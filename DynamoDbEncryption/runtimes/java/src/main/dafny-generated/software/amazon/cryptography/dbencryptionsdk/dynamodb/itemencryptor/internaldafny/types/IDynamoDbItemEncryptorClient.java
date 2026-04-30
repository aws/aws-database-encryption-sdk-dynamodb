// Interface IDynamoDbItemEncryptorClient
// Dafny trait IDynamoDbItemEncryptorClient compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public interface IDynamoDbItemEncryptorClient {
  public Wrappers_Compile.Result<EncryptItemOutput, Error> EncryptItem(EncryptItemInput input);
  public Wrappers_Compile.Result<DecryptItemOutput, Error> DecryptItem(DecryptItemInput input);
}
