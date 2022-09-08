ROOT_DIR:=$(shell dirname $(realpath $(firstword $(MAKEFILE_LIST))))
DYLD_LIBRARY_PATH=$(DYLD_LIBRARY_PATH)

generate_models:
	cd ../../polymorph/smithy-dotnet;\
	./gradlew run --args="\
	-m $(ROOT_DIR)/Model \
	--aws-sdk \
	-namespace com.amazonaws.dynamodb \
	--output-dotnet $(ROOT_DIR)/runtimes/net/Generated \
	-d $(ROOT_DIR)/../../private-aws-encryption-sdk-dafny-staging/src/AWS-KMS/Model"
