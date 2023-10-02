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
  internal class DynamoDbKeyBranchKeyIdSupplier : DynamoDbKeyBranchKeyIdSupplierBase
  {
    internal readonly software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier _impl;
    internal DynamoDbKeyBranchKeyIdSupplier(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier impl) { this._impl = impl; }
    protected override AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBranchKeyIdFromDdbKeyOutput _GetBranchKeyIdFromDdbKey(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBranchKeyIdFromDdbKeyInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetBranchKeyIdFromDdbKeyInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_GetBranchKeyIdFromDdbKeyInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetBranchKeyIdFromDdbKeyOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError> result = this._impl.GetBranchKeyIdFromDdbKey(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_GetBranchKeyIdFromDdbKeyOutput(result.dtor_value);
    }
  }
}
