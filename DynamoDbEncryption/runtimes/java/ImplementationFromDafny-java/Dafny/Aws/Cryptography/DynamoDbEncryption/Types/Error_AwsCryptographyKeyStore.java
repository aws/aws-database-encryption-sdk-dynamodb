// Class Error_AwsCryptographyKeyStore
// Dafny class Error_AwsCryptographyKeyStore compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class Error_AwsCryptographyKeyStore extends Error {
  public Dafny.Aws.Cryptography.KeyStore.Types.Error _AwsCryptographyKeyStore;
  public Error_AwsCryptographyKeyStore (Dafny.Aws.Cryptography.KeyStore.Types.Error AwsCryptographyKeyStore) {
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
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.Error.AwsCryptographyKeyStore");
    s.append("(");
    s.append(dafny.Helpers.toString(this._AwsCryptographyKeyStore));
    s.append(")");
    return s.toString();
  }
}
