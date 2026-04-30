// Class BeaconBitLength
// Dafny class BeaconBitLength compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class BeaconBitLength {
  public BeaconBitLength() {
  }
  public static boolean _Is(int __source) {
    int _0_x = (__source);
    if (true) {
      return __default.IsValid__BeaconBitLength(_0_x);
    }
    return false;
  }
  private static final dafny.TypeDescriptor<java.lang.Integer> _TYPE = dafny.TypeDescriptor.intWithDefault(0);
  public static dafny.TypeDescriptor<java.lang.Integer> _typeDescriptor() {
    return (dafny.TypeDescriptor<java.lang.Integer>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
