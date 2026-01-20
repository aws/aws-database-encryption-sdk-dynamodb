/*
 * Copyright 2014-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package software.amazon.cryptools.dynamodbencryptionclientsdk2.interceptor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import software.amazon.awssdk.core.ClientType;
import software.amazon.awssdk.core.SdkRequest;
import software.amazon.awssdk.core.SdkResponse;
import software.amazon.awssdk.core.interceptor.Context;
import software.amazon.awssdk.core.interceptor.ExecutionAttributes;
import software.amazon.awssdk.core.interceptor.ExecutionInterceptor;
import software.amazon.awssdk.core.interceptor.SdkExecutionAttribute;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.DynamoDBEncryptor;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionContext;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionFlags;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.exceptions.DynamoDbEncryptionException;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.EncryptionMaterialsProvider;

/**
 * Implementation of {@link ExecutionInterceptor} that enables client side encryption with DynamoDb
 * using the DynamoDB Encryption Client (DDBEC) for Java SDK v2.
 * 
 * This interceptor supports the same operations as the SDK v1 DynamoDBMapper:
 * PutItem, GetItem, DeleteItem, Query, Scan, BatchGetItem, BatchWriteItem
 * 
 * Usage:
 * <pre>
 * // Create DDBEC materials provider
 * DirectKmsMaterialsProvider materialProvider = new DirectKmsMaterialsProvider(kmsClient, kmsKeyId);
 * 
 * // Create attribute flags map
 * Map&lt;String, Set&lt;EncryptionFlags&gt;&gt; attributeFlags = new HashMap&lt;&gt;();
 * attributeFlags.put("partition_key", EnumSet.of(EncryptionFlags.SIGN));
 * attributeFlags.put("sort_key", EnumSet.of(EncryptionFlags.SIGN));
 * attributeFlags.put("attribute1", EnumSet.of(EncryptionFlags.ENCRYPT, EncryptionFlags.SIGN));
 * attributeFlags.put("attribute2", EnumSet.of(EncryptionFlags.SIGN));
 * attributeFlags.put("attribute3", EnumSet.noneOf(EncryptionFlags.class));
 * 
 * // Create interceptor
 * DynamoDbEncryptionInterceptor interceptor = DynamoDbEncryptionInterceptor.builder()
 *     .tableName("MyTable")
 *     .partitionKeyName("partition_key")
 *     .sortKeyName("sort_key")
 *     .materialProvider(materialProvider)
 *     .attributeFlags(attributeFlags)
 *     .build();
 * 
 * // Add to DynamoDB client
 * DynamoDbClient client = DynamoDbClient.builder()
 *     .overrideConfiguration(ClientOverrideConfiguration.builder()
 *         .addExecutionInterceptor(interceptor)
 *         .build())
 *     .build();
 * </pre>
 */
public class DDBECInterceptor implements ExecutionInterceptor {

    private final String tableName;
    private final String partitionKeyName;
    private final String sortKeyName;
    private final DynamoDBEncryptor encryptor;
    private final Map<String, Set<EncryptionFlags>> attributeFlags;

    // Operations supported by SDK v1 DynamoDBMapper
    private static final List<String> SUPPORTED_OPERATIONS = Arrays.asList(
        "PutItem", "GetItem", "DeleteItem", "Query", "Scan", "BatchGetItem", "BatchWriteItem"
    );

    private static final String DDB_SERVICE_NAME = "DynamoDb";

    private DDBECInterceptor(Builder builder) {
        this.tableName = builder.tableName;
        this.partitionKeyName = builder.partitionKeyName;
        this.sortKeyName = builder.sortKeyName;
        this.encryptor = DynamoDBEncryptor.getInstance(builder.materialProvider);
        this.attributeFlags = builder.attributeFlags;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public SdkRequest modifyRequest(Context.ModifyRequest context, ExecutionAttributes executionAttributes) {
        SdkRequest originalRequest = context.request();

        // Validate service
        if (!DDB_SERVICE_NAME.equals(executionAttributes.getAttribute(SdkExecutionAttribute.SERVICE_NAME))) {
            throw new DynamoDbEncryptionException(
                "DynamoDbEncryptionInterceptor only supports DynamoDB operations"
            );
        }

        // Validate client type
        if (!ClientType.SYNC.equals(executionAttributes.getAttribute(SdkExecutionAttribute.CLIENT_TYPE))) {
            throw new DynamoDbEncryptionException(
                "DynamoDbEncryptionInterceptor only supports synchronous DynamoDB clients"
            );
        }

        String operationName = executionAttributes.getAttribute(SdkExecutionAttribute.OPERATION_NAME);
        
        // Check if operation is supported
        if (!SUPPORTED_OPERATIONS.contains(operationName)) {
            throw new DynamoDbEncryptionException(
                "Operation " + operationName + " is not supported. Supported operations: " + SUPPORTED_OPERATIONS
            );
        }

        try {
            switch (operationName) {
                case "PutItem":
                    return handlePutItemRequest((PutItemRequest) originalRequest);
                case "BatchWriteItem":
                    return handleBatchWriteItemRequest((BatchWriteItemRequest) originalRequest);
                default:
                    return originalRequest;
            }
        } catch (Exception e) {
            throw new DynamoDbEncryptionException("Failed to encrypt request", e);
        }
    }

    @Override
    public SdkResponse modifyResponse(Context.ModifyResponse context, ExecutionAttributes executionAttributes) {
        SdkResponse originalResponse = context.response();
        String operationName = executionAttributes.getAttribute(SdkExecutionAttribute.OPERATION_NAME);

        try {
            switch (operationName) {
                case "GetItem":
                    return handleGetItemResponse((GetItemResponse) originalResponse);
                case "Query":
                    return handleQueryResponse((QueryResponse) originalResponse);
                case "Scan":
                    return handleScanResponse((ScanResponse) originalResponse);
                case "BatchGetItem":
                    return handleBatchGetItemResponse((BatchGetItemResponse) originalResponse);
                default:
                    return originalResponse;
            }
        } catch (Exception e) {
            throw new DynamoDbEncryptionException("Failed to decrypt response", e);
        }
    }

    private PutItemRequest handlePutItemRequest(PutItemRequest request) throws Exception {
        if (!tableName.equals(request.tableName())) {
            return request; // Different table, don't encrypt
        }

        EncryptionContext context = EncryptionContext.builder()
            .tableName(request.tableName())
            .hashKeyName(partitionKeyName)
            .rangeKeyName(sortKeyName)
            .build();

        Map<String, AttributeValue> encryptedItem = encryptor.encryptRecord(
            request.item(), attributeFlags, context
        );

        return request.toBuilder().item(encryptedItem).build();
    }

    private BatchWriteItemRequest handleBatchWriteItemRequest(BatchWriteItemRequest request) throws Exception {
        Map<String, List<WriteRequest>> requestItems = new HashMap<>(request.requestItems());
        
        if (requestItems.containsKey(tableName)) {
            EncryptionContext context = EncryptionContext.builder()
                .tableName(tableName)
                .hashKeyName(partitionKeyName)
                .rangeKeyName(sortKeyName)
                .build();

            List<WriteRequest> writeRequests = requestItems.get(tableName);
            List<WriteRequest> encryptedRequests = new java.util.ArrayList<>();
            
            for (WriteRequest writeRequest : writeRequests) {
                if (writeRequest.putRequest() != null) {
                    Map<String, AttributeValue> encryptedItem = encryptor.encryptRecord(
                        writeRequest.putRequest().item(), attributeFlags, context
                    );
                    
                    PutRequest encryptedPutRequest = writeRequest.putRequest().toBuilder()
                        .item(encryptedItem)
                        .build();
                    
                    encryptedRequests.add(writeRequest.toBuilder()
                        .putRequest(encryptedPutRequest)
                        .build());
                } else {
                    encryptedRequests.add(writeRequest);
                }
            }
            
            requestItems.put(tableName, encryptedRequests);
        }

        return request.toBuilder().requestItems(requestItems).build();
    }

    private GetItemResponse handleGetItemResponse(GetItemResponse response) throws Exception {
        if (response.item() == null || response.item().isEmpty()) {
            return response;
        }

        EncryptionContext context = EncryptionContext.builder()
            .tableName(tableName)
            .hashKeyName(partitionKeyName)
            .rangeKeyName(sortKeyName)
            .build();

        Map<String, AttributeValue> decryptedItem = encryptor.decryptRecord(
            response.item(), attributeFlags, context
        );

        return response.toBuilder().item(decryptedItem).build();
    }

    private QueryResponse handleQueryResponse(QueryResponse response) throws Exception {
        if (response.items() == null || response.items().isEmpty()) {
            return response;
        }

        EncryptionContext context = EncryptionContext.builder()
            .tableName(tableName)
            .hashKeyName(partitionKeyName)
            .rangeKeyName(sortKeyName)
            .build();

        List<Map<String, AttributeValue>> decryptedItems = new java.util.ArrayList<>();
        for (Map<String, AttributeValue> item : response.items()) {
            Map<String, AttributeValue> decryptedItem = encryptor.decryptRecord(
                item, attributeFlags, context
            );
            decryptedItems.add(decryptedItem);
        }

        return response.toBuilder().items(decryptedItems).build();
    }

    private ScanResponse handleScanResponse(ScanResponse response) throws Exception {
        if (response.items() == null || response.items().isEmpty()) {
            return response;
        }

        EncryptionContext context = EncryptionContext.builder()
            .tableName(tableName)
            .hashKeyName(partitionKeyName)
            .rangeKeyName(sortKeyName)
            .build();

        List<Map<String, AttributeValue>> decryptedItems = new java.util.ArrayList<>();
        for (Map<String, AttributeValue> item : response.items()) {
            Map<String, AttributeValue> decryptedItem = encryptor.decryptRecord(
                item, attributeFlags, context
            );
            decryptedItems.add(decryptedItem);
        }

        return response.toBuilder().items(decryptedItems).build();
    }

    private BatchGetItemResponse handleBatchGetItemResponse(BatchGetItemResponse response) throws Exception {
        if (response.responses() == null || !response.responses().containsKey(tableName)) {
            return response;
        }

        EncryptionContext context = EncryptionContext.builder()
            .tableName(tableName)
            .hashKeyName(partitionKeyName)
            .rangeKeyName(sortKeyName)
            .build();

        Map<String, List<Map<String, AttributeValue>>> responses = new HashMap<>(response.responses());
        List<Map<String, AttributeValue>> items = responses.get(tableName);
        
        if (items != null && !items.isEmpty()) {
            List<Map<String, AttributeValue>> decryptedItems = new java.util.ArrayList<>();
            for (Map<String, AttributeValue> item : items) {
                Map<String, AttributeValue> decryptedItem = encryptor.decryptRecord(
                    item, attributeFlags, context
                );
                decryptedItems.add(decryptedItem);
            }
            responses.put(tableName, decryptedItems);
        }

        return response.toBuilder().responses(responses).build();
    }

    public static class Builder {
        private String tableName;
        private String partitionKeyName;
        private String sortKeyName;
        private EncryptionMaterialsProvider materialProvider;
        private Map<String, Set<EncryptionFlags>> attributeFlags;

        public Builder tableName(String tableName) {
            this.tableName = tableName;
            return this;
        }

        public Builder partitionKeyName(String partitionKeyName) {
            this.partitionKeyName = partitionKeyName;
            return this;
        }

        public Builder sortKeyName(String sortKeyName) {
            this.sortKeyName = sortKeyName;
            return this;
        }

        public Builder materialProvider(EncryptionMaterialsProvider materialProvider) {
            this.materialProvider = materialProvider;
            return this;
        }

        public Builder attributeFlags(Map<String, Set<EncryptionFlags>> attributeFlags) {
            this.attributeFlags = attributeFlags;
            return this;
        }

        public DDBECInterceptor build() {
            if (tableName == null || tableName.isEmpty()) {
                throw new IllegalArgumentException("tableName is required");
            }
            if (partitionKeyName == null || partitionKeyName.isEmpty()) {
                throw new IllegalArgumentException("partitionKeyName is required");
            }
            if (materialProvider == null) {
                throw new IllegalArgumentException("materialProvider is required");
            }
            if (attributeFlags == null || attributeFlags.isEmpty()) {
                throw new IllegalArgumentException("attributeFlags is required");
            }
            
            return new DDBECInterceptor(this);
        }
    }
}
