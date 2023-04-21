// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "Util.dfy"
include "Beacon.dfy"
include "CompoundBeacon.dfy"
include "Virtual.dfy"

module SearchableEncryptionInfo {
  import opened AwsCryptographyDynamoDbEncryptionTypes
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
  import Aws.Cryptography.Primitives
  import Prim = AwsCryptographyPrimitivesTypes
  import MP = AwsCryptographyMaterialProvidersTypes
  import KeyStoreTypes = AwsCryptographyKeyStoreTypes

  newtype VersionNumber = uint64
  type ValidSearchInfo = x : SearchInfo | x.ValidState() witness *

  type ValidStore = x : KeyStoreTypes.IKeyStoreClient | x.ValidState() witness *

  method GetAllKeys(client : Primitives.AtomicPrimitivesClient, stdNames : seq<string>, key : Bytes) returns (output : Result<HmacKeyMap, Error>)
    requires Seq.HasNoDuplicates(stdNames)
    modifies client.Modifies
    requires client.ValidState()
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
    ensures output.Success? ==> forall k <- allKeys :: k in output.value
    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    if |keysLeft| == 0 {
      return Success(acc);
    } else {
      var key :- GetBeaconKey(client, key, keysLeft[0]);
      reveal Seq.HasNoDuplicates();
      output := GetHmacKeys(client, allKeys, keysLeft[1..], key, acc[keysLeft[0] := key]);
    }
  }

  // convert persistent key to the derived key for this beacon
  method GetBeaconKey(client : Primitives.AtomicPrimitivesClient, key : Bytes, name : string)
    returns (output : Result<Bytes, Error>)
    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    var info :- UTF8.Encode("AWS_DBE_SCAN_BEACON" + name).MapFailure(e => E(e));
    var keyR := client.Hkdf(Prim.HkdfInput(
                              digestAlgorithm := Prim.SHA_512,
                              salt := None,
                              ikm := key,
                              info := info,
                              expectedLength := 64
                            ));
    var key :- keyR.MapFailure(e => AwsCryptographyPrimitives(e));
    return Success(key);
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
    cacheTTL : uint32
  ) {
    function Modifies() : set<object> {
      client.Modifies + store.Modifies
    }
    predicate ValidState() {
      client.ValidState() && store.ValidState()
    }
    method getKeyMap(stdNames : seq<string>, keyId : Option<string>) returns (output : Result<HmacKeyMap, Error>)
      requires Seq.HasNoDuplicates(stdNames)
      requires ValidState()
      ensures ValidState()
      modifies Modifies()
    {
      if keyLoc.SingleLoc? {
        :- Need(keyId.None?, E("KeyID should not be supplied with a SingleKeyStore"));
        output := getKeysCache(stdNames, keyLoc.keyId);
      } else if keyLoc.LiteralLoc? {
        :- Need(keyId.None?, E("KeyID should not be supplied with a LiteralKeyStore"));
        output := getKeysLiteral();
      } else {
        :- Need(keyId.Some?, E("KeyID must not be supplied with a MultiKeyStore"));
        output := getKeysCache(stdNames, keyId.value);
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

    method getKeysCache(
      stdNames : seq<string>,
      keyId : string
    )
      returns (output : Result<HmacKeyMap, Error>)
      requires Seq.HasNoDuplicates(stdNames)
      requires ValidState()
      modifies Modifies()
      ensures ValidState()
    {
      var keyIdBytesR := UTF8.Encode(keyId);
      var keyIdBytes :- keyIdBytesR.MapFailure(e => E(e));
      var getCacheInput := MP.GetCacheEntryInput(identifier := keyIdBytes, bytesUsed := None);
      verifyValidStateCache(cache);
      assume {:axiom} cache.Modifies == {};
      var getCacheOutput := cache.GetCacheEntry(getCacheInput);

      if getCacheOutput.Failure? {
        var maybeRawBranchKeyMaterials := store.GetBeaconKey(
          KeyStore.GetBeaconKeyInput(
            branchKeyIdentifier := keyId,
            grantTokens := None
          )
        );
        var rawBranchKeyMaterials :- maybeRawBranchKeyMaterials
        .MapFailure(e => AwsCryptographyKeyStore(AwsCryptographyKeyStore := e));

        var key := rawBranchKeyMaterials.beaconKey;
        var keyMap :- getAllKeys(stdNames, key);
        var beaconKeyMaterials := MP.BeaconKeyMaterials(
          beaconKeyIdentifier := keyId,
          beaconKey := Some(rawBranchKeyMaterials.beaconKey),
          hmacKeys := Some(keyMap)
        );

        var now := Time.GetCurrent();
        var putCacheEntryInput:= MP.PutCacheEntryInput(
          identifier := keyIdBytes,
          materials := MP.Materials.BeaconKey(beaconKeyMaterials),
          creationTime := now,
          expiryTime := now+cacheTTL as MP.PositiveLong,
          messagesUsed := None,
          bytesUsed := None
        );

        verifyValidStateCache(cache);
        assume {:axiom} cache.Modifies == {};
        var _ := cache.PutCacheEntry(putCacheEntryInput);
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

    function method GenerateClosure(fields : seq<string>) : seq<string>
      requires ValidState()
    {
      versions[currWrite].GenerateClosure(fields)
    }

    method GeneratePlainBeacons(item : DDB.AttributeMap) returns (output : Result<DDB.AttributeMap, Error>)
      requires ValidState()
    {
      output := versions[currWrite].GeneratePlainBeacons(item);
    }

    method GenerateSignedBeacons(item : DDB.AttributeMap) returns (output : Result<DDB.AttributeMap, Error>)
      requires ValidState()
      ensures ValidState()
      modifies Modifies()
    {
      output := versions[currWrite].GenerateSignedBeacons(item);
    }
    method GenerateEncryptedBeacons(item : DDB.AttributeMap, keyId : Option<string>) returns (output : Result<DDB.AttributeMap, Error>)
      requires ValidState()
      ensures ValidState()
      modifies Modifies()
    {
      output := versions[currWrite].GenerateEncryptedBeacons(item, keyId);
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
    function method hash(item : DDB.AttributeMap, vf : VirtualFieldMap, keys : HmacKeyMap) : Result<Option<string>, Error>
    {
      if Standard? then
        if std.base.name in keys then
          std.getHash(item, vf, keys[std.base.name])
        else
          Failure(E("Internal error. Beacon " + std.base.name + " has no key."))
      else
        cmp.hash(item, vf, keys)
    }
    function method naked(item : DDB.AttributeMap, vf : VirtualFieldMap) : Result<Option<DDB.AttributeValue>, Error>
    {
      if Standard? then
        std.getNaked(item, vf)
      else
        var str :- cmp.getNaked(item, vf);
        if str.None? then
          Success(None)
        else
          Success(Some(DS(str.value)))
    }
    function method attrHash(item : DDB.AttributeMap, vf : VirtualFieldMap, keys : Option<HmacKeyMap>) : Result<Option<DDB.AttributeValue>, Error>
    {
      if keys.Some? then
        var str :- hash(item, vf, keys.value);
        if str.None? then
          Success(None)
        else
          Success(Some(DS(str.value)))
      else
        naked(item, vf)
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
    function method GetBeaconValue(value : DDB.AttributeValue, keys : Option<HmacKeyMap>) : Result<DDB.AttributeValue, Error>
    {
      if keys.None? then
        Success(value)
      else
        var keys := keys.value;
        if Standard? then
          if std.base.name in keys then
            std.GetBeaconValue(value, keys[std.base.name])
          else
            Failure(E("Internal error. Beacon " + std.base.name + " has no key."))
        else
          cmp.GetBeaconValue(value, keys)
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
    virtualFields : VirtualFieldMap
  )
    : (ret : Result<ValidBeaconVersion, Error>)
    requires version == 1
    requires keySource.ValidState()
  {
    var beaconNames := SortedSets.ComputeSetToOrderedSequence2(beacons.Keys, CharLess);
    var stdKeys := Seq.Filter((k : string) => k in beacons && beacons[k].Standard?, beaconNames);
    FilterPreservesHasNoDuplicates((k : string) => k in beacons && beacons[k].Standard?, beaconNames);
    var bv := BeaconVersion.BeaconVersion(version, keySource, virtualFields, beacons, beaconNames, stdKeys);
    assert bv.ValidState();
    Success(bv)
  }

  type ValidBeaconVersion = x : BeaconVersion | x.ValidState() witness *

  datatype BeaconVersion = BeaconVersion (
    version : VersionNumber,
    keySource : KeySource,
    virtualFields : VirtualFieldMap,
    beacons : BeaconMap,
    beaconNames : seq<string>,
    stdNames : seq<string>
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

    function method GenerateClosure(fields : seq<string>) : seq<string>
    {
      var fieldLists := Seq.Map((s : string) => GetFields(s), fields);
      var fieldSet := set f <- fieldLists, g <- f :: g;
      SortedSets.ComputeSetToOrderedSequence2(fieldSet, CharLess)
    }

    method getKeyMap(keyId : Option<string>) returns (output : Result<HmacKeyMap, Error>)
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
    method GeneratePlainBeacons(item : DDB.AttributeMap)
      returns (output : Result<DDB.AttributeMap, Error>)
      requires ValidState()
    {
      output := GenerateBeacons2(beaconNames, item, None, AnyBeacon);
    }

    // Get all beacons on fields that are signed, but not encrypted
    method GenerateSignedBeacons(item : DDB.AttributeMap)
      returns (output : Result<DDB.AttributeMap, Error>)
      requires ValidState()
      ensures ValidState()
      modifies Modifies()
    {
      output := GenerateBeacons2(beaconNames, item, None, SignedBeacon);
    }

    // Get all beacons on encrypted fields
    method GenerateEncryptedBeacons(item : DDB.AttributeMap, keyId : Option<string>)
      returns (output : Result<DDB.AttributeMap, Error>)
      requires ValidState()
      ensures ValidState()
      modifies Modifies()
    {
      var hmacKeys :- getKeyMap(keyId);
      output := GenerateBeacons2(beaconNames, item, Some(hmacKeys), EncryptedBeacon);
    }

    function method GenerateBeacon(name : string, item : DDB.AttributeMap, keys : Option<HmacKeyMap>) : Result<Option<DDB.AttributeValue>, Error>
      requires name in beacons
    {
      beacons[name].attrHash(item, virtualFields, keys)
    }

    function method GenerateBeacons2(
      names : seq<string>,
      item : DDB.AttributeMap,
      keys : Option<HmacKeyMap>,
      bType : BeaconType,
      acc : DDB.AttributeMap := map[]
    )
      : Result<DDB.AttributeMap, Error>
      requires forall k <- names :: k in beacons
    {
      if |names| == 0 then
        Success(acc)
      else if IsBeaconOfType(beacons[names[0]], bType) then
        var value :- GenerateBeacon(names[0], item, keys);
        if value.Some? then
          GenerateBeacons2(names[1..], item, keys, bType, acc[beacons[names[0]].getBeaconName() := value.value])
        else
          GenerateBeacons2(names[1..], item, keys, bType, acc)
      else
        GenerateBeacons2(names[1..], item, keys, bType, acc)
    }
  }
}
