// Class BeaconType_SignedBeacon
// Dafny class BeaconType_SignedBeacon compiled into Java
package SearchableEncryptionInfo_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class BeaconType_SignedBeacon extends BeaconType {
  public BeaconType_SignedBeacon () {
    super();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BeaconType_SignedBeacon o = (BeaconType_SignedBeacon)other;
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
    s.append("SearchableEncryptionInfo.BeaconType.SignedBeacon");
    return s.toString();
  }
}
