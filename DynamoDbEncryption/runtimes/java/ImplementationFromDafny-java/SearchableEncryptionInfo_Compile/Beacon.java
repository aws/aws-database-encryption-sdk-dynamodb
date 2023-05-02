// Class Beacon
// Dafny class Beacon compiled into Java
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
public abstract class Beacon {
  public Beacon() { }

  private static final Beacon theDefault = SearchableEncryptionInfo_Compile.Beacon.create_Standard(BaseBeacon_Compile.StandardBeacon.Default());
  public static Beacon Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<Beacon> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(Beacon.class, () -> Default());
  public static dafny.TypeDescriptor<Beacon> _typeDescriptor() {
    return (dafny.TypeDescriptor<Beacon>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static Beacon create_Standard(BaseBeacon_Compile.StandardBeacon std) {
    return new Beacon_Standard(std);
  }
  public static Beacon create_Compound(CompoundBeacon_Compile.CompoundBeacon cmp) {
    return new Beacon_Compound(cmp);
  }
  public boolean is_Standard() { return this instanceof Beacon_Standard; }
  public boolean is_Compound() { return this instanceof Beacon_Compound; }
  public BaseBeacon_Compile.StandardBeacon dtor_std() {
    Beacon d = this;
    return ((Beacon_Standard)d)._std;
  }
  public CompoundBeacon_Compile.CompoundBeacon dtor_cmp() {
    Beacon d = this;
    return ((Beacon_Compound)d)._cmp;
  }
  public boolean isEncrypted() {
    if ((this).is_Standard()) {
      return true;
    } else {
      return ((this).dtor_cmp()).isEncrypted();
    }
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> hash(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> vf, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys)
  {
    if ((this).is_Standard()) {
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _993_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), (keys).is_Keys(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Need key for beacon "), (((this).dtor_std()).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" but no keyId found in query."))));
      if ((_993_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_993_valueOrError0).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
      } else if (((keys).dtor_value()).<dafny.DafnySequence<? extends Character>>contains((((this).dtor_std()).dtor_base()).dtor_name())) {
        return ((this).dtor_std()).getHash(item, vf, ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)(((keys).dtor_value()).get((((this).dtor_std()).dtor_base()).dtor_name()))));
      } else {
        return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Internal error. Beacon "), (((this).dtor_std()).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" has no key."))));
      }
    } else {
      return ((this).dtor_cmp()).hash(item, vf, keys);
    }
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> naked(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> vf)
  {
    if ((this).is_Standard()) {
      return ((this).dtor_std()).getNaked(item, vf);
    } else {
      Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _994_valueOrError0 = ((this).dtor_cmp()).getNaked(item, vf);
      if ((_994_valueOrError0).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_994_valueOrError0).<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()));
      } else {
        Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _995_str = (_994_valueOrError0).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        if ((_995_str).is_None()) {
          return Wrappers_Compile.Result.<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>create_None());
        } else {
          return Wrappers_Compile.Result.<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>create_Some(DdbVirtualFields_Compile.__default.DS((_995_str).dtor_value())));
        }
      }
    }
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> attrHash(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> vf, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys)
  {
    if ((keys).is_DontUseKeys()) {
      return (this).naked(item, vf);
    } else {
      Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _996_valueOrError0 = (this).hash(item, vf, keys);
      if ((_996_valueOrError0).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_996_valueOrError0).<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()));
      } else {
        Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _997_str = (_996_valueOrError0).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        if ((_997_str).is_None()) {
          return Wrappers_Compile.Result.<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>create_None());
        } else {
          return Wrappers_Compile.Result.<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>create_Some(DdbVirtualFields_Compile.__default.DS((_997_str).dtor_value())));
        }
      }
    }
  }
  public dafny.DafnySequence<? extends Character> getName() {
    if ((this).is_Standard()) {
      return (((this).dtor_std()).dtor_base()).dtor_name();
    } else {
      return (((this).dtor_cmp()).dtor_base()).dtor_name();
    }
  }
  public dafny.DafnySequence<? extends Character> getBeaconName() {
    if ((this).is_Standard()) {
      return (((this).dtor_std()).dtor_base()).dtor_beaconName();
    } else {
      return (((this).dtor_cmp()).dtor_base()).dtor_beaconName();
    }
  }
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> GetFields(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields) {
    if ((this).is_Standard()) {
      return ((this).dtor_std()).GetFields(virtualFields);
    } else {
      return ((this).dtor_cmp()).GetFields(virtualFields);
    }
  }
  public Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GetBeaconValue(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue value, DynamoDbEncryptionUtil_Compile.MaybeKeyMap keys, boolean forEquality)
  {
    if ((keys).is_DontUseKeys()) {
      return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(value);
    } else if ((this).is_Standard()) {
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _998_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), !((keys).is_ShouldHaveKeys()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Need KeyId because of beacon "), (((this).dtor_std()).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" but no KeyId found in query"))));
      if ((_998_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_998_valueOrError0).<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor());
      } else {
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _999_keys = (keys).dtor_value();
        if ((_999_keys).<dafny.DafnySequence<? extends Character>>contains((((this).dtor_std()).dtor_base()).dtor_name())) {
          return ((this).dtor_std()).GetBeaconValue(value, ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((_999_keys).get((((this).dtor_std()).dtor_base()).dtor_name()))));
        } else {
          return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Internal error. Beacon "), (((this).dtor_std()).dtor_base()).dtor_name()), dafny.DafnySequence.asString(" has no key."))));
        }
      }
    } else {
      return ((this).dtor_cmp()).GetBeaconValue(value, keys, forEquality);
    }
  }
}
