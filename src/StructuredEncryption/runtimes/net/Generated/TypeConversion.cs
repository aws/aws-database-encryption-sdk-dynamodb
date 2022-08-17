// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System.Linq; namespace AWS.Cryptography.StructuredEncryption {
 internal static class TypeConversion {
 public static string FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes__M3_key (Dafny.ISequence<char> value) {
 return FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes__M3_key (string value) {
 return ToDafny_N6_smithy__N3_api__S6_String(value);
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
 public static System.Collections.Generic.Dictionary<string, System.IO.MemoryStream> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData__M10_attributes (Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<byte>>> value) {
 return value.is_None ? (System.Collections.Generic.Dictionary<string, System.IO.MemoryStream>) null : FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<byte>>> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData__M10_attributes (System.Collections.Generic.Dictionary<string, System.IO.MemoryStream> value) {
 return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<byte>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<byte>>>.create_Some(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes((System.Collections.Generic.Dictionary<string, System.IO.MemoryStream>) value));
}
 public static System.IO.MemoryStream FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S8_Terminal (Dafny.ISequence<byte> value) {
 return new System.IO.MemoryStream(value.Elements);
}
 public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S8_Terminal (System.IO.MemoryStream value) {
 return Dafny.Sequence<byte>.FromArray(value.ToArray());
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
 public static AWS.Cryptography.StructuredEncryption.StructuredDataContent FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData__M7_content (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataContent value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_StructuredDataContent(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataContent ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData__M7_content (AWS.Cryptography.StructuredEncryption.StructuredDataContent value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_StructuredDataContent(value);
}
 public static AWS.Cryptography.StructuredEncryption.CryptoSchema FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M12_cryptoSchema (Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M12_cryptoSchema (AWS.Cryptography.StructuredEncryption.CryptoSchema value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema(value);
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
 public static System.Collections.Generic.Dictionary<string, System.IO.MemoryStream> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes (Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<byte>> value) {
 return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes__M3_key(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes__M5_value(pair.Cdr));
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<byte>> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes (System.Collections.Generic.Dictionary<string, System.IO.MemoryStream> value) {
 return Dafny.Map<Dafny.ISequence<char>, Dafny.ISequence<byte>>.FromCollection(value.Select(pair =>
    new Dafny.Pair<Dafny.ISequence<char>, Dafny.ISequence<byte>>(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes__M3_key(pair.Key), ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes__M5_value(pair.Value))
));
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
 public static string FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes__M3_key (Dafny.ISequence<char> value) {
 return FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes__M3_key (string value) {
 return ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static AWS.Cryptography.StructuredEncryption.EncryptStructureInput FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput (Dafny.Aws.Cryptography.StructuredEncryption.Types._IEncryptStructureInput value) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureInput concrete = (Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureInput)value; AWS.Cryptography.StructuredEncryption.EncryptStructureInput converted = new AWS.Cryptography.StructuredEncryption.EncryptStructureInput();  converted.PlaintextStructure = (AWS.Cryptography.StructuredEncryption.StructuredData) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M18_plaintextStructure(concrete.plaintextStructure);
  converted.CryptoSchema = (AWS.Cryptography.StructuredEncryption.CryptoSchema) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M12_cryptoSchema(concrete.cryptoSchema); return converted;
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IEncryptStructureInput ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput (AWS.Cryptography.StructuredEncryption.EncryptStructureInput value) {

 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureInput ( ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M18_plaintextStructure(value.PlaintextStructure) , ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M12_cryptoSchema(value.CryptoSchema) ) ;
}
 public static System.IO.MemoryStream FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes__M5_value (Dafny.ISequence<byte> value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S8_Terminal(value);
}
 public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes__M5_value (System.IO.MemoryStream value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S8_Terminal(value);
}
 public static AWS.Cryptography.StructuredEncryption.DecryptStructureInput FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput (Dafny.Aws.Cryptography.StructuredEncryption.Types._IDecryptStructureInput value) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureInput concrete = (Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureInput)value; AWS.Cryptography.StructuredEncryption.DecryptStructureInput converted = new AWS.Cryptography.StructuredEncryption.DecryptStructureInput();  converted.CiphertextStructure = (AWS.Cryptography.StructuredEncryption.StructuredData) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M19_ciphertextStructure(concrete.ciphertextStructure);
  converted.CryptoSchema = (AWS.Cryptography.StructuredEncryption.CryptoSchema) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M12_cryptoSchema(concrete.cryptoSchema); return converted;
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IDecryptStructureInput ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput (AWS.Cryptography.StructuredEncryption.DecryptStructureInput value) {

 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureInput ( ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M19_ciphertextStructure(value.CiphertextStructure) , ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M12_cryptoSchema(value.CryptoSchema) ) ;
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
 public static AWS.Cryptography.StructuredEncryption.StructuredData FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M18_plaintextStructure (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M18_plaintextStructure (AWS.Cryptography.StructuredEncryption.StructuredData value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value);
}
 public static System.Exception FromDafny_CommonError(Dafny.Aws.Cryptography.StructuredEncryption.Types._IError value) {
 switch(value)
 {

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
