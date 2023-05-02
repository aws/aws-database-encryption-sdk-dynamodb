// Class VirtualTransform_suffix
// Dafny class VirtualTransform_suffix compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class VirtualTransform_suffix extends VirtualTransform {
  public GetSuffix _suffix;
  public VirtualTransform_suffix (GetSuffix suffix) {
    this._suffix = suffix;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    VirtualTransform_suffix o = (VirtualTransform_suffix)other;
    return true && java.util.Objects.equals(this._suffix, o._suffix);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 4;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._suffix);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.VirtualTransform.suffix");
    s.append("(");
    s.append(dafny.Helpers.toString(this._suffix));
    s.append(")");
    return s.toString();
  }
}
