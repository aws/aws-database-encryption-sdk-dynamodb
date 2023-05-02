// Class CryptoSchemaActionType
// Dafny class CryptoSchemaActionType compiled into Java
package StructuredEncryptionUtil_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;
import DynamoDbEncryptionUtil_Compile.*;
import DynamoDbNormalizeNumber_Compile.*;
import DynamoToStruct_Compile.*;
import DynamoDbEncryptionBranchKeyIdSupplier_Compile.*;
import AwsCryptographyDynamoDbEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class CryptoSchemaActionType {
  public CryptoSchemaActionType() {
  }
  private static final dafny.TypeDescriptor<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema.class, () -> Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema.Default());
  public static dafny.TypeDescriptor<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> _typeDescriptor() {
    return (dafny.TypeDescriptor<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
