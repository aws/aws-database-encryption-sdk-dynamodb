// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "Util.dfy"
include "Beacon.dfy"

module CompoundBeacon {
  import opened Wrappers
  import opened BaseBeacon
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened StandardLibrary.String
  import opened TermLoc
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import opened DynamoDbEncryptionUtil
  import opened DdbVirtualFields

  import Prim = AwsCryptographyPrimitivesTypes
  import Primitives = AtomicPrimitives
  import UTF8
  import Seq
  import SortedSets
  import StandardLibrary.Sequence

  type Prefix = x : string | 0 < |x| witness *

  datatype BeaconPart =
    | Encrypted(prefix : Prefix, beacon : BaseBeacon.StandardBeacon)
    | Signed(prefix : Prefix, name : string, loc : TermLoc)
  {

    function method getPrefix() : string
    {
      match this {
        case Encrypted(p, b) => p
        case Signed(p, n, l) => p
      }
    }

    function method getName() : string
    {
      match this {
        case Encrypted(p, b) => b.base.name
        case Signed(p, n, l) => n
      }
    }

    function method getString(item : DDB.AttributeMap, vf : VirtualFieldMap) : Result<Option<string>, Error>
    {
      match this {
        case Encrypted(p, b) => VirtToString(b.loc, item, vf)
        case Signed(p, n, l) => VirtToString(l, item, vf)
      }
    }

    function method GetFields(virtualFields : VirtualFieldMap) : seq<string>
    {
      match this {
        case Encrypted(p, b) => b.GetFields(virtualFields)
        case Signed(p, n, l) =>
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
  ) {
    function method getReqParts() : set<BeaconPart>
    {
      set k <- parts | k.required :: k.part
    }
  }

  type ConstructorList = x : seq<Constructor> | 0 < |x| witness *

  type ValidCompoundBeacon = x : CompoundBeacon | x.ValidState() witness *

  function method MakeCompoundBeacon(
    base : BeaconBase,
    split : char,
    parts : seq<BeaconPart>, // Signed followed by Encrypted
    numSigned : nat,
    construct : ConstructorList
  )
    : (ret : Result<ValidCompoundBeacon, Error>)
    requires numSigned <= |parts|
    requires OrderedParts(parts, numSigned)

    //= specification/searchable-encryption/beacons.md#initialization-failure
    //= type=implication
    //# Initialization MUST fail if any `prefix` in any [part](#part) is a prefix of
    //# the `prefix` of any other [part](#part).
    ensures ret.Success? ==> ret.value.ValidPrefixSet()
  {
    var x := CompoundBeacon.CompoundBeacon(base, split, parts, numSigned, construct);
    var _ :- x.ValidPrefixSetResult();
    Success(x)
  }

  // are the parts properly ordered?
  // that is, with the signed parts followed the encrypted parts
  predicate OrderedParts(p : seq<BeaconPart>, n : nat)
    requires n <= |p|
  {
    && (forall x | 0 <= x < n :: p[x].Signed?)
    && (forall x | n <= x < |p| :: p[x].Encrypted?)
  }

  datatype CompoundBeacon = CompoundBeacon(
    base : BeaconBase,
    split : char,
    parts : seq<BeaconPart>,
    numSigned : nat,
    construct : ConstructorList
  ) {

    predicate ValidState()
    {
      && ValidPrefixSet()
      && numSigned <= |parts|
      && OrderedParts(parts, numSigned)
    }

    function method getNumQueries(globalMax : BucketCount) : BucketCount
    {
      var counts := GetBucketCountsFromValue(DDB.AttributeValue.S(""));
      if counts.Failure? then
        1
      else
        lcmSeq(counts.value, globalMax)
    }

    // no prefix is a prefix of another prefix
    // that is, no ambiguity when determining which prefix is used in a value
    predicate ValidPrefixSet()
    {
      forall x : nat, y : nat
        | 0 <= x < |parts| && x < y < |parts|
        :: OkPrefixPair(x, y)
    }

    // Does these parts refer to `name`
    predicate method {:tailrecursion} HasBeacon2(parts : seq<BeaconPart>, name : string)
    {
      if |parts| == 0 then
        false
      else if parts[0].getName() == name then
        true
      else
        HasBeacon2(parts[1..], name)
    }

    // Does this compound beacon refer to `name`
    predicate method HasBeacon(name : string)
    {
      HasBeacon2(parts, name)
    }

    // Does this beacon have any encrypted parts
    predicate method isEncrypted() {
      numSigned < |parts|
    }

    // find the part whose prefix matches this value
    function method getPartFromPrefix(value : string)
      : (ret : Result<BeaconPart, Error>)
      ensures ret.Success? ==> ret.value.prefix <= value
    {
      partFromPrefix(parts, value)
    }

    function method PartsToString(p : seq<BeaconPart>) : string
    {
      var beaconParts := Seq.Map((s : BeaconPart) => s.getPrefix(), p);
      if |beaconParts| == 0 then
        ""
      else
        Join(beaconParts, "")
    }

    function method CPartToString(s : ConstructorPart) : string
    {
      if s.required then
        s.part.getPrefix()
      else
        "[" + s.part.getPrefix() + "]"
    }

    function method CPartsToString(p : seq<ConstructorPart>) : string
    {
      var beaconParts := Seq.Map((s : ConstructorPart) => CPartToString(s), p);
      if |beaconParts| == 0 then
        ""
      else
        Join(beaconParts, "")
    }

    function method CListToString(p : ConstructorList) : string
    {
      var beaconParts := Seq.Map((s : Constructor) => CPartsToString(s.parts), p);
      Join(beaconParts, ", ")
    }

    // Can this constructor produce this list of parts?
    // e.g. if the constructor has A_.B_ then
    // these are ok : A_foo, B_foo, A_foo.B_foo
    // these are bad : B_foo.A_foo, A_foo.A_foo
    // that is, we can skip a arbitrary number of parts,
    // but once we match a part, the rest of inParts must be able to directly follow
    predicate method CanConstruct(con : seq<ConstructorPart>, inParts : seq<BeaconPart>, matched : bool := false)
    {
      if |inParts| == 0 then
        true
      else if |con| == 0 then
        false
      else if con[0].part == inParts[0] then
        CanConstruct(con[1..], inParts[1..], true)
      else if !con[0].required || !matched then
        CanConstruct(con[1..], inParts, matched)
      else
        false
    }

    // Fail unless one of these constructor can make a beacon composed of this sequence of parts
    predicate method {:tailrecursion} IsValidPartOrder(candidates : seq<Constructor>, inParts : seq<BeaconPart>)
    {
      if |candidates| == 0 then
        false
      else if CanConstruct(candidates[0].parts, inParts) then
        true
      else
        IsValidPartOrder(candidates[1..], inParts)
    }

    // Fail unless it is possible to construct a beacon composed of this sequence of parts
    function method ValidatePartOrder(inParts : seq<BeaconPart>, orig : string) : Result<bool, Error>
    {
      if IsValidPartOrder(construct, inParts) then
        Success(true)
      else
        var msg :=
          "Compound Beacon value '" + orig +
          "' cannot be constructed from any available constructor for " + base.name +
          " value parsed as " + PartsToString(inParts) +
          " available constructors are " + CListToString(construct) + ".";
        Failure(E(msg))
    }

    // find the part whose prefix matches this value
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

    // trim leading pieces that refer to signed parts
    function method SkipSignedPieces(pieces : seq<string>) : Result<seq<string>, Error>
    {
      if |pieces| == 0 then
        Success(pieces)
      else
        var p :- partFromPrefix(parts, pieces[0]);
        if p.Encrypted? then
          Success(pieces)
        else
          SkipSignedPieces(pieces[1..])
    }

    // predicate : are these pieces compatible with a less than operation
    function method IsLessThanComparable(pieces : seq<string>) : Result<bool, Error>
    {
      var rest :- SkipSignedPieces(pieces);
      if |rest| == 0 then
        Success(true)
      else if |rest| != 1 then
        Success(false)
      else
        var p :- partFromPrefix(parts, rest[0]);
        Success(p.prefix == rest[0])
    }

    // return all the fields involved in this beacon
    function method GetFields(virtualFields : VirtualFieldMap) : seq<string>
    {
      Sequence.Flatten(Seq.Map((p : BeaconPart) => p.GetFields(virtualFields), parts))
    }

    // calculate value for a single piece of a compound beacon query string
    function method FindAndCalcPart(value : string, keys : MaybeKeyMap, bucket : BucketNumber) : Result<string, Error>
      requires !keys.DontUseKeys?
    {
      var part :- partFromPrefix(parts, value);
      PartValueCalc(value[|part.prefix|..], keys, part, bucket)
    }

    // predicate : is the value simply the prefix, with no value
    function method justPrefix(value : string) : Result<bool, Error>
    {
      var part :- partFromPrefix(parts, value);
      Success(value == part.prefix)
    }

    // for the given attribute value, return the beacon value
    function method GetBeaconValue(value : DDB.AttributeValue, keys : MaybeKeyMap, forEquality : bool, bucket : BucketNumber) : Result<DDB.AttributeValue, Error>
      requires !keys.DontUseKeys?
    {
      if !value.S? then
        Failure(E("CompoundBeacon " + base.name + " can only be queried as a string, not as " + AttrTypeToStr(value)))
      else
        var parts := Split(value.S, split);
        var partsUsed :- Sequence.MapWithResult(s => getPartFromPrefix(s), parts);
        var _ :- ValidatePartOrder(partsUsed, value.S);
        var beaconParts :- Sequence.MapWithResult(s => FindAndCalcPart(s, keys, bucket), parts);
        var lastIsPrefix :- justPrefix(Seq.Last(parts));
        if !forEquality && lastIsPrefix then
          var result := Join(beaconParts[..|parts|-1] + [Seq.Last(parts)], [split]);
          Success(DDB.AttributeValue.S(result))
        else
          var result := Join(beaconParts, [split]);
          Success(DDB.AttributeValue.S(result))
    }

    function method GetBucketCountsFromParts(inParts : seq<BeaconPart>) : seq<BucketCount>
    {
      if |inParts| == 0 then
        []
      else if inParts[0].Encrypted? then
        [inParts[0].beacon.numberOfBuckets]
      else
        []
    }

    // for the given attribute value, return the beacon value
    function method GetBucketCountsFromValue(value : DDB.AttributeValue) : Result<seq<BucketCount>, Error>
    {
      if !value.S? then
        Failure(E("CompoundBeacon " + base.name + " can only be queried as a string, not as " + AttrTypeToStr(value)))
      else
        var parts := Split(value.S, split);
        var partsUsed :- Sequence.MapWithResult(s => getPartFromPrefix(s), parts);
        var _ :- ValidatePartOrder(partsUsed, value.S);
        Success(GetBucketCountsFromParts(partsUsed))
    }

    // return the beacon value for this constructor, if possible
    function method {:opaque} {:tailrecursion} TryConstructor(
      consFields : seq<ConstructorPart>,
      item : DDB.AttributeMap,
      vf : VirtualFieldMap,
      keys : MaybeKeyMap,
      bucket : BucketNumber,
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
        //= specification/searchable-encryption/beacons.md#value-for-a-compound-beacon
        //# * For that constructor, hash MUST join the [part value](#part-value) for each part
        //# on the `split character`,
        //# excluding parts that are not required and with a source field that is not available.
        if strValue.Some? then
          :- Need(split !in strValue.value, E("Part " + part.getName() + " for beacon " + base.name + " has value '" + strValue.value + "' which contains the split character " + [split] + "'."));
          var val :-
            if keys.DontUseKeys? then
              Success(part.prefix + strValue.value)
            else
              PartValueCalc(strValue.value, keys, part, bucket);
          if |acc| == 0 then
            TryConstructor(consFields[1..], item, vf, keys, bucket, val)
          else
            TryConstructor(consFields[1..], item, vf, keys, bucket, acc + [split] + val)
        else if consFields[0].required then
          Success(None)
        else
          TryConstructor(consFields[1..], item, vf, keys, bucket, acc)
    }

    // attempt each constructor in turn, until one succeeds
    function method {:opaque} {:tailrecursion} TryConstructors(
      construct : seq<Constructor>,
      item : DDB.AttributeMap,
      vf : VirtualFieldMap,
      keys : MaybeKeyMap,
      bucket : BucketNumber
    )
      : (ret : Result<Option<string>, Error>)
      ensures ret.Success? && ret.value.Some? ==> |ret.value.value| > 0
    {
      if |construct| == 0 then
        //= specification/searchable-encryption/beacons.md#value-for-a-compound-beacon
        //# * If no constructor succeeds, this operation MUST return no value.
        Success(None)
      else
        var x :- TryConstructor(construct[0].parts, item, vf, keys, bucket);
        if x.Some? then
          Success(x)
        else
          TryConstructors(construct[1..], item, vf, keys, bucket)
    }

    //= specification/searchable-encryption/beacons.md#value-for-a-compound-beacon
    //= type=implication
    //# * This operation MUST take a record as input, and produce an optional string.
    function method {:opaque} hash(item : DDB.AttributeMap, vf : VirtualFieldMap, keys : MaybeKeyMap, bucket : BucketNumber) : (res : Result<Option<string>, Error>)
      ensures res.Success? && res.value.Some? ==>
                //= specification/searchable-encryption/beacons.md#value-for-a-compound-beacon
                //= type=implication
                //# * If a string is returned, it MUST NOT be empty.
                && |res.value.value| > 0
                   //= specification/searchable-encryption/beacons.md#value-for-a-compound-beacon
                   //= type=implication
                   //# * This operation MUST iterate through all constructors, in order, using the first that succeeds.
                && TryConstructors(construct, item, vf, keys, bucket).Success?
    {
      TryConstructors(construct, item, vf, keys, bucket)
    }

    // return the unhashed beacon value, necessary for final client-side filtering
    function method {:opaque} getNaked(item : DDB.AttributeMap, vf : VirtualFieldMap, bucket : BucketNumber) : (res : Result<Option<string>, Error>)
      ensures res.Success? && res.value.Some? ==>
                && |res.value.value| > 0
    {
      TryConstructors(construct, item, vf, DontUseKeys, bucket)
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
    function method {:opaque} getPart(val : string, keys : HmacKeyMap, bucket : BucketNumber)
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
                && calcParts(pieces, keys, bucket).Success?
                && ret.value == calcParts(pieces, keys, bucket).value
    {
      var pieces := Split(val, split);
      calcParts(pieces, keys, bucket)
    }

    function method calcPart(piece : string, keys : HmacKeyMap, bucket : BucketNumber)
      : (ret : Result<string, Error>)

      ensures ret.Success? ==>
                && findPart(piece).Success?
                && |ret.value| > 0

                //= specification/searchable-encryption/beacons.md#getpart-for-a-compound-beacon
                //= type=implication
                //# * The [Part Value](#part-value-calculation) MUST be calculated for each piece,
                //# using the prefix and length from the discovered part.
                && var thePart := findPart(piece).value;
                && PartValueCalc(piece, Keys(keys), thePart, bucket).Success?
                && ret.value == PartValueCalc(piece, Keys(keys), thePart, bucket).value

      ensures findPart(piece).Failure? ==> ret.Failure?
    {
      var thePart :- findPart(piece);
      PartValueCalc(piece, Keys(keys), thePart, bucket)
    }

    function method calcParts(pieces : seq<string>, keys : HmacKeyMap, bucket : BucketNumber, acc : string := [])
      : (ret : Result<string, Error>)
      requires |pieces| > 0 || |acc| > 0
      ensures ret.Success? ==> |ret.value| > 0
    {
      if |pieces| == 0 then
        Success(acc)
      else
        //= specification/searchable-encryption/beacons.md#getpart-for-a-compound-beacon
        //# * The value returned MUST be these part values, joined with the `split character`.
        var theBeacon :- calcPart(pieces[0], keys, bucket);
        if |acc| == 0 then
          calcParts(pieces[1..], keys, bucket, theBeacon)
        else
          calcParts(pieces[1..], keys, bucket, acc + [split] + theBeacon)
    }

    // true if neither string is a prefix of the other
    static predicate method OkPrefixStringPair(x : string, y : string)
    {
      && !(x <= y)
      && !(y <= x)
    }

    // true is neither part's prefix is a prefix of the other
    predicate method OkPrefixPair(pos1 : nat, pos2 : nat)
      requires pos1 < |parts|
      requires pos2 < |parts|
    {
      || pos1 == pos2
      || OkPrefixStringPair(parts[pos1].prefix, parts[pos2].prefix)
    }

    // OkPrefixPair, but return Result with error message
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

    // error if this part's prefix is a prefix of another part's prefix
    function method CheckOnePrefix(pos : nat) : (ret : Result<bool, Error>)
      requires pos < |parts|
    {
      var partNumbers : seq<nat> := seq(|parts|, (i : nat) => i as nat);
      var _ :- Sequence.MapWithResult((p : int) requires 0 <= p < |parts| => CheckOnePrefixPart(pos, p), seq(|parts|, i => i));
      Success(true)
    }

    // error if any part's prefix is a prefix of another part's prefix
    function method {:tailrecursion} ValidPrefixSetResultPos(index : nat) : (ret : Result<bool, Error>)
      decreases |parts| - index
    {
      if |parts| <= index then
        Success(true)
      else
        var _ :- CheckOnePrefix(index);
        ValidPrefixSetResultPos(index+1)
    }

    // error if any part's prefix is a prefix of another part's prefix
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

    //= specification/searchable-encryption/beacons.md#part-value-calculation
    //= type=implication
    //# Part Value Calculation MUST take some [key materials](./search-config.md#get-beacon-key-materials),
    //# a string (the value for which the beacon is being calculated)
    //# and a [Part](#part) as input, and return a string as output.
    function method {:opaque} PartValueCalc(data : string, keys : MaybeKeyMap, part : BeaconPart, bucket : BucketNumber)
      : (ret : Result<string, Error>)
      requires !keys.DontUseKeys?

      //= specification/searchable-encryption/beacons.md#part-value-calculation
      //= type=implication
      //# If the part is a [signed part](#signed-part-initialization),
      //# the part value MUST be the concatenation of the part's prefix and the input string.
      ensures part.Signed? && ret.Success? ==>
                && ret.value == part.prefix + data
                && 0 < |ret.value|
                   //= specification/searchable-encryption/beacons.md#value-for-a-compound-beacon
                   //= type=implication
                   //# * This operation MUST fail if any plaintext value used in the construction contains the split character.
                && split !in data

      //= specification/searchable-encryption/beacons.md#part-value-calculation
      //= type=implication
      //# If the part is a [encrypted part](#encrypted-part-initialization),
      //# the part value MUST be the concatenation of the part's prefix
      //# and the [string hash](#string-hash) of the input string.
      ensures part.Encrypted? && ret.Success? ==>
                && 0 < |ret.value|
                && keys.Keys?
                && part.beacon.hashStr(data, keys.value, bucket).Success?
                && ret.value == part.prefix + part.beacon.hashStr(data, keys.value, bucket).value
                   //= specification/searchable-encryption/beacons.md#value-for-a-compound-beacon
                   //= type=implication
                   //# * This operation MUST fail if any plaintext value used in the construction contains the split character.
                && split !in data
    {
      :- Need(split !in data, E("Value '" + data + "' for beacon part " + part.getName() + " contains the split character '" + [split] + "'."));
      match part {
        case Encrypted(p, b) =>
          :- Need(keys.Keys?, E("Need KeyId for beacon " + b.base.name + " but no KeyId found in query."));
          var hash :- b.hashStr(data, keys.value, bucket);
          Success(part.prefix + hash)
        case Signed =>
          Success(part.prefix + data)
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
