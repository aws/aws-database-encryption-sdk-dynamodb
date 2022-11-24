// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dynamoDbEncryptionMiddleware.internal

use aws.polymorph#localService

use aws.cryptography.dynamoDbItemEncryptor#AttributeActions
use aws.cryptography.materialProviders#KeyringReference
use aws.cryptography.materialProviders#CryptographicMaterialsManagerReference
use com.amazonaws.dynamodb#DynamoDB_20120810
use com.amazonaws.dynamodb#TableName
use com.amazonaws.dynamodb#AttributeNameList
use com.amazonaws.dynamodb#KeySchemaAttributeName

// TODO The middleware trait is not yet implemented,
// Ideally, this trait will:
//     1. Be syntactic sugar to represent the verbose Transform operation smithy models.
//     2. Additionally implement all the Transform operations in Dafny as passthrough,
//        with an ability to easily add more specific impl via specific Transform*' methods.
//     3. Generate the language-idiomatic way to integrate with the SDK
//        (e.g. the Java SDK Interceptor)
//        that takes in DynamoDbEncryptionMiddlewareInternalConfig as input.
// 
// @middleware(
//     awsService: DynamoDB_20120810,
//     config: DynamoDbEncryptionMiddlewareInternalConfig,
//     errors: [DynamoDbEncryptionMiddlewareInternalException]
//     name: "DynamoDbEncryptionMiddlewareInternal"
// )
@localService(
  sdkId: "DynamoDbEncryptionMiddlewareInternal",
  config: DynamoDbEncryptionMiddlewareInternalConfig,
)
service DynamoDbEncryptionMiddlewareInternal {
    version: "2022-11-21",
    operations: [
      PutItemInputTransform,
      PutItemOutputTransform,
      GetItemInputTransform,
      GetItemOutputTransform,
      BatchWriteItemInputTransform,
      BatchWriteItemOutputTransform,
      BatchGetItemInputTransform,
      BatchGetItemOutputTransform,
      ScanInputTransform,
      ScanOutputTransform,
      QueryInputTransform,
      QueryOutputTransform,
      TransactWriteItemsInputTransform,
      TransactWriteItemsOutputTransform,
      UpdateItemInputTransform,
      UpdateItemOutputTransform,
      DeleteItemInputTransform,
      DeleteItemOutputTransform,
      TransactGetItemsInputTransform,
      TransactGetItemsOutputTransform,
      ExecuteStatementInputTransform,
      ExecuteStatementOutputTransform,
      BatchExecuteStatementInputTransform,
      BatchExecuteStatementOutputTransform,
      ExecuteTransactionInputTransform,
      ExecuteTransactionOutputTransform,
    ],
    errors: [ DynamoDbEncryptionMiddlewareInternalException ]
}

// TODO These configs are in the 'internal' package,
// But ideally this config should represent exactly the
// config the customer needs to input to create the Middleware.
// We can either move these into the itemEncryptor package,
// move this into a new namespace with not service (would require extra Polymorph work),
// Or implement a target-language specific config object which wraps this config.
// Or don't message this package as 'internal'.
structure DynamoDbEncryptionMiddlewareInternalConfig {
    @required
    tableEncryptionConfigs: DynamoDbTableEncryptionConfigs
    // TODO allowed passthrough tables
}

map DynamoDbTableEncryptionConfigs {
    key: TableName,
    value: DynamoDbTableEncryptionConfig
}

structure DynamoDbTableEncryptionConfig {
    @required
    partitionKeyName: KeySchemaAttributeName,
    sortKeyName: KeySchemaAttributeName,

    // TODO scan beacon config
    
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

/////////////
// Errors

@error("client")
structure DynamoDbEncryptionMiddlewareInternalException {
  @required
  message: String,
}
