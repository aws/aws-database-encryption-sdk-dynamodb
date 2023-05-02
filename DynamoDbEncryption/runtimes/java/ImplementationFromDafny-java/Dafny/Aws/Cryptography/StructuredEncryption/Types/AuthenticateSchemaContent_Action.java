// Class AuthenticateSchemaContent_Action
// Dafny class AuthenticateSchemaContent_Action compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public class AuthenticateSchemaContent_Action extends AuthenticateSchemaContent {
  public AuthenticateAction _Action;
  public AuthenticateSchemaContent_Action (AuthenticateAction Action) {
    this._Action = Action;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    AuthenticateSchemaContent_Action o = (AuthenticateSchemaContent_Action)other;
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
    s.append("Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile.AuthenticateSchemaContent.Action");
    s.append("(");
    s.append(dafny.Helpers.toString(this._Action));
    s.append(")");
    return s.toString();
  }
}
