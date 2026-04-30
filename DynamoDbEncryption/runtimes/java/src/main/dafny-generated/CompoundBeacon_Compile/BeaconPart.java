// Class BeaconPart
// Dafny class BeaconPart compiled into Java
package CompoundBeacon_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class BeaconPart {
  public BeaconPart() {
  }
  private static final dafny.TypeDescriptor<BeaconPart> _TYPE = dafny.TypeDescriptor.<BeaconPart>referenceWithInitializer(BeaconPart.class, () -> BeaconPart.Default());
  public static dafny.TypeDescriptor<BeaconPart> _typeDescriptor() {
    return (dafny.TypeDescriptor<BeaconPart>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final BeaconPart theDefault = BeaconPart.create_Encrypted(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), BaseBeacon_Compile.StandardBeacon.Default());
  public static BeaconPart Default() {
    return theDefault;
  }
  public static BeaconPart create_Encrypted(dafny.DafnySequence<? extends Character> prefix, BaseBeacon_Compile.StandardBeacon beacon) {
    return new BeaconPart_Encrypted(prefix, beacon);
  }
  public static BeaconPart create_Signed(dafny.DafnySequence<? extends Character> prefix, dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc) {
    return new BeaconPart_Signed(prefix, name, loc);
  }
  public boolean is_Encrypted() { return this instanceof BeaconPart_Encrypted; }
  public boolean is_Signed() { return this instanceof BeaconPart_Signed; }
  public dafny.DafnySequence<? extends Character> dtor_prefix() {
    BeaconPart d = this;
    if (d instanceof BeaconPart_Encrypted) { return ((BeaconPart_Encrypted)d)._prefix; }
    return ((BeaconPart_Signed)d)._prefix;
  }
  public BaseBeacon_Compile.StandardBeacon dtor_beacon() {
    BeaconPart d = this;
    return ((BeaconPart_Encrypted)d)._beacon;
  }
  public dafny.DafnySequence<? extends Character> dtor_name() {
    BeaconPart d = this;
    return ((BeaconPart_Signed)d)._name;
  }
  public dafny.DafnySequence<? extends TermLoc_Compile.Selector> dtor_loc() {
    BeaconPart d = this;
    return ((BeaconPart_Signed)d)._loc;
  }
  public dafny.DafnySequence<? extends Character> getPrefix() {
    BeaconPart _source0 = this;
    if (_source0.is_Encrypted()) {
      dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((CompoundBeacon_Compile.BeaconPart_Encrypted)_source0)._prefix;
      BaseBeacon_Compile.StandardBeacon _1___mcc_h1 = ((CompoundBeacon_Compile.BeaconPart_Encrypted)_source0)._beacon;
      BaseBeacon_Compile.StandardBeacon _2_b = _1___mcc_h1;
      dafny.DafnySequence<? extends Character> _3_p = _0___mcc_h0;
      return _3_p;
    } else {
      dafny.DafnySequence<? extends Character> _4___mcc_h2 = ((CompoundBeacon_Compile.BeaconPart_Signed)_source0)._prefix;
      dafny.DafnySequence<? extends Character> _5___mcc_h3 = ((CompoundBeacon_Compile.BeaconPart_Signed)_source0)._name;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _6___mcc_h4 = ((CompoundBeacon_Compile.BeaconPart_Signed)_source0)._loc;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _7_l = _6___mcc_h4;
      dafny.DafnySequence<? extends Character> _8_n = _5___mcc_h3;
      dafny.DafnySequence<? extends Character> _9_p = _4___mcc_h2;
      return _9_p;
    }
  }
  public dafny.DafnySequence<? extends Character> getName() {
    BeaconPart _source0 = this;
    if (_source0.is_Encrypted()) {
      dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((CompoundBeacon_Compile.BeaconPart_Encrypted)_source0)._prefix;
      BaseBeacon_Compile.StandardBeacon _1___mcc_h1 = ((CompoundBeacon_Compile.BeaconPart_Encrypted)_source0)._beacon;
      BaseBeacon_Compile.StandardBeacon _2_b = _1___mcc_h1;
      dafny.DafnySequence<? extends Character> _3_p = _0___mcc_h0;
      return ((_2_b).dtor_base()).dtor_name();
    } else {
      dafny.DafnySequence<? extends Character> _4___mcc_h2 = ((CompoundBeacon_Compile.BeaconPart_Signed)_source0)._prefix;
      dafny.DafnySequence<? extends Character> _5___mcc_h3 = ((CompoundBeacon_Compile.BeaconPart_Signed)_source0)._name;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _6___mcc_h4 = ((CompoundBeacon_Compile.BeaconPart_Signed)_source0)._loc;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _7_l = _6___mcc_h4;
      dafny.DafnySequence<? extends Character> _8_n = _5___mcc_h3;
      dafny.DafnySequence<? extends Character> _9_p = _4___mcc_h2;
      return _8_n;
    }
  }
  public Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> getString(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> vf)
  {
    BeaconPart _source0 = this;
    if (_source0.is_Encrypted()) {
      dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((CompoundBeacon_Compile.BeaconPart_Encrypted)_source0)._prefix;
      BaseBeacon_Compile.StandardBeacon _1___mcc_h1 = ((CompoundBeacon_Compile.BeaconPart_Encrypted)_source0)._beacon;
      BaseBeacon_Compile.StandardBeacon _2_b = _1___mcc_h1;
      dafny.DafnySequence<? extends Character> _3_p = _0___mcc_h0;
      return DdbVirtualFields_Compile.__default.VirtToString((_2_b).dtor_loc(), item, vf);
    } else {
      dafny.DafnySequence<? extends Character> _4___mcc_h2 = ((CompoundBeacon_Compile.BeaconPart_Signed)_source0)._prefix;
      dafny.DafnySequence<? extends Character> _5___mcc_h3 = ((CompoundBeacon_Compile.BeaconPart_Signed)_source0)._name;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _6___mcc_h4 = ((CompoundBeacon_Compile.BeaconPart_Signed)_source0)._loc;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _7_l = _6___mcc_h4;
      dafny.DafnySequence<? extends Character> _8_n = _5___mcc_h3;
      dafny.DafnySequence<? extends Character> _9_p = _4___mcc_h2;
      return DdbVirtualFields_Compile.__default.VirtToString(_7_l, item, vf);
    }
  }
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> GetFields(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields) {
    BeaconPart _source0 = this;
    if (_source0.is_Encrypted()) {
      dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((CompoundBeacon_Compile.BeaconPart_Encrypted)_source0)._prefix;
      BaseBeacon_Compile.StandardBeacon _1___mcc_h1 = ((CompoundBeacon_Compile.BeaconPart_Encrypted)_source0)._beacon;
      BaseBeacon_Compile.StandardBeacon _2_b = _1___mcc_h1;
      dafny.DafnySequence<? extends Character> _3_p = _0___mcc_h0;
      return (_2_b).GetFields(virtualFields);
    } else {
      dafny.DafnySequence<? extends Character> _4___mcc_h2 = ((CompoundBeacon_Compile.BeaconPart_Signed)_source0)._prefix;
      dafny.DafnySequence<? extends Character> _5___mcc_h3 = ((CompoundBeacon_Compile.BeaconPart_Signed)_source0)._name;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _6___mcc_h4 = ((CompoundBeacon_Compile.BeaconPart_Signed)_source0)._loc;
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _7_l = _6___mcc_h4;
      dafny.DafnySequence<? extends Character> _8_n = _5___mcc_h3;
      dafny.DafnySequence<? extends Character> _9_p = _4___mcc_h2;
      if ((virtualFields).<dafny.DafnySequence<? extends Character>>contains((((TermLoc_Compile.Selector)(java.lang.Object)(((this).dtor_loc()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key())) {
        return (((DdbVirtualFields_Compile.VirtField)(java.lang.Object)((virtualFields).get((((TermLoc_Compile.Selector)(java.lang.Object)(((this).dtor_loc()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key())))).GetFields();
      } else {
        return dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (((TermLoc_Compile.Selector)(java.lang.Object)(((this).dtor_loc()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key());
      }
    }
  }
}
