// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDynamoDbItemEncryptorTypes.dfy"

module DynamoToStruct {

  import opened ComAmazonawsDynamodbTypes
  import opened AwsCryptographyStructuredEncryptionTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import AwsCryptographyDynamoDbItemEncryptorTypes
  import Util = StructuredEncryptionUtil
  import UTF8
  import SortedSets
  import Seq
  import SE = StructuredEncryptionUtil

  type Error = AwsCryptographyDynamoDbItemEncryptorTypes.Error

  type TerminalDataMap = map<AttributeName, Util.StructuredDataTerminalType>


/* TODO - prove the following
  StructuredToItem(ItemToStructured(itemMap)) == itemMap
  ItemToStructured(StructuredToItem(structureMap)) == structureMap
  AttrToStructured(StructuredToAttr(structure)) == structure
  StructuredToAttr(AttrToStructured(item)) == item

  Also prove : "there exists a single canonical serialization of items that contains a set or map (i.e. there is a canonical ordering or set entries)"
*/

//= specification/dynamodb-encryption-client/ddb-item-conversion.md#overview
//= type=TODO
//# The conversion from DDB Item to Structured Data must be lossless,
//# meaning that converting a DDB Item to
//# a Structured Data and back to a DDB Item again
//# MUST result in the exact same DDB Item.

  // This file exists for these two functions : ItemToStructured and StructuredToItem
  // which provide lossless conversion between an AttributeMap and a StructuredDataMap

  // Convert AttributeMap to StructuredDataMap
  //= specification/dynamodb-encryption-client/ddb-item-conversion.md#convert-ddb-item-to-structured-data
  //= type=implication
  //# - MUST be a [Structured Data Map](../structured-encryption/structures.md#structured-data-map).
  function method {:opaque} ItemToStructured(item : AttributeMap) : (ret : Result<TerminalDataMap, Error>)

    //= specification/dynamodb-encryption-client/ddb-item-conversion.md#convert-ddb-item-to-structured-data
    //= type=implication
    //# - MUST contain a [Structured Data Terminal](../structured-encryption/structures.md#structured-data-terminal)
    //# for each attribute on the DynamoDB Item, and no others.
    ensures ret.Success? ==> ret.value.Keys == item.Keys;

    //= specification/dynamodb-encryption-client/ddb-item-conversion.md#convert-ddb-item-to-structured-data
    //= type=implication
    //# - MUST NOT have [Structured Data Attributes](../structured-encryption/structures.md#structured-data-attributes).
    ensures ret.Success? ==> forall v <- ret.value.Values :: v.content.Terminal?

    //= specification/dynamodb-encryption-client/ddb-item-conversion.md#convert-ddb-item-to-structured-data
    //= type=implication
    //# - The [Terminal Type ID](../structured-encryption/structures.md#terminal-type-id) for each attribute MUST
    //# be the [Type ID](./ddb-attribute-serialization.md#type-id) of the [serialization](./ddb-attribute-serialization.md) of this Attribute Value.
    ensures ret.Success? ==> forall kv <- ret.value.Items :: kv.1.content.Terminal.typeId == AttrToTypeId(item[kv.0])

    //= specification/dynamodb-encryption-client/ddb-item-conversion.md#convert-ddb-item-to-structured-data
    //= type=implication
    //# - The Structured Data Terminal MUST be located at the top level of the Structured Data,
    //# string indexed by the Attribute Name.
    ensures ret.Success? ==> forall kv <- ret.value.Items :: kv.0 in ret.value.Keys && ret.value[kv.0].content.Terminal?

    //= specification/dynamodb-encryption-client/ddb-item-conversion.md#convert-ddb-item-to-structured-data
    //= type=implication
    //# - The [Terminal Value](../structured-encryption/structures.md#terminal-value) for each attribute MUST
    //# be the [Value](./ddb-attribute-serialization.md#type-id) of the [serialization](./ddb-attribute-serialization.md) of this Attribute Value.
    ensures ret.Success? ==> forall kv <- ret.value.Items ::
      && TopLevelAttributeToBytes(item[kv.0]).Success?
      && kv.1.content.Terminal.value == TopLevelAttributeToBytes(item[kv.0]).value

  {
    var structuredMap := map kv <- item.Items | true :: kv.0 := AttrToStructured(kv.1);
    MapKeysMatchItems(item);
    MapError(SimplifyMapValue(structuredMap))
  }

  // Convert StructuredDataMap to AttributeMap
  //= specification/dynamodb-encryption-client/ddb-item-conversion.md#convert-structured-data-to-ddb-item
  //= type=implication
  //# - MUST be a [Structured Data Map](../structured-encryption/structures.md#structured-data-map).
  function method {:opaque} StructuredToItem(s : StructuredDataMap) : (ret : Result<AttributeMap, Error>)
    //= specification/dynamodb-encryption-client/ddb-item-conversion.md#convert-structured-data-to-ddb-item
    //= type=implication
    //# - MUST contain an Attribute for every [Structured Data Terminal](../structured-encryption/structures.md#structured-data-terminal)
    //# on the Structured Data, and not other Attributes.
    ensures ret.Success? ==> ret.value.Keys == s.Keys;

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
    if forall k <- s.Keys :: IsValid_AttributeName(k) then
      var structuredData := map kv <- s.Items | true :: kv.0 := StructuredToAttr(kv.1);
      MapKeysMatchItems(s);
      MapError(SimplifyMapValue(structuredData))
    else
      var badNames := set k <- s.Keys | !IsValid_AttributeName(k) :: k;
      OneBadKey(s, badNames, IsValid_AttributeName);
      var orderedAttrNames := SetToOrderedSequence(badNames, CharLess);
      var attrNameList := Join(orderedAttrNames, ",");
      MakeError("Not valid attribute names : " + attrNameList)
  }

  // everything past here is to implement those two

  // Prove round trip. A work in progress
  lemma RoundTripFromItem(item : AttributeValue)
    ensures  item.B? && AttrToStructured(item).Success? ==> StructuredToAttr(AttrToStructured(item).value).Success?
    ensures  item.NULL? && AttrToStructured(item).Success? ==>
      && StructuredToAttr(AttrToStructured(item).value).Success?
    ensures  item.BOOL? && AttrToStructured(item).Success? ==> StructuredToAttr(AttrToStructured(item).value).Success?
  {
    reveal AttrToStructured();
    reveal StructuredToAttr();
    reveal TopLevelAttributeToBytes();
    reveal AttrToBytes();
    reveal BytesToAttr();

  }

  // Prove round trip. A work in progress
  lemma RoundTripFromStructured(s : StructuredData)
    ensures  StructuredToAttr(s).Success? && s.content.Terminal.typeId == BINARY ==>
      && AttrToStructured(StructuredToAttr(s).value).Success?
    ensures  StructuredToAttr(s).Success? && s.content.Terminal.typeId == BOOLEAN ==>
      && AttrToStructured(StructuredToAttr(s).value).Success?
    ensures  StructuredToAttr(s).Success? && s.content.Terminal.typeId == NULL ==>
      && AttrToStructured(StructuredToAttr(s).value).Success?
{
    reveal AttrToStructured();
    reveal StructuredToAttr();
    reveal TopLevelAttributeToBytes();
    reveal AttrToBytes();
    reveal BytesToAttr();
  }

  function method MakeError<T>(s : string) : Result<T, Error> {
    Failure(Error.DynamoDbItemEncryptorException(message := s))
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

  function method  {:opaque} AttrToStructured(item : AttributeValue) : (ret : Result<StructuredData, string>)
    ensures ret.Success? ==> ret.value.content.Terminal?
    ensures ret.Success? ==> ret.value.content.Terminal.typeId == AttrToTypeId(item)
    ensures ret.Success? ==>
      && TopLevelAttributeToBytes(item).Success?
      && ret.value.content.Terminal.value == TopLevelAttributeToBytes(item).value
  {
    var body :- TopLevelAttributeToBytes(item);
    Success(StructuredData(content := Terminal(StructuredDataTerminal(value := body, typeId := AttrToTypeId(item))), attributes := None))
  }

  function method  {:opaque} StructuredToAttr(s : StructuredData) : (ret : Result<AttributeValue, string>)
    //= specification/dynamodb-encryption-client/ddb-item-conversion.md#convert-structured-data-to-ddb-item
    //= type=implication
    //# - This [Structured Data Map](../structured-encryption/structures.md#structured-data-map),
    //# if not empty,
    //# MUST only contain [Structured Data Terminals](../structured-encryption/structures.md#structured-data-terminal).
    ensures ret.Success? ==> s.content.Terminal?

    //= specification/dynamodb-encryption-client/ddb-item-conversion.md#convert-structured-data-to-ddb-item
    //= type=implication
    //# - MUST NOT have [Structured Data Attributes](../structured-encryption/structures.md#structured-data-attributes).
    ensures ret.Success? ==> s.attributes.None?
  {
    :- Need(s.attributes.None?, "attributes must be None");
    match s.content {
      case Terminal(s) => 
        :- Need(|s.typeId| == 2, "Type ID must be two bytes");
        var attrValueAndLength :- BytesToAttr(s.value, s.typeId, false);
        :- Need(attrValueAndLength.len == |s.value|, "Mismatch between length of encoded data and length of data");
        Success(attrValueAndLength.val)
      case _ => Failure("StructuredData to AttributeValue only works on Terminal data")
    }
  }

    const BOOL_LEN : nat := 1;   // number of bytes in an encoded boolean
    const TYPEID_LEN : nat := 2;   // number of bytes in a TerminalTypeId
    const LENGTH_LEN : nat := 4; // number of bytes in an encoded count or length
    const PREFIX_LEN : nat := 6; // number of bytes in a prefix, i.e. 2-byte type and 4-byte length


    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#type-id
    //= type=implication
    //# Type ID indicates what type a DynamoDB Attribute Value MUST
    //# be serialized and deserialized as.
    //# | Attribute Value Data Type | Terminal Type ID |
    //# | ------------------------- | ---------------- |
    //# | Null (NULL)               | 0x0000           |
    //# | String (S)                | 0x0001           |
    //# | Number (N)                | 0x0002           |
    //# | Binary (B)                | 0xFFFF           |
    //# | Boolean (BOOL)            | 0x0004           |
    //# | String Set (SS)           | 0x0101           |
    //# | Number Set (NS)           | 0x0102           |
    //# | Binary Set (BS)           | 0x01FF           |
    //# | Map (M)                   | 0x0200           |
    //# | List (L)                  | 0x0300           |
    const TERM_T : uint8 := 0x00;
    const SET_T  : uint8 := 0x01;
    const MAP_T  : uint8 := 0x02;
    const LIST_T : uint8 := 0x03;
    const NULL_T : uint8 := 0x00;
    const STRING_T  : uint8 := 0x01;
    const NUMBER_T  : uint8 := 0x02;
    const BINARY_T : uint8 := 0xFF;
    const BOOLEAN_T : uint8 := 0x04;

    const NULL       : TerminalTypeId := [TERM_T, NULL_T];
    const STRING     : TerminalTypeId := [TERM_T, STRING_T];
    const NUMBER     : TerminalTypeId := [TERM_T, NUMBER_T];
    const BINARY     : TerminalTypeId := SE.BYTES_TYPE_ID;
    const BOOLEAN    : TerminalTypeId := [TERM_T, BOOLEAN_T];
    const STRING_SET : TerminalTypeId := [SET_T,  STRING_T];
    const NUMBER_SET : TerminalTypeId := [SET_T,  NUMBER_T];
    const BINARY_SET : TerminalTypeId := [SET_T,  BINARY_T];
    const MAP        : TerminalTypeId := [MAP_T,  NULL_T];
    const LIST       : TerminalTypeId := [LIST_T, NULL_T];

  function method AttrToTypeId(a : AttributeValue) : TerminalTypeId
  {
    match a {
      case S(s) => STRING
      case N(n) => NUMBER
      case B(b) => BINARY
      case SS(ss) => STRING_SET
      case NS(ns) => NUMBER_SET
      case BS(bs) => BINARY_SET
      case M(m) => MAP
      case L(l) => LIST
      case NULL(n) => NULL
      case BOOL(b) => BOOLEAN
    }
  }

  predicate method CharLess(x : char, y : char) {
    x < y
  }

  // convert AttributeValue to byte sequence
  // if `prefix` is true, prefix sequence with TypeID and Length
  function method {:opaque} AttrToBytes(a : AttributeValue, prefix : bool) : (ret : Result<seq<uint8>, string>)
    decreases a
    ensures ret.Success? && prefix ==> 6 <= |ret.value|

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#boolean
    //= type=implication
    //# Boolean MUST be serialized as:
    //# - `0x00` if the value is `false`
    //# - `0x01` if the value is `true`
    ensures a.BOOL? && !prefix ==>
      && (a.BOOL  ==> ret.Success? && |ret.value| == BOOL_LEN && ret.value[0] == 1)
      && (!a.BOOL ==> ret.Success? && |ret.value| == BOOL_LEN && ret.value[0] == 0)
    ensures a.BOOL? && prefix ==>
      && (a.BOOL  ==> (ret.Success? && |ret.value| == PREFIX_LEN+BOOL_LEN && ret.value[PREFIX_LEN] == 1
          && ret.value[0..TYPEID_LEN] == BOOLEAN && ret.value[TYPEID_LEN..PREFIX_LEN] == [0,0,0,1]))
      && (!a.BOOL ==> (ret.Success? && |ret.value| == PREFIX_LEN+BOOL_LEN && ret.value[PREFIX_LEN] == 0
          && ret.value[0..TYPEID_LEN] == BOOLEAN && ret.value[TYPEID_LEN..PREFIX_LEN] == [0,0,0,1]))

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#binary
    //= type=implication
    //# Binary MUST be serialized with the identity function;
    //# or more plainly, Binary Attribute Values are used as is.
    ensures a.B? && !prefix ==> ret.Success? && ret.value == a.B
    ensures a.B? && prefix && ret.Success? ==>
      && ret.value[PREFIX_LEN..] == a.B
      && ret.value[0..TYPEID_LEN] == BINARY
      && U32ToBigEndian(|a.B|).Success?
      && ret.value[TYPEID_LEN..PREFIX_LEN] == U32ToBigEndian(|a.B|).value
      && BigEndianToU32(ret.value[TYPEID_LEN..PREFIX_LEN]).value == |a.B|

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#null
    //= type=implication
    //# Null MUST be serialized as a zero-length byte string.
    ensures a.NULL? && !prefix ==> ret.Success? && |ret.value| == 0
    ensures a.NULL? &&  prefix ==> ret.Success? && |ret.value| == PREFIX_LEN && ret.value[0..TYPEID_LEN] == NULL && ret.value[TYPEID_LEN..PREFIX_LEN] == [0,0,0,0]
  
    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#string
    //= type=implication
    //# String MUST be serialized as UTF-8 encoded bytes.
    ensures a.S? && ret.Success? && !prefix ==> 
      UTF8.Decode(ret.value).Success? && UTF8.Decode(ret.value).value == a.S
    ensures a.S? && ret.Success? && prefix ==> 
      && UTF8.Decode(ret.value[PREFIX_LEN..]).Success?
      && UTF8.Decode(ret.value[PREFIX_LEN..]).value == a.S
      && ret.value[0..TYPEID_LEN] == STRING
      && UTF8.Encode(a.S).Success?
      && U32ToBigEndian(|UTF8.Encode(a.S).value|).Success?
      && ret.value[TYPEID_LEN..PREFIX_LEN] == U32ToBigEndian(|UTF8.Encode(a.S).value|).value
 
    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#number
    //= type=implication
    //# Number MUST be serialized as UTF-8 encoded bytes.
    ensures a.N? && ret.Success? && !prefix ==> 
      UTF8.Decode(ret.value).Success? && UTF8.Decode(ret.value).value == a.N
    ensures a.N? && ret.Success? && prefix ==> 
      && UTF8.Decode(ret.value[PREFIX_LEN..]).Success?
      && UTF8.Decode(ret.value[PREFIX_LEN..]).value == a.N
      && ret.value[0..TYPEID_LEN] == NUMBER
      && UTF8.Encode(a.N).Success?
      && U32ToBigEndian(|UTF8.Encode(a.N).value|).Success?
      && ret.value[TYPEID_LEN..PREFIX_LEN] == U32ToBigEndian(|UTF8.Encode(a.N).value|).value

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#set-entries
    //= type=implication
    //# Binary Sets MUST NOT contain duplicate entries.
    ensures a.BS? && ret.Success? ==> Seq.HasNoDuplicates(a.BS)

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#set
    //= type=implication
    //# A Set MUST be serialized as:
    //# | Field        | Length   |
    //# | ------------ | -------- |
    //# | Set Count    | 4        |
    //# | Set Entries  | Variable |

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
      && ret.value[0..TYPEID_LEN] == BINARY_SET
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
      && ret.value[0..TYPEID_LEN] == STRING_SET
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
      && ret.value[0..TYPEID_LEN] == NUMBER_SET
      && ret.value[PREFIX_LEN..PREFIX_LEN+LENGTH_LEN] == U32ToBigEndian(|a.NS|).value

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#list
    //= type=implication
    //# List MUST be serialized as:
    //# | Field         | Length   |
    //# | ------------- | -------- |
    //# | List Count    | 4        |
    //# | List Entries  | Variable |
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
      && U32ToBigEndian(|a.L|).Success?
      && |ret.value| >= PREFIX_LEN + LENGTH_LEN
      && ret.value[0..TYPEID_LEN] == LIST
      && ret.value[PREFIX_LEN..PREFIX_LEN+LENGTH_LEN] == U32ToBigEndian(|a.L|).value
      && (|a.L| == 0 ==> |ret.value| == PREFIX_LEN + LENGTH_LEN)

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#map-todo-duvet-currently-can-t-handle-headers-named-map
    //= type=implication
    //# Map MUST be serialized as:
    //# | Field                   | Length   |
    //# | ----------------------- | -------- |
    //# | Key Value Pair Count    | 4        |
    //# | Key Value Pair Entries  | Variable |
    ensures a.M? && ret.Success? && !prefix ==>
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
    var baseBytes :- match a {
      case S(s) => UTF8.Encode(s)
      case N(n) => UTF8.Encode(n)
      case B(b) => Success(b)
      case SS(ss) =>
        :- Need(|Seq.ToSet(ss)| == |ss|, "String Set had duplicate values");
        Seq.LemmaNoDuplicatesCardinalityOfSet(ss);
        var count :- U32ToBigEndian(|ss|);
        var body :- CollectString(ss);
        Success(count + body)
      case NS(ns) =>
        :- Need(|Seq.ToSet(ns)| == |ns|, "String Set had duplicate values");
        Seq.LemmaNoDuplicatesCardinalityOfSet(ns);
        var count :- U32ToBigEndian(|ns|);
        var body :- CollectString(ns);
        Success(count + body)
      case BS(bs) =>
        :- Need(|Seq.ToSet(bs)| == |bs|, "String Set had duplicate values");
        Seq.LemmaNoDuplicatesCardinalityOfSet(bs);
        var count :- U32ToBigEndian(|bs|);
        var body :- CollectBinary(bs);
        Success(count + body)
      case M(m) =>
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
        var bytes := map kv <- m.Items | true :: kv.0 := AttrToBytes(kv.1, true);
        var bytes :- SimplifyMapValue(bytes);
        var keys := SortedSets.ComputeSetToOrderedSequence2(bytes.Keys, CharLess);
        var count :- U32ToBigEndian(|m|);
        var body :- CollectMap(keys, bytes);
        Success(count + body)
     case L(l) =>
        var count :- U32ToBigEndian(|l|);
        var body :- CollectList(l);
        Success(count + body)
 
      case NULL(n) => Success([])
      case BOOL(b) => Success([BoolToUint8(b)])
    };
    if prefix then
      var len :- U32ToBigEndian(|baseBytes|);
      Success(AttrToTypeId(a) + len + baseBytes)
    else
      Success(baseBytes)
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
    if x > 0xffff_ffff then
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
    serialized : seq<uint8> := []) 
    : Result<seq<uint8>, string>
  {
    if |setToSerialize| == 0 then
      Success(serialized)
    else
      var entry :- EncodeString(setToSerialize[0]);
      CollectString(setToSerialize[1..], serialized + entry)
  }


  function method SerializeBinaryValue(b : BinaryAttributeValue) : (ret : Result<seq<uint8>, string>)
    // for parallel implication for String Set and Number Set see EncodeString
    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#set-entries
    //= type=implication
    //# Each of these entries MUST be serialized as:
    //# | Field               | Length                               |
    //# | ------------------- | ------------------------------------ |
    //# | Set Entry Length    | 4                                    |
    //# | Set Entry Value     | Variable. Equal to Set Entry Length. |
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
  function method {:tailrecursion} CollectBinary(setToSerialize : BinarySetAttributeValue, serialized : seq<uint8> := []) : Result<seq<uint8>, string>
  {
    if |setToSerialize| == 0 then
      Success(serialized)
    else
      var item :- SerializeBinaryValue(setToSerialize[0]);
      CollectBinary(setToSerialize[1..], serialized + item)
  }

  // List to Bytes
  // Can't be {:tailrecursion} because it calls AttrToBytes which might again call CollectList
  //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#list-entries
  //# Each list entry in the sequence MUST be serialized as:
  //# | Field                | Length                     |
  //# | -------------------- | -------------------------- |
  //# | List Entry Type      | 2                          |
  //# | List Entry Length    | 4                          |
  //# | List Entry Value     | Variable. Equal to Length. |

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
  function method {:opaque} CollectList(
    listToSerialize : ListAttributeValue,
    serialized : seq<uint8> := []
  )
    : (ret : Result<seq<uint8>, string>)
    ensures (ret.Success? && |listToSerialize| == 0) ==> (ret.value == serialized)
    ensures (ret.Success? && |listToSerialize| == 0) ==> (|ret.value| == |serialized|)
  {
    if |listToSerialize| == 0 then
      Success(serialized)
    else
      var val :- AttrToBytes(listToSerialize[0], true);
      CollectList(listToSerialize[1..], serialized + val)
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
      && ret.value[0..TYPEID_LEN] == STRING
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

      var serialized := STRING + len + name + value;
      assert |serialized| == TYPEID_LEN + LENGTH_LEN + |name| + |value|;
      Success(serialized)
  }
  // Map to Bytes
  // input sequence is already serialized
  function method {:tailrecursion} {:opaque} CollectMap(
    keys : seq<AttributeName>,
    mapToSerialize : map<AttributeName, seq<uint8>>,
    serialized : seq<uint8> := []
  )
    : (ret : Result<seq<uint8>, string>)
    requires forall k <- keys :: k in mapToSerialize
    ensures (ret.Success? && |keys| == 0) ==> (ret.value == serialized)
    ensures (ret.Success? && |keys| == 0) ==> (|ret.value| == |serialized|)
  {
    if |keys| == 0 then
      Success(serialized)
    else
      var data :- SerializeMapItem(keys[0], mapToSerialize[keys[0]]);
      CollectMap(keys[1..], mapToSerialize, serialized + data)
  }
  
  function method BoolToUint8(b : bool) : uint8
  {
    if b then 1 else 0
  }

  // AttributeValue with number of bytes consumed in its construction
  datatype AttrValueAndLength = AttrValueAndLength(
    val : AttributeValue,
    len : nat
  )

  predicate method IsUnique<T(==)>(s : seq<T>)
  {
    |set x:T | x in s :: x| == |s|
  }

  // Bytes to Binary Set
  function method {:tailrecursion} {:vcs_split_on_every_assert}  {:opaque} DeserializeBinarySet(
    serialized : seq<uint8>,
    remainingCount : nat,
    origSerializedSize : nat,
    resultSet : AttrValueAndLength)
    : (ret : Result<AttrValueAndLength, string>)
    requires resultSet.val.BS?
    ensures ret.Success? ==> ret.value.val.BS?
    requires |serialized| + resultSet.len == origSerializedSize
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
      var len :- BigEndianToU32(serialized);
      var serialized := serialized[LENGTH_LEN..];
      if |serialized| < len as int then
        Failure("Binary Set Structured Data has too few bytes")
      else
        var nattr := AttributeValue.BS(resultSet.val.BS + [serialized[..len]]);
        DeserializeBinarySet(serialized[len..], remainingCount-1, origSerializedSize, AttrValueAndLength(nattr, resultSet.len + len + LENGTH_LEN))
  }

  // Bytes to String Set
  function method {:tailrecursion} {:vcs_split_on_every_assert} {:opaque} DeserializeStringSet(
    serialized : seq<uint8>,
    remainingCount : nat,
    origSerializedSize : nat,
    resultSet : AttrValueAndLength)
    : (ret : Result<AttrValueAndLength, string>)
    requires resultSet.val.SS?
    ensures ret.Success? ==> ret.value.val.SS?
    requires |serialized| + resultSet.len == origSerializedSize
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
      var len :- BigEndianToU32(serialized);
      var serialized := serialized[LENGTH_LEN..];
      if |serialized| < len as int then
        Failure("String Set Structured Data has too few bytes")
      else
        var nstring :- UTF8.Decode(serialized[..len]);
        var nattr := AttributeValue.SS(resultSet.val.SS + [nstring]);
        DeserializeStringSet(serialized[len..], remainingCount-1, origSerializedSize, AttrValueAndLength(nattr, resultSet.len + len + LENGTH_LEN))
  }

  // Bytes to Number Set
  function method {:tailrecursion} {:vcs_split_on_every_assert} {:opaque} DeserializeNumberSet(
    serialized : seq<uint8>, 
    remainingCount : nat, 
    origSerializedSize : nat, 
    resultSet : AttrValueAndLength) 
    : (ret : Result<AttrValueAndLength, string>)
    requires resultSet.val.NS?
    ensures ret.Success? ==> ret.value.val.NS?
    requires |serialized| + resultSet.len == origSerializedSize
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
      var len :- BigEndianToU32(serialized);
      var serialized := serialized[LENGTH_LEN..];
      if |serialized| < len as int then
        Failure("Number Set Structured Data has too few bytes")
      else
        var nstring :- UTF8.Decode(serialized[..len]);
        var nattr := AttributeValue.NS(resultSet.val.NS + [nstring]);
        DeserializeNumberSet(serialized[len..], remainingCount-1, origSerializedSize, AttrValueAndLength(nattr, resultSet.len + len + LENGTH_LEN))
  }
  
  // Bytes to List
  // Can't be {:tailrecursion} because it calls BytesToAttr which might again call DeserializeList
  function method {:vcs_split_on_every_assert} {:opaque} DeserializeList(
    serialized : seq<uint8>, 
    remainingCount : nat, 
    origSerializedSize : nat, 
    resultList : AttrValueAndLength)
    : (ret : Result<AttrValueAndLength, string>)
    requires resultList.val.L?
    ensures ret.Success? ==> ret.value.val.L?
    requires |serialized| + resultList.len == origSerializedSize
    ensures ret.Success? ==> ret.value.len <= origSerializedSize
    decreases |serialized|
  {
    if remainingCount == 0 then
      Success(resultList)
    else if |serialized| < 6 then
      Failure("Out of bytes reading Type of List element")
    else
      var TerminalTypeId := serialized[0..2];
      var serialized := serialized[2..];
      var len :- BigEndianToU32(serialized);
      var serialized := serialized[LENGTH_LEN..];
      if |serialized| < len then
        Failure("Out of bytes reading Content of List element")
      else
        var nval :- BytesToAttr(serialized[..len], TerminalTypeId, false);
        var nattr := AttributeValue.L(resultList.val.L + [nval.val]);
        DeserializeList(serialized[len..], remainingCount-1, origSerializedSize, AttrValueAndLength(nattr, resultList.len + len + 6))
  }

  // Bytes to Map
  // Can't be {:tailrecursion} because it calls BytesToAttr which might again call DeserializeMap
  function method {:vcs_split_on_every_assert} {:opaque} DeserializeMap(
    serialized : seq<uint8>,
    remainingCount : nat,
    origSerializedSize : nat,
    resultMap : AttrValueAndLength)
    : (ret : Result<AttrValueAndLength, string>)
    requires resultMap.val.M?
    ensures ret.Success? ==> ret.value.val.M?
    requires |serialized| + resultMap.len == origSerializedSize
    ensures ret.Success? ==> ret.value.len <= origSerializedSize
    decreases |serialized|
  {
    if remainingCount == 0 then
      Success(resultMap)
    else
      // get typeId of key
      :- Need(6 <= |serialized|, "Out of bytes reading Map Key");
      var TerminalTypeId_key := serialized[0..2];
      :- Need(TerminalTypeId_key == STRING, "Key of Map is not String");
      var serialized := serialized[2..];

      // get key
      var len :- BigEndianToU32(serialized);
      var serialized := serialized[LENGTH_LEN..];
      :- Need(len as int <= |serialized|, "Key of Map of Structured Data has too few bytes");
      var key :- UTF8.Decode(serialized[..len]);
      var serialized := serialized[len..];

      // get typeId of value
      :- Need(2 <= |serialized|, "Out of bytes reading Map Value");
      :- Need(IsValid_AttributeName(key), "Key is not valid AttributeName");
      var TerminalTypeId_value := serialized[0..2];
      var serialized := serialized[2..];

      // get value and construct result
      var nval :- BytesToAttr(serialized, TerminalTypeId_value, true);

      //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#key-value-pair-entries
      //# This sequence MUST NOT contain duplicate [Map Keys](#map-key).

      //= specification/dynamodb-encryption-client/ddb-item-conversion.md#duplicates
      //# - Conversion from a Structured Data Map MUST fail if it has duplicate keys
      :- Need(key !in resultMap.val.M, "Duplicate key in map.");
      var nattr := AttributeValue.M(resultMap.val.M[key := nval.val]);
      DeserializeMap(serialized[nval.len..], remainingCount-1, origSerializedSize, AttrValueAndLength(nattr, resultMap.len + nval.len + 8 + len))
  }
  
  // Bytes to AttributeValue
  // Can't be {:tailrecursion} because it calls DeserializeList and DeserializeMap which then call BytesToAttr
  function method {:vcs_split_on_every_assert} {:opaque} BytesToAttr(value : seq<uint8>, typeId : TerminalTypeId, hasLen : bool) : (ret : Result<AttrValueAndLength, string>)
    ensures ret.Success? ==> ret.value.len <= |value|
    decreases |value|
  {
    var len :- if hasLen then
        if |value| < LENGTH_LEN then
          Failure("Out of bytes reading length")
        else
          BigEndianToU32(value)
      else
        Success(|value|);
    var value := if hasLen then value[LENGTH_LEN..] else value;
    var lengthBytes := if hasLen then LENGTH_LEN else 0;

    if |value| < len then
      Failure("Structured Data has too few bytes")

    else if typeId == NULL then
      if len != 0 then
        Failure("NULL type did not have length zero")
      else
        // DynamoDB includes a boolean with the NULL
        // We pick true because it appears that the server rejects NULL(false)
        // NOTE : if you start with NULL(false), Decode(Encode()) will produce NULL(true)
        // and so round-trip identity is NOT preserved
        Success(AttrValueAndLength(AttributeValue.NULL(true), lengthBytes))

    else if typeId == STRING then
      var str :- UTF8.Decode(value[..len]);
      Success(AttrValueAndLength(AttributeValue.S(str), len+lengthBytes))

    else if typeId == NUMBER then
      var str :- UTF8.Decode(value[..len]);
      Success(AttrValueAndLength(AttributeValue.N(str), len+lengthBytes))

    else if typeId == BINARY then
      Success(AttrValueAndLength(AttributeValue.B(value[..len]), len+lengthBytes))

    else if typeId == BOOLEAN then
      if len != BOOL_LEN then
        Failure("Boolean Structured Data has more than one byte")
      else if value[0] == 0x00 then
        Success(AttrValueAndLength(AttributeValue.BOOL(false), BOOL_LEN+lengthBytes))
      else if value[0] == 0x01 then
        Success(AttrValueAndLength(AttributeValue.BOOL(true), BOOL_LEN+lengthBytes))
      else
        Failure("Boolean Structured Data had inappropriate value")

    else if typeId == STRING_SET then
      if |value| < LENGTH_LEN then
        Failure("String Set Structured Data has less than LENGTH_LEN bytes")
      else
        var len :- BigEndianToU32(value);
        var value := value[LENGTH_LEN..];
        DeserializeStringSet(value, len, |value| + LENGTH_LEN + lengthBytes, AttrValueAndLength(AttributeValue.SS([]), LENGTH_LEN+lengthBytes))

    else if typeId == NUMBER_SET then
      if |value| < LENGTH_LEN then
        Failure("Number Set Structured Data has less than 4 bytes")
      else
        var len :- BigEndianToU32(value);
        var value := value[LENGTH_LEN..];
        DeserializeNumberSet(value, len, |value| + LENGTH_LEN + lengthBytes, AttrValueAndLength(AttributeValue.NS([]), LENGTH_LEN + lengthBytes))

    else if typeId == BINARY_SET then
      if |value| < LENGTH_LEN then
        Failure("Binary Set Structured Data has less than LENGTH_LEN bytes")
      else
        var len :- BigEndianToU32(value);
        var value := value[LENGTH_LEN..];
        DeserializeBinarySet(value, len, |value| + LENGTH_LEN + lengthBytes, AttrValueAndLength(AttributeValue.BS([]), LENGTH_LEN + lengthBytes))

    else if typeId == MAP then
      if |value| < LENGTH_LEN then
        Failure("List Structured Data has less than 4 bytes")
      else
        var len :- BigEndianToU32(value);
        var value := value[LENGTH_LEN..];
        DeserializeMap(value, len, |value| + LENGTH_LEN + lengthBytes,  AttrValueAndLength(AttributeValue.M(map[]), LENGTH_LEN + lengthBytes))

    else if typeId == LIST then
      if |value| < LENGTH_LEN then
        Failure("List Structured Data has less than 4 bytes")
      else
        var len :- BigEndianToU32(value);
        var value := value[LENGTH_LEN..];
        DeserializeList(value, len, |value| + LENGTH_LEN + lengthBytes, AttrValueAndLength(AttributeValue.L([]), LENGTH_LEN + lengthBytes))

    else
      Failure("Unsupported TerminalTypeId")
  
  }

  function method FlattenValueMap<X,Y>(m : map<X, Result<Y,string>>): map<X,Y> {
    map kv <- m.Items | kv.1.Success? :: kv.0 := kv.1.value
  }

  function method FlattenErrors<X,Y>(m : map<X, Result<Y,string>>): set<string> {
    set k <- m.Values | k.Failure? :: k.error
  }

  lemma OneBadResult<X,Y>(m : map<X, Result<Y,string>>)
    requires ! forall v <- m.Values :: v.Success?
    ensures exists v <- m.Values :: v.Failure?
    ensures |FlattenErrors(m)| > 0
  {
    assert exists v <- m.Values :: v.Failure?;
    var errors := FlattenErrors(m);
    assert exists v :: v in m.Values && v.Failure? && (v.error in errors);
  }

  lemma MapKeysMatchItems<X,Y>(m : map<X,Y>)
    ensures forall k :: k in m.Keys ==> (k, m[k]) in m.Items
  {}

  lemma OneBadKey<X,Y>(s : map<X,Y>, bad : set<X>, f : X -> bool)
    requires !forall k <- s.Keys :: f(k)
    requires bad == set k <- s.Keys | !f(k) :: k;
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
    if forall v <- m.Values :: v.Success? then
      var result := FlattenValueMap(m);
      MapKeysMatchItems(m);
      Success(result)
    else
      OneBadResult(m);
      var badValues := FlattenErrors(m);
      assert(|badValues| > 0);
      var badValueSeq := SetToOrderedSequence(badValues, CharLess);
      Failure(Join(badValueSeq, "\n"))
  }
}
