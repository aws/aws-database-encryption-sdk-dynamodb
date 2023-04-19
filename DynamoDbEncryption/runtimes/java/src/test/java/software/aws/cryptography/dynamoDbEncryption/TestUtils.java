package software.aws.cryptography.dynamoDbEncryption;

import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionFlags;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.DirectKmsMaterialProvider;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dynamoDbEncryption.model.*;
import software.amazon.cryptography.keyStore.KeyStore;
import software.amazon.cryptography.keyStore.model.KeyStoreConfig;
import software.amazon.cryptography.materialProviders.IBranchKeyIdSupplier;
import software.amazon.cryptography.materialProviders.IKeyring;
import software.amazon.cryptography.materialProviders.MaterialProviders;
import software.amazon.cryptography.materialProviders.model.*;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;

import java.nio.ByteBuffer;
import java.util.*;

public class TestUtils {
    public static final String TEST_TABLE_NAME = "DynamoDbEncryptionInterceptorTestTable";
    public static final String TEST_PARTITION_NAME = "partition_key";
    public static final String TEST_SORT_NAME = "sort_key";
    public static final String TEST_ATTR_NAME = "attr1";
    public static final String TEST_ATTR2_NAME = "attr2";

    public static final String TEST_KEY_STORE_NAME = "KeyStoreTestTable";
    public static final String TEST_KEY_STORE_KMS_KEY = "arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126";
    public static final String BRANCH_KEY_ID = "ef31c535-7436-406e-be37-371aea99b298";
    public static final String ACTIVE_ACTIVE_BRANCH_KEY_ID = "7039dc82-03ff-4914-988e-681c09180a2d";

    public static final String KMS_TEST_KEY_ID = "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f";

    public static KeyStore createKeyStore() {
        return KeyStore.builder().KeyStoreConfig(
                KeyStoreConfig.builder()
                        .ddbClient(DynamoDbClient.create())
                        .ddbTableName(TEST_KEY_STORE_NAME)
                        .kmsClient(KmsClient.create())
                        .build()
        ).build();
    }

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

    public static IKeyring createKmsKeyring(String kmsKeyId) {
        MaterialProviders matProv = MaterialProviders.builder()
                .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                .build();
        CreateAwsKmsKeyringInput keyringInput = CreateAwsKmsKeyringInput.builder()
                .kmsKeyId(kmsKeyId)
                .kmsClient(KmsClient.create())
                .build();
        return matProv.CreateAwsKmsKeyring(keyringInput);
    }

    public static IKeyring createKmsKeyring() {
        return createKmsKeyring(KMS_TEST_KEY_ID);
    }

    public static IKeyring createHierarchicalKeyring(KeyStore keystore, String branchKeyId) {
        return createHierarchicalKeyring(keystore, branchKeyId, null);
    }

    public static IKeyring createHierarchicalKeyring(KeyStore keystore, IBranchKeyIdSupplier supplier) {
        return createHierarchicalKeyring(keystore, null, supplier);
    }

    public static IKeyring createHierarchicalKeyring(KeyStore keystore, String branchKeyId, IBranchKeyIdSupplier keyIdSupplier) {
        MaterialProviders matProv = MaterialProviders.builder()
                .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                .build();
        CreateAwsKmsHierarchicalKeyringInput.Builder keyringInputBuilder = CreateAwsKmsHierarchicalKeyringInput.builder()
                .keyStore(keystore)
                .ttlSeconds(600)
                .maxCacheSize(100);
        if (branchKeyId != null) {
            keyringInputBuilder = keyringInputBuilder.branchKeyId(branchKeyId);
        }
        if (keyIdSupplier != null) {
            keyringInputBuilder = keyringInputBuilder.branchKeyIdSupplier(keyIdSupplier);
        }
        return matProv.CreateAwsKmsHierarchicalKeyring(keyringInputBuilder.build());
    }

    public static DynamoDbEncryptionInterceptor createInterceptor(
            Map<String, CryptoAction> actions, List<String> allowedUnauth, IKeyring keyring, LegacyPolicy legacyPolicy, PlaintextPolicy ptPolicy) {
        Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
        DynamoDbTableEncryptionConfig.Builder builder = DynamoDbTableEncryptionConfig.builder()
                .partitionKeyName(TEST_PARTITION_NAME)
                .sortKeyName(TEST_SORT_NAME)
                .attributeActions(actions)
                .algorithmSuiteId(DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384)
                .keyring(keyring);
        if (!allowedUnauth.isEmpty()) {
            builder = builder.allowedUnauthenticatedAttributes(allowedUnauth);
        }
        if (null != legacyPolicy) {
            builder = builder.legacyConfig(createLegacyConfig(legacyPolicy));
        }
        if (null != ptPolicy) {
            builder = builder.plaintextPolicy(ptPolicy);
        }
        tableConfigs.put(TEST_TABLE_NAME, builder.build());

        return DynamoDbEncryptionInterceptor.builder()
                .config(DynamoDbTablesEncryptionConfig.builder()
                        .tableEncryptionConfigs(tableConfigs)
                        .build())
                .build();
    }

    public static DynamoDbEncryptionInterceptor createInterceptor(IKeyring keyring, LegacyPolicy legacyPolicy, PlaintextPolicy ptPolicy) {
        Map<String, CryptoAction> actions = new HashMap<>();
        actions.put(TEST_PARTITION_NAME, CryptoAction.SIGN_ONLY);
        actions.put(TEST_SORT_NAME, CryptoAction.SIGN_ONLY);
        actions.put(TEST_ATTR_NAME, CryptoAction.ENCRYPT_AND_SIGN);
        actions.put(TEST_ATTR2_NAME, CryptoAction.DO_NOTHING);
        List<String> allowedUnauth = Arrays.asList(TEST_ATTR2_NAME);
        return createInterceptor(actions, allowedUnauth, keyring, legacyPolicy, ptPolicy);
    }

    public static Map<String, AttributeValue> createTestItem(String partition, String sort, String attr1, String attr2) {
        HashMap<String, AttributeValue> item = new HashMap<>();
        item.put(TEST_PARTITION_NAME, AttributeValue.builder().s(partition).build());
        item.put(TEST_SORT_NAME, AttributeValue.builder().n(sort).build());
        item.put(TEST_ATTR_NAME, AttributeValue.builder().s(attr1).build());
        item.put(TEST_ATTR2_NAME, AttributeValue.builder().s(attr2).build());
        return item;
    }

    public static Map<String, com.amazonaws.services.dynamodbv2.model.AttributeValue> createLegacyTestItem(
            String partition, String sort, String attr1, String attr2) {
        HashMap<String, com.amazonaws.services.dynamodbv2.model.AttributeValue> item = new HashMap<>();
        item.put(TEST_PARTITION_NAME,
                new com.amazonaws.services.dynamodbv2.model.AttributeValue().withS(partition));
        item.put(TEST_SORT_NAME,
                new com.amazonaws.services.dynamodbv2.model.AttributeValue().withN(sort));
        item.put(TEST_ATTR_NAME,
                new com.amazonaws.services.dynamodbv2.model.AttributeValue().withS(attr1));
        item.put(TEST_ATTR2_NAME,
                new com.amazonaws.services.dynamodbv2.model.AttributeValue().withS(attr2));
        return item;
    }

    public static Map<String, AttributeValue> createTestKey(String partition, String sort) {
        HashMap<String, AttributeValue> key = new HashMap<>();
        key.put(TEST_PARTITION_NAME, AttributeValue.builder().s(partition).build());
        key.put(TEST_SORT_NAME, AttributeValue.builder().n(sort).build());
        return key;
    }

    public static LegacyConfig createLegacyConfig(LegacyPolicy policy) {
        DynamoDBEncryptor legacyEncryptor = createLegacyEncryptor();

        // These do not have to match the schema for non-Legacy items,
        // but MUST match what createLegacyEncryptor returns for testing
        Map<String, CryptoAction> legacyActions = new HashMap<>();
        legacyActions.put(TEST_PARTITION_NAME, CryptoAction.SIGN_ONLY);
        legacyActions.put(TEST_SORT_NAME, CryptoAction.SIGN_ONLY);
        legacyActions.put(TEST_ATTR_NAME, CryptoAction.ENCRYPT_AND_SIGN);
        legacyActions.put(TEST_ATTR2_NAME, CryptoAction.DO_NOTHING);
        return LegacyConfig
            .builder()
            .encryptor(legacyEncryptor)
            .policy(policy)
            .attributeFlags(legacyActions)
            .build();
    }

    public static DynamoDBEncryptor createLegacyEncryptor() {
        AWSKMS kms = AWSKMSClientBuilder.standard().build();
        DirectKmsMaterialProvider cmp = new DirectKmsMaterialProvider(kms, KMS_TEST_KEY_ID);
        return DynamoDBEncryptor.getInstance(cmp);
    }

    public static Map<String, Set<EncryptionFlags>> createLegacyAttributeFlags() {
        // test item values don't matter, we just need the right keys
        Map<String, AttributeValue> item = createTestItem("foo", "fi","fo", "fum");
        EnumSet<EncryptionFlags> signOnly = EnumSet.of(EncryptionFlags.SIGN);
        EnumSet<EncryptionFlags> encryptAndSign =
                EnumSet.of(EncryptionFlags.ENCRYPT, EncryptionFlags.SIGN);
        Map<String, Set<EncryptionFlags>> actions = new HashMap<>();
        for (final String attributeName : item.keySet()) {
            switch (attributeName) {
                case TEST_PARTITION_NAME: // fall through
                case TEST_SORT_NAME:
                    actions.put(attributeName, signOnly);
                    break;
                case TEST_ATTR2_NAME:
                    break;
                default:
                    actions.put(attributeName, encryptAndSign);
                    break;
            }
        }
        return actions;
    }
}
