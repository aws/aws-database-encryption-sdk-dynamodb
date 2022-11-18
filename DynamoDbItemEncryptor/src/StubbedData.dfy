// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "../../StructuredEncryption/Model/AwsCryptographyStructuredEncryptionTypes.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/AwsCryptographicMaterialProviders/src/Index.dfy"

// Module containing verbose stubbed data
// TODO remove once we are no longer stubbing data
module StubbedData {
  import opened Wrappers
  import opened StandardLibrary
  import opened UInt = StandardLibrary.UInt
  import opened AwsCryptographyStructuredEncryptionTypes

  const STUBBED_TYPE_ID : seq<uint8> := [0xFF, 0xFF];
  const STUBBED_BLOB_VALUE : seq<uint8> := [0x21, 0x64, 0x6c, 0x72, 0x6f, 0x77, 0x20, 0x2c, 0x6f, 0x6c, 0x6c, 0x65, 0x68];
  const STUBBED_STRUCTURED_DATA := StructuredData(
    content := StructuredDataContent.DataMap(
      StructuredDataMap := map[
        "foo" := StructuredData(
          content := StructuredDataContent.Terminal(
              StructuredDataTerminal := StructuredDataTerminal(
                  value := STUBBED_BLOB_VALUE,
                  typeId := STUBBED_TYPE_ID
              )
          ),
          attributes := None()
        ),
        "bar" := StructuredData(
          content := StructuredDataContent.Terminal(
              StructuredDataTerminal := StructuredDataTerminal(
                  value := STUBBED_BLOB_VALUE,
                  typeId := STUBBED_TYPE_ID
              )
          ),
          attributes := None()
        ),
        "fizzbuzz" := StructuredData(
          content := StructuredDataContent.Terminal(
              StructuredDataTerminal := StructuredDataTerminal(
                  value := STUBBED_BLOB_VALUE,
                  typeId := STUBBED_TYPE_ID
              )
          ),
          attributes := None()
        )
      ]
    ),
    attributes := None()
  );
  const STUBBED_CRYPTO_SCHEMA := CryptoSchema(
    content := CryptoSchemaContent.SchemaMap(
      CryptoSchemaMap := map[
        "foo" := CryptoSchema(
          content := CryptoSchemaContent.Action(
              CryptoAction := CryptoAction.ENCRYPT_AND_SIGN
          ),
          attributes := None()
        ),
        "bar" := CryptoSchema(
          content := CryptoSchemaContent.Action(
              CryptoAction := CryptoAction.SIGN_ONLY
          ),
          attributes := None()
        ),
        "fizzbuzz" := CryptoSchema(
          content := CryptoSchemaContent.Action(
              CryptoAction := CryptoAction.DO_NOTHING
          ),
          attributes := None()
        )
      ]
    ),
    attributes := None()
  );
  const STUBBED_AUTHENTICATE_SCHEMA := AuthenticateSchema(
    content := AuthenticateSchemaContent.SchemaMap(
      AuthenticateSchemaMap := map[
        "foo" := AuthenticateSchema(
          content := AuthenticateSchemaContent.Action(
              AuthenticateAction := AuthenticateAction.SIGN
          ),
          attributes := None()
        ),
        "bar" := AuthenticateSchema(
          content := AuthenticateSchemaContent.Action(
              AuthenticateAction := AuthenticateAction.SIGN
          ),
          attributes := None()
        ),
        "fizzbuzz" := AuthenticateSchema(
          content := AuthenticateSchemaContent.Action(
              AuthenticateAction := AuthenticateAction.DO_NOT_SIGN
          ),
          attributes := None()
        )
      ]
    ),
    attributes := None()
  );
}
