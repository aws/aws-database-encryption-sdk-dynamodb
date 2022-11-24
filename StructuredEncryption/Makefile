# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

ROOT_DIR:=$(shell dirname $(realpath $(firstword $(MAKEFILE_LIST))))
DEPS_DIR:=$(ROOT_DIR)/../private-aws-encryption-sdk-dafny-staging
CORES=2

verify:
	dafny \
		-vcsCores:$(CORES) \
		-compile:0 \
		-definiteAssignment:3 \
		-verificationLogger:csv \
		-timeLimit:300 \
		-trace \
		`find . -name '*.dfy'`

dafny-reportgenerator:
	dafny-reportgenerator \
		summarize-csv-results \
		--max-resource-count 110000000 \
		TestResults/*.csv

compile_net: | compile_implementation_net compile_test_net compile_net_dependencies

compile_implementation_net:
	dafny \
		-vcsCores:$(CORES) \
		-compileTarget:cs \
		-spillTargetCode:3 \
		-compile:0 \
		-useRuntimeLib \
		-out runtimes/net/ImplementationFromDafny \
		./src/Index.dfy \
		-library:$(DEPS_DIR)/AwsCryptographicMaterialProviders/src/Index.dfy \
		-library:$(DEPS_DIR)/AwsCryptographyPrimitives/src/Index.dfy \
		-library:$(DEPS_DIR)/ComAmazonawsKms/src/Index.dfy \
		-library:$(DEPS_DIR)/ComAmazonawsDynamodb/src/Index.dfy \
		-library:$(DEPS_DIR)/StandardLibrary/src/Index.dfy

compile_test_net:
	dafny \
		-vcsCores:$(CORES) \
		-compileTarget:cs \
		-spillTargetCode:3 \
		-runAllTests:1 \
		-compile:0 \
		-useRuntimeLib \
		-out runtimes/net/tests/TestsFromDafny \
		`find ./test -name '*.dfy'` \
		-library:src/Index.dfy

compile_net_dependencies:
	$(MAKE) -C $(DEPS_DIR)/StandardLibrary compile_implementation_net
	$(MAKE) -C $(DEPS_DIR)/AwsCryptographyPrimitives compile_implementation_net
	$(MAKE) -C $(DEPS_DIR)/ComAmazonawsKms compile_implementation_net
	$(MAKE) -C $(DEPS_DIR)/ComAmazonawsDynamodb compile_implementation_net
	$(MAKE) -C $(DEPS_DIR)/AwsCryptographicMaterialProviders compile_implementation_net

test_net:
	@exit $(shell dotnet run \
		--project runtimes/net/tests/ \
		--framework net6.0 | tee /dev/stderr | grep -c "FAILED")

test_net_mac_intel:
	@exit $(shell DYLD_LIBRARY_PATH="/usr/local/opt/openssl@1.1/lib" dotnet run \
		--project runtimes/net/tests/ \
		--framework net6.0 | tee /dev/stderr | grep -c "FAILED")

setup_net:
	dotnet restore runtimes/net/
