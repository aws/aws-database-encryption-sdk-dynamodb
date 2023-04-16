package software.aws.cryptography.dynamoDbEncryption;

import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.dynamoDbEncryption.DynamoDbEncryption;
import software.amazon.cryptography.dynamoDbEncryption.IDynamoDbKeyBranchKeyIdSupplier;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dynamoDbEncryption.model.CreateDynamoDbEncryptionBranchKeyIdSupplierInput;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.GetBranchKeyIdFromDdbKeyInput;
import software.amazon.cryptography.dynamoDbEncryption.model.GetBranchKeyIdFromDdbKeyOutput;
import software.amazon.cryptography.dynamoDbEncryption.transforms.model.OpaqueError;
import software.amazon.cryptography.materialProviders.IBranchKeyIdSupplier;
import software.amazon.cryptography.materialProviders.IKeyring;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.materialProviders.MaterialProviders;
import software.amazon.cryptography.materialProviders.model.*;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;
import static software.amazon.awssdk.services.kms.model.EncryptionAlgorithmSpec.RSAES_OAEP_SHA_1;
import static software.aws.cryptography.dynamoDbEncryption.TestUtils.*;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

// Here we are testing some manually generated interfaces that don't technically belong to this package,
// but exist alongside this package as a deliverable, and it is easiest to test them here for now.
// TODO these should be moved appropriately when they are properly being generated.
public class OtherTests {
  // These tests require a keystore populated with a key with this Id
    @Test
    public void TestItemEncryptorBuild() {
        Map<String, CryptoAction> actions = new HashMap<>();
        actions.put("foo", CryptoAction.SIGN_ONLY);
        actions.put("bar", CryptoAction.SIGN_ONLY);

        DynamoDbItemEncryptor itemEncryptor = DynamoDbItemEncryptor.builder()
                .DynamoDbItemEncryptorConfig(
                        DynamoDbItemEncryptorConfig.builder()
                                .algorithmSuiteId(DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384)
                                .sortKeyName("foo")
                                .partitionKeyName("bar")
                                .tableName("test-table")
                                .attributeActions(actions)
                                .keyring(createStaticKeyring())
                                // TODO try configuring a LegacyConfig
                                .build()
                ).build();

        assertNotNull(itemEncryptor);
    }

    @Test
    public void TestHierarchyKeyringWithSupplier() {
        MaterialProviders matProv = MaterialProviders.builder()
                .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                .build();

        // Create client with keyring that uses branch key supplier for key A and key B
        DynamoDbEncryption ddbEnc = DynamoDbEncryption.builder()
                .DynamoDbEncryptionConfig(DynamoDbEncryptionConfig.builder().build())
                .build();
        IBranchKeyIdSupplier branchKeyIdSupplier = ddbEnc.CreateDynamoDbEncryptionBranchKeyIdSupplier(
                        CreateDynamoDbEncryptionBranchKeyIdSupplierInput.builder()
                                .ddbKeyBranchKeyIdSupplier(new TestSupplier())
                                .build())
                .branchKeyIdSupplier();
        IKeyring keyring = createHierarchicalKeyring(branchKeyIdSupplier);
        assertNotNull(keyring);
        DynamoDbEncryptionInterceptor interceptor = TestUtils.createInterceptor(keyring, null, null);
        DynamoDbClient ddbAB = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptor)
                                .build())
                .build();

        // Create client with keyring only configured with key A
        IKeyring keyringA = createHierarchicalKeyring(BRANCH_KEY_ID);
        assertNotNull(keyringA);
        DynamoDbEncryptionInterceptor interceptorA = TestUtils.createInterceptor(keyringA, null, null);
        DynamoDbClient ddbA = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptorA)
                                .build())
                .build();

        // Create client with keyring only configured with key B
        IKeyring keyringB = createHierarchicalKeyring(ACTIVE_ACTIVE_BRANCH_KEY_ID);
        assertNotNull(keyringB);
        DynamoDbEncryptionInterceptor interceptorB = TestUtils.createInterceptor(keyringB, null, null);
        DynamoDbClient ddbB = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptorB)
                                .build())
                .build();

        // Put CaseA item into table with Hierarchy keyring with supplier
        // Put item into table
        String partitionValue = "caseA";
        String sortValue = "42";
        String attrValue = "bar";
        String attrValue2 = "hello world";
        Map<String, AttributeValue> item = createTestItem(partitionValue, sortValue, attrValue, attrValue2);

        PutItemRequest putRequestA = PutItemRequest.builder()
                .tableName(TEST_TABLE_NAME)
                .item(item)
                .build();

        PutItemResponse putResponseA = ddbAB.putItem(putRequestA);
        assertEquals(200, putResponseA.sdkHttpResponse().statusCode());

        // Get Item back from table
        Map<String, AttributeValue> keyToGetA = createTestKey(partitionValue, sortValue);
        GetItemRequest getRequestA = GetItemRequest.builder()
                .key(keyToGetA)
                .tableName(TEST_TABLE_NAME)
                .build();

        GetItemResponse getResponseA = ddbAB.getItem(getRequestA);
        assertEquals(200, getResponseA.sdkHttpResponse().statusCode());
        Map<String, AttributeValue> returnedItemA = getResponseA.item();
        assertNotNull(returnedItemA);
        assertEquals(partitionValue, returnedItemA.get(TEST_PARTITION_NAME).s());
        assertEquals(sortValue, returnedItemA.get(TEST_SORT_NAME).n());
        assertEquals(attrValue, returnedItemA.get(TEST_ATTR_NAME).s());

        // Assert we can retrieve this item with a Hierarchical keyring configured only with key A
        getResponseA = ddbA.getItem(getRequestA);
        assertEquals(200, getResponseA.sdkHttpResponse().statusCode());
        returnedItemA = getResponseA.item();
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

        PutItemResponse putResponse2 = ddbAB.putItem(putRequest2);
        assertEquals(200, putResponse2.sdkHttpResponse().statusCode());

        // Get Item back from table
        Map<String, AttributeValue> keyToGetB = createTestKey(partitionValue, sortValue);

        GetItemRequest getRequestB = GetItemRequest.builder()
                .key(keyToGetB)
                .tableName(TEST_TABLE_NAME)
                .build();

        GetItemResponse getResponseB = ddbAB.getItem(getRequestB);
        assertEquals(200, getResponseB.sdkHttpResponse().statusCode());
        Map<String, AttributeValue> returnedItemB = getResponseB.item();
        assertNotNull(returnedItemB);
        assertEquals(partitionValue, returnedItemB.get(TEST_PARTITION_NAME).s());
        assertEquals(sortValue, returnedItemB.get(TEST_SORT_NAME).n());
        assertEquals(attrValue, returnedItemB.get(TEST_ATTR_NAME).s());

        // Assert we can retrieve this item with a Hierarchical keyring configured only with key B
        getResponseB = ddbB.getItem(getRequestB);
        assertEquals(200, getResponseB.sdkHttpResponse().statusCode());
        returnedItemB = getResponseB.item();
        assertNotNull(returnedItemB);
        assertEquals(partitionValue, returnedItemB.get(TEST_PARTITION_NAME).s());
        assertEquals(sortValue, returnedItemB.get(TEST_SORT_NAME).n());
        assertEquals(attrValue, returnedItemB.get(TEST_ATTR_NAME).s());
    }

    @Test
    public void TestHierarchyKeyringWithSupplierReturnsExpectedError() {
        // Create client with keyring that uses branch key supplier that errors on "caseC"
        DynamoDbEncryption ddbEnc = DynamoDbEncryption.builder()
                .DynamoDbEncryptionConfig(DynamoDbEncryptionConfig.builder().build())
                .build();
        IBranchKeyIdSupplier branchKeyIdSupplier = ddbEnc.CreateDynamoDbEncryptionBranchKeyIdSupplier(
                        CreateDynamoDbEncryptionBranchKeyIdSupplierInput.builder()
                                .ddbKeyBranchKeyIdSupplier(new TestSupplier())
                                .build())
                .branchKeyIdSupplier();
        IKeyring keyring = createHierarchicalKeyring(branchKeyIdSupplier);
        assertNotNull(keyring);
        DynamoDbEncryptionInterceptor interceptor = TestUtils.createInterceptor(keyring, null, null);
        DynamoDbClient ddbAB = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptor)
                                .build())
                .build();

        // Put CaseA item into table with Hierarchy keyring with supplier
        String partitionValue = "caseC";
        String sortValue = "42";
        String attrValue = "bar";
        String attrValue2 = "hello world";
        Map<String, AttributeValue> item = createTestItem(partitionValue, sortValue, attrValue, attrValue2);

        PutItemRequest putRequestA = PutItemRequest.builder()
                .tableName(TEST_TABLE_NAME)
                .item(item)
                .build();

        // TODO: Exception SHOULD be `DynamoDbEncryptionException.class`
        // https://sim.amazon.com/issues/4bde0b7b-12fd-4d05-8f8c-a9f1dbda01da
        assertThrows(OpaqueError.class, () -> {
            ddbAB.putItem(putRequestA);
        });
    }

    // DynamoDbKeyBranchKeyIdSupplier to be used with test items produced from TestUtils.java
    class TestSupplier implements IDynamoDbKeyBranchKeyIdSupplier {
        public GetBranchKeyIdFromDdbKeyOutput GetBranchKeyIdFromDdbKey(GetBranchKeyIdFromDdbKeyInput input) {
            Map<String, AttributeValue> key = input.ddbKey();

            // Ensure that key only contains the expected attributes
            assertTrue(key.containsKey(TEST_PARTITION_NAME));
            assertTrue(key.containsKey(TEST_SORT_NAME));
            assertFalse(key.containsKey(TEST_ATTR_NAME));
            assertFalse(key.containsKey(TEST_ATTR2_NAME));

            String branchKeyId;
            if (key.containsKey(TEST_PARTITION_NAME) && key.get(TEST_PARTITION_NAME).s().equals("caseA")) {
                branchKeyId = BRANCH_KEY_ID;
            } else if (key.containsKey(TEST_PARTITION_NAME) && key.get(TEST_PARTITION_NAME).s().equals("caseB")) {
                branchKeyId = ACTIVE_ACTIVE_BRANCH_KEY_ID;
            } else {
                throw new IllegalArgumentException("Item invalid, does not contain expected attributes.");
            }
            return GetBranchKeyIdFromDdbKeyOutput.builder().branchKeyId(branchKeyId).build();
        }
    }
}
