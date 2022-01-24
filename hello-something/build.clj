(ns build)

(defn aot [& args] (compile 'lambdas.hello-something-function))
