// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

// TODO manually updated to include LegacyConfig. This needs to be added to smithy model.

import java.util.List;
import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.materialProviders.CryptographicMaterialsManager;
import software.amazon.cryptography.materialProviders.Keyring;
import software.amazon.cryptography.materialProviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialProviders.IKeyring;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;

public class DynamoDbTableEncryptionConfig {
  private final String partitionKeyName;

  private final String sortKeyName;

  private final Map<String, CryptoAction> attributeActions;

  private final List<String> allowedUnauthenticatedAttributes;

  private final String allowedUnauthenticatedAttributePrefix;

  private final Keyring keyring;

  private final CryptographicMaterialsManager cmm;

  private final LegacyConfig legacyConfig;

  protected DynamoDbTableEncryptionConfig(BuilderImpl builder) {
    this.partitionKeyName = builder.partitionKeyName();
    this.sortKeyName = builder.sortKeyName();
    this.attributeActions = builder.attributeActions();
    this.allowedUnauthenticatedAttributes = builder.allowedUnauthenticatedAttributes();
    this.allowedUnauthenticatedAttributePrefix = builder.allowedUnauthenticatedAttributePrefix();
    this.keyring = builder.keyring();
    this.cmm = builder.cmm();
    this.legacyConfig = builder.legacyConfig();
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

  public Keyring keyring() {
    return this.keyring;
  }

  public CryptographicMaterialsManager cmm() {
    return this.cmm;
  }

  public LegacyConfig legacyConfig() {
    return this.legacyConfig;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
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

    <I extends IKeyring> Builder keyring(I keyring);

    Keyring keyring();

    <I extends ICryptographicMaterialsManager> Builder cmm(I cmm);

    CryptographicMaterialsManager cmm();

    Builder legacyConfig(LegacyConfig legacyConfig);

    LegacyConfig legacyConfig();

    DynamoDbTableEncryptionConfig build();
  }

  static class BuilderImpl implements Builder {
    protected String partitionKeyName;

    protected String sortKeyName;

    protected Map<String, CryptoAction> attributeActions;

    protected List<String> allowedUnauthenticatedAttributes;

    protected String allowedUnauthenticatedAttributePrefix;

    protected Keyring keyring;

    protected CryptographicMaterialsManager cmm;

    protected LegacyConfig legacyConfig;

    protected BuilderImpl() {
    }

    protected BuilderImpl(DynamoDbTableEncryptionConfig model) {
      this.partitionKeyName = model.partitionKeyName();
      this.sortKeyName = model.sortKeyName();
      this.attributeActions = model.attributeActions();
      this.allowedUnauthenticatedAttributes = model.allowedUnauthenticatedAttributes();
      this.allowedUnauthenticatedAttributePrefix = model.allowedUnauthenticatedAttributePrefix();
      this.keyring = model.keyring();
      this.cmm = model.cmm();
      this.legacyConfig = model.legacyConfig();
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

    public <I extends IKeyring> Builder keyring(I keyring) {
      this.keyring = Keyring.create(keyring);
      return this;
    }

    public Keyring keyring() {
      return this.keyring;
    }

    public <I extends ICryptographicMaterialsManager> Builder cmm(I cmm) {
      this.cmm = CryptographicMaterialsManager.create(cmm);
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
    
    public DynamoDbTableEncryptionConfig build() {
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
