package software.amazon.cryptography.examples;

import java.time.Duration;

import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class TestUtils {
    public static final String SESSION_NAME = EnvUtils.envOrFail("USER") + "-DB-ESDK-Java";
    public static final String TEST_KEYSTORE_NAME = EnvUtils.envOrDefault("KEYSTORE_TABLE", "KeyStoreDdbTable");
    public static final String TEST_LOGICAL_KEYSTORE_NAME = EnvUtils.envOrDefault("KEYSTORE_TABLE", "KeyStoreDdbTable");
    public static final String TEST_KEYSTORE_KMS_KEY_ID = EnvUtils.envOrDefault("TEST_KEYSTORE_KMS_KEY_ID",
        "arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126");

    public static final String TEST_AWS_ACCOUNT_ID = EnvUtils.envOrDefault(
        "TEST_AWS_ACCOUNT_ID",
        "658956600833");
    public static final String TEST_AWS_REGION = EnvUtils.envOrDefault("TEST_AWS_REGION", "us-west-2");
    // These are public KMS Keys that MUST only be used for testing, and MUST NOT be used for any production data
    public static final String TEST_KMS_KEY_ID = EnvUtils.envOrDefault(
        "TEST_KMS_KEY_ID",
        "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f");
    public static final String TEST_MRK_KEY_ID = EnvUtils.envOrDefault(
        "TEST_MRK_KEY_ID",
        "arn:aws:kms:us-west-2:658956600833:key/mrk-80bd8ecdcd4342aebd84b7dc9da498a7");
    public static final String TEST_KMS_RSA_KEY_ID = EnvUtils.envOrDefault(
        "TEST_KMS_RSA_KEY_ID",
        "arn:aws:kms:us-west-2:658956600833:key/8b432da4-dde4-4bc3-a794-c7d68cbab5a6");
    public static final String TEST_MRK_REPLICA_KEY_ID_US_EAST_1 = EnvUtils.envOrDefault(
        "TEST_MRK_REPLICA_KEY_ID_US_EAST_1",
        "arn:aws:kms:us-east-1:658956600833:key/mrk-80bd8ecdcd4342aebd84b7dc9da498a7");
    public static final String TEST_MRK_REPLICA_KEY_ID_EU_WEST_1 = EnvUtils.envOrDefault(
        "TEST_MRK_REPLICA_KEY_ID_EU_WEST_1",
        "arn:aws:kms:eu-west-1:658956600833:key/mrk-80bd8ecdcd4342aebd84b7dc9da498a7");

    // Our tests require access to DDB Table with this name
    public static final String TEST_DDB_TABLE_NAME = EnvUtils.envOrDefault(
        "TEST_DDB_TABLE_NAME",
        "DynamoDbEncryptionInterceptorTestTable");

    public static final String KEYSTORE_USER_ROLE_ARN = EnvUtils.envOrDefault(
        "KEYSTORE_USER_ROLE_ARN",
        "arn:aws:iam::658956600833:role/CryptographyExample-KeyStoreUser-us-west-2");
    public static final String KEYSTORE_ADMIN_ROLE_ARN = EnvUtils.envOrDefault(
        "KEYSTORE_ADMIN_ROLE_ARN",
        "arn:aws:iam::658956600833:role/CryptographyExample-KeyStoreAdmin-us-west-2");

    public static final AwsCredentialsProvider defaultCreds = DefaultCredentialsProvider.create();
    public static final SdkHttpClient kmsHttpClient = ApacheHttpClient.builder()
        .connectionTimeToLive(Duration.ofSeconds(5)).build();
    public static final SdkHttpClient httpClient = ApacheHttpClient.create();
    public static final DynamoDbClient keystoreAdminDDBClient = DynamoDbClient.builder()
        .httpClient(httpClient)
        .credentialsProvider(CredentialUtils.credsForRole(
            KEYSTORE_ADMIN_ROLE_ARN, SESSION_NAME,
            Region.of(TEST_AWS_REGION), httpClient, TestUtils.defaultCreds))
        .region(Region.of(TEST_AWS_REGION))
        .build();
}
