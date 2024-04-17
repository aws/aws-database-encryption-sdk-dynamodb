// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../src/UpdateExpr.dfy"
include "../src/Virtual.dfy"

module TestDdbVirtualFields {

  import opened DdbVirtualFields
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import DDB = ComAmazonawsDynamodbTypes

  method {:test} TestUpper() {
    var t : VirtualTransform := upper(Upper());
    expect DoTransform(t, "") == "";
    expect DoTransform(t, "aBcDñÑeF") == "ABCDñÑEF";
  }
  method {:test} TestLower() {
    var t : VirtualTransform := lower(Lower());
    expect DoTransform(t, "") == "";
    expect DoTransform(t, "aBcDñÑeF") == "abcdñÑef";
  }
  method {:test} TestInsert() {
    var t : VirtualTransform := insert(Insert(literal := "_foo"));
    expect DoTransform(t, "") == "_foo";
    expect DoTransform(t, "aBcDñÑeF") == "aBcDñÑeF_foo";
  }
  method {:test} TestPrefix() {
    var p0 : VirtualTransform := prefix(GetPrefix(length := 0));
    var p3 : VirtualTransform := prefix(GetPrefix(length := 3));
    var pn3 : VirtualTransform := prefix(GetPrefix(length := -3));
    expect DoTransform(p0, "") == "";
    expect DoTransform(p3, "") == "";
    expect DoTransform(pn3, "") == "";
    expect DoTransform(p0, "a") == "";
    expect DoTransform(p3, "a") == "a";
    expect DoTransform(pn3, "a") == "";
    expect DoTransform(p0, "abc") == "";
    expect DoTransform(p3, "abc") == "abc";
    expect DoTransform(pn3, "abc") == "";
    expect DoTransform(p0, "aBcDñÑeF") == "";
    expect DoTransform(p3, "aBcDñÑeF") == "aBc";
    expect DoTransform(pn3, "aBcDñÑeF") == "aBcDñ";
  }
  method {:test} TestSuffix() {
    var p0 : VirtualTransform := suffix(GetSuffix(length := 0));
    var p3 : VirtualTransform := suffix(GetSuffix(length := 3));
    var pn3 : VirtualTransform := suffix(GetSuffix(length := -3));
    expect DoTransform(p0, "") == "";
    expect DoTransform(p3, "") == "";
    expect DoTransform(pn3, "") == "";
    expect DoTransform(p0, "a") == "";
    expect DoTransform(p3, "a") == "a";
    expect DoTransform(pn3, "a") == "";
    expect DoTransform(p0, "abc") == "";
    expect DoTransform(p3, "abc") == "abc";
    expect DoTransform(pn3, "abc") == "";
    expect DoTransform(p0, "aBcDñÑeF") == "";
    expect DoTransform(p3, "aBcDñÑeF") == "ÑeF";
    expect DoTransform(pn3, "aBcDñÑeF") == "DñÑeF";
  }
  method {:test} TestSubstring() {
    var p24 : VirtualTransform := substring(GetSubstring(low := 2, high := 4));
    var p42 : VirtualTransform := substring(GetSubstring(low := 4, high := 2));
    var p2n2 : VirtualTransform := substring(GetSubstring(low := 2, high := -2));
    var pn44 : VirtualTransform := substring(GetSubstring(low := -4, high := 4));
    var pn4n2 : VirtualTransform := substring(GetSubstring(low := -4, high := -2));

    expect DoTransform(p24, "abcdef") == "cd";
    expect DoTransform(p42, "abcdef") == "";
    expect DoTransform(p2n2, "abcdef") == "cd";
    expect DoTransform(pn44, "abcdef") == "cd";
    expect DoTransform(pn4n2, "abcdef") == "cd";
  }
  method {:test} TestSegment() {
    var p0 : VirtualTransform := segment(GetSegment(split := ".", index := 0));
    var p1 : VirtualTransform := segment(GetSegment(split := ".", index := 1));
    var p2 : VirtualTransform := segment(GetSegment(split := ".", index := 2));
    var p3 : VirtualTransform := segment(GetSegment(split := ".", index := 3));
    var p4 : VirtualTransform := segment(GetSegment(split := ".", index := 4));
    var p5 : VirtualTransform := segment(GetSegment(split := ".", index := 5));
    var pn1 : VirtualTransform := segment(GetSegment(split := ".", index := -1));
    var pn2 : VirtualTransform := segment(GetSegment(split := ".", index := -2));
    var pn3 : VirtualTransform := segment(GetSegment(split := ".", index := -3));
    var pn4 : VirtualTransform := segment(GetSegment(split := ".", index := -4));
    var pn5 : VirtualTransform := segment(GetSegment(split := ".", index := -5));
    var pn6 : VirtualTransform := segment(GetSegment(split := ".", index := -6));

    expect DoTransform(p0, "1.23.456.7890") == "1";
    expect DoTransform(p1, "1.23.456.7890") == "23";
    expect DoTransform(p2, "1.23.456.7890") == "456";
    expect DoTransform(p3, "1.23.456.7890") == "7890";
    expect DoTransform(p4, "1.23.456.7890") == "";
    expect DoTransform(p5, "1.23.456.7890") == "";
    expect DoTransform(pn1, "1.23.456.7890") == "7890";
    expect DoTransform(pn2, "1.23.456.7890") == "456";
    expect DoTransform(pn3, "1.23.456.7890") == "23";
    expect DoTransform(pn4, "1.23.456.7890") == "1";
    expect DoTransform(pn5, "1.23.456.7890") == "";
    expect DoTransform(pn6, "1.23.456.7890") == "";
  }
  method {:test} TestSegments() {
    var p00 : VirtualTransform := segments(GetSegments(split := ".", low := 0, high := 0));
    var p12 : VirtualTransform := segments(GetSegments(split := ".", low := 1, high := 2));
    var pn32 : VirtualTransform := segments(GetSegments(split := ".", low := -3, high := 2));
    var p13 : VirtualTransform := segments(GetSegments(split := ".", low := 1, high := 3));
    var p0n1 : VirtualTransform := segments(GetSegments(split := ".", low := 0, high := -1));

    expect DoTransform(p00, "1.23.456.7890") == "";
    expect DoTransform(p12, "1.23.456.7890") == "23";
    expect DoTransform(p13, "1.23.456.7890") == "23.456";
    expect DoTransform(pn32, "1.23.456.7890") == "23";
    expect DoTransform(p0n1, "1.23.456.7890") == "1.23.456";
  }
  method {:test} TestVirtualField() {
    var lowTrans : VirtualTransform := lower(Lower());
    var part1 := VirtualPart(loc := "foo", trans := None);
    var part2 := VirtualPart(loc := "bar", trans := Some([lowTrans]));
    var part3 := VirtualPart(loc := "baz[2].florn", trans := None);
    var virtualField :=  VirtualField(name := "myField", parts := [part1, part2, part3]);
    var virtField :- expect ParseVirtualFieldConfig(virtualField);
    var fooString := DDB.AttributeValue.N("1.23");
    var barString := DDB.AttributeValue.N("BarString");
    var flornString := DDB.AttributeValue.S("FlornString");
    var flornMap := DDB.AttributeValue.M(map["florn" := flornString]);
    var bazList := DDB.AttributeValue.L([fooString, barString, flornMap]);
    var item : DDB.AttributeMap := map["foo" := fooString, "bar" := barString, "baz" := bazList];
    var str :- expect GetVirtField(virtField, item);
    expect str == Some("1.23barstringFlornString");
  }
}
