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

  // Attribute names with special characters that seem likely to break
  // when we introduce structured encryption
  const SpecialConfig := @"{
        ""attributeActionsOnEncrypt"": {
          ""RecNum"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""a.b"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""a[2]"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""a#b"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""'a'"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""'a"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""a'"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""'a.b'"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""$'a'"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""$.a"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""$.[a]"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""$.['a']"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""$.['a"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""\""a\"""": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""\""a"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""a\"""": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""\""a.b\"""": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""$\""a\"""": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""$.a"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""$.[a]"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""$.[\""a\""]"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"",
          ""$.[\""a"": ""SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT""
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
  // Configuration with a new encrypted attribute not present in basic config
  const ExpandedBasicConfig := @"{
        ""attributeActionsOnEncrypt"": {
          ""RecNum"": ""SIGN_ONLY"",
          ""Stuff"": ""ENCRYPT_AND_SIGN"",
          ""Junk"": ""ENCRYPT_AND_SIGN"",
          ""NewThing"": ""ENCRYPT_AND_SIGN""
        }
      }"
  // Configuration with a new sign-only attribute not present in basic config
  const ExpandedSignConfig := @"{
        ""attributeActionsOnEncrypt"": {
          ""RecNum"": ""SIGN_ONLY"",
          ""Stuff"": ""ENCRYPT_AND_SIGN"",
          ""Junk"": ""ENCRYPT_AND_SIGN"",
          ""NewThing"": ""SIGN_ONLY""
        }
      }"
  // Configuration with a new DO_NOTHING attribute not present in basic config
  const ExpandedDoNothingConfig := @"{
        ""attributeActionsOnEncrypt"": {
          ""RecNum"": ""SIGN_ONLY"",
          ""Stuff"": ""ENCRYPT_AND_SIGN"",
          ""Junk"": ""ENCRYPT_AND_SIGN"",
          ""NewThing"": ""DO_NOTHING""
        },
        ""allowedUnsignedAttributes"": [""NewThing""]
      }"

  method TextToJson(x: string) returns (output : JSON)
  {
    var str :- expect UTF8.Encode(x);
    var json :- expect API.Deserialize(str);
    return json;
  }

  const QUOTE : string := "\""

  const ConfigRecord :=
    "{\"RecNum\": 1,"
    +  QUOTE + Attr1 + QUOTE + ": \"aaa\","
    +  QUOTE + Attr2 + QUOTE + ": {\"M\" : {\"A\":\"B\", \"C\":\"D\"}},"
    +  QUOTE + Attr3 + QUOTE + ":  {\"L\" : [{\"M\" : {\"A\":\"B\", \"C\":\"D\"}}, {\"NS\":[\"00.0011\", \"0000\", \"2000.000\", \"10.01\"]}, {\"SS\":[\"00.0011\", \"0000\", \"2000.000\", \"10.01\"]}]},"
    +  QUOTE + Attr4 + QUOTE + ": {\"SS\":[\"00.0011\", \"0000\", \"2000.000\", \"10.01\"]},"
    +  QUOTE + Attr5 + QUOTE + ": {\"NS\":[\"00.0011\", \"0000\", \"2000.000\", \"10.01\"]}}"

  const BasicRecord := @"{
          ""RecNum"": 1,
          ""Stuff"": ""StuffData"",
          ""Junk"": ""JunkData""
        }"
  const SpecialRecord := @"{
          ""RecNum"": 1,
          ""a.b"": ""aaa"",
          ""a[2]"": ""bbb"",
          ""a#b"": ""ccc"",
          ""'a'"": ""ddd"",
          ""'a"": ""eee"",
          ""a'"": ""fff"",
          ""'a.b'"": ""ggg"",
          ""$'a'"": ""hhh"",
          ""$.a"": ""iii"",
          ""$.[a]"": ""jjj"",
          ""$.['a']"": ""kkk"",
          ""$.['a"": ""lll"",
          ""\""a\"""": ""mmm"",
          ""\""a"": ""nnn"",
          ""a\"""": ""ooo"",
          ""\""a.b\"""": ""ppp"",
          ""$\""a\"""": ""qqq"",
          ""$.a"": ""rrr"",
          ""$.[a]"": ""sss"",
          ""$.[\""a\""]"": ""ttt"",
          ""$.[\""a"": ""uuu""
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

  type CryptoAction = x : int | 0 <= x < 4
  type CryptoActions = x : seq<CryptoAction> | |x| == 6 witness [0,0,0,0,0,0]
  const CryptoActionStr : seq<string> := ["0", "1", "2", "3"]
  const MyActionNames : seq<string> := ["ENCRYPT_AND_SIGN", "SIGN_ONLY", "SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT", "DO_NOTHING"]
  const Encrypt : CryptoAction := 0
  const SignOnly : CryptoAction := 1
  const SignInclude : CryptoAction := 2
  const DoNothing : CryptoAction := 3

  const A : string := "A"
  const B : string := "\ud000" // "Ud000" <-> "퀀"
  const C : string := "\ufe4c" // "Ufe4c" <-> "﹌"
  const D : string := "\uD800\uDC01" // "U10001" <-> "𐀁" (surrogate pair: "\uD800\uDC01")
  const E : string := "\uD800\uDC02" // "U10002" <-> "𐀂" (same high surrogate as D: "\uD800\uDC02")
  const F : string := "\uD840\uDC02" // "U20002" <-> "𠀂"  (different high surrogate as D: "\D840\uDC02")

  lemma CheckLengths()
    ensures |A| == 1
    ensures |B| == 1
    ensures |C| == 1
    ensures |D| == 2
    ensures |E| == 2
    ensures |F| == 2
  {}

  // Let's make attribute names with complex characters.
  // It shouldn't matter, but let's make sure
  const Attr1 : string  := F+D
  const Attr2 : string  := A+B+C+D
  const Attr3 : string  := E+D
  const Attr4 : string  := C+D
  const Attr5 : string  := D+C+B+A
  const MyAttrNames : seq<string> := ["RecNum", Attr1, Attr2, Attr3, Attr4, Attr5]


  method MakeConfig(actions : CryptoActions) returns (output : JSON)
    ensures output.Object?
  {
    var configActions : seq<(string, JSON)> := [];
    var notSigned : seq<JSON> := [];
    for i := 0 to 6 {
      var myAction : CryptoAction := actions[i];
      configActions := configActions + [(MyAttrNames[i], String(MyActionNames[myAction]))];
      if myAction == DoNothing {
        notSigned := notSigned + [String(MyAttrNames[i])];
      }
    }
    var result : seq<(string, JSON)> := [
      ("attributeActionsOnEncrypt", Object(configActions)),
      ("allowedUnsignedAttributes", Array(notSigned))
    ];

    return Object(result);
  }

  method MakeConfigTest(
    name : string,
    config : JSON,
    record : JSON,
    decryptConfigJson : Option<JSON> :=  None) returns (output : (string, JSON))
  {
    var result : seq<(string, JSON)> :=
      [
        ("type", String("positive-encrypt")),
        ("description", String("config test")),
        ("config", config),
        ("record", record)
      ];
    if decryptConfigJson.Some? {
      var decryptConfig := decryptConfigJson.value;
      result := result + [("decryptConfig", decryptConfig)];
    }
    return(name, Object(result));
  }

  function Increment(x : CryptoActions) : CryptoActions
  {
    if x[5] < 3 then
      [x[0], x[1], x[2], x[3], x[4], x[5]+1]
    else if x[4] < 3 then
      [x[0], x[1], x[2], x[3], x[4]+1, 0]
    else if x[3] < 3 then
      [x[0], x[1], x[2], x[3]+1, 0, 0]
    else if x[2] < 3 then
      [x[0], x[1], x[2]+1, 0, 0, 0]
    else if x[1] < 3 then
      [x[0], x[1]+1, 0, 0, 0, 0]
    else if x[0] < 3 then
      [x[0]+1, 0, 0, 0, 0, 0]
    else
      [0, 0, 0, 0, 0, 0]
  }

  // To be consistent :
  // 1) The primary key (actions[0]) must be sign_only or sign_and_include
  // 2) If anything is sign_and_include, then The primary key must be sign_and_include
  predicate IsConsistent(actions : CryptoActions)
  {
    if actions[0] in [DoNothing, Encrypt] then
      false
    else if actions[0] == SignOnly && (exists x | x in actions :: x == SignInclude) then
      false
    else
      true
  }

  // For a new config to be consistent with an old config:
  // 1) both configs must be individually consistent
  // 2) they must agree on which fields are do_nothing
  predicate IsConsistentWith(oldActions : CryptoActions, newActions : CryptoActions)
  {
    if !IsConsistent(oldActions) || !IsConsistent(newActions) then
      false
    else
      !exists i | 0 <= i < 6 :: (oldActions[i] == DoNothing) != (newActions[i] == DoNothing)
  }

  // make a test for every valid combination of Crypto Actions
  // 'actions' holds the crypto actions for each of six attributes
  // the loop iterates through all possible combinations of attributes by incrementing this list
  method MakeConfigTests() returns (output : seq<(string, JSON)>)
  {
    var actions : CryptoActions := [0,0,0,0,0,0];
    var result : seq<(string, JSON)> := [];
    var record := TextToJson(ConfigRecord);
    var actionWrittenOuter := 0;
    var actionWrittenInner := 0;
    // 4096 == 4 ^ 6 == size of all possible values of `actions`
    for i := 0 to 4096 {
      actions := Increment(actions);
      if IsConsistent(actions) {
        var name := "ConfigTest_";
        for j := 0 to 6 {
          name := name + CryptoActionStr[actions[j]];
        }
        var config := MakeConfig(actions);
        var theTest := MakeConfigTest(name, config, record);
        result := result + [theTest];
        actionWrittenOuter := actionWrittenOuter + 1;

        // for a subset of these,
        // make a test to decrypt with every possible valid combination of Crypto Actions
        // testing all of them would take too much time and space,
        // so we select a sample to produce about 2000 more tests
        // every 100th seems as good as any other method to get a representative sample
        if (actionWrittenOuter % 100) == 0 {
          var otherActions : CryptoActions := [0,0,0,0,0,0];
          // 4096 == 4 ^ 6 == size of all possible values of `otherActions`
          for j := 0 to 4096 {
            otherActions := Increment(otherActions);
            if IsConsistentWith(actions, otherActions) {
              var newConfig := MakeConfig(otherActions);
              var newName := name + "_";
              for k := 0 to 6 {
                newName := newName + CryptoActionStr[otherActions[k]];
              }
              var newTest := MakeConfigTest(newName, config, record, Some(newConfig));
              result := result + [newTest];
              actionWrittenInner := actionWrittenInner + 1;
            }
          }
        }
      }
    }
    print "MakeConfigTests : ", actionWrittenOuter, " outer and ", actionWrittenInner, " inner for ", |result|, " total.\n";
    return result;
  }

  method Write(fileName : string) returns (output : Result<bool, string>)
  {
    print "Write : ", fileName, "\n";
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
    var test14 := MakeTest("14", "positive-encrypt", "Special characters in attribute names", SpecialConfig, SpecialRecord);

    var test15 := MakeTest("15", "positive-encrypt", "Add new ENCRYPT_AND_SIGN attribute", BasicConfig, BasicRecord, Some(ExpandedBasicConfig));
    var test16 := MakeTest("16", "positive-encrypt", "Add new SIGN_ONLY attribute", BasicConfig, BasicRecord, Some(ExpandedSignConfig));
    var test17 := MakeTest("17", "positive-encrypt", "Add new DO_NOTHING attribute", BasicConfig, BasicRecord, Some(ExpandedDoNothingConfig));
    var test18 := MakeTest("18", "positive-encrypt", "Remove ENCRYPT_AND_SIGN attribute, encrypt with expanded, decrypt with basic", ExpandedBasicConfig, BasicRecord, Some(BasicConfig));
    var test19 := MakeTest("19", "positive-encrypt", "Remove SIGN_ONLY attribute, encrypt with expanded, decrypt with basic", ExpandedSignConfig, BasicRecord, Some(BasicConfig));
    var test20 := MakeTest("20", "positive-encrypt", "Remove DO_NOTHING attribute, encrypt with expanded, decrypt with basic", ExpandedDoNothingConfig, BasicRecord, Some(BasicConfig));

    var configTests := MakeConfigTests();
    var tests : seq<(string, JSON)> := [test1, test2, test3, test4, test5, test6, test7, test8, test9, test10, test11, test12, test13, test14, test15, test16, test17, test18, test19, test20] + configTests;
    var final := Object(result + [("tests", Object(tests))]);

    var jsonBytes :- expect API.Serialize(final);
    var x := FileIO.WriteBytesToFile(fileName, jsonBytes);
    expect x.Success?;
    return Success(true);
  }

}
