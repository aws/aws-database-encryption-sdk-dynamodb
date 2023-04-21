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

  datatype BeaconPart =
    | Sensitive(prefix : Prefix, beacon : BaseBeacon.StandardBeacon)
    | NonSensitive(prefix : Prefix, name : string, loc : TermLoc)
  {

    function method getPrefix() : string
    {
      match this {
        case Sensitive(p, b) => p
        case NonSensitive(p, n, l) => p
      }
    }

    function method getName() : string
    {
      match this {
        case Sensitive(p, b) => b.base.name
        case NonSensitive(p, n, l) => n
      }
    }

    function method getString(item : DDB.AttributeMap, vf : VirtualFieldMap) : Result<Option<string>, Error>
    {
      match this {
        case Sensitive(p, b) => VirtToString(b.loc, item, vf)
        case NonSensitive(p, n, l) => VirtToString(l, item, vf)
      }
    }

    function method GetFields(virtualFields : VirtualFieldMap) : seq<string>
    {
      match this {
        case Sensitive(p, b) => b.GetFields(virtualFields)
        case NonSensitive(p, n, l) =>
          if loc[0].key in virtualFields then
            virtualFields[loc[0].key].GetFields()
          else
            [loc[0].key]
      }
    }
  }

  datatype ConstructorPart = ConstructorPart (
    part : BeaconPart,
    required : bool
  )

  type ConstructorPartList = x : seq<ConstructorPart> | 0 < |x| witness *

  datatype Constructor = Constructor(
    parts : ConstructorPartList
  )

  type ConstructorList = x : seq<Constructor> | 0 < |x| witness *

  predicate method {:opaque} Any<T>(f: (T ~> bool), xs: seq<T>)
    requires forall i :: 0 <= i < |xs| ==> f.requires(xs[i])
    reads set i, o | 0 <= i < |xs| && o in f.reads(xs[i]) :: o
  {
    if |xs| == 0 then
      false
    else if f(xs[0]) then
      true
    else
      Any(f, xs[1..])
  }

  type ValidCompoundBeacon = x : CompoundBeacon | x.ValidState() witness *

  function method MakeCompoundBeacon(
    base : BeaconBase,
    split : char,
    parts : seq<BeaconPart>, // Non-Sensitive followed by Sensitive
    construct : ConstructorList
  )
    : Result<ValidCompoundBeacon, Error>
  {
    var x := CompoundBeacon.CompoundBeacon(base, split, parts, construct);
    var _ :- x.ValidPrefixSetResult();
    Success(x)
  }

  datatype CompoundBeacon = CompoundBeacon(
    base : BeaconBase,
    split : char,
    parts : seq<BeaconPart>, // Non-Sensitive followed by Sensitive
    construct : ConstructorList
  ) {

    predicate method isEncrypted() {
      Any((p : BeaconPart) => p.Sensitive?, parts)
    }

    function method {:tailrecursion} getPartFromPrefix(value : string)
      : (ret : Result<BeaconPart, Error>)
      ensures ret.Success? ==> ret.value.prefix <= value
    {
      partFromPrefix(parts, value)
    }

    function method {:tailrecursion} partFromPrefix(p : seq<BeaconPart>, value : string)
      : (ret : Result<BeaconPart, Error>)
      ensures ret.Success? ==> ret.value.prefix <= value
    {
      if |p| == 0 then
        Failure(E("Value " + value + " for beacon " + base.name + " does not match the prefix of any configured part."))
      else if p[0].prefix <= value then
        Success(p[0])
      else
        partFromPrefix(p[1..], value)
    }

    function method startsWithSigned(value : string) : Result<bool, Error>
    {
      var p :- partFromPrefix(parts, value);
      Success(p.NonSensitive?)
    }

    function method GetFields(virtualFields : VirtualFieldMap) : seq<string>
    {
      Seq.Flatten(Seq.Map((p : BeaconPart) => p.GetFields(virtualFields), parts))
    }

    function method FindAndCalcPart(value : string, keys : HmacKeyMap) : Result<string, Error>
    {
      var part :- partFromPrefix(parts, value);
      PartValueCalc(value, part.prefix, keys, part)
    }

    function method GetBeaconValue(value : DDB.AttributeValue, keys : HmacKeyMap) : Result<DDB.AttributeValue, Error>
    {
      if !value.S? then
        Failure(E("CompoundBeacon " + base.name + " can only be queried as a string, not as " + AttrTypeToStr(value)))
      else
        var parts := Split(value.S, split);
        var beaconParts :- Seq.MapWithResult(s => FindAndCalcPart(s, keys), parts);
        var result := Join(beaconParts, [split]);
        Success(DDB.AttributeValue.S(result))
    }

    function method {:opaque} {:tailrecursion} TryConstructor(
      consFields : seq<ConstructorPart>,
      item : DDB.AttributeMap,
      vf : VirtualFieldMap,
      keys : Option<HmacKeyMap>,
      acc : string := "")
      : (ret : Result<Option<string>, Error>)
      ensures ret.Success? && ret.value.Some? ==> |ret.value.value| > 0
    {
      if |consFields| == 0 then
        if |acc| ==  0 then
          Failure(E("Internal Error : Empty beacon created."))
        else
          Success(Some(acc))
      else
        var part := consFields[0].part;
        var strValue :- part.getString(item, vf);
        if strValue.Some? then
          :- Need(split !in strValue.value, E("Part " + part.getName() + " for beacon " + base.name + " has value '" + strValue.value + "' which contains the split character " + [split] + "'."));
          var val :-
            if keys.None? then
              Success(part.prefix + strValue.value)
            else
              PartValueCalc(part.prefix + strValue.value, part.prefix, keys.value, part);
          if |acc| == 0 then
            TryConstructor(consFields[1..], item, vf, keys, val)
          else
            TryConstructor(consFields[1..], item, vf, keys, acc + [split] + val)
        else if consFields[0].required then
          Success(None)
        else
          TryConstructor(consFields[1..], item, vf, keys, acc)
    }

    function method {:opaque} {:tailrecursion} TryConstructors(
      construct : seq<Constructor>,
      item : DDB.AttributeMap,
      vf : VirtualFieldMap,
      keys : Option<HmacKeyMap>
    )
      : (ret : Result<Option<string>, Error>)
      ensures ret.Success? && ret.value.Some? ==> |ret.value.value| > 0
    {
      if |construct| == 0 then
        Success(None)
      else
        var x :- TryConstructor(construct[0].parts, item, vf, keys);
        if x.Some? then
          Success(x)
        else
          TryConstructors(construct[1..], item, vf, keys)
    }

    function method {:opaque} hash(item : DDB.AttributeMap, vf : VirtualFieldMap, keys : HmacKeyMap) : (res : Result<Option<string>, Error>)
      ensures res.Success? && res.value.Some? ==>
                && |res.value.value| > 0
    {
      TryConstructors(construct, item, vf, Some(keys))
    }

    function method {:opaque} getNaked(item : DDB.AttributeMap, vf : VirtualFieldMap) : (res : Result<Option<string>, Error>)
      ensures res.Success? && res.value.Some? ==>
                && |res.value.value| > 0
    {
      TryConstructors(construct, item, vf, None)
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
    function method {:opaque} getPart(val : string, keys : HmacKeyMap)
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
                && calcParts(pieces, keys).Success?
                && ret.value == calcParts(pieces, keys).value
    {
      var pieces := Split(val, split);
      calcParts(pieces, keys)
    }

    function method calcPart(piece : string, keys : HmacKeyMap)
      : (ret : Result<string, Error>)

      ensures ret.Success? ==>
                && findPart(piece).Success?
                && |ret.value| > 0

                //= specification/searchable-encryption/beacons.md#getpart-for-a-compound-beacon
                //= type=implication
                //# * The [Part Value](#part-value-calculation) MUST be calculated for each piece,
                //# using the prefix and length from the discovered part.
                && var thePart := findPart(piece).value;
                && PartValueCalc(piece, thePart.prefix, keys, thePart).Success?
                && ret.value == PartValueCalc(piece, thePart.prefix, keys, thePart).value

      ensures findPart(piece).Failure? ==> ret.Failure?
    {
      var thePart :- findPart(piece);
      PartValueCalc(piece, thePart.prefix, keys, thePart)
    }

    function method calcParts(pieces : seq<string>, keys : HmacKeyMap, acc : string := [])
      : (ret : Result<string, Error>)
      requires |pieces| > 0 || |acc| > 0
      ensures ret.Success? ==> |ret.value| > 0
    {
      if |pieces| == 0 then
        Success(acc)
      else
        //= specification/searchable-encryption/beacons.md#getpart-for-a-compound-beacon
        //# * The value returned MUST be these part values, joined with the `split character`.
        var theBeacon :- calcPart(pieces[0], keys);
        if |acc| == 0 then
          calcParts(pieces[1..], keys, theBeacon)
        else
          calcParts(pieces[1..], keys, acc + [split] + theBeacon)
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

    function method CheckOnePrefixPart(pos1 : nat, pos2 : nat) : (ret : Result<bool, Error>)
      requires pos1 < |parts|
      requires pos2 < |parts|
      ensures ret.Success? ==> OkPrefixPair(pos1, pos2)
    {
      if !OkPrefixPair(pos1, pos2) then
        Failure(E("Compound beacon " + base.name + " defines part " + parts[pos1].getName() + " with prefix " + parts[pos1].prefix
                  + " which is incompatible with part " + parts[pos2].getName() + " which has a prefix of " + parts[pos2].prefix + "."))
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

    predicate ValidPrefixSet()
    {
      forall x : nat, y : nat
        | 0 <= x < |parts| && x < y < |parts|
        :: OkPrefixPair(x, y)
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
      ensures ret.Success? ==> ValidPrefixSet() && ret.value
    {
      var _ :- ValidPrefixSetResultPos(0);
      if forall x : nat, y : nat
        | 0 <= x < |parts| && x < y < |parts|
        :: OkPrefixPair(x, y) then
        Success(true)
      else
        Failure(E("Internal Error"))
    }

    predicate ValidState()
    {
      ValidPrefixSet()
    }

    function method {:opaque} PartValueCalc(data : string, prefix : string, keys : HmacKeyMap, part : BeaconPart)
      : (ret : Result<string, Error>)
      //= specification/searchable-encryption/beacons.md#part-value-calculation
      //= type=implication
      //# The input string MUST begin with the provided prefix.
      requires prefix <= data
      requires 0 < |prefix|
      requires prefix == part.getPrefix()

      //= specification/searchable-encryption/beacons.md#part-value-calculation
      //= type=implication
      //# If the [beacon length](#beacon-length) is not provided, the part value MUST be the input string.
      ensures part.NonSensitive? && ret.Success? ==>
                && ret.value == data
                && 0 < |ret.value|
                && split !in data

      //= specification/searchable-encryption/beacons.md#part-value-calculation
      //= type=implication
      //# If the [beacon length](#beacon-length) is provided,
      //# the part value MUST be the concatenation
      //# of the prefix and the [basicHash](#basichash) of the input string with the configured [beacon length](#beacon-length).
      ensures part.Sensitive? && ret.Success? ==>
                && 0 < |ret.value|
                && part.beacon.hashStr(data, keys).Success?
                && ret.value == prefix + part.beacon.hashStr(data, keys).value
                && split !in data
    {
      :- Need(split !in data, E("Value '" + data + "' for beacon part " + part.getName() + " contains the split character '" + [split] + "'."));
      match part {
        case Sensitive(p, b) =>
          var hash :- b.hashStr(data, keys);
          Success(prefix + hash)
        case NonSensitive =>
          Success(data)
      }
    }
  }

  function method MakeDefaultConstructor(parts : seq<BeaconPart>)
    : Constructor
    requires 0 < |parts|
  {
    var cons := Seq.Map((x : BeaconPart) => ConstructorPart.ConstructorPart(x, true), parts);
    Constructor.Constructor(cons)
  }
}
