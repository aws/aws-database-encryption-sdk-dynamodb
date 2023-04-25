// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../../DynamoDbEncryption/src/NormalizeNumber.dfy"

module TestUpdateExpr {

  import opened DynamoDbNormalizeNumber

  method check_normal(input : string, expected : string)
  {
    var actualR := NormalizeNumber(input);
    if actualR.Failure? {
      print "\nUnexpected failure normalizing '" + input + "'\n";
    }
    expect actualR.Success?;
    var actual := actualR.value;
    if actual != expected {
      print "\n\nNormalizeNumber of '" + input + "' should have been '" + expected + "' but was '" + actual + "'\n\n";
    }
    expect actual == expected;
  }

  method {:test} TestExamples() {
    check_normal("0", "0");
    check_normal("", "0");
    check_normal(".", "0");
    check_normal("0.0", "0");
    check_normal(".0", "0");
    check_normal("e99", "0");
    check_normal("0e99", "0");
    check_normal(".0e99", "0");
    check_normal("0.0e99", "0");
    check_normal("e-99", "0");
    check_normal("0e-99", "0");
    check_normal(".0e-99", "0");
    check_normal("0.0e-99", "0");

    check_normal("12.34", "12.34");
    check_normal("00012.34", "12.34");
    check_normal("12.34000", "12.34");
    check_normal("012.340", "12.34");

    check_normal("123.456", "123.456");
    check_normal("123.456e0", "123.456");
    check_normal("123.456e1", "1234.56");
    check_normal("123.456e-1", "12.3456");
    check_normal("123.456e2", "12345.6");
    check_normal("123.456e-2", "1.23456");
    check_normal("123.456e3", "123456");
    check_normal("123.456e-3", "0.123456");
    check_normal("123.456e4", "1234560");
    check_normal("123.456e-4", "0.0123456");
    check_normal("123.456e5", "12345600");
    check_normal("123.456e-5", "0.00123456");

    check_normal("123", "123");
    check_normal("123e0", "123");
    check_normal("123e1", "1230");
    check_normal("123e2", "12300");
    check_normal("123e3", "123000");
    check_normal("123e-1", "12.3");
    check_normal("123e-2", "1.23");
    check_normal("123e-3", "0.123");
    check_normal("123e-4", "0.0123");

    check_normal(".123", "0.123");
    check_normal(".123e0", "0.123");
    check_normal(".123e1", "1.23");
    check_normal(".123e-1", "0.0123");
    check_normal(".123e2", "12.3");
    check_normal(".123e-2", "0.00123");
    check_normal(".123e3", "123");
    check_normal(".123e-3", "0.000123");

  }
}