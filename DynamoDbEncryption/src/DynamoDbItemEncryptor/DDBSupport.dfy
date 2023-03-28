// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

/*
  Modified DDB calls share a lot of infrastructure.
  This file captures that commonality, implementing the things in ddb-support.md

  TODO - specify and implement these functions
*/

include "../../Model/AwsCryptographyDynamoDbEncryptionItemEncryptorTypes.dfy"
include "AwsCryptographyDynamoDbEncryptionItemEncryptorOperations.dfy"
include "Util.dfy"
include "VirtualDDB.dfy"
include "UpdateExpr.dfy"
include "FilterExpr.dfy"
include "DDBIndex.dfy"

module DynamoDBSupport { 

  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDynamoDbEncryptionItemEncryptorTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened DynamoDbItemEncryptorUtil
  import opened AwsCryptographyDynamoDbEncryptionItemEncryptorOperations
  import opened VirtualDDBFields
  import opened DynamoDBIndexSupport
  import UTF8
  import SortedSets
  import Seq
  import Update = DynamoDbUpdateExpr
  import SET = AwsCryptographyStructuredEncryptionTypes
  import Filter = DynamoDBFilterExpr


  // IsWritable examines an AttributeMap and fails if it is unsuitable for writing.
  // At the moment, this means that no attribute names starts with "aws_dbe_",
  // as all other attribute names would need to be configured, and all the
  // other weird constraints were checked at configuration time.
  function method IsWriteable(config : ValidConfig, item : DDB.AttributeMap)
    : Result<bool, string>
  {
    if forall k <- item :: !(ReservedPrefix <= k) then
      Success(true)
    else
      var bad := set k <- item | ReservedPrefix <= k;
      var badSeq := SortedSets.ComputeSetToOrderedSequence2(bad, CharLess);
      if |badSeq| == 0 then
        Failure("")
      else
        Failure("Writing reserved attributes not allowed : " + Join(badSeq, "\n"))
  }

  function method GetEncryptedAttributes(
    config : ValidConfig,
    expr : Option<string>,
    attrNames : Option<DDB.ExpressionAttributeNameMap> )
    : seq<string>
  {
    if expr.None? then
      []
    else
      var attrs := Filter.ExtractAttributes(expr.value, attrNames);
      Seq.Filter((attr : string) => IsEncrypted(config, attr), attrs)
  }


  // TestConditionExpression fails if a condition expression is not suitable for the
  // given encryption schema.
  // Generally this means no encrypted attribute is referenced.
  function method TestConditionExpression(
    config : ValidConfig,
    expr: Option<DDB.ConditionExpression>,
    attrNames: Option<DDB.ExpressionAttributeNameMap>,
    attrValues: Option<DDB.ExpressionAttributeValueMap>
  )
    : Result<bool, string>
  {
    if expr.Some? then
      var attrs := GetEncryptedAttributes(config, expr, attrNames);
      if |attrs| == 0 then
        Success(true)
      else
        Failure("Condition Expressions forbidden on encrypted attributes : " + Join(attrs, ","))
    else
      Success(true)
  }

  predicate method IsEncrypted(config : ValidConfig, attr : string)
  {
    && attr in config.attributeActions
    && config.attributeActions[attr] == SET.ENCRYPT_AND_SIGN
  }

  predicate method IsSigned(config : ValidConfig, attr : string)
  {
    && attr in config.attributeActions
    && config.attributeActions[attr] != SET.DO_NOTHING
  }

  // TestUpdateExpression fails if an update expression is not suitable for the
  // given encryption schema.
  // Generally this means no signed attribute is referenced.
  function method TestUpdateExpression(
    config : ValidConfig,
    expr: Option<DDB.UpdateExpression>,
    attrNames: Option<DDB.ExpressionAttributeNameMap>,
    attrValues: Option<DDB.ExpressionAttributeValueMap>
  )
    : Result<bool, string>
  {
    if expr.Some? then
      var attrs := Update.ExtractAttributes(expr.value, attrNames);
      var encryptedAttrs := Seq.Filter(s => IsSigned(config, s), attrs);
      if |encryptedAttrs| == 0 then
        Success(true)
      else
        Failure("Update Expressions forbidden on signed attributes : " + Join(encryptedAttrs, ","))
    else
      Success(true)
  }

  // AddBeacons examines an AttributeMap and modifies it to be appropriate for Searchable Encryption,
  // returning a replacement AttributeMap.
  function method AddBeacons(config : ValidConfig, item : DDB.AttributeMap)
    : Result<DDB.AttributeMap, string>
  {
    if config.beacons.None? then
      Success(item)
    else
      var newItems :- config.beacons.value.GenerateBeacons(t => TermToString(t, item), t => TermToBytes(t, item))
        .MapFailure(e => "Error generating beacons");
      var newAttrs := map k <- newItems :: k := DS(newItems[k]);
      var version := DS(VersionPrefix + "1");
      Success(item + newAttrs)
  }

  // RemoveBeacons examines an AttributeMap and modifies it to be appropriate for customer use,
  // returning a replacement AttributeMap.
  function method RemoveBeacons(config : ValidConfig, item : DDB.AttributeMap)
    : Result<DDB.AttributeMap, string>
  {
    if config.beacons.None? then
      Success(item)
    else
      Success(map k <- item | (!(ReservedPrefix <= k)) :: k := item[k])
  }

  // transform optional LSIs for searchable encryption, changing AttributeDefinitions as needed
  function method LsiOptWithAttrs(config : ValidConfig, schema : Option<DDB.LocalSecondaryIndexList>, attrs : DDB.AttributeDefinitions)
    : Result<(Option<DDB.LocalSecondaryIndexList>, DDB.AttributeDefinitions), string>
  {
    if schema.None? || config.beacons.None? then
      Success((schema, []))
    else
      var (newSchema, newAttrs) :- LsiWithAttrs(config, schema.value, attrs);
      Success((Some(newSchema), newAttrs))
  }

  // transform optional GSIs for searchable encryption, changing AttributeDefinitions as needed
  function method GsiOptWithAttrs(config : ValidConfig, schema : Option<DDB.GlobalSecondaryIndexList>, attrs : DDB.AttributeDefinitions)
    : Result<(Option<DDB.GlobalSecondaryIndexList>, DDB.AttributeDefinitions), string>
  {
    if schema.None? || config.beacons.None? then
      Success((schema, []))
    else
      var (newSchema, newAttrs) :- GsiWithAttrs(config, schema.value, attrs);
      Success((Some(newSchema), newAttrs))
  }

  // Transform a CreateTableInput object for searchable encryption.
  function method CreateTableInputForBeacons(config : ValidConfig, req : DDB.CreateTableInput)
    : Result<DDB.CreateTableInput, string>
  {
    if config.beacons.None? then
      Success(req)
    else
      var (newSchema, newAttrs) :- AddBeaconsToKeySchema(config, req.KeySchema, req.AttributeDefinitions);
      var (newLsi, newAttrs) :- LsiOptWithAttrs(config, req.LocalSecondaryIndexes, newAttrs);
      var (newGsi, newAttrs) :- GsiOptWithAttrs(config, req.GlobalSecondaryIndexes, newAttrs);
      Success(req.(
        KeySchema := newSchema,
        AttributeDefinitions := newAttrs,
        LocalSecondaryIndexes := newLsi,
        GlobalSecondaryIndexes := newGsi
      ))
  }

  // Transform a UpdateTableInput object for searchable encryption.
  function method UpdateTableInputForBeacons(config : ValidConfig, req : DDB.UpdateTableInput)
    : Result<DDB.UpdateTableInput, string>
  {
    if config.beacons.None? || req.GlobalSecondaryIndexUpdates.None? then
      Success(req)
    else
      var (indexes, attrs) :- TransformIndexUpdates(config, req.GlobalSecondaryIndexUpdates.value, req.AttributeDefinitions.UnwrapOr([]));
      var newAttrs := if |attrs| == 0 then None else Some(attrs);
      Success(req.(GlobalSecondaryIndexUpdates := Some(indexes), AttributeDefinitions := newAttrs))
  }

  // Transform a DescribeTableOutput object for searchable encryption.
  function method DescribeTableOutputForBeacons(config : ValidConfig, req : DDB.DescribeTableOutput)
    : Result<DDB.DescribeTableOutput, string>
  {
    if config.beacons.None? || req.Table.None? then
      Success(req)
    else
      var locals :- TransformLocalIndexDescription(config, req.Table.value.LocalSecondaryIndexes);
      var globals :- TransformGlobalIndexDescription(config, req.Table.value.GlobalSecondaryIndexes);
      Success(
        DDB.DescribeTableOutput(
          Table := Some(
            req.Table.value.(LocalSecondaryIndexes := locals, GlobalSecondaryIndexes := globals)
          )
        )
      )
  }

  // Transform a QueryInput object for searchable encryption.
  function method QueryInputForBeacons(config : ValidConfig, req : DDB.QueryInput)
    : Result<DDB.QueryInput, string>
  {
    Success(req)
  }

  // Transform a QueryOutput object for searchable encryption.
  function method QueryOutputForBeacons(config : ValidConfig, req : DDB.QueryInput, resp : DDB.QueryOutput)
    : (ret : Result<DDB.QueryOutput, string>)
    requires resp.Items.Some?
    ensures ret.Success? ==>
      && ret.value.Items.Some?
      && |ret.value.Items.value| == |resp.Items.value|
  {
    Success(resp)
  }

  // Transform a ScanInput object for searchable encryption.
  function method ScanInputForBeacons(config : ValidConfig, req : DDB.ScanInput)
    : Result<DDB.ScanInput, string>
  {
    Success(req)
  }

  // Transform a ScanOutput object for searchable encryption.
  function method ScanOutputForBeacons(config : ValidConfig, req : DDB.ScanInput, resp : DDB.ScanOutput)
    : (ret : Result<DDB.ScanOutput, string>)
    requires resp.Items.Some?
    ensures ret.Success? ==>
      && ret.value.Items.Some?
      && |ret.value.Items.value| == |resp.Items.value|
  {
    Success(resp)
  }

}
