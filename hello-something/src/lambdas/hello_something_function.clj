(ns lambdas.hello-something-function
  (:gen-class
   :methods [^:static [handler [String] String]]))

(defn -handler [s]
  (str "Hello " s "!"))
