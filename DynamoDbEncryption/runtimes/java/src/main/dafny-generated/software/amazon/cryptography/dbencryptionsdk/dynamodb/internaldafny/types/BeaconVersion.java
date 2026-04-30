// Class BeaconVersion
// Dafny class BeaconVersion compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class BeaconVersion {
  public int _version;
  public software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient _keyStore;
  public BeaconKeySource _keySource;
  public dafny.DafnySequence<? extends StandardBeacon> _standardBeacons;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends CompoundBeacon>> _compoundBeacons;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends VirtualField>> _virtualFields;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends EncryptedPart>> _encryptedParts;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends SignedPart>> _signedParts;
  public BeaconVersion (int version, software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient keyStore, BeaconKeySource keySource, dafny.DafnySequence<? extends StandardBeacon> standardBeacons, Wrappers_Compile.Option<dafny.DafnySequence<? extends CompoundBeacon>> compoundBeacons, Wrappers_Compile.Option<dafny.DafnySequence<? extends VirtualField>> virtualFields, Wrappers_Compile.Option<dafny.DafnySequence<? extends EncryptedPart>> encryptedParts, Wrappers_Compile.Option<dafny.DafnySequence<? extends SignedPart>> signedParts) {
    this._version = version;
    this._keyStore = keyStore;
    this._keySource = keySource;
    this._standardBeacons = standardBeacons;
    this._compoundBeacons = compoundBeacons;
    this._virtualFields = virtualFields;
    this._encryptedParts = encryptedParts;
    this._signedParts = signedParts;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BeaconVersion o = (BeaconVersion)other;
    return true && this._version == o._version && this._keyStore == o._keyStore && java.util.Objects.equals(this._keySource, o._keySource) && java.util.Objects.equals(this._standardBeacons, o._standardBeacons) && java.util.Objects.equals(this._compoundBeacons, o._compoundBeacons) && java.util.Objects.equals(this._virtualFields, o._virtualFields) && java.util.Objects.equals(this._encryptedParts, o._encryptedParts) && java.util.Objects.equals(this._signedParts, o._signedParts);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.lang.Integer.hashCode(this._version);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._keyStore);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._keySource);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._standardBeacons);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._compoundBeacons);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._virtualFields);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encryptedParts);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._signedParts);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion.BeaconVersion");
    s.append("(");
    s.append(this._version);
    s.append(", ");
    s.append(dafny.Helpers.toString(this._keyStore));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._keySource));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._standardBeacons));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._compoundBeacons));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._virtualFields));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._encryptedParts));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._signedParts));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<BeaconVersion> _TYPE = dafny.TypeDescriptor.<BeaconVersion>referenceWithInitializer(BeaconVersion.class, () -> BeaconVersion.Default());
  public static dafny.TypeDescriptor<BeaconVersion> _typeDescriptor() {
    return (dafny.TypeDescriptor<BeaconVersion>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final BeaconVersion theDefault = BeaconVersion.create(0, null, BeaconKeySource.Default(), dafny.DafnySequence.<StandardBeacon> empty(StandardBeacon._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends CompoundBeacon>>Default(CompoundBeaconList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends VirtualField>>Default(VirtualFieldList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends EncryptedPart>>Default(EncryptedPartsList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends SignedPart>>Default(SignedPartsList._typeDescriptor()));
  public static BeaconVersion Default() {
    return theDefault;
  }
  public static BeaconVersion create(int version, software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient keyStore, BeaconKeySource keySource, dafny.DafnySequence<? extends StandardBeacon> standardBeacons, Wrappers_Compile.Option<dafny.DafnySequence<? extends CompoundBeacon>> compoundBeacons, Wrappers_Compile.Option<dafny.DafnySequence<? extends VirtualField>> virtualFields, Wrappers_Compile.Option<dafny.DafnySequence<? extends EncryptedPart>> encryptedParts, Wrappers_Compile.Option<dafny.DafnySequence<? extends SignedPart>> signedParts) {
    return new BeaconVersion(version, keyStore, keySource, standardBeacons, compoundBeacons, virtualFields, encryptedParts, signedParts);
  }
  public static BeaconVersion create_BeaconVersion(int version, software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient keyStore, BeaconKeySource keySource, dafny.DafnySequence<? extends StandardBeacon> standardBeacons, Wrappers_Compile.Option<dafny.DafnySequence<? extends CompoundBeacon>> compoundBeacons, Wrappers_Compile.Option<dafny.DafnySequence<? extends VirtualField>> virtualFields, Wrappers_Compile.Option<dafny.DafnySequence<? extends EncryptedPart>> encryptedParts, Wrappers_Compile.Option<dafny.DafnySequence<? extends SignedPart>> signedParts) {
    return create(version, keyStore, keySource, standardBeacons, compoundBeacons, virtualFields, encryptedParts, signedParts);
  }
  public boolean is_BeaconVersion() { return true; }
  public int dtor_version() {
    return this._version;
  }
  public software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient dtor_keyStore() {
    return this._keyStore;
  }
  public BeaconKeySource dtor_keySource() {
    return this._keySource;
  }
  public dafny.DafnySequence<? extends StandardBeacon> dtor_standardBeacons() {
    return this._standardBeacons;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends CompoundBeacon>> dtor_compoundBeacons() {
    return this._compoundBeacons;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends VirtualField>> dtor_virtualFields() {
    return this._virtualFields;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends EncryptedPart>> dtor_encryptedParts() {
    return this._encryptedParts;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends SignedPart>> dtor_signedParts() {
    return this._signedParts;
  }
}
