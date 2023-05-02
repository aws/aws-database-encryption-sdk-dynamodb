// Class Error_AwsCryptographyDynamoDbEncryption
// Dafny class Error_AwsCryptographyDynamoDbEncryption compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types;

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
import SearchableEncryptionInfo_Compile.*;
import SearchConfigToInfo_Compile.*;
import DynamoDbUpdateExpr_Compile.*;
import DynamoDBFilterExpr_Compile.*;
import DynamoDBIndexSupport_Compile.*;
import DynamoDBSupport_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class Error_AwsCryptographyDynamoDbEncryption extends Error {
  public Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error _AwsCryptographyDynamoDbEncryption;
  public Error_AwsCryptographyDynamoDbEncryption (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error AwsCryptographyDynamoDbEncryption) {
    this._AwsCryptographyDynamoDbEncryption = AwsCryptographyDynamoDbEncryption;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Error_AwsCryptographyDynamoDbEncryption o = (Error_AwsCryptographyDynamoDbEncryption)other;
    return true && java.util.Objects.equals(this._AwsCryptographyDynamoDbEncryption, o._AwsCryptographyDynamoDbEncryption);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 1;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._AwsCryptographyDynamoDbEncryption);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.Error.AwsCryptographyDynamoDbEncryption");
    s.append("(");
    s.append(dafny.Helpers.toString(this._AwsCryptographyDynamoDbEncryption));
    s.append(")");
    return s.toString();
  }
}
