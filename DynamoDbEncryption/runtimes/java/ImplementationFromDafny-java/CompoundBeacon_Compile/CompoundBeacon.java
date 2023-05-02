// Class CompoundBeacon
// Dafny class CompoundBeacon compiled into Java
package CompoundBeacon_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class CompoundBeacon {
  public BaseBeacon_Compile.BeaconBase _base;
  public char _split;
  public dafny.DafnySequence<? extends BeaconPart> _parts;
  public java.math.BigInteger _numNonSensitive;
  public dafny.DafnySequence<? extends Constructor> _construct;
  public CompoundBeacon (BaseBeacon_Compile.BeaconBase base, char split, dafny.DafnySequence<? extends BeaconPart> parts, java.math.BigInteger numNonSensitive, dafny.DafnySequence<? extends Constructor> construct) {
    this._base = base;
    this._split = split;
    this._parts = parts;
    this._numNonSensitive = numNonSensitive;
    this._construct = construct;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    CompoundBeacon o = (CompoundBeacon)other;
    return true && java.util.Objects.equals(this._base, o._base) && this._split == o._split && java.util.Objects.equals(this._parts, o._parts) && java.util.Objects.equals(this._numNonSensitive, o._numNonSensitive) && java.util.Objects.equals(this._construct, o._construct);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._base);
    hash = ((hash << 5) + hash) + Character.hashCode(this._split);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._parts);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._numNonSensitive);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._construct);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("CompoundBeacon_Compile.CompoundBeacon.CompoundBeacon");
    s.append("(");
    s.append(dafny.Helpers.toString(this._base));
    s.append(", ");
    s.append(this._split);
    s.append(", ");
    s.append(dafny.Helpers.toString(this._parts));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._numNonSensitive));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._construct));
    s.append(")");
    return s.toString();
  }

  private static final CompoundBeacon theDefault = CompoundBeacon_Compile.CompoundBeacon.create(BaseBeacon_Compile.BeaconBase.Default(), 'D', dafny.DafnySequence.<BeaconPart> empty(BeaconPart._typeDescriptor()), java.math.BigInteger.ZERO, dafny.DafnySequence.<Constructor> empty(Constructor._typeDescriptor()));
  public static CompoundBeacon Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<CompoundBeacon> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(CompoundBeacon.class, () -> Default());
  public static dafny.TypeDescriptor<CompoundBeacon> _typeDescriptor() {
    return (dafny.TypeDescriptor<CompoundBeacon>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static CompoundBeacon create(BaseBeacon_Compile.BeaconBase base, char split, dafny.DafnySequence<? extends BeaconPart> parts, java.math.BigInteger numNonSensitive, dafny.DafnySequence<? extends Constructor> construct) {
    return new CompoundBeacon(base, split, parts, numNonSensitive, construct);
  }
  public static CompoundBeacon create_CompoundBeacon(BaseBeacon_Compile.BeaconBase base, char split, dafny.DafnySequence<? extends BeaconPart> parts, java.math.BigInteger numNonSensitive, dafny.DafnySequence<? extends Constructor> construct) {
    return create(base, split, parts, numNonSensitive, construct);
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
  public java.math.BigInteger dtor_numNonSensitive() {
    return this._numNonSensitive;
  }
  public dafny.DafnySequence<? extends Constructor> dtor_construct() {
    return this._construct;
  }
  public boolean isEncrypted() {
    return ((this).dtor_numNonSensitive()).compareTo(java.math.BigInteger.valueOf(((this).dtor_parts()).length())) < 0;
  }
  public Wrappers_Compile.Result<BeaconPart, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> getPartFromPrefix(dafny.DafnySequence<? extends Character> value) {
    return (this).partFromPrefix((this).dtor_parts(), value);
  }
  public Wrappers_Compile.Result<BeaconPart, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> partFromPrefix(dafny.DafnySequence<? extends BeaconPart> p, dafny.DafnySequence<? extends Character> value)
  {
    CompoundBeacon _this = this;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((p).length())).signum() == 0) {
        return Wrappers_Compile.Result.<BeaconPart, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Value "), value), dafny.DafnySequence.asString(" for beacon ")), ((_this).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" does not match the prefix of any configured part."))));
      } else if (((((BeaconPart)(java.lang.Object)((p).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_prefix()).isPrefixOf(value)) {
        return Wrappers_Compile.Result.<BeaconPart, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(((BeaconPart)(java.lang.Object)((p).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))));
      } else {
        CompoundBeacon _in101 = _this;
        dafny.DafnySequence<? extends BeaconPart> _in102 = (p).drop(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends Character> _in103 = value;
        _this = _in101;
        p = _in102;
        value = _in103;
        continue TAIL_CALL_START;
      }
    }
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> SkipSignedPieces(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> pieces) {
    CompoundBeacon _this = this;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((pieces).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(pieces);
      } else {
        Wrappers_Compile.Result<BeaconPart, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _898_valueOrError0 = (_this).partFromPrefix((_this).dtor_parts(), ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((pieces).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))));
        if ((_898_valueOrError0).IsFailure(BeaconPart._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_898_valueOrError0).<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>PropagateFailure(BeaconPart._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
        } else {
          BeaconPart _899_p = (_898_valueOrError0).Extract(BeaconPart._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          if ((_899_p).is_Sensitive()) {
            return Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(pieces);
          } else {
            CompoundBeacon _in104 = _this;
            dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in105 = (pieces).drop(java.math.BigInteger.ONE);
            _this = _in104;
            pieces = _in105;
            continue TAIL_CALL_START;
          }
        }
      }
    }
  }
  public Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> IsLessThanComparable(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> pieces) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _900_valueOrError0 = (this).SkipSignedPieces(pieces);
    if ((_900_valueOrError0).IsFailure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_900_valueOrError0).<Boolean>PropagateFailure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
    } else {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _901_rest = (_900_valueOrError0).Extract(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      if ((java.math.BigInteger.valueOf((_901_rest).length())).signum() == 0) {
        return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
      } else if (!java.util.Objects.equals(java.math.BigInteger.valueOf((_901_rest).length()), java.math.BigInteger.ONE)) {
        return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(false);
      } else {
        Wrappers_Compile.Result<BeaconPart, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _902_valueOrError1 = (this).partFromPrefix((this).dtor_parts(), ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_901_rest).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))));
        if ((_902_valueOrError1).IsFailure(BeaconPart._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_902_valueOrError1).<Boolean>PropagateFailure(BeaconPart._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
        } else {
          BeaconPart _903_p = (_902_valueOrError1).Extract(BeaconPart._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(((_903_p).dtor_prefix()).equals(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_901_rest).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
        }
      }
    }
  }
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> GetFields(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields) {
    return Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>Flatten(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Seq_Compile.__default.<BeaconPart, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>Map(BeaconPart._typeDescriptor(), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>, java.util.function.Function<BeaconPart, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>>)(_904_virtualFields) -> ((java.util.function.Function<BeaconPart, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>)(_905_p_boxed0) -> {
      BeaconPart _905_p = ((BeaconPart)(java.lang.Object)(_905_p_boxed0));
      return (_905_p).GetFields(_904_virtualFields);
    })).apply(virtualFields), (this).dtor_parts()));
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> FindAndCalcPart(dafny.DafnySequence<? extends Character> value, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys)
  {
    Wrappers_Compile.Result<BeaconPart, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _906_valueOrError0 = (this).partFromPrefix((this).dtor_parts(), value);
    if ((_906_valueOrError0).IsFailure(BeaconPart._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_906_valueOrError0).<dafny.DafnySequence<? extends Character>>PropagateFailure(BeaconPart._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    } else {
      BeaconPart _907_part = (_906_valueOrError0).Extract(BeaconPart._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      return (this).PartValueCalc((value).drop(java.math.BigInteger.valueOf(((_907_part).dtor_prefix()).length())), keys, _907_part);
    }
  }
  public Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> justPrefix(dafny.DafnySequence<? extends Character> value) {
    Wrappers_Compile.Result<BeaconPart, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _908_valueOrError0 = (this).partFromPrefix((this).dtor_parts(), value);
    if ((_908_valueOrError0).IsFailure(BeaconPart._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_908_valueOrError0).<Boolean>PropagateFailure(BeaconPart._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
    } else {
      BeaconPart _909_part = (_908_valueOrError0).Extract(BeaconPart._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success((value).equals((_909_part).dtor_prefix()));
    }
  }
  public Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GetBeaconValue(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue value, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys, boolean forEquality)
  {
    if (!((value).is_S())) {
      return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("CompoundBeacon "), ((this).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" can only be queried as a string, not as ")), DynamoDbEncryptionUtil_Compile.__default.AttrTypeToStr(value))));
    } else {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _910_parts = StandardLibrary_Compile.__default.<Character>Split(dafny.TypeDescriptor.CHAR, (value).dtor_S(), (this).dtor_split());
      Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _911_valueOrError0 = Seq_Compile.__default.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>MapWithResult(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, java.util.function.Function<dafny.DafnySequence<? extends Character>, Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>>)(_912_keys) -> ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>)(_913_s_boxed0) -> {
        dafny.DafnySequence<? extends Character> _913_s = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_913_s_boxed0));
        return (this).FindAndCalcPart(_913_s, _912_keys);
      })).apply(keys), _910_parts);
      if ((_911_valueOrError0).IsFailure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_911_valueOrError0).<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>PropagateFailure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor());
      } else {
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _914_beaconParts = (_911_valueOrError0).Extract(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _915_valueOrError1 = (this).justPrefix(Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>Last(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _910_parts));
        if ((_915_valueOrError1).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_915_valueOrError1).<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor());
        } else {
          boolean _916_lastIsPrefix = (_915_valueOrError1).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          if ((!(forEquality)) && (_916_lastIsPrefix)) {
            dafny.DafnySequence<? extends Character> _917_result = StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate((_914_beaconParts).take((java.math.BigInteger.valueOf((_910_parts).length())).subtract(java.math.BigInteger.ONE)), dafny.DafnySequence.of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>Last(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _910_parts))), dafny.DafnySequence.of((this).dtor_split()));
            return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_S(_917_result));
          } else {
            dafny.DafnySequence<? extends Character> _918_result = StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _914_beaconParts, dafny.DafnySequence.of((this).dtor_split()));
            return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_S(_918_result));
          }
        }
      }
    }
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> TryConstructor(dafny.DafnySequence<? extends ConstructorPart> consFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> vf, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys, dafny.DafnySequence<? extends Character> acc)
  {
    CompoundBeacon _this = this;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((consFields).length())).signum() == 0) {
        if ((java.math.BigInteger.valueOf((acc).length())).signum() == 0) {
          return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Internal Error : Empty beacon created.")));
        } else {
          return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(acc));
        }
      } else {
        BeaconPart _919_part = (((ConstructorPart)(java.lang.Object)((consFields).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_part();
        Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _920_valueOrError0 = (_919_part).getString(item, vf);
        if ((_920_valueOrError0).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_920_valueOrError0).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
        } else {
          Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _921_strValue = (_920_valueOrError0).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          if ((_921_strValue).is_Some()) {
            Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _922_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), !((_921_strValue).dtor_value()).contains((_this).dtor_split()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Part "), (_919_part).getName()), dafny.DafnySequence.asString(" for beacon ")), ((_this).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" has value '")), (_921_strValue).dtor_value()), dafny.DafnySequence.asString("' which contains the split character ")), dafny.DafnySequence.of((_this).dtor_split())), dafny.DafnySequence.asString("'."))));
            if ((_922_valueOrError1).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
              return (_922_valueOrError1).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
            } else {
              Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _923_valueOrError2 = (((keys).is_DontUseKeys()) ? (Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.DafnySequence.<Character>concatenate((_919_part).dtor_prefix(), (_921_strValue).dtor_value()))) : ((_this).PartValueCalc((_921_strValue).dtor_value(), keys, _919_part)));
              if ((_923_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
                return (_923_valueOrError2).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
              } else {
                dafny.DafnySequence<? extends Character> _924_val = (_923_valueOrError2).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
                if ((java.math.BigInteger.valueOf((acc).length())).signum() == 0) {
                  CompoundBeacon _in106 = _this;
                  dafny.DafnySequence<? extends ConstructorPart> _in107 = (consFields).drop(java.math.BigInteger.ONE);
                  dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in108 = item;
                  dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> _in109 = vf;
                  DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in110 = keys;
                  dafny.DafnySequence<? extends Character> _in111 = _924_val;
                  _this = _in106;
                  consFields = _in107;
                  item = _in108;
                  vf = _in109;
                  keys = _in110;
                  acc = _in111;
                  continue TAIL_CALL_START;
                } else {
                  CompoundBeacon _in112 = _this;
                  dafny.DafnySequence<? extends ConstructorPart> _in113 = (consFields).drop(java.math.BigInteger.ONE);
                  dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in114 = item;
                  dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> _in115 = vf;
                  DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in116 = keys;
                  dafny.DafnySequence<? extends Character> _in117 = dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(acc, dafny.DafnySequence.of((_this).dtor_split())), _924_val);
                  _this = _in112;
                  consFields = _in113;
                  item = _in114;
                  vf = _in115;
                  keys = _in116;
                  acc = _in117;
                  continue TAIL_CALL_START;
                }
              }
            }
          } else if ((((ConstructorPart)(java.lang.Object)((consFields).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_required()) {
            return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None());
          } else {
            CompoundBeacon _in118 = _this;
            dafny.DafnySequence<? extends ConstructorPart> _in119 = (consFields).drop(java.math.BigInteger.ONE);
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in120 = item;
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> _in121 = vf;
            DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in122 = keys;
            dafny.DafnySequence<? extends Character> _in123 = acc;
            _this = _in118;
            consFields = _in119;
            item = _in120;
            vf = _in121;
            keys = _in122;
            acc = _in123;
            continue TAIL_CALL_START;
          }
        }
      }
    }
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> TryConstructors(dafny.DafnySequence<? extends Constructor> construct, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> vf, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys)
  {
    CompoundBeacon _this = this;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((construct).length())).signum() == 0) {
        return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None());
      } else {
        Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _925_valueOrError0 = (_this).TryConstructor((((Constructor)(java.lang.Object)((construct).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_parts(), item, vf, keys, dafny.DafnySequence.asString(""));
        if ((_925_valueOrError0).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_925_valueOrError0).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
        } else {
          Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _926_x = (_925_valueOrError0).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          if ((_926_x).is_Some()) {
            return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(_926_x);
          } else {
            CompoundBeacon _in124 = _this;
            dafny.DafnySequence<? extends Constructor> _in125 = (construct).drop(java.math.BigInteger.ONE);
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in126 = item;
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> _in127 = vf;
            DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in128 = keys;
            _this = _in124;
            construct = _in125;
            item = _in126;
            vf = _in127;
            keys = _in128;
            continue TAIL_CALL_START;
          }
        }
      }
    }
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> hash(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> vf, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys)
  {
    return (this).TryConstructors((this).dtor_construct(), item, vf, keys);
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> getNaked(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> vf)
  {
    return (this).TryConstructors((this).dtor_construct(), item, vf, DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_DontUseKeys());
  }
  public Wrappers_Compile.Result<BeaconPart, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> findPart(dafny.DafnySequence<? extends Character> val) {
    dafny.DafnySequence<? extends BeaconPart> _927_thePart = Seq_Compile.__default.<BeaconPart>Filter(BeaconPart._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, java.util.function.Function<BeaconPart, Boolean>>)(_928_val) -> ((java.util.function.Function<BeaconPart, Boolean>)(_929_x_boxed0) -> {
      BeaconPart _929_x = ((BeaconPart)(java.lang.Object)(_929_x_boxed0));
      return ((_929_x).dtor_prefix()).isPrefixOf(_928_val);
    })).apply(val), (this).dtor_parts());
    if ((java.math.BigInteger.valueOf((_927_thePart).length())).signum() == 0) {
      return Wrappers_Compile.Result.<BeaconPart, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("No part found in beacon "), ((this).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" match prefix ")), val)));
    } else if ((java.math.BigInteger.valueOf((_927_thePart).length())).compareTo(java.math.BigInteger.ONE) > 0) {
      return Wrappers_Compile.Result.<BeaconPart, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Internal error. Multiple parts for beacon "), ((this).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" matched prefix of ")), val)));
    } else {
      return Wrappers_Compile.Result.<BeaconPart, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(((BeaconPart)(java.lang.Object)((_927_thePart).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))));
    }
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> getPart(dafny.DafnySequence<? extends Character> val, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> keys)
  {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _930_pieces = StandardLibrary_Compile.__default.<Character>Split(dafny.TypeDescriptor.CHAR, val, (this).dtor_split());
    return (this).calcParts(_930_pieces, keys, dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> calcPart(dafny.DafnySequence<? extends Character> piece, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> keys)
  {
    Wrappers_Compile.Result<BeaconPart, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _931_valueOrError0 = (this).findPart(piece);
    if ((_931_valueOrError0).IsFailure(BeaconPart._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_931_valueOrError0).<dafny.DafnySequence<? extends Character>>PropagateFailure(BeaconPart._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    } else {
      BeaconPart _932_thePart = (_931_valueOrError0).Extract(BeaconPart._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      return (this).PartValueCalc(piece, DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_Keys(keys), _932_thePart);
    }
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> calcParts(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> pieces, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> keys, dafny.DafnySequence<? extends Character> acc)
  {
    CompoundBeacon _this = this;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((pieces).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(acc);
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _933_valueOrError0 = (_this).calcPart(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((pieces).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), keys);
        if ((_933_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_933_valueOrError0).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        } else {
          dafny.DafnySequence<? extends Character> _934_theBeacon = (_933_valueOrError0).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          if ((java.math.BigInteger.valueOf((acc).length())).signum() == 0) {
            CompoundBeacon _in129 = _this;
            dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in130 = (pieces).drop(java.math.BigInteger.ONE);
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _in131 = keys;
            dafny.DafnySequence<? extends Character> _in132 = _934_theBeacon;
            _this = _in129;
            pieces = _in130;
            keys = _in131;
            acc = _in132;
            continue TAIL_CALL_START;
          } else {
            CompoundBeacon _in133 = _this;
            dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in134 = (pieces).drop(java.math.BigInteger.ONE);
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _in135 = keys;
            dafny.DafnySequence<? extends Character> _in136 = dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(acc, dafny.DafnySequence.of((_this).dtor_split())), _934_theBeacon);
            _this = _in133;
            pieces = _in134;
            keys = _in135;
            acc = _in136;
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
  public Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> CheckOnePrefixPart(java.math.BigInteger pos1, java.math.BigInteger pos2)
  {
    if (!((this).OkPrefixPair(pos1, pos2))) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Compound beacon "), ((this).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" defines part ")), (((BeaconPart)(java.lang.Object)(((this).dtor_parts()).select(dafny.Helpers.toInt((pos1)))))).getName()), dafny.DafnySequence.asString(" with prefix ")), (((BeaconPart)(java.lang.Object)(((this).dtor_parts()).select(dafny.Helpers.toInt((pos1)))))).dtor_prefix()), dafny.DafnySequence.asString(" which is incompatible with part ")), (((BeaconPart)(java.lang.Object)(((this).dtor_parts()).select(dafny.Helpers.toInt((pos2)))))).getName()), dafny.DafnySequence.asString(" which has a prefix of ")), (((BeaconPart)(java.lang.Object)(((this).dtor_parts()).select(dafny.Helpers.toInt((pos2)))))).dtor_prefix()), dafny.DafnySequence.asString("."))));
    } else {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    }
  }
  public Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> CheckOnePrefix(java.math.BigInteger pos) {
    dafny.DafnySequence<? extends java.math.BigInteger> _935_partNumbers = dafny.DafnySequence.Create(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(((this).dtor_parts()).length()), ((java.util.function.Function<java.math.BigInteger, java.math.BigInteger>)(_936_i_boxed0) -> {
      java.math.BigInteger _936_i = ((java.math.BigInteger)(java.lang.Object)(_936_i_boxed0));
      return _936_i;
    }));
    Wrappers_Compile.Result<dafny.DafnySequence<? extends Boolean>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _937_valueOrError0 = Seq_Compile.__default.<java.math.BigInteger, Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>MapWithResult(dafny.TypeDescriptor.BIG_INTEGER, dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<java.math.BigInteger, java.util.function.Function<java.math.BigInteger, Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>>)(_938_pos) -> ((java.util.function.Function<java.math.BigInteger, Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>)(_939_p_boxed0) -> {
      java.math.BigInteger _939_p = ((java.math.BigInteger)(java.lang.Object)(_939_p_boxed0));
      return (this).CheckOnePrefixPart(_938_pos, _939_p);
    })).apply(pos), dafny.DafnySequence.Create(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(((this).dtor_parts()).length()), ((java.util.function.Function<java.math.BigInteger, java.math.BigInteger>)(_940_i_boxed0) -> {
      java.math.BigInteger _940_i = ((java.math.BigInteger)(java.lang.Object)(_940_i_boxed0));
      return _940_i;
    })));
    if ((_937_valueOrError0).IsFailure(dafny.DafnySequence.<Boolean>_typeDescriptor(dafny.TypeDescriptor.BOOLEAN), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_937_valueOrError0).<Boolean>PropagateFailure(dafny.DafnySequence.<Boolean>_typeDescriptor(dafny.TypeDescriptor.BOOLEAN), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
    } else {
      dafny.DafnySequence<? extends Boolean> _941___v1 = (_937_valueOrError0).Extract(dafny.DafnySequence.<Boolean>_typeDescriptor(dafny.TypeDescriptor.BOOLEAN), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    }
  }
  public Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> ValidPrefixSetResultPos(java.math.BigInteger index) {
    CompoundBeacon _this = this;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf(((_this).dtor_parts()).length())).compareTo(index) <= 0) {
        return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
      } else {
        Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _942_valueOrError0 = (_this).CheckOnePrefix(index);
        if ((_942_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_942_valueOrError0).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
        } else {
          boolean _943___v2 = (_942_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          CompoundBeacon _in137 = _this;
          java.math.BigInteger _in138 = (index).add(java.math.BigInteger.ONE);
          _this = _in137;
          index = _in138;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> ValidPrefixSetResult() {
    Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _944_valueOrError0 = (this).ValidPrefixSetResultPos(java.math.BigInteger.ZERO);
    if ((_944_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_944_valueOrError0).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
    } else {
      boolean _945___v3 = (_944_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      if (dafny.Helpers.Quantifier(dafny.Helpers.IntegerRange(java.math.BigInteger.ZERO, java.math.BigInteger.valueOf(((this).dtor_parts()).length())), true, ((_forall_var_12_boxed0) -> {
        java.math.BigInteger _forall_var_12 = ((java.math.BigInteger)(java.lang.Object)(_forall_var_12_boxed0));
        if (true) {
          java.math.BigInteger _946_x = (java.math.BigInteger)_forall_var_12;
          if ((_946_x).signum() != -1) {
            return dafny.Helpers.Quantifier(dafny.Helpers.IntegerRange(java.math.BigInteger.ZERO, java.math.BigInteger.valueOf(((this).dtor_parts()).length())), true, ((_forall_var_13_boxed0) -> {
              java.math.BigInteger _forall_var_13 = ((java.math.BigInteger)(java.lang.Object)(_forall_var_13_boxed0));
              if (true) {
                java.math.BigInteger _947_y = (java.math.BigInteger)_forall_var_13;
                if ((_947_y).signum() != -1) {
                  return !((((_946_x).signum() != -1) && ((_946_x).compareTo(java.math.BigInteger.valueOf(((this).dtor_parts()).length())) < 0)) && (((_946_x).compareTo(_947_y) < 0) && ((_947_y).compareTo(java.math.BigInteger.valueOf(((this).dtor_parts()).length())) < 0))) || ((this).OkPrefixPair(_946_x, _947_y));
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
        return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
      } else {
        return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Internal Error")));
      }
    }
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> PartValueCalc(dafny.DafnySequence<? extends Character> data, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys, BeaconPart part)
  {
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _948_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), !(data).contains((this).dtor_split()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Value '"), data), dafny.DafnySequence.asString("' for beacon part ")), (part).getName()), dafny.DafnySequence.asString(" contains the split character '")), dafny.DafnySequence.of((this).dtor_split())), dafny.DafnySequence.asString("'."))));
    if ((_948_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_948_valueOrError0).<dafny.DafnySequence<? extends Character>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    } else {
      BeaconPart _source12 = part;
      if (_source12.is_Sensitive()) {
        dafny.DafnySequence<? extends Character> _949___mcc_h0 = ((CompoundBeacon_Compile.BeaconPart_Sensitive)_source12)._prefix;
        BaseBeacon_Compile.StandardBeacon _950___mcc_h1 = ((CompoundBeacon_Compile.BeaconPart_Sensitive)_source12)._beacon;
        BaseBeacon_Compile.StandardBeacon _951_b = _950___mcc_h1;
        dafny.DafnySequence<? extends Character> _952_p = _949___mcc_h0;
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _953_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), (keys).is_Keys(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Need KeyId for beacon "), ((_951_b).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" but no KeyId found in query."))));
        if ((_953_valueOrError1).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_953_valueOrError1).<dafny.DafnySequence<? extends Character>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        } else {
          Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _954_valueOrError2 = (_951_b).hashStr(data, (keys).dtor_value());
          if ((_954_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
            return (_954_valueOrError2).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          } else {
            dafny.DafnySequence<? extends Character> _955_hash = (_954_valueOrError2).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
            return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.DafnySequence.<Character>concatenate((part).dtor_prefix(), _955_hash));
          }
        }
      } else {
        dafny.DafnySequence<? extends Character> _956___mcc_h4 = ((CompoundBeacon_Compile.BeaconPart_NonSensitive)_source12)._prefix;
        dafny.DafnySequence<? extends Character> _957___mcc_h5 = ((CompoundBeacon_Compile.BeaconPart_NonSensitive)_source12)._name;
        dafny.DafnySequence<? extends TermLoc_Compile.Selector> _958___mcc_h6 = ((CompoundBeacon_Compile.BeaconPart_NonSensitive)_source12)._loc;
        BeaconPart _959_NonSensitive = part;
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.DafnySequence.<Character>concatenate((part).dtor_prefix(), data));
      }
    }
  }
}
