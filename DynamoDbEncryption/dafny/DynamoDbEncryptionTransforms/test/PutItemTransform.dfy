// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "TestFixtures.dfy"

module PutItemTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryptionTransforms
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTypes

  method {:test} TestPutItemInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var tableName := GetTableName("no_such_table");
    var input := DDB.PutItemInput(
      TableName := tableName,
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
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemInputTransformInput(
        sdkInput := input
      )
    );

    expect_ok("PutItemInput", transformed);
    expect_equal("PutItemInput", transformed.value.transformedInput, input);
  }

  // DynamoDB String :: cast string to DDB.AttributeValue.S
  function method DS(x : string) : DDB.AttributeValue
  {
    DDB.AttributeValue.S(x)
  }
  function method BasicItem() : DDB.AttributeMap
  {
    map[
      "bar" := DS("baz")
    ]
  }
  method {:test} TestPutItemInputMultiNone() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransformsMutli(None);
    var tableName := GetTableName("foo");
    var input := DDB.PutItemInput(
      TableName := tableName,
      Item := BasicItem()
    );
    var transformed := middlewareUnderTest.PutItemInputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemInputTransformInput(
        sdkInput := input
      )
    );
    expect transformed.Failure?;
    expect transformed.error == AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.DynamoDbEncryptionTransformsException(
                                  message := "In multi-tenant mode, keyProviderId must be aws-kms-hierarchy");
  }

  method {:test} TestPutItemInputMultiForbidForbid() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransformsMutli(
      Some(PlaintextOverride.FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ)
    );
    var tableName := GetTableName("foo");
    var input := DDB.PutItemInput(
      TableName := tableName,
      Item := BasicItem()
    );
    var transformed := middlewareUnderTest.PutItemInputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemInputTransformInput(
        sdkInput := input
      )
    );
    expect transformed.Failure?;
    expect transformed.error == AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.DynamoDbEncryptionTransformsException(
                                  message := "In multi-tenant mode, keyProviderId must be aws-kms-hierarchy");
  }

  method {:test} TestPutItemInputMultiForbidAllow() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransformsMutli(
      Some(PlaintextOverride.FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ)
    );
    var tableName := GetTableName("foo");
    var input := DDB.PutItemInput(
      TableName := tableName,
      Item := BasicItem()
    );
    var transformed := middlewareUnderTest.PutItemInputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemInputTransformInput(
        sdkInput := input
      )
    );
    expect transformed.Failure?;
    expect transformed.error == AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.DynamoDbEncryptionTransformsException(
                                  message := "In multi-tenant mode, keyProviderId must be aws-kms-hierarchy");
  }

  method {:test} TestPutItemInputMultiForceAllow() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransformsMutli(
      Some(PlaintextOverride.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ)
    );
    var tableName := GetTableName("foo");
    var input := DDB.PutItemInput(
      TableName := tableName,
      Item := BasicItem()
    );
    var transformed := middlewareUnderTest.PutItemInputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemInputTransformInput(
        sdkInput := input
      )
    );
    expect transformed.Success?;
  }

  method {:test} TestPutItemOutputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var output := DDB.PutItemOutput(
      Attributes := None(),
      ConsumedCapacity := None(),
      ItemCollectionMetrics := None()
    );
    var tableName := GetTableName("no_such_table");
    var input := DDB.PutItemInput(
      TableName := tableName,
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
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("PutItemOutput", transformed);
    expect_equal("PutItemOutput", transformed.value.transformedOutput, output);
  }
}
