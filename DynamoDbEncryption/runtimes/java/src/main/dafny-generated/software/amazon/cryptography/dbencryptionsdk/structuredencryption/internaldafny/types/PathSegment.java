// Class PathSegment
// Dafny class PathSegment compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class PathSegment {
  public StructureSegment _member;
  public PathSegment (StructureSegment member) {
    this._member = member;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    PathSegment o = (PathSegment)other;
    return true && java.util.Objects.equals(this._member, o._member);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._member);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.PathSegment.member");
    s.append("(");
    s.append(dafny.Helpers.toString(this._member));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<PathSegment> _TYPE = dafny.TypeDescriptor.<PathSegment>referenceWithInitializer(PathSegment.class, () -> PathSegment.Default());
  public static dafny.TypeDescriptor<PathSegment> _typeDescriptor() {
    return (dafny.TypeDescriptor<PathSegment>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final PathSegment theDefault = PathSegment.create(StructureSegment.Default());
  public static PathSegment Default() {
    return theDefault;
  }
  public static PathSegment create(StructureSegment member) {
    return new PathSegment(member);
  }
  public static PathSegment create_member(StructureSegment member) {
    return create(member);
  }
  public boolean is_member() { return true; }
  public StructureSegment dtor_member() {
    return this._member;
  }
}
