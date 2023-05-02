// Class LegacyPolicy_FORBID__ENCRYPT__FORBID__DECRYPT
// Dafny class LegacyPolicy_FORBID__ENCRYPT__FORBID__DECRYPT compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class LegacyPolicy_FORBID__ENCRYPT__FORBID__DECRYPT extends LegacyPolicy {
  public LegacyPolicy_FORBID__ENCRYPT__FORBID__DECRYPT () {
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    LegacyPolicy_FORBID__ENCRYPT__FORBID__DECRYPT o = (LegacyPolicy_FORBID__ENCRYPT__FORBID__DECRYPT)other;
    return true;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 2;
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.LegacyPolicy.FORBID_ENCRYPT_FORBID_DECRYPT");
    return s.toString();
  }
}
