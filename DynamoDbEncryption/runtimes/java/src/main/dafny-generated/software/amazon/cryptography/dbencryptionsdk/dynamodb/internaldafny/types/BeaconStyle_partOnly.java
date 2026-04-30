// Class BeaconStyle_partOnly
// Dafny class BeaconStyle_partOnly compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class BeaconStyle_partOnly extends BeaconStyle {
  public PartOnly _partOnly;
  public BeaconStyle_partOnly (PartOnly partOnly) {
    super();
    this._partOnly = partOnly;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BeaconStyle_partOnly o = (BeaconStyle_partOnly)other;
    return true && java.util.Objects.equals(this._partOnly, o._partOnly);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._partOnly);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconStyle.partOnly");
    s.append("(");
    s.append(dafny.Helpers.toString(this._partOnly));
    s.append(")");
    return s.toString();
  }
}
