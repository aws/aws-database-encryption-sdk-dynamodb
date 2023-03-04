// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "TestFixtures.dfy"

module BatchWriteItemTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryption
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDynamoDbEncryptionTypes


  method {:test} TestBatchWriteItemInputTransform() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryption();
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
      AwsCryptographyDynamoDbEncryptionTypes.BatchWriteItemInputTransformInput(
        sdkInput := input
      )
    );

    expect_ok("BatchWriteItemInput", transformed);
    expect_equal("BatchWriteItemInput", transformed.value.transformedInput, input);
  }

  method {:test} TestBatchWriteItemOutputTransform() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryption();
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
      AwsCryptographyDynamoDbEncryptionTypes.BatchWriteItemOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("BatchWriteItemOutput", transformed);
    expect_equal("BatchWriteItemOutput", transformed.value.transformedOutput, output);
  }

}
