// Interface IDynamoDbKeyBranchKeyIdSupplier
// Dafny trait IDynamoDbKeyBranchKeyIdSupplier compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public interface IDynamoDbKeyBranchKeyIdSupplier {
  public Wrappers_Compile.Result<GetBranchKeyIdFromDdbKeyOutput, Error> GetBranchKeyIdFromDdbKey(GetBranchKeyIdFromDdbKeyInput input);
  public Wrappers_Compile.Result<GetBranchKeyIdFromDdbKeyOutput, Error> GetBranchKeyIdFromDdbKey_k(GetBranchKeyIdFromDdbKeyInput input);
}
