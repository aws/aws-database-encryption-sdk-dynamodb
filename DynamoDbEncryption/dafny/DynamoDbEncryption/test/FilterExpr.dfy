// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../src/FilterExpr.dfy"
include "BeaconTestFixtures.dfy"
include "../src/ConfigToInfo.dfy"

module TestDynamoDBFilterExpr {
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import opened ComAmazonawsDynamodbTypes
  import opened DynamoDBFilterExpr
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened BeaconTestFixtures
  import opened SearchConfigToInfo

  method expect_equal<T(==)>(a: T, b: T)
    ensures a == b
  {
    if a != b {
      print "Not equal: ", a, ", ", b, "\n";
    }
    expect a == b;
  }

  method expect_contains(haystack : AttributeValue, needle : AttributeValue, negate : bool)
  {
  if does_contain(haystack, needle) != negate {
      if negate {
        print haystack, " should not have contained ", needle, "but it did\n";
      }
      else {
        print haystack, " should have contained ", needle, "but it didn't\n";
      }
  }
    expect does_contain(haystack, needle) == negate;
  }

  method {:test} LowLevelTests() {
    expect_equal(ParseExpr("and"), [And]);
    expect_equal(ParseExpr("  AnD   "), [And]);
    expect_equal(ParseExpr(" A  AnD  B "), [Attr("A"), And, Attr("B")]);

    var input := [Not, Attr("A"), In, Open, Attr("B"), Comma, Attr("C"), Close, Or];
    expect IsIN(input[1..]);
    expect_equal(ConvertToPrefix(input),  [Not, In, Open, Attr("A"), Comma, Attr("B"), Comma, Attr("C"), Close, Or]);

    input := [And, Or, Not, And, Or, Not, And, Or, Not];
    expect_equal(ConvertToPrefix(input), input);

    input := [Not, Attr("A"), In, Open, Attr("B"), Comma, Attr("C"), Close];
    expect_equal(ConvertToPrefix(input), [Not, In, Open, Attr("A"), Comma, Attr("B"), Comma, Attr("C"), Close]);
  }

  method {:test} TestExtractAttributes() {
    var attrMap : ExpressionAttributeNameMap := map["#one" := "two", "#three" := "four"];
    expect_equal(ExtractAttributes("", None), []);
    expect_equal(ExtractAttributes("", Some(attrMap)), []);
    expect_equal(ExtractAttributes("A < :b", None), ["A"]);
    expect_equal(ExtractAttributes("A <= :b", Some(attrMap)), ["A"]);
    expect_equal(ExtractAttributes("A < B", None), ["A", "B"]);
    expect_equal(ExtractAttributes("A < B", Some(attrMap)), ["A", "B"]);
    expect_equal(ExtractAttributes(":a >= B", None), ["B"]);
    expect_equal(ExtractAttributes(":a = B", Some(attrMap)), ["B"]);
    expect_equal(ExtractAttributes("#one <> B", Some(attrMap)), ["two", "B"]);
    expect_equal(ExtractAttributes("A < #three", Some(attrMap)), ["A", "four"]);
    expect_equal(ExtractAttributes("#one < #three", Some(attrMap)), ["two", "four"]);
    expect_equal(ExtractAttributes("A in :a, :b, :c", Some(attrMap)), ["A"]);
    expect_equal(ExtractAttributes("A between B and C", Some(attrMap)), ["A", "B", "C"]);
    expect_equal(ExtractAttributes("not begins_with(A, :b)", Some(attrMap)), ["A"]);
    expect_equal(ExtractAttributes("A < B or C <> D", Some(attrMap)), ["A", "B", "C", "D"]);
    expect_equal(ExtractAttributes("contains(A, :b)", Some(attrMap)), ["A"]);
    expect_equal(ExtractAttributes("begins_with(A, :b)", Some(attrMap)), ["A"]);

    // we ignore these, because they can work on any attributes
    // that is, they ignore the underlying value
    expect_equal(ExtractAttributes("attribute_exists(A)", Some(attrMap)), []);
    expect_equal(ExtractAttributes("attribute_not_exists(A)", Some(attrMap)), []);
    expect_equal(ExtractAttributes("size(A)", Some(attrMap)), []);

    expect_equal(ExtractAttributes("A < B or size(C) or D between E and F",
      Some(attrMap)), ["A", "B", "D", "E", "F"]);
  }

  method {:test} TestNoBeacons() {
    var context := ExprContext (
      expr := Some("A < :A AND B = :B"),
      values:= Some(map[
        ":A" := DDB.AttributeValue.N("1.23"),
        ":B" := DDB.AttributeValue.S("abc")
      ]),
      names := None
    );
    var beaconVersion :- expect ConvertVersionWithKey(FullTableConfig, EmptyBeacons, [1,2,3,4,5]);
    var newContext :- expect Beaconize(beaconVersion, context);
    expect newContext == context;
  }

  method {:test} TestBasicParse() {
    var context := ExprContext (
      expr := Some("std2 < :A AND #Field4 = :B"),
      values:= Some(map[
        ":A" := DDB.AttributeValue.N("1.23"),
        ":B" := DDB.AttributeValue.S("abc")
      ]),
      names := Some(map[
        "#Field4" := "std4"
      ])
    );
    var beaconVersion :- expect ConvertVersionWithKey(FullTableConfig, EmptyBeacons, [1,2,3,4,5]);
    var parsed := ParseExpr(context.expr.value);
    expect |parsed| == 7;
    expect parsed[0].Attr?;
    expect parsed[0].s == "std2";
    expect beaconVersion.IsBeacon(parsed[0].s);
    expect OpNeedsBeacon(parsed, 0);
    expect beaconVersion.beacons[parsed[0].s].getBeaconName() == "aws_dbe_b_std2";

    var newContext :- expect BeaconizeParsedExpr(beaconVersion, parsed, 0, context.values.value, context.names);
    var exprString := ParsedExprToString(newContext.expr);
    expect exprString == "aws_dbe_b_std2 < :A AND #Field4 = :B";
  }
  method {:test} TestBasicBeacons() {
    var context := ExprContext (
      expr := Some("std2 < :A AND #Field4 = :B"),
      values:= Some(map[
        ":A" := Std2String,
        ":B" := Std4String
      ]),
      names := Some(map[
        "#Field4" := "std4"
      ])
    );
    var beaconVersion :- expect ConvertVersionWithKey(FullTableConfig, LotsaBeacons, [1,2,3,4,5]);
    var newContext :- expect Beaconize(beaconVersion, context);
    expect_equal(newContext.expr, Some("aws_dbe_b_std2 < :A AND #Field4 = :B"));
    var newName := "aws_dbe_b_std4";
    expect IsValid_AttributeName(newName);
    expect_equal(newContext.names, Some(map["#Field4" := newName]));
    var itemBeacons :- expect beaconVersion.GenerateBeacons(SimpleItem);
    expect "aws_dbe_b_std2" in itemBeacons;
    expect "aws_dbe_b_std4" in itemBeacons;
    expect_equal(newContext.values, Some(map[":A" := itemBeacons["aws_dbe_b_std2"], ":B" := itemBeacons["aws_dbe_b_std4"]]));
  }
}
