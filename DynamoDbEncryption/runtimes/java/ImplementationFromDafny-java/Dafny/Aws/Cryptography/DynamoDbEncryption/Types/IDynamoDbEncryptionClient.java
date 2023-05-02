// Interface IDynamoDbEncryptionClient
// Dafny trait IDynamoDbEncryptionClient compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public interface IDynamoDbEncryptionClient {
  public Wrappers_Compile.Result<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Error> CreateDynamoDbEncryptionBranchKeyIdSupplier(CreateDynamoDbEncryptionBranchKeyIdSupplierInput input);
}
