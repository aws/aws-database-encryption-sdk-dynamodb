// Class EncryptionSelector_DoEncrypt
// Dafny class EncryptionSelector_DoEncrypt compiled into Java
package Canonize_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class EncryptionSelector_DoEncrypt extends EncryptionSelector {
  public EncryptionSelector_DoEncrypt () {
    super();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    EncryptionSelector_DoEncrypt o = (EncryptionSelector_DoEncrypt)other;
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
    s.append("Canonize.EncryptionSelector.DoEncrypt");
    return s.toString();
  }
}
