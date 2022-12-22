// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal;

// TODO manually updated this file to update Dafny.Com.Amazonaws.Dynamodb -> Dafny.Com.Amazonaws.Dynamodb

import Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.Error;
import Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.Error_Collection;
import Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.Error_DynamoDbEncryptionMiddlewareInternalException;
import Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.Error_Opaque;
import dafny.DafnyMap;
import dafny.DafnySequence;
import java.lang.Character;
import java.lang.String;
import java.util.Map;
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
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.CollectionOfErrors;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.DeleteItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.DeleteItemInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.DeleteItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.DeleteItemOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.DynamoDbEncryptionMiddlewareInternalConfig;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.DynamoDbEncryptionMiddlewareInternalException;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.DynamoDbTableEncryptionConfig;
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
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.NativeError;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.OpaqueError;
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

public class ToNative {
  public static OpaqueError Error(Error_Opaque dafnyValue) {
    OpaqueError.Builder nativeBuilder = OpaqueError.builder();
    nativeBuilder.obj(dafnyValue.dtor_obj());
    return nativeBuilder.build();
  }

  public static CollectionOfErrors Error(Error_Collection dafnyValue) {
    CollectionOfErrors.Builder nativeBuilder = CollectionOfErrors.builder();
    nativeBuilder.list(
        software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue.dtor_list(), 
        ToNative::Error));
    return nativeBuilder.build();
  }

  public static DynamoDbEncryptionMiddlewareInternalException Error(
      Error_DynamoDbEncryptionMiddlewareInternalException dafnyValue) {
    DynamoDbEncryptionMiddlewareInternalException.Builder nativeBuilder = DynamoDbEncryptionMiddlewareInternalException.builder();
    nativeBuilder.message(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_message()));
    return nativeBuilder.build();
  }

  public static NativeError Error(Error dafnyValue) {
    if (dafnyValue.is_DynamoDbEncryptionMiddlewareInternalException()) {
      return ToNative.Error((Error_DynamoDbEncryptionMiddlewareInternalException) dafnyValue);
    }
    if (dafnyValue.is_Opaque()) {
      return ToNative.Error((Error_Opaque) dafnyValue);
    }
    if (dafnyValue.is_Collection()) {
      return ToNative.Error((Error_Collection) dafnyValue);
    }
    OpaqueError.Builder nativeBuilder = OpaqueError.builder();
    nativeBuilder.obj(dafnyValue);
    return nativeBuilder.build();
  }

  public static TransactGetItemsOutputTransformOutput TransactGetItemsOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.TransactGetItemsOutputTransformOutput dafnyValue) {
    TransactGetItemsOutputTransformOutput.Builder nativeBuilder = TransactGetItemsOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactGetItemsOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static BatchExecuteStatementInputTransformInput BatchExecuteStatementInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchExecuteStatementInputTransformInput dafnyValue) {
    BatchExecuteStatementInputTransformInput.Builder nativeBuilder = BatchExecuteStatementInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchExecuteStatementInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static DeleteItemOutputTransformInput DeleteItemOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.DeleteItemOutputTransformInput dafnyValue) {
    DeleteItemOutputTransformInput.Builder nativeBuilder = DeleteItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DeleteItemOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DeleteItemInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static QueryInputTransformOutput QueryInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.QueryInputTransformOutput dafnyValue) {
    QueryInputTransformOutput.Builder nativeBuilder = QueryInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.QueryInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static BatchGetItemOutputTransformOutput BatchGetItemOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchGetItemOutputTransformOutput dafnyValue) {
    BatchGetItemOutputTransformOutput.Builder nativeBuilder = BatchGetItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchGetItemOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static PutItemInputTransformInput PutItemInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.PutItemInputTransformInput dafnyValue) {
    PutItemInputTransformInput.Builder nativeBuilder = PutItemInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.PutItemInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static GetItemInputTransformInput GetItemInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.GetItemInputTransformInput dafnyValue) {
    GetItemInputTransformInput.Builder nativeBuilder = GetItemInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.GetItemInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static ScanOutputTransformInput ScanOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ScanOutputTransformInput dafnyValue) {
    ScanOutputTransformInput.Builder nativeBuilder = ScanOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ScanOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ScanInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static TransactWriteItemsOutputTransformInput TransactWriteItemsOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.TransactWriteItemsOutputTransformInput dafnyValue) {
    TransactWriteItemsOutputTransformInput.Builder nativeBuilder = TransactWriteItemsOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactWriteItemsOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactWriteItemsInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static ScanInputTransformOutput ScanInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ScanInputTransformOutput dafnyValue) {
    ScanInputTransformOutput.Builder nativeBuilder = ScanInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ScanInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static BatchWriteItemOutputTransformInput BatchWriteItemOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchWriteItemOutputTransformInput dafnyValue) {
    BatchWriteItemOutputTransformInput.Builder nativeBuilder = BatchWriteItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchWriteItemOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchWriteItemInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static TransactWriteItemsInputTransformOutput TransactWriteItemsInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.TransactWriteItemsInputTransformOutput dafnyValue) {
    TransactWriteItemsInputTransformOutput.Builder nativeBuilder = TransactWriteItemsInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactWriteItemsInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static TransactGetItemsInputTransformOutput TransactGetItemsInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.TransactGetItemsInputTransformOutput dafnyValue) {
    TransactGetItemsInputTransformOutput.Builder nativeBuilder = TransactGetItemsInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactGetItemsInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static BatchGetItemOutputTransformInput BatchGetItemOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchGetItemOutputTransformInput dafnyValue) {
    BatchGetItemOutputTransformInput.Builder nativeBuilder = BatchGetItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchGetItemOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchGetItemInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static GetItemInputTransformOutput GetItemInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.GetItemInputTransformOutput dafnyValue) {
    GetItemInputTransformOutput.Builder nativeBuilder = GetItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.GetItemInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static ExecuteTransactionInputTransformOutput ExecuteTransactionInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ExecuteTransactionInputTransformOutput dafnyValue) {
    ExecuteTransactionInputTransformOutput.Builder nativeBuilder = ExecuteTransactionInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteTransactionInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static BatchWriteItemInputTransformInput BatchWriteItemInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchWriteItemInputTransformInput dafnyValue) {
    BatchWriteItemInputTransformInput.Builder nativeBuilder = BatchWriteItemInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchWriteItemInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static ExecuteStatementInputTransformInput ExecuteStatementInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ExecuteStatementInputTransformInput dafnyValue) {
    ExecuteStatementInputTransformInput.Builder nativeBuilder = ExecuteStatementInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteStatementInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static BatchExecuteStatementOutputTransformInput BatchExecuteStatementOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchExecuteStatementOutputTransformInput dafnyValue) {
    BatchExecuteStatementOutputTransformInput.Builder nativeBuilder = BatchExecuteStatementOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchExecuteStatementOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchExecuteStatementInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static UpdateItemOutputTransformOutput UpdateItemOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.UpdateItemOutputTransformOutput dafnyValue) {
    UpdateItemOutputTransformOutput.Builder nativeBuilder = UpdateItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateItemOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static QueryInputTransformInput QueryInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.QueryInputTransformInput dafnyValue) {
    QueryInputTransformInput.Builder nativeBuilder = QueryInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.QueryInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static ExecuteTransactionOutputTransformInput ExecuteTransactionOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ExecuteTransactionOutputTransformInput dafnyValue) {
    ExecuteTransactionOutputTransformInput.Builder nativeBuilder = ExecuteTransactionOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteTransactionOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteTransactionInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static UpdateItemOutputTransformInput UpdateItemOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.UpdateItemOutputTransformInput dafnyValue) {
    UpdateItemOutputTransformInput.Builder nativeBuilder = UpdateItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateItemOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateItemInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static DeleteItemInputTransformOutput DeleteItemInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.DeleteItemInputTransformOutput dafnyValue) {
    DeleteItemInputTransformOutput.Builder nativeBuilder = DeleteItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DeleteItemInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static TransactGetItemsOutputTransformInput TransactGetItemsOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.TransactGetItemsOutputTransformInput dafnyValue) {
    TransactGetItemsOutputTransformInput.Builder nativeBuilder = TransactGetItemsOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactGetItemsOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactGetItemsInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static ScanInputTransformInput ScanInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ScanInputTransformInput dafnyValue) {
    ScanInputTransformInput.Builder nativeBuilder = ScanInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ScanInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static DynamoDbTableEncryptionConfig DynamoDbTableEncryptionConfig(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.DynamoDbTableEncryptionConfig dafnyValue) {
    DynamoDbTableEncryptionConfig.Builder nativeBuilder = DynamoDbTableEncryptionConfig.builder();
    nativeBuilder.partitionKeyName(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_partitionKeyName()));
    if (dafnyValue.dtor_sortKeyName().is_Some()) {
      nativeBuilder.sortKeyName(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_sortKeyName().dtor_value()));
    }
    nativeBuilder.attributeActions(software.amazon.cryptography.dynamoDbItemEncryptor.ToNative.AttributeActions(dafnyValue.dtor_attributeActions()));
    if (dafnyValue.dtor_allowedUnauthenticatedAttributes().is_Some()) {
      nativeBuilder.allowedUnauthenticatedAttributes(Dafny.Com.Amazonaws.Dynamodb.ToNative.AttributeNameList(dafnyValue.dtor_allowedUnauthenticatedAttributes().dtor_value()));
    }
    if (dafnyValue.dtor_allowedUnauthenticatedAttributePrefix().is_Some()) {
      nativeBuilder.allowedUnauthenticatedAttributePrefix(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_allowedUnauthenticatedAttributePrefix().dtor_value()));
    }
    if (dafnyValue.dtor_keyring().is_Some()) {
      nativeBuilder.keyring(software.amazon.cryptography.materialProviders.ToNative.Keyring(dafnyValue.dtor_keyring().dtor_value()));
    }
    if (dafnyValue.dtor_cmm().is_Some()) {
      nativeBuilder.cmm(software.amazon.cryptography.materialProviders.ToNative.CryptographicMaterialsManager(dafnyValue.dtor_cmm().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static ScanOutputTransformOutput ScanOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ScanOutputTransformOutput dafnyValue) {
    ScanOutputTransformOutput.Builder nativeBuilder = ScanOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ScanOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static TransactWriteItemsInputTransformInput TransactWriteItemsInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.TransactWriteItemsInputTransformInput dafnyValue) {
    TransactWriteItemsInputTransformInput.Builder nativeBuilder = TransactWriteItemsInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactWriteItemsInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static BatchGetItemInputTransformInput BatchGetItemInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchGetItemInputTransformInput dafnyValue) {
    BatchGetItemInputTransformInput.Builder nativeBuilder = BatchGetItemInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchGetItemInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static ExecuteTransactionOutputTransformOutput ExecuteTransactionOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ExecuteTransactionOutputTransformOutput dafnyValue) {
    ExecuteTransactionOutputTransformOutput.Builder nativeBuilder = ExecuteTransactionOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteTransactionOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static BatchExecuteStatementInputTransformOutput BatchExecuteStatementInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchExecuteStatementInputTransformOutput dafnyValue) {
    BatchExecuteStatementInputTransformOutput.Builder nativeBuilder = BatchExecuteStatementInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchExecuteStatementInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static BatchWriteItemOutputTransformOutput BatchWriteItemOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchWriteItemOutputTransformOutput dafnyValue) {
    BatchWriteItemOutputTransformOutput.Builder nativeBuilder = BatchWriteItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchWriteItemOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static BatchExecuteStatementOutputTransformOutput BatchExecuteStatementOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchExecuteStatementOutputTransformOutput dafnyValue) {
    BatchExecuteStatementOutputTransformOutput.Builder nativeBuilder = BatchExecuteStatementOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchExecuteStatementOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static DynamoDbEncryptionMiddlewareInternalConfig DynamoDbEncryptionMiddlewareInternalConfig(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.DynamoDbEncryptionMiddlewareInternalConfig dafnyValue) {
    DynamoDbEncryptionMiddlewareInternalConfig.Builder nativeBuilder = DynamoDbEncryptionMiddlewareInternalConfig.builder();
    nativeBuilder.tableEncryptionConfigs(ToNative.DynamoDbTableEncryptionConfigs(dafnyValue.dtor_tableEncryptionConfigs()));
    return nativeBuilder.build();
  }

  public static TransactWriteItemsOutputTransformOutput TransactWriteItemsOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.TransactWriteItemsOutputTransformOutput dafnyValue) {
    TransactWriteItemsOutputTransformOutput.Builder nativeBuilder = TransactWriteItemsOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactWriteItemsOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static GetItemOutputTransformInput GetItemOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.GetItemOutputTransformInput dafnyValue) {
    GetItemOutputTransformInput.Builder nativeBuilder = GetItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.GetItemOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.GetItemInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static ExecuteStatementOutputTransformInput ExecuteStatementOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ExecuteStatementOutputTransformInput dafnyValue) {
    ExecuteStatementOutputTransformInput.Builder nativeBuilder = ExecuteStatementOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteStatementOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteStatementInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static UpdateItemInputTransformOutput UpdateItemInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.UpdateItemInputTransformOutput dafnyValue) {
    UpdateItemInputTransformOutput.Builder nativeBuilder = UpdateItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateItemInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static DeleteItemOutputTransformOutput DeleteItemOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.DeleteItemOutputTransformOutput dafnyValue) {
    DeleteItemOutputTransformOutput.Builder nativeBuilder = DeleteItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DeleteItemOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static ExecuteStatementOutputTransformOutput ExecuteStatementOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ExecuteStatementOutputTransformOutput dafnyValue) {
    ExecuteStatementOutputTransformOutput.Builder nativeBuilder = ExecuteStatementOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteStatementOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static QueryOutputTransformOutput QueryOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.QueryOutputTransformOutput dafnyValue) {
    QueryOutputTransformOutput.Builder nativeBuilder = QueryOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.QueryOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static BatchGetItemInputTransformOutput BatchGetItemInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchGetItemInputTransformOutput dafnyValue) {
    BatchGetItemInputTransformOutput.Builder nativeBuilder = BatchGetItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchGetItemInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static ExecuteStatementInputTransformOutput ExecuteStatementInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ExecuteStatementInputTransformOutput dafnyValue) {
    ExecuteStatementInputTransformOutput.Builder nativeBuilder = ExecuteStatementInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteStatementInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static ExecuteTransactionInputTransformInput ExecuteTransactionInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.ExecuteTransactionInputTransformInput dafnyValue) {
    ExecuteTransactionInputTransformInput.Builder nativeBuilder = ExecuteTransactionInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteTransactionInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static BatchWriteItemInputTransformOutput BatchWriteItemInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.BatchWriteItemInputTransformOutput dafnyValue) {
    BatchWriteItemInputTransformOutput.Builder nativeBuilder = BatchWriteItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchWriteItemInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static QueryOutputTransformInput QueryOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.QueryOutputTransformInput dafnyValue) {
    QueryOutputTransformInput.Builder nativeBuilder = QueryOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.QueryOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.QueryInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static TransactGetItemsInputTransformInput TransactGetItemsInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.TransactGetItemsInputTransformInput dafnyValue) {
    TransactGetItemsInputTransformInput.Builder nativeBuilder = TransactGetItemsInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactGetItemsInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static DeleteItemInputTransformInput DeleteItemInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.DeleteItemInputTransformInput dafnyValue) {
    DeleteItemInputTransformInput.Builder nativeBuilder = DeleteItemInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DeleteItemInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static PutItemInputTransformOutput PutItemInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.PutItemInputTransformOutput dafnyValue) {
    PutItemInputTransformOutput.Builder nativeBuilder = PutItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.PutItemInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static GetItemOutputTransformOutput GetItemOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.GetItemOutputTransformOutput dafnyValue) {
    GetItemOutputTransformOutput.Builder nativeBuilder = GetItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.GetItemOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static PutItemOutputTransformOutput PutItemOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.PutItemOutputTransformOutput dafnyValue) {
    PutItemOutputTransformOutput.Builder nativeBuilder = PutItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.PutItemOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static UpdateItemInputTransformInput UpdateItemInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.UpdateItemInputTransformInput dafnyValue) {
    UpdateItemInputTransformInput.Builder nativeBuilder = UpdateItemInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateItemInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static PutItemOutputTransformInput PutItemOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.PutItemOutputTransformInput dafnyValue) {
    PutItemOutputTransformInput.Builder nativeBuilder = PutItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.PutItemOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.PutItemInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static Map<String, DynamoDbTableEncryptionConfig> DynamoDbTableEncryptionConfigs(
      DafnyMap<? extends DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.DynamoDbEncryptionMiddleware.Internal.Types.DynamoDbTableEncryptionConfig> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToMap(
        dafnyValue, 
        software.amazon.dafny.conversion.ToNative.Simple::String, 
        software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.ToNative::DynamoDbTableEncryptionConfig);
  }
}
