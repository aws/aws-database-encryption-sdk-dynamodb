// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../src/FilterExpr.dfy"
include "BeaconTestFixtures.dfy"
include "../src/ConfigToInfo.dfy"

module TestDynamoDBFilterExpr {
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import opened ComAmazonawsDynamodbTypes
  import opened DynamoDBFilterExpr
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened BeaconTestFixtures
  import opened SearchConfigToInfo
  import opened DynamoDbEncryptionUtil

  method expect_contains(haystack : AttributeValue, needle : AttributeValue, negate : bool)
  {
    var val := does_contain(haystack, needle);
    if val != negate {
      if negate {
        print haystack, " should not have contained ", needle, "but it did\n";
      }
      else {
        print haystack, " should have contained ", needle, "but it didn't\n";
      }
    }
    expect val == negate;
  }

  method {:test} UnicodeLessTest() {
    // A..F must be strictly increasing
    var A := "A";
    var B := "퀀"; // Ud000"
    var C := "﹌"; // Ufe4c"
    var D := "𐀁"; // U10001
    var E := "𐀂"; // U10002 - same high surrogate as D
    var F := "𠀂"; // U20002 - different high surrogate as D
    assert |A| == 1;
    assert |B| == 1;
    assert |C| == 1;
    assert |D| == 2;
    assert |E| == 2;
    assert |F| == 2;

    // strings in strs must be strictly increasing
    var strs := [A+B+C+D, B+C, C+D, D+C, D+C+B+A, E+D, F+D];

    for i := 0 to |strs| {
      for j := 0 to |strs| {
        expect ((i < j) == UnicodeLess(strs[i], strs[j]));
        expect ((i <= j) == !UnicodeLess(strs[j], strs[i]));
      }
    }
  }

  method {:test} LowLevelTests() {
    expect_equal(ParseExpr("and"), [And]);
    expect_equal(ParseExpr("  AnD   "), [And]);
    expect_equal(ParseExpr(" A  AnD  B "), [MakeAttr("A"), And, MakeAttr("B")]);
    expect_equal(ParseExpr(" A_B  AnD  B_C "), [MakeAttr("A_B"), And, MakeAttr("B_C")]);

    var input := [Not, MakeAttr("A"), In, Open, MakeAttr("B"), Comma, MakeAttr("C"), Close, Or];
    expect IsIN(input, 1);
    expect IsIN(input[1..], 0);
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
      None,
      Some("A < :A AND B = :B"),
      Some(map[
             ":A" := DDB.AttributeValue.N("1.23"),
             ":B" := DDB.AttributeValue.S("abc")
           ]),
      None
    );
    var version := GetEmptyBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var beaconVersion :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var newContext :- expect Beaconize(beaconVersion, context, DontUseKeyId);
    expect newContext == context;
  }

  method {:test} TestBasicParse() {
    var context := ExprContext (
      None,
      Some("std2 = :A AND #Field_4 = :B"),
      Some(map[
             ":A" := DDB.AttributeValue.N("1.23"),
             ":B" := DDB.AttributeValue.S("abc")
           ]),
      Some(map[
             "#Field_4" := "std4"
           ])
    );
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var beaconVersion :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var parsed := ParseExpr(context.filterExpr.value);
    expect |parsed| == 7;
    expect parsed[0].Attr?;
    expect parsed[0].s == "std2";
    expect beaconVersion.IsBeacon(parsed[0].s);
    expect OpNeedsBeacon(parsed, 0);
    expect beaconVersion.beacons[parsed[0].s].getBeaconName() == "aws_dbe_b_std2";

    var newContext :- expect BeaconizeParsedExpr(beaconVersion, parsed, 0, context.values.value, context.names, DontUseKeys, map[]);
    var exprString := ParsedExprToString(newContext.expr);
    expect exprString == "aws_dbe_b_std2 = :A AND #Field_4 = :B";
  }

  method {:test} TestNoBeaconFail() {
    var context := ExprContext (
      None,
      Some("std2 = :A AND #Field4 = :B"),
      Some(map[
             ":A" := DDB.AttributeValue.N("1.23"),
             ":B" := DDB.AttributeValue.S("abc")
           ]),
      Some(map[
             "#Field4" := "std4"
           ])
    );
    var version := GetEmptyBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var beaconVersion :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var parsed := ParseExpr(context.filterExpr.value);
    expect |parsed| == 7;
    expect parsed[0].Attr?;
    expect parsed[0].s == "std2";
    expect beaconVersion.IsBeacon(parsed[0].s);
    expect OpNeedsBeacon(parsed, 0);
    expect beaconVersion.beacons[parsed[0].s].getBeaconName() == "aws_dbe_b_std2";

    var newContext := BeaconizeParsedExpr(beaconVersion, parsed, 0, context.values.value, context.names, DontUseKeys, map[]);
    expect newContext.Failure?;
    expect newContext.error == E("Field std4 is encrypted, and cannot be searched without a beacon.");

    var badBeacon := TestBeaconize(FullTableConfig.attributeActionsOnEncrypt, None, Some("std2 <> :A AND #Field4 = :B"), None);
    expect badBeacon.Failure?;
    expect badBeacon.error == E("Query is using encrypted field : std2.");
    badBeacon := TestBeaconize(FullTableConfig.attributeActionsOnEncrypt, Some("std2 = :A AND #Field4 = :B"), None, None);
    expect badBeacon.Failure?;
    expect badBeacon.error == E("Query is using encrypted field : std2.");
  }

  method {:test} {:vcs_split_on_every_assert} TestBasicBeacons() {
    var context := ExprContext (
      None,
      Some("std2 = :A AND #Field4 = :B"),
      Some(map[
             ":A" := Std2String,
             ":B" := Std4String
           ]),
      Some(map[
             "#Field4" := "std4"
           ])
    );
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var beaconVersion :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var newContext :- expect Beaconize(beaconVersion, context, DontUseKeyId);
    expect_equal(newContext.filterExpr, Some("aws_dbe_b_std2 = :A AND #Field4 = :B"));
    var newName := "aws_dbe_b_std4";
    expect IsValid_AttributeName(newName);
    var expectedNames: DDB.ExpressionAttributeNameMap := map["#Field4" := newName];
    expect_equal(newContext.names, Some(expectedNames));
    var itemBeacons :- expect beaconVersion.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId);
    expect "aws_dbe_b_std2" in itemBeacons;
    expect "aws_dbe_b_std4" in itemBeacons;
    expect_equal(newContext.values, Some(map[":A" := itemBeacons["aws_dbe_b_std2"], ":B" := itemBeacons["aws_dbe_b_std4"]]));
  }

  //= specification/dynamodb-encryption-client/ddb-support.md#queryinputforbeacons
  //= type=test
  //# If a single value in ExpressionAttributeValues is used in more than one context,
  //# for example an expression of `this = :foo OR that = :foo` where `this` and `that`
  //# are both beacons, this operation MUST fail.
  method {:test} TestMultiContextFailures() {
    var context := ExprContext (
      None,
      Some("std2 = :A AND std4 = :A"),
      Some(map[
             ":A" := Std2String
           ]),
      None
    );
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var beaconVersion :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var newContext := Beaconize(beaconVersion, context, DontUseKeyId);
    expect newContext.Failure?;
    expect newContext.error == E(":A used in two different contexts, which is not allowed.");

    context := ExprContext (
      Some("std2 = :A AND std4 = :A"),
      None,
      Some(map[
             ":A" := Std2String
           ]),
      None
    );
    newContext := Beaconize(beaconVersion, context, DontUseKeyId);
    expect newContext.Failure?;
    expect newContext.error == E(":A used in two different contexts, which is not allowed.");

    context := ExprContext (
      Some("std2 = :A"),
      Some("std4 = :A"),
      Some(map[
             ":A" := Std2String
           ]),
      None
    );
    newContext := Beaconize(beaconVersion, context, DontUseKeyId);
    expect newContext.Failure?;
    expect newContext.error == E(":A used in two different contexts, which is not allowed.");
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
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var newItems :- expect FilterResults(bv, [item1], None, Some("one < two"), None, Some(values));
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("one > two"), None, Some(values));
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [item1], None, Some("one <= two"), None, Some(values));
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("one >= two"), None, Some(values));
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [item1], None, Some("one <> two"), None, Some(values));
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("one = two"), None, Some(values));
    expect_equal(newItems, []);

    newItems :- expect FilterResults(bv, [item1], None, Some("three < two"), None, None);
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [item1], None, Some("three > two"), None, None);
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [item1], None, Some("three <= two"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("three >= two"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("three <> two"), None, None);
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [item1], None, Some("three = two"), None, None);
    expect_equal(newItems, [item1]);
  }

  method {:test} TestFilterFailNumeric() {
    var item1  : DDB.AttributeMap := map[
      "one" := DN("800")
    ];
    var values : DDB.ExpressionAttributeValueMap := map [
      ":two" := DN("foo")
    ];
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var newItems := FilterResults(bv, [item1], None, Some("one < :two"), None, Some(values));
    expect newItems.Failure?;
    expect newItems.error == E("Number needs digits either before or after the decimal point. when parsing 'foo'.");
  }

  method {:test} TestFilterCompareNumeric() {
    var item1  : DDB.AttributeMap := map[
      "one" := DN("800")
    ];
    var values : DDB.ExpressionAttributeValueMap := map [
      ":two" := DN("0800.000e0")
    ];
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var newItems :- expect FilterResults(bv, [item1], None, Some("one < :two"), None, Some(values));
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [item1], None, Some("one > :two"), None, Some(values));
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [item1], None, Some("one <= :two"), None, Some(values));
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("one >= :two"), None, Some(values));
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("one <> :two"), None, Some(values));
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [item1], None, Some("one = :two"), None, Some(values));
    expect_equal(newItems, [item1]);

    newItems :- expect FilterResults(bv, [item1], None, Some(":two < one"), None, Some(values));
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [item1], None, Some(":two > one"), None, Some(values));
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [item1], None, Some(":two <= one"), None, Some(values));
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some(":two >= one"), None, Some(values));
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some(":two <> one"), None, Some(values));
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [item1], None, Some(":two = one"), None, Some(values));
    expect_equal(newItems, [item1]);
  }

  method {:test} TestFilterIn() {
    var item1  : DDB.AttributeMap := map[
      "one" := DS("abc"),
      "two" := DS("cde"),
      "three" := DS("cde")
    ];
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var newItems :- expect FilterResults(bv, [item1], None, Some("one in (two, three)"), None, None);
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [item1], None, Some("two in (one, three)"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("three in (two, one)"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("three in (one, one, one, one, two, one, one)"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("three in (one, one, one, one, one, one, one)"), None, None);
    expect_equal(newItems, []);
  }

  method {:test} TestFilterBetweenAlpha() {
    var item1  : DDB.AttributeMap := map[
      "one" := DS("abc"),
      "two" := DS("bcd"),
      "three" := DS("cde")
    ];
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var newItems :- expect FilterResults(bv, [item1], None, Some("one between two and three"), None, None);
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [item1], None, Some("two between one and three"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("two between three and one"), None, None);
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [item1], None, Some("two between two and three"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("two between one and two"), None, None);
    expect_equal(newItems, [item1]);
  }

  method {:test} TestFilterBetweenNumber() {
    var item1  : DDB.AttributeMap := map[
      "one" := DN("9"),
      "two" := DN("52"),
      "three" := DN("185")
    ];
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var newItems :- expect FilterResults(bv, [item1], None, Some("one between two and three"), None, None);
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [item1], None, Some("two between one and three"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("two between three and one"), None, None);
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [item1], None, Some("two between two and three"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("two between one and two"), None, None);
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

    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var newItems :- expect FilterResults(bv, [item1], None, Some("size(one) = :uno"), None, values);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("size(two) between :uno and :tres"), None, values);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("size(three) > :dos"), None, values);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("size(two) in (:uno, :dos)"), None, values);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("size(two) in (:uno, :tres)"), None, values);
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

    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var newItems :- expect FilterResults(bv, [item1], None, Some("contains(one, two)"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("contains(one, three)"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("contains(one, four)"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("contains(one, five)"), None, None);
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

    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var newItems :- expect FilterResults(bv, [item1], None, Some("begins_with(one, two)"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("begins_with(one, three)"), None, None);
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [item1], None, Some("begins_with(one, four)"), None, None);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("begins_with(one, five)"), None, None);
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

    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var newItems :- expect FilterResults(bv, [item1], None, Some("one < :four and two < :five"), None, values);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("one < :four or two > :five"), None, values);
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

    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var newItems :- expect FilterResults(bv, [item1], None, Some("one < two"), Some(names), Some(values));
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("one > two"), Some(names), Some(values));
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [item1], None, Some("#eine < #zwei"), Some(names), Some(values));
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("#eine > #zwei"), Some(names), Some(values));
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [item1], None, Some("#eine < :dos"), Some(names), Some(values));
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some("#eine > :dos"), Some(names), Some(values));
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

    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var newItems :- expect FilterResults(bv, [SimpleItem], None, Some("Date.Month < :uno"), Some(names), Some(values));
    expect_equal(newItems, [SimpleItem]);
    newItems :- expect FilterResults(bv, [SimpleItem], None, Some("Date.Month > :uno"), Some(names), Some(values));
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [SimpleItem], None, Some("Date.#zwei < :uno"), Some(names), Some(values));
    expect_equal(newItems, [SimpleItem]);
    newItems :- expect FilterResults(bv, [SimpleItem], None, Some("Date.#zwei > :uno"), Some(names), Some(values));
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

    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var newItems :- expect FilterResults(bv, [SimpleItem], None, Some("attribute_exists(Date)"), Some(names), Some(values));
    expect_equal(newItems, [SimpleItem]);
    newItems :- expect FilterResults(bv, [SimpleItem], None, Some("attribute_exists(Nope)"), Some(names), Some(values));
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [SimpleItem], None, Some("attribute_not_exists(Date)"), Some(names), Some(values));
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [SimpleItem], None, Some("attribute_not_exists(Nope)"), Some(names), Some(values));
    expect_equal(newItems, [SimpleItem]);
    newItems :- expect FilterResults(bv, [SimpleItem], None, Some("attribute_type(Date, :m)"), Some(names), Some(values));
    expect_equal(newItems, [SimpleItem]);
    newItems :- expect FilterResults(bv, [SimpleItem], None, Some("attribute_type(std2, :s)"), Some(names), Some(values));
    expect_equal(newItems, [SimpleItem]);
    newItems :- expect FilterResults(bv, [SimpleItem], None, Some("not attribute_exists(Date)"), Some(names), Some(values));
    expect_equal(newItems, []);
    newItems :- expect FilterResults(bv, [SimpleItem], None, Some("not attribute_exists(Nope)"), Some(names), Some(values));
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

    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var newItems :- expect FilterResults(bv, [item1], None, Some("size(one) in (:uno, :dos, :tres)"), None, values);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some(":uno in (size(one), :dos, :tres)"), None, values);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some(":uno in (:dos, :tres, size(one))"), None, values);
    expect_equal(newItems, [item1]);
    newItems :- expect FilterResults(bv, [item1], None, Some(":uno in (:dos, :tres)"), None, values);
    expect_equal(newItems, []);
  }

  method {:test} TestFilterBeacons() {

    var values : DDB.ExpressionAttributeValueMap := map [
      ":val2" := DN("1.23"),
      ":val3" := DS("N_MyName.T_MyTitle"),
      ":val4" := DS("T_MyTitle"),
      ":val5" := DS("MyName__mytitle")
    ];

    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var newItems :- expect FilterResults(bv, [SimpleItem], None, Some("std2 = :val2"), None, Some(values));
    expect |newItems| == 1;
    expect_equal(newItems, [SimpleItem]);
    newItems :- expect FilterResults(bv, [SimpleItem], None, Some("NameTitle = :val3"), None, Some(values));
    expect |newItems| == 1;
    expect_equal(newItems, [SimpleItem]);
    newItems :- expect FilterResults(bv, [SimpleItem], None, Some("contains(NameTitle, :val4)"), None, Some(values));
    expect |newItems| == 1;
    expect_equal(newItems, [SimpleItem]);
    newItems :- expect FilterResults(bv, [SimpleItem], None, Some("NameTitleField = :val5)"), None, Some(values));
    expect |newItems| == 1;
    expect_equal(newItems, [SimpleItem]);
  }

  method {:test} TestBadBetween() {

    var values : DDB.ExpressionAttributeValueMap := map [
      ":val3" := DS("T_ATitle"),
      ":val4" := DS("T_MyTitle")
    ];

    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var newItems := FilterResults(bv, [SimpleItem], None, Some("NameTitle between :val3 and :val4"), None, Some(values));
    expect newItems.Failure?;
    expect newItems.error == E("To use BETWEEN with a compound beacon, the part after any common prefix must be LessThanComparable : BETWEEN T_ATitle AND T_MyTitle");
  }

  method {:test} TestBadStandard() {

    var values : DDB.ExpressionAttributeValueMap := map [
      ":val" := DS("foo")
    ];

    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var newItems := FilterResults(bv, [SimpleItem], None, Some("std2 = :val"), None, Some(values));
    expect newItems.Success?;
    newItems := FilterResults(bv, [SimpleItem], None, Some("std2 <> :val"), None, Some(values));
    expect newItems.Failure?;
    expect newItems.error == E("The operation '<>' cannot be used with a standard beacon.");
    newItems := FilterResults(bv, [SimpleItem], None, Some("std2 < :val"), None, Some(values));
    expect newItems.Failure?;
    expect newItems.error == E("The operation '<' cannot be used with a standard beacon.");
    newItems := FilterResults(bv, [SimpleItem], None, Some("std2 > :val"), None, Some(values));
    expect newItems.Failure?;
    expect newItems.error == E("The operation '>' cannot be used with a standard beacon.");
    newItems := FilterResults(bv, [SimpleItem], None, Some("std2 <= :val"), None, Some(values));
    expect newItems.Failure?;
    expect newItems.error == E("The operation '<=' cannot be used with a standard beacon.");
    newItems := FilterResults(bv, [SimpleItem], None, Some("std2 >= :val"), None, Some(values));
    expect newItems.Failure?;
    expect newItems.error == E("The operation '>=' cannot be used with a standard beacon.");
  }

  method {:test} TestComparisons() {

    var values : DDB.ExpressionAttributeValueMap := map [
      ":val1" := DS("N_"),
      ":val2" := DS("N_MyName"),
      ":val3" := DS("N_MyName.T_"),
      ":val4" := DS("N_MyName.T_Title"),
      ":val5" := DS("T_"),
      ":val6" := DS("N_MyName.N_")
    ];

    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);

    var newItems := FilterResults(bv, [SimpleItem], None, Some("NameTitle between :val1 and :val5"), None, Some(values));
    expect newItems.Success?;
    newItems := FilterResults(bv, [SimpleItem], None, Some("NameTitle between :val3 and :val6"), None, Some(values));
    if newItems.Failure? {
      print "\n", newItems, "\n\n";
    }
    expect newItems.Success?;
    newItems := FilterResults(bv, [SimpleItem], None, Some("NameTitle between :val2 and :val3"), None, Some(values));
    expect newItems.Success?;

    newItems := FilterResults(bv, [SimpleItem], None, Some("NameTitle between :val1 and :val2"), None, Some(values));
    expect newItems.Failure?;
    newItems := FilterResults(bv, [SimpleItem], None, Some("NameTitle between :val1 and :val4"), None, Some(values));
    expect newItems.Failure?;

    newItems := FilterResults(bv, [SimpleItem], None, Some("NameTitle < :val1"), None, Some(values));
    expect newItems.Success?;
    newItems := FilterResults(bv, [SimpleItem], None, Some("NameTitle = :val1"), None, Some(values));
    expect newItems.Success?;
    newItems := FilterResults(bv, [SimpleItem], None, Some("NameTitle < :val2"), None, Some(values));
    expect newItems.Failure?;
    newItems := FilterResults(bv, [SimpleItem], None, Some("NameTitle = :val2"), None, Some(values));
    expect newItems.Success?;

    var newContext :- expect Beaconize(bv, ExprContext(None, Some("NameTitle = :val1"), Some(values), None), DontUseKeyId);
    expect newContext.values.Some?;
    expect ":val1" in newContext.values.value;
    expect newContext.values.value[":val1"] == DS("N_" + EmptyName_beacon);
    newContext :- expect Beaconize(bv, ExprContext(None, Some("NameTitle < :val1"), Some(values), None), DontUseKeyId);
    expect newContext.values.Some?;
    expect ":val1" in newContext.values.value;
    expect newContext.values.value[":val1"] == DS("N_");
  }

}
