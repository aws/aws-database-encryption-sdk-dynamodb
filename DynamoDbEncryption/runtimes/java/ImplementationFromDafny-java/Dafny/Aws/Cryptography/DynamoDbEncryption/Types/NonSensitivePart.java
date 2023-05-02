// Class NonSensitivePart
// Dafny class NonSensitivePart compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class NonSensitivePart {
  public dafny.DafnySequence<? extends Character> _name;
  public dafny.DafnySequence<? extends Character> _prefix;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _loc;
  public NonSensitivePart (dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> prefix, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> loc) {
    this._name = name;
    this._prefix = prefix;
    this._loc = loc;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    NonSensitivePart o = (NonSensitivePart)other;
    return true && java.util.Objects.equals(this._name, o._name) && java.util.Objects.equals(this._prefix, o._prefix) && java.util.Objects.equals(this._loc, o._loc);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._name);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._prefix);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._loc);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.NonSensitivePart.NonSensitivePart");
    s.append("(");
    s.append(dafny.Helpers.toString(this._name));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._prefix));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._loc));
    s.append(")");
    return s.toString();
  }

  private static final NonSensitivePart theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.NonSensitivePart.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default());
  public static NonSensitivePart Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<NonSensitivePart> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(NonSensitivePart.class, () -> Default());
  public static dafny.TypeDescriptor<NonSensitivePart> _typeDescriptor() {
    return (dafny.TypeDescriptor<NonSensitivePart>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static NonSensitivePart create(dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> prefix, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> loc) {
    return new NonSensitivePart(name, prefix, loc);
  }
  public static NonSensitivePart create_NonSensitivePart(dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> prefix, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> loc) {
    return create(name, prefix, loc);
  }
  public boolean is_NonSensitivePart() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_name() {
    return this._name;
  }
  public dafny.DafnySequence<? extends Character> dtor_prefix() {
    return this._prefix;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> dtor_loc() {
    return this._loc;
  }
}
