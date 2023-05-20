// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../DynamoDbEncryption/src/Index.dfy"
include "../../DynamoDbEncryptionTransforms/test/TestFixtures.dfy"

module DynamoDbItemEncryptorTest {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened DynamoDbItemEncryptorUtil
  import MaterialProviders
  import DynamoDbItemEncryptor
  import AwsCryptographyMaterialProvidersTypes
  import Types = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import UTF8
  import DDB = ComAmazonawsDynamodbTypes
  import TestFixtures
  import AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations
  import CSE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import SE = StructuredEncryptionUtil
  import DDBE = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import AlgorithmSuites
  import StandardLibrary.String

  // round trip
  // encrypt => encrypted fields changed, others did not
  // various errors

  function method DDBS(x : string) : DDB.AttributeValue {
    DDB.AttributeValue.S(x)
  }

  method {:test} TestUnexpectedField() {
    var encryptor := TestFixtures.GetDynamoDbItemEncryptor();
    var inputItem := map["bar" := DDBS("key"), "encrypt" := DDBS("foo"), "sign" := DDBS("bar"), "nothing" := DDBS("baz"), "unknown" := DDBS("other")];
    var encryptRes := encryptor.EncryptItem(
      Types.EncryptItemInput(
        plaintextItem:=inputItem
      )
    );
    expect encryptRes.Failure?;
    expect encryptRes.error == Types.AwsCryptographyDbEncryptionSdkDynamoDb(
      DDBE.DynamoDbEncryptionException(message := "No Crypto Action configured for attribute unknown"));
  }

  method {:test} TestMissingSortKey() {
    var config := TestFixtures.GetEncryptorConfig();
    var inputItem := map["bar" := DDBS("key"), "encrypt" := DDBS("foo"), "sign" := DDBS("bar"), "nothing" := DDBS("baz")];
    var config2 := config.(
      sortKeyName := Some("sort"),
      attributeActions := config.attributeActions["sort" := CSE.SIGN_ONLY]
    );
    var encryptor := TestFixtures.GetDynamoDbItemEncryptorFrom(config2);
    var encryptRes := encryptor.EncryptItem(
      Types.EncryptItemInput(
        plaintextItem:=inputItem
      )
    );
    expect encryptRes.Failure?;
    expect encryptRes.error == Types.DynamoDbItemEncryptorException(message := "Configuration mismatch partition or sort key does not exist in item.");
  }

  method {:test} TestRoundTrip() {
    var encryptor := TestFixtures.GetDynamoDbItemEncryptor();
    var inputItem := map[
      "bar" := DDBS("key"),
      "encrypt" := DDBS("text"),
      "sign" := DDBS("bar"),
      "nothing" := DDBS("baz")
    ];

    var encryptRes := encryptor.EncryptItem(
      Types.EncryptItemInput(
        plaintextItem:=inputItem
      )
    );

    if encryptRes.Failure? {
      print "\n\n", encryptRes, "\n\n";
    }
    expect encryptRes.Success?;
    expect encryptRes.value.encryptedItem.Keys == inputItem.Keys + {SE.HeaderField, SE.FooterField};
    expect encryptRes.value.encryptedItem["bar"] == inputItem["bar"];
    expect encryptRes.value.encryptedItem["encrypt"] != inputItem["encrypt"];
    expect encryptRes.value.encryptedItem["sign"] == inputItem["sign"];
    expect encryptRes.value.encryptedItem["nothing"] == inputItem["nothing"];

    var decryptRes := encryptor.DecryptItem(
      Types.DecryptItemInput(
        encryptedItem:=encryptRes.value.encryptedItem
      )
    );

    expect decryptRes.Success?;
    expect decryptRes.value.plaintextItem == inputItem;

    var parsedHeader := decryptRes.value.parsedHeader;
    expect parsedHeader.Some?;
    expect parsedHeader.value.algorithmSuiteId == AlgorithmSuites.DBE_ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384.id.DBE;
    expect parsedHeader.value.attributeActions == TestFixtures.GetSignedAttributeActions();
    // Expect the verification key in the context
    expect |parsedHeader.value.storedEncryptionContext| == 1;
    expect UTF8.EncodeAscii("aws-crypto-public-key") in parsedHeader.value.storedEncryptionContext.Keys;
    expect |parsedHeader.value.encryptedDataKeys| == 1;
  }

  method {:test} TestMaxRoundTrip() {
    var inputItem : DDB.AttributeMap := map["bar" := DDBS("key")];
    var actions : DDBE.AttributeActions := map["bar" := CSE.SIGN_ONLY];
    for i := 0 to (MAX_ATTRIBUTE_COUNT-1) {
      var str := String.Base10Int2String(i);
      expect DDB.IsValid_AttributeName(str);
      inputItem := inputItem[str := DDBS(str)];
      actions := actions[str := CSE.ENCRYPT_AND_SIGN];
    }
    var config := TestFixtures.GetEncryptorConfigFromActions(actions);
    var encryptor := TestFixtures.GetDynamoDbItemEncryptorFrom(config);

    var encryptRes := encryptor.EncryptItem(
      Types.EncryptItemInput(
        plaintextItem:=inputItem
      )
    );

    if encryptRes.Failure? {
      print "\n\n", encryptRes, "\n\n";
    }
    expect encryptRes.Success?;
    expect encryptRes.value.encryptedItem.Keys == inputItem.Keys + {SE.HeaderField, SE.FooterField};
    expect "bar" in encryptRes.value.encryptedItem;
    expect "bar" in inputItem;
    expect encryptRes.value.encryptedItem["bar"] == inputItem["bar"];

    var decryptRes := encryptor.DecryptItem(
      Types.DecryptItemInput(
        encryptedItem:=encryptRes.value.encryptedItem
      )
    );

    expect decryptRes.Success?;
    expect decryptRes.value.plaintextItem == inputItem;

    var parsedHeader := decryptRes.value.parsedHeader;
    expect parsedHeader.Some?;
    expect parsedHeader.value.algorithmSuiteId == AlgorithmSuites.DBE_ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384.id.DBE;
    // Expect the verification key in the context
    expect |parsedHeader.value.storedEncryptionContext| == 1;
    expect UTF8.EncodeAscii("aws-crypto-public-key") in parsedHeader.value.storedEncryptionContext.Keys;
    expect |parsedHeader.value.encryptedDataKeys| == 1;
  }

    method {:test} TestTooManyAttributes() {
    var inputItem : DDB.AttributeMap := map["bar" := DDBS("key")];
    var actions : DDBE.AttributeActions := map["bar" := CSE.SIGN_ONLY];
    for i := 0 to MAX_ATTRIBUTE_COUNT {
      var str := String.Base10Int2String(i);
      expect DDB.IsValid_AttributeName(str);
      inputItem := inputItem[str := DDBS(str)];
      actions := actions[str := CSE.ENCRYPT_AND_SIGN];
    }
    var config := TestFixtures.GetEncryptorConfigFromActions(actions);
    var encryptor := TestFixtures.GetDynamoDbItemEncryptorFrom(config);

    var encryptRes := encryptor.EncryptItem(
      Types.EncryptItemInput(
        plaintextItem:=inputItem
      )
    );

    expect encryptRes.Failure?;
    expect encryptRes.error == E("Item to encrypt had 101 attributes, but maximum allowed is 100");
  }
}
