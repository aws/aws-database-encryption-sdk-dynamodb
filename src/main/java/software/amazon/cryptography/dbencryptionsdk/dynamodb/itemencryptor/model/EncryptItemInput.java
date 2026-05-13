// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model;

import java.util.Map;
import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * Inputs for encrypting a DynamoDB Item.
 */
public class EncryptItemInput {

  /**
   * The DynamoDB item to encrypt.
   */
  private final Map<String, AttributeValue> plaintextItem;

  protected EncryptItemInput(BuilderImpl builder) {
    this.plaintextItem = builder.plaintextItem();
  }

  /**
   * @return The DynamoDB item to encrypt.
   */
  public Map<String, AttributeValue> plaintextItem() {
    return this.plaintextItem;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param plaintextItem The DynamoDB item to encrypt.
     */
    Builder plaintextItem(Map<String, AttributeValue> plaintextItem);

    /**
     * @return The DynamoDB item to encrypt.
     */
    Map<String, AttributeValue> plaintextItem();

    EncryptItemInput build();
  }

  static class BuilderImpl implements Builder {

    protected Map<String, AttributeValue> plaintextItem;

    protected BuilderImpl() {}

    protected BuilderImpl(EncryptItemInput model) {
      this.plaintextItem = model.plaintextItem();
    }

    public Builder plaintextItem(Map<String, AttributeValue> plaintextItem) {
      this.plaintextItem = plaintextItem;
      return this;
    }

    public Map<String, AttributeValue> plaintextItem() {
      return this.plaintextItem;
    }

    public EncryptItemInput build() {
      if (Objects.isNull(this.plaintextItem())) {
        throw new IllegalArgumentException(
          "Missing value for required field `plaintextItem`"
        );
      }
      return new EncryptItemInput(this);
    }
  }
}
