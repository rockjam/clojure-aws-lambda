# AWS Lambda with Java Lambda SDK 

Based on [AWS tutorial](https://aws.amazon.com/blogs/compute/clojure/) 
AWS Lambda accepts JAR files. So it's enough to package a jar with all deps, and create a Lambda function with it.
the method should be publically accessible in the JAR.

## aws-sdk-hello function

TODO: fill out

## aws-sdk-pojo function

To deploy the function:
```
make clean package create-pojo-function aws_account_id=<AWS Account ID> 
```

To test the function: 
* go to the AWS console, select "Lambda" service
* go to "Functions" > select "aws-sdk-pojo" function > click "Test" tab
* enter test event `{"firstName": "rock", "lastName": "jam"}` and press "Test"

To update the code:

## aws-sdk-s3-event function

