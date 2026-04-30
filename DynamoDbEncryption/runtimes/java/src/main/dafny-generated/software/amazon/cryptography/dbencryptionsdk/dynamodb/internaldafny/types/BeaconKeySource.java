// Class BeaconKeySource
// Dafny class BeaconKeySource compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class BeaconKeySource {
  public BeaconKeySource() {
  }
  private static final dafny.TypeDescriptor<BeaconKeySource> _TYPE = dafny.TypeDescriptor.<BeaconKeySource>referenceWithInitializer(BeaconKeySource.class, () -> BeaconKeySource.Default());
  public static dafny.TypeDescriptor<BeaconKeySource> _typeDescriptor() {
    return (dafny.TypeDescriptor<BeaconKeySource>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final BeaconKeySource theDefault = BeaconKeySource.create_single(SingleKeyStore.Default());
  public static BeaconKeySource Default() {
    return theDefault;
  }
  public static BeaconKeySource create_single(SingleKeyStore single) {
    return new BeaconKeySource_single(single);
  }
  public static BeaconKeySource create_multi(MultiKeyStore multi) {
    return new BeaconKeySource_multi(multi);
  }
  public boolean is_single() { return this instanceof BeaconKeySource_single; }
  public boolean is_multi() { return this instanceof BeaconKeySource_multi; }
  public SingleKeyStore dtor_single() {
    BeaconKeySource d = this;
    return ((BeaconKeySource_single)d)._single;
  }
  public MultiKeyStore dtor_multi() {
    BeaconKeySource d = this;
    return ((BeaconKeySource_multi)d)._multi;
  }
}
