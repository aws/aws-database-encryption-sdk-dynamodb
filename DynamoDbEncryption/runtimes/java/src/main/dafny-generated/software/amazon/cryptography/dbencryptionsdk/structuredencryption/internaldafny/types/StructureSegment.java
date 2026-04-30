// Class StructureSegment
// Dafny class StructureSegment compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class StructureSegment {
  public dafny.DafnySequence<? extends Character> _key;
  public StructureSegment (dafny.DafnySequence<? extends Character> key) {
    this._key = key;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    StructureSegment o = (StructureSegment)other;
    return true && java.util.Objects.equals(this._key, o._key);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._key);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructureSegment.StructureSegment");
    s.append("(");
    s.append(dafny.Helpers.toString(this._key));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<StructureSegment> _TYPE = dafny.TypeDescriptor.<StructureSegment>referenceWithInitializer(StructureSegment.class, () -> StructureSegment.Default());
  public static dafny.TypeDescriptor<StructureSegment> _typeDescriptor() {
    return (dafny.TypeDescriptor<StructureSegment>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final StructureSegment theDefault = StructureSegment.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
  public static StructureSegment Default() {
    return theDefault;
  }
  public static StructureSegment create(dafny.DafnySequence<? extends Character> key) {
    return new StructureSegment(key);
  }
  public static StructureSegment create_StructureSegment(dafny.DafnySequence<? extends Character> key) {
    return create(key);
  }
  public boolean is_StructureSegment() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_key() {
    return this._key;
  }
}
