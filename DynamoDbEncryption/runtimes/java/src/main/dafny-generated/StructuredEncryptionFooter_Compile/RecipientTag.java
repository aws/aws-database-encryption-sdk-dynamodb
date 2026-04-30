// Class RecipientTag
// Dafny class RecipientTag compiled into Java
package StructuredEncryptionFooter_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class RecipientTag {
  public RecipientTag() {
  }
  public static boolean _Is(dafny.DafnySequence<? extends java.lang.Byte> __source) {
    dafny.DafnySequence<? extends java.lang.Byte> _0_x = __source;
    return java.util.Objects.equals(java.math.BigInteger.valueOf((_0_x).length()), dafny.Helpers.unsignedToBigInteger(__default.RecipientTagSize()));
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence<? extends java.lang.Byte>> _TYPE = dafny.TypeDescriptor.<dafny.DafnySequence<? extends java.lang.Byte>>referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends java.lang.Byte>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends java.lang.Byte>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
