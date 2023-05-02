// Class Error_AwsCryptographyStructuredEncryption
// Dafny class Error_AwsCryptographyStructuredEncryption compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class Error_AwsCryptographyStructuredEncryption extends Error {
  public Dafny.Aws.Cryptography.StructuredEncryption.Types.Error _AwsCryptographyStructuredEncryption;
  public Error_AwsCryptographyStructuredEncryption (Dafny.Aws.Cryptography.StructuredEncryption.Types.Error AwsCryptographyStructuredEncryption) {
    this._AwsCryptographyStructuredEncryption = AwsCryptographyStructuredEncryption;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Error_AwsCryptographyStructuredEncryption o = (Error_AwsCryptographyStructuredEncryption)other;
    return true && java.util.Objects.equals(this._AwsCryptographyStructuredEncryption, o._AwsCryptographyStructuredEncryption);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 1;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._AwsCryptographyStructuredEncryption);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.Error.AwsCryptographyStructuredEncryption");
    s.append("(");
    s.append(dafny.Helpers.toString(this._AwsCryptographyStructuredEncryption));
    s.append(")");
    return s.toString();
  }
}
