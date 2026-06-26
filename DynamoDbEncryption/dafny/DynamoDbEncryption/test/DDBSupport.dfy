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
    var newItem :- expect AddSignedBeacons(Some(search), SimpleItem, 0);
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

  // ValidateExpressionLength is the chokepoint that prevents
  // pathologically long DynamoDB expression strings from reaching the
  // recursive expression parser. Verify each branch of the helper.
  method {:test} TestValidateExpressionLength() {
    // None: nothing to validate.
    expect ValidateExpressionLength(None, "FilterExpression") == Success(true);

    // Empty string: trivially within the limit.
    expect ValidateExpressionLength(Some(""), "FilterExpression") == Success(true);

    // Short string: ordinary case.
    expect ValidateExpressionLength(Some("a < :b"), "FilterExpression") == Success(true);

    // Exactly at the limit (4096 characters): accepted.
    var atLimit : string := seq(MAX_EXPRESSION_LENGTH, _ => ' ');
    expect |atLimit| == MAX_EXPRESSION_LENGTH;
    expect ValidateExpressionLength(Some(atLimit), "KeyConditionExpression") == Success(true);

    // One over the limit (4097 characters): rejected with the expected
    // error, which names the field that violated the constraint.
    var overLimit : string := seq(MAX_EXPRESSION_LENGTH + 1, _ => ' ');
    expect |overLimit| == MAX_EXPRESSION_LENGTH + 1;
    expect ValidateExpressionLength(Some(overLimit), "KeyConditionExpression")
        == Failure(E("KeyConditionExpression exceeds maximum length of 4096 characters."));
    expect ValidateExpressionLength(Some(overLimit), "FilterExpression")
        == Failure(E("FilterExpression exceeds maximum length of 4096 characters."));
  }

  // Confirm that the length check is wired into the public API surface:
  // an over-long KeyConditionExpression must be rejected by
  // QueryInputForBeacons before any expression parsing takes place.
  // search := None is sufficient — the length check runs first,
  // independent of whether searchable encryption is configured.
  method {:test} TestQueryInputForBeaconsRejectsLongKeyExpression() {
    var overLimit : string := seq(MAX_EXPRESSION_LENGTH + 1, _ => ' ');
    var queryInput := DDB.QueryInput(
      TableName := "SomeTable",
      KeyConditionExpression := Some(overLimit)
    );
    var result := QueryInputForBeacons(None, map[], queryInput);
    expect result == Failure(E("KeyConditionExpression exceeds maximum length of 4096 characters."));
  }

  // Same as above for FilterExpression on the scan path.
  method {:test} TestScanInputForBeaconsRejectsLongFilterExpression() {
    var overLimit : string := seq(MAX_EXPRESSION_LENGTH + 1, _ => ' ');
    var scanInput := DDB.ScanInput(
      TableName := "SomeTable",
      FilterExpression := Some(overLimit)
    );
    var result := ScanInputForBeacons(None, map[], scanInput);
    expect result == Failure(E("FilterExpression exceeds maximum length of 4096 characters."));
  }
}
