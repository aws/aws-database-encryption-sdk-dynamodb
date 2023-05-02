// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System.Linq; using System; namespace AWS.Cryptography.StructuredEncryption {
 public static class TypeConversion {
 public static AWS.Cryptography.Primitives.AtomicPrimitives FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S25_AtomicPrimitivesReference (Dafny.Aws.Cryptography.Primitives.Types.IAwsCryptographicPrimitivesClient value) {
 if (value is Dafny.Aws.Cryptography.Primitives.Types.IAwsCryptographicPrimitivesClient dafnyValue) {
    return new AWS.Cryptography.Primitives.AtomicPrimitives(dafnyValue);
}
 throw new System.ArgumentException("Custom implementations of AWS.Cryptography.Primitives.AtomicPrimitives are not supported yet");
}
 public static Dafny.Aws.Cryptography.Primitives.Types.IAwsCryptographicPrimitivesClient ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S25_AtomicPrimitivesReference (AWS.Cryptography.Primitives.AtomicPrimitives value) {
 if (value is AWS.Cryptography.Primitives.AtomicPrimitives nativeValue) {
    return nativeValue.impl();
}
 throw new System.ArgumentException("Custom implementations of AWS.Cryptography.Primitives.AtomicPrimitives are not supported yet");
}
 public static AWS.Cryptography.StructuredEncryption.AuthenticateAction FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateAction (Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction value) {
 if (value.is_SIGN) return AWS.Cryptography.StructuredEncryption.AuthenticateAction.SIGN;
 if (value.is_DO__NOT__SIGN) return AWS.Cryptography.StructuredEncryption.AuthenticateAction.DO_NOT_SIGN;
throw new System.ArgumentException("Invalid AWS.Cryptography.StructuredEncryption.AuthenticateAction value");
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateAction (AWS.Cryptography.StructuredEncryption.AuthenticateAction value) {
 if (AWS.Cryptography.StructuredEncryption.AuthenticateAction.SIGN.Equals(value)) return Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction.create_SIGN();
 if (AWS.Cryptography.StructuredEncryption.AuthenticateAction.DO_NOT_SIGN.Equals(value)) return Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction.create_DO__NOT__SIGN();
throw new System.ArgumentException("Invalid AWS.Cryptography.StructuredEncryption.AuthenticateAction value");
}
 public static AWS.Cryptography.StructuredEncryption.AuthenticateSchema FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateSchema (Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchema value) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema concrete = (Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema)value;
 AWS.Cryptography.StructuredEncryption.AuthenticateSchema converted = new AWS.Cryptography.StructuredEncryption.AuthenticateSchema();
  converted.Content = (AWS.Cryptography.StructuredEncryption.AuthenticateSchemaContent) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S25_AuthenticateSchemaContent(concrete._content);
 if (concrete._attributes.is_Some) converted.Attributes = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.AuthenticateAction>) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S28_AuthenticateSchemaAttributes(concrete._attributes.dtor_value);
 return converted;
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchema ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateSchema (AWS.Cryptography.StructuredEncryption.AuthenticateSchema value) {
 Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction>> var_attributes =
	value.IsSetAttributes() ?
 	new Wrappers_Compile.Option_Some<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction>>(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S28_AuthenticateSchemaAttributes(value.Attributes))
 	: new Wrappers_Compile.Option_None<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction>>();
 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema ( ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S25_AuthenticateSchemaContent(value.Content) ,
 var_attributes ) ;
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.AuthenticateAction> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateSchema__M10_attributes (Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction>> value) {
 return value.is_None ? (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.AuthenticateAction>) null : FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S28_AuthenticateSchemaAttributes(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction>> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateSchema__M10_attributes (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.AuthenticateAction> value) {
 return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction>>.create_Some(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S28_AuthenticateSchemaAttributes((System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.AuthenticateAction>) value));
}
 public static AWS.Cryptography.StructuredEncryption.AuthenticateSchemaContent FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateSchema__M7_content (Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchemaContent value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S25_AuthenticateSchemaContent(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchemaContent ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateSchema__M7_content (AWS.Cryptography.StructuredEncryption.AuthenticateSchemaContent value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S25_AuthenticateSchemaContent(value);
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.AuthenticateAction> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S28_AuthenticateSchemaAttributes (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction> value) {
 return value.ItemEnumerable.ToDictionary(pair => Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateAction(pair.Cdr));
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S28_AuthenticateSchemaAttributes (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.AuthenticateAction> value) {
 return Dafny.Map<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction>.FromCollection(value.Select(pair =>
    new Dafny.Pair<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction>(Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(pair.Key), ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateAction(pair.Value))
));
}
 public static string FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S28_AuthenticateSchemaAttributes__M3_key (Dafny.ISequence<char> value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S28_AuthenticateSchemaAttributes__M3_key (string value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static AWS.Cryptography.StructuredEncryption.AuthenticateAction FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S28_AuthenticateSchemaAttributes__M5_value (Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateAction(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S28_AuthenticateSchemaAttributes__M5_value (AWS.Cryptography.StructuredEncryption.AuthenticateAction value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateAction(value);
}
 public static AWS.Cryptography.StructuredEncryption.AuthenticateSchemaContent FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S25_AuthenticateSchemaContent (Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchemaContent value) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchemaContent concrete = (Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchemaContent)value;
 var converted = new AWS.Cryptography.StructuredEncryption.AuthenticateSchemaContent(); if (value.is_Action) {
 converted.Action = FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateAction(concrete.dtor_Action);
 return converted;
} if (value.is_SchemaMap) {
 converted.SchemaMap = FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_AuthenticateSchemaMap(concrete.dtor_SchemaMap);
 return converted;
} if (value.is_SchemaList) {
 converted.SchemaList = FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_AuthenticateSchemaList(concrete.dtor_SchemaList);
 return converted;
}
throw new System.ArgumentException("Invalid AWS.Cryptography.StructuredEncryption.AuthenticateSchemaContent state");
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchemaContent ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S25_AuthenticateSchemaContent (AWS.Cryptography.StructuredEncryption.AuthenticateSchemaContent value) {
 if (value.IsSetAction()) {
 return Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchemaContent.create_Action(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateAction(value.Action));
} if (value.IsSetSchemaMap()) {
 return Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchemaContent.create_SchemaMap(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_AuthenticateSchemaMap(value.SchemaMap));
} if (value.IsSetSchemaList()) {
 return Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchemaContent.create_SchemaList(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_AuthenticateSchemaList(value.SchemaList));
}
throw new System.ArgumentException("Invalid AWS.Cryptography.StructuredEncryption.AuthenticateSchemaContent state");
}
 public static AWS.Cryptography.StructuredEncryption.AuthenticateAction FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S25_AuthenticateSchemaContent__M6_Action (Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateAction(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S25_AuthenticateSchemaContent__M6_Action (AWS.Cryptography.StructuredEncryption.AuthenticateAction value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateAction(value);
}
 public static System.Collections.Generic.List<AWS.Cryptography.StructuredEncryption.AuthenticateSchema> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S25_AuthenticateSchemaContent__M10_SchemaList (Dafny.ISequence<Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchema> value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_AuthenticateSchemaList(value);
}
 public static Dafny.ISequence<Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchema> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S25_AuthenticateSchemaContent__M10_SchemaList (System.Collections.Generic.List<AWS.Cryptography.StructuredEncryption.AuthenticateSchema> value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_AuthenticateSchemaList(value);
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.AuthenticateSchema> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S25_AuthenticateSchemaContent__M9_SchemaMap (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchema> value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_AuthenticateSchemaMap(value);
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchema> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S25_AuthenticateSchemaContent__M9_SchemaMap (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.AuthenticateSchema> value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_AuthenticateSchemaMap(value);
}
 public static System.Collections.Generic.List<AWS.Cryptography.StructuredEncryption.AuthenticateSchema> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_AuthenticateSchemaList (Dafny.ISequence<Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchema> value) {
 return new System.Collections.Generic.List<AWS.Cryptography.StructuredEncryption.AuthenticateSchema>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateSchema));
}
 public static Dafny.ISequence<Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchema> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_AuthenticateSchemaList (System.Collections.Generic.List<AWS.Cryptography.StructuredEncryption.AuthenticateSchema> value) {
 return Dafny.Sequence<Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchema>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateSchema).ToArray());
}
 public static AWS.Cryptography.StructuredEncryption.AuthenticateSchema FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_AuthenticateSchemaList__M6_member (Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchema value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateSchema(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchema ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_AuthenticateSchemaList__M6_member (AWS.Cryptography.StructuredEncryption.AuthenticateSchema value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateSchema(value);
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.AuthenticateSchema> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_AuthenticateSchemaMap (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchema> value) {
 return value.ItemEnumerable.ToDictionary(pair => Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateSchema(pair.Cdr));
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchema> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_AuthenticateSchemaMap (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.AuthenticateSchema> value) {
 return Dafny.Map<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchema>.FromCollection(value.Select(pair =>
    new Dafny.Pair<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchema>(Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(pair.Key), ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateSchema(pair.Value))
));
}
 public static string FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_AuthenticateSchemaMap__M3_key (Dafny.ISequence<char> value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_AuthenticateSchemaMap__M3_key (string value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static AWS.Cryptography.StructuredEncryption.AuthenticateSchema FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_AuthenticateSchemaMap__M5_value (Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchema value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateSchema(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchema ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_AuthenticateSchemaMap__M5_value (AWS.Cryptography.StructuredEncryption.AuthenticateSchema value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateSchema(value);
}
 public static AWS.Cryptography.StructuredEncryption.CryptoAction FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction (Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction value) {
 if (value.is_ENCRYPT__AND__SIGN) return AWS.Cryptography.StructuredEncryption.CryptoAction.ENCRYPT_AND_SIGN;
 if (value.is_SIGN__ONLY) return AWS.Cryptography.StructuredEncryption.CryptoAction.SIGN_ONLY;
 if (value.is_DO__NOTHING) return AWS.Cryptography.StructuredEncryption.CryptoAction.DO_NOTHING;
throw new System.ArgumentException("Invalid AWS.Cryptography.StructuredEncryption.CryptoAction value");
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction (AWS.Cryptography.StructuredEncryption.CryptoAction value) {
 if (AWS.Cryptography.StructuredEncryption.CryptoAction.ENCRYPT_AND_SIGN.Equals(value)) return Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_ENCRYPT__AND__SIGN();
 if (AWS.Cryptography.StructuredEncryption.CryptoAction.SIGN_ONLY.Equals(value)) return Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_SIGN__ONLY();
 if (AWS.Cryptography.StructuredEncryption.CryptoAction.DO_NOTHING.Equals(value)) return Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_DO__NOTHING();
throw new System.ArgumentException("Invalid AWS.Cryptography.StructuredEncryption.CryptoAction value");
}
 public static AWS.Cryptography.StructuredEncryption.CryptoSchema FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema (Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema value) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema concrete = (Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema)value;
 AWS.Cryptography.StructuredEncryption.CryptoSchema converted = new AWS.Cryptography.StructuredEncryption.CryptoSchema();
  converted.Content = (AWS.Cryptography.StructuredEncryption.CryptoSchemaContent) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S19_CryptoSchemaContent(concrete._content);
 if (concrete._attributes.is_Some) converted.Attributes = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.AuthenticateAction>) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes(concrete._attributes.dtor_value);
 return converted;
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema (AWS.Cryptography.StructuredEncryption.CryptoSchema value) {
 Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction>> var_attributes =
	value.IsSetAttributes() ?
 	new Wrappers_Compile.Option_Some<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction>>(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes(value.Attributes))
 	: new Wrappers_Compile.Option_None<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction>>();
 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema ( ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S19_CryptoSchemaContent(value.Content) ,
 var_attributes ) ;
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.AuthenticateAction> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema__M10_attributes (Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction>> value) {
 return value.is_None ? (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.AuthenticateAction>) null : FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction>> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema__M10_attributes (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.AuthenticateAction> value) {
 return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction>>.create_Some(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes((System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.AuthenticateAction>) value));
}
 public static AWS.Cryptography.StructuredEncryption.CryptoSchemaContent FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema__M7_content (Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchemaContent value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S19_CryptoSchemaContent(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchemaContent ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema__M7_content (AWS.Cryptography.StructuredEncryption.CryptoSchemaContent value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S19_CryptoSchemaContent(value);
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.AuthenticateAction> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction> value) {
 return value.ItemEnumerable.ToDictionary(pair => Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateAction(pair.Cdr));
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.AuthenticateAction> value) {
 return Dafny.Map<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction>.FromCollection(value.Select(pair =>
    new Dafny.Pair<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction>(Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(pair.Key), ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateAction(pair.Value))
));
}
 public static string FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes__M3_key (Dafny.ISequence<char> value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes__M3_key (string value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static AWS.Cryptography.StructuredEncryption.AuthenticateAction FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes__M5_value (Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateAction(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateAction ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_CryptoSchemaAttributes__M5_value (AWS.Cryptography.StructuredEncryption.AuthenticateAction value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateAction(value);
}
 public static AWS.Cryptography.StructuredEncryption.CryptoSchemaContent FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S19_CryptoSchemaContent (Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchemaContent value) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchemaContent concrete = (Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchemaContent)value;
 var converted = new AWS.Cryptography.StructuredEncryption.CryptoSchemaContent(); if (value.is_Action) {
 converted.Action = FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction(concrete.dtor_Action);
 return converted;
} if (value.is_SchemaMap) {
 converted.SchemaMap = FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S15_CryptoSchemaMap(concrete.dtor_SchemaMap);
 return converted;
} if (value.is_SchemaList) {
 converted.SchemaList = FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S16_CryptoSchemaList(concrete.dtor_SchemaList);
 return converted;
}
throw new System.ArgumentException("Invalid AWS.Cryptography.StructuredEncryption.CryptoSchemaContent state");
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchemaContent ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S19_CryptoSchemaContent (AWS.Cryptography.StructuredEncryption.CryptoSchemaContent value) {
 if (value.IsSetAction()) {
 return Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchemaContent.create_Action(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction(value.Action));
} if (value.IsSetSchemaMap()) {
 return Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchemaContent.create_SchemaMap(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S15_CryptoSchemaMap(value.SchemaMap));
} if (value.IsSetSchemaList()) {
 return Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchemaContent.create_SchemaList(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S16_CryptoSchemaList(value.SchemaList));
}
throw new System.ArgumentException("Invalid AWS.Cryptography.StructuredEncryption.CryptoSchemaContent state");
}
 public static AWS.Cryptography.StructuredEncryption.CryptoAction FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S19_CryptoSchemaContent__M6_Action (Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoAction ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S19_CryptoSchemaContent__M6_Action (AWS.Cryptography.StructuredEncryption.CryptoAction value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoAction(value);
}
 public static System.Collections.Generic.List<AWS.Cryptography.StructuredEncryption.CryptoSchema> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S19_CryptoSchemaContent__M10_SchemaList (Dafny.ISequence<Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema> value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S16_CryptoSchemaList(value);
}
 public static Dafny.ISequence<Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S19_CryptoSchemaContent__M10_SchemaList (System.Collections.Generic.List<AWS.Cryptography.StructuredEncryption.CryptoSchema> value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S16_CryptoSchemaList(value);
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoSchema> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S19_CryptoSchemaContent__M9_SchemaMap (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema> value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S15_CryptoSchemaMap(value);
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S19_CryptoSchemaContent__M9_SchemaMap (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoSchema> value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S15_CryptoSchemaMap(value);
}
 public static System.Collections.Generic.List<AWS.Cryptography.StructuredEncryption.CryptoSchema> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S16_CryptoSchemaList (Dafny.ISequence<Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema> value) {
 return new System.Collections.Generic.List<AWS.Cryptography.StructuredEncryption.CryptoSchema>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema));
}
 public static Dafny.ISequence<Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S16_CryptoSchemaList (System.Collections.Generic.List<AWS.Cryptography.StructuredEncryption.CryptoSchema> value) {
 return Dafny.Sequence<Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema).ToArray());
}
 public static AWS.Cryptography.StructuredEncryption.CryptoSchema FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S16_CryptoSchemaList__M6_member (Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S16_CryptoSchemaList__M6_member (AWS.Cryptography.StructuredEncryption.CryptoSchema value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema(value);
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoSchema> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S15_CryptoSchemaMap (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema> value) {
 return value.ItemEnumerable.ToDictionary(pair => Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema(pair.Cdr));
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S15_CryptoSchemaMap (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoSchema> value) {
 return Dafny.Map<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema>.FromCollection(value.Select(pair =>
    new Dafny.Pair<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema>(Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(pair.Key), ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema(pair.Value))
));
}
 public static string FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S15_CryptoSchemaMap__M3_key (Dafny.ISequence<char> value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S15_CryptoSchemaMap__M3_key (string value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static AWS.Cryptography.StructuredEncryption.CryptoSchema FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S15_CryptoSchemaMap__M5_value (Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S15_CryptoSchemaMap__M5_value (AWS.Cryptography.StructuredEncryption.CryptoSchema value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema(value);
}
 public static AWS.Cryptography.StructuredEncryption.DecryptStructureInput FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput (Dafny.Aws.Cryptography.StructuredEncryption.Types._IDecryptStructureInput value) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureInput concrete = (Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureInput)value;
 AWS.Cryptography.StructuredEncryption.DecryptStructureInput converted = new AWS.Cryptography.StructuredEncryption.DecryptStructureInput();
  converted.TableName = (string) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(concrete._tableName);
  converted.EncryptedStructure = (AWS.Cryptography.StructuredEncryption.StructuredData) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(concrete._encryptedStructure);
  converted.AuthenticateSchema = (AWS.Cryptography.StructuredEncryption.AuthenticateSchema) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateSchema(concrete._authenticateSchema);
  converted.Cmm = (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(concrete._cmm);
 if (concrete._encryptionContext.is_Some) converted.EncryptionContext = (System.Collections.Generic.Dictionary<string, string>) AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(concrete._encryptionContext.dtor_value);
 return converted;
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IDecryptStructureInput ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput (AWS.Cryptography.StructuredEncryption.DecryptStructureInput value) {
 Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> var_encryptionContext =
	value.IsSetEncryptionContext() ?
 	new Wrappers_Compile.Option_Some<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>(AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value.EncryptionContext))
 	: new Wrappers_Compile.Option_None<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>();
 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureInput ( Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value.TableName) ,
 ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value.EncryptedStructure) ,
 ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateSchema(value.AuthenticateSchema) ,
 AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value.Cmm) ,
 var_encryptionContext ) ;
}
 public static AWS.Cryptography.StructuredEncryption.AuthenticateSchema FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M18_authenticateSchema (Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchema value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateSchema(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IAuthenticateSchema ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M18_authenticateSchema (AWS.Cryptography.StructuredEncryption.AuthenticateSchema value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_AuthenticateSchema(value);
}
 public static AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M3_cmm (Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager value) {
 return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value);
}
 public static Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M3_cmm (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager value) {
 return AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value);
}
 public static AWS.Cryptography.StructuredEncryption.StructuredData FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M18_encryptedStructure (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M18_encryptedStructure (AWS.Cryptography.StructuredEncryption.StructuredData value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value);
}
 public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M17_encryptionContext (Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> value) {
 return value.is_None ? (System.Collections.Generic.Dictionary<string, string>) null : AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M17_encryptionContext (System.Collections.Generic.Dictionary<string, string> value) {
 return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>.create_Some(AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext((System.Collections.Generic.Dictionary<string, string>) value));
}
 public static string FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M9_tableName (Dafny.ISequence<char> value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput__M9_tableName (string value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static AWS.Cryptography.StructuredEncryption.DecryptStructureOutput FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_DecryptStructureOutput (Dafny.Aws.Cryptography.StructuredEncryption.Types._IDecryptStructureOutput value) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput concrete = (Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput)value;
 AWS.Cryptography.StructuredEncryption.DecryptStructureOutput converted = new AWS.Cryptography.StructuredEncryption.DecryptStructureOutput();
  converted.PlaintextStructure = (AWS.Cryptography.StructuredEncryption.StructuredData) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(concrete._plaintextStructure);
  converted.ParsedHeader = (AWS.Cryptography.StructuredEncryption.ParsedHeader) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_ParsedHeader(concrete._parsedHeader);
 return converted;
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IDecryptStructureOutput ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_DecryptStructureOutput (AWS.Cryptography.StructuredEncryption.DecryptStructureOutput value) {

 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput ( ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value.PlaintextStructure) ,
 ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_ParsedHeader(value.ParsedHeader) ) ;
}
 public static AWS.Cryptography.StructuredEncryption.ParsedHeader FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_DecryptStructureOutput__M12_parsedHeader (Dafny.Aws.Cryptography.StructuredEncryption.Types._IParsedHeader value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_ParsedHeader(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IParsedHeader ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_DecryptStructureOutput__M12_parsedHeader (AWS.Cryptography.StructuredEncryption.ParsedHeader value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_ParsedHeader(value);
}
 public static AWS.Cryptography.StructuredEncryption.StructuredData FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_DecryptStructureOutput__M18_plaintextStructure (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_DecryptStructureOutput__M18_plaintextStructure (AWS.Cryptography.StructuredEncryption.StructuredData value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value);
}
 public static AWS.Cryptography.StructuredEncryption.EncryptStructureInput FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput (Dafny.Aws.Cryptography.StructuredEncryption.Types._IEncryptStructureInput value) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureInput concrete = (Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureInput)value;
 AWS.Cryptography.StructuredEncryption.EncryptStructureInput converted = new AWS.Cryptography.StructuredEncryption.EncryptStructureInput();
  converted.TableName = (string) Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(concrete._tableName);
  converted.PlaintextStructure = (AWS.Cryptography.StructuredEncryption.StructuredData) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(concrete._plaintextStructure);
  converted.CryptoSchema = (AWS.Cryptography.StructuredEncryption.CryptoSchema) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema(concrete._cryptoSchema);
  converted.Cmm = (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager) AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(concrete._cmm);
 if (concrete._algorithmSuiteId.is_Some) converted.AlgorithmSuiteId = (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId) AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(concrete._algorithmSuiteId.dtor_value);
 if (concrete._encryptionContext.is_Some) converted.EncryptionContext = (System.Collections.Generic.Dictionary<string, string>) AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(concrete._encryptionContext.dtor_value);
 return converted;
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IEncryptStructureInput ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput (AWS.Cryptography.StructuredEncryption.EncryptStructureInput value) {
 Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId> var_algorithmSuiteId =
	value.IsSetAlgorithmSuiteId() ?
 	new Wrappers_Compile.Option_Some<Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId>(AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value.AlgorithmSuiteId))
 	: new Wrappers_Compile.Option_None<Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId>();
 Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> var_encryptionContext =
	value.IsSetEncryptionContext() ?
 	new Wrappers_Compile.Option_Some<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>(AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value.EncryptionContext))
 	: new Wrappers_Compile.Option_None<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>();
 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureInput ( Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value.TableName) ,
 ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value.PlaintextStructure) ,
 ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema(value.CryptoSchema) ,
 AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value.Cmm) ,
 var_algorithmSuiteId ,
 var_encryptionContext ) ;
}
 public static AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M16_algorithmSuiteId (Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId> value) {
 return value.is_None ? (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId) null : AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M16_algorithmSuiteId (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId value) {
 return value == null ? Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId>.create_None() : Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId>.create_Some(AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId((AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId) value));
}
 public static AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M3_cmm (Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager value) {
 return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value);
}
 public static Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M3_cmm (AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager value) {
 return AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S38_CryptographicMaterialsManagerReference(value);
}
 public static AWS.Cryptography.StructuredEncryption.CryptoSchema FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M12_cryptoSchema (Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M12_cryptoSchema (AWS.Cryptography.StructuredEncryption.CryptoSchema value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema(value);
}
 public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M17_encryptionContext (Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> value) {
 return value.is_None ? (System.Collections.Generic.Dictionary<string, string>) null : AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M17_encryptionContext (System.Collections.Generic.Dictionary<string, string> value) {
 return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>>>.create_Some(AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext((System.Collections.Generic.Dictionary<string, string>) value));
}
 public static AWS.Cryptography.StructuredEncryption.StructuredData FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M18_plaintextStructure (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M18_plaintextStructure (AWS.Cryptography.StructuredEncryption.StructuredData value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value);
}
 public static string FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M9_tableName (Dafny.ISequence<char> value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput__M9_tableName (string value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static AWS.Cryptography.StructuredEncryption.EncryptStructureOutput FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_EncryptStructureOutput (Dafny.Aws.Cryptography.StructuredEncryption.Types._IEncryptStructureOutput value) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput concrete = (Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput)value;
 AWS.Cryptography.StructuredEncryption.EncryptStructureOutput converted = new AWS.Cryptography.StructuredEncryption.EncryptStructureOutput();
  converted.EncryptedStructure = (AWS.Cryptography.StructuredEncryption.StructuredData) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(concrete._encryptedStructure);
  converted.ParsedHeader = (AWS.Cryptography.StructuredEncryption.ParsedHeader) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_ParsedHeader(concrete._parsedHeader);
 return converted;
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IEncryptStructureOutput ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_EncryptStructureOutput (AWS.Cryptography.StructuredEncryption.EncryptStructureOutput value) {

 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput ( ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value.EncryptedStructure) ,
 ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_ParsedHeader(value.ParsedHeader) ) ;
}
 public static AWS.Cryptography.StructuredEncryption.StructuredData FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_EncryptStructureOutput__M18_encryptedStructure (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_EncryptStructureOutput__M18_encryptedStructure (AWS.Cryptography.StructuredEncryption.StructuredData value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value);
}
 public static AWS.Cryptography.StructuredEncryption.ParsedHeader FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_EncryptStructureOutput__M12_parsedHeader (Dafny.Aws.Cryptography.StructuredEncryption.Types._IParsedHeader value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_ParsedHeader(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IParsedHeader ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_EncryptStructureOutput__M12_parsedHeader (AWS.Cryptography.StructuredEncryption.ParsedHeader value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_ParsedHeader(value);
}
 public static AWS.Cryptography.StructuredEncryption.ParsedHeader FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_ParsedHeader (Dafny.Aws.Cryptography.StructuredEncryption.Types._IParsedHeader value) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types.ParsedHeader concrete = (Dafny.Aws.Cryptography.StructuredEncryption.Types.ParsedHeader)value;
 AWS.Cryptography.StructuredEncryption.ParsedHeader converted = new AWS.Cryptography.StructuredEncryption.ParsedHeader();
  converted.CryptoSchema = (AWS.Cryptography.StructuredEncryption.CryptoSchema) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema(concrete._cryptoSchema);
  converted.AlgorithmSuiteId = (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId) AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(concrete._algorithmSuiteId);
  converted.EncryptedDataKeys = (System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey>) AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList(concrete._encryptedDataKeys);
  converted.StoredEncryptionContext = (System.Collections.Generic.Dictionary<string, string>) AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(concrete._storedEncryptionContext);
 return converted;
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IParsedHeader ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_ParsedHeader (AWS.Cryptography.StructuredEncryption.ParsedHeader value) {

 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.ParsedHeader ( ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema(value.CryptoSchema) ,
 AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value.AlgorithmSuiteId) ,
 AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList(value.EncryptedDataKeys) ,
 AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value.StoredEncryptionContext) ) ;
}
 public static AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_ParsedHeader__M16_algorithmSuiteId (Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId value) {
 return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value);
}
 public static Dafny.Aws.Cryptography.MaterialProviders.Types._IDBEAlgorithmSuiteId ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_ParsedHeader__M16_algorithmSuiteId (AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId value) {
 return AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S19_DBEAlgorithmSuiteId(value);
}
 public static AWS.Cryptography.StructuredEncryption.CryptoSchema FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_ParsedHeader__M12_cryptoSchema (Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._ICryptoSchema ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_ParsedHeader__M12_cryptoSchema (AWS.Cryptography.StructuredEncryption.CryptoSchema value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_CryptoSchema(value);
}
 public static System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_ParsedHeader__M17_encryptedDataKeys (Dafny.ISequence<Dafny.Aws.Cryptography.MaterialProviders.Types._IEncryptedDataKey> value) {
 return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList(value);
}
 public static Dafny.ISequence<Dafny.Aws.Cryptography.MaterialProviders.Types._IEncryptedDataKey> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_ParsedHeader__M17_encryptedDataKeys (System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey> value) {
 return AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S20_EncryptedDataKeyList(value);
}
 public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_ParsedHeader__M23_storedEncryptionContext (Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>> value) {
 return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value);
}
 public static Dafny.IMap<Dafny.ISequence<byte>, Dafny.ISequence<byte>> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S12_ParsedHeader__M23_storedEncryptionContext (System.Collections.Generic.Dictionary<string, string> value) {
 return AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_N3_aws__N12_cryptography__N17_materialProviders__S17_EncryptionContext(value);
}
 public static AWS.Cryptography.StructuredEncryption.StructuredData FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData value) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData concrete = (Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)value;
 AWS.Cryptography.StructuredEncryption.StructuredData converted = new AWS.Cryptography.StructuredEncryption.StructuredData();
  converted.Content = (AWS.Cryptography.StructuredEncryption.StructuredDataContent) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_StructuredDataContent(concrete._content);
 if (concrete._attributes.is_Some) converted.Attributes = (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.StructuredDataTerminal>) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes(concrete._attributes.dtor_value);
 return converted;
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData (AWS.Cryptography.StructuredEncryption.StructuredData value) {
 Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataTerminal>> var_attributes =
	value.IsSetAttributes() ?
 	new Wrappers_Compile.Option_Some<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataTerminal>>(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes(value.Attributes))
 	: new Wrappers_Compile.Option_None<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataTerminal>>();
 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData ( ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_StructuredDataContent(value.Content) ,
 var_attributes ) ;
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.StructuredDataTerminal> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData__M10_attributes (Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataTerminal>> value) {
 return value.is_None ? (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.StructuredDataTerminal>) null : FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes(value.Extract());
}
 public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataTerminal>> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData__M10_attributes (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.StructuredDataTerminal> value) {
 return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataTerminal>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataTerminal>>.create_Some(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes((System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.StructuredDataTerminal>) value));
}
 public static AWS.Cryptography.StructuredEncryption.StructuredDataContent FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData__M7_content (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataContent value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_StructuredDataContent(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataContent ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData__M7_content (AWS.Cryptography.StructuredEncryption.StructuredDataContent value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_StructuredDataContent(value);
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.StructuredDataTerminal> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataTerminal> value) {
 return value.ItemEnumerable.ToDictionary(pair => Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_StructuredDataTerminal(pair.Cdr));
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataTerminal> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.StructuredDataTerminal> value) {
 return Dafny.Map<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataTerminal>.FromCollection(value.Select(pair =>
    new Dafny.Pair<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataTerminal>(Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(pair.Key), ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_StructuredDataTerminal(pair.Value))
));
}
 public static string FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes__M3_key (Dafny.ISequence<char> value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes__M3_key (string value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static AWS.Cryptography.StructuredEncryption.StructuredDataTerminal FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes__M5_value (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataTerminal value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_StructuredDataTerminal(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataTerminal ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S24_StructuredDataAttributes__M5_value (AWS.Cryptography.StructuredEncryption.StructuredDataTerminal value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_StructuredDataTerminal(value);
}
 public static AWS.Cryptography.StructuredEncryption.StructuredDataContent FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_StructuredDataContent (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataContent value) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataContent concrete = (Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataContent)value;
 var converted = new AWS.Cryptography.StructuredEncryption.StructuredDataContent(); if (value.is_Terminal) {
 converted.Terminal = FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_StructuredDataTerminal(concrete.dtor_Terminal);
 return converted;
} if (value.is_DataList) {
 converted.DataList = FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_StructuredDataList(concrete.dtor_DataList);
 return converted;
} if (value.is_DataMap) {
 converted.DataMap = FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S17_StructuredDataMap(concrete.dtor_DataMap);
 return converted;
}
throw new System.ArgumentException("Invalid AWS.Cryptography.StructuredEncryption.StructuredDataContent state");
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataContent ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_StructuredDataContent (AWS.Cryptography.StructuredEncryption.StructuredDataContent value) {
 if (value.IsSetTerminal()) {
 return Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataContent.create_Terminal(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_StructuredDataTerminal(value.Terminal));
} if (value.IsSetDataList()) {
 return Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataContent.create_DataList(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_StructuredDataList(value.DataList));
} if (value.IsSetDataMap()) {
 return Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataContent.create_DataMap(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S17_StructuredDataMap(value.DataMap));
}
throw new System.ArgumentException("Invalid AWS.Cryptography.StructuredEncryption.StructuredDataContent state");
}
 public static System.Collections.Generic.List<AWS.Cryptography.StructuredEncryption.StructuredData> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_StructuredDataContent__M8_DataList (Dafny.ISequence<Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData> value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_StructuredDataList(value);
}
 public static Dafny.ISequence<Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_StructuredDataContent__M8_DataList (System.Collections.Generic.List<AWS.Cryptography.StructuredEncryption.StructuredData> value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_StructuredDataList(value);
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.StructuredData> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_StructuredDataContent__M7_DataMap (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData> value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S17_StructuredDataMap(value);
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_StructuredDataContent__M7_DataMap (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.StructuredData> value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S17_StructuredDataMap(value);
}
 public static AWS.Cryptography.StructuredEncryption.StructuredDataTerminal FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_StructuredDataContent__M8_Terminal (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataTerminal value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_StructuredDataTerminal(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataTerminal ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_StructuredDataContent__M8_Terminal (AWS.Cryptography.StructuredEncryption.StructuredDataTerminal value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_StructuredDataTerminal(value);
}
 public static System.Collections.Generic.List<AWS.Cryptography.StructuredEncryption.StructuredData> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_StructuredDataList (Dafny.ISequence<Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData> value) {
 return new System.Collections.Generic.List<AWS.Cryptography.StructuredEncryption.StructuredData>(value.Elements.Select(FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData));
}
 public static Dafny.ISequence<Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_StructuredDataList (System.Collections.Generic.List<AWS.Cryptography.StructuredEncryption.StructuredData> value) {
 return Dafny.Sequence<Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData>.FromArray(value.Select(ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData).ToArray());
}
 public static AWS.Cryptography.StructuredEncryption.StructuredData FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_StructuredDataList__M6_member (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S18_StructuredDataList__M6_member (AWS.Cryptography.StructuredEncryption.StructuredData value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value);
}
 public static System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.StructuredData> FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S17_StructuredDataMap (Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData> value) {
 return value.ItemEnumerable.ToDictionary(pair => Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(pair.Cdr));
}
 public static Dafny.IMap<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S17_StructuredDataMap (System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.StructuredData> value) {
 return Dafny.Map<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData>.FromCollection(value.Select(pair =>
    new Dafny.Pair<Dafny.ISequence<char>, Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData>(Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(pair.Key), ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(pair.Value))
));
}
 public static string FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S17_StructuredDataMap__M3_key (Dafny.ISequence<char> value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S17_StructuredDataMap__M3_key (string value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static AWS.Cryptography.StructuredEncryption.StructuredData FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S17_StructuredDataMap__M5_value (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value);
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredData ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S17_StructuredDataMap__M5_value (AWS.Cryptography.StructuredEncryption.StructuredData value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_StructuredData(value);
}
 public static AWS.Cryptography.StructuredEncryption.StructuredDataTerminal FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_StructuredDataTerminal (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataTerminal value) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataTerminal concrete = (Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataTerminal)value;
 AWS.Cryptography.StructuredEncryption.StructuredDataTerminal converted = new AWS.Cryptography.StructuredEncryption.StructuredDataTerminal();
  converted.Value = (System.IO.MemoryStream) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S13_TerminalValue(concrete._value);
  converted.TypeId = (System.IO.MemoryStream) FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_TerminalTypeId(concrete._typeId);
 return converted;
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredDataTerminal ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_StructuredDataTerminal (AWS.Cryptography.StructuredEncryption.StructuredDataTerminal value) {

 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataTerminal ( ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S13_TerminalValue(value.Value) ,
 ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_TerminalTypeId(value.TypeId) ) ;
}
 public static System.IO.MemoryStream FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_StructuredDataTerminal__M6_typeId (Dafny.ISequence<byte> value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_TerminalTypeId(value);
}
 public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_StructuredDataTerminal__M6_typeId (System.IO.MemoryStream value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_TerminalTypeId(value);
}
 public static System.IO.MemoryStream FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_StructuredDataTerminal__M5_value (Dafny.ISequence<byte> value) {
 return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S13_TerminalValue(value);
}
 public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_StructuredDataTerminal__M5_value (System.IO.MemoryStream value) {
 return ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S13_TerminalValue(value);
}
 public static AWS.Cryptography.StructuredEncryption.StructuredEncryptionConfig FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S26_StructuredEncryptionConfig (Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredEncryptionConfig value) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredEncryptionConfig concrete = (Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredEncryptionConfig)value;
 AWS.Cryptography.StructuredEncryption.StructuredEncryptionConfig converted = new AWS.Cryptography.StructuredEncryption.StructuredEncryptionConfig();
 
 return converted;
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredEncryptionConfig ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S26_StructuredEncryptionConfig (AWS.Cryptography.StructuredEncryption.StructuredEncryptionConfig value) {

 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredEncryptionConfig (  ) ;
}
 public static AWS.Cryptography.StructuredEncryption.StructuredEncryptionException FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S29_StructuredEncryptionException (Dafny.Aws.Cryptography.StructuredEncryption.Types.Error_StructuredEncryptionException value) {
 return new AWS.Cryptography.StructuredEncryption.StructuredEncryptionException (
 FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S29_StructuredEncryptionException__M7_message(value._message)
 ) ;
}
 public static Dafny.Aws.Cryptography.StructuredEncryption.Types.Error_StructuredEncryptionException ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S29_StructuredEncryptionException (AWS.Cryptography.StructuredEncryption.StructuredEncryptionException value) {

 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.Error_StructuredEncryptionException (
 Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value.Message)
 ) ;
}
 public static string FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S29_StructuredEncryptionException__M7_message (Dafny.ISequence<char> value) {
 return Smithy.Api.TypeConversion.FromDafny_N6_smithy__N3_api__S6_String(value);
}
 public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S29_StructuredEncryptionException__M7_message (string value) {
 return Smithy.Api.TypeConversion.ToDafny_N6_smithy__N3_api__S6_String(value);
}
 public static System.IO.MemoryStream FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_TerminalTypeId (Dafny.ISequence<byte> value) {
 return new System.IO.MemoryStream(value.Elements);
}
 public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S14_TerminalTypeId (System.IO.MemoryStream value) {
 return Dafny.Sequence<byte>.FromArray(value.ToArray());
}
 public static System.IO.MemoryStream FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S13_TerminalValue (Dafny.ISequence<byte> value) {
 return new System.IO.MemoryStream(value.Elements);
}
 public static Dafny.ISequence<byte> ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S13_TerminalValue (System.IO.MemoryStream value) {
 return Dafny.Sequence<byte>.FromArray(value.ToArray());
}
 public static int FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S7_Version (int value) {
 return value;
}
 public static int ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S7_Version (int value) {
 return value;
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
 public static System.Exception FromDafny_CommonError(Dafny.Aws.Cryptography.StructuredEncryption.Types._IError value) {
 switch(value)
 {

 case Dafny.Aws.Cryptography.StructuredEncryption.Types.Error_StructuredEncryptionException dafnyVal:
return FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S29_StructuredEncryptionException(dafnyVal);
 case Dafny.Aws.Cryptography.StructuredEncryption.Types.Error_CollectionOfErrors dafnyVal:
 return new CollectionOfErrors(new System.Collections.Generic.List<Exception>(dafnyVal._list.Elements.Select(x => TypeConversion.FromDafny_CommonError(x))));
 case Dafny.Aws.Cryptography.StructuredEncryption.Types.Error_Opaque dafnyVal:
 return new OpaqueError(dafnyVal._obj);
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
 case CollectionOfErrors collectionOfErrors:
 return new Dafny.Aws.Cryptography.StructuredEncryption.Types.Error_CollectionOfErrors(
     Dafny.Sequence<Dafny.Aws.Cryptography.StructuredEncryption.Types._IError>
     .FromArray(
         collectionOfErrors.list.Select
             (x => TypeConversion.ToDafny_CommonError(x))
         .ToArray()
     )
 );

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
