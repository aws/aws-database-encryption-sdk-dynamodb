// Class __default
// Dafny class __default compiled into Java
package DynamoDbEncryptionBranchKeyIdSupplierTest_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static void TestHappyCase()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier _0_ddbKeyToBranchKeyId;
    TestBranchKeyIdSupplier _nw0 = new TestBranchKeyIdSupplier();
    _nw0.__ctor();
    _0_ddbKeyToBranchKeyId = _nw0;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
    _out0 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DynamoDbEncryption(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DefaultDynamoDbEncryptionConfig());
    _1_valueOrError0 = _out0;
    if (!(!((_1_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(70,27): " + java.lang.String.valueOf(_1_valueOrError0));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient _2_ddbEncResources;
    _2_ddbEncResources = (_1_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError1 = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
    _out1 = (_2_ddbEncResources).CreateDynamoDbEncryptionBranchKeyIdSupplier(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput.create(_0_ddbKeyToBranchKeyId));
    _3_valueOrError1 = _out1;
    if (!(!((_3_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(71,34): " + java.lang.String.valueOf(_3_valueOrError1));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput _4_branchKeyIdSupplierOut;
    _4_branchKeyIdSupplierOut = (_3_valueOrError1).Extract(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.materialproviders.internaldafny.types.IBranchKeyIdSupplier _5_branchKeyIdSupplier;
    _5_branchKeyIdSupplier = (_4_branchKeyIdSupplierOut).dtor_branchKeyIdSupplier();
    long _6_ttl;
    _6_ttl = (long) (long) (((long) (long) (((long) 1L) * ((long) 60000L))) * ((long) 10L));
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _7_valueOrError2 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out2;
    _out2 = software.amazon.cryptography.materialproviders.internaldafny.__default.MaterialProviders(software.amazon.cryptography.materialproviders.internaldafny.__default.DefaultMaterialProvidersConfig());
    _7_valueOrError2 = _out2;
    if (!(!((_7_valueOrError2).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(79,15): " + java.lang.String.valueOf(_7_valueOrError2));
    }
    software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient _8_mpl;
    _8_mpl = (_7_valueOrError2).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient, software.amazon.cryptography.services.kms.internaldafny.types.Error> _9_valueOrError3 = (Wrappers_Compile.Result<software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient, software.amazon.cryptography.services.kms.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient, software.amazon.cryptography.services.kms.internaldafny.types.Error> _out3;
    _out3 = software.amazon.cryptography.services.kms.internaldafny.__default.KMSClient();
    _9_valueOrError3 = _out3;
    if (!(!((_9_valueOrError3).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient.class)), software.amazon.cryptography.services.kms.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(80,21): " + java.lang.String.valueOf(_9_valueOrError3));
    }
    software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient _10_kmsClient;
    _10_kmsClient = (_9_valueOrError3).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient.class)), software.amazon.cryptography.services.kms.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient, software.amazon.cryptography.services.dynamodb.internaldafny.types.Error> _11_valueOrError4 = (Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient, software.amazon.cryptography.services.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient, software.amazon.cryptography.services.dynamodb.internaldafny.types.Error> _out4;
    _out4 = software.amazon.cryptography.services.dynamodb.internaldafny.__default.DynamoDBClient();
    _11_valueOrError4 = _out4;
    if (!(!((_11_valueOrError4).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient.class)), software.amazon.cryptography.services.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(81,26): " + java.lang.String.valueOf(_11_valueOrError4));
    }
    software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient _12_dynamodbClient;
    _12_dynamodbClient = (_11_valueOrError4).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient.class)), software.amazon.cryptography.services.dynamodb.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.keystore.internaldafny.types.KMSConfiguration _13_kmsConfig;
    _13_kmsConfig = software.amazon.cryptography.keystore.internaldafny.types.KMSConfiguration.create_kmsKeyArn(__default.keyArn());
    software.amazon.cryptography.keystore.internaldafny.types.KeyStoreConfig _14_keyStoreConfig;
    _14_keyStoreConfig = software.amazon.cryptography.keystore.internaldafny.types.KeyStoreConfig.create(__default.branchKeyStoreName(), _13_kmsConfig, __default.logicalKeyStoreName(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient>create_Some(((dafny.TypeDescriptor<software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient.class)), _12_dynamodbClient), Wrappers_Compile.Option.<software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient>create_Some(((dafny.TypeDescriptor<software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient.class)), _10_kmsClient));
    Wrappers_Compile.Result<software.amazon.cryptography.keystore.internaldafny.KeyStoreClient, software.amazon.cryptography.keystore.internaldafny.types.Error> _15_valueOrError5 = (Wrappers_Compile.Result<software.amazon.cryptography.keystore.internaldafny.KeyStoreClient, software.amazon.cryptography.keystore.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.keystore.internaldafny.KeyStoreClient, software.amazon.cryptography.keystore.internaldafny.types.Error> _out5;
    _out5 = software.amazon.cryptography.keystore.internaldafny.__default.KeyStore(_14_keyStoreConfig);
    _15_valueOrError5 = _out5;
    if (!(!((_15_valueOrError5).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.keystore.internaldafny.KeyStoreClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.keystore.internaldafny.KeyStoreClient.class)), software.amazon.cryptography.keystore.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(92,20): " + java.lang.String.valueOf(_15_valueOrError5));
    }
    software.amazon.cryptography.keystore.internaldafny.KeyStoreClient _16_keyStore;
    _16_keyStore = (_15_valueOrError5).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.keystore.internaldafny.KeyStoreClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.keystore.internaldafny.KeyStoreClient.class)), software.amazon.cryptography.keystore.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _17_valueOrError6 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring, software.amazon.cryptography.materialproviders.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out6;
    _out6 = (_8_mpl).CreateAwsKmsHierarchicalKeyring(software.amazon.cryptography.materialproviders.internaldafny.types.CreateAwsKmsHierarchicalKeyringInput.create(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.IBranchKeyIdSupplier>create_Some(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.IBranchKeyIdSupplier>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.IBranchKeyIdSupplier.class)), _5_branchKeyIdSupplier), _16_keyStore, _6_ttl, Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.CacheType>create_None(software.amazon.cryptography.materialproviders.internaldafny.types.CacheType._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))));
    _17_valueOrError6 = _out6;
    if (!(!((_17_valueOrError6).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(93,28): " + java.lang.String.valueOf(_17_valueOrError6));
    }
    software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring _18_hierarchyKeyring;
    _18_hierarchyKeyring = (_17_valueOrError6).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptionMaterials, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _19_valueOrError7 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptionMaterials, software.amazon.cryptography.materialproviders.internaldafny.types.Error>)null;
    _19_valueOrError7 = (_8_mpl).InitializeEncryptionMaterials(software.amazon.cryptography.materialproviders.internaldafny.types.InitializeEncryptionMaterialsInput.create(__default.TEST__DBE__ALG__SUITE__ID(), dafny.DafnyMap.fromElements(new dafny.Tuple2(__default.EC__PARTITION__NAME(), __default.BRANCH__KEY__NAME())), dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> empty(UTF8.ValidUTF8Bytes._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_None(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_None(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()))));
    if (!(!((_19_valueOrError7).IsFailure(software.amazon.cryptography.materialproviders.internaldafny.types.EncryptionMaterials._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(105,21): " + java.lang.String.valueOf(_19_valueOrError7));
    }
    software.amazon.cryptography.materialproviders.internaldafny.types.EncryptionMaterials _20_materials;
    _20_materials = (_19_valueOrError7).Extract(software.amazon.cryptography.materialproviders.internaldafny.types.EncryptionMaterials._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _21_valueOrError8 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>Default(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), UTF8.ValidUTF8Bytes.defaultValue());
    _21_valueOrError8 = UTF8.__default.Encode(Base64_Compile.__default.Encode(__default.CASE__A__BYTES()));
    if (!(!((_21_valueOrError8).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(115,17): " + java.lang.String.valueOf(_21_valueOrError8));
    }
    dafny.DafnySequence<? extends java.lang.Byte> _22_caseA;
    _22_caseA = (_21_valueOrError8).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _23_contextCaseA;
    _23_contextCaseA = dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>update((_20_materials).dtor_encryptionContext(), __default.KEY__ATTR__NAME(), _22_caseA);
    software.amazon.cryptography.materialproviders.internaldafny.types.EncryptionMaterials _24_materialsA;
    software.amazon.cryptography.materialproviders.internaldafny.types.EncryptionMaterials _25_dt__update__tmp_h0 = _20_materials;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _26_dt__update_hencryptionContext_h0 = _23_contextCaseA;
    _24_materialsA = software.amazon.cryptography.materialproviders.internaldafny.types.EncryptionMaterials.create((_25_dt__update__tmp_h0).dtor_algorithmSuite(), _26_dt__update_hencryptionContext_h0, (_25_dt__update__tmp_h0).dtor_encryptedDataKeys(), (_25_dt__update__tmp_h0).dtor_requiredEncryptionContextKeys(), (_25_dt__update__tmp_h0).dtor_plaintextDataKey(), (_25_dt__update__tmp_h0).dtor_signingKey(), (_25_dt__update__tmp_h0).dtor_symmetricSigningKeys());
    __default.TestRoundtrip(_18_hierarchyKeyring, _24_materialsA, __default.TEST__DBE__ALG__SUITE__ID(), __default.BRANCH__KEY__ID__A());
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _27_valueOrError9 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>Default(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), UTF8.ValidUTF8Bytes.defaultValue());
    _27_valueOrError9 = UTF8.__default.Encode(Base64_Compile.__default.Encode(__default.CASE__B__BYTES()));
    if (!(!((_27_valueOrError9).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(121,17): " + java.lang.String.valueOf(_27_valueOrError9));
    }
    dafny.DafnySequence<? extends java.lang.Byte> _28_caseB;
    _28_caseB = (_27_valueOrError9).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _29_contextCaseB;
    _29_contextCaseB = dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>update((_20_materials).dtor_encryptionContext(), __default.KEY__ATTR__NAME(), _28_caseB);
    software.amazon.cryptography.materialproviders.internaldafny.types.EncryptionMaterials _30_materialsB;
    software.amazon.cryptography.materialproviders.internaldafny.types.EncryptionMaterials _31_dt__update__tmp_h1 = _20_materials;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _32_dt__update_hencryptionContext_h1 = _29_contextCaseB;
    _30_materialsB = software.amazon.cryptography.materialproviders.internaldafny.types.EncryptionMaterials.create((_31_dt__update__tmp_h1).dtor_algorithmSuite(), _32_dt__update_hencryptionContext_h1, (_31_dt__update__tmp_h1).dtor_encryptedDataKeys(), (_31_dt__update__tmp_h1).dtor_requiredEncryptionContextKeys(), (_31_dt__update__tmp_h1).dtor_plaintextDataKey(), (_31_dt__update__tmp_h1).dtor_signingKey(), (_31_dt__update__tmp_h1).dtor_symmetricSigningKeys());
    __default.TestRoundtrip(_18_hierarchyKeyring, _30_materialsB, __default.TEST__DBE__ALG__SUITE__ID(), __default.BRANCH__KEY__ID__B());
  }
  public static void TestRoundtrip(software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring hierarchyKeyring, software.amazon.cryptography.materialproviders.internaldafny.types.EncryptionMaterials encryptionMaterialsIn, software.amazon.cryptography.materialproviders.internaldafny.types.AlgorithmSuiteId algorithmSuiteId, dafny.DafnySequence<? extends Character> expectedBranchKeyId)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.OnEncryptOutput, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _0_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.OnEncryptOutput, software.amazon.cryptography.materialproviders.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.OnEncryptOutput, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out0;
    _out0 = (hierarchyKeyring).OnEncrypt(software.amazon.cryptography.materialproviders.internaldafny.types.OnEncryptInput.create(encryptionMaterialsIn));
    _0_valueOrError0 = _out0;
    if (!(!((_0_valueOrError0).IsFailure(software.amazon.cryptography.materialproviders.internaldafny.types.OnEncryptOutput._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(137,34): " + java.lang.String.valueOf(_0_valueOrError0));
    }
    software.amazon.cryptography.materialproviders.internaldafny.types.OnEncryptOutput _1_encryptionMaterialsOut;
    _1_encryptionMaterialsOut = (_0_valueOrError0).Extract(software.amazon.cryptography.materialproviders.internaldafny.types.OnEncryptOutput._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _2_valueOrError1 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out1;
    _out1 = software.amazon.cryptography.materialproviders.internaldafny.__default.MaterialProviders(software.amazon.cryptography.materialproviders.internaldafny.__default.DefaultMaterialProvidersConfig());
    _2_valueOrError1 = _out1;
    if (!(!((_2_valueOrError1).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(141,15): " + java.lang.String.valueOf(_2_valueOrError1));
    }
    software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient _3_mpl;
    _3_mpl = (_2_valueOrError1).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.Tuple0, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _4_valueOrError2 = Wrappers_Compile.Result.<dafny.Tuple0, software.amazon.cryptography.materialproviders.internaldafny.types.Error>Default(dafny.Tuple0._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor(), dafny.Tuple0.Default());
    _4_valueOrError2 = (_3_mpl).EncryptionMaterialsHasPlaintextDataKey((_1_encryptionMaterialsOut).dtor_materials());
    if (!(!((_4_valueOrError2).IsFailure(dafny.Tuple0._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(142,13): " + java.lang.String.valueOf(_4_valueOrError2));
    }
    dafny.Tuple0 _5___v0;
    _5___v0 = (_4_valueOrError2).Extract(dafny.Tuple0._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf((((_1_encryptionMaterialsOut).dtor_materials()).dtor_encryptedDataKeys()).length()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(144,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey _6_edk;
    _6_edk = ((software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey)(java.lang.Object)((((_1_encryptionMaterialsOut).dtor_materials()).dtor_encryptedDataKeys()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))));
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _7_valueOrError3 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>Default(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), UTF8.ValidUTF8Bytes.defaultValue());
    _7_valueOrError3 = UTF8.__default.Encode(expectedBranchKeyId);
    if (!(!((_7_valueOrError3).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(149,35): " + java.lang.String.valueOf(_7_valueOrError3));
    }
    dafny.DafnySequence<? extends java.lang.Byte> _8_expectedBranchKeyIdUTF8;
    _8_expectedBranchKeyIdUTF8 = (_7_valueOrError3).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    if (!(((_6_edk).dtor_keyProviderInfo()).equals(_8_expectedBranchKeyIdUTF8))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(150,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.DecryptionMaterials, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _9_valueOrError4 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.DecryptionMaterials, software.amazon.cryptography.materialproviders.internaldafny.types.Error>)null;
    _9_valueOrError4 = (_3_mpl).InitializeDecryptionMaterials(software.amazon.cryptography.materialproviders.internaldafny.types.InitializeDecryptionMaterialsInput.create(algorithmSuiteId, (encryptionMaterialsIn).dtor_encryptionContext(), dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> empty(UTF8.ValidUTF8Bytes._typeDescriptor())));
    if (!(!((_9_valueOrError4).IsFailure(software.amazon.cryptography.materialproviders.internaldafny.types.DecryptionMaterials._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(152,33): " + java.lang.String.valueOf(_9_valueOrError4));
    }
    software.amazon.cryptography.materialproviders.internaldafny.types.DecryptionMaterials _10_decryptionMaterialsIn;
    _10_decryptionMaterialsIn = (_9_valueOrError4).Extract(software.amazon.cryptography.materialproviders.internaldafny.types.DecryptionMaterials._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.OnDecryptOutput, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _11_valueOrError5 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.OnDecryptOutput, software.amazon.cryptography.materialproviders.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.OnDecryptOutput, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out2;
    _out2 = (hierarchyKeyring).OnDecrypt(software.amazon.cryptography.materialproviders.internaldafny.types.OnDecryptInput.create(_10_decryptionMaterialsIn, dafny.DafnySequence.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> of(software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey._typeDescriptor(), _6_edk)));
    _11_valueOrError5 = _out2;
    if (!(!((_11_valueOrError5).IsFailure(software.amazon.cryptography.materialproviders.internaldafny.types.OnDecryptOutput._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(159,34): " + java.lang.String.valueOf(_11_valueOrError5));
    }
    software.amazon.cryptography.materialproviders.internaldafny.types.OnDecryptOutput _12_decryptionMaterialsOut;
    _12_decryptionMaterialsOut = (_11_valueOrError5).Extract(software.amazon.cryptography.materialproviders.internaldafny.types.OnDecryptOutput._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
    if (!(java.util.Objects.equals(((_1_encryptionMaterialsOut).dtor_materials()).dtor_plaintextDataKey(), ((_12_decryptionMaterialsOut).dtor_materials()).dtor_plaintextDataKey()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(166,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static dafny.DafnySequence<? extends Character> branchKeyStoreName()
  {
    return dafny.DafnySequence.asString("KeyStoreDdbTable");
  }
  public static dafny.DafnySequence<? extends Character> logicalKeyStoreName()
  {
    return __default.branchKeyStoreName();
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> STRING__TYPE__ID()
  {
    return dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 1);
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> CASE__A__BYTES()
  {
    return dafny.DafnySequence.<java.lang.Byte>concatenate(__default.STRING__TYPE__ID(), dafny.DafnySequence.<java.lang.Byte> of((byte) 67, (byte) 65, (byte) 83, (byte) 69, (byte) 95, (byte) 65));
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> CASE__B__BYTES()
  {
    return dafny.DafnySequence.<java.lang.Byte>concatenate(__default.STRING__TYPE__ID(), dafny.DafnySequence.<java.lang.Byte> of((byte) 67, (byte) 65, (byte) 83, (byte) 69, (byte) 95, (byte) 66));
  }
  public static dafny.DafnySequence<? extends Character> BRANCH__KEY__ID()
  {
    return dafny.DafnySequence.asString("3f43a9af-08c5-4317-b694-3d3e883dcaef");
  }
  public static dafny.DafnySequence<? extends Character> BRANCH__KEY__ID__A()
  {
    return __default.BRANCH__KEY__ID();
  }
  public static dafny.DafnySequence<? extends Character> ALTERNATE__BRANCH__KEY__ID()
  {
    return dafny.DafnySequence.asString("4bb57643-07c1-419e-92ad-0df0df149d7c");
  }
  public static dafny.DafnySequence<? extends Character> BRANCH__KEY__ID__B()
  {
    return __default.ALTERNATE__BRANCH__KEY__ID();
  }
  public static dafny.DafnySequence<? extends Character> RESERVED__PREFIX()
  {
    return dafny.DafnySequence.asString("aws-crypto-attr.");
  }
  public static dafny.DafnySequence<? extends Character> BRANCH__KEY()
  {
    return dafny.DafnySequence.asString("branchKey");
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> KEY__ATTR__NAME()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 97, (byte) 119, (byte) 115, (byte) 45, (byte) 99, (byte) 114, (byte) 121, (byte) 112, (byte) 116, (byte) 111, (byte) 45, (byte) 97, (byte) 116, (byte) 116, (byte) 114, (byte) 46, (byte) 98, (byte) 114, (byte) 97, (byte) 110, (byte) 99, (byte) 104, (byte) 75, (byte) 101, (byte) 121);
    return _0_s;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> BRANCH__KEY__NAME()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 98, (byte) 114, (byte) 97, (byte) 110, (byte) 99, (byte) 104, (byte) 75, (byte) 101, (byte) 121);
    return _0_s;
  }
  public static dafny.DafnySequence<? extends Character> keyArn()
  {
    return dafny.DafnySequence.asString("arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126");
  }
  public static software.amazon.cryptography.materialproviders.internaldafny.types.AlgorithmSuiteId TEST__DBE__ALG__SUITE__ID()
  {
    return software.amazon.cryptography.materialproviders.internaldafny.types.AlgorithmSuiteId.create_DBE(software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId.create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__SYMSIG__HMAC__SHA384());
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> EC__PARTITION__NAME()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 97, (byte) 119, (byte) 115, (byte) 45, (byte) 99, (byte) 114, (byte) 121, (byte) 112, (byte) 116, (byte) 111, (byte) 45, (byte) 112, (byte) 97, (byte) 114, (byte) 116, (byte) 105, (byte) 116, (byte) 105, (byte) 111, (byte) 110, (byte) 45, (byte) 110, (byte) 97, (byte) 109, (byte) 101);
    return _0_s;
  }
  public static dafny.DafnySequence<? extends Character> CASE__A()
  {
    return dafny.DafnySequence.asString("CASE_A");
  }
  public static dafny.DafnySequence<? extends Character> CASE__B()
  {
    return dafny.DafnySequence.asString("CASE_B");
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> BRANCH__KEY__ID__UTF8()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 51, (byte) 102, (byte) 52, (byte) 51, (byte) 97, (byte) 57, (byte) 97, (byte) 102, (byte) 45, (byte) 48, (byte) 56, (byte) 99, (byte) 53, (byte) 45, (byte) 52, (byte) 51, (byte) 49, (byte) 55, (byte) 45, (byte) 98, (byte) 54, (byte) 57, (byte) 52, (byte) 45, (byte) 51, (byte) 100, (byte) 51, (byte) 101, (byte) 56, (byte) 56, (byte) 51, (byte) 100, (byte) 99, (byte) 97, (byte) 101, (byte) 102);
    return _0_s;
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDbEncryptionBranchKeyIdSupplierTest._default";
  }
}
