// Class _ExternBase___default
// Dafny class __default compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public abstract class _ExternBase___default {
  public _ExternBase___default() {
  }
  public static boolean IsValid__TerminalTypeId(dafny.DafnySequence<? extends java.lang.Byte> x) {
    return ((java.math.BigInteger.valueOf(2L)).compareTo(java.math.BigInteger.valueOf((x).length())) <= 0) && ((java.math.BigInteger.valueOf((x).length())).compareTo(java.math.BigInteger.valueOf(2L)) <= 0);
  }
  public static boolean IsValid__Version(int x) {
    return ((1) <= (x)) && ((x) <= (1));
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile._default";
  }
}
