using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Amazon.DynamoDBv2;
using Amazon.DynamoDBv2.Model;
using System.Diagnostics;
using Xunit;
using Examples.migration.PlaintextToAWSDBE;
using Examples.migration.PlaintextToAWSDBE.plaintext;

namespace Examples.migration.PlaintextToAWSDBE.awsdbe
{
    /*
    Test for Migration Step 1: This tests the first step in the
    plaintext-to-encrypted database migration.
    
    This test verifies that:
    1. Step 1 can successfully write plaintext items
    2. Step 1 can read items written by Step 0 (plaintext)
    3. Step 1 can read items written by itself (plaintext)
    4. Step 1 can read items written by Step 2 (encrypted)
    5. Step 1 can read items written by Step 3 (encrypted)
    
    Running this test requires access to the DDB Table whose name
    is provided by TestUtils.TEST_DDB_TABLE_NAME.
    This table must be configured with the following
    primary key configuration:
      - Partition key is named "partition_key" with type (S)
      - Sort key is named "sort_key" with type (N)
    */
    public class MigrationStep1Test
    {
        [Fact]
        public async Task TestMigrationStep1()
        {
            string kmsKeyID = TestUtils.TEST_KMS_KEY_ID;
            string tableName = TestUtils.TEST_DDB_TABLE_NAME;
            string partitionKey = Guid.NewGuid().ToString();
            string[] sortKeys = { "0", "1", "2", "3" };

            // Given: Step 0 has succeeded
            bool success = await MigrationStep0.MigrationStep0Example(tableName, partitionKey, sortKeys[0], sortKeys[0]);
            Assert.True(success, "MigrationStep0 should complete successfully");

            // Successfully executes step 1
            success = await MigrationStep1.MigrationStep1Example(kmsKeyID, tableName, partitionKey, sortKeys[1], sortKeys[1]);
            Assert.True(success, "MigrationStep1 should complete successfully");

            // When: Execute Step 1 with sortReadValue=0, Then: Success (i.e. can read plaintext values from Step 0)
            success = await MigrationStep1.MigrationStep1Example(kmsKeyID, tableName, partitionKey, sortKeys[1], sortKeys[0]);
            Assert.True(success, "MigrationStep1 should be able to read items written by Step 0");

            // Given: Step 2 has succeeded
            success = await MigrationStep2.MigrationStep2Example(kmsKeyID, tableName, partitionKey, sortKeys[2], sortKeys[2]);
            Assert.True(success, "MigrationStep2 should complete successfully");

            // When: Execute Step 1 with sortReadValue=2, Then: Success (i.e. can read encrypted values from Step 2)
            success = await MigrationStep1.MigrationStep1Example(kmsKeyID, tableName, partitionKey, sortKeys[1], sortKeys[2]);
            Assert.True(success, "MigrationStep1 should be able to read items written by Step 2");

            // Given: Step 3 has succeeded
            success = await MigrationStep3.MigrationStep3Example(kmsKeyID, tableName, partitionKey, sortKeys[3], sortKeys[3]);
            Assert.True(success, "MigrationStep3 should complete successfully");

            // When: Execute Step 1 with sortReadValue=3, Then: Success (i.e. can read encrypted values from Step 3)
            success = await MigrationStep1.MigrationStep1Example(kmsKeyID, tableName, partitionKey, sortKeys[1], sortKeys[3]);
            Assert.True(success, "MigrationStep1 should be able to read items written by Step 3");

            // Cleanup
            foreach (var sortKey in sortKeys)
            {
                await TestUtils.CleanupItems(tableName, partitionKey, sortKey);
            }
        }
    }
}
