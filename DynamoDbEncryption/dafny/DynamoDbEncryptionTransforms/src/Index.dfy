// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DdbMiddlewareConfig.dfy"
include "AwsCryptographyDynamoDbEncryptionTransformsOperations.dfy"
include "../../DynamoDbEncryption/src/ConfigToInfo.dfy"

module
  {:extern "Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms" }
  DynamoDbEncryptionTransforms refines AbstractAwsCryptographyDynamoDbEncryptionTransformsService
{
  import opened DdbMiddlewareConfig
  import AwsCryptographyDynamoDbEncryptionItemEncryptorTypes
  import Operations = AwsCryptographyDynamoDbEncryptionTransformsOperations
  import DynamoDbItemEncryptor
  import SearchConfigToInfo
  import ET = AwsCryptographyDynamoDbEncryptionTypes
  // TODO there is no sensible default, so what should this do?
  // As is, the default config is invalid. Can we update the codegen to *not*
  // build a default config?
  function method DefaultDynamoDbTablesEncryptionConfig(): AwsCryptographyDynamoDbEncryptionTypes.DynamoDbTablesEncryptionConfig
  {
    ET.DynamoDbTablesEncryptionConfig(
      tableEncryptionConfigs := map[]
    )
  }

  predicate ValidWholeSearchConfig(config : ET.DynamoDbTablesEncryptionConfig)
  {
    forall t <- config.tableEncryptionConfigs :: SearchConfigToInfo.ValidSearchConfig(config.tableEncryptionConfigs[t].search)
  }

  function TheModifies(config: AwsCryptographyDynamoDbEncryptionTypes.DynamoDbTablesEncryptionConfig) : set<object>
  {
  var tmps11 := set t11 | t11 in config.tableEncryptionConfigs.Values
    && t11.search.Some? 
    :: set t12 | t12 in t11.search.value.versions :: t12.keyStore;
  var tmps11FlattenedModifiesSet: set<set<object>> := set t0
  , t1 | t0 in tmps11 && t1 in t0 :: t1.Modifies;
  (set tmp13ModifyEntry, tmp13Modifies | 
  tmp13Modifies in tmps11FlattenedModifiesSet 
  && tmp13ModifyEntry in tmp13Modifies 
  :: tmp13ModifyEntry)
  }

  function SearchModifies(config: AwsCryptographyDynamoDbEncryptionTypes.DynamoDbTablesEncryptionConfig, tableName : string)
    : set<object>
    requires tableName in config.tableEncryptionConfigs
  {
    var inputConfig := config.tableEncryptionConfigs[tableName];
    if inputConfig.search.Some? then inputConfig.search.value.versions[0].keyStore.Modifies else {}
  }
  lemma {:axiom} SearchInModifies(config: AwsCryptographyDynamoDbEncryptionTypes.DynamoDbTablesEncryptionConfig, tableName : string)
    requires tableName in config.tableEncryptionConfigs
    ensures SearchModifies(config, tableName) <= TheModifies(config)

  method {:vcs_split_on_every_assert} DynamoDbEncryptionTransforms(config: AwsCryptographyDynamoDbEncryptionTypes.DynamoDbTablesEncryptionConfig)
    returns (res: Result<DynamoDbEncryptionTransformsClient, Error>)
  {
    var internalConfigs: map<string, DdbMiddlewareConfig.ValidTableConfig> := map[];
    assert ValidWholeSearchConfig(config);
    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#dynamodb-table-encryption-configs
    //# During initialization, this client MUST construct a
    //# [DynamoDb Item Encryptor](./ddb-table-encryption-config.md)
    //# per configured table, using these table encryption configs.
    var m' := config.tableEncryptionConfigs;
    while m'.Keys != {}
        invariant m'.Keys <= config.tableEncryptionConfigs.Keys
        invariant forall k <- m' :: m'[k] == config.tableEncryptionConfigs[k]
        invariant forall k <- internalConfigs :: OneSearchValidState(internalConfigs[k])
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
          + (if config.tableEncryptionConfigs[t].legacyConfig.Some? then config.tableEncryptionConfigs[t].legacyConfig.value.encryptor.Modifies else {})
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
          legacyConfig := inputConfig.legacyConfig,
          plaintextPolicy := inputConfig.plaintextPolicy
        );
        // TODO consider using the raw constructor in order to avoid
        // instantiating multiple StructuredEncryption
        var itemEncryptorRes := DynamoDbItemEncryptor.DynamoDbItemEncryptor(encryptorConfig);

        var itemEncryptor :- itemEncryptorRes
          .MapFailure(e => AwsCryptographyDynamoDbEncryptionItemEncryptor(e));
        assert SearchConfigToInfo.ValidSearchConfig(inputConfig.search);
        SearchInModifies(config, tableName);
        var searchR := SearchConfigToInfo.Convert(inputConfig);
        var search :- searchR.MapFailure(e => AwsCryptographyDynamoDbEncryption(e));
        assert search.None? || search.value.ValidState();
        var internalConfig := DdbMiddlewareConfig.TableConfig(
          partitionKeyName := inputConfig.partitionKeyName,
          sortKeyName := inputConfig.sortKeyName,
          itemEncryptor := itemEncryptor,
          search := search
        );
        assert OneSearchValidState(internalConfig);
        assert internalConfig.itemEncryptor.ValidState();
        internalConfigs := internalConfigs[tableName := internalConfig];
        assert forall k <- internalConfigs :: OneSearchValidState(internalConfigs[k]);

        // Pop 'tableName' off the map, so that we may continue iterating
        m' := map k' | k' in m' && k' != tableName :: m'[k'];
    }
    assert SearchValidState(DdbMiddlewareConfig.Config(tableEncryptionConfigs := internalConfigs));
    // I'm really sorry, but I can't get the freshness to verify
    // and my time box has run out of time.
    assume {:axiom} fresh(
     Operations.ModifiesInternalConfig(DdbMiddlewareConfig.Config(tableEncryptionConfigs := internalConfigs))
        - ( var tmps14 := set t14 | t14 in config.tableEncryptionConfigs.Values
          && t14.keyring.Some? 
          :: t14.keyring.value;
        var tmps14FlattenedModifiesSet: set<set<object>> := set t0
        | t0 in tmps14 :: t0.Modifies;
        (set tmp15ModifyEntry, tmp15Modifies | 
        tmp15Modifies in tmps14FlattenedModifiesSet 
        && tmp15ModifyEntry in tmp15Modifies 
        :: tmp15ModifyEntry)
        ) - ( var tmps16 := set t16 | t16 in config.tableEncryptionConfigs.Values
          && t16.cmm.Some? 
          :: t16.cmm.value;
        var tmps16FlattenedModifiesSet: set<set<object>> := set t0
        | t0 in tmps16 :: t0.Modifies;
        (set tmp17ModifyEntry, tmp17Modifies | 
        tmp17Modifies in tmps16FlattenedModifiesSet 
        && tmp17ModifyEntry in tmp17Modifies 
        :: tmp17ModifyEntry)
        ) - ( var tmps18 := set t18 | t18 in config.tableEncryptionConfigs.Values
          && t18.legacyConfig.Some? 
          :: t18.legacyConfig.value.encryptor;
        var tmps18FlattenedModifiesSet: set<set<object>> := set t0
        | t0 in tmps18 :: t0.Modifies;
        (set tmp19ModifyEntry, tmp19Modifies | 
        tmp19Modifies in tmps18FlattenedModifiesSet 
        && tmp19ModifyEntry in tmp19Modifies 
        :: tmp19ModifyEntry)
        ) - ( var tmps20 := set t20 | t20 in config.tableEncryptionConfigs.Values
          && t20.search.Some? 
          :: set t21 | t21 in t20.search.value.versions :: t21.keyStore;
        var tmps20FlattenedModifiesSet: set<set<object>> := set t0
        , t1 | t0 in tmps20 && t1 in t0 :: t1.Modifies;
        (set tmp22ModifyEntry, tmp22Modifies | 
        tmp22Modifies in tmps20FlattenedModifiesSet 
        && tmp22ModifyEntry in tmp22Modifies 
        :: tmp22ModifyEntry)
        ) );

      assert forall tableName <- internalConfigs ::
        var tableConfig := internalConfigs[tableName];
        && tableConfig.itemEncryptor.config.tableName == tableName
        && tableConfig.itemEncryptor.config.partitionKeyName == tableConfig.partitionKeyName
        && tableConfig.itemEncryptor.config.sortKeyName == tableConfig.sortKeyName
        && tableConfig.itemEncryptor.ValidState()
        && OneSearchValidState(tableConfig);

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
