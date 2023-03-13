// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbItemEncryptor.model;

import java.util.Map;
import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class EncryptItemOutput {
  private final Map<String, AttributeValue> encryptedItem;

  protected EncryptItemOutput(BuilderImpl builder) {
    this.encryptedItem = builder.encryptedItem();
  }

  public Map<String, AttributeValue> encryptedItem() {
    return this.encryptedItem;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder encryptedItem(Map<String, AttributeValue> encryptedItem);

    Map<String, AttributeValue> encryptedItem();

    EncryptItemOutput build();
  }

  static class BuilderImpl implements Builder {
    protected Map<String, AttributeValue> encryptedItem;

    protected BuilderImpl() {
    }

    protected BuilderImpl(EncryptItemOutput model) {
      this.encryptedItem = model.encryptedItem();
    }

    public Builder encryptedItem(Map<String, AttributeValue> encryptedItem) {
      this.encryptedItem = encryptedItem;
      return this;
    }

    public Map<String, AttributeValue> encryptedItem() {
      return this.encryptedItem;
    }

    public EncryptItemOutput build() {
      if (Objects.isNull(this.encryptedItem()))  {
        throw new IllegalArgumentException("Missing value for required field `encryptedItem`");
      }
      return new EncryptItemOutput(this);
    }
  }
}
