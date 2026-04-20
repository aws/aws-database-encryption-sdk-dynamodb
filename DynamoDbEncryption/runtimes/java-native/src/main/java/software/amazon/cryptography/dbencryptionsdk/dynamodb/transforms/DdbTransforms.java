// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms;

import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
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
        // TODO: implement full DecryptItem when DecryptPathStructure is available
        // For now, this is a placeholder that shows the integration point
        DynamoDbItemEncryptor encryptor = config.getEncryptor(originalRequest.tableName());
        // Map<String, AttributeValue> decrypted = encryptor.decryptItem(item);
        // return response.toBuilder().item(decrypted).build();
        return response;
    }
}
