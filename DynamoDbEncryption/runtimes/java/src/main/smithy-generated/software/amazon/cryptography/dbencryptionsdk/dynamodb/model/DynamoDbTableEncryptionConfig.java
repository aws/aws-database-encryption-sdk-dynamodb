// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.CryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.Keyring;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;

/**
 * The configuration for client-side encryption for a particular DynamoDB table.
 */
public class DynamoDbTableEncryptionConfig {

  /**
   * The logical table name for this table. This is the name that is cryptographically bound with your data. This can be the same as the actual DynamoDB table name. It's purpose is to be distinct from the DynamoDB table name so that the data may still be authenticated if being read from different (but logically similar) tables, such as a backup table.
   */
  private final String logicalTableName;

  /**
   * The name of the partition key on this table.
   */
  private final String partitionKeyName;

  /**
   * If this table contains a sort key, the name of the sort key on this table.
   */
  private final String sortKeyName;

  /**
   * The configuration for searchable encryption.
   */
  private final SearchConfig search;

  /**
   * A map that describes what attributes should be encrypted and/or signed on encrypt. This map must contain all attributes that might be encountered during encryption.
   */
  private final Map<String, CryptoAction> attributeActionsOnEncrypt;

  /**
   * A list of attribute names such that, if encountered during decryption, those attributes are treated as unsigned.
   */
  private final List<String> allowedUnsignedAttributes;

  /**
   * A prefix such that, if during decryption any attribute has a name with this prefix, it is treated as unsigned.
   */
  private final String allowedUnsignedAttributePrefix;

  /**
   * An ID for the algorithm suite to use during encryption and decryption.
   */
  private final DBEAlgorithmSuiteId algorithmSuiteId;

  /**
   * The Keyring that should be used to wrap and unwrap data keys. If specified a Default Cryptographic Materials Manager with this Keyring is used to obtain materials for encryption and decryption. Either a Keyring or a Cryptographic Materials Manager must be specified.
   */
  private final IKeyring keyring;

  /**
   * The Cryptographic Materials Manager that is used to obtain materials for encryption and decryption.  Either a Keyring or a Cryptographic Materials Manager must be specified.
   */
  private final ICryptographicMaterialsManager cmm;

  /**
   * A configuration that override encryption and/or decryption to instead perform legacy encryption and/or decryption. Used as part of migration from version 2.x to version 3.x.
   */
  private final LegacyOverride legacyOverride;

  /**
   * A configuration that override encryption and/or decryption to instead passthrough and write and/or read plaintext. Used to update plaintext tables to fully use client-side encryption.
   */
  private final PlaintextOverride plaintextOverride;

  protected DynamoDbTableEncryptionConfig(BuilderImpl builder) {
    this.logicalTableName = builder.logicalTableName();
    this.partitionKeyName = builder.partitionKeyName();
    this.sortKeyName = builder.sortKeyName();
    this.search = builder.search();
    this.attributeActionsOnEncrypt = builder.attributeActionsOnEncrypt();
    this.allowedUnsignedAttributes = builder.allowedUnsignedAttributes();
    this.allowedUnsignedAttributePrefix =
      builder.allowedUnsignedAttributePrefix();
    this.algorithmSuiteId = builder.algorithmSuiteId();
    this.keyring = builder.keyring();
    this.cmm = builder.cmm();
    this.legacyOverride = builder.legacyOverride();
    this.plaintextOverride = builder.plaintextOverride();
  }

  /**
   * @return The logical table name for this table. This is the name that is cryptographically bound with your data. This can be the same as the actual DynamoDB table name. It's purpose is to be distinct from the DynamoDB table name so that the data may still be authenticated if being read from different (but logically similar) tables, such as a backup table.
   */
  public String logicalTableName() {
    return this.logicalTableName;
  }

  /**
   * @return The name of the partition key on this table.
   */
  public String partitionKeyName() {
    return this.partitionKeyName;
  }

  /**
   * @return If this table contains a sort key, the name of the sort key on this table.
   */
  public String sortKeyName() {
    return this.sortKeyName;
  }

  /**
   * @return The configuration for searchable encryption.
   */
  public SearchConfig search() {
    return this.search;
  }

  /**
   * @return A map that describes what attributes should be encrypted and/or signed on encrypt. This map must contain all attributes that might be encountered during encryption.
   */
  public Map<String, CryptoAction> attributeActionsOnEncrypt() {
    return this.attributeActionsOnEncrypt;
  }

  /**
   * @return A list of attribute names such that, if encountered during decryption, those attributes are treated as unsigned.
   */
  public List<String> allowedUnsignedAttributes() {
    return this.allowedUnsignedAttributes;
  }

  /**
   * @return A prefix such that, if during decryption any attribute has a name with this prefix, it is treated as unsigned.
   */
  public String allowedUnsignedAttributePrefix() {
    return this.allowedUnsignedAttributePrefix;
  }

  /**
   * @return An ID for the algorithm suite to use during encryption and decryption.
   */
  public DBEAlgorithmSuiteId algorithmSuiteId() {
    return this.algorithmSuiteId;
  }

  /**
   * @return The Keyring that should be used to wrap and unwrap data keys. If specified a Default Cryptographic Materials Manager with this Keyring is used to obtain materials for encryption and decryption. Either a Keyring or a Cryptographic Materials Manager must be specified.
   */
  public IKeyring keyring() {
    return this.keyring;
  }

  /**
   * @return The Cryptographic Materials Manager that is used to obtain materials for encryption and decryption.  Either a Keyring or a Cryptographic Materials Manager must be specified.
   */
  public ICryptographicMaterialsManager cmm() {
    return this.cmm;
  }

  /**
   * @return A configuration that override encryption and/or decryption to instead perform legacy encryption and/or decryption. Used as part of migration from version 2.x to version 3.x.
   */
  public LegacyOverride legacyOverride() {
    return this.legacyOverride;
  }

  /**
   * @return A configuration that override encryption and/or decryption to instead passthrough and write and/or read plaintext. Used to update plaintext tables to fully use client-side encryption.
   */
  public PlaintextOverride plaintextOverride() {
    return this.plaintextOverride;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param logicalTableName The logical table name for this table. This is the name that is cryptographically bound with your data. This can be the same as the actual DynamoDB table name. It's purpose is to be distinct from the DynamoDB table name so that the data may still be authenticated if being read from different (but logically similar) tables, such as a backup table.
     */
    Builder logicalTableName(String logicalTableName);

    /**
     * @return The logical table name for this table. This is the name that is cryptographically bound with your data. This can be the same as the actual DynamoDB table name. It's purpose is to be distinct from the DynamoDB table name so that the data may still be authenticated if being read from different (but logically similar) tables, such as a backup table.
     */
    String logicalTableName();

    /**
     * @param partitionKeyName The name of the partition key on this table.
     */
    Builder partitionKeyName(String partitionKeyName);

    /**
     * @return The name of the partition key on this table.
     */
    String partitionKeyName();

    /**
     * @param sortKeyName If this table contains a sort key, the name of the sort key on this table.
     */
    Builder sortKeyName(String sortKeyName);

    /**
     * @return If this table contains a sort key, the name of the sort key on this table.
     */
    String sortKeyName();

    /**
     * @param search The configuration for searchable encryption.
     */
    Builder search(SearchConfig search);

    /**
     * @return The configuration for searchable encryption.
     */
    SearchConfig search();

    /**
     * @param attributeActionsOnEncrypt A map that describes what attributes should be encrypted and/or signed on encrypt. This map must contain all attributes that might be encountered during encryption.
     */
    Builder attributeActionsOnEncrypt(
      Map<String, CryptoAction> attributeActionsOnEncrypt
    );

    /**
     * @return A map that describes what attributes should be encrypted and/or signed on encrypt. This map must contain all attributes that might be encountered during encryption.
     */
    Map<String, CryptoAction> attributeActionsOnEncrypt();

    /**
     * @param allowedUnsignedAttributes A list of attribute names such that, if encountered during decryption, those attributes are treated as unsigned.
     */
    Builder allowedUnsignedAttributes(List<String> allowedUnsignedAttributes);

    /**
     * @return A list of attribute names such that, if encountered during decryption, those attributes are treated as unsigned.
     */
    List<String> allowedUnsignedAttributes();

    /**
     * @param allowedUnsignedAttributePrefix A prefix such that, if during decryption any attribute has a name with this prefix, it is treated as unsigned.
     */
    Builder allowedUnsignedAttributePrefix(
      String allowedUnsignedAttributePrefix
    );

    /**
     * @return A prefix such that, if during decryption any attribute has a name with this prefix, it is treated as unsigned.
     */
    String allowedUnsignedAttributePrefix();

    /**
     * @param algorithmSuiteId An ID for the algorithm suite to use during encryption and decryption.
     */
    Builder algorithmSuiteId(DBEAlgorithmSuiteId algorithmSuiteId);

    /**
     * @return An ID for the algorithm suite to use during encryption and decryption.
     */
    DBEAlgorithmSuiteId algorithmSuiteId();

    /**
     * @param keyring The Keyring that should be used to wrap and unwrap data keys. If specified a Default Cryptographic Materials Manager with this Keyring is used to obtain materials for encryption and decryption. Either a Keyring or a Cryptographic Materials Manager must be specified.
     */
    Builder keyring(IKeyring keyring);

    /**
     * @return The Keyring that should be used to wrap and unwrap data keys. If specified a Default Cryptographic Materials Manager with this Keyring is used to obtain materials for encryption and decryption. Either a Keyring or a Cryptographic Materials Manager must be specified.
     */
    IKeyring keyring();

    /**
     * @param cmm The Cryptographic Materials Manager that is used to obtain materials for encryption and decryption.  Either a Keyring or a Cryptographic Materials Manager must be specified.
     */
    Builder cmm(ICryptographicMaterialsManager cmm);

    /**
     * @return The Cryptographic Materials Manager that is used to obtain materials for encryption and decryption.  Either a Keyring or a Cryptographic Materials Manager must be specified.
     */
    ICryptographicMaterialsManager cmm();

    /**
     * @param legacyOverride A configuration that override encryption and/or decryption to instead perform legacy encryption and/or decryption. Used as part of migration from version 2.x to version 3.x.
     */
    Builder legacyOverride(LegacyOverride legacyOverride);

    /**
     * @return A configuration that override encryption and/or decryption to instead perform legacy encryption and/or decryption. Used as part of migration from version 2.x to version 3.x.
     */
    LegacyOverride legacyOverride();

    /**
     * @param plaintextOverride A configuration that override encryption and/or decryption to instead passthrough and write and/or read plaintext. Used to update plaintext tables to fully use client-side encryption.
     */
    Builder plaintextOverride(PlaintextOverride plaintextOverride);

    /**
     * @return A configuration that override encryption and/or decryption to instead passthrough and write and/or read plaintext. Used to update plaintext tables to fully use client-side encryption.
     */
    PlaintextOverride plaintextOverride();

    DynamoDbTableEncryptionConfig build();
  }

  static class BuilderImpl implements Builder {

    protected String logicalTableName;

    protected String partitionKeyName;

    protected String sortKeyName;

    protected SearchConfig search;

    protected Map<String, CryptoAction> attributeActionsOnEncrypt;

    protected List<String> allowedUnsignedAttributes;

    protected String allowedUnsignedAttributePrefix;

    protected DBEAlgorithmSuiteId algorithmSuiteId;

    protected IKeyring keyring;

    protected ICryptographicMaterialsManager cmm;

    protected LegacyOverride legacyOverride;

    protected PlaintextOverride plaintextOverride;

    protected BuilderImpl() {}

    protected BuilderImpl(DynamoDbTableEncryptionConfig model) {
      this.logicalTableName = model.logicalTableName();
      this.partitionKeyName = model.partitionKeyName();
      this.sortKeyName = model.sortKeyName();
      this.search = model.search();
      this.attributeActionsOnEncrypt = model.attributeActionsOnEncrypt();
      this.allowedUnsignedAttributes = model.allowedUnsignedAttributes();
      this.allowedUnsignedAttributePrefix =
        model.allowedUnsignedAttributePrefix();
      this.algorithmSuiteId = model.algorithmSuiteId();
      this.keyring = model.keyring();
      this.cmm = model.cmm();
      this.legacyOverride = model.legacyOverride();
      this.plaintextOverride = model.plaintextOverride();
    }

    public Builder logicalTableName(String logicalTableName) {
      this.logicalTableName = logicalTableName;
      return this;
    }

    public String logicalTableName() {
      return this.logicalTableName;
    }

    public Builder partitionKeyName(String partitionKeyName) {
      this.partitionKeyName = partitionKeyName;
      return this;
    }

    public String partitionKeyName() {
      return this.partitionKeyName;
    }

    public Builder sortKeyName(String sortKeyName) {
      this.sortKeyName = sortKeyName;
      return this;
    }

    public String sortKeyName() {
      return this.sortKeyName;
    }

    public Builder search(SearchConfig search) {
      this.search = search;
      return this;
    }

    public SearchConfig search() {
      return this.search;
    }

    public Builder attributeActionsOnEncrypt(
      Map<String, CryptoAction> attributeActionsOnEncrypt
    ) {
      this.attributeActionsOnEncrypt = attributeActionsOnEncrypt;
      return this;
    }

    public Map<String, CryptoAction> attributeActionsOnEncrypt() {
      return this.attributeActionsOnEncrypt;
    }

    public Builder allowedUnsignedAttributes(
      List<String> allowedUnsignedAttributes
    ) {
      this.allowedUnsignedAttributes = allowedUnsignedAttributes;
      return this;
    }

    public List<String> allowedUnsignedAttributes() {
      return this.allowedUnsignedAttributes;
    }

    public Builder allowedUnsignedAttributePrefix(
      String allowedUnsignedAttributePrefix
    ) {
      this.allowedUnsignedAttributePrefix = allowedUnsignedAttributePrefix;
      return this;
    }

    public String allowedUnsignedAttributePrefix() {
      return this.allowedUnsignedAttributePrefix;
    }

    public Builder algorithmSuiteId(DBEAlgorithmSuiteId algorithmSuiteId) {
      this.algorithmSuiteId = algorithmSuiteId;
      return this;
    }

    public DBEAlgorithmSuiteId algorithmSuiteId() {
      return this.algorithmSuiteId;
    }

    public Builder keyring(IKeyring keyring) {
      this.keyring = Keyring.wrap(keyring);
      return this;
    }

    public IKeyring keyring() {
      return this.keyring;
    }

    public Builder cmm(ICryptographicMaterialsManager cmm) {
      this.cmm = CryptographicMaterialsManager.wrap(cmm);
      return this;
    }

    public ICryptographicMaterialsManager cmm() {
      return this.cmm;
    }

    public Builder legacyOverride(LegacyOverride legacyOverride) {
      this.legacyOverride = legacyOverride;
      return this;
    }

    public LegacyOverride legacyOverride() {
      return this.legacyOverride;
    }

    public Builder plaintextOverride(PlaintextOverride plaintextOverride) {
      this.plaintextOverride = plaintextOverride;
      return this;
    }

    public PlaintextOverride plaintextOverride() {
      return this.plaintextOverride;
    }

    public DynamoDbTableEncryptionConfig build() {
      if (Objects.isNull(this.logicalTableName())) {
        throw new IllegalArgumentException(
          "Missing value for required field `logicalTableName`"
        );
      }
      if (Objects.isNull(this.partitionKeyName())) {
        throw new IllegalArgumentException(
          "Missing value for required field `partitionKeyName`"
        );
      }
      if (
        Objects.nonNull(this.partitionKeyName()) &&
        this.partitionKeyName().length() < 1
      ) {
        throw new IllegalArgumentException(
          "The size of `partitionKeyName` must be greater than or equal to 1"
        );
      }
      if (
        Objects.nonNull(this.partitionKeyName()) &&
        this.partitionKeyName().length() > 255
      ) {
        throw new IllegalArgumentException(
          "The size of `partitionKeyName` must be less than or equal to 255"
        );
      }
      if (
        Objects.nonNull(this.sortKeyName()) && this.sortKeyName().length() < 1
      ) {
        throw new IllegalArgumentException(
          "The size of `sortKeyName` must be greater than or equal to 1"
        );
      }
      if (
        Objects.nonNull(this.sortKeyName()) && this.sortKeyName().length() > 255
      ) {
        throw new IllegalArgumentException(
          "The size of `sortKeyName` must be less than or equal to 255"
        );
      }
      if (Objects.isNull(this.attributeActionsOnEncrypt())) {
        throw new IllegalArgumentException(
          "Missing value for required field `attributeActionsOnEncrypt`"
        );
      }
      if (
        Objects.nonNull(this.allowedUnsignedAttributes()) &&
        this.allowedUnsignedAttributes().size() < 1
      ) {
        throw new IllegalArgumentException(
          "The size of `allowedUnsignedAttributes` must be greater than or equal to 1"
        );
      }
      return new DynamoDbTableEncryptionConfig(this);
    }
  }
}
