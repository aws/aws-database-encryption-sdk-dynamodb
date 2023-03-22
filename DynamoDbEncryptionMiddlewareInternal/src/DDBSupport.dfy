// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

/*
  Modified DDB calls share a lot of infrastructure.
  This file captures that commonality, implementing the things in ddb-support.md
*/

include "DdbMiddlewareConfig.dfy"
include "../../DynamoDbItemEncryptor/src/DDBSupport.dfy"

module DynamoDBMiddlewareSupport { 

  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened BS = DynamoDBSupport
  import opened DdbMiddlewareConfig

  // IsWritable examines an AttributeMap and fails if it is unsuitable for writing.
  // Generally this means that no attribute names starts with "aws_dbe_"
  function method {:opaque} IsWriteable(config : ValidTableConfig, item : DDB.AttributeMap)
    : Result<bool, Error>
  {
    BS.IsWriteable(config.itemEncryptor.config, item)
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
    BS.TestConditionExpression(config.itemEncryptor.config, expr, attrNames, attrValues)
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
    BS.TestUpdateExpression(config.itemEncryptor.config, expr, attrNames, attrValues)
      .MapFailure(e => E(e))
  }

  // AddBeacons examines an AttributeMap and modifies it to be appropriate for Searchable Encryption,
  // returning a replacement AttributeMap.
  function method {:opaque} AddBeacons(config : ValidTableConfig, item : DDB.AttributeMap)
    : Result<DDB.AttributeMap, Error>
  {
    BS.AddBeacons(config.itemEncryptor.config, item)
      .MapFailure(e => E(e))
  }

  // RemoveBeacons examines an AttributeMap and modifies it to be appropriate for customer use,
  // returning a replacement AttributeMap.
  function method {:opaque} RemoveBeacons(config : ValidTableConfig, item : DDB.AttributeMap)
    : Result<DDB.AttributeMap, Error>
  {
    BS.RemoveBeacons(config.itemEncryptor.config, item)
      .MapFailure(e => E(e))
  }

  // Transform a CreateTableInput object for searchable encryption.
  function method {:opaque} CreateTableInputForBeacons(config : ValidTableConfig, req : DDB.CreateTableInput)
    : Result<DDB.CreateTableInput, Error>
  {
    BS.CreateTableInputForBeacons(config.itemEncryptor.config, req)
      .MapFailure(e => E(e))
  }

  // Transform a UpdateTableInput object for searchable encryption.
  function method {:opaque} UpdateTableInputForBeacons(config : ValidTableConfig, req : DDB.UpdateTableInput)
    : Result<DDB.UpdateTableInput, Error>
  {
    BS.UpdateTableInputForBeacons(config.itemEncryptor.config, req)
      .MapFailure(e => E(e))
  }

  // Transform a DescribeTableOutput object for searchable encryption.
  function method {:opaque} DescribeTableOutputForBeacons(config : ValidTableConfig, req : DDB.DescribeTableOutput)
    : Result<DDB.DescribeTableOutput, Error>
  {
    BS.DescribeTableOutputForBeacons(config.itemEncryptor.config, req)
      .MapFailure(e => E(e))
  }

  // Transform a QueryInput object for searchable encryption.
  function method {:opaque} QueryInputForBeacons(config : ValidTableConfig, req : DDB.QueryInput)
    : Result<DDB.QueryInput, Error>
  {
    BS.QueryInputForBeacons(config.itemEncryptor.config, req)
      .MapFailure(e => E(e))
  }

  // Transform a QueryOutput object for searchable encryption.
  function method {:opaque} QueryOutputForBeacons(config : ValidTableConfig, req : DDB.QueryInput, resp : DDB.QueryOutput)
    : (ret : Result<DDB.QueryOutput, Error>)
    requires resp.Items.Some?
    ensures ret.Success? ==>
      && ret.value.Items.Some?
      && |ret.value.Items.value| == |resp.Items.value|
  {
    BS.QueryOutputForBeacons(config.itemEncryptor.config, req, resp)
      .MapFailure(e => E(e))
  }

  // Transform a ScanInput object for searchable encryption.
  function method {:opaque} ScanInputForBeacons(config : ValidTableConfig, req : DDB.ScanInput)
    : Result<DDB.ScanInput, Error>
  {
    BS.ScanInputForBeacons(config.itemEncryptor.config, req)
      .MapFailure(e => E(e))
  }

  // Transform a ScanOutput object for searchable encryption.
  function method {:opaque} ScanOutputForBeacons(config : ValidTableConfig, req : DDB.ScanInput, resp : DDB.ScanOutput)
    : (ret : Result<DDB.ScanOutput, Error>)
    requires resp.Items.Some?
    ensures ret.Success? ==>
      && ret.value.Items.Some?
      && |ret.value.Items.value| == |resp.Items.value|
  {
    BS.ScanOutputForBeacons(config.itemEncryptor.config, req, resp)
      .MapFailure(e => E(e))
  }
}
