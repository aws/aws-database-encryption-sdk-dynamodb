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

  const PublicKeyUtf8 : UTF8.ValidUTF8Bytes :=
    var s := [0x61, 0x77, 0x73, 0x2d, 0x63, 0x72, 0x79, 0x70, 0x74, 0x6f, 0x2d, 0x70, 0x75, 0x62, 0x6c, 0x69, 0x63, 0x2d, 0x6b, 0x65, 0x79];
    assert s == UTF8.EncodeAscii("aws-crypto-public-key");
    s

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

  function method {:opaque} GetAttrName(s : string) : DDB.AttributeName
  {
    if DDB.IsValid_AttributeName(s) then
      s
    else
      "spoo"
  }

  const Actions1 : DDBE.AttributeActions := map[
                                              "bar" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
                                              "sortKey" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
                                              "encrypt" := CSE.ENCRYPT_AND_SIGN,
                                              "sign" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
                                              "sign2" := CSE.SIGN_ONLY,
                                              "sign3" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
                                              "sign4" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
                                              "nothing" := CSE.DO_NOTHING
                                            ]

  const Actions2 : DDBE.AttributeActions := map[
                                              GetAttrName("bar") := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
                                              GetAttrName("sortKey") := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
                                              GetAttrName("encrypt") := CSE.ENCRYPT_AND_SIGN,
                                              GetAttrName("sign") := CSE.SIGN_ONLY,
                                              GetAttrName("sign2") := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
                                              GetAttrName("sign3") := CSE.SIGN_ONLY,
                                              GetAttrName("sign4") := CSE.SIGN_ONLY,
                                              GetAttrName("nothing") := CSE.DO_NOTHING
                                            ]

  method {:test} TestV2RoundTripComplexSwitch() {
    var config := TestFixtures.GetEncryptorConfigFromActions(Actions1, Some("sortKey"));
    var encryptor := TestFixtures.GetDynamoDbItemEncryptorFrom(config);

    var inputItem : map<DDB.AttributeName, DDB.AttributeValue> := map[
      "bar" := DDB.AttributeValue.N("00001234"),
      "sortKey" := DDB.AttributeValue.B([1,2,3,4]),
      "encrypt" := DDBS("text"),
      "sign" := DDB.AttributeValue.BOOL(true),
      "sign3" := DDB.AttributeValue.BOOL(false),
      "sign4" := DDB.AttributeValue.NULL(true),
      "nothing" := DDBS("baz")
    ];
    var expectedOutputItem := inputItem["bar" := DDB.AttributeValue.N("1234")];

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
    expect encryptRes.value.encryptedItem["bar"] == expectedOutputItem["bar"]; // because normalized
    expect encryptRes.value.encryptedItem["encrypt"] != inputItem["encrypt"];
    expect encryptRes.value.encryptedItem["sign"] == inputItem["sign"];
    expect encryptRes.value.encryptedItem["sign3"] == inputItem["sign3"];
    expect encryptRes.value.encryptedItem["sign4"] == inputItem["sign4"];
    expect encryptRes.value.encryptedItem["nothing"] == inputItem["nothing"];

    var config2 := TestFixtures.GetEncryptorConfigFromActions(Actions2, Some("sortKey"));
    var encryptor2 := TestFixtures.GetDynamoDbItemEncryptorFrom(config2);

    var decryptRes := encryptor2.DecryptItem(
      Types.DecryptItemInput(
        encryptedItem:=encryptRes.value.encryptedItem
      )
    );

    if decryptRes.Failure? {
      print "\n", decryptRes.error, "\n";
    }
    expect decryptRes.Success?;
    if decryptRes.value.plaintextItem != expectedOutputItem {
      print "\nexpectedOutputItem :\n", expectedOutputItem, "\n";
      print "\nOutput Item :\n", decryptRes.value.plaintextItem, "\n";
    }
    expect decryptRes.value.plaintextItem == expectedOutputItem;

    var parsedHeader := decryptRes.value.parsedHeader;
    expect parsedHeader.Some?;
    expect parsedHeader.value.algorithmSuiteId == AlgorithmSuites.DBE_ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384.id.DBE;
    expect parsedHeader.value.attributeActionsOnEncrypt == Actions1 - {"nothing", "sign2"};
    // Expect the verification key in the context
    expect |parsedHeader.value.storedEncryptionContext| == 1;
    expect PublicKeyUtf8 in parsedHeader.value.storedEncryptionContext.Keys;
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
    expect parsedHeader.value.selectorContext ==
           map[
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


  method {:test} TestV2RoundTripComplex() {
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
    // only one item in the stored context shows that the CMM was properly constructed
    //= specification/structured-encryption/encrypt-path-structure.md#create-new-encryption-context-and-cmm
    //= type=test
    //# Then, this operation MUST create a [Required Encryption Context CMM](https://github.com/awslabs/private-aws-encryption-sdk-specification-staging/blob/dafny-verified/framework/required-encryption-context-cmm.md)
    //# with the following inputs:
    expect |parsedHeader.value.storedEncryptionContext| == 1;
    expect PublicKeyUtf8 in parsedHeader.value.storedEncryptionContext.Keys;
    expect |parsedHeader.value.encryptedDataKeys| == 1;

    var strEC := SE.EcAsString(parsedHeader.value.encryptionContext);
    expect "aws-crypto-public-key" in strEC.Keys;
    strEC := strEC - {"aws-crypto-public-key"};


    //= specification/dynamodb-encryption-client/encrypt-item.md#base-context-value-version-2
    //= type=test
    //# The value MUST be :
    //# - If the type is Number or String, the unaltered (already utf8) bytes of the value
    //# - If the type if Null, the string "null"
    //# - If the type is Boolean, then the string "true" for true and the string "false" for false.
    //# - Else, the value as defined in [Base Context Value Version 1](#base-context-value-version-1)

    //= specification/structured-encryption/encrypt-path-structure.md#create-new-encryption-context-and-cmm
    //= type=test
    //# Otherwise, this operation MUST add an [entry](../dynamodb-encryption-client/encrypt-item.md#base-context-value-version-2) to the encryption context for every
    //# [SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT Crypto Action](./structures.md#sign_and_include_in_encryption_context)
    //# [Terminal Data](./structures.md#terminal-data)
    //# in the input record, plus the Legend.

    //= specification/structured-encryption/encrypt-path-structure.md#create-new-encryption-context-and-cmm
    //= type=test
    //# The Legend MUST be named "aws-crypto-legend" and be a string with one character per attribute added above,
    //# with a one-to-one correspondence with the attributes sorted by their UTF8 encoding,
    //# each character designating the original type of the attribute,
    //# to allow reversing of the [encoding](../dynamodb-encryption-client/encrypt-item.md#base-context-value-version-2).
    //# - 'S' if the attribute was of type String
    //# - 'N' if the attribute was of type Number
    //# - 'L' if the attribute was of type Null or Boolean
    //# - 'B' otherwise
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
    expect parsedHeader.value.selectorContext ==
           map[
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

  method {:test} TestMissingContext() {
    var actions := TestFixtures.GetV2AttributeActions();
    var config := TestFixtures.GetEncryptorConfigFromActions(actions);
    var encryptor := TestFixtures.GetDynamoDbItemEncryptorFrom(config);

    var inputItem := map[
      "bar" := DDBS("key"),
      "encrypt" := DDBS("text"),
      "nothing" := DDBS("baz")
    ];

    var encryptRes := encryptor.EncryptItem(
      Types.EncryptItemInput(
        plaintextItem:=inputItem
      )
    );
    expect encryptRes.Failure?;
    expect encryptRes.error == E("Attribute sign was configured with SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT but was not present in item to be encrypted.");
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
    expect PublicKeyUtf8 in parsedHeader.value.storedEncryptionContext.Keys;
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

  method {:test} TestV2RoundTripSpecial() {
    var actions : DDBE.AttributeActions :=
      map [
        "bar" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
        "a.b" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
        ".a" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
        "a." := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
        ".a." := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
        "a[2]" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
        "a#b" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
        "$" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
        "$a" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
        "$a.b" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
        "$[a]" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
        "$['a']" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
        "$[\"a\"]" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
        "(a)" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
        "$['" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
        "$'a'" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
        "$\"a\"" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
        "$(a)" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
        "$(a" := CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT

      ];
    var config := TestFixtures.GetEncryptorConfigFromActions(actions);
    var encryptor := TestFixtures.GetDynamoDbItemEncryptorFrom(config);

    var inputItem := map[
      "bar" := DDBS("key"),
      "a.b" := DDBS("aaa"),
      ".a" := DDBS("bbb"),
      "a." := DDBS("ccc"),
      ".a." := DDBS("ddd"),
      "a[2]" := DDBS("eee"),
      "a#b" := DDBS("fff"),
      "$" := DDBS("ggg"),
      "$a" := DDBS("hhh"),
      "$a.b" := DDBS("iii"),
      "$[a]" := DDBS("jjj"),
      "$['a']" := DDBS("kkk"),
      "$[\"a\"]" := DDBS("lll"),
      "(a)" := DDBS("mmm"),
      "$['" := DDBS("nnn"),
      "$'a'" := DDBS("ooo"),
      "$\"a\"" := DDBS("ppp"),
      "$(a)" := DDBS("qqq"),
      "$(a" := DDBS("rrr")
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
    var smallEncrypted := encryptRes.value.encryptedItem - {SE.HeaderField, SE.FooterField};
    expect smallEncrypted == inputItem;

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
    expect PublicKeyUtf8 in parsedHeader.value.storedEncryptionContext.Keys;
    expect |parsedHeader.value.encryptedDataKeys| == 1;

    var strEC := SE.EcAsString(parsedHeader.value.encryptionContext);
    expect "aws-crypto-public-key" in strEC.Keys;
    strEC := strEC - {"aws-crypto-public-key"};
    expect strEC ==
           map[
             "aws-crypto-legend" := "SSSSSSSSSSSSSSSSSSS",
             "aws-crypto-attr.bar" := "key",
             "aws-crypto-attr.a.b" := "aaa",
             "aws-crypto-attr..a" := "bbb",
             "aws-crypto-attr.a." := "ccc",
             "aws-crypto-attr..a." := "ddd",
             "aws-crypto-attr.a[2]" := "eee",
             "aws-crypto-attr.a#b" := "fff",
             "aws-crypto-attr.$" := "ggg",
             "aws-crypto-attr.$a" := "hhh",
             "aws-crypto-attr.$a.b" := "iii",
             "aws-crypto-attr.$[a]" := "jjj",
             "aws-crypto-attr.$['a']" := "kkk",
             "aws-crypto-attr.$[\"a\"]" := "lll",
             "aws-crypto-attr.(a)" := "mmm",
             "aws-crypto-attr.$['" := "nnn",
             "aws-crypto-attr.$'a'" := "ooo",
             "aws-crypto-attr.$\"a\"" := "ppp",
             "aws-crypto-attr.$(a)" := "qqq",
             "aws-crypto-attr.$(a" := "rrr",
             "aws-crypto-partition-name" := "bar",
             "aws-crypto-table-name" := "foo"
           ];
    expect parsedHeader.value.selectorContext ==
           map[
             "bar" := DDBS("key"),
             "a.b" := DDBS("aaa"),
             ".a" := DDBS("bbb"),
             "a." := DDBS("ccc"),
             ".a." := DDBS("ddd"),
             "a[2]" := DDBS("eee"),
             "a#b" := DDBS("fff"),
             "$" := DDBS("ggg"),
             "$a" := DDBS("hhh"),
             "$a.b" := DDBS("iii"),
             "$[a]" := DDBS("jjj"),
             "$['a']" := DDBS("kkk"),
             "$[\"a\"]" := DDBS("lll"),
             "(a)" := DDBS("mmm"),
             "$['" := DDBS("nnn"),
             "$'a'" := DDBS("ooo"),
             "$\"a\"" := DDBS("ppp"),
             "$(a)" := DDBS("qqq"),
             "$(a" := DDBS("rrr"),
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
    expect PublicKeyUtf8 in parsedHeader.value.storedEncryptionContext.Keys;
    expect |parsedHeader.value.encryptedDataKeys| == 1;

    //= specification/structured-encryption/encrypt-path-structure.md#create-new-encryption-context-and-cmm
    //= type=test
    //# If no [Crypto Action](./structures.md#crypto-action) is configured to be
    //# [SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT Crypto Action](./structures.md#sign_and_include_in_encryption_context)
    //# then the input cmm and encryption context MUST be used unchanged.
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
    expect PublicKeyUtf8 in parsedHeader.value.storedEncryptionContext.Keys;
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
