// Class VirtPart
// Dafny class VirtPart compiled into Java
package DdbVirtualFields_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class VirtPart {
  public dafny.DafnySequence<? extends TermLoc_Compile.Selector> _loc;
  public dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform> _trans;
  public VirtPart (dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc, dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform> trans) {
    this._loc = loc;
    this._trans = trans;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    VirtPart o = (VirtPart)other;
    return true && java.util.Objects.equals(this._loc, o._loc) && java.util.Objects.equals(this._trans, o._trans);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._loc);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._trans);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("DdbVirtualFields.VirtPart.VirtPart");
    s.append("(");
    s.append(dafny.Helpers.toString(this._loc));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._trans));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<VirtPart> _TYPE = dafny.TypeDescriptor.<VirtPart>referenceWithInitializer(VirtPart.class, () -> VirtPart.Default());
  public static dafny.TypeDescriptor<VirtPart> _typeDescriptor() {
    return (dafny.TypeDescriptor<VirtPart>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final VirtPart theDefault = VirtPart.create(dafny.DafnySequence.<TermLoc_Compile.Selector> empty(TermLoc_Compile.Selector._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform> empty(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform._typeDescriptor()));
  public static VirtPart Default() {
    return theDefault;
  }
  public static VirtPart create(dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc, dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform> trans) {
    return new VirtPart(loc, trans);
  }
  public static VirtPart create_VirtPart(dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc, dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform> trans) {
    return create(loc, trans);
  }
  public boolean is_VirtPart() { return true; }
  public dafny.DafnySequence<? extends TermLoc_Compile.Selector> dtor_loc() {
    return this._loc;
  }
  public dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform> dtor_trans() {
    return this._trans;
  }
}
