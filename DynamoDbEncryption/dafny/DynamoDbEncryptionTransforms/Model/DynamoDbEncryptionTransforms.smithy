// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dbEncryptionSdk.dynamoDb.transforms

use aws.cryptography.dbEncryptionSdk.dynamoDb#DynamoDbTablesEncryptionConfig

use com.amazonaws.dynamodb#DynamoDB_20120810
use aws.cryptography.dbEncryptionSdk.dynamoDb#DynamoDbEncryption
use aws.cryptography.dbEncryptionSdk.dynamoDb.itemEncryptor#DynamoDbItemEncryptor

use aws.polymorph#localService

@localService(
  sdkId: "DynamoDbEncryptionTransforms",
  config: DynamoDbTablesEncryptionConfig,
  dependencies: [
    DynamoDB_20120810,
    DynamoDbEncryption,
    DynamoDbItemEncryptor,
  ]
)
service DynamoDbEncryptionTransforms {
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
    errors: [ DynamoDbEncryptionTransformsException ]
}

@aws.polymorph#reference(service: aws.cryptography.dbEncryptionSdk.dynamoDb.itemEncryptor#DynamoDbItemEncryptor)
structure DynamoDbItemEncryptorReference {}

@aws.polymorph#reference(service: aws.cryptography.dbEncryptionSdk.dynamoDb#DynamoDbEncryption)
structure DynamoDbEncryptionReference {}

@error("client")
structure DynamoDbEncryptionTransformsException {
  @required
  message: String,
}
