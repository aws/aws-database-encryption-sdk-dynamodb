// Class StandardBeaconList
// Dafny class StandardBeaconList compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class StandardBeaconList {
  public StandardBeaconList() {
  }
  public static boolean _Is(dafny.DafnySequence<? extends StandardBeacon> __source) {
    dafny.DafnySequence<? extends StandardBeacon> _2_x = __source;
    return __default.IsValid__StandardBeaconList(_2_x);
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence<? extends StandardBeacon>> _TYPE = dafny.TypeDescriptor.<dafny.DafnySequence<? extends StandardBeacon>>referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<StandardBeacon> empty(StandardBeacon._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends StandardBeacon>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends StandardBeacon>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
