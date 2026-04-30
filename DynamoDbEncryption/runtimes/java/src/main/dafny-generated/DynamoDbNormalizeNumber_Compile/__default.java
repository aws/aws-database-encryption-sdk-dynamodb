// Class __default
// Dafny class __default compiled into Java
package DynamoDbNormalizeNumber_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static dafny.DafnySequence<? extends Character> SkipLeadingZeros(dafny.DafnySequence<? extends Character> val) {
    TAIL_CALL_START: while (true) {
      if ((((java.math.BigInteger.ONE).compareTo(java.math.BigInteger.valueOf((val).length())) < 0) && ((((char)(java.lang.Object)((val).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) == ('0'))) && ((((char)(java.lang.Object)((val).select(dafny.Helpers.toInt((java.math.BigInteger.ONE)))))) != ('.'))) {
        dafny.DafnySequence<? extends Character> _in0 = (val).drop(java.math.BigInteger.ONE);
        val = _in0;
        continue TAIL_CALL_START;
      } else {
        return val;
      }
    }
  }
  public static dafny.DafnySequence<? extends Character> SkipTrailingZeros(dafny.DafnySequence<? extends Character> val) {
    TAIL_CALL_START: while (true) {
      if (((java.math.BigInteger.ONE).compareTo(java.math.BigInteger.valueOf((val).length())) < 0) && ((((char)(java.lang.Object)((val).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((val).length())).subtract(java.math.BigInteger.ONE))))))) == ('0'))) {
        if ((((char)(java.lang.Object)((val).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((val).length())).subtract(java.math.BigInteger.valueOf(2L)))))))) == ('.')) {
          return (val).take((java.math.BigInteger.valueOf((val).length())).subtract(java.math.BigInteger.valueOf(2L)));
        } else {
          dafny.DafnySequence<? extends Character> _in0 = (val).take((java.math.BigInteger.valueOf((val).length())).subtract(java.math.BigInteger.ONE));
          val = _in0;
          continue TAIL_CALL_START;
        }
      } else {
        return val;
      }
    }
  }
  public static dafny.DafnySequence<? extends Character> SkipAllTrailingZeros(dafny.DafnySequence<? extends Character> val) {
    TAIL_CALL_START: while (true) {
      if (((java.math.BigInteger.valueOf((val).length())).signum() == 1) && ((((char)(java.lang.Object)((val).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((val).length())).subtract(java.math.BigInteger.ONE))))))) == ('0'))) {
        dafny.DafnySequence<? extends Character> _in0 = (val).take((java.math.BigInteger.valueOf((val).length())).subtract(java.math.BigInteger.ONE));
        val = _in0;
        continue TAIL_CALL_START;
      } else {
        return val;
      }
    }
  }
  public static boolean IsDecimalDigit(char ch) {
    return (('0') <= (ch)) && ((ch) <= ('9'));
  }
  public static Wrappers_Compile.Result<java.math.BigInteger, dafny.DafnySequence<? extends Character>> StrToIntInner(dafny.DafnySequence<? extends Character> s, java.math.BigInteger acc)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
        return Wrappers_Compile.Result.<java.math.BigInteger, dafny.DafnySequence<? extends Character>>create_Success(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), acc);
      } else if (__default.IsDecimalDigit(((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) {
        dafny.DafnySequence<? extends Character> _in0 = (s).drop(java.math.BigInteger.ONE);
        java.math.BigInteger _in1 = (((acc).multiply(java.math.BigInteger.valueOf(10L))).add(java.math.BigInteger.valueOf(((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))))).subtract(java.math.BigInteger.valueOf('0'));
        s = _in0;
        acc = _in1;
        continue TAIL_CALL_START;
      } else {
        return Wrappers_Compile.Result.<java.math.BigInteger, dafny.DafnySequence<? extends Character>>create_Failure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The character '"), (s).take(java.math.BigInteger.ONE)), dafny.DafnySequence.asString("' is not a valid decimal digit.")));
      }
    }
  }
  public static Wrappers_Compile.Result<java.math.BigInteger, dafny.DafnySequence<? extends Character>> StrToInt(dafny.DafnySequence<? extends Character> s) {
    if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
      return Wrappers_Compile.Result.<java.math.BigInteger, dafny.DafnySequence<? extends Character>>create_Failure(dafny.TypeDescriptor.BIG_INTEGER, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("An empty string is not a valid number."));
    } else if ((((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) == ('-')) {
      Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _0_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (java.math.BigInteger.ONE).compareTo(java.math.BigInteger.valueOf((s).length())) < 0, dafny.DafnySequence.asString("An empty string is not a valid number."));
      if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_0_valueOrError0).<java.math.BigInteger>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.TypeDescriptor.BIG_INTEGER);
      } else {
        Wrappers_Compile.Result<java.math.BigInteger, dafny.DafnySequence<? extends Character>> _1_valueOrError1 = __default.StrToIntInner((s).drop(java.math.BigInteger.ONE), java.math.BigInteger.ZERO);
        if ((_1_valueOrError1).IsFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_1_valueOrError1).<java.math.BigInteger>PropagateFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.TypeDescriptor.BIG_INTEGER);
        } else {
          java.math.BigInteger _2_x = (_1_valueOrError1).Extract(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          return Wrappers_Compile.Result.<java.math.BigInteger, dafny.DafnySequence<? extends Character>>create_Success(dafny.TypeDescriptor.BIG_INTEGER, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (java.math.BigInteger.ZERO).subtract(_2_x));
        }
      }
    } else if ((((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) == ('+')) {
      Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _3_valueOrError2 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (java.math.BigInteger.ONE).compareTo(java.math.BigInteger.valueOf((s).length())) < 0, dafny.DafnySequence.asString("An empty string is not a valid number."));
      if ((_3_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_3_valueOrError2).<java.math.BigInteger>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.TypeDescriptor.BIG_INTEGER);
      } else {
        return __default.StrToIntInner((s).drop(java.math.BigInteger.ONE), java.math.BigInteger.ZERO);
      }
    } else {
      return __default.StrToIntInner(s, java.math.BigInteger.ZERO);
    }
  }
  public static dafny.DafnySequence<? extends Character> Zeros(java.math.BigInteger n) {
    return dafny.DafnySequence.Create(dafny.TypeDescriptor.CHAR, n, ((java.util.function.Function<java.math.BigInteger, Character>)(_0_i_boxed0) -> {
      java.math.BigInteger _0_i = ((java.math.BigInteger)(java.lang.Object)(_0_i_boxed0));
      return '0';
    }));
  }
  public static java.math.BigInteger CountDigits(dafny.DafnySequence<? extends Character> s) {
    java.math.BigInteger _0___accumulator = java.math.BigInteger.ZERO;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
        return (java.math.BigInteger.ZERO).add(_0___accumulator);
      } else if (__default.IsDecimalDigit(((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) {
        _0___accumulator = (_0___accumulator).add(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends Character> _in0 = (s).drop(java.math.BigInteger.ONE);
        s = _in0;
        continue TAIL_CALL_START;
      } else {
        return (java.math.BigInteger.ZERO).add(_0___accumulator);
      }
    }
  }
  public static boolean IsE(char ch) {
    return ((ch) == ('e')) || ((ch) == ('E'));
  }
  public static Wrappers_Compile.Result<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>, dafny.DafnySequence<? extends Character>> ParseNumber(dafny.DafnySequence<? extends Character> n) {
    java.math.BigInteger _0_preDot = __default.CountDigits(n);
    if (java.util.Objects.equals(java.math.BigInteger.valueOf((n).length()), _0_preDot)) {
      return Wrappers_Compile.Result.<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>, dafny.DafnySequence<? extends Character>>create_Success(dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.TypeDescriptor.BIG_INTEGER, dafny.TypeDescriptor.BIG_INTEGER), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>create(n, java.math.BigInteger.valueOf((n).length()), java.math.BigInteger.ZERO));
    } else if ((((char)(java.lang.Object)((n).select(dafny.Helpers.toInt((_0_preDot)))))) == ('.')) {
      java.math.BigInteger _1_postDot = __default.CountDigits((n).drop((_0_preDot).add(java.math.BigInteger.ONE)));
      Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _2_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((_0_preDot).add(_1_postDot)).signum() == 1, dafny.DafnySequence.asString("Number needs digits either before or after the decimal point."));
      if ((_2_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_2_valueOrError0).<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _System.nat._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER));
      } else {
        java.math.BigInteger _3_len = ((_0_preDot).add(_1_postDot)).add(java.math.BigInteger.ONE);
        if (java.util.Objects.equals(_3_len, java.math.BigInteger.valueOf((n).length()))) {
          return Wrappers_Compile.Result.<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>, dafny.DafnySequence<? extends Character>>create_Success(dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _System.nat._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>create(dafny.DafnySequence.<Character>concatenate((n).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((_0_preDot))), (n).drop((_0_preDot).add(java.math.BigInteger.ONE))), _0_preDot, java.math.BigInteger.ZERO));
        } else if (__default.IsE(((char)(java.lang.Object)((n).select(dafny.Helpers.toInt((_3_len))))))) {
          Wrappers_Compile.Result<java.math.BigInteger, dafny.DafnySequence<? extends Character>> _4_valueOrError1 = __default.StrToInt((n).drop((_3_len).add(java.math.BigInteger.ONE)));
          if ((_4_valueOrError1).IsFailure(dafny.TypeDescriptor.BIG_INTEGER, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_4_valueOrError1).<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>>PropagateFailure(dafny.TypeDescriptor.BIG_INTEGER, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _System.nat._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER));
          } else {
            java.math.BigInteger _5_exp = (_4_valueOrError1).Extract(dafny.TypeDescriptor.BIG_INTEGER, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
            return Wrappers_Compile.Result.<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>, dafny.DafnySequence<? extends Character>>create_Success(dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _System.nat._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>create(dafny.DafnySequence.<Character>concatenate((n).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((_0_preDot))), (n).subsequence(dafny.Helpers.toInt(((_0_preDot).add(java.math.BigInteger.ONE))), dafny.Helpers.toInt((_3_len)))), _0_preDot, _5_exp));
          }
        } else {
          return Wrappers_Compile.Result.<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>, dafny.DafnySequence<? extends Character>>create_Failure(dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _System.nat._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Invalid Character in number at '"), (n).drop(_3_len)), dafny.DafnySequence.asString("'.")));
        }
      }
    } else if ((_0_preDot).signum() == 0) {
      return Wrappers_Compile.Result.<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>, dafny.DafnySequence<? extends Character>>create_Failure(dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _System.nat._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Number needs digits either before or after the decimal point."));
    } else if (__default.IsE(((char)(java.lang.Object)((n).select(dafny.Helpers.toInt((_0_preDot))))))) {
      Wrappers_Compile.Result<java.math.BigInteger, dafny.DafnySequence<? extends Character>> _6_valueOrError2 = __default.StrToInt((n).drop((_0_preDot).add(java.math.BigInteger.ONE)));
      if ((_6_valueOrError2).IsFailure(dafny.TypeDescriptor.BIG_INTEGER, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_6_valueOrError2).<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>>PropagateFailure(dafny.TypeDescriptor.BIG_INTEGER, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _System.nat._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER));
      } else {
        java.math.BigInteger _7_exp = (_6_valueOrError2).Extract(dafny.TypeDescriptor.BIG_INTEGER, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        return Wrappers_Compile.Result.<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>, dafny.DafnySequence<? extends Character>>create_Success(dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _System.nat._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>create((n).take(_0_preDot), _0_preDot, _7_exp));
      }
    } else {
      return Wrappers_Compile.Result.<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>, dafny.DafnySequence<? extends Character>>create_Failure(dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _System.nat._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Invalid Character in number at '"), (n).drop(_0_preDot)), dafny.DafnySequence.asString("'.")));
    }
  }
  public static java.math.BigInteger CountZeros(dafny.DafnySequence<? extends Character> value) {
    java.math.BigInteger _0___accumulator = java.math.BigInteger.ZERO;
    TAIL_CALL_START: while (true) {
      if (((java.math.BigInteger.valueOf((value).length())).signum() == 0) || ((((char)(java.lang.Object)((value).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) != ('0'))) {
        return (java.math.BigInteger.ZERO).add(_0___accumulator);
      } else {
        _0___accumulator = (_0___accumulator).add(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends Character> _in0 = (value).drop(java.math.BigInteger.ONE);
        value = _in0;
        continue TAIL_CALL_START;
      }
    }
  }
  public static dafny.Tuple2<dafny.DafnySequence<? extends Character>, java.math.BigInteger> NormalizeValue(dafny.DafnySequence<? extends Character> value, java.math.BigInteger pos)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((value).length())).signum() == 0) {
        return dafny.Tuple2.<dafny.DafnySequence<? extends Character>, java.math.BigInteger>create(value, pos);
      } else if (((((char)(java.lang.Object)((value).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) == ('0')) && ((pos).signum() == 1)) {
        dafny.DafnySequence<? extends Character> _in0 = (value).drop(java.math.BigInteger.ONE);
        java.math.BigInteger _in1 = (pos).subtract(java.math.BigInteger.ONE);
        value = _in0;
        pos = _in1;
        continue TAIL_CALL_START;
      } else if (((((char)(java.lang.Object)((value).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((value).length())).subtract(java.math.BigInteger.ONE))))))) == ('0')) && ((pos).compareTo(java.math.BigInteger.valueOf((value).length())) < 0)) {
        dafny.DafnySequence<? extends Character> _in2 = (value).take((java.math.BigInteger.valueOf((value).length())).subtract(java.math.BigInteger.ONE));
        java.math.BigInteger _in3 = pos;
        value = _in2;
        pos = _in3;
        continue TAIL_CALL_START;
      } else {
        return dafny.Tuple2.<dafny.DafnySequence<? extends Character>, java.math.BigInteger>create(value, pos);
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> NormalizePositive(dafny.DafnySequence<? extends Character> n) {
    Wrappers_Compile.Result<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>, dafny.DafnySequence<? extends Character>> _0_valueOrError0 = __default.ParseNumber(n);
    if ((_0_valueOrError0).IsFailure(dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _System.nat._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _System.nat._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    } else {
      dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger> _let_tmp_rhs0 = (_0_valueOrError0).Extract(dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _System.nat._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      dafny.DafnySequence<? extends Character> _1_value = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>)_let_tmp_rhs0).dtor__0()));
      java.math.BigInteger _2_pos = ((java.math.BigInteger)(java.lang.Object)(((dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>)_let_tmp_rhs0).dtor__1()));
      java.math.BigInteger _3_exp = ((java.math.BigInteger)(java.lang.Object)(((dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>)_let_tmp_rhs0).dtor__2()));
      dafny.Tuple2<dafny.DafnySequence<? extends Character>, java.math.BigInteger> _let_tmp_rhs1 = __default.NormalizeValue(_1_value, _2_pos);
      dafny.DafnySequence<? extends Character> _4_value = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((dafny.Tuple2<dafny.DafnySequence<? extends Character>, java.math.BigInteger>)_let_tmp_rhs1).dtor__0()));
      java.math.BigInteger _5_pos = ((java.math.BigInteger)(java.lang.Object)(((dafny.Tuple2<dafny.DafnySequence<? extends Character>, java.math.BigInteger>)_let_tmp_rhs1).dtor__1()));
      dafny.DafnySequence<? extends Character> _6_digitsOfPrecision = __default.SkipAllTrailingZeros(__default.SkipLeadingZeros(_4_value));
      Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _7_valueOrError1 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (java.math.BigInteger.valueOf((_6_digitsOfPrecision).length())).compareTo(java.math.BigInteger.valueOf(38L)) <= 0, dafny.DafnySequence.asString("Attempting to store more than 38 significant digits in a Number."));
      if ((_7_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_7_valueOrError1).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      } else {
        java.math.BigInteger _8_newPos = (_5_pos).add(_3_exp);
        if ((java.math.BigInteger.valueOf((_6_digitsOfPrecision).length())).signum() == 0) {
          return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("0"));
        } else if ((_8_newPos).signum() != 1) {
          Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _9_valueOrError2 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((_8_newPos).subtract(__default.CountZeros(_4_value))).compareTo(java.math.BigInteger.valueOf(-129L)) >= 0, dafny.DafnySequence.asString("Attempting to store a number with magnitude smaller than supported range."));
          if ((_9_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_9_valueOrError2).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          } else {
            return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("0."), __default.Zeros((java.math.BigInteger.ZERO).subtract(_8_newPos))), _4_value));
          }
        } else if ((_8_newPos).compareTo(java.math.BigInteger.valueOf((_4_value).length())) >= 0) {
          Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _10_valueOrError3 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((_8_newPos).subtract(__default.CountZeros(_4_value))).compareTo(java.math.BigInteger.valueOf(126L)) <= 0, dafny.DafnySequence.asString("Attempting to store a number with magnitude larger than supported range."));
          if ((_10_valueOrError3).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_10_valueOrError3).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          } else {
            return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>concatenate(_4_value, __default.Zeros((_8_newPos).subtract(java.math.BigInteger.valueOf((_4_value).length())))));
          }
        } else {
          return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate((_4_value).take(_8_newPos), dafny.DafnySequence.asString(".")), (_4_value).drop(_8_newPos)));
        }
      }
    }
  }
  public static dafny.DafnySequence<? extends Character> TrimZerosFromValidNumber(dafny.DafnySequence<? extends Character> n) {
    dafny.DafnySequence<? extends Character> _0_n = __default.SkipLeadingZeros(n);
    if ((_0_n).contains('.')) {
      return __default.SkipTrailingZeros(_0_n);
    } else {
      return _0_n;
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> NormalizeNumber2(dafny.DafnySequence<? extends Character> n) {
    Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _0_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (java.math.BigInteger.valueOf((n).length())).signum() == 1, dafny.DafnySequence.asString("An empty string is not a valid number."));
    if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    } else {
      dafny.Tuple2<Boolean, dafny.DafnySequence<? extends Character>> _let_tmp_rhs0 = (((((char)(java.lang.Object)((n).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) == ('-')) ? (dafny.Tuple2.<Boolean, dafny.DafnySequence<? extends Character>>create(true, (n).drop(java.math.BigInteger.ONE))) : ((((((char)(java.lang.Object)((n).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) == ('+')) ? (dafny.Tuple2.<Boolean, dafny.DafnySequence<? extends Character>>create(false, (n).drop(java.math.BigInteger.ONE))) : (dafny.Tuple2.<Boolean, dafny.DafnySequence<? extends Character>>create(false, n)))));
      boolean _1_neg = ((boolean)(java.lang.Object)(((dafny.Tuple2<Boolean, dafny.DafnySequence<? extends Character>>)_let_tmp_rhs0).dtor__0()));
      dafny.DafnySequence<? extends Character> _2_n = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((dafny.Tuple2<Boolean, dafny.DafnySequence<? extends Character>>)_let_tmp_rhs0).dtor__1()));
      Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _3_valueOrError1 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (java.math.BigInteger.valueOf((_2_n).length())).signum() == 1, dafny.DafnySequence.asString("An empty string is not a valid number."));
      if ((_3_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_3_valueOrError1).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _4_valueOrError2 = __default.NormalizePositive(_2_n);
        if ((_4_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_4_valueOrError2).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        } else {
          dafny.DafnySequence<? extends Character> _5_n = (_4_valueOrError2).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          dafny.DafnySequence<? extends Character> _6_n = __default.TrimZerosFromValidNumber(_5_n);
          if ((_1_neg) && (!(_6_n).equals(dafny.DafnySequence.asString("0")))) {
            return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character> of('-'), _6_n));
          } else {
            return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _6_n);
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> NormalizeNumber(dafny.DafnySequence<? extends Character> n) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _0_ret = __default.NormalizeNumber2(n);
    if ((_0_ret).is_Success()) {
      return _0_ret;
    } else {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate((_0_ret).dtor_error(), dafny.DafnySequence.asString(" when parsing '")), n), dafny.DafnySequence.asString("'.")));
    }
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDbNormalizeNumber._default";
  }
}
