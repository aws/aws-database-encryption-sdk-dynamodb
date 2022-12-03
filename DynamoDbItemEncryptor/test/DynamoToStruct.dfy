// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDynamoDbItemEncryptorTypes.dfy"
include "../src/DynamoToStruct.dfy"

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
    expect StructuredToAttr(sdata).Failure?;
  }
  method DoSucceed(data : seq<uint8>, typeId : TerminalTypeId)
  {
    var data := StructuredDataTerminal(value := data, typeId := typeId);
    var sdata := StructuredData(content := Terminal(data), attributes := None);
    expect StructuredToAttr(sdata).Success?;
  }

  method {:test} {:vcs_split_on_every_assert} TestZeroBytes() {
    DoSucceed([], STRING);
    DoSucceed([], NUMBER);
    DoSucceed([], BINARY);
    DoFail([], BOOLEAN);
    DoFail([], STRING_SET);
    DoFail([], NUMBER_SET);
    DoFail([], BINARY_SET);
    DoFail([], MAP);
    DoFail([], LIST);
  }

  method {:test} {:vcs_split_on_every_assert} TestBadType() {
    DoSucceed([0,0,0,1, 0,0, 0,0,0,0], LIST);
    DoFail([0,0,0,1, 3,1, 0,0,0,0], LIST);
  }

  method {:test} {:vcs_split_on_every_assert} TestEncode() {
    var binaryValue := AttributeValue.B([1,2,3,4,5]);
    var encodedBinaryData := StructuredDataTerminal(value := [1,2,3,4,5], typeId := [0,3]);
    var encodedBinaryValue := StructuredData(content := Terminal(encodedBinaryData), attributes := None);
    var binaryStruct := AttrToStructured(binaryValue);
    expect binaryStruct.Success?;
    expect binaryStruct.value == encodedBinaryValue;

    var newBinaryValue := StructuredToAttr(encodedBinaryValue);
    expect newBinaryValue.Success?;
    expect newBinaryValue.value == binaryValue;

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#null
    //= type=test
    //# Null MUST be serialized as a zero-length byte string.
    var nullValue := AttributeValue.NULL(false);
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

    var listValue := AttributeValue.L([binaryValue, nullValue, boolValue]);
    var encodedListData := StructuredDataTerminal(value := [0,0,0,3, 0,3, 0,0,0,5, 1,2,3,4,5, 0,0, 0,0,0,0, 0,4, 0,0,0,1, 0], typeId := [3,0]);
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

    var encodedMapData := StructuredDataTerminal(value :=
      [0,0,0,4,
        0,1, 0,0,0,4, k,e,y,A, 0,3, 0,0,0,5, 1,2,3,4,5,
        0,1, 0,0,0,4, k,e,y,B, 0,0, 0,0,0,0,
        0,1, 0,0,0,4, k,e,y,C, 0,4, 0,0,0,1, 0,
        0,1, 0,0,0,4, k,e,y,D, 3,0, 0,0,0,28, 0,0,0,3, 0,3, 0,0,0,5, 1,2,3,4,5, 0,0, 0,0,0,0, 0,4, 0,0,0,1, 0],
    typeId := [2,0]);
    var encodedMapValue := StructuredData(content := Terminal(encodedMapData), attributes := None);
    var mapStruct := AttrToStructured(mapValue);
    expect mapStruct.Success?;
    expect mapStruct.value == encodedMapValue;

    var newMapValue := StructuredToAttr(mapStruct.value);
    expect newMapValue.Success?;
    expect newMapValue.value == mapValue;
}

  method {:test} {:vcs_split_on_every_assert} TestRoundTrip() {

    var val1 := AttributeValue.S("astring");
    var val2 := AttributeValue.N("12345");
    var val3 := AttributeValue.B([1,2,3,4,5]);
    var val4 := AttributeValue.BOOL(true);
    var val5 := AttributeValue.NULL(false);
    var val6 := AttributeValue.BS([[1,2,3,4,5],[2,3,4,5,6],[3,4,5,6,7]]);
    var val7 := AttributeValue.SS(["ab","cdef","ghijk"]);
    var val8 := AttributeValue.NS(["1","234.567","0"]);

    var val9a := AttributeValue.L([val8, val7, val6]);
    var val9b := AttributeValue.L([val5, val4, val3]);
    var val9c := AttributeValue.L([val2, val1]);
    var val9 := AttributeValue.L([val9a, val9b, val9c]);
    var val10 := AttributeValue.M(map["key1" := val1, "key2" := val2, "key3" := val3, "key4" := val4, "key5" := val5, "key6" := val6, "key7" := val7, "key8" := val8, "key9" := val9]);

    var attrMap := map["key1" := val1, "key2" := val2, "key3" := val3, "key4" := val4, "key5" := val5, "key6" := val6, "key7" := val7, "key8" := val8, "key9" := val9, "key10" := val10];
    var struct := ItemToStructured(attrMap);
    expect struct.Success?;
    var nAttrMap := StructuredToItem(struct.value);
    expect nAttrMap.Success?;
    expect attrMap == nAttrMap.value;
  }
}
