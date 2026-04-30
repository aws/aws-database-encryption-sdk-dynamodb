// Class Flavor
// Dafny class Flavor compiled into Java
package StructuredEncryptionHeader_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class Flavor {
  public Flavor() {
  }
  public static boolean _Is(byte __source) {
    byte _1_x = (__source);
    if (true) {
      return __default.ValidFlavor(_1_x);
    }
    return false;
  }
  private static final dafny.TypeDescriptor<java.lang.Byte> _TYPE = dafny.TypeDescriptor.byteWithDefault((byte)0);
  public static dafny.TypeDescriptor<java.lang.Byte> _typeDescriptor() {
    return (dafny.TypeDescriptor<java.lang.Byte>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
