// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms;

import java.util.Map;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DbeException;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;

/**
 * Configuration for the DDB encryption middleware.
 * Maps table names to their encryption configurations.
 */
public final class DdbMiddlewareConfig {

    private static final String RESERVED_PREFIX = "aws_dbe_";

    private final Map<String, DynamoDbItemEncryptor> tableEncryptors;

    public DdbMiddlewareConfig(Map<String, DynamoDbItemEncryptor> tableEncryptors) {
        this.tableEncryptors = tableEncryptors;
    }

    /** Get the encryptor for a table, or null if the table is not configured. */
    public DynamoDbItemEncryptor getEncryptor(String tableName) {
        return tableEncryptors.get(tableName);
    }

    /** Returns true if the table should pass through without encryption. */
    public boolean isPlainWrite(String tableName) {
        return !tableEncryptors.containsKey(tableName);
    }

    // ---- Shared Validation Helpers ----

    /**
     * Validate that no attribute names in the item start with the reserved prefix.
     * @throws DbeException if any attribute uses the reserved prefix
     */
    public static void validateWriteable(Map<String, ?> item) {
        for (String key : item.keySet()) {
            if (key.startsWith(RESERVED_PREFIX)) {
                throw new DbeException("Attribute name '" + key + "' uses reserved prefix '" + RESERVED_PREFIX + "'");
            }
        }
    }

    /**
     * Validate that a condition/filter expression does not reference encrypted attributes.
     * @throws DbeException if the expression references an encrypted attribute
     */
    public static void validateExpression(
            String expression,
            Map<String, String> expressionAttributeNames,
            DynamoDbItemEncryptorConfig config) {
        if (expression == null || expression.isEmpty()) return;
        if (expressionAttributeNames == null) return;

        Map<String, CryptoAction> actions = config.getAttributeActionsOnEncrypt();
        for (Map.Entry<String, String> entry : expressionAttributeNames.entrySet()) {
            String attrName = entry.getValue();
            CryptoAction action = actions.get(attrName);
            if (action == CryptoAction.ENCRYPT_AND_SIGN) {
                throw new DbeException("ConditionExpression references encrypted attribute '"
                    + attrName + "' (via " + entry.getKey() + ")");
            }
        }
    }
}
