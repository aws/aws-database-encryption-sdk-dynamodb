// Class BeaconStyle_shared
// Dafny class BeaconStyle_shared compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class BeaconStyle_shared extends BeaconStyle {
  public Shared _shared;
  public BeaconStyle_shared (Shared shared) {
    super();
    this._shared = shared;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BeaconStyle_shared o = (BeaconStyle_shared)other;
    return true && java.util.Objects.equals(this._shared, o._shared);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 1;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._shared);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconStyle.shared");
    s.append("(");
    s.append(dafny.Helpers.toString(this._shared));
    s.append(")");
    return s.toString();
  }
}
