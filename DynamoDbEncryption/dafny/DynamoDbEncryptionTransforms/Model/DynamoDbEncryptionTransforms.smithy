// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dynamoDbEncryption.transforms

use aws.cryptography.dynamoDbEncryption#DynamoDbTablesEncryptionConfig

use aws.polymorph#localService

// TODO The middleware trait is not yet implemented,
// Ideally, this trait will:
//     1. Be syntactic sugar to represent the verbose Transform operation smithy models.
//     2. Additionally implement all the Transform operations in Dafny as passthrough,
//        with an ability to easily add more specific impl via specific Transform*' methods.
//     3. Generate the language-idiomatic way to integrate with the SDK
//        (e.g. the Java SDK Interceptor)
//        that takes in DynamoDbTablesEncryptionConfig as input.
// 
// @middleware(
//     awsService: DynamoDB_20120810,
//     config: DynamoDbTablesEncryptionConfig,
//     errors: [DynamoDbEncryptionException]
//     name: "DynamoDbEncryptionTransforms"
// )
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
