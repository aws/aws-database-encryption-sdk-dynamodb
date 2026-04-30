// Class CryptoAction
// Dafny class CryptoAction compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class CryptoAction {
  public CryptoAction() {
  }
  private static final dafny.TypeDescriptor<CryptoAction> _TYPE = dafny.TypeDescriptor.<CryptoAction>referenceWithInitializer(CryptoAction.class, () -> CryptoAction.Default());
  public static dafny.TypeDescriptor<CryptoAction> _typeDescriptor() {
    return (dafny.TypeDescriptor<CryptoAction>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final CryptoAction theDefault = CryptoAction.create_ENCRYPT__AND__SIGN();
  public static CryptoAction Default() {
    return theDefault;
  }
  public static CryptoAction create_ENCRYPT__AND__SIGN() {
    return new CryptoAction_ENCRYPT__AND__SIGN();
  }
  public static CryptoAction create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT() {
    return new CryptoAction_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT();
  }
  public static CryptoAction create_SIGN__ONLY() {
    return new CryptoAction_SIGN__ONLY();
  }
  public static CryptoAction create_DO__NOTHING() {
    return new CryptoAction_DO__NOTHING();
  }
  public boolean is_ENCRYPT__AND__SIGN() { return this instanceof CryptoAction_ENCRYPT__AND__SIGN; }
  public boolean is_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT() { return this instanceof CryptoAction_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT; }
  public boolean is_SIGN__ONLY() { return this instanceof CryptoAction_SIGN__ONLY; }
  public boolean is_DO__NOTHING() { return this instanceof CryptoAction_DO__NOTHING; }
  public static java.util.ArrayList<CryptoAction> AllSingletonConstructors() {
    java.util.ArrayList<CryptoAction> singleton_iterator = new java.util.ArrayList<>();
    singleton_iterator.add(new CryptoAction_ENCRYPT__AND__SIGN());
    singleton_iterator.add(new CryptoAction_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT());
    singleton_iterator.add(new CryptoAction_SIGN__ONLY());
    singleton_iterator.add(new CryptoAction_DO__NOTHING());
    return singleton_iterator;
  }
}
