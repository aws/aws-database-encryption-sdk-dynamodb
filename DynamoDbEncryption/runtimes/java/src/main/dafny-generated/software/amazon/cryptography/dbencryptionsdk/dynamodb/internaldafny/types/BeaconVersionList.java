// Class BeaconVersionList
// Dafny class BeaconVersionList compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class BeaconVersionList {
  public BeaconVersionList() {
  }
  public static boolean _Is(dafny.DafnySequence<? extends BeaconVersion> __source) {
    dafny.DafnySequence<? extends BeaconVersion> _1_x = __source;
    return __default.IsValid__BeaconVersionList(_1_x);
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence<? extends BeaconVersion>> _TYPE = dafny.TypeDescriptor.<dafny.DafnySequence<? extends BeaconVersion>>referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<BeaconVersion> empty(BeaconVersion._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends BeaconVersion>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends BeaconVersion>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
