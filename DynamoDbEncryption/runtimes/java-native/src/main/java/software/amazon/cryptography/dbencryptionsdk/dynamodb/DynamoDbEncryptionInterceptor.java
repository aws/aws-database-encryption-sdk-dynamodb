// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb;

import java.util.HashMap;
import java.util.Map;
import software.amazon.awssdk.core.SdkRequest;
import software.amazon.awssdk.core.SdkResponse;
import software.amazon.awssdk.core.interceptor.Context;
import software.amazon.awssdk.core.interceptor.ExecutionAttribute;
import software.amazon.awssdk.core.interceptor.ExecutionAttributes;
import software.amazon.awssdk.core.interceptor.ExecutionInterceptor;
import software.amazon.awssdk.core.interceptor.SdkExecutionAttribute;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemResponse;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemResponse;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;
import software.amazon.awssdk.services.dynamodb.model.QueryResponse;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;
import software.amazon.awssdk.services.dynamodb.model.TransactWriteItemsRequest;
import software.amazon.awssdk.services.dynamodb.model.TransactWriteItemsResponse;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DbeException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.DdbMiddlewareConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.DdbTransforms;

/**
 * AWS SDK v2 ExecutionInterceptor that transparently encrypts/decrypts
 * DynamoDB items during API calls.
 *
 * <p>Usage:
 * <pre>
 * DynamoDbClient client = DynamoDbClient.builder()
 *     .overrideConfiguration(c -> c.addExecutionInterceptor(
 *         DynamoDbEncryptionInterceptor.create(tableConfigs)))
 *     .build();
 * </pre>
 */
public final class DynamoDbEncryptionInterceptor implements ExecutionInterceptor {

    private static final ExecutionAttribute<SdkRequest> ORIGINAL_REQUEST =
        new ExecutionAttribute<>("DbEsdk_OriginalRequest");

    private final DdbMiddlewareConfig config;

    private DynamoDbEncryptionInterceptor(DdbMiddlewareConfig config) {
        this.config = config;
    }

    /**
     * Create an interceptor from a map of table names to encryptor configs.
     */
    public static DynamoDbEncryptionInterceptor create(
            Map<String, DynamoDbItemEncryptorConfig> tableConfigs) {
        Map<String, DynamoDbItemEncryptor> encryptors = new HashMap<>();
        for (Map.Entry<String, DynamoDbItemEncryptorConfig> entry : tableConfigs.entrySet()) {
            encryptors.put(entry.getKey(), DynamoDbItemEncryptor.create(entry.getValue()));
        }
        return new DynamoDbEncryptionInterceptor(new DdbMiddlewareConfig(encryptors));
    }

    /**
     * Create an interceptor from a pre-built middleware config.
     */
    public static DynamoDbEncryptionInterceptor create(DdbMiddlewareConfig config) {
        return new DynamoDbEncryptionInterceptor(config);
    }

    @Override
    public SdkRequest modifyRequest(Context.ModifyRequest context, ExecutionAttributes attrs) {
        SdkRequest request = context.request();
        attrs.putAttribute(ORIGINAL_REQUEST, request);

        String operation = attrs.getAttribute(SdkExecutionAttribute.OPERATION_NAME);
        if (operation == null) return request;

        switch (operation) {
            case "PutItem":
                return DdbTransforms.putItemInput(config, (PutItemRequest) request);
            case "GetItem":
                return DdbTransforms.getItemInput(config, (GetItemRequest) request);
            case "Query":
                return DdbTransforms.queryInput(config, (QueryRequest) request);
            case "Scan":
                return DdbTransforms.scanInput(config, (ScanRequest) request);
            case "BatchWriteItem":
                return DdbTransforms.batchWriteInput(config, (BatchWriteItemRequest) request);
            case "TransactWriteItems":
                return DdbTransforms.transactWriteInput(config, (TransactWriteItemsRequest) request);
            case "DeleteItem":
                return DdbTransforms.deleteItemInput(config, (DeleteItemRequest) request);
            case "UpdateItem":
                return DdbTransforms.updateItemInput(config, (UpdateItemRequest) request);
            default:
                return request;
        }
    }

    @Override
    public SdkResponse modifyResponse(Context.ModifyResponse context, ExecutionAttributes attrs) {
        SdkResponse response = context.response();
        SdkRequest originalRequest = attrs.getAttribute(ORIGINAL_REQUEST);

        String operation = attrs.getAttribute(SdkExecutionAttribute.OPERATION_NAME);
        if (operation == null) return response;

        switch (operation) {
            case "PutItem":
                return DdbTransforms.putItemOutput(
                    config, (PutItemResponse) response, (PutItemRequest) originalRequest);
            case "GetItem":
                return DdbTransforms.getItemOutput(
                    config, (GetItemResponse) response, (GetItemRequest) originalRequest);
            case "Query":
                return DdbTransforms.queryOutput(
                    config, (QueryResponse) response, (QueryRequest) originalRequest);
            case "Scan":
                return DdbTransforms.scanOutput(
                    config, (ScanResponse) response, (ScanRequest) originalRequest);
            case "BatchGetItem":
                return DdbTransforms.batchGetOutput(config, (BatchGetItemResponse) response);
            case "DeleteItem":
                return DdbTransforms.deleteItemOutput(
                    config, (DeleteItemResponse) response, (DeleteItemRequest) originalRequest);
            default:
                return response;
        }
    }
}
