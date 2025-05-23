# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

CORES=2
TRANSPILE_TESTS_IN_RUST=1

include ../SharedMakefile.mk

PROJECT_SERVICES := \
	DDBEncryption \
	WrappedDynamoDbItemEncryptor

MAIN_SERVICE_FOR_RUST := DDBEncryption

SMITHY_MODEL_ROOT := $(PROJECT_ROOT)/DynamoDbEncryption/dafny/DynamoDbEncryption/Model
OUTPUT_LOCAL_SERVICE_DDBEncryption := --local-service-test
OUTPUT_LOCAL_SERVICE_WrappedDynamoDbItemEncryptor := --local-service-test

SERVICE_NAMESPACE_DDBEncryption=aws.cryptography.dbEncryptionSdk.dynamoDb
SERVICE_NAMESPACE_WrappedDynamoDbItemEncryptor=aws.cryptography.dbEncryptionSdk.dynamoDb.itemEncryptor

MAX_RESOURCE_COUNT=10000000
# Order is important
# In java they MUST be built
# in the order they depend on each other
PROJECT_DEPENDENCIES := \
	submodules/MaterialProviders/AwsCryptographyPrimitives \
	submodules/MaterialProviders/ComAmazonawsKms \
	submodules/MaterialProviders/ComAmazonawsDynamodb \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders \
	submodules/MaterialProviders/TestVectorsAwsCryptographicMaterialProviders \
	DynamoDbEncryption \


RUST_OTHER_FILES := \
	runtimes/rust/src/aes_gcm.rs \
	runtimes/rust/src/aes_kdf_ctr.rs \
	runtimes/rust/src/ddb.rs \
	runtimes/rust/src/concurrent_call.rs \
	runtimes/rust/src/create_client.rs \
	runtimes/rust/src/create_wrapped_item_encryptor.rs \
	runtimes/rust/src/dafny_libraries.rs \
	runtimes/rust/src/digest.rs \
	runtimes/rust/src/ecdh.rs \
	runtimes/rust/src/ecdsa.rs \
	runtimes/rust/src/hmac.rs \
	runtimes/rust/src/kms.rs \
	runtimes/rust/src/local_cmc.rs \
	runtimes/rust/src/oslang.rs \
	runtimes/rust/src/random.rs \
	runtimes/rust/src/rsa.rs \
	runtimes/rust/src/sets.rs \
	runtimes/rust/src/software_externs.rs \
	runtimes/rust/src/storm_tracker.rs \
	runtimes/rust/src/time.rs \
	runtimes/rust/src/uuid.rs

# Since we are packaging projects differently, we cannot make assumptions
# about where the files are located. 
# This is here to get unblocked but should be removed once we have migrated packages
# to the new packaging format.
PROJECT_INDEX := \
	submodules/MaterialProviders/AwsCryptographyPrimitives/src/Index.dfy \
	submodules/MaterialProviders/ComAmazonawsKms/src/Index.dfy \
	submodules/MaterialProviders/ComAmazonawsDynamodb/src/Index.dfy \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographicMaterialProviders/src/Index.dfy \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographyKeyStore/src/Index.dfy \
	submodules/MaterialProviders/TestVectorsAwsCryptographicMaterialProviders/dafny/KeyVectors/src/Index.dfy \
	DynamoDbEncryption/dafny/StructuredEncryption/src/Index.dfy \
	DynamoDbEncryption/dafny/DynamoDbItemEncryptor/src/Index.dfy \
	DynamoDbEncryption/dafny/DynamoDbEncryptionTransforms/src/Index.dfy \
	DynamoDbEncryption/dafny/DynamoDbEncryption/src/Index.dfy \
	DynamoDbEncryption/dafny/DynamoDbItemEncryptor/src/Index.dfy \
	DynamoDbEncryption/dafny/DynamoDbEncryptionTransforms/src/Index.dfy \

STD_LIBRARY=submodules/MaterialProviders/StandardLibrary
SMITHY_DEPS=submodules/MaterialProviders/model

DIR_STRUCTURE_V2=V2

# Dependencies for each local service
SERVICE_DEPS_DDBEncryption := \
	submodules/MaterialProviders/AwsCryptographyPrimitives \
	submodules/MaterialProviders/ComAmazonawsKms \
	submodules/MaterialProviders/ComAmazonawsDynamodb \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographicMaterialProviders \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographyKeyStore \
	DynamoDbEncryption/dafny/DynamoDbEncryptionTransforms \
	DynamoDbEncryption/dafny/DynamoDbEncryption \
	DynamoDbEncryption/dafny/DynamoDbItemEncryptor \
	DynamoDbEncryption/dafny/StructuredEncryption \
	submodules/MaterialProviders/TestVectorsAwsCryptographicMaterialProviders/dafny/TestVectorsAwsCryptographicMaterialProviders \

SERVICE_DEPS_WrappedDynamoDbItemEncryptor := \
	submodules/MaterialProviders/AwsCryptographyPrimitives \
	submodules/MaterialProviders/ComAmazonawsKms \
	submodules/MaterialProviders/ComAmazonawsDynamodb \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographicMaterialProviders \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographyKeyStore \
	DynamoDbEncryption/dafny/StructuredEncryption \
	DynamoDbEncryption/dafny/DynamoDbEncryption \
	DynamoDbEncryption/dafny/DynamoDbItemEncryptor \
	submodules/MaterialProviders/TestVectorsAwsCryptographicMaterialProviders/dafny/TestVectorsAwsCryptographicMaterialProviders \

transpile_implementation_rust: _remove_wrapped_client_rust

_remove_wrapped_client_rust:
	$(MAKE) _sed_file SED_FILE_PATH="runtimes/rust/src/deps/aws_cryptography_materialProviders.rs" \
SED_BEFORE_STRING=' \#\[cfg(feature = "wrapped-client")\]' SED_AFTER_STRING='\/\/ Removed cfg(feature = "wrapped-client")'

REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_PRIMITIVES=runtimes/rust/src/deps/aws_cryptography_primitives.rs
REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_KEYSTORE=runtimes/rust/src/deps/aws_cryptography_keyStore.rs
REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_DYNAMODB=runtimes/rust/src/deps/aws_cryptography_dbEncryptionSdk_dynamoDb_transforms.rs
REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_DYNAMODB_ITEM_ENCRYPTOR=runtimes/rust/src/deps/aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor.rs
REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_DYNAMODB_STRUCTURED_ENCRYPTION=runtimes/rust/src/deps/aws_cryptography_dbEncryptionSdk_structuredEncryption.rs
REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_FROM_1 = "\#\[cfg(feature = \"wrapped-client\")\]"
REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_FROM_2 := 'pub mod wrapped;'
REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_TO_1 := '\/\/ removed wrapped-client feature using sed;'
REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_TO_2 := '\/\/ removed wrapped module using sed;'

_polymorph_rust: _remove_wrapped_client_rust

_remove_wrapped_client_rust:
	$(MAKE) _sed_file SED_FILE_PATH=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_PRIMITIVES) SED_BEFORE_STRING=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_FROM_1) SED_AFTER_STRING=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_TO_1)
	$(MAKE) _sed_file SED_FILE_PATH=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_PRIMITIVES) SED_BEFORE_STRING=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_FROM_2) SED_AFTER_STRING=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_TO_2)
	$(MAKE) _sed_file SED_FILE_PATH=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_KEYSTORE) SED_BEFORE_STRING=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_FROM_1) SED_AFTER_STRING=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_TO_1)
	$(MAKE) _sed_file SED_FILE_PATH=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_KEYSTORE) SED_BEFORE_STRING=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_FROM_2) SED_AFTER_STRING=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_TO_2)
	$(MAKE) _sed_file SED_FILE_PATH=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_DYNAMODB) SED_BEFORE_STRING=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_FROM_1) SED_AFTER_STRING=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_TO_1)
	$(MAKE) _sed_file SED_FILE_PATH=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_DYNAMODB) SED_BEFORE_STRING=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_FROM_2) SED_AFTER_STRING=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_TO_2)
	$(MAKE) _sed_file SED_FILE_PATH=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_DYNAMODB_STRUCTURED_ENCRYPTION) SED_BEFORE_STRING=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_FROM_1) SED_AFTER_STRING=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_TO_1)
	$(MAKE) _sed_file SED_FILE_PATH=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_DYNAMODB_STRUCTURED_ENCRYPTION) SED_BEFORE_STRING=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_FROM_2) SED_AFTER_STRING=$(REMOVE_WRAPPED_CLIENT_AFTER_POLYMORPH_RUST_TO_2)