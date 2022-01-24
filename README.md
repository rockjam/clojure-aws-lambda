# AWS Lambda exercise with Clojure

Examples are based on [AWS Lambda tutorial](https://aws.amazon.com/blogs/compute/clojure/) for Clojure with adjustments for Clojure tools(deps.edn)
and addition of [AWS SAM](https://aws.amazon.com/serverless/sam/) configuration for convenience of resource management and future updates.

* [hello-something](./hello-something) - simple greeting function;
* [pojo](./pojo) - function that accepts Java [POJO](https://en.wikipedia.org/wiki/Plain_old_Java_object) as input; 
* [api-gateway](./api-gateway) - simple greeting function called via API Gateway;
* [s3-image-resize](./s3-image-resize) - function that reads and writes to S3 bucket to make an image resize.

In short, AWS Lambda can be created from a JAR that has public classes with suitable interface. 
Package a JAR with all dependencies included(uberjar) and use it to create AWS Lambda.
Similar approach works for other JVM-based languages, such as Java, Kotlin and Scala.
