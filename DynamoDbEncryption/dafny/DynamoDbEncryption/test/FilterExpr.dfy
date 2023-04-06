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
    expect_equal(ParseExpr(" A  AnD  B "), [MakeAttr("A"), And, MakeAttr("B")]);

    var input := [Not, MakeAttr("A"), In, Open, MakeAttr("B"), Comma, MakeAttr("C"), Close, Or];
    expect IsIN(input[1..]);
    expect_equal(ConvertToPrefix(input),  [Not, In, Open, MakeAttr("A"), Comma, MakeAttr("B"), Comma, MakeAttr("C"), Close, Or]);

    input := [And, Or, Not, And, Or, Not, And, Or, Not];
    expect_equal(ConvertToPrefix(input), input);

    input := [Not, MakeAttr("A"), In, Open, MakeAttr("B"), Comma, MakeAttr("C"), Close];
    expect_equal(ConvertToPrefix(input), [Not, In, Open, MakeAttr("A"), Comma, MakeAttr("B"), Comma, MakeAttr("C"), Close]);
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

  function method DS(x : string) : DDB.AttributeValue
  {
    DDB.AttributeValue.S(x)
  }
  function method DN(x : string) : DDB.AttributeValue
  {
    DDB.AttributeValue.N(x)
  }

  method {:test} TestFilterCompare() {
    var item1  : DDB.AttributeMap := map[
      "one" := DS("abc"),
      "two" := DS("cde"),
      "three" := DS("cde")
    ];
    var values : DDB.ExpressionAttributeValueMap := map [
    ];
    var newItems :- expect FilterResults([item1], None, Some("one < two"), None, Some(values));
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("one > two"), None, Some(values));
    expect_equal(newItems, []);
    newItems :- expect FilterResults([item1], None, Some("one <= two"), None, Some(values));
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("one >= two"), None, Some(values));
    expect_equal(newItems, []);
    newItems :- expect FilterResults([item1], None, Some("one <> two"), None, Some(values));
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("one = two"), None, Some(values));
    expect_equal(newItems, []);

    newItems :- expect FilterResults([item1], None, Some("three < two"), None, None);
    expect_equal(newItems, []);
    newItems :- expect FilterResults([item1], None, Some("three > two"), None, None);
    expect_equal(newItems, []);
    newItems :- expect FilterResults([item1], None, Some("three <= two"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("three >= two"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("three <> two"), None, None);
    expect_equal(newItems, []);
    newItems :- expect FilterResults([item1], None, Some("three = two"), None, None);
    expect_equal(newItems, [item1]);
  }

  method {:test} TestFilterIn() {
    var item1  : DDB.AttributeMap := map[
      "one" := DS("abc"),
      "two" := DS("cde"),
      "three" := DS("cde")
    ];
    var newItems :- expect FilterResults([item1], None, Some("one in (two, three)"), None, None);
    expect_equal(newItems, []);
    newItems :- expect FilterResults([item1], None, Some("two in (one, three)"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("three in (two, one)"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("three in (one, one, one, one, two, one, one)"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("three in (one, one, one, one, one, one, one)"), None, None);
    expect_equal(newItems, []);
  }

  method {:test} TestFilterBetweenAlpha() {
    var item1  : DDB.AttributeMap := map[
      "one" := DS("abc"),
      "two" := DS("bcd"),
      "three" := DS("cde")
    ];
    var newItems :- expect FilterResults([item1], None, Some("one between two and three"), None, None);
    expect_equal(newItems, []);
    newItems :- expect FilterResults([item1], None, Some("two between one and three"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("two between three and one"), None, None);
    expect_equal(newItems, []);
    newItems :- expect FilterResults([item1], None, Some("two between two and three"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("two between one and two"), None, None);
    expect_equal(newItems, [item1]);
  }

  method {:test} TestFilterBetweenNumber() {
    var item1  : DDB.AttributeMap := map[
      "one" := DN("9"),
      "two" := DN("52"),
      "three" := DN("185")
    ];
    var newItems :- expect FilterResults([item1], None, Some("one between two and three"), None, None);
    expect_equal(newItems, []);
    newItems :- expect FilterResults([item1], None, Some("two between one and three"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("two between three and one"), None, None);
    expect_equal(newItems, []);
    newItems :- expect FilterResults([item1], None, Some("two between two and three"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("two between one and two"), None, None);
    expect_equal(newItems, [item1]);
  }
  method {:test} TestFilterSize() {
    var item1  : DDB.AttributeMap := map[
      "one" := DN("9"),
      "two" := DN("52"),
      "three" := DN("185")
    ];
    var values : Option<DDB.ExpressionAttributeValueMap> := Some(map [
      ":uno" := DN("1"),
      ":dos" := DN("2"),
      ":tres" := DN("3")
    ]);

    var newItems :- expect FilterResults([item1], None, Some("size(one) = :uno"), None, values);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("size(two) between :uno and :tres"), None, values);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("size(three) > :dos"), None, values);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("size(two) in (:uno, :dos)"), None, values);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("size(two) in (:uno, :tres)"), None, values);
    expect_equal(newItems, []);
  }
  method {:test} TestFilterContains() {
    var item1  : DDB.AttributeMap := map[
      "one" := DN("abcdef"),
      "two" := DN("a"),
      "three" := DN("f"),
      "four" := DN("cde"),
      "five" := DN("efg")
    ];

    var newItems :- expect FilterResults([item1], None, Some("contains(one, two)"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("contains(one, three)"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("contains(one, four)"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("contains(one, five)"), None, None);
    expect_equal(newItems, []);
  }

  method {:test} TestFilterBegins() {
    var item1  : DDB.AttributeMap := map[
      "one" := DN("abcdef"),
      "two" := DN("a"),
      "three" := DN("f"),
      "four" := DN("abcd"),
      "five" := DN("abcdf")
    ];

    var newItems :- expect FilterResults([item1], None, Some("begins_with(one, two)"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("begins_with(one, three)"), None, None);
    expect_equal(newItems, []);
    newItems :- expect FilterResults([item1], None, Some("begins_with(one, four)"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("begins_with(one, five)"), None, None);
    expect_equal(newItems, []);
  }
    method {:test} TestFilterComplex() {
    var item1  : DDB.AttributeMap := map[
      "one" := DN("1"),
      "two" := DN("2"),
      "three" := DN("3")
    ];
    var values : Option<DDB.ExpressionAttributeValueMap> := Some(map [
      ":four" := DN("4"),
      ":five" := DN("5"),
      ":six" := DN("6")
    ]);

    var newItems :- expect FilterResults([item1], None, Some("one < :four and two < :five"), None, values);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("one < :four or two > :five"), None, values);
    expect_equal(newItems, [item1]);

  }

  method {:test} TestFilterIndirectNames() {
    var item1  : DDB.AttributeMap := map[
      "one" := DS("abc"),
      "two" := DS("cde"),
      "three" := DS("cde")
    ];
    var values : DDB.ExpressionAttributeValueMap := map [
      ":uno" := DS("ab"),
      ":dos" := DS("bc")
    ];
    var names : DDB.ExpressionAttributeNameMap := map [
      "#eine" := "one",
      "#zwei" := "two",
      "#drei" := "three"
    ];

    var newItems :- expect FilterResults([item1], None, Some("one < two"), Some(names), Some(values));
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("one > two"), Some(names), Some(values));
    expect_equal(newItems, []);
    newItems :- expect FilterResults([item1], None, Some("#eine < #zwei"), Some(names), Some(values));
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("#eine > #zwei"), Some(names), Some(values));
    expect_equal(newItems, []);
    newItems :- expect FilterResults([item1], None, Some("#eine < :dos"), Some(names), Some(values));
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some("#eine > :dos"), Some(names), Some(values));
    expect_equal(newItems, []);

  }


  method {:test} TestFilterIndirectNamesWithLoc() {
    var values : DDB.ExpressionAttributeValueMap := map [
      ":uno" := DS("ab"),
      ":dos" := DN("2")
    ];
    var names : DDB.ExpressionAttributeNameMap := map [
      "#eine" := "Date",
      "#zwei" := "Month",
      "#drei" := "Year"
    ];

    var newItems :- expect FilterResults([SimpleItem], None, Some("Date.Month < :uno"), Some(names), Some(values));
    expect_equal(newItems, [SimpleItem]);
    newItems :- expect FilterResults([SimpleItem], None, Some("Date.Month > :uno"), Some(names), Some(values));
    expect_equal(newItems, []);
    newItems :- expect FilterResults([SimpleItem], None, Some("Date.#zwei < :uno"), Some(names), Some(values));
    expect_equal(newItems, [SimpleItem]);
    newItems :- expect FilterResults([SimpleItem], None, Some("Date.#zwei > :uno"), Some(names), Some(values));
    expect_equal(newItems, []);
  }

  method {:test} TestFilterAttrOps() {
    var names : DDB.ExpressionAttributeNameMap := map [
      "#fecha" := "Date"
    ];
    var values : DDB.ExpressionAttributeValueMap := map [
      ":m" := DS("M"),
      ":s" := DS("N")
    ];

    var newItems :- expect FilterResults([SimpleItem], None, Some("attribute_exists(Date)"), Some(names), Some(values));
    expect_equal(newItems, [SimpleItem]);
    newItems :- expect FilterResults([SimpleItem], None, Some("attribute_exists(Nope)"), Some(names), Some(values));
    expect_equal(newItems, []);
    newItems :- expect FilterResults([SimpleItem], None, Some("attribute_not_exists(Date)"), Some(names), Some(values));
    expect_equal(newItems, []);
    newItems :- expect FilterResults([SimpleItem], None, Some("attribute_not_exists(Nope)"), Some(names), Some(values));
    expect_equal(newItems, [SimpleItem]);
    newItems :- expect FilterResults([SimpleItem], None, Some("attribute_type(Date, :m)"), Some(names), Some(values));
    expect_equal(newItems, [SimpleItem]);
    newItems :- expect FilterResults([SimpleItem], None, Some("attribute_type(std2, :s)"), Some(names), Some(values));
    expect_equal(newItems, [SimpleItem]);
    newItems :- expect FilterResults([SimpleItem], None, Some("not attribute_exists(Date)"), Some(names), Some(values));
    expect_equal(newItems, []);
    newItems :- expect FilterResults([SimpleItem], None, Some("not attribute_exists(Nope)"), Some(names), Some(values));
    expect_equal(newItems, [SimpleItem]);  
  }
  method {:test} TestFilterSizeIn() {
    var item1  : DDB.AttributeMap := map[
      "one" := DN("9"),
      "two" := DN("52"),
      "three" := DN("185")
    ];
    var values : Option<DDB.ExpressionAttributeValueMap> := Some(map [
      ":uno" := DN("1"),
      ":dos" := DN("2"),
      ":tres" := DN("3")
    ]);

    var newItems :- expect FilterResults([item1], None, Some("size(one) in (:uno, :dos, :tres)"), None, values);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some(":uno in (size(one), :dos, :tres)"), None, values);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some(":uno in (:dos, :tres, size(one))"), None, values);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults([item1], None, Some(":uno in (:dos, :tres)"), None, values);
    expect_equal(newItems, []);
  }
}
