// Class __default
// Dafny class __default compiled into Java
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
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GetAllKeys(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> stdNames, dafny.DafnySequence<? extends java.lang.Byte> key)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _1011_newKeys;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1012_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out49;
    _out49 = __default.GetHmacKeys(client, stdNames, stdNames, key, dafny.DafnyMap.fromElements());
    _1012_valueOrError0 = _out49;
    if ((_1012_valueOrError0).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      output = (_1012_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())));
      return output;
    }
    _1011_newKeys = (_1012_valueOrError0).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
    output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(_1011_newKeys);
    return output;
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GetHmacKeys(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> allKeys, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> keysLeft, dafny.DafnySequence<? extends java.lang.Byte> key, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> acc)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
    if(true) {
      if ((java.math.BigInteger.valueOf((keysLeft).length())).signum() == 0) {
        output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(acc);
        return output;
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _1013_newKey;
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1014_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out50;
        _out50 = __default.GetBeaconKey(client, key, ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((keysLeft).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))));
        _1014_valueOrError0 = _out50;
        if ((_1014_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          output = (_1014_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())));
          return output;
        }
        _1013_newKey = (_1014_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out51;
        _out51 = __default.GetHmacKeys(client, allKeys, (keysLeft).drop(java.math.BigInteger.ONE), key, dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>update(acc, ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((keysLeft).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), _1013_newKey));
        output = _out51;
      }
    }
    return output;
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GetBeaconKey(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, dafny.DafnySequence<? extends java.lang.Byte> key, dafny.DafnySequence<? extends Character> name)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    dafny.DafnySequence<? extends java.lang.Byte> _1015_info;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1016_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(UTF8.ValidUTF8Bytes.defaultValue());
    _1016_valueOrError0 = (UTF8.__default.Encode(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("AWS_DBE_SCAN_BEACON"), name))).<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>MapFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(_1017_e_boxed0) -> {
      dafny.DafnySequence<? extends Character> _1017_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_1017_e_boxed0));
      return DynamoDbEncryptionUtil_Compile.__default.E(_1017_e);
    }));
    if ((_1016_valueOrError0).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      output = (_1016_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
      return output;
    }
    _1015_info = (_1016_valueOrError0).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.Primitives.Types.Error> _1018_keyR;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.Primitives.Types.Error> _out52;
    _out52 = (client).Hkdf(Dafny.Aws.Cryptography.Primitives.Types.HkdfInput.create(Dafny.Aws.Cryptography.Primitives.Types.DigestAlgorithm.create_SHA__512(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_None(), key, _1015_info, 64));
    _1018_keyR = _out52;
    dafny.DafnySequence<? extends java.lang.Byte> _1019_newKey;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1020_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    _1020_valueOrError1 = (_1018_keyR).<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.Primitives.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.Primitives.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(_1021_e_boxed0) -> {
      Dafny.Aws.Cryptography.Primitives.Types.Error _1021_e = ((Dafny.Aws.Cryptography.Primitives.Types.Error)(java.lang.Object)(_1021_e_boxed0));
      return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error.create_AwsCryptographyPrimitives(_1021_e);
    }));
    if ((_1020_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      output = (_1020_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
      return output;
    }
    _1019_newKey = (_1020_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
    output = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(_1019_newKey);
    return output;
  }
  public static SearchInfo MakeSearchInfo(BeaconVersion version) {
    return SearchableEncryptionInfo_Compile.SearchInfo.create(dafny.DafnySequence.of(ValidBeaconVersion._typeDescriptor(), version), java.math.BigInteger.ZERO);
  }
  public static boolean IsBeaconOfType(Beacon b, BeaconType t)
  {
    BeaconType _source14 = t;
    if (_source14.is_AnyBeacon()) {
      return true;
    } else if (_source14.is_SignedBeacon()) {
      return !((b).isEncrypted());
    } else {
      return (b).isEncrypted();
    }
  }
  public static Wrappers_Compile.Result<BeaconVersion, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> MakeBeaconVersion(long version, KeySource keySource, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Beacon> beacons, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields)
  {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1022_beaconNames = Sets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, (beacons).keySet(), DynamoDbEncryptionUtil_Compile.__default::CharLess);
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1023_stdKeys = Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>Filter(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Beacon>, java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>>)(_1024_beacons) -> ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>)(_1025_k_boxed0) -> {
      dafny.DafnySequence<? extends Character> _1025_k = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_1025_k_boxed0));
      return ((_1024_beacons).<dafny.DafnySequence<? extends Character>>contains(_1025_k)) && ((((Beacon)(java.lang.Object)((_1024_beacons).get(_1025_k)))).is_Standard());
    })).apply(beacons), _1022_beaconNames);
    BeaconVersion _1026_bv = SearchableEncryptionInfo_Compile.BeaconVersion.create(version, keySource, virtualFields, beacons, _1022_beaconNames, _1023_stdKeys);
    return Wrappers_Compile.Result.<BeaconVersion, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(_1026_bv);
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "SearchableEncryptionInfo_Compile._default";
  }
}
