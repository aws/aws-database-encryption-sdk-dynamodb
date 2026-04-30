// Class SingleKeyStore
// Dafny class SingleKeyStore compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class SingleKeyStore {
  public dafny.DafnySequence<? extends Character> _keyId;
  public int _cacheTTL;
  public Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.CacheType> _cache;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _partitionId;
  public SingleKeyStore (dafny.DafnySequence<? extends Character> keyId, int cacheTTL, Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.CacheType> cache, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> partitionId) {
    this._keyId = keyId;
    this._cacheTTL = cacheTTL;
    this._cache = cache;
    this._partitionId = partitionId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    SingleKeyStore o = (SingleKeyStore)other;
    return true && java.util.Objects.equals(this._keyId, o._keyId) && this._cacheTTL == o._cacheTTL && java.util.Objects.equals(this._cache, o._cache) && java.util.Objects.equals(this._partitionId, o._partitionId);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._keyId);
    hash = ((hash << 5) + hash) + java.lang.Integer.hashCode(this._cacheTTL);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._cache);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._partitionId);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.SingleKeyStore.SingleKeyStore");
    s.append("(");
    s.append(dafny.Helpers.toString(this._keyId));
    s.append(", ");
    s.append(this._cacheTTL);
    s.append(", ");
    s.append(dafny.Helpers.toString(this._cache));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._partitionId));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<SingleKeyStore> _TYPE = dafny.TypeDescriptor.<SingleKeyStore>referenceWithInitializer(SingleKeyStore.class, () -> SingleKeyStore.Default());
  public static dafny.TypeDescriptor<SingleKeyStore> _typeDescriptor() {
    return (dafny.TypeDescriptor<SingleKeyStore>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final SingleKeyStore theDefault = SingleKeyStore.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), 0, Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.CacheType>Default(software.amazon.cryptography.materialproviders.internaldafny.types.CacheType._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
  public static SingleKeyStore Default() {
    return theDefault;
  }
  public static SingleKeyStore create(dafny.DafnySequence<? extends Character> keyId, int cacheTTL, Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.CacheType> cache, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> partitionId) {
    return new SingleKeyStore(keyId, cacheTTL, cache, partitionId);
  }
  public static SingleKeyStore create_SingleKeyStore(dafny.DafnySequence<? extends Character> keyId, int cacheTTL, Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.CacheType> cache, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> partitionId) {
    return create(keyId, cacheTTL, cache, partitionId);
  }
  public boolean is_SingleKeyStore() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_keyId() {
    return this._keyId;
  }
  public int dtor_cacheTTL() {
    return this._cacheTTL;
  }
  public Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.CacheType> dtor_cache() {
    return this._cache;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> dtor_partitionId() {
    return this._partitionId;
  }
}
