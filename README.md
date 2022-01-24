# AWS Lambda exercise with Clojure

Examples of AWS Lambdas written in Clojure:
* 

Examples are based on [AWS Clojure tutorial](https://aws.amazon.com/blogs/compute/clojure/) with adjustments for Clojure tools(deps.edn) 
with addition of AWS SAM configuration for convenience of resource management and future updates.

AWS Lambda can be created from a JAR that has public classes with suitable interface. 
Package a JAR with all dependencies included(uberjar) and use it to create Lambda.
Similar approach would work for other JVM-based languages, such as Java, Kotlin and Scala.
