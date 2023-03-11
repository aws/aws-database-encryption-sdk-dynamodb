// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using System.IO;
using System.Collections.Generic;
using AWS.Cryptography.DynamoDbEncryption;
using Dafny.Aws.Cryptography.DynamoDbEncryption.Types;
namespace AWS.Cryptography.DynamoDbEncryption
{
  public class DynamoDbEncryption
  {
    private readonly Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbEncryptionMiddlewareInternalClient _impl;
    public DynamoDbEncryption(AWS.Cryptography.DynamoDbEncryption.DynamoDbEncryptionConfig input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IDynamoDbEncryptionConfig internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S24_DynamoDbEncryptionConfig(input);
      var result = Dafny.Aws.Cryptography.DynamoDbEncryption.__default.DynamoDbEncryption(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      this._impl = result.dtor_value;
    }
    public AWS.Cryptography.DynamoDbEncryption.PutItemInputTransformOutput PutItemInputTransform(AWS.Cryptography.DynamoDbEncryption.PutItemInputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IPutItemInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S26_PutItemInputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IPutItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.PutItemInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S27_PutItemInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.PutItemOutputTransformOutput PutItemOutputTransform(AWS.Cryptography.DynamoDbEncryption.PutItemOutputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IPutItemOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S27_PutItemOutputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IPutItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.PutItemOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S28_PutItemOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.GetItemInputTransformOutput GetItemInputTransform(AWS.Cryptography.DynamoDbEncryption.GetItemInputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetItemInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S26_GetItemInputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.GetItemInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S27_GetItemInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.GetItemOutputTransformOutput GetItemOutputTransform(AWS.Cryptography.DynamoDbEncryption.GetItemOutputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetItemOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S27_GetItemOutputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.GetItemOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S28_GetItemOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.BatchWriteItemInputTransformOutput BatchWriteItemInputTransform(AWS.Cryptography.DynamoDbEncryption.BatchWriteItemInputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBatchWriteItemInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S33_BatchWriteItemInputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBatchWriteItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.BatchWriteItemInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S34_BatchWriteItemInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.BatchWriteItemOutputTransformOutput BatchWriteItemOutputTransform(AWS.Cryptography.DynamoDbEncryption.BatchWriteItemOutputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBatchWriteItemOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S34_BatchWriteItemOutputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBatchWriteItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.BatchWriteItemOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S35_BatchWriteItemOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.BatchGetItemInputTransformOutput BatchGetItemInputTransform(AWS.Cryptography.DynamoDbEncryption.BatchGetItemInputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBatchGetItemInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S31_BatchGetItemInputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBatchGetItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.BatchGetItemInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S32_BatchGetItemInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.BatchGetItemOutputTransformOutput BatchGetItemOutputTransform(AWS.Cryptography.DynamoDbEncryption.BatchGetItemOutputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBatchGetItemOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S32_BatchGetItemOutputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBatchGetItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.BatchGetItemOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S33_BatchGetItemOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.ScanInputTransformOutput ScanInputTransform(AWS.Cryptography.DynamoDbEncryption.ScanInputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IScanInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S23_ScanInputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IScanInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.ScanInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S24_ScanInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.ScanOutputTransformOutput ScanOutputTransform(AWS.Cryptography.DynamoDbEncryption.ScanOutputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IScanOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S24_ScanOutputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IScanOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.ScanOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S25_ScanOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.QueryInputTransformOutput QueryInputTransform(AWS.Cryptography.DynamoDbEncryption.QueryInputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IQueryInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S24_QueryInputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IQueryInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.QueryInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S25_QueryInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.QueryOutputTransformOutput QueryOutputTransform(AWS.Cryptography.DynamoDbEncryption.QueryOutputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IQueryOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S25_QueryOutputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IQueryOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.QueryOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S26_QueryOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.TransactWriteItemsInputTransformOutput TransactWriteItemsInputTransform(AWS.Cryptography.DynamoDbEncryption.TransactWriteItemsInputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ITransactWriteItemsInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S37_TransactWriteItemsInputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ITransactWriteItemsInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.TransactWriteItemsInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S38_TransactWriteItemsInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.TransactWriteItemsOutputTransformOutput TransactWriteItemsOutputTransform(AWS.Cryptography.DynamoDbEncryption.TransactWriteItemsOutputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ITransactWriteItemsOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S38_TransactWriteItemsOutputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ITransactWriteItemsOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.TransactWriteItemsOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S39_TransactWriteItemsOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.UpdateItemInputTransformOutput UpdateItemInputTransform(AWS.Cryptography.DynamoDbEncryption.UpdateItemInputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IUpdateItemInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_UpdateItemInputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IUpdateItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.UpdateItemInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S30_UpdateItemInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.UpdateItemOutputTransformOutput UpdateItemOutputTransform(AWS.Cryptography.DynamoDbEncryption.UpdateItemOutputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IUpdateItemOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S30_UpdateItemOutputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IUpdateItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.UpdateItemOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S31_UpdateItemOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.DeleteItemInputTransformOutput DeleteItemInputTransform(AWS.Cryptography.DynamoDbEncryption.DeleteItemInputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IDeleteItemInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_DeleteItemInputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IDeleteItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.DeleteItemInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S30_DeleteItemInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.DeleteItemOutputTransformOutput DeleteItemOutputTransform(AWS.Cryptography.DynamoDbEncryption.DeleteItemOutputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IDeleteItemOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S30_DeleteItemOutputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IDeleteItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.DeleteItemOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S31_DeleteItemOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.TransactGetItemsInputTransformOutput TransactGetItemsInputTransform(AWS.Cryptography.DynamoDbEncryption.TransactGetItemsInputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ITransactGetItemsInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S35_TransactGetItemsInputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ITransactGetItemsInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.TransactGetItemsInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S36_TransactGetItemsInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.TransactGetItemsOutputTransformOutput TransactGetItemsOutputTransform(AWS.Cryptography.DynamoDbEncryption.TransactGetItemsOutputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ITransactGetItemsOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S36_TransactGetItemsOutputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._ITransactGetItemsOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.TransactGetItemsOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S37_TransactGetItemsOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.ExecuteStatementInputTransformOutput ExecuteStatementInputTransform(AWS.Cryptography.DynamoDbEncryption.ExecuteStatementInputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IExecuteStatementInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S35_ExecuteStatementInputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IExecuteStatementInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.ExecuteStatementInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S36_ExecuteStatementInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.ExecuteStatementOutputTransformOutput ExecuteStatementOutputTransform(AWS.Cryptography.DynamoDbEncryption.ExecuteStatementOutputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IExecuteStatementOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S36_ExecuteStatementOutputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IExecuteStatementOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.ExecuteStatementOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S37_ExecuteStatementOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.BatchExecuteStatementInputTransformOutput BatchExecuteStatementInputTransform(AWS.Cryptography.DynamoDbEncryption.BatchExecuteStatementInputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBatchExecuteStatementInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S40_BatchExecuteStatementInputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBatchExecuteStatementInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.BatchExecuteStatementInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S41_BatchExecuteStatementInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.BatchExecuteStatementOutputTransformOutput BatchExecuteStatementOutputTransform(AWS.Cryptography.DynamoDbEncryption.BatchExecuteStatementOutputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBatchExecuteStatementOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S41_BatchExecuteStatementOutputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IBatchExecuteStatementOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.BatchExecuteStatementOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S42_BatchExecuteStatementOutputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.ExecuteTransactionInputTransformOutput ExecuteTransactionInputTransform(AWS.Cryptography.DynamoDbEncryption.ExecuteTransactionInputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IExecuteTransactionInputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S37_ExecuteTransactionInputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IExecuteTransactionInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.ExecuteTransactionInputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S38_ExecuteTransactionInputTransformOutput(result.dtor_value);
    }
    public AWS.Cryptography.DynamoDbEncryption.ExecuteTransactionOutputTransformOutput ExecuteTransactionOutputTransform(AWS.Cryptography.DynamoDbEncryption.ExecuteTransactionOutputTransformInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IExecuteTransactionOutputTransformInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S38_ExecuteTransactionOutputTransformInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IExecuteTransactionOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = _impl.ExecuteTransactionOutputTransform(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S39_ExecuteTransactionOutputTransformOutput(result.dtor_value);
    }
  }
}
