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
      Item := map[]
    );
    var transformed := middlewareUnderTest.PutItemInputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemInputTransformInput(
        sdkInput := input
      )
    );

    expect_ok("PutItemInput", transformed);
    expect_equal("PutItemInput", transformed.value.transformedInput, input);
  }

  const BasicItem : DDB.AttributeMap := map["bar" := DDB.AttributeValue.S("baz")]

  method TestPutItemInputMultiFail(plaintextOverride : Option<AwsCryptographyDbEncryptionSdkDynamoDbTypes.PlaintextOverride>) {
    assume {:axiom} false;
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransformsMulti(plaintextOverride);
    var tableName := GetTableName("foo");
    var input := DDB.PutItemInput(
      TableName := tableName,
      Item := BasicItem
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

  method {:test} TestPutItemInputMulti() {
    assume {:axiom} false;
    TestPutItemInputMultiFail(None);
    TestPutItemInputMultiFail(Some(PlaintextOverride.FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ));
    TestPutItemInputMultiFail(Some(PlaintextOverride.FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ));
  }

  method {:test} TestPutItemInputMultiForceAllow() {
    assume {:axiom} false;
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransformsMulti(
      Some(PlaintextOverride.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ)
    );
    var tableName := GetTableName("foo");
    var input := DDB.PutItemInput(
      TableName := tableName,
      Item := BasicItem
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
      Item := map[]
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
