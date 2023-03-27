// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DynamoDbMiddlewareSupport.dfy"

module BatchWriteItemTransform {
  import opened DdbMiddlewareConfig
  import opened DynamoDbMiddlewareSupport
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import EncTypes = AwsCryptographyDynamoDbItemEncryptorTypes
  import Seq

  method Input(config: Config, input: BatchWriteItemInputTransformInput)
    returns (output: Result<BatchWriteItemInputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)

  {
    var tableNames := input.sdkInput.RequestItems.Keys;
    var result : map<DDB.TableName, DDB.WriteRequests> := map[];
    while tableNames != {}
      decreases |tableNames|
      invariant tableNames <= input.sdkInput.RequestItems.Keys
    {
      var tableName :| tableName in tableNames;
      tableNames := tableNames - { tableName };

      var writeRequests : DDB.WriteRequests := input.sdkInput.RequestItems[tableName];
      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-batchwriteitem
      //# If the table name does not refer to an [encrypted-table](#encrypted-table),
      //# the list of operations MUST be unchanged.
      if tableName in config.tableEncryptionConfigs {
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

            //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-batchwriteitem
            //# Beacons MUST be [added](ddb-support.md#addbeacons).
            var item :- AddBeacons(tableConfig, req.PutRequest.value.Item);

            //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-batchwriteitem
            //# If the request is validated,
            //# the [Item Encryptor](./ddb-item-encryptor.md) MUST perform
            //# [Encrypt Item](./encrypt-item.md),
            //# where the input [DynamoDB Item](./encrypt-item.md#dynamodb-item)
            //# is output of the [add beacons](ddb-support.md#addbeacons) operation.
            var encryptRes := tableConfig.itemEncryptor.EncryptItem(EncTypes.EncryptItemInput(plaintextItem:=item));
            var encrypted :- MapError(encryptRes);

            //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-batchwriteitem
            //# The PutRequest request's `Item` field MUST be replaced
            //# with a value that is equivalent to
            //# the result [Encrypted DynamoDB Item](./encrypt-item.md#encrypted-dynamodb-item)
            //# calculated above.
            encryptedItems := encryptedItems + [req.(PutRequest := Some(DDB.PutRequest(Item := encrypted.encryptedItem)))];
          }
        }
        writeRequests := encryptedItems;
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
