// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../../src/DynamoDbEncryption/FilterExpr.dfy"

module TestDynamoDBFilterExpr {
  import opened ComAmazonawsDynamodbTypes
  import opened DynamoDBFilterExpr
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt

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
}
