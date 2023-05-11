package software.aws.cryptography.performance.itemencryptor;

public class TestConstants {
    public static final String PARTITION_ATTRIBUTE = "partition_key";
    public static final String SORT_ATTRIBUTE = "sort_key";
    public static final String DATA_TO_ENCRYPT = "data_to_encrypt";
    public static final String DATA_TO_SIGN = "data_to_sign";
    public static final String DATA_TO_IGNORE = ":data_to_ignore";
    public static final String TEST_TABLE = "Test_Table";
    public static final String TEST_PK = "Test_pk";
    public static final String SORT_NUMBER = "10";
    public static final String UNAUTH_PREFIX = ":";
    public static final String KMS_KEY_ARN = "arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126";
    public static final String KEY_NAMESPACE = "Key_Namespace";
    public static final String KEY_NAME = "Key_Name";

    public static final String SIZE_RESULTS_FILE = "build/results/size.txt";

}
