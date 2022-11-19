// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../private-aws-encryption-sdk-dafny-staging/StandardLibrary/src/StandardLibrary.dfy"
include "../src/Index.dfy"
include "../../ComAmazonawsDynamoDb/model/ComAmazonawsDynamodbTypes.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/AwsCryptographicMaterialProviders/src/Index.dfy"

module HappyCaseTests {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import MaterialProviders
  import DynamoDbItemEncryptor
  import AwsCryptographyMaterialProvidersTypes
  import Types = AwsCryptographyDynamoDbItemEncryptorTypes
  import UTF8
  import DDB = ComAmazonawsDynamodbTypes

  const stubbedBytes : seq<uint8> := [0x21, 0x64, 0x6c, 0x72, 0x6f, 0x77, 0x20, 0x2c, 0x6f, 0x6c, 0x6c, 0x65, 0x68];

  method {:test} TestEncryptItem() {
    // Create the Item Encryptor
    var encryptorConfig := Types.DynamoDbItemEncryptorConfig(
      tableName := "foo",
      partitionKeyName := "bar",
      sortKeyName := None(),
      attributeActions := map[],
      allowedUnauthenticatedAttributes := None(),
      allowedUnauthenticatedAttributePrefix := None(),
      keyring := None(),
      cmm := None()
    );
    var encryptor :- expect DynamoDbItemEncryptor.DynamoDbItemEncryptor(encryptorConfig);
    
    // This method is currently stubbed, so it doesn't matter what our input is
    var inputItem := map[];

    var encryptRes := encryptor.EncryptItem(
      Types.EncryptItemInput(
        plaintextItem:=inputItem
      )
    );

    // We know what to expect back from our stubbed data
    var expectedItem := map[
      "foo" := DDB.AttributeValue.B(BinaryAttributeValue:=stubbedBytes),
      "bar" := DDB.AttributeValue.B(BinaryAttributeValue:=stubbedBytes),
      "fizzbuzz" := DDB.AttributeValue.B(BinaryAttributeValue:=stubbedBytes)
    ];

    expect encryptRes.Success?;
    expect encryptRes.value.encryptedItem == expectedItem;
  }

  method {:test} TestDecryptStructure() {
    // Create the Item Encryptor
    var encryptorConfig := Types.DynamoDbItemEncryptorConfig(
      tableName := "foo",
      partitionKeyName := "bar",
      sortKeyName := None(),
      attributeActions := map[],
      allowedUnauthenticatedAttributes := None(),
      allowedUnauthenticatedAttributePrefix := None(),
      keyring := None(),
      cmm := None()
    );
    var encryptor :- expect DynamoDbItemEncryptor.DynamoDbItemEncryptor(encryptorConfig);
    
    // This method is currently stubbed, so it doesn't matter what our input is
    var inputItem := map[];

    var decryptRes := encryptor.DecryptItem(
      Types.DecryptItemInput(
        encryptedItem:=inputItem
      )
    );

    // We know what to expect from our stubbed data
    var expectedItem := map[
      "foo" := DDB.AttributeValue.B(BinaryAttributeValue:=stubbedBytes),
      "bar" := DDB.AttributeValue.B(BinaryAttributeValue:=stubbedBytes),
      "fizzbuzz" := DDB.AttributeValue.B(BinaryAttributeValue:=stubbedBytes)
    ];

    expect decryptRes.Success?;
    expect decryptRes.value.plaintextItem == expectedItem;
  }
}
