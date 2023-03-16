// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DdbMiddlewareConfig.dfy"

module BatchWriteItemTransform {
  import opened DdbMiddlewareConfig
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import EncTypes = AwsCryptographyDynamoDbItemEncryptorTypes
  import Seq


  lemma MapAdds<X,Y>(m : map<X,Y>, x : X, y : Y)
    ensures
      && var newMap := m[x := y];
      && newMap.Keys == m.Keys + {x}
    {}
  lemma AddThree<X>(x : set<X>, y : set<X>, z : set<X>)
    ensures x + y + z == x + z + y
  {}

  method {:vcs_split_on_every_assert} Input(config: Config, input: BatchWriteItemInputTransformInput)
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
      invariant result.Keys + tableNames == input.sdkInput.RequestItems.Keys
      // true but expensive -- invariant forall k <- result.Keys :: |input.sdkInput.RequestItems[k]| == |result[k]|
    {
      var tableName :| tableName in tableNames;
      assert tableNames <= input.sdkInput.RequestItems.Keys;
      ghost var oldTableNames := tableNames;
      tableNames := tableNames - { tableName };
      assert oldTableNames == tableNames + { tableName };
      assert tableNames < input.sdkInput.RequestItems.Keys;
      assert result.Keys + oldTableNames == input.sdkInput.RequestItems.Keys;
      assert result.Keys + tableNames + { tableName } == input.sdkInput.RequestItems.Keys;

      var writeRequests : DDB.WriteRequests := input.sdkInput.RequestItems[tableName];
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
            //# For each `PutRequest` under each key in `RequestItems`,
            //# if there is an Item Encryptor with [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name) equal to the key,
            //# that Item Encryptor MUST perform [Encrypt Item](./encrypt-item.md) where the input
            //# [DynamoDB Item](./encrypt-item.md#dynamodb-item) is the `Item` field in this `PutRequest`
            var encryptRes := tableConfig.itemEncryptor.EncryptItem(EncTypes.EncryptItemInput(plaintextItem:=req.PutRequest.value.Item));

            //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-batchwriteitem
            //# If any [Encrypt Item](./encrypt-item.md) fails,
            //# the client MUST NOT make a network call to DynamoDB,
            //# and BatchWriteItem MUST yield an error.
            var encrypted :- MapError(encryptRes);

            //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-batchwriteitem
            //# The `Item` field in this `PutRequest` MUST be replaced
            //# with a value that is equivalent to
            //# the result [Encrypted DynamoDB Item](./encrypt-item.md#encrypted-dynamodb-item).
            // We only transform PutRequests, so leave the rest of original request alone
            encryptedItems := encryptedItems + [req.(PutRequest := Some(DDB.PutRequest(Item := encrypted.encryptedItem)))];
          }
        }
        assert |writeRequests| == |encryptedItems|;
        writeRequests := encryptedItems;
      }

      ghost var oldResult := result;
      assert result.Keys + tableNames + { tableName } == input.sdkInput.RequestItems.Keys;
      assert oldResult.Keys + tableNames + { tableName } == input.sdkInput.RequestItems.Keys;
      AddThree(oldResult.Keys, tableNames, { tableName } );
      assert oldResult.Keys + { tableName } + tableNames == input.sdkInput.RequestItems.Keys;
      MapAdds(result, tableName, writeRequests);
      MapAdds(oldResult, tableName, writeRequests);

      result := result[tableName := writeRequests];

      assert oldResult[tableName := writeRequests].Keys == oldResult.Keys + {tableName};
      assert oldResult[tableName := writeRequests] == result;
      assert oldResult[tableName := writeRequests].Keys == result.Keys;
    }
    return Success(BatchWriteItemInputTransformOutput(transformedInput := input.sdkInput.(RequestItems := result)));
  }

  method Output(config: Config, input: BatchWriteItemOutputTransformInput)
    returns (output: Result<BatchWriteItemOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    return Success(BatchWriteItemOutputTransformOutput(transformedOutput := input.sdkOutput));
  }

}
