using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Amazon.DynamoDBv2;
using Amazon.DynamoDBv2.Model;
using System.Diagnostics;
using System.Net;
using Examples.migration.PlaintextToAWSDBE;

namespace Examples.migration.PlaintextToAWSDBE.plaintext
{
    /*
    Migration Step 0: This is the pre-migration step for the
    plaintext-to-encrypted database migration, and is the starting
    state for our migration from a plaintext database to a
    client-side encrypted database encrypted using the
    AWS Database Encryption SDK for DynamoDb.

    In this example, we configure a DynamoDbClient to
    write a plaintext record to a table and read that record.
    This emulates the starting state of a plaintext-to-encrypted
    database migration; i.e. a plaintext database you can
    read and write to with the DynamoDbClient.

    Running this example requires access to the DDB Table whose name
    is provided in the function parameter.
    This table must be configured with the following
    primary key configuration:
      - Partition key is named "partition_key" with type (S)
      - Sort key is named "sort_key" with type (S)
    */
    public class MigrationStep0
    {
        public static async Task<bool> MigrationStep0Example(string ddbTableName, string partitionKeyValue, string sortKeyWriteValue, string sortKeyReadValue)
        {
            try
            {
                // 1. Create a standard DynamoDB client
                var ddb = new AmazonDynamoDBClient();

                // 2. Put an example item into DynamoDB table
                //    This item will be stored in plaintext.
                string encryptedAndSignedValue = MigrationUtils.ENCRYPTED_AND_SIGNED_VALUE;
                string signOnlyValue = MigrationUtils.SIGN_ONLY_VALUE;
                string doNothingValue = MigrationUtils.DO_NOTHING_VALUE;
                var item = new Dictionary<string, AttributeValue>
                {
                    ["partition_key"] = new AttributeValue { S = partitionKeyValue },
                    ["sort_key"] = new AttributeValue { N = sortKeyWriteValue },
                    ["attribute1"] = new AttributeValue { S = encryptedAndSignedValue },
                    ["attribute2"] = new AttributeValue { S = signOnlyValue },
                    ["attribute3"] = new AttributeValue { S = doNothingValue }
                };

                var putRequest = new PutItemRequest
                {
                    TableName = ddbTableName,
                    Item = item
                };

                var putResponse = await ddb.PutItemAsync(putRequest);
                Debug.Assert(putResponse.HttpStatusCode == HttpStatusCode.OK);

                // 3. Get an item back from the table as it was written.
                //    If this is an item written in plaintext (i.e. any item written
                //    during Step 0 or 1), then the item will still be in plaintext
                //    and will be able to be processed.
                //    If this is an item that was encrypted client-side (i.e. any item written
                //    during Step 2 or after), then the item will still be encrypted client-side
                //    and will be unable to be processed in your code. To decrypt and process
                //    client-side encrypted items, you will need to configure encrypted reads on
                //    your dynamodb client (this is configured from Step 1 onwards).
                var key = new Dictionary<string, AttributeValue>
                {
                    ["partition_key"] = new AttributeValue { S = partitionKeyValue },
                    ["sort_key"] = new AttributeValue { N = sortKeyReadValue }
                };

                var getRequest = new GetItemRequest
                {
                    TableName = ddbTableName,
                    Key = key
                };

                var getResponse = await ddb.GetItemAsync(getRequest);
                Debug.Assert(getResponse.HttpStatusCode == HttpStatusCode.OK);

                // 4. Verify we get the expected item back
                if (getResponse.Item == null)
                {
                    throw new Exception("No item found");
                }

                bool success = MigrationUtils.VerifyReturnedItem(getResponse, partitionKeyValue, sortKeyReadValue);
                if (success)
                {
                    Console.WriteLine("MigrationStep0 completed successfully");
                }
                return success;
            }
            catch (Exception e)
            {
                Console.WriteLine($"Error in MigrationStep0: {e.Message}");
                throw;
            }
        }

    }
}
