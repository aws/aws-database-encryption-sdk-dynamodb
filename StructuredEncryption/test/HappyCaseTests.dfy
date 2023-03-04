// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "TestFixtures.dfy"
include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/AwsCryptographicMaterialProviders/src/Index.dfy"

// TODO -- add a test with only signed attributes, no encrypted attributes.

module HappyCaseTests {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened AwsCryptographyStructuredEncryptionTypes
  import opened StructuredEncryptionUtil
  import StructuredEncryption
  import AwsCryptographyMaterialProvidersTypes
  import MaterialProviders
  import TestFixtures

  method {:test} TestRoundTrip() {
    var structuredEncryption :-
      expect StructuredEncryption.StructuredEncryption(StructuredEncryption.DefaultStructuredEncryptionConfig());
    var cmm := TestFixtures.GetDefaultCMMWithKMSKeyring();


    assert  && structuredEncryption.ValidState();
    assert && cmm.ValidState();
    assert && cmm.Modifies !! {structuredEncryption.History};
    var encryptRes := structuredEncryption.EncryptStructure(
      EncryptStructureInput(
        tableName := "myTable",
        plaintextStructure := TestFixtures.TEST_STRUCTURED_DATA,
        cryptoSchema := TestFixtures.TEST_CRYPTO_SCHEMA,
        cmm := cmm,
        algorithmSuiteId := None(),
        encryptionContext := None()
      )
    );

    if encryptRes.Failure? {
      print encryptRes;
    }
    expect encryptRes.Success?;
    var newData := encryptRes.value.encryptedStructure.content;
    var testData := TestFixtures.TEST_STRUCTURED_DATA.content;
    expect newData.DataMap?;
    expect testData.DataMap?;
    expect newData.DataMap.Keys == testData.DataMap.Keys + {HeaderField, FooterField};
    expect newData.DataMap["foo"] != testData.DataMap["foo"];
    expect newData.DataMap["bar"] == testData.DataMap["bar"];
    expect newData.DataMap["fizzbuzz"] == testData.DataMap["fizzbuzz"];

    var decryptRes := structuredEncryption.DecryptStructure(
      DecryptStructureInput(
        tableName := "myTable",
        encryptedStructure := encryptRes.value.encryptedStructure,
        authenticateSchema := TestFixtures.TEST_AUTHENTICATE_SCHEMA,
        cmm := cmm,
        encryptionContext := None()
      )
    );

    if decryptRes.Failure? {
      print "\n\n",decryptRes,"\n\n";
    }
    expect decryptRes.Success?;
    var newResult := decryptRes.value.plaintextStructure.content;
    var testResult := TestFixtures.TEST_STRUCTURED_DATA.content;
    expect newResult.DataMap == testResult.DataMap;
  }
}
