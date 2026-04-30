// Class __default
// Dafny class __default compiled into Java
package DynamoToStructTest_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static void DoFail(dafny.DafnySequence<? extends java.lang.Byte> data, dafny.DafnySequence<? extends java.lang.Byte> typeId)
  {
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _0_data;
    _0_data = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(data, typeId);
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _1_result;
    _1_result = DynamoToStruct_Compile.__default.StructuredToAttr(_0_data);
    if (!((_1_result).is_Failure())) {
      System.out.print((dafny.DafnySequence.asString("\nStructuredToAttr should have failed with this data : ")).verbatimString());
      System.out.print(java.lang.String.valueOf(_0_data));
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
    }
    if (!((_1_result).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(24,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void DoSucceed(dafny.DafnySequence<? extends java.lang.Byte> data, dafny.DafnySequence<? extends java.lang.Byte> typeId, java.math.BigInteger pos)
  {
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _0_data;
    _0_data = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(data, typeId);
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _1_result;
    _1_result = DynamoToStruct_Compile.__default.StructuredToAttr(_0_data);
    if (!((_1_result).is_Success())) {
      System.out.print((dafny.DafnySequence.asString("\nUnexpected failure of StructuredToAttr : (")).verbatimString());
      System.out.print(java.lang.String.valueOf(pos));
      System.out.print((dafny.DafnySequence.asString(") : ")).verbatimString());
      System.out.print(java.lang.String.valueOf(_1_result));
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
    }
    if (!((_1_result).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(33,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestZeroBytes()
  {
    __default.DoSucceed(dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()), StructuredEncryptionUtil_Compile.__default.NULL(), java.math.BigInteger.ONE);
    __default.DoSucceed(dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()), StructuredEncryptionUtil_Compile.__default.STRING(), java.math.BigInteger.valueOf(2L));
    __default.DoSucceed(dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()), StructuredEncryptionUtil_Compile.__default.NUMBER(), java.math.BigInteger.valueOf(3L));
    __default.DoSucceed(dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()), StructuredEncryptionUtil_Compile.__default.BINARY(), java.math.BigInteger.valueOf(4L));
    __default.DoFail(dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()), StructuredEncryptionUtil_Compile.__default.BOOLEAN());
    __default.DoFail(dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()), StructuredEncryptionUtil_Compile.__default.STRING__SET());
    __default.DoFail(dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()), StructuredEncryptionUtil_Compile.__default.NUMBER__SET());
    __default.DoFail(dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()), StructuredEncryptionUtil_Compile.__default.BINARY__SET());
    __default.DoFail(dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()), StructuredEncryptionUtil_Compile.__default.MAP());
    __default.DoFail(dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()), StructuredEncryptionUtil_Compile.__default.LIST());
  }
  public static void TestBadType()
  {
    __default.DoSucceed(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0), StructuredEncryptionUtil_Compile.__default.LIST(), java.math.BigInteger.valueOf(5L));
    __default.DoFail(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 3, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 0), StructuredEncryptionUtil_Compile.__default.LIST());
  }
  public static void TestBadLengthList()
  {
    __default.DoFail(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 3, (byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 1), StructuredEncryptionUtil_Compile.__default.LIST());
    __default.DoSucceed(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 255, (byte) 255, (byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 1, (byte) 2), StructuredEncryptionUtil_Compile.__default.LIST(), java.math.BigInteger.valueOf(6L));
    __default.DoFail(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 3, (byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 1, (byte) 2, (byte) 3), StructuredEncryptionUtil_Compile.__default.LIST());
  }
  public static void TestBadLengthMap()
  {
    __default.DoFail(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 4, __default.k(), __default.e(), __default.y(), __default.A(), (byte) 0, (byte) 3, (byte) 0, (byte) 0, (byte) 0, (byte) 5, (byte) 1, (byte) 2, (byte) 3, (byte) 4), StructuredEncryptionUtil_Compile.__default.MAP());
    __default.DoSucceed(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 4, __default.k(), __default.e(), __default.y(), __default.A(), (byte) 255, (byte) 255, (byte) 0, (byte) 0, (byte) 0, (byte) 5, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), StructuredEncryptionUtil_Compile.__default.MAP(), java.math.BigInteger.valueOf(7L));
    __default.DoFail(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 4, __default.k(), __default.e(), __default.y(), __default.A(), (byte) 0, (byte) 3, (byte) 0, (byte) 0, (byte) 0, (byte) 5, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6), StructuredEncryptionUtil_Compile.__default.MAP());
  }
  public static void TestBadDupKeys()
  {
    __default.DoSucceed(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 4, __default.k(), __default.e(), __default.y(), __default.A(), (byte) 255, (byte) 255, (byte) 0, (byte) 0, (byte) 0, (byte) 5, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 4, __default.k(), __default.e(), __default.y(), __default.B(), (byte) 255, (byte) 255, (byte) 0, (byte) 0, (byte) 0, (byte) 5, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), StructuredEncryptionUtil_Compile.__default.MAP(), java.math.BigInteger.valueOf(8L));
    __default.DoFail(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 4, __default.k(), __default.e(), __default.y(), __default.A(), (byte) 255, (byte) 255, (byte) 0, (byte) 0, (byte) 0, (byte) 5, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 4, __default.k(), __default.e(), __default.y(), __default.A(), (byte) 255, (byte) 255, (byte) 0, (byte) 0, (byte) 0, (byte) 5, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), StructuredEncryptionUtil_Compile.__default.MAP());
    __default.DoSucceed(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 49, (byte) 50, (byte) 51, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 52, (byte) 53, (byte) 54), StructuredEncryptionUtil_Compile.__default.BINARY__SET(), java.math.BigInteger.valueOf(9L));
    __default.DoFail(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 49, (byte) 50, (byte) 51, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 49, (byte) 50, (byte) 51), StructuredEncryptionUtil_Compile.__default.BINARY__SET());
    __default.DoSucceed(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 49, (byte) 50, (byte) 51, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 52, (byte) 53, (byte) 54), StructuredEncryptionUtil_Compile.__default.NUMBER__SET(), java.math.BigInteger.valueOf(10L));
    __default.DoFail(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 49, (byte) 50, (byte) 51, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 49, (byte) 50, (byte) 51), StructuredEncryptionUtil_Compile.__default.NUMBER__SET());
    __default.DoSucceed(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 49, (byte) 50, (byte) 51, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 52, (byte) 53, (byte) 54), StructuredEncryptionUtil_Compile.__default.STRING__SET(), java.math.BigInteger.valueOf(11L));
    __default.DoFail(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 49, (byte) 50, (byte) 51, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 49, (byte) 50, (byte) 51), StructuredEncryptionUtil_Compile.__default.STRING__SET());
  }
  public static void TestEncode2()
  {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _0_stringValue;
    _0_stringValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("abc"));
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _1_encodedStringData;
    _1_encodedStringData = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> of((byte) 97, (byte) 98, (byte) 99), dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 1));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _2_stringStruct;
    _2_stringStruct = DynamoToStruct_Compile.__default.AttrToStructured(_0_stringValue);
    if (!((_2_stringStruct).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(100,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_2_stringStruct).dtor_value(), _1_encodedStringData))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(101,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _3_newStringValue;
    _3_newStringValue = DynamoToStruct_Compile.__default.StructuredToAttr(_1_encodedStringData);
    if (!((_3_newStringValue).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(104,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_3_newStringValue).dtor_value(), _0_stringValue))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(105,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _4_numberValue;
    _4_numberValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(dafny.DafnySequence.asString("123"));
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _5_encodedNumberData;
    _5_encodedNumberData = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> of((byte) 49, (byte) 50, (byte) 51), dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 2));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _6_numberStruct;
    _6_numberStruct = DynamoToStruct_Compile.__default.AttrToStructured(_4_numberValue);
    if (!((_6_numberStruct).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(110,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_6_numberStruct).dtor_value(), _5_encodedNumberData))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(111,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _7_newNumberValue;
    _7_newNumberValue = DynamoToStruct_Compile.__default.StructuredToAttr(_5_encodedNumberData);
    if (!((_7_newNumberValue).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(114,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_7_newNumberValue).dtor_value(), _4_numberValue))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(115,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _8_numberSetValue;
    _8_numberSetValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("123"), dafny.DafnySequence.asString("45")));
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _9_encodedNumberSetData;
    _9_encodedNumberSetData = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 49, (byte) 50, (byte) 51, (byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 52, (byte) 53), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _10_numberSetStruct;
    _10_numberSetStruct = DynamoToStruct_Compile.__default.AttrToStructured(_8_numberSetValue);
    if (!((_10_numberSetStruct).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(120,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_10_numberSetStruct).dtor_value(), _9_encodedNumberSetData))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(121,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _11_newNumberSetValue;
    _11_newNumberSetValue = DynamoToStruct_Compile.__default.StructuredToAttr(_9_encodedNumberSetData);
    if (!((_11_newNumberSetValue).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(124,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_11_newNumberSetValue).dtor_value(), _8_numberSetValue))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(125,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _12_stringSetValue;
    _12_stringSetValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_SS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("abc"), dafny.DafnySequence.asString("de")));
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _13_encodedStringSetData;
    _13_encodedStringSetData = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 97, (byte) 98, (byte) 99, (byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 100, (byte) 101), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 1));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _14_stringSetStruct;
    _14_stringSetStruct = DynamoToStruct_Compile.__default.AttrToStructured(_12_stringSetValue);
    if (!((_14_stringSetStruct).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(130,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_14_stringSetStruct).dtor_value(), _13_encodedStringSetData))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(131,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _15_newStringSetValue;
    _15_newStringSetValue = DynamoToStruct_Compile.__default.StructuredToAttr(_13_encodedStringSetData);
    if (!((_15_newStringSetValue).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(134,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_15_newStringSetValue).dtor_value(), _12_stringSetValue))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(135,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _16_binarySetValue;
    _16_binarySetValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BS(dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> of(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3), dafny.DafnySequence.<java.lang.Byte> of((byte) 4, (byte) 5)));
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _17_encodedBinarySetData;
    _17_encodedBinarySetData = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 1, (byte) 2, (byte) 3, (byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 4, (byte) 5), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 255));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _18_binarySetStruct;
    _18_binarySetStruct = DynamoToStruct_Compile.__default.AttrToStructured(_16_binarySetValue);
    if (!((_18_binarySetStruct).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(140,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_18_binarySetStruct).dtor_value(), _17_encodedBinarySetData))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(141,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _19_newBinarySetValue;
    _19_newBinarySetValue = DynamoToStruct_Compile.__default.StructuredToAttr(_17_encodedBinarySetData);
    if (!((_19_newBinarySetValue).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(144,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_19_newBinarySetValue).dtor_value(), _16_binarySetValue))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(145,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestEncode()
  {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _0_binaryValue;
    _0_binaryValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_B(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _1_encodedBinaryData;
    _1_encodedBinaryData = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), dafny.DafnySequence.<java.lang.Byte> of((byte) 255, (byte) 255));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _2_binaryStruct;
    _2_binaryStruct = DynamoToStruct_Compile.__default.AttrToStructured(_0_binaryValue);
    if (!((_2_binaryStruct).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(152,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_2_binaryStruct).dtor_value(), _1_encodedBinaryData))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(153,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _3_newBinaryValue;
    _3_newBinaryValue = DynamoToStruct_Compile.__default.StructuredToAttr(_1_encodedBinaryData);
    if (!((_3_newBinaryValue).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(156,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_3_newBinaryValue).dtor_value(), _0_binaryValue))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(157,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _4_nullValue;
    _4_nullValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NULL(true);
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _5_encodedNullData;
    _5_encodedNullData = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _6_nullStruct;
    _6_nullStruct = DynamoToStruct_Compile.__default.AttrToStructured(_4_nullValue);
    if (!((_6_nullStruct).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(162,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_6_nullStruct).dtor_value(), _5_encodedNullData))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(163,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _7_newNullValue;
    _7_newNullValue = DynamoToStruct_Compile.__default.StructuredToAttr((_6_nullStruct).dtor_value());
    if (!((_7_newNullValue).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(166,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_7_newNullValue).dtor_value(), _4_nullValue))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(167,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _8_boolValue;
    _8_boolValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BOOL(false);
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _9_encodedBoolData;
    _9_encodedBoolData = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> of((byte) 0), dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 4));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _10_boolStruct;
    _10_boolStruct = DynamoToStruct_Compile.__default.AttrToStructured(_8_boolValue);
    if (!((_10_boolStruct).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(172,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_10_boolStruct).dtor_value(), _9_encodedBoolData))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(173,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _11_newBoolValue;
    _11_newBoolValue = DynamoToStruct_Compile.__default.StructuredToAttr((_10_boolStruct).dtor_value());
    if (!((_11_newBoolValue).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(176,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_11_newBoolValue).dtor_value(), _8_boolValue))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(177,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _12_listValue;
    _12_listValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_L(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), _0_binaryValue, _4_nullValue, _8_boolValue));
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _13_encodedListData;
    _13_encodedListData = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 255, (byte) 255, (byte) 0, (byte) 0, (byte) 0, (byte) 5, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 4, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0), dafny.DafnySequence.<java.lang.Byte> of((byte) 3, (byte) 0));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _14_listStruct;
    _14_listStruct = DynamoToStruct_Compile.__default.AttrToStructured(_12_listValue);
    if (!((_14_listStruct).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(210,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_14_listStruct).dtor_value(), _13_encodedListData))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(211,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _15_newListValue;
    _15_newListValue = DynamoToStruct_Compile.__default.StructuredToAttr((_14_listStruct).dtor_value());
    if (!((_15_newListValue).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(214,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_15_newListValue).dtor_value(), _12_listValue))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(215,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _16_mapValue;
    _16_mapValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_M(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("keyA"), _0_binaryValue), new dafny.Tuple2(dafny.DafnySequence.asString("keyB"), _4_nullValue), new dafny.Tuple2(dafny.DafnySequence.asString("keyC"), _8_boolValue), new dafny.Tuple2(dafny.DafnySequence.asString("keyD"), _12_listValue)));
    byte _17_k;
    _17_k = ((byte) ('k'));
    byte _18_e;
    _18_e = ((byte) ('e'));
    byte _19_y;
    _19_y = ((byte) ('y'));
    byte _20_A;
    _20_A = ((byte) ('A'));
    byte _21_B;
    _21_B = ((byte) ('B'));
    byte _22_C;
    _22_C = ((byte) ('C'));
    byte _23_D;
    _23_D = ((byte) ('D'));
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _24_encodedMapData;
    _24_encodedMapData = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 4, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 4, _17_k, _18_e, _19_y, _20_A, (byte) 255, (byte) 255, (byte) 0, (byte) 0, (byte) 0, (byte) 5, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 4, _17_k, _18_e, _19_y, _21_B, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 4, _17_k, _18_e, _19_y, _22_C, (byte) 0, (byte) 4, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 4, _17_k, _18_e, _19_y, _23_D, (byte) 3, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 28, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 255, (byte) 255, (byte) 0, (byte) 0, (byte) 0, (byte) 5, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 4, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0), dafny.DafnySequence.<java.lang.Byte> of((byte) 2, (byte) 0));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _25_mapStruct;
    _25_mapStruct = DynamoToStruct_Compile.__default.AttrToStructured(_16_mapValue);
    if (!((_25_mapStruct).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(266,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_25_mapStruct).dtor_value(), _24_encodedMapData))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(267,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _26_newMapValue;
    _26_newMapValue = DynamoToStruct_Compile.__default.StructuredToAttr((_25_mapStruct).dtor_value());
    if (!((_26_newMapValue).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(270,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_26_newMapValue).dtor_value(), _16_mapValue))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(271,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestNormalizeNAttr()
  {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _0_numberValue;
    _0_numberValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(dafny.DafnySequence.asString("000123.000"));
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _1_encodedNumberData;
    _1_encodedNumberData = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> of((byte) 49, (byte) 50, (byte) 51), dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 2));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _2_numberStruct;
    _2_numberStruct = DynamoToStruct_Compile.__default.AttrToStructured(_0_numberValue);
    if (!((_2_numberStruct).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(278,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_2_numberStruct).dtor_value(), _1_encodedNumberData))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(279,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _3_newNumberValue;
    _3_newNumberValue = DynamoToStruct_Compile.__default.StructuredToAttr(_1_encodedNumberData);
    if (!((_3_newNumberValue).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(282,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_3_newNumberValue).dtor_value(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(dafny.DafnySequence.asString("123"))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(283,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestNormalizeNInSet()
  {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _0_numberSetValue;
    _0_numberSetValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("001.00")));
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _1_encodedNumberSetData;
    _1_encodedNumberSetData = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 49), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _2_numberSetStruct;
    _2_numberSetStruct = DynamoToStruct_Compile.__default.AttrToStructured(_0_numberSetValue);
    if (!((_2_numberSetStruct).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(290,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_2_numberSetStruct).dtor_value(), _1_encodedNumberSetData))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(291,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _3_newNumberSetValue;
    _3_newNumberSetValue = DynamoToStruct_Compile.__default.StructuredToAttr(_1_encodedNumberSetData);
    if (!((_3_newNumberSetValue).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(294,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_3_newNumberSetValue).dtor_value(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("1")))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(295,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestNormalizeNInList()
  {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _0_nValue;
    _0_nValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(dafny.DafnySequence.asString("001.00"));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _1_normalizedNValue;
    _1_normalizedNValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(dafny.DafnySequence.asString("1"));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _2_listValue;
    _2_listValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_L(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), _0_nValue));
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _3_encodedListData;
    _3_encodedListData = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 2, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 49), dafny.DafnySequence.<java.lang.Byte> of((byte) 3, (byte) 0));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _4_listStruct;
    _4_listStruct = DynamoToStruct_Compile.__default.AttrToStructured(_2_listValue);
    if (!((_4_listStruct).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(309,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_4_listStruct).dtor_value(), _3_encodedListData))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(310,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _5_newListValue;
    _5_newListValue = DynamoToStruct_Compile.__default.StructuredToAttr((_4_listStruct).dtor_value());
    if (!((_5_newListValue).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(313,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_5_newListValue).dtor_value(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_L(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), _1_normalizedNValue))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(314,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestNormalizeNInMap()
  {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _0_nValue;
    _0_nValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(dafny.DafnySequence.asString("001.00"));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _1_normalizedNValue;
    _1_normalizedNValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(dafny.DafnySequence.asString("1"));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _2_mapValue;
    _2_mapValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_M(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("keyA"), _0_nValue)));
    byte _3_k;
    _3_k = ((byte) ('k'));
    byte _4_e;
    _4_e = ((byte) ('e'));
    byte _5_y;
    _5_y = ((byte) ('y'));
    byte _6_A;
    _6_A = ((byte) ('A'));
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _7_encodedMapData;
    _7_encodedMapData = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 4, _3_k, _4_e, _5_y, _6_A, (byte) 0, (byte) 2, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 49), dafny.DafnySequence.<java.lang.Byte> of((byte) 2, (byte) 0));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _8_mapStruct;
    _8_mapStruct = DynamoToStruct_Compile.__default.AttrToStructured(_2_mapValue);
    if (!((_8_mapStruct).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(337,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_8_mapStruct).dtor_value(), _7_encodedMapData))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(338,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _9_newMapValue;
    _9_newMapValue = DynamoToStruct_Compile.__default.StructuredToAttr((_8_mapStruct).dtor_value());
    if (!((_9_newMapValue).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(341,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_9_newMapValue).dtor_value(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_M(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("keyA"), _1_normalizedNValue)))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(342,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestSortNSAttr()
  {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _0_numberSetValue;
    _0_numberSetValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("1"), dafny.DafnySequence.asString("2"), dafny.DafnySequence.asString("10")));
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _1_encodedNumberSetData;
    _1_encodedNumberSetData = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 49, (byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 49, (byte) 48, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 50), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _2_numberSetStruct;
    _2_numberSetStruct = DynamoToStruct_Compile.__default.AttrToStructured(_0_numberSetValue);
    if (!((_2_numberSetStruct).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(352,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_2_numberSetStruct).dtor_value(), _1_encodedNumberSetData))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(353,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _3_newNumberSetValue;
    _3_newNumberSetValue = DynamoToStruct_Compile.__default.StructuredToAttr(_1_encodedNumberSetData);
    if (!((_3_newNumberSetValue).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(356,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_3_newNumberSetValue).dtor_value(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("1"), dafny.DafnySequence.asString("10"), dafny.DafnySequence.asString("2")))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(357,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestSortNSAfterNormalize()
  {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _0_numberSetValue;
    _0_numberSetValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("1"), dafny.DafnySequence.asString("02"), dafny.DafnySequence.asString("10")));
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _1_encodedNumberSetData;
    _1_encodedNumberSetData = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 49, (byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 49, (byte) 48, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 50), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _2_numberSetStruct;
    _2_numberSetStruct = DynamoToStruct_Compile.__default.AttrToStructured(_0_numberSetValue);
    if (!((_2_numberSetStruct).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(367,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_2_numberSetStruct).dtor_value(), _1_encodedNumberSetData))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(368,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _3_newNumberSetValue;
    _3_newNumberSetValue = DynamoToStruct_Compile.__default.StructuredToAttr(_1_encodedNumberSetData);
    if (!((_3_newNumberSetValue).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(371,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_3_newNumberSetValue).dtor_value(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("1"), dafny.DafnySequence.asString("10"), dafny.DafnySequence.asString("2")))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(372,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestSortSSAttr()
  {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _0_stringSetValue;
    _0_stringSetValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_SS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("&"), dafny.DafnySequence.asString("｡"), dafny.DafnySequence.asString("𐀂")));
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _1_encodedStringSetData;
    _1_encodedStringSetData = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 38, (byte) 0, (byte) 0, (byte) 0, (byte) 4, (byte) 240, (byte) 144, (byte) 128, (byte) 130, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 239, (byte) 189, (byte) 161), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 1));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _2_stringSetStruct;
    _2_stringSetStruct = DynamoToStruct_Compile.__default.AttrToStructured(_0_stringSetValue);
    if (!((_2_stringSetStruct).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(393,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_2_stringSetStruct).dtor_value(), _1_encodedStringSetData))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(394,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _3_newStringSetValue;
    _3_newStringSetValue = DynamoToStruct_Compile.__default.StructuredToAttr(_1_encodedStringSetData);
    if (!((_3_newStringSetValue).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(397,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_3_newStringSetValue).dtor_value(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_SS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("&"), dafny.DafnySequence.asString("𐀂"), dafny.DafnySequence.asString("｡")))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(398,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestSortBSAttr()
  {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _0_binarySetValue;
    _0_binarySetValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BS(dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> of(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte> of((byte) 1), dafny.DafnySequence.<java.lang.Byte> of((byte) 2), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 0)));
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _1_encodedBinarySetData;
    _1_encodedBinarySetData = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 2), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 255));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _2_binarySetStruct;
    _2_binarySetStruct = DynamoToStruct_Compile.__default.AttrToStructured(_0_binarySetValue);
    if (!((_2_binarySetStruct).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(408,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_2_binarySetStruct).dtor_value(), _1_encodedBinarySetData))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(409,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _3_newBinarySetValue;
    _3_newBinarySetValue = DynamoToStruct_Compile.__default.StructuredToAttr(_1_encodedBinarySetData);
    if (!((_3_newBinarySetValue).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(412,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_3_newBinarySetValue).dtor_value(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BS(dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> of(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte> of((byte) 1), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 0), dafny.DafnySequence.<java.lang.Byte> of((byte) 2)))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(413,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestSetsInListAreSorted()
  {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _0_nSetValue;
    _0_nSetValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("2"), dafny.DafnySequence.asString("1"), dafny.DafnySequence.asString("10")));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _1_sSetValue;
    _1_sSetValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_SS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("&"), dafny.DafnySequence.asString("｡"), dafny.DafnySequence.asString("𐀂")));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _2_bSetValue;
    _2_bSetValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BS(dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> of(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 0), dafny.DafnySequence.<java.lang.Byte> of((byte) 1), dafny.DafnySequence.<java.lang.Byte> of((byte) 2)));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _3_sortedNSetValue;
    _3_sortedNSetValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("1"), dafny.DafnySequence.asString("10"), dafny.DafnySequence.asString("2")));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _4_sortedSSetValue;
    _4_sortedSSetValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_SS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("&"), dafny.DafnySequence.asString("𐀂"), dafny.DafnySequence.asString("｡")));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _5_sortedBSetValue;
    _5_sortedBSetValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BS(dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> of(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte> of((byte) 1), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 0), dafny.DafnySequence.<java.lang.Byte> of((byte) 2)));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _6_listValue;
    _6_listValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_L(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), _0_nSetValue, _1_sSetValue, _2_bSetValue));
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _7_encodedListData;
    _7_encodedListData = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 1, (byte) 2, (byte) 0, (byte) 0, (byte) 0, (byte) 20, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 49, (byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 49, (byte) 48, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 50, (byte) 1, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 24, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 38, (byte) 0, (byte) 0, (byte) 0, (byte) 4, (byte) 240, (byte) 144, (byte) 128, (byte) 130, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 239, (byte) 189, (byte) 161, (byte) 1, (byte) 255, (byte) 0, (byte) 0, (byte) 0, (byte) 20, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 2), dafny.DafnySequence.<java.lang.Byte> of((byte) 3, (byte) 0));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _8_listStruct;
    _8_listStruct = DynamoToStruct_Compile.__default.AttrToStructured(_6_listValue);
    if (!((_8_listStruct).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(437,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_8_listStruct).dtor_value(), _7_encodedListData))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(438,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _9_newListValue;
    _9_newListValue = DynamoToStruct_Compile.__default.StructuredToAttr((_8_listStruct).dtor_value());
    if (!((_9_newListValue).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(441,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_9_newListValue).dtor_value(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_L(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), _3_sortedNSetValue, _4_sortedSSetValue, _5_sortedBSetValue))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(442,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestSetsInMapAreSorted()
  {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _0_nSetValue;
    _0_nSetValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("2"), dafny.DafnySequence.asString("1"), dafny.DafnySequence.asString("10")));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _1_sSetValue;
    _1_sSetValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_SS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("&"), dafny.DafnySequence.asString("｡"), dafny.DafnySequence.asString("𐀂")));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _2_bSetValue;
    _2_bSetValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BS(dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> of(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 0), dafny.DafnySequence.<java.lang.Byte> of((byte) 1), dafny.DafnySequence.<java.lang.Byte> of((byte) 2)));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _3_sortedNSetValue;
    _3_sortedNSetValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("1"), dafny.DafnySequence.asString("10"), dafny.DafnySequence.asString("2")));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _4_sortedSSetValue;
    _4_sortedSSetValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_SS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("&"), dafny.DafnySequence.asString("𐀂"), dafny.DafnySequence.asString("｡")));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _5_sortedBSetValue;
    _5_sortedBSetValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BS(dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> of(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte> of((byte) 1), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 0), dafny.DafnySequence.<java.lang.Byte> of((byte) 2)));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _6_mapValue;
    _6_mapValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_M(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("keyA"), _1_sSetValue), new dafny.Tuple2(dafny.DafnySequence.asString("keyB"), _0_nSetValue), new dafny.Tuple2(dafny.DafnySequence.asString("keyC"), _2_bSetValue)));
    byte _7_k;
    _7_k = ((byte) ('k'));
    byte _8_e;
    _8_e = ((byte) ('e'));
    byte _9_y;
    _9_y = ((byte) ('y'));
    byte _10_A;
    _10_A = ((byte) ('A'));
    byte _11_B;
    _11_B = ((byte) ('B'));
    byte _12_C;
    _12_C = ((byte) ('C'));
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _13_encodedMapData;
    _13_encodedMapData = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 4, _7_k, _8_e, _9_y, _10_A, (byte) 1, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 24, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 38, (byte) 0, (byte) 0, (byte) 0, (byte) 4, (byte) 240, (byte) 144, (byte) 128, (byte) 130, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 239, (byte) 189, (byte) 161, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 4, _7_k, _8_e, _9_y, _11_B, (byte) 1, (byte) 2, (byte) 0, (byte) 0, (byte) 0, (byte) 20, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 49, (byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 49, (byte) 48, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 50, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 4, _7_k, _8_e, _9_y, _12_C, (byte) 1, (byte) 255, (byte) 0, (byte) 0, (byte) 0, (byte) 20, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 2, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 2), dafny.DafnySequence.<java.lang.Byte> of((byte) 2, (byte) 0));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _14_mapStruct;
    _14_mapStruct = DynamoToStruct_Compile.__default.AttrToStructured(_6_mapValue);
    if (!((_14_mapStruct).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(478,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_14_mapStruct).dtor_value(), _13_encodedMapData))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(479,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _15_newMapValue;
    _15_newMapValue = DynamoToStruct_Compile.__default.StructuredToAttr((_14_mapStruct).dtor_value());
    if (!((_15_newMapValue).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(482,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_15_newMapValue).dtor_value(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_M(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("keyA"), _4_sortedSSetValue), new dafny.Tuple2(dafny.DafnySequence.asString("keyB"), _3_sortedNSetValue), new dafny.Tuple2(dafny.DafnySequence.asString("keyC"), _5_sortedBSetValue)))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(483,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestSortMapKeys()
  {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _0_nullValue;
    _0_nullValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NULL(true);
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _1_mapValue;
    _1_mapValue = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_M(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("&"), _0_nullValue), new dafny.Tuple2(dafny.DafnySequence.asString("｡"), _0_nullValue), new dafny.Tuple2(dafny.DafnySequence.asString("𐀂"), _0_nullValue)));
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _2_encodedMapData;
    _2_encodedMapData = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 38, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 4, (byte) 240, (byte) 144, (byte) 128, (byte) 130, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 239, (byte) 189, (byte) 161, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0), dafny.DafnySequence.<java.lang.Byte> of((byte) 2, (byte) 0));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _3_mapStruct;
    _3_mapStruct = DynamoToStruct_Compile.__default.AttrToStructured(_1_mapValue);
    if (!((_3_mapStruct).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(511,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_3_mapStruct).dtor_value(), _2_encodedMapData))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(512,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _4_newMapValue;
    _4_newMapValue = DynamoToStruct_Compile.__default.StructuredToAttr((_3_mapStruct).dtor_value());
    if (!((_4_newMapValue).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(515,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_4_newMapValue).dtor_value(), _1_mapValue))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(516,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestRoundTrip()
  {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _0_val1;
    _0_val1 = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("astring"));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _1_val2;
    _1_val2 = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(dafny.DafnySequence.asString("12345"));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _2_val3;
    _2_val3 = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_B(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _3_val4;
    _3_val4 = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BOOL(true);
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _4_val5;
    _4_val5 = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NULL(true);
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _5_val6;
    _5_val6 = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BS(dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> of(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), dafny.DafnySequence.<java.lang.Byte> of((byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6), dafny.DafnySequence.<java.lang.Byte> of((byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7)));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _6_val7;
    _6_val7 = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_SS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("ab"), dafny.DafnySequence.asString("cdef"), dafny.DafnySequence.asString("ghijk")));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _7_val8;
    _7_val8 = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("0"), dafny.DafnySequence.asString("1"), dafny.DafnySequence.asString("234.567")));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _8_val9a;
    _8_val9a = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_L(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), _7_val8, _6_val7, _5_val6));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _9_val9b;
    _9_val9b = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_L(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), _4_val5, _3_val4, _2_val3));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _10_val9c;
    _10_val9c = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_L(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), _1_val2, _0_val1));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _11_val9;
    _11_val9 = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_L(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), _8_val9a, _9_val9b, _10_val9c));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _12_val10;
    _12_val10 = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_M(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("key1"), _0_val1), new dafny.Tuple2(dafny.DafnySequence.asString("key2"), _1_val2), new dafny.Tuple2(dafny.DafnySequence.asString("key3"), _2_val3), new dafny.Tuple2(dafny.DafnySequence.asString("key4"), _3_val4), new dafny.Tuple2(dafny.DafnySequence.asString("key5"), _4_val5), new dafny.Tuple2(dafny.DafnySequence.asString("key6"), _5_val6), new dafny.Tuple2(dafny.DafnySequence.asString("key7"), _6_val7), new dafny.Tuple2(dafny.DafnySequence.asString("key8"), _7_val8), new dafny.Tuple2(dafny.DafnySequence.asString("key9"), _11_val9)));
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _13_attrMap;
    _13_attrMap = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("key1"), _0_val1), new dafny.Tuple2(dafny.DafnySequence.asString("key2"), _1_val2), new dafny.Tuple2(dafny.DafnySequence.asString("key3"), _2_val3), new dafny.Tuple2(dafny.DafnySequence.asString("key4"), _3_val4), new dafny.Tuple2(dafny.DafnySequence.asString("key5"), _4_val5), new dafny.Tuple2(dafny.DafnySequence.asString("key6"), _5_val6), new dafny.Tuple2(dafny.DafnySequence.asString("key7"), _6_val7), new dafny.Tuple2(dafny.DafnySequence.asString("key8"), _7_val8), new dafny.Tuple2(dafny.DafnySequence.asString("key9"), _11_val9), new dafny.Tuple2(dafny.DafnySequence.asString("key10"), _12_val10));
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _14_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal> empty());
    _14_valueOrError0 = DynamoToStruct_Compile.__default.ItemToStructured(_13_attrMap);
    if (!(!((_14_valueOrError0).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(537,18): " + java.lang.String.valueOf(_14_valueOrError0));
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal> _15_struct;
    _15_struct = (_14_valueOrError0).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _16_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    _16_valueOrError1 = DynamoToStruct_Compile.__default.StructuredToItem(_15_struct);
    if (!(!((_16_valueOrError1).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(538,20): " + java.lang.String.valueOf(_16_valueOrError1));
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _17_nAttrMap;
    _17_nAttrMap = (_16_valueOrError1).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!((_13_attrMap).equals(_17_nAttrMap))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(539,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestMaxDepth()
  {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _0_value;
    _0_value = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("hello"));
    long _hi0 = (long) (long) ((DynamoDbEncryptionUtil_Compile.__default.MAX__STRUCTURE__DEPTH()) - ((long) 1L));
    for (long _1_i = (long) 0L; java.lang.Long.compareUnsigned(_1_i, _hi0) < 0; _1_i++) {
      if ((((long) java.lang.Long.remainderUnsigned(_1_i, (long) 2L)) == 0 ? 0 : 1) == 0) {
        _0_value = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_M(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("key"), _0_value)));
      } else {
        _0_value = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_L(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), _0_value));
      }
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _2_attrMap;
    _2_attrMap = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("key1"), _0_value));
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal> empty());
    _3_valueOrError0 = DynamoToStruct_Compile.__default.ItemToStructured(_2_attrMap);
    if (!(!((_3_valueOrError0).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(552,18): " + java.lang.String.valueOf(_3_valueOrError0));
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal> _4_struct;
    _4_struct = (_3_valueOrError0).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    _5_valueOrError1 = DynamoToStruct_Compile.__default.StructuredToItem(_4_struct);
    if (!(!((_5_valueOrError1).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(553,20): " + java.lang.String.valueOf(_5_valueOrError1));
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _6_nAttrMap;
    _6_nAttrMap = (_5_valueOrError1).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!((_2_attrMap).equals(_6_nAttrMap))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(554,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestTooDeep()
  {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _0_value;
    _0_value = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("hello"));
    long _hi0 = DynamoDbEncryptionUtil_Compile.__default.MAX__STRUCTURE__DEPTH();
    for (long _1_i = (long) 0L; java.lang.Long.compareUnsigned(_1_i, _hi0) < 0; _1_i++) {
      if ((((long) java.lang.Long.remainderUnsigned(_1_i, (long) 2L)) == 0 ? 0 : 1) == 0) {
        _0_value = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_M(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("key"), _0_value)));
      } else {
        _0_value = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_L(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), _0_value));
      }
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _2_attrMap;
    _2_attrMap = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("key1"), _0_value));
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_struct;
    _3_struct = DynamoToStruct_Compile.__default.ItemToStructured(_2_attrMap);
    if (!((_3_struct).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(568,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_3_struct).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Depth of attribute structure to serialize exceeds limit of 32"))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(569,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static byte k()
  {
    return ((byte) ('k'));
  }
  public static byte e()
  {
    return ((byte) ('e'));
  }
  public static byte y()
  {
    return ((byte) ('y'));
  }
  public static byte A()
  {
    return ((byte) ('A'));
  }
  public static byte B()
  {
    return ((byte) ('B'));
  }
  public static byte C()
  {
    return ((byte) ('C'));
  }
  public static byte D()
  {
    return ((byte) ('D'));
  }
  @Override
  public java.lang.String toString() {
    return "DynamoToStructTest._default";
  }
}
