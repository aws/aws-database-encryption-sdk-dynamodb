package software.aws.cryptography.dynamoDbEncryption;

import org.junit.jupiter.api.Test;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.dynamoDbEncryption.resources.DynamoDbEncryptionResources;
import software.amazon.cryptography.dynamoDbEncryption.resources.IDynamoDbItemBranchKeyIdSupplier;
import software.amazon.cryptography.dynamoDbEncryption.resources.model.CreateDynamoDbEncryptionBranchKeyIdSupplierInput;
import software.amazon.cryptography.dynamoDbEncryption.resources.model.DynamoDbEncryptionResourcesConfig;
import software.amazon.cryptography.dynamoDbEncryption.resources.model.GetBranchKeyIdFromItemInput;
import software.amazon.cryptography.dynamoDbEncryption.resources.model.GetBranchKeyIdFromItemOutput;
import software.amazon.cryptography.materialProviders.IBranchKeyIdSupplier;
import software.amazon.cryptography.materialProviders.IKeyring;
import software.amazon.cryptography.materialProviders.MaterialProviders;
import software.amazon.cryptography.materialProviders.model.CreateAwsKmsHierarchicalKeyringInput;
import software.amazon.cryptography.materialProviders.model.CreateAwsKmsRsaKeyringInput;
import software.amazon.cryptography.materialProviders.model.MaterialProvidersConfig;

import java.nio.ByteBuffer;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static software.amazon.awssdk.services.kms.model.EncryptionAlgorithmSpec.RSAES_OAEP_SHA_1;
import static software.aws.cryptography.dynamoDbEncryption.TestUtils.createTestItem;
import static software.aws.cryptography.dynamoDbEncryption.TestUtils.createTestKey;
import static software.aws.cryptography.dynamoDbEncryption.TestUtils.createInterceptor;
import static software.aws.cryptography.dynamoDbEncryption.TestUtils.KMS_TEST_KEY_ID;
import static software.aws.cryptography.dynamoDbEncryption.TestUtils.TEST_TABLE_NAME;
import static software.aws.cryptography.dynamoDbEncryption.TestUtils.TEST_ATTR_NAME;
import static software.aws.cryptography.dynamoDbEncryption.TestUtils.TEST_PARTITION_NAME;
import static software.aws.cryptography.dynamoDbEncryption.TestUtils.TEST_SORT_NAME;

// Here we are testing some manually generated interfaces that don't technically belong to this package,
// but exist alongside this package as a deliverable, and it is easiest to test them here for now.
// TODO these should be moved appropriately when they are properly being generated.
public class OtherTests {
  // These tests require a keystore populated with a key with this Id
  public static final String BRANCH_KEY_ID = "hierarchy-test-v1";
  public static final String ACTIVE_ACTIVE_BRANCH_KEY_ID = "hierarchy-test-active-active";
  public static final String keyArn = "arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126";
  public static final String branchKeyStoreArn = "arn:aws:dynamodb:us-west-2:370957321024:table/HierarchicalKeyringTestTable";

  /*
    @Test
    public void TestCreateBranchKeyStore() {
        MaterialProviders materialProviders = MaterialProviders.builder()
                .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                .build();

        CreateBranchKeyStoreOutput out = materialProviders.CreateBranchKeyStore(
                CreateBranchKeyStoreInput.builder()
                        .tableName("my-branch-keys")
                        .ddbClient(DynamoDbClient.builder().build())
                        .build()
        );
        TableDescription desc = out.tableDescription();
        assertNotNull(desc);
    }

    @Test
    public void TestCreateBranchKey() {
        MaterialProviders materialProviders = MaterialProviders.builder()
                .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                .build();

        CreateBranchKeyOutput out = materialProviders.CreateBranchKey(
                CreateBranchKeyInput.builder()
                        .tableName("my-branch-keys")
                        .kmsKeyId("<regional-kms-key-id>")
                        .kmsClient(KmsClient.create())
                        .ddbClient(DynamoDbClient.builder().build())
                        .build()
        );

        assertEquals("a89b547a-7062-4048-b455-d850e32ef808", out.branchKeyId());
    }

    @Test
    public void TestVersionBranchKey() {
        MaterialProviders materialProviders = MaterialProviders.builder()
                .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                .build();

        VersionBranchKeyOutput out = materialProviders.VersionBranchKey(
                VersionBranchKeyInput.builder()
                        .tableName("my-branch-keys")
                        .branchKeyId("a89b547a-7062-4048-b455-d850e32ef808")
                        .kmsKeyId("<regional-kms-key-id>")
                        .kmsClient(KmsClient.builder().build())
                        .ddbClient(DynamoDbClient.builder().build())
                        .build()
        );

        assertEquals(1, out.versionCreated());
    }
   */

    @Test
    public void TestBuildHierarchyKeyringInvalidConfig() {
        DynamoDbEncryptionResources ddbEncResources = DynamoDbEncryptionResources.builder()
                .DynamoDbEncryptionResourcesConfig(DynamoDbEncryptionResourcesConfig.builder().build())
                .build();
        IBranchKeyIdSupplier branchKeyIdSupplier = ddbEncResources.CreateDynamoDbEncryptionBranchKeyIdSupplier(
                CreateDynamoDbEncryptionBranchKeyIdSupplierInput.builder()
                        .ddbItemBranchKeyIdSupplier(new TestSupplier())
                        .build())
                .branchKeyIdSupplier();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CreateAwsKmsHierarchicalKeyringInput.builder()
                    .kmsClient(KmsClient.create())
                    .kmsKeyId(KMS_TEST_KEY_ID)
                    .branchKeyId("foo")
                    .branchKeyIdSupplier(branchKeyIdSupplier)
                    .branchKeyStoreArn("branch-keys-table")
                    .ddbClient(DynamoDbClient.create())
                    .ttlSeconds(6000l)
                    .maxCacheSize(100)
                    .build();
        });
        assertTrue(exception.getMessage().contains("`branchKeyId` or `branchKeyIdSupplier` cannot both be configured."));

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            CreateAwsKmsHierarchicalKeyringInput.builder()
                    .kmsClient(KmsClient.create())
                    .kmsKeyId(KMS_TEST_KEY_ID)
                    .branchKeyStoreArn("branch-keys-table")
                    .ddbClient(DynamoDbClient.create())
                    .ttlSeconds(6000l)
                    .maxCacheSize(100)
                    .build();
        });
        assertTrue(exception2.getMessage().contains("`branchKeyId` or `branchKeyIdSupplier` must be configured."));
    }

    @Test
    public void TestHierarchyKeyringWithSupplier() {
        MaterialProviders matProv = MaterialProviders.builder()
                .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                .build();
        DynamoDbEncryptionResources ddbEncResources = DynamoDbEncryptionResources.builder()
                .DynamoDbEncryptionResourcesConfig(DynamoDbEncryptionResourcesConfig.builder().build())
                .build();
        IBranchKeyIdSupplier branchKeyIdSupplier = ddbEncResources.CreateDynamoDbEncryptionBranchKeyIdSupplier(
                        CreateDynamoDbEncryptionBranchKeyIdSupplierInput.builder()
                                .ddbItemBranchKeyIdSupplier(new TestSupplier())
                                .build())
                .branchKeyIdSupplier();

        CreateAwsKmsHierarchicalKeyringInput keyringInput = CreateAwsKmsHierarchicalKeyringInput.builder()
                .kmsClient(KmsClient.create())
                .kmsKeyId(keyArn)
                .branchKeyIdSupplier(branchKeyIdSupplier)
                .branchKeyStoreArn(branchKeyStoreArn)
                .ddbClient(DynamoDbClient.create())
                .ttlSeconds(6000l)
                .maxCacheSize(100)
                .build();
        IKeyring keyring = matProv.CreateAwsKmsHierarchicalKeyring(keyringInput);
        assertNotNull(keyring);

        // Put CaseA item
        // Put item into table
        String partitionValue = "caseA";
        String sortValue = "42";
        String attrValue = "bar";
        String attrValue2 = "hello world";
        Map<String, AttributeValue> item = createTestItem(partitionValue, sortValue, attrValue, attrValue2);

        PutItemRequest putRequest = PutItemRequest.builder()
                .tableName(TEST_TABLE_NAME)
                .item(item)
                .build();

        DynamoDbEncryptionInterceptor interceptor = TestUtils.createInterceptor(keyring);
        DynamoDbClient ddb = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptor)
                                .build())
                .build();

        PutItemResponse putResponse = ddb.putItem(putRequest);
        assertEquals(200, putResponse.sdkHttpResponse().statusCode());

        // Get Item back from table
        Map<String, AttributeValue> keyToGet = createTestKey(partitionValue, sortValue);

        GetItemRequest getRequest = GetItemRequest.builder()
                .key(keyToGet)
                .tableName(TEST_TABLE_NAME)
                .build();

        GetItemResponse getResponse = ddb.getItem(getRequest);
        assertEquals(200, getResponse.sdkHttpResponse().statusCode());
        Map<String, AttributeValue> returnedItem = getResponse.item();
        assertNotNull(returnedItem);
        assertEquals(partitionValue, returnedItem.get(TEST_PARTITION_NAME).s());
        assertEquals(sortValue, returnedItem.get(TEST_SORT_NAME).n());
        assertEquals(attrValue, returnedItem.get(TEST_ATTR_NAME).s());

        // Assert we can retrieve this item with a Hierarchical keyring configured with expected branch key id
        CreateAwsKmsHierarchicalKeyringInput keyringAInput = CreateAwsKmsHierarchicalKeyringInput.builder()
                .kmsClient(KmsClient.create())
                .kmsKeyId(keyArn)
                .branchKeyId(BRANCH_KEY_ID)
                .branchKeyStoreArn(branchKeyStoreArn)
                .ddbClient(DynamoDbClient.create())
                .ttlSeconds(6000l)
                .maxCacheSize(100)
                .build();
        IKeyring keyringA = matProv.CreateAwsKmsHierarchicalKeyring(keyringAInput);
        assertNotNull(keyringA);
        DynamoDbEncryptionInterceptor interceptorA = TestUtils.createInterceptor(keyringA);
        DynamoDbClient ddbA = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptorA)
                                .build())
                .build();

        GetItemResponse getResponseA = ddbA.getItem(getRequest);
        assertEquals(200, getResponseA.sdkHttpResponse().statusCode());
        Map<String, AttributeValue> returnedItemA = getResponseA.item();
        assertNotNull(returnedItemA);
        assertEquals(partitionValue, returnedItemA.get(TEST_PARTITION_NAME).s());
        assertEquals(sortValue, returnedItemA.get(TEST_SORT_NAME).n());
        assertEquals(attrValue, returnedItemA.get(TEST_ATTR_NAME).s());

        // Put CaseB item
        // Put item into table
        partitionValue = "caseB";
        sortValue = "42";
        attrValue = "bar";
        attrValue2 = "hello world";
        Map<String, AttributeValue> itemB = createTestItem(partitionValue, sortValue, attrValue, attrValue2);

        PutItemRequest putRequest2 = PutItemRequest.builder()
                .tableName(TEST_TABLE_NAME)
                .item(itemB)
                .build();

        PutItemResponse putResponse2 = ddb.putItem(putRequest2);
        assertEquals(200, putResponse2.sdkHttpResponse().statusCode());

        // Get Item back from table
        Map<String, AttributeValue> keyToGet2 = createTestKey(partitionValue, sortValue);

        GetItemRequest getRequest2 = GetItemRequest.builder()
                .key(keyToGet2)
                .tableName(TEST_TABLE_NAME)
                .build();

        GetItemResponse getResponse2 = ddb.getItem(getRequest2);
        assertEquals(200, getResponse2.sdkHttpResponse().statusCode());
        Map<String, AttributeValue> returnedItem2 = getResponse2.item();
        assertNotNull(returnedItem2);
        assertEquals(partitionValue, returnedItem2.get(TEST_PARTITION_NAME).s());
        assertEquals(sortValue, returnedItem2.get(TEST_SORT_NAME).n());
        assertEquals(attrValue, returnedItem2.get(TEST_ATTR_NAME).s());

        // Assert we can get the same item using a hierachical keyring with specified branch key id
        CreateAwsKmsHierarchicalKeyringInput keyringBInput = CreateAwsKmsHierarchicalKeyringInput.builder()
                .kmsClient(KmsClient.create())
                .kmsKeyId(keyArn)
                .branchKeyId(ACTIVE_ACTIVE_BRANCH_KEY_ID)
                .branchKeyStoreArn(branchKeyStoreArn)
                .ddbClient(DynamoDbClient.create())
                .ttlSeconds(6000l)
                .maxCacheSize(100)
                .build();
        IKeyring keyringB = matProv.CreateAwsKmsHierarchicalKeyring(keyringBInput);
        assertNotNull(keyringB);
        DynamoDbEncryptionInterceptor interceptorB = TestUtils.createInterceptor(keyringB);
        DynamoDbClient ddbB = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptorB)
                                .build())
                .build();
        GetItemResponse getResponseB = ddbB.getItem(getRequest);
        assertEquals(200, getResponseB.sdkHttpResponse().statusCode());
        Map<String, AttributeValue> returnedItemB = getResponseB.item();
        assertNotNull(returnedItemB);
        assertEquals(partitionValue, returnedItemB.get(TEST_PARTITION_NAME).s());
        assertEquals(sortValue, returnedItemB.get(TEST_SORT_NAME).n());
        assertEquals(attrValue, returnedItemB.get(TEST_ATTR_NAME).s());
    }

    @Test
    public void TestBuildEncryptDecryptAwsKmsRsaKeyring() {
        MaterialProviders matProv = MaterialProviders.builder()
                .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                .build();

        ByteBuffer key = ByteBuffer.wrap(new byte[32]);

        CreateAwsKmsRsaKeyringInput input = CreateAwsKmsRsaKeyringInput.builder()
                .kmsClient(KmsClient.create())
                .kmsKeyId(KMS_TEST_KEY_ID)
                .encryptionAlgorithm(RSAES_OAEP_SHA_1)
                .publicKey(key)
                .build();
        IKeyring keyring = matProv.CreateAwsKmsRsaKeyring(input);
        assertNotNull(keyring);
    }

    class TestSupplier implements IDynamoDbItemBranchKeyIdSupplier {
        public GetBranchKeyIdFromItemOutput GetBranchKeyIdFromItem(GetBranchKeyIdFromItemInput input) {
            Map<String, AttributeValue> item = input.ddbItem();
            String branchKeyId;
            if (item.containsKey(TEST_PARTITION_NAME) && item.get(TEST_PARTITION_NAME).s().equals("caseA")) {
                branchKeyId = BRANCH_KEY_ID;
            } else if (item.containsKey(TEST_PARTITION_NAME) && item.get(TEST_PARTITION_NAME).s().equals("caseB")) {
                branchKeyId = ACTIVE_ACTIVE_BRANCH_KEY_ID;
            } else {
                throw new IllegalArgumentException("Item invalid, does not contain expected attributes.");
            }
            return GetBranchKeyIdFromItemOutput.builder().branchKeyId(branchKeyId).build();
        }
    }
}
