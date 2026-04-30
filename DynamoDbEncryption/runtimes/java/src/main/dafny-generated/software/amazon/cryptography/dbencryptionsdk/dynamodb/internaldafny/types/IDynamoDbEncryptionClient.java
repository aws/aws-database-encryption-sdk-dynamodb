// Interface IDynamoDbEncryptionClient
// Dafny trait IDynamoDbEncryptionClient compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public interface IDynamoDbEncryptionClient {
  public Wrappers_Compile.Result<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Error> CreateDynamoDbEncryptionBranchKeyIdSupplier(CreateDynamoDbEncryptionBranchKeyIdSupplierInput input);
  public Wrappers_Compile.Result<GetEncryptedDataKeyDescriptionOutput, Error> GetEncryptedDataKeyDescription(GetEncryptedDataKeyDescriptionInput input);
}
