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
    public class MigrationStep2Test
    {
        [Fact]
        public async Task TestMigrationStep2()
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

            // Successfully executes step 2
            success = await MigrationStep2.MigrationStep2Example(kmsKeyID, tableName, partitionKey, sortKeys[2], sortKeys[2]);
            Assert.True(success, "MigrationStep2 should complete successfully");

            // When: Execute Step 2 with sortReadValue=0, Then: Success (i.e. can read plaintext values from Step 0)
            success = await MigrationStep2.MigrationStep2Example(kmsKeyID, tableName, partitionKey, sortKeys[2], sortKeys[0]);
            Assert.True(success, "MigrationStep2 should be able to read items written by Step 0");

            // When: Execute Step 2 with sortReadValue=1, Then: Success (i.e. can read plaintext values from Step 1)
            success = await MigrationStep2.MigrationStep2Example(kmsKeyID, tableName, partitionKey, sortKeys[2], sortKeys[1]);
            Assert.True(success, "MigrationStep2 should be able to read items written by Step 1");

            // Given: Step 3 has succeeded
            success = await MigrationStep3.MigrationStep3Example(kmsKeyID, tableName, partitionKey, sortKeys[3], sortKeys[3]);
            Assert.True(success, "MigrationStep3 should complete successfully");

            // When: Execute Step 2 with sortReadValue=3, Then: Success (i.e. can read encrypted values from Step 3)
            success = await MigrationStep2.MigrationStep2Example(kmsKeyID, tableName, partitionKey, sortKeys[2], sortKeys[3]);
            Assert.True(success, "MigrationStep2 should be able to read items written by Step 3");

            // Cleanup
            foreach (var sortKey in sortKeys)
            {
                await TestUtils.CleanupItems(tableName, partitionKey, sortKey);
            }
        }
    }
}
