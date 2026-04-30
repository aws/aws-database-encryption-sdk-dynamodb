// Class PartOnly
// Dafny class PartOnly compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class PartOnly {
  public PartOnly () {
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    PartOnly o = (PartOnly)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.PartOnly.PartOnly");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<PartOnly> _TYPE = dafny.TypeDescriptor.<PartOnly>referenceWithInitializer(PartOnly.class, () -> PartOnly.Default());
  public static dafny.TypeDescriptor<PartOnly> _typeDescriptor() {
    return (dafny.TypeDescriptor<PartOnly>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final PartOnly theDefault = PartOnly.create();
  public static PartOnly Default() {
    return theDefault;
  }
  public static PartOnly create() {
    return new PartOnly();
  }
  public static PartOnly create_PartOnly() {
    return create();
  }
  public boolean is_PartOnly() { return true; }
  public static java.util.ArrayList<PartOnly> AllSingletonConstructors() {
    java.util.ArrayList<PartOnly> singleton_iterator = new java.util.ArrayList<>();
    singleton_iterator.add(new PartOnly());
    return singleton_iterator;
  }
}
