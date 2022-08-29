// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using System.IO;
 using System.Collections.Generic;
 using AWS.Cryptography.DynamodbEncryption;
 using Dafny.Aws.Cryptography.DynamodbEncryption.Types; namespace AWS.Cryptography.DynamodbEncryption {
 public class DynamoDBEncryption {
 private readonly IDynamoDBEncryptionClient _impl;
 public DynamoDBEncryption(AWS.Cryptography.DynamodbEncryption.DynamoDBEncryptionConfig input)
 {
 Dafny.Aws.Cryptography.DynamodbEncryption.Types._IDynamoDBEncryptionConfig internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S24_DynamoDBEncryptionConfig(input);
 var result = Dafny.Aws.Cryptography.DynamodbEncryption.__default.DynamoDBEncryption(internalInput);
 if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
 this._impl = result.dtor_value;
}
 public AWS.Cryptography.DynamodbEncryption.EncryptItemOutput EncryptItem(AWS.Cryptography.DynamodbEncryption.EncryptItemInput input) {
 Dafny.Aws.Cryptography.DynamodbEncryption.Types._IEncryptItemInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_EncryptItemInput(input);
 Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamodbEncryption.Types._IEncryptItemOutput, Dafny.Aws.Cryptography.DynamodbEncryption.Types._IError> result = _impl.EncryptItem(internalInput);
 if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
 return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S17_EncryptItemOutput(result.dtor_value);
}
 public AWS.Cryptography.DynamodbEncryption.DecryptItemOutput DecryptItem(AWS.Cryptography.DynamodbEncryption.DecryptItemInput input) {
 Dafny.Aws.Cryptography.DynamodbEncryption.Types._IDecryptItemInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S16_DecryptItemInput(input);
 Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamodbEncryption.Types._IDecryptItemOutput, Dafny.Aws.Cryptography.DynamodbEncryption.Types._IError> result = _impl.DecryptItem(internalInput);
 if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
 return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamodbEncryption__S17_DecryptItemOutput(result.dtor_value);
}
}
}
