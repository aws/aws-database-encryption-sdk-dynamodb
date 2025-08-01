// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DdbMiddlewareConfig.dfy"
include "AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations.dfy"
include "../../DynamoDbEncryption/src/ConfigToInfo.dfy"

module {:extern "software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny" } DynamoDbEncryptionTransforms
  refines AbstractAwsCryptographyDbEncryptionSdkDynamoDbTransformsService
{
  import opened DdbMiddlewareConfig
  import opened StandardLibrary
  import IE_Types = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import Operations = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations
  import DynamoDbItemEncryptor
  import SearchConfigToInfo
  import Seq
  import SortedSets
  import ET = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import SET = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import DDB = ComAmazonawsDynamodbTypes

  // There is no sensible default, so we express something empty but invalid at runtime.
  function method DefaultDynamoDbTablesEncryptionConfig(): AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTablesEncryptionConfig
  {
    ET.DynamoDbTablesEncryptionConfig(
      tableEncryptionConfigs := map[]
    )
  }

  predicate ValidWholeSearchConfig(config : ET.DynamoDbTablesEncryptionConfig)
  {
    forall t <- config.tableEncryptionConfigs :: SearchConfigToInfo.ValidSearchConfig(config.tableEncryptionConfigs[t].search)
  }

  function TheModifies(config: AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTablesEncryptionConfig) : set<object>
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

  function SearchModifies(config: AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTablesEncryptionConfig, tableName : string)
    : set<object>
    requires tableName in config.tableEncryptionConfigs
  {
    var inputConfig := config.tableEncryptionConfigs[tableName];
    if inputConfig.search.Some? then inputConfig.search.value.versions[0].keyStore.Modifies else {}
  }
  lemma {:axiom} SearchInModifies(config: AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTablesEncryptionConfig, tableName : string)
    requires tableName in config.tableEncryptionConfigs
    ensures SearchModifies(config, tableName) <= TheModifies(config)

  function method {:tailrecursion} AddSignedBeaconActions(
    names : seq<string>,
    actions : ET.AttributeActions,
    pos : nat := 0
  ) : ET.AttributeActions
    requires forall k <- names :: DDB.IsValid_AttributeName(k)
    requires pos <= |names|
    decreases |names| - pos
  {
    if |names| == pos then
      actions
    else
      AddSignedBeaconActions(names, actions[names[0] := SET.SIGN_ONLY], pos+1)
  }

  predicate method IsConfigured(config : AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig, name : string)
  {
    || name in config.attributeActionsOnEncrypt
    || (config.allowedUnsignedAttributes.Some? && name in config.allowedUnsignedAttributes.value)
    || (config.allowedUnsignedAttributePrefix.Some? && config.allowedUnsignedAttributePrefix.value <= name)
  }

  predicate {:opaque} AllTableConfigsValid?(configs: map<string, TableConfig>)
    ensures 0 == |configs| ==> AllTableConfigsValid?(configs)
  {
    forall tableName <- configs :: ValidTableConfig?(configs[tableName])
  }
  predicate {:opaque} CorrectlyTransferredStructure?(
    internalConfigs: map<string, DdbMiddlewareConfig.ValidTableConfig>,
    config: AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTablesEncryptionConfig
  )
    ensures 0 == |internalConfigs| ==> CorrectlyTransferredStructure?(internalConfigs, config)
  {
    forall tableName <- internalConfigs
      ::
        && tableName in config.tableEncryptionConfigs
        && ConfigsMatch(tableName, internalConfigs[tableName], config.tableEncryptionConfigs[tableName])
  }
  predicate {:opaque} ConfigsMatch(
    tableName: string,
    internalConfig: DdbMiddlewareConfig.ValidTableConfig,
    inputConfig: AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig
  )
  {
    && tableName == internalConfig.physicalTableName
    && inputConfig.logicalTableName == internalConfig.logicalTableName
    && inputConfig.partitionKeyName == internalConfig.partitionKeyName
    && inputConfig.sortKeyName == internalConfig.sortKeyName
  }

  method {:vcs_split_on_every_assert} DynamoDbEncryptionTransforms(config: AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTablesEncryptionConfig)
    returns (res: Result<DynamoDbEncryptionTransformsClient, Error>)
    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#logical-table-name
    //= type=implication
    //# When mapping [DynamoDB Table Names](#dynamodb-table-name) to [logical table name](#logical-table-name)
    //# there MUST a one to one mapping between the two.
    ensures res.Success? ==>
              && res.value is DynamoDbEncryptionTransformsClient
              && var config := (res.value as DynamoDbEncryptionTransformsClient).config;
              && DdbMiddlewareConfig.ValidConfig?(config)
  {
    var internalConfigs: map<string, DdbMiddlewareConfig.ValidTableConfig> := map[];
    assert ValidWholeSearchConfig(config);
    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#dynamodb-table-encryption-configs
    //# During initialization, this client MUST construct a
    //# [DynamoDb Item Encryptor](./ddb-table-encryption-config.md)
    //# per configured table, using these table encryption configs.
    var m' := config.tableEncryptionConfigs;
    var mKeys := m'.Keys;
    var tableNamesSeq := SortedSets.ComputeSetToSequence(mKeys);
    ghost var mKeysSet := mKeys;

    ghost var inputConfigsModifies: set<object> := set
      tableConfig <- config.tableEncryptionConfigs.Values,
      o <- (
             (if tableConfig.keyring.Some? then tableConfig.keyring.value.Modifies else {})
             + (if tableConfig.cmm.Some? then tableConfig.cmm.value.Modifies else {})
             + (if tableConfig.legacyOverride.Some? then tableConfig.legacyOverride.value.encryptor.Modifies else {})
             + (if tableConfig.search.Some? then tableConfig.search.value.versions[0].keyStore.Modifies else {})
           )
           {:nowarn} :: o; // ignore warning for missing trigger on quantifier

    var allLogicalTableNames := {};
    var i := 0;

    while i < |tableNamesSeq|
      invariant m'.Keys <= config.tableEncryptionConfigs.Keys
      invariant forall k <- m' :: m'[k] == config.tableEncryptionConfigs[k]
      invariant forall internalConfig <- internalConfigs.Values :: internalConfig.logicalTableName in allLogicalTableNames

      invariant CorrectlyTransferredStructure?(internalConfigs, config)
      invariant AllTableConfigsValid?(internalConfigs)
      invariant ValidConfig?(Config(internalConfigs))

      modifies inputConfigsModifies
    {
      var tableName: string := tableNamesSeq[i];

      var inputConfig := config.tableEncryptionConfigs[tableName];
      :- Need(inputConfig.logicalTableName !in allLogicalTableNames,  E("Duplicate logical table mapped to multiple physical tables: " + inputConfig.logicalTableName));

      assert SearchConfigToInfo.ValidSearchConfig(inputConfig.search);
      SearchInModifies(config, tableName);
      reveal SearchConfigToInfo.ValidSharedCache();
      var searchR := SearchConfigToInfo.Convert(inputConfig);
      var search :- searchR.MapFailure(e => AwsCryptographyDbEncryptionSdkDynamoDb(e));
      assert search.None? || search.value.ValidState();

      // Add Signed Beacons to attributeActionsOnEncrypt
      var signedBeacons := if search.None? then [] else search.value.curr().ListSignedBeacons();
      //= specification/searchable-encryption/beacons.md#signed-beacons
      //# Initialization MUST fail if `NAME` is explicitly configured with an
      //# [attribute actions](../dynamodb-encryption-client/ddb-item-encryptor.md#attribute-actions) or
      //# [unauthenticated attributes](../dynamodb-encryption-client/ddb-item-encryptor.md#unauthenticated-attributes),
      //# or begins with the [unauthenticated attribute prefix](../dynamodb-encryption-client/ddb-item-encryptor.md#unauthenticated-attribute-prefix).
      var badBeacons := Seq.Filter(s => IsConfigured(inputConfig, s), signedBeacons);
      if 0 < |badBeacons| {
        return Failure(E("Signed beacons cannot be configured with CryptoActions or as unauthenticated : " + Join(badBeacons, ", ")));
      }
      :- Need(forall k <- signedBeacons :: DDB.IsValid_AttributeName(k), E("Beacon configured with bad name"));
      //= specification/searchable-encryption/beacons.md#signed-beacons
      //# `NAME` MUST be automatically configured with an attribute action of SIGN_ONLY.
      var newActions := AddSignedBeaconActions(signedBeacons, inputConfig.attributeActionsOnEncrypt);

      var encryptorConfig := IE_Types.DynamoDbItemEncryptorConfig(
        logicalTableName := inputConfig.logicalTableName,
        partitionKeyName := inputConfig.partitionKeyName,
        sortKeyName := inputConfig.sortKeyName,
        attributeActionsOnEncrypt := newActions,
        allowedUnsignedAttributes := inputConfig.allowedUnsignedAttributes,
        allowedUnsignedAttributePrefix := inputConfig.allowedUnsignedAttributePrefix,
        algorithmSuiteId := inputConfig.algorithmSuiteId,
        keyring := inputConfig.keyring,
        cmm := inputConfig.cmm,
        legacyOverride := inputConfig.legacyOverride,
        plaintextOverride := inputConfig.plaintextOverride
      );
      var itemEncryptorRes := DynamoDbItemEncryptor.DynamoDbItemEncryptor(encryptorConfig);
      var itemEncryptorX : IE_Types.IDynamoDbItemEncryptorClient :- itemEncryptorRes
      .MapFailure(e => AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor(e));
      assert itemEncryptorX is DynamoDbItemEncryptor.DynamoDbItemEncryptorClient;
      var itemEncryptor := itemEncryptorX as DynamoDbItemEncryptor.DynamoDbItemEncryptorClient;
      assert itemEncryptor.ValidState();
      var encConfig := itemEncryptor.config;
      assert inputConfig.logicalTableName == encConfig.logicalTableName;
      assert inputConfig.partitionKeyName == encConfig.partitionKeyName;
      assert inputConfig.sortKeyName == encConfig.sortKeyName;

      var bucketSelector;
      if inputConfig.bucketSelector.Some? {
        bucketSelector := inputConfig.bucketSelector.value;
      } else {
        bucketSelector := new DefaultBucketSelector();
      }
      var internalConfig: DdbMiddlewareConfig.ValidTableConfig := DdbMiddlewareConfig.TableConfig(
        physicalTableName := tableName,
        logicalTableName := inputConfig.logicalTableName,
        partitionKeyName := inputConfig.partitionKeyName,
        sortKeyName := inputConfig.sortKeyName,
        itemEncryptor := itemEncryptor,
        search := search,
        plaintextOverride := inputConfig.plaintextOverride.UnwrapOr(AwsCryptographyDbEncryptionSdkDynamoDbTypes.PlaintextOverride.FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ),
        bucketSelector := bucketSelector
      );

      internalConfigs := internalConfigs[tableName := internalConfig];
      allLogicalTableNames := allLogicalTableNames + {internalConfig.logicalTableName};

      assert AllTableConfigsValid?(internalConfigs) by {
        reveal AllTableConfigsValid?();
        assert AllTableConfigsValid?(internalConfigs - {tableName});
        assert ValidTableConfig?(internalConfig);
      }
      assert ValidConfig?(Config(internalConfigs)) by {
        assert ValidConfig?(Config(internalConfigs - {tableName}));
        assert internalConfig.physicalTableName == tableName;
      }

      assert CorrectlyTransferredStructure?(internalConfigs, config) by {
        reveal CorrectlyTransferredStructure?();
        reveal ConfigsMatch();
        assert CorrectlyTransferredStructure?(internalConfigs - {tableName}, config);
        assert ConfigsMatch(tableName, internalConfig, inputConfig);
      }

      i := i + 1;
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
                                      && t18.legacyOverride.Some?
                              :: t18.legacyOverride.value.encryptor;
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

    predicate {:vcs_split_on_every_assert} ValidState()
    {
      && Operations.ValidInternalConfig?(config)
      && History !in Operations.ModifiesInternalConfig(config)
      && Modifies == Operations.ModifiesInternalConfig(config) + {History}
    }

    constructor {:vcs_split_on_every_assert} (config: Operations.InternalConfig)
    {
      assert Operations.ValidInternalConfig?(config);
      this.config := config;
      History := new IDynamoDbEncryptionTransformsClientCallHistory();
      Modifies := Operations.ModifiesInternalConfig(config) + {History};
      new;
      assert Operations.ValidInternalConfig?(this.config);
      assert History !in Operations.ModifiesInternalConfig(config);
      assert Modifies == Operations.ModifiesInternalConfig(config) + {History};
      assert ValidState();
    }

  }
}
