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

  method {:test} TestPutItemAttributeNameTooLongBytes() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var tableName := GetTableName("foo");
    // 0xE9 is a 2-byte UTF-8 char, so 40000 chars => 80000 bytes, exceeding the 65535-byte limit.
    var twoByteChar := 0xE9 as char;
    var longKey : DDB.AttributeName := seq(40000, i => twoByteChar);
    var input := DDB.PutItemInput(
      TableName := tableName,
      Item := map[
        "bar" := DDB.AttributeValue.S("key"),
        "encrypt" := DDB.AttributeValue.M(map[longKey := DDB.AttributeValue.S("x")])
      ]
    );
    var transformed := middlewareUnderTest.PutItemInputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemInputTransformInput(
        sdkInput := input
      )
    );
    expect transformed.Failure?;
    expect transformed.error.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor?;
    var encErr := transformed.error.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor;
    expect encErr.AwsCryptographyDbEncryptionSdkDynamoDb?;
    var ddbErr := encErr.AwsCryptographyDbEncryptionSdkDynamoDb;
    expect ddbErr.DynamoDbEncryptionException?;
    expect ddbErr.message == "Attribute name must be between 1 and 65535 UTF-8 bytes";
  }

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
