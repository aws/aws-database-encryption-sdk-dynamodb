// Class ValidStore
// Dafny class ValidStore compiled into Java
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
public class ValidStore {
  public ValidStore() {
  }
  private static final dafny.TypeDescriptor<Dafny.Aws.Cryptography.KeyStore.Types.IKeyStoreClient> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(Dafny.Aws.Cryptography.KeyStore.Types.IKeyStoreClient.class, () -> null);
  public static dafny.TypeDescriptor<Dafny.Aws.Cryptography.KeyStore.Types.IKeyStoreClient> _typeDescriptor() {
    return (dafny.TypeDescriptor<Dafny.Aws.Cryptography.KeyStore.Types.IKeyStoreClient>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
