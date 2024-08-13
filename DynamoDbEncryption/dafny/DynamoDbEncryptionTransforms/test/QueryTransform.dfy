// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "TestFixtures.dfy"

module QueryTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryptionTransforms
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import DBT = AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
  import DBE = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import Types = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes

  method {:test} TestQueryInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var tableName := GetTableName("no_such_table");
    var input := DDB.QueryInput(
      TableName := tableName,
      IndexName := None(),
      Select := None(),
      AttributesToGet := None(),
      Limit := None(),
      ConsistentRead := None(),
      KeyConditions := None(),
      QueryFilter := None(),
      ConditionalOperator := None(),
      ScanIndexForward := None(),
      ExclusiveStartKey := None(),
      ReturnConsumedCapacity := None(),
      ProjectionExpression := None(),
      FilterExpression := None(),
      KeyConditionExpression := None(),
      ExpressionAttributeNames := None(),
      ExpressionAttributeValues := None()
    );
    var transformed := middlewareUnderTest.QueryInputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.QueryInputTransformInput(
        sdkInput := input
      )
    );

    expect_ok("QueryInput", transformed);
    expect_equal("QueryInput", transformed.value.transformedInput, input);
  }

  method {:test} TestQueryOutputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var output := DDB.QueryOutput(
      Items := None(),
      Count := None(),
      ScannedCount := None(),
      LastEvaluatedKey := None(),
      ConsumedCapacity := None()
    );
    var tableName := GetTableName("no_such_table");
    var input := DDB.QueryInput(
      TableName := tableName
    );
    var transformed := middlewareUnderTest.QueryOutputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.QueryOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("QueryOutput", transformed);
    expect_equal("QueryOutput", transformed.value.transformedOutput, output);
  }

  function method DDBS(x : string) : DDB.AttributeValue {
    DDB.AttributeValue.S(x)
  }

  const Actions1 : DBE.AttributeActions := map[
                                             GetAttrName("bar") := CSE.SIGN_ONLY,
                                             GetAttrName("sortKey") := CSE.SIGN_ONLY,
                                             GetAttrName("encrypt1") := CSE.ENCRYPT_AND_SIGN,
                                             GetAttrName("encrypt2") := CSE.ENCRYPT_AND_SIGN,
                                             GetAttrName("sign1") := CSE.SIGN_ONLY,
                                             GetAttrName("sign2") := CSE.SIGN_ONLY
                                           ]

  method {:test} TestDecryptErrorWithSortKey() {
    var config := TestFixtures.GetEncryptorConfigFromActions(Actions1, Some("sortKey"));
    var encryptor := TestFixtures.GetDynamoDbItemEncryptorFrom(config);

    var inputItem : map<DDB.AttributeName, DDB.AttributeValue> := map[
      "bar" := DDB.AttributeValue.N("00001234"),
      "sortKey" := DDB.AttributeValue.B([1,2,3,4]),
      "encrypt1" := DDBS("some text"),
      "encrypt2" := DDBS("more text"),
      "sign1" := DDBS("stuff"),
      "sign2" := DDB.AttributeValue.BOOL(false)
    ];

    var encryptRes :- expect encryptor.EncryptItem(
      Types.EncryptItemInput(
        plaintextItem:=inputItem
      )
    );
    var item1 := encryptRes.encryptedItem;
    expect "encrypt1" in item1;
    expect item1["encrypt1"] != DDBS("some text");

    inputItem := map[
      "bar" := DDB.AttributeValue.N("567"),
      "sortKey" := DDB.AttributeValue.B([5,6,7]),
      "encrypt1" := DDBS("some text"),
      "encrypt2" := DDBS("more text"),
      "sign1" := DDBS("stuff"),
      "sign2" := DDB.AttributeValue.BOOL(false)
    ];
    encryptRes :- expect encryptor.EncryptItem(
      Types.EncryptItemInput(
        plaintextItem:=inputItem
      )
    );
    var item2 := encryptRes.encryptedItem;
    expect "encrypt1" in item2;
    expect item2["encrypt1"] != DDBS("some text");

    inputItem := map[
      "bar" := DDB.AttributeValue.N("890"),
      "sortKey" := DDB.AttributeValue.B([3,1,4]),
      "encrypt1" := DDBS("some text"),
      "encrypt2" := DDBS("more text"),
      "sign1" := DDBS("stuff"),
      "sign2" := DDB.AttributeValue.BOOL(false)
    ];
    encryptRes :- expect encryptor.EncryptItem(
      Types.EncryptItemInput(
        plaintextItem:=inputItem
      )
    );
    var item3 := encryptRes.encryptedItem;
    expect "encrypt1" in item3;
    expect item3["encrypt1"] != DDBS("some text");

    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms2(Actions1, Some("sortKey"));
    var tableName := GetTableName("foo");
    var input := DDB.QueryInput(
      TableName := tableName
    );

    var transformed := middlewareUnderTest.QueryOutputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.QueryOutputTransformInput(
        sdkOutput := DDB.QueryOutput(Items := Some([item1, item2, item3])),
        originalInput := input
      )
    );

    TestFixtures.expect_ok("QueryOutput", transformed);
    expect transformed.value.transformedOutput.Items.Some?;
    var itemList := transformed.value.transformedOutput.Items.value;
    expect |itemList| == 3;
    expect "encrypt1" in itemList[0];
    expect itemList[0]["encrypt1"] == DDBS("some text");


/// now do some damage
    item1 := item1["encrypt1" := item2["encrypt1"]];
    transformed := middlewareUnderTest.QueryOutputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.QueryOutputTransformInput(
        sdkOutput := DDB.QueryOutput(Items := Some([item1, item2, item3])),
        originalInput := input
      )
    );
    expect transformed.Failure?;
    print "\n", transformed.error, "\n";
    expect transformed.error ==
           AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.CollectionOfErrors(
             [
               AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor(AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error.AwsCryptographyDbEncryptionSdkDynamoDb(AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error.AwsCryptographyDbEncryptionSdkStructuredEncryption(AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error.StructuredEncryptionException(message := "Signature of record does not match the signature computed when the record was encrypted.")))),
               AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.DynamoDbEncryptionTransformsException(message := "bar = 1234; sortKey = 01020304")
             ],
             message := "Error(s) found decrypting Query results."
           );

/// do more damage
    item3 := item3["encrypt1" := item2["encrypt1"]];
    transformed := middlewareUnderTest.QueryOutputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.QueryOutputTransformInput(
        sdkOutput := DDB.QueryOutput(Items := Some([item1, item2, item3])),
        originalInput := input
      )
    );
    expect transformed.Failure?;
    print "\n", transformed.error, "\n";
    expect transformed.error ==
           AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.CollectionOfErrors(
             [
               AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor(AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error.AwsCryptographyDbEncryptionSdkDynamoDb(AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error.AwsCryptographyDbEncryptionSdkStructuredEncryption(AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error.StructuredEncryptionException(message := "Signature of record does not match the signature computed when the record was encrypted.")))),
               AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.DynamoDbEncryptionTransformsException(message := "bar = 1234; sortKey = 01020304"),
               AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.DynamoDbEncryptionTransformsException(message := "bar = 890; sortKey = 030104")
             ],
             message := "Error(s) found decrypting Query results."
           );

    var transformed_scan := middlewareUnderTest.ScanOutputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ScanOutputTransformInput(
        sdkOutput := DDB.ScanOutput(Items := Some([item1, item2, item3])),
        originalInput := DDB.ScanInput(TableName := tableName)
      )
    );
    expect transformed_scan.Failure?;
    print "\n", transformed_scan.error, "\n";
    expect transformed_scan.error ==
           AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.CollectionOfErrors(
             [
               AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor(AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error.AwsCryptographyDbEncryptionSdkDynamoDb(AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error.AwsCryptographyDbEncryptionSdkStructuredEncryption(AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error.StructuredEncryptionException(message := "Signature of record does not match the signature computed when the record was encrypted.")))),
               AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.DynamoDbEncryptionTransformsException(message := "bar = 1234; sortKey = 01020304"),
               AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.DynamoDbEncryptionTransformsException(message := "bar = 890; sortKey = 030104")
             ],
             message := "Error(s) found decrypting Scan results."
           );
  }
}
