// Class EncryptedDataKeyDescription
// Dafny class EncryptedDataKeyDescription compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class EncryptedDataKeyDescription {
  public dafny.DafnySequence<? extends Character> _keyProviderId;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _keyProviderInfo;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _branchKeyId;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _branchKeyVersion;
  public EncryptedDataKeyDescription (dafny.DafnySequence<? extends Character> keyProviderId, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> keyProviderInfo, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> branchKeyId, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> branchKeyVersion) {
    this._keyProviderId = keyProviderId;
    this._keyProviderInfo = keyProviderInfo;
    this._branchKeyId = branchKeyId;
    this._branchKeyVersion = branchKeyVersion;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    EncryptedDataKeyDescription o = (EncryptedDataKeyDescription)other;
    return true && java.util.Objects.equals(this._keyProviderId, o._keyProviderId) && java.util.Objects.equals(this._keyProviderInfo, o._keyProviderInfo) && java.util.Objects.equals(this._branchKeyId, o._branchKeyId) && java.util.Objects.equals(this._branchKeyVersion, o._branchKeyVersion);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._keyProviderId);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._keyProviderInfo);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._branchKeyId);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._branchKeyVersion);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription.EncryptedDataKeyDescription");
    s.append("(");
    s.append(dafny.Helpers.toString(this._keyProviderId));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._keyProviderInfo));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._branchKeyId));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._branchKeyVersion));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<EncryptedDataKeyDescription> _TYPE = dafny.TypeDescriptor.<EncryptedDataKeyDescription>referenceWithInitializer(EncryptedDataKeyDescription.class, () -> EncryptedDataKeyDescription.Default());
  public static dafny.TypeDescriptor<EncryptedDataKeyDescription> _typeDescriptor() {
    return (dafny.TypeDescriptor<EncryptedDataKeyDescription>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final EncryptedDataKeyDescription theDefault = EncryptedDataKeyDescription.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
  public static EncryptedDataKeyDescription Default() {
    return theDefault;
  }
  public static EncryptedDataKeyDescription create(dafny.DafnySequence<? extends Character> keyProviderId, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> keyProviderInfo, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> branchKeyId, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> branchKeyVersion) {
    return new EncryptedDataKeyDescription(keyProviderId, keyProviderInfo, branchKeyId, branchKeyVersion);
  }
  public static EncryptedDataKeyDescription create_EncryptedDataKeyDescription(dafny.DafnySequence<? extends Character> keyProviderId, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> keyProviderInfo, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> branchKeyId, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> branchKeyVersion) {
    return create(keyProviderId, keyProviderInfo, branchKeyId, branchKeyVersion);
  }
  public boolean is_EncryptedDataKeyDescription() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_keyProviderId() {
    return this._keyProviderId;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> dtor_keyProviderInfo() {
    return this._keyProviderInfo;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> dtor_branchKeyId() {
    return this._branchKeyId;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> dtor_branchKeyVersion() {
    return this._branchKeyVersion;
  }
}
