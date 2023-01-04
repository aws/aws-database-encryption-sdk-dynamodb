// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../private-aws-encryption-sdk-dafny-staging/StandardLibrary/src/StandardLibrary.dfy"
include "../src/Index.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/ComAmazonawsDynamodb/Model/ComAmazonawsDynamodbTypes.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/AwsCryptographicMaterialProviders/src/Index.dfy"
include "TestFixtures.dfy"

module DynamoDbItemEncryptorTest {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import MaterialProviders
  import DynamoDbItemEncryptor
  import AwsCryptographyMaterialProvidersTypes
  import Types = AwsCryptographyDynamoDbItemEncryptorTypes
  import UTF8
  import DDB = ComAmazonawsDynamodbTypes
  import TestFixtures
  import AwsCryptographyDynamoDbItemEncryptorOperations
  import CSE = AwsCryptographyStructuredEncryptionTypes

  // round trip
  // encrypt => ecrypted fields changed, others did not
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
    expect encryptRes.error == Types.DynamoDbItemEncryptorException(message := "No Crypto Action configured for attribute unknown");
  }

    method {:test} TestRoundTrip() {
    var encryptor := TestFixtures.GetDynamoDbItemEncryptor();
    var inputItem := map["bar" := DDBS("key"), "encrypt" := DDBS("foo"), "sign" := DDBS("bar"), "nothing" := DDBS("baz")];
    var encryptRes := encryptor.EncryptItem(
      Types.EncryptItemInput(
        plaintextItem:=inputItem
      )
    );
    var encrypted :- expect encryptRes;
    var decryptRes := encryptor.DecryptItem(
      Types.DecryptItemInput(
        encryptedItem:=encrypted.encryptedItem
      )
    );
    var decrypted :- expect decryptRes;
    expect decrypted.plaintextItem == inputItem;
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
    expect encryptRes.error == Types.DynamoDbItemEncryptorException(message := "Sort key sort not found in Item to be encrypted or decrypted");
  }

  method {:test} TestEncryptItem() {
    var encryptor := TestFixtures.GetDynamoDbItemEncryptor();
    var inputItem := map[
      "bar" := DDBS("key"),
      "encrypt" := DDBS(TestFixtures.TEST_STRING_TO_ENCRYPT),
      "sign" := DDBS("bar"),
      "nothing" := DDBS("baz")
    ];

    var encryptRes := encryptor.EncryptItem(
      Types.EncryptItemInput(
        plaintextItem:=inputItem
      )
    );

    // Ensure the "encrypted" attribute is as expected
    var expectedItem := map[
      "bar" := DDBS("key"),
      "encrypt" := DDBS(TestFixtures.TEST_FAKE_ENCRYPTED_STRING),
      "sign" := DDBS("bar"),
      "nothing" := DDBS("baz")
    ];

    expect encryptRes.Success?;
    expect encryptRes.value.encryptedItem == expectedItem;
  }

  method {:test} TestDecryptItem() {
    var encryptor := TestFixtures.GetDynamoDbItemEncryptor();
    var inputItem := map[
      "bar" := DDBS("key"),
      "encrypt" := DDBS(TestFixtures.TEST_FAKE_ENCRYPTED_STRING),
      "sign" := DDBS("bar"),
      "nothing" := DDBS("baz")
    ];

    var decryptRes := encryptor.DecryptItem(
      Types.DecryptItemInput(
        encryptedItem:=inputItem
      )
    );

    // Ensure the "encrypted" attribute is "decrypted" as expected
    var expectedItem := map[
      "bar" := DDBS("key"),
      "encrypt" := DDBS(TestFixtures.TEST_STRING_TO_ENCRYPT),
      "sign" := DDBS("bar"),
      "nothing" := DDBS("baz")
    ];

    expect decryptRes.Success?;
    expect decryptRes.value.plaintextItem == expectedItem;
  }
}
