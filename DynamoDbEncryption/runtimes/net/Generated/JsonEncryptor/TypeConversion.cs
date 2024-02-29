// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System.Linq;
using System;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json
{
  public static class TypeConversion
  {
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Action FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S6_Action(software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IAction value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Action concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Action)value;
      var converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Action(); if (value.is_crypto)
      {
        converted.Crypto = FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S6_Action__M6_crypto(concrete.dtor_crypto);
        return converted;
      }
      if (value.is_esdk)
      {
        converted.Esdk = FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S6_Action__M4_esdk(concrete.dtor_esdk);
        return converted;
      }
      if (value.is_dbesdk)
      {
        converted.Dbesdk = FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S6_Action__M6_dbesdk(concrete.dtor_dbesdk);
        return converted;
      }
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Action state");
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IAction ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S6_Action(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Action value)
    {
      if (value.IsSetCrypto())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Action.create_crypto(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S6_Action__M6_crypto(value.Crypto));
      }
      if (value.IsSetEsdk())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Action.create_esdk(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S6_Action__M4_esdk(value.Esdk));
      }
      if (value.IsSetDbesdk())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Action.create_dbesdk(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S6_Action__M6_dbesdk(value.Dbesdk));
      }
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Action state");
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DecryptObjectInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S18_DecryptObjectInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IDecryptObjectInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.DecryptObjectInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.DecryptObjectInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DecryptObjectInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DecryptObjectInput(); converted.EncryptedObject = (AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Json)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S18_DecryptObjectInput__M15_encryptedObject(concrete._encryptedObject); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IDecryptObjectInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S18_DecryptObjectInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DecryptObjectInput value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.DecryptObjectInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S18_DecryptObjectInput__M15_encryptedObject(value.EncryptedObject));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DecryptObjectOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_DecryptObjectOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IDecryptObjectOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.DecryptObjectOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.DecryptObjectOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DecryptObjectOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DecryptObjectOutput(); converted.PlaintextObject = (AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Json)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_DecryptObjectOutput__M15_plaintextObject(concrete._plaintextObject);
      if (concrete._parsedHeader.is_Some) converted.ParsedHeader = (AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.ParsedHeader)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_DecryptObjectOutput__M12_parsedHeader(concrete._parsedHeader); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IDecryptObjectOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_DecryptObjectOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DecryptObjectOutput value)
    {
      AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.ParsedHeader var_parsedHeader = value.IsSetParsedHeader() ? value.ParsedHeader : (AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.ParsedHeader)null;
      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.DecryptObjectOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_DecryptObjectOutput__M15_plaintextObject(value.PlaintextObject), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_DecryptObjectOutput__M12_parsedHeader(var_parsedHeader));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.EncryptObjectInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S18_EncryptObjectInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IEncryptObjectInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.EncryptObjectInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.EncryptObjectInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.EncryptObjectInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.EncryptObjectInput(); converted.PlaintextObject = (AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Json)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S18_EncryptObjectInput__M15_plaintextObject(concrete._plaintextObject); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IEncryptObjectInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S18_EncryptObjectInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.EncryptObjectInput value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.EncryptObjectInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S18_EncryptObjectInput__M15_plaintextObject(value.PlaintextObject));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.EncryptObjectOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_EncryptObjectOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IEncryptObjectOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.EncryptObjectOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.EncryptObjectOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.EncryptObjectOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.EncryptObjectOutput(); converted.EncryptedObject = (AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Json)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_EncryptObjectOutput__M15_encryptedObject(concrete._encryptedObject);
      if (concrete._parsedHeader.is_Some) converted.ParsedHeader = (AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.ParsedHeader)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_EncryptObjectOutput__M12_parsedHeader(concrete._parsedHeader); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IEncryptObjectOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_EncryptObjectOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.EncryptObjectOutput value)
    {
      AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.ParsedHeader var_parsedHeader = value.IsSetParsedHeader() ? value.ParsedHeader : (AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.ParsedHeader)null;
      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.EncryptObjectOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_EncryptObjectOutput__M15_encryptedObject(value.EncryptedObject), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_EncryptObjectOutput__M12_parsedHeader(var_parsedHeader));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Json FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S4_Json(software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IJson value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Json concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Json)value;
      var converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Json(); if (value.is_utf8)
      {
        converted.Utf8 = FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S4_Json__M4_utf8(concrete.dtor_utf8);
        return converted;
      }
      if (value.is_text)
      {
        converted.Text = FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S4_Json__M4_text(concrete.dtor_text);
        return converted;
      }
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Json state");
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IJson ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S4_Json(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Json value)
    {
      if (value.IsSetUtf8())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Json.create_utf8(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S4_Json__M4_utf8(value.Utf8));
      }
      if (value.IsSetText())
      {
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Json.create_text(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S4_Json__M4_text(value.Text));
      }
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Json state");
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.JsonEncryptorConfig FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig(software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IJsonEncryptorConfig value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.JsonEncryptorConfig concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.JsonEncryptorConfig)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.JsonEncryptorConfig converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.JsonEncryptorConfig(); converted.LogicalTableName = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M16_logicalTableName(concrete._logicalTableName);
      converted.AttributeActionsOnEncrypt = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Action>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M25_attributeActionsOnEncrypt(concrete._attributeActionsOnEncrypt);
      if (concrete._allowedUnsignedAttributes.is_Some) converted.AllowedUnsignedAttributes = (System.Collections.Generic.List<string>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M25_allowedUnsignedAttributes(concrete._allowedUnsignedAttributes);
      if (concrete._allowedUnsignedAttributePrefix.is_Some) converted.AllowedUnsignedAttributePrefix = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M30_allowedUnsignedAttributePrefix(concrete._allowedUnsignedAttributePrefix);
      converted.Encrypt = (AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DbesdkEncrypt)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M7_encrypt(concrete._encrypt);
      if (concrete._decryptAs.is_Some) converted.DecryptAs = (System.Collections.Generic.List<string>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M9_decryptAs(concrete._decryptAs); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IJsonEncryptorConfig ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.JsonEncryptorConfig value)
    {
      System.Collections.Generic.List<string> var_allowedUnsignedAttributes = value.IsSetAllowedUnsignedAttributes() ? value.AllowedUnsignedAttributes : (System.Collections.Generic.List<string>)null;
      string var_allowedUnsignedAttributePrefix = value.IsSetAllowedUnsignedAttributePrefix() ? value.AllowedUnsignedAttributePrefix : (string)null;
      System.Collections.Generic.List<string> var_decryptAs = value.IsSetDecryptAs() ? value.DecryptAs : (System.Collections.Generic.List<string>)null;
      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.JsonEncryptorConfig(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M16_logicalTableName(value.LogicalTableName), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M25_attributeActionsOnEncrypt(value.AttributeActionsOnEncrypt), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M25_allowedUnsignedAttributes(var_allowedUnsignedAttributes), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M30_allowedUnsignedAttributePrefix(var_allowedUnsignedAttributePrefix), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M7_encrypt(value.Encrypt), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M9_decryptAs(var_decryptAs));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.JsonEncryptorException FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S22_JsonEncryptorException(software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error_JsonEncryptorException value)
    {
      return new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.JsonEncryptorException(
      FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S22_JsonEncryptorException__M7_message(value._message)
      );
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error_JsonEncryptorException ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S22_JsonEncryptorException(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.JsonEncryptorException value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error_JsonEncryptorException(
      ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S22_JsonEncryptorException__M7_message(value.Message)
      );
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S6_Action__M6_crypto(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_CryptoAction(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S6_Action__M6_crypto(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_CryptoAction(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.EsdkEncrypt FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S6_Action__M4_esdk(software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IEsdkEncrypt value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IEsdkEncrypt ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S6_Action__M4_esdk(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.EsdkEncrypt value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DbesdkEncrypt FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S6_Action__M6_dbesdk(software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IDbesdkEncrypt value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DbesdkEncrypt(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IDbesdkEncrypt ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S6_Action__M6_dbesdk(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DbesdkEncrypt value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DbesdkEncrypt(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Json FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S18_DecryptObjectInput__M15_encryptedObject(software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IJson value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S4_Json(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IJson ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S18_DecryptObjectInput__M15_encryptedObject(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Json value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S4_Json(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Json FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_DecryptObjectOutput__M15_plaintextObject(software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IJson value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S4_Json(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IJson ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_DecryptObjectOutput__M15_plaintextObject(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Json value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S4_Json(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.ParsedHeader FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_DecryptObjectOutput__M12_parsedHeader(Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IParsedHeader> value)
    {
      return value.is_None ? (AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.ParsedHeader)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IParsedHeader> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_DecryptObjectOutput__M12_parsedHeader(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.ParsedHeader value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IParsedHeader>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IParsedHeader>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader((AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.ParsedHeader)value));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Json FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S18_EncryptObjectInput__M15_plaintextObject(software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IJson value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S4_Json(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IJson ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S18_EncryptObjectInput__M15_plaintextObject(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Json value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S4_Json(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Json FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_EncryptObjectOutput__M15_encryptedObject(software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IJson value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S4_Json(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IJson ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_EncryptObjectOutput__M15_encryptedObject(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Json value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S4_Json(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.ParsedHeader FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_EncryptObjectOutput__M12_parsedHeader(Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IParsedHeader> value)
    {
      return value.is_None ? (AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.ParsedHeader)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IParsedHeader> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_EncryptObjectOutput__M12_parsedHeader(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.ParsedHeader value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IParsedHeader>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IParsedHeader>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader((AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.ParsedHeader)value));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S4_Json__M4_utf8(Dafny.ISequence<byte> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S9_Utf8Bytes(value);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S4_Json__M4_utf8(string value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S9_Utf8Bytes(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S4_Json__M4_text(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S4_Json__M4_text(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M16_logicalTableName(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M16_logicalTableName(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Action> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M25_attributeActionsOnEncrypt(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IAction> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S16_AttributeActions(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IAction> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M25_attributeActionsOnEncrypt(System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Action> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S16_AttributeActions(value);
    }
    public static System.Collections.Generic.List<string> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M25_allowedUnsignedAttributes(Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<string>)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S17_AttributeNameList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M25_allowedUnsignedAttributes(System.Collections.Generic.List<string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<char>>>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S17_AttributeNameList((System.Collections.Generic.List<string>)value));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M30_allowedUnsignedAttributePrefix(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N6_smithy__N3_api__S6_String(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M30_allowedUnsignedAttributePrefix(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N6_smithy__N3_api__S6_String((string)value));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DbesdkEncrypt FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M7_encrypt(software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IDbesdkEncrypt value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DbesdkEncrypt(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IDbesdkEncrypt ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M7_encrypt(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DbesdkEncrypt value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DbesdkEncrypt(value);
    }
    public static System.Collections.Generic.List<string> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M9_decryptAs(Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<string>)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DecryptAsList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig__M9_decryptAs(System.Collections.Generic.List<string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<char>>>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DecryptAsList((System.Collections.Generic.List<string>)value));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S22_JsonEncryptorException__M7_message(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S22_JsonEncryptorException__M7_message(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
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
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.EsdkEncrypt FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt(software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IEsdkEncrypt value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.EsdkEncrypt concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.EsdkEncrypt)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.EsdkEncrypt converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.EsdkEncrypt(); if (concrete._encryptionContext.is_Some) converted.EncryptionContext = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt__M17_encryptionContext(concrete._encryptionContext);
      if (concrete._materialsManager.is_Some) converted.MaterialsManager = (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt__M16_materialsManager(concrete._materialsManager);
      if (concrete._keyring.is_Some) converted.Keyring = (AWS.Cryptography.MaterialProviders.IKeyring)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt__M7_keyring(concrete._keyring);
      if (concrete._algorithmSuiteId.is_Some) converted.AlgorithmSuiteId = (AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt__M16_algorithmSuiteId(concrete._algorithmSuiteId);
      if (concrete._frameLength.is_Some) converted.FrameLength = (long)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt__M11_frameLength(concrete._frameLength); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IEsdkEncrypt ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.EsdkEncrypt value)
    {
      System.Collections.Generic.Dictionary<string, string> var_encryptionContext = value.IsSetEncryptionContext() ? value.EncryptionContext : (System.Collections.Generic.Dictionary<string, string>)null;
      AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager var_materialsManager = value.IsSetMaterialsManager() ? value.MaterialsManager : (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)null;
      AWS.Cryptography.MaterialProviders.IKeyring var_keyring = value.IsSetKeyring() ? value.Keyring : (AWS.Cryptography.MaterialProviders.IKeyring)null;
      AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId var_algorithmSuiteId = value.IsSetAlgorithmSuiteId() ? value.AlgorithmSuiteId : (AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId)null;
      long? var_frameLength = value.IsSetFrameLength() ? value.FrameLength : (long?)null;
      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.EsdkEncrypt(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt__M17_encryptionContext(var_encryptionContext), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt__M16_materialsManager(var_materialsManager), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt__M7_keyring(var_keyring), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt__M16_algorithmSuiteId(var_algorithmSuiteId), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt__M11_frameLength(var_frameLength));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DbesdkEncrypt FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DbesdkEncrypt(software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IDbesdkEncrypt value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.DbesdkEncrypt concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.DbesdkEncrypt)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DbesdkEncrypt converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DbesdkEncrypt(); if (concrete._keyring.is_Some) converted.Keyring = (AWS.Cryptography.MaterialProviders.IKeyring)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DbesdkEncrypt__M7_keyring(concrete._keyring);
      if (concrete._cmm.is_Some) converted.Cmm = (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DbesdkEncrypt__M3_cmm(concrete._cmm);
      if (concrete._algorithmSuiteId.is_Some) converted.AlgorithmSuiteId = (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DbesdkEncrypt__M16_algorithmSuiteId(concrete._algorithmSuiteId); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IDbesdkEncrypt ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DbesdkEncrypt(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DbesdkEncrypt value)
    {
      AWS.Cryptography.MaterialProviders.IKeyring var_keyring = value.IsSetKeyring() ? value.Keyring : (AWS.Cryptography.MaterialProviders.IKeyring)null;
      AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager var_cmm = value.IsSetCmm() ? value.Cmm : (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)null;
      AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId var_algorithmSuiteId = value.IsSetAlgorithmSuiteId() ? value.AlgorithmSuiteId : (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)null;
      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.DbesdkEncrypt(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DbesdkEncrypt__M7_keyring(var_keyring), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DbesdkEncrypt__M3_cmm(var_cmm), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DbesdkEncrypt__M16_algorithmSuiteId(var_algorithmSuiteId));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.ParsedHeader FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader(software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IParsedHeader value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.ParsedHeader concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.ParsedHeader)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.ParsedHeader converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.ParsedHeader(); converted.AttributeActionsOnEncrypt = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Action>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader__M25_attributeActionsOnEncrypt(concrete._attributeActionsOnEncrypt);
      converted.AlgorithmSuiteId = (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader__M16_algorithmSuiteId(concrete._algorithmSuiteId);
      converted.EncryptedDataKeys = (System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader__M17_encryptedDataKeys(concrete._encryptedDataKeys);
      converted.StoredEncryptionContext = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader__M23_storedEncryptionContext(concrete._storedEncryptionContext);
      converted.EncryptionContext = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader__M17_encryptionContext(concrete._encryptionContext); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IParsedHeader ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.ParsedHeader value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.ParsedHeader(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader__M25_attributeActionsOnEncrypt(value.AttributeActionsOnEncrypt), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader__M16_algorithmSuiteId(value.AlgorithmSuiteId), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader__M17_encryptedDataKeys(value.EncryptedDataKeys), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader__M23_storedEncryptionContext(value.StoredEncryptionContext), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader__M17_encryptionContext(value.EncryptionContext));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S9_Utf8Bytes(Dafny.ISequence<byte> value)
    {
      System.Text.UTF8Encoding utf8 = new System.Text.UTF8Encoding(false, true);
      return utf8.GetString(value.Elements);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S9_Utf8Bytes(string value)
    {
      System.Text.UTF8Encoding utf8 = new System.Text.UTF8Encoding(false, true);
      return Dafny.Sequence<byte>.FromArray(utf8.GetBytes(value));
    }
    public static string FromDafny_N6_smithy__N3_api__S6_String(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N6_smithy__N3_api__S6_String(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Action> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S16_AttributeActions(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IAction> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S16_AttributeActions__M3_key(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S16_AttributeActions__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IAction> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S16_AttributeActions(System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Action> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IAction>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IAction>(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S16_AttributeActions__M3_key(pair.Key), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S16_AttributeActions__M5_value(pair.Value))
     ));
    }
    public static System.Collections.Generic.List<string> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S17_AttributeNameList(Dafny.ISequence<Dafny.ISequence<char>> value)
    {
      return new System.Collections.Generic.List<string>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S17_AttributeNameList__M6_member));
    }
    public static Dafny.ISequence<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S17_AttributeNameList(System.Collections.Generic.List<string> value)
    {
      return Dafny.Sequence<Dafny.ISequence<char>>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S17_AttributeNameList__M6_member).ToArray());
    }
    public static System.Collections.Generic.List<string> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DecryptAsList(Dafny.ISequence<Dafny.ISequence<char>> value)
    {
      return new System.Collections.Generic.List<string>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DecryptAsList__M6_member));
    }
    public static Dafny.ISequence<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DecryptAsList(System.Collections.Generic.List<string> value)
    {
      return Dafny.Sequence<Dafny.ISequence<char>>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DecryptAsList__M6_member).ToArray());
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt__M17_encryptionContext(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, string>)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt__M17_encryptionContext(System.Collections.Generic.Dictionary<string, string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext((System.Collections.Generic.Dictionary<string, string>)value));
    }
    public static AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt__M16_materialsManager(Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager> value)
    {
      return value.is_None ? (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt__M16_materialsManager(AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference((AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)value));
    }
    public static AWS.Cryptography.MaterialProviders.IKeyring FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt__M7_keyring(Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring> value)
    {
      return value.is_None ? (AWS.Cryptography.MaterialProviders.IKeyring)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt__M7_keyring(AWS.Cryptography.MaterialProviders.IKeyring value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference((AWS.Cryptography.MaterialProviders.IKeyring)value));
    }
    public static AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt__M16_algorithmSuiteId(Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types._IESDKAlgorithmSuiteId> value)
    {
      return value.is_None ? (AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_ESDKAlgorithmSuiteId(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types._IESDKAlgorithmSuiteId> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt__M16_algorithmSuiteId(AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types._IESDKAlgorithmSuiteId>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types._IESDKAlgorithmSuiteId>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_ESDKAlgorithmSuiteId((AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId)value));
    }
    public static long? FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt__M11_frameLength(Wrappers_Compile._IOption<long> value)
    {
      return value.is_None ? (long?)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_FrameLength(value.Extract());
    }
    public static Wrappers_Compile._IOption<long> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_EsdkEncrypt__M11_frameLength(long? value)
    {
      return value == null ? Wrappers_Compile.Option<long>.create_None() : Wrappers_Compile.Option<long>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_FrameLength((long)value));
    }
    public static AWS.Cryptography.MaterialProviders.IKeyring FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DbesdkEncrypt__M7_keyring(Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring> value)
    {
      return value.is_None ? (AWS.Cryptography.MaterialProviders.IKeyring)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DbesdkEncrypt__M7_keyring(AWS.Cryptography.MaterialProviders.IKeyring value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference((AWS.Cryptography.MaterialProviders.IKeyring)value));
    }
    public static AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DbesdkEncrypt__M3_cmm(Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager> value)
    {
      return value.is_None ? (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DbesdkEncrypt__M3_cmm(AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference((AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)value));
    }
    public static AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DbesdkEncrypt__M16_algorithmSuiteId(Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId> value)
    {
      return value.is_None ? (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DbesdkEncrypt__M16_algorithmSuiteId(AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId((AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)value));
    }
    public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Action> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader__M25_attributeActionsOnEncrypt(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IAction> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S16_AttributeActions(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IAction> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader__M25_attributeActionsOnEncrypt(System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Action> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S16_AttributeActions(value);
    }
    public static AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader__M16_algorithmSuiteId(software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value);
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader__M16_algorithmSuiteId(AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader__M17_encryptedDataKeys(Dafny.ISequence<software.amazon.cryptography.materialproviders.internaldafny.types._IEncryptedDataKey> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.materialproviders.internaldafny.types._IEncryptedDataKey> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader__M17_encryptedDataKeys(System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList(value);
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader__M23_storedEncryptionContext(Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value);
    }
    public static Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader__M23_storedEncryptionContext(System.Collections.Generic.Dictionary<string, string> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value);
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader__M17_encryptionContext(Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value);
    }
    public static Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S12_ParsedHeader__M17_encryptionContext(System.Collections.Generic.Dictionary<string, string> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S16_AttributeActions__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S16_AttributeActions__M3_key(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Action FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S16_AttributeActions__M5_value(software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IAction value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S6_Action(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IAction ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S16_AttributeActions__M5_value(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Action value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S6_Action(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S17_AttributeNameList__M6_member(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S17_AttributeNameList__M6_member(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DecryptAsList__M6_member(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S13_DecryptAsList__M6_member(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
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
    public static AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_ESDKAlgorithmSuiteId(software.amazon.cryptography.materialproviders.internaldafny.types._IESDKAlgorithmSuiteId value)
    {
      if (value.is_ALG__AES__128__GCM__IV12__TAG16__NO__KDF) return AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId.ALG_AES_128_GCM_IV12_TAG16_NO_KDF;
      if (value.is_ALG__AES__192__GCM__IV12__TAG16__NO__KDF) return AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId.ALG_AES_192_GCM_IV12_TAG16_NO_KDF;
      if (value.is_ALG__AES__256__GCM__IV12__TAG16__NO__KDF) return AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId.ALG_AES_256_GCM_IV12_TAG16_NO_KDF;
      if (value.is_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256) return AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId.ALG_AES_128_GCM_IV12_TAG16_HKDF_SHA256;
      if (value.is_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA256) return AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId.ALG_AES_192_GCM_IV12_TAG16_HKDF_SHA256;
      if (value.is_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA256) return AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId.ALG_AES_256_GCM_IV12_TAG16_HKDF_SHA256;
      if (value.is_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256__ECDSA__P256) return AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId.ALG_AES_128_GCM_IV12_TAG16_HKDF_SHA256_ECDSA_P256;
      if (value.is_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384) return AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId.ALG_AES_192_GCM_IV12_TAG16_HKDF_SHA384_ECDSA_P384;
      if (value.is_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384) return AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId.ALG_AES_256_GCM_IV12_TAG16_HKDF_SHA384_ECDSA_P384;
      if (value.is_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY) return AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY;
      if (value.is_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384) return AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384;
      throw new System.ArgumentException("Invalid AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId value");
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types._IESDKAlgorithmSuiteId ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_ESDKAlgorithmSuiteId(AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId value)
    {
      if (AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId.ALG_AES_128_GCM_IV12_TAG16_NO_KDF.Equals(value)) return software.amazon.cryptography.materialproviders.internaldafny.types.ESDKAlgorithmSuiteId.create_ALG__AES__128__GCM__IV12__TAG16__NO__KDF();
      if (AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId.ALG_AES_192_GCM_IV12_TAG16_NO_KDF.Equals(value)) return software.amazon.cryptography.materialproviders.internaldafny.types.ESDKAlgorithmSuiteId.create_ALG__AES__192__GCM__IV12__TAG16__NO__KDF();
      if (AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId.ALG_AES_256_GCM_IV12_TAG16_NO_KDF.Equals(value)) return software.amazon.cryptography.materialproviders.internaldafny.types.ESDKAlgorithmSuiteId.create_ALG__AES__256__GCM__IV12__TAG16__NO__KDF();
      if (AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId.ALG_AES_128_GCM_IV12_TAG16_HKDF_SHA256.Equals(value)) return software.amazon.cryptography.materialproviders.internaldafny.types.ESDKAlgorithmSuiteId.create_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256();
      if (AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId.ALG_AES_192_GCM_IV12_TAG16_HKDF_SHA256.Equals(value)) return software.amazon.cryptography.materialproviders.internaldafny.types.ESDKAlgorithmSuiteId.create_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA256();
      if (AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId.ALG_AES_256_GCM_IV12_TAG16_HKDF_SHA256.Equals(value)) return software.amazon.cryptography.materialproviders.internaldafny.types.ESDKAlgorithmSuiteId.create_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA256();
      if (AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId.ALG_AES_128_GCM_IV12_TAG16_HKDF_SHA256_ECDSA_P256.Equals(value)) return software.amazon.cryptography.materialproviders.internaldafny.types.ESDKAlgorithmSuiteId.create_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256__ECDSA__P256();
      if (AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId.ALG_AES_192_GCM_IV12_TAG16_HKDF_SHA384_ECDSA_P384.Equals(value)) return software.amazon.cryptography.materialproviders.internaldafny.types.ESDKAlgorithmSuiteId.create_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384();
      if (AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId.ALG_AES_256_GCM_IV12_TAG16_HKDF_SHA384_ECDSA_P384.Equals(value)) return software.amazon.cryptography.materialproviders.internaldafny.types.ESDKAlgorithmSuiteId.create_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384();
      if (AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY.Equals(value)) return software.amazon.cryptography.materialproviders.internaldafny.types.ESDKAlgorithmSuiteId.create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY();
      if (AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384.Equals(value)) return software.amazon.cryptography.materialproviders.internaldafny.types.ESDKAlgorithmSuiteId.create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384();
      throw new System.ArgumentException("Invalid AWS.Cryptography.MaterialProviders.ESDKAlgorithmSuiteId value");
    }
    public static long FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_FrameLength(long value)
    {
      return value;
    }
    public static long ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S11_FrameLength(long value)
    {
      return value;
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
    public static System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey> FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList(Dafny.ISequence<software.amazon.cryptography.materialproviders.internaldafny.types._IEncryptedDataKey> value)
    {
      return new System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.materialproviders.internaldafny.types._IEncryptedDataKey> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList(System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.materialproviders.internaldafny.types._IEncryptedDataKey>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList__M6_member).ToArray());
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
    public static AWS.Cryptography.MaterialProviders.EncryptedDataKey FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList__M6_member(software.amazon.cryptography.materialproviders.internaldafny.types._IEncryptedDataKey value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey(value);
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types._IEncryptedDataKey ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList__M6_member(AWS.Cryptography.MaterialProviders.EncryptedDataKey value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey(value);
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
    public static AWS.Cryptography.MaterialProviders.EncryptedDataKey FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey(software.amazon.cryptography.materialproviders.internaldafny.types._IEncryptedDataKey value)
    {
      software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey concrete = (software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey)value; AWS.Cryptography.MaterialProviders.EncryptedDataKey converted = new AWS.Cryptography.MaterialProviders.EncryptedDataKey(); converted.KeyProviderId = (string)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey__M13_keyProviderId(concrete._keyProviderId);
      converted.KeyProviderInfo = (System.IO.MemoryStream)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey__M15_keyProviderInfo(concrete._keyProviderInfo);
      converted.Ciphertext = (System.IO.MemoryStream)FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey__M10_ciphertext(concrete._ciphertext); return converted;
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types._IEncryptedDataKey ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey(AWS.Cryptography.MaterialProviders.EncryptedDataKey value)
    {

      return new software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey__M13_keyProviderId(value.KeyProviderId), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey__M15_keyProviderInfo(value.KeyProviderInfo), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey__M10_ciphertext(value.Ciphertext));
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
    public static System.IO.MemoryStream FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey__M10_ciphertext(Dafny.ISequence<byte> value)
    {
      return FromDafny_N6_smithy__N3_api__S4_Blob(value);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_EncryptedDataKey__M10_ciphertext(System.IO.MemoryStream value)
    {
      return ToDafny_N6_smithy__N3_api__S4_Blob(value);
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
    public static System.Exception FromDafny_CommonError(software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IError value)
    {
      switch (value)
      {
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error_AwsCryptographyDbEncryptionSdkStructuredEncryption dafnyVal:
          return AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.TypeConversion.FromDafny_CommonError(
            dafnyVal._AwsCryptographyDbEncryptionSdkStructuredEncryption
          );
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error_AwsCryptographyMaterialProviders dafnyVal:
          return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_CommonError(
            dafnyVal._AwsCryptographyMaterialProviders
          );
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error_AwsCryptographyPrimitives dafnyVal:
          return AWS.Cryptography.Primitives.TypeConversion.FromDafny_CommonError(
            dafnyVal._AwsCryptographyPrimitives
          );
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error_JsonEncryptorException dafnyVal:
          return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S22_JsonEncryptorException(dafnyVal);
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error_CollectionOfErrors dafnyVal:
          return new CollectionOfErrors(
              new System.Collections.Generic.List<Exception>(dafnyVal.dtor_list.CloneAsArray()
                .Select(x => TypeConversion.FromDafny_CommonError(x))),
              new string(dafnyVal.dtor_message.Elements));
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error_Opaque dafnyVal:
          return new OpaqueError(dafnyVal._obj);
        default:
          // The switch MUST be complete for _IError, so `value` MUST NOT be an _IError. (How did you get here?)
          return new OpaqueError();
      }
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IError ToDafny_CommonError(System.Exception value)
    {
      switch (value.GetType().Namespace)
      {
        case "AWS.Cryptography.DbEncryptionSDK.StructuredEncryption":
          return software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error.create_AwsCryptographyDbEncryptionSdkStructuredEncryption(
            AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.TypeConversion.ToDafny_CommonError(value)
          );
        case "AWS.Cryptography.MaterialProviders":
          return software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error.create_AwsCryptographyMaterialProviders(
            AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_CommonError(value)
          );
      }
      switch (value)
      {
        case AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.JsonEncryptorException exception:
          return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S22_JsonEncryptorException(exception);
        case CollectionOfErrors collectionOfErrors:
          return new software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error_CollectionOfErrors(
            Dafny.Sequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IError>
              .FromArray(
                collectionOfErrors.list.Select
                    (x => TypeConversion.ToDafny_CommonError(x))
                  .ToArray()),
            Dafny.Sequence<char>.FromString(collectionOfErrors.Message)
          );
        // OpaqueError is redundant, but listed for completeness.
        case OpaqueError exception:
          return new software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error_Opaque(exception);
        case System.Exception exception:
          return new software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error_Opaque(exception);
        default:
          // The switch MUST be complete for System.Exception, so `value` MUST NOT be an System.Exception. (How did you get here?)
          return new software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error_Opaque(value);
      }
    }
  }
}
