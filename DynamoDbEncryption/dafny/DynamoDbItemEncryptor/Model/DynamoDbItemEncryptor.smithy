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
use aws.cryptography.materialProviders#EncryptedDataKeyList
use aws.cryptography.materialProviders#EncryptionContext
use aws.cryptography.dynamoDbEncryption#AttributeActions
use aws.cryptography.dynamoDbEncryption#LegacyConfig
use aws.cryptography.structuredEncryption#Version
use aws.cryptography.dynamoDbEncryption#PlaintextPolicy

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
    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#structure
    //= type=implication
    //# The following are REQUIRED for DynamoDb Table Encryption Configuration:
    //# - [Logical Table Name](#logical-table-name)
    //# - [DynamoDB Partition Key Name](#dynamodb-partition-key-name)
    //# - [Attribute Actions](#attribute-actions)
    //# - A [CMM](#cmm) or [Keyring](#keyring)

    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#structure
    //= type=implication
    //# The following are OPTIONAL for DynamoDb Table Encryption Configuration:
    //# - [DynamoDB Sort Key Name](#dynamodb-sort-key-name)
    //# - [Unauthenticated Attributes](#unauthenticated-attributes)
    //# - [Unauthenticated Attribute Name Prefix](#unauthenticated-attribute-prefix)
    //# - [Algorithm Suite](#algorithm-suite)
    //# - [Legacy Config](#legacy-config)
    //# - [Plaintext Policy](#plaintext-policy)

    @required
    logicalTableName: String,

    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#dynamodb-partition-key-name
    //= type=implication
    //# This Partition Key Name MUST be a valid DynamoDB Key Schema Attribute Name
    @required
    partitionKeyName: KeySchemaAttributeName,

    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#dynamodb-sort-key-name
    //= type=implication
    //# This Sort Key Name MUST be a valid DynamoDB Key Schema Attribute Name
    sortKeyName: KeySchemaAttributeName,

    @required
    attributeActions: AttributeActions,

    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#unauthenticated-attributes
    //= type=implication
    //# Unauthenticated Attributes MUST be a set of Attribute Names.
    allowedUnauthenticatedAttributes: AttributeNameList,

    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#unauthenticated-attribute-prefix
    //= type=implication
    //# Unauthenticated Attribute Prefix MUST be a string.
    allowedUnauthenticatedAttributePrefix: String,

    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#algorithm-suite
    //= type=implication
    //# This algorithm suite MUST be a [Structured Encryption Library Supported algorithm suite](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md).
    algorithmSuiteId: DBEAlgorithmSuiteId,

    // Requires a Keyring XOR a CMM
    keyring: KeyringReference,
    cmm: CryptographicMaterialsManagerReference,

    legacyConfig: LegacyConfig,

    plaintextPolicy: PlaintextPolicy,
}

//= specification/dynamodb-encryption-client/decrypt-item.md#parsed-header
//= type=implication
//# This structure MUST contain the following values,
//# representing the deserialized form of the header of the input encrypted structure:
//#   - [Algorithm Suite ID](./header.md#format-flavor): The Algorithm Suite ID associated with the Format Flavor on the header.
//#   - [Attribute Actions](./ddb-table-encryption-config.md#attribute-actions): The Crypto Schema for each signed attribute,
//#     calculated using the Crypto Legend in the header, the signature scope used for decryption, and the data in the structure,
//#     converted into Attribute Actions.
//#   - [Encrypted Data Keys](./header.md#encrypted-data-keys): The Encrypted Data Keys stored in the header.
structure ParsedHeader {
    @required
    attributeActions: AttributeActions,
    @required
    algorithmSuiteId: DBEAlgorithmSuiteId,
    @required
    encryptedDataKeys: EncryptedDataKeyList,
    @required
    storedEncryptionContext: EncryptionContext
}

//= specification/dynamodb-encryption-client/ddb-item-encryptor.md#encryptitem
//= type=implication
//# The DynamoDB Item Encryptor MUST provide a function that adheres to [EncryptItem](./encrypt-item.md).
operation EncryptItem {
    input: EncryptItemInput,
    output: EncryptItemOutput,
}

//= specification/dynamodb-encryption-client/ddb-item-encryptor.md#decryptitem
//= type=implication
//# The DynamoDB Item Encryptor MUST provide a function that adheres to [DecryptItem](./decrypt-item.md).
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

    // MAY be None if in plaintext/legacy mode
    parsedHeader: ParsedHeader,
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
    //= specification/dynamodb-encryption-client/decrypt-item.md#output
    //= type=implication
    //# This operation MUST output the following:
    //#   - [DynamoDb Item](#dynamodb-item-1)
    @required
    plaintextItem: AttributeMap,

    // MAY be None if in plaintext/legacy mode
    parsedHeader: ParsedHeader,
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
