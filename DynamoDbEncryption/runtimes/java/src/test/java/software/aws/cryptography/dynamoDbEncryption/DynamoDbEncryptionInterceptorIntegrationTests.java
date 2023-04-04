package software.aws.cryptography.dynamoDbEncryption;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionContext;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionFlags;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.DirectKmsMaterialProvider;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import software.amazon.awssdk.services.dynamodb.model.*;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;

import java.security.GeneralSecurityException;
import java.util.*;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import software.amazon.cryptography.dynamoDbEncryption.model.*;
import software.amazon.cryptography.materialProviders.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static software.aws.cryptography.dynamoDbEncryption.TestUtils.*;


/*
  Tests require access to a DynamoDb table in the default region with:
    - tableName of "DynamoDbEncryptionInterceptorTestTable"
    - partition key of type 'S' with name "partition_key"
    - sort key off type 'N' with name "sort_key"
 */
public class DynamoDbEncryptionInterceptorIntegrationTests {
    static DynamoDbEncryptionInterceptor kmsInterceptor;
    static DynamoDbClient ddbKmsKeyring;

    @BeforeTest
    public static void setup() {
        kmsInterceptor = createInterceptor(createKmsKeyring(), null, null);
        ddbKmsKeyring = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(kmsInterceptor)
                                .build())
                .build();
    }

    @Test
    public void TestPutItemGetItem() {
        // Put item into table
        String partitionValue = "get";
        String sortValue = "42";
        String attrValue = "bar";
        String attrValue2 = "hello world";
        Map<String, AttributeValue> item = createTestItem(partitionValue, sortValue, attrValue, attrValue2);

        PutItemRequest putRequest = PutItemRequest.builder()
                .tableName(TEST_TABLE_NAME)
                .item(item)
                .build();

        PutItemResponse putResponse = ddbKmsKeyring.putItem(putRequest);
        assertEquals(200, putResponse.sdkHttpResponse().statusCode());

        // Get Item back from table
        Map<String, AttributeValue> keyToGet = createTestKey(partitionValue, sortValue);

        GetItemRequest getRequest = GetItemRequest.builder()
                .key(keyToGet)
                .tableName(TEST_TABLE_NAME)
                .build();

        GetItemResponse getResponse = ddbKmsKeyring.getItem(getRequest);
        assertEquals(200, getResponse.sdkHttpResponse().statusCode());
        Map<String, AttributeValue> returnedItem = getResponse.item();
        assertNotNull(returnedItem);
        assertEquals(partitionValue, returnedItem.get(TEST_PARTITION_NAME).s());
        assertEquals(sortValue, returnedItem.get(TEST_SORT_NAME).n());
        assertEquals(attrValue, returnedItem.get(TEST_ATTR_NAME).s());
    }

    @Test
    public void TestBatchWriteBatchGet() {
        // Batch write items to table
        Map<String, List<WriteRequest>> writeRequestItems = new HashMap<>();

        String partitionValue = "batch";
        String sortValue1 = "1";
        String sortValue2 = "2";
        String attrValue = "lorem ipsum";
        String attrValue2 = "hello world";
        Map<String,AttributeValue> item1 = createTestItem(partitionValue, sortValue1, attrValue, attrValue2);
        Map<String,AttributeValue> item2 = createTestItem(partitionValue, sortValue2, attrValue, attrValue2);

        List<WriteRequest> tableRequests = new ArrayList<>();
        tableRequests.add(WriteRequest.builder().putRequest(PutRequest.builder().item(item1).build()).build());
        tableRequests.add(WriteRequest.builder().putRequest(PutRequest.builder().item(item2).build()).build());
        writeRequestItems.put(TEST_TABLE_NAME, tableRequests);

        BatchWriteItemRequest writeRequest = BatchWriteItemRequest.builder()
                .requestItems(writeRequestItems)
                .build();

        BatchWriteItemResponse writeResponse = ddbKmsKeyring.batchWriteItem(writeRequest);
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

        BatchGetItemResponse getResponse = ddbKmsKeyring.batchGetItem(getRequest);
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
        // Put Item into table via transactions
        HashMap<String, AttributeValue> item = new HashMap<>();

        String partitionValue = "transact";
        String sortValue1 = "1";
        String sortValue2 = "2";
        String attrValue = "lorem ipsum";
        String attrValue2 = "hello world";
        Map<String,AttributeValue> item1 = createTestItem(partitionValue, sortValue1, attrValue, attrValue2);
        Map<String,AttributeValue> item2 = createTestItem(partitionValue, sortValue2, attrValue, attrValue2);

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

        TransactWriteItemsResponse putResponse = ddbKmsKeyring.transactWriteItems(writeRequest);
        assertEquals(200, putResponse.sdkHttpResponse().statusCode());

        // Get Item back from table via transactions
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

        TransactGetItemsResponse getResponse = ddbKmsKeyring.transactGetItems(getRequest);
        assertEquals(200, getResponse.sdkHttpResponse().statusCode());
        List<ItemResponse> responses = getResponse.responses();
        assertEquals(2, responses.size());
        ItemResponse response = responses.get(0);
        assertEquals(partitionValue, response.item().get(TEST_PARTITION_NAME).s());
        assertEquals(attrValue, response.item().get(TEST_ATTR_NAME).s());
    }

    @Test
    public void TestScan() {
        // Ensure table is populated with expected items
        String partitionValue = "scan";
        String sortValue1 = "1";
        String sortValue2 = "2";
        String attrValue = "lorem ipsum";
        String attrValue2 = "hello world";
        Map<String,AttributeValue> item1 = createTestItem(partitionValue, sortValue1, attrValue, attrValue2);
        Map<String,AttributeValue> item2 = createTestItem(partitionValue, sortValue2, attrValue, attrValue2);
        List<WriteRequest> tableRequests = new ArrayList<>();
        tableRequests.add(WriteRequest.builder().putRequest(PutRequest.builder().item(item1).build()).build());
        tableRequests.add(WriteRequest.builder().putRequest(PutRequest.builder().item(item2).build()).build());
        Map<String, List<WriteRequest>> writeRequestItems = new HashMap<>();
        writeRequestItems.put(TEST_TABLE_NAME, tableRequests);

        BatchWriteItemRequest writeRequest = BatchWriteItemRequest.builder()
                .requestItems(writeRequestItems)
                .build();
        BatchWriteItemResponse writeResponse = ddbKmsKeyring.batchWriteItem(writeRequest);
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

        ScanResponse scanResponse  = ddbKmsKeyring.scan(scanRequest);
        assertEquals(200, scanResponse.sdkHttpResponse().statusCode());
        assertEquals(2, (double) scanResponse.count());
        Map<String, AttributeValue> item = scanResponse.items().get(0);
        assertEquals(partitionValue, item.get(TEST_PARTITION_NAME).s());
        assertEquals(attrValue, item.get(TEST_ATTR_NAME).s());
    }

    @Test
    public void TestQuery() {
        // Ensure table is populated with expected items
        String partitionValue = "query";
        String sortValue1 = "1";
        String sortValue2 = "2";
        String attrValue = "lorem ipsum";
        String attrValue2 = "hello world";
        Map<String,AttributeValue> item1 = createTestItem(partitionValue, sortValue1, attrValue, attrValue2);
        Map<String,AttributeValue> item2 = createTestItem(partitionValue, sortValue2, attrValue, attrValue2);
        List<WriteRequest> tableRequests = new ArrayList<>();
        tableRequests.add(WriteRequest.builder().putRequest(PutRequest.builder().item(item1).build()).build());
        tableRequests.add(WriteRequest.builder().putRequest(PutRequest.builder().item(item2).build()).build());
        Map<String, List<WriteRequest>> writeRequestItems = new HashMap<>();
        writeRequestItems.put(TEST_TABLE_NAME, tableRequests);

        BatchWriteItemRequest writeRequest = BatchWriteItemRequest.builder()
                .requestItems(writeRequestItems)
                .build();
        BatchWriteItemResponse writeResponse = ddbKmsKeyring.batchWriteItem(writeRequest);
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

        QueryResponse queryResponse  = ddbKmsKeyring.query(queryRequest);
        assertEquals(200, queryResponse.sdkHttpResponse().statusCode());
        assertEquals(1, (double) queryResponse.count());
        Map<String, AttributeValue> item = queryResponse.items().get(0);
        assertEquals(partitionValue, item.get(TEST_PARTITION_NAME).s());
        assertEquals(sortValue2, item.get(TEST_SORT_NAME).n());
        assertEquals(attrValue, item.get(TEST_ATTR_NAME).s());
    }

    @Test
    public void TestReadLegacyItem() throws GeneralSecurityException {
        String partitionValue = "legacyRead";
        String sortValue = "42";
        String attrValue = "bar";
        String attrValue2 = "hello world";
        Map<String, com.amazonaws.services.dynamodbv2.model.AttributeValue> legacyItem =
                createLegacyTestItem(partitionValue, sortValue, attrValue, attrValue2);

        // Set up Legacy DDBEC Encryptor
        DynamoDBEncryptor legacyEncryptor = createLegacyEncryptor();

        EncryptionContext encryptionContext =
            new EncryptionContext.Builder()
                .withTableName(TEST_TABLE_NAME)
                .withHashKeyName(TEST_PARTITION_NAME)
                .withRangeKeyName(TEST_SORT_NAME)
                .build();
        Map<String, Set<EncryptionFlags>> actions = createLegacyAttributeFlags();

        // Encrypt the plaintext record directly
        final Map<String, com.amazonaws.services.dynamodbv2.model.AttributeValue> encrypted_record =
            legacyEncryptor.encryptRecord(legacyItem, actions, encryptionContext);
        // Put record into ddb directly using SDKv1 Java client
        AmazonDynamoDB legacyDDB = AmazonDynamoDBClientBuilder.standard().build();
        legacyDDB.putItem(new com.amazonaws.services.dynamodbv2.model.PutItemRequest(TEST_TABLE_NAME, encrypted_record));

        DynamoDbEncryptionInterceptor interceptor =
                createInterceptor(createKmsKeyring(), LegacyPolicy.REQUIRE_ENCRYPT_ALLOW_DECRYPT, null);
        DynamoDbClient ddbWithLegacy = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptor)
                                .build())
                .build();

        // Read item written by legacy encryptor
        Map<String, AttributeValue> keyToGet = createTestKey(partitionValue, sortValue);
        GetItemRequest getRequest = GetItemRequest.builder()
                .key(keyToGet)
                .tableName(TEST_TABLE_NAME)
                .build();
        GetItemResponse getResponse = ddbWithLegacy.getItem(getRequest);
        assertEquals(200, getResponse.sdkHttpResponse().statusCode());
        Map<String, AttributeValue> returnedItem = getResponse.item();
        assertNotNull(returnedItem);
        assertEquals(partitionValue, returnedItem.get(TEST_PARTITION_NAME).s());
        assertEquals(sortValue, returnedItem.get(TEST_SORT_NAME).n());
        assertEquals(attrValue, returnedItem.get(TEST_ATTR_NAME).s());
    }

    @Test
    public void TestWriteLegacyItem() throws GeneralSecurityException {
        // Put item into table
        String partitionValue = "legacyWrite";
        String sortValue = "42";
        String attrValue = "bar";
        String attrValue2 = "hello world";
        Map<String, AttributeValue> item = createTestItem(partitionValue, sortValue, attrValue, attrValue2);
        
        // Set up Legacy DDBEC Encryptor
        DynamoDBEncryptor legacyEncryptor = createLegacyEncryptor();

        EncryptionContext encryptionContext =
            new EncryptionContext.Builder()
                .withTableName(TEST_TABLE_NAME)
                .withHashKeyName(TEST_PARTITION_NAME)
                .withRangeKeyName(TEST_SORT_NAME)
                .build();
        Map<String, Set<EncryptionFlags>> actions = createLegacyAttributeFlags();
        
        // Configure interceptor with legacy behavior
        DynamoDbEncryptionInterceptor interceptor =
                createInterceptor(createKmsKeyring(), LegacyPolicy.REQUIRE_ENCRYPT_ALLOW_DECRYPT, null);
        DynamoDbClient ddbWithLegacy = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptor)
                                .build())
                .build();

        // Put Item using legacy behavior
        PutItemRequest putRequest = PutItemRequest.builder()
                .tableName(TEST_TABLE_NAME)
                .item(item)
                .build();
        PutItemResponse putResponse = ddbWithLegacy.putItem(putRequest);
        assertEquals(200, putResponse.sdkHttpResponse().statusCode());

        // Get record from ddb directly using SDKv1 Java client
        final Map<String, com.amazonaws.services.dynamodbv2.model.AttributeValue> itemKey = new HashMap<>();
        itemKey.put(TEST_PARTITION_NAME,
                new com.amazonaws.services.dynamodbv2.model.AttributeValue().withS(partitionValue));
        itemKey.put(TEST_SORT_NAME,
                new com.amazonaws.services.dynamodbv2.model.AttributeValue().withN(sortValue));

        AmazonDynamoDB legacyDDB = AmazonDynamoDBClientBuilder.standard().build();
        com.amazonaws.services.dynamodbv2.model.GetItemResult getItemResponse = legacyDDB.getItem(
                new com.amazonaws.services.dynamodbv2.model.GetItemRequest(TEST_TABLE_NAME, itemKey)
        );
        
        // Decrypt the plaintext record directly
        final Map<String, com.amazonaws.services.dynamodbv2.model.AttributeValue> decryptedRecord =
            legacyEncryptor.decryptRecord(getItemResponse.getItem(), actions, encryptionContext);
        assertNotNull(decryptedRecord);
        assertEquals(partitionValue, decryptedRecord.get(TEST_PARTITION_NAME).getS());
        assertEquals(sortValue, decryptedRecord.get(TEST_SORT_NAME).getN());
        assertEquals(attrValue, decryptedRecord.get(TEST_ATTR_NAME).getS());
    }

    @Test
    public void TestPlaintextRead() {
        // Put plaintext item into table
        String partitionValue = "get";
        String sortValue = "42";
        String attrValue = "bar";
        String attrValue2 = "hello world";
        Map<String, AttributeValue> item = createTestItem(partitionValue, sortValue, attrValue, attrValue2);

        DynamoDbClient regularClient = DynamoDbClient.builder().build();

        PutItemRequest putRequest = PutItemRequest.builder()
                .tableName(TEST_TABLE_NAME)
                .item(item)
                .build();

        PutItemResponse putResponse = regularClient.putItem(putRequest);
        assertEquals(200, putResponse.sdkHttpResponse().statusCode());

        // Get Item back from table, using *ALLOW_READ Plaintext policy
        DynamoDbEncryptionInterceptor interceptor = createInterceptor(
                createKmsKeyring(), // Just need to configure some valid keyring
                null,
                PlaintextPolicy.REQUIRE_WRITE_ALLOW_READ);
        DynamoDbClient clientWithPolicy = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptor)
                                .build())
                .build();

        Map<String, AttributeValue> keyToGet = createTestKey(partitionValue, sortValue);

        GetItemRequest getRequest = GetItemRequest.builder()
                .key(keyToGet)
                .tableName(TEST_TABLE_NAME)
                .build();

        GetItemResponse getResponse = clientWithPolicy.getItem(getRequest);
        assertEquals(200, getResponse.sdkHttpResponse().statusCode());
        Map<String, AttributeValue> returnedItem = getResponse.item();
        assertNotNull(returnedItem);
        assertEquals(partitionValue, returnedItem.get(TEST_PARTITION_NAME).s());
        assertEquals(sortValue, returnedItem.get(TEST_SORT_NAME).n());
        assertEquals(attrValue, returnedItem.get(TEST_ATTR_NAME).s());
    }

    @Test
    public void TestPlaintextWrite() {
        // Put plaintext item into table using client with REQUIRE_WRITE* policy
        String partitionValue = "get";
        String sortValue = "42";
        String attrValue = "bar";
        String attrValue2 = "hello world";
        Map<String, AttributeValue> item = createTestItem(partitionValue, sortValue, attrValue, attrValue2);

        DynamoDbEncryptionInterceptor interceptor = createInterceptor(
                createKmsKeyring(), // Just need to configure some valid keyring
                null,
                PlaintextPolicy.REQUIRE_WRITE_ALLOW_READ);
        DynamoDbClient clientWithPolicy = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptor)
                                .build())
                .build();


        PutItemRequest putRequest = PutItemRequest.builder()
                .tableName(TEST_TABLE_NAME)
                .item(item)
                .build();

        PutItemResponse putResponse = clientWithPolicy.putItem(putRequest);
        assertEquals(200, putResponse.sdkHttpResponse().statusCode());

        // Get Item back from table, using *ALLOW_READ Plaintext policy
        DynamoDbClient regularClient = DynamoDbClient.builder().build();

        Map<String, AttributeValue> keyToGet = createTestKey(partitionValue, sortValue);

        GetItemRequest getRequest = GetItemRequest.builder()
                .key(keyToGet)
                .tableName(TEST_TABLE_NAME)
                .build();

        GetItemResponse getResponse = regularClient.getItem(getRequest);
        assertEquals(200, getResponse.sdkHttpResponse().statusCode());
        Map<String, AttributeValue> returnedItem = getResponse.item();
        assertNotNull(returnedItem);
        assertEquals(partitionValue, returnedItem.get(TEST_PARTITION_NAME).s());
        assertEquals(sortValue, returnedItem.get(TEST_SORT_NAME).n());
        assertEquals(attrValue, returnedItem.get(TEST_ATTR_NAME).s());
    }
}
