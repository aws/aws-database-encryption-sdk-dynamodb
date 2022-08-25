ROOT_DIR:=$(shell dirname $(realpath $(firstword $(MAKEFILE_LIST))))
DYLD_LIBRARY_PATH=$(DYLD_LIBRARY_PATH)

verify: verify_structured-encryption

verify_structured-encryption:
	$(MAKE) -C src/StructuredEncryption verify

build: build_dotnet

test: test_dotnet

build_dotnet: build_dotnet_structured-encryption

build_dotnet_structured-encryption:
	$(MAKE) -C src/StructuredEncryption build_dotnet

test_dotnet: test_dotnet_structured-encryption

test_dotnet_structured-encryption:
	$(MAKE) -C src/StructuredEncryption test_dotnet

generate-models: generate-models_structured-encryption

generate-models_structured-encryption:
	$(MAKE) -C src/StructuredEncryption generate-models
