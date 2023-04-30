// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.materialProviders.CryptographicMaterialsManager;
import software.amazon.cryptography.materialProviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialProviders.IKeyring;
import software.amazon.cryptography.materialProviders.Keyring;
import software.amazon.cryptography.materialProviders.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;

public class DynamoDbTableEncryptionConfig {
  private final String logicalTableName;

  private final String partitionKeyName;

  private final String sortKeyName;

  private final SearchConfig search;

  private final Map<String, CryptoAction> attributeActions;

  private final List<String> allowedUnauthenticatedAttributes;

  private final String allowedUnauthenticatedAttributePrefix;

  private final DBEAlgorithmSuiteId algorithmSuiteId;

  private final Keyring keyring;

  private final CryptographicMaterialsManager cmm;

  private final LegacyConfig legacyConfig;

  private final PlaintextPolicy plaintextPolicy;

  protected DynamoDbTableEncryptionConfig(BuilderImpl builder) {
    this.logicalTableName = builder.logicalTableName();
    this.partitionKeyName = builder.partitionKeyName();
    this.sortKeyName = builder.sortKeyName();
    this.search = builder.search();
    this.attributeActions = builder.attributeActions();
    this.allowedUnauthenticatedAttributes = builder.allowedUnauthenticatedAttributes();
    this.allowedUnauthenticatedAttributePrefix = builder.allowedUnauthenticatedAttributePrefix();
    this.algorithmSuiteId = builder.algorithmSuiteId();
    this.keyring = builder.keyring();
    this.cmm = builder.cmm();
    this.legacyConfig = builder.legacyConfig();
    this.plaintextPolicy = builder.plaintextPolicy();
  }

  public String logicalTableName() {
    return this.logicalTableName;
  }

  public String partitionKeyName() {
    return this.partitionKeyName;
  }

  public String sortKeyName() {
    return this.sortKeyName;
  }

  public SearchConfig search() {
    return this.search;
  }

  public Map<String, CryptoAction> attributeActions() {
    return this.attributeActions;
  }

  public List<String> allowedUnauthenticatedAttributes() {
    return this.allowedUnauthenticatedAttributes;
  }

  public String allowedUnauthenticatedAttributePrefix() {
    return this.allowedUnauthenticatedAttributePrefix;
  }

  public DBEAlgorithmSuiteId algorithmSuiteId() {
    return this.algorithmSuiteId;
  }

  public Keyring keyring() {
    return this.keyring;
  }

  public CryptographicMaterialsManager cmm() {
    return this.cmm;
  }

  public LegacyConfig legacyConfig() {
    return this.legacyConfig;
  }

  public PlaintextPolicy plaintextPolicy() {
    return this.plaintextPolicy;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder logicalTableName(String logicalTableName);

    String logicalTableName();

    Builder partitionKeyName(String partitionKeyName);

    String partitionKeyName();

    Builder sortKeyName(String sortKeyName);

    String sortKeyName();

    Builder search(SearchConfig search);

    SearchConfig search();

    Builder attributeActions(Map<String, CryptoAction> attributeActions);

    Map<String, CryptoAction> attributeActions();

    Builder allowedUnauthenticatedAttributes(List<String> allowedUnauthenticatedAttributes);

    List<String> allowedUnauthenticatedAttributes();

    Builder allowedUnauthenticatedAttributePrefix(String allowedUnauthenticatedAttributePrefix);

    String allowedUnauthenticatedAttributePrefix();

    Builder algorithmSuiteId(DBEAlgorithmSuiteId algorithmSuiteId);

    DBEAlgorithmSuiteId algorithmSuiteId();

    Builder keyring(IKeyring keyring);

    Keyring keyring();

    Builder cmm(ICryptographicMaterialsManager cmm);

    CryptographicMaterialsManager cmm();

    Builder legacyConfig(LegacyConfig legacyConfig);

    LegacyConfig legacyConfig();

    Builder plaintextPolicy(PlaintextPolicy plaintextPolicy);

    PlaintextPolicy plaintextPolicy();

    DynamoDbTableEncryptionConfig build();
  }

  static class BuilderImpl implements Builder {
    protected String logicalTableName;

    protected String partitionKeyName;

    protected String sortKeyName;

    protected SearchConfig search;

    protected Map<String, CryptoAction> attributeActions;

    protected List<String> allowedUnauthenticatedAttributes;

    protected String allowedUnauthenticatedAttributePrefix;

    protected DBEAlgorithmSuiteId algorithmSuiteId;

    protected Keyring keyring;

    protected CryptographicMaterialsManager cmm;

    protected LegacyConfig legacyConfig;

    protected PlaintextPolicy plaintextPolicy;

    protected BuilderImpl() {
    }

    protected BuilderImpl(DynamoDbTableEncryptionConfig model) {
      this.logicalTableName = model.logicalTableName();
      this.partitionKeyName = model.partitionKeyName();
      this.sortKeyName = model.sortKeyName();
      this.search = model.search();
      this.attributeActions = model.attributeActions();
      this.allowedUnauthenticatedAttributes = model.allowedUnauthenticatedAttributes();
      this.allowedUnauthenticatedAttributePrefix = model.allowedUnauthenticatedAttributePrefix();
      this.algorithmSuiteId = model.algorithmSuiteId();
      this.keyring = model.keyring();
      this.cmm = model.cmm();
      this.legacyConfig = model.legacyConfig();
      this.plaintextPolicy = model.plaintextPolicy();
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

    public Builder attributeActions(Map<String, CryptoAction> attributeActions) {
      this.attributeActions = attributeActions;
      return this;
    }

    public Map<String, CryptoAction> attributeActions() {
      return this.attributeActions;
    }

    public Builder allowedUnauthenticatedAttributes(List<String> allowedUnauthenticatedAttributes) {
      this.allowedUnauthenticatedAttributes = allowedUnauthenticatedAttributes;
      return this;
    }

    public List<String> allowedUnauthenticatedAttributes() {
      return this.allowedUnauthenticatedAttributes;
    }

    public Builder allowedUnauthenticatedAttributePrefix(
        String allowedUnauthenticatedAttributePrefix) {
      this.allowedUnauthenticatedAttributePrefix = allowedUnauthenticatedAttributePrefix;
      return this;
    }

    public String allowedUnauthenticatedAttributePrefix() {
      return this.allowedUnauthenticatedAttributePrefix;
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

    public Keyring keyring() {
      return this.keyring;
    }

    public Builder cmm(ICryptographicMaterialsManager cmm) {
      this.cmm = CryptographicMaterialsManager.wrap(cmm);
      return this;
    }

    public CryptographicMaterialsManager cmm() {
      return this.cmm;
    }

    public Builder legacyConfig(LegacyConfig legacyConfig) {
      this.legacyConfig = legacyConfig;
      return this;
    }

    public LegacyConfig legacyConfig() {
      return this.legacyConfig;
    }

    public Builder plaintextPolicy(PlaintextPolicy plaintextPolicy) {
      this.plaintextPolicy = plaintextPolicy;
      return this;
    }

    public PlaintextPolicy plaintextPolicy() {
      return this.plaintextPolicy;
    }

    public DynamoDbTableEncryptionConfig build() {
      if (Objects.isNull(this.logicalTableName()))  {
        throw new IllegalArgumentException("Missing value for required field `logicalTableName`");
      }
      if (Objects.isNull(this.partitionKeyName()))  {
        throw new IllegalArgumentException("Missing value for required field `partitionKeyName`");
      }
      if (Objects.nonNull(this.partitionKeyName()) && this.partitionKeyName().length() < 1) {
        throw new IllegalArgumentException("The size of `partitionKeyName` must be greater than or equal to 1");
      }
      if (Objects.nonNull(this.partitionKeyName()) && this.partitionKeyName().length() > 255) {
        throw new IllegalArgumentException("The size of `partitionKeyName` must be less than or equal to 255");
      }
      if (Objects.nonNull(this.sortKeyName()) && this.sortKeyName().length() < 1) {
        throw new IllegalArgumentException("The size of `sortKeyName` must be greater than or equal to 1");
      }
      if (Objects.nonNull(this.sortKeyName()) && this.sortKeyName().length() > 255) {
        throw new IllegalArgumentException("The size of `sortKeyName` must be less than or equal to 255");
      }
      if (Objects.isNull(this.attributeActions()))  {
        throw new IllegalArgumentException("Missing value for required field `attributeActions`");
      }
      if (Objects.nonNull(this.allowedUnauthenticatedAttributes()) && this.allowedUnauthenticatedAttributes().size() < 1) {
        throw new IllegalArgumentException("The size of `allowedUnauthenticatedAttributes` must be greater than or equal to 1");
      }
      return new DynamoDbTableEncryptionConfig(this);
    }
  }
}
