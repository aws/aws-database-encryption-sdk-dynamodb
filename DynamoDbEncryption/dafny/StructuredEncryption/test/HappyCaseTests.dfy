// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "StructuredDataTestFixtures.dfy"

module HappyCaseTests {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import opened StructuredEncryptionUtil
  import StructuredEncryption
  import AwsCryptographyMaterialProvidersTypes
  import MaterialProviders
  import StructuredDataTestFixtures

  const some : UTF8.ValidUTF8Bytes :=
    var s := [0x73, 0x6f, 0x6d, 0x65];
    assert s == UTF8.EncodeAscii("some");
    s

  const value : UTF8.ValidUTF8Bytes :=
    var s := [0x76, 0x61, 0x6c, 0x75, 0x65];
    assert s == UTF8.EncodeAscii("value");
    s

  method {:test} TestRoundTrip() {
    var structuredEncryption :-
      expect StructuredEncryption.StructuredEncryption(StructuredEncryption.DefaultStructuredEncryptionConfig());
    var cmm := StructuredDataTestFixtures.GetDefaultCMMWithKMSKeyring();

    var encContext := map[some := value];
    var algSuiteId := AlgorithmSuites.DBE_ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384.id.DBE;

    assert  && structuredEncryption.ValidState();
    assert && cmm.ValidState();
    assert && cmm.Modifies !! {structuredEncryption.History};
    var encryptRes := structuredEncryption.EncryptStructure(
      EncryptStructureInput(
        tableName := "myTable",
        plaintextStructure := StructuredDataTestFixtures.TEST_STRUCTURED_DATA,
        cryptoSchema := StructuredDataTestFixtures.TEST_CRYPTO_SCHEMA,
        cmm := cmm,
        algorithmSuiteId := Some(algSuiteId),
        encryptionContext := Some(encContext)
      )
    );

    if encryptRes.Failure? {
      print encryptRes;
    }
    expect encryptRes.Success?;
    var newData := encryptRes.value.encryptedStructure;
    var testData := StructuredDataTestFixtures.TEST_STRUCTURED_DATA;
    expect newData.Keys == testData.Keys + {HeaderField, FooterField};
    expect newData["foo"] != testData["foo"];
    expect newData["bar"] == testData["bar"];
    expect newData["fizzbuzz"] == testData["fizzbuzz"];

    var decryptRes := structuredEncryption.DecryptStructure(
      DecryptStructureInput(
        tableName := "myTable",
        encryptedStructure := encryptRes.value.encryptedStructure,
        authenticateSchema := StructuredDataTestFixtures.TEST_AUTHENTICATE_SCHEMA,
        cmm := cmm,
        encryptionContext := None()
      )
    );

    if decryptRes.Failure? {
      print "\n\n",decryptRes,"\n\n";
    }
    expect decryptRes.Success?;
    var newResult := decryptRes.value.plaintextStructure;
    var testResult := StructuredDataTestFixtures.TEST_STRUCTURED_DATA;
    expect newResult == testResult;

    //= specification/structured-encryption/decrypt-path-structure.md#construct-decrypted-structured-data
    //= type=test
    //# The output MUST also include a [Parsed Header](#parsed-header) that contains
    //# data that was serialized into the header included in the output Structured Data.

    var parsedHeader := decryptRes.value.parsedHeader;
    expect decryptRes.value.cryptoSchema == StructuredDataTestFixtures.TEST_CRYPTO_SCHEMA_AUTH_ONLY;
    expect parsedHeader.algorithmSuiteId == algSuiteId;
    expect encContext.Keys <= parsedHeader.storedEncryptionContext.Keys;
    expect forall k <- encContext.Keys :: parsedHeader.storedEncryptionContext[k] == encContext[k];
    expect |parsedHeader.encryptedDataKeys| == 1;
  }
}
