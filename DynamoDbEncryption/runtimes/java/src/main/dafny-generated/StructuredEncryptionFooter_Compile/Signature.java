// Class Signature
// Dafny class Signature compiled into Java
package StructuredEncryptionFooter_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class Signature {
  public Signature() {
  }
  public static boolean _Is(dafny.DafnySequence<? extends java.lang.Byte> __source) {
    dafny.DafnySequence<? extends java.lang.Byte> _1_x = __source;
    return java.util.Objects.equals(java.math.BigInteger.valueOf((_1_x).length()), dafny.Helpers.unsignedToBigInteger(__default.SignatureSize()));
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence<? extends java.lang.Byte>> _TYPE = dafny.TypeDescriptor.<dafny.DafnySequence<? extends java.lang.Byte>>referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends java.lang.Byte>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends java.lang.Byte>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
