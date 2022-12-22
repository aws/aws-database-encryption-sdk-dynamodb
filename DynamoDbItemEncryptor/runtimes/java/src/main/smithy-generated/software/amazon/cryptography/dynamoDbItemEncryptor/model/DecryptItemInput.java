// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbItemEncryptor.model;

// TODO manually updated the below DDB import to point to the right place
// TODO manually updated native type name, i.e. Input->Request Output->Result
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import java.util.Map;
import java.util.Objects;

public class DecryptItemInput {
  private final Map<String, AttributeValue> encryptedItem;

  protected DecryptItemInput(BuilderImpl builder) {
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

    DecryptItemInput build();
  }

  static class BuilderImpl implements Builder {
    protected Map<String, AttributeValue> encryptedItem;

    protected BuilderImpl() {
    }

    protected BuilderImpl(DecryptItemInput model) {
      this.encryptedItem = model.encryptedItem();
    }

    public Builder encryptedItem(Map<String, AttributeValue> encryptedItem) {
      this.encryptedItem = encryptedItem;
      return this;
    }

    public Map<String, AttributeValue> encryptedItem() {
      return this.encryptedItem;
    }

    public DecryptItemInput build() {
      if (Objects.isNull(this.encryptedItem()))  {
        throw new IllegalArgumentException("Missing value for required field `encryptedItem`");
      }
      return new DecryptItemInput(this);
    }
  }
}
