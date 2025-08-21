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
    Migration Step 3: This is the final step in the migration process from
    plaintext to encrypted DynamoDB using the AWS Database Encryption SDK.
    
    In this example, we configure a DynamoDB Encryption client to do the following:
    1. Write items with encryption (no longer writing plaintext)
    2. Read only encrypted items (no longer reading plaintext)
    
    Once you complete Step 3, all items being read by your system are encrypted.
    
    Before you move onto this step, you will need to encrypt all plaintext items in your dataset.
    How you will want to do this depends on your system.
    
    Running this example requires access to the DDB Table whose name
    is provided in the function parameter.
    This table must be configured with the following
    primary key configuration:
      - Partition key is named "partition_key" with type (S)
      - Sort key is named "sort_key" with type (N)
    */
    public class MigrationStep3
    {
        public static async Task<bool> MigrationStep3Example(string kmsKeyId, string ddbTableName, string partitionKeyValue, string sortKeyWriteValue, string sortKeyReadValue)
        {
            // 1. Create a Keyring. This Keyring will be responsible for protecting the data keys that protect your data.
            //    For this example, we will create a AWS KMS Keyring with the AWS KMS Key we want to use.
            //    We will use the `CreateMrkMultiKeyring` method to create this keyring,
            //    as it will correctly handle both single region and Multi-Region KMS Keys.
            var matProv = new MaterialProviders(new MaterialProvidersConfig());
            var keyringInput = new CreateAwsKmsMrkMultiKeyringInput { Generator = kmsKeyId };
            var kmsKeyring = matProv.CreateAwsKmsMrkMultiKeyring(keyringInput);

            // 2. Configure which attributes are encrypted and/or signed when writing new items.
            //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
            //    we must explicitly configure how they should be treated during item encryption:
            //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
            //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
            //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
            var attributeActionsOnEncrypt = new Dictionary<string, CryptoAction>
            {
                ["partition_key"] = CryptoAction.SIGN_ONLY, // Our partition attribute must be SIGN_ONLY
                ["sort_key"] = CryptoAction.SIGN_ONLY, // Our sort attribute must be SIGN_ONLY
                ["attribute1"] = CryptoAction.ENCRYPT_AND_SIGN,
                ["attribute2"] = CryptoAction.SIGN_ONLY,
                ["attribute3"] = CryptoAction.DO_NOTHING
            };

            // 3. Configure which attributes we expect to be excluded in the signature
            //    when reading items.
            //    For this example, we will explicitly list the attributes that are not signed.
            var unsignedAttributes = new List<string> { "attribute3" };

            // 4. Create the DynamoDb Encryption configuration for the table we will be writing to.
            //    This configuration uses PlaintextOverride.FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ
            //    which means:
            //    - Write: Items are forbidden to be written as plaintext.
            //             Items will be written as encrypted items.
            //    - Read: Items are forbidden to be read as plaintext.
            //            Items will be read as encrypted items.
            //    Note: If you do not specify a PlaintextOverride, it defaults to
            //          FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ, which is the desired
            //          behavior for a client interacting with a fully encrypted database.
            var tableConfig = new DynamoDbTableEncryptionConfig
            {
                LogicalTableName = ddbTableName,
                PartitionKeyName = "partition_key",
                SortKeyName = "sort_key",
                AttributeActionsOnEncrypt = attributeActionsOnEncrypt,
                Keyring = kmsKeyring,
                AllowedUnsignedAttributes = unsignedAttributes,
                PlaintextOverride = PlaintextOverride.FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ
            };

            var tableConfigs = new Dictionary<string, DynamoDbTableEncryptionConfig>
            {
                [ddbTableName] = tableConfig
            };

            // 5. Create a new AWS SDK DynamoDb client using the TableEncryptionConfigs
            var ddb = new Client.DynamoDbClient(
                new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigs });

            // 6. Put an item into our table using the above client.
            //    This item will be encrypted due to our PlaintextOverride configuration.
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

            // 7. Get an item back from the table using the same client.
            //    If this is an item written in plaintext (i.e. any item written
            //    during Step 0 or 1), then the read will fail, as we have
            //    configured our client to forbid reading plaintext items.
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

            // 8. Verify we get the expected item back
            if (getResponse.Item == null)
            {
                throw new Exception("No item found");
            }

            bool success = MigrationUtils.VerifyReturnedItem(getResponse, partitionKeyValue, sortKeyReadValue);
            if (success)
            {
                Console.WriteLine("MigrationStep3 completed successfully");
            }
            return success;
        }
    }
}
