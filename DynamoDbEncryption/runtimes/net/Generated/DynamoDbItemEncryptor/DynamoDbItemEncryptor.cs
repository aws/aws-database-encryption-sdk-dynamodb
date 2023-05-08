// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using System.IO;
 using System.Collections.Generic;
 using AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor;
 using software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types; namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor {
 public class DynamoDbItemEncryptor {
 private readonly software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.IDynamoDbItemEncryptorClient _impl;
 public DynamoDbItemEncryptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.IDynamoDbItemEncryptorClient impl) {
    this._impl = impl;
}
 public software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.IDynamoDbItemEncryptorClient impl() {
    return this._impl;
}
 public DynamoDbItemEncryptor(AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DynamoDbItemEncryptorConfig input)
 {
 software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IDynamoDbItemEncryptorConfig internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig(input);
 var result = software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.__default.DynamoDbItemEncryptor(internalInput);
 if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
 this._impl = result.dtor_value;
}
 public AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.EncryptItemOutput EncryptItem(AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.EncryptItemInput input) {
 software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IEncryptItemInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S16_EncryptItemInput(input);
 Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IEncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IError> result = _impl.EncryptItem(internalInput);
 if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
 return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_EncryptItemOutput(result.dtor_value);
}
 public AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DecryptItemOutput DecryptItem(AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DecryptItemInput input) {
 software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IDecryptItemInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S16_DecryptItemInput(input);
 Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IDecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IError> result = _impl.DecryptItem(internalInput);
 if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
 return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_DecryptItemOutput(result.dtor_value);
}
}
}
