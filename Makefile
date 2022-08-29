ROOT_DIR:=$(shell dirname $(realpath $(firstword $(MAKEFILE_LIST))))
DYLD_LIBRARY_PATH=$(DYLD_LIBRARY_PATH)

verify: verify_structured-encryption

verify_structured-encryption:
	$(MAKE) -C src/StructuredEncryption verify

build: build_dotnet

test: test_dotnet

build_dotnet: build_dotnet_structured_encryption

build_dotnet_structured_encryption:
	$(MAKE) -C src/StructuredEncryption build_dotnet

test_dotnet: test_dotnet_structured_encryption

test_dotnet_structured_encryption:
	$(MAKE) -C src/StructuredEncryption test_dotnet

generate_models: generate_models_structured_encryption

generate_models_structured_encryption:
	$(MAKE) -C src/StructuredEncryption generate_models
