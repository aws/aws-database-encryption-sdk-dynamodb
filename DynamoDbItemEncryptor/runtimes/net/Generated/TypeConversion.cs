// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System.Linq; using System; namespace AWS.Cryptography.DynamoDbEncryption.Resources {
 public static class TypeConversion {
 internal static AWS.Cryptography.DynamoDbEncryption.Resources.CreateDynamoDbEncryptionBranchKeyIdSupplierInput FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput (Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._ICreateDynamoDbEncryptionBranchKeyIdSupplierInput value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput)value; AWS.Cryptography.DynamoDbEncryption.Resources.CreateDynamoDbEncryptionBranchKeyIdSupplierInput converted = new AWS.Cryptography.DynamoDbEncryption.Resources.CreateDynamoDbEncryptionBranchKeyIdSupplierInput(); if (concrete._ddbItemBranchKeyIdSupplier.is_Some) converted.DdbItemBranchKeyIdSupplier = (AWS.Cryptography.DynamoDbEncryption.Resources.IDynamoDbItemBranchKeyIdSupplier) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput__M26_ddbItemBranchKeyIdSupplier(concrete._ddbItemBranchKeyIdSupplier); return converted;
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._ICreateDynamoDbEncryptionBranchKeyIdSupplierInput ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput (AWS.Cryptography.DynamoDbEncryption.Resources.CreateDynamoDbEncryptionBranchKeyIdSupplierInput value) {
 AWS.Cryptography.DynamoDbEncryption.Resources.IDynamoDbItemBranchKeyIdSupplier var_ddbItemBranchKeyIdSupplier = value.IsSetDdbItemBranchKeyIdSupplier() ? value.DdbItemBranchKeyIdSupplier : (AWS.Cryptography.DynamoDbEncryption.Resources.IDynamoDbItemBranchKeyIdSupplier) null;
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput__M26_ddbItemBranchKeyIdSupplier(var_ddbItemBranchKeyIdSupplier) ) ;
}
 internal static AWS.Cryptography.DynamoDbEncryption.Resources.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput (Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._ICreateDynamoDbEncryptionBranchKeyIdSupplierOutput value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput)value; AWS.Cryptography.DynamoDbEncryption.Resources.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput converted = new AWS.Cryptography.DynamoDbEncryption.Resources.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(); if (concrete._branchKeyIdSupplier.is_Some) converted.BranchKeyIdSupplier = (AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput__M19_branchKeyIdSupplier(concrete._branchKeyIdSupplier); return converted;
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._ICreateDynamoDbEncryptionBranchKeyIdSupplierOutput ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput (AWS.Cryptography.DynamoDbEncryption.Resources.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput value) {
 AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier var_branchKeyIdSupplier = value.IsSetBranchKeyIdSupplier() ? value.BranchKeyIdSupplier : (AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier) null;
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput__M19_branchKeyIdSupplier(var_branchKeyIdSupplier) ) ;
}
 internal static AWS.Cryptography.DynamoDbEncryption.Resources.DynamoDbEncryptionResourcesConfig FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S33_DynamoDbEncryptionResourcesConfig (Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IDynamoDbEncryptionResourcesConfig value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.DynamoDbEncryptionResourcesConfig concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.DynamoDbEncryptionResourcesConfig)value; AWS.Cryptography.DynamoDbEncryption.Resources.DynamoDbEncryptionResourcesConfig converted = new AWS.Cryptography.DynamoDbEncryption.Resources.DynamoDbEncryptionResourcesConfig();  return converted;
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IDynamoDbEncryptionResourcesConfig ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S33_DynamoDbEncryptionResourcesConfig (AWS.Cryptography.DynamoDbEncryption.Resources.DynamoDbEncryptionResourcesConfig value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.DynamoDbEncryptionResourcesConfig (  ) ;
}
 internal static AWS.Cryptography.DynamoDbEncryption.Resources.DynamoDbEncryptionResourcesException FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S36_DynamoDbEncryptionResourcesException (Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.Error_DynamoDbEncryptionResourcesException value) {
 return new AWS.Cryptography.DynamoDbEncryption.Resources.DynamoDbEncryptionResourcesException (
 FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S36_DynamoDbEncryptionResourcesException__M7_message(value._message)
 ) ;
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.Error_DynamoDbEncryptionResourcesException ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S36_DynamoDbEncryptionResourcesException (AWS.Cryptography.DynamoDbEncryption.Resources.DynamoDbEncryptionResourcesException value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.Error_DynamoDbEncryptionResourcesException (
 ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S36_DynamoDbEncryptionResourcesException__M7_message(value.Message)
 ) ;
}
 internal static AWS.Cryptography.DynamoDbEncryption.Resources.GetBranchKeyIdFromItemInput FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S27_GetBranchKeyIdFromItemInput (Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IGetBranchKeyIdFromItemInput value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.GetBranchKeyIdFromItemInput concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.GetBranchKeyIdFromItemInput)value; AWS.Cryptography.DynamoDbEncryption.Resources.GetBranchKeyIdFromItemInput converted = new AWS.Cryptography.DynamoDbEncryption.Resources.GetBranchKeyIdFromItemInput();  converted.DdbItem = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S27_GetBranchKeyIdFromItemInput__M7_ddbItem(concrete._ddbItem); return converted;
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IGetBranchKeyIdFromItemInput ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S27_GetBranchKeyIdFromItemInput (AWS.Cryptography.DynamoDbEncryption.Resources.GetBranchKeyIdFromItemInput value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.GetBranchKeyIdFromItemInput ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S27_GetBranchKeyIdFromItemInput__M7_ddbItem(value.DdbItem) ) ;
}
 internal static AWS.Cryptography.DynamoDbEncryption.Resources.GetBranchKeyIdFromItemOutput FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S28_GetBranchKeyIdFromItemOutput (Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IGetBranchKeyIdFromItemOutput value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.GetBranchKeyIdFromItemOutput concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.GetBranchKeyIdFromItemOutput)value; AWS.Cryptography.DynamoDbEncryption.Resources.GetBranchKeyIdFromItemOutput converted = new AWS.Cryptography.DynamoDbEncryption.Resources.GetBranchKeyIdFromItemOutput();  converted.BranchKeyId = (string) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S28_GetBranchKeyIdFromItemOutput__M11_branchKeyId(concrete._branchKeyId); return converted;
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IGetBranchKeyIdFromItemOutput ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S28_GetBranchKeyIdFromItemOutput (AWS.Cryptography.DynamoDbEncryption.Resources.GetBranchKeyIdFromItemOutput value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.GetBranchKeyIdFromItemOutput ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S28_GetBranchKeyIdFromItemOutput__M11_branchKeyId(value.BranchKeyId) ) ;
}
 internal static AWS.Cryptography.DynamoDbEncryption.Resources.IDynamoDbItemBranchKeyIdSupplier FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput__M26_ddbItemBranchKeyIdSupplier (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.IDynamoDbItemBranchKeyIdSupplier> value) {
 return value.is_None ? (AWS.Cryptography.DynamoDbEncryption.Resources.IDynamoDbItemBranchKeyIdSupplier) null : FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S40_DynamoDbItemBranchKeyIdSupplierReference(value.Extract());
}
 internal static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.IDynamoDbItemBranchKeyIdSupplier> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput__M26_ddbItemBranchKeyIdSupplier (AWS.Cryptography.DynamoDbEncryption.Resources.IDynamoDbItemBranchKeyIdSupplier value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.IDynamoDbItemBranchKeyIdSupplier>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.IDynamoDbItemBranchKeyIdSupplier>.create_Some(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S40_DynamoDbItemBranchKeyIdSupplierReference((AWS.Cryptography.DynamoDbEncryption.Resources.IDynamoDbItemBranchKeyIdSupplier) value));
}
 internal static AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput__M19_branchKeyIdSupplier (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.IBranchKeyIdSupplier> value) {
 return value.is_None ? (AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier) null : FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference(value.Extract());
}
 internal static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.IBranchKeyIdSupplier> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput__M19_branchKeyIdSupplier (AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.IBranchKeyIdSupplier>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.IBranchKeyIdSupplier>.create_Some(ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference((AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier) value));
}
 internal static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S36_DynamoDbEncryptionResourcesException__M7_message (Dafny.ISequence<char> value) {
 return FromDafny_N6_smithy__N3_api__S6_String(value);
}
 internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S36_DynamoDbEncryptionResourcesException__M7_message (string value) {
 return ToDafny_N6_smithy__N3_api__S6_String(value);
}
 internal static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S27_GetBranchKeyIdFromItemInput__M7_ddbItem (Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
}
 internal static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S27_GetBranchKeyIdFromItemInput__M7_ddbItem (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
}
 internal static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S28_GetBranchKeyIdFromItemOutput__M11_branchKeyId (Dafny.ISequence<char> value) {
 return FromDafny_N6_smithy__N3_api__S6_String(value);
}
 internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S28_GetBranchKeyIdFromItemOutput__M11_branchKeyId (string value) {
 return ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.Resources.IDynamoDbItemBranchKeyIdSupplier FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S40_DynamoDbItemBranchKeyIdSupplierReference (Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.IDynamoDbItemBranchKeyIdSupplier value) {
 if (value is NativeWrapper_DynamoDbItemBranchKeyIdSupplier nativeWrapper) return nativeWrapper._impl;
return new DynamoDbItemBranchKeyIdSupplier(value);

}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.IDynamoDbItemBranchKeyIdSupplier ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S40_DynamoDbItemBranchKeyIdSupplierReference (AWS.Cryptography.DynamoDbEncryption.Resources.IDynamoDbItemBranchKeyIdSupplier value) {
 switch (value)
 {
 case DynamoDbItemBranchKeyIdSupplier valueWithImpl:
    return valueWithImpl._impl;
 case DynamoDbItemBranchKeyIdSupplierBase nativeImpl:
    return new NativeWrapper_DynamoDbItemBranchKeyIdSupplier(nativeImpl);
 default:
    throw new System.ArgumentException(
        "Custom implementations of DynamoDbItemBranchKeyIdSupplier must extend DynamoDbItemBranchKeyIdSupplierBase.");
}
}
 internal static AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference (Dafny.Aws.Cryptography.MaterialProviders.Types.IBranchKeyIdSupplier value) {
 // This is converting a reference type in a dependant module.
 // Therefore it defers to the dependant module for conversion
 return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference(value);
}
 internal static Dafny.Aws.Cryptography.MaterialProviders.Types.IBranchKeyIdSupplier ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference (AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier value) {
 // This is converting a reference type in a dependant module.
 // Therefore it defers to the dependant module for conversion
 return AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference(value);
}
 internal static string FromDafny_N6_smithy__N3_api__S6_String (Dafny.ISequence<char> value) {
 return new string(value.Elements);
}
 internal static Dafny.ISequence<char> ToDafny_N6_smithy__N3_api__S6_String (string value) {
 return Dafny.Sequence<char>.FromString(value);
}
 internal static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap (Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value) {
 return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M5_value(pair.Cdr));
}
 internal static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value) {
 return Dafny.Map<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue>.FromCollection(value.Select(pair =>
    new Dafny.Pair<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M5_value(pair.Value))
));
}
 internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M3_key (Dafny.ISequence<char> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
}
 internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M3_key (string value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
}
 internal static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M5_value (Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
}
 internal static Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M5_value (Amazon.DynamoDBv2.Model.AttributeValue value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
}
 internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName (Dafny.ISequence<char> value) {
 return new string(value.Elements);
}
 internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName (string value) {
 return Dafny.Sequence<char>.FromString(value);
}
 internal static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue (Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue value) {
 Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue concrete = (Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue)value;
 var converted = new Amazon.DynamoDBv2.Model.AttributeValue(); if (value.is_S) {
 converted.S = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_S(concrete.dtor_S);
 return converted;
} if (value.is_N) {
 converted.N = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_N(concrete.dtor_N);
 return converted;
} if (value.is_B) {
 converted.B = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_B(concrete.dtor_B);
 return converted;
} if (value.is_SS) {
 converted.SS = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_SS(concrete.dtor_SS);
 return converted;
} if (value.is_NS) {
 converted.NS = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_NS(concrete.dtor_NS);
 return converted;
} if (value.is_BS) {
 converted.BS = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_BS(concrete.dtor_BS);
 return converted;
} if (value.is_M) {
 converted.M = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_M(concrete.dtor_M);
 return converted;
} if (value.is_L) {
 converted.L = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_L(concrete.dtor_L);
 return converted;
} if (value.is_NULL) {
 converted.NULL = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_NULL(concrete.dtor_NULL);
 return converted;
} if (value.is_BOOL) {
 converted.BOOL = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_BOOL(concrete.dtor_BOOL);
 return converted;
}
throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.Model.AttributeValue state");
}
 internal static Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue (Amazon.DynamoDBv2.Model.AttributeValue value) {
 if (value.S != null) {
 return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_S(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_S(value.S));
} if (value.N != null) {
 return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_N(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_N(value.N));
} if (value.B != null) {
 return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_B(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_B(value.B));
} if (!value.SS.Any()) {
 return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_SS(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_SS(value.SS));
} if (!value.NS.Any()) {
 return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_NS(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_NS(value.NS));
} if (!value.BS.Any()) {
 return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_BS(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_BS(value.BS));
} if (value.IsMSet) {
 return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_M(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_M(value.M));
} if (value.IsLSet) {
 return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_L(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_L(value.L));
} if (value.NULL == true) {
 return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_NULL(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_NULL(value.NULL));
} if (value.IsBOOLSet) {
 return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_BOOL(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_BOOL(value.BOOL));
}
throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.Model.AttributeValue state");
}
 internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_S (Dafny.ISequence<char> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue(value);
}
 internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_S (string value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue(value);
}
 internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_N (Dafny.ISequence<char> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue(value);
}
 internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_N (string value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue(value);
}
 internal static System.IO.MemoryStream FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_B (Dafny.ISequence<byte> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue(value);
}
 internal static Dafny.ISequence<byte> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_B (System.IO.MemoryStream value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue(value);
}
 internal static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_SS (Dafny.ISequence<Dafny.ISequence<char>> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue(value);
}
 internal static Dafny.ISequence<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_SS (System.Collections.Generic.List<string> value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue(value);
}
 internal static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_NS (Dafny.ISequence<Dafny.ISequence<char>> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue(value);
}
 internal static Dafny.ISequence<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_NS (System.Collections.Generic.List<string> value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue(value);
}
 internal static System.Collections.Generic.List<System.IO.MemoryStream> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_BS (Dafny.ISequence<Dafny.ISequence<byte>> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue(value);
}
 internal static Dafny.ISequence<Dafny.ISequence<byte>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_BS (System.Collections.Generic.List<System.IO.MemoryStream> value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue(value);
}
 internal static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_M (Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue(value);
}
 internal static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_M (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue(value);
}
 internal static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_L (Dafny.ISequence<Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue(value);
}
 internal static Dafny.ISequence<Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_L (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue(value);
}
 internal static bool FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_NULL (bool value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_NullAttributeValue(value);
}
 internal static bool ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_NULL (bool value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_NullAttributeValue(value);
}
 internal static bool FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_BOOL (bool value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BooleanAttributeValue(value);
}
 internal static bool ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_BOOL (bool value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BooleanAttributeValue(value);
}
 internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue (Dafny.ISequence<char> value) {
 return new string(value.Elements);
}
 internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue (string value) {
 return Dafny.Sequence<char>.FromString(value);
}
 internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue (Dafny.ISequence<char> value) {
 return new string(value.Elements);
}
 internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue (string value) {
 return Dafny.Sequence<char>.FromString(value);
}
 internal static System.IO.MemoryStream FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue (Dafny.ISequence<byte> value) {
 return new System.IO.MemoryStream(value.Elements);
}
 internal static Dafny.ISequence<byte> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue (System.IO.MemoryStream value) {
 return Dafny.Sequence<byte>.FromArray(value.ToArray());
}
 internal static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue (Dafny.ISequence<Dafny.ISequence<char>> value) {
 return new System.Collections.Generic.List<string>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue__M6_member));
}
 internal static Dafny.ISequence<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue (System.Collections.Generic.List<string> value) {
 return Dafny.Sequence<Dafny.ISequence<char>>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue__M6_member).ToArray());
}
 internal static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue (Dafny.ISequence<Dafny.ISequence<char>> value) {
 return new System.Collections.Generic.List<string>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue__M6_member));
}
 internal static Dafny.ISequence<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue (System.Collections.Generic.List<string> value) {
 return Dafny.Sequence<Dafny.ISequence<char>>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue__M6_member).ToArray());
}
 internal static System.Collections.Generic.List<System.IO.MemoryStream> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue (Dafny.ISequence<Dafny.ISequence<byte>> value) {
 return new System.Collections.Generic.List<System.IO.MemoryStream>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue__M6_member));
}
 internal static Dafny.ISequence<Dafny.ISequence<byte>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue (System.Collections.Generic.List<System.IO.MemoryStream> value) {
 return Dafny.Sequence<Dafny.ISequence<byte>>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue__M6_member).ToArray());
}
 internal static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue (Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value) {
 return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M5_value(pair.Cdr));
}
 internal static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value) {
 return Dafny.Map<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue>.FromCollection(value.Select(pair =>
    new Dafny.Pair<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M5_value(pair.Value))
));
}
 internal static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue (Dafny.ISequence<Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value) {
 return new System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue__M6_member));
}
 internal static Dafny.ISequence<Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> value) {
 return Dafny.Sequence<Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue__M6_member).ToArray());
}
 internal static bool FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_NullAttributeValue (bool value) {
 return value;
}
 internal static bool ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_NullAttributeValue (bool value) {
 return value;
}
 internal static bool FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BooleanAttributeValue (bool value) {
 return value;
}
 internal static bool ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BooleanAttributeValue (bool value) {
 return value;
}
 internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue__M6_member (Dafny.ISequence<char> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue(value);
}
 internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue__M6_member (string value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue(value);
}
 internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue__M6_member (Dafny.ISequence<char> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue(value);
}
 internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue__M6_member (string value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue(value);
}
 internal static System.IO.MemoryStream FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue__M6_member (Dafny.ISequence<byte> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue(value);
}
 internal static Dafny.ISequence<byte> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue__M6_member (System.IO.MemoryStream value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue(value);
}
 internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M3_key (Dafny.ISequence<char> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
}
 internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M3_key (string value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
}
 internal static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M5_value (Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
}
 internal static Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M5_value (Amazon.DynamoDBv2.Model.AttributeValue value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
}
 internal static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue__M6_member (Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
}
 internal static Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue__M6_member (Amazon.DynamoDBv2.Model.AttributeValue value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
}
 public static System.Exception FromDafny_CommonError(Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IError value) {
 switch(value)
 {

 case Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.Error_DynamoDbEncryptionResourcesException dafnyVal:
return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S36_DynamoDbEncryptionResourcesException(dafnyVal);
 case Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.Error_CollectionOfErrors dafnyVal:
 return new CollectionOfErrors(new System.Collections.Generic.List<Exception>(dafnyVal._list.Elements.Select(x => TypeConversion.FromDafny_CommonError(x))));
 case Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.Error_Opaque dafnyVal:
 return new OpaqueError(dafnyVal._obj);
 default:
 // The switch MUST be complete for _IError, so `value` MUST NOT be an _IError. (How did you get here?)
 return new OpaqueError();
}
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IError ToDafny_CommonError(System.Exception value) {

 switch (value)
 {
 case AWS.Cryptography.DynamoDbEncryption.Resources.DynamoDbEncryptionResourcesException exception:
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S36_DynamoDbEncryptionResourcesException(exception);
 case CollectionOfErrors collectionOfErrors:
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.Error_CollectionOfErrors(
     Dafny.Sequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IError>
     .FromArray(
         collectionOfErrors.list.Select
             (x => TypeConversion.ToDafny_CommonError(x))
         .ToArray()
     )
 );

 // OpaqueError is redundant, but listed for completeness.
 case OpaqueError exception:
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.Error_Opaque(exception);
 case System.Exception exception:
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.Error_Opaque(exception);
 default:
 // The switch MUST be complete for System.Exception, so `value` MUST NOT be an System.Exception. (How did you get here?)
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.Error_Opaque(value);
}
}
}
}
