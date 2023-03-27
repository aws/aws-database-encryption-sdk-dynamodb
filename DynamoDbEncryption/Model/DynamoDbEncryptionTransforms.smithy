// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dynamoDbEncryption.internal.transforms

use com.amazonaws.dynamodb#PutItemInput
use com.amazonaws.dynamodb#PutItemOutput
use com.amazonaws.dynamodb#GetItemInput
use com.amazonaws.dynamodb#GetItemOutput
use com.amazonaws.dynamodb#BatchWriteItemInput
use com.amazonaws.dynamodb#BatchWriteItemOutput
use com.amazonaws.dynamodb#BatchGetItemInput
use com.amazonaws.dynamodb#BatchGetItemOutput
use com.amazonaws.dynamodb#ScanInput
use com.amazonaws.dynamodb#ScanOutput
use com.amazonaws.dynamodb#QueryInput
use com.amazonaws.dynamodb#QueryOutput
use com.amazonaws.dynamodb#TransactWriteItemsInput
use com.amazonaws.dynamodb#TransactWriteItemsOutput
use com.amazonaws.dynamodb#UpdateItemInput
use com.amazonaws.dynamodb#UpdateItemOutput
use com.amazonaws.dynamodb#DeleteItemInput
use com.amazonaws.dynamodb#DeleteItemOutput
use com.amazonaws.dynamodb#TransactGetItemsInput
use com.amazonaws.dynamodb#TransactGetItemsOutput
use com.amazonaws.dynamodb#ExecuteStatementInput
use com.amazonaws.dynamodb#ExecuteStatementOutput
use com.amazonaws.dynamodb#BatchExecuteStatementInput
use com.amazonaws.dynamodb#BatchExecuteStatementOutput
use com.amazonaws.dynamodb#ExecuteTransactionInput
use com.amazonaws.dynamodb#ExecuteTransactionOutput
use com.amazonaws.dynamodb#CreateTableInput
use com.amazonaws.dynamodb#CreateTableOutput
use com.amazonaws.dynamodb#UpdateTableInput
use com.amazonaws.dynamodb#UpdateTableOutput
use com.amazonaws.dynamodb#DescribeTableInput
use com.amazonaws.dynamodb#DescribeTableOutput

use aws.polymorph#localService
use aws.cryptography.dynamoDbEncryption#DynamoDbEncryptionException
use aws.cryptography.dynamoDbEncryption#DynamoDbTablesEncryptionConfig

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
    errors: [ DynamoDbEncryptionException ]
}

// TODO: Model passthrough APIs
// TODO: Do we model an "unknown operation" somewhere, that just spits out an error?

operation PutItemInputTransform {
    input: PutItemInputTransformInput,
    output: PutItemInputTransformOutput,
}

structure PutItemInputTransformInput {
    @required
    sdkInput: PutItemInput,
}

structure PutItemInputTransformOutput {
    @required
    transformedInput: PutItemInput,
}

operation PutItemOutputTransform {
    input: PutItemOutputTransformInput,
    output: PutItemOutputTransformOutput,
}

structure PutItemOutputTransformInput {
    @required
    sdkOutput: PutItemOutput,
    @required
    originalInput: PutItemInput,
}

structure PutItemOutputTransformOutput {
    @required
    transformedOutput: PutItemOutput,
}

operation GetItemInputTransform {
    input: GetItemInputTransformInput,
    output: GetItemInputTransformOutput,
}

structure GetItemInputTransformInput {
    @required
    sdkInput: GetItemInput,
}

structure GetItemInputTransformOutput {
    @required
    transformedInput: GetItemInput,
}

operation GetItemOutputTransform {
    input: GetItemOutputTransformInput,
    output: GetItemOutputTransformOutput,
}

structure GetItemOutputTransformInput {
    @required
    sdkOutput: GetItemOutput,
    @required
    originalInput: GetItemInput,
}

structure GetItemOutputTransformOutput {
    @required
    transformedOutput: GetItemOutput,
}

operation BatchWriteItemInputTransform {
    input: BatchWriteItemInputTransformInput,
    output: BatchWriteItemInputTransformOutput,
}

structure BatchWriteItemInputTransformInput {
    @required
    sdkInput: BatchWriteItemInput,
}

structure BatchWriteItemInputTransformOutput {
    @required
    transformedInput: BatchWriteItemInput,
}

operation BatchWriteItemOutputTransform {
    input: BatchWriteItemOutputTransformInput,
    output: BatchWriteItemOutputTransformOutput,
}

structure BatchWriteItemOutputTransformInput {
    @required
    sdkOutput: BatchWriteItemOutput,
    @required
    originalInput: BatchWriteItemInput,
}

structure BatchWriteItemOutputTransformOutput {
    @required
    transformedOutput: BatchWriteItemOutput,
}

operation BatchGetItemInputTransform {
    input: BatchGetItemInputTransformInput,
    output: BatchGetItemInputTransformOutput,
}

structure BatchGetItemInputTransformInput {
    @required
    sdkInput: BatchGetItemInput,
}

structure BatchGetItemInputTransformOutput {
    @required
    transformedInput: BatchGetItemInput,
}

operation BatchGetItemOutputTransform {
    input: BatchGetItemOutputTransformInput,
    output: BatchGetItemOutputTransformOutput,
}

structure BatchGetItemOutputTransformInput {
    @required
    sdkOutput: BatchGetItemOutput,
    @required
    originalInput: BatchGetItemInput,
}

structure BatchGetItemOutputTransformOutput {
    @required
    transformedOutput: BatchGetItemOutput,
}

operation ScanInputTransform {
    input: ScanInputTransformInput,
    output: ScanInputTransformOutput,
}

structure ScanInputTransformInput {
    @required
    sdkInput: ScanInput,
}

structure ScanInputTransformOutput {
    @required
    transformedInput: ScanInput,
}

operation ScanOutputTransform {
    input: ScanOutputTransformInput,
    output: ScanOutputTransformOutput,
}

structure ScanOutputTransformInput {
    @required
    sdkOutput: ScanOutput,
    @required
    originalInput: ScanInput,
}

structure ScanOutputTransformOutput {
    @required
    transformedOutput: ScanOutput,
}

operation QueryInputTransform {
    input: QueryInputTransformInput,
    output: QueryInputTransformOutput,
}

structure QueryInputTransformInput {
    @required
    sdkInput: QueryInput,
}

structure QueryInputTransformOutput {
    @required
    transformedInput: QueryInput,
}

operation QueryOutputTransform {
    input: QueryOutputTransformInput,
    output: QueryOutputTransformOutput,
}

structure QueryOutputTransformInput {
    @required
    sdkOutput: QueryOutput,
    @required
    originalInput: QueryInput,
}

structure QueryOutputTransformOutput {
    @required
    transformedOutput: QueryOutput,
}

operation TransactWriteItemsInputTransform {
    input: TransactWriteItemsInputTransformInput,
    output: TransactWriteItemsInputTransformOutput,
}

structure TransactWriteItemsInputTransformInput {
    @required
    sdkInput: TransactWriteItemsInput,
}

structure TransactWriteItemsInputTransformOutput {
    @required
    transformedInput: TransactWriteItemsInput,
}

operation TransactWriteItemsOutputTransform {
    input: TransactWriteItemsOutputTransformInput,
    output: TransactWriteItemsOutputTransformOutput,
}

structure TransactWriteItemsOutputTransformInput {
    @required
    sdkOutput: TransactWriteItemsOutput,
    @required
    originalInput: TransactWriteItemsInput,
}

structure TransactWriteItemsOutputTransformOutput {
    @required
    transformedOutput: TransactWriteItemsOutput,
}

operation UpdateItemInputTransform {
    input: UpdateItemInputTransformInput,
    output: UpdateItemInputTransformOutput,
}

structure UpdateItemInputTransformInput {
    @required
    sdkInput: UpdateItemInput,
}

structure UpdateItemInputTransformOutput {
    @required
    transformedInput: UpdateItemInput,
}

operation UpdateItemOutputTransform {
    input: UpdateItemOutputTransformInput,
    output: UpdateItemOutputTransformOutput,
}

structure UpdateItemOutputTransformInput {
    @required
    sdkOutput: UpdateItemOutput,
    @required
    originalInput: UpdateItemInput,
}

structure UpdateItemOutputTransformOutput {
    @required
    transformedOutput: UpdateItemOutput,
}

operation DeleteItemInputTransform {
    input: DeleteItemInputTransformInput,
    output: DeleteItemInputTransformOutput,
}

structure DeleteItemInputTransformInput {
    @required
    sdkInput: DeleteItemInput,
}

structure DeleteItemInputTransformOutput {
    @required
    transformedInput: DeleteItemInput,
}

operation DeleteItemOutputTransform {
    input: DeleteItemOutputTransformInput,
    output: DeleteItemOutputTransformOutput,
}

structure DeleteItemOutputTransformInput {
    @required
    sdkOutput: DeleteItemOutput,
    @required
    originalInput: DeleteItemInput,
}

structure DeleteItemOutputTransformOutput {
    @required
    transformedOutput: DeleteItemOutput,
}

operation TransactGetItemsInputTransform {
    input: TransactGetItemsInputTransformInput,
    output: TransactGetItemsInputTransformOutput,
}

structure TransactGetItemsInputTransformInput {
    @required
    sdkInput: TransactGetItemsInput,
}

structure TransactGetItemsInputTransformOutput {
    @required
    transformedInput: TransactGetItemsInput,
}

operation TransactGetItemsOutputTransform {
    input: TransactGetItemsOutputTransformInput,
    output: TransactGetItemsOutputTransformOutput,
}

structure TransactGetItemsOutputTransformInput {
    @required
    sdkOutput: TransactGetItemsOutput,
    @required
    originalInput: TransactGetItemsInput,
}

structure TransactGetItemsOutputTransformOutput {
    @required
    transformedOutput: TransactGetItemsOutput,
}

operation ExecuteStatementInputTransform {
    input: ExecuteStatementInputTransformInput,
    output: ExecuteStatementInputTransformOutput,
}

structure ExecuteStatementInputTransformInput {
    @required
    sdkInput: ExecuteStatementInput,
}

structure ExecuteStatementInputTransformOutput {
    @required
    transformedInput: ExecuteStatementInput,
}

operation ExecuteStatementOutputTransform {
    input: ExecuteStatementOutputTransformInput,
    output: ExecuteStatementOutputTransformOutput,
}

structure ExecuteStatementOutputTransformInput {
    @required
    sdkOutput: ExecuteStatementOutput,
    @required
    originalInput: ExecuteStatementInput,
}

structure ExecuteStatementOutputTransformOutput {
    @required
    transformedOutput: ExecuteStatementOutput,
}

operation BatchExecuteStatementInputTransform {
    input: BatchExecuteStatementInputTransformInput,
    output: BatchExecuteStatementInputTransformOutput,
}

structure BatchExecuteStatementInputTransformInput {
    @required
    sdkInput: BatchExecuteStatementInput,
}

structure BatchExecuteStatementInputTransformOutput {
    @required
    transformedInput: BatchExecuteStatementInput,
}

operation BatchExecuteStatementOutputTransform {
    input: BatchExecuteStatementOutputTransformInput,
    output: BatchExecuteStatementOutputTransformOutput,
}

structure BatchExecuteStatementOutputTransformInput {
    @required
    sdkOutput: BatchExecuteStatementOutput,
    @required
    originalInput: BatchExecuteStatementInput,
}

structure BatchExecuteStatementOutputTransformOutput {
    @required
    transformedOutput: BatchExecuteStatementOutput,
}

operation ExecuteTransactionInputTransform {
    input: ExecuteTransactionInputTransformInput,
    output: ExecuteTransactionInputTransformOutput,
}

structure ExecuteTransactionInputTransformInput {
    @required
    sdkInput: ExecuteTransactionInput,
}

structure ExecuteTransactionInputTransformOutput {
    @required
    transformedInput: ExecuteTransactionInput,
}

operation ExecuteTransactionOutputTransform {
    input: ExecuteTransactionOutputTransformInput,
    output: ExecuteTransactionOutputTransformOutput,
}

structure ExecuteTransactionOutputTransformInput {
    @required
    sdkOutput: ExecuteTransactionOutput,
    @required
    originalInput: ExecuteTransactionInput,
}

structure ExecuteTransactionOutputTransformOutput {
    @required
    transformedOutput: ExecuteTransactionOutput,
}



operation CreateTableInputTransform {
    input: CreateTableInputTransformInput,
    output: CreateTableInputTransformOutput,
}

structure CreateTableInputTransformInput {
    @required
    sdkInput: CreateTableInput,
}

structure CreateTableInputTransformOutput {
    @required
    transformedInput: CreateTableInput,
}

operation CreateTableOutputTransform {
    input: CreateTableOutputTransformInput,
    output: CreateTableOutputTransformOutput,
}

structure CreateTableOutputTransformInput {
    @required
    sdkOutput: CreateTableOutput,
    @required
    originalInput: CreateTableInput,
}

structure CreateTableOutputTransformOutput {
    @required
    transformedOutput: CreateTableOutput,
}

operation UpdateTableInputTransform {
    input: UpdateTableInputTransformInput,
    output: UpdateTableInputTransformOutput,
}

structure UpdateTableInputTransformInput {
    @required
    sdkInput: UpdateTableInput,
}

structure UpdateTableInputTransformOutput {
    @required
    transformedInput: UpdateTableInput,
}

operation UpdateTableOutputTransform {
    input: UpdateTableOutputTransformInput,
    output: UpdateTableOutputTransformOutput,
}

structure UpdateTableOutputTransformInput {
    @required
    sdkOutput: UpdateTableOutput,
    @required
    originalInput: UpdateTableInput,
}

structure UpdateTableOutputTransformOutput {
    @required
    transformedOutput: UpdateTableOutput,
}

operation DescribeTableInputTransform {
    input: DescribeTableInputTransformInput,
    output: DescribeTableInputTransformOutput,
}

structure DescribeTableInputTransformInput {
    @required
    sdkInput: DescribeTableInput,
}

structure DescribeTableInputTransformOutput {
    @required
    transformedInput: DescribeTableInput,
}

operation DescribeTableOutputTransform {
    input: DescribeTableOutputTransformInput,
    output: DescribeTableOutputTransformOutput,
}

structure DescribeTableOutputTransformInput {
    @required
    sdkOutput: DescribeTableOutput,
    @required
    originalInput: DescribeTableInput,
}

structure DescribeTableOutputTransformOutput {
    @required
    transformedOutput: DescribeTableOutput,
}
