// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

/*
  Modified DDB calls share a lot of infrastructure.
  This file captures that commonality, implementing the things in ddb-support.md

  TODO - specify and implement these functions
*/

include "../Model/AwsCryptographyDynamoDbItemEncryptorTypes.dfy"
include "AwsCryptographyDynamoDbItemEncryptorOperations.dfy"
include "Util.dfy"

module DynamoDBSupport { 

  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDynamoDbItemEncryptorTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened DynamoDbItemEncryptorUtil
  import opened AwsCryptographyDynamoDbItemEncryptorOperations
  import UTF8
  import SortedSets
  import Seq
  import SE = StructuredEncryptionUtil
  // IsWritable examines an AttributeMap and fails if it is unsuitable for writing.
  // Generally this means that no attribute names starts with "aws_dbe_"
  // an no field has the same name as a virtual field or virtual database field.
  function method IsWriteable(config : Config, item : DDB.AttributeMap)
    : Result<bool, string>
  {
    Success(true)
  }

  // TestConditionExpression fails if a condition expression is not suitable for the
  // given encryption schema.
  // Generally this means no encrypted attribute is referenced.
  function method TestConditionExpression(
    config : Config,
    expr: Option<DDB.ConditionExpression>,
    attrNames: Option<DDB.ExpressionAttributeNameMap>,
    attrValues: Option<DDB.ExpressionAttributeValueMap>
  )
    : Result<bool, string>
  {
    if expr.Some? then
      Failure("Condition Expressions forbidden on encrypted tables")
    else
      Success(true)
  }

  // TestUpdateExpression fails if an update expression is not suitable for the
  // given encryption schema.
  // Generally this means no signed attribute is referenced.
  function method TestUpdateExpression(
    config : Config,
    expr: Option<DDB.UpdateExpression>,
    attrNames: Option<DDB.ExpressionAttributeNameMap>,
    attrValues: Option<DDB.ExpressionAttributeValueMap>
  )
    : Result<bool, string>
  {
    if expr.Some? then
      Failure("Update Expressions forbidden on encrypted tables")
    else
      Success(true)
  }

  // AddBeacons examines an AttributeMap and modifies it to be appropriate for Searchable Encryption,
  // returning a replacement AttributeMap.
  function method AddBeacons(config : Config, item : DDB.AttributeMap)
    : Result<DDB.AttributeMap, string>
  {
    Success(item)
  }

  // RemoveBeacons examines an AttributeMap and modifies it to be appropriate for customer use,
  // returning a replacement AttributeMap.
  function method RemoveBeacons(config : Config, item : DDB.AttributeMap)
    : Result<DDB.AttributeMap, string>
  {
    Success(item)
  }

  // Transform a CreateTableInput object for searchable encryption.
  function method CreateTableInputForBeacons(config : Config, req : DDB.CreateTableInput)
    : Result<DDB.CreateTableInput, string>
  {
    Success(req)
  }

  // Transform a UpdateTableInput object for searchable encryption.
  function method UpdateTableInputForBeacons(config : Config, req : DDB.UpdateTableInput)
    : Result<DDB.UpdateTableInput, string>
  {
    Success(req)
  }

  // Transform a QueryInput object for searchable encryption.
  function method QueryInputForBeacons(config : Config, req : DDB.QueryInput)
    : Result<DDB.QueryInput, string>
  {
    Success(req)
  }

  // Transform a QueryOutput object for searchable encryption.
  function method QueryOutputForBeacons(config : Config, req : DDB.QueryInput, resp : DDB.QueryOutput)
    : (ret : Result<DDB.QueryOutput, string>)
    requires resp.Items.Some?
    ensures ret.Success? ==>
      && ret.value.Items.Some?
      && |ret.value.Items.value| == |resp.Items.value|
  {
    Success(resp)
  }

  // Transform a ScanInput object for searchable encryption.
  function method ScanInputForBeacons(config : Config, req : DDB.ScanInput)
    : Result<DDB.ScanInput, string>
  {
    Success(req)
  }

  // Transform a ScanOutput object for searchable encryption.
  function method ScanOutputForBeacons(config : Config, req : DDB.ScanInput, resp : DDB.ScanOutput)
    : (ret : Result<DDB.ScanOutput, string>)
    requires resp.Items.Some?
    ensures ret.Success? ==>
      && ret.value.Items.Some?
      && |ret.value.Items.value| == |resp.Items.value|
  {
    Success(resp)
  }
}
