// Class StandardBeacon
// Dafny class StandardBeacon compiled into Java
package BaseBeacon_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class StandardBeacon {
  public BeaconBase _base;
  public byte _length;
  public dafny.DafnySequence<? extends TermLoc_Compile.Selector> _loc;
  public boolean _partOnly;
  public boolean _asSet;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _share;
  public StandardBeacon (BeaconBase base, byte length, dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc, boolean partOnly, boolean asSet, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> share) {
    this._base = base;
    this._length = length;
    this._loc = loc;
    this._partOnly = partOnly;
    this._asSet = asSet;
    this._share = share;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    StandardBeacon o = (StandardBeacon)other;
    return true && java.util.Objects.equals(this._base, o._base) && this._length == o._length && java.util.Objects.equals(this._loc, o._loc) && this._partOnly == o._partOnly && this._asSet == o._asSet && java.util.Objects.equals(this._share, o._share);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._base);
    hash = ((hash << 5) + hash) + java.lang.Byte.hashCode(this._length);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._loc);
    hash = ((hash << 5) + hash) + Boolean.hashCode(this._partOnly);
    hash = ((hash << 5) + hash) + Boolean.hashCode(this._asSet);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._share);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("BaseBeacon.StandardBeacon.StandardBeacon");
    s.append("(");
    s.append(dafny.Helpers.toString(this._base));
    s.append(", ");
    s.append(this._length);
    s.append(", ");
    s.append(dafny.Helpers.toString(this._loc));
    s.append(", ");
    s.append(this._partOnly);
    s.append(", ");
    s.append(this._asSet);
    s.append(", ");
    s.append(dafny.Helpers.toString(this._share));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<StandardBeacon> _TYPE = dafny.TypeDescriptor.<StandardBeacon>referenceWithInitializer(StandardBeacon.class, () -> StandardBeacon.Default());
  public static dafny.TypeDescriptor<StandardBeacon> _typeDescriptor() {
    return (dafny.TypeDescriptor<StandardBeacon>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final StandardBeacon theDefault = StandardBeacon.create(BeaconBase.Default(), BeaconLength.Witness, dafny.DafnySequence.<TermLoc_Compile.Selector> empty(TermLoc_Compile.Selector._typeDescriptor()), false, false, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
  public static StandardBeacon Default() {
    return theDefault;
  }
  public static StandardBeacon create(BeaconBase base, byte length, dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc, boolean partOnly, boolean asSet, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> share) {
    return new StandardBeacon(base, length, loc, partOnly, asSet, share);
  }
  public static StandardBeacon create_StandardBeacon(BeaconBase base, byte length, dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc, boolean partOnly, boolean asSet, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> share) {
    return create(base, length, loc, partOnly, asSet, share);
  }
  public boolean is_StandardBeacon() { return true; }
  public BeaconBase dtor_base() {
    return this._base;
  }
  public byte dtor_length() {
    return this._length;
  }
  public dafny.DafnySequence<? extends TermLoc_Compile.Selector> dtor_loc() {
    return this._loc;
  }
  public boolean dtor_partOnly() {
    return this._partOnly;
  }
  public boolean dtor_asSet() {
    return this._asSet;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> dtor_share() {
    return this._share;
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> hash(dafny.DafnySequence<? extends java.lang.Byte> val, dafny.DafnySequence<? extends java.lang.Byte> key)
  {
    return ((this).dtor_base()).hash(val, key, (this).dtor_length());
  }
  public dafny.DafnySequence<? extends Character> keyName() {
    if (((this).dtor_share()).is_Some()) {
      return ((this).dtor_share()).dtor_value();
    } else {
      return ((this).dtor_base()).dtor_name();
    }
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> hashStr(dafny.DafnySequence<? extends Character> val, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> keys)
  {
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (keys).<dafny.DafnySequence<? extends Character>>contains((this).keyName()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Internal Error, no key for "), (this).keyName())));
    if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends Character>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    } else {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _1_str = UTF8.__default.Encode(val);
      if ((_1_str).is_Failure()) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E((_1_str).dtor_error()));
      } else {
        return (this).hash((_1_str).dtor_value(), ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((keys).get((this).keyName()))));
      }
    }
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> ValueToSet(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue value, dafny.DafnySequence<? extends java.lang.Byte> key)
  {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _pat_let_tv0 = value;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _pat_let_tv1 = value;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _pat_let_tv2 = value;
    dafny.DafnySequence<? extends java.lang.Byte> _pat_let_tv3 = key;
    dafny.DafnySequence<? extends java.lang.Byte> _pat_let_tv4 = key;
    dafny.DafnySequence<? extends java.lang.Byte> _pat_let_tv5 = key;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _pat_let_tv6 = value;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _pat_let_tv7 = value;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _pat_let_tv8 = value;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _pat_let_tv9 = value;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = ((java.util.function.Function<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>>)(_source0_boxed0) -> {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _source0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)(_source0_boxed0));
      if (_source0.is_S()) {
        dafny.DafnySequence<? extends Character> _1___mcc_h0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_S)_source0)._S;
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Beacon "), ((this).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" has style AsSet, but attribute has type ")), DynamoDbEncryptionUtil_Compile.__default.AttrTypeToStr(_pat_let_tv0)), dafny.DafnySequence.asString("."))));
      } else if (_source0.is_N()) {
        dafny.DafnySequence<? extends Character> _2___mcc_h2 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_N)_source0)._N;
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Beacon "), ((this).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" has style AsSet, but attribute has type ")), DynamoDbEncryptionUtil_Compile.__default.AttrTypeToStr(_pat_let_tv1)), dafny.DafnySequence.asString("."))));
      } else if (_source0.is_B()) {
        dafny.DafnySequence<? extends java.lang.Byte> _3___mcc_h4 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_B)_source0)._B;
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Beacon "), ((this).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" has style AsSet, but attribute has type ")), DynamoDbEncryptionUtil_Compile.__default.AttrTypeToStr(_pat_let_tv2)), dafny.DafnySequence.asString("."))));
      } else if (_source0.is_SS()) {
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _4___mcc_h6 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_SS)_source0)._SS;
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _5_n = _4___mcc_h6;
        return (this).BeaconizeStringSet(_5_n, _pat_let_tv3, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
      } else if (_source0.is_NS()) {
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _6___mcc_h8 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_NS)_source0)._NS;
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _7_n = _6___mcc_h8;
        return (this).BeaconizeNumberSet(_7_n, _pat_let_tv4, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
      } else if (_source0.is_BS()) {
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _8___mcc_h10 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_BS)_source0)._BS;
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _9_n = _8___mcc_h10;
        return (this).BeaconizeBinarySet(_9_n, _pat_let_tv5, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
      } else if (_source0.is_M()) {
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _10___mcc_h12 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_M)_source0)._M;
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Beacon "), ((this).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" has style AsSet, but attribute has type ")), DynamoDbEncryptionUtil_Compile.__default.AttrTypeToStr(_pat_let_tv6)), dafny.DafnySequence.asString("."))));
      } else if (_source0.is_L()) {
        dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _11___mcc_h14 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_L)_source0)._L;
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Beacon "), ((this).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" has style AsSet, but attribute has type ")), DynamoDbEncryptionUtil_Compile.__default.AttrTypeToStr(_pat_let_tv7)), dafny.DafnySequence.asString("."))));
      } else if (_source0.is_NULL()) {
        boolean _12___mcc_h16 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_NULL)_source0)._NULL;
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Beacon "), ((this).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" has style AsSet, but attribute has type ")), DynamoDbEncryptionUtil_Compile.__default.AttrTypeToStr(_pat_let_tv8)), dafny.DafnySequence.asString("."))));
      } else {
        boolean _13___mcc_h18 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_BOOL)_source0)._BOOL;
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Beacon "), ((this).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" has style AsSet, but attribute has type ")), DynamoDbEncryptionUtil_Compile.__default.AttrTypeToStr(_pat_let_tv9)), dafny.DafnySequence.asString("."))));
      }
    }).apply(value);
    if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>PropagateFailure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _14_beaconSeq = (_0_valueOrError0).Extract(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_SS(_14_beaconSeq));
    }
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> getHash(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> vf, dafny.DafnySequence<? extends java.lang.Byte> key)
  {
    if ((this).dtor_asSet()) {
      return (this).getHashSet(item, key);
    } else {
      return (this).getHashNonSet(item, vf, key);
    }
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> getHashSet(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, dafny.DafnySequence<? extends java.lang.Byte> key)
  {
    Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _0_value = TermLoc_Compile.__default.TermToAttr((this).dtor_loc(), item, Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor())));
    if ((_0_value).is_None()) {
      return Wrappers_Compile.Result.<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
    } else {
      Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError0 = (this).ValueToSet((_0_value).dtor_value(), key);
      if ((_1_valueOrError0).IsFailure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_1_valueOrError0).<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
      } else {
        software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _2_setValue = (_1_valueOrError0).Extract(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>create_Some(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), _2_setValue));
      }
    }
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> getHashNonSet(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> vf, dafny.DafnySequence<? extends java.lang.Byte> key)
  {
    Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = DdbVirtualFields_Compile.__default.VirtToBytes((this).dtor_loc(), item, vf);
    if ((_0_valueOrError0).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
    } else {
      Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>> _1_bytes = (_0_valueOrError0).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      if ((_1_bytes).is_None()) {
        return Wrappers_Compile.Result.<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError1 = (this).hash((_1_bytes).dtor_value(), key);
        if ((_2_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_2_valueOrError1).<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
        } else {
          dafny.DafnySequence<? extends Character> _3_res = (_2_valueOrError1).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          return Wrappers_Compile.Result.<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>create_Some(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(_3_res)));
        }
      }
    }
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> getNaked(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> vf)
  {
    return DdbVirtualFields_Compile.__default.VirtToAttr((this).dtor_loc(), item, vf);
  }
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> GetFields(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields) {
    if ((virtualFields).<dafny.DafnySequence<? extends Character>>contains((((TermLoc_Compile.Selector)(java.lang.Object)(((this).dtor_loc()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key())) {
      return (((DdbVirtualFields_Compile.VirtField)(java.lang.Object)((virtualFields).get((((TermLoc_Compile.Selector)(java.lang.Object)(((this).dtor_loc()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key())))).GetFields();
    } else {
      return dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (((TermLoc_Compile.Selector)(java.lang.Object)(((this).dtor_loc()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key());
    }
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> BeaconizeStringSet(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> value, dafny.DafnySequence<? extends java.lang.Byte> key, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> converted)
  {
    StandardBeacon _this = this;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((value).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), converted);
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = (DynamoToStruct_Compile.__default.TopLevelAttributeToBytes(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((value).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))))).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<StandardBeacon, java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>>)(_1___this0) -> ((java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_2_e_boxed0) -> {
          dafny.DafnySequence<? extends Character> _2_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_2_e_boxed0));
          return DynamoDbEncryptionUtil_Compile.__default.E(_2_e);
        })).apply(_this));
        if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_0_valueOrError0).<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _3_bytes = (_0_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError1 = (_this).hash(_3_bytes, key);
          if ((_4_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            return (_4_valueOrError1).<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
          } else {
            dafny.DafnySequence<? extends Character> _5_h = (_4_valueOrError1).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
            if ((converted).contains(_5_h)) {
              StandardBeacon _in0 = _this;
              dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in1 = (value).drop(java.math.BigInteger.ONE);
              dafny.DafnySequence<? extends java.lang.Byte> _in2 = key;
              dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in3 = converted;
              _this = _in0;
              ;
              value = _in1;
              key = _in2;
              converted = _in3;
              continue TAIL_CALL_START;
            } else {
              StandardBeacon _in4 = _this;
              dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in5 = (value).drop(java.math.BigInteger.ONE);
              dafny.DafnySequence<? extends java.lang.Byte> _in6 = key;
              dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in7 = dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(converted, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _5_h));
              _this = _in4;
              ;
              value = _in5;
              key = _in6;
              converted = _in7;
              continue TAIL_CALL_START;
            }
          }
        }
      }
    }
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> BeaconizeNumberSet(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> value, dafny.DafnySequence<? extends java.lang.Byte> key, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> converted)
  {
    StandardBeacon _this = this;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((value).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), converted);
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = (DynamoToStruct_Compile.__default.TopLevelAttributeToBytes(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((value).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))))).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<StandardBeacon, java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>>)(_1___this0) -> ((java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_2_e_boxed0) -> {
          dafny.DafnySequence<? extends Character> _2_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_2_e_boxed0));
          return DynamoDbEncryptionUtil_Compile.__default.E(_2_e);
        })).apply(_this));
        if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_0_valueOrError0).<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _3_bytes = (_0_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError1 = (_this).hash(_3_bytes, key);
          if ((_4_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            return (_4_valueOrError1).<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
          } else {
            dafny.DafnySequence<? extends Character> _5_h = (_4_valueOrError1).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
            if ((converted).contains(_5_h)) {
              StandardBeacon _in0 = _this;
              dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in1 = (value).drop(java.math.BigInteger.ONE);
              dafny.DafnySequence<? extends java.lang.Byte> _in2 = key;
              dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in3 = converted;
              _this = _in0;
              ;
              value = _in1;
              key = _in2;
              converted = _in3;
              continue TAIL_CALL_START;
            } else {
              StandardBeacon _in4 = _this;
              dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in5 = (value).drop(java.math.BigInteger.ONE);
              dafny.DafnySequence<? extends java.lang.Byte> _in6 = key;
              dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in7 = dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(converted, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _5_h));
              _this = _in4;
              ;
              value = _in5;
              key = _in6;
              converted = _in7;
              continue TAIL_CALL_START;
            }
          }
        }
      }
    }
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> BeaconizeBinarySet(dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> value, dafny.DafnySequence<? extends java.lang.Byte> key, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> converted)
  {
    StandardBeacon _this = this;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((value).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), converted);
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = (DynamoToStruct_Compile.__default.TopLevelAttributeToBytes(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_B(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((value).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))))).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<StandardBeacon, java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>>)(_1___this0) -> ((java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_2_e_boxed0) -> {
          dafny.DafnySequence<? extends Character> _2_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_2_e_boxed0));
          return DynamoDbEncryptionUtil_Compile.__default.E(_2_e);
        })).apply(_this));
        if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_0_valueOrError0).<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _3_bytes = (_0_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError1 = (_this).hash(_3_bytes, key);
          if ((_4_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            return (_4_valueOrError1).<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
          } else {
            dafny.DafnySequence<? extends Character> _5_h = (_4_valueOrError1).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
            if ((converted).contains(_5_h)) {
              StandardBeacon _in0 = _this;
              dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _in1 = (value).drop(java.math.BigInteger.ONE);
              dafny.DafnySequence<? extends java.lang.Byte> _in2 = key;
              dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in3 = converted;
              _this = _in0;
              ;
              value = _in1;
              key = _in2;
              converted = _in3;
              continue TAIL_CALL_START;
            } else {
              StandardBeacon _in4 = _this;
              dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _in5 = (value).drop(java.math.BigInteger.ONE);
              dafny.DafnySequence<? extends java.lang.Byte> _in6 = key;
              dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in7 = dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(converted, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _5_h));
              _this = _in4;
              ;
              value = _in5;
              key = _in6;
              converted = _in7;
              continue TAIL_CALL_START;
            }
          }
        }
      }
    }
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetBeaconValue(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue value, dafny.DafnySequence<? extends java.lang.Byte> key, boolean forContains)
  {
    if (((((this).dtor_asSet()) && (!((value).is_S()))) && (!((value).is_N()))) && (!((value).is_B()))) {
      return (this).ValueToSet(value, key);
    } else if ((forContains) && ((((value).is_SS()) || ((value).is_NS())) || ((value).is_BS()))) {
      return (this).ValueToSet(value, key);
    } else {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = (DynamoToStruct_Compile.__default.TopLevelAttributeToBytes(value)).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_1_e_boxed0) -> {
        dafny.DafnySequence<? extends Character> _1_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_1_e_boxed0));
        return DynamoDbEncryptionUtil_Compile.__default.E(_1_e);
      }));
      if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_0_valueOrError0).<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor());
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _2_bytes = (_0_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError1 = (this).hash(_2_bytes, key);
        if ((_3_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_3_valueOrError1).<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor());
        } else {
          dafny.DafnySequence<? extends Character> _4_h = (_3_valueOrError1).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(_4_h));
        }
      }
    }
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> getPart(dafny.DafnySequence<? extends java.lang.Byte> val, dafny.DafnySequence<? extends java.lang.Byte> key)
  {
    return ((this).dtor_base()).hash(val, key, (this).dtor_length());
  }
}
