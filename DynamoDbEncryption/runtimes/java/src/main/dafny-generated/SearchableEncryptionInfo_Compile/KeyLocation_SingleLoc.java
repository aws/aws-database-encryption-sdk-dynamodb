// Class KeyLocation_SingleLoc
// Dafny class KeyLocation_SingleLoc compiled into Java
package SearchableEncryptionInfo_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class KeyLocation_SingleLoc extends KeyLocation {
  public dafny.DafnySequence<? extends Character> _keyId;
  public KeyLocation_SingleLoc (dafny.DafnySequence<? extends Character> keyId) {
    super();
    this._keyId = keyId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    KeyLocation_SingleLoc o = (KeyLocation_SingleLoc)other;
    return true && java.util.Objects.equals(this._keyId, o._keyId);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 1;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._keyId);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("SearchableEncryptionInfo.KeyLocation.SingleLoc");
    s.append("(");
    s.append(dafny.Helpers.toString(this._keyId));
    s.append(")");
    return s.toString();
  }
}
