// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption;

import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error_CollectionOfErrors;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error_DynamoDbEncryptionException;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error_Opaque;
import dafny.DafnyMap;
import dafny.DafnySequence;
import java.lang.Character;
import java.lang.String;
import java.util.List;
import java.util.Map;
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
import software.amazon.cryptography.dynamoDbEncryption.model.BeaconVersion;
import software.amazon.cryptography.dynamoDbEncryption.model.CollectionOfErrors;
import software.amazon.cryptography.dynamoDbEncryption.model.CompoundBeacon;
import software.amazon.cryptography.dynamoDbEncryption.model.Constructor;
import software.amazon.cryptography.dynamoDbEncryption.model.ConstructorPart;
import software.amazon.cryptography.dynamoDbEncryption.model.CreateTableInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.CreateTableInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.CreateTableOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.CreateTableOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.DeleteItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.DeleteItemInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.DeleteItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.DeleteItemOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.DescribeTableInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.DescribeTableInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.DescribeTableOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.DescribeTableOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionException;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTableEncryptionConfig;
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
import software.amazon.cryptography.dynamoDbEncryption.model.GetPrefix;
import software.amazon.cryptography.dynamoDbEncryption.model.GetSegment;
import software.amazon.cryptography.dynamoDbEncryption.model.GetSubstring;
import software.amazon.cryptography.dynamoDbEncryption.model.GetSuffix;
import software.amazon.cryptography.dynamoDbEncryption.model.Insert;
import software.amazon.cryptography.dynamoDbEncryption.model.Lower;
import software.amazon.cryptography.dynamoDbEncryption.model.NativeError;
import software.amazon.cryptography.dynamoDbEncryption.model.NonSensitivePart;
import software.amazon.cryptography.dynamoDbEncryption.model.OpaqueError;
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
import software.amazon.cryptography.dynamoDbEncryption.model.SearchConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.SensitivePart;
import software.amazon.cryptography.dynamoDbEncryption.model.StandardBeacon;
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
import software.amazon.cryptography.dynamoDbEncryption.model.UpdateTableInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.UpdateTableInputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.UpdateTableOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryption.model.UpdateTableOutputTransformOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.Upper;
import software.amazon.cryptography.dynamoDbEncryption.model.VirtualField;
import software.amazon.cryptography.dynamoDbEncryption.model.VirtualPart;
import software.amazon.cryptography.dynamoDbEncryption.model.VirtualTransform;

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

  public static DynamoDbEncryptionException Error(Error_DynamoDbEncryptionException dafnyValue) {
    DynamoDbEncryptionException.Builder nativeBuilder = DynamoDbEncryptionException.builder();
    nativeBuilder.message(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_message()));
    return nativeBuilder.build();
  }

  public static NativeError Error(Error dafnyValue) {
    if (dafnyValue.is_DynamoDbEncryptionException()) {
      return ToNative.Error((Error_DynamoDbEncryptionException) dafnyValue);
    }
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

  public static GetSuffix GetSuffix(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSuffix dafnyValue) {
    GetSuffix.Builder nativeBuilder = GetSuffix.builder();
    nativeBuilder.length((dafnyValue.dtor_length()));
    return nativeBuilder.build();
  }

  public static TransactWriteItemsOutputTransformInput TransactWriteItemsOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactWriteItemsOutputTransformInput dafnyValue) {
    TransactWriteItemsOutputTransformInput.Builder nativeBuilder = TransactWriteItemsOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactWriteItemsOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactWriteItemsInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static CreateTableInputTransformInput CreateTableInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateTableInputTransformInput dafnyValue) {
    CreateTableInputTransformInput.Builder nativeBuilder = CreateTableInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.CreateTableInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static DynamoDbTableEncryptionConfig DynamoDbTableEncryptionConfig(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig dafnyValue) {
    DynamoDbTableEncryptionConfig.Builder nativeBuilder = DynamoDbTableEncryptionConfig.builder();
    nativeBuilder.partitionKeyName(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_partitionKeyName()));
    if (dafnyValue.dtor_sortKeyName().is_Some()) {
      nativeBuilder.sortKeyName(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_sortKeyName().dtor_value()));
    }
    if (dafnyValue.dtor_search().is_Some()) {
      nativeBuilder.search(ToNative.SearchConfig(dafnyValue.dtor_search().dtor_value()));
    }
    nativeBuilder.attributeActions(software.amazon.cryptography.dynamoDbItemEncryptor.ToNative.AttributeActions(dafnyValue.dtor_attributeActions()));
    if (dafnyValue.dtor_allowedUnauthenticatedAttributes().is_Some()) {
      nativeBuilder.allowedUnauthenticatedAttributes(Dafny.Com.Amazonaws.Dynamodb.ToNative.AttributeNameList(dafnyValue.dtor_allowedUnauthenticatedAttributes().dtor_value()));
    }
    if (dafnyValue.dtor_allowedUnauthenticatedAttributePrefix().is_Some()) {
      nativeBuilder.allowedUnauthenticatedAttributePrefix(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_allowedUnauthenticatedAttributePrefix().dtor_value()));
    }
    if (dafnyValue.dtor_algorithmSuiteId().is_Some()) {
      nativeBuilder.algorithmSuiteId(software.amazon.cryptography.materialProviders.ToNative.DBEAlgorithmSuiteId(dafnyValue.dtor_algorithmSuiteId().dtor_value()));
    }
    if (dafnyValue.dtor_keyring().is_Some()) {
      nativeBuilder.keyring(software.amazon.cryptography.materialProviders.ToNative.Keyring(dafnyValue.dtor_keyring().dtor_value()));
    }
    if (dafnyValue.dtor_cmm().is_Some()) {
      nativeBuilder.cmm(software.amazon.cryptography.materialProviders.ToNative.CryptographicMaterialsManager(dafnyValue.dtor_cmm().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static CreateTableOutputTransformOutput CreateTableOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateTableOutputTransformOutput dafnyValue) {
    CreateTableOutputTransformOutput.Builder nativeBuilder = CreateTableOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.CreateTableOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static GetItemOutputTransformOutput GetItemOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetItemOutputTransformOutput dafnyValue) {
    GetItemOutputTransformOutput.Builder nativeBuilder = GetItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.GetItemOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static PutItemInputTransformInput PutItemInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PutItemInputTransformInput dafnyValue) {
    PutItemInputTransformInput.Builder nativeBuilder = PutItemInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.PutItemInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static NonSensitivePart NonSensitivePart(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.NonSensitivePart dafnyValue) {
    NonSensitivePart.Builder nativeBuilder = NonSensitivePart.builder();
    nativeBuilder.name(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_name()));
    nativeBuilder.prefix(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_prefix()));
    if (dafnyValue.dtor_loc().is_Some()) {
      nativeBuilder.loc(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_loc().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static TransactGetItemsInputTransformOutput TransactGetItemsInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactGetItemsInputTransformOutput dafnyValue) {
    TransactGetItemsInputTransformOutput.Builder nativeBuilder = TransactGetItemsInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactGetItemsInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static QueryInputTransformOutput QueryInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.QueryInputTransformOutput dafnyValue) {
    QueryInputTransformOutput.Builder nativeBuilder = QueryInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.QueryInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static GetItemInputTransformOutput GetItemInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetItemInputTransformOutput dafnyValue) {
    GetItemInputTransformOutput.Builder nativeBuilder = GetItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.GetItemInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static ExecuteTransactionInputTransformOutput ExecuteTransactionInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteTransactionInputTransformOutput dafnyValue) {
    ExecuteTransactionInputTransformOutput.Builder nativeBuilder = ExecuteTransactionInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteTransactionInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static ExecuteStatementInputTransformInput ExecuteStatementInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteStatementInputTransformInput dafnyValue) {
    ExecuteStatementInputTransformInput.Builder nativeBuilder = ExecuteStatementInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteStatementInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static BatchExecuteStatementInputTransformInput BatchExecuteStatementInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchExecuteStatementInputTransformInput dafnyValue) {
    BatchExecuteStatementInputTransformInput.Builder nativeBuilder = BatchExecuteStatementInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchExecuteStatementInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static TransactGetItemsOutputTransformOutput TransactGetItemsOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactGetItemsOutputTransformOutput dafnyValue) {
    TransactGetItemsOutputTransformOutput.Builder nativeBuilder = TransactGetItemsOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactGetItemsOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static SearchConfig SearchConfig(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SearchConfig dafnyValue) {
    SearchConfig.Builder nativeBuilder = SearchConfig.builder();
    nativeBuilder.versions(ToNative.BeaconVersionList(dafnyValue.dtor_versions()));
    nativeBuilder.writeVersion((dafnyValue.dtor_writeVersion()));
    return nativeBuilder.build();
  }

  public static Lower Lower(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Lower dafnyValue) {
    Lower.Builder nativeBuilder = Lower.builder();
    return nativeBuilder.build();
  }

  public static VirtualField VirtualField(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualField dafnyValue) {
    VirtualField.Builder nativeBuilder = VirtualField.builder();
    nativeBuilder.name(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_name()));
    nativeBuilder.parts(ToNative.VirtualPartList(dafnyValue.dtor_parts()));
    return nativeBuilder.build();
  }

  public static GetSegment GetSegment(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSegment dafnyValue) {
    GetSegment.Builder nativeBuilder = GetSegment.builder();
    nativeBuilder.split(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_split()));
    nativeBuilder.low((dafnyValue.dtor_low()));
    if (dafnyValue.dtor_high().is_Some()) {
      nativeBuilder.high((dafnyValue.dtor_high().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static PutItemInputTransformOutput PutItemInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PutItemInputTransformOutput dafnyValue) {
    PutItemInputTransformOutput.Builder nativeBuilder = PutItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.PutItemInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static ScanOutputTransformInput ScanOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ScanOutputTransformInput dafnyValue) {
    ScanOutputTransformInput.Builder nativeBuilder = ScanOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ScanOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ScanInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static DeleteItemInputTransformInput DeleteItemInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DeleteItemInputTransformInput dafnyValue) {
    DeleteItemInputTransformInput.Builder nativeBuilder = DeleteItemInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DeleteItemInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static QueryOutputTransformInput QueryOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.QueryOutputTransformInput dafnyValue) {
    QueryOutputTransformInput.Builder nativeBuilder = QueryOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.QueryOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.QueryInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static GetItemInputTransformInput GetItemInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetItemInputTransformInput dafnyValue) {
    GetItemInputTransformInput.Builder nativeBuilder = GetItemInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.GetItemInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static DescribeTableInputTransformInput DescribeTableInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DescribeTableInputTransformInput dafnyValue) {
    DescribeTableInputTransformInput.Builder nativeBuilder = DescribeTableInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DescribeTableInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static ScanInputTransformInput ScanInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ScanInputTransformInput dafnyValue) {
    ScanInputTransformInput.Builder nativeBuilder = ScanInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ScanInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static UpdateTableOutputTransformOutput UpdateTableOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.UpdateTableOutputTransformOutput dafnyValue) {
    UpdateTableOutputTransformOutput.Builder nativeBuilder = UpdateTableOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateTableOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static DescribeTableOutputTransformOutput DescribeTableOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DescribeTableOutputTransformOutput dafnyValue) {
    DescribeTableOutputTransformOutput.Builder nativeBuilder = DescribeTableOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DescribeTableOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static DeleteItemOutputTransformOutput DeleteItemOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DeleteItemOutputTransformOutput dafnyValue) {
    DeleteItemOutputTransformOutput.Builder nativeBuilder = DeleteItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DeleteItemOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static GetItemOutputTransformInput GetItemOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetItemOutputTransformInput dafnyValue) {
    GetItemOutputTransformInput.Builder nativeBuilder = GetItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.GetItemOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.GetItemInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static GetPrefix GetPrefix(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetPrefix dafnyValue) {
    GetPrefix.Builder nativeBuilder = GetPrefix.builder();
    nativeBuilder.length((dafnyValue.dtor_length()));
    return nativeBuilder.build();
  }

  public static TransactWriteItemsInputTransformOutput TransactWriteItemsInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactWriteItemsInputTransformOutput dafnyValue) {
    TransactWriteItemsInputTransformOutput.Builder nativeBuilder = TransactWriteItemsInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactWriteItemsInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static BatchGetItemOutputTransformInput BatchGetItemOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchGetItemOutputTransformInput dafnyValue) {
    BatchGetItemOutputTransformInput.Builder nativeBuilder = BatchGetItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchGetItemOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchGetItemInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static BeaconVersion BeaconVersion(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BeaconVersion dafnyValue) {
    BeaconVersion.Builder nativeBuilder = BeaconVersion.builder();
    nativeBuilder.version((dafnyValue.dtor_version()));
    nativeBuilder.keyring(software.amazon.cryptography.materialProviders.ToNative.Keyring(dafnyValue.dtor_keyring()));
    if (dafnyValue.dtor_standardBeacons().is_Some()) {
      nativeBuilder.standardBeacons(ToNative.StandardBeaconList(dafnyValue.dtor_standardBeacons().dtor_value()));
    }
    if (dafnyValue.dtor_compoundBeacons().is_Some()) {
      nativeBuilder.compoundBeacons(ToNative.CompoundBeaconList(dafnyValue.dtor_compoundBeacons().dtor_value()));
    }
    if (dafnyValue.dtor_virtualFields().is_Some()) {
      nativeBuilder.virtualFields(ToNative.VirtualFieldList(dafnyValue.dtor_virtualFields().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static BatchGetItemInputTransformOutput BatchGetItemInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchGetItemInputTransformOutput dafnyValue) {
    BatchGetItemInputTransformOutput.Builder nativeBuilder = BatchGetItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchGetItemInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static Insert Insert(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Insert dafnyValue) {
    Insert.Builder nativeBuilder = Insert.builder();
    nativeBuilder.literal(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_literal()));
    return nativeBuilder.build();
  }

  public static BatchExecuteStatementOutputTransformInput BatchExecuteStatementOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchExecuteStatementOutputTransformInput dafnyValue) {
    BatchExecuteStatementOutputTransformInput.Builder nativeBuilder = BatchExecuteStatementOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchExecuteStatementOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchExecuteStatementInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static DeleteItemOutputTransformInput DeleteItemOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DeleteItemOutputTransformInput dafnyValue) {
    DeleteItemOutputTransformInput.Builder nativeBuilder = DeleteItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DeleteItemOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DeleteItemInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static DynamoDbEncryptionConfig DynamoDbEncryptionConfig(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbEncryptionConfig dafnyValue) {
    DynamoDbEncryptionConfig.Builder nativeBuilder = DynamoDbEncryptionConfig.builder();
    nativeBuilder.tableEncryptionConfigs(ToNative.DynamoDbTableEncryptionConfigs(dafnyValue.dtor_tableEncryptionConfigs()));
    return nativeBuilder.build();
  }

  public static BatchExecuteStatementInputTransformOutput BatchExecuteStatementInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchExecuteStatementInputTransformOutput dafnyValue) {
    BatchExecuteStatementInputTransformOutput.Builder nativeBuilder = BatchExecuteStatementInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchExecuteStatementInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static UpdateItemOutputTransformOutput UpdateItemOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.UpdateItemOutputTransformOutput dafnyValue) {
    UpdateItemOutputTransformOutput.Builder nativeBuilder = UpdateItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateItemOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static DeleteItemInputTransformOutput DeleteItemInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DeleteItemInputTransformOutput dafnyValue) {
    DeleteItemInputTransformOutput.Builder nativeBuilder = DeleteItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DeleteItemInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static UpdateTableOutputTransformInput UpdateTableOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.UpdateTableOutputTransformInput dafnyValue) {
    UpdateTableOutputTransformInput.Builder nativeBuilder = UpdateTableOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateTableOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateTableInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static ExecuteStatementOutputTransformOutput ExecuteStatementOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteStatementOutputTransformOutput dafnyValue) {
    ExecuteStatementOutputTransformOutput.Builder nativeBuilder = ExecuteStatementOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteStatementOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static UpdateItemInputTransformOutput UpdateItemInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.UpdateItemInputTransformOutput dafnyValue) {
    UpdateItemInputTransformOutput.Builder nativeBuilder = UpdateItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateItemInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static StandardBeacon StandardBeacon(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.StandardBeacon dafnyValue) {
    StandardBeacon.Builder nativeBuilder = StandardBeacon.builder();
    nativeBuilder.name(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_name()));
    nativeBuilder.length((dafnyValue.dtor_length()));
    if (dafnyValue.dtor_loc().is_Some()) {
      nativeBuilder.loc(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_loc().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static ExecuteTransactionOutputTransformOutput ExecuteTransactionOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteTransactionOutputTransformOutput dafnyValue) {
    ExecuteTransactionOutputTransformOutput.Builder nativeBuilder = ExecuteTransactionOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteTransactionOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static SensitivePart SensitivePart(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SensitivePart dafnyValue) {
    SensitivePart.Builder nativeBuilder = SensitivePart.builder();
    nativeBuilder.name(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_name()));
    nativeBuilder.prefix(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_prefix()));
    nativeBuilder.length((dafnyValue.dtor_length()));
    if (dafnyValue.dtor_loc().is_Some()) {
      nativeBuilder.loc(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_loc().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static Constructor Constructor(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Constructor dafnyValue) {
    Constructor.Builder nativeBuilder = Constructor.builder();
    nativeBuilder.parts(ToNative.ConstructorPartList(dafnyValue.dtor_parts()));
    return nativeBuilder.build();
  }

  public static ConstructorPart ConstructorPart(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ConstructorPart dafnyValue) {
    ConstructorPart.Builder nativeBuilder = ConstructorPart.builder();
    nativeBuilder.name(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_name()));
    nativeBuilder.required((dafnyValue.dtor_required()));
    return nativeBuilder.build();
  }

  public static UpdateTableInputTransformInput UpdateTableInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.UpdateTableInputTransformInput dafnyValue) {
    UpdateTableInputTransformInput.Builder nativeBuilder = UpdateTableInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateTableInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static TransactGetItemsInputTransformInput TransactGetItemsInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactGetItemsInputTransformInput dafnyValue) {
    TransactGetItemsInputTransformInput.Builder nativeBuilder = TransactGetItemsInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactGetItemsInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static PutItemOutputTransformOutput PutItemOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PutItemOutputTransformOutput dafnyValue) {
    PutItemOutputTransformOutput.Builder nativeBuilder = PutItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.PutItemOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static QueryOutputTransformOutput QueryOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.QueryOutputTransformOutput dafnyValue) {
    QueryOutputTransformOutput.Builder nativeBuilder = QueryOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.QueryOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static UpdateItemInputTransformInput UpdateItemInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.UpdateItemInputTransformInput dafnyValue) {
    UpdateItemInputTransformInput.Builder nativeBuilder = UpdateItemInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateItemInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static CompoundBeacon CompoundBeacon(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CompoundBeacon dafnyValue) {
    CompoundBeacon.Builder nativeBuilder = CompoundBeacon.builder();
    nativeBuilder.name(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_name()));
    nativeBuilder.split(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_split()));
    nativeBuilder.sensitive(ToNative.SensitivePartsList(dafnyValue.dtor_sensitive()));
    if (dafnyValue.dtor_nonSensitive().is_Some()) {
      nativeBuilder.nonSensitive(ToNative.NonSensitivePartsList(dafnyValue.dtor_nonSensitive().dtor_value()));
    }
    if (dafnyValue.dtor_constructors().is_Some()) {
      nativeBuilder.constructors(ToNative.ConstructorList(dafnyValue.dtor_constructors().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static BatchWriteItemOutputTransformOutput BatchWriteItemOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchWriteItemOutputTransformOutput dafnyValue) {
    BatchWriteItemOutputTransformOutput.Builder nativeBuilder = BatchWriteItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchWriteItemOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static ScanOutputTransformOutput ScanOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ScanOutputTransformOutput dafnyValue) {
    ScanOutputTransformOutput.Builder nativeBuilder = ScanOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ScanOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static TransactWriteItemsInputTransformInput TransactWriteItemsInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactWriteItemsInputTransformInput dafnyValue) {
    TransactWriteItemsInputTransformInput.Builder nativeBuilder = TransactWriteItemsInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactWriteItemsInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static BatchGetItemInputTransformInput BatchGetItemInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchGetItemInputTransformInput dafnyValue) {
    BatchGetItemInputTransformInput.Builder nativeBuilder = BatchGetItemInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchGetItemInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static UpdateItemOutputTransformInput UpdateItemOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.UpdateItemOutputTransformInput dafnyValue) {
    UpdateItemOutputTransformInput.Builder nativeBuilder = UpdateItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateItemOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateItemInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static UpdateTableInputTransformOutput UpdateTableInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.UpdateTableInputTransformOutput dafnyValue) {
    UpdateTableInputTransformOutput.Builder nativeBuilder = UpdateTableInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.UpdateTableInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static GetSubstring GetSubstring(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSubstring dafnyValue) {
    GetSubstring.Builder nativeBuilder = GetSubstring.builder();
    nativeBuilder.low((dafnyValue.dtor_low()));
    nativeBuilder.high((dafnyValue.dtor_high()));
    return nativeBuilder.build();
  }

  public static Upper Upper(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Upper dafnyValue) {
    Upper.Builder nativeBuilder = Upper.builder();
    return nativeBuilder.build();
  }

  public static QueryInputTransformInput QueryInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.QueryInputTransformInput dafnyValue) {
    QueryInputTransformInput.Builder nativeBuilder = QueryInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.QueryInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static PutItemOutputTransformInput PutItemOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PutItemOutputTransformInput dafnyValue) {
    PutItemOutputTransformInput.Builder nativeBuilder = PutItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.PutItemOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.PutItemInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static TransactGetItemsOutputTransformInput TransactGetItemsOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactGetItemsOutputTransformInput dafnyValue) {
    TransactGetItemsOutputTransformInput.Builder nativeBuilder = TransactGetItemsOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactGetItemsOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactGetItemsInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static BatchWriteItemOutputTransformInput BatchWriteItemOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchWriteItemOutputTransformInput dafnyValue) {
    BatchWriteItemOutputTransformInput.Builder nativeBuilder = BatchWriteItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchWriteItemOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchWriteItemInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static ScanInputTransformOutput ScanInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ScanInputTransformOutput dafnyValue) {
    ScanInputTransformOutput.Builder nativeBuilder = ScanInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ScanInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static CreateTableOutputTransformInput CreateTableOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateTableOutputTransformInput dafnyValue) {
    CreateTableOutputTransformInput.Builder nativeBuilder = CreateTableOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.CreateTableOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.CreateTableInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static ExecuteTransactionOutputTransformInput ExecuteTransactionOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteTransactionOutputTransformInput dafnyValue) {
    ExecuteTransactionOutputTransformInput.Builder nativeBuilder = ExecuteTransactionOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteTransactionOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteTransactionInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static DescribeTableOutputTransformInput DescribeTableOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DescribeTableOutputTransformInput dafnyValue) {
    DescribeTableOutputTransformInput.Builder nativeBuilder = DescribeTableOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DescribeTableOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DescribeTableInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static BatchWriteItemInputTransformInput BatchWriteItemInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchWriteItemInputTransformInput dafnyValue) {
    BatchWriteItemInputTransformInput.Builder nativeBuilder = BatchWriteItemInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchWriteItemInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static DescribeTableInputTransformOutput DescribeTableInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DescribeTableInputTransformOutput dafnyValue) {
    DescribeTableInputTransformOutput.Builder nativeBuilder = DescribeTableInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.DescribeTableInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static ExecuteStatementInputTransformOutput ExecuteStatementInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteStatementInputTransformOutput dafnyValue) {
    ExecuteStatementInputTransformOutput.Builder nativeBuilder = ExecuteStatementInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteStatementInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static BatchGetItemOutputTransformOutput BatchGetItemOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchGetItemOutputTransformOutput dafnyValue) {
    BatchGetItemOutputTransformOutput.Builder nativeBuilder = BatchGetItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchGetItemOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static VirtualPart VirtualPart(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualPart dafnyValue) {
    VirtualPart.Builder nativeBuilder = VirtualPart.builder();
    nativeBuilder.loc(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_loc()));
    if (dafnyValue.dtor_trans().is_Some()) {
      nativeBuilder.trans(ToNative.VirtualTransformList(dafnyValue.dtor_trans().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static CreateTableInputTransformOutput CreateTableInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateTableInputTransformOutput dafnyValue) {
    CreateTableInputTransformOutput.Builder nativeBuilder = CreateTableInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.CreateTableInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static BatchWriteItemInputTransformOutput BatchWriteItemInputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchWriteItemInputTransformOutput dafnyValue) {
    BatchWriteItemInputTransformOutput.Builder nativeBuilder = BatchWriteItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchWriteItemInput(dafnyValue.dtor_transformedInput()));
    return nativeBuilder.build();
  }

  public static BatchExecuteStatementOutputTransformOutput BatchExecuteStatementOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BatchExecuteStatementOutputTransformOutput dafnyValue) {
    BatchExecuteStatementOutputTransformOutput.Builder nativeBuilder = BatchExecuteStatementOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.BatchExecuteStatementOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static ExecuteTransactionInputTransformInput ExecuteTransactionInputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteTransactionInputTransformInput dafnyValue) {
    ExecuteTransactionInputTransformInput.Builder nativeBuilder = ExecuteTransactionInputTransformInput.builder();
    nativeBuilder.sdkInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteTransactionInput(dafnyValue.dtor_sdkInput()));
    return nativeBuilder.build();
  }

  public static ExecuteStatementOutputTransformInput ExecuteStatementOutputTransformInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ExecuteStatementOutputTransformInput dafnyValue) {
    ExecuteStatementOutputTransformInput.Builder nativeBuilder = ExecuteStatementOutputTransformInput.builder();
    nativeBuilder.sdkOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteStatementOutput(dafnyValue.dtor_sdkOutput()));
    nativeBuilder.originalInput(Dafny.Com.Amazonaws.Dynamodb.ToNative.ExecuteStatementInput(dafnyValue.dtor_originalInput()));
    return nativeBuilder.build();
  }

  public static TransactWriteItemsOutputTransformOutput TransactWriteItemsOutputTransformOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.TransactWriteItemsOutputTransformOutput dafnyValue) {
    TransactWriteItemsOutputTransformOutput.Builder nativeBuilder = TransactWriteItemsOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(Dafny.Com.Amazonaws.Dynamodb.ToNative.TransactWriteItemsOutput(dafnyValue.dtor_transformedOutput()));
    return nativeBuilder.build();
  }

  public static VirtualTransform VirtualTransform(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform dafnyValue) {
    VirtualTransform.Builder nativeBuilder = VirtualTransform.builder();
    if (dafnyValue.is_upper()) {
      nativeBuilder.upper(ToNative.Upper(dafnyValue.dtor_upper()));
    }
    if (dafnyValue.is_lower()) {
      nativeBuilder.lower(ToNative.Lower(dafnyValue.dtor_lower()));
    }
    if (dafnyValue.is_insert()) {
      nativeBuilder.insert(ToNative.Insert(dafnyValue.dtor_insert()));
    }
    if (dafnyValue.is_prefix()) {
      nativeBuilder.prefix(ToNative.GetPrefix(dafnyValue.dtor_prefix()));
    }
    if (dafnyValue.is_suffix()) {
      nativeBuilder.suffix(ToNative.GetSuffix(dafnyValue.dtor_suffix()));
    }
    if (dafnyValue.is_substring()) {
      nativeBuilder.substring(ToNative.GetSubstring(dafnyValue.dtor_substring()));
    }
    if (dafnyValue.is_segment()) {
      nativeBuilder.segment(ToNative.GetSegment(dafnyValue.dtor_segment()));
    }
    return nativeBuilder.build();
  }

  public static List<VirtualField> VirtualFieldList(
      DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualField> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToNative::VirtualField);
  }

  public static List<StandardBeacon> StandardBeaconList(
      DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.StandardBeacon> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToNative::StandardBeacon);
  }

  public static List<VirtualPart> VirtualPartList(
      DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualPart> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToNative::VirtualPart);
  }

  public static List<VirtualTransform> VirtualTransformList(
      DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToNative::VirtualTransform);
  }

  public static List<NonSensitivePart> NonSensitivePartsList(
      DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.NonSensitivePart> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToNative::NonSensitivePart);
  }

  public static List<SensitivePart> SensitivePartsList(
      DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SensitivePart> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToNative::SensitivePart);
  }

  public static List<CompoundBeacon> CompoundBeaconList(
      DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CompoundBeacon> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToNative::CompoundBeacon);
  }

  public static List<Constructor> ConstructorList(
      DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Constructor> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToNative::Constructor);
  }

  public static List<BeaconVersion> BeaconVersionList(
      DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BeaconVersion> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToNative::BeaconVersion);
  }

  public static List<ConstructorPart> ConstructorPartList(
      DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ConstructorPart> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToNative::ConstructorPart);
  }

  public static Map<String, DynamoDbTableEncryptionConfig> DynamoDbTableEncryptionConfigs(
      DafnyMap<? extends DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToMap(
        dafnyValue, 
        software.amazon.dafny.conversion.ToNative.Simple::String, 
        software.amazon.cryptography.dynamoDbEncryption.ToNative::DynamoDbTableEncryptionConfig);
  }
}
