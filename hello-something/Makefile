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

.PHONY: build
build:
	sam build

.PHONY: deploy
deploy: build
	sam deploy

# target used by AWS SAM to build and deploy the function
.PHONY: build-HelloSomethingFunction
build-HelloSomethingFunction: package
	mkdir -p $(ARTIFACTS_DIR)/lib
	cp ./target/hello-something-function.jar $(ARTIFACTS_DIR)/lib/

# target used by AWS SAM to build and deploy java wrapper layer
.PHONY: build-JavaWrapperLayer
build-JavaWrapperLayer:
	cp ./scripts/java-wrapper.sh $(ARTIFACTS_DIR)
