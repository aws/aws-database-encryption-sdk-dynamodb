// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
// ReSharper disable RedundantUsingDirective
// ReSharper disable RedundantNameQualifier
// ReSharper disable SuggestVarOrType_SimpleTypes
using System;
using _System;
using Wrappers_Compile;

namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Wrapped
{
    internal class WrappedNativeWrapper_DynamoDbKeyBranchKeyIdSupplier : software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier
    {
        internal readonly DynamoDbKeyBranchKeyIdSupplierBase _impl;
        public WrappedNativeWrapper_DynamoDbKeyBranchKeyIdSupplier(DynamoDbKeyBranchKeyIdSupplierBase nativeImpl)
        {
            _impl = nativeImpl;
        }
        public Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetBranchKeyIdFromDdbKeyOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError> GetBranchKeyIdFromDdbKey(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetBranchKeyIdFromDdbKeyInput input)
        {
            void validateOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBranchKeyIdFromDdbKeyOutput nativeOutput)
            {
                try { nativeOutput.Validate(); }
                catch (ArgumentException e)
                {
                    var message = $"Output of {_impl}._GetBranchKeyIdFromDdbKey is invalid. {e.Message}";
                    throw new DynamoDbEncryptionException(message);
                }
            }
            AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBranchKeyIdFromDdbKeyInput nativeInput = TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S29_GetBranchKeyIdFromDdbKeyInput(input);
            try
            {
                AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBranchKeyIdFromDdbKeyOutput nativeOutput = _impl.GetBranchKeyIdFromDdbKey(nativeInput);
                _ = nativeOutput ?? throw new DynamoDbEncryptionException($"{_impl}._GetBranchKeyIdFromDdbKey returned null, should be {typeof(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBranchKeyIdFromDdbKeyOutput)}");
                validateOutput(nativeOutput);
                return Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetBranchKeyIdFromDdbKeyOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError>.create_Success(TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_GetBranchKeyIdFromDdbKeyOutput(nativeOutput));
            }
            catch (Exception e)
            {
                return Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetBranchKeyIdFromDdbKeyOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError>.create_Failure(TypeConversion.ToDafny_CommonError(e));
            }
        }
        public Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetBranchKeyIdFromDdbKeyOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError> GetBranchKeyIdFromDdbKey_k(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetBranchKeyIdFromDdbKeyInput input)
        {
            throw new DynamoDbEncryptionException("Not supported at this time.");
        }
    }
}
