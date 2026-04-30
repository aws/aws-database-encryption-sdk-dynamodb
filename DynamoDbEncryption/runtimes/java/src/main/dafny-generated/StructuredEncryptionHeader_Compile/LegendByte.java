// Class LegendByte
// Dafny class LegendByte compiled into Java
package StructuredEncryptionHeader_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class LegendByte {
  public LegendByte() {
  }
  public static byte Witness = __default.SIGN__ONLY__LEGEND();
  public static byte defaultValue() {
    return Witness;
  }
  public static boolean _Is(byte __source) {
    byte _4_x = (__source);
    if (true) {
      return __default.ValidLegendByte(_4_x);
    }
    return false;
  }
  private static final dafny.TypeDescriptor<java.lang.Byte> _TYPE = dafny.TypeDescriptor.byteWithDefault(Witness);
  public static dafny.TypeDescriptor<java.lang.Byte> _typeDescriptor() {
    return (dafny.TypeDescriptor<java.lang.Byte>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
