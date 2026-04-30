// Class PlaintextOverride
// Dafny class PlaintextOverride compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class PlaintextOverride {
  public PlaintextOverride() {
  }
  private static final dafny.TypeDescriptor<PlaintextOverride> _TYPE = dafny.TypeDescriptor.<PlaintextOverride>referenceWithInitializer(PlaintextOverride.class, () -> PlaintextOverride.Default());
  public static dafny.TypeDescriptor<PlaintextOverride> _typeDescriptor() {
    return (dafny.TypeDescriptor<PlaintextOverride>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final PlaintextOverride theDefault = PlaintextOverride.create_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ();
  public static PlaintextOverride Default() {
    return theDefault;
  }
  public static PlaintextOverride create_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ() {
    return new PlaintextOverride_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ();
  }
  public static PlaintextOverride create_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ() {
    return new PlaintextOverride_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ();
  }
  public static PlaintextOverride create_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ() {
    return new PlaintextOverride_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ();
  }
  public boolean is_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ() { return this instanceof PlaintextOverride_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ; }
  public boolean is_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ() { return this instanceof PlaintextOverride_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ; }
  public boolean is_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ() { return this instanceof PlaintextOverride_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ; }
  public static java.util.ArrayList<PlaintextOverride> AllSingletonConstructors() {
    java.util.ArrayList<PlaintextOverride> singleton_iterator = new java.util.ArrayList<>();
    singleton_iterator.add(new PlaintextOverride_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ());
    singleton_iterator.add(new PlaintextOverride_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ());
    singleton_iterator.add(new PlaintextOverride_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ());
    return singleton_iterator;
  }
}
