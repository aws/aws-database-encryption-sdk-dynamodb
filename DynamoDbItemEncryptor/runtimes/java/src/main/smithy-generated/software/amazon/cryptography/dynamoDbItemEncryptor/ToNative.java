// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbItemEncryptor;

import Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.Error;
import Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.Error_CollectionOfErrors;
import Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.Error_DynamoDbItemEncryptorException;
import Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.Error_Opaque;
import dafny.DafnyMap;
import dafny.DafnySequence;
import java.lang.Character;
import java.lang.String;
import java.util.Map;
import software.amazon.cryptography.dynamoDbItemEncryptor.model.CollectionOfErrors;
import software.amazon.cryptography.dynamoDbItemEncryptor.model.DecryptItemInput;
import software.amazon.cryptography.dynamoDbItemEncryptor.model.DecryptItemOutput;
import software.amazon.cryptography.dynamoDbItemEncryptor.model.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dynamoDbItemEncryptor.model.DynamoDbItemEncryptorException;
import software.amazon.cryptography.dynamoDbItemEncryptor.model.EncryptItemInput;
import software.amazon.cryptography.dynamoDbItemEncryptor.model.EncryptItemOutput;
import software.amazon.cryptography.dynamoDbItemEncryptor.model.NativeError;
import software.amazon.cryptography.dynamoDbItemEncryptor.model.OpaqueError;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;

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

  public static DecryptItemOutput DecryptItemOutput(
      Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.DecryptItemOutput dafnyValue) {
    DecryptItemOutput.Builder nativeBuilder = DecryptItemOutput.builder();
    nativeBuilder.plaintextItem(Dafny.Com.Amazonaws.Dynamodb.ToNative.AttributeMap(dafnyValue.dtor_plaintextItem()));
    return nativeBuilder.build();
  }

  public static DecryptItemInput DecryptItemInput(
      Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.DecryptItemInput dafnyValue) {
    DecryptItemInput.Builder nativeBuilder = DecryptItemInput.builder();
    nativeBuilder.encryptedItem(Dafny.Com.Amazonaws.Dynamodb.ToNative.AttributeMap(dafnyValue.dtor_encryptedItem()));
    return nativeBuilder.build();
  }

  public static EncryptItemOutput EncryptItemOutput(
      Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.EncryptItemOutput dafnyValue) {
    EncryptItemOutput.Builder nativeBuilder = EncryptItemOutput.builder();
    nativeBuilder.encryptedItem(Dafny.Com.Amazonaws.Dynamodb.ToNative.AttributeMap(dafnyValue.dtor_encryptedItem()));
    return nativeBuilder.build();
  }

  public static DynamoDbItemEncryptorConfig DynamoDbItemEncryptorConfig(
      Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.DynamoDbItemEncryptorConfig dafnyValue) {
    DynamoDbItemEncryptorConfig.Builder nativeBuilder = DynamoDbItemEncryptorConfig.builder();
    nativeBuilder.tableName(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_tableName()));
    nativeBuilder.partitionKeyName(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_partitionKeyName()));
    if (dafnyValue.dtor_sortKeyName().is_Some()) {
      nativeBuilder.sortKeyName(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_sortKeyName().dtor_value()));
    }
    nativeBuilder.attributeActions(ToNative.AttributeActions(dafnyValue.dtor_attributeActions()));
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
      nativeBuilder.keyring((dafnyValue.dtor_keyring().dtor_value()));
    }
    if (dafnyValue.dtor_cmm().is_Some()) {
      nativeBuilder.cmm((dafnyValue.dtor_cmm().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static EncryptItemInput EncryptItemInput(
      Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.EncryptItemInput dafnyValue) {
    EncryptItemInput.Builder nativeBuilder = EncryptItemInput.builder();
    nativeBuilder.plaintextItem(Dafny.Com.Amazonaws.Dynamodb.ToNative.AttributeMap(dafnyValue.dtor_plaintextItem()));
    return nativeBuilder.build();
  }

  public static Map<String, CryptoAction> AttributeActions(
      DafnyMap<? extends DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToMap(
        dafnyValue, 
        software.amazon.dafny.conversion.ToNative.Simple::String, 
        software.amazon.cryptography.structuredEncryption.ToNative::CryptoAction);
  }
}
