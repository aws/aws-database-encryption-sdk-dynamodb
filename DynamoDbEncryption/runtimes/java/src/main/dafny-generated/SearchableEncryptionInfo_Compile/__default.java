// Class __default
// Dafny class __default compiled into Java
package SearchableEncryptionInfo_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetAllKeys(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient client, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> stdNames, dafny.DafnySequence<? extends java.lang.Byte> key)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
    _out0 = __default.GetHmacKeys(client, stdNames, stdNames, key, dafny.DafnyMap.fromElements());
    _0_valueOrError0 = _out0;
    if ((_0_valueOrError0).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      output = (_0_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())));
      return output;
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _1_newKeys;
    _1_newKeys = (_0_valueOrError0).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), _1_newKeys);
    return output;
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetHmacKeys(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient client, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> allKeys, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> keysLeft, dafny.DafnySequence<? extends java.lang.Byte> key, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> acc)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
    if(true) {
      if ((java.math.BigInteger.valueOf((keysLeft).length())).signum() == 0) {
        output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), acc);
        return output;
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
        _out0 = __default.GetBeaconKey(client, key, ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((keysLeft).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))));
        _0_valueOrError0 = _out0;
        if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_0_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())));
          return output;
        }
        dafny.DafnySequence<? extends java.lang.Byte> _1_newKey;
        _1_newKey = (_0_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
        _out1 = __default.GetHmacKeys(client, allKeys, (keysLeft).drop(java.math.BigInteger.ONE), key, dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>update(acc, ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((keysLeft).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), _1_newKey));
        output = _out1;
      }
    }
    return output;
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetBeaconKey(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient client, dafny.DafnySequence<? extends java.lang.Byte> key, dafny.DafnySequence<? extends Character> name)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), UTF8.ValidUTF8Bytes.defaultValue());
    _0_valueOrError0 = (UTF8.__default.Encode(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("AWS_DBE_SCAN_BEACON"), name))).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_1_e_boxed0) -> {
      dafny.DafnySequence<? extends Character> _1_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_1_e_boxed0));
      return DynamoDbEncryptionUtil_Compile.__default.E(_1_e);
    }));
    if ((_0_valueOrError0).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      output = (_0_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
      return output;
    }
    dafny.DafnySequence<? extends java.lang.Byte> _2_info;
    _2_info = (_0_valueOrError0).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.primitives.internaldafny.types.Error> _3_keyR;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.primitives.internaldafny.types.Error> _out0;
    _out0 = (client).Hkdf(software.amazon.cryptography.primitives.internaldafny.types.HkdfInput.create(software.amazon.cryptography.primitives.internaldafny.types.DigestAlgorithm.create_SHA__512(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_None(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), key, _2_info, 64));
    _3_keyR = _out0;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
    _4_valueOrError1 = (_3_keyR).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.primitives.internaldafny.types.Error, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_5_e_boxed0) -> {
      software.amazon.cryptography.primitives.internaldafny.types.Error _5_e = ((software.amazon.cryptography.primitives.internaldafny.types.Error)(java.lang.Object)(_5_e_boxed0));
      return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error.create_AwsCryptographyPrimitives(_5_e);
    }));
    if ((_4_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      output = (_4_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
      return output;
    }
    dafny.DafnySequence<? extends java.lang.Byte> _6_newKey;
    _6_newKey = (_4_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    output = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), _6_newKey);
    return output;
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GenerateUuidBytes()
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
    if(true) {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _0_uuid_q;
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _out0;
      _out0 = UUID.__default.GenerateUUID();
      _0_uuid_q = _out0;
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
      _1_valueOrError0 = (_0_uuid_q).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_2_e_boxed0) -> {
        dafny.DafnySequence<? extends Character> _2_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_2_e_boxed0));
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error.create_DynamoDbEncryptionException(_2_e);
      }));
      if ((_1_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_1_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
        return output;
      }
      dafny.DafnySequence<? extends Character> _3_uuid;
      _3_uuid = (_1_valueOrError0).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      output = (UUID.__default.ToByteArray(_3_uuid)).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_4_e_boxed0) -> {
        dafny.DafnySequence<? extends Character> _4_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_4_e_boxed0));
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error.create_DynamoDbEncryptionException(_4_e);
      }));
    }
    return output;
  }
  public static SearchInfo MakeSearchInfo(BeaconVersion version) {
    return SearchInfo.create(dafny.DafnySequence.<BeaconVersion> of(ValidBeaconVersion._typeDescriptor(), version), java.math.BigInteger.ZERO);
  }
  public static boolean IsPartOnly(Beacon b) {
    return ((b).is_Standard()) && (((b).dtor_std()).dtor_partOnly());
  }
  public static boolean IsBeaconOfType(Beacon b, BeaconType t)
  {
    BeaconType _source0 = t;
    if (_source0.is_AnyBeacon()) {
      return true;
    } else if (_source0.is_SignedBeacon()) {
      return !((b).isEncrypted());
    } else {
      return (b).isEncrypted();
    }
  }
  public static Wrappers_Compile.Result<BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> MakeBeaconVersion(byte version, KeySource keySource, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Beacon> beacons, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> actions)
  {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_beaconNames = SortedSets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, (beacons).keySet(), DynamoDbEncryptionUtil_Compile.__default::CharLess);
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1_stdKeys = Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>Filter(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Beacon>, java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>>)(_2_beacons) -> ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>)(_3_k_boxed0) -> {
      dafny.DafnySequence<? extends Character> _3_k = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_3_k_boxed0));
      return ((_2_beacons).<dafny.DafnySequence<? extends Character>>contains(_3_k)) && ((((Beacon)(java.lang.Object)((_2_beacons).get(_3_k)))).is_Standard());
    })).apply(beacons), _0_beaconNames);
    dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _4_encrypted = ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(_5_actions) -> ((dafny.Function0<dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(() -> {
      java.util.ArrayList<dafny.DafnySequence<? extends Character>> _coll0 = new java.util.ArrayList<>();
      for (dafny.DafnySequence<? extends Character> _compr_0_boxed0 : (_5_actions).keySet().Elements()) {
        dafny.DafnySequence<? extends Character> _compr_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_0_boxed0));
        dafny.DafnySequence<? extends Character> _6_k = (dafny.DafnySequence<? extends Character>)_compr_0;
        if (((_5_actions).<dafny.DafnySequence<? extends Character>>contains(_6_k)) && (java.util.Objects.equals(((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction)(java.lang.Object)((_5_actions).get(_6_k))), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()))) {
          _coll0.add(_6_k);
        }
      }
      return new dafny.DafnySet<dafny.DafnySequence<? extends Character>>(_coll0);
    })).apply()).apply(actions);
    BeaconVersion _7_bv = BeaconVersion.create(version, keySource, virtualFields, beacons, _0_beaconNames, _1_stdKeys, _4_encrypted);
    return Wrappers_Compile.Result.<BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(BeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), _7_bv);
  }
  @Override
  public java.lang.String toString() {
    return "SearchableEncryptionInfo._default";
  }
}
