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
import software.amazon.cryptography.materialProviders.model.MaterialProvidersConfig;
import software.amazon.cryptography.materialProviders.model.CreateAwsKmsMultiKeyringInput;
import Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring; // TODO resources
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.DynamoDbEncryptionMiddlewareInternal;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.DynamoDbEncryptionMiddlewareInternalConfig;
import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of {@link ExecutionInterceptor} with configurable wait times
 */
public class DynamoDbEncryptionInterceptor implements ExecutionInterceptor {

    static DynamoDbEncryptionMiddlewareInternal transformer;

    public DynamoDbEncryptionInterceptor() {
        // TODO passthrough inputs
        MaterialProviders matProv = MaterialProviders.builder().MaterialProvidersConfig(
            MaterialProvidersConfig.builder().build()
        ).build();
        CreateAwsKmsMultiKeyringInput keyringInput = CreateAwsKmsMultiKeyringInput.builder().generator("arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f").build();
        IKeyring kmsKeyring = matProv.CreateAwsKmsMultiKeyring(keyringInput);
        Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap();
        Map<String, CryptoAction> actions = new HashMap();
        actions.put("partition_key", CryptoAction.ENCRYPT_AND_SIGN);
        actions.put("sort_key", CryptoAction.SIGN_ONLY);
        actions.put("attr1", CryptoAction.DO_NOTHING);

        tableConfigs.put("gazelleJavaTestTable", DynamoDbTableEncryptionConfig.builder()
                .partitionKeyName("partition_key")
                .sortKeyName("sort_key")
                .attributeActions(actions)
                .keyring(kmsKeyring)
                .build());
        this.transformer = DynamoDbEncryptionMiddlewareInternal.builder()
                .DynamoDbEncryptionMiddlewareInternalConfig(
                    DynamoDbEncryptionMiddlewareInternalConfig.builder()
                            .tableEncryptionConfigs(tableConfigs)
                            .build())
                .build();
    }

    @Override
    public SdkRequest modifyRequest(Context.ModifyRequest context, ExecutionAttributes executionAttributes) {
        SdkRequest originalRequest = context.request();
        SdkRequest transformedRequest;
        if (originalRequest instanceof BatchExecuteStatementRequest) {
            transformedRequest = transformer.BatchExecuteStatementInputTransform(
                BatchExecuteStatementInputTransformInput.builder()
                    .sdkInput((BatchExecuteStatementRequest)originalRequest)
                    .build()).transformedInput();

        } else if (originalRequest instanceof BatchGetItemRequest) {
            transformedRequest = transformer.BatchGetItemInputTransform(
                 BatchGetItemInputTransformInput.builder()
                    .sdkInput((BatchGetItemRequest)originalRequest)
                    .build()).transformedInput();

        } else if (originalRequest instanceof BatchWriteItemRequest) {
            transformedRequest = transformer.BatchWriteItemInputTransform(
                 BatchWriteItemInputTransformInput.builder()
                    .sdkInput((BatchWriteItemRequest)originalRequest)
                    .build()).transformedInput();

        } else if (originalRequest instanceof ExecuteStatementRequest) {
            transformedRequest = transformer.ExecuteStatementInputTransform(
                 ExecuteStatementInputTransformInput.builder()
                    .sdkInput((ExecuteStatementRequest)originalRequest)
                    .build()).transformedInput();

        } else if (originalRequest instanceof ExecuteTransactionRequest) {
            transformedRequest = transformer.ExecuteTransactionInputTransform(
                 ExecuteTransactionInputTransformInput.builder()
                    .sdkInput((ExecuteTransactionRequest)originalRequest)
                    .build()).transformedInput();

        } else if (originalRequest instanceof GetItemRequest) {
            transformedRequest = transformer.GetItemInputTransform(
                 GetItemInputTransformInput.builder()
                    .sdkInput((GetItemRequest)originalRequest)
                    .build()).transformedInput();

        } else if (originalRequest instanceof PutItemRequest) {
            transformedRequest = transformer.PutItemInputTransform(
                 PutItemInputTransformInput.builder()
                    .sdkInput((PutItemRequest)originalRequest)
                    .build()).transformedInput();

        } else if (originalRequest instanceof QueryRequest) {
            transformedRequest = transformer.QueryInputTransform(
                 QueryInputTransformInput.builder()
                    .sdkInput((QueryRequest)originalRequest)
                    .build()).transformedInput();

        } else if (originalRequest instanceof ScanRequest) {
            transformedRequest = transformer.ScanInputTransform(
                 ScanInputTransformInput.builder()
                    .sdkInput((ScanRequest)originalRequest)
                    .build()).transformedInput();

        } else if (originalRequest instanceof TransactGetItemsRequest) {
            transformedRequest = transformer.TransactGetItemsInputTransform(
                 TransactGetItemsInputTransformInput.builder()
                    .sdkInput((TransactGetItemsRequest)originalRequest)
                    .build()).transformedInput();

        } else if (originalRequest instanceof TransactWriteItemsRequest) {
            transformedRequest = transformer.TransactWriteItemsInputTransform(
                 TransactWriteItemsInputTransformInput.builder()
                    .sdkInput((TransactWriteItemsRequest)originalRequest)
                    .build()).transformedInput();

        } else if (originalRequest instanceof UpdateItemRequest) {
            transformedRequest = transformer.UpdateItemInputTransform(
                 UpdateItemInputTransformInput.builder()
                    .sdkInput((UpdateItemRequest)originalRequest)
                    .build()).transformedInput();

        } else {
            // passthrough, but eventually we want to check against list on ok APIs to passthrough and error otherwise
            transformedRequest = originalRequest;
        }
        return transformedRequest;
    }

    @Override
    public SdkResponse modifyResponse(Context.ModifyResponse context, ExecutionAttributes executionAttributes) {
        SdkResponse originalResponse = context.response();
        SdkRequest originalRequest = context.request();
        SdkResponse transformedResponse;
        if (originalResponse instanceof BatchExecuteStatementResponse) {
            transformedResponse = transformer.BatchExecuteStatementOutputTransform(
                BatchExecuteStatementOutputTransformInput.builder()
                    .sdkOutput((BatchExecuteStatementResponse)originalResponse)
                    .originalInput((BatchExecuteStatementRequest)originalRequest)
                    .build()).transformedOutput();

        } else if (originalResponse instanceof BatchGetItemResponse) {
            transformedResponse = transformer.BatchGetItemOutputTransform(
                 BatchGetItemOutputTransformInput.builder()
                    .sdkOutput((BatchGetItemResponse)originalResponse)
                    .originalInput((BatchGetItemRequest)originalRequest)
                    .build()).transformedOutput();

        } else if (originalResponse instanceof BatchWriteItemResponse) {
            transformedResponse = transformer.BatchWriteItemOutputTransform(
                 BatchWriteItemOutputTransformInput.builder()
                    .sdkOutput((BatchWriteItemResponse)originalResponse)
                    .originalInput((BatchWriteItemRequest)originalRequest)
                    .build()).transformedOutput();

        } else if (originalResponse instanceof ExecuteStatementResponse) {
            transformedResponse = transformer.ExecuteStatementOutputTransform(
                 ExecuteStatementOutputTransformInput.builder()
                    .sdkOutput((ExecuteStatementResponse)originalResponse)
                    .originalInput((ExecuteStatementRequest)originalRequest)
                    .build()).transformedOutput();

        } else if (originalResponse instanceof ExecuteTransactionResponse) {
            transformedResponse = transformer.ExecuteTransactionOutputTransform(
                 ExecuteTransactionOutputTransformInput.builder()
                    .sdkOutput((ExecuteTransactionResponse)originalResponse)
                    .originalInput((ExecuteTransactionRequest)originalRequest)
                    .build()).transformedOutput();

        } else if (originalResponse instanceof GetItemResponse) {
            transformedResponse = transformer.GetItemOutputTransform(
                 GetItemOutputTransformInput.builder()
                    .sdkOutput((GetItemResponse)originalResponse)
                    .originalInput((GetItemRequest)originalRequest)
                    .build()).transformedOutput();

        } else if (originalResponse instanceof PutItemResponse) {
            transformedResponse = transformer.PutItemOutputTransform(
                 PutItemOutputTransformInput.builder()
                    .sdkOutput((PutItemResponse)originalResponse)
                    .originalInput((PutItemRequest)originalRequest)
                    .build()).transformedOutput();

        } else if (originalResponse instanceof QueryResponse) {
            transformedResponse = transformer.QueryOutputTransform(
                 QueryOutputTransformInput.builder()
                    .sdkOutput((QueryResponse)originalResponse)
                    .originalInput((QueryRequest)originalRequest)
                    .build()).transformedOutput();

        } else if (originalResponse instanceof ScanResponse) {
            transformedResponse = transformer.ScanOutputTransform(
                 ScanOutputTransformInput.builder()
                    .sdkOutput((ScanResponse)originalResponse)
                    .originalInput((ScanRequest)originalRequest)
                    .build()).transformedOutput();

        } else if (originalResponse instanceof TransactGetItemsResponse) {
            transformedResponse = transformer.TransactGetItemsOutputTransform(
                 TransactGetItemsOutputTransformInput.builder()
                    .sdkOutput((TransactGetItemsResponse)originalResponse)
                    .originalInput((TransactGetItemsRequest)originalRequest)
                    .build()).transformedOutput();

        } else if (originalResponse instanceof TransactWriteItemsResponse) {
            transformedResponse = transformer.TransactWriteItemsOutputTransform(
                 TransactWriteItemsOutputTransformInput.builder()
                    .sdkOutput((TransactWriteItemsResponse)originalResponse)
                    .originalInput((TransactWriteItemsRequest)originalRequest)
                    .build()).transformedOutput();

        } else if (originalResponse instanceof UpdateItemResponse) {
            transformedResponse = transformer.UpdateItemOutputTransform(
                 UpdateItemOutputTransformInput.builder()
                    .sdkOutput((UpdateItemResponse)originalResponse)
                    .originalInput((UpdateItemRequest)originalRequest)
                    .build()).transformedOutput();

        } else {
            // passthrough, but eventually we want to check against list on ok APIs to passthrough and error otherwise
            transformedResponse = originalResponse;
        }
        return transformedResponse;
    }
}
