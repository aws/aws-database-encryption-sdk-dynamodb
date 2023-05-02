// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System.Linq; using System; namespace AWS.Cryptography.DynamoDbEncryption {
 public static class TypeConversion {
 public static AWS.Cryptography.Primitives.AtomicPrimitives FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S25_AtomicPrimitivesReference (Dafny.Aws.Cryptography.Primitives.Types.IAwsCryptographicPrimitivesClient value) {
 if (value is Dafny.Aws.Cryptography.Primitives.Types.IAwsCryptographicPrimitivesClient dafnyValue) {
    return new AWS.Cryptography.Primitives.AtomicPrimitives(dafnyValue);
}
 throw new System.ArgumentException("Custom implementations of AWS.Cryptography.Primitives.AtomicPrimitives are not supported yet");
}
 public static Dafny.Aws.Cryptography.Primitives.Types.IAwsCryptographicPrimitivesClient ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S25_AtomicPrimitivesReference (AWS.Cryptography.Primitives.AtomicPrimitives value) {
 if (value is AWS.Cryptography.Primitives.AtomicPrimitives nativeValue) {
    return nativeValue.impl();
}
 throw new System.ArgumentException("Custom implementations of AWS.Cryptography.Primitives.AtomicPrimitives are not supported yet");
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_AttributeActions (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> value) {
 return value.ItemEnumerable.ToDictionary(pair => Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(pair.Car), pair => AWS.Cryptography.StructuredEncryption.TypeConversion.FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction(pair.Cdr));
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_AttributeActions (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> value) {
 return Dafny.Map<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction>.FromCollection(value.Select(pair =>
    new Dafny.Pair<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction>(Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(pair.Key), AWS.Cryptography.StructuredEncryption.TypeConversion.ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction(pair.Value))
));
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_AttributeActions__M3_key (Dafny.ISequence<char> value) {
 return Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_AttributeActions__M3_key (string value) {
 return Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
}
 public static AWS.Cryptography.StructuredEncryption.CryptoAction FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_AttributeActions__M5_value (Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction value) {
 return AWS.Cryptography.StructuredEncryption.TypeConversion.FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_AttributeActions__M5_value (AWS.Cryptography.StructuredEncryption.CryptoAction value) {
 return AWS.Cryptography.StructuredEncryption.TypeConversion.ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction(value);
}
 public static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconBitLength (int value) {
 return value;
}
 public static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconBitLength (int value) {
 return value;
}
 public static AWS.Cryptography.DynamoDbEncryption.BeaconKeySource FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconKeySource (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBeaconKeySource value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BeaconKeySource concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BeaconKeySource)value;
 var converted = new AWS.Cryptography.DynamoDbEncryption.BeaconKeySource(); if (value.is_single) {
 converted.Single = FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_SingleKeyStore(concrete.dtor_single);
 return converted;
} if (value.is_multi) {
 converted.Multi = FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore(concrete.dtor_multi);
 return converted;
}
throw new System.ArgumentException("Invalid AWS.Cryptography.DynamoDbEncryption.BeaconKeySource state");
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBeaconKeySource ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconKeySource (AWS.Cryptography.DynamoDbEncryption.BeaconKeySource value) {
 if (value.IsSetSingle()) {
 return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BeaconKeySource.create_single(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_SingleKeyStore(value.Single));
} if (value.IsSetMulti()) {
 return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BeaconKeySource.create_multi(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore(value.Multi));
}
throw new System.ArgumentException("Invalid AWS.Cryptography.DynamoDbEncryption.BeaconKeySource state");
}
 public static AWS.Cryptography.DynamoDbEncryption.MultiKeyStore FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconKeySource__M5_multi (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IMultiKeyStore value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IMultiKeyStore ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconKeySource__M5_multi (AWS.Cryptography.DynamoDbEncryption.MultiKeyStore value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.SingleKeyStore FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconKeySource__M6_single (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISingleKeyStore value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_SingleKeyStore(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISingleKeyStore ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconKeySource__M6_single (AWS.Cryptography.DynamoDbEncryption.SingleKeyStore value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_SingleKeyStore(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.BeaconVersion FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_BeaconVersion (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBeaconVersion value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BeaconVersion concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BeaconVersion)value;
 AWS.Cryptography.DynamoDbEncryption.BeaconVersion converted = new AWS.Cryptography.DynamoDbEncryption.BeaconVersion();
  converted.Version = (int) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_VersionNumber(concrete._version);
  converted.KeyStore = (AWS.Cryptography.KeyStore.KeyStore) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S17_KeyStoreReference(concrete._keyStore);
  converted.KeySource = (AWS.Cryptography.DynamoDbEncryption.BeaconKeySource) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconKeySource(concrete._keySource);
  converted.StandardBeacons = (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.StandardBeacon>) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_StandardBeaconList(concrete._standardBeacons);
 if (concrete._compoundBeacons.is_Some) converted.CompoundBeacons = (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.CompoundBeacon>) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_CompoundBeaconList(concrete._compoundBeacons.dtor_value);
 if (concrete._virtualFields.is_Some) converted.VirtualFields = (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualField>) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualFieldList(concrete._virtualFields.dtor_value);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBeaconVersion ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_BeaconVersion (AWS.Cryptography.DynamoDbEncryption.BeaconVersion value) {
 Wrappers_Compile._IOption<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ICompoundBeacon>> var_compoundBeacons =
	value.IsSetCompoundBeacons() ?
 	new Wrappers_Compile.Option_Some<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ICompoundBeacon>>(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_CompoundBeaconList(value.CompoundBeacons))
 	: new Wrappers_Compile.Option_None<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ICompoundBeacon>>();
 Wrappers_Compile._IOption<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualField>> var_virtualFields =
	value.IsSetVirtualFields() ?
 	new Wrappers_Compile.Option_Some<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualField>>(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualFieldList(value.VirtualFields))
 	: new Wrappers_Compile.Option_None<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualField>>();
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BeaconVersion ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_VersionNumber(value.Version) ,
 ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S17_KeyStoreReference(value.KeyStore) ,
 ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconKeySource(value.KeySource) ,
 ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_StandardBeaconList(value.StandardBeacons) ,
 var_compoundBeacons ,
 var_virtualFields ) ;
}
 public static System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.CompoundBeacon> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_BeaconVersion__M15_compoundBeacons (Wrappers_Compile._IOption<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ICompoundBeacon>> value) {
 return value.is_None ? (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.CompoundBeacon>) null : FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_CompoundBeaconList(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ICompoundBeacon>> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_BeaconVersion__M15_compoundBeacons (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.CompoundBeacon> value) {
 return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ICompoundBeacon>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ICompoundBeacon>>.create_Some(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_CompoundBeaconList((System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.CompoundBeacon>) value));
}
 public static AWS.Cryptography.DynamoDbEncryption.BeaconKeySource FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_BeaconVersion__M9_keySource (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBeaconKeySource value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconKeySource(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBeaconKeySource ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_BeaconVersion__M9_keySource (AWS.Cryptography.DynamoDbEncryption.BeaconKeySource value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconKeySource(value);
}
 public static AWS.Cryptography.KeyStore.KeyStore FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_BeaconVersion__M8_keyStore (Dafny.Aws.Cryptography.KeyStore.Types.IKeyStoreClient value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S17_KeyStoreReference(value);
}
 public static Dafny.Aws.Cryptography.KeyStore.Types.IKeyStoreClient ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_BeaconVersion__M8_keyStore (AWS.Cryptography.KeyStore.KeyStore value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S17_KeyStoreReference(value);
}
 public static System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.StandardBeacon> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_BeaconVersion__M15_standardBeacons (Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IStandardBeacon> value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_StandardBeaconList(value);
}
 public static Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IStandardBeacon> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_BeaconVersion__M15_standardBeacons (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.StandardBeacon> value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_StandardBeaconList(value);
}
 public static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_BeaconVersion__M7_version (int value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_VersionNumber(value);
}
 public static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_BeaconVersion__M7_version (int value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_VersionNumber(value);
}
 public static System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualField> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_BeaconVersion__M13_virtualFields (Wrappers_Compile._IOption<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualField>> value) {
 return value.is_None ? (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualField>) null : FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualFieldList(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualField>> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_BeaconVersion__M13_virtualFields (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualField> value) {
 return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualField>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualField>>.create_Some(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualFieldList((System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualField>) value));
}
 public static System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.BeaconVersion> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S17_BeaconVersionList (Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBeaconVersion> value) {
 return new System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.BeaconVersion>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_BeaconVersion));
}
 public static Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBeaconVersion> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S17_BeaconVersionList (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.BeaconVersion> value) {
 return Dafny.Sequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBeaconVersion>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_BeaconVersion).ToArray());
}
 public static AWS.Cryptography.DynamoDbEncryption.BeaconVersion FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S17_BeaconVersionList__M6_member (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBeaconVersion value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_BeaconVersion(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBeaconVersion ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S17_BeaconVersionList__M6_member (AWS.Cryptography.DynamoDbEncryption.BeaconVersion value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_BeaconVersion(value);
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S4_Char (Dafny.ISequence<char> value) {
 return new string(value.Elements);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S4_Char (string value) {
 return Dafny.Sequence<char>.FromString(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.CompoundBeacon FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_CompoundBeacon (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ICompoundBeacon value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CompoundBeacon concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CompoundBeacon)value;
 AWS.Cryptography.DynamoDbEncryption.CompoundBeacon converted = new AWS.Cryptography.DynamoDbEncryption.CompoundBeacon();
  converted.Name = (string) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(concrete._name);
  converted.Split = (string) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S4_Char(concrete._split);
 if (concrete._sensitive.is_Some) converted.Sensitive = (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.SensitivePart>) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_SensitivePartsList(concrete._sensitive.dtor_value);
 if (concrete._nonSensitive.is_Some) converted.NonSensitive = (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.NonSensitivePart>) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S21_NonSensitivePartsList(concrete._nonSensitive.dtor_value);
 if (concrete._constructors.is_Some) converted.Constructors = (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.Constructor>) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_ConstructorList(concrete._constructors.dtor_value);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ICompoundBeacon ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_CompoundBeacon (AWS.Cryptography.DynamoDbEncryption.CompoundBeacon value) {
 Wrappers_Compile._IOption<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISensitivePart>> var_sensitive =
	value.IsSetSensitive() ?
 	new Wrappers_Compile.Option_Some<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISensitivePart>>(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_SensitivePartsList(value.Sensitive))
 	: new Wrappers_Compile.Option_None<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISensitivePart>>();
 Wrappers_Compile._IOption<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._INonSensitivePart>> var_nonSensitive =
	value.IsSetNonSensitive() ?
 	new Wrappers_Compile.Option_Some<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._INonSensitivePart>>(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S21_NonSensitivePartsList(value.NonSensitive))
 	: new Wrappers_Compile.Option_None<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._INonSensitivePart>>();
 Wrappers_Compile._IOption<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructor>> var_constructors =
	value.IsSetConstructors() ?
 	new Wrappers_Compile.Option_Some<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructor>>(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_ConstructorList(value.Constructors))
 	: new Wrappers_Compile.Option_None<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructor>>();
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CompoundBeacon ( Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value.Name) ,
 ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S4_Char(value.Split) ,
 var_sensitive ,
 var_nonSensitive ,
 var_constructors ) ;
}
 public static System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.Constructor> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_CompoundBeacon__M12_constructors (Wrappers_Compile._IOption<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructor>> value) {
 return value.is_None ? (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.Constructor>) null : FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_ConstructorList(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructor>> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_CompoundBeacon__M12_constructors (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.Constructor> value) {
 return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructor>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructor>>.create_Some(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_ConstructorList((System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.Constructor>) value));
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_CompoundBeacon__M4_name (Dafny.ISequence<char> value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_CompoundBeacon__M4_name (string value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.NonSensitivePart> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_CompoundBeacon__M12_nonSensitive (Wrappers_Compile._IOption<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._INonSensitivePart>> value) {
 return value.is_None ? (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.NonSensitivePart>) null : FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S21_NonSensitivePartsList(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._INonSensitivePart>> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_CompoundBeacon__M12_nonSensitive (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.NonSensitivePart> value) {
 return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._INonSensitivePart>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._INonSensitivePart>>.create_Some(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S21_NonSensitivePartsList((System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.NonSensitivePart>) value));
}
 public static System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.SensitivePart> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_CompoundBeacon__M9_sensitive (Wrappers_Compile._IOption<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISensitivePart>> value) {
 return value.is_None ? (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.SensitivePart>) null : FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_SensitivePartsList(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISensitivePart>> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_CompoundBeacon__M9_sensitive (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.SensitivePart> value) {
 return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISensitivePart>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISensitivePart>>.create_Some(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_SensitivePartsList((System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.SensitivePart>) value));
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_CompoundBeacon__M5_split (Dafny.ISequence<char> value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S4_Char(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_CompoundBeacon__M5_split (string value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S4_Char(value);
}
 public static System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.CompoundBeacon> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_CompoundBeaconList (Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ICompoundBeacon> value) {
 return new System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.CompoundBeacon>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_CompoundBeacon));
}
 public static Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ICompoundBeacon> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_CompoundBeaconList (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.CompoundBeacon> value) {
 return Dafny.Sequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ICompoundBeacon>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_CompoundBeacon).ToArray());
}
 public static AWS.Cryptography.DynamoDbEncryption.CompoundBeacon FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_CompoundBeaconList__M6_member (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ICompoundBeacon value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_CompoundBeacon(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ICompoundBeacon ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_CompoundBeaconList__M6_member (AWS.Cryptography.DynamoDbEncryption.CompoundBeacon value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_CompoundBeacon(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.Constructor FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_Constructor (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructor value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Constructor concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Constructor)value;
 AWS.Cryptography.DynamoDbEncryption.Constructor converted = new AWS.Cryptography.DynamoDbEncryption.Constructor();
  converted.Parts = (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.ConstructorPart>) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S19_ConstructorPartList(concrete._parts);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructor ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_Constructor (AWS.Cryptography.DynamoDbEncryption.Constructor value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Constructor ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S19_ConstructorPartList(value.Parts) ) ;
}
 public static System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.ConstructorPart> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_Constructor__M5_parts (Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructorPart> value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S19_ConstructorPartList(value);
}
 public static Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructorPart> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_Constructor__M5_parts (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.ConstructorPart> value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S19_ConstructorPartList(value);
}
 public static System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.Constructor> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_ConstructorList (Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructor> value) {
 return new System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.Constructor>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_Constructor));
}
 public static Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructor> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_ConstructorList (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.Constructor> value) {
 return Dafny.Sequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructor>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_Constructor).ToArray());
}
 public static AWS.Cryptography.DynamoDbEncryption.Constructor FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_ConstructorList__M6_member (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructor value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_Constructor(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructor ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_ConstructorList__M6_member (AWS.Cryptography.DynamoDbEncryption.Constructor value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_Constructor(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.ConstructorPart FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_ConstructorPart (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructorPart value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ConstructorPart concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ConstructorPart)value;
 AWS.Cryptography.DynamoDbEncryption.ConstructorPart converted = new AWS.Cryptography.DynamoDbEncryption.ConstructorPart();
  converted.Name = (string) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(concrete._name);
  converted.Required = (bool) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S7_Boolean(concrete._required);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructorPart ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_ConstructorPart (AWS.Cryptography.DynamoDbEncryption.ConstructorPart value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ConstructorPart ( Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value.Name) ,
 Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S7_Boolean(value.Required) ) ;
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_ConstructorPart__M4_name (Dafny.ISequence<char> value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_ConstructorPart__M4_name (string value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static bool FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_ConstructorPart__M8_required (bool value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S7_Boolean(value);
}
 public static bool ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_ConstructorPart__M8_required (bool value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S7_Boolean(value);
}
 public static System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.ConstructorPart> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S19_ConstructorPartList (Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructorPart> value) {
 return new System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.ConstructorPart>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_ConstructorPart));
}
 public static Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructorPart> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S19_ConstructorPartList (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.ConstructorPart> value) {
 return Dafny.Sequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructorPart>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_ConstructorPart).ToArray());
}
 public static AWS.Cryptography.DynamoDbEncryption.ConstructorPart FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S19_ConstructorPartList__M6_member (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructorPart value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_ConstructorPart(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IConstructorPart ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S19_ConstructorPartList__M6_member (AWS.Cryptography.DynamoDbEncryption.ConstructorPart value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_ConstructorPart(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.CreateDynamoDbEncryptionBranchKeyIdSupplierInput FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ICreateDynamoDbEncryptionBranchKeyIdSupplierInput value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput)value;
 AWS.Cryptography.DynamoDbEncryption.CreateDynamoDbEncryptionBranchKeyIdSupplierInput converted = new AWS.Cryptography.DynamoDbEncryption.CreateDynamoDbEncryptionBranchKeyIdSupplierInput();
  converted.DdbKeyBranchKeyIdSupplier = (AWS.Cryptography.DynamoDbEncryption.IDynamoDbKeyBranchKeyIdSupplier) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S39_DynamoDbKeyBranchKeyIdSupplierReference(concrete._ddbKeyBranchKeyIdSupplier);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ICreateDynamoDbEncryptionBranchKeyIdSupplierInput ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput (AWS.Cryptography.DynamoDbEncryption.CreateDynamoDbEncryptionBranchKeyIdSupplierInput value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S39_DynamoDbKeyBranchKeyIdSupplierReference(value.DdbKeyBranchKeyIdSupplier) ) ;
}
 public static AWS.Cryptography.DynamoDbEncryption.IDynamoDbKeyBranchKeyIdSupplier FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput__M25_ddbKeyBranchKeyIdSupplier (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbKeyBranchKeyIdSupplier value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S39_DynamoDbKeyBranchKeyIdSupplierReference(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbKeyBranchKeyIdSupplier ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput__M25_ddbKeyBranchKeyIdSupplier (AWS.Cryptography.DynamoDbEncryption.IDynamoDbKeyBranchKeyIdSupplier value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S39_DynamoDbKeyBranchKeyIdSupplierReference(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ICreateDynamoDbEncryptionBranchKeyIdSupplierOutput value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput)value;
 AWS.Cryptography.DynamoDbEncryption.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput converted = new AWS.Cryptography.DynamoDbEncryption.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput();
  converted.BranchKeyIdSupplier = (AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier) AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference(concrete._branchKeyIdSupplier);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ICreateDynamoDbEncryptionBranchKeyIdSupplierOutput ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput (AWS.Cryptography.DynamoDbEncryption.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput ( AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference(value.BranchKeyIdSupplier) ) ;
}
 public static AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput__M19_branchKeyIdSupplier (Dafny.Aws.Cryptography.MaterialProviders.Types.IBranchKeyIdSupplier value) {
 return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference(value);
}
 public static Dafny.Aws.Cryptography.MaterialProviders.Types.IBranchKeyIdSupplier ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput__M19_branchKeyIdSupplier (AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier value) {
 return AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S28_BranchKeyIdSupplierReference(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.DynamoDbEncryptionConfig FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S24_DynamoDbEncryptionConfig (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IDynamoDbEncryptionConfig value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbEncryptionConfig concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbEncryptionConfig)value;
 AWS.Cryptography.DynamoDbEncryption.DynamoDbEncryptionConfig converted = new AWS.Cryptography.DynamoDbEncryption.DynamoDbEncryptionConfig();
 
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IDynamoDbEncryptionConfig ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S24_DynamoDbEncryptionConfig (AWS.Cryptography.DynamoDbEncryption.DynamoDbEncryptionConfig value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbEncryptionConfig (  ) ;
}
 public static AWS.Cryptography.DynamoDbEncryption.DynamoDbEncryptionException FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S27_DynamoDbEncryptionException (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error_DynamoDbEncryptionException value) {
 return new AWS.Cryptography.DynamoDbEncryption.DynamoDbEncryptionException (
 FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S27_DynamoDbEncryptionException__M7_message(value._message)
 ) ;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error_DynamoDbEncryptionException ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S27_DynamoDbEncryptionException (AWS.Cryptography.DynamoDbEncryption.DynamoDbEncryptionException value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error_DynamoDbEncryptionException (
 Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value.Message)
 ) ;
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S27_DynamoDbEncryptionException__M7_message (Dafny.ISequence<char> value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S27_DynamoDbEncryptionException__M7_message (string value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value);
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
 public static AWS.Cryptography.DynamoDbEncryption.DynamoDbTableEncryptionConfig FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IDynamoDbTableEncryptionConfig value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig)value;
 AWS.Cryptography.DynamoDbEncryption.DynamoDbTableEncryptionConfig converted = new AWS.Cryptography.DynamoDbEncryption.DynamoDbTableEncryptionConfig();
  converted.PartitionKeyName = (string) Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(concrete._partitionKeyName);
 if (concrete._sortKeyName.is_Some) converted.SortKeyName = (string) Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(concrete._sortKeyName.dtor_value);
 if (concrete._search.is_Some) converted.Search = (AWS.Cryptography.DynamoDbEncryption.SearchConfig) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_SearchConfig(concrete._search.dtor_value);
  converted.AttributeActions = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction>) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_AttributeActions(concrete._attributeActions);
 if (concrete._allowedUnauthenticatedAttributes.is_Some) converted.AllowedUnauthenticatedAttributes = (System.Collections.Generic.List<string>) Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList(concrete._allowedUnauthenticatedAttributes.dtor_value);
 if (concrete._allowedUnauthenticatedAttributePrefix.is_Some) converted.AllowedUnauthenticatedAttributePrefix = (string) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(concrete._allowedUnauthenticatedAttributePrefix.dtor_value);
 if (concrete._algorithmSuiteId.is_Some) converted.AlgorithmSuiteId = (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId) AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(concrete._algorithmSuiteId.dtor_value);
 if (concrete._keyring.is_Some) converted.Keyring = (AWS.Cryptography.MaterialProviders.IKeyring) AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference(concrete._keyring.dtor_value);
 if (concrete._cmm.is_Some) converted.Cmm = (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(concrete._cmm.dtor_value);
 if (concrete._legacyConfig.is_Some) converted.LegacyConfig = (AWS.Cryptography.DynamoDbEncryption.LegacyConfig) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyConfig(concrete._legacyConfig.dtor_value);
 if (concrete._plaintextPolicy.is_Some) converted.PlaintextPolicy = (AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_PlaintextPolicy(concrete._plaintextPolicy.dtor_value);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IDynamoDbTableEncryptionConfig ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig (AWS.Cryptography.DynamoDbEncryption.DynamoDbTableEncryptionConfig value) {
 Wrappers_Compile._IOption<Dafny.ISequence<char>> var_sortKeyName =
	value.IsSetSortKeyName() ?
 	new Wrappers_Compile.Option_Some<Dafny.ISequence<char>>(Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(value.SortKeyName))
 	: new Wrappers_Compile.Option_None<Dafny.ISequence<char>>();
 Wrappers_Compile._IOption<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISearchConfig> var_search =
	value.IsSetSearch() ?
 	new Wrappers_Compile.Option_Some<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISearchConfig>(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_SearchConfig(value.Search))
 	: new Wrappers_Compile.Option_None<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISearchConfig>();
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
 	new Wrappers_Compile.Option_Some<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILegacyConfig>(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyConfig(value.LegacyConfig))
 	: new Wrappers_Compile.Option_None<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILegacyConfig>();
 Wrappers_Compile._IOption<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IPlaintextPolicy> var_plaintextPolicy =
	value.IsSetPlaintextPolicy() ?
 	new Wrappers_Compile.Option_Some<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IPlaintextPolicy>(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_PlaintextPolicy(value.PlaintextPolicy))
 	: new Wrappers_Compile.Option_None<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IPlaintextPolicy>();
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig ( Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(value.PartitionKeyName) ,
 var_sortKeyName ,
 var_search ,
 ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_AttributeActions(value.AttributeActions) ,
 var_allowedUnauthenticatedAttributes ,
 var_allowedUnauthenticatedAttributePrefix ,
 var_algorithmSuiteId ,
 var_keyring ,
 var_cmm ,
 var_legacyConfig ,
 var_plaintextPolicy ) ;
}
 public static AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig__M16_algorithmSuiteId (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId> value) {
 return value.is_None ? (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId) null : AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig__M16_algorithmSuiteId (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId>.create_Some(AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId((AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId) value));
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig__M37_allowedUnauthenticatedAttributePrefix (Wrappers_Compile._IOption<Dafny.ISequence<char>> value) {
 return value.is_None ? (string) null : Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig__M37_allowedUnauthenticatedAttributePrefix (string value) {
 return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String((string) value));
}
 public static System.Collections.Generic.List<string> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig__M32_allowedUnauthenticatedAttributes (Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> value) {
 return value.is_None ? (System.Collections.Generic.List<string>) null : Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig__M32_allowedUnauthenticatedAttributes (System.Collections.Generic.List<string> value) {
 return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<char>>>.create_Some(Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList((System.Collections.Generic.List<string>) value));
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig__M16_attributeActions (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_AttributeActions(value);
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig__M16_attributeActions (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_AttributeActions(value);
}
 public static AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig__M3_cmm (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager> value) {
 return value.is_None ? (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) null : AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig__M3_cmm (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager>.create_Some(AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference((AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) value));
}
 public static AWS.Cryptography.MaterialProviders.IKeyring FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig__M7_keyring (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring> value) {
 return value.is_None ? (AWS.Cryptography.MaterialProviders.IKeyring) null : AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig__M7_keyring (AWS.Cryptography.MaterialProviders.IKeyring value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring>.create_Some(AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S16_KeyringReference((AWS.Cryptography.MaterialProviders.IKeyring) value));
}
 public static AWS.Cryptography.DynamoDbEncryption.LegacyConfig FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig__M12_legacyConfig (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILegacyConfig> value) {
 return value.is_None ? (AWS.Cryptography.DynamoDbEncryption.LegacyConfig) null : FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyConfig(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILegacyConfig> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig__M12_legacyConfig (AWS.Cryptography.DynamoDbEncryption.LegacyConfig value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILegacyConfig>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILegacyConfig>.create_Some(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyConfig((AWS.Cryptography.DynamoDbEncryption.LegacyConfig) value));
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig__M16_partitionKeyName (Dafny.ISequence<char> value) {
 return Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig__M16_partitionKeyName (string value) {
 return Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig__M15_plaintextPolicy (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IPlaintextPolicy> value) {
 return value.is_None ? (AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy) null : FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_PlaintextPolicy(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IPlaintextPolicy> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig__M15_plaintextPolicy (AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IPlaintextPolicy>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IPlaintextPolicy>.create_Some(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_PlaintextPolicy((AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy) value));
}
 public static AWS.Cryptography.DynamoDbEncryption.SearchConfig FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig__M6_search (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISearchConfig> value) {
 return value.is_None ? (AWS.Cryptography.DynamoDbEncryption.SearchConfig) null : FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_SearchConfig(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISearchConfig> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig__M6_search (AWS.Cryptography.DynamoDbEncryption.SearchConfig value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISearchConfig>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISearchConfig>.create_Some(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_SearchConfig((AWS.Cryptography.DynamoDbEncryption.SearchConfig) value));
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig__M11_sortKeyName (Wrappers_Compile._IOption<Dafny.ISequence<char>> value) {
 return value.is_None ? (string) null : Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig__M11_sortKeyName (string value) {
 return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_KeySchemaAttributeName((string) value));
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DynamoDbEncryption.DynamoDbTableEncryptionConfig> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S33_DynamoDbTableEncryptionConfigList (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IDynamoDbTableEncryptionConfig> value) {
 return value.ItemEnumerable.ToDictionary(pair => Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig(pair.Cdr));
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IDynamoDbTableEncryptionConfig> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S33_DynamoDbTableEncryptionConfigList (System.Collections.Generic.Dictionary<string, AWS.Cryptography.DynamoDbEncryption.DynamoDbTableEncryptionConfig> value) {
 return Dafny.Map<Dafny.ISequence<char>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IDynamoDbTableEncryptionConfig>.FromCollection(value.Select(pair =>
    new Dafny.Pair<Dafny.ISequence<char>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IDynamoDbTableEncryptionConfig>(Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(pair.Key), ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig(pair.Value))
));
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S33_DynamoDbTableEncryptionConfigList__M3_key (Dafny.ISequence<char> value) {
 return Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S33_DynamoDbTableEncryptionConfigList__M3_key (string value) {
 return Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.DynamoDbTableEncryptionConfig FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S33_DynamoDbTableEncryptionConfigList__M5_value (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IDynamoDbTableEncryptionConfig value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IDynamoDbTableEncryptionConfig ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S33_DynamoDbTableEncryptionConfigList__M5_value (AWS.Cryptography.DynamoDbEncryption.DynamoDbTableEncryptionConfig value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DynamoDbTableEncryptionConfig(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.DynamoDbTablesEncryptionConfig FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S30_DynamoDbTablesEncryptionConfig (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IDynamoDbTablesEncryptionConfig value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTablesEncryptionConfig concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTablesEncryptionConfig)value;
 AWS.Cryptography.DynamoDbEncryption.DynamoDbTablesEncryptionConfig converted = new AWS.Cryptography.DynamoDbEncryption.DynamoDbTablesEncryptionConfig();
  converted.TableEncryptionConfigs = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.DynamoDbEncryption.DynamoDbTableEncryptionConfig>) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S33_DynamoDbTableEncryptionConfigList(concrete._tableEncryptionConfigs);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IDynamoDbTablesEncryptionConfig ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S30_DynamoDbTablesEncryptionConfig (AWS.Cryptography.DynamoDbEncryption.DynamoDbTablesEncryptionConfig value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTablesEncryptionConfig ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S33_DynamoDbTableEncryptionConfigList(value.TableEncryptionConfigs) ) ;
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.DynamoDbEncryption.DynamoDbTableEncryptionConfig> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S30_DynamoDbTablesEncryptionConfig__M22_tableEncryptionConfigs (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IDynamoDbTableEncryptionConfig> value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S33_DynamoDbTableEncryptionConfigList(value);
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IDynamoDbTableEncryptionConfig> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S30_DynamoDbTablesEncryptionConfig__M22_tableEncryptionConfigs (System.Collections.Generic.Dictionary<string, AWS.Cryptography.DynamoDbEncryption.DynamoDbTableEncryptionConfig> value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S33_DynamoDbTableEncryptionConfigList(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyInput FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_GetBranchKeyIdFromDdbKeyInput (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetBranchKeyIdFromDdbKeyInput value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyInput concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyInput)value;
 AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyInput converted = new AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyInput();
  converted.DdbKey = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>) Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(concrete._ddbKey);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetBranchKeyIdFromDdbKeyInput ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_GetBranchKeyIdFromDdbKeyInput (AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyInput value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyInput ( Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value.DdbKey) ) ;
}
 public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_GetBranchKeyIdFromDdbKeyInput__M6_ddbKey (Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> value) {
 return Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Com.Amazonaws.Dynamodb.Types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_GetBranchKeyIdFromDdbKeyInput__M6_ddbKey (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value) {
 return Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyOutput FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S30_GetBranchKeyIdFromDdbKeyOutput (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetBranchKeyIdFromDdbKeyOutput value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyOutput concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyOutput)value;
 AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyOutput converted = new AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyOutput();
  converted.BranchKeyId = (string) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(concrete._branchKeyId);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetBranchKeyIdFromDdbKeyOutput ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S30_GetBranchKeyIdFromDdbKeyOutput (AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyOutput value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyOutput ( Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value.BranchKeyId) ) ;
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S30_GetBranchKeyIdFromDdbKeyOutput__M11_branchKeyId (Dafny.ISequence<char> value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S30_GetBranchKeyIdFromDdbKeyOutput__M11_branchKeyId (string value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.GetPrefix FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetPrefix (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetPrefix value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetPrefix concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetPrefix)value;
 AWS.Cryptography.DynamoDbEncryption.GetPrefix converted = new AWS.Cryptography.DynamoDbEncryption.GetPrefix();
  converted.Length = (int) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S7_Integer(concrete._length);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetPrefix ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetPrefix (AWS.Cryptography.DynamoDbEncryption.GetPrefix value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetPrefix ( Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S7_Integer(value.Length) ) ;
}
 public static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetPrefix__M6_length (int value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S7_Integer(value);
}
 public static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetPrefix__M6_length (int value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S7_Integer(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.GetSegment FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S10_GetSegment (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSegment value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSegment concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSegment)value;
 AWS.Cryptography.DynamoDbEncryption.GetSegment converted = new AWS.Cryptography.DynamoDbEncryption.GetSegment();
  converted.Split = (string) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S4_Char(concrete._split);
  converted.Index = (int) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S7_Integer(concrete._index);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSegment ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S10_GetSegment (AWS.Cryptography.DynamoDbEncryption.GetSegment value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSegment ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S4_Char(value.Split) ,
 Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S7_Integer(value.Index) ) ;
}
 public static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S10_GetSegment__M5_index (int value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S7_Integer(value);
}
 public static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S10_GetSegment__M5_index (int value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S7_Integer(value);
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S10_GetSegment__M5_split (Dafny.ISequence<char> value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S4_Char(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S10_GetSegment__M5_split (string value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S4_Char(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.GetSegments FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSegments value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSegments concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSegments)value;
 AWS.Cryptography.DynamoDbEncryption.GetSegments converted = new AWS.Cryptography.DynamoDbEncryption.GetSegments();
  converted.Split = (string) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S4_Char(concrete._split);
  converted.Low = (int) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S7_Integer(concrete._low);
  converted.High = (int) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S7_Integer(concrete._high);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSegments ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments (AWS.Cryptography.DynamoDbEncryption.GetSegments value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSegments ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S4_Char(value.Split) ,
 Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S7_Integer(value.Low) ,
 Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S7_Integer(value.High) ) ;
}
 public static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments__M4_high (int value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S7_Integer(value);
}
 public static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments__M4_high (int value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S7_Integer(value);
}
 public static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments__M3_low (int value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S7_Integer(value);
}
 public static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments__M3_low (int value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S7_Integer(value);
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments__M5_split (Dafny.ISequence<char> value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S4_Char(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments__M5_split (string value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S4_Char(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.GetSubstring FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_GetSubstring (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSubstring value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSubstring concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSubstring)value;
 AWS.Cryptography.DynamoDbEncryption.GetSubstring converted = new AWS.Cryptography.DynamoDbEncryption.GetSubstring();
  converted.Low = (int) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S7_Integer(concrete._low);
  converted.High = (int) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S7_Integer(concrete._high);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSubstring ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_GetSubstring (AWS.Cryptography.DynamoDbEncryption.GetSubstring value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSubstring ( Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S7_Integer(value.Low) ,
 Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S7_Integer(value.High) ) ;
}
 public static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_GetSubstring__M4_high (int value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S7_Integer(value);
}
 public static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_GetSubstring__M4_high (int value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S7_Integer(value);
}
 public static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_GetSubstring__M3_low (int value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S7_Integer(value);
}
 public static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_GetSubstring__M3_low (int value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S7_Integer(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.GetSuffix FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetSuffix (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSuffix value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSuffix concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSuffix)value;
 AWS.Cryptography.DynamoDbEncryption.GetSuffix converted = new AWS.Cryptography.DynamoDbEncryption.GetSuffix();
  converted.Length = (int) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S7_Integer(concrete._length);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSuffix ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetSuffix (AWS.Cryptography.DynamoDbEncryption.GetSuffix value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSuffix ( Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S7_Integer(value.Length) ) ;
}
 public static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetSuffix__M6_length (int value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S7_Integer(value);
}
 public static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetSuffix__M6_length (int value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S7_Integer(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.Insert FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Insert (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IInsert value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Insert concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Insert)value;
 AWS.Cryptography.DynamoDbEncryption.Insert converted = new AWS.Cryptography.DynamoDbEncryption.Insert();
  converted.Literal = (string) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(concrete._literal);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IInsert ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Insert (AWS.Cryptography.DynamoDbEncryption.Insert value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Insert ( Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value.Literal) ) ;
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Insert__M7_literal (Dafny.ISequence<char> value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Insert__M7_literal (string value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static AWS.Cryptography.KeyStore.KeyStore FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S17_KeyStoreReference (Dafny.Aws.Cryptography.KeyStore.Types.IKeyStoreClient value) {
 if (value is Dafny.Aws.Cryptography.KeyStore.Types.IKeyStoreClient dafnyValue) {
    return new AWS.Cryptography.KeyStore.KeyStore(dafnyValue);
}
 throw new System.ArgumentException("Custom implementations of AWS.Cryptography.KeyStore.KeyStore are not supported yet");
}
 public static Dafny.Aws.Cryptography.KeyStore.Types.IKeyStoreClient ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S17_KeyStoreReference (AWS.Cryptography.KeyStore.KeyStore value) {
 if (value is AWS.Cryptography.KeyStore.KeyStore nativeValue) {
    return nativeValue.impl();
}
 throw new System.ArgumentException("Custom implementations of AWS.Cryptography.KeyStore.KeyStore are not supported yet");
}
 public static AWS.Cryptography.DynamoDbEncryption.LegacyConfig FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyConfig (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILegacyConfig value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.LegacyConfig concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.LegacyConfig)value;
 AWS.Cryptography.DynamoDbEncryption.LegacyConfig converted = new AWS.Cryptography.DynamoDbEncryption.LegacyConfig();
  converted.Policy = (AWS.Cryptography.DynamoDbEncryption.LegacyPolicy) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyPolicy(concrete._policy);
  converted.Encryptor = (AWS.Cryptography.DynamoDbEncryption.ILegacyDynamoDbEncryptor) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S32_LegacyDynamoDbEncryptorReference(concrete._encryptor);
  converted.AttributeFlags = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction>) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_AttributeActions(concrete._attributeFlags);
 if (concrete._defaultAttributeFlag.is_Some) converted.DefaultAttributeFlag = (AWS.Cryptography.StructuredEncryption.CryptoAction) AWS.Cryptography.StructuredEncryption.TypeConversion.FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction(concrete._defaultAttributeFlag.dtor_value);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILegacyConfig ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyConfig (AWS.Cryptography.DynamoDbEncryption.LegacyConfig value) {
 Wrappers_Compile._IOption<Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> var_defaultAttributeFlag =
	value.IsSetDefaultAttributeFlag() ?
 	new Wrappers_Compile.Option_Some<Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction>(AWS.Cryptography.StructuredEncryption.TypeConversion.ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction(value.DefaultAttributeFlag))
 	: new Wrappers_Compile.Option_None<Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction>();
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.LegacyConfig ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyPolicy(value.Policy) ,
 ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S32_LegacyDynamoDbEncryptorReference(value.Encryptor) ,
 ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_AttributeActions(value.AttributeFlags) ,
 var_defaultAttributeFlag ) ;
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyConfig__M14_attributeFlags (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_AttributeActions(value);
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyConfig__M14_attributeFlags (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_AttributeActions(value);
}
 public static AWS.Cryptography.StructuredEncryption.CryptoAction FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyConfig__M20_defaultAttributeFlag (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> value) {
 return value.is_None ? (AWS.Cryptography.StructuredEncryption.CryptoAction) null : AWS.Cryptography.StructuredEncryption.TypeConversion.FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyConfig__M20_defaultAttributeFlag (AWS.Cryptography.StructuredEncryption.CryptoAction value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction>.create_Some(AWS.Cryptography.StructuredEncryption.TypeConversion.ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction((AWS.Cryptography.StructuredEncryption.CryptoAction) value));
}
 public static AWS.Cryptography.DynamoDbEncryption.ILegacyDynamoDbEncryptor FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyConfig__M9_encryptor (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ILegacyDynamoDbEncryptor value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S32_LegacyDynamoDbEncryptorReference(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ILegacyDynamoDbEncryptor ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyConfig__M9_encryptor (AWS.Cryptography.DynamoDbEncryption.ILegacyDynamoDbEncryptor value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S32_LegacyDynamoDbEncryptorReference(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.LegacyPolicy FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyConfig__M6_policy (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILegacyPolicy value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyPolicy(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILegacyPolicy ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyConfig__M6_policy (AWS.Cryptography.DynamoDbEncryption.LegacyPolicy value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyPolicy(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.ILegacyDynamoDbEncryptor FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S32_LegacyDynamoDbEncryptorReference (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ILegacyDynamoDbEncryptor value) {
 if (value is NativeWrapper_LegacyDynamoDbEncryptor nativeWrapper) return nativeWrapper._impl;
return new LegacyDynamoDbEncryptor(value);

}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ILegacyDynamoDbEncryptor ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S32_LegacyDynamoDbEncryptorReference (AWS.Cryptography.DynamoDbEncryption.ILegacyDynamoDbEncryptor value) {
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
 public static AWS.Cryptography.DynamoDbEncryption.LegacyPolicy FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyPolicy (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILegacyPolicy value) {
 if (value.is_REQUIRE__ENCRYPT__ALLOW__DECRYPT) return AWS.Cryptography.DynamoDbEncryption.LegacyPolicy.REQUIRE_ENCRYPT_ALLOW_DECRYPT;
 if (value.is_FORBID__ENCRYPT__ALLOW__DECRYPT) return AWS.Cryptography.DynamoDbEncryption.LegacyPolicy.FORBID_ENCRYPT_ALLOW_DECRYPT;
 if (value.is_FORBID__ENCRYPT__FORBID__DECRYPT) return AWS.Cryptography.DynamoDbEncryption.LegacyPolicy.FORBID_ENCRYPT_FORBID_DECRYPT;
throw new System.ArgumentException("Invalid AWS.Cryptography.DynamoDbEncryption.LegacyPolicy value");
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILegacyPolicy ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_LegacyPolicy (AWS.Cryptography.DynamoDbEncryption.LegacyPolicy value) {
 if (AWS.Cryptography.DynamoDbEncryption.LegacyPolicy.REQUIRE_ENCRYPT_ALLOW_DECRYPT.Equals(value)) return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.LegacyPolicy.create_REQUIRE__ENCRYPT__ALLOW__DECRYPT();
 if (AWS.Cryptography.DynamoDbEncryption.LegacyPolicy.FORBID_ENCRYPT_ALLOW_DECRYPT.Equals(value)) return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.LegacyPolicy.create_FORBID__ENCRYPT__ALLOW__DECRYPT();
 if (AWS.Cryptography.DynamoDbEncryption.LegacyPolicy.FORBID_ENCRYPT_FORBID_DECRYPT.Equals(value)) return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.LegacyPolicy.create_FORBID__ENCRYPT__FORBID__DECRYPT();
throw new System.ArgumentException("Invalid AWS.Cryptography.DynamoDbEncryption.LegacyPolicy value");
}
 public static AWS.Cryptography.DynamoDbEncryption.Lower FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S5_Lower (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILower value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Lower concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Lower)value;
 AWS.Cryptography.DynamoDbEncryption.Lower converted = new AWS.Cryptography.DynamoDbEncryption.Lower();
 
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILower ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S5_Lower (AWS.Cryptography.DynamoDbEncryption.Lower value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Lower (  ) ;
}
 public static AWS.Cryptography.DynamoDbEncryption.MultiKeyStore FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IMultiKeyStore value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.MultiKeyStore concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.MultiKeyStore)value;
 AWS.Cryptography.DynamoDbEncryption.MultiKeyStore converted = new AWS.Cryptography.DynamoDbEncryption.MultiKeyStore();
  converted.KeyFieldName = (string) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(concrete._keyFieldName);
  converted.CacheTTL = (int) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S7_Integer(concrete._cacheTTL);
  converted.MaxCacheSize = (int) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S7_Integer(concrete._maxCacheSize);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IMultiKeyStore ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore (AWS.Cryptography.DynamoDbEncryption.MultiKeyStore value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.MultiKeyStore ( Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value.KeyFieldName) ,
 Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S7_Integer(value.CacheTTL) ,
 Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S7_Integer(value.MaxCacheSize) ) ;
}
 public static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore__M8_cacheTTL (int value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S7_Integer(value);
}
 public static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore__M8_cacheTTL (int value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S7_Integer(value);
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore__M12_keyFieldName (Dafny.ISequence<char> value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore__M12_keyFieldName (string value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore__M12_maxCacheSize (int value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S7_Integer(value);
}
 public static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_MultiKeyStore__M12_maxCacheSize (int value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S7_Integer(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.NonSensitivePart FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_NonSensitivePart (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._INonSensitivePart value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.NonSensitivePart concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.NonSensitivePart)value;
 AWS.Cryptography.DynamoDbEncryption.NonSensitivePart converted = new AWS.Cryptography.DynamoDbEncryption.NonSensitivePart();
  converted.Name = (string) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(concrete._name);
  converted.Prefix = (string) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Prefix(concrete._prefix);
 if (concrete._loc.is_Some) converted.Loc = (string) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_TerminalLocation(concrete._loc.dtor_value);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._INonSensitivePart ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_NonSensitivePart (AWS.Cryptography.DynamoDbEncryption.NonSensitivePart value) {
 Wrappers_Compile._IOption<Dafny.ISequence<char>> var_loc =
	value.IsSetLoc() ?
 	new Wrappers_Compile.Option_Some<Dafny.ISequence<char>>(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_TerminalLocation(value.Loc))
 	: new Wrappers_Compile.Option_None<Dafny.ISequence<char>>();
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.NonSensitivePart ( Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value.Name) ,
 ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Prefix(value.Prefix) ,
 var_loc ) ;
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_NonSensitivePart__M3_loc (Wrappers_Compile._IOption<Dafny.ISequence<char>> value) {
 return value.is_None ? (string) null : FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_TerminalLocation(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_NonSensitivePart__M3_loc (string value) {
 return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_TerminalLocation((string) value));
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_NonSensitivePart__M4_name (Dafny.ISequence<char> value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_NonSensitivePart__M4_name (string value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_NonSensitivePart__M6_prefix (Dafny.ISequence<char> value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Prefix(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_NonSensitivePart__M6_prefix (string value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Prefix(value);
}
 public static System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.NonSensitivePart> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S21_NonSensitivePartsList (Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._INonSensitivePart> value) {
 return new System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.NonSensitivePart>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_NonSensitivePart));
}
 public static Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._INonSensitivePart> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S21_NonSensitivePartsList (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.NonSensitivePart> value) {
 return Dafny.Sequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._INonSensitivePart>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_NonSensitivePart).ToArray());
}
 public static AWS.Cryptography.DynamoDbEncryption.NonSensitivePart FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S21_NonSensitivePartsList__M6_member (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._INonSensitivePart value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_NonSensitivePart(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._INonSensitivePart ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S21_NonSensitivePartsList__M6_member (AWS.Cryptography.DynamoDbEncryption.NonSensitivePart value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_NonSensitivePart(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_PlaintextPolicy (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IPlaintextPolicy value) {
 if (value.is_REQUIRE__WRITE__ALLOW__READ) return AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy.REQUIRE_WRITE_ALLOW_READ;
 if (value.is_FORBID__WRITE__ALLOW__READ) return AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy.FORBID_WRITE_ALLOW_READ;
 if (value.is_FORBID__WRITE__FORBID__READ) return AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy.FORBID_WRITE_FORBID_READ;
throw new System.ArgumentException("Invalid AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy value");
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IPlaintextPolicy ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_PlaintextPolicy (AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy value) {
 if (AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy.REQUIRE_WRITE_ALLOW_READ.Equals(value)) return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PlaintextPolicy.create_REQUIRE__WRITE__ALLOW__READ();
 if (AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy.FORBID_WRITE_ALLOW_READ.Equals(value)) return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PlaintextPolicy.create_FORBID__WRITE__ALLOW__READ();
 if (AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy.FORBID_WRITE_FORBID_READ.Equals(value)) return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PlaintextPolicy.create_FORBID__WRITE__FORBID__READ();
throw new System.ArgumentException("Invalid AWS.Cryptography.DynamoDbEncryption.PlaintextPolicy value");
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Prefix (Dafny.ISequence<char> value) {
 return new string(value.Elements);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Prefix (string value) {
 return Dafny.Sequence<char>.FromString(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.SearchConfig FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_SearchConfig (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISearchConfig value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SearchConfig concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SearchConfig)value;
 AWS.Cryptography.DynamoDbEncryption.SearchConfig converted = new AWS.Cryptography.DynamoDbEncryption.SearchConfig();
  converted.Versions = (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.BeaconVersion>) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S17_BeaconVersionList(concrete._versions);
  converted.WriteVersion = (int) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_VersionNumber(concrete._writeVersion);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISearchConfig ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_SearchConfig (AWS.Cryptography.DynamoDbEncryption.SearchConfig value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SearchConfig ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S17_BeaconVersionList(value.Versions) ,
 ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_VersionNumber(value.WriteVersion) ) ;
}
 public static System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.BeaconVersion> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_SearchConfig__M8_versions (Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBeaconVersion> value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S17_BeaconVersionList(value);
}
 public static Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBeaconVersion> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_SearchConfig__M8_versions (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.BeaconVersion> value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S17_BeaconVersionList(value);
}
 public static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_SearchConfig__M12_writeVersion (int value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_VersionNumber(value);
}
 public static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_SearchConfig__M12_writeVersion (int value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_VersionNumber(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.SensitivePart FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_SensitivePart (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISensitivePart value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SensitivePart concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SensitivePart)value;
 AWS.Cryptography.DynamoDbEncryption.SensitivePart converted = new AWS.Cryptography.DynamoDbEncryption.SensitivePart();
  converted.Name = (string) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(concrete._name);
  converted.Prefix = (string) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Prefix(concrete._prefix);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISensitivePart ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_SensitivePart (AWS.Cryptography.DynamoDbEncryption.SensitivePart value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SensitivePart ( Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value.Name) ,
 ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Prefix(value.Prefix) ) ;
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_SensitivePart__M4_name (Dafny.ISequence<char> value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_SensitivePart__M4_name (string value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_SensitivePart__M6_prefix (Dafny.ISequence<char> value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Prefix(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_SensitivePart__M6_prefix (string value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Prefix(value);
}
 public static System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.SensitivePart> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_SensitivePartsList (Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISensitivePart> value) {
 return new System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.SensitivePart>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_SensitivePart));
}
 public static Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISensitivePart> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_SensitivePartsList (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.SensitivePart> value) {
 return Dafny.Sequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISensitivePart>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_SensitivePart).ToArray());
}
 public static AWS.Cryptography.DynamoDbEncryption.SensitivePart FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_SensitivePartsList__M6_member (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISensitivePart value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_SensitivePart(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISensitivePart ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_SensitivePartsList__M6_member (AWS.Cryptography.DynamoDbEncryption.SensitivePart value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_SensitivePart(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.SingleKeyStore FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_SingleKeyStore (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISingleKeyStore value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SingleKeyStore concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SingleKeyStore)value;
 AWS.Cryptography.DynamoDbEncryption.SingleKeyStore converted = new AWS.Cryptography.DynamoDbEncryption.SingleKeyStore();
  converted.KeyId = (string) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(concrete._keyId);
  converted.CacheTTL = (int) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S7_Integer(concrete._cacheTTL);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ISingleKeyStore ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_SingleKeyStore (AWS.Cryptography.DynamoDbEncryption.SingleKeyStore value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SingleKeyStore ( Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value.KeyId) ,
 Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S7_Integer(value.CacheTTL) ) ;
}
 public static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_SingleKeyStore__M8_cacheTTL (int value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S7_Integer(value);
}
 public static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_SingleKeyStore__M8_cacheTTL (int value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S7_Integer(value);
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_SingleKeyStore__M5_keyId (Dafny.ISequence<char> value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_SingleKeyStore__M5_keyId (string value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.StandardBeacon FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_StandardBeacon (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IStandardBeacon value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.StandardBeacon concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.StandardBeacon)value;
 AWS.Cryptography.DynamoDbEncryption.StandardBeacon converted = new AWS.Cryptography.DynamoDbEncryption.StandardBeacon();
  converted.Name = (string) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(concrete._name);
  converted.Length = (int) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconBitLength(concrete._length);
 if (concrete._loc.is_Some) converted.Loc = (string) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_TerminalLocation(concrete._loc.dtor_value);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IStandardBeacon ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_StandardBeacon (AWS.Cryptography.DynamoDbEncryption.StandardBeacon value) {
 Wrappers_Compile._IOption<Dafny.ISequence<char>> var_loc =
	value.IsSetLoc() ?
 	new Wrappers_Compile.Option_Some<Dafny.ISequence<char>>(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_TerminalLocation(value.Loc))
 	: new Wrappers_Compile.Option_None<Dafny.ISequence<char>>();
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.StandardBeacon ( Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value.Name) ,
 ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconBitLength(value.Length) ,
 var_loc ) ;
}
 public static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_StandardBeacon__M6_length (int value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconBitLength(value);
}
 public static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_StandardBeacon__M6_length (int value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_BeaconBitLength(value);
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_StandardBeacon__M3_loc (Wrappers_Compile._IOption<Dafny.ISequence<char>> value) {
 return value.is_None ? (string) null : FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_TerminalLocation(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_StandardBeacon__M3_loc (string value) {
 return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_TerminalLocation((string) value));
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_StandardBeacon__M4_name (Dafny.ISequence<char> value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_StandardBeacon__M4_name (string value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.StandardBeacon> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_StandardBeaconList (Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IStandardBeacon> value) {
 return new System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.StandardBeacon>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_StandardBeacon));
}
 public static Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IStandardBeacon> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_StandardBeaconList (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.StandardBeacon> value) {
 return Dafny.Sequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IStandardBeacon>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_StandardBeacon).ToArray());
}
 public static AWS.Cryptography.DynamoDbEncryption.StandardBeacon FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_StandardBeaconList__M6_member (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IStandardBeacon value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_StandardBeacon(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IStandardBeacon ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S18_StandardBeaconList__M6_member (AWS.Cryptography.DynamoDbEncryption.StandardBeacon value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S14_StandardBeacon(value);
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_TerminalLocation (Dafny.ISequence<char> value) {
 return new string(value.Elements);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_TerminalLocation (string value) {
 return Dafny.Sequence<char>.FromString(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.Upper FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S5_Upper (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IUpper value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Upper concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Upper)value;
 AWS.Cryptography.DynamoDbEncryption.Upper converted = new AWS.Cryptography.DynamoDbEncryption.Upper();
 
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IUpper ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S5_Upper (AWS.Cryptography.DynamoDbEncryption.Upper value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Upper (  ) ;
}
 public static int FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_VersionNumber (int value) {
 return value;
}
 public static int ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S13_VersionNumber (int value) {
 return value;
}
 public static AWS.Cryptography.DynamoDbEncryption.VirtualField FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_VirtualField (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualField value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualField concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualField)value;
 AWS.Cryptography.DynamoDbEncryption.VirtualField converted = new AWS.Cryptography.DynamoDbEncryption.VirtualField();
  converted.Name = (string) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(concrete._name);
  converted.Parts = (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualPart>) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_VirtualPartList(concrete._parts);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualField ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_VirtualField (AWS.Cryptography.DynamoDbEncryption.VirtualField value) {

 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualField ( Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value.Name) ,
 ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_VirtualPartList(value.Parts) ) ;
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_VirtualField__M4_name (Dafny.ISequence<char> value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_VirtualField__M4_name (string value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualPart> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_VirtualField__M5_parts (Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualPart> value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_VirtualPartList(value);
}
 public static Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualPart> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_VirtualField__M5_parts (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualPart> value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_VirtualPartList(value);
}
 public static System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualField> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualFieldList (Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualField> value) {
 return new System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualField>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_VirtualField));
}
 public static Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualField> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualFieldList (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualField> value) {
 return Dafny.Sequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualField>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_VirtualField).ToArray());
}
 public static AWS.Cryptography.DynamoDbEncryption.VirtualField FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualFieldList__M6_member (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualField value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_VirtualField(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualField ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualFieldList__M6_member (AWS.Cryptography.DynamoDbEncryption.VirtualField value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_VirtualField(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.VirtualPart FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_VirtualPart (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualPart value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualPart concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualPart)value;
 AWS.Cryptography.DynamoDbEncryption.VirtualPart converted = new AWS.Cryptography.DynamoDbEncryption.VirtualPart();
  converted.Loc = (string) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_TerminalLocation(concrete._loc);
 if (concrete._trans.is_Some) converted.Trans = (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualTransform>) FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S20_VirtualTransformList(concrete._trans.dtor_value);
 return converted;
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualPart ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_VirtualPart (AWS.Cryptography.DynamoDbEncryption.VirtualPart value) {
 Wrappers_Compile._IOption<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualTransform>> var_trans =
	value.IsSetTrans() ?
 	new Wrappers_Compile.Option_Some<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualTransform>>(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S20_VirtualTransformList(value.Trans))
 	: new Wrappers_Compile.Option_None<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualTransform>>();
 return new Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualPart ( ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_TerminalLocation(value.Loc) ,
 var_trans ) ;
}
 public static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_VirtualPart__M3_loc (Dafny.ISequence<char> value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_TerminalLocation(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_VirtualPart__M3_loc (string value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_TerminalLocation(value);
}
 public static System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualTransform> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_VirtualPart__M5_trans (Wrappers_Compile._IOption<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualTransform>> value) {
 return value.is_None ? (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualTransform>) null : FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S20_VirtualTransformList(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualTransform>> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_VirtualPart__M5_trans (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualTransform> value) {
 return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualTransform>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualTransform>>.create_Some(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S20_VirtualTransformList((System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualTransform>) value));
}
 public static System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualPart> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_VirtualPartList (Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualPart> value) {
 return new System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualPart>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_VirtualPart));
}
 public static Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualPart> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_VirtualPartList (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualPart> value) {
 return Dafny.Sequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualPart>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_VirtualPart).ToArray());
}
 public static AWS.Cryptography.DynamoDbEncryption.VirtualPart FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_VirtualPartList__M6_member (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualPart value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_VirtualPart(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualPart ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S15_VirtualPartList__M6_member (AWS.Cryptography.DynamoDbEncryption.VirtualPart value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_VirtualPart(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.VirtualTransform FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualTransform value) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform concrete = (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform)value;
 var converted = new AWS.Cryptography.DynamoDbEncryption.VirtualTransform(); if (value.is_upper) {
 converted.Upper = FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S5_Upper(concrete.dtor_upper);
 return converted;
} if (value.is_lower) {
 converted.Lower = FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S5_Lower(concrete.dtor_lower);
 return converted;
} if (value.is_insert) {
 converted.Insert = FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Insert(concrete.dtor_insert);
 return converted;
} if (value.is_prefix) {
 converted.Prefix = FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetPrefix(concrete.dtor_prefix);
 return converted;
} if (value.is_suffix) {
 converted.Suffix = FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetSuffix(concrete.dtor_suffix);
 return converted;
} if (value.is_substring) {
 converted.Substring = FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_GetSubstring(concrete.dtor_substring);
 return converted;
} if (value.is_segment) {
 converted.Segment = FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S10_GetSegment(concrete.dtor_segment);
 return converted;
} if (value.is_segments) {
 converted.Segments = FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments(concrete.dtor_segments);
 return converted;
}
throw new System.ArgumentException("Invalid AWS.Cryptography.DynamoDbEncryption.VirtualTransform state");
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualTransform ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform (AWS.Cryptography.DynamoDbEncryption.VirtualTransform value) {
 if (value.IsSetUpper()) {
 return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform.create_upper(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S5_Upper(value.Upper));
} if (value.IsSetLower()) {
 return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform.create_lower(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S5_Lower(value.Lower));
} if (value.IsSetInsert()) {
 return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform.create_insert(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Insert(value.Insert));
} if (value.IsSetPrefix()) {
 return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform.create_prefix(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetPrefix(value.Prefix));
} if (value.IsSetSuffix()) {
 return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform.create_suffix(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetSuffix(value.Suffix));
} if (value.IsSetSubstring()) {
 return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform.create_substring(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_GetSubstring(value.Substring));
} if (value.IsSetSegment()) {
 return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform.create_segment(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S10_GetSegment(value.Segment));
} if (value.IsSetSegments()) {
 return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform.create_segments(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments(value.Segments));
}
throw new System.ArgumentException("Invalid AWS.Cryptography.DynamoDbEncryption.VirtualTransform state");
}
 public static AWS.Cryptography.DynamoDbEncryption.Insert FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M6_insert (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IInsert value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Insert(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IInsert ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M6_insert (AWS.Cryptography.DynamoDbEncryption.Insert value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S6_Insert(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.Lower FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M5_lower (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILower value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S5_Lower(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ILower ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M5_lower (AWS.Cryptography.DynamoDbEncryption.Lower value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S5_Lower(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.GetPrefix FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M6_prefix (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetPrefix value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetPrefix(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetPrefix ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M6_prefix (AWS.Cryptography.DynamoDbEncryption.GetPrefix value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetPrefix(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.GetSegment FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M7_segment (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSegment value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S10_GetSegment(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSegment ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M7_segment (AWS.Cryptography.DynamoDbEncryption.GetSegment value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S10_GetSegment(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.GetSegments FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M8_segments (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSegments value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSegments ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M8_segments (AWS.Cryptography.DynamoDbEncryption.GetSegments value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S11_GetSegments(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.GetSubstring FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M9_substring (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSubstring value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_GetSubstring(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSubstring ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M9_substring (AWS.Cryptography.DynamoDbEncryption.GetSubstring value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S12_GetSubstring(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.GetSuffix FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M6_suffix (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSuffix value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetSuffix(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetSuffix ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M6_suffix (AWS.Cryptography.DynamoDbEncryption.GetSuffix value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S9_GetSuffix(value);
}
 public static AWS.Cryptography.DynamoDbEncryption.Upper FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M5_upper (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IUpper value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S5_Upper(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IUpper ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform__M5_upper (AWS.Cryptography.DynamoDbEncryption.Upper value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S5_Upper(value);
}
 public static System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualTransform> FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S20_VirtualTransformList (Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualTransform> value) {
 return new System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualTransform>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform));
}
 public static Dafny.ISequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualTransform> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S20_VirtualTransformList (System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualTransform> value) {
 return Dafny.Sequence<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualTransform>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform).ToArray());
}
 public static AWS.Cryptography.DynamoDbEncryption.VirtualTransform FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S20_VirtualTransformList__M6_member (Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualTransform value) {
 return FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform(value);
}
 public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IVirtualTransform ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S20_VirtualTransformList__M6_member (AWS.Cryptography.DynamoDbEncryption.VirtualTransform value) {
 return ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S16_VirtualTransform(value);
}
 public static string FromDafny_N6_smithy__N3_api__S6_String (Dafny.ISequence<char> value) {
 return new string(value.Elements);
}
 public static Dafny.ISequence<char> ToDafny_N6_smithy__N3_api__S6_String (string value) {
 return Dafny.Sequence<char>.FromString(value);
}
 public static bool FromDafny_N6_smithy__N3_api__S7_Boolean (bool value) {
 return value;
}
 public static bool ToDafny_N6_smithy__N3_api__S7_Boolean (bool value) {
 return value;
}
 public static int FromDafny_N6_smithy__N3_api__S7_Integer (int value) {
 return value;
}
 public static int ToDafny_N6_smithy__N3_api__S7_Integer (int value) {
 return value;
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
}
}
