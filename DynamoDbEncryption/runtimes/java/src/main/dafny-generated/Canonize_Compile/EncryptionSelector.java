// Class EncryptionSelector
// Dafny class EncryptionSelector compiled into Java
package Canonize_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class EncryptionSelector {
  public EncryptionSelector() {
  }
  private static final dafny.TypeDescriptor<EncryptionSelector> _TYPE = dafny.TypeDescriptor.<EncryptionSelector>referenceWithInitializer(EncryptionSelector.class, () -> EncryptionSelector.Default());
  public static dafny.TypeDescriptor<EncryptionSelector> _typeDescriptor() {
    return (dafny.TypeDescriptor<EncryptionSelector>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final EncryptionSelector theDefault = EncryptionSelector.create_DoEncrypt();
  public static EncryptionSelector Default() {
    return theDefault;
  }
  public static EncryptionSelector create_DoEncrypt() {
    return new EncryptionSelector_DoEncrypt();
  }
  public static EncryptionSelector create_DoDecrypt() {
    return new EncryptionSelector_DoDecrypt();
  }
  public boolean is_DoEncrypt() { return this instanceof EncryptionSelector_DoEncrypt; }
  public boolean is_DoDecrypt() { return this instanceof EncryptionSelector_DoDecrypt; }
  public static java.util.ArrayList<EncryptionSelector> AllSingletonConstructors() {
    java.util.ArrayList<EncryptionSelector> singleton_iterator = new java.util.ArrayList<>();
    singleton_iterator.add(new EncryptionSelector_DoEncrypt());
    singleton_iterator.add(new EncryptionSelector_DoDecrypt());
    return singleton_iterator;
  }
}
