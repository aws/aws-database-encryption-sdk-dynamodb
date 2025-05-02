// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDbEncryptionSdkDynamoDbTypes.dfy"
include "NormalizeNumber.dfy"

module DynamoToStruct {

  import opened ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened DynamoDbEncryptionUtil
  import Types = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import UTF8
  import SortedSets
  import Seq
  import Norm = DynamoDbNormalizeNumber
  import SE = StructuredEncryptionUtil
  import StandardLibrary.Sequence
  import DafnyLibraries
  import opened MemoryMath

  type Error = Types.Error

  type TerminalDataMap = map<AttributeName, StructuredDataTerminal>

  // This file exists for ItemToStructured and StructuredToItem and their variants,
  // which provide conversion between an AttributeMap and a StructuredDataMap


  // Identical to ItemToStructured, except that the result does not include any attributes configured as DO_NOTHING\
  // Such attributes are unneeded, as they do not partake in signing nor encryption
  function method ItemToStructured2(item : AttributeMap, actions : Types.AttributeActions) : (ret : Result<TerminalDataMap, Error>)
  {
    // var m := new DafnyLibraries.MutableMap<AttributeName, StructuredDataTerminal>();
    // return MakeError("Not valid attribute names : ");

    var structuredMap := map k <- item | k !in actions || actions[k] != DO_NOTHING || ReservedPrefix <= k :: k := AttrToStructured(item[k]);
    MapKeysMatchItems(item);
    MapError(SimplifyMapValue(structuredMap))
  }

  // Identical to StructuredToItem, except that any non encrypted fields in the original are passed through unchanged
  // and only encrypted fields are run through StructuredToAttr
  // This one is used for encryption, and so anything in s but not in orig is also kept
  function method StructuredToItemEncrypt(s : TerminalDataMap, orig : AttributeMap, actions : CryptoSchemaMap) : (ret : Result<AttributeMap, Error>)
  {
    var ddbMap := map k <- orig :: k := if (k in s && k in actions && actions[k] == ENCRYPT_AND_SIGN) then StructuredToAttr(s[k]) else Success(orig[k]);
    MapKeysMatchItems(orig);
    var oldMap :- MapError(SimplifyMapValue(ddbMap));

    var ddbMap2 := map k <- s | k !in orig :: k := StructuredToAttr(s[k]);
    MapKeysMatchItems(s);
    var newMap :- MapError(SimplifyMapValue(ddbMap2));

    Success(oldMap + newMap)
  }

  // Identical to StructuredToItem, except that any non encrypted fields in the original are passed through unchanged
  // and only encrypted fields are run through StructuredToAttr\
  // This one is used for decryption, and so anything in s but not in orig is ignored
  function method StructuredToItemDecrypt(s : TerminalDataMap, orig : AttributeMap, actions : CryptoSchemaMap) : (ret : Result<AttributeMap, Error>)
  {
    var ddbMap := map k <- orig | !(ReservedPrefix <= k) :: k := if (k in s && k in actions && actions[k] == ENCRYPT_AND_SIGN) then StructuredToAttr(s[k]) else Success(orig[k]);
    MapKeysMatchItems(orig);
    MapError(SimplifyMapValue(ddbMap))
  }

  // Convert AttributeMap to StructuredDataMap
  function method {:opaque} ItemToStructured(item : AttributeMap) : (ret : Result<TerminalDataMap, Error>)

    //= specification/dynamodb-encryption-client/ddb-item-conversion.md#convert-ddb-item-to-structured-data
    //= type=implication
    //# - MUST contain a [Structured Data Terminal](../structured-encryption/structures.md#structured-data-terminal)
    //# for each attribute on the DynamoDB Item, and no others.
    ensures ret.Success? ==> ret.value.Keys == item.Keys

    //= specification/dynamodb-encryption-client/ddb-item-conversion.md#convert-ddb-item-to-structured-data
    //= type=implication
    //# - The [Terminal Type ID](../structured-encryption/structures.md#terminal-type-id) for each attribute MUST
    //# be the [Type ID](./ddb-attribute-serialization.md#type-id) of the [serialization](./ddb-attribute-serialization.md) of this Attribute Value.
    ensures ret.Success? ==> forall kv <- ret.value.Items :: kv.1.typeId == AttrToTypeId(item[kv.0])

    //= specification/dynamodb-encryption-client/ddb-item-conversion.md#convert-ddb-item-to-structured-data
    //= type=implication
    //# - The [Terminal Value](../structured-encryption/structures.md#terminal-value) for each attribute MUST
    //# be the [Value](./ddb-attribute-serialization.md#type-id) of the [serialization](./ddb-attribute-serialization.md) of this Attribute Value.
    ensures ret.Success? ==> forall kv <- ret.value.Items ::
                && TopLevelAttributeToBytes(item[kv.0]).Success?
                && kv.1.value == TopLevelAttributeToBytes(item[kv.0]).value

  {
    var structuredMap := map k <- item :: k := AttrToStructured(item[k]);
    MapKeysMatchItems(item);
    MapError(SimplifyMapValue(structuredMap))
  }

  // Convert StructuredDataMap to AttributeMap
  function method {:opaque} StructuredToItem(s : TerminalDataMap) : (ret : Result<AttributeMap, Error>)
    //= specification/dynamodb-encryption-client/ddb-item-conversion.md#convert-structured-data-to-ddb-item
    //= type=implication
    //# - MUST contain an Attribute for every [Structured Data Terminal](../structured-encryption/structures.md#structured-data-terminal)
    //# on the Structured Data, and not other Attributes.
    ensures ret.Success? ==> ret.value.Keys == s.Keys

    //= specification/dynamodb-encryption-client/ddb-item-conversion.md#convert-structured-data-to-ddb-item
    //= type=implication
    //# - MUST NOT have any `Key` strings that are invalid DynamoDB AttributeNames, that is, with more than 65535 characters.
    ensures ret.Success? ==> forall k <- s.Keys :: IsValid_AttributeName(k)

    //= specification/dynamodb-encryption-client/ddb-item-conversion.md#convert-structured-data-to-ddb-item
    //= type=implication
    //# - Each Attribute MUST be deserializable
    //# according to [the serialization scheme](./ddb-attribute-serialization.md#value).
    ensures ret.Success? ==> forall kv <- ret.value.Items ::
                && StructuredToAttr(s[kv.0]).Success?
                && kv.1 == StructuredToAttr(s[kv.0]).value
  {
    if forall k <- s :: IsValid_AttributeName(k) then
      var structuredData := map k <- s :: k := StructuredToAttr(s[k]);
      MapKeysMatchItems(s);
      MapError(SimplifyMapValue(structuredData))
    else
      var badNames := set k <- s | !IsValid_AttributeName(k) :: k;
      OneBadKey(s, badNames, IsValid_AttributeName);
      // We happen to order these values, but this ordering MUST NOT be relied upon.
      var orderedAttrNames := SetToOrderedSequence(badNames, CharLess);
      var attrNameList := Join(orderedAttrNames, ",");
      MakeError("Not valid attribute names : " + attrNameList)
  }

  function method BigEndianPosToU32(x : seq<uint8>, pos : uint64) : (ret : Result<uint32, string>)
    requires HasUint64Len(x)
  {
    if |x| as uint64 < Add(pos, LENGTH_LEN64) then
      Failure("Length of 4-byte integer was less than 4")
    else
      Success(SeqPosToUInt32(x, pos))
  }

  function method BigEndianPosToU32As64(x : seq<uint8>, pos : uint64) : (ret : Result<uint64, string>)
    requires HasUint64Len(x)
  {
    if |x| as uint64 < Add(pos, LENGTH_LEN64) then
      Failure("Length of 4-byte integer was less than 4")
    else
      Success(SeqPosToUInt32(x, pos) as uint64)
  }

  function method MakeError<T>(s : string) : Result<T, Error> {
    Failure(Error.DynamoDbEncryptionException(message := s))
  }

  function method MapError<T>(r : Result<T, string>) : Result<T, Error> {
    if r.Success? then
      Success(r.value)
    else
      MakeError(r.error)
  }

  function method  {:opaque} TopLevelAttributeToBytes(a : AttributeValue) : Result<seq<uint8>, string>
    // We never need to prefix at the top level.
    // The Type ID is serialized separately,
    // and the Length is not needed since we are
    // working with the exact set of bytes when we
    // need to deserialize.
  {
    AttrToBytes(a, false)
  }

  function method  {:opaque} AttrToStructured(item : AttributeValue) : (ret : Result<StructuredDataTerminal, string>)
    ensures ret.Success? ==> ret.value.typeId == AttrToTypeId(item)
    ensures ret.Success? ==>
              && TopLevelAttributeToBytes(item).Success?
              && ret.value.value == TopLevelAttributeToBytes(item).value
  {
    var body :- TopLevelAttributeToBytes(item);
    Success(StructuredDataTerminal(value := body, typeId := AttrToTypeId(item)))
  }

  function method  {:opaque} StructuredToAttr(s : StructuredDataTerminal) : (ret : Result<AttributeValue, string>)
  {
    SequenceIsSafeBecauseItIsInMemory(s.value);
    SequenceIsSafeBecauseItIsInMemory(s.typeId);
    :- Need(|s.typeId| as uint64 == TYPEID_LEN64, "Type ID must be two bytes");
    var attrValueAndLength :- BytesToAttr(s.value, s.typeId, Some(|s.value| as uint64));
    if attrValueAndLength.len != |s.value| as uint64 then
      Failure("Mismatch between length of encoded data and length of data")
    else
      Success(attrValueAndLength.val)
  }

  const BOOL_LEN : nat := 1   // number of bytes in an encoded boolean
  const TYPEID_LEN : nat := 2   // number of bytes in a TerminalTypeId
  const LENGTH_LEN : nat := 4 // number of bytes in an encoded count or length
  const PREFIX_LEN : nat := 6 // number of bytes in a prefix, i.e. 2-byte type and 4-byte length

  const BOOL_LEN64 : uint64 := 1   // number of bytes in an encoded boolean
  const TYPEID_LEN64 : uint64 := 2   // number of bytes in a TerminalTypeId
  const LENGTH_LEN64 : uint64 := 4 // number of bytes in an encoded count or length
  const PREFIX_LEN64 : uint64 := 6 // number of bytes in a prefix, i.e. 2-byte type and 4-byte length

  function method AttrToTypeId(a : AttributeValue) : TerminalTypeId
  {
    match a {
      case S(s) => SE.STRING
      case N(n) => SE.NUMBER
      case B(b) => SE.BINARY
      case SS(ss) => SE.STRING_SET
      case NS(ns) => SE.NUMBER_SET
      case BS(bs) => SE.BINARY_SET
      case M(m) => SE.MAP
      case L(l) => SE.LIST
      case NULL(n) => SE.NULL
      case BOOL(b) => SE.BOOLEAN
    }
  }

  predicate method CharLess(x : char, y : char) {
    x < y
  }

  // convert AttributeValue to byte sequence
  // if `prefix` is true, prefix sequence with TypeID and Length
  function method {:opaque} AttrToBytes(a : AttributeValue, prefix : bool, depth : uint64 := 1) : (ret : Result<seq<uint8>, string>)
    requires depth <= (MAX_STRUCTURE_DEPTH+1)
    decreases a
    ensures ret.Success? && prefix ==> PREFIX_LEN <= |ret.value|
    ensures MAX_STRUCTURE_DEPTH < depth ==> ret.Failure?

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#boolean
    //= type=implication
    //# Boolean MUST be serialized as:
    //# - `0x00` if the value is `false`
    //# - `0x01` if the value is `true`
    ensures a.BOOL? && !prefix && depth <= MAX_STRUCTURE_DEPTH ==>
              && (a.BOOL  ==> ret.Success? && |ret.value| == BOOL_LEN && ret.value[0] == 1)
              && (!a.BOOL ==> ret.Success? && |ret.value| == BOOL_LEN && ret.value[0] == 0)
    ensures a.BOOL? && prefix && depth <= MAX_STRUCTURE_DEPTH ==>
              && (a.BOOL  ==> (ret.Success? && |ret.value| == PREFIX_LEN+BOOL_LEN && ret.value[PREFIX_LEN] == 1
                               && ret.value[0..TYPEID_LEN] == SE.BOOLEAN && ret.value[TYPEID_LEN..PREFIX_LEN] == [0,0,0,1]))
              && (!a.BOOL ==> (ret.Success? && |ret.value| == PREFIX_LEN+BOOL_LEN && ret.value[PREFIX_LEN] == 0
                               //  && ret.value[0..TYPEID_LEN] == SE.BOOLEAN && ret.value[TYPEID_LEN..PREFIX_LEN] == [0,0,0,1]
                    ))

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#binary
    //= type=implication
    //# Binary MUST be serialized with the identity function;
    //# or more plainly, Binary Attribute Values are used as is.
    ensures a.B? && !prefix && depth <= MAX_STRUCTURE_DEPTH ==> ret.Success? && ret.value == a.B
    ensures a.B? && prefix && ret.Success? && depth <= MAX_STRUCTURE_DEPTH ==>
              && ret.value[PREFIX_LEN..] == a.B
              && ret.value[0..TYPEID_LEN] == SE.BINARY
              && U32ToBigEndian(|a.B|).Success?
              && ret.value[TYPEID_LEN..PREFIX_LEN] == U32ToBigEndian(|a.B|).value
              && BigEndianToU32(ret.value[TYPEID_LEN..PREFIX_LEN]).value == |a.B|

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#null
    //= type=implication
    //# Null MUST be serialized as a zero-length byte string.
    ensures a.NULL? && !prefix && depth <= MAX_STRUCTURE_DEPTH ==> ret.Success? && |ret.value| == 0
    ensures a.NULL? &&  prefix && depth <= MAX_STRUCTURE_DEPTH ==> ret.Success? && |ret.value| == PREFIX_LEN && ret.value[0..TYPEID_LEN] == SE.NULL && ret.value[TYPEID_LEN..PREFIX_LEN] == [0,0,0,0]

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#string
    //= type=implication
    //# String MUST be serialized as UTF-8 encoded bytes.
    ensures a.S? && ret.Success? && !prefix ==>
              UTF8.Decode(ret.value).Success? && UTF8.Decode(ret.value).value == a.S
    ensures a.S? && ret.Success? && prefix ==>
              && UTF8.Decode(ret.value[PREFIX_LEN..]).Success?
              && UTF8.Decode(ret.value[PREFIX_LEN..]).value == a.S
              && ret.value[0..TYPEID_LEN] == SE.STRING
              && UTF8.Encode(a.S).Success?
              && U32ToBigEndian(|UTF8.Encode(a.S).value|).Success?
              && ret.value[TYPEID_LEN..PREFIX_LEN] == U32ToBigEndian(|UTF8.Encode(a.S).value|).value

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#number
    //= type=implication
    //# This value MUST be normalized in the same way as DynamoDB normalizes numbers.

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#number
    //= type=implication
    //# This normalized value MUST then be serialized as UTF-8 encoded bytes.
    ensures a.N? && ret.Success? && !prefix ==>
              && Norm.NormalizeNumber(a.N).Success?
              && var nn := Norm.NormalizeNumber(a.N).value;
              && UTF8.Decode(ret.value).Success? && UTF8.Decode(ret.value).value == nn
    ensures a.N? && ret.Success? && prefix ==>
              && Norm.NormalizeNumber(a.N).Success?
              && var nn := Norm.NormalizeNumber(a.N).value;
              && UTF8.Decode(ret.value[PREFIX_LEN..]).Success?
              && UTF8.Decode(ret.value[PREFIX_LEN..]).value == nn
              && ret.value[0..TYPEID_LEN] == SE.NUMBER
              && UTF8.Encode(nn).Success?
              && U32ToBigEndian(|UTF8.Encode(nn).value|).Success?
              && ret.value[TYPEID_LEN..PREFIX_LEN] == U32ToBigEndian(|UTF8.Encode(nn).value|).value

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#set-entries
    //= type=implication
    //# Binary Sets MUST NOT contain duplicate entries.
    ensures a.BS? && ret.Success? ==> Seq.HasNoDuplicates(a.BS)

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#set
    //= type=implication
    //# A Set MUST be serialized as:
    //# | Field       | Length   |
    //# | ----------- | -------- |
    //# | Set Count   | 4        |
    //# | Set Entries | Variable |

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#set-count
    //= type=implication
    //# Set Count MUST be a big-endian unsigned integer
    //# equal to the number of serialized entries in
    //# [Set Entries](#set-entries).
    ensures a.BS? && ret.Success? && !prefix ==>
              && U32ToBigEndian(|a.BS|).Success?
              && |ret.value| >= LENGTH_LEN
              && ret.value[0..LENGTH_LEN] == U32ToBigEndian(|a.BS|).value
              && BigEndianToU32(ret.value[0..LENGTH_LEN]).value == |a.BS|

              //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#set-count
              //= type=implication
              //# Set Count MAY be `0`,
              //# in which case [Set Entries](#set-entries) is a zero-length byte string.
              && (|a.BS| == 0 ==> |ret.value| == LENGTH_LEN)

    ensures a.BS? && ret.Success? && prefix ==>
              && U32ToBigEndian(|a.BS|).Success?
              && |ret.value| >= PREFIX_LEN + LENGTH_LEN
              && ret.value[0..TYPEID_LEN] == SE.BINARY_SET
              && ret.value[PREFIX_LEN..PREFIX_LEN+LENGTH_LEN] == U32ToBigEndian(|a.BS|).value
              && (|a.BS| == 0 ==> |ret.value| == PREFIX_LEN + LENGTH_LEN)

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#set-entries
    //= type=implication
    //# String Sets MUST NOT contain duplicate entries.
    // Other implications for Binary Sets apply here too
    ensures a.SS? && ret.Success? ==> Seq.HasNoDuplicates(a.SS)

    ensures a.SS? && ret.Success? && !prefix ==>
              && U32ToBigEndian(|a.SS|).Success?
              && |ret.value| >= LENGTH_LEN
              && ret.value[0..LENGTH_LEN] == U32ToBigEndian(|a.SS|).value
              && BigEndianToU32(ret.value[0..LENGTH_LEN]).value == |a.SS|
    ensures a.SS? && ret.Success? && prefix ==>
              && U32ToBigEndian(|a.SS|).Success?
              && |ret.value| >= PREFIX_LEN + LENGTH_LEN
              && ret.value[0..TYPEID_LEN] == SE.STRING_SET
              && ret.value[PREFIX_LEN..PREFIX_LEN+LENGTH_LEN] == U32ToBigEndian(|a.SS|).value

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#set-entries
    //= type=implication
    //# Number Sets MUST NOT contain duplicate entries.
    // Other implications for Binary Sets apply here too
    ensures a.NS? && ret.Success? ==> Seq.HasNoDuplicates(a.NS)

    ensures a.NS? && ret.Success? && !prefix ==>
              && U32ToBigEndian(|a.NS|).Success?
              && |ret.value| >= LENGTH_LEN
              && ret.value[0..LENGTH_LEN] == U32ToBigEndian(|a.NS|).value
    ensures a.NS? && ret.Success? && prefix ==>
              && U32ToBigEndian(|a.NS|).Success?
              && |ret.value| >= PREFIX_LEN + LENGTH_LEN
              && ret.value[0..TYPEID_LEN] == SE.NUMBER_SET
              && ret.value[PREFIX_LEN..PREFIX_LEN+LENGTH_LEN] == U32ToBigEndian(|a.NS|).value

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#list
    //= type=implication
    //# List MUST be serialized as:
    //# | Field        | Length   |
    //# | ------------ | -------- |
    //# | List Count   | 4        |
    //# | List Entries | Variable |
    ensures a.L? && ret.Success? && !prefix ==>
              //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#list-count
              //= type=implication
              //# List Count MUST be a big-endian unsigned integer
              //# equal to the number of serialized list entries in
              //# [List Entries](#list-entries).
              && U32ToBigEndian(|a.L|).Success?
              && |ret.value| >= LENGTH_LEN
              && ret.value[0..LENGTH_LEN] == U32ToBigEndian(|a.L|).value
              && BigEndianToU32(ret.value[0..LENGTH_LEN]).value == |a.L|

              //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#list-count
              //= type=implication
              //# List Count MAY be `0`,
              //# in which case [List Entries](#list-entries) is an empty byte string.
              && (|a.L| == 0 ==> |ret.value| == LENGTH_LEN)

    ensures a.L? && ret.Success? && prefix ==>
              && depth <= MAX_STRUCTURE_DEPTH
              && U32ToBigEndian(|a.L|).Success?
              && |ret.value| >= PREFIX_LEN + LENGTH_LEN
              && ret.value[0..TYPEID_LEN] == SE.LIST
              && ListAttrToBytes(a.L, depth).Success?
              && ret.value[PREFIX_LEN..] == ListAttrToBytes(a.L, depth).value
              && ListAttrToBytes(a.L, depth).value[..LENGTH_LEN] == U32ToBigEndian(|a.L|).value
              && (|a.L| == 0 ==> |ret.value| == PREFIX_LEN + LENGTH_LEN)

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#map-attribute
    //= type=implication
    //# Map MUST be serialized as:
    //# | Field                  | Length   |
    //# | ---------------------- | -------- |
    //# | Key Value Pair Count   | 4        |
    //# | Key Value Pair Entries  | Variable |
    ensures a.M? && ret.Success? && !prefix ==>
              && depth <= MAX_STRUCTURE_DEPTH
              && U32ToBigEndian(|a.M|).Success?
              && |ret.value| >= LENGTH_LEN

              //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#key-value-pair-count
              //= type=implication
              //# Key Value Pair Count MUST be a big-endian unsigned integer
              //# equal to the number of serialized key-value pairs in
              //# [Key Value Pair Entries](#key-value-pair-entries).
              && ret.value[0..LENGTH_LEN] == U32ToBigEndian(|a.M|).value
              && BigEndianToU32(ret.value[0..LENGTH_LEN]).value == |a.M|

              //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#key-value-pair-count
              //= type=implication
              //# Key Value Pair Count MAY be `0`,
              //# in which case [Key Value Pair Entries](#key-value-pair-entries) is an empty bytestring.
              && (|a.M| == 0 ==> |ret.value| == LENGTH_LEN)

    ensures a.M? && ret.Success? && prefix ==>
              && U32ToBigEndian(|a.M|).Success?
              && |ret.value| >= PREFIX_LEN + LENGTH_LEN
              && ret.value[0..TYPEID_LEN] == AttrToTypeId(a)
              && (|a.M| == 0 ==> |ret.value| == PREFIX_LEN + LENGTH_LEN)

  {
    :- Need(depth <= MAX_STRUCTURE_DEPTH, "Depth of attribute structure to serialize exceeds limit of " + MAX_STRUCTURE_DEPTH_STR);
    var baseBytes :- match a {
      case S(s) => UTF8.Encode(s)
      case N(n) => var nn :- Norm.NormalizeNumber(n); UTF8.Encode(nn)
      case B(b) => Success(b)
      case SS(ss) => StringSetAttrToBytes(ss)
      case NS(ns) => NumberSetAttrToBytes(ns)
      case BS(bs) => BinarySetAttrToBytes(bs)
      case M(m) => MapAttrToBytes(a, m, depth)
      case L(l) => ListAttrToBytes(l, depth)
      case NULL(n) => Success([])
      case BOOL(b) => Success([BoolToUint8(b)])
    };
    if prefix then
      var len :- U32ToBigEndian(|baseBytes|);
      Success(AttrToTypeId(a) + len + baseBytes)
    else
      Success(baseBytes)
  }

  function method StringSetAttrToBytes(ss: StringSetAttributeValue): (ret: Result<seq<uint8>, string>)
    ensures ret.Success? ==> Seq.HasNoDuplicates(ss)
  {
    var asSet := Seq.ToSet(ss);
    :- Need(|asSet| == |ss|, "String Set had duplicate values");
    Seq.LemmaNoDuplicatesCardinalityOfSet(ss);

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#set-entries
    //# Entries in a String Set MUST be ordered in ascending [UTF-16 binary order](./string-ordering.md#utf-16-binary-order).
    var sortedList := SortedSets.ComputeSetToOrderedSequence2(asSet, CharLess);
    var count :- U32ToBigEndian(|sortedList|);
    var body :- CollectString(sortedList);
    Success(count + body)
  }

  function method NumberSetAttrToBytes(ns: NumberSetAttributeValue): (ret: Result<seq<uint8>, string>)
    ensures ret.Success? ==> Seq.HasNoDuplicates(ns)
  {
    var asSet := Seq.ToSet(ns);
    :- Need(|asSet| == |ns|, "Number Set had duplicate values");
    Seq.LemmaNoDuplicatesCardinalityOfSet(ns);

    var normList :- Sequence.MapWithResult(n => Norm.NormalizeNumber(n), ns);
    var asSet := Seq.ToSet(normList);
    :- Need(|asSet| == |normList|, "Number Set had duplicate values after normalization.");

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#set-entries
    //# Entries in a Number Set MUST be ordered in ascending [UTF-16 binary order](./string-ordering.md#utf-16-binary-order).

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#set-entries
    //# This ordering MUST be applied after normalization of the number value.
    var sortedList := SortedSets.ComputeSetToOrderedSequence2(asSet, CharLess);
    var count :- U32ToBigEndian(|sortedList|);
    var body :- CollectString(sortedList);
    Success(count + body)
  }

  function method BinarySetAttrToBytes(bs: BinarySetAttributeValue): (ret: Result<seq<uint8>, string>)
    ensures ret.Success? ==> Seq.HasNoDuplicates(bs)
    ensures ret.Success? ==>
              && U32ToBigEndian(|bs|).Success?
              && LENGTH_LEN <= |ret.value|
              && ret.value[..LENGTH_LEN] == U32ToBigEndian(|bs|).value
  {
    var asSet := Seq.ToSet(bs);
    :- Need(|asSet| == |bs|, "Binary Set had duplicate values");
    Seq.LemmaNoDuplicatesCardinalityOfSet(bs);

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#set-entries
    //# Entries in a Binary Set MUST be ordered lexicographically by their underlying bytes in ascending order.
    var sortedList := SortedSets.ComputeSetToOrderedSequence2(asSet, ByteLess);
    var count :- U32ToBigEndian(|sortedList|);
    var body :- CollectBinary(sortedList);
    Success(count + body)
  }

  // Specifying the parent (particularly, as the first parameter),
  // along with the corresponding precondition,
  // lets Dafny find the correct termination metric.
  // See "The Parent Trick" for details: <https://leino.science/papers/krml283.html>.
  function method MapAttrToBytes(ghost parent: AttributeValue, m: MapAttributeValue, depth : uint64): (ret: Result<seq<uint8>, string>)
    requires forall k <- m :: m[k] < parent
    requires depth <= MAX_STRUCTURE_DEPTH
  {
    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#value-type
    //# Value Type MUST be the [Type ID](#type-id) of the type of [Map Value](#map-value).

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#value-length
    //# Value Length MUST be a big-endian unsigned integer
    //# equal to the length of [Map Value](#map-value).

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#map-value
    //# Map Value MUST be a [Value](#value).

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#map-value
    //# A Map MAY hold any DynamoDB Attribute Value data type,
    //# and MAY hold values of different types.
    var bytesResults := map k <- m :: k := AttrToBytes(m[k], true, depth+1);

    var count :- U32ToBigEndian(|m|);
    var bytes :- SimplifyMapValue(bytesResults);
    var body :- CollectMap(bytes);
    Success(count + body)
  }

  function method ListAttrToBytes(l: ListAttributeValue, depth : uint64): (ret: Result<seq<uint8>, string>)
    requires depth <= MAX_STRUCTURE_DEPTH
    ensures ret.Success? ==>
              && U32ToBigEndian(|l|).Success?
              && LENGTH_LEN <= |ret.value|
              && ret.value[..LENGTH_LEN] == U32ToBigEndian(|l|).value
    decreases l
  {
    var count :- U32ToBigEndian(|l|);
    var body :- CollectList(l, depth);
    Success(count + body)
  }

  lemma BigEndianLemma()
    ensures U32ToBigEndian(3) == Success([0,0,0,3])
    ensures BigEndianToU32([0,0,0,3]) == Success(3)
  {}

  lemma U32ToBigEndianRoundTrip(x : nat)
    ensures U32ToBigEndian(x).Success? ==>
              && BigEndianToU32(U32ToBigEndian(x).value).Success?
              && BigEndianToU32(U32ToBigEndian(x).value).value == x
  {}

  lemma BigEndianToU32RoundTrip(x : seq<uint8>)
    requires |x| == 4
    ensures BigEndianToU32(x).Success? ==>
              && U32ToBigEndian(BigEndianToU32(x).value).Success?
              && U32ToBigEndian(BigEndianToU32(x).value).value == x
  {}

  function method U32ToBigEndian(x : nat) : (ret : Result<seq<uint8>, string>)
    ensures ret.Success? ==> |ret.value| == LENGTH_LEN
  {
    if !HasUint32Size(x) then
      Failure("Length was too big")
    else
      Success(UInt32ToSeq(x as uint32))
  }

  function method BigEndianToU32(x : seq<uint8>) : (ret : Result<nat, string>)
  {
    if |x| < LENGTH_LEN then
      Failure("Length of 4-byte integer was less than 4")
    else
      Success(SeqToUInt32(x[..LENGTH_LEN]) as nat)
  }

  function method BigEndianToU32As32(x : seq<uint8>) : (ret : Result<uint32, string>)
  {
    if |x| < LENGTH_LEN then
      Failure("Length of 4-byte integer was less than 4")
    else
      Success(SeqToUInt32(x[..LENGTH_LEN]))
  }

  function method BigEndianToU32As64(x : seq<uint8>) : (ret : Result<uint64, string>)
  {
    if |x| < LENGTH_LEN then
      Failure("Length of 4-byte integer was less than 4")
    else
      Success(SeqToUInt32(x[..LENGTH_LEN]) as uint64)
  }

  predicate IsSorted<T>(s: seq<T>, lessThanOrEq: (T, T) -> bool) {
    forall j, k :: 0 <= j < k < |s| ==> lessThanOrEq(s[j], s[k])
  }

  function method EncodeString(s : string) : (ret : Result<seq<uint8>, string>)
    // The Duvet implications set-entries and set-entry-length mentioned in SerializeBinaryValue
    // are also implied here for String Sets and Number Sets
    ensures ret.Success? ==>
              && UTF8.Encode(s).Success?
              && U32ToBigEndian(|UTF8.Encode(s).value|).Success?
              && |ret.value| == LENGTH_LEN + |UTF8.Encode(s).value|
              && ret.value[0..LENGTH_LEN] == U32ToBigEndian(|UTF8.Encode(s).value|).value
              && ret.value[LENGTH_LEN..] == UTF8.Encode(s).value
  {
    var val :- UTF8.Encode(s);
    var len :- U32ToBigEndian(|val|);
    Success(len + val)
  }
  // String Set or Number Set to Bytes
  function method {:tailrecursion} {:opaque} CollectString(
    setToSerialize : StringSetAttributeValue,
    pos : uint64 := 0,
    serialized : seq<uint8> := [])
    : Result<seq<uint8>, string>
    requires pos as nat <= |setToSerialize|
    decreases |setToSerialize| - pos as nat
  {
    SequenceIsSafeBecauseItIsInMemory(setToSerialize);
    if |setToSerialize| as uint64 == pos then
      Success(serialized)
    else
      var entry :- EncodeString(setToSerialize[pos]);
      CollectString(setToSerialize, pos+1, serialized + entry)
  }


  function method SerializeBinaryValue(b : BinaryAttributeValue) : (ret : Result<seq<uint8>, string>)
    // for parallel implication for String Set and Number Set see EncodeString
    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#set-entries
    //= type=implication
    //# Each of these entries MUST be serialized as:
    //# | Field            | Length                               |
    //# | ---------------- | ------------------------------------ |
    //# | Set Entry Length | 4                                    |
    //# | Set Entry Value  | Variable. Equal to Set Entry Length. |
    ensures ret.Success? ==>
              && U32ToBigEndian(|b|).Success?
              && |ret.value| == LENGTH_LEN + |b|
                 //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#set-entry-length
                 //= type=implication
                 //# Set Entry Length MUST be a big-endian unsigned integer
                 //# equal to the length of [Set Entry Value](#set-entry-value).
              && ret.value[0..LENGTH_LEN] == U32ToBigEndian(|b|).value
              && ret.value[LENGTH_LEN..] == b
  {
    var len :- U32ToBigEndian(|b|);
    Success(len + b)
  }

  // Binary Set to Bytes
  function method {:tailrecursion} CollectBinary(
    setToSerialize : BinarySetAttributeValue,
    pos : uint64 := 0,
    serialized : seq<uint8> := []
  ) : Result<seq<uint8>, string>
    requires pos as nat <= |setToSerialize|
    decreases |setToSerialize| - pos as nat
  {
    SequenceIsSafeBecauseItIsInMemory(setToSerialize);
    if |setToSerialize| as uint64 == pos then
      Success(serialized)
    else
      var item :- SerializeBinaryValue(setToSerialize[pos]);
      CollectBinary(setToSerialize, pos+1, serialized + item)
  }

  // List to Bytes
  // Can't be {:tailrecursion} because it calls AttrToBytes which might again call CollectList
  //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#list-entries
  //# Each list entry in the sequence MUST be serialized as:
  //# | Field             | Length                     |
  //# | ----------------- | -------------------------- |
  //# | List Entry Type   | 2                          |
  //# | List Entry Length | 4                          |
  //# | List Entry Value  | Variable. Equal to Length. |

  //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#list-entries
  //# The order of these serialized list entries MUST match
  //# the order of the entries in the original list.

  //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#list-entry-type
  //# List Entry Type MUST be the [Type ID](#type-id) of the type of [List Entry Value](#list-entry-value).

  //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#list-entry-length
  //# List Entry Length MUST be a big-endian unsigned integer
  //# equal to the length of [List Entry Value](#list-entry-value).

  //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#list-entry-value
  //# A List MAY hold any DynamoDB Attribute Value data type,
  //# and MAY hold values of different types.

  function {:opaque} CollectListGhost(
    listToSerialize : ListAttributeValue,
    depth : uint64,
    serialized : seq<uint8> := []
  )
    : (ret : Result<seq<uint8>, string>)
    requires depth <= MAX_STRUCTURE_DEPTH
    ensures (ret.Success? && |listToSerialize| == 0) ==> (ret.value == serialized)
    ensures (ret.Success? && |listToSerialize| == 0) ==> (|ret.value| == |serialized|)
    decreases listToSerialize, 1
  {
    if |listToSerialize| == 0 then
      Success(serialized)
    else
      var val :- AttrToBytes(listToSerialize[0], true, depth+1);
      CollectListGhost(listToSerialize[1..], depth, serialized + val)
  }

  // Can't be {:tailrecursion} because it calls AttrToBytes which might again call CollectList
  function {:opaque} CollectList(
    listToSerialize : ListAttributeValue,
    depth : uint64,
    serialized : seq<uint8> := []
  )
    : (ret : Result<seq<uint8>, string>)
    requires depth <= MAX_STRUCTURE_DEPTH
    ensures (ret.Success? && |listToSerialize| == 0) ==> (ret.value == serialized)
    ensures (ret.Success? && |listToSerialize| == 0) ==> (|ret.value| == |serialized|)
    decreases listToSerialize, 2
  {
    CollectListGhost(listToSerialize, depth, serialized)
  }
  by method {
    reveal CollectList();
    reveal CollectListGhost();
    var result := serialized;
    ValueIsSafeBecauseItIsInMemory(|listToSerialize|);
    for i : uint64 := 0 to |listToSerialize| as uint64
    {
      var val := AttrToBytes(listToSerialize[i], true, depth+1);
      if val.Failure? {
        ret := Failure(val.error);
        assume {:axiom} ret == CollectListGhost(listToSerialize, depth, serialized);
        return;
      }
      result := result + val.value;
    }
    ret := Success(result);
    assume {:axiom} ret == CollectListGhost(listToSerialize, depth, serialized);
  }

  function method SerializeMapItem(key : string, value : seq<uint8>) : (ret : Result<seq<uint8>, string>)

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#key-type
    //= type=implication
    //# Key Type MUST be the [Type ID](#type-id) for Strings.

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#map-key
    //= type=implication
    //# Map Key MUST be a [String Value](#string).
    ensures ret.Success? ==>
              && |ret.value| >= TYPEID_LEN
              && ret.value[0..TYPEID_LEN] == SE.STRING
              && UTF8.Encode(key).Success?
              && |ret.value| == TYPEID_LEN + LENGTH_LEN + |UTF8.Encode(key).value| + |value|
              && UTF8.Decode(ret.value[TYPEID_LEN+LENGTH_LEN..TYPEID_LEN+LENGTH_LEN+|UTF8.Encode(key).value|]).Success?
              && UTF8.Decode(ret.value[TYPEID_LEN+LENGTH_LEN..TYPEID_LEN+LENGTH_LEN+|UTF8.Encode(key).value|]).value == key
    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#key-length
    //= type=implication
    //# Key Length MUST be a non-zero big-endian unsigned integer
    //# equal to the length of [Map Key](#map-key).
    ensures ret.Success? ==>
              && UTF8.Encode(key).Success?
              && U32ToBigEndian(|UTF8.Encode(key).value|).Success?
              && |ret.value| >= TYPEID_LEN+LENGTH_LEN
              && ret.value[TYPEID_LEN..TYPEID_LEN+LENGTH_LEN] == U32ToBigEndian(|UTF8.Encode(key).value|).value

  {
    var name :- UTF8.Encode(key);
    assert UTF8.Decode(name).Success?;
    var len :- U32ToBigEndian(|name|);

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#key-value-pair-entries
    //# Each key-value pair MUST be serialized as:
    //# | Field        | Length   |
    //# | ------------ | -------- |
    //# | Key Type     | 2        |
    //# | Key Length   | 4        |
    //# | Map Key      | Variable |
    //# | Value Type   | 2        |
    //# | Value Length | 4        |
    //# | Map Value    | Variable |

    var serialized := SE.STRING + len + name + value;
    assert |serialized| == TYPEID_LEN + LENGTH_LEN + |name| + |value|;
    Success(serialized)
  }
  // Map to Bytes
  // input sequence is already serialized
  function method {:tailrecursion} {:opaque} CollectMap(
    mapToSerialize : map<AttributeName, seq<uint8>>,
    serialized : seq<uint8> := []
  )
    : (ret : Result<seq<uint8>, string>)
    ensures (ret.Success? && |mapToSerialize| == 0) ==> (ret.value == serialized)
    ensures (ret.Success? && |mapToSerialize| == 0) ==> (|ret.value| == |serialized|)
  {
    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#key-value-pair-entries
    //# Entries in a serialized Map MUST be ordered by key value,
    //# ordered in ascending [UTF-16 binary order](./string-ordering.md#utf-16-binary-order).
    var keys := SortedSets.ComputeSetToOrderedSequence2(mapToSerialize.Keys, CharLess);
    CollectOrderedMapSubset(keys, mapToSerialize, 0, serialized)
  }

  function method {:tailrecursion} {:opaque} CollectOrderedMapSubset(
    keys : seq<AttributeName>,
    mapToSerialize : map<AttributeName, seq<uint8>>,
    pos : uint64 := 0,
    serialized : seq<uint8> := []
  )
    : (ret : Result<seq<uint8>, string>)
    requires pos as nat <= |keys|
    requires forall k <- keys :: k in mapToSerialize
    ensures (ret.Success? && |keys| == 0) ==> (ret.value == serialized)
    ensures (ret.Success? && |keys| == 0) ==> (|ret.value| == |serialized|)
    decreases |keys| - pos as nat
  {
    SequenceIsSafeBecauseItIsInMemory(keys);
    if |keys| as uint64 == pos then
      Success(serialized)
    else
      var data :- SerializeMapItem(keys[pos], mapToSerialize[keys[pos]]);
      CollectOrderedMapSubset(keys, mapToSerialize, pos+1, serialized + data)
  }

  function method BoolToUint8(b : bool) : uint8
  {
    if b then 1 else 0
  }

  // AttributeValue with number of bytes consumed in its construction
  datatype AttrValueAndLength = AttrValueAndLength(
    val : AttributeValue,
    len : uint64
  )

  predicate method IsUnique<T(==)>(s : seq<T>)
  {
    |set x:T | x in s :: x| == |s|
  }

  // Bytes to Binary Set
  function method {:tailrecursion} {:vcs_split_on_every_assert}  {:opaque} DeserializeBinarySet(
    serialized : seq<uint8>,
    remainingCount : uint64,
    origSerializedSize : uint64,
    resultSet : AttrValueAndLength)
    : (ret : Result<AttrValueAndLength, string>)
    requires resultSet.val.BS?
    requires HasUint64Len(serialized)
    ensures ret.Success? ==> ret.value.val.BS?
    requires Add(|serialized| as uint64, resultSet.len) == origSerializedSize
    ensures ret.Success? ==> ret.value.len <= origSerializedSize

    //= specification/dynamodb-encryption-client/ddb-item-conversion.md#duplicates
    //= type=implication
    //# - Conversion from a Structured Data Binary Set MUST fail if it has duplicate values
    ensures ret.Success? && (remainingCount == 0) ==> IsUnique(resultSet.val.BS)
  {
    if remainingCount == 0 then
      :- Need(IsUnique(resultSet.val.BS), "Binary set values must not have duplicates");
      Success(resultSet)
    else if |serialized| < LENGTH_LEN then
      Failure("Out of bytes reading Binary Set")
    else
      var len :- BigEndianToU32As64(serialized);
      var serialized := serialized[LENGTH_LEN..];
      if |serialized| < len as int then
        Failure("Binary Set Structured Data has too few bytes")
      else
        var nattr := AttributeValue.BS(resultSet.val.BS + [serialized[..len]]);
        DeserializeBinarySet(serialized[len..], remainingCount-1, origSerializedSize, AttrValueAndLength(nattr, resultSet.len + len + LENGTH_LEN64))
  }

  // Bytes to String Set
  function method {:tailrecursion} {:vcs_split_on_every_assert} {:opaque} DeserializeStringSet(
    serialized : seq<uint8>,
    remainingCount : uint64,
    origSerializedSize : uint64,
    resultSet : AttrValueAndLength)
    : (ret : Result<AttrValueAndLength, string>)
    requires resultSet.val.SS?
    requires HasUint64Len(serialized)
    ensures ret.Success? ==> ret.value.val.SS?
    requires Add(|serialized| as uint64, resultSet.len) == origSerializedSize
    ensures ret.Success? ==> ret.value.len <= origSerializedSize

    //= specification/dynamodb-encryption-client/ddb-item-conversion.md#duplicates
    //= type=implication
    //# - Conversion from a Structured Data String Set MUST fail if it has duplicate values
    ensures ret.Success? && (remainingCount == 0) ==> IsUnique(resultSet.val.SS)
  {
    if remainingCount == 0 then
      :- Need(IsUnique(resultSet.val.SS), "String set values must not have duplicates");
      Success(resultSet)
    else if |serialized| < LENGTH_LEN then
      Failure("Out of bytes reading String Set")
    else
      var len : uint64 :- BigEndianToU32As64(serialized);
      var serialized := serialized[LENGTH_LEN..];
      if |serialized| < len as int then
        Failure("String Set Structured Data has too few bytes")
      else
        var nstring :- UTF8.Decode(serialized[..len]);
        var nattr := AttributeValue.SS(resultSet.val.SS + [nstring]);
        DeserializeStringSet(serialized[len..], remainingCount-1, origSerializedSize, AttrValueAndLength(nattr, resultSet.len + len + LENGTH_LEN64))
  }

  // Bytes to Number Set
  function method {:tailrecursion} {:vcs_split_on_every_assert} {:opaque} DeserializeNumberSet(
    serialized : seq<uint8>,
    remainingCount : uint64,
    origSerializedSize : uint64,
    resultSet : AttrValueAndLength)
    : (ret : Result<AttrValueAndLength, string>)
    requires resultSet.val.NS?
    requires HasUint64Len(serialized)
    ensures ret.Success? ==> ret.value.val.NS?
    requires Add(|serialized| as uint64, resultSet.len) == origSerializedSize
    ensures ret.Success? ==> ret.value.len <= origSerializedSize

    //= specification/dynamodb-encryption-client/ddb-item-conversion.md#duplicates
    //= type=implication
    //# - Conversion from a Structured Data Number Set MUST fail if it has duplicate values
    ensures ret.Success? && (remainingCount == 0) ==> IsUnique(resultSet.val.NS)
  {
    if remainingCount == 0 then
      :- Need(IsUnique(resultSet.val.NS), "Number set values must not have duplicates");
      Success(resultSet)
    else if |serialized| < LENGTH_LEN then
      Failure("Out of bytes reading String Set")
    else
      var len :- BigEndianToU32As64(serialized);
      var serialized := serialized[LENGTH_LEN..];
      if |serialized| < len as int then
        Failure("Number Set Structured Data has too few bytes")
      else
        var nstring :- UTF8.Decode(serialized[..len]);
        var nattr := AttributeValue.NS(resultSet.val.NS + [nstring]);
        DeserializeNumberSet(serialized[len..], remainingCount-1, origSerializedSize, AttrValueAndLength(nattr, resultSet.len + len + LENGTH_LEN64))
  }

  function method {:vcs_split_on_every_assert} DeserializeListEntry(
    serialized : seq<uint8>,
    pos : uint64,
    depth : uint64,
    resultList : AttrValueAndLength
  )
    : (ret : Result<(AttrValueAndLength, uint64), string>)
    requires HasUint64Len(serialized)
    requires pos as int <= |serialized|
    requires depth <= MAX_STRUCTURE_DEPTH
    requires resultList.val.L?
    ensures ret.Success? ==> ret.value.0.val.L?
    ensures ret.Success? ==> pos < ret.value.1 <= |serialized| as uint64
    decreases |serialized| as uint64 - pos, 0
  {
    var serialized_size := |serialized| as uint64;
    if serialized_size-pos < PREFIX_LEN64 then
      Failure("Out of bytes reading Type of List element")
    else
      var TerminalTypeId := serialized[pos..pos+2];
      var len : uint64 :- BigEndianPosToU32As64(serialized, pos+2);
      var new_pos : uint64 := pos + PREFIX_LEN64;
      if serialized_size - new_pos < len then
        Failure("Out of bytes reading Content of List element")
      else
        assert serialized_size == |serialized| as uint64;
        var nval :- BytesToAttr(serialized, TerminalTypeId, Some(len), depth+1, new_pos);
        var new_pos := Add(new_pos, nval.len);
        var nattr := AttributeValue.L(resultList.val.L + [nval.val]);
        var nResultList := AttrValueAndLength(nattr, Add(resultList.len, new_pos-pos));
        Success((nResultList, new_pos))
  }

  function {:vcs_split_on_every_assert} {:opaque} DeserializeListGhost(
    serialized : seq<uint8>,
    pos : uint64,
    orig_pos : uint64,
    remainingCount : uint64,
    depth : uint64,
    resultList : AttrValueAndLength
  )
    : (ret : Result<AttrValueAndLength, string>)
    requires HasUint64Len(serialized)
    requires pos as int <= |serialized|
    requires orig_pos <= pos
    requires depth <= MAX_STRUCTURE_DEPTH
    requires resultList.val.L?
    ensures ret.Success? ==> ret.value.val.L?
    requires pos == Add(orig_pos, resultList.len)
    ensures ret.Success? ==> ret.value.len <= |serialized| as uint64 - orig_pos
    decreases |serialized| as uint64 - pos, 1
  {
    if remainingCount == 0 then
      Success(resultList)
    else
      var (newResultList, npos) :- DeserializeListEntry(serialized, pos, depth, resultList);
      DeserializeListGhost(serialized, npos, orig_pos, remainingCount - 1, depth, newResultList)
  }

  // Bytes to List
  // Can't be {:tailrecursion} because it calls BytesToAttr which might again call DeserializeList
  function {:vcs_split_on_every_assert} {:opaque} DeserializeList(
    serialized : seq<uint8>,
    pos : uint64,
    ghost orig_pos : uint64,
    remainingCount : uint64,
    depth : uint64,
    resultList : AttrValueAndLength
  )
    : (ret : Result<AttrValueAndLength, string>)
    requires HasUint64Len(serialized)
    requires pos as int <= |serialized|
    requires orig_pos <= pos
    requires depth <= MAX_STRUCTURE_DEPTH
    requires resultList.val.L?
    ensures ret.Success? ==> ret.value.val.L?
    requires pos == Add(orig_pos, resultList.len)
    ensures ret.Success? ==> ret.value.len <= |serialized| as uint64 - orig_pos
    decreases |serialized| as uint64 - pos, 2
  {
    DeserializeListGhost(serialized, pos, orig_pos, remainingCount, depth, resultList)
  }
  by method {
    reveal DeserializeListGhost();
    reveal DeserializeList();
    var npos : uint64 := pos;
    var newResultList := resultList;
    for i : uint64 := 0 to remainingCount
      invariant serialized == old(serialized)
      invariant newResultList.val.L?
      invariant npos as int <= |serialized|
      invariant npos == Add(orig_pos, newResultList.len)
      invariant npos >= pos
    {
      var test := DeserializeListEntry(serialized, npos, depth, newResultList);
      if test.Failure? {
        ret := Failure(test.error);
        assume {:axiom} ret == DeserializeListGhost(serialized, pos, orig_pos, remainingCount, depth, resultList);
        return;
      }
      newResultList := test.value.0;
      npos := test.value.1;
    }
    ret := Success(newResultList);
    assume {:axiom} ret == DeserializeListGhost(serialized, pos, orig_pos, remainingCount, depth, resultList);
  }

  function method {:vcs_split_on_every_assert} DeserializeMapEntry(
    serialized : seq<uint8>,
    pos : uint64,
    depth : uint64,
    resultMap : AttrValueAndLength
  )
    : (ret : Result<(AttrValueAndLength, uint64), string>)
    requires HasUint64Len(serialized)
    requires pos as int <= |serialized|
    requires depth <= MAX_STRUCTURE_DEPTH
    requires resultMap.val.M?
    ensures ret.Success? ==> pos < ret.value.1 <= |serialized| as uint64
    decreases |serialized| as uint64 - pos, 0
  {
    var serialized_size := |serialized| as uint64;
    var orig_pos := pos;

    // get typeId of key
    :- Need(PREFIX_LEN64 <= serialized_size-pos, "Out of bytes reading Map Key");
    var TerminalTypeId_key := serialized[pos..pos+TYPEID_LEN64];
    :- Need(TerminalTypeId_key == SE.STRING, "Key of Map is not String");
    var pos := pos + TYPEID_LEN64;

    // get key
    var len : uint64 :- BigEndianPosToU32As64(serialized, pos);
    var pos := pos + LENGTH_LEN64;
    :- Need(len <= serialized_size-pos, "Key of Map of Structured Data has too few bytes");
    var key :- UTF8.Decode(serialized[pos..pos+len]);
    var pos := pos + len;

    // get typeId of value
    :- Need(2 <= serialized_size-pos, "Out of bytes reading Map Value");
    :- Need(IsValid_AttributeName(key), "Key is not valid AttributeName");
    var TerminalTypeId_value := serialized[pos..pos+TYPEID_LEN64];
    var pos := pos + TYPEID_LEN64;

    // get value and construct result
    var nval :- BytesToAttr(serialized, TerminalTypeId_value, None, depth+1, pos);
    var pos := Add(pos, nval.len);

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#key-value-pair-entries
    //# This sequence MUST NOT contain duplicate [Map Keys](#map-key).

    //= specification/dynamodb-encryption-client/ddb-item-conversion.md#duplicates
    //# - Conversion from a Structured Data Map MUST fail if it has duplicate keys

    :- Need(key !in resultMap.val.M, "Duplicate key in map.");
    var nattr := AttributeValue.M(resultMap.val.M[key := nval.val]);
    var newResultMap := AttrValueAndLength(nattr, Add(resultMap.len, (pos - orig_pos)));

    Success((newResultMap, pos))
  }

  function {:vcs_split_on_every_assert} {:opaque}  DeserializeMapGhost(
    serialized : seq<uint8>,
    pos : uint64,
    orig_pos : uint64,
    remainingCount : uint64,
    depth : uint64,
    resultMap : AttrValueAndLength)
    : (ret : Result<AttrValueAndLength, string>)
    requires HasUint64Len(serialized)
    requires pos as int <= |serialized|
    requires orig_pos <= pos
    requires resultMap.val.M?
    requires depth <= MAX_STRUCTURE_DEPTH
    ensures ret.Success? ==> ret.value.val.M?
    requires pos == Add(orig_pos, resultMap.len)
    ensures ret.Success? ==> ret.value.len <= |serialized| as uint64 - orig_pos
    decreases |serialized| as uint64 - pos, 1
  {
    if remainingCount == 0 then
      Success(resultMap)
    else
      var (newResultMap, npos) :- DeserializeMapEntry(serialized, pos, depth, resultMap);
      DeserializeMapGhost(serialized, npos, orig_pos, remainingCount - 1, depth, newResultMap)
  }

  // Bytes to Map
  // Can't be {:tailrecursion} because it calls BytesToAttr which might again call DeserializeMap
  function {:vcs_split_on_every_assert} {:opaque}  DeserializeMap(
    serialized : seq<uint8>,
    pos : uint64,
    ghost orig_pos : uint64,
    remainingCount : uint64,
    depth : uint64,
    resultMap : AttrValueAndLength)
    : (ret : Result<AttrValueAndLength, string>)
    requires HasUint64Len(serialized)
    requires pos as int <= |serialized|
    requires orig_pos <= pos
    requires resultMap.val.M?
    requires depth <= MAX_STRUCTURE_DEPTH
    ensures ret.Success? ==> ret.value.val.M?
    requires pos == Add(orig_pos, resultMap.len)
    ensures ret.Success? ==> ret.value.len <= |serialized| as uint64 - orig_pos
    decreases |serialized| as uint64 - pos, 2
  {
    DeserializeMapGhost(serialized, pos, orig_pos, remainingCount, depth, resultMap)
  }
  by method {
    reveal DeserializeMapGhost();
    reveal DeserializeMap();
    var npos : uint64 := pos;
    var newResultMap := resultMap;
    for i : uint64 := 0 to remainingCount
      invariant serialized == old(serialized)
      invariant newResultMap.val.M?
      invariant npos as int <= |serialized|
      invariant npos == Add(orig_pos, newResultMap.len)
      invariant npos >= pos
    {
      var test := DeserializeMapEntry(serialized, npos, depth, newResultMap);
      if test.Failure? {
        ret := Failure(test.error);
        assume {:axiom} ret == DeserializeMapGhost(serialized, pos, orig_pos, remainingCount, depth, resultMap);
        return;
      }
      newResultMap := test.value.0;
      npos := test.value.1;
    }
    ret := Success(newResultMap);
    assume {:axiom} ret == DeserializeMapGhost(serialized, pos, orig_pos, remainingCount, depth, resultMap);
  }

  // Bytes to AttributeValue
  // Can't be {:tailrecursion} because it calls DeserializeList and DeserializeMap which then call BytesToAttr
  function method {:vcs_split_on_every_assert} {:opaque} BytesToAttr(
    value : seq<uint8>,
    typeId : TerminalTypeId,
    totalBytes : Option<uint64>, // Some(number of bytes past pos) or None for 'read first bytes to find length'
    depth : uint64 := 1,
    pos : uint64 := 0    // starting position within value
  )
    : (ret : Result<AttrValueAndLength, string>)
    requires HasUint64Len(value)
    requires pos <= |value| as uint64
    requires totalBytes.Some? ==> Add(pos, totalBytes.value) <= |value| as uint64
    ensures ret.Success? ==> Add(pos, ret.value.len) <= |value| as uint64
    ensures MAX_STRUCTURE_DEPTH < depth ==> ret.Failure?
    decreases |value| as uint64 - pos
  {
    var value_size : uint64 := |value| as uint64;
    :- Need(depth <= MAX_STRUCTURE_DEPTH, "Depth of attribute structure to deserialize exceeds limit of " + MAX_STRUCTURE_DEPTH_STR);
    var len : uint64 :- if totalBytes.None? then
                          BigEndianPosToU32As64(value, pos)
                        else
                          Success(totalBytes.value);
    var pos := if totalBytes.None? then Add(pos, LENGTH_LEN64) else pos;
    var lengthBytes : uint64 := if totalBytes.None? then LENGTH_LEN64 else 0;

    if value_size - pos < len then
      Failure("Structured Data has too few bytes")

    else if typeId == SE.NULL then
      if len != 0 then
        Failure("NULL type did not have length zero")
      else
        // DynamoDB includes a boolean with the NULL
        // We pick true because it appears that the server rejects NULL(false)
        // NOTE : if you start with NULL(false), Decode(Encode()) will produce NULL(true)
        // and so round-trip identity is NOT preserved
        Success(AttrValueAndLength(AttributeValue.NULL(true), lengthBytes))

    else if typeId == SE.STRING then
      var str :- UTF8.Decode(value[pos..pos+len]);
      Success(AttrValueAndLength(AttributeValue.S(str), len+lengthBytes))

    else if typeId == SE.NUMBER then
      var str :- UTF8.Decode(value[pos..pos+len]);
      Success(AttrValueAndLength(AttributeValue.N(str), len+lengthBytes))

    else if typeId == SE.BINARY then
      Success(AttrValueAndLength(AttributeValue.B(value[pos..pos+len]), len+lengthBytes))

    else if typeId == SE.BOOLEAN then
      if len != BOOL_LEN64 then
        Failure("Boolean Structured Data has more than one byte")
      else if value[pos] == 0x00 then
        Success(AttrValueAndLength(AttributeValue.BOOL(false), BOOL_LEN64+lengthBytes))
      else if value[pos] == 0x01 then
        Success(AttrValueAndLength(AttributeValue.BOOL(true), BOOL_LEN64+lengthBytes))
      else
        Failure("Boolean Structured Data had inappropriate value")

    else if typeId == SE.STRING_SET then
      if value_size - pos < LENGTH_LEN64 then
        Failure("String Set Structured Data has less than LENGTH_LEN bytes")
      else
        var len : uint64 :- BigEndianPosToU32As64(value, pos);
        var pos : uint64 := pos + LENGTH_LEN64;
        var retval :- DeserializeStringSet(value[pos..], len, Add3(value_size - pos, LENGTH_LEN64, lengthBytes), AttrValueAndLength(AttributeValue.SS([]), LENGTH_LEN64+lengthBytes));
        // this is not needed with Dafny 4.10
        assume {:axiom} Add(pos, retval.len) <= |value| as uint64;
        Success(retval)

    else if typeId == SE.NUMBER_SET then
      if value_size - pos < LENGTH_LEN64 then
        Failure("Number Set Structured Data has less than 4 bytes")
      else
        var len : uint64 :- BigEndianPosToU32As64(value, pos);
        var pos : uint64 := pos + LENGTH_LEN64;
        var retval :- DeserializeNumberSet(value[pos..], len, Add3(value_size - pos, LENGTH_LEN64, lengthBytes), AttrValueAndLength(AttributeValue.NS([]), LENGTH_LEN64 + lengthBytes));
        // this is not needed with Dafny 4.10
        assume {:axiom} Add(pos, retval.len) <= |value| as uint64;
        Success(retval)

    else if typeId == SE.BINARY_SET then
      if value_size - pos < LENGTH_LEN64 then
        Failure("Binary Set Structured Data has less than LENGTH_LEN bytes")
      else
        var len : uint64 :- BigEndianPosToU32As64(value, pos);
        var pos : uint64 := pos + LENGTH_LEN64;
        var retval :- DeserializeBinarySet(value[pos..], len, Add3(value_size - pos, LENGTH_LEN64, lengthBytes), AttrValueAndLength(AttributeValue.BS([]), LENGTH_LEN64 + lengthBytes));
        // this is not needed with Dafny 4.10
        assume {:axiom} Add(pos, retval.len) <= |value| as uint64;
        Success(retval)

    else if typeId == SE.MAP then
      if value_size < Add(LENGTH_LEN64, pos) then
        Failure("List Structured Data has less than 4 bytes")
      else
        var len : uint64 :- BigEndianPosToU32As64(value, pos);
        var pos : uint64 := pos + LENGTH_LEN64;
        var resultMap := AttrValueAndLength(AttributeValue.M(map[]), LENGTH_LEN64 + lengthBytes);
        var retval :- DeserializeMap(value, pos, pos - resultMap.len, len, depth, resultMap);
        // this is not needed with Dafny 4.10
        assume {:axiom} Add(pos, retval.len) <= |value| as uint64;
        Success(retval)

    else if typeId == SE.LIST then
      if value_size < Add(LENGTH_LEN64, pos) then
        Failure("List Structured Data has less than 4 bytes")
      else
        var len : uint64 :- BigEndianPosToU32As64(value, pos);
        var pos : uint64 := pos + LENGTH_LEN64;
        assert pos <= value_size;
        assert value_size == |value| as uint64;
        assert pos <= |value| as uint64;
        var resultList := AttrValueAndLength(AttributeValue.L([]), LENGTH_LEN64 + lengthBytes);
        var retval :- DeserializeList(value, pos, pos - resultList.len, len, depth, resultList);
        // this is not needed with Dafny 4.10
        assume {:axiom} Add(pos, retval.len) <= |value| as uint64;
        Success(retval)
    else
      Failure("Unsupported TerminalTypeId")

  }

  function method FlattenValueMap<X,Y>(m : map<X, Result<Y,string>>): map<X,Y> {
    map k <- m | m[k].Success? :: k := m[k].value
  }

  function method FlattenErrors<X,Y>(m : map<X, Result<Y,string>>): set<string> {
    set k <- m | m[k].Failure? :: m[k].error
  }

  lemma OneBadResult<X,Y>(m : map<X, Result<Y,string>>)
    requires ! forall k <- m :: m[k].Success?
    ensures exists k <- m :: m[k].Failure?
    ensures |FlattenErrors(m)| > 0
  {
    assert exists k <- m :: m[k].Failure?;
    var errors := FlattenErrors(m);
    assert exists k :: k in m && m[k].Failure? && (m[k].error in errors);
  }

  lemma MapKeysMatchItems<X,Y>(m : map<X,Y>)
    ensures forall k :: k in m.Keys ==> (k, m[k]) in m.Items
  {}

  lemma OneBadKey<X,Y>(s : map<X,Y>, bad : set<X>, f : X -> bool)
    requires !forall k <- s.Keys :: f(k)
    requires bad == set k <- s.Keys | !f(k) :: k
    ensures exists k <- s.Keys :: !f(k)
    ensures |bad| > 0
  {
    assert exists v :: v in bad && !f(v) && (v in bad);
  }

  lemma SimplifyMapValueSuccess<X,Y>(m : map<X, Result<Y,string>>)
    ensures SimplifyMapValue(m).Success? <==> forall k <- m :: m[k].Success?
    ensures SimplifyMapValue(m).Success? ==> forall kv <- m.Items :: kv.1.Success?
    ensures SimplifyMapValue(m).Failure? <==> exists k : X | k in m.Keys :: m[k].Failure?
  {}

  // Turn a map<X, Result<Y,string>> into a Result<map<X,Y>, string>
  // If anything reported Failure, return a Failure with all of the error messages
  //
  // useful when  g in
  // var ret := map kv <- m.Items | true :: kv.0 := g(kv.1);
  // returns Result
  function method SimplifyMapValue<X,Y>(m : map<X, Result<Y,string>>) : (ret : Result<map<X,Y>, string>)
    ensures ret.Success? ==> ret.value.Keys == m.Keys
    ensures ret.Success? ==> |ret.value.Keys| == |m.Keys|
    ensures ret.Success? ==> |ret.value| == |m|
  {
    if forall k <- m :: m[k].Success? then
      var result := FlattenValueMap(m);
      MapKeysMatchItems(m);
      Success(result)
    else
      OneBadResult(m);
      var badValues := FlattenErrors(m);
      assert(|badValues| > 0);
      // We happen to order these values, but this ordering MUST NOT be relied upon.
      var badValueSeq := SetToOrderedSequence(badValues, CharLess);
      Failure(Join(badValueSeq, "\n"))
  }
}
