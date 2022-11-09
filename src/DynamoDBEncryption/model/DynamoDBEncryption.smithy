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

@range(min: 1, max: 63)
integer BitLength

@range(min: 1)
integer VersionNumber

@length(min: 1, max: 1)
string Char

structure SplitConfig {
    @required
    split: Char,
    @required
    splitLens: BitLengthList,
    inner: Char,
    @required
    fail_if_short: Boolean,
    @required
    fail_if_long: Boolean,
}

structure Beacon {
    @required
    name: String,
    @required
    length: BitLength,
    prefix: Char,
    ignore: Char,
    split: SplitConfig,
}

structure PrimaryKey  {
    @required
    primary: KeySchemaAttributeName,   // the attribute we're constructing
    @required
    partition: KeySchemaAttributeName, // the encrypted partition key we wish we could use
    sort: KeySchemaAttributeName // the encrypted sort key we wish we could use
}

list BitLengthList {
    member: BitLength
}
list NarrowList {
    member: String
}
list BeaconList {
    member: Beacon
}
list BeaconVersionList {
    member: BeaconVersion
}

structure BeaconVersion {
    @required
    version: VersionNumber,
    @required
    beacons: BeaconList,
    @required
    key: String, // magic designator for hierarchy keyring key
    @required
    write: Boolean, // exactly one version must be write
    primary: PrimaryKey,
    narrowLSIs: NarrowList,
}

structure BeaconConfig {
    @required
    beacons: BeaconVersionList,
    @required
    writeBeaconVersion: VersionNumber,
}

structure DynamoDBTableEncryptionConfig {
    // TODO legacy encryptor
    // TODO legacy schema

    @required
    partitionKeyName: KeySchemaAttributeName,
    sortKeyName: KeySchemaAttributeName,
    beacons: BeaconConfig,
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
