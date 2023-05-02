// Class BeaconVersion
// Dafny class BeaconVersion compiled into Java
package SearchableEncryptionInfo_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class BeaconVersion {
  public long _version;
  public KeySource _keySource;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> _virtualFields;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Beacon> _beacons;
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _beaconNames;
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _stdNames;
  public BeaconVersion (long version, KeySource keySource, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Beacon> beacons, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> beaconNames, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> stdNames) {
    this._version = version;
    this._keySource = keySource;
    this._virtualFields = virtualFields;
    this._beacons = beacons;
    this._beaconNames = beaconNames;
    this._stdNames = stdNames;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BeaconVersion o = (BeaconVersion)other;
    return true && this._version == o._version && java.util.Objects.equals(this._keySource, o._keySource) && java.util.Objects.equals(this._virtualFields, o._virtualFields) && java.util.Objects.equals(this._beacons, o._beacons) && java.util.Objects.equals(this._beaconNames, o._beaconNames) && java.util.Objects.equals(this._stdNames, o._stdNames);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.lang.Long.hashCode(this._version);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._keySource);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._virtualFields);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._beacons);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._beaconNames);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._stdNames);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("SearchableEncryptionInfo_Compile.BeaconVersion.BeaconVersion");
    s.append("(");
    s.append(this._version);
    s.append(", ");
    s.append(dafny.Helpers.toString(this._keySource));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._virtualFields));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._beacons));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._beaconNames));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._stdNames));
    s.append(")");
    return s.toString();
  }

  private static final BeaconVersion theDefault = SearchableEncryptionInfo_Compile.BeaconVersion.create(VersionNumber.Witness, KeySource.Default(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,DdbVirtualFields_Compile.VirtField> empty(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Beacon> empty(), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
  public static BeaconVersion Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<BeaconVersion> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(BeaconVersion.class, () -> Default());
  public static dafny.TypeDescriptor<BeaconVersion> _typeDescriptor() {
    return (dafny.TypeDescriptor<BeaconVersion>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static BeaconVersion create(long version, KeySource keySource, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Beacon> beacons, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> beaconNames, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> stdNames) {
    return new BeaconVersion(version, keySource, virtualFields, beacons, beaconNames, stdNames);
  }
  public static BeaconVersion create_BeaconVersion(long version, KeySource keySource, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Beacon> beacons, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> beaconNames, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> stdNames) {
    return create(version, keySource, virtualFields, beacons, beaconNames, stdNames);
  }
  public boolean is_BeaconVersion() { return true; }
  public long dtor_version() {
    return this._version;
  }
  public KeySource dtor_keySource() {
    return this._keySource;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> dtor_virtualFields() {
    return this._virtualFields;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Beacon> dtor_beacons() {
    return this._beacons;
  }
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> dtor_beaconNames() {
    return this._beaconNames;
  }
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> dtor_stdNames() {
    return this._stdNames;
  }
  public boolean IsBeacon(dafny.DafnySequence<? extends Character> field) {
    return ((this).dtor_beacons()).<dafny.DafnySequence<? extends Character>>contains(field);
  }
  public boolean IsVirtualField(dafny.DafnySequence<? extends Character> field) {
    return ((this).dtor_virtualFields()).<dafny.DafnySequence<? extends Character>>contains(field);
  }
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> GetFields(dafny.DafnySequence<? extends Character> field) {
    if ((this).IsBeacon(field)) {
      return dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate((((Beacon)(java.lang.Object)(((this).dtor_beacons()).get(field)))).GetFields((this).dtor_virtualFields()), dafny.DafnySequence.of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("aws_dbe_b_"), field)));
    } else {
      return dafny.DafnySequence.of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), field);
    }
  }
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> GenerateClosure(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> fields) {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> _1000_fieldLists = Seq_Compile.__default.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>Map(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>)(_1001_s_boxed0) -> {
      dafny.DafnySequence<? extends Character> _1001_s = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_1001_s_boxed0));
      return (this).GetFields(_1001_s);
    }), fields);
    dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _1002_fieldSet = ((java.util.function.Function<dafny.DafnySequence<? extends dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(_1003_fieldLists) -> ((dafny.Function0<dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(() -> {
      java.util.ArrayList<dafny.DafnySequence<? extends Character>> _coll25 = new java.util.ArrayList<>();
      for (dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _compr_25_boxed0 : (_1003_fieldLists).Elements()) {
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _compr_25 = ((dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>)(java.lang.Object)(_compr_25_boxed0));
        if (true) {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1004_f = (dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>)_compr_25;
          for (dafny.DafnySequence<? extends Character> _compr_26_boxed0 : (_1004_f).Elements()) {
            dafny.DafnySequence<? extends Character> _compr_26 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_26_boxed0));
            if (true) {
              dafny.DafnySequence<? extends Character> _1005_g = (dafny.DafnySequence<? extends Character>)_compr_26;
              if (((_1003_fieldLists).contains(_1004_f)) && ((_1004_f).contains(_1005_g))) {
                _coll25.add(_1005_g);
              }
            }
          }
        }
      }
      return new dafny.DafnySet<dafny.DafnySequence<? extends Character>>(_coll25);
    })).apply()).apply(_1000_fieldLists);
    return Sets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, _1002_fieldSet, DynamoDbEncryptionUtil_Compile.__default::CharLess);
  }
  public Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> getKeyMap(DynamoDbEncryptionUtil_Compile.MaybeKeyId keyId)
  {
    Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(DynamoDbEncryptionUtil_Compile.MaybeKeyMap.Default());
    if(true) {
      Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out47;
      _out47 = ((this).dtor_keySource()).getKeyMap((this).dtor_stdNames(), keyId);
      output = _out47;
    }
    return output;
  }
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> ListSignedBeacons() {
    return Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>Filter(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>)(_1006_s_boxed0) -> {
      dafny.DafnySequence<? extends Character> _1006_s = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_1006_s_boxed0));
      return __default.IsBeaconOfType(((Beacon)(java.lang.Object)(((this).dtor_beacons()).get(_1006_s))), SearchableEncryptionInfo_Compile.BeaconType.create_SignedBeacon());
    }), (this).dtor_beaconNames());
  }
  public Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GeneratePlainBeacons(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
    if(true) {
      output = (this).GenerateBeacons2((this).dtor_beaconNames(), item, DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_DontUseKeys(), SearchableEncryptionInfo_Compile.BeaconType.create_AnyBeacon(), dafny.DafnyMap.fromElements());
    }
    return output;
  }
  public Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GenerateSignedBeacons(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
    if(true) {
      output = (this).GenerateBeacons2((this).dtor_beaconNames(), item, DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_DontUseKeys(), SearchableEncryptionInfo_Compile.BeaconType.create_SignedBeacon(), dafny.DafnyMap.fromElements());
    }
    return output;
  }
  public Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GenerateEncryptedBeacons(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, DynamoDbEncryptionUtil_Compile.MaybeKeyId keyId)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
    if(true) {
      DynamoDbEncryptionUtil_Compile.MaybeKeyMap _1007_hmacKeys;
      Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1008_valueOrError0 = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(DynamoDbEncryptionUtil_Compile.MaybeKeyMap.Default());
      Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out48;
      _out48 = (this).getKeyMap(keyId);
      _1008_valueOrError0 = _out48;
      if ((_1008_valueOrError0).IsFailure(DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        output = (_1008_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>PropagateFailure(DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()));
        return output;
      }
      _1007_hmacKeys = (_1008_valueOrError0).Extract(DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      output = (this).GenerateBeacons2((this).dtor_beaconNames(), item, _1007_hmacKeys, SearchableEncryptionInfo_Compile.BeaconType.create_EncryptedBeacon(), dafny.DafnyMap.fromElements());
    }
    return output;
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GenerateBeacon(dafny.DafnySequence<? extends Character> name, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys)
  {
    return (((Beacon)(java.lang.Object)(((this).dtor_beacons()).get(name)))).attrHash(item, (this).dtor_virtualFields(), keys);
  }
  public Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GenerateBeacons2(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> names, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys, BeaconType bType, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> acc)
  {
    BeaconVersion _this = this;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((names).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(acc);
      } else if (__default.IsBeaconOfType(((Beacon)(java.lang.Object)(((_this).dtor_beacons()).get(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((names).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))))), bType)) {
        Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1009_valueOrError0 = (_this).GenerateBeacon(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((names).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), item, keys);
        if ((_1009_valueOrError0).IsFailure(Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_1009_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>PropagateFailure(Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()));
        } else {
          Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1010_value = (_1009_valueOrError0).Extract(Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          if ((_1010_value).is_Some()) {
            BeaconVersion _in139 = _this;
            dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in140 = (names).drop(java.math.BigInteger.ONE);
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in141 = item;
            DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in142 = keys;
            BeaconType _in143 = bType;
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in144 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>update(acc, (((Beacon)(java.lang.Object)(((_this).dtor_beacons()).get(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((names).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))))).getBeaconName(), (_1010_value).dtor_value());
            _this = _in139;
            names = _in140;
            item = _in141;
            keys = _in142;
            bType = _in143;
            acc = _in144;
            continue TAIL_CALL_START;
          } else {
            BeaconVersion _in145 = _this;
            dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in146 = (names).drop(java.math.BigInteger.ONE);
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in147 = item;
            DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in148 = keys;
            BeaconType _in149 = bType;
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in150 = acc;
            _this = _in145;
            names = _in146;
            item = _in147;
            keys = _in148;
            bType = _in149;
            acc = _in150;
            continue TAIL_CALL_START;
          }
        }
      } else {
        BeaconVersion _in151 = _this;
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in152 = (names).drop(java.math.BigInteger.ONE);
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in153 = item;
        DynamoDbEncryptionUtil_Compile.MaybeKeyMap _in154 = keys;
        BeaconType _in155 = bType;
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in156 = acc;
        _this = _in151;
        names = _in152;
        item = _in153;
        keys = _in154;
        bType = _in155;
        acc = _in156;
        continue TAIL_CALL_START;
      }
    }
  }
}
