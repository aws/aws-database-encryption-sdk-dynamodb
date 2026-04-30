// Class __default
// Dafny class __default compiled into Java
package DdbStatement_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static dafny.DafnySequence<? extends Character> UnQuote(dafny.DafnySequence<? extends Character> s) {
    dafny.DafnySequence<? extends Character> _0_s = ((((java.math.BigInteger.valueOf((s).length())).signum() == 1) && ((((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) == ('"'))) ? ((s).drop(java.math.BigInteger.ONE)) : (s));
    if (((java.math.BigInteger.valueOf((_0_s).length())).signum() == 1) && ((((char)(java.lang.Object)((_0_s).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((_0_s).length())).subtract(java.math.BigInteger.ONE))))))) == ('"'))) {
      return (_0_s).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt(((java.math.BigInteger.valueOf((_0_s).length())).subtract(java.math.BigInteger.ONE))));
    } else {
      return _0_s;
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> GetTableName(dafny.DafnySequence<? extends Character> s) {
    dafny.DafnySequence<? extends Character> _0_s = __default.UnQuote(s);
    if (software.amazon.cryptography.services.dynamodb.internaldafny.types.__default.IsValid__TableName(_0_s)) {
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _0_s);
    } else {
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> TableFromStatement(dafny.DafnySequence<? extends Character> s) {
    Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _0_ret = __default.TableFromStatementInner(s);
    if ((_0_ret).is_Some()) {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableName._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (_0_ret).dtor_value());
    } else {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>create_Failure(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableName._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Unable to extract table name from PartiQL statement."));
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> TableFromStatementInner(dafny.DafnySequence<? extends Character> s) {
    dafny.DafnySequence<? extends Character> _0_s = __default.StripLeadingWhitespace(s);
    if (((java.math.BigInteger.valueOf((_0_s).length())).compareTo(java.math.BigInteger.valueOf(6L)) > 0) && ((__default.AsciiLower((_0_s).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((java.math.BigInteger.valueOf(6L)))))).equals(dafny.DafnySequence.asString("exists")))) {
      return __default.TableFromExistsStatement((_0_s).drop(java.math.BigInteger.valueOf(6L)));
    } else {
      java.math.BigInteger _1_len = __default.FindTokenLen(_0_s);
      dafny.DafnySequence<? extends Character> _2_cmd = __default.AsciiLower((_0_s).take(_1_len));
      if ((_2_cmd).equals(dafny.DafnySequence.asString("select"))) {
        return __default.TableFromSelectStatement((_0_s).drop(_1_len));
      } else if ((_2_cmd).equals(dafny.DafnySequence.asString("update"))) {
        return __default.TableFromUpdateStatement((_0_s).drop(_1_len));
      } else if ((_2_cmd).equals(dafny.DafnySequence.asString("delete"))) {
        return __default.TableFromDeleteStatement((_0_s).drop(_1_len));
      } else if ((_2_cmd).equals(dafny.DafnySequence.asString("insert"))) {
        return __default.TableFromInsertStatement((_0_s).drop(_1_len));
      } else {
        return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableName._typeDescriptor());
      }
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> TableFromSelectStatementInner(dafny.DafnySequence<? extends Character> s) {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
        return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      } else {
        dafny.DafnySequence<? extends Character> _0_t = __default.StripLeadingWhitespace(s);
        java.math.BigInteger _1_len = __default.FindTokenLen(_0_t);
        if ((__default.AsciiLower((_0_t).take(_1_len))).equals(dafny.DafnySequence.asString("from"))) {
          dafny.DafnySequence<? extends Character> _2_t = __default.StripLeadingWhitespace((_0_t).drop(_1_len));
          java.math.BigInteger _3_len = __default.FindTokenLen(_2_t);
          return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (_2_t).take(_3_len));
        } else if ((_1_len).signum() == 0) {
          return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        } else {
          dafny.DafnySequence<? extends Character> _in0 = (_0_t).drop(_1_len);
          s = _in0;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> TableFromExistsStatement(dafny.DafnySequence<? extends Character> s) {
    dafny.DafnySequence<? extends Character> _0_s = __default.StripLeadingWhitespace(s);
    if (((java.math.BigInteger.valueOf((_0_s).length())).signum() == 0) || ((((char)(java.lang.Object)((_0_s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) != ('('))) {
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableName._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends Character> _1_s = __default.StripLeadingWhitespace((_0_s).drop(java.math.BigInteger.ONE));
      java.math.BigInteger _2_len = __default.FindTokenLen(_1_s);
      if ((__default.AsciiLower((_1_s).take(_2_len))).equals(dafny.DafnySequence.asString("select"))) {
        return __default.TableFromSelectStatement((_1_s).drop(_2_len));
      } else {
        return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableName._typeDescriptor());
      }
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> TableFromSelectStatement(dafny.DafnySequence<? extends Character> s) {
    Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _0_valueOrError0 = __default.TableFromSelectStatementInner(s);
    if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.TableName._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends Character> _1_name = (_0_valueOrError0).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      if ((_1_name).contains('.')) {
        dafny.Tuple2<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _2_x = StandardLibrary_Compile.__default.<Character>SplitOnce(dafny.TypeDescriptor.CHAR, _1_name, '.');
        return __default.GetTableName((_2_x).dtor__0());
      } else {
        return __default.GetTableName(_1_name);
      }
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> TableFromUpdateStatement(dafny.DafnySequence<? extends Character> s) {
    dafny.DafnySequence<? extends Character> _0_s = __default.StripLeadingWhitespace(s);
    java.math.BigInteger _1_len = __default.FindTokenLen(_0_s);
    if ((_1_len).signum() == 0) {
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableName._typeDescriptor());
    } else {
      return __default.GetTableName((_0_s).take(_1_len));
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> TableFromDeleteStatement(dafny.DafnySequence<? extends Character> s) {
    dafny.DafnySequence<? extends Character> _0_s = __default.StripLeadingWhitespace(s);
    java.math.BigInteger _1_len = __default.FindTokenLen(_0_s);
    if (!(__default.AsciiLower((_0_s).take(_1_len))).equals(dafny.DafnySequence.asString("from"))) {
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableName._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends Character> _2_s = __default.StripLeadingWhitespace((_0_s).drop(_1_len));
      java.math.BigInteger _3_len = __default.FindTokenLen(_2_s);
      if ((_3_len).signum() == 0) {
        return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableName._typeDescriptor());
      } else {
        return __default.GetTableName((_2_s).take(_3_len));
      }
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> TableFromInsertStatement(dafny.DafnySequence<? extends Character> s) {
    dafny.DafnySequence<? extends Character> _0_s = __default.StripLeadingWhitespace(s);
    java.math.BigInteger _1_len = __default.FindTokenLen(_0_s);
    if (!(__default.AsciiLower((_0_s).take(_1_len))).equals(dafny.DafnySequence.asString("into"))) {
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableName._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends Character> _2_s = __default.StripLeadingWhitespace((_0_s).drop(_1_len));
      java.math.BigInteger _3_len = __default.FindTokenLen(_2_s);
      if ((_3_len).signum() == 0) {
        return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableName._typeDescriptor());
      } else {
        return __default.GetTableName((_2_s).take(_3_len));
      }
    }
  }
  public static boolean IsWhitespace(char ch) {
    return (ch) <= (' ');
  }
  public static dafny.DafnySequence<? extends Character> StripLeadingWhitespace(dafny.DafnySequence<? extends Character> s) {
    TAIL_CALL_START: while (true) {
      if (((java.math.BigInteger.valueOf((s).length())).signum() == 0) || (!(__default.IsWhitespace(((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))))) {
        return s;
      } else {
        dafny.DafnySequence<? extends Character> _in0 = (s).drop(java.math.BigInteger.ONE);
        s = _in0;
        continue TAIL_CALL_START;
      }
    }
  }
  public static char AsciiLowerChar(char ch) {
    if ((('A') <= (ch)) && ((ch) <= ('Z'))) {
      return (char) (((char) ((ch) - ('A'))) + ('a'));
    } else {
      return ch;
    }
  }
  public static dafny.DafnySequence<? extends Character> AsciiLower(dafny.DafnySequence<? extends Character> s) {
    dafny.DafnySequence<? extends Character> _0___accumulator = dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR);
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
        return dafny.DafnySequence.<Character>concatenate(_0___accumulator, s);
      } else {
        _0___accumulator = dafny.DafnySequence.<Character>concatenate(_0___accumulator, dafny.DafnySequence.<Character> of(__default.AsciiLowerChar(((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))));
        dafny.DafnySequence<? extends Character> _in0 = (s).drop(java.math.BigInteger.ONE);
        s = _in0;
        continue TAIL_CALL_START;
      }
    }
  }
  public static java.math.BigInteger FindTokenLen(dafny.DafnySequence<? extends Character> s) {
    if (((java.math.BigInteger.valueOf((s).length())).signum() == 0) || (__default.IsWhitespace(((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))))) {
      return java.math.BigInteger.ZERO;
    } else if ((((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) == ('"')) {
      return (java.math.BigInteger.ONE).add(__default.FindTokenLenQuoted((s).drop(java.math.BigInteger.ONE)));
    } else {
      return __default.FindTokenLenPlain(s);
    }
  }
  public static java.math.BigInteger FindTokenLenPlain(dafny.DafnySequence<? extends Character> s) {
    java.math.BigInteger _0___accumulator = java.math.BigInteger.ZERO;
    TAIL_CALL_START: while (true) {
      if (((java.math.BigInteger.valueOf((s).length())).signum() == 0) || (__default.IsWhitespace(((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))))) {
        return (java.math.BigInteger.ZERO).add(_0___accumulator);
      } else {
        _0___accumulator = (_0___accumulator).add(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends Character> _in0 = (s).drop(java.math.BigInteger.ONE);
        s = _in0;
        continue TAIL_CALL_START;
      }
    }
  }
  public static java.math.BigInteger FindTokenLenQuoted(dafny.DafnySequence<? extends Character> s) {
    java.math.BigInteger _0___accumulator = java.math.BigInteger.ZERO;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
        return (java.math.BigInteger.ZERO).add(_0___accumulator);
      } else if ((((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) == ('"')) {
        return (java.math.BigInteger.ONE).add(_0___accumulator);
      } else {
        _0___accumulator = (_0___accumulator).add(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends Character> _in0 = (s).drop(java.math.BigInteger.ONE);
        s = _in0;
        continue TAIL_CALL_START;
      }
    }
  }
  @Override
  public java.lang.String toString() {
    return "DdbStatement._default";
  }
}
