// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption;

import Wrappers_Compile.Option;
import dafny.DafnyMap;
import dafny.DafnySequence;
import java.lang.Byte;
import java.lang.Character;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error_StructuredEncryptionException;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.IStructuredEncryptionClient;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ParsedHeader;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.OpaqueError;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredEncryptionException;
import software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey;
import software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager;

public class ToDafny {
  public static Error Error(RuntimeException nativeValue) {
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
    DafnySequence<? extends Error> list = software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue.list(), 
        ToDafny::Error, 
        Error._typeDescriptor());
    DafnySequence<? extends Character> message = software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.getMessage());
    return Error.create_CollectionOfErrors(list, message);
  }

  public static DecryptStructureInput DecryptStructureInput(
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.DecryptStructureInput nativeValue) {
    DafnySequence<? extends Character> tableName;
    tableName = software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.tableName());
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends StructuredDataTerminal> encryptedStructure;
    encryptedStructure = ToDafny.StructuredDataMap(nativeValue.encryptedStructure());
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends AuthenticateAction> authenticateSchema;
    authenticateSchema = ToDafny.AuthenticateSchemaMap(nativeValue.authenticateSchema());
    ICryptographicMaterialsManager cmm;
    cmm = software.amazon.cryptography.materialproviders.ToDafny.CryptographicMaterialsManager(nativeValue.cmm());
    Option<DafnyMap<? extends DafnySequence<? extends Byte>, ? extends DafnySequence<? extends Byte>>> encryptionContext;
    encryptionContext = (Objects.nonNull(nativeValue.encryptionContext()) && nativeValue.encryptionContext().size() > 0) ?
        Option.create_Some(software.amazon.cryptography.materialproviders.ToDafny.EncryptionContext(nativeValue.encryptionContext()))
        : Option.create_None();
    return new DecryptStructureInput(tableName, encryptedStructure, authenticateSchema, cmm, encryptionContext);
  }

  public static DecryptStructureOutput DecryptStructureOutput(
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.DecryptStructureOutput nativeValue) {
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends StructuredDataTerminal> plaintextStructure;
    plaintextStructure = ToDafny.StructuredDataMap(nativeValue.plaintextStructure());
    ParsedHeader parsedHeader;
    parsedHeader = ToDafny.ParsedHeader(nativeValue.parsedHeader());
    return new DecryptStructureOutput(plaintextStructure, parsedHeader);
  }

  public static EncryptStructureInput EncryptStructureInput(
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.EncryptStructureInput nativeValue) {
    DafnySequence<? extends Character> tableName;
    tableName = software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.tableName());
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends StructuredDataTerminal> plaintextStructure;
    plaintextStructure = ToDafny.StructuredDataMap(nativeValue.plaintextStructure());
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends CryptoAction> cryptoSchema;
    cryptoSchema = ToDafny.CryptoSchemaMap(nativeValue.cryptoSchema());
    ICryptographicMaterialsManager cmm;
    cmm = software.amazon.cryptography.materialproviders.ToDafny.CryptographicMaterialsManager(nativeValue.cmm());
    Option<DBEAlgorithmSuiteId> algorithmSuiteId;
    algorithmSuiteId = Objects.nonNull(nativeValue.algorithmSuiteId()) ?
        Option.create_Some(software.amazon.cryptography.materialproviders.ToDafny.DBEAlgorithmSuiteId(nativeValue.algorithmSuiteId()))
        : Option.create_None();
    Option<DafnyMap<? extends DafnySequence<? extends Byte>, ? extends DafnySequence<? extends Byte>>> encryptionContext;
    encryptionContext = (Objects.nonNull(nativeValue.encryptionContext()) && nativeValue.encryptionContext().size() > 0) ?
        Option.create_Some(software.amazon.cryptography.materialproviders.ToDafny.EncryptionContext(nativeValue.encryptionContext()))
        : Option.create_None();
    return new EncryptStructureInput(tableName, plaintextStructure, cryptoSchema, cmm, algorithmSuiteId, encryptionContext);
  }

  public static EncryptStructureOutput EncryptStructureOutput(
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.EncryptStructureOutput nativeValue) {
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends StructuredDataTerminal> encryptedStructure;
    encryptedStructure = ToDafny.StructuredDataMap(nativeValue.encryptedStructure());
    ParsedHeader parsedHeader;
    parsedHeader = ToDafny.ParsedHeader(nativeValue.parsedHeader());
    return new EncryptStructureOutput(encryptedStructure, parsedHeader);
  }

  public static ParsedHeader ParsedHeader(
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.ParsedHeader nativeValue) {
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends CryptoAction> cryptoSchema;
    cryptoSchema = ToDafny.CryptoSchemaMap(nativeValue.cryptoSchema());
    DBEAlgorithmSuiteId algorithmSuiteId;
    algorithmSuiteId = software.amazon.cryptography.materialproviders.ToDafny.DBEAlgorithmSuiteId(nativeValue.algorithmSuiteId());
    DafnySequence<? extends EncryptedDataKey> encryptedDataKeys;
    encryptedDataKeys = software.amazon.cryptography.materialproviders.ToDafny.EncryptedDataKeyList(nativeValue.encryptedDataKeys());
    DafnyMap<? extends DafnySequence<? extends Byte>, ? extends DafnySequence<? extends Byte>> storedEncryptionContext;
    storedEncryptionContext = software.amazon.cryptography.materialproviders.ToDafny.EncryptionContext(nativeValue.storedEncryptionContext());
    DafnyMap<? extends DafnySequence<? extends Byte>, ? extends DafnySequence<? extends Byte>> encryptionContext;
    encryptionContext = software.amazon.cryptography.materialproviders.ToDafny.EncryptionContext(nativeValue.encryptionContext());
    return new ParsedHeader(cryptoSchema, algorithmSuiteId, encryptedDataKeys, storedEncryptionContext, encryptionContext);
  }

  public static StructuredDataTerminal StructuredDataTerminal(
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal nativeValue) {
    DafnySequence<? extends Byte> value;
    value = software.amazon.smithy.dafny.conversion.ToDafny.Simple.ByteSequence(nativeValue.value());
    DafnySequence<? extends Byte> typeId;
    typeId = software.amazon.smithy.dafny.conversion.ToDafny.Simple.ByteSequence(nativeValue.typeId());
    return new StructuredDataTerminal(value, typeId);
  }

  public static StructuredEncryptionConfig StructuredEncryptionConfig(
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredEncryptionConfig nativeValue) {
    return new StructuredEncryptionConfig();
  }

  public static Error Error(StructuredEncryptionException nativeValue) {
    DafnySequence<? extends Character> message;
    message = software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.message());
    return new Error_StructuredEncryptionException(message);
  }

  public static AuthenticateAction AuthenticateAction(
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthenticateAction nativeValue) {
    switch (nativeValue) {
      case SIGN: {
        return AuthenticateAction.create_SIGN();
      }
      case DO_NOT_SIGN: {
        return AuthenticateAction.create_DO__NOT__SIGN();
      }
      default: {
        throw new RuntimeException("Cannot convert " + nativeValue + " to software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateAction.");
      }
    }
  }

  public static CryptoAction CryptoAction(
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction nativeValue) {
    switch (nativeValue) {
      case ENCRYPT_AND_SIGN: {
        return CryptoAction.create_ENCRYPT__AND__SIGN();
      }
      case SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT: {
        return CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT();
      }
      case SIGN_ONLY: {
        return CryptoAction.create_SIGN__ONLY();
      }
      case DO_NOTHING: {
        return CryptoAction.create_DO__NOTHING();
      }
      default: {
        throw new RuntimeException("Cannot convert " + nativeValue + " to software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.");
      }
    }
  }

  public static DafnyMap<? extends DafnySequence<? extends Character>, ? extends AuthenticateAction> AuthenticateSchemaMap(
      Map<String, software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthenticateAction> nativeValue) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToMap(
        nativeValue, 
        software.amazon.smithy.dafny.conversion.ToDafny.Simple::CharacterSequence, 
        software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToDafny::AuthenticateAction);
  }

  public static DafnyMap<? extends DafnySequence<? extends Character>, ? extends CryptoAction> CryptoSchemaMap(
      Map<String, software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction> nativeValue) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToMap(
        nativeValue, 
        software.amazon.smithy.dafny.conversion.ToDafny.Simple::CharacterSequence, 
        software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToDafny::CryptoAction);
  }

  public static DafnyMap<? extends DafnySequence<? extends Character>, ? extends StructuredDataTerminal> StructuredDataMap(
      Map<String, software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal> nativeValue) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToMap(
        nativeValue, 
        software.amazon.smithy.dafny.conversion.ToDafny.Simple::CharacterSequence, 
        software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToDafny::StructuredDataTerminal);
  }

  public static IStructuredEncryptionClient StructuredEncryption(StructuredEncryption nativeValue) {
    return nativeValue.impl();
  }
}
