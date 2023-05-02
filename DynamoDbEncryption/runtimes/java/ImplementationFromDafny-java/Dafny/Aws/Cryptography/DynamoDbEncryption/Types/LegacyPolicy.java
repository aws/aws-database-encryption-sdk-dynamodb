// Class LegacyPolicy
// Dafny class LegacyPolicy compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class LegacyPolicy {
  public LegacyPolicy() { }

  private static final LegacyPolicy theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.LegacyPolicy.create_REQUIRE__ENCRYPT__ALLOW__DECRYPT();
  public static LegacyPolicy Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<LegacyPolicy> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(LegacyPolicy.class, () -> Default());
  public static dafny.TypeDescriptor<LegacyPolicy> _typeDescriptor() {
    return (dafny.TypeDescriptor<LegacyPolicy>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static LegacyPolicy create_REQUIRE__ENCRYPT__ALLOW__DECRYPT() {
    return new LegacyPolicy_REQUIRE__ENCRYPT__ALLOW__DECRYPT();
  }
  public static LegacyPolicy create_FORBID__ENCRYPT__ALLOW__DECRYPT() {
    return new LegacyPolicy_FORBID__ENCRYPT__ALLOW__DECRYPT();
  }
  public static LegacyPolicy create_FORBID__ENCRYPT__FORBID__DECRYPT() {
    return new LegacyPolicy_FORBID__ENCRYPT__FORBID__DECRYPT();
  }
  public boolean is_REQUIRE__ENCRYPT__ALLOW__DECRYPT() { return this instanceof LegacyPolicy_REQUIRE__ENCRYPT__ALLOW__DECRYPT; }
  public boolean is_FORBID__ENCRYPT__ALLOW__DECRYPT() { return this instanceof LegacyPolicy_FORBID__ENCRYPT__ALLOW__DECRYPT; }
  public boolean is_FORBID__ENCRYPT__FORBID__DECRYPT() { return this instanceof LegacyPolicy_FORBID__ENCRYPT__FORBID__DECRYPT; }
  public static java.util.ArrayList<LegacyPolicy> AllSingletonConstructors() {
    java.util.ArrayList<LegacyPolicy> singleton_iterator = new java.util.ArrayList<>();
    singleton_iterator.add(new LegacyPolicy_REQUIRE__ENCRYPT__ALLOW__DECRYPT());
    singleton_iterator.add(new LegacyPolicy_FORBID__ENCRYPT__ALLOW__DECRYPT());
    singleton_iterator.add(new LegacyPolicy_FORBID__ENCRYPT__FORBID__DECRYPT());
    return singleton_iterator;
  }
}
