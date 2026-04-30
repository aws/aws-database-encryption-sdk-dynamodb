// Class StructuredEncryptionConfig
// Dafny class StructuredEncryptionConfig compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

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
    s.append("AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredEncryptionConfig.StructuredEncryptionConfig");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<StructuredEncryptionConfig> _TYPE = dafny.TypeDescriptor.<StructuredEncryptionConfig>referenceWithInitializer(StructuredEncryptionConfig.class, () -> StructuredEncryptionConfig.Default());
  public static dafny.TypeDescriptor<StructuredEncryptionConfig> _typeDescriptor() {
    return (dafny.TypeDescriptor<StructuredEncryptionConfig>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final StructuredEncryptionConfig theDefault = StructuredEncryptionConfig.create();
  public static StructuredEncryptionConfig Default() {
    return theDefault;
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
