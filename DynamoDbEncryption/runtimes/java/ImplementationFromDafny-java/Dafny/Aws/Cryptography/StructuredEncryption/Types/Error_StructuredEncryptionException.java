// Class Error_StructuredEncryptionException
// Dafny class Error_StructuredEncryptionException compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public class Error_StructuredEncryptionException extends Error {
  public dafny.DafnySequence<? extends Character> _message;
  public Error_StructuredEncryptionException (dafny.DafnySequence<? extends Character> message) {
    this._message = message;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Error_StructuredEncryptionException o = (Error_StructuredEncryptionException)other;
    return true && java.util.Objects.equals(this._message, o._message);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._message);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile.Error.StructuredEncryptionException");
    s.append("(");
    s.append(dafny.Helpers.toString(this._message));
    s.append(")");
    return s.toString();
  }
}
