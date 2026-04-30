// Class ConstructorPart
// Dafny class ConstructorPart compiled into Java
package CompoundBeacon_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class ConstructorPart {
  public BeaconPart _part;
  public boolean _required;
  public ConstructorPart (BeaconPart part, boolean required) {
    this._part = part;
    this._required = required;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ConstructorPart o = (ConstructorPart)other;
    return true && java.util.Objects.equals(this._part, o._part) && this._required == o._required;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._part);
    hash = ((hash << 5) + hash) + Boolean.hashCode(this._required);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("CompoundBeacon.ConstructorPart.ConstructorPart");
    s.append("(");
    s.append(dafny.Helpers.toString(this._part));
    s.append(", ");
    s.append(this._required);
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<ConstructorPart> _TYPE = dafny.TypeDescriptor.<ConstructorPart>referenceWithInitializer(ConstructorPart.class, () -> ConstructorPart.Default());
  public static dafny.TypeDescriptor<ConstructorPart> _typeDescriptor() {
    return (dafny.TypeDescriptor<ConstructorPart>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final ConstructorPart theDefault = ConstructorPart.create(BeaconPart.Default(), false);
  public static ConstructorPart Default() {
    return theDefault;
  }
  public static ConstructorPart create(BeaconPart part, boolean required) {
    return new ConstructorPart(part, required);
  }
  public static ConstructorPart create_ConstructorPart(BeaconPart part, boolean required) {
    return create(part, required);
  }
  public boolean is_ConstructorPart() { return true; }
  public BeaconPart dtor_part() {
    return this._part;
  }
  public boolean dtor_required() {
    return this._required;
  }
}
