// Class PlaintextPolicy
// Dafny class PlaintextPolicy compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class PlaintextPolicy {
  public PlaintextPolicy() { }

  private static final PlaintextPolicy theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PlaintextPolicy.create_REQUIRE__WRITE__ALLOW__READ();
  public static PlaintextPolicy Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<PlaintextPolicy> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(PlaintextPolicy.class, () -> Default());
  public static dafny.TypeDescriptor<PlaintextPolicy> _typeDescriptor() {
    return (dafny.TypeDescriptor<PlaintextPolicy>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static PlaintextPolicy create_REQUIRE__WRITE__ALLOW__READ() {
    return new PlaintextPolicy_REQUIRE__WRITE__ALLOW__READ();
  }
  public static PlaintextPolicy create_FORBID__WRITE__ALLOW__READ() {
    return new PlaintextPolicy_FORBID__WRITE__ALLOW__READ();
  }
  public static PlaintextPolicy create_FORBID__WRITE__FORBID__READ() {
    return new PlaintextPolicy_FORBID__WRITE__FORBID__READ();
  }
  public boolean is_REQUIRE__WRITE__ALLOW__READ() { return this instanceof PlaintextPolicy_REQUIRE__WRITE__ALLOW__READ; }
  public boolean is_FORBID__WRITE__ALLOW__READ() { return this instanceof PlaintextPolicy_FORBID__WRITE__ALLOW__READ; }
  public boolean is_FORBID__WRITE__FORBID__READ() { return this instanceof PlaintextPolicy_FORBID__WRITE__FORBID__READ; }
  public static java.util.ArrayList<PlaintextPolicy> AllSingletonConstructors() {
    java.util.ArrayList<PlaintextPolicy> singleton_iterator = new java.util.ArrayList<>();
    singleton_iterator.add(new PlaintextPolicy_REQUIRE__WRITE__ALLOW__READ());
    singleton_iterator.add(new PlaintextPolicy_FORBID__WRITE__ALLOW__READ());
    singleton_iterator.add(new PlaintextPolicy_FORBID__WRITE__FORBID__READ());
    return singleton_iterator;
  }
}
