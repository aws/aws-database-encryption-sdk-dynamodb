// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal;

import Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.DynamoDbEncryptionMiddlewareInternalClient;
import Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.Error;
import Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.IDynamoDbEncryptionMiddlewareInternalClient;
import Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.__default;
import Wrappers_Compile.Result;
import java.lang.IllegalArgumentException;
import java.util.Objects;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.BatchExecuteStatementInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.BatchExecuteStatementInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.BatchExecuteStatementOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.BatchExecuteStatementOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.BatchGetItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.BatchGetItemInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.BatchGetItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.BatchGetItemOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.BatchWriteItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.BatchWriteItemInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.BatchWriteItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.BatchWriteItemOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.DeleteItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.DeleteItemInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.DeleteItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.DeleteItemOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.DynamoDbEncryptionMiddlewareInternalConfig;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.ExecuteStatementInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.ExecuteStatementInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.ExecuteStatementOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.ExecuteStatementOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.ExecuteTransactionInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.ExecuteTransactionInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.ExecuteTransactionOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.ExecuteTransactionOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.GetItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.GetItemInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.GetItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.GetItemOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.PutItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.PutItemInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.PutItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.PutItemOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.QueryInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.QueryInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.QueryOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.QueryOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.ScanInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.ScanInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.ScanOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.ScanOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.TransactGetItemsInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.TransactGetItemsInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.TransactGetItemsOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.TransactGetItemsOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.TransactWriteItemsInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.TransactWriteItemsInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.TransactWriteItemsOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.TransactWriteItemsOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.UpdateItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.UpdateItemInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.UpdateItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.UpdateItemOutputTransformOutput;

public class DynamoDbEncryptionMiddlewareInternal {
  private final IDynamoDbEncryptionMiddlewareInternalClient _impl;

  protected DynamoDbEncryptionMiddlewareInternal(BuilderImpl builder) {
    DynamoDbEncryptionMiddlewareInternalConfig nativeValue = builder.DynamoDbEncryptionMiddlewareInternalConfig();
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.DynamoDbEncryptionMiddlewareInternalConfig dafnyValue = ToDafny.DynamoDbEncryptionMiddlewareInternalConfig(nativeValue);
    Result<DynamoDbEncryptionMiddlewareInternalClient, Error> result = __default.DynamoDbEncryptionMiddlewareInternal(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    this._impl = result.dtor_value();
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public PutItemInputTransformOutput PutItemInputTransform(PutItemInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.PutItemInputTransformInput dafnyValue = ToDafny.PutItemInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.PutItemInputTransformOutput, Error> result = this._impl.PutItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.PutItemInputTransformOutput(result.dtor_value());
  }

  public PutItemOutputTransformOutput PutItemOutputTransform(
      PutItemOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.PutItemOutputTransformInput dafnyValue = ToDafny.PutItemOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.PutItemOutputTransformOutput, Error> result = this._impl.PutItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.PutItemOutputTransformOutput(result.dtor_value());
  }

  public GetItemInputTransformOutput GetItemInputTransform(GetItemInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.GetItemInputTransformInput dafnyValue = ToDafny.GetItemInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.GetItemInputTransformOutput, Error> result = this._impl.GetItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.GetItemInputTransformOutput(result.dtor_value());
  }

  public GetItemOutputTransformOutput GetItemOutputTransform(
      GetItemOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.GetItemOutputTransformInput dafnyValue = ToDafny.GetItemOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.GetItemOutputTransformOutput, Error> result = this._impl.GetItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.GetItemOutputTransformOutput(result.dtor_value());
  }

  public BatchWriteItemInputTransformOutput BatchWriteItemInputTransform(
      BatchWriteItemInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchWriteItemInputTransformInput dafnyValue = ToDafny.BatchWriteItemInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchWriteItemInputTransformOutput, Error> result = this._impl.BatchWriteItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchWriteItemInputTransformOutput(result.dtor_value());
  }

  public BatchWriteItemOutputTransformOutput BatchWriteItemOutputTransform(
      BatchWriteItemOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchWriteItemOutputTransformInput dafnyValue = ToDafny.BatchWriteItemOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchWriteItemOutputTransformOutput, Error> result = this._impl.BatchWriteItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchWriteItemOutputTransformOutput(result.dtor_value());
  }

  public BatchGetItemInputTransformOutput BatchGetItemInputTransform(
      BatchGetItemInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchGetItemInputTransformInput dafnyValue = ToDafny.BatchGetItemInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchGetItemInputTransformOutput, Error> result = this._impl.BatchGetItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchGetItemInputTransformOutput(result.dtor_value());
  }

  public BatchGetItemOutputTransformOutput BatchGetItemOutputTransform(
      BatchGetItemOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchGetItemOutputTransformInput dafnyValue = ToDafny.BatchGetItemOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchGetItemOutputTransformOutput, Error> result = this._impl.BatchGetItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchGetItemOutputTransformOutput(result.dtor_value());
  }

  public ScanInputTransformOutput ScanInputTransform(ScanInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ScanInputTransformInput dafnyValue = ToDafny.ScanInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ScanInputTransformOutput, Error> result = this._impl.ScanInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ScanInputTransformOutput(result.dtor_value());
  }

  public ScanOutputTransformOutput ScanOutputTransform(ScanOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ScanOutputTransformInput dafnyValue = ToDafny.ScanOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ScanOutputTransformOutput, Error> result = this._impl.ScanOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ScanOutputTransformOutput(result.dtor_value());
  }

  public QueryInputTransformOutput QueryInputTransform(QueryInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.QueryInputTransformInput dafnyValue = ToDafny.QueryInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.QueryInputTransformOutput, Error> result = this._impl.QueryInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.QueryInputTransformOutput(result.dtor_value());
  }

  public QueryOutputTransformOutput QueryOutputTransform(QueryOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.QueryOutputTransformInput dafnyValue = ToDafny.QueryOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.QueryOutputTransformOutput, Error> result = this._impl.QueryOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.QueryOutputTransformOutput(result.dtor_value());
  }

  public TransactWriteItemsInputTransformOutput TransactWriteItemsInputTransform(
      TransactWriteItemsInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.TransactWriteItemsInputTransformInput dafnyValue = ToDafny.TransactWriteItemsInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.TransactWriteItemsInputTransformOutput, Error> result = this._impl.TransactWriteItemsInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.TransactWriteItemsInputTransformOutput(result.dtor_value());
  }

  public TransactWriteItemsOutputTransformOutput TransactWriteItemsOutputTransform(
      TransactWriteItemsOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.TransactWriteItemsOutputTransformInput dafnyValue = ToDafny.TransactWriteItemsOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.TransactWriteItemsOutputTransformOutput, Error> result = this._impl.TransactWriteItemsOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.TransactWriteItemsOutputTransformOutput(result.dtor_value());
  }

  public UpdateItemInputTransformOutput UpdateItemInputTransform(
      UpdateItemInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.UpdateItemInputTransformInput dafnyValue = ToDafny.UpdateItemInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.UpdateItemInputTransformOutput, Error> result = this._impl.UpdateItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.UpdateItemInputTransformOutput(result.dtor_value());
  }

  public UpdateItemOutputTransformOutput UpdateItemOutputTransform(
      UpdateItemOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.UpdateItemOutputTransformInput dafnyValue = ToDafny.UpdateItemOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.UpdateItemOutputTransformOutput, Error> result = this._impl.UpdateItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.UpdateItemOutputTransformOutput(result.dtor_value());
  }

  public DeleteItemInputTransformOutput DeleteItemInputTransform(
      DeleteItemInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.DeleteItemInputTransformInput dafnyValue = ToDafny.DeleteItemInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.DeleteItemInputTransformOutput, Error> result = this._impl.DeleteItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.DeleteItemInputTransformOutput(result.dtor_value());
  }

  public DeleteItemOutputTransformOutput DeleteItemOutputTransform(
      DeleteItemOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.DeleteItemOutputTransformInput dafnyValue = ToDafny.DeleteItemOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.DeleteItemOutputTransformOutput, Error> result = this._impl.DeleteItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.DeleteItemOutputTransformOutput(result.dtor_value());
  }

  public TransactGetItemsInputTransformOutput TransactGetItemsInputTransform(
      TransactGetItemsInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.TransactGetItemsInputTransformInput dafnyValue = ToDafny.TransactGetItemsInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.TransactGetItemsInputTransformOutput, Error> result = this._impl.TransactGetItemsInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.TransactGetItemsInputTransformOutput(result.dtor_value());
  }

  public TransactGetItemsOutputTransformOutput TransactGetItemsOutputTransform(
      TransactGetItemsOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.TransactGetItemsOutputTransformInput dafnyValue = ToDafny.TransactGetItemsOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.TransactGetItemsOutputTransformOutput, Error> result = this._impl.TransactGetItemsOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.TransactGetItemsOutputTransformOutput(result.dtor_value());
  }

  public ExecuteStatementInputTransformOutput ExecuteStatementInputTransform(
      ExecuteStatementInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ExecuteStatementInputTransformInput dafnyValue = ToDafny.ExecuteStatementInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ExecuteStatementInputTransformOutput, Error> result = this._impl.ExecuteStatementInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ExecuteStatementInputTransformOutput(result.dtor_value());
  }

  public ExecuteStatementOutputTransformOutput ExecuteStatementOutputTransform(
      ExecuteStatementOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ExecuteStatementOutputTransformInput dafnyValue = ToDafny.ExecuteStatementOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ExecuteStatementOutputTransformOutput, Error> result = this._impl.ExecuteStatementOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ExecuteStatementOutputTransformOutput(result.dtor_value());
  }

  public BatchExecuteStatementInputTransformOutput BatchExecuteStatementInputTransform(
      BatchExecuteStatementInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchExecuteStatementInputTransformInput dafnyValue = ToDafny.BatchExecuteStatementInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchExecuteStatementInputTransformOutput, Error> result = this._impl.BatchExecuteStatementInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchExecuteStatementInputTransformOutput(result.dtor_value());
  }

  public BatchExecuteStatementOutputTransformOutput BatchExecuteStatementOutputTransform(
      BatchExecuteStatementOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchExecuteStatementOutputTransformInput dafnyValue = ToDafny.BatchExecuteStatementOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchExecuteStatementOutputTransformOutput, Error> result = this._impl.BatchExecuteStatementOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchExecuteStatementOutputTransformOutput(result.dtor_value());
  }

  public ExecuteTransactionInputTransformOutput ExecuteTransactionInputTransform(
      ExecuteTransactionInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ExecuteTransactionInputTransformInput dafnyValue = ToDafny.ExecuteTransactionInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ExecuteTransactionInputTransformOutput, Error> result = this._impl.ExecuteTransactionInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ExecuteTransactionInputTransformOutput(result.dtor_value());
  }

  public ExecuteTransactionOutputTransformOutput ExecuteTransactionOutputTransform(
      ExecuteTransactionOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ExecuteTransactionOutputTransformInput dafnyValue = ToDafny.ExecuteTransactionOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ExecuteTransactionOutputTransformOutput, Error> result = this._impl.ExecuteTransactionOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ExecuteTransactionOutputTransformOutput(result.dtor_value());
  }

  protected IDynamoDbEncryptionMiddlewareInternalClient impl() {
    return this._impl;
  }

  public interface Builder {
    Builder DynamoDbEncryptionMiddlewareInternalConfig(
        DynamoDbEncryptionMiddlewareInternalConfig DynamoDbEncryptionMiddlewareInternalConfig);

    DynamoDbEncryptionMiddlewareInternalConfig DynamoDbEncryptionMiddlewareInternalConfig();

    DynamoDbEncryptionMiddlewareInternal build();
  }

  static class BuilderImpl implements Builder {
    protected DynamoDbEncryptionMiddlewareInternalConfig DynamoDbEncryptionMiddlewareInternalConfig;

    protected BuilderImpl() {
    }

    public Builder DynamoDbEncryptionMiddlewareInternalConfig(
        DynamoDbEncryptionMiddlewareInternalConfig DynamoDbEncryptionMiddlewareInternalConfig) {
      this.DynamoDbEncryptionMiddlewareInternalConfig = DynamoDbEncryptionMiddlewareInternalConfig;
      return this;
    }

    public DynamoDbEncryptionMiddlewareInternalConfig DynamoDbEncryptionMiddlewareInternalConfig() {
      return this.DynamoDbEncryptionMiddlewareInternalConfig;
    }

    public DynamoDbEncryptionMiddlewareInternal build() {
      if (Objects.isNull(this.DynamoDbEncryptionMiddlewareInternalConfig()))  {
        throw new IllegalArgumentException("Missing value for required field `DynamoDbEncryptionMiddlewareInternalConfig`");
      }
      return new DynamoDbEncryptionMiddlewareInternal(this);
    }
  }
}
