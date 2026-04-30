// Class BeaconStyle
// Dafny class BeaconStyle compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class BeaconStyle {
  public BeaconStyle() {
  }
  private static final dafny.TypeDescriptor<BeaconStyle> _TYPE = dafny.TypeDescriptor.<BeaconStyle>referenceWithInitializer(BeaconStyle.class, () -> BeaconStyle.Default());
  public static dafny.TypeDescriptor<BeaconStyle> _typeDescriptor() {
    return (dafny.TypeDescriptor<BeaconStyle>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final BeaconStyle theDefault = BeaconStyle.create_partOnly(PartOnly.Default());
  public static BeaconStyle Default() {
    return theDefault;
  }
  public static BeaconStyle create_partOnly(PartOnly partOnly) {
    return new BeaconStyle_partOnly(partOnly);
  }
  public static BeaconStyle create_shared(Shared shared) {
    return new BeaconStyle_shared(shared);
  }
  public static BeaconStyle create_asSet(AsSet asSet) {
    return new BeaconStyle_asSet(asSet);
  }
  public static BeaconStyle create_sharedSet(SharedSet sharedSet) {
    return new BeaconStyle_sharedSet(sharedSet);
  }
  public boolean is_partOnly() { return this instanceof BeaconStyle_partOnly; }
  public boolean is_shared() { return this instanceof BeaconStyle_shared; }
  public boolean is_asSet() { return this instanceof BeaconStyle_asSet; }
  public boolean is_sharedSet() { return this instanceof BeaconStyle_sharedSet; }
  public PartOnly dtor_partOnly() {
    BeaconStyle d = this;
    return ((BeaconStyle_partOnly)d)._partOnly;
  }
  public Shared dtor_shared() {
    BeaconStyle d = this;
    return ((BeaconStyle_shared)d)._shared;
  }
  public AsSet dtor_asSet() {
    BeaconStyle d = this;
    return ((BeaconStyle_asSet)d)._asSet;
  }
  public SharedSet dtor_sharedSet() {
    BeaconStyle d = this;
    return ((BeaconStyle_sharedSet)d)._sharedSet;
  }
}
