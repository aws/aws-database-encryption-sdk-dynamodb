// Class AuthenticateAction_SIGN
// Dafny class AuthenticateAction_SIGN compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public class AuthenticateAction_SIGN extends AuthenticateAction {
  public AuthenticateAction_SIGN () {
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    AuthenticateAction_SIGN o = (AuthenticateAction_SIGN)other;
    return true;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile.AuthenticateAction.SIGN");
    return s.toString();
  }
}
