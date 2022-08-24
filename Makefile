ROOT_DIR:=$(shell dirname $(realpath $(firstword $(MAKEFILE_LIST))))
DYLD_LIBRARY_PATH=$(DYLD_LIBRARY_PATH)

verify:
	cd src/StructuredEncryption/src;\
	dotnet build -t:VerifyDafny

build: build-dotnet

test: test-dotnet

# TODO cleanup CS0618 warning in MPL
build-dotnet:
	cd src/StructuredEncryption/src;\
	dotnet build /nowarn:CS0618

# TODO cleanup CS0618 warning in MPL
test-dotnet:
	cd src/StructuredEncryption/runtimes/net;\
	dotnet test -f netcoreapp3.1 Test /nowarn:CS0618

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