using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Amazon.DynamoDBv2;
using Amazon.DynamoDBv2.Model;
using System.Diagnostics;
using Xunit;
using Examples.migration.PlaintextToAWSDBE;

namespace Examples.migration.PlaintextToAWSDBE.plaintext
{
    /*
    Test for Migration Step 0: This tests the pre-migration step for the
    plaintext-to-encrypted database migration.
    
    This test verifies that:
    1. Step 0 can successfully write and read plaintext items
    2. (Future) Step 0 can read items written by Step 1 (commented out until Step 1 is implemented)
    3. (Future) Step 0 cannot read items written by Steps 2 and 3 (commented out until Steps 2 and 3 are implemented)
    
    Running this test requires access to the DDB Table whose name
    is provided by TestUtils.TEST_DDB_TABLE_NAME.
    This table must be configured with the following
    primary key configuration:
      - Partition key is named "partition_key" with type (S)
      - Sort key is named "sort_key" with type (S)
    */
    public class MigrationStep0Test
    {
        [Fact]
        public async Task TestMigrationStep0()
        {
            string kmsKeyID = TestUtils.TEST_KMS_KEY_ID;
            string tableName = TestUtils.TEST_DDB_TABLE_NAME;
            string partitionKey = Guid.NewGuid().ToString();
            string[] sortKeys = { "0", "1", "2", "3" };

            try
            {
                // Successfully executes step 0
                bool success = await MigrationStep0.MigrationStep0Example(tableName, partitionKey, sortKeys[0], sortKeys[0]);
                Assert.True(success, "MigrationStep0 should complete successfully");

                // The following tests will be implemented once the other migration steps are created
                
                // Given: Step 1 has succeeded
                // await awsdbe.MigrationStep1.MigrationStep1Example(kmsKeyID, tableName, partitionKey, sortKeys[1], sortKeys[1]);
                
                // When: Execute Step 0 with sortReadValue=1, Then: Success (i.e. can read plaintext values)
                // success = await MigrationStep0.MigrationStep0Example(tableName, partitionKey, sortKeys[0], sortKeys[1]);
                // Assert.True(success, "MigrationStep0 should be able to read items written by Step 1");
                
                // Given: Step 2 has succeeded
                // await awsdbe.MigrationStep2.MigrationStep2Example(kmsKeyID, tableName, partitionKey, sortKeys[2], sortKeys[2]);
                
                // When: Execute Step 0 with sortReadValue=2, Then: should error out when reading encrypted items.
                // var exception = await Assert.ThrowsAsync<Exception>(() => 
                //     MigrationStep0.MigrationStep0Example(tableName, partitionKey, sortKeys[0], sortKeys[2]));
                // Assert.Contains("attribute1 is not a string attribute", exception.Message);
                
                // Given: Step 3 has succeeded (if it exists)
                // await awsdbe.MigrationStep3.MigrationStep3Example(kmsKeyID, tableName, partitionKey, sortKeys[3], sortKeys[3]);
                
                // When: Execute Step 0 with sortReadValue=3, Then: should error out
                // exception = await Assert.ThrowsAsync<Exception>(() => 
                //     MigrationStep0.MigrationStep0Example(tableName, partitionKey, sortKeys[0], sortKeys[3]));
                // Assert.Contains("attribute1 is not a string attribute", exception.Message);
            }
            finally
            {
                // Cleanup
                await MigrationUtils.CleanupItems(tableName, partitionKey, sortKeys);
            }
        }
    }
}
