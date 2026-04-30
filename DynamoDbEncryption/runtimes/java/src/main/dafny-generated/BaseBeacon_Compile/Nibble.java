// Class Nibble
// Dafny class Nibble compiled into Java
package BaseBeacon_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class Nibble {
  public Nibble() {
  }
  public static boolean _Is(byte __source) {
    byte _7_x = (__source);
    if (true) {
      return (((_7_x) == 0 ? 0 : 1) != -1) && (java.lang.Integer.compareUnsigned(_7_x, (byte) 16) < 0);
    }
    return false;
  }
  private static final dafny.TypeDescriptor<java.lang.Byte> _TYPE = dafny.TypeDescriptor.byteWithDefault((byte)0);
  public static dafny.TypeDescriptor<java.lang.Byte> _typeDescriptor() {
    return (dafny.TypeDescriptor<java.lang.Byte>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
