// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Wrapped
{
    public class DynamoDbEncryptionShim : software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient
    {
        public AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryption _impl;
        public DynamoDbEncryptionShim(AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryption impl)
        {
            this._impl = impl;
        }
        public Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICreateDynamoDbEncryptionBranchKeyIdSupplierOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError> CreateDynamoDbEncryptionBranchKeyIdSupplier(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICreateDynamoDbEncryptionBranchKeyIdSupplierInput request)
        {
            try
            {
                AWS.Cryptography.DbEncryptionSDK.DynamoDb.CreateDynamoDbEncryptionBranchKeyIdSupplierInput unWrappedRequest = TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput(request);
                AWS.Cryptography.DbEncryptionSDK.DynamoDb.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput wrappedResponse =
                this._impl.CreateDynamoDbEncryptionBranchKeyIdSupplier(unWrappedRequest);
                return Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICreateDynamoDbEncryptionBranchKeyIdSupplierOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError>.create_Success(TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(wrappedResponse));
            }
            catch (System.Exception ex)
            {
                return Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ICreateDynamoDbEncryptionBranchKeyIdSupplierOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError>.create_Failure(this.ConvertError(ex));
            }

        }
        public Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError> GetEncryptedDataKeyDescription(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetEncryptedDataKeyDescriptionInput request)
        {
            try
            {
                AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetEncryptedDataKeyDescriptionInput unWrappedRequest = TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S35_GetEncryptedDataKeyDescriptionInput(request);
                AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetEncryptedDataKeyDescriptionOutput wrappedResponse =
                this._impl.GetEncryptedDataKeyDescription(unWrappedRequest);
                return Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError>.create_Success(TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S36_GetEncryptedDataKeyDescriptionOutput(wrappedResponse));
            }
            catch (System.Exception ex)
            {
                return Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError>.create_Failure(this.ConvertError(ex));
            }

        }
        public Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetNumberOfQueriesOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError> GetNumberOfQueries(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetNumberOfQueriesInput request)
        {
            try
            {
                AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetNumberOfQueriesInput unWrappedRequest = TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S23_GetNumberOfQueriesInput(request);
                AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetNumberOfQueriesOutput wrappedResponse =
                this._impl.GetNumberOfQueries(unWrappedRequest);
                return Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetNumberOfQueriesOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError>.create_Success(TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S24_GetNumberOfQueriesOutput(wrappedResponse));
            }
            catch (System.Exception ex)
            {
                return Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IGetNumberOfQueriesOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError>.create_Failure(this.ConvertError(ex));
            }

        }
        private software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError ConvertError(System.Exception error)
        {

            switch (error)
            {
                case AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryptionException e:
                    return TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S27_DynamoDbEncryptionException(e);

                case CollectionOfErrors collectionOfErrors:
                    return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_CollectionOfErrors(
                      Dafny.Sequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError>
                        .FromArray(
                          collectionOfErrors.list.Select
                              (x => TypeConversion.ToDafny_CommonError(x))
                            .ToArray()),
                      Dafny.Sequence<char>.FromString(collectionOfErrors.Message)
                    );
                default:
                    return new software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_Opaque(error);

            }
        }
    }
}
