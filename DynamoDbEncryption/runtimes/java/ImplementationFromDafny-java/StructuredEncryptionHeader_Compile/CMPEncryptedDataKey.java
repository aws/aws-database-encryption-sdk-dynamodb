// Class CMPEncryptedDataKey
// Dafny class CMPEncryptedDataKey compiled into Java
package StructuredEncryptionHeader_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class CMPEncryptedDataKey {
  public CMPEncryptedDataKey() {
  }
  private static final dafny.TypeDescriptor<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey.class, () -> Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey.Default());
  public static dafny.TypeDescriptor<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> _typeDescriptor() {
    return (dafny.TypeDescriptor<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
