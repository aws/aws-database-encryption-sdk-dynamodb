// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"

module StructuredDataTestFixtures {
  import opened Wrappers
  import opened StandardLibrary
  import opened UInt = StandardLibrary.UInt
  import opened AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import opened StructuredEncryptionUtil
  import MaterialProviders
  import AwsCryptographyMaterialProvidersTypes

  const TEST_TYPE_ID : seq<uint8> := [0xFF, 0xFF]
  const TEST_BLOB_VALUE : seq<uint8> := [0x21, 0x64, 0x6c, 0x72, 0x6f, 0x77, 0x20, 0x2c, 0x6f, 0x6c, 0x6c, 0x65, 0x68]

  const TEST_STRUCTURED_DATA : StructuredDataMap :=
    map[
      "foo" := StructuredDataTerminal(
        value := TEST_BLOB_VALUE,
        typeId := TEST_TYPE_ID
      ),
      "bar" := StructuredDataTerminal(
        value := TEST_BLOB_VALUE,
        typeId := TEST_TYPE_ID
      ),
      "fizzbuzz" := StructuredDataTerminal(
        value := TEST_BLOB_VALUE,
        typeId := TEST_TYPE_ID
      )
    ]

  const TEST_CRYPTO_SCHEMA : CryptoSchemaMap :=
    map[
      "foo" := CryptoAction.ENCRYPT_AND_SIGN,
      "bar" := CryptoAction.SIGN_ONLY,
      "fizzbuzz" := CryptoAction.DO_NOTHING
    ]
  const TEST_CRYPTO_SCHEMA_AUTH_ONLY : CryptoSchemaMap :=
    map[
      "foo" := CryptoAction.ENCRYPT_AND_SIGN,
      "bar" := CryptoAction.SIGN_ONLY
    ]

  const TEST_AUTHENTICATE_SCHEMA : AuthenticateSchemaMap :=
    map[
      "foo" := SIGN,
      "bar" := SIGN,
      "fizzbuzz" := DO_NOT_SIGN,
      "aws_dbe_head" := DO_NOT_SIGN,
      "aws_dbe_foot" := DO_NOT_SIGN
    ]

  const PUBLIC_US_WEST_2_KMS_TEST_KEY := "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f"

  method GetDefaultCMMWithKMSKeyring()
    returns (cmm: AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager)
    ensures cmm.ValidState()
    ensures fresh(cmm)
    ensures fresh(cmm.Modifies)
  {
    var matProv :- expect MaterialProviders.MaterialProviders(MaterialProviders.DefaultMaterialProvidersConfig());
    var keyringInput := AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMultiKeyringInput(
      generator := Some(PUBLIC_US_WEST_2_KMS_TEST_KEY),
      kmsKeyIds := None(),
      clientSupplier := None(),
      grantTokens := None()
    );
    var keyring :- expect matProv.CreateAwsKmsMultiKeyring(keyringInput);
    var cmmInput := AwsCryptographyMaterialProvidersTypes.CreateDefaultCryptographicMaterialsManagerInput(
      keyring := keyring
    );
    cmm :- expect matProv.CreateDefaultCryptographicMaterialsManager(cmmInput);
  }
}
