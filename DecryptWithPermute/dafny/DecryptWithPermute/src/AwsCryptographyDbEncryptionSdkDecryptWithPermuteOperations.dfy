// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../Model/AwsCryptographyDbEncryptionSdkDecryptWithPermuteTypes.dfy"
include "../../../../DynamoDbEncryption/dafny/DynamoDbItemEncryptor/src/Index.dfy"
include "../../../../submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographicMaterialProviders/src/CMMs/RequiredEncryptionContextCMM.dfy"
include "AltDynamoToStruct.dfy"
include "AltDecryptStructure.dfy"

module AwsCryptographyDbEncryptionSdkDecryptWithPermuteOperations refines AbstractAwsCryptographyDbEncryptionSdkDecryptWithPermuteOperations {
  import opened AwsCryptographyDbEncryptionSdkDecryptWithPermuteTypes
  import ComAmazonawsDynamodbTypes
  import EU = DynamoDbItemEncryptorUtil
  import CMP = AwsCryptographyMaterialProvidersTypes
  import StructuredEncryption
  import AltDynamoToStruct
  import SortedSets
  import Base64
  import opened StandardLibrary
  import Seq
  import CSE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import SE =  StructuredEncryptionUtil
  import InternalLegacyOverride
  import MaterialProviders
  import RequiredEncryptionContextCMM
  import SET = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import DDBE = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import DynamoDbEncryptionUtil
  import StructuredEncryptionUtil
  import StandardLibrary.String
  import IE = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations
  import IT = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import AltDecryptStructure

  datatype Config = Config(
    nameonly inner : IE.Config
  )

  type InternalConfig = Config
  type ValidConfig = x : Config | ValidInternalConfig?(x) witness *

  predicate ValidInternalConfig?(config: InternalConfig)
  {
    IE.ValidInternalConfig?(config.inner)
  }

  function ModifiesInternalConfig(config: InternalConfig) : set<object>
  {
    IE.ModifiesInternalConfig(config.inner)
  }

  // string to Error
  function method E(s : string) : Error {
    DynamoDbPermuteDecryptorException(message := s)
  }

  predicate PermuteDecryptEnsuresPublicly(input: PermuteDecryptInput, output: Result<PermuteDecryptOutput, Error>)
  {true}

  // public Decrypt method
  method {:vcs_split_on_every_assert} PermuteDecrypt(config: InternalConfig, input: PermuteDecryptInput)
    returns (output: Result<PermuteDecryptOutput, Error>)
  {
    var realCount := |set k <- input.inner.encryptedItem | !(EU.ReservedPrefix <= k)|;
    if realCount > EU.MAX_ATTRIBUTE_COUNT {
      var actCount := String.Base10Int2String(realCount);
      var maxCount := String.Base10Int2String(EU.MAX_ATTRIBUTE_COUNT);
      return Failure(E("Item to decrypt had " + actCount + " attributes, but maximum allowed is " + maxCount));
    }

    :- Need(
      && config.inner.partitionKeyName in input.inner.encryptedItem
      && (config.inner.sortKeyName.None? || config.inner.sortKeyName.value in input.inner.encryptedItem)
    , DynamoDbPermuteDecryptorException( message := IE.KeyMissingMsg(config.inner, input.inner.encryptedItem, "Decrypt")));

    // Note: InternalLegacyOverride.DecryptItem checks that the legacy policy is correct.
    if config.inner.internalLegacyOverride.Some? && config.inner.internalLegacyOverride.value.IsLegacyInput(input.inner) {
      var decryptItemOutputR := config.inner.internalLegacyOverride.value.DecryptItem(input.inner);
      var decryptItemOutput :- decryptItemOutputR.MapFailure(e => AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor(e));
      //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
      //# The item returned by this operation MUST be the item outputted by the
      //# [Legacy Encryptor](./ddb-table-encryption-config.md#legacy-encryptor).
      return Success(PermuteDecryptOutput(inner := decryptItemOutput, didPermute := false));
    }

    if (
        && (|| config.inner.plaintextOverride.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ?
            || config.inner.plaintextOverride.FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ?)
        && IE.IsPlaintextItem(input.inner.encryptedItem)
      ) {
      var passthroughOutput := IT.DecryptItemOutput(
        plaintextItem := input.inner.encryptedItem,
        parsedHeader := None
      );
      return Success(PermuteDecryptOutput(inner := passthroughOutput, didPermute := false));
    }

    :- Need(!IE.IsPlaintextItem(input.inner.encryptedItem),
            DynamoDbPermuteDecryptorException(
              message := "Encrypted item missing expected header and footer attributes"));

    var encryptedStructure :- AltDynamoToStruct.ItemToStructured(input.inner.encryptedItem)
    .MapFailure(e => AwsCryptographyDbEncryptionSdkDynamoDb(e));
    var context :- IE.MakeEncryptionContext(config.inner, encryptedStructure).MapFailure(e => AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor(e));
    var authenticateSchema := IE.ConfigToAuthenticateSchema(config.inner, input.inner.encryptedItem);
    var wrappedStruct := CSE.StructuredData(
      content := CSE.StructuredDataContent.DataMap(encryptedStructure),
      attributes := None);

    //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
    //# This operation MUST create a
    //# [Required Encryption Context CMM](https://github.com/awslabs/private-aws-encryption-sdk-specification-staging/blob/dafny-verified/framework/required-encryption-context-cmm.md)
    //# with the following inputs:
    //# - This item encryptor's [CMM](./ddb-table-encryption-config.md#cmm) as the underlying CMM.
    //# - The keys from the [DynamoDB Item Base Context](./encrypt-item.md#dynamodb-item-base-context).

    var reqCMMR := config.inner.cmpClient.CreateRequiredEncryptionContextCMM(
      CMP.CreateRequiredEncryptionContextCMMInput(
        underlyingCMM := Some(config.inner.cmm),
        keyring := None,
        requiredEncryptionContextKeys := SortedSets.ComputeSetToOrderedSequence2(context.Keys, StructuredEncryptionUtil.ByteLess)
      )
    );
    var reqCMM :- reqCMMR.MapFailure(e => AwsCryptographyMaterialProviders(e));

    var decryptVal :- AltDecryptStructure.AltDecryptStructure(
      config.inner.structuredEncryption.config,
      CSE.DecryptStructureInput(
        tableName := config.inner.logicalTableName,
        encryptedStructure := wrappedStruct,
        authenticateSchema := authenticateSchema,
        //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
        //# - CMM MUST be the CMM constructed above.
        cmm:=reqCMM,
        encryptionContext:=Some(context)
      ),
      input.maxSetSize as nat
    );

    var decryptedData := decryptVal.inner.plaintextStructure;
    var ddbItem :- AltDynamoToStruct.StructuredToItem(decryptedData.content.DataMap)
    .MapFailure(e => Error.AwsCryptographyDbEncryptionSdkDynamoDb(e));

    var schemaToConvert := decryptVal.inner.parsedHeader.cryptoSchema;

    var parsedAuthActions :- IE.ConvertCryptoSchemaToAttributeActions(config.inner, schemaToConvert)
    .MapFailure(e => AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor(e));

    var parsedHeader := IT.ParsedHeader(
      attributeActionsOnEncrypt := parsedAuthActions,
      algorithmSuiteId := decryptVal.inner.parsedHeader.algorithmSuiteId,
      storedEncryptionContext := decryptVal.inner.parsedHeader.storedEncryptionContext,
      encryptedDataKeys := decryptVal.inner.parsedHeader.encryptedDataKeys
    );

    var result := IT.DecryptItemOutput(
      plaintextItem := ddbItem,
      parsedHeader := Some(parsedHeader)
    );

    output := Success(
      PermuteDecryptOutput(
        inner := result,
        didPermute := decryptVal.didPermute
      ));
  }
}
