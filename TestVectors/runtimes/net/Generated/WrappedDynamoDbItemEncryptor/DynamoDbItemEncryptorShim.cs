// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.Wrapped
{
    public class DynamoDbItemEncryptorShim : software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.IDynamoDbItemEncryptorClient
    {
        public AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DynamoDbItemEncryptor _impl;
        public DynamoDbItemEncryptorShim(AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DynamoDbItemEncryptor impl)
        {
            this._impl = impl;
        }
        public Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IEncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IError> EncryptItem(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IEncryptItemInput request)
        {
            try
            {
                AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.EncryptItemInput unWrappedRequest = TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S16_EncryptItemInput(request);
                AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.EncryptItemOutput wrappedResponse =
                this._impl.EncryptItem(unWrappedRequest);
                return Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IEncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IError>.create_Success(TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_EncryptItemOutput(wrappedResponse));
            }
            catch (System.Exception ex)
            {
                return Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IEncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IError>.create_Failure(this.ConvertError(ex));
            }

        }
        public Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IDecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IError> DecryptItem(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IDecryptItemInput request)
        {
            try
            {
                AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DecryptItemInput unWrappedRequest = TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S16_DecryptItemInput(request);
                AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DecryptItemOutput wrappedResponse =
                this._impl.DecryptItem(unWrappedRequest);
                return Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IDecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IError>.create_Success(TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S17_DecryptItemOutput(wrappedResponse));
            }
            catch (System.Exception ex)
            {
                return Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IDecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IError>.create_Failure(this.ConvertError(ex));
            }

        }
        private software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IError ConvertError(System.Exception error)
        {
            switch (error.GetType().Namespace)
            {
                case "AWS.Cryptography.DbEncryptionSDK.StructuredEncryption":
                    return software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error.create_AwsCryptographyDbEncryptionSdkStructuredEncryption(
                      AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.TypeConversion.ToDafny_CommonError(error)
                    );
                case "AWS.Cryptography.DbEncryptionSDK.DynamoDb":
                    return software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error.create_AwsCryptographyDbEncryptionSdkDynamoDb(
                      AWS.Cryptography.DbEncryptionSDK.DynamoDb.TypeConversion.ToDafny_CommonError(error)
                    );
                case "AWS.Cryptography.MaterialProviders":
                    return software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error.create_AwsCryptographyMaterialProviders(
                      AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_CommonError(error)
                    );
                case "Com.Amazonaws.Dynamodb":
                    return software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error.create_ComAmazonawsDynamodb(
                      Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_CommonError(error)
                    );
            }
            switch (error)
            {
                case AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DynamoDbItemEncryptorException e:
                    return TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S30_DynamoDbItemEncryptorException(e);

                case CollectionOfErrors collectionOfErrors:
                    return new software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_CollectionOfErrors(
                      Dafny.Sequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IError>
                        .FromArray(
                          collectionOfErrors.list.Select
                              (x => TypeConversion.ToDafny_CommonError(x))
                            .ToArray()),
                      Dafny.Sequence<char>.FromString(collectionOfErrors.Message)
                    );
                default:
                    return new software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_Opaque(error);

            }
        }
    }
}
