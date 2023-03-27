// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dynamoDbEncryption.itemEncryptor

use aws.polymorph#localService

use com.amazonaws.dynamodb#DynamoDB_20120810
use com.amazonaws.dynamodb#AttributeMap
use com.amazonaws.dynamodb#AttributeNameList
use com.amazonaws.dynamodb#TableName
use com.amazonaws.dynamodb#KeySchemaAttributeName
use aws.cryptography.materialProviders#KeyringReference
use aws.cryptography.materialProviders#CryptographicMaterialsManagerReference
use aws.cryptography.materialProviders#DBEAlgorithmSuiteId
use aws.cryptography.dynamoDbEncryption#AttributeActions

@localService(
  sdkId: "DynamoDbItemEncryptor",
  config: DynamoDbItemEncryptorConfig,
)
service DynamoDbItemEncryptor {
    version: "2022-08-26",
    operations: [EncryptItem, DecryptItem],
    errors: [DynamoDbItemEncryptorException],
}

//= specification/dynamodb-encryption-client/ddb-item-encryptor.md#initialization
//= type=implication
//# On initialization of the DynamoDB Item Encryptor, the caller MUST provide:
// - [DynamoDB Table Name](#dynamodb-table-name)
// - [DynamoDB Partition Key Name](#dynamodb-partition-key-name)
// - [Attribute Actions](#attribute-actions)
// - A [CMM](#cmm) or [Keyring](#keyring)

//= specification/dynamodb-encryption-client/ddb-item-encryptor.md#initialization
//= type=implication
//# On initialization, the caller MAY provide:
// - [DynamoDB Sort Key Name](#dynamodb-sort-key-name)
// - [Unauthenticated Attributes](#unauthenticated-attributes)
// - [Unauthenticated Attribute Name Prefix](#unauthenticated-attribute-prefix)
// - [Algorithm Suite](#algorithm-suite)
// - TODO legacy behavior
// - TODO allow plaintext behavior


structure DynamoDbItemEncryptorConfig {
    //= specification/dynamodb-encryption-client/ddb-item-encryptor.md#dynamodb-table-name
    //= type=implication
    //# This Table Name MUST be a valid DynamoDB Table Name.
    @required
    tableName: TableName,

    //= specification/dynamodb-encryption-client/ddb-item-encryptor.md#dynamodb-partition-key-name
    //= type=implication
    //# This Partition Key Name MUST be a valid DynamoDB Key Schema Attribute Name
    @required
    partitionKeyName: KeySchemaAttributeName,

    //= specification/dynamodb-encryption-client/ddb-item-encryptor.md#dynamodb-sort-key-name
    //= type=implication
    //# This Sort Key Name MUST be a valid DynamoDB Key Schema Attribute Name
    sortKeyName: KeySchemaAttributeName,

    @required
    attributeActions: AttributeActions,

    //= specification/dynamodb-encryption-client/ddb-item-encryptor.md#unauthenticated-attributes
    //= type=implication
    //# Unauthenticated Attributes MUST be a set of Attribute Names.
    allowedUnauthenticatedAttributes: AttributeNameList,

    //= specification/dynamodb-encryption-client/ddb-item-encryptor.md#unauthenticated-attribute-prefix
    //= type=implication
    //# Unauthenticated Attribute Prefix MUST be a string.
    allowedUnauthenticatedAttributePrefix: String,

    algorithmSuiteId: DBEAlgorithmSuiteId,

    // Requires a Keyring XOR a CMM
    keyring: KeyringReference,
    cmm: CryptographicMaterialsManagerReference,

    // TODO legacy encryptor
    // TODO legacy schema
}

operation EncryptItem {
    input: EncryptItemInput,
    output: EncryptItemOutput,
}

operation DecryptItem {
    input: DecryptItemInput,
    output: DecryptItemOutput,
}

//= specification/dynamodb-encryption-client/encrypt-item.md#input
//= type=implication
//# The following inputs to this behavior are REQUIRED:
//# - DynamoDB Item
structure EncryptItemInput {
    @required
    plaintextItem: AttributeMap,
}

structure EncryptItemOutput {
    @required
    encryptedItem: AttributeMap,
}

//= specification/dynamodb-encryption-client/decrypt-item.md#input
//= type=implication
//# The following inputs to this behavior are REQUIRED:
//# - DynamoDB Item
structure DecryptItemInput {
    @required
    encryptedItem: AttributeMap,
}

structure DecryptItemOutput {
    @required
    plaintextItem: AttributeMap,
}

@aws.polymorph#reference(service: aws.cryptography.primitives#AwsCryptographicPrimitives)
structure AtomicPrimitivesReference {}

/////////////
// Errors

@error("client")
structure DynamoDbItemEncryptorException {
  @required
  message: String,
}
