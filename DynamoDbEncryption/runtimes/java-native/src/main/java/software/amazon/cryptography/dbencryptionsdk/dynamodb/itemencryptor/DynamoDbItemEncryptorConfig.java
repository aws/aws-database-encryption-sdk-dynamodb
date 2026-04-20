// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor;

import java.util.List;
import java.util.Map;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;

/**
 * Configuration for the DynamoDbItemEncryptor.
 */
public final class DynamoDbItemEncryptorConfig {

    private final String logicalTableName;
    private final String partitionKeyName;
    private final String sortKeyName;
    private final Map<String, CryptoAction> attributeActionsOnEncrypt;
    private final ICryptographicMaterialsManager cmm;
    private final DBEAlgorithmSuiteId algorithmSuiteId;
    private final List<String> allowedUnsignedAttributes;
    private final String allowedUnsignedAttributePrefix;
    private final PlaintextPolicy plaintextPolicy;

    /** Plaintext read/write policy for migration scenarios. */
    public enum PlaintextPolicy {
        FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ,
        FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ,
        FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ
    }

    private DynamoDbItemEncryptorConfig(Builder builder) {
        this.logicalTableName = builder.logicalTableName;
        this.partitionKeyName = builder.partitionKeyName;
        this.sortKeyName = builder.sortKeyName;
        this.attributeActionsOnEncrypt = builder.attributeActionsOnEncrypt;
        this.cmm = builder.cmm;
        this.algorithmSuiteId = builder.algorithmSuiteId;
        this.allowedUnsignedAttributes = builder.allowedUnsignedAttributes;
        this.allowedUnsignedAttributePrefix = builder.allowedUnsignedAttributePrefix;
        this.plaintextPolicy = builder.plaintextPolicy != null
            ? builder.plaintextPolicy : PlaintextPolicy.FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ;
    }

    public String getLogicalTableName() { return logicalTableName; }
    public String getPartitionKeyName() { return partitionKeyName; }
    public String getSortKeyName() { return sortKeyName; }
    public Map<String, CryptoAction> getAttributeActionsOnEncrypt() { return attributeActionsOnEncrypt; }
    public ICryptographicMaterialsManager getCmm() { return cmm; }
    public DBEAlgorithmSuiteId getAlgorithmSuiteId() { return algorithmSuiteId; }
    public List<String> getAllowedUnsignedAttributes() { return allowedUnsignedAttributes; }
    public String getAllowedUnsignedAttributePrefix() { return allowedUnsignedAttributePrefix; }
    public PlaintextPolicy getPlaintextPolicy() { return plaintextPolicy; }

    /** Version: 2 if any action is SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT, else 1. */
    public int getVersion() {
        if (attributeActionsOnEncrypt != null) {
            for (CryptoAction action : attributeActionsOnEncrypt.values()) {
                if (action == CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT) return 2;
            }
        }
        return 1;
    }

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private String logicalTableName;
        private String partitionKeyName;
        private String sortKeyName;
        private Map<String, CryptoAction> attributeActionsOnEncrypt;
        private ICryptographicMaterialsManager cmm;
        private DBEAlgorithmSuiteId algorithmSuiteId;
        private List<String> allowedUnsignedAttributes;
        private String allowedUnsignedAttributePrefix;
        private PlaintextPolicy plaintextPolicy;

        public Builder logicalTableName(String v) { this.logicalTableName = v; return this; }
        public Builder partitionKeyName(String v) { this.partitionKeyName = v; return this; }
        public Builder sortKeyName(String v) { this.sortKeyName = v; return this; }
        public Builder attributeActionsOnEncrypt(Map<String, CryptoAction> v) { this.attributeActionsOnEncrypt = v; return this; }
        public Builder cmm(ICryptographicMaterialsManager v) { this.cmm = v; return this; }
        public Builder algorithmSuiteId(DBEAlgorithmSuiteId v) { this.algorithmSuiteId = v; return this; }
        public Builder allowedUnsignedAttributes(List<String> v) { this.allowedUnsignedAttributes = v; return this; }
        public Builder allowedUnsignedAttributePrefix(String v) { this.allowedUnsignedAttributePrefix = v; return this; }
        public Builder plaintextPolicy(PlaintextPolicy v) { this.plaintextPolicy = v; return this; }

        public DynamoDbItemEncryptorConfig build() {
            return new DynamoDbItemEncryptorConfig(this);
        }
    }
}
