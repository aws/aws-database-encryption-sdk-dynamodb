// Class CMPUtf8Bytes
// Dafny class CMPUtf8Bytes compiled into Java
package StructuredEncryptionHeader_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class CMPUtf8Bytes {
  public CMPUtf8Bytes() {
  }
  public static boolean _Is(dafny.DafnySequence<? extends java.lang.Byte> __source) {
    dafny.DafnySequence<? extends java.lang.Byte> _6_x = __source;
    if (UTF8.ValidUTF8Bytes._Is(_6_x)) {
      return (java.math.BigInteger.valueOf((_6_x).length())).compareTo(StandardLibrary_mUInt_Compile.__default.UINT16__LIMIT()) < 0;
    }
    return false;
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence<? extends java.lang.Byte>> _TYPE = dafny.TypeDescriptor.<dafny.DafnySequence<? extends java.lang.Byte>>referenceWithInitializer(dafny.DafnySequence.class, () -> UTF8.ValidUTF8Bytes.defaultValue());
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends java.lang.Byte>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends java.lang.Byte>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
