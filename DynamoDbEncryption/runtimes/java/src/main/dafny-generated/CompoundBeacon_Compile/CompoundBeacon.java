// Class CompoundBeacon
// Dafny class CompoundBeacon compiled into Java
package CompoundBeacon_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class CompoundBeacon {
  public BaseBeacon_Compile.BeaconBase _base;
  public char _split;
  public dafny.DafnySequence<? extends BeaconPart> _parts;
  public java.math.BigInteger _numSigned;
  public dafny.DafnySequence<? extends Constructor> _construct;
  public CompoundBeacon (BaseBeacon_Compile.BeaconBase base, char split, dafny.DafnySequence<? extends BeaconPart> parts, java.math.BigInteger numSigned, dafny.DafnySequence<? extends Constructor> construct) {
    this._base = base;
    this._split = split;
    this._parts = parts;
    this._numSigned = numSigned;
    this._construct = construct;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    CompoundBeacon o = (CompoundBeacon)other;
    return true && java.util.Objects.equals(this._base, o._base) && this._split == o._split && java.util.Objects.equals(this._parts, o._parts) && java.util.Objects.equals(this._numSigned, o._numSigned) && java.util.Objects.equals(this._construct, o._construct);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._base);
    hash = ((hash << 5) + hash) + Character.hashCode(this._split);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._parts);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._numSigned);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._construct);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("CompoundBeacon.CompoundBeacon.CompoundBeacon");
    s.append("(");
    s.append(dafny.Helpers.toString(this._base));
    s.append(", ");
    s.append(this._split);
    s.append(", ");
    s.append(dafny.Helpers.toString(this._parts));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._numSigned));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._construct));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<CompoundBeacon> _TYPE = dafny.TypeDescriptor.<CompoundBeacon>referenceWithInitializer(CompoundBeacon.class, () -> CompoundBeacon.Default());
  public static dafny.TypeDescriptor<CompoundBeacon> _typeDescriptor() {
    return (dafny.TypeDescriptor<CompoundBeacon>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final CompoundBeacon theDefault = CompoundBeacon.create(BaseBeacon_Compile.BeaconBase.Default(), 'D', dafny.DafnySequence.<BeaconPart> empty(BeaconPart._typeDescriptor()), java.math.BigInteger.ZERO, dafny.DafnySequence.<Constructor> empty(Constructor._typeDescriptor()));
  public static CompoundBeacon Default() {
    return theDefault;
  }
  public static CompoundBeacon create(BaseBeacon_Compile.BeaconBase base, char split, dafny.DafnySequence<? extends BeaconPart> parts, java.math.BigInteger numSigned, dafny.DafnySequence<? extends Constructor> construct) {
    return new CompoundBeacon(base, split, parts, numSigned, construct);
  }
  public static CompoundBeacon create_CompoundBeacon(BaseBeacon_Compile.BeaconBase base, char split, dafny.DafnySequence<? extends BeaconPart> parts, java.math.BigInteger numSigned, dafny.DafnySequence<? extends Constructor> construct) {
    return create(base, split, parts, numSigned, construct);
  }
  public boolean is_CompoundBeacon() { return true; }
  public BaseBeacon_Compile.BeaconBase dtor_base() {
    return this._base;
  }
  public char dtor_split() {
    return this._split;
  }
  public dafny.DafnySequence<? extends BeaconPart> dtor_parts() {
    return this._parts;
  }
  public java.math.BigInteger dtor_numSigned() {
    return this._numSigned;
  }
  public dafny.DafnySequence<? extends Constructor> dtor_construct() {
    return this._construct;
  }
  public boolean HasBeacon2(dafny.DafnySequence<? extends BeaconPart> parts, dafny.DafnySequence<? extends Character> name)
  {
    CompoundBeacon _this = this;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((parts).length())).signum() == 0) {
        return false;
      } else if (((((BeaconPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).getName()).equals(name)) {
        return true;
      } else {
        CompoundBeacon _in0 = _this;
        dafny.DafnySequence<? extends BeaconPart> _in1 = (parts).drop(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends Character> _in2 = name;
        _this = _in0;
        ;
        parts = _in1;
        name = _in2;
        continue TAIL_CALL_START;
      }
    }
  }
  public boolean HasBeacon(dafny.DafnySequence<? extends Character> name) {
    return (this).HasBeacon2((this).dtor_parts(), name);
  }
  public boolean isEncrypted() {
    return ((this).dtor_numSigned()).compareTo(java.math.BigInteger.valueOf(((this).dtor_parts()).length())) < 0;
  }
  public Wrappers_Compile.Result<BeaconPart, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> getPartFromPrefix(dafny.DafnySequence<? extends Character> value) {
    return (this).partFromPrefix((this).dtor_parts(), value);
  }
  public dafny.DafnySequence<? extends Character> PartsToString(dafny.DafnySequence<? extends BeaconPart> p) {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_beaconParts = Seq_Compile.__default.<BeaconPart, dafny.DafnySequence<? extends Character>>Map(BeaconPart._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((java.util.function.Function<BeaconPart, dafny.DafnySequence<? extends Character>>)(_1_s_boxed0) -> {
      BeaconPart _1_s = ((BeaconPart)(java.lang.Object)(_1_s_boxed0));
      return (_1_s).getPrefix();
    }), p);
    if ((java.math.BigInteger.valueOf((_0_beaconParts).length())).signum() == 0) {
      return dafny.DafnySequence.asString("");
    } else {
      return StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _0_beaconParts, dafny.DafnySequence.asString(""));
    }
  }
  public dafny.DafnySequence<? extends Character> CPartToString(ConstructorPart s) {
    if ((s).dtor_required()) {
      return ((s).dtor_part()).getPrefix();
    } else {
      return dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("["), ((s).dtor_part()).getPrefix()), dafny.DafnySequence.asString("]"));
    }
  }
  public dafny.DafnySequence<? extends Character> CPartsToString(dafny.DafnySequence<? extends ConstructorPart> p) {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_beaconParts = Seq_Compile.__default.<ConstructorPart, dafny.DafnySequence<? extends Character>>Map(ConstructorPart._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((java.util.function.Function<ConstructorPart, dafny.DafnySequence<? extends Character>>)(_1_s_boxed0) -> {
      ConstructorPart _1_s = ((ConstructorPart)(java.lang.Object)(_1_s_boxed0));
      return (this).CPartToString(_1_s);
    }), p);
    if ((java.math.BigInteger.valueOf((_0_beaconParts).length())).signum() == 0) {
      return dafny.DafnySequence.asString("");
    } else {
      return StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _0_beaconParts, dafny.DafnySequence.asString(""));
    }
  }
  public dafny.DafnySequence<? extends Character> CListToString(dafny.DafnySequence<? extends Constructor> p) {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_beaconParts = Seq_Compile.__default.<Constructor, dafny.DafnySequence<? extends Character>>Map(Constructor._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((java.util.function.Function<Constructor, dafny.DafnySequence<? extends Character>>)(_1_s_boxed0) -> {
      Constructor _1_s = ((Constructor)(java.lang.Object)(_1_s_boxed0));
      return (this).CPartsToString((_1_s).dtor_parts());
    }), p);
    return StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _0_beaconParts, dafny.DafnySequence.asString(", "));
  }
  public boolean CanConstruct(dafny.DafnySequence<? extends ConstructorPart> con, dafny.DafnySequence<? extends BeaconPart> inParts, boolean matched)
  {
    CompoundBeacon _this = this;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((inParts).length())).signum() == 0) {
        return true;
      } else if ((java.math.BigInteger.valueOf((con).length())).signum() == 0) {
        return false;
      } else if (java.util.Objects.equals((((ConstructorPart)(java.lang.Object)((con).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_part(), ((BeaconPart)(java.lang.Object)((inParts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) {
        CompoundBeacon _in0 = _this;
        dafny.DafnySequence<? extends ConstructorPart> _in1 = (con).drop(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends BeaconPart> _in2 = (inParts).drop(java.math.BigInteger.ONE);
        boolean _in3 = true;
        _this = _in0;
        ;
        con = _in1;
        inParts = _in2;
        matched = _in3;
        continue TAIL_CALL_START;
      } else if ((!((((ConstructorPart)(java.lang.Object)((con).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_required())) || (!(matched))) {
        CompoundBeacon _in4 = _this;
        dafny.DafnySequence<? extends ConstructorPart> _in5 = (con).drop(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends BeaconPart> _in6 = inParts;
        boolean _in7 = matched;
        _this = _in4;
        ;
        con = _in5;
        inParts = _in6;
        matched = _in7;
        continue TAIL_CALL_START;
      } else {
        return false;
      }
    }
  }
  public boolean IsValidPartOrder(dafny.DafnySequence<? extends Constructor> candidates, dafny.DafnySequence<? extends BeaconPart> inParts)
  {
    CompoundBeacon _this = this;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((candidates).length())).signum() == 0) {
        return false;
      } else if ((_this).CanConstruct((((Constructor)(java.lang.Object)((candidates).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_parts(), inParts, false)) {
        return true;
      } else {
        CompoundBeacon _in0 = _this;
        dafny.DafnySequence<? extends Constructor> _in1 = (candidates).drop(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends BeaconPart> _in2 = inParts;
        _this = _in0;
        ;
        candidates = _in1;
        inParts = _in2;
        continue TAIL_CALL_START;
      }
    }
  }
  public Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> ValidatePartOrder(dafny.DafnySequence<? extends BeaconPart> inParts, dafny.DafnySequence<? extends Character> orig)
  {
    if ((this).IsValidPartOrder((this).dtor_construct(), inParts)) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else {
      dafny.DafnySequence<? extends Character> _0_msg = dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Compound Beacon value '"), orig), dafny.DafnySequence.asString("' cannot be constructed from any available constructor for ")), ((this).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" value parsed as ")), (this).PartsToString(inParts)), dafny.DafnySequence.asString(" available constructors are ")), (this).CListToString((this).dtor_construct())), dafny.DafnySequence.asString("."));
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(_0_msg));
    }
  }
  public Wrappers_Compile.Result<BeaconPart, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> partFromPrefix(dafny.DafnySequence<? extends BeaconPart> p, dafny.DafnySequence<? extends Character> value)
  {
    CompoundBeacon _this = this;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((p).length())).signum() == 0) {
        return Wrappers_Compile.Result.<BeaconPart, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(BeaconPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Value "), value), dafny.DafnySequence.asString(" for beacon ")), ((_this).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" does not match the prefix of any configured part."))));
      } else if (((((BeaconPart)(java.lang.Object)((p).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_prefix()).isPrefixOf(value)) {
        return Wrappers_Compile.Result.<BeaconPart, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(BeaconPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((BeaconPart)(java.lang.Object)((p).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))));
      } else {
        CompoundBeacon _in0 = _this;
        dafny.DafnySequence<? extends BeaconPart> _in1 = (p).drop(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends Character> _in2 = value;
        _this = _in0;
        ;
        p = _in1;
        value = _in2;
        continue TAIL_CALL_START;
      }
    }
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> SkipSignedPieces(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> pieces) {
    CompoundBeacon _this = this;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((pieces).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), pieces);
      } else {
        Wrappers_Compile.Result<BeaconPart, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = (_this).partFromPrefix((_this).dtor_parts(), ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((pieces).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))));
        if ((_0_valueOrError0).IsFailure(BeaconPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_0_valueOrError0).<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>PropagateFailure(BeaconPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
        } else {
          BeaconPart _1_p = (_0_valueOrError0).Extract(BeaconPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          if ((_1_p).is_Encrypted()) {
            return Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), pieces);
          } else {
            CompoundBeacon _in0 = _this;
            dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in1 = (pieces).drop(java.math.BigInteger.ONE);
            _this = _in0;
            ;
            pieces = _in1;
            continue TAIL_CALL_START;
          }
        }
      }
    }
  }
  public Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> IsLessThanComparable(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> pieces) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = (this).SkipSignedPieces(pieces);
    if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<Boolean>PropagateFailure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
    } else {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1_rest = (_0_valueOrError0).Extract(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      if ((java.math.BigInteger.valueOf((_1_rest).length())).signum() == 0) {
        return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
      } else if (!java.util.Objects.equals(java.math.BigInteger.valueOf((_1_rest).length()), java.math.BigInteger.ONE)) {
        return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), false);
      } else {
        Wrappers_Compile.Result<BeaconPart, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError1 = (this).partFromPrefix((this).dtor_parts(), ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_1_rest).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))));
        if ((_2_valueOrError1).IsFailure(BeaconPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_2_valueOrError1).<Boolean>PropagateFailure(BeaconPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
        } else {
          BeaconPart _3_p = (_2_valueOrError1).Extract(BeaconPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((_3_p).dtor_prefix()).equals(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_1_rest).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
        }
      }
    }
  }
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> GetFields(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields) {
    return StandardLibrary_mSequence_Compile.__default.<dafny.DafnySequence<? extends Character>>Flatten(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Seq_Compile.__default.<BeaconPart, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>Map(BeaconPart._typeDescriptor(), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>, java.util.function.Function<BeaconPart, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>>)(_0_virtualFields) -> ((java.util.function.Function<BeaconPart, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>)(_1_p_boxed0) -> {
      BeaconPart _1_p = ((BeaconPart)(java.lang.Object)(_1_p_boxed0));
      return (_1_p).GetFields(_0_virtualFields);
    })).apply(virtualFields), (this).dtor_parts()), (long) 0L, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> FindAndCalcPart(dafny.DafnySequence<? extends Character> value, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys)
  {
    Wrappers_Compile.Result<BeaconPart, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = (this).partFromPrefix((this).dtor_parts(), value);
    if ((_0_valueOrError0).IsFailure(BeaconPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends Character>>PropagateFailure(BeaconPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    } else {
      BeaconPart _1_part = (_0_valueOrError0).Extract(BeaconPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      return (this).PartValueCalc((value).drop(java.math.BigInteger.valueOf(((_1_part).dtor_prefix()).length())), keys, _1_part);
    }
  }
  public Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> justPrefix(dafny.DafnySequence<? extends Character> value) {
    Wrappers_Compile.Result<BeaconPart, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = (this).partFromPrefix((this).dtor_parts(), value);
    if ((_0_valueOrError0).IsFailure(BeaconPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<Boolean>PropagateFailure(BeaconPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
    } else {
      BeaconPart _1_part = (_0_valueOrError0).Extract(BeaconPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (value).equals((_1_part).dtor_prefix()));
    }
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetBeaconValue(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue value, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys, boolean forEquality)
  {
    if (!((value).is_S())) {
      return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("CompoundBeacon "), ((this).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" can only be queried as a string, not as ")), DynamoDbEncryptionUtil_Compile.__default.AttrTypeToStr(value))));
    } else {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_parts = StandardLibrary_Compile.__default.<Character>Split(dafny.TypeDescriptor.CHAR, (value).dtor_S(), (this).dtor_split());
      Wrappers_Compile.Result<dafny.DafnySequence<? extends BeaconPart>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError0 = StandardLibrary_mSequence_Compile.__default.<dafny.DafnySequence<? extends Character>, BeaconPart, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapWithResult(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), BeaconPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Wrappers_Compile.Result<BeaconPart, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>>)(_2_s_boxed0) -> {
        dafny.DafnySequence<? extends Character> _2_s = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_2_s_boxed0));
        return (this).getPartFromPrefix(_2_s);
      }), _0_parts, (long) 0L, dafny.DafnySequence.<BeaconPart> empty(BeaconPart._typeDescriptor()));
      if ((_1_valueOrError0).IsFailure(dafny.DafnySequence.<BeaconPart>_typeDescriptor(BeaconPart._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_1_valueOrError0).<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>PropagateFailure(dafny.DafnySequence.<BeaconPart>_typeDescriptor(BeaconPart._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor());
      } else {
        dafny.DafnySequence<? extends BeaconPart> _3_partsUsed = (_1_valueOrError0).Extract(dafny.DafnySequence.<BeaconPart>_typeDescriptor(BeaconPart._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError1 = (this).ValidatePartOrder(_3_partsUsed, (value).dtor_S());
        if ((_4_valueOrError1).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_4_valueOrError1).<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor());
        } else {
          boolean _5___v1 = (_4_valueOrError1).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_valueOrError2 = StandardLibrary_mSequence_Compile.__default.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapWithResult(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, java.util.function.Function<dafny.DafnySequence<? extends Character>, Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>>>)(_7_keys) -> ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>>)(_8_s_boxed0) -> {
            dafny.DafnySequence<? extends Character> _8_s = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_8_s_boxed0));
            return (this).FindAndCalcPart(_8_s, _7_keys);
          })).apply(keys), _0_parts, (long) 0L, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
          if ((_6_valueOrError2).IsFailure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            return (_6_valueOrError2).<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>PropagateFailure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor());
          } else {
            dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _9_beaconParts = (_6_valueOrError2).Extract(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
            Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _10_valueOrError3 = (this).justPrefix(Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>Last(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _0_parts));
            if ((_10_valueOrError3).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
              return (_10_valueOrError3).<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor());
            } else {
              boolean _11_lastIsPrefix = (_10_valueOrError3).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
              if ((!(forEquality)) && (_11_lastIsPrefix)) {
                dafny.DafnySequence<? extends Character> _12_result = StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate((_9_beaconParts).take((java.math.BigInteger.valueOf((_0_parts).length())).subtract(java.math.BigInteger.ONE)), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>Last(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _0_parts))), dafny.DafnySequence.<Character> of((this).dtor_split()));
                return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(_12_result));
              } else {
                dafny.DafnySequence<? extends Character> _13_result = StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _9_beaconParts, dafny.DafnySequence.<Character> of((this).dtor_split()));
                return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(_13_result));
              }
            }
          }
        }
      }
    }
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> TryConstructor(dafny.DafnySequence<? extends ConstructorPart> consFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> vf, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys, dafny.DafnySequence<? extends Character> acc)
  {
    CompoundBeacon _this = this;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((consFields).length())).signum() == 0) {
        if ((java.math.BigInteger.valueOf((acc).length())).signum() == 0) {
          return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Internal Error : Empty beacon created.")));
        } else {
          return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), acc));
        }
      } else {
        BeaconPart _0_part = (((ConstructorPart)(java.lang.Object)((consFields).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_part();
        Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError0 = (_0_part).getString(item, vf);
        if ((_1_valueOrError0).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_1_valueOrError0).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
        } else {
          Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _2_strValue = (_1_valueOrError0).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          if ((_2_strValue).is_Some()) {
            Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError1 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), !((_2_strValue).dtor_value()).contains((_this).dtor_split()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Part "), (_0_part).getName()), dafny.DafnySequence.asString(" for beacon ")), ((_this).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" has value '")), (_2_strValue).dtor_value()), dafny.DafnySequence.asString("' which contains the split character ")), dafny.DafnySequence.<Character> of((_this).dtor_split())), dafny.DafnySequence.asString("'."))));
            if ((_3_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
              return (_3_valueOrError1).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
            } else {
              Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError2 = (((keys).is_DontUseKeys()) ? (Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Character>concatenate((_0_part).dtor_prefix(), (_2_strValue).dtor_value()))) : ((_this).PartValueCalc((_2_strValue).dtor_value(), keys, _0_part)));
              if ((_4_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
                return (_4_valueOrError2).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
              } else {
                dafny.DafnySequence<? extends Character> _5_val = (_4_valueOrError2).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
                if ((java.math.BigInteger.valueOf((acc).length())).signum() == 0) {
                  CompoundBeacon _in0 = _this;
                  dafny.DafnySequence<? extends ConstructorPart> _in1 = (consFields).drop(java.math.BigInteger.ONE);
                  dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in2 = item;
                  dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> _in3 = vf;
                  DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in4 = keys;
                  dafny.DafnySequence<? extends Character> _in5 = _5_val;
                  _this = _in0;
                  ;
                  consFields = _in1;
                  item = _in2;
                  vf = _in3;
                  keys = _in4;
                  acc = _in5;
                  continue TAIL_CALL_START;
                } else {
                  CompoundBeacon _in6 = _this;
                  dafny.DafnySequence<? extends ConstructorPart> _in7 = (consFields).drop(java.math.BigInteger.ONE);
                  dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in8 = item;
                  dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> _in9 = vf;
                  DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in10 = keys;
                  dafny.DafnySequence<? extends Character> _in11 = dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(acc, dafny.DafnySequence.<Character> of((_this).dtor_split())), _5_val);
                  _this = _in6;
                  ;
                  consFields = _in7;
                  item = _in8;
                  vf = _in9;
                  keys = _in10;
                  acc = _in11;
                  continue TAIL_CALL_START;
                }
              }
            }
          } else if ((((ConstructorPart)(java.lang.Object)((consFields).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_required()) {
            return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
          } else {
            CompoundBeacon _in12 = _this;
            dafny.DafnySequence<? extends ConstructorPart> _in13 = (consFields).drop(java.math.BigInteger.ONE);
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in14 = item;
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> _in15 = vf;
            DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in16 = keys;
            dafny.DafnySequence<? extends Character> _in17 = acc;
            _this = _in12;
            ;
            consFields = _in13;
            item = _in14;
            vf = _in15;
            keys = _in16;
            acc = _in17;
            continue TAIL_CALL_START;
          }
        }
      }
    }
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> TryConstructors(dafny.DafnySequence<? extends Constructor> construct, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> vf, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys)
  {
    CompoundBeacon _this = this;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((construct).length())).signum() == 0) {
        return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
      } else {
        Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = (_this).TryConstructor((((Constructor)(java.lang.Object)((construct).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_parts(), item, vf, keys, dafny.DafnySequence.asString(""));
        if ((_0_valueOrError0).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_0_valueOrError0).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
        } else {
          Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _1_x = (_0_valueOrError0).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          if ((_1_x).is_Some()) {
            return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), _1_x);
          } else {
            CompoundBeacon _in0 = _this;
            dafny.DafnySequence<? extends Constructor> _in1 = (construct).drop(java.math.BigInteger.ONE);
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in2 = item;
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> _in3 = vf;
            DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in4 = keys;
            _this = _in0;
            ;
            construct = _in1;
            item = _in2;
            vf = _in3;
            keys = _in4;
            continue TAIL_CALL_START;
          }
        }
      }
    }
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> hash(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> vf, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys)
  {
    return (this).TryConstructors((this).dtor_construct(), item, vf, keys);
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> getNaked(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> vf)
  {
    return (this).TryConstructors((this).dtor_construct(), item, vf, DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_DontUseKeys());
  }
  public Wrappers_Compile.Result<BeaconPart, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> findPart(dafny.DafnySequence<? extends Character> val) {
    dafny.DafnySequence<? extends BeaconPart> _0_thePart = Seq_Compile.__default.<BeaconPart>Filter(BeaconPart._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, java.util.function.Function<BeaconPart, Boolean>>)(_1_val) -> ((java.util.function.Function<BeaconPart, Boolean>)(_2_x_boxed0) -> {
      BeaconPart _2_x = ((BeaconPart)(java.lang.Object)(_2_x_boxed0));
      return ((_2_x).dtor_prefix()).isPrefixOf(_1_val);
    })).apply(val), (this).dtor_parts());
    if ((java.math.BigInteger.valueOf((_0_thePart).length())).signum() == 0) {
      return Wrappers_Compile.Result.<BeaconPart, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(BeaconPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("No part found in beacon "), ((this).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" match prefix ")), val)));
    } else if ((java.math.BigInteger.valueOf((_0_thePart).length())).compareTo(java.math.BigInteger.ONE) > 0) {
      return Wrappers_Compile.Result.<BeaconPart, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(BeaconPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Internal error. Multiple parts for beacon "), ((this).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" matched prefix of ")), val)));
    } else {
      return Wrappers_Compile.Result.<BeaconPart, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(BeaconPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((BeaconPart)(java.lang.Object)((_0_thePart).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))));
    }
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> getPart(dafny.DafnySequence<? extends Character> val, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> keys)
  {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_pieces = StandardLibrary_Compile.__default.<Character>Split(dafny.TypeDescriptor.CHAR, val, (this).dtor_split());
    return (this).calcParts(_0_pieces, keys, dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> calcPart(dafny.DafnySequence<? extends Character> piece, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> keys)
  {
    Wrappers_Compile.Result<BeaconPart, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = (this).findPart(piece);
    if ((_0_valueOrError0).IsFailure(BeaconPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends Character>>PropagateFailure(BeaconPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    } else {
      BeaconPart _1_thePart = (_0_valueOrError0).Extract(BeaconPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      return (this).PartValueCalc(piece, DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_Keys(keys), _1_thePart);
    }
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> calcParts(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> pieces, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> keys, dafny.DafnySequence<? extends Character> acc)
  {
    CompoundBeacon _this = this;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((pieces).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), acc);
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = (_this).calcPart(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((pieces).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), keys);
        if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_0_valueOrError0).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        } else {
          dafny.DafnySequence<? extends Character> _1_theBeacon = (_0_valueOrError0).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          if ((java.math.BigInteger.valueOf((acc).length())).signum() == 0) {
            CompoundBeacon _in0 = _this;
            dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in1 = (pieces).drop(java.math.BigInteger.ONE);
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _in2 = keys;
            dafny.DafnySequence<? extends Character> _in3 = _1_theBeacon;
            _this = _in0;
            ;
            pieces = _in1;
            keys = _in2;
            acc = _in3;
            continue TAIL_CALL_START;
          } else {
            CompoundBeacon _in4 = _this;
            dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in5 = (pieces).drop(java.math.BigInteger.ONE);
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _in6 = keys;
            dafny.DafnySequence<? extends Character> _in7 = dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(acc, dafny.DafnySequence.<Character> of((_this).dtor_split())), _1_theBeacon);
            _this = _in4;
            ;
            pieces = _in5;
            keys = _in6;
            acc = _in7;
            continue TAIL_CALL_START;
          }
        }
      }
    }
  }
  public static boolean OkPrefixStringPair(dafny.DafnySequence<? extends Character> x, dafny.DafnySequence<? extends Character> y)
  {
    return (!((x).isPrefixOf(y))) && (!((y).isPrefixOf(x)));
  }
  public boolean OkPrefixPair(java.math.BigInteger pos1, java.math.BigInteger pos2)
  {
    return (java.util.Objects.equals(pos1, pos2)) || (CompoundBeacon.OkPrefixStringPair((((BeaconPart)(java.lang.Object)(((this).dtor_parts()).select(dafny.Helpers.toInt((pos1)))))).dtor_prefix(), (((BeaconPart)(java.lang.Object)(((this).dtor_parts()).select(dafny.Helpers.toInt((pos2)))))).dtor_prefix()));
  }
  public Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> CheckOnePrefixPart(java.math.BigInteger pos1, java.math.BigInteger pos2)
  {
    if (!((this).OkPrefixPair(pos1, pos2))) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Compound beacon "), ((this).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" defines part ")), (((BeaconPart)(java.lang.Object)(((this).dtor_parts()).select(dafny.Helpers.toInt((pos1)))))).getName()), dafny.DafnySequence.asString(" with prefix ")), (((BeaconPart)(java.lang.Object)(((this).dtor_parts()).select(dafny.Helpers.toInt((pos1)))))).dtor_prefix()), dafny.DafnySequence.asString(" which is incompatible with part ")), (((BeaconPart)(java.lang.Object)(((this).dtor_parts()).select(dafny.Helpers.toInt((pos2)))))).getName()), dafny.DafnySequence.asString(" which has a prefix of ")), (((BeaconPart)(java.lang.Object)(((this).dtor_parts()).select(dafny.Helpers.toInt((pos2)))))).dtor_prefix()), dafny.DafnySequence.asString("."))));
    } else {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    }
  }
  public Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> CheckOnePrefix(java.math.BigInteger pos) {
    dafny.DafnySequence<? extends java.math.BigInteger> _0_partNumbers = dafny.DafnySequence.Create(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(((this).dtor_parts()).length()), ((java.util.function.Function<java.math.BigInteger, java.math.BigInteger>)(_1_i_boxed0) -> {
      java.math.BigInteger _1_i = ((java.math.BigInteger)(java.lang.Object)(_1_i_boxed0));
      return _1_i;
    }));
    Wrappers_Compile.Result<dafny.DafnySequence<? extends Boolean>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError0 = StandardLibrary_mSequence_Compile.__default.<java.math.BigInteger, Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapWithResult(dafny.TypeDescriptor.BIG_INTEGER, dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<java.math.BigInteger, java.util.function.Function<java.math.BigInteger, Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>>>)(_3_pos) -> ((java.util.function.Function<java.math.BigInteger, Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>>)(_4_p_boxed0) -> {
      java.math.BigInteger _4_p = ((java.math.BigInteger)(java.lang.Object)(_4_p_boxed0));
      return (this).CheckOnePrefixPart(_3_pos, _4_p);
    })).apply(pos), dafny.DafnySequence.Create(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(((this).dtor_parts()).length()), ((java.util.function.Function<java.math.BigInteger, java.math.BigInteger>)(_5_i_boxed0) -> {
      java.math.BigInteger _5_i = ((java.math.BigInteger)(java.lang.Object)(_5_i_boxed0));
      return _5_i;
    })), (long) 0L, dafny.DafnySequence.<Boolean> empty(dafny.TypeDescriptor.BOOLEAN));
    if ((_2_valueOrError0).IsFailure(dafny.DafnySequence.<Boolean>_typeDescriptor(dafny.TypeDescriptor.BOOLEAN), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_2_valueOrError0).<Boolean>PropagateFailure(dafny.DafnySequence.<Boolean>_typeDescriptor(dafny.TypeDescriptor.BOOLEAN), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
    } else {
      dafny.DafnySequence<? extends Boolean> _6___v2 = (_2_valueOrError0).Extract(dafny.DafnySequence.<Boolean>_typeDescriptor(dafny.TypeDescriptor.BOOLEAN), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    }
  }
  public Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> ValidPrefixSetResultPos(java.math.BigInteger index) {
    CompoundBeacon _this = this;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf(((_this).dtor_parts()).length())).compareTo(index) <= 0) {
        return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
      } else {
        Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = (_this).CheckOnePrefix(index);
        if ((_0_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_0_valueOrError0).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
        } else {
          boolean _1___v3 = (_0_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          CompoundBeacon _in0 = _this;
          java.math.BigInteger _in1 = (index).add(java.math.BigInteger.ONE);
          _this = _in0;
          ;
          index = _in1;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> ValidPrefixSetResult() {
    Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = (this).ValidPrefixSetResultPos(java.math.BigInteger.ZERO);
    if ((_0_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
    } else {
      boolean _1___v4 = (_0_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      if (dafny.Helpers.Quantifier(dafny.Helpers.IntegerRange(java.math.BigInteger.ZERO, java.math.BigInteger.valueOf(((this).dtor_parts()).length())), true, ((_forall_var_0_boxed0) -> {
        java.math.BigInteger _forall_var_0 = ((java.math.BigInteger)(java.lang.Object)(_forall_var_0_boxed0));
        if (true) {
          java.math.BigInteger _2_x = (java.math.BigInteger)_forall_var_0;
          if (_System.nat._Is(_2_x)) {
            return dafny.Helpers.Quantifier(dafny.Helpers.IntegerRange(java.math.BigInteger.ZERO, java.math.BigInteger.valueOf(((this).dtor_parts()).length())), true, ((_forall_var_1_boxed0) -> {
              java.math.BigInteger _forall_var_1 = ((java.math.BigInteger)(java.lang.Object)(_forall_var_1_boxed0));
              if (true) {
                java.math.BigInteger _3_y = (java.math.BigInteger)_forall_var_1;
                if (_System.nat._Is(_3_y)) {
                  return !((((_2_x).signum() != -1) && ((_2_x).compareTo(java.math.BigInteger.valueOf(((this).dtor_parts()).length())) < 0)) && (((_2_x).compareTo(_3_y) < 0) && ((_3_y).compareTo(java.math.BigInteger.valueOf(((this).dtor_parts()).length())) < 0))) || ((this).OkPrefixPair(_2_x, _3_y));
                } else {
                  return true;
                }
              } else {
                return true;
              }
            }));
          } else {
            return true;
          }
        } else {
          return true;
        }
      }))) {
        return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
      } else {
        return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Internal Error")));
      }
    }
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> PartValueCalc(dafny.DafnySequence<? extends Character> data, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys, BeaconPart part)
  {
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), !(data).contains((this).dtor_split()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Value '"), data), dafny.DafnySequence.asString("' for beacon part ")), (part).getName()), dafny.DafnySequence.asString(" contains the split character '")), dafny.DafnySequence.<Character> of((this).dtor_split())), dafny.DafnySequence.asString("'."))));
    if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends Character>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    } else {
      BeaconPart _source0 = part;
      if (_source0.is_Encrypted()) {
        dafny.DafnySequence<? extends Character> _1___mcc_h0 = ((CompoundBeacon_Compile.BeaconPart_Encrypted)_source0)._prefix;
        BaseBeacon_Compile.StandardBeacon _2___mcc_h1 = ((CompoundBeacon_Compile.BeaconPart_Encrypted)_source0)._beacon;
        BaseBeacon_Compile.StandardBeacon _3_b = _2___mcc_h1;
        dafny.DafnySequence<? extends Character> _4_p = _1___mcc_h0;
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_valueOrError1 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (keys).is_Keys(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Need KeyId for beacon "), ((_3_b).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" but no KeyId found in query."))));
        if ((_5_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_5_valueOrError1).<dafny.DafnySequence<? extends Character>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        } else {
          Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_valueOrError2 = (_3_b).hashStr(data, (keys).dtor_value());
          if ((_6_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            return (_6_valueOrError2).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          } else {
            dafny.DafnySequence<? extends Character> _7_hash = (_6_valueOrError2).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
            return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Character>concatenate((part).dtor_prefix(), _7_hash));
          }
        }
      } else {
        dafny.DafnySequence<? extends Character> _8___mcc_h4 = ((CompoundBeacon_Compile.BeaconPart_Signed)_source0)._prefix;
        dafny.DafnySequence<? extends Character> _9___mcc_h5 = ((CompoundBeacon_Compile.BeaconPart_Signed)_source0)._name;
        dafny.DafnySequence<? extends TermLoc_Compile.Selector> _10___mcc_h6 = ((CompoundBeacon_Compile.BeaconPart_Signed)_source0)._loc;
        BeaconPart _11_Signed = part;
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Character>concatenate((part).dtor_prefix(), data));
      }
    }
  }
}
