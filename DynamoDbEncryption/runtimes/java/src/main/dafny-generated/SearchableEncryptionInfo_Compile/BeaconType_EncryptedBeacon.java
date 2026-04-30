// Class BeaconType_EncryptedBeacon
// Dafny class BeaconType_EncryptedBeacon compiled into Java
package SearchableEncryptionInfo_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class BeaconType_EncryptedBeacon extends BeaconType {
  public BeaconType_EncryptedBeacon () {
    super();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BeaconType_EncryptedBeacon o = (BeaconType_EncryptedBeacon)other;
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
    s.append("SearchableEncryptionInfo.BeaconType.EncryptedBeacon");
    return s.toString();
  }
}
