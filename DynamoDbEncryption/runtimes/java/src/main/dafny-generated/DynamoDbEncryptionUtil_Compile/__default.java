// Class __default
// Dafny class __default compiled into Java
package DynamoDbEncryptionUtil_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static MaybeKeyId MaybeFromOptionKeyId(Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> x) {
    if ((x).is_Some()) {
      return MaybeKeyId.create_KeyId((x).dtor_value());
    } else {
      return MaybeKeyId.create_DontUseKeyId();
    }
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error E(dafny.DafnySequence<? extends Character> s) {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error.create_DynamoDbEncryptionException(s);
  }
  public static boolean CharLess(char x, char y)
  {
    return (x) < (y);
  }
  public static boolean ByteLess(byte x, byte y)
  {
    return java.lang.Integer.compareUnsigned(x, y) < 0;
  }
  public static dafny.DafnySequence<? extends Character> AttrTypeToStr(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue attr) {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _source0 = attr;
    if (_source0.is_S()) {
      dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_S)_source0)._S;
      dafny.DafnySequence<? extends Character> _1_s = _0___mcc_h0;
      return dafny.DafnySequence.asString("S");
    } else if (_source0.is_N()) {
      dafny.DafnySequence<? extends Character> _2___mcc_h1 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_N)_source0)._N;
      dafny.DafnySequence<? extends Character> _3_n = _2___mcc_h1;
      return dafny.DafnySequence.asString("N");
    } else if (_source0.is_B()) {
      dafny.DafnySequence<? extends java.lang.Byte> _4___mcc_h2 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_B)_source0)._B;
      dafny.DafnySequence<? extends java.lang.Byte> _5_n = _4___mcc_h2;
      return dafny.DafnySequence.asString("B");
    } else if (_source0.is_SS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _6___mcc_h3 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_SS)_source0)._SS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _7_n = _6___mcc_h3;
      return dafny.DafnySequence.asString("SS");
    } else if (_source0.is_NS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _8___mcc_h4 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_NS)_source0)._NS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _9_n = _8___mcc_h4;
      return dafny.DafnySequence.asString("NS");
    } else if (_source0.is_BS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _10___mcc_h5 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_BS)_source0)._BS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _11_n = _10___mcc_h5;
      return dafny.DafnySequence.asString("BS");
    } else if (_source0.is_M()) {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _12___mcc_h6 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_M)_source0)._M;
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _13_n = _12___mcc_h6;
      return dafny.DafnySequence.asString("M");
    } else if (_source0.is_L()) {
      dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _14___mcc_h7 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_L)_source0)._L;
      dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _15_n = _14___mcc_h7;
      return dafny.DafnySequence.asString("L");
    } else if (_source0.is_NULL()) {
      boolean _16___mcc_h8 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_NULL)_source0)._NULL;
      boolean _17_n = _16___mcc_h8;
      return dafny.DafnySequence.asString("NULL");
    } else {
      boolean _18___mcc_h9 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_BOOL)_source0)._BOOL;
      boolean _19_n = _18___mcc_h9;
      return dafny.DafnySequence.asString("BOOL");
    }
  }
  public static <__T> dafny.Tuple0 printFromFunction(dafny.TypeDescriptor<__T> _td___T, __T x)
  {
    dafny.Tuple0 _hresult = dafny.Tuple0.Default();
    System.out.print(java.lang.String.valueOf(x));
    System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
    _hresult = dafny.Tuple0.create();
    return _hresult;
  }
  public static dafny.DafnySequence<? extends Character> ReservedPrefix()
  {
    return dafny.DafnySequence.asString("aws_dbe_");
  }
  public static dafny.DafnySequence<? extends Character> BeaconPrefix()
  {
    return dafny.DafnySequence.asString("aws_dbe_b_");
  }
  public static dafny.DafnySequence<? extends Character> VersionPrefix()
  {
    return dafny.DafnySequence.asString("aws_dbe_v_");
  }
  public static long MAX__STRUCTURE__DEPTH()
  {
    return (long) 32L;
  }
  public static dafny.DafnySequence<? extends Character> MAX__STRUCTURE__DEPTH__STR()
  {
    return dafny.DafnySequence.asString("32");
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDbEncryptionUtil._default";
  }
}
