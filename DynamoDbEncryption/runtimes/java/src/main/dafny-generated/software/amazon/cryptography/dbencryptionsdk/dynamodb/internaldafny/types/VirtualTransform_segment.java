// Class VirtualTransform_segment
// Dafny class VirtualTransform_segment compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class VirtualTransform_segment extends VirtualTransform {
  public GetSegment _segment;
  public VirtualTransform_segment (GetSegment segment) {
    super();
    this._segment = segment;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    VirtualTransform_segment o = (VirtualTransform_segment)other;
    return true && java.util.Objects.equals(this._segment, o._segment);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 6;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._segment);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform.segment");
    s.append("(");
    s.append(dafny.Helpers.toString(this._segment));
    s.append(")");
    return s.toString();
  }
}
