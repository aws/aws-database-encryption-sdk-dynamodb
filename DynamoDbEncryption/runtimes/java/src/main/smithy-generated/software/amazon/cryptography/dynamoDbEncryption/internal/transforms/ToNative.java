// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.internal.transforms;

import Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.Error;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.Error_CollectionOfErrors;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.Error_Opaque;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.BatchExecuteStatementInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.BatchExecuteStatementInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.BatchExecuteStatementOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.BatchExecuteStatementOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.BatchGetItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.BatchGetItemInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.BatchGetItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.BatchGetItemOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.BatchWriteItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.BatchWriteItemInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.BatchWriteItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.BatchWriteItemOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.CollectionOfErrors;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.CreateTableInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.CreateTableInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.CreateTableOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.CreateTableOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.DeleteItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.DeleteItemInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.DeleteItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.DeleteItemOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.DescribeTableInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.DescribeTableInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.DescribeTableOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.DescribeTableOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.ExecuteStatementInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.ExecuteStatementInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.ExecuteStatementOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.ExecuteStatementOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.ExecuteTransactionInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.ExecuteTransactionInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.ExecuteTransactionOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.ExecuteTransactionOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.GetItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.GetItemInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.GetItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.GetItemOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.NativeError;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.OpaqueError;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.PutItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.PutItemInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.PutItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.PutItemOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.QueryInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.QueryInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.QueryOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.QueryOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.ScanInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.ScanInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.ScanOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.ScanOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.TransactGetItemsInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.TransactGetItemsInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.TransactGetItemsOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.TransactGetItemsOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.TransactWriteItemsInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.TransactWriteItemsInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.TransactWriteItemsOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.TransactWriteItemsOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.UpdateItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.UpdateItemInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.UpdateItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.UpdateItemOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.UpdateTableInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.UpdateTableInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.UpdateTableOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model.UpdateTableOutputTransformOutput;

public class ToNative {
  public static OpaqueError Error(Error_Opaque dafnyValue) {
    OpaqueError.Builder nativeBuilder = OpaqueError.builder();
    nativeBuilder.obj(dafnyValue.dtor_obj());
    return nativeBuilder.build();
  }

  public static CollectionOfErrors Error(Error_CollectionOfErrors dafnyValue) {
    CollectionOfErrors.Builder nativeBuilder = CollectionOfErrors.builder();
    nativeBuilder.list(
        software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue.dtor_list(), 
        ToNative::Error));
    return nativeBuilder.build();
  }

  public static NativeError Error(Error dafnyValue) {
    if (dafnyValue.is_Opaque()) {
      return ToNative.Error((Error_Opaque) dafnyValue);
    }
    if (dafnyValue.is_CollectionOfErrors()) {
      return ToNative.Error((Error_CollectionOfErrors) dafnyValue);
    }
    OpaqueError.Builder nativeBuilder = OpaqueError.builder();
    nativeBuilder.obj(dafnyValue);
    return nativeBuilder.build();
  }

  public static ExecuteStatementOutputTransformInput ExecuteStatementOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ExecuteStatementOutputTransformInput dafnyValue) {
    ExecuteStatementOutputTransformInput.Builder nativeBuilder = ExecuteStatementOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteStatementOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteStatementInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static TransactWriteItemsOutputTransformOutput TransactWriteItemsOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.TransactWriteItemsOutputTransformOutput dafnyValue) {
    TransactWriteItemsOutputTransformOutput.Builder nativeBuilder = TransactWriteItemsOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactWriteItemsOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static UpdateTableInputTransformOutput UpdateTableInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.UpdateTableInputTransformOutput dafnyValue) {
    UpdateTableInputTransformOutput.Builder nativeBuilder = UpdateTableInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateTableInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static PutItemOutputTransformInput PutItemOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.PutItemOutputTransformInput dafnyValue) {
    PutItemOutputTransformInput.Builder nativeBuilder = PutItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.PutItemOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.PutItemInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static DescribeTableInputTransformInput DescribeTableInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.DescribeTableInputTransformInput dafnyValue) {
    DescribeTableInputTransformInput.Builder nativeBuilder = DescribeTableInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DescribeTableInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static QueryOutputTransformOutput QueryOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.QueryOutputTransformOutput dafnyValue) {
    QueryOutputTransformOutput.Builder nativeBuilder = QueryOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.QueryOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static UpdateTableInputTransformInput UpdateTableInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.UpdateTableInputTransformInput dafnyValue) {
    UpdateTableInputTransformInput.Builder nativeBuilder = UpdateTableInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateTableInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static DeleteItemOutputTransformOutput DeleteItemOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.DeleteItemOutputTransformOutput dafnyValue) {
    DeleteItemOutputTransformOutput.Builder nativeBuilder = DeleteItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DeleteItemOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static TransactWriteItemsInputTransformInput TransactWriteItemsInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.TransactWriteItemsInputTransformInput dafnyValue) {
    TransactWriteItemsInputTransformInput.Builder nativeBuilder = TransactWriteItemsInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactWriteItemsInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static DescribeTableOutputTransformInput DescribeTableOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.DescribeTableOutputTransformInput dafnyValue) {
    DescribeTableOutputTransformInput.Builder nativeBuilder = DescribeTableOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DescribeTableOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DescribeTableInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static CreateTableOutputTransformInput CreateTableOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.CreateTableOutputTransformInput dafnyValue) {
    CreateTableOutputTransformInput.Builder nativeBuilder = CreateTableOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.CreateTableOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.CreateTableInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static PutItemOutputTransformOutput PutItemOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.PutItemOutputTransformOutput dafnyValue) {
    PutItemOutputTransformOutput.Builder nativeBuilder = PutItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.PutItemOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static BatchExecuteStatementInputTransformOutput BatchExecuteStatementInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchExecuteStatementInputTransformOutput dafnyValue) {
    BatchExecuteStatementInputTransformOutput.Builder nativeBuilder = BatchExecuteStatementInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchExecuteStatementInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static ExecuteTransactionOutputTransformOutput ExecuteTransactionOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ExecuteTransactionOutputTransformOutput dafnyValue) {
    ExecuteTransactionOutputTransformOutput.Builder nativeBuilder = ExecuteTransactionOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteTransactionOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static BatchExecuteStatementOutputTransformOutput BatchExecuteStatementOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchExecuteStatementOutputTransformOutput dafnyValue) {
    BatchExecuteStatementOutputTransformOutput.Builder nativeBuilder = BatchExecuteStatementOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchExecuteStatementOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static ExecuteTransactionInputTransformInput ExecuteTransactionInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ExecuteTransactionInputTransformInput dafnyValue) {
    ExecuteTransactionInputTransformInput.Builder nativeBuilder = ExecuteTransactionInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteTransactionInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static ExecuteStatementInputTransformOutput ExecuteStatementInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ExecuteStatementInputTransformOutput dafnyValue) {
    ExecuteStatementInputTransformOutput.Builder nativeBuilder = ExecuteStatementInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteStatementInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static BatchWriteItemInputTransformOutput BatchWriteItemInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchWriteItemInputTransformOutput dafnyValue) {
    BatchWriteItemInputTransformOutput.Builder nativeBuilder = BatchWriteItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchWriteItemInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static ExecuteStatementInputTransformInput ExecuteStatementInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ExecuteStatementInputTransformInput dafnyValue) {
    ExecuteStatementInputTransformInput.Builder nativeBuilder = ExecuteStatementInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteStatementInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static ExecuteTransactionInputTransformOutput ExecuteTransactionInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ExecuteTransactionInputTransformOutput dafnyValue) {
    ExecuteTransactionInputTransformOutput.Builder nativeBuilder = ExecuteTransactionInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteTransactionInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static DescribeTableInputTransformOutput DescribeTableInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.DescribeTableInputTransformOutput dafnyValue) {
    DescribeTableInputTransformOutput.Builder nativeBuilder = DescribeTableInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DescribeTableInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static TransactGetItemsInputTransformOutput TransactGetItemsInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.TransactGetItemsInputTransformOutput dafnyValue) {
    TransactGetItemsInputTransformOutput.Builder nativeBuilder = TransactGetItemsInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactGetItemsInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static CreateTableInputTransformOutput CreateTableInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.CreateTableInputTransformOutput dafnyValue) {
    CreateTableInputTransformOutput.Builder nativeBuilder = CreateTableInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.CreateTableInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static ExecuteStatementOutputTransformOutput ExecuteStatementOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ExecuteStatementOutputTransformOutput dafnyValue) {
    ExecuteStatementOutputTransformOutput.Builder nativeBuilder = ExecuteStatementOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteStatementOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static ScanOutputTransformOutput ScanOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ScanOutputTransformOutput dafnyValue) {
    ScanOutputTransformOutput.Builder nativeBuilder = ScanOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ScanOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static ScanOutputTransformInput ScanOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ScanOutputTransformInput dafnyValue) {
    ScanOutputTransformInput.Builder nativeBuilder = ScanOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ScanOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ScanInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static UpdateItemOutputTransformInput UpdateItemOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.UpdateItemOutputTransformInput dafnyValue) {
    UpdateItemOutputTransformInput.Builder nativeBuilder = UpdateItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateItemOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateItemInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static ExecuteTransactionOutputTransformInput ExecuteTransactionOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ExecuteTransactionOutputTransformInput dafnyValue) {
    ExecuteTransactionOutputTransformInput.Builder nativeBuilder = ExecuteTransactionOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteTransactionOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteTransactionInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static BatchGetItemInputTransformInput BatchGetItemInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchGetItemInputTransformInput dafnyValue) {
    BatchGetItemInputTransformInput.Builder nativeBuilder = BatchGetItemInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchGetItemInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static CreateTableOutputTransformOutput CreateTableOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.CreateTableOutputTransformOutput dafnyValue) {
    CreateTableOutputTransformOutput.Builder nativeBuilder = CreateTableOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.CreateTableOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static ScanInputTransformOutput ScanInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ScanInputTransformOutput dafnyValue) {
    ScanInputTransformOutput.Builder nativeBuilder = ScanInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ScanInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static UpdateItemInputTransformOutput UpdateItemInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.UpdateItemInputTransformOutput dafnyValue) {
    UpdateItemInputTransformOutput.Builder nativeBuilder = UpdateItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateItemInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static QueryInputTransformInput QueryInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.QueryInputTransformInput dafnyValue) {
    QueryInputTransformInput.Builder nativeBuilder = QueryInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.QueryInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static TransactGetItemsOutputTransformInput TransactGetItemsOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.TransactGetItemsOutputTransformInput dafnyValue) {
    TransactGetItemsOutputTransformInput.Builder nativeBuilder = TransactGetItemsOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactGetItemsOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactGetItemsInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static BatchGetItemOutputTransformInput BatchGetItemOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchGetItemOutputTransformInput dafnyValue) {
    BatchGetItemOutputTransformInput.Builder nativeBuilder = BatchGetItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchGetItemOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchGetItemInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static TransactWriteItemsInputTransformOutput TransactWriteItemsInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.TransactWriteItemsInputTransformOutput dafnyValue) {
    TransactWriteItemsInputTransformOutput.Builder nativeBuilder = TransactWriteItemsInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactWriteItemsInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static TransactGetItemsOutputTransformOutput TransactGetItemsOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.TransactGetItemsOutputTransformOutput dafnyValue) {
    TransactGetItemsOutputTransformOutput.Builder nativeBuilder = TransactGetItemsOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactGetItemsOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static ScanInputTransformInput ScanInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ScanInputTransformInput dafnyValue) {
    ScanInputTransformInput.Builder nativeBuilder = ScanInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ScanInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static BatchWriteItemInputTransformInput BatchWriteItemInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchWriteItemInputTransformInput dafnyValue) {
    BatchWriteItemInputTransformInput.Builder nativeBuilder = BatchWriteItemInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchWriteItemInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static UpdateTableOutputTransformOutput UpdateTableOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.UpdateTableOutputTransformOutput dafnyValue) {
    UpdateTableOutputTransformOutput.Builder nativeBuilder = UpdateTableOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateTableOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static DeleteItemOutputTransformInput DeleteItemOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.DeleteItemOutputTransformInput dafnyValue) {
    DeleteItemOutputTransformInput.Builder nativeBuilder = DeleteItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DeleteItemOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DeleteItemInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static BatchExecuteStatementInputTransformInput BatchExecuteStatementInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchExecuteStatementInputTransformInput dafnyValue) {
    BatchExecuteStatementInputTransformInput.Builder nativeBuilder = BatchExecuteStatementInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchExecuteStatementInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static PutItemInputTransformInput PutItemInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.PutItemInputTransformInput dafnyValue) {
    PutItemInputTransformInput.Builder nativeBuilder = PutItemInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.PutItemInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static DeleteItemInputTransformOutput DeleteItemInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.DeleteItemInputTransformOutput dafnyValue) {
    DeleteItemInputTransformOutput.Builder nativeBuilder = DeleteItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DeleteItemInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static DescribeTableOutputTransformOutput DescribeTableOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.DescribeTableOutputTransformOutput dafnyValue) {
    DescribeTableOutputTransformOutput.Builder nativeBuilder = DescribeTableOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DescribeTableOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static UpdateItemOutputTransformOutput UpdateItemOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.UpdateItemOutputTransformOutput dafnyValue) {
    UpdateItemOutputTransformOutput.Builder nativeBuilder = UpdateItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateItemOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static BatchWriteItemOutputTransformInput BatchWriteItemOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchWriteItemOutputTransformInput dafnyValue) {
    BatchWriteItemOutputTransformInput.Builder nativeBuilder = BatchWriteItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchWriteItemOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchWriteItemInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static BatchGetItemOutputTransformOutput BatchGetItemOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchGetItemOutputTransformOutput dafnyValue) {
    BatchGetItemOutputTransformOutput.Builder nativeBuilder = BatchGetItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchGetItemOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static PutItemInputTransformOutput PutItemInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.PutItemInputTransformOutput dafnyValue) {
    PutItemInputTransformOutput.Builder nativeBuilder = PutItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.PutItemInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static TransactGetItemsInputTransformInput TransactGetItemsInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.TransactGetItemsInputTransformInput dafnyValue) {
    TransactGetItemsInputTransformInput.Builder nativeBuilder = TransactGetItemsInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactGetItemsInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static GetItemInputTransformOutput GetItemInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.GetItemInputTransformOutput dafnyValue) {
    GetItemInputTransformOutput.Builder nativeBuilder = GetItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.GetItemInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static GetItemOutputTransformOutput GetItemOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.GetItemOutputTransformOutput dafnyValue) {
    GetItemOutputTransformOutput.Builder nativeBuilder = GetItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.GetItemOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static DeleteItemInputTransformInput DeleteItemInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.DeleteItemInputTransformInput dafnyValue) {
    DeleteItemInputTransformInput.Builder nativeBuilder = DeleteItemInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DeleteItemInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static BatchGetItemInputTransformOutput BatchGetItemInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchGetItemInputTransformOutput dafnyValue) {
    BatchGetItemInputTransformOutput.Builder nativeBuilder = BatchGetItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchGetItemInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static UpdateItemInputTransformInput UpdateItemInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.UpdateItemInputTransformInput dafnyValue) {
    UpdateItemInputTransformInput.Builder nativeBuilder = UpdateItemInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateItemInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static BatchExecuteStatementOutputTransformInput BatchExecuteStatementOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchExecuteStatementOutputTransformInput dafnyValue) {
    BatchExecuteStatementOutputTransformInput.Builder nativeBuilder = BatchExecuteStatementOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchExecuteStatementOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchExecuteStatementInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static UpdateTableOutputTransformInput UpdateTableOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.UpdateTableOutputTransformInput dafnyValue) {
    UpdateTableOutputTransformInput.Builder nativeBuilder = UpdateTableOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateTableOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateTableInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static QueryInputTransformOutput QueryInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.QueryInputTransformOutput dafnyValue) {
    QueryInputTransformOutput.Builder nativeBuilder = QueryInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.QueryInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static GetItemOutputTransformInput GetItemOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.GetItemOutputTransformInput dafnyValue) {
    GetItemOutputTransformInput.Builder nativeBuilder = GetItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.GetItemOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.GetItemInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static GetItemInputTransformInput GetItemInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.GetItemInputTransformInput dafnyValue) {
    GetItemInputTransformInput.Builder nativeBuilder = GetItemInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.GetItemInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static CreateTableInputTransformInput CreateTableInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.CreateTableInputTransformInput dafnyValue) {
    CreateTableInputTransformInput.Builder nativeBuilder = CreateTableInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.CreateTableInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static BatchWriteItemOutputTransformOutput BatchWriteItemOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchWriteItemOutputTransformOutput dafnyValue) {
    BatchWriteItemOutputTransformOutput.Builder nativeBuilder = BatchWriteItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchWriteItemOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static TransactWriteItemsOutputTransformInput TransactWriteItemsOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.TransactWriteItemsOutputTransformInput dafnyValue) {
    TransactWriteItemsOutputTransformInput.Builder nativeBuilder = TransactWriteItemsOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactWriteItemsOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactWriteItemsInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static QueryOutputTransformInput QueryOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.QueryOutputTransformInput dafnyValue) {
    QueryOutputTransformInput.Builder nativeBuilder = QueryOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.QueryOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.QueryInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }
}
