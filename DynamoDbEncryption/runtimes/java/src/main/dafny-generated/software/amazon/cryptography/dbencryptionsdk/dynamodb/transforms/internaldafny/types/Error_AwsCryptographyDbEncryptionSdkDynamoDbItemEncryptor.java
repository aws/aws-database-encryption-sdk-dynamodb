// Class Error_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor
// Dafny class Error_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class Error_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor extends Error {
  public software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error _AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor;
  public Error_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor (software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor) {
    super();
    this._AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Error_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor o = (Error_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor)other;
    return true && java.util.Objects.equals(this._AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor, o._AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 2;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor");
    s.append("(");
    s.append(dafny.Helpers.toString(this._AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor));
    s.append(")");
    return s.toString();
  }
}
