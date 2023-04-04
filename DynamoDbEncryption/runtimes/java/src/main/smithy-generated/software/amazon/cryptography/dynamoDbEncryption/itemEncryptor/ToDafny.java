// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.itemEncryptor;

import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DynamoDbItemEncryptorConfig;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error_DynamoDbItemEncryptorException;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.LegacyConfig;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PlaintextPolicy;
import Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId;
import Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager;
import Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction;
import Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue;
import Wrappers_Compile.Option;
import dafny.DafnyMap;
import dafny.DafnySequence;
import java.lang.Character;
import java.util.Objects;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.CollectionOfErrors;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.DynamoDbItemEncryptorException;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.NativeError;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.OpaqueError;

public class ToDafny {
  public static Error Error(NativeError nativeValue) {
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

<<<<<<< HEAD
=======
  public static DecryptItemInput DecryptItemInput(
      software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.DecryptItemInput nativeValue) {
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends AttributeValue> encryptedItem;
    encryptedItem = Dafny.Com.Amazonaws.Dynamodb.ToDafny.AttributeMap(nativeValue.encryptedItem());
    return new DecryptItemInput(encryptedItem);
  }

>>>>>>> 3b02be3f26a9925ecfba7ec6c06ebbe3b60c212b
  public static DecryptItemOutput DecryptItemOutput(
      software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.DecryptItemOutput nativeValue) {
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends AttributeValue> plaintextItem;
    plaintextItem = Dafny.Com.Amazonaws.Dynamodb.ToDafny.AttributeMap(nativeValue.plaintextItem());
    return new DecryptItemOutput(plaintextItem);
  }

  public static EncryptItemOutput EncryptItemOutput(
      software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.EncryptItemOutput nativeValue) {
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends AttributeValue> encryptedItem;
    encryptedItem = Dafny.Com.Amazonaws.Dynamodb.ToDafny.AttributeMap(nativeValue.encryptedItem());
    return new EncryptItemOutput(encryptedItem);
  }

<<<<<<< HEAD
  public static DecryptItemInput DecryptItemInput(
      software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.DecryptItemInput nativeValue) {
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends AttributeValue> encryptedItem;
    encryptedItem = Dafny.Com.Amazonaws.Dynamodb.ToDafny.AttributeMap(nativeValue.encryptedItem());
    return new DecryptItemInput(encryptedItem);
=======
  public static EncryptItemInput EncryptItemInput(
      software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.EncryptItemInput nativeValue) {
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends AttributeValue> plaintextItem;
    plaintextItem = Dafny.Com.Amazonaws.Dynamodb.ToDafny.AttributeMap(nativeValue.plaintextItem());
    return new EncryptItemInput(plaintextItem);
>>>>>>> 3b02be3f26a9925ecfba7ec6c06ebbe3b60c212b
  }

  public static DynamoDbItemEncryptorConfig DynamoDbItemEncryptorConfig(
      software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.DynamoDbItemEncryptorConfig nativeValue) {
    DafnySequence<? extends Character> tableName;
    tableName = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.tableName());
    DafnySequence<? extends Character> partitionKeyName;
    partitionKeyName = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.partitionKeyName());
    Option<DafnySequence<? extends Character>> sortKeyName;
    sortKeyName = Objects.nonNull(nativeValue.sortKeyName()) ?
        Option.create_Some(software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.sortKeyName()))
        : Option.create_None();
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends CryptoAction> attributeActions;
    attributeActions = software.amazon.cryptography.dynamoDbEncryption.ToDafny.AttributeActions(nativeValue.attributeActions());
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
    Option<LegacyConfig> legacyConfig;
    legacyConfig = Objects.nonNull(nativeValue.legacyConfig()) ?
        Option.create_Some(software.amazon.cryptography.dynamoDbEncryption.ToDafny.LegacyConfig(nativeValue.legacyConfig()))
        : Option.create_None();
<<<<<<< HEAD
    Option<PlaintextPolicy> plaintextPolicy;
    plaintextPolicy = Objects.nonNull(nativeValue.plaintextPolicy()) ?
        Option.create_Some(software.amazon.cryptography.dynamoDbEncryption.ToDafny.PlaintextPolicy(nativeValue.plaintextPolicy()))
        : Option.create_None();
    return new DynamoDbItemEncryptorConfig(tableName, partitionKeyName, sortKeyName, attributeActions, allowedUnauthenticatedAttributes, allowedUnauthenticatedAttributePrefix, algorithmSuiteId, keyring, cmm, legacyConfig, plaintextPolicy);
  }

  public static EncryptItemInput EncryptItemInput(
      software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.EncryptItemInput nativeValue) {
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends AttributeValue> plaintextItem;
    plaintextItem = Dafny.Com.Amazonaws.Dynamodb.ToDafny.AttributeMap(nativeValue.plaintextItem());
    return new EncryptItemInput(plaintextItem);
=======
    return new DynamoDbItemEncryptorConfig(tableName, partitionKeyName, sortKeyName, attributeActions, allowedUnauthenticatedAttributes, allowedUnauthenticatedAttributePrefix, algorithmSuiteId, keyring, cmm, legacyConfig);
>>>>>>> 3b02be3f26a9925ecfba7ec6c06ebbe3b60c212b
  }

  public static Error Error(DynamoDbItemEncryptorException nativeValue) {
    DafnySequence<? extends Character> message;
    message = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.message());
    return new Error_DynamoDbItemEncryptorException(message);
  }
}
