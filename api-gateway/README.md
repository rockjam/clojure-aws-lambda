## api-gateway-function

Function that accepts API gateway request and responds with "Hello World!"

**To deploy the function for the first time:**
```shell
make clean package create-function aws_account_id=<your AWS Account ID> 
```

**To test the function:**
* go to the AWS console, select "Lambda" service
* go to "Functions" > select "api-gateway-function" function > click "Test" tab
* In the test event editor select template `"api-gateway-aws-proxy"`  and press "Test"

**To update the function code:**
```shell
make clean package update-function-code
```

**To delete the function:**
```shell
make delete-function
```
