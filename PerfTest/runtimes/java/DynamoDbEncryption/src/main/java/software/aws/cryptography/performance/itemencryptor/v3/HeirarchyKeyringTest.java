package software.aws.cryptography.performance.itemencryptor.v3;

import com.fasterxml.jackson.databind.ObjectMapper;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.ReturnValue;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.dynamoDbEncryption.DynamoDbEncryption;
import software.amazon.cryptography.dynamoDbEncryption.model.CreateDynamoDbEncryptionBranchKeyIdSupplierInput;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.GetBranchKeyIdFromDdbKeyOutput;
import software.amazon.cryptography.keyStore.KeyStore;
import software.amazon.cryptography.keyStore.model.CreateKeyStoreInput;
import software.amazon.cryptography.keyStore.model.KeyStoreConfig;
import software.amazon.cryptography.materialProviders.IBranchKeyIdSupplier;
import software.amazon.cryptography.materialProviders.IKeyring;
import software.amazon.cryptography.materialProviders.MaterialProviders;
import software.amazon.cryptography.materialProviders.model.CreateAwsKmsHierarchicalKeyringInput;
import software.amazon.cryptography.materialProviders.model.MaterialProvidersConfig;
import software.aws.cryptography.dynamoDbEncryption.DynamoDbEncryptionInterceptor;

import java.util.HashMap;
import java.util.Map;

import static software.aws.cryptography.performance.itemencryptor.TestConstants.DATA_TO_ENCRYPT;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.KMS_KEY_ARN;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.PARTITION_ATTRIBUTE;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.SORT_ATTRIBUTE;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.SORT_NUMBER;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.TEST_PK;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.UNAUTH_PREFIX;

public class HeirarchyKeyringTest extends TestBase {
    private static final String TEST_KEYSTORE_NAME = "KeyStoreTestTable";
    private static final String TEST_DDB_TABLE_NAME = "DynamoDbEncryptionInterceptorTestTable";

    private DynamoDbEncryption ddbEnc;
    private DynamoDbClient ddb;

    public HeirarchyKeyringTest() {
    }

    HeirarchyKeyringTest(final String plainTextFile) {
        this.plainTextFile = plainTextFile;
    }
    @Override
    protected IKeyring createKeyring() {
        final KmsClient kmsClient = KmsClient.create();
        final DynamoDbClient dynamoDbClient = DynamoDbClient.create();

        final KeyStoreConfig keyStoreConfig = KeyStoreConfig.builder()
                                                            .ddbTableName(TEST_KEYSTORE_NAME)
                                                            .kmsKeyArn(KMS_KEY_ARN)
                                                            .kmsClient(kmsClient)
                                                            .ddbClient(dynamoDbClient)
                                                            .build();
        final KeyStore keystore = KeyStore.builder().KeyStoreConfig(
                keyStoreConfig).build();

        keystore.CreateKeyStore(CreateKeyStoreInput.builder().build());

        final String tenant1BranchKey = keystore.CreateKey().branchKeyIdentifier();
        final String tenant2BranchKey = keystore.CreateKey().branchKeyIdentifier();

        ddbEnc = DynamoDbEncryption.builder()
                                                            .DynamoDbEncryptionConfig(DynamoDbEncryptionConfig.builder().build()).build();

        final IBranchKeyIdSupplier branchKeyIdSupplier = ddbEnc.CreateDynamoDbEncryptionBranchKeyIdSupplier(
                CreateDynamoDbEncryptionBranchKeyIdSupplierInput.builder()
                                                                .ddbKeyBranchKeyIdSupplier((getBranchKeyIdFromDdbKeyInput) -> {
                                                                    String tenantKeyId = getBranchKeyIdFromDdbKeyInput.ddbKey().get(PARTITION_ATTRIBUTE).s();
                                                                    if (tenantKeyId.equals(TEST_PK)) {
                                                                        return GetBranchKeyIdFromDdbKeyOutput.builder().branchKeyId(tenant1BranchKey).build();
                                                                    }
                                                                    return GetBranchKeyIdFromDdbKeyOutput.builder().branchKeyId(tenant2BranchKey).build();
                                                                })
                                                                .build())
                                                               .branchKeyIdSupplier();


        CreateAwsKmsHierarchicalKeyringInput keyringInput = CreateAwsKmsHierarchicalKeyringInput.builder()
                                                                                                .maxCacheSize(10)
                                                                                                .keyStore(keystore)
                                                                    .branchKeyIdSupplier(branchKeyIdSupplier).ttlSeconds(60)
                                                                                                .maxCacheSize(100)
                                                                                                .build();
        MaterialProviders matProv = MaterialProviders.builder().MaterialProvidersConfig(MaterialProvidersConfig.builder().build()).build();
        return matProv.CreateAwsKmsHierarchicalKeyring(keyringInput);
    }

    @Override
    public void setup() throws Exception {
        final Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
        final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig.builder()
                                                                                  .logicalTableName(TEST_DDB_TABLE_NAME)
                                                                                  .partitionKeyName(PARTITION_ATTRIBUTE)
                                                                                  .sortKeyName(SORT_ATTRIBUTE)
                                                                                  .attributeActions(getAttributeActions())
                                                                                  .keyring(createKeyring())
                                                                                  .allowedUnauthenticatedAttributePrefix(UNAUTH_PREFIX)
                                                                                  .build();
        tableConfigs.put(TEST_DDB_TABLE_NAME, config);

        DynamoDbEncryptionInterceptor encryptionInterceptor = DynamoDbEncryptionInterceptor.builder()
                                                                                           .config(DynamoDbTablesEncryptionConfig.builder()
                                                                                                                                 .tableEncryptionConfigs(tableConfigs)
                                                                                                                                 .build())
                                                                                           .build();

        ClientOverrideConfiguration clientOverrideConfiguration = ClientOverrideConfiguration.builder()
                                                                                             .addExecutionInterceptor(encryptionInterceptor)
                                                                                             .build();
       ddb = DynamoDbClient.builder()
                           .overrideConfiguration(clientOverrideConfiguration)
                           .build();
        plainTextJson = new ObjectMapper().readTree(getClass().getClassLoader().getResourceAsStream(plainTextFile));
        encryptedAttributes = encrypt();

    }

    @Override
    public Map<String, AttributeValue> encrypt() {
        final HashMap<String, AttributeValue> item = new HashMap<>();
        item.put(PARTITION_ATTRIBUTE, AttributeValue.builder().s(TEST_PK).build());
        item.put(SORT_ATTRIBUTE, AttributeValue.builder().n(SORT_NUMBER).build());
        item.put(DATA_TO_ENCRYPT, AttributeValue.builder().s(plainTextJson.get(DATA_TO_ENCRYPT).asText()).build());
        itemBeforeEncrypt = item;
        final PutItemRequest putRequest = PutItemRequest.builder()
                                                        .tableName(TEST_DDB_TABLE_NAME)
                                                        .item(item)
                                                        .returnValues(ReturnValue.ALL_OLD)
                                                        .build();

        encryptedAttributes = ddb.putItem(putRequest).attributes();
        return encryptedAttributes;
    }


    @Override
    public Map<String, AttributeValue> decrypt() {
        final HashMap<String, AttributeValue> keyToGet = new HashMap<>();
        keyToGet.put(PARTITION_ATTRIBUTE, AttributeValue.builder().s(TEST_PK).build());
        keyToGet.put(SORT_ATTRIBUTE, AttributeValue.builder().n("0").build());

        final GetItemRequest getRequest = GetItemRequest.builder()
                                                        .key(keyToGet)
                                                        .tableName(TEST_DDB_TABLE_NAME)
                                                        .build();

        final GetItemResponse getResponse = ddb.getItem(getRequest);
        return getResponse.item();
    }

    /**
     * main Method to execute tests without JMH. This is helpful in profiling in IDEs (especially IntelliJ) which fails
     * to profile JMH annotated runs.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        TestBase testBase = new HeirarchyKeyringTest("single_attribute.json");
        testBase.setup();
        testBase.decrypt();

    }
}
