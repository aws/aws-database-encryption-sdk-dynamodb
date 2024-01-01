include "JsonItem.dfy"

module {:options "-functionSyntax:4"} WriteManifest {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened JSON.Values
  import JSON.API
  import JSON.Errors
  import opened DynamoDbEncryptionUtil
  import opened ComAmazonawsDynamodbTypes
  import opened SortedSets
  import StandardLibrary.String
  import FileIO
  import opened JSONHelpers
  import DynamoDbItemEncryptor

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

  method BasicConfigJson() returns (output : JSON)
  {
    var str :- expect UTF8.Encode(BasicConfig);
    var json :- expect API.Deserialize(str);
    return json;
  }

  const BasicRecord := @"{
          ""RecNum"": 1,
          ""Stuff"": ""StuffData"",
          ""Junk"": ""JunkData""
        }"

  method BasicRecordJson() returns (output : JSON)
  {
    var json :- expect API.Deserialize(UTF8.EncodeAscii(BasicRecord));
    return json;
  }

  method BasicTest() returns (output : (string, JSON))
  {
    var config := BasicConfigJson();
    var record := BasicRecordJson();
    var result : seq<(string, JSON)> :=
      [
        ("type", String("positive-encrypt")),
        ("description", String("Basic encrypt")),
        ("config", config),
        ("record", record)
      ];
    return("1", Object(result));
  }

  method Write(fileName : string) returns (output : Result<bool, string>)
  {
    var result : seq<(string, JSON)> :=
      [Manifest(), ("keys", String("file://keys.json"))];

    var test1 := BasicTest();
    var tests : seq<(string, JSON)> := [test1];
    var final := Object(result + [("tests", Object(tests))]);

    var jsonBytes :- expect API.Serialize(final);
    var jsonBv := BytesBv(jsonBytes);
    var x := FileIO.WriteBytesToFile(fileName, jsonBv);
    expect x.Success?;
    return Success(true);

  }

}
