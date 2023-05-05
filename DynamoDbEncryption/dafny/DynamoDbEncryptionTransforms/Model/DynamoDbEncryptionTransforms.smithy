// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dynamoDbEncryption.transforms

use aws.cryptography.dynamoDbEncryption#DynamoDbTablesEncryptionConfig

use aws.polymorph#localService

@localService(
  sdkId: "DynamoDbEncryptionTransforms",
  config: DynamoDbTablesEncryptionConfig,
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
      CreateTableInputTransform,
      CreateTableOutputTransform,
      UpdateTableInputTransform,
      UpdateTableOutputTransform,
      DescribeTableInputTransform,
      DescribeTableOutputTransform,
    ],
    errors: [ DynamoDbEncryptionTransformsException ]
}

@aws.polymorph#reference(service: aws.cryptography.dynamoDbEncryption.itemEncryptor#DynamoDbItemEncryptor)
structure DynamoDbItemEncryptorReference {}

@aws.polymorph#reference(service: aws.cryptography.dynamoDbEncryption#DynamoDbEncryption)
structure DynamoDbEncryptionReference {}

@error("client")
structure DynamoDbEncryptionTransformsException {
  @required
  message: String,
}
