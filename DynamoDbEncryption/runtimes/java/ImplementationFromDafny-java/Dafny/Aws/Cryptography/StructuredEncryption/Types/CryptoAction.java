// Class CryptoAction
// Dafny class CryptoAction compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public abstract class CryptoAction {
  public CryptoAction() { }

  private static final CryptoAction theDefault = Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_ENCRYPT__AND__SIGN();
  public static CryptoAction Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<CryptoAction> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(CryptoAction.class, () -> Default());
  public static dafny.TypeDescriptor<CryptoAction> _typeDescriptor() {
    return (dafny.TypeDescriptor<CryptoAction>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static CryptoAction create_ENCRYPT__AND__SIGN() {
    return new CryptoAction_ENCRYPT__AND__SIGN();
  }
  public static CryptoAction create_SIGN__ONLY() {
    return new CryptoAction_SIGN__ONLY();
  }
  public static CryptoAction create_DO__NOTHING() {
    return new CryptoAction_DO__NOTHING();
  }
  public boolean is_ENCRYPT__AND__SIGN() { return this instanceof CryptoAction_ENCRYPT__AND__SIGN; }
  public boolean is_SIGN__ONLY() { return this instanceof CryptoAction_SIGN__ONLY; }
  public boolean is_DO__NOTHING() { return this instanceof CryptoAction_DO__NOTHING; }
  public static java.util.ArrayList<CryptoAction> AllSingletonConstructors() {
    java.util.ArrayList<CryptoAction> singleton_iterator = new java.util.ArrayList<>();
    singleton_iterator.add(new CryptoAction_ENCRYPT__AND__SIGN());
    singleton_iterator.add(new CryptoAction_SIGN__ONLY());
    singleton_iterator.add(new CryptoAction_DO__NOTHING());
    return singleton_iterator;
  }
}
