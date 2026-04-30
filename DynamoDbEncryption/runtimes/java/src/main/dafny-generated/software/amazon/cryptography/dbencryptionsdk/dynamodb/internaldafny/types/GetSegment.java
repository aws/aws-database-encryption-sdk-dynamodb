// Class GetSegment
// Dafny class GetSegment compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class GetSegment {
  public dafny.DafnySequence<? extends Character> _split;
  public int _index;
  public GetSegment (dafny.DafnySequence<? extends Character> split, int index) {
    this._split = split;
    this._index = index;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    GetSegment o = (GetSegment)other;
    return true && java.util.Objects.equals(this._split, o._split) && this._index == o._index;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._split);
    hash = ((hash << 5) + hash) + java.lang.Integer.hashCode(this._index);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetSegment.GetSegment");
    s.append("(");
    s.append(dafny.Helpers.toString(this._split));
    s.append(", ");
    s.append(this._index);
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<GetSegment> _TYPE = dafny.TypeDescriptor.<GetSegment>referenceWithInitializer(GetSegment.class, () -> GetSegment.Default());
  public static dafny.TypeDescriptor<GetSegment> _typeDescriptor() {
    return (dafny.TypeDescriptor<GetSegment>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final GetSegment theDefault = GetSegment.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), 0);
  public static GetSegment Default() {
    return theDefault;
  }
  public static GetSegment create(dafny.DafnySequence<? extends Character> split, int index) {
    return new GetSegment(split, index);
  }
  public static GetSegment create_GetSegment(dafny.DafnySequence<? extends Character> split, int index) {
    return create(split, index);
  }
  public boolean is_GetSegment() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_split() {
    return this._split;
  }
  public int dtor_index() {
    return this._index;
  }
}
