// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

/*
  Support routines for Local and Global Index structures
*/

include "Util.dfy"
include "UpdateExpr.dfy"
include "FilterExpr.dfy"

module DynamoDBIndexSupport {

  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened DynamoDbEncryptionUtil
  import opened DdbVirtualFields
  import opened SearchableEncryptionInfo
  import UTF8
  import SortedSets
  import Seq
  import Update = DynamoDbUpdateExpr
  import SET = AwsCryptographyStructuredEncryptionTypes
  import Filter = DynamoDBFilterExpr

  // transform beacon name to plain names
  function method UnbeaconString(s : string) : string
  {
    if ReservedPrefix <= s then
      s[|ReservedPrefix|..]
    else
      s
  }

  // transform beacon names to plain names in KeySchemaAttributeName
  function method UnbeaconKeySchemaAttributeName(s : DDB.KeySchemaAttributeName)
    : Result<DDB.KeySchemaAttributeName, AwsCryptographyDynamoDbEncryptionTypes.Error>
  {
    if ReservedPrefix <= s then
      var ret := s[|ReservedPrefix|..];
      if DDB.IsValid_KeySchemaAttributeName(ret) then
        Success(ret)
      else
        Failure(E("KeySchemaAttributeName " + s + " is invalid after removing prefix"))
    else
      Success(s)
  }

  // transform beacon names to plain names in KeySchemaElement
  function method UnbeaconKeySchemaElement(s : DDB.KeySchemaElement)
    : Result<DDB.KeySchemaElement, Error>
  {
    var name :- UnbeaconKeySchemaAttributeName(s.AttributeName);
    Success(s.(AttributeName := name))
  }

  // transform beacon names to plain names in KeySchema
  function method UnbeaconKeySchema(schema : DDB.KeySchema)
    : Result<DDB.KeySchema, Error>
  {
    Seq.MapWithResult((k : DDB.KeySchemaElement) => UnbeaconKeySchemaElement(k), schema)
  }

  // transform beacon names to plain names in Projection
  function method UnbeaconProjection(projection : DDB.Projection)
    : Result<DDB.Projection, Error>
  {
    if projection.NonKeyAttributes.None? then
      Success(projection)
    else
      var newAttributes := Seq.Filter((k : DDB.NonKeyAttributeName) => !(ReservedPrefix <= k), projection.NonKeyAttributes.value);
      if DDB.IsValid_NonKeyAttributeNameList(newAttributes) then
        Success(projection.(NonKeyAttributes := Some(newAttributes)))
      else
        Failure(E("Project had invalid attribute name list"))
  }

  // transform beacon names to plain names in Global Index Description
  function method TransformOneLocalIndexDescription(index : DDB.LocalSecondaryIndexDescription)
    : Result<DDB.LocalSecondaryIndexDescription, Error>
  {
    var newKeySchema :-
    if index.KeySchema.None? then
      Success(None)
    else
      var schema :- UnbeaconKeySchema(index.KeySchema.value);
      Success(Some(schema));

    var newProjection :-
    if index.Projection.None? then
      Success(None)
    else
      var projection :- UnbeaconProjection(index.Projection.value);
      Success(Some(projection));

    Success(index.(KeySchema := newKeySchema, Projection := newProjection))
  }

  // transform beacon names to plain names in Global Index Description
  function method TransformOneGlobalIndexDescription(index : DDB.GlobalSecondaryIndexDescription)
    : Result<DDB.GlobalSecondaryIndexDescription, Error>
  {
    var newKeySchema :-
    if index.KeySchema.None? then
      Success(None)
    else
      var schema :- UnbeaconKeySchema(index.KeySchema.value);
      Success(Some(schema));

    var newProjection :-
    if index.Projection.None? then
      Success(None)
    else
      var projection :- UnbeaconProjection(index.Projection.value);
      Success(Some(projection));

    Success(index.(KeySchema := newKeySchema, Projection := newProjection))
  }

  // transform beacon names to plain names in Local Index Descriptions
  function method TransformLocalIndexDescription(req : Option<DDB.LocalSecondaryIndexDescriptionList>)
    : Result<Option<DDB.LocalSecondaryIndexDescriptionList>, Error>
  {
    if req.None? then
      Success(req)
    else
      var nList :- Seq.MapWithResult((d :DDB.LocalSecondaryIndexDescription) => TransformOneLocalIndexDescription(d), req.value);
      Success(Some(nList))
  }

  // transform beacon names to plain names in Global Index Descriptions
  function method TransformGlobalIndexDescription(req : Option<DDB.GlobalSecondaryIndexDescriptionList>)
    : Result<Option<DDB.GlobalSecondaryIndexDescriptionList>, Error>
  {
    if req.None? then
      Success(req)
    else
      var nList :- Seq.MapWithResult((d :DDB.GlobalSecondaryIndexDescription) => TransformOneGlobalIndexDescription(d), req.value);
      Success(Some(nList))
  }

  // make beacon name from attribute name
  function method MakeBeaconName(name : string) : string
  {
    BeaconPrefix + name
  }

  // make beacon name from attribute name, fail if it's not a valid Key Schema Attribute Name
  function method MakeKeySchemaBeaconName(name : string)
    : Result<DDB.KeySchemaAttributeName, Error>
  {
    var newName := MakeBeaconName(name);
    if DDB.IsValid_KeySchemaAttributeName(newName) then
      Success(newName)
    else
      Failure(E("Can't make valid KeySchemaAttributeName from beacon for " + name))
  }

  // make beacon name from attribute name, fail if it's not a valid Non Key Attribute Name
  function method MakeNonKeyBeaconName(name : string)
    : Result<DDB.NonKeyAttributeName, Error>
  {
    var newName := MakeBeaconName(name);
    if DDB.IsValid_NonKeyAttributeName(newName) then
      Success(newName)
    else
      Failure(E("Can't make valid NonKeySchemaAttributeName from beacon for " + name))
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

  predicate method IsEncrypted(actions : AttributeActions, attr : string)
  {
    && attr in actions
    && actions[attr] == SET.ENCRYPT_AND_SIGN
  }

  // transform KeySchemaElement for searchable encryption, changing AttributeDefinitions as needed
  function method AddBeaconsToKeySchemaElement(
    search : ValidSearchInfo,
    actions : AttributeActions,
    element : DDB.KeySchemaElement,
    attrs : DDB.AttributeDefinitions
  )
    : Result<(DDB.KeySchemaElement, DDB.AttributeDefinitions), Error>
  {
    if search.IsBeacon(element.AttributeName) then
      var newName :- MakeKeySchemaBeaconName(element.AttributeName);
      var newAttrs := ReplaceAttrDef(attrs, element.AttributeName, newName);
      Success((element.(AttributeName := newName), newAttrs))
    else if IsEncrypted(actions, element.AttributeName) then
      Failure(E("You can't make an index on an encrypted attribute, unless you've configured a beacon for that attribute."))
    else
      Success((element, attrs))
  }

  // transform Projection for searchable encryption
  // for any beacon in the Projection, add the beacon name plus any attributes used to construct the beacon
  function method AddBeaconsToProjection(search : ValidSearchInfo, proj : DDB.Projection)
    : Result<DDB.Projection, Error>
  {
    if proj.NonKeyAttributes.None? then
      Success(proj)
    else
      var newAttributes := search.GenerateClosure(proj.NonKeyAttributes.value);
      if (forall a <- newAttributes :: DDB.IsValid_NonKeyAttributeName(a)) && DDB.IsValid_NonKeyAttributeNameList(newAttributes) then
       Success(proj.(NonKeyAttributes := Some(newAttributes)))
      else
        Failure(E("Adding beacons to NonKeyAttributes of Projection in CreateGlobalSecondaryIndexAction exceeded the allowed number of projected attributes."))
  }

  // transform CreateGlobalSecondaryIndexAction for searchable encryption, changing AttributeDefinitions as needed
  function method TransformCreateGSIAction(
    search : ValidSearchInfo,
    actions : AttributeActions,
    index : DDB.CreateGlobalSecondaryIndexAction,
    attrs : DDB.AttributeDefinitions
  )
    : Result<(DDB.CreateGlobalSecondaryIndexAction, DDB.AttributeDefinitions), Error>
  {
    var (newKeySchema, attrs) :- AddBeaconsToKeySchema(search, actions, index.KeySchema, attrs);
    var newProjection :- AddBeaconsToProjection(search, index.Projection);
    Success((index.(KeySchema := newKeySchema, Projection := newProjection), attrs))
  }

  // transform GSI Updates for searchable encryption, changing AttributeDefinitions as needed
  function method TransformGlobalSecondaryIndexUpdate(
    search : ValidSearchInfo,
    actions : AttributeActions,
    index : DDB.GlobalSecondaryIndexUpdate,
    attrs : DDB.AttributeDefinitions
  )
    : Result<(DDB.GlobalSecondaryIndexUpdate, DDB.AttributeDefinitions), Error>
  {
    if index.Create.None? then
      Success((index, attrs))
    else
      var (create, attrs) :- TransformCreateGSIAction(search, actions, index.Create.value, attrs);
      Success((index.(Create := Some(create)), attrs))
  }

  // transform IndexUpdates for searchable encryption, changing AttributeDefinitions as needed
  function method {:tailrecursion} TransformIndexUpdates(
    search : ValidSearchInfo,
    actions : AttributeActions,
    indexes : DDB.GlobalSecondaryIndexUpdateList,
    attrs : DDB.AttributeDefinitions,
    acc : DDB.GlobalSecondaryIndexUpdateList := []
  )
    : Result<(DDB.GlobalSecondaryIndexUpdateList, DDB.AttributeDefinitions), Error>
  {
    if |indexes| == 0 then
      Success((acc, attrs))
    else
      var (newIndex, newAttrs) :- TransformGlobalSecondaryIndexUpdate(search, actions, indexes[0], attrs);
    TransformIndexUpdates(search, actions, indexes[1..], newAttrs, acc + [newIndex])
  }

  // transform KeySchema for searchable encryption, changing AttributeDefinitions as needed
  function method {:tailrecursion} AddBeaconsToKeySchema(
    search : ValidSearchInfo,
    actions : AttributeActions,
    schema : seq<DDB.KeySchemaElement>,
    attrs : DDB.AttributeDefinitions,
    acc : seq<DDB.KeySchemaElement> := [],
    origSize : nat := |schema|
  )
    : (ret : Result<(DDB.KeySchema, DDB.AttributeDefinitions), Error>)
    requires 1 <= origSize <= 2
    requires |schema| + |acc| == origSize
    ensures ret.Success? ==> |ret.value.0| == origSize
  {
    if |schema| == 0 then
      Success((acc, attrs))
    else
      var (newSchema, newAttrs) :- AddBeaconsToKeySchemaElement(search, actions, schema[0], attrs);
      AddBeaconsToKeySchema(search, actions, schema[1..], newAttrs, acc + [newSchema], origSize)
  }

  // transform LSI for searchable encryption, changing AttributeDefinitions as needed
  function method TransformOneLsi(
    search : ValidSearchInfo,
    actions : AttributeActions,
    index : DDB.LocalSecondaryIndex,
    attrs : DDB.AttributeDefinitions
  )
    : Result<(DDB.LocalSecondaryIndex, DDB.AttributeDefinitions), Error>
  {
    var (newSchema, newAttrs) :- AddBeaconsToKeySchema(search, actions, index.KeySchema, attrs);
    var newProjection :- AddBeaconsToProjection(search, index.Projection);
    Success((index.(KeySchema := newSchema, Projection := newProjection), newAttrs))
  }

  // transform GSI for searchable encryption, changing AttributeDefinitions as needed
  function method TransformOneGsi(
    search : ValidSearchInfo,
    actions : AttributeActions,
    index : DDB.GlobalSecondaryIndex,
    attrs : DDB.AttributeDefinitions
  )
    : Result<(DDB.GlobalSecondaryIndex, DDB.AttributeDefinitions), Error>
  {
    var (newSchema, newAttrs) :- AddBeaconsToKeySchema(search, actions, index.KeySchema, attrs);
    var newProjection :- AddBeaconsToProjection(search, index.Projection);
    Success((index.(KeySchema := newSchema, Projection := newProjection), newAttrs))
  }

  // transform LSIs for searchable encryption, changing AttributeDefinitions as needed
  function method LsiWithAttrs(
    search : ValidSearchInfo,
    actions : AttributeActions,
    indexes : DDB.LocalSecondaryIndexList,
    attrs : DDB.AttributeDefinitions,
    acc : DDB.LocalSecondaryIndexList := []
  )
    : Result<(DDB.LocalSecondaryIndexList, DDB.AttributeDefinitions), Error>
  {
    if |indexes| == 0 then
      Success((acc, attrs))
    else
      var (newIndex, newAttrs) :- TransformOneLsi(search, actions, indexes[0], attrs);
      LsiWithAttrs(search, actions, indexes[1..], newAttrs, acc + [newIndex])
  }

  // transform GSIs for searchable encryption, changing AttributeDefinitions as needed
  function method GsiWithAttrs(
    search : ValidSearchInfo,
    actions : AttributeActions,
    indexes : DDB.GlobalSecondaryIndexList,
    attrs : DDB.AttributeDefinitions,
    acc : DDB.GlobalSecondaryIndexList := []
  )
    : Result<(DDB.GlobalSecondaryIndexList, DDB.AttributeDefinitions), Error>
  {
    if |indexes| == 0 then
      Success((acc, attrs))
    else
      var (newIndex, newAttrs) :- TransformOneGsi(search, actions, indexes[0], attrs);
      GsiWithAttrs(search, actions, indexes[1..], newAttrs, acc + [newIndex])
  }
}
