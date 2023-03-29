// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../../Model/AwsCryptographyDynamoDbEncryptionItemEncryptorTypes.dfy"
include "../../src/DynamoDbEncryption/DynamoToStruct.dfy"

module DynamoToStructTest {

  import opened DynamoToStruct
  import opened Wrappers
  import opened ComAmazonawsDynamodbTypes
  import opened AwsCryptographyStructuredEncryptionTypes
  import opened StandardLibrary.UInt

  method DoFail(data : seq<uint8>, typeId : TerminalTypeId)
  {
    var data := StructuredDataTerminal(value := data, typeId := typeId);
    var sdata := StructuredData(content := Terminal(data), attributes := None);
    var result := StructuredToAttr(sdata);
    if !result.Failure? {
      print "\nStructuredToAttr should have failed with this data : ", data, "\n";
    }
    expect result.Failure?;
  }
  method DoSucceed(data : seq<uint8>, typeId : TerminalTypeId, pos : nat)
  {
    var data := StructuredDataTerminal(value := data, typeId := typeId);
    var sdata := StructuredData(content := Terminal(data), attributes := None);
    var result := StructuredToAttr(sdata);
    if !result.Success? {
      print "\nUnexpected failure of StructuredToAttr : (", pos, ") : ", result, "\n";
    }
    expect result.Success?;
  }

  method {:test} TestZeroBytes() {
    DoSucceed([], DynamoToStruct.NULL, 1);
    DoSucceed([], STRING, 2);
    DoSucceed([], NUMBER, 3);
    DoSucceed([], BINARY, 4);
    DoFail([], BOOLEAN);
    DoFail([], STRING_SET);
    DoFail([], NUMBER_SET);
    DoFail([], BINARY_SET);
    DoFail([], MAP);
    DoFail([], LIST);
  }

    const k := 'k' as uint8;
    const e := 'e' as uint8;
    const y := 'y' as uint8;
    const A := 'A' as uint8;
    const B := 'B' as uint8;
    const C := 'C' as uint8;
    const D := 'D' as uint8;

  method {:test} TestBadType() {
    DoSucceed([0,0,0,1, 0,0, 0,0,0,0], LIST, 5);
    DoFail   ([0,0,0,1, 3,1, 0,0,0,0], LIST);
  }

  method {:test} TestBadLengthList() {
    DoFail   ([0,0,0,1, 0,3, 0,0,0,2, 1], LIST);
    DoSucceed([0,0,0,1, 0xff,0xff, 0,0,0,2, 1,2], LIST, 6);
    DoFail   ([0,0,0,1, 0,3, 0,0,0,2, 1,2,3], LIST);
  }

  method {:test} TestBadLengthMap() {
    DoFail([0,0,0,1, 0,1, 0,0,0,4, k,e,y,A, 0,3, 0,0,0,5, 1,2,3,4], MAP);
    DoSucceed([0,0,0,1, 0,1, 0,0,0,4, k,e,y,A, 0xff,0xff, 0,0,0,5, 1,2,3,4,5], MAP, 7);
    DoFail([0,0,0,1, 0,1, 0,0,0,4, k,e,y,A, 0,3, 0,0,0,5, 1,2,3,4,5,6], MAP);
  }

  method {:test} TestBadDupKeys() {
    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#key-value-pair-entries
    //= type=test
    //# This sequence MUST NOT contain duplicate [Map Keys](#map-key).

    //= specification/dynamodb-encryption-client/ddb-item-conversion.md#duplicates
    //= type=test
    //# - Conversion from a Structured Data Map MUST fail if it has duplicate keys
    DoSucceed([0,0,0,2, 0,1, 0,0,0,4, k,e,y,A, 0xff,0xff, 0,0,0,5, 1,2,3,4,5, 0,1, 0,0,0,4, k,e,y,B, 0xff,0xff, 0,0,0,5, 1,2,3,4,5], MAP, 8);
    DoFail   ([0,0,0,2, 0,1, 0,0,0,4, k,e,y,A, 0xff,0xff, 0,0,0,5, 1,2,3,4,5, 0,1, 0,0,0,4, k,e,y,A, 0xff,0xff, 0,0,0,5, 1,2,3,4,5], MAP);

    DoSucceed([0,0,0,2, 0,0,0,3, 49,50,51, 0,0,0,3, 52,53,54], BINARY_SET, 9);
    DoFail   ([0,0,0,2, 0,0,0,3, 49,50,51, 0,0,0,3, 49,50,51], BINARY_SET);

    DoSucceed([0,0,0,2, 0,0,0,3, 49,50,51, 0,0,0,3, 52,53,54], NUMBER_SET, 10);
    DoFail   ([0,0,0,2, 0,0,0,3, 49,50,51, 0,0,0,3, 49,50,51], NUMBER_SET);

    DoSucceed([0,0,0,2, 0,0,0,3, 49,50,51, 0,0,0,3, 52,53,54], STRING_SET, 11);
    DoFail   ([0,0,0,2, 0,0,0,3, 49,50,51, 0,0,0,3, 49,50,51], STRING_SET);
  }

  // Split because verification timed out
  method {:test} {:vcs_split_on_every_assert} TestEncode2() {
    var stringValue := AttributeValue.S("abc");
    var encodedStringData := StructuredDataTerminal(value := [97,98,99], typeId := [0,1]);
    var encodedStringValue := StructuredData(content := Terminal(encodedStringData), attributes := None);
    var stringStruct := AttrToStructured(stringValue);
    expect stringStruct.Success?;
    expect stringStruct.value == encodedStringValue;

    var newStringValue := StructuredToAttr(encodedStringValue);
    expect newStringValue.Success?;
    expect newStringValue.value == stringValue;

    var numberValue := AttributeValue.N("123");
    var encodedNumberData := StructuredDataTerminal(value := [49,50,51], typeId := [0,2]);
    var encodedNumberValue := StructuredData(content := Terminal(encodedNumberData), attributes := None);
    var numberStruct := AttrToStructured(numberValue);
    expect numberStruct.Success?;
    expect numberStruct.value == encodedNumberValue;

    var newNumberValue := StructuredToAttr(encodedNumberValue);
    expect newNumberValue.Success?;
    expect newNumberValue.value == numberValue;

    var numberSetValue := AttributeValue.NS(["123","45"]);
    var encodedNumberSetData := StructuredDataTerminal(value := [0,0,0,2, 0,0,0,3, 49,50,51, 0,0,0,2, 52,53], typeId := [1,2]);
    var encodedNumberSetValue := StructuredData(content := Terminal(encodedNumberSetData), attributes := None);
    var numberSetStruct := AttrToStructured(numberSetValue);
    expect numberSetStruct.Success?;
    expect numberSetStruct.value == encodedNumberSetValue;

    var newNumberSetValue := StructuredToAttr(encodedNumberSetValue);
    expect newNumberSetValue.Success?;
    expect newNumberSetValue.value == numberSetValue;

    var stringSetValue := AttributeValue.SS(["abc","de"]);
    var encodedStringSetData := StructuredDataTerminal(value := [0,0,0,2, 0,0,0,3, 97,98,99, 0,0,0,2, 100,101], typeId := [1,1]);
    var encodedStringSetValue := StructuredData(content := Terminal(encodedStringSetData), attributes := None);
    var stringSetStruct := AttrToStructured(stringSetValue);
    expect stringSetStruct.Success?;
    expect stringSetStruct.value == encodedStringSetValue;

    var newStringSetValue := StructuredToAttr(encodedStringSetValue);
    expect newStringSetValue.Success?;
    expect newStringSetValue.value == stringSetValue;

    var binarySetValue := AttributeValue.BS([[1,2,3],[4,5]]);
    var encodedBinarySetData := StructuredDataTerminal(value := [0,0,0,2, 0,0,0,3, 1,2,3, 0,0,0,2, 4,5], typeId := [1,0xff]);
    var encodedBinarySetValue := StructuredData(content := Terminal(encodedBinarySetData), attributes := None);
    var binarySetStruct := AttrToStructured(binarySetValue);
    expect binarySetStruct.Success?;
    expect binarySetStruct.value == encodedBinarySetValue;

    var newBinarySetValue := StructuredToAttr(encodedBinarySetValue);
    expect newBinarySetValue.Success?;
    expect newBinarySetValue.value == binarySetValue;
  }

  method {:test} TestEncode() {
    var binaryValue := AttributeValue.B([1,2,3,4,5]);
    var encodedBinaryData := StructuredDataTerminal(value := [1,2,3,4,5], typeId := [0xff,0xff]);
    var encodedBinaryValue := StructuredData(content := Terminal(encodedBinaryData), attributes := None);
    var binaryStruct := AttrToStructured(binaryValue);
    expect binaryStruct.Success?;
    expect binaryStruct.value == encodedBinaryValue;

    var newBinaryValue := StructuredToAttr(encodedBinaryValue);
    expect newBinaryValue.Success?;
    expect newBinaryValue.value == binaryValue;

    var nullValue := AttributeValue.NULL(true);
    var encodedNullData := StructuredDataTerminal(value := [], typeId := [0,0]);
    var encodedNullValue := StructuredData(content := Terminal(encodedNullData), attributes := None);
    var nullStruct := AttrToStructured(nullValue);
    expect nullStruct.Success?;
    expect nullStruct.value == encodedNullValue;

    var newNullValue := StructuredToAttr(nullStruct.value);
    expect newNullValue.Success?;
    expect newNullValue.value == nullValue;

    var boolValue := AttributeValue.BOOL(false);
    var encodedBoolData := StructuredDataTerminal(value := [0], typeId := [0,4]);
    var encodedBoolValue := StructuredData(content := Terminal(encodedBoolData), attributes := None);
    var boolStruct := AttrToStructured(boolValue);
    expect boolStruct.Success?;
    expect boolStruct.value == encodedBoolValue;

    var newBoolValue := StructuredToAttr(boolStruct.value);
    expect newBoolValue.Success?;
    expect newBoolValue.value == boolValue;

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#list-entries
    //= type=test
    //# Each list entry in the sequence MUST be serialized as:
    //# | Field                | Length                     |
    //# | -------------------- | -------------------------- |
    //# | List Entry Type      | 2                          |
    //# | List Entry Length    | 4                          |
    //# | List Entry Value     | Variable. Equal to Length. |

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
    var encodedListValue := StructuredData(content := Terminal(encodedListData), attributes := None);
    var listStruct := AttrToStructured(listValue);
    expect listStruct.Success?;
    expect listStruct.value == encodedListValue;

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
    var encodedMapData := StructuredDataTerminal(value :=
      [0,0,0,4,
        0,1, 0,0,0,4, k,e,y,A, 0xff,0xff, 0,0,0,5, 1,2,3,4,5,
        0,1, 0,0,0,4, k,e,y,B, 0,0, 0,0,0,0,
        0,1, 0,0,0,4, k,e,y,C, 0,4, 0,0,0,1, 0,
        0,1, 0,0,0,4, k,e,y,D, 3,0, 0,0,0,28, 0,0,0,3, 0xff,0xff, 0,0,0,5, 1,2,3,4,5, 0,0, 0,0,0,0, 0,4, 0,0,0,1, 0],
    typeId := [2,0]);
    var encodedMapValue := StructuredData(content := Terminal(encodedMapData), attributes := None);
    var mapStruct := AttrToStructured(mapValue);
    expect mapStruct.Success?;
    expect mapStruct.value == encodedMapValue;

    var newMapValue := StructuredToAttr(mapStruct.value);
    expect newMapValue.Success?;
    expect newMapValue.value == mapValue;
}

  //= specification/dynamodb-encryption-client/ddb-item-conversion.md#overview
  //= type=test
  //# The conversion from DDB Item to Structured Data must be lossless,
  //# meaning that converting a DDB Item to
  //# a Structured Data and back to a DDB Item again
  //# MUST result in the exact same DDB Item.
  method {:test} TestRoundTrip() {

    var val1 := AttributeValue.S("astring");
    var val2 := AttributeValue.N("12345");
    var val3 := AttributeValue.B([1,2,3,4,5]);
    var val4 := AttributeValue.BOOL(true);
    var val5 := AttributeValue.NULL(true);
    var val6 := AttributeValue.BS([[1,2,3,4,5],[2,3,4,5,6],[3,4,5,6,7]]);
    var val7 := AttributeValue.SS(["ab","cdef","ghijk"]);
    var val8 := AttributeValue.NS(["1","234.567","0"]);

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
}
