// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../src/DynamoDbEncryption/Index.dfy"
include "../TestFixtures.dfy"

module BatchGetItemTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryption
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDynamoDbEncryptionTypes


  method {:test} TestBatchGetItemInputTransform() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryption();
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
      AwsCryptographyDynamoDbEncryptionTypes.BatchGetItemInputTransformInput(
        sdkInput := input
      )
    );

    expect_ok("BatchGetItemInput", transformed);
    expect_equal("BatchGetItemInput", transformed.value.transformedInput, input);
  }

  method {:test} TestBatchGetItemOutputTransform() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryption();
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
      AwsCryptographyDynamoDbEncryptionTypes.BatchGetItemOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("BatchGetItemOutput", transformed);
    expect_equal("BatchGetItemOutput", transformed.value.transformedOutput, output);
  }
}
