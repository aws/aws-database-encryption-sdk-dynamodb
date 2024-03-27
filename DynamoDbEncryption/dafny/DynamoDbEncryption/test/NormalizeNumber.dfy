// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../../DynamoDbEncryption/src/NormalizeNumber.dfy"

module TestNormalizeNumber {

  import opened DynamoDbNormalizeNumber

  method check_normal(input : string, expected : string)
  {
    var actualR := NormalizeNumber(input);
    if actualR.Failure? {
      print "\nUnexpected failure normalizing '" + input + "'\n", actualR.error, "\n";
    }
    expect actualR.Success?;
    var actual := actualR.value;
    if actual != expected {
      print "\n\nNormalizeNumber of '" + input + "' should have been '" + expected + "' but was '" + actual + "'\n\n";
    }
    expect actual == expected;
  }

  method check_failure(input : string)
  {
    var actual := NormalizeNumber(input);
    if actual.Success? {
      print "Expected failure from '" + input + "' but it succeeded with '" + actual.value + "'.";
    }
    expect actual.Failure?;
  }

  method {:test} TestExtremes() {
    // Only 38 digits of precision are allowed, check that 38 is ok and 39 fails
    check_normal ("123456789.01234567890123456789012345678", "123456789.01234567890123456789012345678");
    check_failure("123456789.012345678901234567890123456789");
    check_normal ("1234567890123456789012345678901234567800000000000000000000000000000", "1234567890123456789012345678901234567800000000000000000000000000000");
    check_failure("1234567890123456789012345678901234567890000000000000000000000000000");
    check_normal (".000000000000000000000000012345678901234567890123456789012345678", "0.000000000000000000000000012345678901234567890123456789012345678");
    check_failure(".0000000000000000000000000123456789012345678901234567890123456789");

    // Check vaguely around the highest and lowest allowed exponent
    check_normal ("0000000000000000000000000012345.67e121", "123456700000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    check_normal ("12345.67e121", "123456700000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    check_failure("12345.67e122");
    check_failure("00000000000000000000000000012345.67e122");
    check_normal ("0.00000001e133", "100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    check_failure("0.00000001e134");
    check_normal ("0.00000001e-122", "0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001");
    check_failure("0.00000001e-123");
    check_normal ("1234567e-136", "0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001234567");
    check_failure("1234567e-137");

    // Bounds around highest positive number
    check_normal("9.9999999999999999999999999999999999999E+125", "999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    check_normal(".99999999999999999999999999999999999999E+126", "999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    check_normal("999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", "999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    check_failure("1E+126"); // we don't allow one magnitude higher
    check_failure("10E+125");
    check_normal("100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                 "100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    check_failure("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    check_failure("9.99999999999999999999999999999999999991E+125"); // we don't allow more precision
    check_failure("999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000001");

    // Bounds around smallest positive number
    check_normal("1E-130", "0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001");
    check_normal("10E-131", "0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001");
    check_normal("0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001", "0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001");
    check_failure("9.9999999999999999999999999999999999999E-131"); // We don't allow one magnitude smaller
    check_failure(".99999999999999999999999999999999999999E-130");
    check_failure("0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000099999999999999999999999999999999999999");
    // Bounds around the smallest negative number
    check_normal("-9.9999999999999999999999999999999999999E+125", "-999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    check_normal("-.99999999999999999999999999999999999999E+126", "-999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    check_normal("-999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", "-999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    check_failure("-1E+126"); // magnitude can't be higher
    check_failure("-10E+125");
    check_failure("-1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    check_failure("-999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"); // can't have more precision
    check_failure("-9.99999999999999999999999999999999999991E+125");

    // Bounds around the largest negative number
    check_normal("-1E-130", "-0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001");
    check_normal("-10E-131", "-0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001");
    check_normal("-0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001", "-0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001");
    check_failure("-9.9999999999999999999999999999999999999E-131"); // We don't allow one magnitude smaller
    check_failure("-.99999999999999999999999999999999999999E-130");
    check_failure("-0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000099999999999999999999999999999999999999");

  }

  method {:test} TestFailures() {
    check_failure("");
    check_failure(".");
    check_failure("+");
    check_failure("-");
    check_failure("e");
    check_failure("E");
    check_failure("1.2.3");
    check_failure("1.2e3e4");
    check_failure(".e4");
    check_failure("1.2e4.");
    check_failure("e99");
    check_failure("e-99");
    check_failure("1.2e--99");
    check_failure("1.2e+-99");
    check_failure("1.2e-+99");
    check_failure("--1.2");
    check_failure("++1.2");
    check_failure("+-1.2");
    check_failure("-+1.2");

    check_failure("1e");
    check_failure("1e-");
    check_failure("1e+");
    check_failure("1e1.1");
    check_failure("e0");
    check_failure("1a1");
    check_failure("1-1");
    check_failure("1+1");
    check_failure("1.-2");
    check_failure("1.+2");
  }

  method {:test} TestExamples() {
    check_normal("0", "0");
    check_normal("000", "0");
    check_normal(".000", "0");
    check_normal("0.", "0");
    check_normal("0.0", "0");
    check_normal("000.000", "0");
    check_normal(".0", "0");
    check_normal("0e99", "0");
    check_normal("0.e99", "0");
    check_normal(".0e99", "0");
    check_normal("0.0e99", "0");
    check_normal("0e-99", "0");
    check_normal(".0e-99", "0");
    check_normal("0.0e-99", "0");
    check_normal("0e0", "0");
    check_normal("0.0e0", "0");
    check_normal("0.e0", "0");
    check_normal(".0e0", "0");
    check_normal("0e-0", "0");
    check_normal("0.0e-0", "0");
    check_normal("0.e-0", "0");
    check_normal(".0e-0", "0");
    check_normal("0e999", "0");
    check_normal("0e-999", "0");

    check_normal("-0", "0");
    check_normal("-000", "0");
    check_normal("-.000", "0");
    check_normal("-0.", "0");
    check_normal("-0.0", "0");
    check_normal("-000.000", "0");
    check_normal("-.0", "0");
    check_normal("-0e99", "0");
    check_normal("-0.e99", "0");
    check_normal("-.0e99", "0");
    check_normal("-0.0e99", "0");
    check_normal("-0e-99", "0");
    check_normal("-.0e-99", "0");
    check_normal("-0.0e-99", "0");
    check_normal("-0e0", "0");
    check_normal("-0.0e0", "0");
    check_normal("-0.e0", "0");
    check_normal("-.0e0", "0");
    check_normal("-0e-0", "0");
    check_normal("-0.0e-0", "0");
    check_normal("-0.e-0", "0");
    check_normal("-.0e-0", "0");

    check_normal("+0", "0");
    check_normal("+0e+0", "0");
    check_normal("+0e0", "0");
    check_normal("0e+0", "0");
    check_normal("-0e+0", "0");
    check_normal("-0e0", "0");
    check_normal("1.2e2", "120");
    check_normal("+1.2e2", "120");
    check_normal("+1.2e+2", "120");
    check_normal("1.2e+2", "120");
    check_normal("-1.2e2", "-120");
    check_normal("-1.2e+2", "-120");
    check_normal("+123.456", "123.456");
    check_normal("-123.456", "-123.456");

    check_normal("12.34", "12.34");
    check_normal("00012.34", "12.34");
    check_normal("12.34000", "12.34");
    check_normal("012.340", "12.34");

    check_normal("123.456", "123.456");
    check_normal("123.456e0", "123.456");
    check_normal("123.456e-0", "123.456");
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
    check_normal("123e-0", "123");
    check_normal("123e1", "1230");
    check_normal("123e2", "12300");
    check_normal("123e3", "123000");
    check_normal("123e-1", "12.3");
    check_normal("123e-2", "1.23");
    check_normal("123e-3", "0.123");
    check_normal("123e-4", "0.0123");

    check_normal(".123", "0.123");
    check_normal(".123e0", "0.123");
    check_normal(".123e-0", "0.123");
    check_normal(".123e1", "1.23");
    check_normal(".123e-1", "0.0123");
    check_normal(".123e2", "12.3");
    check_normal(".123e-2", "0.00123");
    check_normal(".123e3", "123");
    check_normal(".123e-3", "0.000123");

    check_normal("123.", "123");
    check_normal("123.e0", "123");
    check_normal("123.e-0", "123");
    check_normal("123.e1", "1230");
    check_normal("123.e-1", "12.3");
    check_normal("123.e2", "12300");
    check_normal("123.e-2", "1.23");
    check_normal("123.e3", "123000");
    check_normal("123.e-3", "0.123");

    check_normal("0.123", "0.123");
    check_normal("0.123e0", "0.123");
    check_normal("0.123e-0", "0.123");
    check_normal("0.123e1", "1.23");
    check_normal("0.123e2", "12.3");
    check_normal("0.123e3", "123");
    check_normal("0.123e4", "1230");
    check_normal("0.123e-1", "0.0123");
    check_normal("0.123e-2", "0.00123");
    check_normal(".123", "0.123");
    check_normal(".123e0", "0.123");
    check_normal(".123e-0", "0.123");
    check_normal(".123e1", "1.23");
    check_normal(".123e2", "12.3");
    check_normal(".123e3", "123");
    check_normal(".123e4", "1230");
    check_normal(".123e-1", "0.0123");
    check_normal(".123e-2", "0.00123");


  }
}