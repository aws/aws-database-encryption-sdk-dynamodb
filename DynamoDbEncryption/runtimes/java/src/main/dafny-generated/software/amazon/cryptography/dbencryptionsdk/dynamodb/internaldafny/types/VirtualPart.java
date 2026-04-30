// Class VirtualPart
// Dafny class VirtualPart compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class VirtualPart {
  public dafny.DafnySequence<? extends Character> _loc;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends VirtualTransform>> _trans;
  public VirtualPart (dafny.DafnySequence<? extends Character> loc, Wrappers_Compile.Option<dafny.DafnySequence<? extends VirtualTransform>> trans) {
    this._loc = loc;
    this._trans = trans;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    VirtualPart o = (VirtualPart)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualPart.VirtualPart");
    s.append("(");
    s.append(dafny.Helpers.toString(this._loc));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._trans));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<VirtualPart> _TYPE = dafny.TypeDescriptor.<VirtualPart>referenceWithInitializer(VirtualPart.class, () -> VirtualPart.Default());
  public static dafny.TypeDescriptor<VirtualPart> _typeDescriptor() {
    return (dafny.TypeDescriptor<VirtualPart>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final VirtualPart theDefault = VirtualPart.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), Wrappers_Compile.Option.<dafny.DafnySequence<? extends VirtualTransform>>Default(VirtualTransformList._typeDescriptor()));
  public static VirtualPart Default() {
    return theDefault;
  }
  public static VirtualPart create(dafny.DafnySequence<? extends Character> loc, Wrappers_Compile.Option<dafny.DafnySequence<? extends VirtualTransform>> trans) {
    return new VirtualPart(loc, trans);
  }
  public static VirtualPart create_VirtualPart(dafny.DafnySequence<? extends Character> loc, Wrappers_Compile.Option<dafny.DafnySequence<? extends VirtualTransform>> trans) {
    return create(loc, trans);
  }
  public boolean is_VirtualPart() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_loc() {
    return this._loc;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends VirtualTransform>> dtor_trans() {
    return this._trans;
  }
}
