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
    public class MigrationStep3Test
    {
        [Fact]
        public async Task TestMigrationStep3()
        {
            string kmsKeyID = TestUtils.TEST_KMS_KEY_ID;
            string tableName = TestUtils.TEST_DDB_TABLE_NAME;
            string partitionKey = Guid.NewGuid().ToString();
            string[] sortKeys = { "0", "1", "2", "3" };

            // Successfully executes step 3
            bool success = await MigrationStep3.MigrationStep3Example(kmsKeyID, tableName, partitionKey, sortKeys[3], sortKeys[3]);
            Assert.True(success, "MigrationStep3 should complete successfully");

            // Given: Step 0 has succeeded
            success = await MigrationStep0.MigrationStep0Example(tableName, partitionKey, sortKeys[0], sortKeys[0]);
            Assert.True(success, "MigrationStep0 should complete successfully");

            // When: Execute Step 3 with sortReadValue=0, Then: should error out when reading plaintext items from Step 0
            var exception = await Assert.ThrowsAsync<DynamoDbItemEncryptorException>(() =>
                MigrationStep3.MigrationStep3Example(kmsKeyID, tableName, partitionKey, sortKeys[3], sortKeys[0]));

            // Given: Step 1 has succeeded
            success = await MigrationStep1.MigrationStep1Example(kmsKeyID, tableName, partitionKey, sortKeys[1], sortKeys[1]);
            Assert.True(success, "MigrationStep1 should complete successfully");

            // When: Execute Step 3 with sortReadValue=1, Then: should error out when reading plaintext items from Step 1
            exception = await Assert.ThrowsAsync<DynamoDbItemEncryptorException>(() =>
                MigrationStep3.MigrationStep3Example(kmsKeyID, tableName, partitionKey, sortKeys[3], sortKeys[1]));
            Assert.Contains("encrypted item missing expected header and footer attributes", exception.Message.ToLower());

            // Given: Step 2 has succeeded
            success = await MigrationStep2.MigrationStep2Example(kmsKeyID, tableName, partitionKey, sortKeys[2], sortKeys[2]);
            Assert.True(success, "MigrationStep2 should complete successfully");

            Assert.Contains("encrypted item missing expected header and footer attributes", exception.Message.ToLower());

            // When: Execute Step 3 with sortReadValue=2, Then: Success (i.e. can read encrypted values from Step 2)
            success = await MigrationStep3.MigrationStep3Example(kmsKeyID, tableName, partitionKey, sortKeys[3], sortKeys[2]);
            Assert.True(success, "MigrationStep3 should be able to read items written by Step 2");

            // Cleanup
            foreach (var sortKey in sortKeys)
            {
                await TestUtils.CleanupItems(tableName, partitionKey, sortKey);
            }
        }
    }
}
