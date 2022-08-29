// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../../../private-aws-encryption-sdk-dafny-staging/src/StandardLibrary/StandardLibrary.dfy"
include "../../../StructuredEncryption/Model/AwsCryptographyStructuredEncryptionTypes.dfy"
include "../../../AWS-DDB/Model/ComAmazonawsDynamodbTypes.dfy"
include "../../Model/AwsCryptographyDynamodbEncryptionTypes.dfy"
include "../../../StructuredEncryption/src/Index.dfy"

module EncryptItemOperation {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import DDB = ComAmazonawsDynamodbTypes
  import Types = AwsCryptographyDynamodbEncryptionTypes
  import StructuredEncryption
  import AwsCryptographyStructuredEncryptionTypes

  method EncryptItem(
    config: Types.DynamoDBEncryptionConfig,
    input: Types.EncryptItemInput,
    structuredEncryption: AwsCryptographyStructuredEncryptionTypes.IStructuredEncryptionClient
  ) returns (output: Result<Types.EncryptItemOutput, Types.Error>)
    modifies
      structuredEncryption.Modifies,
      (if input.keyring.Some? then input.keyring.value.Modifies else {}),
      (if input.cmm.Some? then input.cmm.value.Modifies else {})
    requires structuredEncryption.ValidState()
    requires
      && ( 
        input.keyring.Some? ==>
          && input.keyring.value.ValidState()
          && input.keyring.value.Modifies !! structuredEncryption.Modifies
      ) && (
        input.cmm.Some? ==>
          && input.cmm.value.ValidState()
          && input.cmm.value.Modifies !! structuredEncryption.Modifies
      )
  {
    // TODO transform our input DDB item into a Structure the SEL can understand.
    // For now, all outputs are stubbed so our inputs do not matter.
    // Just use some input which is considered valid for the SEL.
    var inputStructure := AwsCryptographyStructuredEncryptionTypes.StructuredData(
      content := AwsCryptographyStructuredEncryptionTypes.StructuredDataContent.terminal(
        Terminal := AwsCryptographyStructuredEncryptionTypes.Terminal(
          value := [0x21, 0x64, 0x6c, 0x72, 0x6f, 0x77, 0x20, 0x2c, 0x6f, 0x6c, 0x6c, 0x65, 0x68],
          typeId := [0xFF, 0xFF]
        )
      ),
      attributes := None()
    );
    var schema := AwsCryptographyStructuredEncryptionTypes.CryptoSchema(
      content := AwsCryptographyStructuredEncryptionTypes.CryptoSchemaContent.action(
        CryptoAction := AwsCryptographyStructuredEncryptionTypes.CryptoAction.ENCRYPT_AND_SIGN),
      attributes := None()
    );

    // Use the structured encryption client to decrypt the item.
    // TODO For the purpose of creating a minimal integration with
    // the Structured Encryption Library, assume we were given a keyring
    expect input.keyring.Some?;
    var encryptRes := structuredEncryption.EncryptStructure(
      AwsCryptographyStructuredEncryptionTypes.EncryptStructureInput(
        plaintextStructure:=inputStructure,
        cryptoSchema:=schema,
        keyring:=input.keyring,
        cmm:=None(),
        encryptionContext:=None(),
        requiredContextFieldsOnDecrypt:=None()
      )
    );
    // TODO properly convert error and bubble up message
    :- Need(encryptRes.Success?,
      Types.Error.DynamoDBEncryptionException(
        message := "Failed to encrypt item."));
    var encryptedData := encryptRes.value.ciphertextStructure;

    // TODO convert the encrypted structure back into a DDB item.
    // For now we use knowledge of what the stubbed output is to
    // quickly construct a related DDB item.
    expect encryptedData.content.dataMap?;
    expect "foo" in encryptedData.content.StructuredDataMap;
    expect "bar" in encryptedData.content.StructuredDataMap;
    expect "fizzbuzz" in encryptedData.content.StructuredDataMap;
    expect encryptedData.content.StructuredDataMap["foo"].content.terminal?;
    expect encryptedData.content.StructuredDataMap["bar"].content.terminal?;
    expect encryptedData.content.StructuredDataMap["fizzbuzz"].content.terminal?;
    var stubbedItem := map[
      "foo" := DDB.AttributeValue.B(
        BinaryAttributeValue:=encryptedData.content.StructuredDataMap["foo"].content.Terminal.value
      ),
      "bar" := DDB.AttributeValue.B(
        BinaryAttributeValue:=encryptedData.content.StructuredDataMap["bar"].content.Terminal.value
      ),
      "fizzbuzz" := DDB.AttributeValue.B(
        BinaryAttributeValue:=encryptedData.content.StructuredDataMap["fizzbuzz"].content.Terminal.value
      )
    ];

    var encryptOutput := Types.EncryptItemOutput(encryptedItem := stubbedItem);
    output := Success(encryptOutput);
  }
}
