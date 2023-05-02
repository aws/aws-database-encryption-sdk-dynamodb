// Class BeaconBase
// Dafny class BeaconBase compiled into Java
package BaseBeacon_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class BeaconBase {
  public Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient _client;
  public dafny.DafnySequence<? extends Character> _name;
  public dafny.DafnySequence<? extends Character> _beaconName;
  public BeaconBase (Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> beaconName) {
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
    s.append("BaseBeacon_Compile.BeaconBase.BeaconBase");
    s.append("(");
    s.append(dafny.Helpers.toString(this._client));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._name));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._beaconName));
    s.append(")");
    return s.toString();
  }

  private static final BeaconBase theDefault = BaseBeacon_Compile.BeaconBase.create(null, dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
  public static BeaconBase Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<BeaconBase> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(BeaconBase.class, () -> Default());
  public static dafny.TypeDescriptor<BeaconBase> _typeDescriptor() {
    return (dafny.TypeDescriptor<BeaconBase>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static BeaconBase create(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> beaconName) {
    return new BeaconBase(client, name, beaconName);
  }
  public static BeaconBase create_BeaconBase(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> beaconName) {
    return create(client, name, beaconName);
  }
  public boolean is_BeaconBase() { return true; }
  public Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient dtor_client() {
    return this._client;
  }
  public dafny.DafnySequence<? extends Character> dtor_name() {
    return this._name;
  }
  public dafny.DafnySequence<? extends Character> dtor_beaconName() {
    return this._beaconName;
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> hash(dafny.DafnySequence<? extends java.lang.Byte> val, dafny.DafnySequence<? extends java.lang.Byte> key, byte length)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _828_valueOrError0 = (this).getHmac(val, key);
    if ((_828_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_828_valueOrError0).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _829_hash = (_828_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(__default.BytesToHex(_829_hash, length));
    }
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> hashStr(dafny.DafnySequence<? extends Character> val, dafny.DafnySequence<? extends java.lang.Byte> key, byte length)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _830_str = UTF8.__default.Encode(val);
    if ((_830_str).is_Failure()) {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E((_830_str).dtor_error()));
    } else {
      return (this).hash((_830_str).dtor_value(), key, length);
    }
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> getHmac(dafny.DafnySequence<? extends java.lang.Byte> data, dafny.DafnySequence<? extends java.lang.Byte> key)
  {
    Dafny.Aws.Cryptography.Primitives.Types.HMacInput _831_input = Dafny.Aws.Cryptography.Primitives.Types.HMacInput.create(Dafny.Aws.Cryptography.Primitives.Types.DigestAlgorithm.create_SHA__384(), key, data);
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _832_valueOrError0 = (((this).dtor_client()).HMac(_831_input)).<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.Primitives.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.Primitives.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(_833_e_boxed0) -> {
      Dafny.Aws.Cryptography.Primitives.Types.Error _833_e = ((Dafny.Aws.Cryptography.Primitives.Types.Error)(java.lang.Object)(_833_e_boxed0));
      return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error.create_AwsCryptographyPrimitives(_833_e);
    }));
    if ((_832_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_832_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _834_output = (_832_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success((_834_output).take(java.math.BigInteger.valueOf(8L)));
    }
  }
}
