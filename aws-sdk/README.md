# AWS Lambda with Java Lambda SDK 

Based on [AWS tutorial](https://aws.amazon.com/blogs/compute/clojure/) with adjustments for Clojure tools(deps.edn).

One can create AWS Lambda from a JAR file that contains public methods with signatures acceptable by AWS Lambda. 
Package a JAR with all dependencies included(uberjar) and provide it to `aws lambda create-function` command([example](./Makefile#L26-L34)).
So, the similar approach would work for other JVM-based languages, such as Java Kotlin and Scala.

## aws-sdk-hello function

Function that accepts a string and returns a greeting.

**To deploy the function for the first time:**
```shell
make clean package create-hello-function aws_account_id=<your AWS Account ID> 
```

**To test the function:**
* go to the AWS console, select "Lambda" service
* go to "Functions" > select "aws-sdk-hello" function > click "Test" tab
* In the test event editor paste `"rockjam"` and press "Test"

**To update the function code:**
```shell
make clean package update-hello-function-code
```

**To delete the function:**
```shell
make delete-hello-function
```

## aws-sdk-pojo function

Function that accepts custom event described by [MyEvent](src/lambdas/MyEvent.java) Java class and returns a greeting.

**To deploy the function for the first time:**
```shell
make clean package create-pojo-function aws_account_id=<your AWS Account ID> 
```

**To test the function:** 
* go to the AWS console, select "Lambda" service
* go to "Functions" > select "aws-sdk-pojo" function > click "Test" tab
* In the test event editor paste `{"firstName": "rock", "lastName": "jam"}` and press "Test"

**To update the function code:**
```shell
make clean package update-pojo-function-code
```

**To delete the function:**
```shell
make delete-pojo-function
```

## aws-sdk-s3-event function

Function that accepts S3 PUT event and returns a JSON containing details of created S3 object - bucket name and object key.
It can also be invoked by an [S3 trigger](https://docs.aws.amazon.com/lambda/latest/dg/with-s3-example.html#with-s3-example-create-function).

**To deploy the function for the first time:**
```shell
make clean package create-s3-event-function aws_account_id=<your AWS Account ID> 
```

**To test the function:**
* go to the AWS console, select "Lambda" service
* go to "Functions" > select "aws-sdk-s3-event" function > click "Test" tab
* In the test event editor select template `"s3-put"`  and press "Test"

**To update the function code:**
```shell
make clean package update-s3-event-function-code
```

**To delete the function:**
```shell
make delete-s3-event-function
```
