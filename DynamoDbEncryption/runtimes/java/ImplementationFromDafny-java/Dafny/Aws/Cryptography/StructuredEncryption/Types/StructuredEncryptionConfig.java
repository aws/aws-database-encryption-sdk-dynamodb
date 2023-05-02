// Class StructuredEncryptionConfig
// Dafny class StructuredEncryptionConfig compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public class StructuredEncryptionConfig {
  public StructuredEncryptionConfig () {
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    StructuredEncryptionConfig o = (StructuredEncryptionConfig)other;
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
    s.append("Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile.StructuredEncryptionConfig.StructuredEncryptionConfig");
    return s.toString();
  }

  private static final StructuredEncryptionConfig theDefault = Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredEncryptionConfig.create();
  public static StructuredEncryptionConfig Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<StructuredEncryptionConfig> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(StructuredEncryptionConfig.class, () -> Default());
  public static dafny.TypeDescriptor<StructuredEncryptionConfig> _typeDescriptor() {
    return (dafny.TypeDescriptor<StructuredEncryptionConfig>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static StructuredEncryptionConfig create() {
    return new StructuredEncryptionConfig();
  }
  public static StructuredEncryptionConfig create_StructuredEncryptionConfig() {
    return create();
  }
  public boolean is_StructuredEncryptionConfig() { return true; }
  public static java.util.ArrayList<StructuredEncryptionConfig> AllSingletonConstructors() {
    java.util.ArrayList<StructuredEncryptionConfig> singleton_iterator = new java.util.ArrayList<>();
    singleton_iterator.add(new StructuredEncryptionConfig());
    return singleton_iterator;
  }
}
