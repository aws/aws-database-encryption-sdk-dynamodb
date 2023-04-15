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
  import KeyStore = AwsCryptographyKeyStoreTypes
  import Aws.Cryptography.Primitives
  import Prim = AwsCryptographyPrimitivesTypes

  newtype VersionNumber = uint64
  type ValidSearchInfo = x : SearchInfo | x.ValidState?() witness *

  class DumbCache {
    var keyId : string
    var keys : HmacKeyMap

    constructor()
    {
      this.keyId := "";
      this.keys := map[];
    }

    method get(s : string) returns (output : Option<HmacKeyMap>)
    {
      if keyId == s {
        return Some(keys);
      }
      return None;
    }
    method put(s : string, k : HmacKeyMap)
      modifies this
    {
      keyId := s;
      keys := k;
    }
  }
  type ValidStore = x : AwsCryptographyKeyStoreTypes.IKeyStoreClient | x.ValidState() witness *

  datatype KeyLocation =
    | LiteralKey (key: Bytes)
    | SingleLoc (keyId: string)
    | MultiLoc (keyName : string)

  datatype KeySource = KeySource(
    client : Primitives.AtomicPrimitivesClient,
    cache : DumbCache,
    store : ValidStore,
    keyLoc : KeyLocation
  ) {
    function Modifies() : set<object> {
      client.Modifies + store.Modifies + {cache}
    }
    predicate ValidState() {
      client.ValidState() && store.ValidState()
    }
    method getKeyMap(beacons : BeaconMap) returns (output : Result<HmacKeyMap, Error>)
      requires ValidState()
      ensures ValidState()
      modifies Modifies()
    {
      if keyLoc.SingleLoc? {
        output := getKeys(beacons, keyLoc.keyId);
      } else if keyLoc.LiteralKey? {
        output := getAllKeys(beacons, "Literal", keyLoc.key);
      } else {
        output := Failure(E("Multi Tenant not yet implemented"));
      }
    }

    method getKeys(beacons : BeaconMap, keyId : string) returns (output : Result<HmacKeyMap, Error>)
      requires ValidState()
      ensures ValidState()
      modifies Modifies()
    {
      var k := cache.get(keyId);
      if k.Some? {
        return Success(k.value);
      }
      var key :- getKeyFromStore(keyId);
      output := getAllKeys(beacons, keyId, key);
    }

    method getAllKeys(beacons : BeaconMap, keyId : string, key : Bytes) returns (output : Result<HmacKeyMap, Error>)
      requires ValidState()
      ensures ValidState()
      modifies Modifies()
    {
      var beaconKeys := SortedSets.ComputeSetToOrderedSequence2(beacons.Keys, CharLess);
      var stdKeys := Seq.Filter((k : string) => k in beacons && beacons[k].Standard?, beaconKeys);
      var newKeys :- getHmacKeys(stdKeys, key, beacons);
      cache.put(keyId, newKeys);
      return Success(newKeys);
    }

    method {:tailrecursion} getHmacKeys(
      beaconKeys : seq<string>,
      key : Bytes,
      beacons : BeaconMap,
      acc : HmacKeyMap := map[]
    )
      returns (output : Result<HmacKeyMap, Error>)
      requires forall k <- beaconKeys :: k in beacons
      requires forall k <- acc :: k in beacons
      ensures output.Success? ==> forall k <- output.value :: k in beacons

      modifies client.Modifies
      requires client.ValidState()
      ensures client.ValidState()
    {
      if |beaconKeys| == 0 {
        return Success(acc);
      } else {
        var key :- getBeaconKey(key, beaconKeys[0]);
        output := getHmacKeys(beaconKeys[1..], key, beacons, acc[beaconKeys[0] := key]);
      }
    }

    method getKeyFromStore(keyId : string)
      returns (output : Result<Bytes, Error>)
      modifies store.Modifies
      requires store.ValidState()
      ensures store.ValidState()
    {
      var maybeKey := store.GetBeaconKey(
        KeyStore.GetBeaconKeyInput(
          branchKeyIdentifier := keyId,
          awsKmsKeyArn := None,
          grantTokens := None
        )
      );
      var key :- maybeKey.MapFailure(e => AwsCryptographyKeyStore(e));
      output := Success(key.beaconKey);
    }

    // convert persistent key to the derived key for this beacon
    method getBeaconKey(key : Bytes, name : string)
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
  }

  datatype SearchInfo = SearchInfo(
    versions : seq<BeaconVersion>,
    currWrite : nat // index into `versions` for current version being written
  ) {
    function method CheckValid() : (ret : Result<bool, Error>)
      ensures ret.Success? ==> ValidState?()
    {
      var _ :- ValidStateResult();
      :- Need(ValidState?(), E("State Invalid"));
      Success(true)
    }

    function Modifies() : set<object>
    {
      set x, y | y in versions && x in y.Modifies() :: x
    }
    predicate method ValidState?()
    {
      && 0 < |versions|
      && currWrite < |versions|
      && forall v <- versions :: v.ValidState?()
    }
    predicate ValidState()
    {
      && forall v <- versions :: v.ValidState()
    }

    // produce nice error messages for common mistakes
    function method ValidStateResult() : Result<bool, Error>
    {
      var _ :- Seq.MapWithResult((v : BeaconVersion) => v.ValidStateResult(), versions);
      Success(true)
    }

    function method curr() : BeaconVersion
      requires ValidState?()
    {
      versions[currWrite]
    }

    predicate method IsBeacon(field : string)
      requires ValidState?()
    {
      versions[currWrite].IsBeacon(field)
    }
    
    predicate method IsVirtualField(field : string)
      requires ValidState?()
    {
      versions[currWrite].IsVirtualField(field)
    }

    function method GenerateClosure(fields : seq<string>) : seq<string>
      requires ValidState?()
    {
      versions[currWrite].GenerateClosure(fields)
    }

    method GenerateBeacons(item : DDB.AttributeMap) returns (output : Result<DDB.AttributeMap, Error>)
      requires ValidState?()
      requires ValidState()
      ensures ValidState()
      modifies Modifies()
    {
      output := versions[currWrite].GenerateBeacons(item);
    }
  }

  datatype Beacon = 
    | Standard(std : BaseBeacon.StandardBeacon)
    | Compound(cmp : CompoundBeacon.CompoundBeacon)
  {
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
    function method ValidStateResult() : Result<bool, Error>
    {
      if Standard? then
        std.ValidStateResult()
      else
        cmp.ValidStateResult()
    }
    predicate method ValidState()
    {
      if Standard? then
        std.ValidState()
      else
        cmp.ValidState()
    }
  }

  type BeaconMap = map<string, Beacon>

  datatype BeaconVersion = BeaconVersion (
    version : VersionNumber,
    keySource : KeySource,
    beacons : BeaconMap,
    virtualFields : VirtualFieldMap
  ) {

    function Modifies() : set<object>
    {
      keySource.Modifies()
    }

    predicate method ValidState?()
    {
      && version == 1
      && (forall k <- virtualFields :: virtualFields[k].name == k)
      && (forall k <- beacons :: beacons[k].getName() == k)
      && (forall k <- virtualFields :: virtualFields[k].ValidState())
      && (forall k <- beacons :: beacons[k].ValidState())
    }
    predicate ValidState()
    {
      keySource.ValidState()
    }

    function method ValidStateResult() : Result<bool, Error>
    {
      var _ :- Seq.MapWithResult((k : Beacon) => k.ValidStateResult(), SortedSets.ComputeSetToSequence(beacons.Values));
      var _ :- Seq.MapWithResult((k : VirtField) => k.ValidStateResult(), SortedSets.ComputeSetToSequence(virtualFields.Values));
      Success(true)
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

    method getKeyMap() returns (output : Result<HmacKeyMap, Error>)
      requires ValidState()
      ensures ValidState()
      modifies Modifies()
    {
      output := keySource.getKeyMap(beacons);
    }

    method GenerateBeacons(item : DDB.AttributeMap, naked : bool := false)
      returns (output : Result<DDB.AttributeMap, Error>)
      requires ValidState()
      ensures ValidState()
      modifies Modifies()
    {
      var beaconNames := SortedSets.ComputeSetToOrderedSequence2(beacons.Keys, CharLess);
      if naked { 
        output := GenerateBeacons2(beaconNames, item, None);
      } else {
        var hmacKeys :- getKeyMap();
        output := GenerateBeacons2(beaconNames, item, Some(hmacKeys));
      }
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
      acc : DDB.AttributeMap := map[]
    )
      : Result<DDB.AttributeMap, Error>
      requires forall k <- names :: k in beacons
    {
      if |names| == 0 then
        Success(acc)
      else
        var value :- GenerateBeacon(names[0], item, keys);
        if value.Some? then
          GenerateBeacons2(names[1..], item, keys, acc[beacons[names[0]].getBeaconName() := value.value])
        else
          GenerateBeacons2(names[1..], item, keys, acc)
    }
  }
}
