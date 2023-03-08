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
  newtype BitLength = x | 1 <= x <= 63 witness 1

  datatype SplitRec = SplitRec (
    //= specification/structured-encryption/beacons.md#split-record
    //= type=implication
    //# The following inputs to this configuration are REQUIRED:
    //# * A `split` character, to designate a [split beacon](#split-beacon)
    //# * [split lengths](#split-lengths), a sequence of [beacon length](#beacon-length),
    //# for use with a [split beacon](#split-beacon)
    nameonly split: char,
    nameonly splitLens : seq<BitLength> := [],

    //= specification/structured-encryption/beacons.md#split-record
    //= type=implication
    //# The following inputs to this configuration MUST be OPTIONAL:
    // * An `inner` character to designate an [inner prefix](#inner-prefix)
    nameonly inner: Option<char> := None
  )

  datatype Beacon = Beacon(
    nameonly client: Primitives.AtomicPrimitivesClient,
    //= specification/structured-encryption/beacons.md#beacon-record
    //= type=implication
    //# The following inputs to this configuration are REQUIRED:
    // * A name -- a sequence of characters
    // * A plain text HMAC key -- a sequence of bytes
    // * A `length` -- a [beacon length](#beacon-length)
    nameonly name: string,
    nameonly key: Bytes,
    nameonly length: BitLength,

    //= specification/structured-encryption/beacons.md#beacon-record
    //= type=implication
    //# The following inputs to this configuration MUST be OPTIONAL:
    // * A `prefix` character, defining a [prefix beacon](#prefix-beacon)
    // * A [Split Record](#split-record) defining a [split beacon](#split-beacon)
    // * A `ignore` character, defining the [ignore character](#ignore-character)
    nameonly prefix: Option<char> := None,
    nameonly split: Option<SplitRec> := None,
    nameonly ignore: Option<char> := None
  ) {

    // Only three public facing functions

    //= specification/structured-encryption/beacons.md#standardhash
    //= type=implication
    //# * standardHash MUST take a sequence of bytes and an unsigned integer `position` as input.
    function method {:opaque} standardHash(val : Bytes, pos : nat := 0)
      : (ret : Result<string, Error>)
      ensures ret.Success? ==> 
        //= specification/structured-encryption/beacons.md#standardhash
        //= type=implication
        //# * standardHash MUST produce a non-empty string as output.
        && |ret.value| > 0

        //= specification/structured-encryption/beacons.md#standardhash
        //= type=implication
        //# * standardHash MUST calculate a hash length by calling [hashLength](#hashLength) with the supplied `position`.
        && hashLength(pos).Success?
        && var hashLength := hashLength(pos).value;

        && getHmacBytes(val).Success?
        && var hash := getHmacBytes(val).value;
        && ret.value == BytesToHex(hash, hashLength)
        && |ret.value| == (((hashLength as uint8) + 3) / 4) as nat
      
      //= specification/structured-encryption/beacons.md#standardhash
      //= type=implication
      //# * standardHash MUST fail if called on a beacon for which [isCompound](#iscompound) returns true.
      ensures isCompound() ==> ret.Failure?
    {
      if isCompound() then
        Failure(E("standardHash must not be used with a compound beacon."))
      else
        stdHash(val, pos)
    }

    // make a compound hash from a string
    //= specification/structured-encryption/beacons.md#compoundhash
    //= type=implication
    //# * compoundHash MUST take a string as input, and produce a string.
    function method compoundHash(val : string) : (res : Result<string, Error>)
      //= specification/structured-encryption/beacons.md#compoundhash
      //= type=implication
      //# * The returned string MUST NOT be empty.
      ensures res.Success? ==> |res.value| > 0

      //= specification/structured-encryption/beacons.md#compoundhash
      //= type=implication
      //# * If the [Beacon Record](#beacon-record) does not contain a [prefix character](#prefix-beacon),
      //# compoundHash MUST return the [splitHash](#splitHash) of the input string.
      ensures res.Success? && prefix.None? ==>
        && splitHash(val).Success?
        && res.value == splitHash(val).value 

      //= specification/structured-encryption/beacons.md#compoundhash
      //= type=implication
      //# * compoundHash MUST fail if the input string does not contain the prefix character.
      ensures prefix.Some? && prefix.value !in val ==> res.Failure?

      ensures (res.Success? && prefix.Some? && prefix.value in val) ==>
        && var ch := prefix.value;
        //= specification/structured-encryption/beacons.md#compoundhash
        //= type=implication
        //# * compoundHash MUST split the input string into two pieces,
        //# based on the first occurrence of the prefix character in the input string.
        && var parts := SplitOnce(val, ch);
        && splitHash(parts.1).Success?
        && var hash := splitHash(parts.1).value;

        //= specification/structured-encryption/beacons.md#compoundhash
        //= type=implication
        //# * If neither part is the ignore character, including when no ignore character is configured,
        //# compoundHash MUST return the concatenation of the first piece, the prefix character,
        //# and the [splitHash](#splitHash) of the second piece.
        && ((ignore.None? || ([ignore.value] != parts.0 && [ignore.value] != parts.1))
          ==> (res.value == parts.0 + [ch] + hash))

        //= specification/structured-encryption/beacons.md#compoundhash
        //= type=implication
        //# * If the first piece is the [ignore character](#ignore-character),
        //# compoundHash MUST return the [splitHash](#splitHash) of the second piece.
        && ((ignore.Some? && [ignore.value] == parts.0 && [ignore.value] != parts.1)
          ==> res.value == hash)

        //= specification/structured-encryption/beacons.md#compoundhash
        //= type=implication
        //# * If the second piece is the [ignore character](#ignore-character),
        //# compoundHash MUST return the concatenation of the first piece and the prefix character.
        && ((ignore.Some? && [ignore.value] != parts.0 && [ignore.value] == parts.1)
          ==> res.value == parts.0 + [ch])

      //= specification/structured-encryption/beacons.md#compoundhash
      //= type=implication
      //# * If both pieces are the [ignore character](#ignore-character),
      //# or one piece is the [ignore character](#ignore-character) and the other piece
      //# is the empty string, compoundHash MUST fail.
      ensures (
        && ignore.Some?
        && prefix.Some?
        && var ch := prefix.value;
        && ch in val
        && var parts := SplitOnce(val, ch);
        && (|| ([ignore.value] == parts.0 && [ignore.value] == parts.1)
            || (0 == |parts.0| && [ignore.value] == parts.1)
            || ([ignore.value] == parts.0 && 0 == |parts.1|)))
          ==> res.Failure?
    {
      match prefix
        case None => splitHash(val)
        case Some(ch) =>
          if ch in val then
            var parts := SplitOnce(val, ch);
            var hash :- splitHash(parts.1);
            if ignore.None? || ([ignore.value] != parts.0 && [ignore.value] != parts.1) then
              Success(parts.0 + [ch] + hash)
            else if
              || ([ignore.value] == parts.0 && [ignore.value] == parts.1) 
              || ([ignore.value] == parts.0 && 0 == |parts.1|) 
              || (0 == |parts.0| && [ignore.value] == parts.1) then
              Failure(E("Beacon for value " + val + " for field " + name + " would be empty"))
            else if [ignore.value] == parts.0 then
              Success(hash)
            else
              Success(parts.0 + [ch])
          else
            Failure(E("Tried to compute beacon " + name + " with prefix on " + val + " but prefix character '" + [ch] + "' not found in string"))
    }

    // is this a standard hash? (as opposed to a compound hash)
    function method isCompound()
      : bool

      //= specification/structured-encryption/beacons.md#iscompound
      //= type=implication
      //# isCompound MUST return `true` if a [prefix character](#prefix-beacon) or
      //# [Split Record](#split-record) is configured; and false otherwise.
      ensures isCompound() <==> prefix.Some? || split.Some?
    {
      prefix.Some? || split.Some?
    }

    predicate method isValid()
      //= specification/structured-encryption/beacons.md#split-record
      //= type=implication
      //# Construction MUST fail if a [Split Record](#split-record) is specified,
      //# and it specifies a non-empty [split lengths](#split-lengths),
      //# and the first element of [split lengths](#split-lengths) is not equal to
      //# the `length` in the beacon record.
      ensures (split.Some? && 0 < |split.value.splitLens| && split.value.splitLens[0] != length) ==> !isValid()

      //= specification/structured-encryption/beacons.md#split-record
      //= type=implication
      //# Construction MUST fail if any two of the `prefix`, `ignore`, `split` and `inner`
      //# characters are configured and equal to each other.
      ensures !CharsUnique() ==> !isValid()
    {
      && !(split.Some? && 0 < |split.value.splitLens| && split.value.splitLens[0] != length)
      && CharsUnique()
    }

    // the rest is implementation

    predicate method CharsUnique()
    {
      var chars :=
          (if prefix.Some? then [prefix.value] else [])
        + (if ignore.Some? then [ignore.value] else [])
        + (if split.Some? then [split.value.split] else [])
        + (if split.Some? && split.value.inner.Some? then [split.value.inner.value] else []);
      HasNoDuplicates(chars)
    }

    /* Is true if there are no duplicate values in the sequence. */
    predicate method {:opaque} HasNoDuplicates<T(==)>(xs: seq<T>)
    {
      forall i, j :: 0 <= i < |xs| && 0 <= j < |xs| && i != j ==> xs[i] != xs[j]
    }


    // standardHash, but callable from compound hashes
    function method {:opaque} stdHash(val : Bytes, pos : nat := 0)
      : (ret : Result<string, Error>)
      //= specification/structured-encryption/beacons.md#stdhash
      //= type=implication
      //# stdHash MUST provide standardHash with the guarantees it requires.
      ensures ret.Success? ==> 
        && |ret.value| > 0
        && hashLength(pos).Success?
        && var hashLength := hashLength(pos).value;
        && getHmacBytes(val).Success?
        && var hash := getHmacBytes(val).value;
        && ret.value == BytesToHex(hash, hashLength)
        && |ret.value| == (((hashLength as uint8) + 3) / 4) as nat

    {
      var hash :- getHmacBytes(val);
      var len :- hashLength(pos);
      Success(BytesToHex(hash, len))
    }

    // calculate the HMAC for some bytes
    function method getHmac(data  : Bytes) : (res : Result<Bytes, Error>)
      ensures res.Success? ==> |res.value| == 48
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
        Success(output)
    }

    function method getHmacBytes(data : Bytes)
      : (ret : Result<Bytes, Error>)
      ensures ret.Success? ==> |ret.value| == 8

      //= specification/structured-encryption/beacons.md#standardhash
      //= type=implication
      //# * standardHash MUST calculate the [HmacSha384](https://www.ietf.org/rfc/rfc2104.txt)
      //# of the input bytes and the configured key, and keep the first 8 bytes.
      ensures ret.Success? ==>
        && getHmac(data).Success?
        && ret.value == getHmac(data).value[..8]
    {
      var hmac :- getHmac(data);
      Success(hmac[..8])
    }

    // Get the hash length for this part of a split
    //= specification/structured-encryption/beacons.md#hashlength
    //= type=implication
    //# * hashLength MUST take an unsigned integer `position` as input and return a [beacon length](#beacon-length).
    function method hashLength(pos : nat)
      : (ret : Result<BitLength, Error>)
      ensures ret.Success? ==>
        //= specification/structured-encryption/beacons.md#hashlength
        //= type=implication
        //# * If the input is position is zero, hashLength MUST return the beacons's `length`.
        && ((pos == 0) ==> ret.value == length)

        //= specification/structured-encryption/beacons.md#hashlength
        //= type=implication
        //# * If `split-lengths` is empty or absent, hashLength MUST return the beacons's `length`.
        && ((split.None? || |split.value.splitLens| == 0) ==> ret.value == length)

        //= specification/structured-encryption/beacons.md#hashlength
        //= type=implication
        //# * If the input position is less than the number of values in `split-lengths`,
        //# hashLength MUST return the (zero-based) Nth number in the list.
        && (0 < pos && split.Some? && 0 < |split.value.splitLens| ==>
           (pos < |split.value.splitLens| && ret.value == split.value.splitLens[pos]))

      //= specification/structured-encryption/beacons.md#hashlength
      //= type=implication
      //# * If the input position is greater than or equal to the number of values in `split-lengths`,
      //# hashLength MUST fail.
      ensures split.Some? && 0 < |split.value.splitLens| && |split.value.splitLens| <= pos ==> ret.Failure?
    {
      if pos == 0 then
        Success(length)
      else if split.None? || |split.value.splitLens| == 0 then
        Success(length)
      else if pos as int >= |split.value.splitLens| then
        Failure(E("Beacon " + name + " configured for " + Base10Int2String(|split.value.splitLens|) + " parts, but looking for part " + Base10Int2String(pos)))
      else
        Success(split.value.splitLens[pos])
    }

    // Get the standard hash for the UTF8 encoded representation of this string.
    function method standardHashStr(val : string, pos : nat := 0) : (res : Result<string, Error>)
      ensures res.Success? ==> |res.value| > 0
    {
      var str := UTF8.Encode(val);
      if str.Failure? then
        Failure(E(str.error))
      else
        stdHash(str.value, pos)
    }

    // Get the hash for one part of a split
    //= specification/structured-encryption/beacons.md#innerhash
    //= type=implication
    //# * innerHash MUST take a string and an unsigned integer, `position`, as input and produce a string.
    function method innerHash(val : string, pos : nat) : (res : Result<string, Error>)
      //= specification/structured-encryption/beacons.md#innerhash
      //= type=implication
      //# * The returned string MUST NOT be empty.
      ensures res.Success? ==> |res.value| > 0
      
      //= specification/structured-encryption/beacons.md#innerhash
      //= type=implication
      //# * If the configuration does not specify an [inner](#inner-prefix) character,
      //# innerHash MUST return the [stdHash](#stdhash) of the input string and the supplied position.
      ensures res.Success? && (split.None? || split.value.inner.None?) ==>
        && standardHashStr(val, pos).Success?
        && res.value == standardHashStr(val, pos).value

      //= specification/structured-encryption/beacons.md#innerhash
      //= type=implication
      //# * innerHash MUST split the input string into two pieces, on the
      //# first occurrence on the [inner](#inner-prefix) character, returning the concatenation of
      // * the first part of the input string
      // * the inner character
      // * the [standardHash](#standardhash) of the second part of the string and the supplied position.
      ensures res.Success? && split.Some? && split.value.inner.Some? ==>
        && var ch := split.value.inner.value;
        && ch in val
        && var parts := SplitOnce(val, ch);
        && standardHashStr(parts.1, pos).Success?
        && res.value == parts.0 + [ch] + standardHashStr(parts.1, pos).value

      //= specification/structured-encryption/beacons.md#innerhash
      //= type=implication
      //# * innerHash MUST fail if the input string does not contain the [inner](#inner-prefix) character.
      ensures split.Some? && split.value.inner.Some? && split.value.inner.value !in val ==>
        res.Failure?
    {
      if split.None? || split.value.inner.None? then
        standardHashStr(val, pos)
      else
        var ch := split.value.inner.value;
        if ch in val then
          var parts := SplitOnce(val, ch);
          var hash :- standardHashStr(parts.1, pos);
          Success(parts.0 + [ch] + hash)
        else
          Failure(E("Tried to compute beacon " + name + " with inner prefix on " + val + " but inner character '" + [ch] + "' not found in string"))
    }

    // Split the value into pieces, hash each piece, then reassemble
    // with each piece preceded by the delimiter
    function method {:tailrecursion} assemble(val : seq<string>, delim : char, pos : nat, orig : string, mode : SplitMode := Start, acc : string := [])
      : (res : Result<string, Error>) {
      if |val| == 0 then
        if mode == Start then
          Failure(E("Value " + orig + " for field " + name + " has all ignored values"))
        else
          Success(acc)
      else
        if ignore.Some? && val[0] == [ignore.value] then
          var newMode := if mode == Start then Start else End;
          assemble(val[1..], delim, pos+1, orig, newMode, acc)
        else
          if mode == End then
            Failure(E("Value " + orig + " for field " + name + " has discontinuous values"))
          else
            var h :- innerHash(val[0], pos);
            assemble(val[1..], delim, pos+1, orig, SawReal, acc + [delim] + h)
    }

    // ensure that splitting a string wth these parts is ok
    predicate method {:opaque} OKSplit(orig : string, parts : seq<string>)
      requires split.Some?
    {
      var split := split.value;
      |split.splitLens| == 0 || |parts| == |split.splitLens|
    }

    // Split the value, if necessary, and make a hash of each part
    //= specification/structured-encryption/beacons.md#splithash
    //= type=implication
    //# * splitHash MUST take a string as input and produce a string.
    function method splitHash(val : string) : (res : Result<string, Error>)
      //= specification/structured-encryption/beacons.md#splithash
      //= type=implication
      //# * The returned string MUST NOT be empty.
      ensures res.Success? ==> |res.value| > 0

      //= specification/structured-encryption/beacons.md#splithash
      //= type=implication
      //# * If the [Beacon Record](#beacon-record) does not specify a [Split Record](#split-record)
      //# splitHash MUST return the [stdHash](#stdhash) of the input string and zero.
      ensures res.Success? && split.None? ==>
        && standardHashStr(val, 0).Success?
        && res.value == standardHashStr(val, 0).value

      ensures res.Success? && split.Some? ==>
        && var sp := split.value;

        //= specification/structured-encryption/beacons.md#splithash
        //= type=implication
        //# * splitHash MUST split the input string into pieces based on the [split](#split-beacon) character.
        && var parts := Split(val, sp.split);

        //= specification/structured-encryption/beacons.md#splithash
        //# * splitHash MUST calculate the concatenation of,
        //# for each part that is not the [ignore](#ignore-character) character,
        //# the split character followed by the [innerHash](#innerHash) of the part and its position.
        && assemble(parts, sp.split, 0, val).Success?

        //= specification/structured-encryption/beacons.md#splithash
        //= type=implication
        //# * splitHash MUST return the above calculation, followed by the split character.
        && res.value == assemble(parts, sp.split, 0, val).value + [sp.split]

      //= specification/structured-encryption/beacons.md#splithash
      //= type=implication
      //# * splitHash MUST fail if `split-lengths` is not empty and
      //# the number of pieces in the input string
      //# is not equal to the number of lengths in `split-lengths`.
      ensures split.Some? && 0 < |split.value.splitLens| && |Split(val, split.value.split)| != |split.value.splitLens|
        ==> res.Failure?
    {
      match split
        case None => standardHashStr(val, 0)
        case Some(sp) =>
          var parts := Split(val, sp.split);
          :- Need(|split.value.splitLens| == 0 || |parts| == |split.value.splitLens|,
          E("Beacon " + name + " configured for " + Base10Int2String(|split.value.splitLens|) + " parts, but '" + val + "' has " + Base10Int2String(|parts|) + " parts."));
          var str :- assemble(parts, sp.split, 0, val);
          Success(str + [sp.split])
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
        var y := x as bv8;
        var res := [HexVal((y >> 4) as uint8), HexVal((y & 0xf) as uint8)];
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

    static function method CharsFromBitLength(bits : BitLength) : (ret : nat)
      ensures 0 < ret <= 16
    {
      (((bits as uint8) + 3) / 4) as nat
    }

    static function method TopBits(bits : BitLength) : (ret : uint8)
      ensures 1 <= ret <= 4
    {
      var x := bits as uint8 % 4;
      if x == 0 then 4 else x
    }

    static function method BytesFromBitLength(bits : BitLength) : (ret : nat)
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
    static function method BytesToHex(bytes : Bytes, bits : BitLength) : (ret : string)
      requires |bytes| == 8

      //= specification/structured-encryption/beacons.md#standardhash
      //= type=implication
      //# * the length of the returned string MUST be (`hash length`/4) rounded up.
      ensures |ret| == (((bits as uint8) + 3) / 4) as nat
    {
      var numBytes := BytesFromBitLength(bits);
      var numChars := CharsFromBitLength(bits);
      var topBits := TopBits(bits);
      //= specification/structured-encryption/beacons.md#standardhash
      //= type=implication
      //# * standardHash MUST return the rightmost `hash length` bits of these 8 bytes as a hexadecimal string.
      // This can be an implication, because nothing is gained by duplicating all of this code above in an ensures.
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

  // When a split has ignore, you must have only a single run of non-ignored values
  // Start : the leading ignores
  // SawReal : the first run of non-ignores
  // End : the second run of ignores
  // if a non-ignore appears after that, it's an error
  // This declaration is at the bottom, because it is an implementation detail
  // and the only other choice is prominently at the top
  datatype SplitMode = Start | SawReal | End


}