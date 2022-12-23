package software.aws.cryptography.dynamodbencryption;

import software.amazon.awssdk.core.interceptor.Context;
import software.amazon.awssdk.core.interceptor.ExecutionAttributes;
import software.amazon.awssdk.core.interceptor.ExecutionInterceptor;
import software.amazon.awssdk.core.SdkRequest;
import software.amazon.awssdk.core.SdkResponse;

import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.UpdateItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.TransactWriteItemsOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.TransactGetItemsOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.ScanOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.QueryOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.PutItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.GetItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.ExecuteTransactionOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.ExecuteStatementOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.BatchWriteItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.BatchGetItemOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.BatchExecuteStatementOutputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.UpdateItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.TransactWriteItemsInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.TransactGetItemsInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.ScanInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.QueryInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.PutItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.GetItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.ExecuteTransactionInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.ExecuteStatementInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.BatchWriteItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.BatchGetItemInputTransformInput;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.BatchExecuteStatementInputTransformInput;

import software.amazon.awssdk.services.dynamodb.model.UpdateItemResponse;
import software.amazon.awssdk.services.dynamodb.model.TransactWriteItemsResponse;
import software.amazon.awssdk.services.dynamodb.model.TransactGetItemsResponse;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;
import software.amazon.awssdk.services.dynamodb.model.QueryResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.ExecuteTransactionResponse;
import software.amazon.awssdk.services.dynamodb.model.ExecuteStatementResponse;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemResponse;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.BatchExecuteStatementResponse;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;
import software.amazon.awssdk.services.dynamodb.model.TransactWriteItemsRequest;
import software.amazon.awssdk.services.dynamodb.model.TransactGetItemsRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.ExecuteTransactionRequest;
import software.amazon.awssdk.services.dynamodb.model.ExecuteStatementRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchExecuteStatementRequest;

import software.amazon.cryptography.materialProviders.MaterialProviders;
import software.amazon.cryptography.materialProviders.model.CreateAwsKmsMultiKeyringInput;
import Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring; // TODO resources
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.DynamoDbEncryptionMiddlewareInternal;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.DynamoDbEncryptionMiddlewareInternalConfig;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
/**
 * Implementation of {@link ExecutionInterceptor} with configurable wait times
 */
public class DynamoDbEncryptionInterceptorTest {

    @Test
    public void TestEnd2End() {
        // TODO passthrough inputs
        DynamoDbEncryptionInterceptor interceptor = new DynamoDbEncryptionInterceptor(); // TODO builders
        DynamoDbClient ddb = DynamoDbClient.builder()
            .overrideConfiguration(
                ClientOverrideConfiguration.builder()
                    .addExecutionInterceptor(interceptor)
                    .build())
            .build();
        
        // Put Item into Table
        HashMap<String,AttributeValue> itemValues = new HashMap<String,AttributeValue>();

        // Add all content to the table
        itemValues.put("partition_key", AttributeValue.builder().s("foo1").build());
        itemValues.put("sort_key", AttributeValue.builder().n("42").build());
        itemValues.put("attr1", AttributeValue.builder().s("bar").build());

        PutItemRequest request = PutItemRequest.builder()
                .tableName("gazelleJavaTestTable")
                .item(itemValues)
                .build();

        ddb.putItem(request);

        // Get Item From Table
        HashMap<String,AttributeValue> keyToGet = new HashMap<String,AttributeValue>();

        keyToGet.put("partition_key", AttributeValue.builder().s("foo").build());
        keyToGet.put("sort_key", AttributeValue.builder().n("42").build());

        GetItemRequest request2 = GetItemRequest.builder()
                .key(keyToGet)
                .tableName("gazelleJavaTestTable")
                .build();

        GetItemResponse response = ddb.getItem(request2);
        Map<String, AttributeValue> returnedItem = response.item();
        assertNotNull(returnedItem);
        assertEquals("bar", returnedItem.get("attr1").s());
    }
}
