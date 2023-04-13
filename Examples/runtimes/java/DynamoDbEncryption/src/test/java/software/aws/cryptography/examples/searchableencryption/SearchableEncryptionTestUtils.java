package software.aws.cryptography.examples.searchableencryption;

public class SearchableEncryptionTestUtils {

  // This is a public KMS Key that MUST only be used for testing, and MUST NOT be used for any production data
  public static String TEST_BEACON_GSI = "Example-Beacon-Index-On-Beacons";

  // Our tests require access to DDB Table with this name
  public static final String TEST_DDB_TABLE_NAME = "SimpleBeaconTestTable";

  // Our tests require access to DDB Table with this name
  public static final String TEST_BRANCH_KEY_ID = "hierarchy-test-v1";
  // Our tests require access to DDB Table with this name
  public static final String TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ID = "arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126";
  // Our tests require access to DDB Table with this name
  public static final String TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME = "arn:aws:dynamodb:us-west-2:370957321024:table/HierarchicalKeyringTestTable";

}