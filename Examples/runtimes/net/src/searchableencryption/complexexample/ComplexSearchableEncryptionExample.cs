using System;
using System.Threading.Tasks;

public class ComplexSearchableEncryptionExample
{

    /*
     * This file is used in an example to demonstrate complex queries
     * you can perform using beacons.
     * The example data used is for demonstrative purposes only,
     * and might not meet the distribution and correlation uniqueness
     * recommendations for beacons.
     * See our documentation for whether beacons are
     * right for your particular data set:
     * https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/searchable-encryption.html#are-beacons-right-for-me
     */
    public static async Task RunExample(String branchKeyId)
    {
        var ddbTableName = TestUtils.TEST_COMPLEX_DDB_TABLE_NAME;
        var branchKeyWrappingKmsKeyArn = TestUtils.TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN;
        var branchKeyDdbTableName = TestUtils.TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME;

        var ddb = BeaconConfig.SetupBeaconConfig(ddbTableName, branchKeyId, branchKeyWrappingKmsKeyArn, branchKeyDdbTableName);
        await PutRequests.PutAllItemsToTable(ddbTableName, ddb);
        await QueryRequests.RunQueries(ddbTableName, ddb);
    }
}
