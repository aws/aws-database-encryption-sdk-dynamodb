// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../Model/AwsCryptographyDynamoDbItemEncryptorTypes.dfy"
include "StubbedData.dfy"

module AwsCryptographyDynamoDbItemEncryptorOperations refines AbstractAwsCryptographyDynamoDbItemEncryptorOperations {
  import ComAmazonawsDynamodbTypes
  import AwsCryptographyMaterialProvidersTypes
  import StructuredEncryption
  import StubbedData

  datatype Config = Config(
    nameonly tableName: ComAmazonawsDynamodbTypes.TableName,
    nameonly partitionKeyName: ComAmazonawsDynamodbTypes.KeySchemaAttributeName,
    nameonly sortKeyName: Option<ComAmazonawsDynamodbTypes.KeySchemaAttributeName>,
    nameonly cmm: AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager,
    nameonly attributeActions: AttributeActions,
    nameonly allowedUnauthenticatedAttributes: Option<ComAmazonawsDynamodbTypes.AttributeNameList>,
    nameonly allowedUnauthenticatedAttributePrefix: Option<string>,
    nameonly structuredEncryption: StructuredEncryption.StructuredEncryptionClient
    // TODO algorithmSuite
    // TODO legacy encryptor
    // TODO legacy schema
  )

  type InternalConfig = Config

  predicate ValidInternalConfig?(config: InternalConfig)
  {
    && config.cmm.ValidState()
    && config.structuredEncryption.ValidState()
    && config.cmm.Modifies !! config.structuredEncryption.Modifies
  }

  function ModifiesInternalConfig(config: InternalConfig) : set<object>
  {
    config.cmm.Modifies
    + config.structuredEncryption.Modifies
  }

  predicate EncryptItemEnsuresPublicly(input: EncryptItemInput, output: Result<EncryptItemOutput, Error>)
  {true}

  method EncryptItem(config: InternalConfig, input: EncryptItemInput)
      returns (output: Result<EncryptItemOutput, Error>)
  {
    // TODO transform our input DDB item into a Structure the SEL can understand.
    // TODO transform attributeActions into a CryptoSchema that the SEL can understand
    // For now, just pass some stubbed input
    var plaintextStructure := StubbedData.STUBBED_STRUCTURED_DATA;
    var cryptoSchema := StubbedData.STUBBED_CRYPTO_SCHEMA;

    // Use the structured encryption client to decrypt the item.
    var encryptRes := config.structuredEncryption.EncryptStructure(
      AwsCryptographyStructuredEncryptionTypes.EncryptStructureInput(
        plaintextStructure:=plaintextStructure,
        cryptoSchema:=cryptoSchema,
        cmm:=config.cmm,
        encryptionContext:=None()
      )
    );
    // TODO properly convert error and bubble up message
    :- Need(encryptRes.Success?,
      Error.DynamoDbItemEncryptorException(
        message := "Failed to encrypt item."));
    var encryptedData := encryptRes.value.encryptedStructure;

    // TODO convert the encrypted structure back into a DDB item.
    // For now we use knowledge of the expected output 
    // (StructuredEncryption.DecryptStructure is just a passthrough)
    // to quickly construct a related DDB item.
    expect encryptedData.content.DataMap?;
    expect "foo" in encryptedData.content.StructuredDataMap;
    expect "bar" in encryptedData.content.StructuredDataMap;
    expect "fizzbuzz" in encryptedData.content.StructuredDataMap;
    expect encryptedData.content.StructuredDataMap["foo"].content.Terminal?;
    expect encryptedData.content.StructuredDataMap["bar"].content.Terminal?;
    expect encryptedData.content.StructuredDataMap["fizzbuzz"].content.Terminal?;
    var stubbedItem := map[
      "foo" := ComAmazonawsDynamodbTypes.AttributeValue.B(
        BinaryAttributeValue:=encryptedData.content.StructuredDataMap["foo"].content.StructuredDataTerminal.value
      ),
      "bar" := ComAmazonawsDynamodbTypes.AttributeValue.B(
        BinaryAttributeValue:=encryptedData.content.StructuredDataMap["bar"].content.StructuredDataTerminal.value
      ),
      "fizzbuzz" := ComAmazonawsDynamodbTypes.AttributeValue.B(
        BinaryAttributeValue:=encryptedData.content.StructuredDataMap["fizzbuzz"].content.StructuredDataTerminal.value
      )
    ];

    var encryptOutput := EncryptItemOutput(encryptedItem := stubbedItem);
    output := Success(encryptOutput);
  }

  predicate DecryptItemEnsuresPublicly(input: DecryptItemInput, output: Result<DecryptItemOutput, Error>)
  {true}
  
  method DecryptItem(config: InternalConfig, input: DecryptItemInput)
      returns (output: Result<DecryptItemOutput, Error>)
  {
    // TODO transform our input DDB item into a Structure the SEL can understand.
    // TODO calculate AuthenticateSchema based on input DDB Item and AllowedAuthenticated* fields
    // For now, just pass some stubbed input
    var encryptedStructure := StubbedData.STUBBED_STRUCTURED_DATA;
    var authenticateSchema := StubbedData.STUBBED_AUTHENTICATE_SCHEMA;

    // Use the structured encryption client to decrypt the item.
    var decryptRes := config.structuredEncryption.DecryptStructure(
      AwsCryptographyStructuredEncryptionTypes.DecryptStructureInput(
        encryptedStructure:=encryptedStructure,
        authenticateSchema:=authenticateSchema,
        cmm:=config.cmm,
        encryptionContext:=None()
      )
    );
    // TODO properly convert error and bubble up message
    :- Need(decryptRes.Success?,
      Error.DynamoDbItemEncryptorException(
        message := "Failed to decrypt item."));
    var decryptedData := decryptRes.value.plaintextStructure;

    // TODO convert the encrypted structure back into a DDB item.
    // For now we use knowledge of the expected output 
    // (StructuredEncryption.EncryptStructure is just a passthrough)
    // to quickly construct a related DDB item.
    expect decryptedData.content.DataMap?;
    expect "foo" in decryptedData.content.StructuredDataMap;
    expect "bar" in decryptedData.content.StructuredDataMap;
    expect "fizzbuzz" in decryptedData.content.StructuredDataMap;
    expect decryptedData.content.StructuredDataMap["foo"].content.Terminal?;
    expect decryptedData.content.StructuredDataMap["bar"].content.Terminal?;
    expect decryptedData.content.StructuredDataMap["fizzbuzz"].content.Terminal?;
    var stubbedItem := map[
      "foo" := ComAmazonawsDynamodbTypes.AttributeValue.B(
        BinaryAttributeValue:=decryptedData.content.StructuredDataMap["foo"].content.StructuredDataTerminal.value
      ),
      "bar" := ComAmazonawsDynamodbTypes.AttributeValue.B(
        BinaryAttributeValue:=decryptedData.content.StructuredDataMap["bar"].content.StructuredDataTerminal.value
      ),
      "fizzbuzz" := ComAmazonawsDynamodbTypes.AttributeValue.B(
        BinaryAttributeValue:=decryptedData.content.StructuredDataMap["fizzbuzz"].content.StructuredDataTerminal.value
      )
    ];

    var decryptOutput := DecryptItemOutput(plaintextItem := stubbedItem);
    output := Success(decryptOutput);
  }
}
