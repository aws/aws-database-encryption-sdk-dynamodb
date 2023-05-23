// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyOverride;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.PlaintextOverride;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.CryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.Keyring;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;

public class DynamoDbItemEncryptorConfig {
  private final String logicalTableName;

  private final String partitionKeyName;

  private final String sortKeyName;

  private final Map<String, CryptoAction> attributeActionsOnEncrypt;

  private final List<String> allowedUnsignedAttributes;

  private final String allowedUnsignedAttributePrefix;

  private final DBEAlgorithmSuiteId algorithmSuiteId;

  private final IKeyring keyring;

  private final ICryptographicMaterialsManager cmm;

  private final LegacyOverride legacyOverride;

  private final PlaintextOverride plaintextOverride;

  protected DynamoDbItemEncryptorConfig(BuilderImpl builder) {
    this.logicalTableName = builder.logicalTableName();
    this.partitionKeyName = builder.partitionKeyName();
    this.sortKeyName = builder.sortKeyName();
    this.attributeActionsOnEncrypt = builder.attributeActionsOnEncrypt();
    this.allowedUnsignedAttributes = builder.allowedUnsignedAttributes();
    this.allowedUnsignedAttributePrefix = builder.allowedUnsignedAttributePrefix();
    this.algorithmSuiteId = builder.algorithmSuiteId();
    this.keyring = builder.keyring();
    this.cmm = builder.cmm();
    this.legacyOverride = builder.legacyOverride();
    this.plaintextOverride = builder.plaintextOverride();
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

  public Map<String, CryptoAction> attributeActionsOnEncrypt() {
    return this.attributeActionsOnEncrypt;
  }

  public List<String> allowedUnsignedAttributes() {
    return this.allowedUnsignedAttributes;
  }

  public String allowedUnsignedAttributePrefix() {
    return this.allowedUnsignedAttributePrefix;
  }

  public DBEAlgorithmSuiteId algorithmSuiteId() {
    return this.algorithmSuiteId;
  }

  public IKeyring keyring() {
    return this.keyring;
  }

  public ICryptographicMaterialsManager cmm() {
    return this.cmm;
  }

  public LegacyOverride legacyOverride() {
    return this.legacyOverride;
  }

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
    Builder logicalTableName(String logicalTableName);

    String logicalTableName();

    Builder partitionKeyName(String partitionKeyName);

    String partitionKeyName();

    Builder sortKeyName(String sortKeyName);

    String sortKeyName();

    Builder attributeActionsOnEncrypt(Map<String, CryptoAction> attributeActionsOnEncrypt);

    Map<String, CryptoAction> attributeActionsOnEncrypt();

    Builder allowedUnsignedAttributes(List<String> allowedUnsignedAttributes);

    List<String> allowedUnsignedAttributes();

    Builder allowedUnsignedAttributePrefix(String allowedUnsignedAttributePrefix);

    String allowedUnsignedAttributePrefix();

    Builder algorithmSuiteId(DBEAlgorithmSuiteId algorithmSuiteId);

    DBEAlgorithmSuiteId algorithmSuiteId();

    Builder keyring(IKeyring keyring);

    IKeyring keyring();

    Builder cmm(ICryptographicMaterialsManager cmm);

    ICryptographicMaterialsManager cmm();

    Builder legacyOverride(LegacyOverride legacyOverride);

    LegacyOverride legacyOverride();

    Builder plaintextOverride(PlaintextOverride plaintextOverride);

    PlaintextOverride plaintextOverride();

    DynamoDbItemEncryptorConfig build();
  }

  static class BuilderImpl implements Builder {
    protected String logicalTableName;

    protected String partitionKeyName;

    protected String sortKeyName;

    protected Map<String, CryptoAction> attributeActionsOnEncrypt;

    protected List<String> allowedUnsignedAttributes;

    protected String allowedUnsignedAttributePrefix;

    protected DBEAlgorithmSuiteId algorithmSuiteId;

    protected IKeyring keyring;

    protected ICryptographicMaterialsManager cmm;

    protected LegacyOverride legacyOverride;

    protected PlaintextOverride plaintextOverride;

    protected BuilderImpl() {
    }

    protected BuilderImpl(DynamoDbItemEncryptorConfig model) {
      this.logicalTableName = model.logicalTableName();
      this.partitionKeyName = model.partitionKeyName();
      this.sortKeyName = model.sortKeyName();
      this.attributeActionsOnEncrypt = model.attributeActionsOnEncrypt();
      this.allowedUnsignedAttributes = model.allowedUnsignedAttributes();
      this.allowedUnsignedAttributePrefix = model.allowedUnsignedAttributePrefix();
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

    public Builder attributeActionsOnEncrypt(Map<String, CryptoAction> attributeActionsOnEncrypt) {
      this.attributeActionsOnEncrypt = attributeActionsOnEncrypt;
      return this;
    }

    public Map<String, CryptoAction> attributeActionsOnEncrypt() {
      return this.attributeActionsOnEncrypt;
    }

    public Builder allowedUnsignedAttributes(List<String> allowedUnsignedAttributes) {
      this.allowedUnsignedAttributes = allowedUnsignedAttributes;
      return this;
    }

    public List<String> allowedUnsignedAttributes() {
      return this.allowedUnsignedAttributes;
    }

    public Builder allowedUnsignedAttributePrefix(String allowedUnsignedAttributePrefix) {
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

    public DynamoDbItemEncryptorConfig build() {
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
      if (Objects.isNull(this.attributeActionsOnEncrypt()))  {
        throw new IllegalArgumentException("Missing value for required field `attributeActionsOnEncrypt`");
      }
      if (Objects.nonNull(this.allowedUnsignedAttributes()) && this.allowedUnsignedAttributes().size() < 1) {
        throw new IllegalArgumentException("The size of `allowedUnsignedAttributes` must be greater than or equal to 1");
      }
      return new DynamoDbItemEncryptorConfig(this);
    }
  }
}
