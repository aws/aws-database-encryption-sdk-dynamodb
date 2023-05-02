// Class CryptoSchemaContent_Action
// Dafny class CryptoSchemaContent_Action compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public class CryptoSchemaContent_Action extends CryptoSchemaContent {
  public CryptoAction _Action;
  public CryptoSchemaContent_Action (CryptoAction Action) {
    this._Action = Action;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    CryptoSchemaContent_Action o = (CryptoSchemaContent_Action)other;
    return true && java.util.Objects.equals(this._Action, o._Action);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._Action);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile.CryptoSchemaContent.Action");
    s.append("(");
    s.append(dafny.Helpers.toString(this._Action));
    s.append(")");
    return s.toString();
  }
}
