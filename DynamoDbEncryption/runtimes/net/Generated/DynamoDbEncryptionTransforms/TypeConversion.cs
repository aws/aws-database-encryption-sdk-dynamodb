// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System.Linq;
using System;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms
{
  public static class TypeConversion
  {
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S9_StringMap(Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S9_StringMap__M3_key(pair.Car), pair => FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S9_StringMap__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S9_StringMap(System.Collections.Generic.Dictionary<string, string> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, Dafny.ISequence<char>>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, Dafny.ISequence<char>>(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S9_StringMap__M3_key(pair.Key), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S9_StringMap__M5_value(pair.Value))
     ));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactWriteItemsInputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_TransactWriteItemsInputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactWriteItemsInputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsInputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsInputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactWriteItemsInputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactWriteItemsInputTransformInput(); converted.SdkInput = (Amazon.DynamoDBv2.Model.TransactWriteItemsRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_TransactWriteItemsInputTransformInput__M8_sdkInput(concrete._sdkInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactWriteItemsInputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_TransactWriteItemsInputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactWriteItemsInputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsInputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_TransactWriteItemsInputTransformInput__M8_sdkInput(value.SdkInput));
    }
    public static Amazon.DynamoDBv2.Model.BatchWriteItemRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S34_BatchWriteItemOutputTransformInput__M13_originalInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchWriteItemInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchWriteItemInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchWriteItemInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S34_BatchWriteItemOutputTransformInput__M13_originalInput(Amazon.DynamoDBv2.Model.BatchWriteItemRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchWriteItemInput(value);
    }
    public static Amazon.DynamoDBv2.Model.TransactGetItemsRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_TransactGetItemsOutputTransformInput__M13_originalInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItemsInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactGetItemsInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItemsInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_TransactGetItemsOutputTransformInput__M13_originalInput(Amazon.DynamoDBv2.Model.TransactGetItemsRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactGetItemsInput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchExecuteStatementOutputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S41_BatchExecuteStatementOutputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchExecuteStatementOutputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchExecuteStatementOutputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchExecuteStatementOutputTransformInput(); converted.SdkOutput = (Amazon.DynamoDBv2.Model.BatchExecuteStatementResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S41_BatchExecuteStatementOutputTransformInput__M9_sdkOutput(concrete._sdkOutput);
      converted.OriginalInput = (Amazon.DynamoDBv2.Model.BatchExecuteStatementRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S41_BatchExecuteStatementOutputTransformInput__M13_originalInput(concrete._originalInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchExecuteStatementOutputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S41_BatchExecuteStatementOutputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchExecuteStatementOutputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S41_BatchExecuteStatementOutputTransformInput__M9_sdkOutput(value.SdkOutput), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S41_BatchExecuteStatementOutputTransformInput__M13_originalInput(value.OriginalInput));
    }
    public static Amazon.DynamoDBv2.Model.PutItemRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S26_PutItemInputTransformInput__M8_sdkInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IPutItemInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IPutItemInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S26_PutItemInputTransformInput__M8_sdkInput(Amazon.DynamoDBv2.Model.PutItemRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput(value);
    }
    public static Amazon.DynamoDBv2.Model.UpdateItemRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_UpdateItemInputTransformOutput__M16_transformedInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IUpdateItemInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IUpdateItemInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_UpdateItemInputTransformOutput__M16_transformedInput(Amazon.DynamoDBv2.Model.UpdateItemRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteStatementInputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_ExecuteStatementInputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteStatementInputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteStatementInputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteStatementInputTransformOutput(); converted.TransformedInput = (Amazon.DynamoDBv2.Model.ExecuteStatementRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_ExecuteStatementInputTransformOutput__M16_transformedInput(concrete._transformedInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteStatementInputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_ExecuteStatementInputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteStatementInputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_ExecuteStatementInputTransformOutput__M16_transformedInput(value.TransformedInput));
    }
    public static Amazon.DynamoDBv2.Model.TransactWriteItemsRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_TransactWriteItemsOutputTransformInput__M13_originalInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItemsInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItemsInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_TransactWriteItemsOutputTransformInput__M13_originalInput(Amazon.DynamoDBv2.Model.TransactWriteItemsRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput(value);
    }
    public static Amazon.DynamoDBv2.Model.ScanRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_ScanInputTransformOutput__M16_transformedInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IScanInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IScanInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_ScanInputTransformOutput__M16_transformedInput(Amazon.DynamoDBv2.Model.ScanRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput(value);
    }
    public static Amazon.DynamoDBv2.Model.DeleteItemResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S31_DeleteItemOutputTransformOutput__M17_transformedOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IDeleteItemOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_DeleteItemOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IDeleteItemOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S31_DeleteItemOutputTransformOutput__M17_transformedOutput(Amazon.DynamoDBv2.Model.DeleteItemResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_DeleteItemOutput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.QueryInputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_QueryInputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IQueryInputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryInputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryInputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.QueryInputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.QueryInputTransformOutput(); converted.TransformedInput = (Amazon.DynamoDBv2.Model.QueryRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_QueryInputTransformOutput__M16_transformedInput(concrete._transformedInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IQueryInputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_QueryInputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.QueryInputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryInputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_QueryInputTransformOutput__M16_transformedInput(value.TransformedInput));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.QueryOutputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S26_QueryOutputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IQueryOutputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryOutputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryOutputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.QueryOutputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.QueryOutputTransformOutput(); converted.TransformedOutput = (Amazon.DynamoDBv2.Model.QueryResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S26_QueryOutputTransformOutput__M17_transformedOutput(concrete._transformedOutput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IQueryOutputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S26_QueryOutputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.QueryOutputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryOutputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S26_QueryOutputTransformOutput__M17_transformedOutput(value.TransformedOutput));
    }
    public static Amazon.DynamoDBv2.Model.PutItemResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S28_PutItemOutputTransformOutput__M17_transformedOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IPutItemOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_PutItemOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IPutItemOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S28_PutItemOutputTransformOutput__M17_transformedOutput(Amazon.DynamoDBv2.Model.PutItemResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_PutItemOutput(value);
    }
    public static Amazon.DynamoDBv2.Model.PutItemResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_PutItemOutputTransformInput__M9_sdkOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IPutItemOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_PutItemOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IPutItemOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_PutItemOutputTransformInput__M9_sdkOutput(Amazon.DynamoDBv2.Model.PutItemResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_PutItemOutput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchGetItemInputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S32_BatchGetItemInputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchGetItemInputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemInputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemInputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchGetItemInputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchGetItemInputTransformOutput(); converted.TransformedInput = (Amazon.DynamoDBv2.Model.BatchGetItemRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S32_BatchGetItemInputTransformOutput__M16_transformedInput(concrete._transformedInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchGetItemInputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S32_BatchGetItemInputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchGetItemInputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemInputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S32_BatchGetItemInputTransformOutput__M16_transformedInput(value.TransformedInput));
    }
    public static AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredEncryption FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S29_StructuredEncryptionReference(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.IStructuredEncryptionClient value)
    {
      if (value is software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.IStructuredEncryptionClient dafnyValue)
      {
        return new AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredEncryption(dafnyValue);
      }
      throw new System.ArgumentException("Custom implementations of AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredEncryption are not supported yet");
    }
    public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.IStructuredEncryptionClient ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S29_StructuredEncryptionReference(AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredEncryption value)
    {
      if (value is AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredEncryption nativeValue)
      {
        return nativeValue.impl();
      }
      throw new System.ArgumentException("Custom implementations of AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredEncryption are not supported yet");
    }
    public static Amazon.DynamoDBv2.Model.ExecuteTransactionRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_ExecuteTransactionInputTransformInput__M8_sdkInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteTransactionInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ExecuteTransactionInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteTransactionInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_ExecuteTransactionInputTransformInput__M8_sdkInput(Amazon.DynamoDBv2.Model.ExecuteTransactionRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ExecuteTransactionInput(value);
    }
    public static Amazon.DynamoDBv2.Model.ExecuteStatementResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_ExecuteStatementOutputTransformOutput__M17_transformedOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteStatementOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExecuteStatementOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteStatementOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_ExecuteStatementOutputTransformOutput__M17_transformedOutput(Amazon.DynamoDBv2.Model.ExecuteStatementResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExecuteStatementOutput(value);
    }
    public static AWS.Cryptography.MaterialProviders.AwsCryptographicMaterialProviders FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S42_AwsCryptographicMaterialProvidersReference(software.amazon.cryptography.materialproviders.internaldafny.types.IAwsCryptographicMaterialProvidersClient value)
    {
      if (value is software.amazon.cryptography.materialproviders.internaldafny.types.IAwsCryptographicMaterialProvidersClient dafnyValue)
      {
        return new AWS.Cryptography.MaterialProviders.AwsCryptographicMaterialProviders(dafnyValue);
      }
      throw new System.ArgumentException("Custom implementations of AWS.Cryptography.MaterialProviders.AwsCryptographicMaterialProviders are not supported yet");
    }
    public static software.amazon.cryptography.materialproviders.internaldafny.types.IAwsCryptographicMaterialProvidersClient ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S42_AwsCryptographicMaterialProvidersReference(AWS.Cryptography.MaterialProviders.AwsCryptographicMaterialProviders value)
    {
      if (value is AWS.Cryptography.MaterialProviders.AwsCryptographicMaterialProviders nativeValue)
      {
        return nativeValue.impl();
      }
      throw new System.ArgumentException("Custom implementations of AWS.Cryptography.MaterialProviders.AwsCryptographicMaterialProviders are not supported yet");
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchGetItemInputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S31_BatchGetItemInputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchGetItemInputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemInputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemInputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchGetItemInputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchGetItemInputTransformInput(); converted.SdkInput = (Amazon.DynamoDBv2.Model.BatchGetItemRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S31_BatchGetItemInputTransformInput__M8_sdkInput(concrete._sdkInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchGetItemInputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S31_BatchGetItemInputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchGetItemInputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemInputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S31_BatchGetItemInputTransformInput__M8_sdkInput(value.SdkInput));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchExecuteStatementOutputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S42_BatchExecuteStatementOutputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchExecuteStatementOutputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchExecuteStatementOutputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchExecuteStatementOutputTransformOutput(); converted.TransformedOutput = (Amazon.DynamoDBv2.Model.BatchExecuteStatementResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S42_BatchExecuteStatementOutputTransformOutput__M17_transformedOutput(concrete._transformedOutput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchExecuteStatementOutputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S42_BatchExecuteStatementOutputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchExecuteStatementOutputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S42_BatchExecuteStatementOutputTransformOutput__M17_transformedOutput(value.TransformedOutput));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DynamoDbItemEncryptor FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_DynamoDbItemEncryptorReference(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.IDynamoDbItemEncryptorClient value)
    {
      if (value is software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.IDynamoDbItemEncryptorClient dafnyValue)
      {
        return new AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DynamoDbItemEncryptor(dafnyValue);
      }
      throw new System.ArgumentException("Custom implementations of AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DynamoDbItemEncryptor are not supported yet");
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.IDynamoDbItemEncryptorClient ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_DynamoDbItemEncryptorReference(AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DynamoDbItemEncryptor value)
    {
      if (value is AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DynamoDbItemEncryptor nativeValue)
      {
        return nativeValue.impl();
      }
      throw new System.ArgumentException("Custom implementations of AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.DynamoDbItemEncryptor are not supported yet");
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchExecuteStatementInputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S40_BatchExecuteStatementInputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchExecuteStatementInputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchExecuteStatementInputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchExecuteStatementInputTransformInput(); converted.SdkInput = (Amazon.DynamoDBv2.Model.BatchExecuteStatementRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S40_BatchExecuteStatementInputTransformInput__M8_sdkInput(concrete._sdkInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchExecuteStatementInputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S40_BatchExecuteStatementInputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchExecuteStatementInputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S40_BatchExecuteStatementInputTransformInput__M8_sdkInput(value.SdkInput));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DeleteItemOutputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_DeleteItemOutputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IDeleteItemOutputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemOutputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemOutputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DeleteItemOutputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DeleteItemOutputTransformInput(); converted.SdkOutput = (Amazon.DynamoDBv2.Model.DeleteItemResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_DeleteItemOutputTransformInput__M9_sdkOutput(concrete._sdkOutput);
      converted.OriginalInput = (Amazon.DynamoDBv2.Model.DeleteItemRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_DeleteItemOutputTransformInput__M13_originalInput(concrete._originalInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IDeleteItemOutputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_DeleteItemOutputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DeleteItemOutputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemOutputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_DeleteItemOutputTransformInput__M9_sdkOutput(value.SdkOutput), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_DeleteItemOutputTransformInput__M13_originalInput(value.OriginalInput));
    }
    public static Amazon.DynamoDBv2.Model.ExecuteStatementResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_ExecuteStatementOutputTransformInput__M9_sdkOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteStatementOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExecuteStatementOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteStatementOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_ExecuteStatementOutputTransformInput__M9_sdkOutput(Amazon.DynamoDBv2.Model.ExecuteStatementResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExecuteStatementOutput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchGetItemOutputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S33_BatchGetItemOutputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchGetItemOutputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchGetItemOutputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchGetItemOutputTransformOutput(); converted.TransformedOutput = (Amazon.DynamoDBv2.Model.BatchGetItemResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S33_BatchGetItemOutputTransformOutput__M17_transformedOutput(concrete._transformedOutput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchGetItemOutputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S33_BatchGetItemOutputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchGetItemOutputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S33_BatchGetItemOutputTransformOutput__M17_transformedOutput(value.TransformedOutput));
    }
    public static Amazon.DynamoDBv2.Model.PutItemRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_PutItemOutputTransformInput__M13_originalInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IPutItemInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IPutItemInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_PutItemOutputTransformInput__M13_originalInput(Amazon.DynamoDBv2.Model.PutItemRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput(value);
    }
    public static Amazon.DynamoDBv2.Model.ExecuteTransactionResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S39_ExecuteTransactionOutputTransformOutput__M17_transformedOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteTransactionOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ExecuteTransactionOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteTransactionOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S39_ExecuteTransactionOutputTransformOutput__M17_transformedOutput(Amazon.DynamoDBv2.Model.ExecuteTransactionResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ExecuteTransactionOutput(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S9_StringMap__M5_value(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S9_StringMap__M5_value(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Amazon.DynamoDBv2.Model.GetItemResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S28_GetItemOutputTransformOutput__M17_transformedOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IGetItemOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_GetItemOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IGetItemOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S28_GetItemOutputTransformOutput__M17_transformedOutput(Amazon.DynamoDBv2.Model.GetItemResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_GetItemOutput(value);
    }
    public static Amazon.DynamoDBv2.Model.BatchGetItemRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S31_BatchGetItemInputTransformInput__M8_sdkInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchGetItemInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_BatchGetItemInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchGetItemInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S31_BatchGetItemInputTransformInput__M8_sdkInput(Amazon.DynamoDBv2.Model.BatchGetItemRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_BatchGetItemInput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchWriteItemOutputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S35_BatchWriteItemOutputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchWriteItemOutputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchWriteItemOutputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchWriteItemOutputTransformOutput(); converted.TransformedOutput = (Amazon.DynamoDBv2.Model.BatchWriteItemResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S35_BatchWriteItemOutputTransformOutput__M17_transformedOutput(concrete._transformedOutput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchWriteItemOutputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S35_BatchWriteItemOutputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchWriteItemOutputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S35_BatchWriteItemOutputTransformOutput__M17_transformedOutput(value.TransformedOutput));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.PutItemInputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S26_PutItemInputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IPutItemInputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemInputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemInputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.PutItemInputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.PutItemInputTransformInput(); converted.SdkInput = (Amazon.DynamoDBv2.Model.PutItemRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S26_PutItemInputTransformInput__M8_sdkInput(concrete._sdkInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IPutItemInputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S26_PutItemInputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.PutItemInputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemInputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S26_PutItemInputTransformInput__M8_sdkInput(value.SdkInput));
    }
    public static Amazon.DynamoDBv2.Model.PutItemRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_PutItemInputTransformOutput__M16_transformedInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IPutItemInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IPutItemInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_PutItemInputTransformOutput__M16_transformedInput(Amazon.DynamoDBv2.Model.PutItemRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput(value);
    }
    public static Amazon.DynamoDBv2.Model.ScanRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_ScanOutputTransformInput__M13_originalInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IScanInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IScanInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_ScanOutputTransformInput__M13_originalInput(Amazon.DynamoDBv2.Model.ScanRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput(value);
    }
    public static Amazon.DynamoDBv2.Model.QueryResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S26_QueryOutputTransformOutput__M17_transformedOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IQueryOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IQueryOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S26_QueryOutputTransformOutput__M17_transformedOutput(Amazon.DynamoDBv2.Model.QueryResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S22_ResolveAttributesInput__M9_TableName(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S22_ResolveAttributesInput__M9_TableName(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(value);
    }
    public static Amazon.DynamoDBv2.Model.BatchWriteItemRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S34_BatchWriteItemInputTransformOutput__M16_transformedInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchWriteItemInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchWriteItemInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchWriteItemInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S34_BatchWriteItemInputTransformOutput__M16_transformedInput(Amazon.DynamoDBv2.Model.BatchWriteItemRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchWriteItemInput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchGetItemOutputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S32_BatchGetItemOutputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchGetItemOutputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchGetItemOutputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchGetItemOutputTransformInput(); converted.SdkOutput = (Amazon.DynamoDBv2.Model.BatchGetItemResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S32_BatchGetItemOutputTransformInput__M9_sdkOutput(concrete._sdkOutput);
      converted.OriginalInput = (Amazon.DynamoDBv2.Model.BatchGetItemRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S32_BatchGetItemOutputTransformInput__M13_originalInput(concrete._originalInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchGetItemOutputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S32_BatchGetItemOutputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchGetItemOutputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S32_BatchGetItemOutputTransformInput__M9_sdkOutput(value.SdkOutput), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S32_BatchGetItemOutputTransformInput__M13_originalInput(value.OriginalInput));
    }
    public static Amazon.DynamoDBv2.Model.DeleteItemRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_DeleteItemInputTransformOutput__M16_transformedInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IDeleteItemInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IDeleteItemInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_DeleteItemInputTransformOutput__M16_transformedInput(Amazon.DynamoDBv2.Model.DeleteItemRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput(value);
    }
    public static Amazon.DynamoDBv2.Model.BatchExecuteStatementRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S41_BatchExecuteStatementInputTransformOutput__M16_transformedInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchExecuteStatementInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_BatchExecuteStatementInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchExecuteStatementInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S41_BatchExecuteStatementInputTransformOutput__M16_transformedInput(Amazon.DynamoDBv2.Model.BatchExecuteStatementRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_BatchExecuteStatementInput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ScanOutputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_ScanOutputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IScanOutputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanOutputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanOutputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ScanOutputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ScanOutputTransformOutput(); converted.TransformedOutput = (Amazon.DynamoDBv2.Model.ScanResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_ScanOutputTransformOutput__M17_transformedOutput(concrete._transformedOutput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IScanOutputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_ScanOutputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ScanOutputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanOutputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_ScanOutputTransformOutput__M17_transformedOutput(value.TransformedOutput));
    }
    public static Amazon.DynamoDBv2.Model.BatchWriteItemResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S34_BatchWriteItemOutputTransformInput__M9_sdkOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchWriteItemOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BatchWriteItemOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchWriteItemOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S34_BatchWriteItemOutputTransformInput__M9_sdkOutput(Amazon.DynamoDBv2.Model.BatchWriteItemResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BatchWriteItemOutput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactWriteItemsInputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_TransactWriteItemsInputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactWriteItemsInputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsInputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsInputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactWriteItemsInputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactWriteItemsInputTransformOutput(); converted.TransformedInput = (Amazon.DynamoDBv2.Model.TransactWriteItemsRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_TransactWriteItemsInputTransformOutput__M16_transformedInput(concrete._transformedInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactWriteItemsInputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_TransactWriteItemsInputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactWriteItemsInputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsInputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_TransactWriteItemsInputTransformOutput__M16_transformedInput(value.TransformedInput));
    }
    public static Amazon.DynamoDBv2.Model.ExecuteStatementRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_ExecuteStatementOutputTransformInput__M13_originalInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteStatementInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteStatementInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_ExecuteStatementOutputTransformInput__M13_originalInput(Amazon.DynamoDBv2.Model.ExecuteStatementRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteStatementOutputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_ExecuteStatementOutputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteStatementOutputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteStatementOutputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteStatementOutputTransformOutput(); converted.TransformedOutput = (Amazon.DynamoDBv2.Model.ExecuteStatementResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_ExecuteStatementOutputTransformOutput__M17_transformedOutput(concrete._transformedOutput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteStatementOutputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_ExecuteStatementOutputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteStatementOutputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_ExecuteStatementOutputTransformOutput__M17_transformedOutput(value.TransformedOutput));
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S9_StringMap__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S9_StringMap__M3_key(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.UpdateItemInputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S29_UpdateItemInputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IUpdateItemInputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemInputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemInputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.UpdateItemInputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.UpdateItemInputTransformInput(); converted.SdkInput = (Amazon.DynamoDBv2.Model.UpdateItemRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S29_UpdateItemInputTransformInput__M8_sdkInput(concrete._sdkInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IUpdateItemInputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S29_UpdateItemInputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.UpdateItemInputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemInputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S29_UpdateItemInputTransformInput__M8_sdkInput(value.SdkInput));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S22_ResolveAttributesInput__M4_Item(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S22_ResolveAttributesInput__M4_Item(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    public static Amazon.DynamoDBv2.Model.BatchExecuteStatementRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S41_BatchExecuteStatementOutputTransformInput__M13_originalInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchExecuteStatementInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_BatchExecuteStatementInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchExecuteStatementInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S41_BatchExecuteStatementOutputTransformInput__M13_originalInput(Amazon.DynamoDBv2.Model.BatchExecuteStatementRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_BatchExecuteStatementInput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteStatementInputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S35_ExecuteStatementInputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteStatementInputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteStatementInputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteStatementInputTransformInput(); converted.SdkInput = (Amazon.DynamoDBv2.Model.ExecuteStatementRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S35_ExecuteStatementInputTransformInput__M8_sdkInput(concrete._sdkInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteStatementInputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S35_ExecuteStatementInputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteStatementInputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S35_ExecuteStatementInputTransformInput__M8_sdkInput(value.SdkInput));
    }
    public static Amazon.DynamoDBv2.Model.GetItemRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S26_GetItemInputTransformInput__M8_sdkInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IGetItemInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IGetItemInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S26_GetItemInputTransformInput__M8_sdkInput(Amazon.DynamoDBv2.Model.GetItemRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactGetItemsInputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_TransactGetItemsInputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactGetItemsInputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsInputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsInputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactGetItemsInputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactGetItemsInputTransformOutput(); converted.TransformedInput = (Amazon.DynamoDBv2.Model.TransactGetItemsRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_TransactGetItemsInputTransformOutput__M16_transformedInput(concrete._transformedInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactGetItemsInputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_TransactGetItemsInputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactGetItemsInputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsInputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_TransactGetItemsInputTransformOutput__M16_transformedInput(value.TransformedInput));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteTransactionInputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_ExecuteTransactionInputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteTransactionInputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteTransactionInputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteTransactionInputTransformOutput(); converted.TransformedInput = (Amazon.DynamoDBv2.Model.ExecuteTransactionRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_ExecuteTransactionInputTransformOutput__M16_transformedInput(concrete._transformedInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteTransactionInputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_ExecuteTransactionInputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteTransactionInputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_ExecuteTransactionInputTransformOutput__M16_transformedInput(value.TransformedInput));
    }
    public static Amazon.DynamoDBv2.Model.DeleteItemResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_DeleteItemOutputTransformInput__M9_sdkOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IDeleteItemOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_DeleteItemOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IDeleteItemOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_DeleteItemOutputTransformInput__M9_sdkOutput(Amazon.DynamoDBv2.Model.DeleteItemResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_DeleteItemOutput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchWriteItemInputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S33_BatchWriteItemInputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchWriteItemInputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchWriteItemInputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchWriteItemInputTransformInput(); converted.SdkInput = (Amazon.DynamoDBv2.Model.BatchWriteItemRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S33_BatchWriteItemInputTransformInput__M8_sdkInput(concrete._sdkInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchWriteItemInputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S33_BatchWriteItemInputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchWriteItemInputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S33_BatchWriteItemInputTransformInput__M8_sdkInput(value.SdkInput));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactGetItemsInputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S35_TransactGetItemsInputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactGetItemsInputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsInputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsInputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactGetItemsInputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactGetItemsInputTransformInput(); converted.SdkInput = (Amazon.DynamoDBv2.Model.TransactGetItemsRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S35_TransactGetItemsInputTransformInput__M8_sdkInput(concrete._sdkInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactGetItemsInputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S35_TransactGetItemsInputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactGetItemsInputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsInputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S35_TransactGetItemsInputTransformInput__M8_sdkInput(value.SdkInput));
    }
    public static Amazon.DynamoDBv2.Model.BatchExecuteStatementResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S41_BatchExecuteStatementOutputTransformInput__M9_sdkOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchExecuteStatementOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_BatchExecuteStatementOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchExecuteStatementOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S41_BatchExecuteStatementOutputTransformInput__M9_sdkOutput(Amazon.DynamoDBv2.Model.BatchExecuteStatementResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_BatchExecuteStatementOutput(value);
    }
    public static Amazon.DynamoDBv2.Model.QueryRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_QueryInputTransformInput__M8_sdkInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IQueryInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IQueryInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_QueryInputTransformInput__M8_sdkInput(Amazon.DynamoDBv2.Model.QueryRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ScanInputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S23_ScanInputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IScanInputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanInputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanInputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ScanInputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ScanInputTransformInput(); converted.SdkInput = (Amazon.DynamoDBv2.Model.ScanRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S23_ScanInputTransformInput__M8_sdkInput(concrete._sdkInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IScanInputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S23_ScanInputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ScanInputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanInputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S23_ScanInputTransformInput__M8_sdkInput(value.SdkInput));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.GetItemInputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_GetItemInputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IGetItemInputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemInputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemInputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.GetItemInputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.GetItemInputTransformOutput(); converted.TransformedInput = (Amazon.DynamoDBv2.Model.GetItemRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_GetItemInputTransformOutput__M16_transformedInput(concrete._transformedInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IGetItemInputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_GetItemInputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.GetItemInputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemInputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_GetItemInputTransformOutput__M16_transformedInput(value.TransformedInput));
    }
    public static Amazon.DynamoDBv2.Model.ScanResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_ScanOutputTransformOutput__M17_transformedOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IScanOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IScanOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_ScanOutputTransformOutput__M17_transformedOutput(Amazon.DynamoDBv2.Model.ScanResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput(value);
    }
    public static Amazon.DynamoDBv2.Model.DeleteItemRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_DeleteItemOutputTransformInput__M13_originalInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IDeleteItemInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IDeleteItemInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_DeleteItemOutputTransformInput__M13_originalInput(Amazon.DynamoDBv2.Model.DeleteItemRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.PutItemOutputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S28_PutItemOutputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IPutItemOutputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemOutputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemOutputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.PutItemOutputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.PutItemOutputTransformOutput(); converted.TransformedOutput = (Amazon.DynamoDBv2.Model.PutItemResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S28_PutItemOutputTransformOutput__M17_transformedOutput(concrete._transformedOutput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IPutItemOutputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S28_PutItemOutputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.PutItemOutputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemOutputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S28_PutItemOutputTransformOutput__M17_transformedOutput(value.TransformedOutput));
    }
    public static Amazon.DynamoDBv2.Model.BatchGetItemResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S33_BatchGetItemOutputTransformOutput__M17_transformedOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchGetItemOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetItemOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchGetItemOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S33_BatchGetItemOutputTransformOutput__M17_transformedOutput(Amazon.DynamoDBv2.Model.BatchGetItemResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetItemOutput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.GetItemOutputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S28_GetItemOutputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IGetItemOutputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.GetItemOutputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.GetItemOutputTransformOutput(); converted.TransformedOutput = (Amazon.DynamoDBv2.Model.GetItemResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S28_GetItemOutputTransformOutput__M17_transformedOutput(concrete._transformedOutput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IGetItemOutputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S28_GetItemOutputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.GetItemOutputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S28_GetItemOutputTransformOutput__M17_transformedOutput(value.TransformedOutput));
    }
    public static Amazon.DynamoDBv2.Model.DeleteItemRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S29_DeleteItemInputTransformInput__M8_sdkInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IDeleteItemInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IDeleteItemInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S29_DeleteItemInputTransformInput__M8_sdkInput(Amazon.DynamoDBv2.Model.DeleteItemRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput(value);
    }
    public static Amazon.DynamoDBv2.Model.TransactGetItemsResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_TransactGetItemsOutputTransformOutput__M17_transformedOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItemsOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_TransactGetItemsOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItemsOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_TransactGetItemsOutputTransformOutput__M17_transformedOutput(Amazon.DynamoDBv2.Model.TransactGetItemsResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_TransactGetItemsOutput(value);
    }
    public static Amazon.DynamoDBv2.Model.BatchGetItemRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S32_BatchGetItemInputTransformOutput__M16_transformedInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchGetItemInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_BatchGetItemInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchGetItemInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S32_BatchGetItemInputTransformOutput__M16_transformedInput(Amazon.DynamoDBv2.Model.BatchGetItemRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_BatchGetItemInput(value);
    }
    public static Amazon.DynamoDBv2.Model.QueryRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_QueryOutputTransformInput__M13_originalInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IQueryInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IQueryInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_QueryOutputTransformInput__M13_originalInput(Amazon.DynamoDBv2.Model.QueryRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput(value);
    }
    public static Amazon.DynamoDBv2.Model.BatchWriteItemResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S35_BatchWriteItemOutputTransformOutput__M17_transformedOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchWriteItemOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BatchWriteItemOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchWriteItemOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S35_BatchWriteItemOutputTransformOutput__M17_transformedOutput(Amazon.DynamoDBv2.Model.BatchWriteItemResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BatchWriteItemOutput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactWriteItemsOutputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_TransactWriteItemsOutputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactWriteItemsOutputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsOutputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsOutputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactWriteItemsOutputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactWriteItemsOutputTransformInput(); converted.SdkOutput = (Amazon.DynamoDBv2.Model.TransactWriteItemsResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_TransactWriteItemsOutputTransformInput__M9_sdkOutput(concrete._sdkOutput);
      converted.OriginalInput = (Amazon.DynamoDBv2.Model.TransactWriteItemsRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_TransactWriteItemsOutputTransformInput__M13_originalInput(concrete._originalInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactWriteItemsOutputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_TransactWriteItemsOutputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactWriteItemsOutputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsOutputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_TransactWriteItemsOutputTransformInput__M9_sdkOutput(value.SdkOutput), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_TransactWriteItemsOutputTransformInput__M13_originalInput(value.OriginalInput));
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S23_ResolveAttributesOutput__M15_CompoundBeacons(Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S9_StringMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S23_ResolveAttributesOutput__M15_CompoundBeacons(System.Collections.Generic.Dictionary<string, string> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S9_StringMap(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.UpdateItemInputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_UpdateItemInputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IUpdateItemInputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemInputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemInputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.UpdateItemInputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.UpdateItemInputTransformOutput(); converted.TransformedInput = (Amazon.DynamoDBv2.Model.UpdateItemRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_UpdateItemInputTransformOutput__M16_transformedInput(concrete._transformedInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IUpdateItemInputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_UpdateItemInputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.UpdateItemInputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemInputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_UpdateItemInputTransformOutput__M16_transformedInput(value.TransformedInput));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.PutItemOutputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_PutItemOutputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IPutItemOutputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemOutputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemOutputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.PutItemOutputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.PutItemOutputTransformInput(); converted.SdkOutput = (Amazon.DynamoDBv2.Model.PutItemResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_PutItemOutputTransformInput__M9_sdkOutput(concrete._sdkOutput);
      converted.OriginalInput = (Amazon.DynamoDBv2.Model.PutItemRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_PutItemOutputTransformInput__M13_originalInput(concrete._originalInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IPutItemOutputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_PutItemOutputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.PutItemOutputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemOutputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_PutItemOutputTransformInput__M9_sdkOutput(value.SdkOutput), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_PutItemOutputTransformInput__M13_originalInput(value.OriginalInput));
    }
    public static Amazon.DynamoDBv2.Model.UpdateItemResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_UpdateItemOutputTransformInput__M9_sdkOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IUpdateItemOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateItemOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IUpdateItemOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_UpdateItemOutputTransformInput__M9_sdkOutput(Amazon.DynamoDBv2.Model.UpdateItemResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateItemOutput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryption FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_DynamoDbEncryptionReference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient value)
    {
      if (value is software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient dafnyValue)
      {
        return new AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryption(dafnyValue);
      }
      throw new System.ArgumentException("Custom implementations of AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryption are not supported yet");
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_DynamoDbEncryptionReference(AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryption value)
    {
      if (value is AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryption nativeValue)
      {
        return nativeValue.impl();
      }
      throw new System.ArgumentException("Custom implementations of AWS.Cryptography.DbEncryptionSDK.DynamoDb.DynamoDbEncryption are not supported yet");
    }
    public static Amazon.DynamoDBv2.Model.ScanResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_ScanOutputTransformInput__M9_sdkOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IScanOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IScanOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_ScanOutputTransformInput__M9_sdkOutput(Amazon.DynamoDBv2.Model.ScanResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactGetItemsOutputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_TransactGetItemsOutputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactGetItemsOutputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsOutputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsOutputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactGetItemsOutputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactGetItemsOutputTransformInput(); converted.SdkOutput = (Amazon.DynamoDBv2.Model.TransactGetItemsResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_TransactGetItemsOutputTransformInput__M9_sdkOutput(concrete._sdkOutput);
      converted.OriginalInput = (Amazon.DynamoDBv2.Model.TransactGetItemsRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_TransactGetItemsOutputTransformInput__M13_originalInput(concrete._originalInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactGetItemsOutputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_TransactGetItemsOutputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactGetItemsOutputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsOutputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_TransactGetItemsOutputTransformInput__M9_sdkOutput(value.SdkOutput), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_TransactGetItemsOutputTransformInput__M13_originalInput(value.OriginalInput));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ResolveAttributesOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S23_ResolveAttributesOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IResolveAttributesOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ResolveAttributesOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ResolveAttributesOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ResolveAttributesOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ResolveAttributesOutput(); converted.VirtualFields = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S23_ResolveAttributesOutput__M13_VirtualFields(concrete._VirtualFields);
      converted.CompoundBeacons = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S23_ResolveAttributesOutput__M15_CompoundBeacons(concrete._CompoundBeacons); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IResolveAttributesOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S23_ResolveAttributesOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ResolveAttributesOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ResolveAttributesOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S23_ResolveAttributesOutput__M13_VirtualFields(value.VirtualFields), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S23_ResolveAttributesOutput__M15_CompoundBeacons(value.CompoundBeacons));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteTransactionOutputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_ExecuteTransactionOutputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteTransactionOutputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteTransactionOutputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteTransactionOutputTransformInput(); converted.SdkOutput = (Amazon.DynamoDBv2.Model.ExecuteTransactionResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_ExecuteTransactionOutputTransformInput__M9_sdkOutput(concrete._sdkOutput);
      converted.OriginalInput = (Amazon.DynamoDBv2.Model.ExecuteTransactionRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_ExecuteTransactionOutputTransformInput__M13_originalInput(concrete._originalInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteTransactionOutputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_ExecuteTransactionOutputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteTransactionOutputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_ExecuteTransactionOutputTransformInput__M9_sdkOutput(value.SdkOutput), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_ExecuteTransactionOutputTransformInput__M13_originalInput(value.OriginalInput));
    }
    public static Amazon.DynamoDBv2.Model.BatchExecuteStatementRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S40_BatchExecuteStatementInputTransformInput__M8_sdkInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchExecuteStatementInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_BatchExecuteStatementInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchExecuteStatementInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S40_BatchExecuteStatementInputTransformInput__M8_sdkInput(Amazon.DynamoDBv2.Model.BatchExecuteStatementRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_BatchExecuteStatementInput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DeleteItemOutputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S31_DeleteItemOutputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IDeleteItemOutputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemOutputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemOutputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DeleteItemOutputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DeleteItemOutputTransformOutput(); converted.TransformedOutput = (Amazon.DynamoDBv2.Model.DeleteItemResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S31_DeleteItemOutputTransformOutput__M17_transformedOutput(concrete._transformedOutput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IDeleteItemOutputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S31_DeleteItemOutputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DeleteItemOutputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemOutputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S31_DeleteItemOutputTransformOutput__M17_transformedOutput(value.TransformedOutput));
    }
    public static Amazon.DynamoDBv2.Model.ExecuteStatementRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_ExecuteStatementInputTransformOutput__M16_transformedInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteStatementInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteStatementInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_ExecuteStatementInputTransformOutput__M16_transformedInput(Amazon.DynamoDBv2.Model.ExecuteStatementRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ScanInputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_ScanInputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IScanInputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanInputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanInputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ScanInputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ScanInputTransformOutput(); converted.TransformedInput = (Amazon.DynamoDBv2.Model.ScanRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_ScanInputTransformOutput__M16_transformedInput(concrete._transformedInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IScanInputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_ScanInputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ScanInputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanInputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_ScanInputTransformOutput__M16_transformedInput(value.TransformedInput));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.GetItemOutputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_GetItemOutputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IGetItemOutputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.GetItemOutputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.GetItemOutputTransformInput(); converted.SdkOutput = (Amazon.DynamoDBv2.Model.GetItemResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_GetItemOutputTransformInput__M9_sdkOutput(concrete._sdkOutput);
      converted.OriginalInput = (Amazon.DynamoDBv2.Model.GetItemRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_GetItemOutputTransformInput__M13_originalInput(concrete._originalInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IGetItemOutputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_GetItemOutputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.GetItemOutputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_GetItemOutputTransformInput__M9_sdkOutput(value.SdkOutput), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_GetItemOutputTransformInput__M13_originalInput(value.OriginalInput));
    }
    public static Amazon.DynamoDBv2.Model.QueryResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_QueryOutputTransformInput__M9_sdkOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IQueryOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IQueryOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_QueryOutputTransformInput__M9_sdkOutput(Amazon.DynamoDBv2.Model.QueryResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteTransactionInputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_ExecuteTransactionInputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteTransactionInputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteTransactionInputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteTransactionInputTransformInput(); converted.SdkInput = (Amazon.DynamoDBv2.Model.ExecuteTransactionRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_ExecuteTransactionInputTransformInput__M8_sdkInput(concrete._sdkInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteTransactionInputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_ExecuteTransactionInputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteTransactionInputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_ExecuteTransactionInputTransformInput__M8_sdkInput(value.SdkInput));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchExecuteStatementInputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S41_BatchExecuteStatementInputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchExecuteStatementInputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchExecuteStatementInputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchExecuteStatementInputTransformOutput(); converted.TransformedInput = (Amazon.DynamoDBv2.Model.BatchExecuteStatementRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S41_BatchExecuteStatementInputTransformOutput__M16_transformedInput(concrete._transformedInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchExecuteStatementInputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S41_BatchExecuteStatementInputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchExecuteStatementInputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S41_BatchExecuteStatementInputTransformOutput__M16_transformedInput(value.TransformedInput));
    }
    public static Amazon.DynamoDBv2.Model.UpdateItemResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S31_UpdateItemOutputTransformOutput__M17_transformedOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IUpdateItemOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateItemOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IUpdateItemOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S31_UpdateItemOutputTransformOutput__M17_transformedOutput(Amazon.DynamoDBv2.Model.UpdateItemResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateItemOutput(value);
    }
    public static Amazon.DynamoDBv2.Model.UpdateItemRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_UpdateItemOutputTransformInput__M13_originalInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IUpdateItemInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IUpdateItemInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_UpdateItemOutputTransformInput__M13_originalInput(Amazon.DynamoDBv2.Model.UpdateItemRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput(value);
    }
    public static Amazon.DynamoDBv2.Model.TransactWriteItemsRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_TransactWriteItemsInputTransformOutput__M16_transformedInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItemsInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItemsInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_TransactWriteItemsInputTransformOutput__M16_transformedInput(Amazon.DynamoDBv2.Model.TransactWriteItemsRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput(value);
    }
    public static Amazon.DynamoDBv2.Model.BatchExecuteStatementResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S42_BatchExecuteStatementOutputTransformOutput__M17_transformedOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchExecuteStatementOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_BatchExecuteStatementOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchExecuteStatementOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S42_BatchExecuteStatementOutputTransformOutput__M17_transformedOutput(Amazon.DynamoDBv2.Model.BatchExecuteStatementResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_BatchExecuteStatementOutput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.QueryOutputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_QueryOutputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IQueryOutputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryOutputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryOutputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.QueryOutputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.QueryOutputTransformInput(); converted.SdkOutput = (Amazon.DynamoDBv2.Model.QueryResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_QueryOutputTransformInput__M9_sdkOutput(concrete._sdkOutput);
      converted.OriginalInput = (Amazon.DynamoDBv2.Model.QueryRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_QueryOutputTransformInput__M13_originalInput(concrete._originalInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IQueryOutputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_QueryOutputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.QueryOutputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryOutputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_QueryOutputTransformInput__M9_sdkOutput(value.SdkOutput), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_QueryOutputTransformInput__M13_originalInput(value.OriginalInput));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteStatementOutputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_ExecuteStatementOutputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteStatementOutputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteStatementOutputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteStatementOutputTransformInput(); converted.SdkOutput = (Amazon.DynamoDBv2.Model.ExecuteStatementResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_ExecuteStatementOutputTransformInput__M9_sdkOutput(concrete._sdkOutput);
      converted.OriginalInput = (Amazon.DynamoDBv2.Model.ExecuteStatementRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_ExecuteStatementOutputTransformInput__M13_originalInput(concrete._originalInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteStatementOutputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_ExecuteStatementOutputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteStatementOutputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_ExecuteStatementOutputTransformInput__M9_sdkOutput(value.SdkOutput), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_ExecuteStatementOutputTransformInput__M13_originalInput(value.OriginalInput));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteTransactionOutputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S39_ExecuteTransactionOutputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteTransactionOutputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteTransactionOutputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteTransactionOutputTransformOutput(); converted.TransformedOutput = (Amazon.DynamoDBv2.Model.ExecuteTransactionResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S39_ExecuteTransactionOutputTransformOutput__M17_transformedOutput(concrete._transformedOutput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IExecuteTransactionOutputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S39_ExecuteTransactionOutputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ExecuteTransactionOutputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S39_ExecuteTransactionOutputTransformOutput__M17_transformedOutput(value.TransformedOutput));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DeleteItemInputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S29_DeleteItemInputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IDeleteItemInputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemInputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemInputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DeleteItemInputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DeleteItemInputTransformInput(); converted.SdkInput = (Amazon.DynamoDBv2.Model.DeleteItemRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S29_DeleteItemInputTransformInput__M8_sdkInput(concrete._sdkInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IDeleteItemInputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S29_DeleteItemInputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DeleteItemInputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemInputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S29_DeleteItemInputTransformInput__M8_sdkInput(value.SdkInput));
    }
    public static Amazon.DynamoDBv2.Model.ScanRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S23_ScanInputTransformInput__M8_sdkInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IScanInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IScanInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S23_ScanInputTransformInput__M8_sdkInput(Amazon.DynamoDBv2.Model.ScanRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput(value);
    }
    public static Amazon.DynamoDBv2.Model.ExecuteTransactionResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_ExecuteTransactionOutputTransformInput__M9_sdkOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteTransactionOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ExecuteTransactionOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteTransactionOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_ExecuteTransactionOutputTransformInput__M9_sdkOutput(Amazon.DynamoDBv2.Model.ExecuteTransactionResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ExecuteTransactionOutput(value);
    }
    public static Amazon.DynamoDBv2.Model.BatchGetItemRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S32_BatchGetItemOutputTransformInput__M13_originalInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchGetItemInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_BatchGetItemInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchGetItemInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S32_BatchGetItemOutputTransformInput__M13_originalInput(Amazon.DynamoDBv2.Model.BatchGetItemRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_BatchGetItemInput(value);
    }
    public static string FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_DynamoDbEncryptionTransformsException__M7_message(Dafny.ISequence<char> value)
    {
      return FromDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_DynamoDbEncryptionTransformsException__M7_message(string value)
    {
      return ToDafny_N6_smithy__N3_api__S6_String(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.QueryInputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_QueryInputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IQueryInputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryInputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryInputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.QueryInputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.QueryInputTransformInput(); converted.SdkInput = (Amazon.DynamoDBv2.Model.QueryRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_QueryInputTransformInput__M8_sdkInput(concrete._sdkInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IQueryInputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_QueryInputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.QueryInputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryInputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_QueryInputTransformInput__M8_sdkInput(value.SdkInput));
    }
    public static Amazon.DynamoDBv2.Model.TransactGetItemsResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_TransactGetItemsOutputTransformInput__M9_sdkOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItemsOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_TransactGetItemsOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItemsOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_TransactGetItemsOutputTransformInput__M9_sdkOutput(Amazon.DynamoDBv2.Model.TransactGetItemsResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_TransactGetItemsOutput(value);
    }
    public static Amazon.DynamoDBv2.Model.TransactGetItemsRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S35_TransactGetItemsInputTransformInput__M8_sdkInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItemsInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactGetItemsInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItemsInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S35_TransactGetItemsInputTransformInput__M8_sdkInput(Amazon.DynamoDBv2.Model.TransactGetItemsRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactGetItemsInput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.PutItemInputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_PutItemInputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IPutItemInputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemInputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemInputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.PutItemInputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.PutItemInputTransformOutput(); converted.TransformedInput = (Amazon.DynamoDBv2.Model.PutItemRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_PutItemInputTransformOutput__M16_transformedInput(concrete._transformedInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IPutItemInputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_PutItemInputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.PutItemInputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemInputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_PutItemInputTransformOutput__M16_transformedInput(value.TransformedInput));
    }
    public static Amazon.DynamoDBv2.Model.BatchGetItemResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S32_BatchGetItemOutputTransformInput__M9_sdkOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchGetItemOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetItemOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchGetItemOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S32_BatchGetItemOutputTransformInput__M9_sdkOutput(Amazon.DynamoDBv2.Model.BatchGetItemResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetItemOutput(value);
    }
    public static Amazon.DynamoDBv2.Model.TransactWriteItemsRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_TransactWriteItemsInputTransformInput__M8_sdkInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItemsInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItemsInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_TransactWriteItemsInputTransformInput__M8_sdkInput(Amazon.DynamoDBv2.Model.TransactWriteItemsRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput(value);
    }
    public static Amazon.DynamoDBv2.Model.TransactWriteItemsResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S39_TransactWriteItemsOutputTransformOutput__M17_transformedOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItemsOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_TransactWriteItemsOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItemsOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S39_TransactWriteItemsOutputTransformOutput__M17_transformedOutput(Amazon.DynamoDBv2.Model.TransactWriteItemsResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_TransactWriteItemsOutput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.UpdateItemOutputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_UpdateItemOutputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IUpdateItemOutputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemOutputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemOutputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.UpdateItemOutputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.UpdateItemOutputTransformInput(); converted.SdkOutput = (Amazon.DynamoDBv2.Model.UpdateItemResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_UpdateItemOutputTransformInput__M9_sdkOutput(concrete._sdkOutput);
      converted.OriginalInput = (Amazon.DynamoDBv2.Model.UpdateItemRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_UpdateItemOutputTransformInput__M13_originalInput(concrete._originalInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IUpdateItemOutputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_UpdateItemOutputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.UpdateItemOutputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemOutputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_UpdateItemOutputTransformInput__M9_sdkOutput(value.SdkOutput), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_UpdateItemOutputTransformInput__M13_originalInput(value.OriginalInput));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchWriteItemInputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S34_BatchWriteItemInputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchWriteItemInputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchWriteItemInputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchWriteItemInputTransformOutput(); converted.TransformedInput = (Amazon.DynamoDBv2.Model.BatchWriteItemRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S34_BatchWriteItemInputTransformOutput__M16_transformedInput(concrete._transformedInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchWriteItemInputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S34_BatchWriteItemInputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchWriteItemInputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S34_BatchWriteItemInputTransformOutput__M16_transformedInput(value.TransformedInput));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchWriteItemOutputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S34_BatchWriteItemOutputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchWriteItemOutputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchWriteItemOutputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchWriteItemOutputTransformInput(); converted.SdkOutput = (Amazon.DynamoDBv2.Model.BatchWriteItemResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S34_BatchWriteItemOutputTransformInput__M9_sdkOutput(concrete._sdkOutput);
      converted.OriginalInput = (Amazon.DynamoDBv2.Model.BatchWriteItemRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S34_BatchWriteItemOutputTransformInput__M13_originalInput(concrete._originalInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IBatchWriteItemOutputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S34_BatchWriteItemOutputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.BatchWriteItemOutputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S34_BatchWriteItemOutputTransformInput__M9_sdkOutput(value.SdkOutput), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S34_BatchWriteItemOutputTransformInput__M13_originalInput(value.OriginalInput));
    }
    public static Amazon.DynamoDBv2.Model.TransactWriteItemsResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_TransactWriteItemsOutputTransformInput__M9_sdkOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItemsOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_TransactWriteItemsOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItemsOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_TransactWriteItemsOutputTransformInput__M9_sdkOutput(Amazon.DynamoDBv2.Model.TransactWriteItemsResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_TransactWriteItemsOutput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactGetItemsOutputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_TransactGetItemsOutputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactGetItemsOutputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsOutputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsOutputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactGetItemsOutputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactGetItemsOutputTransformOutput(); converted.TransformedOutput = (Amazon.DynamoDBv2.Model.TransactGetItemsResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_TransactGetItemsOutputTransformOutput__M17_transformedOutput(concrete._transformedOutput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactGetItemsOutputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_TransactGetItemsOutputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactGetItemsOutputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsOutputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_TransactGetItemsOutputTransformOutput__M17_transformedOutput(value.TransformedOutput));
    }
    public static Amazon.DynamoDBv2.Model.ExecuteTransactionRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_ExecuteTransactionInputTransformOutput__M16_transformedInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteTransactionInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ExecuteTransactionInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteTransactionInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_ExecuteTransactionInputTransformOutput__M16_transformedInput(Amazon.DynamoDBv2.Model.ExecuteTransactionRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ExecuteTransactionInput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactWriteItemsOutputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S39_TransactWriteItemsOutputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactWriteItemsOutputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsOutputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsOutputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactWriteItemsOutputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactWriteItemsOutputTransformOutput(); converted.TransformedOutput = (Amazon.DynamoDBv2.Model.TransactWriteItemsResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S39_TransactWriteItemsOutputTransformOutput__M17_transformedOutput(concrete._transformedOutput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._ITransactWriteItemsOutputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S39_TransactWriteItemsOutputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TransactWriteItemsOutputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsOutputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S39_TransactWriteItemsOutputTransformOutput__M17_transformedOutput(value.TransformedOutput));
    }
    public static Amazon.DynamoDBv2.Model.QueryRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_QueryInputTransformOutput__M16_transformedInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IQueryInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IQueryInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S25_QueryInputTransformOutput__M16_transformedInput(Amazon.DynamoDBv2.Model.QueryRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DynamoDbEncryptionTransformsException FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_DynamoDbEncryptionTransformsException(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error_DynamoDbEncryptionTransformsException value)
    {
      return new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DynamoDbEncryptionTransformsException(
      FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_DynamoDbEncryptionTransformsException__M7_message(value._message)
      );
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error_DynamoDbEncryptionTransformsException ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_DynamoDbEncryptionTransformsException(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DynamoDbEncryptionTransformsException value)
    {

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error_DynamoDbEncryptionTransformsException(
      ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_DynamoDbEncryptionTransformsException__M7_message(value.Message)
      );
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.GetItemInputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S26_GetItemInputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IGetItemInputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemInputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemInputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.GetItemInputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.GetItemInputTransformInput(); converted.SdkInput = (Amazon.DynamoDBv2.Model.GetItemRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S26_GetItemInputTransformInput__M8_sdkInput(concrete._sdkInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IGetItemInputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S26_GetItemInputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.GetItemInputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemInputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S26_GetItemInputTransformInput__M8_sdkInput(value.SdkInput));
    }
    public static int? FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S22_ResolveAttributesInput__M7_Version(Wrappers_Compile._IOption<int> value)
    {
      return value.is_None ? (int?)null : FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_VersionNumber(value.Extract());
    }
    public static Wrappers_Compile._IOption<int> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S22_ResolveAttributesInput__M7_Version(int? value)
    {
      return value == null ? Wrappers_Compile.Option<int>.create_None() : Wrappers_Compile.Option<int>.create_Some(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_VersionNumber((int)value));
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DeleteItemInputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_DeleteItemInputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IDeleteItemInputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemInputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemInputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DeleteItemInputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DeleteItemInputTransformOutput(); converted.TransformedInput = (Amazon.DynamoDBv2.Model.DeleteItemRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_DeleteItemInputTransformOutput__M16_transformedInput(concrete._transformedInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IDeleteItemInputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_DeleteItemInputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DeleteItemInputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemInputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S30_DeleteItemInputTransformOutput__M16_transformedInput(value.TransformedInput));
    }
    public static Amazon.DynamoDBv2.Model.GetItemRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_GetItemOutputTransformInput__M13_originalInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IGetItemInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IGetItemInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_GetItemOutputTransformInput__M13_originalInput(Amazon.DynamoDBv2.Model.GetItemRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput(value);
    }
    public static Amazon.DynamoDBv2.Model.GetItemRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_GetItemInputTransformOutput__M16_transformedInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IGetItemInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IGetItemInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_GetItemInputTransformOutput__M16_transformedInput(Amazon.DynamoDBv2.Model.GetItemRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput(value);
    }
    public static Amazon.DynamoDBv2.Model.TransactGetItemsRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_TransactGetItemsInputTransformOutput__M16_transformedInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItemsInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactGetItemsInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItemsInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S36_TransactGetItemsInputTransformOutput__M16_transformedInput(Amazon.DynamoDBv2.Model.TransactGetItemsRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactGetItemsInput(value);
    }
    public static Amazon.DynamoDBv2.Model.BatchWriteItemRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S33_BatchWriteItemInputTransformInput__M8_sdkInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchWriteItemInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchWriteItemInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchWriteItemInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S33_BatchWriteItemInputTransformInput__M8_sdkInput(Amazon.DynamoDBv2.Model.BatchWriteItemRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchWriteItemInput(value);
    }
    public static Amazon.DynamoDBv2.Model.ExecuteTransactionRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_ExecuteTransactionOutputTransformInput__M13_originalInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteTransactionInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ExecuteTransactionInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteTransactionInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S38_ExecuteTransactionOutputTransformInput__M13_originalInput(Amazon.DynamoDBv2.Model.ExecuteTransactionRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ExecuteTransactionInput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ResolveAttributesInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S22_ResolveAttributesInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IResolveAttributesInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ResolveAttributesInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ResolveAttributesInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ResolveAttributesInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ResolveAttributesInput(); converted.TableName = (string)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S22_ResolveAttributesInput__M9_TableName(concrete._TableName);
      converted.Item = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S22_ResolveAttributesInput__M4_Item(concrete._Item);
      if (concrete._Version.is_Some) converted.Version = (int)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S22_ResolveAttributesInput__M7_Version(concrete._Version); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IResolveAttributesInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S22_ResolveAttributesInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ResolveAttributesInput value)
    {
      value.Validate();
      int? var_version = value.IsSetVersion() ? value.Version : (int?)null;
      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ResolveAttributesInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S22_ResolveAttributesInput__M9_TableName(value.TableName), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S22_ResolveAttributesInput__M4_Item(value.Item), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S22_ResolveAttributesInput__M7_Version(var_version));
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S23_ResolveAttributesOutput__M13_VirtualFields(Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>> value)
    {
      return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S9_StringMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>> ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S23_ResolveAttributesOutput__M13_VirtualFields(System.Collections.Generic.Dictionary<string, string> value)
    {
      return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S9_StringMap(value);
    }
    public static Amazon.DynamoDBv2.Model.GetItemResponse FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_GetItemOutputTransformInput__M9_sdkOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IGetItemOutput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_GetItemOutput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IGetItemOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S27_GetItemOutputTransformInput__M9_sdkOutput(Amazon.DynamoDBv2.Model.GetItemResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_GetItemOutput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.UpdateItemOutputTransformOutput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S31_UpdateItemOutputTransformOutput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IUpdateItemOutputTransformOutput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemOutputTransformOutput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemOutputTransformOutput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.UpdateItemOutputTransformOutput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.UpdateItemOutputTransformOutput(); converted.TransformedOutput = (Amazon.DynamoDBv2.Model.UpdateItemResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S31_UpdateItemOutputTransformOutput__M17_transformedOutput(concrete._transformedOutput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IUpdateItemOutputTransformOutput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S31_UpdateItemOutputTransformOutput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.UpdateItemOutputTransformOutput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemOutputTransformOutput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S31_UpdateItemOutputTransformOutput__M17_transformedOutput(value.TransformedOutput));
    }
    public static Amazon.DynamoDBv2.Model.ExecuteStatementRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S35_ExecuteStatementInputTransformInput__M8_sdkInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteStatementInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteStatementInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S35_ExecuteStatementInputTransformInput__M8_sdkInput(Amazon.DynamoDBv2.Model.ExecuteStatementRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput(value);
    }
    public static AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ScanOutputTransformInput FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_ScanOutputTransformInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IScanOutputTransformInput value)
    {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanOutputTransformInput concrete = (software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanOutputTransformInput)value; AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ScanOutputTransformInput converted = new AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ScanOutputTransformInput(); converted.SdkOutput = (Amazon.DynamoDBv2.Model.ScanResponse)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_ScanOutputTransformInput__M9_sdkOutput(concrete._sdkOutput);
      converted.OriginalInput = (Amazon.DynamoDBv2.Model.ScanRequest)FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_ScanOutputTransformInput__M13_originalInput(concrete._originalInput); return converted;
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IScanOutputTransformInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_ScanOutputTransformInput(AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.ScanOutputTransformInput value)
    {
      value.Validate();

      return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanOutputTransformInput(ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_ScanOutputTransformInput__M9_sdkOutput(value.SdkOutput), ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S24_ScanOutputTransformInput__M13_originalInput(value.OriginalInput));
    }
    public static Amazon.DynamoDBv2.Model.UpdateItemRequest FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S29_UpdateItemInputTransformInput__M8_sdkInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IUpdateItemInput value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IUpdateItemInput ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S29_UpdateItemInputTransformInput__M8_sdkInput(Amazon.DynamoDBv2.Model.UpdateItemRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput(value);
    }
    public static Amazon.DynamoDBv2.Model.BatchWriteItemRequest FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchWriteItemInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchWriteItemInput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput)value; Amazon.DynamoDBv2.Model.BatchWriteItemRequest converted = new Amazon.DynamoDBv2.Model.BatchWriteItemRequest(); converted.RequestItems = (System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.WriteRequest>>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchWriteItemInput__M12_RequestItems(concrete._RequestItems);
      if (concrete._ReturnConsumedCapacity.is_Some) converted.ReturnConsumedCapacity = (Amazon.DynamoDBv2.ReturnConsumedCapacity)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchWriteItemInput__M22_ReturnConsumedCapacity(concrete._ReturnConsumedCapacity);
      if (concrete._ReturnItemCollectionMetrics.is_Some) converted.ReturnItemCollectionMetrics = (Amazon.DynamoDBv2.ReturnItemCollectionMetrics)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchWriteItemInput__M27_ReturnItemCollectionMetrics(concrete._ReturnItemCollectionMetrics); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchWriteItemInput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchWriteItemInput(Amazon.DynamoDBv2.Model.BatchWriteItemRequest value)
    {

      Amazon.DynamoDBv2.ReturnConsumedCapacity var_returnConsumedCapacity = value.ReturnConsumedCapacity != null ? value.ReturnConsumedCapacity : (Amazon.DynamoDBv2.ReturnConsumedCapacity)null;
      Amazon.DynamoDBv2.ReturnItemCollectionMetrics var_returnItemCollectionMetrics = value.ReturnItemCollectionMetrics != null ? value.ReturnItemCollectionMetrics : (Amazon.DynamoDBv2.ReturnItemCollectionMetrics)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchWriteItemInput__M12_RequestItems(value.RequestItems), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchWriteItemInput__M22_ReturnConsumedCapacity(var_returnConsumedCapacity), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchWriteItemInput__M27_ReturnItemCollectionMetrics(var_returnItemCollectionMetrics));
    }
    public static Amazon.DynamoDBv2.Model.TransactGetItemsRequest FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactGetItemsInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItemsInput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsInput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsInput)value; Amazon.DynamoDBv2.Model.TransactGetItemsRequest converted = new Amazon.DynamoDBv2.Model.TransactGetItemsRequest(); converted.TransactItems = (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.TransactGetItem>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactGetItemsInput__M13_TransactItems(concrete._TransactItems);
      if (concrete._ReturnConsumedCapacity.is_Some) converted.ReturnConsumedCapacity = (Amazon.DynamoDBv2.ReturnConsumedCapacity)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactGetItemsInput__M22_ReturnConsumedCapacity(concrete._ReturnConsumedCapacity); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItemsInput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactGetItemsInput(Amazon.DynamoDBv2.Model.TransactGetItemsRequest value)
    {

      Amazon.DynamoDBv2.ReturnConsumedCapacity var_returnConsumedCapacity = value.ReturnConsumedCapacity != null ? value.ReturnConsumedCapacity : (Amazon.DynamoDBv2.ReturnConsumedCapacity)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsInput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactGetItemsInput__M13_TransactItems(value.TransactItems), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactGetItemsInput__M22_ReturnConsumedCapacity(var_returnConsumedCapacity));
    }
    public static Amazon.DynamoDBv2.Model.PutItemRequest FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IPutItemInput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemInput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemInput)value; Amazon.DynamoDBv2.Model.PutItemRequest converted = new Amazon.DynamoDBv2.Model.PutItemRequest(); converted.TableName = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M9_TableName(concrete._TableName);
      converted.Item = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M4_Item(concrete._Item);
      if (concrete._Expected.is_Some) converted.Expected = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M8_Expected(concrete._Expected);
      if (concrete._ReturnValues.is_Some) converted.ReturnValues = (Amazon.DynamoDBv2.ReturnValue)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M12_ReturnValues(concrete._ReturnValues);
      if (concrete._ReturnConsumedCapacity.is_Some) converted.ReturnConsumedCapacity = (Amazon.DynamoDBv2.ReturnConsumedCapacity)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M22_ReturnConsumedCapacity(concrete._ReturnConsumedCapacity);
      if (concrete._ReturnItemCollectionMetrics.is_Some) converted.ReturnItemCollectionMetrics = (Amazon.DynamoDBv2.ReturnItemCollectionMetrics)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M27_ReturnItemCollectionMetrics(concrete._ReturnItemCollectionMetrics);
      if (concrete._ConditionalOperator.is_Some) converted.ConditionalOperator = (Amazon.DynamoDBv2.ConditionalOperator)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M19_ConditionalOperator(concrete._ConditionalOperator);
      if (concrete._ConditionExpression.is_Some) converted.ConditionExpression = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M19_ConditionExpression(concrete._ConditionExpression);
      if (concrete._ExpressionAttributeNames.is_Some) converted.ExpressionAttributeNames = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M24_ExpressionAttributeNames(concrete._ExpressionAttributeNames);
      if (concrete._ExpressionAttributeValues.is_Some) converted.ExpressionAttributeValues = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M25_ExpressionAttributeValues(concrete._ExpressionAttributeValues);
      if (concrete._ReturnValuesOnConditionCheckFailure.is_Some) converted.ReturnValuesOnConditionCheckFailure = (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M35_ReturnValuesOnConditionCheckFailure(concrete._ReturnValuesOnConditionCheckFailure); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IPutItemInput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput(Amazon.DynamoDBv2.Model.PutItemRequest value)
    {

      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue> var_expected = value.Expected != null ? value.Expected : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue>)null;
      Amazon.DynamoDBv2.ReturnValue var_returnValues = value.ReturnValues != null ? value.ReturnValues : (Amazon.DynamoDBv2.ReturnValue)null;
      Amazon.DynamoDBv2.ReturnConsumedCapacity var_returnConsumedCapacity = value.ReturnConsumedCapacity != null ? value.ReturnConsumedCapacity : (Amazon.DynamoDBv2.ReturnConsumedCapacity)null;
      Amazon.DynamoDBv2.ReturnItemCollectionMetrics var_returnItemCollectionMetrics = value.ReturnItemCollectionMetrics != null ? value.ReturnItemCollectionMetrics : (Amazon.DynamoDBv2.ReturnItemCollectionMetrics)null;
      Amazon.DynamoDBv2.ConditionalOperator var_conditionalOperator = value.ConditionalOperator != null ? value.ConditionalOperator : (Amazon.DynamoDBv2.ConditionalOperator)null;
      string var_conditionExpression = value.ConditionExpression != null ? value.ConditionExpression : (string)null;
      System.Collections.Generic.Dictionary<string, string> var_expressionAttributeNames = value.ExpressionAttributeNames != null ? value.ExpressionAttributeNames : (System.Collections.Generic.Dictionary<string, string>)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> var_expressionAttributeValues = value.ExpressionAttributeValues != null ? value.ExpressionAttributeValues : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null;
      Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure var_returnValuesOnConditionCheckFailure = value.ReturnValuesOnConditionCheckFailure != null ? value.ReturnValuesOnConditionCheckFailure : (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemInput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M9_TableName(value.TableName), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M4_Item(value.Item), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M8_Expected(var_expected), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M12_ReturnValues(var_returnValues), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M22_ReturnConsumedCapacity(var_returnConsumedCapacity), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M27_ReturnItemCollectionMetrics(var_returnItemCollectionMetrics), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M19_ConditionalOperator(var_conditionalOperator), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M19_ConditionExpression(var_conditionExpression), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M24_ExpressionAttributeNames(var_expressionAttributeNames), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M25_ExpressionAttributeValues(var_expressionAttributeValues), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M35_ReturnValuesOnConditionCheckFailure(var_returnValuesOnConditionCheckFailure));
    }
    public static Amazon.DynamoDBv2.Model.UpdateItemRequest FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IUpdateItemInput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemInput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemInput)value; Amazon.DynamoDBv2.Model.UpdateItemRequest converted = new Amazon.DynamoDBv2.Model.UpdateItemRequest(); converted.TableName = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M9_TableName(concrete._TableName);
      converted.Key = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M3_Key(concrete._Key);
      if (concrete._AttributeUpdates.is_Some) converted.AttributeUpdates = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValueUpdate>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M16_AttributeUpdates(concrete._AttributeUpdates);
      if (concrete._Expected.is_Some) converted.Expected = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M8_Expected(concrete._Expected);
      if (concrete._ConditionalOperator.is_Some) converted.ConditionalOperator = (Amazon.DynamoDBv2.ConditionalOperator)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M19_ConditionalOperator(concrete._ConditionalOperator);
      if (concrete._ReturnValues.is_Some) converted.ReturnValues = (Amazon.DynamoDBv2.ReturnValue)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M12_ReturnValues(concrete._ReturnValues);
      if (concrete._ReturnConsumedCapacity.is_Some) converted.ReturnConsumedCapacity = (Amazon.DynamoDBv2.ReturnConsumedCapacity)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M22_ReturnConsumedCapacity(concrete._ReturnConsumedCapacity);
      if (concrete._ReturnItemCollectionMetrics.is_Some) converted.ReturnItemCollectionMetrics = (Amazon.DynamoDBv2.ReturnItemCollectionMetrics)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M27_ReturnItemCollectionMetrics(concrete._ReturnItemCollectionMetrics);
      if (concrete._UpdateExpression.is_Some) converted.UpdateExpression = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M16_UpdateExpression(concrete._UpdateExpression);
      if (concrete._ConditionExpression.is_Some) converted.ConditionExpression = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M19_ConditionExpression(concrete._ConditionExpression);
      if (concrete._ExpressionAttributeNames.is_Some) converted.ExpressionAttributeNames = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M24_ExpressionAttributeNames(concrete._ExpressionAttributeNames);
      if (concrete._ExpressionAttributeValues.is_Some) converted.ExpressionAttributeValues = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M25_ExpressionAttributeValues(concrete._ExpressionAttributeValues);
      if (concrete._ReturnValuesOnConditionCheckFailure.is_Some) converted.ReturnValuesOnConditionCheckFailure = (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M35_ReturnValuesOnConditionCheckFailure(concrete._ReturnValuesOnConditionCheckFailure); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IUpdateItemInput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput(Amazon.DynamoDBv2.Model.UpdateItemRequest value)
    {

      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValueUpdate> var_attributeUpdates = value.AttributeUpdates != null ? value.AttributeUpdates : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValueUpdate>)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue> var_expected = value.Expected != null ? value.Expected : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue>)null;
      Amazon.DynamoDBv2.ConditionalOperator var_conditionalOperator = value.ConditionalOperator != null ? value.ConditionalOperator : (Amazon.DynamoDBv2.ConditionalOperator)null;
      Amazon.DynamoDBv2.ReturnValue var_returnValues = value.ReturnValues != null ? value.ReturnValues : (Amazon.DynamoDBv2.ReturnValue)null;
      Amazon.DynamoDBv2.ReturnConsumedCapacity var_returnConsumedCapacity = value.ReturnConsumedCapacity != null ? value.ReturnConsumedCapacity : (Amazon.DynamoDBv2.ReturnConsumedCapacity)null;
      Amazon.DynamoDBv2.ReturnItemCollectionMetrics var_returnItemCollectionMetrics = value.ReturnItemCollectionMetrics != null ? value.ReturnItemCollectionMetrics : (Amazon.DynamoDBv2.ReturnItemCollectionMetrics)null;
      string var_updateExpression = value.UpdateExpression != null ? value.UpdateExpression : (string)null;
      string var_conditionExpression = value.ConditionExpression != null ? value.ConditionExpression : (string)null;
      System.Collections.Generic.Dictionary<string, string> var_expressionAttributeNames = value.ExpressionAttributeNames != null ? value.ExpressionAttributeNames : (System.Collections.Generic.Dictionary<string, string>)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> var_expressionAttributeValues = value.ExpressionAttributeValues != null ? value.ExpressionAttributeValues : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null;
      Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure var_returnValuesOnConditionCheckFailure = value.ReturnValuesOnConditionCheckFailure != null ? value.ReturnValuesOnConditionCheckFailure : (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemInput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M9_TableName(value.TableName), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M3_Key(value.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M16_AttributeUpdates(var_attributeUpdates), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M8_Expected(var_expected), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M19_ConditionalOperator(var_conditionalOperator), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M12_ReturnValues(var_returnValues), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M22_ReturnConsumedCapacity(var_returnConsumedCapacity), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M27_ReturnItemCollectionMetrics(var_returnItemCollectionMetrics), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M16_UpdateExpression(var_updateExpression), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M19_ConditionExpression(var_conditionExpression), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M24_ExpressionAttributeNames(var_expressionAttributeNames), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M25_ExpressionAttributeValues(var_expressionAttributeValues), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M35_ReturnValuesOnConditionCheckFailure(var_returnValuesOnConditionCheckFailure));
    }
    public static Amazon.DynamoDBv2.Model.TransactWriteItemsRequest FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItemsInput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsInput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsInput)value; Amazon.DynamoDBv2.Model.TransactWriteItemsRequest converted = new Amazon.DynamoDBv2.Model.TransactWriteItemsRequest(); converted.TransactItems = (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.TransactWriteItem>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput__M13_TransactItems(concrete._TransactItems);
      if (concrete._ReturnConsumedCapacity.is_Some) converted.ReturnConsumedCapacity = (Amazon.DynamoDBv2.ReturnConsumedCapacity)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput__M22_ReturnConsumedCapacity(concrete._ReturnConsumedCapacity);
      if (concrete._ReturnItemCollectionMetrics.is_Some) converted.ReturnItemCollectionMetrics = (Amazon.DynamoDBv2.ReturnItemCollectionMetrics)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput__M27_ReturnItemCollectionMetrics(concrete._ReturnItemCollectionMetrics);
      if (concrete._ClientRequestToken.is_Some) converted.ClientRequestToken = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput__M18_ClientRequestToken(concrete._ClientRequestToken); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItemsInput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput(Amazon.DynamoDBv2.Model.TransactWriteItemsRequest value)
    {

      Amazon.DynamoDBv2.ReturnConsumedCapacity var_returnConsumedCapacity = value.ReturnConsumedCapacity != null ? value.ReturnConsumedCapacity : (Amazon.DynamoDBv2.ReturnConsumedCapacity)null;
      Amazon.DynamoDBv2.ReturnItemCollectionMetrics var_returnItemCollectionMetrics = value.ReturnItemCollectionMetrics != null ? value.ReturnItemCollectionMetrics : (Amazon.DynamoDBv2.ReturnItemCollectionMetrics)null;
      string var_clientRequestToken = value.ClientRequestToken != null ? value.ClientRequestToken : (string)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsInput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput__M13_TransactItems(value.TransactItems), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput__M22_ReturnConsumedCapacity(var_returnConsumedCapacity), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput__M27_ReturnItemCollectionMetrics(var_returnItemCollectionMetrics), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput__M18_ClientRequestToken(var_clientRequestToken));
    }
    public static Amazon.DynamoDBv2.Model.ScanRequest FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IScanInput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput)value; Amazon.DynamoDBv2.Model.ScanRequest converted = new Amazon.DynamoDBv2.Model.ScanRequest(); converted.TableName = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M9_TableName(concrete._TableName);
      if (concrete._IndexName.is_Some) converted.IndexName = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M9_IndexName(concrete._IndexName);
      if (concrete._AttributesToGet.is_Some) converted.AttributesToGet = (System.Collections.Generic.List<string>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M15_AttributesToGet(concrete._AttributesToGet);
      if (concrete._Limit.is_Some) converted.Limit = (int)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M5_Limit(concrete._Limit);
      if (concrete._Select.is_Some) converted.Select = (Amazon.DynamoDBv2.Select)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M6_Select(concrete._Select);
      if (concrete._ScanFilter.is_Some) converted.ScanFilter = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M10_ScanFilter(concrete._ScanFilter);
      if (concrete._ConditionalOperator.is_Some) converted.ConditionalOperator = (Amazon.DynamoDBv2.ConditionalOperator)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M19_ConditionalOperator(concrete._ConditionalOperator);
      if (concrete._ExclusiveStartKey.is_Some) converted.ExclusiveStartKey = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M17_ExclusiveStartKey(concrete._ExclusiveStartKey);
      if (concrete._ReturnConsumedCapacity.is_Some) converted.ReturnConsumedCapacity = (Amazon.DynamoDBv2.ReturnConsumedCapacity)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M22_ReturnConsumedCapacity(concrete._ReturnConsumedCapacity);
      if (concrete._TotalSegments.is_Some) converted.TotalSegments = (int)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M13_TotalSegments(concrete._TotalSegments);
      if (concrete._Segment.is_Some) converted.Segment = (int)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M7_Segment(concrete._Segment);
      if (concrete._ProjectionExpression.is_Some) converted.ProjectionExpression = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M20_ProjectionExpression(concrete._ProjectionExpression);
      if (concrete._FilterExpression.is_Some) converted.FilterExpression = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M16_FilterExpression(concrete._FilterExpression);
      if (concrete._ExpressionAttributeNames.is_Some) converted.ExpressionAttributeNames = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M24_ExpressionAttributeNames(concrete._ExpressionAttributeNames);
      if (concrete._ExpressionAttributeValues.is_Some) converted.ExpressionAttributeValues = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M25_ExpressionAttributeValues(concrete._ExpressionAttributeValues);
      if (concrete._ConsistentRead.is_Some) converted.ConsistentRead = (bool)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M14_ConsistentRead(concrete._ConsistentRead); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IScanInput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput(Amazon.DynamoDBv2.Model.ScanRequest value)
    {

      string var_indexName = value.IndexName != null ? value.IndexName : (string)null;
      System.Collections.Generic.List<string> var_attributesToGet = value.AttributesToGet != null ? value.AttributesToGet : (System.Collections.Generic.List<string>)null;
      int? var_limit = value.IsLimitSet ? value.Limit : (int?)null;
      Amazon.DynamoDBv2.Select var_select = value.Select != null ? value.Select : (Amazon.DynamoDBv2.Select)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition> var_scanFilter = value.ScanFilter != null ? value.ScanFilter : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition>)null;
      Amazon.DynamoDBv2.ConditionalOperator var_conditionalOperator = value.ConditionalOperator != null ? value.ConditionalOperator : (Amazon.DynamoDBv2.ConditionalOperator)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> var_exclusiveStartKey = value.ExclusiveStartKey != null ? value.ExclusiveStartKey : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null;
      Amazon.DynamoDBv2.ReturnConsumedCapacity var_returnConsumedCapacity = value.ReturnConsumedCapacity != null ? value.ReturnConsumedCapacity : (Amazon.DynamoDBv2.ReturnConsumedCapacity)null;
      int? var_totalSegments = value.IsTotalSegmentsSet ? value.TotalSegments : (int?)null;
      int? var_segment = value.IsSegmentSet ? value.Segment : (int?)null;
      string var_projectionExpression = value.ProjectionExpression != null ? value.ProjectionExpression : (string)null;
      string var_filterExpression = value.FilterExpression != null ? value.FilterExpression : (string)null;
      System.Collections.Generic.Dictionary<string, string> var_expressionAttributeNames = value.ExpressionAttributeNames != null ? value.ExpressionAttributeNames : (System.Collections.Generic.Dictionary<string, string>)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> var_expressionAttributeValues = value.ExpressionAttributeValues != null ? value.ExpressionAttributeValues : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null;
      bool? var_consistentRead = value.ConsistentRead != null ? value.ConsistentRead : (bool?)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M9_TableName(value.TableName), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M9_IndexName(var_indexName), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M15_AttributesToGet(var_attributesToGet), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M5_Limit(var_limit), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M6_Select(var_select), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M10_ScanFilter(var_scanFilter), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M19_ConditionalOperator(var_conditionalOperator), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M17_ExclusiveStartKey(var_exclusiveStartKey), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M22_ReturnConsumedCapacity(var_returnConsumedCapacity), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M13_TotalSegments(var_totalSegments), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M7_Segment(var_segment), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M20_ProjectionExpression(var_projectionExpression), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M16_FilterExpression(var_filterExpression), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M24_ExpressionAttributeNames(var_expressionAttributeNames), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M25_ExpressionAttributeValues(var_expressionAttributeValues), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M14_ConsistentRead(var_consistentRead));
    }
    public static Amazon.DynamoDBv2.Model.DeleteItemResponse FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_DeleteItemOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IDeleteItemOutput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemOutput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemOutput)value; Amazon.DynamoDBv2.Model.DeleteItemResponse converted = new Amazon.DynamoDBv2.Model.DeleteItemResponse(); if (concrete._Attributes.is_Some) converted.Attributes = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_DeleteItemOutput__M10_Attributes(concrete._Attributes);
      if (concrete._ConsumedCapacity.is_Some) converted.ConsumedCapacity = (Amazon.DynamoDBv2.Model.ConsumedCapacity)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_DeleteItemOutput__M16_ConsumedCapacity(concrete._ConsumedCapacity);
      if (concrete._ItemCollectionMetrics.is_Some) converted.ItemCollectionMetrics = (Amazon.DynamoDBv2.Model.ItemCollectionMetrics)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_DeleteItemOutput__M21_ItemCollectionMetrics(concrete._ItemCollectionMetrics); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IDeleteItemOutput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_DeleteItemOutput(Amazon.DynamoDBv2.Model.DeleteItemResponse value)
    {

      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> var_attributes = value.Attributes != null ? value.Attributes : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null;
      Amazon.DynamoDBv2.Model.ConsumedCapacity var_consumedCapacity = value.ConsumedCapacity != null ? value.ConsumedCapacity : (Amazon.DynamoDBv2.Model.ConsumedCapacity)null;
      Amazon.DynamoDBv2.Model.ItemCollectionMetrics var_itemCollectionMetrics = value.ItemCollectionMetrics != null ? value.ItemCollectionMetrics : (Amazon.DynamoDBv2.Model.ItemCollectionMetrics)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemOutput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_DeleteItemOutput__M10_Attributes(var_attributes), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_DeleteItemOutput__M16_ConsumedCapacity(var_consumedCapacity), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_DeleteItemOutput__M21_ItemCollectionMetrics(var_itemCollectionMetrics));
    }
    public static Amazon.DynamoDBv2.Model.PutItemResponse FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_PutItemOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IPutItemOutput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemOutput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemOutput)value; Amazon.DynamoDBv2.Model.PutItemResponse converted = new Amazon.DynamoDBv2.Model.PutItemResponse(); if (concrete._Attributes.is_Some) converted.Attributes = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_PutItemOutput__M10_Attributes(concrete._Attributes);
      if (concrete._ConsumedCapacity.is_Some) converted.ConsumedCapacity = (Amazon.DynamoDBv2.Model.ConsumedCapacity)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_PutItemOutput__M16_ConsumedCapacity(concrete._ConsumedCapacity);
      if (concrete._ItemCollectionMetrics.is_Some) converted.ItemCollectionMetrics = (Amazon.DynamoDBv2.Model.ItemCollectionMetrics)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_PutItemOutput__M21_ItemCollectionMetrics(concrete._ItemCollectionMetrics); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IPutItemOutput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_PutItemOutput(Amazon.DynamoDBv2.Model.PutItemResponse value)
    {

      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> var_attributes = value.Attributes != null ? value.Attributes : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null;
      Amazon.DynamoDBv2.Model.ConsumedCapacity var_consumedCapacity = value.ConsumedCapacity != null ? value.ConsumedCapacity : (Amazon.DynamoDBv2.Model.ConsumedCapacity)null;
      Amazon.DynamoDBv2.Model.ItemCollectionMetrics var_itemCollectionMetrics = value.ItemCollectionMetrics != null ? value.ItemCollectionMetrics : (Amazon.DynamoDBv2.Model.ItemCollectionMetrics)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemOutput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_PutItemOutput__M10_Attributes(var_attributes), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_PutItemOutput__M16_ConsumedCapacity(var_consumedCapacity), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_PutItemOutput__M21_ItemCollectionMetrics(var_itemCollectionMetrics));
    }
    public static Amazon.DynamoDBv2.Model.ExecuteTransactionRequest FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ExecuteTransactionInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteTransactionInput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput)value; Amazon.DynamoDBv2.Model.ExecuteTransactionRequest converted = new Amazon.DynamoDBv2.Model.ExecuteTransactionRequest(); converted.TransactStatements = (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ParameterizedStatement>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ExecuteTransactionInput__M18_TransactStatements(concrete._TransactStatements);
      if (concrete._ClientRequestToken.is_Some) converted.ClientRequestToken = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ExecuteTransactionInput__M18_ClientRequestToken(concrete._ClientRequestToken);
      if (concrete._ReturnConsumedCapacity.is_Some) converted.ReturnConsumedCapacity = (Amazon.DynamoDBv2.ReturnConsumedCapacity)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ExecuteTransactionInput__M22_ReturnConsumedCapacity(concrete._ReturnConsumedCapacity); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteTransactionInput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ExecuteTransactionInput(Amazon.DynamoDBv2.Model.ExecuteTransactionRequest value)
    {

      string var_clientRequestToken = value.ClientRequestToken != null ? value.ClientRequestToken : (string)null;
      Amazon.DynamoDBv2.ReturnConsumedCapacity var_returnConsumedCapacity = value.ReturnConsumedCapacity != null ? value.ReturnConsumedCapacity : (Amazon.DynamoDBv2.ReturnConsumedCapacity)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ExecuteTransactionInput__M18_TransactStatements(value.TransactStatements), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ExecuteTransactionInput__M18_ClientRequestToken(var_clientRequestToken), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ExecuteTransactionInput__M22_ReturnConsumedCapacity(var_returnConsumedCapacity));
    }
    public static Amazon.DynamoDBv2.Model.ExecuteStatementResponse FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExecuteStatementOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteStatementOutput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementOutput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementOutput)value; Amazon.DynamoDBv2.Model.ExecuteStatementResponse converted = new Amazon.DynamoDBv2.Model.ExecuteStatementResponse(); if (concrete._Items.is_Some) converted.Items = (System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExecuteStatementOutput__M5_Items(concrete._Items);
      if (concrete._NextToken.is_Some) converted.NextToken = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExecuteStatementOutput__M9_NextToken(concrete._NextToken);
      if (concrete._ConsumedCapacity.is_Some) converted.ConsumedCapacity = (Amazon.DynamoDBv2.Model.ConsumedCapacity)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExecuteStatementOutput__M16_ConsumedCapacity(concrete._ConsumedCapacity);
      if (concrete._LastEvaluatedKey.is_Some) converted.LastEvaluatedKey = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExecuteStatementOutput__M16_LastEvaluatedKey(concrete._LastEvaluatedKey); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteStatementOutput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExecuteStatementOutput(Amazon.DynamoDBv2.Model.ExecuteStatementResponse value)
    {

      System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>> var_items = value.Items != null ? value.Items : (System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>)null;
      string var_nextToken = value.NextToken != null ? value.NextToken : (string)null;
      Amazon.DynamoDBv2.Model.ConsumedCapacity var_consumedCapacity = value.ConsumedCapacity != null ? value.ConsumedCapacity : (Amazon.DynamoDBv2.Model.ConsumedCapacity)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> var_lastEvaluatedKey = value.LastEvaluatedKey != null ? value.LastEvaluatedKey : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementOutput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExecuteStatementOutput__M5_Items(var_items), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExecuteStatementOutput__M9_NextToken(var_nextToken), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExecuteStatementOutput__M16_ConsumedCapacity(var_consumedCapacity), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExecuteStatementOutput__M16_LastEvaluatedKey(var_lastEvaluatedKey));
    }
    public static Amazon.DynamoDBv2.Model.ExecuteTransactionResponse FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ExecuteTransactionOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteTransactionOutput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionOutput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionOutput)value; Amazon.DynamoDBv2.Model.ExecuteTransactionResponse converted = new Amazon.DynamoDBv2.Model.ExecuteTransactionResponse(); if (concrete._Responses.is_Some) converted.Responses = (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemResponse>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ExecuteTransactionOutput__M9_Responses(concrete._Responses);
      if (concrete._ConsumedCapacity.is_Some) converted.ConsumedCapacity = (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ExecuteTransactionOutput__M16_ConsumedCapacity(concrete._ConsumedCapacity); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteTransactionOutput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ExecuteTransactionOutput(Amazon.DynamoDBv2.Model.ExecuteTransactionResponse value)
    {

      System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemResponse> var_responses = value.Responses != null ? value.Responses : (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemResponse>)null;
      System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity> var_consumedCapacity = value.ConsumedCapacity != null ? value.ConsumedCapacity : (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionOutput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ExecuteTransactionOutput__M9_Responses(var_responses), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ExecuteTransactionOutput__M16_ConsumedCapacity(var_consumedCapacity));
    }
    public static string FromDafny_N6_smithy__N3_api__S6_String(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N6_smithy__N3_api__S6_String(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static Amazon.DynamoDBv2.Model.GetItemResponse FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_GetItemOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IGetItemOutput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemOutput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemOutput)value; Amazon.DynamoDBv2.Model.GetItemResponse converted = new Amazon.DynamoDBv2.Model.GetItemResponse(); if (concrete._Item.is_Some) converted.Item = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_GetItemOutput__M4_Item(concrete._Item);
      if (concrete._ConsumedCapacity.is_Some) converted.ConsumedCapacity = (Amazon.DynamoDBv2.Model.ConsumedCapacity)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_GetItemOutput__M16_ConsumedCapacity(concrete._ConsumedCapacity); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IGetItemOutput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_GetItemOutput(Amazon.DynamoDBv2.Model.GetItemResponse value)
    {

      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> var_item = value.Item != null ? value.Item : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null;
      Amazon.DynamoDBv2.Model.ConsumedCapacity var_consumedCapacity = value.ConsumedCapacity != null ? value.ConsumedCapacity : (Amazon.DynamoDBv2.Model.ConsumedCapacity)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemOutput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_GetItemOutput__M4_Item(var_item), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_GetItemOutput__M16_ConsumedCapacity(var_consumedCapacity));
    }
    public static Amazon.DynamoDBv2.Model.BatchGetItemRequest FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_BatchGetItemInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchGetItemInput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput)value; Amazon.DynamoDBv2.Model.BatchGetItemRequest converted = new Amazon.DynamoDBv2.Model.BatchGetItemRequest(); converted.RequestItems = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.KeysAndAttributes>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_BatchGetItemInput__M12_RequestItems(concrete._RequestItems);
      if (concrete._ReturnConsumedCapacity.is_Some) converted.ReturnConsumedCapacity = (Amazon.DynamoDBv2.ReturnConsumedCapacity)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_BatchGetItemInput__M22_ReturnConsumedCapacity(concrete._ReturnConsumedCapacity); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchGetItemInput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_BatchGetItemInput(Amazon.DynamoDBv2.Model.BatchGetItemRequest value)
    {

      Amazon.DynamoDBv2.ReturnConsumedCapacity var_returnConsumedCapacity = value.ReturnConsumedCapacity != null ? value.ReturnConsumedCapacity : (Amazon.DynamoDBv2.ReturnConsumedCapacity)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_BatchGetItemInput__M12_RequestItems(value.RequestItems), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_BatchGetItemInput__M22_ReturnConsumedCapacity(var_returnConsumedCapacity));
    }
    public static Amazon.DynamoDBv2.Model.QueryResponse FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IQueryOutput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput)value; Amazon.DynamoDBv2.Model.QueryResponse converted = new Amazon.DynamoDBv2.Model.QueryResponse(); if (concrete._Items.is_Some) converted.Items = (System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput__M5_Items(concrete._Items);
      if (concrete._Count.is_Some) converted.Count = (int)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput__M5_Count(concrete._Count);
      if (concrete._ScannedCount.is_Some) converted.ScannedCount = (int)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput__M12_ScannedCount(concrete._ScannedCount);
      if (concrete._LastEvaluatedKey.is_Some) converted.LastEvaluatedKey = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput__M16_LastEvaluatedKey(concrete._LastEvaluatedKey);
      if (concrete._ConsumedCapacity.is_Some) converted.ConsumedCapacity = (Amazon.DynamoDBv2.Model.ConsumedCapacity)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput__M16_ConsumedCapacity(concrete._ConsumedCapacity); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IQueryOutput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput(Amazon.DynamoDBv2.Model.QueryResponse value)
    {

      System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>> var_items = value.Items != null ? value.Items : (System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>)null;
      int? var_count = value.Count != null ? value.Count : (int?)null;
      int? var_scannedCount = value.ScannedCount != null ? value.ScannedCount : (int?)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> var_lastEvaluatedKey = value.LastEvaluatedKey != null ? value.LastEvaluatedKey : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null;
      Amazon.DynamoDBv2.Model.ConsumedCapacity var_consumedCapacity = value.ConsumedCapacity != null ? value.ConsumedCapacity : (Amazon.DynamoDBv2.Model.ConsumedCapacity)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput__M5_Items(var_items), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput__M5_Count(var_count), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput__M12_ScannedCount(var_scannedCount), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput__M16_LastEvaluatedKey(var_lastEvaluatedKey), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput__M16_ConsumedCapacity(var_consumedCapacity));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static Amazon.DynamoDBv2.Model.DeleteItemRequest FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IDeleteItemInput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemInput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemInput)value; Amazon.DynamoDBv2.Model.DeleteItemRequest converted = new Amazon.DynamoDBv2.Model.DeleteItemRequest(); converted.TableName = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M9_TableName(concrete._TableName);
      converted.Key = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M3_Key(concrete._Key);
      if (concrete._Expected.is_Some) converted.Expected = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M8_Expected(concrete._Expected);
      if (concrete._ConditionalOperator.is_Some) converted.ConditionalOperator = (Amazon.DynamoDBv2.ConditionalOperator)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M19_ConditionalOperator(concrete._ConditionalOperator);
      if (concrete._ReturnValues.is_Some) converted.ReturnValues = (Amazon.DynamoDBv2.ReturnValue)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M12_ReturnValues(concrete._ReturnValues);
      if (concrete._ReturnConsumedCapacity.is_Some) converted.ReturnConsumedCapacity = (Amazon.DynamoDBv2.ReturnConsumedCapacity)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M22_ReturnConsumedCapacity(concrete._ReturnConsumedCapacity);
      if (concrete._ReturnItemCollectionMetrics.is_Some) converted.ReturnItemCollectionMetrics = (Amazon.DynamoDBv2.ReturnItemCollectionMetrics)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M27_ReturnItemCollectionMetrics(concrete._ReturnItemCollectionMetrics);
      if (concrete._ConditionExpression.is_Some) converted.ConditionExpression = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M19_ConditionExpression(concrete._ConditionExpression);
      if (concrete._ExpressionAttributeNames.is_Some) converted.ExpressionAttributeNames = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M24_ExpressionAttributeNames(concrete._ExpressionAttributeNames);
      if (concrete._ExpressionAttributeValues.is_Some) converted.ExpressionAttributeValues = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M25_ExpressionAttributeValues(concrete._ExpressionAttributeValues);
      if (concrete._ReturnValuesOnConditionCheckFailure.is_Some) converted.ReturnValuesOnConditionCheckFailure = (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M35_ReturnValuesOnConditionCheckFailure(concrete._ReturnValuesOnConditionCheckFailure); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IDeleteItemInput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput(Amazon.DynamoDBv2.Model.DeleteItemRequest value)
    {

      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue> var_expected = value.Expected != null ? value.Expected : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue>)null;
      Amazon.DynamoDBv2.ConditionalOperator var_conditionalOperator = value.ConditionalOperator != null ? value.ConditionalOperator : (Amazon.DynamoDBv2.ConditionalOperator)null;
      Amazon.DynamoDBv2.ReturnValue var_returnValues = value.ReturnValues != null ? value.ReturnValues : (Amazon.DynamoDBv2.ReturnValue)null;
      Amazon.DynamoDBv2.ReturnConsumedCapacity var_returnConsumedCapacity = value.ReturnConsumedCapacity != null ? value.ReturnConsumedCapacity : (Amazon.DynamoDBv2.ReturnConsumedCapacity)null;
      Amazon.DynamoDBv2.ReturnItemCollectionMetrics var_returnItemCollectionMetrics = value.ReturnItemCollectionMetrics != null ? value.ReturnItemCollectionMetrics : (Amazon.DynamoDBv2.ReturnItemCollectionMetrics)null;
      string var_conditionExpression = value.ConditionExpression != null ? value.ConditionExpression : (string)null;
      System.Collections.Generic.Dictionary<string, string> var_expressionAttributeNames = value.ExpressionAttributeNames != null ? value.ExpressionAttributeNames : (System.Collections.Generic.Dictionary<string, string>)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> var_expressionAttributeValues = value.ExpressionAttributeValues != null ? value.ExpressionAttributeValues : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null;
      Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure var_returnValuesOnConditionCheckFailure = value.ReturnValuesOnConditionCheckFailure != null ? value.ReturnValuesOnConditionCheckFailure : (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemInput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M9_TableName(value.TableName), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M3_Key(value.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M8_Expected(var_expected), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M19_ConditionalOperator(var_conditionalOperator), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M12_ReturnValues(var_returnValues), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M22_ReturnConsumedCapacity(var_returnConsumedCapacity), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M27_ReturnItemCollectionMetrics(var_returnItemCollectionMetrics), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M19_ConditionExpression(var_conditionExpression), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M24_ExpressionAttributeNames(var_expressionAttributeNames), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M25_ExpressionAttributeValues(var_expressionAttributeValues), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M35_ReturnValuesOnConditionCheckFailure(var_returnValuesOnConditionCheckFailure));
    }
    public static Amazon.DynamoDBv2.Model.BatchExecuteStatementRequest FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_BatchExecuteStatementInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchExecuteStatementInput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput)value; Amazon.DynamoDBv2.Model.BatchExecuteStatementRequest converted = new Amazon.DynamoDBv2.Model.BatchExecuteStatementRequest(); converted.Statements = (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.BatchStatementRequest>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_BatchExecuteStatementInput__M10_Statements(concrete._Statements);
      if (concrete._ReturnConsumedCapacity.is_Some) converted.ReturnConsumedCapacity = (Amazon.DynamoDBv2.ReturnConsumedCapacity)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_BatchExecuteStatementInput__M22_ReturnConsumedCapacity(concrete._ReturnConsumedCapacity); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchExecuteStatementInput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_BatchExecuteStatementInput(Amazon.DynamoDBv2.Model.BatchExecuteStatementRequest value)
    {

      Amazon.DynamoDBv2.ReturnConsumedCapacity var_returnConsumedCapacity = value.ReturnConsumedCapacity != null ? value.ReturnConsumedCapacity : (Amazon.DynamoDBv2.ReturnConsumedCapacity)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_BatchExecuteStatementInput__M10_Statements(value.Statements), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_BatchExecuteStatementInput__M22_ReturnConsumedCapacity(var_returnConsumedCapacity));
    }
    public static Amazon.DynamoDBv2.Model.BatchWriteItemResponse FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BatchWriteItemOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchWriteItemOutput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemOutput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemOutput)value; Amazon.DynamoDBv2.Model.BatchWriteItemResponse converted = new Amazon.DynamoDBv2.Model.BatchWriteItemResponse(); if (concrete._UnprocessedItems.is_Some) converted.UnprocessedItems = (System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.WriteRequest>>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BatchWriteItemOutput__M16_UnprocessedItems(concrete._UnprocessedItems);
      if (concrete._ItemCollectionMetrics.is_Some) converted.ItemCollectionMetrics = (System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemCollectionMetrics>>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BatchWriteItemOutput__M21_ItemCollectionMetrics(concrete._ItemCollectionMetrics);
      if (concrete._ConsumedCapacity.is_Some) converted.ConsumedCapacity = (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BatchWriteItemOutput__M16_ConsumedCapacity(concrete._ConsumedCapacity); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchWriteItemOutput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BatchWriteItemOutput(Amazon.DynamoDBv2.Model.BatchWriteItemResponse value)
    {

      System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.WriteRequest>> var_unprocessedItems = value.UnprocessedItems != null ? value.UnprocessedItems : (System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.WriteRequest>>)null;
      System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemCollectionMetrics>> var_itemCollectionMetrics = value.ItemCollectionMetrics != null ? value.ItemCollectionMetrics : (System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemCollectionMetrics>>)null;
      System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity> var_consumedCapacity = value.ConsumedCapacity != null ? value.ConsumedCapacity : (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemOutput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BatchWriteItemOutput__M16_UnprocessedItems(var_unprocessedItems), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BatchWriteItemOutput__M21_ItemCollectionMetrics(var_itemCollectionMetrics), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BatchWriteItemOutput__M16_ConsumedCapacity(var_consumedCapacity));
    }
    public static Amazon.DynamoDBv2.Model.ExecuteStatementRequest FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteStatementInput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput)value; Amazon.DynamoDBv2.Model.ExecuteStatementRequest converted = new Amazon.DynamoDBv2.Model.ExecuteStatementRequest(); converted.Statement = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M9_Statement(concrete._Statement);
      if (concrete._Parameters.is_Some) converted.Parameters = (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M10_Parameters(concrete._Parameters);
      if (concrete._ConsistentRead.is_Some) converted.ConsistentRead = (bool)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M14_ConsistentRead(concrete._ConsistentRead);
      if (concrete._NextToken.is_Some) converted.NextToken = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M9_NextToken(concrete._NextToken);
      if (concrete._ReturnConsumedCapacity.is_Some) converted.ReturnConsumedCapacity = (Amazon.DynamoDBv2.ReturnConsumedCapacity)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M22_ReturnConsumedCapacity(concrete._ReturnConsumedCapacity);
      if (concrete._Limit.is_Some) converted.Limit = (int)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M5_Limit(concrete._Limit);
      if (concrete._ReturnValuesOnConditionCheckFailure.is_Some) converted.ReturnValuesOnConditionCheckFailure = (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M35_ReturnValuesOnConditionCheckFailure(concrete._ReturnValuesOnConditionCheckFailure); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IExecuteStatementInput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput(Amazon.DynamoDBv2.Model.ExecuteStatementRequest value)
    {

      System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> var_parameters = value.Parameters != null ? value.Parameters : (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>)null;
      bool? var_consistentRead = value.ConsistentRead != null ? value.ConsistentRead : (bool?)null;
      string var_nextToken = value.NextToken != null ? value.NextToken : (string)null;
      Amazon.DynamoDBv2.ReturnConsumedCapacity var_returnConsumedCapacity = value.ReturnConsumedCapacity != null ? value.ReturnConsumedCapacity : (Amazon.DynamoDBv2.ReturnConsumedCapacity)null;
      int? var_limit = value.Limit != null ? value.Limit : (int?)null;
      Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure var_returnValuesOnConditionCheckFailure = value.ReturnValuesOnConditionCheckFailure != null ? value.ReturnValuesOnConditionCheckFailure : (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M9_Statement(value.Statement), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M10_Parameters(var_parameters), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M14_ConsistentRead(var_consistentRead), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M9_NextToken(var_nextToken), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M22_ReturnConsumedCapacity(var_returnConsumedCapacity), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M5_Limit(var_limit), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M35_ReturnValuesOnConditionCheckFailure(var_returnValuesOnConditionCheckFailure));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M5_value(pair.Value))
     ));
    }
    public static Amazon.DynamoDBv2.Model.GetItemRequest FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IGetItemInput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput)value; Amazon.DynamoDBv2.Model.GetItemRequest converted = new Amazon.DynamoDBv2.Model.GetItemRequest(); converted.TableName = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M9_TableName(concrete._TableName);
      converted.Key = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M3_Key(concrete._Key);
      if (concrete._AttributesToGet.is_Some) converted.AttributesToGet = (System.Collections.Generic.List<string>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M15_AttributesToGet(concrete._AttributesToGet);
      if (concrete._ConsistentRead.is_Some) converted.ConsistentRead = (bool)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M14_ConsistentRead(concrete._ConsistentRead);
      if (concrete._ReturnConsumedCapacity.is_Some) converted.ReturnConsumedCapacity = (Amazon.DynamoDBv2.ReturnConsumedCapacity)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M22_ReturnConsumedCapacity(concrete._ReturnConsumedCapacity);
      if (concrete._ProjectionExpression.is_Some) converted.ProjectionExpression = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M20_ProjectionExpression(concrete._ProjectionExpression);
      if (concrete._ExpressionAttributeNames.is_Some) converted.ExpressionAttributeNames = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M24_ExpressionAttributeNames(concrete._ExpressionAttributeNames); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IGetItemInput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput(Amazon.DynamoDBv2.Model.GetItemRequest value)
    {

      System.Collections.Generic.List<string> var_attributesToGet = value.AttributesToGet != null ? value.AttributesToGet : (System.Collections.Generic.List<string>)null;
      bool? var_consistentRead = value.ConsistentRead != null ? value.ConsistentRead : (bool?)null;
      Amazon.DynamoDBv2.ReturnConsumedCapacity var_returnConsumedCapacity = value.ReturnConsumedCapacity != null ? value.ReturnConsumedCapacity : (Amazon.DynamoDBv2.ReturnConsumedCapacity)null;
      string var_projectionExpression = value.ProjectionExpression != null ? value.ProjectionExpression : (string)null;
      System.Collections.Generic.Dictionary<string, string> var_expressionAttributeNames = value.ExpressionAttributeNames != null ? value.ExpressionAttributeNames : (System.Collections.Generic.Dictionary<string, string>)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M9_TableName(value.TableName), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M3_Key(value.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M15_AttributesToGet(var_attributesToGet), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M14_ConsistentRead(var_consistentRead), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M22_ReturnConsumedCapacity(var_returnConsumedCapacity), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M20_ProjectionExpression(var_projectionExpression), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M24_ExpressionAttributeNames(var_expressionAttributeNames));
    }
    public static Amazon.DynamoDBv2.Model.BatchExecuteStatementResponse FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_BatchExecuteStatementOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchExecuteStatementOutput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementOutput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementOutput)value; Amazon.DynamoDBv2.Model.BatchExecuteStatementResponse converted = new Amazon.DynamoDBv2.Model.BatchExecuteStatementResponse(); if (concrete._Responses.is_Some) converted.Responses = (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.BatchStatementResponse>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_BatchExecuteStatementOutput__M9_Responses(concrete._Responses);
      if (concrete._ConsumedCapacity.is_Some) converted.ConsumedCapacity = (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_BatchExecuteStatementOutput__M16_ConsumedCapacity(concrete._ConsumedCapacity); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchExecuteStatementOutput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_BatchExecuteStatementOutput(Amazon.DynamoDBv2.Model.BatchExecuteStatementResponse value)
    {

      System.Collections.Generic.List<Amazon.DynamoDBv2.Model.BatchStatementResponse> var_responses = value.Responses != null ? value.Responses : (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.BatchStatementResponse>)null;
      System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity> var_consumedCapacity = value.ConsumedCapacity != null ? value.ConsumedCapacity : (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementOutput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_BatchExecuteStatementOutput__M9_Responses(var_responses), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_BatchExecuteStatementOutput__M16_ConsumedCapacity(var_consumedCapacity));
    }
    public static Amazon.DynamoDBv2.Model.QueryRequest FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IQueryInput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput)value; Amazon.DynamoDBv2.Model.QueryRequest converted = new Amazon.DynamoDBv2.Model.QueryRequest(); converted.TableName = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M9_TableName(concrete._TableName);
      if (concrete._IndexName.is_Some) converted.IndexName = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M9_IndexName(concrete._IndexName);
      if (concrete._Select.is_Some) converted.Select = (Amazon.DynamoDBv2.Select)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M6_Select(concrete._Select);
      if (concrete._AttributesToGet.is_Some) converted.AttributesToGet = (System.Collections.Generic.List<string>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M15_AttributesToGet(concrete._AttributesToGet);
      if (concrete._Limit.is_Some) converted.Limit = (int)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M5_Limit(concrete._Limit);
      if (concrete._ConsistentRead.is_Some) converted.ConsistentRead = (bool)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M14_ConsistentRead(concrete._ConsistentRead);
      if (concrete._KeyConditions.is_Some) converted.KeyConditions = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M13_KeyConditions(concrete._KeyConditions);
      if (concrete._QueryFilter.is_Some) converted.QueryFilter = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M11_QueryFilter(concrete._QueryFilter);
      if (concrete._ConditionalOperator.is_Some) converted.ConditionalOperator = (Amazon.DynamoDBv2.ConditionalOperator)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M19_ConditionalOperator(concrete._ConditionalOperator);
      if (concrete._ScanIndexForward.is_Some) converted.ScanIndexForward = (bool)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M16_ScanIndexForward(concrete._ScanIndexForward);
      if (concrete._ExclusiveStartKey.is_Some) converted.ExclusiveStartKey = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M17_ExclusiveStartKey(concrete._ExclusiveStartKey);
      if (concrete._ReturnConsumedCapacity.is_Some) converted.ReturnConsumedCapacity = (Amazon.DynamoDBv2.ReturnConsumedCapacity)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M22_ReturnConsumedCapacity(concrete._ReturnConsumedCapacity);
      if (concrete._ProjectionExpression.is_Some) converted.ProjectionExpression = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M20_ProjectionExpression(concrete._ProjectionExpression);
      if (concrete._FilterExpression.is_Some) converted.FilterExpression = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M16_FilterExpression(concrete._FilterExpression);
      if (concrete._KeyConditionExpression.is_Some) converted.KeyConditionExpression = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M22_KeyConditionExpression(concrete._KeyConditionExpression);
      if (concrete._ExpressionAttributeNames.is_Some) converted.ExpressionAttributeNames = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M24_ExpressionAttributeNames(concrete._ExpressionAttributeNames);
      if (concrete._ExpressionAttributeValues.is_Some) converted.ExpressionAttributeValues = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M25_ExpressionAttributeValues(concrete._ExpressionAttributeValues); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IQueryInput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput(Amazon.DynamoDBv2.Model.QueryRequest value)
    {

      string var_indexName = value.IndexName != null ? value.IndexName : (string)null;
      Amazon.DynamoDBv2.Select var_select = value.Select != null ? value.Select : (Amazon.DynamoDBv2.Select)null;
      System.Collections.Generic.List<string> var_attributesToGet = value.AttributesToGet != null ? value.AttributesToGet : (System.Collections.Generic.List<string>)null;
      int? var_limit = value.IsLimitSet ? value.Limit : (int?)null;
      bool? var_consistentRead = value.ConsistentRead != null ? value.ConsistentRead : (bool?)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition> var_keyConditions = value.KeyConditions != null ? value.KeyConditions : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition>)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition> var_queryFilter = value.QueryFilter != null ? value.QueryFilter : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition>)null;
      Amazon.DynamoDBv2.ConditionalOperator var_conditionalOperator = value.ConditionalOperator != null ? value.ConditionalOperator : (Amazon.DynamoDBv2.ConditionalOperator)null;
      bool? var_scanIndexForward = value.ScanIndexForward != null ? value.ScanIndexForward : (bool?)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> var_exclusiveStartKey = value.ExclusiveStartKey != null ? value.ExclusiveStartKey : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null;
      Amazon.DynamoDBv2.ReturnConsumedCapacity var_returnConsumedCapacity = value.ReturnConsumedCapacity != null ? value.ReturnConsumedCapacity : (Amazon.DynamoDBv2.ReturnConsumedCapacity)null;
      string var_projectionExpression = value.ProjectionExpression != null ? value.ProjectionExpression : (string)null;
      string var_filterExpression = value.FilterExpression != null ? value.FilterExpression : (string)null;
      string var_keyConditionExpression = value.KeyConditionExpression != null ? value.KeyConditionExpression : (string)null;
      System.Collections.Generic.Dictionary<string, string> var_expressionAttributeNames = value.ExpressionAttributeNames != null ? value.ExpressionAttributeNames : (System.Collections.Generic.Dictionary<string, string>)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> var_expressionAttributeValues = value.ExpressionAttributeValues != null ? value.ExpressionAttributeValues : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M9_TableName(value.TableName), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M9_IndexName(var_indexName), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M6_Select(var_select), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M15_AttributesToGet(var_attributesToGet), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M5_Limit(var_limit), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M14_ConsistentRead(var_consistentRead), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M13_KeyConditions(var_keyConditions), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M11_QueryFilter(var_queryFilter), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M19_ConditionalOperator(var_conditionalOperator), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M16_ScanIndexForward(var_scanIndexForward), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M17_ExclusiveStartKey(var_exclusiveStartKey), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M22_ReturnConsumedCapacity(var_returnConsumedCapacity), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M20_ProjectionExpression(var_projectionExpression), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M16_FilterExpression(var_filterExpression), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M22_KeyConditionExpression(var_keyConditionExpression), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M24_ExpressionAttributeNames(var_expressionAttributeNames), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M25_ExpressionAttributeValues(var_expressionAttributeValues));
    }
    public static Amazon.DynamoDBv2.Model.ScanResponse FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IScanOutput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput)value; Amazon.DynamoDBv2.Model.ScanResponse converted = new Amazon.DynamoDBv2.Model.ScanResponse(); if (concrete._Items.is_Some) converted.Items = (System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput__M5_Items(concrete._Items);
      if (concrete._Count.is_Some) converted.Count = (int)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput__M5_Count(concrete._Count);
      if (concrete._ScannedCount.is_Some) converted.ScannedCount = (int)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput__M12_ScannedCount(concrete._ScannedCount);
      if (concrete._LastEvaluatedKey.is_Some) converted.LastEvaluatedKey = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput__M16_LastEvaluatedKey(concrete._LastEvaluatedKey);
      if (concrete._ConsumedCapacity.is_Some) converted.ConsumedCapacity = (Amazon.DynamoDBv2.Model.ConsumedCapacity)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput__M16_ConsumedCapacity(concrete._ConsumedCapacity); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IScanOutput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput(Amazon.DynamoDBv2.Model.ScanResponse value)
    {

      System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>> var_items = value.Items != null ? value.Items : (System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>)null;
      int? var_count = value.Count != null ? value.Count : (int?)null;
      int? var_scannedCount = value.ScannedCount != null ? value.ScannedCount : (int?)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> var_lastEvaluatedKey = value.LastEvaluatedKey != null ? value.LastEvaluatedKey : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null;
      Amazon.DynamoDBv2.Model.ConsumedCapacity var_consumedCapacity = value.ConsumedCapacity != null ? value.ConsumedCapacity : (Amazon.DynamoDBv2.Model.ConsumedCapacity)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput__M5_Items(var_items), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput__M5_Count(var_count), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput__M12_ScannedCount(var_scannedCount), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput__M16_LastEvaluatedKey(var_lastEvaluatedKey), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput__M16_ConsumedCapacity(var_consumedCapacity));
    }
    public static Amazon.DynamoDBv2.Model.BatchGetItemResponse FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetItemOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchGetItemOutput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemOutput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemOutput)value; Amazon.DynamoDBv2.Model.BatchGetItemResponse converted = new Amazon.DynamoDBv2.Model.BatchGetItemResponse(); if (concrete._Responses.is_Some) converted.Responses = (System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetItemOutput__M9_Responses(concrete._Responses);
      if (concrete._UnprocessedKeys.is_Some) converted.UnprocessedKeys = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.KeysAndAttributes>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetItemOutput__M15_UnprocessedKeys(concrete._UnprocessedKeys);
      if (concrete._ConsumedCapacity.is_Some) converted.ConsumedCapacity = (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetItemOutput__M16_ConsumedCapacity(concrete._ConsumedCapacity); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchGetItemOutput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetItemOutput(Amazon.DynamoDBv2.Model.BatchGetItemResponse value)
    {

      System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>> var_responses = value.Responses != null ? value.Responses : (System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>>)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.KeysAndAttributes> var_unprocessedKeys = value.UnprocessedKeys != null ? value.UnprocessedKeys : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.KeysAndAttributes>)null;
      System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity> var_consumedCapacity = value.ConsumedCapacity != null ? value.ConsumedCapacity : (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemOutput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetItemOutput__M9_Responses(var_responses), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetItemOutput__M15_UnprocessedKeys(var_unprocessedKeys), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetItemOutput__M16_ConsumedCapacity(var_consumedCapacity));
    }
    public static Amazon.DynamoDBv2.Model.TransactGetItemsResponse FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_TransactGetItemsOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItemsOutput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsOutput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsOutput)value; Amazon.DynamoDBv2.Model.TransactGetItemsResponse converted = new Amazon.DynamoDBv2.Model.TransactGetItemsResponse(); if (concrete._ConsumedCapacity.is_Some) converted.ConsumedCapacity = (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_TransactGetItemsOutput__M16_ConsumedCapacity(concrete._ConsumedCapacity);
      if (concrete._Responses.is_Some) converted.Responses = (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemResponse>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_TransactGetItemsOutput__M9_Responses(concrete._Responses); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItemsOutput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_TransactGetItemsOutput(Amazon.DynamoDBv2.Model.TransactGetItemsResponse value)
    {

      System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity> var_consumedCapacity = value.ConsumedCapacity != null ? value.ConsumedCapacity : (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)null;
      System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemResponse> var_responses = value.Responses != null ? value.Responses : (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemResponse>)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsOutput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_TransactGetItemsOutput__M16_ConsumedCapacity(var_consumedCapacity), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_TransactGetItemsOutput__M9_Responses(var_responses));
    }
    public static Amazon.DynamoDBv2.Model.UpdateItemResponse FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateItemOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._IUpdateItemOutput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemOutput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemOutput)value; Amazon.DynamoDBv2.Model.UpdateItemResponse converted = new Amazon.DynamoDBv2.Model.UpdateItemResponse(); if (concrete._Attributes.is_Some) converted.Attributes = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateItemOutput__M10_Attributes(concrete._Attributes);
      if (concrete._ConsumedCapacity.is_Some) converted.ConsumedCapacity = (Amazon.DynamoDBv2.Model.ConsumedCapacity)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateItemOutput__M16_ConsumedCapacity(concrete._ConsumedCapacity);
      if (concrete._ItemCollectionMetrics.is_Some) converted.ItemCollectionMetrics = (Amazon.DynamoDBv2.Model.ItemCollectionMetrics)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateItemOutput__M21_ItemCollectionMetrics(concrete._ItemCollectionMetrics); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IUpdateItemOutput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateItemOutput(Amazon.DynamoDBv2.Model.UpdateItemResponse value)
    {

      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> var_attributes = value.Attributes != null ? value.Attributes : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null;
      Amazon.DynamoDBv2.Model.ConsumedCapacity var_consumedCapacity = value.ConsumedCapacity != null ? value.ConsumedCapacity : (Amazon.DynamoDBv2.Model.ConsumedCapacity)null;
      Amazon.DynamoDBv2.Model.ItemCollectionMetrics var_itemCollectionMetrics = value.ItemCollectionMetrics != null ? value.ItemCollectionMetrics : (Amazon.DynamoDBv2.Model.ItemCollectionMetrics)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemOutput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateItemOutput__M10_Attributes(var_attributes), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateItemOutput__M16_ConsumedCapacity(var_consumedCapacity), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateItemOutput__M21_ItemCollectionMetrics(var_itemCollectionMetrics));
    }
    public static Amazon.DynamoDBv2.Model.TransactWriteItemsResponse FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_TransactWriteItemsOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItemsOutput value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsOutput concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsOutput)value; Amazon.DynamoDBv2.Model.TransactWriteItemsResponse converted = new Amazon.DynamoDBv2.Model.TransactWriteItemsResponse(); if (concrete._ConsumedCapacity.is_Some) converted.ConsumedCapacity = (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_TransactWriteItemsOutput__M16_ConsumedCapacity(concrete._ConsumedCapacity);
      if (concrete._ItemCollectionMetrics.is_Some) converted.ItemCollectionMetrics = (System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemCollectionMetrics>>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_TransactWriteItemsOutput__M21_ItemCollectionMetrics(concrete._ItemCollectionMetrics); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItemsOutput ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_TransactWriteItemsOutput(Amazon.DynamoDBv2.Model.TransactWriteItemsResponse value)
    {

      System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity> var_consumedCapacity = value.ConsumedCapacity != null ? value.ConsumedCapacity : (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)null;
      System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemCollectionMetrics>> var_itemCollectionMetrics = value.ItemCollectionMetrics != null ? value.ItemCollectionMetrics : (System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemCollectionMetrics>>)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsOutput(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_TransactWriteItemsOutput__M16_ConsumedCapacity(var_consumedCapacity), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_TransactWriteItemsOutput__M21_ItemCollectionMetrics(var_itemCollectionMetrics));
    }
    public static int FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_VersionNumber(int value)
    {
      return value;
    }
    public static int ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S13_VersionNumber(int value)
    {
      return value;
    }
    public static System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.WriteRequest>> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchWriteItemInput__M12_RequestItems(Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IWriteRequest>> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_BatchWriteItemRequestMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IWriteRequest>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchWriteItemInput__M12_RequestItems(System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.WriteRequest>> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_BatchWriteItemRequestMap(value);
    }
    public static Amazon.DynamoDBv2.ReturnConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchWriteItemInput__M22_ReturnConsumedCapacity(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnConsumedCapacity)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchWriteItemInput__M22_ReturnConsumedCapacity(Amazon.DynamoDBv2.ReturnConsumedCapacity value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity((Amazon.DynamoDBv2.ReturnConsumedCapacity)value));
    }
    public static Amazon.DynamoDBv2.ReturnItemCollectionMetrics FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchWriteItemInput__M27_ReturnItemCollectionMetrics(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnItemCollectionMetrics> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnItemCollectionMetrics)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ReturnItemCollectionMetrics(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnItemCollectionMetrics> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchWriteItemInput__M27_ReturnItemCollectionMetrics(Amazon.DynamoDBv2.ReturnItemCollectionMetrics value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnItemCollectionMetrics>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnItemCollectionMetrics>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ReturnItemCollectionMetrics((Amazon.DynamoDBv2.ReturnItemCollectionMetrics)value));
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.TransactGetItem> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactGetItemsInput__M13_TransactItems(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItem> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_TransactGetItemList(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItem> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactGetItemsInput__M13_TransactItems(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.TransactGetItem> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_TransactGetItemList(value);
    }
    public static Amazon.DynamoDBv2.ReturnConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactGetItemsInput__M22_ReturnConsumedCapacity(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnConsumedCapacity)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactGetItemsInput__M22_ReturnConsumedCapacity(Amazon.DynamoDBv2.ReturnConsumedCapacity value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity((Amazon.DynamoDBv2.ReturnConsumedCapacity)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M9_TableName(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M9_TableName(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M4_Item(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_PutItemInputAttributeMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M4_Item(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_PutItemInputAttributeMap(value);
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M8_Expected(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IExpectedAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ExpectedAttributeMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IExpectedAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M8_Expected(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IExpectedAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IExpectedAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ExpectedAttributeMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.ReturnValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M12_ReturnValues(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValue> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnValue)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_ReturnValue(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M12_ReturnValues(Amazon.DynamoDBv2.ReturnValue value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValue>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValue>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_ReturnValue((Amazon.DynamoDBv2.ReturnValue)value));
    }
    public static Amazon.DynamoDBv2.ReturnConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M22_ReturnConsumedCapacity(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnConsumedCapacity)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M22_ReturnConsumedCapacity(Amazon.DynamoDBv2.ReturnConsumedCapacity value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity((Amazon.DynamoDBv2.ReturnConsumedCapacity)value));
    }
    public static Amazon.DynamoDBv2.ReturnItemCollectionMetrics FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M27_ReturnItemCollectionMetrics(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnItemCollectionMetrics> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnItemCollectionMetrics)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ReturnItemCollectionMetrics(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnItemCollectionMetrics> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M27_ReturnItemCollectionMetrics(Amazon.DynamoDBv2.ReturnItemCollectionMetrics value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnItemCollectionMetrics>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnItemCollectionMetrics>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ReturnItemCollectionMetrics((Amazon.DynamoDBv2.ReturnItemCollectionMetrics)value));
    }
    public static Amazon.DynamoDBv2.ConditionalOperator FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M19_ConditionalOperator(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionalOperator> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ConditionalOperator)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionalOperator(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionalOperator> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M19_ConditionalOperator(Amazon.DynamoDBv2.ConditionalOperator value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionalOperator>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionalOperator>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionalOperator((Amazon.DynamoDBv2.ConditionalOperator)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M19_ConditionExpression(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionExpression(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M19_ConditionExpression(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionExpression((string)value));
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M24_ExpressionAttributeNames(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, string>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M24_ExpressionAttributeNames(System.Collections.Generic.Dictionary<string, string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap((System.Collections.Generic.Dictionary<string, string>)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M25_ExpressionAttributeValues(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M25_ExpressionAttributeValues(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M35_ReturnValuesOnConditionCheckFailure(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S35_ReturnValuesOnConditionCheckFailure(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_PutItemInput__M35_ReturnValuesOnConditionCheckFailure(Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S35_ReturnValuesOnConditionCheckFailure((Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M9_TableName(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M9_TableName(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M3_Key(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M3_Key(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValueUpdate> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M16_AttributeUpdates(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValueUpdate>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValueUpdate>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_AttributeUpdates(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValueUpdate>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M16_AttributeUpdates(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValueUpdate> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValueUpdate>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValueUpdate>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_AttributeUpdates((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValueUpdate>)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M8_Expected(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IExpectedAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ExpectedAttributeMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IExpectedAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M8_Expected(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IExpectedAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IExpectedAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ExpectedAttributeMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.ConditionalOperator FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M19_ConditionalOperator(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionalOperator> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ConditionalOperator)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionalOperator(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionalOperator> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M19_ConditionalOperator(Amazon.DynamoDBv2.ConditionalOperator value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionalOperator>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionalOperator>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionalOperator((Amazon.DynamoDBv2.ConditionalOperator)value));
    }
    public static Amazon.DynamoDBv2.ReturnValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M12_ReturnValues(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValue> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnValue)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_ReturnValue(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M12_ReturnValues(Amazon.DynamoDBv2.ReturnValue value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValue>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValue>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_ReturnValue((Amazon.DynamoDBv2.ReturnValue)value));
    }
    public static Amazon.DynamoDBv2.ReturnConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M22_ReturnConsumedCapacity(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnConsumedCapacity)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M22_ReturnConsumedCapacity(Amazon.DynamoDBv2.ReturnConsumedCapacity value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity((Amazon.DynamoDBv2.ReturnConsumedCapacity)value));
    }
    public static Amazon.DynamoDBv2.ReturnItemCollectionMetrics FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M27_ReturnItemCollectionMetrics(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnItemCollectionMetrics> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnItemCollectionMetrics)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ReturnItemCollectionMetrics(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnItemCollectionMetrics> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M27_ReturnItemCollectionMetrics(Amazon.DynamoDBv2.ReturnItemCollectionMetrics value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnItemCollectionMetrics>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnItemCollectionMetrics>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ReturnItemCollectionMetrics((Amazon.DynamoDBv2.ReturnItemCollectionMetrics)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M16_UpdateExpression(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateExpression(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M16_UpdateExpression(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateExpression((string)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M19_ConditionExpression(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionExpression(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M19_ConditionExpression(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionExpression((string)value));
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M24_ExpressionAttributeNames(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, string>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M24_ExpressionAttributeNames(System.Collections.Generic.Dictionary<string, string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap((System.Collections.Generic.Dictionary<string, string>)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M25_ExpressionAttributeValues(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M25_ExpressionAttributeValues(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M35_ReturnValuesOnConditionCheckFailure(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S35_ReturnValuesOnConditionCheckFailure(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_UpdateItemInput__M35_ReturnValuesOnConditionCheckFailure(Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S35_ReturnValuesOnConditionCheckFailure((Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)value));
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.TransactWriteItem> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput__M13_TransactItems(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItem> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactWriteItemList(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItem> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput__M13_TransactItems(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.TransactWriteItem> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactWriteItemList(value);
    }
    public static Amazon.DynamoDBv2.ReturnConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput__M22_ReturnConsumedCapacity(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnConsumedCapacity)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput__M22_ReturnConsumedCapacity(Amazon.DynamoDBv2.ReturnConsumedCapacity value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity((Amazon.DynamoDBv2.ReturnConsumedCapacity)value));
    }
    public static Amazon.DynamoDBv2.ReturnItemCollectionMetrics FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput__M27_ReturnItemCollectionMetrics(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnItemCollectionMetrics> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnItemCollectionMetrics)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ReturnItemCollectionMetrics(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnItemCollectionMetrics> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput__M27_ReturnItemCollectionMetrics(Amazon.DynamoDBv2.ReturnItemCollectionMetrics value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnItemCollectionMetrics>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnItemCollectionMetrics>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ReturnItemCollectionMetrics((Amazon.DynamoDBv2.ReturnItemCollectionMetrics)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput__M18_ClientRequestToken(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ClientRequestToken(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_TransactWriteItemsInput__M18_ClientRequestToken(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ClientRequestToken((string)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M9_TableName(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M9_TableName(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M9_IndexName(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_IndexName(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M9_IndexName(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_IndexName((string)value));
    }
    public static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M15_AttributesToGet(Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<string>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M15_AttributesToGet(System.Collections.Generic.List<string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<char>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList((System.Collections.Generic.List<string>)value));
    }
    public static int? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M5_Limit(Wrappers_Compile._IOption<int> value)
    {
      return value.is_None ? (int?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_PositiveIntegerObject(value.Extract());
    }
    public static Wrappers_Compile._IOption<int> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M5_Limit(int? value)
    {
      return value == null ? Wrappers_Compile.Option<int>.create_None() : Wrappers_Compile.Option<int>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_PositiveIntegerObject((int)value));
    }
    public static Amazon.DynamoDBv2.Select FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M6_Select(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._ISelect> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.Select)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Select(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._ISelect> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M6_Select(Amazon.DynamoDBv2.Select value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._ISelect>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._ISelect>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Select((Amazon.DynamoDBv2.Select)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M10_ScanFilter(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_FilterConditionMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M10_ScanFilter(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_FilterConditionMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition>)value));
    }
    public static Amazon.DynamoDBv2.ConditionalOperator FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M19_ConditionalOperator(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionalOperator> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ConditionalOperator)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionalOperator(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionalOperator> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M19_ConditionalOperator(Amazon.DynamoDBv2.ConditionalOperator value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionalOperator>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionalOperator>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionalOperator((Amazon.DynamoDBv2.ConditionalOperator)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M17_ExclusiveStartKey(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M17_ExclusiveStartKey(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.ReturnConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M22_ReturnConsumedCapacity(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnConsumedCapacity)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M22_ReturnConsumedCapacity(Amazon.DynamoDBv2.ReturnConsumedCapacity value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity((Amazon.DynamoDBv2.ReturnConsumedCapacity)value));
    }
    public static int? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M13_TotalSegments(Wrappers_Compile._IOption<int> value)
    {
      return value.is_None ? (int?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_ScanTotalSegments(value.Extract());
    }
    public static Wrappers_Compile._IOption<int> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M13_TotalSegments(int? value)
    {
      return value == null ? Wrappers_Compile.Option<int>.create_None() : Wrappers_Compile.Option<int>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_ScanTotalSegments((int)value));
    }
    public static int? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M7_Segment(Wrappers_Compile._IOption<int> value)
    {
      return value.is_None ? (int?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_ScanSegment(value.Extract());
    }
    public static Wrappers_Compile._IOption<int> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M7_Segment(int? value)
    {
      return value == null ? Wrappers_Compile.Option<int>.create_None() : Wrappers_Compile.Option<int>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_ScanSegment((int)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M20_ProjectionExpression(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ProjectionExpression(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M20_ProjectionExpression(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ProjectionExpression((string)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M16_FilterExpression(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionExpression(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M16_FilterExpression(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionExpression((string)value));
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M24_ExpressionAttributeNames(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, string>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M24_ExpressionAttributeNames(System.Collections.Generic.Dictionary<string, string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap((System.Collections.Generic.Dictionary<string, string>)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M25_ExpressionAttributeValues(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M25_ExpressionAttributeValues(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static bool? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M14_ConsistentRead(Wrappers_Compile._IOption<bool> value)
    {
      return value.is_None ? (bool?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConsistentRead(value.Extract());
    }
    public static Wrappers_Compile._IOption<bool> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_ScanInput__M14_ConsistentRead(bool? value)
    {
      return value == null ? Wrappers_Compile.Option<bool>.create_None() : Wrappers_Compile.Option<bool>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConsistentRead((bool)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_DeleteItemOutput__M10_Attributes(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_DeleteItemOutput__M10_Attributes(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.Model.ConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_DeleteItemOutput__M16_ConsumedCapacity(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.Model.ConsumedCapacity)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_DeleteItemOutput__M16_ConsumedCapacity(Amazon.DynamoDBv2.Model.ConsumedCapacity value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity((Amazon.DynamoDBv2.Model.ConsumedCapacity)value));
    }
    public static Amazon.DynamoDBv2.Model.ItemCollectionMetrics FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_DeleteItemOutput__M21_ItemCollectionMetrics(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.Model.ItemCollectionMetrics)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ItemCollectionMetrics(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_DeleteItemOutput__M21_ItemCollectionMetrics(Amazon.DynamoDBv2.Model.ItemCollectionMetrics value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ItemCollectionMetrics((Amazon.DynamoDBv2.Model.ItemCollectionMetrics)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_PutItemOutput__M10_Attributes(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_PutItemOutput__M10_Attributes(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.Model.ConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_PutItemOutput__M16_ConsumedCapacity(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.Model.ConsumedCapacity)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_PutItemOutput__M16_ConsumedCapacity(Amazon.DynamoDBv2.Model.ConsumedCapacity value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity((Amazon.DynamoDBv2.Model.ConsumedCapacity)value));
    }
    public static Amazon.DynamoDBv2.Model.ItemCollectionMetrics FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_PutItemOutput__M21_ItemCollectionMetrics(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.Model.ItemCollectionMetrics)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ItemCollectionMetrics(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_PutItemOutput__M21_ItemCollectionMetrics(Amazon.DynamoDBv2.Model.ItemCollectionMetrics value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ItemCollectionMetrics((Amazon.DynamoDBv2.Model.ItemCollectionMetrics)value));
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ParameterizedStatement> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ExecuteTransactionInput__M18_TransactStatements(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IParameterizedStatement> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ParameterizedStatements(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IParameterizedStatement> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ExecuteTransactionInput__M18_TransactStatements(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ParameterizedStatement> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ParameterizedStatements(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ExecuteTransactionInput__M18_ClientRequestToken(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ClientRequestToken(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ExecuteTransactionInput__M18_ClientRequestToken(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ClientRequestToken((string)value));
    }
    public static Amazon.DynamoDBv2.ReturnConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ExecuteTransactionInput__M22_ReturnConsumedCapacity(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnConsumedCapacity)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ExecuteTransactionInput__M22_ReturnConsumedCapacity(Amazon.DynamoDBv2.ReturnConsumedCapacity value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity((Amazon.DynamoDBv2.ReturnConsumedCapacity)value));
    }
    public static System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExecuteStatementOutput__M5_Items(Wrappers_Compile._IOption<Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_ItemList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExecuteStatementOutput__M5_Items(System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_ItemList((System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExecuteStatementOutput__M9_NextToken(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_PartiQLNextToken(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExecuteStatementOutput__M9_NextToken(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_PartiQLNextToken((string)value));
    }
    public static Amazon.DynamoDBv2.Model.ConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExecuteStatementOutput__M16_ConsumedCapacity(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.Model.ConsumedCapacity)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExecuteStatementOutput__M16_ConsumedCapacity(Amazon.DynamoDBv2.Model.ConsumedCapacity value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity((Amazon.DynamoDBv2.Model.ConsumedCapacity)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExecuteStatementOutput__M16_LastEvaluatedKey(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExecuteStatementOutput__M16_LastEvaluatedKey(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemResponse> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ExecuteTransactionOutput__M9_Responses(Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemResponse>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemResponse>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ItemResponseList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemResponse>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ExecuteTransactionOutput__M9_Responses(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemResponse> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemResponse>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemResponse>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ItemResponseList((System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemResponse>)value));
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ExecuteTransactionOutput__M16_ConsumedCapacity(Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ConsumedCapacityMultiple(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ExecuteTransactionOutput__M16_ConsumedCapacity(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ConsumedCapacityMultiple((System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_GetItemOutput__M4_Item(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_GetItemOutput__M4_Item(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.Model.ConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_GetItemOutput__M16_ConsumedCapacity(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.Model.ConsumedCapacity)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_GetItemOutput__M16_ConsumedCapacity(Amazon.DynamoDBv2.Model.ConsumedCapacity value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity((Amazon.DynamoDBv2.Model.ConsumedCapacity)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.KeysAndAttributes> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_BatchGetItemInput__M12_RequestItems(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IKeysAndAttributes> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetRequestMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IKeysAndAttributes> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_BatchGetItemInput__M12_RequestItems(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.KeysAndAttributes> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetRequestMap(value);
    }
    public static Amazon.DynamoDBv2.ReturnConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_BatchGetItemInput__M22_ReturnConsumedCapacity(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnConsumedCapacity)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_BatchGetItemInput__M22_ReturnConsumedCapacity(Amazon.DynamoDBv2.ReturnConsumedCapacity value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity((Amazon.DynamoDBv2.ReturnConsumedCapacity)value));
    }
    public static System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput__M5_Items(Wrappers_Compile._IOption<Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_ItemList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput__M5_Items(System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_ItemList((System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>)value));
    }
    public static int? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput__M5_Count(Wrappers_Compile._IOption<int> value)
    {
      return value.is_None ? (int?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S7_Integer(value.Extract());
    }
    public static Wrappers_Compile._IOption<int> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput__M5_Count(int? value)
    {
      return value == null ? Wrappers_Compile.Option<int>.create_None() : Wrappers_Compile.Option<int>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S7_Integer((int)value));
    }
    public static int? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput__M12_ScannedCount(Wrappers_Compile._IOption<int> value)
    {
      return value.is_None ? (int?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S7_Integer(value.Extract());
    }
    public static Wrappers_Compile._IOption<int> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput__M12_ScannedCount(int? value)
    {
      return value == null ? Wrappers_Compile.Option<int>.create_None() : Wrappers_Compile.Option<int>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S7_Integer((int)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput__M16_LastEvaluatedKey(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput__M16_LastEvaluatedKey(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.Model.ConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput__M16_ConsumedCapacity(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.Model.ConsumedCapacity)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_QueryOutput__M16_ConsumedCapacity(Amazon.DynamoDBv2.Model.ConsumedCapacity value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity((Amazon.DynamoDBv2.Model.ConsumedCapacity)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M9_TableName(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M9_TableName(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M3_Key(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M3_Key(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M8_Expected(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IExpectedAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ExpectedAttributeMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IExpectedAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M8_Expected(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IExpectedAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IExpectedAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ExpectedAttributeMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.ConditionalOperator FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M19_ConditionalOperator(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionalOperator> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ConditionalOperator)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionalOperator(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionalOperator> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M19_ConditionalOperator(Amazon.DynamoDBv2.ConditionalOperator value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionalOperator>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionalOperator>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionalOperator((Amazon.DynamoDBv2.ConditionalOperator)value));
    }
    public static Amazon.DynamoDBv2.ReturnValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M12_ReturnValues(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValue> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnValue)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_ReturnValue(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M12_ReturnValues(Amazon.DynamoDBv2.ReturnValue value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValue>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValue>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_ReturnValue((Amazon.DynamoDBv2.ReturnValue)value));
    }
    public static Amazon.DynamoDBv2.ReturnConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M22_ReturnConsumedCapacity(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnConsumedCapacity)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M22_ReturnConsumedCapacity(Amazon.DynamoDBv2.ReturnConsumedCapacity value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity((Amazon.DynamoDBv2.ReturnConsumedCapacity)value));
    }
    public static Amazon.DynamoDBv2.ReturnItemCollectionMetrics FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M27_ReturnItemCollectionMetrics(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnItemCollectionMetrics> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnItemCollectionMetrics)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ReturnItemCollectionMetrics(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnItemCollectionMetrics> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M27_ReturnItemCollectionMetrics(Amazon.DynamoDBv2.ReturnItemCollectionMetrics value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnItemCollectionMetrics>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnItemCollectionMetrics>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ReturnItemCollectionMetrics((Amazon.DynamoDBv2.ReturnItemCollectionMetrics)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M19_ConditionExpression(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionExpression(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M19_ConditionExpression(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionExpression((string)value));
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M24_ExpressionAttributeNames(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, string>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M24_ExpressionAttributeNames(System.Collections.Generic.Dictionary<string, string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap((System.Collections.Generic.Dictionary<string, string>)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M25_ExpressionAttributeValues(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M25_ExpressionAttributeValues(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M35_ReturnValuesOnConditionCheckFailure(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S35_ReturnValuesOnConditionCheckFailure(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_DeleteItemInput__M35_ReturnValuesOnConditionCheckFailure(Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S35_ReturnValuesOnConditionCheckFailure((Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)value));
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.BatchStatementRequest> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_BatchExecuteStatementInput__M10_Statements(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementRequest> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_PartiQLBatchRequest(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementRequest> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_BatchExecuteStatementInput__M10_Statements(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.BatchStatementRequest> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_PartiQLBatchRequest(value);
    }
    public static Amazon.DynamoDBv2.ReturnConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_BatchExecuteStatementInput__M22_ReturnConsumedCapacity(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnConsumedCapacity)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_BatchExecuteStatementInput__M22_ReturnConsumedCapacity(Amazon.DynamoDBv2.ReturnConsumedCapacity value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity((Amazon.DynamoDBv2.ReturnConsumedCapacity)value));
    }
    public static System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.WriteRequest>> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BatchWriteItemOutput__M16_UnprocessedItems(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IWriteRequest>>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.WriteRequest>>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_BatchWriteItemRequestMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IWriteRequest>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BatchWriteItemOutput__M16_UnprocessedItems(System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.WriteRequest>> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IWriteRequest>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IWriteRequest>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_BatchWriteItemRequestMap((System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.WriteRequest>>)value));
    }
    public static System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemCollectionMetrics>> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BatchWriteItemOutput__M21_ItemCollectionMetrics(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics>>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemCollectionMetrics>>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionMetricsPerTable(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BatchWriteItemOutput__M21_ItemCollectionMetrics(System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemCollectionMetrics>> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionMetricsPerTable((System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemCollectionMetrics>>)value));
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BatchWriteItemOutput__M16_ConsumedCapacity(Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ConsumedCapacityMultiple(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BatchWriteItemOutput__M16_ConsumedCapacity(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ConsumedCapacityMultiple((System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M9_Statement(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_PartiQLStatement(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M9_Statement(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_PartiQLStatement(value);
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M10_Parameters(Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_PreparedStatementParameters(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M10_Parameters(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_PreparedStatementParameters((System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static bool? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M14_ConsistentRead(Wrappers_Compile._IOption<bool> value)
    {
      return value.is_None ? (bool?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConsistentRead(value.Extract());
    }
    public static Wrappers_Compile._IOption<bool> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M14_ConsistentRead(bool? value)
    {
      return value == null ? Wrappers_Compile.Option<bool>.create_None() : Wrappers_Compile.Option<bool>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConsistentRead((bool)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M9_NextToken(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_PartiQLNextToken(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M9_NextToken(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_PartiQLNextToken((string)value));
    }
    public static Amazon.DynamoDBv2.ReturnConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M22_ReturnConsumedCapacity(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnConsumedCapacity)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M22_ReturnConsumedCapacity(Amazon.DynamoDBv2.ReturnConsumedCapacity value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity((Amazon.DynamoDBv2.ReturnConsumedCapacity)value));
    }
    public static int? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M5_Limit(Wrappers_Compile._IOption<int> value)
    {
      return value.is_None ? (int?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_PositiveIntegerObject(value.Extract());
    }
    public static Wrappers_Compile._IOption<int> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M5_Limit(int? value)
    {
      return value == null ? Wrappers_Compile.Option<int>.create_None() : Wrappers_Compile.Option<int>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_PositiveIntegerObject((int)value));
    }
    public static Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M35_ReturnValuesOnConditionCheckFailure(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S35_ReturnValuesOnConditionCheckFailure(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ExecuteStatementInput__M35_ReturnValuesOnConditionCheckFailure(Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S35_ReturnValuesOnConditionCheckFailure((Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M5_value(software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap__M5_value(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M9_TableName(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M9_TableName(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M3_Key(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M3_Key(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    public static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M15_AttributesToGet(Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<string>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M15_AttributesToGet(System.Collections.Generic.List<string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<char>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList((System.Collections.Generic.List<string>)value));
    }
    public static bool? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M14_ConsistentRead(Wrappers_Compile._IOption<bool> value)
    {
      return value.is_None ? (bool?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConsistentRead(value.Extract());
    }
    public static Wrappers_Compile._IOption<bool> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M14_ConsistentRead(bool? value)
    {
      return value == null ? Wrappers_Compile.Option<bool>.create_None() : Wrappers_Compile.Option<bool>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConsistentRead((bool)value));
    }
    public static Amazon.DynamoDBv2.ReturnConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M22_ReturnConsumedCapacity(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnConsumedCapacity)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M22_ReturnConsumedCapacity(Amazon.DynamoDBv2.ReturnConsumedCapacity value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity((Amazon.DynamoDBv2.ReturnConsumedCapacity)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M20_ProjectionExpression(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ProjectionExpression(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M20_ProjectionExpression(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ProjectionExpression((string)value));
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M24_ExpressionAttributeNames(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, string>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_GetItemInput__M24_ExpressionAttributeNames(System.Collections.Generic.Dictionary<string, string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap((System.Collections.Generic.Dictionary<string, string>)value));
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.BatchStatementResponse> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_BatchExecuteStatementOutput__M9_Responses(Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementResponse>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.BatchStatementResponse>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_PartiQLBatchResponse(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementResponse>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_BatchExecuteStatementOutput__M9_Responses(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.BatchStatementResponse> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementResponse>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementResponse>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_PartiQLBatchResponse((System.Collections.Generic.List<Amazon.DynamoDBv2.Model.BatchStatementResponse>)value));
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_BatchExecuteStatementOutput__M16_ConsumedCapacity(Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ConsumedCapacityMultiple(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_BatchExecuteStatementOutput__M16_ConsumedCapacity(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ConsumedCapacityMultiple((System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M9_TableName(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M9_TableName(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M9_IndexName(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_IndexName(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M9_IndexName(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_IndexName((string)value));
    }
    public static Amazon.DynamoDBv2.Select FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M6_Select(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._ISelect> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.Select)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Select(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._ISelect> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M6_Select(Amazon.DynamoDBv2.Select value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._ISelect>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._ISelect>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Select((Amazon.DynamoDBv2.Select)value));
    }
    public static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M15_AttributesToGet(Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<string>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M15_AttributesToGet(System.Collections.Generic.List<string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<char>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList((System.Collections.Generic.List<string>)value));
    }
    public static int? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M5_Limit(Wrappers_Compile._IOption<int> value)
    {
      return value.is_None ? (int?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_PositiveIntegerObject(value.Extract());
    }
    public static Wrappers_Compile._IOption<int> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M5_Limit(int? value)
    {
      return value == null ? Wrappers_Compile.Option<int>.create_None() : Wrappers_Compile.Option<int>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_PositiveIntegerObject((int)value));
    }
    public static bool? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M14_ConsistentRead(Wrappers_Compile._IOption<bool> value)
    {
      return value.is_None ? (bool?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConsistentRead(value.Extract());
    }
    public static Wrappers_Compile._IOption<bool> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M14_ConsistentRead(bool? value)
    {
      return value == null ? Wrappers_Compile.Option<bool>.create_None() : Wrappers_Compile.Option<bool>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConsistentRead((bool)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M13_KeyConditions(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_KeyConditions(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M13_KeyConditions(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_KeyConditions((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition>)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M11_QueryFilter(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_FilterConditionMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M11_QueryFilter(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_FilterConditionMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition>)value));
    }
    public static Amazon.DynamoDBv2.ConditionalOperator FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M19_ConditionalOperator(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionalOperator> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ConditionalOperator)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionalOperator(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionalOperator> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M19_ConditionalOperator(Amazon.DynamoDBv2.ConditionalOperator value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionalOperator>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionalOperator>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionalOperator((Amazon.DynamoDBv2.ConditionalOperator)value));
    }
    public static bool? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M16_ScanIndexForward(Wrappers_Compile._IOption<bool> value)
    {
      return value.is_None ? (bool?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_BooleanObject(value.Extract());
    }
    public static Wrappers_Compile._IOption<bool> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M16_ScanIndexForward(bool? value)
    {
      return value == null ? Wrappers_Compile.Option<bool>.create_None() : Wrappers_Compile.Option<bool>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_BooleanObject((bool)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M17_ExclusiveStartKey(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M17_ExclusiveStartKey(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.ReturnConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M22_ReturnConsumedCapacity(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnConsumedCapacity)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M22_ReturnConsumedCapacity(Amazon.DynamoDBv2.ReturnConsumedCapacity value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity((Amazon.DynamoDBv2.ReturnConsumedCapacity)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M20_ProjectionExpression(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ProjectionExpression(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M20_ProjectionExpression(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ProjectionExpression((string)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M16_FilterExpression(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionExpression(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M16_FilterExpression(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionExpression((string)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M22_KeyConditionExpression(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_KeyExpression(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M22_KeyConditionExpression(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_KeyExpression((string)value));
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M24_ExpressionAttributeNames(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, string>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M24_ExpressionAttributeNames(System.Collections.Generic.Dictionary<string, string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap((System.Collections.Generic.Dictionary<string, string>)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M25_ExpressionAttributeValues(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_QueryInput__M25_ExpressionAttributeValues(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput__M5_Items(Wrappers_Compile._IOption<Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_ItemList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput__M5_Items(System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_ItemList((System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>)value));
    }
    public static int? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput__M5_Count(Wrappers_Compile._IOption<int> value)
    {
      return value.is_None ? (int?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S7_Integer(value.Extract());
    }
    public static Wrappers_Compile._IOption<int> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput__M5_Count(int? value)
    {
      return value == null ? Wrappers_Compile.Option<int>.create_None() : Wrappers_Compile.Option<int>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S7_Integer((int)value));
    }
    public static int? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput__M12_ScannedCount(Wrappers_Compile._IOption<int> value)
    {
      return value.is_None ? (int?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S7_Integer(value.Extract());
    }
    public static Wrappers_Compile._IOption<int> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput__M12_ScannedCount(int? value)
    {
      return value == null ? Wrappers_Compile.Option<int>.create_None() : Wrappers_Compile.Option<int>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S7_Integer((int)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput__M16_LastEvaluatedKey(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput__M16_LastEvaluatedKey(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.Model.ConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput__M16_ConsumedCapacity(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.Model.ConsumedCapacity)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_ScanOutput__M16_ConsumedCapacity(Amazon.DynamoDBv2.Model.ConsumedCapacity value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity((Amazon.DynamoDBv2.Model.ConsumedCapacity)value));
    }
    public static System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetItemOutput__M9_Responses(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchGetResponseMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetItemOutput__M9_Responses(System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchGetResponseMap((System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>>)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.KeysAndAttributes> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetItemOutput__M15_UnprocessedKeys(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IKeysAndAttributes>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.KeysAndAttributes>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetRequestMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IKeysAndAttributes>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetItemOutput__M15_UnprocessedKeys(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.KeysAndAttributes> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IKeysAndAttributes>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IKeysAndAttributes>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetRequestMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.KeysAndAttributes>)value));
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetItemOutput__M16_ConsumedCapacity(Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ConsumedCapacityMultiple(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetItemOutput__M16_ConsumedCapacity(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ConsumedCapacityMultiple((System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)value));
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_TransactGetItemsOutput__M16_ConsumedCapacity(Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ConsumedCapacityMultiple(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_TransactGetItemsOutput__M16_ConsumedCapacity(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ConsumedCapacityMultiple((System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)value));
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemResponse> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_TransactGetItemsOutput__M9_Responses(Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemResponse>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemResponse>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ItemResponseList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemResponse>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_TransactGetItemsOutput__M9_Responses(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemResponse> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemResponse>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemResponse>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ItemResponseList((System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemResponse>)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateItemOutput__M10_Attributes(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateItemOutput__M10_Attributes(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.Model.ConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateItemOutput__M16_ConsumedCapacity(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.Model.ConsumedCapacity)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateItemOutput__M16_ConsumedCapacity(Amazon.DynamoDBv2.Model.ConsumedCapacity value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity((Amazon.DynamoDBv2.Model.ConsumedCapacity)value));
    }
    public static Amazon.DynamoDBv2.Model.ItemCollectionMetrics FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateItemOutput__M21_ItemCollectionMetrics(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.Model.ItemCollectionMetrics)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ItemCollectionMetrics(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateItemOutput__M21_ItemCollectionMetrics(Amazon.DynamoDBv2.Model.ItemCollectionMetrics value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ItemCollectionMetrics((Amazon.DynamoDBv2.Model.ItemCollectionMetrics)value));
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_TransactWriteItemsOutput__M16_ConsumedCapacity(Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ConsumedCapacityMultiple(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_TransactWriteItemsOutput__M16_ConsumedCapacity(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ConsumedCapacityMultiple((System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>)value));
    }
    public static System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemCollectionMetrics>> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_TransactWriteItemsOutput__M21_ItemCollectionMetrics(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics>>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemCollectionMetrics>>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionMetricsPerTable(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_TransactWriteItemsOutput__M21_ItemCollectionMetrics(System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemCollectionMetrics>> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionMetricsPerTable((System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemCollectionMetrics>>)value));
    }
    public static System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.WriteRequest>> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_BatchWriteItemRequestMap(Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IWriteRequest>> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_BatchWriteItemRequestMap__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_BatchWriteItemRequestMap__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IWriteRequest>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_BatchWriteItemRequestMap(System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.WriteRequest>> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IWriteRequest>>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IWriteRequest>>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_BatchWriteItemRequestMap__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_BatchWriteItemRequestMap__M5_value(pair.Value))
     ));
    }
    public static Amazon.DynamoDBv2.ReturnConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity(software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity value)
    {
      if (value.is_INDEXES) return Amazon.DynamoDBv2.ReturnConsumedCapacity.INDEXES;
      if (value.is_TOTAL) return Amazon.DynamoDBv2.ReturnConsumedCapacity.TOTAL;
      if (value.is_NONE) return Amazon.DynamoDBv2.ReturnConsumedCapacity.NONE;
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.ReturnConsumedCapacity value");
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnConsumedCapacity ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ReturnConsumedCapacity(Amazon.DynamoDBv2.ReturnConsumedCapacity value)
    {
      if (Amazon.DynamoDBv2.ReturnConsumedCapacity.INDEXES.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity.create_INDEXES();
      if (Amazon.DynamoDBv2.ReturnConsumedCapacity.TOTAL.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity.create_TOTAL();
      if (Amazon.DynamoDBv2.ReturnConsumedCapacity.NONE.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity.create_NONE();
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.ReturnConsumedCapacity value");
    }
    public static Amazon.DynamoDBv2.ReturnItemCollectionMetrics FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ReturnItemCollectionMetrics(software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnItemCollectionMetrics value)
    {
      if (value.is_SIZE) return Amazon.DynamoDBv2.ReturnItemCollectionMetrics.SIZE;
      if (value.is_NONE) return Amazon.DynamoDBv2.ReturnItemCollectionMetrics.NONE;
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.ReturnItemCollectionMetrics value");
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnItemCollectionMetrics ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ReturnItemCollectionMetrics(Amazon.DynamoDBv2.ReturnItemCollectionMetrics value)
    {
      if (Amazon.DynamoDBv2.ReturnItemCollectionMetrics.SIZE.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnItemCollectionMetrics.create_SIZE();
      if (Amazon.DynamoDBv2.ReturnItemCollectionMetrics.NONE.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnItemCollectionMetrics.create_NONE();
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.ReturnItemCollectionMetrics value");
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.TransactGetItem> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_TransactGetItemList(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItem> value)
    {
      return new System.Collections.Generic.List<Amazon.DynamoDBv2.Model.TransactGetItem>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_TransactGetItemList__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItem> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_TransactGetItemList(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.TransactGetItem> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItem>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_TransactGetItemList__M6_member).ToArray());
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_PutItemInputAttributeMap(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_PutItemInputAttributeMap__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_PutItemInputAttributeMap__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_PutItemInputAttributeMap(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_PutItemInputAttributeMap__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_PutItemInputAttributeMap__M5_value(pair.Value))
     ));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ExpectedAttributeMap(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IExpectedAttributeValue> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ExpectedAttributeMap__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ExpectedAttributeMap__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IExpectedAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ExpectedAttributeMap(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.ExpectedAttributeValue> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IExpectedAttributeValue>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IExpectedAttributeValue>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ExpectedAttributeMap__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ExpectedAttributeMap__M5_value(pair.Value))
     ));
    }
    public static Amazon.DynamoDBv2.ReturnValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_ReturnValue(software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValue value)
    {
      if (value.is_NONE) return Amazon.DynamoDBv2.ReturnValue.NONE;
      if (value.is_ALL__OLD) return Amazon.DynamoDBv2.ReturnValue.ALL_OLD;
      if (value.is_UPDATED__OLD) return Amazon.DynamoDBv2.ReturnValue.UPDATED_OLD;
      if (value.is_ALL__NEW) return Amazon.DynamoDBv2.ReturnValue.ALL_NEW;
      if (value.is_UPDATED__NEW) return Amazon.DynamoDBv2.ReturnValue.UPDATED_NEW;
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.ReturnValue value");
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_ReturnValue(Amazon.DynamoDBv2.ReturnValue value)
    {
      if (Amazon.DynamoDBv2.ReturnValue.NONE.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValue.create_NONE();
      if (Amazon.DynamoDBv2.ReturnValue.ALL_OLD.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValue.create_ALL__OLD();
      if (Amazon.DynamoDBv2.ReturnValue.UPDATED_OLD.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValue.create_UPDATED__OLD();
      if (Amazon.DynamoDBv2.ReturnValue.ALL_NEW.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValue.create_ALL__NEW();
      if (Amazon.DynamoDBv2.ReturnValue.UPDATED_NEW.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValue.create_UPDATED__NEW();
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.ReturnValue value");
    }
    public static Amazon.DynamoDBv2.ConditionalOperator FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionalOperator(software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionalOperator value)
    {
      if (value.is_AND) return Amazon.DynamoDBv2.ConditionalOperator.AND;
      if (value.is_OR) return Amazon.DynamoDBv2.ConditionalOperator.OR;
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.ConditionalOperator value");
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionalOperator ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionalOperator(Amazon.DynamoDBv2.ConditionalOperator value)
    {
      if (Amazon.DynamoDBv2.ConditionalOperator.AND.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ConditionalOperator.create_AND();
      if (Amazon.DynamoDBv2.ConditionalOperator.OR.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ConditionalOperator.create_OR();
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.ConditionalOperator value");
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionExpression(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionExpression(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap(Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap(System.Collections.Generic.Dictionary<string, string> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, Dafny.ISequence<char>>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, Dafny.ISequence<char>>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap__M5_value(pair.Value))
     ));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap__M5_value(pair.Value))
     ));
    }
    public static Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S35_ReturnValuesOnConditionCheckFailure(software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure value)
    {
      if (value.is_ALL__OLD) return Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure.ALL_OLD;
      if (value.is_NONE) return Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure.NONE;
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure value");
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S35_ReturnValuesOnConditionCheckFailure(Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure value)
    {
      if (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure.ALL_OLD.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValuesOnConditionCheckFailure.create_ALL__OLD();
      if (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure.NONE.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValuesOnConditionCheckFailure.create_NONE();
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure value");
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M5_value(pair.Value))
     ));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValueUpdate> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_AttributeUpdates(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValueUpdate> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_AttributeUpdates__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_AttributeUpdates__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValueUpdate> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_AttributeUpdates(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValueUpdate> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValueUpdate>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValueUpdate>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_AttributeUpdates__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_AttributeUpdates__M5_value(pair.Value))
     ));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateExpression(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateExpression(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.TransactWriteItem> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactWriteItemList(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItem> value)
    {
      return new System.Collections.Generic.List<Amazon.DynamoDBv2.Model.TransactWriteItem>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactWriteItemList__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItem> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactWriteItemList(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.TransactWriteItem> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItem>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactWriteItemList__M6_member).ToArray());
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ClientRequestToken(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ClientRequestToken(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_IndexName(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_IndexName(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList(Dafny.ISequence<Dafny.ISequence<char>> value)
    {
      return new System.Collections.Generic.List<string>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList__M6_member));
    }
    public static Dafny.ISequence<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList(System.Collections.Generic.List<string> value)
    {
      return Dafny.Sequence<Dafny.ISequence<char>>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList__M6_member).ToArray());
    }
    public static int FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_PositiveIntegerObject(int value)
    {
      return value;
    }
    public static int ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_PositiveIntegerObject(int value)
    {
      return value;
    }
    public static Amazon.DynamoDBv2.Select FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Select(software.amazon.cryptography.services.dynamodb.internaldafny.types._ISelect value)
    {
      if (value.is_ALL__ATTRIBUTES) return Amazon.DynamoDBv2.Select.ALL_ATTRIBUTES;
      if (value.is_ALL__PROJECTED__ATTRIBUTES) return Amazon.DynamoDBv2.Select.ALL_PROJECTED_ATTRIBUTES;
      if (value.is_SPECIFIC__ATTRIBUTES) return Amazon.DynamoDBv2.Select.SPECIFIC_ATTRIBUTES;
      if (value.is_COUNT) return Amazon.DynamoDBv2.Select.COUNT;
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.Select value");
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ISelect ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Select(Amazon.DynamoDBv2.Select value)
    {
      if (Amazon.DynamoDBv2.Select.ALL_ATTRIBUTES.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.Select.create_ALL__ATTRIBUTES();
      if (Amazon.DynamoDBv2.Select.ALL_PROJECTED_ATTRIBUTES.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.Select.create_ALL__PROJECTED__ATTRIBUTES();
      if (Amazon.DynamoDBv2.Select.SPECIFIC_ATTRIBUTES.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.Select.create_SPECIFIC__ATTRIBUTES();
      if (Amazon.DynamoDBv2.Select.COUNT.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.Select.create_COUNT();
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.Select value");
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_FilterConditionMap(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_FilterConditionMap__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_FilterConditionMap__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_FilterConditionMap(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_FilterConditionMap__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_FilterConditionMap__M5_value(pair.Value))
     ));
    }
    public static int FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_ScanTotalSegments(int value)
    {
      return value;
    }
    public static int ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_ScanTotalSegments(int value)
    {
      return value;
    }
    public static int FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_ScanSegment(int value)
    {
      return value;
    }
    public static int ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S11_ScanSegment(int value)
    {
      return value;
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ProjectionExpression(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ProjectionExpression(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static bool FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConsistentRead(bool value)
    {
      return value;
    }
    public static bool ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConsistentRead(bool value)
    {
      return value;
    }
    public static Amazon.DynamoDBv2.Model.ConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity(software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.ConsumedCapacity concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.ConsumedCapacity)value; Amazon.DynamoDBv2.Model.ConsumedCapacity converted = new Amazon.DynamoDBv2.Model.ConsumedCapacity(); if (concrete._TableName.is_Some) converted.TableName = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M9_TableName(concrete._TableName);
      if (concrete._CapacityUnits.is_Some) converted.CapacityUnits = (double)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M13_CapacityUnits(concrete._CapacityUnits);
      if (concrete._ReadCapacityUnits.is_Some) converted.ReadCapacityUnits = (double)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M17_ReadCapacityUnits(concrete._ReadCapacityUnits);
      if (concrete._WriteCapacityUnits.is_Some) converted.WriteCapacityUnits = (double)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M18_WriteCapacityUnits(concrete._WriteCapacityUnits);
      if (concrete._Table.is_Some) converted.Table = (Amazon.DynamoDBv2.Model.Capacity)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M5_Table(concrete._Table);
      if (concrete._LocalSecondaryIndexes.is_Some) converted.LocalSecondaryIndexes = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Capacity>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M21_LocalSecondaryIndexes(concrete._LocalSecondaryIndexes);
      if (concrete._GlobalSecondaryIndexes.is_Some) converted.GlobalSecondaryIndexes = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Capacity>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M22_GlobalSecondaryIndexes(concrete._GlobalSecondaryIndexes); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity(Amazon.DynamoDBv2.Model.ConsumedCapacity value)
    {

      string var_tableName = value.TableName != null ? value.TableName : (string)null;
      double? var_capacityUnits = value.CapacityUnits != null ? value.CapacityUnits : (double?)null;
      double? var_readCapacityUnits = value.ReadCapacityUnits != null ? value.ReadCapacityUnits : (double?)null;
      double? var_writeCapacityUnits = value.WriteCapacityUnits != null ? value.WriteCapacityUnits : (double?)null;
      Amazon.DynamoDBv2.Model.Capacity var_table = value.Table != null ? value.Table : (Amazon.DynamoDBv2.Model.Capacity)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Capacity> var_localSecondaryIndexes = value.LocalSecondaryIndexes != null ? value.LocalSecondaryIndexes : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Capacity>)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Capacity> var_globalSecondaryIndexes = value.GlobalSecondaryIndexes != null ? value.GlobalSecondaryIndexes : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Capacity>)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.ConsumedCapacity(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M9_TableName(var_tableName), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M13_CapacityUnits(var_capacityUnits), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M17_ReadCapacityUnits(var_readCapacityUnits), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M18_WriteCapacityUnits(var_writeCapacityUnits), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M5_Table(var_table), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M21_LocalSecondaryIndexes(var_localSecondaryIndexes), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M22_GlobalSecondaryIndexes(var_globalSecondaryIndexes));
    }
    public static Amazon.DynamoDBv2.Model.ItemCollectionMetrics FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ItemCollectionMetrics(software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.ItemCollectionMetrics concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.ItemCollectionMetrics)value; Amazon.DynamoDBv2.Model.ItemCollectionMetrics converted = new Amazon.DynamoDBv2.Model.ItemCollectionMetrics(); if (concrete._ItemCollectionKey.is_Some) converted.ItemCollectionKey = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ItemCollectionMetrics__M17_ItemCollectionKey(concrete._ItemCollectionKey);
      if (concrete._SizeEstimateRangeGB.is_Some) converted.SizeEstimateRangeGB = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ItemCollectionMetrics__M19_SizeEstimateRangeGB(concrete._SizeEstimateRangeGB).Select(i => (double)i).ToList(); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ItemCollectionMetrics(Amazon.DynamoDBv2.Model.ItemCollectionMetrics value)
    {

      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> var_itemCollectionKey = value.ItemCollectionKey != null ? value.ItemCollectionKey : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null;
      System.Collections.Generic.List<double> var_sizeEstimateRangeGB = value.SizeEstimateRangeGB != null ? value.SizeEstimateRangeGB : (System.Collections.Generic.List<double>)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.ItemCollectionMetrics(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ItemCollectionMetrics__M17_ItemCollectionKey(var_itemCollectionKey), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ItemCollectionMetrics__M19_SizeEstimateRangeGB(var_sizeEstimateRangeGB));
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ParameterizedStatement> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ParameterizedStatements(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IParameterizedStatement> value)
    {
      return new System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ParameterizedStatement>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ParameterizedStatements__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IParameterizedStatement> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ParameterizedStatements(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ParameterizedStatement> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IParameterizedStatement>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ParameterizedStatements__M6_member).ToArray());
    }
    public static System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_ItemList(Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return new System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_ItemList__M6_member));
    }
    public static Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_ItemList(System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>> value)
    {
      return Dafny.Sequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_ItemList__M6_member).ToArray());
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_PartiQLNextToken(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_PartiQLNextToken(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemResponse> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ItemResponseList(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemResponse> value)
    {
      return new System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemResponse>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ItemResponseList__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemResponse> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ItemResponseList(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemResponse> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemResponse>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ItemResponseList__M6_member).ToArray());
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ConsumedCapacityMultiple(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity> value)
    {
      return new System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ConsumedCapacityMultiple__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ConsumedCapacityMultiple(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ConsumedCapacity> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ConsumedCapacityMultiple__M6_member).ToArray());
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.KeysAndAttributes> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetRequestMap(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IKeysAndAttributes> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetRequestMap__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetRequestMap__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IKeysAndAttributes> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetRequestMap(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.KeysAndAttributes> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IKeysAndAttributes>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IKeysAndAttributes>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetRequestMap__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetRequestMap__M5_value(pair.Value))
     ));
    }
    public static int FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S7_Integer(int value)
    {
      return value;
    }
    public static int ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S7_Integer(int value)
    {
      return value;
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.BatchStatementRequest> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_PartiQLBatchRequest(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementRequest> value)
    {
      return new System.Collections.Generic.List<Amazon.DynamoDBv2.Model.BatchStatementRequest>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_PartiQLBatchRequest__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementRequest> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_PartiQLBatchRequest(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.BatchStatementRequest> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementRequest>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_PartiQLBatchRequest__M6_member).ToArray());
    }
    public static System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemCollectionMetrics>> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionMetricsPerTable(Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics>> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionMetricsPerTable__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionMetricsPerTable__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionMetricsPerTable(System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemCollectionMetrics>> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics>>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics>>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionMetricsPerTable__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionMetricsPerTable__M5_value(pair.Value))
     ));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_PartiQLStatement(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_PartiQLStatement(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_PreparedStatementParameters(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return new System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_PreparedStatementParameters__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_PreparedStatementParameters(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_PreparedStatementParameters__M6_member).ToArray());
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)value;
      var converted = new Amazon.DynamoDBv2.Model.AttributeValue(); if (value.is_S)
      {
        converted.S = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_S(concrete.dtor_S);
        return converted;
      }
      if (value.is_N)
      {
        converted.N = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_N(concrete.dtor_N);
        return converted;
      }
      if (value.is_B)
      {
        converted.B = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_B(concrete.dtor_B);
        return converted;
      }
      if (value.is_SS)
      {
        converted.SS = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_SS(concrete.dtor_SS);
        return converted;
      }
      if (value.is_NS)
      {
        converted.NS = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_NS(concrete.dtor_NS);
        return converted;
      }
      if (value.is_BS)
      {
        converted.BS = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_BS(concrete.dtor_BS);
        return converted;
      }
      if (value.is_M)
      {
        converted.M = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_M(concrete.dtor_M);
        return converted;
      }
      if (value.is_L)
      {
        converted.L = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_L(concrete.dtor_L);
        return converted;
      }
      if (value.is_NULL)
      {
        converted.NULL = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_NULL(concrete.dtor_NULL);
        return converted;
      }
      if (value.is_BOOL)
      {
        converted.BOOL = FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_BOOL(concrete.dtor_BOOL);
        return converted;
      }
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.Model.AttributeValue state");
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      if (value.S != null)
      {
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_S(value.S));
      }
      if (value.N != null)
      {
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_N(value.N));
      }
      if (value.B != null)
      {
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_B(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_B(value.B));
      }
      if (value.SS.Any())
      {
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_SS(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_SS(value.SS));
      }
      if (value.NS.Any())
      {
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NS(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_NS(value.NS));
      }
      if (value.BS.Any())
      {
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BS(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_BS(value.BS));
      }
      if (value.IsMSet)
      {
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_M(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_M(value.M));
      }
      if (value.IsLSet)
      {
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_L(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_L(value.L));
      }
      if (value.NULL == true)
      {
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NULL(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_NULL(value.NULL));
      }
      if (value.IsBOOLSet)
      {
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BOOL(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_BOOL(value.BOOL));
      }
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.Model.AttributeValue state");
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.BatchStatementResponse> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_PartiQLBatchResponse(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementResponse> value)
    {
      return new System.Collections.Generic.List<Amazon.DynamoDBv2.Model.BatchStatementResponse>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_PartiQLBatchResponse__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementResponse> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_PartiQLBatchResponse(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.BatchStatementResponse> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementResponse>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_PartiQLBatchResponse__M6_member).ToArray());
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_KeyConditions(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_KeyConditions__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_KeyConditions__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_KeyConditions(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Condition> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_KeyConditions__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_KeyConditions__M5_value(pair.Value))
     ));
    }
    public static bool FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_BooleanObject(bool value)
    {
      return value;
    }
    public static bool ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_BooleanObject(bool value)
    {
      return value;
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_KeyExpression(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_KeyExpression(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchGetResponseMap(Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchGetResponseMap__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchGetResponseMap__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchGetResponseMap(System.Collections.Generic.Dictionary<string, System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchGetResponseMap__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchGetResponseMap__M5_value(pair.Value))
     ));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_BatchWriteItemRequestMap__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_BatchWriteItemRequestMap__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.WriteRequest> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_BatchWriteItemRequestMap__M5_value(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IWriteRequest> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_WriteRequests(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IWriteRequest> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_BatchWriteItemRequestMap__M5_value(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.WriteRequest> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_WriteRequests(value);
    }
    public static Amazon.DynamoDBv2.Model.TransactGetItem FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_TransactGetItemList__M6_member(software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItem value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_TransactGetItem(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItem ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_TransactGetItemList__M6_member(Amazon.DynamoDBv2.Model.TransactGetItem value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_TransactGetItem(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_PutItemInputAttributeMap__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_PutItemInputAttributeMap__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_PutItemInputAttributeMap__M5_value(software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_PutItemInputAttributeMap__M5_value(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ExpectedAttributeMap__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ExpectedAttributeMap__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Amazon.DynamoDBv2.Model.ExpectedAttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ExpectedAttributeMap__M5_value(software.amazon.cryptography.services.dynamodb.internaldafny.types._IExpectedAttributeValue value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExpectedAttributeValue(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IExpectedAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ExpectedAttributeMap__M5_value(Amazon.DynamoDBv2.Model.ExpectedAttributeValue value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExpectedAttributeValue(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S31_ExpressionAttributeNameVariable(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S31_ExpressionAttributeNameVariable(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap__M5_value(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap__M5_value(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S32_ExpressionAttributeValueVariable(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S32_ExpressionAttributeValueVariable(value);
    }
    public static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap__M5_value(software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap__M5_value(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M5_value(software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key__M5_value(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_AttributeUpdates__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_AttributeUpdates__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Amazon.DynamoDBv2.Model.AttributeValueUpdate FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_AttributeUpdates__M5_value(software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValueUpdate value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_AttributeValueUpdate(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValueUpdate ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_AttributeUpdates__M5_value(Amazon.DynamoDBv2.Model.AttributeValueUpdate value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_AttributeValueUpdate(value);
    }
    public static Amazon.DynamoDBv2.Model.TransactWriteItem FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactWriteItemList__M6_member(software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItem value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_TransactWriteItem(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItem ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_TransactWriteItemList__M6_member(Amazon.DynamoDBv2.Model.TransactWriteItem value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_TransactWriteItem(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList__M6_member(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList__M6_member(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_FilterConditionMap__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_FilterConditionMap__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Amazon.DynamoDBv2.Model.Condition FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_FilterConditionMap__M5_value(software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_Condition(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_FilterConditionMap__M5_value(Amazon.DynamoDBv2.Model.Condition value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_Condition(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M9_TableName(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M9_TableName(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn((string)value));
    }
    public static double? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M13_CapacityUnits(Wrappers_Compile._IOption<Dafny.ISequence<byte>> value)
    {
      return value.is_None ? (double?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ConsumedCapacityUnits(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<byte>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M13_CapacityUnits(double? value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<byte>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<byte>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ConsumedCapacityUnits((double)value));
    }
    public static double? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M17_ReadCapacityUnits(Wrappers_Compile._IOption<Dafny.ISequence<byte>> value)
    {
      return value.is_None ? (double?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ConsumedCapacityUnits(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<byte>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M17_ReadCapacityUnits(double? value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<byte>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<byte>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ConsumedCapacityUnits((double)value));
    }
    public static double? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M18_WriteCapacityUnits(Wrappers_Compile._IOption<Dafny.ISequence<byte>> value)
    {
      return value.is_None ? (double?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ConsumedCapacityUnits(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<byte>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M18_WriteCapacityUnits(double? value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<byte>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<byte>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ConsumedCapacityUnits((double)value));
    }
    public static Amazon.DynamoDBv2.Model.Capacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M5_Table(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._ICapacity> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.Model.Capacity)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_Capacity(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._ICapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M5_Table(Amazon.DynamoDBv2.Model.Capacity value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._ICapacity>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._ICapacity>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_Capacity((Amazon.DynamoDBv2.Model.Capacity)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Capacity> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M21_LocalSecondaryIndexes(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICapacity>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Capacity>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_SecondaryIndexesCapacityMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICapacity>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M21_LocalSecondaryIndexes(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Capacity> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICapacity>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICapacity>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_SecondaryIndexesCapacityMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Capacity>)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Capacity> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M22_GlobalSecondaryIndexes(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICapacity>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Capacity>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_SecondaryIndexesCapacityMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICapacity>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity__M22_GlobalSecondaryIndexes(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Capacity> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICapacity>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICapacity>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_SecondaryIndexesCapacityMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Capacity>)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ItemCollectionMetrics__M17_ItemCollectionKey(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionKeyAttributeMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ItemCollectionMetrics__M17_ItemCollectionKey(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionKeyAttributeMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static System.Collections.Generic.List<double> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ItemCollectionMetrics__M19_SizeEstimateRangeGB(Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<byte>>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<double>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S31_ItemCollectionSizeEstimateRange(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<byte>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ItemCollectionMetrics__M19_SizeEstimateRangeGB(System.Collections.Generic.List<double> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<byte>>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<byte>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S31_ItemCollectionSizeEstimateRange((System.Collections.Generic.List<double>)value));
    }
    public static Amazon.DynamoDBv2.Model.ParameterizedStatement FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ParameterizedStatements__M6_member(software.amazon.cryptography.services.dynamodb.internaldafny.types._IParameterizedStatement value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ParameterizedStatement(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IParameterizedStatement ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_ParameterizedStatements__M6_member(Amazon.DynamoDBv2.Model.ParameterizedStatement value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ParameterizedStatement(value);
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_ItemList__M6_member(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_ItemList__M6_member(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value);
    }
    public static Amazon.DynamoDBv2.Model.ItemResponse FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ItemResponseList__M6_member(software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemResponse value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_ItemResponse(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemResponse ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ItemResponseList__M6_member(Amazon.DynamoDBv2.Model.ItemResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_ItemResponse(value);
    }
    public static Amazon.DynamoDBv2.Model.ConsumedCapacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ConsumedCapacityMultiple__M6_member(software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IConsumedCapacity ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_ConsumedCapacityMultiple__M6_member(Amazon.DynamoDBv2.Model.ConsumedCapacity value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_ConsumedCapacity(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetRequestMap__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetRequestMap__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static Amazon.DynamoDBv2.Model.KeysAndAttributes FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetRequestMap__M5_value(software.amazon.cryptography.services.dynamodb.internaldafny.types._IKeysAndAttributes value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IKeysAndAttributes ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_BatchGetRequestMap__M5_value(Amazon.DynamoDBv2.Model.KeysAndAttributes value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes(value);
    }
    public static Amazon.DynamoDBv2.Model.BatchStatementRequest FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_PartiQLBatchRequest__M6_member(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementRequest value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BatchStatementRequest(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementRequest ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_PartiQLBatchRequest__M6_member(Amazon.DynamoDBv2.Model.BatchStatementRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BatchStatementRequest(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionMetricsPerTable__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionMetricsPerTable__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemCollectionMetrics> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionMetricsPerTable__M5_value(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionMetricsMultiple(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionMetricsPerTable__M5_value(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemCollectionMetrics> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionMetricsMultiple(value);
    }
    public static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_PreparedStatementParameters__M6_member(software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_PreparedStatementParameters__M6_member(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_S(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_S(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_N(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_N(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue(value);
    }
    public static System.IO.MemoryStream FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_B(Dafny.ISequence<byte> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue(value);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_B(System.IO.MemoryStream value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue(value);
    }
    public static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_SS(Dafny.ISequence<Dafny.ISequence<char>> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue(value);
    }
    public static Dafny.ISequence<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_SS(System.Collections.Generic.List<string> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue(value);
    }
    public static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_NS(Dafny.ISequence<Dafny.ISequence<char>> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue(value);
    }
    public static Dafny.ISequence<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_NS(System.Collections.Generic.List<string> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue(value);
    }
    public static System.Collections.Generic.List<System.IO.MemoryStream> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_BS(Dafny.ISequence<Dafny.ISequence<byte>> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue(value);
    }
    public static Dafny.ISequence<Dafny.ISequence<byte>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M2_BS(System.Collections.Generic.List<System.IO.MemoryStream> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue(value);
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_M(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_M(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue(value);
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_L(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue(value);
    }
    public static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M1_L(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue(value);
    }
    public static bool FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_NULL(bool value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_NullAttributeValue(value);
    }
    public static bool ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_NULL(bool value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_NullAttributeValue(value);
    }
    public static bool FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_BOOL(bool value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BooleanAttributeValue(value);
    }
    public static bool ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue__M4_BOOL(bool value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BooleanAttributeValue(value);
    }
    public static Amazon.DynamoDBv2.Model.BatchStatementResponse FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_PartiQLBatchResponse__M6_member(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementResponse value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_BatchStatementResponse(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementResponse ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_PartiQLBatchResponse__M6_member(Amazon.DynamoDBv2.Model.BatchStatementResponse value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_BatchStatementResponse(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_KeyConditions__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_KeyConditions__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Amazon.DynamoDBv2.Model.Condition FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_KeyConditions__M5_value(software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_Condition(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_KeyConditions__M5_value(Amazon.DynamoDBv2.Model.Condition value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_Condition(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchGetResponseMap__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchGetResponseMap__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchGetResponseMap__M5_value(Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_ItemList(value);
    }
    public static Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchGetResponseMap__M5_value(System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_ItemList(value);
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.WriteRequest> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_WriteRequests(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IWriteRequest> value)
    {
      return new System.Collections.Generic.List<Amazon.DynamoDBv2.Model.WriteRequest>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_WriteRequests__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IWriteRequest> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_WriteRequests(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.WriteRequest> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IWriteRequest>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_WriteRequests__M6_member).ToArray());
    }
    public static Amazon.DynamoDBv2.Model.TransactGetItem FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_TransactGetItem(software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItem value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItem concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItem)value; Amazon.DynamoDBv2.Model.TransactGetItem converted = new Amazon.DynamoDBv2.Model.TransactGetItem(); converted.Get = (Amazon.DynamoDBv2.Model.Get)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_TransactGetItem__M3_Get(concrete._Get); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactGetItem ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_TransactGetItem(Amazon.DynamoDBv2.Model.TransactGetItem value)
    {


      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItem(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_TransactGetItem__M3_Get(value.Get));
    }
    public static Amazon.DynamoDBv2.Model.ExpectedAttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExpectedAttributeValue(software.amazon.cryptography.services.dynamodb.internaldafny.types._IExpectedAttributeValue value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.ExpectedAttributeValue concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.ExpectedAttributeValue)value; Amazon.DynamoDBv2.Model.ExpectedAttributeValue converted = new Amazon.DynamoDBv2.Model.ExpectedAttributeValue(); if (concrete._Value.is_Some) converted.Value = (Amazon.DynamoDBv2.Model.AttributeValue)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExpectedAttributeValue__M5_Value(concrete._Value);
      if (concrete._Exists.is_Some) converted.Exists = (bool)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExpectedAttributeValue__M6_Exists(concrete._Exists);
      if (concrete._ComparisonOperator.is_Some) converted.ComparisonOperator = (Amazon.DynamoDBv2.ComparisonOperator)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExpectedAttributeValue__M18_ComparisonOperator(concrete._ComparisonOperator);
      if (concrete._AttributeValueList.is_Some) converted.AttributeValueList = (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExpectedAttributeValue__M18_AttributeValueList(concrete._AttributeValueList); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IExpectedAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExpectedAttributeValue(Amazon.DynamoDBv2.Model.ExpectedAttributeValue value)
    {

      Amazon.DynamoDBv2.Model.AttributeValue var_value = value.Value != null ? value.Value : (Amazon.DynamoDBv2.Model.AttributeValue)null;
      bool? var_exists = value.Exists != null ? value.Exists : (bool?)null;
      Amazon.DynamoDBv2.ComparisonOperator var_comparisonOperator = value.ComparisonOperator != null ? value.ComparisonOperator : (Amazon.DynamoDBv2.ComparisonOperator)null;
      System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> var_attributeValueList = value.AttributeValueList != null ? value.AttributeValueList : (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.ExpectedAttributeValue(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExpectedAttributeValue__M5_Value(var_value), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExpectedAttributeValue__M6_Exists(var_exists), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExpectedAttributeValue__M18_ComparisonOperator(var_comparisonOperator), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExpectedAttributeValue__M18_AttributeValueList(var_attributeValueList));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S31_ExpressionAttributeNameVariable(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S31_ExpressionAttributeNameVariable(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S32_ExpressionAttributeValueVariable(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S32_ExpressionAttributeValueVariable(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static Amazon.DynamoDBv2.Model.AttributeValueUpdate FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_AttributeValueUpdate(software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValueUpdate value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValueUpdate concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValueUpdate)value; Amazon.DynamoDBv2.Model.AttributeValueUpdate converted = new Amazon.DynamoDBv2.Model.AttributeValueUpdate(); if (concrete._Value.is_Some) converted.Value = (Amazon.DynamoDBv2.Model.AttributeValue)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_AttributeValueUpdate__M5_Value(concrete._Value);
      if (concrete._Action.is_Some) converted.Action = (Amazon.DynamoDBv2.AttributeAction)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_AttributeValueUpdate__M6_Action(concrete._Action); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValueUpdate ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_AttributeValueUpdate(Amazon.DynamoDBv2.Model.AttributeValueUpdate value)
    {

      Amazon.DynamoDBv2.Model.AttributeValue var_value = value.Value != null ? value.Value : (Amazon.DynamoDBv2.Model.AttributeValue)null;
      Amazon.DynamoDBv2.AttributeAction var_action = value.Action != null ? value.Action : (Amazon.DynamoDBv2.AttributeAction)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValueUpdate(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_AttributeValueUpdate__M5_Value(var_value), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_AttributeValueUpdate__M6_Action(var_action));
    }
    public static Amazon.DynamoDBv2.Model.TransactWriteItem FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_TransactWriteItem(software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItem value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItem concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItem)value; Amazon.DynamoDBv2.Model.TransactWriteItem converted = new Amazon.DynamoDBv2.Model.TransactWriteItem(); if (concrete._ConditionCheck.is_Some) converted.ConditionCheck = (Amazon.DynamoDBv2.Model.ConditionCheck)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_TransactWriteItem__M14_ConditionCheck(concrete._ConditionCheck);
      if (concrete._Put.is_Some) converted.Put = (Amazon.DynamoDBv2.Model.Put)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_TransactWriteItem__M3_Put(concrete._Put);
      if (concrete._Delete.is_Some) converted.Delete = (Amazon.DynamoDBv2.Model.Delete)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_TransactWriteItem__M6_Delete(concrete._Delete);
      if (concrete._Update.is_Some) converted.Update = (Amazon.DynamoDBv2.Model.Update)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_TransactWriteItem__M6_Update(concrete._Update); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ITransactWriteItem ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_TransactWriteItem(Amazon.DynamoDBv2.Model.TransactWriteItem value)
    {

      Amazon.DynamoDBv2.Model.ConditionCheck var_conditionCheck = value.ConditionCheck != null ? value.ConditionCheck : (Amazon.DynamoDBv2.Model.ConditionCheck)null;
      Amazon.DynamoDBv2.Model.Put var_put = value.Put != null ? value.Put : (Amazon.DynamoDBv2.Model.Put)null;
      Amazon.DynamoDBv2.Model.Delete var_delete = value.Delete != null ? value.Delete : (Amazon.DynamoDBv2.Model.Delete)null;
      Amazon.DynamoDBv2.Model.Update var_update = value.Update != null ? value.Update : (Amazon.DynamoDBv2.Model.Update)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItem(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_TransactWriteItem__M14_ConditionCheck(var_conditionCheck), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_TransactWriteItem__M3_Put(var_put), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_TransactWriteItem__M6_Delete(var_delete), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_TransactWriteItem__M6_Update(var_update));
    }
    public static Amazon.DynamoDBv2.Model.Condition FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_Condition(software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.Condition concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.Condition)value; Amazon.DynamoDBv2.Model.Condition converted = new Amazon.DynamoDBv2.Model.Condition(); if (concrete._AttributeValueList.is_Some) converted.AttributeValueList = (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_Condition__M18_AttributeValueList(concrete._AttributeValueList);
      converted.ComparisonOperator = (Amazon.DynamoDBv2.ComparisonOperator)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_Condition__M18_ComparisonOperator(concrete._ComparisonOperator); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ICondition ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_Condition(Amazon.DynamoDBv2.Model.Condition value)
    {

      System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> var_attributeValueList = value.AttributeValueList != null ? value.AttributeValueList : (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.Condition(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_Condition__M18_AttributeValueList(var_attributeValueList), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_Condition__M18_ComparisonOperator(value.ComparisonOperator));
    }
    public static double FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ConsumedCapacityUnits(Dafny.ISequence<byte> value)
    {
      return BitConverter.ToDouble(value.CloneAsArray(), 0);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ConsumedCapacityUnits(double value)
    {
      return Dafny.Sequence<byte>.FromArray(BitConverter.GetBytes(value));
    }
    public static Amazon.DynamoDBv2.Model.Capacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_Capacity(software.amazon.cryptography.services.dynamodb.internaldafny.types._ICapacity value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.Capacity concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.Capacity)value; Amazon.DynamoDBv2.Model.Capacity converted = new Amazon.DynamoDBv2.Model.Capacity(); if (concrete._ReadCapacityUnits.is_Some) converted.ReadCapacityUnits = (double)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_Capacity__M17_ReadCapacityUnits(concrete._ReadCapacityUnits);
      if (concrete._WriteCapacityUnits.is_Some) converted.WriteCapacityUnits = (double)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_Capacity__M18_WriteCapacityUnits(concrete._WriteCapacityUnits);
      if (concrete._CapacityUnits.is_Some) converted.CapacityUnits = (double)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_Capacity__M13_CapacityUnits(concrete._CapacityUnits); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ICapacity ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_Capacity(Amazon.DynamoDBv2.Model.Capacity value)
    {

      double? var_readCapacityUnits = value.ReadCapacityUnits != null ? value.ReadCapacityUnits : (double?)null;
      double? var_writeCapacityUnits = value.WriteCapacityUnits != null ? value.WriteCapacityUnits : (double?)null;
      double? var_capacityUnits = value.CapacityUnits != null ? value.CapacityUnits : (double?)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.Capacity(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_Capacity__M17_ReadCapacityUnits(var_readCapacityUnits), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_Capacity__M18_WriteCapacityUnits(var_writeCapacityUnits), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_Capacity__M13_CapacityUnits(var_capacityUnits));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Capacity> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_SecondaryIndexesCapacityMap(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICapacity> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_SecondaryIndexesCapacityMap__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_SecondaryIndexesCapacityMap__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICapacity> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_SecondaryIndexesCapacityMap(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.Capacity> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICapacity>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._ICapacity>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_SecondaryIndexesCapacityMap__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_SecondaryIndexesCapacityMap__M5_value(pair.Value))
     ));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionKeyAttributeMap(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionKeyAttributeMap__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionKeyAttributeMap__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionKeyAttributeMap(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionKeyAttributeMap__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionKeyAttributeMap__M5_value(pair.Value))
     ));
    }
    public static System.Collections.Generic.List<double> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S31_ItemCollectionSizeEstimateRange(Dafny.ISequence<Dafny.ISequence<byte>> value)
    {
      return new System.Collections.Generic.List<double>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S31_ItemCollectionSizeEstimateRange__M6_member));
    }
    public static Dafny.ISequence<Dafny.ISequence<byte>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S31_ItemCollectionSizeEstimateRange(System.Collections.Generic.List<double> value)
    {
      return Dafny.Sequence<Dafny.ISequence<byte>>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S31_ItemCollectionSizeEstimateRange__M6_member).ToArray());
    }
    public static Amazon.DynamoDBv2.Model.ParameterizedStatement FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ParameterizedStatement(software.amazon.cryptography.services.dynamodb.internaldafny.types._IParameterizedStatement value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement)value; Amazon.DynamoDBv2.Model.ParameterizedStatement converted = new Amazon.DynamoDBv2.Model.ParameterizedStatement(); converted.Statement = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ParameterizedStatement__M9_Statement(concrete._Statement);
      if (concrete._Parameters.is_Some) converted.Parameters = (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ParameterizedStatement__M10_Parameters(concrete._Parameters);
      if (concrete._ReturnValuesOnConditionCheckFailure.is_Some) converted.ReturnValuesOnConditionCheckFailure = (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ParameterizedStatement__M35_ReturnValuesOnConditionCheckFailure(concrete._ReturnValuesOnConditionCheckFailure); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IParameterizedStatement ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ParameterizedStatement(Amazon.DynamoDBv2.Model.ParameterizedStatement value)
    {

      System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> var_parameters = value.Parameters != null ? value.Parameters : (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>)null;
      Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure var_returnValuesOnConditionCheckFailure = value.ReturnValuesOnConditionCheckFailure != null ? value.ReturnValuesOnConditionCheckFailure : (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ParameterizedStatement__M9_Statement(value.Statement), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ParameterizedStatement__M10_Parameters(var_parameters), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ParameterizedStatement__M35_ReturnValuesOnConditionCheckFailure(var_returnValuesOnConditionCheckFailure));
    }
    public static Amazon.DynamoDBv2.Model.ItemResponse FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_ItemResponse(software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemResponse value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.ItemResponse concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.ItemResponse)value; Amazon.DynamoDBv2.Model.ItemResponse converted = new Amazon.DynamoDBv2.Model.ItemResponse(); if (concrete._Item.is_Some) converted.Item = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_ItemResponse__M4_Item(concrete._Item); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemResponse ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_ItemResponse(Amazon.DynamoDBv2.Model.ItemResponse value)
    {

      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> var_item = value.Item != null ? value.Item : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.ItemResponse(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_ItemResponse__M4_Item(var_item));
    }
    public static Amazon.DynamoDBv2.Model.KeysAndAttributes FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes(software.amazon.cryptography.services.dynamodb.internaldafny.types._IKeysAndAttributes value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.KeysAndAttributes concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.KeysAndAttributes)value; Amazon.DynamoDBv2.Model.KeysAndAttributes converted = new Amazon.DynamoDBv2.Model.KeysAndAttributes(); converted.Keys = (System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes__M4_Keys(concrete._Keys);
      if (concrete._AttributesToGet.is_Some) converted.AttributesToGet = (System.Collections.Generic.List<string>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes__M15_AttributesToGet(concrete._AttributesToGet);
      if (concrete._ConsistentRead.is_Some) converted.ConsistentRead = (bool)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes__M14_ConsistentRead(concrete._ConsistentRead);
      if (concrete._ProjectionExpression.is_Some) converted.ProjectionExpression = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes__M20_ProjectionExpression(concrete._ProjectionExpression);
      if (concrete._ExpressionAttributeNames.is_Some) converted.ExpressionAttributeNames = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes__M24_ExpressionAttributeNames(concrete._ExpressionAttributeNames); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IKeysAndAttributes ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes(Amazon.DynamoDBv2.Model.KeysAndAttributes value)
    {

      System.Collections.Generic.List<string> var_attributesToGet = value.AttributesToGet != null ? value.AttributesToGet : (System.Collections.Generic.List<string>)null;
      bool? var_consistentRead = value.ConsistentRead != null ? value.ConsistentRead : (bool?)null;
      string var_projectionExpression = value.ProjectionExpression != null ? value.ProjectionExpression : (string)null;
      System.Collections.Generic.Dictionary<string, string> var_expressionAttributeNames = value.ExpressionAttributeNames != null ? value.ExpressionAttributeNames : (System.Collections.Generic.Dictionary<string, string>)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.KeysAndAttributes(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes__M4_Keys(value.Keys), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes__M15_AttributesToGet(var_attributesToGet), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes__M14_ConsistentRead(var_consistentRead), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes__M20_ProjectionExpression(var_projectionExpression), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes__M24_ExpressionAttributeNames(var_expressionAttributeNames));
    }
    public static Amazon.DynamoDBv2.Model.BatchStatementRequest FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BatchStatementRequest(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementRequest value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest)value; Amazon.DynamoDBv2.Model.BatchStatementRequest converted = new Amazon.DynamoDBv2.Model.BatchStatementRequest(); converted.Statement = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BatchStatementRequest__M9_Statement(concrete._Statement);
      if (concrete._Parameters.is_Some) converted.Parameters = (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BatchStatementRequest__M10_Parameters(concrete._Parameters);
      if (concrete._ConsistentRead.is_Some) converted.ConsistentRead = (bool)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BatchStatementRequest__M14_ConsistentRead(concrete._ConsistentRead);
      if (concrete._ReturnValuesOnConditionCheckFailure.is_Some) converted.ReturnValuesOnConditionCheckFailure = (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BatchStatementRequest__M35_ReturnValuesOnConditionCheckFailure(concrete._ReturnValuesOnConditionCheckFailure); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementRequest ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BatchStatementRequest(Amazon.DynamoDBv2.Model.BatchStatementRequest value)
    {

      System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> var_parameters = value.Parameters != null ? value.Parameters : (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>)null;
      bool? var_consistentRead = value.ConsistentRead != null ? value.ConsistentRead : (bool?)null;
      Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure var_returnValuesOnConditionCheckFailure = value.ReturnValuesOnConditionCheckFailure != null ? value.ReturnValuesOnConditionCheckFailure : (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BatchStatementRequest__M9_Statement(value.Statement), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BatchStatementRequest__M10_Parameters(var_parameters), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BatchStatementRequest__M14_ConsistentRead(var_consistentRead), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BatchStatementRequest__M35_ReturnValuesOnConditionCheckFailure(var_returnValuesOnConditionCheckFailure));
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemCollectionMetrics> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionMetricsMultiple(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics> value)
    {
      return new System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemCollectionMetrics>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionMetricsMultiple__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionMetricsMultiple(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.ItemCollectionMetrics> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionMetricsMultiple__M6_member).ToArray());
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static System.IO.MemoryStream FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue(Dafny.ISequence<byte> value)
    {
      return new System.IO.MemoryStream(value.Elements);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue(System.IO.MemoryStream value)
    {
      if (value.ToArray().Length == 0 && value.Length > 0)
      {
        throw new System.ArgumentException("Fatal Error: MemoryStream instance not backed by an array!");
      }
      return Dafny.Sequence<byte>.FromArray(value.ToArray());

    }
    public static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue(Dafny.ISequence<Dafny.ISequence<char>> value)
    {
      return new System.Collections.Generic.List<string>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue__M6_member));
    }
    public static Dafny.ISequence<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue(System.Collections.Generic.List<string> value)
    {
      return Dafny.Sequence<Dafny.ISequence<char>>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue__M6_member).ToArray());
    }
    public static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue(Dafny.ISequence<Dafny.ISequence<char>> value)
    {
      return new System.Collections.Generic.List<string>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue__M6_member));
    }
    public static Dafny.ISequence<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue(System.Collections.Generic.List<string> value)
    {
      return Dafny.Sequence<Dafny.ISequence<char>>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue__M6_member).ToArray());
    }
    public static System.Collections.Generic.List<System.IO.MemoryStream> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue(Dafny.ISequence<Dafny.ISequence<byte>> value)
    {
      return new System.Collections.Generic.List<System.IO.MemoryStream>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue__M6_member));
    }
    public static Dafny.ISequence<Dafny.ISequence<byte>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue(System.Collections.Generic.List<System.IO.MemoryStream> value)
    {
      return Dafny.Sequence<Dafny.ISequence<byte>>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue__M6_member).ToArray());
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return value.ItemEnumerable.ToDictionary(pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M3_key(pair.Car), pair => FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M5_value(pair.Cdr));
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return Dafny.Map<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>.FromCollection(value.Select(pair =>
         new Dafny.Pair<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M3_key(pair.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M5_value(pair.Value))
     ));
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return new System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue__M6_member).ToArray());
    }
    public static bool FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_NullAttributeValue(bool value)
    {
      return value;
    }
    public static bool ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_NullAttributeValue(bool value)
    {
      return value;
    }
    public static bool FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BooleanAttributeValue(bool value)
    {
      return value;
    }
    public static bool ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BooleanAttributeValue(bool value)
    {
      return value;
    }
    public static Amazon.DynamoDBv2.Model.BatchStatementResponse FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_BatchStatementResponse(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementResponse value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementResponse concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementResponse)value; Amazon.DynamoDBv2.Model.BatchStatementResponse converted = new Amazon.DynamoDBv2.Model.BatchStatementResponse(); if (concrete._Error.is_Some) converted.Error = (Amazon.DynamoDBv2.Model.BatchStatementError)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_BatchStatementResponse__M5_Error(concrete._Error);
      if (concrete._TableName.is_Some) converted.TableName = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_BatchStatementResponse__M9_TableName(concrete._TableName);
      if (concrete._Item.is_Some) converted.Item = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_BatchStatementResponse__M4_Item(concrete._Item); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementResponse ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_BatchStatementResponse(Amazon.DynamoDBv2.Model.BatchStatementResponse value)
    {

      Amazon.DynamoDBv2.Model.BatchStatementError var_error = value.Error != null ? value.Error : (Amazon.DynamoDBv2.Model.BatchStatementError)null;
      string var_tableName = value.TableName != null ? value.TableName : (string)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> var_item = value.Item != null ? value.Item : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementResponse(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_BatchStatementResponse__M5_Error(var_error), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_BatchStatementResponse__M9_TableName(var_tableName), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_BatchStatementResponse__M4_Item(var_item));
    }
    public static Amazon.DynamoDBv2.Model.WriteRequest FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_WriteRequests__M6_member(software.amazon.cryptography.services.dynamodb.internaldafny.types._IWriteRequest value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_WriteRequest(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IWriteRequest ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_WriteRequests__M6_member(Amazon.DynamoDBv2.Model.WriteRequest value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_WriteRequest(value);
    }
    public static Amazon.DynamoDBv2.Model.Get FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_TransactGetItem__M3_Get(software.amazon.cryptography.services.dynamodb.internaldafny.types._IGet value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Get(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IGet ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_TransactGetItem__M3_Get(Amazon.DynamoDBv2.Model.Get value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Get(value);
    }
    public static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExpectedAttributeValue__M5_Value(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.Model.AttributeValue)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExpectedAttributeValue__M5_Value(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue((Amazon.DynamoDBv2.Model.AttributeValue)value));
    }
    public static bool? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExpectedAttributeValue__M6_Exists(Wrappers_Compile._IOption<bool> value)
    {
      return value.is_None ? (bool?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_BooleanObject(value.Extract());
    }
    public static Wrappers_Compile._IOption<bool> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExpectedAttributeValue__M6_Exists(bool? value)
    {
      return value == null ? Wrappers_Compile.Option<bool>.create_None() : Wrappers_Compile.Option<bool>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_BooleanObject((bool)value));
    }
    public static Amazon.DynamoDBv2.ComparisonOperator FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExpectedAttributeValue__M18_ComparisonOperator(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IComparisonOperator> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ComparisonOperator)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ComparisonOperator(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IComparisonOperator> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExpectedAttributeValue__M18_ComparisonOperator(Amazon.DynamoDBv2.ComparisonOperator value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IComparisonOperator>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IComparisonOperator>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ComparisonOperator((Amazon.DynamoDBv2.ComparisonOperator)value));
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExpectedAttributeValue__M18_AttributeValueList(Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_AttributeValueList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ExpectedAttributeValue__M18_AttributeValueList(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_AttributeValueList((System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_AttributeValueUpdate__M5_Value(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.Model.AttributeValue)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_AttributeValueUpdate__M5_Value(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue((Amazon.DynamoDBv2.Model.AttributeValue)value));
    }
    public static Amazon.DynamoDBv2.AttributeAction FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_AttributeValueUpdate__M6_Action(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeAction> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.AttributeAction)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_AttributeAction(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeAction> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_AttributeValueUpdate__M6_Action(Amazon.DynamoDBv2.AttributeAction value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeAction>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeAction>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_AttributeAction((Amazon.DynamoDBv2.AttributeAction)value));
    }
    public static Amazon.DynamoDBv2.Model.ConditionCheck FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_TransactWriteItem__M14_ConditionCheck(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionCheck> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.Model.ConditionCheck)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionCheck> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_TransactWriteItem__M14_ConditionCheck(Amazon.DynamoDBv2.Model.ConditionCheck value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionCheck>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionCheck>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck((Amazon.DynamoDBv2.Model.ConditionCheck)value));
    }
    public static Amazon.DynamoDBv2.Model.Put FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_TransactWriteItem__M3_Put(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IPut> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.Model.Put)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IPut> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_TransactWriteItem__M3_Put(Amazon.DynamoDBv2.Model.Put value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IPut>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IPut>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put((Amazon.DynamoDBv2.Model.Put)value));
    }
    public static Amazon.DynamoDBv2.Model.Delete FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_TransactWriteItem__M6_Delete(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IDelete> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.Model.Delete)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IDelete> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_TransactWriteItem__M6_Delete(Amazon.DynamoDBv2.Model.Delete value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IDelete>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IDelete>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete((Amazon.DynamoDBv2.Model.Delete)value));
    }
    public static Amazon.DynamoDBv2.Model.Update FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_TransactWriteItem__M6_Update(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IUpdate> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.Model.Update)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IUpdate> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_TransactWriteItem__M6_Update(Amazon.DynamoDBv2.Model.Update value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IUpdate>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IUpdate>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update((Amazon.DynamoDBv2.Model.Update)value));
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_Condition__M18_AttributeValueList(Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_AttributeValueList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_Condition__M18_AttributeValueList(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_AttributeValueList((System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.ComparisonOperator FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_Condition__M18_ComparisonOperator(software.amazon.cryptography.services.dynamodb.internaldafny.types._IComparisonOperator value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ComparisonOperator(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IComparisonOperator ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_Condition__M18_ComparisonOperator(Amazon.DynamoDBv2.ComparisonOperator value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ComparisonOperator(value);
    }
    public static double? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_Capacity__M17_ReadCapacityUnits(Wrappers_Compile._IOption<Dafny.ISequence<byte>> value)
    {
      return value.is_None ? (double?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ConsumedCapacityUnits(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<byte>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_Capacity__M17_ReadCapacityUnits(double? value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<byte>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<byte>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ConsumedCapacityUnits((double)value));
    }
    public static double? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_Capacity__M18_WriteCapacityUnits(Wrappers_Compile._IOption<Dafny.ISequence<byte>> value)
    {
      return value.is_None ? (double?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ConsumedCapacityUnits(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<byte>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_Capacity__M18_WriteCapacityUnits(double? value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<byte>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<byte>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ConsumedCapacityUnits((double)value));
    }
    public static double? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_Capacity__M13_CapacityUnits(Wrappers_Compile._IOption<Dafny.ISequence<byte>> value)
    {
      return value.is_None ? (double?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ConsumedCapacityUnits(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<byte>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_Capacity__M13_CapacityUnits(double? value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<byte>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<byte>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ConsumedCapacityUnits((double)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_SecondaryIndexesCapacityMap__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_IndexName(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_SecondaryIndexesCapacityMap__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_IndexName(value);
    }
    public static Amazon.DynamoDBv2.Model.Capacity FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_SecondaryIndexesCapacityMap__M5_value(software.amazon.cryptography.services.dynamodb.internaldafny.types._ICapacity value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_Capacity(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._ICapacity ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_SecondaryIndexesCapacityMap__M5_value(Amazon.DynamoDBv2.Model.Capacity value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_Capacity(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionKeyAttributeMap__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionKeyAttributeMap__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionKeyAttributeMap__M5_value(software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionKeyAttributeMap__M5_value(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static double FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S31_ItemCollectionSizeEstimateRange__M6_member(Dafny.ISequence<byte> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S31_ItemCollectionSizeEstimateBound(value);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S31_ItemCollectionSizeEstimateRange__M6_member(double value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S31_ItemCollectionSizeEstimateBound(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ParameterizedStatement__M9_Statement(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_PartiQLStatement(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ParameterizedStatement__M9_Statement(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_PartiQLStatement(value);
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ParameterizedStatement__M10_Parameters(Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_PreparedStatementParameters(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ParameterizedStatement__M10_Parameters(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_PreparedStatementParameters((System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ParameterizedStatement__M35_ReturnValuesOnConditionCheckFailure(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S35_ReturnValuesOnConditionCheckFailure(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_ParameterizedStatement__M35_ReturnValuesOnConditionCheckFailure(Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S35_ReturnValuesOnConditionCheckFailure((Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_ItemResponse__M4_Item(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_ItemResponse__M4_Item(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes__M4_Keys(Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S7_KeyList(value);
    }
    public static Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes__M4_Keys(System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S7_KeyList(value);
    }
    public static System.Collections.Generic.List<string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes__M15_AttributesToGet(Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<string>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<Dafny.ISequence<char>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes__M15_AttributesToGet(System.Collections.Generic.List<string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<Dafny.ISequence<char>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_AttributeNameList((System.Collections.Generic.List<string>)value));
    }
    public static bool? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes__M14_ConsistentRead(Wrappers_Compile._IOption<bool> value)
    {
      return value.is_None ? (bool?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConsistentRead(value.Extract());
    }
    public static Wrappers_Compile._IOption<bool> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes__M14_ConsistentRead(bool? value)
    {
      return value == null ? Wrappers_Compile.Option<bool>.create_None() : Wrappers_Compile.Option<bool>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConsistentRead((bool)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes__M20_ProjectionExpression(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ProjectionExpression(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes__M20_ProjectionExpression(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ProjectionExpression((string)value));
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes__M24_ExpressionAttributeNames(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, string>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_KeysAndAttributes__M24_ExpressionAttributeNames(System.Collections.Generic.Dictionary<string, string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap((System.Collections.Generic.Dictionary<string, string>)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BatchStatementRequest__M9_Statement(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_PartiQLStatement(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BatchStatementRequest__M9_Statement(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_PartiQLStatement(value);
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BatchStatementRequest__M10_Parameters(Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_PreparedStatementParameters(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BatchStatementRequest__M10_Parameters(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_PreparedStatementParameters((System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static bool? FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BatchStatementRequest__M14_ConsistentRead(Wrappers_Compile._IOption<bool> value)
    {
      return value.is_None ? (bool?)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConsistentRead(value.Extract());
    }
    public static Wrappers_Compile._IOption<bool> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BatchStatementRequest__M14_ConsistentRead(bool? value)
    {
      return value == null ? Wrappers_Compile.Option<bool>.create_None() : Wrappers_Compile.Option<bool>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConsistentRead((bool)value));
    }
    public static Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BatchStatementRequest__M35_ReturnValuesOnConditionCheckFailure(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S35_ReturnValuesOnConditionCheckFailure(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_BatchStatementRequest__M35_ReturnValuesOnConditionCheckFailure(Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S35_ReturnValuesOnConditionCheckFailure((Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)value));
    }
    public static Amazon.DynamoDBv2.Model.ItemCollectionMetrics FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionMetricsMultiple__M6_member(software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ItemCollectionMetrics(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IItemCollectionMetrics ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S29_ItemCollectionMetricsMultiple__M6_member(Amazon.DynamoDBv2.Model.ItemCollectionMetrics value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S21_ItemCollectionMetrics(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue__M6_member(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_StringSetAttributeValue__M6_member(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_StringAttributeValue(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue__M6_member(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_NumberSetAttributeValue__M6_member(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_NumberAttributeValue(value);
    }
    public static System.IO.MemoryStream FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue__M6_member(Dafny.ISequence<byte> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue(value);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S23_BinarySetAttributeValue__M6_member(System.IO.MemoryStream value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_BinaryAttributeValue(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M3_key(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M3_key(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_AttributeName(value);
    }
    public static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M5_value(software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S17_MapAttributeValue__M5_value(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue__M6_member(software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ListAttributeValue__M6_member(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static Amazon.DynamoDBv2.Model.BatchStatementError FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_BatchStatementResponse__M5_Error(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementError> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.Model.BatchStatementError)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchStatementError(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementError> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_BatchStatementResponse__M5_Error(Amazon.DynamoDBv2.Model.BatchStatementError value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementError>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementError>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchStatementError((Amazon.DynamoDBv2.Model.BatchStatementError)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_BatchStatementResponse__M9_TableName(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_BatchStatementResponse__M9_TableName(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S9_TableName((string)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_BatchStatementResponse__M4_Item(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S22_BatchStatementResponse__M4_Item(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.Model.WriteRequest FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_WriteRequest(software.amazon.cryptography.services.dynamodb.internaldafny.types._IWriteRequest value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest)value; Amazon.DynamoDBv2.Model.WriteRequest converted = new Amazon.DynamoDBv2.Model.WriteRequest(); if (concrete._PutRequest.is_Some) converted.PutRequest = (Amazon.DynamoDBv2.Model.PutRequest)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_WriteRequest__M10_PutRequest(concrete._PutRequest);
      if (concrete._DeleteRequest.is_Some) converted.DeleteRequest = (Amazon.DynamoDBv2.Model.DeleteRequest)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_WriteRequest__M13_DeleteRequest(concrete._DeleteRequest); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IWriteRequest ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_WriteRequest(Amazon.DynamoDBv2.Model.WriteRequest value)
    {

      Amazon.DynamoDBv2.Model.PutRequest var_putRequest = value.PutRequest != null ? value.PutRequest : (Amazon.DynamoDBv2.Model.PutRequest)null;
      Amazon.DynamoDBv2.Model.DeleteRequest var_deleteRequest = value.DeleteRequest != null ? value.DeleteRequest : (Amazon.DynamoDBv2.Model.DeleteRequest)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_WriteRequest__M10_PutRequest(var_putRequest), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_WriteRequest__M13_DeleteRequest(var_deleteRequest));
    }
    public static Amazon.DynamoDBv2.Model.Get FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Get(software.amazon.cryptography.services.dynamodb.internaldafny.types._IGet value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.Get concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.Get)value; Amazon.DynamoDBv2.Model.Get converted = new Amazon.DynamoDBv2.Model.Get(); converted.Key = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Get__M3_Key(concrete._Key);
      converted.TableName = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Get__M9_TableName(concrete._TableName);
      if (concrete._ProjectionExpression.is_Some) converted.ProjectionExpression = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Get__M20_ProjectionExpression(concrete._ProjectionExpression);
      if (concrete._ExpressionAttributeNames.is_Some) converted.ExpressionAttributeNames = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Get__M24_ExpressionAttributeNames(concrete._ExpressionAttributeNames); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IGet ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Get(Amazon.DynamoDBv2.Model.Get value)
    {

      string var_projectionExpression = value.ProjectionExpression != null ? value.ProjectionExpression : (string)null;
      System.Collections.Generic.Dictionary<string, string> var_expressionAttributeNames = value.ExpressionAttributeNames != null ? value.ExpressionAttributeNames : (System.Collections.Generic.Dictionary<string, string>)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.Get(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Get__M3_Key(value.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Get__M9_TableName(value.TableName), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Get__M20_ProjectionExpression(var_projectionExpression), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Get__M24_ExpressionAttributeNames(var_expressionAttributeNames));
    }
    public static Amazon.DynamoDBv2.ComparisonOperator FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ComparisonOperator(software.amazon.cryptography.services.dynamodb.internaldafny.types._IComparisonOperator value)
    {
      if (value.is_EQ) return Amazon.DynamoDBv2.ComparisonOperator.EQ;
      if (value.is_NE) return Amazon.DynamoDBv2.ComparisonOperator.NE;
      if (value.is_IN) return Amazon.DynamoDBv2.ComparisonOperator.IN;
      if (value.is_LE) return Amazon.DynamoDBv2.ComparisonOperator.LE;
      if (value.is_LT) return Amazon.DynamoDBv2.ComparisonOperator.LT;
      if (value.is_GE) return Amazon.DynamoDBv2.ComparisonOperator.GE;
      if (value.is_GT) return Amazon.DynamoDBv2.ComparisonOperator.GT;
      if (value.is_BETWEEN) return Amazon.DynamoDBv2.ComparisonOperator.BETWEEN;
      if (value.is_NOT__NULL) return Amazon.DynamoDBv2.ComparisonOperator.NOT_NULL;
      if (value.is_NULL) return Amazon.DynamoDBv2.ComparisonOperator.NULL;
      if (value.is_CONTAINS) return Amazon.DynamoDBv2.ComparisonOperator.CONTAINS;
      if (value.is_NOT__CONTAINS) return Amazon.DynamoDBv2.ComparisonOperator.NOT_CONTAINS;
      if (value.is_BEGINS__WITH) return Amazon.DynamoDBv2.ComparisonOperator.BEGINS_WITH;
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.ComparisonOperator value");
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IComparisonOperator ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_ComparisonOperator(Amazon.DynamoDBv2.ComparisonOperator value)
    {
      if (Amazon.DynamoDBv2.ComparisonOperator.EQ.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ComparisonOperator.create_EQ();
      if (Amazon.DynamoDBv2.ComparisonOperator.NE.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ComparisonOperator.create_NE();
      if (Amazon.DynamoDBv2.ComparisonOperator.IN.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ComparisonOperator.create_IN();
      if (Amazon.DynamoDBv2.ComparisonOperator.LE.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ComparisonOperator.create_LE();
      if (Amazon.DynamoDBv2.ComparisonOperator.LT.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ComparisonOperator.create_LT();
      if (Amazon.DynamoDBv2.ComparisonOperator.GE.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ComparisonOperator.create_GE();
      if (Amazon.DynamoDBv2.ComparisonOperator.GT.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ComparisonOperator.create_GT();
      if (Amazon.DynamoDBv2.ComparisonOperator.BETWEEN.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ComparisonOperator.create_BETWEEN();
      if (Amazon.DynamoDBv2.ComparisonOperator.NOT_NULL.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ComparisonOperator.create_NOT__NULL();
      if (Amazon.DynamoDBv2.ComparisonOperator.NULL.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ComparisonOperator.create_NULL();
      if (Amazon.DynamoDBv2.ComparisonOperator.CONTAINS.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ComparisonOperator.create_CONTAINS();
      if (Amazon.DynamoDBv2.ComparisonOperator.NOT_CONTAINS.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ComparisonOperator.create_NOT__CONTAINS();
      if (Amazon.DynamoDBv2.ComparisonOperator.BEGINS_WITH.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.ComparisonOperator.create_BEGINS__WITH();
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.ComparisonOperator value");
    }
    public static System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_AttributeValueList(Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return new System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_AttributeValueList__M6_member));
    }
    public static Dafny.ISequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_AttributeValueList(System.Collections.Generic.List<Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return Dafny.Sequence<software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_AttributeValueList__M6_member).ToArray());
    }
    public static Amazon.DynamoDBv2.AttributeAction FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_AttributeAction(software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeAction value)
    {
      if (value.is_ADD) return Amazon.DynamoDBv2.AttributeAction.ADD;
      if (value.is_PUT) return Amazon.DynamoDBv2.AttributeAction.PUT;
      if (value.is_DELETE) return Amazon.DynamoDBv2.AttributeAction.DELETE;
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.AttributeAction value");
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeAction ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S15_AttributeAction(Amazon.DynamoDBv2.AttributeAction value)
    {
      if (Amazon.DynamoDBv2.AttributeAction.ADD.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeAction.create_ADD();
      if (Amazon.DynamoDBv2.AttributeAction.PUT.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeAction.create_PUT();
      if (Amazon.DynamoDBv2.AttributeAction.DELETE.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeAction.create_DELETE();
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.AttributeAction value");
    }
    public static Amazon.DynamoDBv2.Model.ConditionCheck FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck(software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionCheck value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.ConditionCheck concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.ConditionCheck)value; Amazon.DynamoDBv2.Model.ConditionCheck converted = new Amazon.DynamoDBv2.Model.ConditionCheck(); converted.Key = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M3_Key(concrete._Key);
      converted.TableName = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M9_TableName(concrete._TableName);
      converted.ConditionExpression = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M19_ConditionExpression(concrete._ConditionExpression);
      if (concrete._ExpressionAttributeNames.is_Some) converted.ExpressionAttributeNames = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M24_ExpressionAttributeNames(concrete._ExpressionAttributeNames);
      if (concrete._ExpressionAttributeValues.is_Some) converted.ExpressionAttributeValues = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M25_ExpressionAttributeValues(concrete._ExpressionAttributeValues);
      if (concrete._ReturnValuesOnConditionCheckFailure.is_Some) converted.ReturnValuesOnConditionCheckFailure = (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M35_ReturnValuesOnConditionCheckFailure(concrete._ReturnValuesOnConditionCheckFailure); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IConditionCheck ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck(Amazon.DynamoDBv2.Model.ConditionCheck value)
    {

      System.Collections.Generic.Dictionary<string, string> var_expressionAttributeNames = value.ExpressionAttributeNames != null ? value.ExpressionAttributeNames : (System.Collections.Generic.Dictionary<string, string>)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> var_expressionAttributeValues = value.ExpressionAttributeValues != null ? value.ExpressionAttributeValues : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null;
      Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure var_returnValuesOnConditionCheckFailure = value.ReturnValuesOnConditionCheckFailure != null ? value.ReturnValuesOnConditionCheckFailure : (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.ConditionCheck(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M3_Key(value.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M9_TableName(value.TableName), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M19_ConditionExpression(value.ConditionExpression), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M24_ExpressionAttributeNames(var_expressionAttributeNames), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M25_ExpressionAttributeValues(var_expressionAttributeValues), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M35_ReturnValuesOnConditionCheckFailure(var_returnValuesOnConditionCheckFailure));
    }
    public static Amazon.DynamoDBv2.Model.Put FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put(software.amazon.cryptography.services.dynamodb.internaldafny.types._IPut value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.Put concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.Put)value; Amazon.DynamoDBv2.Model.Put converted = new Amazon.DynamoDBv2.Model.Put(); converted.Item = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M4_Item(concrete._Item);
      converted.TableName = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M9_TableName(concrete._TableName);
      if (concrete._ConditionExpression.is_Some) converted.ConditionExpression = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M19_ConditionExpression(concrete._ConditionExpression);
      if (concrete._ExpressionAttributeNames.is_Some) converted.ExpressionAttributeNames = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M24_ExpressionAttributeNames(concrete._ExpressionAttributeNames);
      if (concrete._ExpressionAttributeValues.is_Some) converted.ExpressionAttributeValues = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M25_ExpressionAttributeValues(concrete._ExpressionAttributeValues);
      if (concrete._ReturnValuesOnConditionCheckFailure.is_Some) converted.ReturnValuesOnConditionCheckFailure = (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M35_ReturnValuesOnConditionCheckFailure(concrete._ReturnValuesOnConditionCheckFailure); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IPut ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put(Amazon.DynamoDBv2.Model.Put value)
    {

      string var_conditionExpression = value.ConditionExpression != null ? value.ConditionExpression : (string)null;
      System.Collections.Generic.Dictionary<string, string> var_expressionAttributeNames = value.ExpressionAttributeNames != null ? value.ExpressionAttributeNames : (System.Collections.Generic.Dictionary<string, string>)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> var_expressionAttributeValues = value.ExpressionAttributeValues != null ? value.ExpressionAttributeValues : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null;
      Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure var_returnValuesOnConditionCheckFailure = value.ReturnValuesOnConditionCheckFailure != null ? value.ReturnValuesOnConditionCheckFailure : (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.Put(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M4_Item(value.Item), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M9_TableName(value.TableName), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M19_ConditionExpression(var_conditionExpression), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M24_ExpressionAttributeNames(var_expressionAttributeNames), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M25_ExpressionAttributeValues(var_expressionAttributeValues), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M35_ReturnValuesOnConditionCheckFailure(var_returnValuesOnConditionCheckFailure));
    }
    public static Amazon.DynamoDBv2.Model.Delete FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete(software.amazon.cryptography.services.dynamodb.internaldafny.types._IDelete value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.Delete concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.Delete)value; Amazon.DynamoDBv2.Model.Delete converted = new Amazon.DynamoDBv2.Model.Delete(); converted.Key = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M3_Key(concrete._Key);
      converted.TableName = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M9_TableName(concrete._TableName);
      if (concrete._ConditionExpression.is_Some) converted.ConditionExpression = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M19_ConditionExpression(concrete._ConditionExpression);
      if (concrete._ExpressionAttributeNames.is_Some) converted.ExpressionAttributeNames = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M24_ExpressionAttributeNames(concrete._ExpressionAttributeNames);
      if (concrete._ExpressionAttributeValues.is_Some) converted.ExpressionAttributeValues = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M25_ExpressionAttributeValues(concrete._ExpressionAttributeValues);
      if (concrete._ReturnValuesOnConditionCheckFailure.is_Some) converted.ReturnValuesOnConditionCheckFailure = (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M35_ReturnValuesOnConditionCheckFailure(concrete._ReturnValuesOnConditionCheckFailure); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IDelete ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete(Amazon.DynamoDBv2.Model.Delete value)
    {

      string var_conditionExpression = value.ConditionExpression != null ? value.ConditionExpression : (string)null;
      System.Collections.Generic.Dictionary<string, string> var_expressionAttributeNames = value.ExpressionAttributeNames != null ? value.ExpressionAttributeNames : (System.Collections.Generic.Dictionary<string, string>)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> var_expressionAttributeValues = value.ExpressionAttributeValues != null ? value.ExpressionAttributeValues : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null;
      Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure var_returnValuesOnConditionCheckFailure = value.ReturnValuesOnConditionCheckFailure != null ? value.ReturnValuesOnConditionCheckFailure : (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.Delete(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M3_Key(value.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M9_TableName(value.TableName), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M19_ConditionExpression(var_conditionExpression), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M24_ExpressionAttributeNames(var_expressionAttributeNames), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M25_ExpressionAttributeValues(var_expressionAttributeValues), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M35_ReturnValuesOnConditionCheckFailure(var_returnValuesOnConditionCheckFailure));
    }
    public static Amazon.DynamoDBv2.Model.Update FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update(software.amazon.cryptography.services.dynamodb.internaldafny.types._IUpdate value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.Update concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.Update)value; Amazon.DynamoDBv2.Model.Update converted = new Amazon.DynamoDBv2.Model.Update(); converted.Key = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M3_Key(concrete._Key);
      converted.UpdateExpression = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M16_UpdateExpression(concrete._UpdateExpression);
      converted.TableName = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M9_TableName(concrete._TableName);
      if (concrete._ConditionExpression.is_Some) converted.ConditionExpression = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M19_ConditionExpression(concrete._ConditionExpression);
      if (concrete._ExpressionAttributeNames.is_Some) converted.ExpressionAttributeNames = (System.Collections.Generic.Dictionary<string, string>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M24_ExpressionAttributeNames(concrete._ExpressionAttributeNames);
      if (concrete._ExpressionAttributeValues.is_Some) converted.ExpressionAttributeValues = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M25_ExpressionAttributeValues(concrete._ExpressionAttributeValues);
      if (concrete._ReturnValuesOnConditionCheckFailure.is_Some) converted.ReturnValuesOnConditionCheckFailure = (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M35_ReturnValuesOnConditionCheckFailure(concrete._ReturnValuesOnConditionCheckFailure); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IUpdate ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update(Amazon.DynamoDBv2.Model.Update value)
    {

      string var_conditionExpression = value.ConditionExpression != null ? value.ConditionExpression : (string)null;
      System.Collections.Generic.Dictionary<string, string> var_expressionAttributeNames = value.ExpressionAttributeNames != null ? value.ExpressionAttributeNames : (System.Collections.Generic.Dictionary<string, string>)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> var_expressionAttributeValues = value.ExpressionAttributeValues != null ? value.ExpressionAttributeValues : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null;
      Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure var_returnValuesOnConditionCheckFailure = value.ReturnValuesOnConditionCheckFailure != null ? value.ReturnValuesOnConditionCheckFailure : (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.Update(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M3_Key(value.Key), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M16_UpdateExpression(value.UpdateExpression), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M9_TableName(value.TableName), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M19_ConditionExpression(var_conditionExpression), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M24_ExpressionAttributeNames(var_expressionAttributeNames), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M25_ExpressionAttributeValues(var_expressionAttributeValues), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M35_ReturnValuesOnConditionCheckFailure(var_returnValuesOnConditionCheckFailure));
    }
    public static double FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S31_ItemCollectionSizeEstimateBound(Dafny.ISequence<byte> value)
    {
      return BitConverter.ToDouble(value.CloneAsArray(), 0);
    }
    public static Dafny.ISequence<byte> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S31_ItemCollectionSizeEstimateBound(double value)
    {
      return Dafny.Sequence<byte>.FromArray(BitConverter.GetBytes(value));
    }
    public static System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S7_KeyList(Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return new System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>>(value.Elements.Select(FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S7_KeyList__M6_member));
    }
    public static Dafny.ISequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S7_KeyList(System.Collections.Generic.List<System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>> value)
    {
      return Dafny.Sequence<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.FromArray(value.Select(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S7_KeyList__M6_member).ToArray());
    }
    public static Amazon.DynamoDBv2.Model.BatchStatementError FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchStatementError(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementError value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementError concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementError)value; Amazon.DynamoDBv2.Model.BatchStatementError converted = new Amazon.DynamoDBv2.Model.BatchStatementError(); if (concrete._Code.is_Some) converted.Code = (Amazon.DynamoDBv2.BatchStatementErrorCodeEnum)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchStatementError__M4_Code(concrete._Code);
      if (concrete._Message.is_Some) converted.Message = (string)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchStatementError__M7_Message(concrete._Message);
      if (concrete._Item.is_Some) converted.Item = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchStatementError__M4_Item(concrete._Item); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementError ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchStatementError(Amazon.DynamoDBv2.Model.BatchStatementError value)
    {

      Amazon.DynamoDBv2.BatchStatementErrorCodeEnum var_code = value.Code != null ? value.Code : (Amazon.DynamoDBv2.BatchStatementErrorCodeEnum)null;
      string var_message = value.Message != null ? value.Message : (string)null;
      System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> var_item = value.Item != null ? value.Item : (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null;
      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementError(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchStatementError__M4_Code(var_code), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchStatementError__M7_Message(var_message), ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchStatementError__M4_Item(var_item));
    }
    public static Amazon.DynamoDBv2.Model.PutRequest FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_WriteRequest__M10_PutRequest(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IPutRequest> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.Model.PutRequest)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_PutRequest(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IPutRequest> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_WriteRequest__M10_PutRequest(Amazon.DynamoDBv2.Model.PutRequest value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IPutRequest>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IPutRequest>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_PutRequest((Amazon.DynamoDBv2.Model.PutRequest)value));
    }
    public static Amazon.DynamoDBv2.Model.DeleteRequest FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_WriteRequest__M13_DeleteRequest(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IDeleteRequest> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.Model.DeleteRequest)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_DeleteRequest(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IDeleteRequest> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_WriteRequest__M13_DeleteRequest(Amazon.DynamoDBv2.Model.DeleteRequest value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IDeleteRequest>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IDeleteRequest>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_DeleteRequest((Amazon.DynamoDBv2.Model.DeleteRequest)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Get__M3_Key(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Get__M3_Key(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Get__M9_TableName(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Get__M9_TableName(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Get__M20_ProjectionExpression(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ProjectionExpression(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Get__M20_ProjectionExpression(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S20_ProjectionExpression((string)value));
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Get__M24_ExpressionAttributeNames(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, string>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Get__M24_ExpressionAttributeNames(System.Collections.Generic.Dictionary<string, string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap((System.Collections.Generic.Dictionary<string, string>)value));
    }
    public static Amazon.DynamoDBv2.Model.AttributeValue FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_AttributeValueList__M6_member(software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S18_AttributeValueList__M6_member(Amazon.DynamoDBv2.Model.AttributeValue value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_AttributeValue(value);
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M3_Key(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M3_Key(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M9_TableName(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M9_TableName(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M19_ConditionExpression(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionExpression(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M19_ConditionExpression(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionExpression(value);
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M24_ExpressionAttributeNames(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, string>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M24_ExpressionAttributeNames(System.Collections.Generic.Dictionary<string, string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap((System.Collections.Generic.Dictionary<string, string>)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M25_ExpressionAttributeValues(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M25_ExpressionAttributeValues(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M35_ReturnValuesOnConditionCheckFailure(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S35_ReturnValuesOnConditionCheckFailure(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S14_ConditionCheck__M35_ReturnValuesOnConditionCheckFailure(Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S35_ReturnValuesOnConditionCheckFailure((Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M4_Item(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_PutItemInputAttributeMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M4_Item(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_PutItemInputAttributeMap(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M9_TableName(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M9_TableName(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M19_ConditionExpression(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionExpression(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M19_ConditionExpression(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionExpression((string)value));
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M24_ExpressionAttributeNames(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, string>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M24_ExpressionAttributeNames(System.Collections.Generic.Dictionary<string, string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap((System.Collections.Generic.Dictionary<string, string>)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M25_ExpressionAttributeValues(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M25_ExpressionAttributeValues(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M35_ReturnValuesOnConditionCheckFailure(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S35_ReturnValuesOnConditionCheckFailure(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Put__M35_ReturnValuesOnConditionCheckFailure(Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S35_ReturnValuesOnConditionCheckFailure((Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M3_Key(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M3_Key(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M9_TableName(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M9_TableName(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M19_ConditionExpression(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionExpression(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M19_ConditionExpression(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionExpression((string)value));
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M24_ExpressionAttributeNames(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, string>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M24_ExpressionAttributeNames(System.Collections.Generic.Dictionary<string, string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap((System.Collections.Generic.Dictionary<string, string>)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M25_ExpressionAttributeValues(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M25_ExpressionAttributeValues(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M35_ReturnValuesOnConditionCheckFailure(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S35_ReturnValuesOnConditionCheckFailure(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Delete__M35_ReturnValuesOnConditionCheckFailure(Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S35_ReturnValuesOnConditionCheckFailure((Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M3_Key(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M3_Key(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M16_UpdateExpression(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateExpression(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M16_UpdateExpression(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S16_UpdateExpression(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M9_TableName(Dafny.ISequence<char> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M9_TableName(string value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S8_TableArn(value);
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M19_ConditionExpression(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionExpression(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M19_ConditionExpression(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_ConditionExpression((string)value));
    }
    public static System.Collections.Generic.Dictionary<string, string> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M24_ExpressionAttributeNames(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, string>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M24_ExpressionAttributeNames(System.Collections.Generic.Dictionary<string, string> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, Dafny.ISequence<char>>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S26_ExpressionAttributeNameMap((System.Collections.Generic.Dictionary<string, string>)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M25_ExpressionAttributeValues(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M25_ExpressionAttributeValues(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_ExpressionAttributeValueMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M35_ReturnValuesOnConditionCheckFailure(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S35_ReturnValuesOnConditionCheckFailure(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_Update__M35_ReturnValuesOnConditionCheckFailure(Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IReturnValuesOnConditionCheckFailure>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S35_ReturnValuesOnConditionCheckFailure((Amazon.DynamoDBv2.ReturnValuesOnConditionCheckFailure)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S7_KeyList__M6_member(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S7_KeyList__M6_member(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    public static Amazon.DynamoDBv2.BatchStatementErrorCodeEnum FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchStatementError__M4_Code(Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementErrorCodeEnum> value)
    {
      return value.is_None ? (Amazon.DynamoDBv2.BatchStatementErrorCodeEnum)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_BatchStatementErrorCodeEnum(value.Extract());
    }
    public static Wrappers_Compile._IOption<software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementErrorCodeEnum> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchStatementError__M4_Code(Amazon.DynamoDBv2.BatchStatementErrorCodeEnum value)
    {
      return value == null ? Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementErrorCodeEnum>.create_None() : Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementErrorCodeEnum>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_BatchStatementErrorCodeEnum((Amazon.DynamoDBv2.BatchStatementErrorCodeEnum)value));
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchStatementError__M7_Message(Wrappers_Compile._IOption<Dafny.ISequence<char>> value)
    {
      return value.is_None ? (string)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_String(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.ISequence<char>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchStatementError__M7_Message(string value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.ISequence<char>>.create_None() : Wrappers_Compile.Option<Dafny.ISequence<char>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_String((string)value));
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchStatementError__M4_Item(Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> value)
    {
      return value.is_None ? (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)null : FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap(value.Extract());
    }
    public static Wrappers_Compile._IOption<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S19_BatchStatementError__M4_Item(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return value == null ? Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_None() : Wrappers_Compile.Option<Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue>>.create_Some(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S12_AttributeMap((System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)value));
    }
    public static Amazon.DynamoDBv2.Model.PutRequest FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_PutRequest(software.amazon.cryptography.services.dynamodb.internaldafny.types._IPutRequest value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.PutRequest concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.PutRequest)value; Amazon.DynamoDBv2.Model.PutRequest converted = new Amazon.DynamoDBv2.Model.PutRequest(); converted.Item = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_PutRequest__M4_Item(concrete._Item); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IPutRequest ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_PutRequest(Amazon.DynamoDBv2.Model.PutRequest value)
    {


      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.PutRequest(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_PutRequest__M4_Item(value.Item));
    }
    public static Amazon.DynamoDBv2.Model.DeleteRequest FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_DeleteRequest(software.amazon.cryptography.services.dynamodb.internaldafny.types._IDeleteRequest value)
    {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteRequest concrete = (software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteRequest)value; Amazon.DynamoDBv2.Model.DeleteRequest converted = new Amazon.DynamoDBv2.Model.DeleteRequest(); converted.Key = (System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue>)FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_DeleteRequest__M3_Key(concrete._Key); return converted;
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IDeleteRequest ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_DeleteRequest(Amazon.DynamoDBv2.Model.DeleteRequest value)
    {


      return new software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteRequest(ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_DeleteRequest__M3_Key(value.Key));
    }
    public static Amazon.DynamoDBv2.BatchStatementErrorCodeEnum FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_BatchStatementErrorCodeEnum(software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementErrorCodeEnum value)
    {
      if (value.is_ConditionalCheckFailed) return Amazon.DynamoDBv2.BatchStatementErrorCodeEnum.ConditionalCheckFailed;
      if (value.is_ItemCollectionSizeLimitExceeded) return Amazon.DynamoDBv2.BatchStatementErrorCodeEnum.ItemCollectionSizeLimitExceeded;
      if (value.is_RequestLimitExceeded) return Amazon.DynamoDBv2.BatchStatementErrorCodeEnum.RequestLimitExceeded;
      if (value.is_ValidationError) return Amazon.DynamoDBv2.BatchStatementErrorCodeEnum.ValidationError;
      if (value.is_ProvisionedThroughputExceeded) return Amazon.DynamoDBv2.BatchStatementErrorCodeEnum.ProvisionedThroughputExceeded;
      if (value.is_TransactionConflict) return Amazon.DynamoDBv2.BatchStatementErrorCodeEnum.TransactionConflict;
      if (value.is_ThrottlingError) return Amazon.DynamoDBv2.BatchStatementErrorCodeEnum.ThrottlingError;
      if (value.is_InternalServerError) return Amazon.DynamoDBv2.BatchStatementErrorCodeEnum.InternalServerError;
      if (value.is_ResourceNotFound) return Amazon.DynamoDBv2.BatchStatementErrorCodeEnum.ResourceNotFound;
      if (value.is_AccessDenied) return Amazon.DynamoDBv2.BatchStatementErrorCodeEnum.AccessDenied;
      if (value.is_DuplicateItem) return Amazon.DynamoDBv2.BatchStatementErrorCodeEnum.DuplicateItem;
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.BatchStatementErrorCodeEnum value");
    }
    public static software.amazon.cryptography.services.dynamodb.internaldafny.types._IBatchStatementErrorCodeEnum ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S27_BatchStatementErrorCodeEnum(Amazon.DynamoDBv2.BatchStatementErrorCodeEnum value)
    {
      if (Amazon.DynamoDBv2.BatchStatementErrorCodeEnum.ConditionalCheckFailed.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementErrorCodeEnum.create_ConditionalCheckFailed();
      if (Amazon.DynamoDBv2.BatchStatementErrorCodeEnum.ItemCollectionSizeLimitExceeded.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementErrorCodeEnum.create_ItemCollectionSizeLimitExceeded();
      if (Amazon.DynamoDBv2.BatchStatementErrorCodeEnum.RequestLimitExceeded.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementErrorCodeEnum.create_RequestLimitExceeded();
      if (Amazon.DynamoDBv2.BatchStatementErrorCodeEnum.ValidationError.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementErrorCodeEnum.create_ValidationError();
      if (Amazon.DynamoDBv2.BatchStatementErrorCodeEnum.ProvisionedThroughputExceeded.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementErrorCodeEnum.create_ProvisionedThroughputExceeded();
      if (Amazon.DynamoDBv2.BatchStatementErrorCodeEnum.TransactionConflict.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementErrorCodeEnum.create_TransactionConflict();
      if (Amazon.DynamoDBv2.BatchStatementErrorCodeEnum.ThrottlingError.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementErrorCodeEnum.create_ThrottlingError();
      if (Amazon.DynamoDBv2.BatchStatementErrorCodeEnum.InternalServerError.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementErrorCodeEnum.create_InternalServerError();
      if (Amazon.DynamoDBv2.BatchStatementErrorCodeEnum.ResourceNotFound.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementErrorCodeEnum.create_ResourceNotFound();
      if (Amazon.DynamoDBv2.BatchStatementErrorCodeEnum.AccessDenied.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementErrorCodeEnum.create_AccessDenied();
      if (Amazon.DynamoDBv2.BatchStatementErrorCodeEnum.DuplicateItem.Equals(value)) return software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementErrorCodeEnum.create_DuplicateItem();
      throw new System.ArgumentException("Invalid Amazon.DynamoDBv2.BatchStatementErrorCodeEnum value");
    }
    public static string FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_String(Dafny.ISequence<char> value)
    {
      return new string(value.Elements);
    }
    public static Dafny.ISequence<char> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S6_String(string value)
    {
      return Dafny.Sequence<char>.FromString(value);
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_PutRequest__M4_Item(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_PutItemInputAttributeMap(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S10_PutRequest__M4_Item(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S24_PutItemInputAttributeMap(value);
    }
    public static System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_DeleteRequest__M3_Key(Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> value)
    {
      return FromDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    public static Dafny.IMap<Dafny.ISequence<char>, software.amazon.cryptography.services.dynamodb.internaldafny.types._IAttributeValue> ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S13_DeleteRequest__M3_Key(System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> value)
    {
      return ToDafny_N3_com__N9_amazonaws__N8_dynamodb__S3_Key(value);
    }
    public static System.Exception FromDafny_CommonError(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError value)
    {
      switch (value)
      {
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error_AwsCryptographyDbEncryptionSdkDynamoDb dafnyVal:
          return AWS.Cryptography.DbEncryptionSDK.DynamoDb.TypeConversion.FromDafny_CommonError(
            dafnyVal._AwsCryptographyDbEncryptionSdkDynamoDb
          );
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor dafnyVal:
          return AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.TypeConversion.FromDafny_CommonError(
            dafnyVal._AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor
          );
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error_AwsCryptographyDbEncryptionSdkStructuredEncryption dafnyVal:
          return AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.TypeConversion.FromDafny_CommonError(
            dafnyVal._AwsCryptographyDbEncryptionSdkStructuredEncryption
          );
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error_AwsCryptographyMaterialProviders dafnyVal:
          return AWS.Cryptography.MaterialProviders.TypeConversion.FromDafny_CommonError(
            dafnyVal._AwsCryptographyMaterialProviders
          );
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error_ComAmazonawsDynamodb dafnyVal:
          return Com.Amazonaws.Dynamodb.TypeConversion.FromDafny_CommonError(
            dafnyVal._ComAmazonawsDynamodb
          );
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error_DynamoDbEncryptionTransformsException dafnyVal:
          return FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_DynamoDbEncryptionTransformsException(dafnyVal);
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error_CollectionOfErrors dafnyVal:
          return new CollectionOfErrors(
              new System.Collections.Generic.List<Exception>(dafnyVal.dtor_list.CloneAsArray()
                .Select(x => TypeConversion.FromDafny_CommonError(x))),
              new string(dafnyVal.dtor_message.Elements));
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error_Opaque dafnyVal:
          return new OpaqueError(dafnyVal._obj);
        case software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error_OpaqueWithText dafnyVal:
          return new OpaqueWithTextError(dafnyVal._obj, dafnyVal._obj.ToString());
        default:
          // The switch MUST be complete for _IError, so `value` MUST NOT be an _IError. (How did you get here?)
          return new OpaqueError();
      }
    }
    public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError ToDafny_CommonError(System.Exception value)
    {
      switch (value.GetType().Namespace)
      {
        case "AWS.Cryptography.DbEncryptionSDK.StructuredEncryption":
          return software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error.create_AwsCryptographyDbEncryptionSdkStructuredEncryption(
            AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.TypeConversion.ToDafny_CommonError(value)
          );
        case "AWS.Cryptography.MaterialProviders":
          return software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error.create_AwsCryptographyMaterialProviders(
            AWS.Cryptography.MaterialProviders.TypeConversion.ToDafny_CommonError(value)
          );
        case "Com.Amazonaws.Dynamodb":
          return software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error.create_ComAmazonawsDynamodb(
            Com.Amazonaws.Dynamodb.TypeConversion.ToDafny_CommonError(value)
          );
      }
      switch (value)
      {
        case AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.DynamoDbEncryptionTransformsException exception:
          return ToDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N10_transforms__S37_DynamoDbEncryptionTransformsException(exception);
        case CollectionOfErrors collectionOfErrors:
          return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error_CollectionOfErrors(
            Dafny.Sequence<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types._IError>
              .FromArray(
                collectionOfErrors.list.Select
                    (x => TypeConversion.ToDafny_CommonError(x))
                  .ToArray()),
            Dafny.Sequence<char>.FromString(collectionOfErrors.Message)
          );
        // OpaqueError is redundant, but listed for completeness.
        case OpaqueError exception:
          return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error_Opaque(exception);
        case System.Exception exception:
          return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error_Opaque(exception);
        default:
          // The switch MUST be complete for System.Exception, so `value` MUST NOT be an System.Exception. (How did you get here?)
          return new software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error_Opaque(value);
      }
    }
  }
}
