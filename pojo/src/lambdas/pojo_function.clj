(ns lambdas.pojo-function
  (:gen-class
   :methods [[handlepojo [lambdas.MyEvent] String]]))

(defn -handlepojo [this event]
  (str "Hello " (.getFirstName event) " " (.getLastName event)))
