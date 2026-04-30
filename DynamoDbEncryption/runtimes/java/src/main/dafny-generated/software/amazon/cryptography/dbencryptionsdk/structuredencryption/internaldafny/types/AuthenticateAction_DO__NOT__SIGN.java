// Class AuthenticateAction_DO__NOT__SIGN
// Dafny class AuthenticateAction_DO__NOT__SIGN compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class AuthenticateAction_DO__NOT__SIGN extends AuthenticateAction {
  public AuthenticateAction_DO__NOT__SIGN () {
    super();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    AuthenticateAction_DO__NOT__SIGN o = (AuthenticateAction_DO__NOT__SIGN)other;
    return true;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 1;
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthenticateAction.DO_NOT_SIGN");
    return s.toString();
  }
}
