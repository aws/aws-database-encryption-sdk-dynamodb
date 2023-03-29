// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../../src/DynamoDbEncryption/UpdateExpr.dfy"

module TestUpdateExpr {

  import opened DynamoDbUpdateExpr

  method expect_equal<T(==)>(a: T, b: T)
    ensures a == b
  {
    if a != b {
      print "Not equal: ", a, ", ", b, "\n";
    }
    expect a == b;
  }

  method {:test} TestExamples() {
    // examples from https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.UpdateExpressions.html
    expect_equal(ExtractAttrs( "SET ProductCategory = :c, Price = :p"), ["ProductCategory", "Price"]);
    expect_equal(ExtractAttrs( "SET RelatedItems[1] = :ri"), ["RelatedItems"]);
    expect_equal(ExtractAttrs( "SET #pr.#5star[1] = :r5, #pr.#3star = :r3"), ["#pr", "#pr"]);
    expect_equal(ExtractAttrs( "SET Price = Price - :p"), ["Price", "Price"]);
    expect_equal(ExtractAttrs("SET #ri = list_append(#ri, :vals)"), ["#ri", "#ri"]);
    expect_equal(ExtractAttrs("SET #ri = list_append(:vals, #ri)"), ["#ri", "#ri"]);
    expect_equal(ExtractAttrs("SET Price = if_not_exists(Price, :p)"), ["Price", "Price"]);
    expect_equal(ExtractAttrs("REMOVE Brand, InStock, QuantityOnHand"), ["Brand", "InStock", "QuantityOnHand"]);
    expect_equal(ExtractAttrs("REMOVE RelatedItems[1], RelatedItems[2]"), ["RelatedItems", "RelatedItems"]);
    expect_equal(ExtractAttrs("ADD QuantityOnHand :q"), ["QuantityOnHand"]);
    expect_equal(ExtractAttrs("DELETE Color :p"), ["Color"]);

    var m : ComAmazonawsDynamodbTypes.ExpressionAttributeNameMap := map["#pr" := "foo"];
    expect_equal(ExtractAttributes("SET #pr.#5star[1] = :r5, #pr.#3star = :r3", Wrappers.Some(m)), ["foo", "foo"]);
  }

}
