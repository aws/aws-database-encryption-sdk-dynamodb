// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../src/DynamoDbEncryption/Index.dfy"
include "../TestFixtures.dfy"

module ScanTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryption
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDynamoDbEncryptionTypes

  method {:test} TestScanInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryption();
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
      AwsCryptographyDynamoDbEncryptionTypes.ScanInputTransformInput(
        sdkInput := input
      )
    );

    expect_ok("ScanInput", transformed);
    expect_equal("ScanInput", transformed.value.transformedInput, input);
  }

  method {:test} TestScanOutputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryption();
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
      AwsCryptographyDynamoDbEncryptionTypes.ScanOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("ScanOutput", transformed);
    expect_equal("ScanOutput", transformed.value.transformedOutput, output);
  }
}
