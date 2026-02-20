// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

/*
  Modified DDB calls share a lot of infrastructure.
  This file captures that commonality, implementing the things in ddb-support.md
*/

include "Util.dfy"
include "UpdateExpr.dfy"
include "FilterExpr.dfy"
include "Virtual.dfy"
include "SearchInfo.dfy"

module DynamoDBSupport {

  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened StandardLibrary.MemoryMath
  import opened DynamoDbEncryptionUtil
  import opened DdbVirtualFields
  import opened SearchableEncryptionInfo
  import StandardLibrary.String
  import UTF8
  import SortedSets
  import Seq
  import Update = DynamoDbUpdateExpr
  import Filter = DynamoDBFilterExpr
  import SET = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import NN = DynamoDbNormalizeNumber

  method GetNumberOfQueries(search : SearchableEncryptionInfo.BeaconVersion, query : DDB.QueryInput)
    returns (output : Result<PartitionCount, Error>)
  {
    var numberOfQueries :- Filter.GetNumQueries(
      search,
      query.KeyConditionExpression,
      query.ExpressionAttributeValues,
      query.ExpressionAttributeNames
    );
    return Success(numberOfQueries);
  }

  // IsWritable examines an AttributeMap and fails if it is unsuitable for writing.
  // At the moment, this means that no attribute names starts with "aws_dbe_",
  // as all other attribute names would need to be configured, and all the
  // other weird constraints were checked at configuration time.
  method IsWriteable(item : DDB.AttributeMap)
    returns (ret : Result<bool, string>)
    //= specification/dynamodb-encryption-client/ddb-support.md#writable
    //= type=implication
    //# Writeable MUST reject any item containing an attribute which begins with `aws_dbe_`.
    ensures ret.Success? ==> forall k <- item :: !(ReservedPrefix <= k)
  {
    var keys := SortedSets.ComputeSetToOrderedSequence2(item.Keys, CharLess);
    SequenceIsSafeBecauseItIsInMemory(keys);
    var rp := ReservedPrefix; // because the constant ReservedPrefix is actual an expensive function call
    for i : uint64 := 0 to |keys| as uint64
      invariant forall j | 0 <= j < i :: !(ReservedPrefix <= keys[j])
    {
      if rp <= keys[i] {
        var result := "Writing reserved attributes not allowed : ";
        for j : uint64 := i to |keys| as uint64 {
          if rp <= keys[i] {
            result := result + keys[i] + "\n";
          }
        }
        return Failure(result);
      }
    }
    return Success(true);
  }

  function method GetEncryptedAttributes(
    actions : AttributeActions,
    expr : Option<string>,
    attrNames : Option<DDB.ExpressionAttributeNameMap> )
    : seq<string>
  {
    if expr.None? then
      []
    else
      var attrs := Filter.ExtractAttributes(expr.value, attrNames);
      Seq.Filter((attr : string) => IsEncrypted(actions, attr), attrs)
  }


  // TestConditionExpression fails if a condition expression is not suitable for the
  // given encryption schema.
  // Generally this means no encrypted attribute is referenced.
  function method TestConditionExpression(
    actions : AttributeActions,
    expr: Option<DDB.ConditionExpression>,
    attrNames: Option<DDB.ExpressionAttributeNameMap>,
    attrValues: Option<DDB.ExpressionAttributeValueMap>
  )
    : (ret : Result<bool, string>)
    //= specification/dynamodb-encryption-client/ddb-support.md#testconditionexpression
    //= type=implication
    //# TestConditionExpression MUST fail if any operand in the condition expression is an encrypted attribute name.
    ensures ret.Success? ==> |GetEncryptedAttributes(actions, expr, attrNames)| == 0
  {
    if expr.Some? then
      var attrs := GetEncryptedAttributes(actions, expr, attrNames);
      SequenceIsSafeBecauseItIsInMemory(attrs);
      if |attrs| as uint64 == 0 then
        Success(true)
      else
        Failure("Condition Expressions forbidden on encrypted attributes : " + Join(attrs, ","))
    else
      Success(true)
  }

  predicate method IsSigned(actions : AttributeActions, attr : string)
  {
    && attr in actions
    && actions[attr] != SET.DO_NOTHING
  }

  predicate method IsEncrypted(actions : AttributeActions, attr : string)
  {
    && attr in actions
    && actions[attr] == SET.ENCRYPT_AND_SIGN
  }

  // TestUpdateExpression fails if an update expression is not suitable for the
  // given encryption schema.
  // Generally this means no signed attribute is referenced.
  function method TestUpdateExpression(
    actions : AttributeActions,
    expr: Option<DDB.UpdateExpression>,
    attrNames: Option<DDB.ExpressionAttributeNameMap>,
    attrValues: Option<DDB.ExpressionAttributeValueMap>
  )
    : (ret : Result<bool, string>)
    //= specification/dynamodb-encryption-client/ddb-support.md#testupdateexpression
    //= type=implication
    //# TestUpdateExpression MUST fail if any operand in the update expression is a signed attribute name.
    ensures ret.Success? ==> expr.None? || |Seq.Filter(s => IsSigned(actions, s), Update.ExtractAttributes(expr.value, attrNames))| == 0
  {
    if expr.Some? then
      var attrs := Update.ExtractAttributes(expr.value, attrNames);
      var encryptedAttrs := Seq.Filter(s => IsSigned(actions, s), attrs);
      SequenceIsSafeBecauseItIsInMemory(encryptedAttrs);
      if |encryptedAttrs| as uint64 == 0 then
        Success(true)
      else
        Failure("Update Expressions forbidden on signed attributes : " + Join(encryptedAttrs, ","))
    else
      Success(true)
  }

  // AddBeacons examines an AttributeMap and modifies it to be appropriate for Searchable Encryption,
  // returning a replacement AttributeMap.
  method GetEncryptedBeacons(search : Option<ValidSearchInfo>, item : DDB.AttributeMap, keyId : MaybeKeyId, partition : PartitionNumber)
    returns (output : Result<DDB.AttributeMap, Error>)
    modifies if search.Some? then search.value.Modifies() else {}
  {
    if search.None? {
      return Success(map[]);
    } else {
      output := search.value.GenerateEncryptedBeacons(item, keyId, partition);
    }
  }

  const VersionTag : DDB.AttributeName := VersionPrefix + "1"

  // AddBeacons examines an AttributeMap and modifies it to be appropriate for Searchable Encryption,
  // returning a replacement AttributeMap.
  method AddSignedBeacons(search : Option<ValidSearchInfo>, item : DDB.AttributeMap, partition : PartitionNumber)
    returns (output : Result<DDB.AttributeMap, Error>)
    modifies if search.Some? then search.value.Modifies() else {}

    //= specification/searchable-encryption/search-config.md#versioning
    //= type=implication
    //# In addition to the configured beacons, a [version tag](#version-tag) MUST also be written.

    //= specification/dynamodb-encryption-client/ddb-support.md#addsignedbeacons
    //= type=implication
    //# AddSignedBeacons MUST also add an attribute with name `aws_dbe_v_1` and whose value is a string containing a single space.
    ensures output.Success? && search.Some? ==> VersionTag in output.value
  {
    if search.None? {
      return Success(item);
    } else {
      var newAttrs :- search.value.GenerateSignedBeacons(item, partition);

      //= specification/dynamodb-encryption-client/ddb-support.md#addsignedbeacons
      //# If the attribute NAME already exists,
      //# if the constructed compound beacon does not match
      //# the existing attribute value AddSignedBeacons MUST fail.
      var badAttrs := set k <- newAttrs | k in item && item[k] != newAttrs[k] :: k;
      SetIsSafeBecauseItIsInMemory(badAttrs);
      :- Need(|badAttrs| as uint64 == 0, E("Signed beacons have generated values different from supplied values."));
      var version : DDB.AttributeMap := map[VersionTag := DS(" ")];
      var both := newAttrs.Keys * item.Keys;
      var bad := set k <- both | newAttrs[k] != item[k];
      SetIsSafeBecauseItIsInMemory(bad);
      if 0 < |bad| as uint64 {
        // We happen to order these values, but this ordering MUST NOT be relied upon.
        var badSeq := SortedSets.ComputeSetToOrderedSequence2(bad, CharLess);
        return Failure(E("Supplied Beacons do not match calculated beacons : " + Join(badSeq, ", ")));
      }
      //= specification/dynamodb-encryption-client/ddb-support.md#addsignedbeacons
      //# The result of AddSignedBeacons MUST be a super set of everything in the input AttributeMap.
      if search.value.curr().keySource.keyLoc.MultiLoc? && search.value.curr().keySource.keyLoc.deleteKey {
        var newItem := map k <- item | k != search.value.curr().keySource.keyLoc.keyName :: k := item[k];
        return Success(newItem + newAttrs + version);
      } else {
        return Success(item + newAttrs + version);
      }
    }
  }

  function method DoRemoveBeacons(item : DDB.AttributeMap) : DDB.AttributeMap
  {
    map k <- item | (!(ReservedPrefix <= k)) :: k := item[k]
  }

  // RemoveBeacons examines an AttributeMap and modifies it to be appropriate for customer use,
  // returning a replacement AttributeMap.
  function method RemoveBeacons(search : Option<ValidSearchInfo>, item : DDB.AttributeMap)
    : (ret : Result<DDB.AttributeMap, string>)

    //= specification/dynamodb-encryption-client/ddb-support.md#removebeacons
    //= type=implication
    //# RemoveBeacons MUST remove any attributes whose name begins with `aws_dbe_`,
    //# and leave all other attributes unchanged.
    ensures ret.Success? && search.Some? ==>
              && (forall k <- ret.value :: !(ReservedPrefix <= k))
              && (forall k <- item :: (ReservedPrefix <= k) || (k in ret.value && ret.value[k] == item[k]))
  {
    Success(DoRemoveBeacons(item))
  }
  const PartitionName : string := ":aws_dbe_partition"

  function method GetNumber(val : DDB.AttributeValue, name : string) : Result<uint32, Error>
  {
    if val.N? then
      var val :- NN.StrToInt(val.N).MapFailure(e => E(e));
      :- Need(0 <= val < INT32_MAX_LIMIT, E("Value of " + name + " out of range."));
      Success(val as uint32)
    else
      Failure(E("Value of " + name + " is not numeric (i.e. 'N')"))
  }

  // Unlike Query, Scan must not specify PartitionName
  function method TestPartitionForScan(names : Option<DDB.ExpressionAttributeValueMap>)
    : Result<bool, Error>
  {
    if names.None? then
      Success(true)
    else if PartitionName in names.value then
      Failure(E("A value for " + PartitionName + " must not be specified for Scan operations."))
    else
      Success(true)
  }

  // If names[":aws_dbe_partition"] holds S(N)' return (Some(names - {":aws_dbe_partition"}), Some(N))
  // else return (None, None)
  function method ExtractPartitionNumber(names : Option<DDB.ExpressionAttributeValueMap>)
    : Result<(Option<DDB.ExpressionAttributeValueMap>, Option<uint32>), Error>
  {
    if names.None? then
      Success((None, None))
    else if PartitionName in names.value then
      var val :- GetNumber(names.value[PartitionName], PartitionName);
      if |names.value| == 1 then
        Success((None, Some(val)))
      else
        Success((Some(names.value - {PartitionName}), Some(val)))
    else
      Success((None, None))
  }

  // Extract aws_dbe_partition = NN from filterExpr and return partition
  method ExtractPartition(search : SearchableEncryptionInfo.BeaconVersion, keyExpr : Option<string>, filterExpr : Option<string>, names : Option<DDB.ExpressionAttributeNameMap>, values : Option<DDB.ExpressionAttributeValueMap>, actions : AttributeActions)
    returns (output : Result<(Option<DDB.ExpressionAttributeValueMap>, PartitionNumber), Error>)
    ensures output.Success? ==> output.value.1 < search.numPartitions
  {
    if search.numPartitions <= 1 {
      :- Need(values.None? || PartitionName !in values.value, E("If no partitions are configured, do not specify " + PartitionName));
      return Success((values, 0));
    }

    var foo :- ExtractPartitionNumber(values);
    var (values2, partition) := foo;
    if partition.Some? {
      :- Need(partition.value < search.numPartitions as uint32, E(PartitionName + " specified in FilterExpression was " + String.Base10Int2String(partition.value as int) + " must be less than the number of partitions: " + String.Base10Int2String(search.numPartitions as int)));
      var nPartition := (partition.value as nat) as PartitionNumber;
      return Success((values2, nPartition));
    }

    // No partition specified is OK if no encrypted fields are searched
    var filterHasEncField := Filter.UsesEncryptedField(Filter.ParseExprOpt(filterExpr), actions, names);
    var keyHasEncField := Filter.UsesEncryptedField(Filter.ParseExprOpt(keyExpr), actions, names);
    if keyHasEncField.Some? || filterHasEncField.Some? {
      return Failure(E("When numberOfPartitions is greater than one, XXXValues must contain " + PartitionName));
    } else {
      return Success((values, 0));
    }
  }

  // Transform a QueryInput object for searchable encryption.
  method QueryInputForBeacons(search : Option<ValidSearchInfo>, actions : AttributeActions, req : DDB.QueryInput)
    returns (output : Result<DDB.QueryInput, Error>)
    modifies if search.Some? then search.value.Modifies() else {}
  {
    if search.None? {
      var _ :- Filter.TestBeaconize(
        actions,
        req.KeyConditionExpression,
        req.FilterExpression,
        req.ExpressionAttributeNames
      );
      return Success(req);
    } else {
      var keyId :- Filter.GetBeaconKeyId(search.value.curr(), req.KeyConditionExpression, req.FilterExpression, req.ExpressionAttributeValues, req.ExpressionAttributeNames);
      var foo :- ExtractPartition(search.value.curr(), req.FilterExpression, req.KeyConditionExpression, req.ExpressionAttributeNames, req.ExpressionAttributeValues, actions);
      var (newValues, partition) := foo;
      var numQueries :- Filter.GetNumQueries(search.value.curr(), req.KeyConditionExpression, req.ExpressionAttributeValues, req.ExpressionAttributeNames);
      if numQueries <= partition {
        return Failure(E("Partition number was " + String.Base10Int2String(partition as int) + " but should have been less than number of queries : " + String.Base10Int2String(numQueries as int)));
      }
      var oldContext := Filter.ExprContext(req.KeyConditionExpression, req.FilterExpression, newValues, req.ExpressionAttributeNames);
      var newContext :- Filter.DoBeaconize(search.value.curr(), oldContext, keyId, partition, numQueries);
      return Success(req.(
                     KeyConditionExpression := newContext.keyExpr,
                     FilterExpression := newContext.filterExpr,
                     ExpressionAttributeNames := newContext.names,
                     ExpressionAttributeValues := newContext.values
                     ));
    }
  }

  // Transform a QueryOutput object for searchable encryption.
  method QueryOutputForBeacons(search : Option<ValidSearchInfo>, req : DDB.QueryInput, resp : DDB.QueryOutput)
    returns (output : Result<DDB.QueryOutput, Error>)
    requires resp.Items.Some?
    ensures output.Success? ==> output.value.Items.Some?
    modifies if search.Some? then search.value.Modifies() else {}
  {
    if search.None? {
      var trimmedItems := Seq.Map(i => DoRemoveBeacons(i), resp.Items.value);
      return Success(resp.(Items := Some(trimmedItems)));
    } else {
      var newItems :- Filter.FilterResults(
        search.value.curr(),
        resp.Items.value,
        req.KeyConditionExpression,
        req.FilterExpression,
        req.ExpressionAttributeNames,
        req.ExpressionAttributeValues);
      SequenceIsSafeBecauseItIsInMemory(newItems);
      :- Need(|newItems| as uint64 < INT32_MAX_LIMIT as uint64, DynamoDbEncryptionUtil.E("This is impossible."));
      var trimmedItems := Seq.Map(i => DoRemoveBeacons(i), newItems);
      var count :=
        if resp.Count.Some? then
          Some(|trimmedItems| as DDB.Integer)
        else
          None;
      return Success(resp.(Items := Some(trimmedItems), Count := count));
    }
  }

  function method GetBeaconKeyId(
    search : Option<ValidSearchInfo>,
    keyExpr : Option<DDB.ConditionExpression>,
    filterExpr : Option<DDB.ConditionExpression>,
    values: Option<DDB.ExpressionAttributeValueMap>,
    names : Option<DDB.ExpressionAttributeNameMap>
  )
    : Result<MaybeKeyId, Error>
  {
    if search.None? then
      Success(DontUseKeyId)
    else
      Filter.GetBeaconKeyId(search.value.curr(), keyExpr, filterExpr, values, names)
  }

  // Transform a ScanInput object for searchable encryption.
  method ScanInputForBeacons(search : Option<ValidSearchInfo>, actions : AttributeActions, req : DDB.ScanInput)
    returns (output : Result<DDB.ScanInput, Error>)
    modifies if search.Some? then search.value.Modifies() else {}
  {
    if search.None? {
      var _ :- Filter.TestBeaconize(
        actions,
        None,
        req.FilterExpression,
        req.ExpressionAttributeNames
      );
      return Success(req);
    } else {
      var keyId :- Filter.GetBeaconKeyId(search.value.curr(), None, req.FilterExpression, req.ExpressionAttributeValues, req.ExpressionAttributeNames);
      var _ :- TestPartitionForScan(req.ExpressionAttributeValues);
      var context := Filter.ExprContext(None, req.FilterExpression, req.ExpressionAttributeValues, req.ExpressionAttributeNames);
      var newContext :- Filter.DoBeaconize(search.value.curr(), context, keyId, 0, 1);
      return Success(req.(
                     FilterExpression := newContext.filterExpr,
                     ExpressionAttributeNames := newContext.names,
                     ExpressionAttributeValues := newContext.values
                     ));
    }
  }

  // Transform a ScanOutput object for searchable encryption.
  method ScanOutputForBeacons(search : Option<ValidSearchInfo>, req : DDB.ScanInput, resp : DDB.ScanOutput)
    returns (ret : Result<DDB.ScanOutput, Error>)
    requires resp.Items.Some?
    ensures ret.Success? ==> ret.value.Items.Some?
    modifies if search.Some? then search.value.Modifies() else {}
  {
    if search.None? {
      var trimmedItems := Seq.Map(i => DoRemoveBeacons(i), resp.Items.value);
      return Success(resp.(Items := Some(trimmedItems)));
    } else {
      var newItems :- Filter.FilterResults(
        search.value.curr(),
        resp.Items.value,
        None,
        req.FilterExpression,
        req.ExpressionAttributeNames,
        req.ExpressionAttributeValues);
      SequenceIsSafeBecauseItIsInMemory(newItems);
      :- Need(|newItems| as uint64 < INT32_MAX_LIMIT as uint64, DynamoDbEncryptionUtil.E("This is impossible."));
      var trimmedItems := Seq.Map(i => DoRemoveBeacons(i), newItems);
      var count :=
        if resp.Count.Some? then
          Some(|trimmedItems| as DDB.Integer)
        else
          None;
      return Success(resp.(Items := Some(trimmedItems), Count := count));
    }
  }

  function method {:tailrecursion} GetVirtualFieldsLoop(
    fields : seq<string>,
    bv : SearchableEncryptionInfo.BeaconVersion,
    item : DDB.AttributeMap,
    results : map<string, string> := map[])
    : (output : Result<map<string, string>, Error>)
    requires forall x <- fields :: x in bv.virtualFields
    requires forall x <- results :: x in bv.virtualFields
    ensures output.Success? ==> forall x <- output.value :: x in bv.virtualFields
  {
    SequenceIsSafeBecauseItIsInMemory(fields);
    if |fields| as uint64 == 0 then
      Success(results)
    else
      var optValue :- GetVirtField(bv.virtualFields[fields[0 as uint32]], item);
      if optValue.Some? then
        GetVirtualFieldsLoop(fields[1 as uint32..], bv, item, results[fields[0 as uint32] := optValue.value])
      else
        GetVirtualFieldsLoop(fields[1 as uint32..], bv, item, results)
  }

  method GetVirtualFields(beaconVersion : SearchableEncryptionInfo.BeaconVersion, item : DDB.AttributeMap)
    returns (output : Result<map<string, string>, Error>)
  {
    var fieldNames := SortedSets.ComputeSetToOrderedSequence2(beaconVersion.virtualFields.Keys, CharLess);
    output := GetVirtualFieldsLoop(fieldNames, beaconVersion, item);
  }

  function method {:tailrecursion} GetCompoundBeaconsLoop(
    fields : seq<string>,
    bv : SearchableEncryptionInfo.BeaconVersion,
    item : DDB.AttributeMap,
    partition : PartitionNumber,
    results : map<string, string> := map[])
    : (output : Result<map<string, string>, Error>)
    requires forall x <- fields :: x in bv.beacons
    requires forall x <- results :: x in bv.beacons
    ensures output.Success? ==> forall x <- output.value :: x in bv.beacons
  {
    SequenceIsSafeBecauseItIsInMemory(fields);
    if |fields| as uint64  == 0 then
      Success(results)
    else
      var beacon := bv.beacons[fields[0 as uint32]];
      if beacon.Compound? then
        var optValue :- beacon.cmp.getNaked(item, bv.virtualFields, partition);
        if optValue.Some? then
          GetCompoundBeaconsLoop(fields[1 as uint32..], bv, item, partition, results[fields[0] := optValue.value])
        else
          GetCompoundBeaconsLoop(fields[1 as uint32..], bv, item, partition, results)
      else
        GetCompoundBeaconsLoop(fields[1 as uint32..], bv, item, partition, results)
  }

  method GetCompoundBeacons(beaconVersion : SearchableEncryptionInfo.BeaconVersion, item : DDB.AttributeMap, partition : PartitionNumber)
    returns (output : Result<map<string, string>, Error>)
  {
    var beaconNames := SortedSets.ComputeSetToOrderedSequence2(beaconVersion.beacons.Keys, CharLess);
    output := GetCompoundBeaconsLoop(beaconNames, beaconVersion, item, partition);
  }

}
