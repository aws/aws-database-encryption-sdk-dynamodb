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

  newtype VersionNumber = uint64

  datatype SearchInfo = SearchInfo(
    versions : seq<BeaconVersion>,
    currWrite : nat // index into `versions` for current version being written
  ) {

    function method CheckValid() : (ret : Result<bool, Error>)
      ensures ret.Success? ==> ValidState()
    {
      var _ :- ValidStateResult();
      :- Need(ValidState(), E("State Invalid"));
      Success(true)
    }

    predicate method ValidState()
    {
      && 0 < |versions|
      && currWrite < |versions|
      && forall v <- versions :: v.ValidState()
    }

    // produce nice error messages for common mistakes
    function method ValidStateResult() : Result<bool, Error>
    {
      var _ :- Seq.MapWithResult((v : BeaconVersion) => v.ValidStateResult(), versions);
      Success(true)
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

    function method GenerateBeacons(item : DDB.AttributeMap) : Result<DDB.AttributeMap, Error>
      requires ValidState()
    {
      versions[currWrite].GenerateBeacons(item)
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
    function method GetBeaconValue(value : DDB.AttributeValue, keys : HmacKeyMap, naked : bool) : Result<DDB.AttributeValue, Error>
    {
      if naked then
        Success(value)
      else
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
    beacons : BeaconMap,
    virtualFields : VirtualFieldMap,
    hmacKeys : HmacKeyMap
  ) {

    predicate method ValidState()
    {
      && version == 1
      && (forall k <- virtualFields :: virtualFields[k].name == k)
      && (forall k <- beacons :: beacons[k].getName() == k)
      && (forall k <- virtualFields :: virtualFields[k].ValidState())
      && (forall k <- beacons :: beacons[k].ValidState())
      && hmacKeys.Keys == beacons.Keys
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

    function method GenerateBeacons(item : DDB.AttributeMap, naked : bool := false) : Result<DDB.AttributeMap, Error>
    {
      var beaconNames := SortedSets.ComputeSetToOrderedSequence2(beacons.Keys, CharLess);
      GenerateBeacons2(beaconNames, item, if naked then None else Some(hmacKeys))
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
