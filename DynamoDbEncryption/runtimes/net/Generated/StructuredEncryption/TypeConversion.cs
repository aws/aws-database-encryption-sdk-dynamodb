// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System.Linq;
using System;
namespace AWS.Cryptography.DbEncryptionSDK.StructuredEncryption
{
  public static class TypeConversion
  {
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_EncryptPathStructureInput__M9_tableName(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_EncryptPathStructureInput__M9_tableName(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.DecryptStructureOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_DecryptStructureOutput(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IDecryptStructureOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureOutput concrete = (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureOutput)value; AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.DecryptStructureOutput converted = new AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.DecryptStructureOutput(); converted.PlaintextStructure = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_DecryptStructureOutput__M18_plaintextStructure(concrete._plaintextStructure);
      converted.CryptoSchema = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_DecryptStructureOutput__M12_cryptoSchema(concrete._cryptoSchema);
      converted.ParsedHeader = (AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ParsedHeader)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_DecryptStructureOutput__M12_parsedHeader(concrete._parsedHeader); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IDecryptStructureOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_DecryptStructureOutput(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.DecryptStructureOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_DecryptStructureOutput__M18_plaintextStructure(value.PlaintextStructure), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_DecryptStructureOutput__M12_cryptoSchema(value.CryptoSchema), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_DecryptStructureOutput__M12_parsedHeader(value.ParsedHeader));
    }
    public static System.IO.MemoryStream FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_StructuredDataTerminal__M5_value(Dafny.ISequence<byte> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S13_TerminalValue(value);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_StructuredDataTerminal__M5_value(System.IO.MemoryStream value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S13_TerminalValue(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ResolveAuthActionsInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S23_ResolveAuthActionsInput(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IResolveAuthActionsInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ResolveAuthActionsInput concrete = (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ResolveAuthActionsInput)value; AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ResolveAuthActionsInput converted = new AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ResolveAuthActionsInput(); converted.TableName = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S23_ResolveAuthActionsInput__M9_tableName(concrete._tableName);
      converted.AuthActions = (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthItem>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S23_ResolveAuthActionsInput__M11_authActions(concrete._authActions);
      converted.HeaderBytes = (System.IO.MemoryStream)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S23_ResolveAuthActionsInput__M11_headerBytes(concrete._headerBytes); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IResolveAuthActionsInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S23_ResolveAuthActionsInput(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ResolveAuthActionsInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ResolveAuthActionsInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S23_ResolveAuthActionsInput__M9_tableName(value.TableName), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S23_ResolveAuthActionsInput__M11_authActions(value.AuthActions), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S23_ResolveAuthActionsInput__M11_headerBytes(value.HeaderBytes));
    }
    public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_AuthenticateSchemaMap(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthenticateAction> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_AuthenticateSchemaMap__M3_key(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_AuthenticateSchemaMap__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthenticateAction> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_AuthenticateSchemaMap(System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthenticateAction>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthenticateAction>(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_AuthenticateSchemaMap__M3_key(pair.Key), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_AuthenticateSchemaMap__M5_value(pair.Value))
     ));
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.DecryptPathStructureOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S26_DecryptPathStructureOutput(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IDecryptPathStructureOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptPathStructureOutput concrete = (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptPathStructureOutput)value; AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.DecryptPathStructureOutput converted = new AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.DecryptPathStructureOutput(); converted.PlaintextStructure = (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S26_DecryptPathStructureOutput__M18_plaintextStructure(concrete._plaintextStructure);
      converted.ParsedHeader = (AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ParsedHeader)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S26_DecryptPathStructureOutput__M12_parsedHeader(concrete._parsedHeader); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IDecryptPathStructureOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S26_DecryptPathStructureOutput(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.DecryptPathStructureOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptPathStructureOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S26_DecryptPathStructureOutput__M18_plaintextStructure(value.PlaintextStructure), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S26_DecryptPathStructureOutput__M12_parsedHeader(value.ParsedHeader));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S17_StructuredDataMap__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S17_StructuredDataMap__M3_key(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthItem> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S23_ResolveAuthActionsInput__M11_authActions(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthItem> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthList(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthItem> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S23_ResolveAuthActionsInput__M11_authActions(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthItem> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthList(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthItem__M6_action(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthenticateAction value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S18_AuthenticateAction(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthenticateAction ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthItem__M6_action(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S18_AuthenticateAction(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthItem> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthList(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthItem> value)
    {
      return new System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthItem>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthList__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthItem> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthList(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthItem> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthItem>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthList__M6_member).ToArray());
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthItem> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_DecryptPathStructureInput__M18_encryptedStructure(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthItem> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthList(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthItem> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_DecryptPathStructureInput__M18_encryptedStructure(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthItem> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthList(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S15_CryptoSchemaMap__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S15_CryptoSchemaMap__M3_key(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_EncryptStructureOutput__M18_encryptedStructure(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructuredDataTerminal> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S17_StructuredDataMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructuredDataTerminal> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_EncryptStructureOutput__M18_encryptedStructure(System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S17_StructuredDataMap(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S17_StructuredDataMap__M5_value(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructuredDataTerminal value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_StructuredDataTerminal(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructuredDataTerminal ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S17_StructuredDataMap__M5_value(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_StructuredDataTerminal(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.PathSegment FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S4_Path__M6_member(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IPathSegment value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S11_PathSegment(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IPathSegment ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S4_Path__M6_member(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.PathSegment value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S11_PathSegment(value);
    }
    public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_DecryptStructureOutput__M12_cryptoSchema(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S15_CryptoSchemaMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_DecryptStructureOutput__M12_cryptoSchema(System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S15_CryptoSchemaMap(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S23_ResolveAuthActionsInput__M9_tableName(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S23_ResolveAuthActionsInput__M9_tableName(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthItem__M4_data(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructuredDataTerminal value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_StructuredDataTerminal(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructuredDataTerminal ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthItem__M4_data(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_StructuredDataTerminal(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S26_DecryptPathStructureOutput__M18_plaintextStructure(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoItem> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoList(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoItem> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S26_DecryptPathStructureOutput__M18_plaintextStructure(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoList(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.PathSegment> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoItem__M3_key(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IPathSegment> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S4_Path(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IPathSegment> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoItem__M3_key(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.PathSegment> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S4_Path(value);
    }
    public static AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M3_cmm(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value);
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M3_cmm(AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ParsedHeader FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IParsedHeader value)
    {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ParsedHeader concrete = (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ParsedHeader)value; AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ParsedHeader converted = new AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ParsedHeader(); converted.AlgorithmSuiteId = (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader__M16_algorithmSuiteId(concrete._algorithmSuiteId);
      converted.EncryptedDataKeys = (System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader__M17_encryptedDataKeys(concrete._encryptedDataKeys);
      converted.StoredEncryptionContext = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader__M23_storedEncryptionContext(concrete._storedEncryptionContext);
      converted.EncryptionContext = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader__M17_encryptionContext(concrete._encryptionContext); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IParsedHeader ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ParsedHeader value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ParsedHeader(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader__M16_algorithmSuiteId(value.AlgorithmSuiteId), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader__M17_encryptedDataKeys(value.EncryptedDataKeys), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader__M23_storedEncryptionContext(value.StoredEncryptionContext), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader__M17_encryptionContext(value.EncryptionContext));
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.DecryptStructureInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_DecryptStructureInput(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IDecryptStructureInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureInput concrete = (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureInput)value; AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.DecryptStructureInput converted = new AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.DecryptStructureInput(); converted.TableName = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_DecryptStructureInput__M9_tableName(concrete._tableName);
      converted.EncryptedStructure = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_DecryptStructureInput__M18_encryptedStructure(concrete._encryptedStructure);
      converted.AuthenticateSchema = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_DecryptStructureInput__M18_authenticateSchema(concrete._authenticateSchema);
      converted.Cmm = (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_DecryptStructureInput__M3_cmm(concrete._cmm);
      if (concrete._encryptionContext.is_Some) converted.EncryptionContext = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_DecryptStructureInput__M17_encryptionContext(concrete._encryptionContext); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IDecryptStructureInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_DecryptStructureInput(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.DecryptStructureInput value)
    {
      value.Validate();
      System.Collections.Generic.Dictionary<string, string> var_encryptionContext = value.IsSetEncryptionContext() ? value.EncryptionContext : (System.Collections.Generic.Dictionary<string, string>)null;
      return new software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_DecryptStructureInput__M9_tableName(value.TableName), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_DecryptStructureInput__M18_encryptedStructure(value.EncryptedStructure), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_DecryptStructureInput__M18_authenticateSchema(value.AuthenticateSchema), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_DecryptStructureInput__M3_cmm(value.Cmm), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_DecryptStructureInput__M17_encryptionContext(var_encryptionContext));
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructureSegment FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S11_PathSegment__M6_member(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructureSegment value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S16_StructureSegment(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructureSegment ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S11_PathSegment__M6_member(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructureSegment value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S16_StructureSegment(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoList(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoItem> value)
    {
      return new System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoList__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoItem> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoList(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoItem>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoList__M6_member).ToArray());
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthItem FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthList__M6_member(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthItem value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthItem(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthItem ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthList__M6_member(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthItem value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthItem(value);
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader__M23_storedEncryptionContext(Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value);
    }
    public static Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader__M23_storedEncryptionContext(System.Collections.Generic.Dictionary<string, string> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_AuthenticateSchemaMap__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_AuthenticateSchemaMap__M3_key(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S17_StructuredDataMap(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructuredDataTerminal> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S17_StructuredDataMap__M3_key(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S17_StructuredDataMap__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructuredDataTerminal> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S17_StructuredDataMap(System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructuredDataTerminal>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructuredDataTerminal>(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S17_StructuredDataMap__M3_key(pair.Key), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S17_StructuredDataMap__M5_value(pair.Value))
     ));
    }
    public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M18_plaintextStructure(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructuredDataTerminal> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S17_StructuredDataMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructuredDataTerminal> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M18_plaintextStructure(System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S17_StructuredDataMap(value);
    }
    public static System.IO.MemoryStream FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S13_TerminalValue(Dafny.ISequence<byte> value)
    {
      return new System.IO.MemoryStream(value.Elements);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S13_TerminalValue(System.IO.MemoryStream value)
    {
      if (value.ToArray().Length == 0 && value.Length > 0)
      {
        throw new System.ArgumentException("Fatal Error: MemoryStream instance not backed by an array!");
      }
      return Dafny.Sequence<byte>.FromArray(value.ToArray());

    }
    public static AWS.Cryptography.Primitives.AwsCryptographicPrimitives FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_AtomicPrimitivesReference(software.amazon.cryptography.primitives.internaldafny.types.IAwsCryptographicPrimitivesClient value)
    {
      if (value is software.amazon.cryptography.primitives.internaldafny.types.IAwsCryptographicPrimitivesClient dafnyValue)
      {
        return new AWS.Cryptography.Primitives.AwsCryptographicPrimitives(dafnyValue);
      }
      throw new System.ArgumentException("Custom implementations of AWS.Cryptography.Primitives.AwsCryptographicPrimitives are not supported yet");
    }
    public static software.amazon.cryptography.primitives.internaldafny.types.IAwsCryptographicPrimitivesClient ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_AtomicPrimitivesReference(AWS.Cryptography.Primitives.AwsCryptographicPrimitives value)
    {
      if (value is AWS.Cryptography.Primitives.AwsCryptographicPrimitives nativeValue)
      {
        return nativeValue.impl();
      }
      throw new System.ArgumentException("Custom implementations of AWS.Cryptography.Primitives.AwsCryptographicPrimitives are not supported yet");
    }
    public static System.IO.MemoryStream FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_StructuredDataTerminal__M6_typeId(Dafny.ISequence<byte> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S14_TerminalTypeId(value);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_StructuredDataTerminal__M6_typeId(System.IO.MemoryStream value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S14_TerminalTypeId(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S26_EncryptPathStructureOutput__M18_encryptedStructure(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoItem> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoList(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoItem> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S26_EncryptPathStructureOutput__M18_encryptedStructure(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoList(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.DecryptPathStructureInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_DecryptPathStructureInput(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IDecryptPathStructureInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptPathStructureInput concrete = (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptPathStructureInput)value; AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.DecryptPathStructureInput converted = new AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.DecryptPathStructureInput(); converted.TableName = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_DecryptPathStructureInput__M9_tableName(concrete._tableName);
      converted.EncryptedStructure = (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthItem>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_DecryptPathStructureInput__M18_encryptedStructure(concrete._encryptedStructure);
      converted.Cmm = (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_DecryptPathStructureInput__M3_cmm(concrete._cmm);
      if (concrete._encryptionContext.is_Some) converted.EncryptionContext = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_DecryptPathStructureInput__M17_encryptionContext(concrete._encryptionContext); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IDecryptPathStructureInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_DecryptPathStructureInput(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.DecryptPathStructureInput value)
    {
      value.Validate();
      System.Collections.Generic.Dictionary<string, string> var_encryptionContext = value.IsSetEncryptionContext() ? value.EncryptionContext : (System.Collections.Generic.Dictionary<string, string>)null;
      return new software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptPathStructureInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_DecryptPathStructureInput__M9_tableName(value.TableName), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_DecryptPathStructureInput__M18_encryptedStructure(value.EncryptedStructure), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_DecryptPathStructureInput__M3_cmm(value.Cmm), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_DecryptPathStructureInput__M17_encryptionContext(var_encryptionContext));
    }
    public static AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M16_algorithmSuiteId(Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId> value)
    {
      return value.is_None ? (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M16_algorithmSuiteId(AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId((AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)value));
    }
    public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_DecryptStructureInput__M18_authenticateSchema(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthenticateAction> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_AuthenticateSchemaMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthenticateAction> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_DecryptStructureInput__M18_authenticateSchema(System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_AuthenticateSchemaMap(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.EncryptPathStructureInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_EncryptPathStructureInput(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IEncryptPathStructureInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptPathStructureInput concrete = (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptPathStructureInput)value; AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.EncryptPathStructureInput converted = new AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.EncryptPathStructureInput(); converted.TableName = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_EncryptPathStructureInput__M9_tableName(concrete._tableName);
      converted.PlaintextStructure = (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_EncryptPathStructureInput__M18_plaintextStructure(concrete._plaintextStructure);
      converted.Cmm = (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_EncryptPathStructureInput__M3_cmm(concrete._cmm);
      if (concrete._algorithmSuiteId.is_Some) converted.AlgorithmSuiteId = (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_EncryptPathStructureInput__M16_algorithmSuiteId(concrete._algorithmSuiteId);
      if (concrete._encryptionContext.is_Some) converted.EncryptionContext = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_EncryptPathStructureInput__M17_encryptionContext(concrete._encryptionContext); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IEncryptPathStructureInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_EncryptPathStructureInput(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.EncryptPathStructureInput value)
    {
      value.Validate();
      AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId var_algorithmSuiteId = value.IsSetAlgorithmSuiteId() ? value.AlgorithmSuiteId : (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)null;
      System.Collections.Generic.Dictionary<string, string> var_encryptionContext = value.IsSetEncryptionContext() ? value.EncryptionContext : (System.Collections.Generic.Dictionary<string, string>)null;
      return new software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptPathStructureInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_EncryptPathStructureInput__M9_tableName(value.TableName), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_EncryptPathStructureInput__M18_plaintextStructure(value.PlaintextStructure), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_EncryptPathStructureInput__M3_cmm(value.Cmm), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_EncryptPathStructureInput__M16_algorithmSuiteId(var_algorithmSuiteId), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_EncryptPathStructureInput__M17_encryptionContext(var_encryptionContext));
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.EncryptStructureOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_EncryptStructureOutput(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IEncryptStructureOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureOutput concrete = (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureOutput)value; AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.EncryptStructureOutput converted = new AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.EncryptStructureOutput(); converted.EncryptedStructure = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_EncryptStructureOutput__M18_encryptedStructure(concrete._encryptedStructure);
      converted.CryptoSchema = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_EncryptStructureOutput__M12_cryptoSchema(concrete._cryptoSchema);
      converted.ParsedHeader = (AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ParsedHeader)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_EncryptStructureOutput__M12_parsedHeader(concrete._parsedHeader); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IEncryptStructureOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_EncryptStructureOutput(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.EncryptStructureOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_EncryptStructureOutput__M18_encryptedStructure(value.EncryptedStructure), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_EncryptStructureOutput__M12_cryptoSchema(value.CryptoSchema), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_EncryptStructureOutput__M12_parsedHeader(value.ParsedHeader));
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ResolveAuthActionsOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S24_ResolveAuthActionsOutput(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IResolveAuthActionsOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ResolveAuthActionsOutput concrete = (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ResolveAuthActionsOutput)value; AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ResolveAuthActionsOutput converted = new AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ResolveAuthActionsOutput(); converted.CryptoActions = (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S24_ResolveAuthActionsOutput__M13_cryptoActions(concrete._cryptoActions); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IResolveAuthActionsOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S24_ResolveAuthActionsOutput(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ResolveAuthActionsOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ResolveAuthActionsOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S24_ResolveAuthActionsOutput__M13_cryptoActions(value.CryptoActions));
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredEncryptionConfig FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S26_StructuredEncryptionConfig(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructuredEncryptionConfig value)
    {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredEncryptionConfig concrete = (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredEncryptionConfig)value; AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredEncryptionConfig converted = new AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredEncryptionConfig(); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructuredEncryptionConfig ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S26_StructuredEncryptionConfig(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredEncryptionConfig value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredEncryptionConfig();
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoList__M6_member(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoItem value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoItem(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoItem ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoList__M6_member(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoItem(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoItem(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoItem value)
    {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem concrete = (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem)value; AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem converted = new AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem(); converted.Key = (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.PathSegment>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoItem__M3_key(concrete._key);
      converted.Data = (AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoItem__M4_data(concrete._data);
      converted.Action = (AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoItem__M6_action(concrete._action); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoItem ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoItem(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoItem__M3_key(value.Key), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoItem__M4_data(value.Data), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoItem__M6_action(value.Action));
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ParsedHeader FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S26_DecryptPathStructureOutput__M12_parsedHeader(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IParsedHeader value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IParsedHeader ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S26_DecryptPathStructureOutput__M12_parsedHeader(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ParsedHeader value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoItem__M4_data(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructuredDataTerminal value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_StructuredDataTerminal(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructuredDataTerminal ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoItem__M4_data(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_StructuredDataTerminal(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S29_StructuredEncryptionException__M7_message(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S29_StructuredEncryptionException__M7_message(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.PathSegment> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthItem__M3_key(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IPathSegment> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S4_Path(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IPathSegment> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthItem__M3_key(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.PathSegment> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S4_Path(value);
    }
    public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_EncryptStructureOutput__M12_cryptoSchema(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S15_CryptoSchemaMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_EncryptStructureOutput__M12_cryptoSchema(System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S15_CryptoSchemaMap(value);
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_DecryptStructureInput__M17_encryptionContext(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, string>)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_DecryptStructureInput__M17_encryptionContext(System.Collections.Generic.Dictionary<string, string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext((System.Collections.Generic.Dictionary<string, string>)value));
    }
    public static AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_EncryptPathStructureInput__M16_algorithmSuiteId(Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId> value)
    {
      return value.is_None ? (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_EncryptPathStructureInput__M16_algorithmSuiteId(AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId((AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)value));
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M17_encryptionContext(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, string>)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M17_encryptionContext(System.Collections.Generic.Dictionary<string, string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext((System.Collections.Generic.Dictionary<string, string>)value));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_DecryptPathStructureInput__M9_tableName(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_DecryptPathStructureInput__M9_tableName(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.PathSegment FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S11_PathSegment(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IPathSegment value)
    {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment concrete = (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment)value;
      var converted = new AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.PathSegment(); if (value.is_member)
      {
        converted.Member = FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S11_PathSegment__M6_member(concrete.dtor_member);
        return converted;
      }
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.PathSegment state");
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IPathSegment ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S11_PathSegment(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.PathSegment value)
    {
      value.Validate(); if (value.IsSetMember())
      {
        return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment.create(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S11_PathSegment__M6_member(value.Member));
      }
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.PathSegment state");
    }
    public static System.IO.MemoryStream FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S14_TerminalTypeId(Dafny.ISequence<byte> value)
    {
      return new System.IO.MemoryStream(value.Elements);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S14_TerminalTypeId(System.IO.MemoryStream value)
    {
      if (value.ToArray().Length == 0 && value.Length > 0)
      {
        throw new System.ArgumentException("Fatal Error: MemoryStream instance not backed by an array!");
      }
      return Dafny.Sequence<byte>.FromArray(value.ToArray());

    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_DecryptStructureInput__M9_tableName(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_DecryptStructureInput__M9_tableName(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoItem__M6_action(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_CryptoAction(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoItem__M6_action(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_CryptoAction(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S24_ResolveAuthActionsOutput__M13_cryptoActions(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoItem> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoList(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoItem> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S24_ResolveAuthActionsOutput__M13_cryptoActions(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoList(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader__M17_encryptedDataKeys(Dafny.ISequence<software.amazon.cryptography.materialproviders.internaldafny.types._IEncryptedDataKey> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.materialproviders.internaldafny.types._IEncryptedDataKey> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader__M17_encryptedDataKeys(System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.EncryptPathStructureOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S26_EncryptPathStructureOutput(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IEncryptPathStructureOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptPathStructureOutput concrete = (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptPathStructureOutput)value; AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.EncryptPathStructureOutput converted = new AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.EncryptPathStructureOutput(); converted.EncryptedStructure = (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S26_EncryptPathStructureOutput__M18_encryptedStructure(concrete._encryptedStructure);
      converted.ParsedHeader = (AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ParsedHeader)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S26_EncryptPathStructureOutput__M12_parsedHeader(concrete._parsedHeader); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IEncryptPathStructureOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S26_EncryptPathStructureOutput(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.EncryptPathStructureOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptPathStructureOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S26_EncryptPathStructureOutput__M18_encryptedStructure(value.EncryptedStructure), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S26_EncryptPathStructureOutput__M12_parsedHeader(value.ParsedHeader));
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructureSegment FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S16_StructureSegment(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructureSegment value)
    {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructureSegment concrete = (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructureSegment)value; AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructureSegment converted = new AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructureSegment(); converted.Key = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S16_StructureSegment__M3_key(concrete._key); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructureSegment ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S16_StructureSegment(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructureSegment value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructureSegment(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S16_StructureSegment__M3_key(value.Key));
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_DecryptPathStructureInput__M17_encryptionContext(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, string>)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_DecryptPathStructureInput__M17_encryptionContext(System.Collections.Generic.Dictionary<string, string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext((System.Collections.Generic.Dictionary<string, string>)value));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M9_tableName(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M9_tableName(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ParsedHeader FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_EncryptStructureOutput__M12_parsedHeader(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IParsedHeader value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IParsedHeader ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_EncryptStructureOutput__M12_parsedHeader(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ParsedHeader value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader(value);
    }
    public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_DecryptStructureOutput__M18_plaintextStructure(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructuredDataTerminal> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S17_StructuredDataMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructuredDataTerminal> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_DecryptStructureOutput__M18_plaintextStructure(System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S17_StructuredDataMap(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthItem FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthItem(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthItem value)
    {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem concrete = (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem)value; AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthItem converted = new AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthItem(); converted.Key = (System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.PathSegment>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthItem__M3_key(concrete._key);
      converted.Data = (AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthItem__M4_data(concrete._data);
      converted.Action = (AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthItem__M6_action(concrete._action); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthItem ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthItem(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthItem value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthItem__M3_key(value.Key), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthItem__M4_data(value.Data), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S8_AuthItem__M6_action(value.Action));
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ParsedHeader FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S26_EncryptPathStructureOutput__M12_parsedHeader(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IParsedHeader value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IParsedHeader ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S26_EncryptPathStructureOutput__M12_parsedHeader(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ParsedHeader value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader(value);
    }
    public static System.IO.MemoryStream FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S23_ResolveAuthActionsInput__M11_headerBytes(Dafny.ISequence<byte> value)
    {
      return FromDafny_N6_smithy__N3_api__S4_Blob(value);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S23_ResolveAuthActionsInput__M11_headerBytes(System.IO.MemoryStream value)
    {
      return ToDafny_N6_smithy__N3_api__S4_Blob(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S15_CryptoSchemaMap__M5_value(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_CryptoAction(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S15_CryptoSchemaMap__M5_value(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_CryptoAction(value);
    }
    public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_DecryptStructureInput__M18_encryptedStructure(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructuredDataTerminal> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S17_StructuredDataMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructuredDataTerminal> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_DecryptStructureInput__M18_encryptedStructure(System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S17_StructuredDataMap(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_AuthenticateSchemaMap__M5_value(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthenticateAction value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S18_AuthenticateAction(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthenticateAction ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_AuthenticateSchemaMap__M5_value(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S18_AuthenticateAction(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.EncryptStructureInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IEncryptStructureInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureInput concrete = (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureInput)value; AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.EncryptStructureInput converted = new AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.EncryptStructureInput(); converted.TableName = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M9_tableName(concrete._tableName);
      converted.PlaintextStructure = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M18_plaintextStructure(concrete._plaintextStructure);
      converted.CryptoSchema = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M12_cryptoSchema(concrete._cryptoSchema);
      converted.Cmm = (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M3_cmm(concrete._cmm);
      if (concrete._algorithmSuiteId.is_Some) converted.AlgorithmSuiteId = (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M16_algorithmSuiteId(concrete._algorithmSuiteId);
      if (concrete._encryptionContext.is_Some) converted.EncryptionContext = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M17_encryptionContext(concrete._encryptionContext); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IEncryptStructureInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.EncryptStructureInput value)
    {
      value.Validate();
      AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId var_algorithmSuiteId = value.IsSetAlgorithmSuiteId() ? value.AlgorithmSuiteId : (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId)null;
      System.Collections.Generic.Dictionary<string, string> var_encryptionContext = value.IsSetEncryptionContext() ? value.EncryptionContext : (System.Collections.Generic.Dictionary<string, string>)null;
      return new software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M9_tableName(value.TableName), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M18_plaintextStructure(value.PlaintextStructure), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M12_cryptoSchema(value.CryptoSchema), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M3_cmm(value.Cmm), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M16_algorithmSuiteId(var_algorithmSuiteId), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M17_encryptionContext(var_encryptionContext));
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
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_StructuredDataTerminal(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructuredDataTerminal value)
    {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal concrete = (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal)value; AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal converted = new AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal(); converted.Value = (System.IO.MemoryStream)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_StructuredDataTerminal__M5_value(concrete._value);
      converted.TypeId = (System.IO.MemoryStream)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_StructuredDataTerminal__M6_typeId(concrete._typeId); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IStructuredDataTerminal ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_StructuredDataTerminal(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_StructuredDataTerminal__M5_value(value.Value), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_StructuredDataTerminal__M6_typeId(value.TypeId));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S16_StructureSegment__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S16_StructureSegment__M3_key(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S18_AuthenticateAction(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthenticateAction value)
    {
      if (value.is_SIGN) return AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction.SIGN;
      if (value.is_DO__NOT__SIGN) return AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction.DO_NOT_SIGN;
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction value");
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IAuthenticateAction ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S18_AuthenticateAction(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction value)
    {
      if (AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction.SIGN.Equals(value)) return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateAction.create_SIGN();
      if (AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction.DO_NOT_SIGN.Equals(value)) return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateAction.create_DO__NOT__SIGN();
      throw new System.ArgumentException("Invalid AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction value");
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_EncryptPathStructureInput__M18_plaintextStructure(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoItem> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoList(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoItem> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_EncryptPathStructureInput__M18_plaintextStructure(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S10_CryptoList(value);
    }
    public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S15_CryptoSchemaMap(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S15_CryptoSchemaMap__M3_key(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S15_CryptoSchemaMap__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S15_CryptoSchemaMap(System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction>(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S15_CryptoSchemaMap__M3_key(pair.Key), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S15_CryptoSchemaMap__M5_value(pair.Value))
     ));
    }
    public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M12_cryptoSchema(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S15_CryptoSchemaMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._ICryptoAction> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_EncryptStructureInput__M12_cryptoSchema(System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S15_CryptoSchemaMap(value);
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader__M17_encryptionContext(Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value);
    }
    public static Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader__M17_encryptionContext(System.Collections.Generic.Dictionary<string, string> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value);
    }
    public static AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_DecryptStructureInput__M3_cmm(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value);
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S21_DecryptStructureInput__M3_cmm(AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value);
    }
    public static AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_DecryptPathStructureInput__M3_cmm(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value);
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_DecryptPathStructureInput__M3_cmm(AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value);
    }
    public static AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader__M16_algorithmSuiteId(software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value);
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types._IDBEAlgorithmSuiteId ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader__M16_algorithmSuiteId(AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredEncryptionException FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S29_StructuredEncryptionException(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error_StructuredEncryptionException value)
    {
      return new AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredEncryptionException(
      FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S29_StructuredEncryptionException__M7_message(value._message)
      );
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error_StructuredEncryptionException ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S29_StructuredEncryptionException(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredEncryptionException value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error_StructuredEncryptionException(
      ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S29_StructuredEncryptionException__M7_message(value.Message)
      );
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_EncryptPathStructureInput__M17_encryptionContext(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, string>)null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_EncryptPathStructureInput__M17_encryptionContext(System.Collections.Generic.Dictionary<string, string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext((System.Collections.Generic.Dictionary<string, string>)value));
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ParsedHeader FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_DecryptStructureOutput__M12_parsedHeader(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IParsedHeader value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader(value);
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IParsedHeader ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S22_DecryptStructureOutput__M12_parsedHeader(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ParsedHeader value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S12_ParsedHeader(value);
    }
    public static System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.PathSegment> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S4_Path(Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IPathSegment> value)
    {
      return new System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.PathSegment>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S4_Path__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IPathSegment> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S4_Path(System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.PathSegment> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IPathSegment>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S4_Path__M6_member).ToArray());
    }
    public static AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_EncryptPathStructureInput__M3_cmm(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager value)
    {
      return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value);
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S25_EncryptPathStructureInput__M3_cmm(AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager value)
    {
      return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value);
    }
    public static string FromDafny_N6_smithy__N3_api__S6_String(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N6_smithy__N3_api__S6_String(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
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
      value.Validate();

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
    public static System.Exception FromDafny_CommonError(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IError value)
    {
      switch (value)
      {
        case software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error_AwsCryptographyMaterialProviders dafnyVal:
          return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_CommonError(
            dafnyVal._AwsCryptographyMaterialProviders
          );
        case software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error_AwsCryptographyPrimitives dafnyVal:
          return AWS.Cryptography.Primitives.TypeConversion.FromDafny_CommonError(
            dafnyVal._AwsCryptographyPrimitives
          );
        case software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error_StructuredEncryptionException dafnyVal:
          return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S29_StructuredEncryptionException(dafnyVal);
        case software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error_CollectionOfErrors dafnyVal:
          return new CollectionOfErrors(
              new System.Collections.Generic.List<Exception>(dafnyVal.dtor_list.CloneAsArray()
                .Select(x => TypeConversion.FromDafny_CommonError(x))),
              new string(dafnyVal.dtor_message.Elements));
        case software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error_Opaque dafnyVal:
          return new OpaqueError(dafnyVal._obj);
        case software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error_OpaqueWithText dafnyVal:
          return new OpaqueWithTextError(dafnyVal._obj, dafnyVal._obj.ToString());
        default:
          // The switch MUST be complete for _IError, so `value` MUST NOT be an _IError. (How did you get here?)
          return new OpaqueError();
      }
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IError ToDafny_CommonError(System.Exception value)
    {

      switch (value)
      {
        case AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredEncryptionException exception:
          return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N20_structuredEncryption__S29_StructuredEncryptionException(exception);
        case CollectionOfErrors collectionOfErrors:
          return new software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error_CollectionOfErrors(
            Dafny.Sequence<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types._IError>
              .FromArray(
                collectionOfErrors.list.Select
                    (x => TypeConversion.ToDafny_CommonError(x))
                  .ToArray()),
            Dafny.Sequence<char>.FromString(collectionOfErrors.Message)
          );
        // OpaqueError is redundant, but listed for completeness.
        case OpaqueError exception:
          return new software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error_Opaque(exception);
        case System.Exception exception:
          return new software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error_Opaque(exception);
        default:
          // The switch MUST be complete for System.Exception, so `value` MUST NOT be an System.Exception. (How did you get here?)
          return new software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error_Opaque(value);
      }
    }
  }
}
