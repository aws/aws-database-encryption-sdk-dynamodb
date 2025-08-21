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
    
    This step will be implemented in the future. It will demonstrate how to:
    1. Configure a DynamoDB client with full encryption capabilities
    2. Write fully encrypted items that cannot be read by plaintext clients (Step 0)
    3. Read both plaintext items and fully encrypted items
    
    Running this example requires access to the DDB Table whose name
    is provided in the function parameter.
    This table must be configured with the following
    primary key configuration:
      - Partition key is named "partition_key" with type (S)
      - Sort key is named "sort_key" with type (S)
    */
    public class MigrationStep2
    {
        // This method will be implemented in the future
        public static async Task<bool> MigrationStep2Example(string kmsKeyId, string ddbTableName, string partitionKeyValue, string sortKeyWriteValue, string sortKeyReadValue)
        {
            // TODO: Implement MigrationStep2
            throw new NotImplementedException("MigrationStep2 is not yet implemented");
        }
    }
}
