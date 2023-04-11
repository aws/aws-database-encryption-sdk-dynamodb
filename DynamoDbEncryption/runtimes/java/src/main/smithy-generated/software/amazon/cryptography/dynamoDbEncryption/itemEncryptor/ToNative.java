// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.itemEncryptor;

import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error_CollectionOfErrors;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error_DynamoDbItemEncryptorException;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error_Opaque;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.CollectionOfErrors;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.DecryptItemInput;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.DecryptItemOutput;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.DynamoDbItemEncryptorException;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.EncryptItemInput;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.EncryptItemOutput;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.NativeError;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.OpaqueError;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.ParsedHeader;

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

  public static DynamoDbItemEncryptorException Error(
      Error_DynamoDbItemEncryptorException dafnyValue) {
    DynamoDbItemEncryptorException.Builder nativeBuilder = DynamoDbItemEncryptorException.builder();
    nativeBuilder.message(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_message()));
    return nativeBuilder.build();
  }

  public static NativeError Error(Error dafnyValue) {
    if (dafnyValue.is_DynamoDbItemEncryptorException()) {
      return ToNative.Error((Error_DynamoDbItemEncryptorException) dafnyValue);
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

  public static ParsedHeader ParsedHeader(
      Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.ParsedHeader dafnyValue) {
    ParsedHeader.Builder nativeBuilder = ParsedHeader.builder();
    nativeBuilder.attributeActions(software.amazon.cryptography.dynamoDbEncryption.ToNative.AttributeActions(dafnyValue.dtor_attributeActions()));
    nativeBuilder.algorithmSuiteId(software.amazon.cryptography.materialProviders.ToNative.DBEAlgorithmSuiteId(dafnyValue.dtor_algorithmSuiteId()));
    nativeBuilder.encryptedDataKeys(software.amazon.cryptography.materialProviders.ToNative.EncryptedDataKeyList(dafnyValue.dtor_encryptedDataKeys()));
    nativeBuilder.storedEncryptionContext(software.amazon.cryptography.materialProviders.ToNative.EncryptionContext(dafnyValue.dtor_storedEncryptionContext()));
    return nativeBuilder.build();
  }

  public static DecryptItemInput DecryptItemInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemInput dafnyValue) {
    DecryptItemInput.Builder nativeBuilder = DecryptItemInput.builder();
    nativeBuilder.encryptedItem(Dafny.Com.Amazonaws.Dynamodb.ToNative.AttributeMap(dafnyValue.dtor_encryptedItem()));
    return nativeBuilder.build();
  }

  public static DecryptItemOutput DecryptItemOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput dafnyValue) {
    DecryptItemOutput.Builder nativeBuilder = DecryptItemOutput.builder();
    nativeBuilder.plaintextItem(Dafny.Com.Amazonaws.Dynamodb.ToNative.AttributeMap(dafnyValue.dtor_plaintextItem()));
    if (dafnyValue.dtor_parsedHeader().is_Some()) {
      nativeBuilder.parsedHeader(ToNative.ParsedHeader(dafnyValue.dtor_parsedHeader().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static EncryptItemOutput EncryptItemOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput dafnyValue) {
    EncryptItemOutput.Builder nativeBuilder = EncryptItemOutput.builder();
    nativeBuilder.encryptedItem(Dafny.Com.Amazonaws.Dynamodb.ToNative.AttributeMap(dafnyValue.dtor_encryptedItem()));
    return nativeBuilder.build();
  }

  public static EncryptItemInput EncryptItemInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemInput dafnyValue) {
    EncryptItemInput.Builder nativeBuilder = EncryptItemInput.builder();
    nativeBuilder.plaintextItem(Dafny.Com.Amazonaws.Dynamodb.ToNative.AttributeMap(dafnyValue.dtor_plaintextItem()));
    return nativeBuilder.build();
  }

  public static DynamoDbItemEncryptorConfig DynamoDbItemEncryptorConfig(
      Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DynamoDbItemEncryptorConfig dafnyValue) {
    DynamoDbItemEncryptorConfig.Builder nativeBuilder = DynamoDbItemEncryptorConfig.builder();
    nativeBuilder.tableName(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_tableName()));
    nativeBuilder.partitionKeyName(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_partitionKeyName()));
    if (dafnyValue.dtor_sortKeyName().is_Some()) {
      nativeBuilder.sortKeyName(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_sortKeyName().dtor_value()));
    }
    nativeBuilder.attributeActions(software.amazon.cryptography.dynamoDbEncryption.ToNative.AttributeActions(dafnyValue.dtor_attributeActions()));
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
    if (dafnyValue.dtor_legacyConfig().is_Some()) {
      nativeBuilder.legacyConfig(software.amazon.cryptography.dynamoDbEncryption.ToNative.LegacyConfig(dafnyValue.dtor_legacyConfig().dtor_value()));
    }
    if (dafnyValue.dtor_plaintextPolicy().is_Some()) {
      nativeBuilder.plaintextPolicy(software.amazon.cryptography.dynamoDbEncryption.ToNative.PlaintextPolicy(dafnyValue.dtor_plaintextPolicy().dtor_value()));
    }
    return nativeBuilder.build();
  }
}
