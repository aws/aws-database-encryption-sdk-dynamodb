// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dynamoDbItemEncryptor

use aws.polymorph#localService

use com.amazonaws.dynamodb#DynamoDB_20120810
use com.amazonaws.dynamodb#AttributeMap
use com.amazonaws.dynamodb#AttributeName
use com.amazonaws.dynamodb#AttributeNameList
use com.amazonaws.dynamodb#TableName
use com.amazonaws.dynamodb#KeySchemaAttributeName
use aws.cryptography.materialProviders#KeyringReference
use aws.cryptography.materialProviders#CryptographicMaterialsManagerReference
use aws.cryptography.structuredEncryption#CryptoAction

@localService(
  sdkId: "DynamoDbItemEncryptor",
  config: DynamoDbItemEncryptorConfig,
)
service DynamoDbItemEncryptor {
    version: "2022-08-26",
    operations: [EncryptItem, DecryptItem],
    errors: [DynamoDbItemEncryptorException],
}

structure DynamoDbItemEncryptorConfig {
    @required
    tableName: TableName,
    @required
    partitionKeyName: KeySchemaAttributeName,
    sortKeyName: KeySchemaAttributeName,

    @required
    attributeActions: AttributeActions,
    allowedUnauthenticatedAttributes: AttributeNameList,
    allowedUnauthenticatedAttributePrefix: String,
    // TODO algorithmSuite

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
structure DecryptItemInput {
    @required
    encryptedItem: AttributeMap,
}

structure DecryptItemOutput {
    @required
    plaintextItem: AttributeMap,
}

map AttributeActions {
    key: AttributeName,
    value: CryptoAction,
}

/////////////
// Errors

@error("client")
structure DynamoDbItemEncryptorException {
  @required
  message: String,
}
