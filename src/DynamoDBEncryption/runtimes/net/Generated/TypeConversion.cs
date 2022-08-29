// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System.Linq; namespace AWS.Cryptography.DynamodbEncryption {
 internal static class TypeConversion {
 public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext (Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>> value) {
 return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M3_key(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M5_value(pair.Cdr));
}
 public static Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext (System.Collections.Generic.Dictionary<string, string> value) {
 return Dafny.Map<Dafny.ISequence<byte>, Dafny.ISequence<byte>>.FromCollection(value.Select(pair =>
    new Dafny.Pair<Dafny.ISequence<byte>, Dafny.ISequence<byte>>(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M3_key(pair.Key), ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M5_value(pair.Value))
));
}
 public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M3_key (Dafny.ISequence<char> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M3_key (string value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
}
 public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName (Dafny.ISequence<char> value) {
 return new string(value.Elements);
}
 public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName (string value) {
 return Dafny.Sequence<char>.FromString(value);
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M12_cryptoSchema (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S15_DDBCryptoSchema(value);
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M12_cryptoSchema (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S15_DDBCryptoSchema(value);
}
 public static string FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_Utf8Bytes (Dafny.ISequence<byte> value) {
 System.Text.UTF8Encoding utf8 = new System.Text.UTF8Encoding(false, true);
return utf8.GetString(value.Elements);
}
 public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_Utf8Bytes (string value) {
 System.Text.UTF8Encoding utf8 = new System.Text.UTF8Encoding(false, true);
return Dafny.Sequence<byte>.FromArray(utf8.GetBytes(value));
}
 public static AWS.Cryptography.DynamodbEncryption.EncryptItemInput FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput (Dafny.Aws.Cryptography.DynamodbEncryption.Types._IEncryptItemInput value) {
 Dafny.Aws.Cryptography.DynamodbEncryption.Types.EncryptItemInput concrete = (Dafny.Aws.Cryptography.DynamodbEncryption.Types.EncryptItemInput)value; AWS.Cryptography.DynamodbEncryption.EncryptItemInput converted = new AWS.Cryptography.DynamodbEncryption.EncryptItemInput();  converted.Item = (System.Collections.Generic.Dictionary<string, Com.Amazonaws.Dynamodb.AttributeValue>) FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M4_item(concrete.item);
  converted.CryptoSchema = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction>) FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M12_cryptoSchema(concrete.cryptoSchema);
 if (concrete.encryptionContext.is_Some) converted.EncryptionContext = (System.Collections.Generic.Dictionary<string, string>) FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M17_encryptionContext(concrete.encryptionContext);
 if (concrete.requiredContextFieldsOnDecrypt.is_Some) converted.RequiredContextFieldsOnDecrypt = (System.Collections.Generic.List<string>) FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M30_requiredContextFieldsOnDecrypt(concrete.requiredContextFieldsOnDecrypt);
 if (concrete.keyring.is_Some) converted.Keyring = (AWS.Cryptography.MaterialProviders.IKeyring) FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M7_keyring(concrete.keyring);
 if (concrete.cmm.is_Some) converted.Cmm = (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M3_cmm(concrete.cmm); return converted;
}
 public static Dafny.Aws.Cryptography.DynamodbEncryption.Types._IEncryptItemInput ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput (AWS.Cryptography.DynamodbEncryption.EncryptItemInput value) {
 System.Collections.Generic.Dictionary<string, string> var_encryptionContext = value.IsSetEncryptionContext() ? value.EncryptionContext : (System.Collections.Generic.Dictionary<string, string>) null;
 System.Collections.Generic.List<string> var_requiredContextFieldsOnDecrypt = value.IsSetRequiredContextFieldsOnDecrypt() ? value.RequiredContextFieldsOnDecrypt : (System.Collections.Generic.List<string>) null;
 AWS.Cryptography.MaterialProviders.IKeyring var_keyring = value.IsSetKeyring() ? value.Keyring : (AWS.Cryptography.MaterialProviders.IKeyring) null;
 AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager var_cmm = value.IsSetCmm() ? value.Cmm : (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) null;
 return new Dafny.Aws.Cryptography.DynamodbEncryption.Types.EncryptItemInput ( ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M4_item(value.Item) , ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M12_cryptoSchema(value.CryptoSchema) , ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M17_encryptionContext(var_encryptionContext) , ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M30_requiredContextFieldsOnDecrypt(var_requiredContextFieldsOnDecrypt) , ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M7_keyring(var_keyring) , ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M3_cmm(var_cmm) ) ;
}
 public static System.Collections.Generic.Dictionary<string, Com.Amazonaws.Dynamodb.AttributeValue> FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S17_DecryptItemOutput__M4_item (Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S17_DecryptItemOutput__M4_item (System.Collections.Generic.Dictionary<string, Com.Amazonaws.Dynamodb.AttributeValue> value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
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
 public static AWS.Cryptography.DynamodbEncryption.EncryptItemOutput FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S17_EncryptItemOutput (Dafny.Aws.Cryptography.DynamodbEncryption.Types._IEncryptItemOutput value) {
 Dafny.Aws.Cryptography.DynamodbEncryption.Types.EncryptItemOutput concrete = (Dafny.Aws.Cryptography.DynamodbEncryption.Types.EncryptItemOutput)value; AWS.Cryptography.DynamodbEncryption.EncryptItemOutput converted = new AWS.Cryptography.DynamodbEncryption.EncryptItemOutput();  converted.EncryptedItem = (System.Collections.Generic.Dictionary<string, Com.Amazonaws.Dynamodb.AttributeValue>) FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S17_EncryptItemOutput__M13_encryptedItem(concrete.encryptedItem); return converted;
}
 public static Dafny.Aws.Cryptography.DynamodbEncryption.Types._IEncryptItemOutput ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S17_EncryptItemOutput (AWS.Cryptography.DynamodbEncryption.EncryptItemOutput value) {

 return new Dafny.Aws.Cryptography.DynamodbEncryption.Types.EncryptItemOutput ( ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S17_EncryptItemOutput__M13_encryptedItem(value.EncryptedItem) ) ;
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DynamodbEncryption.DynamoDBTableEncryptionConfig> FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S24_DynamoDBEncryptionConfig__M12_tableConfigs (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.DynamodbEncryption.Types._IDynamoDBTableEncryptionConfig> value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S30_DynamoDBTableEncryptionConfigs(value);
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.DynamodbEncryption.Types._IDynamoDBTableEncryptionConfig> ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S24_DynamoDBEncryptionConfig__M12_tableConfigs (System.Collections.Generic.Dictionary<string, AWS.Cryptography.DynamodbEncryption.DynamoDBTableEncryptionConfig> value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S30_DynamoDBTableEncryptionConfigs(value);
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S27_DynamoDBEncryptionException__M7_message (Dafny.ISequence<char> value) {
 return FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S27_DynamoDBEncryptionException__M7_message (string value) {
 return ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static string FromDafny_N6_smithy__N3_api__S6_String (Dafny.ISequence<char> value) {
 return new string(value.Elements);
}
 public static Dafny.ISequence<char> ToDafny_N6_smithy__N3_api__S6_String (string value) {
 return Dafny.Sequence<char>.FromString(value);
}
 public static string FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M5_value (Dafny.ISequence<byte> value) {
 return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_Utf8Bytes(value);
}
 public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M5_value (string value) {
 return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_Utf8Bytes(value);
}
 public static AWS.Cryptography.StructuredEncryption.CryptoAction FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S15_DDBCryptoSchema__M5_value (Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S15_DDBCryptoSchema__M5_value (AWS.Cryptography.StructuredEncryption.CryptoAction value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction(value);
}
 public static Com.Amazonaws.Dynamodb.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue (Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue value) {
 
}
 public static Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue (Com.Amazonaws.Dynamodb.AttributeValue value) {
 
}
 public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName (Dafny.ISequence<char> value) {
 return new string(value.Elements);
}
 public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName (string value) {
 return Dafny.Sequence<char>.FromString(value);
}
 public static AWS.Cryptography.DynamodbEncryption.DecryptItemOutput FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S17_DecryptItemOutput (Dafny.Aws.Cryptography.DynamodbEncryption.Types._IDecryptItemOutput value) {
 Dafny.Aws.Cryptography.DynamodbEncryption.Types.DecryptItemOutput concrete = (Dafny.Aws.Cryptography.DynamodbEncryption.Types.DecryptItemOutput)value; AWS.Cryptography.DynamodbEncryption.DecryptItemOutput converted = new AWS.Cryptography.DynamodbEncryption.DecryptItemOutput();  converted.Item = (System.Collections.Generic.Dictionary<string, Com.Amazonaws.Dynamodb.AttributeValue>) FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S17_DecryptItemOutput__M4_item(concrete.item); return converted;
}
 public static Dafny.Aws.Cryptography.DynamodbEncryption.Types._IDecryptItemOutput ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S17_DecryptItemOutput (AWS.Cryptography.DynamodbEncryption.DecryptItemOutput value) {

 return new Dafny.Aws.Cryptography.DynamodbEncryption.Types.DecryptItemOutput ( ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S17_DecryptItemOutput__M4_item(value.Item) ) ;
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S15_DDBCryptoSchema__M3_key (Dafny.ISequence<char> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S15_DDBCryptoSchema__M3_key (string value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DynamodbEncryption.DynamoDBTableEncryptionConfig> FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S30_DynamoDBTableEncryptionConfigs (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.DynamodbEncryption.Types._IDynamoDBTableEncryptionConfig> value) {
 return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S30_DynamoDBTableEncryptionConfigs__M3_key(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S30_DynamoDBTableEncryptionConfigs__M5_value(pair.Cdr));
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.DynamodbEncryption.Types._IDynamoDBTableEncryptionConfig> ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S30_DynamoDBTableEncryptionConfigs (System.Collections.Generic.Dictionary<string, AWS.Cryptography.DynamodbEncryption.DynamoDBTableEncryptionConfig> value) {
 return Dafny.Map<Dafny.ISequence<char>, Dafny.Aws.Cryptography.DynamodbEncryption.Types._IDynamoDBTableEncryptionConfig>.FromCollection(value.Select(pair =>
    new Dafny.Pair<Dafny.ISequence<char>, Dafny.Aws.Cryptography.DynamodbEncryption.Types._IDynamoDBTableEncryptionConfig>(ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S30_DynamoDBTableEncryptionConfigs__M3_key(pair.Key), ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S30_DynamoDBTableEncryptionConfigs__M5_value(pair.Value))
));
}
 public static System.Collections.Generic.Dictionary<string, Com.Amazonaws.Dynamodb.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap (Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value) {
 return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M5_value(pair.Cdr));
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap (System.Collections.Generic.Dictionary<string, Com.Amazonaws.Dynamodb.AttributeValue> value) {
 return Dafny.Map<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue>.FromCollection(value.Select(pair =>
    new Dafny.Pair<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M5_value(pair.Value))
));
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
 public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M17_encryptionContext (Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> value) {
 return value.is_None ? (System.Collections.Generic.Dictionary<string, string>) null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M17_encryptionContext (System.Collections.Generic.Dictionary<string, string> value) {
 return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext((System.Collections.Generic.Dictionary<string, string>) value));
}
 public static Com.Amazonaws.Dynamodb.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M5_value (Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
}
 public static Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M5_value (Com.Amazonaws.Dynamodb.AttributeValue value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
}
 public static System.Collections.Generic.List<string> FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M30_requiredContextFieldsOnDecrypt (Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<byte>>> value) {
 return value.is_None ? (System.Collections.Generic.List<string>) null : FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S26_EncryptionContextFieldList(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<byte>>> ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M30_requiredContextFieldsOnDecrypt (System.Collections.Generic.List<string> value) {
 return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<byte>>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<byte>>>.create_Some(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S26_EncryptionContextFieldList((System.Collections.Generic.List<string>) value));
}
 public static string FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S26_EncryptionContextFieldList__M6_member (Dafny.ISequence<byte> value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S9_Utf8Bytes(value);
}
 public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S26_EncryptionContextFieldList__M6_member (string value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S9_Utf8Bytes(value);
}
 public static AWS.Cryptography.MaterialProviders.IKeyring FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M7_keyring (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring> value) {
 return value.is_None ? (AWS.Cryptography.MaterialProviders.IKeyring) null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring> ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M7_keyring (AWS.Cryptography.MaterialProviders.IKeyring value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference((AWS.Cryptography.MaterialProviders.IKeyring) value));
}
 public static string FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M3_key (Dafny.ISequence<byte> value) {
 return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_Utf8Bytes(value);
}
 public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext__M3_key (string value) {
 return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S9_Utf8Bytes(value);
}
 public static AWS.Cryptography.DynamodbEncryption.DynamoDBEncryptionConfig FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S24_DynamoDBEncryptionConfig (Dafny.Aws.Cryptography.DynamodbEncryption.Types._IDynamoDBEncryptionConfig value) {
 Dafny.Aws.Cryptography.DynamodbEncryption.Types.DynamoDBEncryptionConfig concrete = (Dafny.Aws.Cryptography.DynamodbEncryption.Types.DynamoDBEncryptionConfig)value; AWS.Cryptography.DynamodbEncryption.DynamoDBEncryptionConfig converted = new AWS.Cryptography.DynamodbEncryption.DynamoDBEncryptionConfig();  converted.TableConfigs = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.DynamodbEncryption.DynamoDBTableEncryptionConfig>) FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S24_DynamoDBEncryptionConfig__M12_tableConfigs(concrete.tableConfigs); return converted;
}
 public static Dafny.Aws.Cryptography.DynamodbEncryption.Types._IDynamoDBEncryptionConfig ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S24_DynamoDBEncryptionConfig (AWS.Cryptography.DynamodbEncryption.DynamoDBEncryptionConfig value) {

 return new Dafny.Aws.Cryptography.DynamodbEncryption.Types.DynamoDBEncryptionConfig ( ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S24_DynamoDBEncryptionConfig__M12_tableConfigs(value.TableConfigs) ) ;
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
 public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName (Dafny.ISequence<char> value) {
 return new string(value.Elements);
}
 public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName (string value) {
 return Dafny.Sequence<char>.FromString(value);
}
 public static AWS.Cryptography.MaterialProviders.IKeyring FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_DecryptItemInput__M7_keyring (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring> value) {
 return value.is_None ? (AWS.Cryptography.MaterialProviders.IKeyring) null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring> ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_DecryptItemInput__M7_keyring (AWS.Cryptography.MaterialProviders.IKeyring value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference((AWS.Cryptography.MaterialProviders.IKeyring) value));
}
 public static AWS.Cryptography.DynamodbEncryption.DynamoDBTableEncryptionConfig FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S30_DynamoDBTableEncryptionConfigs__M5_value (Dafny.Aws.Cryptography.DynamodbEncryption.Types._IDynamoDBTableEncryptionConfig value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S29_DynamoDBTableEncryptionConfig(value);
}
 public static Dafny.Aws.Cryptography.DynamodbEncryption.Types._IDynamoDBTableEncryptionConfig ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S30_DynamoDBTableEncryptionConfigs__M5_value (AWS.Cryptography.DynamodbEncryption.DynamoDBTableEncryptionConfig value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S29_DynamoDBTableEncryptionConfig(value);
}
 public static System.Collections.Generic.Dictionary<string, Com.Amazonaws.Dynamodb.AttributeValue> FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_DecryptItemInput__M13_encryptedItem (Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_DecryptItemInput__M13_encryptedItem (System.Collections.Generic.Dictionary<string, Com.Amazonaws.Dynamodb.AttributeValue> value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S29_DynamoDBTableEncryptionConfig__M16_partitionKeyName (Dafny.ISequence<char> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S29_DynamoDBTableEncryptionConfig__M16_partitionKeyName (string value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(value);
}
 public static AWS.Cryptography.DynamodbEncryption.DecryptItemInput FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_DecryptItemInput (Dafny.Aws.Cryptography.DynamodbEncryption.Types._IDecryptItemInput value) {
 Dafny.Aws.Cryptography.DynamodbEncryption.Types.DecryptItemInput concrete = (Dafny.Aws.Cryptography.DynamodbEncryption.Types.DecryptItemInput)value; AWS.Cryptography.DynamodbEncryption.DecryptItemInput converted = new AWS.Cryptography.DynamodbEncryption.DecryptItemInput();  converted.EncryptedItem = (System.Collections.Generic.Dictionary<string, Com.Amazonaws.Dynamodb.AttributeValue>) FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_DecryptItemInput__M13_encryptedItem(concrete.encryptedItem);
 if (concrete.encryptionContext.is_Some) converted.EncryptionContext = (System.Collections.Generic.Dictionary<string, string>) FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_DecryptItemInput__M17_encryptionContext(concrete.encryptionContext);
 if (concrete.keyring.is_Some) converted.Keyring = (AWS.Cryptography.MaterialProviders.IKeyring) FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_DecryptItemInput__M7_keyring(concrete.keyring);
 if (concrete.cmm.is_Some) converted.Cmm = (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_DecryptItemInput__M3_cmm(concrete.cmm); return converted;
}
 public static Dafny.Aws.Cryptography.DynamodbEncryption.Types._IDecryptItemInput ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_DecryptItemInput (AWS.Cryptography.DynamodbEncryption.DecryptItemInput value) {
 System.Collections.Generic.Dictionary<string, string> var_encryptionContext = value.IsSetEncryptionContext() ? value.EncryptionContext : (System.Collections.Generic.Dictionary<string, string>) null;
 AWS.Cryptography.MaterialProviders.IKeyring var_keyring = value.IsSetKeyring() ? value.Keyring : (AWS.Cryptography.MaterialProviders.IKeyring) null;
 AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager var_cmm = value.IsSetCmm() ? value.Cmm : (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) null;
 return new Dafny.Aws.Cryptography.DynamodbEncryption.Types.DecryptItemInput ( ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_DecryptItemInput__M13_encryptedItem(value.EncryptedItem) , ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_DecryptItemInput__M17_encryptionContext(var_encryptionContext) , ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_DecryptItemInput__M7_keyring(var_keyring) , ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_DecryptItemInput__M3_cmm(var_cmm) ) ;
}
 public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_DecryptItemInput__M17_encryptionContext (Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> value) {
 return value.is_None ? (System.Collections.Generic.Dictionary<string, string>) null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_DecryptItemInput__M17_encryptionContext (System.Collections.Generic.Dictionary<string, string> value) {
 return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext((System.Collections.Generic.Dictionary<string, string>) value));
}
 public static System.Collections.Generic.Dictionary<string, Com.Amazonaws.Dynamodb.AttributeValue> FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M4_item (Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M4_item (System.Collections.Generic.Dictionary<string, Com.Amazonaws.Dynamodb.AttributeValue> value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
}
 public static AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M3_cmm (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager> value) {
 return value.is_None ? (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager> ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput__M3_cmm (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference((AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) value));
}
 public static System.Collections.Generic.List<string> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S26_EncryptionContextFieldList (Dafny.ISequence<Dafny.ISequence<byte>> value) {
 return new System.Collections.Generic.List<string>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S26_EncryptionContextFieldList__M6_member));
}
 public static Dafny.ISequence<Dafny.ISequence<byte>> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S26_EncryptionContextFieldList (System.Collections.Generic.List<string> value) {
 return Dafny.Sequence<Dafny.ISequence<byte>>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S26_EncryptionContextFieldList__M6_member).ToArray());
}
 public static AWS.Cryptography.DynamodbEncryption.DynamoDBTableEncryptionConfig FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S29_DynamoDBTableEncryptionConfig (Dafny.Aws.Cryptography.DynamodbEncryption.Types._IDynamoDBTableEncryptionConfig value) {
 Dafny.Aws.Cryptography.DynamodbEncryption.Types.DynamoDBTableEncryptionConfig concrete = (Dafny.Aws.Cryptography.DynamodbEncryption.Types.DynamoDBTableEncryptionConfig)value; AWS.Cryptography.DynamodbEncryption.DynamoDBTableEncryptionConfig converted = new AWS.Cryptography.DynamodbEncryption.DynamoDBTableEncryptionConfig();  converted.PartitionKeyName = (string) FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S29_DynamoDBTableEncryptionConfig__M16_partitionKeyName(concrete.partitionKeyName);
 if (concrete.sortKeyName.is_Some) converted.SortKeyName = (string) FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S29_DynamoDBTableEncryptionConfig__M11_sortKeyName(concrete.sortKeyName); return converted;
}
 public static Dafny.Aws.Cryptography.DynamodbEncryption.Types._IDynamoDBTableEncryptionConfig ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S29_DynamoDBTableEncryptionConfig (AWS.Cryptography.DynamodbEncryption.DynamoDBTableEncryptionConfig value) {
 string var_sortKeyName = value.IsSetSortKeyName() ? value.SortKeyName : (string) null;
 return new Dafny.Aws.Cryptography.DynamodbEncryption.Types.DynamoDBTableEncryptionConfig ( ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S29_DynamoDBTableEncryptionConfig__M16_partitionKeyName(value.PartitionKeyName) , ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S29_DynamoDBTableEncryptionConfig__M11_sortKeyName(var_sortKeyName) ) ;
}
 public static System.Collections.Generic.Dictionary<string, Com.Amazonaws.Dynamodb.AttributeValue> FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S17_EncryptItemOutput__M13_encryptedItem (Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S17_EncryptItemOutput__M13_encryptedItem (System.Collections.Generic.Dictionary<string, Com.Amazonaws.Dynamodb.AttributeValue> value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S29_DynamoDBTableEncryptionConfig__M11_sortKeyName (Wrappers_Compile._IOption<Dafny.ISequence<char>> value) {
 return value.is_None ? (string) null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S29_DynamoDBTableEncryptionConfig__M11_sortKeyName (string value) {
 return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName((string) value));
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S15_DDBCryptoSchema (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> value) {
 return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S15_DDBCryptoSchema__M3_key(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S15_DDBCryptoSchema__M5_value(pair.Cdr));
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S15_DDBCryptoSchema (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> value) {
 return Dafny.Map<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction>.FromCollection(value.Select(pair =>
    new Dafny.Pair<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction>(ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S15_DDBCryptoSchema__M3_key(pair.Key), ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S15_DDBCryptoSchema__M5_value(pair.Value))
));
}
 public static string FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S9_Utf8Bytes (Dafny.ISequence<byte> value) {
 System.Text.UTF8Encoding utf8 = new System.Text.UTF8Encoding(false, true);
return utf8.GetString(value.Elements);
}
 public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S9_Utf8Bytes (string value) {
 System.Text.UTF8Encoding utf8 = new System.Text.UTF8Encoding(false, true);
return Dafny.Sequence<byte>.FromArray(utf8.GetBytes(value));
}
 public static AWS.Cryptography.DynamodbEncryption.DynamoDBEncryptionException FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S27_DynamoDBEncryptionException (Dafny.Aws.Cryptography.DynamodbEncryption.Types.Error_DynamoDBEncryptionException value) {
 return new AWS.Cryptography.DynamodbEncryption.DynamoDBEncryptionException (
 FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S27_DynamoDBEncryptionException__M7_message(value.message)
 ) ;
}
 public static Dafny.Aws.Cryptography.DynamodbEncryption.Types.Error_DynamoDBEncryptionException ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S27_DynamoDBEncryptionException (AWS.Cryptography.DynamodbEncryption.DynamoDBEncryptionException value) {

 return new Dafny.Aws.Cryptography.DynamodbEncryption.Types.Error_DynamoDBEncryptionException (
 ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S27_DynamoDBEncryptionException__M7_message(value.Message)
 ) ;
}
 public static AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_DecryptItemInput__M3_cmm (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager> value) {
 return value.is_None ? (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager> ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_DecryptItemInput__M3_cmm (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference((AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) value));
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S30_DynamoDBTableEncryptionConfigs__M3_key (Dafny.ISequence<char> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S30_DynamoDBTableEncryptionConfigs__M3_key (string value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(value);
}
 public static System.Exception FromDafny_CommonError(Dafny.Aws.Cryptography.DynamodbEncryption.Types._IError value) {
 switch(value)
 {
 case Dafny.Aws.Cryptography.DynamodbEncryption.Types.Error_DynamoDBEncryptionException dafnyVal:
return FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S27_DynamoDBEncryptionException(dafnyVal);
 case Dafny.Aws.Cryptography.DynamodbEncryption.Types.Error_Opaque dafnyVal:
 return new OpaqueError(dafnyVal.obj);
 default:
 // The switch MUST be complete for _IError, so `value` MUST NOT be an _IError. (How did you get here?) 
 return new OpaqueError();
}
}
 public static Dafny.Aws.Cryptography.DynamodbEncryption.Types._IError ToDafny_CommonError(System.Exception value) {
 switch (value)
 {
 case AWS.Cryptography.DynamodbEncryption.DynamoDBEncryptionException exception:
 return ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S27_DynamoDBEncryptionException(exception);
 // OpaqueError is redundant, but listed for completeness.
 case OpaqueError exception:
 return new Dafny.Aws.Cryptography.DynamodbEncryption.Types.Error_Opaque(exception);
 case System.Exception exception:
 return new Dafny.Aws.Cryptography.DynamodbEncryption.Types.Error_Opaque(exception);
 default:
 // The switch MUST be complete for System.Exception, so `value` MUST NOT be an System.Exception. (How did you get here?) 
 return new Dafny.Aws.Cryptography.DynamodbEncryption.Types.Error_Opaque(value);
}
}
}
}
