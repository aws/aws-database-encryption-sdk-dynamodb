// Class DecryptCanon
// Dafny class DecryptCanon compiled into Java
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
public class DecryptCanon {
  public DecryptCanon() {
  }
  private static final dafny.TypeDescriptor<DecryptCanonData> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(DecryptCanonData.class, () -> DecryptCanonData.Default());
  public static dafny.TypeDescriptor<DecryptCanonData> _typeDescriptor() {
    return (dafny.TypeDescriptor<DecryptCanonData>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
