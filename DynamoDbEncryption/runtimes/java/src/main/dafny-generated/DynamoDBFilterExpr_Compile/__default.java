// Class __default
// Dafny class __default compiled into Java
package DynamoDBFilterExpr_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> ExtractAttributes(dafny.DafnySequence<? extends Character> s, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> ex)
  {
    dafny.DafnySequence<? extends Token> _0_tokens = __default.ParseExpr(s, (long) 0L);
    return __default.ExtractAttributes2(_0_tokens, ex, java.math.BigInteger.valueOf(-1L), (long) 0L);
  }
  public static boolean IsSpecial(Token t) {
    return (((t).is_AttributeExists()) || ((t).is_AttributeNotExists())) || ((t).is_Size());
  }
  public static dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> ExtractAttributes2(dafny.DafnySequence<? extends Token> tokens, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names, java.math.BigInteger tokensUntilSkip, long pos)
  {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0___accumulator = dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    TAIL_CALL_START: while (true) {
      if (((long) (tokens).cardinalityInt()) == (pos)) {
        return dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(_0___accumulator, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
      } else if (__default.IsSpecial(((Token)(java.lang.Object)((tokens).select(dafny.Helpers.unsignedToInt(pos)))))) {
        dafny.DafnySequence<? extends Token> _in0 = tokens;
        Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in1 = names;
        java.math.BigInteger _in2 = java.math.BigInteger.ONE;
        long _in3 = (long) (long) ((pos) + ((long) 1L));
        tokens = _in0;
        names = _in1;
        tokensUntilSkip = _in2;
        pos = _in3;
        continue TAIL_CALL_START;
      } else if (((((Token)(java.lang.Object)((tokens).select(dafny.Helpers.unsignedToInt(pos))))).is_Attr()) && ((tokensUntilSkip).signum() == 0)) {
        dafny.DafnySequence<? extends Token> _in4 = tokens;
        Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in5 = names;
        java.math.BigInteger _in6 = java.math.BigInteger.valueOf(-1L);
        long _in7 = (long) (long) ((pos) + ((long) 1L));
        tokens = _in4;
        names = _in5;
        tokensUntilSkip = _in6;
        pos = _in7;
        continue TAIL_CALL_START;
      } else if ((((Token)(java.lang.Object)((tokens).select(dafny.Helpers.unsignedToInt(pos))))).is_Attr()) {
        _0___accumulator = dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(_0___accumulator, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), __default.GetAttrName(((Token)(java.lang.Object)((tokens).select(dafny.Helpers.unsignedToInt(pos)))), names)));
        dafny.DafnySequence<? extends Token> _in8 = tokens;
        Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in9 = names;
        java.math.BigInteger _in10 = java.math.BigInteger.valueOf(-1L);
        long _in11 = (long) (long) ((pos) + ((long) 1L));
        tokens = _in8;
        names = _in9;
        tokensUntilSkip = _in10;
        pos = _in11;
        continue TAIL_CALL_START;
      } else {
        dafny.DafnySequence<? extends Token> _in12 = tokens;
        Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in13 = names;
        java.math.BigInteger _in14 = (tokensUntilSkip).subtract(java.math.BigInteger.ONE);
        long _in15 = (long) (long) ((pos) + ((long) 1L));
        tokens = _in12;
        names = _in13;
        tokensUntilSkip = _in14;
        pos = _in15;
        continue TAIL_CALL_START;
      }
    }
  }
  public static boolean IsEquality(Token t) {
    return (((t).is_Eq()) || ((t).is_Ne())) || ((t).is_In());
  }
  public static boolean IsInequality(Token t) {
    return ((((t).is_Lt()) || ((t).is_Le())) || ((t).is_Gt())) || ((t).is_Ge());
  }
  public static dafny.DafnySequence<? extends Character> TokenToString(Token t) {
    Token _source0 = t;
    if (_source0.is_Attr()) {
      dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._loc;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _2_l = _1___mcc_h1;
      dafny.DafnySequence<? extends Character> _3_s = _0___mcc_h0;
      return _3_s;
    } else if (_source0.is_Value()) {
      dafny.DafnySequence<? extends Character> _4___mcc_h2 = ((DynamoDBFilterExpr_Compile.Token_Value)_source0)._s;
      dafny.DafnySequence<? extends Character> _5_s = _4___mcc_h2;
      return _5_s;
    } else if (_source0.is_Eq()) {
      return dafny.DafnySequence.asString("=");
    } else if (_source0.is_Ne()) {
      return dafny.DafnySequence.asString("<>");
    } else if (_source0.is_Lt()) {
      return dafny.DafnySequence.asString("<");
    } else if (_source0.is_Gt()) {
      return dafny.DafnySequence.asString(">");
    } else if (_source0.is_Le()) {
      return dafny.DafnySequence.asString("<=");
    } else if (_source0.is_Ge()) {
      return dafny.DafnySequence.asString(">=");
    } else if (_source0.is_Between()) {
      return dafny.DafnySequence.asString("BETWEEN");
    } else if (_source0.is_In()) {
      return dafny.DafnySequence.asString("IN");
    } else if (_source0.is_Open()) {
      return dafny.DafnySequence.asString("(");
    } else if (_source0.is_Close()) {
      return dafny.DafnySequence.asString(")");
    } else if (_source0.is_Comma()) {
      return dafny.DafnySequence.asString(",");
    } else if (_source0.is_Not()) {
      return dafny.DafnySequence.asString("NOT");
    } else if (_source0.is_And()) {
      return dafny.DafnySequence.asString("AND");
    } else if (_source0.is_Or()) {
      return dafny.DafnySequence.asString("OR");
    } else if (_source0.is_AttributeExists()) {
      return dafny.DafnySequence.asString("attribute_exists");
    } else if (_source0.is_AttributeNotExists()) {
      return dafny.DafnySequence.asString("attribute_not_exists");
    } else if (_source0.is_AttributeType()) {
      return dafny.DafnySequence.asString("attribute_type");
    } else if (_source0.is_BeginsWith()) {
      return dafny.DafnySequence.asString("begins_with");
    } else if (_source0.is_Contains()) {
      return dafny.DafnySequence.asString("contains");
    } else {
      return dafny.DafnySequence.asString("size");
    }
  }
  public static Wrappers_Compile.Option<java.math.BigInteger> GetInPos(dafny.DafnySequence<? extends Token> expr, java.math.BigInteger pos)
  {
    TAIL_CALL_START: while (true) {
      if ((pos).compareTo(java.math.BigInteger.valueOf(3L)) < 0) {
        return Wrappers_Compile.Option.<java.math.BigInteger>create_None(dafny.TypeDescriptor.BIG_INTEGER);
      } else if (((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))).is_Open()) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L)))))))).is_In())) {
        return Wrappers_Compile.Option.<java.math.BigInteger>create_Some(dafny.TypeDescriptor.BIG_INTEGER, (pos).subtract(java.math.BigInteger.valueOf(2L)));
      } else if (((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))).is_Comma()) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L)))))))).is_Value())) {
        dafny.DafnySequence<? extends Token> _in0 = expr;
        java.math.BigInteger _in1 = (pos).subtract(java.math.BigInteger.valueOf(2L));
        expr = _in0;
        pos = _in1;
        continue TAIL_CALL_START;
      } else {
        return Wrappers_Compile.Option.<java.math.BigInteger>create_None(dafny.TypeDescriptor.BIG_INTEGER);
      }
    }
  }
  public static dafny.DafnySequence<? extends Character> RealName(dafny.DafnySequence<? extends Character> s) {
    if ((DynamoDbEncryptionUtil_Compile.__default.BeaconPrefix()).isProperPrefixOf(s)) {
      return (s).drop(java.math.BigInteger.valueOf((DynamoDbEncryptionUtil_Compile.__default.BeaconPrefix()).length()));
    } else {
      return s;
    }
  }
  public static boolean HasBeacon(SearchableEncryptionInfo_Compile.BeaconVersion b, Token t, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names)
  {
    if ((t).is_Attr()) {
      dafny.DafnySequence<? extends Character> _0_name = __default.RealName((t).dtor_s());
      return (((((b).dtor_beacons()).<dafny.DafnySequence<? extends Character>>contains(_0_name)) || ((((names).is_Some()) && (((names).dtor_value()).<dafny.DafnySequence<? extends Character>>contains(_0_name))) && (((b).dtor_beacons()).<dafny.DafnySequence<? extends Character>>contains(__default.RealName(((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((names).dtor_value()).get(_0_name)))))))) || (((b).dtor_encryptedFields()).<dafny.DafnySequence<? extends Character>>contains(_0_name))) || ((((names).is_Some()) && (((names).dtor_value()).<dafny.DafnySequence<? extends Character>>contains(_0_name))) && (((b).dtor_encryptedFields()).<dafny.DafnySequence<? extends Character>>contains(__default.RealName(((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((names).dtor_value()).get(_0_name)))))));
    } else {
      return false;
    }
  }
  public static Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.Beacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetBeacon2(SearchableEncryptionInfo_Compile.BeaconVersion b, Token t, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names)
  {
    dafny.DafnySequence<? extends Character> _0_name = __default.RealName((t).dtor_s());
    if (((b).dtor_beacons()).<dafny.DafnySequence<? extends Character>>contains(_0_name)) {
      if (SearchableEncryptionInfo_Compile.__default.IsPartOnly(((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)(((b).dtor_beacons()).get(_0_name))))) {
        return Wrappers_Compile.Result.<SearchableEncryptionInfo_Compile.Beacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(SearchableEncryptionInfo_Compile.Beacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Field "), _0_name), dafny.DafnySequence.asString(" is encrypted, and has a PartOnly beacon, and so can only be used as part of a compound beacon."))));
      } else {
        return Wrappers_Compile.Result.<SearchableEncryptionInfo_Compile.Beacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(SearchableEncryptionInfo_Compile.Beacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)(((b).dtor_beacons()).get(_0_name))));
      }
    } else if ((((names).is_Some()) && (((names).dtor_value()).<dafny.DafnySequence<? extends Character>>contains(_0_name))) && (((b).dtor_beacons()).<dafny.DafnySequence<? extends Character>>contains(__default.RealName(((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((names).dtor_value()).get(_0_name))))))) {
      dafny.DafnySequence<? extends Character> _1_name2 = __default.RealName(((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((names).dtor_value()).get(_0_name))));
      return Wrappers_Compile.Result.<SearchableEncryptionInfo_Compile.Beacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(SearchableEncryptionInfo_Compile.Beacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)(((b).dtor_beacons()).get(_1_name2))));
    } else if (((b).dtor_encryptedFields()).<dafny.DafnySequence<? extends Character>>contains(_0_name)) {
      return Wrappers_Compile.Result.<SearchableEncryptionInfo_Compile.Beacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(SearchableEncryptionInfo_Compile.Beacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Field "), _0_name), dafny.DafnySequence.asString(" is encrypted, and cannot be searched without a beacon."))));
    } else {
      dafny.DafnySequence<? extends Character> _2_name2 = __default.RealName(((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((names).dtor_value()).get(_0_name))));
      return Wrappers_Compile.Result.<SearchableEncryptionInfo_Compile.Beacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(SearchableEncryptionInfo_Compile.Beacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Field "), _2_name2), dafny.DafnySequence.asString(" is encrypted, and cannot be searched without a beacon."))));
    }
  }
  public static Wrappers_Compile.Result<EqualityBeacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetBeacon(SearchableEncryptionInfo_Compile.BeaconVersion bv, Token t, Token op, Token value, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> values)
  {
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.Beacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = __default.GetBeacon2(bv, t, names);
    if ((_0_valueOrError0).IsFailure(SearchableEncryptionInfo_Compile.Beacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<EqualityBeacon>PropagateFailure(SearchableEncryptionInfo_Compile.Beacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), EqualityBeacon._typeDescriptor());
    } else {
      SearchableEncryptionInfo_Compile.Beacon _1_b = (_0_valueOrError0).Extract(SearchableEncryptionInfo_Compile.Beacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError1 = __default.CanBeacon(_1_b, op, (value).dtor_s(), values);
      if ((_2_valueOrError1).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_2_valueOrError1).<EqualityBeacon>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), EqualityBeacon._typeDescriptor());
      } else {
        boolean _3___v0 = (_2_valueOrError1).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<EqualityBeacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(EqualityBeacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), EqualityBeacon.create(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.Beacon>create_Some(SearchableEncryptionInfo_Compile.Beacon._typeDescriptor(), _1_b), __default.IsEquality(op), java.util.Objects.equals(op, Token.create_Contains())));
      }
    }
  }
  public static Wrappers_Compile.Result<EqualityBeacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetBetweenBeacon(SearchableEncryptionInfo_Compile.BeaconVersion bv, Token t, Token op, Token leftValue, Token rightValue, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> values)
  {
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.Beacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = __default.GetBeacon2(bv, t, names);
    if ((_0_valueOrError0).IsFailure(SearchableEncryptionInfo_Compile.Beacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<EqualityBeacon>PropagateFailure(SearchableEncryptionInfo_Compile.Beacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), EqualityBeacon._typeDescriptor());
    } else {
      SearchableEncryptionInfo_Compile.Beacon _1_b = (_0_valueOrError0).Extract(SearchableEncryptionInfo_Compile.Beacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError1 = __default.CanBetween(_1_b, op, (leftValue).dtor_s(), (rightValue).dtor_s(), values);
      if ((_2_valueOrError1).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_2_valueOrError1).<EqualityBeacon>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), EqualityBeacon._typeDescriptor());
      } else {
        boolean _3___v1 = (_2_valueOrError1).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<EqualityBeacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(EqualityBeacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), EqualityBeacon.create(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.Beacon>create_Some(SearchableEncryptionInfo_Compile.Beacon._typeDescriptor(), _1_b), false, false));
      }
    }
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> CanStandardBeacon(Token op) {
    Token _source0 = op;
    if (_source0.is_Attr()) {
      dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._loc;
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_Value()) {
      dafny.DafnySequence<? extends Character> _2___mcc_h4 = ((DynamoDBFilterExpr_Compile.Token_Value)_source0)._s;
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_Eq()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_Ne()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The operation '"), __default.TokenToString(op)), dafny.DafnySequence.asString("' cannot be used with a standard beacon."))));
    } else if (_source0.is_Lt()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The operation '"), __default.TokenToString(op)), dafny.DafnySequence.asString("' cannot be used with a standard beacon."))));
    } else if (_source0.is_Gt()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The operation '"), __default.TokenToString(op)), dafny.DafnySequence.asString("' cannot be used with a standard beacon."))));
    } else if (_source0.is_Le()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The operation '"), __default.TokenToString(op)), dafny.DafnySequence.asString("' cannot be used with a standard beacon."))));
    } else if (_source0.is_Ge()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The operation '"), __default.TokenToString(op)), dafny.DafnySequence.asString("' cannot be used with a standard beacon."))));
    } else if (_source0.is_Between()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The operation '"), __default.TokenToString(op)), dafny.DafnySequence.asString("' cannot be used with a standard beacon."))));
    } else if (_source0.is_In()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_Open()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_Close()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_Comma()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_Not()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_And()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_Or()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_AttributeExists()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_AttributeNotExists()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_AttributeType()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_BeginsWith()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The operation '"), __default.TokenToString(op)), dafny.DafnySequence.asString("' cannot be used with a standard beacon."))));
    } else if (_source0.is_Contains()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    }
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> CanCompoundBeacon(SearchableEncryptionInfo_Compile.Beacon b, Token op, dafny.DafnySequence<? extends Character> value)
  {
    Token _source0 = op;
    if (_source0.is_Attr()) {
      dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._loc;
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_Value()) {
      dafny.DafnySequence<? extends Character> _2___mcc_h4 = ((DynamoDBFilterExpr_Compile.Token_Value)_source0)._s;
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_Eq()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_Ne()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_Lt()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _3_pieces = StandardLibrary_Compile.__default.<Character>Split(dafny.TypeDescriptor.CHAR, value, ((b).dtor_cmp()).dtor_split());
      Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError0 = ((b).dtor_cmp()).IsLessThanComparable(_3_pieces);
      if ((_4_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_4_valueOrError0).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      } else {
        boolean _5_canLess = (_4_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        if (_5_canLess) {
          return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
        } else {
          return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The operation '"), __default.TokenToString(op)), dafny.DafnySequence.asString("' cannot be used with a compound beacon, unless the value is LessThanComparable : ")), value)));
        }
      }
    } else if (_source0.is_Gt()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _6_pieces = StandardLibrary_Compile.__default.<Character>Split(dafny.TypeDescriptor.CHAR, value, ((b).dtor_cmp()).dtor_split());
      Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _7_valueOrError0 = ((b).dtor_cmp()).IsLessThanComparable(_6_pieces);
      if ((_7_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_7_valueOrError0).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      } else {
        boolean _8_canLess = (_7_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        if (_8_canLess) {
          return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
        } else {
          return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The operation '"), __default.TokenToString(op)), dafny.DafnySequence.asString("' cannot be used with a compound beacon, unless the value is LessThanComparable : ")), value)));
        }
      }
    } else if (_source0.is_Le()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _9_pieces = StandardLibrary_Compile.__default.<Character>Split(dafny.TypeDescriptor.CHAR, value, ((b).dtor_cmp()).dtor_split());
      Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _10_valueOrError0 = ((b).dtor_cmp()).IsLessThanComparable(_9_pieces);
      if ((_10_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_10_valueOrError0).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      } else {
        boolean _11_canLess = (_10_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        if (_11_canLess) {
          return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
        } else {
          return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The operation '"), __default.TokenToString(op)), dafny.DafnySequence.asString("' cannot be used with a compound beacon, unless the value is LessThanComparable : ")), value)));
        }
      }
    } else if (_source0.is_Ge()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _12_pieces = StandardLibrary_Compile.__default.<Character>Split(dafny.TypeDescriptor.CHAR, value, ((b).dtor_cmp()).dtor_split());
      Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _13_valueOrError0 = ((b).dtor_cmp()).IsLessThanComparable(_12_pieces);
      if ((_13_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_13_valueOrError0).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      } else {
        boolean _14_canLess = (_13_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        if (_14_canLess) {
          return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
        } else {
          return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The operation '"), __default.TokenToString(op)), dafny.DafnySequence.asString("' cannot be used with a compound beacon, unless the value is LessThanComparable : ")), value)));
        }
      }
    } else if (_source0.is_Between()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_In()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_Open()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_Close()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_Comma()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_Not()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_And()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_Or()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_AttributeExists()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_AttributeNotExists()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_AttributeType()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_BeginsWith()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else if (_source0.is_Contains()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetStringFromValue(dafny.DafnySequence<? extends Character> value, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> values, SearchableEncryptionInfo_Compile.Beacon b)
  {
    if ((values).<dafny.DafnySequence<? extends Character>>contains(value)) {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _0_val = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((values).get(value)));
      if ((_0_val).is_S()) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (_0_val).dtor_S());
      } else {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Value "), value), dafny.DafnySequence.asString(" supplied for compound beacon ")), (((b).dtor_cmp()).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" is of type ")), DynamoDbEncryptionUtil_Compile.__default.AttrTypeToStr(_0_val)), dafny.DafnySequence.asString(" but must be of type S (string)."))));
      }
    } else {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Value "), value), dafny.DafnySequence.asString(" used in query string, but not supplied in value map."))));
    }
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> CanBeacon(SearchableEncryptionInfo_Compile.Beacon b, Token op, dafny.DafnySequence<? extends Character> value, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> values)
  {
    if ((b).is_Standard()) {
      return __default.CanStandardBeacon(op);
    } else {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = __default.GetStringFromValue(value, values, b);
      if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_0_valueOrError0).<Boolean>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      } else {
        dafny.DafnySequence<? extends Character> _1_val = (_0_valueOrError0).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        return __default.CanCompoundBeacon(b, op, _1_val);
      }
    }
  }
  public static dafny.Tuple2<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> RemoveCommonPrefix(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> x, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> y, long pos)
  {
    TAIL_CALL_START: while (true) {
      if (((((long) (x).cardinalityInt()) == (pos)) || (((long) (y).cardinalityInt()) == (pos))) || (!(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((x).select(dafny.Helpers.unsignedToInt(pos))))).equals(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((y).select(dafny.Helpers.unsignedToInt(pos))))))) {
        return dafny.Tuple2.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>create((x).drop(pos), (y).drop(pos));
      } else {
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in0 = x;
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in1 = y;
        long _in2 = StandardLibrary_mMemoryMath_Compile.__default.Add(pos, (long) 1L);
        x = _in0;
        y = _in1;
        pos = _in2;
        continue TAIL_CALL_START;
      }
    }
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> CanBetween(SearchableEncryptionInfo_Compile.Beacon b, Token op, dafny.DafnySequence<? extends Character> leftValue, dafny.DafnySequence<? extends Character> rightValue, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> values)
  {
    if ((b).is_Standard()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("The operation BETWEEN cannot be used with a standard beacon.")));
    } else {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = __default.GetStringFromValue(leftValue, values, b);
      if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_0_valueOrError0).<Boolean>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      } else {
        dafny.DafnySequence<? extends Character> _1_leftVal = (_0_valueOrError0).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError1 = __default.GetStringFromValue(rightValue, values, b);
        if ((_2_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_2_valueOrError1).<Boolean>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
        } else {
          dafny.DafnySequence<? extends Character> _3_rightVal = (_2_valueOrError1).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _4_leftParts = StandardLibrary_Compile.__default.<Character>Split(dafny.TypeDescriptor.CHAR, _1_leftVal, ((b).dtor_cmp()).dtor_split());
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _5_rightParts = StandardLibrary_Compile.__default.<Character>Split(dafny.TypeDescriptor.CHAR, _3_rightVal, ((b).dtor_cmp()).dtor_split());
          dafny.Tuple2<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> _let_tmp_rhs0 = __default.RemoveCommonPrefix(_4_leftParts, _5_rightParts, (long) 0L);
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _6_newLeft = ((dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>)(java.lang.Object)(((dafny.Tuple2<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>)_let_tmp_rhs0).dtor__0()));
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _7_newRight = ((dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>)(java.lang.Object)(((dafny.Tuple2<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>)_let_tmp_rhs0).dtor__1()));
          Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _8_valueOrError2 = ((b).dtor_cmp()).IsLessThanComparable(_6_newLeft);
          if ((_8_valueOrError2).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            return (_8_valueOrError2).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
          } else {
            boolean _9_leftCanLess = (_8_valueOrError2).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
            Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _10_valueOrError3 = ((b).dtor_cmp()).IsLessThanComparable(_7_newRight);
            if ((_10_valueOrError3).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
              return (_10_valueOrError3).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
            } else {
              boolean _11_rightCanLess = (_10_valueOrError3).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
              Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _12_valueOrError4 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (_9_leftCanLess) && (_11_rightCanLess), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("To use BETWEEN with a compound beacon, the part after any common prefix must be LessThanComparable : "), dafny.DafnySequence.asString("BETWEEN ")), _1_leftVal), dafny.DafnySequence.asString(" AND ")), _3_rightVal)));
              if ((_12_valueOrError4).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
                return (_12_valueOrError4).<Boolean>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
              } else {
                return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
              }
            }
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<EqualityBeacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> BeaconForValue(SearchableEncryptionInfo_Compile.BeaconVersion b, dafny.DafnySequence<? extends Token> expr, java.math.BigInteger pos, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> values)
  {
    if (((((pos).add(java.math.BigInteger.valueOf(2L))).compareTo(java.math.BigInteger.valueOf((expr).length())) < 0) && (__default.IsComp(((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).add(java.math.BigInteger.ONE))))))))) && (__default.HasBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).add(java.math.BigInteger.valueOf(2L))))))), names))) {
      return __default.GetBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).add(java.math.BigInteger.valueOf(2L))))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).add(java.math.BigInteger.ONE)))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos))))), names, values);
    } else if ((((java.math.BigInteger.valueOf(2L)).compareTo(pos) <= 0) && (__default.IsComp(((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))))) && (__default.HasBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))), names))) {
      return __default.GetBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE)))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos))))), names, values);
    } else if ((((((java.math.BigInteger.valueOf(4L)).compareTo(pos) <= 0) && (((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(4L)))))))).is_Contains()) || ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(4L)))))))).is_BeginsWith()))) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(3L)))))))).is_Open())) && (__default.HasBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))), names))) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))).is_Comma())) {
      return __default.GetBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(4L))))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos))))), names, values);
    } else if (((((((java.math.BigInteger.valueOf(2L)).compareTo(pos) <= 0) && ((pos).compareTo((java.math.BigInteger.valueOf((expr).length())).subtract(java.math.BigInteger.valueOf(2L))) < 0)) && (((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L)))))))).is_Contains()) || ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L)))))))).is_BeginsWith()))) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))).is_Open())) && (__default.HasBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).add(java.math.BigInteger.valueOf(2L))))))), names))) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).add(java.math.BigInteger.ONE))))))).is_Comma())) {
      return __default.GetBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).add(java.math.BigInteger.valueOf(2L))))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos))))), names, values);
    } else if ((((((java.math.BigInteger.valueOf(2L)).compareTo(pos) <= 0) && ((pos).compareTo((java.math.BigInteger.valueOf((expr).length())).subtract(java.math.BigInteger.valueOf(2L))) < 0)) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))).is_Between())) && (__default.HasBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))), names))) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).add(java.math.BigInteger.valueOf(2L)))))))).is_Value())) {
      return __default.GetBetweenBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE)))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).add(java.math.BigInteger.valueOf(2L))))))), names, values);
    } else if ((((((java.math.BigInteger.valueOf(4L)).compareTo(pos) <= 0) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))).is_And())) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(3L)))))))).is_Between())) && (__default.HasBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(4L))))))), names))) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L)))))))).is_Value())) {
      return __default.GetBetweenBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(4L))))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(3L))))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos))))), names, values);
    } else if ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).is_Value()) {
      Wrappers_Compile.Option<java.math.BigInteger> _0_in__pos = __default.GetInPos(expr, pos);
      if ((_0_in__pos).is_None()) {
        return Wrappers_Compile.Result.<EqualityBeacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(EqualityBeacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), EqualityBeacon.create(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.Beacon>create_None(SearchableEncryptionInfo_Compile.Beacon._typeDescriptor()), true, false));
      } else if (__default.HasBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((((_0_in__pos).dtor_value()).subtract(java.math.BigInteger.ONE)))))), names)) {
        return __default.GetBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((((_0_in__pos).dtor_value()).subtract(java.math.BigInteger.ONE)))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((_0_in__pos).dtor_value()))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos))))), names, values);
      } else {
        return Wrappers_Compile.Result.<EqualityBeacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(EqualityBeacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), EqualityBeacon.create(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.Beacon>create_None(SearchableEncryptionInfo_Compile.Beacon._typeDescriptor()), true, false));
      }
    } else {
      return Wrappers_Compile.Result.<EqualityBeacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(EqualityBeacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), EqualityBeacon.create(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.Beacon>create_None(SearchableEncryptionInfo_Compile.Beacon._typeDescriptor()), true, false));
    }
  }
  public static Wrappers_Compile.Option<Token> AttrForValue(dafny.DafnySequence<? extends Token> expr, java.math.BigInteger pos)
  {
    if (((((pos).add(java.math.BigInteger.valueOf(2L))).compareTo(java.math.BigInteger.valueOf((expr).length())) < 0) && (__default.IsComp(((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).add(java.math.BigInteger.ONE))))))))) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).add(java.math.BigInteger.valueOf(2L)))))))).is_Attr())) {
      return Wrappers_Compile.Option.<Token>create_Some(Token._typeDescriptor(), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).add(java.math.BigInteger.valueOf(2L))))))));
    } else if ((((java.math.BigInteger.valueOf(2L)).compareTo(pos) <= 0) && (__default.IsComp(((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))))) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L)))))))).is_Attr())) {
      return Wrappers_Compile.Option.<Token>create_Some(Token._typeDescriptor(), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))));
    } else if ((((((java.math.BigInteger.valueOf(4L)).compareTo(pos) <= 0) && (((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(4L)))))))).is_Contains()) || ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(4L)))))))).is_BeginsWith()))) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(3L)))))))).is_Open())) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L)))))))).is_Attr())) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))).is_Comma())) {
      return Wrappers_Compile.Option.<Token>create_Some(Token._typeDescriptor(), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))));
    } else if ((((java.math.BigInteger.valueOf(2L)).compareTo(pos) <= 0) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))).is_Between())) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L)))))))).is_Attr())) {
      return Wrappers_Compile.Option.<Token>create_Some(Token._typeDescriptor(), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))));
    } else if (((((java.math.BigInteger.valueOf(4L)).compareTo(pos) <= 0) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))).is_And())) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(3L)))))))).is_Between())) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(4L)))))))).is_Attr())) {
      return Wrappers_Compile.Option.<Token>create_Some(Token._typeDescriptor(), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(4L))))))));
    } else {
      Wrappers_Compile.Option<java.math.BigInteger> _0_in__pos = __default.GetInPos(expr, pos);
      if ((_0_in__pos).is_None()) {
        return Wrappers_Compile.Option.<Token>create_None(Token._typeDescriptor());
      } else if ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((((_0_in__pos).dtor_value()).subtract(java.math.BigInteger.ONE))))))).is_Attr()) {
        return Wrappers_Compile.Option.<Token>create_Some(Token._typeDescriptor(), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((((_0_in__pos).dtor_value()).subtract(java.math.BigInteger.ONE)))))));
      } else {
        return Wrappers_Compile.Option.<Token>create_None(Token._typeDescriptor());
      }
    }
  }
  public static boolean OpNeedsBeacon(dafny.DafnySequence<? extends Token> expr, java.math.BigInteger pos)
  {
    if ((pos).compareTo(java.math.BigInteger.valueOf(2L)) < 0) {
      return true;
    } else if (!((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))).is_Open())) {
      return true;
    } else {
      return __default.TokenNeedsBeacon(((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))));
    }
  }
  public static boolean IsAllowedOnBeaconPred(dafny.DafnySequence<? extends Token> expr, java.math.BigInteger pos)
  {
    if ((pos).compareTo(java.math.BigInteger.valueOf(2L)) < 0) {
      return true;
    } else if (!((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))).is_Open())) {
      return true;
    } else if (__default.TokenAllowsBeacon(((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))))) {
      return true;
    } else {
      return false;
    }
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> IsAllowedOnBeacon(dafny.DafnySequence<? extends Token> expr, java.math.BigInteger pos, dafny.DafnySequence<? extends Character> name)
  {
    if (__default.IsAllowedOnBeaconPred(expr, pos)) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Function "), __default.TokenToString(((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))))), dafny.DafnySequence.asString(" cannot be used on encrypted fields, but it is being used with ")), name)));
    }
  }
  public static boolean TokenNeedsBeacon(Token t) {
    return !(((t).is_AttributeExists()) || ((t).is_AttributeNotExists()));
  }
  public static boolean TokenAllowsBeacon(Token t) {
    return !(((t).is_AttributeType()) || ((t).is_Size()));
  }
  public static Wrappers_Compile.Result<ParsedContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> BeaconizeParsedExpr(SearchableEncryptionInfo_Compile.BeaconVersion b, dafny.DafnySequence<? extends Token> expr, java.math.BigInteger pos, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> oldValues, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> newValues, dafny.DafnySequence<? extends Token> acc)
  {
    TAIL_CALL_START: while (true) {
      if (java.util.Objects.equals(pos, java.math.BigInteger.valueOf((expr).length()))) {
        return Wrappers_Compile.Result.<ParsedContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(ParsedContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ParsedContext.create(acc, newValues, names));
      } else if ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).is_Attr()) {
        boolean _0_isIndirectName = (dafny.DafnySequence.asString("#")).isPrefixOf((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).dtor_s());
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (!(_0_isIndirectName)) || (((names).is_Some()) && (((names).dtor_value()).<dafny.DafnySequence<? extends Character>>contains((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).dtor_s()))), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Name "), (((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).dtor_s()), dafny.DafnySequence.asString(" not in ExpressionAttributeNameMap."))));
        if ((_1_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_1_valueOrError0).<ParsedContext>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ParsedContext._typeDescriptor());
        } else {
          dafny.DafnySequence<? extends Character> _2_oldName = ((_0_isIndirectName) ? (((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((names).dtor_value()).get((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).dtor_s())))) : ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).dtor_s()));
          boolean _3_exclude = ((keys).is_DontUseKeys()) && (!(__default.IsAllowedOnBeaconPred(expr, pos)));
          if (((b).IsBeacon(_2_oldName)) && (!(_3_exclude))) {
            Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError1 = __default.IsAllowedOnBeacon(expr, pos, _2_oldName);
            if ((_4_valueOrError1).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
              return (_4_valueOrError1).<ParsedContext>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ParsedContext._typeDescriptor());
            } else {
              boolean _5___v4 = (_4_valueOrError1).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
              if (__default.OpNeedsBeacon(expr, pos)) {
                dafny.DafnySequence<? extends Character> _6_newName = (((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)(((b).dtor_beacons()).get(_2_oldName)))).getBeaconName();
                if (_0_isIndirectName) {
                  SearchableEncryptionInfo_Compile.BeaconVersion _in0 = b;
                  dafny.DafnySequence<? extends Token> _in1 = expr;
                  java.math.BigInteger _in2 = (pos).add(java.math.BigInteger.ONE);
                  dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in3 = oldValues;
                  Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in4 = Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor()), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>update((names).dtor_value(), (((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).dtor_s(), _6_newName));
                  DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in5 = keys;
                  dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in6 = newValues;
                  dafny.DafnySequence<? extends Token> _in7 = dafny.DafnySequence.<Token>concatenate(acc, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))));
                  b = _in0;
                  expr = _in1;
                  pos = _in2;
                  oldValues = _in3;
                  names = _in4;
                  keys = _in5;
                  newValues = _in6;
                  acc = _in7;
                  continue TAIL_CALL_START;
                } else {
                  SearchableEncryptionInfo_Compile.BeaconVersion _in8 = b;
                  dafny.DafnySequence<? extends Token> _in9 = expr;
                  java.math.BigInteger _in10 = (pos).add(java.math.BigInteger.ONE);
                  dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in11 = oldValues;
                  Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in12 = names;
                  DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in13 = keys;
                  dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in14 = newValues;
                  dafny.DafnySequence<? extends Token> _in15 = dafny.DafnySequence.<Token>concatenate(acc, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), Token.create_Attr(_6_newName, TermLoc_Compile.__default.TermLocMap(_6_newName))));
                  b = _in8;
                  expr = _in9;
                  pos = _in10;
                  oldValues = _in11;
                  names = _in12;
                  keys = _in13;
                  newValues = _in14;
                  acc = _in15;
                  continue TAIL_CALL_START;
                }
              } else {
                SearchableEncryptionInfo_Compile.BeaconVersion _in16 = b;
                dafny.DafnySequence<? extends Token> _in17 = expr;
                java.math.BigInteger _in18 = (pos).add(java.math.BigInteger.ONE);
                dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in19 = oldValues;
                Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in20 = names;
                DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in21 = keys;
                dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in22 = newValues;
                dafny.DafnySequence<? extends Token> _in23 = dafny.DafnySequence.<Token>concatenate(acc, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))));
                b = _in16;
                expr = _in17;
                pos = _in18;
                oldValues = _in19;
                names = _in20;
                keys = _in21;
                newValues = _in22;
                acc = _in23;
                continue TAIL_CALL_START;
              }
            }
          } else {
            SearchableEncryptionInfo_Compile.BeaconVersion _in24 = b;
            dafny.DafnySequence<? extends Token> _in25 = expr;
            java.math.BigInteger _in26 = (pos).add(java.math.BigInteger.ONE);
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in27 = oldValues;
            Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in28 = names;
            DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in29 = keys;
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in30 = newValues;
            dafny.DafnySequence<? extends Token> _in31 = dafny.DafnySequence.<Token>concatenate(acc, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))));
            b = _in24;
            expr = _in25;
            pos = _in26;
            oldValues = _in27;
            names = _in28;
            keys = _in29;
            newValues = _in30;
            acc = _in31;
            continue TAIL_CALL_START;
          }
        }
      } else if ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).is_Value()) {
        dafny.DafnySequence<? extends Character> _7_name = (((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).dtor_s();
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _8_valueOrError2 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (oldValues).<dafny.DafnySequence<? extends Character>>contains(_7_name), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(_7_name, dafny.DafnySequence.asString(" not found in ExpressionAttributeValueMap"))));
        if ((_8_valueOrError2).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_8_valueOrError2).<ParsedContext>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ParsedContext._typeDescriptor());
        } else {
          software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _9_oldValue = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((oldValues).get(_7_name)));
          Wrappers_Compile.Result<EqualityBeacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _10_valueOrError3 = __default.BeaconForValue(b, expr, pos, names, oldValues);
          if ((_10_valueOrError3).IsFailure(EqualityBeacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            return (_10_valueOrError3).<ParsedContext>PropagateFailure(EqualityBeacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ParsedContext._typeDescriptor());
          } else {
            EqualityBeacon _11_eb = (_10_valueOrError3).Extract(EqualityBeacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
            Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _12_valueOrError4 = ((((_11_eb).dtor_beacon()).is_None()) ? (Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), _9_oldValue)) : ((((_11_eb).dtor_beacon()).dtor_value()).GetBeaconValue(_9_oldValue, keys, (_11_eb).dtor_forEquality(), (_11_eb).dtor_forContains())));
            if ((_12_valueOrError4).IsFailure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
              return (_12_valueOrError4).<ParsedContext>PropagateFailure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ParsedContext._typeDescriptor());
            } else {
              software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _13_newValue = (_12_valueOrError4).Extract(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
              Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _14_valueOrError5 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (!(newValues).<dafny.DafnySequence<? extends Character>>contains(_7_name)) || (java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((newValues).get(_7_name))), _13_newValue)), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(_7_name, dafny.DafnySequence.asString(" used in two different contexts, which is not allowed."))));
              if ((_14_valueOrError5).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
                return (_14_valueOrError5).<ParsedContext>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ParsedContext._typeDescriptor());
              } else {
                SearchableEncryptionInfo_Compile.BeaconVersion _in32 = b;
                dafny.DafnySequence<? extends Token> _in33 = expr;
                java.math.BigInteger _in34 = (pos).add(java.math.BigInteger.ONE);
                dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in35 = oldValues;
                Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in36 = names;
                DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in37 = keys;
                dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in38 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>update(newValues, _7_name, _13_newValue);
                dafny.DafnySequence<? extends Token> _in39 = dafny.DafnySequence.<Token>concatenate(acc, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))));
                b = _in32;
                expr = _in33;
                pos = _in34;
                oldValues = _in35;
                names = _in36;
                keys = _in37;
                newValues = _in38;
                acc = _in39;
                continue TAIL_CALL_START;
              }
            }
          }
        }
      } else {
        SearchableEncryptionInfo_Compile.BeaconVersion _in40 = b;
        dafny.DafnySequence<? extends Token> _in41 = expr;
        java.math.BigInteger _in42 = (pos).add(java.math.BigInteger.ONE);
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in43 = oldValues;
        Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in44 = names;
        DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in45 = keys;
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in46 = newValues;
        dafny.DafnySequence<? extends Token> _in47 = dafny.DafnySequence.<Token>concatenate(acc, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))));
        b = _in40;
        expr = _in41;
        pos = _in42;
        oldValues = _in43;
        names = _in44;
        keys = _in45;
        newValues = _in46;
        acc = _in47;
        continue TAIL_CALL_START;
      }
    }
  }
  public static dafny.DafnySequence<? extends Character> ParsedExprToString(dafny.DafnySequence<? extends Token> t) {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_x = Seq_Compile.__default.<Token, dafny.DafnySequence<? extends Character>>Map(Token._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((java.util.function.Function<Token, dafny.DafnySequence<? extends Character>>)(_1_x_boxed0) -> {
      Token _1_x = ((Token)(java.lang.Object)(_1_x_boxed0));
      return __default.TokenToString(_1_x);
    }), t);
    if ((java.math.BigInteger.valueOf((_0_x).length())).signum() == 0) {
      return dafny.DafnySequence.asString("");
    } else {
      return StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _0_x, dafny.DafnySequence.asString(" "));
    }
  }
  public static boolean IsUnary(Token t) {
    Token _source0 = t;
    if (_source0.is_Attr()) {
      dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._loc;
      return false;
    } else if (_source0.is_Value()) {
      dafny.DafnySequence<? extends Character> _2___mcc_h4 = ((DynamoDBFilterExpr_Compile.Token_Value)_source0)._s;
      return false;
    } else if (_source0.is_Eq()) {
      return false;
    } else if (_source0.is_Ne()) {
      return false;
    } else if (_source0.is_Lt()) {
      return false;
    } else if (_source0.is_Gt()) {
      return false;
    } else if (_source0.is_Le()) {
      return false;
    } else if (_source0.is_Ge()) {
      return false;
    } else if (_source0.is_Between()) {
      return false;
    } else if (_source0.is_In()) {
      return false;
    } else if (_source0.is_Open()) {
      return false;
    } else if (_source0.is_Close()) {
      return false;
    } else if (_source0.is_Comma()) {
      return false;
    } else if (_source0.is_Not()) {
      return true;
    } else if (_source0.is_And()) {
      return false;
    } else if (_source0.is_Or()) {
      return false;
    } else if (_source0.is_AttributeExists()) {
      return false;
    } else if (_source0.is_AttributeNotExists()) {
      return false;
    } else if (_source0.is_AttributeType()) {
      return false;
    } else if (_source0.is_BeginsWith()) {
      return false;
    } else if (_source0.is_Contains()) {
      return false;
    } else {
      return false;
    }
  }
  public static boolean IsComp(Token t) {
    Token _source0 = t;
    if (_source0.is_Attr()) {
      dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._loc;
      return false;
    } else if (_source0.is_Value()) {
      dafny.DafnySequence<? extends Character> _2___mcc_h4 = ((DynamoDBFilterExpr_Compile.Token_Value)_source0)._s;
      return false;
    } else if (_source0.is_Eq()) {
      return true;
    } else if (_source0.is_Ne()) {
      return true;
    } else if (_source0.is_Lt()) {
      return true;
    } else if (_source0.is_Gt()) {
      return true;
    } else if (_source0.is_Le()) {
      return true;
    } else if (_source0.is_Ge()) {
      return true;
    } else if (_source0.is_Between()) {
      return false;
    } else if (_source0.is_In()) {
      return false;
    } else if (_source0.is_Open()) {
      return false;
    } else if (_source0.is_Close()) {
      return false;
    } else if (_source0.is_Comma()) {
      return false;
    } else if (_source0.is_Not()) {
      return false;
    } else if (_source0.is_And()) {
      return false;
    } else if (_source0.is_Or()) {
      return false;
    } else if (_source0.is_AttributeExists()) {
      return false;
    } else if (_source0.is_AttributeNotExists()) {
      return false;
    } else if (_source0.is_AttributeType()) {
      return false;
    } else if (_source0.is_BeginsWith()) {
      return false;
    } else if (_source0.is_Contains()) {
      return false;
    } else {
      return false;
    }
  }
  public static boolean IsBinaryBool(Token t) {
    Token _source0 = t;
    if (_source0.is_Attr()) {
      dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._loc;
      return false;
    } else if (_source0.is_Value()) {
      dafny.DafnySequence<? extends Character> _2___mcc_h4 = ((DynamoDBFilterExpr_Compile.Token_Value)_source0)._s;
      return false;
    } else if (_source0.is_Eq()) {
      return false;
    } else if (_source0.is_Ne()) {
      return false;
    } else if (_source0.is_Lt()) {
      return false;
    } else if (_source0.is_Gt()) {
      return false;
    } else if (_source0.is_Le()) {
      return false;
    } else if (_source0.is_Ge()) {
      return false;
    } else if (_source0.is_Between()) {
      return false;
    } else if (_source0.is_In()) {
      return false;
    } else if (_source0.is_Open()) {
      return false;
    } else if (_source0.is_Close()) {
      return false;
    } else if (_source0.is_Comma()) {
      return false;
    } else if (_source0.is_Not()) {
      return false;
    } else if (_source0.is_And()) {
      return true;
    } else if (_source0.is_Or()) {
      return true;
    } else if (_source0.is_AttributeExists()) {
      return false;
    } else if (_source0.is_AttributeNotExists()) {
      return false;
    } else if (_source0.is_AttributeType()) {
      return false;
    } else if (_source0.is_BeginsWith()) {
      return false;
    } else if (_source0.is_Contains()) {
      return false;
    } else {
      return false;
    }
  }
  public static boolean IsBinary(Token t) {
    return (__default.IsComp(t)) || (__default.IsBinaryBool(t));
  }
  public static boolean IsVar(Token t) {
    Token _source0 = t;
    if (_source0.is_Attr()) {
      dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._loc;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _2_loc = _1___mcc_h1;
      dafny.DafnySequence<? extends Character> _3_s = _0___mcc_h0;
      return true;
    } else if (_source0.is_Value()) {
      dafny.DafnySequence<? extends Character> _4___mcc_h4 = ((DynamoDBFilterExpr_Compile.Token_Value)_source0)._s;
      dafny.DafnySequence<? extends Character> _5_s = _4___mcc_h4;
      return true;
    } else if (_source0.is_Eq()) {
      return false;
    } else if (_source0.is_Ne()) {
      return false;
    } else if (_source0.is_Lt()) {
      return false;
    } else if (_source0.is_Gt()) {
      return false;
    } else if (_source0.is_Le()) {
      return false;
    } else if (_source0.is_Ge()) {
      return false;
    } else if (_source0.is_Between()) {
      return false;
    } else if (_source0.is_In()) {
      return false;
    } else if (_source0.is_Open()) {
      return false;
    } else if (_source0.is_Close()) {
      return false;
    } else if (_source0.is_Comma()) {
      return false;
    } else if (_source0.is_Not()) {
      return false;
    } else if (_source0.is_And()) {
      return false;
    } else if (_source0.is_Or()) {
      return false;
    } else if (_source0.is_AttributeExists()) {
      return false;
    } else if (_source0.is_AttributeNotExists()) {
      return false;
    } else if (_source0.is_AttributeType()) {
      return false;
    } else if (_source0.is_BeginsWith()) {
      return false;
    } else if (_source0.is_Contains()) {
      return false;
    } else {
      return false;
    }
  }
  public static boolean IsFunction(Token t) {
    Token _source0 = t;
    if (_source0.is_Attr()) {
      dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._loc;
      return false;
    } else if (_source0.is_Value()) {
      dafny.DafnySequence<? extends Character> _2___mcc_h4 = ((DynamoDBFilterExpr_Compile.Token_Value)_source0)._s;
      return false;
    } else if (_source0.is_Eq()) {
      return false;
    } else if (_source0.is_Ne()) {
      return false;
    } else if (_source0.is_Lt()) {
      return false;
    } else if (_source0.is_Gt()) {
      return false;
    } else if (_source0.is_Le()) {
      return false;
    } else if (_source0.is_Ge()) {
      return false;
    } else if (_source0.is_Between()) {
      return true;
    } else if (_source0.is_In()) {
      return true;
    } else if (_source0.is_Open()) {
      return false;
    } else if (_source0.is_Close()) {
      return false;
    } else if (_source0.is_Comma()) {
      return false;
    } else if (_source0.is_Not()) {
      return false;
    } else if (_source0.is_And()) {
      return false;
    } else if (_source0.is_Or()) {
      return false;
    } else if (_source0.is_AttributeExists()) {
      return true;
    } else if (_source0.is_AttributeNotExists()) {
      return true;
    } else if (_source0.is_AttributeType()) {
      return true;
    } else if (_source0.is_BeginsWith()) {
      return true;
    } else if (_source0.is_Contains()) {
      return true;
    } else {
      return true;
    }
  }
  public static java.math.BigInteger Precedence(Token t) {
    Token _source0 = t;
    if (_source0.is_Attr()) {
      dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._loc;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _2_loc = _1___mcc_h1;
      dafny.DafnySequence<? extends Character> _3_s = _0___mcc_h0;
      return java.math.BigInteger.valueOf(10L);
    } else if (_source0.is_Value()) {
      dafny.DafnySequence<? extends Character> _4___mcc_h2 = ((DynamoDBFilterExpr_Compile.Token_Value)_source0)._s;
      dafny.DafnySequence<? extends Character> _5_s = _4___mcc_h2;
      return java.math.BigInteger.valueOf(10L);
    } else if (_source0.is_Eq()) {
      return java.math.BigInteger.valueOf(9L);
    } else if (_source0.is_Ne()) {
      return java.math.BigInteger.valueOf(9L);
    } else if (_source0.is_Lt()) {
      return java.math.BigInteger.valueOf(9L);
    } else if (_source0.is_Gt()) {
      return java.math.BigInteger.valueOf(9L);
    } else if (_source0.is_Le()) {
      return java.math.BigInteger.valueOf(9L);
    } else if (_source0.is_Ge()) {
      return java.math.BigInteger.valueOf(9L);
    } else if (_source0.is_Between()) {
      return java.math.BigInteger.valueOf(7L);
    } else if (_source0.is_In()) {
      return java.math.BigInteger.valueOf(8L);
    } else if (_source0.is_Open()) {
      return java.math.BigInteger.valueOf(11L);
    } else if (_source0.is_Close()) {
      return java.math.BigInteger.valueOf(11L);
    } else if (_source0.is_Comma()) {
      return java.math.BigInteger.valueOf(11L);
    } else if (_source0.is_Not()) {
      return java.math.BigInteger.valueOf(5L);
    } else if (_source0.is_And()) {
      return java.math.BigInteger.valueOf(4L);
    } else if (_source0.is_Or()) {
      return java.math.BigInteger.valueOf(3L);
    } else if (_source0.is_AttributeExists()) {
      return java.math.BigInteger.valueOf(6L);
    } else if (_source0.is_AttributeNotExists()) {
      return java.math.BigInteger.valueOf(6L);
    } else if (_source0.is_AttributeType()) {
      return java.math.BigInteger.valueOf(6L);
    } else if (_source0.is_BeginsWith()) {
      return java.math.BigInteger.valueOf(6L);
    } else if (_source0.is_Contains()) {
      return java.math.BigInteger.valueOf(6L);
    } else {
      return java.math.BigInteger.valueOf(6L);
    }
  }
  public static dafny.DafnySequence<? extends Token> ParseExpr(dafny.DafnySequence<? extends Character> s, long pos)
  {
    dafny.DafnySequence<? extends Token> _0___accumulator = dafny.DafnySequence.<Token> empty(Token._typeDescriptor());
    TAIL_CALL_START: while (true) {
      dafny.Tuple2<java.lang.Long, Token> _1_tup = __default.FindIndexToken(s, pos);
      if ((((_1_tup).dtor__0()) == 0 ? 0 : 1) == 1) {
        _0___accumulator = dafny.DafnySequence.<Token>concatenate(_0___accumulator, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), (_1_tup).dtor__1()));
        dafny.DafnySequence<? extends Character> _in0 = s;
        long _in1 = StandardLibrary_mMemoryMath_Compile.__default.Add(pos, (_1_tup).dtor__0());
        s = _in0;
        pos = _in1;
        continue TAIL_CALL_START;
      } else {
        return dafny.DafnySequence.<Token>concatenate(_0___accumulator, dafny.DafnySequence.<Token> empty(Token._typeDescriptor()));
      }
    }
  }
  public static byte ByteLower(byte ch) {
    if ((java.lang.Integer.compareUnsigned(((byte) ('A')), ch) <= 0) && (java.lang.Integer.compareUnsigned(ch, ((byte) ('Z'))) <= 0)) {
      return (byte) (byte) ((byte)(((byte) (byte) ((byte)((ch) - (((byte) ('A')))))) + (((byte) ('a')))));
    } else {
      return ch;
    }
  }
  public static char CharLower(char ch) {
    if ((('A') <= (ch)) && ((ch) <= ('Z'))) {
      return (char) (((char) ((ch) - ('A'))) + ('a'));
    } else {
      return ch;
    }
  }
  public static boolean EqualLower(dafny.DafnySequence<? extends Character> pre, dafny.DafnySequence<? extends Character> s, long pos, long diff)
  {
    TAIL_CALL_START: while (true) {
      if (((long) (pre).cardinalityInt()) == (pos)) {
        return true;
      } else if ((((char)(java.lang.Object)((pre).select(dafny.Helpers.unsignedToInt(pos))))) != (__default.CharLower(((char)(java.lang.Object)((s).select(dafny.Helpers.unsignedToInt((long) (long) ((pos) + (diff))))))))) {
        return false;
      } else {
        dafny.DafnySequence<? extends Character> _in0 = pre;
        dafny.DafnySequence<? extends Character> _in1 = s;
        long _in2 = StandardLibrary_mMemoryMath_Compile.__default.Add(pos, (long) 1L);
        long _in3 = diff;
        pre = _in0;
        s = _in1;
        pos = _in2;
        diff = _in3;
        continue TAIL_CALL_START;
      }
    }
  }
  public static boolean PrefixLower(dafny.DafnySequence<? extends Character> pre, dafny.DafnySequence<? extends Character> s, long pos)
  {
    if (java.lang.Long.compareUnsigned(StandardLibrary_mMemoryMath_Compile.__default.Add(pos, (long) (pre).cardinalityInt()), (long) (s).cardinalityInt()) > 0) {
      return false;
    } else {
      return __default.EqualLower(pre, s, (long) 0L, pos);
    }
  }
  public static boolean ValueChar(char ch) {
    if ((('a') <= (ch)) && ((ch) <= ('z'))) {
      return true;
    } else if ((('A') <= (ch)) && ((ch) <= ('Z'))) {
      return true;
    } else if ((('0') <= (ch)) && ((ch) <= ('9'))) {
      return true;
    } else if ((ch) == ('_')) {
      return true;
    } else {
      return false;
    }
  }
  public static boolean AttributeChar(char ch) {
    if (__default.ValueChar(ch)) {
      return true;
    } else if ((dafny.DafnySequence.<Character> of(':', '[', ']', '.', '#')).contains(ch)) {
      return true;
    } else {
      return false;
    }
  }
  public static long ValueLen(dafny.DafnySequence<? extends Character> s, long pos)
  {
    if ((pos) == ((long) (s).cardinalityInt())) {
      return (long) 0L;
    } else if (__default.ValueChar(((char)(java.lang.Object)((s).select(dafny.Helpers.unsignedToInt(pos)))))) {
      return StandardLibrary_mMemoryMath_Compile.__default.Add(__default.ValueLen(s, StandardLibrary_mMemoryMath_Compile.__default.Add(pos, (long) 1L)), (long) 1L);
    } else {
      return (long) 0L;
    }
  }
  public static long AttributeLen(dafny.DafnySequence<? extends Character> s, long pos)
  {
    if ((pos) == ((long) (s).cardinalityInt())) {
      return (long) 0L;
    } else if (__default.AttributeChar(((char)(java.lang.Object)((s).select(dafny.Helpers.unsignedToInt(pos)))))) {
      return StandardLibrary_mMemoryMath_Compile.__default.Add(__default.AttributeLen(s, StandardLibrary_mMemoryMath_Compile.__default.Add(pos, (long) 1L)), (long) 1L);
    } else {
      return (long) 0L;
    }
  }
  public static Token MakeAttr(dafny.DafnySequence<? extends Character> s) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_loc = TermLoc_Compile.__default.MakeTermLoc(s);
    if ((_0_loc).is_Success()) {
      return Token.create_Attr(s, (_0_loc).dtor_value());
    } else {
      return Token.create_Attr(s, TermLoc_Compile.__default.TermLocMap(s));
    }
  }
  public static dafny.Tuple2<java.lang.Long, Token> FindIndexToken(dafny.DafnySequence<? extends Character> s, long pos)
  {
    if ((pos) == ((long) (s).cardinalityInt())) {
      return dafny.Tuple2.<java.lang.Long, Token>create((long) 0L, Token.create_Close());
    } else {
      char _0_ch = ((char)(java.lang.Object)((s).select(dafny.Helpers.unsignedToInt(pos))));
      long _1_remaining = (long) (long) (((long) (s).cardinalityInt()) - (pos));
      if ((_0_ch) == (' ')) {
        dafny.Tuple2<java.lang.Long, Token> _2_foo = __default.FindIndexToken(s, StandardLibrary_mMemoryMath_Compile.__default.Add(pos, (long) 1L));
        if ((((_2_foo).dtor__0()) == 0 ? 0 : 1) == 0) {
          return dafny.Tuple2.<java.lang.Long, Token>create((_2_foo).dtor__0(), (_2_foo).dtor__1());
        } else {
          return dafny.Tuple2.<java.lang.Long, Token>create(StandardLibrary_mMemoryMath_Compile.__default.Add((_2_foo).dtor__0(), (long) 1L), (_2_foo).dtor__1());
        }
      } else if ((_0_ch) == ('(')) {
        return dafny.Tuple2.<java.lang.Long, Token>create((long) 1L, Token.create_Open());
      } else if ((_0_ch) == (')')) {
        return dafny.Tuple2.<java.lang.Long, Token>create((long) 1L, Token.create_Close());
      } else if ((_0_ch) == (',')) {
        return dafny.Tuple2.<java.lang.Long, Token>create((long) 1L, Token.create_Comma());
      } else if ((_0_ch) == ('=')) {
        return dafny.Tuple2.<java.lang.Long, Token>create((long) 1L, Token.create_Eq());
      } else if ((_0_ch) == ('<')) {
        if ((_1_remaining) == ((long) 1L)) {
          return dafny.Tuple2.<java.lang.Long, Token>create((long) 1L, Token.create_Lt());
        } else if ((((char)(java.lang.Object)((s).select(dafny.Helpers.unsignedToInt((long) (long) ((pos) + ((long) 1L))))))) == ('=')) {
          return dafny.Tuple2.<java.lang.Long, Token>create((long) 2L, Token.create_Le());
        } else if ((((char)(java.lang.Object)((s).select(dafny.Helpers.unsignedToInt((long) (long) ((pos) + ((long) 1L))))))) == ('>')) {
          return dafny.Tuple2.<java.lang.Long, Token>create((long) 2L, Token.create_Ne());
        } else {
          return dafny.Tuple2.<java.lang.Long, Token>create((long) 1L, Token.create_Lt());
        }
      } else if ((_0_ch) == ('>')) {
        if ((_1_remaining) == ((long) 1L)) {
          return dafny.Tuple2.<java.lang.Long, Token>create((long) 1L, Token.create_Gt());
        } else if ((((char)(java.lang.Object)((s).select(dafny.Helpers.unsignedToInt((long) (long) ((pos) + ((long) 1L))))))) == ('=')) {
          return dafny.Tuple2.<java.lang.Long, Token>create((long) 2L, Token.create_Ge());
        } else {
          return dafny.Tuple2.<java.lang.Long, Token>create((long) 1L, Token.create_Gt());
        }
      } else if (__default.PrefixLower(dafny.DafnySequence.asString("in"), s, pos)) {
        return dafny.Tuple2.<java.lang.Long, Token>create((long) 2L, Token.create_In());
      } else if (__default.PrefixLower(dafny.DafnySequence.asString("between"), s, pos)) {
        return dafny.Tuple2.<java.lang.Long, Token>create((long) 7L, Token.create_Between());
      } else if (__default.PrefixLower(dafny.DafnySequence.asString("and"), s, pos)) {
        return dafny.Tuple2.<java.lang.Long, Token>create((long) 3L, Token.create_And());
      } else if (__default.PrefixLower(dafny.DafnySequence.asString("or"), s, pos)) {
        return dafny.Tuple2.<java.lang.Long, Token>create((long) 2L, Token.create_Or());
      } else if (__default.PrefixLower(dafny.DafnySequence.asString("not"), s, pos)) {
        return dafny.Tuple2.<java.lang.Long, Token>create((long) 3L, Token.create_Not());
      } else if (__default.PrefixLower(dafny.DafnySequence.asString("attribute_not_exists"), s, pos)) {
        return dafny.Tuple2.<java.lang.Long, Token>create((long) 20L, Token.create_AttributeNotExists());
      } else if (__default.PrefixLower(dafny.DafnySequence.asString("attribute_type"), s, pos)) {
        return dafny.Tuple2.<java.lang.Long, Token>create((long) 14L, Token.create_AttributeType());
      } else if (__default.PrefixLower(dafny.DafnySequence.asString("begins_with"), s, pos)) {
        return dafny.Tuple2.<java.lang.Long, Token>create((long) 11L, Token.create_BeginsWith());
      } else if (__default.PrefixLower(dafny.DafnySequence.asString("attribute_exists"), s, pos)) {
        return dafny.Tuple2.<java.lang.Long, Token>create((long) 16L, Token.create_AttributeExists());
      } else if (__default.PrefixLower(dafny.DafnySequence.asString("contains"), s, pos)) {
        return dafny.Tuple2.<java.lang.Long, Token>create((long) 8L, Token.create_Contains());
      } else if (__default.PrefixLower(dafny.DafnySequence.asString("size"), s, pos)) {
        return dafny.Tuple2.<java.lang.Long, Token>create((long) 4L, Token.create_Size());
      } else if ((_0_ch) == (':')) {
        long _3_x = StandardLibrary_mMemoryMath_Compile.__default.Add(__default.ValueLen(s, StandardLibrary_mMemoryMath_Compile.__default.Add(pos, (long) 1L)), (long) 1L);
        return dafny.Tuple2.<java.lang.Long, Token>create(_3_x, Token.create_Value((s).subsequence(dafny.Helpers.unsignedToInt(pos), dafny.Helpers.unsignedToInt((long) (long) ((pos) + (_3_x))))));
      } else if ((_0_ch) == ('#')) {
        long _4_x = StandardLibrary_mMemoryMath_Compile.__default.Add(__default.ValueLen(s, StandardLibrary_mMemoryMath_Compile.__default.Add(pos, (long) 1L)), (long) 1L);
        return dafny.Tuple2.<java.lang.Long, Token>create(_4_x, __default.MakeAttr((s).subsequence(dafny.Helpers.unsignedToInt(pos), dafny.Helpers.unsignedToInt((long) (long) ((pos) + (_4_x))))));
      } else {
        long _5_x = __default.AttributeLen(s, pos);
        return dafny.Tuple2.<java.lang.Long, Token>create(_5_x, __default.MakeAttr((s).subsequence(dafny.Helpers.unsignedToInt(pos), dafny.Helpers.unsignedToInt((long) (long) ((pos) + (_5_x))))));
      }
    }
  }
  public static long VarOrSize(dafny.DafnySequence<? extends Token> input, long pos)
  {
    if (((long) (input).cardinalityInt()) == (pos)) {
      return (long) 0L;
    } else if (((((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))).is_Value()) || ((((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))).is_Attr())) {
      return (long) 1L;
    } else if (((((java.lang.Long.compareUnsigned(StandardLibrary_mMemoryMath_Compile.__default.Add((long) 3L, pos), (long) (input).cardinalityInt()) < 0) && ((((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))).is_Size())) && ((((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt((long) (long) ((pos) + ((long) 1L))))))).is_Open())) && (__default.IsVar(((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt((long) (long) ((pos) + ((long) 2L))))))))) && ((((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt((long) (long) ((pos) + ((long) 3L))))))).is_Close())) {
      return (long) 4L;
    } else {
      return (long) 0L;
    }
  }
  public static Wrappers_Compile.Option<dafny.Tuple3<java.lang.Long, java.lang.Long, java.lang.Long>> IsBetween(dafny.DafnySequence<? extends Token> input, long pos)
  {
    long _0_input__size = (long) (input).cardinalityInt();
    if (java.lang.Long.compareUnsigned(_0_input__size, StandardLibrary_mMemoryMath_Compile.__default.Add(pos, (long) 5L)) < 0) {
      return Wrappers_Compile.Option.<dafny.Tuple3<java.lang.Long, java.lang.Long, java.lang.Long>>create_None(dafny.Tuple3.<java.lang.Long, java.lang.Long, java.lang.Long>_typeDescriptor(BoundedInts_Compile.uint64._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
    } else {
      long _1_p1 = __default.VarOrSize(input, pos);
      if (((((_1_p1) == 0 ? 0 : 1) == 1) && (java.lang.Long.compareUnsigned(StandardLibrary_mMemoryMath_Compile.__default.Add((long) (long) ((pos) + (_1_p1)), (long) 1L), _0_input__size) < 0)) && ((((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt((long) (long) ((pos) + (_1_p1))))))).is_Between())) {
        long _2_p2 = __default.VarOrSize(input, (long) (long) (((long) (long) ((pos) + (_1_p1))) + ((long) 1L)));
        if (((((_2_p2) == 0 ? 0 : 1) == 1) && (java.lang.Long.compareUnsigned(StandardLibrary_mMemoryMath_Compile.__default.Add((long) (long) (((long) (long) ((pos) + (_1_p1))) + (_2_p2)), (long) 2L), _0_input__size) < 0)) && ((((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt((long) (long) (((long) (long) (((long) (long) ((pos) + (_1_p1))) + (_2_p2))) + ((long) 1L))))))).is_And())) {
          long _3_p3 = __default.VarOrSize(input, (long) (long) (((long) (long) (((long) (long) ((pos) + (_1_p1))) + (_2_p2))) + ((long) 2L)));
          if (((_3_p3) == 0 ? 0 : 1) == 1) {
            return Wrappers_Compile.Option.<dafny.Tuple3<java.lang.Long, java.lang.Long, java.lang.Long>>create_Some(dafny.Tuple3.<java.lang.Long, java.lang.Long, java.lang.Long>_typeDescriptor(BoundedInts_Compile.uint64._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), dafny.Tuple3.<java.lang.Long, java.lang.Long, java.lang.Long>create(_1_p1, _2_p2, _3_p3));
          } else {
            return Wrappers_Compile.Option.<dafny.Tuple3<java.lang.Long, java.lang.Long, java.lang.Long>>create_None(dafny.Tuple3.<java.lang.Long, java.lang.Long, java.lang.Long>_typeDescriptor(BoundedInts_Compile.uint64._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
          }
        } else {
          return Wrappers_Compile.Option.<dafny.Tuple3<java.lang.Long, java.lang.Long, java.lang.Long>>create_None(dafny.Tuple3.<java.lang.Long, java.lang.Long, java.lang.Long>_typeDescriptor(BoundedInts_Compile.uint64._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
        }
      } else {
        return Wrappers_Compile.Option.<dafny.Tuple3<java.lang.Long, java.lang.Long, java.lang.Long>>create_None(dafny.Tuple3.<java.lang.Long, java.lang.Long, java.lang.Long>_typeDescriptor(BoundedInts_Compile.uint64._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
      }
    }
  }
  public static boolean IsIN(dafny.DafnySequence<? extends Token> input, long pos)
  {
    if (java.lang.Long.compareUnsigned((long) (input).cardinalityInt(), StandardLibrary_mMemoryMath_Compile.__default.Add(pos, (long) 3L)) < 0) {
      return false;
    } else if (!(__default.IsVar(((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))))) {
      return false;
    } else if (!java.util.Objects.equals(((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt((long) (long) ((pos) + ((long) 1L)))))), Token.create_In())) {
      return false;
    } else if (!java.util.Objects.equals(((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt((long) (long) ((pos) + ((long) 2L)))))), Token.create_Open())) {
      return false;
    } else {
      return true;
    }
  }
  public static dafny.DafnySequence<? extends Token> ConvertToPrefix(dafny.DafnySequence<? extends Token> input, long pos)
  {
    dafny.DafnySequence<? extends Token> _0___accumulator = dafny.DafnySequence.<Token> empty(Token._typeDescriptor());
    TAIL_CALL_START: while (true) {
      if (java.lang.Long.compareUnsigned((long) (input).cardinalityInt(), StandardLibrary_mMemoryMath_Compile.__default.Add(pos, (long) 5L)) < 0) {
        return dafny.DafnySequence.<Token>concatenate(_0___accumulator, (input).drop(pos));
      } else if (__default.IsIN(input, pos)) {
        _0___accumulator = dafny.DafnySequence.<Token>concatenate(_0___accumulator, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt((long) (long) ((pos) + ((long) 1L)))))), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt((long) (long) ((pos) + ((long) 2L)))))), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos)))), Token.create_Comma()));
        dafny.DafnySequence<? extends Token> _in0 = input;
        long _in1 = (long) (long) ((pos) + ((long) 3L));
        input = _in0;
        pos = _in1;
        continue TAIL_CALL_START;
      } else {
        Wrappers_Compile.Option<dafny.Tuple3<java.lang.Long, java.lang.Long, java.lang.Long>> _1_between = __default.IsBetween(input, pos);
        if ((_1_between).is_Some()) {
          dafny.Tuple3<java.lang.Long, java.lang.Long, java.lang.Long> _2_b = (_1_between).dtor_value();
          _0___accumulator = dafny.DafnySequence.<Token>concatenate(_0___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token> of(Token._typeDescriptor(), Token.create_Between(), Token.create_Open()), (input).subsequence(dafny.Helpers.unsignedToInt(pos), dafny.Helpers.unsignedToInt((long) (long) ((pos) + ((_2_b).dtor__0()))))), dafny.DafnySequence.<Token> of(Token._typeDescriptor(), Token.create_Comma())), (input).subsequence(dafny.Helpers.unsignedToInt((long) (long) (((long) (long) ((pos) + ((_2_b).dtor__0()))) + ((long) 1L))), dafny.Helpers.unsignedToInt((long) (long) (((long) (long) (((long) (long) ((pos) + ((_2_b).dtor__0()))) + ((_2_b).dtor__1()))) + ((long) 1L))))), dafny.DafnySequence.<Token> of(Token._typeDescriptor(), Token.create_Comma())), (input).subsequence(dafny.Helpers.unsignedToInt((long) (long) (((long) (long) (((long) (long) ((pos) + ((_2_b).dtor__0()))) + ((_2_b).dtor__1()))) + ((long) 2L))), dafny.Helpers.unsignedToInt((long) (long) (((long) (long) (((long) (long) (((long) (long) ((pos) + ((_2_b).dtor__0()))) + ((_2_b).dtor__1()))) + ((_2_b).dtor__2()))) + ((long) 2L))))), dafny.DafnySequence.<Token> of(Token._typeDescriptor(), Token.create_Close())));
          dafny.DafnySequence<? extends Token> _in2 = input;
          long _in3 = (long) (long) (((long) (long) (((long) (long) (((long) (long) ((pos) + ((_2_b).dtor__0()))) + ((_2_b).dtor__1()))) + ((_2_b).dtor__2()))) + ((long) 2L));
          input = _in2;
          pos = _in3;
          continue TAIL_CALL_START;
        } else {
          _0___accumulator = dafny.DafnySequence.<Token>concatenate(_0___accumulator, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
          dafny.DafnySequence<? extends Token> _in4 = input;
          long _in5 = (long) (long) ((pos) + ((long) 1L));
          input = _in4;
          pos = _in5;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static dafny.DafnySequence<? extends Token> ConvertToRpn(dafny.DafnySequence<? extends Token> input) {
    dafny.DafnySequence<? extends Token> _0_stack = dafny.DafnySequence.<Token> empty(Token._typeDescriptor());
    return __default.ConvertToRpn__inner(input, _0_stack, (long) 0L);
  }
  public static dafny.DafnySequence<? extends Token> ConvertToRpn__inner(dafny.DafnySequence<? extends Token> input, dafny.DafnySequence<? extends Token> stack, long pos)
  {
    dafny.DafnySequence<? extends Token> _0___accumulator = dafny.DafnySequence.<Token> empty(Token._typeDescriptor());
    TAIL_CALL_START: while (true) {
      if ((pos) == ((long) (input).cardinalityInt())) {
        if ((java.math.BigInteger.valueOf((stack).length())).signum() == 0) {
          return dafny.DafnySequence.<Token>concatenate(_0___accumulator, dafny.DafnySequence.<Token> empty(Token._typeDescriptor()));
        } else {
          _0___accumulator = dafny.DafnySequence.<Token>concatenate(_0___accumulator, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))));
          dafny.DafnySequence<? extends Token> _in0 = input;
          dafny.DafnySequence<? extends Token> _in1 = (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE));
          long _in2 = pos;
          input = _in0;
          stack = _in1;
          pos = _in2;
          continue TAIL_CALL_START;
        }
      } else {
        Token _source0 = ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))));
        if (_source0.is_Attr()) {
          dafny.DafnySequence<? extends Character> _1___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._s;
          dafny.DafnySequence<? extends TermLoc_Compile.Selector> _2___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._loc;
          dafny.DafnySequence<? extends TermLoc_Compile.Selector> _3_loc = _2___mcc_h1;
          dafny.DafnySequence<? extends Character> _4_s = _1___mcc_h0;
          return dafny.DafnySequence.<Token>concatenate(_0___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))), __default.ConvertToRpn__inner(input, stack, (long) (long) ((pos) + ((long) 1L)))));
        } else if (_source0.is_Value()) {
          dafny.DafnySequence<? extends Character> _5___mcc_h2 = ((DynamoDBFilterExpr_Compile.Token_Value)_source0)._s;
          dafny.DafnySequence<? extends Character> _6_s = _5___mcc_h2;
          return dafny.DafnySequence.<Token>concatenate(_0___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))), __default.ConvertToRpn__inner(input, stack, (long) (long) ((pos) + ((long) 1L)))));
        } else if (_source0.is_Eq()) {
          if ((java.math.BigInteger.valueOf((stack).length())).signum() == 0) {
            dafny.DafnySequence<? extends Token> _in3 = input;
            dafny.DafnySequence<? extends Token> _in4 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
            long _in5 = (long) (long) ((pos) + ((long) 1L));
            input = _in3;
            stack = _in4;
            pos = _in5;
            continue TAIL_CALL_START;
          } else if ((__default.Precedence(((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))))).compareTo(__default.Precedence(((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos)))))) >= 0) {
            return dafny.DafnySequence.<Token>concatenate(_0___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))), __default.ConvertToRpn__inner(input, (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)), pos)));
          } else {
            dafny.DafnySequence<? extends Token> _in6 = input;
            dafny.DafnySequence<? extends Token> _in7 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
            long _in8 = (long) (long) ((pos) + ((long) 1L));
            input = _in6;
            stack = _in7;
            pos = _in8;
            continue TAIL_CALL_START;
          }
        } else if (_source0.is_Ne()) {
          if ((java.math.BigInteger.valueOf((stack).length())).signum() == 0) {
            dafny.DafnySequence<? extends Token> _in9 = input;
            dafny.DafnySequence<? extends Token> _in10 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
            long _in11 = (long) (long) ((pos) + ((long) 1L));
            input = _in9;
            stack = _in10;
            pos = _in11;
            continue TAIL_CALL_START;
          } else if ((__default.Precedence(((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))))).compareTo(__default.Precedence(((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos)))))) >= 0) {
            return dafny.DafnySequence.<Token>concatenate(_0___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))), __default.ConvertToRpn__inner(input, (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)), pos)));
          } else {
            dafny.DafnySequence<? extends Token> _in12 = input;
            dafny.DafnySequence<? extends Token> _in13 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
            long _in14 = (long) (long) ((pos) + ((long) 1L));
            input = _in12;
            stack = _in13;
            pos = _in14;
            continue TAIL_CALL_START;
          }
        } else if (_source0.is_Lt()) {
          if ((java.math.BigInteger.valueOf((stack).length())).signum() == 0) {
            dafny.DafnySequence<? extends Token> _in15 = input;
            dafny.DafnySequence<? extends Token> _in16 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
            long _in17 = (long) (long) ((pos) + ((long) 1L));
            input = _in15;
            stack = _in16;
            pos = _in17;
            continue TAIL_CALL_START;
          } else if ((__default.Precedence(((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))))).compareTo(__default.Precedence(((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos)))))) >= 0) {
            return dafny.DafnySequence.<Token>concatenate(_0___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))), __default.ConvertToRpn__inner(input, (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)), pos)));
          } else {
            dafny.DafnySequence<? extends Token> _in18 = input;
            dafny.DafnySequence<? extends Token> _in19 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
            long _in20 = (long) (long) ((pos) + ((long) 1L));
            input = _in18;
            stack = _in19;
            pos = _in20;
            continue TAIL_CALL_START;
          }
        } else if (_source0.is_Gt()) {
          if ((java.math.BigInteger.valueOf((stack).length())).signum() == 0) {
            dafny.DafnySequence<? extends Token> _in21 = input;
            dafny.DafnySequence<? extends Token> _in22 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
            long _in23 = (long) (long) ((pos) + ((long) 1L));
            input = _in21;
            stack = _in22;
            pos = _in23;
            continue TAIL_CALL_START;
          } else if ((__default.Precedence(((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))))).compareTo(__default.Precedence(((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos)))))) >= 0) {
            return dafny.DafnySequence.<Token>concatenate(_0___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))), __default.ConvertToRpn__inner(input, (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)), pos)));
          } else {
            dafny.DafnySequence<? extends Token> _in24 = input;
            dafny.DafnySequence<? extends Token> _in25 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
            long _in26 = (long) (long) ((pos) + ((long) 1L));
            input = _in24;
            stack = _in25;
            pos = _in26;
            continue TAIL_CALL_START;
          }
        } else if (_source0.is_Le()) {
          if ((java.math.BigInteger.valueOf((stack).length())).signum() == 0) {
            dafny.DafnySequence<? extends Token> _in27 = input;
            dafny.DafnySequence<? extends Token> _in28 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
            long _in29 = (long) (long) ((pos) + ((long) 1L));
            input = _in27;
            stack = _in28;
            pos = _in29;
            continue TAIL_CALL_START;
          } else if ((__default.Precedence(((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))))).compareTo(__default.Precedence(((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos)))))) >= 0) {
            return dafny.DafnySequence.<Token>concatenate(_0___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))), __default.ConvertToRpn__inner(input, (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)), pos)));
          } else {
            dafny.DafnySequence<? extends Token> _in30 = input;
            dafny.DafnySequence<? extends Token> _in31 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
            long _in32 = (long) (long) ((pos) + ((long) 1L));
            input = _in30;
            stack = _in31;
            pos = _in32;
            continue TAIL_CALL_START;
          }
        } else if (_source0.is_Ge()) {
          if ((java.math.BigInteger.valueOf((stack).length())).signum() == 0) {
            dafny.DafnySequence<? extends Token> _in33 = input;
            dafny.DafnySequence<? extends Token> _in34 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
            long _in35 = (long) (long) ((pos) + ((long) 1L));
            input = _in33;
            stack = _in34;
            pos = _in35;
            continue TAIL_CALL_START;
          } else if ((__default.Precedence(((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))))).compareTo(__default.Precedence(((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos)))))) >= 0) {
            return dafny.DafnySequence.<Token>concatenate(_0___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))), __default.ConvertToRpn__inner(input, (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)), pos)));
          } else {
            dafny.DafnySequence<? extends Token> _in36 = input;
            dafny.DafnySequence<? extends Token> _in37 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
            long _in38 = (long) (long) ((pos) + ((long) 1L));
            input = _in36;
            stack = _in37;
            pos = _in38;
            continue TAIL_CALL_START;
          }
        } else if (_source0.is_Between()) {
          dafny.DafnySequence<? extends Token> _in39 = input;
          dafny.DafnySequence<? extends Token> _in40 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
          long _in41 = (long) (long) ((pos) + ((long) 1L));
          input = _in39;
          stack = _in40;
          pos = _in41;
          continue TAIL_CALL_START;
        } else if (_source0.is_In()) {
          dafny.DafnySequence<? extends Token> _in42 = input;
          dafny.DafnySequence<? extends Token> _in43 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
          long _in44 = (long) (long) ((pos) + ((long) 1L));
          input = _in42;
          stack = _in43;
          pos = _in44;
          continue TAIL_CALL_START;
        } else if (_source0.is_Open()) {
          dafny.DafnySequence<? extends Token> _in45 = input;
          dafny.DafnySequence<? extends Token> _in46 = stack;
          long _in47 = (long) (long) ((pos) + ((long) 1L));
          input = _in45;
          stack = _in46;
          pos = _in47;
          continue TAIL_CALL_START;
        } else if (_source0.is_Close()) {
          if ((java.math.BigInteger.valueOf((stack).length())).signum() == 0) {
            dafny.DafnySequence<? extends Token> _in48 = input;
            dafny.DafnySequence<? extends Token> _in49 = stack;
            long _in50 = (long) (long) ((pos) + ((long) 1L));
            input = _in48;
            stack = _in49;
            pos = _in50;
            continue TAIL_CALL_START;
          } else if (java.util.Objects.equals(((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))), Token.create_Open())) {
            dafny.DafnySequence<? extends Token> _in51 = input;
            dafny.DafnySequence<? extends Token> _in52 = (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE));
            long _in53 = (long) (long) ((pos) + ((long) 1L));
            input = _in51;
            stack = _in52;
            pos = _in53;
            continue TAIL_CALL_START;
          } else {
            return dafny.DafnySequence.<Token>concatenate(_0___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))), __default.ConvertToRpn__inner(input, (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)), (long) (long) ((pos) + ((long) 1L)))));
          }
        } else if (_source0.is_Comma()) {
          if ((java.math.BigInteger.valueOf((stack).length())).signum() == 1) {
            if (__default.IsFunction(((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))))) {
              dafny.DafnySequence<? extends Token> _in54 = input;
              dafny.DafnySequence<? extends Token> _in55 = stack;
              long _in56 = (long) (long) ((pos) + ((long) 1L));
              input = _in54;
              stack = _in55;
              pos = _in56;
              continue TAIL_CALL_START;
            } else {
              return dafny.DafnySequence.<Token>concatenate(_0___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))), __default.ConvertToRpn__inner(input, (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)), (long) (long) ((pos) + ((long) 1L)))));
            }
          } else {
            dafny.DafnySequence<? extends Token> _in57 = input;
            dafny.DafnySequence<? extends Token> _in58 = stack;
            long _in59 = (long) (long) ((pos) + ((long) 1L));
            input = _in57;
            stack = _in58;
            pos = _in59;
            continue TAIL_CALL_START;
          }
        } else if (_source0.is_Not()) {
          dafny.DafnySequence<? extends Token> _in60 = input;
          dafny.DafnySequence<? extends Token> _in61 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
          long _in62 = (long) (long) ((pos) + ((long) 1L));
          input = _in60;
          stack = _in61;
          pos = _in62;
          continue TAIL_CALL_START;
        } else if (_source0.is_And()) {
          if ((java.math.BigInteger.valueOf((stack).length())).signum() == 0) {
            dafny.DafnySequence<? extends Token> _in63 = input;
            dafny.DafnySequence<? extends Token> _in64 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
            long _in65 = (long) (long) ((pos) + ((long) 1L));
            input = _in63;
            stack = _in64;
            pos = _in65;
            continue TAIL_CALL_START;
          } else if ((__default.Precedence(((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))))).compareTo(__default.Precedence(((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos)))))) >= 0) {
            return dafny.DafnySequence.<Token>concatenate(_0___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))), __default.ConvertToRpn__inner(input, (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)), pos)));
          } else {
            dafny.DafnySequence<? extends Token> _in66 = input;
            dafny.DafnySequence<? extends Token> _in67 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
            long _in68 = (long) (long) ((pos) + ((long) 1L));
            input = _in66;
            stack = _in67;
            pos = _in68;
            continue TAIL_CALL_START;
          }
        } else if (_source0.is_Or()) {
          if ((java.math.BigInteger.valueOf((stack).length())).signum() == 0) {
            dafny.DafnySequence<? extends Token> _in69 = input;
            dafny.DafnySequence<? extends Token> _in70 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
            long _in71 = (long) (long) ((pos) + ((long) 1L));
            input = _in69;
            stack = _in70;
            pos = _in71;
            continue TAIL_CALL_START;
          } else if ((__default.Precedence(((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))))).compareTo(__default.Precedence(((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos)))))) >= 0) {
            return dafny.DafnySequence.<Token>concatenate(_0___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))), __default.ConvertToRpn__inner(input, (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)), pos)));
          } else {
            dafny.DafnySequence<? extends Token> _in72 = input;
            dafny.DafnySequence<? extends Token> _in73 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
            long _in74 = (long) (long) ((pos) + ((long) 1L));
            input = _in72;
            stack = _in73;
            pos = _in74;
            continue TAIL_CALL_START;
          }
        } else if (_source0.is_AttributeExists()) {
          dafny.DafnySequence<? extends Token> _in75 = input;
          dafny.DafnySequence<? extends Token> _in76 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
          long _in77 = (long) (long) ((pos) + ((long) 1L));
          input = _in75;
          stack = _in76;
          pos = _in77;
          continue TAIL_CALL_START;
        } else if (_source0.is_AttributeNotExists()) {
          dafny.DafnySequence<? extends Token> _in78 = input;
          dafny.DafnySequence<? extends Token> _in79 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
          long _in80 = (long) (long) ((pos) + ((long) 1L));
          input = _in78;
          stack = _in79;
          pos = _in80;
          continue TAIL_CALL_START;
        } else if (_source0.is_AttributeType()) {
          dafny.DafnySequence<? extends Token> _in81 = input;
          dafny.DafnySequence<? extends Token> _in82 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
          long _in83 = (long) (long) ((pos) + ((long) 1L));
          input = _in81;
          stack = _in82;
          pos = _in83;
          continue TAIL_CALL_START;
        } else if (_source0.is_BeginsWith()) {
          dafny.DafnySequence<? extends Token> _in84 = input;
          dafny.DafnySequence<? extends Token> _in85 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
          long _in86 = (long) (long) ((pos) + ((long) 1L));
          input = _in84;
          stack = _in85;
          pos = _in86;
          continue TAIL_CALL_START;
        } else if (_source0.is_Contains()) {
          dafny.DafnySequence<? extends Token> _in87 = input;
          dafny.DafnySequence<? extends Token> _in88 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
          long _in89 = (long) (long) ((pos) + ((long) 1L));
          input = _in87;
          stack = _in88;
          pos = _in89;
          continue TAIL_CALL_START;
        } else {
          dafny.DafnySequence<? extends Token> _in90 = input;
          dafny.DafnySequence<? extends Token> _in91 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.<Token> of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))));
          long _in92 = (long) (long) ((pos) + ((long) 1L));
          input = _in90;
          stack = _in91;
          pos = _in92;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static java.math.BigInteger GetSize(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue value) {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _source0 = value;
    if (_source0.is_S()) {
      dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_S)_source0)._S;
      dafny.DafnySequence<? extends Character> _1_s = _0___mcc_h0;
      return java.math.BigInteger.valueOf((_1_s).length());
    } else if (_source0.is_N()) {
      dafny.DafnySequence<? extends Character> _2___mcc_h1 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_N)_source0)._N;
      dafny.DafnySequence<? extends Character> _3_n = _2___mcc_h1;
      return java.math.BigInteger.valueOf((_3_n).length());
    } else if (_source0.is_B()) {
      dafny.DafnySequence<? extends java.lang.Byte> _4___mcc_h2 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_B)_source0)._B;
      dafny.DafnySequence<? extends java.lang.Byte> _5_n = _4___mcc_h2;
      return java.math.BigInteger.valueOf((_5_n).length());
    } else if (_source0.is_SS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _6___mcc_h3 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_SS)_source0)._SS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _7_n = _6___mcc_h3;
      return java.math.BigInteger.valueOf((_7_n).length());
    } else if (_source0.is_NS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _8___mcc_h4 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_NS)_source0)._NS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _9_n = _8___mcc_h4;
      return java.math.BigInteger.valueOf((_9_n).length());
    } else if (_source0.is_BS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _10___mcc_h5 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_BS)_source0)._BS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _11_n = _10___mcc_h5;
      return java.math.BigInteger.valueOf((_11_n).length());
    } else if (_source0.is_M()) {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _12___mcc_h6 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_M)_source0)._M;
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _13_n = _12___mcc_h6;
      return java.math.BigInteger.valueOf((_13_n).size());
    } else if (_source0.is_L()) {
      dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _14___mcc_h7 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_L)_source0)._L;
      dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _15_n = _14___mcc_h7;
      return java.math.BigInteger.valueOf((_15_n).length());
    } else if (_source0.is_NULL()) {
      boolean _16___mcc_h8 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_NULL)_source0)._NULL;
      boolean _17_n = _16___mcc_h8;
      return java.math.BigInteger.ONE;
    } else {
      boolean _18___mcc_h9 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_BOOL)_source0)._BOOL;
      boolean _19_n = _18___mcc_h9;
      return java.math.BigInteger.ONE;
    }
  }
  public static software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue GetStr(StackValue s) {
    StackValue _source0 = s;
    if (_source0.is_Bool()) {
      boolean _0___mcc_h0 = ((DynamoDBFilterExpr_Compile.StackValue_Bool)_source0)._b;
      boolean _1_b = _0___mcc_h0;
      return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NULL(true);
    } else if (_source0.is_Str()) {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _2___mcc_h1 = ((DynamoDBFilterExpr_Compile.StackValue_Str)_source0)._s;
      software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _3_s = _2___mcc_h1;
      return _3_s;
    } else {
      return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NULL(true);
    }
  }
  public static StackValue AsStr(dafny.DafnySequence<? extends Character> s) {
    return StackValue.create_Str(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(s));
  }
  public static StackValue StackValueFromValue(dafny.DafnySequence<? extends Character> s, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> values)
  {
    if ((values).<dafny.DafnySequence<? extends Character>>contains(s)) {
      return StackValue.create_Str(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((values).get(s))));
    } else {
      return StackValue.create_DoesNotExist();
    }
  }
  public static StackValue StackValueFromItem(dafny.DafnySequence<? extends Character> s, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item)
  {
    if ((item).<dafny.DafnySequence<? extends Character>>contains(s)) {
      return StackValue.create_Str(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((item).get(s))));
    } else {
      return StackValue.create_DoesNotExist();
    }
  }
  public static StackValue StackValueFromAttr(Token t, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names)
  {
    if (((names).is_Some()) && (((names).dtor_value()).<dafny.DafnySequence<? extends Character>>contains((t).dtor_s()))) {
      return __default.StackValueFromItem(((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((names).dtor_value()).get((t).dtor_s()))), item);
    } else {
      Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _0_attr = TermLoc_Compile.__default.TermToAttr((t).dtor_loc(), item, names);
      if ((_0_attr).is_Some()) {
        return StackValue.create_Str((_0_attr).dtor_value());
      } else {
        return StackValue.create_DoesNotExist();
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Token>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetParsedExpr(dafny.DafnySequence<? extends Character> input) {
    dafny.DafnySequence<? extends Token> _0_seq1 = __default.ParseExpr(input, (long) 0L);
    dafny.DafnySequence<? extends Token> _1_seq2 = __default.ConvertToPrefix(_0_seq1, (long) 0L);
    return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Token>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<Token>_typeDescriptor(Token._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), __default.ConvertToRpn(_1_seq2));
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> EvalExpr(dafny.DafnySequence<? extends Token> input, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> values)
  {
    Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> ret = Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), false);
    if(true) {
      Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
      _out0 = __default.InnerEvalExpr(input, dafny.DafnySequence.<StackValue> empty(StackValue._typeDescriptor()), item, names, values, (long) 0L);
      ret = _out0;
    }
    return ret;
  }
  public static java.math.BigInteger StringsFollowing(dafny.DafnySequence<? extends StackValue> input) {
    java.math.BigInteger _0___accumulator = java.math.BigInteger.ZERO;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((input).length())).signum() == 0) {
        return (java.math.BigInteger.ZERO).add(_0___accumulator);
      } else if (!((((StackValue)(java.lang.Object)((input).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((input).length())).subtract(java.math.BigInteger.ONE))))))).is_Str())) {
        return (java.math.BigInteger.ZERO).add(_0___accumulator);
      } else {
        _0___accumulator = (_0___accumulator).add(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends StackValue> _in0 = (input).take((java.math.BigInteger.valueOf((input).length())).subtract(java.math.BigInteger.ONE));
        input = _in0;
        continue TAIL_CALL_START;
      }
    }
  }
  public static <__T> boolean seq__contains(dafny.TypeDescriptor<__T> _td___T, dafny.DafnySequence<? extends __T> haystack, dafny.DafnySequence<? extends __T> needle)
  {
    boolean ret = false;
    Wrappers_Compile.Option<java.math.BigInteger> _0_result;
    Wrappers_Compile.Option<java.math.BigInteger> _out0;
    _out0 = StandardLibrary_mString_Compile.__default.<__T>HasSubString(_td___T, haystack, needle);
    _0_result = _out0;
    ret = (_0_result).is_Some();
    return ret;
  }
  public static boolean does__contain(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue haystack, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue needle)
  {
    boolean ret = false;
    if(true) {
      software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _source0 = haystack;
      if (_source0.is_S()) {
        dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_S)_source0)._S;
        dafny.DafnySequence<? extends Character> _1_s = _0___mcc_h0;
        if ((needle).is_S()) {
          boolean _out0;
          _out0 = __default.<Character>seq__contains(dafny.TypeDescriptor.CHAR, (haystack).dtor_S(), (needle).dtor_S());
          ret = _out0;
        } else {
          ret = false;
          return ret;
        }
      } else if (_source0.is_N()) {
        dafny.DafnySequence<? extends Character> _2___mcc_h2 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_N)_source0)._N;
        dafny.DafnySequence<? extends Character> _3_n = _2___mcc_h2;
        if ((needle).is_N()) {
          boolean _out1;
          _out1 = __default.<Character>seq__contains(dafny.TypeDescriptor.CHAR, (haystack).dtor_N(), (needle).dtor_N());
          ret = _out1;
        } else {
          ret = false;
          return ret;
        }
      } else if (_source0.is_B()) {
        dafny.DafnySequence<? extends java.lang.Byte> _4___mcc_h4 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_B)_source0)._B;
        dafny.DafnySequence<? extends java.lang.Byte> _5_n = _4___mcc_h4;
        if ((needle).is_B()) {
          boolean _out2;
          _out2 = __default.<java.lang.Byte>seq__contains(BoundedInts_Compile.uint8._typeDescriptor(), (haystack).dtor_B(), (needle).dtor_B());
          ret = _out2;
        } else {
          ret = false;
          return ret;
        }
      } else if (_source0.is_SS()) {
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _6___mcc_h6 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_SS)_source0)._SS;
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _7_s = _6___mcc_h6;
        if ((needle).is_S()) {
          ret = ((haystack).dtor_SS()).contains((needle).dtor_S());
          return ret;
        } else {
          ret = false;
          return ret;
        }
      } else if (_source0.is_NS()) {
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _8___mcc_h8 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_NS)_source0)._NS;
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _9_s = _8___mcc_h8;
        if ((needle).is_N()) {
          ret = ((haystack).dtor_NS()).contains((needle).dtor_N());
          return ret;
        } else {
          ret = false;
          return ret;
        }
      } else if (_source0.is_BS()) {
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _10___mcc_h10 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_BS)_source0)._BS;
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _11_s = _10___mcc_h10;
        if ((needle).is_B()) {
          ret = ((haystack).dtor_BS()).contains((needle).dtor_B());
          return ret;
        } else {
          ret = false;
          return ret;
        }
      } else if (_source0.is_M()) {
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _12___mcc_h12 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_M)_source0)._M;
        ret = false;
        return ret;
      } else if (_source0.is_L()) {
        dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _13___mcc_h14 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_L)_source0)._L;
        dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _14_list = _13___mcc_h14;
        ret = (_14_list).contains(needle);
        return ret;
      } else if (_source0.is_NULL()) {
        boolean _15___mcc_h16 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_NULL)_source0)._NULL;
        ret = false;
        return ret;
      } else {
        boolean _16___mcc_h18 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_BOOL)_source0)._BOOL;
        ret = false;
        return ret;
      }
    }
    return ret;
  }
  public static boolean begins__with(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue haystack, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue needle)
  {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _source0 = haystack;
    if (_source0.is_S()) {
      dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_S)_source0)._S;
      dafny.DafnySequence<? extends Character> _1_s = _0___mcc_h0;
      if ((needle).is_S()) {
        return ((needle).dtor_S()).isPrefixOf((haystack).dtor_S());
      } else {
        return false;
      }
    } else if (_source0.is_N()) {
      dafny.DafnySequence<? extends Character> _2___mcc_h2 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_N)_source0)._N;
      dafny.DafnySequence<? extends Character> _3_n = _2___mcc_h2;
      if ((needle).is_N()) {
        return ((needle).dtor_N()).isPrefixOf((haystack).dtor_N());
      } else {
        return false;
      }
    } else if (_source0.is_B()) {
      dafny.DafnySequence<? extends java.lang.Byte> _4___mcc_h4 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_B)_source0)._B;
      dafny.DafnySequence<? extends java.lang.Byte> _5_n = _4___mcc_h4;
      if ((needle).is_B()) {
        return ((needle).dtor_B()).isPrefixOf((haystack).dtor_B());
      } else {
        return false;
      }
    } else if (_source0.is_SS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _6___mcc_h6 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_SS)_source0)._SS;
      return false;
    } else if (_source0.is_NS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _7___mcc_h8 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_NS)_source0)._NS;
      return false;
    } else if (_source0.is_BS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _8___mcc_h10 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_BS)_source0)._BS;
      return false;
    } else if (_source0.is_M()) {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _9___mcc_h12 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_M)_source0)._M;
      return false;
    } else if (_source0.is_L()) {
      dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _10___mcc_h14 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_L)_source0)._L;
      dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _11_list = _10___mcc_h14;
      if ((java.math.BigInteger.valueOf((_11_list).length())).signum() == 0) {
        return false;
      } else if (java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_11_list).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), needle)) {
        return true;
      } else if ((needle).is_L()) {
        return ((needle).dtor_L()).isPrefixOf(_11_list);
      } else {
        return false;
      }
    } else if (_source0.is_NULL()) {
      boolean _12___mcc_h16 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_NULL)_source0)._NULL;
      return false;
    } else {
      boolean _13___mcc_h18 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_BOOL)_source0)._BOOL;
      return false;
    }
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> is__between(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue middle, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue left, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue right)
  {
    Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = __default.AttributeLE(left, middle);
    if ((_0_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
    } else {
      boolean _1_leftRet = (_0_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError1 = __default.AttributeLE(middle, right);
      if ((_2_valueOrError1).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_2_valueOrError1).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      } else {
        boolean _3_rightRet = (_2_valueOrError1).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (_1_leftRet) && (_3_rightRet));
      }
    }
  }
  public static boolean is__in(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue target, dafny.DafnySequence<? extends StackValue> list, long pos)
  {
    TAIL_CALL_START: while (true) {
      if (((long) (list).cardinalityInt()) == (pos)) {
        return false;
      } else if (java.util.Objects.equals(__default.GetStr(((StackValue)(java.lang.Object)((list).select(dafny.Helpers.unsignedToInt(pos))))), target)) {
        return true;
      } else {
        software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _in0 = target;
        dafny.DafnySequence<? extends StackValue> _in1 = list;
        long _in2 = (long) (long) ((pos) + ((long) 1L));
        target = _in0;
        list = _in1;
        pos = _in2;
        continue TAIL_CALL_START;
      }
    }
  }
  public static dafny.DafnySequence<? extends Character> AttrToStr(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue attr) {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _source0 = attr;
    if (_source0.is_S()) {
      dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_S)_source0)._S;
      dafny.DafnySequence<? extends Character> _1_s = _0___mcc_h0;
      return _1_s;
    } else if (_source0.is_N()) {
      dafny.DafnySequence<? extends Character> _2___mcc_h2 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_N)_source0)._N;
      dafny.DafnySequence<? extends Character> _3_n = _2___mcc_h2;
      return _3_n;
    } else if (_source0.is_B()) {
      dafny.DafnySequence<? extends java.lang.Byte> _4___mcc_h4 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_B)_source0)._B;
      return dafny.DafnySequence.asString("");
    } else if (_source0.is_SS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _5___mcc_h6 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_SS)_source0)._SS;
      return dafny.DafnySequence.asString("");
    } else if (_source0.is_NS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _6___mcc_h8 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_NS)_source0)._NS;
      return dafny.DafnySequence.asString("");
    } else if (_source0.is_BS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _7___mcc_h10 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_BS)_source0)._BS;
      return dafny.DafnySequence.asString("");
    } else if (_source0.is_M()) {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _8___mcc_h12 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_M)_source0)._M;
      return dafny.DafnySequence.asString("");
    } else if (_source0.is_L()) {
      dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _9___mcc_h14 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_L)_source0)._L;
      return dafny.DafnySequence.asString("");
    } else if (_source0.is_NULL()) {
      boolean _10___mcc_h16 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_NULL)_source0)._NULL;
      return dafny.DafnySequence.asString("");
    } else {
      boolean _11___mcc_h18 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_BOOL)_source0)._BOOL;
      return dafny.DafnySequence.asString("");
    }
  }
  public static boolean IsAttrType(StackValue attr, StackValue typeStr)
  {
    return (DynamoDbEncryptionUtil_Compile.__default.AttrTypeToStr(__default.GetStr(attr))).equals(__default.AttrToStr(__default.GetStr(typeStr)));
  }
  public static Wrappers_Compile.Result<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> apply__function(Token input, dafny.DafnySequence<? extends StackValue> stack, java.math.BigInteger num__args)
  {
    Wrappers_Compile.Result<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.Default());
    if(true) {
      Token _source0 = input;
      if (_source0.is_Attr()) {
        dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._s;
        dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._loc;
        result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(true));
        return result;
      } else if (_source0.is_Value()) {
        dafny.DafnySequence<? extends Character> _2___mcc_h4 = ((DynamoDBFilterExpr_Compile.Token_Value)_source0)._s;
        result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(true));
        return result;
      } else if (_source0.is_Eq()) {
        result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(true));
        return result;
      } else if (_source0.is_Ne()) {
        result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(true));
        return result;
      } else if (_source0.is_Lt()) {
        result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(true));
        return result;
      } else if (_source0.is_Gt()) {
        result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(true));
        return result;
      } else if (_source0.is_Le()) {
        result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(true));
        return result;
      } else if (_source0.is_Ge()) {
        result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(true));
        return result;
      } else if (_source0.is_Between()) {
        if ((java.math.BigInteger.valueOf((stack).length())).compareTo(java.math.BigInteger.valueOf(3L)) < 0) {
          result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("No Stack for Between")));
          return result;
        } else if ((((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))).is_Str()) && ((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.valueOf(2L)))))))).is_Str())) && ((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.valueOf(3L)))))))).is_Str())) {
          Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError0 = Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), false);
          _3_valueOrError0 = __default.is__between((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.valueOf(3L)))))))).dtor_s(), (((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.valueOf(2L)))))))).dtor_s(), (((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))).dtor_s());
          if ((_3_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            result = (_3_valueOrError0).<StackValue>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue._typeDescriptor());
            return result;
          }
          boolean _4_ret;
          _4_ret = (_3_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(_4_ret));
          return result;
        } else {
          result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Wrong Types for Between")));
          return result;
        }
      } else if (_source0.is_In()) {
        java.math.BigInteger _5_num = java.math.BigInteger.ZERO;
        _5_num = __default.StringsFollowing(stack);
        if ((java.math.BigInteger.valueOf((stack).length())).compareTo(_5_num) < 0) {
          result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Tautology False")));
          return result;
        } else if ((_5_num).signum() == 0) {
          result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("In has no args")));
          return result;
        } else {
          result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(__default.is__in(__default.GetStr(((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(_5_num))))))), (stack).drop(((java.math.BigInteger.valueOf((stack).length())).subtract(_5_num)).add(java.math.BigInteger.ONE)), (long) 0L)));
          return result;
        }
      } else if (_source0.is_Open()) {
        result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(true));
        return result;
      } else if (_source0.is_Close()) {
        result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(true));
        return result;
      } else if (_source0.is_Comma()) {
        result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(true));
        return result;
      } else if (_source0.is_Not()) {
        result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(true));
        return result;
      } else if (_source0.is_And()) {
        result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(true));
        return result;
      } else if (_source0.is_Or()) {
        result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(true));
        return result;
      } else if (_source0.is_AttributeExists()) {
        if ((java.math.BigInteger.valueOf((stack).length())).compareTo(java.math.BigInteger.ONE) < 0) {
          result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("No Stack for AttributeExists")));
          return result;
        } else {
          result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(!((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))).is_DoesNotExist())));
          return result;
        }
      } else if (_source0.is_AttributeNotExists()) {
        if ((java.math.BigInteger.valueOf((stack).length())).compareTo(java.math.BigInteger.ONE) < 0) {
          result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("No Stack for AttributeExists")));
          return result;
        } else {
          result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))).is_DoesNotExist()));
          return result;
        }
      } else if (_source0.is_AttributeType()) {
        if ((java.math.BigInteger.valueOf((stack).length())).compareTo(java.math.BigInteger.valueOf(2L)) < 0) {
          result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("No Stack for AttributeType")));
          return result;
        } else {
          result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(__default.IsAttrType(((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.valueOf(2L))))))), ((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))))));
          return result;
        }
      } else if (_source0.is_BeginsWith()) {
        if ((java.math.BigInteger.valueOf((stack).length())).compareTo(java.math.BigInteger.valueOf(2L)) < 0) {
          result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("No Stack for BeginsWith")));
          return result;
        } else if (((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))).is_Str()) && ((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.valueOf(2L)))))))).is_Str())) {
          result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(__default.begins__with((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.valueOf(2L)))))))).dtor_s(), (((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))).dtor_s())));
          return result;
        } else {
          result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Wrong Types for BeginsWith")));
          return result;
        }
      } else if (_source0.is_Contains()) {
        if ((java.math.BigInteger.valueOf((stack).length())).compareTo(java.math.BigInteger.valueOf(2L)) < 0) {
          result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("No Stack for contains")));
          return result;
        } else if (((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))).is_Str()) && ((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.valueOf(2L)))))))).is_Str())) {
          boolean _6_xxx;
          boolean _out0;
          _out0 = __default.does__contain((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.valueOf(2L)))))))).dtor_s(), (((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))).dtor_s());
          _6_xxx = _out0;
          result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(_6_xxx));
          return result;
        } else {
          result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Wrong Types for contains")));
          return result;
        }
      } else {
        if ((java.math.BigInteger.valueOf((stack).length())).compareTo(java.math.BigInteger.ONE) < 0) {
          result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("No Stack for Size")));
          return result;
        } else if (!((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))).is_Str())) {
          result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Wrong Types for Size")));
          return result;
        } else {
          java.math.BigInteger _7_n = java.math.BigInteger.ZERO;
          _7_n = __default.GetSize((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))).dtor_s());
          result = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Str(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(StandardLibrary_mString_Compile.__default.Base10Int2String(_7_n))));
          return result;
        }
      }
    }
    return result;
  }
  public static Wrappers_Compile.Result<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> apply__unary(Token input, StackValue stack)
  {
    if ((stack).is_Bool()) {
      return Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(!((stack).dtor_b())));
    } else {
      return Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("wrong type for Not")));
    }
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> apply__binary__bool(Token input, boolean x, boolean y)
  {
    Token _source0 = input;
    if (_source0.is_Attr()) {
      dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._loc;
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_Value()) {
      dafny.DafnySequence<? extends Character> _2___mcc_h4 = ((DynamoDBFilterExpr_Compile.Token_Value)_source0)._s;
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_Eq()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_Ne()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_Lt()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_Gt()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_Le()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_Ge()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_Between()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_In()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_Open()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_Close()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_Comma()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_Not()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_And()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (x) && (y));
    } else if (_source0.is_Or()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (x) || (y));
    } else if (_source0.is_AttributeExists()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_AttributeNotExists()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_AttributeType()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_BeginsWith()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_Contains()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    }
  }
  public static boolean IsHighSurrogate(char ch) {
    return (((char)dafny.Helpers.toInt((java.math.BigInteger.valueOf(55296L)))) <= (ch)) && ((ch) <= ((char)dafny.Helpers.toInt((java.math.BigInteger.valueOf(56319L)))));
  }
  public static boolean UnicodeLess(dafny.DafnySequence<? extends Character> a, dafny.DafnySequence<? extends Character> b, java.math.BigInteger pos)
  {
    TAIL_CALL_START: while (true) {
      if ((java.util.Objects.equals(java.math.BigInteger.valueOf((a).length()), pos)) && (java.util.Objects.equals(java.math.BigInteger.valueOf((b).length()), pos))) {
        return false;
      } else if (java.util.Objects.equals(java.math.BigInteger.valueOf((a).length()), pos)) {
        return true;
      } else if (java.util.Objects.equals(java.math.BigInteger.valueOf((b).length()), pos)) {
        return false;
      } else if ((((char)(java.lang.Object)((a).select(dafny.Helpers.toInt((pos)))))) == (((char)(java.lang.Object)((b).select(dafny.Helpers.toInt((pos))))))) {
        dafny.DafnySequence<? extends Character> _in0 = a;
        dafny.DafnySequence<? extends Character> _in1 = b;
        java.math.BigInteger _in2 = (pos).add(java.math.BigInteger.ONE);
        a = _in0;
        b = _in1;
        pos = _in2;
        continue TAIL_CALL_START;
      } else {
        boolean _0_aIsHighSurrogate = __default.IsHighSurrogate(((char)(java.lang.Object)((a).select(dafny.Helpers.toInt((pos))))));
        boolean _1_bIsHighSurrogate = __default.IsHighSurrogate(((char)(java.lang.Object)((b).select(dafny.Helpers.toInt((pos))))));
        if ((_0_aIsHighSurrogate) == (_1_bIsHighSurrogate)) {
          return (((char)(java.lang.Object)((a).select(dafny.Helpers.toInt((pos)))))) < (((char)(java.lang.Object)((b).select(dafny.Helpers.toInt((pos))))));
        } else {
          return _1_bIsHighSurrogate;
        }
      }
    }
  }
  public static boolean UnicodeLessOrEqual(dafny.DafnySequence<? extends Character> a, dafny.DafnySequence<? extends Character> b)
  {
    return !(__default.UnicodeLess(b, a, java.math.BigInteger.ZERO));
  }
  public static Wrappers_Compile.Result<java.lang.Byte, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> CompareFloat(dafny.DafnySequence<? extends Character> x, dafny.DafnySequence<? extends Character> y)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = (DynamoDbNormalizeNumber_Compile.__default.NormalizeNumber(x)).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_1_e_boxed0) -> {
      dafny.DafnySequence<? extends Character> _1_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_1_e_boxed0));
      return DynamoDbEncryptionUtil_Compile.__default.E(_1_e);
    }));
    if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<java.lang.Byte>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), FloatCompare_Compile.CompareType._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends Character> _2_newX = (_0_valueOrError0).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError1 = (DynamoDbNormalizeNumber_Compile.__default.NormalizeNumber(y)).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_4_e_boxed0) -> {
        dafny.DafnySequence<? extends Character> _4_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_4_e_boxed0));
        return DynamoDbEncryptionUtil_Compile.__default.E(_4_e);
      }));
      if ((_3_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_3_valueOrError1).<java.lang.Byte>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), FloatCompare_Compile.CompareType._typeDescriptor());
      } else {
        dafny.DafnySequence<? extends Character> _5_newY = (_3_valueOrError1).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<java.lang.Byte, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(FloatCompare_Compile.CompareType._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), FloatCompare_Compile.__default.CompareFloat(_2_newX, _5_newY));
      }
    }
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> AttributeEQ(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue a, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue b)
  {
    if (((a).is_N()) && ((b).is_N())) {
      Wrappers_Compile.Result<java.lang.Byte, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = __default.CompareFloat((a).dtor_N(), (b).dtor_N());
      if ((_0_valueOrError0).IsFailure(FloatCompare_Compile.CompareType._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_0_valueOrError0).<Boolean>PropagateFailure(FloatCompare_Compile.CompareType._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      } else {
        byte _1_ret = (_0_valueOrError0).Extract(FloatCompare_Compile.CompareType._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), java.lang.Integer.signum((_1_ret)) == 0);
      }
    } else {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), java.util.Objects.equals(a, b));
    }
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> AttributeNE(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue a, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue b)
  {
    Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = __default.AttributeEQ(a, b);
    if ((_0_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
    } else {
      boolean _1_ret = (_0_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), !(_1_ret));
    }
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> AttributeLE(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue a, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue b)
  {
    if (((a).is_N()) && ((b).is_N())) {
      Wrappers_Compile.Result<java.lang.Byte, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = __default.CompareFloat((a).dtor_N(), (b).dtor_N());
      if ((_0_valueOrError0).IsFailure(FloatCompare_Compile.CompareType._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_0_valueOrError0).<Boolean>PropagateFailure(FloatCompare_Compile.CompareType._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      } else {
        byte _1_ret = (_0_valueOrError0).Extract(FloatCompare_Compile.CompareType._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), java.lang.Integer.signum((_1_ret)) != 1);
      }
    } else if (((a).is_S()) && ((b).is_S())) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), __default.UnicodeLessOrEqual((a).dtor_S(), (b).dtor_S()));
    } else if (((a).is_B()) && ((b).is_B())) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StandardLibrary_Compile.__default.<java.lang.Byte>LexicographicLessOrEqual(BoundedInts_Compile.uint8._typeDescriptor(), (a).dtor_B(), (b).dtor_B(), DynamoDbEncryptionUtil_Compile.__default::ByteLess));
    } else {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), false);
    }
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> AttributeLT(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue a, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue b)
  {
    Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = __default.AttributeLE(b, a);
    if ((_0_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
    } else {
      boolean _1_ret = (_0_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), !(_1_ret));
    }
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> AttributeGT(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue a, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue b)
  {
    Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = __default.AttributeLE(a, b);
    if ((_0_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
    } else {
      boolean _1_ret = (_0_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), !(_1_ret));
    }
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> AttributeGE(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue a, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue b)
  {
    Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = __default.AttributeLE(b, a);
    if ((_0_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
    } else {
      boolean _1_ret = (_0_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), _1_ret);
    }
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> apply__binary__comp(Token input, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue x, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue y)
  {
    Token _source0 = input;
    if (_source0.is_Attr()) {
      dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._loc;
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_Value()) {
      dafny.DafnySequence<? extends Character> _2___mcc_h4 = ((DynamoDBFilterExpr_Compile.Token_Value)_source0)._s;
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_Eq()) {
      return __default.AttributeEQ(x, y);
    } else if (_source0.is_Ne()) {
      return __default.AttributeNE(x, y);
    } else if (_source0.is_Lt()) {
      return __default.AttributeLT(x, y);
    } else if (_source0.is_Gt()) {
      return __default.AttributeGT(x, y);
    } else if (_source0.is_Le()) {
      return __default.AttributeLE(x, y);
    } else if (_source0.is_Ge()) {
      return __default.AttributeGE(x, y);
    } else if (_source0.is_Between()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_In()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_Open()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_Close()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_Comma()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_Not()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_And()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_Or()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_AttributeExists()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_AttributeNotExists()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_AttributeType()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_BeginsWith()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source0.is_Contains()) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    }
  }
  public static Wrappers_Compile.Result<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> apply__binary(Token input, StackValue x, StackValue y)
  {
    if (__default.IsComp(input)) {
      if (((x).is_Str()) && ((y).is_Str())) {
        Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = __default.apply__binary__comp(input, (x).dtor_s(), (y).dtor_s());
        if ((_0_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_0_valueOrError0).<StackValue>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue._typeDescriptor());
        } else {
          boolean _1_val = (_0_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          return Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(_1_val));
        }
      } else {
        return Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("wrong types for comparison")));
      }
    } else if (((x).is_Bool()) && ((y).is_Bool())) {
      Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError1 = __default.apply__binary__bool(input, (x).dtor_b(), (y).dtor_b());
      if ((_2_valueOrError1).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_2_valueOrError1).<StackValue>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue._typeDescriptor());
      } else {
        boolean _3_val = (_2_valueOrError1).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.create_Bool(_3_val));
      }
    } else {
      return Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("wrong types for boolean binary")));
    }
  }
  public static java.math.BigInteger NumArgs(Token t, dafny.DafnySequence<? extends StackValue> stack)
  {
    Token _source0 = t;
    if (_source0.is_Attr()) {
      dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source0)._loc;
      return java.math.BigInteger.ZERO;
    } else if (_source0.is_Value()) {
      dafny.DafnySequence<? extends Character> _2___mcc_h4 = ((DynamoDBFilterExpr_Compile.Token_Value)_source0)._s;
      return java.math.BigInteger.ZERO;
    } else if (_source0.is_Eq()) {
      return java.math.BigInteger.ZERO;
    } else if (_source0.is_Ne()) {
      return java.math.BigInteger.ZERO;
    } else if (_source0.is_Lt()) {
      return java.math.BigInteger.ZERO;
    } else if (_source0.is_Gt()) {
      return java.math.BigInteger.ZERO;
    } else if (_source0.is_Le()) {
      return java.math.BigInteger.ZERO;
    } else if (_source0.is_Ge()) {
      return java.math.BigInteger.ZERO;
    } else if (_source0.is_Between()) {
      return java.math.BigInteger.valueOf(3L);
    } else if (_source0.is_In()) {
      return __default.StringsFollowing(stack);
    } else if (_source0.is_Open()) {
      return java.math.BigInteger.ZERO;
    } else if (_source0.is_Close()) {
      return java.math.BigInteger.ZERO;
    } else if (_source0.is_Comma()) {
      return java.math.BigInteger.ZERO;
    } else if (_source0.is_Not()) {
      return java.math.BigInteger.ZERO;
    } else if (_source0.is_And()) {
      return java.math.BigInteger.ZERO;
    } else if (_source0.is_Or()) {
      return java.math.BigInteger.ZERO;
    } else if (_source0.is_AttributeExists()) {
      return java.math.BigInteger.ONE;
    } else if (_source0.is_AttributeNotExists()) {
      return java.math.BigInteger.ONE;
    } else if (_source0.is_AttributeType()) {
      return java.math.BigInteger.valueOf(2L);
    } else if (_source0.is_BeginsWith()) {
      return java.math.BigInteger.valueOf(2L);
    } else if (_source0.is_Contains()) {
      return java.math.BigInteger.valueOf(2L);
    } else {
      return java.math.BigInteger.ONE;
    }
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> InnerEvalExpr(dafny.DafnySequence<? extends Token> input, dafny.DafnySequence<? extends StackValue> stack, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> values, long pos)
  {
    Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> ret = Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), false);
    if(true) {
      if ((pos) == ((long) (input).cardinalityInt())) {
        if ((java.util.Objects.equals(java.math.BigInteger.ONE, java.math.BigInteger.valueOf((stack).length()))) && ((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).is_Bool())) {
          ret = Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_b());
          return ret;
        } else {
          ret = Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("ended with bad stack")));
          return ret;
        }
      } else {
        Token _0_t;
        _0_t = ((Token)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))));
        if ((_0_t).is_Value()) {
          Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
          _out0 = __default.InnerEvalExpr(input, dafny.DafnySequence.<StackValue>concatenate(stack, dafny.DafnySequence.<StackValue> of(StackValue._typeDescriptor(), __default.StackValueFromValue((_0_t).dtor_s(), values))), item, names, values, (long) (long) ((pos) + ((long) 1L)));
          ret = _out0;
        } else if ((_0_t).is_Attr()) {
          Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
          _out1 = __default.InnerEvalExpr(input, dafny.DafnySequence.<StackValue>concatenate(stack, dafny.DafnySequence.<StackValue> of(StackValue._typeDescriptor(), __default.StackValueFromAttr(_0_t, item, names))), item, names, values, (long) (long) ((pos) + ((long) 1L)));
          ret = _out1;
        } else if (__default.IsUnary(_0_t)) {
          if ((java.math.BigInteger.valueOf((stack).length())).signum() == 0) {
            ret = Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Empty stack for unary op")));
          } else {
            Wrappers_Compile.Result<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError0 = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.Default());
            _1_valueOrError0 = __default.apply__unary(_0_t, ((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))));
            if ((_1_valueOrError0).IsFailure(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
              ret = (_1_valueOrError0).<Boolean>PropagateFailure(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
              return ret;
            }
            StackValue _2_val;
            _2_val = (_1_valueOrError0).Extract(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
            Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
            _out2 = __default.InnerEvalExpr(input, dafny.DafnySequence.<StackValue>concatenate((stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)), dafny.DafnySequence.<StackValue> of(StackValue._typeDescriptor(), _2_val)), item, names, values, (long) (long) ((pos) + ((long) 1L)));
            ret = _out2;
          }
        } else if (__default.IsBinary(_0_t)) {
          if ((java.math.BigInteger.valueOf((stack).length())).compareTo(java.math.BigInteger.valueOf(2L)) < 0) {
            ret = Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Empty stack for binary op")));
          } else {
            Wrappers_Compile.Result<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError1 = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.Default());
            _3_valueOrError1 = __default.apply__binary(_0_t, ((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.valueOf(2L))))))), ((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))));
            if ((_3_valueOrError1).IsFailure(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
              ret = (_3_valueOrError1).<Boolean>PropagateFailure(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
              return ret;
            }
            StackValue _4_val;
            _4_val = (_3_valueOrError1).Extract(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
            Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out3;
            _out3 = __default.InnerEvalExpr(input, dafny.DafnySequence.<StackValue>concatenate((stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.valueOf(2L))), dafny.DafnySequence.<StackValue> of(StackValue._typeDescriptor(), _4_val)), item, names, values, (long) (long) ((pos) + ((long) 1L)));
            ret = _out3;
          }
        } else if (__default.IsFunction(_0_t)) {
          java.math.BigInteger _5_num__args = java.math.BigInteger.ZERO;
          _5_num__args = __default.NumArgs(_0_t, stack);
          if ((java.math.BigInteger.valueOf((stack).length())).compareTo(_5_num__args) < 0) {
            ret = Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Empty stack for function call")));
          } else {
            Wrappers_Compile.Result<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_valueOrError2 = Wrappers_Compile.Result.<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StackValue.Default());
            Wrappers_Compile.Result<StackValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out4;
            _out4 = __default.apply__function(_0_t, stack, _5_num__args);
            _6_valueOrError2 = _out4;
            if ((_6_valueOrError2).IsFailure(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
              ret = (_6_valueOrError2).<Boolean>PropagateFailure(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
              return ret;
            }
            StackValue _7_val;
            _7_val = (_6_valueOrError2).Extract(StackValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
            Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out5;
            _out5 = __default.InnerEvalExpr(input, dafny.DafnySequence.<StackValue>concatenate((stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(_5_num__args)), dafny.DafnySequence.<StackValue> of(StackValue._typeDescriptor(), _7_val)), item, names, values, (long) (long) ((pos) + ((long) 1L)));
            ret = _out5;
          }
        } else {
          ret = Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
        }
      }
    }
    return ret;
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> FilterItems(SearchableEncryptionInfo_Compile.BeaconVersion b, dafny.DafnySequence<? extends Token> parsed, dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> ItemList, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> values)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> empty(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())));
    dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _0_acc;
    _0_acc = dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> empty(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
    java.math.BigInteger _hi0 = java.math.BigInteger.valueOf((ItemList).length());
    for (java.math.BigInteger _1_i = java.math.BigInteger.ZERO; _1_i.compareTo(_hi0) < 0; _1_i = _1_i.add(java.math.BigInteger.ONE)) {
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
      _out0 = (b).GeneratePlainBeacons(((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>)(java.lang.Object)((ItemList).select(dafny.Helpers.toInt((_1_i))))));
      _2_valueOrError0 = _out0;
      if ((_2_valueOrError0).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_2_valueOrError0).<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())));
        return output;
      }
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _3_newAttrs;
      _3_newAttrs = (_2_valueOrError0).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError1 = Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), false);
      Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
      _out1 = __default.EvalExpr(parsed, dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>merge(((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>)(java.lang.Object)((ItemList).select(dafny.Helpers.toInt((_1_i))))), _3_newAttrs), names, values);
      _4_valueOrError1 = _out1;
      if ((_4_valueOrError1).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_4_valueOrError1).<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())));
        return output;
      }
      boolean _5_doesMatch;
      _5_doesMatch = (_4_valueOrError1).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      if (_5_doesMatch) {
        _0_acc = dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>concatenate(_0_acc, dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> of(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), ((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>)(java.lang.Object)((ItemList).select(dafny.Helpers.toInt((_1_i)))))));
      }
    }
    output = Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), _0_acc);
    return output;
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> FilterResults(SearchableEncryptionInfo_Compile.BeaconVersion b, dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> ItemList, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> KeyExpression, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> FilterExpression, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> values)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> empty(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())));
    if(true) {
      if (((java.math.BigInteger.valueOf((ItemList).length())).signum() == 0) || (((KeyExpression).is_None()) && ((FilterExpression).is_None()))) {
        output = Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ItemList);
        return output;
      } else {
        dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _0_afterKeys = dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> empty(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
        if ((KeyExpression).is_Some()) {
          dafny.DafnySequence<? extends Token> _1_parsed;
          _1_parsed = __default.ParseExpr((KeyExpression).dtor_value(), (long) 0L);
          Wrappers_Compile.Result<ParsedContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError0 = Wrappers_Compile.Result.<ParsedContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(ParsedContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ParsedContext.Default());
          _2_valueOrError0 = __default.BeaconizeParsedExpr(b, _1_parsed, java.math.BigInteger.ZERO, (values).UnwrapOr(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements()), names, DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_DontUseKeys(), dafny.DafnyMap.fromElements(), dafny.DafnySequence.<Token> empty(Token._typeDescriptor()));
          if ((_2_valueOrError0).IsFailure(ParsedContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            output = (_2_valueOrError0).<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>PropagateFailure(ParsedContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())));
            return output;
          }
          ParsedContext _3_expr;
          _3_expr = (_2_valueOrError0).Extract(ParsedContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          dafny.DafnySequence<? extends Token> _4_expr1;
          _4_expr1 = __default.ConvertToPrefix((_3_expr).dtor_expr(), (long) 0L);
          dafny.DafnySequence<? extends Token> _5_expr2;
          _5_expr2 = __default.ConvertToRpn(_4_expr1);
          Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> empty(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())));
          Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
          _out0 = __default.FilterItems(b, _5_expr2, ItemList, (_3_expr).dtor_names(), (_3_expr).dtor_values());
          _6_valueOrError1 = _out0;
          if ((_6_valueOrError1).IsFailure(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            output = (_6_valueOrError1).<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>PropagateFailure(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())));
            return output;
          }
          _0_afterKeys = (_6_valueOrError1).Extract(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        } else {
          _0_afterKeys = ItemList;
        }
        if ((FilterExpression).is_Some()) {
          dafny.DafnySequence<? extends Token> _7_parsed;
          _7_parsed = __default.ParseExpr((FilterExpression).dtor_value(), (long) 0L);
          Wrappers_Compile.Result<ParsedContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _8_valueOrError2 = Wrappers_Compile.Result.<ParsedContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(ParsedContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ParsedContext.Default());
          _8_valueOrError2 = __default.BeaconizeParsedExpr(b, _7_parsed, java.math.BigInteger.ZERO, (values).UnwrapOr(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements()), names, DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_DontUseKeys(), dafny.DafnyMap.fromElements(), dafny.DafnySequence.<Token> empty(Token._typeDescriptor()));
          if ((_8_valueOrError2).IsFailure(ParsedContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            output = (_8_valueOrError2).<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>PropagateFailure(ParsedContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())));
            return output;
          }
          ParsedContext _9_expr;
          _9_expr = (_8_valueOrError2).Extract(ParsedContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          dafny.DafnySequence<? extends Token> _10_expr1;
          _10_expr1 = __default.ConvertToPrefix((_9_expr).dtor_expr(), (long) 0L);
          dafny.DafnySequence<? extends Token> _11_expr2;
          _11_expr2 = __default.ConvertToRpn(_10_expr1);
          Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
          _out1 = __default.FilterItems(b, _11_expr2, _0_afterKeys, (_9_expr).dtor_names(), (_9_expr).dtor_values());
          output = _out1;
        } else {
          output = Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), _0_afterKeys);
          return output;
        }
      }
    }
    return output;
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> KeyIdFromPart(SearchableEncryptionInfo_Compile.BeaconVersion bv, dafny.DafnySequence<? extends Character> keyIdField, dafny.DafnySequence<? extends Character> attr, dafny.DafnySequence<? extends Character> value)
  {
    if ((!((bv).dtor_beacons()).<dafny.DafnySequence<? extends Character>>contains(attr)) || ((((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)(((bv).dtor_beacons()).get(attr)))).is_Standard())) {
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    } else {
      dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> _0_parts = ((((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)(((bv).dtor_beacons()).get(attr)))).dtor_cmp()).dtor_parts();
      dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> _1_theParts = Seq_Compile.__default.<CompoundBeacon_Compile.BeaconPart>Filter(CompoundBeacon_Compile.BeaconPart._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, java.util.function.Function<CompoundBeacon_Compile.BeaconPart, Boolean>>)(_2_keyIdField) -> ((java.util.function.Function<CompoundBeacon_Compile.BeaconPart, Boolean>)(_3_p_boxed0) -> {
        CompoundBeacon_Compile.BeaconPart _3_p = ((CompoundBeacon_Compile.BeaconPart)(java.lang.Object)(_3_p_boxed0));
        return ((_3_p).is_Signed()) && (((((TermLoc_Compile.Selector)(java.lang.Object)(((_3_p).dtor_loc()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key()).equals(_2_keyIdField));
      })).apply(keyIdField), _0_parts);
      if (!java.util.Objects.equals(java.math.BigInteger.valueOf((_1_theParts).length()), java.math.BigInteger.ONE)) {
        return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      } else {
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _4_pieces = StandardLibrary_Compile.__default.<Character>Split(dafny.TypeDescriptor.CHAR, value, ((((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)(((bv).dtor_beacons()).get(attr)))).dtor_cmp()).dtor_split());
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _5_piece = Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>Filter(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((java.util.function.Function<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>, java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>>)(_6_theParts) -> ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>)(_7_s_boxed0) -> {
          dafny.DafnySequence<? extends Character> _7_s = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_7_s_boxed0));
          return ((((CompoundBeacon_Compile.BeaconPart)(java.lang.Object)((_6_theParts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_prefix()).isPrefixOf(_7_s);
        })).apply(_1_theParts), _4_pieces);
        if (!java.util.Objects.equals(java.math.BigInteger.valueOf((_5_piece).length()), java.math.BigInteger.ONE)) {
          return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        } else {
          dafny.DafnySequence<? extends Character> _8_p = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_5_piece).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))));
          return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (_8_p).drop(java.math.BigInteger.valueOf(((((CompoundBeacon_Compile.BeaconPart)(java.lang.Object)((_1_theParts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_prefix()).length())));
        }
      }
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> KeyIdFromAttr(SearchableEncryptionInfo_Compile.BeaconVersion bv, Wrappers_Compile.Option<Token> attr, dafny.DafnySequence<? extends Character> value, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names)
  {
    if ((attr).is_None()) {
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    } else {
      dafny.DafnySequence<? extends Character> _0_name = ((((names).is_Some()) && (((names).dtor_value()).<dafny.DafnySequence<? extends Character>>contains(((attr).dtor_value()).dtor_s()))) ? (((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((names).dtor_value()).get(((attr).dtor_value()).dtor_s())))) : (((attr).dtor_value()).dtor_s()));
      dafny.DafnySequence<? extends Character> _1_keyIdField = (((bv).dtor_keySource()).dtor_keyLoc()).dtor_keyName();
      if ((_1_keyIdField).equals(_0_name)) {
        return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), value);
      } else {
        return __default.KeyIdFromPart(bv, _1_keyIdField, ((attr).dtor_value()).dtor_s(), value);
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetBeaconKeyIds2(java.math.BigInteger pos, SearchableEncryptionInfo_Compile.BeaconVersion bv, dafny.DafnySequence<? extends Token> expr, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> values, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> soFar)
  {
    TAIL_CALL_START: while (true) {
      if (java.util.Objects.equals(pos, java.math.BigInteger.valueOf((expr).length()))) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), soFar);
      } else if ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).is_Value()) {
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (values).<dafny.DafnySequence<? extends Character>>contains((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).dtor_s()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).dtor_s(), dafny.DafnySequence.asString(" not found in ExpressionAttributeValueMap"))));
        if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_0_valueOrError0).<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
        } else {
          software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _1_oldValue = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((values).get((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).dtor_s())));
          if ((_1_oldValue).is_S()) {
            Wrappers_Compile.Option<Token> _2_attr = __default.AttrForValue(expr, pos);
            Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _3_keyId = __default.KeyIdFromAttr(bv, _2_attr, (_1_oldValue).dtor_S(), names);
            if (((_3_keyId).is_None()) || ((soFar).contains((_3_keyId).dtor_value()))) {
              java.math.BigInteger _in0 = (pos).add(java.math.BigInteger.ONE);
              SearchableEncryptionInfo_Compile.BeaconVersion _in1 = bv;
              dafny.DafnySequence<? extends Token> _in2 = expr;
              dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in3 = values;
              Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in4 = names;
              dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in5 = soFar;
              pos = _in0;
              bv = _in1;
              expr = _in2;
              values = _in3;
              names = _in4;
              soFar = _in5;
              continue TAIL_CALL_START;
            } else {
              java.math.BigInteger _in6 = (pos).add(java.math.BigInteger.ONE);
              SearchableEncryptionInfo_Compile.BeaconVersion _in7 = bv;
              dafny.DafnySequence<? extends Token> _in8 = expr;
              dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in9 = values;
              Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in10 = names;
              dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in11 = dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(soFar, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (_3_keyId).dtor_value()));
              pos = _in6;
              bv = _in7;
              expr = _in8;
              values = _in9;
              names = _in10;
              soFar = _in11;
              continue TAIL_CALL_START;
            }
          } else {
            java.math.BigInteger _in12 = (pos).add(java.math.BigInteger.ONE);
            SearchableEncryptionInfo_Compile.BeaconVersion _in13 = bv;
            dafny.DafnySequence<? extends Token> _in14 = expr;
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in15 = values;
            Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in16 = names;
            dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in17 = soFar;
            pos = _in12;
            bv = _in13;
            expr = _in14;
            values = _in15;
            names = _in16;
            soFar = _in17;
            continue TAIL_CALL_START;
          }
        }
      } else {
        java.math.BigInteger _in18 = (pos).add(java.math.BigInteger.ONE);
        SearchableEncryptionInfo_Compile.BeaconVersion _in19 = bv;
        dafny.DafnySequence<? extends Token> _in20 = expr;
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in21 = values;
        Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in22 = names;
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in23 = soFar;
        pos = _in18;
        bv = _in19;
        expr = _in20;
        values = _in21;
        names = _in22;
        soFar = _in23;
        continue TAIL_CALL_START;
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetBeaconKeyIds(SearchableEncryptionInfo_Compile.BeaconVersion bv, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> expr, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> values, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> soFar)
  {
    if ((expr).is_None()) {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), soFar);
    } else {
      dafny.DafnySequence<? extends Token> _0_parsed = __default.ParseExpr((expr).dtor_value(), (long) 0L);
      return __default.GetBeaconKeyIds2(java.math.BigInteger.ZERO, bv, _0_parsed, values, names, soFar);
    }
  }
  public static Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyId, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetBeaconKeyId(SearchableEncryptionInfo_Compile.BeaconVersion bv, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> keyExpr, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> filterExpr, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> values, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names)
  {
    if (!((((bv).dtor_keySource()).dtor_keyLoc()).is_MultiLoc())) {
      return Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyId, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    } else if ((values).is_None()) {
      return Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyId, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_ShouldHaveKeyId());
    } else {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = __default.GetBeaconKeyIds(bv, keyExpr, (values).dtor_value(), names, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
      if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_0_valueOrError0).<DynamoDbEncryptionUtil_Compile.MaybeKeyId>PropagateFailure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor());
      } else {
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1_soFar = (_0_valueOrError0).Extract(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError1 = __default.GetBeaconKeyIds(bv, filterExpr, (values).dtor_value(), names, _1_soFar);
        if ((_2_valueOrError1).IsFailure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_2_valueOrError1).<DynamoDbEncryptionUtil_Compile.MaybeKeyId>PropagateFailure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor());
        } else {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _3_final = (_2_valueOrError1).Extract(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          if (java.util.Objects.equals(java.math.BigInteger.valueOf((_3_final).length()), java.math.BigInteger.ONE)) {
            return Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyId, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_KeyId(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_3_final).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
          } else if ((java.math.BigInteger.valueOf((_3_final).length())).signum() == 0) {
            return Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyId, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_ShouldHaveKeyId());
          } else {
            return Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyId, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Multiple values found for "), (((bv).dtor_keySource()).dtor_keyLoc()).dtor_keyName()), dafny.DafnySequence.asString(" in query : ")), StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _3_final, dafny.DafnySequence.asString(", ")))));
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> Beaconize(SearchableEncryptionInfo_Compile.BeaconVersion b, ExprContext context, DynamoDbEncryptionUtil_Compile.MaybeKeyId keyId, boolean naked)
  {
    Wrappers_Compile.Result<ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ExprContext.Default());
    if(true) {
      if ((((context).dtor_keyExpr()).is_None()) && (((context).dtor_filterExpr()).is_None())) {
        output = Wrappers_Compile.Result.<ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), context);
        return output;
      } else {
        DynamoDbEncryptionUtil_Compile.MaybeKeyMap _0_keys;
        _0_keys = DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_DontUseKeys();
        if (!(naked)) {
          Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError0 = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyMap.Default());
          Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
          _out0 = (b).getKeyMap(keyId);
          _1_valueOrError0 = _out0;
          if ((_1_valueOrError0).IsFailure(DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            output = (_1_valueOrError0).<ExprContext>PropagateFailure(DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ExprContext._typeDescriptor());
            return output;
          }
          _0_keys = (_1_valueOrError0).Extract(DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        }
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _2_values;
        if (((context).dtor_values()).is_Some()) {
          _2_values = ((context).dtor_values()).dtor_value();
        } else {
          _2_values = dafny.DafnyMap.fromElements();
        }
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _3_newValues;
        _3_newValues = dafny.DafnyMap.fromElements();
        Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _4_newKeyExpr;
        _4_newKeyExpr = (context).dtor_keyExpr();
        Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _5_newFilterExpr;
        _5_newFilterExpr = (context).dtor_filterExpr();
        Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _6_newNames;
        _6_newNames = (context).dtor_names();
        if (((context).dtor_keyExpr()).is_Some()) {
          dafny.DafnySequence<? extends Token> _7_parsed;
          _7_parsed = __default.ParseExpr(((context).dtor_keyExpr()).dtor_value(), (long) 0L);
          Wrappers_Compile.Result<ParsedContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _8_valueOrError1 = Wrappers_Compile.Result.<ParsedContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(ParsedContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ParsedContext.Default());
          _8_valueOrError1 = __default.BeaconizeParsedExpr(b, _7_parsed, java.math.BigInteger.ZERO, _2_values, _6_newNames, _0_keys, _3_newValues, dafny.DafnySequence.<Token> empty(Token._typeDescriptor()));
          if ((_8_valueOrError1).IsFailure(ParsedContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            output = (_8_valueOrError1).<ExprContext>PropagateFailure(ParsedContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ExprContext._typeDescriptor());
            return output;
          }
          ParsedContext _9_newContext;
          _9_newContext = (_8_valueOrError1).Extract(ParsedContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          _4_newKeyExpr = Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), __default.ParsedExprToString((_9_newContext).dtor_expr()));
          _3_newValues = (_9_newContext).dtor_values();
          _6_newNames = (_9_newContext).dtor_names();
        }
        if (((context).dtor_filterExpr()).is_Some()) {
          dafny.DafnySequence<? extends Token> _10_parsed;
          _10_parsed = __default.ParseExpr(((context).dtor_filterExpr()).dtor_value(), (long) 0L);
          Wrappers_Compile.Result<ParsedContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _11_valueOrError2 = Wrappers_Compile.Result.<ParsedContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(ParsedContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ParsedContext.Default());
          _11_valueOrError2 = __default.BeaconizeParsedExpr(b, _10_parsed, java.math.BigInteger.ZERO, _2_values, _6_newNames, _0_keys, _3_newValues, dafny.DafnySequence.<Token> empty(Token._typeDescriptor()));
          if ((_11_valueOrError2).IsFailure(ParsedContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            output = (_11_valueOrError2).<ExprContext>PropagateFailure(ParsedContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ExprContext._typeDescriptor());
            return output;
          }
          ParsedContext _12_newContext;
          _12_newContext = (_11_valueOrError2).Extract(ParsedContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          _5_newFilterExpr = Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), __default.ParsedExprToString((_12_newContext).dtor_expr()));
          _3_newValues = (_12_newContext).dtor_values();
          _6_newNames = (_12_newContext).dtor_names();
        }
        output = Wrappers_Compile.Result.<ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ExprContext.create(_4_newKeyExpr, _5_newFilterExpr, (((java.math.BigInteger.valueOf((_3_newValues).size())).signum() == 0) ? (Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_None(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()))) : (Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), _3_newValues))), _6_newNames));
        return output;
      }
    }
    return output;
  }
  public static dafny.DafnySequence<? extends Character> GetAttrName(Token t, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names)
  {
    if (((names).is_Some()) && (((names).dtor_value()).<dafny.DafnySequence<? extends Character>>contains((t).dtor_s()))) {
      return ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((names).dtor_value()).get((t).dtor_s())));
    } else {
      return (t).dtor_s();
    }
  }
  public static Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> TestParsedExpr(dafny.DafnySequence<? extends Token> expr, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> encrypted, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names)
  {
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    java.math.BigInteger _hi0 = java.math.BigInteger.valueOf((expr).length());
    for (java.math.BigInteger _0_i = java.math.BigInteger.ZERO; _0_i.compareTo(_hi0) < 0; _0_i = _0_i.add(java.math.BigInteger.ONE)) {
      if ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((_0_i)))))).is_Attr()) {
        dafny.DafnySequence<? extends Character> _1_name;
        _1_name = __default.GetAttrName(((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((_0_i))))), names);
        if ((encrypted).<dafny.DafnySequence<? extends Character>>contains(_1_name)) {
          output = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Fail(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Query is using encrypted field : "), _1_name), dafny.DafnySequence.asString("."))));
          return output;
        }
      }
    }
    output = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Pass(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    return output;
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> TestBeaconize(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> actions, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> keyExpr, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> filterExpr, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names)
  {
    Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), false);
    dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _0_encrypted;
    _0_encrypted = ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(_1_actions) -> ((dafny.Function0<dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(() -> {
      java.util.ArrayList<dafny.DafnySequence<? extends Character>> _coll0 = new java.util.ArrayList<>();
      for (dafny.DafnySequence<? extends Character> _compr_0_boxed0 : (_1_actions).keySet().Elements()) {
        dafny.DafnySequence<? extends Character> _compr_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_0_boxed0));
        dafny.DafnySequence<? extends Character> _2_k = (dafny.DafnySequence<? extends Character>)_compr_0;
        if (((_1_actions).<dafny.DafnySequence<? extends Character>>contains(_2_k)) && (java.util.Objects.equals(((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction)(java.lang.Object)((_1_actions).get(_2_k))), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()))) {
          _coll0.add(_2_k);
        }
      }
      return new dafny.DafnySet<dafny.DafnySequence<? extends Character>>(_coll0);
    })).apply()).apply(actions);
    if ((keyExpr).is_Some()) {
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError0 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
      _out0 = __default.TestParsedExpr(__default.ParseExpr((keyExpr).dtor_value(), (long) 0L), _0_encrypted, names);
      _3_valueOrError0 = _out0;
      if ((_3_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_3_valueOrError0).<Boolean>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
        return output;
      }
    }
    if ((filterExpr).is_Some()) {
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError1 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
      _out1 = __default.TestParsedExpr(__default.ParseExpr((filterExpr).dtor_value(), (long) 0L), _0_encrypted, names);
      _4_valueOrError1 = _out1;
      if ((_4_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_4_valueOrError1).<Boolean>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
        return output;
      }
    }
    output = Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    return output;
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDBFilterExpr._default";
  }
}
