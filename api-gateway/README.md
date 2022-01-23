# api-gateway-function

Function that accepts API gateway request and returns "Hello World!" plain text response.

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
sam local start-api
```

This command will start a local HTTP server hosting function endpoint in Docker container. You can call function
with `curl -XGET http://localhost:3000/hello`

### Deploy the function for the first time

```shell
same deploy --guided 
```

and follow the on-screen prompts. 

After deploy process is done, there will be an endpoint to invoke function in
the `Outputs` section. Call this endpoint to test the function.

### Deploy function or configuration change

```shell
make deploy
```

### Delete the function and cleanup resources:

```shell
sam delete
```
