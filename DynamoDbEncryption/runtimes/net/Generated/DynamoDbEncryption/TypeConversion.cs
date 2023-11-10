// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System.Linq;
using System;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public static class TypeConversion
  {
    // BEGIN MANUAL EDIT
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
    // END MANUAL EDIT
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconKeySource FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconKeySource(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconKeySource value)
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
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconKeySource ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconKeySource(AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconKeySource value)
    {
      if (value.IsSetSingle())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconKeySource.create_single(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconKeySource__M6_single(value.Single));
      }
      if (value.IsSetMulti())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconKeySource.create_multi(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconKeySource__M5_multi(value.Multi));
      }
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconKeySource state");
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconStyle FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconStyle value)
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
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IBeaconStyle ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle(AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconStyle value)
    {
      if (value.IsSetPartOnly())
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
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.CreateDynamoDbEncryptionBranchKeyIdSupplierInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICreateDynamoDbEncryptionBranchKeyIdSupplierInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.CreateDynamoDbEncryptionBranchKeyIdSupplierInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.CreateDynamoDbEncryptionBranchKeyIdSupplierInput(); converted.DdbKeyBranchKeyIdSupplier = (AWS.Cryptography.DbEncryptionSDK.DynamoDb.IDynamoDbKeyBranchKeyIdSupplier)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput__M25_ddbKeyBranchKeyIdSupplier(concrete._ddbKeyBranchKeyIdSupplier); return converted;
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICreateDynamoDbEncryptionBranchKeyIdSupplierInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.CreateDynamoDbEncryptionBranchKeyIdSupplierInput value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput__M25_ddbKeyBranchKeyIdSupplier(value.DdbKeyBranchKeyIdSupplier));
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICreateDynamoDbEncryptionBranchKeyIdSupplierOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(); converted.BranchKeyIdSupplier = (AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput__M19_branchKeyIdSupplier(concrete._branchKeyIdSupplier); return converted;
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICreateDynamoDbEncryptionBranchKeyIdSupplierOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput__M19_branchKeyIdSupplier(value.BranchKeyIdSupplier));
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryptionConfig FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S24_DynamoDbEncryptionConfig(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IDynamoDbEncryptionConfig value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbEncryptionConfig concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbEncryptionConfig)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryptionConfig converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryptionConfig(); return converted;
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IDynamoDbEncryptionConfig ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S24_DynamoDbEncryptionConfig(AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryptionConfig value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbEncryptionConfig();
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryptionException FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_DynamoDbEncryptionException(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_DynamoDbEncryptionException value)
    {
      return new AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryptionException(
      FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_DynamoDbEncryptionException__M7_message(value._message)
      );
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_DynamoDbEncryptionException ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_DynamoDbEncryptionException(AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryptionException value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_DynamoDbEncryptionException(
      ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_DynamoDbEncryptionException__M7_message(value.Message)
      );
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBranchKeyIdFromDdbKeyInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_GetBranchKeyIdFromDdbKeyInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetBranchKeyIdFromDdbKeyInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBranchKeyIdFromDdbKeyInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBranchKeyIdFromDdbKeyInput(); converted.DdbKey = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_GetBranchKeyIdFromDdbKeyInput__M6_ddbKey(concrete._ddbKey); return converted;
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetBranchKeyIdFromDdbKeyInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_GetBranchKeyIdFromDdbKeyInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBranchKeyIdFromDdbKeyInput value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_GetBranchKeyIdFromDdbKeyInput__M6_ddbKey(value.DdbKey));
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBranchKeyIdFromDdbKeyOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_GetBranchKeyIdFromDdbKeyOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetBranchKeyIdFromDdbKeyOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBranchKeyIdFromDdbKeyOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBranchKeyIdFromDdbKeyOutput(); converted.BranchKeyId = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_GetBranchKeyIdFromDdbKeyOutput__M11_branchKeyId(concrete._branchKeyId); return converted;
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetBranchKeyIdFromDdbKeyOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_GetBranchKeyIdFromDdbKeyOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBranchKeyIdFromDdbKeyOutput value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_GetBranchKeyIdFromDdbKeyOutput__M11_branchKeyId(value.BranchKeyId));
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_LegacyPolicy(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILegacyPolicy value)
    {
      if (value.is_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT) return AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT;
      if (value.is_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT) return AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy.FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT;
      if (value.is_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT) return AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy.FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT;
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy value");
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILegacyPolicy ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_LegacyPolicy(AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy value)
    {
      if (AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT.Equals(value)) return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyPolicy.create_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT();
      if (AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy.FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT.Equals(value)) return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyPolicy.create_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT();
      if (AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy.FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT.Equals(value)) return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyPolicy.create_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT();
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy value");
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S17_PlaintextOverride(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IPlaintextOverride value)
    {
      if (value.is_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ) return AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ;
      if (value.is_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ) return AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride.FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ;
      if (value.is_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ) return AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride.FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ;
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride value");
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IPlaintextOverride ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S17_PlaintextOverride(AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride value)
    {
      if (AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ.Equals(value)) return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride.create_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ();
      if (AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride.FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ.Equals(value)) return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride.create_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ();
      if (AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride.FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ.Equals(value)) return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride.create_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ();
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride value");
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualTransform FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualTransform value)
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
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IVirtualTransform ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualTransform value)
    {
      if (value.IsSetUpper())
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
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.SingleKeyStore FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconKeySource__M6_single(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISingleKeyStore value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore(value);
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISingleKeyStore ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconKeySource__M6_single(AWS.Cryptography.DbEncryptionSDK.DynamoDb.SingleKeyStore value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore(value);
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.MultiKeyStore FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconKeySource__M5_multi(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IMultiKeyStore value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore(value);
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IMultiKeyStore ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S15_BeaconKeySource__M5_multi(AWS.Cryptography.DbEncryptionSDK.DynamoDb.MultiKeyStore value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore(value);
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.PartOnly FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M8_partOnly(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IPartOnly value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S8_PartOnly(value);
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IPartOnly ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M8_partOnly(AWS.Cryptography.DbEncryptionSDK.DynamoDb.PartOnly value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S8_PartOnly(value);
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Shared FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M6_shared(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IShared value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Shared(value);
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IShared ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M6_shared(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Shared value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Shared(value);
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.AsSet FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M5_asSet(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IAsSet value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_AsSet(value);
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IAsSet ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M5_asSet(AWS.Cryptography.DbEncryptionSDK.DynamoDb.AsSet value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_AsSet(value);
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.SharedSet FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M9_sharedSet(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISharedSet value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_SharedSet(value);
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISharedSet ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_BeaconStyle__M9_sharedSet(AWS.Cryptography.DbEncryptionSDK.DynamoDb.SharedSet value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_SharedSet(value);
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.IDynamoDbKeyBranchKeyIdSupplier FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput__M25_ddbKeyBranchKeyIdSupplier(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S39_DynamoDbKeyBranchKeyIdSupplierReference(value);
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput__M25_ddbKeyBranchKeyIdSupplier(AWS.Cryptography.DbEncryptionSDK.DynamoDb.IDynamoDbKeyBranchKeyIdSupplier value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S39_DynamoDbKeyBranchKeyIdSupplierReference(value);
    }
    internal static AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput__M19_branchKeyIdSupplier(software.amazon.cryptography.materialproviders.internaldafny.types.IBranchKeyIdSupplier value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference(value);
    }
    internal static software.amazon.cryptography.materialproviders.internaldafny.types.IBranchKeyIdSupplier ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput__M19_branchKeyIdSupplier(AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference(value);
    }
    internal static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_DynamoDbEncryptionException__M7_message(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_DynamoDbEncryptionException__M7_message(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    internal static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_GetBranchKeyIdFromDdbKeyInput__M6_ddbKey(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    internal static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_GetBranchKeyIdFromDdbKeyInput__M6_ddbKey(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    internal static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_GetBranchKeyIdFromDdbKeyOutput__M11_branchKeyId(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_GetBranchKeyIdFromDdbKeyOutput__M11_branchKeyId(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Upper FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M5_upper(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IUpper value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_Upper(value);
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IUpper ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M5_upper(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Upper value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_Upper(value);
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Lower FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M5_lower(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILower value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_Lower(value);
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILower ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M5_lower(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Lower value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_Lower(value);
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Insert FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M6_insert(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IInsert value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Insert(value);
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IInsert ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M6_insert(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Insert value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Insert(value);
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetPrefix FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M6_prefix(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetPrefix value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetPrefix(value);
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetPrefix ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M6_prefix(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetPrefix value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetPrefix(value);
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSuffix FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M6_suffix(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSuffix value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetSuffix(value);
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSuffix ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M6_suffix(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSuffix value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetSuffix(value);
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSubstring FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M9_substring(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSubstring value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring(value);
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSubstring ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M9_substring(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSubstring value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring(value);
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegment FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M7_segment(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSegment value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment(value);
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSegment ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M7_segment(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegment value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment(value);
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegments FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M8_segments(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSegments value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments(value);
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSegments ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_VirtualTransform__M8_segments(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegments value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments(value);
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.SingleKeyStore FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISingleKeyStore value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SingleKeyStore concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SingleKeyStore)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.SingleKeyStore converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.SingleKeyStore(); converted.KeyId = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M5_keyId(concrete._keyId);
      converted.CacheTTL = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M8_cacheTTL(concrete._cacheTTL); return converted;
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISingleKeyStore ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore(AWS.Cryptography.DbEncryptionSDK.DynamoDb.SingleKeyStore value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SingleKeyStore(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M5_keyId(value.KeyId), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M8_cacheTTL(value.CacheTTL));
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.MultiKeyStore FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IMultiKeyStore value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.MultiKeyStore concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.MultiKeyStore)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.MultiKeyStore converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.MultiKeyStore(); converted.KeyFieldName = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M12_keyFieldName(concrete._keyFieldName);
      converted.CacheTTL = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M8_cacheTTL(concrete._cacheTTL);
      if (concrete._cache.is_Some) converted.Cache = (AWS.Cryptography.MaterialProviders.CacheType)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M5_cache(concrete._cache); return converted;
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IMultiKeyStore ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore(AWS.Cryptography.DbEncryptionSDK.DynamoDb.MultiKeyStore value)
    {
      AWS.Cryptography.MaterialProviders.CacheType var_cache = value.IsSetCache() ? value.Cache : (AWS.Cryptography.MaterialProviders.CacheType)null;
      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.MultiKeyStore(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M12_keyFieldName(value.KeyFieldName), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M8_cacheTTL(value.CacheTTL), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M5_cache(var_cache));
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.PartOnly FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S8_PartOnly(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IPartOnly value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PartOnly concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PartOnly)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.PartOnly converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.PartOnly(); return converted;
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IPartOnly ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S8_PartOnly(AWS.Cryptography.DbEncryptionSDK.DynamoDb.PartOnly value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PartOnly();
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Shared FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Shared(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IShared value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Shared concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Shared)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Shared converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Shared(); converted.Other = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Shared__M5_other(concrete._other); return converted;
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IShared ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Shared(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Shared value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Shared(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Shared__M5_other(value.Other));
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.AsSet FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_AsSet(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IAsSet value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.AsSet concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.AsSet)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.AsSet converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.AsSet(); return converted;
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IAsSet ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_AsSet(AWS.Cryptography.DbEncryptionSDK.DynamoDb.AsSet value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.AsSet();
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.SharedSet FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_SharedSet(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISharedSet value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SharedSet concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SharedSet)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.SharedSet converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.SharedSet(); converted.Other = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_SharedSet__M5_other(concrete._other); return converted;
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ISharedSet ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_SharedSet(AWS.Cryptography.DbEncryptionSDK.DynamoDb.SharedSet value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SharedSet(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_SharedSet__M5_other(value.Other));
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
    internal static AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference(software.amazon.cryptography.materialproviders.internaldafny.types.IBranchKeyIdSupplier value)
    {
      // This is converting a reference type in a dependant module.
      // Therefore it defers to the dependant module for conversion
      return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference(value);
    }
    internal static software.amazon.cryptography.materialproviders.internaldafny.types.IBranchKeyIdSupplier ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference(AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier value)
    {
      // This is converting a reference type in a dependant module.
      // Therefore it defers to the dependant module for conversion
      return AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference(value);
    }
    internal static string FromDafny_N6_smithy__N3_api__S6_String(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    internal static Dafny.ISequence<char> ToDafny_N6_smithy__N3_api__S6_String(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    internal static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M5_value(pair.Cdr));
    }
    internal static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M5_value(pair.Value))
     ));
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Upper FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_Upper(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IUpper value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Upper concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Upper)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Upper converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Upper(); return converted;
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IUpper ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_Upper(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Upper value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Upper();
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Lower FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_Lower(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILower value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Lower concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Lower)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Lower converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Lower(); return converted;
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILower ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S5_Lower(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Lower value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Lower();
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Insert FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Insert(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IInsert value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Insert concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Insert)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Insert converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Insert(); converted.Literal = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Insert__M7_literal(concrete._literal); return converted;
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IInsert ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Insert(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Insert value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Insert(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Insert__M7_literal(value.Literal));
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetPrefix FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetPrefix(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetPrefix value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetPrefix concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetPrefix)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetPrefix converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetPrefix(); converted.Length = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetPrefix__M6_length(concrete._length); return converted;
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetPrefix ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetPrefix(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetPrefix value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetPrefix(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetPrefix__M6_length(value.Length));
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSuffix FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetSuffix(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSuffix value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSuffix concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSuffix)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSuffix converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSuffix(); converted.Length = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetSuffix__M6_length(concrete._length); return converted;
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSuffix ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetSuffix(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSuffix value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSuffix(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetSuffix__M6_length(value.Length));
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSubstring FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSubstring value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSubstring concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSubstring)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSubstring converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSubstring(); converted.Low = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring__M3_low(concrete._low);
      converted.High = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring__M4_high(concrete._high); return converted;
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSubstring ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSubstring value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSubstring(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring__M3_low(value.Low), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring__M4_high(value.High));
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegment FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSegment value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegment converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegment(); converted.Split = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment__M5_split(concrete._split);
      converted.Index = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment__M5_index(concrete._index); return converted;
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSegment ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegment value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment__M5_split(value.Split), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment__M5_index(value.Index));
    }
    internal static AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegments FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSegments value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegments concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegments)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegments converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegments(); converted.Split = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M5_split(concrete._split);
      converted.Low = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M3_low(concrete._low);
      converted.High = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M4_high(concrete._high); return converted;
    }
    internal static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetSegments ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetSegments value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegments(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M5_split(value.Split), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M3_low(value.Low), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M4_high(value.High));
    }
    internal static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M5_keyId(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M5_keyId(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    internal static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M8_cacheTTL(int value)
    {
      return FromDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    internal static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_SingleKeyStore__M8_cacheTTL(int value)
    {
      return ToDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    internal static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M12_keyFieldName(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M12_keyFieldName(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    internal static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M8_cacheTTL(int value)
    {
      return FromDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    internal static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M8_cacheTTL(int value)
    {
      return ToDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    internal static AWS.Cryptography.MaterialProviders.CacheType FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M5_cache(Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types._ICacheType> value)
    {
      return value.is_None ? (AWS.Cryptography.MaterialProviders.CacheType)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType(value.Extract());
    }
    internal static Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types._ICacheType> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_MultiKeyStore__M5_cache(AWS.Cryptography.MaterialProviders.CacheType value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types._ICacheType>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types._ICacheType>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType((AWS.Cryptography.MaterialProviders.CacheType)value));
    }
    internal static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Shared__M5_other(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Shared__M5_other(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    internal static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_SharedSet__M5_other(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_SharedSet__M5_other(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    internal static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M5_value(software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    internal static software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M5_value(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    internal static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Insert__M7_literal(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S6_Insert__M7_literal(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    internal static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetPrefix__M6_length(int value)
    {
      return FromDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    internal static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetPrefix__M6_length(int value)
    {
      return ToDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    internal static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetSuffix__M6_length(int value)
    {
      return FromDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    internal static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S9_GetSuffix__M6_length(int value)
    {
      return ToDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    internal static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring__M3_low(int value)
    {
      return FromDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    internal static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring__M3_low(int value)
    {
      return ToDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    internal static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring__M4_high(int value)
    {
      return FromDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    internal static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S12_GetSubstring__M4_high(int value)
    {
      return ToDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    internal static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment__M5_split(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S4_Char(value);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment__M5_split(string value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S4_Char(value);
    }
    internal static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment__M5_index(int value)
    {
      return FromDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    internal static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S10_GetSegment__M5_index(int value)
    {
      return ToDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    internal static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M5_split(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S4_Char(value);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M5_split(string value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S4_Char(value);
    }
    internal static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M3_low(int value)
    {
      return FromDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    internal static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M3_low(int value)
    {
      return ToDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    internal static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M4_high(int value)
    {
      return FromDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    internal static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S11_GetSegments__M4_high(int value)
    {
      return ToDafny_N6_smithy__N3_api__S7_Integer(value);
    }
    internal static int FromDafny_N6_smithy__N3_api__S7_Integer(int value)
    {
      return value;
    }
    internal static int ToDafny_N6_smithy__N3_api__S7_Integer(int value)
    {
      return value;
    }
    internal static AWS.Cryptography.MaterialProviders.CacheType FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType(software.amazon.cryptography.materialproviders.internaldafny.types._ICacheType value)
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
      throw new System.ArgumentException("Invalid AWS.Cryptography.MaterialProviders.CacheType state");
    }
    internal static software.amazon.cryptography.materialproviders.internaldafny.types._ICacheType ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType(AWS.Cryptography.MaterialProviders.CacheType value)
    {
      if (value.IsSetDefault())
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
      throw new System.ArgumentException("Invalid AWS.Cryptography.MaterialProviders.CacheType state");
    }
    internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    internal static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue value)
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
    internal static software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(Amazon.DynamoDBv2.Model.AttributeValue value)
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
    internal static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S4_Char(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S4_Char(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    internal static AWS.Cryptography.MaterialProviders.DefaultCache FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M7_Default(software.amazon.cryptography.materialproviders.internaldafny.types._IDefaultCache value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S12_DefaultCache(value);
    }
    internal static software.amazon.cryptography.materialproviders.internaldafny.types._IDefaultCache ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M7_Default(AWS.Cryptography.MaterialProviders.DefaultCache value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S12_DefaultCache(value);
    }
    internal static AWS.Cryptography.MaterialProviders.NoCache FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M2_No(software.amazon.cryptography.materialproviders.internaldafny.types._INoCache value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S7_NoCache(value);
    }
    internal static software.amazon.cryptography.materialproviders.internaldafny.types._INoCache ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M2_No(AWS.Cryptography.MaterialProviders.NoCache value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S7_NoCache(value);
    }
    internal static AWS.Cryptography.MaterialProviders.SingleThreadedCache FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M14_SingleThreaded(software.amazon.cryptography.materialproviders.internaldafny.types._ISingleThreadedCache value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache(value);
    }
    internal static software.amazon.cryptography.materialproviders.internaldafny.types._ISingleThreadedCache ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M14_SingleThreaded(AWS.Cryptography.MaterialProviders.SingleThreadedCache value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache(value);
    }
    internal static AWS.Cryptography.MaterialProviders.MultiThreadedCache FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M13_MultiThreaded(software.amazon.cryptography.materialproviders.internaldafny.types._IMultiThreadedCache value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache(value);
    }
    internal static software.amazon.cryptography.materialproviders.internaldafny.types._IMultiThreadedCache ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M13_MultiThreaded(AWS.Cryptography.MaterialProviders.MultiThreadedCache value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache(value);
    }
    internal static AWS.Cryptography.MaterialProviders.StormTrackingCache FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M13_StormTracking(software.amazon.cryptography.materialproviders.internaldafny.types._IStormTrackingCache value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache(value);
    }
    internal static software.amazon.cryptography.materialproviders.internaldafny.types._IStormTrackingCache ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_CacheType__M13_StormTracking(AWS.Cryptography.MaterialProviders.StormTrackingCache value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache(value);
    }
    internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_S(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue(value);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_S(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue(value);
    }
    internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_N(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue(value);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_N(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue(value);
    }
    internal static System.IO.MemoryStream FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_B(Dafny.ISequence<byte> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue(value);
    }
    internal static Dafny.ISequence<byte> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_B(System.IO.MemoryStream value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue(value);
    }
    internal static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_SS(Dafny.ISequence<Dafny.ISequence<char>> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue(value);
    }
    internal static Dafny.ISequence<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_SS(System.Collections.Generic.List<string> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue(value);
    }
    internal static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_NS(Dafny.ISequence<Dafny.ISequence<char>> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue(value);
    }
    internal static Dafny.ISequence<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_NS(System.Collections.Generic.List<string> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue(value);
    }
    internal static System.Collections.Generic.List<System.IO.MemoryStream> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_BS(Dafny.ISequence<Dafny.ISequence<byte>> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue(value);
    }
    internal static Dafny.ISequence<Dafny.ISequence<byte>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_BS(System.Collections.Generic.List<System.IO.MemoryStream> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue(value);
    }
    internal static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_M(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue(value);
    }
    internal static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_M(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue(value);
    }
    internal static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_L(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue(value);
    }
    internal static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_L(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue(value);
    }
    internal static bool FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_NULL(bool value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_NullAttributeValue(value);
    }
    internal static bool ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_NULL(bool value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_NullAttributeValue(value);
    }
    internal static bool FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_BOOL(bool value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BooleanAttributeValue(value);
    }
    internal static bool ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_BOOL(bool value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BooleanAttributeValue(value);
    }
    internal static AWS.Cryptography.MaterialProviders.DefaultCache FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S12_DefaultCache(software.amazon.cryptography.materialproviders.internaldafny.types._IDefaultCache value)
    {
      software.amazon.cryptography.materialproviders.internaldafny.types.DefaultCache concrete = (software.amazon.cryptography.materialproviders.internaldafny.types.DefaultCache)value; AWS.Cryptography.MaterialProviders.DefaultCache converted = new AWS.Cryptography.MaterialProviders.DefaultCache(); converted.EntryCapacity = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S12_DefaultCache__M13_entryCapacity(concrete._entryCapacity); return converted;
    }
    internal static software.amazon.cryptography.materialproviders.internaldafny.types._IDefaultCache ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S12_DefaultCache(AWS.Cryptography.MaterialProviders.DefaultCache value)
    {

      return new software.amazon.cryptography.materialproviders.internaldafny.types.DefaultCache(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S12_DefaultCache__M13_entryCapacity(value.EntryCapacity));
    }
    internal static AWS.Cryptography.MaterialProviders.NoCache FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S7_NoCache(software.amazon.cryptography.materialproviders.internaldafny.types._INoCache value)
    {
      software.amazon.cryptography.materialproviders.internaldafny.types.NoCache concrete = (software.amazon.cryptography.materialproviders.internaldafny.types.NoCache)value; AWS.Cryptography.MaterialProviders.NoCache converted = new AWS.Cryptography.MaterialProviders.NoCache(); return converted;
    }
    internal static software.amazon.cryptography.materialproviders.internaldafny.types._INoCache ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S7_NoCache(AWS.Cryptography.MaterialProviders.NoCache value)
    {

      return new software.amazon.cryptography.materialproviders.internaldafny.types.NoCache();
    }
    internal static AWS.Cryptography.MaterialProviders.SingleThreadedCache FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache(software.amazon.cryptography.materialproviders.internaldafny.types._ISingleThreadedCache value)
    {
      software.amazon.cryptography.materialproviders.internaldafny.types.SingleThreadedCache concrete = (software.amazon.cryptography.materialproviders.internaldafny.types.SingleThreadedCache)value; AWS.Cryptography.MaterialProviders.SingleThreadedCache converted = new AWS.Cryptography.MaterialProviders.SingleThreadedCache(); converted.EntryCapacity = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache__M13_entryCapacity(concrete._entryCapacity);
      if (concrete._entryPruningTailSize.is_Some) converted.EntryPruningTailSize = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache__M20_entryPruningTailSize(concrete._entryPruningTailSize); return converted;
    }
    internal static software.amazon.cryptography.materialproviders.internaldafny.types._ISingleThreadedCache ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache(AWS.Cryptography.MaterialProviders.SingleThreadedCache value)
    {
      int? var_entryPruningTailSize = value.IsSetEntryPruningTailSize() ? value.EntryPruningTailSize : (int?)null;
      return new software.amazon.cryptography.materialproviders.internaldafny.types.SingleThreadedCache(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache__M13_entryCapacity(value.EntryCapacity), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache__M20_entryPruningTailSize(var_entryPruningTailSize));
    }
    internal static AWS.Cryptography.MaterialProviders.MultiThreadedCache FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache(software.amazon.cryptography.materialproviders.internaldafny.types._IMultiThreadedCache value)
    {
      software.amazon.cryptography.materialproviders.internaldafny.types.MultiThreadedCache concrete = (software.amazon.cryptography.materialproviders.internaldafny.types.MultiThreadedCache)value; AWS.Cryptography.MaterialProviders.MultiThreadedCache converted = new AWS.Cryptography.MaterialProviders.MultiThreadedCache(); converted.EntryCapacity = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache__M13_entryCapacity(concrete._entryCapacity);
      if (concrete._entryPruningTailSize.is_Some) converted.EntryPruningTailSize = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache__M20_entryPruningTailSize(concrete._entryPruningTailSize); return converted;
    }
    internal static software.amazon.cryptography.materialproviders.internaldafny.types._IMultiThreadedCache ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache(AWS.Cryptography.MaterialProviders.MultiThreadedCache value)
    {
      int? var_entryPruningTailSize = value.IsSetEntryPruningTailSize() ? value.EntryPruningTailSize : (int?)null;
      return new software.amazon.cryptography.materialproviders.internaldafny.types.MultiThreadedCache(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache__M13_entryCapacity(value.EntryCapacity), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache__M20_entryPruningTailSize(var_entryPruningTailSize));
    }
    internal static AWS.Cryptography.MaterialProviders.StormTrackingCache FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache(software.amazon.cryptography.materialproviders.internaldafny.types._IStormTrackingCache value)
    {
      software.amazon.cryptography.materialproviders.internaldafny.types.StormTrackingCache concrete = (software.amazon.cryptography.materialproviders.internaldafny.types.StormTrackingCache)value; AWS.Cryptography.MaterialProviders.StormTrackingCache converted = new AWS.Cryptography.MaterialProviders.StormTrackingCache(); converted.EntryCapacity = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M13_entryCapacity(concrete._entryCapacity);
      if (concrete._entryPruningTailSize.is_Some) converted.EntryPruningTailSize = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M20_entryPruningTailSize(concrete._entryPruningTailSize);
      converted.GracePeriod = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M11_gracePeriod(concrete._gracePeriod);
      converted.GraceInterval = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M13_graceInterval(concrete._graceInterval);
      converted.FanOut = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M6_fanOut(concrete._fanOut);
      converted.InFlightTTL = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M11_inFlightTTL(concrete._inFlightTTL);
      converted.SleepMilli = (int)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M10_sleepMilli(concrete._sleepMilli); return converted;
    }
    internal static software.amazon.cryptography.materialproviders.internaldafny.types._IStormTrackingCache ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache(AWS.Cryptography.MaterialProviders.StormTrackingCache value)
    {
      int? var_entryPruningTailSize = value.IsSetEntryPruningTailSize() ? value.EntryPruningTailSize : (int?)null;
      return new software.amazon.cryptography.materialproviders.internaldafny.types.StormTrackingCache(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M13_entryCapacity(value.EntryCapacity), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M20_entryPruningTailSize(var_entryPruningTailSize), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M11_gracePeriod(value.GracePeriod), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M13_graceInterval(value.GraceInterval), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M6_fanOut(value.FanOut), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M11_inFlightTTL(value.InFlightTTL), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M10_sleepMilli(value.SleepMilli));
    }
    internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    internal static System.IO.MemoryStream FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue(Dafny.ISequence<byte> value)
    {
      return new System.IO.MemoryStream(value.Elements);
    }
    internal static Dafny.ISequence<byte> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue(System.IO.MemoryStream value)
    {
      return Dafny.Sequence<byte>.FromArray(value.ToArray());
    }
    internal static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue(Dafny.ISequence<Dafny.ISequence<char>> value)
    {
      return new System.Collections.Generic.List<string>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue__M6_member));
    }
    internal static Dafny.ISequence<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue(System.Collections.Generic.List<string> value)
    {
      return Dafny.Sequence<Dafny.ISequence<char>>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue__M6_member).ToArray());
    }
    internal static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue(Dafny.ISequence<Dafny.ISequence<char>> value)
    {
      return new System.Collections.Generic.List<string>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue__M6_member));
    }
    internal static Dafny.ISequence<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue(System.Collections.Generic.List<string> value)
    {
      return Dafny.Sequence<Dafny.ISequence<char>>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue__M6_member).ToArray());
    }
    internal static System.Collections.Generic.List<System.IO.MemoryStream> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue(Dafny.ISequence<Dafny.ISequence<byte>> value)
    {
      return new System.Collections.Generic.List<System.IO.MemoryStream>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue__M6_member));
    }
    internal static Dafny.ISequence<Dafny.ISequence<byte>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue(System.Collections.Generic.List<System.IO.MemoryStream> value)
    {
      return Dafny.Sequence<Dafny.ISequence<byte>>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue__M6_member).ToArray());
    }
    internal static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M5_value(pair.Cdr));
    }
    internal static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M5_value(pair.Value))
     ));
    }
    internal static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return new System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue__M6_member));
    }
    internal static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue__M6_member).ToArray());
    }
    internal static bool FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_NullAttributeValue(bool value)
    {
      return value;
    }
    internal static bool ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_NullAttributeValue(bool value)
    {
      return value;
    }
    internal static bool FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BooleanAttributeValue(bool value)
    {
      return value;
    }
    internal static bool ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BooleanAttributeValue(bool value)
    {
      return value;
    }
    internal static int FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S12_DefaultCache__M13_entryCapacity(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    internal static int ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S12_DefaultCache__M13_entryCapacity(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    internal static int FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache__M13_entryCapacity(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    internal static int ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache__M13_entryCapacity(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    internal static int? FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache__M20_entryPruningTailSize(Wrappers_Compile._IOption<int> value)
    {
      return value.is_None ? (int?)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value.Extract());
    }
    internal static Wrappers_Compile._IOption<int> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_SingleThreadedCache__M20_entryPruningTailSize(int? value)
    {
      return value == null ? Wrappers_Compile.Option<int>.create_None() : Wrappers_Compile.Option<int>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber((int)value));
    }
    internal static int FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache__M13_entryCapacity(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    internal static int ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache__M13_entryCapacity(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    internal static int? FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache__M20_entryPruningTailSize(Wrappers_Compile._IOption<int> value)
    {
      return value.is_None ? (int?)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value.Extract());
    }
    internal static Wrappers_Compile._IOption<int> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_MultiThreadedCache__M20_entryPruningTailSize(int? value)
    {
      return value == null ? Wrappers_Compile.Option<int>.create_None() : Wrappers_Compile.Option<int>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber((int)value));
    }
    internal static int FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M13_entryCapacity(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    internal static int ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M13_entryCapacity(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    internal static int? FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M20_entryPruningTailSize(Wrappers_Compile._IOption<int> value)
    {
      return value.is_None ? (int?)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value.Extract());
    }
    internal static Wrappers_Compile._IOption<int> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M20_entryPruningTailSize(int? value)
    {
      return value == null ? Wrappers_Compile.Option<int>.create_None() : Wrappers_Compile.Option<int>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber((int)value));
    }
    internal static int FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M11_gracePeriod(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    internal static int ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M11_gracePeriod(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    internal static int FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M13_graceInterval(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    internal static int ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M13_graceInterval(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    internal static int FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M6_fanOut(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    internal static int ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M6_fanOut(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    internal static int FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M11_inFlightTTL(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    internal static int ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M11_inFlightTTL(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    internal static int FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M10_sleepMilli(int value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    internal static int ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S18_StormTrackingCache__M10_sleepMilli(int value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(value);
    }
    internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue__M6_member(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue(value);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue__M6_member(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue(value);
    }
    internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue__M6_member(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue(value);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue__M6_member(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue(value);
    }
    internal static System.IO.MemoryStream FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue__M6_member(Dafny.ISequence<byte> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue(value);
    }
    internal static Dafny.ISequence<byte> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue__M6_member(System.IO.MemoryStream value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue(value);
    }
    internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    internal static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M5_value(software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    internal static software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M5_value(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    internal static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue__M6_member(software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    internal static software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue__M6_member(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    internal static int FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(int value)
    {
      return value;
    }
    internal static int ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S14_CountingNumber(int value)
    {
      return value;
    }
    public static System.Exception FromDafny_CommonError(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError value)
    {
      switch (value)
      {
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_ComAmazonawsDynamodb dafnyVal:
          return Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_CommonError(
            dafnyVal._ComAmazonawsDynamodb
          );
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_AwsCryptographyMaterialProviders dafnyVal:
          return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_CommonError(
            dafnyVal._AwsCryptographyMaterialProviders
          );
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_AwsCryptographyDbEncryptionSdkStructuredEncryption dafnyVal:
          return AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.TypeConversion.FromDafny_CommonError(
            dafnyVal._AwsCryptographyDbEncryptionSdkStructuredEncryption
          );
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_AwsCryptographyPrimitives dafnyVal:
          return AWS.Cryptography.Primitives.TypeConversion.FromDafny_CommonError(
            dafnyVal._AwsCryptographyPrimitives
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
