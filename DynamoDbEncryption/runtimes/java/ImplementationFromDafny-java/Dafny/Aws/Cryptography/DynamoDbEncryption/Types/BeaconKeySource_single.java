// Class BeaconKeySource_single
// Dafny class BeaconKeySource_single compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class BeaconKeySource_single extends BeaconKeySource {
  public SingleKeyStore _single;
  public BeaconKeySource_single (SingleKeyStore single) {
    this._single = single;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BeaconKeySource_single o = (BeaconKeySource_single)other;
    return true && java.util.Objects.equals(this._single, o._single);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._single);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.BeaconKeySource.single");
    s.append("(");
    s.append(dafny.Helpers.toString(this._single));
    s.append(")");
    return s.toString();
  }
}
