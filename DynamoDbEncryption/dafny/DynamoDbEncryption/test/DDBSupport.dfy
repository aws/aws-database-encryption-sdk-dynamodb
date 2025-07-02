// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "BeaconTestFixtures.dfy"
include "../src/DDBSupport.dfy"

module TestDDBSupport {
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import opened ComAmazonawsDynamodbTypes
  import opened DynamoDBFilterExpr
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened BeaconTestFixtures
  import opened DynamoDBSupport
  import opened DynamoDbEncryptionUtil
  import opened SearchConfigToInfo
  import SI = SearchableEncryptionInfo

  method {:test} TestAddSignedBeacons() {
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var search := SI.SearchInfo([bv], 0);
    var newItem :- expect AddSignedBeacons(Some(search), SimpleItem, []);
    assert IsValid_AttributeName("aws_dbe_v_1");
    assert IsValid_AttributeName("JustSigned");
    var expectedNew : DDB.AttributeMap := map[
      "aws_dbe_v_1" := AttributeValue.S(" "),
      "JustSigned" := AttributeValue.S("Y_1984.M_May")
    ];
    expect newItem == SimpleItem + expectedNew;
  }

  // DynamoDB String :: cast string to DDB.AttributeValue.S
  function method DS(x : string) : DDB.AttributeValue
  {
    DDB.AttributeValue.S(x)
  }

  method {:test} TestMulti() {
    var version := GetLotsaBeaconsMulti();
    var src := GetMultiSource("TheKeyField", version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var search := SI.SearchInfo([bv], 0);
    var expressionAttributeValues : map<string, AttributeValue> := map[
      ":value" := DS("0ad21413-51aa-42e1-9c3d-6a4b1edf7e10")
    ];
    var queryInput := DDB.QueryInput (
      TableName := "SomeTable",
      ExpressionAttributeValues := Some(expressionAttributeValues),
      KeyConditionExpression := Some("TheKeyField = :value")
    );
    var result :- expect QueryInputForBeacons(Some(search), FullTableConfig.attributeActionsOnEncrypt, queryInput);

    // Verify Success with branch key id plus beacon
    expressionAttributeValues := map[
      ":value" := DS("0ad21413-51aa-42e1-9c3d-6a4b1edf7e10"),
      ":other" := DS("junk")
    ];
    queryInput := DDB.QueryInput (
      TableName := "foo",
      ExpressionAttributeValues := Some(expressionAttributeValues),
      KeyConditionExpression := Some("TheKeyField = :value AND std2 = :other")
    );
    result :- expect QueryInputForBeacons(Some(search), FullTableConfig.attributeActionsOnEncrypt, queryInput);

    // Verify Failure with beacon but no branch key id
    queryInput := DDB.QueryInput (
      TableName := "foo",
      ExpressionAttributeValues := Some(expressionAttributeValues),
      KeyConditionExpression := Some("std2 = :other")
    );
    var result2 := QueryInputForBeacons(Some(search), FullTableConfig.attributeActionsOnEncrypt, queryInput);
    expect result2 == Failure(AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error.DynamoDbEncryptionException(
                                message := "Need KeyId because of beacon std2 but no KeyId found in query"));

    // Verify Success, even when field names are indirect via ExpressionAttributeNames
    var expressionAttributeNames := map[
      "#beacon" := "std2",
      "#keyfield" := "TheKeyField"
    ];
    queryInput := DDB.QueryInput (
      TableName := "foo",
      ExpressionAttributeNames := Some(expressionAttributeNames),
      ExpressionAttributeValues := Some(expressionAttributeValues),
      KeyConditionExpression := Some("#keyfield = :value AND #beacon = :other")
    );
    result :- expect QueryInputForBeacons(Some(search), FullTableConfig.attributeActionsOnEncrypt, queryInput);
  }
}
