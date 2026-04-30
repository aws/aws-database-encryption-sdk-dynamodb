// Class CryptoAction_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT
// Dafny class CryptoAction_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class CryptoAction_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT extends CryptoAction {
  public CryptoAction_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT () {
    super();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    CryptoAction_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT o = (CryptoAction_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT)other;
    return true;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 1;
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT");
    return s.toString();
  }
}
