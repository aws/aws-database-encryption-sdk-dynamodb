// Class VirtualTransform_segments
// Dafny class VirtualTransform_segments compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class VirtualTransform_segments extends VirtualTransform {
  public GetSegments _segments;
  public VirtualTransform_segments (GetSegments segments) {
    this._segments = segments;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    VirtualTransform_segments o = (VirtualTransform_segments)other;
    return true && java.util.Objects.equals(this._segments, o._segments);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 7;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._segments);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.VirtualTransform.segments");
    s.append("(");
    s.append(dafny.Helpers.toString(this._segments));
    s.append(")");
    return s.toString();
  }
}
