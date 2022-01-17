# AWS Lambda with Java Lambda SDK 

Based on [AWS tutorial](https://aws.amazon.com/blogs/compute/clojure/) 

## aws-sdk-hello function

TODO: fill out

## aws-sdk-pojo function

To deploy the function:
```
make clean package create-pojo-function aws_account_id=<AWS Acount ID> 
```

To test the function: 
* go to the AWS console, select "Lambda" service
* go to "Functions" > select "aws-sdk-pojo" function > click "Test" tab
* enter test event `{"firstName": "rock", "lastName": "jam"}` and press "Test"
