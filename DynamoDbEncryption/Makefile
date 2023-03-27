# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

CORES=2

include ../SharedMakefile.mk

SMITHY_NAMESPACES := \
	aws.cryptography.dynamoDbEncryption \
	aws.cryptography.dynamoDbItemEncryptor \
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

# Because transpiling the entire project takes a long time,
# and usually you only need to transpile a small change in a specific namespace,
# the following are custom targets to build specific namespaces.
# Note that these do not transpille and deploy the dependencies.
# TODO: Update the SharedMakefile to represent these targets more generally.
transpile_implementation_DynamoDbItemEncryptor: TARGET=java
transpile_implementation_DynamoDbItemEncryptor: OUT=runtimes/java/ImplementationFromDafny
transpile_implementation_DynamoDbItemEncryptor:
	dafny \
		-vcsCores:$(CORES) \
		-compileTarget:$(TARGET) \
		-spillTargetCode:3 \
		-compile:0 \
		-optimizeErasableDatatypeWrapper:0 \
		-useRuntimeLib \
		-out $(OUT) \
		./src/DynamoDbItemEncryptor/Index.dfy \
		-library:$(PROJECT_ROOT)/$(STD_LIBRARY)/src/Index.dfy \
		$(patsubst %, -library:$(PROJECT_ROOT)/%/src/Index.dfy, $(LIBRARIES))

transpile_test_DynamoDbItemEncryptor: TARGET=java
transpile_test_DynamoDbItemEncryptor: OUT=runtimes/java/ImplementationFromDafny
transpile_test_DynamoDbItemEncryptor:
	dafny \
		-vcsCores:$(CORES) \
		-compileTarget:$(TARGET) \
		-spillTargetCode:3 \
		-runAllTests:1 \
		-compile:0 \
		-optimizeErasableDatatypeWrapper:0 \
		-useRuntimeLib \
		-out $(OUT) \
		`find ./test -name '*.dfy'` \
		-library:src/Index.dfy

