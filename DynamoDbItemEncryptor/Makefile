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
		--max-resource-count 10000000 \
		TestResults/*.csv

transpile_net: | transpile_implementation_net transpile_test_net transpile_net_dependencies

transpile_implementation_net:
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
		-library:$(ROOT_DIR)/../StructuredEncryption/src/Index.dfy \
		-library:$(DEPS_DIR)/ComAmazonawsKms/src/Index.dfy \
		-library:$(DEPS_DIR)/ComAmazonawsDynamodb/src/Index.dfy \
		-library:$(DEPS_DIR)/StandardLibrary/src/Index.dfy

transpile_test_net:
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

transpile_net_dependencies:
	$(MAKE) -C $(DEPS_DIR)/StandardLibrary transpile_implementation_net
	$(MAKE) -C $(DEPS_DIR)/AwsCryptographyPrimitives transpile_implementation_net
	$(MAKE) -C $(DEPS_DIR)/ComAmazonawsKms transpile_implementation_net
	$(MAKE) -C $(DEPS_DIR)/ComAmazonawsDynamodb transpile_implementation_net
	$(MAKE) -C $(DEPS_DIR)/AwsCryptographicMaterialProviders transpile_implementation_net
	$(MAKE) -C $(ROOT_DIR)/../StructuredEncryption transpile_implementation_net

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

transpile_java: | transpile_implementation_java transpile_test_java

transpile_implementation_java: | _clean_implementation_java _transpile_implementation_java _mv_implementation_java

_clean_implementation_java:
	rm -rf runtimes/java/temp/AwsCryptographyDynamoDbItemEncryptor-java/* && rm -rf runtimes/java/src/main/dafny-generated/*

_transpile_implementation_java:
	dafny \
		-vcsCores:$(CORES) \
		-compileTarget:java \
		-spillTargetCode:3 \
		-compile:0 \
		-useRuntimeLib \
		-out runtimes/java/temp/AwsCryptographyDynamoDbItemEncryptor \
		./src/Index.dfy \
		-library:$(ROOT_DIR)/../StructuredEncryption/src/Index.dfy \
		-library:$(DEPS_DIR)/AwsCryptographicMaterialProviders/src/Index.dfy \
		-library:$(DEPS_DIR)/AwsCryptographyPrimitives/src/Index.dfy \
		-library:$(DEPS_DIR)/ComAmazonawsKms/src/Index.dfy \
		-library:$(DEPS_DIR)/ComAmazonawsDynamodb/src/Index.dfy \
		-library:$(DEPS_DIR)/StandardLibrary/src/Index.dfy

_mv_implementation_java:
	./runtimes/java/makefile_helper.sh implementation

transpile_test_java: | _clean_test_java _transpile_test_java _mv_test_java

_clean_test_java:
	rm -rf runtimes/java/temp-tests/AwsCryptographyDynamoDbItemEncryptorTests-java/* && rm -rf runtimes/java/src/test/dafny-generated/*

_transpile_test_java:
	dafny \
		-vcsCores:$(CORES) \
		-compileTarget:java \
		-spillTargetCode:3 \
		-runAllTests:1 \
		-compile:0 \
		-useRuntimeLib \
		-out runtimes/java/temp-tests/AwsCryptographyDynamoDbItemEncryptorTests \
		`find ./test -name '*.dfy'` \
		-library:src/Index.dfy

_mv_test_java:
	./runtimes/java/makefile_helper.sh test

build_java_dependencies:
	$(MAKE) -C $(DEPS_DIR)/StandardLibrary mvn_local_deploy
	$(MAKE) -C $(DEPS_DIR)/AwsCryptographyPrimitives mvn_local_deploy
	$(MAKE) -C $(DEPS_DIR)/ComAmazonawsKms mvn_local_deploy
	$(MAKE) -C $(DEPS_DIR)/ComAmazonawsDynamodb mvn_local_deploy
	$(MAKE) -C $(DEPS_DIR)/AwsCryptographicMaterialProviders mvn_local_deploy
	$(MAKE) -C $(ROOT_DIR)/../StructuredEncryption mvn_local_deploy

build_java: transpile_java build_java_dependencies
	gradle -p runtimes/java build

mvn_local_deploy: transpile_java
	gradle -p runtimes/java publishToMavenLocal

test_java:
	gradle -p runtimes/java runTests
