// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "TestFixtures.dfy"

module BatchWriteItemTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryptionTransforms
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDynamoDbEncryptionTransformsTypes


  method {:test} TestBatchWriteItemInputTransform() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var tableName := GetTableName("foo");
    var request := DDB.WriteRequest (
      PutRequest := None(),
      DeleteRequest := None()
    );
    var requests := GetWriteRequests([request]);
    var theMap := GetBatchWriteItemRequestMap(map[tableName := requests]);
    var input := DDB.BatchWriteItemInput(
      RequestItems := theMap,
      ReturnConsumedCapacity := None(),
      ReturnItemCollectionMetrics := None()
    );
    var transformed := middlewareUnderTest.BatchWriteItemInputTransform(
      AwsCryptographyDynamoDbEncryptionTransformsTypes.BatchWriteItemInputTransformInput(
        sdkInput := input
      )
    );

    expect_ok("BatchWriteItemInput", transformed);
    expect_equal("BatchWriteItemInput", transformed.value.transformedInput, input);
  }

  method {:test} TestBatchWriteItemOutputTransform() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var output := DDB.BatchWriteItemOutput(
      UnprocessedItems := None(),
      ItemCollectionMetrics := None(),
      ConsumedCapacity := None()
    );
    var tableName := GetTableName("foo");
    var request := DDB.WriteRequest (
      PutRequest := None(),
      DeleteRequest := None()
    );
    var requests := GetWriteRequests([request]);
    var theMap := GetBatchWriteItemRequestMap(map[tableName := requests]);

    var input := DDB.BatchWriteItemInput(
      RequestItems := theMap,
      ReturnConsumedCapacity := None(),
      ReturnItemCollectionMetrics := None()
    );
    var transformed := middlewareUnderTest.BatchWriteItemOutputTransform(
      AwsCryptographyDynamoDbEncryptionTransformsTypes.BatchWriteItemOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("BatchWriteItemOutput", transformed);
    expect_equal("BatchWriteItemOutput", transformed.value.transformedOutput, output);
  }

}
