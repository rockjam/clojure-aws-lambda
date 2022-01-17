.PHONY: test
test:
	clojure -M:test

.PHONY: fmt
fmt:
	clojure -M:fmt

.PHONY: compile
compile:
	mkdir -p classes
	clojure -M -e "(binding [*compiler-options* {:direct-linking true}] (compile 'lambdas.hello))"

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
      --zip-file fileb://./target/lambdas-hello.jar
