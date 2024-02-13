# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

CORES=2

include ../SharedMakefile.mk

PROJECT_SERVICES := \
	DDBEncryption \

SMITHY_MODEL_ROOT := $(PROJECT_ROOT)/DynamoDbEncryption/dafny/DynamoDbEncryption/Model
OUTPUT_LOCAL_SERVICE_DDBEncryption := --local-service-test

SERVICE_NAMESPACE_DDBEncryption=aws.cryptography.dbEncryptionSdk.dynamoDb

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
	DynamoDbEncryption/dafny/DynamoDbEncryption/src/Index.dfy \

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
	DynamoDbEncryption/dafny/StructuredEncryption \
	DynamoDbEncryption/dafny/DynamoDbEncryption \
	submodules/MaterialProviders/TestVectorsAwsCryptographicMaterialProviders/dafny/TestVectorsAwsCryptographicMaterialProviders \


format_net:
	pushd runtimes/net && dotnet format && popd

clean:
	rm -f runtimes/java/WriteTests1.json runtimes/java/decrypt.json runtimes/java/encrypt.json runtimes/net/*.json
