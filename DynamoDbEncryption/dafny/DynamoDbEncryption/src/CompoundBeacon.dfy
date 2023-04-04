// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

/*
  BaseBeacon.Beacon defines the way that input data (bytes or strings)
  is converted into beacons, for use in searchable encryption.

  The public interface of this module consists of the Beacon datatype, and four of its methods.
  - standardHash : turn a sequence of bytes into a hex string
  - compoundHash : turn a string into another string, containing one or more standardHash's and possibly some plain text.
  - isValid : is the Beacon internally consistent?
*/

include "Util.dfy"
include "Beacon.dfy"

module CompoundBeacon {
  import opened Wrappers
  import opened BaseBeacon
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened StandardLibrary.String
  import opened TermLoc
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import opened DynamoDbEncryptionUtil
  import opened DdbVirtualFields

  import Prim = AwsCryptographyPrimitivesTypes
  import Aws.Cryptography.Primitives
  import UTF8
  import Seq
  import SortedSets

  type Prefix = x : string | 0 < |x| witness *

  // if length is null, this is a non-sensitive part
  datatype BeaconPart = BeaconPart (
    name : string,
    loc : TermLoc,
    prefix : Prefix,
    length : Option<BeaconLength>
  ) {

  function method GetFields(virtualFields : VirtualFieldMap) : seq<string>
    {
      if loc[0].key in virtualFields then
        virtualFields[loc[0].key].GetFields()
      else
        [loc[0].key]
    }
  }

  datatype ConstructorPart = ConstructorPart (
    name : string,
    required : bool
  )

  type ConstructorPartList = x : seq<ConstructorPart> | 0 < |x| witness *

  datatype Constructor = Constructor(
    parts : ConstructorPartList
  )

  type ConstructorList = x : seq<Constructor> | 0 < |x| witness *
  
  datatype CompoundBeacon = CompoundBeacon(
    base : BeaconBase,
    split : char,
    parts : seq<BeaconPart>, // Non-Sensitive followed by Sensitive
    construct : ConstructorList
  ) {

    function method FindPartByName(name : string) : Result<BeaconPart, Error>
    {
      // TODO - prove and keep track, so this can't fail
      var part := Seq.Filter((x : BeaconPart) => (x.name == name), parts);
      :- Need(|part| == 1, E("Internal error, constructor named non-existent part"));
      Success(part[0])
    }

    function method GetFields(virtualFields : VirtualFieldMap) : seq<string>
    {
      Seq.Flatten(Seq.Map((p : BeaconPart) => p.GetFields(virtualFields), parts))
    }

    function method FindAndCalcPart(value : string) : Result<string, Error>
    {
      var part := Seq.Filter((b : BeaconPart) => b.prefix <= value, parts);
      if |part| == 0 then
        Failure(E("Value " + value + " for beacon " + base.name + " does not match the prefix of any configured part."))
      else if 1 < |part| then
        Failure(E("Internal error. Value " + value + " for beacon " + base.name + " somehow matched multiple prefixes."))
      else
        PartValueCalc(value, part[0].prefix, part[0].length)
    }

    function method GetBeaconValue(value : DDB.AttributeValue) : Result<DDB.AttributeValue, Error>
    {
      if !value.S? then
        Failure(E("CompoundBeacon " + base.name + " can only be queried as a string, not as " + AttrTypeToStr(value)))
      else
        var parts := Split(value.S, split);
        var beaconParts :- Seq.MapWithResult(s => FindAndCalcPart(s), parts);
        var result := Join(beaconParts, [split]);
        Success(DDB.AttributeValue.S(result))
    }

    function method {:opaque} {:tailrecursion} TryConstructor(
      consFields : seq<ConstructorPart>,
      item : DDB.AttributeMap,
      vf : VirtualFieldMap,
      acc : string := "")
      : (ret : Result<string, Error>)
      ensures ret.Success? ==> |ret.value| > 0
    {
      if |consFields| == 0 then
        if |acc| ==  0 then
          Failure(E("Internal Error : Empty beacon created."))
        else
          Success(acc)
      else
        //= specification/searchable-encryption/beacons.md#hash-for-a-compound-beacon
        //# * For that constructor, hash MUST join the [part value](#part-value) for each part on the `split character`,
        //# excluding parts that are not required and with a source field that is not available.
        var part :- FindPartByName(consFields[0].name);
        var strValue := VirtToString(part.loc, item, vf);
        :- Need(!consFields[0].required || strValue.Success?, E("")); // this error message never propagated
        if strValue.Success? then
          var val :- PartValueCalc(part.prefix + strValue.value, part.prefix, part.length);
          if |acc| == 0 then
            TryConstructor(consFields[1..], item, vf, val)
          else
            TryConstructor(consFields[1..], item, vf, acc + [split] + val)
        else
          TryConstructor(consFields[1..], item, vf, acc)
    }

    function method {:opaque} {:tailrecursion} TryConstructors(
      construct : seq<Constructor>,
      item : DDB.AttributeMap,
      vf : VirtualFieldMap
    )
      : (ret : Result<string, Error>)
      ensures ret.Success? ==> |ret.value| > 0
    {
      if |construct| == 0 then
        Failure(E("No constructor for " + base.name + " could be satisfied."))
      else
        //= specification/searchable-encryption/beacons.md#hash-for-a-compound-beacon
        //# * has MUST iterate through all constructors, in order, using the first that succeeds.
        var x := TryConstructor(construct[0].parts, item, vf);
        if x.Success? then
          x
        else
          TryConstructors(construct[1..], item, vf)
    }

    //= specification/searchable-encryption/beacons.md#hash-for-a-compound-beacon
    //= type=implication
    //# * hash MUST take a record as input, and produce a string.
    function method {:opaque} hash(item : DDB.AttributeMap, vf : VirtualFieldMap) : (res : Result<string, Error>)
      ensures res.Success? ==> 
        //= specification/searchable-encryption/beacons.md#hash-for-a-compound-beacon
        //= type=implication
        //# * The returned string MUST NOT be empty.
        && |res.value| > 0
    {
      TryConstructors(construct, item, vf)
    }

    function method {:opaque} findPart(val : string)
      : (ret : Result<BeaconPart, Error>)
      ensures |Seq.Filter((x : BeaconPart) => (x.prefix <= val), parts)| == 0 ==> ret.Failure?
      ensures ret.Success? ==>
        //= specification/searchable-encryption/beacons.md#getpart-for-a-compound-beacon
        //= type=implication
        //# * For each piece, a [part](#part) MUST be identified by matching the prefix of a [part](#part)
        //# to the beginning of the piece.        
        ret.value.prefix <= val

      //= specification/searchable-encryption/beacons.md#getpart-for-a-compound-beacon
      //= type=implication
      //# * If no such part exists, this operation MUST fail.
      ensures |Seq.Filter((x : BeaconPart) => (x.prefix <= val), parts)| == 0 ==> ret.Failure?
    {
      var thePart : seq<BeaconPart> := Seq.Filter((x : BeaconPart) => (x.prefix <= val), parts);
      if |thePart| == 0 then
        Failure(E("No part found in beacon " + base.name + " match prefix " + val))
      else if |thePart| > 1 then
        Failure(E("Internal error. Multiple parts for beacon " + base.name + " matched prefix of " + val))
      else
        assert |thePart| == 1;
        Success(thePart[0])
    }

    //= specification/searchable-encryption/beacons.md#getpart-for-a-compound-beacon
    //= type=implication
    //# * getPart MUST take a string as input and produce a string.
    function method {:opaque} getPart(val : string)
      : (ret : Result<string, Error>)
      //= specification/searchable-encryption/beacons.md#getpart-for-a-compound-beacon
      //= type=implication
      //# * The returned string MUST NOT be empty.
      requires 0 < |val|

      ensures ret.Success? ==> 
        && |ret.value| > 0

        //= specification/searchable-encryption/beacons.md#getpart-for-a-compound-beacon
        //= type=implication
        //# * The string MUST be split on the `split character` into pieces.
        && var pieces := Split(val, split);
        && calcParts(pieces).Success?
        && ret.value == calcParts(pieces).value
    {
        var pieces := Split(val, split);
        calcParts(pieces)
    }

    function method calcPart(piece : string)
      : (ret : Result<string, Error>)

      ensures ret.Success? ==>
        && findPart(piece).Success?
        && |ret.value| > 0

        //= specification/searchable-encryption/beacons.md#getpart-for-a-compound-beacon
        //= type=implication
        //# * The [Part Value](#part-value-calculation) MUST be calculated for each piece,
        //# using the prefix and length from the discovered part.
        && var thePart := findPart(piece).value;
        && PartValueCalc(piece, thePart.prefix, thePart.length).Success?
        && ret.value == PartValueCalc(piece, thePart.prefix, thePart.length).value

      ensures findPart(piece).Failure? ==> ret.Failure?
    {
      var thePart :- findPart(piece);
      PartValueCalc(piece, thePart.prefix, thePart.length)
    }

    function method calcParts(pieces : seq<string>, acc : string := [])
      : (ret : Result<string, Error>)
      requires |pieces| > 0 || |acc| > 0
      ensures ret.Success? ==> |ret.value| > 0
    {
      if |pieces| == 0 then
        Success(acc)
      else
        //= specification/searchable-encryption/beacons.md#getpart-for-a-compound-beacon
        //# * The value returned MUST be these part values, joined with the `split character`.
        var theBeacon :- calcPart(pieces[0]);
        if |acc| == 0 then
          calcParts(pieces[1..], theBeacon)
        else
          calcParts(pieces[1..], acc + [split] + theBeacon)
    }

    static predicate method OkPrefixStringPair(x : string, y : string)
    {
      && !(x <= y)
      && !(y <= x)
    }
    predicate method OkPrefixPair(pos1 : nat, pos2 : nat)
      requires pos1 < |parts|
      requires pos2 < |parts|
    {
      || pos1 == pos2 
      || OkPrefixStringPair(parts[pos1].prefix, parts[pos2].prefix)
    }

    predicate method ValidPrefixSet()
    {
      forall x : nat, y : nat
        | 0 <= x < |parts| && x < y < |parts|
        :: OkPrefixPair(x, y)
    }

    function method CheckOnePrefixPart(pos1 : nat, pos2 : nat) : (ret : Result<bool, Error>)
      requires pos1 < |parts|
      requires pos2 < |parts|
      ensures ret.Success? ==> OkPrefixPair(pos1, pos2)
    {
      if !OkPrefixPair(pos1, pos2) then
        Failure(E("Compound beacon " + base.name + " defines part " + parts[pos1].name + " with prefix " + parts[pos1].prefix
        + " which is incompatible with part " + parts[pos2].name + " which has a prefix of " + parts[pos2].prefix + "."))
      else
        Success(true)
    }

    function method CheckOnePrefix(pos : nat) : (ret : Result<bool, Error>)
      requires pos < |parts|
    {
      var partNumbers : seq<nat> := seq(|parts|, (i : nat) => i as nat);
      var _ :- Seq.MapWithResult((p : int) requires 0 <= p < |parts| => CheckOnePrefixPart(pos, p), seq(|parts|, i => i));
      Success(true)
    }

    function method ValidPrefixSetResultPos(index : nat) : (ret : Result<bool, Error>)
      decreases |parts| - index
    {
      if |parts| <= index then
        Success(true)
      else
        var _ :- CheckOnePrefix(index);
        ValidPrefixSetResultPos(index+1)
    }

    function method ValidPrefixSetResult() : (ret : Result<bool, Error>)
    {
      ValidPrefixSetResultPos(0)
    }

    predicate method ValidPart(f : ConstructorPart)
    {
      |Seq.Filter((x : BeaconPart) => x.name == f.name, parts)| == 1
    }

    function method ValidPartResult(f : ConstructorPart) : Result<bool, Error>
    {
      var count := |Seq.Filter((x : BeaconPart) => x.name == f.name, parts)|;
      if count == 0 then
        Failure(E("Constructor for beacon " + base.name + " mentions part " + f.name + " but no such beacon part is configured."))
      else
        Success(true)
    }

    predicate method ValidConstructor(con : seq<ConstructorPart>)
    {
      if |con| == 0 then
        true
      else
        ValidPart(con[0]) && ValidConstructor(con[1..])
    }

    function method ValidConstructorResult(con : seq<ConstructorPart>) : Result<bool, Error>
    {
      if |con| == 0 then
        Success(true)
      else
        var _ :- ValidPartResult(con[0]);
        ValidConstructorResult(con[1..])
    }

    predicate method {:tailrecursion} ValidConstructors(con : seq<Constructor>)
    {
      if |con| == 0 then
        true
      else
        if ValidConstructor(con[0].parts) then
          ValidConstructors(con[1..])
        else
          false
    }

    function method {:tailrecursion} ValidConstructorsResult(con : seq<Constructor>) : Result<bool, Error>
    {
      if |con| == 0 then
        Success(true)
      else
        var _ :- ValidConstructorResult(con[0].parts);
        ValidConstructorsResult(con[1..])
    }

    function method ValidState()
      : (ret : bool)
      ensures ret ==>
        //= specification/searchable-encryption/beacons.md#initialization-failure
        //= type=implication
        //# Initialization MUST fail if any `prefix` in any [part](#part) is a prefix of
        //# the `prefix` of any other [part](#part).
        && ValidPrefixSet()

        //= specification/searchable-encryption/beacons.md#initialization-failure
        //= type=implication
        //# Initialization MUST fail if any [constructor](#constructor) is configured with a field name
        //# that is not a defined [part](#part).
        && ValidConstructors(construct)
    {
      ValidPrefixSet() && ValidConstructors(construct)
    }

    function method ValidStateResult() : Result<bool, Error>
    {
      var _ :- ValidPrefixSetResult();
      var _ :- ValidConstructorsResult(construct);
      Success(true)
    }

    //= specification/searchable-encryption/beacons.md#part-value-calculation
    //= type=implication
    //# Part Value Calculation MUST take a string, a prefix, and an optional [beacon length](#beacon-length) as input, and return a string as output.
    function method {:opaque} PartValueCalc(data : string, prefix : string, length : Option<BeaconLength>)
      : (ret : Result<string, Error>)
      //= specification/searchable-encryption/beacons.md#part-value-calculation
      //= type=implication
      //# The input string MUST begin with the provided prefix.
      requires prefix <= data
      requires 0 < |prefix|

      //= specification/searchable-encryption/beacons.md#part-value-calculation
      //= type=implication
      //# If the [beacon length](#beacon-length) is not provided, the part value MUST be the input string.
      ensures length.None? ==>
        && ret.Success?
        && ret.value == data
        && 0 < |ret.value|

      //= specification/searchable-encryption/beacons.md#part-value-calculation
      //= type=implication
      //# If the [beacon length](#beacon-length) is provided,
      //# the part value MUST be the concatenation
      //# of the prefix and the [basicHash](#basichash) of the input string with the configured [beacon length](#beacon-length).
      ensures ret.Success? && length.Some? ==>
        && 0 < |ret.value|
        && base.hashStr(data, length.value).Success?
        && ret.value == prefix + base.hashStr(data, length.value).value
    {
      if length.None? then
        Success(data)
      else
        var hash :- base.hashStr(data, length.value);
        Success(prefix + hash)
    }
  }

  function method MakeDefaultConstructor(parts : seq<BeaconPart>)
    : Constructor
    requires 0 < |parts|
  {
    var cons := Seq.Map((x : BeaconPart) => ConstructorPart.ConstructorPart(x.name, true), parts);
    Constructor.Constructor(cons)
  }
}
