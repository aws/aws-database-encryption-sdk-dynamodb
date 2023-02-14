# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

CORES=2
DEPS_DIR:=private-aws-encryption-sdk-dafny-staging

include ../SharedMakefile.mk

MAX_RESOURCE_COUNT=10000000
# Order is important
# In java they MUST be built
# in the order they depend on each other
LIBRARIES := \
	$(DEPS_DIR)/StandardLibrary \
	$(DEPS_DIR)/AwsCryptographyPrimitives \
	$(DEPS_DIR)/ComAmazonawsKms \
	$(DEPS_DIR)/ComAmazonawsDynamodb \
	$(DEPS_DIR)/AwsCryptographicMaterialProviders \
	StructuredEncryption \
	DynamoDbItemEncryptor \
	DynamoDbEncryptionMiddlewareInternal
