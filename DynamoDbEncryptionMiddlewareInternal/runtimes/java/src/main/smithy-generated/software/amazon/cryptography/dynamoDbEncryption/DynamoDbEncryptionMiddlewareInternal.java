// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption;

import Dafny.Aws.Cryptography.DynamoDbEncryption.DynamoDbEncryptionMiddlewareInternalClient;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbEncryptionMiddlewareInternalClient;
import Dafny.Aws.Cryptography.DynamoDbEncryption.__default;
import Wrappers_Compile.Result;
import java.lang.IllegalArgumentException;
import java.util.Objects;
import software.amazon.cryptography.dynamoDbEncryption.model.BatchExecuteStatementInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.BatchExecuteStatementInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.BatchExecuteStatementOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.BatchExecuteStatementOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.BatchGetItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.BatchGetItemInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.BatchGetItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.BatchGetItemOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.BatchWriteItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.BatchWriteItemInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.BatchWriteItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.BatchWriteItemOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.DeleteItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.DeleteItemInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.DeleteItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.DeleteItemOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.ExecuteStatementInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.ExecuteStatementInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.ExecuteStatementOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.ExecuteStatementOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.ExecuteTransactionInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.ExecuteTransactionInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.ExecuteTransactionOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.ExecuteTransactionOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.GetItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.GetItemInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.GetItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.GetItemOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.PutItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.PutItemInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.PutItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.PutItemOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.QueryInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.QueryInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.QueryOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.QueryOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.ScanInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.ScanInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.ScanOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.ScanOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.TransactGetItemsInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.TransactGetItemsInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.TransactGetItemsOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.TransactGetItemsOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.TransactWriteItemsInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.TransactWriteItemsInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.TransactWriteItemsOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.TransactWriteItemsOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.UpdateItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.UpdateItemInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.UpdateItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.UpdateItemOutputTransformOutput;

public class DynamoDbEncryptionMiddlewareInternal {
  private final IDynamoDbEncryptionMiddlewareInternalClient _impl;

  protected DynamoDbEncryptionMiddlewareInternal(BuilderImpl builder) {
    DynamoDbEncryptionConfig nativeValue = builder.DynamoDbEncryptionConfig();
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbEncryptionConfig dafnyValue = ToDafny.DynamoDbEncryptionConfig(nativeValue);
    Result<DynamoDbEncryptionMiddlewareInternalClient, Error> result = __default.DynamoDbEncryptionMiddlewareInternal(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    this._impl = result.dtor_value();
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  protected IDynamoDbEncryptionMiddlewareInternalClient impl() {
    return this._impl;
  }

  public PutItemInputTransformOutput PutItemInputTransform(PutItemInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PutItemInputTransformInput dafnyValue = ToDafny.PutItemInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PutItemInputTransformOutput, Error> result = this._impl.PutItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.PutItemInputTransformOutput(result.dtor_value());
  }

  public PutItemOutputTransformOutput PutItemOutputTransform(
      PutItemOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PutItemOutputTransformInput dafnyValue = ToDafny.PutItemOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PutItemOutputTransformOutput, Error> result = this._impl.PutItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.PutItemOutputTransformOutput(result.dtor_value());
  }

  public GetItemInputTransformOutput GetItemInputTransform(GetItemInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetItemInputTransformInput dafnyValue = ToDafny.GetItemInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetItemInputTransformOutput, Error> result = this._impl.GetItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.GetItemInputTransformOutput(result.dtor_value());
  }

  public GetItemOutputTransformOutput GetItemOutputTransform(
      GetItemOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetItemOutputTransformInput dafnyValue = ToDafny.GetItemOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetItemOutputTransformOutput, Error> result = this._impl.GetItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.GetItemOutputTransformOutput(result.dtor_value());
  }

  public BatchWriteItemInputTransformOutput BatchWriteItemInputTransform(
      BatchWriteItemInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchWriteItemInputTransformInput dafnyValue = ToDafny.BatchWriteItemInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchWriteItemInputTransformOutput, Error> result = this._impl.BatchWriteItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchWriteItemInputTransformOutput(result.dtor_value());
  }

  public BatchWriteItemOutputTransformOutput BatchWriteItemOutputTransform(
      BatchWriteItemOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchWriteItemOutputTransformInput dafnyValue = ToDafny.BatchWriteItemOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchWriteItemOutputTransformOutput, Error> result = this._impl.BatchWriteItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchWriteItemOutputTransformOutput(result.dtor_value());
  }

  public BatchGetItemInputTransformOutput BatchGetItemInputTransform(
      BatchGetItemInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchGetItemInputTransformInput dafnyValue = ToDafny.BatchGetItemInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchGetItemInputTransformOutput, Error> result = this._impl.BatchGetItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchGetItemInputTransformOutput(result.dtor_value());
  }

  public BatchGetItemOutputTransformOutput BatchGetItemOutputTransform(
      BatchGetItemOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchGetItemOutputTransformInput dafnyValue = ToDafny.BatchGetItemOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchGetItemOutputTransformOutput, Error> result = this._impl.BatchGetItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchGetItemOutputTransformOutput(result.dtor_value());
  }

  public ScanInputTransformOutput ScanInputTransform(ScanInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ScanInputTransformInput dafnyValue = ToDafny.ScanInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ScanInputTransformOutput, Error> result = this._impl.ScanInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ScanInputTransformOutput(result.dtor_value());
  }

  public ScanOutputTransformOutput ScanOutputTransform(ScanOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ScanOutputTransformInput dafnyValue = ToDafny.ScanOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ScanOutputTransformOutput, Error> result = this._impl.ScanOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ScanOutputTransformOutput(result.dtor_value());
  }

  public QueryInputTransformOutput QueryInputTransform(QueryInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.QueryInputTransformInput dafnyValue = ToDafny.QueryInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.QueryInputTransformOutput, Error> result = this._impl.QueryInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.QueryInputTransformOutput(result.dtor_value());
  }

  public QueryOutputTransformOutput QueryOutputTransform(QueryOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.QueryOutputTransformInput dafnyValue = ToDafny.QueryOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.QueryOutputTransformOutput, Error> result = this._impl.QueryOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.QueryOutputTransformOutput(result.dtor_value());
  }

  public TransactWriteItemsInputTransformOutput TransactWriteItemsInputTransform(
      TransactWriteItemsInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactWriteItemsInputTransformInput dafnyValue = ToDafny.TransactWriteItemsInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactWriteItemsInputTransformOutput, Error> result = this._impl.TransactWriteItemsInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.TransactWriteItemsInputTransformOutput(result.dtor_value());
  }

  public TransactWriteItemsOutputTransformOutput TransactWriteItemsOutputTransform(
      TransactWriteItemsOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactWriteItemsOutputTransformInput dafnyValue = ToDafny.TransactWriteItemsOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactWriteItemsOutputTransformOutput, Error> result = this._impl.TransactWriteItemsOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.TransactWriteItemsOutputTransformOutput(result.dtor_value());
  }

  public UpdateItemInputTransformOutput UpdateItemInputTransform(
      UpdateItemInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.UpdateItemInputTransformInput dafnyValue = ToDafny.UpdateItemInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.UpdateItemInputTransformOutput, Error> result = this._impl.UpdateItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.UpdateItemInputTransformOutput(result.dtor_value());
  }

  public UpdateItemOutputTransformOutput UpdateItemOutputTransform(
      UpdateItemOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.UpdateItemOutputTransformInput dafnyValue = ToDafny.UpdateItemOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.UpdateItemOutputTransformOutput, Error> result = this._impl.UpdateItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.UpdateItemOutputTransformOutput(result.dtor_value());
  }

  public DeleteItemInputTransformOutput DeleteItemInputTransform(
      DeleteItemInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DeleteItemInputTransformInput dafnyValue = ToDafny.DeleteItemInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DeleteItemInputTransformOutput, Error> result = this._impl.DeleteItemInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.DeleteItemInputTransformOutput(result.dtor_value());
  }

  public DeleteItemOutputTransformOutput DeleteItemOutputTransform(
      DeleteItemOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DeleteItemOutputTransformInput dafnyValue = ToDafny.DeleteItemOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DeleteItemOutputTransformOutput, Error> result = this._impl.DeleteItemOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.DeleteItemOutputTransformOutput(result.dtor_value());
  }

  public TransactGetItemsInputTransformOutput TransactGetItemsInputTransform(
      TransactGetItemsInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactGetItemsInputTransformInput dafnyValue = ToDafny.TransactGetItemsInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactGetItemsInputTransformOutput, Error> result = this._impl.TransactGetItemsInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.TransactGetItemsInputTransformOutput(result.dtor_value());
  }

  public TransactGetItemsOutputTransformOutput TransactGetItemsOutputTransform(
      TransactGetItemsOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactGetItemsOutputTransformInput dafnyValue = ToDafny.TransactGetItemsOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactGetItemsOutputTransformOutput, Error> result = this._impl.TransactGetItemsOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.TransactGetItemsOutputTransformOutput(result.dtor_value());
  }

  public ExecuteStatementInputTransformOutput ExecuteStatementInputTransform(
      ExecuteStatementInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteStatementInputTransformInput dafnyValue = ToDafny.ExecuteStatementInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteStatementInputTransformOutput, Error> result = this._impl.ExecuteStatementInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ExecuteStatementInputTransformOutput(result.dtor_value());
  }

  public ExecuteStatementOutputTransformOutput ExecuteStatementOutputTransform(
      ExecuteStatementOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteStatementOutputTransformInput dafnyValue = ToDafny.ExecuteStatementOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteStatementOutputTransformOutput, Error> result = this._impl.ExecuteStatementOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ExecuteStatementOutputTransformOutput(result.dtor_value());
  }

  public BatchExecuteStatementInputTransformOutput BatchExecuteStatementInputTransform(
      BatchExecuteStatementInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchExecuteStatementInputTransformInput dafnyValue = ToDafny.BatchExecuteStatementInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchExecuteStatementInputTransformOutput, Error> result = this._impl.BatchExecuteStatementInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchExecuteStatementInputTransformOutput(result.dtor_value());
  }

  public BatchExecuteStatementOutputTransformOutput BatchExecuteStatementOutputTransform(
      BatchExecuteStatementOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchExecuteStatementOutputTransformInput dafnyValue = ToDafny.BatchExecuteStatementOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchExecuteStatementOutputTransformOutput, Error> result = this._impl.BatchExecuteStatementOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.BatchExecuteStatementOutputTransformOutput(result.dtor_value());
  }

  public ExecuteTransactionInputTransformOutput ExecuteTransactionInputTransform(
      ExecuteTransactionInputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteTransactionInputTransformInput dafnyValue = ToDafny.ExecuteTransactionInputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteTransactionInputTransformOutput, Error> result = this._impl.ExecuteTransactionInputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ExecuteTransactionInputTransformOutput(result.dtor_value());
  }

  public ExecuteTransactionOutputTransformOutput ExecuteTransactionOutputTransform(
      ExecuteTransactionOutputTransformInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteTransactionOutputTransformInput dafnyValue = ToDafny.ExecuteTransactionOutputTransformInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteTransactionOutputTransformOutput, Error> result = this._impl.ExecuteTransactionOutputTransform(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.ExecuteTransactionOutputTransformOutput(result.dtor_value());
  }

  public interface Builder {
    Builder DynamoDbEncryptionConfig(DynamoDbEncryptionConfig DynamoDbEncryptionConfig);

    DynamoDbEncryptionConfig DynamoDbEncryptionConfig();

    DynamoDbEncryptionMiddlewareInternal build();
  }

  static class BuilderImpl implements Builder {
    protected DynamoDbEncryptionConfig DynamoDbEncryptionConfig;

    protected BuilderImpl() {
    }

    public Builder DynamoDbEncryptionConfig(DynamoDbEncryptionConfig DynamoDbEncryptionConfig) {
      this.DynamoDbEncryptionConfig = DynamoDbEncryptionConfig;
      return this;
    }

    public DynamoDbEncryptionConfig DynamoDbEncryptionConfig() {
      return this.DynamoDbEncryptionConfig;
    }

    public DynamoDbEncryptionMiddlewareInternal build() {
      if (Objects.isNull(this.DynamoDbEncryptionConfig()))  {
        throw new IllegalArgumentException("Missing value for required field `DynamoDbEncryptionConfig`");
      }
      return new DynamoDbEncryptionMiddlewareInternal(this);
    }
  }
}
