// Class Error_AwsCryptographyDynamoDbEncryptionItemEncryptor
// Dafny class Error_AwsCryptographyDynamoDbEncryptionItemEncryptor compiled into Java
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
public class Error_AwsCryptographyDynamoDbEncryptionItemEncryptor extends Error {
  public Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error _AwsCryptographyDynamoDbEncryptionItemEncryptor;
  public Error_AwsCryptographyDynamoDbEncryptionItemEncryptor (Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error AwsCryptographyDynamoDbEncryptionItemEncryptor) {
    this._AwsCryptographyDynamoDbEncryptionItemEncryptor = AwsCryptographyDynamoDbEncryptionItemEncryptor;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Error_AwsCryptographyDynamoDbEncryptionItemEncryptor o = (Error_AwsCryptographyDynamoDbEncryptionItemEncryptor)other;
    return true && java.util.Objects.equals(this._AwsCryptographyDynamoDbEncryptionItemEncryptor, o._AwsCryptographyDynamoDbEncryptionItemEncryptor);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 2;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._AwsCryptographyDynamoDbEncryptionItemEncryptor);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.Error.AwsCryptographyDynamoDbEncryptionItemEncryptor");
    s.append("(");
    s.append(dafny.Helpers.toString(this._AwsCryptographyDynamoDbEncryptionItemEncryptor));
    s.append(")");
    return s.toString();
  }
}
