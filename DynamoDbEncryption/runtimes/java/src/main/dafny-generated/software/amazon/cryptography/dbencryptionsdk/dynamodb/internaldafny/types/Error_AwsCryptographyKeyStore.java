// Class Error_AwsCryptographyKeyStore
// Dafny class Error_AwsCryptographyKeyStore compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class Error_AwsCryptographyKeyStore extends Error {
  public software.amazon.cryptography.keystore.internaldafny.types.Error _AwsCryptographyKeyStore;
  public Error_AwsCryptographyKeyStore (software.amazon.cryptography.keystore.internaldafny.types.Error AwsCryptographyKeyStore) {
    super();
    this._AwsCryptographyKeyStore = AwsCryptographyKeyStore;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Error_AwsCryptographyKeyStore o = (Error_AwsCryptographyKeyStore)other;
    return true && java.util.Objects.equals(this._AwsCryptographyKeyStore, o._AwsCryptographyKeyStore);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 3;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._AwsCryptographyKeyStore);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error.AwsCryptographyKeyStore");
    s.append("(");
    s.append(dafny.Helpers.toString(this._AwsCryptographyKeyStore));
    s.append(")");
    return s.toString();
  }
}
