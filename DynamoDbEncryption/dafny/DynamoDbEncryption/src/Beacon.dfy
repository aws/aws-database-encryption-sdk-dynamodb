// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "Util.dfy"
include "Virtual.dfy"
include "DynamoToStruct.dfy"

module BaseBeacon {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened StandardLibrary.String
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import opened HexStrings
  import opened DynamoDbEncryptionUtil
  import opened DdbVirtualFields
  import opened Seq
  import DynamoToStruct

  import DDB = ComAmazonawsDynamodbTypes
  import Prim = AwsCryptographyPrimitivesTypes
  import Primitives = AtomicPrimitives
  import UTF8
  import SortedSets
  import TermLoc

  //= specification/searchable-encryption/beacons.md#beacon-length
  //= type=implication
  //# A beacon length MUST be an integer between 1 and 63 inclusive,
  //# indicating the number of bits in the resulting beacon.
  newtype BeaconLength = x | 1 <= x <= 63 witness 1

  // half of a byte, or one hex character
  type Nibble = x : uint8 | 0 <= x < 16

  datatype BeaconBase = BeaconBase(
    nameonly client: Primitives.AtomicPrimitivesClient,
    nameonly name: string,
    nameonly beaconName: DDB.AttributeName
  ) {

    //= specification/searchable-encryption/beacons.md#basichash
    //= type=implication
    //# * basicHash MUST take an [hmac key](./search-config.md#hmac-key-generation), a [beacon length](#beacon-length) and a sequence of bytes as input.
    function method {:opaque} hash(val : Bytes, key : Bytes, length : BeaconLength)
      : (ret : Result<string, Error>)
      ensures ret.Success? ==>
                //= specification/searchable-encryption/beacons.md#basichash
                //= type=implication
                //# * basicHash MUST produce a non-empty string as output.
                && |ret.value| > 0

                && getHmac(val, key).Success?
                && var hash := getHmac(val, key).value;

                //= specification/searchable-encryption/beacons.md#basichash
                //= type=implication
                //# * basicHash MUST return the rightmost [beacon length](#beacon-length) bits of these 8 bytes as a hexadecimal string.
                && ret.value == BytesToHex(hash, length)

                //= specification/searchable-encryption/beacons.md#basichash
                //= type=implication
                //# * the length of the returned string MUST be (`beacon length`/4) rounded up.
                && |ret.value| == (((length as uint8) + 3) / 4) as nat

    {
      var hash :- getHmac(val, key);
      Success(BytesToHex(hash, length))
    }

    // Get the standard hash for the UTF8 encoded representation of this string.
    function method {:opaque} hashStr(val : string, key : Bytes, length : BeaconLength) : (res : Result<string, Error>)
      ensures res.Success? ==> |res.value| > 0
    {
      var str := UTF8.Encode(val);
      if str.Failure? then
        Failure(E(str.error))
      else
        hash(str.value, key, length)
    }

    // calculate the HMAC for some bytes
    function method {:opaque} getHmac(data : Bytes, key : Bytes) : (res : Result<Bytes, Error>)
      ensures res.Success? ==> |res.value| == 8

      ensures res.Success? ==>
                //= specification/searchable-encryption/beacons.md#basichash
                //= type=implication
                //# * basicHash MUST calculate the [HmacSha384](https://www.ietf.org/rfc/rfc2104.txt)
                //# of the input bytes and the [hmac key](./search-config.md#hmac-key-generation), and keep the first 8 bytes.
                && var input := Prim.HMacInput(digestAlgorithm := Prim.SHA_384, key := key, message := data);
                && client.HMac(input).Success?
                && res.value == client.HMac(input).value[..8]
    {
      var input := Prim.HMacInput (
                     digestAlgorithm := Prim.SHA_384,
                     key := key,
                     message := data
                   );
      var output :- client.HMac(input).MapFailure(e => AwsCryptographyPrimitives(e));
      Success(output[..8])
    }
  }

  type ValidStandardBeacon = x : StandardBeacon | x.ValidState() witness *

  function method MakeStandardBeacon(
    client: Primitives.AtomicPrimitivesClient,
    name: string,
    length : BeaconLength,
    loc : string,
    partOnly : bool,
    asSet : bool,
    share : Option<string>
  )
    : (ret : Result<ValidStandardBeacon, Error>)
    ensures ret.Success? ==>
              && TermLoc.MakeTermLoc(loc).Success?
              && ret.value.loc == TermLoc.MakeTermLoc(loc).value
  {
    var termLoc :- TermLoc.MakeTermLoc(loc);
    var beaconName := BeaconPrefix + name;
    :- Need(DDB.IsValid_AttributeName(beaconName), E(beaconName + " is not a valid attribute name."));
    Success(StandardBeacon.StandardBeacon(
              BeaconBase (
                client := client,
                name := name,
                beaconName := beaconName
              ),
              length,
              termLoc,
              partOnly,
              asSet,
              share
            ))
  }
  datatype StandardBeacon = StandardBeacon (
    base : BeaconBase,
    length : BeaconLength,
    loc : TermLoc.TermLoc,
    partOnly : bool,
    asSet : bool,
    share : Option<string>
  ) {
    function method {:opaque} hash(val : Bytes, key : Bytes)
      : (ret : Result<string, Error>)
      ensures ret.Success? ==>
                && |ret.value| > 0
                && base.hash(val, key, length).Success?
                && ret.value == base.hash(val, key, length).value

                && |ret.value| == (((length as uint8) + 3) / 4) as nat
    {
      base.hash(val, key, length)
    }

    // return the name of the hmac key to use
    //= specification/searchable-encryption/beacons.md#shared-initialization
    //# This beacon MUST calculate its [value](#beacon-value) as if it were the `other` beacon.
    function method keyName() : string
    {
      if share.Some? then
        share.value
      else
        base.name
    }

    // Get the standard hash for the UTF8 encoded representation of this string.
    //= specification/searchable-encryption/beacons.md#string-hash
    //= type=implication
    //# * string hash MUST take a string and some [key materials](./search-config.md#get-beacon-key-materials)
    //# as input, and produce a string as output.
    function method {:opaque} hashStr(val : string, keys : HmacKeyMap) : (res : Result<string, Error>)
      ensures res.Success? ==> |res.value| > 0

      //= specification/searchable-encryption/beacons.md#string-hash
      //= type=implication
      //# * string hash MUST return the [basic hash](#basichash) of the UTF8 representation
      //# of the input string, the HMAC key from the [key materials](./search-config.md#get-beacon-key-materials)
      //# associated with this beacon, and the beacon length associated with this beacon.
      ensures res.Success? ==>
                && keyName() in keys
                && UTF8.Encode(val).Success?
                && var str := UTF8.Encode(val).value;
                && hash(str, keys[keyName()]).Success?
                && res.value == hash(str, keys[keyName()]).value
    {
      :- Need(keyName() in keys, E("Internal Error, no key for " + keyName()));
      var str := UTF8.Encode(val);
      if str.Failure? then
        Failure(E(str.error))
      else
        hash(str.value, keys[keyName()])
    }

    function method {:opaque} ValueToSet(value : DDB.AttributeValue, key : Bytes) : (ret : Result<DDB.AttributeValue, Error>)
      ensures ret.Success? ==> ret.value.SS?
      ensures !value.SS? && !value.NS? && !value.BS? ==> ret.Failure?
      ensures ret.Success? ==> HasNoDuplicates(ret.value.SS)
    {
      reveal HasNoDuplicates();
      assert HasNoDuplicates<string>([]);
      var beaconSeq :- match value {
        case SS(n) => BeaconizeStringSet(n, key)
        case NS(n) => BeaconizeNumberSet(n, key)
        case BS(n) => BeaconizeBinarySet(n, key)
        case _ => Failure(E("Beacon " + base.name + " has style AsSet, but attribute has type " + AttrTypeToStr(value) + "."))
      };
      Success(DDB.AttributeValue.SS(beaconSeq))
    }

    //= specification/searchable-encryption/beacons.md#value-for-a-standard-beacon
    //= type=implication
    //# * This operation MUST take an [hmac key](./search-config.md#hmac-key-generation), a record as input, and produce an optional [AttributeValue](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_AttributeValue.html).
    function method {:opaque} getHash(item : DDB.AttributeMap, vf : VirtualFieldMap, key : Bytes) : (ret : Result<Option<DDB.AttributeValue>, Error>)
      //= specification/searchable-encryption/beacons.md#value-for-a-standard-beacon
      //= type=implication
      //# * If this beacon is marked AsSet then this operation MUST return the
      //# [set value](#value-for-a-set-standard-beacon),
      //# otherwise it MUST return the [non-set value](#value-for-a-non-set-standard-beacon)
      ensures asSet ==> ret == getHashSet(item, key)
      ensures !asSet ==> ret == getHashNonSet(item, vf, key)
    {
      if asSet then
        getHashSet(item, key)
      else
        getHashNonSet(item, vf, key)
    }

    function method {:opaque} getHashSet(item : DDB.AttributeMap, key : Bytes) : (ret : Result<Option<DDB.AttributeValue>, Error>)
      requires asSet
      ensures ret.Success? ==>
                //= specification/searchable-encryption/beacons.md#value-for-a-set-standard-beacon
                //= type=implication
                //# * The returned
                //# [AttributeValue](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_AttributeValue.html)
                //# MUST be type "SS" StringSet.
                && (ret.value.Some? ==> ret.value.value.SS?)
                   //= specification/searchable-encryption/beacons.md#value-for-a-set-standard-beacon
                   //= type=implication
                   //# * The resulting set MUST NOT contain duplicates.
                && (ret.value.Some? ==> HasNoDuplicates(ret.value.value.SS))
                   //= specification/searchable-encryption/beacons.md#asset-initialization
                   //= type=implication
                   //# * Writing an item MUST fail if the item contains this beacon's attribute,
                   //# and that attribute is not of type Set.
                && var value := TermLoc.TermToAttr(loc, item, None);
                && (value.Some? && !(value.value.SS? || value.value.NS? || value.value.BS?) ==> ret.Failure?)
    {
      var value := TermLoc.TermToAttr(loc, item, None);
      if value.None? then
        Success(None)
      else
        //= specification/searchable-encryption/beacons.md#asset-initialization
        //# * The Standard Beacon MUST be stored in the item as a Set,
        //# comprised of the [beacon values](#beacon-value) of all the elements in the original Set.
        var setValue :- ValueToSet(value.value, key);
        Success(Some(setValue))
    }
    function method {:opaque} getHashNonSet(item : DDB.AttributeMap, vf : VirtualFieldMap, key : Bytes) : (ret : Result<Option<DDB.AttributeValue>, Error>)
      requires !asSet
      ensures ret.Success? ==>
                //= specification/searchable-encryption/beacons.md#value-for-a-non-set-standard-beacon
                //= type=implication
                //# * The returned
                //# [AttributeValue](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_AttributeValue.html)
                //# MUST be type "S" String.
                && (ret.value.Some? ==> ret.value.value.S?)
                && VirtToBytes(loc, item, vf).Success?
                && var bytes := VirtToBytes(loc, item, vf).value;
                //= specification/searchable-encryption/beacons.md#value-for-a-standard-beacon
                //= type=implication
                //# * This operation MUST return no value if the associated field does not exist in the record
                && (bytes.None? ==> ret.value.None?)
                   //= specification/searchable-encryption/beacons.md#value-for-a-non-set-standard-beacon
                   //= type=implication
                   //# * This operation MUST convert the attribute value of the associated field to
                   //# a sequence of bytes, as per [attribute serialization](../dynamodb-encryption-client/ddb-attribute-serialization.md).
                && (bytes.Some? ==> ret.value.Some? && hash(bytes.value, key).Success? && ret.value.value == DDB.AttributeValue.S(hash(bytes.value, key).value))
                   //= specification/searchable-encryption/beacons.md#value-for-a-non-set-standard-beacon
                   //= type=implication
                   //# * This operation MUST return the [basicHash](#basichash) of the resulting bytes and the configured [beacon length](#beacon-length).
                && (bytes.Some? ==> ret.value.Some? && base.hash(bytes.value, key, length).Success? && ret.value.value == DDB.AttributeValue.S(base.hash(bytes.value, key, length).value))
    {
      var bytes :- VirtToBytes(loc, item, vf);
      if bytes.None? then
        Success(None)
      else
        var res :- hash(bytes.value, key);
        Success(Some(DDB.AttributeValue.S(res)))
    }

    function method {:opaque} getNaked(item : DDB.AttributeMap, vf : VirtualFieldMap) : Result<Option<DDB.AttributeValue>, Error>
    {
      VirtToAttr(loc, item, vf)
    }

    function method GetFields(virtualFields : VirtualFieldMap) : seq<string>
    {
      if loc[0].key in virtualFields then
        virtualFields[loc[0].key].GetFields()
      else
        [loc[0].key]
    }

    function method {:tailrecursion} BeaconizeStringSet(value : DDB.StringSetAttributeValue, key : Bytes, converted : seq<string> := [])
      : (ret : Result<seq<string>, Error>)
      requires HasNoDuplicates(converted)
      ensures ret.Success? ==> HasNoDuplicates(ret.value)
    {
      if |value| == 0 then
        Success(converted)
      else
        var bytes :- DynamoToStruct.TopLevelAttributeToBytes(DDB.AttributeValue.S(value[0])).MapFailure(e => E(e));
        var h :- hash(bytes, key);
        if h in converted then
          BeaconizeStringSet(value[1..], key, converted)
        else
          reveal HasNoDuplicates();
          BeaconizeStringSet(value[1..], key, converted + [h])
    }

    function method {:tailrecursion} BeaconizeNumberSet(value : DDB.NumberSetAttributeValue, key : Bytes, converted : seq<string> := [])
      : (ret : Result<seq<string>, Error>)
      requires HasNoDuplicates(converted)
      ensures ret.Success? ==> HasNoDuplicates(ret.value)
    {
      if |value| == 0 then
        Success(converted)
      else
        var bytes :- DynamoToStruct.TopLevelAttributeToBytes(DDB.AttributeValue.N(value[0])).MapFailure(e => E(e));
        var h :- hash(bytes, key);
        if h in converted then
          BeaconizeNumberSet(value[1..], key, converted)
        else
          reveal HasNoDuplicates();
          BeaconizeNumberSet(value[1..], key, converted + [h])
    }

    function method {:tailrecursion} BeaconizeBinarySet(value : DDB.BinarySetAttributeValue, key : Bytes, converted : seq<string> := [])
      : (ret : Result<seq<string>, Error>)
      requires HasNoDuplicates(converted)
      ensures ret.Success? ==> HasNoDuplicates(ret.value)
    {
      if |value| == 0 then
        Success(converted)
      else
        var bytes :- DynamoToStruct.TopLevelAttributeToBytes(DDB.AttributeValue.B(value[0])).MapFailure(e => E(e));
        var h :- hash(bytes, key);
        if h in converted then
          BeaconizeBinarySet(value[1..], key, converted)
        else
          reveal HasNoDuplicates();
          BeaconizeBinarySet(value[1..], key, converted + [h])
    }

    function method GetBeaconValue(value : DDB.AttributeValue, key : Bytes, forContains : bool)
      : (ret : Result<DDB.AttributeValue, Error>)
    {
      // in query, allow beaconization of terminals
      if asSet && !value.S? && !value.N? && !value.B? then
        ValueToSet(value, key)
      else if forContains && (value.SS? || value.NS? || value.BS?) then
        ValueToSet(value, key)
      else
        var bytes :- DynamoToStruct.TopLevelAttributeToBytes(value).MapFailure(e => E(e));
        var h :- hash(bytes, key);
        Success(DDB.AttributeValue.S(h))
    }

    //= specification/searchable-encryption/beacons.md#getpart-for-a-standard-beacon
    //= type=implication
    //# * getPart MUST take an [hmac key](./search-config.md#hmac-key-generation), a sequence of bytes as input, and produce a string.
    function method {:opaque} getPart(val : Bytes, key : Bytes)
      : (ret : Result<string, Error>)
      requires 0 < |val|

      ensures ret.Success? ==>
                && |ret.value| > 0

      ensures ret.Success? ==>
                //= specification/searchable-encryption/beacons.md#getpart-for-a-standard-beacon
                //= type=implication
                //# * getPart MUST return the [basicHash](#basichash) of the input and the configured [beacon length](#beacon-length).
                && base.hash(val, key, length).Success?
                && ret.value == base.hash(val, key, length).value
    {
      base.hash(val, key, length)
    }
    predicate ValidState() {true}
  }

  // For a given BeaconLength, how many chars in the associated hex string?
  function method CharsFromBeaconLength(bits : BeaconLength) : (ret : nat)
    ensures 0 < ret <= 16
  {
    (((bits as uint8) + 3) / 4) as nat
  }

  // For a given BeaconLength, how many bits are kept in the top Nibble
  function method TopBits(bits : BeaconLength) : (ret : uint8)
    ensures 1 <= ret <= 4
  {
    var x := bits as uint8 % 4;
    if x == 0 then 4 else x
  }

  // For a given BeaconLength, how many bytes of the underlying hash are used?
  function method BytesFromBeaconLength(bits : BeaconLength) : (ret : nat)
    ensures 0 < ret <= 8
  {
    (((bits as uint8) + 7) / 8) as nat
  }

  // keep only the bottom `length` bits of this value
  function method TruncateNibble(nibble : Nibble, length : uint8) : Nibble
    requires 1 <= length <= 4
  {
    if length == 4 then nibble
    else if length == 3 then nibble % 8
    else if length == 2 then nibble % 4
    else nibble % 2
  }

  // turn 8-byte sequence into properly formatted bits-length hex string.
  function method BytesToHex(bytes : Bytes, bits : BeaconLength) : (ret : string)
    requires |bytes| == 8
    ensures |ret| == (((bits as uint8) + 3) / 4) as nat
  {
    var numBytes := BytesFromBeaconLength(bits);
    var numChars := CharsFromBeaconLength(bits);
    var topBits := TopBits(bits);

    var bytes := bytes[8-numBytes..];
    if numChars == 2 * numBytes then
      var topNibble := (bytes[0] / 16);
      var bottomNibble := (bytes[0] % 16);
      [HexChar(TruncateNibble(topNibble, topBits)), HexChar(bottomNibble)] + ToHexString(bytes[1..])
    else
      [HexChar(TruncateNibble(bytes[0] % 16, topBits))] + ToHexString(bytes[1..])
  }
}
