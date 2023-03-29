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
      // TODO - better error messages
      :- Need(ValidState(), E("State Invalid"));
      Success(true)
    }
    predicate method ValidState()
    {
      && 0 < |versions|
      && currWrite < |versions|
      && forall v <- versions :: v.ValidState()
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
    function method hash(item : DDB.AttributeMap, vf : VirtualFieldMap) : Result<string, Error>
    {
      if Standard? then
        std.getHash(item, vf)
      else
        cmp.hash(item, vf)
    }
    function method attrHash(item : DDB.AttributeMap, vf : VirtualFieldMap) : Result<DDB.AttributeValue, Error>
    {
      var str :- hash(item, vf);
      Success(DS(str))
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
    function method GetFields() : seq<string>
    {
      if Standard? then
        std.GetFields()
      else
        cmp.GetFields()
    }
  }

  type BeaconMap = map<string, Beacon>

  datatype BeaconVersion = BeaconVersion (
    version : VersionNumber,
    beacons : BeaconMap,
    virtualFields : VirtualFieldMap
  ) {

    predicate method ValidState()
    {
      && version == 1
      && (forall k <- virtualFields :: virtualFields[k].name == k)
      && (forall k <- beacons :: beacons[k].getName() == k)
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
        beacons[field].GetFields() + ["aws_dbe_b_" + field]
      else
        [field]
    }

    function method GenerateClosure(fields : seq<string>) : seq<string>
    {
      var fieldLists := Seq.Map((s : string) => GetFields(s), fields);
      var fieldSet := set f <- fieldLists, g <- f :: g;
      SortedSets.ComputeSetToOrderedSequence2(fieldSet, CharLess)
    }

    function method GenerateBeacons(item : DDB.AttributeMap) : Result<DDB.AttributeMap, Error>
    {
      var attrs := map k <- beacons :: beacons[k].getBeaconName() := beacons[k].attrHash(item, virtualFields);
      if forall k <- attrs :: attrs[k].Success? then
        Success(map k <- attrs :: k := attrs[k].value)
      else
        // TODO
        Failure(E(""))
    }
  }
}
