// Class BeaconType_AnyBeacon
// Dafny class BeaconType_AnyBeacon compiled into Java
package SearchableEncryptionInfo_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class BeaconType_AnyBeacon extends BeaconType {
  public BeaconType_AnyBeacon () {
    super();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BeaconType_AnyBeacon o = (BeaconType_AnyBeacon)other;
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
    s.append("SearchableEncryptionInfo.BeaconType.AnyBeacon");
    return s.toString();
  }
}
