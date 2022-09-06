// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../../private-aws-encryption-sdk-dafny-staging/src/StandardLibrary/StandardLibrary.dfy"
include "../src/Index.dfy"
include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"
include "../../../private-aws-encryption-sdk-dafny-staging/src/AwsCryptographicMaterialProviders/src/Index.dfy"

module HappyCaseTests {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened AwsCryptographyStructuredEncryptionTypes
  import StructuredEncryption
  import AwsCryptographyMaterialProvidersTypes
  import MaterialProviders

  const bytesTypeId : seq<uint8> := [0xFF, 0xFF];
  const stubbedBytes : seq<uint8> := [0x21, 0x64, 0x6c, 0x72, 0x6f, 0x77, 0x20, 0x2c, 0x6f, 0x6c, 0x6c, 0x65, 0x68];
  const stubbedStructure := StructuredData(
    content := StructuredDataContent.dataMap(
      StructuredDataMap := map[
        "foo" := StructuredData(
          content := StructuredDataContent.terminal(
              Terminal := Terminal(
                  value := stubbedBytes,
                  typeId := bytesTypeId
              )
          ),
          attributes := None()
        ),
        "bar" := StructuredData(
          content := StructuredDataContent.terminal(
              Terminal := Terminal(
                  value := stubbedBytes,
                  typeId := bytesTypeId
              )
          ),
          attributes := None()
        ),
        "fizzbuzz" := StructuredData(
          content := StructuredDataContent.terminal(
              Terminal := Terminal(
                  value := stubbedBytes,
                  typeId := bytesTypeId
              )
          ),
          attributes := None()
        )
      ]
    ),
    attributes := None()
  );

  method {:test} TestEncryptStructure() {
    var structuredEncryption :-
      expect StructuredEncryption.StructuredEncryption(StructuredEncryption.DefaultStructuredEncryptionConfig());

    // Create keyring. Currently doesn't matter what keyring we create.
    var matProv :- expect MaterialProviders.MaterialProviders(MaterialProviders.DefaultMaterialProvidersConfig());
    var keyringInput := AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMrkMultiKeyringInput(
        generator := Some("arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f"),
        kmsKeyIds := None(),
        clientSupplier := None(),
        grantTokens := None()
    );
    var keyring :- expect matProv.CreateAwsKmsMrkMultiKeyring(keyringInput);
    
    // This method is currently stubbed, so it doesn't matter what our input is
    var inputStructure := StructuredData(
      content := StructuredDataContent.terminal(
        Terminal := Terminal(
          value := stubbedBytes,
          typeId := bytesTypeId
        )
      ),
      attributes := None()
    );
    var schema := CryptoSchema(
      content := CryptoSchemaContent.action(CryptoAction := CryptoAction.ENCRYPT_AND_SIGN),
      attributes := None()
    );

    var encryptRes := structuredEncryption.EncryptStructure(
      EncryptStructureInput(
        plaintextStructure:=inputStructure,
        cryptoSchema:=schema,
        keyring:=Some(keyring),
        cmm:=None(),
        encryptionContext:=None(),
        requiredContextFieldsOnDecrypt:=None()
      )
    );

    expect encryptRes.Success?;
    expect encryptRes.value.ciphertextStructure == stubbedStructure;
  }

  method {:test} TestDecryptStructure() {
    var structuredEncryption :-
      expect StructuredEncryption.StructuredEncryption(StructuredEncryption.DefaultStructuredEncryptionConfig());

    // Create keyring. Currently doesn't matter what keyring we create.
    var matProv :- expect MaterialProviders.MaterialProviders(MaterialProviders.DefaultMaterialProvidersConfig());
    var keyringInput := AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMrkMultiKeyringInput(
        generator := Some("arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f"),
        kmsKeyIds := None(),
        clientSupplier := None(),
        grantTokens := None()
    );
    var keyring :- expect matProv.CreateAwsKmsMrkMultiKeyring(keyringInput);
    
    // This method is currently stubbed, so it doesn't matter what our input is
    var inputStructure := StructuredData(
      content := StructuredDataContent.terminal(
        Terminal := Terminal(
          value := stubbedBytes,
          typeId := bytesTypeId
        )
      ),
      attributes := None()
    );
    var schema := CryptoSchema(
      content := CryptoSchemaContent.action(CryptoAction := CryptoAction.ENCRYPT_AND_SIGN),
      attributes := None()
    );
    var schemaMap := map[];
    schemaMap := schemaMap["0":=schema];

    var decryptRes := structuredEncryption.DecryptStructure(
      DecryptStructureInput(
        ciphertextStructure:=inputStructure,
        cryptoSchemas:=schemaMap,
        keyring:=Some(keyring),
        cmm:=None(),
        encryptionContext:=None()
      )
    );

    expect decryptRes.Success?;
    expect decryptRes.value.plaintextStructure == stubbedStructure;
  }
}
