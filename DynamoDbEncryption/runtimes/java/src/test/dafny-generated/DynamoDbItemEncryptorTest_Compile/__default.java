// Class __default
// Dafny class __default compiled into Java
package DynamoDbItemEncryptorTest_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue DDBS(dafny.DafnySequence<? extends Character> x) {
    return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(x);
  }
  public static void TestUnexpectedField()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient _0_encryptor;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient _out0;
    _out0 = TestFixtures_Compile.__default.GetDynamoDbItemEncryptor();
    _0_encryptor = _out0;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _1_inputItem;
    _1_inputItem = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), __default.DDBS(dafny.DafnySequence.asString("key"))), new dafny.Tuple2(dafny.DafnySequence.asString("encrypt"), __default.DDBS(dafny.DafnySequence.asString("foo"))), new dafny.Tuple2(dafny.DafnySequence.asString("sign"), __default.DDBS(dafny.DafnySequence.asString("bar"))), new dafny.Tuple2(dafny.DafnySequence.asString("nothing"), __default.DDBS(dafny.DafnySequence.asString("baz"))), new dafny.Tuple2(dafny.DafnySequence.asString("unknown"), __default.DDBS(dafny.DafnySequence.asString("other"))));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _2_encryptRes;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _out1;
    _out1 = (_0_encryptor).EncryptItem(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemInput.create(_1_inputItem));
    _2_encryptRes = _out1;
    if (!((_2_encryptRes).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(45,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_2_encryptRes).dtor_error(), software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error.create_AwsCryptographyDbEncryptionSdkDynamoDb(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error.create_DynamoDbEncryptionException(dafny.DafnySequence.asString("No Crypto Action configured for attribute unknown")))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(46,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestMissingSortKey()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _0_config;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _out0;
    _out0 = TestFixtures_Compile.__default.GetEncryptorConfig();
    _0_config = _out0;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _1_inputItem;
    _1_inputItem = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), __default.DDBS(dafny.DafnySequence.asString("key"))), new dafny.Tuple2(dafny.DafnySequence.asString("encrypt"), __default.DDBS(dafny.DafnySequence.asString("foo"))), new dafny.Tuple2(dafny.DafnySequence.asString("sign"), __default.DDBS(dafny.DafnySequence.asString("bar"))), new dafny.Tuple2(dafny.DafnySequence.asString("nothing"), __default.DDBS(dafny.DafnySequence.asString("baz"))));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _2_config2;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _3_dt__update__tmp_h0 = _0_config;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _4_dt__update_hattributeActionsOnEncrypt_h0 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>update((_0_config).dtor_attributeActionsOnEncrypt(), dafny.DafnySequence.asString("sort"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY());
    Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _5_dt__update_hsortKeyName_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("sort"));
    _2_config2 = software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig.create((_3_dt__update__tmp_h0).dtor_logicalTableName(), (_3_dt__update__tmp_h0).dtor_partitionKeyName(), _5_dt__update_hsortKeyName_h0, _4_dt__update_hattributeActionsOnEncrypt_h0, (_3_dt__update__tmp_h0).dtor_allowedUnsignedAttributes(), (_3_dt__update__tmp_h0).dtor_allowedUnsignedAttributePrefix(), (_3_dt__update__tmp_h0).dtor_algorithmSuiteId(), (_3_dt__update__tmp_h0).dtor_keyring(), (_3_dt__update__tmp_h0).dtor_cmm(), (_3_dt__update__tmp_h0).dtor_legacyOverride(), (_3_dt__update__tmp_h0).dtor_plaintextOverride());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient _6_encryptor;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient _out1;
    _out1 = TestFixtures_Compile.__default.GetDynamoDbItemEncryptorFrom(_2_config2);
    _6_encryptor = _out1;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _7_encryptRes;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _out2;
    _out2 = (_6_encryptor).EncryptItem(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemInput.create(_1_inputItem));
    _7_encryptRes = _out2;
    if (!((_7_encryptRes).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(63,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_7_encryptRes).dtor_error(), software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error.create_DynamoDbItemEncryptorException(dafny.DafnySequence.asString("On Encrypt : Sort key 'sort' does not exist in item. Item contains these attributes : bar encrypt nothing sign."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(64,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static dafny.DafnySequence<? extends Character> GetAttrName(dafny.DafnySequence<? extends Character> s) {
    if (software.amazon.cryptography.services.dynamodb.internaldafny.types.__default.IsValid__AttributeName(s)) {
      return s;
    } else {
      return dafny.DafnySequence.asString("spoo");
    }
  }
  public static void TestV2RoundTripComplexSwitch()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _0_config;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _out0;
    _out0 = TestFixtures_Compile.__default.GetEncryptorConfigFromActions(__default.Actions1(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("sortKey")));
    _0_config = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient _1_encryptor;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient _out1;
    _out1 = TestFixtures_Compile.__default.GetDynamoDbItemEncryptorFrom(_0_config);
    _1_encryptor = _out1;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _2_inputItem;
    _2_inputItem = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(dafny.DafnySequence.asString("00001234"))), new dafny.Tuple2(dafny.DafnySequence.asString("sortKey"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_B(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4))), new dafny.Tuple2(dafny.DafnySequence.asString("encrypt"), __default.DDBS(dafny.DafnySequence.asString("text"))), new dafny.Tuple2(dafny.DafnySequence.asString("sign"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BOOL(true)), new dafny.Tuple2(dafny.DafnySequence.asString("sign3"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BOOL(false)), new dafny.Tuple2(dafny.DafnySequence.asString("sign4"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NULL(true)), new dafny.Tuple2(dafny.DafnySequence.asString("nothing"), __default.DDBS(dafny.DafnySequence.asString("baz"))));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _3_encryptRes;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _out2;
    _out2 = (_1_encryptor).EncryptItem(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemInput.create(_2_inputItem));
    _3_encryptRes = _out2;
    if ((_3_encryptRes).is_Failure()) {
      System.out.print((dafny.DafnySequence.asString("\n\n")).verbatimString());
      System.out.print(java.lang.String.valueOf(_3_encryptRes));
      System.out.print((dafny.DafnySequence.asString("\n\n")).verbatimString());
    }
    if (!((_3_encryptRes).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(122,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((_3_encryptRes).dtor_value()).dtor_encryptedItem()).keySet()).equals(dafny.DafnySet.<dafny.DafnySequence<? extends Character>>union((_2_inputItem).keySet(), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> of(StructuredEncryptionUtil_Compile.__default.HeaderField(), StructuredEncryptionUtil_Compile.__default.FooterField()))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(123,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((((_3_encryptRes).dtor_value()).dtor_encryptedItem()).get(dafny.DafnySequence.asString("bar")))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_2_inputItem).get(dafny.DafnySequence.asString("bar"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(124,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(!java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((((_3_encryptRes).dtor_value()).dtor_encryptedItem()).get(dafny.DafnySequence.asString("encrypt")))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_2_inputItem).get(dafny.DafnySequence.asString("encrypt"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(125,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((((_3_encryptRes).dtor_value()).dtor_encryptedItem()).get(dafny.DafnySequence.asString("sign")))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_2_inputItem).get(dafny.DafnySequence.asString("sign"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(126,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((((_3_encryptRes).dtor_value()).dtor_encryptedItem()).get(dafny.DafnySequence.asString("sign3")))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_2_inputItem).get(dafny.DafnySequence.asString("sign3"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(127,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((((_3_encryptRes).dtor_value()).dtor_encryptedItem()).get(dafny.DafnySequence.asString("sign4")))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_2_inputItem).get(dafny.DafnySequence.asString("sign4"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(128,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((((_3_encryptRes).dtor_value()).dtor_encryptedItem()).get(dafny.DafnySequence.asString("nothing")))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_2_inputItem).get(dafny.DafnySequence.asString("nothing"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(129,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _4_config2;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _out3;
    _out3 = TestFixtures_Compile.__default.GetEncryptorConfigFromActions(__default.Actions2(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("sortKey")));
    _4_config2 = _out3;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient _5_encryptor2;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient _out4;
    _out4 = TestFixtures_Compile.__default.GetDynamoDbItemEncryptorFrom(_4_config2);
    _5_encryptor2 = _out4;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _6_decryptRes;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _out5;
    _out5 = (_5_encryptor2).DecryptItem(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemInput.create(((_3_encryptRes).dtor_value()).dtor_encryptedItem()));
    _6_decryptRes = _out5;
    if ((_6_decryptRes).is_Failure()) {
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
      System.out.print(java.lang.String.valueOf((_6_decryptRes).dtor_error()));
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
    }
    if (!((_6_decryptRes).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(143,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((_6_decryptRes).dtor_value()).dtor_plaintextItem()).equals(_2_inputItem)) {
      System.out.print((dafny.DafnySequence.asString("\ninputItem :\n")).verbatimString());
      System.out.print(java.lang.String.valueOf(_2_inputItem));
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
      System.out.print((dafny.DafnySequence.asString("\nOutput Item :\n")).verbatimString());
      System.out.print(java.lang.String.valueOf(((_6_decryptRes).dtor_value()).dtor_plaintextItem()));
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
    }
    if (!((((_6_decryptRes).dtor_value()).dtor_plaintextItem()).equals(_2_inputItem))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(148,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.ParsedHeader> _7_parsedHeader;
    _7_parsedHeader = ((_6_decryptRes).dtor_value()).dtor_parsedHeader();
    if (!((_7_parsedHeader).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(151,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((_7_parsedHeader).dtor_value()).dtor_algorithmSuiteId(), ((AlgorithmSuites_Compile.__default.DBE__ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384()).dtor_id()).dtor_DBE()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(152,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((_7_parsedHeader).dtor_value()).dtor_attributeActionsOnEncrypt()).equals(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>subtract(__default.Actions1(), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.asString("nothing"), dafny.DafnySequence.asString("sign2")))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(153,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf((((_7_parsedHeader).dtor_value()).dtor_storedEncryptionContext()).size()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(155,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((_7_parsedHeader).dtor_value()).dtor_storedEncryptionContext()).keySet()).<dafny.DafnySequence<? extends java.lang.Byte>>contains(__default.PublicKeyUtf8()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(156,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf((((_7_parsedHeader).dtor_value()).dtor_encryptedDataKeys()).length()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(157,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> _8_strEC;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> _out6;
    _out6 = StructuredEncryptionUtil_Compile.__default.EcAsString(((_7_parsedHeader).dtor_value()).dtor_encryptionContext());
    _8_strEC = _out6;
    if (!(((_8_strEC).keySet()).<dafny.DafnySequence<? extends Character>>contains(dafny.DafnySequence.asString("aws-crypto-public-key")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(160,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    _8_strEC = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>subtract(_8_strEC, dafny.DafnySet.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.asString("aws-crypto-public-key")));
    if (!((_8_strEC).equals(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-legend"), dafny.DafnySequence.asString("NLLLB")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.bar"), dafny.DafnySequence.asString("1234")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.sortKey"), dafny.DafnySequence.asString("//8BAgME")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.sign"), dafny.DafnySequence.asString("true")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.sign3"), dafny.DafnySequence.asString("false")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.sign4"), dafny.DafnySequence.asString("null")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-partition-name"), dafny.DafnySequence.asString("bar")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-sort-name"), dafny.DafnySequence.asString("sortKey")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-table-name"), dafny.DafnySequence.asString("foo")))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(162,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((_7_parsedHeader).dtor_value()).dtor_selectorContext()).equals(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(dafny.DafnySequence.asString("1234"))), new dafny.Tuple2(dafny.DafnySequence.asString("sortKey"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_B(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4))), new dafny.Tuple2(dafny.DafnySequence.asString("sign"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BOOL(true)), new dafny.Tuple2(dafny.DafnySequence.asString("sign3"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BOOL(false)), new dafny.Tuple2(dafny.DafnySequence.asString("sign4"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NULL(true)), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_table_name"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("foo"))), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_partition_name"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("bar"))), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_sort_name"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("sortKey"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(173,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestV2RoundTripComplex()
  {
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _0_actions;
    _0_actions = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("sortKey"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("encrypt"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("sign"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("sign2"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), new dafny.Tuple2(dafny.DafnySequence.asString("sign3"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("sign4"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("nothing"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_DO__NOTHING()));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _1_config;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _out0;
    _out0 = TestFixtures_Compile.__default.GetEncryptorConfigFromActions(_0_actions, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("sortKey")));
    _1_config = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient _2_encryptor;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient _out1;
    _out1 = TestFixtures_Compile.__default.GetDynamoDbItemEncryptorFrom(_1_config);
    _2_encryptor = _out1;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _3_inputItem;
    _3_inputItem = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(dafny.DafnySequence.asString("1234"))), new dafny.Tuple2(dafny.DafnySequence.asString("sortKey"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_B(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4))), new dafny.Tuple2(dafny.DafnySequence.asString("encrypt"), __default.DDBS(dafny.DafnySequence.asString("text"))), new dafny.Tuple2(dafny.DafnySequence.asString("sign"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BOOL(true)), new dafny.Tuple2(dafny.DafnySequence.asString("sign3"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BOOL(false)), new dafny.Tuple2(dafny.DafnySequence.asString("sign4"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NULL(true)), new dafny.Tuple2(dafny.DafnySequence.asString("nothing"), __default.DDBS(dafny.DafnySequence.asString("baz"))));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _4_encryptRes;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _out2;
    _out2 = (_2_encryptor).EncryptItem(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemInput.create(_3_inputItem));
    _4_encryptRes = _out2;
    if ((_4_encryptRes).is_Failure()) {
      System.out.print((dafny.DafnySequence.asString("\n\n")).verbatimString());
      System.out.print(java.lang.String.valueOf(_4_encryptRes));
      System.out.print((dafny.DafnySequence.asString("\n\n")).verbatimString());
    }
    if (!((_4_encryptRes).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(221,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((_4_encryptRes).dtor_value()).dtor_encryptedItem()).keySet()).equals(dafny.DafnySet.<dafny.DafnySequence<? extends Character>>union((_3_inputItem).keySet(), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> of(StructuredEncryptionUtil_Compile.__default.HeaderField(), StructuredEncryptionUtil_Compile.__default.FooterField()))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(222,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((((_4_encryptRes).dtor_value()).dtor_encryptedItem()).get(dafny.DafnySequence.asString("bar")))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_3_inputItem).get(dafny.DafnySequence.asString("bar"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(223,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(!java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((((_4_encryptRes).dtor_value()).dtor_encryptedItem()).get(dafny.DafnySequence.asString("encrypt")))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_3_inputItem).get(dafny.DafnySequence.asString("encrypt"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(224,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((((_4_encryptRes).dtor_value()).dtor_encryptedItem()).get(dafny.DafnySequence.asString("sign")))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_3_inputItem).get(dafny.DafnySequence.asString("sign"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(225,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((((_4_encryptRes).dtor_value()).dtor_encryptedItem()).get(dafny.DafnySequence.asString("sign3")))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_3_inputItem).get(dafny.DafnySequence.asString("sign3"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(226,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((((_4_encryptRes).dtor_value()).dtor_encryptedItem()).get(dafny.DafnySequence.asString("sign4")))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_3_inputItem).get(dafny.DafnySequence.asString("sign4"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(227,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((((_4_encryptRes).dtor_value()).dtor_encryptedItem()).get(dafny.DafnySequence.asString("nothing")))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_3_inputItem).get(dafny.DafnySequence.asString("nothing"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(228,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _5_decryptRes;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _out3;
    _out3 = (_2_encryptor).DecryptItem(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemInput.create(((_4_encryptRes).dtor_value()).dtor_encryptedItem()));
    _5_decryptRes = _out3;
    if ((_5_decryptRes).is_Failure()) {
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
      System.out.print(java.lang.String.valueOf((_5_decryptRes).dtor_error()));
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
    }
    if (!((_5_decryptRes).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(239,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((_5_decryptRes).dtor_value()).dtor_plaintextItem()).equals(_3_inputItem)) {
      System.out.print((dafny.DafnySequence.asString("\nInput Item :\n")).verbatimString());
      System.out.print(java.lang.String.valueOf(_3_inputItem));
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
      System.out.print((dafny.DafnySequence.asString("\nOutput Item :\n")).verbatimString());
      System.out.print(java.lang.String.valueOf(((_5_decryptRes).dtor_value()).dtor_plaintextItem()));
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
    }
    if (!((((_5_decryptRes).dtor_value()).dtor_plaintextItem()).equals(_3_inputItem))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(244,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.ParsedHeader> _6_parsedHeader;
    _6_parsedHeader = ((_5_decryptRes).dtor_value()).dtor_parsedHeader();
    if (!((_6_parsedHeader).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(247,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((_6_parsedHeader).dtor_value()).dtor_algorithmSuiteId(), ((AlgorithmSuites_Compile.__default.DBE__ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384()).dtor_id()).dtor_DBE()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(248,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((_6_parsedHeader).dtor_value()).dtor_attributeActionsOnEncrypt()).equals(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>subtract(_0_actions, dafny.DafnySet.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.asString("nothing"), dafny.DafnySequence.asString("sign2")))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(249,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf((((_6_parsedHeader).dtor_value()).dtor_storedEncryptionContext()).size()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(256,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((_6_parsedHeader).dtor_value()).dtor_storedEncryptionContext()).keySet()).<dafny.DafnySequence<? extends java.lang.Byte>>contains(__default.PublicKeyUtf8()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(257,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf((((_6_parsedHeader).dtor_value()).dtor_encryptedDataKeys()).length()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(258,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> _7_strEC;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> _out4;
    _out4 = StructuredEncryptionUtil_Compile.__default.EcAsString(((_6_parsedHeader).dtor_value()).dtor_encryptionContext());
    _7_strEC = _out4;
    if (!(((_7_strEC).keySet()).<dafny.DafnySequence<? extends Character>>contains(dafny.DafnySequence.asString("aws-crypto-public-key")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(261,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    _7_strEC = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>subtract(_7_strEC, dafny.DafnySet.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.asString("aws-crypto-public-key")));
    if (!((_7_strEC).equals(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-legend"), dafny.DafnySequence.asString("NLLLB")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.bar"), dafny.DafnySequence.asString("1234")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.sortKey"), dafny.DafnySequence.asString("//8BAgME")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.sign"), dafny.DafnySequence.asString("true")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.sign3"), dafny.DafnySequence.asString("false")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.sign4"), dafny.DafnySequence.asString("null")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-partition-name"), dafny.DafnySequence.asString("bar")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-sort-name"), dafny.DafnySequence.asString("sortKey")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-table-name"), dafny.DafnySequence.asString("foo")))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(290,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((_6_parsedHeader).dtor_value()).dtor_selectorContext()).equals(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(dafny.DafnySequence.asString("1234"))), new dafny.Tuple2(dafny.DafnySequence.asString("sortKey"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_B(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4))), new dafny.Tuple2(dafny.DafnySequence.asString("sign"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BOOL(true)), new dafny.Tuple2(dafny.DafnySequence.asString("sign3"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BOOL(false)), new dafny.Tuple2(dafny.DafnySequence.asString("sign4"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NULL(true)), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_table_name"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("foo"))), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_partition_name"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("bar"))), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_sort_name"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("sortKey"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(301,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestMissingContext()
  {
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _0_actions;
    _0_actions = TestFixtures_Compile.__default.GetV2AttributeActions();
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _1_config;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _out0;
    _out0 = TestFixtures_Compile.__default.GetEncryptorConfigFromActions(_0_actions, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.KeySchemaAttributeName._typeDescriptor()));
    _1_config = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient _2_encryptor;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient _out1;
    _out1 = TestFixtures_Compile.__default.GetDynamoDbItemEncryptorFrom(_1_config);
    _2_encryptor = _out1;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _3_inputItem;
    _3_inputItem = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), __default.DDBS(dafny.DafnySequence.asString("key"))), new dafny.Tuple2(dafny.DafnySequence.asString("encrypt"), __default.DDBS(dafny.DafnySequence.asString("text"))), new dafny.Tuple2(dafny.DafnySequence.asString("nothing"), __default.DDBS(dafny.DafnySequence.asString("baz"))));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _4_encryptRes;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _out2;
    _out2 = (_2_encryptor).EncryptItem(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemInput.create(_3_inputItem));
    _4_encryptRes = _out2;
    if (!((_4_encryptRes).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(331,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_4_encryptRes).dtor_error(), DynamoDbItemEncryptorUtil_Compile.__default.E(dafny.DafnySequence.asString("Attribute sign was configured with SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT but was not present in item to be encrypted."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(332,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestV2RoundTrip()
  {
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _0_actions;
    _0_actions = TestFixtures_Compile.__default.GetV2AttributeActions();
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _1_config;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _out0;
    _out0 = TestFixtures_Compile.__default.GetEncryptorConfigFromActions(_0_actions, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.KeySchemaAttributeName._typeDescriptor()));
    _1_config = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient _2_encryptor;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient _out1;
    _out1 = TestFixtures_Compile.__default.GetDynamoDbItemEncryptorFrom(_1_config);
    _2_encryptor = _out1;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _3_inputItem;
    _3_inputItem = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), __default.DDBS(dafny.DafnySequence.asString("key"))), new dafny.Tuple2(dafny.DafnySequence.asString("encrypt"), __default.DDBS(dafny.DafnySequence.asString("text"))), new dafny.Tuple2(dafny.DafnySequence.asString("sign"), __default.DDBS(dafny.DafnySequence.asString("barsoom"))), new dafny.Tuple2(dafny.DafnySequence.asString("nothing"), __default.DDBS(dafny.DafnySequence.asString("baz"))));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _4_encryptRes;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _out2;
    _out2 = (_2_encryptor).EncryptItem(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemInput.create(_3_inputItem));
    _4_encryptRes = _out2;
    if ((_4_encryptRes).is_Failure()) {
      System.out.print((dafny.DafnySequence.asString("\n\n")).verbatimString());
      System.out.print(java.lang.String.valueOf(_4_encryptRes));
      System.out.print((dafny.DafnySequence.asString("\n\n")).verbatimString());
    }
    if (!((_4_encryptRes).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(356,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((_4_encryptRes).dtor_value()).dtor_encryptedItem()).keySet()).equals(dafny.DafnySet.<dafny.DafnySequence<? extends Character>>union((_3_inputItem).keySet(), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> of(StructuredEncryptionUtil_Compile.__default.HeaderField(), StructuredEncryptionUtil_Compile.__default.FooterField()))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(357,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((((_4_encryptRes).dtor_value()).dtor_encryptedItem()).get(dafny.DafnySequence.asString("bar")))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_3_inputItem).get(dafny.DafnySequence.asString("bar"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(358,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(!java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((((_4_encryptRes).dtor_value()).dtor_encryptedItem()).get(dafny.DafnySequence.asString("encrypt")))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_3_inputItem).get(dafny.DafnySequence.asString("encrypt"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(359,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((((_4_encryptRes).dtor_value()).dtor_encryptedItem()).get(dafny.DafnySequence.asString("sign")))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_3_inputItem).get(dafny.DafnySequence.asString("sign"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(360,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((((_4_encryptRes).dtor_value()).dtor_encryptedItem()).get(dafny.DafnySequence.asString("nothing")))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_3_inputItem).get(dafny.DafnySequence.asString("nothing"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(361,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _5_decryptRes;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _out3;
    _out3 = (_2_encryptor).DecryptItem(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemInput.create(((_4_encryptRes).dtor_value()).dtor_encryptedItem()));
    _5_decryptRes = _out3;
    if ((_5_decryptRes).is_Failure()) {
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
      System.out.print(java.lang.String.valueOf((_5_decryptRes).dtor_error()));
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
    }
    if (!((_5_decryptRes).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(372,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((_5_decryptRes).dtor_value()).dtor_plaintextItem()).equals(_3_inputItem)) {
      System.out.print((dafny.DafnySequence.asString("\nInput Item :\n")).verbatimString());
      System.out.print(java.lang.String.valueOf(_3_inputItem));
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
      System.out.print((dafny.DafnySequence.asString("\nOutput Item :\n")).verbatimString());
      System.out.print(java.lang.String.valueOf(((_5_decryptRes).dtor_value()).dtor_plaintextItem()));
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
    }
    if (!((((_5_decryptRes).dtor_value()).dtor_plaintextItem()).equals(_3_inputItem))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(377,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.ParsedHeader> _6_parsedHeader;
    _6_parsedHeader = ((_5_decryptRes).dtor_value()).dtor_parsedHeader();
    if (!((_6_parsedHeader).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(380,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((_6_parsedHeader).dtor_value()).dtor_algorithmSuiteId(), ((AlgorithmSuites_Compile.__default.DBE__ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384()).dtor_id()).dtor_DBE()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(381,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((_6_parsedHeader).dtor_value()).dtor_attributeActionsOnEncrypt()).equals(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>subtract(_0_actions, dafny.DafnySet.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.asString("nothing")))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(382,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf((((_6_parsedHeader).dtor_value()).dtor_storedEncryptionContext()).size()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(384,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((_6_parsedHeader).dtor_value()).dtor_storedEncryptionContext()).keySet()).<dafny.DafnySequence<? extends java.lang.Byte>>contains(__default.PublicKeyUtf8()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(385,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf((((_6_parsedHeader).dtor_value()).dtor_encryptedDataKeys()).length()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(386,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> _7_strEC;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> _out4;
    _out4 = StructuredEncryptionUtil_Compile.__default.EcAsString(((_6_parsedHeader).dtor_value()).dtor_encryptionContext());
    _7_strEC = _out4;
    if (!(((_7_strEC).keySet()).<dafny.DafnySequence<? extends Character>>contains(dafny.DafnySequence.asString("aws-crypto-public-key")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(389,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    _7_strEC = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>subtract(_7_strEC, dafny.DafnySet.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.asString("aws-crypto-public-key")));
    if (!((_7_strEC).equals(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-legend"), dafny.DafnySequence.asString("SS")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.bar"), dafny.DafnySequence.asString("key")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.sign"), dafny.DafnySequence.asString("barsoom")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-partition-name"), dafny.DafnySequence.asString("bar")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-table-name"), dafny.DafnySequence.asString("foo")))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(391,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((_6_parsedHeader).dtor_value()).dtor_selectorContext()).equals(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("key"))), new dafny.Tuple2(dafny.DafnySequence.asString("sign"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("barsoom"))), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_table_name"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("foo"))), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_partition_name"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("bar"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(398,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestV2RoundTripSpecial()
  {
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _0_actions;
    _0_actions = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("a.b"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString(".a"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("a."), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString(".a."), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("a[2]"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("a#b"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("$"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("$a"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("$a.b"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("$[a]"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("$['a']"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("$[\"a\"]"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("(a)"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("$['"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("$'a'"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("$\"a\""), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("$(a)"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("$(a"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _1_config;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _out0;
    _out0 = TestFixtures_Compile.__default.GetEncryptorConfigFromActions(_0_actions, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.KeySchemaAttributeName._typeDescriptor()));
    _1_config = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient _2_encryptor;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient _out1;
    _out1 = TestFixtures_Compile.__default.GetDynamoDbItemEncryptorFrom(_1_config);
    _2_encryptor = _out1;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _3_inputItem;
    _3_inputItem = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), __default.DDBS(dafny.DafnySequence.asString("key"))), new dafny.Tuple2(dafny.DafnySequence.asString("a.b"), __default.DDBS(dafny.DafnySequence.asString("aaa"))), new dafny.Tuple2(dafny.DafnySequence.asString(".a"), __default.DDBS(dafny.DafnySequence.asString("bbb"))), new dafny.Tuple2(dafny.DafnySequence.asString("a."), __default.DDBS(dafny.DafnySequence.asString("ccc"))), new dafny.Tuple2(dafny.DafnySequence.asString(".a."), __default.DDBS(dafny.DafnySequence.asString("ddd"))), new dafny.Tuple2(dafny.DafnySequence.asString("a[2]"), __default.DDBS(dafny.DafnySequence.asString("eee"))), new dafny.Tuple2(dafny.DafnySequence.asString("a#b"), __default.DDBS(dafny.DafnySequence.asString("fff"))), new dafny.Tuple2(dafny.DafnySequence.asString("$"), __default.DDBS(dafny.DafnySequence.asString("ggg"))), new dafny.Tuple2(dafny.DafnySequence.asString("$a"), __default.DDBS(dafny.DafnySequence.asString("hhh"))), new dafny.Tuple2(dafny.DafnySequence.asString("$a.b"), __default.DDBS(dafny.DafnySequence.asString("iii"))), new dafny.Tuple2(dafny.DafnySequence.asString("$[a]"), __default.DDBS(dafny.DafnySequence.asString("jjj"))), new dafny.Tuple2(dafny.DafnySequence.asString("$['a']"), __default.DDBS(dafny.DafnySequence.asString("kkk"))), new dafny.Tuple2(dafny.DafnySequence.asString("$[\"a\"]"), __default.DDBS(dafny.DafnySequence.asString("lll"))), new dafny.Tuple2(dafny.DafnySequence.asString("(a)"), __default.DDBS(dafny.DafnySequence.asString("mmm"))), new dafny.Tuple2(dafny.DafnySequence.asString("$['"), __default.DDBS(dafny.DafnySequence.asString("nnn"))), new dafny.Tuple2(dafny.DafnySequence.asString("$'a'"), __default.DDBS(dafny.DafnySequence.asString("ooo"))), new dafny.Tuple2(dafny.DafnySequence.asString("$\"a\""), __default.DDBS(dafny.DafnySequence.asString("ppp"))), new dafny.Tuple2(dafny.DafnySequence.asString("$(a)"), __default.DDBS(dafny.DafnySequence.asString("qqq"))), new dafny.Tuple2(dafny.DafnySequence.asString("$(a"), __default.DDBS(dafny.DafnySequence.asString("rrr"))));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _4_encryptRes;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _out2;
    _out2 = (_2_encryptor).EncryptItem(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemInput.create(_3_inputItem));
    _4_encryptRes = _out2;
    if ((_4_encryptRes).is_Failure()) {
      System.out.print((dafny.DafnySequence.asString("\n\n")).verbatimString());
      System.out.print(java.lang.String.valueOf(_4_encryptRes));
      System.out.print((dafny.DafnySequence.asString("\n\n")).verbatimString());
    }
    if (!((_4_encryptRes).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(464,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((_4_encryptRes).dtor_value()).dtor_encryptedItem()).keySet()).equals(dafny.DafnySet.<dafny.DafnySequence<? extends Character>>union((_3_inputItem).keySet(), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> of(StructuredEncryptionUtil_Compile.__default.HeaderField(), StructuredEncryptionUtil_Compile.__default.FooterField()))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(465,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _5_smallEncrypted;
    _5_smallEncrypted = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>subtract(((_4_encryptRes).dtor_value()).dtor_encryptedItem(), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> of(StructuredEncryptionUtil_Compile.__default.HeaderField(), StructuredEncryptionUtil_Compile.__default.FooterField()));
    if (!((_5_smallEncrypted).equals(_3_inputItem))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(467,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _6_decryptRes;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _out3;
    _out3 = (_2_encryptor).DecryptItem(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemInput.create(((_4_encryptRes).dtor_value()).dtor_encryptedItem()));
    _6_decryptRes = _out3;
    if ((_6_decryptRes).is_Failure()) {
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
      System.out.print(java.lang.String.valueOf((_6_decryptRes).dtor_error()));
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
    }
    if (!((_6_decryptRes).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(478,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((_6_decryptRes).dtor_value()).dtor_plaintextItem()).equals(_3_inputItem)) {
      System.out.print((dafny.DafnySequence.asString("\nInput Item :\n")).verbatimString());
      System.out.print(java.lang.String.valueOf(_3_inputItem));
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
      System.out.print((dafny.DafnySequence.asString("\nOutput Item :\n")).verbatimString());
      System.out.print(java.lang.String.valueOf(((_6_decryptRes).dtor_value()).dtor_plaintextItem()));
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
    }
    if (!((((_6_decryptRes).dtor_value()).dtor_plaintextItem()).equals(_3_inputItem))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(483,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.ParsedHeader> _7_parsedHeader;
    _7_parsedHeader = ((_6_decryptRes).dtor_value()).dtor_parsedHeader();
    if (!((_7_parsedHeader).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(486,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((_7_parsedHeader).dtor_value()).dtor_algorithmSuiteId(), ((AlgorithmSuites_Compile.__default.DBE__ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384()).dtor_id()).dtor_DBE()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(487,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((_7_parsedHeader).dtor_value()).dtor_attributeActionsOnEncrypt()).equals(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>subtract(_0_actions, dafny.DafnySet.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.asString("nothing")))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(488,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf((((_7_parsedHeader).dtor_value()).dtor_storedEncryptionContext()).size()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(490,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((_7_parsedHeader).dtor_value()).dtor_storedEncryptionContext()).keySet()).<dafny.DafnySequence<? extends java.lang.Byte>>contains(__default.PublicKeyUtf8()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(491,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf((((_7_parsedHeader).dtor_value()).dtor_encryptedDataKeys()).length()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(492,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> _8_strEC;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> _out4;
    _out4 = StructuredEncryptionUtil_Compile.__default.EcAsString(((_7_parsedHeader).dtor_value()).dtor_encryptionContext());
    _8_strEC = _out4;
    if (!(((_8_strEC).keySet()).<dafny.DafnySequence<? extends Character>>contains(dafny.DafnySequence.asString("aws-crypto-public-key")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(495,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    _8_strEC = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>subtract(_8_strEC, dafny.DafnySet.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.asString("aws-crypto-public-key")));
    if (!((_8_strEC).equals(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-legend"), dafny.DafnySequence.asString("SSSSSSSSSSSSSSSSSSS")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.bar"), dafny.DafnySequence.asString("key")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.a.b"), dafny.DafnySequence.asString("aaa")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr..a"), dafny.DafnySequence.asString("bbb")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.a."), dafny.DafnySequence.asString("ccc")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr..a."), dafny.DafnySequence.asString("ddd")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.a[2]"), dafny.DafnySequence.asString("eee")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.a#b"), dafny.DafnySequence.asString("fff")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.$"), dafny.DafnySequence.asString("ggg")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.$a"), dafny.DafnySequence.asString("hhh")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.$a.b"), dafny.DafnySequence.asString("iii")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.$[a]"), dafny.DafnySequence.asString("jjj")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.$['a']"), dafny.DafnySequence.asString("kkk")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.$[\"a\"]"), dafny.DafnySequence.asString("lll")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.(a)"), dafny.DafnySequence.asString("mmm")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.$['"), dafny.DafnySequence.asString("nnn")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.$'a'"), dafny.DafnySequence.asString("ooo")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.$\"a\""), dafny.DafnySequence.asString("ppp")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.$(a)"), dafny.DafnySequence.asString("qqq")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.$(a"), dafny.DafnySequence.asString("rrr")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-partition-name"), dafny.DafnySequence.asString("bar")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-table-name"), dafny.DafnySequence.asString("foo")))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(497,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((_7_parsedHeader).dtor_value()).dtor_selectorContext()).equals(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), __default.DDBS(dafny.DafnySequence.asString("key"))), new dafny.Tuple2(dafny.DafnySequence.asString("a.b"), __default.DDBS(dafny.DafnySequence.asString("aaa"))), new dafny.Tuple2(dafny.DafnySequence.asString(".a"), __default.DDBS(dafny.DafnySequence.asString("bbb"))), new dafny.Tuple2(dafny.DafnySequence.asString("a."), __default.DDBS(dafny.DafnySequence.asString("ccc"))), new dafny.Tuple2(dafny.DafnySequence.asString(".a."), __default.DDBS(dafny.DafnySequence.asString("ddd"))), new dafny.Tuple2(dafny.DafnySequence.asString("a[2]"), __default.DDBS(dafny.DafnySequence.asString("eee"))), new dafny.Tuple2(dafny.DafnySequence.asString("a#b"), __default.DDBS(dafny.DafnySequence.asString("fff"))), new dafny.Tuple2(dafny.DafnySequence.asString("$"), __default.DDBS(dafny.DafnySequence.asString("ggg"))), new dafny.Tuple2(dafny.DafnySequence.asString("$a"), __default.DDBS(dafny.DafnySequence.asString("hhh"))), new dafny.Tuple2(dafny.DafnySequence.asString("$a.b"), __default.DDBS(dafny.DafnySequence.asString("iii"))), new dafny.Tuple2(dafny.DafnySequence.asString("$[a]"), __default.DDBS(dafny.DafnySequence.asString("jjj"))), new dafny.Tuple2(dafny.DafnySequence.asString("$['a']"), __default.DDBS(dafny.DafnySequence.asString("kkk"))), new dafny.Tuple2(dafny.DafnySequence.asString("$[\"a\"]"), __default.DDBS(dafny.DafnySequence.asString("lll"))), new dafny.Tuple2(dafny.DafnySequence.asString("(a)"), __default.DDBS(dafny.DafnySequence.asString("mmm"))), new dafny.Tuple2(dafny.DafnySequence.asString("$['"), __default.DDBS(dafny.DafnySequence.asString("nnn"))), new dafny.Tuple2(dafny.DafnySequence.asString("$'a'"), __default.DDBS(dafny.DafnySequence.asString("ooo"))), new dafny.Tuple2(dafny.DafnySequence.asString("$\"a\""), __default.DDBS(dafny.DafnySequence.asString("ppp"))), new dafny.Tuple2(dafny.DafnySequence.asString("$(a)"), __default.DDBS(dafny.DafnySequence.asString("qqq"))), new dafny.Tuple2(dafny.DafnySequence.asString("$(a"), __default.DDBS(dafny.DafnySequence.asString("rrr"))), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_table_name"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("foo"))), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_partition_name"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("bar"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(522,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestRoundTrip()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient _0_encryptor;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient _out0;
    _out0 = TestFixtures_Compile.__default.GetDynamoDbItemEncryptor();
    _0_encryptor = _out0;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _1_inputItem;
    _1_inputItem = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), __default.DDBS(dafny.DafnySequence.asString("key"))), new dafny.Tuple2(dafny.DafnySequence.asString("encrypt"), __default.DDBS(dafny.DafnySequence.asString("text"))), new dafny.Tuple2(dafny.DafnySequence.asString("sign"), __default.DDBS(dafny.DafnySequence.asString("bar"))), new dafny.Tuple2(dafny.DafnySequence.asString("nothing"), __default.DDBS(dafny.DafnySequence.asString("baz"))));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _2_encryptRes;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _out1;
    _out1 = (_0_encryptor).EncryptItem(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemInput.create(_1_inputItem));
    _2_encryptRes = _out1;
    if ((_2_encryptRes).is_Failure()) {
      System.out.print((dafny.DafnySequence.asString("\n\n")).verbatimString());
      System.out.print(java.lang.String.valueOf(_2_encryptRes));
      System.out.print((dafny.DafnySequence.asString("\n\n")).verbatimString());
    }
    if (!((_2_encryptRes).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(566,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((_2_encryptRes).dtor_value()).dtor_encryptedItem()).keySet()).equals(dafny.DafnySet.<dafny.DafnySequence<? extends Character>>union((_1_inputItem).keySet(), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> of(StructuredEncryptionUtil_Compile.__default.HeaderField(), StructuredEncryptionUtil_Compile.__default.FooterField()))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(567,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((((_2_encryptRes).dtor_value()).dtor_encryptedItem()).get(dafny.DafnySequence.asString("bar")))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_1_inputItem).get(dafny.DafnySequence.asString("bar"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(568,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(!java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((((_2_encryptRes).dtor_value()).dtor_encryptedItem()).get(dafny.DafnySequence.asString("encrypt")))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_1_inputItem).get(dafny.DafnySequence.asString("encrypt"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(569,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((((_2_encryptRes).dtor_value()).dtor_encryptedItem()).get(dafny.DafnySequence.asString("sign")))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_1_inputItem).get(dafny.DafnySequence.asString("sign"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(570,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((((_2_encryptRes).dtor_value()).dtor_encryptedItem()).get(dafny.DafnySequence.asString("nothing")))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_1_inputItem).get(dafny.DafnySequence.asString("nothing"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(571,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _3_decryptRes;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _out2;
    _out2 = (_0_encryptor).DecryptItem(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemInput.create(((_2_encryptRes).dtor_value()).dtor_encryptedItem()));
    _3_decryptRes = _out2;
    if (!((_3_decryptRes).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(579,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((_3_decryptRes).dtor_value()).dtor_plaintextItem()).equals(_1_inputItem))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(580,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.ParsedHeader> _4_parsedHeader;
    _4_parsedHeader = ((_3_decryptRes).dtor_value()).dtor_parsedHeader();
    if (!((_4_parsedHeader).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(583,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((_4_parsedHeader).dtor_value()).dtor_algorithmSuiteId(), ((AlgorithmSuites_Compile.__default.DBE__ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384()).dtor_id()).dtor_DBE()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(584,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((_4_parsedHeader).dtor_value()).dtor_attributeActionsOnEncrypt()).equals(TestFixtures_Compile.__default.GetSignedAttributeActions()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(585,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf((((_4_parsedHeader).dtor_value()).dtor_storedEncryptionContext()).size()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(587,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((_4_parsedHeader).dtor_value()).dtor_storedEncryptionContext()).keySet()).<dafny.DafnySequence<? extends java.lang.Byte>>contains(__default.PublicKeyUtf8()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(588,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf((((_4_parsedHeader).dtor_value()).dtor_encryptedDataKeys()).length()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(589,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> _5_strEC;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> _out3;
    _out3 = StructuredEncryptionUtil_Compile.__default.EcAsString(((_4_parsedHeader).dtor_value()).dtor_encryptionContext());
    _5_strEC = _out3;
    if (!(((_5_strEC).keySet()).<dafny.DafnySequence<? extends Character>>contains(dafny.DafnySequence.asString("aws-crypto-public-key")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(597,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    _5_strEC = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>subtract(_5_strEC, dafny.DafnySet.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.asString("aws-crypto-public-key")));
    if (!((_5_strEC).equals(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-attr.bar"), dafny.DafnySequence.asString("AAFrZXk=")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-partition-name"), dafny.DafnySequence.asString("bar")), new dafny.Tuple2(dafny.DafnySequence.asString("aws-crypto-table-name"), dafny.DafnySequence.asString("foo")))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(599,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((_4_parsedHeader).dtor_value()).dtor_selectorContext()).equals(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("key"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(604,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestLargeRoundTrip()
  {
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _0_inputItem;
    _0_inputItem = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), __default.DDBS(dafny.DafnySequence.asString("key"))));
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _1_actions;
    _1_actions = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()));
    java.math.BigInteger _hi0 = java.math.BigInteger.valueOf(500L);
    for (java.math.BigInteger _2_i = java.math.BigInteger.ZERO; _2_i.compareTo(_hi0) < 0; _2_i = _2_i.add(java.math.BigInteger.ONE)) {
      dafny.DafnySequence<? extends Character> _3_str;
      _3_str = StandardLibrary_mString_Compile.__default.Base10Int2String(_2_i);
      if (!(software.amazon.cryptography.services.dynamodb.internaldafny.types.__default.IsValid__AttributeName(_3_str))) {
        throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(612,6): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
      }
      _0_inputItem = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>update(_0_inputItem, _3_str, __default.DDBS(_3_str));
      _1_actions = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>update(_1_actions, _3_str, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN());
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _4_config;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _out0;
    _out0 = TestFixtures_Compile.__default.GetEncryptorConfigFromActions(_1_actions, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.KeySchemaAttributeName._typeDescriptor()));
    _4_config = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient _5_encryptor;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient _out1;
    _out1 = TestFixtures_Compile.__default.GetDynamoDbItemEncryptorFrom(_4_config);
    _5_encryptor = _out1;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _6_encryptRes;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _out2;
    _out2 = (_5_encryptor).EncryptItem(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemInput.create(_0_inputItem));
    _6_encryptRes = _out2;
    if ((_6_encryptRes).is_Failure()) {
      System.out.print((dafny.DafnySequence.asString("\n\n")).verbatimString());
      System.out.print(java.lang.String.valueOf(_6_encryptRes));
      System.out.print((dafny.DafnySequence.asString("\n\n")).verbatimString());
    }
    if (!((_6_encryptRes).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(628,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((_6_encryptRes).dtor_value()).dtor_encryptedItem()).keySet()).equals(dafny.DafnySet.<dafny.DafnySequence<? extends Character>>union((_0_inputItem).keySet(), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> of(StructuredEncryptionUtil_Compile.__default.HeaderField(), StructuredEncryptionUtil_Compile.__default.FooterField()))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(629,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((_6_encryptRes).dtor_value()).dtor_encryptedItem()).<dafny.DafnySequence<? extends Character>>contains(dafny.DafnySequence.asString("bar")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(630,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((_0_inputItem).<dafny.DafnySequence<? extends Character>>contains(dafny.DafnySequence.asString("bar")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(631,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((((_6_encryptRes).dtor_value()).dtor_encryptedItem()).get(dafny.DafnySequence.asString("bar")))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_0_inputItem).get(dafny.DafnySequence.asString("bar"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(632,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _7_decryptRes;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _out3;
    _out3 = (_5_encryptor).DecryptItem(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemInput.create(((_6_encryptRes).dtor_value()).dtor_encryptedItem()));
    _7_decryptRes = _out3;
    if (!((_7_decryptRes).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(640,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((_7_decryptRes).dtor_value()).dtor_plaintextItem()).equals(_0_inputItem))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(641,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.ParsedHeader> _8_parsedHeader;
    _8_parsedHeader = ((_7_decryptRes).dtor_value()).dtor_parsedHeader();
    if (!((_8_parsedHeader).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(644,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((_8_parsedHeader).dtor_value()).dtor_algorithmSuiteId(), ((AlgorithmSuites_Compile.__default.DBE__ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384()).dtor_id()).dtor_DBE()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(645,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf((((_8_parsedHeader).dtor_value()).dtor_storedEncryptionContext()).size()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(647,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((_8_parsedHeader).dtor_value()).dtor_storedEncryptionContext()).keySet()).<dafny.DafnySequence<? extends java.lang.Byte>>contains(__default.PublicKeyUtf8()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(648,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf((((_8_parsedHeader).dtor_value()).dtor_encryptedDataKeys()).length()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(649,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> Actions2()
  {
    return dafny.DafnyMap.fromElements(new dafny.Tuple2(__default.GetAttrName(dafny.DafnySequence.asString("bar")), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(__default.GetAttrName(dafny.DafnySequence.asString("sortKey")), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(__default.GetAttrName(dafny.DafnySequence.asString("encrypt")), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), new dafny.Tuple2(__default.GetAttrName(dafny.DafnySequence.asString("sign")), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), new dafny.Tuple2(__default.GetAttrName(dafny.DafnySequence.asString("sign2")), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(__default.GetAttrName(dafny.DafnySequence.asString("sign3")), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), new dafny.Tuple2(__default.GetAttrName(dafny.DafnySequence.asString("sign4")), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), new dafny.Tuple2(__default.GetAttrName(dafny.DafnySequence.asString("nothing")), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_DO__NOTHING()));
  }
  public static dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> Actions1()
  {
    return dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("sortKey"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("encrypt"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("sign"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("sign2"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), new dafny.Tuple2(dafny.DafnySequence.asString("sign3"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("sign4"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("nothing"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_DO__NOTHING()));
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> PublicKeyUtf8()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 97, (byte) 119, (byte) 115, (byte) 45, (byte) 99, (byte) 114, (byte) 121, (byte) 112, (byte) 116, (byte) 111, (byte) 45, (byte) 112, (byte) 117, (byte) 98, (byte) 108, (byte) 105, (byte) 99, (byte) 45, (byte) 107, (byte) 101, (byte) 121);
    return _0_s;
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDbItemEncryptorTest._default";
  }
}
