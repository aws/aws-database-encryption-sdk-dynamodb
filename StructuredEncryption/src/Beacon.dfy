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
    nameonly split: char,
    nameonly splitLens : seq<BitLength> := [],

    nameonly inner: Option<char> := None
  )

  datatype Beacon = Beacon(
    nameonly client: Primitives.AtomicPrimitivesClient,

    nameonly name: string,
    nameonly key: Bytes,
    nameonly length: BitLength,

    nameonly prefix: Option<char> := None,
    nameonly split: Option<SplitRec> := None,
    nameonly ignore: Option<char> := None
  ) {

    // Only three public facing functions

    function method {:opaque} standardHash(val : Bytes, pos : nat := 0)
      : (ret : Result<string, Error>)
      ensures ret.Success? ==> 
        && |ret.value| > 0

        && hashLength(pos).Success?
        && var hashLength := hashLength(pos).value;

        && getHmacBytes(val).Success?
        && var hash := getHmacBytes(val).value;
        && ret.value == BytesToHex(hash, hashLength)
        && |ret.value| == (((hashLength as uint8) + 3) / 4) as nat
      
      ensures isCompound() ==> ret.Failure?
    {
      if isCompound() then
        Failure(E("standardHash must not be used with a compound beacon."))
      else
        stdHash(val, pos)
    }

    function method compoundHash(val : string) : (res : Result<string, Error>)
      ensures res.Success? ==> |res.value| > 0

      ensures res.Success? && prefix.None? ==>
        && splitHash(val).Success?
        && res.value == splitHash(val).value 

      ensures prefix.Some? && prefix.value !in val ==> res.Failure?

      ensures (res.Success? && prefix.Some? && prefix.value in val) ==>
        && var ch := prefix.value;
        && var parts := SplitOnce(val, ch);
        && splitHash(parts.1).Success?
        && var hash := splitHash(parts.1).value;

        && ((ignore.None? || ([ignore.value] != parts.0 && [ignore.value] != parts.1))
          ==> (res.value == parts.0 + [ch] + hash))

        && ((ignore.Some? && [ignore.value] == parts.0 && [ignore.value] != parts.1)
          ==> res.value == hash)

        && ((ignore.Some? && [ignore.value] != parts.0 && [ignore.value] == parts.1)
          ==> res.value == parts.0 + [ch])

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

      ensures isCompound() <==> prefix.Some? || split.Some?
    {
      prefix.Some? || split.Some?
    }

    predicate method isValid()
      ensures (split.Some? && 0 < |split.value.splitLens| && split.value.splitLens[0] != length) ==> !isValid()

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

      ensures ret.Success? ==>
        && getHmac(data).Success?
        && ret.value == getHmac(data).value[..8]
    {
      var hmac :- getHmac(data);
      Success(hmac[..8])
    }

    function method hashLength(pos : nat)
      : (ret : Result<BitLength, Error>)
      ensures ret.Success? ==>
        && ((pos == 0) ==> ret.value == length)

        && ((split.None? || |split.value.splitLens| == 0) ==> ret.value == length)

        && (0 < pos && split.Some? && 0 < |split.value.splitLens| ==>
           (pos < |split.value.splitLens| && ret.value == split.value.splitLens[pos]))

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

    function method innerHash(val : string, pos : nat) : (res : Result<string, Error>)
      ensures res.Success? ==> |res.value| > 0
      
      ensures res.Success? && (split.None? || split.value.inner.None?) ==>
        && standardHashStr(val, pos).Success?
        && res.value == standardHashStr(val, pos).value

      ensures res.Success? && split.Some? && split.value.inner.Some? ==>
        && var ch := split.value.inner.value;
        && ch in val
        && var parts := SplitOnce(val, ch);
        && standardHashStr(parts.1, pos).Success?
        && res.value == parts.0 + [ch] + standardHashStr(parts.1, pos).value

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

    function method splitHash(val : string) : (res : Result<string, Error>)
      ensures res.Success? ==> |res.value| > 0

      ensures res.Success? && split.None? ==>
        && standardHashStr(val, 0).Success?
        && res.value == standardHashStr(val, 0).value

      ensures res.Success? && split.Some? ==>
        && var sp := split.value;

        && var parts := Split(val, sp.split);

        && assemble(parts, sp.split, 0, val).Success?

        && res.value == assemble(parts, sp.split, 0, val).value + [sp.split]

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

      ensures |ret| == (((bits as uint8) + 3) / 4) as nat
    {
      var numBytes := BytesFromBitLength(bits);
      var numChars := CharsFromBitLength(bits);
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

  // When a split has ignore, you must have only a single run of non-ignored values
  // Start : the leading ignores
  // SawReal : the first run of non-ignores
  // End : the second run of ignores
  // if a non-ignore appears after that, it's an error
  // This declaration is at the bottom, because it is an implementation detail
  // and the only other choice is prominently at the top
  datatype SplitMode = Start | SawReal | End


}