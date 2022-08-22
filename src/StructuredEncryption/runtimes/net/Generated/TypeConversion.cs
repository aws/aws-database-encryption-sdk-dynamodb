// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System.Linq; namespace AWS.Cryptography.StructuredEncryption {
 internal static class TypeConversion {
 public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M17_encryptionContext (Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> value) {
 return value.is_None ? (System.Collections.Generic.Dictionary<string, string>) null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M17_encryptionContext (System.Collections.Generic.Dictionary<string, string> value) {
 return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext((System.Collections.Generic.Dictionary<string, string>) value));
}
 public static System.Collections.Generic.List<string> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M30_requiredContextFieldsOnDecrypt (Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<byte>>> value) {
 return value.is_None ? (System.Collections.Generic.List<string>) null : FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S26_EncryptionContextFieldList(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<byte>>> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M30_requiredContextFieldsOnDecrypt (System.Collections.Generic.List<string> value) {
 return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<byte>>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<byte>>>.create_Some(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S26_EncryptionContextFieldList((System.Collections.Generic.List<string>) value));
}
 public static string FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_Utf8Bytes (Dafny.ISequence<byte> value) {
 System.Text.UTF8Encoding utf8 = new System.Text.UTF8Encoding(false, true);
return utf8.GetString(value.Elements);
}
 public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_Utf8Bytes (string value) {
 System.Text.UTF8Encoding utf8 = new System.Text.UTF8Encoding(false, true);
return Dafny.Sequence<byte>.FromArray(utf8.GetBytes(value));
}
 public static AWS.Cryptography.StructuredEncryption.StructuredEncryptionException FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S29_StructuredEncryptionException (Dafny.Aws.Cryptography.StructuredEncryption.Types.Error_StructuredEncryptionException value) {
 return new AWS.Cryptography.StructuredEncryption.StructuredEncryptionException (
 FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S29_StructuredEncryptionException__M7_message(value.message)
 ) ;
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types.Error_StructuredEncryptionException ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S29_StructuredEncryptionException (AWS.Cryptography.StructuredEncryption.StructuredEncryptionException value) {

 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.Error_StructuredEncryptionException (
 ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S29_StructuredEncryptionException__M7_message(value.Message)
 ) ;
}
 public static System.Collections.Generic.Dictionary<string, System.IO.MemoryStream> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData__M10_attributes (Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<byte>>> value) {
 return value.is_None ? (System.Collections.Generic.Dictionary<string, System.IO.MemoryStream>) null : FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<byte>>> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData__M10_attributes (System.Collections.Generic.Dictionary<string, System.IO.MemoryStream> value) {
 return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<byte>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<byte>>>.create_Some(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes((System.Collections.Generic.Dictionary<string, System.IO.MemoryStream>) value));
}
 public static string FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M5_value (Dafny.ISequence<byte> value) {
 return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_Utf8Bytes(value);
}
 public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M5_value (string value) {
 return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_Utf8Bytes(value);
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> value) {
 return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes__M3_key(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes__M5_value(pair.Cdr));
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> value) {
 return Dafny.Map<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction>.FromCollection(value.Select(pair =>
    new Dafny.Pair<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction>(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes__M3_key(pair.Key), ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes__M5_value(pair.Value))
));
}
 public static AWS.Cryptography.StructuredEncryption.StructuredData FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData value) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData concrete = (Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)value; AWS.Cryptography.StructuredEncryption.StructuredData converted = new AWS.Cryptography.StructuredEncryption.StructuredData();  converted.Content = (AWS.Cryptography.StructuredEncryption.StructuredDataContent) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData__M7_content(concrete.content);
 if (concrete.attributes.is_Some) converted.Attributes = (System.Collections.Generic.Dictionary<string, System.IO.MemoryStream>) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData__M10_attributes(concrete.attributes); return converted;
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData (AWS.Cryptography.StructuredEncryption.StructuredData value) {
 System.Collections.Generic.Dictionary<string, System.IO.MemoryStream> var_attributes = value.IsSetAttributes() ? value.Attributes : (System.Collections.Generic.Dictionary<string, System.IO.MemoryStream>) null;
 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData ( ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData__M7_content(value.Content) , ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData__M10_attributes(var_attributes) ) ;
}
 public static AWS.Cryptography.StructuredEncryption.StructuredData FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_DecryptStructureOutput__M18_plaintextStructure (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_DecryptStructureOutput__M18_plaintextStructure (AWS.Cryptography.StructuredEncryption.StructuredData value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value);
}
 public static AWS.Cryptography.StructuredEncryption.CryptoSchemaContent FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S19_CryptoSchemaContent (Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchemaContent value) {
 
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchemaContent ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S19_CryptoSchemaContent (AWS.Cryptography.StructuredEncryption.CryptoSchemaContent value) {
 
}
 public static AWS.Cryptography.StructuredEncryption.StructuredData FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_EncryptStructureOutput__M19_ciphertextStructure (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_EncryptStructureOutput__M19_ciphertextStructure (AWS.Cryptography.StructuredEncryption.StructuredData value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value);
}
 public static string FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S26_EncryptionContextFieldList__M6_member (Dafny.ISequence<byte> value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S9_Utf8Bytes(value);
}
 public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S26_EncryptionContextFieldList__M6_member (string value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S9_Utf8Bytes(value);
}
 public static AWS.Cryptography.StructuredEncryption.StructuredDataContent FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData__M7_content (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataContent value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_StructuredDataContent(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataContent ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData__M7_content (AWS.Cryptography.StructuredEncryption.StructuredDataContent value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_StructuredDataContent(value);
}
 public static AWS.Cryptography.StructuredEncryption.CryptoAction FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction (Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction value) {
 if (value.is_ENCRYPT__AND__SIGN) return AWS.Cryptography.StructuredEncryption.CryptoAction.ENCRYPT_AND_SIGN;
 if (value.is_SIGN__ONLY) return AWS.Cryptography.StructuredEncryption.CryptoAction.SIGN_ONLY;
 if (value.is_IGNORE) return AWS.Cryptography.StructuredEncryption.CryptoAction.IGNORE;
throw new System.ArgumentException("Invalid AWS.Cryptography.StructuredEncryption.CryptoAction value");
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction (AWS.Cryptography.StructuredEncryption.CryptoAction value) {
 if (AWS.Cryptography.StructuredEncryption.CryptoAction.ENCRYPT_AND_SIGN.Equals(value)) return Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_ENCRYPT__AND__SIGN();
 if (AWS.Cryptography.StructuredEncryption.CryptoAction.SIGN_ONLY.Equals(value)) return Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_SIGN__ONLY();
 if (AWS.Cryptography.StructuredEncryption.CryptoAction.IGNORE.Equals(value)) return Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_IGNORE();
throw new System.ArgumentException("Invalid AWS.Cryptography.StructuredEncryption.CryptoAction value");
}
 public static AWS.Cryptography.StructuredEncryption.CryptoSchema FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M12_cryptoSchema (Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M12_cryptoSchema (AWS.Cryptography.StructuredEncryption.CryptoSchema value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema(value);
}
 public static AWS.Cryptography.StructuredEncryption.StructuredEncryptionConfig FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S26_StructuredEncryptionConfig (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredEncryptionConfig value) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredEncryptionConfig concrete = (Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredEncryptionConfig)value; AWS.Cryptography.StructuredEncryption.StructuredEncryptionConfig converted = new AWS.Cryptography.StructuredEncryption.StructuredEncryptionConfig();  return converted;
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredEncryptionConfig ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S26_StructuredEncryptionConfig (AWS.Cryptography.StructuredEncryption.StructuredEncryptionConfig value) {

 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredEncryptionConfig (  ) ;
}
 public static AWS.Cryptography.StructuredEncryption.StructuredData FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M19_ciphertextStructure (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M19_ciphertextStructure (AWS.Cryptography.StructuredEncryption.StructuredData value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value);
}
 public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M17_encryptionContext (Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> value) {
 return value.is_None ? (System.Collections.Generic.Dictionary<string, string>) null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M17_encryptionContext (System.Collections.Generic.Dictionary<string, string> value) {
 return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext((System.Collections.Generic.Dictionary<string, string>) value));
}
 public static string FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes__M3_key (Dafny.ISequence<char> value) {
 return FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes__M3_key (string value) {
 return ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static AWS.Cryptography.StructuredEncryption.EncryptStructureInput FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput (Dafny.Aws.Cryptography.StructuredEncryption.Types._IEncryptStructureInput value) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureInput concrete = (Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureInput)value; AWS.Cryptography.StructuredEncryption.EncryptStructureInput converted = new AWS.Cryptography.StructuredEncryption.EncryptStructureInput();  converted.PlaintextStructure = (AWS.Cryptography.StructuredEncryption.StructuredData) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M18_plaintextStructure(concrete.plaintextStructure);
  converted.CryptoSchema = (AWS.Cryptography.StructuredEncryption.CryptoSchema) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M12_cryptoSchema(concrete.cryptoSchema);
 if (concrete.keyring.is_Some) converted.Keyring = (AWS.Cryptography.MaterialProviders.IKeyring) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M7_keyring(concrete.keyring);
 if (concrete.cmm.is_Some) converted.Cmm = (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M3_cmm(concrete.cmm);
 if (concrete.encryptionContext.is_Some) converted.EncryptionContext = (System.Collections.Generic.Dictionary<string, string>) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M17_encryptionContext(concrete.encryptionContext);
 if (concrete.requiredContextFieldsOnDecrypt.is_Some) converted.RequiredContextFieldsOnDecrypt = (System.Collections.Generic.List<string>) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M30_requiredContextFieldsOnDecrypt(concrete.requiredContextFieldsOnDecrypt); return converted;
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IEncryptStructureInput ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput (AWS.Cryptography.StructuredEncryption.EncryptStructureInput value) {
 AWS.Cryptography.MaterialProviders.IKeyring var_keyring = value.IsSetKeyring() ? value.Keyring : (AWS.Cryptography.MaterialProviders.IKeyring) null;
 AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager var_cmm = value.IsSetCmm() ? value.Cmm : (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) null;
 System.Collections.Generic.Dictionary<string, string> var_encryptionContext = value.IsSetEncryptionContext() ? value.EncryptionContext : (System.Collections.Generic.Dictionary<string, string>) null;
 System.Collections.Generic.List<string> var_requiredContextFieldsOnDecrypt = value.IsSetRequiredContextFieldsOnDecrypt() ? value.RequiredContextFieldsOnDecrypt : (System.Collections.Generic.List<string>) null;
 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureInput ( ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M18_plaintextStructure(value.PlaintextStructure) , ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M12_cryptoSchema(value.CryptoSchema) , ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M7_keyring(var_keyring) , ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M3_cmm(var_cmm) , ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M17_encryptionContext(var_encryptionContext) , ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M30_requiredContextFieldsOnDecrypt(var_requiredContextFieldsOnDecrypt) ) ;
}
 public static AWS.Cryptography.MaterialProviders.IKeyring FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M7_keyring (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring> value) {
 return value.is_None ? (AWS.Cryptography.MaterialProviders.IKeyring) null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M7_keyring (AWS.Cryptography.MaterialProviders.IKeyring value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference((AWS.Cryptography.MaterialProviders.IKeyring) value));
}
 public static string FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S19_CryptoSchemaVersion (Dafny.ISequence<char> value) {
 return new string(value.Elements);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S19_CryptoSchemaVersion (string value) {
 return Dafny.Sequence<char>.FromString(value);
}
 public static AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M3_cmm (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager> value) {
 return value.is_None ? (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M3_cmm (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference((AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) value));
}
 public static string FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S29_StructuredEncryptionException__M7_message (Dafny.ISequence<char> value) {
 return FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S29_StructuredEncryptionException__M7_message (string value) {
 return ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static AWS.Cryptography.StructuredEncryption.CryptoSchema FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema (Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema value) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema concrete = (Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema)value; AWS.Cryptography.StructuredEncryption.CryptoSchema converted = new AWS.Cryptography.StructuredEncryption.CryptoSchema();  converted.Content = (AWS.Cryptography.StructuredEncryption.CryptoSchemaContent) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema__M7_content(concrete.content);
 if (concrete.attributes.is_Some) converted.Attributes = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction>) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema__M10_attributes(concrete.attributes); return converted;
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema (AWS.Cryptography.StructuredEncryption.CryptoSchema value) {
 System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> var_attributes = value.IsSetAttributes() ? value.Attributes : (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction>) null;
 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema ( ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema__M7_content(value.Content) , ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema__M10_attributes(var_attributes) ) ;
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema__M10_attributes (Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction>> value) {
 return value.is_None ? (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction>) null : FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction>> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema__M10_attributes (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> value) {
 return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction>>.create_Some(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes((System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction>) value));
}
 public static string FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes__M3_key (Dafny.ISequence<char> value) {
 return FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes__M3_key (string value) {
 return ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext (Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>> value) {
 return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M3_key(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M5_value(pair.Cdr));
}
 public static Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext (System.Collections.Generic.Dictionary<string, string> value) {
 return Dafny.Map<Dafny.ISequence<byte>, Dafny.ISequence<byte>>.FromCollection(value.Select(pair =>
    new Dafny.Pair<Dafny.ISequence<byte>, Dafny.ISequence<byte>>(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M3_key(pair.Key), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M5_value(pair.Value))
));
}
 public static AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference (Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager value) {
 if (value is NativeWrapper_CryptographicMaterialsManager nativeWrapper) return nativeWrapper._impl;
return new CryptographicMaterialsManager(value);

}
 public static Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager value) {
 switch (value)
 {
 case CryptographicMaterialsManager valueWithImpl:
    return valueWithImpl._impl;
 case CryptographicMaterialsManagerBase nativeImpl:
    return new NativeWrapper_CryptographicMaterialsManager(nativeImpl);
 default:
    throw new System.ArgumentException(
        "Custom implementations of CryptographicMaterialsManager must extend CryptographicMaterialsManagerBase.");
}
}
 public static AWS.Cryptography.StructuredEncryption.DecryptStructureOutput FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_DecryptStructureOutput (Dafny.Aws.Cryptography.StructuredEncryption.Types._IDecryptStructureOutput value) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput concrete = (Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput)value; AWS.Cryptography.StructuredEncryption.DecryptStructureOutput converted = new AWS.Cryptography.StructuredEncryption.DecryptStructureOutput();  converted.PlaintextStructure = (AWS.Cryptography.StructuredEncryption.StructuredData) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_DecryptStructureOutput__M18_plaintextStructure(concrete.plaintextStructure); return converted;
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IDecryptStructureOutput ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_DecryptStructureOutput (AWS.Cryptography.StructuredEncryption.DecryptStructureOutput value) {

 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput ( ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_DecryptStructureOutput__M18_plaintextStructure(value.PlaintextStructure) ) ;
}
 public static AWS.Cryptography.StructuredEncryption.StructuredDataContent FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_StructuredDataContent (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataContent value) {
 
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataContent ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_StructuredDataContent (AWS.Cryptography.StructuredEncryption.StructuredDataContent value) {
 
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoSchema> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M13_cryptoSchemas (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema> value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S13_CryptoSchemas(value);
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M13_cryptoSchemas (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoSchema> value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S13_CryptoSchemas(value);
}
 public static AWS.Cryptography.StructuredEncryption.CryptoSchemaContent FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema__M7_content (Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchemaContent value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S19_CryptoSchemaContent(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchemaContent ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema__M7_content (AWS.Cryptography.StructuredEncryption.CryptoSchemaContent value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S19_CryptoSchemaContent(value);
}
 public static string FromDafny_N6_smithy__N3_api__S6_String (Dafny.ISequence<char> value) {
 return new string(value.Elements);
}
 public static Dafny.ISequence<char> ToDafny_N6_smithy__N3_api__S6_String (string value) {
 return Dafny.Sequence<char>.FromString(value);
}
 public static System.IO.MemoryStream FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S8_Terminal (Dafny.ISequence<byte> value) {
 return new System.IO.MemoryStream(value.Elements);
}
 public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S8_Terminal (System.IO.MemoryStream value) {
 return Dafny.Sequence<byte>.FromArray(value.ToArray());
}
 public static string FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S13_CryptoSchemas__M3_key (Dafny.ISequence<char> value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S19_CryptoSchemaVersion(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S13_CryptoSchemas__M3_key (string value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S19_CryptoSchemaVersion(value);
}
 public static AWS.Cryptography.StructuredEncryption.CryptoSchema FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S13_CryptoSchemas__M5_value (Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S13_CryptoSchemas__M5_value (AWS.Cryptography.StructuredEncryption.CryptoSchema value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema(value);
}
 public static AWS.Cryptography.MaterialProviders.IKeyring FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference (Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring value) {
 if (value is NativeWrapper_Keyring nativeWrapper) return nativeWrapper._impl;
return new Keyring(value);

}
 public static Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference (AWS.Cryptography.MaterialProviders.IKeyring value) {
 switch (value)
 {
 case Keyring valueWithImpl:
    return valueWithImpl._impl;
 case KeyringBase nativeImpl:
    return new NativeWrapper_Keyring(nativeImpl);
 default:
    throw new System.ArgumentException(
        "Custom implementations of Keyring must extend KeyringBase.");
}
}
 public static AWS.Cryptography.StructuredEncryption.CryptoAction FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes__M5_value (Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes__M5_value (AWS.Cryptography.StructuredEncryption.CryptoAction value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction(value);
}
 public static AWS.Cryptography.StructuredEncryption.EncryptStructureOutput FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_EncryptStructureOutput (Dafny.Aws.Cryptography.StructuredEncryption.Types._IEncryptStructureOutput value) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput concrete = (Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput)value; AWS.Cryptography.StructuredEncryption.EncryptStructureOutput converted = new AWS.Cryptography.StructuredEncryption.EncryptStructureOutput();  converted.CiphertextStructure = (AWS.Cryptography.StructuredEncryption.StructuredData) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_EncryptStructureOutput__M19_ciphertextStructure(concrete.ciphertextStructure); return converted;
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IEncryptStructureOutput ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_EncryptStructureOutput (AWS.Cryptography.StructuredEncryption.EncryptStructureOutput value) {

 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput ( ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_EncryptStructureOutput__M19_ciphertextStructure(value.CiphertextStructure) ) ;
}
 public static string FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M3_key (Dafny.ISequence<byte> value) {
 return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_Utf8Bytes(value);
}
 public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M3_key (string value) {
 return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_Utf8Bytes(value);
}
 public static System.Collections.Generic.Dictionary<string, System.IO.MemoryStream> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes (Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<byte>> value) {
 return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes__M3_key(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes__M5_value(pair.Cdr));
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<byte>> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes (System.Collections.Generic.Dictionary<string, System.IO.MemoryStream> value) {
 return Dafny.Map<Dafny.ISequence<char>, Dafny.ISequence<byte>>.FromCollection(value.Select(pair =>
    new Dafny.Pair<Dafny.ISequence<char>, Dafny.ISequence<byte>>(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes__M3_key(pair.Key), ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes__M5_value(pair.Value))
));
}
 public static AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M3_cmm (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager> value) {
 return value.is_None ? (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M3_cmm (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference((AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) value));
}
 public static System.Collections.Generic.List<string> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S26_EncryptionContextFieldList (Dafny.ISequence<Dafny.ISequence<byte>> value) {
 return new System.Collections.Generic.List<string>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S26_EncryptionContextFieldList__M6_member));
}
 public static Dafny.ISequence<Dafny.ISequence<byte>> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S26_EncryptionContextFieldList (System.Collections.Generic.List<string> value) {
 return Dafny.Sequence<Dafny.ISequence<byte>>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S26_EncryptionContextFieldList__M6_member).ToArray());
}
 public static System.IO.MemoryStream FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes__M5_value (Dafny.ISequence<byte> value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S8_Terminal(value);
}
 public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes__M5_value (System.IO.MemoryStream value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S8_Terminal(value);
}
 public static AWS.Cryptography.StructuredEncryption.DecryptStructureInput FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput (Dafny.Aws.Cryptography.StructuredEncryption.Types._IDecryptStructureInput value) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureInput concrete = (Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureInput)value; AWS.Cryptography.StructuredEncryption.DecryptStructureInput converted = new AWS.Cryptography.StructuredEncryption.DecryptStructureInput();  converted.CiphertextStructure = (AWS.Cryptography.StructuredEncryption.StructuredData) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M19_ciphertextStructure(concrete.ciphertextStructure);
  converted.CryptoSchemas = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoSchema>) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M13_cryptoSchemas(concrete.cryptoSchemas);
 if (concrete.keyring.is_Some) converted.Keyring = (AWS.Cryptography.MaterialProviders.IKeyring) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M7_keyring(concrete.keyring);
 if (concrete.cmm.is_Some) converted.Cmm = (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M3_cmm(concrete.cmm);
 if (concrete.encryptionContext.is_Some) converted.EncryptionContext = (System.Collections.Generic.Dictionary<string, string>) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M17_encryptionContext(concrete.encryptionContext); return converted;
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IDecryptStructureInput ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput (AWS.Cryptography.StructuredEncryption.DecryptStructureInput value) {
 AWS.Cryptography.MaterialProviders.IKeyring var_keyring = value.IsSetKeyring() ? value.Keyring : (AWS.Cryptography.MaterialProviders.IKeyring) null;
 AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager var_cmm = value.IsSetCmm() ? value.Cmm : (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) null;
 System.Collections.Generic.Dictionary<string, string> var_encryptionContext = value.IsSetEncryptionContext() ? value.EncryptionContext : (System.Collections.Generic.Dictionary<string, string>) null;
 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureInput ( ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M19_ciphertextStructure(value.CiphertextStructure) , ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M13_cryptoSchemas(value.CryptoSchemas) , ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M7_keyring(var_keyring) , ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M3_cmm(var_cmm) , ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M17_encryptionContext(var_encryptionContext) ) ;
}
 public static string FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S9_Utf8Bytes (Dafny.ISequence<byte> value) {
 System.Text.UTF8Encoding utf8 = new System.Text.UTF8Encoding(false, true);
return utf8.GetString(value.Elements);
}
 public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S9_Utf8Bytes (string value) {
 System.Text.UTF8Encoding utf8 = new System.Text.UTF8Encoding(false, true);
return Dafny.Sequence<byte>.FromArray(utf8.GetBytes(value));
}
 public static AWS.Cryptography.MaterialProviders.IKeyring FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M7_keyring (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring> value) {
 return value.is_None ? (AWS.Cryptography.MaterialProviders.IKeyring) null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M7_keyring (AWS.Cryptography.MaterialProviders.IKeyring value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference((AWS.Cryptography.MaterialProviders.IKeyring) value));
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoSchema> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S13_CryptoSchemas (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema> value) {
 return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S13_CryptoSchemas__M3_key(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S13_CryptoSchemas__M5_value(pair.Cdr));
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S13_CryptoSchemas (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoSchema> value) {
 return Dafny.Map<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema>.FromCollection(value.Select(pair =>
    new Dafny.Pair<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema>(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S13_CryptoSchemas__M3_key(pair.Key), ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S13_CryptoSchemas__M5_value(pair.Value))
));
}
 public static AWS.Cryptography.StructuredEncryption.StructuredData FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M18_plaintextStructure (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M18_plaintextStructure (AWS.Cryptography.StructuredEncryption.StructuredData value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value);
}
 public static System.Exception FromDafny_CommonError(Dafny.Aws.Cryptography.StructuredEncryption.Types._IError value) {
 switch(value)
 {
 case Dafny.Aws.Cryptography.StructuredEncryption.Types.Error_StructuredEncryptionException dafnyVal:
return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S29_StructuredEncryptionException(dafnyVal);
 case Dafny.Aws.Cryptography.StructuredEncryption.Types.Error_Opaque dafnyVal:
 return new OpaqueError(dafnyVal.obj);
 default:
 // The switch MUST be complete for _IError, so `value` MUST NOT be an _IError. (How did you get here?) 
 return new OpaqueError();
}
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IError ToDafny_CommonError(System.Exception value) {
 switch (value)
 {
 case AWS.Cryptography.StructuredEncryption.StructuredEncryptionException exception:
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S29_StructuredEncryptionException(exception);
 // OpaqueError is redundant, but listed for completeness.
 case OpaqueError exception:
 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.Error_Opaque(exception);
 case System.Exception exception:
 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.Error_Opaque(exception);
 default:
 // The switch MUST be complete for System.Exception, so `value` MUST NOT be an System.Exception. (How did you get here?) 
 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.Error_Opaque(value);
}
}
}
}
