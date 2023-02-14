# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

ROOT_DIR:=$(shell dirname $(realpath $(firstword $(MAKEFILE_LIST))))
DEPS_DIR:=$(ROOT_DIR)/../private-aws-encryption-sdk-dafny-staging

build_java_dependencies:
	$(MAKE) -C $(DEPS_DIR)/StandardLibrary build_java
	$(MAKE) -C $(DEPS_DIR)/AwsCryptographyPrimitives build_java
	$(MAKE) -C $(DEPS_DIR)/ComAmazonawsKms build_java
	$(MAKE) -C $(DEPS_DIR)/ComAmazonawsDynamodb build_java
	$(MAKE) -C $(DEPS_DIR)/AwsCryptographicMaterialProviders build_java
	$(MAKE) -C $(ROOT_DIR)/../StructuredEncryption build_java
	$(MAKE) -C $(ROOT_DIR)/../DynamoDbItemEncryptor build_java
	$(MAKE) -C $(ROOT_DIR)/../DynamoDbEncryptionMiddlewareInternal build_java

mvn_local_deploy_dependencies:
	$(MAKE) -C $(DEPS_DIR)/StandardLibrary mvn_local_deploy
	$(MAKE) -C $(DEPS_DIR)/AwsCryptographyPrimitives mvn_local_deploy
	$(MAKE) -C $(DEPS_DIR)/ComAmazonawsKms mvn_local_deploy
	$(MAKE) -C $(DEPS_DIR)/ComAmazonawsDynamodb mvn_local_deploy
	$(MAKE) -C $(DEPS_DIR)/AwsCryptographicMaterialProviders mvn_local_deploy
	$(MAKE) -C $(ROOT_DIR)/../StructuredEncryption mvn_local_deploy
	$(MAKE) -C $(ROOT_DIR)/../DynamoDbItemEncryptor mvn_local_deploy
	$(MAKE) -C $(ROOT_DIR)/../DynamoDbEncryptionMiddlewareInternal mvn_local_deploy

build_java: build_java_dependencies mvn_local_deploy_dependencies
	gradle -p runtimes/java build

mvn_local_deploy:
	gradle -p runtimes/java publishToMavenLocal

test_java:
	gradle -p runtimes/java test
