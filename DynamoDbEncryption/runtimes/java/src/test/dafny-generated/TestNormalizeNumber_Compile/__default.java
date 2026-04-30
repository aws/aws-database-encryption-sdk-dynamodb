// Class __default
// Dafny class __default compiled into Java
package TestNormalizeNumber_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static void check__normal(dafny.DafnySequence<? extends Character> input, dafny.DafnySequence<? extends Character> expected)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _0_actualR;
    _0_actualR = DynamoDbNormalizeNumber_Compile.__default.NormalizeNumber(input);
    if ((_0_actualR).is_Failure()) {
      System.out.print((dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("\nUnexpected failure normalizing '"), input), dafny.DafnySequence.asString("'\n"))).verbatimString());
      System.out.print(((_0_actualR).dtor_error()).verbatimString());
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
    }
    if (!((_0_actualR).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/NormalizeNumber.dfy(16,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    dafny.DafnySequence<? extends Character> _1_actual;
    _1_actual = (_0_actualR).dtor_value();
    if (!(_1_actual).equals(expected)) {
      System.out.print((dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("\n\nNormalizeNumber of '"), input), dafny.DafnySequence.asString("' should have been '")), expected), dafny.DafnySequence.asString("' but was '")), _1_actual), dafny.DafnySequence.asString("'\n\n"))).verbatimString());
    }
    if (!((_1_actual).equals(expected))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/NormalizeNumber.dfy(21,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void check__failure(dafny.DafnySequence<? extends Character> input)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _0_actual;
    _0_actual = DynamoDbNormalizeNumber_Compile.__default.NormalizeNumber(input);
    if ((_0_actual).is_Success()) {
      System.out.print((dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Expected failure from '"), input), dafny.DafnySequence.asString("' but it succeeded with '")), (_0_actual).dtor_value()), dafny.DafnySequence.asString("'."))).verbatimString());
    }
    if (!((_0_actual).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/NormalizeNumber.dfy(30,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestExtremes()
  {
    __default.check__normal(dafny.DafnySequence.asString("123456789.01234567890123456789012345678"), dafny.DafnySequence.asString("123456789.01234567890123456789012345678"));
    __default.check__failure(dafny.DafnySequence.asString("123456789.012345678901234567890123456789"));
    __default.check__normal(dafny.DafnySequence.asString("1234567890123456789012345678901234567800000000000000000000000000000"), dafny.DafnySequence.asString("1234567890123456789012345678901234567800000000000000000000000000000"));
    __default.check__failure(dafny.DafnySequence.asString("1234567890123456789012345678901234567890000000000000000000000000000"));
    __default.check__normal(dafny.DafnySequence.asString(".000000000000000000000000012345678901234567890123456789012345678"), dafny.DafnySequence.asString("0.000000000000000000000000012345678901234567890123456789012345678"));
    __default.check__failure(dafny.DafnySequence.asString(".0000000000000000000000000123456789012345678901234567890123456789"));
    __default.check__normal(dafny.DafnySequence.asString("0000000000000000000000000012345.67e121"), dafny.DafnySequence.asString("123456700000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    __default.check__normal(dafny.DafnySequence.asString("12345.67e121"), dafny.DafnySequence.asString("123456700000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    __default.check__failure(dafny.DafnySequence.asString("12345.67e122"));
    __default.check__failure(dafny.DafnySequence.asString("00000000000000000000000000012345.67e122"));
    __default.check__normal(dafny.DafnySequence.asString("0.00000001e133"), dafny.DafnySequence.asString("100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    __default.check__failure(dafny.DafnySequence.asString("0.00000001e134"));
    __default.check__normal(dafny.DafnySequence.asString("0.00000001e-122"), dafny.DafnySequence.asString("0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"));
    __default.check__failure(dafny.DafnySequence.asString("0.00000001e-123"));
    __default.check__normal(dafny.DafnySequence.asString("1234567e-136"), dafny.DafnySequence.asString("0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001234567"));
    __default.check__failure(dafny.DafnySequence.asString("1234567e-137"));
    __default.check__normal(dafny.DafnySequence.asString("9.9999999999999999999999999999999999999E+125"), dafny.DafnySequence.asString("999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    __default.check__normal(dafny.DafnySequence.asString(".99999999999999999999999999999999999999E+126"), dafny.DafnySequence.asString("999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    __default.check__normal(dafny.DafnySequence.asString("999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"), dafny.DafnySequence.asString("999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    __default.check__failure(dafny.DafnySequence.asString("1E+126"));
    __default.check__failure(dafny.DafnySequence.asString("10E+125"));
    __default.check__normal(dafny.DafnySequence.asString("100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"), dafny.DafnySequence.asString("100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    __default.check__failure(dafny.DafnySequence.asString("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    __default.check__failure(dafny.DafnySequence.asString("9.99999999999999999999999999999999999991E+125"));
    __default.check__failure(dafny.DafnySequence.asString("999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"));
    __default.check__normal(dafny.DafnySequence.asString("1E-130"), dafny.DafnySequence.asString("0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"));
    __default.check__normal(dafny.DafnySequence.asString("10E-131"), dafny.DafnySequence.asString("0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"));
    __default.check__normal(dafny.DafnySequence.asString("0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"), dafny.DafnySequence.asString("0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"));
    __default.check__failure(dafny.DafnySequence.asString("9.9999999999999999999999999999999999999E-131"));
    __default.check__failure(dafny.DafnySequence.asString(".99999999999999999999999999999999999999E-130"));
    __default.check__failure(dafny.DafnySequence.asString("0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000099999999999999999999999999999999999999"));
    __default.check__normal(dafny.DafnySequence.asString("-9.9999999999999999999999999999999999999E+125"), dafny.DafnySequence.asString("-999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    __default.check__normal(dafny.DafnySequence.asString("-.99999999999999999999999999999999999999E+126"), dafny.DafnySequence.asString("-999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    __default.check__normal(dafny.DafnySequence.asString("-999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"), dafny.DafnySequence.asString("-999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    __default.check__failure(dafny.DafnySequence.asString("-1E+126"));
    __default.check__failure(dafny.DafnySequence.asString("-10E+125"));
    __default.check__failure(dafny.DafnySequence.asString("-1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    __default.check__failure(dafny.DafnySequence.asString("-999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"));
    __default.check__failure(dafny.DafnySequence.asString("-9.99999999999999999999999999999999999991E+125"));
    __default.check__normal(dafny.DafnySequence.asString("-1E-130"), dafny.DafnySequence.asString("-0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"));
    __default.check__normal(dafny.DafnySequence.asString("-10E-131"), dafny.DafnySequence.asString("-0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"));
    __default.check__normal(dafny.DafnySequence.asString("-0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"), dafny.DafnySequence.asString("-0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"));
    __default.check__failure(dafny.DafnySequence.asString("-9.9999999999999999999999999999999999999E-131"));
    __default.check__failure(dafny.DafnySequence.asString("-.99999999999999999999999999999999999999E-130"));
    __default.check__failure(dafny.DafnySequence.asString("-0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000099999999999999999999999999999999999999"));
  }
  public static void TestFailures()
  {
    __default.check__failure(dafny.DafnySequence.asString(""));
    __default.check__failure(dafny.DafnySequence.asString("."));
    __default.check__failure(dafny.DafnySequence.asString("+"));
    __default.check__failure(dafny.DafnySequence.asString("-"));
    __default.check__failure(dafny.DafnySequence.asString("e"));
    __default.check__failure(dafny.DafnySequence.asString("E"));
    __default.check__failure(dafny.DafnySequence.asString("1.2.3"));
    __default.check__failure(dafny.DafnySequence.asString("1.2e3e4"));
    __default.check__failure(dafny.DafnySequence.asString(".e4"));
    __default.check__failure(dafny.DafnySequence.asString("1.2e4."));
    __default.check__failure(dafny.DafnySequence.asString("e99"));
    __default.check__failure(dafny.DafnySequence.asString("e-99"));
    __default.check__failure(dafny.DafnySequence.asString("1.2e--99"));
    __default.check__failure(dafny.DafnySequence.asString("1.2e+-99"));
    __default.check__failure(dafny.DafnySequence.asString("1.2e-+99"));
    __default.check__failure(dafny.DafnySequence.asString("--1.2"));
    __default.check__failure(dafny.DafnySequence.asString("++1.2"));
    __default.check__failure(dafny.DafnySequence.asString("+-1.2"));
    __default.check__failure(dafny.DafnySequence.asString("-+1.2"));
    __default.check__failure(dafny.DafnySequence.asString("1e"));
    __default.check__failure(dafny.DafnySequence.asString("1e-"));
    __default.check__failure(dafny.DafnySequence.asString("1e+"));
    __default.check__failure(dafny.DafnySequence.asString("1e1.1"));
    __default.check__failure(dafny.DafnySequence.asString("e0"));
    __default.check__failure(dafny.DafnySequence.asString("1a1"));
    __default.check__failure(dafny.DafnySequence.asString("1-1"));
    __default.check__failure(dafny.DafnySequence.asString("1+1"));
    __default.check__failure(dafny.DafnySequence.asString("1.-2"));
    __default.check__failure(dafny.DafnySequence.asString("1.+2"));
  }
  public static void TestExamples()
  {
    __default.check__normal(dafny.DafnySequence.asString("0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("000"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString(".000"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("0."), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("0.0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("000.000"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString(".0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("0e99"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("0.e99"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString(".0e99"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("0.0e99"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("0e-99"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString(".0e-99"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("0.0e-99"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("0e0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("0.0e0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("0.e0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString(".0e0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("0e-0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("0.0e-0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("0.e-0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString(".0e-0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("0e999"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("0e-999"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-000"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-.000"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-0."), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-0.0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-000.000"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-.0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-0e99"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-0.e99"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-.0e99"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-0.0e99"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-0e-99"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-.0e-99"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-0.0e-99"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-0e0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-0.0e0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-0.e0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-.0e0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-0e-0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-0.0e-0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-0.e-0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-.0e-0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("+0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("+0e+0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("+0e0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("0e+0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-0e+0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("-0e0"), dafny.DafnySequence.asString("0"));
    __default.check__normal(dafny.DafnySequence.asString("1.2e2"), dafny.DafnySequence.asString("120"));
    __default.check__normal(dafny.DafnySequence.asString("+1.2e2"), dafny.DafnySequence.asString("120"));
    __default.check__normal(dafny.DafnySequence.asString("+1.2e+2"), dafny.DafnySequence.asString("120"));
    __default.check__normal(dafny.DafnySequence.asString("1.2e+2"), dafny.DafnySequence.asString("120"));
    __default.check__normal(dafny.DafnySequence.asString("-1.2e2"), dafny.DafnySequence.asString("-120"));
    __default.check__normal(dafny.DafnySequence.asString("-1.2e+2"), dafny.DafnySequence.asString("-120"));
    __default.check__normal(dafny.DafnySequence.asString("+123.456"), dafny.DafnySequence.asString("123.456"));
    __default.check__normal(dafny.DafnySequence.asString("-123.456"), dafny.DafnySequence.asString("-123.456"));
    __default.check__normal(dafny.DafnySequence.asString("12.34"), dafny.DafnySequence.asString("12.34"));
    __default.check__normal(dafny.DafnySequence.asString("00012.34"), dafny.DafnySequence.asString("12.34"));
    __default.check__normal(dafny.DafnySequence.asString("12.34000"), dafny.DafnySequence.asString("12.34"));
    __default.check__normal(dafny.DafnySequence.asString("012.340"), dafny.DafnySequence.asString("12.34"));
    __default.check__normal(dafny.DafnySequence.asString("123.456"), dafny.DafnySequence.asString("123.456"));
    __default.check__normal(dafny.DafnySequence.asString("123.456e0"), dafny.DafnySequence.asString("123.456"));
    __default.check__normal(dafny.DafnySequence.asString("123.456e-0"), dafny.DafnySequence.asString("123.456"));
    __default.check__normal(dafny.DafnySequence.asString("123.456e1"), dafny.DafnySequence.asString("1234.56"));
    __default.check__normal(dafny.DafnySequence.asString("123.456e-1"), dafny.DafnySequence.asString("12.3456"));
    __default.check__normal(dafny.DafnySequence.asString("123.456e2"), dafny.DafnySequence.asString("12345.6"));
    __default.check__normal(dafny.DafnySequence.asString("123.456e-2"), dafny.DafnySequence.asString("1.23456"));
    __default.check__normal(dafny.DafnySequence.asString("123.456e3"), dafny.DafnySequence.asString("123456"));
    __default.check__normal(dafny.DafnySequence.asString("123.456e-3"), dafny.DafnySequence.asString("0.123456"));
    __default.check__normal(dafny.DafnySequence.asString("123.456e4"), dafny.DafnySequence.asString("1234560"));
    __default.check__normal(dafny.DafnySequence.asString("123.456e-4"), dafny.DafnySequence.asString("0.0123456"));
    __default.check__normal(dafny.DafnySequence.asString("123.456e5"), dafny.DafnySequence.asString("12345600"));
    __default.check__normal(dafny.DafnySequence.asString("123.456e-5"), dafny.DafnySequence.asString("0.00123456"));
    __default.check__normal(dafny.DafnySequence.asString("123"), dafny.DafnySequence.asString("123"));
    __default.check__normal(dafny.DafnySequence.asString("123e0"), dafny.DafnySequence.asString("123"));
    __default.check__normal(dafny.DafnySequence.asString("123e-0"), dafny.DafnySequence.asString("123"));
    __default.check__normal(dafny.DafnySequence.asString("123e1"), dafny.DafnySequence.asString("1230"));
    __default.check__normal(dafny.DafnySequence.asString("123e2"), dafny.DafnySequence.asString("12300"));
    __default.check__normal(dafny.DafnySequence.asString("123e3"), dafny.DafnySequence.asString("123000"));
    __default.check__normal(dafny.DafnySequence.asString("123e-1"), dafny.DafnySequence.asString("12.3"));
    __default.check__normal(dafny.DafnySequence.asString("123e-2"), dafny.DafnySequence.asString("1.23"));
    __default.check__normal(dafny.DafnySequence.asString("123e-3"), dafny.DafnySequence.asString("0.123"));
    __default.check__normal(dafny.DafnySequence.asString("123e-4"), dafny.DafnySequence.asString("0.0123"));
    __default.check__normal(dafny.DafnySequence.asString(".123"), dafny.DafnySequence.asString("0.123"));
    __default.check__normal(dafny.DafnySequence.asString(".123e0"), dafny.DafnySequence.asString("0.123"));
    __default.check__normal(dafny.DafnySequence.asString(".123e-0"), dafny.DafnySequence.asString("0.123"));
    __default.check__normal(dafny.DafnySequence.asString(".123e1"), dafny.DafnySequence.asString("1.23"));
    __default.check__normal(dafny.DafnySequence.asString(".123e-1"), dafny.DafnySequence.asString("0.0123"));
    __default.check__normal(dafny.DafnySequence.asString(".123e2"), dafny.DafnySequence.asString("12.3"));
    __default.check__normal(dafny.DafnySequence.asString(".123e-2"), dafny.DafnySequence.asString("0.00123"));
    __default.check__normal(dafny.DafnySequence.asString(".123e3"), dafny.DafnySequence.asString("123"));
    __default.check__normal(dafny.DafnySequence.asString(".123e-3"), dafny.DafnySequence.asString("0.000123"));
    __default.check__normal(dafny.DafnySequence.asString("123."), dafny.DafnySequence.asString("123"));
    __default.check__normal(dafny.DafnySequence.asString("123.e0"), dafny.DafnySequence.asString("123"));
    __default.check__normal(dafny.DafnySequence.asString("123.e-0"), dafny.DafnySequence.asString("123"));
    __default.check__normal(dafny.DafnySequence.asString("123.e1"), dafny.DafnySequence.asString("1230"));
    __default.check__normal(dafny.DafnySequence.asString("123.e-1"), dafny.DafnySequence.asString("12.3"));
    __default.check__normal(dafny.DafnySequence.asString("123.e2"), dafny.DafnySequence.asString("12300"));
    __default.check__normal(dafny.DafnySequence.asString("123.e-2"), dafny.DafnySequence.asString("1.23"));
    __default.check__normal(dafny.DafnySequence.asString("123.e3"), dafny.DafnySequence.asString("123000"));
    __default.check__normal(dafny.DafnySequence.asString("123.e-3"), dafny.DafnySequence.asString("0.123"));
    __default.check__normal(dafny.DafnySequence.asString("0.123"), dafny.DafnySequence.asString("0.123"));
    __default.check__normal(dafny.DafnySequence.asString("0.123e0"), dafny.DafnySequence.asString("0.123"));
    __default.check__normal(dafny.DafnySequence.asString("0.123e-0"), dafny.DafnySequence.asString("0.123"));
    __default.check__normal(dafny.DafnySequence.asString("0.123e1"), dafny.DafnySequence.asString("1.23"));
    __default.check__normal(dafny.DafnySequence.asString("0.123e2"), dafny.DafnySequence.asString("12.3"));
    __default.check__normal(dafny.DafnySequence.asString("0.123e3"), dafny.DafnySequence.asString("123"));
    __default.check__normal(dafny.DafnySequence.asString("0.123e4"), dafny.DafnySequence.asString("1230"));
    __default.check__normal(dafny.DafnySequence.asString("0.123e-1"), dafny.DafnySequence.asString("0.0123"));
    __default.check__normal(dafny.DafnySequence.asString("0.123e-2"), dafny.DafnySequence.asString("0.00123"));
    __default.check__normal(dafny.DafnySequence.asString(".123"), dafny.DafnySequence.asString("0.123"));
    __default.check__normal(dafny.DafnySequence.asString(".123e0"), dafny.DafnySequence.asString("0.123"));
    __default.check__normal(dafny.DafnySequence.asString(".123e-0"), dafny.DafnySequence.asString("0.123"));
    __default.check__normal(dafny.DafnySequence.asString(".123e1"), dafny.DafnySequence.asString("1.23"));
    __default.check__normal(dafny.DafnySequence.asString(".123e2"), dafny.DafnySequence.asString("12.3"));
    __default.check__normal(dafny.DafnySequence.asString(".123e3"), dafny.DafnySequence.asString("123"));
    __default.check__normal(dafny.DafnySequence.asString(".123e4"), dafny.DafnySequence.asString("1230"));
    __default.check__normal(dafny.DafnySequence.asString(".123e-1"), dafny.DafnySequence.asString("0.0123"));
    __default.check__normal(dafny.DafnySequence.asString(".123e-2"), dafny.DafnySequence.asString("0.00123"));
  }
  @Override
  public java.lang.String toString() {
    return "TestNormalizeNumber._default";
  }
}
