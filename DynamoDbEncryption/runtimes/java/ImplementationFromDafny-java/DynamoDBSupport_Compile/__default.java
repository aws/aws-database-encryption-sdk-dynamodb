// Class __default
// Dafny class __default compiled into Java
package DynamoDBSupport_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<Boolean, dafny.DafnySequence<? extends Character>> IsWriteable(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item) {
    if (((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Boolean>)(_1511_item) -> dafny.Helpers.Quantifier((_1511_item).keySet().Elements(), true, ((_forall_var_15_boxed0) -> {
      dafny.DafnySequence<? extends Character> _forall_var_15 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_forall_var_15_boxed0));
      if (true) {
        dafny.DafnySequence<? extends Character> _1512_k = (dafny.DafnySequence<? extends Character>)_forall_var_15;
        return !((_1511_item).<dafny.DafnySequence<? extends Character>>contains(_1512_k)) || (!((DynamoDbEncryptionUtil_Compile.__default.ReservedPrefix()).isPrefixOf(_1512_k)));
      } else {
        return true;
      }
    }))).apply(item)) {
      return Wrappers_Compile.Result.<Boolean, dafny.DafnySequence<? extends Character>>create_Success(true);
    } else {
      dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _1513_bad = ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(_1514_item) -> ((dafny.Function0<dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(() -> {
        java.util.ArrayList<dafny.DafnySequence<? extends Character>> _coll28 = new java.util.ArrayList<>();
        for (dafny.DafnySequence<? extends Character> _compr_29_boxed0 : (_1514_item).keySet().Elements()) {
          dafny.DafnySequence<? extends Character> _compr_29 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_29_boxed0));
          if (true) {
            dafny.DafnySequence<? extends Character> _1515_k = (dafny.DafnySequence<? extends Character>)_compr_29;
            if (((_1514_item).<dafny.DafnySequence<? extends Character>>contains(_1515_k)) && ((DynamoDbEncryptionUtil_Compile.__default.ReservedPrefix()).isPrefixOf(_1515_k))) {
              _coll28.add(_1515_k);
            }
          }
        }
        return new dafny.DafnySet<dafny.DafnySequence<? extends Character>>(_coll28);
      })).apply()).apply(item);
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1516_badSeq = Sets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, _1513_bad, DynamoDbEncryptionUtil_Compile.__default::CharLess);
      if ((java.math.BigInteger.valueOf((_1516_badSeq).length())).signum() == 0) {
        return Wrappers_Compile.Result.<Boolean, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString(""));
      } else {
        return Wrappers_Compile.Result.<Boolean, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Writing reserved attributes not allowed : "), StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _1516_badSeq, dafny.DafnySequence.asString("\n"))));
      }
    }
  }
  public static dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> GetEncryptedAttributes(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> actions, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> expr, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> attrNames)
  {
    if ((expr).is_None()) {
      return dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    } else {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1517_attrs = DynamoDBFilterExpr_Compile.__default.ExtractAttributes((expr).dtor_value(), attrNames);
      return Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>Filter(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>, java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>>)(_1518_actions) -> ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>)(_1519_attr_boxed0) -> {
        dafny.DafnySequence<? extends Character> _1519_attr = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_1519_attr_boxed0));
        return __default.IsEncrypted(_1518_actions, _1519_attr);
      })).apply(actions), _1517_attrs);
    }
  }
  public static Wrappers_Compile.Result<Boolean, dafny.DafnySequence<? extends Character>> TestConditionExpression(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> actions, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> expr, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> attrNames, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> attrValues)
  {
    if ((expr).is_Some()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1520_attrs = __default.GetEncryptedAttributes(actions, expr, attrNames);
      if ((java.math.BigInteger.valueOf((_1520_attrs).length())).signum() == 0) {
        return Wrappers_Compile.Result.<Boolean, dafny.DafnySequence<? extends Character>>create_Success(true);
      } else {
        return Wrappers_Compile.Result.<Boolean, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Condition Expressions forbidden on encrypted attributes : "), StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _1520_attrs, dafny.DafnySequence.asString(","))));
      }
    } else {
      return Wrappers_Compile.Result.<Boolean, dafny.DafnySequence<? extends Character>>create_Success(true);
    }
  }
  public static boolean IsSigned(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> actions, dafny.DafnySequence<? extends Character> attr)
  {
    return ((actions).<dafny.DafnySequence<? extends Character>>contains(attr)) && (!java.util.Objects.equals(((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction)(java.lang.Object)((actions).get(attr))), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_DO__NOTHING()));
  }
  public static boolean IsEncrypted(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> actions, dafny.DafnySequence<? extends Character> attr)
  {
    return ((actions).<dafny.DafnySequence<? extends Character>>contains(attr)) && (java.util.Objects.equals(((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction)(java.lang.Object)((actions).get(attr))), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_ENCRYPT__AND__SIGN()));
  }
  public static Wrappers_Compile.Result<Boolean, dafny.DafnySequence<? extends Character>> TestUpdateExpression(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> actions, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> expr, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> attrNames, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> attrValues)
  {
    if ((expr).is_Some()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1521_attrs = DynamoDbUpdateExpr_Compile.__default.ExtractAttributes((expr).dtor_value(), attrNames);
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1522_encryptedAttrs = Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>Filter(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>, java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>>)(_1523_actions) -> ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>)(_1524_s_boxed0) -> {
        dafny.DafnySequence<? extends Character> _1524_s = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_1524_s_boxed0));
        return __default.IsSigned(_1523_actions, _1524_s);
      })).apply(actions), _1521_attrs);
      if ((java.math.BigInteger.valueOf((_1522_encryptedAttrs).length())).signum() == 0) {
        return Wrappers_Compile.Result.<Boolean, dafny.DafnySequence<? extends Character>>create_Success(true);
      } else {
        return Wrappers_Compile.Result.<Boolean, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Update Expressions forbidden on signed attributes : "), StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _1522_encryptedAttrs, dafny.DafnySequence.asString(","))));
      }
    } else {
      return Wrappers_Compile.Result.<Boolean, dafny.DafnySequence<? extends Character>>create_Success(true);
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GetEncryptedBeacons(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, DynamoDbEncryptionUtil_Compile.MaybeKeyId keyId)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
    if(true) {
      if ((search).is_None()) {
        output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.DafnyMap.fromElements());
        return output;
      } else {
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out69;
        _out69 = ((search).dtor_value()).GenerateEncryptedBeacons(item, keyId);
        output = _out69;
      }
    }
    return output;
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> AddSignedBeacons(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
    if(true) {
      if ((search).is_None()) {
        output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(item);
        return output;
      } else {
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1525_newAttrs;
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1526_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out70;
        _out70 = ((search).dtor_value()).GenerateSignedBeacons(item);
        _1526_valueOrError0 = _out70;
        if ((_1526_valueOrError0).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          output = (_1526_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()));
          return output;
        }
        _1525_newAttrs = (_1526_valueOrError0).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _1527_badAttrs;
        _1527_badAttrs = ((dafny.Function2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(_1528_newAttrs, _1529_item) -> ((dafny.Function0<dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(() -> {
          java.util.ArrayList<dafny.DafnySequence<? extends Character>> _coll29 = new java.util.ArrayList<>();
          for (dafny.DafnySequence<? extends Character> _compr_30_boxed0 : (_1528_newAttrs).keySet().Elements()) {
            dafny.DafnySequence<? extends Character> _compr_30 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_30_boxed0));
            if (true) {
              dafny.DafnySequence<? extends Character> _1530_k = (dafny.DafnySequence<? extends Character>)_compr_30;
              if (((_1528_newAttrs).<dafny.DafnySequence<? extends Character>>contains(_1530_k)) && (((_1529_item).<dafny.DafnySequence<? extends Character>>contains(_1530_k)) && (!java.util.Objects.equals(((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue)(java.lang.Object)((_1529_item).get(_1530_k))), ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue)(java.lang.Object)((_1528_newAttrs).get(_1530_k))))))) {
                _coll29.add(_1530_k);
              }
            }
          }
          return new dafny.DafnySet<dafny.DafnySequence<? extends Character>>(_coll29);
        })).apply()).apply(_1525_newAttrs, item);
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1531_valueOrError1 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default();
        _1531_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf((_1527_badAttrs).size())).signum() == 0, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Signed beacons have generated values different from supplied values.")));
        if ((_1531_valueOrError1).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          output = (_1531_valueOrError1).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()));
          return output;
        }
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1532_version;
        _1532_version = dafny.DafnyMap.fromElements(new dafny.Tuple2(__default.VersionTag(), DdbVirtualFields_Compile.__default.DS(dafny.DafnySequence.asString(" "))));
        dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _1533_both;
        _1533_both = dafny.DafnySet.<dafny.DafnySequence<? extends Character>>intersection((_1525_newAttrs).keySet(), (item).keySet());
        dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _1534_bad;
        _1534_bad = ((dafny.Function3<dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(_1535_both, _1536_newAttrs, _1537_item) -> ((dafny.Function0<dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(() -> {
          java.util.ArrayList<dafny.DafnySequence<? extends Character>> _coll30 = new java.util.ArrayList<>();
          for (dafny.DafnySequence<? extends Character> _compr_31_boxed0 : (_1535_both).Elements()) {
            dafny.DafnySequence<? extends Character> _compr_31 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_31_boxed0));
            if (true) {
              dafny.DafnySequence<? extends Character> _1538_k = (dafny.DafnySequence<? extends Character>)_compr_31;
              if (((_1535_both).<dafny.DafnySequence<? extends Character>>contains(_1538_k)) && (!java.util.Objects.equals(((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue)(java.lang.Object)((_1536_newAttrs).get(_1538_k))), ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue)(java.lang.Object)((_1537_item).get(_1538_k)))))) {
                _coll30.add(_1538_k);
              }
            }
          }
          return new dafny.DafnySet<dafny.DafnySequence<? extends Character>>(_coll30);
        })).apply()).apply(_1533_both, _1525_newAttrs, item);
        if ((java.math.BigInteger.valueOf((_1534_bad).size())).signum() == 1) {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1539_badSeq;
          _1539_badSeq = Sets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, _1534_bad, DynamoDbEncryptionUtil_Compile.__default::CharLess);
          output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Supplied Beacons do not match calculated beacons : "), StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _1539_badSeq, dafny.DafnySequence.asString(", ")))));
          return output;
        }
        if (((((((search).dtor_value()).curr()).dtor_keySource()).dtor_keyLoc()).is_MultiLoc()) && ((((((search).dtor_value()).curr()).dtor_keySource()).dtor_keyLoc()).dtor_deleteKey())) {
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1540_newItem;
          _1540_newItem = ((dafny.Function2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>)(_1541_item, _1542_search) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>)(() -> {
            java.util.HashMap<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _coll31 = new java.util.HashMap<>();
            for (dafny.DafnySequence<? extends Character> _compr_32_boxed0 : (_1541_item).keySet().Elements()) {
              dafny.DafnySequence<? extends Character> _compr_32 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_32_boxed0));
              if (true) {
                dafny.DafnySequence<? extends Character> _1543_k = (dafny.DafnySequence<? extends Character>)_compr_32;
                if (((_1541_item).<dafny.DafnySequence<? extends Character>>contains(_1543_k)) && (!(_1543_k).equals((((((_1542_search).dtor_value()).curr()).dtor_keySource()).dtor_keyLoc()).dtor_keyName()))) {
                  _coll31.put(_1543_k,((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue)(java.lang.Object)((_1541_item).get(_1543_k))));
                }
              }
            }
            return new dafny.DafnyMap<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>(_coll31);
          })).apply()).apply(item, search);
          output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>merge(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>merge(_1540_newItem, _1525_newAttrs), _1532_version));
          return output;
        } else {
          output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>merge(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>merge(item, _1525_newAttrs), _1532_version));
          return output;
        }
      }
    }
    return output;
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, dafny.DafnySequence<? extends Character>> RemoveBeacons(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item)
  {
    if ((search).is_None()) {
      return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, dafny.DafnySequence<? extends Character>>create_Success(item);
    } else {
      return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, dafny.DafnySequence<? extends Character>>create_Success(((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>)(_1544_item) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>)(() -> {
  java.util.HashMap<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _coll32 = new java.util.HashMap<>();
  for (dafny.DafnySequence<? extends Character> _compr_33_boxed0 : (_1544_item).keySet().Elements()) {
    dafny.DafnySequence<? extends Character> _compr_33 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_33_boxed0));
    if (true) {
      dafny.DafnySequence<? extends Character> _1545_k = (dafny.DafnySequence<? extends Character>)_compr_33;
      if (((_1544_item).<dafny.DafnySequence<? extends Character>>contains(_1545_k)) && (!((DynamoDbEncryptionUtil_Compile.__default.ReservedPrefix()).isPrefixOf(_1545_k)))) {
        _coll32.put(_1545_k,((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue)(java.lang.Object)((_1544_item).get(_1545_k))));
      }
    }
  }
  return new dafny.DafnyMap<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>(_coll32);
})).apply()).apply(item));
    }
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> LsiOptWithAttrs(SearchableEncryptionInfo_Compile.SearchInfo search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> actions, Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>> schema, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> attrs)
  {
    if ((schema).is_None()) {
      return Wrappers_Compile.Result.<dafny.Tuple2<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.Tuple2.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>create(schema, dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> empty(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())));
    } else {
      Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1546_valueOrError0 = DynamoDBIndexSupport_Compile.__default.LsiWithAttrs(search, actions, (schema).dtor_value(), attrs, dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex> empty(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex._typeDescriptor()));
      if ((_1546_valueOrError0).IsFailure(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex._typeDescriptor()), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1546_valueOrError0).<dafny.Tuple2<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>>PropagateFailure(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex._typeDescriptor()), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex._typeDescriptor())), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())));
      } else {
        dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>> _let_tmp_rhs13 = (_1546_valueOrError0).Extract(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex._typeDescriptor()), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex> _1547_newSchema = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>)(java.lang.Object)(((dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs13).dtor__0()));
        dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _1548_newAttrs = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>)(java.lang.Object)(((dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs13).dtor__1()));
        return Wrappers_Compile.Result.<dafny.Tuple2<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.Tuple2.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>create(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>create_Some(_1547_newSchema), _1548_newAttrs));
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GsiOptWithAttrs(SearchableEncryptionInfo_Compile.SearchInfo search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> actions, Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>> schema, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> attrs)
  {
    if ((schema).is_None()) {
      return Wrappers_Compile.Result.<dafny.Tuple2<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.Tuple2.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>create(schema, dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> empty(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())));
    } else {
      Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1549_valueOrError0 = DynamoDBIndexSupport_Compile.__default.GsiWithAttrs(search, actions, (schema).dtor_value(), attrs, dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex> empty(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex._typeDescriptor()));
      if ((_1549_valueOrError0).IsFailure(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex._typeDescriptor()), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1549_valueOrError0).<dafny.Tuple2<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>>PropagateFailure(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex._typeDescriptor()), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex._typeDescriptor())), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())));
      } else {
        dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>> _let_tmp_rhs14 = (_1549_valueOrError0).Extract(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex._typeDescriptor()), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex> _1550_newSchema = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>)(java.lang.Object)(((dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs14).dtor__0()));
        dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _1551_newAttrs = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>)(java.lang.Object)(((dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs14).dtor__1()));
        return Wrappers_Compile.Result.<dafny.Tuple2<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.Tuple2.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>create(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>create_Some(_1550_newSchema), _1551_newAttrs));
      }
    }
  }
  public static Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> CreateTableInputForBeacons(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> actions, Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput req)
  {
    if ((search).is_None()) {
      return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(req);
    } else {
      Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1552_valueOrError0 = DynamoDBIndexSupport_Compile.__default.AddBeaconsToKeySchema((search).dtor_value(), actions, (req).dtor_KeySchema(), (req).dtor_AttributeDefinitions(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> empty(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement._typeDescriptor()), java.math.BigInteger.valueOf(((req).dtor_KeySchema()).length()));
      if ((_1552_valueOrError0).IsFailure(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1552_valueOrError0).<Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput>PropagateFailure(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput._typeDescriptor());
      } else {
        dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>> _let_tmp_rhs15 = (_1552_valueOrError0).Extract(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> _1553_newSchema = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>)(java.lang.Object)(((dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs15).dtor__0()));
        dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _1554_newAttrs = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>)(java.lang.Object)(((dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs15).dtor__1()));
        Wrappers_Compile.Result<dafny.Tuple2<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1555_valueOrError1 = __default.LsiOptWithAttrs((search).dtor_value(), actions, (req).dtor_LocalSecondaryIndexes(), _1554_newAttrs);
        if ((_1555_valueOrError1).IsFailure(dafny.Tuple2.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex._typeDescriptor())), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_1555_valueOrError1).<Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput>PropagateFailure(dafny.Tuple2.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex._typeDescriptor())), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput._typeDescriptor());
        } else {
          dafny.Tuple2<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>> _let_tmp_rhs16 = (_1555_valueOrError1).Extract(dafny.Tuple2.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex._typeDescriptor())), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>> _1556_newLsi = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>)(java.lang.Object)(((dafny.Tuple2<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs16).dtor__0()));
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _1557_newAttrs = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>)(java.lang.Object)(((dafny.Tuple2<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs16).dtor__1()));
          Wrappers_Compile.Result<dafny.Tuple2<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1558_valueOrError2 = __default.GsiOptWithAttrs((search).dtor_value(), actions, (req).dtor_GlobalSecondaryIndexes(), _1557_newAttrs);
          if ((_1558_valueOrError2).IsFailure(dafny.Tuple2.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex._typeDescriptor())), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
            return (_1558_valueOrError2).<Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput>PropagateFailure(dafny.Tuple2.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex._typeDescriptor())), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput._typeDescriptor());
          } else {
            dafny.Tuple2<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>> _let_tmp_rhs17 = (_1558_valueOrError2).Extract(dafny.Tuple2.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex._typeDescriptor())), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
            Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>> _1559_newGsi = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>)(java.lang.Object)(((dafny.Tuple2<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs17).dtor__0()));
            dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _1560_newAttrs = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>)(java.lang.Object)(((dafny.Tuple2<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs17).dtor__1()));
            return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(((Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput, Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput>Let(req, boxed102 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput _pat_let51_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput)(java.lang.Object)(boxed102));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput, Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput>Let(_pat_let51_0, boxed103 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput _1561_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput)(java.lang.Object)(boxed103));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>, Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput>Let(_1559_newGsi, boxed104 -> {
      Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>> _pat_let52_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>)(java.lang.Object)(boxed104));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>, Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput>Let(_pat_let52_0, boxed105 -> {
        Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>> _1562_dt__update_hGlobalSecondaryIndexes_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>>)(java.lang.Object)(boxed105));
        return ((Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>, Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput>Let(_1556_newLsi, boxed106 -> {
          Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>> _pat_let53_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>)(java.lang.Object)(boxed106));
          return ((Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>, Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput>Let(_pat_let53_0, boxed107 -> {
            Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>> _1563_dt__update_hLocalSecondaryIndexes_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>>)(java.lang.Object)(boxed107));
            return ((Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>, Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput>Let(_1560_newAttrs, boxed108 -> {
              dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _pat_let54_0 = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>)(java.lang.Object)(boxed108));
              return ((Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>, Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput>Let(_pat_let54_0, boxed109 -> {
                dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _1564_dt__update_hAttributeDefinitions_h0 = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>)(java.lang.Object)(boxed109));
                return ((Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput>Let(_1553_newSchema, boxed110 -> {
                  dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> _pat_let55_0 = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>)(java.lang.Object)(boxed110));
                  return ((Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput>Let(_pat_let55_0, boxed111 -> {
                    dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> _1565_dt__update_hKeySchema_h0 = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>)(java.lang.Object)(boxed111));
                    return Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput.create(_1564_dt__update_hAttributeDefinitions_h0, (_1561_dt__update__tmp_h0).dtor_TableName(), _1565_dt__update_hKeySchema_h0, _1563_dt__update_hLocalSecondaryIndexes_h0, _1562_dt__update_hGlobalSecondaryIndexes_h0, (_1561_dt__update__tmp_h0).dtor_BillingMode(), (_1561_dt__update__tmp_h0).dtor_ProvisionedThroughput(), (_1561_dt__update__tmp_h0).dtor_StreamSpecification(), (_1561_dt__update__tmp_h0).dtor_SSESpecification(), (_1561_dt__update__tmp_h0).dtor_Tags(), (_1561_dt__update__tmp_h0).dtor_TableClass());
                  }
                  )));
                }
                )));
              }
              )));
            }
            )));
          }
          )));
        }
        )));
      }
      )));
    }
    )));
  }
  )));
}
))));
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> UpdateTableInputForBeacons(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> actions, Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput req)
  {
    if (((search).is_None()) || (((req).dtor_GlobalSecondaryIndexUpdates()).is_None())) {
      return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(req);
    } else {
      Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1566_valueOrError0 = DynamoDBIndexSupport_Compile.__default.TransformIndexUpdates((search).dtor_value(), actions, ((req).dtor_GlobalSecondaryIndexUpdates()).dtor_value(), ((req).dtor_AttributeDefinitions()).UnwrapOr(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor()), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> empty(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate> empty(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate._typeDescriptor()));
      if ((_1566_valueOrError0).IsFailure(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate._typeDescriptor()), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1566_valueOrError0).<Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput>PropagateFailure(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate._typeDescriptor()), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput._typeDescriptor());
      } else {
        dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>> _let_tmp_rhs18 = (_1566_valueOrError0).Extract(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate._typeDescriptor()), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate> _1567_indexes = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>)(java.lang.Object)(((dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs18).dtor__0()));
        dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _1568_attrs = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>)(java.lang.Object)(((dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs18).dtor__1()));
        Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>> _1569_newAttrs = (((java.math.BigInteger.valueOf((_1568_attrs).length())).signum() == 0) ? (Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>create_None()) : (Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>create_Some(_1568_attrs)));
        return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(((Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput, Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput>Let(req, boxed112 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput _pat_let56_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput)(java.lang.Object)(boxed112));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput, Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput>Let(_pat_let56_0, boxed113 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput _1570_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput)(java.lang.Object)(boxed113));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput>Let(_1569_newAttrs, boxed114 -> {
      Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>> _pat_let57_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)(java.lang.Object)(boxed114));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput>Let(_pat_let57_0, boxed115 -> {
        Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>> _1571_dt__update_hAttributeDefinitions_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)(java.lang.Object)(boxed115));
        return ((Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>>, Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput>Let(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>>create_Some(_1567_indexes), boxed116 -> {
          Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>> _pat_let58_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>>)(java.lang.Object)(boxed116));
          return ((Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>>, Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput>Let(_pat_let58_0, boxed117 -> {
            Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>> _1572_dt__update_hGlobalSecondaryIndexUpdates_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>>)(java.lang.Object)(boxed117));
            return Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput.create(_1571_dt__update_hAttributeDefinitions_h0, (_1570_dt__update__tmp_h0).dtor_TableName(), (_1570_dt__update__tmp_h0).dtor_BillingMode(), (_1570_dt__update__tmp_h0).dtor_ProvisionedThroughput(), _1572_dt__update_hGlobalSecondaryIndexUpdates_h0, (_1570_dt__update__tmp_h0).dtor_StreamSpecification(), (_1570_dt__update__tmp_h0).dtor_SSESpecification(), (_1570_dt__update__tmp_h0).dtor_ReplicaUpdates(), (_1570_dt__update__tmp_h0).dtor_TableClass());
          }
          )));
        }
        )));
      }
      )));
    }
    )));
  }
  )));
}
))));
      }
    }
  }
  public static Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> DescribeTableOutputForBeacons(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> search, Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput req)
  {
    if (((search).is_None()) || (((req).dtor_Table()).is_None())) {
      return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(req);
    } else {
      Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1573_valueOrError0 = DynamoDBIndexSupport_Compile.__default.TransformLocalIndexDescription((((req).dtor_Table()).dtor_value()).dtor_LocalSecondaryIndexes());
      if ((_1573_valueOrError0).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1573_valueOrError0).<Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput._typeDescriptor());
      } else {
        Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>> _1574_locals = (_1573_valueOrError0).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1575_valueOrError1 = DynamoDBIndexSupport_Compile.__default.TransformGlobalIndexDescription((((req).dtor_Table()).dtor_value()).dtor_GlobalSecondaryIndexes());
        if ((_1575_valueOrError1).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_1575_valueOrError1).<Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput._typeDescriptor());
        } else {
          Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>> _1576_globals = (_1575_valueOrError1).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput.create(Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.TableDescription>create_Some(((Dafny.Com.Amazonaws.Dynamodb.Types.TableDescription)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.TableDescription, Dafny.Com.Amazonaws.Dynamodb.Types.TableDescription>Let(((req).dtor_Table()).dtor_value(), boxed118 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.TableDescription _pat_let59_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.TableDescription)(java.lang.Object)(boxed118));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.TableDescription)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.TableDescription, Dafny.Com.Amazonaws.Dynamodb.Types.TableDescription>Let(_pat_let59_0, boxed119 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.TableDescription _1577_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.TableDescription)(java.lang.Object)(boxed119));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.TableDescription)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>>, Dafny.Com.Amazonaws.Dynamodb.Types.TableDescription>Let(_1576_globals, boxed120 -> {
      Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>> _pat_let60_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>>)(java.lang.Object)(boxed120));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.TableDescription)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>>, Dafny.Com.Amazonaws.Dynamodb.Types.TableDescription>Let(_pat_let60_0, boxed121 -> {
        Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>> _1578_dt__update_hGlobalSecondaryIndexes_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>>)(java.lang.Object)(boxed121));
        return ((Dafny.Com.Amazonaws.Dynamodb.Types.TableDescription)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>>, Dafny.Com.Amazonaws.Dynamodb.Types.TableDescription>Let(_1574_locals, boxed122 -> {
          Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>> _pat_let61_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>>)(java.lang.Object)(boxed122));
          return ((Dafny.Com.Amazonaws.Dynamodb.Types.TableDescription)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>>, Dafny.Com.Amazonaws.Dynamodb.Types.TableDescription>Let(_pat_let61_0, boxed123 -> {
            Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>> _1579_dt__update_hLocalSecondaryIndexes_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>>)(java.lang.Object)(boxed123));
            return Dafny.Com.Amazonaws.Dynamodb.Types.TableDescription.create((_1577_dt__update__tmp_h0).dtor_AttributeDefinitions(), (_1577_dt__update__tmp_h0).dtor_TableName(), (_1577_dt__update__tmp_h0).dtor_KeySchema(), (_1577_dt__update__tmp_h0).dtor_TableStatus(), (_1577_dt__update__tmp_h0).dtor_CreationDateTime(), (_1577_dt__update__tmp_h0).dtor_ProvisionedThroughput(), (_1577_dt__update__tmp_h0).dtor_TableSizeBytes(), (_1577_dt__update__tmp_h0).dtor_ItemCount(), (_1577_dt__update__tmp_h0).dtor_TableArn(), (_1577_dt__update__tmp_h0).dtor_TableId(), (_1577_dt__update__tmp_h0).dtor_BillingModeSummary(), _1579_dt__update_hLocalSecondaryIndexes_h0, _1578_dt__update_hGlobalSecondaryIndexes_h0, (_1577_dt__update__tmp_h0).dtor_StreamSpecification(), (_1577_dt__update__tmp_h0).dtor_LatestStreamLabel(), (_1577_dt__update__tmp_h0).dtor_LatestStreamArn(), (_1577_dt__update__tmp_h0).dtor_GlobalTableVersion(), (_1577_dt__update__tmp_h0).dtor_Replicas(), (_1577_dt__update__tmp_h0).dtor_RestoreSummary(), (_1577_dt__update__tmp_h0).dtor_SSEDescription(), (_1577_dt__update__tmp_h0).dtor_ArchivalSummary(), (_1577_dt__update__tmp_h0).dtor_TableClassSummary());
          }
          )));
        }
        )));
      }
      )));
    }
    )));
  }
  )));
}
))))));
        }
      }
    }
  }
  public static Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> QueryInputForBeacons(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> search, Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput req)
  {
    Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = (Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)null;
    if(true) {
      if ((search).is_None()) {
        output = Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(req);
        return output;
      } else {
        DynamoDbEncryptionUtil_Compile.MaybeKeyId _1580_keyId;
        Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyId, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1581_valueOrError0 = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyId, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(DynamoDbEncryptionUtil_Compile.MaybeKeyId.Default());
        _1581_valueOrError0 = DynamoDBFilterExpr_Compile.__default.GetBeaconKeyId(((search).dtor_value()).curr(), (req).dtor_KeyConditionExpression(), (req).dtor_FilterExpression(), (req).dtor_ExpressionAttributeValues(), (req).dtor_ExpressionAttributeNames());
        if ((_1581_valueOrError0).IsFailure(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          output = (_1581_valueOrError0).<Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput>PropagateFailure(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput._typeDescriptor());
          return output;
        }
        _1580_keyId = (_1581_valueOrError0).Extract(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        DynamoDBFilterExpr_Compile.ExprContext _1582_oldContext;
        _1582_oldContext = DynamoDBFilterExpr_Compile.ExprContext.create((req).dtor_KeyConditionExpression(), (req).dtor_FilterExpression(), (req).dtor_ExpressionAttributeValues(), (req).dtor_ExpressionAttributeNames());
        DynamoDBFilterExpr_Compile.ExprContext _1583_newContext;
        Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1584_valueOrError1 = Wrappers_Compile.Result.<DynamoDBFilterExpr_Compile.ExprContext, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(DynamoDBFilterExpr_Compile.ExprContext.Default());
        Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out71;
        _out71 = DynamoDBFilterExpr_Compile.__default.Beaconize(((search).dtor_value()).curr(), _1582_oldContext, _1580_keyId, false);
        _1584_valueOrError1 = _out71;
        if ((_1584_valueOrError1).IsFailure(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          output = (_1584_valueOrError1).<Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput>PropagateFailure(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput._typeDescriptor());
          return output;
        }
        _1583_newContext = (_1584_valueOrError1).Extract(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        DynamoDBFilterExpr_Compile.ExprContext _pat_let_tv6 = _1583_newContext;
        DynamoDBFilterExpr_Compile.ExprContext _pat_let_tv7 = _1583_newContext;
        DynamoDBFilterExpr_Compile.ExprContext _pat_let_tv8 = _1583_newContext;
        DynamoDBFilterExpr_Compile.ExprContext _pat_let_tv9 = _1583_newContext;
        output = Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(((Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput, Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput>Let(req, boxed124 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput _pat_let62_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput)(java.lang.Object)(boxed124));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput, Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput>Let(_pat_let62_0, boxed125 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput _1585_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput)(java.lang.Object)(boxed125));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput>Let((_pat_let_tv6).dtor_values(), boxed126 -> {
      Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> _pat_let63_0 = ((Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>)(java.lang.Object)(boxed126));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput>Let(_pat_let63_0, boxed127 -> {
        Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> _1586_dt__update_hExpressionAttributeValues_h0 = ((Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>)(java.lang.Object)(boxed127));
        return ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>, Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput>Let((_pat_let_tv7).dtor_names(), boxed128 -> {
          Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _pat_let64_0 = ((Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>)(java.lang.Object)(boxed128));
          return ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>, Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput>Let(_pat_let64_0, boxed129 -> {
            Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _1587_dt__update_hExpressionAttributeNames_h0 = ((Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>)(java.lang.Object)(boxed129));
            return ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput>Let((_pat_let_tv8).dtor_filterExpr(), boxed130 -> {
              Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _pat_let65_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>)(java.lang.Object)(boxed130));
              return ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput>Let(_pat_let65_0, boxed131 -> {
                Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _1588_dt__update_hFilterExpression_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>)(java.lang.Object)(boxed131));
                return ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput>Let((_pat_let_tv9).dtor_keyExpr(), boxed132 -> {
                  Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _pat_let66_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>)(java.lang.Object)(boxed132));
                  return ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput>Let(_pat_let66_0, boxed133 -> {
                    Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _1589_dt__update_hKeyConditionExpression_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>)(java.lang.Object)(boxed133));
                    return Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput.create((_1585_dt__update__tmp_h0).dtor_TableName(), (_1585_dt__update__tmp_h0).dtor_IndexName(), (_1585_dt__update__tmp_h0).dtor_Select(), (_1585_dt__update__tmp_h0).dtor_AttributesToGet(), (_1585_dt__update__tmp_h0).dtor_Limit(), (_1585_dt__update__tmp_h0).dtor_ConsistentRead(), (_1585_dt__update__tmp_h0).dtor_KeyConditions(), (_1585_dt__update__tmp_h0).dtor_QueryFilter(), (_1585_dt__update__tmp_h0).dtor_ConditionalOperator(), (_1585_dt__update__tmp_h0).dtor_ScanIndexForward(), (_1585_dt__update__tmp_h0).dtor_ExclusiveStartKey(), (_1585_dt__update__tmp_h0).dtor_ReturnConsumedCapacity(), (_1585_dt__update__tmp_h0).dtor_ProjectionExpression(), _1588_dt__update_hFilterExpression_h0, _1589_dt__update_hKeyConditionExpression_h0, _1587_dt__update_hExpressionAttributeNames_h0, _1586_dt__update_hExpressionAttributeValues_h0);
                  }
                  )));
                }
                )));
              }
              )));
            }
            )));
          }
          )));
        }
        )));
      }
      )));
    }
    )));
  }
  )));
}
))));
        return output;
      }
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> QueryOutputForBeacons(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> search, Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput req, Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput resp)
  {
    Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput.Default());
    if(true) {
      if (((search).is_None()) || (((resp).dtor_Items()).is_None())) {
        output = Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(resp);
        return output;
      } else {
        dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> _1590_newItems;
        Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1591_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> empty(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())));
        Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out72;
        _out72 = DynamoDBFilterExpr_Compile.__default.FilterResults(((search).dtor_value()).curr(), ((resp).dtor_Items()).dtor_value(), (req).dtor_KeyConditionExpression(), (req).dtor_FilterExpression(), (req).dtor_ExpressionAttributeNames(), (req).dtor_ExpressionAttributeValues());
        _1591_valueOrError0 = _out72;
        if ((_1591_valueOrError0).IsFailure(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          output = (_1591_valueOrError0).<Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput>PropagateFailure(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput._typeDescriptor());
          return output;
        }
        _1590_newItems = (_1591_valueOrError0).Extract(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1592_valueOrError1 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default();
        _1592_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf((_1590_newItems).length())).compareTo(StandardLibrary_mUInt_Compile.__default.INT32__MAX__LIMIT()) < 0, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("This is impossible.")));
        if ((_1592_valueOrError1).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          output = (_1592_valueOrError1).<Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput._typeDescriptor());
          return output;
        }
        Wrappers_Compile.Option<java.lang.Integer> _1593_count;
        _1593_count = ((((resp).dtor_Count()).is_Some()) ? (Wrappers_Compile.Option.<java.lang.Integer>create_Some((_1590_newItems).cardinalityInt())) : (Wrappers_Compile.Option.<java.lang.Integer>create_None()));
        Wrappers_Compile.Option<java.lang.Integer> _pat_let_tv10 = _1593_count;
        dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> _pat_let_tv11 = _1590_newItems;
        output = Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(((Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput, Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput>Let(resp, boxed134 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput _pat_let67_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput)(java.lang.Object)(boxed134));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput, Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput>Let(_pat_let67_0, boxed135 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput _1594_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput)(java.lang.Object)(boxed135));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<java.lang.Integer>, Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput>Let(_pat_let_tv10, boxed136 -> {
      Wrappers_Compile.Option<java.lang.Integer> _pat_let68_0 = ((Wrappers_Compile.Option<java.lang.Integer>)(java.lang.Object)(boxed136));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<java.lang.Integer>, Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput>Let(_pat_let68_0, boxed137 -> {
        Wrappers_Compile.Option<java.lang.Integer> _1595_dt__update_hCount_h0 = ((Wrappers_Compile.Option<java.lang.Integer>)(java.lang.Object)(boxed137));
        return ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>, Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput>Let(Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>create_Some(_pat_let_tv11), boxed138 -> {
          Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>> _pat_let69_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>)(java.lang.Object)(boxed138));
          return ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>, Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput>Let(_pat_let69_0, boxed139 -> {
            Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>> _1596_dt__update_hItems_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>)(java.lang.Object)(boxed139));
            return Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput.create(_1596_dt__update_hItems_h0, _1595_dt__update_hCount_h0, (_1594_dt__update__tmp_h0).dtor_ScannedCount(), (_1594_dt__update__tmp_h0).dtor_LastEvaluatedKey(), (_1594_dt__update__tmp_h0).dtor_ConsumedCapacity());
          }
          )));
        }
        )));
      }
      )));
    }
    )));
  }
  )));
}
))));
        return output;
      }
    }
    return output;
  }
  public static Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyId, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GetBeaconKeyId(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> search, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> keyExpr, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> filterExpr, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> values, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names)
  {
    if ((search).is_None()) {
      return Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyId, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    } else {
      return DynamoDBFilterExpr_Compile.__default.GetBeaconKeyId(((search).dtor_value()).curr(), keyExpr, filterExpr, values, names);
    }
  }
  public static Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> ScanInputForBeacons(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> search, Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput req)
  {
    Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = (Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)null;
    if(true) {
      if ((search).is_None()) {
        output = Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(req);
        return output;
      } else {
        DynamoDbEncryptionUtil_Compile.MaybeKeyId _1597_keyId;
        Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyId, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1598_valueOrError0 = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyId, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(DynamoDbEncryptionUtil_Compile.MaybeKeyId.Default());
        _1598_valueOrError0 = DynamoDBFilterExpr_Compile.__default.GetBeaconKeyId(((search).dtor_value()).curr(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(), (req).dtor_FilterExpression(), (req).dtor_ExpressionAttributeValues(), (req).dtor_ExpressionAttributeNames());
        if ((_1598_valueOrError0).IsFailure(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          output = (_1598_valueOrError0).<Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput>PropagateFailure(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput._typeDescriptor());
          return output;
        }
        _1597_keyId = (_1598_valueOrError0).Extract(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        DynamoDBFilterExpr_Compile.ExprContext _1599_context;
        _1599_context = DynamoDBFilterExpr_Compile.ExprContext.create(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(), (req).dtor_FilterExpression(), (req).dtor_ExpressionAttributeValues(), (req).dtor_ExpressionAttributeNames());
        DynamoDBFilterExpr_Compile.ExprContext _1600_newContext;
        Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1601_valueOrError1 = Wrappers_Compile.Result.<DynamoDBFilterExpr_Compile.ExprContext, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(DynamoDBFilterExpr_Compile.ExprContext.Default());
        Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out73;
        _out73 = DynamoDBFilterExpr_Compile.__default.Beaconize(((search).dtor_value()).curr(), _1599_context, _1597_keyId, false);
        _1601_valueOrError1 = _out73;
        if ((_1601_valueOrError1).IsFailure(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          output = (_1601_valueOrError1).<Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput>PropagateFailure(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput._typeDescriptor());
          return output;
        }
        _1600_newContext = (_1601_valueOrError1).Extract(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        DynamoDBFilterExpr_Compile.ExprContext _pat_let_tv12 = _1600_newContext;
        DynamoDBFilterExpr_Compile.ExprContext _pat_let_tv13 = _1600_newContext;
        DynamoDBFilterExpr_Compile.ExprContext _pat_let_tv14 = _1600_newContext;
        output = Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(((Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput, Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput>Let(req, boxed140 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput _pat_let70_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput)(java.lang.Object)(boxed140));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput, Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput>Let(_pat_let70_0, boxed141 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput _1602_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput)(java.lang.Object)(boxed141));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput>Let((_pat_let_tv12).dtor_values(), boxed142 -> {
      Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> _pat_let71_0 = ((Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>)(java.lang.Object)(boxed142));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput>Let(_pat_let71_0, boxed143 -> {
        Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> _1603_dt__update_hExpressionAttributeValues_h0 = ((Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>)(java.lang.Object)(boxed143));
        return ((Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>, Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput>Let((_pat_let_tv13).dtor_names(), boxed144 -> {
          Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _pat_let72_0 = ((Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>)(java.lang.Object)(boxed144));
          return ((Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>, Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput>Let(_pat_let72_0, boxed145 -> {
            Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _1604_dt__update_hExpressionAttributeNames_h0 = ((Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>)(java.lang.Object)(boxed145));
            return ((Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput>Let((_pat_let_tv14).dtor_filterExpr(), boxed146 -> {
              Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _pat_let73_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>)(java.lang.Object)(boxed146));
              return ((Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput>Let(_pat_let73_0, boxed147 -> {
                Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _1605_dt__update_hFilterExpression_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>)(java.lang.Object)(boxed147));
                return Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput.create((_1602_dt__update__tmp_h0).dtor_TableName(), (_1602_dt__update__tmp_h0).dtor_IndexName(), (_1602_dt__update__tmp_h0).dtor_AttributesToGet(), (_1602_dt__update__tmp_h0).dtor_Limit(), (_1602_dt__update__tmp_h0).dtor_Select(), (_1602_dt__update__tmp_h0).dtor_ScanFilter(), (_1602_dt__update__tmp_h0).dtor_ConditionalOperator(), (_1602_dt__update__tmp_h0).dtor_ExclusiveStartKey(), (_1602_dt__update__tmp_h0).dtor_ReturnConsumedCapacity(), (_1602_dt__update__tmp_h0).dtor_TotalSegments(), (_1602_dt__update__tmp_h0).dtor_Segment(), (_1602_dt__update__tmp_h0).dtor_ProjectionExpression(), _1605_dt__update_hFilterExpression_h0, _1604_dt__update_hExpressionAttributeNames_h0, _1603_dt__update_hExpressionAttributeValues_h0, (_1602_dt__update__tmp_h0).dtor_ConsistentRead());
              }
              )));
            }
            )));
          }
          )));
        }
        )));
      }
      )));
    }
    )));
  }
  )));
}
))));
        return output;
      }
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> ScanOutputForBeacons(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> search, Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput req, Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput resp)
  {
    Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> ret = Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput.Default());
    if(true) {
      if ((search).is_None()) {
        ret = Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(resp);
        return ret;
      } else {
        dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> _1606_newItems;
        Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1607_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> empty(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())));
        Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out74;
        _out74 = DynamoDBFilterExpr_Compile.__default.FilterResults(((search).dtor_value()).curr(), ((resp).dtor_Items()).dtor_value(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(), (req).dtor_FilterExpression(), (req).dtor_ExpressionAttributeNames(), (req).dtor_ExpressionAttributeValues());
        _1607_valueOrError0 = _out74;
        if ((_1607_valueOrError0).IsFailure(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          ret = (_1607_valueOrError0).<Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput>PropagateFailure(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput._typeDescriptor());
          return ret;
        }
        _1606_newItems = (_1607_valueOrError0).Extract(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1608_valueOrError1 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default();
        _1608_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf((_1606_newItems).length())).compareTo(StandardLibrary_mUInt_Compile.__default.INT32__MAX__LIMIT()) < 0, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("This is impossible.")));
        if ((_1608_valueOrError1).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          ret = (_1608_valueOrError1).<Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput._typeDescriptor());
          return ret;
        }
        Wrappers_Compile.Option<java.lang.Integer> _1609_count;
        _1609_count = ((((resp).dtor_Count()).is_Some()) ? (Wrappers_Compile.Option.<java.lang.Integer>create_Some((_1606_newItems).cardinalityInt())) : (Wrappers_Compile.Option.<java.lang.Integer>create_None()));
        Wrappers_Compile.Option<java.lang.Integer> _pat_let_tv15 = _1609_count;
        dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> _pat_let_tv16 = _1606_newItems;
        ret = Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(((Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput, Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput>Let(resp, boxed148 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput _pat_let74_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput)(java.lang.Object)(boxed148));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput, Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput>Let(_pat_let74_0, boxed149 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput _1610_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput)(java.lang.Object)(boxed149));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<java.lang.Integer>, Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput>Let(_pat_let_tv15, boxed150 -> {
      Wrappers_Compile.Option<java.lang.Integer> _pat_let75_0 = ((Wrappers_Compile.Option<java.lang.Integer>)(java.lang.Object)(boxed150));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<java.lang.Integer>, Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput>Let(_pat_let75_0, boxed151 -> {
        Wrappers_Compile.Option<java.lang.Integer> _1611_dt__update_hCount_h0 = ((Wrappers_Compile.Option<java.lang.Integer>)(java.lang.Object)(boxed151));
        return ((Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>, Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput>Let(Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>create_Some(_pat_let_tv16), boxed152 -> {
          Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>> _pat_let76_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>)(java.lang.Object)(boxed152));
          return ((Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>, Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput>Let(_pat_let76_0, boxed153 -> {
            Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>> _1612_dt__update_hItems_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>)(java.lang.Object)(boxed153));
            return Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput.create(_1612_dt__update_hItems_h0, _1611_dt__update_hCount_h0, (_1610_dt__update__tmp_h0).dtor_ScannedCount(), (_1610_dt__update__tmp_h0).dtor_LastEvaluatedKey(), (_1610_dt__update__tmp_h0).dtor_ConsumedCapacity());
          }
          )));
        }
        )));
      }
      )));
    }
    )));
  }
  )));
}
))));
        return ret;
      }
    }
    return ret;
  }
  public static dafny.DafnySequence<? extends Character> VersionTag()
  {
    return dafny.DafnySequence.<Character>concatenate(DynamoDbEncryptionUtil_Compile.__default.VersionPrefix(), dafny.DafnySequence.asString("1"));
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDBSupport_Compile._default";
  }
}
