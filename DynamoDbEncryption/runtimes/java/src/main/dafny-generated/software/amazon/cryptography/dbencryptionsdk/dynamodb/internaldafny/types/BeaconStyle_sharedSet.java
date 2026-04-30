// Class BeaconStyle_sharedSet
// Dafny class BeaconStyle_sharedSet compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class BeaconStyle_sharedSet extends BeaconStyle {
  public SharedSet _sharedSet;
  public BeaconStyle_sharedSet (SharedSet sharedSet) {
    super();
    this._sharedSet = sharedSet;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BeaconStyle_sharedSet o = (BeaconStyle_sharedSet)other;
    return true && java.util.Objects.equals(this._sharedSet, o._sharedSet);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 3;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._sharedSet);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconStyle.sharedSet");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sharedSet));
    s.append(")");
    return s.toString();
  }
}
