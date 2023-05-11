// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb;

import Wrappers_Compile.Option;
import dafny.DafnyMap;
import dafny.DafnySequence;
import java.lang.Boolean;
import java.lang.Character;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconKeySource;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_DynamoDbEncryptionException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetPrefix;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegments;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSubstring;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSuffix;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Insert;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyPolicy;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Lower;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.MultiKeyStore;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextPolicy;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SearchConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SingleKeyStore;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Upper;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.OpaqueError;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction;
import software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient;
import software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.internaldafny.types.IBranchKeyIdSupplier;
import software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue;

public class ToDafny {
  public static Error Error(RuntimeException nativeValue) {
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

  public static BeaconVersion BeaconVersion(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconVersion nativeValue) {
    Integer version;
    version = (nativeValue.version());
    IKeyStoreClient keyStore;
    keyStore = software.amazon.cryptography.keystore.ToDafny.KeyStore(nativeValue.keyStore());
    BeaconKeySource keySource;
    keySource = ToDafny.BeaconKeySource(nativeValue.keySource());
    DafnySequence<? extends StandardBeacon> standardBeacons;
    standardBeacons = ToDafny.StandardBeaconList(nativeValue.standardBeacons());
    Option<DafnySequence<? extends CompoundBeacon>> compoundBeacons;
    compoundBeacons = (Objects.nonNull(nativeValue.compoundBeacons()) && nativeValue.compoundBeacons().size() > 0) ?
        Option.create_Some(ToDafny.CompoundBeaconList(nativeValue.compoundBeacons()))
        : Option.create_None();
    Option<DafnySequence<? extends VirtualField>> virtualFields;
    virtualFields = (Objects.nonNull(nativeValue.virtualFields()) && nativeValue.virtualFields().size() > 0) ?
        Option.create_Some(ToDafny.VirtualFieldList(nativeValue.virtualFields()))
        : Option.create_None();
    return new BeaconVersion(version, keyStore, keySource, standardBeacons, compoundBeacons, virtualFields);
  }

  public static CompoundBeacon CompoundBeacon(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CompoundBeacon nativeValue) {
    DafnySequence<? extends Character> name;
    name = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.name());
    DafnySequence<? extends Character> split;
    split = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.split());
    Option<DafnySequence<? extends EncryptedPart>> encrypted;
    encrypted = (Objects.nonNull(nativeValue.encrypted()) && nativeValue.encrypted().size() > 0) ?
        Option.create_Some(ToDafny.EncryptedPartsList(nativeValue.encrypted()))
        : Option.create_None();
    Option<DafnySequence<? extends SignedPart>> signed;
    signed = (Objects.nonNull(nativeValue.signed()) && nativeValue.signed().size() > 0) ?
        Option.create_Some(ToDafny.SignedPartsList(nativeValue.signed()))
        : Option.create_None();
    Option<DafnySequence<? extends Constructor>> constructors;
    constructors = (Objects.nonNull(nativeValue.constructors()) && nativeValue.constructors().size() > 0) ?
        Option.create_Some(ToDafny.ConstructorList(nativeValue.constructors()))
        : Option.create_None();
    return new CompoundBeacon(name, split, encrypted, signed, constructors);
  }

  public static Constructor Constructor(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Constructor nativeValue) {
    DafnySequence<? extends ConstructorPart> parts;
    parts = ToDafny.ConstructorPartList(nativeValue.parts());
    return new Constructor(parts);
  }

  public static ConstructorPart ConstructorPart(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.ConstructorPart nativeValue) {
    DafnySequence<? extends Character> name;
    name = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.name());
    Boolean required;
    required = (nativeValue.required());
    return new ConstructorPart(name, required);
  }

  public static CreateDynamoDbEncryptionBranchKeyIdSupplierInput CreateDynamoDbEncryptionBranchKeyIdSupplierInput(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CreateDynamoDbEncryptionBranchKeyIdSupplierInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier ddbKeyBranchKeyIdSupplier;
    ddbKeyBranchKeyIdSupplier = ToDafny.DynamoDbKeyBranchKeyIdSupplier(nativeValue.ddbKeyBranchKeyIdSupplier());
    return new CreateDynamoDbEncryptionBranchKeyIdSupplierInput(ddbKeyBranchKeyIdSupplier);
  }

  public static CreateDynamoDbEncryptionBranchKeyIdSupplierOutput CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput nativeValue) {
    IBranchKeyIdSupplier branchKeyIdSupplier;
    branchKeyIdSupplier = software.amazon.cryptography.materialproviders.ToDafny.BranchKeyIdSupplier(nativeValue.branchKeyIdSupplier());
    return new CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(branchKeyIdSupplier);
  }

  public static DynamoDbEncryptionConfig DynamoDbEncryptionConfig(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionConfig nativeValue) {
    return new DynamoDbEncryptionConfig();
  }

  public static DynamoDbTableEncryptionConfig DynamoDbTableEncryptionConfig(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig nativeValue) {
    DafnySequence<? extends Character> logicalTableName;
    logicalTableName = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.logicalTableName());
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
        Option.create_Some(ToDafny.LegacyConfig(nativeValue.legacyConfig()))
        : Option.create_None();
    Option<PlaintextPolicy> plaintextPolicy;
    plaintextPolicy = Objects.nonNull(nativeValue.plaintextPolicy()) ?
        Option.create_Some(ToDafny.PlaintextPolicy(nativeValue.plaintextPolicy()))
        : Option.create_None();
    return new DynamoDbTableEncryptionConfig(logicalTableName, partitionKeyName, sortKeyName, search, attributeActions, allowedUnauthenticatedAttributes, allowedUnauthenticatedAttributePrefix, algorithmSuiteId, keyring, cmm, legacyConfig, plaintextPolicy);
  }

  public static DynamoDbTablesEncryptionConfig DynamoDbTablesEncryptionConfig(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig nativeValue) {
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends DynamoDbTableEncryptionConfig> tableEncryptionConfigs;
    tableEncryptionConfigs = ToDafny.DynamoDbTableEncryptionConfigList(nativeValue.tableEncryptionConfigs());
    return new DynamoDbTablesEncryptionConfig(tableEncryptionConfigs);
  }

  public static EncryptedPart EncryptedPart(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.EncryptedPart nativeValue) {
    DafnySequence<? extends Character> name;
    name = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.name());
    DafnySequence<? extends Character> prefix;
    prefix = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.prefix());
    return new EncryptedPart(name, prefix);
  }

  public static GetBranchKeyIdFromDdbKeyInput GetBranchKeyIdFromDdbKeyInput(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetBranchKeyIdFromDdbKeyInput nativeValue) {
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends AttributeValue> ddbKey;
    ddbKey = software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.Key(nativeValue.ddbKey());
    return new GetBranchKeyIdFromDdbKeyInput(ddbKey);
  }

  public static GetBranchKeyIdFromDdbKeyOutput GetBranchKeyIdFromDdbKeyOutput(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetBranchKeyIdFromDdbKeyOutput nativeValue) {
    DafnySequence<? extends Character> branchKeyId;
    branchKeyId = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.branchKeyId());
    return new GetBranchKeyIdFromDdbKeyOutput(branchKeyId);
  }

  public static GetPrefix GetPrefix(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetPrefix nativeValue) {
    Integer length;
    length = (nativeValue.length());
    return new GetPrefix(length);
  }

  public static GetSegment GetSegment(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetSegment nativeValue) {
    DafnySequence<? extends Character> split;
    split = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.split());
    Integer index;
    index = (nativeValue.index());
    return new GetSegment(split, index);
  }

  public static GetSegments GetSegments(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetSegments nativeValue) {
    DafnySequence<? extends Character> split;
    split = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.split());
    Integer low;
    low = (nativeValue.low());
    Integer high;
    high = (nativeValue.high());
    return new GetSegments(split, low, high);
  }

  public static GetSubstring GetSubstring(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetSubstring nativeValue) {
    Integer low;
    low = (nativeValue.low());
    Integer high;
    high = (nativeValue.high());
    return new GetSubstring(low, high);
  }

  public static GetSuffix GetSuffix(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetSuffix nativeValue) {
    Integer length;
    length = (nativeValue.length());
    return new GetSuffix(length);
  }

  public static Insert Insert(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Insert nativeValue) {
    DafnySequence<? extends Character> literal;
    literal = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.literal());
    return new Insert(literal);
  }

  public static LegacyConfig LegacyConfig(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyConfig nativeValue) {
    LegacyPolicy policy;
    policy = ToDafny.LegacyPolicy(nativeValue.policy());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ILegacyDynamoDbEncryptor encryptor;
    encryptor = ToDafny.LegacyDynamoDbEncryptor(nativeValue.encryptor());
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends CryptoAction> attributeFlags;
    attributeFlags = ToDafny.AttributeActions(nativeValue.attributeFlags());
    Option<CryptoAction> defaultAttributeFlag;
    defaultAttributeFlag = Objects.nonNull(nativeValue.defaultAttributeFlag()) ?
        Option.create_Some(software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToDafny.CryptoAction(nativeValue.defaultAttributeFlag()))
        : Option.create_None();
    return new LegacyConfig(policy, encryptor, attributeFlags, defaultAttributeFlag);
  }

  public static Lower Lower(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Lower nativeValue) {
    return new Lower();
  }

  public static MultiKeyStore MultiKeyStore(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.MultiKeyStore nativeValue) {
    DafnySequence<? extends Character> keyFieldName;
    keyFieldName = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.keyFieldName());
    Integer cacheTTL;
    cacheTTL = (nativeValue.cacheTTL());
    Integer maxCacheSize;
    maxCacheSize = (nativeValue.maxCacheSize());
    return new MultiKeyStore(keyFieldName, cacheTTL, maxCacheSize);
  }

  public static SearchConfig SearchConfig(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SearchConfig nativeValue) {
    DafnySequence<? extends BeaconVersion> versions;
    versions = ToDafny.BeaconVersionList(nativeValue.versions());
    Integer writeVersion;
    writeVersion = (nativeValue.writeVersion());
    return new SearchConfig(versions, writeVersion);
  }

  public static SignedPart SignedPart(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SignedPart nativeValue) {
    DafnySequence<? extends Character> name;
    name = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.name());
    DafnySequence<? extends Character> prefix;
    prefix = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.prefix());
    Option<DafnySequence<? extends Character>> loc;
    loc = Objects.nonNull(nativeValue.loc()) ?
        Option.create_Some(software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.loc()))
        : Option.create_None();
    return new SignedPart(name, prefix, loc);
  }

  public static SingleKeyStore SingleKeyStore(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SingleKeyStore nativeValue) {
    DafnySequence<? extends Character> keyId;
    keyId = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.keyId());
    Integer cacheTTL;
    cacheTTL = (nativeValue.cacheTTL());
    return new SingleKeyStore(keyId, cacheTTL);
  }

  public static StandardBeacon StandardBeacon(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.StandardBeacon nativeValue) {
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

  public static Upper Upper(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Upper nativeValue) {
    return new Upper();
  }

  public static VirtualField VirtualField(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualField nativeValue) {
    DafnySequence<? extends Character> name;
    name = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.name());
    DafnySequence<? extends VirtualPart> parts;
    parts = ToDafny.VirtualPartList(nativeValue.parts());
    return new VirtualField(name, parts);
  }

  public static VirtualPart VirtualPart(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualPart nativeValue) {
    DafnySequence<? extends Character> loc;
    loc = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.loc());
    Option<DafnySequence<? extends VirtualTransform>> trans;
    trans = (Objects.nonNull(nativeValue.trans()) && nativeValue.trans().size() > 0) ?
        Option.create_Some(ToDafny.VirtualTransformList(nativeValue.trans()))
        : Option.create_None();
    return new VirtualPart(loc, trans);
  }

  public static Error Error(DynamoDbEncryptionException nativeValue) {
    DafnySequence<? extends Character> message;
    message = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.message());
    return new Error_DynamoDbEncryptionException(message);
  }

  public static LegacyPolicy LegacyPolicy(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyPolicy nativeValue) {
    switch (nativeValue) {
      case REQUIRE_ENCRYPT_ALLOW_DECRYPT: {
        return LegacyPolicy.create_REQUIRE__ENCRYPT__ALLOW__DECRYPT();
      }
      case FORBID_ENCRYPT_ALLOW_DECRYPT: {
        return LegacyPolicy.create_FORBID__ENCRYPT__ALLOW__DECRYPT();
      }
      case FORBID_ENCRYPT_FORBID_DECRYPT: {
        return LegacyPolicy.create_FORBID__ENCRYPT__FORBID__DECRYPT();
      }
      default: {
        throw new RuntimeException("Cannot convert " + nativeValue + " to software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyPolicy.");
      }
    }
  }

  public static PlaintextPolicy PlaintextPolicy(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.PlaintextPolicy nativeValue) {
    switch (nativeValue) {
      case REQUIRE_WRITE_ALLOW_READ: {
        return PlaintextPolicy.create_REQUIRE__WRITE__ALLOW__READ();
      }
      case FORBID_WRITE_ALLOW_READ: {
        return PlaintextPolicy.create_FORBID__WRITE__ALLOW__READ();
      }
      case FORBID_WRITE_FORBID_READ: {
        return PlaintextPolicy.create_FORBID__WRITE__FORBID__READ();
      }
      default: {
        throw new RuntimeException("Cannot convert " + nativeValue + " to software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextPolicy.");
      }
    }
  }

  public static BeaconKeySource BeaconKeySource(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconKeySource nativeValue) {
    if (Objects.nonNull(nativeValue.single())) {
      return BeaconKeySource.create_single(ToDafny.SingleKeyStore(nativeValue.single()));
    }
    if (Objects.nonNull(nativeValue.multi())) {
      return BeaconKeySource.create_multi(ToDafny.MultiKeyStore(nativeValue.multi()));
    }
    throw new IllegalArgumentException("Cannot convert " + nativeValue + " to software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconKeySource.");
  }

  public static VirtualTransform VirtualTransform(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualTransform nativeValue) {
    if (Objects.nonNull(nativeValue.upper())) {
      return VirtualTransform.create_upper(ToDafny.Upper(nativeValue.upper()));
    }
    if (Objects.nonNull(nativeValue.lower())) {
      return VirtualTransform.create_lower(ToDafny.Lower(nativeValue.lower()));
    }
    if (Objects.nonNull(nativeValue.insert())) {
      return VirtualTransform.create_insert(ToDafny.Insert(nativeValue.insert()));
    }
    if (Objects.nonNull(nativeValue.prefix())) {
      return VirtualTransform.create_prefix(ToDafny.GetPrefix(nativeValue.prefix()));
    }
    if (Objects.nonNull(nativeValue.suffix())) {
      return VirtualTransform.create_suffix(ToDafny.GetSuffix(nativeValue.suffix()));
    }
    if (Objects.nonNull(nativeValue.substring())) {
      return VirtualTransform.create_substring(ToDafny.GetSubstring(nativeValue.substring()));
    }
    if (Objects.nonNull(nativeValue.segment())) {
      return VirtualTransform.create_segment(ToDafny.GetSegment(nativeValue.segment()));
    }
    if (Objects.nonNull(nativeValue.segments())) {
      return VirtualTransform.create_segments(ToDafny.GetSegments(nativeValue.segments()));
    }
    throw new IllegalArgumentException("Cannot convert " + nativeValue + " to software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.");
  }

  public static DafnySequence<? extends BeaconVersion> BeaconVersionList(
      List<software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconVersion> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue, 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::BeaconVersion, 
        BeaconVersion._typeDescriptor());
  }

  public static DafnySequence<? extends CompoundBeacon> CompoundBeaconList(
      List<software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CompoundBeacon> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue, 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::CompoundBeacon, 
        CompoundBeacon._typeDescriptor());
  }

  public static DafnySequence<? extends Constructor> ConstructorList(
      List<software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Constructor> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue, 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::Constructor, 
        Constructor._typeDescriptor());
  }

  public static DafnySequence<? extends ConstructorPart> ConstructorPartList(
      List<software.amazon.cryptography.dbencryptionsdk.dynamodb.model.ConstructorPart> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue, 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::ConstructorPart, 
        ConstructorPart._typeDescriptor());
  }

  public static DafnySequence<? extends EncryptedPart> EncryptedPartsList(
      List<software.amazon.cryptography.dbencryptionsdk.dynamodb.model.EncryptedPart> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue, 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::EncryptedPart, 
        EncryptedPart._typeDescriptor());
  }

  public static DafnySequence<? extends SignedPart> SignedPartsList(
      List<software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SignedPart> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue, 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::SignedPart, 
        SignedPart._typeDescriptor());
  }

  public static DafnySequence<? extends StandardBeacon> StandardBeaconList(
      List<software.amazon.cryptography.dbencryptionsdk.dynamodb.model.StandardBeacon> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue, 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::StandardBeacon, 
        StandardBeacon._typeDescriptor());
  }

  public static DafnySequence<? extends VirtualField> VirtualFieldList(
      List<software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualField> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue, 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::VirtualField, 
        VirtualField._typeDescriptor());
  }

  public static DafnySequence<? extends VirtualPart> VirtualPartList(
      List<software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualPart> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue, 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::VirtualPart, 
        VirtualPart._typeDescriptor());
  }

  public static DafnySequence<? extends VirtualTransform> VirtualTransformList(
      List<software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualTransform> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue, 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::VirtualTransform, 
        VirtualTransform._typeDescriptor());
  }

  public static DafnyMap<? extends DafnySequence<? extends Character>, ? extends CryptoAction> AttributeActions(
      Map<String, software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToMap(
        nativeValue, 
        software.amazon.dafny.conversion.ToDafny.Simple::CharacterSequence, 
        software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToDafny::CryptoAction);
  }

  public static DafnyMap<? extends DafnySequence<? extends Character>, ? extends DynamoDbTableEncryptionConfig> DynamoDbTableEncryptionConfigList(
      Map<String, software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig> nativeValue) {
    return software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToMap(
        nativeValue, 
        software.amazon.dafny.conversion.ToDafny.Simple::CharacterSequence, 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::DynamoDbTableEncryptionConfig);
  }

  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier DynamoDbKeyBranchKeyIdSupplier(
      IDynamoDbKeyBranchKeyIdSupplier nativeValue) {
    return DynamoDbKeyBranchKeyIdSupplier.wrap(nativeValue).impl();
  }

  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ILegacyDynamoDbEncryptor LegacyDynamoDbEncryptor(
      ILegacyDynamoDbEncryptor nativeValue) {
    return LegacyDynamoDbEncryptor.wrap(nativeValue).impl();
  }

  public static IDynamoDbEncryptionClient DynamoDbEncryption(DynamoDbEncryption nativeValue) {
    return nativeValue.impl();
  }
}
