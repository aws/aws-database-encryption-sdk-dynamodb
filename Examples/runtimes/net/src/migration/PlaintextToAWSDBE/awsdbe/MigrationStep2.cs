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
    Migration Step 2: This is the second step in the migration process from
    plaintext to encrypted DynamoDB using the AWS Database Encryption SDK.
    
    In this example, we configure a DynamoDB Encryption client to do the following:
    1. Write items with encryption (no longer writing plaintext)
    2. Read both plaintext items and encrypted items
    
    Once you deploy this change to your system, you will have a dataset
    containing both encrypted and plaintext items.
    Because the changes in Step 1 have been deployed to all readers,
    we can be sure that our entire system is ready to read this new data.
    
    Before you move onto the next step, you will need to encrypt all plaintext items in your dataset.
    How you will want to do this depends on your system.
    
    Running this example requires access to the DDB Table whose name
    is provided in the function parameter.
    This table must be configured with the following
    primary key configuration:
      - Partition key is named "partition_key" with type (S)
      - Sort key is named "sort_key" with type (N)
    */
    public class MigrationStep2
    {
        public static async Task<bool> MigrationStep2Example(string kmsKeyId, string ddbTableName, string partitionKeyValue, string sortKeyWriteValue, string sortKeyReadValue)
        {
            // 1. Create table configurations
            // In this of migration we will use PlaintextOverride.FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ
            // which means:
            // - Write: Items are forbidden to be written as plaintext.
            //         Items will be written as encrypted items.
            // - Read: Items are allowed to be read as plaintext.
            //         Items are allowed to be read as encrypted items.
            var tableConfigs = Common.CreateTableConfigs(kmsKeyId, ddbTableName, PlaintextOverride.FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ);

            // 2. Create a new AWS SDK DynamoDb client using the TableEncryptionConfigs
            var ddb = new Client.DynamoDbClient(
                new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigs });

            // 3. Put an item into our table using the above client.
            //    This item will be encrypted due to our PlaintextOverride configuration.
            string partitionKeyName = "partition_key";
            string sortKeyName = "sort_key";
            string encryptedAndSignedValue = MigrationUtils.ENCRYPTED_AND_SIGNED_VALUE;
            string signOnlyValue = MigrationUtils.SIGN_ONLY_VALUE;
            string doNothingValue = MigrationUtils.DO_NOTHING_VALUE;
            var item = new Dictionary<string, AttributeValue>
            {
                [partitionKeyName] = new AttributeValue { S = partitionKeyValue },
                [sortKeyName] = new AttributeValue { N = sortKeyWriteValue },
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

            // 4. Get an item back from the table using the same client.
            //    If this is an item written in plaintext (i.e. any item written
            //    during Step 0 or 1), then the item will still be in plaintext.
            //    If this is an item that was encrypted client-side (i.e. any item written
            //    during Step 2 or after), then the item will be decrypted client-side
            //    and surfaced as a plaintext item.
            var key = new Dictionary<string, AttributeValue>
            {
                [partitionKeyName] = new AttributeValue { S = partitionKeyValue },
                [sortKeyName] = new AttributeValue { N = sortKeyReadValue }
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

            // 5. Verify we get the expected item back
            if (getResponse.Item == null)
            {
                throw new Exception("No item found");
            }

            bool success = MigrationUtils.VerifyReturnedItem(getResponse, partitionKeyValue, sortKeyReadValue);
            if (success)
            {
                Console.WriteLine("MigrationStep2 completed successfully");
            }
            return success;
        }
    }
}
