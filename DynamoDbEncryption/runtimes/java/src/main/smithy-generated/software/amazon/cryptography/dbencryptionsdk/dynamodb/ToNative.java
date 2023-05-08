// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb;

import dafny.DafnyMap;
import dafny.DafnySequence;
import java.lang.Character;
import java.lang.IllegalArgumentException;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_DynamoDbEncryptionException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_Opaque;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconKeySource;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconVersion;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CompoundBeacon;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Constructor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.ConstructorPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CreateDynamoDbEncryptionBranchKeyIdSupplierInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetBranchKeyIdFromDdbKeyInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetBranchKeyIdFromDdbKeyOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetPrefix;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetSegment;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetSegments;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetSubstring;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetSuffix;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Insert;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyPolicy;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Lower;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.MultiKeyStore;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.NonSensitivePart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.OpaqueError;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.PlaintextPolicy;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SearchConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SensitivePart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SingleKeyStore;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.StandardBeacon;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Upper;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualField;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualTransform;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;

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

  public static DynamoDbEncryptionException Error(Error_DynamoDbEncryptionException dafnyValue) {
    DynamoDbEncryptionException.Builder nativeBuilder = DynamoDbEncryptionException.builder();
    nativeBuilder.message(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_message()));
    return nativeBuilder.build();
  }

  public static RuntimeException Error(Error dafnyValue) {
    if (dafnyValue.is_DynamoDbEncryptionException()) {
      return ToNative.Error((Error_DynamoDbEncryptionException) dafnyValue);
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

  public static BeaconVersion BeaconVersion(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion dafnyValue) {
    BeaconVersion.Builder nativeBuilder = BeaconVersion.builder();
    nativeBuilder.version((dafnyValue.dtor_version()));
    nativeBuilder.keyStore(software.amazon.cryptography.keystore.ToNative.KeyStore(dafnyValue.dtor_keyStore()));
    nativeBuilder.keySource(ToNative.BeaconKeySource(dafnyValue.dtor_keySource()));
    nativeBuilder.standardBeacons(ToNative.StandardBeaconList(dafnyValue.dtor_standardBeacons()));
    if (dafnyValue.dtor_compoundBeacons().is_Some()) {
      nativeBuilder.compoundBeacons(ToNative.CompoundBeaconList(dafnyValue.dtor_compoundBeacons().dtor_value()));
    }
    if (dafnyValue.dtor_virtualFields().is_Some()) {
      nativeBuilder.virtualFields(ToNative.VirtualFieldList(dafnyValue.dtor_virtualFields().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static CompoundBeacon CompoundBeacon(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon dafnyValue) {
    CompoundBeacon.Builder nativeBuilder = CompoundBeacon.builder();
    nativeBuilder.name(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_name()));
    nativeBuilder.split(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_split()));
    if (dafnyValue.dtor_sensitive().is_Some()) {
      nativeBuilder.sensitive(ToNative.SensitivePartsList(dafnyValue.dtor_sensitive().dtor_value()));
    }
    if (dafnyValue.dtor_nonSensitive().is_Some()) {
      nativeBuilder.nonSensitive(ToNative.NonSensitivePartsList(dafnyValue.dtor_nonSensitive().dtor_value()));
    }
    if (dafnyValue.dtor_constructors().is_Some()) {
      nativeBuilder.constructors(ToNative.ConstructorList(dafnyValue.dtor_constructors().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static Constructor Constructor(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor dafnyValue) {
    Constructor.Builder nativeBuilder = Constructor.builder();
    nativeBuilder.parts(ToNative.ConstructorPartList(dafnyValue.dtor_parts()));
    return nativeBuilder.build();
  }

  public static ConstructorPart ConstructorPart(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart dafnyValue) {
    ConstructorPart.Builder nativeBuilder = ConstructorPart.builder();
    nativeBuilder.name(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_name()));
    nativeBuilder.required((dafnyValue.dtor_required()));
    return nativeBuilder.build();
  }

  public static CreateDynamoDbEncryptionBranchKeyIdSupplierInput CreateDynamoDbEncryptionBranchKeyIdSupplierInput(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput dafnyValue) {
    CreateDynamoDbEncryptionBranchKeyIdSupplierInput.Builder nativeBuilder = CreateDynamoDbEncryptionBranchKeyIdSupplierInput.builder();
    nativeBuilder.ddbKeyBranchKeyIdSupplier(ToNative.DynamoDbKeyBranchKeyIdSupplier(dafnyValue.dtor_ddbKeyBranchKeyIdSupplier()));
    return nativeBuilder.build();
  }

  public static CreateDynamoDbEncryptionBranchKeyIdSupplierOutput CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput dafnyValue) {
    CreateDynamoDbEncryptionBranchKeyIdSupplierOutput.Builder nativeBuilder = CreateDynamoDbEncryptionBranchKeyIdSupplierOutput.builder();
    nativeBuilder.branchKeyIdSupplier(software.amazon.cryptography.materialproviders.ToNative.BranchKeyIdSupplier(dafnyValue.dtor_branchKeyIdSupplier()));
    return nativeBuilder.build();
  }

  public static DynamoDbEncryptionConfig DynamoDbEncryptionConfig(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbEncryptionConfig dafnyValue) {
    DynamoDbEncryptionConfig.Builder nativeBuilder = DynamoDbEncryptionConfig.builder();
    return nativeBuilder.build();
  }

  public static DynamoDbTableEncryptionConfig DynamoDbTableEncryptionConfig(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig dafnyValue) {
    DynamoDbTableEncryptionConfig.Builder nativeBuilder = DynamoDbTableEncryptionConfig.builder();
    nativeBuilder.logicalTableName(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_logicalTableName()));
    nativeBuilder.partitionKeyName(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_partitionKeyName()));
    if (dafnyValue.dtor_sortKeyName().is_Some()) {
      nativeBuilder.sortKeyName(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_sortKeyName().dtor_value()));
    }
    if (dafnyValue.dtor_search().is_Some()) {
      nativeBuilder.search(ToNative.SearchConfig(dafnyValue.dtor_search().dtor_value()));
    }
    nativeBuilder.attributeActions(ToNative.AttributeActions(dafnyValue.dtor_attributeActions()));
    if (dafnyValue.dtor_allowedUnauthenticatedAttributes().is_Some()) {
      nativeBuilder.allowedUnauthenticatedAttributes(software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.AttributeNameList(dafnyValue.dtor_allowedUnauthenticatedAttributes().dtor_value()));
    }
    if (dafnyValue.dtor_allowedUnauthenticatedAttributePrefix().is_Some()) {
      nativeBuilder.allowedUnauthenticatedAttributePrefix(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_allowedUnauthenticatedAttributePrefix().dtor_value()));
    }
    if (dafnyValue.dtor_algorithmSuiteId().is_Some()) {
      nativeBuilder.algorithmSuiteId(software.amazon.cryptography.materialproviders.ToNative.DBEAlgorithmSuiteId(dafnyValue.dtor_algorithmSuiteId().dtor_value()));
    }
    if (dafnyValue.dtor_keyring().is_Some()) {
      nativeBuilder.keyring(software.amazon.cryptography.materialproviders.ToNative.Keyring(dafnyValue.dtor_keyring().dtor_value()));
    }
    if (dafnyValue.dtor_cmm().is_Some()) {
      nativeBuilder.cmm(software.amazon.cryptography.materialproviders.ToNative.CryptographicMaterialsManager(dafnyValue.dtor_cmm().dtor_value()));
    }
    if (dafnyValue.dtor_legacyConfig().is_Some()) {
      nativeBuilder.legacyConfig(ToNative.LegacyConfig(dafnyValue.dtor_legacyConfig().dtor_value()));
    }
    if (dafnyValue.dtor_plaintextPolicy().is_Some()) {
      nativeBuilder.plaintextPolicy(ToNative.PlaintextPolicy(dafnyValue.dtor_plaintextPolicy().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static DynamoDbTablesEncryptionConfig DynamoDbTablesEncryptionConfig(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTablesEncryptionConfig dafnyValue) {
    DynamoDbTablesEncryptionConfig.Builder nativeBuilder = DynamoDbTablesEncryptionConfig.builder();
    nativeBuilder.tableEncryptionConfigs(ToNative.DynamoDbTableEncryptionConfigList(dafnyValue.dtor_tableEncryptionConfigs()));
    return nativeBuilder.build();
  }

  public static GetBranchKeyIdFromDdbKeyInput GetBranchKeyIdFromDdbKeyInput(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyInput dafnyValue) {
    GetBranchKeyIdFromDdbKeyInput.Builder nativeBuilder = GetBranchKeyIdFromDdbKeyInput.builder();
    nativeBuilder.ddbKey(software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.Key(dafnyValue.dtor_ddbKey()));
    return nativeBuilder.build();
  }

  public static GetBranchKeyIdFromDdbKeyOutput GetBranchKeyIdFromDdbKeyOutput(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput dafnyValue) {
    GetBranchKeyIdFromDdbKeyOutput.Builder nativeBuilder = GetBranchKeyIdFromDdbKeyOutput.builder();
    nativeBuilder.branchKeyId(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_branchKeyId()));
    return nativeBuilder.build();
  }

  public static GetPrefix GetPrefix(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetPrefix dafnyValue) {
    GetPrefix.Builder nativeBuilder = GetPrefix.builder();
    nativeBuilder.length((dafnyValue.dtor_length()));
    return nativeBuilder.build();
  }

  public static GetSegment GetSegment(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment dafnyValue) {
    GetSegment.Builder nativeBuilder = GetSegment.builder();
    nativeBuilder.split(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_split()));
    nativeBuilder.index((dafnyValue.dtor_index()));
    return nativeBuilder.build();
  }

  public static GetSegments GetSegments(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegments dafnyValue) {
    GetSegments.Builder nativeBuilder = GetSegments.builder();
    nativeBuilder.split(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_split()));
    nativeBuilder.low((dafnyValue.dtor_low()));
    nativeBuilder.high((dafnyValue.dtor_high()));
    return nativeBuilder.build();
  }

  public static GetSubstring GetSubstring(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSubstring dafnyValue) {
    GetSubstring.Builder nativeBuilder = GetSubstring.builder();
    nativeBuilder.low((dafnyValue.dtor_low()));
    nativeBuilder.high((dafnyValue.dtor_high()));
    return nativeBuilder.build();
  }

  public static GetSuffix GetSuffix(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSuffix dafnyValue) {
    GetSuffix.Builder nativeBuilder = GetSuffix.builder();
    nativeBuilder.length((dafnyValue.dtor_length()));
    return nativeBuilder.build();
  }

  public static Insert Insert(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Insert dafnyValue) {
    Insert.Builder nativeBuilder = Insert.builder();
    nativeBuilder.literal(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_literal()));
    return nativeBuilder.build();
  }

  public static LegacyConfig LegacyConfig(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyConfig dafnyValue) {
    LegacyConfig.Builder nativeBuilder = LegacyConfig.builder();
    nativeBuilder.policy(ToNative.LegacyPolicy(dafnyValue.dtor_policy()));
    nativeBuilder.encryptor(ToNative.LegacyDynamoDbEncryptor(dafnyValue.dtor_encryptor()));
    nativeBuilder.attributeFlags(ToNative.AttributeActions(dafnyValue.dtor_attributeFlags()));
    if (dafnyValue.dtor_defaultAttributeFlag().is_Some()) {
      nativeBuilder.defaultAttributeFlag(software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToNative.CryptoAction(dafnyValue.dtor_defaultAttributeFlag().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static Lower Lower(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Lower dafnyValue) {
    Lower.Builder nativeBuilder = Lower.builder();
    return nativeBuilder.build();
  }

  public static MultiKeyStore MultiKeyStore(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.MultiKeyStore dafnyValue) {
    MultiKeyStore.Builder nativeBuilder = MultiKeyStore.builder();
    nativeBuilder.keyFieldName(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_keyFieldName()));
    nativeBuilder.cacheTTL((dafnyValue.dtor_cacheTTL()));
    nativeBuilder.maxCacheSize((dafnyValue.dtor_maxCacheSize()));
    return nativeBuilder.build();
  }

  public static NonSensitivePart NonSensitivePart(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.NonSensitivePart dafnyValue) {
    NonSensitivePart.Builder nativeBuilder = NonSensitivePart.builder();
    nativeBuilder.name(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_name()));
    nativeBuilder.prefix(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_prefix()));
    if (dafnyValue.dtor_loc().is_Some()) {
      nativeBuilder.loc(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_loc().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static SearchConfig SearchConfig(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SearchConfig dafnyValue) {
    SearchConfig.Builder nativeBuilder = SearchConfig.builder();
    nativeBuilder.versions(ToNative.BeaconVersionList(dafnyValue.dtor_versions()));
    nativeBuilder.writeVersion((dafnyValue.dtor_writeVersion()));
    return nativeBuilder.build();
  }

  public static SensitivePart SensitivePart(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SensitivePart dafnyValue) {
    SensitivePart.Builder nativeBuilder = SensitivePart.builder();
    nativeBuilder.name(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_name()));
    nativeBuilder.prefix(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_prefix()));
    return nativeBuilder.build();
  }

  public static SingleKeyStore SingleKeyStore(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SingleKeyStore dafnyValue) {
    SingleKeyStore.Builder nativeBuilder = SingleKeyStore.builder();
    nativeBuilder.keyId(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_keyId()));
    nativeBuilder.cacheTTL((dafnyValue.dtor_cacheTTL()));
    return nativeBuilder.build();
  }

  public static StandardBeacon StandardBeacon(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon dafnyValue) {
    StandardBeacon.Builder nativeBuilder = StandardBeacon.builder();
    nativeBuilder.name(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_name()));
    nativeBuilder.length((dafnyValue.dtor_length()));
    if (dafnyValue.dtor_loc().is_Some()) {
      nativeBuilder.loc(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_loc().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static Upper Upper(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Upper dafnyValue) {
    Upper.Builder nativeBuilder = Upper.builder();
    return nativeBuilder.build();
  }

  public static VirtualField VirtualField(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField dafnyValue) {
    VirtualField.Builder nativeBuilder = VirtualField.builder();
    nativeBuilder.name(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_name()));
    nativeBuilder.parts(ToNative.VirtualPartList(dafnyValue.dtor_parts()));
    return nativeBuilder.build();
  }

  public static VirtualPart VirtualPart(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart dafnyValue) {
    VirtualPart.Builder nativeBuilder = VirtualPart.builder();
    nativeBuilder.loc(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_loc()));
    if (dafnyValue.dtor_trans().is_Some()) {
      nativeBuilder.trans(ToNative.VirtualTransformList(dafnyValue.dtor_trans().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static LegacyPolicy LegacyPolicy(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyPolicy dafnyValue) {
    if (dafnyValue.is_REQUIRE__ENCRYPT__ALLOW__DECRYPT()) {
      return LegacyPolicy.REQUIRE_ENCRYPT_ALLOW_DECRYPT;
    }
    if (dafnyValue.is_FORBID__ENCRYPT__ALLOW__DECRYPT()) {
      return LegacyPolicy.FORBID_ENCRYPT_ALLOW_DECRYPT;
    }
    if (dafnyValue.is_FORBID__ENCRYPT__FORBID__DECRYPT()) {
      return LegacyPolicy.FORBID_ENCRYPT_FORBID_DECRYPT;
    }
    throw new IllegalArgumentException("No entry of software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyPolicy matches the input : " + dafnyValue);
  }

  public static PlaintextPolicy PlaintextPolicy(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextPolicy dafnyValue) {
    if (dafnyValue.is_REQUIRE__WRITE__ALLOW__READ()) {
      return PlaintextPolicy.REQUIRE_WRITE_ALLOW_READ;
    }
    if (dafnyValue.is_FORBID__WRITE__ALLOW__READ()) {
      return PlaintextPolicy.FORBID_WRITE_ALLOW_READ;
    }
    if (dafnyValue.is_FORBID__WRITE__FORBID__READ()) {
      return PlaintextPolicy.FORBID_WRITE_FORBID_READ;
    }
    throw new IllegalArgumentException("No entry of software.amazon.cryptography.dbencryptionsdk.dynamodb.model.PlaintextPolicy matches the input : " + dafnyValue);
  }

  public static BeaconKeySource BeaconKeySource(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconKeySource dafnyValue) {
    BeaconKeySource.Builder nativeBuilder = BeaconKeySource.builder();
    if (dafnyValue.is_single()) {
      nativeBuilder.single(ToNative.SingleKeyStore(dafnyValue.dtor_single()));
    }
    if (dafnyValue.is_multi()) {
      nativeBuilder.multi(ToNative.MultiKeyStore(dafnyValue.dtor_multi()));
    }
    return nativeBuilder.build();
  }

  public static VirtualTransform VirtualTransform(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform dafnyValue) {
    VirtualTransform.Builder nativeBuilder = VirtualTransform.builder();
    if (dafnyValue.is_upper()) {
      nativeBuilder.upper(ToNative.Upper(dafnyValue.dtor_upper()));
    }
    if (dafnyValue.is_lower()) {
      nativeBuilder.lower(ToNative.Lower(dafnyValue.dtor_lower()));
    }
    if (dafnyValue.is_insert()) {
      nativeBuilder.insert(ToNative.Insert(dafnyValue.dtor_insert()));
    }
    if (dafnyValue.is_prefix()) {
      nativeBuilder.prefix(ToNative.GetPrefix(dafnyValue.dtor_prefix()));
    }
    if (dafnyValue.is_suffix()) {
      nativeBuilder.suffix(ToNative.GetSuffix(dafnyValue.dtor_suffix()));
    }
    if (dafnyValue.is_substring()) {
      nativeBuilder.substring(ToNative.GetSubstring(dafnyValue.dtor_substring()));
    }
    if (dafnyValue.is_segment()) {
      nativeBuilder.segment(ToNative.GetSegment(dafnyValue.dtor_segment()));
    }
    if (dafnyValue.is_segments()) {
      nativeBuilder.segments(ToNative.GetSegments(dafnyValue.dtor_segments()));
    }
    return nativeBuilder.build();
  }

  public static List<BeaconVersion> BeaconVersionList(
      DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::BeaconVersion);
  }

  public static List<CompoundBeacon> CompoundBeaconList(
      DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::CompoundBeacon);
  }

  public static List<Constructor> ConstructorList(
      DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::Constructor);
  }

  public static List<ConstructorPart> ConstructorPartList(
      DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::ConstructorPart);
  }

  public static List<NonSensitivePart> NonSensitivePartsList(
      DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.NonSensitivePart> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::NonSensitivePart);
  }

  public static List<SensitivePart> SensitivePartsList(
      DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SensitivePart> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::SensitivePart);
  }

  public static List<StandardBeacon> StandardBeaconList(
      DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::StandardBeacon);
  }

  public static List<VirtualField> VirtualFieldList(
      DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::VirtualField);
  }

  public static List<VirtualPart> VirtualPartList(
      DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::VirtualPart);
  }

  public static List<VirtualTransform> VirtualTransformList(
      DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::VirtualTransform);
  }

  public static Map<String, CryptoAction> AttributeActions(
      DafnyMap<? extends DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToMap(
        dafnyValue, 
        software.amazon.dafny.conversion.ToNative.Simple::String, 
        software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToNative::CryptoAction);
  }

  public static Map<String, DynamoDbTableEncryptionConfig> DynamoDbTableEncryptionConfigList(
      DafnyMap<? extends DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToMap(
        dafnyValue, 
        software.amazon.dafny.conversion.ToNative.Simple::String, 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::DynamoDbTableEncryptionConfig);
  }

  public static IDynamoDbKeyBranchKeyIdSupplier DynamoDbKeyBranchKeyIdSupplier(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier dafnyValue) {
    if (dafnyValue instanceof DynamoDbKeyBranchKeyIdSupplier.NativeWrapper) {
      return ((DynamoDbKeyBranchKeyIdSupplier.NativeWrapper) dafnyValue)._impl;
    }
    return DynamoDbKeyBranchKeyIdSupplier.wrap(dafnyValue);
  }

  public static ILegacyDynamoDbEncryptor LegacyDynamoDbEncryptor(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ILegacyDynamoDbEncryptor dafnyValue) {
    if (dafnyValue instanceof LegacyDynamoDbEncryptor.NativeWrapper) {
      return ((LegacyDynamoDbEncryptor.NativeWrapper) dafnyValue)._impl;
    }
    return LegacyDynamoDbEncryptor.wrap(dafnyValue);
  }

  public static DynamoDbEncryption DynamoDbEncryption(IDynamoDbEncryptionClient dafnyValue) {
    return new DynamoDbEncryption(dafnyValue);
  }
}
