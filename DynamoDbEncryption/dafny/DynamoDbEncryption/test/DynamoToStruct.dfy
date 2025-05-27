// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDbEncryptionSdkDynamoDbTypes.dfy"
include "../../DynamoDbEncryption/src/DynamoToStruct.dfy"

module DynamoToStructTest {

  import opened DynamoToStruct
  import opened Wrappers
  import opened ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import opened StandardLibrary.UInt
  import opened DynamoDbEncryptionUtil
  import SE = StructuredEncryptionUtil

  method DoFail(data : seq<uint8>, typeId : TerminalTypeId)
  {
    var data := StructuredDataTerminal(value := data, typeId := typeId);
    var result := StructuredToAttr(data);
    if !result.Failure? {
      print "\nStructuredToAttr should have failed with this data : ", data, "\n";
    }
    expect result.Failure?;
  }
  method DoSucceed(data : seq<uint8>, typeId : TerminalTypeId, pos : nat)
  {
    var data := StructuredDataTerminal(value := data, typeId := typeId);
    var result := StructuredToAttr(data);
    if !result.Success? {
      print "\nUnexpected failure of StructuredToAttr : (", pos, ") : ", result, "\n";
    }
    expect result.Success?;
  }

  method {:test} TestZeroBytes() {
    DoSucceed([], SE.NULL, 1);
    DoSucceed([], SE.STRING, 2);
    DoSucceed([], SE.NUMBER, 3);
    DoSucceed([], SE.BINARY, 4);
    DoFail([], SE.BOOLEAN);
    DoFail([], SE.STRING_SET);
    DoFail([], SE.NUMBER_SET);
    DoFail([], SE.BINARY_SET);
    DoFail([], SE.MAP);
    DoFail([], SE.LIST);
  }

  const k := 'k' as uint8
  const e := 'e' as uint8
  const y := 'y' as uint8
  const A := 'A' as uint8
  const B := 'B' as uint8
  const C := 'C' as uint8
  const D := 'D' as uint8

  method {:test} TestBadType() {
    DoSucceed([0,0,0,1, 0,0, 0,0,0,0], SE.LIST, 5);
    DoFail   ([0,0,0,1, 3,1, 0,0,0,0], SE.LIST);
  }

  method {:test} TestBadLengthList() {
    DoFail   ([0,0,0,1, 0,3, 0,0,0,2, 1], SE.LIST);
    DoSucceed([0,0,0,1, 0xff,0xff, 0,0,0,2, 1,2], SE.LIST, 6);
    DoFail   ([0,0,0,1, 0,3, 0,0,0,2, 1,2,3], SE.LIST);
  }

  method {:test} TestBadLengthMap() {
    DoFail([0,0,0,1, 0,1, 0,0,0,4, k,e,y,A, 0,3, 0,0,0,5, 1,2,3,4], SE.MAP);
    DoSucceed([0,0,0,1, 0,1, 0,0,0,4, k,e,y,A, 0xff,0xff, 0,0,0,5, 1,2,3,4,5], SE.MAP, 7);
    DoFail([0,0,0,1, 0,1, 0,0,0,4, k,e,y,A, 0,3, 0,0,0,5, 1,2,3,4,5,6], SE.MAP);
  }

  method {:test} TestBadDupKeys() {
    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#key-value-pair-entries
    //= type=test
    //# This sequence MUST NOT contain duplicate [Map Keys](#map-key).

    //= specification/dynamodb-encryption-client/ddb-item-conversion.md#duplicates
    //= type=test
    //# - Conversion from a Structured Data Map MUST fail if it has duplicate keys
    DoSucceed([0,0,0,2, 0,1, 0,0,0,4, k,e,y,A, 0xff,0xff, 0,0,0,5, 1,2,3,4,5, 0,1, 0,0,0,4, k,e,y,B, 0xff,0xff, 0,0,0,5, 1,2,3,4,5], SE.MAP, 8);
    DoFail   ([0,0,0,2, 0,1, 0,0,0,4, k,e,y,A, 0xff,0xff, 0,0,0,5, 1,2,3,4,5, 0,1, 0,0,0,4, k,e,y,A, 0xff,0xff, 0,0,0,5, 1,2,3,4,5], SE.MAP);

    DoSucceed([0,0,0,2, 0,0,0,3, 49,50,51, 0,0,0,3, 52,53,54], SE.BINARY_SET, 9);
    DoFail   ([0,0,0,2, 0,0,0,3, 49,50,51, 0,0,0,3, 49,50,51], SE.BINARY_SET);

    DoSucceed([0,0,0,2, 0,0,0,3, 49,50,51, 0,0,0,3, 52,53,54], SE.NUMBER_SET, 10);
    DoFail   ([0,0,0,2, 0,0,0,3, 49,50,51, 0,0,0,3, 49,50,51], SE.NUMBER_SET);

    DoSucceed([0,0,0,2, 0,0,0,3, 49,50,51, 0,0,0,3, 52,53,54], SE.STRING_SET, 11);
    DoFail   ([0,0,0,2, 0,0,0,3, 49,50,51, 0,0,0,3, 49,50,51], SE.STRING_SET);
  }

  // Split because verification timed out
  method {:test} {:vcs_split_on_every_assert} TestEncode2() {
    var stringValue := AttributeValue.S("abc");
    var encodedStringData := StructuredDataTerminal(value := [97,98,99], typeId := [0,1]);
    var stringStruct := AttrToStructured(stringValue);
    expect stringStruct.Success?;
    expect stringStruct.value == encodedStringData;

    var newStringValue := StructuredToAttr(encodedStringData);
    expect newStringValue.Success?;
    expect newStringValue.value == stringValue;

    var numberValue := AttributeValue.N("123");
    var encodedNumberData := StructuredDataTerminal(value := [49,50,51], typeId := [0,2]);
    var numberStruct := AttrToStructured(numberValue);
    expect numberStruct.Success?;
    expect numberStruct.value == encodedNumberData;

    var newNumberValue := StructuredToAttr(encodedNumberData);
    expect newNumberValue.Success?;
    expect newNumberValue.value == numberValue;

    var numberSetValue := AttributeValue.NS(["123","45"]);
    var encodedNumberSetData := StructuredDataTerminal(value := [0,0,0,2, 0,0,0,3, 49,50,51, 0,0,0,2, 52,53], typeId := [1,2]);
    var numberSetStruct := AttrToStructured(numberSetValue);
    expect numberSetStruct.Success?;
    expect numberSetStruct.value == encodedNumberSetData;

    var newNumberSetValue := StructuredToAttr(encodedNumberSetData);
    expect newNumberSetValue.Success?;
    expect newNumberSetValue.value == numberSetValue;

    var stringSetValue := AttributeValue.SS(["abc","de"]);
    var encodedStringSetData := StructuredDataTerminal(value := [0,0,0,2, 0,0,0,3, 97,98,99, 0,0,0,2, 100,101], typeId := [1,1]);
    var stringSetStruct := AttrToStructured(stringSetValue);
    expect stringSetStruct.Success?;
    expect stringSetStruct.value == encodedStringSetData;

    var newStringSetValue := StructuredToAttr(encodedStringSetData);
    expect newStringSetValue.Success?;
    expect newStringSetValue.value == stringSetValue;

    var binarySetValue := AttributeValue.BS([[1,2,3],[4,5]]);
    var encodedBinarySetData := StructuredDataTerminal(value := [0,0,0,2, 0,0,0,3, 1,2,3, 0,0,0,2, 4,5], typeId := [1,0xff]);
    var binarySetStruct := AttrToStructured(binarySetValue);
    expect binarySetStruct.Success?;
    expect binarySetStruct.value == encodedBinarySetData;

    var newBinarySetValue := StructuredToAttr(encodedBinarySetData);
    expect newBinarySetValue.Success?;
    expect newBinarySetValue.value == binarySetValue;
  }

  method {:test} TestEncode() {
    var binaryValue := AttributeValue.B([1,2,3,4,5]);
    var encodedBinaryData := StructuredDataTerminal(value := [1,2,3,4,5], typeId := [0xff,0xff]);
    var binaryStruct := AttrToStructured(binaryValue);
    expect binaryStruct.Success?;
    expect binaryStruct.value == encodedBinaryData;

    var newBinaryValue := StructuredToAttr(encodedBinaryData);
    expect newBinaryValue.Success?;
    expect newBinaryValue.value == binaryValue;

    var nullValue := AttributeValue.NULL(true);
    var encodedNullData := StructuredDataTerminal(value := [], typeId := [0,0]);
    var nullStruct := AttrToStructured(nullValue);
    expect nullStruct.Success?;
    expect nullStruct.value == encodedNullData;

    var newNullValue := StructuredToAttr(nullStruct.value);
    expect newNullValue.Success?;
    expect newNullValue.value == nullValue;

    var boolValue := AttributeValue.BOOL(false);
    var encodedBoolData := StructuredDataTerminal(value := [0], typeId := [0,4]);
    var boolStruct := AttrToStructured(boolValue);
    expect boolStruct.Success?;
    expect boolStruct.value == encodedBoolData;

    var newBoolValue := StructuredToAttr(boolStruct.value);
    expect newBoolValue.Success?;
    expect newBoolValue.value == boolValue;

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#list-entries
    //= type=test
    //# Each list entry in the sequence MUST be serialized as:
    //# | Field             | Length                     |
    //# | ----------------- | -------------------------- |
    //# | List Entry Type   | 2                          |
    //# | List Entry Length | 4                          |
    //# | List Entry Value  | Variable. Equal to Length. |

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#list-entries
    //= type=test
    //# The order of these serialized list entries MUST match
    //# the order of the entries in the original list.

    // for list-entry-length see also TestBadLengthList() above
    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#list-entry-length
    //= type=test
    //# List Entry Length MUST be a big-endian unsigned integer
    //# equal to the length of [List Entry Value](#list-entry-value).

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#list-entry-type
    //= type=test
    //# List Entry Type MUST be the [Type ID](#type-id) of the type of [List Entry Value](#list-entry-value).

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#list-entry-value
    //= type=test
    //# A List MAY hold any DynamoDB Attribute Value data type,
    //# and MAY hold values of different types.
    var listValue := AttributeValue.L([binaryValue, nullValue, boolValue]);
    var encodedListData := StructuredDataTerminal(value := [0,0,0,3, 0xff,0xff, 0,0,0,5, 1,2,3,4,5, 0,0, 0,0,0,0, 0,4, 0,0,0,1, 0], typeId := [3,0]);
    var listStruct := AttrToStructured(listValue);
    expect listStruct.Success?;
    expect listStruct.value == encodedListData;

    var newListValue := StructuredToAttr(listStruct.value);
    expect newListValue.Success?;
    expect newListValue.value == listValue;

    var mapValue := AttributeValue.M(map["keyA" := binaryValue, "keyB" := nullValue, "keyC" := boolValue, "keyD" := listValue]);
    var k := 'k' as uint8;
    var e := 'e' as uint8;
    var y := 'y' as uint8;
    var A := 'A' as uint8;
    var B := 'B' as uint8;
    var C := 'C' as uint8;
    var D := 'D' as uint8;

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#key-value-pair-entries
    //= type=test
    //# Each key-value pair MUST be serialized as:
    //# | Field        | Length   |
    //# | ------------ | -------- |
    //# | Key Type     | 2        |
    //# | Key Length   | 4        |
    //# | Map Key      | Variable |
    //# | Value Type   | 2        |
    //# | Value Length | 4        |
    //# | Map Value    | Variable |

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#value-type
    //= type=test
    //# Value Type MUST be the [Type ID](#type-id) of the type of [Map Value](#map-value).

    // for value-length see also TestBadLengthMap() above
    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#value-length
    //= type=test
    //# Value Length MUST be a big-endian unsigned integer
    //# equal to the length of [Map Value](#map-value).

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#map-value
    //= type=test
    //# Map Value MUST be a [Value](#value).

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#map-value
    //= type=test
    //# A Map MAY hold any DynamoDB Attribute Value data type,
    //# and MAY hold values of different types.
    var encodedMapData := StructuredDataTerminal(
      value := [
        0,0,0,4,
        0,1, 0,0,0,4, k,e,y,A, 0xff,0xff, 0,0,0,5, 1,2,3,4,5,
        0,1, 0,0,0,4, k,e,y,B, 0,0, 0,0,0,0,
        0,1, 0,0,0,4, k,e,y,C, 0,4, 0,0,0,1, 0,
        0,1, 0,0,0,4, k,e,y,D, 3,0, 0,0,0,28, 0,0,0,3, 0xff,0xff, 0,0,0,5, 1,2,3,4,5, 0,0, 0,0,0,0, 0,4, 0,0,0,1, 0
      ],
      typeId := [2,0]);
    var mapStruct := AttrToStructured(mapValue);
    expect mapStruct.Success?;
    expect mapStruct.value == encodedMapData;

    var newMapValue := StructuredToAttr(mapStruct.value);
    expect newMapValue.Success?;
    expect newMapValue.value == mapValue;
  }

  method {:test} TestNormalizeNAttr() {
    var numberValue := AttributeValue.N("000123.000");
    var encodedNumberData := StructuredDataTerminal(value := [49,50,51], typeId := [0,2]);
    var numberStruct := AttrToStructured(numberValue);
    expect numberStruct.Success?;
    expect numberStruct.value == encodedNumberData;

    var newNumberValue := StructuredToAttr(encodedNumberData);
    expect newNumberValue.Success?;
    expect newNumberValue.value == AttributeValue.N("123");
  }

  method {:test} TestNormalizeNInSet() {
    var numberSetValue := AttributeValue.NS(["001.00"]);
    var encodedNumberSetData := StructuredDataTerminal(value := [0,0,0,1, 0,0,0,1, 49], typeId := [1,2]);
    var numberSetStruct := AttrToStructured(numberSetValue);
    expect numberSetStruct.Success?;
    expect numberSetStruct.value == encodedNumberSetData;

    var newNumberSetValue := StructuredToAttr(encodedNumberSetData);
    expect newNumberSetValue.Success?;
    expect newNumberSetValue.value == AttributeValue.NS(["1"]);
  }

  method {:test} TestNormalizeNInList() {
    var nValue := AttributeValue.N("001.00");
    var normalizedNValue := AttributeValue.N("1");

    var listValue := AttributeValue.L([nValue]);
    var encodedListData := StructuredDataTerminal(value := [
                                                    0,0,0,1, // 1 member in list
                                                    0,2, 0,0,0,1, 49 // 1st member is N("1")
                                                  ],
                                                  typeId := [3,0]);
    var listStruct := AttrToStructured(listValue);
    expect listStruct.Success?;
    expect listStruct.value == encodedListData;

    var newListValue := StructuredToAttr(listStruct.value);
    expect newListValue.Success?;
    expect newListValue.value == AttributeValue.L([normalizedNValue]);
  }

  method {:test} TestNormalizeNInMap() {
    var nValue := AttributeValue.N("001.00");
    var normalizedNValue := AttributeValue.N("1");

    var mapValue := AttributeValue.M(map["keyA" := nValue]);
    var k := 'k' as uint8;
    var e := 'e' as uint8;
    var y := 'y' as uint8;
    var A := 'A' as uint8;

    var encodedMapData := StructuredDataTerminal(
      value := [
        0,0,0,1, // there is 1 entry in the map
        0,1, 0,0,0,4, k,e,y,A, // 1st entry's key
        0,2, 0,0,0,1, // 1st entry's value is a N and is 1 byte long
        49 // "1"
      ],
      typeId := [2,0]);

    var mapStruct := AttrToStructured(mapValue);
    expect mapStruct.Success?;
    expect mapStruct.value == encodedMapData;

    var newMapValue := StructuredToAttr(mapStruct.value);
    expect newMapValue.Success?;
    expect newMapValue.value == AttributeValue.M(map["keyA" := normalizedNValue]);
  }

  //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#set-entries
  //= type=test
  //# Entries in a Number Set MUST be ordered in ascending [UTF-16 binary order](./string-ordering.md#utf-16-binary-order).
  method {:test} TestSortNSAttr() {
    var numberSetValue := AttributeValue.NS(["1","2","10"]);
    var encodedNumberSetData := StructuredDataTerminal(value := [0,0,0,3, 0,0,0,1, 49, 0,0,0,2, 49,48, 0,0,0,1, 50], typeId := [1,2]);
    var numberSetStruct := AttrToStructured(numberSetValue);
    expect numberSetStruct.Success?;
    expect numberSetStruct.value == encodedNumberSetData;

    var newNumberSetValue := StructuredToAttr(encodedNumberSetData);
    expect newNumberSetValue.Success?;
    expect newNumberSetValue.value == AttributeValue.NS(["1","10","2"]);
  }

  //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#set-entries
  //= type=test
  //# This ordering MUST be applied after normalization of the number value.
  method {:test} TestSortNSAfterNormalize() {
    var numberSetValue := AttributeValue.NS(["1","02","10"]);
    var encodedNumberSetData := StructuredDataTerminal(value := [0,0,0,3, 0,0,0,1, 49, 0,0,0,2, 49,48, 0,0,0,1, 50], typeId := [1,2]);
    var numberSetStruct := AttrToStructured(numberSetValue);
    expect numberSetStruct.Success?;
    expect numberSetStruct.value == encodedNumberSetData;

    var newNumberSetValue := StructuredToAttr(encodedNumberSetData);
    expect newNumberSetValue.Success?;
    expect newNumberSetValue.value == AttributeValue.NS(["1","10","2"]);
  }

  //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#set-entries
  //= type=test
  //# Entries in a String Set MUST be ordered in ascending [UTF-16 binary order](./string-ordering.md#utf-16-binary-order).
  method {:test} TestSortSSAttr() {
    // "\ud800\udc02" <-> "𐀂"
    var stringSetValue := AttributeValue.SS(["&","｡","\ud800\udc02"]);
    // Note that string values are UTF-8 encoded, but sorted by UTF-16 encoding.
    var encodedStringSetData := StructuredDataTerminal(value := [
                                                         0,0,0,3, // 3 entries in set
                                                         0,0,0,1, // 1st entry is 1 byte
                                                         0x26, // "&" in UTF-8 encoding
                                                         0,0,0,4, // 2nd entry is 4 bytes
                                                         0xF0,0x90,0x80,0x82, // "\ud800\udc02" in UTF-8 encoding
                                                         0,0,0,3, // 3rd entry is 3 bytes
                                                         0xEF,0xBD,0xA1 // "｡" in UTF-8 encoding
                                                       ],
                                                       typeId := [1,1]
    );
    var stringSetStruct := AttrToStructured(stringSetValue);
    expect stringSetStruct.Success?;
    expect stringSetStruct.value == encodedStringSetData;

    var newStringSetValue := StructuredToAttr(encodedStringSetData);
    expect newStringSetValue.Success?;
    // "\ud800\udc02" <-> "𐀂"
    expect newStringSetValue.value == AttributeValue.SS(["&","\ud800\udc02","｡"]);
  }

  //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#set-entries
  //= type=test
  //# Entries in a Binary Set MUST be ordered lexicographically by their underlying bytes in ascending order.
  method {:test} TestSortBSAttr() {
    var binarySetValue := AttributeValue.BS([[1],[2],[1,0]]);
    var encodedBinarySetData := StructuredDataTerminal(value := [0,0,0,3, 0,0,0,1, 1, 0,0,0,2, 1,0, 0,0,0,1, 2], typeId := [1,0xff]);
    var binarySetStruct := AttrToStructured(binarySetValue);
    expect binarySetStruct.Success?;
    expect binarySetStruct.value == encodedBinarySetData;

    var newBinarySetValue := StructuredToAttr(encodedBinarySetData);
    expect newBinarySetValue.Success?;
    expect newBinarySetValue.value == AttributeValue.BS([[1],[1,0],[2]]);
  }

  method {:test} TestSetsInListAreSorted() {
    var nSetValue := AttributeValue.NS(["2","1","10"]);
    // "\ud800\udc02" <-> "𐀂"
    var sSetValue := AttributeValue.SS(["&","｡","\ud800\udc02"]);
    var bSetValue := AttributeValue.BS([[1,0],[1],[2]]);

    var sortedNSetValue := AttributeValue.NS(["1","10","2"]);
    // "\ud800\udc02" <-> "𐀂"
    var sortedSSetValue := AttributeValue.SS(["&","\ud800\udc02","｡"]);
    var sortedBSetValue := AttributeValue.BS([[1],[1,0],[2]]);

    var listValue := AttributeValue.L([nSetValue, sSetValue, bSetValue]);
    var encodedListData := StructuredDataTerminal(value := [
                                                    0,0,0,3, // 3 members in list
                                                    1,2, 0,0,0,20, // 1st member is a NS and is 20 bytes long
                                                    0,0,0,3, 0,0,0,1, 49, 0,0,0,2, 49,48, 0,0,0,1, 50, // NS
                                                    1,1, 0,0,0,24, // 2nd member is a SS and is 24 bytes long
                                                    0,0,0,3, 0,0,0,1, 0x26, 0,0,0,4, 0xF0,0x90,0x80,0x82, 0,0,0,3, 0xEF,0xBD,0xA1, // SS
                                                    1,0xFF, 0,0,0,20, // 3rd member is a BS and is 20 bytes long
                                                    0,0,0,3, 0,0,0,1, 1, 0,0,0,2, 1,0, 0,0,0,1, 2 // BS
                                                  ],
                                                  typeId := [3,0]);
    var listStruct := AttrToStructured(listValue);
    expect listStruct.Success?;
    expect listStruct.value == encodedListData;

    var newListValue := StructuredToAttr(listStruct.value);
    expect newListValue.Success?;
    expect newListValue.value == AttributeValue.L([sortedNSetValue, sortedSSetValue, sortedBSetValue]);
  }

  method {:test} TestSetsInMapAreSorted() {
    var nSetValue := AttributeValue.NS(["2","1","10"]);
    // "\ud800\udc02" <-> "𐀂"
    var sSetValue := AttributeValue.SS(["&","｡","\ud800\udc02"]);
    var bSetValue := AttributeValue.BS([[1,0],[1],[2]]);

    var sortedNSetValue := AttributeValue.NS(["1","10","2"]);
    // "\ud800\udc02" <-> "𐀂"
    var sortedSSetValue := AttributeValue.SS(["&","\ud800\udc02","｡"]);
    var sortedBSetValue := AttributeValue.BS([[1],[1,0],[2]]);

    var mapValue := AttributeValue.M(map["keyA" := sSetValue, "keyB" := nSetValue, "keyC" := bSetValue]);
    var k := 'k' as uint8;
    var e := 'e' as uint8;
    var y := 'y' as uint8;
    var A := 'A' as uint8;
    var B := 'B' as uint8;
    var C := 'C' as uint8;

    var encodedMapData := StructuredDataTerminal(
      value := [
        0,0,0,3, // there are 3 entries in the map
        0,1, 0,0,0,4, k,e,y,A, // 1st entry's key
        1,1, 0,0,0,24, // 1st entry's value is a SS and is 24 bytes long
        0,0,0,3, 0,0,0,1, 0x26, 0,0,0,4, 0xF0,0x90,0x80,0x82, 0,0,0,3, 0xEF,0xBD,0xA1, // SS
        0,1, 0,0,0,4, k,e,y,B, // 2nd entry's key
        1,2, 0,0,0,20, // 2nd entry's value is a NS and is 20 bytes long
        0,0,0,3, 0,0,0,1, 49, 0,0,0,2, 49,48, 0,0,0,1, 50, // NS
        0,1, 0,0,0,4, k,e,y,C, // 3rd entry's key
        1,0xFF, 0,0,0,20, // 3rd entry's value is a BS and is 20 bytes long
        0,0,0,3, 0,0,0,1, 1, 0,0,0,2, 1,0, 0,0,0,1, 2 // BS
      ],
      typeId := [2,0]);

    var mapStruct := AttrToStructured(mapValue);
    expect mapStruct.Success?;
    expect mapStruct.value == encodedMapData;

    var newMapValue := StructuredToAttr(mapStruct.value);
    expect newMapValue.Success?;
    expect newMapValue.value == AttributeValue.M(map["keyA" := sortedSSetValue, "keyB" := sortedNSetValue, "keyC" := sortedBSetValue]);
  }

  //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#key-value-pair-entries
  //= type=test
  //# Entries in a serialized Map MUST be ordered by key value,
  //# ordered in ascending [UTF-16 binary order](./string-ordering.md#utf-16-binary-order).
  method {:test} TestSortMapKeys() {
    var nullValue := AttributeValue.NULL(true);

    // "\ud800\udc02" <-> "𐀂"
    var mapValue := AttributeValue.M(map["&" := nullValue, "｡" := nullValue, "\ud800\udc02" := nullValue]);

    // Note that the string values are encoded as UTF-8, but are sorted according to UTF-16 encoding.
    var encodedMapData := StructuredDataTerminal(
      value := [
        0,0,0,3, // 3 entries
        0,1, 0,0,0,1, // 1st key is a string 1 byte long
        0x26, // "&" UTF-8 encoded
        0,0, 0,0,0,0, // null value
        0,1, 0,0,0,4, // 2nd key is a string 4 bytes long
        0xF0, 0x90, 0x80, 0x82, // "\ud800\udc02" UTF-8 encoded
        0,0, 0,0,0,0, // null value
        0,1, 0,0,0,3, // 3rd key is a string 3 bytes long
        0xEF, 0xBD, 0xA1, // "｡"
        0,0, 0,0,0,0 // null value
      ],
      typeId := [2,0]);
    var mapStruct := AttrToStructured(mapValue);
    expect mapStruct.Success?;
    expect mapStruct.value == encodedMapData;

    var newMapValue := StructuredToAttr(mapStruct.value);
    expect newMapValue.Success?;
    expect newMapValue.value == mapValue;
  }

  method {:test} TestRoundTrip() {
    // Note - set and number values are carefully pre-normalized.
    var val1 := AttributeValue.S("astring");
    var val2 := AttributeValue.N("12345");
    var val3 := AttributeValue.B([1,2,3,4,5]);
    var val4 := AttributeValue.BOOL(true);
    var val5 := AttributeValue.NULL(true);
    var val6 := AttributeValue.BS([[1,2,3,4,5],[2,3,4,5,6],[3,4,5,6,7]]);
    var val7 := AttributeValue.SS(["ab","cdef","ghijk"]);
    var val8 := AttributeValue.NS(["0", "1","234.567"]);

    var val9a := AttributeValue.L([val8, val7, val6]);
    var val9b := AttributeValue.L([val5, val4, val3]);
    var val9c := AttributeValue.L([val2, val1]);
    var val9 := AttributeValue.L([val9a, val9b, val9c]);
    var val10 := AttributeValue.M(map["key1" := val1, "key2" := val2, "key3" := val3, "key4" := val4, "key5" := val5, "key6" := val6, "key7" := val7, "key8" := val8, "key9" := val9]);

    var attrMap := map["key1" := val1, "key2" := val2, "key3" := val3, "key4" := val4, "key5" := val5, "key6" := val6, "key7" := val7, "key8" := val8, "key9" := val9, "key10" := val10];
    var struct :- expect ItemToStructured(attrMap);
    var nAttrMap :- expect StructuredToItem(struct);
    expect attrMap == nAttrMap;
  }

  method {:test} TestMaxDepth() {
    var value := AttributeValue.S("hello");
    for i := 0 to (MAX_STRUCTURE_DEPTH-1) {
      if i % 2 == 0 {
        value := AttributeValue.M(map["key" := value]);
      } else {
        value := AttributeValue.L([value]);
      }
    }
    var attrMap : AttributeMap := map["key1" := value];
    var struct :- expect ItemToStructured(attrMap);
    var nAttrMap :- expect StructuredToItem(struct);
    expect attrMap == nAttrMap;
  }

  method {:test} TestTooDeep() {
    var value := AttributeValue.S("hello");
    for i := 0 to MAX_STRUCTURE_DEPTH {
      if i % 2 == 0 {
        value := AttributeValue.M(map["key" := value]);
      } else {
        value := AttributeValue.L([value]);
      }
    }
    var attrMap : AttributeMap := map["key1" := value];
    var struct := ItemToStructured(attrMap);
    expect struct.Failure?;
    expect struct.error == E("Depth of attribute structure to serialize exceeds limit of 32");
  }
}
