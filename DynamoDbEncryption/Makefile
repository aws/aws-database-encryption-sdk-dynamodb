# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

CORES=2

TRANSPILE_TESTS_IN_RUST=1
ENABLE_EXTERN_PROCESSING=1

include ../SharedMakefile.mk

DIR_STRUCTURE_V2=V2

PROJECT_SERVICES := \
	DynamoDbEncryption \
	DynamoDbItemEncryptor \
	DynamoDbEncryptionTransforms \
	StructuredEncryption

MAIN_SERVICE_FOR_RUST := DynamoDbEncryptionTransforms

RUST_OTHER_FILES := \
	runtimes/rust/src/aes_gcm.rs \
	runtimes/rust/src/aes_kdf_ctr.rs \
	runtimes/rust/src/ddb.rs \
	runtimes/rust/src/concurrent_call.rs \
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

# Namespace for each local service
# Currently our build relies on local services and namespaces being 1:1
SERVICE_NAMESPACE_StructuredEncryption=aws.cryptography.dbEncryptionSdk.structuredEncryption
SERVICE_NAMESPACE_DynamoDbEncryption=aws.cryptography.dbEncryptionSdk.dynamoDb
SERVICE_NAMESPACE_DynamoDbItemEncryptor=aws.cryptography.dbEncryptionSdk.dynamoDb.itemEncryptor
SERVICE_NAMESPACE_DynamoDbEncryptionTransforms=aws.cryptography.dbEncryptionSdk.dynamoDb.transforms

MAX_RESOURCE_COUNT=20000000
# Order is important
# In java they MUST be built
# in the order they depend on each other
PROJECT_DEPENDENCIES := \
	submodules/MaterialProviders/AwsCryptographyPrimitives \
	submodules/MaterialProviders/ComAmazonawsKms \
	submodules/MaterialProviders/ComAmazonawsDynamodb \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders
STD_LIBRARY=submodules/MaterialProviders/StandardLibrary
SMITHY_DEPS=submodules/MaterialProviders/model

# Since we are packaging projects differently, we cannot make assumptions
# about where the files are located. 
# This is here to get unblocked but should be removed once we have migrated packages
# to the new packaging format.
PROJECT_INDEX := \
	submodules/MaterialProviders/AwsCryptographyPrimitives/src/Index.dfy \
	submodules/MaterialProviders/ComAmazonawsKms/src/Index.dfy \
	submodules/MaterialProviders/ComAmazonawsDynamodb/src/Index.dfy \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographicMaterialProviders/src/Index.dfy \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographyKeyStore/src/Index.dfy

# Dependencies for each local service
SERVICE_DEPS_StructuredEncryption := \
	submodules/MaterialProviders/AwsCryptographyPrimitives \
	submodules/MaterialProviders/ComAmazonawsKms \
	submodules/MaterialProviders/ComAmazonawsDynamodb \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographicMaterialProviders \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographyKeyStore
SERVICE_DEPS_DynamoDbEncryption := \
	submodules/MaterialProviders/AwsCryptographyPrimitives \
	submodules/MaterialProviders/ComAmazonawsKms \
	submodules/MaterialProviders/ComAmazonawsDynamodb \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographicMaterialProviders \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographyKeyStore \
	DynamoDbEncryption/dafny/StructuredEncryption
SERVICE_DEPS_DynamoDbItemEncryptor := \
	submodules/MaterialProviders/AwsCryptographyPrimitives \
	submodules/MaterialProviders/ComAmazonawsKms \
	submodules/MaterialProviders/ComAmazonawsDynamodb \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographicMaterialProviders \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographyKeyStore \
	DynamoDbEncryption/dafny/DynamoDbEncryption \
	DynamoDbEncryption/dafny/StructuredEncryption
SERVICE_DEPS_DynamoDbEncryptionTransforms := \
	submodules/MaterialProviders/AwsCryptographyPrimitives \
	submodules/MaterialProviders/ComAmazonawsKms \
	submodules/MaterialProviders/ComAmazonawsDynamodb \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographicMaterialProviders \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographyKeyStore \
	DynamoDbEncryption/dafny/DynamoDbEncryption \
	DynamoDbEncryption/dafny/StructuredEncryption \
	DynamoDbEncryption/dafny/DynamoDbItemEncryptor

# Go
# TODO-Go-ORR: Define the name later https://sim.amazon.com/issues/CrypTool-5444
# This will probably get changes to */releases/go/* but I will bring this to the team later.
GO_MODULE_NAME="github.com/aws/aws-database-encryption-sdk-dynamodb"

GO_DEPENDENCY_MODULE_NAMES := \
	--dependency-library-name=aws.cryptography.primitives=github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives \
	--dependency-library-name=com.amazonaws.kms=github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms \
	--dependency-library-name=com.amazonaws.dynamodb=github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb \
	--dependency-library-name=aws.cryptography.materialProviders=github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl \
	--dependency-library-name=aws.cryptography.keyStore=github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl \
	--dependency-library-name=sdk.com.amazonaws.dynamodb=github.com/aws/aws-sdk-go-v2/service/dynamodb \
	--dependency-library-name=sdk.com.amazonaws.kms=github.com/aws/aws-sdk-go-v2/service/kms \
	--dependency-library-name=aws.cryptography.dbEncryptionSdk.structuredEncryption=github.com/aws/aws-database-encryption-sdk-dynamodb \
	--dependency-library-name=aws.cryptography.dbEncryptionSdk.dynamoDb=github.com/aws/aws-database-encryption-sdk-dynamodb \
	--dependency-library-name=aws.cryptography.dbEncryptionSdk.dynamoDb.itemEncryptor=github.com/aws/aws-database-encryption-sdk-dynamodb \
	--dependency-library-name=aws.cryptography.dbEncryptionSdk.dynamoDb.transforms=github.com/aws/aws-database-encryption-sdk-dynamodb
	
TRANSLATION_RECORD_GO := \
    submodules/MaterialProviders/StandardLibrary/runtimes/go/ImplementationFromDafny-go/ImplementationFromDafny-go.dtr \
    submodules/MaterialProviders/ComAmazonawsKms/runtimes/go/ImplementationFromDafny-go/ImplementationFromDafny-go.dtr \
    submodules/MaterialProviders/ComAmazonawsDynamodb/runtimes/go/ImplementationFromDafny-go/ImplementationFromDafny-go.dtr \
    submodules/MaterialProviders/AwsCryptographyPrimitives/runtimes/go/ImplementationFromDafny-go/ImplementationFromDafny-go.dtr \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders/runtimes/go/ImplementationFromDafny-go/ImplementationFromDafny-go.dtr

# Constants for languages that drop extern names (Python, Go)

DYNAMODB_TYPES_FILE_PATH=dafny/DynamoDbEncryption/Model/AwsCryptographyDbEncryptionSdkDynamoDbTypes.dfy
DYNAMODB_TYPES_FILE_WITH_EXTERN_STRING="module {:extern \"software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types\" } AwsCryptographyDbEncryptionSdkDynamoDbTypes"
DYNAMODB_TYPES_FILE_WITHOUT_EXTERN_STRING="module AwsCryptographyDbEncryptionSdkDynamoDbTypes"

DYNAMODB_INDEX_FILE_PATH=dafny/DynamoDbEncryption/src/Index.dfy
DYNAMODB_INDEX_FILE_WITH_EXTERN_STRING="module {:extern \"software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny\" } DynamoDbEncryption"
DYNAMODB_INDEX_FILE_WITHOUT_EXTERN_STRING="module DynamoDbEncryption"

ITEMENCRYPTOR_TYPES_FILE_PATH=dafny/DynamoDbItemEncryptor/Model/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.dfy
ITEMENCRYPTOR_TYPES_FILE_WITH_EXTERN_STRING="module {:extern \"software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types\" } AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes"
ITEMENCRYPTOR_TYPES_FILE_WITHOUT_EXTERN_STRING="module AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes"

ITEMENCRYPTOR_INDEX_FILE_PATH=dafny/DynamoDbItemEncryptor/src/Index.dfy
ITEMENCRYPTOR_INDEX_FILE_WITH_EXTERN_STRING="module {:extern \"software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny\" } DynamoDbItemEncryptor"
ITEMENCRYPTOR_INDEX_FILE_WITHOUT_EXTERN_STRING="module DynamoDbItemEncryptor"

ITEMENCRYPTOR_LEGACY_FILE_PATH=dafny/DynamoDbItemEncryptor/src/InternalLegacyOverride.dfy
ITEMENCRYPTOR_LEGACY_FILE_WITH_EXTERN_STRING="module {:extern \"software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.legacy\"} InternalLegacyOverride {"
ITEMENCRYPTOR_LEGACY_FILE_WITHOUT_EXTERN_STRING="module InternalLegacyOverride {"

TRANSFORMS_TYPES_FILE_PATH=dafny/DynamoDbEncryptionTransforms/Model/AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.dfy
TRANSFORMS_TYPES_FILE_WITH_EXTERN_STRING="module {:extern \"software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types\" } AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes"
TRANSFORMS_TYPES_FILE_WITHOUT_EXTERN_STRING="module AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes"

TRANSFORMS_INDEX_FILE_PATH=dafny/DynamoDbEncryptionTransforms/src/Index.dfy
TRANSFORMS_INDEX_FILE_WITH_EXTERN_STRING="module {:extern \"software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny\" } DynamoDbEncryptionTransforms"
TRANSFORMS_INDEX_FILE_WITHOUT_EXTERN_STRING="module DynamoDbEncryptionTransforms"

STRUCTUREDENCRYPTION_TYPES_FILE_PATH=dafny/StructuredEncryption/Model/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.dfy
STRUCTUREDENCRYPTION_TYPES_FILE_WITH_EXTERN_STRING="module {:extern \"software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types\" } AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
STRUCTUREDENCRYPTION_TYPES_FILE_WITHOUT_EXTERN_STRING="module AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"

STRUCTUREDENCRYPTION_INDEX_FILE_PATH=dafny/StructuredEncryption/src/Index.dfy
STRUCTUREDENCRYPTION_INDEX_FILE_WITH_EXTERN_STRING="module {:extern \"software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny\" } StructuredEncryption"
STRUCTUREDENCRYPTION_INDEX_FILE_WITHOUT_EXTERN_STRING="module StructuredEncryption"

# Target to restore all directories in a list
# remove this once we don't copy all of the directories into implementation and test. https://sim.amazon.com/issues/0371eaa5-61b5-490c-ad0b-927b6dc4d2d2
RESTORE_DIRS := README.md
_polymorph_go: restore_directories
restore_directories:
	@for dir in $(RESTORE_DIRS); do \
		if [ -d "runtimes/go/ImplementationFromDafny-go/$$dir" ]; then \
			cp -Rf runtimes/go/ImplementationFromDafny-go/$$dir runtimes/go/; \
			rm -rf runtimes/go/ImplementationFromDafny-go/$$dir; \
			rm -rf runtimes/go/TestsFromDafny-go/$$dir; \
		else \
			echo "Directory $$dir not found"; \
		fi \
	done

_sed_types_file_remove_extern:
	$(MAKE) _sed_file SED_FILE_PATH=$(DYNAMODB_TYPES_FILE_PATH) SED_BEFORE_STRING=$(DYNAMODB_TYPES_FILE_WITH_EXTERN_STRING) SED_AFTER_STRING=$(DYNAMODB_TYPES_FILE_WITHOUT_EXTERN_STRING)
	$(MAKE) _sed_file SED_FILE_PATH=$(ITEMENCRYPTOR_TYPES_FILE_PATH) SED_BEFORE_STRING=$(ITEMENCRYPTOR_TYPES_FILE_WITH_EXTERN_STRING) SED_AFTER_STRING=$(ITEMENCRYPTOR_TYPES_FILE_WITHOUT_EXTERN_STRING)
	$(MAKE) _sed_file SED_FILE_PATH=$(TRANSFORMS_TYPES_FILE_PATH) SED_BEFORE_STRING=$(TRANSFORMS_TYPES_FILE_WITH_EXTERN_STRING) SED_AFTER_STRING=$(TRANSFORMS_TYPES_FILE_WITHOUT_EXTERN_STRING)
	$(MAKE) _sed_file SED_FILE_PATH=$(STRUCTUREDENCRYPTION_TYPES_FILE_PATH) SED_BEFORE_STRING=$(STRUCTUREDENCRYPTION_TYPES_FILE_WITH_EXTERN_STRING) SED_AFTER_STRING=$(STRUCTUREDENCRYPTION_TYPES_FILE_WITHOUT_EXTERN_STRING)

_sed_index_file_remove_extern:
	$(MAKE) _sed_file SED_FILE_PATH=$(DYNAMODB_INDEX_FILE_PATH) SED_BEFORE_STRING=$(DYNAMODB_INDEX_FILE_WITH_EXTERN_STRING) SED_AFTER_STRING=$(DYNAMODB_INDEX_FILE_WITHOUT_EXTERN_STRING)
	$(MAKE) _sed_file SED_FILE_PATH=$(ITEMENCRYPTOR_INDEX_FILE_PATH) SED_BEFORE_STRING=$(ITEMENCRYPTOR_INDEX_FILE_WITH_EXTERN_STRING) SED_AFTER_STRING=$(ITEMENCRYPTOR_INDEX_FILE_WITHOUT_EXTERN_STRING)
	$(MAKE) _sed_file SED_FILE_PATH=$(ITEMENCRYPTOR_LEGACY_FILE_PATH) SED_BEFORE_STRING=$(ITEMENCRYPTOR_LEGACY_FILE_WITH_EXTERN_STRING) SED_AFTER_STRING=$(ITEMENCRYPTOR_LEGACY_FILE_WITHOUT_EXTERN_STRING)
	$(MAKE) _sed_file SED_FILE_PATH=$(TRANSFORMS_INDEX_FILE_PATH) SED_BEFORE_STRING=$(TRANSFORMS_INDEX_FILE_WITH_EXTERN_STRING) SED_AFTER_STRING=$(TRANSFORMS_INDEX_FILE_WITHOUT_EXTERN_STRING)
	$(MAKE) _sed_file SED_FILE_PATH=$(STRUCTUREDENCRYPTION_INDEX_FILE_PATH) SED_BEFORE_STRING=$(STRUCTUREDENCRYPTION_INDEX_FILE_WITH_EXTERN_STRING) SED_AFTER_STRING=$(STRUCTUREDENCRYPTION_INDEX_FILE_WITHOUT_EXTERN_STRING)

_sed_types_file_add_extern:
	$(MAKE) _sed_file SED_FILE_PATH=$(DYNAMODB_TYPES_FILE_PATH) SED_BEFORE_STRING=$(DYNAMODB_TYPES_FILE_WITHOUT_EXTERN_STRING) SED_AFTER_STRING=$(DYNAMODB_TYPES_FILE_WITH_EXTERN_STRING)
	$(MAKE) _sed_file SED_FILE_PATH=$(ITEMENCRYPTOR_TYPES_FILE_PATH) SED_BEFORE_STRING=$(ITEMENCRYPTOR_TYPES_FILE_WITHOUT_EXTERN_STRING) SED_AFTER_STRING=$(ITEMENCRYPTOR_TYPES_FILE_WITH_EXTERN_STRING)
	$(MAKE) _sed_file SED_FILE_PATH=$(TRANSFORMS_TYPES_FILE_PATH) SED_BEFORE_STRING=$(TRANSFORMS_TYPES_FILE_WITHOUT_EXTERN_STRING) SED_AFTER_STRING=$(TRANSFORMS_TYPES_FILE_WITH_EXTERN_STRING)
	$(MAKE) _sed_file SED_FILE_PATH=$(STRUCTUREDENCRYPTION_TYPES_FILE_PATH) SED_BEFORE_STRING=$(STRUCTUREDENCRYPTION_TYPES_FILE_WITHOUT_EXTERN_STRING) SED_AFTER_STRING=$(STRUCTUREDENCRYPTION_TYPES_FILE_WITH_EXTERN_STRING)

_sed_index_file_add_extern:
	$(MAKE) _sed_file SED_FILE_PATH=$(DYNAMODB_INDEX_FILE_PATH) SED_BEFORE_STRING=$(DYNAMODB_INDEX_FILE_WITHOUT_EXTERN_STRING) SED_AFTER_STRING=$(DYNAMODB_INDEX_FILE_WITH_EXTERN_STRING)
	$(MAKE) _sed_file SED_FILE_PATH=$(ITEMENCRYPTOR_INDEX_FILE_PATH) SED_BEFORE_STRING=$(ITEMENCRYPTOR_INDEX_FILE_WITHOUT_EXTERN_STRING) SED_AFTER_STRING=$(ITEMENCRYPTOR_INDEX_FILE_WITH_EXTERN_STRING)
	$(MAKE) _sed_file SED_FILE_PATH=$(ITEMENCRYPTOR_LEGACY_FILE_PATH) SED_BEFORE_STRING=$(ITEMENCRYPTOR_LEGACY_FILE_WITHOUT_EXTERN_STRING) SED_AFTER_STRING=$(ITEMENCRYPTOR_LEGACY_FILE_WITH_EXTERN_STRING)
	$(MAKE) _sed_file SED_FILE_PATH=$(TRANSFORMS_INDEX_FILE_PATH) SED_BEFORE_STRING=$(TRANSFORMS_INDEX_FILE_WITHOUT_EXTERN_STRING) SED_AFTER_STRING=$(TRANSFORMS_INDEX_FILE_WITH_EXTERN_STRING)
	$(MAKE) _sed_file SED_FILE_PATH=$(STRUCTUREDENCRYPTION_INDEX_FILE_PATH) SED_BEFORE_STRING=$(STRUCTUREDENCRYPTION_INDEX_FILE_WITHOUT_EXTERN_STRING) SED_AFTER_STRING=$(STRUCTUREDENCRYPTION_INDEX_FILE_WITH_EXTERN_STRING)
