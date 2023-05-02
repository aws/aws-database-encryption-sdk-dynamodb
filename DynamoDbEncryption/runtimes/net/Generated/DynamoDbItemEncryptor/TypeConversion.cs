// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System.Linq; using System; namespace AWS.Cryptography.DynamoDbEncryption.ItemEncryptor {
 public static class TypeConversion {
 public static AWS.Cryptography.Primitives.AtomicPrimitives FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S25_AtomicPrimitivesReference (Dafny.Aws.Cryptography.Primitives.Types.IAwsCryptographicPrimitivesClient value) {
 if (value is Dafny.Aws.Cryptography.Primitives.Types.IAwsCryptographicPrimitivesClient dafnyValue) {
    return new AWS.Cryptography.Primitives.AtomicPrimitives(dafnyValue);
}
 throw new System.ArgumentException("Custom implementations of AWS.Cryptography.Primitives.AtomicPrimitives are not supported yet");
}
 public static Dafny.Aws.Cryptography.Primitives.Types.IAwsCryptographicPrimitivesClient ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S25_AtomicPrimitivesReference (AWS.Cryptography.Primitives.AtomicPrimitives value) {
 if (value is AWS.Cryptography.Primitives.AtomicPrimitives nativeValue) {
    return nativeValue.impl();
}
 throw new System.ArgumentException("Custom implementations of AWS.Cryptography.Primitives.AtomicPrimitives are not supported yet");
}
 public static AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.DecryptItemInput FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S16_DecryptItemInput (Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IDecryptItemInput value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemInput concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemInput)value;
 AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.DecryptItemInput converted = new AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.DecryptItemInput();
  converted.EncryptedItem = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>) Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(concrete._encryptedItem);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IDecryptItemInput ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S16_DecryptItemInput (AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.DecryptItemInput value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemInput ( Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value.EncryptedItem) ) ;
}
 public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S16_DecryptItemInput__M13_encryptedItem (Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value) {
 return Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S16_DecryptItemInput__M13_encryptedItem (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value) {
 return Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.DecryptItemOutput FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S17_DecryptItemOutput (Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IDecryptItemOutput value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput)value;
 AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.DecryptItemOutput converted = new AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.DecryptItemOutput();
  converted.PlaintextItem = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>) Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(concrete._plaintextItem);
 if (concrete._parsedHeader.is_Some) converted.ParsedHeader = (AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.ParsedHeader) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S12_ParsedHeader(concrete._parsedHeader.dtor_value);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IDecryptItemOutput ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S17_DecryptItemOutput (AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.DecryptItemOutput value) {
 Wrappers_Compile._IOption<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IParsedHeader> var_parsedHeader =
	value.IsSetParsedHeader() ?
 	new Wrappers_Compile.Option_Some<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IParsedHeader>(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S12_ParsedHeader(value.ParsedHeader))
 	: new Wrappers_Compile.Option_None<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IParsedHeader>();
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput ( Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value.PlaintextItem) ,
 var_parsedHeader ) ;
}
 public static AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.ParsedHeader FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S17_DecryptItemOutput__M12_parsedHeader (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IParsedHeader> value) {
 return value.is_None ? (AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.ParsedHeader) null : FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S12_ParsedHeader(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IParsedHeader> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S17_DecryptItemOutput__M12_parsedHeader (AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.ParsedHeader value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IParsedHeader>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IParsedHeader>.create_Some(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S12_ParsedHeader((AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.ParsedHeader) value));
}
 public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S17_DecryptItemOutput__M13_plaintextItem (Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value) {
 return Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S17_DecryptItemOutput__M13_plaintextItem (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value) {
 return Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorConfig FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig (Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IDynamoDbItemEncryptorConfig value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DynamoDbItemEncryptorConfig concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DynamoDbItemEncryptorConfig)value;
 AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorConfig converted = new AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorConfig();
  converted.TableName = (string) Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(concrete._tableName);
  converted.PartitionKeyName = (string) Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(concrete._partitionKeyName);
 if (concrete._sortKeyName.is_Some) converted.SortKeyName = (string) Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(concrete._sortKeyName.dtor_value);
  converted.AttributeActions = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction>) AWS.Cryptography.DynamoDbEncryption.TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_AttributeActions(concrete._attributeActions);
 if (concrete._allowedUnauthenticatedAttributes.is_Some) converted.AllowedUnauthenticatedAttributes = (System.Collections.Generic.List<string>) Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList(concrete._allowedUnauthenticatedAttributes.dtor_value);
 if (concrete._allowedUnauthenticatedAttributePrefix.is_Some) converted.AllowedUnauthenticatedAttributePrefix = (string) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(concrete._allowedUnauthenticatedAttributePrefix.dtor_value);
 if (concrete._algorithmSuiteId.is_Some) converted.AlgorithmSuiteId = (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId) AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(concrete._algorithmSuiteId.dtor_value);
 if (concrete._keyring.is_Some) converted.Keyring = (AWS.Cryptography.MaterialProviders.IKeyring) AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference(concrete._keyring.dtor_value);
 if (concrete._cmm.is_Some) converted.Cmm = (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(concrete._cmm.dtor_value);
 if (concrete._legacyConfig.is_Some) converted.LegacyConfig = (AWS.Cryptography.DynamoDbEncryption.LegacyConfig) AWS.Cryptography.DynamoDbEncryption.TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyConfig(concrete._legacyConfig.dtor_value);
 if (concrete._plaintextPolicy.is_Some) converted.PlaintextPolicy = (AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy) AWS.Cryptography.DynamoDbEncryption.TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_PlaintextPolicy(concrete._plaintextPolicy.dtor_value);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IDynamoDbItemEncryptorConfig ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig (AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorConfig value) {
 Wrappers_Compile._IOption<Dafny.ISequence<char>> var_sortKeyName =
	value.IsSetSortKeyName() ?
 	new Wrappers_Compile.Option_Some<Dafny.ISequence<char>>(Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(value.SortKeyName))
 	: new Wrappers_Compile.Option_None<Dafny.ISequence<char>>();
 Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> var_allowedUnauthenticatedAttributes =
	value.IsSetAllowedUnauthenticatedAttributes() ?
 	new Wrappers_Compile.Option_Some<Dafny.ISequence<Dafny.ISequence<char>>>(Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList(value.AllowedUnauthenticatedAttributes))
 	: new Wrappers_Compile.Option_None<Dafny.ISequence<Dafny.ISequence<char>>>();
 Wrappers_Compile._IOption<Dafny.ISequence<char>> var_allowedUnauthenticatedAttributePrefix =
	value.IsSetAllowedUnauthenticatedAttributePrefix() ?
 	new Wrappers_Compile.Option_Some<Dafny.ISequence<char>>(Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value.AllowedUnauthenticatedAttributePrefix))
 	: new Wrappers_Compile.Option_None<Dafny.ISequence<char>>();
 Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId> var_algorithmSuiteId =
	value.IsSetAlgorithmSuiteId() ?
 	new Wrappers_Compile.Option_Some<Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId>(AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value.AlgorithmSuiteId))
 	: new Wrappers_Compile.Option_None<Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId>();
 Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring> var_keyring =
	value.IsSetKeyring() ?
 	new Wrappers_Compile.Option_Some<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring>(AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference(value.Keyring))
 	: new Wrappers_Compile.Option_None<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring>();
 Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager> var_cmm =
	value.IsSetCmm() ?
 	new Wrappers_Compile.Option_Some<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager>(AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value.Cmm))
 	: new Wrappers_Compile.Option_None<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager>();
 Wrappers_Compile._IOption<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILegacyConfig> var_legacyConfig =
	value.IsSetLegacyConfig() ?
 	new Wrappers_Compile.Option_Some<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILegacyConfig>(AWS.Cryptography.DynamoDbEncryption.TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyConfig(value.LegacyConfig))
 	: new Wrappers_Compile.Option_None<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILegacyConfig>();
 Wrappers_Compile._IOption<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IPlaintextPolicy> var_plaintextPolicy =
	value.IsSetPlaintextPolicy() ?
 	new Wrappers_Compile.Option_Some<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IPlaintextPolicy>(AWS.Cryptography.DynamoDbEncryption.TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_PlaintextPolicy(value.PlaintextPolicy))
 	: new Wrappers_Compile.Option_None<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IPlaintextPolicy>();
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DynamoDbItemEncryptorConfig ( Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(value.TableName) ,
 Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(value.PartitionKeyName) ,
 var_sortKeyName ,
 AWS.Cryptography.DynamoDbEncryption.TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_AttributeActions(value.AttributeActions) ,
 var_allowedUnauthenticatedAttributes ,
 var_allowedUnauthenticatedAttributePrefix ,
 var_algorithmSuiteId ,
 var_keyring ,
 var_cmm ,
 var_legacyConfig ,
 var_plaintextPolicy ) ;
}
 public static AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_algorithmSuiteId (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId> value) {
 return value.is_None ? (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId) null : AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_algorithmSuiteId (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId>.create_Some(AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId((AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId) value));
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M37_allowedUnauthenticatedAttributePrefix (Wrappers_Compile._IOption<Dafny.ISequence<char>> value) {
 return value.is_None ? (string) null : Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M37_allowedUnauthenticatedAttributePrefix (string value) {
 return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String((string) value));
}
 public static System.Collections.Generic.List<string> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M32_allowedUnauthenticatedAttributes (Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> value) {
 return value.is_None ? (System.Collections.Generic.List<string>) null : Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M32_allowedUnauthenticatedAttributes (System.Collections.Generic.List<string> value) {
 return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<char>>>.create_Some(Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList((System.Collections.Generic.List<string>) value));
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_attributeActions (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> value) {
 return AWS.Cryptography.DynamoDbEncryption.TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_AttributeActions(value);
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_attributeActions (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> value) {
 return AWS.Cryptography.DynamoDbEncryption.TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_AttributeActions(value);
}
 public static AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M3_cmm (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager> value) {
 return value.is_None ? (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) null : AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M3_cmm (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager>.create_Some(AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference((AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) value));
}
 public static AWS.Cryptography.MaterialProviders.IKeyring FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M7_keyring (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring> value) {
 return value.is_None ? (AWS.Cryptography.MaterialProviders.IKeyring) null : AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M7_keyring (AWS.Cryptography.MaterialProviders.IKeyring value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring>.create_Some(AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference((AWS.Cryptography.MaterialProviders.IKeyring) value));
}
 public static AWS.Cryptography.DynamoDbEncryption.LegacyConfig FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M12_legacyConfig (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILegacyConfig> value) {
 return value.is_None ? (AWS.Cryptography.DynamoDbEncryption.LegacyConfig) null : AWS.Cryptography.DynamoDbEncryption.TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyConfig(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILegacyConfig> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M12_legacyConfig (AWS.Cryptography.DynamoDbEncryption.LegacyConfig value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILegacyConfig>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILegacyConfig>.create_Some(AWS.Cryptography.DynamoDbEncryption.TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyConfig((AWS.Cryptography.DynamoDbEncryption.LegacyConfig) value));
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_partitionKeyName (Dafny.ISequence<char> value) {
 return Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M16_partitionKeyName (string value) {
 return Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M15_plaintextPolicy (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IPlaintextPolicy> value) {
 return value.is_None ? (AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy) null : AWS.Cryptography.DynamoDbEncryption.TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_PlaintextPolicy(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IPlaintextPolicy> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M15_plaintextPolicy (AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IPlaintextPolicy>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IPlaintextPolicy>.create_Some(AWS.Cryptography.DynamoDbEncryption.TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_PlaintextPolicy((AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy) value));
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M11_sortKeyName (Wrappers_Compile._IOption<Dafny.ISequence<char>> value) {
 return value.is_None ? (string) null : Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M11_sortKeyName (string value) {
 return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName((string) value));
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M9_tableName (Dafny.ISequence<char> value) {
 return Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig__M9_tableName (string value) {
 return Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorException FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S30_DynamoDbItemEncryptorException (Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error_DynamoDbItemEncryptorException value) {
 return new AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorException (
 FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S30_DynamoDbItemEncryptorException__M7_message(value._message)
 ) ;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error_DynamoDbItemEncryptorException ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S30_DynamoDbItemEncryptorException (AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorException value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error_DynamoDbItemEncryptorException (
 Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value.Message)
 ) ;
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S30_DynamoDbItemEncryptorException__M7_message (Dafny.ISequence<char> value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S30_DynamoDbItemEncryptorException__M7_message (string value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.EncryptItemInput FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S16_EncryptItemInput (Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IEncryptItemInput value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemInput concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemInput)value;
 AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.EncryptItemInput converted = new AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.EncryptItemInput();
  converted.PlaintextItem = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>) Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(concrete._plaintextItem);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IEncryptItemInput ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S16_EncryptItemInput (AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.EncryptItemInput value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemInput ( Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value.PlaintextItem) ) ;
}
 public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S16_EncryptItemInput__M13_plaintextItem (Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value) {
 return Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S16_EncryptItemInput__M13_plaintextItem (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value) {
 return Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.EncryptItemOutput FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S17_EncryptItemOutput (Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IEncryptItemOutput value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput)value;
 AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.EncryptItemOutput converted = new AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.EncryptItemOutput();
  converted.EncryptedItem = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>) Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(concrete._encryptedItem);
 if (concrete._parsedHeader.is_Some) converted.ParsedHeader = (AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.ParsedHeader) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S12_ParsedHeader(concrete._parsedHeader.dtor_value);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IEncryptItemOutput ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S17_EncryptItemOutput (AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.EncryptItemOutput value) {
 Wrappers_Compile._IOption<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IParsedHeader> var_parsedHeader =
	value.IsSetParsedHeader() ?
 	new Wrappers_Compile.Option_Some<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IParsedHeader>(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S12_ParsedHeader(value.ParsedHeader))
 	: new Wrappers_Compile.Option_None<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IParsedHeader>();
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput ( Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value.EncryptedItem) ,
 var_parsedHeader ) ;
}
 public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S17_EncryptItemOutput__M13_encryptedItem (Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value) {
 return Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S17_EncryptItemOutput__M13_encryptedItem (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value) {
 return Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.ParsedHeader FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S17_EncryptItemOutput__M12_parsedHeader (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IParsedHeader> value) {
 return value.is_None ? (AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.ParsedHeader) null : FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S12_ParsedHeader(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IParsedHeader> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S17_EncryptItemOutput__M12_parsedHeader (AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.ParsedHeader value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IParsedHeader>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IParsedHeader>.create_Some(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S12_ParsedHeader((AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.ParsedHeader) value));
}
 public static AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.ParsedHeader FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S12_ParsedHeader (Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IParsedHeader value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.ParsedHeader concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.ParsedHeader)value;
 AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.ParsedHeader converted = new AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.ParsedHeader();
  converted.AttributeActions = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction>) AWS.Cryptography.DynamoDbEncryption.TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_AttributeActions(concrete._attributeActions);
  converted.AlgorithmSuiteId = (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId) AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(concrete._algorithmSuiteId);
  converted.EncryptedDataKeys = (System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey>) AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList(concrete._encryptedDataKeys);
  converted.StoredEncryptionContext = (System.Collections.Generic.Dictionary<string, string>) AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(concrete._storedEncryptionContext);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IParsedHeader ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S12_ParsedHeader (AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.ParsedHeader value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.ParsedHeader ( AWS.Cryptography.DynamoDbEncryption.TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_AttributeActions(value.AttributeActions) ,
 AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value.AlgorithmSuiteId) ,
 AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList(value.EncryptedDataKeys) ,
 AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value.StoredEncryptionContext) ) ;
}
 public static AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S12_ParsedHeader__M16_algorithmSuiteId (Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId value) {
 return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value);
}
 public static Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S12_ParsedHeader__M16_algorithmSuiteId (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId value) {
 return AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value);
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S12_ParsedHeader__M16_attributeActions (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> value) {
 return AWS.Cryptography.DynamoDbEncryption.TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_AttributeActions(value);
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S12_ParsedHeader__M16_attributeActions (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> value) {
 return AWS.Cryptography.DynamoDbEncryption.TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_AttributeActions(value);
}
 public static System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S12_ParsedHeader__M17_encryptedDataKeys (Dafny.ISequence<Dafny.Aws.Cryptography.MaterialProviders.Types._IEncryptedDataKey> value) {
 return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList(value);
}
 public static Dafny.ISequence<Dafny.Aws.Cryptography.MaterialProviders.Types._IEncryptedDataKey> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S12_ParsedHeader__M17_encryptedDataKeys (System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey> value) {
 return AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList(value);
}
 public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S12_ParsedHeader__M23_storedEncryptionContext (Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>> value) {
 return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value);
}
 public static Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S12_ParsedHeader__M23_storedEncryptionContext (System.Collections.Generic.Dictionary<string, string> value) {
 return AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value);
}
 public static string FromDafny_N6_smithy__N3_api__S6_String (Dafny.ISequence<char> value) {
 return new string(value.Elements);
}
 public static Dafny.ISequence<char> ToDafny_N6_smithy__N3_api__S6_String (string value) {
 return Dafny.Sequence<char>.FromString(value);
}
 public static System.IO.MemoryStream FromDafny_N6_smithy__N3_api__S4_Blob (Dafny.ISequence<byte> value) {
 return new System.IO.MemoryStream(value.Elements);
}
 public static Dafny.ISequence<byte> ToDafny_N6_smithy__N3_api__S4_Blob (System.IO.MemoryStream value) {
 return Dafny.Sequence<byte>.FromArray(value.ToArray());
}
 public static System.Exception FromDafny_CommonError(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IError value) {
 switch(value)
 {
 case Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error_AwsCryptographyDynamoDbEncryption dafnyVal:
  return AWS.Cryptography.DynamoDbEncryption.TypeConversion.FromDafny_CommonError(
    dafnyVal._AwsCryptographyDynamoDbEncryption
  );
 case Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error_ComAmazonawsDynamodb dafnyVal:
  return Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_CommonError(
    dafnyVal._ComAmazonawsDynamodb
  );
 case Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error_AwsCryptographyStructuredEncryption dafnyVal:
  return AWS.Cryptography.StructuredEncryption.TypeConversion.FromDafny_CommonError(
    dafnyVal._AwsCryptographyStructuredEncryption
  );
 case Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error_AwsCryptographyMaterialProviders dafnyVal:
  return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_CommonError(
    dafnyVal._AwsCryptographyMaterialProviders
  );
 case Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error_DynamoDbItemEncryptorException dafnyVal:
return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S30_DynamoDbItemEncryptorException(dafnyVal);
 case Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error_CollectionOfErrors dafnyVal:
 return new CollectionOfErrors(new System.Collections.Generic.List<Exception>(dafnyVal._list.Elements.Select(x => TypeConversion.FromDafny_CommonError(x))));
 case Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error_Opaque dafnyVal:
 return new OpaqueError(dafnyVal._obj);
 default:
 // The switch MUST be complete for _IError, so `value` MUST NOT be an _IError. (How did you get here?)
 return new OpaqueError();
}
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IError ToDafny_CommonError(System.Exception value) {
 switch (value.GetType().Namespace) {
 case "AWS.Cryptography.DynamoDbEncryption":
  return Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_AwsCryptographyDynamoDbEncryption(
    AWS.Cryptography.DynamoDbEncryption.TypeConversion.ToDafny_CommonError(value)
  );
 case "AWS.Cryptography.StructuredEncryption":
  return Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_AwsCryptographyStructuredEncryption(
    AWS.Cryptography.StructuredEncryption.TypeConversion.ToDafny_CommonError(value)
  );
 case "AWS.Cryptography.MaterialProviders":
  return Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_AwsCryptographyMaterialProviders(
    AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_CommonError(value)
  );
 case "Com.Amazonaws.Dynamodb":
  return Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_ComAmazonawsDynamodb(
    Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_CommonError(value)
  );
}
 switch (value)
 {
 case AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorException exception:
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S30_DynamoDbItemEncryptorException(exception);
 case CollectionOfErrors collectionOfErrors:
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error_CollectionOfErrors(
     Dafny.Sequence<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IError>
     .FromArray(
         collectionOfErrors.list.Select
             (x => TypeConversion.ToDafny_CommonError(x))
         .ToArray()
     )
 );

 // OpaqueError is redundant, but listed for completeness.
 case OpaqueError exception:
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error_Opaque(exception);
 case System.Exception exception:
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error_Opaque(exception);
 default:
 // The switch MUST be complete for System.Exception, so `value` MUST NOT be an System.Exception. (How did you get here?)
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error_Opaque(value);
}
}
}
}
