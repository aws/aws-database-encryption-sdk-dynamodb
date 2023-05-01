// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using System.IO;
 using System.Collections.Generic;
 using AWS.Cryptography.DynamoDbEncryption.ItemEncryptor;
 using Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types; namespace AWS.Cryptography.DynamoDbEncryption.ItemEncryptor {
 public class DynamoDbItemEncryptor {
 private readonly Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.IDynamoDbItemEncryptorClient _impl;
 public DynamoDbItemEncryptor(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.IDynamoDbItemEncryptorClient impl) {
    this._impl = impl;
}
 public Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.IDynamoDbItemEncryptorClient impl() {
    return this._impl;
}
 public DynamoDbItemEncryptor(AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorConfig input)
 {
 Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IDynamoDbItemEncryptorConfig internalInput = AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig(input);
 var result = Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.__default.DynamoDbItemEncryptor(internalInput);
 if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
 this._impl = result.dtor_value;
}
 public AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.EncryptItemOutput EncryptItem(AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.EncryptItemInput input) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IEncryptItemInput internalInput = AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S16_EncryptItemInput(input);
 Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IEncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IError> result = _impl.EncryptItem(internalInput);
 if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
 return AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S17_EncryptItemOutput(result.dtor_value);
}
 public AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.DecryptItemOutput DecryptItem(AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.DecryptItemInput input) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IDecryptItemInput internalInput = AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S16_DecryptItemInput(input);
 Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IDecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types._IError> result = _impl.DecryptItem(internalInput);
 if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
 return AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N13_itemEncryptor__S17_DecryptItemOutput(result.dtor_value);
}
}
}
