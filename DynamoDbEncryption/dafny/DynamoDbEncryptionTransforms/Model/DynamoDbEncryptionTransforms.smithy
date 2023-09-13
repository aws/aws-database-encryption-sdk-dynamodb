// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dbEncryptionSdk.dynamoDb.transforms

use aws.cryptography.dbEncryptionSdk.dynamoDb#DynamoDbTablesEncryptionConfig

use com.amazonaws.dynamodb#DynamoDB_20120810
use com.amazonaws.dynamodb#TableName
use com.amazonaws.dynamodb#AttributeMap

use aws.cryptography.dbEncryptionSdk.dynamoDb#DynamoDbEncryption
use aws.cryptography.dbEncryptionSdk.dynamoDb.itemEncryptor#DynamoDbItemEncryptor
use aws.cryptography.dbEncryptionSdk.dynamoDb#VersionNumber

use aws.polymorph#localService
use aws.polymorph#javadoc

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
      ResolveAttributes,
    ],
    errors: [ DynamoDbEncryptionTransformsException ]
}

@javadoc("Given an Item, show the intermediate values (e.g. compound beacons, virtual fields).")
operation ResolveAttributes {
    input: ResolveAttributesInput,
    output: ResolveAttributesOutput,
}

map StringMap {
  key : String,
  value : String
}

structure ResolveAttributesInput {
    @required
    @javadoc("Use the config for this Table.")
    TableName: TableName,
    @required
    @javadoc("The Item to be examined.")
    Item: AttributeMap,
    @javadoc("The beacon version to use. Defaults to 'writeVersion'.")
    Version : VersionNumber
}

structure ResolveAttributesOutput {
    @required
    @javadoc("Full plaintext of all calculable virtual fields.")
    VirtualFields: StringMap,
    @required
    @javadoc("Full plaintext of all calculable compound beacons.")
    CompoundBeacons: StringMap,
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
