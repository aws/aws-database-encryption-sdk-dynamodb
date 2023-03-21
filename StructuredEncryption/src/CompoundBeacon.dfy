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


include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"
include "Util.dfy"
include "Paths.dfy"
include "Beacon.dfy"

module CompoundBeacon {
  import opened Wrappers
  import opened BaseBeacon
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

  type FieldName = string
  type Prefix = x : string | 0 < |x| witness *

  // if length is null, this is a non-sensitive part
  datatype BeaconPart = BeaconPart (
    fieldName : FieldName,
    prefix : Prefix,
    length : Option<BeaconLength>
  )

  datatype ConstructorPart = ConstructorPart (
    fieldName : FieldName,
    required : bool
  )

  type ConstructorPartList = x : seq<ConstructorPart> | 0 < |x| witness *

  datatype Constructor = Constructor(
    parts : ConstructorPartList
  )

  type ConstructorList = x : seq<Constructor> | 0 < |x| witness *

  type Stringify = (TerminalLocation) -> Result<string,string>
  
  datatype CompoundBeacon = CompoundBeacon(
    base : BeaconBase,
    split : char,
    parts : seq<BeaconPart>, // Non-Sensitive followed by Sensitive
    construct : ConstructorList
  ) {

    function method FindPartByName(name : string) : Result<BeaconPart, Error>
    {
      // TODO - prove and keep track, so this can't fail
      var part := Seq.Filter((x : BeaconPart) => (x.fieldName == name), parts);
      :- Need(|part| == 1, E("Internal error, constructor named non-existent part"));
      Success(part[0])
    }

    function method {:opaque} {:tailrecursion} TryConstructor(consFields : seq<ConstructorPart>, fields : map<string, string>, acc : string := "")
      : (ret : Result<string, Error>)
      ensures ret.Success? ==> |ret.value| > 0
    {
      if |consFields| == 0 then
        if |acc| ==  0 then
          Failure(E("Internal Error : Empty beacon created."))
        else
          Success(acc)
      else
        //= specification/structured-encryption/beacons.md#hash-for-a-compound-beacon
        //# * For that constructor, hash MUST join the [part value](#part-value) for each part on the `split character`,
        //# excluding parts that are not required and with a source field that is not available.
        :- Need(!consFields[0].required || consFields[0].fieldName in fields, E("")); // this error message never propagated
        if consFields[0].fieldName in fields then
          var part :- FindPartByName(consFields[0].fieldName);
          var val :- PartValueCalc(part.prefix + fields[part.fieldName], part.prefix, part.length);
          if |acc| == 0 then
            TryConstructor(consFields[1..], fields, val)
          else
            TryConstructor(consFields[1..], fields, acc + [split] + val)
        else
          TryConstructor(consFields[1..], fields, acc)
    }

    function method {:opaque} {:tailrecursion} TryConstructors(construct : seq<Constructor>, fields : map<string, string>)
      : (ret : Result<string, Error>)
      ensures ret.Success? ==> |ret.value| > 0
    {
      if |construct| == 0 then
        Failure(E("No constructor for " + base.name + " could be satisfied."))
      else
        //= specification/structured-encryption/beacons.md#hash-for-a-compound-beacon
        //# * has MUST iterate through all constructors, in order, using the first that succeeds.
        var x := TryConstructor(construct[0].parts, fields);
        if x.Success? then
          x
        else
          TryConstructors(construct[1..], fields)
    }

    //= specification/structured-encryption/beacons.md#hash-for-a-compound-beacon
    //= type=implication
    //# * hash MUST take a record as input, and produce a string.
    function method {:opaque} hash(fields : map<string, string>) : (res : Result<string, Error>)
      ensures res.Success? ==> 
        //= specification/structured-encryption/beacons.md#hash-for-a-compound-beacon
        //= type=implication
        //# * The returned string MUST NOT be empty.
        && |res.value| > 0
    {
      TryConstructors(construct, fields)
    }

    function method {:opaque} findPart(val : string)
      : (ret : Result<BeaconPart, Error>)
      ensures |Seq.Filter((x : BeaconPart) => (x.prefix <= val), parts)| == 0 ==> ret.Failure?
      ensures ret.Success? ==>
        //= specification/structured-encryption/beacons.md#getpart-for-a-compound-beacon
        //= type=implication
        //# * For each piece, a [part](#part) MUST be identified by matching the prefix of a [part](#part)
        //# to the beginning of the piece.        
        ret.value.prefix <= val

      //= specification/structured-encryption/beacons.md#getpart-for-a-compound-beacon
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

    //= specification/structured-encryption/beacons.md#getpart-for-a-compound-beacon
    //= type=implication
    //# * getPart MUST take a string as input and produce a string.
    function method {:opaque} getPart(val : string)
      : (ret : Result<string, Error>)
      //= specification/structured-encryption/beacons.md#getpart-for-a-compound-beacon
      //= type=implication
      //# * The returned string MUST NOT be empty.
      requires 0 < |val|

      ensures ret.Success? ==> 
        && |ret.value| > 0

        //= specification/structured-encryption/beacons.md#getpart-for-a-compound-beacon
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

        //= specification/structured-encryption/beacons.md#getpart-for-a-compound-beacon
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
        //= specification/structured-encryption/beacons.md#getpart-for-a-compound-beacon
        //# * The value returned MUST be these part values, joined with the `split character`.
        var theBeacon :- calcPart(pieces[0]);
        if |acc| == 0 then
          calcParts(pieces[1..], theBeacon)
        else
          calcParts(pieces[1..], acc + [split] + theBeacon)
    }

    predicate method ValidPrefixSet()
    {
      forall x : nat, y : nat
        | 0 <= x <= |parts| && x < y <= |parts|
        :: !(parts[x].prefix <= parts[x].prefix)
    }

    static predicate method IsEncrypted(schema : CryptoSchemaPlain, fieldName : FieldName)
    {
      && fieldName in schema
      && schema[fieldName].content.Action == ENCRYPT_AND_SIGN
    }

    predicate method ValidNonSensitive(schema : CryptoSchemaPlain)
    {
      && |Seq.Filter((x : BeaconPart) => x.length.None? &&  IsEncrypted(schema, x.fieldName), parts)| == 0
      && |Seq.Filter((x : BeaconPart) => x.length.Some? && !IsEncrypted(schema, x.fieldName), parts)| == 0
    }

    predicate method ValidPart(f : ConstructorPart)
    {
      |Seq.Filter((x : BeaconPart) => x.fieldName == f.fieldName, parts)| == 1
    }

    predicate method ValidConstructor(con : seq<ConstructorPart>)
    {
      if |con| == 0 then
        true
      else
        ValidPart(con[0]) && ValidConstructor(con[1..])
    }

    predicate method ValidConstructors(con : seq<Constructor>)
    {
      if |con| == 0 then
        true
      else
        ValidConstructor(con[0].parts) && ValidConstructors(con[1..])
    }

    function method isValid(schema : CryptoSchemaPlain, virtualFields : map<string,string>, unauthPrefix : string)
      : (ret : bool)
      ensures ret ==>
        //= specification/structured-encryption/beacons.md#initialization-failure
        //= type=implication
        //# Initialization MUST fail if any `prefix` in any [part](#part) is a prefix of
        //# the `prefix` of any other [part](#part).
        && ValidPrefixSet()

        //= specification/structured-encryption/beacons.md#initialization-failure
        //= type=implication
        //# Initialization MUST fail if any [non-sensitive-part](#non-sensitive-part) contains
        //# any part of an encrypted field, or any [sensitive-part](#sensitive-part) fails to contain
        //# some part of an encrypted field.
        && ValidNonSensitive(schema)

        //= specification/structured-encryption/beacons.md#initialization-failure
        //= type=implication
        //# Initialization MUST fail if any [constructor](#constructor) is configured with a field name
        //# that is not a defined [part](#part).
        && ValidConstructors(construct)
    {
      ValidPrefixSet() && ValidNonSensitive(schema) && ValidConstructors(construct)
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
    var cons := Seq.Map((x : BeaconPart) => ConstructorPart(x.fieldName, true), parts);
    Constructor(cons)
  }
}