// Class CMPEncryptedDataKeyListEmptyOK
// Dafny class CMPEncryptedDataKeyListEmptyOK compiled into Java
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
public class CMPEncryptedDataKeyListEmptyOK {
  public CMPEncryptedDataKeyListEmptyOK() {
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> empty(CMPEncryptedDataKey._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
