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

  const ENCRYPT_TYPE := "aws-dbesdk-encrypt"
  const DECRYPT_TYPE := "aws-dbesdk-decrypt"
  const LIB_PREFIX := "aws/aws-dbesdk-"

  function Manifest() : (string, JSON)
  {
    var result : seq<(string, JSON)> :=
      [
        ("type", String(ENCRYPT_TYPE)),
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
  const BasicV2Config := @"{
        ""attributeActionsOnEncrypt"": {
          ""RecNum"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""Stuff"": ""ENCRYPT_AND_SIGN"",
          ""Junk"": ""ENCRYPT_AND_SIGN""
        }
      }"
  const LongerV2Config1 := @"{
        ""attributeActionsOnEncrypt"": {
          ""RecNum"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""Stuff"": ""ENCRYPT_AND_SIGN"",
          ""Junk"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""Thing2"": ""ENCRYPT_AND_SIGN"",
          ""Thing3"": ""ENCRYPT_AND_SIGN""
        }
      }"
  const LongerV2Config2 := @"{
        ""attributeActionsOnEncrypt"": {
          ""RecNum"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""Stuff"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""Junk"": ""ENCRYPT_AND_SIGN"",
          ""Thing2"": ""ENCRYPT_AND_SIGN"",
          ""Thing3"": ""ENCRYPT_AND_SIGN""
        }
      }"
  const MixedConfig := @"{
        ""attributeActionsOnEncrypt"": {
          ""RecNum"": ""SIGN_ONLY"",
          ""Stuff"": ""SIGN_ONLY"",
          ""Junk"": ""ENCRYPT_AND_SIGN""
        }
      }"
  const BasicConfigSig := @"{
        ""attributeActionsOnEncrypt"": {
          ""RecNum"": ""SIGN_ONLY"",
          ""Stuff"": ""ENCRYPT_AND_SIGN"",
          ""Junk"": ""ENCRYPT_AND_SIGN""
        },
        ""algorithmSuiteId"" : ""ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384""
      }"
  const BasicConfigNoSig := @"{
        ""attributeActionsOnEncrypt"": {
          ""RecNum"": ""SIGN_ONLY"",
          ""Stuff"": ""ENCRYPT_AND_SIGN"",
          ""Junk"": ""ENCRYPT_AND_SIGN""
        },
        ""algorithmSuiteId"" : ""ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384""
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
  const ComplexRecord := @"{
          ""RecNum"": 1,
          ""Stuff"": {""L"" : [{""M"" : {""A"":""B"", ""C"":""D""}}, {""NS"":[""00.0011"", ""0000"", ""2000.000"", ""10.01""]}, {""SS"":[""00.0011"", ""0000"", ""2000.000"", ""10.01""]}]},
          ""Junk"": {""L"" : [{""M"" : {""A"":""B"", ""C"":""D""}}, {""NS"":[""00.0011"", ""0000"", ""2000.000"", ""10.01""]}, {""SS"":[""00.0011"", ""0000"", ""2000.000"", ""10.01""]}]}
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
    var test6 := MakeTest("6", "positive-encrypt", "Basic With Sig", BasicConfigSig, BasicRecord);
    var test7 := MakeTest("7", "positive-encrypt", "Basic Without Sig", BasicConfigNoSig, BasicRecord);
    var test8 := MakeTest("8", "positive-encrypt", "Change Sig to NoSig", BasicConfigSig, BasicRecord, Some(BasicConfigNoSig));
    var test9 := MakeTest("9", "positive-encrypt", "Change NoSig to Sig", BasicConfigNoSig, BasicRecord, Some(BasicConfigSig));
    var test10 := MakeTest("10", "positive-encrypt", "Complex encrypt", MixedConfig, ComplexRecord);
    var test11 := MakeTest("11", "positive-encrypt", "Basic encrypt V2", BasicV2Config, BasicRecord);
    var test12 := MakeTest("12", "positive-encrypt", "Basic encrypt V2 switching1", LongerV2Config1, BasicRecord, Some(LongerV2Config2));
    var test13 := MakeTest("13", "positive-encrypt", "Basic encrypt V2 switching2", LongerV2Config2, BasicRecord, Some(LongerV2Config1));
    var tests : seq<(string, JSON)> := [test1, test2, test3, test4, test5, test6, test7, test8, test9, test10, test11, test12, test13];
    var final := Object(result + [("tests", Object(tests))]);

    var jsonBytes :- expect API.Serialize(final);
    var jsonBv := BytesBv(jsonBytes);
    var x := FileIO.WriteBytesToFile(fileName, jsonBv);
    expect x.Success?;
    return Success(true);
  }

}
