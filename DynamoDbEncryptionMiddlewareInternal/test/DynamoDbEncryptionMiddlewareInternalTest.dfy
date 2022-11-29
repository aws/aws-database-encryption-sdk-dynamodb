// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier := Apache-2.0
include "../../private-aws-encryption-sdk-dafny-staging/StandardLibrary/src/StandardLibrary.dfy"
include "../src/Index.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/ComAmazonawsDynamodb/Model/ComAmazonawsDynamodbTypes.dfy"
include "TestFixtures.dfy"
include "../Model/AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.dfy"

// TODO We will want to break this into multiple files
module DynamoDbEncryptionMiddlewareInternalTest {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened DynamoDbEncryptionMiddlewareInternal
  import DDB = ComAmazonawsDynamodbTypes
  import TestFixtures
  import AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes

  method {:test} TestGetItemInputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.GetItemInput(
      TableName := "foo",
      Key := map[],
      AttributesToGet := None(),
      ConsistentRead := None(),
      ReturnConsumedCapacity := None(),
      ProjectionExpression := None(),
      ExpressionAttributeNames := None()
    );
    var transformed := middlewareUnderTest.GetItemInputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.GetItemInputTransformInput(
        sdkInput := input
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Unimplemented";
  }

  method {:test} TestGetItemOutputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.GetItemOutput(
      Item := None(),
      ConsumedCapacity := None()
    );
    var transformed := middlewareUnderTest.GetItemOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.GetItemOutputTransformInput(
        sdkOutput := output
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Unimplemented";
  }

  method {:test} TestPutItemInputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.PutItemInput(
      TableName := "foo",
      Item := map[],
      Expected := None(),
      ReturnValues := None(),
      ReturnConsumedCapacity := None(),
      ReturnItemCollectionMetrics := None(),
      ConditionalOperator := None(),
      ConditionExpression := None(),
      ExpressionAttributeNames := None(),
      ExpressionAttributeValues := None()
    );
    var transformed := middlewareUnderTest.PutItemInputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.PutItemInputTransformInput(
        sdkInput := input
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Unimplemented";
  }

  method {:test} TestPutItemOutputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.PutItemOutput(
      Attributes := None(),
      ConsumedCapacity := None(),
      ItemCollectionMetrics := None()
    );
    var transformed := middlewareUnderTest.PutItemOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.PutItemOutputTransformInput(
        sdkOutput := output
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Unimplemented";
  }

  method {:test} TestBatchWriteItemInputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.BatchWriteItemInput(
      RequestItems := map[
        "foo" := [
          DDB.WriteRequest (
            PutRequest := None(),
            DeleteRequest := None()
          )
        ]
      ],
      ReturnConsumedCapacity := None(),
      ReturnItemCollectionMetrics := None()
    );
    var transformed := middlewareUnderTest.BatchWriteItemInputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.BatchWriteItemInputTransformInput(
        sdkInput := input
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Unimplemented";
  }

  method {:test} TestBatchWriteItemOutputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.BatchWriteItemOutput(
      UnprocessedItems := None(),
      ItemCollectionMetrics := None(),
      ConsumedCapacity := None()
    );
    var transformed := middlewareUnderTest.BatchWriteItemOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.BatchWriteItemOutputTransformInput(
        sdkOutput := output
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Unimplemented";
  }

  method {:test} TestBatchGetItemInputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.BatchGetItemInput(
      RequestItems := map[
        "foo" := DDB.KeysAndAttributes(
          KeyList := [
            map[]
          ],
          AttributesToGet := None(),
          ConsistentRead := None(),
          ProjectionExpression := None(),
          ExpressionAttributeNames := None()
        )
      ],
      ReturnConsumedCapacity := None()
    );
    var transformed := middlewareUnderTest.BatchGetItemInputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.BatchGetItemInputTransformInput(
        sdkInput := input
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Unimplemented";
  }

  method {:test} TestBatchGetItemOutputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.BatchGetItemOutput(
      Responses := None(),
      UnprocessedKeys := None(),
      ConsumedCapacity := None()
    );
    var transformed := middlewareUnderTest.BatchGetItemOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.BatchGetItemOutputTransformInput(
        sdkOutput := output
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Unimplemented";
  }

  method {:test} TestScanInputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.ScanInput(
      TableName := "foo",
      IndexName := None(),
      AttributesToGet := None(),
      Limit := None(),
      Select := None(),
      ScanFilter := None(),
      ConditionalOperator := None(),
      ExclusiveStartKey := None(),
      ReturnConsumedCapacity := None(),
      TotalSegments := None(),
      Segment := None(),
      ProjectionExpression := None(),
      FilterExpression := None(),
      ExpressionAttributeNames := None(),
      ExpressionAttributeValues := None(),
      ConsistentRead := None()
    );
    var transformed := middlewareUnderTest.ScanInputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.ScanInputTransformInput(
        sdkInput := input
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Unimplemented";
  }

  method {:test} TestScanOutputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.ScanOutput(
      ItemList := None(),
      Count := None(),
      ScannedCount := None(),
      LastEvaluatedKey := None(),
      ConsumedCapacity := None()
    );
    var transformed := middlewareUnderTest.ScanOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.ScanOutputTransformInput(
        sdkOutput := output
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Unimplemented";
  }

  method {:test} TestQueryInputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.QueryInput(
      TableName := "foo",
      IndexName := None(),
      Select := None(),
      AttributesToGet := None(),
      Limit := None(),
      ConsistentRead := None(),
      KeyConditions := None(),
      QueryFilter := None(),
      ConditionalOperator := None(),
      ScanIndexForward := None(),
      ExclusiveStartKey := None(),
      ReturnConsumedCapacity := None(),
      ProjectionExpression := None(),
      FilterExpression := None(),
      KeyConditionExpression := None(),
      ExpressionAttributeNames := None(),
      ExpressionAttributeValues := None()
    );
    var transformed := middlewareUnderTest.QueryInputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.QueryInputTransformInput(
        sdkInput := input
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Unimplemented";
  }

  method {:test} TestQueryOutputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.QueryOutput(
      ItemList := None(),
      Count := None(),
      ScannedCount := None(),
      LastEvaluatedKey := None(),
      ConsumedCapacity := None()
    );
    var transformed := middlewareUnderTest.QueryOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.QueryOutputTransformInput(
        sdkOutput := output
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Unimplemented";
  }

  method {:test} TestTransactWriteItemsInputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.TransactWriteItemsInput(
      TransactItems := [
        DDB.TransactWriteItem(
          ConditionCheck := None(),
          Put := None(),
          Delete := None(),
          Update := None()
        )
      ],
      ReturnConsumedCapacity := None(),
      ReturnItemCollectionMetrics := None(),
      ClientRequestToken := None()
    );
    var transformed := middlewareUnderTest.TransactWriteItemsInputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.TransactWriteItemsInputTransformInput(
        sdkInput := input
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Unimplemented";
  }

  method {:test} TestTransactWriteItemsOutputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.TransactWriteItemsOutput(
      ConsumedCapacity := None(),
      ItemCollectionMetrics := None()
    );
    var transformed := middlewareUnderTest.TransactWriteItemsOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.TransactWriteItemsOutputTransformInput(
        sdkOutput := output
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Unimplemented";
  }

  method {:test} TestUpdateItemInputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.UpdateItemInput(
      TableName := "foo",
      Key := map[],
      AttributeUpdates := None(),
      Expected := None(),
      ConditionalOperator := None(),
      ReturnValues := None(),
      ReturnConsumedCapacity := None(),
      ReturnItemCollectionMetrics := None(),
      UpdateExpression := None(),
      ConditionExpression := None(),
      ExpressionAttributeNames := None(),
      ExpressionAttributeValues := None()
    );
    var transformed := middlewareUnderTest.UpdateItemInputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.UpdateItemInputTransformInput(
        sdkInput := input
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Unimplemented";
  }

  method {:test} TestUpdateItemOutputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.UpdateItemOutput(
      Attributes := None(),
      ConsumedCapacity := None(),
      ItemCollectionMetrics := None()
    );
    var transformed := middlewareUnderTest.UpdateItemOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.UpdateItemOutputTransformInput(
        sdkOutput := output
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Unimplemented";
  }

  method {:test} TestDeleteItemInputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.DeleteItemInput(
      TableName := "foo",
      Key := map[],
      Expected := None(),
      ConditionalOperator := None(),
      ReturnValues := None(),
      ReturnConsumedCapacity := None(),
      ReturnItemCollectionMetrics := None(),
      ConditionExpression := None(),
      ExpressionAttributeNames := None(),
      ExpressionAttributeValues := None()
    );
    var transformed := middlewareUnderTest.DeleteItemInputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.DeleteItemInputTransformInput(
        sdkInput := input
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Unimplemented";
  }

  method {:test} TestDeleteItemOutputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.DeleteItemOutput(
      Attributes := None(),
      ConsumedCapacity := None(),
      ItemCollectionMetrics := None()
    );
    var transformed := middlewareUnderTest.DeleteItemOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.DeleteItemOutputTransformInput(
        sdkOutput := output
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Unimplemented";
  }

  method {:test} TestTransactGetItemsInputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.TransactGetItemsInput(
      TransactItems := [
        DDB.TransactGetItem(
          Get := DDB.Get(
            Key := map[],
            TableName := "foo",
            ProjectionExpression := None(),
            ExpressionAttributeNames := None()
          )
        )
      ],
      ReturnConsumedCapacity := None()
    );
    var transformed := middlewareUnderTest.TransactGetItemsInputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.TransactGetItemsInputTransformInput(
        sdkInput := input
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Unimplemented";
  }

  method {:test} TestTransactGetItemsOutputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.TransactGetItemsOutput(
      ConsumedCapacity := None(),
      Responses := None()
    );
    var transformed := middlewareUnderTest.TransactGetItemsOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.TransactGetItemsOutputTransformInput(
        sdkOutput := output
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Unimplemented";
  }

    method {:test} TestExecuteStatementInputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.ExecuteStatementInput(
      Statement := "foo",
      Parameters := None(),
      ConsistentRead := None(),
      NextToken := None(),
      ReturnConsumedCapacity := None(),
      Limit := None()
    );
    var transformed := middlewareUnderTest.ExecuteStatementInputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.ExecuteStatementInputTransformInput(
        sdkInput := input
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Not Supported";
  }

  method {:test} TestExecuteStatementOutputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.ExecuteStatementOutput(
      ItemList := None(),
      NextToken := None(),
      ConsumedCapacity := None(),
      LastEvaluatedKey := None()
    );
    var transformed := middlewareUnderTest.ExecuteStatementOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.ExecuteStatementOutputTransformInput(
        sdkOutput := output
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Not Supported";
  }

    method {:test} TestBatchExecuteStatementInputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.BatchExecuteStatementInput(
      Statements := [
        DDB.BatchStatementRequest(
          Statement := "foo",
          Parameters := None(),
          ConsistentRead := None()
        )
      ],
      ReturnConsumedCapacity := None()
    );
    var transformed := middlewareUnderTest.BatchExecuteStatementInputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.BatchExecuteStatementInputTransformInput(
        sdkInput := input
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Not Supported";
  }

  method {:test} TestBatchExecuteStatementOutputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.BatchExecuteStatementOutput(
      Responses := None(),
      ConsumedCapacity := None()
    );
    var transformed := middlewareUnderTest.BatchExecuteStatementOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.BatchExecuteStatementOutputTransformInput(
        sdkOutput := output
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Not Supported";
  }

    method {:test} TestExecuteTransactionInputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.ExecuteTransactionInput(
      TransactStatements :=  [
        DDB.ParameterizedStatement (
          Statement := "foo",
          Parameters := None()
        )
      ],
      ClientRequestToken := None(),
      ReturnConsumedCapacity := None()
    );
    var transformed := middlewareUnderTest.ExecuteTransactionInputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.ExecuteTransactionInputTransformInput(
        sdkInput := input
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Not Supported";
  }

  method {:test} TestExecuteTransactionOutputTransform() {
    // Currently it does not matter what our input is
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.ExecuteTransactionOutput(
      Responses := None(),
      ConsumedCapacity := None()
    );
    var transformed := middlewareUnderTest.ExecuteTransactionOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.ExecuteTransactionOutputTransformInput(
        sdkOutput := output
      )
    );

    expect transformed.Failure?;
    expect transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect transformed.error.message == "Not Supported";
  }
}
