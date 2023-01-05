// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dynamoDbEncryption

use aws.polymorph#localService

use aws.cryptography.dynamoDbItemEncryptor#AttributeActions
use aws.cryptography.materialProviders#KeyringReference
use aws.cryptography.materialProviders#CryptographicMaterialsManagerReference
use com.amazonaws.dynamodb#DynamoDB_20120810
use com.amazonaws.dynamodb#TableName
use com.amazonaws.dynamodb#AttributeNameList
use com.amazonaws.dynamodb#KeySchemaAttributeName

// TODO "hide" the below APIs from customers, but keep the config structures "public"

// TODO The middleware trait is not yet implemented,
// Ideally, this trait will:
//     1. Be syntactic sugar to represent the verbose Transform operation smithy models.
//     2. Additionally implement all the Transform operations in Dafny as passthrough,
//        with an ability to easily add more specific impl via specific Transform*' methods.
//     3. Generate the language-idiomatic way to integrate with the SDK
//        (e.g. the Java SDK Interceptor)
//        that takes in DynamoDbEncryptionConfig as input.
// 
// @middleware(
//     awsService: DynamoDB_20120810,
//     config: DynamoDbEncryptionConfig,
//     errors: [DynamoDbEncryptionException]
//     name: "DynamoDbEncryptionMiddlewareInternal"
// )
@localService(
  sdkId: "DynamoDbEncryptionMiddlewareInternal",
  config: DynamoDbEncryptionConfig,
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
    errors: [ DynamoDbEncryptionException ]
}

structure DynamoDbEncryptionConfig {
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
structure DynamoDbEncryptionException {
  @required
  message: String,
}
