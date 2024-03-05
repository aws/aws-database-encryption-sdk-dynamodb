// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"

module JsonEncryptorTest {
  import opened AwsCryptographyDbEncryptionSdkDynamoDbJsonTypes
  import opened JsonEncryptorUtil
  import opened Wrappers
  import opened StandardLibrary.UInt
  import MaterialProviders
  import JsonEncryptor
  import JsonToStruct`Fun
  import UTF8
  import JSON.Spec
  import JSON.API
  import opened JSON.Values
  import JSON.Errors
  import CSE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import SortedSets


  predicate method IsEncrypted(actions : Option<MemberActions>, name : string)
  {
    || (ReservedPrefix < name)
    || (actions.Some? && name in actions.value && actions.value[name].crypto? && actions.value[name].crypto == CSE.ENCRYPT_AND_SIGN)
  }

  method ObjectToStructuredFull(item : string, actions : Option<MemberActions> := None)
    returns (ret : Result<CSE.StructuredDataMap, string>)
  {
    var obj :- UTF8.Encode(item);
    var json :- API.Deserialize(obj).MapFailure((e : Errors.DeserializationError) => e.ToString());
    :- Need(json.Object?, "JSON to encrypt must be an Object : " + item);
    var result : CSE.StructuredDataMap := map[];
    for i := 0 to |json.obj| {
      var struct :- JsonToStruct.AttrToStructured(json.obj[i].1, IsEncrypted(actions, json.obj[i].0));
      result := result[json.obj[i].0 := struct];
    }
    return Success(result);
  }

  method StructuredToObjectFull(s : CSE.StructuredDataMap) returns (ret : Result<string, string>)
  {
    var keys := SortedSets.ComputeSetToOrderedSequence2(s.Keys, CharLess);
    var result : seq<(string, JSON)> := [];
    for i := 0 to |keys| {
      var j :- JsonToStruct.StructuredToAttr(s[keys[i]]);
      result := result + [(keys[i], j)];
    }
    var final := Object(result);
    var jsonBytes :- API.Serialize(final).MapFailure((e : Errors.SerializationError) => e.ToString());
    return UTF8.Decode(jsonBytes);
  }


  method ExpectEqualJson(item : string, final : Json)
  {
    var obj :- expect UTF8.Encode(item);
    var itemJson :- expect API.Deserialize(obj);
    var jsonBytes :- expect API.Serialize(itemJson);
    var newItem :- expect UTF8.Decode(jsonBytes);

  if final.text? && newItem == final.text {
    return;
  }

    var finalJson :- expect JsonToStruct.SmithyJsonToObject(final);
    if JsonToStruct.JsonEqual(itemJson, finalJson) {
      print "Item seemed to change from : ", item, " to ", final, " but it was really still the same\n";

    } else {
      print "Item changed : ", item, " to ", final, "\n";
      expect false;
    }
  }

  method TestRoundTrip(item : string)
  {
    print "Testing ", item, "\n";
    var o2s := ObjectToStructuredFull(item, None);
    if o2s.Failure? {
      print "Unexpected ObjectToStructured error : \n", o2s.error, "\n", item, "\n";
    }
    expect o2s.Success?;
    var s2o := StructuredToObjectFull(o2s.value);
    if s2o.Failure? {
      print "Unexpected StructuredToObject error : \n", s2o.error, "\n", item, "\n", o2s.value, "\n";
    }
    expect s2o.Success?;
    ExpectEqualJson(item, text(s2o.value));

  }
  method {:test} TestRoundTrips() {
    TestRoundTrip("{}");
    TestRoundTrip("{\"abc\" : 42}");
    TestRoundTrip("{\"abc\" : true}");
    TestRoundTrip("{\"abc\" : false}");
    TestRoundTrip("{\"abc\" : null}");
    TestRoundTrip("{\"abc\" : 100}");
    TestRoundTrip("{\"abc\" : 100e0}");
    TestRoundTrip("{\"abc\" : 100e1}");
    TestRoundTrip("{\"abc\" : 100e2}");
    TestRoundTrip("{\"abc\" : \"foo\"}");
    TestRoundTrip("{\"abc\" : \"foo\", \"bcd\" : true, \"cde\" : 42}");
    TestRoundTrip("{\"abc\" : {}}");
    TestRoundTrip("{\"abc\" : []}");
    TestRoundTrip("{\"abc\" : [1,2,true,false,null,\"aaa\"]}");
    TestRoundTrip("{\"abc\" : {\"bcd\" : 42, \"abcde\" : null, \"cde\" : \"foo\", \"qwert\" : [1,2,3]}}");
  }

  const PUBLIC_US_WEST_2_KMS_TEST_KEY := "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f"
  method GetKmsKeyring()
      returns (keyring: AwsCryptographyMaterialProvidersTypes.IKeyring)
    ensures keyring.ValidState()
    ensures fresh(keyring)
    ensures fresh(keyring.Modifies)
  {
    var matProv :- expect MaterialProviders.MaterialProviders(MaterialProviders.DefaultMaterialProvidersConfig());
    var keyringInput := AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMultiKeyringInput(
      generator := Some(PUBLIC_US_WEST_2_KMS_TEST_KEY),
      kmsKeyIds := None(),
      clientSupplier := None(),
      grantTokens := None()
    );
    keyring :- expect matProv.CreateAwsKmsMultiKeyring(keyringInput);
  }

  method GetConfigFromActions(actions : MemberActions) returns (output : JsonEncryptorConfig) {
    var keyring := GetKmsKeyring();
    var logicalTableName := "foo";
    output := JsonEncryptorConfig(
      domain := logicalTableName,
      memberActionsOnEncrypt := actions,
      allowedUnsignedMembers := Some(["nothing"]),
      allowedUnsignedMemberPrefix := None,
      encrypt := JsonEncrypt(keyring := Some(keyring))
    );
  }

  method GetEncryptorFromConfig(config : JsonEncryptorConfig)
    returns (encryptor: JsonEncryptor.JsonEncryptorClient)
    ensures encryptor.ValidState()
    ensures fresh(encryptor)
    ensures fresh(encryptor.Modifies)
  {
    var keyring := GetKmsKeyring();
    var encryptorConfig := JsonEncryptorConfig(
      domain := config.domain,
      memberActionsOnEncrypt := config.memberActionsOnEncrypt,
      allowedUnsignedMembers := config.allowedUnsignedMembers,
      allowedUnsignedMemberPrefix := config.allowedUnsignedMemberPrefix,
      encrypt := JsonEncrypt(keyring := Some(keyring))
    );
    expect forall k <- encryptorConfig.memberActionsOnEncrypt :: encryptorConfig.memberActionsOnEncrypt[k].crypto?;
    var encryptor2 : IJsonEncryptorClient :- expect JsonEncryptor.JsonEncryptor(encryptorConfig);
    assert encryptor2 is JsonEncryptor.JsonEncryptorClient;
    encryptor := encryptor2 as JsonEncryptor.JsonEncryptorClient;
  }

  method GetEncryptorFromActions(actions : MemberActions)
    returns (encryptor: JsonEncryptor.JsonEncryptorClient)
    ensures encryptor.ValidState()
    ensures fresh(encryptor)
    ensures fresh(encryptor.Modifies)
  {
    var config := GetConfigFromActions(actions);
    encryptor := GetEncryptorFromConfig(config);
  }

  method TestEncryptRoundTrip(encryptor : JsonEncryptor.JsonEncryptorClient, item : string)
    requires encryptor.ValidState()
    ensures encryptor.ValidState()
    modifies encryptor.Modifies
  {
    print "TestEncryptRoundTrip plain : ", item, "\n";
    var encItem :- expect encryptor.EncryptObject(EncryptObjectInput(plaintextObject := text(item)));
//  nameonly parsedHeader: Option<ParsedHeader> := Option.None

    var decItem :- expect encryptor.DecryptObject(DecryptObjectInput(encryptedObject := encItem.encryptedObject));
//  nameonly parsedHeader: Option<ParsedHeader> := Option.None
  ExpectEqualJson(item, decItem.plaintextObject);
  }

  method {:test} TestEncryptRoundTrips() {
    var actions : MemberActions := map[
      "bar" := crypto(CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT),
      "sortKey" := crypto(CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT),
      "encrypt" := crypto(CSE.ENCRYPT_AND_SIGN),
      "sign" := crypto(CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT),
      "sign2" := crypto(CSE.SIGN_ONLY),
      "sign3" := crypto(CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT),
      "sign4" := crypto(CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT),
      "nothing" := crypto(CSE.DO_NOTHING)
    ];
    var encryptor := GetEncryptorFromActions(actions);
    TestEncryptRoundTrip(encryptor, "{\"bar\" : \"abc\"}");
    TestEncryptRoundTrip(encryptor, "{\"bar\" : \"abc\", \"encrypt\" : 42}");
  }

}
