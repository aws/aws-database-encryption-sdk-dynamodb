// Class BeaconPart_Sensitive
// Dafny class BeaconPart_Sensitive compiled into Java
package CompoundBeacon_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;
import DynamoDbEncryptionUtil_Compile.*;
import DynamoDbNormalizeNumber_Compile.*;
import DynamoToStruct_Compile.*;
import DynamoDbEncryptionBranchKeyIdSupplier_Compile.*;
import AwsCryptographyDynamoDbEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.*;
import StructuredEncryptionUtil_Compile.*;
import Sets_Compile.*;
import StructuredEncryptionPaths_Compile.*;
import StructuredEncryptionHeader_Compile.*;
import StructuredEncryptionFooter_Compile.*;
import StructuredEncryptionCrypt_Compile.*;
import Maps_Compile.*;
import AwsCryptographyStructuredEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.StructuredEncryption.*;
import TermLoc_Compile.*;
import DdbVirtualFields_Compile.*;
import BaseBeacon_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class BeaconPart_Sensitive extends BeaconPart {
  public dafny.DafnySequence<? extends Character> _prefix;
  public BaseBeacon_Compile.StandardBeacon _beacon;
  public BeaconPart_Sensitive (dafny.DafnySequence<? extends Character> prefix, BaseBeacon_Compile.StandardBeacon beacon) {
    this._prefix = prefix;
    this._beacon = beacon;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BeaconPart_Sensitive o = (BeaconPart_Sensitive)other;
    return true && java.util.Objects.equals(this._prefix, o._prefix) && java.util.Objects.equals(this._beacon, o._beacon);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._prefix);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._beacon);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("CompoundBeacon_Compile.BeaconPart.Sensitive");
    s.append("(");
    s.append(dafny.Helpers.toString(this._prefix));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._beacon));
    s.append(")");
    return s.toString();
  }
}
