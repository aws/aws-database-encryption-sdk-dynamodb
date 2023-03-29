// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

/*
  The entry points of interest are

  // Stringify a TerminalLocation in the context of an AttributeMap
  TermToString(t : TerminalLocation, item : DDB.AttributeMap) : string

  This is generally used this way
  VirtualField f = GetVirtualField(spec);
  fieldValue := f.makeString(t => TermToString(t, item));

  // calculate all virtual field values, in the same way as PutItem et al
  GetVirtualAttributes(fields : seq<VirtualField>, item : DDB.AttributeMap) : DDB.AttributeMap
*/

include "../../Model/AwsCryptographyDynamoDbEncryptionItemEncryptorTypes.dfy"
include "../StructuredEncryption/Virtual.dfy"
include "../DynamoDbEncryption/DynamoToStruct.dfy"

module VirtualDDBFields {
  import opened StandardLibrary
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import Base64
  import opened StandardLibrary.UInt
  import opened StructuredEncryptionUtil
  import opened StructuredEncryptionPaths
  import opened VirtualFields
  import DynamoToStruct

  // return true if item does not have the given terminal
  predicate method LacksAttribute(t : TerminalLocation, item : DDB.AttributeMap)
  {
    t.parts[0].key !in item
  }

  // return true if item has all of the terminals necessary for field
  predicate method ValueHasNeededAttrs(field : VirtualField, item : DDB.AttributeMap)
  {
    !field.examine(t => LacksAttribute(t, item))
  }

  // return the string value for the given terminal in the given item
  function method TermToString(t : TerminalLocation, item : DDB.AttributeMap)
    : Result<string,string>
  {
    if t.parts[0].key !in item then
      Failure("Requested attribute " + t.parts[0].key + " not in item.")
    else
      var part :- GetTerminal(item[t.parts[0].key], t.parts[1..]);
      AttrValueToString(part)
  }

  // return the string value for the given terminal in the given item
  function method TermToBytes(t : TerminalLocation, item : DDB.AttributeMap)
    : Result<Bytes,string>
  {
    if t.parts[0].key !in item then
      Failure("Requested attribute " + t.parts[0].key + " not in item.")
    else
      var part :- GetTerminal(item[t.parts[0].key], t.parts[1..]);
      DynamoToStruct.AttrToBytes(part, true)
  }

  // return the string value for the given terminal in the given value
  function method {:tailrecursion} {:opaque} GetTerminal(v : DDB.AttributeValue, parts : seq<Selector>)
    : Result<DDB.AttributeValue, string>
  {
    if |parts| == 0 then
      Success(v)
    else
      match v {
        case S(s) => Failure("Found string with parts left over.")
        case N(s) => Failure("Found number with parts left over.")
        case B(b) => Failure("Found binary with parts left over.")
        case SS(s) => Failure("Found string set with parts left over.")
        case NS(s) => Failure("Found number set with parts left over.")
        case BS(s) => Failure("Found binary set with parts left over.")
        case BOOL(b) => Failure("Found boolean with parts left over.")
        case NULL(n) => Failure("Found null with parts left over.")
        case L(l) =>
          if !parts[0].List? then
            Failure("Tried to access list with key")
          else if |l| <= parts[0].pos as int then
            Failure("Tried to access beyond the end of the list")
          else
            GetTerminal(l[parts[0].pos], parts[1..])
        case M(m) =>
          if !parts[0].Map? then
            Failure("Tried to access map with index")
          else if parts[0].key !in m then
            Failure("Tried to access " + parts[0].key + " which is not in the map.")
          else
            GetTerminal(m[parts[0].key], parts[1..])
      }
  }

  // return the string value for the given terminal in the given value
  function method {:opaque} AttrValueToString(v : DDB.AttributeValue)
    : Result<string, string>
  {
    match v {
      case S(s) => Success(s)
      case N(s) => Success(s)
      case B(b) => Success(Base64.Encode(b))
      case SS(s) => Failure("Can't convert String Set to string.")
      case NS(s) => Failure("Can't convert Number Set to string.")
      case BS(s) => Failure("Can't convert Binary Set to string.")
      case BOOL(b) => Success(if b then "true" else "false")
      case NULL(n) => Success("null")
      case L(l) => Failure("Can't convert List to string.")
      case M(m) => Failure("Can't convert Map to string.")
    }
  }

  // return true if everything in the AttributeMap is of type string
  predicate AllStrings(item : DDB.AttributeMap) {
    forall x <- item :: item[x].S?
  }

  // convert string to DynamoDB Attribute
  function method DS(s : string)
    : DDB.AttributeValue
  {
    DDB.AttributeValue.S(s)
  }

  // return an AttributeMap containing all of the virtual fields for which we have the appropriate attributes
  function method {:tailrecursion} GetVirtualAttrs (
    fields : seq<VirtualField>,
    item : DDB.AttributeMap,
    acc : DDB.AttributeMap := map[])
    : (ret : Result<DDB.AttributeMap, string>)
    requires AllStrings(acc)
    ensures ret.Success? ==> AllStrings(ret.value)
  {
    if |fields| == 0 then
      Success(acc)
    else
      :- Need(DDB.IsValid_AttributeName(fields[0].name), "Virtual field name '" + fields[0].name + "' is not a valid DynamoDB Attribute Name");
      if ValueHasNeededAttrs(fields[0], item) then
        var value :- fields[0].makeString(t => TermToString(t, item));
        GetVirtualAttrs(fields[1..], item, acc[fields[0].name := DDB.AttributeValue.S(value)])
      else
        GetVirtualAttrs(fields[1..], item, acc)
  }
}
