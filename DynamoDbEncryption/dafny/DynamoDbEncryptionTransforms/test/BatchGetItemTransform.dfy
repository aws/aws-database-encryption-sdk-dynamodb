// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "TestFixtures.dfy"

module BatchGetItemTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryptionTransforms
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDynamoDbEncryptionTransformsTypes


  method {:test} TestBatchGetItemInputTransform() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var tableName := GetTableName("foo");
    var keyList := GetKeyList([map[]]);
    var val := DDB.KeysAndAttributes(
      Keys := keyList,
      AttributesToGet := None(),
      ConsistentRead := None(),
      ProjectionExpression := None(),
      ExpressionAttributeNames := None()
    );
    var theMap := GetBatchGetRequestMap(map[tableName := val]);
    var input := DDB.BatchGetItemInput(
      RequestItems := theMap,
      ReturnConsumedCapacity := None()
    );
    var transformed := middlewareUnderTest.BatchGetItemInputTransform(
      AwsCryptographyDynamoDbEncryptionTransformsTypes.BatchGetItemInputTransformInput(
        sdkInput := input
      )
    );

    expect_ok("BatchGetItemInput", transformed);
    expect_equal("BatchGetItemInput", transformed.value.transformedInput, input);
  }

  method {:test} TestBatchGetItemOutputTransform() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var output := DDB.BatchGetItemOutput(
      Responses := None(),
      UnprocessedKeys := None(),
      ConsumedCapacity := None()
    );
    var tableName := GetTableName("foo");
    var keyList := GetKeyList([map[]]);
    var val := DDB.KeysAndAttributes(
      Keys := keyList,
      AttributesToGet := None(),
      ConsistentRead := None(),
      ProjectionExpression := None(),
      ExpressionAttributeNames := None()
    );
    var theMap := GetBatchGetRequestMap(map[tableName := val]);
    var input := DDB.BatchGetItemInput(
      RequestItems := theMap,
      ReturnConsumedCapacity := None()
    );
    var transformed := middlewareUnderTest.BatchGetItemOutputTransform(
      AwsCryptographyDynamoDbEncryptionTransformsTypes.BatchGetItemOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("BatchGetItemOutput", transformed);
    expect_equal("BatchGetItemOutput", transformed.value.transformedOutput, output);
  }
}
