// Class VirtualField
// Dafny class VirtualField compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class VirtualField {
  public dafny.DafnySequence<? extends Character> _name;
  public dafny.DafnySequence<? extends VirtualPart> _parts;
  public VirtualField (dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends VirtualPart> parts) {
    this._name = name;
    this._parts = parts;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    VirtualField o = (VirtualField)other;
    return true && java.util.Objects.equals(this._name, o._name) && java.util.Objects.equals(this._parts, o._parts);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._name);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._parts);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.VirtualField.VirtualField");
    s.append("(");
    s.append(dafny.Helpers.toString(this._name));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._parts));
    s.append(")");
    return s.toString();
  }

  private static final VirtualField theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualField.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<VirtualPart> empty(VirtualPart._typeDescriptor()));
  public static VirtualField Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<VirtualField> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(VirtualField.class, () -> Default());
  public static dafny.TypeDescriptor<VirtualField> _typeDescriptor() {
    return (dafny.TypeDescriptor<VirtualField>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static VirtualField create(dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends VirtualPart> parts) {
    return new VirtualField(name, parts);
  }
  public static VirtualField create_VirtualField(dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends VirtualPart> parts) {
    return create(name, parts);
  }
  public boolean is_VirtualField() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_name() {
    return this._name;
  }
  public dafny.DafnySequence<? extends VirtualPart> dtor_parts() {
    return this._parts;
  }
}
