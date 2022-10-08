// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../../private-aws-encryption-sdk-dafny-staging/src/StandardLibrary/StandardLibrary.dfy"
include "../../../private-aws-encryption-sdk-dafny-staging/src/Util/UTF8.dfy"
include "../src/Index.dfy"
include "../model/AwsCryptographyDynamodbEncryptionTypes.dfy"
include "../../AWS-DDB/model/ComAmazonawsDynamodbTypes.dfy"
include "../../../private-aws-encryption-sdk-dafny-staging/src/AwsCryptographicMaterialProviders/src/Index.dfy"

module HappyCaseTests {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import MaterialProviders
  import DynamoDBEncryption
  import AwsCryptographyMaterialProvidersTypes
  import Types = AwsCryptographyDynamodbEncryptionTypes
  import UTF8
  import DDB = ComAmazonawsDynamodbTypes

  const stubbedBytes : seq<uint8> := [0x21, 0x64, 0x6c, 0x72, 0x6f, 0x77, 0x20, 0x2c, 0x6f, 0x6c, 0x6c, 0x65, 0x68];

  method {:test} TestEncryptItem() {
    var encryptorConfig := Types.DynamoDBEncryptionConfig(
      tableConfigs := map["tableName" := Types.DynamoDBTableEncryptionConfig(
        partitionKeyName := "partition_key",
        sortKeyName := Some("sort_key")
      )]
    );
    var encryptor :- expect DynamoDBEncryption.DynamoDBEncryption(encryptorConfig);

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
    var inputItem := map[];
    var schema := map[];

    var encryptRes := encryptor.EncryptItem(
      Types.EncryptItemInput(
        item:=inputItem,
        cryptoSchema:=schema,
        encryptionContext:=None(),
        requiredContextFieldsOnDecrypt:=None(),
        keyring:=Some(keyring),
        cmm:=None()
      )
    );

    var expectedItem := map[
      "foo" := DDB.AttributeValue.B(BinaryAttributeValue:=stubbedBytes),
      "bar" := DDB.AttributeValue.B(BinaryAttributeValue:=stubbedBytes),
      "fizzbuzz" := DDB.AttributeValue.B(BinaryAttributeValue:=stubbedBytes)
    ];

    expect encryptRes.Success?;
    expect encryptRes.value.encryptedItem == expectedItem;
  }

  method {:test} TestDecryptStructure() {
    var encryptorConfig := Types.DynamoDBEncryptionConfig(
      tableConfigs := map["tableName" := Types.DynamoDBTableEncryptionConfig(
        partitionKeyName := "partition_key",
        sortKeyName := Some("sort_key")
      )]
    );
    var encryptor :- expect DynamoDBEncryption.DynamoDBEncryption(encryptorConfig);

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
    var inputItem := map[];

    var decryptRes := encryptor.DecryptItem(
      Types.DecryptItemInput(
        encryptedItem:=inputItem,
        encryptionContext:=None(),
        keyring:=Some(keyring),
        cmm:=None()
      )
    );

    var expectedItem := map[
      "foo" := DDB.AttributeValue.B(BinaryAttributeValue:=stubbedBytes),
      "bar" := DDB.AttributeValue.B(BinaryAttributeValue:=stubbedBytes),
      "fizzbuzz" := DDB.AttributeValue.B(BinaryAttributeValue:=stubbedBytes)
    ];

    expect decryptRes.Success?;
    expect decryptRes.value.item == expectedItem;
  }
}
