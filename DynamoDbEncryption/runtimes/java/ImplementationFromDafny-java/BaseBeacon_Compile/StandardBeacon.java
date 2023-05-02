// Class StandardBeacon
// Dafny class StandardBeacon compiled into Java
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
public class StandardBeacon {
  public BeaconBase _base;
  public byte _length;
  public dafny.DafnySequence<? extends TermLoc_Compile.Selector> _loc;
  public StandardBeacon (BeaconBase base, byte length, dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc) {
    this._base = base;
    this._length = length;
    this._loc = loc;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    StandardBeacon o = (StandardBeacon)other;
    return true && java.util.Objects.equals(this._base, o._base) && this._length == o._length && java.util.Objects.equals(this._loc, o._loc);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._base);
    hash = ((hash << 5) + hash) + java.lang.Byte.hashCode(this._length);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._loc);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("BaseBeacon_Compile.StandardBeacon.StandardBeacon");
    s.append("(");
    s.append(dafny.Helpers.toString(this._base));
    s.append(", ");
    s.append(this._length);
    s.append(", ");
    s.append(dafny.Helpers.toString(this._loc));
    s.append(")");
    return s.toString();
  }

  private static final StandardBeacon theDefault = BaseBeacon_Compile.StandardBeacon.create(BeaconBase.Default(), BeaconLength.Witness, dafny.DafnySequence.<TermLoc_Compile.Selector> empty(TermLoc_Compile.Selector._typeDescriptor()));
  public static StandardBeacon Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<StandardBeacon> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(StandardBeacon.class, () -> Default());
  public static dafny.TypeDescriptor<StandardBeacon> _typeDescriptor() {
    return (dafny.TypeDescriptor<StandardBeacon>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static StandardBeacon create(BeaconBase base, byte length, dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc) {
    return new StandardBeacon(base, length, loc);
  }
  public static StandardBeacon create_StandardBeacon(BeaconBase base, byte length, dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc) {
    return create(base, length, loc);
  }
  public boolean is_StandardBeacon() { return true; }
  public BeaconBase dtor_base() {
    return this._base;
  }
  public byte dtor_length() {
    return this._length;
  }
  public dafny.DafnySequence<? extends TermLoc_Compile.Selector> dtor_loc() {
    return this._loc;
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> hash(dafny.DafnySequence<? extends java.lang.Byte> val, dafny.DafnySequence<? extends java.lang.Byte> key)
  {
    return ((this).dtor_base()).hash(val, key, (this).dtor_length());
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> hashStr(dafny.DafnySequence<? extends Character> val, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> keys)
  {
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _835_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), (keys).<dafny.DafnySequence<? extends Character>>contains(((this).dtor_base()).dtor_name()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Internal Error, no key for "), ((this).dtor_base()).dtor_name())));
    if ((_835_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_835_valueOrError0).<dafny.DafnySequence<? extends Character>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    } else {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _836_str = UTF8.__default.Encode(val);
      if ((_836_str).is_Failure()) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E((_836_str).dtor_error()));
      } else {
        return (this).hash((_836_str).dtor_value(), ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((keys).get(((this).dtor_base()).dtor_name()))));
      }
    }
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> getHash(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> vf, dafny.DafnySequence<? extends java.lang.Byte> key)
  {
    Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _837_valueOrError0 = DdbVirtualFields_Compile.__default.VirtToBytes((this).dtor_loc(), item, vf);
    if ((_837_valueOrError0).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_837_valueOrError0).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
    } else {
      Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>> _838_bytes = (_837_valueOrError0).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      if ((_838_bytes).is_None()) {
        return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None());
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _839_valueOrError1 = (this).hash((_838_bytes).dtor_value(), key);
        if ((_839_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_839_valueOrError1).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
        } else {
          dafny.DafnySequence<? extends Character> _840_res = (_839_valueOrError1).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(_840_res));
        }
      }
    }
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> getNaked(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> vf)
  {
    return DdbVirtualFields_Compile.__default.VirtToAttr((this).dtor_loc(), item, vf);
  }
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> GetFields(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields) {
    if ((virtualFields).<dafny.DafnySequence<? extends Character>>contains((((TermLoc_Compile.Selector)(java.lang.Object)(((this).dtor_loc()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key())) {
      return (((DdbVirtualFields_Compile.VirtField)(java.lang.Object)((virtualFields).get((((TermLoc_Compile.Selector)(java.lang.Object)(((this).dtor_loc()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key())))).GetFields();
    } else {
      return dafny.DafnySequence.of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (((TermLoc_Compile.Selector)(java.lang.Object)(((this).dtor_loc()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key());
    }
  }
  public Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GetBeaconValue(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue value, dafny.DafnySequence<? extends java.lang.Byte> key)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _841_valueOrError0 = (DynamoToStruct_Compile.__default.TopLevelAttributeToBytes(value)).<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(_842_e_boxed0) -> {
      dafny.DafnySequence<? extends Character> _842_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_842_e_boxed0));
      return DynamoDbEncryptionUtil_Compile.__default.E(_842_e);
    }));
    if ((_841_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_841_valueOrError0).<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _843_bytes = (_841_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _844_valueOrError1 = (this).hash(_843_bytes, key);
      if ((_844_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_844_valueOrError1).<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor());
      } else {
        dafny.DafnySequence<? extends Character> _845_h = (_844_valueOrError1).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_S(_845_h));
      }
    }
  }
  public Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> getPart(dafny.DafnySequence<? extends java.lang.Byte> val, dafny.DafnySequence<? extends java.lang.Byte> key)
  {
    return ((this).dtor_base()).hash(val, key, (this).dtor_length());
  }
}
