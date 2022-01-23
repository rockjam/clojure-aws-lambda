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

.PHONY: deploy
deploy:
	sam build
	sam deploy

# target used by AWS sam to build and deploy the function
.PHONY: build-ApiGatewayFunction
build-ApiGatewayFunction: package
	mkdir -p $(ARTIFACTS_DIR)/lib
	cp ./target/api-gateway-function.jar $(ARTIFACTS_DIR)/lib/

.PHONY: build-JavaWrapperLayer
build-JavaWrapperLayer:
	cp ./scripts/java-wrapper.sh $(ARTIFACTS_DIR)
