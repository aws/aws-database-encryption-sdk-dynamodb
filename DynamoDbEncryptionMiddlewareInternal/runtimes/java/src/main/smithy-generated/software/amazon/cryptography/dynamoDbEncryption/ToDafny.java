// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption;

import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchExecuteStatementInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchExecuteStatementInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchExecuteStatementOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchExecuteStatementOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchGetItemInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchGetItemInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchGetItemOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchGetItemOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchWriteItemInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchWriteItemInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchWriteItemOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchWriteItemOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateTableInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateTableInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateTableOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateTableOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DeleteItemInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DeleteItemInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DeleteItemOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DeleteItemOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DescribeTableInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DescribeTableInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DescribeTableOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DescribeTableOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbEncryptionConfig;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error_DynamoDbEncryptionException;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteStatementInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteStatementInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteStatementOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteStatementOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteTransactionInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteTransactionInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteTransactionOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteTransactionOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetItemInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetItemInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetItemOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetItemOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PutItemInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PutItemInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PutItemOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PutItemOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.QueryInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.QueryInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.QueryOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.QueryOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ScanInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ScanInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ScanOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ScanOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactGetItemsInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactGetItemsInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactGetItemsOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactGetItemsOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactWriteItemsInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactWriteItemsInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactWriteItemsOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactWriteItemsOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.UpdateItemInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.UpdateItemInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.UpdateItemOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.UpdateItemOutputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.UpdateTableInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.UpdateTableInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.UpdateTableOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.UpdateTableOutputTransformOutput;
import Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId;
import Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager;
import Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction;
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
import Wrappers_Compile.Option;
import dafny.DafnyMap;
import dafny.DafnySequence;
import java.lang.Character;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.dynamoDbEncryption.model.CollectionOfErrors;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionException;
import software.amazon.cryptography.dynamoDbEncryption.model.NativeError;
import software.amazon.cryptography.dynamoDbEncryption.model.OpaqueError;

public class ToDafny {
  public static Error Error(NativeError nativeValue) {
    if (nativeValue instanceof DynamoDbEncryptionException) {
      return ToDafny.Error((DynamoDbEncryptionException) nativeValue);
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

  public static UpdateTableInputTransformOutput UpdateTableInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.UpdateTableInputTransformOutput nativeValue) {
    UpdateTableInput transformedInput;
    transformedInput = com.amazonaws.dynamodb.ToDafny.UpdateTableInput(nativeValue.transformedInput());
    return new UpdateTableInputTransformOutput(transformedInput);
  }

  public static ExecuteStatementOutputTransformInput ExecuteStatementOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.ExecuteStatementOutputTransformInput nativeValue) {
    ExecuteStatementOutput sdkOutput;
    sdkOutput = com.amazonaws.dynamodb.ToDafny.ExecuteStatementOutput(nativeValue.sdkOutput());
    ExecuteStatementInput originalInput;
    originalInput = com.amazonaws.dynamodb.ToDafny.ExecuteStatementInput(nativeValue.originalInput());
    return new ExecuteStatementOutputTransformInput(sdkOutput, originalInput);
  }

  public static BatchWriteItemOutputTransformOutput BatchWriteItemOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchWriteItemOutputTransformOutput nativeValue) {
    BatchWriteItemOutput transformedOutput;
    transformedOutput = com.amazonaws.dynamodb.ToDafny.BatchWriteItemOutput(nativeValue.transformedOutput());
    return new BatchWriteItemOutputTransformOutput(transformedOutput);
  }

  public static GetItemOutputTransformInput GetItemOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.GetItemOutputTransformInput nativeValue) {
    GetItemOutput sdkOutput;
    sdkOutput = com.amazonaws.dynamodb.ToDafny.GetItemOutput(nativeValue.sdkOutput());
    GetItemInput originalInput;
    originalInput = com.amazonaws.dynamodb.ToDafny.GetItemInput(nativeValue.originalInput());
    return new GetItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static TransactGetItemsOutputTransformInput TransactGetItemsOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.TransactGetItemsOutputTransformInput nativeValue) {
    TransactGetItemsOutput sdkOutput;
    sdkOutput = com.amazonaws.dynamodb.ToDafny.TransactGetItemsOutput(nativeValue.sdkOutput());
    TransactGetItemsInput originalInput;
    originalInput = com.amazonaws.dynamodb.ToDafny.TransactGetItemsInput(nativeValue.originalInput());
    return new TransactGetItemsOutputTransformInput(sdkOutput, originalInput);
  }

  public static DynamoDbEncryptionConfig DynamoDbEncryptionConfig(
      software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionConfig nativeValue) {
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends DynamoDbTableEncryptionConfig> tableEncryptionConfigs;
    tableEncryptionConfigs = ToDafny.DynamoDbTableEncryptionConfigs(nativeValue.tableEncryptionConfigs());
    return new DynamoDbEncryptionConfig(tableEncryptionConfigs);
  }

  public static TransactWriteItemsOutputTransformOutput TransactWriteItemsOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.TransactWriteItemsOutputTransformOutput nativeValue) {
    TransactWriteItemsOutput transformedOutput;
    transformedOutput = com.amazonaws.dynamodb.ToDafny.TransactWriteItemsOutput(nativeValue.transformedOutput());
    return new TransactWriteItemsOutputTransformOutput(transformedOutput);
  }

  public static BatchExecuteStatementOutputTransformOutput BatchExecuteStatementOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchExecuteStatementOutputTransformOutput nativeValue) {
    BatchExecuteStatementOutput transformedOutput;
    transformedOutput = com.amazonaws.dynamodb.ToDafny.BatchExecuteStatementOutput(nativeValue.transformedOutput());
    return new BatchExecuteStatementOutputTransformOutput(transformedOutput);
  }

  public static ExecuteTransactionInputTransformInput ExecuteTransactionInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.ExecuteTransactionInputTransformInput nativeValue) {
    ExecuteTransactionInput sdkInput;
    sdkInput = com.amazonaws.dynamodb.ToDafny.ExecuteTransactionInput(nativeValue.sdkInput());
    return new ExecuteTransactionInputTransformInput(sdkInput);
  }

  public static BatchGetItemInputTransformInput BatchGetItemInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchGetItemInputTransformInput nativeValue) {
    BatchGetItemInput sdkInput;
    sdkInput = com.amazonaws.dynamodb.ToDafny.BatchGetItemInput(nativeValue.sdkInput());
    return new BatchGetItemInputTransformInput(sdkInput);
  }

  public static DescribeTableInputTransformInput DescribeTableInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.DescribeTableInputTransformInput nativeValue) {
    DescribeTableInput sdkInput;
    sdkInput = com.amazonaws.dynamodb.ToDafny.DescribeTableInput(nativeValue.sdkInput());
    return new DescribeTableInputTransformInput(sdkInput);
  }

  public static PutItemOutputTransformInput PutItemOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.PutItemOutputTransformInput nativeValue) {
    PutItemOutput sdkOutput;
    sdkOutput = com.amazonaws.dynamodb.ToDafny.PutItemOutput(nativeValue.sdkOutput());
    PutItemInput originalInput;
    originalInput = com.amazonaws.dynamodb.ToDafny.PutItemInput(nativeValue.originalInput());
    return new PutItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static UpdateTableOutputTransformInput UpdateTableOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.UpdateTableOutputTransformInput nativeValue) {
    UpdateTableOutput sdkOutput;
    sdkOutput = com.amazonaws.dynamodb.ToDafny.UpdateTableOutput(nativeValue.sdkOutput());
    UpdateTableInput originalInput;
    originalInput = com.amazonaws.dynamodb.ToDafny.UpdateTableInput(nativeValue.originalInput());
    return new UpdateTableOutputTransformInput(sdkOutput, originalInput);
  }

  public static TransactWriteItemsInputTransformInput TransactWriteItemsInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.TransactWriteItemsInputTransformInput nativeValue) {
    TransactWriteItemsInput sdkInput;
    sdkInput = com.amazonaws.dynamodb.ToDafny.TransactWriteItemsInput(nativeValue.sdkInput());
    return new TransactWriteItemsInputTransformInput(sdkInput);
  }

  public static TransactGetItemsInputTransformInput TransactGetItemsInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.TransactGetItemsInputTransformInput nativeValue) {
    TransactGetItemsInput sdkInput;
    sdkInput = com.amazonaws.dynamodb.ToDafny.TransactGetItemsInput(nativeValue.sdkInput());
    return new TransactGetItemsInputTransformInput(sdkInput);
  }

  public static PutItemOutputTransformOutput PutItemOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.PutItemOutputTransformOutput nativeValue) {
    PutItemOutput transformedOutput;
    transformedOutput = com.amazonaws.dynamodb.ToDafny.PutItemOutput(nativeValue.transformedOutput());
    return new PutItemOutputTransformOutput(transformedOutput);
  }

  public static DeleteItemInputTransformInput DeleteItemInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.DeleteItemInputTransformInput nativeValue) {
    DeleteItemInput sdkInput;
    sdkInput = com.amazonaws.dynamodb.ToDafny.DeleteItemInput(nativeValue.sdkInput());
    return new DeleteItemInputTransformInput(sdkInput);
  }

  public static PutItemInputTransformOutput PutItemInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.PutItemInputTransformOutput nativeValue) {
    PutItemInput transformedInput;
    transformedInput = com.amazonaws.dynamodb.ToDafny.PutItemInput(nativeValue.transformedInput());
    return new PutItemInputTransformOutput(transformedInput);
  }

  public static QueryOutputTransformInput QueryOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.QueryOutputTransformInput nativeValue) {
    QueryOutput sdkOutput;
    sdkOutput = com.amazonaws.dynamodb.ToDafny.QueryOutput(nativeValue.sdkOutput());
    QueryInput originalInput;
    originalInput = com.amazonaws.dynamodb.ToDafny.QueryInput(nativeValue.originalInput());
    return new QueryOutputTransformInput(sdkOutput, originalInput);
  }

  public static BatchExecuteStatementInputTransformOutput BatchExecuteStatementInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchExecuteStatementInputTransformOutput nativeValue) {
    BatchExecuteStatementInput transformedInput;
    transformedInput = com.amazonaws.dynamodb.ToDafny.BatchExecuteStatementInput(nativeValue.transformedInput());
    return new BatchExecuteStatementInputTransformOutput(transformedInput);
  }

  public static UpdateItemOutputTransformOutput UpdateItemOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.UpdateItemOutputTransformOutput nativeValue) {
    UpdateItemOutput transformedOutput;
    transformedOutput = com.amazonaws.dynamodb.ToDafny.UpdateItemOutput(nativeValue.transformedOutput());
    return new UpdateItemOutputTransformOutput(transformedOutput);
  }

  public static TransactWriteItemsOutputTransformInput TransactWriteItemsOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.TransactWriteItemsOutputTransformInput nativeValue) {
    TransactWriteItemsOutput sdkOutput;
    sdkOutput = com.amazonaws.dynamodb.ToDafny.TransactWriteItemsOutput(nativeValue.sdkOutput());
    TransactWriteItemsInput originalInput;
    originalInput = com.amazonaws.dynamodb.ToDafny.TransactWriteItemsInput(nativeValue.originalInput());
    return new TransactWriteItemsOutputTransformInput(sdkOutput, originalInput);
  }

  public static DeleteItemInputTransformOutput DeleteItemInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.DeleteItemInputTransformOutput nativeValue) {
    DeleteItemInput transformedInput;
    transformedInput = com.amazonaws.dynamodb.ToDafny.DeleteItemInput(nativeValue.transformedInput());
    return new DeleteItemInputTransformOutput(transformedInput);
  }

  public static DeleteItemOutputTransformOutput DeleteItemOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.DeleteItemOutputTransformOutput nativeValue) {
    DeleteItemOutput transformedOutput;
    transformedOutput = com.amazonaws.dynamodb.ToDafny.DeleteItemOutput(nativeValue.transformedOutput());
    return new DeleteItemOutputTransformOutput(transformedOutput);
  }

  public static QueryInputTransformOutput QueryInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.QueryInputTransformOutput nativeValue) {
    QueryInput transformedInput;
    transformedInput = com.amazonaws.dynamodb.ToDafny.QueryInput(nativeValue.transformedInput());
    return new QueryInputTransformOutput(transformedInput);
  }

  public static CreateTableInputTransformInput CreateTableInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.CreateTableInputTransformInput nativeValue) {
    CreateTableInput sdkInput;
    sdkInput = com.amazonaws.dynamodb.ToDafny.CreateTableInput(nativeValue.sdkInput());
    return new CreateTableInputTransformInput(sdkInput);
  }

  public static BatchExecuteStatementOutputTransformInput BatchExecuteStatementOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchExecuteStatementOutputTransformInput nativeValue) {
    BatchExecuteStatementOutput sdkOutput;
    sdkOutput = com.amazonaws.dynamodb.ToDafny.BatchExecuteStatementOutput(nativeValue.sdkOutput());
    BatchExecuteStatementInput originalInput;
    originalInput = com.amazonaws.dynamodb.ToDafny.BatchExecuteStatementInput(nativeValue.originalInput());
    return new BatchExecuteStatementOutputTransformInput(sdkOutput, originalInput);
  }

  public static BatchGetItemInputTransformOutput BatchGetItemInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchGetItemInputTransformOutput nativeValue) {
    BatchGetItemInput transformedInput;
    transformedInput = com.amazonaws.dynamodb.ToDafny.BatchGetItemInput(nativeValue.transformedInput());
    return new BatchGetItemInputTransformOutput(transformedInput);
  }

  public static UpdateTableOutputTransformOutput UpdateTableOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.UpdateTableOutputTransformOutput nativeValue) {
    UpdateTableOutput transformedOutput;
    transformedOutput = com.amazonaws.dynamodb.ToDafny.UpdateTableOutput(nativeValue.transformedOutput());
    return new UpdateTableOutputTransformOutput(transformedOutput);
  }

  public static QueryOutputTransformOutput QueryOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.QueryOutputTransformOutput nativeValue) {
    QueryOutput transformedOutput;
    transformedOutput = com.amazonaws.dynamodb.ToDafny.QueryOutput(nativeValue.transformedOutput());
    return new QueryOutputTransformOutput(transformedOutput);
  }

  public static GetItemInputTransformOutput GetItemInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.GetItemInputTransformOutput nativeValue) {
    GetItemInput transformedInput;
    transformedInput = com.amazonaws.dynamodb.ToDafny.GetItemInput(nativeValue.transformedInput());
    return new GetItemInputTransformOutput(transformedInput);
  }

  public static TransactWriteItemsInputTransformOutput TransactWriteItemsInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.TransactWriteItemsInputTransformOutput nativeValue) {
    TransactWriteItemsInput transformedInput;
    transformedInput = com.amazonaws.dynamodb.ToDafny.TransactWriteItemsInput(nativeValue.transformedInput());
    return new TransactWriteItemsInputTransformOutput(transformedInput);
  }

  public static BatchGetItemOutputTransformInput BatchGetItemOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchGetItemOutputTransformInput nativeValue) {
    BatchGetItemOutput sdkOutput;
    sdkOutput = com.amazonaws.dynamodb.ToDafny.BatchGetItemOutput(nativeValue.sdkOutput());
    BatchGetItemInput originalInput;
    originalInput = com.amazonaws.dynamodb.ToDafny.BatchGetItemInput(nativeValue.originalInput());
    return new BatchGetItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static BatchGetItemOutputTransformOutput BatchGetItemOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchGetItemOutputTransformOutput nativeValue) {
    BatchGetItemOutput transformedOutput;
    transformedOutput = com.amazonaws.dynamodb.ToDafny.BatchGetItemOutput(nativeValue.transformedOutput());
    return new BatchGetItemOutputTransformOutput(transformedOutput);
  }

  public static BatchExecuteStatementInputTransformInput BatchExecuteStatementInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchExecuteStatementInputTransformInput nativeValue) {
    BatchExecuteStatementInput sdkInput;
    sdkInput = com.amazonaws.dynamodb.ToDafny.BatchExecuteStatementInput(nativeValue.sdkInput());
    return new BatchExecuteStatementInputTransformInput(sdkInput);
  }

  public static DeleteItemOutputTransformInput DeleteItemOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.DeleteItemOutputTransformInput nativeValue) {
    DeleteItemOutput sdkOutput;
    sdkOutput = com.amazonaws.dynamodb.ToDafny.DeleteItemOutput(nativeValue.sdkOutput());
    DeleteItemInput originalInput;
    originalInput = com.amazonaws.dynamodb.ToDafny.DeleteItemInput(nativeValue.originalInput());
    return new DeleteItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static ScanInputTransformOutput ScanInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.ScanInputTransformOutput nativeValue) {
    ScanInput transformedInput;
    transformedInput = com.amazonaws.dynamodb.ToDafny.ScanInput(nativeValue.transformedInput());
    return new ScanInputTransformOutput(transformedInput);
  }

  public static TransactGetItemsOutputTransformOutput TransactGetItemsOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.TransactGetItemsOutputTransformOutput nativeValue) {
    TransactGetItemsOutput transformedOutput;
    transformedOutput = com.amazonaws.dynamodb.ToDafny.TransactGetItemsOutput(nativeValue.transformedOutput());
    return new TransactGetItemsOutputTransformOutput(transformedOutput);
  }

  public static GetItemInputTransformInput GetItemInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.GetItemInputTransformInput nativeValue) {
    GetItemInput sdkInput;
    sdkInput = com.amazonaws.dynamodb.ToDafny.GetItemInput(nativeValue.sdkInput());
    return new GetItemInputTransformInput(sdkInput);
  }

  public static PutItemInputTransformInput PutItemInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.PutItemInputTransformInput nativeValue) {
    PutItemInput sdkInput;
    sdkInput = com.amazonaws.dynamodb.ToDafny.PutItemInput(nativeValue.sdkInput());
    return new PutItemInputTransformInput(sdkInput);
  }

  public static ScanOutputTransformInput ScanOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.ScanOutputTransformInput nativeValue) {
    ScanOutput sdkOutput;
    sdkOutput = com.amazonaws.dynamodb.ToDafny.ScanOutput(nativeValue.sdkOutput());
    ScanInput originalInput;
    originalInput = com.amazonaws.dynamodb.ToDafny.ScanInput(nativeValue.originalInput());
    return new ScanOutputTransformInput(sdkOutput, originalInput);
  }

  public static DynamoDbTableEncryptionConfig DynamoDbTableEncryptionConfig(
      software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTableEncryptionConfig nativeValue) {
    DafnySequence<? extends Character> partitionKeyName;
    partitionKeyName = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.partitionKeyName());
    Option<DafnySequence<? extends Character>> sortKeyName;
    sortKeyName = Objects.nonNull(nativeValue.sortKeyName()) ?
        Option.create_Some(software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.sortKeyName()))
        : Option.create_None();
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends CryptoAction> attributeActions;
    attributeActions = software.amazon.cryptography.dynamoDbItemEncryptor.ToDafny.AttributeActions(nativeValue.attributeActions());
    Option<DafnySequence<? extends DafnySequence<? extends Character>>> allowedUnauthenticatedAttributes;
    allowedUnauthenticatedAttributes = Objects.nonNull(nativeValue.allowedUnauthenticatedAttributes()) ?
        Option.create_Some(com.amazonaws.dynamodb.ToDafny.AttributeNameList(nativeValue.allowedUnauthenticatedAttributes()))
        : Option.create_None();
    Option<DafnySequence<? extends Character>> allowedUnauthenticatedAttributePrefix;
    allowedUnauthenticatedAttributePrefix = Objects.nonNull(nativeValue.allowedUnauthenticatedAttributePrefix()) ?
        Option.create_Some(software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.allowedUnauthenticatedAttributePrefix()))
        : Option.create_None();
    Option<DBEAlgorithmSuiteId> algorithmSuiteId;
    algorithmSuiteId = Objects.nonNull(nativeValue.algorithmSuiteId()) ?
        Option.create_Some(software.amazon.cryptography.materialProviders.ToDafny.DBEAlgorithmSuiteId(nativeValue.algorithmSuiteId()))
        : Option.create_None();
    Option<IKeyring> keyring;
    keyring = Objects.nonNull(nativeValue.keyring()) ?
        Option.create_Some((nativeValue.keyring()))
        : Option.create_None();
    Option<ICryptographicMaterialsManager> cmm;
    cmm = Objects.nonNull(nativeValue.cmm()) ?
        Option.create_Some((nativeValue.cmm()))
        : Option.create_None();
    return new DynamoDbTableEncryptionConfig(partitionKeyName, sortKeyName, attributeActions, allowedUnauthenticatedAttributes, allowedUnauthenticatedAttributePrefix, algorithmSuiteId, keyring, cmm);
  }

  public static GetItemOutputTransformOutput GetItemOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.GetItemOutputTransformOutput nativeValue) {
    GetItemOutput transformedOutput;
    transformedOutput = com.amazonaws.dynamodb.ToDafny.GetItemOutput(nativeValue.transformedOutput());
    return new GetItemOutputTransformOutput(transformedOutput);
  }

  public static ScanInputTransformInput ScanInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.ScanInputTransformInput nativeValue) {
    ScanInput sdkInput;
    sdkInput = com.amazonaws.dynamodb.ToDafny.ScanInput(nativeValue.sdkInput());
    return new ScanInputTransformInput(sdkInput);
  }

  public static DescribeTableOutputTransformOutput DescribeTableOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.DescribeTableOutputTransformOutput nativeValue) {
    DescribeTableOutput transformedOutput;
    transformedOutput = com.amazonaws.dynamodb.ToDafny.DescribeTableOutput(nativeValue.transformedOutput());
    return new DescribeTableOutputTransformOutput(transformedOutput);
  }

  public static ScanOutputTransformOutput ScanOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.ScanOutputTransformOutput nativeValue) {
    ScanOutput transformedOutput;
    transformedOutput = com.amazonaws.dynamodb.ToDafny.ScanOutput(nativeValue.transformedOutput());
    return new ScanOutputTransformOutput(transformedOutput);
  }

  public static UpdateItemInputTransformInput UpdateItemInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.UpdateItemInputTransformInput nativeValue) {
    UpdateItemInput sdkInput;
    sdkInput = com.amazonaws.dynamodb.ToDafny.UpdateItemInput(nativeValue.sdkInput());
    return new UpdateItemInputTransformInput(sdkInput);
  }

  public static TransactGetItemsInputTransformOutput TransactGetItemsInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.TransactGetItemsInputTransformOutput nativeValue) {
    TransactGetItemsInput transformedInput;
    transformedInput = com.amazonaws.dynamodb.ToDafny.TransactGetItemsInput(nativeValue.transformedInput());
    return new TransactGetItemsInputTransformOutput(transformedInput);
  }

  public static BatchWriteItemInputTransformOutput BatchWriteItemInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchWriteItemInputTransformOutput nativeValue) {
    BatchWriteItemInput transformedInput;
    transformedInput = com.amazonaws.dynamodb.ToDafny.BatchWriteItemInput(nativeValue.transformedInput());
    return new BatchWriteItemInputTransformOutput(transformedInput);
  }

  public static CreateTableInputTransformOutput CreateTableInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.CreateTableInputTransformOutput nativeValue) {
    CreateTableInput transformedInput;
    transformedInput = com.amazonaws.dynamodb.ToDafny.CreateTableInput(nativeValue.transformedInput());
    return new CreateTableInputTransformOutput(transformedInput);
  }

  public static DescribeTableInputTransformOutput DescribeTableInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.DescribeTableInputTransformOutput nativeValue) {
    DescribeTableInput transformedInput;
    transformedInput = com.amazonaws.dynamodb.ToDafny.DescribeTableInput(nativeValue.transformedInput());
    return new DescribeTableInputTransformOutput(transformedInput);
  }

  public static ExecuteStatementInputTransformOutput ExecuteStatementInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.ExecuteStatementInputTransformOutput nativeValue) {
    ExecuteStatementInput transformedInput;
    transformedInput = com.amazonaws.dynamodb.ToDafny.ExecuteStatementInput(nativeValue.transformedInput());
    return new ExecuteStatementInputTransformOutput(transformedInput);
  }

  public static QueryInputTransformInput QueryInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.QueryInputTransformInput nativeValue) {
    QueryInput sdkInput;
    sdkInput = com.amazonaws.dynamodb.ToDafny.QueryInput(nativeValue.sdkInput());
    return new QueryInputTransformInput(sdkInput);
  }

  public static UpdateItemOutputTransformInput UpdateItemOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.UpdateItemOutputTransformInput nativeValue) {
    UpdateItemOutput sdkOutput;
    sdkOutput = com.amazonaws.dynamodb.ToDafny.UpdateItemOutput(nativeValue.sdkOutput());
    UpdateItemInput originalInput;
    originalInput = com.amazonaws.dynamodb.ToDafny.UpdateItemInput(nativeValue.originalInput());
    return new UpdateItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static ExecuteTransactionOutputTransformOutput ExecuteTransactionOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.ExecuteTransactionOutputTransformOutput nativeValue) {
    ExecuteTransactionOutput transformedOutput;
    transformedOutput = com.amazonaws.dynamodb.ToDafny.ExecuteTransactionOutput(nativeValue.transformedOutput());
    return new ExecuteTransactionOutputTransformOutput(transformedOutput);
  }

  public static ExecuteTransactionOutputTransformInput ExecuteTransactionOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.ExecuteTransactionOutputTransformInput nativeValue) {
    ExecuteTransactionOutput sdkOutput;
    sdkOutput = com.amazonaws.dynamodb.ToDafny.ExecuteTransactionOutput(nativeValue.sdkOutput());
    ExecuteTransactionInput originalInput;
    originalInput = com.amazonaws.dynamodb.ToDafny.ExecuteTransactionInput(nativeValue.originalInput());
    return new ExecuteTransactionOutputTransformInput(sdkOutput, originalInput);
  }

  public static CreateTableOutputTransformOutput CreateTableOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.CreateTableOutputTransformOutput nativeValue) {
    CreateTableOutput transformedOutput;
    transformedOutput = com.amazonaws.dynamodb.ToDafny.CreateTableOutput(nativeValue.transformedOutput());
    return new CreateTableOutputTransformOutput(transformedOutput);
  }

  public static UpdateTableInputTransformInput UpdateTableInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.UpdateTableInputTransformInput nativeValue) {
    UpdateTableInput sdkInput;
    sdkInput = com.amazonaws.dynamodb.ToDafny.UpdateTableInput(nativeValue.sdkInput());
    return new UpdateTableInputTransformInput(sdkInput);
  }

  public static BatchWriteItemOutputTransformInput BatchWriteItemOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchWriteItemOutputTransformInput nativeValue) {
    BatchWriteItemOutput sdkOutput;
    sdkOutput = com.amazonaws.dynamodb.ToDafny.BatchWriteItemOutput(nativeValue.sdkOutput());
    BatchWriteItemInput originalInput;
    originalInput = com.amazonaws.dynamodb.ToDafny.BatchWriteItemInput(nativeValue.originalInput());
    return new BatchWriteItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static UpdateItemInputTransformOutput UpdateItemInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.UpdateItemInputTransformOutput nativeValue) {
    UpdateItemInput transformedInput;
    transformedInput = com.amazonaws.dynamodb.ToDafny.UpdateItemInput(nativeValue.transformedInput());
    return new UpdateItemInputTransformOutput(transformedInput);
  }

  public static CreateTableOutputTransformInput CreateTableOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.CreateTableOutputTransformInput nativeValue) {
    CreateTableOutput sdkOutput;
    sdkOutput = com.amazonaws.dynamodb.ToDafny.CreateTableOutput(nativeValue.sdkOutput());
    CreateTableInput originalInput;
    originalInput = com.amazonaws.dynamodb.ToDafny.CreateTableInput(nativeValue.originalInput());
    return new CreateTableOutputTransformInput(sdkOutput, originalInput);
  }

  public static DescribeTableOutputTransformInput DescribeTableOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.DescribeTableOutputTransformInput nativeValue) {
    DescribeTableOutput sdkOutput;
    sdkOutput = com.amazonaws.dynamodb.ToDafny.DescribeTableOutput(nativeValue.sdkOutput());
    DescribeTableInput originalInput;
    originalInput = com.amazonaws.dynamodb.ToDafny.DescribeTableInput(nativeValue.originalInput());
    return new DescribeTableOutputTransformInput(sdkOutput, originalInput);
  }

  public static ExecuteStatementInputTransformInput ExecuteStatementInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.ExecuteStatementInputTransformInput nativeValue) {
    ExecuteStatementInput sdkInput;
    sdkInput = com.amazonaws.dynamodb.ToDafny.ExecuteStatementInput(nativeValue.sdkInput());
    return new ExecuteStatementInputTransformInput(sdkInput);
  }

  public static ExecuteStatementOutputTransformOutput ExecuteStatementOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.ExecuteStatementOutputTransformOutput nativeValue) {
    ExecuteStatementOutput transformedOutput;
    transformedOutput = com.amazonaws.dynamodb.ToDafny.ExecuteStatementOutput(nativeValue.transformedOutput());
    return new ExecuteStatementOutputTransformOutput(transformedOutput);
  }

  public static ExecuteTransactionInputTransformOutput ExecuteTransactionInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.ExecuteTransactionInputTransformOutput nativeValue) {
    ExecuteTransactionInput transformedInput;
    transformedInput = com.amazonaws.dynamodb.ToDafny.ExecuteTransactionInput(nativeValue.transformedInput());
    return new ExecuteTransactionInputTransformOutput(transformedInput);
  }

  public static BatchWriteItemInputTransformInput BatchWriteItemInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchWriteItemInputTransformInput nativeValue) {
    BatchWriteItemInput sdkInput;
    sdkInput = com.amazonaws.dynamodb.ToDafny.BatchWriteItemInput(nativeValue.sdkInput());
    return new BatchWriteItemInputTransformInput(sdkInput);
  }

  public static Error Error(DynamoDbEncryptionException nativeValue) {
    DafnySequence<? extends Character> message;
    message = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.message());
    return new Error_DynamoDbEncryptionException(message);
  }

  public static DafnyMap<? extends DafnySequence<? extends Character>, ? extends DynamoDbTableEncryptionConfig> DynamoDbTableEncryptionConfigs(
      Map<String, software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTableEncryptionConfig> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToMap(
        nativeValue, 
        software.amazon.dafny.conversion.ToDafny.Simple::CharacterSequence, 
        software.amazon.cryptography.dynamoDbEncryption.ToDafny::DynamoDbTableEncryptionConfig);
  }
}
