// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using System.IO;
 using System.Collections.Generic;
 using AWS.Cryptography.DynamoDbItemEncryptor;
 using Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types; namespace AWS.Cryptography.DynamoDbItemEncryptor {
 public class DynamoDbItemEncryptor {
 private readonly Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.IDynamoDbItemEncryptorClient _impl;
 public DynamoDbItemEncryptor(AWS.Cryptography.DynamoDbItemEncryptor.DynamoDbItemEncryptorConfig input)
 {
 Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types._IDynamoDbItemEncryptorConfig internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S27_DynamoDbItemEncryptorConfig(input);
 var result = Dafny.Aws.Cryptography.DynamoDbItemEncryptor.__default.DynamoDbItemEncryptor(internalInput);
 if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
 this._impl = result.dtor_value;
}
 public AWS.Cryptography.DynamoDbItemEncryptor.EncryptItemOutput EncryptItem(AWS.Cryptography.DynamoDbItemEncryptor.EncryptItemInput input) {
 Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types._IEncryptItemInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_EncryptItemInput(input);
 Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types._IEncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types._IError> result = _impl.EncryptItem(internalInput);
 if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
 return TypeConversion.FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S17_EncryptItemOutput(result.dtor_value);
}
 public AWS.Cryptography.DynamoDbItemEncryptor.DecryptItemOutput DecryptItem(AWS.Cryptography.DynamoDbItemEncryptor.DecryptItemInput input) {
 Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types._IDecryptItemInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S16_DecryptItemInput(input);
 Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types._IDecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types._IError> result = _impl.DecryptItem(internalInput);
 if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
 return TypeConversion.FromDafny_N3_aws__N12_cryptography__N21_dynamoDbItemEncryptor__S17_DecryptItemOutput(result.dtor_value);
}
}
}
