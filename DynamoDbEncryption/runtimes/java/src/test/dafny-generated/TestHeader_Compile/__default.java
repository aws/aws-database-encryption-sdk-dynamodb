// Class __default
// Dafny class __default compiled into Java
package TestHeader_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static void TestRoundTrip()
  {
    StructuredEncryptionHeader_Compile.PartialHeader _0_head;
    _0_head = StructuredEncryptionHeader_Compile.PartialHeader.create((byte) 1, (byte) 1, dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32), dafny.DafnySequence.<java.lang.Byte> of((byte) 101, (byte) 115), dafny.DafnyMap.fromElements(new dafny.Tuple2(__default.abc(), __default.def())), dafny.DafnySequence.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> of(software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey.create(__default.provID(), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), dafny.DafnySequence.<java.lang.Byte> of((byte) 6, (byte) 7, (byte) 8, (byte) 9))));
    dafny.DafnySequence<? extends java.lang.Byte> _1_ser;
    _1_ser = dafny.DafnySequence.<java.lang.Byte>concatenate((_0_head).serialize(), (_0_head).dtor_msgID());
    Wrappers_Compile.Result<StructuredEncryptionHeader_Compile.PartialHeader, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _2_valueOrError0 = (Wrappers_Compile.Result<StructuredEncryptionHeader_Compile.PartialHeader, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>)null;
    _2_valueOrError0 = StructuredEncryptionHeader_Compile.__default.PartialDeserialize(_1_ser);
    if (!(!((_2_valueOrError0).IsFailure(StructuredEncryptionHeader_Compile.PartialHeader._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(63,16): " + java.lang.String.valueOf(_2_valueOrError0));
    }
    StructuredEncryptionHeader_Compile.PartialHeader _3_orig;
    _3_orig = (_2_valueOrError0).Extract(StructuredEncryptionHeader_Compile.PartialHeader._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
    if (!(java.util.Objects.equals(_3_orig, _0_head))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(64,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestRoundTripWithCommit()
  {
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _0_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _out0;
    _out0 = software.amazon.cryptography.primitives.internaldafny.__default.AtomicPrimitives(software.amazon.cryptography.primitives.internaldafny.__default.DefaultCryptoConfig());
    _0_valueOrError0 = _out0;
    if (!(!((_0_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(68,18): " + java.lang.String.valueOf(_0_valueOrError0));
    }
    software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient _1_client;
    _1_client = (_0_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor());
    StructuredEncryptionHeader_Compile.PartialHeader _2_head;
    _2_head = StructuredEncryptionHeader_Compile.PartialHeader.create((byte) 1, (byte) 1, dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32), dafny.DafnySequence.<java.lang.Byte> of((byte) 101, (byte) 115), dafny.DafnyMap.fromElements(new dafny.Tuple2(__default.abc(), __default.def())), dafny.DafnySequence.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> of(software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey.create(__default.provID(), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), dafny.DafnySequence.<java.lang.Byte> of((byte) 6, (byte) 7, (byte) 8, (byte) 9))));
    dafny.DafnySequence<? extends java.lang.Byte> _3_key;
    _3_key = (_2_head).dtor_msgID();
    software.amazon.cryptography.materialproviders.internaldafny.types.AlgorithmSuiteInfo _4_alg;
    _4_alg = AlgorithmSuites_Compile.__default.DBE__ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384();
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _5_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
    _5_valueOrError1 = StructuredEncryptionHeader_Compile.__default.Serialize(_1_client, _4_alg, _3_key, _2_head);
    if (!(!((_5_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(82,15): " + java.lang.String.valueOf(_5_valueOrError1));
    }
    dafny.DafnySequence<? extends java.lang.Byte> _6_ser;
    _6_ser = (_5_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<StructuredEncryptionHeader_Compile.PartialHeader, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _7_valueOrError2 = (Wrappers_Compile.Result<StructuredEncryptionHeader_Compile.PartialHeader, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>)null;
    _7_valueOrError2 = StructuredEncryptionHeader_Compile.__default.PartialDeserialize(_6_ser);
    if (!(!((_7_valueOrError2).IsFailure(StructuredEncryptionHeader_Compile.PartialHeader._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(83,16): " + java.lang.String.valueOf(_7_valueOrError2));
    }
    StructuredEncryptionHeader_Compile.PartialHeader _8_orig;
    _8_orig = (_7_valueOrError2).Extract(StructuredEncryptionHeader_Compile.PartialHeader._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
    if (!(java.util.Objects.equals(_8_orig, _2_head))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(84,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _9_valueOrError3 = Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), false);
    _9_valueOrError3 = (_2_head).verifyCommitment(_1_client, _4_alg, _3_key, _6_ser);
    if (!(!((_9_valueOrError3).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(85,22): " + java.lang.String.valueOf(_9_valueOrError3));
    }
    boolean _10_goodResult;
    _10_goodResult = (_9_valueOrError3).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
    byte _11_lastByte;
    _11_lastByte = ((byte)(java.lang.Object)((_6_ser).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((_6_ser).length())).subtract(java.math.BigInteger.ONE))))));
    byte _12_badByte;
    if (((_11_lastByte) == 0 ? 0 : 1) == 0) {
      _12_badByte = (byte) 255;
    } else {
      _12_badByte = (byte) (byte) ((byte)((_11_lastByte) - ((byte) 1)));
    }
    dafny.DafnySequence<? extends java.lang.Byte> _13_badSer;
    _13_badSer = dafny.DafnySequence.<java.lang.Byte>concatenate((_6_ser).take((java.math.BigInteger.valueOf((_6_ser).length())).subtract(java.math.BigInteger.ONE)), dafny.DafnySequence.<java.lang.Byte> of(_12_badByte));
    Wrappers_Compile.Result<StructuredEncryptionHeader_Compile.PartialHeader, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _14_valueOrError4 = (Wrappers_Compile.Result<StructuredEncryptionHeader_Compile.PartialHeader, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>)null;
    _14_valueOrError4 = StructuredEncryptionHeader_Compile.__default.PartialDeserialize(_13_badSer);
    if (!(!((_14_valueOrError4).IsFailure(StructuredEncryptionHeader_Compile.PartialHeader._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(90,17): " + java.lang.String.valueOf(_14_valueOrError4));
    }
    StructuredEncryptionHeader_Compile.PartialHeader _15_head2;
    _15_head2 = (_14_valueOrError4).Extract(StructuredEncryptionHeader_Compile.PartialHeader._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
    if (!(java.util.Objects.equals(_15_head2, _2_head))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(91,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _16_badResult;
    _16_badResult = (_2_head).verifyCommitment(_1_client, _4_alg, _3_key, _13_badSer);
    if (!((_16_badResult).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(94,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_16_badResult).dtor_error(), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Key commitment mismatch."))))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(95,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestDuplicateContext()
  {
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _0_cont;
    _0_cont = dafny.DafnyMap.fromElements(new dafny.Tuple2(__default.abc(), __default.def()), new dafny.Tuple2(__default.cba(), __default.fed()));
    dafny.DafnySequence<? extends java.lang.Byte> _1_serCont;
    _1_serCont = StructuredEncryptionHeader_Compile.__default.SerializeContext(_0_cont);
    if (!((_1_serCont).equals(dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 2, (byte) 0, (byte) 3, __default.a(), __default.b(), __default.c(), (byte) 0, (byte) 3, __default.d(), __default.e(), __default.f(), (byte) 0, (byte) 3, __default.c(), __default.b(), __default.a(), (byte) 0, (byte) 3, __default.f(), __default.e(), __default.d())))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(107,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _2_newCont;
    _2_newCont = StructuredEncryptionHeader_Compile.__default.GetContext(_1_serCont);
    if (!((_2_newCont).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(115,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((_2_newCont).dtor_value()).dtor__0()).equals(_0_cont))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(116,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((_2_newCont).dtor_value()).dtor__1()) == ((long) (_1_serCont).cardinalityInt()))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(117,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    dafny.DafnySequence<? extends java.lang.Byte> _3_badSerCont;
    _3_badSerCont = dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 3, (byte) 0, (byte) 3, __default.a(), __default.b(), __default.c(), (byte) 0, (byte) 3, __default.d(), __default.e(), __default.f(), (byte) 0, (byte) 3, __default.c(), __default.b(), __default.a(), (byte) 0, (byte) 3, __default.f(), __default.e(), __default.d(), (byte) 0, (byte) 3, __default.a(), __default.b(), __default.c(), (byte) 0, (byte) 3, __default.e(), __default.d(), __default.f());
    Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _4_newBadCont;
    _4_newBadCont = StructuredEncryptionHeader_Compile.__default.GetContext(_3_badSerCont);
    if (!(java.util.Objects.equals(_4_newBadCont, Wrappers_Compile.Result.<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Failure(dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>_typeDescriptor(StructuredEncryptionHeader_Compile.CMPEncryptionContext._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Context keys out of order.")))))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(132,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestOutOfOrderContext()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_badSerCont;
    _0_badSerCont = dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 2, (byte) 0, (byte) 3, __default.c(), __default.b(), __default.a(), (byte) 0, (byte) 3, __default.f(), __default.e(), __default.d(), (byte) 0, (byte) 3, __default.a(), __default.b(), __default.c(), (byte) 0, (byte) 3, __default.d(), __default.e(), __default.f());
    Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _1_newBadCont;
    _1_newBadCont = StructuredEncryptionHeader_Compile.__default.GetContext(_0_badSerCont);
    if (!(java.util.Objects.equals(_1_newBadCont, Wrappers_Compile.Result.<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Failure(dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>_typeDescriptor(StructuredEncryptionHeader_Compile.CMPEncryptionContext._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Context keys out of order.")))))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(148,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem MakeCrypto(dafny.DafnySequence<? extends Character> s, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction a)
  {
    return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem.create(StructuredEncryptionPaths_Compile.__default.StringToUniPath(s), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2)), a);
  }
  public static void TestSchemaOrderAlpha()
  {
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> _0_schemaMap;
    _0_schemaMap = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> of(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem._typeDescriptor(), __default.MakeCrypto(dafny.DafnySequence.asString("abc"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), __default.MakeCrypto(dafny.DafnySequence.asString("def"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), __default.MakeCrypto(dafny.DafnySequence.asString("ghi"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_DO__NOTHING()), __default.MakeCrypto(dafny.DafnySequence.asString("jkl"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), __default.MakeCrypto(dafny.DafnySequence.asString("mno"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), __default.MakeCrypto(dafny.DafnySequence.asString("pqr"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_DO__NOTHING()));
    dafny.DafnySequence<? extends Character> _1_tableName;
    _1_tableName = dafny.DafnySequence.asString("name");
    Wrappers_Compile.Result<dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _2_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem>_typeDescriptor(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem> empty(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()));
    _2_valueOrError0 = Canonize_Compile.__default.ForEncrypt(_1_tableName, _0_schemaMap);
    if (!(!((_2_valueOrError0).IsFailure(dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem>_typeDescriptor(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(166,23): " + java.lang.String.valueOf(_2_valueOrError0));
    }
    dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> _3_canonSchema;
    _3_canonSchema = (_2_valueOrError0).Extract(dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem>_typeDescriptor(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _4_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(StructuredEncryptionHeader_Compile.Legend._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(StructuredEncryptionHeader_Compile.LegendByte._typeDescriptor()));
    _4_valueOrError1 = StructuredEncryptionHeader_Compile.__default.MakeLegend(_3_canonSchema);
    if (!(!((_4_valueOrError1).IsFailure(StructuredEncryptionHeader_Compile.Legend._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(167,18): " + java.lang.String.valueOf(_4_valueOrError1));
    }
    dafny.DafnySequence<? extends java.lang.Byte> _5_legend;
    _5_legend = (_4_valueOrError1).Extract(StructuredEncryptionHeader_Compile.Legend._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
    if (!((_5_legend).equals(dafny.DafnySequence.<java.lang.Byte> of(StructuredEncryptionHeader_Compile.__default.ENCRYPT__AND__SIGN__LEGEND(), StructuredEncryptionHeader_Compile.__default.SIGN__ONLY__LEGEND(), StructuredEncryptionHeader_Compile.__default.ENCRYPT__AND__SIGN__LEGEND(), StructuredEncryptionHeader_Compile.__default.SIGN__ONLY__LEGEND())))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(175,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestSchemaOrderLength()
  {
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> _0_schemaMap;
    _0_schemaMap = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> of(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem._typeDescriptor(), __default.MakeCrypto(dafny.DafnySequence.asString("aa"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), __default.MakeCrypto(dafny.DafnySequence.asString("zz"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), __default.MakeCrypto(dafny.DafnySequence.asString("aaa"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_DO__NOTHING()), __default.MakeCrypto(dafny.DafnySequence.asString("zzz"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), __default.MakeCrypto(dafny.DafnySequence.asString("aaaa"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), __default.MakeCrypto(dafny.DafnySequence.asString("zzzz"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_DO__NOTHING()));
    dafny.DafnySequence<? extends Character> _1_tableName;
    _1_tableName = dafny.DafnySequence.asString("name");
    Wrappers_Compile.Result<dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _2_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem>_typeDescriptor(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem> empty(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()));
    _2_valueOrError0 = Canonize_Compile.__default.ForEncrypt(_1_tableName, _0_schemaMap);
    if (!(!((_2_valueOrError0).IsFailure(dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem>_typeDescriptor(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(188,23): " + java.lang.String.valueOf(_2_valueOrError0));
    }
    dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> _3_canonSchema;
    _3_canonSchema = (_2_valueOrError0).Extract(dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem>_typeDescriptor(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _4_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(StructuredEncryptionHeader_Compile.Legend._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(StructuredEncryptionHeader_Compile.LegendByte._typeDescriptor()));
    _4_valueOrError1 = StructuredEncryptionHeader_Compile.__default.MakeLegend(_3_canonSchema);
    if (!(!((_4_valueOrError1).IsFailure(StructuredEncryptionHeader_Compile.Legend._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(189,18): " + java.lang.String.valueOf(_4_valueOrError1));
    }
    dafny.DafnySequence<? extends java.lang.Byte> _5_legend;
    _5_legend = (_4_valueOrError1).Extract(StructuredEncryptionHeader_Compile.Legend._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
    if (!((_5_legend).equals(dafny.DafnySequence.<java.lang.Byte> of(StructuredEncryptionHeader_Compile.__default.ENCRYPT__AND__SIGN__LEGEND(), StructuredEncryptionHeader_Compile.__default.SIGN__ONLY__LEGEND(), StructuredEncryptionHeader_Compile.__default.ENCRYPT__AND__SIGN__LEGEND(), StructuredEncryptionHeader_Compile.__default.SIGN__ONLY__LEGEND())))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(197,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestSchemaOrderLength2()
  {
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> _0_schemaMap;
    _0_schemaMap = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> of(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem._typeDescriptor(), __default.MakeCrypto(dafny.DafnySequence.asString("aa"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), __default.MakeCrypto(dafny.DafnySequence.asString("zzz"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), __default.MakeCrypto(dafny.DafnySequence.asString("zzzz"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_DO__NOTHING()), __default.MakeCrypto(dafny.DafnySequence.asString("aaa"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_DO__NOTHING()), __default.MakeCrypto(dafny.DafnySequence.asString("zz"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), __default.MakeCrypto(dafny.DafnySequence.asString("aaaa"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()));
    dafny.DafnySequence<? extends Character> _1_tableName;
    _1_tableName = dafny.DafnySequence.asString("name");
    Wrappers_Compile.Result<dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _2_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem>_typeDescriptor(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem> empty(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()));
    _2_valueOrError0 = Canonize_Compile.__default.ForEncrypt(_1_tableName, _0_schemaMap);
    if (!(!((_2_valueOrError0).IsFailure(dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem>_typeDescriptor(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(210,23): " + java.lang.String.valueOf(_2_valueOrError0));
    }
    dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> _3_canonSchema;
    _3_canonSchema = (_2_valueOrError0).Extract(dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem>_typeDescriptor(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _4_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(StructuredEncryptionHeader_Compile.Legend._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(StructuredEncryptionHeader_Compile.LegendByte._typeDescriptor()));
    _4_valueOrError1 = StructuredEncryptionHeader_Compile.__default.MakeLegend(_3_canonSchema);
    if (!(!((_4_valueOrError1).IsFailure(StructuredEncryptionHeader_Compile.Legend._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(211,18): " + java.lang.String.valueOf(_4_valueOrError1));
    }
    dafny.DafnySequence<? extends java.lang.Byte> _5_legend;
    _5_legend = (_4_valueOrError1).Extract(StructuredEncryptionHeader_Compile.Legend._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
    if (!((_5_legend).equals(dafny.DafnySequence.<java.lang.Byte> of(StructuredEncryptionHeader_Compile.__default.ENCRYPT__AND__SIGN__LEGEND(), StructuredEncryptionHeader_Compile.__default.SIGN__ONLY__LEGEND(), StructuredEncryptionHeader_Compile.__default.ENCRYPT__AND__SIGN__LEGEND(), StructuredEncryptionHeader_Compile.__default.SIGN__ONLY__LEGEND())))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Header.dfy(219,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> abc()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 97, (byte) 98, (byte) 99);
    return _0_s;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> def()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 100, (byte) 101, (byte) 102);
    return _0_s;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> provID()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 112, (byte) 114, (byte) 111, (byte) 118, (byte) 73, (byte) 68);
    return _0_s;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> cba()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 99, (byte) 98, (byte) 97);
    return _0_s;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> fed()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 102, (byte) 101, (byte) 100);
    return _0_s;
  }
  public static byte a()
  {
    return ((byte) ('a'));
  }
  public static byte b()
  {
    return ((byte) ('b'));
  }
  public static byte c()
  {
    return ((byte) ('c'));
  }
  public static byte d()
  {
    return ((byte) ('d'));
  }
  public static byte e()
  {
    return ((byte) ('e'));
  }
  public static byte f()
  {
    return ((byte) ('f'));
  }
  @Override
  public java.lang.String toString() {
    return "TestHeader._default";
  }
}
