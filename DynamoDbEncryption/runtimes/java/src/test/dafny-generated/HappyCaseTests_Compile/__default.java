// Class __default
// Dafny class __default compiled into Java
package HappyCaseTests_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static void TestRoundTrip()
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.StructuredEncryptionClient, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _0_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.StructuredEncryptionClient, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.StructuredEncryptionClient, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _out0;
    _out0 = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.__default.StructuredEncryption(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.__default.DefaultStructuredEncryptionConfig());
    _0_valueOrError0 = _out0;
    if (!(!((_0_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.StructuredEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.StructuredEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/HappyCaseTests.dfy(28,6): " + java.lang.String.valueOf(_0_valueOrError0));
    }
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.StructuredEncryptionClient _1_structuredEncryption;
    _1_structuredEncryption = (_0_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.StructuredEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.StructuredEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager _2_cmm;
    software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager _out1;
    _out1 = StructuredDataTestFixtures_Compile.__default.GetDefaultCMMWithKMSKeyring();
    _2_cmm = _out1;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _3_encContext;
    _3_encContext = dafny.DafnyMap.fromElements(new dafny.Tuple2(__default.some(), __default.value()));
    software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId _4_algSuiteId;
    _4_algSuiteId = ((AlgorithmSuites_Compile.__default.DBE__ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384()).dtor_id()).dtor_DBE();
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _5_encryptRes;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _out2;
    _out2 = (_1_structuredEncryption).EncryptStructure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureInput.create(dafny.DafnySequence.asString("myTable"), StructuredDataTestFixtures_Compile.__default.TEST__STRUCTURED__DATA(), StructuredDataTestFixtures_Compile.__default.TEST__CRYPTO__SCHEMA(), _2_cmm, Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId>create_Some(software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId._typeDescriptor(), _4_algSuiteId), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), _3_encContext)));
    _5_encryptRes = _out2;
    if ((_5_encryptRes).is_Failure()) {
      System.out.print(java.lang.String.valueOf(_5_encryptRes));
    }
    if (!((_5_encryptRes).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/HappyCaseTests.dfy(51,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal> _6_newData;
    _6_newData = ((_5_encryptRes).dtor_value()).dtor_encryptedStructure();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal> _7_testData;
    _7_testData = StructuredDataTestFixtures_Compile.__default.TEST__STRUCTURED__DATA();
    if (!(((_6_newData).keySet()).equals(dafny.DafnySet.<dafny.DafnySequence<? extends Character>>union((_7_testData).keySet(), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> of(StructuredEncryptionUtil_Compile.__default.HeaderField(), StructuredEncryptionUtil_Compile.__default.FooterField()))))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/HappyCaseTests.dfy(54,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(!java.util.Objects.equals(((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal)(java.lang.Object)((_6_newData).get(dafny.DafnySequence.asString("foo")))), ((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal)(java.lang.Object)((_7_testData).get(dafny.DafnySequence.asString("foo"))))))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/HappyCaseTests.dfy(55,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal)(java.lang.Object)((_6_newData).get(dafny.DafnySequence.asString("bar")))), ((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal)(java.lang.Object)((_7_testData).get(dafny.DafnySequence.asString("bar"))))))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/HappyCaseTests.dfy(56,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal)(java.lang.Object)((_6_newData).get(dafny.DafnySequence.asString("fizzbuzz")))), ((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal)(java.lang.Object)((_7_testData).get(dafny.DafnySequence.asString("fizzbuzz"))))))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/HappyCaseTests.dfy(57,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _8_decryptRes;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _out3;
    _out3 = (_1_structuredEncryption).DecryptStructure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureInput.create(dafny.DafnySequence.asString("myTable"), ((_5_encryptRes).dtor_value()).dtor_encryptedStructure(), StructuredDataTestFixtures_Compile.__default.TEST__AUTHENTICATE__SCHEMA(), _2_cmm, Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>create_None(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(UTF8.ValidUTF8Bytes._typeDescriptor(), UTF8.ValidUTF8Bytes._typeDescriptor()))));
    _8_decryptRes = _out3;
    if ((_8_decryptRes).is_Failure()) {
      System.out.print((dafny.DafnySequence.asString("\n\n")).verbatimString());
      System.out.print(java.lang.String.valueOf(_8_decryptRes));
      System.out.print((dafny.DafnySequence.asString("\n\n")).verbatimString());
    }
    if (!((_8_decryptRes).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/HappyCaseTests.dfy(72,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal> _9_newResult;
    _9_newResult = ((_8_decryptRes).dtor_value()).dtor_plaintextStructure();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal> _10_testResult;
    _10_testResult = StructuredDataTestFixtures_Compile.__default.TEST__STRUCTURED__DATA();
    if (!((_9_newResult).equals(_10_testResult))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/HappyCaseTests.dfy(75,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ParsedHeader _11_parsedHeader;
    _11_parsedHeader = ((_8_decryptRes).dtor_value()).dtor_parsedHeader();
    if (!((((_8_decryptRes).dtor_value()).dtor_cryptoSchema()).equals(StructuredDataTestFixtures_Compile.__default.TEST__CRYPTO__SCHEMA__AUTH__ONLY()))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/HappyCaseTests.dfy(83,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_11_parsedHeader).dtor_algorithmSuiteId(), _4_algSuiteId))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/HappyCaseTests.dfy(84,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((_3_encContext).keySet()).isSubsetOf(((_11_parsedHeader).dtor_storedEncryptionContext()).keySet()))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/HappyCaseTests.dfy(85,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((dafny.Function2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ParsedHeader, Boolean>)(_12_encContext, _13_parsedHeader) -> dafny.Helpers.Quantifier(((_12_encContext).keySet()).Elements(), true, ((_forall_var_0_boxed0) -> {
      dafny.DafnySequence<? extends java.lang.Byte> _forall_var_0 = ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)(_forall_var_0_boxed0));
      dafny.DafnySequence<? extends java.lang.Byte> _14_k = (dafny.DafnySequence<? extends java.lang.Byte>)_forall_var_0;
      return !(((_12_encContext).keySet()).<dafny.DafnySequence<? extends java.lang.Byte>>contains(_14_k)) || ((((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)(((_13_parsedHeader).dtor_storedEncryptionContext()).get(_14_k)))).equals(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((_12_encContext).get(_14_k)))));
    }))).apply(_3_encContext, _11_parsedHeader))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/HappyCaseTests.dfy(86,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf(((_11_parsedHeader).dtor_encryptedDataKeys()).length()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/HappyCaseTests.dfy(87,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> some()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 115, (byte) 111, (byte) 109, (byte) 101);
    return _0_s;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> value()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 118, (byte) 97, (byte) 108, (byte) 117, (byte) 101);
    return _0_s;
  }
  @Override
  public java.lang.String toString() {
    return "HappyCaseTests._default";
  }
}
