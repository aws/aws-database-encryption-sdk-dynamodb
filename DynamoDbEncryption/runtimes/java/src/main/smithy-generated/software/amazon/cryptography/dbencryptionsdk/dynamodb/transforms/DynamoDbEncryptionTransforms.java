// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms;

import Wrappers_Compile.Result;
import java.lang.IllegalArgumentException;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.__default;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.IDynamoDbEncryptionTransformsClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchExecuteStatementInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchExecuteStatementInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchExecuteStatementOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchExecuteStatementOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchGetItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchGetItemInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchGetItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchGetItemOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchWriteItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchWriteItemInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchWriteItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchWriteItemOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.CreateTableInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.CreateTableInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.CreateTableOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.CreateTableOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.DeleteItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.DeleteItemInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.DeleteItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.DeleteItemOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.DescribeTableInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.DescribeTableInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.DescribeTableOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.DescribeTableOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteStatementInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteStatementInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteStatementOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteStatementOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteTransactionInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteTransactionInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteTransactionOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteTransactionOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.GetItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.GetItemInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.GetItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.GetItemOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.PutItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.PutItemInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.PutItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.PutItemOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.QueryInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.QueryInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.QueryOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.QueryOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ScanInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ScanInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ScanOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ScanOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactGetItemsInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactGetItemsInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactGetItemsOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactGetItemsOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactWriteItemsInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactWriteItemsInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactWriteItemsOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactWriteItemsOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.UpdateItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.UpdateItemInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.UpdateItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.UpdateItemOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.UpdateTableInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.UpdateTableInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.UpdateTableOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.UpdateTableOutputTransformOutput;

public class DynamoDbEncryptionTransforms {
  private final IDynamoDbEncryptionTransformsClient _impl;

  protected DynamoDbEncryptionTransforms(BuilderImpl builder) {
    DynamoDbTablesEncryptionConfig nativeValue = builder.DynamoDbTablesEncryptionConfig();
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTablesEncryptionConfig dafnyValue = software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny.DynamoDbTablesEncryptionConfig(nativeValue);
    Result<DynamoDbEncryptionTransformsClient, Error> result = __default.DynamoDbEncryptionTransforms(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    this._impl = result.dtor_value();
  }

  DynamoDbEncryptionTransforms(IDynamoDbEncryptionTransformsClient impl) {
    this._impl = impl;
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public BatchExecuteStatementInputTransformOutput BatchExecuteStatementInputTransform(
      BatchExecuteStatementInputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformInput dafnyValue = ToDafny.BatchExecuteStatementInputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput, Error> result = this._impl.BatchExecuteStatementInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchExecuteStatementInputTransformOutput(result.dtor_value());
  }

  public BatchExecuteStatementOutputTransformOutput BatchExecuteStatementOutputTransform(
      BatchExecuteStatementOutputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformInput dafnyValue = ToDafny.BatchExecuteStatementOutputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput, Error> result = this._impl.BatchExecuteStatementOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchExecuteStatementOutputTransformOutput(result.dtor_value());
  }

  public BatchGetItemInputTransformOutput BatchGetItemInputTransform(
      BatchGetItemInputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemInputTransformInput dafnyValue = ToDafny.BatchGetItemInputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemInputTransformOutput, Error> result = this._impl.BatchGetItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchGetItemInputTransformOutput(result.dtor_value());
  }

  public BatchGetItemOutputTransformOutput BatchGetItemOutputTransform(
      BatchGetItemOutputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformInput dafnyValue = ToDafny.BatchGetItemOutputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformOutput, Error> result = this._impl.BatchGetItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchGetItemOutputTransformOutput(result.dtor_value());
  }

  public BatchWriteItemInputTransformOutput BatchWriteItemInputTransform(
      BatchWriteItemInputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformInput dafnyValue = ToDafny.BatchWriteItemInputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput, Error> result = this._impl.BatchWriteItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchWriteItemInputTransformOutput(result.dtor_value());
  }

  public BatchWriteItemOutputTransformOutput BatchWriteItemOutputTransform(
      BatchWriteItemOutputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformInput dafnyValue = ToDafny.BatchWriteItemOutputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput, Error> result = this._impl.BatchWriteItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchWriteItemOutputTransformOutput(result.dtor_value());
  }

  public CreateTableInputTransformOutput CreateTableInputTransform(
      CreateTableInputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.CreateTableInputTransformInput dafnyValue = ToDafny.CreateTableInputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.CreateTableInputTransformOutput, Error> result = this._impl.CreateTableInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.CreateTableInputTransformOutput(result.dtor_value());
  }

  public CreateTableOutputTransformOutput CreateTableOutputTransform(
      CreateTableOutputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.CreateTableOutputTransformInput dafnyValue = ToDafny.CreateTableOutputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.CreateTableOutputTransformOutput, Error> result = this._impl.CreateTableOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.CreateTableOutputTransformOutput(result.dtor_value());
  }

  public DeleteItemInputTransformOutput DeleteItemInputTransform(
      DeleteItemInputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemInputTransformInput dafnyValue = ToDafny.DeleteItemInputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemInputTransformOutput, Error> result = this._impl.DeleteItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.DeleteItemInputTransformOutput(result.dtor_value());
  }

  public DeleteItemOutputTransformOutput DeleteItemOutputTransform(
      DeleteItemOutputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemOutputTransformInput dafnyValue = ToDafny.DeleteItemOutputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemOutputTransformOutput, Error> result = this._impl.DeleteItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.DeleteItemOutputTransformOutput(result.dtor_value());
  }

  public DescribeTableInputTransformOutput DescribeTableInputTransform(
      DescribeTableInputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DescribeTableInputTransformInput dafnyValue = ToDafny.DescribeTableInputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DescribeTableInputTransformOutput, Error> result = this._impl.DescribeTableInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.DescribeTableInputTransformOutput(result.dtor_value());
  }

  public DescribeTableOutputTransformOutput DescribeTableOutputTransform(
      DescribeTableOutputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DescribeTableOutputTransformInput dafnyValue = ToDafny.DescribeTableOutputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DescribeTableOutputTransformOutput, Error> result = this._impl.DescribeTableOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.DescribeTableOutputTransformOutput(result.dtor_value());
  }

  public ExecuteStatementInputTransformOutput ExecuteStatementInputTransform(
      ExecuteStatementInputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformInput dafnyValue = ToDafny.ExecuteStatementInputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput, Error> result = this._impl.ExecuteStatementInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ExecuteStatementInputTransformOutput(result.dtor_value());
  }

  public ExecuteStatementOutputTransformOutput ExecuteStatementOutputTransform(
      ExecuteStatementOutputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformInput dafnyValue = ToDafny.ExecuteStatementOutputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput, Error> result = this._impl.ExecuteStatementOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ExecuteStatementOutputTransformOutput(result.dtor_value());
  }

  public ExecuteTransactionInputTransformOutput ExecuteTransactionInputTransform(
      ExecuteTransactionInputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformInput dafnyValue = ToDafny.ExecuteTransactionInputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformOutput, Error> result = this._impl.ExecuteTransactionInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ExecuteTransactionInputTransformOutput(result.dtor_value());
  }

  public ExecuteTransactionOutputTransformOutput ExecuteTransactionOutputTransform(
      ExecuteTransactionOutputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformInput dafnyValue = ToDafny.ExecuteTransactionOutputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformOutput, Error> result = this._impl.ExecuteTransactionOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ExecuteTransactionOutputTransformOutput(result.dtor_value());
  }

  public GetItemInputTransformOutput GetItemInputTransform(GetItemInputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemInputTransformInput dafnyValue = ToDafny.GetItemInputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemInputTransformOutput, Error> result = this._impl.GetItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.GetItemInputTransformOutput(result.dtor_value());
  }

  public GetItemOutputTransformOutput GetItemOutputTransform(
      GetItemOutputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformInput dafnyValue = ToDafny.GetItemOutputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformOutput, Error> result = this._impl.GetItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.GetItemOutputTransformOutput(result.dtor_value());
  }

  public PutItemInputTransformOutput PutItemInputTransform(PutItemInputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemInputTransformInput dafnyValue = ToDafny.PutItemInputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemInputTransformOutput, Error> result = this._impl.PutItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.PutItemInputTransformOutput(result.dtor_value());
  }

  public PutItemOutputTransformOutput PutItemOutputTransform(
      PutItemOutputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemOutputTransformInput dafnyValue = ToDafny.PutItemOutputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemOutputTransformOutput, Error> result = this._impl.PutItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.PutItemOutputTransformOutput(result.dtor_value());
  }

  public QueryInputTransformOutput QueryInputTransform(QueryInputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryInputTransformInput dafnyValue = ToDafny.QueryInputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryInputTransformOutput, Error> result = this._impl.QueryInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.QueryInputTransformOutput(result.dtor_value());
  }

  public QueryOutputTransformOutput QueryOutputTransform(QueryOutputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryOutputTransformInput dafnyValue = ToDafny.QueryOutputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryOutputTransformOutput, Error> result = this._impl.QueryOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.QueryOutputTransformOutput(result.dtor_value());
  }

  public ScanInputTransformOutput ScanInputTransform(ScanInputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanInputTransformInput dafnyValue = ToDafny.ScanInputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanInputTransformOutput, Error> result = this._impl.ScanInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ScanInputTransformOutput(result.dtor_value());
  }

  public ScanOutputTransformOutput ScanOutputTransform(ScanOutputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanOutputTransformInput dafnyValue = ToDafny.ScanOutputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanOutputTransformOutput, Error> result = this._impl.ScanOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ScanOutputTransformOutput(result.dtor_value());
  }

  public TransactGetItemsInputTransformOutput TransactGetItemsInputTransform(
      TransactGetItemsInputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsInputTransformInput dafnyValue = ToDafny.TransactGetItemsInputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsInputTransformOutput, Error> result = this._impl.TransactGetItemsInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.TransactGetItemsInputTransformOutput(result.dtor_value());
  }

  public TransactGetItemsOutputTransformOutput TransactGetItemsOutputTransform(
      TransactGetItemsOutputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsOutputTransformInput dafnyValue = ToDafny.TransactGetItemsOutputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsOutputTransformOutput, Error> result = this._impl.TransactGetItemsOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.TransactGetItemsOutputTransformOutput(result.dtor_value());
  }

  public TransactWriteItemsInputTransformOutput TransactWriteItemsInputTransform(
      TransactWriteItemsInputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsInputTransformInput dafnyValue = ToDafny.TransactWriteItemsInputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsInputTransformOutput, Error> result = this._impl.TransactWriteItemsInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.TransactWriteItemsInputTransformOutput(result.dtor_value());
  }

  public TransactWriteItemsOutputTransformOutput TransactWriteItemsOutputTransform(
      TransactWriteItemsOutputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsOutputTransformInput dafnyValue = ToDafny.TransactWriteItemsOutputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsOutputTransformOutput, Error> result = this._impl.TransactWriteItemsOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.TransactWriteItemsOutputTransformOutput(result.dtor_value());
  }

  public UpdateItemInputTransformOutput UpdateItemInputTransform(
      UpdateItemInputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemInputTransformInput dafnyValue = ToDafny.UpdateItemInputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemInputTransformOutput, Error> result = this._impl.UpdateItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.UpdateItemInputTransformOutput(result.dtor_value());
  }

  public UpdateItemOutputTransformOutput UpdateItemOutputTransform(
      UpdateItemOutputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemOutputTransformInput dafnyValue = ToDafny.UpdateItemOutputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemOutputTransformOutput, Error> result = this._impl.UpdateItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.UpdateItemOutputTransformOutput(result.dtor_value());
  }

  public UpdateTableInputTransformOutput UpdateTableInputTransform(
      UpdateTableInputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateTableInputTransformInput dafnyValue = ToDafny.UpdateTableInputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateTableInputTransformOutput, Error> result = this._impl.UpdateTableInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.UpdateTableInputTransformOutput(result.dtor_value());
  }

  public UpdateTableOutputTransformOutput UpdateTableOutputTransform(
      UpdateTableOutputTransformInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateTableOutputTransformInput dafnyValue = ToDafny.UpdateTableOutputTransformInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateTableOutputTransformOutput, Error> result = this._impl.UpdateTableOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.UpdateTableOutputTransformOutput(result.dtor_value());
  }

  protected IDynamoDbEncryptionTransformsClient impl() {
    return this._impl;
  }

  public interface Builder {
    /**
     * @param DynamoDbTablesEncryptionConfig The configuration for client-side encryption with multiple DynamoDB table.
     */
    Builder DynamoDbTablesEncryptionConfig(
        DynamoDbTablesEncryptionConfig DynamoDbTablesEncryptionConfig);

    /**
     * @return The configuration for client-side encryption with multiple DynamoDB table.
     */
    DynamoDbTablesEncryptionConfig DynamoDbTablesEncryptionConfig();

    DynamoDbEncryptionTransforms build();
  }

  static class BuilderImpl implements Builder {
    protected DynamoDbTablesEncryptionConfig DynamoDbTablesEncryptionConfig;

    protected BuilderImpl() {
    }

    public Builder DynamoDbTablesEncryptionConfig(
        DynamoDbTablesEncryptionConfig DynamoDbTablesEncryptionConfig) {
      this.DynamoDbTablesEncryptionConfig = DynamoDbTablesEncryptionConfig;
      return this;
    }

    public DynamoDbTablesEncryptionConfig DynamoDbTablesEncryptionConfig() {
      return this.DynamoDbTablesEncryptionConfig;
    }

    public DynamoDbEncryptionTransforms build() {
      if (Objects.isNull(this.DynamoDbTablesEncryptionConfig()))  {
        throw new IllegalArgumentException("Missing value for required field `DynamoDbTablesEncryptionConfig`");
      }
      return new DynamoDbEncryptionTransforms(this);
    }
  }
}
