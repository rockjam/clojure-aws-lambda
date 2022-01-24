(ns lambdas.s3-image-resize-function
  (:gen-class
   :implements [com.amazonaws.services.lambda.runtime.RequestStreamHandler]
   :init init
   :state state)
  (:require [clojure.data.json :as json]
            [clojure.string :as str]
            [clojure.java.io :as io]
            [cognitect.aws.client.api :as aws]
            [image-resizer.resize :refer :all]
            [image-resizer.format :as format])
  (:import (java.net URLDecoder)))

(defn -init []
  (println "in init")
  [[] {:s3-client (aws/client {:api :s3})}])

(def max-width 100)
(def max-height 100)

(defn parse-s3-event [event]
  (let [s3-data (get-in event [:records 0 :s3])]
    {:bucket (get-in s3-data [:bucket :name])
     :key    (. URLDecoder (decode (get-in s3-data [:object :key]) "UTF-8"))}))

(defn handle-event [event this]
  (let [{source-bucket :bucket key :key} (parse-s3-event event)
        resized-bucket (str source-bucket "-resized")
        s3-client (:s3-client (.state this))]
    (do
      (aws/validate-requests s3-client true)
      (println "resizing:" source-bucket "/" key)
      (let [get-response (aws/invoke s3-client {:op :GetObject :request {:Bucket source-bucket :Key key}})
            content-type (:ContentType get-response)]
        (with-open [reader (io/input-stream (:Body get-response))
                    writer (format/as-stream-by-mime-type ((resize-fn max-width max-height) reader) content-type)]
          (aws/invoke s3-client {:op :PutObject :request {:Bucket resized-bucket :Key key :Body writer}})))
      {:response "ok"})))

(defn key->keyword [key-string]
  (-> key-string
      (str/replace #"([a-z])([A-Z])" "$1-$2")
      (str/replace #"([A-Z]+)([A-Z])" "$1-$2")
      (str/lower-case)
      (keyword)))

(defn -handleRequest [this is os context]
  (let [w (io/writer os)]
    (-> (json/read (io/reader is) :key-fn key->keyword)
        (handle-event this)
        (json/write w))
    (.flush w)))

