// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.transforms;

import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchGetItemInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchGetItemInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchGetItemOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchGetItemOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.CreateTableInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.CreateTableInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.CreateTableOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.CreateTableOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DeleteItemInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DeleteItemInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DeleteItemOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DeleteItemOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error_DynamoDbEncryptionTransformsException;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteStatementInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteStatementInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteStatementOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteStatementOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteTransactionInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteTransactionInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteTransactionOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteTransactionOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateTableInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateTableInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateTableOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateTableOutputTransformOutput;
import Dafny.Com.Amazonaws.Dynamodb.Types.BatchExecuteStatementInput;
import Dafny.Com.Amazonaws.Dynamodb.Types.BatchExecuteStatementOutput;
import Dafny.Com.Amazonaws.Dynamodb.Types.BatchGetItemInput;
import Dafny.Com.Amazonaws.Dynamodb.Types.BatchGetItemOutput;
import Dafny.Com.Amazonaws.Dynamodb.Types.BatchWriteItemInput;
import Dafny.Com.Amazonaws.Dynamodb.Types.BatchWriteItemOutput;
import Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput;
import Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableOutput;
import Dafny.Com.Amazonaws.Dynamodb.Types.DeleteItemInput;
import Dafny.Com.Amazonaws.Dynamodb.Types.DeleteItemOutput;
import Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableInput;
import Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput;
import Dafny.Com.Amazonaws.Dynamodb.Types.ExecuteStatementInput;
import Dafny.Com.Amazonaws.Dynamodb.Types.ExecuteStatementOutput;
import Dafny.Com.Amazonaws.Dynamodb.Types.ExecuteTransactionInput;
import Dafny.Com.Amazonaws.Dynamodb.Types.ExecuteTransactionOutput;
import Dafny.Com.Amazonaws.Dynamodb.Types.GetItemInput;
import Dafny.Com.Amazonaws.Dynamodb.Types.GetItemOutput;
import Dafny.Com.Amazonaws.Dynamodb.Types.PutItemInput;
import Dafny.Com.Amazonaws.Dynamodb.Types.PutItemOutput;
import Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput;
import Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput;
import Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput;
import Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput;
import Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsInput;
import Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsOutput;
import Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput;
import Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsOutput;
import Dafny.Com.Amazonaws.Dynamodb.Types.UpdateItemInput;
import Dafny.Com.Amazonaws.Dynamodb.Types.UpdateItemOutput;
import Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput;
import Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableOutput;
import dafny.DafnySequence;
import java.lang.Character;
import java.lang.RuntimeException;
import software.amazon.cryptography.dynamoDbEncryption.transforms.model.CollectionOfErrors;
import software.amazon.cryptography.dynamoDbEncryption.transforms.model.DynamoDbEncryptionTransformsException;
import software.amazon.cryptography.dynamoDbEncryption.transforms.model.OpaqueError;

public class ToDafny {
  public static Error Error(RuntimeException nativeValue) {
    if (nativeValue instanceof DynamoDbEncryptionTransformsException) {
      return ToDafny.Error((DynamoDbEncryptionTransformsException) nativeValue);
    }
    if (nativeValue instanceof OpaqueError) {
      return ToDafny.Error((OpaqueError) nativeValue);
    }
    if (nativeValue instanceof CollectionOfErrors) {
      return ToDafny.Error((CollectionOfErrors) nativeValue);
    }
    return Error.create_Opaque(nativeValue);
  }

  public static Error Error(OpaqueError nativeValue) {
    return Error.create_Opaque(nativeValue.obj());
  }

  public static Error Error(CollectionOfErrors nativeValue) {
    DafnySequence<? extends Error> list = software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue.list(), 
        ToDafny::Error, 
        Error._typeDescriptor());
    return Error.create_CollectionOfErrors(list);
  }

  public static BatchWriteItemOutputTransformInput BatchWriteItemOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.BatchWriteItemOutputTransformInput nativeValue) {
    BatchWriteItemOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchWriteItemOutput(nativeValue.sdkOutput());
    BatchWriteItemInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchWriteItemInput(nativeValue.originalInput());
    return new BatchWriteItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static BatchGetItemInputTransformOutput BatchGetItemInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.BatchGetItemInputTransformOutput nativeValue) {
    BatchGetItemInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchGetItemInput(nativeValue.transformedInput());
    return new BatchGetItemInputTransformOutput(transformedInput);
  }

  public static BatchExecuteStatementOutputTransformInput BatchExecuteStatementOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.BatchExecuteStatementOutputTransformInput nativeValue) {
    BatchExecuteStatementOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchExecuteStatementOutput(nativeValue.sdkOutput());
    BatchExecuteStatementInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchExecuteStatementInput(nativeValue.originalInput());
    return new BatchExecuteStatementOutputTransformInput(sdkOutput, originalInput);
  }

  public static ScanInputTransformInput ScanInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.ScanInputTransformInput nativeValue) {
    ScanInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ScanInput(nativeValue.sdkInput());
    return new ScanInputTransformInput(sdkInput);
  }

  public static UpdateTableOutputTransformOutput UpdateTableOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.UpdateTableOutputTransformOutput nativeValue) {
    UpdateTableOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.UpdateTableOutput(nativeValue.transformedOutput());
    return new UpdateTableOutputTransformOutput(transformedOutput);
  }

  public static DescribeTableOutputTransformOutput DescribeTableOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.DescribeTableOutputTransformOutput nativeValue) {
    DescribeTableOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.DescribeTableOutput(nativeValue.transformedOutput());
    return new DescribeTableOutputTransformOutput(transformedOutput);
  }

  public static ScanOutputTransformOutput ScanOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.ScanOutputTransformOutput nativeValue) {
    ScanOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ScanOutput(nativeValue.transformedOutput());
    return new ScanOutputTransformOutput(transformedOutput);
  }

  public static BatchWriteItemInputTransformInput BatchWriteItemInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.BatchWriteItemInputTransformInput nativeValue) {
    BatchWriteItemInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchWriteItemInput(nativeValue.sdkInput());
    return new BatchWriteItemInputTransformInput(sdkInput);
  }

  public static UpdateItemInputTransformInput UpdateItemInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.UpdateItemInputTransformInput nativeValue) {
    UpdateItemInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.UpdateItemInput(nativeValue.sdkInput());
    return new UpdateItemInputTransformInput(sdkInput);
  }

  public static BatchGetItemOutputTransformOutput BatchGetItemOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.BatchGetItemOutputTransformOutput nativeValue) {
    BatchGetItemOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchGetItemOutput(nativeValue.transformedOutput());
    return new BatchGetItemOutputTransformOutput(transformedOutput);
  }

  public static DeleteItemOutputTransformInput DeleteItemOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.DeleteItemOutputTransformInput nativeValue) {
    DeleteItemOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.DeleteItemOutput(nativeValue.sdkOutput());
    DeleteItemInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.DeleteItemInput(nativeValue.originalInput());
    return new DeleteItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static UpdateItemOutputTransformOutput UpdateItemOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.UpdateItemOutputTransformOutput nativeValue) {
    UpdateItemOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.UpdateItemOutput(nativeValue.transformedOutput());
    return new UpdateItemOutputTransformOutput(transformedOutput);
  }

  public static DeleteItemInputTransformOutput DeleteItemInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.DeleteItemInputTransformOutput nativeValue) {
    DeleteItemInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.DeleteItemInput(nativeValue.transformedInput());
    return new DeleteItemInputTransformOutput(transformedInput);
  }

  public static BatchWriteItemInputTransformOutput BatchWriteItemInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.BatchWriteItemInputTransformOutput nativeValue) {
    BatchWriteItemInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchWriteItemInput(nativeValue.transformedInput());
    return new BatchWriteItemInputTransformOutput(transformedInput);
  }

  public static BatchExecuteStatementInputTransformOutput BatchExecuteStatementInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.BatchExecuteStatementInputTransformOutput nativeValue) {
    BatchExecuteStatementInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchExecuteStatementInput(nativeValue.transformedInput());
    return new BatchExecuteStatementInputTransformOutput(transformedInput);
  }

  public static PutItemOutputTransformOutput PutItemOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.PutItemOutputTransformOutput nativeValue) {
    PutItemOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.PutItemOutput(nativeValue.transformedOutput());
    return new PutItemOutputTransformOutput(transformedOutput);
  }

  public static PutItemInputTransformInput PutItemInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.PutItemInputTransformInput nativeValue) {
    PutItemInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.PutItemInput(nativeValue.sdkInput());
    return new PutItemInputTransformInput(sdkInput);
  }

  public static BatchExecuteStatementOutputTransformOutput BatchExecuteStatementOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.BatchExecuteStatementOutputTransformOutput nativeValue) {
    BatchExecuteStatementOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchExecuteStatementOutput(nativeValue.transformedOutput());
    return new BatchExecuteStatementOutputTransformOutput(transformedOutput);
  }

  public static QueryInputTransformOutput QueryInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.QueryInputTransformOutput nativeValue) {
    QueryInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.QueryInput(nativeValue.transformedInput());
    return new QueryInputTransformOutput(transformedInput);
  }

  public static GetItemOutputTransformOutput GetItemOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.GetItemOutputTransformOutput nativeValue) {
    GetItemOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.GetItemOutput(nativeValue.transformedOutput());
    return new GetItemOutputTransformOutput(transformedOutput);
  }

  public static TransactGetItemsInputTransformInput TransactGetItemsInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.TransactGetItemsInputTransformInput nativeValue) {
    TransactGetItemsInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.TransactGetItemsInput(nativeValue.sdkInput());
    return new TransactGetItemsInputTransformInput(sdkInput);
  }

  public static QueryOutputTransformOutput QueryOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.QueryOutputTransformOutput nativeValue) {
    QueryOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.QueryOutput(nativeValue.transformedOutput());
    return new QueryOutputTransformOutput(transformedOutput);
  }

  public static UpdateTableOutputTransformInput UpdateTableOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.UpdateTableOutputTransformInput nativeValue) {
    UpdateTableOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.UpdateTableOutput(nativeValue.sdkOutput());
    UpdateTableInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.UpdateTableInput(nativeValue.originalInput());
    return new UpdateTableOutputTransformInput(sdkOutput, originalInput);
  }

  public static DeleteItemInputTransformInput DeleteItemInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.DeleteItemInputTransformInput nativeValue) {
    DeleteItemInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.DeleteItemInput(nativeValue.sdkInput());
    return new DeleteItemInputTransformInput(sdkInput);
  }

  public static BatchGetItemOutputTransformInput BatchGetItemOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.BatchGetItemOutputTransformInput nativeValue) {
    BatchGetItemOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchGetItemOutput(nativeValue.sdkOutput());
    BatchGetItemInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchGetItemInput(nativeValue.originalInput());
    return new BatchGetItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static PutItemInputTransformOutput PutItemInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.PutItemInputTransformOutput nativeValue) {
    PutItemInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.PutItemInput(nativeValue.transformedInput());
    return new PutItemInputTransformOutput(transformedInput);
  }

  public static UpdateTableInputTransformOutput UpdateTableInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.UpdateTableInputTransformOutput nativeValue) {
    UpdateTableInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.UpdateTableInput(nativeValue.transformedInput());
    return new UpdateTableInputTransformOutput(transformedInput);
  }

  public static BatchWriteItemOutputTransformOutput BatchWriteItemOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.BatchWriteItemOutputTransformOutput nativeValue) {
    BatchWriteItemOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchWriteItemOutput(nativeValue.transformedOutput());
    return new BatchWriteItemOutputTransformOutput(transformedOutput);
  }

  public static BatchExecuteStatementInputTransformInput BatchExecuteStatementInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.BatchExecuteStatementInputTransformInput nativeValue) {
    BatchExecuteStatementInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchExecuteStatementInput(nativeValue.sdkInput());
    return new BatchExecuteStatementInputTransformInput(sdkInput);
  }

  public static TransactWriteItemsInputTransformOutput TransactWriteItemsInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.TransactWriteItemsInputTransformOutput nativeValue) {
    TransactWriteItemsInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.TransactWriteItemsInput(nativeValue.transformedInput());
    return new TransactWriteItemsInputTransformOutput(transformedInput);
  }

  public static GetItemOutputTransformInput GetItemOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.GetItemOutputTransformInput nativeValue) {
    GetItemOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.GetItemOutput(nativeValue.sdkOutput());
    GetItemInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.GetItemInput(nativeValue.originalInput());
    return new GetItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static CreateTableInputTransformInput CreateTableInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.CreateTableInputTransformInput nativeValue) {
    CreateTableInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.CreateTableInput(nativeValue.sdkInput());
    return new CreateTableInputTransformInput(sdkInput);
  }

  public static QueryOutputTransformInput QueryOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.QueryOutputTransformInput nativeValue) {
    QueryOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.QueryOutput(nativeValue.sdkOutput());
    QueryInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.QueryInput(nativeValue.originalInput());
    return new QueryOutputTransformInput(sdkOutput, originalInput);
  }

  public static GetItemInputTransformInput GetItemInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.GetItemInputTransformInput nativeValue) {
    GetItemInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.GetItemInput(nativeValue.sdkInput());
    return new GetItemInputTransformInput(sdkInput);
  }

  public static TransactWriteItemsOutputTransformInput TransactWriteItemsOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.TransactWriteItemsOutputTransformInput nativeValue) {
    TransactWriteItemsOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.TransactWriteItemsOutput(nativeValue.sdkOutput());
    TransactWriteItemsInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.TransactWriteItemsInput(nativeValue.originalInput());
    return new TransactWriteItemsOutputTransformInput(sdkOutput, originalInput);
  }

  public static ExecuteTransactionInputTransformInput ExecuteTransactionInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.ExecuteTransactionInputTransformInput nativeValue) {
    ExecuteTransactionInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ExecuteTransactionInput(nativeValue.sdkInput());
    return new ExecuteTransactionInputTransformInput(sdkInput);
  }

  public static DeleteItemOutputTransformOutput DeleteItemOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.DeleteItemOutputTransformOutput nativeValue) {
    DeleteItemOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.DeleteItemOutput(nativeValue.transformedOutput());
    return new DeleteItemOutputTransformOutput(transformedOutput);
  }

  public static ExecuteTransactionOutputTransformInput ExecuteTransactionOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.ExecuteTransactionOutputTransformInput nativeValue) {
    ExecuteTransactionOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ExecuteTransactionOutput(nativeValue.sdkOutput());
    ExecuteTransactionInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ExecuteTransactionInput(nativeValue.originalInput());
    return new ExecuteTransactionOutputTransformInput(sdkOutput, originalInput);
  }

  public static DescribeTableInputTransformInput DescribeTableInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.DescribeTableInputTransformInput nativeValue) {
    DescribeTableInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.DescribeTableInput(nativeValue.sdkInput());
    return new DescribeTableInputTransformInput(sdkInput);
  }

  public static PutItemOutputTransformInput PutItemOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.PutItemOutputTransformInput nativeValue) {
    PutItemOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.PutItemOutput(nativeValue.sdkOutput());
    PutItemInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.PutItemInput(nativeValue.originalInput());
    return new PutItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static CreateTableOutputTransformInput CreateTableOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.CreateTableOutputTransformInput nativeValue) {
    CreateTableOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.CreateTableOutput(nativeValue.sdkOutput());
    CreateTableInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.CreateTableInput(nativeValue.originalInput());
    return new CreateTableOutputTransformInput(sdkOutput, originalInput);
  }

  public static GetItemInputTransformOutput GetItemInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.GetItemInputTransformOutput nativeValue) {
    GetItemInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.GetItemInput(nativeValue.transformedInput());
    return new GetItemInputTransformOutput(transformedInput);
  }

  public static DescribeTableOutputTransformInput DescribeTableOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.DescribeTableOutputTransformInput nativeValue) {
    DescribeTableOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.DescribeTableOutput(nativeValue.sdkOutput());
    DescribeTableInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.DescribeTableInput(nativeValue.originalInput());
    return new DescribeTableOutputTransformInput(sdkOutput, originalInput);
  }

  public static ExecuteStatementOutputTransformInput ExecuteStatementOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.ExecuteStatementOutputTransformInput nativeValue) {
    ExecuteStatementOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ExecuteStatementOutput(nativeValue.sdkOutput());
    ExecuteStatementInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ExecuteStatementInput(nativeValue.originalInput());
    return new ExecuteStatementOutputTransformInput(sdkOutput, originalInput);
  }

  public static CreateTableInputTransformOutput CreateTableInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.CreateTableInputTransformOutput nativeValue) {
    CreateTableInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.CreateTableInput(nativeValue.transformedInput());
    return new CreateTableInputTransformOutput(transformedInput);
  }

  public static DescribeTableInputTransformOutput DescribeTableInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.DescribeTableInputTransformOutput nativeValue) {
    DescribeTableInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.DescribeTableInput(nativeValue.transformedInput());
    return new DescribeTableInputTransformOutput(transformedInput);
  }

  public static ExecuteStatementInputTransformOutput ExecuteStatementInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.ExecuteStatementInputTransformOutput nativeValue) {
    ExecuteStatementInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ExecuteStatementInput(nativeValue.transformedInput());
    return new ExecuteStatementInputTransformOutput(transformedInput);
  }

  public static TransactWriteItemsOutputTransformOutput TransactWriteItemsOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.TransactWriteItemsOutputTransformOutput nativeValue) {
    TransactWriteItemsOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.TransactWriteItemsOutput(nativeValue.transformedOutput());
    return new TransactWriteItemsOutputTransformOutput(transformedOutput);
  }

  public static ScanOutputTransformInput ScanOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.ScanOutputTransformInput nativeValue) {
    ScanOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ScanOutput(nativeValue.sdkOutput());
    ScanInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ScanInput(nativeValue.originalInput());
    return new ScanOutputTransformInput(sdkOutput, originalInput);
  }

  public static ExecuteTransactionOutputTransformOutput ExecuteTransactionOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.ExecuteTransactionOutputTransformOutput nativeValue) {
    ExecuteTransactionOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ExecuteTransactionOutput(nativeValue.transformedOutput());
    return new ExecuteTransactionOutputTransformOutput(transformedOutput);
  }

  public static UpdateTableInputTransformInput UpdateTableInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.UpdateTableInputTransformInput nativeValue) {
    UpdateTableInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.UpdateTableInput(nativeValue.sdkInput());
    return new UpdateTableInputTransformInput(sdkInput);
  }

  public static CreateTableOutputTransformOutput CreateTableOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.CreateTableOutputTransformOutput nativeValue) {
    CreateTableOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.CreateTableOutput(nativeValue.transformedOutput());
    return new CreateTableOutputTransformOutput(transformedOutput);
  }

  public static BatchGetItemInputTransformInput BatchGetItemInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.BatchGetItemInputTransformInput nativeValue) {
    BatchGetItemInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchGetItemInput(nativeValue.sdkInput());
    return new BatchGetItemInputTransformInput(sdkInput);
  }

  public static UpdateItemInputTransformOutput UpdateItemInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.UpdateItemInputTransformOutput nativeValue) {
    UpdateItemInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.UpdateItemInput(nativeValue.transformedInput());
    return new UpdateItemInputTransformOutput(transformedInput);
  }

  public static TransactWriteItemsInputTransformInput TransactWriteItemsInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.TransactWriteItemsInputTransformInput nativeValue) {
    TransactWriteItemsInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.TransactWriteItemsInput(nativeValue.sdkInput());
    return new TransactWriteItemsInputTransformInput(sdkInput);
  }

  public static ExecuteTransactionInputTransformOutput ExecuteTransactionInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.ExecuteTransactionInputTransformOutput nativeValue) {
    ExecuteTransactionInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ExecuteTransactionInput(nativeValue.transformedInput());
    return new ExecuteTransactionInputTransformOutput(transformedInput);
  }

  public static ExecuteStatementOutputTransformOutput ExecuteStatementOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.ExecuteStatementOutputTransformOutput nativeValue) {
    ExecuteStatementOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ExecuteStatementOutput(nativeValue.transformedOutput());
    return new ExecuteStatementOutputTransformOutput(transformedOutput);
  }

  public static ExecuteStatementInputTransformInput ExecuteStatementInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.ExecuteStatementInputTransformInput nativeValue) {
    ExecuteStatementInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ExecuteStatementInput(nativeValue.sdkInput());
    return new ExecuteStatementInputTransformInput(sdkInput);
  }

  public static TransactGetItemsInputTransformOutput TransactGetItemsInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.TransactGetItemsInputTransformOutput nativeValue) {
    TransactGetItemsInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.TransactGetItemsInput(nativeValue.transformedInput());
    return new TransactGetItemsInputTransformOutput(transformedInput);
  }

  public static ScanInputTransformOutput ScanInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.ScanInputTransformOutput nativeValue) {
    ScanInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ScanInput(nativeValue.transformedInput());
    return new ScanInputTransformOutput(transformedInput);
  }

  public static TransactGetItemsOutputTransformOutput TransactGetItemsOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.TransactGetItemsOutputTransformOutput nativeValue) {
    TransactGetItemsOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.TransactGetItemsOutput(nativeValue.transformedOutput());
    return new TransactGetItemsOutputTransformOutput(transformedOutput);
  }

  public static TransactGetItemsOutputTransformInput TransactGetItemsOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.TransactGetItemsOutputTransformInput nativeValue) {
    TransactGetItemsOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.TransactGetItemsOutput(nativeValue.sdkOutput());
    TransactGetItemsInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.TransactGetItemsInput(nativeValue.originalInput());
    return new TransactGetItemsOutputTransformInput(sdkOutput, originalInput);
  }

  public static UpdateItemOutputTransformInput UpdateItemOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.UpdateItemOutputTransformInput nativeValue) {
    UpdateItemOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.UpdateItemOutput(nativeValue.sdkOutput());
    UpdateItemInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.UpdateItemInput(nativeValue.originalInput());
    return new UpdateItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static QueryInputTransformInput QueryInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.transforms.model.QueryInputTransformInput nativeValue) {
    QueryInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.QueryInput(nativeValue.sdkInput());
    return new QueryInputTransformInput(sdkInput);
  }

  public static Error Error(DynamoDbEncryptionTransformsException nativeValue) {
    DafnySequence<? extends Character> message;
    message = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.message());
    return new Error_DynamoDbEncryptionTransformsException(message);
  }
}
