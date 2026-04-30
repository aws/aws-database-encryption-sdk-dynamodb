// Class BeaconType
// Dafny class BeaconType compiled into Java
package SearchableEncryptionInfo_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class BeaconType {
  public BeaconType() {
  }
  private static final dafny.TypeDescriptor<BeaconType> _TYPE = dafny.TypeDescriptor.<BeaconType>referenceWithInitializer(BeaconType.class, () -> BeaconType.Default());
  public static dafny.TypeDescriptor<BeaconType> _typeDescriptor() {
    return (dafny.TypeDescriptor<BeaconType>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final BeaconType theDefault = BeaconType.create_AnyBeacon();
  public static BeaconType Default() {
    return theDefault;
  }
  public static BeaconType create_AnyBeacon() {
    return new BeaconType_AnyBeacon();
  }
  public static BeaconType create_SignedBeacon() {
    return new BeaconType_SignedBeacon();
  }
  public static BeaconType create_EncryptedBeacon() {
    return new BeaconType_EncryptedBeacon();
  }
  public boolean is_AnyBeacon() { return this instanceof BeaconType_AnyBeacon; }
  public boolean is_SignedBeacon() { return this instanceof BeaconType_SignedBeacon; }
  public boolean is_EncryptedBeacon() { return this instanceof BeaconType_EncryptedBeacon; }
  public static java.util.ArrayList<BeaconType> AllSingletonConstructors() {
    java.util.ArrayList<BeaconType> singleton_iterator = new java.util.ArrayList<>();
    singleton_iterator.add(new BeaconType_AnyBeacon());
    singleton_iterator.add(new BeaconType_SignedBeacon());
    singleton_iterator.add(new BeaconType_EncryptedBeacon());
    return singleton_iterator;
  }
}
