// Class Constructor
// Dafny class Constructor compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class Constructor {
  public dafny.DafnySequence<? extends ConstructorPart> _parts;
  public Constructor (dafny.DafnySequence<? extends ConstructorPart> parts) {
    this._parts = parts;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Constructor o = (Constructor)other;
    return true && java.util.Objects.equals(this._parts, o._parts);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._parts);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.Constructor.Constructor");
    s.append("(");
    s.append(dafny.Helpers.toString(this._parts));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<Constructor> _TYPE = dafny.TypeDescriptor.<Constructor>referenceWithInitializer(Constructor.class, () -> Constructor.Default());
  public static dafny.TypeDescriptor<Constructor> _typeDescriptor() {
    return (dafny.TypeDescriptor<Constructor>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final Constructor theDefault = Constructor.create(dafny.DafnySequence.<ConstructorPart> empty(ConstructorPart._typeDescriptor()));
  public static Constructor Default() {
    return theDefault;
  }
  public static Constructor create(dafny.DafnySequence<? extends ConstructorPart> parts) {
    return new Constructor(parts);
  }
  public static Constructor create_Constructor(dafny.DafnySequence<? extends ConstructorPart> parts) {
    return create(parts);
  }
  public boolean is_Constructor() { return true; }
  public dafny.DafnySequence<? extends ConstructorPart> dtor_parts() {
    return this._parts;
  }
}
