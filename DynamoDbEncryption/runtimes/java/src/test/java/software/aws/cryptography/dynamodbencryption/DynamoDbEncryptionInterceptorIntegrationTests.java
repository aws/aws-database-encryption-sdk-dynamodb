package software.aws.cryptography.dynamodbencryption;

import software.amazon.awssdk.services.dynamodb.model.*;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.materialProviders.IKeyring;
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
        IKeyring kmsKeyring = matProv.CreateAwsKmsMultiKeyring(keyringInput);

        Map<String, CryptoAction> actions = new HashMap<>();
        actions.put(TEST_PARTITION_NAME, CryptoAction.ENCRYPT_AND_SIGN);
        actions.put(TEST_SORT_NAME, CryptoAction.SIGN_ONLY);
        actions.put(TEST_ATTR_NAME, CryptoAction.DO_NOTHING);

        Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME, DynamoDbTableEncryptionConfig.builder()
                .partitionKeyName(TEST_PARTITION_NAME)
                .sortKeyName(TEST_SORT_NAME)
                .attributeActions(actions)
                .keyring(kmsKeyring)
                .build());

        return DynamoDbEncryptionInterceptor.builder()
                .config(DynamoDbEncryptionConfig.builder()
                        .tableEncryptionConfigs(tableConfigs)
                        .build())
                .build();
    }

    public Map<String, AttributeValue> createTestItem(String partition, String sort, String attr) {
        HashMap<String, AttributeValue> item = new HashMap<>();
        item.put(TEST_PARTITION_NAME, AttributeValue.builder().s(partition).build());
        item.put(TEST_SORT_NAME, AttributeValue.builder().n(sort).build());
        item.put(TEST_ATTR_NAME, AttributeValue.builder().s(attr).build());
        return item;
    }

    public Map<String, AttributeValue> createTestKey(String partition, String sort) {
        HashMap<String, AttributeValue> key = new HashMap<>();
        key.put(TEST_PARTITION_NAME, AttributeValue.builder().s(partition).build());
        key.put(TEST_SORT_NAME, AttributeValue.builder().n(sort).build());
        return key;
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

        String partitionValue = "foo";
        String sortValue = "42";
        String attrValue = "bar";
        Map<String, AttributeValue> item = createTestItem(partitionValue, sortValue, attrValue);

        PutItemRequest putRequest = PutItemRequest.builder()
                .tableName(TEST_TABLE_NAME)
                .item(item)
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

        String partitionValue = "batch";
        String sortValue1 = "1";
        String sortValue2 = "2";
        String attrValue = "lorem ipsum";
        Map<String,AttributeValue> item1 = createTestItem(partitionValue, sortValue1, attrValue);
        Map<String,AttributeValue> item2 = createTestItem(partitionValue, sortValue2, attrValue);

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

        Map<String,AttributeValue> key1 = createTestKey(partitionValue, sortValue1);
        Map<String,AttributeValue> key2 = createTestKey(partitionValue, sortValue2);

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

    @Test
    public void TestTransactWriteAndGet() {
        DynamoDbEncryptionInterceptor interceptor = createInterceptor();
        DynamoDbClient ddb = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptor)
                                .build())
                .build();

        // Put Item into table
        HashMap<String, AttributeValue> item = new HashMap<>();

        String partitionValue = "transact";
        String sortValue1 = "1";
        String sortValue2 = "2";
        String attrValue = "lorem ipsum";
        Map<String,AttributeValue> item1 = createTestItem(partitionValue, sortValue1, attrValue);
        Map<String,AttributeValue> item2 = createTestItem(partitionValue, sortValue2, attrValue);

        // TODO Transactions need to be built with TableName, otherwise we get a NPE.
        // TableName is @required but the Java object builder does not enforce it.
        // We should add validation on our conversions to give a helpful error message instead.
        TransactWriteItemsRequest writeRequest = TransactWriteItemsRequest.builder()
                .transactItems(
                        TransactWriteItem.builder()
                                .put(Put.builder()
                                        .item(item1)
                                        .tableName(TEST_TABLE_NAME)
                                        .build())
                                .build(),
                        TransactWriteItem.builder()
                                .put(Put.builder()
                                        .item(item2)
                                        .tableName(TEST_TABLE_NAME)
                                        .build())
                                .build())
                .build();

        TransactWriteItemsResponse putResponse = ddb.transactWriteItems(writeRequest);
        assertEquals(200, putResponse.sdkHttpResponse().statusCode());

        // Get Item back from table
        Map<String,AttributeValue> key1 = createTestKey(partitionValue, sortValue1);
        Map<String,AttributeValue> key2 = createTestKey(partitionValue, sortValue2);


        TransactGetItemsRequest getRequest = TransactGetItemsRequest.builder()
                .transactItems(
                        TransactGetItem.builder()
                                .get(Get.builder()
                                        .key(key1)
                                        .tableName(TEST_TABLE_NAME)
                                        .build())
                                .build(),
                        TransactGetItem.builder()
                                .get(Get.builder()
                                        .key(key2)
                                        .tableName(TEST_TABLE_NAME)
                                        .build())
                                .build()
                )
                .build();

        TransactGetItemsResponse getResponse = ddb.transactGetItems(getRequest);
        assertEquals(200, getResponse.sdkHttpResponse().statusCode());
        List<ItemResponse> responses = getResponse.responses();
        assertEquals(2, responses.size());
        ItemResponse response = responses.get(0);
        assertEquals(partitionValue, response.item().get(TEST_PARTITION_NAME).s());
        assertEquals(attrValue, response.item().get(TEST_ATTR_NAME).s());
    }

    @Test
    public void TestScan() {
        DynamoDbEncryptionInterceptor interceptor = createInterceptor();
        DynamoDbClient ddb = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptor)
                                .build())
                .build();

        // Ensure table is populated with expected items
        String partitionValue = "scan";
        String sortValue1 = "1";
        String sortValue2 = "2";
        String attrValue = "lorem ipsum";
        Map<String,AttributeValue> item1 = createTestItem(partitionValue, sortValue1, attrValue);
        Map<String,AttributeValue> item2 = createTestItem(partitionValue, sortValue2, attrValue);
        List<WriteRequest> tableRequests = new ArrayList<>();
        tableRequests.add(WriteRequest.builder().putRequest(PutRequest.builder().item(item1).build()).build());
        tableRequests.add(WriteRequest.builder().putRequest(PutRequest.builder().item(item2).build()).build());
        Map<String, List<WriteRequest>> writeRequestItems = new HashMap<>();
        writeRequestItems.put(TEST_TABLE_NAME, tableRequests);

        BatchWriteItemRequest writeRequest = BatchWriteItemRequest.builder()
                .requestItems(writeRequestItems)
                .build();
        BatchWriteItemResponse writeResponse = ddb.batchWriteItem(writeRequest);
        assertEquals(200, writeResponse.sdkHttpResponse().statusCode());
        assertEquals(0, writeResponse.unprocessedItems().size());

        // Scan and filter for items with "scan"
        Map<String, AttributeValue> attrValues = new HashMap();
        attrValues.put(":val", AttributeValue.builder().s(partitionValue).build());
        ScanRequest scanRequest = ScanRequest.builder()
                .tableName(TEST_TABLE_NAME)
                .filterExpression("partition_key = :val")
                .expressionAttributeValues(attrValues)
                .build();

        ScanResponse scanResponse  = ddb.scan(scanRequest);
        assertEquals(200, scanResponse.sdkHttpResponse().statusCode());
        assertEquals(2, scanResponse.count());
        Map<String, AttributeValue> item = scanResponse.items().get(0);
        assertEquals(partitionValue, item.get(TEST_PARTITION_NAME).s());
        assertEquals(attrValue, item.get(TEST_ATTR_NAME).s());
    }

    @Test
    public void TestQuery() {
        DynamoDbEncryptionInterceptor interceptor = createInterceptor();
        DynamoDbClient ddb = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptor)
                                .build())
                .build();

        // Ensure table is populated with expected items
        String partitionValue = "query";
        String sortValue1 = "1";
        String sortValue2 = "2";
        String attrValue = "lorem ipsum";
        Map<String,AttributeValue> item1 = createTestItem(partitionValue, sortValue1, attrValue);
        Map<String,AttributeValue> item2 = createTestItem(partitionValue, sortValue2, attrValue);
        List<WriteRequest> tableRequests = new ArrayList<>();
        tableRequests.add(WriteRequest.builder().putRequest(PutRequest.builder().item(item1).build()).build());
        tableRequests.add(WriteRequest.builder().putRequest(PutRequest.builder().item(item2).build()).build());
        Map<String, List<WriteRequest>> writeRequestItems = new HashMap<>();
        writeRequestItems.put(TEST_TABLE_NAME, tableRequests);

        BatchWriteItemRequest writeRequest = BatchWriteItemRequest.builder()
                .requestItems(writeRequestItems)
                .build();
        BatchWriteItemResponse writeResponse = ddb.batchWriteItem(writeRequest);
        assertEquals(200, writeResponse.sdkHttpResponse().statusCode());
        assertEquals(0, writeResponse.unprocessedItems().size());

        // Query such that we get one "query" item back, but not the other
        Map<String, AttributeValue> attrValues = new HashMap();
        attrValues.put(":v1", AttributeValue.builder().s(partitionValue).build());
        attrValues.put(":v2", AttributeValue.builder().n(sortValue1).build());
        QueryRequest queryRequest = QueryRequest.builder()
                .tableName(TEST_TABLE_NAME)
                .keyConditionExpression("partition_key = :v1 AND sort_key > :v2")
                .expressionAttributeValues(attrValues)
                .build();

        QueryResponse queryResponse  = ddb.query(queryRequest);
        assertEquals(200, queryResponse.sdkHttpResponse().statusCode());
        assertEquals(1, queryResponse.count());
        Map<String, AttributeValue> item = queryResponse.items().get(0);
        assertEquals(partitionValue, item.get(TEST_PARTITION_NAME).s());
        assertEquals(sortValue2, item.get(TEST_SORT_NAME).n());
        assertEquals(attrValue, item.get(TEST_ATTR_NAME).s());
    }
}
