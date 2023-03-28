# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

CORES=2

include ../SharedMakefile.mk

SMITHY_NAMESPACES := \
	aws.cryptography.structuredEncryption \
	aws.cryptography.dynamoDbEncryption \
	aws.cryptography.dynamoDbEncryption.itemEncryptor \
	aws.cryptography.dynamoDbEncryption.transforms
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
	pushd runtimes/net && dotnet format DynamoDbEncryption.csproj && popd

# Transpiling the entire project can take a while (~10 minutes),
# So these custom written targets can be used to short-circuit the process
# and only transpile Dafny code for a specific namespace,
# e.g. No transpiling other namespaces
# and no transpiling and deploying dependencies.
# Note that these targets don't do any sort of 'clean'.
# If you are adding/renaming files, you should use `make build_java` first,
# and then can use these targets if you need to re-transpile after making
# smaller adjustments.
# TODO Improve/Generalize these targets into the SharedMakefile
transpile_implementation_%: TARGET=java
transpile_implementation_%: OUT=runtimes/java/ImplementationFromDafny
transpile_implementation_%:
	dafny \
		-vcsCores:$(CORES) \
		-compileTarget:$(TARGET) \
		-spillTargetCode:3 \
		-compile:0 \
		-optimizeErasableDatatypeWrapper:0 \
		-useRuntimeLib \
		-out $(OUT) \
		./src/%/Index.dfy \
		-library:$(PROJECT_ROOT)/$(STD_LIBRARY)/src/Index.dfy \
		$(patsubst %, -library:$(PROJECT_ROOT)/%/src/Index.dfy, $(LIBRARIES))

transpile_test_%:
	dafny \
		-vcsCores:$(CORES) \
		-compileTarget:$(TARGET) \
		-spillTargetCode:3 \
		-runAllTests:1 \
		-compile:0 \
		-optimizeErasableDatatypeWrapper:0 \
		-useRuntimeLib \
		-out $(OUT) \
		`find ./test/% -name '*.dfy'` \
		-library:src/Index.dfy
