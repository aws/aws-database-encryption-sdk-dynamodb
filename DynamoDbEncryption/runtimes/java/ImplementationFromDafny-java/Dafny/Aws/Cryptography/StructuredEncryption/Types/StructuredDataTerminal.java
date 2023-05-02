// Class StructuredDataTerminal
// Dafny class StructuredDataTerminal compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public class StructuredDataTerminal {
  public dafny.DafnySequence<? extends java.lang.Byte> _value;
  public dafny.DafnySequence<? extends java.lang.Byte> _typeId;
  public StructuredDataTerminal (dafny.DafnySequence<? extends java.lang.Byte> value, dafny.DafnySequence<? extends java.lang.Byte> typeId) {
    this._value = value;
    this._typeId = typeId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    StructuredDataTerminal o = (StructuredDataTerminal)other;
    return true && java.util.Objects.equals(this._value, o._value) && java.util.Objects.equals(this._typeId, o._typeId);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._value);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._typeId);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile.StructuredDataTerminal.StructuredDataTerminal");
    s.append("(");
    s.append(dafny.Helpers.toString(this._value));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._typeId));
    s.append(")");
    return s.toString();
  }

  private static final StructuredDataTerminal theDefault = Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataTerminal.create(dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
  public static StructuredDataTerminal Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<StructuredDataTerminal> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(StructuredDataTerminal.class, () -> Default());
  public static dafny.TypeDescriptor<StructuredDataTerminal> _typeDescriptor() {
    return (dafny.TypeDescriptor<StructuredDataTerminal>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static StructuredDataTerminal create(dafny.DafnySequence<? extends java.lang.Byte> value, dafny.DafnySequence<? extends java.lang.Byte> typeId) {
    return new StructuredDataTerminal(value, typeId);
  }
  public static StructuredDataTerminal create_StructuredDataTerminal(dafny.DafnySequence<? extends java.lang.Byte> value, dafny.DafnySequence<? extends java.lang.Byte> typeId) {
    return create(value, typeId);
  }
  public boolean is_StructuredDataTerminal() { return true; }
  public dafny.DafnySequence<? extends java.lang.Byte> dtor_value() {
    return this._value;
  }
  public dafny.DafnySequence<? extends java.lang.Byte> dtor_typeId() {
    return this._typeId;
  }
}
