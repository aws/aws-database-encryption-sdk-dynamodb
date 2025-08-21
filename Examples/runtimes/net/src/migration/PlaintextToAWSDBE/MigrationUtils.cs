using System;
using System.Collections.Generic;
using Amazon.DynamoDBv2.Model;

namespace Examples.migration.PlaintextToAWSDBE
{
    /*
    Utility class for the PlaintextToAWSDBE migration examples.
    This class contains shared functionality used by all migration steps.
    */
    public class MigrationUtils
    {
        // Common attribute values used across all migration steps
        public static readonly string ENCRYPTED_AND_SIGNED_VALUE = "this will be encrypted and signed";
        public static readonly string SIGN_ONLY_VALUE = "this will never be encrypted, but it will be signed";
        public static readonly string DO_NOTHING_VALUE = "this will never be encrypted nor signed";
        
        // Verify that a returned item matches the expected values
        public static bool VerifyReturnedItem(GetItemResponse response, string partitionKeyValue, string sortKeyValue, 
                                             string encryptedAndSignedValue = null, string signOnlyValue = null, string doNothingValue = null)
        {
            // Use default values if not provided
            encryptedAndSignedValue = encryptedAndSignedValue ?? ENCRYPTED_AND_SIGNED_VALUE;
            signOnlyValue = signOnlyValue ?? SIGN_ONLY_VALUE;
            doNothingValue = doNothingValue ?? DO_NOTHING_VALUE;
            
            var item = response.Item;
            
            // Verify partition key
            if (!item.ContainsKey("partition_key") || item["partition_key"].S != partitionKeyValue)
            {
                throw new Exception($"partition_key mismatch: expected {partitionKeyValue}, got {(item.ContainsKey("partition_key") ? item["partition_key"].S : "null")}");
            }
            
            // Verify sort key
            if (!item.ContainsKey("sort_key") || item["sort_key"].N != sortKeyValue)
            {
                throw new Exception($"sort_key mismatch: expected {sortKeyValue}, got {(item.ContainsKey("sort_key") ? item["sort_key"].N : "null")}");
            }
            
            // Verify attribute1 (will be encrypted and signed in future steps)
            if (!item.ContainsKey("attribute1") || item["attribute1"].S != encryptedAndSignedValue)
            {
                throw new Exception($"attribute1 mismatch: expected {encryptedAndSignedValue}, got {(item.ContainsKey("attribute1") ? item["attribute1"].S : "null")}");
            }
            
            // Verify attribute2 (will be signed but not encrypted in future steps)
            if (!item.ContainsKey("attribute2") || item["attribute2"].S != signOnlyValue)
            {
                throw new Exception($"attribute2 mismatch: expected {signOnlyValue}, got {(item.ContainsKey("attribute2") ? item["attribute2"].S : "null")}");
            }
            
            // Verify attribute3 (will neither be encrypted nor signed in future steps)
            if (!item.ContainsKey("attribute3") || item["attribute3"].S != doNothingValue)
            {
                throw new Exception($"attribute3 mismatch: expected {doNothingValue}, got {(item.ContainsKey("attribute3") ? item["attribute3"].S : "null")}");
            }
            
            return true;
        }

        // Helper method to clean up test items
        public static async System.Threading.Tasks.Task CleanupItems(string tableName, string partitionKey, string[] sortKeys)
        {
            var ddb = new Amazon.DynamoDBv2.AmazonDynamoDBClient();
            
            foreach (var sortKey in sortKeys)
            {
                try
                {
                    var key = new Dictionary<string, AttributeValue>
                    {
                        ["partition_key"] = new AttributeValue { S = partitionKey },
                        ["sort_key"] = new AttributeValue { N = sortKey }
                    };

                    var deleteRequest = new DeleteItemRequest
                    {
                        TableName = tableName,
                        Key = key
                    };

                    await ddb.DeleteItemAsync(deleteRequest);
                }
                catch (Exception e)
                {
                    // Log but don't fail if cleanup fails
                    Console.WriteLine($"Warning: Failed to clean up test item with sort key {sortKey}: {e.Message}");
                }
            }
        }
    }
}
