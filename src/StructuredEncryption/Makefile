ROOT_DIR:=$(shell dirname $(realpath $(firstword $(MAKEFILE_LIST))))
DYLD_LIBRARY_PATH=$(DYLD_LIBRARY_PATH)

verify:
	cd runtimes/net;\
	dotnet build -t:VerifyDafny Test

build: build_dotnet

clean: clean_dotnet_build clean_dotnet_test

test: test_dotnet

# TODO cleanup CS0618 warning in MPL
build_dotnet:
	cd src;\
	dotnet build /nowarn:CS0618

clean_dotnet_build:
	cd src;\
	dotnet clean

clean_dotnet_test:
	cd runtimes/net;\
	dotnet clean test

# TODO cleanup CS0618 warning in MPL
test_dotnet:
	cd runtimes/net;\
	dotnet test Test /nowarn:CS0618

generate_models:
	cd ../../polymorph/smithy-dotnet;\
	./gradlew run --args="\
	-m $(ROOT_DIR)/Model \
	-namespace aws.cryptography.structuredEncryption \
	--output-dotnet $(ROOT_DIR)/runtimes/net/Generated \
	-d $(ROOT_DIR)/../../private-aws-encryption-sdk-dafny-staging/src/AwsCryptographicMaterialProviders/Model \
	-d $(ROOT_DIR)/../../private-aws-encryption-sdk-dafny-staging/src/Crypto/Model \
	-d $(ROOT_DIR)/../../private-aws-encryption-sdk-dafny-staging/src/AWS-KMS/Model \
	-d $(ROOT_DIR)/../../private-aws-encryption-sdk-dafny-staging/model"
