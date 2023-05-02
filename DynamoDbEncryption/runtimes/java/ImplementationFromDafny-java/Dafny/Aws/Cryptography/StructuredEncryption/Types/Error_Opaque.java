// Class Error_Opaque
// Dafny class Error_Opaque compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public class Error_Opaque extends Error {
  public Object _obj;
  public Error_Opaque (Object obj) {
    this._obj = obj;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Error_Opaque o = (Error_Opaque)other;
    return true && this._obj == o._obj;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 4;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._obj);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile.Error.Opaque");
    s.append("(");
    s.append(dafny.Helpers.toString(this._obj));
    s.append(")");
    return s.toString();
  }
}
