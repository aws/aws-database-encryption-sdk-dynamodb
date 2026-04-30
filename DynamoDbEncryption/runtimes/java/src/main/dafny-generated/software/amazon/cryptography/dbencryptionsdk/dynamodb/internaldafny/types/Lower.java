// Class Lower
// Dafny class Lower compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class Lower {
  public Lower () {
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Lower o = (Lower)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.Lower.Lower");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<Lower> _TYPE = dafny.TypeDescriptor.<Lower>referenceWithInitializer(Lower.class, () -> Lower.Default());
  public static dafny.TypeDescriptor<Lower> _typeDescriptor() {
    return (dafny.TypeDescriptor<Lower>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final Lower theDefault = Lower.create();
  public static Lower Default() {
    return theDefault;
  }
  public static Lower create() {
    return new Lower();
  }
  public static Lower create_Lower() {
    return create();
  }
  public boolean is_Lower() { return true; }
  public static java.util.ArrayList<Lower> AllSingletonConstructors() {
    java.util.ArrayList<Lower> singleton_iterator = new java.util.ArrayList<>();
    singleton_iterator.add(new Lower());
    return singleton_iterator;
  }
}
