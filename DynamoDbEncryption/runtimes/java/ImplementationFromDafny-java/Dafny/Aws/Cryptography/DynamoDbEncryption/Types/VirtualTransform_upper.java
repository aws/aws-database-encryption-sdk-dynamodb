// Class VirtualTransform_upper
// Dafny class VirtualTransform_upper compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class VirtualTransform_upper extends VirtualTransform {
  public Upper _upper;
  public VirtualTransform_upper (Upper upper) {
    this._upper = upper;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    VirtualTransform_upper o = (VirtualTransform_upper)other;
    return true && java.util.Objects.equals(this._upper, o._upper);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._upper);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.VirtualTransform.upper");
    s.append("(");
    s.append(dafny.Helpers.toString(this._upper));
    s.append(")");
    return s.toString();
  }
}
