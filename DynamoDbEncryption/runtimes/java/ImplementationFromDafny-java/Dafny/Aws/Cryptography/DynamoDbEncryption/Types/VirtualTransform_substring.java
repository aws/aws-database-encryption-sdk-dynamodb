// Class VirtualTransform_substring
// Dafny class VirtualTransform_substring compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class VirtualTransform_substring extends VirtualTransform {
  public GetSubstring _substring;
  public VirtualTransform_substring (GetSubstring substring) {
    this._substring = substring;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    VirtualTransform_substring o = (VirtualTransform_substring)other;
    return true && java.util.Objects.equals(this._substring, o._substring);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 5;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._substring);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.VirtualTransform.substring");
    s.append("(");
    s.append(dafny.Helpers.toString(this._substring));
    s.append(")");
    return s.toString();
  }
}
