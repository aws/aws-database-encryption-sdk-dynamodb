// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.json;

import Wrappers_Compile.Option;
import dafny.DafnyMap;
import dafny.DafnySequence;
import dafny.TypeDescriptor;
import java.lang.Byte;
import java.lang.Character;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.DecryptObjectInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.DecryptObjectOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.EncryptObjectInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.EncryptObjectOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error_JsonEncryptorException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.IJsonEncryptorClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.JsonEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.ParsedHeader;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.JsonEncryptorException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.OpaqueError;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction;
import software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey;
import software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring;

public class ToDafny {
  public static Error Error(RuntimeException nativeValue) {
    if (nativeValue instanceof JsonEncryptorException) {
      return ToDafny.Error((JsonEncryptorException) nativeValue);
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

  public static DecryptObjectInput DecryptObjectInput(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.DecryptObjectInput nativeValue) {
    DafnySequence<? extends Character> encryptedObject;
    encryptedObject = software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.encryptedObject());
    return new DecryptObjectInput(encryptedObject);
  }

  public static DecryptObjectOutput DecryptObjectOutput(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.DecryptObjectOutput nativeValue) {
    DafnySequence<? extends Character> plaintextObject;
    plaintextObject = software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.plaintextObject());
    Option<ParsedHeader> parsedHeader;
    parsedHeader = Objects.nonNull(nativeValue.parsedHeader()) ?
        Option.create_Some(ToDafny.ParsedHeader(nativeValue.parsedHeader()))
        : Option.create_None();
    return new DecryptObjectOutput(plaintextObject, parsedHeader);
  }

  public static EncryptObjectInput EncryptObjectInput(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.EncryptObjectInput nativeValue) {
    DafnySequence<? extends Character> plaintextObject;
    plaintextObject = software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.plaintextObject());
    return new EncryptObjectInput(plaintextObject);
  }

  public static EncryptObjectOutput EncryptObjectOutput(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.EncryptObjectOutput nativeValue) {
    DafnySequence<? extends Character> encryptedObject;
    encryptedObject = software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.encryptedObject());
    Option<ParsedHeader> parsedHeader;
    parsedHeader = Objects.nonNull(nativeValue.parsedHeader()) ?
        Option.create_Some(ToDafny.ParsedHeader(nativeValue.parsedHeader()))
        : Option.create_None();
    return new EncryptObjectOutput(encryptedObject, parsedHeader);
  }

  public static JsonEncryptorConfig JsonEncryptorConfig(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.JsonEncryptorConfig nativeValue) {
    DafnySequence<? extends Character> logicalTableName;
    logicalTableName = software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.logicalTableName());
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends CryptoAction> attributeActionsOnEncrypt;
    attributeActionsOnEncrypt = ToDafny.AttributeActions(nativeValue.attributeActionsOnEncrypt());
    Option<DafnySequence<? extends DafnySequence<? extends Character>>> allowedUnsignedAttributes;
    allowedUnsignedAttributes = (Objects.nonNull(nativeValue.allowedUnsignedAttributes()) && nativeValue.allowedUnsignedAttributes().size() > 0) ?
        Option.create_Some(ToDafny.AttributeNameList(nativeValue.allowedUnsignedAttributes()))
        : Option.create_None();
    Option<DafnySequence<? extends Character>> allowedUnsignedAttributePrefix;
    allowedUnsignedAttributePrefix = Objects.nonNull(nativeValue.allowedUnsignedAttributePrefix()) ?
        Option.create_Some(software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.allowedUnsignedAttributePrefix()))
        : Option.create_None();
    Option<DBEAlgorithmSuiteId> algorithmSuiteId;
    algorithmSuiteId = Objects.nonNull(nativeValue.algorithmSuiteId()) ?
        Option.create_Some(software.amazon.cryptography.materialproviders.ToDafny.DBEAlgorithmSuiteId(nativeValue.algorithmSuiteId()))
        : Option.create_None();
    Option<IKeyring> keyring;
    keyring = Objects.nonNull(nativeValue.keyring()) ?
        Option.create_Some(software.amazon.cryptography.materialproviders.ToDafny.Keyring(nativeValue.keyring()))
        : Option.create_None();
    Option<ICryptographicMaterialsManager> cmm;
    cmm = Objects.nonNull(nativeValue.cmm()) ?
        Option.create_Some(software.amazon.cryptography.materialproviders.ToDafny.CryptographicMaterialsManager(nativeValue.cmm()))
        : Option.create_None();
    return new JsonEncryptorConfig(logicalTableName, attributeActionsOnEncrypt, allowedUnsignedAttributes, allowedUnsignedAttributePrefix, algorithmSuiteId, keyring, cmm);
  }

  public static ParsedHeader ParsedHeader(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.ParsedHeader nativeValue) {
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends CryptoAction> attributeActionsOnEncrypt;
    attributeActionsOnEncrypt = ToDafny.AttributeActions(nativeValue.attributeActionsOnEncrypt());
    DBEAlgorithmSuiteId algorithmSuiteId;
    algorithmSuiteId = software.amazon.cryptography.materialproviders.ToDafny.DBEAlgorithmSuiteId(nativeValue.algorithmSuiteId());
    DafnySequence<? extends EncryptedDataKey> encryptedDataKeys;
    encryptedDataKeys = software.amazon.cryptography.materialproviders.ToDafny.EncryptedDataKeyList(nativeValue.encryptedDataKeys());
    DafnyMap<? extends DafnySequence<? extends Byte>, ? extends DafnySequence<? extends Byte>> storedEncryptionContext;
    storedEncryptionContext = software.amazon.cryptography.materialproviders.ToDafny.EncryptionContext(nativeValue.storedEncryptionContext());
    return new ParsedHeader(attributeActionsOnEncrypt, algorithmSuiteId, encryptedDataKeys, storedEncryptionContext);
  }

  public static Error Error(JsonEncryptorException nativeValue) {
    DafnySequence<? extends Character> message;
    message = software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.message());
    return new Error_JsonEncryptorException(message);
  }

  public static DafnySequence<? extends DafnySequence<? extends Character>> AttributeNameList(
      List<String> nativeValue) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue, 
        software.amazon.smithy.dafny.conversion.ToDafny.Simple::CharacterSequence, 
        DafnySequence._typeDescriptor(TypeDescriptor.CHAR));
  }

  public static DafnyMap<? extends DafnySequence<? extends Character>, ? extends CryptoAction> AttributeActions(
      Map<String, software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction> nativeValue) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToMap(
        nativeValue, 
        software.amazon.smithy.dafny.conversion.ToDafny.Simple::CharacterSequence, 
        software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToDafny::CryptoAction);
  }

  public static IJsonEncryptorClient JsonEncryptor(JsonEncryptor nativeValue) {
    return nativeValue.impl();
  }
}
