# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

ROOT_DIR:=$(shell dirname $(realpath $(firstword $(MAKEFILE_LIST))))
DEPS_DIR:=$(ROOT_DIR)/../private-aws-encryption-sdk-dafny-staging

build_java_dependencies:
	$(MAKE) -C $(ROOT_DIR)/../DynamoDbEncryptionMiddlewareInternal build_java
	$(MAKE) -C $(ROOT_DIR)/../DynamoDbEncryptionMiddlewareInternal mvn_local_deploy

build_java: build_java_dependencies
	gradle -p runtimes/java build

mvn_local_deploy:
	gradle -p runtimes/java publishToMavenLocal

test_java:
	gradle -p runtimes/java test
