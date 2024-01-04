// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "JsonItem.dfy"

module {:options "-functionSyntax:4"} WriteManifest {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened JSON.Values
  import JSON.API
  import JSON.Errors
  import StandardLibrary.String
  import FileIO
  import opened JSONHelpers

  function Manifest() : (string, JSON)
  {
    var result : seq<(string, JSON)> :=
      [
        ("type", String("aws-dbesdk-encrypt")),
        ("version", String("1"))
      ];
    ("manifest", Object(result))
  }

  const BasicConfig := @"{
        ""attributeActionsOnEncrypt"": {
          ""RecNum"": ""SIGN_ONLY"",
          ""Stuff"": ""ENCRYPT_AND_SIGN"",
          ""Junk"": ""ENCRYPT_AND_SIGN""
        }
      }"
  const SignConfig := @"{
        ""attributeActionsOnEncrypt"": {
          ""RecNum"": ""SIGN_ONLY"",
          ""Stuff"": ""SIGN_ONLY"",
          ""Junk"": ""SIGN_ONLY""
        }
      }"
  const NothingConfig := @"{
        ""attributeActionsOnEncrypt"": {
          ""RecNum"": ""SIGN_ONLY"",
          ""Stuff"": ""DO_NOTHING"",
          ""Junk"": ""DO_NOTHING""
        },
        ""allowedUnsignedAttributes"" : [""Stuff"", ""Junk""]
      }"
    
  method TextToJson(x: string) returns (output : JSON)
  {
    var str :- expect UTF8.Encode(x);
    var json :- expect API.Deserialize(str);
    return json;
  }

  const BasicRecord := @"{
          ""RecNum"": 1,
          ""Stuff"": ""StuffData"",
          ""Junk"": ""JunkData""
        }"
  const BadRecord := @"{
          ""Stuff"": ""StuffData"",
          ""Junk"": ""JunkData""
        }"

  method MakeTest(
    name : string, 
    typ : string, 
    desc : string, 
    configJson : string, 
    recordJson : string, 
    decryptConfigJson : Option<string> :=  None) returns (output : (string, JSON))
  {
    var config := TextToJson(configJson);
    var record := TextToJson(recordJson);
    var result : seq<(string, JSON)> :=
      [
        ("type", String(typ)),
        ("description", String(desc)),
        ("config", config),
        ("record", record)
      ];
    if decryptConfigJson.Some? {
      var decryptConfig := TextToJson(decryptConfigJson.value);
      result := result + [("decryptConfig", decryptConfig)];
    }
    return(name, Object(result));
  }

  method Write(fileName : string) returns (output : Result<bool, string>)
  {
    var result : seq<(string, JSON)> :=
      [Manifest(), ("keys", String("file://keys.json"))];

    var test1 := MakeTest("1", "positive-encrypt", "Basic encrypt", BasicConfig, BasicRecord);
    var test2 := MakeTest("2", "positive-encrypt", "Change ENCRYPT_AND_SIGN to SIGN_ONLY", BasicConfig, BasicRecord, Some(SignConfig));
    var test3 := MakeTest("3", "positive-encrypt", "Change SIGN_ONLY to ENCRYPT_AND_SIGN", SignConfig, BasicRecord, Some(BasicConfig));
    var test4 := MakeTest("4", "negative-decrypt", "Change ENCRYPT_AND_SIGN to DO_NOTHING", BasicConfig, BasicRecord, Some(NothingConfig));
    var test5 := MakeTest("5", "negative-encrypt", "Lacks primary key", BasicConfig, BadRecord);
    var tests : seq<(string, JSON)> := [test1, test2, test3, test4, test5];
    var final := Object(result + [("tests", Object(tests))]);

    var jsonBytes :- expect API.Serialize(final);
    var jsonBv := BytesBv(jsonBytes);
    var x := FileIO.WriteBytesToFile(fileName, jsonBv);
    expect x.Success?;
    return Success(true);
  }

}
