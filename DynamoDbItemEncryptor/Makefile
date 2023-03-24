# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

CORES=2
DEPS_DIR:=private-aws-encryption-sdk-dafny-staging

include ../$(DEPS_DIR)/SharedMakefile.mk

SMITHY_NAMESPACE=aws.cryptography.dynamoDbItemEncryptor
SMITHY_NAMESPACES := \
    aws.cryptography.dynamoDbItemEncryptor \
    aws.cryptography.dynamoDbEncryption.resources
MAX_RESOURCE_COUNT=10000000
# Order is important
# In java they MUST be built
# in the order they depend on each other
LIBRARIES := \
	AwsCryptographyPrimitives \
	ComAmazonawsKms \
	ComAmazonawsDynamodb \
	AwsCryptographicMaterialProviders \
	../StructuredEncryption

format_net:
	pushd runtimes/net && dotnet format && popd
