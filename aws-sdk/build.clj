(ns build)

(defn aot [& args]
  (do
    (compile 'lambdas.hello)
    (compile 'lambdas.pojo)
    (compile 'lambdas.s3-event-handler)
    (compile 'lambdas.s3-image-resize-handler)
    (compile 'lambdas.api-gateway-handler))
  )
