// Class EncryptCanon
// Dafny class EncryptCanon compiled into Java
package AwsCryptographyStructuredEncryptionOperations_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class EncryptCanon {
  public EncryptCanon() {
  }
  private static final dafny.TypeDescriptor<EncryptCanonData> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(EncryptCanonData.class, () -> EncryptCanonData.Default());
  public static dafny.TypeDescriptor<EncryptCanonData> _typeDescriptor() {
    return (dafny.TypeDescriptor<EncryptCanonData>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
