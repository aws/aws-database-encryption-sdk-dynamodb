// Class Error_AwsCryptographyDbEncryptionSdkDynamoDb
// Dafny class Error_AwsCryptographyDbEncryptionSdkDynamoDb compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class Error_AwsCryptographyDbEncryptionSdkDynamoDb extends Error {
  public software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error _AwsCryptographyDbEncryptionSdkDynamoDb;
  public Error_AwsCryptographyDbEncryptionSdkDynamoDb (software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error AwsCryptographyDbEncryptionSdkDynamoDb) {
    super();
    this._AwsCryptographyDbEncryptionSdkDynamoDb = AwsCryptographyDbEncryptionSdkDynamoDb;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Error_AwsCryptographyDbEncryptionSdkDynamoDb o = (Error_AwsCryptographyDbEncryptionSdkDynamoDb)other;
    return true && java.util.Objects.equals(this._AwsCryptographyDbEncryptionSdkDynamoDb, o._AwsCryptographyDbEncryptionSdkDynamoDb);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 1;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._AwsCryptographyDbEncryptionSdkDynamoDb);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.AwsCryptographyDbEncryptionSdkDynamoDb");
    s.append("(");
    s.append(dafny.Helpers.toString(this._AwsCryptographyDbEncryptionSdkDynamoDb));
    s.append(")");
    return s.toString();
  }
}
