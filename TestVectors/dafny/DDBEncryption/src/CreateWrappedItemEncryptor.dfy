// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDynamoDbEncryptionTypesWrapped.dfy"
include "../../../../DynamoDbEncryption/dafny/DynamoDbItemEncryptor/src/Index.dfy"

module {:extern} CreateWrappedItemEncryptor {
  import opened Wrappers
  import AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import ENC = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import DynamoDbItemEncryptor
  import Operations = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations

  method {:extern} CreateWrappedItemEncryptor(config: ENC.DynamoDbItemEncryptorConfig)
    returns (output: Result<ENC.IDynamoDbItemEncryptorClient, ENC.Error>)
    ensures output.Success? ==>
              && output.value is DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
              && fresh(output.value)
              && fresh(output.value.History)
              && output.value.ValidState()
              && var rconfig := (output.value as DynamoDbItemEncryptor.DynamoDbItemEncryptorClient).config;
              && fresh(output.value.Modifies)
              && rconfig.logicalTableName == config.logicalTableName
              && rconfig.partitionKeyName == config.partitionKeyName
              && rconfig.sortKeyName == config.sortKeyName
              && rconfig.attributeActionsOnEncrypt == config.attributeActionsOnEncrypt
              && rconfig.allowedUnsignedAttributes == config.allowedUnsignedAttributes
              && rconfig.allowedUnsignedAttributePrefix == config.allowedUnsignedAttributePrefix
              && rconfig.algorithmSuiteId == config.algorithmSuiteId

              //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#attribute-actions
              //= type=implication
              //# The [Key Action](#key-action)
              //# MUST be configured to the partition attribute and, if present, sort attribute.
              && rconfig.version == Operations.VersionFromActions(config.attributeActionsOnEncrypt)
              && config.partitionKeyName in config.attributeActionsOnEncrypt
              && config.attributeActionsOnEncrypt[config.partitionKeyName] == Operations.KeyActionFromVersion(rconfig.version)
              && (config.sortKeyName.Some? ==>
                    && config.sortKeyName.value in config.attributeActionsOnEncrypt
                    && config.attributeActionsOnEncrypt[config.sortKeyName.value] == Operations.KeyActionFromVersion(rconfig.version))

    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#plaintext-policy
    //# If not specified, encryption and decryption MUST behave according to `FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ`.
    ensures
      && output.Success?
      && config.plaintextOverride.None?
      ==>
        && var config := (output.value as DynamoDbItemEncryptor.DynamoDbItemEncryptorClient).config;
        && config.plaintextOverride.FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ?
}
