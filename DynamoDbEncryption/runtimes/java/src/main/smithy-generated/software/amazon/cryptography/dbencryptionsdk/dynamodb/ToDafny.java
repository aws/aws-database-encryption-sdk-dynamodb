// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb;

import Wrappers_Compile.Option;
import dafny.DafnyMap;
import dafny.DafnySequence;
import dafny.TypeDescriptor;
import java.lang.Boolean;
import java.lang.Character;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.AsSet;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconKeySource;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_DynamoDbEncryptionException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionUnion;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetPrefix;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegments;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSubstring;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSuffix;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Insert;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyOverride;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyPolicy;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Lower;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.MultiKeyStore;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PartOnly;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SearchConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Shared;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SharedSet;
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
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.OpaqueWithTextError;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction;
import software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient;
import software.amazon.cryptography.materialproviders.internaldafny.types.CacheType;
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
    if (nativeValue instanceof OpaqueWithTextError) {
      return ToDafny.Error((OpaqueWithTextError) nativeValue);
    }
    if (nativeValue instanceof CollectionOfErrors) {
      return ToDafny.Error((CollectionOfErrors) nativeValue);
    }
    return Error.create_Opaque(nativeValue);
  }

  public static Error Error(OpaqueError nativeValue) {
    return Error.create_Opaque(nativeValue.obj());
  }

  public static Error Error(OpaqueWithTextError nativeValue) {
    return Error.create_OpaqueWithText(
      nativeValue.obj(),
      dafny.DafnySequence.asString(nativeValue.objMessage())
    );
  }

  public static Error Error(CollectionOfErrors nativeValue) {
    DafnySequence<? extends Error> list =
      software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue.list(),
        ToDafny::Error,
        Error._typeDescriptor()
      );
    DafnySequence<? extends Character> message =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.getMessage()
      );
    return Error.create_CollectionOfErrors(list, message);
  }

  public static AsSet AsSet(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.AsSet nativeValue
  ) {
    return new AsSet();
  }

  public static BeaconVersion BeaconVersion(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconVersion nativeValue
  ) {
    Integer version;
    version = (nativeValue.version());
    IKeyStoreClient keyStore;
    keyStore =
      software.amazon.cryptography.keystore.ToDafny.KeyStore(
        nativeValue.keyStore()
      );
    BeaconKeySource keySource;
    keySource = ToDafny.BeaconKeySource(nativeValue.keySource());
    DafnySequence<? extends StandardBeacon> standardBeacons;
    standardBeacons = ToDafny.StandardBeaconList(nativeValue.standardBeacons());
    Option<DafnySequence<? extends CompoundBeacon>> compoundBeacons;
    compoundBeacons =
      (Objects.nonNull(nativeValue.compoundBeacons()) &&
          nativeValue.compoundBeacons().size() > 0)
        ? Option.create_Some(
          DafnySequence._typeDescriptor(CompoundBeacon._typeDescriptor()),
          ToDafny.CompoundBeaconList(nativeValue.compoundBeacons())
        )
        : Option.create_None(
          DafnySequence._typeDescriptor(CompoundBeacon._typeDescriptor())
        );
    Option<DafnySequence<? extends VirtualField>> virtualFields;
    virtualFields =
      (Objects.nonNull(nativeValue.virtualFields()) &&
          nativeValue.virtualFields().size() > 0)
        ? Option.create_Some(
          DafnySequence._typeDescriptor(VirtualField._typeDescriptor()),
          ToDafny.VirtualFieldList(nativeValue.virtualFields())
        )
        : Option.create_None(
          DafnySequence._typeDescriptor(VirtualField._typeDescriptor())
        );
    Option<DafnySequence<? extends EncryptedPart>> encryptedParts;
    encryptedParts =
      (Objects.nonNull(nativeValue.encryptedParts()) &&
          nativeValue.encryptedParts().size() > 0)
        ? Option.create_Some(
          DafnySequence._typeDescriptor(EncryptedPart._typeDescriptor()),
          ToDafny.EncryptedPartsList(nativeValue.encryptedParts())
        )
        : Option.create_None(
          DafnySequence._typeDescriptor(EncryptedPart._typeDescriptor())
        );
    Option<DafnySequence<? extends SignedPart>> signedParts;
    signedParts =
      (Objects.nonNull(nativeValue.signedParts()) &&
          nativeValue.signedParts().size() > 0)
        ? Option.create_Some(
          DafnySequence._typeDescriptor(SignedPart._typeDescriptor()),
          ToDafny.SignedPartsList(nativeValue.signedParts())
        )
        : Option.create_None(
          DafnySequence._typeDescriptor(SignedPart._typeDescriptor())
        );
    return new BeaconVersion(
      version,
      keyStore,
      keySource,
      standardBeacons,
      compoundBeacons,
      virtualFields,
      encryptedParts,
      signedParts
    );
  }

  public static CompoundBeacon CompoundBeacon(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CompoundBeacon nativeValue
  ) {
    DafnySequence<? extends Character> name;
    name =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.name()
      );
    DafnySequence<? extends Character> split;
    split =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.split()
      );
    Option<DafnySequence<? extends EncryptedPart>> encrypted;
    encrypted =
      (Objects.nonNull(nativeValue.encrypted()) &&
          nativeValue.encrypted().size() > 0)
        ? Option.create_Some(
          DafnySequence._typeDescriptor(EncryptedPart._typeDescriptor()),
          ToDafny.EncryptedPartsList(nativeValue.encrypted())
        )
        : Option.create_None(
          DafnySequence._typeDescriptor(EncryptedPart._typeDescriptor())
        );
    Option<DafnySequence<? extends SignedPart>> signed;
    signed =
      (Objects.nonNull(nativeValue.signed()) && nativeValue.signed().size() > 0)
        ? Option.create_Some(
          DafnySequence._typeDescriptor(SignedPart._typeDescriptor()),
          ToDafny.SignedPartsList(nativeValue.signed())
        )
        : Option.create_None(
          DafnySequence._typeDescriptor(SignedPart._typeDescriptor())
        );
    Option<DafnySequence<? extends Constructor>> constructors;
    constructors =
      (Objects.nonNull(nativeValue.constructors()) &&
          nativeValue.constructors().size() > 0)
        ? Option.create_Some(
          DafnySequence._typeDescriptor(Constructor._typeDescriptor()),
          ToDafny.ConstructorList(nativeValue.constructors())
        )
        : Option.create_None(
          DafnySequence._typeDescriptor(Constructor._typeDescriptor())
        );
    return new CompoundBeacon(name, split, encrypted, signed, constructors);
  }

  public static Constructor Constructor(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Constructor nativeValue
  ) {
    DafnySequence<? extends ConstructorPart> parts;
    parts = ToDafny.ConstructorPartList(nativeValue.parts());
    return new Constructor(parts);
  }

  public static ConstructorPart ConstructorPart(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.ConstructorPart nativeValue
  ) {
    DafnySequence<? extends Character> name;
    name =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.name()
      );
    Boolean required;
    required = (nativeValue.required());
    return new ConstructorPart(name, required);
  }

  public static CreateDynamoDbEncryptionBranchKeyIdSupplierInput CreateDynamoDbEncryptionBranchKeyIdSupplierInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CreateDynamoDbEncryptionBranchKeyIdSupplierInput nativeValue
  ) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier ddbKeyBranchKeyIdSupplier;
    ddbKeyBranchKeyIdSupplier =
      ToDafny.DynamoDbKeyBranchKeyIdSupplier(
        nativeValue.ddbKeyBranchKeyIdSupplier()
      );
    return new CreateDynamoDbEncryptionBranchKeyIdSupplierInput(
      ddbKeyBranchKeyIdSupplier
    );
  }

  public static CreateDynamoDbEncryptionBranchKeyIdSupplierOutput CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput nativeValue
  ) {
    IBranchKeyIdSupplier branchKeyIdSupplier;
    branchKeyIdSupplier =
      software.amazon.cryptography.materialproviders.ToDafny.BranchKeyIdSupplier(
        nativeValue.branchKeyIdSupplier()
      );
    return new CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(
      branchKeyIdSupplier
    );
  }

  public static DynamoDbEncryptionConfig DynamoDbEncryptionConfig(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionConfig nativeValue
  ) {
    return new DynamoDbEncryptionConfig();
  }

  public static DynamoDbTableEncryptionConfig DynamoDbTableEncryptionConfig(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig nativeValue
  ) {
    DafnySequence<? extends Character> logicalTableName;
    logicalTableName =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.logicalTableName()
      );
    DafnySequence<? extends Character> partitionKeyName;
    partitionKeyName =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.partitionKeyName()
      );
    Option<DafnySequence<? extends Character>> sortKeyName;
    sortKeyName =
      Objects.nonNull(nativeValue.sortKeyName())
        ? Option.create_Some(
          DafnySequence._typeDescriptor(TypeDescriptor.CHAR),
          software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
            nativeValue.sortKeyName()
          )
        )
        : Option.create_None(
          DafnySequence._typeDescriptor(TypeDescriptor.CHAR)
        );
    Option<SearchConfig> search;
    search =
      Objects.nonNull(nativeValue.search())
        ? Option.create_Some(
          SearchConfig._typeDescriptor(),
          ToDafny.SearchConfig(nativeValue.search())
        )
        : Option.create_None(SearchConfig._typeDescriptor());
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends CryptoAction
    > attributeActionsOnEncrypt;
    attributeActionsOnEncrypt =
      ToDafny.AttributeActions(nativeValue.attributeActionsOnEncrypt());
    Option<
      DafnySequence<? extends DafnySequence<? extends Character>>
    > allowedUnsignedAttributes;
    allowedUnsignedAttributes =
      (Objects.nonNull(nativeValue.allowedUnsignedAttributes()) &&
          nativeValue.allowedUnsignedAttributes().size() > 0)
        ? Option.create_Some(
          DafnySequence._typeDescriptor(
            DafnySequence._typeDescriptor(TypeDescriptor.CHAR)
          ),
          software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.AttributeNameList(
            nativeValue.allowedUnsignedAttributes()
          )
        )
        : Option.create_None(
          DafnySequence._typeDescriptor(
            DafnySequence._typeDescriptor(TypeDescriptor.CHAR)
          )
        );
    Option<DafnySequence<? extends Character>> allowedUnsignedAttributePrefix;
    allowedUnsignedAttributePrefix =
      Objects.nonNull(nativeValue.allowedUnsignedAttributePrefix())
        ? Option.create_Some(
          DafnySequence._typeDescriptor(TypeDescriptor.CHAR),
          software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
            nativeValue.allowedUnsignedAttributePrefix()
          )
        )
        : Option.create_None(
          DafnySequence._typeDescriptor(TypeDescriptor.CHAR)
        );
    Option<DBEAlgorithmSuiteId> algorithmSuiteId;
    algorithmSuiteId =
      Objects.nonNull(nativeValue.algorithmSuiteId())
        ? Option.create_Some(
          DBEAlgorithmSuiteId._typeDescriptor(),
          software.amazon.cryptography.materialproviders.ToDafny.DBEAlgorithmSuiteId(
            nativeValue.algorithmSuiteId()
          )
        )
        : Option.create_None(DBEAlgorithmSuiteId._typeDescriptor());
    Option<IKeyring> keyring;
    keyring =
      Objects.nonNull(nativeValue.keyring())
        ? Option.create_Some(
          TypeDescriptor.reference(IKeyring.class),
          software.amazon.cryptography.materialproviders.ToDafny.Keyring(
            nativeValue.keyring()
          )
        )
        : Option.create_None(TypeDescriptor.reference(IKeyring.class));
    Option<ICryptographicMaterialsManager> cmm;
    cmm =
      Objects.nonNull(nativeValue.cmm())
        ? Option.create_Some(
          TypeDescriptor.reference(ICryptographicMaterialsManager.class),
          software.amazon.cryptography.materialproviders.ToDafny.CryptographicMaterialsManager(
            nativeValue.cmm()
          )
        )
        : Option.create_None(
          TypeDescriptor.reference(ICryptographicMaterialsManager.class)
        );
    Option<LegacyOverride> legacyOverride;
    legacyOverride =
      Objects.nonNull(nativeValue.legacyOverride())
        ? Option.create_Some(
          LegacyOverride._typeDescriptor(),
          ToDafny.LegacyOverride(nativeValue.legacyOverride())
        )
        : Option.create_None(LegacyOverride._typeDescriptor());
    Option<PlaintextOverride> plaintextOverride;
    plaintextOverride =
      Objects.nonNull(nativeValue.plaintextOverride())
        ? Option.create_Some(
          PlaintextOverride._typeDescriptor(),
          ToDafny.PlaintextOverride(nativeValue.plaintextOverride())
        )
        : Option.create_None(PlaintextOverride._typeDescriptor());
    return new DynamoDbTableEncryptionConfig(
      logicalTableName,
      partitionKeyName,
      sortKeyName,
      search,
      attributeActionsOnEncrypt,
      allowedUnsignedAttributes,
      allowedUnsignedAttributePrefix,
      algorithmSuiteId,
      keyring,
      cmm,
      legacyOverride,
      plaintextOverride
    );
  }

  public static DynamoDbTablesEncryptionConfig DynamoDbTablesEncryptionConfig(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig nativeValue
  ) {
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends DynamoDbTableEncryptionConfig
    > tableEncryptionConfigs;
    tableEncryptionConfigs =
      ToDafny.DynamoDbTableEncryptionConfigList(
        nativeValue.tableEncryptionConfigs()
      );
    return new DynamoDbTablesEncryptionConfig(tableEncryptionConfigs);
  }

  public static EncryptedDataKeyDescription EncryptedDataKeyDescription(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.EncryptedDataKeyDescription nativeValue
  ) {
    DafnySequence<? extends Character> keyProviderId;
    keyProviderId =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.keyProviderId()
      );
    Option<DafnySequence<? extends Character>> keyProviderInfo;
    keyProviderInfo =
      Objects.nonNull(nativeValue.keyProviderInfo())
        ? Option.create_Some(
          DafnySequence._typeDescriptor(TypeDescriptor.CHAR),
          software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
            nativeValue.keyProviderInfo()
          )
        )
        : Option.create_None(
          DafnySequence._typeDescriptor(TypeDescriptor.CHAR)
        );
    Option<DafnySequence<? extends Character>> branchKeyId;
    branchKeyId =
      Objects.nonNull(nativeValue.branchKeyId())
        ? Option.create_Some(
          DafnySequence._typeDescriptor(TypeDescriptor.CHAR),
          software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
            nativeValue.branchKeyId()
          )
        )
        : Option.create_None(
          DafnySequence._typeDescriptor(TypeDescriptor.CHAR)
        );
    Option<DafnySequence<? extends Character>> branchKeyVersion;
    branchKeyVersion =
      Objects.nonNull(nativeValue.branchKeyVersion())
        ? Option.create_Some(
          DafnySequence._typeDescriptor(TypeDescriptor.CHAR),
          software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
            nativeValue.branchKeyVersion()
          )
        )
        : Option.create_None(
          DafnySequence._typeDescriptor(TypeDescriptor.CHAR)
        );
    return new EncryptedDataKeyDescription(
      keyProviderId,
      keyProviderInfo,
      branchKeyId,
      branchKeyVersion
    );
  }

  public static EncryptedPart EncryptedPart(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.EncryptedPart nativeValue
  ) {
    DafnySequence<? extends Character> name;
    name =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.name()
      );
    DafnySequence<? extends Character> prefix;
    prefix =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.prefix()
      );
    return new EncryptedPart(name, prefix);
  }

  public static GetBranchKeyIdFromDdbKeyInput GetBranchKeyIdFromDdbKeyInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetBranchKeyIdFromDdbKeyInput nativeValue
  ) {
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends AttributeValue
    > ddbKey;
    ddbKey =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.Key(
        nativeValue.ddbKey()
      );
    return new GetBranchKeyIdFromDdbKeyInput(ddbKey);
  }

  public static GetBranchKeyIdFromDdbKeyOutput GetBranchKeyIdFromDdbKeyOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetBranchKeyIdFromDdbKeyOutput nativeValue
  ) {
    DafnySequence<? extends Character> branchKeyId;
    branchKeyId =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.branchKeyId()
      );
    return new GetBranchKeyIdFromDdbKeyOutput(branchKeyId);
  }

  public static GetEncryptedDataKeyDescriptionInput GetEncryptedDataKeyDescriptionInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionInput nativeValue
  ) {
    GetEncryptedDataKeyDescriptionUnion input;
    input = ToDafny.GetEncryptedDataKeyDescriptionUnion(nativeValue.input());
    return new GetEncryptedDataKeyDescriptionInput(input);
  }

  public static GetEncryptedDataKeyDescriptionOutput GetEncryptedDataKeyDescriptionOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionOutput nativeValue
  ) {
    DafnySequence<
      ? extends EncryptedDataKeyDescription
    > encryptedDataKeyDescriptionOutput;
    encryptedDataKeyDescriptionOutput =
      ToDafny.EncryptedDataKeyDescriptionList(
        nativeValue.EncryptedDataKeyDescriptionOutput()
      );
    return new GetEncryptedDataKeyDescriptionOutput(
      encryptedDataKeyDescriptionOutput
    );
  }

  public static GetPrefix GetPrefix(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetPrefix nativeValue
  ) {
    Integer length;
    length = (nativeValue.length());
    return new GetPrefix(length);
  }

  public static GetSegment GetSegment(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetSegment nativeValue
  ) {
    DafnySequence<? extends Character> split;
    split =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.split()
      );
    Integer index;
    index = (nativeValue.index());
    return new GetSegment(split, index);
  }

  public static GetSegments GetSegments(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetSegments nativeValue
  ) {
    DafnySequence<? extends Character> split;
    split =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.split()
      );
    Integer low;
    low = (nativeValue.low());
    Integer high;
    high = (nativeValue.high());
    return new GetSegments(split, low, high);
  }

  public static GetSubstring GetSubstring(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetSubstring nativeValue
  ) {
    Integer low;
    low = (nativeValue.low());
    Integer high;
    high = (nativeValue.high());
    return new GetSubstring(low, high);
  }

  public static GetSuffix GetSuffix(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetSuffix nativeValue
  ) {
    Integer length;
    length = (nativeValue.length());
    return new GetSuffix(length);
  }

  public static Insert Insert(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Insert nativeValue
  ) {
    DafnySequence<? extends Character> literal;
    literal =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.literal()
      );
    return new Insert(literal);
  }

  public static LegacyOverride LegacyOverride(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyOverride nativeValue
  ) {
    LegacyPolicy policy;
    policy = ToDafny.LegacyPolicy(nativeValue.policy());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ILegacyDynamoDbEncryptor encryptor;
    encryptor = ToDafny.LegacyDynamoDbEncryptor(nativeValue.encryptor());
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends CryptoAction
    > attributeActionsOnEncrypt;
    attributeActionsOnEncrypt =
      ToDafny.AttributeActions(nativeValue.attributeActionsOnEncrypt());
    Option<CryptoAction> defaultAttributeFlag;
    defaultAttributeFlag =
      Objects.nonNull(nativeValue.defaultAttributeFlag())
        ? Option.create_Some(
          CryptoAction._typeDescriptor(),
          software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToDafny.CryptoAction(
            nativeValue.defaultAttributeFlag()
          )
        )
        : Option.create_None(CryptoAction._typeDescriptor());
    return new LegacyOverride(
      policy,
      encryptor,
      attributeActionsOnEncrypt,
      defaultAttributeFlag
    );
  }

  public static Lower Lower(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Lower nativeValue
  ) {
    return new Lower();
  }

  public static MultiKeyStore MultiKeyStore(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.MultiKeyStore nativeValue
  ) {
    DafnySequence<? extends Character> keyFieldName;
    keyFieldName =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.keyFieldName()
      );
    Integer cacheTTL;
    cacheTTL = (nativeValue.cacheTTL());
    Option<CacheType> cache;
    cache =
      Objects.nonNull(nativeValue.cache())
        ? Option.create_Some(
          CacheType._typeDescriptor(),
          software.amazon.cryptography.materialproviders.ToDafny.CacheType(
            nativeValue.cache()
          )
        )
        : Option.create_None(CacheType._typeDescriptor());
    Option<DafnySequence<? extends Character>> partitionId;
    partitionId =
      Objects.nonNull(nativeValue.partitionId())
        ? Option.create_Some(
          DafnySequence._typeDescriptor(TypeDescriptor.CHAR),
          software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
            nativeValue.partitionId()
          )
        )
        : Option.create_None(
          DafnySequence._typeDescriptor(TypeDescriptor.CHAR)
        );
    return new MultiKeyStore(keyFieldName, cacheTTL, cache, partitionId);
  }

  public static PartOnly PartOnly(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.PartOnly nativeValue
  ) {
    return new PartOnly();
  }

  public static SearchConfig SearchConfig(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SearchConfig nativeValue
  ) {
    DafnySequence<? extends BeaconVersion> versions;
    versions = ToDafny.BeaconVersionList(nativeValue.versions());
    Integer writeVersion;
    writeVersion = (nativeValue.writeVersion());
    return new SearchConfig(versions, writeVersion);
  }

  public static Shared Shared(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Shared nativeValue
  ) {
    DafnySequence<? extends Character> other;
    other =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.other()
      );
    return new Shared(other);
  }

  public static SharedSet SharedSet(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SharedSet nativeValue
  ) {
    DafnySequence<? extends Character> other;
    other =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.other()
      );
    return new SharedSet(other);
  }

  public static SignedPart SignedPart(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SignedPart nativeValue
  ) {
    DafnySequence<? extends Character> name;
    name =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.name()
      );
    DafnySequence<? extends Character> prefix;
    prefix =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.prefix()
      );
    Option<DafnySequence<? extends Character>> loc;
    loc =
      Objects.nonNull(nativeValue.loc())
        ? Option.create_Some(
          DafnySequence._typeDescriptor(TypeDescriptor.CHAR),
          software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
            nativeValue.loc()
          )
        )
        : Option.create_None(
          DafnySequence._typeDescriptor(TypeDescriptor.CHAR)
        );
    return new SignedPart(name, prefix, loc);
  }

  public static SingleKeyStore SingleKeyStore(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SingleKeyStore nativeValue
  ) {
    DafnySequence<? extends Character> keyId;
    keyId =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.keyId()
      );
    Integer cacheTTL;
    cacheTTL = (nativeValue.cacheTTL());
    Option<CacheType> cache;
    cache =
      Objects.nonNull(nativeValue.cache())
        ? Option.create_Some(
          CacheType._typeDescriptor(),
          software.amazon.cryptography.materialproviders.ToDafny.CacheType(
            nativeValue.cache()
          )
        )
        : Option.create_None(CacheType._typeDescriptor());
    Option<DafnySequence<? extends Character>> partitionId;
    partitionId =
      Objects.nonNull(nativeValue.partitionId())
        ? Option.create_Some(
          DafnySequence._typeDescriptor(TypeDescriptor.CHAR),
          software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
            nativeValue.partitionId()
          )
        )
        : Option.create_None(
          DafnySequence._typeDescriptor(TypeDescriptor.CHAR)
        );
    return new SingleKeyStore(keyId, cacheTTL, cache, partitionId);
  }

  public static StandardBeacon StandardBeacon(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.StandardBeacon nativeValue
  ) {
    DafnySequence<? extends Character> name;
    name =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.name()
      );
    Integer length;
    length = (nativeValue.length());
    Option<DafnySequence<? extends Character>> loc;
    loc =
      Objects.nonNull(nativeValue.loc())
        ? Option.create_Some(
          DafnySequence._typeDescriptor(TypeDescriptor.CHAR),
          software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
            nativeValue.loc()
          )
        )
        : Option.create_None(
          DafnySequence._typeDescriptor(TypeDescriptor.CHAR)
        );
    Option<BeaconStyle> style;
    style =
      Objects.nonNull(nativeValue.style())
        ? Option.create_Some(
          BeaconStyle._typeDescriptor(),
          ToDafny.BeaconStyle(nativeValue.style())
        )
        : Option.create_None(BeaconStyle._typeDescriptor());
    return new StandardBeacon(name, length, loc, style);
  }

  public static Upper Upper(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Upper nativeValue
  ) {
    return new Upper();
  }

  public static VirtualField VirtualField(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualField nativeValue
  ) {
    DafnySequence<? extends Character> name;
    name =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.name()
      );
    DafnySequence<? extends VirtualPart> parts;
    parts = ToDafny.VirtualPartList(nativeValue.parts());
    return new VirtualField(name, parts);
  }

  public static VirtualPart VirtualPart(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualPart nativeValue
  ) {
    DafnySequence<? extends Character> loc;
    loc =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.loc()
      );
    Option<DafnySequence<? extends VirtualTransform>> trans;
    trans =
      (Objects.nonNull(nativeValue.trans()) && nativeValue.trans().size() > 0)
        ? Option.create_Some(
          DafnySequence._typeDescriptor(VirtualTransform._typeDescriptor()),
          ToDafny.VirtualTransformList(nativeValue.trans())
        )
        : Option.create_None(
          DafnySequence._typeDescriptor(VirtualTransform._typeDescriptor())
        );
    return new VirtualPart(loc, trans);
  }

  public static Error Error(DynamoDbEncryptionException nativeValue) {
    DafnySequence<? extends Character> message;
    message =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.message()
      );
    return new Error_DynamoDbEncryptionException(message);
  }

  public static LegacyPolicy LegacyPolicy(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyPolicy nativeValue
  ) {
    switch (nativeValue) {
      case FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT:
        {
          return LegacyPolicy.create_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT();
        }
      case FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT:
        {
          return LegacyPolicy.create_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT();
        }
      case FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT:
        {
          return LegacyPolicy.create_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT();
        }
      default:
        {
          throw new RuntimeException(
            "Cannot convert " +
            nativeValue +
            " to software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyPolicy."
          );
        }
    }
  }

  public static PlaintextOverride PlaintextOverride(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.PlaintextOverride nativeValue
  ) {
    switch (nativeValue) {
      case FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ:
        {
          return PlaintextOverride.create_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ();
        }
      case FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ:
        {
          return PlaintextOverride.create_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ();
        }
      case FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ:
        {
          return PlaintextOverride.create_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ();
        }
      default:
        {
          throw new RuntimeException(
            "Cannot convert " +
            nativeValue +
            " to software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride."
          );
        }
    }
  }

  public static BeaconKeySource BeaconKeySource(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconKeySource nativeValue
  ) {
    if (Objects.nonNull(nativeValue.single())) {
      return BeaconKeySource.create_single(
        ToDafny.SingleKeyStore(nativeValue.single())
      );
    }
    if (Objects.nonNull(nativeValue.multi())) {
      return BeaconKeySource.create_multi(
        ToDafny.MultiKeyStore(nativeValue.multi())
      );
    }
    throw new IllegalArgumentException(
      "Cannot convert " +
      nativeValue +
      " to software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconKeySource."
    );
  }

  public static BeaconStyle BeaconStyle(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconStyle nativeValue
  ) {
    if (Objects.nonNull(nativeValue.partOnly())) {
      return BeaconStyle.create_partOnly(
        ToDafny.PartOnly(nativeValue.partOnly())
      );
    }
    if (Objects.nonNull(nativeValue.shared())) {
      return BeaconStyle.create_shared(ToDafny.Shared(nativeValue.shared()));
    }
    if (Objects.nonNull(nativeValue.asSet())) {
      return BeaconStyle.create_asSet(ToDafny.AsSet(nativeValue.asSet()));
    }
    if (Objects.nonNull(nativeValue.sharedSet())) {
      return BeaconStyle.create_sharedSet(
        ToDafny.SharedSet(nativeValue.sharedSet())
      );
    }
    throw new IllegalArgumentException(
      "Cannot convert " +
      nativeValue +
      " to software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle."
    );
  }

  public static GetEncryptedDataKeyDescriptionUnion GetEncryptedDataKeyDescriptionUnion(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionUnion nativeValue
  ) {
    if (Objects.nonNull(nativeValue.header())) {
      return GetEncryptedDataKeyDescriptionUnion.create_header(
        software.amazon.smithy.dafny.conversion.ToDafny.Simple.ByteSequence(
          nativeValue.header()
        )
      );
    }
    if (Objects.nonNull(nativeValue.item())) {
      return GetEncryptedDataKeyDescriptionUnion.create_item(
        software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.AttributeMap(
          nativeValue.item()
        )
      );
    }
    throw new IllegalArgumentException(
      "Cannot convert " +
      nativeValue +
      " to software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionUnion."
    );
  }

  public static VirtualTransform VirtualTransform(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualTransform nativeValue
  ) {
    if (Objects.nonNull(nativeValue.upper())) {
      return VirtualTransform.create_upper(ToDafny.Upper(nativeValue.upper()));
    }
    if (Objects.nonNull(nativeValue.lower())) {
      return VirtualTransform.create_lower(ToDafny.Lower(nativeValue.lower()));
    }
    if (Objects.nonNull(nativeValue.insert())) {
      return VirtualTransform.create_insert(
        ToDafny.Insert(nativeValue.insert())
      );
    }
    if (Objects.nonNull(nativeValue.prefix())) {
      return VirtualTransform.create_prefix(
        ToDafny.GetPrefix(nativeValue.prefix())
      );
    }
    if (Objects.nonNull(nativeValue.suffix())) {
      return VirtualTransform.create_suffix(
        ToDafny.GetSuffix(nativeValue.suffix())
      );
    }
    if (Objects.nonNull(nativeValue.substring())) {
      return VirtualTransform.create_substring(
        ToDafny.GetSubstring(nativeValue.substring())
      );
    }
    if (Objects.nonNull(nativeValue.segment())) {
      return VirtualTransform.create_segment(
        ToDafny.GetSegment(nativeValue.segment())
      );
    }
    if (Objects.nonNull(nativeValue.segments())) {
      return VirtualTransform.create_segments(
        ToDafny.GetSegments(nativeValue.segments())
      );
    }
    throw new IllegalArgumentException(
      "Cannot convert " +
      nativeValue +
      " to software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform."
    );
  }

  public static DafnySequence<? extends BeaconVersion> BeaconVersionList(
    List<
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconVersion
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
      nativeValue,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::BeaconVersion,
      BeaconVersion._typeDescriptor()
    );
  }

  public static DafnySequence<? extends CompoundBeacon> CompoundBeaconList(
    List<
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CompoundBeacon
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
      nativeValue,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::CompoundBeacon,
      CompoundBeacon._typeDescriptor()
    );
  }

  public static DafnySequence<? extends Constructor> ConstructorList(
    List<
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Constructor
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
      nativeValue,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::Constructor,
      Constructor._typeDescriptor()
    );
  }

  public static DafnySequence<? extends ConstructorPart> ConstructorPartList(
    List<
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.ConstructorPart
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
      nativeValue,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::ConstructorPart,
      ConstructorPart._typeDescriptor()
    );
  }

  public static DafnySequence<
    ? extends EncryptedDataKeyDescription
  > EncryptedDataKeyDescriptionList(
    List<
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.EncryptedDataKeyDescription
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
      nativeValue,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::EncryptedDataKeyDescription,
      EncryptedDataKeyDescription._typeDescriptor()
    );
  }

  public static DafnySequence<? extends EncryptedPart> EncryptedPartsList(
    List<
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.EncryptedPart
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
      nativeValue,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::EncryptedPart,
      EncryptedPart._typeDescriptor()
    );
  }

  public static DafnySequence<? extends SignedPart> SignedPartsList(
    List<
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SignedPart
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
      nativeValue,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::SignedPart,
      SignedPart._typeDescriptor()
    );
  }

  public static DafnySequence<? extends StandardBeacon> StandardBeaconList(
    List<
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.StandardBeacon
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
      nativeValue,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::StandardBeacon,
      StandardBeacon._typeDescriptor()
    );
  }

  public static DafnySequence<? extends VirtualField> VirtualFieldList(
    List<
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualField
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
      nativeValue,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::VirtualField,
      VirtualField._typeDescriptor()
    );
  }

  public static DafnySequence<? extends VirtualPart> VirtualPartList(
    List<
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualPart
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
      nativeValue,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::VirtualPart,
      VirtualPart._typeDescriptor()
    );
  }

  public static DafnySequence<? extends VirtualTransform> VirtualTransformList(
    List<
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualTransform
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
      nativeValue,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::VirtualTransform,
      VirtualTransform._typeDescriptor()
    );
  }

  public static DafnyMap<
    ? extends DafnySequence<? extends Character>,
    ? extends CryptoAction
  > AttributeActions(
    Map<
      String,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToMap(
      nativeValue,
      software.amazon.smithy.dafny.conversion.ToDafny.Simple::CharacterSequence,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToDafny::CryptoAction
    );
  }

  public static DafnyMap<
    ? extends DafnySequence<? extends Character>,
    ? extends DynamoDbTableEncryptionConfig
  > DynamoDbTableEncryptionConfigList(
    Map<
      String,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToMap(
      nativeValue,
      software.amazon.smithy.dafny.conversion.ToDafny.Simple::CharacterSequence,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny::DynamoDbTableEncryptionConfig
    );
  }

  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier DynamoDbKeyBranchKeyIdSupplier(
    IDynamoDbKeyBranchKeyIdSupplier nativeValue
  ) {
    return DynamoDbKeyBranchKeyIdSupplier.wrap(nativeValue).impl();
  }

  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ILegacyDynamoDbEncryptor LegacyDynamoDbEncryptor(
    ILegacyDynamoDbEncryptor nativeValue
  ) {
    return LegacyDynamoDbEncryptor.wrap(nativeValue).impl();
  }

  public static IDynamoDbEncryptionClient DynamoDbEncryption(
    DynamoDbEncryption nativeValue
  ) {
    return nativeValue.impl();
  }
}
