// Class KeyLocation_MultiLoc
// Dafny class KeyLocation_MultiLoc compiled into Java
package SearchableEncryptionInfo_Compile;

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
import CompoundBeacon_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class KeyLocation_MultiLoc extends KeyLocation {
  public dafny.DafnySequence<? extends Character> _keyName;
  public boolean _deleteKey;
  public KeyLocation_MultiLoc (dafny.DafnySequence<? extends Character> keyName, boolean deleteKey) {
    this._keyName = keyName;
    this._deleteKey = deleteKey;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    KeyLocation_MultiLoc o = (KeyLocation_MultiLoc)other;
    return true && java.util.Objects.equals(this._keyName, o._keyName) && this._deleteKey == o._deleteKey;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 2;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._keyName);
    hash = ((hash << 5) + hash) + Boolean.hashCode(this._deleteKey);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("SearchableEncryptionInfo_Compile.KeyLocation.MultiLoc");
    s.append("(");
    s.append(dafny.Helpers.toString(this._keyName));
    s.append(", ");
    s.append(this._deleteKey);
    s.append(")");
    return s.toString();
  }
}
