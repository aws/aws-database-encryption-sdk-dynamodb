// Interface IDynamoDbKeyBranchKeyIdSupplier
// Dafny trait IDynamoDbKeyBranchKeyIdSupplier compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public interface IDynamoDbKeyBranchKeyIdSupplier {
  public Wrappers_Compile.Result<GetBranchKeyIdFromDdbKeyOutput, Error> GetBranchKeyIdFromDdbKey(GetBranchKeyIdFromDdbKeyInput input);
  public Wrappers_Compile.Result<GetBranchKeyIdFromDdbKeyOutput, Error> GetBranchKeyIdFromDdbKey_k(GetBranchKeyIdFromDdbKeyInput input);
}
