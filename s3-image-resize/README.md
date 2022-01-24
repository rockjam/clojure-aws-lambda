# s3-image-resize-function 

Function that resizes source images from source S3 bucket and writes it to destination S3 bucket. 
Following the [tutorial](https://docs.aws.amazon.com/lambda/latest/dg/with-s3-tutorial.html).

Prerequisites:

* AWS CLI installed and configured
* AWS SAM CLI
* Docker(for local testing)

## How To:

### Prepare the function for deploy

```shell
make build
```

### Deploy the function for the first time

```shell
sam deploy --stack-name s3-image-resize-app --guided 
```
and follow the on-screen prompts.

The deploy process will create both source and destination S3 buckets, and will grant necessary read/write access to them.

After deploy process is done, go to AWS console, upload an image to the source bucket. 
It's resized version should soon appear in the destination bucket.

### Deploy function or configuration change

```shell
make deploy
```

### Delete the function and cleanup resources:

```shell
sam delete
```
and follow the on-screen prompts.
