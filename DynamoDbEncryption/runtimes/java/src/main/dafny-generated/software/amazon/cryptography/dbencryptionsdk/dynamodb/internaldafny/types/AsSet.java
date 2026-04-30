// Class AsSet
// Dafny class AsSet compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class AsSet {
  public AsSet () {
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    AsSet o = (AsSet)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.AsSet.AsSet");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<AsSet> _TYPE = dafny.TypeDescriptor.<AsSet>referenceWithInitializer(AsSet.class, () -> AsSet.Default());
  public static dafny.TypeDescriptor<AsSet> _typeDescriptor() {
    return (dafny.TypeDescriptor<AsSet>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final AsSet theDefault = AsSet.create();
  public static AsSet Default() {
    return theDefault;
  }
  public static AsSet create() {
    return new AsSet();
  }
  public static AsSet create_AsSet() {
    return create();
  }
  public boolean is_AsSet() { return true; }
  public static java.util.ArrayList<AsSet> AllSingletonConstructors() {
    java.util.ArrayList<AsSet> singleton_iterator = new java.util.ArrayList<>();
    singleton_iterator.add(new AsSet());
    return singleton_iterator;
  }
}
