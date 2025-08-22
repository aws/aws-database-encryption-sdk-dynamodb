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
        public static bool VerifyReturnedItem(GetItemResponse response, string partitionKeyValue, string sortKeyValue)
        {
            var item = response.Item;

            if (!item.ContainsKey("partition_key") || item["partition_key"].S != partitionKeyValue)
            {
                throw new Exception($"partition_key mismatch: expected {partitionKeyValue}, got {(item.ContainsKey("partition_key") ? item["partition_key"].S : "null")}");
            }

            if (!item.ContainsKey("sort_key") || item["sort_key"].N != sortKeyValue)
            {
                throw new Exception($"sort_key mismatch: expected {sortKeyValue}, got {(item.ContainsKey("sort_key") ? item["sort_key"].N : "null")}");
            }

            if (!item.ContainsKey("attribute1") || item["attribute1"].S != ENCRYPTED_AND_SIGNED_VALUE)
            {
                throw new Exception($"attribute1 mismatch: expected {ENCRYPTED_AND_SIGNED_VALUE}, got {(item.ContainsKey("attribute1") ? item["attribute1"].S : "null")}");
            }

            if (!item.ContainsKey("attribute2") || item["attribute2"].S != SIGN_ONLY_VALUE)
            {
                throw new Exception($"attribute2 mismatch: expected {SIGN_ONLY_VALUE}, got {(item.ContainsKey("attribute2") ? item["attribute2"].S : "null")}");
            }

            if (!item.ContainsKey("attribute3") || item["attribute3"].S != DO_NOTHING_VALUE)
            {
                throw new Exception($"attribute3 mismatch: expected {DO_NOTHING_VALUE}, got {(item.ContainsKey("attribute3") ? item["attribute3"].S : "null")}");
            }

            return true;
        }
    }
}
