// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.structuredEncryption;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.Error;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.Error_CollectionOfErrors;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.Error_Opaque;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.Error_StructuredEncryptionException;
import dafny.DafnyMap;
import dafny.DafnySequence;
import java.lang.Character;
import java.lang.IllegalArgumentException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import software.amazon.cryptography.structuredEncryption.model.AuthenticateAction;
import software.amazon.cryptography.structuredEncryption.model.AuthenticateSchema;
import software.amazon.cryptography.structuredEncryption.model.AuthenticateSchemaContent;
import software.amazon.cryptography.structuredEncryption.model.CollectionOfErrors;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;
import software.amazon.cryptography.structuredEncryption.model.CryptoSchema;
import software.amazon.cryptography.structuredEncryption.model.CryptoSchemaContent;
import software.amazon.cryptography.structuredEncryption.model.DecryptStructureInput;
import software.amazon.cryptography.structuredEncryption.model.DecryptStructureOutput;
import software.amazon.cryptography.structuredEncryption.model.EncryptStructureInput;
import software.amazon.cryptography.structuredEncryption.model.EncryptStructureOutput;
import software.amazon.cryptography.structuredEncryption.model.NativeError;
import software.amazon.cryptography.structuredEncryption.model.OpaqueError;
import software.amazon.cryptography.structuredEncryption.model.ParsedHeader;
import software.amazon.cryptography.structuredEncryption.model.StructuredData;
import software.amazon.cryptography.structuredEncryption.model.StructuredDataContent;
import software.amazon.cryptography.structuredEncryption.model.StructuredDataTerminal;
import software.amazon.cryptography.structuredEncryption.model.StructuredEncryptionConfig;
import software.amazon.cryptography.structuredEncryption.model.StructuredEncryptionException;

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

  public static StructuredEncryptionException Error(
      Error_StructuredEncryptionException dafnyValue) {
    StructuredEncryptionException.Builder nativeBuilder = StructuredEncryptionException.builder();
    nativeBuilder.message(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_message()));
    return nativeBuilder.build();
  }

  public static NativeError Error(Error dafnyValue) {
    if (dafnyValue.is_StructuredEncryptionException()) {
      return ToNative.Error((Error_StructuredEncryptionException) dafnyValue);
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

  public static StructuredDataTerminal StructuredDataTerminal(
      Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataTerminal dafnyValue) {
    StructuredDataTerminal.Builder nativeBuilder = StructuredDataTerminal.builder();
    nativeBuilder.value(software.amazon.dafny.conversion.ToNative.Simple.ByteBuffer(dafnyValue.dtor_value()));
    nativeBuilder.typeId(software.amazon.dafny.conversion.ToNative.Simple.ByteBuffer(dafnyValue.dtor_typeId()));
    return nativeBuilder.build();
  }

  public static StructuredData StructuredData(
      Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData dafnyValue) {
    StructuredData.Builder nativeBuilder = StructuredData.builder();
    nativeBuilder.content(ToNative.StructuredDataContent(dafnyValue.dtor_content()));
    if (dafnyValue.dtor_attributes().is_Some()) {
      nativeBuilder.attributes(ToNative.StructuredDataAttributes(dafnyValue.dtor_attributes().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static DecryptStructureInput DecryptStructureInput(
      Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureInput dafnyValue) {
    DecryptStructureInput.Builder nativeBuilder = DecryptStructureInput.builder();
    nativeBuilder.tableName(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_tableName()));
    nativeBuilder.encryptedStructure(ToNative.StructuredData(dafnyValue.dtor_encryptedStructure()));
    nativeBuilder.authenticateSchema(ToNative.AuthenticateSchema(dafnyValue.dtor_authenticateSchema()));
    nativeBuilder.cmm(software.amazon.cryptography.materialProviders.ToNative.CryptographicMaterialsManager(dafnyValue.dtor_cmm()));
    if (dafnyValue.dtor_encryptionContext().is_Some()) {
      nativeBuilder.encryptionContext(software.amazon.cryptography.materialProviders.ToNative.EncryptionContext(dafnyValue.dtor_encryptionContext().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static EncryptStructureInput EncryptStructureInput(
      Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureInput dafnyValue) {
    EncryptStructureInput.Builder nativeBuilder = EncryptStructureInput.builder();
    nativeBuilder.tableName(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_tableName()));
    nativeBuilder.plaintextStructure(ToNative.StructuredData(dafnyValue.dtor_plaintextStructure()));
    nativeBuilder.cryptoSchema(ToNative.CryptoSchema(dafnyValue.dtor_cryptoSchema()));
    nativeBuilder.cmm(software.amazon.cryptography.materialProviders.ToNative.CryptographicMaterialsManager(dafnyValue.dtor_cmm()));
    if (dafnyValue.dtor_algorithmSuiteId().is_Some()) {
      nativeBuilder.algorithmSuiteId(software.amazon.cryptography.materialProviders.ToNative.DBEAlgorithmSuiteId(dafnyValue.dtor_algorithmSuiteId().dtor_value()));
    }
    if (dafnyValue.dtor_encryptionContext().is_Some()) {
      nativeBuilder.encryptionContext(software.amazon.cryptography.materialProviders.ToNative.EncryptionContext(dafnyValue.dtor_encryptionContext().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static DecryptStructureOutput DecryptStructureOutput(
      Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput dafnyValue) {
    DecryptStructureOutput.Builder nativeBuilder = DecryptStructureOutput.builder();
    nativeBuilder.plaintextStructure(ToNative.StructuredData(dafnyValue.dtor_plaintextStructure()));
    nativeBuilder.parsedHeader(ToNative.ParsedHeader(dafnyValue.dtor_parsedHeader()));
    return nativeBuilder.build();
  }

  public static CryptoSchema CryptoSchema(
      Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema dafnyValue) {
    CryptoSchema.Builder nativeBuilder = CryptoSchema.builder();
    nativeBuilder.content(ToNative.CryptoSchemaContent(dafnyValue.dtor_content()));
    if (dafnyValue.dtor_attributes().is_Some()) {
      nativeBuilder.attributes(ToNative.CryptoSchemaAttributes(dafnyValue.dtor_attributes().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static EncryptStructureOutput EncryptStructureOutput(
      Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput dafnyValue) {
    EncryptStructureOutput.Builder nativeBuilder = EncryptStructureOutput.builder();
    nativeBuilder.encryptedStructure(ToNative.StructuredData(dafnyValue.dtor_encryptedStructure()));
    return nativeBuilder.build();
  }

  public static StructuredEncryptionConfig StructuredEncryptionConfig(
      Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredEncryptionConfig dafnyValue) {
    StructuredEncryptionConfig.Builder nativeBuilder = StructuredEncryptionConfig.builder();
    return nativeBuilder.build();
  }

  public static ParsedHeader ParsedHeader(
      Dafny.Aws.Cryptography.StructuredEncryption.Types.ParsedHeader dafnyValue) {
    ParsedHeader.Builder nativeBuilder = ParsedHeader.builder();
    nativeBuilder.cryptoSchema(ToNative.CryptoSchema(dafnyValue.dtor_cryptoSchema()));
    nativeBuilder.algorithmSuiteId(software.amazon.cryptography.materialProviders.ToNative.DBEAlgorithmSuiteId(dafnyValue.dtor_algorithmSuiteId()));
    nativeBuilder.encryptedDataKeys(software.amazon.cryptography.materialProviders.ToNative.EncryptedDataKeyList(dafnyValue.dtor_encryptedDataKeys()));
    nativeBuilder.storedEncryptionContext(software.amazon.cryptography.materialProviders.ToNative.EncryptionContext(dafnyValue.dtor_storedEncryptionContext()));
    return nativeBuilder.build();
  }

  public static AuthenticateSchema AuthenticateSchema(
      Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema dafnyValue) {
    AuthenticateSchema.Builder nativeBuilder = AuthenticateSchema.builder();
    nativeBuilder.content(ToNative.AuthenticateSchemaContent(dafnyValue.dtor_content()));
    if (dafnyValue.dtor_attributes().is_Some()) {
      nativeBuilder.attributes(ToNative.AuthenticateSchemaAttributes(dafnyValue.dtor_attributes().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static CryptoAction CryptoAction(
      Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction dafnyValue) {
    if (dafnyValue.is_ENCRYPT__AND__SIGN()) {
      return CryptoAction.ENCRYPT_AND_SIGN;
    }
    if (dafnyValue.is_SIGN__ONLY()) {
      return CryptoAction.SIGN_ONLY;
    }
    if (dafnyValue.is_DO__NOTHING()) {
      return CryptoAction.DO_NOTHING;
    }
    throw new IllegalArgumentException("No entry of software.amazon.cryptography.structuredEncryption.model.CryptoAction matches the input : " + dafnyValue);
  }

  public static AuthenticateAction AuthenticateAction(
      Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction dafnyValue) {
    if (dafnyValue.is_SIGN()) {
      return AuthenticateAction.SIGN;
    }
    if (dafnyValue.is_DO__NOT__SIGN()) {
      return AuthenticateAction.DO_NOT_SIGN;
    }
    throw new IllegalArgumentException("No entry of software.amazon.cryptography.structuredEncryption.model.AuthenticateAction matches the input : " + dafnyValue);
  }

  public static StructuredDataContent StructuredDataContent(
      Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataContent dafnyValue) {
    StructuredDataContent.Builder nativeBuilder = StructuredDataContent.builder();
    if (dafnyValue.is_Terminal()) {
      nativeBuilder.Terminal(ToNative.StructuredDataTerminal(dafnyValue.dtor_Terminal()));
    }
    if (dafnyValue.is_DataList()) {
      nativeBuilder.DataList(ToNative.StructuredDataList(dafnyValue.dtor_DataList()));
    }
    if (dafnyValue.is_DataMap()) {
      nativeBuilder.DataMap(ToNative.StructuredDataMap(dafnyValue.dtor_DataMap()));
    }
    return nativeBuilder.build();
  }

  public static AuthenticateSchemaContent AuthenticateSchemaContent(
      Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchemaContent dafnyValue) {
    AuthenticateSchemaContent.Builder nativeBuilder = AuthenticateSchemaContent.builder();
    if (dafnyValue.is_Action()) {
      nativeBuilder.Action(ToNative.AuthenticateAction(dafnyValue.dtor_Action()));
    }
    if (dafnyValue.is_SchemaMap()) {
      nativeBuilder.SchemaMap(ToNative.AuthenticateSchemaMap(dafnyValue.dtor_SchemaMap()));
    }
    if (dafnyValue.is_SchemaList()) {
      nativeBuilder.SchemaList(ToNative.AuthenticateSchemaList(dafnyValue.dtor_SchemaList()));
    }
    return nativeBuilder.build();
  }

  public static CryptoSchemaContent CryptoSchemaContent(
      Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchemaContent dafnyValue) {
    CryptoSchemaContent.Builder nativeBuilder = CryptoSchemaContent.builder();
    if (dafnyValue.is_Action()) {
      nativeBuilder.Action(ToNative.CryptoAction(dafnyValue.dtor_Action()));
    }
    if (dafnyValue.is_SchemaMap()) {
      nativeBuilder.SchemaMap(ToNative.CryptoSchemaMap(dafnyValue.dtor_SchemaMap()));
    }
    if (dafnyValue.is_SchemaList()) {
      nativeBuilder.SchemaList(ToNative.CryptoSchemaList(dafnyValue.dtor_SchemaList()));
    }
    return nativeBuilder.build();
  }

  public static List<CryptoSchema> CryptoSchemaList(
      DafnySequence<? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.structuredEncryption.ToNative::CryptoSchema);
  }

  public static List<AuthenticateSchema> AuthenticateSchemaList(
      DafnySequence<? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.structuredEncryption.ToNative::AuthenticateSchema);
  }

  public static List<StructuredData> StructuredDataList(
      DafnySequence<? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.structuredEncryption.ToNative::StructuredData);
  }

  public static Map<String, CryptoSchema> CryptoSchemaMap(
      DafnyMap<? extends DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToMap(
        dafnyValue, 
        software.amazon.dafny.conversion.ToNative.Simple::String, 
        software.amazon.cryptography.structuredEncryption.ToNative::CryptoSchema);
  }

  public static Map<String, StructuredDataTerminal> StructuredDataAttributes(
      DafnyMap<? extends DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataTerminal> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToMap(
        dafnyValue, 
        software.amazon.dafny.conversion.ToNative.Simple::String, 
        software.amazon.cryptography.structuredEncryption.ToNative::StructuredDataTerminal);
  }

  public static Map<String, AuthenticateSchema> AuthenticateSchemaMap(
      DafnyMap<? extends DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToMap(
        dafnyValue, 
        software.amazon.dafny.conversion.ToNative.Simple::String, 
        software.amazon.cryptography.structuredEncryption.ToNative::AuthenticateSchema);
  }

  public static Map<String, AuthenticateAction> CryptoSchemaAttributes(
      DafnyMap<? extends DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToMap(
        dafnyValue, 
        software.amazon.dafny.conversion.ToNative.Simple::String, 
        software.amazon.cryptography.structuredEncryption.ToNative::AuthenticateAction);
  }

  public static Map<String, AuthenticateAction> AuthenticateSchemaAttributes(
      DafnyMap<? extends DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToMap(
        dafnyValue, 
        software.amazon.dafny.conversion.ToNative.Simple::String, 
        software.amazon.cryptography.structuredEncryption.ToNative::AuthenticateAction);
  }

  public static Map<String, StructuredData> StructuredDataMap(
      DafnyMap<? extends DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToMap(
        dafnyValue, 
        software.amazon.dafny.conversion.ToNative.Simple::String, 
        software.amazon.cryptography.structuredEncryption.ToNative::StructuredData);
  }
}
