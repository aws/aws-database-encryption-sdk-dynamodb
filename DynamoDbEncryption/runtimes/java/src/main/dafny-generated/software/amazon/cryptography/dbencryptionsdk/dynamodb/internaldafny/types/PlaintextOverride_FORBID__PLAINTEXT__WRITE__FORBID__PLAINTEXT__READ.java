// Class PlaintextOverride_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ
// Dafny class PlaintextOverride_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class PlaintextOverride_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ extends PlaintextOverride {
  public PlaintextOverride_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ () {
    super();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    PlaintextOverride_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ o = (PlaintextOverride_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.PlaintextOverride.FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ");
    return s.toString();
  }
}
