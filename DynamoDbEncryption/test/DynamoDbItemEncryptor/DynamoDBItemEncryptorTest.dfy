// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../../submodules/MaterialProviders/StandardLibrary/src/StandardLibrary.dfy"
include "../../../submodules/MaterialProviders/ComAmazonawsDynamodb/Model/ComAmazonawsDynamodbTypes.dfy"
include "../../../submodules/MaterialProviders/AwsCryptographicMaterialProviders/src/Index.dfy"
include "../../src/DynamoDbItemEncryptor/Index.dfy"
include "../TestFixtures.dfy"

module DynamoDbItemEncryptorTest {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import MaterialProviders
  import DynamoDbItemEncryptor
  import AwsCryptographyMaterialProvidersTypes
  import Types = AwsCryptographyDynamoDbEncryptionItemEncryptorTypes
  import UTF8
  import DDB = ComAmazonawsDynamodbTypes
  import TestFixtures
  import AwsCryptographyDynamoDbEncryptionItemEncryptorOperations
  import CSE = AwsCryptographyStructuredEncryptionTypes
  import SE = StructuredEncryptionUtil
  import DDBE = AwsCryptographyDynamoDbEncryptionTypes

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
    expect encryptRes.error == Types.AwsCryptographyDynamoDbEncryption(
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
    expect encryptRes.error == Types.DynamoDbItemEncryptorException(message := "Sort key sort not found in Item to be encrypted or decrypted");
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
  }
}
