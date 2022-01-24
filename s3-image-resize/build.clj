(ns build)

(defn aot [& args] (compile 'lambdas.s3-image-resize-function))
