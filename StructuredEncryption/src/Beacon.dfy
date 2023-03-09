// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

/*
  BaseBeacon.Beacon defines the way that input data (bytes or strings)
  is converted into beacons, for use in searchable encryption.

  The public interface of this module consists of the Beacon datatype, and four of its methods.
  - standardHash : turn a sequence of bytes into a hex string
  - compoundHash : turn a string into another string, containing one or more standardHash's and possibly some plain text.
  - isCompound : is this Beacon configured to do any of the fancy compoundHash things?
  - isValid : is the Beacon internally consistent?
*/


include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"
include "Util.dfy"

module BaseBeacon {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened StandardLibrary.String
  import opened AwsCryptographyStructuredEncryptionTypes
  import opened StructuredEncryptionUtil

  import Prim = AwsCryptographyPrimitivesTypes
  import Aws.Cryptography.Primitives
  import UTF8
  import Seq

  //= specification/structured-encryption/beacons.md#beacon-length
  //= type=implication
  //# A beacon length MUST be an integer between 1 and 63 inclusive,
  //# indicating the number of bits in the resulting beacon.
  newtype BeaconLength = x | 1 <= x <= 63 witness 1
  type FieldName = string
  type Prefix = string

  datatype SensitivePart = SensitivePart(
    //= specification/structured-encryption/beacons.md#sensitive-part
    //= type=implication
    //# A sensitive part config MUST have the following inputs:
    //# * A field name -- a string
    //# * A Prefix -- a string
    //# * A `length` -- a [beacon length](#beacon-length)
    fieldName : FieldName,
    prefix : Prefix,
    length : BeaconLength
  )

  datatype NonSensitivePart = NonSensitivePart(
    //= specification/structured-encryption/beacons.md#non-sensitive-part
    //= type=implication
    //# A non-sensitive part config MUST have the following inputs:
    //# * A field name -- a string
    //# * A Prefix -- a string
    fieldName : FieldName,
    prefix : Prefix
  )

  datatype Constructor = Constructor(
    //= specification/structured-encryption/beacons.md#constructor
    //= type=implication
    //# A Constructor MUST be a list of field names, each corresponding to a field name in a [part](#part).
    parts : seq<FieldName>
  )

  datatype CompoundBeacon = CompoundBeacon(
    //= specification/structured-encryption/beacons.md#compound-beacon-config
    //= type=implication
    //# A compound beacon config MUST have the following inputs:
    //# * A join string
    //# * A list of sensitive parts
    join : string,
    sensitive : seq<SensitivePart>,

    //= specification/structured-encryption/beacons.md#compound-beacon-config
    //= type=implication
    //# The following inputs to a compound beacon config MUST be OPTIONAL:
    //#  * A list of non-sensitive parts
    //#  * A list of constructors
    nonSensitive : seq<NonSensitivePart>,
    construct : seq<Constructor>
  )

  datatype BeaconType = 
    //= specification/structured-encryption/beacons.md#standard-beacon-config
    //= type=implication
    //# A standard beacon config MUST have
    //# * A `length` -- a [beacon length](#beacon-length)
    | StandardBeacon(length: BeaconLength)
    | CompoundBeacon(data : CompoundBeacon)

  datatype Beacon = Beacon(
    nameonly client: Primitives.AtomicPrimitivesClient,

    //= specification/structured-encryption/beacons.md#beacon-configuration
    //= type=implication
    //# The following inputs to this configuration are REQUIRED:
    //# * A name -- a sequence of characters
    //# * A plaintext HMAC key -- a sequence of bytes
    //# * A [standard beacon config](#standard-beaconconfig)
    //# or a [compound beacon config](#compound-beacon-config).
    nameonly name: string,
    nameonly key: Bytes,
    nameonly config: BeaconType
  ) {

    // Only three public facing functions

    //= specification/structured-encryption/beacons.md#standardhash
    //= type=implication
    //# * standardHash MUST take a sequence of bytes as input.
    function method {:opaque} standardHash(val : Bytes)
      : (ret : Result<string, Error>)
      ensures ret.Success? ==>
        && config.StandardBeacon?
        //= specification/structured-encryption/beacons.md#standardhash
        //= type=implication
        //# * standardHash MUST produce a non-empty string as output.
        && |ret.value| > 0

        //= specification/structured-encryption/beacons.md#standardhash
        //= type=implication
        //# * standardHash MUST calculate the [HmacSha384](https://www.ietf.org/rfc/rfc2104.txt)
        //# of the input bytes and the configured key, and keep the first 8 bytes.
        && getHmac(val).Success?
        && var hash := getHmac(val).value;

        //= specification/structured-encryption/beacons.md#standardhash
        //= type=implication
        //# * standardHash MUST return the rightmost [beacon length](#beacon-length) bits of these 8 bytes as a hexadecimal string.
        && ret.value == BytesToHex(hash, config.length)

        //= specification/structured-encryption/beacons.md#standardhash
        //= type=implication
        //# * the length of the returned string MUST be (`hash length`/4) rounded up.
        && |ret.value| == (((config.length as uint8) + 3) / 4) as nat
      
      //= specification/structured-encryption/beacons.md#standardhash
      //= type=implication
      //# * standardHash MUST fail if called on a beacon configured as a [compound beacon](#compound-beacon).
      ensures isCompound() ==> ret.Failure?
    {
      if isCompound() then
        Failure(E("standardHash must not be used with a compound beacon."))
      else
        stdHash(val, config.length)
    }

    function method compoundHash(val : string) : (res : Result<string, Error>)
      ensures res.Success? ==> 
        //= specification/structured-encryption/beacons.md#compoundhash
        //= type=implication
        //# * The returned string MUST NOT be empty.
        && |res.value| > 0

        //= specification/structured-encryption/beacons.md#compoundhash
        //= type=implication
        //# * compoundHash MUST fail if called on a beacon configured as a [standard beacon](#standard-beacon).
        && isCompound() 
    {
      if !isCompound() then
        Failure(E("compoundHash must not be used with a standard beacon."))
      else
        Success(" ")
    }

    // is this a standard hash? (as opposed to a compound hash)
    predicate method isCompound()
      //= specification/structured-encryption/beacons.md#iscompound
      //= type=implication
      //# isCompound MUST return `true` if the beacon is a [compound beacon](#compound-beacon),
      //# and false if the beacon is a [standard beacon](#standard-beacon).
      ensures isCompound() <==> config.CompoundBeacon?
      ensures !isCompound() <==> config.StandardBeacon?
    {
      config.CompoundBeacon?
    }

    predicate method isValid()
    {
      // TODO -- make list of all prefixes, test for substring
      // TODO -- make list of all names, test for duplicates
      // TODO -- needs list of configured fields, virtual fields
      true
    }

    // the rest is implementation

    /* Is true if there are no duplicate values in the sequence. */
    predicate method {:opaque} HasNoDuplicates<T(==)>(xs: seq<T>)
    {
      forall i, j :: 0 <= i < |xs| && 0 <= j < |xs| && i != j ==> xs[i] != xs[j]
    }


    // standardHash, but callable from compound hashes
    function method {:opaque} stdHash(val : Bytes, length : BeaconLength)
      : (ret : Result<string, Error>)
      ensures ret.Success? ==> 
        && |ret.value| > 0
        && getHmac(val).Success?
        && var hash := getHmac(val).value;
        && ret.value == BytesToHex(hash, length)
        && |ret.value| == (((length as uint8) + 3) / 4) as nat

    {
      var hash :- getHmac(val);
      Success(BytesToHex(hash, length))
    }

    // calculate the HMAC for some bytes
    function method getHmac(data  : Bytes) : (res : Result<Bytes, Error>)
      ensures res.Success? ==> |res.value| == 8
    {
      var input := Prim.HMacInput (
        digestAlgorithm := Prim.SHA_384,
        key := key,
        message := data
      );
      var outputR := client.HMac(input);
      var output :- outputR.MapFailure(e => AwsCryptographyPrimitives(e));
      if |output| != 48 then
        Failure(E("HMAC_384 did not produce 48 bits"))
      else
        Success(output[..8])
    }

    // Get the standard hash for the UTF8 encoded representation of this string.
    function method standardHashStr(val : string, length : BeaconLength) : (res : Result<string, Error>)
      ensures res.Success? ==> |res.value| > 0
    {
      var str := UTF8.Encode(val);
      if str.Failure? then
        Failure(E(str.error))
      else
        stdHash(str.value, length)
    }

    // return the hex character for this hex value
    static function method HexVal(x : uint8) : (res : char)
      requires x < 16
      ensures '0' <= res <= 'f'
    {
      if x < 10 then
        '0' + x as char
      else
        'a' + (x - 10) as char
    }

    // return the hex string for this byte
    static function method HexStr(x : uint8) : (ret : string)
      ensures |ret| == 2
    {
      if x < 16 then
        var res := ['0', HexVal(x)];
        res
      else
        var res := [HexVal((x / 16) as uint8), HexVal((x % 16) as uint8)];
        res
    }

    // return the hex string for these bytes, keeping any leading zero
    static function method {:tailrecursion} HexFmt(val : Bytes) : (ret : string)
      ensures |ret| == 2 * |val|
    {
      if |val| == 0 then
        []
      else
        HexStr(val[0]) + HexFmt(val[1..])
    }

    static function method CharsFromBeaconLength(bits : BeaconLength) : (ret : nat)
      ensures 0 < ret <= 16
    {
      (((bits as uint8) + 3) / 4) as nat
    }

    static function method TopBits(bits : BeaconLength) : (ret : uint8)
      ensures 1 <= ret <= 4
    {
      var x := bits as uint8 % 4;
      if x == 0 then 4 else x
    }

    static function method BytesFromBeaconLength(bits : BeaconLength) : (ret : nat)
      ensures 0 < ret <= 8
    {
      (((bits as uint8) + 7) / 8) as nat
    }

    static function method TruncateNibble(nibble : uint8, length : uint8) : uint8
      requires 0 <= nibble < 16
      requires 1 <= length <= 4
    {
      if length == 4 then nibble
      else if length == 3 then nibble % 8
      else if length == 2 then nibble % 4
      else nibble % 2
    }

    // turn 8-byte sequence into properly formatted bits-length hex string.
    static function method BytesToHex(bytes : Bytes, bits : BeaconLength) : (ret : string)
      requires |bytes| == 8

      ensures |ret| == (((bits as uint8) + 3) / 4) as nat
    {
      var numBytes := BytesFromBeaconLength(bits);
      var numChars := CharsFromBeaconLength(bits);
      var topBits := TopBits(bits);

      var bytes := bytes[8-numBytes..];
      if numChars == 2 * numBytes then
        var topNibble := bytes[0] / 16;
        var bottomNibble := bytes[0] % 16;
        [HexVal(TruncateNibble(topNibble, topBits)), HexVal(bottomNibble)] + HexFmt(bytes[1..])
      else
        [HexVal(TruncateNibble(bytes[0] % 16, topBits))] + HexFmt(bytes[1..])
    }
  
    lemma CheckBytesToHex()
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
        && BytesToHex(bytes, 9) == "1b7"
        && BytesToHex(bytes, 10) == "3b7"
    {}
  }
}