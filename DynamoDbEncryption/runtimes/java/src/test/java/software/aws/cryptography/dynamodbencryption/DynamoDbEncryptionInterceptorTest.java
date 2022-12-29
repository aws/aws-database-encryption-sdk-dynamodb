package software.aws.cryptography.dynamodbencryption;

import software.amazon.awssdk.core.SdkRequest;
import software.amazon.awssdk.core.interceptor.*;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.nio.ByteBuffer;
import java.util.*;

import org.junit.jupiter.api.Test;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionException;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dynamoDbItemEncryptor.model.DynamoDbItemEncryptorException;
import software.amazon.cryptography.materialProviders.Keyring;
import software.amazon.cryptography.materialProviders.MaterialProviders;
import software.amazon.cryptography.materialProviders.model.AesWrappingAlg;
import software.amazon.cryptography.materialProviders.model.CreateRawAesKeyringInput;
import software.amazon.cryptography.materialProviders.model.MaterialProvidersConfig;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;

import static org.junit.jupiter.api.Assertions.*;

public class DynamoDbEncryptionInterceptorTest {
    static final String TEST_TABLE_NAME = "DynamoDbEncryptionInterceptorTestTable";
    static final String TEST_PARTITION_NAME = "partition_key";
    static final String TEST_SORT_NAME = "sort_key";
    static final String TEST_ATTR_NAME = "attr1";

    public DynamoDbEncryptionInterceptor createInterceptor() {
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
        Keyring kmsKeyring = matProv.CreateRawAesKeyring(keyringInput);

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

    public Map<String, AttributeValue> createTestItem() {
        return createTestItem("partition", "42", "attr1");
    }

    public Map<String, AttributeValue> createTestItem(String partition, String sort, String attr) {
        HashMap<String, AttributeValue> item = new HashMap<>();
        item.put(TEST_PARTITION_NAME, AttributeValue.builder().s(partition).build());
        item.put(TEST_SORT_NAME, AttributeValue.builder().n(sort).build());
        item.put(TEST_ATTR_NAME, AttributeValue.builder().s(attr).build());
        return item;
    }

    @Test
    public void TestPutItemGetItemWithConditionExpression() {
        DynamoDbEncryptionInterceptor interceptor = createInterceptor();

        PutItemRequest oldRequest = PutItemRequest.builder()
                .tableName(TEST_TABLE_NAME)
                .conditionExpression("foo")
                .build();

        Context.ModifyRequest context = InterceptorContext.builder()
                .request(oldRequest)
                .build();
        ExecutionAttributes attributes = ExecutionAttributes.builder()
                .put(SdkExecutionAttribute.OPERATION_NAME, "PutItem")
                .put(SdkExecutionAttribute.SERVICE_NAME, "DynamoDb")
                .build();

        Exception exception = assertThrows(DynamoDbEncryptionException.class, () -> {
            interceptor.modifyRequest(context, attributes);
        });
        assertTrue(exception.getMessage().contains("Condition Expressions not supported in PutItem with Encryption."));
    }

    @Test
    public void TestUpdateItemOnEncryptedTable() {
        DynamoDbEncryptionInterceptor interceptor = createInterceptor();

        UpdateItemRequest oldRequest = UpdateItemRequest.builder()
                .tableName(TEST_TABLE_NAME)
                .build();

        Context.ModifyRequest context = InterceptorContext.builder()
                .request(oldRequest)
                .build();
        ExecutionAttributes attributes = ExecutionAttributes.builder()
                .put(SdkExecutionAttribute.OPERATION_NAME, "UpdateItem")
                .put(SdkExecutionAttribute.SERVICE_NAME, "DynamoDb")
                .build();

        Exception exception = assertThrows(DynamoDbEncryptionException.class, () -> {
            interceptor.modifyRequest(context, attributes);
        });
        assertTrue(exception.getMessage().contains("Updates are not supported on tables configured with encryption."));
    }

    @Test
    public void TestUpdateItemOnNonEncryptedTable() {
        DynamoDbEncryptionInterceptor interceptor = createInterceptor();

        UpdateItemRequest oldRequest = UpdateItemRequest.builder()
                .tableName("otherTable")
                .build();

        Context.ModifyRequest context = InterceptorContext.builder()
                .request(oldRequest)
                .build();
        ExecutionAttributes attributes = ExecutionAttributes.builder()
                .put(SdkExecutionAttribute.OPERATION_NAME, "UpdateItem")
                .put(SdkExecutionAttribute.SERVICE_NAME, "DynamoDb")
                .build();

        SdkRequest newRequest = interceptor.modifyRequest(context, attributes);
        assertEquals(oldRequest, newRequest);
    }

    @Test
    public void TestTransactWriteItemsWithConditionCheck() {
        DynamoDbEncryptionInterceptor interceptor = createInterceptor();

        TransactWriteItemsRequest oldRequest = TransactWriteItemsRequest.builder()
                .transactItems(
                        TransactWriteItem.builder()
                                .put(Put.builder()
                                        .tableName(TEST_TABLE_NAME)
                                        .build())
                                .conditionCheck(ConditionCheck.builder()
                                        .tableName(TEST_TABLE_NAME)
                                        .build())
                                .build())
                .build();

        Context.ModifyRequest context = InterceptorContext.builder()
                .request(oldRequest)
                .build();
        ExecutionAttributes attributes = ExecutionAttributes.builder()
                .put(SdkExecutionAttribute.OPERATION_NAME, "TransactWriteItems")
                .put(SdkExecutionAttribute.SERVICE_NAME, "DynamoDb")
                .build();

        Exception exception = assertThrows(DynamoDbEncryptionException.class, () -> {
            interceptor.modifyRequest(context, attributes);
        });
        assertTrue(exception.getMessage().contains("Condition expressions not allowed on encrypted tables (TransactWriteItems ConditionCheck)"));
    }

    @Test
    public void TestTransactWriteItemsWithPutConditionExpression() {
        DynamoDbEncryptionInterceptor interceptor = createInterceptor();

        TransactWriteItemsRequest oldRequest = TransactWriteItemsRequest.builder()
                .transactItems(
                        TransactWriteItem.builder()
                                .put(Put.builder()
                                        .tableName(TEST_TABLE_NAME)
                                        .conditionExpression("foo")
                                        .build())
                                .build())
                .build();

        Context.ModifyRequest context = InterceptorContext.builder()
                .request(oldRequest)
                .build();
        ExecutionAttributes attributes = ExecutionAttributes.builder()
                .put(SdkExecutionAttribute.OPERATION_NAME, "TransactWriteItems")
                .put(SdkExecutionAttribute.SERVICE_NAME, "DynamoDb")
                .build();

        Exception exception = assertThrows(DynamoDbEncryptionException.class, () -> {
            interceptor.modifyRequest(context, attributes);
        });
        assertTrue(exception.getMessage().contains("Condition expressions not allowed on encrypted tables (TransactWriteItems Put)"));
    }

    @Test
    public void TestTransactWriteItemsWithDeleteConditionExpression() {
        DynamoDbEncryptionInterceptor interceptor = createInterceptor();

        TransactWriteItemsRequest oldRequest = TransactWriteItemsRequest.builder()
                .transactItems(
                        TransactWriteItem.builder()
                                .delete(Delete.builder()
                                        .tableName(TEST_TABLE_NAME)
                                        .conditionExpression("foo")
                                        .build())
                                .build())
                .build();

        Context.ModifyRequest context = InterceptorContext.builder()
                .request(oldRequest)
                .build();
        ExecutionAttributes attributes = ExecutionAttributes.builder()
                .put(SdkExecutionAttribute.OPERATION_NAME, "TransactWriteItems")
                .put(SdkExecutionAttribute.SERVICE_NAME, "DynamoDb")
                .build();

        Exception exception = assertThrows(DynamoDbEncryptionException.class, () -> {
            interceptor.modifyRequest(context, attributes);
        });
        assertTrue(exception.getMessage().contains("Condition checks not allowed on encrypted tables (TransactWriteItems Delete)"));
    }

    @Test
    public void TestTransactWriteItemsWithUpdateOnEncryptedTable() {
        DynamoDbEncryptionInterceptor interceptor = createInterceptor();

        TransactWriteItemsRequest oldRequest = TransactWriteItemsRequest.builder()
                .transactItems(
                        TransactWriteItem.builder()
                                .update(Update.builder()
                                        .tableName(TEST_TABLE_NAME)
                                        .build())
                                .build())
                .build();

        Context.ModifyRequest context = InterceptorContext.builder()
                .request(oldRequest)
                .build();
        ExecutionAttributes attributes = ExecutionAttributes.builder()
                .put(SdkExecutionAttribute.OPERATION_NAME, "TransactWriteItems")
                .put(SdkExecutionAttribute.SERVICE_NAME, "DynamoDb")
                .build();

        Exception exception = assertThrows(DynamoDbEncryptionException.class, () -> {
            interceptor.modifyRequest(context, attributes);
        });
        assertTrue(exception.getMessage().contains("Updates not allowed on encrypted tables (TransactWriteItems Update)"));
    }

    @Test
    public void TestDeleteItemWithConditionExpression() {
        DynamoDbEncryptionInterceptor interceptor = createInterceptor();

        DeleteItemRequest oldRequest = DeleteItemRequest.builder()
                .tableName(TEST_TABLE_NAME)
                .conditionExpression("foo")
                .build();

        Context.ModifyRequest context = InterceptorContext.builder()
                .request(oldRequest)
                .build();
        ExecutionAttributes attributes = ExecutionAttributes.builder()
                .put(SdkExecutionAttribute.OPERATION_NAME, "DeleteItem")
                .put(SdkExecutionAttribute.SERVICE_NAME, "DynamoDb")
                .build();

        Exception exception = assertThrows(DynamoDbEncryptionException.class, () -> {
            interceptor.modifyRequest(context, attributes);
        });
        assertTrue(exception.getMessage().contains("Condition Expressions not supported in DeleteItem with Encryption."));
    }

    @Test
    public void TestDeleteItemWithConditionExpressionNonEncryptedTable() {
        DynamoDbEncryptionInterceptor interceptor = createInterceptor();

        DeleteItemRequest oldRequest = DeleteItemRequest.builder()
                .tableName("otherTable")
                .conditionExpression("foo")
                .build();

        Context.ModifyRequest context = InterceptorContext.builder()
                .request(oldRequest)
                .build();
        ExecutionAttributes attributes = ExecutionAttributes.builder()
                .put(SdkExecutionAttribute.OPERATION_NAME, "DeleteItem")
                .put(SdkExecutionAttribute.SERVICE_NAME, "DynamoDb")
                .build();

        SdkRequest newRequest = interceptor.modifyRequest(context, attributes);
        assertEquals(oldRequest, newRequest);
    }

    @Test
    public void TestExecuteStatementOnEncryptedTable() {
        DynamoDbEncryptionInterceptor interceptor = createInterceptor();

        ExecutionAttributes attributes = ExecutionAttributes.builder()
                .put(SdkExecutionAttribute.OPERATION_NAME, "ExecuteStatement")
                .put(SdkExecutionAttribute.SERVICE_NAME, "DynamoDb")
                .build();
        List<String> statementsWithEncryptedTable = Arrays.asList(
                String.format("EXISTS( SELECT * FROM \"%s\" WHERE \"Artist\" = 'Acme Band' AND \"SongTitle\" = 'PartiQL Rocks')", TEST_TABLE_NAME),
                String.format("INSERT INTO \"%s\" value {'Artist' : 'Acme Band','SongTitle' : 'PartiQL Rocks'}", TEST_TABLE_NAME),
                String.format("DELETE FROM \"%s\" WHERE \"Artist\" = 'Acme Band' AND \"SongTitle\" = 'PartiQL Rocks' RETURNING ALL OLD *", TEST_TABLE_NAME),
                String.format("SELECT OrderID, Total FROM \"%s\" WHERE OrderID IN [1, 2, 3] ORDER BY OrderID DESC", TEST_TABLE_NAME),
                String.format("SELECT Devices.FireStick.DateWatched[0] FROM %s WHERE CustomerID= 'C1' AND MovieID= 'M1'", TEST_TABLE_NAME),
                String.format("UPDATE \"%s\" SET AwardsWon=1 SET AwardDetail={'Grammys':[2020, 2018]}  WHERE Artist='Acme Band' AND SongTitle='PartiQL Rocks", TEST_TABLE_NAME)
        );

        for (String statement : statementsWithEncryptedTable) {
            ExecuteStatementRequest oldRequest = ExecuteStatementRequest.builder()
                    .statement(statement)
                    .build();
            Context.ModifyRequest context = InterceptorContext.builder()
                    .request(oldRequest)
                    .build();
            Exception exception = assertThrows(DynamoDbEncryptionException.class, () -> {
                interceptor.modifyRequest(context, attributes);
            });
            assertTrue(exception.getMessage().contains("ExecuteStatement not Supported on encrypted tables."));
        }
    }

    @Test
    public void TestExecuteStatementOnNonEncryptedTable() {
        DynamoDbEncryptionInterceptor interceptor = createInterceptor();

        ExecuteStatementRequest oldRequest = ExecuteStatementRequest.builder()
                .statement("SELECT * FROM otherTable")
                .build();

        Context.ModifyRequest context = InterceptorContext.builder()
                .request(oldRequest)
                .build();
        ExecutionAttributes attributes = ExecutionAttributes.builder()
                .put(SdkExecutionAttribute.OPERATION_NAME, "ExecuteStatement")
                .put(SdkExecutionAttribute.SERVICE_NAME, "DynamoDb")
                .build();

        SdkRequest newRequest = interceptor.modifyRequest(context, attributes);
        assertEquals(oldRequest, newRequest);
    }

    @Test
    public void TestUnknownOperationRequest() {
        DynamoDbEncryptionInterceptor interceptor = createInterceptor();

        Context.ModifyRequest context = InterceptorContext.builder()
                .request(PutItemRequest.builder().build())
                .build();
        ExecutionAttributes attributes = ExecutionAttributes.builder()
                .put(SdkExecutionAttribute.OPERATION_NAME, "UnknownOperation")
                .put(SdkExecutionAttribute.SERVICE_NAME, "DynamoDb")
                .build();

        Exception exception = assertThrows(DynamoDbEncryptionException.class, () -> {
            interceptor.modifyRequest(context, attributes);
        });
        assertTrue(exception.getMessage().contains("DynamoDbEncryptionInterceptor does not support use with unrecognized operation"));
    }

    @Test
    public void TestUnknownServiceRequest() {
        DynamoDbEncryptionInterceptor interceptor = createInterceptor();

        Context.ModifyRequest context = InterceptorContext.builder()
                .request(PutItemRequest.builder().build())
                .build();
        ExecutionAttributes attributes = ExecutionAttributes.builder()
                .put(SdkExecutionAttribute.OPERATION_NAME, "PutItem")
                .put(SdkExecutionAttribute.SERVICE_NAME, "OtherService")
                .build();

        Exception exception = assertThrows(DynamoDbEncryptionException.class, () -> {
            interceptor.modifyRequest(context, attributes);
        });
        assertTrue(exception.getMessage().contains("DynamoDbEncryptionInterceptor does not support use with services other than DynamoDb."));
    }

    @Test
    public void TestEmptyInterceptorBuild() {
        Exception exception = assertThrows(DynamoDbEncryptionException.class, () -> {
            DynamoDbEncryptionInterceptor.builder().build();
        });
        assertTrue(exception.getMessage().contains("Missing value for required field `config`"));
    }

    @Test
    public void TestPutWithInvalidCryptoAction() {
        DynamoDbEncryptionInterceptor interceptor = createInterceptor();

        Map<String, AttributeValue> item = createTestItem("foo", "10", "bar");
        // Add an attribute not modelled in the crypto schema
        item.put("attr2", AttributeValue.fromS("attr2"));
        PutItemRequest oldRequest = PutItemRequest.builder()
                .item(item)
                .tableName(TEST_TABLE_NAME)
                .build();

        Context.ModifyRequest context = InterceptorContext.builder()
                .request(oldRequest)
                .build();
        ExecutionAttributes attributes = ExecutionAttributes.builder()
                .put(SdkExecutionAttribute.OPERATION_NAME, "PutItem")
                .put(SdkExecutionAttribute.SERVICE_NAME, "DynamoDb")
                .build();

        Exception exception = assertThrows(DynamoDbItemEncryptorException.class, () -> {
            interceptor.modifyRequest(context, attributes);
        });
        assertTrue(exception.getMessage().contains("No Crypto Action configured for attribute"));
    }

    @Test
    public void TestPutMissingPartition() {
        DynamoDbEncryptionInterceptor interceptor = createInterceptor();

        Map<String, AttributeValue> item = createTestItem("foo", "10", "bar");
        // Remove partition key from item
        item.remove(TEST_PARTITION_NAME);
        PutItemRequest oldRequest = PutItemRequest.builder()
                .item(item)
                .tableName(TEST_TABLE_NAME)
                .build();

        Context.ModifyRequest context = InterceptorContext.builder()
                .request(oldRequest)
                .build();
        ExecutionAttributes attributes = ExecutionAttributes.builder()
                .put(SdkExecutionAttribute.OPERATION_NAME, "PutItem")
                .put(SdkExecutionAttribute.SERVICE_NAME, "DynamoDb")
                .build();

        Exception exception = assertThrows(DynamoDbItemEncryptorException.class, () -> {
            interceptor.modifyRequest(context, attributes);
        });
        assertTrue(exception.getMessage().contains(String.format("Partition key %s not found in Item to be encrypted or decrypted", TEST_PARTITION_NAME)));
    }

    @Test
    public void TestPutMissingSort() {
        DynamoDbEncryptionInterceptor interceptor = createInterceptor();

        Map<String, AttributeValue> item = createTestItem("foo", "10", "bar");
        // Remove partition key from item
        item.remove(TEST_SORT_NAME);
        PutItemRequest oldRequest = PutItemRequest.builder()
                .item(item)
                .tableName(TEST_TABLE_NAME)
                .build();

        Context.ModifyRequest context = InterceptorContext.builder()
                .request(oldRequest)
                .build();
        ExecutionAttributes attributes = ExecutionAttributes.builder()
                .put(SdkExecutionAttribute.OPERATION_NAME, "PutItem")
                .put(SdkExecutionAttribute.SERVICE_NAME, "DynamoDb")
                .build();

        Exception exception = assertThrows(DynamoDbItemEncryptorException.class, () -> {
            interceptor.modifyRequest(context, attributes);
        });
        assertTrue(exception.getMessage().contains(String.format("Sort key %s not found in Item to be encrypted or decrypted", TEST_SORT_NAME)));
    }
}
