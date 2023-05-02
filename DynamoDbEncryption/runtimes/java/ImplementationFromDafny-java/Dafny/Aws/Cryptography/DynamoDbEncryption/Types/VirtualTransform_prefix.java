// Class VirtualTransform_prefix
// Dafny class VirtualTransform_prefix compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class VirtualTransform_prefix extends VirtualTransform {
  public GetPrefix _prefix;
  public VirtualTransform_prefix (GetPrefix prefix) {
    this._prefix = prefix;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    VirtualTransform_prefix o = (VirtualTransform_prefix)other;
    return true && java.util.Objects.equals(this._prefix, o._prefix);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 3;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._prefix);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.VirtualTransform.prefix");
    s.append("(");
    s.append(dafny.Helpers.toString(this._prefix));
    s.append(")");
    return s.toString();
  }
}
