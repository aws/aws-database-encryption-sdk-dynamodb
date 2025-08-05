// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System.Linq;
using System;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public static class TypeConversion
  {
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.AsSet FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_AsSet(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IAsSet value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.AsSet concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.AsSet)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.AsSet converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.AsSet(); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IAsSet ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_AsSet(AWS.Cryptography.DbEncryptionSDK.DynamoDb.AsSet value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.AsSet();
    }
    public static AWS.Cryptography.Primitives.AtomicPrimitives FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S25_AtomicPrimitivesReference(software.amazon.cryptography.primitives.internaldafny.types.IAwsCryptographicPrimitivesClient value)
    {
      if (value is software.amazon.cryptography.primitives.internaldafny.types.IAwsCryptographicPrimitivesClient dafnyValue)
      {
        return new AWS.Cryptography.Primitives.AtomicPrimitives(dafnyValue);
      }
      throw new System.ArgumentException("Custom implementations of AWS.Cryptography.Primitives.AtomicPrimitives are not supported yet");
    }
    public static software.amazon.cryptography.primitives.internaldafny.types.IAwsCryptographicPrimitivesClient ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S25_AtomicPrimitivesReference(AWS.Cryptography.Primitives.AtomicPrimitives value)
    {
      if (value is AWS.Cryptography.Primitives.AtomicPrimitives nativeValue)
      {
        return nativeValue.impl();
      }
      throw new System.ArgumentException("Custom implementations of AWS.Cryptography.Primitives.AtomicPrimitives are not supported yet");
    }
    public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_AttributeActions(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_AttributeActions__M3_key(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_AttributeActions__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_AttributeActions(System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction>(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_AttributeActions__M3_key(pair.Key), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_AttributeActions__M5_value(pair.Value))
     ));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_AttributeActions__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_AttributeActions__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_AttributeActions__M5_value(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_CryptoAction(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_AttributeActions__M5_value(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_CryptoAction(value);
    }
    public static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconBitLength(int value)
    {
      return value;
    }
    public static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconBitLength(int value)
    {
      return value;
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconKeySource FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconKeySource(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconKeySource value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconKeySource concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconKeySource)value;
      var converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconKeySource(); if (value.is_single)
      {
        converted.Single = FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconKeySource__M6_single(concrete.dtor_single);
        return converted;
      }
      if (value.is_multi)
      {
        converted.Multi = FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconKeySource__M5_multi(concrete.dtor_multi);
        return converted;
      }
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconKeySource state");
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconKeySource ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconKeySource(AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconKeySource value)
    {
      value.Validate(); if (value.IsSetSingle())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconKeySource.create_single(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconKeySource__M6_single(value.Single));
      }
      if (value.IsSetMulti())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconKeySource.create_multi(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconKeySource__M5_multi(value.Multi));
      }
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconKeySource state");
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.MultiKeyStore FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconKeySource__M5_multi(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IMultiKeyStore value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IMultiKeyStore ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconKeySource__M5_multi(AWS.Cryptography.DbEncryptionSDK.DynamoDb.MultiKeyStore value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.SingleKeyStore FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconKeySource__M6_single(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISingleKeyStore value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISingleKeyStore ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconKeySource__M6_single(AWS.Cryptography.DbEncryptionSDK.DynamoDb.SingleKeyStore value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconStyle FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconStyle value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle)value;
      var converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconStyle(); if (value.is_partOnly)
      {
        converted.PartOnly = FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M8_partOnly(concrete.dtor_partOnly);
        return converted;
      }
      if (value.is_shared)
      {
        converted.Shared = FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M6_shared(concrete.dtor_shared);
        return converted;
      }
      if (value.is_asSet)
      {
        converted.AsSet = FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M5_asSet(concrete.dtor_asSet);
        return converted;
      }
      if (value.is_sharedSet)
      {
        converted.SharedSet = FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M9_sharedSet(concrete.dtor_sharedSet);
        return converted;
      }
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconStyle state");
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconStyle ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle(AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconStyle value)
    {
      value.Validate(); if (value.IsSetPartOnly())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle.create_partOnly(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M8_partOnly(value.PartOnly));
      }
      if (value.IsSetShared())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle.create_shared(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M6_shared(value.Shared));
      }
      if (value.IsSetAsSet())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle.create_asSet(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M5_asSet(value.AsSet));
      }
      if (value.IsSetSharedSet())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle.create_sharedSet(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M9_sharedSet(value.SharedSet));
      }
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconStyle state");
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.AsSet FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M5_asSet(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IAsSet value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_AsSet(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IAsSet ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M5_asSet(AWS.Cryptography.DbEncryptionSDK.DynamoDb.AsSet value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_AsSet(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.PartOnly FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M8_partOnly(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IPartOnly value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S8_PartOnly(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IPartOnly ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M8_partOnly(AWS.Cryptography.DbEncryptionSDK.DynamoDb.PartOnly value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S8_PartOnly(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Shared FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M6_shared(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IShared value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Shared(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IShared ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M6_shared(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Shared value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Shared(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.SharedSet FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M9_sharedSet(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISharedSet value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_SharedSet(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISharedSet ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M9_sharedSet(AWS.Cryptography.DbEncryptionSDK.DynamoDb.SharedSet value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_SharedSet(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconVersion FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconVersion value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconVersion converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconVersion(); converted.Version = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M7_version(concrete._version);
      converted.KeyStore = (AWS.Cryptography.KeyStore.KeyStore)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M8_keyStore(concrete._keyStore);
      converted.KeySource = (AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconKeySource)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M9_keySource(concrete._keySource);
      converted.StandardBeacons = (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.StandardBeacon>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M15_standardBeacons(concrete._standardBeacons);
      if (concrete._compoundBeacons.is_Some) converted.CompoundBeacons = (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.CompoundBeacon>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M15_compoundBeacons(concrete._compoundBeacons);
      if (concrete._virtualFields.is_Some) converted.VirtualFields = (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualField>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M13_virtualFields(concrete._virtualFields);
      if (concrete._encryptedParts.is_Some) converted.EncryptedParts = (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M14_encryptedParts(concrete._encryptedParts);
      if (concrete._signedParts.is_Some) converted.SignedParts = (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M11_signedParts(concrete._signedParts);
      if (concrete._numberOfBuckets.is_Some) converted.NumberOfBuckets = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M15_numberOfBuckets(concrete._numberOfBuckets); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconVersion ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion(AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconVersion value)
    {
      value.Validate();
      System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.CompoundBeacon> var_compoundBeacons = value.IsSetCompoundBeacons() ? value.CompoundBeacons : (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.CompoundBeacon>)null;
      System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualField> var_virtualFields = value.IsSetVirtualFields() ? value.VirtualFields : (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualField>)null;
      System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart> var_encryptedParts = value.IsSetEncryptedParts() ? value.EncryptedParts : (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart>)null;
      System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart> var_signedParts = value.IsSetSignedParts() ? value.SignedParts : (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart>)null;
      int? var_numberOfBuckets = value.IsSetNumberOfBuckets() ? value.NumberOfBuckets : (int?)null;
      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M7_version(value.Version), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M8_keyStore(value.KeyStore), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M9_keySource(value.KeySource), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M15_standardBeacons(value.StandardBeacons), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M15_compoundBeacons(var_compoundBeacons), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M13_virtualFields(var_virtualFields), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M14_encryptedParts(var_encryptedParts), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M11_signedParts(var_signedParts), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M15_numberOfBuckets(var_numberOfBuckets));
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.CompoundBeacon> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M15_compoundBeacons(Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICompoundBeacon>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.CompoundBeacon>)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_CompoundBeaconList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICompoundBeacon>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M15_compoundBeacons(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.CompoundBeacon> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICompoundBeacon>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICompoundBeacon>>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_CompoundBeaconList((System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.CompoundBeacon>)value));
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M14_encryptedParts(Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedPart>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart>)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_EncryptedPartsList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedPart>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M14_encryptedParts(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedPart>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedPart>>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_EncryptedPartsList((System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart>)value));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconKeySource FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M9_keySource(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconKeySource value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconKeySource(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconKeySource ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M9_keySource(AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconKeySource value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconKeySource(value);
    }
    public static AWS.Cryptography.KeyStore.KeyStore FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M8_keyStore(software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S17_KeyStoreReference(value);
    }
    public static software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M8_keyStore(AWS.Cryptography.KeyStore.KeyStore value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S17_KeyStoreReference(value);
    }
    public static int? FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M15_numberOfBuckets(Wrappers_Compile._IOption<int> value)
    {
      return value.is_None ? (int?)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BucketCount(value.Extract());
    }
    public static Wrappers_Compile._IOption<int> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M15_numberOfBuckets(int? value)
    {
      return value == null ? Wrappers_Compile.Option<int>.create_None() : Wrappers_Compile.Option<int>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BucketCount((int)value));
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M11_signedParts(Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISignedPart>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart>)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_SignedPartsList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISignedPart>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M11_signedParts(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISignedPart>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISignedPart>>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_SignedPartsList((System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart>)value));
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.StandardBeacon> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M15_standardBeacons(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IStandardBeacon> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_StandardBeaconList(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IStandardBeacon> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M15_standardBeacons(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.StandardBeacon> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_StandardBeaconList(value);
    }
    public static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M7_version(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_VersionNumber(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M7_version(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_VersionNumber(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualField> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M13_virtualFields(Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualField>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualField>)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualFieldList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualField>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion__M13_virtualFields(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualField> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualField>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualField>>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualFieldList((System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualField>)value));
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconVersion> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S17_BeaconVersionList(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconVersion> value)
    {
      return new System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconVersion>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S17_BeaconVersionList__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconVersion> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S17_BeaconVersionList(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconVersion> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconVersion>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S17_BeaconVersionList__M6_member).ToArray());
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconVersion FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S17_BeaconVersionList__M6_member(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconVersion value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconVersion ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S17_BeaconVersionList__M6_member(AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconVersion value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_BeaconVersion(value);
    }
    public static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BucketCount(int value)
    {
      return value;
    }
    public static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BucketCount(int value)
    {
      return value;
    }
    public static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_BucketNumber(int value)
    {
      return value;
    }
    public static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_BucketNumber(int value)
    {
      return value;
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.IBucketSelector FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S23_BucketSelectorReference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IBucketSelector value)
    {
      return new BucketSelector(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IBucketSelector ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S23_BucketSelectorReference(AWS.Cryptography.DbEncryptionSDK.DynamoDb.IBucketSelector value)
    {
      if (value is BucketSelector valueWithImpl)
      {
        return valueWithImpl._impl;
      }
      throw new System.ArgumentException("Custom implementations of AWS.Cryptography.DbEncryptionSDK.DynamoDb.IBucketSelector are not supported");

    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S4_Char(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S4_Char(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.CompoundBeacon FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICompoundBeacon value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.CompoundBeacon converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.CompoundBeacon(); converted.Name = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon__M4_name(concrete._name);
      converted.Split = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon__M5_split(concrete._split);
      if (concrete._encrypted.is_Some) converted.Encrypted = (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon__M9_encrypted(concrete._encrypted);
      if (concrete._signed.is_Some) converted.Signed = (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon__M6_signed(concrete._signed);
      if (concrete._constructors.is_Some) converted.Constructors = (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.Constructor>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon__M12_constructors(concrete._constructors); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICompoundBeacon ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon(AWS.Cryptography.DbEncryptionSDK.DynamoDb.CompoundBeacon value)
    {
      value.Validate();
      System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart> var_encrypted = value.IsSetEncrypted() ? value.Encrypted : (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart>)null;
      System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart> var_signed = value.IsSetSigned() ? value.Signed : (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart>)null;
      System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.Constructor> var_constructors = value.IsSetConstructors() ? value.Constructors : (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.Constructor>)null;
      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon__M4_name(value.Name), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon__M5_split(value.Split), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon__M9_encrypted(var_encrypted), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon__M6_signed(var_signed), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon__M12_constructors(var_constructors));
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.Constructor> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon__M12_constructors(Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IConstructor>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.Constructor>)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_ConstructorList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IConstructor>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon__M12_constructors(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.Constructor> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IConstructor>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IConstructor>>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_ConstructorList((System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.Constructor>)value));
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon__M9_encrypted(Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedPart>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart>)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_EncryptedPartsList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedPart>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon__M9_encrypted(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedPart>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedPart>>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_EncryptedPartsList((System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart>)value));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon__M4_name(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon__M4_name(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon__M6_signed(Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISignedPart>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart>)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_SignedPartsList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISignedPart>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon__M6_signed(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISignedPart>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISignedPart>>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_SignedPartsList((System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart>)value));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon__M5_split(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S4_Char(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon__M5_split(string value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S4_Char(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.CompoundBeacon> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_CompoundBeaconList(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICompoundBeacon> value)
    {
      return new System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.CompoundBeacon>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_CompoundBeaconList__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICompoundBeacon> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_CompoundBeaconList(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.CompoundBeacon> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICompoundBeacon>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_CompoundBeaconList__M6_member).ToArray());
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.CompoundBeacon FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_CompoundBeaconList__M6_member(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICompoundBeacon value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICompoundBeacon ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_CompoundBeaconList__M6_member(AWS.Cryptography.DbEncryptionSDK.DynamoDb.CompoundBeacon value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_CompoundBeacon(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Constructor FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_Constructor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IConstructor value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Constructor converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Constructor(); converted.Parts = (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.ConstructorPart>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_Constructor__M5_parts(concrete._parts); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IConstructor ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_Constructor(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Constructor value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_Constructor__M5_parts(value.Parts));
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.ConstructorPart> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_Constructor__M5_parts(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IConstructorPart> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S19_ConstructorPartList(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IConstructorPart> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_Constructor__M5_parts(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.ConstructorPart> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S19_ConstructorPartList(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.Constructor> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_ConstructorList(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IConstructor> value)
    {
      return new System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.Constructor>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_ConstructorList__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IConstructor> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_ConstructorList(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.Constructor> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IConstructor>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_ConstructorList__M6_member).ToArray());
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Constructor FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_ConstructorList__M6_member(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IConstructor value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_Constructor(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IConstructor ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_ConstructorList__M6_member(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Constructor value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_Constructor(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.ConstructorPart FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_ConstructorPart(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IConstructorPart value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.ConstructorPart converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.ConstructorPart(); converted.Name = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_ConstructorPart__M4_name(concrete._name);
      converted.Required = (bool)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_ConstructorPart__M8_required(concrete._required); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IConstructorPart ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_ConstructorPart(AWS.Cryptography.DbEncryptionSDK.DynamoDb.ConstructorPart value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_ConstructorPart__M4_name(value.Name), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_ConstructorPart__M8_required(value.Required));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_ConstructorPart__M4_name(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_ConstructorPart__M4_name(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static bool FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_ConstructorPart__M8_required(bool value)
    {
      return FromDafny_N6_smithy__N3_api__S7_Boolean(value);
    }
    public static bool ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_ConstructorPart__M8_required(bool value)
    {
      return ToDafny_N6_smithy__N3_api__S7_Boolean(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.ConstructorPart> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S19_ConstructorPartList(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IConstructorPart> value)
    {
      return new System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.ConstructorPart>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S19_ConstructorPartList__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IConstructorPart> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S19_ConstructorPartList(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.ConstructorPart> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IConstructorPart>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S19_ConstructorPartList__M6_member).ToArray());
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.ConstructorPart FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S19_ConstructorPartList__M6_member(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IConstructorPart value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_ConstructorPart(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IConstructorPart ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S19_ConstructorPartList__M6_member(AWS.Cryptography.DbEncryptionSDK.DynamoDb.ConstructorPart value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_ConstructorPart(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.CreateDynamoDbEncryptionBranchKeyIdSupplierInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICreateDynamoDbEncryptionBranchKeyIdSupplierInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.CreateDynamoDbEncryptionBranchKeyIdSupplierInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.CreateDynamoDbEncryptionBranchKeyIdSupplierInput(); converted.DdbKeyBranchKeyIdSupplier = (AWS.Cryptography.DbEncryptionSDK.DynamoDb.IDynamoDbKeyBranchKeyIdSupplier)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput__M25_ddbKeyBranchKeyIdSupplier(concrete._ddbKeyBranchKeyIdSupplier); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICreateDynamoDbEncryptionBranchKeyIdSupplierInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.CreateDynamoDbEncryptionBranchKeyIdSupplierInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput__M25_ddbKeyBranchKeyIdSupplier(value.DdbKeyBranchKeyIdSupplier));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.IDynamoDbKeyBranchKeyIdSupplier FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput__M25_ddbKeyBranchKeyIdSupplier(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S39_DynamoDbKeyBranchKeyIdSupplierReference(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput__M25_ddbKeyBranchKeyIdSupplier(AWS.Cryptography.DbEncryptionSDK.DynamoDb.IDynamoDbKeyBranchKeyIdSupplier value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S39_DynamoDbKeyBranchKeyIdSupplierReference(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICreateDynamoDbEncryptionBranchKeyIdSupplierOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(); converted.BranchKeyIdSupplier = (AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput__M19_branchKeyIdSupplier(concrete._branchKeyIdSupplier); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICreateDynamoDbEncryptionBranchKeyIdSupplierOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput__M19_branchKeyIdSupplier(value.BranchKeyIdSupplier));
    }
    public static AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput__M19_branchKeyIdSupplier(software.amazon.cryptography.materialproviders.internaldafny.types.IBranchKeyIdSupplier value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference(value);
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types.IBranchKeyIdSupplier ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput__M19_branchKeyIdSupplier(AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryptionConfig FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S24_DynamoDbEncryptionConfig(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IDynamoDbEncryptionConfig value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbEncryptionConfig concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbEncryptionConfig)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryptionConfig converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryptionConfig(); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IDynamoDbEncryptionConfig ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S24_DynamoDbEncryptionConfig(AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryptionConfig value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbEncryptionConfig();
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryptionException FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_DynamoDbEncryptionException(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_DynamoDbEncryptionException value)
    {
      return new AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryptionException(
      FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_DynamoDbEncryptionException__M7_message(value._message)
      );
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_DynamoDbEncryptionException ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_DynamoDbEncryptionException(AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryptionException value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_DynamoDbEncryptionException(
      ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_DynamoDbEncryptionException__M7_message(value.Message)
      );
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_DynamoDbEncryptionException__M7_message(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_DynamoDbEncryptionException__M7_message(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.IDynamoDbKeyBranchKeyIdSupplier FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S39_DynamoDbKeyBranchKeyIdSupplierReference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier value)
    {
      if (value is NativeWrapper_DynamoDbKeyBranchKeyIdSupplier nativeWrapper) return nativeWrapper._impl;
      return new DynamoDbKeyBranchKeyIdSupplier(value);

    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S39_DynamoDbKeyBranchKeyIdSupplierReference(AWS.Cryptography.DbEncryptionSDK.DynamoDb.IDynamoDbKeyBranchKeyIdSupplier value)
    {
      switch (value)
      {
        case DynamoDbKeyBranchKeyIdSupplier valueWithImpl:
          return valueWithImpl._impl;
        case DynamoDbKeyBranchKeyIdSupplierBase nativeImpl:
          return new NativeWrapper_DynamoDbKeyBranchKeyIdSupplier(nativeImpl);
        default:
          throw new System.ArgumentException(
              "Custom implementations of DynamoDbKeyBranchKeyIdSupplier must extend DynamoDbKeyBranchKeyIdSupplierBase.");
      }
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbTableEncryptionConfig FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IDynamoDbTableEncryptionConfig value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbTableEncryptionConfig converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbTableEncryptionConfig(); converted.LogicalTableName = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M16_logicalTableName(concrete._logicalTableName);
      converted.PartitionKeyName = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M16_partitionKeyName(concrete._partitionKeyName);
      if (concrete._sortKeyName.is_Some) converted.SortKeyName = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M11_sortKeyName(concrete._sortKeyName);
      if (concrete._search.is_Some) converted.Search = (AWS.Cryptography.DbEncryptionSDK.DynamoDb.SearchConfig)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M6_search(concrete._search);
      converted.AttributeActionsOnEncrypt = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M25_attributeActionsOnEncrypt(concrete._attributeActionsOnEncrypt);
      if (concrete._allowedUnsignedAttributes.is_Some) converted.AllowedUnsignedAttributes = (System.Collections.Generic.List<string>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M25_allowedUnsignedAttributes(concrete._allowedUnsignedAttributes);
      if (concrete._allowedUnsignedAttributePrefix.is_Some) converted.AllowedUnsignedAttributePrefix = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M30_allowedUnsignedAttributePrefix(concrete._allowedUnsignedAttributePrefix);
      if (concrete._algorithmSuiteId.is_Some) converted.AlgorithmSuiteId = (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M16_algorithmSuiteId(concrete._algorithmSuiteId);
      if (concrete._keyring.is_Some) converted.Keyring = (AWS.Cryptography.MaterialProviders.IKeyring)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M7_keyring(concrete._keyring);
      if (concrete._cmm.is_Some) converted.Cmm = (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M3_cmm(concrete._cmm);
      if (concrete._legacyOverride.is_Some) converted.LegacyOverride = (AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyOverride)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M14_legacyOverride(concrete._legacyOverride);
      if (concrete._plaintextOverride.is_Some) converted.PlaintextOverride = (AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M17_plaintextOverride(concrete._plaintextOverride);
      if (concrete._bucketSelector.is_Some) converted.BucketSelector = (AWS.Cryptography.DbEncryptionSDK.DynamoDb.IBucketSelector)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M14_bucketSelector(concrete._bucketSelector); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IDynamoDbTableEncryptionConfig ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig(AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbTableEncryptionConfig value)
    {
      value.Validate();
      string var_sortKeyName = value.IsSetSortKeyName() ? value.SortKeyName : (string)null;
      AWS.Cryptography.DbEncryptionSDK.DynamoDb.SearchConfig var_search = value.IsSetSearch() ? value.Search : (AWS.Cryptography.DbEncryptionSDK.DynamoDb.SearchConfig)null;
      System.Collections.Generic.List<string> var_allowedUnsignedAttributes = value.IsSetAllowedUnsignedAttributes() ? value.AllowedUnsignedAttributes : (System.Collections.Generic.List<string>)null;
      string var_allowedUnsignedAttributePrefix = value.IsSetAllowedUnsignedAttributePrefix() ? value.AllowedUnsignedAttributePrefix : (string)null;
      AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId var_algorithmSuiteId = value.IsSetAlgorithmSuiteId() ? value.AlgorithmSuiteId : (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)null;
      AWS.Cryptography.MaterialProviders.IKeyring var_keyring = value.IsSetKeyring() ? value.Keyring : (AWS.Cryptography.MaterialProviders.IKeyring)null;
      AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager var_cmm = value.IsSetCmm() ? value.Cmm : (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)null;
      AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyOverride var_legacyOverride = value.IsSetLegacyOverride() ? value.LegacyOverride : (AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyOverride)null;
      AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride var_plaintextOverride = value.IsSetPlaintextOverride() ? value.PlaintextOverride : (AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride)null;
      AWS.Cryptography.DbEncryptionSDK.DynamoDb.IBucketSelector var_bucketSelector = value.IsSetBucketSelector() ? value.BucketSelector : (AWS.Cryptography.DbEncryptionSDK.DynamoDb.IBucketSelector)null;
      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M16_logicalTableName(value.LogicalTableName), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M16_partitionKeyName(value.PartitionKeyName), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M11_sortKeyName(var_sortKeyName), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M6_search(var_search), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M25_attributeActionsOnEncrypt(value.AttributeActionsOnEncrypt), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M25_allowedUnsignedAttributes(var_allowedUnsignedAttributes), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M30_allowedUnsignedAttributePrefix(var_allowedUnsignedAttributePrefix), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M16_algorithmSuiteId(var_algorithmSuiteId), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M7_keyring(var_keyring), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M3_cmm(var_cmm), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M14_legacyOverride(var_legacyOverride), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M17_plaintextOverride(var_plaintextOverride), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M14_bucketSelector(var_bucketSelector));
    }
    public static AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M16_algorithmSuiteId(Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId> value)
    {
      return value.is_None ? (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M16_algorithmSuiteId(AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId((AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)value));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M30_allowedUnsignedAttributePrefix(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N6_smithy__N3_api__S6_String(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M30_allowedUnsignedAttributePrefix(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N6_smithy__N3_api__S6_String((string)value));
    }
    public static System.Collections.Generic.List<string> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M25_allowedUnsignedAttributes(Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<string>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M25_allowedUnsignedAttributes(System.Collections.Generic.List<string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<char>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList((System.Collections.Generic.List<string>)value));
    }
    public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M25_attributeActionsOnEncrypt(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_AttributeActions(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M25_attributeActionsOnEncrypt(System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_AttributeActions(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.IBucketSelector FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M14_bucketSelector(Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IBucketSelector> value)
    {
      return value.is_None ? (AWS.Cryptography.DbEncryptionSDK.DynamoDb.IBucketSelector)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S23_BucketSelectorReference(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IBucketSelector> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M14_bucketSelector(AWS.Cryptography.DbEncryptionSDK.DynamoDb.IBucketSelector value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IBucketSelector>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IBucketSelector>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S23_BucketSelectorReference((AWS.Cryptography.DbEncryptionSDK.DynamoDb.IBucketSelector)value));
    }
    public static AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M3_cmm(Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager> value)
    {
      return value.is_None ? (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M3_cmm(AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference((AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)value));
    }
    public static AWS.Cryptography.MaterialProviders.IKeyring FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M7_keyring(Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring> value)
    {
      return value.is_None ? (AWS.Cryptography.MaterialProviders.IKeyring)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M7_keyring(AWS.Cryptography.MaterialProviders.IKeyring value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference((AWS.Cryptography.MaterialProviders.IKeyring)value));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyOverride FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M14_legacyOverride(Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILegacyOverride> value)
    {
      return value.is_None ? (AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyOverride)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_LegacyOverride(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILegacyOverride> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M14_legacyOverride(AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyOverride value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILegacyOverride>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILegacyOverride>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_LegacyOverride((AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyOverride)value));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M16_logicalTableName(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M16_logicalTableName(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M16_partitionKeyName(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M16_partitionKeyName(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M17_plaintextOverride(Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IPlaintextOverride> value)
    {
      return value.is_None ? (AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S17_PlaintextOverride(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IPlaintextOverride> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M17_plaintextOverride(AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IPlaintextOverride>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IPlaintextOverride>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S17_PlaintextOverride((AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride)value));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.SearchConfig FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M6_search(Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISearchConfig> value)
    {
      return value.is_None ? (AWS.Cryptography.DbEncryptionSDK.DynamoDb.SearchConfig)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_SearchConfig(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISearchConfig> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M6_search(AWS.Cryptography.DbEncryptionSDK.DynamoDb.SearchConfig value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISearchConfig>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISearchConfig>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_SearchConfig((AWS.Cryptography.DbEncryptionSDK.DynamoDb.SearchConfig)value));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M11_sortKeyName(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig__M11_sortKeyName(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName((string)value));
    }
    public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbTableEncryptionConfig> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S33_DynamoDbTableEncryptionConfigList(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IDynamoDbTableEncryptionConfig> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S33_DynamoDbTableEncryptionConfigList__M3_key(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S33_DynamoDbTableEncryptionConfigList__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IDynamoDbTableEncryptionConfig> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S33_DynamoDbTableEncryptionConfigList(System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbTableEncryptionConfig> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IDynamoDbTableEncryptionConfig>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IDynamoDbTableEncryptionConfig>(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S33_DynamoDbTableEncryptionConfigList__M3_key(pair.Key), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S33_DynamoDbTableEncryptionConfigList__M5_value(pair.Value))
     ));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S33_DynamoDbTableEncryptionConfigList__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S33_DynamoDbTableEncryptionConfigList__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbTableEncryptionConfig FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S33_DynamoDbTableEncryptionConfigList__M5_value(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IDynamoDbTableEncryptionConfig value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IDynamoDbTableEncryptionConfig ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S33_DynamoDbTableEncryptionConfigList__M5_value(AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbTableEncryptionConfig value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_DynamoDbTableEncryptionConfig(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbTablesEncryptionConfig FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_DynamoDbTablesEncryptionConfig(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IDynamoDbTablesEncryptionConfig value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTablesEncryptionConfig concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTablesEncryptionConfig)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbTablesEncryptionConfig converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbTablesEncryptionConfig(); converted.TableEncryptionConfigs = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbTableEncryptionConfig>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_DynamoDbTablesEncryptionConfig__M22_tableEncryptionConfigs(concrete._tableEncryptionConfigs); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IDynamoDbTablesEncryptionConfig ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_DynamoDbTablesEncryptionConfig(AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbTablesEncryptionConfig value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTablesEncryptionConfig(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_DynamoDbTablesEncryptionConfig__M22_tableEncryptionConfigs(value.TableEncryptionConfigs));
    }
    public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbTableEncryptionConfig> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_DynamoDbTablesEncryptionConfig__M22_tableEncryptionConfigs(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IDynamoDbTableEncryptionConfig> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S33_DynamoDbTableEncryptionConfigList(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IDynamoDbTableEncryptionConfig> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_DynamoDbTablesEncryptionConfig__M22_tableEncryptionConfigs(System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbTableEncryptionConfig> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S33_DynamoDbTableEncryptionConfigList(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedDataKeyDescription FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_EncryptedDataKeyDescription(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedDataKeyDescription value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedDataKeyDescription converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedDataKeyDescription(); converted.KeyProviderId = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_EncryptedDataKeyDescription__M13_keyProviderId(concrete._keyProviderId);
      if (concrete._keyProviderInfo.is_Some) converted.KeyProviderInfo = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_EncryptedDataKeyDescription__M15_keyProviderInfo(concrete._keyProviderInfo);
      if (concrete._branchKeyId.is_Some) converted.BranchKeyId = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_EncryptedDataKeyDescription__M11_branchKeyId(concrete._branchKeyId);
      if (concrete._branchKeyVersion.is_Some) converted.BranchKeyVersion = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_EncryptedDataKeyDescription__M16_branchKeyVersion(concrete._branchKeyVersion); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedDataKeyDescription ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_EncryptedDataKeyDescription(AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedDataKeyDescription value)
    {
      value.Validate();
      string var_keyProviderInfo = value.IsSetKeyProviderInfo() ? value.KeyProviderInfo : (string)null;
      string var_branchKeyId = value.IsSetBranchKeyId() ? value.BranchKeyId : (string)null;
      string var_branchKeyVersion = value.IsSetBranchKeyVersion() ? value.BranchKeyVersion : (string)null;
      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_EncryptedDataKeyDescription__M13_keyProviderId(value.KeyProviderId), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_EncryptedDataKeyDescription__M15_keyProviderInfo(var_keyProviderInfo), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_EncryptedDataKeyDescription__M11_branchKeyId(var_branchKeyId), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_EncryptedDataKeyDescription__M16_branchKeyVersion(var_branchKeyVersion));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_EncryptedDataKeyDescription__M11_branchKeyId(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N6_smithy__N3_api__S6_String(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_EncryptedDataKeyDescription__M11_branchKeyId(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N6_smithy__N3_api__S6_String((string)value));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_EncryptedDataKeyDescription__M16_branchKeyVersion(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N6_smithy__N3_api__S6_String(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_EncryptedDataKeyDescription__M16_branchKeyVersion(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N6_smithy__N3_api__S6_String((string)value));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_EncryptedDataKeyDescription__M13_keyProviderId(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_EncryptedDataKeyDescription__M13_keyProviderId(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_EncryptedDataKeyDescription__M15_keyProviderInfo(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N6_smithy__N3_api__S6_String(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_EncryptedDataKeyDescription__M15_keyProviderInfo(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N6_smithy__N3_api__S6_String((string)value));
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedDataKeyDescription> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S31_EncryptedDataKeyDescriptionList(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedDataKeyDescription> value)
    {
      return new System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedDataKeyDescription>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S31_EncryptedDataKeyDescriptionList__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedDataKeyDescription> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S31_EncryptedDataKeyDescriptionList(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedDataKeyDescription> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedDataKeyDescription>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S31_EncryptedDataKeyDescriptionList__M6_member).ToArray());
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedDataKeyDescription FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S31_EncryptedDataKeyDescriptionList__M6_member(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedDataKeyDescription value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_EncryptedDataKeyDescription(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedDataKeyDescription ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S31_EncryptedDataKeyDescriptionList__M6_member(AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedDataKeyDescription value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_EncryptedDataKeyDescription(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_EncryptedPart(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedPart value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart(); converted.Name = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_EncryptedPart__M4_name(concrete._name);
      converted.Prefix = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_EncryptedPart__M6_prefix(concrete._prefix); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedPart ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_EncryptedPart(AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_EncryptedPart__M4_name(value.Name), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_EncryptedPart__M6_prefix(value.Prefix));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_EncryptedPart__M4_name(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_EncryptedPart__M4_name(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_EncryptedPart__M6_prefix(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Prefix(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_EncryptedPart__M6_prefix(string value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Prefix(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_EncryptedPartsList(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedPart> value)
    {
      return new System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_EncryptedPartsList__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedPart> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_EncryptedPartsList(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedPart>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_EncryptedPartsList__M6_member).ToArray());
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_EncryptedPartsList__M6_member(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedPart value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_EncryptedPart(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedPart ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_EncryptedPartsList__M6_member(AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_EncryptedPart(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBranchKeyIdFromDdbKeyInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_GetBranchKeyIdFromDdbKeyInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetBranchKeyIdFromDdbKeyInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBranchKeyIdFromDdbKeyInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBranchKeyIdFromDdbKeyInput(); converted.DdbKey = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_GetBranchKeyIdFromDdbKeyInput__M6_ddbKey(concrete._ddbKey); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetBranchKeyIdFromDdbKeyInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_GetBranchKeyIdFromDdbKeyInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBranchKeyIdFromDdbKeyInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_GetBranchKeyIdFromDdbKeyInput__M6_ddbKey(value.DdbKey));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_GetBranchKeyIdFromDdbKeyInput__M6_ddbKey(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_GetBranchKeyIdFromDdbKeyInput__M6_ddbKey(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBranchKeyIdFromDdbKeyOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_GetBranchKeyIdFromDdbKeyOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetBranchKeyIdFromDdbKeyOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBranchKeyIdFromDdbKeyOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBranchKeyIdFromDdbKeyOutput(); converted.BranchKeyId = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_GetBranchKeyIdFromDdbKeyOutput__M11_branchKeyId(concrete._branchKeyId); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetBranchKeyIdFromDdbKeyOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_GetBranchKeyIdFromDdbKeyOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBranchKeyIdFromDdbKeyOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_GetBranchKeyIdFromDdbKeyOutput__M11_branchKeyId(value.BranchKeyId));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_GetBranchKeyIdFromDdbKeyOutput__M11_branchKeyId(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_GetBranchKeyIdFromDdbKeyOutput__M11_branchKeyId(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBucketNumberInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S20_GetBucketNumberInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetBucketNumberInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBucketNumberInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBucketNumberInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBucketNumberInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBucketNumberInput(); converted.Item = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S20_GetBucketNumberInput__M4_item(concrete._item);
      converted.NumberOfBuckets = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S20_GetBucketNumberInput__M15_numberOfBuckets(concrete._numberOfBuckets); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetBucketNumberInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S20_GetBucketNumberInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBucketNumberInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBucketNumberInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S20_GetBucketNumberInput__M4_item(value.Item), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S20_GetBucketNumberInput__M15_numberOfBuckets(value.NumberOfBuckets));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S20_GetBucketNumberInput__M4_item(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S20_GetBucketNumberInput__M4_item(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    public static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S20_GetBucketNumberInput__M15_numberOfBuckets(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BucketCount(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S20_GetBucketNumberInput__M15_numberOfBuckets(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BucketCount(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBucketNumberOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S21_GetBucketNumberOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetBucketNumberOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBucketNumberOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBucketNumberOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBucketNumberOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBucketNumberOutput(); converted.BucketNumber = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S21_GetBucketNumberOutput__M12_bucketNumber(concrete._bucketNumber); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetBucketNumberOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S21_GetBucketNumberOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBucketNumberOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBucketNumberOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S21_GetBucketNumberOutput__M12_bucketNumber(value.BucketNumber));
    }
    public static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S21_GetBucketNumberOutput__M12_bucketNumber(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_BucketNumber(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S21_GetBucketNumberOutput__M12_bucketNumber(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_BucketNumber(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetEncryptedDataKeyDescriptionInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S35_GetEncryptedDataKeyDescriptionInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetEncryptedDataKeyDescriptionInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetEncryptedDataKeyDescriptionInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetEncryptedDataKeyDescriptionInput(); converted.Input = (AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetEncryptedDataKeyDescriptionUnion)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S35_GetEncryptedDataKeyDescriptionInput__M5_input(concrete._input); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetEncryptedDataKeyDescriptionInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S35_GetEncryptedDataKeyDescriptionInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetEncryptedDataKeyDescriptionInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S35_GetEncryptedDataKeyDescriptionInput__M5_input(value.Input));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetEncryptedDataKeyDescriptionUnion FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S35_GetEncryptedDataKeyDescriptionInput__M5_input(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetEncryptedDataKeyDescriptionUnion value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S35_GetEncryptedDataKeyDescriptionUnion(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetEncryptedDataKeyDescriptionUnion ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S35_GetEncryptedDataKeyDescriptionInput__M5_input(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetEncryptedDataKeyDescriptionUnion value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S35_GetEncryptedDataKeyDescriptionUnion(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetEncryptedDataKeyDescriptionOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S36_GetEncryptedDataKeyDescriptionOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetEncryptedDataKeyDescriptionOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetEncryptedDataKeyDescriptionOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetEncryptedDataKeyDescriptionOutput(); converted.EncryptedDataKeyDescriptionOutput = (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedDataKeyDescription>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S36_GetEncryptedDataKeyDescriptionOutput__M33_EncryptedDataKeyDescriptionOutput(concrete._EncryptedDataKeyDescriptionOutput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetEncryptedDataKeyDescriptionOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S36_GetEncryptedDataKeyDescriptionOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetEncryptedDataKeyDescriptionOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S36_GetEncryptedDataKeyDescriptionOutput__M33_EncryptedDataKeyDescriptionOutput(value.EncryptedDataKeyDescriptionOutput));
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedDataKeyDescription> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S36_GetEncryptedDataKeyDescriptionOutput__M33_EncryptedDataKeyDescriptionOutput(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedDataKeyDescription> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S31_EncryptedDataKeyDescriptionList(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IEncryptedDataKeyDescription> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S36_GetEncryptedDataKeyDescriptionOutput__M33_EncryptedDataKeyDescriptionOutput(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedDataKeyDescription> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S31_EncryptedDataKeyDescriptionList(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetEncryptedDataKeyDescriptionUnion FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S35_GetEncryptedDataKeyDescriptionUnion(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetEncryptedDataKeyDescriptionUnion value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionUnion concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionUnion)value;
      var converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetEncryptedDataKeyDescriptionUnion(); if (value.is_header)
      {
        converted.Header = FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S35_GetEncryptedDataKeyDescriptionUnion__M6_header(concrete.dtor_header);
        return converted;
      }
      if (value.is_item)
      {
        converted.Item = FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S35_GetEncryptedDataKeyDescriptionUnion__M4_item(concrete.dtor_item);
        return converted;
      }
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetEncryptedDataKeyDescriptionUnion state");
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetEncryptedDataKeyDescriptionUnion ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S35_GetEncryptedDataKeyDescriptionUnion(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetEncryptedDataKeyDescriptionUnion value)
    {
      value.Validate(); if (value.IsSetHeader())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionUnion.create_header(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S35_GetEncryptedDataKeyDescriptionUnion__M6_header(value.Header));
      }
      if (value.IsSetItem())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionUnion.create_item(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S35_GetEncryptedDataKeyDescriptionUnion__M4_item(value.Item));
      }
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetEncryptedDataKeyDescriptionUnion state");
    }
    public static System.IO.MemoryStream FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S35_GetEncryptedDataKeyDescriptionUnion__M6_header(Dafny.ISequence<byte> value)
    {
      return FromDafny_N6_smithy__N3_api__S4_Blob(value);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S35_GetEncryptedDataKeyDescriptionUnion__M6_header(System.IO.MemoryStream value)
    {
      return ToDafny_N6_smithy__N3_api__S4_Blob(value);
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S35_GetEncryptedDataKeyDescriptionUnion__M4_item(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S35_GetEncryptedDataKeyDescriptionUnion__M4_item(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetPrefix FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetPrefix(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetPrefix value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetPrefix concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetPrefix)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetPrefix converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetPrefix(); converted.Length = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetPrefix__M6_length(concrete._length); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetPrefix ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetPrefix(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetPrefix value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetPrefix(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetPrefix__M6_length(value.Length));
    }
    public static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetPrefix__M6_length(int value)
    {
      return FromDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetPrefix__M6_length(int value)
    {
      return ToDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegment FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSegment value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegment converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegment(); converted.Split = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment__M5_split(concrete._split);
      converted.Index = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment__M5_index(concrete._index); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSegment ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegment value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment__M5_split(value.Split), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment__M5_index(value.Index));
    }
    public static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment__M5_index(int value)
    {
      return FromDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment__M5_index(int value)
    {
      return ToDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment__M5_split(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S4_Char(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment__M5_split(string value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S4_Char(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegments FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSegments value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegments concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegments)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegments converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegments(); converted.Split = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M5_split(concrete._split);
      converted.Low = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M3_low(concrete._low);
      converted.High = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M4_high(concrete._high); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSegments ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegments value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegments(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M5_split(value.Split), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M3_low(value.Low), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M4_high(value.High));
    }
    public static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M4_high(int value)
    {
      return FromDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M4_high(int value)
    {
      return ToDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    public static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M3_low(int value)
    {
      return FromDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M3_low(int value)
    {
      return ToDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M5_split(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S4_Char(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M5_split(string value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S4_Char(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSubstring FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSubstring value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSubstring concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSubstring)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSubstring converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSubstring(); converted.Low = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring__M3_low(concrete._low);
      converted.High = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring__M4_high(concrete._high); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSubstring ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSubstring value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSubstring(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring__M3_low(value.Low), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring__M4_high(value.High));
    }
    public static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring__M4_high(int value)
    {
      return FromDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring__M4_high(int value)
    {
      return ToDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    public static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring__M3_low(int value)
    {
      return FromDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring__M3_low(int value)
    {
      return ToDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSuffix FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetSuffix(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSuffix value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSuffix concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSuffix)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSuffix converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSuffix(); converted.Length = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetSuffix__M6_length(concrete._length); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSuffix ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetSuffix(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSuffix value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSuffix(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetSuffix__M6_length(value.Length));
    }
    public static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetSuffix__M6_length(int value)
    {
      return FromDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetSuffix__M6_length(int value)
    {
      return ToDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Insert FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Insert(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IInsert value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Insert concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Insert)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Insert converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Insert(); converted.Literal = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Insert__M7_literal(concrete._literal); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IInsert ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Insert(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Insert value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Insert(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Insert__M7_literal(value.Literal));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Insert__M7_literal(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Insert__M7_literal(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static AWS.Cryptography.KeyStore.KeyStore FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S17_KeyStoreReference(software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient value)
    {
      if (value is software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient dafnyValue)
      {
        return new AWS.Cryptography.KeyStore.KeyStore(dafnyValue);
      }
      throw new System.ArgumentException("Custom implementations of AWS.Cryptography.KeyStore.KeyStore are not supported yet");
    }
    public static software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S17_KeyStoreReference(AWS.Cryptography.KeyStore.KeyStore value)
    {
      if (value is AWS.Cryptography.KeyStore.KeyStore nativeValue)
      {
        return nativeValue.impl();
      }
      throw new System.ArgumentException("Custom implementations of AWS.Cryptography.KeyStore.KeyStore are not supported yet");
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.ILegacyDynamoDbEncryptor FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S32_LegacyDynamoDbEncryptorReference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ILegacyDynamoDbEncryptor value)
    {
      if (value is NativeWrapper_LegacyDynamoDbEncryptor nativeWrapper) return nativeWrapper._impl;
      return new LegacyDynamoDbEncryptor(value);

    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ILegacyDynamoDbEncryptor ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S32_LegacyDynamoDbEncryptorReference(AWS.Cryptography.DbEncryptionSDK.DynamoDb.ILegacyDynamoDbEncryptor value)
    {
      switch (value)
      {
        case LegacyDynamoDbEncryptor valueWithImpl:
          return valueWithImpl._impl;
        case LegacyDynamoDbEncryptorBase nativeImpl:
          return new NativeWrapper_LegacyDynamoDbEncryptor(nativeImpl);
        default:
          throw new System.ArgumentException(
              "Custom implementations of LegacyDynamoDbEncryptor must extend LegacyDynamoDbEncryptorBase.");
      }
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyOverride FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_LegacyOverride(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILegacyOverride value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyOverride concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyOverride)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyOverride converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyOverride(); converted.Policy = (AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_LegacyOverride__M6_policy(concrete._policy);
      converted.Encryptor = (AWS.Cryptography.DbEncryptionSDK.DynamoDb.ILegacyDynamoDbEncryptor)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_LegacyOverride__M9_encryptor(concrete._encryptor);
      converted.AttributeActionsOnEncrypt = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_LegacyOverride__M25_attributeActionsOnEncrypt(concrete._attributeActionsOnEncrypt);
      if (concrete._defaultAttributeFlag.is_Some) converted.DefaultAttributeFlag = (AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_LegacyOverride__M20_defaultAttributeFlag(concrete._defaultAttributeFlag); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILegacyOverride ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_LegacyOverride(AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyOverride value)
    {
      value.Validate();
      AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction var_defaultAttributeFlag = value.IsSetDefaultAttributeFlag() ? value.DefaultAttributeFlag : (AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction)null;
      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyOverride(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_LegacyOverride__M6_policy(value.Policy), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_LegacyOverride__M9_encryptor(value.Encryptor), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_LegacyOverride__M25_attributeActionsOnEncrypt(value.AttributeActionsOnEncrypt), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_LegacyOverride__M20_defaultAttributeFlag(var_defaultAttributeFlag));
    }
    public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_LegacyOverride__M25_attributeActionsOnEncrypt(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_AttributeActions(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_LegacyOverride__M25_attributeActionsOnEncrypt(System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_AttributeActions(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_LegacyOverride__M20_defaultAttributeFlag(Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction> value)
    {
      return value.is_None ? (AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_CryptoAction(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_LegacyOverride__M20_defaultAttributeFlag(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_CryptoAction((AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction)value));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.ILegacyDynamoDbEncryptor FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_LegacyOverride__M9_encryptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ILegacyDynamoDbEncryptor value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S32_LegacyDynamoDbEncryptorReference(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ILegacyDynamoDbEncryptor ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_LegacyOverride__M9_encryptor(AWS.Cryptography.DbEncryptionSDK.DynamoDb.ILegacyDynamoDbEncryptor value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S32_LegacyDynamoDbEncryptorReference(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_LegacyOverride__M6_policy(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILegacyPolicy value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_LegacyPolicy(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILegacyPolicy ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_LegacyOverride__M6_policy(AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_LegacyPolicy(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_LegacyPolicy(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILegacyPolicy value)
    {
      if (value.is_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT) return AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT;
      if (value.is_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT) return AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy.FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT;
      if (value.is_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT) return AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy.FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT;
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy value");
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILegacyPolicy ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_LegacyPolicy(AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy value)
    {
      if (AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT.Equals(value)) return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyPolicy.create_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT();
      if (AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy.FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT.Equals(value)) return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyPolicy.create_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT();
      if (AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy.FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT.Equals(value)) return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyPolicy.create_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT();
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy value");
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Lower FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_Lower(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILower value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Lower concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Lower)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Lower converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Lower(); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILower ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_Lower(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Lower value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Lower();
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.MultiKeyStore FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IMultiKeyStore value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.MultiKeyStore concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.MultiKeyStore)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.MultiKeyStore converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.MultiKeyStore(); converted.KeyFieldName = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M12_keyFieldName(concrete._keyFieldName);
      converted.CacheTTL = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M8_cacheTTL(concrete._cacheTTL);
      if (concrete._cache.is_Some) converted.Cache = (AWS.Cryptography.MaterialProviders.CacheType)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M5_cache(concrete._cache);
      if (concrete._partitionId.is_Some) converted.PartitionId = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M11_partitionId(concrete._partitionId); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IMultiKeyStore ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore(AWS.Cryptography.DbEncryptionSDK.DynamoDb.MultiKeyStore value)
    {
      value.Validate();
      AWS.Cryptography.MaterialProviders.CacheType var_cache = value.IsSetCache() ? value.Cache : (AWS.Cryptography.MaterialProviders.CacheType)null;
      string var_partitionId = value.IsSetPartitionId() ? value.PartitionId : (string)null;
      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.MultiKeyStore(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M12_keyFieldName(value.KeyFieldName), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M8_cacheTTL(value.CacheTTL), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M5_cache(var_cache), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M11_partitionId(var_partitionId));
    }
    public static AWS.Cryptography.MaterialProviders.CacheType FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M5_cache(Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types._ICacheType> value)
    {
      return value.is_None ? (AWS.Cryptography.MaterialProviders.CacheType)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types._ICacheType> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M5_cache(AWS.Cryptography.MaterialProviders.CacheType value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types._ICacheType>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types._ICacheType>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType((AWS.Cryptography.MaterialProviders.CacheType)value));
    }
    public static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M8_cacheTTL(int value)
    {
      return FromDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M8_cacheTTL(int value)
    {
      return ToDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M12_keyFieldName(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M12_keyFieldName(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M11_partitionId(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N6_smithy__N3_api__S6_String(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M11_partitionId(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N6_smithy__N3_api__S6_String((string)value));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.PartOnly FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S8_PartOnly(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IPartOnly value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PartOnly concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PartOnly)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.PartOnly converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.PartOnly(); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IPartOnly ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S8_PartOnly(AWS.Cryptography.DbEncryptionSDK.DynamoDb.PartOnly value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PartOnly();
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S17_PlaintextOverride(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IPlaintextOverride value)
    {
      if (value.is_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ) return AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ;
      if (value.is_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ) return AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride.FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ;
      if (value.is_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ) return AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride.FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ;
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride value");
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IPlaintextOverride ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S17_PlaintextOverride(AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride value)
    {
      if (AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ.Equals(value)) return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride.create_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ();
      if (AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride.FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ.Equals(value)) return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride.create_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ();
      if (AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride.FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ.Equals(value)) return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride.create_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ();
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride value");
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Prefix(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Prefix(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.SearchConfig FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_SearchConfig(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISearchConfig value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SearchConfig concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SearchConfig)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.SearchConfig converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.SearchConfig(); converted.Versions = (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconVersion>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_SearchConfig__M8_versions(concrete._versions);
      converted.WriteVersion = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_SearchConfig__M12_writeVersion(concrete._writeVersion); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISearchConfig ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_SearchConfig(AWS.Cryptography.DbEncryptionSDK.DynamoDb.SearchConfig value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SearchConfig(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_SearchConfig__M8_versions(value.Versions), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_SearchConfig__M12_writeVersion(value.WriteVersion));
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconVersion> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_SearchConfig__M8_versions(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconVersion> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S17_BeaconVersionList(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconVersion> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_SearchConfig__M8_versions(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconVersion> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S17_BeaconVersionList(value);
    }
    public static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_SearchConfig__M12_writeVersion(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_VersionNumber(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_SearchConfig__M12_writeVersion(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_VersionNumber(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Shared FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Shared(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IShared value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Shared concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Shared)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Shared converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Shared(); converted.Other = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Shared__M5_other(concrete._other); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IShared ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Shared(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Shared value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Shared(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Shared__M5_other(value.Other));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Shared__M5_other(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Shared__M5_other(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.SharedSet FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_SharedSet(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISharedSet value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SharedSet concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SharedSet)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.SharedSet converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.SharedSet(); converted.Other = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_SharedSet__M5_other(concrete._other); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISharedSet ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_SharedSet(AWS.Cryptography.DbEncryptionSDK.DynamoDb.SharedSet value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SharedSet(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_SharedSet__M5_other(value.Other));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_SharedSet__M5_other(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_SharedSet__M5_other(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_SignedPart(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISignedPart value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart(); converted.Name = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_SignedPart__M4_name(concrete._name);
      converted.Prefix = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_SignedPart__M6_prefix(concrete._prefix);
      if (concrete._loc.is_Some) converted.Loc = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_SignedPart__M3_loc(concrete._loc); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISignedPart ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_SignedPart(AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart value)
    {
      value.Validate();
      string var_loc = value.IsSetLoc() ? value.Loc : (string)null;
      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_SignedPart__M4_name(value.Name), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_SignedPart__M6_prefix(value.Prefix), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_SignedPart__M3_loc(var_loc));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_SignedPart__M3_loc(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_TerminalLocation(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_SignedPart__M3_loc(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_TerminalLocation((string)value));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_SignedPart__M4_name(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_SignedPart__M4_name(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_SignedPart__M6_prefix(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Prefix(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_SignedPart__M6_prefix(string value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Prefix(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_SignedPartsList(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISignedPart> value)
    {
      return new System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_SignedPartsList__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISignedPart> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_SignedPartsList(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISignedPart>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_SignedPartsList__M6_member).ToArray());
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_SignedPartsList__M6_member(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISignedPart value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_SignedPart(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISignedPart ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_SignedPartsList__M6_member(AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_SignedPart(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.SingleKeyStore FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISingleKeyStore value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SingleKeyStore concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SingleKeyStore)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.SingleKeyStore converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.SingleKeyStore(); converted.KeyId = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M5_keyId(concrete._keyId);
      converted.CacheTTL = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M8_cacheTTL(concrete._cacheTTL);
      if (concrete._cache.is_Some) converted.Cache = (AWS.Cryptography.MaterialProviders.CacheType)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M5_cache(concrete._cache);
      if (concrete._partitionId.is_Some) converted.PartitionId = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M11_partitionId(concrete._partitionId); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISingleKeyStore ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore(AWS.Cryptography.DbEncryptionSDK.DynamoDb.SingleKeyStore value)
    {
      value.Validate();
      AWS.Cryptography.MaterialProviders.CacheType var_cache = value.IsSetCache() ? value.Cache : (AWS.Cryptography.MaterialProviders.CacheType)null;
      string var_partitionId = value.IsSetPartitionId() ? value.PartitionId : (string)null;
      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SingleKeyStore(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M5_keyId(value.KeyId), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M8_cacheTTL(value.CacheTTL), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M5_cache(var_cache), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M11_partitionId(var_partitionId));
    }
    public static AWS.Cryptography.MaterialProviders.CacheType FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M5_cache(Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types._ICacheType> value)
    {
      return value.is_None ? (AWS.Cryptography.MaterialProviders.CacheType)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types._ICacheType> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M5_cache(AWS.Cryptography.MaterialProviders.CacheType value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types._ICacheType>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types._ICacheType>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType((AWS.Cryptography.MaterialProviders.CacheType)value));
    }
    public static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M8_cacheTTL(int value)
    {
      return FromDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M8_cacheTTL(int value)
    {
      return ToDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M5_keyId(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M5_keyId(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M11_partitionId(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N6_smithy__N3_api__S6_String(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M11_partitionId(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N6_smithy__N3_api__S6_String((string)value));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.StandardBeacon FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IStandardBeacon value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.StandardBeacon converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.StandardBeacon(); converted.Name = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon__M4_name(concrete._name);
      converted.Length = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon__M6_length(concrete._length);
      if (concrete._loc.is_Some) converted.Loc = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon__M3_loc(concrete._loc);
      if (concrete._style.is_Some) converted.Style = (AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconStyle)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon__M5_style(concrete._style);
      if (concrete._numberOfBuckets.is_Some) converted.NumberOfBuckets = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon__M15_numberOfBuckets(concrete._numberOfBuckets); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IStandardBeacon ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon(AWS.Cryptography.DbEncryptionSDK.DynamoDb.StandardBeacon value)
    {
      value.Validate();
      string var_loc = value.IsSetLoc() ? value.Loc : (string)null;
      AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconStyle var_style = value.IsSetStyle() ? value.Style : (AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconStyle)null;
      int? var_numberOfBuckets = value.IsSetNumberOfBuckets() ? value.NumberOfBuckets : (int?)null;
      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon__M4_name(value.Name), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon__M6_length(value.Length), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon__M3_loc(var_loc), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon__M5_style(var_style), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon__M15_numberOfBuckets(var_numberOfBuckets));
    }
    public static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon__M6_length(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconBitLength(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon__M6_length(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconBitLength(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon__M3_loc(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_TerminalLocation(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon__M3_loc(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_TerminalLocation((string)value));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon__M4_name(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon__M4_name(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static int? FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon__M15_numberOfBuckets(Wrappers_Compile._IOption<int> value)
    {
      return value.is_None ? (int?)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BucketCount(value.Extract());
    }
    public static Wrappers_Compile._IOption<int> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon__M15_numberOfBuckets(int? value)
    {
      return value == null ? Wrappers_Compile.Option<int>.create_None() : Wrappers_Compile.Option<int>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BucketCount((int)value));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconStyle FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon__M5_style(Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconStyle> value)
    {
      return value.is_None ? (AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconStyle)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconStyle> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon__M5_style(AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconStyle value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconStyle>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconStyle>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle((AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconStyle)value));
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.StandardBeacon> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_StandardBeaconList(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IStandardBeacon> value)
    {
      return new System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.StandardBeacon>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_StandardBeaconList__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IStandardBeacon> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_StandardBeaconList(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.StandardBeacon> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IStandardBeacon>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_StandardBeaconList__M6_member).ToArray());
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.StandardBeacon FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_StandardBeaconList__M6_member(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IStandardBeacon value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IStandardBeacon ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S18_StandardBeaconList__M6_member(AWS.Cryptography.DbEncryptionSDK.DynamoDb.StandardBeacon value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_StandardBeacon(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_TerminalLocation(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_TerminalLocation(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Upper FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_Upper(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IUpper value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Upper concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Upper)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Upper converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Upper(); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IUpper ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_Upper(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Upper value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Upper();
    }
    public static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_VersionNumber(int value)
    {
      return value;
    }
    public static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_VersionNumber(int value)
    {
      return value;
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualField FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_VirtualField(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualField value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualField converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualField(); converted.Name = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_VirtualField__M4_name(concrete._name);
      converted.Parts = (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualPart>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_VirtualField__M5_parts(concrete._parts); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualField ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_VirtualField(AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualField value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_VirtualField__M4_name(value.Name), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_VirtualField__M5_parts(value.Parts));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_VirtualField__M4_name(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_VirtualField__M4_name(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualPart> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_VirtualField__M5_parts(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualPart> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_VirtualPartList(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualPart> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_VirtualField__M5_parts(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualPart> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_VirtualPartList(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualField> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualFieldList(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualField> value)
    {
      return new System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualField>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualFieldList__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualField> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualFieldList(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualField> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualField>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualFieldList__M6_member).ToArray());
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualField FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualFieldList__M6_member(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualField value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_VirtualField(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualField ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualFieldList__M6_member(AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualField value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_VirtualField(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualPart FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_VirtualPart(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualPart value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualPart converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualPart(); converted.Loc = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_VirtualPart__M3_loc(concrete._loc);
      if (concrete._trans.is_Some) converted.Trans = (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualTransform>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_VirtualPart__M5_trans(concrete._trans); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualPart ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_VirtualPart(AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualPart value)
    {
      value.Validate();
      System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualTransform> var_trans = value.IsSetTrans() ? value.Trans : (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualTransform>)null;
      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_VirtualPart__M3_loc(value.Loc), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_VirtualPart__M5_trans(var_trans));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_VirtualPart__M3_loc(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_TerminalLocation(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_VirtualPart__M3_loc(string value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_TerminalLocation(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualTransform> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_VirtualPart__M5_trans(Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualTransform>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualTransform>)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S20_VirtualTransformList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualTransform>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_VirtualPart__M5_trans(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualTransform> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualTransform>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualTransform>>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S20_VirtualTransformList((System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualTransform>)value));
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualPart> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_VirtualPartList(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualPart> value)
    {
      return new System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualPart>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_VirtualPartList__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualPart> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_VirtualPartList(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualPart> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualPart>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_VirtualPartList__M6_member).ToArray());
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualPart FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_VirtualPartList__M6_member(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualPart value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_VirtualPart(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualPart ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_VirtualPartList__M6_member(AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualPart value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_VirtualPart(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualTransform FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualTransform value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform)value;
      var converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualTransform(); if (value.is_upper)
      {
        converted.Upper = FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M5_upper(concrete.dtor_upper);
        return converted;
      }
      if (value.is_lower)
      {
        converted.Lower = FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M5_lower(concrete.dtor_lower);
        return converted;
      }
      if (value.is_insert)
      {
        converted.Insert = FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M6_insert(concrete.dtor_insert);
        return converted;
      }
      if (value.is_prefix)
      {
        converted.Prefix = FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M6_prefix(concrete.dtor_prefix);
        return converted;
      }
      if (value.is_suffix)
      {
        converted.Suffix = FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M6_suffix(concrete.dtor_suffix);
        return converted;
      }
      if (value.is_substring)
      {
        converted.Substring = FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M9_substring(concrete.dtor_substring);
        return converted;
      }
      if (value.is_segment)
      {
        converted.Segment = FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M7_segment(concrete.dtor_segment);
        return converted;
      }
      if (value.is_segments)
      {
        converted.Segments = FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M8_segments(concrete.dtor_segments);
        return converted;
      }
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualTransform state");
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualTransform ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualTransform value)
    {
      value.Validate(); if (value.IsSetUpper())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_upper(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M5_upper(value.Upper));
      }
      if (value.IsSetLower())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_lower(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M5_lower(value.Lower));
      }
      if (value.IsSetInsert())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_insert(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M6_insert(value.Insert));
      }
      if (value.IsSetPrefix())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_prefix(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M6_prefix(value.Prefix));
      }
      if (value.IsSetSuffix())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_suffix(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M6_suffix(value.Suffix));
      }
      if (value.IsSetSubstring())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_substring(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M9_substring(value.Substring));
      }
      if (value.IsSetSegment())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_segment(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M7_segment(value.Segment));
      }
      if (value.IsSetSegments())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_segments(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M8_segments(value.Segments));
      }
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualTransform state");
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Insert FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M6_insert(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IInsert value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Insert(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IInsert ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M6_insert(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Insert value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Insert(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Lower FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M5_lower(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILower value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_Lower(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILower ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M5_lower(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Lower value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_Lower(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetPrefix FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M6_prefix(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetPrefix value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetPrefix(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetPrefix ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M6_prefix(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetPrefix value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetPrefix(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegment FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M7_segment(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSegment value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSegment ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M7_segment(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegment value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegments FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M8_segments(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSegments value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSegments ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M8_segments(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegments value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSubstring FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M9_substring(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSubstring value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSubstring ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M9_substring(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSubstring value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSuffix FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M6_suffix(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSuffix value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetSuffix(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSuffix ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M6_suffix(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSuffix value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetSuffix(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Upper FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M5_upper(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IUpper value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_Upper(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IUpper ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M5_upper(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Upper value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_Upper(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualTransform> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S20_VirtualTransformList(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualTransform> value)
    {
      return new System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualTransform>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S20_VirtualTransformList__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualTransform> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S20_VirtualTransformList(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualTransform> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualTransform>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S20_VirtualTransformList__M6_member).ToArray());
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualTransform FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S20_VirtualTransformList__M6_member(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualTransform value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualTransform ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S20_VirtualTransformList__M6_member(AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualTransform value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_CryptoAction(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction value)
    {
      if (value.is_ENCRYPT__AND__SIGN) return AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction.ENCRYPT_AND_SIGN;
      if (value.is_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT) return AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT;
      if (value.is_SIGN__ONLY) return AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction.SIGN_ONLY;
      if (value.is_DO__NOTHING) return AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction.DO_NOTHING;
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction value");
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_CryptoAction(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction value)
    {
      if (AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction.ENCRYPT_AND_SIGN.Equals(value)) return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN();
      if (AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT.Equals(value)) return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT();
      if (AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction.SIGN_ONLY.Equals(value)) return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY();
      if (AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction.DO_NOTHING.Equals(value)) return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_DO__NOTHING();
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction value");
    }
    public static AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference(software.amazon.cryptography.materialproviders.internaldafny.types.IBranchKeyIdSupplier value)
    {
      // This is converting a reference type in a dependant module.
      // Therefore it defers to the dependant module for conversion
      return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference(value);
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types.IBranchKeyIdSupplier ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference(AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier value)
    {
      // This is converting a reference type in a dependant module.
      // Therefore it defers to the dependant module for conversion
      return AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference(value);
    }
    public static AWS.Cryptography.MaterialProviders.CacheType FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType(software.amazon.cryptography.materialproviders.internaldafny.types._ICacheType value)
    {
      software.amazon.cryptography.materialproviders.internaldafny.types.CacheType concrete = (software.amazon.cryptography.materialproviders.internaldafny.types.CacheType)value;
      var converted = new AWS.Cryptography.MaterialProviders.CacheType(); if (value.is_Default)
      {
        converted.Default = FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M7_Default(concrete.dtor_Default);
        return converted;
      }
      if (value.is_No)
      {
        converted.No = FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M2_No(concrete.dtor_No);
        return converted;
      }
      if (value.is_SingleThreaded)
      {
        converted.SingleThreaded = FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M14_SingleThreaded(concrete.dtor_SingleThreaded);
        return converted;
      }
      if (value.is_MultiThreaded)
      {
        converted.MultiThreaded = FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M13_MultiThreaded(concrete.dtor_MultiThreaded);
        return converted;
      }
      if (value.is_StormTracking)
      {
        converted.StormTracking = FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M13_StormTracking(concrete.dtor_StormTracking);
        return converted;
      }
      if (value.is_Shared)
      {
        converted.Shared = FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M6_Shared(concrete.dtor_Shared);
        return converted;
      }
      throw new System.ArgumentException("Invalid AWS.Cryptography.MaterialProviders.CacheType state");
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types._ICacheType ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType(AWS.Cryptography.MaterialProviders.CacheType value)
    {
      value.Validate(); if (value.IsSetDefault())
      {
        return software.amazon.cryptography.materialproviders.internaldafny.types.CacheType.create_Default(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M7_Default(value.Default));
      }
      if (value.IsSetNo())
      {
        return software.amazon.cryptography.materialproviders.internaldafny.types.CacheType.create_No(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M2_No(value.No));
      }
      if (value.IsSetSingleThreaded())
      {
        return software.amazon.cryptography.materialproviders.internaldafny.types.CacheType.create_SingleThreaded(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M14_SingleThreaded(value.SingleThreaded));
      }
      if (value.IsSetMultiThreaded())
      {
        return software.amazon.cryptography.materialproviders.internaldafny.types.CacheType.create_MultiThreaded(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M13_MultiThreaded(value.MultiThreaded));
      }
      if (value.IsSetStormTracking())
      {
        return software.amazon.cryptography.materialproviders.internaldafny.types.CacheType.create_StormTracking(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M13_StormTracking(value.StormTracking));
      }
      if (value.IsSetShared())
      {
        return software.amazon.cryptography.materialproviders.internaldafny.types.CacheType.create_Shared(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M6_Shared(value.Shared));
      }
      throw new System.ArgumentException("Invalid AWS.Cryptography.MaterialProviders.CacheType state");
    }
    public static AWS.Cryptography.MaterialProviders.DefaultCache FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M7_Default(software.amazon.cryptography.materialproviders.internaldafny.types._IDefaultCache value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S12_DefaultCache(value);
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types._IDefaultCache ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M7_Default(AWS.Cryptography.MaterialProviders.DefaultCache value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S12_DefaultCache(value);
    }
    public static AWS.Cryptography.MaterialProviders.MultiThreadedCache FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M13_MultiThreaded(software.amazon.cryptography.materialproviders.internaldafny.types._IMultiThreadedCache value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache(value);
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types._IMultiThreadedCache ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M13_MultiThreaded(AWS.Cryptography.MaterialProviders.MultiThreadedCache value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache(value);
    }
    public static AWS.Cryptography.MaterialProviders.NoCache FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M2_No(software.amazon.cryptography.materialproviders.internaldafny.types._INoCache value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S7_NoCache(value);
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types._INoCache ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M2_No(AWS.Cryptography.MaterialProviders.NoCache value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S7_NoCache(value);
    }
    public static AWS.Cryptography.MaterialProviders.ICryptographicMaterialsCache FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M6_Shared(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S36_CryptographicMaterialsCacheReference(value);
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M6_Shared(AWS.Cryptography.MaterialProviders.ICryptographicMaterialsCache value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S36_CryptographicMaterialsCacheReference(value);
    }
    public static AWS.Cryptography.MaterialProviders.SingleThreadedCache FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M14_SingleThreaded(software.amazon.cryptography.materialproviders.internaldafny.types._ISingleThreadedCache value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache(value);
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types._ISingleThreadedCache ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M14_SingleThreaded(AWS.Cryptography.MaterialProviders.SingleThreadedCache value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache(value);
    }
    public static AWS.Cryptography.MaterialProviders.StormTrackingCache FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M13_StormTracking(software.amazon.cryptography.materialproviders.internaldafny.types._IStormTrackingCache value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache(value);
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types._IStormTrackingCache ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M13_StormTracking(AWS.Cryptography.MaterialProviders.StormTrackingCache value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache(value);
    }
    public static int FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(int value)
    {
      return value;
    }
    public static int ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(int value)
    {
      return value;
    }
    public static AWS.Cryptography.MaterialProviders.ICryptographicMaterialsCache FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S36_CryptographicMaterialsCacheReference(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache value)
    {
      // This is converting a reference type in a dependant module.
      // Therefore it defers to the dependant module for conversion
      return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S36_CryptographicMaterialsCacheReference(value);
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S36_CryptographicMaterialsCacheReference(AWS.Cryptography.MaterialProviders.ICryptographicMaterialsCache value)
    {
      // This is converting a reference type in a dependant module.
      // Therefore it defers to the dependant module for conversion
      return AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S36_CryptographicMaterialsCacheReference(value);
    }
    public static AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager value)
    {
      // This is converting a reference type in a dependant module.
      // Therefore it defers to the dependant module for conversion
      return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value);
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager value)
    {
      // This is converting a reference type in a dependant module.
      // Therefore it defers to the dependant module for conversion
      return AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value);
    }
    public static AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId value)
    {
      if (value.is_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__SYMSIG__HMAC__SHA384) return AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384;
      if (value.is_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384) return AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384;
      throw new System.ArgumentException("Invalid AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId value");
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId value)
    {
      if (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384.Equals(value)) return software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId.create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__SYMSIG__HMAC__SHA384();
      if (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384.Equals(value)) return software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId.create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384();
      throw new System.ArgumentException("Invalid AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId value");
    }
    public static AWS.Cryptography.MaterialProviders.DefaultCache FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S12_DefaultCache(software.amazon.cryptography.materialproviders.internaldafny.types._IDefaultCache value)
    {
      software.amazon.cryptography.materialproviders.internaldafny.types.DefaultCache concrete = (software.amazon.cryptography.materialproviders.internaldafny.types.DefaultCache)value; AWS.Cryptography.MaterialProviders.DefaultCache converted = new AWS.Cryptography.MaterialProviders.DefaultCache(); converted.EntryCapacity = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S12_DefaultCache__M13_entryCapacity(concrete._entryCapacity); return converted;
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types._IDefaultCache ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S12_DefaultCache(AWS.Cryptography.MaterialProviders.DefaultCache value)
    {
      value.Validate();

      return new software.amazon.cryptography.materialproviders.internaldafny.types.DefaultCache(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S12_DefaultCache__M13_entryCapacity(value.EntryCapacity));
    }
    public static int FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S12_DefaultCache__M13_entryCapacity(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S12_DefaultCache__M13_entryCapacity(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    public static AWS.Cryptography.MaterialProviders.IKeyring FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference(software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring value)
    {
      // This is converting a reference type in a dependant module.
      // Therefore it defers to the dependant module for conversion
      return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference(value);
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference(AWS.Cryptography.MaterialProviders.IKeyring value)
    {
      // This is converting a reference type in a dependant module.
      // Therefore it defers to the dependant module for conversion
      return AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference(value);
    }
    public static AWS.Cryptography.MaterialProviders.MultiThreadedCache FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache(software.amazon.cryptography.materialproviders.internaldafny.types._IMultiThreadedCache value)
    {
      software.amazon.cryptography.materialproviders.internaldafny.types.MultiThreadedCache concrete = (software.amazon.cryptography.materialproviders.internaldafny.types.MultiThreadedCache)value; AWS.Cryptography.MaterialProviders.MultiThreadedCache converted = new AWS.Cryptography.MaterialProviders.MultiThreadedCache(); converted.EntryCapacity = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache__M13_entryCapacity(concrete._entryCapacity);
      if (concrete._entryPruningTailSize.is_Some) converted.EntryPruningTailSize = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache__M20_entryPruningTailSize(concrete._entryPruningTailSize); return converted;
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types._IMultiThreadedCache ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache(AWS.Cryptography.MaterialProviders.MultiThreadedCache value)
    {
      value.Validate();
      int? var_entryPruningTailSize = value.IsSetEntryPruningTailSize() ? value.EntryPruningTailSize : (int?)null;
      return new software.amazon.cryptography.materialproviders.internaldafny.types.MultiThreadedCache(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache__M13_entryCapacity(value.EntryCapacity), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache__M20_entryPruningTailSize(var_entryPruningTailSize));
    }
    public static int FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache__M13_entryCapacity(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache__M13_entryCapacity(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    public static int? FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache__M20_entryPruningTailSize(Wrappers_Compile._IOption<int> value)
    {
      return value.is_None ? (int?)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value.Extract());
    }
    public static Wrappers_Compile._IOption<int> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache__M20_entryPruningTailSize(int? value)
    {
      return value == null ? Wrappers_Compile.Option<int>.create_None() : Wrappers_Compile.Option<int>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber((int)value));
    }
    public static AWS.Cryptography.MaterialProviders.NoCache FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S7_NoCache(software.amazon.cryptography.materialproviders.internaldafny.types._INoCache value)
    {
      software.amazon.cryptography.materialproviders.internaldafny.types.NoCache concrete = (software.amazon.cryptography.materialproviders.internaldafny.types.NoCache)value; AWS.Cryptography.MaterialProviders.NoCache converted = new AWS.Cryptography.MaterialProviders.NoCache(); return converted;
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types._INoCache ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S7_NoCache(AWS.Cryptography.MaterialProviders.NoCache value)
    {
      value.Validate();

      return new software.amazon.cryptography.materialproviders.internaldafny.types.NoCache();
    }
    public static AWS.Cryptography.MaterialProviders.SingleThreadedCache FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache(software.amazon.cryptography.materialproviders.internaldafny.types._ISingleThreadedCache value)
    {
      software.amazon.cryptography.materialproviders.internaldafny.types.SingleThreadedCache concrete = (software.amazon.cryptography.materialproviders.internaldafny.types.SingleThreadedCache)value; AWS.Cryptography.MaterialProviders.SingleThreadedCache converted = new AWS.Cryptography.MaterialProviders.SingleThreadedCache(); converted.EntryCapacity = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache__M13_entryCapacity(concrete._entryCapacity);
      if (concrete._entryPruningTailSize.is_Some) converted.EntryPruningTailSize = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache__M20_entryPruningTailSize(concrete._entryPruningTailSize); return converted;
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types._ISingleThreadedCache ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache(AWS.Cryptography.MaterialProviders.SingleThreadedCache value)
    {
      value.Validate();
      int? var_entryPruningTailSize = value.IsSetEntryPruningTailSize() ? value.EntryPruningTailSize : (int?)null;
      return new software.amazon.cryptography.materialproviders.internaldafny.types.SingleThreadedCache(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache__M13_entryCapacity(value.EntryCapacity), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache__M20_entryPruningTailSize(var_entryPruningTailSize));
    }
    public static int FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache__M13_entryCapacity(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache__M13_entryCapacity(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    public static int? FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache__M20_entryPruningTailSize(Wrappers_Compile._IOption<int> value)
    {
      return value.is_None ? (int?)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value.Extract());
    }
    public static Wrappers_Compile._IOption<int> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache__M20_entryPruningTailSize(int? value)
    {
      return value == null ? Wrappers_Compile.Option<int>.create_None() : Wrappers_Compile.Option<int>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber((int)value));
    }
    public static AWS.Cryptography.MaterialProviders.StormTrackingCache FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache(software.amazon.cryptography.materialproviders.internaldafny.types._IStormTrackingCache value)
    {
      software.amazon.cryptography.materialproviders.internaldafny.types.StormTrackingCache concrete = (software.amazon.cryptography.materialproviders.internaldafny.types.StormTrackingCache)value; AWS.Cryptography.MaterialProviders.StormTrackingCache converted = new AWS.Cryptography.MaterialProviders.StormTrackingCache(); converted.EntryCapacity = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M13_entryCapacity(concrete._entryCapacity);
      if (concrete._entryPruningTailSize.is_Some) converted.EntryPruningTailSize = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M20_entryPruningTailSize(concrete._entryPruningTailSize);
      converted.GracePeriod = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M11_gracePeriod(concrete._gracePeriod);
      converted.GraceInterval = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M13_graceInterval(concrete._graceInterval);
      converted.FanOut = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M6_fanOut(concrete._fanOut);
      converted.InFlightTTL = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M11_inFlightTTL(concrete._inFlightTTL);
      converted.SleepMilli = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M10_sleepMilli(concrete._sleepMilli);
      if (concrete._timeUnits.is_Some) converted.TimeUnits = (AWS.Cryptography.MaterialProviders.TimeUnits)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M9_timeUnits(concrete._timeUnits); return converted;
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types._IStormTrackingCache ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache(AWS.Cryptography.MaterialProviders.StormTrackingCache value)
    {
      value.Validate();
      int? var_entryPruningTailSize = value.IsSetEntryPruningTailSize() ? value.EntryPruningTailSize : (int?)null;
      AWS.Cryptography.MaterialProviders.TimeUnits var_timeUnits = value.IsSetTimeUnits() ? value.TimeUnits : (AWS.Cryptography.MaterialProviders.TimeUnits)null;
      return new software.amazon.cryptography.materialproviders.internaldafny.types.StormTrackingCache(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M13_entryCapacity(value.EntryCapacity), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M20_entryPruningTailSize(var_entryPruningTailSize), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M11_gracePeriod(value.GracePeriod), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M13_graceInterval(value.GraceInterval), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M6_fanOut(value.FanOut), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M11_inFlightTTL(value.InFlightTTL), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M10_sleepMilli(value.SleepMilli), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M9_timeUnits(var_timeUnits));
    }
    public static int FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M13_entryCapacity(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M13_entryCapacity(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    public static int? FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M20_entryPruningTailSize(Wrappers_Compile._IOption<int> value)
    {
      return value.is_None ? (int?)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value.Extract());
    }
    public static Wrappers_Compile._IOption<int> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M20_entryPruningTailSize(int? value)
    {
      return value == null ? Wrappers_Compile.Option<int>.create_None() : Wrappers_Compile.Option<int>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber((int)value));
    }
    public static int FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M6_fanOut(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M6_fanOut(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    public static int FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M13_graceInterval(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M13_graceInterval(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    public static int FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M11_gracePeriod(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M11_gracePeriod(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    public static int FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M11_inFlightTTL(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M11_inFlightTTL(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    public static int FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M10_sleepMilli(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    public static int ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M10_sleepMilli(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    public static AWS.Cryptography.MaterialProviders.TimeUnits FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M9_timeUnits(Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types._ITimeUnits> value)
    {
      return value.is_None ? (AWS.Cryptography.MaterialProviders.TimeUnits)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_TimeUnits(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types._ITimeUnits> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M9_timeUnits(AWS.Cryptography.MaterialProviders.TimeUnits value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types._ITimeUnits>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types._ITimeUnits>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_TimeUnits((AWS.Cryptography.MaterialProviders.TimeUnits)value));
    }
    public static AWS.Cryptography.MaterialProviders.TimeUnits FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_TimeUnits(software.amazon.cryptography.materialproviders.internaldafny.types._ITimeUnits value)
    {
      if (value.is_Seconds) return AWS.Cryptography.MaterialProviders.TimeUnits.Seconds;
      if (value.is_Milliseconds) return AWS.Cryptography.MaterialProviders.TimeUnits.Milliseconds;
      throw new System.ArgumentException("Invalid AWS.Cryptography.MaterialProviders.TimeUnits value");
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types._ITimeUnits ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_TimeUnits(AWS.Cryptography.MaterialProviders.TimeUnits value)
    {
      if (AWS.Cryptography.MaterialProviders.TimeUnits.Seconds.Equals(value)) return software.amazon.cryptography.materialproviders.internaldafny.types.TimeUnits.create_Seconds();
      if (AWS.Cryptography.MaterialProviders.TimeUnits.Milliseconds.Equals(value)) return software.amazon.cryptography.materialproviders.internaldafny.types.TimeUnits.create_Milliseconds();
      throw new System.ArgumentException("Invalid AWS.Cryptography.MaterialProviders.TimeUnits value");
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M5_value(pair.Value))
     ));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M5_value(software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M5_value(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList(Dafny.ISequence<Dafny.ISequence<char>> value)
    {
      return new System.Collections.Generic.List<string>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList__M6_member));
    }
    public static Dafny.ISequence<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList(System.Collections.Generic.List<string> value)
    {
      return Dafny.Sequence<Dafny.ISequence<char>>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList__M6_member).ToArray());
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList__M6_member(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList__M6_member(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)value;
      var converted = new Amazon.DynamoDBv2.Model.AttributeValue(); if (value.is_S)
      {
        converted.S = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_S(concrete.dtor_S);
        return converted;
      }
      if (value.is_N)
      {
        converted.N = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_N(concrete.dtor_N);
        return converted;
      }
      if (value.is_B)
      {
        converted.B = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_B(concrete.dtor_B);
        return converted;
      }
      if (value.is_SS)
      {
        converted.SS = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_SS(concrete.dtor_SS);
        return converted;
      }
      if (value.is_NS)
      {
        converted.NS = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_NS(concrete.dtor_NS);
        return converted;
      }
      if (value.is_BS)
      {
        converted.BS = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_BS(concrete.dtor_BS);
        return converted;
      }
      if (value.is_M)
      {
        converted.M = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_M(concrete.dtor_M);
        return converted;
      }
      if (value.is_L)
      {
        converted.L = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_L(concrete.dtor_L);
        return converted;
      }
      if (value.is_NULL)
      {
        converted.NULL = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_NULL(concrete.dtor_NULL);
        return converted;
      }
      if (value.is_BOOL)
      {
        converted.BOOL = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_BOOL(concrete.dtor_BOOL);
        return converted;
      }
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.Model.AttributeValue state");
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      if (value.S != null)
      {
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_S(value.S));
      }
      if (value.N != null)
      {
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_N(value.N));
      }
      if (value.B != null)
      {
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_B(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_B(value.B));
      }
      if (value.SS.Any())
      {
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_SS(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_SS(value.SS));
      }
      if (value.NS.Any())
      {
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NS(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_NS(value.NS));
      }
      if (value.BS.Any())
      {
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BS(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_BS(value.BS));
      }
      if (value.IsMSet)
      {
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_M(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_M(value.M));
      }
      if (value.IsLSet)
      {
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_L(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_L(value.L));
      }
      if (value.NULL == true)
      {
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NULL(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_NULL(value.NULL));
      }
      if (value.IsBOOLSet)
      {
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BOOL(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_BOOL(value.BOOL));
      }
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.Model.AttributeValue state");
    }
    public static System.IO.MemoryStream FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_B(Dafny.ISequence<byte> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue(value);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_B(System.IO.MemoryStream value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue(value);
    }
    public static bool FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_BOOL(bool value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BooleanAttributeValue(value);
    }
    public static bool ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_BOOL(bool value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BooleanAttributeValue(value);
    }
    public static System.Collections.Generic.List<System.IO.MemoryStream> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_BS(Dafny.ISequence<Dafny.ISequence<byte>> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue(value);
    }
    public static Dafny.ISequence<Dafny.ISequence<byte>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_BS(System.Collections.Generic.List<System.IO.MemoryStream> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue(value);
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_L(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_L(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue(value);
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_M(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_M(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_N(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_N(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue(value);
    }
    public static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_NS(Dafny.ISequence<Dafny.ISequence<char>> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue(value);
    }
    public static Dafny.ISequence<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_NS(System.Collections.Generic.List<string> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue(value);
    }
    public static bool FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_NULL(bool value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_NullAttributeValue(value);
    }
    public static bool ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_NULL(bool value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_NullAttributeValue(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_S(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_S(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue(value);
    }
    public static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_SS(Dafny.ISequence<Dafny.ISequence<char>> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue(value);
    }
    public static Dafny.ISequence<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_SS(System.Collections.Generic.List<string> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue(value);
    }
    public static System.IO.MemoryStream FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue(Dafny.ISequence<byte> value)
    {
      return new System.IO.MemoryStream(value.Elements);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue(System.IO.MemoryStream value)
    {
      if (value.ToArray().Length == 0 && value.Length > 0)
      {
        throw new System.ArgumentException("Fatal Error: MemoryStream instance not backed by an array!");
      }
      return Dafny.Sequence<byte>.FromArray(value.ToArray());

    }
    public static System.Collections.Generic.List<System.IO.MemoryStream> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue(Dafny.ISequence<Dafny.ISequence<byte>> value)
    {
      return new System.Collections.Generic.List<System.IO.MemoryStream>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue__M6_member));
    }
    public static Dafny.ISequence<Dafny.ISequence<byte>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue(System.Collections.Generic.List<System.IO.MemoryStream> value)
    {
      return Dafny.Sequence<Dafny.ISequence<byte>>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue__M6_member).ToArray());
    }
    public static System.IO.MemoryStream FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue__M6_member(Dafny.ISequence<byte> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue(value);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue__M6_member(System.IO.MemoryStream value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue(value);
    }
    public static bool FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BooleanAttributeValue(bool value)
    {
      return value;
    }
    public static bool ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BooleanAttributeValue(bool value)
    {
      return value;
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M5_value(pair.Value))
     ));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M5_value(software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M5_value(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return new System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue__M6_member).ToArray());
    }
    public static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue__M6_member(software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue__M6_member(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M5_value(pair.Value))
     ));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M5_value(software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M5_value(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static bool FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_NullAttributeValue(bool value)
    {
      return value;
    }
    public static bool ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_NullAttributeValue(bool value)
    {
      return value;
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue(Dafny.ISequence<Dafny.ISequence<char>> value)
    {
      return new System.Collections.Generic.List<string>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue__M6_member));
    }
    public static Dafny.ISequence<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue(System.Collections.Generic.List<string> value)
    {
      return Dafny.Sequence<Dafny.ISequence<char>>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue__M6_member).ToArray());
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue__M6_member(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue__M6_member(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue(Dafny.ISequence<Dafny.ISequence<char>> value)
    {
      return new System.Collections.Generic.List<string>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue__M6_member));
    }
    public static Dafny.ISequence<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue(System.Collections.Generic.List<string> value)
    {
      return Dafny.Sequence<Dafny.ISequence<char>>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue__M6_member).ToArray());
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue__M6_member(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue__M6_member(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static System.IO.MemoryStream FromDafny_N6_smithy__N3_api__S4_Blob(Dafny.ISequence<byte> value)
    {
      return new System.IO.MemoryStream(value.Elements);
    }
    public static Dafny.ISequence<byte> ToDafny_N6_smithy__N3_api__S4_Blob(System.IO.MemoryStream value)
    {
      if (value.ToArray().Length == 0 && value.Length > 0)
      {
        throw new System.ArgumentException("Fatal Error: MemoryStream instance not backed by an array!");
      }
      return Dafny.Sequence<byte>.FromArray(value.ToArray());

    }
    public static bool FromDafny_N6_smithy__N3_api__S7_Boolean(bool value)
    {
      return value;
    }
    public static bool ToDafny_N6_smithy__N3_api__S7_Boolean(bool value)
    {
      return value;
    }
    public static int FromDafny_N6_smithy__N3_api__S7_Integer(int value)
    {
      return value;
    }
    public static int ToDafny_N6_smithy__N3_api__S7_Integer(int value)
    {
      return value;
    }
    public static string FromDafny_N6_smithy__N3_api__S6_String(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N6_smithy__N3_api__S6_String(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static System.Exception FromDafny_CommonError(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError value)
    {
      switch (value)
      {
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_AwsCryptographyDbEncryptionSdkStructuredEncryption dafnyVal:
          return AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.TypeConversion.FromDafny_CommonError(
            dafnyVal._AwsCryptographyDbEncryptionSdkStructuredEncryption
          );
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_AwsCryptographyKeyStore dafnyVal:
          return AWS.Cryptography.KeyStore.TypeConversion.FromDafny_CommonError(
            dafnyVal._AwsCryptographyKeyStore
          );
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_AwsCryptographyMaterialProviders dafnyVal:
          return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_CommonError(
            dafnyVal._AwsCryptographyMaterialProviders
          );
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_AwsCryptographyPrimitives dafnyVal:
          return AWS.Cryptography.Primitives.TypeConversion.FromDafny_CommonError(
            dafnyVal._AwsCryptographyPrimitives
          );
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_ComAmazonawsDynamodb dafnyVal:
          return Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_CommonError(
            dafnyVal._ComAmazonawsDynamodb
          );
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_DynamoDbEncryptionException dafnyVal:
          return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_DynamoDbEncryptionException(dafnyVal);
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_CollectionOfErrors dafnyVal:
          return new CollectionOfErrors(
              new System.Collections.Generic.List<Exception>(dafnyVal.dtor_list.CloneAsArray()
                .Select(x => TypeConversion.FromDafny_CommonError(x))),
              new string(dafnyVal.dtor_message.Elements));
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_Opaque dafnyVal:
          return new OpaqueError(dafnyVal._obj);
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_OpaqueWithText dafnyVal:
          return new OpaqueWithTextError(dafnyVal._obj, dafnyVal._obj.ToString());
        default:
          // The switch MUST be complete for _IError, so `value` MUST NOT be an _IError. (How did you get here?)
          return new OpaqueError();
      }
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError ToDafny_CommonError(System.Exception value)
    {

      switch (value)
      {
        case AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryptionException exception:
          return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_DynamoDbEncryptionException(exception);
        case CollectionOfErrors collectionOfErrors:
          return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_CollectionOfErrors(
            Dafny.Sequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError>
              .FromArray(
                collectionOfErrors.list.Select
                    (x => TypeConversion.ToDafny_CommonError(x))
                  .ToArray()),
            Dafny.Sequence<char>.FromString(collectionOfErrors.Message)
          );
        // OpaqueError is redundant, but listed for completeness.
        case OpaqueError exception:
          return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_Opaque(exception);
        case System.Exception exception:
          return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_Opaque(exception);
        default:
          // The switch MUST be complete for System.Exception, so `value` MUST NOT be an System.Exception. (How did you get here?)
          return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_Opaque(value);
      }
    }
  }
}
