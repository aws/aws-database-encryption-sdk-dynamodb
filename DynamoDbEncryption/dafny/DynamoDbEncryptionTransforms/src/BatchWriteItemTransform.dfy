// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DynamoDbMiddlewareSupport.dfy"

module BatchWriteItemTransform {
  import opened DdbMiddlewareConfig
  import opened DynamoDbMiddlewareSupport
  import opened Wrappers
  import opened StandardLibrary.UInt
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
  import EncTypes = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import Seq
  import SortedSets
  import Util = DynamoDbEncryptionUtil
  import Types = AwsCryptographyDbEncryptionSdkDynamoDbTypes

  method {:vcs_split_on_every_assert} Input(config: Config, input: BatchWriteItemInputTransformInput)
    returns (output: Result<BatchWriteItemInputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)
  {
    var tableNames := input.sdkInput.RequestItems.Keys;
    var result : map<DDB.TableArn, DDB.WriteRequests> := map[];
    var tableNamesSeq := SortedSets.ComputeSetToSequence(tableNames);
    ghost var tableNamesSet' := tableNames;
    var i := 0;
    while i < |tableNamesSeq|
      invariant Seq.HasNoDuplicates(tableNamesSeq)
      invariant forall j | i <= j < |tableNamesSeq| :: tableNamesSeq[j] in tableNamesSet'
      invariant |tableNamesSet'| == |tableNamesSeq| - i
      invariant tableNamesSet' <= input.sdkInput.RequestItems.Keys
    {
      var tableName := tableNamesSeq[i];

      var writeRequests : DDB.WriteRequests := input.sdkInput.RequestItems[tableName];
      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-batchwriteitem
      //# If the table name does not refer to an [encrypted-table](#encrypted-table),
      //# the list of operations MUST be unchanged.
      if !IsPlainWrite(config, tableName) {
        var tableConfig := config.tableEncryptionConfigs[tableName];
        var encryptedItems : seq<DDB.WriteRequest> := [];
        for x := 0 to |writeRequests|
          invariant |encryptedItems| == x
        {
          var req : DDB.WriteRequest := writeRequests[x];
          if req.PutRequest.None? {
            // We only transform PutRequests, so no PutRequest ==> no change
            encryptedItems := encryptedItems + [req];
          } else {
            //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-batchwriteitem
            //# The Item MUST be [writable](ddb-support.md#writable).
            var _ :- IsWriteable(tableConfig, req.PutRequest.value.Item);

            var bucket :- GetRandomBucket(tableConfig);
            var item :- AddSignedBeacons(tableConfig, req.PutRequest.value.Item, bucket);

            var encryptRes := tableConfig.itemEncryptor.EncryptItem(EncTypes.EncryptItemInput(plaintextItem:=item));
            var encrypted :- MapError(encryptRes);
            var keyId :- GetKeyIdFromHeader(tableConfig, encrypted);
            var beaconAttrs :- GetEncryptedBeacons(tableConfig, req.PutRequest.value.Item, Util.MaybeFromOptionKeyId(keyId), bucket);

            //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-batchwriteitem
            //# The PutRequest request's `Item` field MUST be replaced
            //# with a value that is equivalent to
            //# the result [Encrypted DynamoDB Item](./encrypt-item.md#encrypted-dynamodb-item)
            //# calculated above.
            encryptedItems := encryptedItems + [req.(PutRequest := Some(DDB.PutRequest(Item := encrypted.encryptedItem + beaconAttrs)))];
          }
        }
        writeRequests := encryptedItems;
      }
      tableNamesSet' := tableNamesSet' - {tableName};
      i := i + 1;
      assert forall j | i <= j < |tableNamesSeq| :: tableNamesSeq[j] in tableNamesSet' by {
        reveal Seq.HasNoDuplicates();
      }
      result := result[tableName := writeRequests];
    }
    :- Need(|result| ==  |input.sdkInput.RequestItems|, E("Internal Error")); // Dafny gets too confused
    return Success(BatchWriteItemInputTransformOutput(transformedInput := input.sdkInput.(RequestItems := result)));
  }

  // Given the encrypted item, find the original plaintext item, based on the never encrypted PK and SK.
  // We don't have to worry about duplicates, because DynamoDB will report an error if there are duplicates
  method GetOrigItem(
    tableConfig : ValidTableConfig,
    srcRequests : DDB.WriteRequests,
    itemReq : DDB.WriteRequest
  ) returns (ret : Result<DDB.WriteRequest, Error>)
    requires itemReq.PutRequest.Some?
    ensures ret.Success? ==> ret.value.PutRequest.Some?
  {
    var partKey := tableConfig.partitionKeyName;
    var sortKey := tableConfig.sortKeyName;
    var item := itemReq.PutRequest.value.Item;
    :- Need(partKey in item, E("Required partition key not in unprocessed item"));
    :- Need(sortKey.None? || sortKey.value in item, E("Required sort key not in unprocessed item"));
    for i := 0 to |srcRequests| {
      if srcRequests[i].PutRequest.Some? {
        var req := srcRequests[i].PutRequest.value.Item;
        if partKey in req  && req[partKey] == item[partKey] {
          if sortKey.None? || (sortKey.value in req  && req[sortKey.value] == item[sortKey.value]) {
            return Success(srcRequests[i]);
          }
        }
      }
    }
    return Failure(E("Item in UnprocessedItems not found in original request."));
  }

  method Output(config: Config, input: BatchWriteItemOutputTransformInput)
    returns (output: Result<BatchWriteItemOutputTransformOutput, Error>)

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-batchwriteitem
    //= type=implication
    //# If there are no UnprocessedItems, then the BatchWriteItemOutput MUST be returned unchanged.
    ensures input.sdkOutput.UnprocessedItems.None? ==>
              && output.Success?
              && output.value.transformedOutput == input.sdkOutput
  {
    if input.sdkOutput.UnprocessedItems.None? {
      return Success(BatchWriteItemOutputTransformOutput(transformedOutput := input.sdkOutput));
    }

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-batchwriteitem
    //# Each item in UnprocessedItems MUST be replaced by its original plaintext value.
    var srcItems := input.originalInput.RequestItems;
    var unprocessed := input.sdkOutput.UnprocessedItems.value;
    var tableNames := unprocessed.Keys;
    var result : map<DDB.TableArn, DDB.WriteRequests> := map[];
    var tableNamesSeq := SortedSets.ComputeSetToSequence(tableNames);
    ghost var tableNamesSet' := tableNames;
    var i := 0;
    while i < |tableNamesSeq|
      invariant Seq.HasNoDuplicates(tableNamesSeq)
      invariant forall j | i <= j < |tableNamesSeq| :: tableNamesSeq[j] in tableNamesSet'
      invariant |tableNamesSet'| == |tableNamesSeq| - i
      invariant tableNamesSet' <= unprocessed.Keys
    {
      var tableName := tableNamesSeq[i];

      var writeRequests : DDB.WriteRequests := unprocessed[tableName];
      if !IsPlainWrite(config, tableName) {
        if tableName !in srcItems {
          return Failure(E(tableName + " in UnprocessedItems for BatchWriteItem response, but not in original request."));
        }
        var srcRequests := srcItems[tableName];
        var tableConfig := config.tableEncryptionConfigs[tableName];
        var origItems : seq<DDB.WriteRequest> := [];
        for x := 0 to |writeRequests|
          invariant |origItems| == x
        {
          var req : DDB.WriteRequest := writeRequests[x];
          if req.PutRequest.None? {
            // We only transform PutRequests, so no PutRequest ==> no change
            origItems := origItems + [req];
          } else {
            var orig_item :- GetOrigItem(tableConfig, srcRequests, req);
            origItems := origItems + [orig_item];
          }
        }
        writeRequests := origItems;
      }
      tableNamesSet' := tableNamesSet' - {tableName};
      i := i + 1;
      assert forall j | i <= j < |tableNamesSeq| :: tableNamesSeq[j] in tableNamesSet' by {
        reveal Seq.HasNoDuplicates();
      }
      result := result[tableName := writeRequests];
    }
    :- Need(|result| ==  |unprocessed|, E("Internal Error")); // Dafny gets too confused
    var new_output := input.sdkOutput.(UnprocessedItems := Some(result));
    return Success(BatchWriteItemOutputTransformOutput(transformedOutput := new_output));
  }

}
