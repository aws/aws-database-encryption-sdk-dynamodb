// Class CryptoAction_SIGN__ONLY
// Dafny class CryptoAction_SIGN__ONLY compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public class CryptoAction_SIGN__ONLY extends CryptoAction {
  public CryptoAction_SIGN__ONLY () {
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    CryptoAction_SIGN__ONLY o = (CryptoAction_SIGN__ONLY)other;
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
    s.append("Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile.CryptoAction.SIGN_ONLY");
    return s.toString();
  }
}
