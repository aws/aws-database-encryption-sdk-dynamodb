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
    
    This step will be implemented in the future. It will demonstrate how to:
    1. Configure a DynamoDB client with encryption capabilities
    2. Write items that can still be read by plaintext clients (Step 0)
    3. Read both plaintext items and items written by this step
    
    Running this example requires access to the DDB Table whose name
    is provided in the function parameter.
    This table must be configured with the following
    primary key configuration:
      - Partition key is named "partition_key" with type (S)
      - Sort key is named "sort_key" with type (S)
    */
    public class MigrationStep1
    {
        // This method will be implemented in the future
        public static async Task<bool> MigrationStep1Example(string kmsKeyId, string ddbTableName, string partitionKeyValue, string sortKeyWriteValue, string sortKeyReadValue)
        {
            // TODO: Implement MigrationStep1
            throw new NotImplementedException("MigrationStep1 is not yet implemented");
        }
    }
}
