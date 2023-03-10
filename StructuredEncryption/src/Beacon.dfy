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
include "Paths.dfy"

module BaseBeacon {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened StandardLibrary.String
  import opened AwsCryptographyStructuredEncryptionTypes
  import opened StructuredEncryptionUtil
  import opened StructuredEncryptionPaths

  import Prim = AwsCryptographyPrimitivesTypes
  import Aws.Cryptography.Primitives
  import UTF8
  import Seq
  import SortedSets

  //= specification/structured-encryption/beacons.md#beacon-length
  //= type=implication
  //# A beacon length MUST be an integer between 1 and 63 inclusive,
  //# indicating the number of bits in the resulting beacon.
  newtype BeaconLength = x | 1 <= x <= 63 witness 1
  type FieldName = string
  type Prefix = x : string | |x| > 0 witness *
  type ConstructorList = x : seq<FieldName> | |x| > 0 witness *

  // if length is null, this is a non-sensitive part
  datatype Part = Part (
    fieldName : FieldName,
    prefix : Prefix,
    length : Option<BeaconLength>
  )

  datatype Constructor = Constructor(
    //= specification/structured-encryption/beacons.md#constructor
    //= type=implication
    //# A Constructor MUST be a list of field names, each corresponding to a field name in a [part](#part).
    parts : ConstructorList
  )

  datatype CompoundBeacon = CompoundBeacon(
    split : char,
    parts : seq<Part>, // all Non-Sensitive followed by all Sensitive
    construct : seq<Constructor>
  )

  datatype BeaconType = 
    //= specification/structured-encryption/beacons.md#standard-beacon-config
    //= type=implication
    //# A standard beacon config MUST have
    //# * A `length` -- a [beacon length](#beacon-length)
    | Standard(length: BeaconLength)
    | Compound(data : CompoundBeacon)

  type Stringify = (TerminalLocation) -> Result<string,string>

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
      //= specification/structured-encryption/beacons.md#standardhash
      //= type=implication
      //# * standardHash MUST be used with a beacon configured as a [standard beacon](#standard-beacon).
      requires !isCompound()
      ensures ret.Success? ==>
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
    {
      stdHash(val, config.length)
    }

    function method {:opaque} BuildDefault(parts : seq<Part>, fields : map<string, string>, acc : string := [], haveSens : bool := false)
      : (ret : Result<string, Error>)
      requires isCompound()
      requires haveSens ==> |acc| > 0
      ensures haveSens ==> |acc| > 0
      ensures ret.Success? ==> |ret.value| > 0
    {
      if |parts| == 0 then
        if haveSens then
          Success(acc)
        else
          Failure(E("Default constructor for " + name + " could not find a sensitive part."))
      else if parts[0].fieldName in fields then
        var val :- PartValueCalc(parts[0].prefix + fields[parts[0].fieldName], parts[0].prefix, parts[0].length);
        if |acc| == 0 then
          BuildDefault(parts[1..], fields, val, parts[0].length.Some?)
        else
          BuildDefault(parts[1..], fields, acc + [config.data.split] + val, parts[0].length.Some?)
      else
        BuildDefault(parts[1..], fields, acc, haveSens)
    }

    function method FindPartByName(name : string) : Result<Part, Error>
      requires isCompound()
    {
      // TODO - prove and keep track, so this can't fail
      var part := Seq.Filter((x : Part) => (x.fieldName == name), config.data.parts);
      :- Need(|part| == 1, E("Internal error, constructor named non-existent part"));
      Success(part[0])
    }

    function method {:opaque} TryConstructor(consFields : seq<FieldName>, fields : map<string, string>, acc : string := "")
      : (ret : Result<string, Error>)
      requires isCompound()
      requires |consFields| > 0 || |acc| > 0
      ensures ret.Success? ==> |ret.value| > 0
    {
      if |consFields| == 0 then
        Success(acc)
      else
        :- Need(consFields[0] in fields, E("")); // this error message never propagated
        var part :- FindPartByName(consFields[0]);
        var val :- PartValueCalc(part.prefix + fields[part.fieldName], part.prefix, part.length);
        if |acc| == 0 then
          TryConstructor(consFields[1..], fields, val)
        else
          TryConstructor(consFields[1..], fields, acc + [config.data.split] + val)
    }

    function method {:opaque} TryConstructors(construct : seq<Constructor>, fields : map<string, string>)
      : (ret : Result<string, Error>)
      requires isCompound()
      ensures ret.Success? ==> |ret.value| > 0
    {
      if |construct| == 0 then
        Failure(E("No constructor for " + name + " could be satisfied."))
      else
        var x := TryConstructor(construct[0].parts, fields);
        if x.Success? then
          x
        else
          TryConstructors(construct[1..], fields)
    }

    //= specification/structured-encryption/beacons.md#compoundhash
    //= type=implication
    //# * compoundHash MUST take a record as input, and produce a string.
    function method {:opaque} compoundHash(fields : map<string, string>) : (res : Result<string, Error>)
      //= specification/structured-encryption/beacons.md#compoundhash
      //= type=implication
      //# * compoundHash MUST be used with a beacon configured as a [compound beacon](#compound-beacon).
      requires isCompound()
      ensures res.Success? ==> 
        //= specification/structured-encryption/beacons.md#compoundhash
        //= type=implication
        //# * The returned string MUST NOT be empty.
        && |res.value| > 0
    {
      if |config.data.construct| == 0 then
        BuildDefault(config.data.parts, fields)
      else
        TryConstructors(config.data.construct, fields)
    }

    // is this a standard hash? (as opposed to a compound hash)
    predicate method isCompound()
      //= specification/structured-encryption/beacons.md#iscompound
      //= type=implication
      //# isCompound MUST return `true` if the beacon is a [compound beacon](#compound-beacon),
      //# and false if the beacon is a [standard beacon](#standard-beacon).
      ensures isCompound() <==> config.Compound?
      ensures !isCompound() <==> config.Standard?
    {
      config.Compound?
    }

    function method {:opaque} findPart(val : string)
      : (ret : Result<Part, Error>)
      requires isCompound()
      ensures |Seq.Filter((x : Part) => (x.prefix <= val), config.data.parts)| == 0 ==> ret.Failure?
      ensures ret.Success? ==>
        ret.value.prefix <= val
    {
      var thePart : seq<Part> := Seq.Filter((x : Part) => (x.prefix <= val), config.data.parts);
      if |thePart| == 0 then
        Failure(E("No part found in beacon " + name + " match prefix " + val))
      else if |thePart| > 1 then
        Failure(E("Internal error. Multiple parts for beacon " + name + " matched prefix of " + val))
      else
        assert |thePart| == 1;
        Success(thePart[0])
    }

    //= specification/structured-encryption/beacons.md#getpart
    //= type=implication
    //# * getPart MUST take a string as input and returns a string as output.
    function method {:opaque} getPart(val : string)
      : (ret : Result<string, Error>)
      requires 0 < |val|

      //= specification/structured-encryption/beacons.md#getpart
      //= type=implication
      //# * The returned string MUST NOT be empty.
      ensures ret.Success? ==> 
        && |ret.value| > 0
      
      //= specification/structured-encryption/beacons.md#getpart
      //= type=implication
      //# * If called on a beacon configured as a [standard beacon](#standard-beacon),
      //# getPart MUST return the [standardHash](#standardhash) of the input string
      //# and the configured [beacon length](#beacon-length).
      ensures ret.Success? && !isCompound() ==>
        && standardHashStr(val, config.length).Success?
        && ret.value == standardHashStr(val, config.length).value
    {
      if isCompound() then
        var pieces := Split(val, config.data.split);
        calcParts(pieces)
      else
        standardHashStr(val, config.length)
    }

    function method calcPart(piece : string)
      : (ret : Result<string, Error>)
      requires isCompound()

      ensures ret.Success? ==>
        //= specification/structured-encryption/beacons.md#getpart
        //= type=implication
        //# * For each piece, a [part](#part) MUST be identified by matching the prefix of a [part](#part)
        //# to the beginning of the piece.
        && findPart(piece).Success?
        && |ret.value| > 0

      //= specification/structured-encryption/beacons.md#getpart
      //= type=implication
      //# * If no such part exists, this operation MUST fail.
      ensures findPart(piece).Failure? ==> ret.Failure?
    {
      var thePart :- findPart(piece);
      PartValueCalc(piece, thePart.prefix, thePart.length)
    }

    function method calcParts(pieces : seq<string>, acc : string := [])
      : (ret : Result<string, Error>)
      requires isCompound()
      requires |pieces| > 0 || |acc| > 0
      ensures ret.Success? ==> |ret.value| > 0
    {
      if |pieces| == 0 then
        Success(acc)
      else
        var theBeacon :- calcPart(pieces[0]);
        if |acc| == 0 then
          calcParts(pieces[1..], theBeacon)
        else
          calcParts(pieces[1..], acc + [config.data.split] + theBeacon)
    }

    predicate method ValidPrefixSet()
      requires isCompound()
    {
      forall x : nat, y : nat
        | 0 <= x <= |config.data.parts| && x < y <= |config.data.parts|
        :: !(config.data.parts[x].prefix <= config.data.parts[x].prefix)
    }

    static predicate method IsEncrypted(schema : CryptoSchemaPlain, fieldName : FieldName)
    {
      && fieldName in schema
      && schema[fieldName].content.Action == ENCRYPT_AND_SIGN
    }

    //= specification/structured-encryption/beacons.md#constructor
    //# Construction MUST fail if any [non-sensitive-part](#non-sensitive-part) contains
    //# any part of an encrypted field, or any [sensitive-part](#sensitive-part) does not contain
    //# any part of an encrypted field.
    predicate method ValidNonSensitive(schema : CryptoSchemaPlain)
      requires isCompound()
    {
      && |Seq.Filter((x : Part) => x.length.None? &&  IsEncrypted(schema, x.fieldName), config.data.parts)| == 0
      && |Seq.Filter((x : Part) => x.length.Some? && !IsEncrypted(schema, x.fieldName), config.data.parts)| == 0
    }

    //= specification/structured-encryption/beacons.md#constructor
    //# Construction MUST fail if any [constructor](#constructor) is configured with a field name
    //# that is not a defined [part](#part).
    predicate method ValidPart(f : FieldName)
      requires isCompound()
    {
      |Seq.Filter((x : Part) => x.fieldName == f, config.data.parts)| == 1
    }

    predicate method ValidConstructor(con : seq<FieldName>)
      requires isCompound()
    {
      if |con| == 0 then
        true
      else
        && ValidPart(con[0])
        && ValidConstructor(con[1..])
    }

    predicate method ValidConstructors(con : seq<Constructor>)
      requires isCompound()
    {
      if |con| == 0 then
        true
      else
        ValidConstructor(con[0].parts) && ValidConstructors(con[1..])
    }

    function method isValid(schema : CryptoSchemaPlain, virtualFields : map<string,string>, unauthPrefix : string)
      : (ret : bool)
      ensures ret && isCompound() ==>
        //= specification/structured-encryption/beacons.md#constructor
        //= type=implication
        //# Construction MUST fail if any `prefix` in any [part](#part) is a prefix of
        //# the `prefix` of any other [part](#part).
        && ValidPrefixSet()

        //= specification/structured-encryption/beacons.md#constructor
        //= type=implication
        //# Construction MUST fail if any [non-sensitive-part](#non-sensitive-part) contains
        //# any part of an encrypted field, or any [sensitive-part](#sensitive-part) does not contain
        //# any part of an encrypted field.
        && ValidNonSensitive(schema)

        //= specification/structured-encryption/beacons.md#constructor
        //= type=implication
        //# Construction MUST fail if any [constructor](#constructor) is configured with a field name
        //# that is not a defined [part](#part).
        && ValidConstructors(config.data.construct)
    {
      var result := name !in schema && name !in virtualFields && !(unauthPrefix <= name);

      if isCompound() then
        result && ValidPrefixSet() && ValidNonSensitive(schema) && ValidConstructors(config.data.construct)
      else
        result
    }

    // the rest is implementation

    /* Is true if there are no duplicate values in the sequence. */
    predicate method {:opaque} HasNoDuplicates<T(==)>(xs: seq<T>)
    {
      forall i, j :: 0 <= i < |xs| && 0 <= j < |xs| && i != j ==> xs[i] != xs[j]
    }

    //= specification/structured-encryption/beacons.md#part-value-calculation
    //= type=implication
    //# Part Value Calculation MUST take a string, a prefix, and an optional [beacon length](#beacon-length) as input, and return a string as output.
    function method {:opaque} PartValueCalc(data : string, prefix : string, length : Option<BeaconLength>)
      : (ret : Result<string, Error>)
      //= specification/structured-encryption/beacons.md#part-value-calculation
      //= type=implication
      //# The input string MUST begin with the provided prefix.
      requires prefix <= data
      requires 0 < |prefix|

      //= specification/structured-encryption/beacons.md#part-value-calculation
      //= type=implication
      //# If the [beacon length](#beacon-length) is not provided, the part value MUST be the input string.
      ensures length.None? ==>
        && ret.Success?
        && ret.value == data
        && 0 < |ret.value|

      //= specification/structured-encryption/beacons.md#part-value-calculation
      //= type=implication
      //# If the [beacon length](#beacon-length) is provided,
      //# the part value MUST be the concatenation
      //# of the prefix and the [standardHash](#standardhash) of the input string with the configured [beacon length](#beacon-length).
      ensures ret.Success? && length.Some? ==>
        && 0 < |ret.value|
        && standardHashStr(data, length.value).Success?
        && ret.value == prefix + standardHashStr(data, length.value).value
    {
      if length.None? then
        Success(data)
      else
        var hash :- standardHashStr(data, length.value);
        Success(prefix + hash)
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
    function method {:opaque} getHmac(data  : Bytes) : (res : Result<Bytes, Error>)
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
        Failure(E("HMAC_384 did not produce 384 bits"))
      else
        Success(output[..8])
    }

    // Get the standard hash for the UTF8 encoded representation of this string.
    function method {:opaque} standardHashStr(val : string, length : BeaconLength) : (res : Result<string, Error>)
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
      // return the hex string for these bytes, keeping any leading zero
     function method {:tailrecursion} HexFmt(val : Bytes) : (ret : string)
      ensures |ret| == 2 * |val|
    {
      if |val| == 0 then
        []
      else
        Beacon.HexStr(val[0]) + HexFmt(val[1..])
    }

}