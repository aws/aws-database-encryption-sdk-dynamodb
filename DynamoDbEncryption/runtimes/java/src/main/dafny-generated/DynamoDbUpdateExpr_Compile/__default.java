// Class __default
// Dafny class __default compiled into Java
package DynamoDbUpdateExpr_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> ExtractAttributes(dafny.DafnySequence<? extends Character> s, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> ex)
  {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_x = __default.ExtractAttrs(s);
    if ((ex).is_None()) {
      return _0_x;
    } else {
      return __default.Resolve(_0_x, (ex).dtor_value());
    }
  }
  public static boolean IgnoreAttr(dafny.DafnySequence<? extends Character> s) {
    return (dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("SET"), dafny.DafnySequence.asString("REMOVE"), dafny.DafnySequence.asString("ADD"), dafny.DafnySequence.asString("DELETE"), dafny.DafnySequence.asString("list_append"), dafny.DafnySequence.asString("if_not_exists"))).contains(s);
  }
  public static dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> Resolve(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> names, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> ex)
  {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0___accumulator = dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((names).length())).signum() == 0) {
        return dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(_0___accumulator, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
      } else if ((ex).<dafny.DafnySequence<? extends Character>>contains(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((names).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) {
        _0___accumulator = dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(_0___accumulator, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((ex).get(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((names).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))))));
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in0 = (names).drop(java.math.BigInteger.ONE);
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> _in1 = ex;
        names = _in0;
        ex = _in1;
        continue TAIL_CALL_START;
      } else {
        _0___accumulator = dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(_0___accumulator, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((names).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in2 = (names).drop(java.math.BigInteger.ONE);
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> _in3 = ex;
        names = _in2;
        ex = _in3;
        continue TAIL_CALL_START;
      }
    }
  }
  public static dafny.DafnySequence<? extends Character> ChopOne(dafny.DafnySequence<? extends Character> s, char ch)
  {
    if ((s).contains(ch)) {
      return (StandardLibrary_Compile.__default.<Character>SplitOnce(dafny.TypeDescriptor.CHAR, s, ch)).dtor__0();
    } else {
      return s;
    }
  }
  public static dafny.DafnySequence<? extends Character> Chop(dafny.DafnySequence<? extends Character> s) {
    dafny.DafnySequence<? extends Character> _0_s = __default.ChopOne(s, '.');
    return __default.ChopOne(_0_s, '[');
  }
  public static dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> ExtractAttrs(dafny.DafnySequence<? extends Character> s) {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0___accumulator = dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
        return dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(_0___accumulator, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
      } else {
        dafny.Tuple2<java.math.BigInteger, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>> _1_ret = __default.FindToken(s);
        if (((_1_ret).dtor__0()).signum() == 0) {
          return dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(_0___accumulator, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
        } else if (((_1_ret).dtor__1()).is_None()) {
          dafny.DafnySequence<? extends Character> _in0 = (s).drop((_1_ret).dtor__0());
          s = _in0;
          continue TAIL_CALL_START;
        } else if (__default.IgnoreAttr(((_1_ret).dtor__1()).dtor_value())) {
          dafny.DafnySequence<? extends Character> _in1 = (s).drop((_1_ret).dtor__0());
          s = _in1;
          continue TAIL_CALL_START;
        } else {
          _0___accumulator = dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(_0___accumulator, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), __default.Chop(((_1_ret).dtor__1()).dtor_value())));
          dafny.DafnySequence<? extends Character> _in2 = (s).drop((_1_ret).dtor__0());
          s = _in2;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static boolean BadStart(char ch) {
    return ((ch) == (':')) || ((('0') <= (ch)) && ((ch) <= ('9')));
  }
  public static boolean AttrStart(char ch) {
    if ((('a') <= (ch)) && ((ch) <= ('z'))) {
      return true;
    } else if ((('A') <= (ch)) && ((ch) <= ('Z'))) {
      return true;
    } else if (((ch) == ('#')) || ((ch) == ('_'))) {
      return true;
    } else {
      return false;
    }
  }
  public static boolean AttrChar(char ch) {
    if (__default.AttrStart(ch)) {
      return true;
    } else if ((('0') <= (ch)) && ((ch) <= ('9'))) {
      return true;
    } else if ((dafny.DafnySequence.<Character> of('[', ']', '.')).contains(ch)) {
      return true;
    } else {
      return false;
    }
  }
  public static java.math.BigInteger AttrLen(dafny.DafnySequence<? extends Character> s) {
    java.math.BigInteger _0___accumulator = java.math.BigInteger.ZERO;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
        return (java.math.BigInteger.ZERO).add(_0___accumulator);
      } else if (__default.AttrChar(((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) {
        _0___accumulator = (java.math.BigInteger.ONE).add(_0___accumulator);
        dafny.DafnySequence<? extends Character> _in0 = (s).drop(java.math.BigInteger.ONE);
        s = _in0;
        continue TAIL_CALL_START;
      } else {
        return (java.math.BigInteger.ZERO).add(_0___accumulator);
      }
    }
  }
  public static dafny.Tuple2<java.math.BigInteger, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>> FindToken(dafny.DafnySequence<? extends Character> s) {
    if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
      return dafny.Tuple2.<java.math.BigInteger, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>create(java.math.BigInteger.ZERO, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
    } else {
      char _0_ch = ((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))));
      if ((_0_ch) == ('#')) {
        java.math.BigInteger _1_x = (__default.AttrLen((s).drop(java.math.BigInteger.ONE))).add(java.math.BigInteger.ONE);
        return dafny.Tuple2.<java.math.BigInteger, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>create(_1_x, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (s).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((_1_x)))));
      } else if (__default.BadStart(_0_ch)) {
        java.math.BigInteger _2_x = (__default.AttrLen((s).drop(java.math.BigInteger.ONE))).add(java.math.BigInteger.ONE);
        return dafny.Tuple2.<java.math.BigInteger, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>create(_2_x, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
      } else if (__default.AttrStart(_0_ch)) {
        java.math.BigInteger _3_x = (__default.AttrLen((s).drop(java.math.BigInteger.ONE))).add(java.math.BigInteger.ONE);
        return dafny.Tuple2.<java.math.BigInteger, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>create(_3_x, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (s).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((_3_x)))));
      } else {
        return dafny.Tuple2.<java.math.BigInteger, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>create(java.math.BigInteger.ONE, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
      }
    }
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDbUpdateExpr._default";
  }
}
