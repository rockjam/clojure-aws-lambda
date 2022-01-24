# AWS Lambda exercise with Clojure

Examples are based on [AWS Clojure tutorial](https://aws.amazon.com/blogs/compute/clojure/) with adjustments for Clojure tools(deps.edn)
with addition of AWS SAM configuration for convenience of resource management and future updates.

* [hello-something](./hello-something) - simple greeting function;
* [pojo](./pojo) - function that accepts Java [POJO](https://en.wikipedia.org/wiki/Plain_old_Java_object) as input; 
* [api-gateway](./api-gateway) - simple greeting function called via API Gateway;
* [s3-image-resize](./s3-image-resize) - function that reads and writes to S3 bucket to make an image resize.

AWS Lambda can be created from a JAR that has public classes with suitable interface. 
Package a JAR with all dependencies included(uberjar) and use it to create Lambda.
Similar approach would work for other JVM-based languages, such as Java, Kotlin and Scala.
