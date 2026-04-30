// Class VersionNumber
// Dafny class VersionNumber compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class VersionNumber {
  public VersionNumber() {
  }
  public static boolean _Is(int __source) {
    int _4_x = (__source);
    if (true) {
      return __default.IsValid__VersionNumber(_4_x);
    }
    return false;
  }
  private static final dafny.TypeDescriptor<java.lang.Integer> _TYPE = dafny.TypeDescriptor.intWithDefault(0);
  public static dafny.TypeDescriptor<java.lang.Integer> _typeDescriptor() {
    return (dafny.TypeDescriptor<java.lang.Integer>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
