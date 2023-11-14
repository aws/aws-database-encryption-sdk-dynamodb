// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using System.IO;
using System.Collections.Generic;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
using software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public class DynamoDbEncryption
  {
    private readonly software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient _impl;
    public DynamoDbEncryption(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient impl)
    {
      this._impl = impl;
    }
    public software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient impl()
    {
      return this._impl;
    }
    public DynamoDbEncryption(AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryptionConfig input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IDynamoDbEncryptionConfig internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S24_DynamoDbEncryptionConfig(input);
      var result = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DynamoDbEncryption(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      this._impl = result.dtor_value;
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput CreateDynamoDbEncryptionBranchKeyIdSupplier(AWS.Cryptography.DbEncryptionSDK.DynamoDb.CreateDynamoDbEncryptionBranchKeyIdSupplierInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICreateDynamoDbEncryptionBranchKeyIdSupplierInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICreateDynamoDbEncryptionBranchKeyIdSupplierOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError> result = _impl.CreateDynamoDbEncryptionBranchKeyIdSupplier(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(result.dtor_value);
    }
  }
}
