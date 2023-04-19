// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "StructuredDataTestFixtures.dfy"

// TODO -- add a test with only signed attributes, no encrypted attributes.

module HappyCaseTests {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened AwsCryptographyStructuredEncryptionTypes
  import opened StructuredEncryptionUtil
  import StructuredEncryption
  import AwsCryptographyMaterialProvidersTypes
  import MaterialProviders
  import StructuredDataTestFixtures

  method {:test} TestRoundTrip() {
    var structuredEncryption :-
      expect StructuredEncryption.StructuredEncryption(StructuredEncryption.DefaultStructuredEncryptionConfig());
    var cmm := StructuredDataTestFixtures.GetDefaultCMMWithKMSKeyring();

    var encContext := map[UTF8.EncodeAscii("some") := UTF8.EncodeAscii("value")];
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
    var newData := encryptRes.value.encryptedStructure.content;
    var testData := StructuredDataTestFixtures.TEST_STRUCTURED_DATA.content;
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
        authenticateSchema := StructuredDataTestFixtures.TEST_AUTHENTICATE_SCHEMA,
        cmm := cmm,
        encryptionContext := None()
      )
    );

    if decryptRes.Failure? {
      print "\n\n",decryptRes,"\n\n";
    }
    expect decryptRes.Success?;
    var newResult := decryptRes.value.plaintextStructure.content;
    var testResult := StructuredDataTestFixtures.TEST_STRUCTURED_DATA.content;
    expect newResult.DataMap == testResult.DataMap;

    //= specification/structured-encryption/decrypt-structure.md#construct-decrypted-structured-data
    //= type=test
    //# The output MUST also include a [Parsed Header](#parsed-header) that contains
    //# data that was serialized into the header included in the output Structured Data.

    //= specification/structured-encryption/decrypt-structure.md#parsed-header
    //= type=test
    //# This structure MUST contain the following values,
    //# representing the deserialized form of the header of the input encrypted structure:
    //#   - [Algorithm Suite ID](./header.md#format-flavor): The Algorithm Suite ID associated with the Format Flavor on the header.
    //#   - [Crypto Schema](./header.md#encrypt-legend): The Crypto Schema for each signed Terminal,
    //#     calculated using the Crypto Legend in the header, the signature scope used for decryption, and the data in the input structure.
    //#   - [Stored Encryption Context](./header.md#encryption-context): The Encryption Context stored in the header.
    //#   - [Encrypted Data Keys](./header.md#encrypted-data-keys): The Encrypted Data Keys stored in the header.
    var parsedHeader := decryptRes.value.parsedHeader;
    expect parsedHeader.cryptoSchema == StructuredDataTestFixtures.TEST_CRYPTO_SCHEMA_AUTH_ONLY;
    expect parsedHeader.algorithmSuiteId == algSuiteId;
    expect encContext.Keys <= parsedHeader.storedEncryptionContext.Keys;
    expect forall k <- encContext.Keys :: parsedHeader.storedEncryptionContext[k] == encContext[k];
    expect |parsedHeader.encryptedDataKeys| == 1;
  }
}
