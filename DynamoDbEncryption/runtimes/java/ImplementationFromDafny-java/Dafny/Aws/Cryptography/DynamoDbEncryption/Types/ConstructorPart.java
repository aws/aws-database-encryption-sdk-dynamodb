// Class ConstructorPart
// Dafny class ConstructorPart compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class ConstructorPart {
  public dafny.DafnySequence<? extends Character> _name;
  public boolean _required;
  public ConstructorPart (dafny.DafnySequence<? extends Character> name, boolean required) {
    this._name = name;
    this._required = required;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ConstructorPart o = (ConstructorPart)other;
    return true && java.util.Objects.equals(this._name, o._name) && this._required == o._required;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._name);
    hash = ((hash << 5) + hash) + Boolean.hashCode(this._required);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.ConstructorPart.ConstructorPart");
    s.append("(");
    s.append(dafny.Helpers.toString(this._name));
    s.append(", ");
    s.append(this._required);
    s.append(")");
    return s.toString();
  }

  private static final ConstructorPart theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ConstructorPart.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), false);
  public static ConstructorPart Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<ConstructorPart> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(ConstructorPart.class, () -> Default());
  public static dafny.TypeDescriptor<ConstructorPart> _typeDescriptor() {
    return (dafny.TypeDescriptor<ConstructorPart>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static ConstructorPart create(dafny.DafnySequence<? extends Character> name, boolean required) {
    return new ConstructorPart(name, required);
  }
  public static ConstructorPart create_ConstructorPart(dafny.DafnySequence<? extends Character> name, boolean required) {
    return create(name, required);
  }
  public boolean is_ConstructorPart() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_name() {
    return this._name;
  }
  public boolean dtor_required() {
    return this._required;
  }
}
