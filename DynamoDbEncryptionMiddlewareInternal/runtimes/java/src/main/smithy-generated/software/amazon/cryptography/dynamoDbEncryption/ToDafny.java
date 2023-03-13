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
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DeleteItemInputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DeleteItemInputTransformOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DeleteItemOutputTransformInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DeleteItemOutputTransformOutput;
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
import Dafny.Com.Amazonaws.Dynamodb.Types.DeleteItemInput;
import Dafny.Com.Amazonaws.Dynamodb.Types.DeleteItemOutput;
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
    allowedUnauthenticatedAttributes = (Objects.nonNull(nativeValue.allowedUnauthenticatedAttributes()) && nativeValue.allowedUnauthenticatedAttributes().size() > 0) ?
        Option.create_Some(Dafny.Com.Amazonaws.Dynamodb.ToDafny.AttributeNameList(nativeValue.allowedUnauthenticatedAttributes()))
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
        Option.create_Some(software.amazon.cryptography.materialProviders.ToDafny.Keyring(nativeValue.keyring()))
        : Option.create_None();
    Option<ICryptographicMaterialsManager> cmm;
    cmm = Objects.nonNull(nativeValue.cmm()) ?
        Option.create_Some(software.amazon.cryptography.materialProviders.ToDafny.CryptographicMaterialsManager(nativeValue.cmm()))
        : Option.create_None();
    return new DynamoDbTableEncryptionConfig(partitionKeyName, sortKeyName, attributeActions, allowedUnauthenticatedAttributes, allowedUnauthenticatedAttributePrefix, algorithmSuiteId, keyring, cmm);
  }

  public static PutItemInputTransformInput PutItemInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.PutItemInputTransformInput nativeValue) {
    PutItemInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.PutItemInput(nativeValue.sdkInput());
    return new PutItemInputTransformInput(sdkInput);
  }

  public static TransactWriteItemsOutputTransformInput TransactWriteItemsOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.TransactWriteItemsOutputTransformInput nativeValue) {
    TransactWriteItemsOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.TransactWriteItemsOutput(nativeValue.sdkOutput());
    TransactWriteItemsInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.TransactWriteItemsInput(nativeValue.originalInput());
    return new TransactWriteItemsOutputTransformInput(sdkOutput, originalInput);
  }

  public static ScanOutputTransformInput ScanOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.ScanOutputTransformInput nativeValue) {
    ScanOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ScanOutput(nativeValue.sdkOutput());
    ScanInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ScanInput(nativeValue.originalInput());
    return new ScanOutputTransformInput(sdkOutput, originalInput);
  }

  public static DeleteItemOutputTransformInput DeleteItemOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.DeleteItemOutputTransformInput nativeValue) {
    DeleteItemOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.DeleteItemOutput(nativeValue.sdkOutput());
    DeleteItemInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.DeleteItemInput(nativeValue.originalInput());
    return new DeleteItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static BatchExecuteStatementInputTransformInput BatchExecuteStatementInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchExecuteStatementInputTransformInput nativeValue) {
    BatchExecuteStatementInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchExecuteStatementInput(nativeValue.sdkInput());
    return new BatchExecuteStatementInputTransformInput(sdkInput);
  }

  public static ExecuteStatementInputTransformOutput ExecuteStatementInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.ExecuteStatementInputTransformOutput nativeValue) {
    ExecuteStatementInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ExecuteStatementInput(nativeValue.transformedInput());
    return new ExecuteStatementInputTransformOutput(transformedInput);
  }

  public static GetItemOutputTransformOutput GetItemOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.GetItemOutputTransformOutput nativeValue) {
    GetItemOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.GetItemOutput(nativeValue.transformedOutput());
    return new GetItemOutputTransformOutput(transformedOutput);
  }

  public static BatchGetItemOutputTransformOutput BatchGetItemOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchGetItemOutputTransformOutput nativeValue) {
    BatchGetItemOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchGetItemOutput(nativeValue.transformedOutput());
    return new BatchGetItemOutputTransformOutput(transformedOutput);
  }

  public static DeleteItemOutputTransformOutput DeleteItemOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.DeleteItemOutputTransformOutput nativeValue) {
    DeleteItemOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.DeleteItemOutput(nativeValue.transformedOutput());
    return new DeleteItemOutputTransformOutput(transformedOutput);
  }

  public static DeleteItemInputTransformOutput DeleteItemInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.DeleteItemInputTransformOutput nativeValue) {
    DeleteItemInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.DeleteItemInput(nativeValue.transformedInput());
    return new DeleteItemInputTransformOutput(transformedInput);
  }

  public static UpdateItemOutputTransformOutput UpdateItemOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.UpdateItemOutputTransformOutput nativeValue) {
    UpdateItemOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.UpdateItemOutput(nativeValue.transformedOutput());
    return new UpdateItemOutputTransformOutput(transformedOutput);
  }

  public static PutItemOutputTransformInput PutItemOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.PutItemOutputTransformInput nativeValue) {
    PutItemOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.PutItemOutput(nativeValue.sdkOutput());
    PutItemInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.PutItemInput(nativeValue.originalInput());
    return new PutItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static BatchGetItemInputTransformOutput BatchGetItemInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchGetItemInputTransformOutput nativeValue) {
    BatchGetItemInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchGetItemInput(nativeValue.transformedInput());
    return new BatchGetItemInputTransformOutput(transformedInput);
  }

  public static BatchExecuteStatementOutputTransformInput BatchExecuteStatementOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchExecuteStatementOutputTransformInput nativeValue) {
    BatchExecuteStatementOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchExecuteStatementOutput(nativeValue.sdkOutput());
    BatchExecuteStatementInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchExecuteStatementInput(nativeValue.originalInput());
    return new BatchExecuteStatementOutputTransformInput(sdkOutput, originalInput);
  }

  public static PutItemInputTransformOutput PutItemInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.PutItemInputTransformOutput nativeValue) {
    PutItemInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.PutItemInput(nativeValue.transformedInput());
    return new PutItemInputTransformOutput(transformedInput);
  }

  public static BatchGetItemOutputTransformInput BatchGetItemOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchGetItemOutputTransformInput nativeValue) {
    BatchGetItemOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchGetItemOutput(nativeValue.sdkOutput());
    BatchGetItemInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchGetItemInput(nativeValue.originalInput());
    return new BatchGetItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static QueryOutputTransformInput QueryOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.QueryOutputTransformInput nativeValue) {
    QueryOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.QueryOutput(nativeValue.sdkOutput());
    QueryInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.QueryInput(nativeValue.originalInput());
    return new QueryOutputTransformInput(sdkOutput, originalInput);
  }

  public static DeleteItemInputTransformInput DeleteItemInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.DeleteItemInputTransformInput nativeValue) {
    DeleteItemInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.DeleteItemInput(nativeValue.sdkInput());
    return new DeleteItemInputTransformInput(sdkInput);
  }

  public static TransactWriteItemsInputTransformOutput TransactWriteItemsInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.TransactWriteItemsInputTransformOutput nativeValue) {
    TransactWriteItemsInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.TransactWriteItemsInput(nativeValue.transformedInput());
    return new TransactWriteItemsInputTransformOutput(transformedInput);
  }

  public static GetItemInputTransformOutput GetItemInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.GetItemInputTransformOutput nativeValue) {
    GetItemInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.GetItemInput(nativeValue.transformedInput());
    return new GetItemInputTransformOutput(transformedInput);
  }

  public static GetItemInputTransformInput GetItemInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.GetItemInputTransformInput nativeValue) {
    GetItemInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.GetItemInput(nativeValue.sdkInput());
    return new GetItemInputTransformInput(sdkInput);
  }

  public static QueryInputTransformOutput QueryInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.QueryInputTransformOutput nativeValue) {
    QueryInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.QueryInput(nativeValue.transformedInput());
    return new QueryInputTransformOutput(transformedInput);
  }

  public static BatchWriteItemOutputTransformOutput BatchWriteItemOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchWriteItemOutputTransformOutput nativeValue) {
    BatchWriteItemOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchWriteItemOutput(nativeValue.transformedOutput());
    return new BatchWriteItemOutputTransformOutput(transformedOutput);
  }

  public static GetItemOutputTransformInput GetItemOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.GetItemOutputTransformInput nativeValue) {
    GetItemOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.GetItemOutput(nativeValue.sdkOutput());
    GetItemInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.GetItemInput(nativeValue.originalInput());
    return new GetItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static PutItemOutputTransformOutput PutItemOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.PutItemOutputTransformOutput nativeValue) {
    PutItemOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.PutItemOutput(nativeValue.transformedOutput());
    return new PutItemOutputTransformOutput(transformedOutput);
  }

  public static ExecuteTransactionOutputTransformOutput ExecuteTransactionOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.ExecuteTransactionOutputTransformOutput nativeValue) {
    ExecuteTransactionOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ExecuteTransactionOutput(nativeValue.transformedOutput());
    return new ExecuteTransactionOutputTransformOutput(transformedOutput);
  }

  public static ExecuteStatementOutputTransformOutput ExecuteStatementOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.ExecuteStatementOutputTransformOutput nativeValue) {
    ExecuteStatementOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ExecuteStatementOutput(nativeValue.transformedOutput());
    return new ExecuteStatementOutputTransformOutput(transformedOutput);
  }

  public static QueryOutputTransformOutput QueryOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.QueryOutputTransformOutput nativeValue) {
    QueryOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.QueryOutput(nativeValue.transformedOutput());
    return new QueryOutputTransformOutput(transformedOutput);
  }

  public static BatchExecuteStatementInputTransformOutput BatchExecuteStatementInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchExecuteStatementInputTransformOutput nativeValue) {
    BatchExecuteStatementInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchExecuteStatementInput(nativeValue.transformedInput());
    return new BatchExecuteStatementInputTransformOutput(transformedInput);
  }

  public static TransactWriteItemsInputTransformInput TransactWriteItemsInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.TransactWriteItemsInputTransformInput nativeValue) {
    TransactWriteItemsInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.TransactWriteItemsInput(nativeValue.sdkInput());
    return new TransactWriteItemsInputTransformInput(sdkInput);
  }

  public static BatchGetItemInputTransformInput BatchGetItemInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchGetItemInputTransformInput nativeValue) {
    BatchGetItemInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchGetItemInput(nativeValue.sdkInput());
    return new BatchGetItemInputTransformInput(sdkInput);
  }

  public static ExecuteStatementOutputTransformInput ExecuteStatementOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.ExecuteStatementOutputTransformInput nativeValue) {
    ExecuteStatementOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ExecuteStatementOutput(nativeValue.sdkOutput());
    ExecuteStatementInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ExecuteStatementInput(nativeValue.originalInput());
    return new ExecuteStatementOutputTransformInput(sdkOutput, originalInput);
  }

  public static ScanOutputTransformOutput ScanOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.ScanOutputTransformOutput nativeValue) {
    ScanOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ScanOutput(nativeValue.transformedOutput());
    return new ScanOutputTransformOutput(transformedOutput);
  }

  public static UpdateItemInputTransformInput UpdateItemInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.UpdateItemInputTransformInput nativeValue) {
    UpdateItemInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.UpdateItemInput(nativeValue.sdkInput());
    return new UpdateItemInputTransformInput(sdkInput);
  }

  public static BatchWriteItemInputTransformOutput BatchWriteItemInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchWriteItemInputTransformOutput nativeValue) {
    BatchWriteItemInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchWriteItemInput(nativeValue.transformedInput());
    return new BatchWriteItemInputTransformOutput(transformedInput);
  }

  public static TransactWriteItemsOutputTransformOutput TransactWriteItemsOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.TransactWriteItemsOutputTransformOutput nativeValue) {
    TransactWriteItemsOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.TransactWriteItemsOutput(nativeValue.transformedOutput());
    return new TransactWriteItemsOutputTransformOutput(transformedOutput);
  }

  public static TransactGetItemsInputTransformInput TransactGetItemsInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.TransactGetItemsInputTransformInput nativeValue) {
    TransactGetItemsInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.TransactGetItemsInput(nativeValue.sdkInput());
    return new TransactGetItemsInputTransformInput(sdkInput);
  }

  public static DynamoDbEncryptionConfig DynamoDbEncryptionConfig(
      software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionConfig nativeValue) {
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends DynamoDbTableEncryptionConfig> tableEncryptionConfigs;
    tableEncryptionConfigs = ToDafny.DynamoDbTableEncryptionConfigs(nativeValue.tableEncryptionConfigs());
    return new DynamoDbEncryptionConfig(tableEncryptionConfigs);
  }

  public static BatchExecuteStatementOutputTransformOutput BatchExecuteStatementOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchExecuteStatementOutputTransformOutput nativeValue) {
    BatchExecuteStatementOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchExecuteStatementOutput(nativeValue.transformedOutput());
    return new BatchExecuteStatementOutputTransformOutput(transformedOutput);
  }

  public static ExecuteTransactionInputTransformInput ExecuteTransactionInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.ExecuteTransactionInputTransformInput nativeValue) {
    ExecuteTransactionInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ExecuteTransactionInput(nativeValue.sdkInput());
    return new ExecuteTransactionInputTransformInput(sdkInput);
  }

  public static TransactGetItemsOutputTransformInput TransactGetItemsOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.TransactGetItemsOutputTransformInput nativeValue) {
    TransactGetItemsOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.TransactGetItemsOutput(nativeValue.sdkOutput());
    TransactGetItemsInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.TransactGetItemsInput(nativeValue.originalInput());
    return new TransactGetItemsOutputTransformInput(sdkOutput, originalInput);
  }

  public static UpdateItemOutputTransformInput UpdateItemOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.UpdateItemOutputTransformInput nativeValue) {
    UpdateItemOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.UpdateItemOutput(nativeValue.sdkOutput());
    UpdateItemInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.UpdateItemInput(nativeValue.originalInput());
    return new UpdateItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static BatchWriteItemInputTransformInput BatchWriteItemInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchWriteItemInputTransformInput nativeValue) {
    BatchWriteItemInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchWriteItemInput(nativeValue.sdkInput());
    return new BatchWriteItemInputTransformInput(sdkInput);
  }

  public static ScanInputTransformInput ScanInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.ScanInputTransformInput nativeValue) {
    ScanInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ScanInput(nativeValue.sdkInput());
    return new ScanInputTransformInput(sdkInput);
  }

  public static BatchWriteItemOutputTransformInput BatchWriteItemOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.BatchWriteItemOutputTransformInput nativeValue) {
    BatchWriteItemOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchWriteItemOutput(nativeValue.sdkOutput());
    BatchWriteItemInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.BatchWriteItemInput(nativeValue.originalInput());
    return new BatchWriteItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static QueryInputTransformInput QueryInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.QueryInputTransformInput nativeValue) {
    QueryInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.QueryInput(nativeValue.sdkInput());
    return new QueryInputTransformInput(sdkInput);
  }

  public static TransactGetItemsInputTransformOutput TransactGetItemsInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.TransactGetItemsInputTransformOutput nativeValue) {
    TransactGetItemsInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.TransactGetItemsInput(nativeValue.transformedInput());
    return new TransactGetItemsInputTransformOutput(transformedInput);
  }

  public static TransactGetItemsOutputTransformOutput TransactGetItemsOutputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.TransactGetItemsOutputTransformOutput nativeValue) {
    TransactGetItemsOutput transformedOutput;
    transformedOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.TransactGetItemsOutput(nativeValue.transformedOutput());
    return new TransactGetItemsOutputTransformOutput(transformedOutput);
  }

  public static ExecuteStatementInputTransformInput ExecuteStatementInputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.ExecuteStatementInputTransformInput nativeValue) {
    ExecuteStatementInput sdkInput;
    sdkInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ExecuteStatementInput(nativeValue.sdkInput());
    return new ExecuteStatementInputTransformInput(sdkInput);
  }

  public static ExecuteTransactionInputTransformOutput ExecuteTransactionInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.ExecuteTransactionInputTransformOutput nativeValue) {
    ExecuteTransactionInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ExecuteTransactionInput(nativeValue.transformedInput());
    return new ExecuteTransactionInputTransformOutput(transformedInput);
  }

  public static UpdateItemInputTransformOutput UpdateItemInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.UpdateItemInputTransformOutput nativeValue) {
    UpdateItemInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.UpdateItemInput(nativeValue.transformedInput());
    return new UpdateItemInputTransformOutput(transformedInput);
  }

  public static ExecuteTransactionOutputTransformInput ExecuteTransactionOutputTransformInput(
      software.amazon.cryptography.dynamoDbEncryption.model.ExecuteTransactionOutputTransformInput nativeValue) {
    ExecuteTransactionOutput sdkOutput;
    sdkOutput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ExecuteTransactionOutput(nativeValue.sdkOutput());
    ExecuteTransactionInput originalInput;
    originalInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ExecuteTransactionInput(nativeValue.originalInput());
    return new ExecuteTransactionOutputTransformInput(sdkOutput, originalInput);
  }

  public static ScanInputTransformOutput ScanInputTransformOutput(
      software.amazon.cryptography.dynamoDbEncryption.model.ScanInputTransformOutput nativeValue) {
    ScanInput transformedInput;
    transformedInput = Dafny.Com.Amazonaws.Dynamodb.ToDafny.ScanInput(nativeValue.transformedInput());
    return new ScanInputTransformOutput(transformedInput);
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
