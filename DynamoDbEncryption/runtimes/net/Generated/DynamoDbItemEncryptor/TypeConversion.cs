// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System.Linq;
using System;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor
{
  public static class TypeConversion
  {
    private const string ISO8601DateFormat = "yyyy-MM-dd\\THH:mm:ss.fff\\Z";

    private const string ISO8601DateFormatNoMS = "yyyy-MM-dd\\THH:mm:ss\\Z";

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
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.ILegacyDynamoDbEncryptor FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S32_LegacyDynamoDbEncryptorReference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ILegacyDynamoDbEncryptor value)
    {
      // This is converting a reference type in a dependant module.
      // Therefore it defers to the dependant module for conversion
      return AWS.Cryptography.DbEncryptionSDK.DynamoDb.TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S32_LegacyDynamoDbEncryptorReference(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ILegacyDynamoDbEncryptor ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S32_LegacyDynamoDbEncryptorReference(AWS.Cryptography.DbEncryptionSDK.DynamoDb.ILegacyDynamoDbEncryptor value)
    {
      // This is converting a reference type in a dependant module.
      // Therefore it defers to the dependant module for conversion
      return AWS.Cryptography.DbEncryptionSDK.DynamoDb.TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S32_LegacyDynamoDbEncryptorReference(value);
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
    public static AWS.Cryptography.Primitives.AtomicPrimitives FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S25_AtomicPrimitivesReference(software.amazon.cryptography.primitives.internaldafny.types.IAwsCryptographicPrimitivesClient value)
    {
      if (value is software.amazon.cryptography.primitives.internaldafny.types.IAwsCryptographicPrimitivesClient dafnyValue)
      {
        return new AWS.Cryptography.Primitives.AtomicPrimitives(dafnyValue);
      }
      throw new System.ArgumentException("Custom implementations of AWS.Cryptography.Primitives.AtomicPrimitives are not supported yet");
    }
    public static software.amazon.cryptography.primitives.internaldafny.types.IAwsCryptographicPrimitivesClient ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S25_AtomicPrimitivesReference(AWS.Cryptography.Primitives.AtomicPrimitives value)
    {
      if (value is AWS.Cryptography.Primitives.AtomicPrimitives nativeValue)
      {
        return nativeValue.impl();
      }
      throw new System.ArgumentException("Custom implementations of AWS.Cryptography.Primitives.AtomicPrimitives are not supported yet");
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DecryptItemInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S16_DecryptItemInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IDecryptItemInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DecryptItemInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DecryptItemInput(); converted.EncryptedItem = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S16_DecryptItemInput__M13_encryptedItem(concrete._encryptedItem); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IDecryptItemInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S16_DecryptItemInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DecryptItemInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S16_DecryptItemInput__M13_encryptedItem(value.EncryptedItem));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S16_DecryptItemInput__M13_encryptedItem(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S16_DecryptItemInput__M13_encryptedItem(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DecryptItemOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_DecryptItemOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IDecryptItemOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DecryptItemOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DecryptItemOutput(); converted.PlaintextItem = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_DecryptItemOutput__M13_plaintextItem(concrete._plaintextItem);
      if (concrete._parsedHeader.is_Some) converted.ParsedHeader = (AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.ParsedHeader)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_DecryptItemOutput__M12_parsedHeader(concrete._parsedHeader); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IDecryptItemOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_DecryptItemOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DecryptItemOutput value)
    {
      value.Validate();
      AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.ParsedHeader var_parsedHeader = value.IsSetParsedHeader() ? value.ParsedHeader : (AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.ParsedHeader)null;
      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_DecryptItemOutput__M13_plaintextItem(value.PlaintextItem), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_DecryptItemOutput__M12_parsedHeader(var_parsedHeader));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.ParsedHeader FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_DecryptItemOutput__M12_parsedHeader(Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IParsedHeader> value)
    {
      return value.is_None ? (AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.ParsedHeader)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IParsedHeader> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_DecryptItemOutput__M12_parsedHeader(AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.ParsedHeader value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IParsedHeader>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IParsedHeader>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader((AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.ParsedHeader)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_DecryptItemOutput__M13_plaintextItem(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_DecryptItemOutput__M13_plaintextItem(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DynamoDbItemEncryptorConfig FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IDynamoDbItemEncryptorConfig value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DynamoDbItemEncryptorConfig converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DynamoDbItemEncryptorConfig(); converted.LogicalTableName = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_logicalTableName(concrete._logicalTableName);
      converted.PartitionKeyName = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_partitionKeyName(concrete._partitionKeyName);
      if (concrete._sortKeyName.is_Some) converted.SortKeyName = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M11_sortKeyName(concrete._sortKeyName);
      converted.AttributeActionsOnEncrypt = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M25_attributeActionsOnEncrypt(concrete._attributeActionsOnEncrypt);
      if (concrete._allowedUnsignedAttributes.is_Some) converted.AllowedUnsignedAttributes = (System.Collections.Generic.List<string>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M25_allowedUnsignedAttributes(concrete._allowedUnsignedAttributes);
      if (concrete._allowedUnsignedAttributePrefix.is_Some) converted.AllowedUnsignedAttributePrefix = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M30_allowedUnsignedAttributePrefix(concrete._allowedUnsignedAttributePrefix);
      if (concrete._algorithmSuiteId.is_Some) converted.AlgorithmSuiteId = (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_algorithmSuiteId(concrete._algorithmSuiteId);
      if (concrete._keyring.is_Some) converted.Keyring = (AWS.Cryptography.MaterialProviders.IKeyring)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M7_keyring(concrete._keyring);
      if (concrete._cmm.is_Some) converted.Cmm = (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M3_cmm(concrete._cmm);
      if (concrete._legacyOverride.is_Some) converted.LegacyOverride = (AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyOverride)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M14_legacyOverride(concrete._legacyOverride);
      if (concrete._plaintextOverride.is_Some) converted.PlaintextOverride = (AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M17_plaintextOverride(concrete._plaintextOverride); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IDynamoDbItemEncryptorConfig ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig(AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DynamoDbItemEncryptorConfig value)
    {
      value.Validate();
      string var_sortKeyName = value.IsSetSortKeyName() ? value.SortKeyName : (string)null;
      System.Collections.Generic.List<string> var_allowedUnsignedAttributes = value.IsSetAllowedUnsignedAttributes() ? value.AllowedUnsignedAttributes : (System.Collections.Generic.List<string>)null;
      string var_allowedUnsignedAttributePrefix = value.IsSetAllowedUnsignedAttributePrefix() ? value.AllowedUnsignedAttributePrefix : (string)null;
      AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId var_algorithmSuiteId = value.IsSetAlgorithmSuiteId() ? value.AlgorithmSuiteId : (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)null;
      AWS.Cryptography.MaterialProviders.IKeyring var_keyring = value.IsSetKeyring() ? value.Keyring : (AWS.Cryptography.MaterialProviders.IKeyring)null;
      AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager var_cmm = value.IsSetCmm() ? value.Cmm : (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)null;
      AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyOverride var_legacyOverride = value.IsSetLegacyOverride() ? value.LegacyOverride : (AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyOverride)null;
      AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride var_plaintextOverride = value.IsSetPlaintextOverride() ? value.PlaintextOverride : (AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride)null;
      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_logicalTableName(value.LogicalTableName), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_partitionKeyName(value.PartitionKeyName), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M11_sortKeyName(var_sortKeyName), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M25_attributeActionsOnEncrypt(value.AttributeActionsOnEncrypt), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M25_allowedUnsignedAttributes(var_allowedUnsignedAttributes), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M30_allowedUnsignedAttributePrefix(var_allowedUnsignedAttributePrefix), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_algorithmSuiteId(var_algorithmSuiteId), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M7_keyring(var_keyring), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M3_cmm(var_cmm), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M14_legacyOverride(var_legacyOverride), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M17_plaintextOverride(var_plaintextOverride));
    }
    public static AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_algorithmSuiteId(Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId> value)
    {
      return value.is_None ? (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_algorithmSuiteId(AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId((AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)value));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M30_allowedUnsignedAttributePrefix(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N6_smithy__N3_api__S6_String(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M30_allowedUnsignedAttributePrefix(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N6_smithy__N3_api__S6_String((string)value));
    }
    public static System.Collections.Generic.List<string> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M25_allowedUnsignedAttributes(Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<string>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M25_allowedUnsignedAttributes(System.Collections.Generic.List<string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<char>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList((System.Collections.Generic.List<string>)value));
    }
    public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M25_attributeActionsOnEncrypt(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_AttributeActions(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M25_attributeActionsOnEncrypt(System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_AttributeActions(value);
    }
    public static AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M3_cmm(Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager> value)
    {
      return value.is_None ? (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M3_cmm(AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference((AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)value));
    }
    public static AWS.Cryptography.MaterialProviders.IKeyring FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M7_keyring(Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring> value)
    {
      return value.is_None ? (AWS.Cryptography.MaterialProviders.IKeyring)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M7_keyring(AWS.Cryptography.MaterialProviders.IKeyring value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference((AWS.Cryptography.MaterialProviders.IKeyring)value));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyOverride FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M14_legacyOverride(Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILegacyOverride> value)
    {
      return value.is_None ? (AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyOverride)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_LegacyOverride(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILegacyOverride> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M14_legacyOverride(AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyOverride value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILegacyOverride>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILegacyOverride>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S14_LegacyOverride((AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyOverride)value));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_logicalTableName(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_logicalTableName(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_partitionKeyName(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_partitionKeyName(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M17_plaintextOverride(Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IPlaintextOverride> value)
    {
      return value.is_None ? (AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S17_PlaintextOverride(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IPlaintextOverride> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M17_plaintextOverride(AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IPlaintextOverride>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IPlaintextOverride>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S17_PlaintextOverride((AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride)value));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M11_sortKeyName(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M11_sortKeyName(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName((string)value));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DynamoDbItemEncryptorException FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S30_DynamoDbItemEncryptorException(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_DynamoDbItemEncryptorException value)
    {
      return new AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DynamoDbItemEncryptorException(
      FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S30_DynamoDbItemEncryptorException__M7_message(value._message)
      );
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_DynamoDbItemEncryptorException ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S30_DynamoDbItemEncryptorException(AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DynamoDbItemEncryptorException value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_DynamoDbItemEncryptorException(
      ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S30_DynamoDbItemEncryptorException__M7_message(value.Message)
      );
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S30_DynamoDbItemEncryptorException__M7_message(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S30_DynamoDbItemEncryptorException__M7_message(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.EncryptItemInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S16_EncryptItemInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IEncryptItemInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.EncryptItemInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.EncryptItemInput(); converted.PlaintextItem = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S16_EncryptItemInput__M13_plaintextItem(concrete._plaintextItem); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IEncryptItemInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S16_EncryptItemInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.EncryptItemInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S16_EncryptItemInput__M13_plaintextItem(value.PlaintextItem));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S16_EncryptItemInput__M13_plaintextItem(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S16_EncryptItemInput__M13_plaintextItem(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.EncryptItemOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_EncryptItemOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IEncryptItemOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.EncryptItemOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.EncryptItemOutput(); converted.EncryptedItem = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_EncryptItemOutput__M13_encryptedItem(concrete._encryptedItem);
      if (concrete._parsedHeader.is_Some) converted.ParsedHeader = (AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.ParsedHeader)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_EncryptItemOutput__M12_parsedHeader(concrete._parsedHeader); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IEncryptItemOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_EncryptItemOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.EncryptItemOutput value)
    {
      value.Validate();
      AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.ParsedHeader var_parsedHeader = value.IsSetParsedHeader() ? value.ParsedHeader : (AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.ParsedHeader)null;
      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_EncryptItemOutput__M13_encryptedItem(value.EncryptedItem), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_EncryptItemOutput__M12_parsedHeader(var_parsedHeader));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_EncryptItemOutput__M13_encryptedItem(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_EncryptItemOutput__M13_encryptedItem(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.ParsedHeader FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_EncryptItemOutput__M12_parsedHeader(Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IParsedHeader> value)
    {
      return value.is_None ? (AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.ParsedHeader)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IParsedHeader> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_EncryptItemOutput__M12_parsedHeader(AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.ParsedHeader value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IParsedHeader>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IParsedHeader>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader((AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.ParsedHeader)value));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.ParsedHeader FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IParsedHeader value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.ParsedHeader concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.ParsedHeader)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.ParsedHeader converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.ParsedHeader(); converted.AttributeActionsOnEncrypt = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M25_attributeActionsOnEncrypt(concrete._attributeActionsOnEncrypt);
      converted.AlgorithmSuiteId = (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M16_algorithmSuiteId(concrete._algorithmSuiteId);
      converted.EncryptedDataKeys = (System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M17_encryptedDataKeys(concrete._encryptedDataKeys);
      converted.StoredEncryptionContext = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M23_storedEncryptionContext(concrete._storedEncryptionContext);
      converted.EncryptionContext = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M17_encryptionContext(concrete._encryptionContext);
      converted.SelectorContext = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M15_selectorContext(concrete._selectorContext); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IParsedHeader ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader(AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.ParsedHeader value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.ParsedHeader(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M25_attributeActionsOnEncrypt(value.AttributeActionsOnEncrypt), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M16_algorithmSuiteId(value.AlgorithmSuiteId), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M17_encryptedDataKeys(value.EncryptedDataKeys), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M23_storedEncryptionContext(value.StoredEncryptionContext), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M17_encryptionContext(value.EncryptionContext), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M15_selectorContext(value.SelectorContext));
    }
    public static AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M16_algorithmSuiteId(software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value);
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M16_algorithmSuiteId(AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value);
    }
    public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M25_attributeActionsOnEncrypt(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_AttributeActions(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M25_attributeActionsOnEncrypt(System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S16_AttributeActions(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M17_encryptedDataKeys(Dafny.ISequence<software.amazon.cryptography.materialproviders.internaldafny.types._IEncryptedDataKey> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.materialproviders.internaldafny.types._IEncryptedDataKey> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M17_encryptedDataKeys(System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList(value);
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M17_encryptionContext(Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value);
    }
    public static Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M17_encryptionContext(System.Collections.Generic.Dictionary<string, string> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value);
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M15_selectorContext(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M15_selectorContext(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M23_storedEncryptionContext(Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value);
    }
    public static Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S12_ParsedHeader__M23_storedEncryptionContext(System.Collections.Generic.Dictionary<string, string> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredEncryption FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S29_StructuredEncryptionReference(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.IStructuredEncryptionClient value)
    {
      if (value is software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.IStructuredEncryptionClient dafnyValue)
      {
        return new AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredEncryption(dafnyValue);
      }
      throw new System.ArgumentException("Custom implementations of AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredEncryption are not supported yet");
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.IStructuredEncryptionClient ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S29_StructuredEncryptionReference(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredEncryption value)
    {
      if (value is AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredEncryption nativeValue)
      {
        return nativeValue.impl();
      }
      throw new System.ArgumentException("Custom implementations of AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredEncryption are not supported yet");
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
    public static AWS.Cryptography.MaterialProviders.EncryptedDataKey FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey(software.amazon.cryptography.materialproviders.internaldafny.types._IEncryptedDataKey value)
    {
      software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey concrete = (software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey)value; AWS.Cryptography.MaterialProviders.EncryptedDataKey converted = new AWS.Cryptography.MaterialProviders.EncryptedDataKey(); converted.KeyProviderId = (string)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey__M13_keyProviderId(concrete._keyProviderId);
      converted.KeyProviderInfo = (System.IO.MemoryStream)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey__M15_keyProviderInfo(concrete._keyProviderInfo);
      converted.Ciphertext = (System.IO.MemoryStream)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey__M10_ciphertext(concrete._ciphertext); return converted;
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types._IEncryptedDataKey ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey(AWS.Cryptography.MaterialProviders.EncryptedDataKey value)
    {
      value.Validate();

      return new software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey__M13_keyProviderId(value.KeyProviderId), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey__M15_keyProviderInfo(value.KeyProviderInfo), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey__M10_ciphertext(value.Ciphertext));
    }
    public static System.IO.MemoryStream FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey__M10_ciphertext(Dafny.ISequence<byte> value)
    {
      return FromDafny_N6_smithy__N3_api__S4_Blob(value);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey__M10_ciphertext(System.IO.MemoryStream value)
    {
      return ToDafny_N6_smithy__N3_api__S4_Blob(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey__M13_keyProviderId(Dafny.ISequence<byte> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_Utf8Bytes(value);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey__M13_keyProviderId(string value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_Utf8Bytes(value);
    }
    public static System.IO.MemoryStream FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey__M15_keyProviderInfo(Dafny.ISequence<byte> value)
    {
      return FromDafny_N6_smithy__N3_api__S4_Blob(value);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey__M15_keyProviderInfo(System.IO.MemoryStream value)
    {
      return ToDafny_N6_smithy__N3_api__S4_Blob(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey> FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList(Dafny.ISequence<software.amazon.cryptography.materialproviders.internaldafny.types._IEncryptedDataKey> value)
    {
      return new System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.materialproviders.internaldafny.types._IEncryptedDataKey> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList(System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.materialproviders.internaldafny.types._IEncryptedDataKey>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList__M6_member).ToArray());
    }
    public static AWS.Cryptography.MaterialProviders.EncryptedDataKey FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList__M6_member(software.amazon.cryptography.materialproviders.internaldafny.types._IEncryptedDataKey value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey(value);
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types._IEncryptedDataKey ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList__M6_member(AWS.Cryptography.MaterialProviders.EncryptedDataKey value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey(value);
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M3_key(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(System.Collections.Generic.Dictionary<string, string> value)
    {
      return Dafny.Map<Dafny.ISequence<byte>, Dafny.ISequence<byte>>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<byte>, Dafny.ISequence<byte>>(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M3_key(pair.Key), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M5_value(pair.Value))
     ));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M3_key(Dafny.ISequence<byte> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_Utf8Bytes(value);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M3_key(string value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_Utf8Bytes(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M5_value(Dafny.ISequence<byte> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_Utf8Bytes(value);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M5_value(string value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_Utf8Bytes(value);
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
    public static string FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_Utf8Bytes(Dafny.ISequence<byte> value)
    {
      System.Text.UTF8Encoding utf8 = new System.Text.UTF8Encoding(false, true);
      return utf8.GetString(value.Elements);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_Utf8Bytes(string value)
    {
      System.Text.UTF8Encoding utf8 = new System.Text.UTF8Encoding(false, true);
      return Dafny.Sequence<byte>.FromArray(utf8.GetBytes(value));
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
    public static string FromDafny_N6_smithy__N3_api__S6_String(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N6_smithy__N3_api__S6_String(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static System.Exception FromDafny_CommonError(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IError value)
    {
      switch (value)
      {
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_AwsCryptographyDbEncryptionSdkDynamoDb dafnyVal:
          return AWS.Cryptography.DbEncryptionSDK.DynamoDb.TypeConversion.FromDafny_CommonError(
            dafnyVal._AwsCryptographyDbEncryptionSdkDynamoDb
          );
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_AwsCryptographyDbEncryptionSdkStructuredEncryption dafnyVal:
          return AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.TypeConversion.FromDafny_CommonError(
            dafnyVal._AwsCryptographyDbEncryptionSdkStructuredEncryption
          );
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_AwsCryptographyMaterialProviders dafnyVal:
          return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_CommonError(
            dafnyVal._AwsCryptographyMaterialProviders
          );
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_AwsCryptographyPrimitives dafnyVal:
          return AWS.Cryptography.Primitives.TypeConversion.FromDafny_CommonError(
            dafnyVal._AwsCryptographyPrimitives
          );
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_ComAmazonawsDynamodb dafnyVal:
          return Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_CommonError(
            dafnyVal._ComAmazonawsDynamodb
          );
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_DynamoDbItemEncryptorException dafnyVal:
          return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S30_DynamoDbItemEncryptorException(dafnyVal);
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_CollectionOfErrors dafnyVal:
          return new CollectionOfErrors(
              new System.Collections.Generic.List<Exception>(dafnyVal.dtor_list.CloneAsArray()
                .Select(x => TypeConversion.FromDafny_CommonError(x))),
              new string(dafnyVal.dtor_message.Elements));
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_Opaque dafnyVal:
          return new OpaqueError(dafnyVal._obj);
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_OpaqueWithText dafnyVal:
          return new OpaqueWithTextError(dafnyVal._obj, dafnyVal._obj.ToString());
        default:
          // The switch MUST be complete for _IError, so `value` MUST NOT be an _IError. (How did you get here?)
          return new OpaqueError();
      }
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IError ToDafny_CommonError(System.Exception value)
    {
      switch (value.GetType().Namespace)
      {
        case "AWS.Cryptography.DbEncryptionSDK.StructuredEncryption":
          return software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error.create_AwsCryptographyDbEncryptionSdkStructuredEncryption(
            AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.TypeConversion.ToDafny_CommonError(value)
          );
        case "AWS.Cryptography.DbEncryptionSDK.DynamoDb":
          return software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error.create_AwsCryptographyDbEncryptionSdkDynamoDb(
            AWS.Cryptography.DbEncryptionSDK.DynamoDb.TypeConversion.ToDafny_CommonError(value)
          );
        case "AWS.Cryptography.MaterialProviders":
          return software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error.create_AwsCryptographyMaterialProviders(
            AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_CommonError(value)
          );
        case "Com.Amazonaws.Dynamodb":
          return software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error.create_ComAmazonawsDynamodb(
            Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_CommonError(value)
          );
      }
      switch (value)
      {
        case AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DynamoDbItemEncryptorException exception:
          return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S30_DynamoDbItemEncryptorException(exception);
        case CollectionOfErrors collectionOfErrors:
          return new software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_CollectionOfErrors(
            Dafny.Sequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IError>
              .FromArray(
                collectionOfErrors.list.Select
                    (x => TypeConversion.ToDafny_CommonError(x))
                  .ToArray()),
            Dafny.Sequence<char>.FromString(collectionOfErrors.Message)
          );
        // OpaqueError is redundant, but listed for completeness.
        case OpaqueError exception:
          return new software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_Opaque(exception);
        case System.Exception exception:
          return new software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_Opaque(exception);
        default:
          // The switch MUST be complete for System.Exception, so `value` MUST NOT be an System.Exception. (How did you get here?)
          return new software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_Opaque(value);
      }
    }
  }
}
