// Class CMPEncryptionContext
// Dafny class CMPEncryptionContext compiled into Java
package StructuredEncryptionHeader_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class CMPEncryptionContext {
  public CMPEncryptionContext() {
  }
  public static boolean _Is(dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> __source) {
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _3_x = __source;
    return __default.ValidEncryptionContext(_3_x);
  }
  private static final dafny.TypeDescriptor<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> _TYPE = dafny.TypeDescriptor.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>referenceWithInitializer(dafny.DafnyMap.class, () -> dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
  public static dafny.TypeDescriptor<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
