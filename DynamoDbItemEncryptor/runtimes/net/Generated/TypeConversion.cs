// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System.Linq;
using System;
namespace AWS.Cryptography.DynamoDbItemEncryptor
{
  public static class TypeConversion
  {
    internal static AWS.Cryptography.DynamoDbItemEncryptor.DecryptItemInput FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_DecryptItemInput(Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types._IDecryptItemInput value)
    {
      Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.DecryptItemInput concrete = (Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.DecryptItemInput)value; AWS.Cryptography.DynamoDbItemEncryptor.DecryptItemInput converted = new AWS.Cryptography.DynamoDbItemEncryptor.DecryptItemInput(); converted.EncryptedItem = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_DecryptItemInput__M13_encryptedItem(concrete._encryptedItem); return converted;
    }
    internal static Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types._IDecryptItemInput ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_DecryptItemInput(AWS.Cryptography.DynamoDbItemEncryptor.DecryptItemInput value)
    {

      return new Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.DecryptItemInput(ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_DecryptItemInput__M13_encryptedItem(value.EncryptedItem));
    }
    internal static AWS.Cryptography.DynamoDbItemEncryptor.DecryptItemOutput FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S17_DecryptItemOutput(Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types._IDecryptItemOutput value)
    {
      Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.DecryptItemOutput concrete = (Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.DecryptItemOutput)value; AWS.Cryptography.DynamoDbItemEncryptor.DecryptItemOutput converted = new AWS.Cryptography.DynamoDbItemEncryptor.DecryptItemOutput(); converted.PlaintextItem = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S17_DecryptItemOutput__M13_plaintextItem(concrete._plaintextItem); return converted;
    }
    internal static Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types._IDecryptItemOutput ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S17_DecryptItemOutput(AWS.Cryptography.DynamoDbItemEncryptor.DecryptItemOutput value)
    {

      return new Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.DecryptItemOutput(ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S17_DecryptItemOutput__M13_plaintextItem(value.PlaintextItem));
    }
    internal static AWS.Cryptography.DynamoDbItemEncryptor.DynamoDbItemEncryptorConfig FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig(Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types._IDynamoDbItemEncryptorConfig value)
    {
      Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.DynamoDbItemEncryptorConfig concrete = (Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.DynamoDbItemEncryptorConfig)value; AWS.Cryptography.DynamoDbItemEncryptor.DynamoDbItemEncryptorConfig converted = new AWS.Cryptography.DynamoDbItemEncryptor.DynamoDbItemEncryptorConfig(); converted.TableName = (string)FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M9_tableName(concrete._tableName);
      converted.PartitionKeyName = (string)FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_partitionKeyName(concrete._partitionKeyName);
      if (concrete._sortKeyName.is_Some) converted.SortKeyName = (string)FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M11_sortKeyName(concrete._sortKeyName);
      converted.AttributeActions = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction>)FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_attributeActions(concrete._attributeActions);
      if (concrete._allowedUnauthenticatedAttributes.is_Some) converted.AllowedUnauthenticatedAttributes = (System.Collections.Generic.List<string>)FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M32_allowedUnauthenticatedAttributes(concrete._allowedUnauthenticatedAttributes);
      if (concrete._allowedUnauthenticatedAttributePrefix.is_Some) converted.AllowedUnauthenticatedAttributePrefix = (string)FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M37_allowedUnauthenticatedAttributePrefix(concrete._allowedUnauthenticatedAttributePrefix);
      if (concrete._algorithmSuiteId.is_Some) converted.AlgorithmSuiteId = (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_algorithmSuiteId(concrete._algorithmSuiteId);
      if (concrete._keyring.is_Some) converted.Keyring = (AWS.Cryptography.MaterialProviders.IKeyring)FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M7_keyring(concrete._keyring);
      if (concrete._cmm.is_Some) converted.Cmm = (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M3_cmm(concrete._cmm); return converted;
    }
    internal static Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types._IDynamoDbItemEncryptorConfig ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig(AWS.Cryptography.DynamoDbItemEncryptor.DynamoDbItemEncryptorConfig value)
    {
      string var_sortKeyName = value.IsSetSortKeyName() ? value.SortKeyName : (string)null;
      System.Collections.Generic.List<string> var_allowedUnauthenticatedAttributes = value.IsSetAllowedUnauthenticatedAttributes() ? value.AllowedUnauthenticatedAttributes : (System.Collections.Generic.List<string>)null;
      string var_allowedUnauthenticatedAttributePrefix = value.IsSetAllowedUnauthenticatedAttributePrefix() ? value.AllowedUnauthenticatedAttributePrefix : (string)null;
      AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId var_algorithmSuiteId = value.IsSetAlgorithmSuiteId() ? value.AlgorithmSuiteId : (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)null;
      AWS.Cryptography.MaterialProviders.IKeyring var_keyring = value.IsSetKeyring() ? value.Keyring : (AWS.Cryptography.MaterialProviders.IKeyring)null;
      AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager var_cmm = value.IsSetCmm() ? value.Cmm : (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)null;
      return new Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.DynamoDbItemEncryptorConfig(ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M9_tableName(value.TableName), ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_partitionKeyName(value.PartitionKeyName), ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M11_sortKeyName(var_sortKeyName), ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_attributeActions(value.AttributeActions), ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M32_allowedUnauthenticatedAttributes(var_allowedUnauthenticatedAttributes), ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M37_allowedUnauthenticatedAttributePrefix(var_allowedUnauthenticatedAttributePrefix), ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_algorithmSuiteId(var_algorithmSuiteId), ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M7_keyring(var_keyring), ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M3_cmm(var_cmm));
    }
    internal static AWS.Cryptography.DynamoDbItemEncryptor.DynamoDbItemEncryptorException FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S30_DynamoDbItemEncryptorException(Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.Error_DynamoDbItemEncryptorException value)
    {
      return new AWS.Cryptography.DynamoDbItemEncryptor.DynamoDbItemEncryptorException(
      FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S30_DynamoDbItemEncryptorException__M7_message(value._message)
      );
    }
    internal static Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.Error_DynamoDbItemEncryptorException ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S30_DynamoDbItemEncryptorException(AWS.Cryptography.DynamoDbItemEncryptor.DynamoDbItemEncryptorException value)
    {

      return new Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.Error_DynamoDbItemEncryptorException(
      ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S30_DynamoDbItemEncryptorException__M7_message(value.Message)
      );
    }
    internal static AWS.Cryptography.DynamoDbItemEncryptor.EncryptItemInput FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_EncryptItemInput(Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types._IEncryptItemInput value)
    {
      Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.EncryptItemInput concrete = (Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.EncryptItemInput)value; AWS.Cryptography.DynamoDbItemEncryptor.EncryptItemInput converted = new AWS.Cryptography.DynamoDbItemEncryptor.EncryptItemInput(); converted.PlaintextItem = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_EncryptItemInput__M13_plaintextItem(concrete._plaintextItem); return converted;
    }
    internal static Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types._IEncryptItemInput ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_EncryptItemInput(AWS.Cryptography.DynamoDbItemEncryptor.EncryptItemInput value)
    {

      return new Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.EncryptItemInput(ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_EncryptItemInput__M13_plaintextItem(value.PlaintextItem));
    }
    internal static AWS.Cryptography.DynamoDbItemEncryptor.EncryptItemOutput FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S17_EncryptItemOutput(Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types._IEncryptItemOutput value)
    {
      Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.EncryptItemOutput concrete = (Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.EncryptItemOutput)value; AWS.Cryptography.DynamoDbItemEncryptor.EncryptItemOutput converted = new AWS.Cryptography.DynamoDbItemEncryptor.EncryptItemOutput(); converted.EncryptedItem = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S17_EncryptItemOutput__M13_encryptedItem(concrete._encryptedItem); return converted;
    }
    internal static Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types._IEncryptItemOutput ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S17_EncryptItemOutput(AWS.Cryptography.DynamoDbItemEncryptor.EncryptItemOutput value)
    {

      return new Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.EncryptItemOutput(ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S17_EncryptItemOutput__M13_encryptedItem(value.EncryptedItem));
    }
    internal static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_DecryptItemInput__M13_encryptedItem(Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    internal static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_DecryptItemInput__M13_encryptedItem(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    internal static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S17_DecryptItemOutput__M13_plaintextItem(Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    internal static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S17_DecryptItemOutput__M13_plaintextItem(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    internal static string FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M9_tableName(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(value);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M9_tableName(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(value);
    }
    internal static string FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_partitionKeyName(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(value);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_partitionKeyName(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(value);
    }
    internal static string FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M11_sortKeyName(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(value.Extract());
    }
    internal static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M11_sortKeyName(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName((string)value));
    }
    internal static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_attributeActions(Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_AttributeActions(value);
    }
    internal static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_attributeActions(System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_AttributeActions(value);
    }
    internal static System.Collections.Generic.List<string> FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M32_allowedUnauthenticatedAttributes(Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<string>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList(value.Extract());
    }
    internal static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M32_allowedUnauthenticatedAttributes(System.Collections.Generic.List<string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<char>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList((System.Collections.Generic.List<string>)value));
    }
    internal static string FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M37_allowedUnauthenticatedAttributePrefix(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N6_smithy__N3_api__S6_String(value.Extract());
    }
    internal static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M37_allowedUnauthenticatedAttributePrefix(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N6_smithy__N3_api__S6_String((string)value));
    }
    internal static AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_algorithmSuiteId(Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId> value)
    {
      return value.is_None ? (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value.Extract());
    }
    internal static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId> ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_algorithmSuiteId(AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId((AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)value));
    }
    internal static AWS.Cryptography.MaterialProviders.IKeyring FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M7_keyring(Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring> value)
    {
      return value.is_None ? (AWS.Cryptography.MaterialProviders.IKeyring)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference(value.Extract());
    }
    internal static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring> ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M7_keyring(AWS.Cryptography.MaterialProviders.IKeyring value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference((AWS.Cryptography.MaterialProviders.IKeyring)value));
    }
    internal static AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M3_cmm(Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager> value)
    {
      return value.is_None ? (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value.Extract());
    }
    internal static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager> ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig__M3_cmm(AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference((AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)value));
    }
    internal static string FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S30_DynamoDbItemEncryptorException__M7_message(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S30_DynamoDbItemEncryptorException__M7_message(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    internal static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_EncryptItemInput__M13_plaintextItem(Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    internal static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_EncryptItemInput__M13_plaintextItem(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    internal static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S17_EncryptItemOutput__M13_encryptedItem(Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    internal static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S17_EncryptItemOutput__M13_encryptedItem(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    internal static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M5_value(pair.Cdr));
    }
    internal static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M5_value(pair.Value))
     ));
    }
    internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    internal static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_AttributeActions(Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_AttributeActions__M3_key(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_AttributeActions__M5_value(pair.Cdr));
    }
    internal static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_AttributeActions(System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction>(ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_AttributeActions__M3_key(pair.Key), ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_AttributeActions__M5_value(pair.Value))
     ));
    }
    internal static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList(Dafny.ISequence<Dafny.ISequence<char>> value)
    {
      return new System.Collections.Generic.List<string>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList__M6_member));
    }
    internal static Dafny.ISequence<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList(System.Collections.Generic.List<string> value)
    {
      return Dafny.Sequence<Dafny.ISequence<char>>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList__M6_member).ToArray());
    }
    internal static string FromDafny_N6_smithy__N3_api__S6_String(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    internal static Dafny.ISequence<char> ToDafny_N6_smithy__N3_api__S6_String(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    internal static AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId value)
    {
      if (value.is_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__SYMSIG__HMAC__SHA384) return AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384;
      if (value.is_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384) return AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384;
      throw new System.ArgumentException("Invalid AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId value");
    }
    internal static Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId value)
    {
      if (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384.Equals(value)) return Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId.create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__SYMSIG__HMAC__SHA384();
      if (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384.Equals(value)) return Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId.create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384();
      throw new System.ArgumentException("Invalid AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId value");
    }
    internal static AWS.Cryptography.MaterialProviders.IKeyring FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference(Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring value)
    {
      // This is converting a reference type in a dependant module.
      // Therefore it defers to the dependant module for conversion
      return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference(value);
    }
    internal static Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference(AWS.Cryptography.MaterialProviders.IKeyring value)
    {
      // This is converting a reference type in a dependant module.
      // Therefore it defers to the dependant module for conversion
      return AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference(value);
    }
    internal static AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager value)
    {
      // This is converting a reference type in a dependant module.
      // Therefore it defers to the dependant module for conversion
      return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value);
    }
    internal static Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager value)
    {
      // This is converting a reference type in a dependant module.
      // Therefore it defers to the dependant module for conversion
      return AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value);
    }
    internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    internal static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M5_value(Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    internal static Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M5_value(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    internal static string FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_AttributeActions__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_AttributeActions__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    internal static AWS.Cryptography.StructuredEncryption.CryptoAction FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_AttributeActions__M5_value(Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction value)
    {
      return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction(value);
    }
    internal static Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_AttributeActions__M5_value(AWS.Cryptography.StructuredEncryption.CryptoAction value)
    {
      return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction(value);
    }
    internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList__M6_member(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList__M6_member(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    internal static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue value)
    {
      Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue concrete = (Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue)value;
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
    internal static Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      if (value.S != null)
      {
        return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_S(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_S(value.S));
      }
      if (value.N != null)
      {
        return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_N(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_N(value.N));
      }
      if (value.B != null)
      {
        return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_B(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_B(value.B));
      }
      if (!value.SS.Any())
      {
        return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_SS(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_SS(value.SS));
      }
      if (!value.NS.Any())
      {
        return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_NS(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_NS(value.NS));
      }
      if (!value.BS.Any())
      {
        return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_BS(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_BS(value.BS));
      }
      if (value.IsMSet)
      {
        return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_M(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_M(value.M));
      }
      if (value.IsLSet)
      {
        return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_L(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_L(value.L));
      }
      if (value.NULL == true)
      {
        return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_NULL(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_NULL(value.NULL));
      }
      if (value.IsBOOLSet)
      {
        return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_BOOL(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_BOOL(value.BOOL));
      }
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.Model.AttributeValue state");
    }
    internal static AWS.Cryptography.StructuredEncryption.CryptoAction FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction(Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction value)
    {
      if (value.is_ENCRYPT__AND__SIGN) return AWS.Cryptography.StructuredEncryption.CryptoAction.ENCRYPT_AND_SIGN;
      if (value.is_SIGN__ONLY) return AWS.Cryptography.StructuredEncryption.CryptoAction.SIGN_ONLY;
      if (value.is_DO__NOTHING) return AWS.Cryptography.StructuredEncryption.CryptoAction.DO_NOTHING;
      throw new System.ArgumentException("Invalid AWS.Cryptography.StructuredEncryption.CryptoAction value");
    }
    internal static Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction(AWS.Cryptography.StructuredEncryption.CryptoAction value)
    {
      if (AWS.Cryptography.StructuredEncryption.CryptoAction.ENCRYPT_AND_SIGN.Equals(value)) return Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_ENCRYPT__AND__SIGN();
      if (AWS.Cryptography.StructuredEncryption.CryptoAction.SIGN_ONLY.Equals(value)) return Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_SIGN__ONLY();
      if (AWS.Cryptography.StructuredEncryption.CryptoAction.DO_NOTHING.Equals(value)) return Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_DO__NOTHING();
      throw new System.ArgumentException("Invalid AWS.Cryptography.StructuredEncryption.CryptoAction value");
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
    internal static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_M(Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue(value);
    }
    internal static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_M(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue(value);
    }
    internal static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_L(Dafny.ISequence<Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue(value);
    }
    internal static Dafny.ISequence<Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_L(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> value)
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
    internal static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue(Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M5_value(pair.Cdr));
    }
    internal static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M5_value(pair.Value))
     ));
    }
    internal static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue(Dafny.ISequence<Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value)
    {
      return new System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue__M6_member));
    }
    internal static Dafny.ISequence<Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return Dafny.Sequence<Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue__M6_member).ToArray());
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
    internal static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M5_value(Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    internal static Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M5_value(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    internal static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue__M6_member(Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    internal static Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue__M6_member(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static System.Exception FromDafny_CommonError(Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types._IError value)
    {
      switch (value)
      {
        case Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.Error_AwsCryptographyStructuredEncryption dafnyVal:
          return AWS.Cryptography.StructuredEncryption.TypeConversion.FromDafny_CommonError(
            dafnyVal._AwsCryptographyStructuredEncryption
          );
        case Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.Error_AwsCryptographyMaterialProviders dafnyVal:
          return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_CommonError(
            dafnyVal._AwsCryptographyMaterialProviders
          );
        case Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.Error_ComAmazonawsDynamodb dafnyVal:
          return Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_CommonError(
            dafnyVal._ComAmazonawsDynamodb
          );
        case Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.Error_DynamoDbItemEncryptorException dafnyVal:
          return FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S30_DynamoDbItemEncryptorException(dafnyVal);
        case Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.Error_CollectionOfErrors dafnyVal:
          return new CollectionOfErrors(new System.Collections.Generic.List<Exception>(dafnyVal._list.Elements.Select(x => TypeConversion.FromDafny_CommonError(x))));
        case Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.Error_Opaque dafnyVal:
          return new OpaqueError(dafnyVal._obj);
        default:
          // The switch MUST be complete for _IError, so `value` MUST NOT be an _IError. (How did you get here?)
          return new OpaqueError();
      }
    }
    public static Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types._IError ToDafny_CommonError(System.Exception value)
    {
      switch (value.GetType().Namespace)
      {
        case "AWS.Cryptography.StructuredEncryption":
          return Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.Error.create_AwsCryptographyStructuredEncryption(
            AWS.Cryptography.StructuredEncryption.TypeConversion.ToDafny_CommonError(value)
          );
        case "AWS.Cryptography.MaterialProviders":
          return Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.Error.create_AwsCryptographyMaterialProviders(
            AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_CommonError(value)
          );
        case "Com.Amazonaws.Dynamodb":
          return Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.Error.create_ComAmazonawsDynamodb(
            Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_CommonError(value)
          );
      }
      switch (value)
      {
        case AWS.Cryptography.DynamoDbItemEncryptor.DynamoDbItemEncryptorException exception:
          return ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S30_DynamoDbItemEncryptorException(exception);
        case CollectionOfErrors collectionOfErrors:
          return new Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.Error_CollectionOfErrors(
              Dafny.Sequence<Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types._IError>
              .FromArray(
                  collectionOfErrors.list.Select
                      (x => TypeConversion.ToDafny_CommonError(x))
                  .ToArray()
              )
          );

        // OpaqueError is redundant, but listed for completeness.
        case OpaqueError exception:
          return new Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.Error_Opaque(exception);
        case System.Exception exception:
          return new Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.Error_Opaque(exception);
        default:
          // The switch MUST be complete for System.Exception, so `value` MUST NOT be an System.Exception. (How did you get here?)
          return new Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.Error_Opaque(value);
      }
    }
  }
}
