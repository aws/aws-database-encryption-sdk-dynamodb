// Class LegacyPolicy_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT
// Dafny class LegacyPolicy_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class LegacyPolicy_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT extends LegacyPolicy {
  public LegacyPolicy_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT () {
    super();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    LegacyPolicy_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT o = (LegacyPolicy_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.LegacyPolicy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT");
    return s.toString();
  }
}
