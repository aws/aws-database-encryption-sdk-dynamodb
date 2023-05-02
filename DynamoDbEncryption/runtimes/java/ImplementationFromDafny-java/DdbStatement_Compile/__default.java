// Class __default
// Dafny class __default compiled into Java
package DdbStatement_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;
import DynamoDbEncryptionUtil_Compile.*;
import DynamoDbNormalizeNumber_Compile.*;
import DynamoToStruct_Compile.*;
import DynamoDbEncryptionBranchKeyIdSupplier_Compile.*;
import AwsCryptographyDynamoDbEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.*;
import StructuredEncryptionUtil_Compile.*;
import Sets_Compile.*;
import StructuredEncryptionPaths_Compile.*;
import StructuredEncryptionHeader_Compile.*;
import StructuredEncryptionFooter_Compile.*;
import StructuredEncryptionCrypt_Compile.*;
import Maps_Compile.*;
import AwsCryptographyStructuredEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.StructuredEncryption.*;
import TermLoc_Compile.*;
import DdbVirtualFields_Compile.*;
import BaseBeacon_Compile.*;
import CompoundBeacon_Compile.*;
import SearchableEncryptionInfo_Compile.*;
import SearchConfigToInfo_Compile.*;
import DynamoDbUpdateExpr_Compile.*;
import DynamoDBFilterExpr_Compile.*;
import DynamoDBIndexSupport_Compile.*;
import DynamoDBSupport_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.*;
import DynamoDbItemEncryptorUtil_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.*;
import AwsCryptographyDynamoDbEncryptionItemEncryptorOperations_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.*;
import DdbMiddlewareConfig_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static dafny.DafnySequence<? extends Character> UnQuote(dafny.DafnySequence<? extends Character> s) {
    dafny.DafnySequence<? extends Character> _1752_s = ((((java.math.BigInteger.valueOf((s).length())).signum() == 1) && ((((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) == ('"'))) ? ((s).drop(java.math.BigInteger.ONE)) : (s));
    if (((java.math.BigInteger.valueOf((_1752_s).length())).signum() == 1) && ((((char)(java.lang.Object)((_1752_s).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((_1752_s).length())).subtract(java.math.BigInteger.ONE))))))) == ('"'))) {
      return (_1752_s).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt(((java.math.BigInteger.valueOf((_1752_s).length())).subtract(java.math.BigInteger.ONE))));
    } else {
      return _1752_s;
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> GetTableName(dafny.DafnySequence<? extends Character> s) {
    dafny.DafnySequence<? extends Character> _1753_s = __default.UnQuote(s);
    if (Dafny.Com.Amazonaws.Dynamodb.Types.__default.IsValid__TableName(_1753_s)) {
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(_1753_s);
    } else {
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None();
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> TableFromStatement(dafny.DafnySequence<? extends Character> s) {
    Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _1754_ret = __default.TableFromStatementInner(s);
    if ((_1754_ret).is_Some()) {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>create_Success((_1754_ret).dtor_value());
    } else {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("Unable to extract table name from PartiQL statement."));
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> TableFromStatementInner(dafny.DafnySequence<? extends Character> s) {
    dafny.DafnySequence<? extends Character> _1755_s = __default.StripLeadingWhitespace(s);
    if (((java.math.BigInteger.valueOf((_1755_s).length())).compareTo(java.math.BigInteger.valueOf(6L)) > 0) && ((__default.AsciiLower((_1755_s).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((java.math.BigInteger.valueOf(6L)))))).equals(dafny.DafnySequence.asString("exists")))) {
      return __default.TableFromExistsStatement((_1755_s).drop(java.math.BigInteger.valueOf(6L)));
    } else {
      java.math.BigInteger _1756_len = __default.FindTokenLen(_1755_s);
      dafny.DafnySequence<? extends Character> _1757_cmd = __default.AsciiLower((_1755_s).take(_1756_len));
      if ((_1757_cmd).equals(dafny.DafnySequence.asString("select"))) {
        return __default.TableFromSelectStatement((_1755_s).drop(_1756_len));
      } else if ((_1757_cmd).equals(dafny.DafnySequence.asString("update"))) {
        return __default.TableFromUpdateStatement((_1755_s).drop(_1756_len));
      } else if ((_1757_cmd).equals(dafny.DafnySequence.asString("delete"))) {
        return __default.TableFromDeleteStatement((_1755_s).drop(_1756_len));
      } else if ((_1757_cmd).equals(dafny.DafnySequence.asString("insert"))) {
        return __default.TableFromInsertStatement((_1755_s).drop(_1756_len));
      } else {
        return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None();
      }
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> TableFromSelectStatementInner(dafny.DafnySequence<? extends Character> s) {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
        return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None();
      } else {
        dafny.DafnySequence<? extends Character> _1758_t = __default.StripLeadingWhitespace(s);
        java.math.BigInteger _1759_len = __default.FindTokenLen(_1758_t);
        if ((__default.AsciiLower((_1758_t).take(_1759_len))).equals(dafny.DafnySequence.asString("from"))) {
          dafny.DafnySequence<? extends Character> _1760_t = __default.StripLeadingWhitespace((_1758_t).drop(_1759_len));
          java.math.BigInteger _1761_len = __default.FindTokenLen(_1760_t);
          return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some((_1760_t).take(_1761_len));
        } else if ((_1759_len).signum() == 0) {
          return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None();
        } else {
          dafny.DafnySequence<? extends Character> _in404 = (_1758_t).drop(_1759_len);
          s = _in404;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> TableFromExistsStatement(dafny.DafnySequence<? extends Character> s) {
    dafny.DafnySequence<? extends Character> _1762_s = __default.StripLeadingWhitespace(s);
    if (((java.math.BigInteger.valueOf((_1762_s).length())).signum() == 0) || ((((char)(java.lang.Object)((_1762_s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) != ('('))) {
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None();
    } else {
      dafny.DafnySequence<? extends Character> _1763_s = __default.StripLeadingWhitespace((_1762_s).drop(java.math.BigInteger.ONE));
      java.math.BigInteger _1764_len = __default.FindTokenLen(_1763_s);
      if ((__default.AsciiLower((_1763_s).take(_1764_len))).equals(dafny.DafnySequence.asString("select"))) {
        return __default.TableFromSelectStatement((_1763_s).drop(_1764_len));
      } else {
        return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None();
      }
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> TableFromSelectStatement(dafny.DafnySequence<? extends Character> s) {
    Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _1765_valueOrError0 = __default.TableFromSelectStatementInner(s);
    if ((_1765_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_1765_valueOrError0).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Com.Amazonaws.Dynamodb.Types.TableName._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends Character> _1766_name = (_1765_valueOrError0).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      if ((_1766_name).contains('.')) {
        dafny.Tuple2<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _1767_x = StandardLibrary_Compile.__default.<Character>SplitOnce(dafny.TypeDescriptor.CHAR, _1766_name, '.');
        return __default.GetTableName((_1767_x).dtor__0());
      } else {
        return __default.GetTableName(_1766_name);
      }
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> TableFromUpdateStatement(dafny.DafnySequence<? extends Character> s) {
    dafny.DafnySequence<? extends Character> _1768_s = __default.StripLeadingWhitespace(s);
    java.math.BigInteger _1769_len = __default.FindTokenLen(_1768_s);
    if ((_1769_len).signum() == 0) {
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None();
    } else {
      return __default.GetTableName((_1768_s).take(_1769_len));
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> TableFromDeleteStatement(dafny.DafnySequence<? extends Character> s) {
    dafny.DafnySequence<? extends Character> _1770_s = __default.StripLeadingWhitespace(s);
    java.math.BigInteger _1771_len = __default.FindTokenLen(_1770_s);
    if (!(__default.AsciiLower((_1770_s).take(_1771_len))).equals(dafny.DafnySequence.asString("from"))) {
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None();
    } else {
      dafny.DafnySequence<? extends Character> _1772_s = __default.StripLeadingWhitespace((_1770_s).drop(_1771_len));
      java.math.BigInteger _1773_len = __default.FindTokenLen(_1772_s);
      if ((_1773_len).signum() == 0) {
        return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None();
      } else {
        return __default.GetTableName((_1772_s).take(_1773_len));
      }
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> TableFromInsertStatement(dafny.DafnySequence<? extends Character> s) {
    dafny.DafnySequence<? extends Character> _1774_s = __default.StripLeadingWhitespace(s);
    java.math.BigInteger _1775_len = __default.FindTokenLen(_1774_s);
    if (!(__default.AsciiLower((_1774_s).take(_1775_len))).equals(dafny.DafnySequence.asString("into"))) {
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None();
    } else {
      dafny.DafnySequence<? extends Character> _1776_s = __default.StripLeadingWhitespace((_1774_s).drop(_1775_len));
      java.math.BigInteger _1777_len = __default.FindTokenLen(_1776_s);
      if ((_1777_len).signum() == 0) {
        return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None();
      } else {
        return __default.GetTableName((_1776_s).take(_1777_len));
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
        dafny.DafnySequence<? extends Character> _in405 = (s).drop(java.math.BigInteger.ONE);
        s = _in405;
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
    dafny.DafnySequence<? extends Character> _1778___accumulator = dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR);
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
        return dafny.DafnySequence.<Character>concatenate(_1778___accumulator, s);
      } else {
        _1778___accumulator = dafny.DafnySequence.<Character>concatenate(_1778___accumulator, dafny.DafnySequence.of(__default.AsciiLowerChar(((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))));
        dafny.DafnySequence<? extends Character> _in406 = (s).drop(java.math.BigInteger.ONE);
        s = _in406;
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
    java.math.BigInteger _1779___accumulator = java.math.BigInteger.ZERO;
    TAIL_CALL_START: while (true) {
      if (((java.math.BigInteger.valueOf((s).length())).signum() == 0) || (__default.IsWhitespace(((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))))) {
        return (java.math.BigInteger.ZERO).add(_1779___accumulator);
      } else {
        _1779___accumulator = (_1779___accumulator).add(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends Character> _in407 = (s).drop(java.math.BigInteger.ONE);
        s = _in407;
        continue TAIL_CALL_START;
      }
    }
  }
  public static java.math.BigInteger FindTokenLenQuoted(dafny.DafnySequence<? extends Character> s) {
    java.math.BigInteger _1780___accumulator = java.math.BigInteger.ZERO;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
        return (java.math.BigInteger.ZERO).add(_1780___accumulator);
      } else if ((((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) == ('"')) {
        return (java.math.BigInteger.ONE).add(_1780___accumulator);
      } else {
        _1780___accumulator = (_1780___accumulator).add(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends Character> _in408 = (s).drop(java.math.BigInteger.ONE);
        s = _in408;
        continue TAIL_CALL_START;
      }
    }
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "DdbStatement_Compile._default";
  }
}
