ROOT_DIR:=$(shell dirname $(realpath $(firstword $(MAKEFILE_LIST))))
DYLD_LIBRARY_PATH=$(DYLD_LIBRARY_PATH)

####
# Build Targets
####

build: build_dotnet

build_dotnet: build_dotnet_structured_encryption build_dotnet_ddb_encryption

build_dotnet_structured_encryption:
	$(MAKE) -C src/StructuredEncryption build_dotnet

build_dotnet_ddb_encryption:
	$(MAKE) -C src/DynamoDBEncryption build_dotnet

####
# Clean Targets
####

clean: clean_dotnet_structured_encryption clean_dotnet_ddb_encryption

clean_dotnet_structured_encryption:
	$(MAKE) -C src/StructuredEncryption clean

clean_dotnet_ddb_encryption:
	$(MAKE) -C src/DynamoDBEncryption clean

####
# Verify Targets
####

verify: verify_structured_encryption verify_ddb_encryption

verify_structured_encryption:
	$(MAKE) -C src/StructuredEncryption verify

verify_ddb_encryption:
	$(MAKE) -C src/DynamoDBEncryption verify

####
# Test Targets
####

test: test_dotnet

test_dotnet: test_dotnet_structured_encryption test_dotnet_ddb_encryption

test_dotnet_structured_encryption:
	$(MAKE) -C src/StructuredEncryption test_dotnet

test_dotnet_ddb_encryption:
	$(MAKE) -C src/DynamoDBEncryption test_dotnet

####
# Generate Models Targets
####

generate_models: generate_models_structured_encryption generate_models_ddb_encryption generate_models_aws_ddb

generate_models_structured_encryption:
	$(MAKE) -C src/StructuredEncryption generate_models

generate_models_ddb_encryption:
	$(MAKE) -C src/DynamoDBEncryption generate_models

generate_models_aws_ddb:
	$(MAKE) -C src/AWS-DDB generate_models
