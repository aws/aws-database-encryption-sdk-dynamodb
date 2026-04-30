// Class Error_AwsCryptographyPrimitives
// Dafny class Error_AwsCryptographyPrimitives compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class Error_AwsCryptographyPrimitives extends Error {
  public software.amazon.cryptography.primitives.internaldafny.types.Error _AwsCryptographyPrimitives;
  public Error_AwsCryptographyPrimitives (software.amazon.cryptography.primitives.internaldafny.types.Error AwsCryptographyPrimitives) {
    super();
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
    hash = ((hash << 5) + hash) + 2;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._AwsCryptographyPrimitives);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error.AwsCryptographyPrimitives");
    s.append("(");
    s.append(dafny.Helpers.toString(this._AwsCryptographyPrimitives));
    s.append(")");
    return s.toString();
  }
}
