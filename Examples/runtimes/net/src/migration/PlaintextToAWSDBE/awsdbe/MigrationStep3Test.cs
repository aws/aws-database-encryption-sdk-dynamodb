using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Amazon.DynamoDBv2;
using Amazon.DynamoDBv2.Model;
using System.Diagnostics;
using Xunit;
using Examples.migration.PlaintextToAWSDBE;
using Examples.migration.PlaintextToAWSDBE.plaintext;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor;

namespace Examples.migration.PlaintextToAWSDBE.awsdbe
{
    /*
    Test for Migration Step 3: This tests the final step in the
    plaintext-to-encrypted database migration.
    
    This test verifies that:
    1. Step 3 can successfully write encrypted items
    2. Step 3 cannot read items written by Step 0 (plaintext) - should throw an exception
    3. Step 3 cannot read items written by Step 1 (plaintext) - should throw an exception
    4. Step 3 can read items written by Step 2 (encrypted)
    5. Step 3 can read items written by itself (encrypted)
    
    Running this test requires access to the DDB Table whose name
    is provided by TestUtils.TEST_DDB_TABLE_NAME.
    This table must be configured with the following
    primary key configuration:
      - Partition key is named "partition_key" with type (S)
      - Sort key is named "sort_key" with type (N)
    */
    public class MigrationStep3Test
    {
        [Fact]
        public async Task TestMigrationStep3()
        {
            string kmsKeyID = TestUtils.TEST_KMS_KEY_ID;
            string tableName = TestUtils.TEST_DDB_TABLE_NAME;
            string partitionKey = Guid.NewGuid().ToString();
            string[] sortKeys = { "0", "1", "2", "3" };

            // Given: Step 0 has succeeded
            bool success = await MigrationStep0.MigrationStep0Example(tableName, partitionKey, sortKeys[0], sortKeys[0]);
            Assert.True(success, "MigrationStep0 should complete successfully");

            // Given: Step 1 has succeeded
            success = await MigrationStep1.MigrationStep1Example(kmsKeyID, tableName, partitionKey, sortKeys[1], sortKeys[1]);
            Assert.True(success, "MigrationStep1 should complete successfully");

            // Given: Step 2 has succeeded
            success = await MigrationStep2.MigrationStep2Example(kmsKeyID, tableName, partitionKey, sortKeys[2], sortKeys[2]);
            Assert.True(success, "MigrationStep2 should complete successfully");
            
            // Successfully executes step 3
            success = await MigrationStep3.MigrationStep3Example(kmsKeyID, tableName, partitionKey, sortKeys[3], sortKeys[3]);
            Assert.True(success, "MigrationStep3 should complete successfully");
            
            // When: Execute Step 3 with sortReadValue=0, Then: should error out when reading plaintext items from Step 0
            var exception = await Assert.ThrowsAsync<DynamoDbItemEncryptorException>(() => 
                MigrationStep3.MigrationStep3Example(kmsKeyID, tableName, partitionKey, sortKeys[3], sortKeys[0]));
            
            Assert.Contains("encrypted item missing expected header and footer attributes", exception.Message.ToLower());

            // When: Execute Step 3 with sortReadValue=1, Then: should error out when reading plaintext items from Step 1
            exception = await Assert.ThrowsAsync<DynamoDbItemEncryptorException>(() => 
                MigrationStep3.MigrationStep3Example(kmsKeyID, tableName, partitionKey, sortKeys[3], sortKeys[1]));
            Assert.Contains("encrypted item missing expected header and footer attributes", exception.Message.ToLower());

            // When: Execute Step 3 with sortReadValue=2, Then: Success (i.e. can read encrypted values from Step 2)
            success = await MigrationStep3.MigrationStep3Example(kmsKeyID, tableName, partitionKey, sortKeys[3], sortKeys[2]);
            Assert.True(success, "MigrationStep3 should be able to read items written by Step 2");

            // Cleanup
            await MigrationUtils.CleanupItems(tableName, partitionKey, sortKeys);
        }
    }
}
