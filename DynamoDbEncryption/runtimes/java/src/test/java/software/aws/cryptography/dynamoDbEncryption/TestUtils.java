package software.aws.cryptography.dynamoDbEncryption;

import com.amazonaws.services.kms.AWSKMSClientBuilder;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.materialProviders.Keyring;
import software.amazon.cryptography.materialProviders.MaterialProviders;
import software.amazon.cryptography.materialProviders.model.*;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class TestUtils {
    static final String TEST_TABLE_NAME = "DynamoDbEncryptionInterceptorTestTable";
    static final String TEST_PARTITION_NAME = "partition_key";
    static final String TEST_SORT_NAME = "sort_key";
    static final String TEST_ATTR_NAME = "attr1";

    static final String KMS_TEST_KEY_ID = "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f";

    public static Keyring createStaticKeyring() {
        MaterialProviders matProv = MaterialProviders.builder()
                .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                .build();
        ByteBuffer key = ByteBuffer.wrap(new byte[32]);
        CreateRawAesKeyringInput keyringInput = CreateRawAesKeyringInput.builder()
                .keyName("name")
                .keyNamespace("namespace")
                .wrappingAlg(AesWrappingAlg.ALG_AES256_GCM_IV12_TAG16)
                .wrappingKey(key)
                .build();
        return matProv.CreateRawAesKeyring(keyringInput);
    }

    public static Keyring createHierarchyKeyring() {
        MaterialProviders matProv = MaterialProviders.builder()
                .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                .build();
        ByteBuffer key = ByteBuffer.wrap(new byte[32]);
        CreateAwsKmsHierarchyKeyringInput keyringInput = CreateAwsKmsHierarchyKeyringInput.builder()
                .branchKeyId("myBranchKey")
                .branchKeysTableName("HierarchyKeyringBranchKeyTestTable")
                .ddbClient(DynamoDbClient.create())
                .kmsClient(AWSKMSClientBuilder.standard().build())
                .build();
        return matProv.CreateAwsKmsHierarchicalKeyring(keyringInput);
    }

    public static Keyring createKmsKeyring() {
        MaterialProviders matProv = MaterialProviders.builder()
                .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                .build();
        CreateAwsKmsKeyringInput keyringInput = CreateAwsKmsKeyringInput.builder()
                .kmsClient(AWSKMSClientBuilder.standard().build())
                .kmsKeyId(KMS_TEST_KEY_ID)
                .build();
        return matProv.CreateAwsKmsKeyring(keyringInput);
    }

    public static DynamoDbEncryptionInterceptor createInterceptor(Map<String, CryptoAction> actions, Keyring keyring) {
        Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME, DynamoDbTableEncryptionConfig.builder()
                .partitionKeyName(TEST_PARTITION_NAME)
                .sortKeyName(TEST_SORT_NAME)
                .attributeActions(actions)
                .keyring(keyring)
                .build());

        return DynamoDbEncryptionInterceptor.builder()
                .config(DynamoDbEncryptionConfig.builder()
                        .tableEncryptionConfigs(tableConfigs)
                        .build())
                .build();
    }
    public static DynamoDbEncryptionInterceptor createInterceptor(Keyring keyring) {
        Map<String, CryptoAction> actions = new HashMap<>();
        actions.put(TEST_PARTITION_NAME, CryptoAction.ENCRYPT_AND_SIGN);
        actions.put(TEST_SORT_NAME, CryptoAction.SIGN_ONLY);
        actions.put(TEST_ATTR_NAME, CryptoAction.DO_NOTHING);
        return createInterceptor(actions, keyring);
    }

    public static Map<String, AttributeValue> createTestItem(String partition, String sort, String attr) {
        HashMap<String, AttributeValue> item = new HashMap<>();
        item.put(TEST_PARTITION_NAME, AttributeValue.builder().s(partition).build());
        item.put(TEST_SORT_NAME, AttributeValue.builder().n(sort).build());
        item.put(TEST_ATTR_NAME, AttributeValue.builder().s(attr).build());
        return item;
    }

    public static Map<String, AttributeValue> createTestKey(String partition, String sort) {
        HashMap<String, AttributeValue> key = new HashMap<>();
        key.put(TEST_PARTITION_NAME, AttributeValue.builder().s(partition).build());
        key.put(TEST_SORT_NAME, AttributeValue.builder().n(sort).build());
        return key;
    }
}
