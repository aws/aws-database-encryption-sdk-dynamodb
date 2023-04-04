# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

CORES=2

include ../SharedMakefile.mk

PROJECT_SERVICES := \
	DynamoDbEncryption \
	DynamoDbItemEncryptor \
	DynamoDbEncryptionTransforms \
	StructuredEncryption

# Namespace for each local service
# Currently our build relies on local services and namespaces being 1:1
SERVICE_NAMESPACE_StructuredEncryption=aws.cryptography.structuredEncryption
SERVICE_NAMESPACE_DynamoDbEncryption=aws.cryptography.dynamoDbEncryption
SERVICE_NAMESPACE_DynamoDbItemEncryptor=aws.cryptography.dynamoDbEncryption.itemEncryptor
SERVICE_NAMESPACE_DynamoDbEncryptionTransforms=aws.cryptography.dynamoDbEncryption.transforms

MAX_RESOURCE_COUNT=10000000
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

# Dependencies for each local service
SERVICE_DEPS_StructuredEncryption := \
	submodules/MaterialProviders/AwsCryptographyPrimitives \
	submodules/MaterialProviders/ComAmazonawsKms \
	submodules/MaterialProviders/ComAmazonawsDynamodb \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders
SERVICE_DEPS_DynamoDbEncryption := \
	submodules/MaterialProviders/AwsCryptographyPrimitives \
	submodules/MaterialProviders/ComAmazonawsKms \
	submodules/MaterialProviders/ComAmazonawsDynamodb \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders \
	DynamoDbEncryption/dafny/StructuredEncryption
SERVICE_DEPS_DynamoDbItemEncryptor := \
	submodules/MaterialProviders/AwsCryptographyPrimitives \
	submodules/MaterialProviders/ComAmazonawsKms \
	submodules/MaterialProviders/ComAmazonawsDynamodb \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders \
	DynamoDbEncryption/dafny/DynamoDbEncryption \
	DynamoDbEncryption/dafny/StructuredEncryption
SERVICE_DEPS_DynamoDbEncryptionTransforms := \
	submodules/MaterialProviders/AwsCryptographyPrimitives \
	submodules/MaterialProviders/ComAmazonawsKms \
	submodules/MaterialProviders/ComAmazonawsDynamodb \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders \
	DynamoDbEncryption/dafny/DynamoDbEncryption \
	DynamoDbEncryption/dafny/StructuredEncryption \
	DynamoDbEncryption/dafny/DynamoDbItemEncryptor

format_net:
	pushd runtimes/net && dotnet format DynamoDbEncryption.csproj && popd
