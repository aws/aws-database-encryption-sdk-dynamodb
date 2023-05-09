package software.aws.cryptography.examples;

public class TestUtils {
    public static final String TEST_KEYSTORE_NAME = "KeyStoreTestTable";
    public static final String TEST_LOGICAL_KEYSTORE_NAME = "KeyStoreTestTable";
    public static final String TEST_KEYSTORE_KMS_KEY_ID = "arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126";

    // This is a public KMS Key that MUST only be used for testing, and MUST NOT be used for any production data
    public static final String TEST_KMS_KEY_ID = "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f";

    // Our tests require access to DDB Table with this name
    public static final String TEST_DDB_TABLE_NAME = "DynamoDbEncryptionInterceptorTestTable";
}
