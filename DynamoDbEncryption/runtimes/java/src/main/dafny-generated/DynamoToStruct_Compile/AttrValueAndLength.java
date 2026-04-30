// Class AttrValueAndLength
// Dafny class AttrValueAndLength compiled into Java
package DynamoToStruct_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class AttrValueAndLength {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _val;
  public long _len;
  public AttrValueAndLength (software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue val, long len) {
    this._val = val;
    this._len = len;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    AttrValueAndLength o = (AttrValueAndLength)other;
    return true && java.util.Objects.equals(this._val, o._val) && this._len == o._len;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._val);
    hash = ((hash << 5) + hash) + java.lang.Long.hashCode(this._len);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("DynamoToStruct.AttrValueAndLength.AttrValueAndLength");
    s.append("(");
    s.append(dafny.Helpers.toString(this._val));
    s.append(", ");
    s.append(this._len);
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<AttrValueAndLength> _TYPE = dafny.TypeDescriptor.<AttrValueAndLength>referenceWithInitializer(AttrValueAndLength.class, () -> AttrValueAndLength.Default());
  public static dafny.TypeDescriptor<AttrValueAndLength> _typeDescriptor() {
    return (dafny.TypeDescriptor<AttrValueAndLength>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final AttrValueAndLength theDefault = AttrValueAndLength.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.Default(), 0L);
  public static AttrValueAndLength Default() {
    return theDefault;
  }
  public static AttrValueAndLength create(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue val, long len) {
    return new AttrValueAndLength(val, len);
  }
  public static AttrValueAndLength create_AttrValueAndLength(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue val, long len) {
    return create(val, len);
  }
  public boolean is_AttrValueAndLength() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue dtor_val() {
    return this._val;
  }
  public long dtor_len() {
    return this._len;
  }
}
