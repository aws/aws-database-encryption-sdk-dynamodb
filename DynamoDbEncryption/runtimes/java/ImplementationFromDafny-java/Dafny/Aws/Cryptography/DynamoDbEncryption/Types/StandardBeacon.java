// Class StandardBeacon
// Dafny class StandardBeacon compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class StandardBeacon {
  public dafny.DafnySequence<? extends Character> _name;
  public int _length;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _loc;
  public StandardBeacon (dafny.DafnySequence<? extends Character> name, int length, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> loc) {
    this._name = name;
    this._length = length;
    this._loc = loc;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    StandardBeacon o = (StandardBeacon)other;
    return true && java.util.Objects.equals(this._name, o._name) && this._length == o._length && java.util.Objects.equals(this._loc, o._loc);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._name);
    hash = ((hash << 5) + hash) + java.lang.Integer.hashCode(this._length);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._loc);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.StandardBeacon.StandardBeacon");
    s.append("(");
    s.append(dafny.Helpers.toString(this._name));
    s.append(", ");
    s.append(this._length);
    s.append(", ");
    s.append(dafny.Helpers.toString(this._loc));
    s.append(")");
    return s.toString();
  }

  private static final StandardBeacon theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.StandardBeacon.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), 0, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default());
  public static StandardBeacon Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<StandardBeacon> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(StandardBeacon.class, () -> Default());
  public static dafny.TypeDescriptor<StandardBeacon> _typeDescriptor() {
    return (dafny.TypeDescriptor<StandardBeacon>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static StandardBeacon create(dafny.DafnySequence<? extends Character> name, int length, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> loc) {
    return new StandardBeacon(name, length, loc);
  }
  public static StandardBeacon create_StandardBeacon(dafny.DafnySequence<? extends Character> name, int length, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> loc) {
    return create(name, length, loc);
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
}
