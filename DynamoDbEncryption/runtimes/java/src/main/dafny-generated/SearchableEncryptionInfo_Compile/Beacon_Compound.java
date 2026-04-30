// Class Beacon_Compound
// Dafny class Beacon_Compound compiled into Java
package SearchableEncryptionInfo_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class Beacon_Compound extends Beacon {
  public CompoundBeacon_Compile.CompoundBeacon _cmp;
  public Beacon_Compound (CompoundBeacon_Compile.CompoundBeacon cmp) {
    super();
    this._cmp = cmp;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Beacon_Compound o = (Beacon_Compound)other;
    return true && java.util.Objects.equals(this._cmp, o._cmp);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 1;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._cmp);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("SearchableEncryptionInfo.Beacon.Compound");
    s.append("(");
    s.append(dafny.Helpers.toString(this._cmp));
    s.append(")");
    return s.toString();
  }
}
