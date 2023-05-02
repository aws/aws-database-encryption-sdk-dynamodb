// Class CryptoAction_DO__NOTHING
// Dafny class CryptoAction_DO__NOTHING compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public class CryptoAction_DO__NOTHING extends CryptoAction {
  public CryptoAction_DO__NOTHING () {
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    CryptoAction_DO__NOTHING o = (CryptoAction_DO__NOTHING)other;
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
    s.append("Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile.CryptoAction.DO_NOTHING");
    return s.toString();
  }
}
