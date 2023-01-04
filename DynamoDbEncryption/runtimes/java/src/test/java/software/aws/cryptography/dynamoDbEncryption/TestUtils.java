package software.aws.cryptography.dynamoDbEncryption;

import com.amazonaws.services.kms.AWSKMSClientBuilder;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.materialProviders.IKeyring;
import software.amazon.cryptography.materialProviders.MaterialProviders;
import software.amazon.cryptography.materialProviders.model.*;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUtils {
    public static final String TEST_TABLE_NAME = "DynamoDbEncryptionInterceptorTestTable";
    public static final String ENHANCED_CLIENT_TEST_TABLE_NAME = "DynamoDbEncryptionEnhancedClientTestTable";
    public static final String TEST_PARTITION_NAME = "partition_key";
    public static final String TEST_SORT_NAME = "sort_key";
    public static final String TEST_ATTR_NAME = "attr1";
    public static final String TEST_ATTR2_NAME = "attr2";

    public static final String KMS_TEST_KEY_ID = "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f";

    public static IKeyring createStaticKeyring() {
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

    public static IKeyring createKmsKeyring() {
        MaterialProviders matProv = MaterialProviders.builder()
                .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                .build();
        CreateAwsKmsKeyringInput keyringInput = CreateAwsKmsKeyringInput.builder()
                .kmsClient(AWSKMSClientBuilder.standard().build())
                .kmsKeyId(KMS_TEST_KEY_ID)
                .build();
        return matProv.CreateAwsKmsKeyring(keyringInput);
    }

    public static DynamoDbEncryptionInterceptor createInterceptor(Map<String, CryptoAction> actions, List<String> allowedUnauth, IKeyring keyring) {
        Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
        DynamoDbTableEncryptionConfig.Builder builder = DynamoDbTableEncryptionConfig.builder()
                .partitionKeyName(TEST_PARTITION_NAME)
                .sortKeyName(TEST_SORT_NAME)
                .attributeActions(actions)
                .keyring(keyring);
        if (!allowedUnauth.isEmpty()) {
            builder = builder.allowedUnauthenticatedAttributes(allowedUnauth);
        }
        tableConfigs.put(TEST_TABLE_NAME, builder.build());

        return DynamoDbEncryptionInterceptor.builder()
                .config(DynamoDbEncryptionConfig.builder()
                        .tableEncryptionConfigs(tableConfigs)
                        .build())
                .build();
    }
    public static DynamoDbEncryptionInterceptor createInterceptor(IKeyring keyring) {
        Map<String, CryptoAction> actions = new HashMap<>();
        actions.put(TEST_PARTITION_NAME, CryptoAction.SIGN_ONLY);
        actions.put(TEST_SORT_NAME, CryptoAction.SIGN_ONLY);
        actions.put(TEST_ATTR_NAME, CryptoAction.ENCRYPT_AND_SIGN);
        actions.put(TEST_ATTR2_NAME, CryptoAction.DO_NOTHING);
        List<String> allowedUnauth = Arrays.asList(TEST_ATTR2_NAME);
        return createInterceptor(actions, allowedUnauth, keyring);
    }

    public static Map<String, AttributeValue> createTestItem(String partition, String sort, String attr1, String attr2) {
        HashMap<String, AttributeValue> item = new HashMap<>();
        item.put(TEST_PARTITION_NAME, AttributeValue.builder().s(partition).build());
        item.put(TEST_SORT_NAME, AttributeValue.builder().n(sort).build());
        item.put(TEST_ATTR_NAME, AttributeValue.builder().s(attr1).build());
        item.put(TEST_ATTR2_NAME, AttributeValue.builder().s(attr2).build());
        return item;
    }

    public static Map<String, AttributeValue> createTestKey(String partition, String sort) {
        HashMap<String, AttributeValue> key = new HashMap<>();
        key.put(TEST_PARTITION_NAME, AttributeValue.builder().s(partition).build());
        key.put(TEST_SORT_NAME, AttributeValue.builder().n(sort).build());
        return key;
    }
}
