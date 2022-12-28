package software.aws.cryptography.dynamodbencryption;

import software.amazon.awssdk.services.dynamodb.model.*;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.DynamoDbEncryptionMiddlewareInternalConfig;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.materialProviders.Keyring;
import software.amazon.cryptography.materialProviders.MaterialProviders;
import software.amazon.cryptography.materialProviders.model.CreateAwsKmsMultiKeyringInput;
import software.amazon.cryptography.materialProviders.model.MaterialProvidersConfig;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/*
  Tests require access to a DynamoDb table in the default region with:
    - tableName of "DynamoDbEncryptionInterceptorTestTable"
    - partition key of type 'S' with name "partition_key"
    - sort key off type 'N' with name "sort_key"
 */
public class DynamoDbEncryptionInterceptorIntegrationTests {
    static final String TEST_TABLE_NAME = "DynamoDbEncryptionInterceptorTestTable";
    static final String TEST_PARTITION_NAME = "partition_key";
    static final String TEST_SORT_NAME = "sort_key";
    static final String TEST_ATTR_NAME = "attr1";

    static final String KMS_TEST_KEY_ID = "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f";

    public DynamoDbEncryptionInterceptor createInterceptor() {
        MaterialProviders matProv = MaterialProviders.builder()
                .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                .build();
        CreateAwsKmsMultiKeyringInput keyringInput = CreateAwsKmsMultiKeyringInput.builder()
                .generator(KMS_TEST_KEY_ID)
                .build();
        Keyring kmsKeyring = matProv.CreateAwsKmsMultiKeyring(keyringInput);

        Map<String, CryptoAction> actions = new HashMap<>();
        actions.put(TEST_PARTITION_NAME, CryptoAction.ENCRYPT_AND_SIGN);
        actions.put("bad", CryptoAction.SIGN_ONLY);
        actions.put(TEST_ATTR_NAME, CryptoAction.DO_NOTHING);

        Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME, DynamoDbTableEncryptionConfig.builder()
                .partitionKeyName(TEST_PARTITION_NAME)
                .sortKeyName(TEST_SORT_NAME)
                .attributeActions(actions)
                .keyring(kmsKeyring)
                .build());

        return DynamoDbEncryptionInterceptor.builder()
                .config(DynamoDbEncryptionMiddlewareInternalConfig.builder()
                        .tableEncryptionConfigs(tableConfigs)
                        .build())
                .build();
    }

    @Test
    public void TestPutItemGetItem() {
        DynamoDbEncryptionInterceptor interceptor = createInterceptor();
        DynamoDbClient ddb = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptor)
                                .build())
                .build();

        // Put Item into table
        HashMap<String, AttributeValue> item = new HashMap<>();

        String partitionValue = "foo";
        String sortValue = "42";
        String attrValue = "bar";
        item.put(TEST_PARTITION_NAME, AttributeValue.builder().s(partitionValue).build());
        item.put(TEST_SORT_NAME, AttributeValue.builder().n(sortValue).build());
        item.put(TEST_ATTR_NAME, AttributeValue.builder().s(attrValue).build());

        PutItemRequest putRequest = PutItemRequest.builder()
                .tableName(TEST_TABLE_NAME)
                .item(item)
                .build();

        PutItemResponse putResponse = ddb.putItem(putRequest);
        assertEquals(200, putResponse.sdkHttpResponse().statusCode());

        // Get Item back from table
        HashMap<String, AttributeValue> keyToGet = new HashMap<>();

        keyToGet.put(TEST_PARTITION_NAME, AttributeValue.builder().s(partitionValue).build());
        keyToGet.put(TEST_SORT_NAME, AttributeValue.builder().n(sortValue).build());

        GetItemRequest getRequest = GetItemRequest.builder()
                .key(keyToGet)
                .tableName(TEST_TABLE_NAME)
                .build();

        GetItemResponse getResponse = ddb.getItem(getRequest);
        assertEquals(200, putResponse.sdkHttpResponse().statusCode());
        Map<String, AttributeValue> returnedItem = getResponse.item();
        assertNotNull(returnedItem);
        assertEquals(partitionValue, returnedItem.get(TEST_PARTITION_NAME).s());
        assertEquals(sortValue, returnedItem.get(TEST_SORT_NAME).n());
        assertEquals(attrValue, returnedItem.get(TEST_ATTR_NAME).s());
    }

    @Test
    public void TestBatchWriteBatchGet() {
        DynamoDbEncryptionInterceptor interceptor = createInterceptor();
        DynamoDbClient ddb = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptor)
                                .build())
                .build();

        // Batch write items to table
        Map<String, List<WriteRequest>> writeRequestItems = new HashMap<>();

        HashMap<String,AttributeValue> item1 = new HashMap<>();
        String partitionValue = "batch";
        String sortValue1 = "1";
        String attrValue = "lorem ipsum";
        item1.put(TEST_PARTITION_NAME, AttributeValue.builder().s(partitionValue).build());
        item1.put(TEST_SORT_NAME, AttributeValue.builder().n(sortValue1).build());
        item1.put(TEST_ATTR_NAME, AttributeValue.builder().s(attrValue).build());

        HashMap<String,AttributeValue> item2 = new HashMap<>();
        String sortValue2 = "2";
        item2.put(TEST_PARTITION_NAME, AttributeValue.builder().s(partitionValue).build());
        item2.put(TEST_SORT_NAME, AttributeValue.builder().n(sortValue2).build());
        item2.put(TEST_ATTR_NAME, AttributeValue.builder().s(attrValue).build());

        List<WriteRequest> tableRequests = new ArrayList<>();
        tableRequests.add(WriteRequest.builder().putRequest(PutRequest.builder().item(item1).build()).build());
        tableRequests.add(WriteRequest.builder().putRequest(PutRequest.builder().item(item2).build()).build());
        writeRequestItems.put(TEST_TABLE_NAME, tableRequests);

        BatchWriteItemRequest writeRequest = BatchWriteItemRequest.builder()
                .requestItems(writeRequestItems)
                .build();

        BatchWriteItemResponse writeResponse = ddb.batchWriteItem(writeRequest);
        assertEquals(200, writeResponse.sdkHttpResponse().statusCode());
        // Technically DDB does not have to process every item,
        // however given we are working with a small set of data
        // this should almost never happen
        assertEquals(0, writeResponse.unprocessedItems().size());

        // Batch get items back from table
        Map<String, KeysAndAttributes> getRequestItems = new HashMap<>();

        HashMap<String,AttributeValue> key1 = new HashMap<>();
        key1.put(TEST_PARTITION_NAME, AttributeValue.builder().s(partitionValue).build());
        key1.put(TEST_SORT_NAME, AttributeValue.builder().n(sortValue1).build());

        HashMap<String,AttributeValue> key2 = new HashMap<>();
        key2.put(TEST_PARTITION_NAME, AttributeValue.builder().s(partitionValue).build());
        key2.put(TEST_SORT_NAME, AttributeValue.builder().n(sortValue2).build());

        List<Map<String,AttributeValue>> tableGetRequests = new ArrayList<>();
        tableGetRequests.add(key1);
        tableGetRequests.add(key2);
        getRequestItems.put(TEST_TABLE_NAME, KeysAndAttributes.builder().keys(tableGetRequests).build());

        BatchGetItemRequest getRequest = BatchGetItemRequest.builder()
                .requestItems(getRequestItems)
                .build();

        BatchGetItemResponse getResponse = ddb.batchGetItem(getRequest);
        assertEquals(200, getResponse.sdkHttpResponse().statusCode());
        // Technically DDB does not have to process every item,
        // however given we are working with a small set of data
        // this should almost never happen
        assertEquals(0, getResponse.unprocessedKeys().size());
        List<Map<String, AttributeValue>> returnedItems = getResponse.responses().get(TEST_TABLE_NAME);
        assertEquals(2, returnedItems.size());
        Map<String, AttributeValue> returnedItem = returnedItems.get(0);
        assertEquals(partitionValue, returnedItem.get(TEST_PARTITION_NAME).s());
        assertEquals(attrValue, returnedItem.get(TEST_ATTR_NAME).s());
    }
}
