// Class CompoundBeaconList
// Dafny class CompoundBeaconList compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class CompoundBeaconList {
  public CompoundBeaconList() {
  }
  public static boolean _Is(dafny.DafnySequence<? extends CompoundBeacon> __source) {
    dafny.DafnySequence<? extends CompoundBeacon> _3_x = __source;
    return __default.IsValid__CompoundBeaconList(_3_x);
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence<? extends CompoundBeacon>> _TYPE = dafny.TypeDescriptor.<dafny.DafnySequence<? extends CompoundBeacon>>referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<CompoundBeacon> empty(CompoundBeacon._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends CompoundBeacon>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends CompoundBeacon>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
