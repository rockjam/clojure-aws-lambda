(ns lambdas.s3-event-handler
  (:gen-class
    :implements [com.amazonaws.services.lambda.runtime.RequestStreamHandler])
  (:require [clojure.data.json :as json]
            [clojure.string :as str]
            [clojure.java.io :as io])
  (:import (java.net URLDecoder)))

(defn handle-event [event]
  (let [s3-data (get-in event [:records 0 :s3])
        response {:bucket-name (get-in s3-data [:bucket :name])
                  :object-key  (. URLDecoder (decode (get-in s3-data [:object :key]) "UTF-8"))}]
    (do
      (println "response: " (json/write-str response :indent true))
      response)))

(defn key->keyword [key-string]
  (-> key-string
      (str/replace #"([a-z])([A-Z])" "$1-$2")
      (str/replace #"([A-Z]+)([A-Z])" "$1-$2")
      (str/lower-case)
      (keyword)))

(defn -handleRequest [this is os context]
  (let [w (io/writer os)]
    (-> (json/read (io/reader is) :key-fn key->keyword)
        (handle-event)
        (json/write w))
    (.flush w)))

