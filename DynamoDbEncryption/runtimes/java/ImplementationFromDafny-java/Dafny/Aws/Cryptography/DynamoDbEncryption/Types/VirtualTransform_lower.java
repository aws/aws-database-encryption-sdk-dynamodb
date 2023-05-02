// Class VirtualTransform_lower
// Dafny class VirtualTransform_lower compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class VirtualTransform_lower extends VirtualTransform {
  public Lower _lower;
  public VirtualTransform_lower (Lower lower) {
    this._lower = lower;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    VirtualTransform_lower o = (VirtualTransform_lower)other;
    return true && java.util.Objects.equals(this._lower, o._lower);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 1;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._lower);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.VirtualTransform.lower");
    s.append("(");
    s.append(dafny.Helpers.toString(this._lower));
    s.append(")");
    return s.toString();
  }
}
