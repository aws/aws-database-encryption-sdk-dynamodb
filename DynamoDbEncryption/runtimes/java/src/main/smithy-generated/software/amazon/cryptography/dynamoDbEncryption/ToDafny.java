// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption;

import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BeaconVersion;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CompoundBeacon;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Constructor;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ConstructorPart;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbEncryptionConfig;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTablesEncryptionConfig;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error_DynamoDbEncryptionException;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.NonSensitivePart;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SearchConfig;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SensitivePart;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.StandardBeacon;
import Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId;
import Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager;
import Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction;
import Wrappers_Compile.Option;
import dafny.DafnyMap;
import dafny.DafnySequence;
import java.lang.Boolean;
import java.lang.Character;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
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

  public static DynamoDbEncryptionConfig DynamoDbEncryptionConfig(
      software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionConfig nativeValue) {
    return new DynamoDbEncryptionConfig();
  }

  public static StandardBeacon StandardBeacon(
      software.amazon.cryptography.dynamoDbEncryption.model.StandardBeacon nativeValue) {
    DafnySequence<? extends Character> name;
    name = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.name());
    Integer length;
    length = (nativeValue.length());
    Option<DafnySequence<? extends Character>> loc;
    loc = Objects.nonNull(nativeValue.loc()) ?
        Option.create_Some(software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.loc()))
        : Option.create_None();
    return new StandardBeacon(name, length, loc);
  }

  public static Constructor Constructor(
      software.amazon.cryptography.dynamoDbEncryption.model.Constructor nativeValue) {
    DafnySequence<? extends ConstructorPart> parts;
    parts = ToDafny.ConstructorPartList(nativeValue.parts());
    return new Constructor(parts);
  }

  public static DynamoDbTablesEncryptionConfig DynamoDbTablesEncryptionConfig(
      software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTablesEncryptionConfig nativeValue) {
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends DynamoDbTableEncryptionConfig> tableEncryptionConfigs;
    tableEncryptionConfigs = ToDafny.DynamoDbTableEncryptionConfigs(nativeValue.tableEncryptionConfigs());
    return new DynamoDbTablesEncryptionConfig(tableEncryptionConfigs);
  }

  public static NonSensitivePart NonSensitivePart(
      software.amazon.cryptography.dynamoDbEncryption.model.NonSensitivePart nativeValue) {
    DafnySequence<? extends Character> name;
    name = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.name());
    DafnySequence<? extends Character> prefix;
    prefix = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.prefix());
    Option<DafnySequence<? extends Character>> loc;
    loc = Objects.nonNull(nativeValue.loc()) ?
        Option.create_Some(software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.loc()))
        : Option.create_None();
    return new NonSensitivePart(name, prefix, loc);
  }

  public static CompoundBeacon CompoundBeacon(
      software.amazon.cryptography.dynamoDbEncryption.model.CompoundBeacon nativeValue) {
    DafnySequence<? extends Character> name;
    name = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.name());
    DafnySequence<? extends Character> split;
    split = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.split());
    DafnySequence<? extends SensitivePart> sensitive;
    sensitive = ToDafny.SensitivePartsList(nativeValue.sensitive());
    Option<DafnySequence<? extends NonSensitivePart>> nonSensitive;
    nonSensitive = (Objects.nonNull(nativeValue.nonSensitive()) && nativeValue.nonSensitive().size() > 0) ?
        Option.create_Some(ToDafny.NonSensitivePartsList(nativeValue.nonSensitive()))
        : Option.create_None();
    Option<DafnySequence<? extends Constructor>> constructors;
    constructors = (Objects.nonNull(nativeValue.constructors()) && nativeValue.constructors().size() > 0) ?
        Option.create_Some(ToDafny.ConstructorList(nativeValue.constructors()))
        : Option.create_None();
    return new CompoundBeacon(name, split, sensitive, nonSensitive, constructors);
  }

  public static SearchConfig SearchConfig(
      software.amazon.cryptography.dynamoDbEncryption.model.SearchConfig nativeValue) {
    DafnySequence<? extends BeaconVersion> versions;
    versions = ToDafny.BeaconVersionList(nativeValue.versions());
    Integer writeVersion;
    writeVersion = (nativeValue.writeVersion());
    return new SearchConfig(versions, writeVersion);
  }

  public static DynamoDbTableEncryptionConfig DynamoDbTableEncryptionConfig(
      software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTableEncryptionConfig nativeValue) {
    DafnySequence<? extends Character> partitionKeyName;
    partitionKeyName = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.partitionKeyName());
    Option<DafnySequence<? extends Character>> sortKeyName;
    sortKeyName = Objects.nonNull(nativeValue.sortKeyName()) ?
        Option.create_Some(software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.sortKeyName()))
        : Option.create_None();
    Option<SearchConfig> search;
    search = Objects.nonNull(nativeValue.search()) ?
        Option.create_Some(ToDafny.SearchConfig(nativeValue.search()))
        : Option.create_None();
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends CryptoAction> attributeActions;
    attributeActions = ToDafny.AttributeActions(nativeValue.attributeActions());
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
    return new DynamoDbTableEncryptionConfig(partitionKeyName, sortKeyName, search, attributeActions, allowedUnauthenticatedAttributes, allowedUnauthenticatedAttributePrefix, algorithmSuiteId, keyring, cmm);
  }

  public static BeaconVersion BeaconVersion(
      software.amazon.cryptography.dynamoDbEncryption.model.BeaconVersion nativeValue) {
    Integer version;
    version = (nativeValue.version());
    IKeyring keyring;
    keyring = software.amazon.cryptography.materialProviders.ToDafny.Keyring(nativeValue.keyring());
    Option<DafnySequence<? extends StandardBeacon>> standardBeacons;
    standardBeacons = (Objects.nonNull(nativeValue.standardBeacons()) && nativeValue.standardBeacons().size() > 0) ?
        Option.create_Some(ToDafny.StandardBeaconList(nativeValue.standardBeacons()))
        : Option.create_None();
    Option<DafnySequence<? extends CompoundBeacon>> compoundBeacons;
    compoundBeacons = (Objects.nonNull(nativeValue.compoundBeacons()) && nativeValue.compoundBeacons().size() > 0) ?
        Option.create_Some(ToDafny.CompoundBeaconList(nativeValue.compoundBeacons()))
        : Option.create_None();
    return new BeaconVersion(version, keyring, standardBeacons, compoundBeacons);
  }

  public static SensitivePart SensitivePart(
      software.amazon.cryptography.dynamoDbEncryption.model.SensitivePart nativeValue) {
    DafnySequence<? extends Character> name;
    name = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.name());
    DafnySequence<? extends Character> prefix;
    prefix = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.prefix());
    Integer length;
    length = (nativeValue.length());
    Option<DafnySequence<? extends Character>> loc;
    loc = Objects.nonNull(nativeValue.loc()) ?
        Option.create_Some(software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.loc()))
        : Option.create_None();
    return new SensitivePart(name, prefix, length, loc);
  }

  public static ConstructorPart ConstructorPart(
      software.amazon.cryptography.dynamoDbEncryption.model.ConstructorPart nativeValue) {
    DafnySequence<? extends Character> name;
    name = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.name());
    Boolean required;
    required = (nativeValue.required());
    return new ConstructorPart(name, required);
  }

  public static Error Error(DynamoDbEncryptionException nativeValue) {
    DafnySequence<? extends Character> message;
    message = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.message());
    return new Error_DynamoDbEncryptionException(message);
  }

  public static DafnySequence<? extends SensitivePart> SensitivePartsList(
      List<software.amazon.cryptography.dynamoDbEncryption.model.SensitivePart> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToDafny::SensitivePart, 
        SensitivePart._typeDescriptor());
  }

  public static DafnySequence<? extends BeaconVersion> BeaconVersionList(
      List<software.amazon.cryptography.dynamoDbEncryption.model.BeaconVersion> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToDafny::BeaconVersion, 
        BeaconVersion._typeDescriptor());
  }

  public static DafnySequence<? extends CompoundBeacon> CompoundBeaconList(
      List<software.amazon.cryptography.dynamoDbEncryption.model.CompoundBeacon> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToDafny::CompoundBeacon, 
        CompoundBeacon._typeDescriptor());
  }

  public static DafnySequence<? extends StandardBeacon> StandardBeaconList(
      List<software.amazon.cryptography.dynamoDbEncryption.model.StandardBeacon> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToDafny::StandardBeacon, 
        StandardBeacon._typeDescriptor());
  }

  public static DafnySequence<? extends Constructor> ConstructorList(
      List<software.amazon.cryptography.dynamoDbEncryption.model.Constructor> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToDafny::Constructor, 
        Constructor._typeDescriptor());
  }

  public static DafnySequence<? extends NonSensitivePart> NonSensitivePartsList(
      List<software.amazon.cryptography.dynamoDbEncryption.model.NonSensitivePart> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToDafny::NonSensitivePart, 
        NonSensitivePart._typeDescriptor());
  }

  public static DafnySequence<? extends ConstructorPart> ConstructorPartList(
      List<software.amazon.cryptography.dynamoDbEncryption.model.ConstructorPart> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToDafny::ConstructorPart, 
        ConstructorPart._typeDescriptor());
  }

  public static DafnyMap<? extends DafnySequence<? extends Character>, ? extends DynamoDbTableEncryptionConfig> DynamoDbTableEncryptionConfigs(
      Map<String, software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTableEncryptionConfig> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToMap(
        nativeValue, 
        software.amazon.dafny.conversion.ToDafny.Simple::CharacterSequence, 
        software.amazon.cryptography.dynamoDbEncryption.ToDafny::DynamoDbTableEncryptionConfig);
  }

  public static DafnyMap<? extends DafnySequence<? extends Character>, ? extends CryptoAction> AttributeActions(
      Map<String, software.amazon.cryptography.structuredEncryption.model.CryptoAction> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToMap(
        nativeValue, 
        software.amazon.dafny.conversion.ToDafny.Simple::CharacterSequence, 
        software.amazon.cryptography.structuredEncryption.ToDafny::CryptoAction);
  }
}
