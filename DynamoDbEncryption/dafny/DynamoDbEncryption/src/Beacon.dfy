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
  import DynamoToStruct

  import DDB = ComAmazonawsDynamodbTypes
  import Prim = AwsCryptographyPrimitivesTypes
  import Aws.Cryptography.Primitives
  import UTF8
  import Seq
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
    loc : string
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
              termLoc
            ))
  }
  datatype StandardBeacon = StandardBeacon (
    base : BeaconBase,
    length : BeaconLength,
    loc : TermLoc.TermLoc
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
        && base.name in keys
        && UTF8.Encode(val).Success?
        && var str := UTF8.Encode(val).value;
        && hash(str, keys[base.name]).Success?
        && res.value == hash(str, keys[base.name]).value
    {
      :- Need(base.name in keys, E("Internal Error, no key for " + base.name));
      var str := UTF8.Encode(val);
      if str.Failure? then
        Failure(E(str.error))
      else
        hash(str.value, keys[base.name])
    }

    //= specification/searchable-encryption/beacons.md#value-for-a-standard-beacon
    //= type=implication
    //# * This operation MUST take an [hmac key](./search-config.md#hmac-key-generation), a record as input, and produce an optional string.
    function method {:opaque} getHash(item : DDB.AttributeMap, vf : VirtualFieldMap, key : Bytes) : (ret : Result<Option<string>, Error>)
      ensures ret.Success? ==>
                && VirtToBytes(loc, item, vf).Success?
                   //= specification/searchable-encryption/beacons.md#value-for-a-standard-beacon
                   //= type=implication
                   //# * This operation MUST convert the attribute value of the associated field to
                   //# a sequence of bytes, as per [attribute serialization](../dynamodb-encryption-client/ddb-attribute-serialization.md).
                && var bytes := VirtToBytes(loc, item, vf).value;
                //= specification/searchable-encryption/beacons.md#value-for-a-standard-beacon
                //= type=implication
                //# * This operation MUST return no value if the associated field does not exist in the record
                && (bytes.None? ==> ret.value.None?)
                   //= specification/searchable-encryption/beacons.md#value-for-a-standard-beacon
                   //= type=implication
                   //# * This operation MUST return the [basicHash](#basichash) of the input and the configured [beacon length](#beacon-length).
                && (bytes.Some? ==> ret.value.Some? && hash(bytes.value, key).Success? && ret.value.value == hash(bytes.value, key).value)
                && (bytes.Some? ==> ret.value.Some? && base.hash(bytes.value, key, length).Success? && ret.value.value == base.hash(bytes.value, key, length).value)
    {
      var bytes :- VirtToBytes(loc, item, vf);
      if bytes.None? then
        Success(None)
      else
        var res :- hash(bytes.value, key);
        Success(Some(res))
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

    function method GetBeaconValue(value : DDB.AttributeValue, key : Bytes) : Result<DDB.AttributeValue, Error>
    {
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

  lemma {:vcs_split_on_every_assert} CheckBytesToHex()
    ensures
      && var bytes := [1,2,3,4,5,6,7,0xb7];
      && BytesToHex(bytes, 1) == "1"
      && BytesToHex(bytes, 2) == "3"
      && BytesToHex(bytes, 3) == "7"
      && BytesToHex(bytes, 4) == "7"
      && BytesToHex(bytes, 5) == "17"
      && BytesToHex(bytes, 6) == "37"
      && BytesToHex(bytes, 7) == "37"
      && BytesToHex(bytes, 8) == "b7"
  {}
}
