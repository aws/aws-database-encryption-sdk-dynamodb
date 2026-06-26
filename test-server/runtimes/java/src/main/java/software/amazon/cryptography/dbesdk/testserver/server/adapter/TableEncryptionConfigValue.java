// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.server.adapter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.PlaintextOverride;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;

/**
 * Plain value mirror of the Smithy model's {@code TableEncryptionConfig} shape, holding everything
 * the adapter needs to build one table's {@code DynamoDbEnhancedTableEncryptionConfig}.
 *
 * <p>This is a framework-internal config object decoupled from the smithy-java generated types. The
 * {@code createClient} handler (task 2.3) is responsible for translating the generated {@code
 * TableEncryptionConfig} into this value object, including mapping the model's string-valued enums
 * ({@code CryptoAction}, {@code DBEAlgorithmSuiteId}, {@code PlaintextOverride}) onto the
 * corresponding DB-ESDK / Material Providers enum constants used here. Carrying the DB-ESDK enum
 * types directly means the values flow straight into the DB-ESDK builders without a second
 * translation inside the adapter.
 *
 * <p>The fields mirror {@code DynamoDbTableEncryptionConfig} from the DB-ESDK model by name (Req
 * 2.5). Note that the Enhanced Client derives per-attribute crypto actions from a {@code
 * TableSchema} rather than from an explicit action map; {@link GenericItemTableSchemas} bridges
 * this by building a schema whose derived actions equal {@link #attributeActionsOnEncrypt()}.
 */
public final class TableEncryptionConfigValue {

  private final String logicalTableName;
  private final String partitionKeyName;
  private final String sortKeyName;
  private final Map<String, CryptoAction> attributeActionsOnEncrypt;
  private final List<String> allowedUnsignedAttributes;
  private final String allowedUnsignedAttributePrefix;
  private final DBEAlgorithmSuiteId algorithmSuiteId;
  private final PlaintextOverride plaintextOverride;
  private final KeyringConfigValue keyring;

  private TableEncryptionConfigValue(final Builder builder) {
    this.logicalTableName =
        Objects.requireNonNull(builder.logicalTableName, "logicalTableName must not be null");
    this.partitionKeyName =
        Objects.requireNonNull(builder.partitionKeyName, "partitionKeyName must not be null");
    this.sortKeyName = builder.sortKeyName;
    this.attributeActionsOnEncrypt =
        Objects.requireNonNull(
            builder.attributeActionsOnEncrypt, "attributeActionsOnEncrypt must not be null");
    this.allowedUnsignedAttributes = builder.allowedUnsignedAttributes;
    this.allowedUnsignedAttributePrefix = builder.allowedUnsignedAttributePrefix;
    this.algorithmSuiteId = builder.algorithmSuiteId;
    this.plaintextOverride = builder.plaintextOverride;
    this.keyring = Objects.requireNonNull(builder.keyring, "keyring must not be null");
  }

  public String logicalTableName() {
    return logicalTableName;
  }

  public String partitionKeyName() {
    return partitionKeyName;
  }

  /** @return the sort key attribute name, or {@code null} if the table has no sort key */
  public String sortKeyName() {
    return sortKeyName;
  }

  public Map<String, CryptoAction> attributeActionsOnEncrypt() {
    return attributeActionsOnEncrypt;
  }

  /** @return the allowed-unsigned attribute names, or {@code null} if unset */
  public List<String> allowedUnsignedAttributes() {
    return allowedUnsignedAttributes;
  }

  /** @return the allowed-unsigned attribute-name prefix, or {@code null} if unset */
  public String allowedUnsignedAttributePrefix() {
    return allowedUnsignedAttributePrefix;
  }

  /** @return the algorithm suite id, or {@code null} to use the DB-ESDK default */
  public DBEAlgorithmSuiteId algorithmSuiteId() {
    return algorithmSuiteId;
  }

  /** @return the plaintext override, or {@code null} to use the DB-ESDK default */
  public PlaintextOverride plaintextOverride() {
    return plaintextOverride;
  }

  public KeyringConfigValue keyring() {
    return keyring;
  }

  public static Builder builder() {
    return new Builder();
  }

  /** Mutable builder for {@link TableEncryptionConfigValue}. */
  public static final class Builder {

    private String logicalTableName;
    private String partitionKeyName;
    private String sortKeyName;
    private Map<String, CryptoAction> attributeActionsOnEncrypt = new LinkedHashMap<>();
    private List<String> allowedUnsignedAttributes;
    private String allowedUnsignedAttributePrefix;
    private DBEAlgorithmSuiteId algorithmSuiteId;
    private PlaintextOverride plaintextOverride;
    private KeyringConfigValue keyring;

    public Builder logicalTableName(final String value) {
      this.logicalTableName = value;
      return this;
    }

    public Builder partitionKeyName(final String value) {
      this.partitionKeyName = value;
      return this;
    }

    public Builder sortKeyName(final String value) {
      this.sortKeyName = value;
      return this;
    }

    public Builder attributeActionsOnEncrypt(final Map<String, CryptoAction> value) {
      this.attributeActionsOnEncrypt = value;
      return this;
    }

    public Builder allowedUnsignedAttributes(final List<String> value) {
      this.allowedUnsignedAttributes = value;
      return this;
    }

    public Builder allowedUnsignedAttributePrefix(final String value) {
      this.allowedUnsignedAttributePrefix = value;
      return this;
    }

    public Builder algorithmSuiteId(final DBEAlgorithmSuiteId value) {
      this.algorithmSuiteId = value;
      return this;
    }

    public Builder plaintextOverride(final PlaintextOverride value) {
      this.plaintextOverride = value;
      return this;
    }

    public Builder keyring(final KeyringConfigValue value) {
      this.keyring = value;
      return this;
    }

    public TableEncryptionConfigValue build() {
      return new TableEncryptionConfigValue(this);
    }
  }
}
