#!/bin/bash

# A simple script for using our Polymorph package to generate
# all relevant code

pushd .

export CURRENT_DIR=`pwd`
export DEPS_ROOT=$CURRENT_DIR/../private-aws-encryption-sdk-dafny-staging
export POLYMORPH_ROOT=$CURRENT_DIR/../polymorph/smithy-polymorph

export ComAmazonawsDynamoDb_ROOT=$CURRENT_DIR
export StandardLibrary_ROOT=$DEPS_ROOT/StandardLibrary

cd "$POLYMORPH_ROOT"

# Generate code from DynamoDbItemEncryptor smithy model
./gradlew run --args="\
    --output-dafny \
    --include-dafny $StandardLibrary_ROOT/src/Index.dfy \
    --model $ComAmazonawsDynamoDb_ROOT/Model \
    --dependent-model $DEPS_ROOT/model \
    --namespace com.amazonaws.dynamodb \
    --aws-sdk"

popd
