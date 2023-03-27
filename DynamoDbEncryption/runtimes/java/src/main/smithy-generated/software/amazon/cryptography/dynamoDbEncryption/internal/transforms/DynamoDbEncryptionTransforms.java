// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.internal.transforms;

import Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.DynamoDbEncryptionTransformsClient;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.Error;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.IDynamoDbEncryptionTransformsClient;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.__default;
import Wrappers_Compile.Result;
import java.lang.IllegalArgumentException;
import java.util.Objects;
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
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTablesEncryptionConfig;

public class DynamoDbEncryptionTransforms {
  private final IDynamoDbEncryptionTransformsClient _impl;

  protected DynamoDbEncryptionTransforms(BuilderImpl builder) {
    DynamoDbTablesEncryptionConfig nativeValue = builder.DynamoDbTablesEncryptionConfig();
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTablesEncryptionConfig dafnyValue = software.amazon.cryptography.dynamoDbEncryption.ToDafny.DynamoDbTablesEncryptionConfig(nativeValue);
    Result<DynamoDbEncryptionTransformsClient, Error> result = __default.DynamoDbEncryptionTransforms(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    this._impl = result.dtor_value();
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public PutItemInputTransformOutput PutItemInputTransform(PutItemInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.PutItemInputTransformInput dafnyValue = ToDafny.PutItemInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.PutItemInputTransformOutput, Error> result = this._impl.PutItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.PutItemInputTransformOutput(result.dtor_value());
  }

  public PutItemOutputTransformOutput PutItemOutputTransform(
      PutItemOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.PutItemOutputTransformInput dafnyValue = ToDafny.PutItemOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.PutItemOutputTransformOutput, Error> result = this._impl.PutItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.PutItemOutputTransformOutput(result.dtor_value());
  }

  public GetItemInputTransformOutput GetItemInputTransform(GetItemInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.GetItemInputTransformInput dafnyValue = ToDafny.GetItemInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.GetItemInputTransformOutput, Error> result = this._impl.GetItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.GetItemInputTransformOutput(result.dtor_value());
  }

  public GetItemOutputTransformOutput GetItemOutputTransform(
      GetItemOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.GetItemOutputTransformInput dafnyValue = ToDafny.GetItemOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.GetItemOutputTransformOutput, Error> result = this._impl.GetItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.GetItemOutputTransformOutput(result.dtor_value());
  }

  public BatchWriteItemInputTransformOutput BatchWriteItemInputTransform(
      BatchWriteItemInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchWriteItemInputTransformInput dafnyValue = ToDafny.BatchWriteItemInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchWriteItemInputTransformOutput, Error> result = this._impl.BatchWriteItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchWriteItemInputTransformOutput(result.dtor_value());
  }

  public BatchWriteItemOutputTransformOutput BatchWriteItemOutputTransform(
      BatchWriteItemOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchWriteItemOutputTransformInput dafnyValue = ToDafny.BatchWriteItemOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchWriteItemOutputTransformOutput, Error> result = this._impl.BatchWriteItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchWriteItemOutputTransformOutput(result.dtor_value());
  }

  public BatchGetItemInputTransformOutput BatchGetItemInputTransform(
      BatchGetItemInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchGetItemInputTransformInput dafnyValue = ToDafny.BatchGetItemInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchGetItemInputTransformOutput, Error> result = this._impl.BatchGetItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchGetItemInputTransformOutput(result.dtor_value());
  }

  public BatchGetItemOutputTransformOutput BatchGetItemOutputTransform(
      BatchGetItemOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchGetItemOutputTransformInput dafnyValue = ToDafny.BatchGetItemOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchGetItemOutputTransformOutput, Error> result = this._impl.BatchGetItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchGetItemOutputTransformOutput(result.dtor_value());
  }

  public ScanInputTransformOutput ScanInputTransform(ScanInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ScanInputTransformInput dafnyValue = ToDafny.ScanInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ScanInputTransformOutput, Error> result = this._impl.ScanInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ScanInputTransformOutput(result.dtor_value());
  }

  public ScanOutputTransformOutput ScanOutputTransform(ScanOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ScanOutputTransformInput dafnyValue = ToDafny.ScanOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ScanOutputTransformOutput, Error> result = this._impl.ScanOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ScanOutputTransformOutput(result.dtor_value());
  }

  public QueryInputTransformOutput QueryInputTransform(QueryInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.QueryInputTransformInput dafnyValue = ToDafny.QueryInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.QueryInputTransformOutput, Error> result = this._impl.QueryInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.QueryInputTransformOutput(result.dtor_value());
  }

  public QueryOutputTransformOutput QueryOutputTransform(QueryOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.QueryOutputTransformInput dafnyValue = ToDafny.QueryOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.QueryOutputTransformOutput, Error> result = this._impl.QueryOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.QueryOutputTransformOutput(result.dtor_value());
  }

  public TransactWriteItemsInputTransformOutput TransactWriteItemsInputTransform(
      TransactWriteItemsInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.TransactWriteItemsInputTransformInput dafnyValue = ToDafny.TransactWriteItemsInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.TransactWriteItemsInputTransformOutput, Error> result = this._impl.TransactWriteItemsInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.TransactWriteItemsInputTransformOutput(result.dtor_value());
  }

  public TransactWriteItemsOutputTransformOutput TransactWriteItemsOutputTransform(
      TransactWriteItemsOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.TransactWriteItemsOutputTransformInput dafnyValue = ToDafny.TransactWriteItemsOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.TransactWriteItemsOutputTransformOutput, Error> result = this._impl.TransactWriteItemsOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.TransactWriteItemsOutputTransformOutput(result.dtor_value());
  }

  public UpdateItemInputTransformOutput UpdateItemInputTransform(
      UpdateItemInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.UpdateItemInputTransformInput dafnyValue = ToDafny.UpdateItemInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.UpdateItemInputTransformOutput, Error> result = this._impl.UpdateItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.UpdateItemInputTransformOutput(result.dtor_value());
  }

  public UpdateItemOutputTransformOutput UpdateItemOutputTransform(
      UpdateItemOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.UpdateItemOutputTransformInput dafnyValue = ToDafny.UpdateItemOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.UpdateItemOutputTransformOutput, Error> result = this._impl.UpdateItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.UpdateItemOutputTransformOutput(result.dtor_value());
  }

  public DeleteItemInputTransformOutput DeleteItemInputTransform(
      DeleteItemInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.DeleteItemInputTransformInput dafnyValue = ToDafny.DeleteItemInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.DeleteItemInputTransformOutput, Error> result = this._impl.DeleteItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.DeleteItemInputTransformOutput(result.dtor_value());
  }

  public DeleteItemOutputTransformOutput DeleteItemOutputTransform(
      DeleteItemOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.DeleteItemOutputTransformInput dafnyValue = ToDafny.DeleteItemOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.DeleteItemOutputTransformOutput, Error> result = this._impl.DeleteItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.DeleteItemOutputTransformOutput(result.dtor_value());
  }

  public TransactGetItemsInputTransformOutput TransactGetItemsInputTransform(
      TransactGetItemsInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.TransactGetItemsInputTransformInput dafnyValue = ToDafny.TransactGetItemsInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.TransactGetItemsInputTransformOutput, Error> result = this._impl.TransactGetItemsInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.TransactGetItemsInputTransformOutput(result.dtor_value());
  }

  public TransactGetItemsOutputTransformOutput TransactGetItemsOutputTransform(
      TransactGetItemsOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.TransactGetItemsOutputTransformInput dafnyValue = ToDafny.TransactGetItemsOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.TransactGetItemsOutputTransformOutput, Error> result = this._impl.TransactGetItemsOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.TransactGetItemsOutputTransformOutput(result.dtor_value());
  }

  public ExecuteStatementInputTransformOutput ExecuteStatementInputTransform(
      ExecuteStatementInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ExecuteStatementInputTransformInput dafnyValue = ToDafny.ExecuteStatementInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ExecuteStatementInputTransformOutput, Error> result = this._impl.ExecuteStatementInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ExecuteStatementInputTransformOutput(result.dtor_value());
  }

  public ExecuteStatementOutputTransformOutput ExecuteStatementOutputTransform(
      ExecuteStatementOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ExecuteStatementOutputTransformInput dafnyValue = ToDafny.ExecuteStatementOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ExecuteStatementOutputTransformOutput, Error> result = this._impl.ExecuteStatementOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ExecuteStatementOutputTransformOutput(result.dtor_value());
  }

  public BatchExecuteStatementInputTransformOutput BatchExecuteStatementInputTransform(
      BatchExecuteStatementInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchExecuteStatementInputTransformInput dafnyValue = ToDafny.BatchExecuteStatementInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchExecuteStatementInputTransformOutput, Error> result = this._impl.BatchExecuteStatementInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchExecuteStatementInputTransformOutput(result.dtor_value());
  }

  public BatchExecuteStatementOutputTransformOutput BatchExecuteStatementOutputTransform(
      BatchExecuteStatementOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchExecuteStatementOutputTransformInput dafnyValue = ToDafny.BatchExecuteStatementOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.BatchExecuteStatementOutputTransformOutput, Error> result = this._impl.BatchExecuteStatementOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchExecuteStatementOutputTransformOutput(result.dtor_value());
  }

  public ExecuteTransactionInputTransformOutput ExecuteTransactionInputTransform(
      ExecuteTransactionInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ExecuteTransactionInputTransformInput dafnyValue = ToDafny.ExecuteTransactionInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ExecuteTransactionInputTransformOutput, Error> result = this._impl.ExecuteTransactionInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ExecuteTransactionInputTransformOutput(result.dtor_value());
  }

  public ExecuteTransactionOutputTransformOutput ExecuteTransactionOutputTransform(
      ExecuteTransactionOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ExecuteTransactionOutputTransformInput dafnyValue = ToDafny.ExecuteTransactionOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.ExecuteTransactionOutputTransformOutput, Error> result = this._impl.ExecuteTransactionOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ExecuteTransactionOutputTransformOutput(result.dtor_value());
  }

  public CreateTableInputTransformOutput CreateTableInputTransform(
      CreateTableInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.CreateTableInputTransformInput dafnyValue = ToDafny.CreateTableInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.CreateTableInputTransformOutput, Error> result = this._impl.CreateTableInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.CreateTableInputTransformOutput(result.dtor_value());
  }

  public CreateTableOutputTransformOutput CreateTableOutputTransform(
      CreateTableOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.CreateTableOutputTransformInput dafnyValue = ToDafny.CreateTableOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.CreateTableOutputTransformOutput, Error> result = this._impl.CreateTableOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.CreateTableOutputTransformOutput(result.dtor_value());
  }

  public UpdateTableInputTransformOutput UpdateTableInputTransform(
      UpdateTableInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.UpdateTableInputTransformInput dafnyValue = ToDafny.UpdateTableInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.UpdateTableInputTransformOutput, Error> result = this._impl.UpdateTableInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.UpdateTableInputTransformOutput(result.dtor_value());
  }

  public UpdateTableOutputTransformOutput UpdateTableOutputTransform(
      UpdateTableOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.UpdateTableOutputTransformInput dafnyValue = ToDafny.UpdateTableOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.UpdateTableOutputTransformOutput, Error> result = this._impl.UpdateTableOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.UpdateTableOutputTransformOutput(result.dtor_value());
  }

  public DescribeTableInputTransformOutput DescribeTableInputTransform(
      DescribeTableInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.DescribeTableInputTransformInput dafnyValue = ToDafny.DescribeTableInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.DescribeTableInputTransformOutput, Error> result = this._impl.DescribeTableInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.DescribeTableInputTransformOutput(result.dtor_value());
  }

  public DescribeTableOutputTransformOutput DescribeTableOutputTransform(
      DescribeTableOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.DescribeTableOutputTransformInput dafnyValue = ToDafny.DescribeTableOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Internal.Transforms.Types.DescribeTableOutputTransformOutput, Error> result = this._impl.DescribeTableOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.DescribeTableOutputTransformOutput(result.dtor_value());
  }

  protected IDynamoDbEncryptionTransformsClient impl() {
    return this._impl;
  }

  public interface Builder {
    Builder DynamoDbTablesEncryptionConfig(
        DynamoDbTablesEncryptionConfig DynamoDbTablesEncryptionConfig);

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
