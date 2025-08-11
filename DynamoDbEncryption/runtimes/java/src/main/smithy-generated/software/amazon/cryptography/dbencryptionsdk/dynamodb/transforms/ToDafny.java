// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms;

import Wrappers_Compile.Option;
import dafny.DafnyMap;
import dafny.DafnySequence;
import dafny.TypeDescriptor;
import java.lang.Character;
import java.lang.Integer;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error_DynamoDbEncryptionTransformsException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetNumberOfQueriesInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetNumberOfQueriesOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.IDynamoDbEncryptionTransformsClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ResolveAttributesInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ResolveAttributesOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.DynamoDbEncryptionTransformsException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.OpaqueError;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.OpaqueWithTextError;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementOutput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemOutput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemOutput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemInput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemOutput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementOutput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionOutput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemOutput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemInput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemOutput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsInput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsOutput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsInput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsOutput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemInput;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemOutput;

public class ToDafny {

  public static Error Error(RuntimeException nativeValue) {
    if (nativeValue instanceof DynamoDbEncryptionTransformsException) {
      return ToDafny.Error((DynamoDbEncryptionTransformsException) nativeValue);
    }
    if (nativeValue instanceof OpaqueError) {
      return ToDafny.Error((OpaqueError) nativeValue);
    }
    if (nativeValue instanceof OpaqueWithTextError) {
      return ToDafny.Error((OpaqueWithTextError) nativeValue);
    }
    if (nativeValue instanceof CollectionOfErrors) {
      return ToDafny.Error((CollectionOfErrors) nativeValue);
    }
    return Error.create_Opaque(nativeValue);
  }

  public static Error Error(OpaqueError nativeValue) {
    return Error.create_Opaque(nativeValue.obj());
  }

  public static Error Error(OpaqueWithTextError nativeValue) {
    return Error.create_OpaqueWithText(
      nativeValue.obj(),
      dafny.DafnySequence.asString(nativeValue.objMessage())
    );
  }

  public static Error Error(CollectionOfErrors nativeValue) {
    DafnySequence<? extends Error> list =
      software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue.list(),
        ToDafny::Error,
        Error._typeDescriptor()
      );
    DafnySequence<? extends Character> message =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.getMessage()
      );
    return Error.create_CollectionOfErrors(list, message);
  }

  public static BatchExecuteStatementInputTransformInput BatchExecuteStatementInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchExecuteStatementInputTransformInput nativeValue
  ) {
    BatchExecuteStatementInput sdkInput;
    sdkInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.BatchExecuteStatementInput(
        nativeValue.sdkInput()
      );
    return new BatchExecuteStatementInputTransformInput(sdkInput);
  }

  public static BatchExecuteStatementInputTransformOutput BatchExecuteStatementInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchExecuteStatementInputTransformOutput nativeValue
  ) {
    BatchExecuteStatementInput transformedInput;
    transformedInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.BatchExecuteStatementInput(
        nativeValue.transformedInput()
      );
    return new BatchExecuteStatementInputTransformOutput(transformedInput);
  }

  public static BatchExecuteStatementOutputTransformInput BatchExecuteStatementOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchExecuteStatementOutputTransformInput nativeValue
  ) {
    BatchExecuteStatementOutput sdkOutput;
    sdkOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.BatchExecuteStatementOutput(
        nativeValue.sdkOutput()
      );
    BatchExecuteStatementInput originalInput;
    originalInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.BatchExecuteStatementInput(
        nativeValue.originalInput()
      );
    return new BatchExecuteStatementOutputTransformInput(
      sdkOutput,
      originalInput
    );
  }

  public static BatchExecuteStatementOutputTransformOutput BatchExecuteStatementOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchExecuteStatementOutputTransformOutput nativeValue
  ) {
    BatchExecuteStatementOutput transformedOutput;
    transformedOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.BatchExecuteStatementOutput(
        nativeValue.transformedOutput()
      );
    return new BatchExecuteStatementOutputTransformOutput(transformedOutput);
  }

  public static BatchGetItemInputTransformInput BatchGetItemInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchGetItemInputTransformInput nativeValue
  ) {
    BatchGetItemInput sdkInput;
    sdkInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.BatchGetItemInput(
        nativeValue.sdkInput()
      );
    return new BatchGetItemInputTransformInput(sdkInput);
  }

  public static BatchGetItemInputTransformOutput BatchGetItemInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchGetItemInputTransformOutput nativeValue
  ) {
    BatchGetItemInput transformedInput;
    transformedInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.BatchGetItemInput(
        nativeValue.transformedInput()
      );
    return new BatchGetItemInputTransformOutput(transformedInput);
  }

  public static BatchGetItemOutputTransformInput BatchGetItemOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchGetItemOutputTransformInput nativeValue
  ) {
    BatchGetItemOutput sdkOutput;
    sdkOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.BatchGetItemOutput(
        nativeValue.sdkOutput()
      );
    BatchGetItemInput originalInput;
    originalInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.BatchGetItemInput(
        nativeValue.originalInput()
      );
    return new BatchGetItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static BatchGetItemOutputTransformOutput BatchGetItemOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchGetItemOutputTransformOutput nativeValue
  ) {
    BatchGetItemOutput transformedOutput;
    transformedOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.BatchGetItemOutput(
        nativeValue.transformedOutput()
      );
    return new BatchGetItemOutputTransformOutput(transformedOutput);
  }

  public static BatchWriteItemInputTransformInput BatchWriteItemInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchWriteItemInputTransformInput nativeValue
  ) {
    BatchWriteItemInput sdkInput;
    sdkInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.BatchWriteItemInput(
        nativeValue.sdkInput()
      );
    return new BatchWriteItemInputTransformInput(sdkInput);
  }

  public static BatchWriteItemInputTransformOutput BatchWriteItemInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchWriteItemInputTransformOutput nativeValue
  ) {
    BatchWriteItemInput transformedInput;
    transformedInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.BatchWriteItemInput(
        nativeValue.transformedInput()
      );
    return new BatchWriteItemInputTransformOutput(transformedInput);
  }

  public static BatchWriteItemOutputTransformInput BatchWriteItemOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchWriteItemOutputTransformInput nativeValue
  ) {
    BatchWriteItemOutput sdkOutput;
    sdkOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.BatchWriteItemOutput(
        nativeValue.sdkOutput()
      );
    BatchWriteItemInput originalInput;
    originalInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.BatchWriteItemInput(
        nativeValue.originalInput()
      );
    return new BatchWriteItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static BatchWriteItemOutputTransformOutput BatchWriteItemOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchWriteItemOutputTransformOutput nativeValue
  ) {
    BatchWriteItemOutput transformedOutput;
    transformedOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.BatchWriteItemOutput(
        nativeValue.transformedOutput()
      );
    return new BatchWriteItemOutputTransformOutput(transformedOutput);
  }

  public static DeleteItemInputTransformInput DeleteItemInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.DeleteItemInputTransformInput nativeValue
  ) {
    DeleteItemInput sdkInput;
    sdkInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.DeleteItemInput(
        nativeValue.sdkInput()
      );
    return new DeleteItemInputTransformInput(sdkInput);
  }

  public static DeleteItemInputTransformOutput DeleteItemInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.DeleteItemInputTransformOutput nativeValue
  ) {
    DeleteItemInput transformedInput;
    transformedInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.DeleteItemInput(
        nativeValue.transformedInput()
      );
    return new DeleteItemInputTransformOutput(transformedInput);
  }

  public static DeleteItemOutputTransformInput DeleteItemOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.DeleteItemOutputTransformInput nativeValue
  ) {
    DeleteItemOutput sdkOutput;
    sdkOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.DeleteItemOutput(
        nativeValue.sdkOutput()
      );
    DeleteItemInput originalInput;
    originalInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.DeleteItemInput(
        nativeValue.originalInput()
      );
    return new DeleteItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static DeleteItemOutputTransformOutput DeleteItemOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.DeleteItemOutputTransformOutput nativeValue
  ) {
    DeleteItemOutput transformedOutput;
    transformedOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.DeleteItemOutput(
        nativeValue.transformedOutput()
      );
    return new DeleteItemOutputTransformOutput(transformedOutput);
  }

  public static ExecuteStatementInputTransformInput ExecuteStatementInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteStatementInputTransformInput nativeValue
  ) {
    ExecuteStatementInput sdkInput;
    sdkInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.ExecuteStatementInput(
        nativeValue.sdkInput()
      );
    return new ExecuteStatementInputTransformInput(sdkInput);
  }

  public static ExecuteStatementInputTransformOutput ExecuteStatementInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteStatementInputTransformOutput nativeValue
  ) {
    ExecuteStatementInput transformedInput;
    transformedInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.ExecuteStatementInput(
        nativeValue.transformedInput()
      );
    return new ExecuteStatementInputTransformOutput(transformedInput);
  }

  public static ExecuteStatementOutputTransformInput ExecuteStatementOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteStatementOutputTransformInput nativeValue
  ) {
    ExecuteStatementOutput sdkOutput;
    sdkOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.ExecuteStatementOutput(
        nativeValue.sdkOutput()
      );
    ExecuteStatementInput originalInput;
    originalInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.ExecuteStatementInput(
        nativeValue.originalInput()
      );
    return new ExecuteStatementOutputTransformInput(sdkOutput, originalInput);
  }

  public static ExecuteStatementOutputTransformOutput ExecuteStatementOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteStatementOutputTransformOutput nativeValue
  ) {
    ExecuteStatementOutput transformedOutput;
    transformedOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.ExecuteStatementOutput(
        nativeValue.transformedOutput()
      );
    return new ExecuteStatementOutputTransformOutput(transformedOutput);
  }

  public static ExecuteTransactionInputTransformInput ExecuteTransactionInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteTransactionInputTransformInput nativeValue
  ) {
    ExecuteTransactionInput sdkInput;
    sdkInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.ExecuteTransactionInput(
        nativeValue.sdkInput()
      );
    return new ExecuteTransactionInputTransformInput(sdkInput);
  }

  public static ExecuteTransactionInputTransformOutput ExecuteTransactionInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteTransactionInputTransformOutput nativeValue
  ) {
    ExecuteTransactionInput transformedInput;
    transformedInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.ExecuteTransactionInput(
        nativeValue.transformedInput()
      );
    return new ExecuteTransactionInputTransformOutput(transformedInput);
  }

  public static ExecuteTransactionOutputTransformInput ExecuteTransactionOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteTransactionOutputTransformInput nativeValue
  ) {
    ExecuteTransactionOutput sdkOutput;
    sdkOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.ExecuteTransactionOutput(
        nativeValue.sdkOutput()
      );
    ExecuteTransactionInput originalInput;
    originalInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.ExecuteTransactionInput(
        nativeValue.originalInput()
      );
    return new ExecuteTransactionOutputTransformInput(sdkOutput, originalInput);
  }

  public static ExecuteTransactionOutputTransformOutput ExecuteTransactionOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteTransactionOutputTransformOutput nativeValue
  ) {
    ExecuteTransactionOutput transformedOutput;
    transformedOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.ExecuteTransactionOutput(
        nativeValue.transformedOutput()
      );
    return new ExecuteTransactionOutputTransformOutput(transformedOutput);
  }

  public static GetItemInputTransformInput GetItemInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.GetItemInputTransformInput nativeValue
  ) {
    GetItemInput sdkInput;
    sdkInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.GetItemInput(
        nativeValue.sdkInput()
      );
    return new GetItemInputTransformInput(sdkInput);
  }

  public static GetItemInputTransformOutput GetItemInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.GetItemInputTransformOutput nativeValue
  ) {
    GetItemInput transformedInput;
    transformedInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.GetItemInput(
        nativeValue.transformedInput()
      );
    return new GetItemInputTransformOutput(transformedInput);
  }

  public static GetItemOutputTransformInput GetItemOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.GetItemOutputTransformInput nativeValue
  ) {
    GetItemOutput sdkOutput;
    sdkOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.GetItemOutput(
        nativeValue.sdkOutput()
      );
    GetItemInput originalInput;
    originalInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.GetItemInput(
        nativeValue.originalInput()
      );
    return new GetItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static GetItemOutputTransformOutput GetItemOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.GetItemOutputTransformOutput nativeValue
  ) {
    GetItemOutput transformedOutput;
    transformedOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.GetItemOutput(
        nativeValue.transformedOutput()
      );
    return new GetItemOutputTransformOutput(transformedOutput);
  }

  public static GetNumberOfQueriesInput GetNumberOfQueriesInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.GetNumberOfQueriesInput nativeValue
  ) {
    QueryInput input;
    input =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.QueryInput(
        nativeValue.input()
      );
    return new GetNumberOfQueriesInput(input);
  }

  public static GetNumberOfQueriesOutput GetNumberOfQueriesOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.GetNumberOfQueriesOutput nativeValue
  ) {
    Integer numberOfQueries;
    numberOfQueries = (nativeValue.numberOfQueries());
    return new GetNumberOfQueriesOutput(numberOfQueries);
  }

  public static PutItemInputTransformInput PutItemInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.PutItemInputTransformInput nativeValue
  ) {
    PutItemInput sdkInput;
    sdkInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.PutItemInput(
        nativeValue.sdkInput()
      );
    return new PutItemInputTransformInput(sdkInput);
  }

  public static PutItemInputTransformOutput PutItemInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.PutItemInputTransformOutput nativeValue
  ) {
    PutItemInput transformedInput;
    transformedInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.PutItemInput(
        nativeValue.transformedInput()
      );
    return new PutItemInputTransformOutput(transformedInput);
  }

  public static PutItemOutputTransformInput PutItemOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.PutItemOutputTransformInput nativeValue
  ) {
    PutItemOutput sdkOutput;
    sdkOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.PutItemOutput(
        nativeValue.sdkOutput()
      );
    PutItemInput originalInput;
    originalInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.PutItemInput(
        nativeValue.originalInput()
      );
    return new PutItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static PutItemOutputTransformOutput PutItemOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.PutItemOutputTransformOutput nativeValue
  ) {
    PutItemOutput transformedOutput;
    transformedOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.PutItemOutput(
        nativeValue.transformedOutput()
      );
    return new PutItemOutputTransformOutput(transformedOutput);
  }

  public static QueryInputTransformInput QueryInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.QueryInputTransformInput nativeValue
  ) {
    QueryInput sdkInput;
    sdkInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.QueryInput(
        nativeValue.sdkInput()
      );
    return new QueryInputTransformInput(sdkInput);
  }

  public static QueryInputTransformOutput QueryInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.QueryInputTransformOutput nativeValue
  ) {
    QueryInput transformedInput;
    transformedInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.QueryInput(
        nativeValue.transformedInput()
      );
    return new QueryInputTransformOutput(transformedInput);
  }

  public static QueryOutputTransformInput QueryOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.QueryOutputTransformInput nativeValue
  ) {
    QueryOutput sdkOutput;
    sdkOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.QueryOutput(
        nativeValue.sdkOutput()
      );
    QueryInput originalInput;
    originalInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.QueryInput(
        nativeValue.originalInput()
      );
    return new QueryOutputTransformInput(sdkOutput, originalInput);
  }

  public static QueryOutputTransformOutput QueryOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.QueryOutputTransformOutput nativeValue
  ) {
    QueryOutput transformedOutput;
    transformedOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.QueryOutput(
        nativeValue.transformedOutput()
      );
    return new QueryOutputTransformOutput(transformedOutput);
  }

  public static ResolveAttributesInput ResolveAttributesInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ResolveAttributesInput nativeValue
  ) {
    DafnySequence<? extends Character> tableName;
    tableName =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.TableName()
      );
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends AttributeValue
    > item;
    item =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.AttributeMap(
        nativeValue.Item()
      );
    Option<Integer> version;
    version =
      Objects.nonNull(nativeValue.Version())
        ? Option.create_Some(TypeDescriptor.INT, (nativeValue.Version()))
        : Option.create_None(TypeDescriptor.INT);
    return new ResolveAttributesInput(tableName, item, version);
  }

  public static ResolveAttributesOutput ResolveAttributesOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ResolveAttributesOutput nativeValue
  ) {
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends DafnySequence<? extends Character>
    > virtualFields;
    virtualFields = ToDafny.StringMap(nativeValue.VirtualFields());
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends DafnySequence<? extends Character>
    > compoundBeacons;
    compoundBeacons = ToDafny.StringMap(nativeValue.CompoundBeacons());
    return new ResolveAttributesOutput(virtualFields, compoundBeacons);
  }

  public static ScanInputTransformInput ScanInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ScanInputTransformInput nativeValue
  ) {
    ScanInput sdkInput;
    sdkInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.ScanInput(
        nativeValue.sdkInput()
      );
    return new ScanInputTransformInput(sdkInput);
  }

  public static ScanInputTransformOutput ScanInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ScanInputTransformOutput nativeValue
  ) {
    ScanInput transformedInput;
    transformedInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.ScanInput(
        nativeValue.transformedInput()
      );
    return new ScanInputTransformOutput(transformedInput);
  }

  public static ScanOutputTransformInput ScanOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ScanOutputTransformInput nativeValue
  ) {
    ScanOutput sdkOutput;
    sdkOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.ScanOutput(
        nativeValue.sdkOutput()
      );
    ScanInput originalInput;
    originalInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.ScanInput(
        nativeValue.originalInput()
      );
    return new ScanOutputTransformInput(sdkOutput, originalInput);
  }

  public static ScanOutputTransformOutput ScanOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ScanOutputTransformOutput nativeValue
  ) {
    ScanOutput transformedOutput;
    transformedOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.ScanOutput(
        nativeValue.transformedOutput()
      );
    return new ScanOutputTransformOutput(transformedOutput);
  }

  public static TransactGetItemsInputTransformInput TransactGetItemsInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactGetItemsInputTransformInput nativeValue
  ) {
    TransactGetItemsInput sdkInput;
    sdkInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.TransactGetItemsInput(
        nativeValue.sdkInput()
      );
    return new TransactGetItemsInputTransformInput(sdkInput);
  }

  public static TransactGetItemsInputTransformOutput TransactGetItemsInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactGetItemsInputTransformOutput nativeValue
  ) {
    TransactGetItemsInput transformedInput;
    transformedInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.TransactGetItemsInput(
        nativeValue.transformedInput()
      );
    return new TransactGetItemsInputTransformOutput(transformedInput);
  }

  public static TransactGetItemsOutputTransformInput TransactGetItemsOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactGetItemsOutputTransformInput nativeValue
  ) {
    TransactGetItemsOutput sdkOutput;
    sdkOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.TransactGetItemsOutput(
        nativeValue.sdkOutput()
      );
    TransactGetItemsInput originalInput;
    originalInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.TransactGetItemsInput(
        nativeValue.originalInput()
      );
    return new TransactGetItemsOutputTransformInput(sdkOutput, originalInput);
  }

  public static TransactGetItemsOutputTransformOutput TransactGetItemsOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactGetItemsOutputTransformOutput nativeValue
  ) {
    TransactGetItemsOutput transformedOutput;
    transformedOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.TransactGetItemsOutput(
        nativeValue.transformedOutput()
      );
    return new TransactGetItemsOutputTransformOutput(transformedOutput);
  }

  public static TransactWriteItemsInputTransformInput TransactWriteItemsInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactWriteItemsInputTransformInput nativeValue
  ) {
    TransactWriteItemsInput sdkInput;
    sdkInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.TransactWriteItemsInput(
        nativeValue.sdkInput()
      );
    return new TransactWriteItemsInputTransformInput(sdkInput);
  }

  public static TransactWriteItemsInputTransformOutput TransactWriteItemsInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactWriteItemsInputTransformOutput nativeValue
  ) {
    TransactWriteItemsInput transformedInput;
    transformedInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.TransactWriteItemsInput(
        nativeValue.transformedInput()
      );
    return new TransactWriteItemsInputTransformOutput(transformedInput);
  }

  public static TransactWriteItemsOutputTransformInput TransactWriteItemsOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactWriteItemsOutputTransformInput nativeValue
  ) {
    TransactWriteItemsOutput sdkOutput;
    sdkOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.TransactWriteItemsOutput(
        nativeValue.sdkOutput()
      );
    TransactWriteItemsInput originalInput;
    originalInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.TransactWriteItemsInput(
        nativeValue.originalInput()
      );
    return new TransactWriteItemsOutputTransformInput(sdkOutput, originalInput);
  }

  public static TransactWriteItemsOutputTransformOutput TransactWriteItemsOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactWriteItemsOutputTransformOutput nativeValue
  ) {
    TransactWriteItemsOutput transformedOutput;
    transformedOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.TransactWriteItemsOutput(
        nativeValue.transformedOutput()
      );
    return new TransactWriteItemsOutputTransformOutput(transformedOutput);
  }

  public static UpdateItemInputTransformInput UpdateItemInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.UpdateItemInputTransformInput nativeValue
  ) {
    UpdateItemInput sdkInput;
    sdkInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.UpdateItemInput(
        nativeValue.sdkInput()
      );
    return new UpdateItemInputTransformInput(sdkInput);
  }

  public static UpdateItemInputTransformOutput UpdateItemInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.UpdateItemInputTransformOutput nativeValue
  ) {
    UpdateItemInput transformedInput;
    transformedInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.UpdateItemInput(
        nativeValue.transformedInput()
      );
    return new UpdateItemInputTransformOutput(transformedInput);
  }

  public static UpdateItemOutputTransformInput UpdateItemOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.UpdateItemOutputTransformInput nativeValue
  ) {
    UpdateItemOutput sdkOutput;
    sdkOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.UpdateItemOutput(
        nativeValue.sdkOutput()
      );
    UpdateItemInput originalInput;
    originalInput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.UpdateItemInput(
        nativeValue.originalInput()
      );
    return new UpdateItemOutputTransformInput(sdkOutput, originalInput);
  }

  public static UpdateItemOutputTransformOutput UpdateItemOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.UpdateItemOutputTransformOutput nativeValue
  ) {
    UpdateItemOutput transformedOutput;
    transformedOutput =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.UpdateItemOutput(
        nativeValue.transformedOutput()
      );
    return new UpdateItemOutputTransformOutput(transformedOutput);
  }

  public static Error Error(DynamoDbEncryptionTransformsException nativeValue) {
    DafnySequence<? extends Character> message;
    message =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.message()
      );
    return new Error_DynamoDbEncryptionTransformsException(message);
  }

  public static DafnyMap<
    ? extends DafnySequence<? extends Character>,
    ? extends DafnySequence<? extends Character>
  > StringMap(Map<String, String> nativeValue) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToMap(
      nativeValue,
      software.amazon.smithy.dafny.conversion.ToDafny.Simple::CharacterSequence,
      software.amazon.smithy.dafny.conversion.ToDafny.Simple::CharacterSequence
    );
  }

  public static IDynamoDbEncryptionTransformsClient DynamoDbEncryptionTransforms(
    DynamoDbEncryptionTransforms nativeValue
  ) {
    return nativeValue.impl();
  }
}
