# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

CORES=2
ENABLE_EXTERN_PROCESSING=1
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

# Python

PYTHON_MODULE_NAME=aws_dbesdk_dynamodb_test_vectors

TRANSLATION_RECORD_PYTHON := \
    --translation-record ../submodules/MaterialProviders/StandardLibrary/runtimes/python/src/smithy_dafny_standard_library/internaldafny/generated/dafny_src-py.dtr \
    --translation-record ../submodules/MaterialProviders/ComAmazonawsKms/runtimes/python/src/aws_cryptography_internal_kms/internaldafny/generated/dafny_src-py.dtr \
    --translation-record ../submodules/MaterialProviders/ComAmazonawsDynamodb/runtimes/python/src/aws_cryptography_internal_dynamodb/internaldafny/generated/dafny_src-py.dtr \
    --translation-record ../submodules/MaterialProviders/AwsCryptographyPrimitives/runtimes/python/src/aws_cryptography_primitives/internaldafny/generated/dafny_src-py.dtr \
	--translation-record ../submodules/MaterialProviders/AwsCryptographicMaterialProviders/runtimes/python/src/aws_cryptographic_material_providers/internaldafny/generated/dafny_src-py.dtr \
	--translation-record ../submodules/MaterialProviders/TestVectorsAwsCryptographicMaterialProviders/runtimes/python/src/aws_cryptography_materialproviders_test_vectors/internaldafny/generated/dafny_src-py.dtr \
	--translation-record ../DynamoDbEncryption/runtimes/python/src/aws_dbesdk_dynamodb/internaldafny/generated/dafny_src-py.dtr

PYTHON_DEPENDENCY_MODULE_NAMES := \
	--dependency-library-name=aws.cryptography.primitives=aws_cryptography_primitives \
	--dependency-library-name=com.amazonaws.kms=aws_cryptography_internal_kms \
	--dependency-library-name=com.amazonaws.dynamodb=aws_cryptography_internal_dynamodb \
	--dependency-library-name=aws.cryptography.materialProviders=aws_cryptographic_material_providers \
	--dependency-library-name=aws.cryptography.keyStore=aws_cryptographic_material_providers \
	--dependency-library-name=aws.cryptography.materialProvidersTestVectorKeys=aws_cryptography_materialproviders_test_vectors \
	--dependency-library-name=aws.cryptography.dbEncryptionSdk.structuredEncryption=aws_dbesdk_dynamodb \
	--dependency-library-name=aws.cryptography.dbEncryptionSdk.dynamoDb=aws_dbesdk_dynamodb \
	--dependency-library-name=aws.cryptography.dbEncryptionSdk.dynamoDb.itemEncryptor=aws_dbesdk_dynamodb \
	--dependency-library-name=aws.cryptography.dbEncryptionSdk.dynamoDb.transforms=aws_dbesdk_dynamodb \

# Constants for languages that drop extern names (Python, Go)

INDEX_FILE_PATH=dafny/DDBEncryption/src/LibraryIndex.dfy
INDEX_FILE_WITH_EXTERN_STRING="module {:extern \"software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.wrapped\"} WrappedDynamoDbEncryption refines WrappedAbstractAwsCryptographyDynamoDbEncryptionService"
INDEX_FILE_WITHOUT_EXTERN_STRING="module WrappedDynamoDbEncryption refines WrappedAbstractAwsCryptographyDynamoDbEncryptionService"

ITEMENCRYPTOR_INDEX_FILE_PATH=dafny/WrappedDynamoDbItemEncryptor/src/Index.dfy
ITEMENCRYPTOR_INDEX_FILE_WITH_EXTERN_STRING="module {:extern \"software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.wrapped\" } WrappedItemEncryptor refines WrappedAbstractAwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorService {"
ITEMENCRYPTOR_INDEX_FILE_WITHOUT_EXTERN_STRING="module WrappedItemEncryptor refines WrappedAbstractAwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorService {"

_sed_index_file_add_extern:
	$(MAKE) _sed_file SED_FILE_PATH=$(INDEX_FILE_PATH) SED_BEFORE_STRING=$(INDEX_FILE_WITHOUT_EXTERN_STRING) SED_AFTER_STRING=$(INDEX_FILE_WITH_EXTERN_STRING)
	$(MAKE) _sed_file SED_FILE_PATH=$(ITEMENCRYPTOR_INDEX_FILE_PATH) SED_BEFORE_STRING=$(ITEMENCRYPTOR_INDEX_FILE_WITHOUT_EXTERN_STRING) SED_AFTER_STRING=$(ITEMENCRYPTOR_INDEX_FILE_WITH_EXTERN_STRING)

_sed_index_file_remove_extern:
	$(MAKE) _sed_file SED_FILE_PATH=$(INDEX_FILE_PATH) SED_BEFORE_STRING=$(INDEX_FILE_WITH_EXTERN_STRING) SED_AFTER_STRING=$(INDEX_FILE_WITHOUT_EXTERN_STRING)
	$(MAKE) _sed_file SED_FILE_PATH=$(ITEMENCRYPTOR_INDEX_FILE_PATH) SED_BEFORE_STRING=$(ITEMENCRYPTOR_INDEX_FILE_WITH_EXTERN_STRING) SED_AFTER_STRING=$(ITEMENCRYPTOR_INDEX_FILE_WITHOUT_EXTERN_STRING)

_sed_types_file_remove_extern:
	echo "no types file"

_sed_types_file_add_extern:
	echo "no types file"

test_python_client_interface:
	rm -rf runtimes/python/.tox
	python3 -m tox -c runtimes/python -e client

test_python_resource_interface:
	rm -rf runtimes/python/.tox
	python3 -m tox -c runtimes/python -e resource

test_python_table_interface:
	rm -rf runtimes/python/.tox
	python3 -m tox -c runtimes/python -e table
