// Class ValidStandardBeacon
// Dafny class ValidStandardBeacon compiled into Java
package BaseBeacon_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class ValidStandardBeacon {
  public ValidStandardBeacon() {
  }
  private static final dafny.TypeDescriptor<StandardBeacon> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(StandardBeacon.class, () -> StandardBeacon.Default());
  public static dafny.TypeDescriptor<StandardBeacon> _typeDescriptor() {
    return (dafny.TypeDescriptor<StandardBeacon>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
