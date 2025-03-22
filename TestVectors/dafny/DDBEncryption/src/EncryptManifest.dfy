// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "JsonConfig.dfy"
include "WriteManifest.dfy"
include "../../../../DynamoDbEncryption/dafny/DynamoDbItemEncryptor/src/Index.dfy"

module {:options "-functionSyntax:4"} EncryptManifest {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened JSON.Values
  import opened WriteManifest
  import Time
  import JSON.API
  import JSON.Errors
  import opened DynamoDbEncryptionUtil
  import DdbItemJson
  import StandardLibrary.String
  import FileIO
  import opened JSONHelpers
  import JsonConfig
  import ENC = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import KeyVectors

  function Manifest() : (string, JSON)
  {
    var result : seq<(string, JSON)> :=
      [
        ("type", String(DECRYPT_TYPE)),
        ("version", String("1"))
      ];
    ("manifest", Object(result))
  }

  function Client(lang : string, version : string) : (string, JSON)
  {
    var result : seq<(string, JSON)> :=
      [
        ("name", String(LIB_PREFIX + lang)),
        ("version", String(version))
      ];
    ("client", Object(result))
  }

  method OnePositiveTest(name : string, theType : string, desc : string, config : JSON, decryptConfig : Option<JSON>, record : JSON, keys: KeyVectors.KeyVectorsClient)
    returns (output : Result<(string, JSON), string>)
    requires keys.ValidState()
    modifies keys.Modifies
    ensures keys.ValidState()
  {
    var rec :- JsonConfig.GetRecord(record);
    var encryptor :- JsonConfig.GetItemEncryptor(name, config, keys);
    var encrypted :- expect encryptor.EncryptItem(
      ENC.EncryptItemInput(
        plaintextItem:=rec.item
      )
    );
    var item :- expect DdbItemJson.DdbItemToJson(encrypted.encryptedItem);

    var result : seq<(string, JSON)> :=
      [
        ("type", String(theType)),
        ("description", String(desc)),
        ("config", if decryptConfig.Some? then decryptConfig.value else config),
        ("plaintext", record),
        ("encrypted", item)
      ];
    return Success((name, Object(result)));
  }

  method OneNegativeTest(name : string, config : JSON, record : JSON, keys: KeyVectors.KeyVectorsClient)
    returns (output : Result<bool, string>)
    requires keys.ValidState()
    modifies keys.Modifies
    ensures keys.ValidState()
  {
    var rec :- JsonConfig.GetRecord(record);
    var encryptor :- JsonConfig.GetItemEncryptor(name, config, keys);
    var encrypted := encryptor.EncryptItem(
      ENC.EncryptItemInput(
        plaintextItem:=rec.item
      )
    );
    if encrypted.Success? {
      return Failure("Test " + name + " failed to fail to encrypt.");
    }
    return Success(true);
  }


  method OneTest(name : string, value : JSON, keys: KeyVectors.KeyVectorsClient)
    returns (output : Result<Option<(string, JSON)>, string>)
    requires keys.ValidState()
    modifies keys.Modifies
    ensures keys.ValidState()
  {
    :- Need(value.Object?, "Test must be an object");

    var types : Option<string> := None;
    var description : Option<string> := None;
    var config : Option<JSON> := None;
    var decryptConfig : Option<JSON> := None;
    var record : Option<JSON> := None;

    for i := 0 to |value.obj| {
      var obj := value.obj[i];
      match obj.0 {
        case "type" =>
          :- Need(obj.1.String?, "Value of 'type' must be a string.");
          types := Some(obj.1.str);
        case "description" =>
          :- Need(obj.1.String?, "Value of 'description' must be a string.");
          description := Some(obj.1.str);
        case "config" =>
          :- Need(obj.1.Object?, "Value of 'config' must be an object.");
          config := Some(obj.1);
        case "decryptConfig" =>
          :- Need(obj.1.Object?, "Value of 'decryptConfig' must be an object.");
          decryptConfig := Some(obj.1);
        case "record" =>
          :- Need(obj.1.Object?, "Value of 'record' must be an object.");
          record := Some(obj.1);
        case _ => return Failure("Unknown test member : " + obj.0 + " in " + name);
      }
    }
    :- Need(types.Some?, "Test requires a 'type' member.");
    :- Need(description.Some?, "Test requires a 'description' member.");
    :- Need(config.Some?, "Test requires a 'config' member.");
    :- Need(record.Some?, "Test requires a 'record' member.");

    if types.value == "positive-encrypt" {
      var x :- OnePositiveTest(name, "positive-decrypt", description.value, config.value, decryptConfig, record.value, keys);
      return Success(Some(x));
    } else if types.value == "negative-decrypt" {
      var x :- OnePositiveTest(name, "negative-decrypt", description.value, config.value, decryptConfig, record.value, keys);
      return Success(Some(x));
    } else if types.value == "negative-encrypt" {
      var _ := OneNegativeTest(name, config.value, record.value, keys);
      return Success(None);
    } else {
      return Failure("Invalid encrypt type : '" + types.value + "'.");
    }
  }

  method Encrypt(inFile : string, outFile : string, lang : string, version : string, keyVectors: KeyVectors.KeyVectorsClient)
    returns (output : Result<bool, string>)
    requires keyVectors.ValidState()
    modifies keyVectors.Modifies
    ensures keyVectors.ValidState()
  {
    var timeStamp :- expect Time.GetCurrentTimeStamp();
    print timeStamp + " Encrypt : ", inFile, "\n";
    var configBytes :- expect FileIO.ReadBytesFromFile(inFile);
    timeStamp :- expect Time.GetCurrentTimeStamp();
    print timeStamp + " File Read.\n";
    var json :- expect API.Deserialize(configBytes);
    timeStamp :- expect Time.GetCurrentTimeStamp();
    print timeStamp + " JSON Parsed.\n";

    :- Need(json.Object?, "Encrypt file must contain a JSON object.");
    var keys : Option<string> := None;
    var manifest : Option<seq<(string, JSON)>> := None;
    var tests : Option<seq<(string, JSON)>> := None;

    for i := 0 to |json.obj| {
      var obj := json.obj[i];
      match obj.0 {
        case "keys" =>
          :- Need(obj.1.String?, "Value of 'keys' must be a string.");
          keys := Some(obj.1.str);
        case "manifest" =>
          :- Need(obj.1.Object?, "Value of 'manifest' must be an object.");
          manifest := Some(obj.1.obj);
        case "tests" =>
          :- Need(obj.1.Object?, "Value of 'tests' must be an object.");
          tests := Some(obj.1.obj);
        case _ => return Failure("Unknown top level encrypt tag : " + obj.0);
      }
    }
    :- Need(keys.Some?, "Encrypt manifest requires a 'keys' member.");
    :- Need(manifest.Some?, "Encrypt manifest requires a 'manifest' member.");
    :- Need(tests.Some?, "Encrypt manifest requires a 'tests' member.");

    for i := 0 to |manifest.value| {
      var obj := manifest.value[i];
      match obj.0 {
        case "type" =>
          :- Need(obj.1.String?, "Value of 'type' must be a string.");
          :- Need(obj.1.str == ENCRYPT_TYPE, "Value of 'type' must be '" + ENCRYPT_TYPE + "'.");
        case "version" =>
          :- Need(obj.1.String?, "Value of 'version' must be a string.");
          :- Need(obj.1.str == "1", "Value of 'version' must be '1'");
        case _ => return Failure("Unknown manifest member : " + obj.0);
      }
    }

    var result : seq<(string, JSON)> :=
      [Manifest(), Client(lang, version), ("keys", String("file://keys.json"))];

    var test : seq<(string, JSON)> := [];

    for i := 0 to |tests.value| {
      var obj := tests.value[i];
      :- Need(obj.1.Object?, "Value of test '" + obj.0 + "' must be an Object.");
      var newTest :- OneTest(obj.0, obj.1, keyVectors);
      if newTest.Some? {
        test := test + [newTest.value];
      }
    }

    var final := Object(result + [("tests", Object(test))]);
    var jsonBytes :- expect API.Serialize(final);
    var x :- expect FileIO.WriteBytesToFile(outFile, jsonBytes);

    timeStamp :- expect Time.GetCurrentTimeStamp();
    print timeStamp + " Tests Complete.\n";
    return Success(true);
  }

}