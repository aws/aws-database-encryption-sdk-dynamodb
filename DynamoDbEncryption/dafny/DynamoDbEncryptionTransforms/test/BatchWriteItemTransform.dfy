// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "TestFixtures.dfy"

module BatchWriteItemTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryptionTransforms
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import TTypes = AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes

  method {:test} TestBatchWriteItemInputTransform() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var tableName := GetTableName("foo");
    var request := DDB.WriteRequest (
      PutRequest := None,
      DeleteRequest := None
    );
    var requests := GetWriteRequests([request]);
    var theMap := GetBatchWriteItemRequestMap(map[tableName := requests]);
    var input := DDB.BatchWriteItemInput(
      RequestItems := theMap,
      ReturnConsumedCapacity := None,
      ReturnItemCollectionMetrics := None
    );
    var transformed := middlewareUnderTest.BatchWriteItemInputTransform(
      TTypes.BatchWriteItemInputTransformInput(
        sdkInput := input
      )
    );

    expect_ok("BatchWriteItemInput", transformed);
    expect_equal("BatchWriteItemInput", transformed.value.transformedInput, input);
  }


  const Item1 : DDB.AttributeMap := map[
                                      "bar" := DDB.AttributeValue.S("bar1"),
                                      "sign" := DDB.AttributeValue.S("sign1"),
                                      "encrypt" := DDB.AttributeValue.S("encrypt1"),
                                      "plain" := DDB.AttributeValue.S("plain1")
                                    ]

  const Item2 : DDB.AttributeMap := map[
                                      "bar" := DDB.AttributeValue.S("bar2"),
                                      "sign" := DDB.AttributeValue.S("sign2"),
                                      "encrypt" := DDB.AttributeValue.S("encrypt2"),
                                      "plain" := DDB.AttributeValue.S("plain2")
                                    ]

  const Item3 : DDB.AttributeMap := map[
                                      "bar" := DDB.AttributeValue.S("bar3"),
                                      "sign" := DDB.AttributeValue.S("sign3"),
                                      "encrypt" := DDB.AttributeValue.S("encrypt3"),
                                      "plain" := DDB.AttributeValue.S("plain3")
                                    ]

  const Item4 : DDB.AttributeMap := map[
                                      "bar" := DDB.AttributeValue.S("bar4"),
                                      "sign" := DDB.AttributeValue.S("sign4"),
                                      "encrypt" := DDB.AttributeValue.S("encrypt4"),
                                      "plain" := DDB.AttributeValue.S("plain4")
                                    ]

  method {:test} TestBatchWriteItemOutputTransform() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var output := DDB.BatchWriteItemOutput(
      UnprocessedItems := None,
      ItemCollectionMetrics := None,
      ConsumedCapacity := None
    );
    var tableName := GetTableName("foo");
    var request := DDB.WriteRequest (
      PutRequest := None,
      DeleteRequest := None
    );
    var requests := GetWriteRequests([request]);
    var theMap := GetBatchWriteItemRequestMap(map[tableName := requests]);

    var input := DDB.BatchWriteItemInput(
      RequestItems := theMap,
      ReturnConsumedCapacity := None,
      ReturnItemCollectionMetrics := None
    );
    var transformed := middlewareUnderTest.BatchWriteItemOutputTransform(
      TTypes.BatchWriteItemOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("BatchWriteItemOutput", transformed);
    expect_equal("BatchWriteItemOutput", transformed.value.transformedOutput, output);
  }

  function method MakePut(item : DDB.AttributeMap) : DDB.WriteRequest
  {
    DDB.WriteRequest ( DeleteRequest := None, PutRequest := Some(DDB.PutRequest(Item := item)))
  }

  //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-batchwriteitem
  //= type=test
  //# Each item in UnprocessedItems MUST be replaced by its original plaintext value.
  method {:test} TestBatchWriteItemOutputTransformUnprocessed() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var tableName := GetTableName("foo");

    var theRequests := GetBatchWriteItemRequestMap(map[tableName := [MakePut(Item1), MakePut(Item2), MakePut(Item3), MakePut(Item4)]]);

    var input := DDB.BatchWriteItemInput(
      RequestItems := theRequests
    );
    var transInput :- expect middlewareUnderTest.BatchWriteItemInputTransform(
      TTypes.BatchWriteItemInputTransformInput(
        sdkInput := input
      )
    );

    var unProcessed : DDB.BatchWriteItemRequestMap := transInput.transformedInput.RequestItems;
    expect unProcessed != input.RequestItems;
    var output := DDB.BatchWriteItemOutput(
      UnprocessedItems := Some(unProcessed)
    );

    var transOutput :- expect middlewareUnderTest.BatchWriteItemOutputTransform(
      TTypes.BatchWriteItemOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_equal("BatchWriteOutput", transOutput.transformedOutput.UnprocessedItems, Some(theRequests));
  }

  method {:test} TestBatchWriteItemOutputTransformUnprocessed2() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var tableName1 := GetTableName("foo");
    var tableName2 := GetTableName("baz");

    var theRequests := GetBatchWriteItemRequestMap(map[tableName1 := [MakePut(Item1), MakePut(Item2)], tableName2 := [MakePut(Item3), MakePut(Item4)]]);

    var input := DDB.BatchWriteItemInput(
      RequestItems := theRequests
    );
    var transInput :- expect middlewareUnderTest.BatchWriteItemInputTransform(
      TTypes.BatchWriteItemInputTransformInput(
        sdkInput := input
      )
    );

    var unProcessed : DDB.BatchWriteItemRequestMap := transInput.transformedInput.RequestItems;
    expect unProcessed != input.RequestItems;
    var output := DDB.BatchWriteItemOutput(
      UnprocessedItems := Some(unProcessed)
    );

    var transOutput :- expect middlewareUnderTest.BatchWriteItemOutputTransform(
      TTypes.BatchWriteItemOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_equal("BatchWriteOutput", transOutput.transformedOutput.UnprocessedItems, Some(theRequests));
  }

  method {:test} {:vcs_split_on_every_assert} TestBatchWriteItemOutputTransformUnprocessed3() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var tableName1 := GetTableName("foo");
    var tableName2 := GetTableName("baz");

    var theRequests := GetBatchWriteItemRequestMap(map[tableName1 := [MakePut(Item1), MakePut(Item2)], tableName2 := [MakePut(Item3), MakePut(Item4)]]);

    var input := DDB.BatchWriteItemInput(
      RequestItems := theRequests
    );
    var transInput :- expect middlewareUnderTest.BatchWriteItemInputTransform(
      TTypes.BatchWriteItemInputTransformInput(
        sdkInput := input
      )
    );

    expect tableName1 in transInput.transformedInput.RequestItems;
    expect tableName2 in transInput.transformedInput.RequestItems;

    var list := map[
      tableName1 := transInput.transformedInput.RequestItems[tableName1][0..1],
      tableName2 := transInput.transformedInput.RequestItems[tableName2][0..1]
    ];
    expect DDB.IsValid_BatchWriteItemRequestMap(list);
    var unProcessed : DDB.BatchWriteItemRequestMap := list;

    var orig_list := map [
      tableName1 := [MakePut(Item1)],
      tableName2 := [MakePut(Item3)]
    ];
    expect DDB.IsValid_BatchWriteItemRequestMap(orig_list);
    var originalUnProcessed : DDB.BatchWriteItemRequestMap := orig_list;

    expect unProcessed != input.RequestItems;
    var output := DDB.BatchWriteItemOutput(
      UnprocessedItems := Some(unProcessed)
    );

    var transOutput :- expect middlewareUnderTest.BatchWriteItemOutputTransform(
      TTypes.BatchWriteItemOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_equal("BatchWriteOutput", transOutput.transformedOutput.UnprocessedItems, Some(originalUnProcessed));
  }

  const Item1a : DDB.AttributeMap := map[
                                       "bar" := DDB.AttributeValue.S("bar1"),
                                       "sign" := DDB.AttributeValue.S("sign2"),
                                       "encrypt" := DDB.AttributeValue.S("encrypt2"),
                                       "plain" := DDB.AttributeValue.S("plain2")
                                     ]

  const Item1b : DDB.AttributeMap := map[
                                       "bar" := DDB.AttributeValue.S("bar1"),
                                       "sign" := DDB.AttributeValue.S("sign3"),
                                       "encrypt" := DDB.AttributeValue.S("encrypt3"),
                                       "plain" := DDB.AttributeValue.S("plain3")
                                     ]

  const Item1c : DDB.AttributeMap := map[
                                       "bar" := DDB.AttributeValue.S("bar1"),
                                       "sign" := DDB.AttributeValue.S("sign4"),
                                       "encrypt" := DDB.AttributeValue.S("encrypt4"),
                                       "plain" := DDB.AttributeValue.S("plain4")
                                     ]

  method {:test} TestBatchWriteItemOutputTransformUnprocessed4() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms2();
    var tableName1 := GetTableName("foo");
    var tableName2 := GetTableName("baz");

    var theRequests := GetBatchWriteItemRequestMap(map[tableName1 := [MakePut(Item1), MakePut(Item1a)], tableName2 := [MakePut(Item1b), MakePut(Item1c)]]);

    var input := DDB.BatchWriteItemInput(
      RequestItems := theRequests
    );
    var transInput :- expect middlewareUnderTest.BatchWriteItemInputTransform(
      TTypes.BatchWriteItemInputTransformInput(
        sdkInput := input
      )
    );

    var unProcessed : DDB.BatchWriteItemRequestMap := transInput.transformedInput.RequestItems;
    expect unProcessed != input.RequestItems;
    var output := DDB.BatchWriteItemOutput(
      UnprocessedItems := Some(unProcessed)
    );

    var transOutput :- expect middlewareUnderTest.BatchWriteItemOutputTransform(
      TTypes.BatchWriteItemOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_equal("BatchWriteOutput", transOutput.transformedOutput.UnprocessedItems, Some(theRequests));
  }
}
