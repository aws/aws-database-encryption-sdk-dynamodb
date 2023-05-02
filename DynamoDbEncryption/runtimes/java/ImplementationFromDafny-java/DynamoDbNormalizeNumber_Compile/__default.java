// Class __default
// Dafny class __default compiled into Java
package DynamoDbNormalizeNumber_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;
import DynamoDbEncryptionUtil_Compile.*;

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
          dafny.DafnySequence<? extends Character> _in1 = (val).take((java.math.BigInteger.valueOf((val).length())).subtract(java.math.BigInteger.ONE));
          val = _in1;
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
        dafny.DafnySequence<? extends Character> _in2 = (val).take((java.math.BigInteger.valueOf((val).length())).subtract(java.math.BigInteger.ONE));
        val = _in2;
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
        return Wrappers_Compile.Result.<java.math.BigInteger, dafny.DafnySequence<? extends Character>>create_Success(acc);
      } else if (__default.IsDecimalDigit(((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) {
        dafny.DafnySequence<? extends Character> _in3 = (s).drop(java.math.BigInteger.ONE);
        java.math.BigInteger _in4 = (((acc).multiply(java.math.BigInteger.valueOf(10L))).add(java.math.BigInteger.valueOf(((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))))).subtract(java.math.BigInteger.valueOf('0'));
        s = _in3;
        acc = _in4;
        continue TAIL_CALL_START;
      } else {
        return Wrappers_Compile.Result.<java.math.BigInteger, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The character '"), (s).take(java.math.BigInteger.ONE)), dafny.DafnySequence.asString("' is not a valid decimal digit.")));
      }
    }
  }
  public static Wrappers_Compile.Result<java.math.BigInteger, dafny.DafnySequence<? extends Character>> StrToInt(dafny.DafnySequence<? extends Character> s) {
    if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
      return Wrappers_Compile.Result.<java.math.BigInteger, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("An empty string is not a valid number."));
    } else if ((((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) == ('-')) {
      Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _20_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (java.math.BigInteger.ONE).compareTo(java.math.BigInteger.valueOf((s).length())) < 0, dafny.DafnySequence.asString("An empty string is not a valid number."));
      if ((_20_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_20_valueOrError0).<java.math.BigInteger>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.TypeDescriptor.BIG_INTEGER);
      } else {
        Wrappers_Compile.Result<java.math.BigInteger, dafny.DafnySequence<? extends Character>> _21_valueOrError1 = __default.StrToIntInner((s).drop(java.math.BigInteger.ONE), java.math.BigInteger.ZERO);
        if ((_21_valueOrError1).IsFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_21_valueOrError1).<java.math.BigInteger>PropagateFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.TypeDescriptor.BIG_INTEGER);
        } else {
          java.math.BigInteger _22_x = (_21_valueOrError1).Extract(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          return Wrappers_Compile.Result.<java.math.BigInteger, dafny.DafnySequence<? extends Character>>create_Success((java.math.BigInteger.ZERO).subtract(_22_x));
        }
      }
    } else if ((((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) == ('+')) {
      Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _23_valueOrError2 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (java.math.BigInteger.ONE).compareTo(java.math.BigInteger.valueOf((s).length())) < 0, dafny.DafnySequence.asString("An empty string is not a valid number."));
      if ((_23_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_23_valueOrError2).<java.math.BigInteger>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.TypeDescriptor.BIG_INTEGER);
      } else {
        return __default.StrToIntInner((s).drop(java.math.BigInteger.ONE), java.math.BigInteger.ZERO);
      }
    } else {
      return __default.StrToIntInner(s, java.math.BigInteger.ZERO);
    }
  }
  public static dafny.DafnySequence<? extends Character> Zeros(java.math.BigInteger n) {
    return dafny.DafnySequence.Create(dafny.TypeDescriptor.CHAR, n, ((java.util.function.Function<java.math.BigInteger, Character>)(_24_i_boxed0) -> {
      java.math.BigInteger _24_i = ((java.math.BigInteger)(java.lang.Object)(_24_i_boxed0));
      return '0';
    }));
  }
  public static java.math.BigInteger CountDigits(dafny.DafnySequence<? extends Character> s) {
    java.math.BigInteger _25___accumulator = java.math.BigInteger.ZERO;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
        return (java.math.BigInteger.ZERO).add(_25___accumulator);
      } else if (__default.IsDecimalDigit(((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) {
        _25___accumulator = (_25___accumulator).add(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends Character> _in5 = (s).drop(java.math.BigInteger.ONE);
        s = _in5;
        continue TAIL_CALL_START;
      } else {
        return (java.math.BigInteger.ZERO).add(_25___accumulator);
      }
    }
  }
  public static boolean IsE(char ch) {
    return ((ch) == ('e')) || ((ch) == ('E'));
  }
  public static Wrappers_Compile.Result<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>, dafny.DafnySequence<? extends Character>> ParseNumber(dafny.DafnySequence<? extends Character> n) {
    java.math.BigInteger _26_preDot = __default.CountDigits(n);
    if (java.util.Objects.equals(java.math.BigInteger.valueOf((n).length()), _26_preDot)) {
      return Wrappers_Compile.Result.<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>, dafny.DafnySequence<? extends Character>>create_Success(dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>create(n, java.math.BigInteger.valueOf((n).length()), java.math.BigInteger.ZERO));
    } else if ((((char)(java.lang.Object)((n).select(dafny.Helpers.toInt((_26_preDot)))))) == ('.')) {
      java.math.BigInteger _27_postDot = __default.CountDigits((n).drop((_26_preDot).add(java.math.BigInteger.ONE)));
      Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _28_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((_26_preDot).add(_27_postDot)).signum() == 1, dafny.DafnySequence.asString("Number needs digits either before or after the decimal point."));
      if ((_28_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_28_valueOrError0).<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _System.nat._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER));
      } else {
        java.math.BigInteger _29_len = ((_26_preDot).add(_27_postDot)).add(java.math.BigInteger.ONE);
        if (java.util.Objects.equals(_29_len, java.math.BigInteger.valueOf((n).length()))) {
          return Wrappers_Compile.Result.<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>, dafny.DafnySequence<? extends Character>>create_Success(dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>create(dafny.DafnySequence.<Character>concatenate((n).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((_26_preDot))), (n).drop((_26_preDot).add(java.math.BigInteger.ONE))), _26_preDot, java.math.BigInteger.ZERO));
        } else if (__default.IsE(((char)(java.lang.Object)((n).select(dafny.Helpers.toInt((_29_len))))))) {
          Wrappers_Compile.Result<java.math.BigInteger, dafny.DafnySequence<? extends Character>> _30_valueOrError1 = __default.StrToInt((n).drop((_29_len).add(java.math.BigInteger.ONE)));
          if ((_30_valueOrError1).IsFailure(dafny.TypeDescriptor.BIG_INTEGER, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_30_valueOrError1).<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>>PropagateFailure(dafny.TypeDescriptor.BIG_INTEGER, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _System.nat._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER));
          } else {
            java.math.BigInteger _31_exp = (_30_valueOrError1).Extract(dafny.TypeDescriptor.BIG_INTEGER, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
            return Wrappers_Compile.Result.<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>, dafny.DafnySequence<? extends Character>>create_Success(dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>create(dafny.DafnySequence.<Character>concatenate((n).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((_26_preDot))), (n).subsequence(dafny.Helpers.toInt(((_26_preDot).add(java.math.BigInteger.ONE))), dafny.Helpers.toInt((_29_len)))), _26_preDot, _31_exp));
          }
        } else {
          return Wrappers_Compile.Result.<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Invalid Character in number at '"), (n).drop(_29_len)), dafny.DafnySequence.asString("'.")));
        }
      }
    } else if ((_26_preDot).signum() == 0) {
      return Wrappers_Compile.Result.<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("Number needs digits either before or after the decimal point."));
    } else if (__default.IsE(((char)(java.lang.Object)((n).select(dafny.Helpers.toInt((_26_preDot))))))) {
      Wrappers_Compile.Result<java.math.BigInteger, dafny.DafnySequence<? extends Character>> _32_valueOrError2 = __default.StrToInt((n).drop((_26_preDot).add(java.math.BigInteger.ONE)));
      if ((_32_valueOrError2).IsFailure(dafny.TypeDescriptor.BIG_INTEGER, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_32_valueOrError2).<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>>PropagateFailure(dafny.TypeDescriptor.BIG_INTEGER, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _System.nat._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER));
      } else {
        java.math.BigInteger _33_exp = (_32_valueOrError2).Extract(dafny.TypeDescriptor.BIG_INTEGER, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        return Wrappers_Compile.Result.<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>, dafny.DafnySequence<? extends Character>>create_Success(dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>create((n).take(_26_preDot), _26_preDot, _33_exp));
      }
    } else {
      return Wrappers_Compile.Result.<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Invalid Character in number at '"), (n).drop(_26_preDot)), dafny.DafnySequence.asString("'.")));
    }
  }
  public static java.math.BigInteger CountZeros(dafny.DafnySequence<? extends Character> value) {
    java.math.BigInteger _34___accumulator = java.math.BigInteger.ZERO;
    TAIL_CALL_START: while (true) {
      if (((java.math.BigInteger.valueOf((value).length())).signum() == 0) || ((((char)(java.lang.Object)((value).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) != ('0'))) {
        return (java.math.BigInteger.ZERO).add(_34___accumulator);
      } else {
        _34___accumulator = (_34___accumulator).add(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends Character> _in6 = (value).drop(java.math.BigInteger.ONE);
        value = _in6;
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
        dafny.DafnySequence<? extends Character> _in7 = (value).drop(java.math.BigInteger.ONE);
        java.math.BigInteger _in8 = (pos).subtract(java.math.BigInteger.ONE);
        value = _in7;
        pos = _in8;
        continue TAIL_CALL_START;
      } else if (((((char)(java.lang.Object)((value).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((value).length())).subtract(java.math.BigInteger.ONE))))))) == ('0')) && ((pos).compareTo(java.math.BigInteger.valueOf((value).length())) < 0)) {
        dafny.DafnySequence<? extends Character> _in9 = (value).take((java.math.BigInteger.valueOf((value).length())).subtract(java.math.BigInteger.ONE));
        java.math.BigInteger _in10 = pos;
        value = _in9;
        pos = _in10;
        continue TAIL_CALL_START;
      } else {
        return dafny.Tuple2.<dafny.DafnySequence<? extends Character>, java.math.BigInteger>create(value, pos);
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> NormalizePositive(dafny.DafnySequence<? extends Character> n) {
    Wrappers_Compile.Result<dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>, dafny.DafnySequence<? extends Character>> _35_valueOrError0 = __default.ParseNumber(n);
    if ((_35_valueOrError0).IsFailure(dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _System.nat._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_35_valueOrError0).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _System.nat._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    } else {
      dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger> _let_tmp_rhs0 = (_35_valueOrError0).Extract(dafny.Tuple3.<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _System.nat._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      dafny.DafnySequence<? extends Character> _36_value = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>)_let_tmp_rhs0).dtor__0()));
      java.math.BigInteger _37_pos = ((java.math.BigInteger)(java.lang.Object)(((dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>)_let_tmp_rhs0).dtor__1()));
      java.math.BigInteger _38_exp = ((java.math.BigInteger)(java.lang.Object)(((dafny.Tuple3<dafny.DafnySequence<? extends Character>, java.math.BigInteger, java.math.BigInteger>)_let_tmp_rhs0).dtor__2()));
      dafny.Tuple2<dafny.DafnySequence<? extends Character>, java.math.BigInteger> _let_tmp_rhs1 = __default.NormalizeValue(_36_value, _37_pos);
      dafny.DafnySequence<? extends Character> _39_value = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((dafny.Tuple2<dafny.DafnySequence<? extends Character>, java.math.BigInteger>)_let_tmp_rhs1).dtor__0()));
      java.math.BigInteger _40_pos = ((java.math.BigInteger)(java.lang.Object)(((dafny.Tuple2<dafny.DafnySequence<? extends Character>, java.math.BigInteger>)_let_tmp_rhs1).dtor__1()));
      dafny.DafnySequence<? extends Character> _41_digitsOfPrecision = __default.SkipAllTrailingZeros(__default.SkipLeadingZeros(_39_value));
      Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _42_valueOrError1 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (java.math.BigInteger.valueOf((_41_digitsOfPrecision).length())).compareTo(java.math.BigInteger.valueOf(38L)) <= 0, dafny.DafnySequence.asString("Attempting to store more than 38 significant digits in a Number."));
      if ((_42_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_42_valueOrError1).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      } else {
        java.math.BigInteger _43_newPos = (_40_pos).add(_38_exp);
        if ((java.math.BigInteger.valueOf((_41_digitsOfPrecision).length())).signum() == 0) {
          return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.asString("0"));
        } else if ((_43_newPos).signum() != 1) {
          Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _44_valueOrError2 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((_43_newPos).subtract(__default.CountZeros(_39_value))).compareTo(java.math.BigInteger.valueOf(-129L)) >= 0, dafny.DafnySequence.asString("Attempting to store a number with magnitude smaller than supported range."));
          if ((_44_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_44_valueOrError2).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          } else {
            return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("0."), __default.Zeros((java.math.BigInteger.ZERO).subtract(_43_newPos))), _39_value));
          }
        } else if ((_43_newPos).compareTo(java.math.BigInteger.valueOf((_39_value).length())) >= 0) {
          Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _45_valueOrError3 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((_43_newPos).subtract(__default.CountZeros(_39_value))).compareTo(java.math.BigInteger.valueOf(126L)) <= 0, dafny.DafnySequence.asString("Attempting to store a number with magnitude larger than supported range."));
          if ((_45_valueOrError3).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_45_valueOrError3).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          } else {
            return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<Character>concatenate(_39_value, __default.Zeros((_43_newPos).subtract(java.math.BigInteger.valueOf((_39_value).length())))));
          }
        } else {
          return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate((_39_value).take(_43_newPos), dafny.DafnySequence.asString(".")), (_39_value).drop(_43_newPos)));
        }
      }
    }
  }
  public static dafny.DafnySequence<? extends Character> TrimZerosFromValidNumber(dafny.DafnySequence<? extends Character> n) {
    dafny.DafnySequence<? extends Character> _46_n = __default.SkipLeadingZeros(n);
    if ((_46_n).contains('.')) {
      return __default.SkipTrailingZeros(_46_n);
    } else {
      return _46_n;
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> NormalizeNumber2(dafny.DafnySequence<? extends Character> n) {
    Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _47_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (java.math.BigInteger.valueOf((n).length())).signum() == 1, dafny.DafnySequence.asString("An empty string is not a valid number."));
    if ((_47_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_47_valueOrError0).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    } else {
      dafny.Tuple2<Boolean, dafny.DafnySequence<? extends Character>> _let_tmp_rhs2 = (((((char)(java.lang.Object)((n).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) == ('-')) ? (dafny.Tuple2.<Boolean, dafny.DafnySequence<? extends Character>>create(true, (n).drop(java.math.BigInteger.ONE))) : ((((((char)(java.lang.Object)((n).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) == ('+')) ? (dafny.Tuple2.<Boolean, dafny.DafnySequence<? extends Character>>create(false, (n).drop(java.math.BigInteger.ONE))) : (dafny.Tuple2.<Boolean, dafny.DafnySequence<? extends Character>>create(false, n)))));
      boolean _48_neg = ((boolean)(java.lang.Object)(((dafny.Tuple2<Boolean, dafny.DafnySequence<? extends Character>>)_let_tmp_rhs2).dtor__0()));
      dafny.DafnySequence<? extends Character> _49_n = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((dafny.Tuple2<Boolean, dafny.DafnySequence<? extends Character>>)_let_tmp_rhs2).dtor__1()));
      Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _50_valueOrError1 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (java.math.BigInteger.valueOf((_49_n).length())).signum() == 1, dafny.DafnySequence.asString("An empty string is not a valid number."));
      if ((_50_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_50_valueOrError1).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _51_valueOrError2 = __default.NormalizePositive(_49_n);
        if ((_51_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_51_valueOrError2).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        } else {
          dafny.DafnySequence<? extends Character> _52_n = (_51_valueOrError2).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          dafny.DafnySequence<? extends Character> _53_n = __default.TrimZerosFromValidNumber(_52_n);
          if ((_48_neg) && (!(_53_n).equals(dafny.DafnySequence.asString("0")))) {
            return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.of('-'), _53_n));
          } else {
            return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>create_Success(_53_n);
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> NormalizeNumber(dafny.DafnySequence<? extends Character> n) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _54_ret = __default.NormalizeNumber2(n);
    if ((_54_ret).is_Success()) {
      return _54_ret;
    } else {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate((_54_ret).dtor_error(), dafny.DafnySequence.asString(" when parsing '")), n), dafny.DafnySequence.asString("'.")));
    }
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDbNormalizeNumber_Compile._default";
  }
}
