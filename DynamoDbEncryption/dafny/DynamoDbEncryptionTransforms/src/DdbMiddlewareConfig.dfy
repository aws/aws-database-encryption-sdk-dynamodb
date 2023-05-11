// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../Model/AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.dfy"

module DdbMiddlewareConfig {
  import opened Wrappers
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
  import DynamoDbItemEncryptor
  import EncTypes = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import DDBE = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import SearchableEncryptionInfo
  
  datatype TableConfig = TableConfig(
    physicalTableName: ComAmazonawsDynamodbTypes.TableName,
    logicalTableName: string,
    partitionKeyName: string,
    sortKeyName: Option<string>,
    itemEncryptor: DynamoDbItemEncryptor.DynamoDbItemEncryptorClient,
    search : Option<SearchableEncryptionInfo.ValidSearchInfo>
  )

  predicate ValidTableConfig?(config: TableConfig) {
    var encryptorConfig := config.itemEncryptor.config;
    && config.logicalTableName == encryptorConfig.logicalTableName
    && config.partitionKeyName == encryptorConfig.partitionKeyName
    && config.sortKeyName == encryptorConfig.sortKeyName
    && config.itemEncryptor.ValidState()
    && OneSearchValidState(config)
  }

  type ValidTableConfig = c: TableConfig | ValidTableConfig?(c) witness *

  function OneSearchModifies(config : ValidTableConfig) : set<object>
  {
    if config.search.Some? then config.search.value.Modifies() else {}
  }
  function SearchModifies(config: Config) : set<object>
  {
    //set x, y | y in config.tableEncryptionConfigs && x in OneSearchModifies(config.tableEncryptionConfigs[y]) :: x
    set versions <- set configValue <- config.tableEncryptionConfigs.Values | configValue.search.Some? :: configValue.search.value.versions,
    keyStore <- set version <- versions :: version.keySource.store,
    obj <- keyStore.Modifies | obj in keyStore.Modifies :: obj

  }

  predicate OneSearchValidState(config : TableConfig)
  {
    && (config.search.Some? ==> config.search.value.ValidState())
  }
  predicate SearchValidState(config: Config)
  {
    forall k <- config.tableEncryptionConfigs :: OneSearchValidState(config.tableEncryptionConfigs[k])
  }

  function ModifiesConfig(config: Config) : set<object>
  {
    (set t <- config.tableEncryptionConfigs.Keys, o <- config.tableEncryptionConfigs[t].itemEncryptor.Modifies :: o)
    + (set t <- config.tableEncryptionConfigs.Keys, o <- OneSearchModifies(config.tableEncryptionConfigs[t]) :: o)
  }

  predicate ValidConfig?(config: Config)
  {
    && (forall tableName <- config.tableEncryptionConfigs ::
        config.tableEncryptionConfigs[tableName].physicalTableName == tableName)
    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#logical-table-name
    //# When mapping [DynamoDB Table Names](#dynamodb-table-name) to [logical table name](#logical-table-name)
    //# there MUST a one to one mapping between the two.
    && (forall
        c1 <- config.tableEncryptionConfigs.Values,
        c2 <- config.tableEncryptionConfigs.Values
      | c1 != c2
      :: c1.logicalTableName != c2.logicalTableName
    )
  }


  datatype Config = Config(
    tableEncryptionConfigs: map<string, ValidTableConfig>
  )

  function method MapError<T>(r : Result<T, EncTypes.Error>) : Result<T, Error> {
    r.MapFailure(e => AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor(e))
  }

  function method MapString<T>(r : Result<T, string>) : Result<T, Error> {
    r.MapFailure(e => Error.DynamoDbEncryptionTransformsException(message := e))
  }

  // string to Error
  function method E(s : string) : Error {
    DynamoDbEncryptionTransformsException(message := s)
  }

  function method MakeError<X>(s : string) : Result<X, Error>
  {
    Failure(Error.DynamoDbEncryptionTransformsException(message := s))
  }

  predicate SameOption<X>(x : Option<X>, y : Option<X>)
  {
    (x.Some? && y.Some?) || (x.None? && y.None?)
  }
}
