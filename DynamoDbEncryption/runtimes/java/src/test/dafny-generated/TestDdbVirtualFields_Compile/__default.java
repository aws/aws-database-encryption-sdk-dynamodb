// Class __default
// Dafny class __default compiled into Java
package TestDdbVirtualFields_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static void TestUpper()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _0_t;
    _0_t = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_upper(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Upper.create());
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_0_t, dafny.DafnySequence.asString(""))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(18,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_0_t, dafny.DafnySequence.asString("aBcDñÑeF"))).equals(dafny.DafnySequence.asString("ABCDñÑEF")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(19,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestLower()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _0_t;
    _0_t = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_lower(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Lower.create());
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_0_t, dafny.DafnySequence.asString(""))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(23,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_0_t, dafny.DafnySequence.asString("aBcDñÑeF"))).equals(dafny.DafnySequence.asString("abcdñÑef")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(24,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestInsert()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _0_t;
    _0_t = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_insert(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Insert.create(dafny.DafnySequence.asString("_foo")));
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_0_t, dafny.DafnySequence.asString(""))).equals(dafny.DafnySequence.asString("_foo")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(28,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_0_t, dafny.DafnySequence.asString("aBcDñÑeF"))).equals(dafny.DafnySequence.asString("aBcDñÑeF_foo")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(29,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestPrefix()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _0_p0;
    _0_p0 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_prefix(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetPrefix.create(0));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _1_p3;
    _1_p3 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_prefix(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetPrefix.create(3));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _2_pn3;
    _2_pn3 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_prefix(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetPrefix.create(-3));
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_0_p0, dafny.DafnySequence.asString(""))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(35,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_1_p3, dafny.DafnySequence.asString(""))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(36,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_2_pn3, dafny.DafnySequence.asString(""))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(37,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_0_p0, dafny.DafnySequence.asString("a"))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(38,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_1_p3, dafny.DafnySequence.asString("a"))).equals(dafny.DafnySequence.asString("a")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(39,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_2_pn3, dafny.DafnySequence.asString("a"))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(40,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_0_p0, dafny.DafnySequence.asString("abc"))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(41,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_1_p3, dafny.DafnySequence.asString("abc"))).equals(dafny.DafnySequence.asString("abc")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(42,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_2_pn3, dafny.DafnySequence.asString("abc"))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(43,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_0_p0, dafny.DafnySequence.asString("aBcDñÑeF"))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(44,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_1_p3, dafny.DafnySequence.asString("aBcDñÑeF"))).equals(dafny.DafnySequence.asString("aBc")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(45,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_2_pn3, dafny.DafnySequence.asString("aBcDñÑeF"))).equals(dafny.DafnySequence.asString("aBcDñ")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(46,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestSuffix()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _0_p0;
    _0_p0 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_suffix(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSuffix.create(0));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _1_p3;
    _1_p3 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_suffix(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSuffix.create(3));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _2_pn3;
    _2_pn3 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_suffix(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSuffix.create(-3));
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_0_p0, dafny.DafnySequence.asString(""))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(52,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_1_p3, dafny.DafnySequence.asString(""))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(53,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_2_pn3, dafny.DafnySequence.asString(""))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(54,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_0_p0, dafny.DafnySequence.asString("a"))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(55,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_1_p3, dafny.DafnySequence.asString("a"))).equals(dafny.DafnySequence.asString("a")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(56,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_2_pn3, dafny.DafnySequence.asString("a"))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(57,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_0_p0, dafny.DafnySequence.asString("abc"))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(58,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_1_p3, dafny.DafnySequence.asString("abc"))).equals(dafny.DafnySequence.asString("abc")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(59,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_2_pn3, dafny.DafnySequence.asString("abc"))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(60,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_0_p0, dafny.DafnySequence.asString("aBcDñÑeF"))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(61,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_1_p3, dafny.DafnySequence.asString("aBcDñÑeF"))).equals(dafny.DafnySequence.asString("ÑeF")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(62,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_2_pn3, dafny.DafnySequence.asString("aBcDñÑeF"))).equals(dafny.DafnySequence.asString("DñÑeF")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(63,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestSubstring()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _0_p24;
    _0_p24 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_substring(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSubstring.create(2, 4));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _1_p42;
    _1_p42 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_substring(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSubstring.create(4, 2));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _2_p2n2;
    _2_p2n2 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_substring(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSubstring.create(2, -2));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _3_pn44;
    _3_pn44 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_substring(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSubstring.create(-4, 4));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _4_pn4n2;
    _4_pn4n2 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_substring(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSubstring.create(-4, -2));
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_0_p24, dafny.DafnySequence.asString("abcdef"))).equals(dafny.DafnySequence.asString("cd")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(72,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_1_p42, dafny.DafnySequence.asString("abcdef"))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(73,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_2_p2n2, dafny.DafnySequence.asString("abcdef"))).equals(dafny.DafnySequence.asString("cd")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(74,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_3_pn44, dafny.DafnySequence.asString("abcdef"))).equals(dafny.DafnySequence.asString("cd")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(75,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_4_pn4n2, dafny.DafnySequence.asString("abcdef"))).equals(dafny.DafnySequence.asString("cd")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(76,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestSegment()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _0_p0;
    _0_p0 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_segment(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment.create(dafny.DafnySequence.asString("."), 0));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _1_p1;
    _1_p1 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_segment(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment.create(dafny.DafnySequence.asString("."), 1));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _2_p2;
    _2_p2 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_segment(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment.create(dafny.DafnySequence.asString("."), 2));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _3_p3;
    _3_p3 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_segment(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment.create(dafny.DafnySequence.asString("."), 3));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _4_p4;
    _4_p4 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_segment(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment.create(dafny.DafnySequence.asString("."), 4));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _5_p5;
    _5_p5 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_segment(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment.create(dafny.DafnySequence.asString("."), 5));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _6_pn1;
    _6_pn1 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_segment(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment.create(dafny.DafnySequence.asString("."), -1));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _7_pn2;
    _7_pn2 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_segment(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment.create(dafny.DafnySequence.asString("."), -2));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _8_pn3;
    _8_pn3 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_segment(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment.create(dafny.DafnySequence.asString("."), -3));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _9_pn4;
    _9_pn4 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_segment(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment.create(dafny.DafnySequence.asString("."), -4));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _10_pn5;
    _10_pn5 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_segment(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment.create(dafny.DafnySequence.asString("."), -5));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _11_pn6;
    _11_pn6 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_segment(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment.create(dafny.DafnySequence.asString("."), -6));
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_0_p0, dafny.DafnySequence.asString("1.23.456.7890"))).equals(dafny.DafnySequence.asString("1")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(92,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_1_p1, dafny.DafnySequence.asString("1.23.456.7890"))).equals(dafny.DafnySequence.asString("23")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(93,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_2_p2, dafny.DafnySequence.asString("1.23.456.7890"))).equals(dafny.DafnySequence.asString("456")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(94,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_3_p3, dafny.DafnySequence.asString("1.23.456.7890"))).equals(dafny.DafnySequence.asString("7890")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(95,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_4_p4, dafny.DafnySequence.asString("1.23.456.7890"))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(96,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_5_p5, dafny.DafnySequence.asString("1.23.456.7890"))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(97,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_6_pn1, dafny.DafnySequence.asString("1.23.456.7890"))).equals(dafny.DafnySequence.asString("7890")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(98,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_7_pn2, dafny.DafnySequence.asString("1.23.456.7890"))).equals(dafny.DafnySequence.asString("456")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(99,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_8_pn3, dafny.DafnySequence.asString("1.23.456.7890"))).equals(dafny.DafnySequence.asString("23")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(100,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_9_pn4, dafny.DafnySequence.asString("1.23.456.7890"))).equals(dafny.DafnySequence.asString("1")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(101,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_10_pn5, dafny.DafnySequence.asString("1.23.456.7890"))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(102,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_11_pn6, dafny.DafnySequence.asString("1.23.456.7890"))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(103,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestSegments()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _0_p00;
    _0_p00 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_segments(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegments.create(dafny.DafnySequence.asString("."), 0, 0));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _1_p12;
    _1_p12 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_segments(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegments.create(dafny.DafnySequence.asString("."), 1, 2));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _2_pn32;
    _2_pn32 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_segments(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegments.create(dafny.DafnySequence.asString("."), -3, 2));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _3_p13;
    _3_p13 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_segments(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegments.create(dafny.DafnySequence.asString("."), 1, 3));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _4_p0n1;
    _4_p0n1 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_segments(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegments.create(dafny.DafnySequence.asString("."), 0, -1));
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_0_p00, dafny.DafnySequence.asString("1.23.456.7890"))).equals(dafny.DafnySequence.asString("")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(112,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_1_p12, dafny.DafnySequence.asString("1.23.456.7890"))).equals(dafny.DafnySequence.asString("23")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(113,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_3_p13, dafny.DafnySequence.asString("1.23.456.7890"))).equals(dafny.DafnySequence.asString("23.456")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(114,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_2_pn32, dafny.DafnySequence.asString("1.23.456.7890"))).equals(dafny.DafnySequence.asString("23")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(115,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((DdbVirtualFields_Compile.__default.DoTransform(_4_p0n1, dafny.DafnySequence.asString("1.23.456.7890"))).equals(dafny.DafnySequence.asString("1.23.456")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(116,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestVirtualField()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _0_lowTrans;
    _0_lowTrans = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_lower(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Lower.create());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart _1_part1;
    _1_part1 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart.create(dafny.DafnySequence.asString("foo"), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransformList._typeDescriptor()));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart _2_part2;
    _2_part2 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart.create(dafny.DafnySequence.asString("bar"), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform._typeDescriptor(), _0_lowTrans)));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart _3_part3;
    _3_part3 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart.create(dafny.DafnySequence.asString("baz[2].florn"), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransformList._typeDescriptor()));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField _4_virtualField;
    _4_virtualField = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField.create(dafny.DafnySequence.asString("myField"), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart._typeDescriptor(), _1_part1, _2_part2, _3_part3));
    Wrappers_Compile.Result<DdbVirtualFields_Compile.VirtField, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_valueOrError0 = Wrappers_Compile.Result.<DdbVirtualFields_Compile.VirtField, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(DdbVirtualFields_Compile.VirtField._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DdbVirtualFields_Compile.VirtField.Default());
    _5_valueOrError0 = DdbVirtualFields_Compile.__default.ParseVirtualFieldConfig(_4_virtualField);
    if (!(!((_5_valueOrError0).IsFailure(DdbVirtualFields_Compile.VirtField._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(124,21): " + java.lang.String.valueOf(_5_valueOrError0));
    }
    DdbVirtualFields_Compile.VirtField _6_virtField;
    _6_virtField = (_5_valueOrError0).Extract(DdbVirtualFields_Compile.VirtField._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _7_fooString;
    _7_fooString = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(dafny.DafnySequence.asString("1.23"));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _8_barString;
    _8_barString = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(dafny.DafnySequence.asString("BarString"));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _9_flornString;
    _9_flornString = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("FlornString"));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _10_flornMap;
    _10_flornMap = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_M(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("florn"), _9_flornString)));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _11_bazList;
    _11_bazList = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_L(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), _7_fooString, _8_barString, _10_flornMap));
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _12_item;
    _12_item = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("foo"), _7_fooString), new dafny.Tuple2(dafny.DafnySequence.asString("bar"), _8_barString), new dafny.Tuple2(dafny.DafnySequence.asString("baz"), _11_bazList));
    Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _13_valueOrError1 = Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
    _13_valueOrError1 = DdbVirtualFields_Compile.__default.GetVirtField(_6_virtField, _12_item);
    if (!(!((_13_valueOrError1).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(131,15): " + java.lang.String.valueOf(_13_valueOrError1));
    }
    Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _14_str;
    _14_str = (_13_valueOrError1).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!(java.util.Objects.equals(_14_str, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("1.23barstringFlornString"))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Virtual.dfy(132,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  @Override
  public java.lang.String toString() {
    return "TestDdbVirtualFields._default";
  }
}
