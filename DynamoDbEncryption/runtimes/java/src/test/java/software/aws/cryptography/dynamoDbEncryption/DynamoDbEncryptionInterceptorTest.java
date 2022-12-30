package software.aws.cryptography.dynamoDbEncryption;

import org.junit.jupiter.api.BeforeAll;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.core.SdkRequest;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.core.interceptor.*;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
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
import static software.aws.cryptography.dynamoDbEncryption.TestUtils.*;

public class DynamoDbEncryptionInterceptorTest {
    static DynamoDbEncryptionInterceptor interceptor;

    @BeforeAll
    public static void setup() {
        interceptor = createInterceptor(createStaticKeyring());
    }

    @Test
    public void TestPutItemGetItemWithConditionExpression() {
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
        UpdateItemRequest oldRequest = UpdateItemRequest.builder()
                .tableName("otherTable")
                .key(Collections.EMPTY_MAP) // TODO another case where 'key' is required by the server but not checked client side
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
        DeleteItemRequest oldRequest = DeleteItemRequest.builder()
                .tableName("otherTable")
                .key(Collections.EMPTY_MAP) // TODO another case where 'key' is required by the server but not checked client side
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
