# pojo-function 

Function that accepts custom event described by [MyEvent](src/lambdas/MyEvent.java) Java class and returns a greeting.

Prerequisites:

* AWS CLI installed and configured
* AWS SAM CLI
* Docker(for local testing)

## How To:

### Prepare the function for deploy

```shell
make build
```

### Test the function locally

```shell
echo '{"firstName": "rock", "lastName": "jam"}' | sam local invoke --event -
```

This command should print `"Hello rock jam"` in the terminal

### Deploy the function for the first time

```shell
sam deploy --stack-name pojo-app --guided 
```
and follow the on-screen prompts.

After deploy process is done, invoke a function with
```shell
aws lambda invoke --function-name pojo-function --payload '{"firstName": "rock", "lastName": "jam"}' result.json
```

The function result will be in `result.json` file.

### Deploy function or configuration change

```shell
make deploy
```

### Delete the function and cleanup resources:

```shell
sam delete
```
and follow the on-screen prompts.
