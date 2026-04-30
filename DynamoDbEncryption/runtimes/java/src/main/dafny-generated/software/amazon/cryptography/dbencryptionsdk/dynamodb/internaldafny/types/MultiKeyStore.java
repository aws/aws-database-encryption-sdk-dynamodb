// Class MultiKeyStore
// Dafny class MultiKeyStore compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class MultiKeyStore {
  public dafny.DafnySequence<? extends Character> _keyFieldName;
  public int _cacheTTL;
  public Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.CacheType> _cache;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _partitionId;
  public MultiKeyStore (dafny.DafnySequence<? extends Character> keyFieldName, int cacheTTL, Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.CacheType> cache, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> partitionId) {
    this._keyFieldName = keyFieldName;
    this._cacheTTL = cacheTTL;
    this._cache = cache;
    this._partitionId = partitionId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    MultiKeyStore o = (MultiKeyStore)other;
    return true && java.util.Objects.equals(this._keyFieldName, o._keyFieldName) && this._cacheTTL == o._cacheTTL && java.util.Objects.equals(this._cache, o._cache) && java.util.Objects.equals(this._partitionId, o._partitionId);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._keyFieldName);
    hash = ((hash << 5) + hash) + java.lang.Integer.hashCode(this._cacheTTL);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._cache);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._partitionId);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.MultiKeyStore.MultiKeyStore");
    s.append("(");
    s.append(dafny.Helpers.toString(this._keyFieldName));
    s.append(", ");
    s.append(this._cacheTTL);
    s.append(", ");
    s.append(dafny.Helpers.toString(this._cache));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._partitionId));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<MultiKeyStore> _TYPE = dafny.TypeDescriptor.<MultiKeyStore>referenceWithInitializer(MultiKeyStore.class, () -> MultiKeyStore.Default());
  public static dafny.TypeDescriptor<MultiKeyStore> _typeDescriptor() {
    return (dafny.TypeDescriptor<MultiKeyStore>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final MultiKeyStore theDefault = MultiKeyStore.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), 0, Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.CacheType>Default(software.amazon.cryptography.materialproviders.internaldafny.types.CacheType._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
  public static MultiKeyStore Default() {
    return theDefault;
  }
  public static MultiKeyStore create(dafny.DafnySequence<? extends Character> keyFieldName, int cacheTTL, Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.CacheType> cache, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> partitionId) {
    return new MultiKeyStore(keyFieldName, cacheTTL, cache, partitionId);
  }
  public static MultiKeyStore create_MultiKeyStore(dafny.DafnySequence<? extends Character> keyFieldName, int cacheTTL, Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.CacheType> cache, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> partitionId) {
    return create(keyFieldName, cacheTTL, cache, partitionId);
  }
  public boolean is_MultiKeyStore() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_keyFieldName() {
    return this._keyFieldName;
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
