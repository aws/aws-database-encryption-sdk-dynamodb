// Class _ExternBase___default
// Dafny class __default compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class _ExternBase___default {
  public _ExternBase___default() {
  }
  public static boolean IsValid__TerminalTypeId(dafny.DafnySequence<? extends java.lang.Byte> x) {
    return ((java.math.BigInteger.valueOf(2L)).compareTo(java.math.BigInteger.valueOf((x).length())) <= 0) && ((java.math.BigInteger.valueOf((x).length())).compareTo(java.math.BigInteger.valueOf(2L)) <= 0);
  }
  public static boolean IsDummySubsetType(java.math.BigInteger x) {
    return (x).signum() == 1;
  }
  @Override
  public java.lang.String toString() {
    return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes._default";
  }
}
