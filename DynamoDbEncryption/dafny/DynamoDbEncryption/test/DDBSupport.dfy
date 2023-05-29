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
    var newItem :- expect AddSignedBeacons(Some(search), SimpleItem);
    assert IsValid_AttributeName("aws_dbe_v_1");
    assert IsValid_AttributeName("JustSigned");
    var expectedNew : DDB.AttributeMap := map[
      "aws_dbe_v_1" := AttributeValue.S(" "),
      "JustSigned" := AttributeValue.S("Y_1984.M_May")
    ];
    expect newItem == SimpleItem + expectedNew;
  }

  method {:test} TestCreateTablePlain() {
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var search := SI.SearchInfo([bv], 0);
    var oldCreate := DDB.CreateTableInput(
      AttributeDefinitions := [
        AttributeDefinition(AttributeName := "PK", AttributeType := ScalarAttributeType.S),
        AttributeDefinition(AttributeName := "SK", AttributeType := ScalarAttributeType.S)
      ],
      TableName := "MyTableName",
      KeySchema := [
        KeySchemaElement(AttributeName := "PK", KeyType := HASH),
        KeySchemaElement(AttributeName := "SK", KeyType := RANGE)
      ],
      LocalSecondaryIndexes := None,
      GlobalSecondaryIndexes := None,
      BillingMode := None,
      ProvisionedThroughput := None,
      StreamSpecification := None,
      SSESpecification := None,
      Tags := None,
      TableClass := None
    );
    var newCreate :- expect CreateTableInputForBeacons(Some(search), FullTableConfig.attributeActionsOnEncrypt, oldCreate);
    expect newCreate == oldCreate;
  }

  method {:test} TestCreateTableIndexes() {
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var search := SI.SearchInfo([bv], 0);
    var oldCreate := DDB.CreateTableInput(
      AttributeDefinitions := [
        AttributeDefinition(AttributeName := "PK", AttributeType := ScalarAttributeType.S),
        AttributeDefinition(AttributeName := "SK", AttributeType := ScalarAttributeType.S),
        AttributeDefinition(AttributeName := "PK1", AttributeType := ScalarAttributeType.S),
        AttributeDefinition(AttributeName := "SK1", AttributeType := ScalarAttributeType.S)
      ],
      TableName := "MyTableName",
      KeySchema := [
        KeySchemaElement(AttributeName := "PK", KeyType := HASH),
        KeySchemaElement(AttributeName := "SK", KeyType := RANGE)
      ],
      LocalSecondaryIndexes := Some([
        DDB.LocalSecondaryIndex(
          IndexName := "Local1",
          KeySchema := [
            KeySchemaElement(AttributeName := "Local", KeyType := RANGE)
          ],
          Projection := Projection(
            ProjectionType := Some(ProjectionType.ALL),
            NonKeyAttributes := None
          )
        )
      ]),
      GlobalSecondaryIndexes := Some([
        DDB.GlobalSecondaryIndex(
          IndexName := "GSI1",
          KeySchema := [
            KeySchemaElement(AttributeName := "PK1", KeyType := HASH),
            KeySchemaElement(AttributeName := "SK1", KeyType := RANGE)
          ],
          Projection := Projection(
            ProjectionType := Some(ProjectionType.ALL),
            NonKeyAttributes := None
          ),
          ProvisionedThroughput := Some(ProvisionedThroughput (
            ReadCapacityUnits := 42 ,
            WriteCapacityUnits := 43
          ))
        )
      ]),
      BillingMode := None,
      ProvisionedThroughput := None,
      StreamSpecification := None,
      SSESpecification := None,
      Tags := None,
      TableClass := None
    );
    var newCreate :- expect CreateTableInputForBeacons(Some(search), FullTableConfig.attributeActionsOnEncrypt, oldCreate);
    expect newCreate == oldCreate;
  }

    method {:test} TestCreateTableIndexesAndBeacons() {
    var version := GetIndexBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var search := SI.SearchInfo([bv], 0);
    var oldCreate := DDB.CreateTableInput(
      AttributeDefinitions := [
        AttributeDefinition(AttributeName := "PK", AttributeType := ScalarAttributeType.S),
        AttributeDefinition(AttributeName := "SK", AttributeType := ScalarAttributeType.S),
        AttributeDefinition(AttributeName := "PK1", AttributeType := ScalarAttributeType.S),
        AttributeDefinition(AttributeName := "SK1", AttributeType := ScalarAttributeType.S),
        AttributeDefinition(AttributeName := "Local", AttributeType := ScalarAttributeType.S)
      ],
      TableName := "MyTableName",
      KeySchema := [
        KeySchemaElement(AttributeName := "PK", KeyType := HASH),
        KeySchemaElement(AttributeName := "SK", KeyType := RANGE)
      ],
      LocalSecondaryIndexes := Some([
        DDB.LocalSecondaryIndex(
          IndexName := "Local1",
          KeySchema := [
            KeySchemaElement(AttributeName := "Local", KeyType := RANGE)
          ],
          Projection := Projection(
            ProjectionType := Some(ProjectionType.ALL),
            NonKeyAttributes := None
          )
        )
      ]),
      GlobalSecondaryIndexes := Some([
        DDB.GlobalSecondaryIndex(
          IndexName := "GSI1",
          KeySchema := [
            KeySchemaElement(AttributeName := "PK1", KeyType := HASH),
            KeySchemaElement(AttributeName := "SK1", KeyType := RANGE)
          ],
          Projection := Projection(
            ProjectionType := Some(ProjectionType.ALL),
            NonKeyAttributes := None
          ),
          ProvisionedThroughput := Some(ProvisionedThroughput (
            ReadCapacityUnits := 42 ,
            WriteCapacityUnits := 43
          ))
        )
      ]),
      BillingMode := None,
      ProvisionedThroughput := None,
      StreamSpecification := None,
      SSESpecification := None,
      Tags := None,
      TableClass := None
    );
    var expectedCreate := DDB.CreateTableInput(
      AttributeDefinitions := [
        AttributeDefinition(AttributeName := "PK", AttributeType := ScalarAttributeType.S),
        AttributeDefinition(AttributeName := "SK", AttributeType := ScalarAttributeType.S),
        AttributeDefinition(AttributeName := "aws_dbe_b_PK1", AttributeType := ScalarAttributeType.S),
        AttributeDefinition(AttributeName := "aws_dbe_b_SK1", AttributeType := ScalarAttributeType.S),
        AttributeDefinition(AttributeName := "aws_dbe_b_Local", AttributeType := ScalarAttributeType.S)
      ],
      TableName := "MyTableName",
      KeySchema := [
        KeySchemaElement(AttributeName := "PK", KeyType := HASH),
        KeySchemaElement(AttributeName := "SK", KeyType := RANGE)
      ],
      LocalSecondaryIndexes := Some([
        DDB.LocalSecondaryIndex(
          IndexName := "Local1",
          KeySchema := [
            KeySchemaElement(AttributeName := "aws_dbe_b_Local", KeyType := RANGE)
          ],
          Projection := Projection(
            ProjectionType := Some(ProjectionType.ALL),
            NonKeyAttributes := None
          )
        )
      ]),
      GlobalSecondaryIndexes := Some([
        DDB.GlobalSecondaryIndex(
          IndexName := "GSI1",
          KeySchema := [
            KeySchemaElement(AttributeName := "aws_dbe_b_PK1", KeyType := HASH),
            KeySchemaElement(AttributeName := "aws_dbe_b_SK1", KeyType := RANGE)
          ],
          Projection := Projection(
            ProjectionType := Some(ProjectionType.ALL),
            NonKeyAttributes := None
          ),
          ProvisionedThroughput := Some(ProvisionedThroughput (
            ReadCapacityUnits := 42 ,
            WriteCapacityUnits := 43
          ))
        )
      ]),
      BillingMode := None,
      ProvisionedThroughput := None,
      StreamSpecification := None,
      SSESpecification := None,
      Tags := None,
      TableClass := None
    );

    var newCreate :- expect CreateTableInputForBeacons(Some(search), FullTableConfig.attributeActionsOnEncrypt, oldCreate);
    expect newCreate == expectedCreate;
  }
}
