// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dynamodbEncryption

use aws.polymorph#localService

use com.amazonaws.dynamodb#DynamoDB_20120810
use com.amazonaws.dynamodb#AttributeMap
use com.amazonaws.dynamodb#AttributeName
use com.amazonaws.dynamodb#TableName
use com.amazonaws.dynamodb#KeySchemaAttributeName
use aws.cryptography.materialProviders#KeyringReference
use aws.cryptography.materialProviders#CryptographicMaterialsManagerReference
use aws.cryptography.materialProviders#EncryptionContext
use aws.cryptography.structuredEncryption#CryptoAction
use aws.cryptography.structuredEncryption#EncryptionContextFieldList

@localService(
  sdkId: "DynamoDBEncryption",
  config: DynamoDBEncryptionConfig,
)
service DynamoDBEncryption {
    version: "2022-08-26",
    operations: [EncryptItem, DecryptItem],
    errors: [DynamoDBEncryptionException],
}

structure DynamoDBEncryptionConfig {
    @required
    tableConfigs: DynamoDBTableEncryptionConfigs,
}

map DynamoDBTableEncryptionConfigs {
    key: TableName,
    value: DynamoDBTableEncryptionConfig,
}

structure DynamoDBTableEncryptionConfig {
    // TODO legacy encryptor
    // TODO legacy schema

    @required
    partitionKeyName: KeySchemaAttributeName,
    sortKeyName: KeySchemaAttributeName,
}

operation EncryptItem {
    input: EncryptItemInput,
    output: EncryptItemOutput,
}

operation DecryptItem {
    input: DecryptItemInput,
    output: DecryptItemOutput,
}

structure EncryptItemInput {
    @required
    item: AttributeMap,

    @required
    cryptoSchema: DDBCryptoSchema,

    // TODO algorithmSuite

    encryptionContext: EncryptionContext,
    requiredContextFieldsOnDecrypt: EncryptionContextFieldList,

    // Requires a Keyring XOR a CMM
    keyring: KeyringReference,
    cmm: CryptographicMaterialsManagerReference,
}

structure EncryptItemOutput {
    @required
    encryptedItem: AttributeMap,
    // TODO parsed header
}

structure DecryptItemInput {
    @required
    encryptedItem: AttributeMap,
    encryptionContext: EncryptionContext,

    // Requires a Keyring XOR a CMM
    keyring: KeyringReference,
    cmm: CryptographicMaterialsManagerReference,
}

structure DecryptItemOutput {
    @required
    item: AttributeMap,
    // TODO parsed header
}

map DDBCryptoSchema {
    key: AttributeName,
    value: CryptoAction,
}

/////////////
// Errors

@error("client")
structure DynamoDBEncryptionException {
  @required
  message: String,
}
