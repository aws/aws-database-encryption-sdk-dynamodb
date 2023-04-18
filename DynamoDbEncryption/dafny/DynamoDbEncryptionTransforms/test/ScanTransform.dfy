// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../DynamoDbEncryptionTransforms/src/Index.dfy"
include "TestFixtures.dfy"

module ScanTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryptionTransforms
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDynamoDbEncryptionTransformsTypes

  method {:test} TestScanInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var tableName := GetTableName("no_such_table");
    var input := DDB.ScanInput(
      TableName := tableName,
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
      AwsCryptographyDynamoDbEncryptionTransformsTypes.ScanInputTransformInput(
        sdkInput := input
      )
    );

    expect_ok("ScanInput", transformed);
    expect_equal("ScanInput", transformed.value.transformedInput, input);
  }

  method {:test} TestScanOutputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var output := DDB.ScanOutput(
      Items := None(),
      Count := None(),
      ScannedCount := None(),
      LastEvaluatedKey := None(),
      ConsumedCapacity := None()
    );
    var tableName := GetTableName("no_such_table");
    var input := DDB.ScanInput(
      TableName := tableName,
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
      AwsCryptographyDynamoDbEncryptionTransformsTypes.ScanOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("ScanOutput", transformed);
    expect_equal("ScanOutput", transformed.value.transformedOutput, output);
  }
}
