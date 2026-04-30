// Class __default
// Dafny class __default compiled into Java
package StructuredEncryptionUtil_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static dafny.DafnySet<? extends dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>> CryptoListToSet(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> xs) {
    return ((java.util.function.Function<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem>, dafny.DafnySet<? extends dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>>>)(_0_xs) -> ((dafny.Function0<dafny.DafnySet<? extends dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>>>)(() -> {
      java.util.ArrayList<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>> _coll0 = new java.util.ArrayList<>();
      for (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem _compr_0_boxed0 : (_0_xs).Elements()) {
        software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem _compr_0 = ((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem)(java.lang.Object)(_compr_0_boxed0));
        software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem _1_k = (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem)_compr_0;
        if ((_0_xs).contains(_1_k)) {
          _coll0.add((_1_k).dtor_key());
        }
      }
      return new dafny.DafnySet<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>>(_coll0);
    })).apply()).apply(xs);
  }
  public static dafny.DafnySet<? extends dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>> CanonCryptoListToSet(dafny.DafnySequence<? extends CanonCryptoItem> xs) {
    return ((java.util.function.Function<dafny.DafnySequence<? extends CanonCryptoItem>, dafny.DafnySet<? extends dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>>>)(_0_xs) -> ((dafny.Function0<dafny.DafnySet<? extends dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>>>)(() -> {
      java.util.ArrayList<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>> _coll0 = new java.util.ArrayList<>();
      for (CanonCryptoItem _compr_0_boxed0 : (_0_xs).Elements()) {
        CanonCryptoItem _compr_0 = ((CanonCryptoItem)(java.lang.Object)(_compr_0_boxed0));
        CanonCryptoItem _1_k = (CanonCryptoItem)_compr_0;
        if ((_0_xs).contains(_1_k)) {
          _coll0.add((_1_k).dtor_origKey());
        }
      }
      return new dafny.DafnySet<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>>(_coll0);
    })).apply()).apply(xs);
  }
  public static dafny.DafnySet<? extends dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>> AuthListToSet(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem> xs) {
    return ((java.util.function.Function<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem>, dafny.DafnySet<? extends dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>>>)(_0_xs) -> ((dafny.Function0<dafny.DafnySet<? extends dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>>>)(() -> {
      java.util.ArrayList<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>> _coll0 = new java.util.ArrayList<>();
      for (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem _compr_0_boxed0 : (_0_xs).Elements()) {
        software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem _compr_0 = ((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem)(java.lang.Object)(_compr_0_boxed0));
        software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem _1_k = (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem)_compr_0;
        if ((_0_xs).contains(_1_k)) {
          _coll0.add((_1_k).dtor_key());
        }
      }
      return new dafny.DafnySet<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>>(_coll0);
    })).apply()).apply(xs);
  }
  public static boolean CryptoListHasNoDuplicatesFromSet(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> xs) {
    return ((long) (__default.CryptoListToSet(xs)).cardinalityInt()) == ((long) (xs).cardinalityInt());
  }
  public static boolean AuthListHasNoDuplicatesFromSet(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem> xs) {
    return ((long) (__default.AuthListToSet(xs)).cardinalityInt()) == ((long) (xs).cardinalityInt());
  }
  public static boolean ValidString(dafny.DafnySequence<? extends Character> x) {
    return (StandardLibrary_mUInt_Compile.__default.<Character>HasUint64Len(dafny.TypeDescriptor.CHAR, x)) && ((UTF8.__default.Encode(x)).is_Success());
  }
  public static boolean ValidSuite(software.amazon.cryptography.materialproviders.internaldafny.types.AlgorithmSuiteInfo alg) {
    return (((alg).dtor_id()).is_DBE()) && (AlgorithmSuites_Compile.__default.DBEAlgorithmSuite_q(alg));
  }
  public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error E(dafny.DafnySequence<? extends Character> s) {
    return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error.create_StructuredEncryptionException(s);
  }
  public static byte ConstantTimeCompare(dafny.DafnySequence<? extends java.lang.Byte> a, dafny.DafnySequence<? extends java.lang.Byte> b, long pos, byte acc)
  {
    TAIL_CALL_START: while (true) {
      if (((long) (a).cardinalityInt()) == (pos)) {
        return acc;
      } else {
        byte _0_x = (byte) (byte) ((byte)(((((byte)(java.lang.Object)((a).select(dafny.Helpers.unsignedToInt(pos)))))) ^ ((((byte)(java.lang.Object)((b).select(dafny.Helpers.unsignedToInt(pos))))))));
        dafny.DafnySequence<? extends java.lang.Byte> _in0 = a;
        dafny.DafnySequence<? extends java.lang.Byte> _in1 = b;
        long _in2 = (long) (long) ((pos) + ((long) 1L));
        byte _in3 = (byte) (byte) ((byte)((_0_x) | (acc)));
        a = _in0;
        b = _in1;
        pos = _in2;
        acc = _in3;
        continue TAIL_CALL_START;
      }
    }
  }
  public static boolean ConstantTimeEquals(dafny.DafnySequence<? extends java.lang.Byte> a, dafny.DafnySequence<? extends java.lang.Byte> b)
  {
    return ((__default.ConstantTimeCompare(a, b, (long) 0L, (byte) 0)) == 0 ? 0 : 1) == 0;
  }
  public static boolean IsAuthAttr(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction x) {
    return !((x).is_DO__NOTHING());
  }
  public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal ValueToData(dafny.DafnySequence<? extends java.lang.Byte> value, dafny.DafnySequence<? extends java.lang.Byte> typeId)
  {
    return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(value, typeId);
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> GetValue(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal data) {
    return (data).dtor_value();
  }
  public static boolean ByteLess(byte x, byte y)
  {
    return java.lang.Integer.compareUnsigned(x, y) < 0;
  }
  public static boolean CharLess(char x, char y)
  {
    return (x) < (y);
  }
  public static dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> EcAsString(dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> ec)
  {
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> output = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends Character>> empty();
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _0_keys;
    _0_keys = SortedSets.__default.<java.lang.Byte>SetToOrderedSequence2(BoundedInts_Compile.uint8._typeDescriptor(), (ec).keySet(), __default::ByteLess);
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> _1_ret;
    _1_ret = dafny.DafnyMap.fromElements();
    long _hi0 = (long) (_0_keys).cardinalityInt();
    for (long _2_i = (long) 0L; java.lang.Long.compareUnsigned(_2_i, _hi0) < 0; _2_i++) {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _3_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>Default(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
      _3_valueOrError0 = UTF8.__default.Decode(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((_0_keys).select(dafny.Helpers.unsignedToInt(_2_i)))));
      if (!(!((_3_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))))) {
        throw new dafny.DafnyHaltException("dafny/StructuredEncryption/src/Util.dfy(304,17): " + java.lang.String.valueOf(_3_valueOrError0));
      }
      dafny.DafnySequence<? extends Character> _4_key;
      _4_key = (_3_valueOrError0).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _5_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>Default(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
      _5_valueOrError1 = UTF8.__default.Decode(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((ec).get(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((_0_keys).select(dafny.Helpers.unsignedToInt(_2_i))))))));
      if (!(!((_5_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))))) {
        throw new dafny.DafnyHaltException("dafny/StructuredEncryption/src/Util.dfy(305,19): " + java.lang.String.valueOf(_5_valueOrError1));
      }
      dafny.DafnySequence<? extends Character> _6_value;
      _6_value = (_5_valueOrError1).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      _1_ret = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>update(_1_ret, _4_key, _6_value);
    }
    output = _1_ret;
    return output;
  }
  public static void PrintEncryptionContext(dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> ec, dafny.DafnySequence<? extends Character> name)
  {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _0_keys;
    _0_keys = SortedSets.__default.<java.lang.Byte>SetToOrderedSequence2(BoundedInts_Compile.uint8._typeDescriptor(), (ec).keySet(), __default::ByteLess);
    System.out.print((name).verbatimString());
    System.out.print((dafny.DafnySequence.asString(" := {\n")).verbatimString());
    java.math.BigInteger _hi0 = java.math.BigInteger.valueOf((_0_keys).length());
    for (java.math.BigInteger _1_i = java.math.BigInteger.ZERO; _1_i.compareTo(_hi0) < 0; _1_i = _1_i.add(java.math.BigInteger.ONE)) {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _2_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>Default(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
      _2_valueOrError0 = UTF8.__default.Decode(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((_0_keys).select(dafny.Helpers.toInt((_1_i))))));
      if (!(!((_2_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))))) {
        throw new dafny.DafnyHaltException("dafny/StructuredEncryption/src/Util.dfy(316,17): " + java.lang.String.valueOf(_2_valueOrError0));
      }
      dafny.DafnySequence<? extends Character> _3_key;
      _3_key = (_2_valueOrError0).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _4_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>Default(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
      _4_valueOrError1 = UTF8.__default.Decode(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((ec).get(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((_0_keys).select(dafny.Helpers.toInt((_1_i)))))))));
      if (!(!((_4_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))))) {
        throw new dafny.DafnyHaltException("dafny/StructuredEncryption/src/Util.dfy(317,19): " + java.lang.String.valueOf(_4_valueOrError1));
      }
      dafny.DafnySequence<? extends Character> _5_value;
      _5_value = (_4_valueOrError1).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      System.out.print((dafny.DafnySequence.asString("  ")).verbatimString());
      System.out.print((_3_key).verbatimString());
      System.out.print((dafny.DafnySequence.asString(" := ")).verbatimString());
      System.out.print((_5_value).verbatimString());
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
    }
    System.out.print((dafny.DafnySequence.asString("}\n")).verbatimString());
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> EncodeTerminal(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal t) {
    dafny.DafnySequence<? extends Character> _0_base = Base64_Compile.__default.Encode(dafny.DafnySequence.<java.lang.Byte>concatenate((t).dtor_typeId(), (t).dtor_value()));
    return (UTF8.__default.Encode(_0_base)).dtor_value();
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> DecodeTerminal(dafny.DafnySequence<? extends java.lang.Byte> t) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _0_valueOrError0 = UTF8.__default.Decode(t);
    if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_0_valueOrError0).<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends Character> _1_utf8DecodedVal = (_0_valueOrError0).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _2_valueOrError1 = Base64_Compile.__default.Decode(_1_utf8DecodedVal);
      if ((_2_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_2_valueOrError1).<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor());
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _3_base64DecodedVal = (_2_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _4_valueOrError2 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), java.lang.Long.compareUnsigned((long) (_3_base64DecodedVal).cardinalityInt(), (long) 2L) >= 0, dafny.DafnySequence.asString("Invalid serialization of DDB Attribute in encryption context."));
        if ((_4_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_4_valueOrError2).<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor());
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _5_typeId = (_3_base64DecodedVal).take(2);
          dafny.DafnySequence<? extends java.lang.Byte> _6_serializedValue = (_3_base64DecodedVal).drop(2);
          return Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>>create_Success(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(_6_serializedValue, _5_typeId));
        }
      }
    }
  }
  public static dafny.DafnySequence<? extends Character> ReservedPrefix()
  {
    return dafny.DafnySequence.asString("aws_dbe_");
  }
  public static dafny.DafnySequence<? extends Character> HeaderField()
  {
    return dafny.DafnySequence.<Character>concatenate(__default.ReservedPrefix(), dafny.DafnySequence.asString("head"));
  }
  public static dafny.DafnySequence<? extends Character> FooterField()
  {
    return dafny.DafnySequence.<Character>concatenate(__default.ReservedPrefix(), dafny.DafnySequence.asString("foot"));
  }
  public static dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> HeaderPath()
  {
    return dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> of(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment.create(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructureSegment.create(__default.HeaderField())));
  }
  public static dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> FooterPath()
  {
    return dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> of(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment.create(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructureSegment.create(__default.FooterField())));
  }
  public static dafny.DafnySequence<? extends dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>> HeaderPaths()
  {
    return dafny.DafnySequence.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>> of(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment._typeDescriptor()), __default.HeaderPath(), __default.FooterPath());
  }
  public static dafny.DafnySequence<? extends Character> ReservedCryptoContextPrefixString()
  {
    return dafny.DafnySequence.asString("aws-crypto-");
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> ReservedCryptoContextPrefixUTF8()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 97, (byte) 119, (byte) 115, (byte) 45, (byte) 99, (byte) 114, (byte) 121, (byte) 112, (byte) 116, (byte) 111, (byte) 45);
    return _0_s;
  }
  public static dafny.DafnySequence<? extends Character> ATTR__PREFIX()
  {
    return dafny.DafnySequence.<Character>concatenate(__default.ReservedCryptoContextPrefixString(), dafny.DafnySequence.asString("attr."));
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> EC__ATTR__PREFIX()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 97, (byte) 119, (byte) 115, (byte) 45, (byte) 99, (byte) 114, (byte) 121, (byte) 112, (byte) 116, (byte) 111, (byte) 45, (byte) 97, (byte) 116, (byte) 116, (byte) 114, (byte) 46);
    return _0_s;
  }
  public static dafny.DafnySequence<? extends Character> LEGEND()
  {
    return dafny.DafnySequence.<Character>concatenate(__default.ReservedCryptoContextPrefixString(), dafny.DafnySequence.asString("legend"));
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> LEGEND__UTF8()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 97, (byte) 119, (byte) 115, (byte) 45, (byte) 99, (byte) 114, (byte) 121, (byte) 112, (byte) 116, (byte) 111, (byte) 45, (byte) 108, (byte) 101, (byte) 103, (byte) 101, (byte) 110, (byte) 100);
    return _0_s;
  }
  public static dafny.DafnySequence<? extends Character> NULL__STR()
  {
    return dafny.DafnySequence.asString("null");
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> NULL__UTF8()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 110, (byte) 117, (byte) 108, (byte) 108);
    return _0_s;
  }
  public static dafny.DafnySequence<? extends Character> TRUE__STR()
  {
    return dafny.DafnySequence.asString("true");
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> TRUE__UTF8()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 116, (byte) 114, (byte) 117, (byte) 101);
    return _0_s;
  }
  public static dafny.DafnySequence<? extends Character> FALSE__STR()
  {
    return dafny.DafnySequence.asString("false");
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> FALSE__UTF8()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 102, (byte) 97, (byte) 108, (byte) 115, (byte) 101);
    return _0_s;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> BYTES__TYPE__ID()
  {
    return dafny.DafnySequence.<java.lang.Byte> of((byte) 255, (byte) 255);
  }
  public static byte TERM__T()
  {
    return (byte) 0;
  }
  public static byte NULL__T()
  {
    return (byte) 0;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> NULL()
  {
    return dafny.DafnySequence.<java.lang.Byte> of(__default.TERM__T(), __default.NULL__T());
  }
  public static byte STRING__T()
  {
    return (byte) 1;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> STRING()
  {
    return dafny.DafnySequence.<java.lang.Byte> of(__default.TERM__T(), __default.STRING__T());
  }
  public static byte NUMBER__T()
  {
    return (byte) 2;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> NUMBER()
  {
    return dafny.DafnySequence.<java.lang.Byte> of(__default.TERM__T(), __default.NUMBER__T());
  }
  public static byte BOOLEAN__T()
  {
    return (byte) 4;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> BOOLEAN()
  {
    return dafny.DafnySequence.<java.lang.Byte> of(__default.TERM__T(), __default.BOOLEAN__T());
  }
  public static byte SET__T()
  {
    return (byte) 1;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> STRING__SET()
  {
    return dafny.DafnySequence.<java.lang.Byte> of(__default.SET__T(), __default.STRING__T());
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> NUMBER__SET()
  {
    return dafny.DafnySequence.<java.lang.Byte> of(__default.SET__T(), __default.NUMBER__T());
  }
  public static byte BINARY__T()
  {
    return (byte) 255;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> BINARY__SET()
  {
    return dafny.DafnySequence.<java.lang.Byte> of(__default.SET__T(), __default.BINARY__T());
  }
  public static byte MAP__T()
  {
    return (byte) 2;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> MAP()
  {
    return dafny.DafnySequence.<java.lang.Byte> of(__default.MAP__T(), __default.NULL__T());
  }
  public static byte LIST__T()
  {
    return (byte) 3;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> LIST()
  {
    return dafny.DafnySequence.<java.lang.Byte> of(__default.LIST__T(), __default.NULL__T());
  }
  public static char LEGEND__STRING()
  {
    return 'S';
  }
  public static char LEGEND__NUMBER()
  {
    return 'N';
  }
  public static char LEGEND__LITERAL()
  {
    return 'L';
  }
  public static char LEGEND__BINARY()
  {
    return 'B';
  }
  public static long TYPEID__LEN64()
  {
    return (long) 2L;
  }
  public static long KeySize64()
  {
    return (long) 32L;
  }
  public static long NonceSize64()
  {
    return (long) 12L;
  }
  public static long AuthTagSize64()
  {
    return (long) 16L;
  }
  public static long MSGID__LEN64()
  {
    return (long) 32L;
  }
  public static byte DbeAlgorithmFamily()
  {
    return (byte) 103;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> BINARY()
  {
    return dafny.DafnySequence.<java.lang.Byte> of((byte) 255, (byte) 255);
  }
  @Override
  public java.lang.String toString() {
    return "StructuredEncryptionUtil._default";
  }
}
