package software.aws.cryptography.examples.searchableencryption;

public class SearchableEncryptionTestUtils {

  // This is the name of a GSI that must be configured on the table with name TEST_DDB_TABLE_NAME
  public static String TEST_BEACON_GSI = "Example-Beacon-Index-On-Beacons";

  // Our tests require access to DDB Table with this name
  public static final String TEST_DDB_TABLE_NAME = "SimpleBeaconTestTable";

  // The branch keystore DDB table must contain a branch key item with this value in the `branch-key-id` column
  public static final String TEST_BRANCH_KEY_ID = "hierarchy-test-v1";

  // The branch key must have been created using this KMS key
  // Note: This is a public resource that anyone can access.
  // This MUST NOT be used to encrypt any production data.
  public static final String TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ID = "arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126";

  // Our tests require access to DDB Table with this name configured as a branch keystore
  public static final String TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME = "arn:aws:dynamodb:us-west-2:370957321024:table/HierarchicalKeyringTestTable";

}