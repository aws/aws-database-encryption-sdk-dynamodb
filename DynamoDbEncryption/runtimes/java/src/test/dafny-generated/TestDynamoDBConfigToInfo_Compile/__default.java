// Class __default
// Dafny class __default compiled into Java
package TestDynamoDBConfigToInfo_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static void TestTwoBeaconsOneLoc()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon _0_fred;
    _0_fred = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon.create(dafny.DafnySequence.asString("fred"), 16, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("std6[0]")), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle._typeDescriptor()));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _1_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _1_version = _out0;
    SearchableEncryptionInfo_Compile.KeySource _2_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _1_version);
    _2_src = _out1;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _3_newBeacons;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _4_dt__update__tmp_h0 = _1_version;
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> _5_dt__update_hstandardBeacons_h0 = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), BeaconTestFixtures_Compile.__default.std2(), BeaconTestFixtures_Compile.__default.std4(), BeaconTestFixtures_Compile.__default.std6(), BeaconTestFixtures_Compile.__default.NameTitleBeacon(), BeaconTestFixtures_Compile.__default.NameB(), BeaconTestFixtures_Compile.__default.TitleB(), _0_fred);
    _3_newBeacons = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_4_dt__update__tmp_h0).dtor_version(), (_4_dt__update__tmp_h0).dtor_keyStore(), (_4_dt__update__tmp_h0).dtor_keySource(), _5_dt__update_hstandardBeacons_h0, (_4_dt__update__tmp_h0).dtor_compoundBeacons(), (_4_dt__update__tmp_h0).dtor_virtualFields(), (_4_dt__update__tmp_h0).dtor_encryptedParts(), (_4_dt__update__tmp_h0).dtor_signedParts());
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_beaconVersion;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _3_newBeacons, _2_src);
    _6_beaconVersion = _out2;
    if (!((_6_beaconVersion).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/ConfigToInfo.dfy(24,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_6_beaconVersion).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Beacon fred is defined on location std6[0], but beacon std6 is already defined on that location."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/ConfigToInfo.dfy(25,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestTwoVirtOneLoc()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField _0_TitleNameField;
    _0_TitleNameField = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField.create(dafny.DafnySequence.asString("TitleNameField"), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart._typeDescriptor(), BeaconTestFixtures_Compile.__default.VPart2(), BeaconTestFixtures_Compile.__default.VPart1()));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _1_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _1_version = _out0;
    SearchableEncryptionInfo_Compile.KeySource _2_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _1_version);
    _2_src = _out1;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _3_newBeacons;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _4_dt__update__tmp_h0 = _1_version;
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField>> _5_dt__update_hvirtualFields_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField._typeDescriptor(), BeaconTestFixtures_Compile.__default.NameTitleField(), _0_TitleNameField));
    _3_newBeacons = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_4_dt__update__tmp_h0).dtor_version(), (_4_dt__update__tmp_h0).dtor_keyStore(), (_4_dt__update__tmp_h0).dtor_keySource(), (_4_dt__update__tmp_h0).dtor_standardBeacons(), (_4_dt__update__tmp_h0).dtor_compoundBeacons(), _5_dt__update_hvirtualFields_h0, (_4_dt__update__tmp_h0).dtor_encryptedParts(), (_4_dt__update__tmp_h0).dtor_signedParts());
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_beaconVersion;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _3_newBeacons, _2_src);
    _6_beaconVersion = _out2;
    if (!((_6_beaconVersion).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/ConfigToInfo.dfy(33,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_6_beaconVersion).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Virtual field TitleNameField is defined on the same locations as NameTitleField."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/ConfigToInfo.dfy(34,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestVirtAndBeaconSameLoc()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _0_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _0_version = _out0;
    SearchableEncryptionInfo_Compile.KeySource _1_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _0_version);
    _1_src = _out1;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _2_newBeacons;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _3_dt__update__tmp_h0 = _0_version;
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField>> _4_dt__update_hvirtualFields_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField._typeDescriptor(), BeaconTestFixtures_Compile.__default.NameVirtField(), BeaconTestFixtures_Compile.__default.NameTitleField()));
    _2_newBeacons = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_3_dt__update__tmp_h0).dtor_version(), (_3_dt__update__tmp_h0).dtor_keyStore(), (_3_dt__update__tmp_h0).dtor_keySource(), (_3_dt__update__tmp_h0).dtor_standardBeacons(), (_3_dt__update__tmp_h0).dtor_compoundBeacons(), _4_dt__update_hvirtualFields_h0, (_3_dt__update__tmp_h0).dtor_encryptedParts(), (_3_dt__update__tmp_h0).dtor_signedParts());
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_beaconVersion;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _2_newBeacons, _1_src);
    _5_beaconVersion = _out2;
    if (!((_5_beaconVersion).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/ConfigToInfo.dfy(41,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_5_beaconVersion).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Beacon Name is defined on location Name, but virtual field NameVirtField is already defined on that single location."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/ConfigToInfo.dfy(42,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestNSwithEB()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _0_version;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out0;
    _out0 = BeaconTestFixtures_Compile.__default.GetLotsaBeacons();
    _0_version = _out0;
    SearchableEncryptionInfo_Compile.KeySource _1_src;
    SearchableEncryptionInfo_Compile.KeySource _out1;
    _out1 = BeaconTestFixtures_Compile.__default.GetLiteralSource(dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), _0_version);
    _1_src = _out1;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon _2_DupNameNS;
    _2_DupNameNS = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon.create(dafny.DafnySequence.asString("Name"), dafny.DafnySequence.asString("."), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPartsList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart._typeDescriptor(), BeaconTestFixtures_Compile.__default.Year(), BeaconTestFixtures_Compile.__default.Month())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor>>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorList._typeDescriptor()));
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon _3_DupNameS;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon _4_dt__update__tmp_h0 = _2_DupNameNS;
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>> _5_dt__update_hencrypted_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor(), BeaconTestFixtures_Compile.__default.Title()));
    _3_DupNameS = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon.create((_4_dt__update__tmp_h0).dtor_name(), (_4_dt__update__tmp_h0).dtor_split(), _5_dt__update_hencrypted_h0, (_4_dt__update__tmp_h0).dtor_signed(), (_4_dt__update__tmp_h0).dtor_constructors());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _6_newBeacons;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _7_dt__update__tmp_h1 = _0_version;
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> _8_dt__update_hstandardBeacons_h0 = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon._typeDescriptor(), BeaconTestFixtures_Compile.__default.std2(), BeaconTestFixtures_Compile.__default.std4(), BeaconTestFixtures_Compile.__default.std6(), BeaconTestFixtures_Compile.__default.NameTitleBeacon(), BeaconTestFixtures_Compile.__default.TitleB());
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>> _9_dt__update_hcompoundBeacons_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor(), _3_DupNameS));
    _6_newBeacons = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_7_dt__update__tmp_h1).dtor_version(), (_7_dt__update__tmp_h1).dtor_keyStore(), (_7_dt__update__tmp_h1).dtor_keySource(), _8_dt__update_hstandardBeacons_h0, _9_dt__update_hcompoundBeacons_h0, (_7_dt__update__tmp_h1).dtor_virtualFields(), (_7_dt__update__tmp_h1).dtor_encryptedParts(), (_7_dt__update__tmp_h1).dtor_signedParts());
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _10_beaconVersion;
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _6_newBeacons, _1_src);
    _10_beaconVersion = _out2;
    if (!((_10_beaconVersion).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/ConfigToInfo.dfy(58,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _11_dt__update__tmp_h2 = _6_newBeacons;
    Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>> _12_dt__update_hcompoundBeacons_h1 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>>create_Some(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon._typeDescriptor(), _2_DupNameNS));
    _6_newBeacons = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion.create((_11_dt__update__tmp_h2).dtor_version(), (_11_dt__update__tmp_h2).dtor_keyStore(), (_11_dt__update__tmp_h2).dtor_keySource(), (_11_dt__update__tmp_h2).dtor_standardBeacons(), _12_dt__update_hcompoundBeacons_h1, (_11_dt__update__tmp_h2).dtor_virtualFields(), (_11_dt__update__tmp_h2).dtor_encryptedParts(), (_11_dt__update__tmp_h2).dtor_signedParts());
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out3;
    _out3 = SearchConfigToInfo_Compile.__default.ConvertVersionWithSource(BeaconTestFixtures_Compile.__default.FullTableConfig(), _6_newBeacons, _1_src);
    _10_beaconVersion = _out3;
    if (!((_10_beaconVersion).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/ConfigToInfo.dfy(62,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals((_10_beaconVersion).dtor_error(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Name not allowed as a CompoundBeacon because a fully signed beacon cannot have the same name as an existing attribute."))))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/ConfigToInfo.dfy(63,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  @Override
  public java.lang.String toString() {
    return "TestDynamoDBConfigToInfo._default";
  }
}
