// Class AuthenticateAction
// Dafny class AuthenticateAction compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class AuthenticateAction {
  public AuthenticateAction() {
  }
  private static final dafny.TypeDescriptor<AuthenticateAction> _TYPE = dafny.TypeDescriptor.<AuthenticateAction>referenceWithInitializer(AuthenticateAction.class, () -> AuthenticateAction.Default());
  public static dafny.TypeDescriptor<AuthenticateAction> _typeDescriptor() {
    return (dafny.TypeDescriptor<AuthenticateAction>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final AuthenticateAction theDefault = AuthenticateAction.create_SIGN();
  public static AuthenticateAction Default() {
    return theDefault;
  }
  public static AuthenticateAction create_SIGN() {
    return new AuthenticateAction_SIGN();
  }
  public static AuthenticateAction create_DO__NOT__SIGN() {
    return new AuthenticateAction_DO__NOT__SIGN();
  }
  public boolean is_SIGN() { return this instanceof AuthenticateAction_SIGN; }
  public boolean is_DO__NOT__SIGN() { return this instanceof AuthenticateAction_DO__NOT__SIGN; }
  public static java.util.ArrayList<AuthenticateAction> AllSingletonConstructors() {
    java.util.ArrayList<AuthenticateAction> singleton_iterator = new java.util.ArrayList<>();
    singleton_iterator.add(new AuthenticateAction_SIGN());
    singleton_iterator.add(new AuthenticateAction_DO__NOT__SIGN());
    return singleton_iterator;
  }
}
