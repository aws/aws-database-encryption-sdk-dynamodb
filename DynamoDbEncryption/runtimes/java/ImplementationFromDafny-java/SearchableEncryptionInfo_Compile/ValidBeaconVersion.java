// Class ValidBeaconVersion
// Dafny class ValidBeaconVersion compiled into Java
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
public class ValidBeaconVersion {
  public ValidBeaconVersion() {
  }
  private static final dafny.TypeDescriptor<BeaconVersion> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(BeaconVersion.class, () -> BeaconVersion.Default());
  public static dafny.TypeDescriptor<BeaconVersion> _typeDescriptor() {
    return (dafny.TypeDescriptor<BeaconVersion>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
