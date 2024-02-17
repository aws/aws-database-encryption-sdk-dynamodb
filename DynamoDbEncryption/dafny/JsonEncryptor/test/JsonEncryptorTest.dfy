// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"

module JsonEncryptorTest {
  import opened AwsCryptographyDbEncryptionSdkDynamoDbJsonTypes
  import opened Wrappers
  import opened StandardLibrary.UInt
  import MaterialProviders
  import JsonEncryptor
  import JsonToStruct
  import UTF8
  import JSON.API
  import CSE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import SE = StructuredEncryptionUtil

  // import AwsCryptographyMaterialProvidersTypes
  // import DDB = ComAmazonawsDynamodbTypes
  // import AwsCryptographyDbEncryptionSdkJsonEncryptorOperations
  // import DDBE = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  // import AlgorithmSuites
  // import StandardLibrary.String


  method ExpectEqualJson(item : string, final : string)
  {
    var obj :- expect UTF8.Encode(item);
    var itemJson :- expect API.Deserialize(obj);
    var jsonBytes :- expect API.Serialize(itemJson);
    var newItem :- expect UTF8.Decode(jsonBytes);

  if newItem == final {
    return;
  }

    obj :- expect UTF8.Encode(final);
    var finalJson :- expect API.Deserialize(obj);
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
    var o2s := JsonToStruct.ObjectToStructured(item, None);
    if o2s.Failure? {
      print "Unexpected ObjectToStructured error : \n", o2s.error, "\n", item, "\n";
    }
    expect o2s.Success?;
    var s2o := JsonToStruct.StructuredToObject(o2s.value);
    if s2o.Failure? {
      print "Unexpected StructuredToObject error : \n", s2o.error, "\n", item, "\n", o2s.value, "\n";
    }
    expect s2o.Success?;
    ExpectEqualJson(item, s2o.value);

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

  method GetConfigFromActions(actions : AttributeActions) returns (output : JsonEncryptorConfig) {
    var keyring := GetKmsKeyring();
    var logicalTableName := "foo";
    output := JsonEncryptorConfig(
      logicalTableName := logicalTableName,
      attributeActionsOnEncrypt := actions,
      allowedUnsignedAttributes := Some(["nothing"]),
      allowedUnsignedAttributePrefix := None,
      keyring := Some(keyring),
      cmm := None,
      algorithmSuiteId := None
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
      logicalTableName := config.logicalTableName,
      attributeActionsOnEncrypt := config.attributeActionsOnEncrypt,
      allowedUnsignedAttributes := config.allowedUnsignedAttributes,
      allowedUnsignedAttributePrefix := config.allowedUnsignedAttributePrefix,
      keyring := Some(keyring),
      cmm := None,
      algorithmSuiteId := None
    );
    var encryptor2 : IJsonEncryptorClient :- expect JsonEncryptor.JsonEncryptor(encryptorConfig);
    assert encryptor2 is JsonEncryptor.JsonEncryptorClient;
    encryptor := encryptor2 as JsonEncryptor.JsonEncryptorClient;
  }

  method GetEncryptorFromActions(actions : AttributeActions)
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
    var encItem :- expect encryptor.EncryptObject(EncryptObjectInput(plaintextObject := item));
//  nameonly parsedHeader: Option<ParsedHeader> := Option.None

    var decItem :- expect encryptor.DecryptObject(DecryptObjectInput(encryptedObject := encItem.encryptedObject));
//  nameonly parsedHeader: Option<ParsedHeader> := Option.None
  ExpectEqualJson(item, decItem.plaintextObject);
  }

  method {:test} TestEncryptRoundTrips() {
    var actions := map[
      "bar" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
      "sortKey" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
      "encrypt" := CSE.ENCRYPT_AND_SIGN,
      "sign" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
      "sign2" := CSE.SIGN_ONLY,
      "sign3" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
      "sign4" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
      "nothing" := CSE.DO_NOTHING
    ];
    var encryptor := GetEncryptorFromActions(actions);
    TestEncryptRoundTrip(encryptor, "{\"bar\" : \"abc\"}");
    TestEncryptRoundTrip(encryptor, "{\"bar\" : \"abc\", \"encrypt\" : 42}");
  }

}
