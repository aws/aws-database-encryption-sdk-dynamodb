// Class __default
// Dafny class __default compiled into Java
package DynamoDbUpdateExpr_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> ExtractAttributes(dafny.DafnySequence<? extends Character> s, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> ex)
  {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1140_x = __default.ExtractAttrs(s);
    if ((ex).is_None()) {
      return _1140_x;
    } else {
      return __default.Resolve(_1140_x, (ex).dtor_value());
    }
  }
  public static boolean IgnoreAttr(dafny.DafnySequence<? extends Character> s) {
    return (dafny.DafnySequence.of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("SET"), dafny.DafnySequence.asString("REMOVE"), dafny.DafnySequence.asString("ADD"), dafny.DafnySequence.asString("DELETE"), dafny.DafnySequence.asString("list_append"), dafny.DafnySequence.asString("if_not_exists"))).contains(s);
  }
  public static dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> Resolve(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> names, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> ex)
  {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1141___accumulator = dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((names).length())).signum() == 0) {
        return dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(_1141___accumulator, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
      } else if ((ex).<dafny.DafnySequence<? extends Character>>contains(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((names).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) {
        _1141___accumulator = dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(_1141___accumulator, dafny.DafnySequence.of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((ex).get(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((names).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))))));
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in182 = (names).drop(java.math.BigInteger.ONE);
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> _in183 = ex;
        names = _in182;
        ex = _in183;
        continue TAIL_CALL_START;
      } else {
        _1141___accumulator = dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(_1141___accumulator, dafny.DafnySequence.of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((names).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in184 = (names).drop(java.math.BigInteger.ONE);
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> _in185 = ex;
        names = _in184;
        ex = _in185;
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
    dafny.DafnySequence<? extends Character> _1142_s = __default.ChopOne(s, '.');
    return __default.ChopOne(_1142_s, '[');
  }
  public static dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> ExtractAttrs(dafny.DafnySequence<? extends Character> s) {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1143___accumulator = dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
        return dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(_1143___accumulator, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
      } else {
        dafny.Tuple2<java.math.BigInteger, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>> _1144_ret = __default.FindToken(s);
        if (((_1144_ret).dtor__0()).signum() == 0) {
          return dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(_1143___accumulator, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
        } else if (((_1144_ret).dtor__1()).is_None()) {
          dafny.DafnySequence<? extends Character> _in186 = (s).drop((_1144_ret).dtor__0());
          s = _in186;
          continue TAIL_CALL_START;
        } else if (__default.IgnoreAttr(((_1144_ret).dtor__1()).dtor_value())) {
          dafny.DafnySequence<? extends Character> _in187 = (s).drop((_1144_ret).dtor__0());
          s = _in187;
          continue TAIL_CALL_START;
        } else {
          _1143___accumulator = dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(_1143___accumulator, dafny.DafnySequence.of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), __default.Chop(((_1144_ret).dtor__1()).dtor_value())));
          dafny.DafnySequence<? extends Character> _in188 = (s).drop((_1144_ret).dtor__0());
          s = _in188;
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
    } else if ((dafny.DafnySequence.of('[', ']', '.')).contains(ch)) {
      return true;
    } else {
      return false;
    }
  }
  public static java.math.BigInteger AttrLen(dafny.DafnySequence<? extends Character> s) {
    java.math.BigInteger _1145___accumulator = java.math.BigInteger.ZERO;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
        return (java.math.BigInteger.ZERO).add(_1145___accumulator);
      } else if (__default.AttrChar(((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) {
        _1145___accumulator = (java.math.BigInteger.ONE).add(_1145___accumulator);
        dafny.DafnySequence<? extends Character> _in189 = (s).drop(java.math.BigInteger.ONE);
        s = _in189;
        continue TAIL_CALL_START;
      } else {
        return (java.math.BigInteger.ZERO).add(_1145___accumulator);
      }
    }
  }
  public static dafny.Tuple2<java.math.BigInteger, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>> FindToken(dafny.DafnySequence<? extends Character> s) {
    if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
      return dafny.Tuple2.<java.math.BigInteger, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>create(java.math.BigInteger.ZERO, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None());
    } else {
      char _1146_ch = ((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))));
      if ((_1146_ch) == ('#')) {
        java.math.BigInteger _1147_x = (__default.AttrLen((s).drop(java.math.BigInteger.ONE))).add(java.math.BigInteger.ONE);
        return dafny.Tuple2.<java.math.BigInteger, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>create(_1147_x, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some((s).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((_1147_x)))));
      } else if (__default.BadStart(_1146_ch)) {
        java.math.BigInteger _1148_x = (__default.AttrLen((s).drop(java.math.BigInteger.ONE))).add(java.math.BigInteger.ONE);
        return dafny.Tuple2.<java.math.BigInteger, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>create(_1148_x, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None());
      } else if (__default.AttrStart(_1146_ch)) {
        java.math.BigInteger _1149_x = (__default.AttrLen((s).drop(java.math.BigInteger.ONE))).add(java.math.BigInteger.ONE);
        return dafny.Tuple2.<java.math.BigInteger, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>create(_1149_x, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some((s).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((_1149_x)))));
      } else {
        return dafny.Tuple2.<java.math.BigInteger, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>create(java.math.BigInteger.ONE, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None());
      }
    }
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDbUpdateExpr_Compile._default";
  }
}
