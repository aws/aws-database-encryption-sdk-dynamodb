ROOT_DIR:=$(shell dirname $(realpath $(firstword $(MAKEFILE_LIST))))
DYLD_LIBRARY_PATH=$(DYLD_LIBRARY_PATH)

build:
	cd src/StructuredEncryption/src;\
	dotnet build

test: build
	cd src/StructuredEncryption/runtimes/net;\
	dotnet test -f netcoreapp3.1 Test

generate-models:
	cd polymorph/smithy-dotnet;\
	./gradlew run --args="\
	-m $(ROOT_DIR)/src/StructuredEncryption/Model \
	-namespace aws.cryptography.structuredEncryption \
	--output-dotnet $(ROOT_DIR)/src/StructuredEncryption/runtimes/net/Generated \
	-d $(ROOT_DIR)/private-aws-encryption-sdk-dafny-staging/src/AwsCryptographicMaterialProviders/Model \
	-d $(ROOT_DIR)/private-aws-encryption-sdk-dafny-staging/src/Crypto/Model \
	-d $(ROOT_DIR)/private-aws-encryption-sdk-dafny-staging/src/AWS-KMS/Model \
	-d $(ROOT_DIR)/private-aws-encryption-sdk-dafny-staging/model"