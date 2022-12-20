// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "AwsCryptographyDynamoDbEncryptionMiddlewareInternalOperations.dfy"
include "DdbStatement.dfy"
include "../../DynamoDbItemEncryptor/Model/AwsCryptographyDynamoDbItemEncryptorTypes.dfy"

module
  {:extern "Dafny.Aws.Cryptography.DynamoDbEncryptionMiddlewareInternal" }
  DynamoDbEncryptionMiddlewareInternal refines AbstractAwsCryptographyDynamoDbEncryptionMiddlewareInternalService
{
  import AwsCryptographyDynamoDbItemEncryptorTypes
  import Operations = AwsCryptographyDynamoDbEncryptionMiddlewareInternalOperations
  import DynamoDbItemEncryptor
  import DdbStatement

  // TODO there is no sensible default, so what should this do?
  // As is, the default config is invalid. Can we update the codegen to *not*
  // build a default config?
  function method DefaultDynamoDbEncryptionMiddlewareInternalConfig(): DynamoDbEncryptionMiddlewareInternalConfig
  {
    DynamoDbEncryptionMiddlewareInternalConfig(
      tableEncryptionConfigs := map[]
    )
  }

  method DynamoDbEncryptionMiddlewareInternal(config: DynamoDbEncryptionMiddlewareInternalConfig)
    returns (res: Result<DynamoDbEncryptionMiddlewareInternalClient, Error>)
  {
    // TODO validate input
    var internalConfigs: map<string, Operations.TableConfig> := map[];

    var m' := config.tableEncryptionConfigs;
    while m'.Keys != {}
        invariant m'.Keys <= config.tableEncryptionConfigs.Keys
        invariant forall k <- m' :: m'[k] == config.tableEncryptionConfigs[k]
        invariant forall tableName <- internalConfigs, tableConfig :: tableConfig == internalConfigs[tableName]
          ==>
            && tableConfig.itemEncryptor.config.tableName == tableName
            && tableConfig.itemEncryptor.config.partitionKeyName == tableConfig.partitionKeyName
            && tableConfig.itemEncryptor.config.sortKeyName == tableConfig.sortKeyName
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

        var encryptorConfig := AwsCryptographyDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig(
          tableName := tableName,
          partitionKeyName := inputConfig.partitionKeyName,
          sortKeyName := inputConfig.sortKeyName,
          attributeActions := inputConfig.attributeActions,
          allowedUnauthenticatedAttributes := inputConfig.allowedUnauthenticatedAttributes,
          allowedUnauthenticatedAttributePrefix := inputConfig.allowedUnauthenticatedAttributePrefix,
          keyring := inputConfig.keyring,
          cmm := inputConfig.cmm
        );
        // TODO consider using the raw constructor in order to avoid
        // instantiating multiple StructuredEncryption
        var itemEncryptorRes := DynamoDbItemEncryptor.DynamoDbItemEncryptor(encryptorConfig);

        var itemEncryptor :- itemEncryptorRes
          .MapFailure(e => AwsCryptographyDynamoDbItemEncryptor(e));

        var internalConfig := Operations.TableConfig(
          partitionKeyName := inputConfig.partitionKeyName,
          sortKeyName := inputConfig.sortKeyName,
          itemEncryptor := itemEncryptor
        );

        assert internalConfig.itemEncryptor.ValidState();
        internalConfigs := internalConfigs[tableName := internalConfig];

        // Pop 'tableName' off the map, so that we may continue iterating
        m' := map k' | k' in m' && k' != tableName :: m'[k'];
    }

    var client := new DynamoDbEncryptionMiddlewareInternalClient(
      Operations.Config(
        tableEncryptionConfigs := internalConfigs
      )
    );

    return Success(client);
  }

  class DynamoDbEncryptionMiddlewareInternalClient... {

    predicate ValidState()
    {
      && Operations.ValidInternalConfig?(config)
      && History !in Operations.ModifiesInternalConfig(config)
      && Modifies == Operations.ModifiesInternalConfig(config) + {History}
    }

    constructor(config: Operations.InternalConfig)
    {
      this.config := config;
      History := new IDynamoDbEncryptionMiddlewareInternalClientCallHistory();
      Modifies := Operations.ModifiesInternalConfig(config) + {History};
    }

  }
}
