// Class BeaconVersion
// Dafny class BeaconVersion compiled into Java
package SearchableEncryptionInfo_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class BeaconVersion {
  public byte _version;
  public KeySource _keySource;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> _virtualFields;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Beacon> _beacons;
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _beaconNames;
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _stdNames;
  public dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _encryptedFields;
  public BeaconVersion (byte version, KeySource keySource, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Beacon> beacons, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> beaconNames, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> stdNames, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> encryptedFields) {
    this._version = version;
    this._keySource = keySource;
    this._virtualFields = virtualFields;
    this._beacons = beacons;
    this._beaconNames = beaconNames;
    this._stdNames = stdNames;
    this._encryptedFields = encryptedFields;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BeaconVersion o = (BeaconVersion)other;
    return true && this._version == o._version && java.util.Objects.equals(this._keySource, o._keySource) && java.util.Objects.equals(this._virtualFields, o._virtualFields) && java.util.Objects.equals(this._beacons, o._beacons) && java.util.Objects.equals(this._beaconNames, o._beaconNames) && java.util.Objects.equals(this._stdNames, o._stdNames) && java.util.Objects.equals(this._encryptedFields, o._encryptedFields);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.lang.Byte.hashCode(this._version);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._keySource);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._virtualFields);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._beacons);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._beaconNames);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._stdNames);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encryptedFields);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("SearchableEncryptionInfo.BeaconVersion.BeaconVersion");
    s.append("(");
    s.append(this._version);
    s.append(", ");
    s.append(dafny.Helpers.toString(this._keySource));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._virtualFields));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._beacons));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._beaconNames));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._stdNames));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._encryptedFields));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<BeaconVersion> _TYPE = dafny.TypeDescriptor.<BeaconVersion>referenceWithInitializer(BeaconVersion.class, () -> BeaconVersion.Default());
  public static dafny.TypeDescriptor<BeaconVersion> _typeDescriptor() {
    return (dafny.TypeDescriptor<BeaconVersion>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final BeaconVersion theDefault = BeaconVersion.create(VersionNumber.Witness, KeySource.Default(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,DdbVirtualFields_Compile.VirtField> empty(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Beacon> empty(), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> empty());
  public static BeaconVersion Default() {
    return theDefault;
  }
  public static BeaconVersion create(byte version, KeySource keySource, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Beacon> beacons, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> beaconNames, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> stdNames, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> encryptedFields) {
    return new BeaconVersion(version, keySource, virtualFields, beacons, beaconNames, stdNames, encryptedFields);
  }
  public static BeaconVersion create_BeaconVersion(byte version, KeySource keySource, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Beacon> beacons, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> beaconNames, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> stdNames, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> encryptedFields) {
    return create(version, keySource, virtualFields, beacons, beaconNames, stdNames, encryptedFields);
  }
  public boolean is_BeaconVersion() { return true; }
  public byte dtor_version() {
    return this._version;
  }
  public KeySource dtor_keySource() {
    return this._keySource;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> dtor_virtualFields() {
    return this._virtualFields;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Beacon> dtor_beacons() {
    return this._beacons;
  }
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> dtor_beaconNames() {
    return this._beaconNames;
  }
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> dtor_stdNames() {
    return this._stdNames;
  }
  public dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> dtor_encryptedFields() {
    return this._encryptedFields;
  }
  public boolean IsBeacon(dafny.DafnySequence<? extends Character> field) {
    return ((this).dtor_beacons()).<dafny.DafnySequence<? extends Character>>contains(field);
  }
  public boolean IsVirtualField(dafny.DafnySequence<? extends Character> field) {
    return ((this).dtor_virtualFields()).<dafny.DafnySequence<? extends Character>>contains(field);
  }
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> GetFields(dafny.DafnySequence<? extends Character> field) {
    if ((this).IsBeacon(field)) {
      return dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate((((Beacon)(java.lang.Object)(((this).dtor_beacons()).get(field)))).GetFields((this).dtor_virtualFields()), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("aws_dbe_b_"), field)));
    } else {
      return dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), field);
    }
  }
  public Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> getKeyMap(DynamoDbEncryptionUtil_Compile.MaybeKeyId keyId)
  {
    Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyMap.Default());
    if(true) {
      Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
      _out0 = ((this).dtor_keySource()).getKeyMap((this).dtor_stdNames(), keyId);
      output = _out0;
    }
    return output;
  }
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> ListSignedBeacons() {
    return Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>Filter(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>)(_0_s_boxed0) -> {
      dafny.DafnySequence<? extends Character> _0_s = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_0_s_boxed0));
      return __default.IsBeaconOfType(((Beacon)(java.lang.Object)(((this).dtor_beacons()).get(_0_s))), BeaconType.create_SignedBeacon());
    }), (this).dtor_beaconNames());
  }
  public Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GeneratePlainBeacons(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    if(true) {
      output = (this).GenerateBeacons2((this).dtor_beaconNames(), item, DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_DontUseKeys(), BeaconType.create_AnyBeacon(), dafny.DafnyMap.fromElements());
    }
    return output;
  }
  public Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GenerateSignedBeacons(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    if(true) {
      output = (this).GenerateBeacons2((this).dtor_beaconNames(), item, DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_DontUseKeys(), BeaconType.create_SignedBeacon(), dafny.DafnyMap.fromElements());
    }
    return output;
  }
  public Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GenerateEncryptedBeacons(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, DynamoDbEncryptionUtil_Compile.MaybeKeyId keyId)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    if(true) {
      Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyMap.Default());
      Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
      _out0 = (this).getKeyMap(keyId);
      _0_valueOrError0 = _out0;
      if ((_0_valueOrError0).IsFailure(DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_0_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
        return output;
      }
      DynamoDbEncryptionUtil_Compile.MaybeKeyMap _1_hmacKeys;
      _1_hmacKeys = (_0_valueOrError0).Extract(DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      output = (this).GenerateBeacons2((this).dtor_beaconNames(), item, _1_hmacKeys, BeaconType.create_EncryptedBeacon(), dafny.DafnyMap.fromElements());
    }
    return output;
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GenerateBeacon(dafny.DafnySequence<? extends Character> name, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys)
  {
    return (((Beacon)(java.lang.Object)(((this).dtor_beacons()).get(name)))).attrHash(item, (this).dtor_virtualFields(), keys);
  }
  public Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GenerateBeacons2(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> names, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys, BeaconType bType, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> acc)
  {
    BeaconVersion _this = this;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((names).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), acc);
      } else if ((__default.IsBeaconOfType(((Beacon)(java.lang.Object)(((_this).dtor_beacons()).get(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((names).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))))), bType)) && (!(__default.IsPartOnly(((Beacon)(java.lang.Object)(((_this).dtor_beacons()).get(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((names).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))))))))) {
        Wrappers_Compile.Result<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = (_this).GenerateBeacon(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((names).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), item, keys);
        if ((_0_valueOrError0).IsFailure(Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_0_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
        } else {
          Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _1_value = (_0_valueOrError0).Extract(Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          if ((_1_value).is_Some()) {
            BeaconVersion _in0 = _this;
            dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in1 = (names).drop(java.math.BigInteger.ONE);
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in2 = item;
            DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in3 = keys;
            BeaconType _in4 = bType;
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in5 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>update(acc, (((Beacon)(java.lang.Object)(((_this).dtor_beacons()).get(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((names).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))))).getBeaconName(), (_1_value).dtor_value());
            _this = _in0;
            ;
            names = _in1;
            item = _in2;
            keys = _in3;
            bType = _in4;
            acc = _in5;
            continue TAIL_CALL_START;
          } else {
            BeaconVersion _in6 = _this;
            dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in7 = (names).drop(java.math.BigInteger.ONE);
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in8 = item;
            DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in9 = keys;
            BeaconType _in10 = bType;
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in11 = acc;
            _this = _in6;
            ;
            names = _in7;
            item = _in8;
            keys = _in9;
            bType = _in10;
            acc = _in11;
            continue TAIL_CALL_START;
          }
        }
      } else {
        BeaconVersion _in12 = _this;
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in13 = (names).drop(java.math.BigInteger.ONE);
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in14 = item;
        DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in15 = keys;
        BeaconType _in16 = bType;
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in17 = acc;
        _this = _in12;
        ;
        names = _in13;
        item = _in14;
        keys = _in15;
        bType = _in16;
        acc = _in17;
        continue TAIL_CALL_START;
      }
    }
  }
}
