// Class __default
// Dafny class __default compiled into Java
package BeaconTestFixtures_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static <__T> void expect__equal(dafny.TypeDescriptor<__T> _td___T, __T a, __T b)
  {
    if (!java.util.Objects.equals(a, b)) {
      System.out.print((dafny.DafnySequence.asString("Not equal: ")).verbatimString());
      System.out.print(java.lang.String.valueOf(a));
      System.out.print((dafny.DafnySequence.asString(", ")).verbatimString());
      System.out.print(java.lang.String.valueOf(b));
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
    }
    if (!(java.util.Objects.equals(a, b))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(31,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient GetKeyStore()
  {
    software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient output = null;
    Wrappers_Compile.Result<software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient, software.amazon.cryptography.services.kms.internaldafny.types.Error> _0_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient, software.amazon.cryptography.services.kms.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient, software.amazon.cryptography.services.kms.internaldafny.types.Error> _out0;
    _out0 = software.amazon.cryptography.services.kms.internaldafny.__default.KMSClient();
    _0_valueOrError0 = _out0;
    if (!(!((_0_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient.class)), software.amazon.cryptography.services.kms.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(125,21): " + java.lang.String.valueOf(_0_valueOrError0));
    }
    software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient _1_kmsClient;
    _1_kmsClient = (_0_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient.class)), software.amazon.cryptography.services.kms.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient, software.amazon.cryptography.services.dynamodb.internaldafny.types.Error> _2_valueOrError1 = (Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient, software.amazon.cryptography.services.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient, software.amazon.cryptography.services.dynamodb.internaldafny.types.Error> _out1;
    _out1 = software.amazon.cryptography.services.dynamodb.internaldafny.__default.DynamoDBClient();
    _2_valueOrError1 = _out1;
    if (!(!((_2_valueOrError1).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient.class)), software.amazon.cryptography.services.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(126,21): " + java.lang.String.valueOf(_2_valueOrError1));
    }
    software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient _3_ddbClient;
    _3_ddbClient = (_2_valueOrError1).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient.class)), software.amazon.cryptography.services.dynamodb.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.keystore.internaldafny.types.KMSConfiguration _4_kmsConfig;
    _4_kmsConfig = software.amazon.cryptography.keystore.internaldafny.types.KMSConfiguration.create_kmsKeyArn(dafny.DafnySequence.asString("arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126"));
    software.amazon.cryptography.keystore.internaldafny.types.KeyStoreConfig _5_keyStoreConfig;
    _5_keyStoreConfig = software.amazon.cryptography.keystore.internaldafny.types.KeyStoreConfig.create(dafny.DafnySequence.asString("KeyStoreDdbTable"), _4_kmsConfig, dafny.DafnySequence.asString("KeyStoreDdbTable"), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient>create_Some(((dafny.TypeDescriptor<software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient.class)), _3_ddbClient), Wrappers_Compile.Option.<software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient>create_Some(((dafny.TypeDescriptor<software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient.class)), _1_kmsClient));
    Wrappers_Compile.Result<software.amazon.cryptography.keystore.internaldafny.KeyStoreClient, software.amazon.cryptography.keystore.internaldafny.types.Error> _6_valueOrError2 = (Wrappers_Compile.Result<software.amazon.cryptography.keystore.internaldafny.KeyStoreClient, software.amazon.cryptography.keystore.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.keystore.internaldafny.KeyStoreClient, software.amazon.cryptography.keystore.internaldafny.types.Error> _out2;
    _out2 = software.amazon.cryptography.keystore.internaldafny.__default.KeyStore(_5_keyStoreConfig);
    _6_valueOrError2 = _out2;
    if (!(!((_6_valueOrError2).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.keystore.internaldafny.KeyStoreClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.keystore.internaldafny.KeyStoreClient.class)), software.amazon.cryptography.keystore.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(140,17): " + java.lang.String.valueOf(_6_valueOrError2));
    }
    software.amazon.cryptography.keystore.internaldafny.KeyStoreClient _7_store;
    _7_store = (_6_valueOrError2).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.keystore.internaldafny.KeyStoreClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.keystore.internaldafny.KeyStoreClient.class)), software.amazon.cryptography.keystore.internaldafny.types.Error._typeDescriptor());
    output = _7_store;
    return output;
  }
  public static software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient GetBadKeyStore()
  {
    software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient output = null;
    Wrappers_Compile.Result<software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient, software.amazon.cryptography.services.kms.internaldafny.types.Error> _0_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient, software.amazon.cryptography.services.kms.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient, software.amazon.cryptography.services.kms.internaldafny.types.Error> _out0;
    _out0 = software.amazon.cryptography.services.kms.internaldafny.__default.KMSClient();
    _0_valueOrError0 = _out0;
    if (!(!((_0_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient.class)), software.amazon.cryptography.services.kms.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(152,21): " + java.lang.String.valueOf(_0_valueOrError0));
    }
    software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient _1_kmsClient;
    _1_kmsClient = (_0_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient.class)), software.amazon.cryptography.services.kms.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient, software.amazon.cryptography.services.dynamodb.internaldafny.types.Error> _2_valueOrError1 = (Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient, software.amazon.cryptography.services.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient, software.amazon.cryptography.services.dynamodb.internaldafny.types.Error> _out1;
    _out1 = software.amazon.cryptography.services.dynamodb.internaldafny.__default.DynamoDBClient();
    _2_valueOrError1 = _out1;
    if (!(!((_2_valueOrError1).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient.class)), software.amazon.cryptography.services.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(153,21): " + java.lang.String.valueOf(_2_valueOrError1));
    }
    software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient _3_ddbClient;
    _3_ddbClient = (_2_valueOrError1).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient.class)), software.amazon.cryptography.services.dynamodb.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.keystore.internaldafny.types.KMSConfiguration _4_kmsConfig;
    _4_kmsConfig = software.amazon.cryptography.keystore.internaldafny.types.KMSConfiguration.create_kmsKeyArn(dafny.DafnySequence.asString("arn:aws:kms:us-west-2:370957321024:key/bad-arn"));
    software.amazon.cryptography.keystore.internaldafny.types.KeyStoreConfig _5_keyStoreConfig;
    _5_keyStoreConfig = software.amazon.cryptography.keystore.internaldafny.types.KeyStoreConfig.create(dafny.DafnySequence.asString("bad-table-name"), _4_kmsConfig, dafny.DafnySequence.asString("KeyStoreDdbTable"), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient>create_Some(((dafny.TypeDescriptor<software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient.class)), _3_ddbClient), Wrappers_Compile.Option.<software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient>create_Some(((dafny.TypeDescriptor<software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.services.kms.internaldafny.types.IKMSClient.class)), _1_kmsClient));
    Wrappers_Compile.Result<software.amazon.cryptography.keystore.internaldafny.KeyStoreClient, software.amazon.cryptography.keystore.internaldafny.types.Error> _6_valueOrError2 = (Wrappers_Compile.Result<software.amazon.cryptography.keystore.internaldafny.KeyStoreClient, software.amazon.cryptography.keystore.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.keystore.internaldafny.KeyStoreClient, software.amazon.cryptography.keystore.internaldafny.types.Error> _out2;
    _out2 = software.amazon.cryptography.keystore.internaldafny.__default.KeyStore(_5_keyStoreConfig);
    _6_valueOrError2 = _out2;
    if (!(!((_6_valueOrError2).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.keystore.internaldafny.KeyStoreClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.keystore.internaldafny.KeyStoreClient.class)), software.amazon.cryptography.keystore.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(171,17): " + java.lang.String.valueOf(_6_valueOrError2));
    }
    software.amazon.cryptography.keystore.internaldafny.KeyStoreClient _7_store;
    _7_store = (_6_valueOrError2).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.keystore.internaldafny.KeyStoreClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.keystore.internaldafny.KeyStoreClient.class)), software.amazon.cryptography.keystore.internaldafny.types.Error._typeDescriptor());
    output = _7_store;
    return output;
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion GetEmptyBeacons()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion output = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion)null;
    software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient _0_store;
    software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient _out0;
    _out0 = __default.GetKeyStore();
    _0_store = _out0;
    output = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create(1, _0_store, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconKeySource.create_single(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SingleKeyStore.create(dafny.DafnySequence.asString("foo"), 42, Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.CacheType>create_None(software.amazon.cryptography.materialproviders.internaldafny.types.CacheType._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)))), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), __default.std2()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeaconList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualFieldList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPartsList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPartsList._typeDescriptor()));
    return output;
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion GetLotsaBeacons()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion output = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion)null;
    software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient _0_store;
    software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient _out0;
    _out0 = __default.GetKeyStore();
    _0_store = _out0;
    output = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create(1, _0_store, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconKeySource.create_single(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SingleKeyStore.create(dafny.DafnySequence.asString("foo"), 42, Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.CacheType>create_None(software.amazon.cryptography.materialproviders.internaldafny.types.CacheType._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)))), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), __default.std2(), __default.std4(), __default.std6(), __default.NameTitleBeacon(), __default.NameB(), __default.TitleB()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor(), __default.NameTitle(), __default.YearName(), __default.Mixed(), __default.JustSigned())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField._typeDescriptor(), __default.NameTitleField())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPartsList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPartsList._typeDescriptor()));
    return output;
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion GetLotsaBeaconsMulti()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion output = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion)null;
    software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient _0_store;
    software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient _out0;
    _out0 = __default.GetKeyStore();
    _0_store = _out0;
    output = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create(1, _0_store, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconKeySource.create_multi(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.MultiKeyStore.create(dafny.DafnySequence.asString("TheKeyField"), 42, Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.CacheType>create_None(software.amazon.cryptography.materialproviders.internaldafny.types.CacheType._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)))), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), __default.std2(), __default.std4(), __default.std6(), __default.NameTitleBeacon(), __default.NameB(), __default.TitleB()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor(), __default.NameTitle(), __default.YearName(), __default.Mixed(), __default.JustSigned())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField._typeDescriptor(), __default.NameTitleField())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPartsList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPartsList._typeDescriptor()));
    return output;
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion GetLotsaBeaconsSingleWithSharedCache(software.amazon.cryptography.materialproviders.internaldafny.types.CacheType cache, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> partitionId)
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion output = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion)null;
    software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient _0_store;
    software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient _out0;
    _out0 = __default.GetKeyStore();
    _0_store = _out0;
    output = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create(1, _0_store, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconKeySource.create_single(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SingleKeyStore.create(dafny.DafnySequence.asString("040a32a8-3737-4f16-a3ba-bd4449556d73"), 42, Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.CacheType>create_Some(software.amazon.cryptography.materialproviders.internaldafny.types.CacheType._typeDescriptor(), cache), partitionId)), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), __default.std2(), __default.std4(), __default.std6(), __default.NameTitleBeacon(), __default.NameB(), __default.TitleB()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor(), __default.NameTitle(), __default.YearName(), __default.Mixed(), __default.JustSigned())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField._typeDescriptor(), __default.NameTitleField())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPartsList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPartsList._typeDescriptor()));
    return output;
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion GetLotsaBeaconsSingleWithSharedCacheWithBadKeyStore(software.amazon.cryptography.materialproviders.internaldafny.types.CacheType cache, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> partitionId)
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion output = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion)null;
    software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient _0_store;
    software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient _out0;
    _out0 = __default.GetBadKeyStore();
    _0_store = _out0;
    output = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create(1, _0_store, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconKeySource.create_single(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SingleKeyStore.create(dafny.DafnySequence.asString("040a32a8-3737-4f16-a3ba-bd4449556d73"), 42, Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.CacheType>create_Some(software.amazon.cryptography.materialproviders.internaldafny.types.CacheType._typeDescriptor(), cache), partitionId)), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), __default.std2(), __default.std4(), __default.std6(), __default.NameTitleBeacon(), __default.NameB(), __default.TitleB()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor(), __default.NameTitle(), __default.YearName(), __default.Mixed(), __default.JustSigned())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField._typeDescriptor(), __default.NameTitleField())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPartsList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPartsList._typeDescriptor()));
    return output;
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion GetLotsaBeaconsMultiWithSharedCache(software.amazon.cryptography.materialproviders.internaldafny.types.CacheType cache, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> partitionId)
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion output = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion)null;
    software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient _0_store;
    software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient _out0;
    _out0 = __default.GetKeyStore();
    _0_store = _out0;
    output = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create(1, _0_store, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconKeySource.create_multi(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.MultiKeyStore.create(dafny.DafnySequence.asString("TheKeyField"), 42, Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.CacheType>create_Some(software.amazon.cryptography.materialproviders.internaldafny.types.CacheType._typeDescriptor(), cache), partitionId)), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), __default.std2(), __default.std4(), __default.std6(), __default.NameTitleBeacon(), __default.NameB(), __default.TitleB()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor(), __default.NameTitle(), __default.YearName(), __default.Mixed(), __default.JustSigned())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField._typeDescriptor(), __default.NameTitleField())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPartsList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPartsList._typeDescriptor()));
    return output;
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion GetLotsaBeaconsMultiWithSharedCacheWithBadKeyStore(software.amazon.cryptography.materialproviders.internaldafny.types.CacheType cache, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> partitionId)
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion output = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion)null;
    software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient _0_store;
    software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient _out0;
    _out0 = __default.GetBadKeyStore();
    _0_store = _out0;
    output = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create(1, _0_store, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconKeySource.create_multi(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.MultiKeyStore.create(dafny.DafnySequence.asString("TheKeyField"), 42, Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.CacheType>create_Some(software.amazon.cryptography.materialproviders.internaldafny.types.CacheType._typeDescriptor(), cache), partitionId)), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), __default.std2(), __default.std4(), __default.std6(), __default.NameTitleBeacon(), __default.NameB(), __default.TitleB()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor(), __default.NameTitle(), __default.YearName(), __default.Mixed(), __default.JustSigned())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField._typeDescriptor(), __default.NameTitleField())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPartsList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPartsList._typeDescriptor()));
    return output;
  }
  public static software.amazon.cryptography.materialproviders.internaldafny.types.CacheType GetSharedCache()
  {
    software.amazon.cryptography.materialproviders.internaldafny.types.CacheType cache = (software.amazon.cryptography.materialproviders.internaldafny.types.CacheType)null;
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _0_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error>)null;
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out0;
      _out0 = software.amazon.cryptography.materialproviders.internaldafny.__default.MaterialProviders(software.amazon.cryptography.materialproviders.internaldafny.__default.DefaultMaterialProvidersConfig());
      _0_valueOrError0 = _out0;
      if (!(!((_0_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())))) {
        throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(330,15): " + java.lang.String.valueOf(_0_valueOrError0));
      }
      software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient _1_mpl;
      _1_mpl = (_0_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _2_valueOrError1 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache, software.amazon.cryptography.materialproviders.internaldafny.types.Error>)null;
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out1;
      _out1 = (_1_mpl).CreateCryptographicMaterialsCache(software.amazon.cryptography.materialproviders.internaldafny.types.CreateCryptographicMaterialsCacheInput.create(software.amazon.cryptography.materialproviders.internaldafny.types.CacheType.create_Default(software.amazon.cryptography.materialproviders.internaldafny.types.DefaultCache.create(100))));
      _2_valueOrError1 = _out1;
      if (!(!((_2_valueOrError1).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())))) {
        throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(332,23): " + java.lang.String.valueOf(_2_valueOrError1));
      }
      software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache _3_sharedCache;
      _3_sharedCache = (_2_valueOrError1).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
      cache = software.amazon.cryptography.materialproviders.internaldafny.types.CacheType.create_Shared(_3_sharedCache);
    }
    return cache;
  }
  public static SearchableEncryptionInfo_Compile.KeySource GetLiteralSource(dafny.DafnySequence<? extends java.lang.Byte> key, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion version)
  {
    SearchableEncryptionInfo_Compile.KeySource output = (SearchableEncryptionInfo_Compile.KeySource)null;
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _0_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _out0;
    _out0 = software.amazon.cryptography.primitives.internaldafny.__default.AtomicPrimitives(software.amazon.cryptography.primitives.internaldafny.__default.DefaultCryptoConfig());
    _0_valueOrError0 = _out0;
    if (!(!((_0_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(385,18): " + java.lang.String.valueOf(_0_valueOrError0));
    }
    software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient _1_client;
    _1_client = (_0_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor());
    dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _2_keyNameSet;
    _2_keyNameSet = ((java.util.function.Function<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(_3_version) -> ((dafny.Function0<dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(() -> {
      java.util.ArrayList<dafny.DafnySequence<? extends Character>> _coll0 = new java.util.ArrayList<>();
      for (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon _compr_0_boxed0 : ((_3_version).dtor_standardBeacons()).Elements()) {
        software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon _compr_0 = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon)(java.lang.Object)(_compr_0_boxed0));
        software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon _4_b = (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon)_compr_0;
        if (((_3_version).dtor_standardBeacons()).contains(_4_b)) {
          _coll0.add((_4_b).dtor_name());
        }
      }
      return new dafny.DafnySet<dafny.DafnySequence<? extends Character>>(_coll0);
    })).apply()).apply(version);
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _5_keyNames;
    _5_keyNames = SortedSets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, _2_keyNameSet, DynamoDbEncryptionUtil_Compile.__default::CharLess);
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
    _out1 = SearchableEncryptionInfo_Compile.__default.GetHmacKeys(_1_client, _5_keyNames, _5_keyNames, key, dafny.DafnyMap.fromElements());
    _6_valueOrError1 = _out1;
    if (!(!((_6_valueOrError1).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(389,16): " + java.lang.String.valueOf(_6_valueOrError1));
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _7_keys;
    _7_keys = (_6_valueOrError1).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _8_valueOrError2 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out2;
    _out2 = software.amazon.cryptography.materialproviders.internaldafny.__default.MaterialProviders(software.amazon.cryptography.materialproviders.internaldafny.__default.DefaultMaterialProvidersConfig());
    _8_valueOrError2 = _out2;
    if (!(!((_8_valueOrError2).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(390,15): " + java.lang.String.valueOf(_8_valueOrError2));
    }
    software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient _9_mpl;
    _9_mpl = (_8_valueOrError2).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.materialproviders.internaldafny.types.CreateCryptographicMaterialsCacheInput _10_input;
    _10_input = software.amazon.cryptography.materialproviders.internaldafny.types.CreateCryptographicMaterialsCacheInput.create(software.amazon.cryptography.materialproviders.internaldafny.types.CacheType.create_Default(software.amazon.cryptography.materialproviders.internaldafny.types.DefaultCache.create(3)));
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _11_valueOrError3 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache, software.amazon.cryptography.materialproviders.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out3;
    _out3 = (_9_mpl).CreateCryptographicMaterialsCache(_10_input);
    _11_valueOrError3 = _out3;
    if (!(!((_11_valueOrError3).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(394,17): " + java.lang.String.valueOf(_11_valueOrError3));
    }
    software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache _12_cache;
    _12_cache = (_11_valueOrError3).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _13_valueOrError4 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out4;
    _out4 = SearchableEncryptionInfo_Compile.__default.GenerateUuidBytes();
    _13_valueOrError4 = _out4;
    if (!(!((_13_valueOrError4).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(396,41): " + java.lang.String.valueOf(_13_valueOrError4));
    }
    dafny.DafnySequence<? extends java.lang.Byte> _14_partitionIdBytes;
    _14_partitionIdBytes = (_13_valueOrError4).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _15_valueOrError5 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out5;
    _out5 = SearchableEncryptionInfo_Compile.__default.GenerateUuidBytes();
    _15_valueOrError5 = _out5;
    if (!(!((_15_valueOrError5).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(407,49): " + java.lang.String.valueOf(_15_valueOrError5));
    }
    dafny.DafnySequence<? extends java.lang.Byte> _16_logicalKeyStoreNameBytes;
    _16_logicalKeyStoreNameBytes = (_15_valueOrError5).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    output = SearchableEncryptionInfo_Compile.KeySource.create(_1_client, (version).dtor_keyStore(), SearchableEncryptionInfo_Compile.KeyLocation.create_LiteralLoc(_7_keys), _12_cache, 0, _14_partitionIdBytes, _16_logicalKeyStoreNameBytes);
    return output;
  }
  public static SearchableEncryptionInfo_Compile.KeySource GetMultiSource(dafny.DafnySequence<? extends Character> keyName, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion version)
  {
    SearchableEncryptionInfo_Compile.KeySource output = (SearchableEncryptionInfo_Compile.KeySource)null;
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _0_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _out0;
    _out0 = software.amazon.cryptography.primitives.internaldafny.__default.AtomicPrimitives(software.amazon.cryptography.primitives.internaldafny.__default.DefaultCryptoConfig());
    _0_valueOrError0 = _out0;
    if (!(!((_0_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(421,18): " + java.lang.String.valueOf(_0_valueOrError0));
    }
    software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient _1_client;
    _1_client = (_0_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _2_valueOrError1 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out1;
    _out1 = software.amazon.cryptography.materialproviders.internaldafny.__default.MaterialProviders(software.amazon.cryptography.materialproviders.internaldafny.__default.DefaultMaterialProvidersConfig());
    _2_valueOrError1 = _out1;
    if (!(!((_2_valueOrError1).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(422,15): " + java.lang.String.valueOf(_2_valueOrError1));
    }
    software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient _3_mpl;
    _3_mpl = (_2_valueOrError1).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.materialproviders.internaldafny.types.CreateCryptographicMaterialsCacheInput _4_input;
    _4_input = software.amazon.cryptography.materialproviders.internaldafny.types.CreateCryptographicMaterialsCacheInput.create(software.amazon.cryptography.materialproviders.internaldafny.types.CacheType.create_Default(software.amazon.cryptography.materialproviders.internaldafny.types.DefaultCache.create(3)));
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _5_valueOrError2 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache, software.amazon.cryptography.materialproviders.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out2;
    _out2 = (_3_mpl).CreateCryptographicMaterialsCache(_4_input);
    _5_valueOrError2 = _out2;
    if (!(!((_5_valueOrError2).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(426,17): " + java.lang.String.valueOf(_5_valueOrError2));
    }
    software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache _6_cache;
    _6_cache = (_5_valueOrError2).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _7_valueOrError3 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out3;
    _out3 = SearchableEncryptionInfo_Compile.__default.GenerateUuidBytes();
    _7_valueOrError3 = _out3;
    if (!(!((_7_valueOrError3).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(428,41): " + java.lang.String.valueOf(_7_valueOrError3));
    }
    dafny.DafnySequence<? extends java.lang.Byte> _8_partitionIdBytes;
    _8_partitionIdBytes = (_7_valueOrError3).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _9_valueOrError4 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out4;
    _out4 = SearchableEncryptionInfo_Compile.__default.GenerateUuidBytes();
    _9_valueOrError4 = _out4;
    if (!(!((_9_valueOrError4).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(439,49): " + java.lang.String.valueOf(_9_valueOrError4));
    }
    dafny.DafnySequence<? extends java.lang.Byte> _10_logicalKeyStoreNameBytes;
    _10_logicalKeyStoreNameBytes = (_9_valueOrError4).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    output = SearchableEncryptionInfo_Compile.KeySource.create(_1_client, (version).dtor_keyStore(), SearchableEncryptionInfo_Compile.KeyLocation.create_MultiLoc(keyName, false), _6_cache, 0, _8_partitionIdBytes, _10_logicalKeyStoreNameBytes);
    return output;
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart Name()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart.create(dafny.DafnySequence.asString("Name"), dafny.DafnySequence.asString("N_"));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart Title()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart.create(dafny.DafnySequence.asString("Title"), dafny.DafnySequence.asString("T_"));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon NameTitle()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon.create(dafny.DafnySequence.asString("NameTitle"), dafny.DafnySequence.asString("."), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor(), __default.Name(), __default.Title())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPartsList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorList._typeDescriptor()));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart Year()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart.create(dafny.DafnySequence.asString("Year"), dafny.DafnySequence.asString("Y_"), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.TerminalLocation._typeDescriptor()));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon YearName()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon.create(dafny.DafnySequence.asString("YearName"), dafny.DafnySequence.asString("."), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor(), __default.Name())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart._typeDescriptor(), __default.Year())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorList._typeDescriptor()));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart TooBad()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart.create(dafny.DafnySequence.asString("TooBad"), dafny.DafnySequence.asString("T"));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon BadPrefix()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon.create(dafny.DafnySequence.asString("BadPrefix"), dafny.DafnySequence.asString("."), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor(), __default.Name(), __default.Title(), __default.TooBad())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPartsList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorList._typeDescriptor()));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart Nothing()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart.create(dafny.DafnySequence.asString("Nothing"), dafny.DafnySequence.asString("N__"), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.TerminalLocation._typeDescriptor()));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon BadPrefix2()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon.create(dafny.DafnySequence.asString("BadPrefix2"), dafny.DafnySequence.asString("."), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor(), __default.Name())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart._typeDescriptor(), __default.Nothing())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorList._typeDescriptor()));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart Month()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart.create(dafny.DafnySequence.asString("Month"), dafny.DafnySequence.asString("M_"), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Date.Month")));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon JustSigned()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon.create(dafny.DafnySequence.asString("JustSigned"), dafny.DafnySequence.asString("."), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPartsList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart._typeDescriptor(), __default.Year(), __default.Month())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorList._typeDescriptor()));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon Mixed()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon.create(dafny.DafnySequence.asString("Mixed"), dafny.DafnySequence.asString("."), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor(), __default.Name(), __default.Title())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart._typeDescriptor(), __default.Year(), __default.Month())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor.create(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart.create(dafny.DafnySequence.asString("Name"), true), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart.create(dafny.DafnySequence.asString("Year"), true))), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor.create(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart.create(dafny.DafnySequence.asString("Title"), true), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart.create(dafny.DafnySequence.asString("Month"), false))))));
  }
  public static software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue Std6String()
  {
    return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("666"));
  }
  public static software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue Std6List()
  {
    return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_L(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), __default.Std6String()));
  }
  public static software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue MonthString()
  {
    return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("May"));
  }
  public static software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue YearString()
  {
    return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(dafny.DafnySequence.asString("1984"));
  }
  public static software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue DateMap()
  {
    return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_M(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("Month"), __default.MonthString()), new dafny.Tuple2(dafny.DafnySequence.asString("Year"), __default.YearString())));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart VPart1()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart.create(dafny.DafnySequence.asString("Name"), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_insert(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Insert.create(dafny.DafnySequence.asString("__"))))));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart VPart2()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart.create(dafny.DafnySequence.asString("Title"), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform.create_lower(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Lower.create()))));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField NameTitleField()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField.create(dafny.DafnySequence.asString("NameTitleField"), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart._typeDescriptor(), __default.VPart1(), __default.VPart2()));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField NameVirtField()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField.create(dafny.DafnySequence.asString("NameVirtField"), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart._typeDescriptor(), __default.VPart1()));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon std2()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("std2"), 24, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.TerminalLocation._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor()));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon std4()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("std4"), 24, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("std4")), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor()));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon std6()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("std6"), 26, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("std6[0]")), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor()));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon NameTitleBeacon()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("NameTitleField"), 28, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.TerminalLocation._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor()));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon NameB()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("Name"), 32, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.TerminalLocation._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor()));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon TitleB()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("Title"), 32, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.TerminalLocation._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor()));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig EmptyTableConfig()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig.create(dafny.DafnySequence.asString("Foo"), dafny.DafnySequence.asString("foo"), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.KeySchemaAttributeName._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SearchConfig>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SearchConfig._typeDescriptor()), dafny.DafnyMap.fromElements(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeNameList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId>create_None(software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>create_None(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring.class))), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>create_None(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager.class))), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyOverride>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyOverride._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride._typeDescriptor()));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig FullTableConfig()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _0_dt__update__tmp_h0 = __default.EmptyTableConfig();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _1_dt__update_hattributeActionsOnEncrypt_h0 = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("std2"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("std4"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("std6"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("Name"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("Title"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("TooBad"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("Year"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), new dafny.Tuple2(dafny.DafnySequence.asString("Date"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), new dafny.Tuple2(dafny.DafnySequence.asString("TheKeyField"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()));
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig.create((_0_dt__update__tmp_h0).dtor_logicalTableName(), (_0_dt__update__tmp_h0).dtor_partitionKeyName(), (_0_dt__update__tmp_h0).dtor_sortKeyName(), (_0_dt__update__tmp_h0).dtor_search(), _1_dt__update_hattributeActionsOnEncrypt_h0, (_0_dt__update__tmp_h0).dtor_allowedUnsignedAttributes(), (_0_dt__update__tmp_h0).dtor_allowedUnsignedAttributePrefix(), (_0_dt__update__tmp_h0).dtor_algorithmSuiteId(), (_0_dt__update__tmp_h0).dtor_keyring(), (_0_dt__update__tmp_h0).dtor_cmm(), (_0_dt__update__tmp_h0).dtor_legacyOverride(), (_0_dt__update__tmp_h0).dtor_plaintextOverride());
  }
  public static software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue Std2String()
  {
    return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(dafny.DafnySequence.asString("1.23"));
  }
  public static software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue Std4String()
  {
    return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("abc"));
  }
  public static software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue NameString()
  {
    return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("MyName"));
  }
  public static software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue TitleString()
  {
    return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("MyTitle"));
  }
  public static dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> SimpleItem()
  {
    return dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("std2"), __default.Std2String()), new dafny.Tuple2(dafny.DafnySequence.asString("std4"), __default.Std4String()), new dafny.Tuple2(dafny.DafnySequence.asString("std6"), __default.Std6List()), new dafny.Tuple2(dafny.DafnySequence.asString("Date"), __default.DateMap()), new dafny.Tuple2(dafny.DafnySequence.asString("Year"), __default.YearString()), new dafny.Tuple2(dafny.DafnySequence.asString("Name"), __default.NameString()), new dafny.Tuple2(dafny.DafnySequence.asString("Title"), __default.TitleString()));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon TooBadB()
  {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("TooBad"), 32, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.TerminalLocation._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor()));
  }
  public static dafny.DafnySequence<? extends Character> std2__beacon()
  {
    return dafny.DafnySequence.asString("ac6f5d");
  }
  public static dafny.DafnySequence<? extends Character> Name__beacon()
  {
    return dafny.DafnySequence.asString("7d9bfa40");
  }
  public static dafny.DafnySequence<? extends Character> Title__beacon()
  {
    return dafny.DafnySequence.asString("e4feb833");
  }
  public static dafny.DafnySequence<? extends Character> std4__beacon()
  {
    return dafny.DafnySequence.asString("0e9064");
  }
  public static dafny.DafnySequence<? extends Character> std6__beacon()
  {
    return dafny.DafnySequence.asString("2d99222");
  }
  public static dafny.DafnySequence<? extends Character> NameTitle__beacon()
  {
    return dafny.DafnySequence.asString("4c577d7");
  }
  public static dafny.DafnySequence<? extends Character> EmptyName__beacon()
  {
    return dafny.DafnySequence.asString("e0e88994");
  }
  public static dafny.DafnySequence<? extends Character> EmptyTitle__beacon()
  {
    return dafny.DafnySequence.asString("af34f26f");
  }
  @Override
  public java.lang.String toString() {
    return "BeaconTestFixtures._default";
  }
}
