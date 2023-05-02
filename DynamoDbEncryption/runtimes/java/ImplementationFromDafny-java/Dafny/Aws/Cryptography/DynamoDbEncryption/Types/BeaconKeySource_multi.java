// Class BeaconKeySource_multi
// Dafny class BeaconKeySource_multi compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class BeaconKeySource_multi extends BeaconKeySource {
  public MultiKeyStore _multi;
  public BeaconKeySource_multi (MultiKeyStore multi) {
    this._multi = multi;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BeaconKeySource_multi o = (BeaconKeySource_multi)other;
    return true && java.util.Objects.equals(this._multi, o._multi);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 1;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._multi);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.BeaconKeySource.multi");
    s.append("(");
    s.append(dafny.Helpers.toString(this._multi));
    s.append(")");
    return s.toString();
  }
}
