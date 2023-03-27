# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

CORES=2

include ../SharedMakefile.mk

SMITHY_NAMESPACES := \
	aws.cryptography.dynamoDbEncryption \
	aws.cryptography.dynamoDbEncryption.itemEncryptor \
	aws.cryptography.dynamoDbEncryption.internal.transforms \
	aws.cryptography.structuredEncryption
MAX_RESOURCE_COUNT=10000000
# Order is important
# In java they MUST be built
# in the order they depend on each other
LIBRARIES := \
	submodules/MaterialProviders/AwsCryptographyPrimitives \
	submodules/MaterialProviders/ComAmazonawsKms \
	submodules/MaterialProviders/ComAmazonawsDynamodb \
	submodules/MaterialProviders/AwsCryptographicMaterialProviders
STD_LIBRARY=submodules/MaterialProviders/StandardLibrary
SMITHY_DEPS=submodules/MaterialProviders/model

format_net:
	pushd runtimes/net && dotnet format && popd
