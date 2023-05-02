// Class __default
// Dafny class __default compiled into Java
package DynamoDBFilterExpr_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> ExtractAttributes(dafny.DafnySequence<? extends Character> s, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> ex)
  {
    dafny.DafnySequence<? extends Token> _1150_tokens = __default.ParseExpr(s);
    return __default.ExtractAttributes2(_1150_tokens, ex, java.math.BigInteger.valueOf(-1L));
  }
  public static boolean IsSpecial(Token t) {
    return (((t).is_AttributeExists()) || ((t).is_AttributeNotExists())) || ((t).is_Size());
  }
  public static dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> ExtractAttributes2(dafny.DafnySequence<? extends Token> tokens, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> ex, java.math.BigInteger tokensUntilSkip)
  {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1151___accumulator = dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((tokens).length())).signum() == 0) {
        return dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(_1151___accumulator, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
      } else if (__default.IsSpecial(((Token)(java.lang.Object)((tokens).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) {
        dafny.DafnySequence<? extends Token> _in190 = (tokens).drop(java.math.BigInteger.ONE);
        Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in191 = ex;
        java.math.BigInteger _in192 = java.math.BigInteger.ONE;
        tokens = _in190;
        ex = _in191;
        tokensUntilSkip = _in192;
        continue TAIL_CALL_START;
      } else if (((((Token)(java.lang.Object)((tokens).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).is_Attr()) && ((tokensUntilSkip).signum() == 0)) {
        dafny.DafnySequence<? extends Token> _in193 = (tokens).drop(java.math.BigInteger.ONE);
        Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in194 = ex;
        java.math.BigInteger _in195 = java.math.BigInteger.valueOf(-1L);
        tokens = _in193;
        ex = _in194;
        tokensUntilSkip = _in195;
        continue TAIL_CALL_START;
      } else if ((((Token)(java.lang.Object)((tokens).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).is_Attr()) {
        _1151___accumulator = dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(_1151___accumulator, dafny.DafnySequence.of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), __default.GetName((((Token)(java.lang.Object)((tokens).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_s(), ex)));
        dafny.DafnySequence<? extends Token> _in196 = (tokens).drop(java.math.BigInteger.ONE);
        Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in197 = ex;
        java.math.BigInteger _in198 = java.math.BigInteger.valueOf(-1L);
        tokens = _in196;
        ex = _in197;
        tokensUntilSkip = _in198;
        continue TAIL_CALL_START;
      } else {
        dafny.DafnySequence<? extends Token> _in199 = (tokens).drop(java.math.BigInteger.ONE);
        Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in200 = ex;
        java.math.BigInteger _in201 = (tokensUntilSkip).subtract(java.math.BigInteger.ONE);
        tokens = _in199;
        ex = _in200;
        tokensUntilSkip = _in201;
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
    Token _source16 = t;
    if (_source16.is_Attr()) {
      dafny.DafnySequence<? extends Character> _1152___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source16)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1153___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source16)._loc;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1154_l = _1153___mcc_h1;
      dafny.DafnySequence<? extends Character> _1155_s = _1152___mcc_h0;
      return _1155_s;
    } else if (_source16.is_Value()) {
      dafny.DafnySequence<? extends Character> _1156___mcc_h2 = ((DynamoDBFilterExpr_Compile.Token_Value)_source16)._s;
      dafny.DafnySequence<? extends Character> _1157_s = _1156___mcc_h2;
      return _1157_s;
    } else if (_source16.is_Eq()) {
      return dafny.DafnySequence.asString("=");
    } else if (_source16.is_Ne()) {
      return dafny.DafnySequence.asString("<>");
    } else if (_source16.is_Lt()) {
      return dafny.DafnySequence.asString("<");
    } else if (_source16.is_Gt()) {
      return dafny.DafnySequence.asString(">");
    } else if (_source16.is_Le()) {
      return dafny.DafnySequence.asString("<=");
    } else if (_source16.is_Ge()) {
      return dafny.DafnySequence.asString(">=");
    } else if (_source16.is_Between()) {
      return dafny.DafnySequence.asString("BETWEEN");
    } else if (_source16.is_In()) {
      return dafny.DafnySequence.asString("IN");
    } else if (_source16.is_Open()) {
      return dafny.DafnySequence.asString("(");
    } else if (_source16.is_Close()) {
      return dafny.DafnySequence.asString(")");
    } else if (_source16.is_Comma()) {
      return dafny.DafnySequence.asString(",");
    } else if (_source16.is_Not()) {
      return dafny.DafnySequence.asString("NOT");
    } else if (_source16.is_And()) {
      return dafny.DafnySequence.asString("AND");
    } else if (_source16.is_Or()) {
      return dafny.DafnySequence.asString("OR");
    } else if (_source16.is_AttributeExists()) {
      return dafny.DafnySequence.asString("attribute_exists");
    } else if (_source16.is_AttributeNotExists()) {
      return dafny.DafnySequence.asString("attribute_not_exists");
    } else if (_source16.is_AttributeType()) {
      return dafny.DafnySequence.asString("attribute_type");
    } else if (_source16.is_BeginsWith()) {
      return dafny.DafnySequence.asString("begins_with");
    } else if (_source16.is_Contains()) {
      return dafny.DafnySequence.asString("contains");
    } else {
      return dafny.DafnySequence.asString("size");
    }
  }
  public static Wrappers_Compile.Option<java.math.BigInteger> GetInPos(dafny.DafnySequence<? extends Token> expr, java.math.BigInteger pos)
  {
    TAIL_CALL_START: while (true) {
      if ((pos).compareTo(java.math.BigInteger.ONE) < 0) {
        return Wrappers_Compile.Option.<java.math.BigInteger>create_None();
      } else if ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).is_In()) {
        return Wrappers_Compile.Option.<java.math.BigInteger>create_Some(pos);
      } else if (!((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).is_Value())) {
        return Wrappers_Compile.Option.<java.math.BigInteger>create_None();
      } else if ((pos).compareTo(java.math.BigInteger.valueOf(2L)) < 0) {
        return Wrappers_Compile.Option.<java.math.BigInteger>create_None();
      } else if ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))).is_In()) {
        return Wrappers_Compile.Option.<java.math.BigInteger>create_Some((pos).subtract(java.math.BigInteger.ONE));
      } else if (!((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))).is_Comma())) {
        return Wrappers_Compile.Option.<java.math.BigInteger>create_None();
      } else {
        dafny.DafnySequence<? extends Token> _in202 = expr;
        java.math.BigInteger _in203 = (pos).subtract(java.math.BigInteger.valueOf(2L));
        expr = _in202;
        pos = _in203;
        continue TAIL_CALL_START;
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
      dafny.DafnySequence<? extends Character> _1158_name = __default.RealName((t).dtor_s());
      return (((b).dtor_beacons()).<dafny.DafnySequence<? extends Character>>contains(_1158_name)) || ((((names).is_Some()) && (((names).dtor_value()).<dafny.DafnySequence<? extends Character>>contains(_1158_name))) && (((b).dtor_beacons()).<dafny.DafnySequence<? extends Character>>contains(__default.RealName(((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((names).dtor_value()).get(_1158_name)))))));
    } else {
      return false;
    }
  }
  public static SearchableEncryptionInfo_Compile.Beacon GetBeacon2(SearchableEncryptionInfo_Compile.BeaconVersion b, Token t, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names)
  {
    dafny.DafnySequence<? extends Character> _1159_name = __default.RealName((t).dtor_s());
    if (((b).dtor_beacons()).<dafny.DafnySequence<? extends Character>>contains(_1159_name)) {
      return ((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)(((b).dtor_beacons()).get(_1159_name)));
    } else {
      dafny.DafnySequence<? extends Character> _1160_name2 = __default.RealName(((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((names).dtor_value()).get(_1159_name))));
      return ((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)(((b).dtor_beacons()).get(_1160_name2)));
    }
  }
  public static Wrappers_Compile.Result<EqualityBeacon, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GetBeacon(SearchableEncryptionInfo_Compile.BeaconVersion bv, Token t, Token op, Token value, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> values)
  {
    SearchableEncryptionInfo_Compile.Beacon _1161_b = __default.GetBeacon2(bv, t, names);
    Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1162_valueOrError0 = __default.CanBeacon(_1161_b, op, (value).dtor_s(), values);
    if ((_1162_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_1162_valueOrError0).<EqualityBeacon>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), EqualityBeacon._typeDescriptor());
    } else {
      boolean _1163___v0 = (_1162_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<EqualityBeacon, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.EqualityBeacon.create(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.Beacon>create_Some(_1161_b), __default.IsEquality(op)));
    }
  }
  public static Wrappers_Compile.Result<EqualityBeacon, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GetBetweenBeacon(SearchableEncryptionInfo_Compile.BeaconVersion bv, Token t, Token op, Token leftValue, Token rightValue, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> values)
  {
    SearchableEncryptionInfo_Compile.Beacon _1164_b = __default.GetBeacon2(bv, t, names);
    Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1165_valueOrError0 = __default.CanBetween(_1164_b, op, (leftValue).dtor_s(), (rightValue).dtor_s(), values);
    if ((_1165_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_1165_valueOrError0).<EqualityBeacon>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), EqualityBeacon._typeDescriptor());
    } else {
      boolean _1166___v1 = (_1165_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<EqualityBeacon, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.EqualityBeacon.create(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.Beacon>create_Some(_1164_b), false));
    }
  }
  public static Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> CanStandardBeacon(Token op) {
    Token _source17 = op;
    if (_source17.is_Attr()) {
      dafny.DafnySequence<? extends Character> _1167___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source17)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1168___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source17)._loc;
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source17.is_Value()) {
      dafny.DafnySequence<? extends Character> _1169___mcc_h4 = ((DynamoDBFilterExpr_Compile.Token_Value)_source17)._s;
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source17.is_Eq()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source17.is_Ne()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source17.is_Lt()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The operation '"), __default.TokenToString(op)), dafny.DafnySequence.asString("' cannot be used with a standard beacon."))));
    } else if (_source17.is_Gt()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The operation '"), __default.TokenToString(op)), dafny.DafnySequence.asString("' cannot be used with a standard beacon."))));
    } else if (_source17.is_Le()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The operation '"), __default.TokenToString(op)), dafny.DafnySequence.asString("' cannot be used with a standard beacon."))));
    } else if (_source17.is_Ge()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The operation '"), __default.TokenToString(op)), dafny.DafnySequence.asString("' cannot be used with a standard beacon."))));
    } else if (_source17.is_Between()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The operation '"), __default.TokenToString(op)), dafny.DafnySequence.asString("' cannot be used with a standard beacon."))));
    } else if (_source17.is_In()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source17.is_Open()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source17.is_Close()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source17.is_Comma()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source17.is_Not()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source17.is_And()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source17.is_Or()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source17.is_AttributeExists()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source17.is_AttributeNotExists()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source17.is_AttributeType()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source17.is_BeginsWith()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The operation '"), __default.TokenToString(op)), dafny.DafnySequence.asString("' cannot be used with a standard beacon."))));
    } else if (_source17.is_Contains()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The operation '"), __default.TokenToString(op)), dafny.DafnySequence.asString("' cannot be used with a standard beacon."))));
    } else {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    }
  }
  public static Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> CanCompoundBeacon(SearchableEncryptionInfo_Compile.Beacon b, Token op, dafny.DafnySequence<? extends Character> value)
  {
    Token _source18 = op;
    if (_source18.is_Attr()) {
      dafny.DafnySequence<? extends Character> _1170___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source18)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1171___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source18)._loc;
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source18.is_Value()) {
      dafny.DafnySequence<? extends Character> _1172___mcc_h4 = ((DynamoDBFilterExpr_Compile.Token_Value)_source18)._s;
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source18.is_Eq()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source18.is_Ne()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source18.is_Lt()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1173_pieces = StandardLibrary_Compile.__default.<Character>Split(dafny.TypeDescriptor.CHAR, value, ((b).dtor_cmp()).dtor_split());
      Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1174_valueOrError0 = ((b).dtor_cmp()).IsLessThanComparable(_1173_pieces);
      if ((_1174_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1174_valueOrError0).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      } else {
        boolean _1175_canLess = (_1174_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        if (_1175_canLess) {
          return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
        } else {
          return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The operation '"), __default.TokenToString(op)), dafny.DafnySequence.asString("' cannot be used with a compound beacon, unless the value is LessThanComparable : ")), value)));
        }
      }
    } else if (_source18.is_Gt()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1176_pieces = StandardLibrary_Compile.__default.<Character>Split(dafny.TypeDescriptor.CHAR, value, ((b).dtor_cmp()).dtor_split());
      Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1177_valueOrError0 = ((b).dtor_cmp()).IsLessThanComparable(_1176_pieces);
      if ((_1177_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1177_valueOrError0).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      } else {
        boolean _1178_canLess = (_1177_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        if (_1178_canLess) {
          return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
        } else {
          return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The operation '"), __default.TokenToString(op)), dafny.DafnySequence.asString("' cannot be used with a compound beacon, unless the value is LessThanComparable : ")), value)));
        }
      }
    } else if (_source18.is_Le()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1179_pieces = StandardLibrary_Compile.__default.<Character>Split(dafny.TypeDescriptor.CHAR, value, ((b).dtor_cmp()).dtor_split());
      Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1180_valueOrError0 = ((b).dtor_cmp()).IsLessThanComparable(_1179_pieces);
      if ((_1180_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1180_valueOrError0).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      } else {
        boolean _1181_canLess = (_1180_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        if (_1181_canLess) {
          return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
        } else {
          return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The operation '"), __default.TokenToString(op)), dafny.DafnySequence.asString("' cannot be used with a compound beacon, unless the value is LessThanComparable : ")), value)));
        }
      }
    } else if (_source18.is_Ge()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1182_pieces = StandardLibrary_Compile.__default.<Character>Split(dafny.TypeDescriptor.CHAR, value, ((b).dtor_cmp()).dtor_split());
      Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1183_valueOrError0 = ((b).dtor_cmp()).IsLessThanComparable(_1182_pieces);
      if ((_1183_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1183_valueOrError0).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      } else {
        boolean _1184_canLess = (_1183_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        if (_1184_canLess) {
          return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
        } else {
          return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The operation '"), __default.TokenToString(op)), dafny.DafnySequence.asString("' cannot be used with a compound beacon, unless the value is LessThanComparable : ")), value)));
        }
      }
    } else if (_source18.is_Between()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source18.is_In()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source18.is_Open()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source18.is_Close()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source18.is_Comma()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source18.is_Not()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source18.is_And()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source18.is_Or()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source18.is_AttributeExists()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source18.is_AttributeNotExists()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source18.is_AttributeType()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source18.is_BeginsWith()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else if (_source18.is_Contains()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GetStringFromValue(dafny.DafnySequence<? extends Character> value, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> values, SearchableEncryptionInfo_Compile.Beacon b)
  {
    if ((values).<dafny.DafnySequence<? extends Character>>contains(value)) {
      Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _1185_val = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue)(java.lang.Object)((values).get(value)));
      if ((_1185_val).is_S()) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success((_1185_val).dtor_S());
      } else {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Value "), value), dafny.DafnySequence.asString(" supplied for compound beacon ")), (((b).dtor_cmp()).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" is of type ")), DynamoDbEncryptionUtil_Compile.__default.AttrTypeToStr(_1185_val)), dafny.DafnySequence.asString(" but must be of type S (string)."))));
      }
    } else {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Value "), value), dafny.DafnySequence.asString(" used in query string, but not supplied in value map."))));
    }
  }
  public static Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> CanBeacon(SearchableEncryptionInfo_Compile.Beacon b, Token op, dafny.DafnySequence<? extends Character> value, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> values)
  {
    if ((b).is_Standard()) {
      return __default.CanStandardBeacon(op);
    } else {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1186_valueOrError0 = __default.GetStringFromValue(value, values, b);
      if ((_1186_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1186_valueOrError0).<Boolean>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      } else {
        dafny.DafnySequence<? extends Character> _1187_val = (_1186_valueOrError0).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        return __default.CanCompoundBeacon(b, op, _1187_val);
      }
    }
  }
  public static dafny.Tuple2<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> RemoveCommonPrefix(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> x, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> y)
  {
    TAIL_CALL_START: while (true) {
      if ((((java.math.BigInteger.valueOf((x).length())).signum() == 0) || ((java.math.BigInteger.valueOf((y).length())).signum() == 0)) || (!(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((x).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).equals(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((y).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))))) {
        return dafny.Tuple2.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>create(x, y);
      } else {
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in204 = (x).drop(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in205 = (y).drop(java.math.BigInteger.ONE);
        x = _in204;
        y = _in205;
        continue TAIL_CALL_START;
      }
    }
  }
  public static Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> CanBetween(SearchableEncryptionInfo_Compile.Beacon b, Token op, dafny.DafnySequence<? extends Character> leftValue, dafny.DafnySequence<? extends Character> rightValue, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> values)
  {
    if ((b).is_Standard()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("The operation BETWEEN cannot be used with a standard beacon.")));
    } else {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1188_valueOrError0 = __default.GetStringFromValue(leftValue, values, b);
      if ((_1188_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1188_valueOrError0).<Boolean>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      } else {
        dafny.DafnySequence<? extends Character> _1189_leftVal = (_1188_valueOrError0).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1190_valueOrError1 = __default.GetStringFromValue(rightValue, values, b);
        if ((_1190_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_1190_valueOrError1).<Boolean>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
        } else {
          dafny.DafnySequence<? extends Character> _1191_rightVal = (_1190_valueOrError1).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1192_leftParts = StandardLibrary_Compile.__default.<Character>Split(dafny.TypeDescriptor.CHAR, _1189_leftVal, ((b).dtor_cmp()).dtor_split());
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1193_rightParts = StandardLibrary_Compile.__default.<Character>Split(dafny.TypeDescriptor.CHAR, _1191_rightVal, ((b).dtor_cmp()).dtor_split());
          dafny.Tuple2<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> _let_tmp_rhs4 = __default.RemoveCommonPrefix(_1192_leftParts, _1193_rightParts);
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1194_newLeft = ((dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>)(java.lang.Object)(((dafny.Tuple2<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>)_let_tmp_rhs4).dtor__0()));
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1195_newRight = ((dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>)(java.lang.Object)(((dafny.Tuple2<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>)_let_tmp_rhs4).dtor__1()));
          Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1196_valueOrError2 = ((b).dtor_cmp()).IsLessThanComparable(_1194_newLeft);
          if ((_1196_valueOrError2).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
            return (_1196_valueOrError2).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
          } else {
            boolean _1197_leftCanLess = (_1196_valueOrError2).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
            Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1198_valueOrError3 = ((b).dtor_cmp()).IsLessThanComparable(_1195_newRight);
            if ((_1198_valueOrError3).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
              return (_1198_valueOrError3).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
            } else {
              boolean _1199_rightCanLess = (_1198_valueOrError3).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
              Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1200_valueOrError4 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), (_1197_leftCanLess) && (_1199_rightCanLess), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("To use BETWEEN with a compound beacon, the part after any common prefix must be LessThanComparable : "), dafny.DafnySequence.asString("BETWEEN ")), _1189_leftVal), dafny.DafnySequence.asString(" AND ")), _1191_rightVal)));
              if ((_1200_valueOrError4).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
                return (_1200_valueOrError4).<Boolean>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
              } else {
                return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
              }
            }
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<EqualityBeacon, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> BeaconForValue(SearchableEncryptionInfo_Compile.BeaconVersion b, dafny.DafnySequence<? extends Token> expr, java.math.BigInteger pos, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> values)
  {
    if (((((pos).add(java.math.BigInteger.valueOf(2L))).compareTo(java.math.BigInteger.valueOf((expr).length())) < 0) && (__default.IsComp(((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).add(java.math.BigInteger.ONE))))))))) && (__default.HasBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).add(java.math.BigInteger.valueOf(2L))))))), names))) {
      return __default.GetBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).add(java.math.BigInteger.valueOf(2L))))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).add(java.math.BigInteger.ONE)))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos))))), names, values);
    } else if ((((java.math.BigInteger.valueOf(2L)).compareTo(pos) <= 0) && (__default.IsComp(((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))))) && (__default.HasBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))), names))) {
      return __default.GetBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE)))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos))))), names, values);
    } else if ((((((java.math.BigInteger.valueOf(4L)).compareTo(pos) <= 0) && (((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(4L)))))))).is_Contains()) || ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(4L)))))))).is_BeginsWith()))) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(3L)))))))).is_Open())) && (__default.HasBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))), names))) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))).is_Comma())) {
      return __default.GetBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(4L))))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos))))), names, values);
    } else if ((((((java.math.BigInteger.valueOf(2L)).compareTo(pos) <= 0) && ((pos).compareTo((java.math.BigInteger.valueOf((expr).length())).subtract(java.math.BigInteger.valueOf(2L))) < 0)) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))).is_Between())) && (__default.HasBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))), names))) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).add(java.math.BigInteger.valueOf(2L)))))))).is_Value())) {
      return __default.GetBetweenBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE)))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).add(java.math.BigInteger.valueOf(2L))))))), names, values);
    } else if ((((((java.math.BigInteger.valueOf(4L)).compareTo(pos) <= 0) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))).is_And())) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(3L)))))))).is_Between())) && (__default.HasBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(4L))))))), names))) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L)))))))).is_Value())) {
      return __default.GetBetweenBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(4L))))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(3L))))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos))))), names, values);
    } else if ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).is_Value()) {
      Wrappers_Compile.Option<java.math.BigInteger> _1201_in__pos = __default.GetInPos(expr, pos);
      if ((_1201_in__pos).is_None()) {
        return Wrappers_Compile.Result.<EqualityBeacon, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.EqualityBeacon.create(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.Beacon>create_None(), true));
      } else if (__default.HasBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((((_1201_in__pos).dtor_value()).subtract(java.math.BigInteger.ONE)))))), names)) {
        return __default.GetBeacon(b, ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((((_1201_in__pos).dtor_value()).subtract(java.math.BigInteger.ONE)))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((_1201_in__pos).dtor_value()))))), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos))))), names, values);
      } else {
        return Wrappers_Compile.Result.<EqualityBeacon, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.EqualityBeacon.create(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.Beacon>create_None(), true));
      }
    } else {
      return Wrappers_Compile.Result.<EqualityBeacon, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.EqualityBeacon.create(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.Beacon>create_None(), true));
    }
  }
  public static Wrappers_Compile.Option<Token> AttrForValue(dafny.DafnySequence<? extends Token> expr, java.math.BigInteger pos)
  {
    if (((((pos).add(java.math.BigInteger.valueOf(2L))).compareTo(java.math.BigInteger.valueOf((expr).length())) < 0) && (__default.IsComp(((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).add(java.math.BigInteger.ONE))))))))) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).add(java.math.BigInteger.valueOf(2L)))))))).is_Attr())) {
      return Wrappers_Compile.Option.<Token>create_Some(((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).add(java.math.BigInteger.valueOf(2L))))))));
    } else if ((((java.math.BigInteger.valueOf(2L)).compareTo(pos) <= 0) && (__default.IsComp(((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))))) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L)))))))).is_Attr())) {
      return Wrappers_Compile.Option.<Token>create_Some(((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))));
    } else if ((((((java.math.BigInteger.valueOf(4L)).compareTo(pos) <= 0) && (((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(4L)))))))).is_Contains()) || ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(4L)))))))).is_BeginsWith()))) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(3L)))))))).is_Open())) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L)))))))).is_Attr())) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))).is_Comma())) {
      return Wrappers_Compile.Option.<Token>create_Some(((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))));
    } else if ((((java.math.BigInteger.valueOf(2L)).compareTo(pos) <= 0) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))).is_Between())) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L)))))))).is_Attr())) {
      return Wrappers_Compile.Option.<Token>create_Some(((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))));
    } else if (((((java.math.BigInteger.valueOf(4L)).compareTo(pos) <= 0) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.ONE))))))).is_And())) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(3L)))))))).is_Between())) && ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(4L)))))))).is_Attr())) {
      return Wrappers_Compile.Option.<Token>create_Some(((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(4L))))))));
    } else {
      Wrappers_Compile.Option<java.math.BigInteger> _1202_in__pos = __default.GetInPos(expr, pos);
      if ((_1202_in__pos).is_None()) {
        return Wrappers_Compile.Option.<Token>create_None();
      } else if ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((((_1202_in__pos).dtor_value()).subtract(java.math.BigInteger.ONE))))))).is_Attr()) {
        return Wrappers_Compile.Option.<Token>create_Some(((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((((_1202_in__pos).dtor_value()).subtract(java.math.BigInteger.ONE)))))));
      } else {
        return Wrappers_Compile.Option.<Token>create_None();
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
  public static Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> IsAllowedOnBeacon(dafny.DafnySequence<? extends Token> expr, java.math.BigInteger pos, dafny.DafnySequence<? extends Character> name)
  {
    if (__default.IsAllowedOnBeaconPred(expr, pos)) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Function "), __default.TokenToString(((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt(((pos).subtract(java.math.BigInteger.valueOf(2L))))))))), dafny.DafnySequence.asString(" cannot be used on encrypted fields, but it is being used with ")), name)));
    }
  }
  public static boolean TokenNeedsBeacon(Token t) {
    return !(((t).is_AttributeExists()) || ((t).is_AttributeNotExists()));
  }
  public static boolean TokenAllowsBeacon(Token t) {
    return !(((t).is_AttributeType()) || ((t).is_Size()));
  }
  public static Wrappers_Compile.Result<ParsedContext, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> BeaconizeParsedExpr(SearchableEncryptionInfo_Compile.BeaconVersion b, dafny.DafnySequence<? extends Token> expr, java.math.BigInteger pos, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> oldValues, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> newValues, dafny.DafnySequence<? extends Token> acc)
  {
    TAIL_CALL_START: while (true) {
      if (java.util.Objects.equals(pos, java.math.BigInteger.valueOf((expr).length()))) {
        return Wrappers_Compile.Result.<ParsedContext, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.ParsedContext.create(acc, newValues, names));
      } else if ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).is_Attr()) {
        boolean _1203_isIndirectName = (dafny.DafnySequence.asString("#")).isPrefixOf((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).dtor_s());
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1204_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), (!(_1203_isIndirectName)) || (((names).is_Some()) && (((names).dtor_value()).<dafny.DafnySequence<? extends Character>>contains((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).dtor_s()))), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Name "), (((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).dtor_s()), dafny.DafnySequence.asString(" not in ExpressionAttributeNameMap."))));
        if ((_1204_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_1204_valueOrError0).<ParsedContext>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ParsedContext._typeDescriptor());
        } else {
          dafny.DafnySequence<? extends Character> _1205_oldName = ((_1203_isIndirectName) ? (((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((names).dtor_value()).get((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).dtor_s())))) : ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).dtor_s()));
          boolean _1206_exclude = ((keys).is_DontUseKeys()) && (!(__default.IsAllowedOnBeaconPred(expr, pos)));
          if (((b).IsBeacon(_1205_oldName)) && (!(_1206_exclude))) {
            Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1207_valueOrError1 = __default.IsAllowedOnBeacon(expr, pos, _1205_oldName);
            if ((_1207_valueOrError1).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
              return (_1207_valueOrError1).<ParsedContext>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ParsedContext._typeDescriptor());
            } else {
              boolean _1208___v4 = (_1207_valueOrError1).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
              if (__default.OpNeedsBeacon(expr, pos)) {
                dafny.DafnySequence<? extends Character> _1209_newName = (((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)(((b).dtor_beacons()).get(_1205_oldName)))).getBeaconName();
                if (_1203_isIndirectName) {
                  SearchableEncryptionInfo_Compile.BeaconVersion _in206 = b;
                  dafny.DafnySequence<? extends Token> _in207 = expr;
                  java.math.BigInteger _in208 = (pos).add(java.math.BigInteger.ONE);
                  dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in209 = oldValues;
                  Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in210 = Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>update((names).dtor_value(), (((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).dtor_s(), _1209_newName));
                  DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in211 = keys;
                  dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in212 = newValues;
                  dafny.DafnySequence<? extends Token> _in213 = dafny.DafnySequence.<Token>concatenate(acc, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))));
                  b = _in206;
                  expr = _in207;
                  pos = _in208;
                  oldValues = _in209;
                  names = _in210;
                  keys = _in211;
                  newValues = _in212;
                  acc = _in213;
                  continue TAIL_CALL_START;
                } else {
                  SearchableEncryptionInfo_Compile.BeaconVersion _in214 = b;
                  dafny.DafnySequence<? extends Token> _in215 = expr;
                  java.math.BigInteger _in216 = (pos).add(java.math.BigInteger.ONE);
                  dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in217 = oldValues;
                  Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in218 = names;
                  DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in219 = keys;
                  dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in220 = newValues;
                  dafny.DafnySequence<? extends Token> _in221 = dafny.DafnySequence.<Token>concatenate(acc, dafny.DafnySequence.of(Token._typeDescriptor(), DynamoDBFilterExpr_Compile.Token.create_Attr(_1209_newName, TermLoc_Compile.__default.TermLocMap(_1209_newName))));
                  b = _in214;
                  expr = _in215;
                  pos = _in216;
                  oldValues = _in217;
                  names = _in218;
                  keys = _in219;
                  newValues = _in220;
                  acc = _in221;
                  continue TAIL_CALL_START;
                }
              } else {
                SearchableEncryptionInfo_Compile.BeaconVersion _in222 = b;
                dafny.DafnySequence<? extends Token> _in223 = expr;
                java.math.BigInteger _in224 = (pos).add(java.math.BigInteger.ONE);
                dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in225 = oldValues;
                Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in226 = names;
                DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in227 = keys;
                dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in228 = newValues;
                dafny.DafnySequence<? extends Token> _in229 = dafny.DafnySequence.<Token>concatenate(acc, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))));
                b = _in222;
                expr = _in223;
                pos = _in224;
                oldValues = _in225;
                names = _in226;
                keys = _in227;
                newValues = _in228;
                acc = _in229;
                continue TAIL_CALL_START;
              }
            }
          } else {
            SearchableEncryptionInfo_Compile.BeaconVersion _in230 = b;
            dafny.DafnySequence<? extends Token> _in231 = expr;
            java.math.BigInteger _in232 = (pos).add(java.math.BigInteger.ONE);
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in233 = oldValues;
            Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in234 = names;
            DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in235 = keys;
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in236 = newValues;
            dafny.DafnySequence<? extends Token> _in237 = dafny.DafnySequence.<Token>concatenate(acc, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))));
            b = _in230;
            expr = _in231;
            pos = _in232;
            oldValues = _in233;
            names = _in234;
            keys = _in235;
            newValues = _in236;
            acc = _in237;
            continue TAIL_CALL_START;
          }
        }
      } else if ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).is_Value()) {
        dafny.DafnySequence<? extends Character> _1210_name = (((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).dtor_s();
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1211_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), (oldValues).<dafny.DafnySequence<? extends Character>>contains(_1210_name), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(_1210_name, dafny.DafnySequence.asString(" not found in ExpressionAttributeValueMap"))));
        if ((_1211_valueOrError2).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_1211_valueOrError2).<ParsedContext>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ParsedContext._typeDescriptor());
        } else {
          Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _1212_oldValue = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue)(java.lang.Object)((oldValues).get(_1210_name)));
          Wrappers_Compile.Result<EqualityBeacon, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1213_valueOrError3 = __default.BeaconForValue(b, expr, pos, names, oldValues);
          if ((_1213_valueOrError3).IsFailure(EqualityBeacon._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
            return (_1213_valueOrError3).<ParsedContext>PropagateFailure(EqualityBeacon._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ParsedContext._typeDescriptor());
          } else {
            EqualityBeacon _1214_eb = (_1213_valueOrError3).Extract(EqualityBeacon._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
            Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1215_valueOrError4 = ((((_1214_eb).dtor_beacon()).is_None()) ? (Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(_1212_oldValue)) : ((((_1214_eb).dtor_beacon()).dtor_value()).GetBeaconValue(_1212_oldValue, keys, (_1214_eb).dtor_forEquality())));
            if ((_1215_valueOrError4).IsFailure(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
              return (_1215_valueOrError4).<ParsedContext>PropagateFailure(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ParsedContext._typeDescriptor());
            } else {
              Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _1216_newValue = (_1215_valueOrError4).Extract(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
              Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1217_valueOrError5 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), (!(newValues).<dafny.DafnySequence<? extends Character>>contains(_1210_name)) || (java.util.Objects.equals(((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue)(java.lang.Object)((newValues).get(_1210_name))), _1216_newValue)), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(_1210_name, dafny.DafnySequence.asString(" used in two different contexts, which is not allowed."))));
              if ((_1217_valueOrError5).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
                return (_1217_valueOrError5).<ParsedContext>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ParsedContext._typeDescriptor());
              } else {
                SearchableEncryptionInfo_Compile.BeaconVersion _in238 = b;
                dafny.DafnySequence<? extends Token> _in239 = expr;
                java.math.BigInteger _in240 = (pos).add(java.math.BigInteger.ONE);
                dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in241 = oldValues;
                Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in242 = names;
                DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in243 = keys;
                dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in244 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>update(newValues, _1210_name, _1216_newValue);
                dafny.DafnySequence<? extends Token> _in245 = dafny.DafnySequence.<Token>concatenate(acc, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))));
                b = _in238;
                expr = _in239;
                pos = _in240;
                oldValues = _in241;
                names = _in242;
                keys = _in243;
                newValues = _in244;
                acc = _in245;
                continue TAIL_CALL_START;
              }
            }
          }
        }
      } else {
        SearchableEncryptionInfo_Compile.BeaconVersion _in246 = b;
        dafny.DafnySequence<? extends Token> _in247 = expr;
        java.math.BigInteger _in248 = (pos).add(java.math.BigInteger.ONE);
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in249 = oldValues;
        Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in250 = names;
        DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in251 = keys;
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in252 = newValues;
        dafny.DafnySequence<? extends Token> _in253 = dafny.DafnySequence.<Token>concatenate(acc, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))));
        b = _in246;
        expr = _in247;
        pos = _in248;
        oldValues = _in249;
        names = _in250;
        keys = _in251;
        newValues = _in252;
        acc = _in253;
        continue TAIL_CALL_START;
      }
    }
  }
  public static dafny.DafnySequence<? extends Character> ParsedExprToString(dafny.DafnySequence<? extends Token> t) {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1218_x = Seq_Compile.__default.<Token, dafny.DafnySequence<? extends Character>>Map(Token._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((java.util.function.Function<Token, dafny.DafnySequence<? extends Character>>)(_1219_x_boxed0) -> {
      Token _1219_x = ((Token)(java.lang.Object)(_1219_x_boxed0));
      return __default.TokenToString(_1219_x);
    }), t);
    if ((java.math.BigInteger.valueOf((_1218_x).length())).signum() == 0) {
      return dafny.DafnySequence.asString("");
    } else {
      return StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _1218_x, dafny.DafnySequence.asString(" "));
    }
  }
  public static boolean IsUnary(Token t) {
    Token _source19 = t;
    if (_source19.is_Attr()) {
      dafny.DafnySequence<? extends Character> _1220___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source19)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1221___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source19)._loc;
      return false;
    } else if (_source19.is_Value()) {
      dafny.DafnySequence<? extends Character> _1222___mcc_h4 = ((DynamoDBFilterExpr_Compile.Token_Value)_source19)._s;
      return false;
    } else if (_source19.is_Eq()) {
      return false;
    } else if (_source19.is_Ne()) {
      return false;
    } else if (_source19.is_Lt()) {
      return false;
    } else if (_source19.is_Gt()) {
      return false;
    } else if (_source19.is_Le()) {
      return false;
    } else if (_source19.is_Ge()) {
      return false;
    } else if (_source19.is_Between()) {
      return false;
    } else if (_source19.is_In()) {
      return false;
    } else if (_source19.is_Open()) {
      return false;
    } else if (_source19.is_Close()) {
      return false;
    } else if (_source19.is_Comma()) {
      return false;
    } else if (_source19.is_Not()) {
      return true;
    } else if (_source19.is_And()) {
      return false;
    } else if (_source19.is_Or()) {
      return false;
    } else if (_source19.is_AttributeExists()) {
      return false;
    } else if (_source19.is_AttributeNotExists()) {
      return false;
    } else if (_source19.is_AttributeType()) {
      return false;
    } else if (_source19.is_BeginsWith()) {
      return false;
    } else if (_source19.is_Contains()) {
      return false;
    } else {
      return false;
    }
  }
  public static boolean IsComp(Token t) {
    Token _source20 = t;
    if (_source20.is_Attr()) {
      dafny.DafnySequence<? extends Character> _1223___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source20)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1224___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source20)._loc;
      return false;
    } else if (_source20.is_Value()) {
      dafny.DafnySequence<? extends Character> _1225___mcc_h4 = ((DynamoDBFilterExpr_Compile.Token_Value)_source20)._s;
      return false;
    } else if (_source20.is_Eq()) {
      return true;
    } else if (_source20.is_Ne()) {
      return true;
    } else if (_source20.is_Lt()) {
      return true;
    } else if (_source20.is_Gt()) {
      return true;
    } else if (_source20.is_Le()) {
      return true;
    } else if (_source20.is_Ge()) {
      return true;
    } else if (_source20.is_Between()) {
      return false;
    } else if (_source20.is_In()) {
      return false;
    } else if (_source20.is_Open()) {
      return false;
    } else if (_source20.is_Close()) {
      return false;
    } else if (_source20.is_Comma()) {
      return false;
    } else if (_source20.is_Not()) {
      return false;
    } else if (_source20.is_And()) {
      return false;
    } else if (_source20.is_Or()) {
      return false;
    } else if (_source20.is_AttributeExists()) {
      return false;
    } else if (_source20.is_AttributeNotExists()) {
      return false;
    } else if (_source20.is_AttributeType()) {
      return false;
    } else if (_source20.is_BeginsWith()) {
      return false;
    } else if (_source20.is_Contains()) {
      return false;
    } else {
      return false;
    }
  }
  public static boolean IsBinaryBool(Token t) {
    Token _source21 = t;
    if (_source21.is_Attr()) {
      dafny.DafnySequence<? extends Character> _1226___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source21)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1227___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source21)._loc;
      return false;
    } else if (_source21.is_Value()) {
      dafny.DafnySequence<? extends Character> _1228___mcc_h4 = ((DynamoDBFilterExpr_Compile.Token_Value)_source21)._s;
      return false;
    } else if (_source21.is_Eq()) {
      return false;
    } else if (_source21.is_Ne()) {
      return false;
    } else if (_source21.is_Lt()) {
      return false;
    } else if (_source21.is_Gt()) {
      return false;
    } else if (_source21.is_Le()) {
      return false;
    } else if (_source21.is_Ge()) {
      return false;
    } else if (_source21.is_Between()) {
      return false;
    } else if (_source21.is_In()) {
      return false;
    } else if (_source21.is_Open()) {
      return false;
    } else if (_source21.is_Close()) {
      return false;
    } else if (_source21.is_Comma()) {
      return false;
    } else if (_source21.is_Not()) {
      return false;
    } else if (_source21.is_And()) {
      return true;
    } else if (_source21.is_Or()) {
      return true;
    } else if (_source21.is_AttributeExists()) {
      return false;
    } else if (_source21.is_AttributeNotExists()) {
      return false;
    } else if (_source21.is_AttributeType()) {
      return false;
    } else if (_source21.is_BeginsWith()) {
      return false;
    } else if (_source21.is_Contains()) {
      return false;
    } else {
      return false;
    }
  }
  public static boolean IsBinary(Token t) {
    return (__default.IsComp(t)) || (__default.IsBinaryBool(t));
  }
  public static boolean IsVar(Token t) {
    Token _source22 = t;
    if (_source22.is_Attr()) {
      dafny.DafnySequence<? extends Character> _1229___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source22)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1230___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source22)._loc;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1231_loc = _1230___mcc_h1;
      dafny.DafnySequence<? extends Character> _1232_s = _1229___mcc_h0;
      return true;
    } else if (_source22.is_Value()) {
      dafny.DafnySequence<? extends Character> _1233___mcc_h4 = ((DynamoDBFilterExpr_Compile.Token_Value)_source22)._s;
      dafny.DafnySequence<? extends Character> _1234_s = _1233___mcc_h4;
      return true;
    } else if (_source22.is_Eq()) {
      return false;
    } else if (_source22.is_Ne()) {
      return false;
    } else if (_source22.is_Lt()) {
      return false;
    } else if (_source22.is_Gt()) {
      return false;
    } else if (_source22.is_Le()) {
      return false;
    } else if (_source22.is_Ge()) {
      return false;
    } else if (_source22.is_Between()) {
      return false;
    } else if (_source22.is_In()) {
      return false;
    } else if (_source22.is_Open()) {
      return false;
    } else if (_source22.is_Close()) {
      return false;
    } else if (_source22.is_Comma()) {
      return false;
    } else if (_source22.is_Not()) {
      return false;
    } else if (_source22.is_And()) {
      return false;
    } else if (_source22.is_Or()) {
      return false;
    } else if (_source22.is_AttributeExists()) {
      return false;
    } else if (_source22.is_AttributeNotExists()) {
      return false;
    } else if (_source22.is_AttributeType()) {
      return false;
    } else if (_source22.is_BeginsWith()) {
      return false;
    } else if (_source22.is_Contains()) {
      return false;
    } else {
      return false;
    }
  }
  public static boolean IsFunction(Token t) {
    Token _source23 = t;
    if (_source23.is_Attr()) {
      dafny.DafnySequence<? extends Character> _1235___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source23)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1236___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source23)._loc;
      return false;
    } else if (_source23.is_Value()) {
      dafny.DafnySequence<? extends Character> _1237___mcc_h4 = ((DynamoDBFilterExpr_Compile.Token_Value)_source23)._s;
      return false;
    } else if (_source23.is_Eq()) {
      return false;
    } else if (_source23.is_Ne()) {
      return false;
    } else if (_source23.is_Lt()) {
      return false;
    } else if (_source23.is_Gt()) {
      return false;
    } else if (_source23.is_Le()) {
      return false;
    } else if (_source23.is_Ge()) {
      return false;
    } else if (_source23.is_Between()) {
      return true;
    } else if (_source23.is_In()) {
      return true;
    } else if (_source23.is_Open()) {
      return false;
    } else if (_source23.is_Close()) {
      return false;
    } else if (_source23.is_Comma()) {
      return false;
    } else if (_source23.is_Not()) {
      return false;
    } else if (_source23.is_And()) {
      return false;
    } else if (_source23.is_Or()) {
      return false;
    } else if (_source23.is_AttributeExists()) {
      return true;
    } else if (_source23.is_AttributeNotExists()) {
      return true;
    } else if (_source23.is_AttributeType()) {
      return true;
    } else if (_source23.is_BeginsWith()) {
      return true;
    } else if (_source23.is_Contains()) {
      return true;
    } else {
      return true;
    }
  }
  public static java.math.BigInteger Precedence(Token t) {
    Token _source24 = t;
    if (_source24.is_Attr()) {
      dafny.DafnySequence<? extends Character> _1238___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source24)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1239___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source24)._loc;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1240_loc = _1239___mcc_h1;
      dafny.DafnySequence<? extends Character> _1241_s = _1238___mcc_h0;
      return java.math.BigInteger.valueOf(10L);
    } else if (_source24.is_Value()) {
      dafny.DafnySequence<? extends Character> _1242___mcc_h2 = ((DynamoDBFilterExpr_Compile.Token_Value)_source24)._s;
      dafny.DafnySequence<? extends Character> _1243_s = _1242___mcc_h2;
      return java.math.BigInteger.valueOf(10L);
    } else if (_source24.is_Eq()) {
      return java.math.BigInteger.valueOf(9L);
    } else if (_source24.is_Ne()) {
      return java.math.BigInteger.valueOf(9L);
    } else if (_source24.is_Lt()) {
      return java.math.BigInteger.valueOf(9L);
    } else if (_source24.is_Gt()) {
      return java.math.BigInteger.valueOf(9L);
    } else if (_source24.is_Le()) {
      return java.math.BigInteger.valueOf(9L);
    } else if (_source24.is_Ge()) {
      return java.math.BigInteger.valueOf(9L);
    } else if (_source24.is_Between()) {
      return java.math.BigInteger.valueOf(7L);
    } else if (_source24.is_In()) {
      return java.math.BigInteger.valueOf(8L);
    } else if (_source24.is_Open()) {
      return java.math.BigInteger.valueOf(11L);
    } else if (_source24.is_Close()) {
      return java.math.BigInteger.valueOf(11L);
    } else if (_source24.is_Comma()) {
      return java.math.BigInteger.valueOf(11L);
    } else if (_source24.is_Not()) {
      return java.math.BigInteger.valueOf(5L);
    } else if (_source24.is_And()) {
      return java.math.BigInteger.valueOf(4L);
    } else if (_source24.is_Or()) {
      return java.math.BigInteger.valueOf(3L);
    } else if (_source24.is_AttributeExists()) {
      return java.math.BigInteger.valueOf(6L);
    } else if (_source24.is_AttributeNotExists()) {
      return java.math.BigInteger.valueOf(6L);
    } else if (_source24.is_AttributeType()) {
      return java.math.BigInteger.valueOf(6L);
    } else if (_source24.is_BeginsWith()) {
      return java.math.BigInteger.valueOf(6L);
    } else if (_source24.is_Contains()) {
      return java.math.BigInteger.valueOf(6L);
    } else {
      return java.math.BigInteger.valueOf(6L);
    }
  }
  public static dafny.DafnySequence<? extends Token> ParseExpr(dafny.DafnySequence<? extends Character> s) {
    dafny.DafnySequence<? extends Token> _1244___accumulator = dafny.DafnySequence.<Token> empty(Token._typeDescriptor());
    TAIL_CALL_START: while (true) {
      dafny.Tuple2<java.math.BigInteger, Token> _1245_tup = __default.FindIndexToken(s);
      if (((_1245_tup).dtor__0()).signum() == 1) {
        _1244___accumulator = dafny.DafnySequence.<Token>concatenate(_1244___accumulator, dafny.DafnySequence.of(Token._typeDescriptor(), (_1245_tup).dtor__1()));
        dafny.DafnySequence<? extends Character> _in254 = (s).drop((_1245_tup).dtor__0());
        s = _in254;
        continue TAIL_CALL_START;
      } else {
        return dafny.DafnySequence.<Token>concatenate(_1244___accumulator, dafny.DafnySequence.<Token> empty(Token._typeDescriptor()));
      }
    }
  }
  public static byte ByteLower(byte ch) {
    if ((java.lang.Integer.compareUnsigned(((byte) ('A')), ch) <= 0) && (java.lang.Integer.compareUnsigned(ch, ((byte) ('Z'))) <= 0)) {
      return (byte) (byte)  ((byte)(((byte) (byte)  ((byte)((ch) - (((byte) ('A')))))) + (((byte) ('a')))));
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
  public static dafny.DafnySequence<? extends Character> strLower(dafny.DafnySequence<? extends Character> s) {
    dafny.DafnySequence<? extends Character> _1246___accumulator = dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR);
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
        return dafny.DafnySequence.<Character>concatenate(_1246___accumulator, s);
      } else {
        _1246___accumulator = dafny.DafnySequence.<Character>concatenate(_1246___accumulator, dafny.DafnySequence.of(__default.CharLower(((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))));
        dafny.DafnySequence<? extends Character> _in255 = (s).drop(java.math.BigInteger.ONE);
        s = _in255;
        continue TAIL_CALL_START;
      }
    }
  }
  public static boolean PrefixLower(dafny.DafnySequence<? extends Character> pre, dafny.DafnySequence<? extends Character> s)
  {
    return (__default.strLower(pre)).isPrefixOf(__default.strLower(s));
  }
  public static boolean ValueChar(char ch) {
    if ((('a') <= (ch)) && ((ch) <= ('z'))) {
      return true;
    } else if ((('A') <= (ch)) && ((ch) <= ('Z'))) {
      return true;
    } else if ((('0') <= (ch)) && ((ch) <= ('9'))) {
      return true;
    } else {
      return false;
    }
  }
  public static boolean AttributeChar(char ch) {
    if (__default.ValueChar(ch)) {
      return true;
    } else if ((dafny.DafnySequence.of(':', '[', ']', '.', '#')).contains(ch)) {
      return true;
    } else {
      return false;
    }
  }
  public static java.math.BigInteger ValueLen(dafny.DafnySequence<? extends Character> s) {
    java.math.BigInteger _1247___accumulator = java.math.BigInteger.ZERO;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
        return (java.math.BigInteger.ZERO).add(_1247___accumulator);
      } else if (__default.ValueChar(((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) {
        _1247___accumulator = (java.math.BigInteger.ONE).add(_1247___accumulator);
        dafny.DafnySequence<? extends Character> _in256 = (s).drop(java.math.BigInteger.ONE);
        s = _in256;
        continue TAIL_CALL_START;
      } else {
        return (java.math.BigInteger.ZERO).add(_1247___accumulator);
      }
    }
  }
  public static java.math.BigInteger AttributeLen(dafny.DafnySequence<? extends Character> s) {
    java.math.BigInteger _1248___accumulator = java.math.BigInteger.ZERO;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
        return (java.math.BigInteger.ZERO).add(_1248___accumulator);
      } else if (__default.AttributeChar(((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) {
        _1248___accumulator = (java.math.BigInteger.ONE).add(_1248___accumulator);
        dafny.DafnySequence<? extends Character> _in257 = (s).drop(java.math.BigInteger.ONE);
        s = _in257;
        continue TAIL_CALL_START;
      } else {
        return (java.math.BigInteger.ZERO).add(_1248___accumulator);
      }
    }
  }
  public static Token MakeAttr(dafny.DafnySequence<? extends Character> s) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1249_loc = TermLoc_Compile.__default.MakeTermLoc(s);
    if ((_1249_loc).is_Success()) {
      return DynamoDBFilterExpr_Compile.Token.create_Attr(s, (_1249_loc).dtor_value());
    } else {
      return DynamoDBFilterExpr_Compile.Token.create_Attr(s, TermLoc_Compile.__default.TermLocMap(s));
    }
  }
  public static dafny.Tuple2<java.math.BigInteger, Token> FindIndexToken(dafny.DafnySequence<? extends Character> s) {
    if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
      return dafny.Tuple2.<java.math.BigInteger, Token>create(java.math.BigInteger.ZERO, DynamoDBFilterExpr_Compile.Token.create_Close());
    } else {
      char _1250_ch = ((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))));
      if ((_1250_ch) == (' ')) {
        dafny.Tuple2<java.math.BigInteger, Token> _1251_foo = __default.FindIndexToken((s).drop(java.math.BigInteger.ONE));
        if (((_1251_foo).dtor__0()).signum() == 0) {
          return dafny.Tuple2.<java.math.BigInteger, Token>create((_1251_foo).dtor__0(), (_1251_foo).dtor__1());
        } else {
          return dafny.Tuple2.<java.math.BigInteger, Token>create(((_1251_foo).dtor__0()).add(java.math.BigInteger.ONE), (_1251_foo).dtor__1());
        }
      } else if ((_1250_ch) == ('(')) {
        return dafny.Tuple2.<java.math.BigInteger, Token>create(java.math.BigInteger.ONE, DynamoDBFilterExpr_Compile.Token.create_Open());
      } else if ((_1250_ch) == (')')) {
        return dafny.Tuple2.<java.math.BigInteger, Token>create(java.math.BigInteger.ONE, DynamoDBFilterExpr_Compile.Token.create_Close());
      } else if ((_1250_ch) == (',')) {
        return dafny.Tuple2.<java.math.BigInteger, Token>create(java.math.BigInteger.ONE, DynamoDBFilterExpr_Compile.Token.create_Comma());
      } else if ((_1250_ch) == ('=')) {
        return dafny.Tuple2.<java.math.BigInteger, Token>create(java.math.BigInteger.ONE, DynamoDBFilterExpr_Compile.Token.create_Eq());
      } else if ((_1250_ch) == ('<')) {
        if ((dafny.DafnySequence.asString("<=")).isPrefixOf(s)) {
          return dafny.Tuple2.<java.math.BigInteger, Token>create(java.math.BigInteger.valueOf(2L), DynamoDBFilterExpr_Compile.Token.create_Le());
        } else if ((dafny.DafnySequence.asString("<>")).isPrefixOf(s)) {
          return dafny.Tuple2.<java.math.BigInteger, Token>create(java.math.BigInteger.valueOf(2L), DynamoDBFilterExpr_Compile.Token.create_Ne());
        } else {
          return dafny.Tuple2.<java.math.BigInteger, Token>create(java.math.BigInteger.ONE, DynamoDBFilterExpr_Compile.Token.create_Lt());
        }
      } else if ((_1250_ch) == ('>')) {
        if ((dafny.DafnySequence.asString(">=")).isPrefixOf(s)) {
          return dafny.Tuple2.<java.math.BigInteger, Token>create(java.math.BigInteger.valueOf(2L), DynamoDBFilterExpr_Compile.Token.create_Ge());
        } else {
          return dafny.Tuple2.<java.math.BigInteger, Token>create(java.math.BigInteger.ONE, DynamoDBFilterExpr_Compile.Token.create_Gt());
        }
      } else if (__default.PrefixLower(dafny.DafnySequence.asString("in"), s)) {
        return dafny.Tuple2.<java.math.BigInteger, Token>create(java.math.BigInteger.valueOf(2L), DynamoDBFilterExpr_Compile.Token.create_In());
      } else if (__default.PrefixLower(dafny.DafnySequence.asString("between"), s)) {
        return dafny.Tuple2.<java.math.BigInteger, Token>create(java.math.BigInteger.valueOf(7L), DynamoDBFilterExpr_Compile.Token.create_Between());
      } else if (__default.PrefixLower(dafny.DafnySequence.asString("and"), s)) {
        return dafny.Tuple2.<java.math.BigInteger, Token>create(java.math.BigInteger.valueOf(3L), DynamoDBFilterExpr_Compile.Token.create_And());
      } else if (__default.PrefixLower(dafny.DafnySequence.asString("or"), s)) {
        return dafny.Tuple2.<java.math.BigInteger, Token>create(java.math.BigInteger.valueOf(2L), DynamoDBFilterExpr_Compile.Token.create_Or());
      } else if (__default.PrefixLower(dafny.DafnySequence.asString("not"), s)) {
        return dafny.Tuple2.<java.math.BigInteger, Token>create(java.math.BigInteger.valueOf(3L), DynamoDBFilterExpr_Compile.Token.create_Not());
      } else if (__default.PrefixLower(dafny.DafnySequence.asString("attribute_not_exists"), s)) {
        return dafny.Tuple2.<java.math.BigInteger, Token>create(java.math.BigInteger.valueOf(20L), DynamoDBFilterExpr_Compile.Token.create_AttributeNotExists());
      } else if (__default.PrefixLower(dafny.DafnySequence.asString("attribute_type"), s)) {
        return dafny.Tuple2.<java.math.BigInteger, Token>create(java.math.BigInteger.valueOf(14L), DynamoDBFilterExpr_Compile.Token.create_AttributeType());
      } else if (__default.PrefixLower(dafny.DafnySequence.asString("begins_with"), s)) {
        return dafny.Tuple2.<java.math.BigInteger, Token>create(java.math.BigInteger.valueOf(11L), DynamoDBFilterExpr_Compile.Token.create_BeginsWith());
      } else if (__default.PrefixLower(dafny.DafnySequence.asString("attribute_exists"), s)) {
        return dafny.Tuple2.<java.math.BigInteger, Token>create(java.math.BigInteger.valueOf(16L), DynamoDBFilterExpr_Compile.Token.create_AttributeExists());
      } else if (__default.PrefixLower(dafny.DafnySequence.asString("contains"), s)) {
        return dafny.Tuple2.<java.math.BigInteger, Token>create(java.math.BigInteger.valueOf(8L), DynamoDBFilterExpr_Compile.Token.create_Contains());
      } else if (__default.PrefixLower(dafny.DafnySequence.asString("size"), s)) {
        return dafny.Tuple2.<java.math.BigInteger, Token>create(java.math.BigInteger.valueOf(4L), DynamoDBFilterExpr_Compile.Token.create_Size());
      } else if ((_1250_ch) == (':')) {
        java.math.BigInteger _1252_x = (__default.ValueLen((s).drop(java.math.BigInteger.ONE))).add(java.math.BigInteger.ONE);
        return dafny.Tuple2.<java.math.BigInteger, Token>create(_1252_x, DynamoDBFilterExpr_Compile.Token.create_Value((s).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((_1252_x)))));
      } else if ((_1250_ch) == ('#')) {
        java.math.BigInteger _1253_x = (__default.ValueLen((s).drop(java.math.BigInteger.ONE))).add(java.math.BigInteger.ONE);
        return dafny.Tuple2.<java.math.BigInteger, Token>create(_1253_x, __default.MakeAttr((s).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((_1253_x)))));
      } else {
        java.math.BigInteger _1254_x = __default.AttributeLen(s);
        return dafny.Tuple2.<java.math.BigInteger, Token>create(_1254_x, __default.MakeAttr((s).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((_1254_x)))));
      }
    }
  }
  public static java.math.BigInteger VarOrSize(dafny.DafnySequence<? extends Token> input) {
    if ((java.math.BigInteger.valueOf((input).length())).signum() == 0) {
      return java.math.BigInteger.ZERO;
    } else if (((((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).is_Value()) || ((((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).is_Attr())) {
      return java.math.BigInteger.ONE;
    } else if ((((((java.math.BigInteger.valueOf(3L)).compareTo(java.math.BigInteger.valueOf((input).length())) < 0) && ((((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).is_Size())) && ((((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ONE)))))).is_Open())) && (__default.IsVar(((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.valueOf(2L))))))))) && ((((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.valueOf(3L))))))).is_Close())) {
      return java.math.BigInteger.valueOf(4L);
    } else {
      return java.math.BigInteger.ZERO;
    }
  }
  public static Wrappers_Compile.Option<dafny.Tuple3<java.math.BigInteger, java.math.BigInteger, java.math.BigInteger>> IsBetween(dafny.DafnySequence<? extends Token> input) {
    if ((java.math.BigInteger.valueOf((input).length())).compareTo(java.math.BigInteger.valueOf(5L)) < 0) {
      return Wrappers_Compile.Option.<dafny.Tuple3<java.math.BigInteger, java.math.BigInteger, java.math.BigInteger>>create_None();
    } else {
      java.math.BigInteger _1255_p1 = __default.VarOrSize(input);
      if ((((_1255_p1).signum() == 1) && (((_1255_p1).add(java.math.BigInteger.ONE)).compareTo(java.math.BigInteger.valueOf((input).length())) < 0)) && ((((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((_1255_p1)))))).is_Between())) {
        java.math.BigInteger _1256_p2 = __default.VarOrSize((input).drop((_1255_p1).add(java.math.BigInteger.ONE)));
        if ((((_1256_p2).signum() == 1) && ((((_1255_p1).add(_1256_p2)).add(java.math.BigInteger.valueOf(2L))).compareTo(java.math.BigInteger.valueOf((input).length())) < 0)) && ((((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((((_1255_p1).add(_1256_p2)).add(java.math.BigInteger.ONE))))))).is_And())) {
          java.math.BigInteger _1257_p3 = __default.VarOrSize((input).drop(((_1255_p1).add(_1256_p2)).add(java.math.BigInteger.valueOf(2L))));
          if ((_1257_p3).signum() == 1) {
            return Wrappers_Compile.Option.<dafny.Tuple3<java.math.BigInteger, java.math.BigInteger, java.math.BigInteger>>create_Some(dafny.Tuple3.<java.math.BigInteger, java.math.BigInteger, java.math.BigInteger>create(_1255_p1, _1256_p2, _1257_p3));
          } else {
            return Wrappers_Compile.Option.<dafny.Tuple3<java.math.BigInteger, java.math.BigInteger, java.math.BigInteger>>create_None();
          }
        } else {
          return Wrappers_Compile.Option.<dafny.Tuple3<java.math.BigInteger, java.math.BigInteger, java.math.BigInteger>>create_None();
        }
      } else {
        return Wrappers_Compile.Option.<dafny.Tuple3<java.math.BigInteger, java.math.BigInteger, java.math.BigInteger>>create_None();
      }
    }
  }
  public static boolean IsIN(dafny.DafnySequence<? extends Token> input) {
    if ((java.math.BigInteger.valueOf((input).length())).compareTo(java.math.BigInteger.valueOf(3L)) < 0) {
      return false;
    } else if (!(__default.IsVar(((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))))) {
      return false;
    } else if (!java.util.Objects.equals(((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ONE))))), DynamoDBFilterExpr_Compile.Token.create_In())) {
      return false;
    } else if (!java.util.Objects.equals(((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.valueOf(2L)))))), DynamoDBFilterExpr_Compile.Token.create_Open())) {
      return false;
    } else {
      return true;
    }
  }
  public static dafny.DafnySequence<? extends Token> ConvertToPrefix(dafny.DafnySequence<? extends Token> input) {
    dafny.DafnySequence<? extends Token> _1258___accumulator = dafny.DafnySequence.<Token> empty(Token._typeDescriptor());
    TAIL_CALL_START: while (true) {
      Wrappers_Compile.Option<dafny.Tuple3<java.math.BigInteger, java.math.BigInteger, java.math.BigInteger>> _1259_between = __default.IsBetween(input);
      if ((java.math.BigInteger.valueOf((input).length())).compareTo(java.math.BigInteger.valueOf(5L)) < 0) {
        return dafny.DafnySequence.<Token>concatenate(_1258___accumulator, input);
      } else if (__default.IsIN(input)) {
        _1258___accumulator = dafny.DafnySequence.<Token>concatenate(_1258___accumulator, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ONE))))), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.valueOf(2L)))))), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), DynamoDBFilterExpr_Compile.Token.create_Comma()));
        dafny.DafnySequence<? extends Token> _in258 = (input).drop(java.math.BigInteger.valueOf(3L));
        input = _in258;
        continue TAIL_CALL_START;
      } else if ((_1259_between).is_Some()) {
        dafny.Tuple3<java.math.BigInteger, java.math.BigInteger, java.math.BigInteger> _1260_b = (_1259_between).dtor_value();
        _1258___accumulator = dafny.DafnySequence.<Token>concatenate(_1258___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.of(Token._typeDescriptor(), DynamoDBFilterExpr_Compile.Token.create_Between(), DynamoDBFilterExpr_Compile.Token.create_Open()), (input).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt(((_1260_b).dtor__0())))), dafny.DafnySequence.of(Token._typeDescriptor(), DynamoDBFilterExpr_Compile.Token.create_Comma())), (input).subsequence(dafny.Helpers.toInt((((_1260_b).dtor__0()).add(java.math.BigInteger.ONE))), dafny.Helpers.toInt(((((_1260_b).dtor__0()).add((_1260_b).dtor__1())).add(java.math.BigInteger.ONE))))), dafny.DafnySequence.of(Token._typeDescriptor(), DynamoDBFilterExpr_Compile.Token.create_Comma())), (input).subsequence(dafny.Helpers.toInt(((((_1260_b).dtor__0()).add((_1260_b).dtor__1())).add(java.math.BigInteger.valueOf(2L)))), dafny.Helpers.toInt((((((_1260_b).dtor__0()).add((_1260_b).dtor__1())).add((_1260_b).dtor__2())).add(java.math.BigInteger.valueOf(2L)))))), dafny.DafnySequence.of(Token._typeDescriptor(), DynamoDBFilterExpr_Compile.Token.create_Close())));
        dafny.DafnySequence<? extends Token> _in259 = (input).drop(((((_1260_b).dtor__0()).add((_1260_b).dtor__1())).add((_1260_b).dtor__2())).add(java.math.BigInteger.valueOf(2L)));
        input = _in259;
        continue TAIL_CALL_START;
      } else {
        _1258___accumulator = dafny.DafnySequence.<Token>concatenate(_1258___accumulator, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
        dafny.DafnySequence<? extends Token> _in260 = (input).drop(java.math.BigInteger.ONE);
        input = _in260;
        continue TAIL_CALL_START;
      }
    }
  }
  public static dafny.DafnySequence<? extends Token> ConvertToRpn(dafny.DafnySequence<? extends Token> input) {
    dafny.DafnySequence<? extends Token> _1261_stack = dafny.DafnySequence.<Token> empty(Token._typeDescriptor());
    return __default.ConvertToRpn__inner(input, _1261_stack);
  }
  public static dafny.DafnySequence<? extends Token> ConvertToRpn__inner(dafny.DafnySequence<? extends Token> input, dafny.DafnySequence<? extends Token> stack)
  {
    dafny.DafnySequence<? extends Token> _1262___accumulator = dafny.DafnySequence.<Token> empty(Token._typeDescriptor());
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((input).length())).signum() == 0) {
        if ((java.math.BigInteger.valueOf((stack).length())).signum() == 0) {
          return dafny.DafnySequence.<Token>concatenate(_1262___accumulator, dafny.DafnySequence.<Token> empty(Token._typeDescriptor()));
        } else {
          _1262___accumulator = dafny.DafnySequence.<Token>concatenate(_1262___accumulator, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))));
          dafny.DafnySequence<? extends Token> _in261 = input;
          dafny.DafnySequence<? extends Token> _in262 = (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE));
          input = _in261;
          stack = _in262;
          continue TAIL_CALL_START;
        }
      } else {
        Token _source25 = ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))));
        if (_source25.is_Attr()) {
          dafny.DafnySequence<? extends Character> _1263___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source25)._s;
          dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1264___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source25)._loc;
          dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1265_loc = _1264___mcc_h1;
          dafny.DafnySequence<? extends Character> _1266_s = _1263___mcc_h0;
          return dafny.DafnySequence.<Token>concatenate(_1262___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))), __default.ConvertToRpn__inner((input).drop(java.math.BigInteger.ONE), stack)));
        } else if (_source25.is_Value()) {
          dafny.DafnySequence<? extends Character> _1267___mcc_h2 = ((DynamoDBFilterExpr_Compile.Token_Value)_source25)._s;
          dafny.DafnySequence<? extends Character> _1268_s = _1267___mcc_h2;
          return dafny.DafnySequence.<Token>concatenate(_1262___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))), __default.ConvertToRpn__inner((input).drop(java.math.BigInteger.ONE), stack)));
        } else if (_source25.is_Eq()) {
          if ((java.math.BigInteger.valueOf((stack).length())).signum() == 0) {
            dafny.DafnySequence<? extends Token> _in263 = (input).drop(java.math.BigInteger.ONE);
            dafny.DafnySequence<? extends Token> _in264 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
            input = _in263;
            stack = _in264;
            continue TAIL_CALL_START;
          } else if ((__default.Precedence(((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))))).compareTo(__default.Precedence(((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) >= 0) {
            return dafny.DafnySequence.<Token>concatenate(_1262___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))), __default.ConvertToRpn__inner(input, (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))));
          } else {
            dafny.DafnySequence<? extends Token> _in265 = (input).drop(java.math.BigInteger.ONE);
            dafny.DafnySequence<? extends Token> _in266 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
            input = _in265;
            stack = _in266;
            continue TAIL_CALL_START;
          }
        } else if (_source25.is_Ne()) {
          if ((java.math.BigInteger.valueOf((stack).length())).signum() == 0) {
            dafny.DafnySequence<? extends Token> _in267 = (input).drop(java.math.BigInteger.ONE);
            dafny.DafnySequence<? extends Token> _in268 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
            input = _in267;
            stack = _in268;
            continue TAIL_CALL_START;
          } else if ((__default.Precedence(((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))))).compareTo(__default.Precedence(((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) >= 0) {
            return dafny.DafnySequence.<Token>concatenate(_1262___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))), __default.ConvertToRpn__inner(input, (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))));
          } else {
            dafny.DafnySequence<? extends Token> _in269 = (input).drop(java.math.BigInteger.ONE);
            dafny.DafnySequence<? extends Token> _in270 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
            input = _in269;
            stack = _in270;
            continue TAIL_CALL_START;
          }
        } else if (_source25.is_Lt()) {
          if ((java.math.BigInteger.valueOf((stack).length())).signum() == 0) {
            dafny.DafnySequence<? extends Token> _in271 = (input).drop(java.math.BigInteger.ONE);
            dafny.DafnySequence<? extends Token> _in272 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
            input = _in271;
            stack = _in272;
            continue TAIL_CALL_START;
          } else if ((__default.Precedence(((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))))).compareTo(__default.Precedence(((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) >= 0) {
            return dafny.DafnySequence.<Token>concatenate(_1262___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))), __default.ConvertToRpn__inner(input, (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))));
          } else {
            dafny.DafnySequence<? extends Token> _in273 = (input).drop(java.math.BigInteger.ONE);
            dafny.DafnySequence<? extends Token> _in274 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
            input = _in273;
            stack = _in274;
            continue TAIL_CALL_START;
          }
        } else if (_source25.is_Gt()) {
          if ((java.math.BigInteger.valueOf((stack).length())).signum() == 0) {
            dafny.DafnySequence<? extends Token> _in275 = (input).drop(java.math.BigInteger.ONE);
            dafny.DafnySequence<? extends Token> _in276 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
            input = _in275;
            stack = _in276;
            continue TAIL_CALL_START;
          } else if ((__default.Precedence(((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))))).compareTo(__default.Precedence(((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) >= 0) {
            return dafny.DafnySequence.<Token>concatenate(_1262___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))), __default.ConvertToRpn__inner(input, (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))));
          } else {
            dafny.DafnySequence<? extends Token> _in277 = (input).drop(java.math.BigInteger.ONE);
            dafny.DafnySequence<? extends Token> _in278 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
            input = _in277;
            stack = _in278;
            continue TAIL_CALL_START;
          }
        } else if (_source25.is_Le()) {
          if ((java.math.BigInteger.valueOf((stack).length())).signum() == 0) {
            dafny.DafnySequence<? extends Token> _in279 = (input).drop(java.math.BigInteger.ONE);
            dafny.DafnySequence<? extends Token> _in280 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
            input = _in279;
            stack = _in280;
            continue TAIL_CALL_START;
          } else if ((__default.Precedence(((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))))).compareTo(__default.Precedence(((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) >= 0) {
            return dafny.DafnySequence.<Token>concatenate(_1262___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))), __default.ConvertToRpn__inner(input, (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))));
          } else {
            dafny.DafnySequence<? extends Token> _in281 = (input).drop(java.math.BigInteger.ONE);
            dafny.DafnySequence<? extends Token> _in282 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
            input = _in281;
            stack = _in282;
            continue TAIL_CALL_START;
          }
        } else if (_source25.is_Ge()) {
          if ((java.math.BigInteger.valueOf((stack).length())).signum() == 0) {
            dafny.DafnySequence<? extends Token> _in283 = (input).drop(java.math.BigInteger.ONE);
            dafny.DafnySequence<? extends Token> _in284 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
            input = _in283;
            stack = _in284;
            continue TAIL_CALL_START;
          } else if ((__default.Precedence(((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))))).compareTo(__default.Precedence(((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) >= 0) {
            return dafny.DafnySequence.<Token>concatenate(_1262___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))), __default.ConvertToRpn__inner(input, (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))));
          } else {
            dafny.DafnySequence<? extends Token> _in285 = (input).drop(java.math.BigInteger.ONE);
            dafny.DafnySequence<? extends Token> _in286 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
            input = _in285;
            stack = _in286;
            continue TAIL_CALL_START;
          }
        } else if (_source25.is_Between()) {
          dafny.DafnySequence<? extends Token> _in287 = (input).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends Token> _in288 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
          input = _in287;
          stack = _in288;
          continue TAIL_CALL_START;
        } else if (_source25.is_In()) {
          dafny.DafnySequence<? extends Token> _in289 = (input).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends Token> _in290 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
          input = _in289;
          stack = _in290;
          continue TAIL_CALL_START;
        } else if (_source25.is_Open()) {
          dafny.DafnySequence<? extends Token> _in291 = (input).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends Token> _in292 = stack;
          input = _in291;
          stack = _in292;
          continue TAIL_CALL_START;
        } else if (_source25.is_Close()) {
          if ((java.math.BigInteger.valueOf((stack).length())).signum() == 0) {
            dafny.DafnySequence<? extends Token> _in293 = (input).drop(java.math.BigInteger.ONE);
            dafny.DafnySequence<? extends Token> _in294 = stack;
            input = _in293;
            stack = _in294;
            continue TAIL_CALL_START;
          } else if (java.util.Objects.equals(((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))), DynamoDBFilterExpr_Compile.Token.create_Open())) {
            dafny.DafnySequence<? extends Token> _in295 = (input).drop(java.math.BigInteger.ONE);
            dafny.DafnySequence<? extends Token> _in296 = (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE));
            input = _in295;
            stack = _in296;
            continue TAIL_CALL_START;
          } else {
            return dafny.DafnySequence.<Token>concatenate(_1262___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))), __default.ConvertToRpn__inner((input).drop(java.math.BigInteger.ONE), (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))));
          }
        } else if (_source25.is_Comma()) {
          if ((java.math.BigInteger.valueOf((stack).length())).signum() == 1) {
            if (__default.IsFunction(((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))))) {
              dafny.DafnySequence<? extends Token> _in297 = (input).drop(java.math.BigInteger.ONE);
              dafny.DafnySequence<? extends Token> _in298 = stack;
              input = _in297;
              stack = _in298;
              continue TAIL_CALL_START;
            } else {
              return dafny.DafnySequence.<Token>concatenate(_1262___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))), __default.ConvertToRpn__inner((input).drop(java.math.BigInteger.ONE), (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))));
            }
          } else {
            dafny.DafnySequence<? extends Token> _in299 = (input).drop(java.math.BigInteger.ONE);
            dafny.DafnySequence<? extends Token> _in300 = stack;
            input = _in299;
            stack = _in300;
            continue TAIL_CALL_START;
          }
        } else if (_source25.is_Not()) {
          dafny.DafnySequence<? extends Token> _in301 = (input).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends Token> _in302 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
          input = _in301;
          stack = _in302;
          continue TAIL_CALL_START;
        } else if (_source25.is_And()) {
          if ((java.math.BigInteger.valueOf((stack).length())).signum() == 0) {
            dafny.DafnySequence<? extends Token> _in303 = (input).drop(java.math.BigInteger.ONE);
            dafny.DafnySequence<? extends Token> _in304 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
            input = _in303;
            stack = _in304;
            continue TAIL_CALL_START;
          } else if ((__default.Precedence(((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))))).compareTo(__default.Precedence(((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) >= 0) {
            return dafny.DafnySequence.<Token>concatenate(_1262___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))), __default.ConvertToRpn__inner(input, (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))));
          } else {
            dafny.DafnySequence<? extends Token> _in305 = (input).drop(java.math.BigInteger.ONE);
            dafny.DafnySequence<? extends Token> _in306 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
            input = _in305;
            stack = _in306;
            continue TAIL_CALL_START;
          }
        } else if (_source25.is_Or()) {
          if ((java.math.BigInteger.valueOf((stack).length())).signum() == 0) {
            dafny.DafnySequence<? extends Token> _in307 = (input).drop(java.math.BigInteger.ONE);
            dafny.DafnySequence<? extends Token> _in308 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
            input = _in307;
            stack = _in308;
            continue TAIL_CALL_START;
          } else if ((__default.Precedence(((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))))).compareTo(__default.Precedence(((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) >= 0) {
            return dafny.DafnySequence.<Token>concatenate(_1262___accumulator, dafny.DafnySequence.<Token>concatenate(dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))), __default.ConvertToRpn__inner(input, (stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))));
          } else {
            dafny.DafnySequence<? extends Token> _in309 = (input).drop(java.math.BigInteger.ONE);
            dafny.DafnySequence<? extends Token> _in310 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
            input = _in309;
            stack = _in310;
            continue TAIL_CALL_START;
          }
        } else if (_source25.is_AttributeExists()) {
          dafny.DafnySequence<? extends Token> _in311 = (input).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends Token> _in312 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
          input = _in311;
          stack = _in312;
          continue TAIL_CALL_START;
        } else if (_source25.is_AttributeNotExists()) {
          dafny.DafnySequence<? extends Token> _in313 = (input).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends Token> _in314 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
          input = _in313;
          stack = _in314;
          continue TAIL_CALL_START;
        } else if (_source25.is_AttributeType()) {
          dafny.DafnySequence<? extends Token> _in315 = (input).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends Token> _in316 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
          input = _in315;
          stack = _in316;
          continue TAIL_CALL_START;
        } else if (_source25.is_BeginsWith()) {
          dafny.DafnySequence<? extends Token> _in317 = (input).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends Token> _in318 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
          input = _in317;
          stack = _in318;
          continue TAIL_CALL_START;
        } else if (_source25.is_Contains()) {
          dafny.DafnySequence<? extends Token> _in319 = (input).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends Token> _in320 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
          input = _in319;
          stack = _in320;
          continue TAIL_CALL_START;
        } else {
          dafny.DafnySequence<? extends Token> _in321 = (input).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends Token> _in322 = dafny.DafnySequence.<Token>concatenate(stack, dafny.DafnySequence.of(Token._typeDescriptor(), ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
          input = _in321;
          stack = _in322;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static java.math.BigInteger GetSize(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue value) {
    Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _source26 = value;
    if (_source26.is_S()) {
      dafny.DafnySequence<? extends Character> _1269___mcc_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_S)_source26)._S;
      dafny.DafnySequence<? extends Character> _1270_s = _1269___mcc_h0;
      return java.math.BigInteger.valueOf((_1270_s).length());
    } else if (_source26.is_N()) {
      dafny.DafnySequence<? extends Character> _1271___mcc_h1 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_N)_source26)._N;
      dafny.DafnySequence<? extends Character> _1272_n = _1271___mcc_h1;
      return java.math.BigInteger.valueOf((_1272_n).length());
    } else if (_source26.is_B()) {
      dafny.DafnySequence<? extends java.lang.Byte> _1273___mcc_h2 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_B)_source26)._B;
      dafny.DafnySequence<? extends java.lang.Byte> _1274_n = _1273___mcc_h2;
      return java.math.BigInteger.valueOf((_1274_n).length());
    } else if (_source26.is_SS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1275___mcc_h3 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_SS)_source26)._SS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1276_n = _1275___mcc_h3;
      return java.math.BigInteger.valueOf((_1276_n).length());
    } else if (_source26.is_NS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1277___mcc_h4 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_NS)_source26)._NS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1278_n = _1277___mcc_h4;
      return java.math.BigInteger.valueOf((_1278_n).length());
    } else if (_source26.is_BS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _1279___mcc_h5 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_BS)_source26)._BS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _1280_n = _1279___mcc_h5;
      return java.math.BigInteger.valueOf((_1280_n).length());
    } else if (_source26.is_M()) {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1281___mcc_h6 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_M)_source26)._M;
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1282_n = _1281___mcc_h6;
      return java.math.BigInteger.valueOf((_1282_n).size());
    } else if (_source26.is_L()) {
      dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1283___mcc_h7 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_L)_source26)._L;
      dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1284_n = _1283___mcc_h7;
      return java.math.BigInteger.valueOf((_1284_n).length());
    } else if (_source26.is_NULL()) {
      boolean _1285___mcc_h8 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_NULL)_source26)._NULL;
      boolean _1286_n = _1285___mcc_h8;
      return java.math.BigInteger.ONE;
    } else {
      boolean _1287___mcc_h9 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_BOOL)_source26)._BOOL;
      boolean _1288_n = _1287___mcc_h9;
      return java.math.BigInteger.ONE;
    }
  }
  public static Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue GetStr(StackValue s) {
    StackValue _source27 = s;
    if (_source27.is_Bool()) {
      boolean _1289___mcc_h0 = ((DynamoDBFilterExpr_Compile.StackValue_Bool)_source27)._b;
      boolean _1290_b = _1289___mcc_h0;
      return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_NULL(true);
    } else if (_source27.is_Str()) {
      Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _1291___mcc_h1 = ((DynamoDBFilterExpr_Compile.StackValue_Str)_source27)._s;
      Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _1292_s = _1291___mcc_h1;
      return _1292_s;
    } else {
      return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_NULL(true);
    }
  }
  public static StackValue AsStr(dafny.DafnySequence<? extends Character> s) {
    return DynamoDBFilterExpr_Compile.StackValue.create_Str(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_S(s));
  }
  public static StackValue StackValueFromValue(dafny.DafnySequence<? extends Character> s, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> values)
  {
    if ((values).<dafny.DafnySequence<? extends Character>>contains(s)) {
      return DynamoDBFilterExpr_Compile.StackValue.create_Str(((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue)(java.lang.Object)((values).get(s))));
    } else {
      return DynamoDBFilterExpr_Compile.StackValue.create_DoesNotExist();
    }
  }
  public static StackValue StackValueFromItem(dafny.DafnySequence<? extends Character> s, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item)
  {
    if ((item).<dafny.DafnySequence<? extends Character>>contains(s)) {
      return DynamoDBFilterExpr_Compile.StackValue.create_Str(((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue)(java.lang.Object)((item).get(s))));
    } else {
      return DynamoDBFilterExpr_Compile.StackValue.create_DoesNotExist();
    }
  }
  public static StackValue StackValueFromAttr(Token t, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names)
  {
    if (((names).is_Some()) && (((names).dtor_value()).<dafny.DafnySequence<? extends Character>>contains((t).dtor_s()))) {
      return __default.StackValueFromItem(((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((names).dtor_value()).get((t).dtor_s()))), item);
    } else {
      Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1293_attr = TermLoc_Compile.__default.TermToAttr((t).dtor_loc(), item, names);
      if ((_1293_attr).is_Some()) {
        return DynamoDBFilterExpr_Compile.StackValue.create_Str((_1293_attr).dtor_value());
      } else {
        return DynamoDBFilterExpr_Compile.StackValue.create_DoesNotExist();
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Token>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GetParsedExpr(dafny.DafnySequence<? extends Character> input) {
    dafny.DafnySequence<? extends Token> _1294_seq1 = __default.ParseExpr(input);
    dafny.DafnySequence<? extends Token> _1295_seq2 = __default.ConvertToPrefix(_1294_seq1);
    return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Token>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(__default.ConvertToRpn(_1295_seq2));
  }
  public static Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> EvalExpr(dafny.DafnySequence<? extends Token> input, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> values)
  {
    return __default.InnerEvalExpr(input, dafny.DafnySequence.<StackValue> empty(StackValue._typeDescriptor()), item, names, values);
  }
  public static java.math.BigInteger StringsFollowing(dafny.DafnySequence<? extends StackValue> input) {
    java.math.BigInteger _1296___accumulator = java.math.BigInteger.ZERO;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((input).length())).signum() == 0) {
        return (java.math.BigInteger.ZERO).add(_1296___accumulator);
      } else if (!((((StackValue)(java.lang.Object)((input).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((input).length())).subtract(java.math.BigInteger.ONE))))))).is_Str())) {
        return (java.math.BigInteger.ZERO).add(_1296___accumulator);
      } else {
        _1296___accumulator = (_1296___accumulator).add(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends StackValue> _in323 = (input).take((java.math.BigInteger.valueOf((input).length())).subtract(java.math.BigInteger.ONE));
        input = _in323;
        continue TAIL_CALL_START;
      }
    }
  }
  public static <__T> boolean seq__contains(dafny.TypeDescriptor<__T> _td___T, dafny.DafnySequence<? extends __T> haystack, dafny.DafnySequence<? extends __T> needle)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((needle).length())).signum() == 0) {
        return true;
      } else if ((java.math.BigInteger.valueOf((haystack).length())).signum() == 0) {
        return false;
      } else if ((java.math.BigInteger.valueOf((haystack).length())).compareTo(java.math.BigInteger.valueOf((needle).length())) < 0) {
        return false;
      } else if ((java.util.Objects.equals(((__T)(java.lang.Object)((needle).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), ((__T)(java.lang.Object)((haystack).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) && (((needle).drop(java.math.BigInteger.ONE)).isPrefixOf((haystack).drop(java.math.BigInteger.ONE)))) {
        return true;
      } else {
        dafny.DafnySequence<? extends __T> _in324 = (haystack).drop(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends __T> _in325 = needle;
        haystack = _in324;
        needle = _in325;
        continue TAIL_CALL_START;
      }
    }
  }
  public static boolean does__contain(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue haystack, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue needle)
  {
    Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _source28 = haystack;
    if (_source28.is_S()) {
      dafny.DafnySequence<? extends Character> _1297___mcc_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_S)_source28)._S;
      dafny.DafnySequence<? extends Character> _1298_s = _1297___mcc_h0;
      if ((needle).is_S()) {
        return __default.<Character>seq__contains(dafny.TypeDescriptor.CHAR, (haystack).dtor_S(), (needle).dtor_S());
      } else {
        return false;
      }
    } else if (_source28.is_N()) {
      dafny.DafnySequence<? extends Character> _1299___mcc_h2 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_N)_source28)._N;
      dafny.DafnySequence<? extends Character> _1300_n = _1299___mcc_h2;
      if ((needle).is_N()) {
        return __default.<Character>seq__contains(dafny.TypeDescriptor.CHAR, (haystack).dtor_N(), (needle).dtor_N());
      } else {
        return false;
      }
    } else if (_source28.is_B()) {
      dafny.DafnySequence<? extends java.lang.Byte> _1301___mcc_h4 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_B)_source28)._B;
      dafny.DafnySequence<? extends java.lang.Byte> _1302_n = _1301___mcc_h4;
      if ((needle).is_B()) {
        return __default.<java.lang.Byte>seq__contains(StandardLibrary_mUInt_Compile.uint8._typeDescriptor(), (haystack).dtor_B(), (needle).dtor_B());
      } else {
        return false;
      }
    } else if (_source28.is_SS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1303___mcc_h6 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_SS)_source28)._SS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1304_s = _1303___mcc_h6;
      if ((needle).is_S()) {
        return ((haystack).dtor_SS()).contains((needle).dtor_S());
      } else {
        return false;
      }
    } else if (_source28.is_NS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1305___mcc_h8 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_NS)_source28)._NS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1306_s = _1305___mcc_h8;
      if ((needle).is_N()) {
        return ((haystack).dtor_NS()).contains((needle).dtor_N());
      } else {
        return false;
      }
    } else if (_source28.is_BS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _1307___mcc_h10 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_BS)_source28)._BS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _1308_s = _1307___mcc_h10;
      if ((needle).is_B()) {
        return ((haystack).dtor_BS()).contains((needle).dtor_B());
      } else {
        return false;
      }
    } else if (_source28.is_M()) {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1309___mcc_h12 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_M)_source28)._M;
      return false;
    } else if (_source28.is_L()) {
      dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1310___mcc_h14 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_L)_source28)._L;
      dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1311_list = _1310___mcc_h14;
      return (_1311_list).contains(needle);
    } else if (_source28.is_NULL()) {
      boolean _1312___mcc_h16 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_NULL)_source28)._NULL;
      return false;
    } else {
      boolean _1313___mcc_h18 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_BOOL)_source28)._BOOL;
      return false;
    }
  }
  public static boolean begins__with(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue haystack, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue needle)
  {
    Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _source29 = haystack;
    if (_source29.is_S()) {
      dafny.DafnySequence<? extends Character> _1314___mcc_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_S)_source29)._S;
      dafny.DafnySequence<? extends Character> _1315_s = _1314___mcc_h0;
      if ((needle).is_S()) {
        return ((needle).dtor_S()).isPrefixOf((haystack).dtor_S());
      } else {
        return false;
      }
    } else if (_source29.is_N()) {
      dafny.DafnySequence<? extends Character> _1316___mcc_h2 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_N)_source29)._N;
      dafny.DafnySequence<? extends Character> _1317_n = _1316___mcc_h2;
      if ((needle).is_N()) {
        return ((needle).dtor_N()).isPrefixOf((haystack).dtor_N());
      } else {
        return false;
      }
    } else if (_source29.is_B()) {
      dafny.DafnySequence<? extends java.lang.Byte> _1318___mcc_h4 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_B)_source29)._B;
      dafny.DafnySequence<? extends java.lang.Byte> _1319_n = _1318___mcc_h4;
      if ((needle).is_B()) {
        return ((needle).dtor_B()).isPrefixOf((haystack).dtor_B());
      } else {
        return false;
      }
    } else if (_source29.is_SS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1320___mcc_h6 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_SS)_source29)._SS;
      return false;
    } else if (_source29.is_NS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1321___mcc_h8 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_NS)_source29)._NS;
      return false;
    } else if (_source29.is_BS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _1322___mcc_h10 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_BS)_source29)._BS;
      return false;
    } else if (_source29.is_M()) {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1323___mcc_h12 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_M)_source29)._M;
      return false;
    } else if (_source29.is_L()) {
      dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1324___mcc_h14 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_L)_source29)._L;
      dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1325_list = _1324___mcc_h14;
      if ((java.math.BigInteger.valueOf((_1325_list).length())).signum() == 0) {
        return false;
      } else if (java.util.Objects.equals(((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue)(java.lang.Object)((_1325_list).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), needle)) {
        return true;
      } else if ((needle).is_L()) {
        return ((needle).dtor_L()).isPrefixOf(_1325_list);
      } else {
        return false;
      }
    } else if (_source29.is_NULL()) {
      boolean _1326___mcc_h16 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_NULL)_source29)._NULL;
      return false;
    } else {
      boolean _1327___mcc_h18 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_BOOL)_source29)._BOOL;
      return false;
    }
  }
  public static boolean is__between(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue middle, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue left, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue right)
  {
    return (__default.AttributeLE(left, middle)) && (__default.AttributeLE(middle, right));
  }
  public static boolean is__in(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue target, dafny.DafnySequence<? extends StackValue> list)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((list).length())).signum() == 0) {
        return false;
      } else if (java.util.Objects.equals(__default.GetStr(((StackValue)(java.lang.Object)((list).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))), target)) {
        return true;
      } else {
        Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _in326 = target;
        dafny.DafnySequence<? extends StackValue> _in327 = (list).drop(java.math.BigInteger.ONE);
        target = _in326;
        list = _in327;
        continue TAIL_CALL_START;
      }
    }
  }
  public static dafny.DafnySequence<? extends Character> AttrToStr(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue attr) {
    Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _source30 = attr;
    if (_source30.is_S()) {
      dafny.DafnySequence<? extends Character> _1328___mcc_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_S)_source30)._S;
      dafny.DafnySequence<? extends Character> _1329_s = _1328___mcc_h0;
      return _1329_s;
    } else if (_source30.is_N()) {
      dafny.DafnySequence<? extends Character> _1330___mcc_h2 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_N)_source30)._N;
      dafny.DafnySequence<? extends Character> _1331_n = _1330___mcc_h2;
      return _1331_n;
    } else if (_source30.is_B()) {
      dafny.DafnySequence<? extends java.lang.Byte> _1332___mcc_h4 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_B)_source30)._B;
      return dafny.DafnySequence.asString("");
    } else if (_source30.is_SS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1333___mcc_h6 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_SS)_source30)._SS;
      return dafny.DafnySequence.asString("");
    } else if (_source30.is_NS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1334___mcc_h8 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_NS)_source30)._NS;
      return dafny.DafnySequence.asString("");
    } else if (_source30.is_BS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _1335___mcc_h10 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_BS)_source30)._BS;
      return dafny.DafnySequence.asString("");
    } else if (_source30.is_M()) {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1336___mcc_h12 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_M)_source30)._M;
      return dafny.DafnySequence.asString("");
    } else if (_source30.is_L()) {
      dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1337___mcc_h14 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_L)_source30)._L;
      return dafny.DafnySequence.asString("");
    } else if (_source30.is_NULL()) {
      boolean _1338___mcc_h16 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_NULL)_source30)._NULL;
      return dafny.DafnySequence.asString("");
    } else {
      boolean _1339___mcc_h18 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_BOOL)_source30)._BOOL;
      return dafny.DafnySequence.asString("");
    }
  }
  public static boolean IsAttrType(StackValue attr, StackValue typeStr)
  {
    return (DynamoDbEncryptionUtil_Compile.__default.AttrTypeToStr(__default.GetStr(attr))).equals(__default.AttrToStr(__default.GetStr(typeStr)));
  }
  public static Wrappers_Compile.Result<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> apply__function(Token input, dafny.DafnySequence<? extends StackValue> stack, java.math.BigInteger num__args)
  {
    Token _source31 = input;
    if (_source31.is_Attr()) {
      dafny.DafnySequence<? extends Character> _1340___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source31)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1341___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source31)._loc;
      return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(true));
    } else if (_source31.is_Value()) {
      dafny.DafnySequence<? extends Character> _1342___mcc_h4 = ((DynamoDBFilterExpr_Compile.Token_Value)_source31)._s;
      return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(true));
    } else if (_source31.is_Eq()) {
      return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(true));
    } else if (_source31.is_Ne()) {
      return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(true));
    } else if (_source31.is_Lt()) {
      return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(true));
    } else if (_source31.is_Gt()) {
      return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(true));
    } else if (_source31.is_Le()) {
      return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(true));
    } else if (_source31.is_Ge()) {
      return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(true));
    } else if (_source31.is_Between()) {
      if ((java.math.BigInteger.valueOf((stack).length())).compareTo(java.math.BigInteger.valueOf(3L)) < 0) {
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("No Stack for Between")));
      } else if ((((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))).is_Str()) && ((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.valueOf(2L)))))))).is_Str())) && ((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.valueOf(3L)))))))).is_Str())) {
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(__default.is__between((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.valueOf(3L)))))))).dtor_s(), (((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.valueOf(2L)))))))).dtor_s(), (((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))).dtor_s())));
      } else {
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Wrong Types for contains")));
      }
    } else if (_source31.is_In()) {
      java.math.BigInteger _1343_num = __default.StringsFollowing(stack);
      if ((java.math.BigInteger.valueOf((stack).length())).compareTo(_1343_num) < 0) {
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Tautology False")));
      } else if ((_1343_num).signum() == 0) {
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("In has no args")));
      } else {
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(__default.is__in(__default.GetStr(((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(_1343_num))))))), (stack).drop(((java.math.BigInteger.valueOf((stack).length())).subtract(_1343_num)).add(java.math.BigInteger.ONE)))));
      }
    } else if (_source31.is_Open()) {
      return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(true));
    } else if (_source31.is_Close()) {
      return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(true));
    } else if (_source31.is_Comma()) {
      return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(true));
    } else if (_source31.is_Not()) {
      return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(true));
    } else if (_source31.is_And()) {
      return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(true));
    } else if (_source31.is_Or()) {
      return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(true));
    } else if (_source31.is_AttributeExists()) {
      if ((java.math.BigInteger.valueOf((stack).length())).compareTo(java.math.BigInteger.ONE) < 0) {
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("No Stack for AttributeExists")));
      } else {
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(!((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))).is_DoesNotExist())));
      }
    } else if (_source31.is_AttributeNotExists()) {
      if ((java.math.BigInteger.valueOf((stack).length())).compareTo(java.math.BigInteger.ONE) < 0) {
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("No Stack for AttributeExists")));
      } else {
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))).is_DoesNotExist()));
      }
    } else if (_source31.is_AttributeType()) {
      if ((java.math.BigInteger.valueOf((stack).length())).compareTo(java.math.BigInteger.valueOf(2L)) < 0) {
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("No Stack for AttributeType")));
      } else {
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(__default.IsAttrType(((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.valueOf(2L))))))), ((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))))));
      }
    } else if (_source31.is_BeginsWith()) {
      if ((java.math.BigInteger.valueOf((stack).length())).compareTo(java.math.BigInteger.valueOf(2L)) < 0) {
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("No Stack for BeginsWith")));
      } else if (((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))).is_Str()) && ((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.valueOf(2L)))))))).is_Str())) {
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(__default.begins__with((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.valueOf(2L)))))))).dtor_s(), (((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))).dtor_s())));
      } else {
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Wrong Types for BeginsWith")));
      }
    } else if (_source31.is_Contains()) {
      if ((java.math.BigInteger.valueOf((stack).length())).compareTo(java.math.BigInteger.valueOf(2L)) < 0) {
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("No Stack for contains")));
      } else if (((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))).is_Str()) && ((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.valueOf(2L)))))))).is_Str())) {
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(__default.does__contain((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.valueOf(2L)))))))).dtor_s(), (((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))).dtor_s())));
      } else {
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Wrong Types for contains")));
      }
    } else {
      if ((java.math.BigInteger.valueOf((stack).length())).compareTo(java.math.BigInteger.ONE) < 0) {
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("No Stack for Size")));
      } else if (!((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))).is_Str())) {
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Wrong Types for Size")));
      } else {
        java.math.BigInteger _1344_n = __default.GetSize((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE))))))).dtor_s());
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Str(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_N(String_Compile.__default.Base10Int2String(_1344_n))));
      }
    }
  }
  public static Wrappers_Compile.Result<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> apply__unary(Token input, StackValue stack)
  {
    if ((stack).is_Bool()) {
      return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(!((stack).dtor_b())));
    } else {
      return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("wrong type for Not")));
    }
  }
  public static Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> apply__binary__bool(Token input, boolean x, boolean y)
  {
    Token _source32 = input;
    if (_source32.is_Attr()) {
      dafny.DafnySequence<? extends Character> _1345___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source32)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1346___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source32)._loc;
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source32.is_Value()) {
      dafny.DafnySequence<? extends Character> _1347___mcc_h4 = ((DynamoDBFilterExpr_Compile.Token_Value)_source32)._s;
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source32.is_Eq()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source32.is_Ne()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source32.is_Lt()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source32.is_Gt()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source32.is_Le()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source32.is_Ge()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source32.is_Between()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source32.is_In()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source32.is_Open()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source32.is_Close()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source32.is_Comma()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source32.is_Not()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source32.is_And()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success((x) && (y));
    } else if (_source32.is_Or()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success((x) || (y));
    } else if (_source32.is_AttributeExists()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source32.is_AttributeNotExists()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source32.is_AttributeType()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source32.is_BeginsWith()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source32.is_Contains()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    }
  }
  public static <__T> boolean LexicographicLess(dafny.TypeDescriptor<__T> _td___T, dafny.DafnySequence<? extends __T> a, dafny.DafnySequence<? extends __T> b, dafny.Function2<__T, __T, Boolean> less)
  {
    return !(StandardLibrary_Compile.__default.<__T>LexicographicLessOrEqual(_td___T, b, a, less));
  }
  public static <__T> boolean LexicographicGreater(dafny.TypeDescriptor<__T> _td___T, dafny.DafnySequence<? extends __T> a, dafny.DafnySequence<? extends __T> b, dafny.Function2<__T, __T, Boolean> less)
  {
    return !(StandardLibrary_Compile.__default.<__T>LexicographicLessOrEqual(_td___T, a, b, less));
  }
  public static <__T> boolean LexicographicGreaterOrEqual(dafny.TypeDescriptor<__T> _td___T, dafny.DafnySequence<? extends __T> a, dafny.DafnySequence<? extends __T> b, dafny.Function2<__T, __T, Boolean> less)
  {
    return StandardLibrary_Compile.__default.<__T>LexicographicLessOrEqual(_td___T, b, a, less);
  }
  public static boolean CharLess(char a, char b)
  {
    return (a) < (b);
  }
  public static boolean ByteLess(byte a, byte b)
  {
    return java.lang.Integer.compareUnsigned(a, b) < 0;
  }
  public static boolean AttributeLE(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue a, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue b)
  {
    if (((a).is_N()) && ((b).is_N())) {
      return java.lang.Integer.signum((FloatCompare_Compile.__default.CompareFloat((a).dtor_N(), (b).dtor_N()))) != 1;
    } else if (((a).is_S()) && ((b).is_S())) {
      return StandardLibrary_Compile.__default.<Character>LexicographicLessOrEqual(dafny.TypeDescriptor.CHAR, (a).dtor_S(), (b).dtor_S(), __default::CharLess);
    } else if (((a).is_B()) && ((b).is_B())) {
      return StandardLibrary_Compile.__default.<java.lang.Byte>LexicographicLessOrEqual(StandardLibrary_mUInt_Compile.uint8._typeDescriptor(), (a).dtor_B(), (b).dtor_B(), __default::ByteLess);
    } else {
      return false;
    }
  }
  public static boolean AttributeLT(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue a, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue b)
  {
    return !(__default.AttributeLE(b, a));
  }
  public static boolean AttributeGT(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue a, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue b)
  {
    return !(__default.AttributeLE(a, b));
  }
  public static boolean AttributeGE(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue a, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue b)
  {
    return __default.AttributeLE(b, a);
  }
  public static Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> apply__binary__comp(Token input, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue x, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue y)
  {
    Token _source33 = input;
    if (_source33.is_Attr()) {
      dafny.DafnySequence<? extends Character> _1348___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source33)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1349___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source33)._loc;
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source33.is_Value()) {
      dafny.DafnySequence<? extends Character> _1350___mcc_h4 = ((DynamoDBFilterExpr_Compile.Token_Value)_source33)._s;
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source33.is_Eq()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(java.util.Objects.equals(x, y));
    } else if (_source33.is_Ne()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(!java.util.Objects.equals(x, y));
    } else if (_source33.is_Lt()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(__default.AttributeLT(x, y));
    } else if (_source33.is_Gt()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(__default.AttributeGT(x, y));
    } else if (_source33.is_Le()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(__default.AttributeLE(x, y));
    } else if (_source33.is_Ge()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(__default.AttributeGE(x, y));
    } else if (_source33.is_Between()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source33.is_In()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source33.is_Open()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source33.is_Close()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source33.is_Comma()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source33.is_Not()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source33.is_And()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source33.is_Or()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source33.is_AttributeExists()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source33.is_AttributeNotExists()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source33.is_AttributeType()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source33.is_BeginsWith()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else if (_source33.is_Contains()) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    } else {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("invalid op in apply_binary_bool")));
    }
  }
  public static Wrappers_Compile.Result<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> apply__binary(Token input, StackValue x, StackValue y)
  {
    if (__default.IsComp(input)) {
      if (((x).is_Str()) && ((y).is_Str())) {
        Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1351_valueOrError0 = __default.apply__binary__comp(input, (x).dtor_s(), (y).dtor_s());
        if ((_1351_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_1351_valueOrError0).<StackValue>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), StackValue._typeDescriptor());
        } else {
          boolean _1352_val = (_1351_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(_1352_val));
        }
      } else {
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("wrong types for comparison")));
      }
    } else if (((x).is_Bool()) && ((y).is_Bool())) {
      Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1353_valueOrError1 = __default.apply__binary__bool(input, (x).dtor_b(), (y).dtor_b());
      if ((_1353_valueOrError1).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1353_valueOrError1).<StackValue>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), StackValue._typeDescriptor());
      } else {
        boolean _1354_val = (_1353_valueOrError1).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.StackValue.create_Bool(_1354_val));
      }
    } else {
      return Wrappers_Compile.Result.<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("wrong types for boolean binary")));
    }
  }
  public static java.math.BigInteger NumArgs(Token t, dafny.DafnySequence<? extends StackValue> stack)
  {
    Token _source34 = t;
    if (_source34.is_Attr()) {
      dafny.DafnySequence<? extends Character> _1355___mcc_h0 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source34)._s;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1356___mcc_h1 = ((DynamoDBFilterExpr_Compile.Token_Attr)_source34)._loc;
      return java.math.BigInteger.ZERO;
    } else if (_source34.is_Value()) {
      dafny.DafnySequence<? extends Character> _1357___mcc_h4 = ((DynamoDBFilterExpr_Compile.Token_Value)_source34)._s;
      return java.math.BigInteger.ZERO;
    } else if (_source34.is_Eq()) {
      return java.math.BigInteger.ZERO;
    } else if (_source34.is_Ne()) {
      return java.math.BigInteger.ZERO;
    } else if (_source34.is_Lt()) {
      return java.math.BigInteger.ZERO;
    } else if (_source34.is_Gt()) {
      return java.math.BigInteger.ZERO;
    } else if (_source34.is_Le()) {
      return java.math.BigInteger.ZERO;
    } else if (_source34.is_Ge()) {
      return java.math.BigInteger.ZERO;
    } else if (_source34.is_Between()) {
      return java.math.BigInteger.valueOf(3L);
    } else if (_source34.is_In()) {
      return __default.StringsFollowing(stack);
    } else if (_source34.is_Open()) {
      return java.math.BigInteger.ZERO;
    } else if (_source34.is_Close()) {
      return java.math.BigInteger.ZERO;
    } else if (_source34.is_Comma()) {
      return java.math.BigInteger.ZERO;
    } else if (_source34.is_Not()) {
      return java.math.BigInteger.ZERO;
    } else if (_source34.is_And()) {
      return java.math.BigInteger.ZERO;
    } else if (_source34.is_Or()) {
      return java.math.BigInteger.ZERO;
    } else if (_source34.is_AttributeExists()) {
      return java.math.BigInteger.ONE;
    } else if (_source34.is_AttributeNotExists()) {
      return java.math.BigInteger.ONE;
    } else if (_source34.is_AttributeType()) {
      return java.math.BigInteger.valueOf(2L);
    } else if (_source34.is_BeginsWith()) {
      return java.math.BigInteger.valueOf(2L);
    } else if (_source34.is_Contains()) {
      return java.math.BigInteger.valueOf(2L);
    } else {
      return java.math.BigInteger.ONE;
    }
  }
  public static Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> InnerEvalExpr(dafny.DafnySequence<? extends Token> input, dafny.DafnySequence<? extends StackValue> stack, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> values)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((input).length())).signum() == 0) {
        if ((java.util.Objects.equals(java.math.BigInteger.ONE, java.math.BigInteger.valueOf((stack).length()))) && ((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).is_Bool())) {
          return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success((((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_b());
        } else {
          return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("ended with bad stack")));
        }
      } else {
        Token _1358_t = ((Token)(java.lang.Object)((input).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))));
        if ((_1358_t).is_Value()) {
          dafny.DafnySequence<? extends Token> _in328 = (input).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends StackValue> _in329 = dafny.DafnySequence.<StackValue>concatenate(stack, dafny.DafnySequence.of(StackValue._typeDescriptor(), __default.StackValueFromValue((_1358_t).dtor_s(), values)));
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in330 = item;
          Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in331 = names;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in332 = values;
          input = _in328;
          stack = _in329;
          item = _in330;
          names = _in331;
          values = _in332;
          continue TAIL_CALL_START;
        } else if ((_1358_t).is_Attr()) {
          dafny.DafnySequence<? extends Token> _in333 = (input).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends StackValue> _in334 = dafny.DafnySequence.<StackValue>concatenate(stack, dafny.DafnySequence.of(StackValue._typeDescriptor(), __default.StackValueFromAttr(_1358_t, item, names)));
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in335 = item;
          Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in336 = names;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in337 = values;
          input = _in333;
          stack = _in334;
          item = _in335;
          names = _in336;
          values = _in337;
          continue TAIL_CALL_START;
        } else if (__default.IsUnary(_1358_t)) {
          if ((java.math.BigInteger.valueOf((stack).length())).signum() == 0) {
            return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Empty stack for unary op")));
          } else {
            Wrappers_Compile.Result<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1359_valueOrError0 = __default.apply__unary(_1358_t, ((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))));
            if ((_1359_valueOrError0).IsFailure(StackValue._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
              return (_1359_valueOrError0).<Boolean>PropagateFailure(StackValue._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
            } else {
              StackValue _1360_val = (_1359_valueOrError0).Extract(StackValue._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
              dafny.DafnySequence<? extends Token> _in338 = (input).drop(java.math.BigInteger.ONE);
              dafny.DafnySequence<? extends StackValue> _in339 = dafny.DafnySequence.<StackValue>concatenate((stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)), dafny.DafnySequence.of(StackValue._typeDescriptor(), _1360_val));
              dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in340 = item;
              Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in341 = names;
              dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in342 = values;
              input = _in338;
              stack = _in339;
              item = _in340;
              names = _in341;
              values = _in342;
              continue TAIL_CALL_START;
            }
          }
        } else if (__default.IsBinary(_1358_t)) {
          if ((java.math.BigInteger.valueOf((stack).length())).compareTo(java.math.BigInteger.valueOf(2L)) < 0) {
            return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Empty stack for binary op")));
          } else {
            Wrappers_Compile.Result<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1361_valueOrError1 = __default.apply__binary(_1358_t, ((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.valueOf(2L))))))), ((StackValue)(java.lang.Object)((stack).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.ONE)))))));
            if ((_1361_valueOrError1).IsFailure(StackValue._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
              return (_1361_valueOrError1).<Boolean>PropagateFailure(StackValue._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
            } else {
              StackValue _1362_val = (_1361_valueOrError1).Extract(StackValue._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
              dafny.DafnySequence<? extends Token> _in343 = (input).drop(java.math.BigInteger.ONE);
              dafny.DafnySequence<? extends StackValue> _in344 = dafny.DafnySequence.<StackValue>concatenate((stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(java.math.BigInteger.valueOf(2L))), dafny.DafnySequence.of(StackValue._typeDescriptor(), _1362_val));
              dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in345 = item;
              Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in346 = names;
              dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in347 = values;
              input = _in343;
              stack = _in344;
              item = _in345;
              names = _in346;
              values = _in347;
              continue TAIL_CALL_START;
            }
          }
        } else if (__default.IsFunction(_1358_t)) {
          java.math.BigInteger _1363_num__args = __default.NumArgs(_1358_t, stack);
          if ((java.math.BigInteger.valueOf((stack).length())).compareTo(_1363_num__args) < 0) {
            return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Empty stack for function call")));
          } else {
            Wrappers_Compile.Result<StackValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1364_valueOrError2 = __default.apply__function(_1358_t, stack, _1363_num__args);
            if ((_1364_valueOrError2).IsFailure(StackValue._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
              return (_1364_valueOrError2).<Boolean>PropagateFailure(StackValue._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
            } else {
              StackValue _1365_val = (_1364_valueOrError2).Extract(StackValue._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
              dafny.DafnySequence<? extends Token> _in348 = (input).drop(java.math.BigInteger.ONE);
              dafny.DafnySequence<? extends StackValue> _in349 = dafny.DafnySequence.<StackValue>concatenate((stack).take((java.math.BigInteger.valueOf((stack).length())).subtract(_1363_num__args)), dafny.DafnySequence.of(StackValue._typeDescriptor(), _1365_val));
              dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in350 = item;
              Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in351 = names;
              dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in352 = values;
              input = _in348;
              stack = _in349;
              item = _in350;
              names = _in351;
              values = _in352;
              continue TAIL_CALL_START;
            }
          }
        } else {
          return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> FilterItems(SearchableEncryptionInfo_Compile.BeaconVersion b, dafny.DafnySequence<? extends Token> parsed, dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> ItemList, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> values)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> empty(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())));
    if(true) {
      if ((java.math.BigInteger.valueOf((ItemList).length())).signum() == 0) {
        output = Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> empty(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())));
        return output;
      }
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1366_newAttrs;
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1367_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out64;
      _out64 = (b).GeneratePlainBeacons(((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>)(java.lang.Object)((ItemList).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))));
      _1367_valueOrError0 = _out64;
      if ((_1367_valueOrError0).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        output = (_1367_valueOrError0).<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())));
        return output;
      }
      _1366_newAttrs = (_1367_valueOrError0).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      boolean _1368_doesMatch;
      Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1369_valueOrError1 = Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(false);
      _1369_valueOrError1 = __default.EvalExpr(parsed, dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>merge(((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>)(java.lang.Object)((ItemList).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), _1366_newAttrs), names, values);
      if ((_1369_valueOrError1).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        output = (_1369_valueOrError1).<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())));
        return output;
      }
      _1368_doesMatch = (_1369_valueOrError1).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> _1370_rest;
      Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1371_valueOrError2 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> empty(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())));
      Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out65;
      _out65 = __default.FilterItems(b, parsed, (ItemList).drop(java.math.BigInteger.ONE), names, values);
      _1371_valueOrError2 = _out65;
      if ((_1371_valueOrError2).IsFailure(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        output = (_1371_valueOrError2).<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>PropagateFailure(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())));
        return output;
      }
      _1370_rest = (_1371_valueOrError2).Extract(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      if (_1368_doesMatch) {
        output = Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>concatenate((ItemList).take(java.math.BigInteger.ONE), _1370_rest));
        return output;
      } else {
        output = Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(_1370_rest);
        return output;
      }
    }
    return output;
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> FilterResults(SearchableEncryptionInfo_Compile.BeaconVersion b, dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> ItemList, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> KeyExpression, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> FilterExpression, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> values)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> empty(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())));
    if(true) {
      if (((java.math.BigInteger.valueOf((ItemList).length())).signum() == 0) || (((KeyExpression).is_None()) && ((FilterExpression).is_None()))) {
        output = Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(ItemList);
        return output;
      } else {
        dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> _1372_afterKeys = dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> empty(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()));
        if ((KeyExpression).is_Some()) {
          dafny.DafnySequence<? extends Token> _1373_parsed;
          Wrappers_Compile.Result<dafny.DafnySequence<? extends Token>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1374_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends Token>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnySequence.<Token> empty(Token._typeDescriptor()));
          _1374_valueOrError0 = __default.GetParsedExpr((KeyExpression).dtor_value());
          if ((_1374_valueOrError0).IsFailure(dafny.DafnySequence.<Token>_typeDescriptor(Token._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
            output = (_1374_valueOrError0).<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>PropagateFailure(dafny.DafnySequence.<Token>_typeDescriptor(Token._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())));
            return output;
          }
          _1373_parsed = (_1374_valueOrError0).Extract(dafny.DafnySequence.<Token>_typeDescriptor(Token._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          dafny.DafnySequence<? extends Token> _1375_parsed2;
          _1375_parsed2 = __default.ParseExpr((KeyExpression).dtor_value());
          ParsedContext _1376_expr;
          Wrappers_Compile.Result<ParsedContext, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1377_valueOrError1 = Wrappers_Compile.Result.<ParsedContext, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(ParsedContext.Default());
          _1377_valueOrError1 = __default.BeaconizeParsedExpr(b, _1375_parsed2, java.math.BigInteger.ZERO, (values).UnwrapOr(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements()), names, DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_DontUseKeys(), dafny.DafnyMap.fromElements(), dafny.DafnySequence.<Token> empty(Token._typeDescriptor()));
          if ((_1377_valueOrError1).IsFailure(ParsedContext._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
            output = (_1377_valueOrError1).<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>PropagateFailure(ParsedContext._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())));
            return output;
          }
          _1376_expr = (_1377_valueOrError1).Extract(ParsedContext._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          dafny.DafnySequence<? extends Token> _1378_expr1;
          _1378_expr1 = __default.ConvertToPrefix((_1376_expr).dtor_expr());
          dafny.DafnySequence<? extends Token> _1379_expr2;
          _1379_expr2 = __default.ConvertToRpn(_1378_expr1);
          Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1380_valueOrError2 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> empty(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())));
          Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out66;
          _out66 = __default.FilterItems(b, _1379_expr2, ItemList, (_1376_expr).dtor_names(), (_1376_expr).dtor_values());
          _1380_valueOrError2 = _out66;
          if ((_1380_valueOrError2).IsFailure(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
            output = (_1380_valueOrError2).<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>PropagateFailure(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())));
            return output;
          }
          _1372_afterKeys = (_1380_valueOrError2).Extract(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        } else {
          _1372_afterKeys = ItemList;
        }
        if ((FilterExpression).is_Some()) {
          dafny.DafnySequence<? extends Token> _1381_parsed;
          _1381_parsed = __default.ParseExpr((FilterExpression).dtor_value());
          ParsedContext _1382_expr;
          Wrappers_Compile.Result<ParsedContext, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1383_valueOrError3 = Wrappers_Compile.Result.<ParsedContext, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(ParsedContext.Default());
          _1383_valueOrError3 = __default.BeaconizeParsedExpr(b, _1381_parsed, java.math.BigInteger.ZERO, (values).UnwrapOr(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements()), names, DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_DontUseKeys(), dafny.DafnyMap.fromElements(), dafny.DafnySequence.<Token> empty(Token._typeDescriptor()));
          if ((_1383_valueOrError3).IsFailure(ParsedContext._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
            output = (_1383_valueOrError3).<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>PropagateFailure(ParsedContext._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())));
            return output;
          }
          _1382_expr = (_1383_valueOrError3).Extract(ParsedContext._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          dafny.DafnySequence<? extends Token> _1384_expr1;
          _1384_expr1 = __default.ConvertToPrefix((_1382_expr).dtor_expr());
          dafny.DafnySequence<? extends Token> _1385_expr2;
          _1385_expr2 = __default.ConvertToRpn(_1384_expr1);
          Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out67;
          _out67 = __default.FilterItems(b, _1385_expr2, _1372_afterKeys, (_1382_expr).dtor_names(), (_1382_expr).dtor_values());
          output = _out67;
        } else {
          output = Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(_1372_afterKeys);
          return output;
        }
      }
    }
    return output;
  }
  public static dafny.DafnySequence<? extends Character> GetName(dafny.DafnySequence<? extends Character> s, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> ExpressionAttributeNames)
  {
    if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
      return s;
    } else if ((((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) != ('#')) {
      return s;
    } else if ((ExpressionAttributeNames).is_None()) {
      return dafny.DafnySequence.asString("");
    } else if (((ExpressionAttributeNames).dtor_value()).<dafny.DafnySequence<? extends Character>>contains(s)) {
      return ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((ExpressionAttributeNames).dtor_value()).get(s)));
    } else {
      return (s).drop(java.math.BigInteger.ONE);
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> KeyIdFromPart(SearchableEncryptionInfo_Compile.BeaconVersion bv, dafny.DafnySequence<? extends Character> keyIdField, dafny.DafnySequence<? extends Character> attr, dafny.DafnySequence<? extends Character> value)
  {
    if ((!((bv).dtor_beacons()).<dafny.DafnySequence<? extends Character>>contains(attr)) || ((((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)(((bv).dtor_beacons()).get(attr)))).is_Standard())) {
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None();
    } else {
      dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> _1386_parts = ((((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)(((bv).dtor_beacons()).get(attr)))).dtor_cmp()).dtor_parts();
      dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> _1387_theParts = Seq_Compile.__default.<CompoundBeacon_Compile.BeaconPart>Filter(CompoundBeacon_Compile.BeaconPart._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, java.util.function.Function<CompoundBeacon_Compile.BeaconPart, Boolean>>)(_1388_keyIdField) -> ((java.util.function.Function<CompoundBeacon_Compile.BeaconPart, Boolean>)(_1389_p_boxed0) -> {
        CompoundBeacon_Compile.BeaconPart _1389_p = ((CompoundBeacon_Compile.BeaconPart)(java.lang.Object)(_1389_p_boxed0));
        return ((_1389_p).is_NonSensitive()) && (((((TermLoc_Compile.Selector)(java.lang.Object)(((_1389_p).dtor_loc()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key()).equals(_1388_keyIdField));
      })).apply(keyIdField), _1386_parts);
      if (!java.util.Objects.equals(java.math.BigInteger.valueOf((_1387_theParts).length()), java.math.BigInteger.ONE)) {
        return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None();
      } else {
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1390_pieces = StandardLibrary_Compile.__default.<Character>Split(dafny.TypeDescriptor.CHAR, value, ((((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)(((bv).dtor_beacons()).get(attr)))).dtor_cmp()).dtor_split());
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1391_piece = Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>Filter(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((java.util.function.Function<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>, java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>>)(_1392_theParts) -> ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>)(_1393_s_boxed0) -> {
          dafny.DafnySequence<? extends Character> _1393_s = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_1393_s_boxed0));
          return ((((CompoundBeacon_Compile.BeaconPart)(java.lang.Object)((_1392_theParts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_prefix()).isPrefixOf(_1393_s);
        })).apply(_1387_theParts), _1390_pieces);
        if (!java.util.Objects.equals(java.math.BigInteger.valueOf((_1391_piece).length()), java.math.BigInteger.ONE)) {
          return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None();
        } else {
          dafny.DafnySequence<? extends Character> _1394_p = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_1391_piece).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))));
          return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some((_1394_p).drop(java.math.BigInteger.valueOf(((((CompoundBeacon_Compile.BeaconPart)(java.lang.Object)((_1387_theParts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_prefix()).length())));
        }
      }
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> KeyIdFromAttr(SearchableEncryptionInfo_Compile.BeaconVersion bv, Wrappers_Compile.Option<Token> attr, dafny.DafnySequence<? extends Character> value, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names)
  {
    if ((attr).is_None()) {
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None();
    } else {
      dafny.DafnySequence<? extends Character> _1395_name = ((((names).is_Some()) && (((names).dtor_value()).<dafny.DafnySequence<? extends Character>>contains(((attr).dtor_value()).dtor_s()))) ? (((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((names).dtor_value()).get(((attr).dtor_value()).dtor_s())))) : (((attr).dtor_value()).dtor_s()));
      dafny.DafnySequence<? extends Character> _1396_keyIdField = (((bv).dtor_keySource()).dtor_keyLoc()).dtor_keyName();
      if ((_1396_keyIdField).equals(((attr).dtor_value()).dtor_s())) {
        return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(value);
      } else {
        return __default.KeyIdFromPart(bv, _1396_keyIdField, ((attr).dtor_value()).dtor_s(), value);
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GetBeaconKeyIds2(java.math.BigInteger pos, SearchableEncryptionInfo_Compile.BeaconVersion bv, dafny.DafnySequence<? extends Token> expr, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> values, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> soFar)
  {
    TAIL_CALL_START: while (true) {
      if (java.util.Objects.equals(pos, java.math.BigInteger.valueOf((expr).length()))) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(soFar);
      } else if ((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).is_Value()) {
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1397_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), (values).<dafny.DafnySequence<? extends Character>>contains((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).dtor_s()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).dtor_s(), dafny.DafnySequence.asString(" not found in ExpressionAttributeValueMap"))));
        if ((_1397_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_1397_valueOrError0).<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
        } else {
          Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _1398_oldValue = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue)(java.lang.Object)((values).get((((Token)(java.lang.Object)((expr).select(dafny.Helpers.toInt((pos)))))).dtor_s())));
          if ((_1398_oldValue).is_S()) {
            Wrappers_Compile.Option<Token> _1399_attr = __default.AttrForValue(expr, pos);
            Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _1400_keyId = __default.KeyIdFromAttr(bv, _1399_attr, (_1398_oldValue).dtor_S(), names);
            if (((_1400_keyId).is_None()) || ((soFar).contains((_1400_keyId).dtor_value()))) {
              java.math.BigInteger _in353 = (pos).add(java.math.BigInteger.ONE);
              SearchableEncryptionInfo_Compile.BeaconVersion _in354 = bv;
              dafny.DafnySequence<? extends Token> _in355 = expr;
              dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in356 = values;
              Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in357 = names;
              dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in358 = soFar;
              pos = _in353;
              bv = _in354;
              expr = _in355;
              values = _in356;
              names = _in357;
              soFar = _in358;
              continue TAIL_CALL_START;
            } else {
              java.math.BigInteger _in359 = (pos).add(java.math.BigInteger.ONE);
              SearchableEncryptionInfo_Compile.BeaconVersion _in360 = bv;
              dafny.DafnySequence<? extends Token> _in361 = expr;
              dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in362 = values;
              Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in363 = names;
              dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in364 = dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(soFar, dafny.DafnySequence.of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (_1400_keyId).dtor_value()));
              pos = _in359;
              bv = _in360;
              expr = _in361;
              values = _in362;
              names = _in363;
              soFar = _in364;
              continue TAIL_CALL_START;
            }
          } else {
            java.math.BigInteger _in365 = (pos).add(java.math.BigInteger.ONE);
            SearchableEncryptionInfo_Compile.BeaconVersion _in366 = bv;
            dafny.DafnySequence<? extends Token> _in367 = expr;
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in368 = values;
            Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in369 = names;
            dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in370 = soFar;
            pos = _in365;
            bv = _in366;
            expr = _in367;
            values = _in368;
            names = _in369;
            soFar = _in370;
            continue TAIL_CALL_START;
          }
        }
      } else {
        java.math.BigInteger _in371 = (pos).add(java.math.BigInteger.ONE);
        SearchableEncryptionInfo_Compile.BeaconVersion _in372 = bv;
        dafny.DafnySequence<? extends Token> _in373 = expr;
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in374 = values;
        Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in375 = names;
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in376 = soFar;
        pos = _in371;
        bv = _in372;
        expr = _in373;
        values = _in374;
        names = _in375;
        soFar = _in376;
        continue TAIL_CALL_START;
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GetBeaconKeyIds(SearchableEncryptionInfo_Compile.BeaconVersion bv, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> expr, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> values, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> soFar)
  {
    if ((expr).is_None()) {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(soFar);
    } else {
      dafny.DafnySequence<? extends Token> _1401_parsed = __default.ParseExpr((expr).dtor_value());
      return __default.GetBeaconKeyIds2(java.math.BigInteger.ZERO, bv, _1401_parsed, values, names, soFar);
    }
  }
  public static Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyId, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GetBeaconKeyId(SearchableEncryptionInfo_Compile.BeaconVersion bv, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> keyExpr, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> filterExpr, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> values, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names)
  {
    if (!((((bv).dtor_keySource()).dtor_keyLoc()).is_MultiLoc())) {
      return Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyId, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    } else if ((values).is_None()) {
      return Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyId, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_ShouldHaveKeyId());
    } else {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1402_valueOrError0 = __default.GetBeaconKeyIds(bv, keyExpr, (values).dtor_value(), names, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
      if ((_1402_valueOrError0).IsFailure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1402_valueOrError0).<DynamoDbEncryptionUtil_Compile.MaybeKeyId>PropagateFailure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor());
      } else {
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1403_soFar = (_1402_valueOrError0).Extract(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1404_valueOrError1 = __default.GetBeaconKeyIds(bv, filterExpr, (values).dtor_value(), names, _1403_soFar);
        if ((_1404_valueOrError1).IsFailure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_1404_valueOrError1).<DynamoDbEncryptionUtil_Compile.MaybeKeyId>PropagateFailure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor());
        } else {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1405_final = (_1404_valueOrError1).Extract(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          if (java.util.Objects.equals(java.math.BigInteger.valueOf((_1405_final).length()), java.math.BigInteger.ONE)) {
            return Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyId, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_KeyId(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_1405_final).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
          } else if ((java.math.BigInteger.valueOf((_1405_final).length())).signum() == 0) {
            return Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyId, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_ShouldHaveKeyId());
          } else {
            return Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyId, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Multiple values found for "), (((bv).dtor_keySource()).dtor_keyLoc()).dtor_keyName()), dafny.DafnySequence.asString(" in query : ")), StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _1405_final, dafny.DafnySequence.asString(", ")))));
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<ExprContext, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> Beaconize(SearchableEncryptionInfo_Compile.BeaconVersion b, ExprContext context, DynamoDbEncryptionUtil_Compile.MaybeKeyId keyId, boolean naked)
  {
    Wrappers_Compile.Result<ExprContext, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = Wrappers_Compile.Result.<ExprContext, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(ExprContext.Default());
    if(true) {
      if (((((context).dtor_keyExpr()).is_None()) && (((context).dtor_filterExpr()).is_None())) || (((context).dtor_values()).is_None())) {
        output = Wrappers_Compile.Result.<ExprContext, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(context);
        return output;
      } else {
        DynamoDbEncryptionUtil_Compile.MaybeKeyMap _1406_keys;
        _1406_keys = DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_DontUseKeys();
        if (!(naked)) {
          Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1407_valueOrError0 = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(DynamoDbEncryptionUtil_Compile.MaybeKeyMap.Default());
          Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out68;
          _out68 = (b).getKeyMap(keyId);
          _1407_valueOrError0 = _out68;
          if ((_1407_valueOrError0).IsFailure(DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
            output = (_1407_valueOrError0).<ExprContext>PropagateFailure(DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ExprContext._typeDescriptor());
            return output;
          }
          _1406_keys = (_1407_valueOrError0).Extract(DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        }
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1408_newValues;
        _1408_newValues = dafny.DafnyMap.fromElements();
        Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _1409_newKeyExpr;
        _1409_newKeyExpr = (context).dtor_keyExpr();
        Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _1410_newFilterExpr;
        _1410_newFilterExpr = (context).dtor_filterExpr();
        Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _1411_newNames;
        _1411_newNames = (context).dtor_names();
        if (((context).dtor_keyExpr()).is_Some()) {
          dafny.DafnySequence<? extends Token> _1412_parsed;
          _1412_parsed = __default.ParseExpr(((context).dtor_keyExpr()).dtor_value());
          ParsedContext _1413_newContext;
          Wrappers_Compile.Result<ParsedContext, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1414_valueOrError1 = Wrappers_Compile.Result.<ParsedContext, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(ParsedContext.Default());
          _1414_valueOrError1 = __default.BeaconizeParsedExpr(b, _1412_parsed, java.math.BigInteger.ZERO, ((context).dtor_values()).dtor_value(), _1411_newNames, _1406_keys, _1408_newValues, dafny.DafnySequence.<Token> empty(Token._typeDescriptor()));
          if ((_1414_valueOrError1).IsFailure(ParsedContext._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
            output = (_1414_valueOrError1).<ExprContext>PropagateFailure(ParsedContext._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ExprContext._typeDescriptor());
            return output;
          }
          _1413_newContext = (_1414_valueOrError1).Extract(ParsedContext._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          _1409_newKeyExpr = Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(__default.ParsedExprToString((_1413_newContext).dtor_expr()));
          _1408_newValues = (_1413_newContext).dtor_values();
          _1411_newNames = (_1413_newContext).dtor_names();
        }
        if (((context).dtor_filterExpr()).is_Some()) {
          dafny.DafnySequence<? extends Token> _1415_parsed;
          _1415_parsed = __default.ParseExpr(((context).dtor_filterExpr()).dtor_value());
          ParsedContext _1416_newContext;
          Wrappers_Compile.Result<ParsedContext, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1417_valueOrError2 = Wrappers_Compile.Result.<ParsedContext, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(ParsedContext.Default());
          _1417_valueOrError2 = __default.BeaconizeParsedExpr(b, _1415_parsed, java.math.BigInteger.ZERO, ((context).dtor_values()).dtor_value(), _1411_newNames, _1406_keys, _1408_newValues, dafny.DafnySequence.<Token> empty(Token._typeDescriptor()));
          if ((_1417_valueOrError2).IsFailure(ParsedContext._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
            output = (_1417_valueOrError2).<ExprContext>PropagateFailure(ParsedContext._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ExprContext._typeDescriptor());
            return output;
          }
          _1416_newContext = (_1417_valueOrError2).Extract(ParsedContext._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          _1410_newFilterExpr = Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(__default.ParsedExprToString((_1416_newContext).dtor_expr()));
          _1408_newValues = (_1416_newContext).dtor_values();
          _1411_newNames = (_1416_newContext).dtor_names();
        }
        output = Wrappers_Compile.Result.<ExprContext, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDBFilterExpr_Compile.ExprContext.create(_1409_newKeyExpr, _1410_newFilterExpr, Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>create_Some(_1408_newValues), _1411_newNames));
        return output;
      }
    }
    return output;
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDBFilterExpr_Compile._default";
  }
}
