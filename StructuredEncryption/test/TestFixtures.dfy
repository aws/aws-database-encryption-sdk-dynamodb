// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/AwsCryptographicMaterialProviders/src/Index.dfy"

module TestFixtures {
  import opened Wrappers
  import opened StandardLibrary
  import opened UInt = StandardLibrary.UInt
  import opened AwsCryptographyStructuredEncryptionTypes
  import MaterialProviders
  import AwsCryptographyMaterialProvidersTypes

  const TEST_TYPE_ID : seq<uint8> := [0xFF, 0xFF];
  const TEST_BLOB_VALUE : seq<uint8> := [0x21, 0x64, 0x6c, 0x72, 0x6f, 0x77, 0x20, 0x2c, 0x6f, 0x6c, 0x6c, 0x65, 0x68];
  const TEST_STRUCTURED_DATA := StructuredData(
    content := StructuredDataContent.DataMap(
      DataMap := map[
        "foo" := StructuredData(
          content := StructuredDataContent.Terminal(
              Terminal := StructuredDataTerminal(
                  value := TEST_BLOB_VALUE,
                  typeId := TEST_TYPE_ID
              )
          ),
          attributes := None()
        ),
        "bar" := StructuredData(
          content := StructuredDataContent.Terminal(
              Terminal := StructuredDataTerminal(
                  value := TEST_BLOB_VALUE,
                  typeId := TEST_TYPE_ID
              )
          ),
          attributes := None()
        ),
        "fizzbuzz" := StructuredData(
          content := StructuredDataContent.Terminal(
              Terminal := StructuredDataTerminal(
                  value := TEST_BLOB_VALUE,
                  typeId := TEST_TYPE_ID
              )
          ),
          attributes := None()
        )
      ]
    ),
    attributes := None()
  );
  const TEST_CRYPTO_SCHEMA := CryptoSchema(
    content := CryptoSchemaContent.SchemaMap(
      SchemaMap := map[
        "foo" := CryptoSchema(
          content := CryptoSchemaContent.Action(
              Action := CryptoAction.ENCRYPT_AND_SIGN
          ),
          attributes := None()
        ),
        "bar" := CryptoSchema(
          content := CryptoSchemaContent.Action(
              Action := CryptoAction.SIGN_ONLY
          ),
          attributes := None()
        ),
        "fizzbuzz" := CryptoSchema(
          content := CryptoSchemaContent.Action(
              Action := CryptoAction.DO_NOTHING
          ),
          attributes := None()
        )
      ]
    ),
    attributes := None()
  );
  const TEST_AUTHENTICATE_SCHEMA := AuthenticateSchema(
    content := AuthenticateSchemaContent.SchemaMap(
      SchemaMap := map[
        "foo" := AuthenticateSchema(
          content := AuthenticateSchemaContent.Action(
              Action := AuthenticateAction.SIGN
          ),
          attributes := None()
        ),
        "bar" := AuthenticateSchema(
          content := AuthenticateSchemaContent.Action(
              Action := AuthenticateAction.SIGN
          ),
          attributes := None()
        ),
        "fizzbuzz" := AuthenticateSchema(
          content := AuthenticateSchemaContent.Action(
              Action := AuthenticateAction.DO_NOT_SIGN
          ),
          attributes := None()
        )
      ]
    ),
    attributes := None()
  );
  const PUBLIC_US_WEST_2_KMS_TEST_KEY := "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f";

  method GetDefaultCMMWithKMSKeyring()
      returns (cmm: AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager)
    ensures cmm.ValidState(); 
    ensures fresh(cmm); 
    ensures fresh(cmm.Modifies); 
  {
    var matProv :- expect MaterialProviders.MaterialProviders(MaterialProviders.DefaultMaterialProvidersConfig());
    var keyringInput := AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMrkMultiKeyringInput(
        generator := Some(PUBLIC_US_WEST_2_KMS_TEST_KEY),
        kmsKeyIds := None(),
        clientSupplier := None(),
        grantTokens := None()
    );
    var keyring :- expect matProv.CreateAwsKmsMrkMultiKeyring(keyringInput);
        var cmmInput := AwsCryptographyMaterialProvidersTypes.CreateDefaultCryptographicMaterialsManagerInput(
        keyring := keyring
    );
    cmm :- expect matProv.CreateDefaultCryptographicMaterialsManager(cmmInput);
  }
}
