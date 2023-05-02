// Class SensitivePart
// Dafny class SensitivePart compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class SensitivePart {
  public dafny.DafnySequence<? extends Character> _name;
  public dafny.DafnySequence<? extends Character> _prefix;
  public SensitivePart (dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> prefix) {
    this._name = name;
    this._prefix = prefix;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    SensitivePart o = (SensitivePart)other;
    return true && java.util.Objects.equals(this._name, o._name) && java.util.Objects.equals(this._prefix, o._prefix);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._name);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._prefix);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.SensitivePart.SensitivePart");
    s.append("(");
    s.append(dafny.Helpers.toString(this._name));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._prefix));
    s.append(")");
    return s.toString();
  }

  private static final SensitivePart theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SensitivePart.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
  public static SensitivePart Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<SensitivePart> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(SensitivePart.class, () -> Default());
  public static dafny.TypeDescriptor<SensitivePart> _typeDescriptor() {
    return (dafny.TypeDescriptor<SensitivePart>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static SensitivePart create(dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> prefix) {
    return new SensitivePart(name, prefix);
  }
  public static SensitivePart create_SensitivePart(dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> prefix) {
    return create(name, prefix);
  }
  public boolean is_SensitivePart() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_name() {
    return this._name;
  }
  public dafny.DafnySequence<? extends Character> dtor_prefix() {
    return this._prefix;
  }
}
