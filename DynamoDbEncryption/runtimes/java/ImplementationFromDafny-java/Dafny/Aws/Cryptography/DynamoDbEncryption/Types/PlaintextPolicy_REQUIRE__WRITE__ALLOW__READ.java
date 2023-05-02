// Class PlaintextPolicy_REQUIRE__WRITE__ALLOW__READ
// Dafny class PlaintextPolicy_REQUIRE__WRITE__ALLOW__READ compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class PlaintextPolicy_REQUIRE__WRITE__ALLOW__READ extends PlaintextPolicy {
  public PlaintextPolicy_REQUIRE__WRITE__ALLOW__READ () {
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    PlaintextPolicy_REQUIRE__WRITE__ALLOW__READ o = (PlaintextPolicy_REQUIRE__WRITE__ALLOW__READ)other;
    return true;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.PlaintextPolicy.REQUIRE_WRITE_ALLOW_READ");
    return s.toString();
  }
}
