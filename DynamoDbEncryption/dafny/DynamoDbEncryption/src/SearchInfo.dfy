// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "Util.dfy"
include "Beacon.dfy"
include "CompoundBeacon.dfy"
include "Virtual.dfy"

module SearchableEncryptionInfo {
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import BaseBeacon
  import CompoundBeacon
  import opened TermLoc
  import opened DynamoDbEncryptionUtil
  import opened DdbVirtualFields
  import opened StandardLibrary
  import opened Wrappers
  import opened StandardLibrary.UInt
  import SortedSets
  import Sets
  import UTF8
  import opened Time
  import KeyStore = AwsCryptographyKeyStoreTypes
  import Primitives = AtomicPrimitives
  import Prim = AwsCryptographyPrimitivesTypes
  import MP = AwsCryptographyMaterialProvidersTypes
  import KeyStoreTypes = AwsCryptographyKeyStoreTypes
  import SE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import opened CacheConstants
  import UUID
  import Digest

  //= specification/searchable-encryption/search-config.md#version-number
  //= type=implication
  //# A version number MUST be `1`.
  newtype VersionNumber = x : int | x == 1 witness 1

  type ValidSearchInfo = x : SearchInfo | x.ValidState() witness *

  type ValidStore = x : KeyStoreTypes.IKeyStoreClient | x.ValidState() witness *

  method GetAllKeys(client : Primitives.AtomicPrimitivesClient, stdNames : seq<string>, key : Bytes) returns (output : Result<HmacKeyMap, Error>)
    requires Seq.HasNoDuplicates(stdNames)
    modifies client.Modifies
    requires client.ValidState()
    ensures client.History.Digest == old(client.History.Digest)
    ensures client.ValidState()
  {
    var newKeys :- GetHmacKeys(client, stdNames, stdNames, key);
    return Success(newKeys);
  }

  method {:tailrecursion} GetHmacKeys(
    client : Primitives.AtomicPrimitivesClient,
    allKeys : seq<string>,
    keysLeft : seq<string>,
    key : Bytes,
    acc : HmacKeyMap := map[]
  )
    returns (output : Result<HmacKeyMap, Error>)
    requires Seq.HasNoDuplicates(allKeys)
    requires Seq.HasNoDuplicates(keysLeft)
    requires forall k <- allKeys :: k in keysLeft || k in acc
    requires forall k <- keysLeft :: k in allKeys
    ensures client.History.Digest == old(client.History.Digest)
    ensures output.Success? ==> forall k <- allKeys :: k in output.value
    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    if |keysLeft| == 0 {
      return Success(acc);
    } else {
      //= specification/searchable-encryption/search-config.md#get-beacon-key-materials
      //# For every [standard beacons](beacons.md#standard-beacon-initialization) an HMAC key
      //# MUST be generated in accordance with [HMAC Key Generation](#hmac-key-generation).
      var newKey :- GetBeaconKey(client, key, keysLeft[0]);
      reveal Seq.HasNoDuplicates();
             //= specification/searchable-encryption/search-config.md#get-beacon-key-materials
             //# [Beacon Key Materials](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/structures.md#beacon-key-materials) MUST be generated
             //# with the [beacon key id](#beacon-key-id) equal to the `beacon key id`
             //# and the [HMAC Keys](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/structures.md#hmac-keys) equal to a map
             //# of every [standard beacons](beacons.md#standard-beacon-initialization) name to its generated HMAC key.
      output := GetHmacKeys(client, allKeys, keysLeft[1..], key, acc[keysLeft[0] := newKey]);
    }
  }

  // convert persistent key to the derived key for this beacon
  method GetBeaconKey(client : Primitives.AtomicPrimitivesClient, key : Bytes, name : string)
    returns (output : Result<Bytes, Error>)
    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
    ensures client.History.Digest == old(client.History.Digest)

    ensures output.Success? ==>
              && var fullName := "AWS_DBE_SCAN_BEACON" + name;
              && UTF8.Encode(fullName).Success?
              && var info := UTF8.Encode(fullName).value;
              && var oldHistory := old(client.History.Hkdf);
              && var newHistory := client.History.Hkdf;
              && |newHistory| == |oldHistory|+1
              && Seq.Last(newHistory).output.Success?
              && var hkdfInput := Seq.Last(newHistory).input;
              && var hkdfOutput := Seq.Last(newHistory).output;
              //= specification/searchable-encryption/search-config.md#hmac-key-generation
              //= type=implication
              //# For each beacon HKDF-SHA512 MUST be used
              //# to calculate the key for individual beacon,
              //# using the beacon key retrieved above as the initial key material with no salt.
              && hkdfInput.digestAlgorithm == Prim.SHA_512
              && hkdfInput.salt == None
              && hkdfInput.ikm == key
                 //= specification/searchable-encryption/search-config.md#hmac-key-generation
                 //= type=implication
                 //# The `info` MUST be the concatenation of "AWS_DBE_SCAN_BEACON" encoded as UTF8
                 //# and the beacon name.
              && hkdfInput.info == info
                 //= specification/searchable-encryption/search-config.md#hmac-key-generation
                 //= type=implication
                 //# The `expectedLength` MUST be 64 bytes.
              && hkdfInput.expectedLength == 64
  {
    var info :- UTF8.Encode("AWS_DBE_SCAN_BEACON" + name).MapFailure(e => E(e));
    var keyR := client.Hkdf(Prim.HkdfInput(
                              digestAlgorithm := Prim.SHA_512,
                              salt := None,
                              ikm := key,
                              info := info,
                              expectedLength := 64
                            ));
    var newKey :- keyR.MapFailure(e => AwsCryptographyPrimitives(e));
    return Success(newKey);
  }

  // Generates a new random UUID converted to UTF8 bytes
  method GenerateUuidBytes() returns (output : Result<seq<uint8>, Error>)
  {
    var uuid? := UUID.GenerateUUID();

    var uuid :- uuid?
    .MapFailure(e => Error.DynamoDbEncryptionException(message := e));

    output := UUID.ToByteArray(uuid)
    .MapFailure(e => Error.DynamoDbEncryptionException(message := e));
  }

  datatype KeyLocation =
    | LiteralLoc (keys: HmacKeyMap)
    | SingleLoc (keyId: string)
    | MultiLoc (keyName : string, deleteKey : bool)

  datatype KeySource = KeySource(
    client : Primitives.AtomicPrimitivesClient,
    store : ValidStore,
    keyLoc : KeyLocation,
    cache : MP.ICryptographicMaterialsCache,
    cacheTTL : uint32,
    partitionIdBytes : seq<uint8>,
    logicalKeyStoreNameBytes : seq<uint8>
  ) {
    function Modifies() : set<object> {
      client.Modifies + store.Modifies + cache.Modifies
    }
    predicate ValidState() {
      && client.ValidState()
      && store.ValidState()
      && cache.ValidState()
      && store.Modifies !! cache.Modifies
    }
    method getKeyMap(stdNames : seq<string>, keyId : MaybeKeyId) returns (output : Result<MaybeKeyMap, Error>)
      requires Seq.HasNoDuplicates(stdNames)
      requires ValidState()
      ensures ValidState()
      modifies Modifies()
    {
      if keyLoc.SingleLoc? {
        :- Need(keyId.DontUseKeyId?, E("KeyID should not be supplied with a SingleKeyStore"));
        var now := Time.GetCurrent();
        var theMap :- getKeysCache(
          client,
          stdNames,
          keyLoc.keyId,
          cacheTTL as MP.PositiveLong,
          partitionIdBytes,
          logicalKeyStoreNameBytes,
          now as MP.PositiveLong
        );
        return Success(Keys(theMap));
      } else if keyLoc.LiteralLoc? {
        :- Need(keyId.DontUseKeyId?, E("KeyID should not be supplied with a LiteralKeyStore"));
        var theMap :- getKeysLiteral();
        return Success(Keys(theMap));
      } else {
        match keyId {
          case DontUseKeyId => return Failure(E("Fixed KeyID must not be supplied with a MultiKeyStore"));
          case ShouldHaveKeyId => return Success(ShouldHaveKeys);
          case KeyId(id) =>
            var now := Time.GetCurrent();
            var theMap :- getKeysCache(
              client,
              stdNames,
              id,
              cacheTTL as MP.PositiveLong,
              partitionIdBytes,
              logicalKeyStoreNameBytes,
              now as MP.PositiveLong
            );
            return Success(Keys(theMap));
        }
      }
    }

    // We add this axiom here because verifying the mutability of the share state of the
    // cache. Dafny does not support concurrency and proving the state of mutable frames
    // is complicated.
    lemma {:axiom} verifyValidStateCache (cmc: MP.ICryptographicMaterialsCache) ensures cmc.ValidState()

    method getKeysLiteral()
      returns (output : Result<HmacKeyMap, Error>)
      requires keyLoc.LiteralLoc?
    {
      return Success(keyLoc.keys);
    }

    function method PosLongAdd(x : MP.PositiveLong, y : MP.PositiveLong) : MP.PositiveLong
    {
      assert MP.IsValid_PositiveLong(x);
      assert MP.IsValid_PositiveLong(y);
      if x as nat + y as nat < INT64_MAX_LIMIT then
        x + y
      else
        INT64_MAX_LIMIT as MP.PositiveLong
    }
    function method PosLongSub(x : MP.PositiveLong, y : MP.PositiveLong) : MP.PositiveLong
    {
      assert MP.IsValid_PositiveLong(x);
      assert MP.IsValid_PositiveLong(y);
      if x <= y then
        0
      else
        x - y
    }

    // Checks if (time_now - cache creation time of the extracted cache entry) is less than the allowed
    // TTL of the current Beacon Key Source calling the getEntry method from the cache.
    // Mitigates risk if another Beacon Key Source wrote the entry with a longer TTL.
    predicate method cacheEntryWithinLimits(
      creationTime: MP.PositiveLong,
      now: MP.PositiveLong,
      ttlSeconds: MP.PositiveLong
    ): (output: bool)
    {
      if now <= creationTime then
        true
      else
        PosLongSub(now, creationTime) <= ttlSeconds as MP.PositiveLong
    }

    method getKeysCache(
      client : Primitives.AtomicPrimitivesClient,
      stdNames : seq<string>,
      keyId : string,
      cacheTTL : MP.PositiveLong,
      partitionIdBytes : seq<uint8>,
      logicalKeyStoreNameBytes : seq<uint8>,
      now : MP.PositiveLong
    )
      returns (output : Result<HmacKeyMap, Error>)
      requires Seq.HasNoDuplicates(stdNames)
      requires ValidState()
      requires client.ValidState()
      modifies Modifies()
      modifies client.Modifies
      ensures ValidState()
      ensures client.ValidState()

      //= specification/searchable-encryption/search-config.md#get-beacon-key-materials
      //= type=implication
      //# Get beacon key MUST Call the associated [Key Store Cache](#key-store-cache)
      //# [Get Cache Entry](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/local-cryptographic-materials-cache.md#get-cache-entry)
      //# with the cache identifier defined in the [Searchable Encryption Cache Identifier](#searchable-encryption-cache-identifier) section.
      ensures output.Success? ==>
                && var oldGetCacheHistory := old(cache.History.GetCacheEntry);
                && var newGetCacheHistory := cache.History.GetCacheEntry;
                && |newGetCacheHistory| == |oldGetCacheHistory|+1
                && var getCacheInput := Seq.Last(newGetCacheHistory).input;
                && var getCacheOutput := Seq.Last(newGetCacheHistory).output;
                && UTF8.Encode(keyId).Success?

                && var oldClientHistory := old(client.History.Digest);
                && var newClientHistory := client.History.Digest;
                && |newClientHistory| == |oldClientHistory|+1
                && var identifier := RESOURCE_ID_HIERARCHICAL_KEYRING + NULL_BYTE + SCOPE_ID_SEARCHABLE_ENCRYPTION + NULL_BYTE + partitionIdBytes + NULL_BYTE + logicalKeyStoreNameBytes + NULL_BYTE + UTF8.Encode(keyId).value;
                && var digestInput := Seq.Last(newClientHistory).input;
                && var digestOutput := Seq.Last(newClientHistory).output;
                && digestInput.message == identifier
                && (digestOutput.Success? ==> (getCacheInput.identifier == digestOutput.value))

                //= specification/searchable-encryption/search-config.md#get-beacon-key-materials
                //= type=implication
                //# If a [cache entry](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#cache-entry)
                //# exists, get beacon key MUST return the [entry materials](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#materials).
                && (getCacheOutput.Success? && cacheEntryWithinLimits(
                      creationTime := getCacheOutput.value.creationTime,
                      now := now,
                      ttlSeconds := cacheTTL
                    ) ==>
                      && getCacheOutput.value.materials.BeaconKey?
                      && getCacheOutput.value.materials.BeaconKey.hmacKeys.Some?
                      && output.value == getCacheOutput.value.materials.BeaconKey.hmacKeys.value)

                && (getCacheOutput.Failure? || !cacheEntryWithinLimits(
                      creationTime := getCacheOutput.value.creationTime,
                      now := now,
                      ttlSeconds := cacheTTL
                    ) ==>
                      && var oldGetHistory := old(store.History.GetBeaconKey);
                      && var newGetHistory := store.History.GetBeaconKey;
                      && |newGetHistory| == |oldGetHistory|+1
                         //= specification/searchable-encryption/search-config.md#get-beacon-key-materials
                         //= type=implication
                         //# If `GetBeaconKey` fails get beacon key MUST fail.
                      && Seq.Last(newGetHistory).output.Success?
                      && var storeInput := Seq.Last(newGetHistory).input;
                      && var storeOutput := Seq.Last(newGetHistory).output;
                      //= specification/searchable-encryption/search-config.md#get-beacon-key-materials
                      //= type=implication
                      //# The `beacon key id` MUST be passed to the configured `KeyStore`'s `GetBeaconKey` operation.
                      && storeInput.branchKeyIdentifier == keyId
                      && var oldPutCacheHistory := old(cache.History.PutCacheEntry);
                      && var newPutCacheHistory := cache.History.PutCacheEntry;
                      && |newPutCacheHistory| == |oldPutCacheHistory|+1
                      && (
                           var putCacheOutput := Seq.Last(newPutCacheHistory).output;
                           || putCacheOutput.Success?
                           || putCacheOutput.error.EntryAlreadyExists?
                         )
                      && var putCacheInput := Seq.Last(newPutCacheHistory).input;
                      && var putCacheOutput := Seq.Last(newPutCacheHistory).output;

                      //= specification/searchable-encryption/search-config.md#get-beacon-key-materials
                      //# The Searchable Encryption cache identifier
                      //# used to [Put Cache Entry](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/local-cryptographic-materials-cache.md#put-cache-entry)
                      //# MUST be the same
                      //# as the identifier that was used to attempt [Get Cache Entry](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/local-cryptographic-materials-cache.md#get-cache-entry).
                      && putCacheInput.identifier == getCacheInput.identifier

                      //= specification/searchable-encryption/search-config.md#get-beacon-key-materials
                      //= type=implication
                      //# These cached materials MUST be returned.
                      && (putCacheInput.materials.BeaconKey? ==> putCacheInput.materials.BeaconKey.hmacKeys == Some(output.value))
                   )
    {

      // Resource ID: Hierarchical Keyring [0x02]
      var resourceId : seq<uint8> := RESOURCE_ID_HIERARCHICAL_KEYRING;

      // Scope ID: Searchable Encryption [0x03]
      var scopeId : seq<uint8> := SCOPE_ID_SEARCHABLE_ENCRYPTION;

      // Create the Suffix
      var keyIdBytesR := UTF8.Encode(keyId);
      var keyIdBytes :- keyIdBytesR.MapFailure(e => E(e));
      var suffix : seq<uint8> := logicalKeyStoreNameBytes + NULL_BYTE + keyIdBytes;

      // Append Resource Id, Scope Id, Partition Id, and Suffix to create the cache identifier
      var identifier := resourceId + NULL_BYTE + scopeId + NULL_BYTE + partitionIdBytes + NULL_BYTE + suffix;

      // Take a SHA384 of the cache identifier
      var hashAlgorithm := Prim.DigestAlgorithm.SHA_384;

      var identifierDigestInput := Prim.DigestInput(
        digestAlgorithm := hashAlgorithm, message := identifier
      );
      var maybeCacheDigest := client.Digest(identifierDigestInput);
      var cacheDigest :- maybeCacheDigest.MapFailure(e => AwsCryptographyPrimitives(e));

      // Use the SHA384 of the identifier as the cache identifier
      var getCacheInput := MP.GetCacheEntryInput(identifier := cacheDigest, bytesUsed := None);
      verifyValidStateCache(cache);
      var getCacheOutput := cache.GetCacheEntry(getCacheInput);
      // If error is not EntryDoesNotExist, return failure
      if (getCacheOutput.Failure? && !getCacheOutput.error.EntryDoesNotExist?) {
        return Failure(AwsCryptographyMaterialProviders(AwsCryptographyMaterialProviders:=getCacheOutput.error));
      }

      assert
        && |client.History.Digest| == |old(client.History.Digest)| + 1
        && Seq.Last(client.History.Digest).input.message == identifier
        && Seq.Last(cache.History.GetCacheEntry).input.identifier == Seq.Last(client.History.Digest).output.value
      by {
        assume{:axiom} client.Modifies !! cache.Modifies;
      }

      //= specification/searchable-encryption/search-config.md#get-beacon-key-materials
      //# If using a `Shared` cache across multiple [Beacon Key Sources](#beacon-key-source),
      //# different [Beacon Key Sources](#beacon-key-source) having the same `beaconKey` can have different TTLs.
      //# In such a case, the expiry time in the cache is set according to the [Beacon Key Source](#beacon-key-source) that populated the cache.
      //# There MUST be a check (cacheEntryWithinLimits) to make sure that for the cache entry found, who's TTL has NOT expired,
      //# `time.now() - cacheEntryCreationTime <= ttlSeconds` is true and
      //# valid for TTL of the [Beacon Key Source](#beacon-key-source) getting the cache entry.
      //# If this is NOT true, then we MUST treat the cache entry as expired.
      if getCacheOutput.Failure? || !cacheEntryWithinLimits(
           creationTime := getCacheOutput.value.creationTime,
           now := now,
           ttlSeconds := cacheTTL
         ) {
        //= specification/searchable-encryption/search-config.md#beacon-keys
        //# Beacon keys MUST be obtained from the configured [Beacon Key Source](#beacon-key-source).
        var maybeRawBeaconKeyMaterials := store.GetBeaconKey(
          KeyStore.GetBeaconKeyInput(
            branchKeyIdentifier := keyId
          )
        );
        assert
          && |client.History.Digest| == |old(client.History.Digest)| + 1
          && Seq.Last(client.History.Digest).input.message == identifier
          && Seq.Last(cache.History.GetCacheEntry).input.identifier == Seq.Last(client.History.Digest).output.value
        by {
          assume{:axiom} client.Modifies !! store.Modifies;
        }
        var rawBeaconKeyMaterials :- maybeRawBeaconKeyMaterials
        .MapFailure(e => AwsCryptographyKeyStore(AwsCryptographyKeyStore := e));

        var key := rawBeaconKeyMaterials.beaconKeyMaterials.beaconKey;
        :- Need(key.Some?, E("beacon key unexpectedly empty"));
        var keyMap :- getAllKeys(stdNames, key.value);
        var beaconKeyMaterials := rawBeaconKeyMaterials.beaconKeyMaterials.(beaconKey := None, hmacKeys := Some(keyMap));

        //= specification/searchable-encryption/search-config.md#get-beacon-key-materials
        //# These materials MUST be put into the associated [Key Store Cache](#key-store-cache)
        //# with an [Expiry Time](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#expiry-time)
        //# equal to now + configured [cacheTTL](#cachettl).
        var putCacheEntryInput:= MP.PutCacheEntryInput(
          identifier := cacheDigest,
          materials := MP.Materials.BeaconKey(beaconKeyMaterials),
          creationTime := now,
          expiryTime := PosLongAdd(now, cacheTTL),
          messagesUsed := None,
          bytesUsed := None
        );

        verifyValidStateCache(cache);

        var putResult := cache.PutCacheEntry(putCacheEntryInput);
        if (putResult.Failure? && !putResult.error.EntryAlreadyExists?) {
          return Failure(AwsCryptographyMaterialProviders(AwsCryptographyMaterialProviders:=putResult.error));
        }
        assert
          && |client.History.Digest| == |old(client.History.Digest)| + 1
          && Seq.Last(client.History.Digest).input.message == identifier
          && Seq.Last(cache.History.GetCacheEntry).input.identifier == Seq.Last(client.History.Digest).output.value
        by {
          assume{:axiom} client.Modifies !! cache.Modifies;
        }
        return Success(keyMap);
      } else {
        :- Need(
          && getCacheOutput.value.materials.BeaconKey?
          && getCacheOutput.value.materials.BeaconKey.hmacKeys.Some?
          && getCacheOutput.value.materials.BeaconKey.beaconKeyIdentifier == keyId
          && getCacheOutput.value.materials.BeaconKey.hmacKeys.Some?,
          E("Invalid Material Type.")
        );
        return Success(getCacheOutput.value.materials.BeaconKey.hmacKeys.value);
      }
    }

    method getAllKeys(stdNames : seq<string>, key : Bytes) returns (output : Result<HmacKeyMap, Error>)
      requires Seq.HasNoDuplicates(stdNames)
      modifies client.Modifies
      requires client.ValidState()
      ensures client.History.Digest == old(client.History.Digest)
      ensures client.ValidState()
    {
      output := GetAllKeys(client, stdNames, key);
    }
  }

  function method MakeSearchInfo(version : ValidBeaconVersion) : (ret : ValidSearchInfo)
  {
    SearchInfo([version], 0)
  }

  datatype SearchInfo = SearchInfo(
    versions : seq<BeaconVersion>,
    currWrite : nat // index into `versions` for current version being written
  ) {

    function Modifies() : set<object>
    {
      set x, y | y in versions && x in y.Modifies() :: x
    }

    predicate ValidState()
    {
      && |versions| == 1
      && currWrite == 0
      && versions[0].ValidState()
    }

    function method curr() : BeaconVersion
      requires ValidState()
    {
      versions[currWrite]
    }

    predicate method IsBeacon(field : string)
      requires ValidState()
    {
      versions[currWrite].IsBeacon(field)
    }

    predicate method IsVirtualField(field : string)
      requires ValidState()
    {
      versions[currWrite].IsVirtualField(field)
    }

    method GeneratePlainBeacons(item : DDB.AttributeMap, bucket : BucketNumber) returns (output : Result<DDB.AttributeMap, Error>)
      requires ValidState()
    {
      output := versions[currWrite].GeneratePlainBeacons(item, bucket);
    }

    method GenerateSignedBeacons(item : DDB.AttributeMap, bucket : BucketNumber) returns (output : Result<DDB.AttributeMap, Error>)
      requires ValidState()
      ensures ValidState()
      modifies Modifies()
    {
      output := versions[currWrite].GenerateSignedBeacons(item, bucket);
    }
    method GenerateEncryptedBeacons(item : DDB.AttributeMap, keyId : MaybeKeyId, bucket : BucketNumber) returns (output : Result<DDB.AttributeMap, Error>)
      requires ValidState()
      ensures ValidState()
      modifies Modifies()
    {
      output := versions[currWrite].GenerateEncryptedBeacons(item, keyId, bucket);
    }
  }

  datatype Beacon =
    | Standard(std : BaseBeacon.ValidStandardBeacon)
    | Compound(cmp : CompoundBeacon.ValidCompoundBeacon)
  {
    predicate method isEncrypted()
    {
      if Standard? then
        true
      else
        cmp.isEncrypted()
    }
    function method hash(item : DDB.AttributeMap, vf : VirtualFieldMap, keys : MaybeKeyMap, bucket : BucketNumber)
      : (ret : Result<Option<DDB.AttributeValue>, Error>)
      requires !keys.DontUseKeys?

      //= specification/searchable-encryption/search-config.md#get-beacon-key-for-query
      //= type=implication
      //# A query MUST fail if this flag is present, and any part of the query
      //# requires a key; that is, needs to compute a standard beacon.
      ensures Standard? && keys.ShouldHaveKeys? ==> ret.Failure?
    {
      if Standard? then
        :- Need(keys.Keys?, E("Need key for beacon " + std.keyName() + " but no keyId found in query."));
        if std.keyName() in keys.value then
          std.getHash(item, vf, keys.value[std.keyName()], bucket)
        else
          Failure(E("Internal error. Beacon " + std.keyName() + " has no key!"))
      else
        var strHash :- cmp.hash(item, vf, keys, bucket);
        if strHash.None? then
          Success(None)
        else
          Success(Some(DDB.AttributeValue.S(strHash.value)))
    }
    function method naked(item : DDB.AttributeMap, vf : VirtualFieldMap, bucket : BucketNumber) : Result<Option<DDB.AttributeValue>, Error>
    {
      if Standard? then
        std.getNaked(item, vf)
      else
        var str :- cmp.getNaked(item, vf, bucket);
        if str.None? then
          Success(None)
        else
          Success(Some(DS(str.value)))
    }
    function method attrHash(item : DDB.AttributeMap, vf : VirtualFieldMap, keys : MaybeKeyMap, bucket : BucketNumber) : Result<Option<DDB.AttributeValue>, Error>
    {
      if keys.DontUseKeys? then
        naked(item, vf, bucket)
      else
        hash(item, vf, keys, bucket)
    }
    function method getName() : string
    {
      if Standard? then
        std.base.name
      else
        cmp.base.name
    }
    function method getBeaconName() : string
    {
      if Standard? then
        std.base.beaconName
      else
        cmp.base.beaconName
    }
    function method GetFields(virtualFields : VirtualFieldMap) : seq<string>
    {
      if Standard? then
        std.GetFields(virtualFields)
      else
        cmp.GetFields(virtualFields)
    }

    function method GetBeaconValue(value : DDB.AttributeValue, keys : MaybeKeyMap, forEquality : bool, forContains : bool, bucket : BucketNumber)
      : Result<DDB.AttributeValue, Error>
    {
      if keys.DontUseKeys? then
        Success(value)
      else if Standard? then
        :- Need(!keys.ShouldHaveKeys?, E("Need KeyId because of beacon " + std.keyName() + " but no KeyId found in query"));
        var keys := keys.value;
        if std.keyName() in keys then
          std.GetBeaconValue(value, keys[std.keyName()], forContains, bucket)
        else
          Failure(E("Internal error. Beacon " + std.keyName() + " has no key."))
      else
        cmp.GetBeaconValue(value, keys, forEquality, bucket)
    }

    predicate ValidState()
    {
      if Standard? then
        std.ValidState()
      else
        cmp.ValidState()
    }
  }

  type BeaconMap = x : map<string, Beacon> | IsValidBeaconMap(x) witness *

  predicate IsValidBeaconMap(m : map<string, Beacon>)
  {
    forall x <- m :: x == m[x].getName()
  }

  datatype BeaconType =
    | AnyBeacon
    | SignedBeacon
    | EncryptedBeacon

  predicate method IsPartOnly(b : Beacon)
  {
    b.Standard? && b.std.partOnly
  }
  predicate method IsBeaconOfType(b : Beacon, t : BeaconType)
  {
    match t {
      case AnyBeacon => true
      case SignedBeacon => !b.isEncrypted()
      case EncryptedBeacon => b.isEncrypted()
    }
  }

  lemma FilterDoesNotInventElements<T>(f: T ~> bool, xs: seq<T>)
    requires forall i :: 0 <= i < |xs| ==> f.requires(xs[i])
    ensures var result := Seq.Filter(f, xs);
            forall i :: 0 <= i < |result| ==> result[i] in xs
  {
    reveal Seq.Filter();
  }

  lemma HasNoDuplicatesAppend(a: seq, b: seq)
    requires Seq.HasNoDuplicates(a)
    requires Seq.HasNoDuplicates(b)
    requires forall i, j :: 0 <= i < |a| && 0 <= j < |b| ==> a[i] != b[j]
    ensures Seq.HasNoDuplicates(a + b)
  {
    reveal Seq.HasNoDuplicates();
  }

  lemma FilterPreservesHasNoDuplicates<T>(f: T ~> bool, xs: seq<T>)
    requires forall i :: 0 <= i < |xs| ==> f.requires(xs[i])
    requires Seq.HasNoDuplicates(xs)
    ensures Seq.HasNoDuplicates(Seq.Filter(f, xs))
  {
    reveal Seq.Filter(), Seq.HasNoDuplicates();
    if |xs| == 0 {
    } else {
      var a := if f(xs[0]) then [xs[0]] else [];
      var b := Seq.Filter(f, xs[1..]);

      calc {
        Seq.HasNoDuplicates(Seq.Filter(f, xs));
      ==  { assert Seq.Filter(f, xs) == a + b; }
        Seq.HasNoDuplicates(a + b);
      <==  { HasNoDuplicatesAppend(a, b); }
        Seq.HasNoDuplicates(a) && Seq.HasNoDuplicates(b) &&
        (forall i, j :: 0 <= i < |a| && 0 <= j < |b| ==> a[i] != b[j]);
      ==  { assert Seq.HasNoDuplicates(a); }
        Seq.HasNoDuplicates(b) &&
        (forall i, j :: 0 <= i < |a| && 0 <= j < |b| ==> a[i] != b[j]);
      ==  { FilterPreservesHasNoDuplicates(f, xs[1..]); }
        (forall i, j :: 0 <= i < |a| && 0 <= j < |b| ==> a[i] != b[j]);
      }

      forall i, j | 0 <= i < |a| && 0 <= j < |b|
        ensures a[i] != b[j]
      {
        assert b[j] in Seq.Filter(f, xs[1..]);
        FilterDoesNotInventElements(f, xs[1..]);
      }

    }
  }

  function method MakeBeaconVersion(
    version : VersionNumber,
    keySource : KeySource,
    beacons : BeaconMap,
    virtualFields : VirtualFieldMap,
    actions : AttributeActions,
    numBuckets : BucketCount
  )
    : (ret : Result<ValidBeaconVersion, Error>)
    requires version == 1
    requires keySource.ValidState()
    requires 0 < numBuckets
  {
    // We happen to order these values, but this ordering MUST NOT be relied upon.
    var beaconNames := SortedSets.ComputeSetToOrderedSequence2(beacons.Keys, CharLess);
    var stdKeys := Seq.Filter((k : string) => k in beacons && beacons[k].Standard?, beaconNames);
    FilterPreservesHasNoDuplicates((k : string) => k in beacons && beacons[k].Standard?, beaconNames);
    var encrypted := set k <- actions | actions[k] == SE.ENCRYPT_AND_SIGN :: k;
    var bv := BeaconVersion.BeaconVersion(version, keySource, virtualFields, beacons, beaconNames, stdKeys, encrypted, numBuckets);
    assert bv.ValidState();
    Success(bv)
  }

  type ValidBeaconVersion = x : BeaconVersion | x.ValidState() witness *

  datatype BeaconVersion = BeaconVersion (
    version : VersionNumber,
    keySource : KeySource,
    virtualFields : VirtualFieldMap,
    beacons : BeaconMap,
    // The ordering of `beaconNames` MUST NOT be relied upon.
    beaconNames : seq<string>,
    stdNames : seq<string>,
    encryptedFields : set<string>,
    numBuckets : BucketCount
  ) {

    function Modifies() : set<object>
    {
      keySource.Modifies()
    }

    predicate ValidState()
    {
      && version == 1
      && keySource.ValidState()
      && (forall k <- beaconNames :: k in beacons)
      && Seq.HasNoDuplicates(beaconNames)
      && |beaconNames| == |beacons|
      && (forall k <- stdNames :: k in beacons)
      && Seq.HasNoDuplicates(stdNames)
      && 0 < numBuckets
    }

    predicate method IsBeacon(field : string)
    {
      field in beacons
    }

    predicate method IsVirtualField(field : string)
    {
      field in virtualFields
    }

    function method GetFields(field : string) : seq<string>
    {
      if IsBeacon(field) then
        beacons[field].GetFields(virtualFields) + ["aws_dbe_b_" + field]
      else
        [field]
    }

    method getKeyMap(keyId : MaybeKeyId) returns (output : Result<MaybeKeyMap, Error>)
      requires ValidState()
      ensures ValidState()
      modifies Modifies()
    {
      output := keySource.getKeyMap(stdNames, keyId);
    }

    function method ListSignedBeacons()
      : seq<string>
      requires ValidState()
    {
      Seq.Filter((s : string) requires s in beacons => IsBeaconOfType(beacons[s], SignedBeacon), beaconNames)
    }

    // Get all beacons with plaintext values
    method GeneratePlainBeacons(item : DDB.AttributeMap, bucket : BucketNumber)
      returns (output : Result<DDB.AttributeMap, Error>)
      requires ValidState()
    {
      output := GenerateBeacons2(beaconNames, item, DontUseKeys, AnyBeacon, bucket);
    }

    // Get all beacons on fields that are signed, but not encrypted
    method GenerateSignedBeacons(item : DDB.AttributeMap, bucket : BucketNumber)
      returns (output : Result<DDB.AttributeMap, Error>)
      requires ValidState()
      ensures ValidState()
      modifies Modifies()
    {
      //= specification/dynamodb-encryption-client/ddb-support.md#addsignedbeacons
      //# AddSignedBeacons MUST only operate on [compound beacons](../searchable-encryption/beacons.md#compound-beacon)
      //# that do not have any [encrypted parts](../searchable-encryption/beacons.md#compound-beacon-initialization).

      //= specification/dynamodb-encryption-client/ddb-support.md#addsignedbeacons
      //# For every configured compound beacons which only contains non encrypted parts
      //# that can be successfully built from the attributes in the input AttributeMap,
      //# AddSignedBeacons MUST add an attribute named NAME,
      //# where NAME is the name of the beacon.

      //= specification/dynamodb-encryption-client/ddb-support.md#addsignedbeacons
      //# The value of this attribute MUST be a string,
      //# and must have the value defined in [beacons](../searchable-encryption/beacons.md#beacon-value).
      output := GenerateBeacons2(beaconNames, item, DontUseKeys, SignedBeacon, bucket);
    }

    // Get all beacons on encrypted fields
    method GenerateEncryptedBeacons(item : DDB.AttributeMap, keyId : MaybeKeyId, bucket : BucketNumber)
      returns (output : Result<DDB.AttributeMap, Error>)
      requires ValidState()
      ensures ValidState()
      modifies Modifies()
    {
      //= specification/searchable-encryption/search-config.md#get-beacon-key-after-encrypt
      //# The `beacon key id`, [Key Store Cache](#key-store-cache), and a `KeyStore`
      //# MUST be passed to [Get Beacon Key Materials](#get-beacon-key-materials)
      //# and the result returned for Get beacon key after encrypt.

      //= specification/dynamodb-encryption-client/ddb-support.md#getencryptedbeacons
      //# To obtain [Beacon Key Materials] GetEncryptedBeacons
      //# MUST call [Get beacon key after encrypt](../searchable-encryption/search-config.md#get-beacon-key-after-encrypt).
      var hmacKeys :- getKeyMap(keyId);

      //= specification/dynamodb-encryption-client/ddb-support.md#getencryptedbeacons
      //# GetEncryptedBeacons MUST NOT operate on [compound beacons](../searchable-encryption/beacons.md#compound-beacon)
      //# that only have [signed parts](../searchable-encryption/beacons.md#compound-beacon-initialization).

      //= specification/dynamodb-encryption-client/ddb-support.md#getencryptedbeacons
      //# For all other configured beacons
      //# that can be successfully built from the attributes in the input AttributeMap,
      //# GetEncryptedBeacons MUST add an attribute named aws_dbe_b_NAME,
      //# where NAME is the name of the beacon.

      //= specification/dynamodb-encryption-client/ddb-support.md#getencryptedbeacons
      //# The value of this attribute MUST be a string,
      //# and must have the value defined in [beacons](../searchable-encryption/beacons.md#beacon-value)

      //= specification/dynamodb-encryption-client/ddb-support.md#getencryptedbeacons
      //# The result of GetEncryptedBeacons MUST NOT contain any keys
      //# in the [Encrypt Item Output](./encrypt-item.md#output) AttributeMap.

      output := GenerateBeacons2(beaconNames, item, hmacKeys, EncryptedBeacon, bucket);
    }

    function method GenerateBeacon(name : string, item : DDB.AttributeMap, keys : MaybeKeyMap, bucket : BucketNumber) : Result<Option<DDB.AttributeValue>, Error>
      requires name in beacons
    {
      beacons[name].attrHash(item, virtualFields, keys, bucket)
    }

    function method GenerateBeacons2(
      names : seq<string>,
      item : DDB.AttributeMap,
      keys : MaybeKeyMap,
      bType : BeaconType,
      bucket : BucketNumber,
      acc : DDB.AttributeMap := map[]
    )
      : Result<DDB.AttributeMap, Error>
      requires forall k <- names :: k in beacons
    {
      if |names| == 0 then
        Success(acc)
      //= specification/searchable-encryption/beacons.md#partonly-initialization
      //# The Standard Beacon MUST NOT be stored in the item for a PartOnly beacon.
      else if IsBeaconOfType(beacons[names[0]], bType) && !IsPartOnly(beacons[names[0]]) then
        var value :- GenerateBeacon(names[0], item, keys, bucket);
        if value.Some? then
          GenerateBeacons2(names[1..], item, keys, bType, bucket, acc[beacons[names[0]].getBeaconName() := value.value])
        else
          GenerateBeacons2(names[1..], item, keys, bType, bucket, acc)
      else
        GenerateBeacons2(names[1..], item, keys, bType, bucket, acc)
    }
  }
}
