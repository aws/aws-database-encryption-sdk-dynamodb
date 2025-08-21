using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Amazon.DynamoDBv2;
using Amazon.DynamoDBv2.Model;
using System.Diagnostics;
using System.Net;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
using AWS.Cryptography.MaterialProviders;
using Examples.migration.PlaintextToAWSDBE;

namespace Examples.migration.PlaintextToAWSDBE.awsdbe
{
    /*
    Migration Step 1: This is the first step in the migration process from
    plaintext to encrypted DynamoDB using the AWS Database Encryption SDK.
    
    In this example, we configure a DynamoDB Encryption client to do the following:
    1. Write items only in plaintext
    2. Read items in plaintext or, if the item is encrypted, decrypt with our encryption configuration
    
    While this step configures your client to be ready to start reading encrypted items,
    we do not yet expect to be reading any encrypted items,
    as our client still writes plaintext items.
    Before you move on to step 2, ensure that these changes have successfully been deployed
    to all of your readers.
    
    Running this example requires access to the DDB Table whose name
    is provided in the function parameter.
    This table must be configured with the following
    primary key configuration:
      - Partition key is named "partition_key" with type (S)
      - Sort key is named "sort_key" with type (N)
    */
    public class MigrationStep1
    {
        public static async Task<bool> MigrationStep1Example(string kmsKeyId, string ddbTableName, string partitionKeyValue, string sortKeyWriteValue, string sortKeyReadValue)
        {
            var tableConfigs = Common.CreateTableConfigs(kmsKeyId, ddbTableName, PlaintextOverride.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ);

            // 1. Create a new AWS SDK DynamoDb client using the TableEncryptionConfigs
            var ddb = new Client.DynamoDbClient(
                new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigs });

            // 2. Put an item into our table using the above client.
            //    This item will be stored in plaintext due to our PlaintextOverride configuration.
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

            // 3. Get an item back from the table using the same client.
            //    If this is an item written in plaintext (i.e. any item written
            //    during Step 0 or 1), then the item will still be in plaintext.
            //    If this is an item that was encrypted client-side (i.e. any item written
            //    during Step 2 or after), then the item will be decrypted client-side
            //    and surfaced as a plaintext item.
            var key = new Dictionary<string, AttributeValue>
            {
                ["partition_key"] = new AttributeValue { S = partitionKeyValue },
                ["sort_key"] = new AttributeValue { N = sortKeyReadValue }
            };

            var getRequest = new GetItemRequest
            {
                TableName = ddbTableName,
                Key = key,
                // In this example we configure a strongly consistent read
                // because we perform a read immediately after a write (for demonstrative purposes).
                // By default, reads are only eventually consistent.
                ConsistentRead = true
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
                Console.WriteLine("MigrationStep1 completed successfully");
            }
            return success;
        }
    }
}
