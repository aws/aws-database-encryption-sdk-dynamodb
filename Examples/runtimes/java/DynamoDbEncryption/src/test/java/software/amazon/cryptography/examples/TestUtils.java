package software.amazon.cryptography.examples;

public class TestUtils {

  public static final String TEST_KEYSTORE_NAME = "KeyStoreDdbTable";
  public static final String TEST_LOGICAL_KEYSTORE_NAME = "KeyStoreDdbTable";
  public static final String TEST_KEYSTORE_KMS_KEY_ID =
    "arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126";

  public static final String TEST_AWS_ACCOUNT_ID = "658956600833";
  public static final String TEST_AWS_REGION = "us-west-2";
  // These are public KMS Keys that MUST only be used for testing, and MUST NOT be used for any production data
  public static final String TEST_KMS_KEY_ID =
    "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f";
  public static final String TEST_MRK_KEY_ID =
    "arn:aws:kms:us-west-2:658956600833:key/mrk-80bd8ecdcd4342aebd84b7dc9da498a7";
  public static final String TEST_KMS_RSA_KEY_ID =
    "arn:aws:kms:us-west-2:658956600833:key/8b432da4-dde4-4bc3-a794-c7d68cbab5a6";
  public static final String TEST_MRK_REPLICA_KEY_ID_US_EAST_1 =
    "arn:aws:kms:us-east-1:658956600833:key/mrk-80bd8ecdcd4342aebd84b7dc9da498a7";
  public static final String TEST_MRK_REPLICA_KEY_ID_EU_WEST_1 =
    "arn:aws:kms:eu-west-1:658956600833:key/mrk-80bd8ecdcd4342aebd84b7dc9da498a7";
  public static final String TEST_KMS_ECDH_KEY_ID_P256_SENDER =
    "arn:aws:kms:us-west-2:370957321024:key/eabdf483-6be2-4d2d-8ee4-8c2583d416e9";
  public static final String TEST_KMS_ECDH_KEY_ID_P256_RECIPIENT =
    "arn:aws:kms:us-west-2:370957321024:key/0265c8e9-5b6a-4055-8f70-63719e09fda5";

  // Our tests require access to DDB Table with this name
  public static final String TEST_DDB_TABLE_NAME =
    "DynamoDbEncryptionInterceptorTestTable";
}
