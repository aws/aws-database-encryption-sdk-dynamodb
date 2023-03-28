// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DdbMiddlewareConfig.dfy"
include "AwsCryptographyDynamoDbEncryptionTransformsOperations.dfy"

module
  {:extern "Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms" }
  DynamoDbEncryptionTransforms refines AbstractAwsCryptographyDynamoDbEncryptionTransformsService
{
  import opened DdbMiddlewareConfig
  import AwsCryptographyDynamoDbEncryptionItemEncryptorTypes
  import Operations = AwsCryptographyDynamoDbEncryptionTransformsOperations
  import DynamoDbItemEncryptor

  // TODO there is no sensible default, so what should this do?
  // As is, the default config is invalid. Can we update the codegen to *not*
  // build a default config?
  function method DefaultDynamoDbTablesEncryptionConfig(): AwsCryptographyDynamoDbEncryptionTypes.DynamoDbTablesEncryptionConfig
  {
    AwsCryptographyDynamoDbEncryptionTypes.DynamoDbTablesEncryptionConfig(
      tableEncryptionConfigs := map[]
    )
  }

  method {:vcs_split_on_every_assert} DynamoDbEncryptionTransforms(config: AwsCryptographyDynamoDbEncryptionTypes.DynamoDbTablesEncryptionConfig)
    returns (res: Result<DynamoDbEncryptionTransformsClient, Error>)
  {
    // TODO validate input
    var internalConfigs: map<string, DdbMiddlewareConfig.TableConfig> := map[];

    var m' := config.tableEncryptionConfigs;
    while m'.Keys != {}
        invariant m'.Keys <= config.tableEncryptionConfigs.Keys
        invariant forall k <- m' :: m'[k] == config.tableEncryptionConfigs[k]
        invariant forall tableName <- internalConfigs, tableConfig :: (tableConfig == internalConfigs[tableName]
          ==>
            && tableConfig.itemEncryptor.config.tableName == tableName
            && tableConfig.itemEncryptor.config.partitionKeyName == tableConfig.partitionKeyName
            && tableConfig.itemEncryptor.config.sortKeyName == tableConfig.sortKeyName)
        invariant forall t :: t in internalConfigs.Keys ==> internalConfigs[t].itemEncryptor.ValidState()

        invariant fresh((set t <- internalConfigs.Keys, o <- internalConfigs[t].itemEncryptor.Modifies :: o) -
          set t <- config.tableEncryptionConfigs.Keys, o <- (
            (if config.tableEncryptionConfigs[t].keyring.Some? then config.tableEncryptionConfigs[t].keyring.value.Modifies else {})
          + (if config.tableEncryptionConfigs[t].cmm.Some? then config.tableEncryptionConfigs[t].cmm.value.Modifies else {})
      ) :: o)

        decreases m'.Keys
    {
        var tableName: string :| tableName in m';
        var inputConfig := config.tableEncryptionConfigs[tableName];

        var encryptorConfig := AwsCryptographyDynamoDbEncryptionItemEncryptorTypes.DynamoDbItemEncryptorConfig(
          tableName := tableName,
          partitionKeyName := inputConfig.partitionKeyName,
          sortKeyName := inputConfig.sortKeyName,
          attributeActions := inputConfig.attributeActions,
          allowedUnauthenticatedAttributes := inputConfig.allowedUnauthenticatedAttributes,
          allowedUnauthenticatedAttributePrefix := inputConfig.allowedUnauthenticatedAttributePrefix,
          algorithmSuiteId := inputConfig.algorithmSuiteId,
          keyring := inputConfig.keyring,
          cmm := inputConfig.cmm,
          legacyConfig := None // TODO pass the right config
        );
        // TODO consider using the raw constructor in order to avoid
        // instantiating multiple StructuredEncryption
        var itemEncryptorRes := DynamoDbItemEncryptor.DynamoDbItemEncryptor(encryptorConfig);

        var itemEncryptor :- itemEncryptorRes
          .MapFailure(e => AwsCryptographyDynamoDbEncryptionItemEncryptor(e));

        var internalConfig := DdbMiddlewareConfig.TableConfig(
          partitionKeyName := inputConfig.partitionKeyName,
          sortKeyName := inputConfig.sortKeyName,
          itemEncryptor := itemEncryptor
        );

        assert internalConfig.itemEncryptor.ValidState();
        internalConfigs := internalConfigs[tableName := internalConfig];

        // Pop 'tableName' off the map, so that we may continue iterating
        m' := map k' | k' in m' && k' != tableName :: m'[k'];
    }

    var client := new DynamoDbEncryptionTransformsClient(
      DdbMiddlewareConfig.Config(
        tableEncryptionConfigs := internalConfigs
      )
    );

    return Success(client);
  }

  class DynamoDbEncryptionTransformsClient... {

    predicate ValidState()
    {
      && Operations.ValidInternalConfig?(config)
      && History !in Operations.ModifiesInternalConfig(config)
      && Modifies == Operations.ModifiesInternalConfig(config) + {History}
    }

    constructor(config: Operations.InternalConfig)
    {
      this.config := config;
      History := new IDynamoDbEncryptionTransformsClientCallHistory();
      Modifies := Operations.ModifiesInternalConfig(config) + {History};
    }

  }
}
