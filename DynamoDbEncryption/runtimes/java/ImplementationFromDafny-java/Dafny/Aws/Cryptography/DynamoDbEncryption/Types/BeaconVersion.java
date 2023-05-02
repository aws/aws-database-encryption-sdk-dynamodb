// Class BeaconVersion
// Dafny class BeaconVersion compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class BeaconVersion {
  public int _version;
  public Dafny.Aws.Cryptography.KeyStore.Types.IKeyStoreClient _keyStore;
  public BeaconKeySource _keySource;
  public dafny.DafnySequence<? extends StandardBeacon> _standardBeacons;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends CompoundBeacon>> _compoundBeacons;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends VirtualField>> _virtualFields;
  public BeaconVersion (int version, Dafny.Aws.Cryptography.KeyStore.Types.IKeyStoreClient keyStore, BeaconKeySource keySource, dafny.DafnySequence<? extends StandardBeacon> standardBeacons, Wrappers_Compile.Option<dafny.DafnySequence<? extends CompoundBeacon>> compoundBeacons, Wrappers_Compile.Option<dafny.DafnySequence<? extends VirtualField>> virtualFields) {
    this._version = version;
    this._keyStore = keyStore;
    this._keySource = keySource;
    this._standardBeacons = standardBeacons;
    this._compoundBeacons = compoundBeacons;
    this._virtualFields = virtualFields;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BeaconVersion o = (BeaconVersion)other;
    return true && this._version == o._version && this._keyStore == o._keyStore && java.util.Objects.equals(this._keySource, o._keySource) && java.util.Objects.equals(this._standardBeacons, o._standardBeacons) && java.util.Objects.equals(this._compoundBeacons, o._compoundBeacons) && java.util.Objects.equals(this._virtualFields, o._virtualFields);
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
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.BeaconVersion.BeaconVersion");
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
    s.append(")");
    return s.toString();
  }

  private static final BeaconVersion theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BeaconVersion.create(0, null, BeaconKeySource.Default(), dafny.DafnySequence.<StandardBeacon> empty(StandardBeacon._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends CompoundBeacon>>Default(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends VirtualField>>Default());
  public static BeaconVersion Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<BeaconVersion> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(BeaconVersion.class, () -> Default());
  public static dafny.TypeDescriptor<BeaconVersion> _typeDescriptor() {
    return (dafny.TypeDescriptor<BeaconVersion>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static BeaconVersion create(int version, Dafny.Aws.Cryptography.KeyStore.Types.IKeyStoreClient keyStore, BeaconKeySource keySource, dafny.DafnySequence<? extends StandardBeacon> standardBeacons, Wrappers_Compile.Option<dafny.DafnySequence<? extends CompoundBeacon>> compoundBeacons, Wrappers_Compile.Option<dafny.DafnySequence<? extends VirtualField>> virtualFields) {
    return new BeaconVersion(version, keyStore, keySource, standardBeacons, compoundBeacons, virtualFields);
  }
  public static BeaconVersion create_BeaconVersion(int version, Dafny.Aws.Cryptography.KeyStore.Types.IKeyStoreClient keyStore, BeaconKeySource keySource, dafny.DafnySequence<? extends StandardBeacon> standardBeacons, Wrappers_Compile.Option<dafny.DafnySequence<? extends CompoundBeacon>> compoundBeacons, Wrappers_Compile.Option<dafny.DafnySequence<? extends VirtualField>> virtualFields) {
    return create(version, keyStore, keySource, standardBeacons, compoundBeacons, virtualFields);
  }
  public boolean is_BeaconVersion() { return true; }
  public int dtor_version() {
    return this._version;
  }
  public Dafny.Aws.Cryptography.KeyStore.Types.IKeyStoreClient dtor_keyStore() {
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
}
