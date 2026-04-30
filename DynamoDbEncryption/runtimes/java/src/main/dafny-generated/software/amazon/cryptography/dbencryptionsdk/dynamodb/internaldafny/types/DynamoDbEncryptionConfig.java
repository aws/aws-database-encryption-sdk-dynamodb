// Class DynamoDbEncryptionConfig
// Dafny class DynamoDbEncryptionConfig compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class DynamoDbEncryptionConfig {
  public DynamoDbEncryptionConfig () {
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    DynamoDbEncryptionConfig o = (DynamoDbEncryptionConfig)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbEncryptionConfig.DynamoDbEncryptionConfig");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<DynamoDbEncryptionConfig> _TYPE = dafny.TypeDescriptor.<DynamoDbEncryptionConfig>referenceWithInitializer(DynamoDbEncryptionConfig.class, () -> DynamoDbEncryptionConfig.Default());
  public static dafny.TypeDescriptor<DynamoDbEncryptionConfig> _typeDescriptor() {
    return (dafny.TypeDescriptor<DynamoDbEncryptionConfig>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final DynamoDbEncryptionConfig theDefault = DynamoDbEncryptionConfig.create();
  public static DynamoDbEncryptionConfig Default() {
    return theDefault;
  }
  public static DynamoDbEncryptionConfig create() {
    return new DynamoDbEncryptionConfig();
  }
  public static DynamoDbEncryptionConfig create_DynamoDbEncryptionConfig() {
    return create();
  }
  public boolean is_DynamoDbEncryptionConfig() { return true; }
  public static java.util.ArrayList<DynamoDbEncryptionConfig> AllSingletonConstructors() {
    java.util.ArrayList<DynamoDbEncryptionConfig> singleton_iterator = new java.util.ArrayList<>();
    singleton_iterator.add(new DynamoDbEncryptionConfig());
    return singleton_iterator;
  }
}
