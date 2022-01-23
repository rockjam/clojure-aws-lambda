(ns build)

(defn aot [& args] (compile 'lambdas.api-gateway-function))
