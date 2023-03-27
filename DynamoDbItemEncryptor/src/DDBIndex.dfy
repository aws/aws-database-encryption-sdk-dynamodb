// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

/*
  Support routines for Local and Global Index structures
*/

include "../Model/AwsCryptographyDynamoDbItemEncryptorTypes.dfy"
include "AwsCryptographyDynamoDbItemEncryptorOperations.dfy"
include "Util.dfy"
include "VirtualDDB.dfy"
include "UpdateExpr.dfy"
include "FilterExpr.dfy"

module DynamoDBIndexSupport { 

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
  import Filter = DynamoDBFilterExpr

  // transform beacon name to plain names
  function method UnbeaconString(s : string) : string
  {
    if SE.ReservedPrefix <= s then
      s[|SE.ReservedPrefix|..]
    else
      s
  }

  // transform beacon names to plain names in KeySchemaAttributeName
  function method UnbeaconKeySchemaAttributeName(s : DDB.KeySchemaAttributeName)
    : Result<DDB.KeySchemaAttributeName, string>
  {
    if SE.ReservedPrefix <= s then
      var ret := s[|SE.ReservedPrefix|..];
      if DDB.IsValid_KeySchemaAttributeName(ret) then
        Success(ret)
      else
        Failure("KeySchemaAttributeName " + s + " is invalid after removing prefix")
    else
      Success(s)
  }

  // transform beacon names to plain names in KeySchemaElement
  function method UnbeaconKeySchemaElement(s : DDB.KeySchemaElement)
    : Result<DDB.KeySchemaElement, string>
  {
    var name :- UnbeaconKeySchemaAttributeName(s.AttributeName);
    Success(s.(AttributeName := name))
  }

  // transform beacon names to plain names in KeySchema
  function method UnbeaconKeySchema(config : ValidConfig, schema : DDB.KeySchema)
    : Result<DDB.KeySchema, string>
  {
    Seq.MapWithResult((k : DDB.KeySchemaElement) => UnbeaconKeySchemaElement(k), schema)
  }

  // transform beacon names to plain names in Projection
  function method UnbeaconProjection(config : ValidConfig, projection : DDB.Projection)
    : Result<DDB.Projection, string>
  {
    if projection.NonKeyAttributes.None? then
      Success(projection)
    else
      var newAttributes := Seq.Filter((k : DDB.NonKeyAttributeName) => !(SE.ReservedPrefix <= k), projection.NonKeyAttributes.value);
      if DDB.IsValid_NonKeyAttributeNameList(newAttributes) then
        Success(projection.(NonKeyAttributes := Some(newAttributes)))
      else
        Failure("Project had invalid attribute name list")
  }

  // transform beacon names to plain names in Global Index Description
  function method TransformOneLocalIndexDescription(config : ValidConfig, index : DDB.LocalSecondaryIndexDescription)
    : Result<DDB.LocalSecondaryIndexDescription, string>
  {
    if index.KeySchema.None? then
      Success(index)
    else
      var newSchema :- UnbeaconKeySchema(config, index.KeySchema.value);
      Success(index.(KeySchema := Some(newSchema)))
  }

  // transform beacon names to plain names in Global Index Description
  function method TransformOneGlobalIndexDescription(config : ValidConfig, index : DDB.GlobalSecondaryIndexDescription)
    : Result<DDB.GlobalSecondaryIndexDescription, string>
  {
    var newKeySchema :-
    if index.KeySchema.None? then
      Success(None)
    else
      var schema :- UnbeaconKeySchema(config, index.KeySchema.value);
      Success(Some(schema));

    var newProjection :-
    if index.Projection.None? then
      Success(None)
    else
      var projection :- UnbeaconProjection(config, index.Projection.value);
      Success(Some(projection));

    Success(index.(KeySchema := newKeySchema, Projection := newProjection))
  }

  // transform beacon names to plain names in Local Index Descriptions
  function method TransformLocalIndexDescription(config : ValidConfig, req : Option<DDB.LocalSecondaryIndexDescriptionList>)
    : Result<Option<DDB.LocalSecondaryIndexDescriptionList>, string>
  {
    if req.None? then
      Success(req)
    else
      var nList :- Seq.MapWithResult((d :DDB.LocalSecondaryIndexDescription) => TransformOneLocalIndexDescription(config, d), req.value);
      Success(Some(nList))
  }

  // transform beacon names to plain names in Global Index Descriptions
  function method TransformGlobalIndexDescription(config : ValidConfig, req : Option<DDB.GlobalSecondaryIndexDescriptionList>)
    : Result<Option<DDB.GlobalSecondaryIndexDescriptionList>, string>
  {
    if req.None? then
      Success(req)
    else
      var nList :- Seq.MapWithResult((d :DDB.GlobalSecondaryIndexDescription) => TransformOneGlobalIndexDescription(config, d), req.value);
      Success(Some(nList))
  }

  predicate method IsBeacon(config : ValidConfig, name : string)
  {
    if config.beacons.None? then
      false
    else
      config.beacons.value.IsBeacon(name)
  }

  // make beacon name from attribute name
  function method MakeBeaconName(config : ValidConfig, name : string) : string
  {
    BeaconPrefix + name
  }

  // make beacon name from attribute name, fail if it's not a valid Key Schema Attribute Name
  function method MakeKeySchemaBeaconName(config : ValidConfig, name : string)
    : Result<DDB.KeySchemaAttributeName, string>
  {
    var newName := MakeBeaconName(config, name);
    if DDB.IsValid_KeySchemaAttributeName(newName) then
      Success(newName)
    else
      Failure("Can't make valid KeySchemaAttributeName from beacon for " + name)
  }

  // make beacon name from attribute name, fail if it's not a valid Non Key Attribute Name
  function method MakeNonKeyBeaconName(config : ValidConfig, name : string)
    : Result<DDB.NonKeyAttributeName, string>
  {
    var newName := MakeBeaconName(config, name);
    if DDB.IsValid_NonKeyAttributeName(newName) then
      Success(newName)
    else
      Failure("Can't make valid NonKeySchemaAttributeName from beacon for " + name)
  }

  // replace oldName with newName, and old type with String
  function method {:tailrecursion} ReplaceAttrDef(
    attrs : DDB.AttributeDefinitions,
    oldName : DDB.KeySchemaAttributeName,
    newName : DDB.KeySchemaAttributeName
  )
    : DDB.AttributeDefinitions
  {
    if |attrs| == 0 then
      attrs
    else if attrs[0].AttributeName == oldName then
      var newAttr := DDB.AttributeDefinition(AttributeName := newName, AttributeType := DDB.ScalarAttributeType.S);
      [newAttr] + ReplaceAttrDef(attrs[1..], oldName, newName)
    else
      [attrs[0]] + ReplaceAttrDef(attrs[1..], oldName, newName)
  }

  // transform KeySchemaElement for searchable encryption, changing AttributeDefinitions as needed
  function method AddBeaconsToKeySchemaElement(
    config : ValidConfig,
    element : DDB.KeySchemaElement,
    attrs : DDB.AttributeDefinitions
  )
    : Result<(DDB.KeySchemaElement, DDB.AttributeDefinitions), string>
  {
    if IsBeacon(config, element.AttributeName) then
      var newName :- MakeKeySchemaBeaconName(config, element.AttributeName);
      var newAttrs := ReplaceAttrDef(attrs, element.AttributeName, newName);
      Success((element.(AttributeName := newName), newAttrs))
    else if IsEncrypted(config, element.AttributeName) then
      Failure("You can't make an index on an encrypted attribute, unless you've configured a beacon for that attribute.")
    else
      Success((element, attrs))
  }

  // transform Projection for searchable encryption
  // for any beacon in the Projection, add the beacon name plus any attributes used to construct the beacon
  function method AddBeaconsToProjection(config : ValidConfig, proj : DDB.Projection)
    : Result<DDB.Projection, string>
    requires config.beacons.Some?
  {
    if proj.NonKeyAttributes.None? then
      Success(proj)
    else
      var newAttributes := config.beacons.value.GenerateClosure(proj.NonKeyAttributes.value);
      if (forall a <- newAttributes :: DDB.IsValid_NonKeyAttributeName(a)) && DDB.IsValid_NonKeyAttributeNameList(newAttributes) then
       Success(proj.(NonKeyAttributes := Some(newAttributes)))
      else
        Failure("Adding beacons to NonKeyAttributes of Projection in CreateGlobalSecondaryIndexAction exceeded the allowed number of projected attributes.")
  }

  // transform CreateGlobalSecondaryIndexAction for searchable encryption, changing AttributeDefinitions as needed
  function method TransformCreateGSIAction(
    config : ValidConfig,
    index : DDB.CreateGlobalSecondaryIndexAction,
    attrs : DDB.AttributeDefinitions
  )
    : Result<(DDB.CreateGlobalSecondaryIndexAction, DDB.AttributeDefinitions), string>
    requires config.beacons.Some?
  {
    var (newKeySchema, attrs) :- AddBeaconsToKeySchema(config, index.KeySchema, attrs);
    var newProjection :- AddBeaconsToProjection(config, index.Projection);
    Success((index.(KeySchema := newKeySchema, Projection := newProjection), attrs))
  }

  // transform GSI Updates for searchable encryption, changing AttributeDefinitions as needed
  function method TransformGlobalSecondaryIndexUpdate(
    config : ValidConfig,
    index : DDB.GlobalSecondaryIndexUpdate,
    attrs : DDB.AttributeDefinitions
  )
    : Result<(DDB.GlobalSecondaryIndexUpdate, DDB.AttributeDefinitions), string>
    requires config.beacons.Some?
  {
    if index.Create.None? then
      Success((index, attrs))
    else
      var (create, attrs) :- TransformCreateGSIAction(config, index.Create.value, attrs);
      Success((index.(Create := Some(create)), attrs))
  }

  // transform IndexUpdates for searchable encryption, changing AttributeDefinitions as needed
  function method {:tailrecursion} TransformIndexUpdates(
    config : ValidConfig,
    indexes : DDB.GlobalSecondaryIndexUpdateList,
    attrs : DDB.AttributeDefinitions,
    acc : DDB.GlobalSecondaryIndexUpdateList := []
  )
    : Result<(DDB.GlobalSecondaryIndexUpdateList, DDB.AttributeDefinitions), string>
    requires config.beacons.Some?
  {
    if |indexes| == 0 then
      Success((acc, attrs))
    else
      var (newIndex, newAttrs) :- TransformGlobalSecondaryIndexUpdate(config, indexes[0], attrs);
    TransformIndexUpdates(config, indexes[1..], newAttrs, acc + [newIndex])
  }

  // transform KeySchema for searchable encryption, changing AttributeDefinitions as needed
  function method {:tailrecursion} AddBeaconsToKeySchema(
    config : ValidConfig,
    schema : seq<DDB.KeySchemaElement>,
    attrs : DDB.AttributeDefinitions,
    acc : seq<DDB.KeySchemaElement> := [],
    origSize : nat := |schema|
  )
    : (ret : Result<(DDB.KeySchema, DDB.AttributeDefinitions), string>)
    requires 1 <= origSize <= 2
    requires |schema| + |acc| == origSize
    ensures ret.Success? ==> |ret.value.0| == origSize
  {
    if |schema| == 0 then
      Success((acc, attrs))
    else
      var (newSchema, newAttrs) :- AddBeaconsToKeySchemaElement(config, schema[0], attrs);
      AddBeaconsToKeySchema(config, schema[1..], newAttrs, acc + [newSchema], origSize)
  }

  // transform LSI for searchable encryption, changing AttributeDefinitions as needed
  function method TransformOneLsi(
    config : ValidConfig,
    index : DDB.LocalSecondaryIndex,
    attrs : DDB.AttributeDefinitions
  )
    : Result<(DDB.LocalSecondaryIndex, DDB.AttributeDefinitions), string>
    requires config.beacons.Some?
  {
    var (newSchema, newAttrs) :- AddBeaconsToKeySchema(config, index.KeySchema, attrs);
    var newProjection :- AddBeaconsToProjection(config, index.Projection);
    Success((index.(KeySchema := newSchema, Projection := newProjection), newAttrs))
  }

  // transform GSI for searchable encryption, changing AttributeDefinitions as needed
  function method TransformOneGsi(
    config : ValidConfig,
    index : DDB.GlobalSecondaryIndex,
    attrs : DDB.AttributeDefinitions
  )
    : Result<(DDB.GlobalSecondaryIndex, DDB.AttributeDefinitions), string>
    requires config.beacons.Some?
  {
    var (newSchema, newAttrs) :- AddBeaconsToKeySchema(config, index.KeySchema, attrs);
    var newProjection :- AddBeaconsToProjection(config, index.Projection);
    Success((index.(KeySchema := newSchema, Projection := newProjection), newAttrs))
  }

  // transform LSIs for searchable encryption, changing AttributeDefinitions as needed
  function method LsiWithAttrs(
    config : ValidConfig,
    indexes : DDB.LocalSecondaryIndexList,
    attrs : DDB.AttributeDefinitions,
    acc : DDB.LocalSecondaryIndexList := []
  )
    : Result<(DDB.LocalSecondaryIndexList, DDB.AttributeDefinitions), string>
    requires config.beacons.Some?
  {
    if |indexes| == 0 then
      Success((acc, attrs))
    else
      var (newIndex, newAttrs) :- TransformOneLsi(config, indexes[0], attrs);
      LsiWithAttrs(config, indexes[1..], newAttrs, acc + [newIndex])
  }

  // transform GSIs for searchable encryption, changing AttributeDefinitions as needed
  function method GsiWithAttrs(
    config : ValidConfig,
    indexes : DDB.GlobalSecondaryIndexList,
    attrs : DDB.AttributeDefinitions,
    acc : DDB.GlobalSecondaryIndexList := []
  )
    : Result<(DDB.GlobalSecondaryIndexList, DDB.AttributeDefinitions), string>
    requires config.beacons.Some?
  {
    if |indexes| == 0 then
      Success((acc, attrs))
    else
      var (newIndex, newAttrs) :- TransformOneGsi(config, indexes[0], attrs);
      GsiWithAttrs(config, indexes[1..], newAttrs, acc + [newIndex])
  }

}