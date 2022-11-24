// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "AwsCryptographyDynamoDbEncryptionMiddlewareInternalOperations.dfy"
include "../../DynamoDbItemEncryptor/Model/AwsCryptographyDynamoDbItemEncryptorTypes.dfy"

module
  {:extern "Dafny.Aws.Cryptography.DynamoDbEncryptionMiddlewareInternal" }
  DynamoDbEncryptionMiddlewareInternal refines AbstractAwsCryptographyDynamoDbEncryptionMiddlewareInternalService
{
  import AwsCryptographyDynamoDbItemEncryptorTypes
  import Operations = AwsCryptographyDynamoDbEncryptionMiddlewareInternalOperations
  import DynamoDbItemEncryptor

  // TODO there is no sensible default, so what should this do?
  // As is, the default config is invalid. Can we update the codegen to *not*
  // build a default config?
  function method DefaultDynamoDbEncryptionMiddlewareInternalConfig(): DynamoDbEncryptionMiddlewareInternalConfig
  {
    DynamoDbEncryptionMiddlewareInternalConfig(
      tableEncryptionConfigs := map[
        "foo" := DynamoDbTableEncryptionConfig(
          partitionKeyName := "bar",
          sortKeyName := None(),
          attributeActions := map[],
          allowedUnauthenticatedAttributes := None(),
          allowedUnauthenticatedAttributePrefix := None(),
          keyring := None(),
          cmm := None()
        )
      ]
    )
  }

  method DynamoDbEncryptionMiddlewareInternal(config: DynamoDbEncryptionMiddlewareInternalConfig)
    returns (res: Result<DynamoDbEncryptionMiddlewareInternalClient, Error>)
  {
    // TODO validate input
    var internalConfigs: map<string, Operations.TableConfig> := map[];

    // TODO is there an easier way to iterate through a map?
    var m' := config.tableEncryptionConfigs;
    while m'.Keys != {}
        invariant m'.Keys <= config.tableEncryptionConfigs.Keys
        invariant forall k | k in m' :: m'[k] == config.tableEncryptionConfigs[k]
        invariant forall tableName, tableConfig :: tableName in internalConfigs && tableConfig == internalConfigs[tableName] ==>
            && tableConfig.itemEncryptor.config.tableName == tableName
            && tableConfig.itemEncryptor.config.partitionKeyName == tableConfig.partitionKeyName
            && tableConfig.itemEncryptor.config.sortKeyName == tableConfig.sortKeyName
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

        internalConfigs := internalConfigs[tableName := internalConfig];
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
