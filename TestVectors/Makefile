# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

CORES=2

include ../submodules/MaterialProviders/SharedMakefileV2.mk

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
	AwsCryptographyPrimitives \
	ComAmazonawsKms \
	ComAmazonawsDynamodb \
	AwsCryptographicMaterialProviders \
	TestVectorsAwsCryptographicMaterialProviders \
	../../DynamoDbEncryption \

# Since we are packaging projects differently, we cannot make assumptions
# about where the files are located. 
# This is here to get unblocked but should be removed once we have migrated packages
# to the new packaging format.
PROJECT_INDEX := \
	AwsCryptographyPrimitives/src/Index.dfy \
	ComAmazonawsKms/src/Index.dfy \
	ComAmazonawsDynamodb/src/Index.dfy \
	AwsCryptographicMaterialProviders/dafny/AwsCryptographicMaterialProviders/src/Index.dfy \
	AwsCryptographicMaterialProviders/dafny/AwsCryptographyKeyStore/src/Index.dfy \
	../../DynamoDbEncryption/dafny/StructuredEncryption/src/Index.dfy \
	../../DynamoDbEncryption/dafny/DynamoDbEncryption/src/Index.dfy \

STD_LIBRARY=StandardLibrary
SMITHY_DEPS=model

DIR_STRUCTURE_V2=V2

# Dependencies for each local service
SERVICE_DEPS_DDBEncryption := \
	AwsCryptographyPrimitives \
	ComAmazonawsKms \
	ComAmazonawsDynamodb \
	AwsCryptographicMaterialProviders/dafny/AwsCryptographicMaterialProviders \
	AwsCryptographicMaterialProviders/dafny/AwsCryptographyKeyStore \
	../../DynamoDbEncryption/dafny/StructuredEncryption \
	../../DynamoDbEncryption/dafny/DynamoDbEncryption \
	TestVectorsAwsCryptographicMaterialProviders/dafny/TestVectorsAwsCryptographicMaterialProviders \

format_net:
	pushd runtimes/net && dotnet format && popd
