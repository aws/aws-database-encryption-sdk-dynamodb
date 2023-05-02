// Class Error_AwsCryptographyMaterialProviders
// Dafny class Error_AwsCryptographyMaterialProviders compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class Error_AwsCryptographyMaterialProviders extends Error {
  public Dafny.Aws.Cryptography.MaterialProviders.Types.Error _AwsCryptographyMaterialProviders;
  public Error_AwsCryptographyMaterialProviders (Dafny.Aws.Cryptography.MaterialProviders.Types.Error AwsCryptographyMaterialProviders) {
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
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.Error.AwsCryptographyMaterialProviders");
    s.append("(");
    s.append(dafny.Helpers.toString(this._AwsCryptographyMaterialProviders));
    s.append(")");
    return s.toString();
  }
}
