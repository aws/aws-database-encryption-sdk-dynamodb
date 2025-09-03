// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.ILegacyDynamoDbEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.LegacyDynamoDbEncryptor;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;

/**
 * A configuration for overriding encryption and/or decryption to instead perform legacy encryption and decryption.
 */
public class LegacyOverride {

  /**
   * A policy which configures whether legacy behavior overrides encryption and/or decryption.
   */
  private final LegacyPolicy policy;

  /**
   * A configuration for the legacy DynamoDB Encryption Client's Encryptor.
   */
  private final ILegacyDynamoDbEncryptor encryptor;

  /**
   * Overrides which attributes are encrypted and/or signed for any items read or written with legacy behavior.
   */
  private final Map<String, CryptoAction> attributeActionsOnEncrypt;

  /**
   * This input is not used in the Java Client and should not be specified.
   */
  private final CryptoAction defaultAttributeFlag;

  protected LegacyOverride(BuilderImpl builder) {
    this.policy = builder.policy();
    this.encryptor = builder.encryptor();
    this.attributeActionsOnEncrypt = builder.attributeActionsOnEncrypt();
    this.defaultAttributeFlag = builder.defaultAttributeFlag();
  }

  /**
   * @return A policy which configures whether legacy behavior overrides encryption and/or decryption.
   */
  public LegacyPolicy policy() {
    return this.policy;
  }

  /**
   * @return A configuration for the legacy DynamoDB Encryption Client's Encryptor.
   */
  public ILegacyDynamoDbEncryptor encryptor() {
    return this.encryptor;
  }

  /**
   * @return Overrides which attributes are encrypted and/or signed for any items read or written with legacy behavior.
   */
  public Map<String, CryptoAction> attributeActionsOnEncrypt() {
    return this.attributeActionsOnEncrypt;
  }

  /**
   * @return This input is not used in the Java Client and should not be specified.
   */
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
    /**
     * @param policy A policy which configures whether legacy behavior overrides encryption and/or decryption.
     */
    Builder policy(LegacyPolicy policy);

    /**
     * @return A policy which configures whether legacy behavior overrides encryption and/or decryption.
     */
    LegacyPolicy policy();

    /**
     * @param encryptor A configuration for the legacy DynamoDB Encryption Client's Encryptor.
     */
    Builder encryptor(ILegacyDynamoDbEncryptor encryptor);

    /**
     * @return A configuration for the legacy DynamoDB Encryption Client's Encryptor.
     */
    ILegacyDynamoDbEncryptor encryptor();

    /**
     * @param attributeActionsOnEncrypt Overrides which attributes are encrypted and/or signed for any items read or written with legacy behavior.
     */
    Builder attributeActionsOnEncrypt(
      Map<String, CryptoAction> attributeActionsOnEncrypt
    );

    /**
     * @return Overrides which attributes are encrypted and/or signed for any items read or written with legacy behavior.
     */
    Map<String, CryptoAction> attributeActionsOnEncrypt();

    /**
     * @param defaultAttributeFlag This input is not used in the Java Client and should not be specified.
     */
    Builder defaultAttributeFlag(CryptoAction defaultAttributeFlag);

    /**
     * @return This input is not used in the Java Client and should not be specified.
     */
    CryptoAction defaultAttributeFlag();

    LegacyOverride build();
  }

  static class BuilderImpl implements Builder {

    protected LegacyPolicy policy;

    protected ILegacyDynamoDbEncryptor encryptor;

    protected Map<String, CryptoAction> attributeActionsOnEncrypt;

    protected CryptoAction defaultAttributeFlag;

    protected BuilderImpl() {}

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

    public Builder attributeActionsOnEncrypt(
      Map<String, CryptoAction> attributeActionsOnEncrypt
    ) {
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
      if (Objects.isNull(this.policy())) {
        throw new IllegalArgumentException(
          "Missing value for required field `policy`"
        );
      }
      if (Objects.isNull(this.encryptor())) {
        throw new IllegalArgumentException(
          "Missing value for required field `encryptor`"
        );
      }
      if (Objects.isNull(this.attributeActionsOnEncrypt())) {
        throw new IllegalArgumentException(
          "Missing value for required field `attributeActionsOnEncrypt`"
        );
      }
      return new LegacyOverride(this);
    }
  }
}
