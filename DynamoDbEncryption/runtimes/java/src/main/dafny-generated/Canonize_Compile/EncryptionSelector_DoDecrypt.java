// Class EncryptionSelector_DoDecrypt
// Dafny class EncryptionSelector_DoDecrypt compiled into Java
package Canonize_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class EncryptionSelector_DoDecrypt extends EncryptionSelector {
  public EncryptionSelector_DoDecrypt () {
    super();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    EncryptionSelector_DoDecrypt o = (EncryptionSelector_DoDecrypt)other;
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
    s.append("Canonize.EncryptionSelector.DoDecrypt");
    return s.toString();
  }
}
