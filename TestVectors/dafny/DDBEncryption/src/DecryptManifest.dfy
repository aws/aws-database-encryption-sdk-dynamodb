// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "JsonConfig.dfy"
include "WriteManifest.dfy"
include "../../../../DynamoDbEncryption/dafny/DynamoDbItemEncryptor/src/Index.dfy"

module {:options "-functionSyntax:4"} DecryptManifest {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened JSON.Values
  import opened WriteManifest
  import JSON.API
  import JSON.Errors
  import DdbItemJson
  import StandardLibrary.String
  import FileIO
  import opened JSONHelpers
  import JsonConfig
  import ENC = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes

  method OnePositiveTest(name : string, config : JSON, encrypted : JSON, plaintext : JSON) returns (output : Result<bool, string>)
  {
    var enc :- JsonConfig.GetRecord(encrypted);
    var plain :- JsonConfig.GetRecord(plaintext);
    var encryptor :- JsonConfig.GetItemEncryptor(name, config);
    var decrypted :- expect encryptor.DecryptItem(
      ENC.DecryptItemInput(
        encryptedItem:=enc.item
      )
    );
    expect DdbItemJson.NormalizeItem(decrypted.plaintextItem) == DdbItemJson.NormalizeItem(plain.item);

    return Success(true);
  }

  method OneNegativeTest(name : string, config : JSON, encrypted : JSON) returns (output : Result<bool, string>)
  {
    var enc :- JsonConfig.GetRecord(encrypted);
    var encryptor :- JsonConfig.GetItemEncryptor(name, config);
    var decrypted := encryptor.DecryptItem(
      ENC.DecryptItemInput(
        encryptedItem:=enc.item
      )
    );
    if decrypted.Success? {
      return Failure("Failed to fail to decrypt " + name);
    }
    return Success(true);
  }

  method OneTest(name : string, value : JSON) returns (output : Result<bool, string>)
  {
    :- Need(value.Object?, "Test must be an object");

    var types : Option<string> := None;
    var description : Option<string> := None;
    var config : Option<JSON> := None;
    var encrypted : Option<JSON> := None;
    var plaintext : Option<JSON> := None;

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
        case "encrypted" =>
          :- Need(obj.1.Object?, "Value of 'record' must be an object.");
          encrypted := Some(obj.1);
        case "plaintext" =>
          :- Need(obj.1.Object?, "Value of 'record' must be an object.");
          plaintext := Some(obj.1);
        case _ => return Failure("Unknown test member : " + obj.0 + " in " + name);
      }
    }
    :- Need(types.Some?, "Test requires a 'type' member.");
    :- Need(description.Some?, "Test requires a 'description' member.");
    :- Need(config.Some?, "Test requires a 'config' member.");
    :- Need(encrypted.Some?, "Test requires a 'encrypted' member.");

    if types.value == "positive-decrypt" {
      :- Need(plaintext.Some?, "positive-decrypt Test requires a 'plaintext' member.");
      output := OnePositiveTest(name, config.value, encrypted.value, plaintext.value);
    } else if types.value == "negative-decrypt" {
      output := OneNegativeTest(name, config.value, encrypted.value);
    } else {
      return Failure("Invalid encrypt type : '" + types.value + "'.");
    }
  }

  method Decrypt(inFile : string) returns (output : Result<bool, string>)
  {
    print "Decrypt : ", inFile, "\n";
    var configBv :- expect FileIO.ReadBytesFromFile(inFile);
    var configBytes := BvToBytes(configBv);
    var json :- expect API.Deserialize(configBytes);

    :- Need(json.Object?, "Decrypt file must contain a JSON object.");
    var keys : Option<string> := None;
    var client : Option<seq<(string, JSON)>> := None;
    var manifest : Option<seq<(string, JSON)>> := None;
    var tests : Option<seq<(string, JSON)>> := None;

    for i := 0 to |json.obj| {
      var obj := json.obj[i];
      match obj.0 {
        case "keys" =>
          :- Need(obj.1.String?, "Value of 'keys' must be a string.");
          keys := Some(obj.1.str);
        case "client" =>
          :- Need(obj.1.Object?, "Value of 'client' must be an Object.");
          client := Some(obj.1.obj);
        case "manifest" =>
          :- Need(obj.1.Object?, "Value of 'manifest' must be an object.");
          manifest := Some(obj.1.obj);
        case "tests" =>
          :- Need(obj.1.Object?, "Value of 'tests' must be an object.");
          tests := Some(obj.1.obj);
        case _ => return Failure("Unknown top level encrypt tag : " + obj.0);
      }
    }
    :- Need(keys.Some?, "Decrypt manifest requires a 'keys' member.");
    :- Need(client.Some?, "Decrypt manifest requires a 'client' member.");
    :- Need(manifest.Some?, "Decrypt manifest requires a 'manifest' member.");
    :- Need(tests.Some?, "Decrypt manifest requires a 'tests' member.");

    for i := 0 to |manifest.value| {
      var obj := manifest.value[i];
      match obj.0 {
        case "type" =>
          :- Need(obj.1.String?, "Value of 'type' must be a string.");
          :- Need(obj.1.str == DECRYPT_TYPE, "Value of 'type' must be '" + DECRYPT_TYPE + "'.");
        case "version" =>
          :- Need(obj.1.String?, "Value of 'version' must be a string.");
          :- Need(obj.1.str == "1", "Value of 'version' must be '1'");
        case _ => return Failure("Unknown manifest member : " + obj.0);
      }
    }

    for i := 0 to |tests.value| {
      var obj := tests.value[i];
      :- Need(obj.1.Object?, "Value of test '" + obj.0 + "' must be an Object.");
      var _ :- OneTest(obj.0, obj.1);
    }

    return Success(true);
  }

}