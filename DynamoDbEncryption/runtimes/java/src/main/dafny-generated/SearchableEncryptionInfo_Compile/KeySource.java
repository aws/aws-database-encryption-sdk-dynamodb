// Class KeySource
// Dafny class KeySource compiled into Java
package SearchableEncryptionInfo_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class KeySource {
  public software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient _client;
  public software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient _store;
  public KeyLocation _keyLoc;
  public software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache _cache;
  public int _cacheTTL;
  public dafny.DafnySequence<? extends java.lang.Byte> _partitionIdBytes;
  public dafny.DafnySequence<? extends java.lang.Byte> _logicalKeyStoreNameBytes;
  public KeySource (software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient client, software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient store, KeyLocation keyLoc, software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache cache, int cacheTTL, dafny.DafnySequence<? extends java.lang.Byte> partitionIdBytes, dafny.DafnySequence<? extends java.lang.Byte> logicalKeyStoreNameBytes) {
    this._client = client;
    this._store = store;
    this._keyLoc = keyLoc;
    this._cache = cache;
    this._cacheTTL = cacheTTL;
    this._partitionIdBytes = partitionIdBytes;
    this._logicalKeyStoreNameBytes = logicalKeyStoreNameBytes;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    KeySource o = (KeySource)other;
    return true && this._client == o._client && this._store == o._store && java.util.Objects.equals(this._keyLoc, o._keyLoc) && this._cache == o._cache && this._cacheTTL == o._cacheTTL && java.util.Objects.equals(this._partitionIdBytes, o._partitionIdBytes) && java.util.Objects.equals(this._logicalKeyStoreNameBytes, o._logicalKeyStoreNameBytes);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._client);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._store);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._keyLoc);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._cache);
    hash = ((hash << 5) + hash) + java.lang.Integer.hashCode(this._cacheTTL);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._partitionIdBytes);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._logicalKeyStoreNameBytes);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("SearchableEncryptionInfo.KeySource.KeySource");
    s.append("(");
    s.append(dafny.Helpers.toString(this._client));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._store));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._keyLoc));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._cache));
    s.append(", ");
    s.append(this._cacheTTL);
    s.append(", ");
    s.append(dafny.Helpers.toString(this._partitionIdBytes));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._logicalKeyStoreNameBytes));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<KeySource> _TYPE = dafny.TypeDescriptor.<KeySource>referenceWithInitializer(KeySource.class, () -> KeySource.Default());
  public static dafny.TypeDescriptor<KeySource> _typeDescriptor() {
    return (dafny.TypeDescriptor<KeySource>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final KeySource theDefault = KeySource.create(null, null, KeyLocation.Default(), null, 0, dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
  public static KeySource Default() {
    return theDefault;
  }
  public static KeySource create(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient client, software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient store, KeyLocation keyLoc, software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache cache, int cacheTTL, dafny.DafnySequence<? extends java.lang.Byte> partitionIdBytes, dafny.DafnySequence<? extends java.lang.Byte> logicalKeyStoreNameBytes) {
    return new KeySource(client, store, keyLoc, cache, cacheTTL, partitionIdBytes, logicalKeyStoreNameBytes);
  }
  public static KeySource create_KeySource(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient client, software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient store, KeyLocation keyLoc, software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache cache, int cacheTTL, dafny.DafnySequence<? extends java.lang.Byte> partitionIdBytes, dafny.DafnySequence<? extends java.lang.Byte> logicalKeyStoreNameBytes) {
    return create(client, store, keyLoc, cache, cacheTTL, partitionIdBytes, logicalKeyStoreNameBytes);
  }
  public boolean is_KeySource() { return true; }
  public software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient dtor_client() {
    return this._client;
  }
  public software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient dtor_store() {
    return this._store;
  }
  public KeyLocation dtor_keyLoc() {
    return this._keyLoc;
  }
  public software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache dtor_cache() {
    return this._cache;
  }
  public int dtor_cacheTTL() {
    return this._cacheTTL;
  }
  public dafny.DafnySequence<? extends java.lang.Byte> dtor_partitionIdBytes() {
    return this._partitionIdBytes;
  }
  public dafny.DafnySequence<? extends java.lang.Byte> dtor_logicalKeyStoreNameBytes() {
    return this._logicalKeyStoreNameBytes;
  }
  public Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> getKeyMap(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> stdNames, DynamoDbEncryptionUtil_Compile.MaybeKeyId keyId)
  {
    Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyMap.Default());
    if(true) {
      if (((this).dtor_keyLoc()).is_SingleLoc()) {
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (keyId).is_DontUseKeyId(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("KeyID should not be supplied with a SingleKeyStore")));
        if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_0_valueOrError0).<DynamoDbEncryptionUtil_Compile.MaybeKeyMap>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor());
          return output;
        }
        long _1_now;
        long _out0;
        _out0 = Time.__default.CurrentRelativeTime();
        _1_now = _out0;
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
        _out1 = (this).getKeysCache((this).dtor_client(), stdNames, ((this).dtor_keyLoc()).dtor_keyId(), (long) java.lang.Integer.toUnsignedLong((this).dtor_cacheTTL()), (this).dtor_partitionIdBytes(), (this).dtor_logicalKeyStoreNameBytes(), (_1_now));
        _2_valueOrError1 = _out1;
        if ((_2_valueOrError1).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_2_valueOrError1).<DynamoDbEncryptionUtil_Compile.MaybeKeyMap>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor());
          return output;
        }
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _3_theMap;
        _3_theMap = (_2_valueOrError1).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        output = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_Keys(_3_theMap));
        return output;
      } else if (((this).dtor_keyLoc()).is_LiteralLoc()) {
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError2 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        _4_valueOrError2 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (keyId).is_DontUseKeyId(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("KeyID should not be supplied with a LiteralKeyStore")));
        if ((_4_valueOrError2).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_4_valueOrError2).<DynamoDbEncryptionUtil_Compile.MaybeKeyMap>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor());
          return output;
        }
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_valueOrError3 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
        _out2 = (this).getKeysLiteral();
        _5_valueOrError3 = _out2;
        if ((_5_valueOrError3).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_5_valueOrError3).<DynamoDbEncryptionUtil_Compile.MaybeKeyMap>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor());
          return output;
        }
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _6_theMap;
        _6_theMap = (_5_valueOrError3).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        output = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_Keys(_6_theMap));
        return output;
      } else {
        DynamoDbEncryptionUtil_Compile.MaybeKeyId _source0 = keyId;
        if (_source0.is_DontUseKeyId()) {
          output = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Fixed KeyID must not be supplied with a MultiKeyStore")));
          return output;
        } else if (_source0.is_ShouldHaveKeyId()) {
          output = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_ShouldHaveKeys());
          return output;
        } else {
          dafny.DafnySequence<? extends Character> _7___mcc_h0 = ((DynamoDbEncryptionUtil_Compile.MaybeKeyId_KeyId)_source0)._value;
          dafny.DafnySequence<? extends Character> _8_id = _7___mcc_h0;
          long _9_now;
          long _out3;
          _out3 = Time.__default.CurrentRelativeTime();
          _9_now = _out3;
          Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _10_valueOrError4 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
          Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out4;
          _out4 = (this).getKeysCache((this).dtor_client(), stdNames, _8_id, (long) java.lang.Integer.toUnsignedLong((this).dtor_cacheTTL()), (this).dtor_partitionIdBytes(), (this).dtor_logicalKeyStoreNameBytes(), (_9_now));
          _10_valueOrError4 = _out4;
          if ((_10_valueOrError4).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            output = (_10_valueOrError4).<DynamoDbEncryptionUtil_Compile.MaybeKeyMap>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor());
            return output;
          }
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _11_theMap;
          _11_theMap = (_10_valueOrError4).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          output = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_Keys(_11_theMap));
          return output;
        }
      }
    }
    return output;
  }
  public Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> getKeysLiteral()
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
    output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((this).dtor_keyLoc()).dtor_keys());
    return output;
  }
  public long PosLongAdd(long x, long y)
  {
    if (((java.math.BigInteger.valueOf(x)).add(java.math.BigInteger.valueOf(y))).compareTo(StandardLibrary_mUInt_Compile.__default.INT64__MAX__LIMIT()) < 0) {
      return (long) (long) ((x) + (y));
    } else {
      return (StandardLibrary_mUInt_Compile.__default.INT64__MAX__LIMIT()).longValue();
    }
  }
  public long PosLongSub(long x, long y)
  {
    if ((x) <= (y)) {
      return (long) 0L;
    } else {
      return (long) (long) ((x) - (y));
    }
  }
  public boolean cacheEntryWithinLimits(long creationTime, long now, long ttlSeconds)
  {
    if ((now) <= (creationTime)) {
      return true;
    } else {
      return ((this).PosLongSub(now, creationTime)) <= (ttlSeconds);
    }
  }
  public Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> getKeysCache(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient client, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> stdNames, dafny.DafnySequence<? extends Character> keyId, long cacheTTL, dafny.DafnySequence<? extends java.lang.Byte> partitionIdBytes, dafny.DafnySequence<? extends java.lang.Byte> logicalKeyStoreNameBytes, long now)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
    if(true) {
      dafny.DafnySequence<? extends java.lang.Byte> _0_resourceId;
      _0_resourceId = CacheConstants_Compile.__default.RESOURCE__ID__HIERARCHICAL__KEYRING();
      dafny.DafnySequence<? extends java.lang.Byte> _1_scopeId;
      _1_scopeId = CacheConstants_Compile.__default.SCOPE__ID__SEARCHABLE__ENCRYPTION();
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _2_keyIdBytesR;
      _2_keyIdBytesR = UTF8.__default.Encode(keyId);
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), UTF8.ValidUTF8Bytes.defaultValue());
      _3_valueOrError0 = (_2_keyIdBytesR).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_4_e_boxed0) -> {
        dafny.DafnySequence<? extends Character> _4_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_4_e_boxed0));
        return DynamoDbEncryptionUtil_Compile.__default.E(_4_e);
      }));
      if ((_3_valueOrError0).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_3_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())));
        return output;
      }
      dafny.DafnySequence<? extends java.lang.Byte> _5_keyIdBytes;
      _5_keyIdBytes = (_3_valueOrError0).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      dafny.DafnySequence<? extends java.lang.Byte> _6_suffix;
      _6_suffix = dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(logicalKeyStoreNameBytes, CacheConstants_Compile.__default.NULL__BYTE()), _5_keyIdBytes);
      dafny.DafnySequence<? extends java.lang.Byte> _7_identifier;
      _7_identifier = dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(_0_resourceId, CacheConstants_Compile.__default.NULL__BYTE()), _1_scopeId), CacheConstants_Compile.__default.NULL__BYTE()), partitionIdBytes), CacheConstants_Compile.__default.NULL__BYTE()), _6_suffix);
      software.amazon.cryptography.primitives.internaldafny.types.DigestAlgorithm _8_hashAlgorithm;
      _8_hashAlgorithm = software.amazon.cryptography.primitives.internaldafny.types.DigestAlgorithm.create_SHA__384();
      software.amazon.cryptography.primitives.internaldafny.types.DigestInput _9_identifierDigestInput;
      _9_identifierDigestInput = software.amazon.cryptography.primitives.internaldafny.types.DigestInput.create(_8_hashAlgorithm, _7_identifier);
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.primitives.internaldafny.types.Error> _10_maybeCacheDigest;
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.primitives.internaldafny.types.Error> _out0;
      _out0 = (client).Digest(_9_identifierDigestInput);
      _10_maybeCacheDigest = _out0;
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _11_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
      _11_valueOrError1 = (_10_maybeCacheDigest).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.primitives.internaldafny.types.Error, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_12_e_boxed0) -> {
        software.amazon.cryptography.primitives.internaldafny.types.Error _12_e = ((software.amazon.cryptography.primitives.internaldafny.types.Error)(java.lang.Object)(_12_e_boxed0));
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error.create_AwsCryptographyPrimitives(_12_e);
      }));
      if ((_11_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_11_valueOrError1).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())));
        return output;
      }
      dafny.DafnySequence<? extends java.lang.Byte> _13_cacheDigest;
      _13_cacheDigest = (_11_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      software.amazon.cryptography.materialproviders.internaldafny.types.GetCacheEntryInput _14_getCacheInput;
      _14_getCacheInput = software.amazon.cryptography.materialproviders.internaldafny.types.GetCacheEntryInput.create(_13_cacheDigest, Wrappers_Compile.Option.<java.lang.Long>create_None(BoundedInts_Compile.int64._typeDescriptor()));
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.GetCacheEntryOutput, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _15_getCacheOutput;
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.GetCacheEntryOutput, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out1;
      _out1 = ((this).dtor_cache()).GetCacheEntry(_14_getCacheInput);
      _15_getCacheOutput = _out1;
      if (((_15_getCacheOutput).is_Failure()) && (!(((_15_getCacheOutput).dtor_error()).is_EntryDoesNotExist()))) {
        output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error.create_AwsCryptographyMaterialProviders((_15_getCacheOutput).dtor_error()));
        return output;
      }
      if (((_15_getCacheOutput).is_Failure()) || (!((this).cacheEntryWithinLimits(((_15_getCacheOutput).dtor_value()).dtor_creationTime(), now, cacheTTL)))) {
        Wrappers_Compile.Result<software.amazon.cryptography.keystore.internaldafny.types.GetBeaconKeyOutput, software.amazon.cryptography.keystore.internaldafny.types.Error> _16_maybeRawBeaconKeyMaterials;
        Wrappers_Compile.Result<software.amazon.cryptography.keystore.internaldafny.types.GetBeaconKeyOutput, software.amazon.cryptography.keystore.internaldafny.types.Error> _out2;
        _out2 = ((this).dtor_store()).GetBeaconKey(software.amazon.cryptography.keystore.internaldafny.types.GetBeaconKeyInput.create(keyId));
        _16_maybeRawBeaconKeyMaterials = _out2;
        Wrappers_Compile.Result<software.amazon.cryptography.keystore.internaldafny.types.GetBeaconKeyOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _17_valueOrError2 = Wrappers_Compile.Result.<software.amazon.cryptography.keystore.internaldafny.types.GetBeaconKeyOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.keystore.internaldafny.types.GetBeaconKeyOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.keystore.internaldafny.types.GetBeaconKeyOutput.Default());
        _17_valueOrError2 = (_16_maybeRawBeaconKeyMaterials).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(software.amazon.cryptography.keystore.internaldafny.types.GetBeaconKeyOutput._typeDescriptor(), software.amazon.cryptography.keystore.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.keystore.internaldafny.types.Error, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_18_e_boxed0) -> {
          software.amazon.cryptography.keystore.internaldafny.types.Error _18_e = ((software.amazon.cryptography.keystore.internaldafny.types.Error)(java.lang.Object)(_18_e_boxed0));
          return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error.create_AwsCryptographyKeyStore(_18_e);
        }));
        if ((_17_valueOrError2).IsFailure(software.amazon.cryptography.keystore.internaldafny.types.GetBeaconKeyOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_17_valueOrError2).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(software.amazon.cryptography.keystore.internaldafny.types.GetBeaconKeyOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())));
          return output;
        }
        software.amazon.cryptography.keystore.internaldafny.types.GetBeaconKeyOutput _19_rawBeaconKeyMaterials;
        _19_rawBeaconKeyMaterials = (_17_valueOrError2).Extract(software.amazon.cryptography.keystore.internaldafny.types.GetBeaconKeyOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>> _20_key;
        _20_key = ((_19_rawBeaconKeyMaterials).dtor_beaconKeyMaterials()).dtor_beaconKey();
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _21_valueOrError3 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        _21_valueOrError3 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (_20_key).is_Some(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("beacon key unexpectedly empty")));
        if ((_21_valueOrError3).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_21_valueOrError3).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())));
          return output;
        }
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _22_valueOrError4 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out3;
        _out3 = (this).getAllKeys(stdNames, (_20_key).dtor_value());
        _22_valueOrError4 = _out3;
        if ((_22_valueOrError4).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_22_valueOrError4).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())));
          return output;
        }
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _23_keyMap;
        _23_keyMap = (_22_valueOrError4).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        software.amazon.cryptography.keystore.internaldafny.types.BeaconKeyMaterials _24_beaconKeyMaterials;
        software.amazon.cryptography.keystore.internaldafny.types.BeaconKeyMaterials _25_dt__update__tmp_h0 = (_19_rawBeaconKeyMaterials).dtor_beaconKeyMaterials();
        Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> _26_dt__update_hhmacKeys_h0 = Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), _23_keyMap);
        Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>> _27_dt__update_hbeaconKey_h0 = Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_None(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
        _24_beaconKeyMaterials = software.amazon.cryptography.keystore.internaldafny.types.BeaconKeyMaterials.create((_25_dt__update__tmp_h0).dtor_beaconKeyIdentifier(), (_25_dt__update__tmp_h0).dtor_encryptionContext(), _27_dt__update_hbeaconKey_h0, _26_dt__update_hhmacKeys_h0);
        software.amazon.cryptography.materialproviders.internaldafny.types.PutCacheEntryInput _28_putCacheEntryInput;
        _28_putCacheEntryInput = software.amazon.cryptography.materialproviders.internaldafny.types.PutCacheEntryInput.create(_13_cacheDigest, software.amazon.cryptography.materialproviders.internaldafny.types.Materials.create_BeaconKey(_24_beaconKeyMaterials), now, (this).PosLongAdd(now, cacheTTL), Wrappers_Compile.Option.<java.lang.Integer>create_None(software.amazon.cryptography.materialproviders.internaldafny.types.PositiveInteger._typeDescriptor()), Wrappers_Compile.Option.<java.lang.Integer>create_None(software.amazon.cryptography.materialproviders.internaldafny.types.PositiveInteger._typeDescriptor()));
        Wrappers_Compile.Result<dafny.Tuple0, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _29_putResult;
        Wrappers_Compile.Result<dafny.Tuple0, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out4;
        _out4 = ((this).dtor_cache()).PutCacheEntry(_28_putCacheEntryInput);
        _29_putResult = _out4;
        if (((_29_putResult).is_Failure()) && (!(((_29_putResult).dtor_error()).is_EntryAlreadyExists()))) {
          output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error.create_AwsCryptographyMaterialProviders((_29_putResult).dtor_error()));
          return output;
        }
        output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), _23_keyMap);
        return output;
      } else {
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _30_valueOrError5 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        _30_valueOrError5 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((((((_15_getCacheOutput).dtor_value()).dtor_materials()).is_BeaconKey()) && ((((((_15_getCacheOutput).dtor_value()).dtor_materials()).dtor_BeaconKey()).dtor_hmacKeys()).is_Some())) && ((((((_15_getCacheOutput).dtor_value()).dtor_materials()).dtor_BeaconKey()).dtor_beaconKeyIdentifier()).equals(keyId))) && ((((((_15_getCacheOutput).dtor_value()).dtor_materials()).dtor_BeaconKey()).dtor_hmacKeys()).is_Some()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid Material Type.")));
        if ((_30_valueOrError5).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_30_valueOrError5).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())));
          return output;
        }
        output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (((((_15_getCacheOutput).dtor_value()).dtor_materials()).dtor_BeaconKey()).dtor_hmacKeys()).dtor_value());
        return output;
      }
    }
    return output;
  }
  public Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> getAllKeys(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> stdNames, dafny.DafnySequence<? extends java.lang.Byte> key)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
    if(true) {
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
      _out0 = __default.GetAllKeys((this).dtor_client(), stdNames, key);
      output = _out0;
    }
    return output;
  }
}
