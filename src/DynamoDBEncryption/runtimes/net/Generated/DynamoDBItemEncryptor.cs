// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using System.IO;
 using System.Collections.Generic;
 using AWS.Cryptography.DynamoDBEncryption;
 using Dafny.Aws.Cryptography.DynamoDBEncryption.Types; namespace AWS.Cryptography.DynamoDBEncryption {
 internal class DynamoDBItemEncryptor : DynamoDBItemEncryptorBase {
 internal readonly Dafny.Aws.Cryptography.DynamoDBEncryption.Types.IDynamoDBItemEncryptor _impl;
 internal DynamoDBItemEncryptor(Dafny.Aws.Cryptography.DynamoDBEncryption.Types.IDynamoDBItemEncryptor impl) { this._impl = impl; }
 protected override AWS.Cryptography.DynamoDBEncryption.EncryptItemOutput _EncryptItem(AWS.Cryptography.DynamoDBEncryption.EncryptItemInput input) {
 Dafny.Aws.Cryptography.DynamoDBEncryption.Types._IEncryptItemInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDBEncryption__S16_EncryptItemInput(input);
 Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDBEncryption.Types._IEncryptItemOutput, Dafny.Aws.Cryptography.DynamoDBEncryption.Types._IError> result = this._impl.EncryptItem(internalInput);
 if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
 return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDBEncryption__S17_EncryptItemOutput(result.dtor_value);
}
 protected override AWS.Cryptography.DynamoDBEncryption.DecryptItemOutput _DecryptItem(AWS.Cryptography.DynamoDBEncryption.DecryptItemInput input) {
 Dafny.Aws.Cryptography.DynamoDBEncryption.Types._IDecryptItemInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDBEncryption__S16_DecryptItemInput(input);
 Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDBEncryption.Types._IDecryptItemOutput, Dafny.Aws.Cryptography.DynamoDBEncryption.Types._IError> result = this._impl.DecryptItem(internalInput);
 if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
 return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDBEncryption__S17_DecryptItemOutput(result.dtor_value);
}
}
}
