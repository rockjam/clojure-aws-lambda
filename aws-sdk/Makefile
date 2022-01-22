.PHONY: test
test:
	clojure -M:test

.PHONY: fmt
fmt:
	clojure -M:fmt

.PHONY: compile
compile:
	mkdir -p classes
	javac --release 11 -d classes src/**/*.java
	clojure -M -e "(binding [*compiler-options* {:direct-linking true}] (compile 'lambdas.hello) (compile 'lambdas.pojo) (compile 'lambdas.s3-event-handler) (compile 'lambdas.s3-image-resize-handler))"

.PHONY: package
package: compile
	clojure -M:package

.PHONY: clean
clean:
	rm -rf classes
	rm -rf target

.PHONY: create-hello-function
create-hello-function:
	aws lambda create-function \
      --function-name aws-sdk-hello \
      --handler lambdas.hello::handler \
      --runtime java11 \
      --architecture arm64 \
      --memory 256 \
      --timeout 10 \
      --role arn:aws:iam::$(aws_account_id):role/lambda-role \
      --zip-file fileb://./target/lambdas-java-aws-sdk.jar

.PHONY: update-hello-function-code
update-hello-function-code:
	aws lambda update-function-code \
      --function-name aws-sdk-hello \
      --zip-file fileb://./target/lambdas-java-aws-sdk.jar

.PHONY: delete-hello-function
delete-hello-function:
	aws lambda delete-function --function-name aws-sdk-hello

.PHONY: create-pojo-function
create-pojo-function:
	aws lambda create-function \
      --function-name aws-sdk-pojo \
      --handler lambdas.pojo::handlepojo \
      --runtime java11 \
      --architecture arm64 \
      --memory 256 \
      --timeout 10 \
      --role arn:aws:iam::$(aws_account_id):role/lambda-role \
      --zip-file fileb://./target/lambdas-java-aws-sdk.jar

.PHONY: update-pojo-function-code
update-pojo-function-code:
	aws lambda update-function-code \
      --function-name aws-sdk-pojo \
      --zip-file fileb://./target/lambdas-java-aws-sdk.jar

.PHONY: delete-pojo-function
delete-pojo-function:
	aws lambda delete-function --function-name aws-sdk-pojo

.PHONY: create-s3-event-function
create-s3-event-function:
	aws lambda create-function \
      --function-name aws-sdk-s3-event \
      --handler lambdas.s3_event_handler \
      --runtime java11 \
      --architecture arm64 \
      --memory 256 \
      --timeout 10 \
      --role arn:aws:iam::$(aws_account_id):role/lambda-role \
      --zip-file fileb://./target/lambdas-java-aws-sdk.jar

.PHONY: update-s3-event-function-code
update-s3-event-function-code:
	aws lambda update-function-code \
      --function-name aws-sdk-s3-event \
      --zip-file fileb://./target/lambdas-java-aws-sdk.jar

.PHONY: delete-s3-event-function
delete-s3-event-function:
	aws lambda delete-function --function-name aws-sdk-s3-event

.PHONY: create-image-resize-function
create-image-resize-function:
	aws lambda create-function \
      --function-name aws-sdk-image-resize \
      --handler lambdas.s3_image_resize_handler \
      --runtime java11 \
      --architecture arm64 \
      --memory 1024 \
      --timeout 60 \
      --role arn:aws:iam::$(aws_account_id):role/lambda-s3-image-resize-role \
      --zip-file fileb://./target/lambdas-java-aws-sdk.jar

.PHONY: update-image-resize-function-code
update-image-resize-function-code:
	aws lambda update-function-code \
      --function-name aws-sdk-image-resize \
      --zip-file fileb://./target/lambdas-java-aws-sdk.jar

.PHONY: delete-image-resize-function
delete-image-resize-function:
	aws lambda delete-function --function-name aws-sdk-image-resize
