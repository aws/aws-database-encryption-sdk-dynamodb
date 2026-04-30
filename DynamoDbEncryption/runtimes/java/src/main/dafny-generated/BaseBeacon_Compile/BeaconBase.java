// Class BeaconBase
// Dafny class BeaconBase compiled into Java
package BaseBeacon_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class BeaconBase {
  public software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient _client;
  public dafny.DafnySequence<? extends Character> _name;
  public dafny.DafnySequence<? extends Character> _beaconName;
  public BeaconBase (software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient client, dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> beaconName) {
    this._client = client;
    this._name = name;
    this._beaconName = beaconName;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BeaconBase o = (BeaconBase)other;
    return true && this._client == o._client && java.util.Objects.equals(this._name, o._name) && java.util.Objects.equals(this._beaconName, o._beaconName);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._client);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._name);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._beaconName);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("BaseBeacon.BeaconBase.BeaconBase");
    s.append("(");
    s.append(dafny.Helpers.toString(this._client));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._name));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._beaconName));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<BeaconBase> _TYPE = dafny.TypeDescriptor.<BeaconBase>referenceWithInitializer(BeaconBase.class, () -> BeaconBase.Default());
  public static dafny.TypeDescriptor<BeaconBase> _typeDescriptor() {
    return (dafny.TypeDescriptor<BeaconBase>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final BeaconBase theDefault = BeaconBase.create(null, dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
  public static BeaconBase Default() {
    return theDefault;
  }
  public static BeaconBase create(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient client, dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> beaconName) {
    return new BeaconBase(client, name, beaconName);
  }
  public static BeaconBase create_BeaconBase(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient client, dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> beaconName) {
    return create(client, name, beaconName);
  }
  public boolean is_BeaconBase() { return true; }
  public software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient dtor_client() {
    return this._client;
  }
  public dafny.DafnySequence<? extends Character> dtor_name() {
    return this._name;
  }
  public dafny.DafnySequence<? extends Character> dtor_beaconName() {
    return this._beaconName;
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> hash(dafny.DafnySequence<? extends java.lang.Byte> val, dafny.DafnySequence<? extends java.lang.Byte> key, byte length)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = (this).getHmac(val, key);
    if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _1_hash = (_0_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), __default.BytesToHex(_1_hash, length));
    }
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> hashStr(dafny.DafnySequence<? extends Character> val, dafny.DafnySequence<? extends java.lang.Byte> key, byte length)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _0_str = UTF8.__default.Encode(val);
    if ((_0_str).is_Failure()) {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E((_0_str).dtor_error()));
    } else {
      return (this).hash((_0_str).dtor_value(), key, length);
    }
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> getHmac(dafny.DafnySequence<? extends java.lang.Byte> data, dafny.DafnySequence<? extends java.lang.Byte> key)
  {
    software.amazon.cryptography.primitives.internaldafny.types.HMacInput _0_input = software.amazon.cryptography.primitives.internaldafny.types.HMacInput.create(software.amazon.cryptography.primitives.internaldafny.types.DigestAlgorithm.create_SHA__384(), key, data);
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError0 = (((this).dtor_client()).HMac(_0_input)).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.primitives.internaldafny.types.Error, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_2_e_boxed0) -> {
      software.amazon.cryptography.primitives.internaldafny.types.Error _2_e = ((software.amazon.cryptography.primitives.internaldafny.types.Error)(java.lang.Object)(_2_e_boxed0));
      return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error.create_AwsCryptographyPrimitives(_2_e);
    }));
    if ((_1_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_1_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _3_output = (_1_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (_3_output).take(java.math.BigInteger.valueOf(8L)));
    }
  }
}
