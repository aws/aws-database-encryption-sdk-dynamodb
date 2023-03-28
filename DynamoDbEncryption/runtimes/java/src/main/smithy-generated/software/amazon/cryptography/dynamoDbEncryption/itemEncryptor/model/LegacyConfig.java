// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model;

import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.ILegacyDynamoDbEncryptor;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.LegacyDynamoDbEncryptor;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;

public class LegacyConfig {
  private final LegacyPolicy policy;

  private final LegacyDynamoDbEncryptor encryptor;

  private final Map<String, CryptoAction> attributeFlags;

  private final CryptoAction defaultAttributeFlag;

  protected LegacyConfig(BuilderImpl builder) {
    this.policy = builder.policy();
    this.encryptor = builder.encryptor();
    this.attributeFlags = builder.attributeFlags();
    this.defaultAttributeFlag = builder.defaultAttributeFlag();
  }

  public LegacyPolicy policy() {
    return this.policy;
  }

  public LegacyDynamoDbEncryptor encryptor() {
    return this.encryptor;
  }

  public Map<String, CryptoAction> attributeFlags() {
    return this.attributeFlags;
  }

  public CryptoAction defaultAttributeFlag() {
    return this.defaultAttributeFlag;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder policy(LegacyPolicy policy);

    LegacyPolicy policy();

    Builder encryptor(ILegacyDynamoDbEncryptor encryptor);

    LegacyDynamoDbEncryptor encryptor();

    Builder attributeFlags(Map<String, CryptoAction> attributeFlags);

    Map<String, CryptoAction> attributeFlags();

    Builder defaultAttributeFlag(CryptoAction defaultAttributeFlag);

    CryptoAction defaultAttributeFlag();

    LegacyConfig build();
  }

  static class BuilderImpl implements Builder {
    protected LegacyPolicy policy;

    protected LegacyDynamoDbEncryptor encryptor;

    protected Map<String, CryptoAction> attributeFlags;

    protected CryptoAction defaultAttributeFlag;

    protected BuilderImpl() {
    }

    protected BuilderImpl(LegacyConfig model) {
      this.policy = model.policy();
      this.encryptor = model.encryptor();
      this.attributeFlags = model.attributeFlags();
      this.defaultAttributeFlag = model.defaultAttributeFlag();
    }

    public Builder policy(LegacyPolicy policy) {
      this.policy = policy;
      return this;
    }

    public LegacyPolicy policy() {
      return this.policy;
    }

    public Builder encryptor(ILegacyDynamoDbEncryptor encryptor) {
      this.encryptor = LegacyDynamoDbEncryptor.wrap(encryptor);
      return this;
    }

    public LegacyDynamoDbEncryptor encryptor() {
      return this.encryptor;
    }

    public Builder attributeFlags(Map<String, CryptoAction> attributeFlags) {
      this.attributeFlags = attributeFlags;
      return this;
    }

    public Map<String, CryptoAction> attributeFlags() {
      return this.attributeFlags;
    }

    public Builder defaultAttributeFlag(CryptoAction defaultAttributeFlag) {
      this.defaultAttributeFlag = defaultAttributeFlag;
      return this;
    }

    public CryptoAction defaultAttributeFlag() {
      return this.defaultAttributeFlag;
    }

    public LegacyConfig build() {
      if (Objects.isNull(this.policy()))  {
        throw new IllegalArgumentException("Missing value for required field `policy`");
      }
      if (Objects.isNull(this.encryptor()))  {
        throw new IllegalArgumentException("Missing value for required field `encryptor`");
      }
      if (Objects.isNull(this.attributeFlags()))  {
        throw new IllegalArgumentException("Missing value for required field `attributeFlags`");
      }
      return new LegacyConfig(this);
    }
  }
}
