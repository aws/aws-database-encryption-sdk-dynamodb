// Class Error_AwsCryptographyMaterialProviders
// Dafny class Error_AwsCryptographyMaterialProviders compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class Error_AwsCryptographyMaterialProviders extends Error {
  public software.amazon.cryptography.materialproviders.internaldafny.types.Error _AwsCryptographyMaterialProviders;
  public Error_AwsCryptographyMaterialProviders (software.amazon.cryptography.materialproviders.internaldafny.types.Error AwsCryptographyMaterialProviders) {
    super();
    this._AwsCryptographyMaterialProviders = AwsCryptographyMaterialProviders;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Error_AwsCryptographyMaterialProviders o = (Error_AwsCryptographyMaterialProviders)other;
    return true && java.util.Objects.equals(this._AwsCryptographyMaterialProviders, o._AwsCryptographyMaterialProviders);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 2;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._AwsCryptographyMaterialProviders);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error.AwsCryptographyMaterialProviders");
    s.append("(");
    s.append(dafny.Helpers.toString(this._AwsCryptographyMaterialProviders));
    s.append(")");
    return s.toString();
  }
}
