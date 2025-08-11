// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dbEncryptionSdk.dynamoDb.transforms

use aws.cryptography.dbEncryptionSdk.dynamoDb#DynamoDbTablesEncryptionConfig

use com.amazonaws.dynamodb#DynamoDB_20120810
use com.amazonaws.dynamodb#TableName
use com.amazonaws.dynamodb#AttributeMap
use com.amazonaws.dynamodb#QueryInput

use aws.cryptography.dbEncryptionSdk.dynamoDb#DynamoDbEncryption
use aws.cryptography.dbEncryptionSdk.dynamoDb.itemEncryptor#DynamoDbItemEncryptor
use aws.cryptography.dbEncryptionSdk.dynamoDb#VersionNumber
use aws.cryptography.dbEncryptionSdk.structuredEncryption#StructuredEncryption
use aws.cryptography.materialProviders#AwsCryptographicMaterialProviders
use aws.cryptography.dbEncryptionSdk.dynamoDb#BucketCount

use aws.polymorph#localService
use aws.polymorph#javadoc

@localService(
  sdkId: "DynamoDbEncryptionTransforms",
  config: DynamoDbTablesEncryptionConfig,
  dependencies: [
    DynamoDB_20120810,
    DynamoDbEncryption,
    DynamoDbItemEncryptor,
    StructuredEncryption,
    AwsCryptographicMaterialProviders
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
      GetNumberOfQueries,
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

@javadoc("Return the necessary number of query operations for this query, based on bucket usage.")
operation GetNumberOfQueries {
    input: GetNumberOfQueriesInput,
    output: GetNumberOfQueriesOutput,
}
structure GetNumberOfQueriesInput {
    @required
    input: QueryInput
}
structure GetNumberOfQueriesOutput {
    @required
    numberOfQueries: BucketCount
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

@aws.polymorph#reference(service: aws.cryptography.dbEncryptionSdk.structuredEncryption#StructuredEncryption)
structure StructuredEncryptionReference {}

@aws.polymorph#reference(service: aws.cryptography.materialProviders#AwsCryptographicMaterialProviders)
structure AwsCryptographicMaterialProvidersReference {}

@error("client")
structure DynamoDbEncryptionTransformsException {
  @required
  message: String,
}

