// Class AuthSchemaActionType
// Dafny class AuthSchemaActionType compiled into Java
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
public class AuthSchemaActionType {
  public AuthSchemaActionType() {
  }
  private static final dafny.TypeDescriptor<Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema.class, () -> Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema.Default());
  public static dafny.TypeDescriptor<Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema> _typeDescriptor() {
    return (dafny.TypeDescriptor<Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
