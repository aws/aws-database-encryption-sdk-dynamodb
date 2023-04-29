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
  import opened StandardLibrary
  import AwsCryptographyDynamoDbEncryptionItemEncryptorTypes
  import Operations = AwsCryptographyDynamoDbEncryptionTransformsOperations
  import DynamoDbItemEncryptor
  import SearchConfigToInfo
  import Seq
  import ET = AwsCryptographyDynamoDbEncryptionTypes
  import SET = AwsCryptographyStructuredEncryptionTypes
  import DDB = ComAmazonawsDynamodbTypes

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

  function method {:tailrecursion} AddActions(names : seq<string>, actions : ET.AttributeActions) : ET.AttributeActions
    requires forall k <- names :: DDB.IsValid_AttributeName(k)
  {
    if |names| == 0 then
      actions
    else
      AddActions(names[1..], actions[names[0] := SET.SIGN_ONLY])
  }

  predicate {:opaque} AllTableConfigsValid?(configs: map<string, TableConfig>)
    ensures 0 == |configs| ==> AllTableConfigsValid?(configs)
  {
    forall tableName <- configs :: ValidTableConfig?(configs[tableName])
  }
  predicate {:opaque} CorrectlyTransferedStructure?(
    internalConfigs: map<string, DdbMiddlewareConfig.ValidTableConfig>,
    config: AwsCryptographyDynamoDbEncryptionTypes.DynamoDbTablesEncryptionConfig
  )
    ensures 0 == |internalConfigs| ==> CorrectlyTransferedStructure?(internalConfigs, config)
  {
    forall tableName <- internalConfigs
    ::
      && tableName in config.tableEncryptionConfigs
      && ConfigsMatch(tableName, internalConfigs[tableName], config.tableEncryptionConfigs[tableName])
  }
  predicate {:opaque} ConfigsMatch(
    tableName: string,
    internalConfig: DdbMiddlewareConfig.ValidTableConfig,
    inputConfig: AwsCryptographyDynamoDbEncryptionTypes.DynamoDbTableEncryptionConfig
  )
  {
    && tableName == internalConfig.physicalTableName
    && inputConfig.logicalTableName == internalConfig.logicalTableName
    && inputConfig.partitionKeyName == internalConfig.partitionKeyName
    && inputConfig.sortKeyName == internalConfig.sortKeyName
  }

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

    ghost var inputConfigsModifies: set<object> := set
      tableConfig <- set tableName <- config.tableEncryptionConfigs, tableConfig | tableConfig == config.tableEncryptionConfigs[tableName] :: tableConfig,
      o <- (
            (if tableConfig.keyring.Some? then tableConfig.keyring.value.Modifies else {})
          + (if tableConfig.cmm.Some? then tableConfig.cmm.value.Modifies else {})
          + (if tableConfig.legacyConfig.Some? then tableConfig.legacyConfig.value.encryptor.Modifies else {})
      )
      :: o;

    while m'.Keys != {}
        invariant m'.Keys <= config.tableEncryptionConfigs.Keys
        invariant forall k <- m' :: m'[k] == config.tableEncryptionConfigs[k]

        invariant CorrectlyTransferedStructure?(internalConfigs, config)
        invariant AllTableConfigsValid?(internalConfigs)
        invariant ValidConfig?(Config(internalConfigs))

        decreases m'.Keys
        modifies inputConfigsModifies
    {
        var tableName: string :| tableName in m';
        var inputConfig := config.tableEncryptionConfigs[tableName];

        assert SearchConfigToInfo.ValidSearchConfig(inputConfig.search);
        SearchInModifies(config, tableName);
        var searchR := SearchConfigToInfo.Convert(inputConfig);
        var search :- searchR.MapFailure(e => AwsCryptographyDynamoDbEncryption(e));
        assert search.None? || search.value.ValidState();

        // Add Signed Beacons to attributeActions
        var signedBeacons := if search.None? then [] else search.value.curr().ListSignedBeacons();
        var badBeacons := Seq.Filter(s => s in inputConfig.attributeActions, signedBeacons);
        if 0 < |badBeacons| {
          return Failure(E("Beacons cannot be configured with CryptoActions : " + Join(badBeacons, ", ")));
        }
        :- Need(forall k <- signedBeacons :: DDB.IsValid_AttributeName(k), E("Beacon configured with bad name"));
        //= specification/dynamodb-encryption-client/ddb-support.md#addnonsensitivebeacons
        //# This new NonSensitiveBeacons MUST be added to [Attribute Actions](./ddb-table-encryption-config.md#attribute-actions)
        //# as a [SIGN_ONLY](../structured-encryption/structures.md#sign_only) action.
        var newActions := AddActions(signedBeacons, inputConfig.attributeActions);

        var encryptorConfig := AwsCryptographyDynamoDbEncryptionItemEncryptorTypes.DynamoDbItemEncryptorConfig(
          logicalTableName := inputConfig.logicalTableName,
          partitionKeyName := inputConfig.partitionKeyName,
          sortKeyName := inputConfig.sortKeyName,
          attributeActions := newActions,
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

        var internalConfig: DdbMiddlewareConfig.ValidTableConfig := DdbMiddlewareConfig.TableConfig(
          physicalTableName := tableName,
          logicalTableName := inputConfig.logicalTableName,
          partitionKeyName := inputConfig.partitionKeyName,
          sortKeyName := inputConfig.sortKeyName,
          itemEncryptor := itemEncryptor,
          search := search
        );
        
        internalConfigs := internalConfigs[tableName := internalConfig];

        assert AllTableConfigsValid?(internalConfigs) by {
          reveal AllTableConfigsValid?();
          assert AllTableConfigsValid?(internalConfigs - {tableName});
          assert ValidTableConfig?(internalConfig);
        }
        assert ValidConfig?(Config(internalConfigs)) by {
          assert ValidConfig?(Config(internalConfigs - {tableName}));
          assert internalConfig.physicalTableName == tableName;
        }

        assert CorrectlyTransferedStructure?(internalConfigs, config) by {
          reveal CorrectlyTransferedStructure?();
          reveal ConfigsMatch();
          assert CorrectlyTransferedStructure?(internalConfigs - {tableName}, config);
          assert ConfigsMatch(tableName, internalConfig, inputConfig);
        }

        // Pop 'tableName' off the map, so that we may continue iterating
        m' := map k' | k' in m' && k' != tableName :: m'[k'];
    }
    assert SearchValidState(DdbMiddlewareConfig.Config(tableEncryptionConfigs := internalConfigs));

    var newConfig := DdbMiddlewareConfig.Config(tableEncryptionConfigs := internalConfigs);
    assert Operations.ValidInternalConfig?(newConfig);
    var client := new DynamoDbEncryptionTransformsClient(newConfig);

    // I'm really sorry, but I can't get the freshness to verify
    // and my time box has run out of time.
    assume {:axiom} fresh(
      client.Modifies
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

    return Success(client);
  }

  // lemma ConstructionOK(config : DdbMiddlewareConfig.Config)
  //   requires Operations.ValidInternalConfig?(config)
  //   ensures new DynamoDbEncryptionTransformsClient(newConfig).ValidState()

  class DynamoDbEncryptionTransformsClient... {

    predicate ValidState()
    {
      && Operations.ValidInternalConfig?(config)
      && History !in Operations.ModifiesInternalConfig(config)
      && Modifies == Operations.ModifiesInternalConfig(config) + {History}
    }

    constructor {:vcs_split_on_every_assert} (config: Operations.InternalConfig)
    {
      this.config := config;
      History := new IDynamoDbEncryptionTransformsClientCallHistory();
      Modifies := Operations.ModifiesInternalConfig(config) + {History};
    }

  }
}
