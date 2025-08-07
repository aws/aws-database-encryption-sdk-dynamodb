// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../Model/AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.dfy"

module DdbMiddlewareConfig {
  import opened Wrappers
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
  import opened StandardLibrary.UInt
  import DynamoDbItemEncryptor
  import EncTypes = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import DDBE = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import SearchableEncryptionInfo
  import DDB = ComAmazonawsDynamodbTypes
  import HexStrings
  import StandardLibrary.String

  datatype TableConfig = TableConfig(
    physicalTableName: DDB.TableName,
    logicalTableName: string,
    partitionKeyName: string,
    sortKeyName: Option<string>,
    itemEncryptor: DynamoDbItemEncryptor.DynamoDbItemEncryptorClient,
    search : Option<SearchableEncryptionInfo.ValidSearchInfo>,
    plaintextOverride: AwsCryptographyDbEncryptionSdkDynamoDbTypes.PlaintextOverride
  )

  // return true if records written to the table should NOT be encrypted or otherwise modified
  predicate method IsPlainWrite(config : Config, tableName : string)
  {
    || tableName !in config.tableEncryptionConfigs
    || config.tableEncryptionConfigs[tableName].plaintextOverride == AwsCryptographyDbEncryptionSdkDynamoDbTypes.PlaintextOverride.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ
  }

  method GetRandomBucket(config : TableConfig, item : DDB.AttributeMap) returns (output : Result<DDBE.BucketNumber, Error>)
    modifies if config.search.Some? then config.search.value.curr().bucketSelector.Modifies else {}
    requires if config.search.Some? then config.search.value.curr().bucketSelector.ValidState() else true
    ensures if config.search.Some? then config.search.value.curr().bucketSelector.ValidState() else true
  {
    if config.search.None? {
      return Success(0);
    }
    var numBuckets := config.search.value.versions[0].numBuckets;
    if numBuckets <= 1 {
      return Success(0);
    }

    var outR := config.search.value.curr().bucketSelector.GetBucketNumber(DDBE.GetBucketNumberInput(item := item, numberOfBuckets := numBuckets));
    var out :- outR.MapFailure(e => AwsCryptographyDbEncryptionSdkDynamoDb(e));
    if out.bucketNumber == 0 {
      return Success(0);
    } else if numBuckets as DDBE.BucketCount <= out.bucketNumber {
      return Failure(E("Bucket Selector returned " + String.Base10Int2String(out.bucketNumber as int) + " which should have been no more than " + String.Base10Int2String(numBuckets as int)));
    } else if out.bucketNumber < 0 {
      return Failure(E("Bucket Selector returned " + String.Base10Int2String(out.bucketNumber as int) + " which should have been positive."));
    } else {
      return Success(out.bucketNumber);
    }
  }

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
    set
      versions <- (set configValue <- config.tableEncryptionConfigs.Values | configValue.search.Some? :: configValue.search.value.versions),
      keyStore <- (set version <- versions :: version.keySource.store),
      obj <- keyStore.Modifies
             {:nowarn} :: obj

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

  function method AttrToString(attr : DDB.AttributeValue) : string
  {
    if attr.S? then
      attr.S
    else if attr.N? then
      attr.N
    else if attr.B? then
      HexStrings.ToHexString(attr.B)
    else
      "unexpected key type"
  }

  // return human readable string containing primary keys
  function method KeyString(config : ValidTableConfig, item : DDB.AttributeMap) : string
  {
    var partition :=
      if config.partitionKeyName in item then
        config.partitionKeyName + " = " + AttrToString(item[config.partitionKeyName])
      else
        "";
    var sort :=
      if config.sortKeyName.Some? && config.sortKeyName.value in item then
        "; " + config.sortKeyName.value + " = " + AttrToString(item[config.sortKeyName.value])
      else
        "";

    partition + sort
  }

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
