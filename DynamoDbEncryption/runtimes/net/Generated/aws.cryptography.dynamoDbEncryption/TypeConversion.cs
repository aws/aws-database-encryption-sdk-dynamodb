// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System.Linq; using System; namespace AWS.Cryptography.DynamoDbEncryption {
 public static class TypeConversion {
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
 internal static string FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S27_DynamoDbEncryptionException__M7_message (Dafny.ISequence<char> value) {
 return FromDafny_N6_smithy__N3_api__S6_String(value);
}
 internal static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S27_DynamoDbEncryptionException__M7_message (string value) {
 return ToDafny_N6_smithy__N3_api__S6_String(value);
}
 internal static string FromDafny_N6_smithy__N3_api__S6_String (Dafny.ISequence<char> value) {
 return new string(value.Elements);
}
 internal static Dafny.ISequence<char> ToDafny_N6_smithy__N3_api__S6_String (string value) {
 return Dafny.Sequence<char>.FromString(value);
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
