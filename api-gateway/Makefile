.PHONY: test
test:
	clojure -M:test

.PHONY: fmt
fmt:
	clojure -M:fmt

.PHONY: compile
compile:
	mkdir -p classes
	clojure -X:aot

.PHONY: package
package: compile
	clojure -M:package

.PHONY: clean
clean:
	rm -rf classes
	rm -rf target

.PHONY: create-function
create-function:
	aws lambda create-function \
      --function-name api-gateway-function \
      --handler lambdas.api_gateway_function \
      --runtime java11 \
      --architecture arm64 \
      --memory 256 \
      --timeout 10 \
      --role arn:aws:iam::$(aws_account_id):role/lambda-role \
      --zip-file fileb://./target/api-gateway-function.jar

.PHONY: update-function-code
update-function-code:
	aws lambda update-function-code \
      --function-name api-gateway-function \
      --zip-file fileb://./target/api-gateway-function.jar

.PHONY: delete-function
delete-function:
	aws lambda delete-function --function-name api-gateway-function
