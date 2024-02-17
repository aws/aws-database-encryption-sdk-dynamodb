// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using System.IO;
using System.Collections.Generic;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json;
using software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json
{
  public class JsonEncryptor
  {
    private readonly software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.IJsonEncryptorClient _impl;
    public JsonEncryptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.IJsonEncryptorClient impl)
    {
      this._impl = impl;
    }
    public software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.IJsonEncryptorClient impl()
    {
      return this._impl;
    }
    public JsonEncryptor(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.JsonEncryptorConfig input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IJsonEncryptorConfig internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_JsonEncryptorConfig(input);
      var result = software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.__default.JsonEncryptor(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      this._impl = result.dtor_value;
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.EncryptObjectOutput EncryptObject(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.EncryptObjectInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IEncryptObjectInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S18_EncryptObjectInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IEncryptObjectOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IError> result = _impl.EncryptObject(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_EncryptObjectOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DecryptObjectOutput DecryptObject(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DecryptObjectInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IDecryptObjectInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S18_DecryptObjectInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IDecryptObjectOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types._IError> result = _impl.DecryptObject(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N4_json__S19_DecryptObjectOutput(result.dtor_value);
    }
  }
}
