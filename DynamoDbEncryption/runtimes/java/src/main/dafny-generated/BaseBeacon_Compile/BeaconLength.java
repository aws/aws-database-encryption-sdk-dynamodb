// Class BeaconLength
// Dafny class BeaconLength compiled into Java
package BaseBeacon_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class BeaconLength {
  public BeaconLength() {
  }
  public static java.util.ArrayList<java.lang.Byte> IntegerRange(java.math.BigInteger lo, java.math.BigInteger hi) {
    java.util.ArrayList<java.lang.Byte> arr = new java.util.ArrayList<>();
    for (java.math.BigInteger j = lo; j.compareTo(hi) < 0; j = j.add(java.math.BigInteger.ONE)) { arr.add(java.lang.Byte.valueOf(j.byteValue())); }
    return arr;
  }
  public static byte Witness = ((java.lang.Number) (java.math.BigInteger.ONE)).byteValue();
  public static boolean _Is(byte __source) {
    java.math.BigInteger _6_x = dafny.Helpers.unsignedToBigInteger(__source);
    return ((java.math.BigInteger.ONE).compareTo(_6_x) <= 0) && ((_6_x).compareTo(java.math.BigInteger.valueOf(63L)) <= 0);
  }
  private static final dafny.TypeDescriptor<java.lang.Byte> _TYPE = dafny.TypeDescriptor.byteWithDefault(Witness);
  public static dafny.TypeDescriptor<java.lang.Byte> _typeDescriptor() {
    return (dafny.TypeDescriptor<java.lang.Byte>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
