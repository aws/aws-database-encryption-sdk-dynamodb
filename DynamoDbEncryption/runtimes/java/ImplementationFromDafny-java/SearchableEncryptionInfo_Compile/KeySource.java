// Class KeySource
// Dafny class KeySource compiled into Java
package SearchableEncryptionInfo_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;
import DynamoDbEncryptionUtil_Compile.*;
import DynamoDbNormalizeNumber_Compile.*;
import DynamoToStruct_Compile.*;
import DynamoDbEncryptionBranchKeyIdSupplier_Compile.*;
import AwsCryptographyDynamoDbEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.*;
import StructuredEncryptionUtil_Compile.*;
import Sets_Compile.*;
import StructuredEncryptionPaths_Compile.*;
import StructuredEncryptionHeader_Compile.*;
import StructuredEncryptionFooter_Compile.*;
import StructuredEncryptionCrypt_Compile.*;
import Maps_Compile.*;
import AwsCryptographyStructuredEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.StructuredEncryption.*;
import TermLoc_Compile.*;
import DdbVirtualFields_Compile.*;
import BaseBeacon_Compile.*;
import CompoundBeacon_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class KeySource {
  public Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient _client;
  public Dafny.Aws.Cryptography.KeyStore.Types.IKeyStoreClient _store;
  public KeyLocation _keyLoc;
  public Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsCache _cache;
  public int _cacheTTL;
  public KeySource (Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, Dafny.Aws.Cryptography.KeyStore.Types.IKeyStoreClient store, KeyLocation keyLoc, Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsCache cache, int cacheTTL) {
    this._client = client;
    this._store = store;
    this._keyLoc = keyLoc;
    this._cache = cache;
    this._cacheTTL = cacheTTL;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    KeySource o = (KeySource)other;
    return true && this._client == o._client && this._store == o._store && java.util.Objects.equals(this._keyLoc, o._keyLoc) && this._cache == o._cache && this._cacheTTL == o._cacheTTL;
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
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("SearchableEncryptionInfo_Compile.KeySource.KeySource");
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
    s.append(")");
    return s.toString();
  }

  private static final KeySource theDefault = SearchableEncryptionInfo_Compile.KeySource.create(null, null, KeyLocation.Default(), null, 0);
  public static KeySource Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<KeySource> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(KeySource.class, () -> Default());
  public static dafny.TypeDescriptor<KeySource> _typeDescriptor() {
    return (dafny.TypeDescriptor<KeySource>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static KeySource create(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, Dafny.Aws.Cryptography.KeyStore.Types.IKeyStoreClient store, KeyLocation keyLoc, Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsCache cache, int cacheTTL) {
    return new KeySource(client, store, keyLoc, cache, cacheTTL);
  }
  public static KeySource create_KeySource(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, Dafny.Aws.Cryptography.KeyStore.Types.IKeyStoreClient store, KeyLocation keyLoc, Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsCache cache, int cacheTTL) {
    return create(client, store, keyLoc, cache, cacheTTL);
  }
  public boolean is_KeySource() { return true; }
  public Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient dtor_client() {
    return this._client;
  }
  public Dafny.Aws.Cryptography.KeyStore.Types.IKeyStoreClient dtor_store() {
    return this._store;
  }
  public KeyLocation dtor_keyLoc() {
    return this._keyLoc;
  }
  public Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsCache dtor_cache() {
    return this._cache;
  }
  public int dtor_cacheTTL() {
    return this._cacheTTL;
  }
  public Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> getKeyMap(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> stdNames, DynamoDbEncryptionUtil_Compile.MaybeKeyId keyId)
  {
    Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(DynamoDbEncryptionUtil_Compile.MaybeKeyMap.Default());
    if(true) {
      if (((this).dtor_keyLoc()).is_SingleLoc()) {
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _965_valueOrError0 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default();
        _965_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), (keyId).is_DontUseKeyId(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("KeyID should not be supplied with a SingleKeyStore")));
        if ((_965_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          output = (_965_valueOrError0).<DynamoDbEncryptionUtil_Compile.MaybeKeyMap>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor());
          return output;
        }
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _966_theMap;
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _967_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out35;
        _out35 = (this).getKeysCache(stdNames, ((this).dtor_keyLoc()).dtor_keyId());
        _967_valueOrError1 = _out35;
        if ((_967_valueOrError1).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          output = (_967_valueOrError1).<DynamoDbEncryptionUtil_Compile.MaybeKeyMap>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor());
          return output;
        }
        _966_theMap = (_967_valueOrError1).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        output = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_Keys(_966_theMap));
        return output;
      } else if (((this).dtor_keyLoc()).is_LiteralLoc()) {
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _968_valueOrError2 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default();
        _968_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), (keyId).is_DontUseKeyId(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("KeyID should not be supplied with a LiteralKeyStore")));
        if ((_968_valueOrError2).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          output = (_968_valueOrError2).<DynamoDbEncryptionUtil_Compile.MaybeKeyMap>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor());
          return output;
        }
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _969_theMap;
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _970_valueOrError3 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out36;
        _out36 = (this).getKeysLiteral();
        _970_valueOrError3 = _out36;
        if ((_970_valueOrError3).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          output = (_970_valueOrError3).<DynamoDbEncryptionUtil_Compile.MaybeKeyMap>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor());
          return output;
        }
        _969_theMap = (_970_valueOrError3).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        output = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_Keys(_969_theMap));
        return output;
      } else {
        DynamoDbEncryptionUtil_Compile.MaybeKeyId _source13 = keyId;
        if (_source13.is_DontUseKeyId()) {
          output = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("KeyID must not be supplied with a MultiKeyStore")));
          return output;
        } else if (_source13.is_ShouldHaveKeyId()) {
          output = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_ShouldHaveKeys());
          return output;
        } else {
          dafny.DafnySequence<? extends Character> _971___mcc_h0 = ((DynamoDbEncryptionUtil_Compile.MaybeKeyId_KeyId)_source13)._value;
          dafny.DafnySequence<? extends Character> _972_id = _971___mcc_h0;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _973_theMap;
          Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _974_valueOrError4 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
          Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out37;
          _out37 = (this).getKeysCache(stdNames, _972_id);
          _974_valueOrError4 = _out37;
          if ((_974_valueOrError4).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
            output = (_974_valueOrError4).<DynamoDbEncryptionUtil_Compile.MaybeKeyMap>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyMap._typeDescriptor());
            return output;
          }
          _973_theMap = (_974_valueOrError4).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          output = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyMap, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_Keys(_973_theMap));
          return output;
        }
      }
    }
    return output;
  }
  public Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> getKeysLiteral()
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
    output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(((this).dtor_keyLoc()).dtor_keys());
    return output;
  }
  public Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> getKeysCache(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> stdNames, dafny.DafnySequence<? extends Character> keyId)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
    if(true) {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _975_keyIdBytesR;
      _975_keyIdBytesR = UTF8.__default.Encode(keyId);
      dafny.DafnySequence<? extends java.lang.Byte> _976_keyIdBytes;
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _977_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(UTF8.ValidUTF8Bytes.defaultValue());
      _977_valueOrError0 = (_975_keyIdBytesR).<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>MapFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(_978_e_boxed0) -> {
        dafny.DafnySequence<? extends Character> _978_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_978_e_boxed0));
        return DynamoDbEncryptionUtil_Compile.__default.E(_978_e);
      }));
      if ((_977_valueOrError0).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        output = (_977_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())));
        return output;
      }
      _976_keyIdBytes = (_977_valueOrError0).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      Dafny.Aws.Cryptography.MaterialProviders.Types.GetCacheEntryInput _979_getCacheInput;
      _979_getCacheInput = Dafny.Aws.Cryptography.MaterialProviders.Types.GetCacheEntryInput.create(_976_keyIdBytes, Wrappers_Compile.Option.<java.lang.Long>create_None());
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.GetCacheEntryOutput, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _980_getCacheOutput;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.GetCacheEntryOutput, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _out38;
      _out38 = ((this).dtor_cache()).GetCacheEntry(_979_getCacheInput);
      _980_getCacheOutput = _out38;
      if ((_980_getCacheOutput).is_Failure()) {
        Wrappers_Compile.Result<Dafny.Aws.Cryptography.KeyStore.Types.GetBeaconKeyOutput, Dafny.Aws.Cryptography.KeyStore.Types.Error> _981_maybeRawBeaconKeyMaterials;
        Wrappers_Compile.Result<Dafny.Aws.Cryptography.KeyStore.Types.GetBeaconKeyOutput, Dafny.Aws.Cryptography.KeyStore.Types.Error> _out39;
        _out39 = ((this).dtor_store()).GetBeaconKey(Dafny.Aws.Cryptography.KeyStore.Types.GetBeaconKeyInput.create(keyId));
        _981_maybeRawBeaconKeyMaterials = _out39;
        Dafny.Aws.Cryptography.KeyStore.Types.GetBeaconKeyOutput _982_rawBeaconKeyMaterials;
        Wrappers_Compile.Result<Dafny.Aws.Cryptography.KeyStore.Types.GetBeaconKeyOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _983_valueOrError1 = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.KeyStore.Types.GetBeaconKeyOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(Dafny.Aws.Cryptography.KeyStore.Types.GetBeaconKeyOutput.Default());
        _983_valueOrError1 = (_981_maybeRawBeaconKeyMaterials).<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>MapFailure(Dafny.Aws.Cryptography.KeyStore.Types.GetBeaconKeyOutput._typeDescriptor(), Dafny.Aws.Cryptography.KeyStore.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.KeyStore.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(_984_e_boxed0) -> {
          Dafny.Aws.Cryptography.KeyStore.Types.Error _984_e = ((Dafny.Aws.Cryptography.KeyStore.Types.Error)(java.lang.Object)(_984_e_boxed0));
          return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error.create_AwsCryptographyKeyStore(_984_e);
        }));
        if ((_983_valueOrError1).IsFailure(Dafny.Aws.Cryptography.KeyStore.Types.GetBeaconKeyOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          output = (_983_valueOrError1).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(Dafny.Aws.Cryptography.KeyStore.Types.GetBeaconKeyOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())));
          return output;
        }
        _982_rawBeaconKeyMaterials = (_983_valueOrError1).Extract(Dafny.Aws.Cryptography.KeyStore.Types.GetBeaconKeyOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        dafny.DafnySequence<? extends java.lang.Byte> _985_key;
        _985_key = (_982_rawBeaconKeyMaterials).dtor_beaconKey();
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _986_keyMap;
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _987_valueOrError2 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out40;
        _out40 = (this).getAllKeys(stdNames, _985_key);
        _987_valueOrError2 = _out40;
        if ((_987_valueOrError2).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          output = (_987_valueOrError2).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())));
          return output;
        }
        _986_keyMap = (_987_valueOrError2).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        Dafny.Aws.Cryptography.MaterialProviders.Types.BeaconKeyMaterials _988_beaconKeyMaterials;
        _988_beaconKeyMaterials = Dafny.Aws.Cryptography.MaterialProviders.Types.BeaconKeyMaterials.create(keyId, Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_Some((_982_rawBeaconKeyMaterials).dtor_beaconKey()), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>create_Some(_986_keyMap));
        long _989_now;
        long _out41;
        _out41 = Time.__default.CurrentRelativeTime();
        _989_now = _out41;
        Dafny.Aws.Cryptography.MaterialProviders.Types.PutCacheEntryInput _990_putCacheEntryInput;
        _990_putCacheEntryInput = Dafny.Aws.Cryptography.MaterialProviders.Types.PutCacheEntryInput.create(_976_keyIdBytes, Dafny.Aws.Cryptography.MaterialProviders.Types.Materials.create_BeaconKey(_988_beaconKeyMaterials), _989_now, (long)  ((_989_now) + (java.lang.Integer.toUnsignedLong((this).dtor_cacheTTL()))), Wrappers_Compile.Option.<java.lang.Integer>create_None(), Wrappers_Compile.Option.<java.lang.Integer>create_None());
        Wrappers_Compile.Result<dafny.Tuple0, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _991___v0;
        Wrappers_Compile.Result<dafny.Tuple0, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _out42;
        _out42 = ((this).dtor_cache()).PutCacheEntry(_990_putCacheEntryInput);
        _991___v0 = _out42;
        output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(_986_keyMap);
        return output;
      } else {
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _992_valueOrError3 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default();
        _992_valueOrError3 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ((((((_980_getCacheOutput).dtor_value()).dtor_materials()).is_BeaconKey()) && ((((((_980_getCacheOutput).dtor_value()).dtor_materials()).dtor_BeaconKey()).dtor_hmacKeys()).is_Some())) && ((((((_980_getCacheOutput).dtor_value()).dtor_materials()).dtor_BeaconKey()).dtor_beaconKeyIdentifier()).equals(keyId))) && ((((((_980_getCacheOutput).dtor_value()).dtor_materials()).dtor_BeaconKey()).dtor_hmacKeys()).is_Some()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid Material Type.")));
        if ((_992_valueOrError3).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          output = (_992_valueOrError3).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())));
          return output;
        }
        output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success((((((_980_getCacheOutput).dtor_value()).dtor_materials()).dtor_BeaconKey()).dtor_hmacKeys()).dtor_value());
        return output;
      }
    }
    return output;
  }
  public Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> getAllKeys(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> stdNames, dafny.DafnySequence<? extends java.lang.Byte> key)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
    if(true) {
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out43;
      _out43 = __default.GetAllKeys((this).dtor_client(), stdNames, key);
      output = _out43;
    }
    return output;
  }
}
