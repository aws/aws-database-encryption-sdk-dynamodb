// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DynamoDbMiddlewareSupport.dfy"

module BatchWriteItemTransform {
  import opened DdbMiddlewareConfig
  import opened DynamoDbMiddlewareSupport
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
  import EncTypes = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import Seq
  import SortedSets
  import Util = DynamoDbEncryptionUtil

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

            var item :- AddSignedBeacons(tableConfig, req.PutRequest.value.Item);

            var encryptRes := tableConfig.itemEncryptor.EncryptItem(EncTypes.EncryptItemInput(plaintextItem:=item));
            var encrypted :- MapError(encryptRes);
            var keyId :- GetKeyIdFromHeader(tableConfig, encrypted);
            var beaconAttrs :- GetEncryptedBeacons(tableConfig, req.PutRequest.value.Item, Util.MaybeFromOptionKeyId(keyId));

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

  method Output(config: Config, input: BatchWriteItemOutputTransformInput)
    returns (output: Result<BatchWriteItemOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    return Success(BatchWriteItemOutputTransformOutput(transformedOutput := input.sdkOutput));
  }

}
