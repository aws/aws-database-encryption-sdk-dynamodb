// Class Error_AwsCryptographyPrimitives
// Dafny class Error_AwsCryptographyPrimitives compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class Error_AwsCryptographyPrimitives extends Error {
  public Dafny.Aws.Cryptography.Primitives.Types.Error _AwsCryptographyPrimitives;
  public Error_AwsCryptographyPrimitives (Dafny.Aws.Cryptography.Primitives.Types.Error AwsCryptographyPrimitives) {
    this._AwsCryptographyPrimitives = AwsCryptographyPrimitives;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Error_AwsCryptographyPrimitives o = (Error_AwsCryptographyPrimitives)other;
    return true && java.util.Objects.equals(this._AwsCryptographyPrimitives, o._AwsCryptographyPrimitives);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 4;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._AwsCryptographyPrimitives);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.Error.AwsCryptographyPrimitives");
    s.append("(");
    s.append(dafny.Helpers.toString(this._AwsCryptographyPrimitives));
    s.append(")");
    return s.toString();
  }
}
