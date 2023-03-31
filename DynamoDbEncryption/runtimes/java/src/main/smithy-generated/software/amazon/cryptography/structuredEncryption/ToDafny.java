// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.structuredEncryption;

import Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId;
import Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchemaContent;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchemaContent;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureInput;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureInput;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.Error;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.Error_StructuredEncryptionException;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataContent;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataTerminal;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredEncryptionConfig;
import Wrappers_Compile.Option;
import dafny.DafnyMap;
import dafny.DafnySequence;
import java.lang.Byte;
import java.lang.Character;
import java.lang.IllegalArgumentException;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.structuredEncryption.model.CollectionOfErrors;
import software.amazon.cryptography.structuredEncryption.model.NativeError;
import software.amazon.cryptography.structuredEncryption.model.OpaqueError;
import software.amazon.cryptography.structuredEncryption.model.StructuredEncryptionException;

public class ToDafny {
  public static Error Error(NativeError nativeValue) {
    if (nativeValue instanceof StructuredEncryptionException) {
      return ToDafny.Error((StructuredEncryptionException) nativeValue);
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

  public static StructuredDataTerminal StructuredDataTerminal(
      software.amazon.cryptography.structuredEncryption.model.StructuredDataTerminal nativeValue) {
    DafnySequence<? extends Byte> value;
    value = software.amazon.dafny.conversion.ToDafny.Simple.ByteSequence(nativeValue.value());
    DafnySequence<? extends Byte> typeId;
    typeId = software.amazon.dafny.conversion.ToDafny.Simple.ByteSequence(nativeValue.typeId());
    return new StructuredDataTerminal(value, typeId);
  }

  public static CryptoSchema CryptoSchema(
      software.amazon.cryptography.structuredEncryption.model.CryptoSchema nativeValue) {
    CryptoSchemaContent content;
    content = ToDafny.CryptoSchemaContent(nativeValue.content());
    Option<DafnyMap<? extends DafnySequence<? extends Character>, ? extends AuthenticateAction>> attributes;
    attributes = (Objects.nonNull(nativeValue.attributes()) && nativeValue.attributes().size() > 0) ?
        Option.create_Some(ToDafny.CryptoSchemaAttributes(nativeValue.attributes()))
        : Option.create_None();
    return new CryptoSchema(content, attributes);
  }

  public static DecryptStructureInput DecryptStructureInput(
      software.amazon.cryptography.structuredEncryption.model.DecryptStructureInput nativeValue) {
    DafnySequence<? extends Character> tableName;
    tableName = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.tableName());
    StructuredData encryptedStructure;
    encryptedStructure = ToDafny.StructuredData(nativeValue.encryptedStructure());
    AuthenticateSchema authenticateSchema;
    authenticateSchema = ToDafny.AuthenticateSchema(nativeValue.authenticateSchema());
    ICryptographicMaterialsManager cmm;
    cmm = software.amazon.cryptography.materialProviders.ToDafny.CryptographicMaterialsManager(nativeValue.cmm());
    Option<DafnyMap<? extends DafnySequence<? extends Byte>, ? extends DafnySequence<? extends Byte>>> encryptionContext;
    encryptionContext = (Objects.nonNull(nativeValue.encryptionContext()) && nativeValue.encryptionContext().size() > 0) ?
        Option.create_Some(software.amazon.cryptography.materialProviders.ToDafny.EncryptionContext(nativeValue.encryptionContext()))
        : Option.create_None();
    return new DecryptStructureInput(tableName, encryptedStructure, authenticateSchema, cmm, encryptionContext);
  }

  public static DecryptStructureOutput DecryptStructureOutput(
      software.amazon.cryptography.structuredEncryption.model.DecryptStructureOutput nativeValue) {
    StructuredData plaintextStructure;
    plaintextStructure = ToDafny.StructuredData(nativeValue.plaintextStructure());
    return new DecryptStructureOutput(plaintextStructure);
  }

  public static AuthenticateSchema AuthenticateSchema(
      software.amazon.cryptography.structuredEncryption.model.AuthenticateSchema nativeValue) {
    AuthenticateSchemaContent content;
    content = ToDafny.AuthenticateSchemaContent(nativeValue.content());
    Option<DafnyMap<? extends DafnySequence<? extends Character>, ? extends AuthenticateAction>> attributes;
    attributes = (Objects.nonNull(nativeValue.attributes()) && nativeValue.attributes().size() > 0) ?
        Option.create_Some(ToDafny.AuthenticateSchemaAttributes(nativeValue.attributes()))
        : Option.create_None();
    return new AuthenticateSchema(content, attributes);
  }

  public static StructuredEncryptionConfig StructuredEncryptionConfig(
      software.amazon.cryptography.structuredEncryption.model.StructuredEncryptionConfig nativeValue) {
    return new StructuredEncryptionConfig();
  }

  public static EncryptStructureOutput EncryptStructureOutput(
      software.amazon.cryptography.structuredEncryption.model.EncryptStructureOutput nativeValue) {
    StructuredData encryptedStructure;
    encryptedStructure = ToDafny.StructuredData(nativeValue.encryptedStructure());
    return new EncryptStructureOutput(encryptedStructure);
  }

  public static StructuredData StructuredData(
      software.amazon.cryptography.structuredEncryption.model.StructuredData nativeValue) {
    StructuredDataContent content;
    content = ToDafny.StructuredDataContent(nativeValue.content());
    Option<DafnyMap<? extends DafnySequence<? extends Character>, ? extends StructuredDataTerminal>> attributes;
    attributes = (Objects.nonNull(nativeValue.attributes()) && nativeValue.attributes().size() > 0) ?
        Option.create_Some(ToDafny.StructuredDataAttributes(nativeValue.attributes()))
        : Option.create_None();
    return new StructuredData(content, attributes);
  }

  public static EncryptStructureInput EncryptStructureInput(
      software.amazon.cryptography.structuredEncryption.model.EncryptStructureInput nativeValue) {
    DafnySequence<? extends Character> tableName;
    tableName = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.tableName());
    StructuredData plaintextStructure;
    plaintextStructure = ToDafny.StructuredData(nativeValue.plaintextStructure());
    CryptoSchema cryptoSchema;
    cryptoSchema = ToDafny.CryptoSchema(nativeValue.cryptoSchema());
    ICryptographicMaterialsManager cmm;
    cmm = software.amazon.cryptography.materialProviders.ToDafny.CryptographicMaterialsManager(nativeValue.cmm());
    Option<DBEAlgorithmSuiteId> algorithmSuiteId;
    algorithmSuiteId = Objects.nonNull(nativeValue.algorithmSuiteId()) ?
        Option.create_Some(software.amazon.cryptography.materialProviders.ToDafny.DBEAlgorithmSuiteId(nativeValue.algorithmSuiteId()))
        : Option.create_None();
    Option<DafnyMap<? extends DafnySequence<? extends Byte>, ? extends DafnySequence<? extends Byte>>> encryptionContext;
    encryptionContext = (Objects.nonNull(nativeValue.encryptionContext()) && nativeValue.encryptionContext().size() > 0) ?
        Option.create_Some(software.amazon.cryptography.materialProviders.ToDafny.EncryptionContext(nativeValue.encryptionContext()))
        : Option.create_None();
    return new EncryptStructureInput(tableName, plaintextStructure, cryptoSchema, cmm, algorithmSuiteId, encryptionContext);
  }

  public static Error Error(StructuredEncryptionException nativeValue) {
    DafnySequence<? extends Character> message;
    message = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.message());
    return new Error_StructuredEncryptionException(message);
  }

  public static AuthenticateAction AuthenticateAction(
      software.amazon.cryptography.structuredEncryption.model.AuthenticateAction nativeValue) {
    switch (nativeValue) {
      case SIGN: {
        return AuthenticateAction.create_SIGN();
      }
      case DO_NOT_SIGN: {
        return AuthenticateAction.create_DO__NOT__SIGN();
      }
      default: {
        throw new RuntimeException("Cannot convert " + nativeValue + " to Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction.");
      }
    }
  }

  public static CryptoAction CryptoAction(
      software.amazon.cryptography.structuredEncryption.model.CryptoAction nativeValue) {
    switch (nativeValue) {
      case ENCRYPT_AND_SIGN: {
        return CryptoAction.create_ENCRYPT__AND__SIGN();
      }
      case SIGN_ONLY: {
        return CryptoAction.create_SIGN__ONLY();
      }
      case DO_NOTHING: {
        return CryptoAction.create_DO__NOTHING();
      }
      default: {
        throw new RuntimeException("Cannot convert " + nativeValue + " to Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.");
      }
    }
  }

  public static StructuredDataContent StructuredDataContent(
      software.amazon.cryptography.structuredEncryption.model.StructuredDataContent nativeValue) {
    if (Objects.nonNull(nativeValue.Terminal())) {
      return StructuredDataContent.create_Terminal(ToDafny.StructuredDataTerminal(nativeValue.Terminal()));
    }
    if (Objects.nonNull(nativeValue.DataList())) {
      return StructuredDataContent.create_DataList(ToDafny.StructuredDataList(nativeValue.DataList()));
    }
    if (Objects.nonNull(nativeValue.DataMap())) {
      return StructuredDataContent.create_DataMap(ToDafny.StructuredDataMap(nativeValue.DataMap()));
    }
    throw new IllegalArgumentException("Cannot convert " + nativeValue + " to Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataContent.");
  }

  public static CryptoSchemaContent CryptoSchemaContent(
      software.amazon.cryptography.structuredEncryption.model.CryptoSchemaContent nativeValue) {
    if (Objects.nonNull(nativeValue.Action())) {
      return CryptoSchemaContent.create_Action(ToDafny.CryptoAction(nativeValue.Action()));
    }
    if (Objects.nonNull(nativeValue.SchemaMap())) {
      return CryptoSchemaContent.create_SchemaMap(ToDafny.CryptoSchemaMap(nativeValue.SchemaMap()));
    }
    if (Objects.nonNull(nativeValue.SchemaList())) {
      return CryptoSchemaContent.create_SchemaList(ToDafny.CryptoSchemaList(nativeValue.SchemaList()));
    }
    throw new IllegalArgumentException("Cannot convert " + nativeValue + " to Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchemaContent.");
  }

  public static AuthenticateSchemaContent AuthenticateSchemaContent(
      software.amazon.cryptography.structuredEncryption.model.AuthenticateSchemaContent nativeValue) {
    if (Objects.nonNull(nativeValue.Action())) {
      return AuthenticateSchemaContent.create_Action(ToDafny.AuthenticateAction(nativeValue.Action()));
    }
    if (Objects.nonNull(nativeValue.SchemaMap())) {
      return AuthenticateSchemaContent.create_SchemaMap(ToDafny.AuthenticateSchemaMap(nativeValue.SchemaMap()));
    }
    if (Objects.nonNull(nativeValue.SchemaList())) {
      return AuthenticateSchemaContent.create_SchemaList(ToDafny.AuthenticateSchemaList(nativeValue.SchemaList()));
    }
    throw new IllegalArgumentException("Cannot convert " + nativeValue + " to Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchemaContent.");
  }

  public static DafnySequence<? extends CryptoSchema> CryptoSchemaList(
      List<software.amazon.cryptography.structuredEncryption.model.CryptoSchema> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue, 
        software.amazon.cryptography.structuredEncryption.ToDafny::CryptoSchema, 
        CryptoSchema._typeDescriptor());
  }

  public static DafnySequence<? extends AuthenticateSchema> AuthenticateSchemaList(
      List<software.amazon.cryptography.structuredEncryption.model.AuthenticateSchema> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue, 
        software.amazon.cryptography.structuredEncryption.ToDafny::AuthenticateSchema, 
        AuthenticateSchema._typeDescriptor());
  }

  public static DafnySequence<? extends StructuredData> StructuredDataList(
      List<software.amazon.cryptography.structuredEncryption.model.StructuredData> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue, 
        software.amazon.cryptography.structuredEncryption.ToDafny::StructuredData, 
        StructuredData._typeDescriptor());
  }

  public static DafnyMap<? extends DafnySequence<? extends Character>, ? extends AuthenticateAction> AuthenticateSchemaAttributes(
      Map<String, software.amazon.cryptography.structuredEncryption.model.AuthenticateAction> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToMap(
        nativeValue, 
        software.amazon.dafny.conversion.ToDafny.Simple::CharacterSequence, 
        software.amazon.cryptography.structuredEncryption.ToDafny::AuthenticateAction);
  }

  public static DafnyMap<? extends DafnySequence<? extends Character>, ? extends StructuredData> StructuredDataMap(
      Map<String, software.amazon.cryptography.structuredEncryption.model.StructuredData> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToMap(
        nativeValue, 
        software.amazon.dafny.conversion.ToDafny.Simple::CharacterSequence, 
        software.amazon.cryptography.structuredEncryption.ToDafny::StructuredData);
  }

  public static DafnyMap<? extends DafnySequence<? extends Character>, ? extends CryptoSchema> CryptoSchemaMap(
      Map<String, software.amazon.cryptography.structuredEncryption.model.CryptoSchema> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToMap(
        nativeValue, 
        software.amazon.dafny.conversion.ToDafny.Simple::CharacterSequence, 
        software.amazon.cryptography.structuredEncryption.ToDafny::CryptoSchema);
  }

  public static DafnyMap<? extends DafnySequence<? extends Character>, ? extends AuthenticateSchema> AuthenticateSchemaMap(
      Map<String, software.amazon.cryptography.structuredEncryption.model.AuthenticateSchema> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToMap(
        nativeValue, 
        software.amazon.dafny.conversion.ToDafny.Simple::CharacterSequence, 
        software.amazon.cryptography.structuredEncryption.ToDafny::AuthenticateSchema);
  }

  public static DafnyMap<? extends DafnySequence<? extends Character>, ? extends StructuredDataTerminal> StructuredDataAttributes(
      Map<String, software.amazon.cryptography.structuredEncryption.model.StructuredDataTerminal> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToMap(
        nativeValue, 
        software.amazon.dafny.conversion.ToDafny.Simple::CharacterSequence, 
        software.amazon.cryptography.structuredEncryption.ToDafny::StructuredDataTerminal);
  }

  public static DafnyMap<? extends DafnySequence<? extends Character>, ? extends AuthenticateAction> CryptoSchemaAttributes(
      Map<String, software.amazon.cryptography.structuredEncryption.model.AuthenticateAction> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToMap(
        nativeValue, 
        software.amazon.dafny.conversion.ToDafny.Simple::CharacterSequence, 
        software.amazon.cryptography.structuredEncryption.ToDafny::AuthenticateAction);
  }
}
