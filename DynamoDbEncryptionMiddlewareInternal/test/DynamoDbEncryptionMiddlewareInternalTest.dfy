// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
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

  method expect_ok<X>(tag : string, actual : Result<X, AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.Error>)
    ensures actual.Success?
  {
    if actual.Failure? {
      print tag, "\t", actual;
    }
    expect actual.Success?;
  }
  method expect_equal<X(==)>(tag : string, actual : X, expected : X)
  {
    if actual != expected {
      print tag, "\texpected\n", expected, "\ngot\n", actual, "\n";
    }
    expect actual == expected;
  }

  method ExpectFailure<X>(ret : Result<X, AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.Error>, s : string)
  {
    if !ret.Failure? {
      print "Got Success when expected failure ", s, "\n";
    }
    expect ret.Failure?;
    if !ret.error.DynamoDbEncryptionMiddlewareInternalException? {
      print "Error type not DynamoDbEncryptionMiddlewareInternalException : ", ret, "\n";
    }
    expect ret.error.DynamoDbEncryptionMiddlewareInternalException?;
    if ret.error.message != s {
      print "Expected error message '", s, "' got message '", ret.error.message, "'\n";
    }
    expect ret.error.message == s;
  }

  method {:test} TestGetItemInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.GetItemInput(
      TableName := "no_such_table",
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
    expect_ok("GetItemInput", transformed);
    expect_equal("GetItemInput", transformed.value.transformedInput, input);
  }

  method {:test} TestGetItemOutputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.GetItemInput(
      TableName := "no_such_table",
      Key := map[],
      AttributesToGet := None(),
      ConsistentRead := None(),
      ReturnConsumedCapacity := None(),
      ProjectionExpression := None(),
      ExpressionAttributeNames := None()
    );
    var output := DDB.GetItemOutput(
      Item := None(),
      ConsumedCapacity := None()
    );
    var transformed := middlewareUnderTest.GetItemOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.GetItemOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("GetItemOutput", transformed);
    expect_equal("GetItemOutput", transformed.value.transformedOutput, output);
  }

  method {:test} TestPutItemInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.PutItemInput(
      TableName := "no_such_table",
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

    expect_ok("PutItemInput", transformed);
    expect_equal("PutItemInput", transformed.value.transformedInput, input);
  }

  method {:test} TestPutItemOutputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.PutItemOutput(
      Attributes := None(),
      ConsumedCapacity := None(),
      ItemCollectionMetrics := None()
    );
    var input := DDB.PutItemInput(
      TableName := "no_such_table",
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
    var transformed := middlewareUnderTest.PutItemOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.PutItemOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("PutItemOutput", transformed);
    expect_equal("PutItemOutput", transformed.value.transformedOutput, output);
  }

  method {:test} TestBatchWriteItemInputTransform() {
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

    expect_ok("BatchWriteItemInput", transformed);
    expect_equal("BatchWriteItemInput", transformed.value.transformedInput, input);
  }

  method {:test} TestBatchWriteItemOutputTransform() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.BatchWriteItemOutput(
      UnprocessedItems := None(),
      ItemCollectionMetrics := None(),
      ConsumedCapacity := None()
    );
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
    var transformed := middlewareUnderTest.BatchWriteItemOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.BatchWriteItemOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("BatchWriteItemOutput", transformed);
    expect_equal("BatchWriteItemOutput", transformed.value.transformedOutput, output);
  }

  method {:test} TestBatchGetItemInputTransform() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.BatchGetItemInput(
      RequestItems := map[
        "foo" := DDB.KeysAndAttributes(
          Keys := [
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

    expect_ok("BatchGetItemInput", transformed);
    expect_equal("BatchGetItemInput", transformed.value.transformedInput, input);
  }

  method {:test} TestBatchGetItemOutputTransform() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.BatchGetItemOutput(
      Responses := None(),
      UnprocessedKeys := None(),
      ConsumedCapacity := None()
    );
    var input := DDB.BatchGetItemInput(
      RequestItems := map[
        "foo" := DDB.KeysAndAttributes(
          Keys := [
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
    var transformed := middlewareUnderTest.BatchGetItemOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.BatchGetItemOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("BatchGetItemOutput", transformed);
    expect_equal("BatchGetItemOutput", transformed.value.transformedOutput, output);
  }

  method {:test} TestScanInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.ScanInput(
      TableName := "no_such_table",
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

    expect_ok("ScanInput", transformed);
    expect_equal("ScanInput", transformed.value.transformedInput, input);
  }

  method {:test} TestScanOutputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.ScanOutput(
      Items := None(),
      Count := None(),
      ScannedCount := None(),
      LastEvaluatedKey := None(),
      ConsumedCapacity := None()
    );
    var input := DDB.ScanInput(
      TableName := "no_such_table",
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
    var transformed := middlewareUnderTest.ScanOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.ScanOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("ScanOutput", transformed);
    expect_equal("ScanOutput", transformed.value.transformedOutput, output);
  }

  method {:test} TestQueryInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.QueryInput(
      TableName := "no_such_table",
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

    expect_ok("QueryInput", transformed);
    expect_equal("QueryInput", transformed.value.transformedInput, input);
  }

  method {:test} TestQueryOutputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.QueryOutput(
      Items := None(),
      Count := None(),
      ScannedCount := None(),
      LastEvaluatedKey := None(),
      ConsumedCapacity := None()
    );
    var input := DDB.QueryInput(
      TableName := "no_such_table",
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
    var transformed := middlewareUnderTest.QueryOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.QueryOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("QueryOutput", transformed);
    expect_equal("QueryOutput", transformed.value.transformedOutput, output);
  }

  method {:test} TestTransactWriteItemsInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.TransactWriteItemsInput(
      TransactItems := [
        DDB.TransactWriteItem(
          ConditionCheck := None(),
          Put := None(),
          Delete := Some(DDB.Delete(
            Key := map["this" := DDB.AttributeValue.S("that")],
            TableName := "bar",
            ConditionExpression := None,
            ExpressionAttributeNames := None,
            ExpressionAttributeValues := None,
            ReturnValuesOnConditionCheckFailure := None)),
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

    expect_ok("TransactWriteItemsInput", transformed);
    expect_equal("TransactWriteItemsInput", transformed.value.transformedInput, input);
  }

    method {:test} TestTransactWriteItemsInputEmpty() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.TransactWriteItemsInput(
      TransactItems := [
        DDB.TransactWriteItem(
          ConditionCheck := None,
          Put := None,
          Delete := None,
          Update := None
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
    ExpectFailure(transformed, "Each item in TransactWriteItems must specify at least one operation");
  }

  method {:test} TestTransactWriteItemsOutputTransform() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.TransactWriteItemsOutput(
      ConsumedCapacity := None(),
      ItemCollectionMetrics := None()
    );
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
    var transformed := middlewareUnderTest.TransactWriteItemsOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.TransactWriteItemsOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("TransactWriteItemsOutput", transformed);
    expect_equal("TransactWriteItemsOutput", transformed.value.transformedOutput, output);
  }

  method {:test} TestUpdateItemInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.UpdateItemInput(
      TableName := "no_such_table",
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

    expect_ok("UpdateItemInput", transformed);
    expect_equal("UpdateItemInput", transformed.value.transformedInput, input);
  }

  method {:test} TestUpdateItemOutputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.UpdateItemOutput(
      Attributes := None(),
      ConsumedCapacity := None(),
      ItemCollectionMetrics := None()
    );
    var input := DDB.UpdateItemInput(
      TableName := "no_such_table",
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
    var transformed := middlewareUnderTest.UpdateItemOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.UpdateItemOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("UpdateItemOutput", transformed);
    expect_equal("UpdateItemOutput", transformed.value.transformedOutput, output);
  }

  method {:test} TestDeleteItemInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.DeleteItemInput(
      TableName := "no_such_table",
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

    expect_ok("DeleteItemInput", transformed);
    expect_equal("DeleteItemInput", transformed.value.transformedInput, input);
  }

  method {:test} TestDeleteItemOutputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.DeleteItemOutput(
      Attributes := None(),
      ConsumedCapacity := None(),
      ItemCollectionMetrics := None()
    );
    var input := DDB.DeleteItemInput(
      TableName := "no_such_table",
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
    var transformed := middlewareUnderTest.DeleteItemOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.DeleteItemOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("DeleteItemOutput", transformed);
    expect_equal("DeleteItemOutput", transformed.value.transformedOutput, output);
  }

  method {:test} TestTransactGetItemsInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var input := DDB.TransactGetItemsInput(
      TransactItems := [
        DDB.TransactGetItem(
          Get := DDB.Get(
            Key := map[],
            TableName := "no_such_table",
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

    expect_ok("TransactGetItemsInput", transformed);
    expect_equal("TransactGetItemsInput", transformed.value.transformedInput, input);
  }

  method {:test} TestTransactGetItemsOutputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.TransactGetItemsOutput(
      ConsumedCapacity := None(),
      Responses := None()
    );
    var input := DDB.TransactGetItemsInput(
      TransactItems := [
        DDB.TransactGetItem(
          Get := DDB.Get(
            Key := map[],
            TableName := "no_such_table",
            ProjectionExpression := None(),
            ExpressionAttributeNames := None()
          )
        )
      ],
      ReturnConsumedCapacity := None()
    );
    var transformed := middlewareUnderTest.TransactGetItemsOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.TransactGetItemsOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("TransactGetItemsOutput", transformed);
    expect_equal("TransactGetItemsOutput", transformed.value.transformedOutput, output);
  }

  method {:test} TestExecuteStatementInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var good_input := DDB.ExecuteStatementInput(
      Statement := "update \"no_such_table\"",
      Parameters := None(),
      ConsistentRead := None(),
      NextToken := None(),
      ReturnConsumedCapacity := None(),
      Limit := None()
    );
    var good_transformed := middlewareUnderTest.ExecuteStatementInputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.ExecuteStatementInputTransformInput(
        sdkInput := good_input
      )
    );

    expect_ok("ExecuteStatement", good_transformed);
    expect_equal("ExecuteStatement", good_transformed.value.transformedInput, good_input);
  }

  method {:test} TestExecuteStatementInputEncrypted() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var bad_input := DDB.ExecuteStatementInput(
      Statement := "update \"foo\"",
      Parameters := None(),
      ConsistentRead := None(),
      NextToken := None(),
      ReturnConsumedCapacity := None(),
      Limit := None()
    );
    var bad_transformed := middlewareUnderTest.ExecuteStatementInputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.ExecuteStatementInputTransformInput(
        sdkInput := bad_input
      )
    );

    expect bad_transformed.Failure?;
    expect bad_transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect bad_transformed.error.message == "ExecuteStatement not Supported on encrypted tables.";
  }

  method {:test} TestExecuteStatementOutput() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.ExecuteStatementOutput(
      Items := None(),
      NextToken := None(),
      ConsumedCapacity := None(),
      LastEvaluatedKey := None()
    );
    var input := DDB.ExecuteStatementInput(
      Statement := "foo",
      Parameters := None(),
      ConsistentRead := None(),
      NextToken := None(),
      ReturnConsumedCapacity := None(),
      Limit := None()
    );
    var transformed := middlewareUnderTest.ExecuteStatementOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.ExecuteStatementOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("ExecuteStatement", transformed);
    expect_equal("ExecuteStatement", transformed.value.transformedOutput, output);
  }

  method {:test} TestBatchExecuteStatementInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var good_input := DDB.BatchExecuteStatementInput(
      Statements := [
        DDB.BatchStatementRequest(
          Statement := "update \"no_such_table\"",
          Parameters := None(),
          ConsistentRead := None()
        )
      ],
      ReturnConsumedCapacity := None()
    );
    var good_transformed := middlewareUnderTest.BatchExecuteStatementInputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.BatchExecuteStatementInputTransformInput(
        sdkInput := good_input
      )
    );

    expect_ok("BatchExecuteStatement", good_transformed);
    expect_equal("BatchExecuteStatement", good_transformed.value.transformedInput, good_input);
  }

  method {:test} TestBatchExecuteStatementInputEncrypted() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var bad_input := DDB.BatchExecuteStatementInput(
      Statements := [
        DDB.BatchStatementRequest(
          Statement := "update \"foo\"",
          Parameters := None(),
          ConsistentRead := None()
        )
      ],
      ReturnConsumedCapacity := None()
    );
    var bad_transformed := middlewareUnderTest.BatchExecuteStatementInputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.BatchExecuteStatementInputTransformInput(
        sdkInput := bad_input
      )
    );

    expect bad_transformed.Failure?;
    expect bad_transformed.error.DynamoDbEncryptionMiddlewareInternalException?;
    expect bad_transformed.error.message == "BatchExecuteStatement not Supported on encrypted tables.";
  }

  method {:test} TestBatchExecuteStatementOutputTransform() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.BatchExecuteStatementOutput(
      Responses := None(),
      ConsumedCapacity := None()
    );
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
    var transformed := middlewareUnderTest.BatchExecuteStatementOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.BatchExecuteStatementOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("BatchExecuteStatement", transformed);
    expect_equal("BatchExecuteStatement", transformed.value.transformedOutput, output);
  }

  method {:test} TestExecuteTransactionInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var good_input := DDB.ExecuteTransactionInput(
      TransactStatements :=  [
        DDB.ParameterizedStatement (
          Statement := "update \"no_such_table\"",
          Parameters := None()
        )
      ],
      ClientRequestToken := None(),
      ReturnConsumedCapacity := None()
    );
    var good_transformed := middlewareUnderTest.ExecuteTransactionInputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.ExecuteTransactionInputTransformInput(
        sdkInput := good_input
      )
    );

    expect_ok("ExecuteTransaction", good_transformed);
    expect_equal("ExecuteTransaction", good_transformed.value.transformedInput, good_input);
  }

  method {:test} TestExecuteTransactionInput() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var bad_input := DDB.ExecuteTransactionInput(
      TransactStatements :=  [
        DDB.ParameterizedStatement (
          Statement := "update foo",
          Parameters := None()
        )
      ],
      ClientRequestToken := None(),
      ReturnConsumedCapacity := None()
    );
    var bad_transformed := middlewareUnderTest.ExecuteTransactionInputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.ExecuteTransactionInputTransformInput(
        sdkInput := bad_input
      )
    );

    ExpectFailure(bad_transformed, "ExecuteTransaction not Supported on encrypted tables.");
  }

  method {:test} TestExecuteTransactionOutputTransform() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionMiddlewareInternal();
    var output := DDB.ExecuteTransactionOutput(
      Responses := None(),
      ConsumedCapacity := None()
    );
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
    var transformed := middlewareUnderTest.ExecuteTransactionOutputTransform(
      AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.ExecuteTransactionOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("ExecuteTransactionOutput", transformed);
    expect_equal("ExecuteTransactionOutput", transformed.value.transformedOutput, output);
  }
}
