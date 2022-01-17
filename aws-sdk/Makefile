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
	clojure -M -e "(binding [*compiler-options* {:direct-linking true}] (compile 'lambdas.hello) (compile 'lambdas.pojo))"

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

.PHONY: delete-pojo-function
delete-pojo-function:
	aws lambda delete-function --function-name aws-sdk-pojo
