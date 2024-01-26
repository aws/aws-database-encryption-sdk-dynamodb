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
    attributeActionsOnEncrypt := config.attributeActionsOnEncrypt["sort" := CSE.SIGN_ONLY]
    );
    var encryptor := TestFixtures.GetDynamoDbItemEncryptorFrom(config2);
    var encryptRes := encryptor.EncryptItem(
      Types.EncryptItemInput(
        plaintextItem:=inputItem
      )
    );
    expect encryptRes.Failure?;
    expect encryptRes.error == Types.DynamoDbItemEncryptorException(
                                 message := "On Encrypt : Sort key 'sort' does not exist in item. Item contains these attributes : bar encrypt nothing sign."
                               );
  }

  method {:test} TestV2RoundTrip2() {
    var actions := map[
      "bar" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
      "sortKey" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
      "encrypt" := CSE.ENCRYPT_AND_SIGN,
      "sign" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
      "sign2" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
      "sign3" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
      "sign4" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
      "nothing" := CSE.DO_NOTHING
    ];
    var config := TestFixtures.GetEncryptorConfigFromActions(actions, Some("sortKey"));
    var encryptor := TestFixtures.GetDynamoDbItemEncryptorFrom(config);

    var inputItem := map[
      "bar" := DDB.AttributeValue.N("1234"),
      "sortKey" := DDB.AttributeValue.B([1,2,3,4]),
      "encrypt" := DDBS("text"),
      "sign" := DDB.AttributeValue.BOOL(true),
      "sign3" := DDB.AttributeValue.BOOL(false),
      "sign4" := DDB.AttributeValue.NULL(true),
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
    expect encryptRes.value.encryptedItem["sign3"] == inputItem["sign3"];
    expect encryptRes.value.encryptedItem["sign4"] == inputItem["sign4"];
    expect encryptRes.value.encryptedItem["nothing"] == inputItem["nothing"];

    var decryptRes := encryptor.DecryptItem(
      Types.DecryptItemInput(
        encryptedItem:=encryptRes.value.encryptedItem
      )
    );

    if decryptRes.Failure? {
      print "\n", decryptRes.error, "\n";
    }
    expect decryptRes.Success?;
    if decryptRes.value.plaintextItem != inputItem {
      print "\nInput Item :\n", inputItem, "\n";
      print "\nOutput Item :\n", decryptRes.value.plaintextItem, "\n";
    }
    expect decryptRes.value.plaintextItem == inputItem;

    var parsedHeader := decryptRes.value.parsedHeader;
    expect parsedHeader.Some?;
    expect parsedHeader.value.algorithmSuiteId == AlgorithmSuites.DBE_ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384.id.DBE;
    expect parsedHeader.value.attributeActionsOnEncrypt == actions - {"nothing", "sign2"};
    // Expect the verification key in the context
    expect |parsedHeader.value.storedEncryptionContext| == 1;
    expect UTF8.EncodeAscii("aws-crypto-public-key") in parsedHeader.value.storedEncryptionContext.Keys;
    expect |parsedHeader.value.encryptedDataKeys| == 1;

    var strEC := SE.EcAsString(parsedHeader.value.encryptionContext);
    expect "aws-crypto-public-key" in strEC.Keys;
    strEC := strEC - {"aws-crypto-public-key"};    
    expect strEC == map[
      "aws-crypto-legend" := "NLLLB",
      "aws-crypto-attr.bar" := "1234",
      "aws-crypto-attr.sortKey" := "//8BAgME",
      "aws-crypto-attr.sign" := "true",
      "aws-crypto-attr.sign3" := "false",
      "aws-crypto-attr.sign4" := "null",
      "aws-crypto-partition-name" := "bar",
      "aws-crypto-sort-name" := "sortKey",
      "aws-crypto-table-name" := "foo"
    ];
    expect parsedHeader.value.selectorContext == map[
      "bar" := DDB.AttributeValue.N("1234"),
      "sortKey" := DDB.AttributeValue.B([1,2,3,4]),
      "sign" := DDB.AttributeValue.BOOL(true),
      "sign3" := DDB.AttributeValue.BOOL(false),
      "sign4" := DDB.AttributeValue.NULL(true),

      "aws_dbe_table_name" := DDB.AttributeValue.S("foo"),
      "aws_dbe_partition_name" := DDB.AttributeValue.S("bar"),
      "aws_dbe_sort_name" := DDB.AttributeValue.S("sortKey")
      ];
  }

  method {:test} TestV2RoundTrip() {
    var actions := TestFixtures.GetV2AttributeActions();
    var config := TestFixtures.GetEncryptorConfigFromActions(actions);
    var encryptor := TestFixtures.GetDynamoDbItemEncryptorFrom(config);

    var inputItem := map[
      "bar" := DDBS("key"),
      "encrypt" := DDBS("text"),
      "sign" := DDBS("barsoom"),
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

    if decryptRes.Failure? {
      print "\n", decryptRes.error, "\n";
    }
    expect decryptRes.Success?;
    if decryptRes.value.plaintextItem != inputItem {
      print "\nInput Item :\n", inputItem, "\n";
      print "\nOutput Item :\n", decryptRes.value.plaintextItem, "\n";
    }
    expect decryptRes.value.plaintextItem == inputItem;

    var parsedHeader := decryptRes.value.parsedHeader;
    expect parsedHeader.Some?;
    expect parsedHeader.value.algorithmSuiteId == AlgorithmSuites.DBE_ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384.id.DBE;
    expect parsedHeader.value.attributeActionsOnEncrypt == actions - {"nothing"};
    // Expect the verification key in the context
    expect |parsedHeader.value.storedEncryptionContext| == 1;
    expect UTF8.EncodeAscii("aws-crypto-public-key") in parsedHeader.value.storedEncryptionContext.Keys;
    expect |parsedHeader.value.encryptedDataKeys| == 1;

    var strEC := SE.EcAsString(parsedHeader.value.encryptionContext);
    expect "aws-crypto-public-key" in strEC.Keys;
    strEC := strEC - {"aws-crypto-public-key"};
    expect strEC == map[
      "aws-crypto-legend" := "SS",
      "aws-crypto-attr.bar" := "key",
      "aws-crypto-attr.sign" := "barsoom",
      "aws-crypto-partition-name" := "bar",
      "aws-crypto-table-name" := "foo"
    ];
    expect parsedHeader.value.selectorContext == map[
      "bar" := DDB.AttributeValue.S("key"),
      "sign" := DDB.AttributeValue.S("barsoom"),
      "aws_dbe_table_name" := DDB.AttributeValue.S("foo"),
      "aws_dbe_partition_name" := DDB.AttributeValue.S("bar")
      ];
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
    expect parsedHeader.value.attributeActionsOnEncrypt == TestFixtures.GetSignedAttributeActions();
    // Expect the verification key in the context
    expect |parsedHeader.value.storedEncryptionContext| == 1;
    expect UTF8.EncodeAscii("aws-crypto-public-key") in parsedHeader.value.storedEncryptionContext.Keys;
    expect |parsedHeader.value.encryptedDataKeys| == 1;

    var strEC := SE.EcAsString(parsedHeader.value.encryptionContext);
    expect "aws-crypto-public-key" in strEC.Keys;
    strEC := strEC - {"aws-crypto-public-key"};
    expect strEC == map[
      "aws-crypto-attr.bar" := "AAFrZXk=",
      "aws-crypto-partition-name" := "bar",
      "aws-crypto-table-name" := "foo"
    ];
    expect parsedHeader.value.selectorContext == map["bar" := DDB.AttributeValue.S("key")];
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
