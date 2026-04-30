// Class DynamoDbEncryptionClient
// Dafny class DynamoDbEncryptionClient compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny;

@SuppressWarnings({"unchecked", "deprecation"})
public class DynamoDbEncryptionClient implements software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient {
  public DynamoDbEncryptionClient() {
    this._config = AwsCryptographyDbEncryptionSdkDynamoDbOperations_Compile.Config.Default();
  }
  public void __ctor(AwsCryptographyDbEncryptionSdkDynamoDbOperations_Compile.Config config)
  {
    (this)._config = config;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> CreateDynamoDbEncryptionBranchKeyIdSupplier(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbOperations_Compile.__default.CreateDynamoDbEncryptionBranchKeyIdSupplier((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetEncryptedDataKeyDescription(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput.Default());
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbOperations_Compile.__default.GetEncryptedDataKeyDescription((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public AwsCryptographyDbEncryptionSdkDynamoDbOperations_Compile.Config _config;
  public AwsCryptographyDbEncryptionSdkDynamoDbOperations_Compile.Config config()
  {
    return this._config;
  }
  private static final dafny.TypeDescriptor<DynamoDbEncryptionClient> _TYPE = dafny.TypeDescriptor.<DynamoDbEncryptionClient>referenceWithInitializer(DynamoDbEncryptionClient.class, () -> (DynamoDbEncryptionClient) null);
  public static dafny.TypeDescriptor<DynamoDbEncryptionClient> _typeDescriptor() {
    return (dafny.TypeDescriptor<DynamoDbEncryptionClient>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDbEncryption.DynamoDbEncryptionClient";
  }
}
