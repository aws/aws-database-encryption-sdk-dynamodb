// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.ILegacyDynamoDbEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.LegacyDynamoDbEncryptor;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;

public class LegacyOverride {
  private final LegacyPolicy policy;

  private final ILegacyDynamoDbEncryptor encryptor;

  private final Map<String, CryptoAction> attributeActionsOnEncrypt;

  private final CryptoAction defaultAttributeFlag;

  protected LegacyOverride(BuilderImpl builder) {
    this.policy = builder.policy();
    this.encryptor = builder.encryptor();
    this.attributeActionsOnEncrypt = builder.attributeActionsOnEncrypt();
    this.defaultAttributeFlag = builder.defaultAttributeFlag();
  }

  public LegacyPolicy policy() {
    return this.policy;
  }

  public ILegacyDynamoDbEncryptor encryptor() {
    return this.encryptor;
  }

  public Map<String, CryptoAction> attributeActionsOnEncrypt() {
    return this.attributeActionsOnEncrypt;
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

    ILegacyDynamoDbEncryptor encryptor();

    Builder attributeActionsOnEncrypt(Map<String, CryptoAction> attributeActionsOnEncrypt);

    Map<String, CryptoAction> attributeActionsOnEncrypt();

    Builder defaultAttributeFlag(CryptoAction defaultAttributeFlag);

    CryptoAction defaultAttributeFlag();

    LegacyOverride build();
  }

  static class BuilderImpl implements Builder {
    protected LegacyPolicy policy;

    protected ILegacyDynamoDbEncryptor encryptor;

    protected Map<String, CryptoAction> attributeActionsOnEncrypt;

    protected CryptoAction defaultAttributeFlag;

    protected BuilderImpl() {
    }

    protected BuilderImpl(LegacyOverride model) {
      this.policy = model.policy();
      this.encryptor = model.encryptor();
      this.attributeActionsOnEncrypt = model.attributeActionsOnEncrypt();
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

    public ILegacyDynamoDbEncryptor encryptor() {
      return this.encryptor;
    }

    public Builder attributeActionsOnEncrypt(Map<String, CryptoAction> attributeActionsOnEncrypt) {
      this.attributeActionsOnEncrypt = attributeActionsOnEncrypt;
      return this;
    }

    public Map<String, CryptoAction> attributeActionsOnEncrypt() {
      return this.attributeActionsOnEncrypt;
    }

    public Builder defaultAttributeFlag(CryptoAction defaultAttributeFlag) {
      this.defaultAttributeFlag = defaultAttributeFlag;
      return this;
    }

    public CryptoAction defaultAttributeFlag() {
      return this.defaultAttributeFlag;
    }

    public LegacyOverride build() {
      if (Objects.isNull(this.policy()))  {
        throw new IllegalArgumentException("Missing value for required field `policy`");
      }
      if (Objects.isNull(this.encryptor()))  {
        throw new IllegalArgumentException("Missing value for required field `encryptor`");
      }
      if (Objects.isNull(this.attributeActionsOnEncrypt()))  {
        throw new IllegalArgumentException("Missing value for required field `attributeActionsOnEncrypt`");
      }
      return new LegacyOverride(this);
    }
  }
}
