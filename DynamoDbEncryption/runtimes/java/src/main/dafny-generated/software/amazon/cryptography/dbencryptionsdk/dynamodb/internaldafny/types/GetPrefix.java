// Class GetPrefix
// Dafny class GetPrefix compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class GetPrefix {
  public int _length;
  public GetPrefix (int length) {
    this._length = length;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    GetPrefix o = (GetPrefix)other;
    return true && this._length == o._length;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.lang.Integer.hashCode(this._length);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetPrefix.GetPrefix");
    s.append("(");
    s.append(this._length);
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<GetPrefix> _TYPE = dafny.TypeDescriptor.<GetPrefix>referenceWithInitializer(GetPrefix.class, () -> GetPrefix.Default());
  public static dafny.TypeDescriptor<GetPrefix> _typeDescriptor() {
    return (dafny.TypeDescriptor<GetPrefix>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final GetPrefix theDefault = GetPrefix.create(0);
  public static GetPrefix Default() {
    return theDefault;
  }
  public static GetPrefix create(int length) {
    return new GetPrefix(length);
  }
  public static GetPrefix create_GetPrefix(int length) {
    return create(length);
  }
  public boolean is_GetPrefix() { return true; }
  public int dtor_length() {
    return this._length;
  }
}
