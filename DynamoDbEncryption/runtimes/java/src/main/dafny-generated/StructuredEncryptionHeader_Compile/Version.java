// Class Version
// Dafny class Version compiled into Java
package StructuredEncryptionHeader_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class Version {
  public Version() {
  }
  public static byte Witness = (byte) 1;
  public static byte defaultValue() {
    return Witness;
  }
  public static boolean _Is(byte __source) {
    byte _0_x = (__source);
    if (true) {
      return __default.ValidVersion(_0_x);
    }
    return false;
  }
  private static final dafny.TypeDescriptor<java.lang.Byte> _TYPE = dafny.TypeDescriptor.byteWithDefault(Witness);
  public static dafny.TypeDescriptor<java.lang.Byte> _typeDescriptor() {
    return (dafny.TypeDescriptor<java.lang.Byte>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
