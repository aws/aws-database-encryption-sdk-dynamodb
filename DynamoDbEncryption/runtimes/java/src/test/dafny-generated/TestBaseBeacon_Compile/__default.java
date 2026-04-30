// Class __default
// Dafny class __default compiled into Java
package TestBaseBeacon_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static void TestBeacon()
  {
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _0_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _out0;
    _out0 = software.amazon.cryptography.primitives.internaldafny.__default.AtomicPrimitives(software.amazon.cryptography.primitives.internaldafny.__default.DefaultCryptoConfig());
    _0_valueOrError0 = _out0;
    if (!(!((_0_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(27,22): " + java.lang.String.valueOf(_0_valueOrError0));
    }
    software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient _1_primitives;
    _1_primitives = (_0_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor());
    BaseBeacon_Compile.BeaconBase _2_bb;
    _2_bb = BaseBeacon_Compile.BeaconBase.create(_1_primitives, dafny.DafnySequence.asString("foo"), dafny.DafnySequence.asString("aws_dbe_b_foo"));
    BaseBeacon_Compile.StandardBeacon _3_b;
    _3_b = BaseBeacon_Compile.StandardBeacon.create(_2_bb, (byte) 8, TermLoc_Compile.__default.TermLocMap(dafny.DafnySequence.asString("foo")), false, false, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
    _4_valueOrError1 = (_2_bb).getHmac(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2));
    if (!(!((_4_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(31,17): " + java.lang.String.valueOf(_4_valueOrError1));
    }
    dafny.DafnySequence<? extends java.lang.Byte> _5_bytes;
    _5_bytes = (_4_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!((_5_bytes).equals(dafny.DafnySequence.<java.lang.Byte> of((byte) 39, (byte) 147, (byte) 147, (byte) 139, (byte) 38, (byte) 233, (byte) 82, (byte) 126)))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(32,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_valueOrError2 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
    _6_valueOrError2 = (_3_b).hash(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2));
    if (!(!((_6_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(33,15): " + java.lang.String.valueOf(_6_valueOrError2));
    }
    dafny.DafnySequence<? extends Character> _7_str;
    _7_str = (_6_valueOrError2).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!((_7_str).equals(dafny.DafnySequence.asString("7e")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(34,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _8_valueOrError3 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
    _8_valueOrError3 = (_2_bb).getHmac(dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2));
    if (!(!((_8_valueOrError3).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(35,13): " + java.lang.String.valueOf(_8_valueOrError3));
    }
    _5_bytes = (_8_valueOrError3).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!((((byte)(java.lang.Object)((_5_bytes).select(dafny.Helpers.toInt((java.math.BigInteger.valueOf(7L))))))) == ((byte) 128))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(36,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _9_valueOrError4 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
    _9_valueOrError4 = (_3_b).hash(dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2));
    if (!(!((_9_valueOrError4).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(37,11): " + java.lang.String.valueOf(_9_valueOrError4));
    }
    _7_str = (_9_valueOrError4).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!((_7_str).equals(dafny.DafnySequence.asString("80")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(38,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _10_valueOrError5 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
    _10_valueOrError5 = (_2_bb).getHmac(__default.x123(), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2));
    if (!(!((_10_valueOrError5).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(39,13): " + java.lang.String.valueOf(_10_valueOrError5));
    }
    _5_bytes = (_10_valueOrError5).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!((((byte)(java.lang.Object)((_5_bytes).select(dafny.Helpers.toInt((java.math.BigInteger.valueOf(7L))))))) == ((byte) 97))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(40,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestBadPrefix()
  {
    software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient _0_store;
    software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetKeyStore();
    _0_store = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _1_version;
    _1_version = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create(1, _0_store, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconKeySource.create_single(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SingleKeyStore.create(dafny.DafnySequence.asString("foo"), 42, Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.CacheType>create_None(software.amazon.cryptography.materialproviders.internaldafny.types.CacheType._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)))), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), BeaconTestFixtures_Compile.__default.NameB(), BeaconTestFixtures_Compile.__default.TitleB(), BeaconTestFixtures_Compile.__default.TooBadB()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor(), BeaconTestFixtures_Compile.__default.BadPrefix())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualFieldList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPartsList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPartsList._typeDescriptor()));
    SearchableEncryptionInfo_Compile.KeySource _2_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _1_version);
    _2_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_res;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _1_version, _2_src);
    _3_res = _out2;
    if (!((_3_res).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(58,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    BeaconTestFixtures_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>expect__equal(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (_3_res).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Compound beacon BadPrefix defines part Title with prefix T_ which is incompatible with part TooBad which has a prefix of T.")));
  }
  public static void TestContainsSplit()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _0_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _0_version = _out0;
    SearchableEncryptionInfo_Compile.KeySource _1_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _0_version);
    _1_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError0 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _0_version, _1_src);
    _2_valueOrError0 = _out2;
    if (!(!((_2_valueOrError0).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(67,14): " + java.lang.String.valueOf(_2_valueOrError0));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _3_bv;
    _3_bv = (_2_valueOrError0).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out3;
    _out3 = (_3_bv).GenerateEncryptedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    _4_valueOrError1 = _out3;
    if (!(!((_4_valueOrError1).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(68,21): " + java.lang.String.valueOf(_4_valueOrError1));
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _5_goodAttrs;
    _5_goodAttrs = (_4_valueOrError1).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _6_badItem;
    _6_badItem = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>update(BeaconTestFixtures_Compile.__default.SimpleItem(), dafny.DafnySequence.asString("Name"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("A.B")));
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _7_badAttrs;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out4;
    _out4 = (_3_bv).GenerateEncryptedBeacons(_6_badItem, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    _7_badAttrs = _out4;
    if (!((_7_badAttrs).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(71,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    BeaconTestFixtures_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>expect__equal(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (_7_badAttrs).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Part Name for beacon Mixed has value 'A.B' which contains the split character .'.")));
  }
  public static void TestOneBeaconValue()
  {
    dafny.DafnySequence<? extends Character> _0_x;
    dafny.DafnySequence<? extends Character> _out0;
    _out0 = __default.GetBeaconValue(dafny.DafnySequence.asString("std2"), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), dafny.DafnySequence.asString("1.23"), (byte) 24);
    _0_x = _out0;
    if (!((_0_x).equals(BeaconTestFixtures_Compile.__default.std2__beacon()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(79,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    dafny.DafnySequence<? extends Character> _out1;
    _out1 = __default.GetBeaconValue(dafny.DafnySequence.asString("Name"), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), dafny.DafnySequence.asString("MyName"), (byte) 32);
    _0_x = _out1;
    if (!((_0_x).equals(BeaconTestFixtures_Compile.__default.Name__beacon()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(81,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    dafny.DafnySequence<? extends Character> _out2;
    _out2 = __default.GetBeaconValue(dafny.DafnySequence.asString("Title"), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), dafny.DafnySequence.asString("MyTitle"), (byte) 32);
    _0_x = _out2;
    if (!((_0_x).equals(BeaconTestFixtures_Compile.__default.Title__beacon()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(83,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    dafny.DafnySequence<? extends Character> _out3;
    _out3 = __default.GetBeaconValue(dafny.DafnySequence.asString("std4"), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), dafny.DafnySequence.asString("abc"), (byte) 24);
    _0_x = _out3;
    if (!((_0_x).equals(BeaconTestFixtures_Compile.__default.std4__beacon()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(85,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    dafny.DafnySequence<? extends Character> _out4;
    _out4 = __default.GetBeaconValue(dafny.DafnySequence.asString("std6"), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), dafny.DafnySequence.asString("666"), (byte) 26);
    _0_x = _out4;
    if (!((_0_x).equals(BeaconTestFixtures_Compile.__default.std6__beacon()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(87,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    dafny.DafnySequence<? extends Character> _out5;
    _out5 = __default.GetBeaconValue(dafny.DafnySequence.asString("NameTitleField"), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), dafny.DafnySequence.asString("MyName__mytitle"), (byte) 28);
    _0_x = _out5;
    if (!((_0_x).equals(BeaconTestFixtures_Compile.__default.NameTitle__beacon()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(89,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    dafny.DafnySequence<? extends Character> _out6;
    _out6 = __default.GetBeaconValue(dafny.DafnySequence.asString("Name"), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), dafny.DafnySequence.asString(""), (byte) 32);
    _0_x = _out6;
    if (!((_0_x).equals(BeaconTestFixtures_Compile.__default.EmptyName__beacon()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(91,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    dafny.DafnySequence<? extends Character> _out7;
    _out7 = __default.GetBeaconValue(dafny.DafnySequence.asString("Title"), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), dafny.DafnySequence.asString(""), (byte) 32);
    _0_x = _out7;
    if (!((_0_x).equals(BeaconTestFixtures_Compile.__default.EmptyTitle__beacon()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(93,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestNumbersNormalize()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _0_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _0_version = _out0;
    SearchableEncryptionInfo_Compile.KeySource _1_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _0_version);
    _1_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError0 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _0_version, _1_src);
    _2_valueOrError0 = _out2;
    if (!(!((_2_valueOrError0).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(100,14): " + java.lang.String.valueOf(_2_valueOrError0));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _3_bv;
    _3_bv = (_2_valueOrError0).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out3;
    _out3 = (_3_bv).GenerateEncryptedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    _4_valueOrError1 = _out3;
    if (!(!((_4_valueOrError1).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(101,21): " + java.lang.String.valueOf(_4_valueOrError1));
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _5_goodAttrs;
    _5_goodAttrs = (_4_valueOrError1).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!((_5_goodAttrs).<dafny.DafnySequence<? extends Character>>contains(dafny.DafnySequence.asString("aws_dbe_b_std2")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(105,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_5_goodAttrs).get(dafny.DafnySequence.asString("aws_dbe_b_std2")))), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(BeaconTestFixtures_Compile.__default.std2__beacon())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(106,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _6_newItem;
    _6_newItem = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>update(BeaconTestFixtures_Compile.__default.SimpleItem(), dafny.DafnySequence.asString("std2"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(dafny.DafnySequence.asString("000001.23000000")));
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _7_valueOrError2 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out4;
    _out4 = (_3_bv).GenerateEncryptedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    _7_valueOrError2 = _out4;
    if (!(!((_7_valueOrError2).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(108,20): " + java.lang.String.valueOf(_7_valueOrError2));
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _8_newAttrs;
    _8_newAttrs = (_7_valueOrError2).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!((_8_newAttrs).<dafny.DafnySequence<? extends Character>>contains(dafny.DafnySequence.asString("aws_dbe_b_std2")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(109,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_5_goodAttrs).get(dafny.DafnySequence.asString("aws_dbe_b_std2")))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_8_newAttrs).get(dafny.DafnySequence.asString("aws_dbe_b_std2"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(110,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestSharedCacheBeaconsSingleKeyStoreWithSamePartitionId()
  {
    dafny.DafnySequence<? extends Character> _0_partitionId;
    _0_partitionId = dafny.DafnySequence.asString("partitionId");
    software.amazon.cryptography.materialproviders.internaldafny.types.CacheType _1_sharedCache;
    software.amazon.cryptography.materialproviders.internaldafny.types.CacheType _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetSharedCache();
    _1_sharedCache = _out0;
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _2_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _out1;
    _out1 = software.amazon.cryptography.primitives.internaldafny.__default.AtomicPrimitives(software.amazon.cryptography.primitives.internaldafny.__default.DefaultCryptoConfig());
    _2_valueOrError0 = _out1;
    if (!(!((_2_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(117,22): " + java.lang.String.valueOf(_2_valueOrError0));
    }
    software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient _3_primitives;
    _3_primitives = (_2_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _4_badVersion;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out2;
    _out2 = BeaconTestFixtures_Compile.__default.GetLotsaBeaconsSingleWithSharedCacheWithBadKeyStore(_1_sharedCache, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _0_partitionId));
    _4_badVersion = _out2;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_valueOrError1 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out3;
    _out3 = SearchConfigToInfo_Compile.__default.MakeKeySource(BeaconTestFixtures_Compile.__default.FullTableConfig(), (_4_badVersion).dtor_keyStore(), (_4_badVersion).dtor_keySource(), _3_primitives);
    _5_valueOrError1 = _out3;
    if (!(!((_5_valueOrError1).IsFailure(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(133,18): " + java.lang.String.valueOf(_5_valueOrError1));
    }
    SearchableEncryptionInfo_Compile.KeySource _6_badSrc;
    _6_badSrc = (_5_valueOrError1).Extract(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _7_valueOrError2 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out4;
    _out4 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _4_badVersion, _6_badSrc);
    _7_valueOrError2 = _out4;
    if (!(!((_7_valueOrError2).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(134,17): " + java.lang.String.valueOf(_7_valueOrError2));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _8_badBv;
    _8_badBv = (_7_valueOrError2).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _9_badAttrs;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out5;
    _out5 = (_8_badBv).GenerateEncryptedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    _9_badAttrs = _out5;
    if (!((_9_badAttrs).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(136,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _10_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out6;
    _out6 = BeaconTestFixtures_Compile.__default.GetLotsaBeaconsSingleWithSharedCache(_1_sharedCache, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _0_partitionId));
    _10_version = _out6;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _11_valueOrError3 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out7;
    _out7 = SearchConfigToInfo_Compile.__default.MakeKeySource(BeaconTestFixtures_Compile.__default.FullTableConfig(), (_10_version).dtor_keyStore(), (_10_version).dtor_keySource(), _3_primitives);
    _11_valueOrError3 = _out7;
    if (!(!((_11_valueOrError3).IsFailure(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(140,15): " + java.lang.String.valueOf(_11_valueOrError3));
    }
    SearchableEncryptionInfo_Compile.KeySource _12_src;
    _12_src = (_11_valueOrError3).Extract(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _13_valueOrError4 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out8;
    _out8 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _10_version, _12_src);
    _13_valueOrError4 = _out8;
    if (!(!((_13_valueOrError4).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(141,14): " + java.lang.String.valueOf(_13_valueOrError4));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _14_bv;
    _14_bv = (_13_valueOrError4).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _15_valueOrError5 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out9;
    _out9 = (_14_bv).GenerateEncryptedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    _15_valueOrError5 = _out9;
    if (!(!((_15_valueOrError5).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(142,21): " + java.lang.String.valueOf(_15_valueOrError5));
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _16_goodAttrs;
    _16_goodAttrs = (_15_valueOrError5).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _17_valueOrError6 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out10;
    _out10 = (_8_badBv).GenerateEncryptedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    _17_valueOrError6 = _out10;
    if (!(!((_17_valueOrError6).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(146,29): " + java.lang.String.valueOf(_17_valueOrError6));
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _18_badAttrsNowCached;
    _18_badAttrsNowCached = (_17_valueOrError6).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
  }
  public static void TestSharedCacheBeaconsSingleKeyStoreWithDifferentPartitionId()
  {
    software.amazon.cryptography.materialproviders.internaldafny.types.CacheType _0_sharedCache;
    software.amazon.cryptography.materialproviders.internaldafny.types.CacheType _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetSharedCache();
    _0_sharedCache = _out0;
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _1_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _out1;
    _out1 = software.amazon.cryptography.primitives.internaldafny.__default.AtomicPrimitives(software.amazon.cryptography.primitives.internaldafny.__default.DefaultCryptoConfig());
    _1_valueOrError0 = _out1;
    if (!(!((_1_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(152,22): " + java.lang.String.valueOf(_1_valueOrError0));
    }
    software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient _2_primitives;
    _2_primitives = (_1_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor());
    dafny.DafnySequence<? extends Character> _3_partitionIdBadVersion;
    _3_partitionIdBadVersion = dafny.DafnySequence.asString("partitionIdBadVersion");
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _4_badVersion;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out2;
    _out2 = BeaconTestFixtures_Compile.__default.GetLotsaBeaconsSingleWithSharedCacheWithBadKeyStore(_0_sharedCache, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _3_partitionIdBadVersion));
    _4_badVersion = _out2;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_valueOrError1 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out3;
    _out3 = SearchConfigToInfo_Compile.__default.MakeKeySource(BeaconTestFixtures_Compile.__default.FullTableConfig(), (_4_badVersion).dtor_keyStore(), (_4_badVersion).dtor_keySource(), _2_primitives);
    _5_valueOrError1 = _out3;
    if (!(!((_5_valueOrError1).IsFailure(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(169,18): " + java.lang.String.valueOf(_5_valueOrError1));
    }
    SearchableEncryptionInfo_Compile.KeySource _6_badSrc;
    _6_badSrc = (_5_valueOrError1).Extract(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _7_valueOrError2 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out4;
    _out4 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _4_badVersion, _6_badSrc);
    _7_valueOrError2 = _out4;
    if (!(!((_7_valueOrError2).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(170,17): " + java.lang.String.valueOf(_7_valueOrError2));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _8_badBv;
    _8_badBv = (_7_valueOrError2).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _9_badAttrs;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out5;
    _out5 = (_8_badBv).GenerateEncryptedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    _9_badAttrs = _out5;
    if (!((_9_badAttrs).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(172,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    dafny.DafnySequence<? extends Character> _10_partitionIdGoodVersion;
    _10_partitionIdGoodVersion = dafny.DafnySequence.asString("partitionIdGoodVersion");
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _11_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out6;
    _out6 = BeaconTestFixtures_Compile.__default.GetLotsaBeaconsSingleWithSharedCache(_0_sharedCache, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _10_partitionIdGoodVersion));
    _11_version = _out6;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _12_valueOrError3 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out7;
    _out7 = SearchConfigToInfo_Compile.__default.MakeKeySource(BeaconTestFixtures_Compile.__default.FullTableConfig(), (_11_version).dtor_keyStore(), (_11_version).dtor_keySource(), _2_primitives);
    _12_valueOrError3 = _out7;
    if (!(!((_12_valueOrError3).IsFailure(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(177,15): " + java.lang.String.valueOf(_12_valueOrError3));
    }
    SearchableEncryptionInfo_Compile.KeySource _13_src;
    _13_src = (_12_valueOrError3).Extract(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _14_valueOrError4 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out8;
    _out8 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _11_version, _13_src);
    _14_valueOrError4 = _out8;
    if (!(!((_14_valueOrError4).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(178,14): " + java.lang.String.valueOf(_14_valueOrError4));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _15_bv;
    _15_bv = (_14_valueOrError4).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _16_valueOrError5 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out9;
    _out9 = (_15_bv).GenerateEncryptedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    _16_valueOrError5 = _out9;
    if (!(!((_16_valueOrError5).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(179,21): " + java.lang.String.valueOf(_16_valueOrError5));
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _17_goodAttrs;
    _17_goodAttrs = (_16_valueOrError5).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _18_badAttrsNowCached;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out10;
    _out10 = (_8_badBv).GenerateEncryptedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    _18_badAttrsNowCached = _out10;
    if (!((_18_badAttrsNowCached).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(183,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestSharedCacheBeaconsSingleKeyStoreWithUnspecifiedPartitionId()
  {
    software.amazon.cryptography.materialproviders.internaldafny.types.CacheType _0_sharedCache;
    software.amazon.cryptography.materialproviders.internaldafny.types.CacheType _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetSharedCache();
    _0_sharedCache = _out0;
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _1_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _out1;
    _out1 = software.amazon.cryptography.primitives.internaldafny.__default.AtomicPrimitives(software.amazon.cryptography.primitives.internaldafny.__default.DefaultCryptoConfig());
    _1_valueOrError0 = _out1;
    if (!(!((_1_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(189,22): " + java.lang.String.valueOf(_1_valueOrError0));
    }
    software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient _2_primitives;
    _2_primitives = (_1_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _3_badVersion;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out2;
    _out2 = BeaconTestFixtures_Compile.__default.GetLotsaBeaconsSingleWithSharedCacheWithBadKeyStore(_0_sharedCache, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
    _3_badVersion = _out2;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError1 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out3;
    _out3 = SearchConfigToInfo_Compile.__default.MakeKeySource(BeaconTestFixtures_Compile.__default.FullTableConfig(), (_3_badVersion).dtor_keyStore(), (_3_badVersion).dtor_keySource(), _2_primitives);
    _4_valueOrError1 = _out3;
    if (!(!((_4_valueOrError1).IsFailure(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(205,18): " + java.lang.String.valueOf(_4_valueOrError1));
    }
    SearchableEncryptionInfo_Compile.KeySource _5_badSrc;
    _5_badSrc = (_4_valueOrError1).Extract(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_valueOrError2 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out4;
    _out4 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _3_badVersion, _5_badSrc);
    _6_valueOrError2 = _out4;
    if (!(!((_6_valueOrError2).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(206,17): " + java.lang.String.valueOf(_6_valueOrError2));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _7_badBv;
    _7_badBv = (_6_valueOrError2).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _8_badAttrs;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out5;
    _out5 = (_7_badBv).GenerateEncryptedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    _8_badAttrs = _out5;
    if (!((_8_badAttrs).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(208,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _9_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out6;
    _out6 = BeaconTestFixtures_Compile.__default.GetLotsaBeaconsSingleWithSharedCache(_0_sharedCache, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
    _9_version = _out6;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _10_valueOrError3 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out7;
    _out7 = SearchConfigToInfo_Compile.__default.MakeKeySource(BeaconTestFixtures_Compile.__default.FullTableConfig(), (_9_version).dtor_keyStore(), (_9_version).dtor_keySource(), _2_primitives);
    _10_valueOrError3 = _out7;
    if (!(!((_10_valueOrError3).IsFailure(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(212,15): " + java.lang.String.valueOf(_10_valueOrError3));
    }
    SearchableEncryptionInfo_Compile.KeySource _11_src;
    _11_src = (_10_valueOrError3).Extract(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _12_valueOrError4 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out8;
    _out8 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _9_version, _11_src);
    _12_valueOrError4 = _out8;
    if (!(!((_12_valueOrError4).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(213,14): " + java.lang.String.valueOf(_12_valueOrError4));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _13_bv;
    _13_bv = (_12_valueOrError4).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _14_valueOrError5 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out9;
    _out9 = (_13_bv).GenerateEncryptedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    _14_valueOrError5 = _out9;
    if (!(!((_14_valueOrError5).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(214,21): " + java.lang.String.valueOf(_14_valueOrError5));
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _15_goodAttrs;
    _15_goodAttrs = (_14_valueOrError5).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _16_badAttrsNowCached;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out10;
    _out10 = (_7_badBv).GenerateEncryptedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    _16_badAttrsNowCached = _out10;
    if (!((_16_badAttrsNowCached).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(219,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestSharedCacheBeaconsMultiKeyStoreWithSamePartitionId()
  {
    dafny.DafnySequence<? extends Character> _0_partitionId;
    _0_partitionId = dafny.DafnySequence.asString("partitionId");
    software.amazon.cryptography.materialproviders.internaldafny.types.CacheType _1_sharedCache;
    software.amazon.cryptography.materialproviders.internaldafny.types.CacheType _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetSharedCache();
    _1_sharedCache = _out0;
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _2_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _out1;
    _out1 = software.amazon.cryptography.primitives.internaldafny.__default.AtomicPrimitives(software.amazon.cryptography.primitives.internaldafny.__default.DefaultCryptoConfig());
    _2_valueOrError0 = _out1;
    if (!(!((_2_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(226,22): " + java.lang.String.valueOf(_2_valueOrError0));
    }
    software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient _3_primitives;
    _3_primitives = (_2_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _4_badVersion;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out2;
    _out2 = BeaconTestFixtures_Compile.__default.GetLotsaBeaconsMultiWithSharedCacheWithBadKeyStore(_1_sharedCache, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _0_partitionId));
    _4_badVersion = _out2;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_valueOrError1 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out3;
    _out3 = SearchConfigToInfo_Compile.__default.MakeKeySource(BeaconTestFixtures_Compile.__default.FullTableConfig(), (_4_badVersion).dtor_keyStore(), (_4_badVersion).dtor_keySource(), _3_primitives);
    _5_valueOrError1 = _out3;
    if (!(!((_5_valueOrError1).IsFailure(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(242,18): " + java.lang.String.valueOf(_5_valueOrError1));
    }
    SearchableEncryptionInfo_Compile.KeySource _6_badSrc;
    _6_badSrc = (_5_valueOrError1).Extract(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _7_valueOrError2 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out4;
    _out4 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _4_badVersion, _6_badSrc);
    _7_valueOrError2 = _out4;
    if (!(!((_7_valueOrError2).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(243,17): " + java.lang.String.valueOf(_7_valueOrError2));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _8_badBv;
    _8_badBv = (_7_valueOrError2).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _9_badAttrs;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out5;
    _out5 = (_8_badBv).GenerateEncryptedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_KeyId(dafny.DafnySequence.asString("040a32a8-3737-4f16-a3ba-bd4449556d73")));
    _9_badAttrs = _out5;
    if (!((_9_badAttrs).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(245,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _10_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out6;
    _out6 = BeaconTestFixtures_Compile.__default.GetLotsaBeaconsMultiWithSharedCache(_1_sharedCache, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _0_partitionId));
    _10_version = _out6;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _11_valueOrError3 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out7;
    _out7 = SearchConfigToInfo_Compile.__default.MakeKeySource(BeaconTestFixtures_Compile.__default.FullTableConfig(), (_10_version).dtor_keyStore(), (_10_version).dtor_keySource(), _3_primitives);
    _11_valueOrError3 = _out7;
    if (!(!((_11_valueOrError3).IsFailure(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(249,15): " + java.lang.String.valueOf(_11_valueOrError3));
    }
    SearchableEncryptionInfo_Compile.KeySource _12_src;
    _12_src = (_11_valueOrError3).Extract(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _13_valueOrError4 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out8;
    _out8 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _10_version, _12_src);
    _13_valueOrError4 = _out8;
    if (!(!((_13_valueOrError4).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(250,14): " + java.lang.String.valueOf(_13_valueOrError4));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _14_bv;
    _14_bv = (_13_valueOrError4).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _15_valueOrError5 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out9;
    _out9 = (_14_bv).GenerateEncryptedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_KeyId(dafny.DafnySequence.asString("040a32a8-3737-4f16-a3ba-bd4449556d73")));
    _15_valueOrError5 = _out9;
    if (!(!((_15_valueOrError5).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(251,21): " + java.lang.String.valueOf(_15_valueOrError5));
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _16_goodAttrs;
    _16_goodAttrs = (_15_valueOrError5).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _17_valueOrError6 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out10;
    _out10 = (_8_badBv).GenerateEncryptedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_KeyId(dafny.DafnySequence.asString("040a32a8-3737-4f16-a3ba-bd4449556d73")));
    _17_valueOrError6 = _out10;
    if (!(!((_17_valueOrError6).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(255,29): " + java.lang.String.valueOf(_17_valueOrError6));
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _18_badAttrsNowCached;
    _18_badAttrsNowCached = (_17_valueOrError6).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
  }
  public static void TestSharedCacheBeaconsMultiKeyStoreWithDifferentPartitionId()
  {
    software.amazon.cryptography.materialproviders.internaldafny.types.CacheType _0_sharedCache;
    software.amazon.cryptography.materialproviders.internaldafny.types.CacheType _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetSharedCache();
    _0_sharedCache = _out0;
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _1_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _out1;
    _out1 = software.amazon.cryptography.primitives.internaldafny.__default.AtomicPrimitives(software.amazon.cryptography.primitives.internaldafny.__default.DefaultCryptoConfig());
    _1_valueOrError0 = _out1;
    if (!(!((_1_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(262,22): " + java.lang.String.valueOf(_1_valueOrError0));
    }
    software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient _2_primitives;
    _2_primitives = (_1_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor());
    dafny.DafnySequence<? extends Character> _3_partitionIdBadVersion;
    _3_partitionIdBadVersion = dafny.DafnySequence.asString("partitionIdBadVersion");
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _4_badVersion;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out2;
    _out2 = BeaconTestFixtures_Compile.__default.GetLotsaBeaconsMultiWithSharedCacheWithBadKeyStore(_0_sharedCache, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _3_partitionIdBadVersion));
    _4_badVersion = _out2;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_valueOrError1 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out3;
    _out3 = SearchConfigToInfo_Compile.__default.MakeKeySource(BeaconTestFixtures_Compile.__default.FullTableConfig(), (_4_badVersion).dtor_keyStore(), (_4_badVersion).dtor_keySource(), _2_primitives);
    _5_valueOrError1 = _out3;
    if (!(!((_5_valueOrError1).IsFailure(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(279,18): " + java.lang.String.valueOf(_5_valueOrError1));
    }
    SearchableEncryptionInfo_Compile.KeySource _6_badSrc;
    _6_badSrc = (_5_valueOrError1).Extract(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _7_valueOrError2 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out4;
    _out4 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _4_badVersion, _6_badSrc);
    _7_valueOrError2 = _out4;
    if (!(!((_7_valueOrError2).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(280,17): " + java.lang.String.valueOf(_7_valueOrError2));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _8_badBv;
    _8_badBv = (_7_valueOrError2).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _9_badAttrs;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out5;
    _out5 = (_8_badBv).GenerateEncryptedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_KeyId(dafny.DafnySequence.asString("040a32a8-3737-4f16-a3ba-bd4449556d73")));
    _9_badAttrs = _out5;
    if (!((_9_badAttrs).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(285,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    dafny.DafnySequence<? extends Character> _10_partitionIdGoodVersion;
    _10_partitionIdGoodVersion = dafny.DafnySequence.asString("partitionIdGoodVersion");
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _11_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out6;
    _out6 = BeaconTestFixtures_Compile.__default.GetLotsaBeaconsMultiWithSharedCache(_0_sharedCache, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _10_partitionIdGoodVersion));
    _11_version = _out6;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _12_valueOrError3 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out7;
    _out7 = SearchConfigToInfo_Compile.__default.MakeKeySource(BeaconTestFixtures_Compile.__default.FullTableConfig(), (_11_version).dtor_keyStore(), (_11_version).dtor_keySource(), _2_primitives);
    _12_valueOrError3 = _out7;
    if (!(!((_12_valueOrError3).IsFailure(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(290,15): " + java.lang.String.valueOf(_12_valueOrError3));
    }
    SearchableEncryptionInfo_Compile.KeySource _13_src;
    _13_src = (_12_valueOrError3).Extract(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _14_valueOrError4 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out8;
    _out8 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _11_version, _13_src);
    _14_valueOrError4 = _out8;
    if (!(!((_14_valueOrError4).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(291,14): " + java.lang.String.valueOf(_14_valueOrError4));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _15_bv;
    _15_bv = (_14_valueOrError4).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _16_valueOrError5 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out9;
    _out9 = (_15_bv).GenerateEncryptedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_KeyId(dafny.DafnySequence.asString("040a32a8-3737-4f16-a3ba-bd4449556d73")));
    _16_valueOrError5 = _out9;
    if (!(!((_16_valueOrError5).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(292,21): " + java.lang.String.valueOf(_16_valueOrError5));
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _17_goodAttrs;
    _17_goodAttrs = (_16_valueOrError5).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _18_badAttrsNowCached;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out10;
    _out10 = (_8_badBv).GenerateEncryptedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_KeyId(dafny.DafnySequence.asString("040a32a8-3737-4f16-a3ba-bd4449556d73")));
    _18_badAttrsNowCached = _out10;
    if (!((_18_badAttrsNowCached).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(296,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestSharedCacheBeaconsMultiKeyStoreWithUnspecifiedPartitionId()
  {
    software.amazon.cryptography.materialproviders.internaldafny.types.CacheType _0_sharedCache;
    software.amazon.cryptography.materialproviders.internaldafny.types.CacheType _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetSharedCache();
    _0_sharedCache = _out0;
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _1_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _out1;
    _out1 = software.amazon.cryptography.primitives.internaldafny.__default.AtomicPrimitives(software.amazon.cryptography.primitives.internaldafny.__default.DefaultCryptoConfig());
    _1_valueOrError0 = _out1;
    if (!(!((_1_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(302,22): " + java.lang.String.valueOf(_1_valueOrError0));
    }
    software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient _2_primitives;
    _2_primitives = (_1_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _3_badVersion;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out2;
    _out2 = BeaconTestFixtures_Compile.__default.GetLotsaBeaconsMultiWithSharedCacheWithBadKeyStore(_0_sharedCache, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
    _3_badVersion = _out2;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError1 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out3;
    _out3 = SearchConfigToInfo_Compile.__default.MakeKeySource(BeaconTestFixtures_Compile.__default.FullTableConfig(), (_3_badVersion).dtor_keyStore(), (_3_badVersion).dtor_keySource(), _2_primitives);
    _4_valueOrError1 = _out3;
    if (!(!((_4_valueOrError1).IsFailure(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(318,18): " + java.lang.String.valueOf(_4_valueOrError1));
    }
    SearchableEncryptionInfo_Compile.KeySource _5_badSrc;
    _5_badSrc = (_4_valueOrError1).Extract(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_valueOrError2 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out4;
    _out4 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _3_badVersion, _5_badSrc);
    _6_valueOrError2 = _out4;
    if (!(!((_6_valueOrError2).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(319,17): " + java.lang.String.valueOf(_6_valueOrError2));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _7_badBv;
    _7_badBv = (_6_valueOrError2).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _8_badAttrs;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out5;
    _out5 = (_7_badBv).GenerateEncryptedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_KeyId(dafny.DafnySequence.asString("040a32a8-3737-4f16-a3ba-bd4449556d73")));
    _8_badAttrs = _out5;
    if (!((_8_badAttrs).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(324,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _9_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out6;
    _out6 = BeaconTestFixtures_Compile.__default.GetLotsaBeaconsMultiWithSharedCache(_0_sharedCache, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
    _9_version = _out6;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _10_valueOrError3 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out7;
    _out7 = SearchConfigToInfo_Compile.__default.MakeKeySource(BeaconTestFixtures_Compile.__default.FullTableConfig(), (_9_version).dtor_keyStore(), (_9_version).dtor_keySource(), _2_primitives);
    _10_valueOrError3 = _out7;
    if (!(!((_10_valueOrError3).IsFailure(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(328,15): " + java.lang.String.valueOf(_10_valueOrError3));
    }
    SearchableEncryptionInfo_Compile.KeySource _11_src;
    _11_src = (_10_valueOrError3).Extract(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _12_valueOrError4 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out8;
    _out8 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _9_version, _11_src);
    _12_valueOrError4 = _out8;
    if (!(!((_12_valueOrError4).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(329,14): " + java.lang.String.valueOf(_12_valueOrError4));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _13_bv;
    _13_bv = (_12_valueOrError4).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _14_valueOrError5 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out9;
    _out9 = (_13_bv).GenerateEncryptedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_KeyId(dafny.DafnySequence.asString("040a32a8-3737-4f16-a3ba-bd4449556d73")));
    _14_valueOrError5 = _out9;
    if (!(!((_14_valueOrError5).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(330,21): " + java.lang.String.valueOf(_14_valueOrError5));
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _15_goodAttrs;
    _15_goodAttrs = (_14_valueOrError5).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _16_badAttrsNowCached;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out10;
    _out10 = (_7_badBv).GenerateEncryptedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_KeyId(dafny.DafnySequence.asString("040a32a8-3737-4f16-a3ba-bd4449556d73")));
    _16_badAttrsNowCached = _out10;
    if (!((_16_badAttrsNowCached).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(335,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestBeaconValues()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _0_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _0_version = _out0;
    SearchableEncryptionInfo_Compile.KeySource _1_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _0_version);
    _1_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError0 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _0_version, _1_src);
    _2_valueOrError0 = _out2;
    if (!(!((_2_valueOrError0).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(342,14): " + java.lang.String.valueOf(_2_valueOrError0));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _3_bv;
    _3_bv = (_2_valueOrError0).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out3;
    _out3 = (_3_bv).GenerateSignedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem());
    _4_valueOrError1 = _out3;
    if (!(!((_4_valueOrError1).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(343,17): " + java.lang.String.valueOf(_4_valueOrError1));
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _5_attrs;
    _5_attrs = (_4_valueOrError1).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!((_5_attrs).equals(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("JustSigned"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("Y_1984.M_May"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(344,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_valueOrError2 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out4;
    _out4 = (_3_bv).GenerateEncryptedBeacons(BeaconTestFixtures_Compile.__default.SimpleItem(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    _6_valueOrError2 = _out4;
    if (!(!((_6_valueOrError2).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(345,13): " + java.lang.String.valueOf(_6_valueOrError2));
    }
    _5_attrs = (_6_valueOrError2).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!((_5_attrs).equals(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_b_Mixed"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("N_"), BeaconTestFixtures_Compile.__default.Name__beacon()), dafny.DafnySequence.asString(".Y_1984")))), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_b_Name"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(BeaconTestFixtures_Compile.__default.Name__beacon())), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_b_NameTitle"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("N_"), BeaconTestFixtures_Compile.__default.Name__beacon()), dafny.DafnySequence.asString(".T_")), BeaconTestFixtures_Compile.__default.Title__beacon()))), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_b_NameTitleField"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("4c577d7"))), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_b_std2"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(BeaconTestFixtures_Compile.__default.std2__beacon())), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_b_Title"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(BeaconTestFixtures_Compile.__default.Title__beacon())), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_b_std6"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(BeaconTestFixtures_Compile.__default.std6__beacon())), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_b_std4"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(BeaconTestFixtures_Compile.__default.std4__beacon())), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_b_YearName"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Y_1984.N_"), BeaconTestFixtures_Compile.__default.Name__beacon()))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(346,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static dafny.DafnySequence<? extends Character> GetBeaconValue(dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends java.lang.Byte> key, dafny.DafnySequence<? extends Character> value, byte length)
  {
    dafny.DafnySequence<? extends Character> output = dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR);
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _0_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>Default(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), UTF8.ValidUTF8Bytes.defaultValue());
    _0_valueOrError0 = UTF8.__default.Encode(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("AWS_DBE_SCAN_BEACON"), name));
    if (!(!((_0_valueOrError0).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(370,16): " + java.lang.String.valueOf(_0_valueOrError0));
    }
    dafny.DafnySequence<? extends java.lang.Byte> _1_info;
    _1_info = (_0_valueOrError0).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _2_valueOrError1 = (Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _out0;
    _out0 = software.amazon.cryptography.primitives.internaldafny.__default.AtomicPrimitives(software.amazon.cryptography.primitives.internaldafny.__default.DefaultCryptoConfig());
    _2_valueOrError1 = _out0;
    if (!(!((_2_valueOrError1).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(371,18): " + java.lang.String.valueOf(_2_valueOrError1));
    }
    software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient _3_client;
    _3_client = (_2_valueOrError1).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.primitives.internaldafny.types.Error> _4_valueOrError2 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.primitives.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.primitives.internaldafny.types.Error> _out1;
    _out1 = (_3_client).Hkdf(software.amazon.cryptography.primitives.internaldafny.types.HkdfInput.create(software.amazon.cryptography.primitives.internaldafny.types.DigestAlgorithm.create_SHA__512(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_None(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), key, _1_info, 64));
    _4_valueOrError2 = _out1;
    if (!(!((_4_valueOrError2).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(373,15): " + java.lang.String.valueOf(_4_valueOrError2));
    }
    dafny.DafnySequence<? extends java.lang.Byte> _5_key;
    _5_key = (_4_valueOrError2).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _6_valueOrError3 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>Default(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), UTF8.ValidUTF8Bytes.defaultValue());
    _6_valueOrError3 = UTF8.__default.Encode(value);
    if (!(!((_6_valueOrError3).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(381,16): " + java.lang.String.valueOf(_6_valueOrError3));
    }
    dafny.DafnySequence<? extends java.lang.Byte> _7_data;
    _7_data = (_6_valueOrError3).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    software.amazon.cryptography.primitives.internaldafny.types.HMacInput _8_input;
    _8_input = software.amazon.cryptography.primitives.internaldafny.types.HMacInput.create(software.amazon.cryptography.primitives.internaldafny.types.DigestAlgorithm.create_SHA__384(), _5_key, _7_data);
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.primitives.internaldafny.types.Error> _9_valueOrError4 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.primitives.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
    _9_valueOrError4 = (_3_client).HMac(_8_input);
    if (!(!((_9_valueOrError4).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(387,18): " + java.lang.String.valueOf(_9_valueOrError4));
    }
    dafny.DafnySequence<? extends java.lang.Byte> _10_hmac48;
    _10_hmac48 = (_9_valueOrError4).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor());
    dafny.DafnySequence<? extends java.lang.Byte> _11_hmac8;
    _11_hmac8 = (_10_hmac48).take(java.math.BigInteger.valueOf(8L));
    output = BaseBeacon_Compile.__default.BytesToHex(_11_hmac8, length);
    return output;
  }
  public static void TestCompoundQueries()
  {
    DynamoDBFilterExpr_Compile.ExprContext _0_context;
    _0_context = DynamoDBFilterExpr_Compile.ExprContext.create(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Mixed = :mixed")), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_None(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor())));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _1_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _1_version = _out0;
    SearchableEncryptionInfo_Compile.KeySource _2_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _1_version);
    _2_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError0 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _1_version, _2_src);
    _3_valueOrError0 = _out2;
    if (!(!((_3_valueOrError0).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(402,25): " + java.lang.String.valueOf(_3_valueOrError0));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _4_beaconVersion;
    _4_beaconVersion = (_3_valueOrError0).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    DynamoDBFilterExpr_Compile.ExprContext _5_dt__update__tmp_h0 = _0_context;
    Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _6_dt__update_hvalues_h0 = Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString(":mixed"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("N_MyName.Y_1984")))));
    _0_context = DynamoDBFilterExpr_Compile.ExprContext.create((_5_dt__update__tmp_h0).dtor_keyExpr(), (_5_dt__update__tmp_h0).dtor_filterExpr(), _6_dt__update_hvalues_h0, (_5_dt__update__tmp_h0).dtor_names());
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _7_valueOrError1 = Wrappers_Compile.Result.<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDBFilterExpr_Compile.ExprContext.Default());
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out3;
    _out3 = DynamoDBFilterExpr_Compile.__default.Beaconize(_4_beaconVersion, _0_context, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId(), false);
    _7_valueOrError1 = _out3;
    if (!(!((_7_valueOrError1).IsFailure(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(405,22): " + java.lang.String.valueOf(_7_valueOrError1));
    }
    DynamoDBFilterExpr_Compile.ExprContext _8_newContext;
    _8_newContext = (_7_valueOrError1).Extract(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    DynamoDBFilterExpr_Compile.ExprContext _9_dt__update__tmp_h1 = _0_context;
    Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _10_dt__update_hvalues_h1 = Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString(":mixed"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("N_MyName")))));
    _0_context = DynamoDBFilterExpr_Compile.ExprContext.create((_9_dt__update__tmp_h1).dtor_keyExpr(), (_9_dt__update__tmp_h1).dtor_filterExpr(), _10_dt__update_hvalues_h1, (_9_dt__update__tmp_h1).dtor_names());
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _11_valueOrError2 = Wrappers_Compile.Result.<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDBFilterExpr_Compile.ExprContext.Default());
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out4;
    _out4 = DynamoDBFilterExpr_Compile.__default.Beaconize(_4_beaconVersion, _0_context, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId(), false);
    _11_valueOrError2 = _out4;
    if (!(!((_11_valueOrError2).IsFailure(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(407,18): " + java.lang.String.valueOf(_11_valueOrError2));
    }
    _8_newContext = (_11_valueOrError2).Extract(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    DynamoDBFilterExpr_Compile.ExprContext _12_dt__update__tmp_h2 = _0_context;
    Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _13_dt__update_hvalues_h2 = Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString(":mixed"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("Y_1984")))));
    _0_context = DynamoDBFilterExpr_Compile.ExprContext.create((_12_dt__update__tmp_h2).dtor_keyExpr(), (_12_dt__update__tmp_h2).dtor_filterExpr(), _13_dt__update_hvalues_h2, (_12_dt__update__tmp_h2).dtor_names());
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _14_valueOrError3 = Wrappers_Compile.Result.<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDBFilterExpr_Compile.ExprContext.Default());
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out5;
    _out5 = DynamoDBFilterExpr_Compile.__default.Beaconize(_4_beaconVersion, _0_context, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId(), false);
    _14_valueOrError3 = _out5;
    if (!(!((_14_valueOrError3).IsFailure(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(409,18): " + java.lang.String.valueOf(_14_valueOrError3));
    }
    _8_newContext = (_14_valueOrError3).Extract(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    DynamoDBFilterExpr_Compile.ExprContext _15_dt__update__tmp_h3 = _0_context;
    Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _16_dt__update_hvalues_h3 = Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString(":mixed"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("T_foo")))));
    _0_context = DynamoDBFilterExpr_Compile.ExprContext.create((_15_dt__update__tmp_h3).dtor_keyExpr(), (_15_dt__update__tmp_h3).dtor_filterExpr(), _16_dt__update_hvalues_h3, (_15_dt__update__tmp_h3).dtor_names());
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _17_valueOrError4 = Wrappers_Compile.Result.<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDBFilterExpr_Compile.ExprContext.Default());
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out6;
    _out6 = DynamoDBFilterExpr_Compile.__default.Beaconize(_4_beaconVersion, _0_context, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId(), false);
    _17_valueOrError4 = _out6;
    if (!(!((_17_valueOrError4).IsFailure(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(411,18): " + java.lang.String.valueOf(_17_valueOrError4));
    }
    _8_newContext = (_17_valueOrError4).Extract(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    DynamoDBFilterExpr_Compile.ExprContext _18_dt__update__tmp_h4 = _0_context;
    Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _19_dt__update_hvalues_h4 = Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString(":mixed"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("M_bar")))));
    _0_context = DynamoDBFilterExpr_Compile.ExprContext.create((_18_dt__update__tmp_h4).dtor_keyExpr(), (_18_dt__update__tmp_h4).dtor_filterExpr(), _19_dt__update_hvalues_h4, (_18_dt__update__tmp_h4).dtor_names());
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _20_valueOrError5 = Wrappers_Compile.Result.<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDBFilterExpr_Compile.ExprContext.Default());
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out7;
    _out7 = DynamoDBFilterExpr_Compile.__default.Beaconize(_4_beaconVersion, _0_context, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId(), false);
    _20_valueOrError5 = _out7;
    if (!(!((_20_valueOrError5).IsFailure(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(413,18): " + java.lang.String.valueOf(_20_valueOrError5));
    }
    _8_newContext = (_20_valueOrError5).Extract(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    DynamoDBFilterExpr_Compile.ExprContext _21_dt__update__tmp_h5 = _0_context;
    Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _22_dt__update_hvalues_h5 = Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString(":mixed"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("T_foo.M_bar")))));
    _0_context = DynamoDBFilterExpr_Compile.ExprContext.create((_21_dt__update__tmp_h5).dtor_keyExpr(), (_21_dt__update__tmp_h5).dtor_filterExpr(), _22_dt__update_hvalues_h5, (_21_dt__update__tmp_h5).dtor_names());
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _23_valueOrError6 = Wrappers_Compile.Result.<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDBFilterExpr_Compile.ExprContext.Default());
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out8;
    _out8 = DynamoDBFilterExpr_Compile.__default.Beaconize(_4_beaconVersion, _0_context, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId(), false);
    _23_valueOrError6 = _out8;
    if (!(!((_23_valueOrError6).IsFailure(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(415,18): " + java.lang.String.valueOf(_23_valueOrError6));
    }
    _8_newContext = (_23_valueOrError6).Extract(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    DynamoDBFilterExpr_Compile.ExprContext _24_dt__update__tmp_h6 = _0_context;
    Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _25_dt__update_hvalues_h6 = Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString(":mixed"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("N_MyName.N_MyName")))));
    _0_context = DynamoDBFilterExpr_Compile.ExprContext.create((_24_dt__update__tmp_h6).dtor_keyExpr(), (_24_dt__update__tmp_h6).dtor_filterExpr(), _25_dt__update_hvalues_h6, (_24_dt__update__tmp_h6).dtor_names());
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _26_badContext;
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out9;
    _out9 = DynamoDBFilterExpr_Compile.__default.Beaconize(_4_beaconVersion, _0_context, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId(), false);
    _26_badContext = _out9;
    if (!((_26_badContext).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(419,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_26_badContext).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Compound Beacon value 'N_MyName.N_MyName' cannot be constructed from any available constructor for Mixed value parsed as N_N_ available constructors are N_Y_, T_[M_]."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(420,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    DynamoDBFilterExpr_Compile.ExprContext _27_dt__update__tmp_h7 = _0_context;
    Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _28_dt__update_hvalues_h7 = Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString(":mixed"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("Y_1984.N_MyName")))));
    _0_context = DynamoDBFilterExpr_Compile.ExprContext.create((_27_dt__update__tmp_h7).dtor_keyExpr(), (_27_dt__update__tmp_h7).dtor_filterExpr(), _28_dt__update_hvalues_h7, (_27_dt__update__tmp_h7).dtor_names());
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out10;
    _out10 = DynamoDBFilterExpr_Compile.__default.Beaconize(_4_beaconVersion, _0_context, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId(), false);
    _26_badContext = _out10;
    if (!((_26_badContext).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(424,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_26_badContext).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Compound Beacon value 'Y_1984.N_MyName' cannot be constructed from any available constructor for Mixed value parsed as Y_N_ available constructors are N_Y_, T_[M_]."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(425,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    DynamoDBFilterExpr_Compile.ExprContext _29_dt__update__tmp_h8 = _0_context;
    Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _30_dt__update_hvalues_h8 = Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString(":mixed"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("M_bar.T_foo")))));
    _0_context = DynamoDBFilterExpr_Compile.ExprContext.create((_29_dt__update__tmp_h8).dtor_keyExpr(), (_29_dt__update__tmp_h8).dtor_filterExpr(), _30_dt__update_hvalues_h8, (_29_dt__update__tmp_h8).dtor_names());
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out11;
    _out11 = DynamoDBFilterExpr_Compile.__default.Beaconize(_4_beaconVersion, _0_context, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId(), false);
    _26_badContext = _out11;
    if (!((_26_badContext).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(429,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_26_badContext).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Compound Beacon value 'M_bar.T_foo' cannot be constructed from any available constructor for Mixed value parsed as M_T_ available constructors are N_Y_, T_[M_]."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(430,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestQueryBeacons()
  {
    DynamoDBFilterExpr_Compile.ExprContext _0_context;
    _0_context = DynamoDBFilterExpr_Compile.ExprContext.create(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("std2 = :std2 AND std4 = :std4 AND :std6 = std6 AND Name = :Name AND Mixed = :Mixed"), dafny.DafnySequence.asString(" AND :NameTitle = NameTitle AND NameTitle = :NameTitleN AND NameTitle = :NameTitleT AND NameTitle = :NameTitleTN")), dafny.DafnySequence.asString(" AND NameTitleField = :NameTitleField And Title = :Title AND YearName = :YearName"))), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString(":std2"), BeaconTestFixtures_Compile.__default.Std2String()), new dafny.Tuple2(dafny.DafnySequence.asString(":std4"), BeaconTestFixtures_Compile.__default.Std4String()), new dafny.Tuple2(dafny.DafnySequence.asString(":std6"), BeaconTestFixtures_Compile.__default.Std6String()), new dafny.Tuple2(dafny.DafnySequence.asString(":Name"), BeaconTestFixtures_Compile.__default.NameString()), new dafny.Tuple2(dafny.DafnySequence.asString(":Title"), BeaconTestFixtures_Compile.__default.TitleString()), new dafny.Tuple2(dafny.DafnySequence.asString(":Mixed"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("N_MyName.Y_1984"))), new dafny.Tuple2(dafny.DafnySequence.asString(":NameTitle"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("N_MyName.T_MyTitle"))), new dafny.Tuple2(dafny.DafnySequence.asString(":NameTitleN"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("N_MyName"))), new dafny.Tuple2(dafny.DafnySequence.asString(":NameTitleT"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("T_MyTitle"))), new dafny.Tuple2(dafny.DafnySequence.asString(":NameTitleTN"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("N_MyName.T_MyTitle"))), new dafny.Tuple2(dafny.DafnySequence.asString(":NameTitleField"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("MyName__mytitle"))), new dafny.Tuple2(dafny.DafnySequence.asString(":YearName"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("Y_1984.N_MyName"))))), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor())));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _1_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _1_version = _out0;
    SearchableEncryptionInfo_Compile.KeySource _2_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _1_version);
    _2_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError0 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _1_version, _2_src);
    _3_valueOrError0 = _out2;
    if (!(!((_3_valueOrError0).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(457,25): " + java.lang.String.valueOf(_3_valueOrError0));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _4_beaconVersion;
    _4_beaconVersion = (_3_valueOrError0).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_valueOrError1 = Wrappers_Compile.Result.<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDBFilterExpr_Compile.ExprContext.Default());
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out3;
    _out3 = DynamoDBFilterExpr_Compile.__default.Beaconize(_4_beaconVersion, _0_context, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId(), false);
    _5_valueOrError1 = _out3;
    if (!(!((_5_valueOrError1).IsFailure(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(458,22): " + java.lang.String.valueOf(_5_valueOrError1));
    }
    DynamoDBFilterExpr_Compile.ExprContext _6_newContext;
    _6_newContext = (_5_valueOrError1).Extract(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!(java.util.Objects.equals((_6_newContext).dtor_values(), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString(":Mixed"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("N_"), BeaconTestFixtures_Compile.__default.Name__beacon()), dafny.DafnySequence.asString(".Y_1984")))), new dafny.Tuple2(dafny.DafnySequence.asString(":Name"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(BeaconTestFixtures_Compile.__default.Name__beacon())), new dafny.Tuple2(dafny.DafnySequence.asString(":NameTitle"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("N_"), BeaconTestFixtures_Compile.__default.Name__beacon()), dafny.DafnySequence.asString(".T_")), BeaconTestFixtures_Compile.__default.Title__beacon()))), new dafny.Tuple2(dafny.DafnySequence.asString(":NameTitleTN"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("N_"), BeaconTestFixtures_Compile.__default.Name__beacon()), dafny.DafnySequence.asString(".T_")), BeaconTestFixtures_Compile.__default.Title__beacon()))), new dafny.Tuple2(dafny.DafnySequence.asString(":NameTitleN"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("N_"), BeaconTestFixtures_Compile.__default.Name__beacon()))), new dafny.Tuple2(dafny.DafnySequence.asString(":NameTitleT"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("T_"), BeaconTestFixtures_Compile.__default.Title__beacon()))), new dafny.Tuple2(dafny.DafnySequence.asString(":NameTitleField"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(BeaconTestFixtures_Compile.__default.NameTitle__beacon())), new dafny.Tuple2(dafny.DafnySequence.asString(":std2"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(BeaconTestFixtures_Compile.__default.std2__beacon())), new dafny.Tuple2(dafny.DafnySequence.asString(":Title"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(BeaconTestFixtures_Compile.__default.Title__beacon())), new dafny.Tuple2(dafny.DafnySequence.asString(":std6"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(BeaconTestFixtures_Compile.__default.std6__beacon())), new dafny.Tuple2(dafny.DafnySequence.asString(":std4"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(BeaconTestFixtures_Compile.__default.std4__beacon())), new dafny.Tuple2(dafny.DafnySequence.asString(":YearName"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Y_1984.N_"), BeaconTestFixtures_Compile.__default.Name__beacon())))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(459,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_6_newContext).dtor_names(), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor()))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(473,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestUnusedPartOnly()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _0_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _0_version = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon _1_badBeacon;
    _1_badBeacon = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("badBeacon"), 24, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.TerminalLocation._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_Some(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle.create_partOnly(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PartOnly.create())));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _2_newConfig;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _3_dt__update__tmp_h0 = BeaconTestFixtures_Compile.__default.FullTableConfig();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _4_dt__update_hattributeActionsOnEncrypt_h0 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>update((BeaconTestFixtures_Compile.__default.FullTableConfig()).dtor_attributeActionsOnEncrypt(), dafny.DafnySequence.asString("badBeacon"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN());
    _2_newConfig = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig.create((_3_dt__update__tmp_h0).dtor_logicalTableName(), (_3_dt__update__tmp_h0).dtor_partitionKeyName(), (_3_dt__update__tmp_h0).dtor_sortKeyName(), (_3_dt__update__tmp_h0).dtor_search(), _4_dt__update_hattributeActionsOnEncrypt_h0, (_3_dt__update__tmp_h0).dtor_allowedUnsignedAttributes(), (_3_dt__update__tmp_h0).dtor_allowedUnsignedAttributePrefix(), (_3_dt__update__tmp_h0).dtor_algorithmSuiteId(), (_3_dt__update__tmp_h0).dtor_keyring(), (_3_dt__update__tmp_h0).dtor_cmm(), (_3_dt__update__tmp_h0).dtor_legacyOverride(), (_3_dt__update__tmp_h0).dtor_plaintextOverride());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _5_dt__update__tmp_h1 = _0_version;
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> _6_dt__update_hstandardBeacons_h0 = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon>concatenate((_0_version).dtor_standardBeacons(), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), _1_badBeacon));
    _0_version = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_5_dt__update__tmp_h1).dtor_version(), (_5_dt__update__tmp_h1).dtor_keyStore(), (_5_dt__update__tmp_h1).dtor_keySource(), _6_dt__update_hstandardBeacons_h0, (_5_dt__update__tmp_h1).dtor_compoundBeacons(), (_5_dt__update__tmp_h1).dtor_virtualFields(), (_5_dt__update__tmp_h1).dtor_encryptedParts(), (_5_dt__update__tmp_h1).dtor_signedParts());
    SearchableEncryptionInfo_Compile.KeySource _7_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _0_version);
    _7_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _8_bv;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(_2_newConfig, _0_version, _7_src);
    _8_bv = _out2;
    if (!((_8_bv).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(488,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_8_bv).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("PartOnly beacon badBeacon MUST be used in a compound beacon."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(489,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestCompoundWithUnknown()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart _0_Unknown;
    _0_Unknown = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart.create(dafny.DafnySequence.asString("Unknown"), dafny.DafnySequence.asString("U_"));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon _1_NameUnknown;
    _1_NameUnknown = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon.create(dafny.DafnySequence.asString("NameUnknown"), dafny.DafnySequence.asString("."), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor(), BeaconTestFixtures_Compile.__default.Name(), _0_Unknown)), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPartsList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorList._typeDescriptor()));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _2_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _2_version = _out0;
    if (!(((_2_version).dtor_compoundBeacons()).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(504,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _3_dt__update__tmp_h0 = _2_version;
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>> _4_dt__update_hcompoundBeacons_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>concatenate(((_2_version).dtor_compoundBeacons()).dtor_value(), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor(), _1_NameUnknown)));
    _2_version = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_3_dt__update__tmp_h0).dtor_version(), (_3_dt__update__tmp_h0).dtor_keyStore(), (_3_dt__update__tmp_h0).dtor_keySource(), (_3_dt__update__tmp_h0).dtor_standardBeacons(), _4_dt__update_hcompoundBeacons_h0, (_3_dt__update__tmp_h0).dtor_virtualFields(), (_3_dt__update__tmp_h0).dtor_encryptedParts(), (_3_dt__update__tmp_h0).dtor_signedParts());
    SearchableEncryptionInfo_Compile.KeySource _5_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _2_version);
    _5_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_bv;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _2_version, _5_src);
    _6_bv = _out2;
    if (!((_6_bv).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(508,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_6_bv).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Compound beacon NameUnknown refers to standard beacon Unknown which is not configured."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(509,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TesSetInCompound()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _0_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _0_version = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon _1_setBeacon;
    _1_setBeacon = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("setBeacon"), 24, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.TerminalLocation._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_Some(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle.create_asSet(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.AsSet.create())));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon _2_compoundSet;
    _2_compoundSet = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon.create(dafny.DafnySequence.asString("compoundSet"), dafny.DafnySequence.asString("."), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor(), BeaconTestFixtures_Compile.__default.Name(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart.create(dafny.DafnySequence.asString("setBeacon"), dafny.DafnySequence.asString("S_")))), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPartsList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorList._typeDescriptor()));
    if (!(((_0_version).dtor_compoundBeacons()).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(527,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _3_newConfig;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _4_dt__update__tmp_h0 = BeaconTestFixtures_Compile.__default.FullTableConfig();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _5_dt__update_hattributeActionsOnEncrypt_h0 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>update((BeaconTestFixtures_Compile.__default.FullTableConfig()).dtor_attributeActionsOnEncrypt(), dafny.DafnySequence.asString("setBeacon"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN());
    _3_newConfig = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig.create((_4_dt__update__tmp_h0).dtor_logicalTableName(), (_4_dt__update__tmp_h0).dtor_partitionKeyName(), (_4_dt__update__tmp_h0).dtor_sortKeyName(), (_4_dt__update__tmp_h0).dtor_search(), _5_dt__update_hattributeActionsOnEncrypt_h0, (_4_dt__update__tmp_h0).dtor_allowedUnsignedAttributes(), (_4_dt__update__tmp_h0).dtor_allowedUnsignedAttributePrefix(), (_4_dt__update__tmp_h0).dtor_algorithmSuiteId(), (_4_dt__update__tmp_h0).dtor_keyring(), (_4_dt__update__tmp_h0).dtor_cmm(), (_4_dt__update__tmp_h0).dtor_legacyOverride(), (_4_dt__update__tmp_h0).dtor_plaintextOverride());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _6_dt__update__tmp_h1 = _0_version;
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>> _7_dt__update_hcompoundBeacons_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>concatenate(((_0_version).dtor_compoundBeacons()).dtor_value(), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor(), _2_compoundSet)));
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> _8_dt__update_hstandardBeacons_h0 = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon>concatenate((_0_version).dtor_standardBeacons(), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), _1_setBeacon));
    _0_version = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_6_dt__update__tmp_h1).dtor_version(), (_6_dt__update__tmp_h1).dtor_keyStore(), (_6_dt__update__tmp_h1).dtor_keySource(), _8_dt__update_hstandardBeacons_h0, _7_dt__update_hcompoundBeacons_h0, (_6_dt__update__tmp_h1).dtor_virtualFields(), (_6_dt__update__tmp_h1).dtor_encryptedParts(), (_6_dt__update__tmp_h1).dtor_signedParts());
    SearchableEncryptionInfo_Compile.KeySource _9_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _0_version);
    _9_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _10_bv;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(_3_newConfig, _0_version, _9_src);
    _10_bv = _out2;
    if (!((_10_bv).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(533,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_10_bv).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Compound beacon compoundSet uses setBeacon which is an AsSet beacon, and therefore cannot be used in a Compound Beacon."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(534,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void SharedBadReferenceToCompound()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _0_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _0_version = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon _1_shareBeacon;
    _1_shareBeacon = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("shareBeacon"), 24, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.TerminalLocation._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_Some(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle.create_shared(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Shared.create(dafny.DafnySequence.asString("NameTitle")))));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _2_newConfig;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _3_dt__update__tmp_h0 = BeaconTestFixtures_Compile.__default.FullTableConfig();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _4_dt__update_hattributeActionsOnEncrypt_h0 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>update((BeaconTestFixtures_Compile.__default.FullTableConfig()).dtor_attributeActionsOnEncrypt(), dafny.DafnySequence.asString("shareBeacon"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN());
    _2_newConfig = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig.create((_3_dt__update__tmp_h0).dtor_logicalTableName(), (_3_dt__update__tmp_h0).dtor_partitionKeyName(), (_3_dt__update__tmp_h0).dtor_sortKeyName(), (_3_dt__update__tmp_h0).dtor_search(), _4_dt__update_hattributeActionsOnEncrypt_h0, (_3_dt__update__tmp_h0).dtor_allowedUnsignedAttributes(), (_3_dt__update__tmp_h0).dtor_allowedUnsignedAttributePrefix(), (_3_dt__update__tmp_h0).dtor_algorithmSuiteId(), (_3_dt__update__tmp_h0).dtor_keyring(), (_3_dt__update__tmp_h0).dtor_cmm(), (_3_dt__update__tmp_h0).dtor_legacyOverride(), (_3_dt__update__tmp_h0).dtor_plaintextOverride());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _5_dt__update__tmp_h1 = _0_version;
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> _6_dt__update_hstandardBeacons_h0 = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon>concatenate((_0_version).dtor_standardBeacons(), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), _1_shareBeacon));
    _0_version = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_5_dt__update__tmp_h1).dtor_version(), (_5_dt__update__tmp_h1).dtor_keyStore(), (_5_dt__update__tmp_h1).dtor_keySource(), _6_dt__update_hstandardBeacons_h0, (_5_dt__update__tmp_h1).dtor_compoundBeacons(), (_5_dt__update__tmp_h1).dtor_virtualFields(), (_5_dt__update__tmp_h1).dtor_encryptedParts(), (_5_dt__update__tmp_h1).dtor_signedParts());
    SearchableEncryptionInfo_Compile.KeySource _7_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _0_version);
    _7_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _8_bv;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(_2_newConfig, _0_version, _7_src);
    _8_bv = _out2;
    if (!((_8_bv).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(549,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_8_bv).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Beacon shareBeacon is shared to NameTitle but NameTitle is a compound beacon."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(550,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void ChainedShare()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _0_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _0_version = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon _1_shareBeacon;
    _1_shareBeacon = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("shareBeacon"), 24, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.TerminalLocation._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_Some(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle.create_shared(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Shared.create(dafny.DafnySequence.asString("std2")))));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon _2_other;
    _2_other = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("std4"), 24, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.TerminalLocation._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_Some(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle.create_shared(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Shared.create(dafny.DafnySequence.asString("shareBeacon")))));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _3_newConfig;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _4_dt__update__tmp_h0 = BeaconTestFixtures_Compile.__default.FullTableConfig();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _5_dt__update_hattributeActionsOnEncrypt_h0 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>update((BeaconTestFixtures_Compile.__default.FullTableConfig()).dtor_attributeActionsOnEncrypt(), dafny.DafnySequence.asString("shareBeacon"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN());
    _3_newConfig = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig.create((_4_dt__update__tmp_h0).dtor_logicalTableName(), (_4_dt__update__tmp_h0).dtor_partitionKeyName(), (_4_dt__update__tmp_h0).dtor_sortKeyName(), (_4_dt__update__tmp_h0).dtor_search(), _5_dt__update_hattributeActionsOnEncrypt_h0, (_4_dt__update__tmp_h0).dtor_allowedUnsignedAttributes(), (_4_dt__update__tmp_h0).dtor_allowedUnsignedAttributePrefix(), (_4_dt__update__tmp_h0).dtor_algorithmSuiteId(), (_4_dt__update__tmp_h0).dtor_keyring(), (_4_dt__update__tmp_h0).dtor_cmm(), (_4_dt__update__tmp_h0).dtor_legacyOverride(), (_4_dt__update__tmp_h0).dtor_plaintextOverride());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _6_dt__update__tmp_h1 = _0_version;
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> _7_dt__update_hstandardBeacons_h0 = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), BeaconTestFixtures_Compile.__default.std2(), _1_shareBeacon, _2_other);
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>> _8_dt__update_hcompoundBeacons_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeaconList._typeDescriptor());
    _0_version = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_6_dt__update__tmp_h1).dtor_version(), (_6_dt__update__tmp_h1).dtor_keyStore(), (_6_dt__update__tmp_h1).dtor_keySource(), _7_dt__update_hstandardBeacons_h0, _8_dt__update_hcompoundBeacons_h0, (_6_dt__update__tmp_h1).dtor_virtualFields(), (_6_dt__update__tmp_h1).dtor_encryptedParts(), (_6_dt__update__tmp_h1).dtor_signedParts());
    SearchableEncryptionInfo_Compile.KeySource _9_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _0_version);
    _9_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _10_bv;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(_3_newConfig, _0_version, _9_src);
    _10_bv = _out2;
    if (!((_10_bv).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(569,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_10_bv).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Beacon std4 is shared to shareBeacon which is in turn shared to std2. Share chains are not allowed."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(570,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void SelfShare()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _0_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _0_version = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon _1_shareBeacon;
    _1_shareBeacon = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("shareBeacon"), 24, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.TerminalLocation._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_Some(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle.create_shared(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Shared.create(dafny.DafnySequence.asString("shareBeacon")))));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _2_newConfig;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _3_dt__update__tmp_h0 = BeaconTestFixtures_Compile.__default.FullTableConfig();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _4_dt__update_hattributeActionsOnEncrypt_h0 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>update((BeaconTestFixtures_Compile.__default.FullTableConfig()).dtor_attributeActionsOnEncrypt(), dafny.DafnySequence.asString("shareBeacon"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN());
    _2_newConfig = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig.create((_3_dt__update__tmp_h0).dtor_logicalTableName(), (_3_dt__update__tmp_h0).dtor_partitionKeyName(), (_3_dt__update__tmp_h0).dtor_sortKeyName(), (_3_dt__update__tmp_h0).dtor_search(), _4_dt__update_hattributeActionsOnEncrypt_h0, (_3_dt__update__tmp_h0).dtor_allowedUnsignedAttributes(), (_3_dt__update__tmp_h0).dtor_allowedUnsignedAttributePrefix(), (_3_dt__update__tmp_h0).dtor_algorithmSuiteId(), (_3_dt__update__tmp_h0).dtor_keyring(), (_3_dt__update__tmp_h0).dtor_cmm(), (_3_dt__update__tmp_h0).dtor_legacyOverride(), (_3_dt__update__tmp_h0).dtor_plaintextOverride());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _5_dt__update__tmp_h1 = _0_version;
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> _6_dt__update_hstandardBeacons_h0 = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), BeaconTestFixtures_Compile.__default.std2(), _1_shareBeacon);
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>> _7_dt__update_hcompoundBeacons_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeaconList._typeDescriptor());
    _0_version = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_5_dt__update__tmp_h1).dtor_version(), (_5_dt__update__tmp_h1).dtor_keyStore(), (_5_dt__update__tmp_h1).dtor_keySource(), _6_dt__update_hstandardBeacons_h0, _7_dt__update_hcompoundBeacons_h0, (_5_dt__update__tmp_h1).dtor_virtualFields(), (_5_dt__update__tmp_h1).dtor_encryptedParts(), (_5_dt__update__tmp_h1).dtor_signedParts());
    SearchableEncryptionInfo_Compile.KeySource _8_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _0_version);
    _8_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _9_bv;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(_2_newConfig, _0_version, _8_src);
    _9_bv = _out2;
    if (!((_9_bv).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(585,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_9_bv).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Beacon shareBeacon is shared to itself."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(586,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void SharedBadReferenceNonExistent()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _0_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _0_version = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon _1_shareBeacon;
    _1_shareBeacon = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("shareBeacon"), 24, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.TerminalLocation._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_Some(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle.create_shared(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Shared.create(dafny.DafnySequence.asString("DoesNotExist")))));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _2_dt__update__tmp_h0 = _0_version;
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> _3_dt__update_hstandardBeacons_h0 = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon>concatenate((_0_version).dtor_standardBeacons(), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), _1_shareBeacon));
    _0_version = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_2_dt__update__tmp_h0).dtor_version(), (_2_dt__update__tmp_h0).dtor_keyStore(), (_2_dt__update__tmp_h0).dtor_keySource(), _3_dt__update_hstandardBeacons_h0, (_2_dt__update__tmp_h0).dtor_compoundBeacons(), (_2_dt__update__tmp_h0).dtor_virtualFields(), (_2_dt__update__tmp_h0).dtor_encryptedParts(), (_2_dt__update__tmp_h0).dtor_signedParts());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _4_newConfig;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _5_dt__update__tmp_h1 = BeaconTestFixtures_Compile.__default.FullTableConfig();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _6_dt__update_hattributeActionsOnEncrypt_h0 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>update((BeaconTestFixtures_Compile.__default.FullTableConfig()).dtor_attributeActionsOnEncrypt(), dafny.DafnySequence.asString("shareBeacon"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN());
    _4_newConfig = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig.create((_5_dt__update__tmp_h1).dtor_logicalTableName(), (_5_dt__update__tmp_h1).dtor_partitionKeyName(), (_5_dt__update__tmp_h1).dtor_sortKeyName(), (_5_dt__update__tmp_h1).dtor_search(), _6_dt__update_hattributeActionsOnEncrypt_h0, (_5_dt__update__tmp_h1).dtor_allowedUnsignedAttributes(), (_5_dt__update__tmp_h1).dtor_allowedUnsignedAttributePrefix(), (_5_dt__update__tmp_h1).dtor_algorithmSuiteId(), (_5_dt__update__tmp_h1).dtor_keyring(), (_5_dt__update__tmp_h1).dtor_cmm(), (_5_dt__update__tmp_h1).dtor_legacyOverride(), (_5_dt__update__tmp_h1).dtor_plaintextOverride());
    SearchableEncryptionInfo_Compile.KeySource _7_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _0_version);
    _7_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _8_bv;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(_4_newConfig, _0_version, _7_src);
    _8_bv = _out2;
    if (!((_8_bv).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(601,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_8_bv).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Beacon shareBeacon is shared to DoesNotExist which is not defined."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(602,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void SharedBadLength()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _0_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _0_version = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon _1_shareBeacon;
    _1_shareBeacon = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("shareBeacon"), 23, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.TerminalLocation._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_Some(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle.create_shared(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Shared.create(dafny.DafnySequence.asString("std2")))));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _2_dt__update__tmp_h0 = _0_version;
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> _3_dt__update_hstandardBeacons_h0 = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon>concatenate((_0_version).dtor_standardBeacons(), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), _1_shareBeacon));
    _0_version = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_2_dt__update__tmp_h0).dtor_version(), (_2_dt__update__tmp_h0).dtor_keyStore(), (_2_dt__update__tmp_h0).dtor_keySource(), _3_dt__update_hstandardBeacons_h0, (_2_dt__update__tmp_h0).dtor_compoundBeacons(), (_2_dt__update__tmp_h0).dtor_virtualFields(), (_2_dt__update__tmp_h0).dtor_encryptedParts(), (_2_dt__update__tmp_h0).dtor_signedParts());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _4_newConfig;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _5_dt__update__tmp_h1 = BeaconTestFixtures_Compile.__default.FullTableConfig();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _6_dt__update_hattributeActionsOnEncrypt_h0 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>update((BeaconTestFixtures_Compile.__default.FullTableConfig()).dtor_attributeActionsOnEncrypt(), dafny.DafnySequence.asString("shareBeacon"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN());
    _4_newConfig = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig.create((_5_dt__update__tmp_h1).dtor_logicalTableName(), (_5_dt__update__tmp_h1).dtor_partitionKeyName(), (_5_dt__update__tmp_h1).dtor_sortKeyName(), (_5_dt__update__tmp_h1).dtor_search(), _6_dt__update_hattributeActionsOnEncrypt_h0, (_5_dt__update__tmp_h1).dtor_allowedUnsignedAttributes(), (_5_dt__update__tmp_h1).dtor_allowedUnsignedAttributePrefix(), (_5_dt__update__tmp_h1).dtor_algorithmSuiteId(), (_5_dt__update__tmp_h1).dtor_keyring(), (_5_dt__update__tmp_h1).dtor_cmm(), (_5_dt__update__tmp_h1).dtor_legacyOverride(), (_5_dt__update__tmp_h1).dtor_plaintextOverride());
    SearchableEncryptionInfo_Compile.KeySource _7_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _0_version);
    _7_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _8_bv;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(_4_newConfig, _0_version, _7_src);
    _8_bv = _out2;
    if (!((_8_bv).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(618,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_8_bv).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Beacon shareBeacon is shared to std2 but shareBeacon has length 23 and std2 has length 24."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(619,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestPartOnlyNotStored()
  {
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _0_MyItem;
    _0_MyItem = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("std2"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("abc"))), new dafny.Tuple2(dafny.DafnySequence.asString("partOnly"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("def"))));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon _1_compoundPart;
    _1_compoundPart = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon.create(dafny.DafnySequence.asString("compoundPart"), dafny.DafnySequence.asString("."), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart.create(dafny.DafnySequence.asString("partOnly"), dafny.DafnySequence.asString("S_")))), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPartsList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorList._typeDescriptor()));
    DynamoDBFilterExpr_Compile.ExprContext _2_context;
    _2_context = DynamoDBFilterExpr_Compile.ExprContext.create(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("partOnly = :val")), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString(":val"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("foo"))))), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor())));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _3_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _3_version = _out0;
    if (!(((_3_version).dtor_compoundBeacons()).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(643,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon _4_partBeacon;
    _4_partBeacon = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("partOnly"), 23, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.TerminalLocation._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor()));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _5_newVersion;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _6_dt__update__tmp_h0 = _3_version;
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>> _7_dt__update_hcompoundBeacons_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>concatenate(((_3_version).dtor_compoundBeacons()).dtor_value(), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor(), _1_compoundPart)));
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> _8_dt__update_hstandardBeacons_h0 = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon>concatenate((_3_version).dtor_standardBeacons(), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), _4_partBeacon));
    _5_newVersion = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_6_dt__update__tmp_h0).dtor_version(), (_6_dt__update__tmp_h0).dtor_keyStore(), (_6_dt__update__tmp_h0).dtor_keySource(), _8_dt__update_hstandardBeacons_h0, _7_dt__update_hcompoundBeacons_h0, (_6_dt__update__tmp_h0).dtor_virtualFields(), (_6_dt__update__tmp_h0).dtor_encryptedParts(), (_6_dt__update__tmp_h0).dtor_signedParts());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _9_newConfig;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _10_dt__update__tmp_h1 = BeaconTestFixtures_Compile.__default.FullTableConfig();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _11_dt__update_hattributeActionsOnEncrypt_h0 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>update((BeaconTestFixtures_Compile.__default.FullTableConfig()).dtor_attributeActionsOnEncrypt(), dafny.DafnySequence.asString("partOnly"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN());
    _9_newConfig = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig.create((_10_dt__update__tmp_h1).dtor_logicalTableName(), (_10_dt__update__tmp_h1).dtor_partitionKeyName(), (_10_dt__update__tmp_h1).dtor_sortKeyName(), (_10_dt__update__tmp_h1).dtor_search(), _11_dt__update_hattributeActionsOnEncrypt_h0, (_10_dt__update__tmp_h1).dtor_allowedUnsignedAttributes(), (_10_dt__update__tmp_h1).dtor_allowedUnsignedAttributePrefix(), (_10_dt__update__tmp_h1).dtor_algorithmSuiteId(), (_10_dt__update__tmp_h1).dtor_keyring(), (_10_dt__update__tmp_h1).dtor_cmm(), (_10_dt__update__tmp_h1).dtor_legacyOverride(), (_10_dt__update__tmp_h1).dtor_plaintextOverride());
    SearchableEncryptionInfo_Compile.KeySource _12_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _5_newVersion);
    _12_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _13_valueOrError0 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(_9_newConfig, _5_newVersion, _12_src);
    _13_valueOrError0 = _out2;
    if (!(!((_13_valueOrError0).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(652,14): " + java.lang.String.valueOf(_13_valueOrError0));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _14_bv;
    _14_bv = (_13_valueOrError0).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _15_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out3;
    _out3 = (_14_bv).GenerateEncryptedBeacons(_0_MyItem, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    _15_valueOrError1 = _out3;
    if (!(!((_15_valueOrError1).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(654,21): " + java.lang.String.valueOf(_15_valueOrError1));
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _16_goodAttrs;
    _16_goodAttrs = (_15_valueOrError1).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!((_16_goodAttrs).equals(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_b_std2"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("51e1da"))), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_b_partOnly"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("405a51"))), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_b_compoundPart"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("S_405a51"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(655,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _17_goodQuery;
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out4;
    _out4 = DynamoDBFilterExpr_Compile.__default.Beaconize(_14_bv, _2_context, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId(), false);
    _17_goodQuery = _out4;
    if (!((_17_goodQuery).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(661,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    _4_partBeacon = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("partOnly"), 23, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.TerminalLocation._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_Some(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle.create_partOnly(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PartOnly.create())));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _18_dt__update__tmp_h2 = _3_version;
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>> _19_dt__update_hcompoundBeacons_h1 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>concatenate(((_3_version).dtor_compoundBeacons()).dtor_value(), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor(), _1_compoundPart)));
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> _20_dt__update_hstandardBeacons_h1 = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon>concatenate((_3_version).dtor_standardBeacons(), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), _4_partBeacon));
    _5_newVersion = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_18_dt__update__tmp_h2).dtor_version(), (_18_dt__update__tmp_h2).dtor_keyStore(), (_18_dt__update__tmp_h2).dtor_keySource(), _20_dt__update_hstandardBeacons_h1, _19_dt__update_hcompoundBeacons_h1, (_18_dt__update__tmp_h2).dtor_virtualFields(), (_18_dt__update__tmp_h2).dtor_encryptedParts(), (_18_dt__update__tmp_h2).dtor_signedParts());
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _21_valueOrError2 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out5;
    _out5 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(_9_newConfig, _5_newVersion, _12_src);
    _21_valueOrError2 = _out5;
    if (!(!((_21_valueOrError2).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(672,10): " + java.lang.String.valueOf(_21_valueOrError2));
    }
    _14_bv = (_21_valueOrError2).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _22_valueOrError3 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out6;
    _out6 = (_14_bv).GenerateEncryptedBeacons(_0_MyItem, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    _22_valueOrError3 = _out6;
    if (!(!((_22_valueOrError3).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(673,17): " + java.lang.String.valueOf(_22_valueOrError3));
    }
    _16_goodAttrs = (_22_valueOrError3).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!((_16_goodAttrs).equals(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_b_std2"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("51e1da"))), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_b_compoundPart"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("S_405a51"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(678,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _23_badQuery;
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out7;
    _out7 = DynamoDBFilterExpr_Compile.__default.Beaconize(_14_bv, _2_context, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId(), false);
    _23_badQuery = _out7;
    if (!((_23_badQuery).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(687,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_23_badQuery).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Field partOnly is encrypted, and has a PartOnly beacon, and so can only be used as part of a compound beacon."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(688,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestShareSameBeacon()
  {
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _0_MyItem;
    _0_MyItem = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("std2"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("abc"))), new dafny.Tuple2(dafny.DafnySequence.asString("partOnly"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("abc"))));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _1_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _1_version = _out0;
    if (!(((_1_version).dtor_compoundBeacons()).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(699,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon _2_partBeacon;
    _2_partBeacon = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("partOnly"), 24, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.TerminalLocation._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor()));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _3_newVersion;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _4_dt__update__tmp_h0 = _1_version;
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> _5_dt__update_hstandardBeacons_h0 = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon>concatenate((_1_version).dtor_standardBeacons(), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), _2_partBeacon));
    _3_newVersion = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_4_dt__update__tmp_h0).dtor_version(), (_4_dt__update__tmp_h0).dtor_keyStore(), (_4_dt__update__tmp_h0).dtor_keySource(), _5_dt__update_hstandardBeacons_h0, (_4_dt__update__tmp_h0).dtor_compoundBeacons(), (_4_dt__update__tmp_h0).dtor_virtualFields(), (_4_dt__update__tmp_h0).dtor_encryptedParts(), (_4_dt__update__tmp_h0).dtor_signedParts());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _6_newConfig;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _7_dt__update__tmp_h1 = BeaconTestFixtures_Compile.__default.FullTableConfig();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _8_dt__update_hattributeActionsOnEncrypt_h0 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>update((BeaconTestFixtures_Compile.__default.FullTableConfig()).dtor_attributeActionsOnEncrypt(), dafny.DafnySequence.asString("partOnly"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN());
    _6_newConfig = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig.create((_7_dt__update__tmp_h1).dtor_logicalTableName(), (_7_dt__update__tmp_h1).dtor_partitionKeyName(), (_7_dt__update__tmp_h1).dtor_sortKeyName(), (_7_dt__update__tmp_h1).dtor_search(), _8_dt__update_hattributeActionsOnEncrypt_h0, (_7_dt__update__tmp_h1).dtor_allowedUnsignedAttributes(), (_7_dt__update__tmp_h1).dtor_allowedUnsignedAttributePrefix(), (_7_dt__update__tmp_h1).dtor_algorithmSuiteId(), (_7_dt__update__tmp_h1).dtor_keyring(), (_7_dt__update__tmp_h1).dtor_cmm(), (_7_dt__update__tmp_h1).dtor_legacyOverride(), (_7_dt__update__tmp_h1).dtor_plaintextOverride());
    SearchableEncryptionInfo_Compile.KeySource _9_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _3_newVersion);
    _9_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _10_valueOrError0 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(_6_newConfig, _3_newVersion, _9_src);
    _10_valueOrError0 = _out2;
    if (!(!((_10_valueOrError0).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(707,14): " + java.lang.String.valueOf(_10_valueOrError0));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _11_bv;
    _11_bv = (_10_valueOrError0).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _12_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out3;
    _out3 = (_11_bv).GenerateEncryptedBeacons(_0_MyItem, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    _12_valueOrError1 = _out3;
    if (!(!((_12_valueOrError1).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(709,21): " + java.lang.String.valueOf(_12_valueOrError1));
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _13_goodAttrs;
    _13_goodAttrs = (_12_valueOrError1).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!((_13_goodAttrs).equals(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_b_std2"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("51e1da"))), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_b_partOnly"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("928d9b"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(710,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    _2_partBeacon = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("partOnly"), 24, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.TerminalLocation._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_Some(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle.create_shared(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Shared.create(dafny.DafnySequence.asString("std2")))));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _14_dt__update__tmp_h2 = _1_version;
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> _15_dt__update_hstandardBeacons_h1 = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon>concatenate((_1_version).dtor_standardBeacons(), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), _2_partBeacon));
    _3_newVersion = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_14_dt__update__tmp_h2).dtor_version(), (_14_dt__update__tmp_h2).dtor_keyStore(), (_14_dt__update__tmp_h2).dtor_keySource(), _15_dt__update_hstandardBeacons_h1, (_14_dt__update__tmp_h2).dtor_compoundBeacons(), (_14_dt__update__tmp_h2).dtor_virtualFields(), (_14_dt__update__tmp_h2).dtor_encryptedParts(), (_14_dt__update__tmp_h2).dtor_signedParts());
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _16_valueOrError2 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out4;
    _out4 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(_6_newConfig, _3_newVersion, _9_src);
    _16_valueOrError2 = _out4;
    if (!(!((_16_valueOrError2).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(723,10): " + java.lang.String.valueOf(_16_valueOrError2));
    }
    _11_bv = (_16_valueOrError2).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _17_valueOrError3 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out5;
    _out5 = (_11_bv).GenerateEncryptedBeacons(_0_MyItem, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    _17_valueOrError3 = _out5;
    if (!(!((_17_valueOrError3).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(724,17): " + java.lang.String.valueOf(_17_valueOrError3));
    }
    _13_goodAttrs = (_17_valueOrError3).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!((_13_goodAttrs).equals(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_b_std2"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("51e1da"))), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_b_partOnly"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("51e1da"))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(729,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    DynamoDBFilterExpr_Compile.ExprContext _18_context;
    _18_context = DynamoDBFilterExpr_Compile.ExprContext.create(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("partOnly = :pVal AND std2 = :sVal")), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString(":pVal"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("foo"))), new dafny.Tuple2(dafny.DafnySequence.asString(":sVal"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("foo"))))), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor())));
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _19_valueOrError4 = Wrappers_Compile.Result.<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDBFilterExpr_Compile.ExprContext.Default());
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out6;
    _out6 = DynamoDBFilterExpr_Compile.__default.Beaconize(_11_bv, _18_context, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId(), false);
    _19_valueOrError4 = _out6;
    if (!(!((_19_valueOrError4).IsFailure(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(741,21): " + java.lang.String.valueOf(_19_valueOrError4));
    }
    DynamoDBFilterExpr_Compile.ExprContext _20_goodQuery;
    _20_goodQuery = (_19_valueOrError4).Extract(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!(java.util.Objects.equals((_20_goodQuery).dtor_values(), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString(":pVal"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("4379a7"))), new dafny.Tuple2(dafny.DafnySequence.asString(":sVal"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("4379a7")))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(742,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestBeaconSetQuery()
  {
    DynamoDBFilterExpr_Compile.ExprContext _0_context;
    _0_context = DynamoDBFilterExpr_Compile.ExprContext.create(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("setAttr = :setVal")), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString(":setVal"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_SS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("abc"), dafny.DafnySequence.asString("def"), dafny.DafnySequence.asString("ghi")))))), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor())));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon _1_setBeacon;
    _1_setBeacon = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("setAttr"), 24, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.TerminalLocation._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_Some(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle.create_asSet(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.AsSet.create())));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _2_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _2_version = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _3_newVersion;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _4_dt__update__tmp_h0 = _2_version;
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> _5_dt__update_hstandardBeacons_h0 = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon>concatenate((_2_version).dtor_standardBeacons(), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), _1_setBeacon));
    _3_newVersion = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_4_dt__update__tmp_h0).dtor_version(), (_4_dt__update__tmp_h0).dtor_keyStore(), (_4_dt__update__tmp_h0).dtor_keySource(), _5_dt__update_hstandardBeacons_h0, (_4_dt__update__tmp_h0).dtor_compoundBeacons(), (_4_dt__update__tmp_h0).dtor_virtualFields(), (_4_dt__update__tmp_h0).dtor_encryptedParts(), (_4_dt__update__tmp_h0).dtor_signedParts());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _6_newConfig;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _7_dt__update__tmp_h1 = BeaconTestFixtures_Compile.__default.FullTableConfig();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _8_dt__update_hattributeActionsOnEncrypt_h0 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>update((BeaconTestFixtures_Compile.__default.FullTableConfig()).dtor_attributeActionsOnEncrypt(), dafny.DafnySequence.asString("setAttr"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN());
    _6_newConfig = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig.create((_7_dt__update__tmp_h1).dtor_logicalTableName(), (_7_dt__update__tmp_h1).dtor_partitionKeyName(), (_7_dt__update__tmp_h1).dtor_sortKeyName(), (_7_dt__update__tmp_h1).dtor_search(), _8_dt__update_hattributeActionsOnEncrypt_h0, (_7_dt__update__tmp_h1).dtor_allowedUnsignedAttributes(), (_7_dt__update__tmp_h1).dtor_allowedUnsignedAttributePrefix(), (_7_dt__update__tmp_h1).dtor_algorithmSuiteId(), (_7_dt__update__tmp_h1).dtor_keyring(), (_7_dt__update__tmp_h1).dtor_cmm(), (_7_dt__update__tmp_h1).dtor_legacyOverride(), (_7_dt__update__tmp_h1).dtor_plaintextOverride());
    SearchableEncryptionInfo_Compile.KeySource _9_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _3_newVersion);
    _9_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _10_valueOrError0 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(_6_newConfig, _3_newVersion, _9_src);
    _10_valueOrError0 = _out2;
    if (!(!((_10_valueOrError0).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(765,14): " + java.lang.String.valueOf(_10_valueOrError0));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _11_bv;
    _11_bv = (_10_valueOrError0).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _12_valueOrError1 = Wrappers_Compile.Result.<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDBFilterExpr_Compile.ExprContext.Default());
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out3;
    _out3 = DynamoDBFilterExpr_Compile.__default.Beaconize(_11_bv, _0_context, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId(), false);
    _12_valueOrError1 = _out3;
    if (!(!((_12_valueOrError1).IsFailure(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(768,21): " + java.lang.String.valueOf(_12_valueOrError1));
    }
    DynamoDBFilterExpr_Compile.ExprContext _13_goodQuery;
    _13_goodQuery = (_12_valueOrError1).Extract(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!(java.util.Objects.equals((_13_goodQuery).dtor_values(), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString(":setVal"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_SS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("43c4d8"), dafny.DafnySequence.asString("2f3278"), dafny.DafnySequence.asString("f1972e"))))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(769,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    _0_context = DynamoDBFilterExpr_Compile.ExprContext.create(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("setAttr = :setVal")), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString(":setVal"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("abc"))))), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor())));
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _14_valueOrError2 = Wrappers_Compile.Result.<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDBFilterExpr_Compile.ExprContext.Default());
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out4;
    _out4 = DynamoDBFilterExpr_Compile.__default.Beaconize(_11_bv, _0_context, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId(), false);
    _14_valueOrError2 = _out4;
    if (!(!((_14_valueOrError2).IsFailure(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(777,17): " + java.lang.String.valueOf(_14_valueOrError2));
    }
    _13_goodQuery = (_14_valueOrError2).Extract(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    _0_context = DynamoDBFilterExpr_Compile.ExprContext.create(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("setAttr = :setVal")), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString(":setVal"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_L(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()))))), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor())));
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _15_badQuery;
    Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out5;
    _out5 = DynamoDBFilterExpr_Compile.__default.Beaconize(_11_bv, _0_context, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId(), false);
    _15_badQuery = _out5;
    if (!((_15_badQuery).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(786,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_15_badQuery).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Beacon setAttr has style AsSet, but attribute has type L."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(787,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestSetNotSet()
  {
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _0_MyItem;
    _0_MyItem = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("std2"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("abc"))), new dafny.Tuple2(dafny.DafnySequence.asString("partOnly"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_SS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("abc"), dafny.DafnySequence.asString("def"), dafny.DafnySequence.asString("ghi")))));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _1_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _1_version = _out0;
    if (!(((_1_version).dtor_compoundBeacons()).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(798,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon _2_partBeacon;
    _2_partBeacon = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("partOnly"), 24, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.TerminalLocation._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_Some(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle.create_asSet(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.AsSet.create())));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _3_newVersion;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _4_dt__update__tmp_h0 = _1_version;
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> _5_dt__update_hstandardBeacons_h0 = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon>concatenate((_1_version).dtor_standardBeacons(), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), _2_partBeacon));
    _3_newVersion = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_4_dt__update__tmp_h0).dtor_version(), (_4_dt__update__tmp_h0).dtor_keyStore(), (_4_dt__update__tmp_h0).dtor_keySource(), _5_dt__update_hstandardBeacons_h0, (_4_dt__update__tmp_h0).dtor_compoundBeacons(), (_4_dt__update__tmp_h0).dtor_virtualFields(), (_4_dt__update__tmp_h0).dtor_encryptedParts(), (_4_dt__update__tmp_h0).dtor_signedParts());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _6_newConfig;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _7_dt__update__tmp_h1 = BeaconTestFixtures_Compile.__default.FullTableConfig();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _8_dt__update_hattributeActionsOnEncrypt_h0 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>update((BeaconTestFixtures_Compile.__default.FullTableConfig()).dtor_attributeActionsOnEncrypt(), dafny.DafnySequence.asString("partOnly"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN());
    _6_newConfig = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig.create((_7_dt__update__tmp_h1).dtor_logicalTableName(), (_7_dt__update__tmp_h1).dtor_partitionKeyName(), (_7_dt__update__tmp_h1).dtor_sortKeyName(), (_7_dt__update__tmp_h1).dtor_search(), _8_dt__update_hattributeActionsOnEncrypt_h0, (_7_dt__update__tmp_h1).dtor_allowedUnsignedAttributes(), (_7_dt__update__tmp_h1).dtor_allowedUnsignedAttributePrefix(), (_7_dt__update__tmp_h1).dtor_algorithmSuiteId(), (_7_dt__update__tmp_h1).dtor_keyring(), (_7_dt__update__tmp_h1).dtor_cmm(), (_7_dt__update__tmp_h1).dtor_legacyOverride(), (_7_dt__update__tmp_h1).dtor_plaintextOverride());
    SearchableEncryptionInfo_Compile.KeySource _9_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _3_newVersion);
    _9_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _10_valueOrError0 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(_6_newConfig, _3_newVersion, _9_src);
    _10_valueOrError0 = _out2;
    if (!(!((_10_valueOrError0).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(809,14): " + java.lang.String.valueOf(_10_valueOrError0));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _11_bv;
    _11_bv = (_10_valueOrError0).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!(((_11_bv).dtor_beacons()).<dafny.DafnySequence<? extends Character>>contains(dafny.DafnySequence.asString("partOnly")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(810,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)(((_11_bv).dtor_beacons()).get(dafny.DafnySequence.asString("partOnly"))))).is_Standard())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(811,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _12_goodAttrs;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out3;
    _out3 = (_11_bv).GenerateEncryptedBeacons(_0_MyItem, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    _12_goodAttrs = _out3;
    if ((_12_goodAttrs).is_Failure()) {
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
      System.out.print(java.lang.String.valueOf((_12_goodAttrs).dtor_error()));
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
    }
    if (!((_12_goodAttrs).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(820,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((_12_goodAttrs).dtor_value()).equals(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_b_std2"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("51e1da"))), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_b_partOnly"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_SS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("928d9b"), dafny.DafnySequence.asString("405a51"), dafny.DafnySequence.asString("9c6c2e")))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(821,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _13_BadItem;
    _13_BadItem = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>update(_0_MyItem, dafny.DafnySequence.asString("partOnly"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("abc")));
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _14_badAttrs;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out4;
    _out4 = (_11_bv).GenerateEncryptedBeacons(_13_BadItem, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    _14_badAttrs = _out4;
    if (!((_14_badAttrs).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(832,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_14_badAttrs).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Beacon partOnly has style AsSet, but attribute has type S."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(833,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestSharedSet()
  {
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _0_MyItem;
    _0_MyItem = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("std2"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("abc"))), new dafny.Tuple2(dafny.DafnySequence.asString("partOnly"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_SS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("abc"), dafny.DafnySequence.asString("def"), dafny.DafnySequence.asString("ghi")))));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _1_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _1_version = _out0;
    if (!(((_1_version).dtor_compoundBeacons()).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(844,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon _2_partBeacon;
    _2_partBeacon = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("partOnly"), 24, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.TerminalLocation._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_Some(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle.create_sharedSet(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SharedSet.create(dafny.DafnySequence.asString("std2")))));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _3_newVersion;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _4_dt__update__tmp_h0 = _1_version;
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> _5_dt__update_hstandardBeacons_h0 = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon>concatenate((_1_version).dtor_standardBeacons(), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), _2_partBeacon));
    _3_newVersion = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_4_dt__update__tmp_h0).dtor_version(), (_4_dt__update__tmp_h0).dtor_keyStore(), (_4_dt__update__tmp_h0).dtor_keySource(), _5_dt__update_hstandardBeacons_h0, (_4_dt__update__tmp_h0).dtor_compoundBeacons(), (_4_dt__update__tmp_h0).dtor_virtualFields(), (_4_dt__update__tmp_h0).dtor_encryptedParts(), (_4_dt__update__tmp_h0).dtor_signedParts());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _6_newConfig;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _7_dt__update__tmp_h1 = BeaconTestFixtures_Compile.__default.FullTableConfig();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _8_dt__update_hattributeActionsOnEncrypt_h0 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>update((BeaconTestFixtures_Compile.__default.FullTableConfig()).dtor_attributeActionsOnEncrypt(), dafny.DafnySequence.asString("partOnly"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN());
    _6_newConfig = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig.create((_7_dt__update__tmp_h1).dtor_logicalTableName(), (_7_dt__update__tmp_h1).dtor_partitionKeyName(), (_7_dt__update__tmp_h1).dtor_sortKeyName(), (_7_dt__update__tmp_h1).dtor_search(), _8_dt__update_hattributeActionsOnEncrypt_h0, (_7_dt__update__tmp_h1).dtor_allowedUnsignedAttributes(), (_7_dt__update__tmp_h1).dtor_allowedUnsignedAttributePrefix(), (_7_dt__update__tmp_h1).dtor_algorithmSuiteId(), (_7_dt__update__tmp_h1).dtor_keyring(), (_7_dt__update__tmp_h1).dtor_cmm(), (_7_dt__update__tmp_h1).dtor_legacyOverride(), (_7_dt__update__tmp_h1).dtor_plaintextOverride());
    SearchableEncryptionInfo_Compile.KeySource _9_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _3_newVersion);
    _9_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _10_valueOrError0 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(_6_newConfig, _3_newVersion, _9_src);
    _10_valueOrError0 = _out2;
    if (!(!((_10_valueOrError0).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(855,14): " + java.lang.String.valueOf(_10_valueOrError0));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _11_bv;
    _11_bv = (_10_valueOrError0).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!(((_11_bv).dtor_beacons()).<dafny.DafnySequence<? extends Character>>contains(dafny.DafnySequence.asString("partOnly")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(856,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)(((_11_bv).dtor_beacons()).get(dafny.DafnySequence.asString("partOnly"))))).is_Standard())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(857,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _12_goodAttrs;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out3;
    _out3 = (_11_bv).GenerateEncryptedBeacons(_0_MyItem, DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    _12_goodAttrs = _out3;
    if ((_12_goodAttrs).is_Failure()) {
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
      System.out.print(java.lang.String.valueOf((_12_goodAttrs).dtor_error()));
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
    }
    if (!((_12_goodAttrs).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(866,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((_12_goodAttrs).dtor_value()).equals(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_b_std2"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(dafny.DafnySequence.asString("51e1da"))), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_b_partOnly"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_SS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("51e1da"), dafny.DafnySequence.asString("39ef85"), dafny.DafnySequence.asString("3ff06a")))))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(867,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void GlobalPartNotExist()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _0_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _0_version = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart _1_NotExist;
    _1_NotExist = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart.create(dafny.DafnySequence.asString("NotExist"), dafny.DafnySequence.asString("Q_"));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _2_dt__update__tmp_h0 = _0_version;
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>> _3_dt__update_hencryptedParts_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor(), _1_NotExist));
    _0_version = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_2_dt__update__tmp_h0).dtor_version(), (_2_dt__update__tmp_h0).dtor_keyStore(), (_2_dt__update__tmp_h0).dtor_keySource(), (_2_dt__update__tmp_h0).dtor_standardBeacons(), (_2_dt__update__tmp_h0).dtor_compoundBeacons(), (_2_dt__update__tmp_h0).dtor_virtualFields(), _3_dt__update_hencryptedParts_h0, (_2_dt__update__tmp_h0).dtor_signedParts());
    SearchableEncryptionInfo_Compile.KeySource _4_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _0_version);
    _4_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_bv;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _0_version, _4_src);
    _5_bv = _out2;
    if (!((_5_bv).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(881,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_5_bv).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Global Parts List refers to standard beacon NotExist which is not configured."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(882,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void DuplicateGlobalSigned()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _0_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _0_version = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _1_dt__update__tmp_h0 = _0_version;
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>> _2_dt__update_hsignedParts_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart._typeDescriptor(), BeaconTestFixtures_Compile.__default.Year(), BeaconTestFixtures_Compile.__default.Month(), BeaconTestFixtures_Compile.__default.Year()));
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>> _3_dt__update_hcompoundBeacons_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeaconList._typeDescriptor());
    _0_version = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_1_dt__update__tmp_h0).dtor_version(), (_1_dt__update__tmp_h0).dtor_keyStore(), (_1_dt__update__tmp_h0).dtor_keySource(), (_1_dt__update__tmp_h0).dtor_standardBeacons(), _3_dt__update_hcompoundBeacons_h0, (_1_dt__update__tmp_h0).dtor_virtualFields(), (_1_dt__update__tmp_h0).dtor_encryptedParts(), _2_dt__update_hsignedParts_h0);
    SearchableEncryptionInfo_Compile.KeySource _4_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _0_version);
    _4_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_bv;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _0_version, _4_src);
    _5_bv = _out2;
    if (!((_5_bv).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(891,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_5_bv).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Duplicate part name Year in Global Parts List."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(892,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void DuplicateGlobalEncrypted()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _0_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _0_version = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _1_dt__update__tmp_h0 = _0_version;
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>> _2_dt__update_hencryptedParts_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor(), BeaconTestFixtures_Compile.__default.Name(), BeaconTestFixtures_Compile.__default.Title(), BeaconTestFixtures_Compile.__default.Name()));
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>> _3_dt__update_hcompoundBeacons_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeaconList._typeDescriptor());
    _0_version = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_1_dt__update__tmp_h0).dtor_version(), (_1_dt__update__tmp_h0).dtor_keyStore(), (_1_dt__update__tmp_h0).dtor_keySource(), (_1_dt__update__tmp_h0).dtor_standardBeacons(), _3_dt__update_hcompoundBeacons_h0, (_1_dt__update__tmp_h0).dtor_virtualFields(), _2_dt__update_hencryptedParts_h0, (_1_dt__update__tmp_h0).dtor_signedParts());
    SearchableEncryptionInfo_Compile.KeySource _4_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _0_version);
    _4_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_bv;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _0_version, _4_src);
    _5_bv = _out2;
    if (!((_5_bv).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(901,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_5_bv).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Duplicate part name Name in Global Parts List."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(902,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void DuplicateGlobalPrefix()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _0_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _0_version = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart _1_Std6;
    _1_Std6 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart.create(dafny.DafnySequence.asString("std6"), dafny.DafnySequence.asString("N_"));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _2_dt__update__tmp_h0 = _0_version;
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>> _3_dt__update_hencryptedParts_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor(), BeaconTestFixtures_Compile.__default.Name(), BeaconTestFixtures_Compile.__default.Title(), _1_Std6));
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>> _4_dt__update_hcompoundBeacons_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeaconList._typeDescriptor());
    _0_version = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_2_dt__update__tmp_h0).dtor_version(), (_2_dt__update__tmp_h0).dtor_keyStore(), (_2_dt__update__tmp_h0).dtor_keySource(), (_2_dt__update__tmp_h0).dtor_standardBeacons(), _4_dt__update_hcompoundBeacons_h0, (_2_dt__update__tmp_h0).dtor_virtualFields(), _3_dt__update_hencryptedParts_h0, (_2_dt__update__tmp_h0).dtor_signedParts());
    SearchableEncryptionInfo_Compile.KeySource _5_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _0_version);
    _5_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_bv;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _0_version, _5_src);
    _6_bv = _out2;
    if (!((_6_bv).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(912,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_6_bv).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Duplicate prefix N_ in Global Parts List."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(913,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void DuplicateGlobalVsLocalEncrypted()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _0_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _0_version = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _1_dt__update__tmp_h0 = _0_version;
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>> _2_dt__update_hencryptedParts_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor(), BeaconTestFixtures_Compile.__default.Name()));
    _0_version = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_1_dt__update__tmp_h0).dtor_version(), (_1_dt__update__tmp_h0).dtor_keyStore(), (_1_dt__update__tmp_h0).dtor_keySource(), (_1_dt__update__tmp_h0).dtor_standardBeacons(), (_1_dt__update__tmp_h0).dtor_compoundBeacons(), (_1_dt__update__tmp_h0).dtor_virtualFields(), _2_dt__update_hencryptedParts_h0, (_1_dt__update__tmp_h0).dtor_signedParts());
    SearchableEncryptionInfo_Compile.KeySource _3_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _0_version);
    _3_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_bv;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _0_version, _3_src);
    _4_bv = _out2;
    if (!((_4_bv).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(922,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_4_bv).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Compound beacon NameTitle defines encrypted part Name which is already defined as a global part."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(923,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void DuplicateGlobalVsLocalSigned()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _0_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _0_version = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _1_dt__update__tmp_h0 = _0_version;
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>> _2_dt__update_hsignedParts_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart._typeDescriptor(), BeaconTestFixtures_Compile.__default.Month()));
    _0_version = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_1_dt__update__tmp_h0).dtor_version(), (_1_dt__update__tmp_h0).dtor_keyStore(), (_1_dt__update__tmp_h0).dtor_keySource(), (_1_dt__update__tmp_h0).dtor_standardBeacons(), (_1_dt__update__tmp_h0).dtor_compoundBeacons(), (_1_dt__update__tmp_h0).dtor_virtualFields(), (_1_dt__update__tmp_h0).dtor_encryptedParts(), _2_dt__update_hsignedParts_h0);
    SearchableEncryptionInfo_Compile.KeySource _3_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _0_version);
    _3_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_bv;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _0_version, _3_src);
    _4_bv = _out2;
    if (!((_4_bv).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(932,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_4_bv).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Compound beacon Mixed defines signed part Month which is already defined as a global part."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(933,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void CompoundNoConstructor()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon _0_compoundDefault;
    _0_compoundDefault = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon.create(dafny.DafnySequence.asString("compoundDefault"), dafny.DafnySequence.asString("."), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPartsList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPartsList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorList._typeDescriptor()));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _1_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _1_version = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _2_dt__update__tmp_h0 = _1_version;
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>> _3_dt__update_hencryptedParts_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor(), BeaconTestFixtures_Compile.__default.Name(), BeaconTestFixtures_Compile.__default.Title()));
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>> _4_dt__update_hsignedParts_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart._typeDescriptor(), BeaconTestFixtures_Compile.__default.Month()));
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>> _5_dt__update_hcompoundBeacons_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor(), _0_compoundDefault));
    _1_version = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_2_dt__update__tmp_h0).dtor_version(), (_2_dt__update__tmp_h0).dtor_keyStore(), (_2_dt__update__tmp_h0).dtor_keySource(), (_2_dt__update__tmp_h0).dtor_standardBeacons(), _5_dt__update_hcompoundBeacons_h0, (_2_dt__update__tmp_h0).dtor_virtualFields(), _3_dt__update_hencryptedParts_h0, _4_dt__update_hsignedParts_h0);
    SearchableEncryptionInfo_Compile.KeySource _6_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _1_version);
    _6_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _7_bv;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _1_version, _6_src);
    _7_bv = _out2;
    if (!((_7_bv).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(950,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_7_bv).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Compound beacon compoundDefault defines no constructors, and also no local parts. Cannot make a default constructor from global parts."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(951,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void CompoundMixed()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon _0_Mixed;
    _0_Mixed = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon.create(dafny.DafnySequence.asString("Mixed"), dafny.DafnySequence.asString("."), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor(), BeaconTestFixtures_Compile.__default.Title())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart._typeDescriptor(), BeaconTestFixtures_Compile.__default.Month())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor.create(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart.create(dafny.DafnySequence.asString("Name"), true), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart.create(dafny.DafnySequence.asString("Year"), true))), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor.create(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart.create(dafny.DafnySequence.asString("Title"), true), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart.create(dafny.DafnySequence.asString("Month"), false))))));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _1_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _1_version = _out0;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _2_dt__update__tmp_h0 = _1_version;
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>> _3_dt__update_hencryptedParts_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor(), BeaconTestFixtures_Compile.__default.Name()));
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>> _4_dt__update_hsignedParts_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart._typeDescriptor(), BeaconTestFixtures_Compile.__default.Year()));
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>> _5_dt__update_hcompoundBeacons_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor(), _0_Mixed));
    _1_version = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_2_dt__update__tmp_h0).dtor_version(), (_2_dt__update__tmp_h0).dtor_keyStore(), (_2_dt__update__tmp_h0).dtor_keySource(), (_2_dt__update__tmp_h0).dtor_standardBeacons(), _5_dt__update_hcompoundBeacons_h0, (_2_dt__update__tmp_h0).dtor_virtualFields(), _3_dt__update_hencryptedParts_h0, _4_dt__update_hsignedParts_h0);
    SearchableEncryptionInfo_Compile.KeySource _6_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _1_version);
    _6_src = _out1;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _7_valueOrError0 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _1_version, _6_src);
    _7_valueOrError0 = _out2;
    if (!(!((_7_valueOrError0).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(970,14): " + java.lang.String.valueOf(_7_valueOrError0));
    }
    SearchableEncryptionInfo_Compile.BeaconVersion _8_bv;
    _8_bv = (_7_valueOrError0).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
  }
  public static void CheckBytesToHex()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_bytes;
    _0_bytes = dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 183);
    if (!((BaseBeacon_Compile.__default.BytesToHex(_0_bytes, (byte) 1)).equals(dafny.DafnySequence.asString("1")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(979,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((BaseBeacon_Compile.__default.BytesToHex(_0_bytes, (byte) 2)).equals(dafny.DafnySequence.asString("3")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(980,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((BaseBeacon_Compile.__default.BytesToHex(_0_bytes, (byte) 3)).equals(dafny.DafnySequence.asString("7")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(981,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((BaseBeacon_Compile.__default.BytesToHex(_0_bytes, (byte) 4)).equals(dafny.DafnySequence.asString("7")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(982,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((BaseBeacon_Compile.__default.BytesToHex(_0_bytes, (byte) 5)).equals(dafny.DafnySequence.asString("17")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(983,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((BaseBeacon_Compile.__default.BytesToHex(_0_bytes, (byte) 6)).equals(dafny.DafnySequence.asString("37")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(984,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((BaseBeacon_Compile.__default.BytesToHex(_0_bytes, (byte) 7)).equals(dafny.DafnySequence.asString("37")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(985,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((BaseBeacon_Compile.__default.BytesToHex(_0_bytes, (byte) 8)).equals(dafny.DafnySequence.asString("b7")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/Beacon.dfy(986,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> x123()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 49, (byte) 50, (byte) 51);
    return _0_s;
  }
  @Override
  public java.lang.String toString() {
    return "TestBaseBeacon._default";
  }
}
