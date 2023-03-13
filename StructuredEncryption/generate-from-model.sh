#!/bin/bash

# A simple script for using our Polymorph package to generate
# all relevant code

pushd .

export CURRENT_DIR=`pwd`
export DEPS_ROOT=$CURRENT_DIR/../private-aws-encryption-sdk-dafny-staging
export CODEGEN_CLI_ROOT=$CURRENT_DIR/../polymorph/codegen/smithy-dafny-codegen-cli

export MaterialProviders_ROOT=$DEPS_ROOT/AwsCryptographicMaterialProviders
export AwsCryptographyPrimitives_ROOT=$DEPS_ROOT/AwsCryptographyPrimitives
export ComAmazonawsKms_ROOT=$DEPS_ROOT/ComAmazonawsKms
export ComAmazonawsDynamodb_ROOT=$DEPS_ROOT/ComAmazonawsDynamodb
export StructuredEncryption_ROOT=$CURRENT_DIR
export StandardLibrary_ROOT=$DEPS_ROOT/StandardLibrary

cd "$CODEGEN_CLI_ROOT"

# Generate code for StructuredEncryption
./gradlew run --args="\
    --output-dafny \
    --output-java $StructuredEncryption_ROOT/runtimes/java/src/main/smithy-generated \
    --include-dafny $StandardLibrary_ROOT/src/Index.dfy \
    --model $StructuredEncryption_ROOT/Model \
    --dependent-model $ComAmazonawsKms_ROOT/Model \
    --dependent-model $ComAmazonawsDynamodb_ROOT/Model \
    --dependent-model $MaterialProviders_ROOT/Model \
    --dependent-model $DEPS_ROOT/model \
    --dependent-model $AwsCryptographyPrimitives_ROOT/Model \
    --namespace aws.cryptography.structuredEncryption"

popd
