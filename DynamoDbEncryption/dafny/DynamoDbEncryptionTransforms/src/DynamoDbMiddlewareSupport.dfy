// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

/*
  Modified DDB calls share a lot of infrastructure.
  This file captures that commonality, implementing the things in ddb-support.md
*/

include "DdbMiddlewareConfig.dfy"
include "../../DynamoDbEncryption/src/DDBSupport.dfy"

module DynamoDbMiddlewareSupport {

  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDynamoDbEncryptionTransformsTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened BS = DynamoDBSupport
  import opened DdbMiddlewareConfig
  import AwsCryptographyDynamoDbEncryptionItemEncryptorOperations

  // IsWritable examines an AttributeMap and fails if it is unsuitable for writing.
  // Generally this means that no attribute names starts with "aws_dbe_"
  function method {:opaque} IsWriteable(config : ValidTableConfig, item : DDB.AttributeMap)
    : Result<bool, Error>
  {
    BS.IsWriteable(item)
      .MapFailure(e => E(e))
  }

  // TestConditionExpression fails if a condition expression is not suitable for the
  // given encryption schema.
  // Generally this means no encrypted attribute is referenced.
  function method {:opaque} TestConditionExpression(
    config : ValidTableConfig,
    expr: Option<DDB.ConditionExpression>,
    attrNames: Option<DDB.ExpressionAttributeNameMap>,
    attrValues: Option<DDB.ExpressionAttributeValueMap>
  )
    : Result<bool, Error>
  {
    BS.TestConditionExpression(config.itemEncryptor.config.attributeActions, expr, attrNames, attrValues)
      .MapFailure(e => E(e))
  }

  // TestUpdateExpression fails if an update expression is not suitable for the
  // given encryption schema.
  // Generally this means no signed attribute is referenced.
  function method {:opaque} TestUpdateExpression(
    config : ValidTableConfig,
    expr: Option<DDB.UpdateExpression>,
    attrNames: Option<DDB.ExpressionAttributeNameMap>,
    attrValues: Option<DDB.ExpressionAttributeValueMap>
  )
    : Result<bool, Error>
  {
    BS.TestUpdateExpression(config.itemEncryptor.config.attributeActions, expr, attrNames, attrValues)
      .MapFailure(e => E(e))
  }

  // AddSignedBeacons examines an AttributeMap and modifies it to be appropriate for Searchable Encryption,
  // returning a replacement AttributeMap.
  method AddSignedBeacons(config : ValidTableConfig, item : DDB.AttributeMap)
    returns (output : Result<DDB.AttributeMap, Error>)
    requires AwsCryptographyDynamoDbEncryptionItemEncryptorOperations.ValidInternalConfig?(config.itemEncryptor.config)
    requires OneSearchValidState(config)
    ensures OneSearchValidState(config)
    modifies OneSearchModifies(config)
  {
    var ret := BS.AddSignedBeacons(config.search, item);
    return ret.MapFailure(e => AwsCryptographyDynamoDbEncryption(e));
  }

  // GetEncryptedBeacons examines an AttributeMap and modifies it to be appropriate for Searchable Encryption,
  // returning just the new items.
  method GetEncryptedBeacons(config : ValidTableConfig, item : DDB.AttributeMap, keyId : Option<string>)
    returns (output : Result<DDB.AttributeMap, Error>)
    requires AwsCryptographyDynamoDbEncryptionItemEncryptorOperations.ValidInternalConfig?(config.itemEncryptor.config)
    requires OneSearchValidState(config)
    ensures OneSearchValidState(config)
    modifies OneSearchModifies(config)
  {
    var ret := BS.GetEncryptedBeacons(config.search, item, keyId);
    return ret.MapFailure(e => AwsCryptographyDynamoDbEncryption(e));
  }

  function method GetBeaconKeyId(config : ValidTableConfig,
    keyExpr : Option<DDB.ConditionExpression>,
    filterExpr : Option<DDB.ConditionExpression>,
    values: Option<DDB.ExpressionAttributeValueMap>,
    names : Option<DDB.ExpressionAttributeNameMap>
  )
    : Result<Option<string>, Error>
  {
    BS.GetBeaconKeyId(config.search, keyExpr, filterExpr, values, names)
      .MapFailure(e => AwsCryptographyDynamoDbEncryption(e))
  }

  // RemoveBeacons examines an AttributeMap and modifies it to be appropriate for customer use,
  // returning a replacement AttributeMap.
  function method {:opaque} RemoveBeacons(config : ValidTableConfig, item : DDB.AttributeMap)
    : Result<DDB.AttributeMap, Error>
  {
    BS.RemoveBeacons(config.search, item)
      .MapFailure(e => E(e))
  }

  // Transform a CreateTableInput object for searchable encryption.
  function method {:opaque} CreateTableInputForBeacons(config : ValidTableConfig, req : DDB.CreateTableInput)
    : Result<DDB.CreateTableInput, Error>
  {
    BS.CreateTableInputForBeacons(config.search, config.itemEncryptor.config.attributeActions, req)
      .MapFailure(e => AwsCryptographyDynamoDbEncryption(e))
  }

  // Transform a UpdateTableInput object for searchable encryption.
  function method {:opaque} UpdateTableInputForBeacons(config : ValidTableConfig, req : DDB.UpdateTableInput)
    : Result<DDB.UpdateTableInput, Error>
  {
    BS.UpdateTableInputForBeacons(config.search, config.itemEncryptor.config.attributeActions, req)
      .MapFailure(e => AwsCryptographyDynamoDbEncryption(e))
  }

  // Transform a DescribeTableOutput object for searchable encryption.
  function method {:opaque} DescribeTableOutputForBeacons(config : ValidTableConfig, req : DDB.DescribeTableOutput)
    : Result<DDB.DescribeTableOutput, Error>
  {
    BS.DescribeTableOutputForBeacons(config.search, req)
      .MapFailure(e => AwsCryptographyDynamoDbEncryption(e))
  }

  // Transform a QueryInput object for searchable encryption.
  method {:opaque} QueryInputForBeacons(config : ValidTableConfig, req : DDB.QueryInput)
    returns (output : Result<DDB.QueryInput, Error>)
    requires OneSearchValidState(config)
    ensures OneSearchValidState(config)
    modifies OneSearchModifies(config)
  {
    var ret := BS.QueryInputForBeacons(config.search, req);
    return ret.MapFailure(e => AwsCryptographyDynamoDbEncryption(e));
  }

  // Transform a QueryOutput object for searchable encryption.
  method QueryOutputForBeacons(config : ValidTableConfig, req : DDB.QueryInput, resp : DDB.QueryOutput)
    returns (output : Result<DDB.QueryOutput, Error>)
    requires resp.Items.Some?
    ensures output.Success? ==> output.value.Items.Some?
    requires OneSearchValidState(config)
    ensures OneSearchValidState(config)
    modifies OneSearchModifies(config)
  {
    var ret := BS.QueryOutputForBeacons(config.search, req, resp);
    return ret.MapFailure(e => AwsCryptographyDynamoDbEncryption(e));
  }

  // Transform a ScanInput object for searchable encryption.
  method ScanInputForBeacons(config : ValidTableConfig, req : DDB.ScanInput)
    returns (output : Result<DDB.ScanInput, Error>)
    requires OneSearchValidState(config)
    ensures OneSearchValidState(config)
    modifies OneSearchModifies(config)
  {
    var ret := BS.ScanInputForBeacons(config.search, req);
    return ret.MapFailure(e => AwsCryptographyDynamoDbEncryption(e));
  }

  // Transform a ScanOutput object for searchable encryption.
  method ScanOutputForBeacons(config : ValidTableConfig, req : DDB.ScanInput, resp : DDB.ScanOutput)
    returns (output : Result<DDB.ScanOutput, Error>)
    requires resp.Items.Some?
    ensures output.Success? ==> output.value.Items.Some?
    requires OneSearchValidState(config)
    ensures OneSearchValidState(config)
    modifies OneSearchModifies(config)
  {
    var ret := BS.ScanOutputForBeacons(config.search, req, resp);
    return ret.MapFailure(e => AwsCryptographyDynamoDbEncryption(e));
  }
}
