#!/bin/bash

# A simple script for using our Polymorph package to generate
# all relevant code

pushd .

export CURRENT_DIR=`pwd`
export DEPS_ROOT=$CURRENT_DIR/../private-aws-encryption-sdk-dafny-staging
export POLYMORPH_ROOT=$CURRENT_DIR/../polymorph/smithy-polymorph

export MaterialProviders_ROOT=$DEPS_ROOT/AwsCryptographicMaterialProviders
export AwsCryptographyPrimitives_ROOT=$DEPS_ROOT/AwsCryptographyPrimitives
export ComAmazonawsKms_ROOT=$DEPS_ROOT/ComAmazonawsKms
export ComAmazonawsDynamodb_ROOT=$DEPS_ROOT/ComAmazonawsDynamodb
export StructuredEncryption_ROOT=$CURRENT_DIR/../StructuredEncryption
export DynamoDbItemEncryptor_ROOT=$CURRENT_DIR/../DynamoDbItemEncryptor
export StandardLibrary_ROOT=$DEPS_ROOT/StandardLibrary
export DynamoDbEncryptionMiddleware_ROOT=$CURRENT_DIR

cd "$POLYMORPH_ROOT"

# Generate code from DynamoDbItemEncryptor smithy model
./gradlew run --args="\
    --output-dafny \
    --include-dafny $StandardLibrary_ROOT/src/Index.dfy \
    --output-java $DynamoDbEncryptionMiddleware_ROOT/runtimes/java/src/main/smithy-generated \
    --model $DynamoDbEncryptionMiddleware_ROOT/Model \
    --dependent-model $ComAmazonawsKms_ROOT/Model \
    --dependent-model $ComAmazonawsDynamodb_ROOT/Model \
    --dependent-model $MaterialProviders_ROOT/Model \
    --dependent-model $DEPS_ROOT/model \
    --dependent-model $AwsCryptographyPrimitives_ROOT/Model \
    --dependent-model $StructuredEncryption_ROOT/Model \
    --dependent-model $DynamoDbItemEncryptor_ROOT/Model \
    --namespace aws.cryptography.dynamoDbEncryption"

popd
