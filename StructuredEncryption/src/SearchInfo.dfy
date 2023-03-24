// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"
include "Beacon.dfy"
include "CompoundBeacon.dfy"
include "Virtual.dfy"

module SearchableEncryptionInfo {
  import opened AwsCryptographyStructuredEncryptionTypes
  import opened BaseBeacon
  import opened CompoundBeacon
  import opened VirtualFields
  import opened StandardLibrary
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened StructuredEncryptionUtil
  import opened StructuredEncryptionPaths
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

    function method GenerateBeacons(stringify : Stringify, byteify : Byteify) : Result<map<string,string>, Error>
      requires ValidState()
    {
      versions[currWrite].GenerateBeacons(stringify, byteify)
    }
  }

  datatype Beacon = 
    | Standard(std : StandardBeacon)
    | Compound(cmp : CompoundBeacon)
  {
    function method hash(stringify : Stringify, byteify : Byteify) : Result<string, Error>
    {
      if Standard? then
        std.getHash(byteify)
      else
        cmp.hash(stringify)
    }
    function method getName() : string
    {
      if Standard? then
        std.base.name
      else
        cmp.base.name
    }
  }

  type BeaconMap = map<string, Beacon>
  type VirtualFieldMap = map<string, VirtualField>

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

    // TerminalLocation to string via virtual field, if any
    function method GetVirtualLocationString(loc : TerminalLocation, stringify : Stringify) : Option<string>
    {
      if loc.isRoot() && loc.getRoot() in virtualFields then
        var strVal := virtualFields[loc.getRoot()].makeString(stringify);
        if strVal.Success? then
          Some(strVal.value)
        else
          None
      else
        None
    }

    // TerminalLocation to Bytes via virtual field, if any
    function method GetVirtualLocationBytes(loc : TerminalLocation, stringify : Stringify) : Option<Bytes>
    {
      if loc.isRoot() && loc.getRoot() in virtualFields then
        var strVal := virtualFields[loc.getRoot()].makeString(stringify);
        if strVal.Success? then
          var bytes := UTF8.Encode(strVal.value);
          if bytes.Success? then
            Some(bytes.value)
          else
            None
        else
          None
      else
        None
    }

    // Stringify via virtual field, or supplied Stringify
    function method VirtualStringify(loc : TerminalLocation, stringify : Stringify) : Result<string,string>
    {
      var virt := GetVirtualLocationString(loc, stringify);
      if virt.Some? then
        Success(virt.value)
      else
        stringify(loc)
    }

    // Byteify via virtual field, or supplied Byteify
    function method VirtualByteify(loc : TerminalLocation, stringify : Stringify, byteify : Byteify) : Result<Bytes,string>
    {
      var virt := GetVirtualLocationBytes(loc, stringify);
      if virt.Some? then
        Success(virt.value)
      else
        byteify(loc)
    }

    // Generate all possible beacons
    function method GenerateBeacons(stringify : Stringify, byteify : Byteify) : Result<map<string,string>, Error>
    {
      var result := map k <- beacons :: k :=
        beacons[k].hash(t => VirtualStringify(t, stringify), t => VirtualByteify(t, stringify, byteify));
      Success(map k <- result | result[k].Success? :: k := result[k].value)
    }
  }
}