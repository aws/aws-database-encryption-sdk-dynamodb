// Class StandardBeacon
// Dafny class StandardBeacon compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class StandardBeacon {
  public dafny.DafnySequence<? extends Character> _name;
  public int _length;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _loc;
  public Wrappers_Compile.Option<BeaconStyle> _style;
  public StandardBeacon (dafny.DafnySequence<? extends Character> name, int length, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> loc, Wrappers_Compile.Option<BeaconStyle> style) {
    this._name = name;
    this._length = length;
    this._loc = loc;
    this._style = style;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    StandardBeacon o = (StandardBeacon)other;
    return true && java.util.Objects.equals(this._name, o._name) && this._length == o._length && java.util.Objects.equals(this._loc, o._loc) && java.util.Objects.equals(this._style, o._style);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._name);
    hash = ((hash << 5) + hash) + java.lang.Integer.hashCode(this._length);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._loc);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._style);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon.StandardBeacon");
    s.append("(");
    s.append(dafny.Helpers.toString(this._name));
    s.append(", ");
    s.append(this._length);
    s.append(", ");
    s.append(dafny.Helpers.toString(this._loc));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._style));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<StandardBeacon> _TYPE = dafny.TypeDescriptor.<StandardBeacon>referenceWithInitializer(StandardBeacon.class, () -> StandardBeacon.Default());
  public static dafny.TypeDescriptor<StandardBeacon> _typeDescriptor() {
    return (dafny.TypeDescriptor<StandardBeacon>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final StandardBeacon theDefault = StandardBeacon.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), 0, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default(TerminalLocation._typeDescriptor()), Wrappers_Compile.Option.<BeaconStyle>Default(BeaconStyle._typeDescriptor()));
  public static StandardBeacon Default() {
    return theDefault;
  }
  public static StandardBeacon create(dafny.DafnySequence<? extends Character> name, int length, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> loc, Wrappers_Compile.Option<BeaconStyle> style) {
    return new StandardBeacon(name, length, loc, style);
  }
  public static StandardBeacon create_StandardBeacon(dafny.DafnySequence<? extends Character> name, int length, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> loc, Wrappers_Compile.Option<BeaconStyle> style) {
    return create(name, length, loc, style);
  }
  public boolean is_StandardBeacon() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_name() {
    return this._name;
  }
  public int dtor_length() {
    return this._length;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> dtor_loc() {
    return this._loc;
  }
  public Wrappers_Compile.Option<BeaconStyle> dtor_style() {
    return this._style;
  }
}
