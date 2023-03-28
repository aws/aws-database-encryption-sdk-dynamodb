// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption;

import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error_CollectionOfErrors;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error_DynamoDbEncryptionException;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error_Opaque;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbItemBranchKeyIdSupplier;
import dafny.DafnyMap;
import dafny.DafnySequence;
import java.lang.Character;
import java.lang.IllegalArgumentException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import software.amazon.cryptography.dynamoDbEncryption.model.BeaconVersion;
import software.amazon.cryptography.dynamoDbEncryption.model.CollectionOfErrors;
import software.amazon.cryptography.dynamoDbEncryption.model.CompoundBeacon;
import software.amazon.cryptography.dynamoDbEncryption.model.Constructor;
import software.amazon.cryptography.dynamoDbEncryption.model.ConstructorPart;
import software.amazon.cryptography.dynamoDbEncryption.model.CreateDynamoDbEncryptionBranchKeyIdSupplierInput;
import software.amazon.cryptography.dynamoDbEncryption.model.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionException;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.GetBranchKeyIdFromItemInput;
import software.amazon.cryptography.dynamoDbEncryption.model.GetBranchKeyIdFromItemOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.GetPrefix;
import software.amazon.cryptography.dynamoDbEncryption.model.GetSegment;
import software.amazon.cryptography.dynamoDbEncryption.model.GetSegments;
import software.amazon.cryptography.dynamoDbEncryption.model.GetSubstring;
import software.amazon.cryptography.dynamoDbEncryption.model.GetSuffix;
import software.amazon.cryptography.dynamoDbEncryption.model.Insert;
import software.amazon.cryptography.dynamoDbEncryption.model.LegacyConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.LegacyPolicy;
import software.amazon.cryptography.dynamoDbEncryption.model.Lower;
import software.amazon.cryptography.dynamoDbEncryption.model.NativeError;
import software.amazon.cryptography.dynamoDbEncryption.model.NonSensitivePart;
import software.amazon.cryptography.dynamoDbEncryption.model.OpaqueError;
import software.amazon.cryptography.dynamoDbEncryption.model.SearchConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.SensitivePart;
import software.amazon.cryptography.dynamoDbEncryption.model.StandardBeacon;
import software.amazon.cryptography.dynamoDbEncryption.model.Upper;
import software.amazon.cryptography.dynamoDbEncryption.model.VirtualField;
import software.amazon.cryptography.dynamoDbEncryption.model.VirtualPart;
import software.amazon.cryptography.dynamoDbEncryption.model.VirtualTransform;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;

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

  public static NativeError Error(Error dafnyValue) {
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

  public static VirtualPart VirtualPart(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualPart dafnyValue) {
    VirtualPart.Builder nativeBuilder = VirtualPart.builder();
    nativeBuilder.loc(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_loc()));
    if (dafnyValue.dtor_trans().is_Some()) {
      nativeBuilder.trans(ToNative.VirtualTransformList(dafnyValue.dtor_trans().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static DynamoDbEncryptionConfig DynamoDbEncryptionConfig(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbEncryptionConfig dafnyValue) {
    DynamoDbEncryptionConfig.Builder nativeBuilder = DynamoDbEncryptionConfig.builder();
    return nativeBuilder.build();
  }

  public static Insert Insert(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Insert dafnyValue) {
    Insert.Builder nativeBuilder = Insert.builder();
    nativeBuilder.literal(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_literal()));
    return nativeBuilder.build();
  }

  public static StandardBeacon StandardBeacon(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.StandardBeacon dafnyValue) {
    StandardBeacon.Builder nativeBuilder = StandardBeacon.builder();
    nativeBuilder.name(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_name()));
    nativeBuilder.length((dafnyValue.dtor_length()));
    if (dafnyValue.dtor_loc().is_Some()) {
      nativeBuilder.loc(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_loc().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static GetPrefix GetPrefix(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetPrefix dafnyValue) {
    GetPrefix.Builder nativeBuilder = GetPrefix.builder();
    nativeBuilder.length((dafnyValue.dtor_length()));
    return nativeBuilder.build();
  }

  public static Constructor Constructor(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Constructor dafnyValue) {
    Constructor.Builder nativeBuilder = Constructor.builder();
    nativeBuilder.parts(ToNative.ConstructorPartList(dafnyValue.dtor_parts()));
    return nativeBuilder.build();
  }

  public static GetSegments GetSegments(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSegments dafnyValue) {
    GetSegments.Builder nativeBuilder = GetSegments.builder();
    nativeBuilder.split(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_split()));
    nativeBuilder.low((dafnyValue.dtor_low()));
    nativeBuilder.high((dafnyValue.dtor_high()));
    return nativeBuilder.build();
  }

  public static GetSubstring GetSubstring(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSubstring dafnyValue) {
    GetSubstring.Builder nativeBuilder = GetSubstring.builder();
    nativeBuilder.low((dafnyValue.dtor_low()));
    nativeBuilder.high((dafnyValue.dtor_high()));
    return nativeBuilder.build();
  }

  public static CreateDynamoDbEncryptionBranchKeyIdSupplierInput CreateDynamoDbEncryptionBranchKeyIdSupplierInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput dafnyValue) {
    CreateDynamoDbEncryptionBranchKeyIdSupplierInput.Builder nativeBuilder = CreateDynamoDbEncryptionBranchKeyIdSupplierInput.builder();
    nativeBuilder.ddbItemBranchKeyIdSupplier(ToNative.DynamoDbItemBranchKeyIdSupplier(dafnyValue.dtor_ddbItemBranchKeyIdSupplier()));
    return nativeBuilder.build();
  }

  public static DynamoDbTablesEncryptionConfig DynamoDbTablesEncryptionConfig(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTablesEncryptionConfig dafnyValue) {
    DynamoDbTablesEncryptionConfig.Builder nativeBuilder = DynamoDbTablesEncryptionConfig.builder();
    nativeBuilder.tableEncryptionConfigs(ToNative.DynamoDbTableEncryptionConfigList(dafnyValue.dtor_tableEncryptionConfigs()));
    return nativeBuilder.build();
  }

  public static NonSensitivePart NonSensitivePart(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.NonSensitivePart dafnyValue) {
    NonSensitivePart.Builder nativeBuilder = NonSensitivePart.builder();
    nativeBuilder.name(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_name()));
    nativeBuilder.prefix(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_prefix()));
    if (dafnyValue.dtor_loc().is_Some()) {
      nativeBuilder.loc(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_loc().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static LegacyConfig LegacyConfig(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.LegacyConfig dafnyValue) {
    LegacyConfig.Builder nativeBuilder = LegacyConfig.builder();
    nativeBuilder.policy(ToNative.LegacyPolicy(dafnyValue.dtor_policy()));
    nativeBuilder.encryptor(ToNative.LegacyDynamoDbEncryptor(dafnyValue.dtor_encryptor()));
    nativeBuilder.attributeFlags(ToNative.AttributeActions(dafnyValue.dtor_attributeFlags()));
    if (dafnyValue.dtor_defaultAttributeFlag().is_Some()) {
      nativeBuilder.defaultAttributeFlag(software.amazon.cryptography.structuredEncryption.ToNative.CryptoAction(dafnyValue.dtor_defaultAttributeFlag().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static CompoundBeacon CompoundBeacon(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CompoundBeacon dafnyValue) {
    CompoundBeacon.Builder nativeBuilder = CompoundBeacon.builder();
    nativeBuilder.name(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_name()));
    nativeBuilder.split(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_split()));
    nativeBuilder.sensitive(ToNative.SensitivePartsList(dafnyValue.dtor_sensitive()));
    if (dafnyValue.dtor_nonSensitive().is_Some()) {
      nativeBuilder.nonSensitive(ToNative.NonSensitivePartsList(dafnyValue.dtor_nonSensitive().dtor_value()));
    }
    if (dafnyValue.dtor_constructors().is_Some()) {
      nativeBuilder.constructors(ToNative.ConstructorList(dafnyValue.dtor_constructors().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static SearchConfig SearchConfig(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SearchConfig dafnyValue) {
    SearchConfig.Builder nativeBuilder = SearchConfig.builder();
    nativeBuilder.versions(ToNative.BeaconVersionList(dafnyValue.dtor_versions()));
    nativeBuilder.writeVersion((dafnyValue.dtor_writeVersion()));
    return nativeBuilder.build();
  }

  public static Lower Lower(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Lower dafnyValue) {
    Lower.Builder nativeBuilder = Lower.builder();
    return nativeBuilder.build();
  }

  public static VirtualField VirtualField(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualField dafnyValue) {
    VirtualField.Builder nativeBuilder = VirtualField.builder();
    nativeBuilder.name(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_name()));
    nativeBuilder.parts(ToNative.VirtualPartList(dafnyValue.dtor_parts()));
    return nativeBuilder.build();
  }

  public static GetSegment GetSegment(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSegment dafnyValue) {
    GetSegment.Builder nativeBuilder = GetSegment.builder();
    nativeBuilder.split(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_split()));
    nativeBuilder.index((dafnyValue.dtor_index()));
    return nativeBuilder.build();
  }

  public static CreateDynamoDbEncryptionBranchKeyIdSupplierOutput CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput dafnyValue) {
    CreateDynamoDbEncryptionBranchKeyIdSupplierOutput.Builder nativeBuilder = CreateDynamoDbEncryptionBranchKeyIdSupplierOutput.builder();
    nativeBuilder.branchKeyIdSupplier(software.amazon.cryptography.materialProviders.ToNative.BranchKeyIdSupplier(dafnyValue.dtor_branchKeyIdSupplier()));
    return nativeBuilder.build();
  }

  public static GetSuffix GetSuffix(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSuffix dafnyValue) {
    GetSuffix.Builder nativeBuilder = GetSuffix.builder();
    nativeBuilder.length((dafnyValue.dtor_length()));
    return nativeBuilder.build();
  }

  public static DynamoDbTableEncryptionConfig DynamoDbTableEncryptionConfig(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig dafnyValue) {
    DynamoDbTableEncryptionConfig.Builder nativeBuilder = DynamoDbTableEncryptionConfig.builder();
    nativeBuilder.partitionKeyName(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_partitionKeyName()));
    if (dafnyValue.dtor_sortKeyName().is_Some()) {
      nativeBuilder.sortKeyName(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_sortKeyName().dtor_value()));
    }
    if (dafnyValue.dtor_search().is_Some()) {
      nativeBuilder.search(ToNative.SearchConfig(dafnyValue.dtor_search().dtor_value()));
    }
    nativeBuilder.attributeActions(ToNative.AttributeActions(dafnyValue.dtor_attributeActions()));
    if (dafnyValue.dtor_allowedUnauthenticatedAttributes().is_Some()) {
      nativeBuilder.allowedUnauthenticatedAttributes(Dafny.Com.Amazonaws.Dynamodb.ToNative.AttributeNameList(dafnyValue.dtor_allowedUnauthenticatedAttributes().dtor_value()));
    }
    if (dafnyValue.dtor_allowedUnauthenticatedAttributePrefix().is_Some()) {
      nativeBuilder.allowedUnauthenticatedAttributePrefix(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_allowedUnauthenticatedAttributePrefix().dtor_value()));
    }
    if (dafnyValue.dtor_algorithmSuiteId().is_Some()) {
      nativeBuilder.algorithmSuiteId(software.amazon.cryptography.materialProviders.ToNative.DBEAlgorithmSuiteId(dafnyValue.dtor_algorithmSuiteId().dtor_value()));
    }
    if (dafnyValue.dtor_keyring().is_Some()) {
      nativeBuilder.keyring(software.amazon.cryptography.materialProviders.ToNative.Keyring(dafnyValue.dtor_keyring().dtor_value()));
    }
    if (dafnyValue.dtor_cmm().is_Some()) {
      nativeBuilder.cmm(software.amazon.cryptography.materialProviders.ToNative.CryptographicMaterialsManager(dafnyValue.dtor_cmm().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static BeaconVersion BeaconVersion(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BeaconVersion dafnyValue) {
    BeaconVersion.Builder nativeBuilder = BeaconVersion.builder();
    nativeBuilder.version((dafnyValue.dtor_version()));
    nativeBuilder.keyring(software.amazon.cryptography.materialProviders.ToNative.Keyring(dafnyValue.dtor_keyring()));
    if (dafnyValue.dtor_standardBeacons().is_Some()) {
      nativeBuilder.standardBeacons(ToNative.StandardBeaconList(dafnyValue.dtor_standardBeacons().dtor_value()));
    }
    if (dafnyValue.dtor_compoundBeacons().is_Some()) {
      nativeBuilder.compoundBeacons(ToNative.CompoundBeaconList(dafnyValue.dtor_compoundBeacons().dtor_value()));
    }
    if (dafnyValue.dtor_virtualFields().is_Some()) {
      nativeBuilder.virtualFields(ToNative.VirtualFieldList(dafnyValue.dtor_virtualFields().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static GetBranchKeyIdFromItemOutput GetBranchKeyIdFromItemOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromItemOutput dafnyValue) {
    GetBranchKeyIdFromItemOutput.Builder nativeBuilder = GetBranchKeyIdFromItemOutput.builder();
    nativeBuilder.branchKeyId(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_branchKeyId()));
    return nativeBuilder.build();
  }

  public static GetBranchKeyIdFromItemInput GetBranchKeyIdFromItemInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromItemInput dafnyValue) {
    GetBranchKeyIdFromItemInput.Builder nativeBuilder = GetBranchKeyIdFromItemInput.builder();
    nativeBuilder.ddbItem(Dafny.Com.Amazonaws.Dynamodb.ToNative.AttributeMap(dafnyValue.dtor_ddbItem()));
    return nativeBuilder.build();
  }

  public static Upper Upper(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Upper dafnyValue) {
    Upper.Builder nativeBuilder = Upper.builder();
    return nativeBuilder.build();
  }

  public static SensitivePart SensitivePart(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SensitivePart dafnyValue) {
    SensitivePart.Builder nativeBuilder = SensitivePart.builder();
    nativeBuilder.name(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_name()));
    nativeBuilder.prefix(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_prefix()));
    nativeBuilder.length((dafnyValue.dtor_length()));
    if (dafnyValue.dtor_loc().is_Some()) {
      nativeBuilder.loc(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_loc().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static ConstructorPart ConstructorPart(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ConstructorPart dafnyValue) {
    ConstructorPart.Builder nativeBuilder = ConstructorPart.builder();
    nativeBuilder.name(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_name()));
    nativeBuilder.required((dafnyValue.dtor_required()));
    return nativeBuilder.build();
  }

  public static LegacyPolicy LegacyPolicy(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.LegacyPolicy dafnyValue) {
    if (dafnyValue.is_REQUIRE__ENCRYPT__ALLOW__DECRYPT()) {
      return LegacyPolicy.REQUIRE_ENCRYPT_ALLOW_DECRYPT;
    }
    if (dafnyValue.is_FORBID__ENCRYPT__ALLOW__DECRYPT()) {
      return LegacyPolicy.FORBID_ENCRYPT_ALLOW_DECRYPT;
    }
    if (dafnyValue.is_FORBID__ENCRYPT__FORBID__DECRYPT()) {
      return LegacyPolicy.FORBID_ENCRYPT_FORBID_DECRYPT;
    }
    throw new IllegalArgumentException("No entry of software.amazon.cryptography.dynamoDbEncryption.model.LegacyPolicy matches the input : " + dafnyValue);
  }

  public static VirtualTransform VirtualTransform(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform dafnyValue) {
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

  public static List<VirtualTransform> VirtualTransformList(
      DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToNative::VirtualTransform);
  }

  public static List<SensitivePart> SensitivePartsList(
      DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SensitivePart> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToNative::SensitivePart);
  }

  public static List<BeaconVersion> BeaconVersionList(
      DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BeaconVersion> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToNative::BeaconVersion);
  }

  public static List<CompoundBeacon> CompoundBeaconList(
      DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CompoundBeacon> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToNative::CompoundBeacon);
  }

  public static List<StandardBeacon> StandardBeaconList(
      DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.StandardBeacon> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToNative::StandardBeacon);
  }

  public static List<Constructor> ConstructorList(
      DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Constructor> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToNative::Constructor);
  }

  public static List<VirtualField> VirtualFieldList(
      DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualField> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToNative::VirtualField);
  }

  public static List<NonSensitivePart> NonSensitivePartsList(
      DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.NonSensitivePart> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToNative::NonSensitivePart);
  }

  public static List<ConstructorPart> ConstructorPartList(
      DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ConstructorPart> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToNative::ConstructorPart);
  }

  public static List<VirtualPart> VirtualPartList(
      DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualPart> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue, 
        software.amazon.cryptography.dynamoDbEncryption.ToNative::VirtualPart);
  }

  public static Map<String, CryptoAction> AttributeActions(
      DafnyMap<? extends DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToMap(
        dafnyValue, 
        software.amazon.dafny.conversion.ToNative.Simple::String, 
        software.amazon.cryptography.structuredEncryption.ToNative::CryptoAction);
  }

  public static Map<String, DynamoDbTableEncryptionConfig> DynamoDbTableEncryptionConfigList(
      DafnyMap<? extends DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig> dafnyValue) {
    return software.amazon.dafny.conversion.ToNative.Aggregate.GenericToMap(
        dafnyValue, 
        software.amazon.dafny.conversion.ToNative.Simple::String, 
        software.amazon.cryptography.dynamoDbEncryption.ToNative::DynamoDbTableEncryptionConfig);
  }

  public static DynamoDbItemBranchKeyIdSupplier DynamoDbItemBranchKeyIdSupplier(
      IDynamoDbItemBranchKeyIdSupplier dafnyValue) {
    return DynamoDbItemBranchKeyIdSupplier.wrap(dafnyValue);
  }

  public static ILegacyDynamoDbEncryptor LegacyDynamoDbEncryptor(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ILegacyDynamoDbEncryptor dafnyValue) {
    if (dafnyValue instanceof LegacyDynamoDbEncryptor.NativeWrapper) {
      return ((LegacyDynamoDbEncryptor.NativeWrapper) dafnyValue)._impl;
    }
    return LegacyDynamoDbEncryptor.wrap(dafnyValue);
  }
}
