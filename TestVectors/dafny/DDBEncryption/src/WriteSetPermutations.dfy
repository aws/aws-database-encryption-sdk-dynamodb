// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDynamoDbEncryptionTypesWrapped.dfy"
include "CreateInterceptedDDBClient.dfy"
include "JsonItem.dfy"
include "Permute.dfy"

module {:options "-functionSyntax:4"} WriteSetPermutations {
  import opened JSON.Values
  import BoundedInts
  import JSON.API
  import FileIO
  import opened StandardLibrary.String
  import opened Permutations
  import Base64

  type Bytes = seq<BoundedInts.uint8>
  type BytesList = seq<Bytes>
  type StringList = seq<string>

  function GetConfigs() : JSON
  {
    Object([("AllSign",
             Object([("attributeActionsOnEncrypt",
             Object([
             ("RecNum", String("SIGN_ONLY")),
             ("StringSet", String("SIGN_ONLY")),
             ("NumberSet", String("SIGN_ONLY")),
             ("BinarySet", String("SIGN_ONLY"))
             ])
             )])),
            ("AllEncrypt",
             Object([("attributeActionsOnEncrypt",
             Object([
             ("RecNum", String("SIGN_ONLY")),
             ("StringSet", String("ENCRYPT_AND_SIGN")),
             ("NumberSet", String("ENCRYPT_AND_SIGN")),
             ("BinarySet", String("ENCRYPT_AND_SIGN"))
             ])
             )])
            )])
  }

  function {:tailrecursion} GetStringArray(str : StringList, acc : seq<JSON> := []) : JSON
  {
    if |str| == 0 then
      Array(acc)
    else
      GetStringArray(str[1..], acc + [String(str[0])])
  }

  function {:tailrecursion} EncodeStrings(bytes : BytesList, acc : seq<string> := []) : seq<string>
  {
    if |bytes| == 0 then
      acc
    else
      EncodeStrings(bytes[1..], acc + [Base64.Encode(bytes[0])])
  }

  function GetBinaryArray(bytes : BytesList) : JSON
  {
    var strs := EncodeStrings(bytes);
    GetStringArray(strs)
  }


  function {:opaque} GetRecord(recNum : int, str : StringList, num : StringList, bytes : BytesList) : JSON
  {
    var numStr := Base10Int2String(recNum);
    Object([
             ("RecNum", Object([("N", String(numStr))])),
             ("StringSet", Object([("SS", GetStringArray(str))])),
             ("NumberSet", Object([("NS", GetStringArray(num))])),
             ("BinarySet", Object([("BS", GetBinaryArray(bytes))]))
           ])
  }


  function {:opaque} {:tailrecursion} GetRecords2(
    recNum : int,
    str : seq<StringList>,
    num : seq<StringList>,
    bytes : seq<BytesList>,
    acc : seq<JSON> := []) : seq<JSON>
    decreases str
    decreases num
    decreases bytes
  {
    if |str| == 0 || |num| == 0 || |bytes| == 0 then
      acc
    else
      var newRec := GetRecord(recNum, str[0], num[0], bytes[0]);
      GetRecords2(recNum+1, str[1..], num[1..], bytes[1..], acc + [newRec])
  }

  method GetRecords() returns (result : seq<JSON>)
  {
    var recs : seq<JSON> := [];
    var recs1 := [GetRecord(200, ["aaa"], ["111"], [[1,2,3]])];

    var p2s := GeneratePermutations(["aaa", "bbb"]);
    var p2n := GeneratePermutations(["111", "222"]);
    var p2b := GeneratePermutations([[1,2,3], [2,3,4]]);
    var recs2 := GetRecords2(201, p2s, p2n, p2b);

    var p3s := GeneratePermutations(["aaa", "bbb", "ccc"]);
    var p3n := GeneratePermutations(["111", "222", "333"]);
    var p3b := GeneratePermutations([[1,2,3], [2,3,4], [3,4,5]]);
    var recs3 := GetRecords2(203, p3s, p3n, p3b);

    var p4s := GeneratePermutations(["aaa", "bbb", "ccc", "ddd"]);
    var p4n := GeneratePermutations(["111", "222", "333", "444"]);
    var p4b := GeneratePermutations([[1,2,3], [2,3,4], [3,4,5], [4,5,6]]);
    var recs4 := GetRecords2(209, p4s, p4n, p4b);

    return recs1 + recs2 + recs3 + recs4;
  }

  method WriteSetPermutations()
  {
    var configs := GetConfigs();
    var records := GetRecords();
    var whole := Object([("RoundTripTest", Object([
                          ("Records", Array(records)),
                          ("Configs", configs)
                          ]))]);

    var jsonBytes :- expect API.Serialize(whole);

    var _ :- expect FileIO.WriteBytesToFile(
      "PermTest.json",
      jsonBytes
    );
  }
}
