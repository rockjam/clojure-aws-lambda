# hello-something-function 

Function that accepts a string and returns a greeting string.

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
 echo '"Nick"' | sam local invoke --event -
```

This command should print `"Hello Nick!"` in the terminal

### Deploy the function for the first time

```shell
sam deploy --stack-name hello-something-app --guided 
```
and follow the on-screen prompts.

After deploy process is done, invoke a function with
```shell
aws lambda invoke --function-name hello-something-function --payload '"Nick"' result.json
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
