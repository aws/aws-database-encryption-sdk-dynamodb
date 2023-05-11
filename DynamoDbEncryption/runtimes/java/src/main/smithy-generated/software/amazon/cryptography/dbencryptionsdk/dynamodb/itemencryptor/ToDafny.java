// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor;

import Wrappers_Compile.Option;
import dafny.DafnyMap;
import dafny.DafnySequence;
import java.lang.Byte;
import java.lang.Character;
import java.lang.RuntimeException;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextPolicy;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_DynamoDbItemEncryptorException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.IDynamoDbItemEncryptorClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.ParsedHeader;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.OpaqueError;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction;
import software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey;
import software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue;

public class ToDafny {
  public static Error Error(RuntimeException nativeValue) {
    if (nativeValue instanceof DynamoDbItemEncryptorException) {
      return ToDafny.Error((DynamoDbItemEncryptorException) nativeValue);
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

  public static DecryptItemInput DecryptItemInput(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemInput nativeValue) {
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends AttributeValue> encryptedItem;
    encryptedItem = software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.AttributeMap(nativeValue.encryptedItem());
    return new DecryptItemInput(encryptedItem);
  }

  public static DecryptItemOutput DecryptItemOutput(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemOutput nativeValue) {
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends AttributeValue> plaintextItem;
    plaintextItem = software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.AttributeMap(nativeValue.plaintextItem());
    Option<ParsedHeader> parsedHeader;
    parsedHeader = Objects.nonNull(nativeValue.parsedHeader()) ?
        Option.create_Some(ToDafny.ParsedHeader(nativeValue.parsedHeader()))
        : Option.create_None();
    return new DecryptItemOutput(plaintextItem, parsedHeader);
  }

  public static DynamoDbItemEncryptorConfig DynamoDbItemEncryptorConfig(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorConfig nativeValue) {
    DafnySequence<? extends Character> logicalTableName;
    logicalTableName = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.logicalTableName());
    DafnySequence<? extends Character> partitionKeyName;
    partitionKeyName = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.partitionKeyName());
    Option<DafnySequence<? extends Character>> sortKeyName;
    sortKeyName = Objects.nonNull(nativeValue.sortKeyName()) ?
        Option.create_Some(software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.sortKeyName()))
        : Option.create_None();
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends CryptoAction> attributeActions;
    attributeActions = software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny.AttributeActions(nativeValue.attributeActions());
    Option<DafnySequence<? extends DafnySequence<? extends Character>>> allowedUnauthenticatedAttributes;
    allowedUnauthenticatedAttributes = (Objects.nonNull(nativeValue.allowedUnauthenticatedAttributes()) && nativeValue.allowedUnauthenticatedAttributes().size() > 0) ?
        Option.create_Some(software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.AttributeNameList(nativeValue.allowedUnauthenticatedAttributes()))
        : Option.create_None();
    Option<DafnySequence<? extends Character>> allowedUnauthenticatedAttributePrefix;
    allowedUnauthenticatedAttributePrefix = Objects.nonNull(nativeValue.allowedUnauthenticatedAttributePrefix()) ?
        Option.create_Some(software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.allowedUnauthenticatedAttributePrefix()))
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
    Option<LegacyConfig> legacyConfig;
    legacyConfig = Objects.nonNull(nativeValue.legacyConfig()) ?
        Option.create_Some(software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny.LegacyConfig(nativeValue.legacyConfig()))
        : Option.create_None();
    Option<PlaintextPolicy> plaintextPolicy;
    plaintextPolicy = Objects.nonNull(nativeValue.plaintextPolicy()) ?
        Option.create_Some(software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny.PlaintextPolicy(nativeValue.plaintextPolicy()))
        : Option.create_None();
    return new DynamoDbItemEncryptorConfig(logicalTableName, partitionKeyName, sortKeyName, attributeActions, allowedUnauthenticatedAttributes, allowedUnauthenticatedAttributePrefix, algorithmSuiteId, keyring, cmm, legacyConfig, plaintextPolicy);
  }

  public static EncryptItemInput EncryptItemInput(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemInput nativeValue) {
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends AttributeValue> plaintextItem;
    plaintextItem = software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.AttributeMap(nativeValue.plaintextItem());
    return new EncryptItemInput(plaintextItem);
  }

  public static EncryptItemOutput EncryptItemOutput(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemOutput nativeValue) {
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends AttributeValue> encryptedItem;
    encryptedItem = software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.AttributeMap(nativeValue.encryptedItem());
    Option<ParsedHeader> parsedHeader;
    parsedHeader = Objects.nonNull(nativeValue.parsedHeader()) ?
        Option.create_Some(ToDafny.ParsedHeader(nativeValue.parsedHeader()))
        : Option.create_None();
    return new EncryptItemOutput(encryptedItem, parsedHeader);
  }

  public static ParsedHeader ParsedHeader(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.ParsedHeader nativeValue) {
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends CryptoAction> attributeActions;
    attributeActions = software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny.AttributeActions(nativeValue.attributeActions());
    DBEAlgorithmSuiteId algorithmSuiteId;
    algorithmSuiteId = software.amazon.cryptography.materialproviders.ToDafny.DBEAlgorithmSuiteId(nativeValue.algorithmSuiteId());
    DafnySequence<? extends EncryptedDataKey> encryptedDataKeys;
    encryptedDataKeys = software.amazon.cryptography.materialproviders.ToDafny.EncryptedDataKeyList(nativeValue.encryptedDataKeys());
    DafnyMap<? extends DafnySequence<? extends Byte>, ? extends DafnySequence<? extends Byte>> storedEncryptionContext;
    storedEncryptionContext = software.amazon.cryptography.materialproviders.ToDafny.EncryptionContext(nativeValue.storedEncryptionContext());
    return new ParsedHeader(attributeActions, algorithmSuiteId, encryptedDataKeys, storedEncryptionContext);
  }

  public static Error Error(DynamoDbItemEncryptorException nativeValue) {
    DafnySequence<? extends Character> message;
    message = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.message());
    return new Error_DynamoDbItemEncryptorException(message);
  }

  public static IDynamoDbItemEncryptorClient DynamoDbItemEncryptor(
      DynamoDbItemEncryptor nativeValue) {
    return nativeValue.impl();
  }
}
