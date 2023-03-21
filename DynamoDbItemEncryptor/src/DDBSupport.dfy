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
include "VirtualDDB.dfy"
include "UpdateExpr.dfy"

module DynamoDBSupport { 

  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDynamoDbItemEncryptorTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened DynamoDbItemEncryptorUtil
  import opened AwsCryptographyDynamoDbItemEncryptorOperations
  import opened VirtualDDBFields
  import UTF8
  import SortedSets
  import Seq
  import SE = StructuredEncryptionUtil
  import Update = DynamoDbUpdateExpr
  import SET = AwsCryptographyStructuredEncryptionTypes

  // IsWritable examines an AttributeMap and fails if it is unsuitable for writing.
  // At the moment, this means that no attribute names starts with "aws_dbe_",
  // as all other attribute names would need to be configured, and all the
  // other weird constraints were checked at configuration time.
  function method IsWriteable(config : Config, item : DDB.AttributeMap)
    : Result<bool, string>
  {
    if forall k <- item :: !(SE.ReservedPrefix <= k) then
      Success(true)
    else
      var bad := set k <- item | SE.ReservedPrefix <= k;
      var badSeq := SortedSets.ComputeSetToOrderedSequence2(bad, SE.CharLess);
      if |badSeq| == 0 then
        Failure("")
      else
        Failure("Writing reserved attributes not allowed : " + Join(badSeq, "\n"))
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

  predicate method IsEncrypted(config : Config, attr : string)
  {
    && attr in config.attributeActions
    && config.attributeActions[attr] == SET.ENCRYPT_AND_SIGN
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
      var attrs := Update.ExtractAttributes(expr.value, attrNames);
      var encryptedAttrs := Seq.Filter(s => IsEncrypted(config, s), attrs);
      if |encryptedAttrs| == 0 then
        Success(true)
      else
        Failure("Update Expressions forbidden on encrypted attributes : " + Join(encryptedAttrs, ","))
    else
      Success(true)
  }

  // AddBeacons examines an AttributeMap and modifies it to be appropriate for Searchable Encryption,
  // returning a replacement AttributeMap.
  function method AddBeacons(config : Config, item : DDB.AttributeMap)
    : Result<DDB.AttributeMap, string>
    requires ValidInternalConfig?(config)
  {
    if config.beacons.None? then
      Success(item)
    else
      var newItems :- config.beacons.value.GenerateBeacons(t => TermToString(t, item), t => TermToBytes(t, item))
        .MapFailure(e => "Error generating beacons");
      var newAttrs := map k <- newItems :: k := DS(newItems[k]);
      Success(item + newAttrs)
  }

  // RemoveBeacons examines an AttributeMap and modifies it to be appropriate for customer use,
  // returning a replacement AttributeMap.
  function method RemoveBeacons(config : Config, item : DDB.AttributeMap)
    : Result<DDB.AttributeMap, string>
  {
    if config.beacons.None? then
      Success(item)
    else
      Success(map k <- item | (!(SE.ReservedPrefix <= k)) :: k := item[k])
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
