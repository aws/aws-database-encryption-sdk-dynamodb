// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbItemEncryptor.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.materialProviders.CryptographicMaterialsManager;
import software.amazon.cryptography.materialProviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialProviders.IKeyring;
import software.amazon.cryptography.materialProviders.Keyring;
import software.amazon.cryptography.materialProviders.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;

public class DynamoDbItemEncryptorConfig {
  private final String tableName;

  private final String partitionKeyName;

  private final String sortKeyName;

  private final Map<String, CryptoAction> attributeActions;

  private final List<String> allowedUnauthenticatedAttributes;

  private final String allowedUnauthenticatedAttributePrefix;

  private final DBEAlgorithmSuiteId algorithmSuiteId;

  private final Keyring keyring;

  private final CryptographicMaterialsManager cmm;

  protected DynamoDbItemEncryptorConfig(BuilderImpl builder) {
    this.tableName = builder.tableName();
    this.partitionKeyName = builder.partitionKeyName();
    this.sortKeyName = builder.sortKeyName();
    this.attributeActions = builder.attributeActions();
    this.allowedUnauthenticatedAttributes = builder.allowedUnauthenticatedAttributes();
    this.allowedUnauthenticatedAttributePrefix = builder.allowedUnauthenticatedAttributePrefix();
    this.algorithmSuiteId = builder.algorithmSuiteId();
    this.keyring = builder.keyring();
    this.cmm = builder.cmm();
  }

  public String tableName() {
    return this.tableName;
  }

  public String partitionKeyName() {
    return this.partitionKeyName;
  }

  public String sortKeyName() {
    return this.sortKeyName;
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

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder tableName(String tableName);

    String tableName();

    Builder partitionKeyName(String partitionKeyName);

    String partitionKeyName();

    Builder sortKeyName(String sortKeyName);

    String sortKeyName();

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

    DynamoDbItemEncryptorConfig build();
  }

  static class BuilderImpl implements Builder {
    protected String tableName;

    protected String partitionKeyName;

    protected String sortKeyName;

    protected Map<String, CryptoAction> attributeActions;

    protected List<String> allowedUnauthenticatedAttributes;

    protected String allowedUnauthenticatedAttributePrefix;

    protected DBEAlgorithmSuiteId algorithmSuiteId;

    protected Keyring keyring;

    protected CryptographicMaterialsManager cmm;

    protected BuilderImpl() {
    }

    protected BuilderImpl(DynamoDbItemEncryptorConfig model) {
      this.tableName = model.tableName();
      this.partitionKeyName = model.partitionKeyName();
      this.sortKeyName = model.sortKeyName();
      this.attributeActions = model.attributeActions();
      this.allowedUnauthenticatedAttributes = model.allowedUnauthenticatedAttributes();
      this.allowedUnauthenticatedAttributePrefix = model.allowedUnauthenticatedAttributePrefix();
      this.algorithmSuiteId = model.algorithmSuiteId();
      this.keyring = model.keyring();
      this.cmm = model.cmm();
    }

    public Builder tableName(String tableName) {
      this.tableName = tableName;
      return this;
    }

    public String tableName() {
      return this.tableName;
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

    public DynamoDbItemEncryptorConfig build() {
      if (Objects.isNull(this.tableName()))  {
        throw new IllegalArgumentException("Missing value for required field `tableName`");
      }
      if (Objects.nonNull(this.tableName()) && this.tableName().length() < 3) {
        throw new IllegalArgumentException("The size of `tableName` must be greater than or equal to 3");
      }
      if (Objects.nonNull(this.tableName()) && this.tableName().length() > 255) {
        throw new IllegalArgumentException("The size of `tableName` must be less than or equal to 255");
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
      return new DynamoDbItemEncryptorConfig(this);
    }
  }
}
