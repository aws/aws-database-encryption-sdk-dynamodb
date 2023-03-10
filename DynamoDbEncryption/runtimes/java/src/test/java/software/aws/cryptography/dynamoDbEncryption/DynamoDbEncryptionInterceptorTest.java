package software.aws.cryptography.dynamoDbEncryption;

import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionFlags;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.DirectKmsMaterialProvider;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import org.junit.jupiter.api.BeforeAll;
import software.amazon.awssdk.core.SdkRequest;
import software.amazon.awssdk.core.interceptor.*;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.*;

import org.junit.jupiter.api.Test;
import software.amazon.cryptography.dynamoDbEncryption.model.*;
import software.amazon.cryptography.dynamoDbItemEncryptor.model.DynamoDbItemEncryptorException;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;

import static org.junit.jupiter.api.Assertions.*;
import static software.aws.cryptography.dynamoDbEncryption.TestUtils.*;

public class DynamoDbEncryptionInterceptorTest {
    static DynamoDbEncryptionInterceptor interceptor;

    @BeforeAll
    public static void setup() {
        interceptor = createInterceptor(createKmsKeyring());
    }

    @Test
    public void TestPutItemEncryptsAccordingToAttributeActions() {
        String partitionValue = "foo";
        String sortValue = "42";
        String attrValue = "encrypt";
        String attrValue2 = "do nothing";
        Map<String, AttributeValue> item = createTestItem(partitionValue, sortValue, attrValue, attrValue2);

        PutItemRequest oldRequest = PutItemRequest.builder()
                .tableName(TEST_TABLE_NAME)
                .item(item)
                .build();

        Context.ModifyRequest context = InterceptorContext.builder()
                .request(oldRequest)
                .build();
        ExecutionAttributes attributes = ExecutionAttributes.builder()
                .put(SdkExecutionAttribute.OPERATION_NAME, "PutItem")
                .put(SdkExecutionAttribute.SERVICE_NAME, "DynamoDb")
                .build();

        SdkRequest newRequest = interceptor.modifyRequest(context, attributes);
        assertTrue(newRequest instanceof PutItemRequest);

        // ENCRYPT_AND_SIGN results in changed attribute
        assertNotEquals(oldRequest.item().get(TEST_ATTR_NAME), ((PutItemRequest) newRequest).item().get(TEST_ATTR_NAME));

        // SIGN_ONLY and DO_NOTHING does not modify any attribute values
        assertEquals(oldRequest.item().get(TEST_ATTR2_NAME), ((PutItemRequest) newRequest).item().get(TEST_ATTR2_NAME));
        assertEquals(oldRequest.item().get(TEST_PARTITION_NAME), ((PutItemRequest) newRequest).item().get(TEST_PARTITION_NAME));
        assertEquals(oldRequest.item().get(TEST_SORT_NAME), ((PutItemRequest) newRequest).item().get(TEST_SORT_NAME));
    }

    @Test
    public void TestInterceptorBuilderAcceptsLegacyEncryptor() {
        Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
        Map<String, CryptoAction> actions = new HashMap<>();
        actions.put(TEST_PARTITION_NAME, CryptoAction.SIGN_ONLY);
        actions.put(TEST_SORT_NAME, CryptoAction.SIGN_ONLY);
        actions.put(TEST_ATTR_NAME, CryptoAction.ENCRYPT_AND_SIGN);

        // Legacy Encryptor creation
        AWSKMS kmsClient = AWSKMSClientBuilder.standard().build();
        final DirectKmsMaterialProvider cmp = new DirectKmsMaterialProvider(kmsClient, "kmsKeyARN");
        final DynamoDBEncryptor oldEncryptor = DynamoDBEncryptor.getInstance(cmp);
        final Map<String, Set<EncryptionFlags>> oldActions = new HashMap<>();

        DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig.builder()
                .partitionKeyName(TEST_PARTITION_NAME)
                .sortKeyName(TEST_SORT_NAME)
                .attributeActions(actions)
                .keyring(createKmsKeyring())
                /*.legacyConfig(
                    LegacyConfig.builder()
                        .legacyEncryptor(LegacyDynamoDbItemEncryptor.builder()
                                .encryptor(oldEncryptor)
                                .attributeFlags(oldActions)
                                .build())
                        .legacyPolicy(LegacyPolicy.REQUIRE_ENCRYPT_ALLOW_DECRYPT)
                        .build())*/
                .build();
        tableConfigs.put(TEST_TABLE_NAME, config);

        DynamoDbEncryptionInterceptor interceptor = DynamoDbEncryptionInterceptor.builder()
                .config(DynamoDbEncryptionConfig.builder()
                        .tableEncryptionConfigs(tableConfigs)
                        .build())
                .build();
        assertNotNull(interceptor);
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
    public void TestBadCryptoActionOnPartitionKey() {
        Map<String, CryptoAction> actions = new HashMap<>();
        actions.put(TEST_PARTITION_NAME, CryptoAction.ENCRYPT_AND_SIGN);
        actions.put(TEST_SORT_NAME, CryptoAction.SIGN_ONLY);
        actions.put(TEST_ATTR_NAME, CryptoAction.DO_NOTHING);
        List<String> allowedUnauth = Arrays.asList(TEST_ATTR_NAME);

        // TODO: Exception SHOULD be `DynamoDbItemEncryptorException.class`
        // https://sim.amazon.com/issues/4bde0b7b-12fd-4d05-8f8c-a9f1dbda01da
        Exception exception = assertThrows(OpaqueError.class, () -> {
            createInterceptor(actions, allowedUnauth, createKmsKeyring());
        });
        //assertTrue(exception.getMessage().contains("Partition key attribute action MUST be SIGN_ONLY"));
    }

    @Test
    public void TestBadCryptoActionOnSortKey() {
        Map<String, CryptoAction> actions = new HashMap<>();
        actions.put(TEST_PARTITION_NAME, CryptoAction.SIGN_ONLY);
        actions.put(TEST_SORT_NAME, CryptoAction.ENCRYPT_AND_SIGN);
        actions.put(TEST_ATTR_NAME, CryptoAction.DO_NOTHING);
        List<String> allowedUnauth = Arrays.asList(TEST_ATTR_NAME);

        // TODO: Exception SHOULD be `DynamoDbItemEncryptorException.class`
        // https://sim.amazon.com/issues/4bde0b7b-12fd-4d05-8f8c-a9f1dbda01da
        Exception exception = assertThrows(OpaqueError.class, () -> {
            createInterceptor(actions, allowedUnauth, createKmsKeyring());
        });
        //assertTrue(exception.getMessage().contains("Sort key attribute action MUST be SIGN_ONLY"));
    }

    @Test
    public void TestInconsistentSignatureScope() {
        Map<String, CryptoAction> actions = new HashMap<>();
        actions.put(TEST_PARTITION_NAME, CryptoAction.SIGN_ONLY);
        actions.put(TEST_SORT_NAME, CryptoAction.SIGN_ONLY);
        actions.put(TEST_ATTR_NAME, CryptoAction.DO_NOTHING);
        List<String> allowedUnauth = Arrays.asList();

        // TODO: Exception SHOULD be `DynamoDbItemEncryptorException.class`
        // https://sim.amazon.com/issues/4bde0b7b-12fd-4d05-8f8c-a9f1dbda01da
        Exception exception = assertThrows(OpaqueError.class, () -> {
            createInterceptor(actions, allowedUnauth, createKmsKeyring());
        });
        // assertTrue(exception.getMessage().contains(String.format("Attribute: %s configuration not compatible with unauthenticated configuration.", TEST_ATTR_NAME)));

        List<String> allowedUnauth2 = Arrays.asList(TEST_ATTR_NAME, TEST_SORT_NAME);

        // TODO: Exception SHOULD be `DynamoDbItemEncryptorException.class`
        // https://sim.amazon.com/issues/4bde0b7b-12fd-4d05-8f8c-a9f1dbda01da
        Exception exception2 = assertThrows(OpaqueError.class, () -> {
            createInterceptor(actions, allowedUnauth2, createKmsKeyring());
        });
        //assertTrue(exception2.getMessage().contains(String.format("Attribute: %s configuration not compatible with unauthenticated configuration.", TEST_SORT_NAME)));
    }

    @Test
    public void TestPutWithInvalidCryptoAction() {
        Map<String, AttributeValue> item = createTestItem("foo", "10", "bar", "awol");
        // Add an attribute not modelled in the crypto schema
        item.put("attr3", AttributeValue.fromS("attr3"));
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

        // TODO: Exception SHOULD be `DynamoDbItemEncryptorException.class`
        // https://sim.amazon.com/issues/4bde0b7b-12fd-4d05-8f8c-a9f1dbda01da
        Exception exception = assertThrows(OpaqueError.class, () -> {
            interceptor.modifyRequest(context, attributes);
        });
        //assertTrue(exception.getMessage().contains("No Crypto Action configured for attribute"));
    }

    @Test
    public void TestPutMissingPartition() {
        Map<String, AttributeValue> item = createTestItem("foo", "10", "bar", "awol");
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

        // TODO: Exception SHOULD be `DynamoDbItemEncryptorException.class`
        // https://sim.amazon.com/issues/4bde0b7b-12fd-4d05-8f8c-a9f1dbda01da
        Exception exception = assertThrows(OpaqueError.class, () -> {
            interceptor.modifyRequest(context, attributes);
        });
        //assertTrue(exception.getMessage().contains(String.format("Partition key %s not found in Item to be encrypted or decrypted", TEST_PARTITION_NAME)));
    }

    @Test
    public void TestPutMissingSort() {
        Map<String, AttributeValue> item = createTestItem("foo", "10", "bar", "awol");
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

        // TODO: Exception SHOULD be `DynamoDbItemEncryptorException.class`
        // https://sim.amazon.com/issues/4bde0b7b-12fd-4d05-8f8c-a9f1dbda01da
        Exception exception = assertThrows(OpaqueError.class, () -> {
            interceptor.modifyRequest(context, attributes);
        });
        //assertTrue(exception.getMessage().contains(String.format("Sort key %s not found in Item to be encrypted or decrypted", TEST_SORT_NAME)));
    }
}
