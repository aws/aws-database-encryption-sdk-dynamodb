// Class _ExternBase___default
// Dafny class __default compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class _ExternBase___default {
  public _ExternBase___default() {
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbEncryptionConfig DefaultDynamoDbEncryptionConfig() {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbEncryptionConfig.create();
  }
  public static Wrappers_Compile.Result<DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> DynamoDbEncryption(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbEncryptionConfig config)
  {
    Wrappers_Compile.Result<DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> res = (Wrappers_Compile.Result<DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    AwsCryptographyDbEncryptionSdkDynamoDbOperations_Compile.Config _0_internalConfig;
    _0_internalConfig = AwsCryptographyDbEncryptionSdkDynamoDbOperations_Compile.Config.create();
    DynamoDbEncryptionClient _1_client;
    DynamoDbEncryptionClient _nw0 = new DynamoDbEncryptionClient();
    _nw0.__ctor(_0_internalConfig);
    _1_client = _nw0;
    res = Wrappers_Compile.Result.<DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(((dafny.TypeDescriptor<DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), _1_client);
    return res;
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> CreateSuccessOfClient(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient client) {
    return Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), client);
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> CreateFailureOfError(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error error) {
    return Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), error);
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDbEncryption._default";
  }
}
