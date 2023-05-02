// Class BeaconPart
// Dafny class BeaconPart compiled into Java
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
public abstract class BeaconPart {
  public BeaconPart() { }

  private static final BeaconPart theDefault = CompoundBeacon_Compile.BeaconPart.create_Sensitive(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), BaseBeacon_Compile.StandardBeacon.Default());
  public static BeaconPart Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<BeaconPart> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(BeaconPart.class, () -> Default());
  public static dafny.TypeDescriptor<BeaconPart> _typeDescriptor() {
    return (dafny.TypeDescriptor<BeaconPart>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static BeaconPart create_Sensitive(dafny.DafnySequence<? extends Character> prefix, BaseBeacon_Compile.StandardBeacon beacon) {
    return new BeaconPart_Sensitive(prefix, beacon);
  }
  public static BeaconPart create_NonSensitive(dafny.DafnySequence<? extends Character> prefix, dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc) {
    return new BeaconPart_NonSensitive(prefix, name, loc);
  }
  public boolean is_Sensitive() { return this instanceof BeaconPart_Sensitive; }
  public boolean is_NonSensitive() { return this instanceof BeaconPart_NonSensitive; }
  public dafny.DafnySequence<? extends Character> dtor_prefix() {
    BeaconPart d = this;
    if (d instanceof BeaconPart_Sensitive) { return ((BeaconPart_Sensitive)d)._prefix; }
    return ((BeaconPart_NonSensitive)d)._prefix;
  }
  public BaseBeacon_Compile.StandardBeacon dtor_beacon() {
    BeaconPart d = this;
    return ((BeaconPart_Sensitive)d)._beacon;
  }
  public dafny.DafnySequence<? extends Character> dtor_name() {
    BeaconPart d = this;
    return ((BeaconPart_NonSensitive)d)._name;
  }
  public dafny.DafnySequence<? extends TermLoc_Compile.Selector> dtor_loc() {
    BeaconPart d = this;
    return ((BeaconPart_NonSensitive)d)._loc;
  }
  public dafny.DafnySequence<? extends Character> getPrefix() {
    BeaconPart _source8 = this;
    if (_source8.is_Sensitive()) {
      dafny.DafnySequence<? extends Character> _857___mcc_h0 = ((CompoundBeacon_Compile.BeaconPart_Sensitive)_source8)._prefix;
      BaseBeacon_Compile.StandardBeacon _858___mcc_h1 = ((CompoundBeacon_Compile.BeaconPart_Sensitive)_source8)._beacon;
      BaseBeacon_Compile.StandardBeacon _859_b = _858___mcc_h1;
      dafny.DafnySequence<? extends Character> _860_p = _857___mcc_h0;
      return _860_p;
    } else {
      dafny.DafnySequence<? extends Character> _861___mcc_h2 = ((CompoundBeacon_Compile.BeaconPart_NonSensitive)_source8)._prefix;
      dafny.DafnySequence<? extends Character> _862___mcc_h3 = ((CompoundBeacon_Compile.BeaconPart_NonSensitive)_source8)._name;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _863___mcc_h4 = ((CompoundBeacon_Compile.BeaconPart_NonSensitive)_source8)._loc;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _864_l = _863___mcc_h4;
      dafny.DafnySequence<? extends Character> _865_n = _862___mcc_h3;
      dafny.DafnySequence<? extends Character> _866_p = _861___mcc_h2;
      return _866_p;
    }
  }
  public dafny.DafnySequence<? extends Character> getName() {
    BeaconPart _source9 = this;
    if (_source9.is_Sensitive()) {
      dafny.DafnySequence<? extends Character> _867___mcc_h0 = ((CompoundBeacon_Compile.BeaconPart_Sensitive)_source9)._prefix;
      BaseBeacon_Compile.StandardBeacon _868___mcc_h1 = ((CompoundBeacon_Compile.BeaconPart_Sensitive)_source9)._beacon;
      BaseBeacon_Compile.StandardBeacon _869_b = _868___mcc_h1;
      dafny.DafnySequence<? extends Character> _870_p = _867___mcc_h0;
      return ((_869_b).dtor_base()).dtor_name();
    } else {
      dafny.DafnySequence<? extends Character> _871___mcc_h2 = ((CompoundBeacon_Compile.BeaconPart_NonSensitive)_source9)._prefix;
      dafny.DafnySequence<? extends Character> _872___mcc_h3 = ((CompoundBeacon_Compile.BeaconPart_NonSensitive)_source9)._name;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _873___mcc_h4 = ((CompoundBeacon_Compile.BeaconPart_NonSensitive)_source9)._loc;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _874_l = _873___mcc_h4;
      dafny.DafnySequence<? extends Character> _875_n = _872___mcc_h3;
      dafny.DafnySequence<? extends Character> _876_p = _871___mcc_h2;
      return _875_n;
    }
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> getString(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> vf)
  {
    BeaconPart _source10 = this;
    if (_source10.is_Sensitive()) {
      dafny.DafnySequence<? extends Character> _877___mcc_h0 = ((CompoundBeacon_Compile.BeaconPart_Sensitive)_source10)._prefix;
      BaseBeacon_Compile.StandardBeacon _878___mcc_h1 = ((CompoundBeacon_Compile.BeaconPart_Sensitive)_source10)._beacon;
      BaseBeacon_Compile.StandardBeacon _879_b = _878___mcc_h1;
      dafny.DafnySequence<? extends Character> _880_p = _877___mcc_h0;
      return DdbVirtualFields_Compile.__default.VirtToString((_879_b).dtor_loc(), item, vf);
    } else {
      dafny.DafnySequence<? extends Character> _881___mcc_h2 = ((CompoundBeacon_Compile.BeaconPart_NonSensitive)_source10)._prefix;
      dafny.DafnySequence<? extends Character> _882___mcc_h3 = ((CompoundBeacon_Compile.BeaconPart_NonSensitive)_source10)._name;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _883___mcc_h4 = ((CompoundBeacon_Compile.BeaconPart_NonSensitive)_source10)._loc;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _884_l = _883___mcc_h4;
      dafny.DafnySequence<? extends Character> _885_n = _882___mcc_h3;
      dafny.DafnySequence<? extends Character> _886_p = _881___mcc_h2;
      return DdbVirtualFields_Compile.__default.VirtToString(_884_l, item, vf);
    }
  }
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> GetFields(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields) {
    BeaconPart _source11 = this;
    if (_source11.is_Sensitive()) {
      dafny.DafnySequence<? extends Character> _887___mcc_h0 = ((CompoundBeacon_Compile.BeaconPart_Sensitive)_source11)._prefix;
      BaseBeacon_Compile.StandardBeacon _888___mcc_h1 = ((CompoundBeacon_Compile.BeaconPart_Sensitive)_source11)._beacon;
      BaseBeacon_Compile.StandardBeacon _889_b = _888___mcc_h1;
      dafny.DafnySequence<? extends Character> _890_p = _887___mcc_h0;
      return (_889_b).GetFields(virtualFields);
    } else {
      dafny.DafnySequence<? extends Character> _891___mcc_h2 = ((CompoundBeacon_Compile.BeaconPart_NonSensitive)_source11)._prefix;
      dafny.DafnySequence<? extends Character> _892___mcc_h3 = ((CompoundBeacon_Compile.BeaconPart_NonSensitive)_source11)._name;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _893___mcc_h4 = ((CompoundBeacon_Compile.BeaconPart_NonSensitive)_source11)._loc;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _894_l = _893___mcc_h4;
      dafny.DafnySequence<? extends Character> _895_n = _892___mcc_h3;
      dafny.DafnySequence<? extends Character> _896_p = _891___mcc_h2;
      if ((virtualFields).<dafny.DafnySequence<? extends Character>>contains((((TermLoc_Compile.Selector)(java.lang.Object)(((this).dtor_loc()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key())) {
        return (((DdbVirtualFields_Compile.VirtField)(java.lang.Object)((virtualFields).get((((TermLoc_Compile.Selector)(java.lang.Object)(((this).dtor_loc()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key())))).GetFields();
      } else {
        return dafny.DafnySequence.of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (((TermLoc_Compile.Selector)(java.lang.Object)(((this).dtor_loc()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key());
      }
    }
  }
}
