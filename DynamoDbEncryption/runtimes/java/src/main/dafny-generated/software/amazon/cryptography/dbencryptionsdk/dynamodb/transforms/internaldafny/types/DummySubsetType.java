// Class DummySubsetType
// Dafny class DummySubsetType compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class DummySubsetType {
  public DummySubsetType() {
  }
  public static java.math.BigInteger Witness = java.math.BigInteger.ONE;
  public static java.math.BigInteger defaultValue() {
    return Witness;
  }
  public static boolean _Is(java.math.BigInteger __source) {
    java.math.BigInteger _1_x = __source;
    return __default.IsDummySubsetType(_1_x);
  }
  private static final dafny.TypeDescriptor<java.math.BigInteger> _TYPE = dafny.TypeDescriptor.<java.math.BigInteger>referenceWithInitializer(java.math.BigInteger.class, () -> DummySubsetType.defaultValue());
  public static dafny.TypeDescriptor<java.math.BigInteger> _typeDescriptor() {
    return (dafny.TypeDescriptor<java.math.BigInteger>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
