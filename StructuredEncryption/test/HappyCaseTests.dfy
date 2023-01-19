// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "TestFixtures.dfy"
include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/AwsCryptographicMaterialProviders/src/Index.dfy"

// TODO EncryptStructure and DecryptStructure are currently no-ops,
// so the only test cases right now are simple smoke tests
module HappyCaseTests {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened AwsCryptographyStructuredEncryptionTypes
  import StructuredEncryption
  import AwsCryptographyMaterialProvidersTypes
  import MaterialProviders
  import TestFixtures

  method {:test} TestEncryptStructure() {
    var structuredEncryption :-
      expect StructuredEncryption.StructuredEncryption(StructuredEncryption.DefaultStructuredEncryptionConfig());
    var cmm := TestFixtures.GetDefaultCMMWithKMSKeyring();


    assert  && structuredEncryption.ValidState();
    assert && cmm.ValidState();
    assert && cmm.Modifies !! {structuredEncryption.History};
    var encryptRes := structuredEncryption.EncryptStructure(
      EncryptStructureInput(
        plaintextStructure := TestFixtures.TEST_STRUCTURED_DATA,
        cryptoSchema := TestFixtures.TEST_CRYPTO_SCHEMA,
        cmm := cmm,
        encryptionContext := None()
      )
    );

    if encryptRes.Failure? {
      print encryptRes;
    }
    expect encryptRes.Success?;
    // TODO: Right now this just tests expected "fake" encryption
    expect encryptRes.value.encryptedStructure == TestFixtures.TEST_STRUCTURED_DATA_ENCRYPTED;
  }

  method {:test} TestDecryptStructure() {
    var structuredEncryption :-
      expect StructuredEncryption.StructuredEncryption(StructuredEncryption.DefaultStructuredEncryptionConfig());
    var cmm := TestFixtures.GetDefaultCMMWithKMSKeyring();

    var decryptRes := structuredEncryption.DecryptStructure(
      DecryptStructureInput(
        encryptedStructure := TestFixtures.TEST_STRUCTURED_DATA_ENCRYPTED,
        authenticateSchema := TestFixtures.TEST_AUTHENTICATE_SCHEMA,
        cmm := cmm,
        encryptionContext := None()
      )
    );

    expect decryptRes.Success?;
    // TODO: Right now this just tests expected "fake" decryption
    expect decryptRes.value.plaintextStructure == TestFixtures.TEST_STRUCTURED_DATA;
  }
}
