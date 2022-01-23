(ns lambdas.api-gateway-function
  (:gen-class
   :implements [com.amazonaws.services.lambda.runtime.RequestStreamHandler])
  (:require [clojure.data.json :as json]
            [clojure.string :as str]
            [clojure.java.io :as io]))

(defn handle-event [event]
  {:statusCode 200
   :headers    {"content-type" "text/plain; charset=utf-8"}
   :body       "Hello World!"})

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

