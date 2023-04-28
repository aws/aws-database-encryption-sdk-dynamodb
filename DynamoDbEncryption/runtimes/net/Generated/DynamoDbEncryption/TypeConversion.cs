// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System.Linq; using System; namespace AWS.Cryptography.DynamoDbEncryption {
 public static class TypeConversion {
 internal static AWS.Cryptography.DynamoDbEncryption.BeaconKeySource FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconKeySource (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBeaconKeySource value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BeaconKeySource concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BeaconKeySource)value;
 var converted = new AWS.Cryptography.DynamoDbEncryption.BeaconKeySource(); if (value.is_single) {
 converted.Single = FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconKeySource__M6_single(concrete.dtor_single);
 return converted;
} if (value.is_multi) {
 converted.Multi = FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconKeySource__M5_multi(concrete.dtor_multi);
 return converted;
}
throw new System.ArgumentException("Invalid AWS.Cryptography.DynamoDbEncryption.BeaconKeySource state");
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBeaconKeySource ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconKeySource (AWS.Cryptography.DynamoDbEncryption.BeaconKeySource value) {
 if (value.IsSetSingle()) {
 return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BeaconKeySource.create_single(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconKeySource__M6_single(value.Single));
} if (value.IsSetMulti()) {
 return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BeaconKeySource.create_multi(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconKeySource__M5_multi(value.Multi));
}
throw new System.ArgumentException("Invalid AWS.Cryptography.DynamoDbEncryption.BeaconKeySource state");
}
 internal static AWS.Cryptography.DynamoDbEncryption.CreateDynamoDbEncryptionBranchKeyIdSupplierInput FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ICreateDynamoDbEncryptionBranchKeyIdSupplierInput value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput)value; AWS.Cryptography.DynamoDbEncryption.CreateDynamoDbEncryptionBranchKeyIdSupplierInput converted = new AWS.Cryptography.DynamoDbEncryption.CreateDynamoDbEncryptionBranchKeyIdSupplierInput();  converted.DdbKeyBranchKeyIdSupplier = (AWS.Cryptography.DynamoDbEncryption.IDynamoDbKeyBranchKeyIdSupplier) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput__M25_ddbKeyBranchKeyIdSupplier(concrete._ddbKeyBranchKeyIdSupplier); return converted;
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ICreateDynamoDbEncryptionBranchKeyIdSupplierInput ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput (AWS.Cryptography.DynamoDbEncryption.CreateDynamoDbEncryptionBranchKeyIdSupplierInput value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput__M25_ddbKeyBranchKeyIdSupplier(value.DdbKeyBranchKeyIdSupplier) ) ;
}
 internal static AWS.Cryptography.DynamoDbEncryption.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ICreateDynamoDbEncryptionBranchKeyIdSupplierOutput value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput)value; AWS.Cryptography.DynamoDbEncryption.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput converted = new AWS.Cryptography.DynamoDbEncryption.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput();  converted.BranchKeyIdSupplier = (AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput__M19_branchKeyIdSupplier(concrete._branchKeyIdSupplier); return converted;
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ICreateDynamoDbEncryptionBranchKeyIdSupplierOutput ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput (AWS.Cryptography.DynamoDbEncryption.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput__M19_branchKeyIdSupplier(value.BranchKeyIdSupplier) ) ;
}
 internal static AWS.Cryptography.DynamoDbEncryption.DynamoDbEncryptionConfig FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S24_DynamoDbEncryptionConfig (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IDynamoDbEncryptionConfig value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbEncryptionConfig concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbEncryptionConfig)value; AWS.Cryptography.DynamoDbEncryption.DynamoDbEncryptionConfig converted = new AWS.Cryptography.DynamoDbEncryption.DynamoDbEncryptionConfig();  return converted;
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IDynamoDbEncryptionConfig ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S24_DynamoDbEncryptionConfig (AWS.Cryptography.DynamoDbEncryption.DynamoDbEncryptionConfig value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbEncryptionConfig (  ) ;
}
 internal static AWS.Cryptography.DynamoDbEncryption.DynamoDbEncryptionException FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S27_DynamoDbEncryptionException (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error_DynamoDbEncryptionException value) {
 return new AWS.Cryptography.DynamoDbEncryption.DynamoDbEncryptionException (
 FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S27_DynamoDbEncryptionException__M7_message(value._message)
 ) ;
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error_DynamoDbEncryptionException ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S27_DynamoDbEncryptionException (AWS.Cryptography.DynamoDbEncryption.DynamoDbEncryptionException value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error_DynamoDbEncryptionException (
 ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S27_DynamoDbEncryptionException__M7_message(value.Message)
 ) ;
}
 internal static AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyInput FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_GetBranchKeyIdFromDdbKeyInput (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetBranchKeyIdFromDdbKeyInput value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyInput concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyInput)value; AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyInput converted = new AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyInput();  converted.DdbKey = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_GetBranchKeyIdFromDdbKeyInput__M6_ddbKey(concrete._ddbKey); return converted;
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetBranchKeyIdFromDdbKeyInput ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_GetBranchKeyIdFromDdbKeyInput (AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyInput value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyInput ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_GetBranchKeyIdFromDdbKeyInput__M6_ddbKey(value.DdbKey) ) ;
}
 internal static AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyOutput FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S30_GetBranchKeyIdFromDdbKeyOutput (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetBranchKeyIdFromDdbKeyOutput value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyOutput concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyOutput)value; AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyOutput converted = new AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyOutput();  converted.BranchKeyId = (string) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S30_GetBranchKeyIdFromDdbKeyOutput__M11_branchKeyId(concrete._branchKeyId); return converted;
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetBranchKeyIdFromDdbKeyOutput ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S30_GetBranchKeyIdFromDdbKeyOutput (AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyOutput value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyOutput ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S30_GetBranchKeyIdFromDdbKeyOutput__M11_branchKeyId(value.BranchKeyId) ) ;
}
 internal static AWS.Cryptography.DynamoDbEncryption.LegacyPolicy FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyPolicy (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILegacyPolicy value) {
 if (value.is_REQUIRE__ENCRYPT__ALLOW__DECRYPT) return AWS.Cryptography.DynamoDbEncryption.LegacyPolicy.REQUIRE_ENCRYPT_ALLOW_DECRYPT;
 if (value.is_FORBID__ENCRYPT__ALLOW__DECRYPT) return AWS.Cryptography.DynamoDbEncryption.LegacyPolicy.FORBID_ENCRYPT_ALLOW_DECRYPT;
 if (value.is_FORBID__ENCRYPT__FORBID__DECRYPT) return AWS.Cryptography.DynamoDbEncryption.LegacyPolicy.FORBID_ENCRYPT_FORBID_DECRYPT;
throw new System.ArgumentException("Invalid AWS.Cryptography.DynamoDbEncryption.LegacyPolicy value");
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILegacyPolicy ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyPolicy (AWS.Cryptography.DynamoDbEncryption.LegacyPolicy value) {
 if (AWS.Cryptography.DynamoDbEncryption.LegacyPolicy.REQUIRE_ENCRYPT_ALLOW_DECRYPT.Equals(value)) return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.LegacyPolicy.create_REQUIRE__ENCRYPT__ALLOW__DECRYPT();
 if (AWS.Cryptography.DynamoDbEncryption.LegacyPolicy.FORBID_ENCRYPT_ALLOW_DECRYPT.Equals(value)) return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.LegacyPolicy.create_FORBID__ENCRYPT__ALLOW__DECRYPT();
 if (AWS.Cryptography.DynamoDbEncryption.LegacyPolicy.FORBID_ENCRYPT_FORBID_DECRYPT.Equals(value)) return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.LegacyPolicy.create_FORBID__ENCRYPT__FORBID__DECRYPT();
throw new System.ArgumentException("Invalid AWS.Cryptography.DynamoDbEncryption.LegacyPolicy value");
}
 internal static AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_PlaintextPolicy (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IPlaintextPolicy value) {
 if (value.is_REQUIRE__WRITE__ALLOW__READ) return AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy.REQUIRE_WRITE_ALLOW_READ;
 if (value.is_FORBID__WRITE__ALLOW__READ) return AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy.FORBID_WRITE_ALLOW_READ;
 if (value.is_FORBID__WRITE__FORBID__READ) return AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy.FORBID_WRITE_FORBID_READ;
throw new System.ArgumentException("Invalid AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy value");
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IPlaintextPolicy ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_PlaintextPolicy (AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy value) {
 if (AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy.REQUIRE_WRITE_ALLOW_READ.Equals(value)) return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PlaintextPolicy.create_REQUIRE__WRITE__ALLOW__READ();
 if (AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy.FORBID_WRITE_ALLOW_READ.Equals(value)) return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PlaintextPolicy.create_FORBID__WRITE__ALLOW__READ();
 if (AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy.FORBID_WRITE_FORBID_READ.Equals(value)) return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PlaintextPolicy.create_FORBID__WRITE__FORBID__READ();
throw new System.ArgumentException("Invalid AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy value");
}
 internal static AWS.Cryptography.DynamoDbEncryption.VirtualTransform FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualTransform value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform)value;
 var converted = new AWS.Cryptography.DynamoDbEncryption.VirtualTransform(); if (value.is_upper) {
 converted.Upper = FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M5_upper(concrete.dtor_upper);
 return converted;
} if (value.is_lower) {
 converted.Lower = FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M5_lower(concrete.dtor_lower);
 return converted;
} if (value.is_insert) {
 converted.Insert = FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M6_insert(concrete.dtor_insert);
 return converted;
} if (value.is_prefix) {
 converted.Prefix = FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M6_prefix(concrete.dtor_prefix);
 return converted;
} if (value.is_suffix) {
 converted.Suffix = FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M6_suffix(concrete.dtor_suffix);
 return converted;
} if (value.is_substring) {
 converted.Substring = FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M9_substring(concrete.dtor_substring);
 return converted;
} if (value.is_segment) {
 converted.Segment = FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M7_segment(concrete.dtor_segment);
 return converted;
} if (value.is_segments) {
 converted.Segments = FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M8_segments(concrete.dtor_segments);
 return converted;
}
throw new System.ArgumentException("Invalid AWS.Cryptography.DynamoDbEncryption.VirtualTransform state");
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualTransform ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform (AWS.Cryptography.DynamoDbEncryption.VirtualTransform value) {
 if (value.IsSetUpper()) {
 return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform.create_upper(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M5_upper(value.Upper));
} if (value.IsSetLower()) {
 return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform.create_lower(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M5_lower(value.Lower));
} if (value.IsSetInsert()) {
 return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform.create_insert(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M6_insert(value.Insert));
} if (value.IsSetPrefix()) {
 return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform.create_prefix(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M6_prefix(value.Prefix));
} if (value.IsSetSuffix()) {
 return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform.create_suffix(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M6_suffix(value.Suffix));
} if (value.IsSetSubstring()) {
 return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform.create_substring(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M9_substring(value.Substring));
} if (value.IsSetSegment()) {
 return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform.create_segment(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M7_segment(value.Segment));
} if (value.IsSetSegments()) {
 return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform.create_segments(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M8_segments(value.Segments));
}
throw new System.ArgumentException("Invalid AWS.Cryptography.DynamoDbEncryption.VirtualTransform state");
}
 internal static AWS.Cryptography.DynamoDbEncryption.SingleKeyStore FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconKeySource__M6_single (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISingleKeyStore value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_SingleKeyStore(value);
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISingleKeyStore ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconKeySource__M6_single (AWS.Cryptography.DynamoDbEncryption.SingleKeyStore value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_SingleKeyStore(value);
}
 internal static AWS.Cryptography.DynamoDbEncryption.MultiKeyStore FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconKeySource__M5_multi (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IMultiKeyStore value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore(value);
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IMultiKeyStore ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconKeySource__M5_multi (AWS.Cryptography.DynamoDbEncryption.MultiKeyStore value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore(value);
}
 internal static AWS.Cryptography.DynamoDbEncryption.IDynamoDbKeyBranchKeyIdSupplier FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput__M25_ddbKeyBranchKeyIdSupplier (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbKeyBranchKeyIdSupplier value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S39_DynamoDbKeyBranchKeyIdSupplierReference(value);
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbKeyBranchKeyIdSupplier ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput__M25_ddbKeyBranchKeyIdSupplier (AWS.Cryptography.DynamoDbEncryption.IDynamoDbKeyBranchKeyIdSupplier value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S39_DynamoDbKeyBranchKeyIdSupplierReference(value);
}
 internal static AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput__M19_branchKeyIdSupplier (Dafny.Aws.Cryptography.MaterialProviders.Types.IBranchKeyIdSupplier value) {
 return FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference(value);
}
 internal static Dafny.Aws.Cryptography.MaterialProviders.Types.IBranchKeyIdSupplier ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput__M19_branchKeyIdSupplier (AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier value) {
 return ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference(value);
}
 internal static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S27_DynamoDbEncryptionException__M7_message (Dafny.ISequence<char> value) {
 return FromDafny_N6_smithy__N3_api__S6_String(value);
}
 internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S27_DynamoDbEncryptionException__M7_message (string value) {
 return ToDafny_N6_smithy__N3_api__S6_String(value);
}
 internal static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_GetBranchKeyIdFromDdbKeyInput__M6_ddbKey (Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
}
 internal static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_GetBranchKeyIdFromDdbKeyInput__M6_ddbKey (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
}
 internal static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S30_GetBranchKeyIdFromDdbKeyOutput__M11_branchKeyId (Dafny.ISequence<char> value) {
 return FromDafny_N6_smithy__N3_api__S6_String(value);
}
 internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S30_GetBranchKeyIdFromDdbKeyOutput__M11_branchKeyId (string value) {
 return ToDafny_N6_smithy__N3_api__S6_String(value);
}
 internal static AWS.Cryptography.DynamoDbEncryption.Upper FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M5_upper (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IUpper value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S5_Upper(value);
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IUpper ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M5_upper (AWS.Cryptography.DynamoDbEncryption.Upper value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S5_Upper(value);
}
 internal static AWS.Cryptography.DynamoDbEncryption.Lower FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M5_lower (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILower value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S5_Lower(value);
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILower ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M5_lower (AWS.Cryptography.DynamoDbEncryption.Lower value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S5_Lower(value);
}
 internal static AWS.Cryptography.DynamoDbEncryption.Insert FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M6_insert (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IInsert value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Insert(value);
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IInsert ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M6_insert (AWS.Cryptography.DynamoDbEncryption.Insert value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Insert(value);
}
 internal static AWS.Cryptography.DynamoDbEncryption.GetPrefix FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M6_prefix (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetPrefix value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetPrefix(value);
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetPrefix ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M6_prefix (AWS.Cryptography.DynamoDbEncryption.GetPrefix value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetPrefix(value);
}
 internal static AWS.Cryptography.DynamoDbEncryption.GetSuffix FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M6_suffix (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSuffix value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetSuffix(value);
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSuffix ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M6_suffix (AWS.Cryptography.DynamoDbEncryption.GetSuffix value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetSuffix(value);
}
 internal static AWS.Cryptography.DynamoDbEncryption.GetSubstring FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M9_substring (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSubstring value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_GetSubstring(value);
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSubstring ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M9_substring (AWS.Cryptography.DynamoDbEncryption.GetSubstring value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_GetSubstring(value);
}
 internal static AWS.Cryptography.DynamoDbEncryption.GetSegment FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M7_segment (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSegment value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S10_GetSegment(value);
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSegment ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M7_segment (AWS.Cryptography.DynamoDbEncryption.GetSegment value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S10_GetSegment(value);
}
 internal static AWS.Cryptography.DynamoDbEncryption.GetSegments FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M8_segments (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSegments value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments(value);
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSegments ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M8_segments (AWS.Cryptography.DynamoDbEncryption.GetSegments value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments(value);
}
 internal static AWS.Cryptography.DynamoDbEncryption.SingleKeyStore FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_SingleKeyStore (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISingleKeyStore value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SingleKeyStore concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SingleKeyStore)value; AWS.Cryptography.DynamoDbEncryption.SingleKeyStore converted = new AWS.Cryptography.DynamoDbEncryption.SingleKeyStore();  converted.KeyId = (string) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_SingleKeyStore__M5_keyId(concrete._keyId);
  converted.CacheTTL = (int) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_SingleKeyStore__M8_cacheTTL(concrete._cacheTTL); return converted;
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISingleKeyStore ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_SingleKeyStore (AWS.Cryptography.DynamoDbEncryption.SingleKeyStore value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SingleKeyStore ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_SingleKeyStore__M5_keyId(value.KeyId) , ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_SingleKeyStore__M8_cacheTTL(value.CacheTTL) ) ;
}
 internal static AWS.Cryptography.DynamoDbEncryption.MultiKeyStore FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IMultiKeyStore value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.MultiKeyStore concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.MultiKeyStore)value; AWS.Cryptography.DynamoDbEncryption.MultiKeyStore converted = new AWS.Cryptography.DynamoDbEncryption.MultiKeyStore();  converted.KeyFieldName = (string) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore__M12_keyFieldName(concrete._keyFieldName);
  converted.CacheTTL = (int) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore__M8_cacheTTL(concrete._cacheTTL);
  converted.MaxCacheSize = (int) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore__M12_maxCacheSize(concrete._maxCacheSize); return converted;
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IMultiKeyStore ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore (AWS.Cryptography.DynamoDbEncryption.MultiKeyStore value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.MultiKeyStore ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore__M12_keyFieldName(value.KeyFieldName) , ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore__M8_cacheTTL(value.CacheTTL) , ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore__M12_maxCacheSize(value.MaxCacheSize) ) ;
}
 public static AWS.Cryptography.DynamoDbEncryption.IDynamoDbKeyBranchKeyIdSupplier FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S39_DynamoDbKeyBranchKeyIdSupplierReference (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbKeyBranchKeyIdSupplier value) {
 if (value is NativeWrapper_DynamoDbKeyBranchKeyIdSupplier nativeWrapper) return nativeWrapper._impl;
return new DynamoDbKeyBranchKeyIdSupplier(value);

}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbKeyBranchKeyIdSupplier ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S39_DynamoDbKeyBranchKeyIdSupplierReference (AWS.Cryptography.DynamoDbEncryption.IDynamoDbKeyBranchKeyIdSupplier value) {
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
 internal static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key (Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value) {
 return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M5_value(pair.Cdr));
}
 internal static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value) {
 return Dafny.Map<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue>.FromCollection(value.Select(pair =>
    new Dafny.Pair<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M5_value(pair.Value))
));
}
 internal static AWS.Cryptography.DynamoDbEncryption.Upper FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S5_Upper (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IUpper value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Upper concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Upper)value; AWS.Cryptography.DynamoDbEncryption.Upper converted = new AWS.Cryptography.DynamoDbEncryption.Upper();  return converted;
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IUpper ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S5_Upper (AWS.Cryptography.DynamoDbEncryption.Upper value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Upper (  ) ;
}
 internal static AWS.Cryptography.DynamoDbEncryption.Lower FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S5_Lower (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILower value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Lower concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Lower)value; AWS.Cryptography.DynamoDbEncryption.Lower converted = new AWS.Cryptography.DynamoDbEncryption.Lower();  return converted;
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILower ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S5_Lower (AWS.Cryptography.DynamoDbEncryption.Lower value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Lower (  ) ;
}
 internal static AWS.Cryptography.DynamoDbEncryption.Insert FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Insert (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IInsert value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Insert concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Insert)value; AWS.Cryptography.DynamoDbEncryption.Insert converted = new AWS.Cryptography.DynamoDbEncryption.Insert();  converted.Literal = (string) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Insert__M7_literal(concrete._literal); return converted;
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IInsert ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Insert (AWS.Cryptography.DynamoDbEncryption.Insert value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Insert ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Insert__M7_literal(value.Literal) ) ;
}
 internal static AWS.Cryptography.DynamoDbEncryption.GetPrefix FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetPrefix (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetPrefix value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetPrefix concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetPrefix)value; AWS.Cryptography.DynamoDbEncryption.GetPrefix converted = new AWS.Cryptography.DynamoDbEncryption.GetPrefix();  converted.Length = (int) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetPrefix__M6_length(concrete._length); return converted;
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetPrefix ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetPrefix (AWS.Cryptography.DynamoDbEncryption.GetPrefix value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetPrefix ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetPrefix__M6_length(value.Length) ) ;
}
 internal static AWS.Cryptography.DynamoDbEncryption.GetSuffix FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetSuffix (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSuffix value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSuffix concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSuffix)value; AWS.Cryptography.DynamoDbEncryption.GetSuffix converted = new AWS.Cryptography.DynamoDbEncryption.GetSuffix();  converted.Length = (int) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetSuffix__M6_length(concrete._length); return converted;
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSuffix ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetSuffix (AWS.Cryptography.DynamoDbEncryption.GetSuffix value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSuffix ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetSuffix__M6_length(value.Length) ) ;
}
 internal static AWS.Cryptography.DynamoDbEncryption.GetSubstring FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_GetSubstring (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSubstring value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSubstring concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSubstring)value; AWS.Cryptography.DynamoDbEncryption.GetSubstring converted = new AWS.Cryptography.DynamoDbEncryption.GetSubstring();  converted.Low = (int) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_GetSubstring__M3_low(concrete._low);
  converted.High = (int) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_GetSubstring__M4_high(concrete._high); return converted;
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSubstring ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_GetSubstring (AWS.Cryptography.DynamoDbEncryption.GetSubstring value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSubstring ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_GetSubstring__M3_low(value.Low) , ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_GetSubstring__M4_high(value.High) ) ;
}
 internal static AWS.Cryptography.DynamoDbEncryption.GetSegment FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S10_GetSegment (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSegment value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSegment concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSegment)value; AWS.Cryptography.DynamoDbEncryption.GetSegment converted = new AWS.Cryptography.DynamoDbEncryption.GetSegment();  converted.Split = (string) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S10_GetSegment__M5_split(concrete._split);
  converted.Index = (int) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S10_GetSegment__M5_index(concrete._index); return converted;
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSegment ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S10_GetSegment (AWS.Cryptography.DynamoDbEncryption.GetSegment value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSegment ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S10_GetSegment__M5_split(value.Split) , ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S10_GetSegment__M5_index(value.Index) ) ;
}
 internal static AWS.Cryptography.DynamoDbEncryption.GetSegments FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSegments value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSegments concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSegments)value; AWS.Cryptography.DynamoDbEncryption.GetSegments converted = new AWS.Cryptography.DynamoDbEncryption.GetSegments();  converted.Split = (string) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments__M5_split(concrete._split);
  converted.Low = (int) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments__M3_low(concrete._low);
  converted.High = (int) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments__M4_high(concrete._high); return converted;
}
 internal static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSegments ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments (AWS.Cryptography.DynamoDbEncryption.GetSegments value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSegments ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments__M5_split(value.Split) , ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments__M3_low(value.Low) , ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments__M4_high(value.High) ) ;
}
 internal static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_SingleKeyStore__M5_keyId (Dafny.ISequence<char> value) {
 return FromDafny_N6_smithy__N3_api__S6_String(value);
}
 internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_SingleKeyStore__M5_keyId (string value) {
 return ToDafny_N6_smithy__N3_api__S6_String(value);
}
 internal static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_SingleKeyStore__M8_cacheTTL (int value) {
 return FromDafny_N6_smithy__N3_api__S7_Integer(value);
}
 internal static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_SingleKeyStore__M8_cacheTTL (int value) {
 return ToDafny_N6_smithy__N3_api__S7_Integer(value);
}
 internal static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore__M12_keyFieldName (Dafny.ISequence<char> value) {
 return FromDafny_N6_smithy__N3_api__S6_String(value);
}
 internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore__M12_keyFieldName (string value) {
 return ToDafny_N6_smithy__N3_api__S6_String(value);
}
 internal static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore__M8_cacheTTL (int value) {
 return FromDafny_N6_smithy__N3_api__S7_Integer(value);
}
 internal static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore__M8_cacheTTL (int value) {
 return ToDafny_N6_smithy__N3_api__S7_Integer(value);
}
 internal static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore__M12_maxCacheSize (int value) {
 return FromDafny_N6_smithy__N3_api__S7_Integer(value);
}
 internal static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore__M12_maxCacheSize (int value) {
 return ToDafny_N6_smithy__N3_api__S7_Integer(value);
}
 internal static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M3_key (Dafny.ISequence<char> value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
}
 internal static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M3_key (string value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
}
 internal static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M5_value (Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue value) {
 return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
}
 internal static Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M5_value (Amazon.DynamoDBv2.Model.AttributeValue value) {
 return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
}
 internal static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Insert__M7_literal (Dafny.ISequence<char> value) {
 return FromDafny_N6_smithy__N3_api__S6_String(value);
}
 internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Insert__M7_literal (string value) {
 return ToDafny_N6_smithy__N3_api__S6_String(value);
}
 internal static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetPrefix__M6_length (int value) {
 return FromDafny_N6_smithy__N3_api__S7_Integer(value);
}
 internal static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetPrefix__M6_length (int value) {
 return ToDafny_N6_smithy__N3_api__S7_Integer(value);
}
 internal static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetSuffix__M6_length (int value) {
 return FromDafny_N6_smithy__N3_api__S7_Integer(value);
}
 internal static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetSuffix__M6_length (int value) {
 return ToDafny_N6_smithy__N3_api__S7_Integer(value);
}
 internal static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_GetSubstring__M3_low (int value) {
 return FromDafny_N6_smithy__N3_api__S7_Integer(value);
}
 internal static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_GetSubstring__M3_low (int value) {
 return ToDafny_N6_smithy__N3_api__S7_Integer(value);
}
 internal static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_GetSubstring__M4_high (int value) {
 return FromDafny_N6_smithy__N3_api__S7_Integer(value);
}
 internal static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_GetSubstring__M4_high (int value) {
 return ToDafny_N6_smithy__N3_api__S7_Integer(value);
}
 internal static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S10_GetSegment__M5_split (Dafny.ISequence<char> value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S4_Char(value);
}
 internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S10_GetSegment__M5_split (string value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S4_Char(value);
}
 internal static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S10_GetSegment__M5_index (int value) {
 return FromDafny_N6_smithy__N3_api__S7_Integer(value);
}
 internal static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S10_GetSegment__M5_index (int value) {
 return ToDafny_N6_smithy__N3_api__S7_Integer(value);
}
 internal static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments__M5_split (Dafny.ISequence<char> value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S4_Char(value);
}
 internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments__M5_split (string value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S4_Char(value);
}
 internal static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments__M3_low (int value) {
 return FromDafny_N6_smithy__N3_api__S7_Integer(value);
}
 internal static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments__M3_low (int value) {
 return ToDafny_N6_smithy__N3_api__S7_Integer(value);
}
 internal static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments__M4_high (int value) {
 return FromDafny_N6_smithy__N3_api__S7_Integer(value);
}
 internal static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments__M4_high (int value) {
 return ToDafny_N6_smithy__N3_api__S7_Integer(value);
}
 internal static int FromDafny_N6_smithy__N3_api__S7_Integer (int value) {
 return value;
}
 internal static int ToDafny_N6_smithy__N3_api__S7_Integer (int value) {
 return value;
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
 internal static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S4_Char (Dafny.ISequence<char> value) {
 return new string(value.Elements);
}
 internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S4_Char (string value) {
 return Dafny.Sequence<char>.FromString(value);
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
 public static System.Exception FromDafny_CommonError(Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError value) {
 switch(value)
 {

 case Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error_DynamoDbEncryptionException dafnyVal:
return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S27_DynamoDbEncryptionException(dafnyVal);
 case Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error_CollectionOfErrors dafnyVal:
 return new CollectionOfErrors(new System.Collections.Generic.List<Exception>(dafnyVal._list.Elements.Select(x => TypeConversion.FromDafny_CommonError(x))));
 case Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error_Opaque dafnyVal:
 return new OpaqueError(dafnyVal._obj);
 default:
 // The switch MUST be complete for _IError, so `value` MUST NOT be an _IError. (How did you get here?)
 return new OpaqueError();
}
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError ToDafny_CommonError(System.Exception value) {

 switch (value)
 {
 case AWS.Cryptography.DynamoDbEncryption.DynamoDbEncryptionException exception:
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S27_DynamoDbEncryptionException(exception);
 case CollectionOfErrors collectionOfErrors:
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error_CollectionOfErrors(
     Dafny.Sequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError>
     .FromArray(
         collectionOfErrors.list.Select
             (x => TypeConversion.ToDafny_CommonError(x))
         .ToArray()
     )
 );

 // OpaqueError is redundant, but listed for completeness.
 case OpaqueError exception:
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error_Opaque(exception);
 case System.Exception exception:
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error_Opaque(exception);
 default:
 // The switch MUST be complete for System.Exception, so `value` MUST NOT be an System.Exception. (How did you get here?)
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error_Opaque(value);
}
}

 public static ILegacyDynamoDbEncryptor FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S32_LegacyDynamoDbEncryptorReference(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ILegacyDynamoDbEncryptor value)
 {
   if (value is NativeWrapper_LegacyDynamoDbEncryptor nativeWrapper) return nativeWrapper._impl;
   return new LegacyDynamoDbEncryptor(value);
 }

 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ILegacyDynamoDbEncryptor ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S32_LegacyDynamoDbEncryptorReference(ILegacyDynamoDbEncryptor value)
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
 }
}
