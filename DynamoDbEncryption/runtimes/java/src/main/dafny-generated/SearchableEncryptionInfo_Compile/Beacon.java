// Class Beacon
// Dafny class Beacon compiled into Java
package SearchableEncryptionInfo_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class Beacon {
  public Beacon() {
  }
  private static final dafny.TypeDescriptor<Beacon> _TYPE = dafny.TypeDescriptor.<Beacon>referenceWithInitializer(Beacon.class, () -> Beacon.Default());
  public static dafny.TypeDescriptor<Beacon> _typeDescriptor() {
    return (dafny.TypeDescriptor<Beacon>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final Beacon theDefault = Beacon.create_Standard(BaseBeacon_Compile.StandardBeacon.Default());
  public static Beacon Default() {
    return theDefault;
  }
  public static Beacon create_Standard(BaseBeacon_Compile.StandardBeacon std) {
    return new Beacon_Standard(std);
  }
  public static Beacon create_Compound(CompoundBeacon_Compile.CompoundBeacon cmp) {
    return new Beacon_Compound(cmp);
  }
  public boolean is_Standard() { return this instanceof Beacon_Standard; }
  public boolean is_Compound() { return this instanceof Beacon_Compound; }
  public BaseBeacon_Compile.StandardBeacon dtor_std() {
    Beacon d = this;
    return ((Beacon_Standard)d)._std;
  }
  public CompoundBeacon_Compile.CompoundBeacon dtor_cmp() {
    Beacon d = this;
    return ((Beacon_Compound)d)._cmp;
  }
  public boolean isEncrypted() {
    if ((this).is_Standard()) {
      return true;
    } else {
      return ((this).dtor_cmp()).isEncrypted();
    }
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> hash(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> vf, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys)
  {
    if ((this).is_Standard()) {
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (keys).is_Keys(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Need key for beacon "), ((this).dtor_std()).keyName()), dafny.DafnySequence.asString(" but no keyId found in query."))));
      if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_0_valueOrError0).<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
      } else if (((keys).dtor_value()).<dafny.DafnySequence<? extends Character>>contains(((this).dtor_std()).keyName())) {
        return ((this).dtor_std()).getHash(item, vf, ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)(((keys).dtor_value()).get(((this).dtor_std()).keyName()))));
      } else {
        return Wrappers_Compile.Result.<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Internal error. Beacon "), ((this).dtor_std()).keyName()), dafny.DafnySequence.asString(" has no key!"))));
      }
    } else {
      Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError1 = ((this).dtor_cmp()).hash(item, vf, keys);
      if ((_1_valueOrError1).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_1_valueOrError1).<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
      } else {
        Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _2_strHash = (_1_valueOrError1).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        if ((_2_strHash).is_None()) {
          return Wrappers_Compile.Result.<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
        } else {
          return Wrappers_Compile.Result.<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>create_Some(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S((_2_strHash).dtor_value())));
        }
      }
    }
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> naked(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> vf)
  {
    if ((this).is_Standard()) {
      return ((this).dtor_std()).getNaked(item, vf);
    } else {
      Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = ((this).dtor_cmp()).getNaked(item, vf);
      if ((_0_valueOrError0).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_0_valueOrError0).<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
      } else {
        Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _1_str = (_0_valueOrError0).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        if ((_1_str).is_None()) {
          return Wrappers_Compile.Result.<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
        } else {
          return Wrappers_Compile.Result.<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>create_Some(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), DdbVirtualFields_Compile.__default.DS((_1_str).dtor_value())));
        }
      }
    }
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> attrHash(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> vf, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys)
  {
    if ((keys).is_DontUseKeys()) {
      return (this).naked(item, vf);
    } else {
      return (this).hash(item, vf, keys);
    }
  }
  public dafny.DafnySequence<? extends Character> getName() {
    if ((this).is_Standard()) {
      return (((this).dtor_std()).dtor_base()).dtor_name();
    } else {
      return (((this).dtor_cmp()).dtor_base()).dtor_name();
    }
  }
  public dafny.DafnySequence<? extends Character> getBeaconName() {
    if ((this).is_Standard()) {
      return (((this).dtor_std()).dtor_base()).dtor_beaconName();
    } else {
      return (((this).dtor_cmp()).dtor_base()).dtor_beaconName();
    }
  }
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> GetFields(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields) {
    if ((this).is_Standard()) {
      return ((this).dtor_std()).GetFields(virtualFields);
    } else {
      return ((this).dtor_cmp()).GetFields(virtualFields);
    }
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetBeaconValue(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue value, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys, boolean forEquality, boolean forContains)
  {
    if ((keys).is_DontUseKeys()) {
      return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), value);
    } else if ((this).is_Standard()) {
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), !((keys).is_ShouldHaveKeys()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Need KeyId because of beacon "), ((this).dtor_std()).keyName()), dafny.DafnySequence.asString(" but no KeyId found in query"))));
      if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_0_valueOrError0).<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor());
      } else {
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _1_keys = (keys).dtor_value();
        if ((_1_keys).<dafny.DafnySequence<? extends Character>>contains(((this).dtor_std()).keyName())) {
          return ((this).dtor_std()).GetBeaconValue(value, ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((_1_keys).get(((this).dtor_std()).keyName()))), forContains);
        } else {
          return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Internal error. Beacon "), ((this).dtor_std()).keyName()), dafny.DafnySequence.asString(" has no key."))));
        }
      }
    } else {
      return ((this).dtor_cmp()).GetBeaconValue(value, keys, forEquality);
    }
  }
}
