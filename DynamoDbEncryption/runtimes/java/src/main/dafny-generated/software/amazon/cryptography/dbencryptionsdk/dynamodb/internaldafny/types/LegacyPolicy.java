// Class LegacyPolicy
// Dafny class LegacyPolicy compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class LegacyPolicy {
  public LegacyPolicy() {
  }
  private static final dafny.TypeDescriptor<LegacyPolicy> _TYPE = dafny.TypeDescriptor.<LegacyPolicy>referenceWithInitializer(LegacyPolicy.class, () -> LegacyPolicy.Default());
  public static dafny.TypeDescriptor<LegacyPolicy> _typeDescriptor() {
    return (dafny.TypeDescriptor<LegacyPolicy>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final LegacyPolicy theDefault = LegacyPolicy.create_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT();
  public static LegacyPolicy Default() {
    return theDefault;
  }
  public static LegacyPolicy create_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT() {
    return new LegacyPolicy_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT();
  }
  public static LegacyPolicy create_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT() {
    return new LegacyPolicy_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT();
  }
  public static LegacyPolicy create_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT() {
    return new LegacyPolicy_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT();
  }
  public boolean is_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT() { return this instanceof LegacyPolicy_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT; }
  public boolean is_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT() { return this instanceof LegacyPolicy_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT; }
  public boolean is_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT() { return this instanceof LegacyPolicy_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT; }
  public static java.util.ArrayList<LegacyPolicy> AllSingletonConstructors() {
    java.util.ArrayList<LegacyPolicy> singleton_iterator = new java.util.ArrayList<>();
    singleton_iterator.add(new LegacyPolicy_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT());
    singleton_iterator.add(new LegacyPolicy_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT());
    singleton_iterator.add(new LegacyPolicy_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT());
    return singleton_iterator;
  }
}
