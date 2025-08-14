// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using System.IO;
using System.Collections.Generic;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms;
using software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms
{
  public class DynamoDbEncryptionTransforms
  {
    private readonly software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.IDynamoDbEncryptionTransformsClient _impl;
    public DynamoDbEncryptionTransforms(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.IDynamoDbEncryptionTransformsClient impl)
    {
      this._impl = impl;
    }
    public software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.IDynamoDbEncryptionTransformsClient impl()
    {
      return this._impl;
    }
    public DynamoDbEncryptionTransforms(AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbTablesEncryptionConfig input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IDynamoDbTablesEncryptionConfig internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_DynamoDbTablesEncryptionConfig(input);
      var result = software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.__default.DynamoDbEncryptionTransforms(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      this._impl = result.dtor_value;
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.PutItemInputTransformOutput PutItemInputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.PutItemInputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IPutItemInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S26_PutItemInputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IPutItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.PutItemInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_PutItemInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.PutItemOutputTransformOutput PutItemOutputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.PutItemOutputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IPutItemOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_PutItemOutputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IPutItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.PutItemOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S28_PutItemOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.GetItemInputTransformOutput GetItemInputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.GetItemInputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IGetItemInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S26_GetItemInputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IGetItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.GetItemInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_GetItemInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.GetItemOutputTransformOutput GetItemOutputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.GetItemOutputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IGetItemOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_GetItemOutputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IGetItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.GetItemOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S28_GetItemOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchWriteItemInputTransformOutput BatchWriteItemInputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchWriteItemInputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchWriteItemInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S33_BatchWriteItemInputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchWriteItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.BatchWriteItemInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S34_BatchWriteItemInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchWriteItemOutputTransformOutput BatchWriteItemOutputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchWriteItemOutputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchWriteItemOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S34_BatchWriteItemOutputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchWriteItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.BatchWriteItemOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S35_BatchWriteItemOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchGetItemInputTransformOutput BatchGetItemInputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchGetItemInputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchGetItemInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S31_BatchGetItemInputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchGetItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.BatchGetItemInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S32_BatchGetItemInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchGetItemOutputTransformOutput BatchGetItemOutputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchGetItemOutputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchGetItemOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S32_BatchGetItemOutputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchGetItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.BatchGetItemOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S33_BatchGetItemOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ScanInputTransformOutput ScanInputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ScanInputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IScanInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S23_ScanInputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IScanInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.ScanInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_ScanInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ScanOutputTransformOutput ScanOutputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ScanOutputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IScanOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_ScanOutputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IScanOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.ScanOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_ScanOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.QueryInputTransformOutput QueryInputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.QueryInputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IQueryInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_QueryInputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IQueryInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.QueryInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_QueryInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.QueryOutputTransformOutput QueryOutputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.QueryOutputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IQueryOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_QueryOutputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IQueryOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.QueryOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S26_QueryOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactWriteItemsInputTransformOutput TransactWriteItemsInputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactWriteItemsInputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactWriteItemsInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_TransactWriteItemsInputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactWriteItemsInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.TransactWriteItemsInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_TransactWriteItemsInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactWriteItemsOutputTransformOutput TransactWriteItemsOutputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactWriteItemsOutputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactWriteItemsOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_TransactWriteItemsOutputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactWriteItemsOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.TransactWriteItemsOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S39_TransactWriteItemsOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.UpdateItemInputTransformOutput UpdateItemInputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.UpdateItemInputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IUpdateItemInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S29_UpdateItemInputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IUpdateItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.UpdateItemInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_UpdateItemInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.UpdateItemOutputTransformOutput UpdateItemOutputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.UpdateItemOutputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IUpdateItemOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_UpdateItemOutputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IUpdateItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.UpdateItemOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S31_UpdateItemOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DeleteItemInputTransformOutput DeleteItemInputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DeleteItemInputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IDeleteItemInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S29_DeleteItemInputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IDeleteItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.DeleteItemInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_DeleteItemInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DeleteItemOutputTransformOutput DeleteItemOutputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DeleteItemOutputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IDeleteItemOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_DeleteItemOutputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IDeleteItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.DeleteItemOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S31_DeleteItemOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactGetItemsInputTransformOutput TransactGetItemsInputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactGetItemsInputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactGetItemsInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S35_TransactGetItemsInputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactGetItemsInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.TransactGetItemsInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_TransactGetItemsInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactGetItemsOutputTransformOutput TransactGetItemsOutputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactGetItemsOutputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactGetItemsOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_TransactGetItemsOutputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactGetItemsOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.TransactGetItemsOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_TransactGetItemsOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteStatementInputTransformOutput ExecuteStatementInputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteStatementInputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteStatementInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S35_ExecuteStatementInputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.ExecuteStatementInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_ExecuteStatementInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteStatementOutputTransformOutput ExecuteStatementOutputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteStatementOutputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteStatementOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_ExecuteStatementOutputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteStatementOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.ExecuteStatementOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_ExecuteStatementOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchExecuteStatementInputTransformOutput BatchExecuteStatementInputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchExecuteStatementInputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchExecuteStatementInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S40_BatchExecuteStatementInputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.BatchExecuteStatementInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S41_BatchExecuteStatementInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchExecuteStatementOutputTransformOutput BatchExecuteStatementOutputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchExecuteStatementOutputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchExecuteStatementOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S41_BatchExecuteStatementOutputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchExecuteStatementOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.BatchExecuteStatementOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S42_BatchExecuteStatementOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteTransactionInputTransformOutput ExecuteTransactionInputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteTransactionInputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteTransactionInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_ExecuteTransactionInputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteTransactionInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.ExecuteTransactionInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_ExecuteTransactionInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteTransactionOutputTransformOutput ExecuteTransactionOutputTransform(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteTransactionOutputTransformInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteTransactionOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_ExecuteTransactionOutputTransformInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteTransactionOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.ExecuteTransactionOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S39_ExecuteTransactionOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ResolveAttributesOutput ResolveAttributes(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ResolveAttributesInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IResolveAttributesInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S22_ResolveAttributesInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IResolveAttributesOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.ResolveAttributes(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S23_ResolveAttributesOutput(result.dtor_value);
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.GetNumberOfQueriesOutput GetNumberOfQueries(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.GetNumberOfQueriesInput input)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IGetNumberOfQueriesInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S23_GetNumberOfQueriesInput(input);
      Wrappers_Compile._IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IGetNumberOfQueriesOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError> result = _impl.GetNumberOfQueries(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_GetNumberOfQueriesOutput(result.dtor_value);
    }
  }
}
