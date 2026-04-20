// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.ddbconversion.AttributeSerializer;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DbeException;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.Canonize;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.DecryptPathStructure;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.EncryptPathStructure;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoItem;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.PathSegment;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;

/**
 * Encrypts and decrypts DynamoDB items using structured encryption.
 * Adapts the StructuredEncryption layer for DynamoDB-specific concerns.
 */
public final class DynamoDbItemEncryptor {

    private static final String RESERVED_PREFIX = "aws_dbe_";
    private static final String EC_TABLE_NAME = "aws-crypto-table-name";
    private static final String EC_PARTITION_NAME = "aws-crypto-partition-name";
    private static final String EC_SORT_NAME = "aws-crypto-sort-name";
    private static final String EC_ATTR_PREFIX = "aws-crypto-attr.";

    private final DynamoDbItemEncryptorConfig config;

    private DynamoDbItemEncryptor(DynamoDbItemEncryptorConfig config) {
        this.config = config;
    }

    /** Create and validate a DynamoDbItemEncryptor. */
    public static DynamoDbItemEncryptor create(DynamoDbItemEncryptorConfig config) {
        validateConfig(config);
        return new DynamoDbItemEncryptor(config);
    }

    // ---- EncryptItem ----

    /**
     * Encrypt a DynamoDB item.
     *
     * @param plaintextItem the item to encrypt
     * @return encrypted item with aws_dbe_head and aws_dbe_foot attributes
     */
    public Map<String, AttributeValue> encryptItem(Map<String, AttributeValue> plaintextItem) {
        // Plaintext policy: FORCE_PLAINTEXT_WRITE returns item unchanged
        if (config.getPlaintextPolicy() == DynamoDbItemEncryptorConfig.PlaintextPolicy.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ) {
            return plaintextItem;
        }

        // Validate required keys exist
        if (!plaintextItem.containsKey(config.getPartitionKeyName())) {
            throw new DbeException("Item missing partition key: " + config.getPartitionKeyName());
        }
        if (config.getSortKeyName() != null && !plaintextItem.containsKey(config.getSortKeyName())) {
            throw new DbeException("Item missing sort key: " + config.getSortKeyName());
        }

        // Convert DDB item to CryptoList (excluding DO_NOTHING attributes)
        List<CryptoItem> cryptoList = new ArrayList<>();
        for (Map.Entry<String, AttributeValue> entry : plaintextItem.entrySet()) {
            String attrName = entry.getKey();
            CryptoAction action = resolveAction(attrName);
            if (action == CryptoAction.DO_NOTHING) continue;

            StructuredDataTerminal terminal = AttributeSerializer.serializeAttr(entry.getValue());
            cryptoList.add(new CryptoItem(
                Collections.singletonList(new PathSegment(attrName)),
                terminal, action));
        }

        // Build encryption context
        Map<String, String> encContext = buildEncryptionContext(plaintextItem);

        // Encrypt
        EncryptPathStructure.Result result = EncryptPathStructure.encrypt(
            config.getLogicalTableName(),
            cryptoList,
            config.getCmm(),
            config.getAlgorithmSuiteId(),
            encContext);

        // Convert back to DDB item
        Map<String, AttributeValue> encryptedItem = new LinkedHashMap<>();

        // Add DO_NOTHING attributes from original item (pass-through)
        for (Map.Entry<String, AttributeValue> entry : plaintextItem.entrySet()) {
            String attrName = entry.getKey();
            if (attrName.startsWith(RESERVED_PREFIX)) continue;
            CryptoAction action = resolveAction(attrName);
            if (action == CryptoAction.DO_NOTHING) {
                encryptedItem.put(attrName, entry.getValue());
            }
        }

        // Add encrypted/signed fields from result
        for (CryptoItem item : result.getEncryptedStructure()) {
            String attrName = item.getKey().get(0).getKey();
            if (attrName.equals("aws_dbe_head") || attrName.equals("aws_dbe_foot")) {
                // Header and footer are stored as Binary attributes
                encryptedItem.put(attrName, AttributeValue.fromB(
                    software.amazon.awssdk.core.SdkBytes.fromByteArray(item.getData().getValue())));
            } else {
                CryptoAction action = item.getAction();
                if (action == CryptoAction.ENCRYPT_AND_SIGN) {
                    // Encrypted: stored as Binary
                    encryptedItem.put(attrName, AttributeValue.fromB(
                        software.amazon.awssdk.core.SdkBytes.fromByteArray(item.getData().getValue())));
                } else {
                    // SIGN_ONLY / SIGN_AND_INCLUDE_IN_EC: use original value
                    encryptedItem.put(attrName, plaintextItem.get(attrName));
                }
            }
        }

        return encryptedItem;
    }

    // ---- DecryptItem ----

    /**
     * Decrypt a DynamoDB item that was encrypted by this SDK.
     *
     * @param encryptedItem the encrypted item (must contain aws_dbe_head and aws_dbe_foot)
     * @return decrypted item with aws_dbe_head/foot removed
     */
    public Map<String, AttributeValue> decryptItem(Map<String, AttributeValue> encryptedItem) {
        // Check if item is plaintext (no header)
        if (!encryptedItem.containsKey("aws_dbe_head")) {
            // Plaintext policy: allow plaintext reads if configured
            if (config.getPlaintextPolicy() == DynamoDbItemEncryptorConfig.PlaintextPolicy.FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ
                || config.getPlaintextPolicy() == DynamoDbItemEncryptorConfig.PlaintextPolicy.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ) {
                return encryptedItem;
            }
            throw new DbeException("Item is not encrypted (missing aws_dbe_head)");
        }

        // Convert encrypted DDB item to CryptoList
        List<CryptoItem> cryptoList = new ArrayList<>();
        for (Map.Entry<String, AttributeValue> entry : encryptedItem.entrySet()) {
            String attrName = entry.getKey();
            // Determine action for this attribute
            CryptoAction action;
            if (attrName.equals("aws_dbe_head") || attrName.equals("aws_dbe_foot")) {
                // Header/footer are passed to DecryptPathStructure as-is
                action = CryptoAction.DO_NOTHING; // placeholder, will be handled specially
            } else if (attrName.startsWith(RESERVED_PREFIX)) {
                continue; // skip other reserved attributes (beacons etc)
            } else {
                action = resolveActionForDecrypt(attrName);
            }

            StructuredDataTerminal terminal = AttributeSerializer.serializeAttr(entry.getValue());
            cryptoList.add(new CryptoItem(
                Collections.singletonList(new PathSegment(attrName)),
                terminal, action));
        }

        // Build encryption context
        Map<String, String> encContext = buildEncryptionContextForDecrypt(encryptedItem);

        // Decrypt
        DecryptPathStructure.Result result = DecryptPathStructure.decrypt(
            config.getLogicalTableName(),
            cryptoList,
            config.getCmm(),
            encContext);

        // Convert back to DDB item
        Map<String, AttributeValue> decryptedItem = new LinkedHashMap<>();
        for (CryptoItem item : result.getPlaintextStructure()) {
            String attrName = item.getKey().get(0).getKey();
            decryptedItem.put(attrName, AttributeSerializer.deserializeAttr(item.getData()));
        }

        // Add DO_NOTHING attributes from original (excluding reserved)
        for (Map.Entry<String, AttributeValue> entry : encryptedItem.entrySet()) {
            String attrName = entry.getKey();
            if (attrName.startsWith(RESERVED_PREFIX)) continue;
            if (!decryptedItem.containsKey(attrName)) {
                decryptedItem.put(attrName, entry.getValue());
            }
        }

        return decryptedItem;
    }

    private CryptoAction resolveActionForDecrypt(String attrName) {
        Map<String, CryptoAction> actions = config.getAttributeActionsOnEncrypt();
        if (actions.containsKey(attrName)) {
            return actions.get(attrName);
        }
        if (isAllowedUnsigned(attrName)) {
            return CryptoAction.DO_NOTHING;
        }
        // Unknown attribute during decrypt — treat as SIGN_ONLY (authenticated)
        return CryptoAction.SIGN_ONLY;
    }

    private Map<String, String> buildEncryptionContextForDecrypt(Map<String, AttributeValue> item) {
        // For decrypt, we build the same base context as encrypt
        // The stored EC from the header will be merged by DecryptPathStructure
        Map<String, String> ec = new LinkedHashMap<>();
        ec.put(EC_TABLE_NAME, config.getLogicalTableName());
        ec.put(EC_PARTITION_NAME, config.getPartitionKeyName());
        if (config.getSortKeyName() != null) {
            ec.put(EC_SORT_NAME, config.getSortKeyName());
        }
        if (config.getVersion() == 1) {
            AttributeValue pkVal = item.get(config.getPartitionKeyName());
            if (pkVal != null) addKeyValueToContext(ec, config.getPartitionKeyName(), pkVal);
            if (config.getSortKeyName() != null) {
                AttributeValue skVal = item.get(config.getSortKeyName());
                if (skVal != null) addKeyValueToContext(ec, config.getSortKeyName(), skVal);
            }
        }
        return ec;
    }

    // ---- Encryption Context ----

    /**
     * Build the DynamoDB Item Base Context.
     * V1: table name + key names + key values (base64 encoded).
     * V2: table name + key names only.
     */
    Map<String, String> buildEncryptionContext(Map<String, AttributeValue> item) {
        Map<String, String> ec = new LinkedHashMap<>();
        ec.put(EC_TABLE_NAME, config.getLogicalTableName());
        ec.put(EC_PARTITION_NAME, config.getPartitionKeyName());

        if (config.getSortKeyName() != null) {
            ec.put(EC_SORT_NAME, config.getSortKeyName());
        }

        if (config.getVersion() == 1) {
            // V1: include key values as base64(typeId + serializedValue)
            addKeyValueToContext(ec, config.getPartitionKeyName(), item.get(config.getPartitionKeyName()));
            if (config.getSortKeyName() != null) {
                addKeyValueToContext(ec, config.getSortKeyName(), item.get(config.getSortKeyName()));
            }
        }
        // V2: key values come via SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT through the structured encryption layer

        return ec;
    }

    private void addKeyValueToContext(Map<String, String> ec, String attrName, AttributeValue value) {
        StructuredDataTerminal terminal = AttributeSerializer.serializeAttr(value);
        byte[] combined = new byte[2 + terminal.getValue().length];
        System.arraycopy(terminal.getTypeId(), 0, combined, 0, 2);
        System.arraycopy(terminal.getValue(), 0, combined, 2, terminal.getValue().length);
        String encoded = Base64.getEncoder().encodeToString(combined);
        ec.put(EC_ATTR_PREFIX + attrName, encoded);
    }

    // ---- Config & Helpers ----

    private CryptoAction resolveAction(String attrName) {
        Map<String, CryptoAction> actions = config.getAttributeActionsOnEncrypt();
        if (actions.containsKey(attrName)) {
            return actions.get(attrName);
        }
        // Attribute not in config: check if it's in allowed unsigned
        if (isAllowedUnsigned(attrName)) {
            return CryptoAction.DO_NOTHING;
        }
        // Default: must be signed (fail-closed)
        throw new DbeException("No action configured for attribute: " + attrName
            + " and it is not in allowed unsigned attributes/prefix");
    }

    private boolean isAllowedUnsigned(String attrName) {
        if (config.getAllowedUnsignedAttributes() != null
            && config.getAllowedUnsignedAttributes().contains(attrName)) {
            return true;
        }
        if (config.getAllowedUnsignedAttributePrefix() != null
            && attrName.startsWith(config.getAllowedUnsignedAttributePrefix())) {
            return true;
        }
        return false;
    }

    public DynamoDbItemEncryptorConfig getConfig() { return config; }

    // ---- Config Validation ----

    private static void validateConfig(DynamoDbItemEncryptorConfig config) {
        if (config.getCmm() == null) {
            throw new DbeException("Must provide a CMM");
        }
        if (config.getLogicalTableName() == null || config.getLogicalTableName().isEmpty()) {
            throw new DbeException("logicalTableName is required");
        }
        if (config.getPartitionKeyName() == null || config.getPartitionKeyName().isEmpty()) {
            throw new DbeException("partitionKeyName is required");
        }
        if (config.getAttributeActionsOnEncrypt() == null || config.getAttributeActionsOnEncrypt().isEmpty()) {
            throw new DbeException("attributeActionsOnEncrypt is required");
        }

        int version = determineVersion(config.getAttributeActionsOnEncrypt());
        CryptoAction keyAction = version == 2
            ? CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT
            : CryptoAction.SIGN_ONLY;

        // Partition key must have the correct key action
        CryptoAction pkAction = config.getAttributeActionsOnEncrypt().get(config.getPartitionKeyName());
        if (pkAction != keyAction) {
            throw new DbeException("Partition key action must be " + keyAction);
        }

        // Sort key must have the correct key action (if present)
        if (config.getSortKeyName() != null) {
            CryptoAction skAction = config.getAttributeActionsOnEncrypt().get(config.getSortKeyName());
            if (skAction != keyAction) {
                throw new DbeException("Sort key action must be " + keyAction);
            }
        }

        // Validate each attribute action
        for (Map.Entry<String, CryptoAction> entry : config.getAttributeActionsOnEncrypt().entrySet()) {
            String attrName = entry.getKey();
            CryptoAction action = entry.getValue();

            // No reserved prefix
            if (attrName.startsWith(RESERVED_PREFIX) || attrName.startsWith("aws-crypto-")) {
                throw new DbeException("Attribute name uses reserved prefix: " + attrName);
            }

            // Forward compatibility: DO_NOTHING must be in allowed-unsigned
            if (action == CryptoAction.DO_NOTHING) {
                if (!isAllowedUnsignedStatic(attrName, config)) {
                    throw new DbeException("DO_NOTHING attribute '" + attrName
                        + "' must be in allowedUnsignedAttributes or match allowedUnsignedAttributePrefix");
                }
            } else {
                // Non-DO_NOTHING must NOT be in allowed-unsigned
                if (isAllowedUnsignedStatic(attrName, config)) {
                    throw new DbeException("Signed attribute '" + attrName
                        + "' must not be in allowedUnsignedAttributes or match allowedUnsignedAttributePrefix");
                }
            }
        }
    }

    private static int determineVersion(Map<String, CryptoAction> actions) {
        for (CryptoAction action : actions.values()) {
            if (action == CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT) return 2;
        }
        return 1;
    }

    private static boolean isAllowedUnsignedStatic(String attrName, DynamoDbItemEncryptorConfig config) {
        if (config.getAllowedUnsignedAttributes() != null
            && config.getAllowedUnsignedAttributes().contains(attrName)) {
            return true;
        }
        if (config.getAllowedUnsignedAttributePrefix() != null
            && attrName.startsWith(config.getAllowedUnsignedAttributePrefix())) {
            return true;
        }
        return false;
    }
}
