// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemResponse;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemResponse;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.KeysAndAttributes;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.awssdk.services.dynamodb.model.PutRequest;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;
import software.amazon.awssdk.services.dynamodb.model.QueryResponse;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;
import software.amazon.awssdk.services.dynamodb.model.TransactGetItem;
import software.amazon.awssdk.services.dynamodb.model.TransactGetItemsRequest;
import software.amazon.awssdk.services.dynamodb.model.TransactGetItemsResponse;
import software.amazon.awssdk.services.dynamodb.model.TransactWriteItem;
import software.amazon.awssdk.services.dynamodb.model.TransactWriteItemsRequest;
import software.amazon.awssdk.services.dynamodb.model.TransactWriteItemsResponse;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;
import software.amazon.awssdk.services.dynamodb.model.WriteRequest;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DbeException;

/**
 * Transforms for PutItem and GetItem DynamoDB API calls.
 */
public final class DdbTransforms {

    private DdbTransforms() {}

    // ---- PutItem ----

    /** Transform PutItem request: encrypt the item before sending to DynamoDB. */
    public static PutItemRequest putItemInput(DdbMiddlewareConfig config, PutItemRequest request) {
        if (config.isPlainWrite(request.tableName())) {
            return request;
        }

        DynamoDbItemEncryptor encryptor = config.getEncryptor(request.tableName());

        // Reject legacy parameters
        if (request.hasExpected() && !request.expected().isEmpty()) {
            throw new DbeException("Legacy parameter 'Expected' not supported with encryption");
        }
        if (request.conditionalOperator() != null) {
            throw new DbeException("Legacy parameter 'ConditionalOperator' not supported with encryption");
        }

        // Validate no reserved prefix attributes
        DdbMiddlewareConfig.validateWriteable(request.item());

        // Validate condition expression doesn't reference encrypted attributes
        DdbMiddlewareConfig.validateExpression(
            request.conditionExpression(),
            request.expressionAttributeNames(),
            encryptor.getConfig());

        // Encrypt the item
        Map<String, AttributeValue> encryptedItem = encryptor.encryptItem(request.item());

        return request.toBuilder().item(encryptedItem).build();
    }

    /** Transform PutItem response: decrypt returned attributes (ReturnValues=ALL_OLD). */
    public static PutItemResponse putItemOutput(
            DdbMiddlewareConfig config, PutItemResponse response, PutItemRequest originalRequest) {
        if (config.isPlainWrite(originalRequest.tableName())) {
            return response;
        }
        if (!response.hasAttributes() || response.attributes().isEmpty()) {
            return response;
        }

        // Decrypt the old item returned by ReturnValues=ALL_OLD
        // Note: for now we return as-is since DecryptItem is not yet implemented
        // TODO: decrypt response.attributes() when DecryptItem is available
        return response;
    }

    // ---- GetItem ----

    /** Transform GetItem request: pass through (no modification needed). */
    public static GetItemRequest getItemInput(DdbMiddlewareConfig config, GetItemRequest request) {
        // GetItem requests don't need modification — encryption is transparent on read
        return request;
    }

    /** Transform GetItem response: decrypt the returned item. */
    public static GetItemResponse getItemOutput(
            DdbMiddlewareConfig config, GetItemResponse response, GetItemRequest originalRequest) {
        if (config.isPlainWrite(originalRequest.tableName())) {
            return response;
        }
        if (!response.hasItem() || response.item().isEmpty()) {
            return response;
        }

        // Check if the item is encrypted (has aws_dbe_head)
        Map<String, AttributeValue> item = response.item();
        if (!item.containsKey("aws_dbe_head")) {
            // Plaintext item — pass through
            return response;
        }

        // Decrypt the item
        DynamoDbItemEncryptor encryptor = config.getEncryptor(originalRequest.tableName());
        Map<String, AttributeValue> decrypted = encryptor.decryptItem(item);
        return response.toBuilder().item(decrypted).build();
    }

    // ---- Query ----

    public static QueryRequest queryInput(DdbMiddlewareConfig config, QueryRequest request) {
        if (config.isPlainWrite(request.tableName())) return request;
        DynamoDbItemEncryptor encryptor = config.getEncryptor(request.tableName());
        DdbMiddlewareConfig.validateExpression(
            request.filterExpression(), request.expressionAttributeNames(), encryptor.getConfig());
        DdbMiddlewareConfig.validateExpression(
            request.keyConditionExpression(), request.expressionAttributeNames(), encryptor.getConfig());
        return request;
    }

    public static QueryResponse queryOutput(DdbMiddlewareConfig config, QueryResponse response, QueryRequest request) {
        if (config.isPlainWrite(request.tableName())) return response;
        if (!response.hasItems() || response.items().isEmpty()) return response;
        DynamoDbItemEncryptor encryptor = config.getEncryptor(request.tableName());
        List<Map<String, AttributeValue>> decrypted = decryptItems(encryptor, response.items());
        return response.toBuilder().items(decrypted).build();
    }

    // ---- Scan ----

    public static ScanRequest scanInput(DdbMiddlewareConfig config, ScanRequest request) {
        if (config.isPlainWrite(request.tableName())) return request;
        DynamoDbItemEncryptor encryptor = config.getEncryptor(request.tableName());
        DdbMiddlewareConfig.validateExpression(
            request.filterExpression(), request.expressionAttributeNames(), encryptor.getConfig());
        return request;
    }

    public static ScanResponse scanOutput(DdbMiddlewareConfig config, ScanResponse response, ScanRequest request) {
        if (config.isPlainWrite(request.tableName())) return response;
        if (!response.hasItems() || response.items().isEmpty()) return response;
        DynamoDbItemEncryptor encryptor = config.getEncryptor(request.tableName());
        List<Map<String, AttributeValue>> decrypted = decryptItems(encryptor, response.items());
        return response.toBuilder().items(decrypted).build();
    }

    // ---- BatchWriteItem ----

    public static BatchWriteItemRequest batchWriteInput(DdbMiddlewareConfig config, BatchWriteItemRequest request) {
        if (!request.hasRequestItems()) return request;
        Map<String, List<WriteRequest>> transformed = new LinkedHashMap<>();
        for (Map.Entry<String, List<WriteRequest>> entry : request.requestItems().entrySet()) {
            String tableName = entry.getKey();
            if (config.isPlainWrite(tableName)) {
                transformed.put(tableName, entry.getValue());
                continue;
            }
            DynamoDbItemEncryptor encryptor = config.getEncryptor(tableName);
            List<WriteRequest> newRequests = new ArrayList<>();
            for (WriteRequest wr : entry.getValue()) {
                if (wr.putRequest() != null) {
                    DdbMiddlewareConfig.validateWriteable(wr.putRequest().item());
                    Map<String, AttributeValue> encrypted = encryptor.encryptItem(wr.putRequest().item());
                    newRequests.add(wr.toBuilder().putRequest(PutRequest.builder().item(encrypted).build()).build());
                } else {
                    newRequests.add(wr);
                }
            }
            transformed.put(tableName, newRequests);
        }
        return request.toBuilder().requestItems(transformed).build();
    }

    // ---- BatchGetItem ----

    public static BatchGetItemResponse batchGetOutput(DdbMiddlewareConfig config, BatchGetItemResponse response) {
        if (!response.hasResponses() || response.responses().isEmpty()) return response;
        Map<String, List<Map<String, AttributeValue>>> transformed = new LinkedHashMap<>();
        for (Map.Entry<String, List<Map<String, AttributeValue>>> entry : response.responses().entrySet()) {
            String tableName = entry.getKey();
            if (config.isPlainWrite(tableName)) {
                transformed.put(tableName, entry.getValue());
                continue;
            }
            DynamoDbItemEncryptor encryptor = config.getEncryptor(tableName);
            transformed.put(tableName, decryptItems(encryptor, entry.getValue()));
        }
        return response.toBuilder().responses(transformed).build();
    }

    // ---- TransactWriteItems ----

    public static TransactWriteItemsRequest transactWriteInput(DdbMiddlewareConfig config, TransactWriteItemsRequest request) {
        if (!request.hasTransactItems()) return request;
        List<TransactWriteItem> transformed = new ArrayList<>();
        for (TransactWriteItem item : request.transactItems()) {
            if (item.put() != null && !config.isPlainWrite(item.put().tableName())) {
                DynamoDbItemEncryptor encryptor = config.getEncryptor(item.put().tableName());
                DdbMiddlewareConfig.validateWriteable(item.put().item());
                Map<String, AttributeValue> encrypted = encryptor.encryptItem(item.put().item());
                transformed.add(item.toBuilder().put(item.put().toBuilder().item(encrypted).build()).build());
            } else {
                transformed.add(item);
            }
        }
        return request.toBuilder().transactItems(transformed).build();
    }

    // ---- DeleteItem ----

    public static DeleteItemRequest deleteItemInput(DdbMiddlewareConfig config, DeleteItemRequest request) {
        if (config.isPlainWrite(request.tableName())) return request;
        DynamoDbItemEncryptor encryptor = config.getEncryptor(request.tableName());
        DdbMiddlewareConfig.validateExpression(
            request.conditionExpression(), request.expressionAttributeNames(), encryptor.getConfig());
        return request;
    }

    public static DeleteItemResponse deleteItemOutput(
            DdbMiddlewareConfig config, DeleteItemResponse response, DeleteItemRequest request) {
        if (config.isPlainWrite(request.tableName())) return response;
        if (!response.hasAttributes() || response.attributes().isEmpty()) return response;
        if (response.attributes().containsKey("aws_dbe_head")) {
            DynamoDbItemEncryptor encryptor = config.getEncryptor(request.tableName());
            return response.toBuilder().attributes(encryptor.decryptItem(response.attributes())).build();
        }
        return response;
    }

    // ---- UpdateItem ----

    public static UpdateItemRequest updateItemInput(DdbMiddlewareConfig config, UpdateItemRequest request) {
        if (config.isPlainWrite(request.tableName())) return request;
        DynamoDbItemEncryptor encryptor = config.getEncryptor(request.tableName());
        DdbMiddlewareConfig.validateExpression(
            request.updateExpression(), request.expressionAttributeNames(), encryptor.getConfig());
        DdbMiddlewareConfig.validateExpression(
            request.conditionExpression(), request.expressionAttributeNames(), encryptor.getConfig());
        return request;
    }

    // ---- Shared ----

    private static List<Map<String, AttributeValue>> decryptItems(
            DynamoDbItemEncryptor encryptor, List<Map<String, AttributeValue>> items) {
        List<Map<String, AttributeValue>> result = new ArrayList<>(items.size());
        for (Map<String, AttributeValue> item : items) {
            if (item.containsKey("aws_dbe_head")) {
                result.add(encryptor.decryptItem(item));
            } else {
                result.add(item);
            }
        }
        return result;
    }
}
