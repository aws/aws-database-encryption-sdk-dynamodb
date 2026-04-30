// Class KeyLocation_LiteralLoc
// Dafny class KeyLocation_LiteralLoc compiled into Java
package SearchableEncryptionInfo_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class KeyLocation_LiteralLoc extends KeyLocation {
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _keys;
  public KeyLocation_LiteralLoc (dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> keys) {
    super();
    this._keys = keys;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    KeyLocation_LiteralLoc o = (KeyLocation_LiteralLoc)other;
    return true && java.util.Objects.equals(this._keys, o._keys);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._keys);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("SearchableEncryptionInfo.KeyLocation.LiteralLoc");
    s.append("(");
    s.append(dafny.Helpers.toString(this._keys));
    s.append(")");
    return s.toString();
  }
}
