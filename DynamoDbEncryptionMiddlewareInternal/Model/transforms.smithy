// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dynamoDbEncryptionMiddleware.internal

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

// TODO: OutputTransformInputs need a 'executedSDKInput' or similar for Scan Beacons)
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
}

structure ExecuteTransactionOutputTransformOutput {
    @required
    transformedOutput: ExecuteTransactionOutput,
}
