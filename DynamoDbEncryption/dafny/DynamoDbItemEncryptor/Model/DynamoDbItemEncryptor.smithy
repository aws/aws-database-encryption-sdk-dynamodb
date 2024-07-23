// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dbEncryptionSdk.dynamoDb.itemEncryptor

use aws.polymorph#localService
use aws.polymorph#javadoc

use com.amazonaws.dynamodb#DynamoDB_20120810
use com.amazonaws.dynamodb#AttributeMap
use com.amazonaws.dynamodb#AttributeNameList
use com.amazonaws.dynamodb#TableName
use com.amazonaws.dynamodb#KeySchemaAttributeName
use com.amazonaws.dynamodb#Key

use aws.cryptography.primitives#AwsCryptographicPrimitives

use aws.cryptography.materialProviders#KeyringReference
use aws.cryptography.materialProviders#CryptographicMaterialsManagerReference
use aws.cryptography.materialProviders#DBEAlgorithmSuiteId
use aws.cryptography.materialProviders#EncryptedDataKeyList
use aws.cryptography.materialProviders#EncryptionContext
use aws.cryptography.materialProviders#AwsCryptographicMaterialProviders

use aws.cryptography.dbEncryptionSdk.dynamoDb#AttributeActions
use aws.cryptography.dbEncryptionSdk.dynamoDb#LegacyOverride
use aws.cryptography.dbEncryptionSdk.structuredEncryption#Version
use aws.cryptography.dbEncryptionSdk.dynamoDb#PlaintextOverride
use aws.cryptography.dbEncryptionSdk.dynamoDb#DynamoDbEncryption
use aws.cryptography.dbEncryptionSdk.structuredEncryption#StructuredEncryption

@localService(
  sdkId: "DynamoDbItemEncryptor",
  config: DynamoDbItemEncryptorConfig,
  dependencies: [
    AwsCryptographicPrimitives,
    DynamoDB_20120810,
    AwsCryptographicMaterialProviders,
    StructuredEncryption,
    DynamoDbEncryption,
  ]
)
service DynamoDbItemEncryptor {
    version: "2022-08-26",
    operations: [EncryptItem, DecryptItem],
    errors: [DynamoDbItemEncryptorException],
}

@javadoc("The configuration for the client-side encryption of DynamoDB items.")
structure DynamoDbItemEncryptorConfig {
    //= specification/dynamodb-encryption-client/ddb-item-encryptor.md#initialization
    //= type=implication
    //# On initialization of the DynamoDB Item Encryptor
    //# the caller MUST provide:
    //# - [DynamoDB Table Name](./ddb-table-encryption-config.md#dynamodb-table-name)
    //# - [DynamoDB Partition Key Name](./ddb-table-encryption-config.md#dynamodb-partition-key-name)
    //# - [Attribute Actions](./ddb-table-encryption-config.md#attribute-actions)
    //# - A [CMM](./ddb-table-encryption-config.md#cmm) or [Keyring](./ddb-table-encryption-config.md#keyring)

    //= specification/dynamodb-encryption-client/ddb-item-encryptor.md#initialization
    //= type=implication
    //# The following are OPTIONAL for the DynamoDB Item Encryptor:
    //# - [DynamoDB Sort Key Name](./ddb-table-encryption-config.md#dynamodb-sort-key-name)
    //# - [Unauthenticated Attributes](./ddb-table-encryption-config.md#unauthenticated-attributes)
    //# - [Unauthenticated Attribute Name Prefix](./ddb-table-encryption-config.md#unauthenticated-attribute-prefix)
    //# - [Algorithm Suite](./ddb-table-encryption-config.md#algorithm-suite)
    //# - [Legacy Config](./ddb-table-encryption-config.md#legacy-config)
    //# - [Plaintext Policy](./ddb-table-encryption-config.md#plaintext-policy)

    @required
    @javadoc("The logical table name for this table. This is the name that is cryptographically bound with your data. This can be the same as the actual DynamoDB table name. It's purpose is to be distinct from the DynamoDB table name so that the data may still be authenticated if being read from different (but logically similar) tables, such as a backup table.")
    logicalTableName: String,

    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#dynamodb-partition-key-name
    //= type=implication
    //# This Partition Key Name MUST be a valid DynamoDB Key Schema Attribute Name
    @required
    @javadoc("The name of the partition key on the table this item will be written to or was read from.")
    partitionKeyName: KeySchemaAttributeName,

    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#dynamodb-sort-key-name
    //= type=implication
    //# This Sort Key Name MUST be a valid DynamoDB Key Schema Attribute Name
    @javadoc("If this table contains a sort key, the name of the sort key on the table this item will be written to or was read from.")
    sortKeyName: KeySchemaAttributeName,

    @required
    @javadoc("A map that describes what attributes should be encrypted and/or signed on encrypt. This map must contain all attributes that might be encountered during encryption.")
    attributeActionsOnEncrypt: AttributeActions,

    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#unauthenticated-attributes
    //= type=implication
    //# Unauthenticated Attributes MUST be a set of Attribute Names.
    @javadoc("A list of attribute names such that, if encountered during decryption, those attributes are treated as unsigned.")
    allowedUnsignedAttributes: AttributeNameList,

    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#unauthenticated-attribute-prefix
    //= type=implication
    //# Unauthenticated Attribute Prefix MUST be a string.
    @javadoc("A prefix such that, if during decryption any attribute has a name with this prefix, it is treated as unsigned.")
    allowedUnsignedAttributePrefix: String,

    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#algorithm-suite
    //= type=implication
    //# This algorithm suite MUST be a [Structured Encryption Library Supported algorithm suite](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md).
    @javadoc("An ID for the algorithm suite to use during encryption and decryption.")
    algorithmSuiteId: DBEAlgorithmSuiteId,

    // Requires a Keyring XOR a CMM
    @javadoc("The Keyring that should be used to wrap and unwrap data keys. If specified a Default Cryptographic Materials Manager with this Keyring is used to obtain materials for encryption and decryption. Either a Keyring or a Cryptographic Materials Manager must be specified.")
    keyring: KeyringReference,
    @javadoc("The Cryptographic Materials Manager that is used to obtain materials for encryption and decryption.  Either a Keyring or a Cryptographic Materials Manager must be specified.")
    cmm: CryptographicMaterialsManagerReference,

    @javadoc("A configuration that override encryption and/or decryption to instead perform legacy encryption and/or decryption. Used as part of migration from version 2.x to version 3.x.")
    legacyOverride: LegacyOverride,

    @javadoc("A configuration that override encryption and/or decryption to instead passthrough and write and/or read plaintext. Used to update plaintext tables to fully use client-side encryption.")
    plaintextOverride: PlaintextOverride,
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
//#   - [Stored Encryption Context](../structured-encryption/header.md#encryption-context): The Encryption Context stored in the header.
//#   - [Encryption Context](../structured-encryption/decrypt-structure#encryption-context): The full Encryption Context used.
//#   - Selector Context : the AttributeMap as passed to the [Branch Key Supplier](./ddb-encryption-branch-key-id-supplier.md)
@javadoc("A parsed version of the header that was written with or read on an encrypted DynamoDB item.")
structure ParsedHeader {
    @required
    @javadoc("The non-DO_NOTHING Crypto Actions that were configured when this item was originally encrypted.")
    attributeActionsOnEncrypt: AttributeActions,
    @required
    @javadoc("The ID of the algorithm suite that was used to encrypt this item.")
    algorithmSuiteId: DBEAlgorithmSuiteId,
    @required
    @javadoc("The encrypted data keys that are stored in the header of this item.")
    encryptedDataKeys: EncryptedDataKeyList,
    @required
    @javadoc("The portion of the encryption context that was stored in the header of this item.")
    storedEncryptionContext: EncryptionContext,
    @required
    @javadoc("The full encryption context.")
    encryptionContext: EncryptionContext,
    @required
    @javadoc("The encryption context as presented to the branch key selector.")
    selectorContext: Key
}

//= specification/dynamodb-encryption-client/ddb-item-encryptor.md#encryptitem
//= type=implication
//# The DynamoDB Item Encryptor MUST provide a function that adheres to [EncryptItem](./encrypt-item.md).
@javadoc("Encrypt a DynamoDB Item.")
operation EncryptItem {
    input: EncryptItemInput,
    output: EncryptItemOutput,
}

//= specification/dynamodb-encryption-client/ddb-item-encryptor.md#decryptitem
//= type=implication
//# The DynamoDB Item Encryptor MUST provide a function that adheres to [DecryptItem](./decrypt-item.md).
@javadoc("Decrypt a DynamoDB Item.")
operation DecryptItem {
    input: DecryptItemInput,
    output: DecryptItemOutput,
}

//= specification/dynamodb-encryption-client/encrypt-item.md#input
//= type=implication
//# The following inputs to this behavior are REQUIRED:
//# - DynamoDB Item
@javadoc("Inputs for encrypting a DynamoDB Item.")
structure EncryptItemInput {
    @required
    @javadoc("The DynamoDB item to encrypt.")
    plaintextItem: AttributeMap,
}

@javadoc("Outputs for encrypting a DynamoDB Item.")
structure EncryptItemOutput {
    @required
    @javadoc("The encrypted DynamoDB item.")
    encryptedItem: AttributeMap,

    // MAY be None if in plaintext/legacy mode
    @javadoc("A parsed version of the header written with the encrypted DynamoDB item.")
    parsedHeader: ParsedHeader,
}

//= specification/dynamodb-encryption-client/decrypt-item.md#input
//= type=implication
//# The following inputs to this behavior are REQUIRED:
//# - [DynamoDb Item](#input-dynamodb-item)
@javadoc("Inputs for decrypting a DynamoDB Item.")
structure DecryptItemInput {
    @required
    @javadoc("The encrypted DynamoDB item to decrypt.")
    encryptedItem: AttributeMap,
}

@javadoc("Outputs for decrypting a DynamoDB Item.")
structure DecryptItemOutput {
    //= specification/dynamodb-encryption-client/decrypt-item.md#output
    //= type=implication
    //# This operation MUST output the following:
    //#   - [DynamoDb Item](#output-dynamodb-item)
    @required
    @javadoc("The decrypted DynamoDB item.")
    plaintextItem: AttributeMap,

    // MAY be None if in plaintext/legacy mode
    @javadoc("A parsed version of the header on the encrypted DynamoDB item.")
    parsedHeader: ParsedHeader,
}


@aws.polymorph#reference(service: aws.cryptography.primitives#AwsCryptographicPrimitives)
structure AtomicPrimitivesReference {}
@aws.polymorph#reference(service: aws.cryptography.dbEncryptionSdk.structuredEncryption#StructuredEncryption)
structure StructuredEncryptionReference {}

// Errors

@error("client")
structure DynamoDbItemEncryptorException {
  @required
  message: String,
}
