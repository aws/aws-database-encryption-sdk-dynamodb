// Class DynamoDbItemEncryptorClient
// Dafny class DynamoDbItemEncryptorClient compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny;

@SuppressWarnings({"unchecked", "deprecation"})
public class DynamoDbItemEncryptorClient implements software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.IDynamoDbItemEncryptorClient {
  public DynamoDbItemEncryptorClient() {
    this._config = (AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations_Compile.Config)null;
  }
  public void __ctor(AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations_Compile.Config config)
  {
    (this)._config = config;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> EncryptItem(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput.Default());
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations_Compile.__default.EncryptItem((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> DecryptItem(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput.Default());
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations_Compile.__default.DecryptItem((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations_Compile.Config _config;
  public AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations_Compile.Config config()
  {
    return this._config;
  }
  private static final dafny.TypeDescriptor<DynamoDbItemEncryptorClient> _TYPE = dafny.TypeDescriptor.<DynamoDbItemEncryptorClient>referenceWithInitializer(DynamoDbItemEncryptorClient.class, () -> (DynamoDbItemEncryptorClient) null);
  public static dafny.TypeDescriptor<DynamoDbItemEncryptorClient> _typeDescriptor() {
    return (dafny.TypeDescriptor<DynamoDbItemEncryptorClient>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDbItemEncryptor.DynamoDbItemEncryptorClient";
  }
}
