// Class VirtualTransform_insert
// Dafny class VirtualTransform_insert compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class VirtualTransform_insert extends VirtualTransform {
  public Insert _insert;
  public VirtualTransform_insert (Insert insert) {
    this._insert = insert;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    VirtualTransform_insert o = (VirtualTransform_insert)other;
    return true && java.util.Objects.equals(this._insert, o._insert);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 2;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._insert);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.VirtualTransform.insert");
    s.append("(");
    s.append(dafny.Helpers.toString(this._insert));
    s.append(")");
    return s.toString();
  }
}
