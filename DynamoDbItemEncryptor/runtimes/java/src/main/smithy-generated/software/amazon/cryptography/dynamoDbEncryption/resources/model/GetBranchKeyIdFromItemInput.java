// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.resources.model;

import java.util.Map;
import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class GetBranchKeyIdFromItemInput {
  private final Map<String, AttributeValue> ddbItem;

  protected GetBranchKeyIdFromItemInput(BuilderImpl builder) {
    this.ddbItem = builder.ddbItem();
  }

  public Map<String, AttributeValue> ddbItem() {
    return this.ddbItem;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder ddbItem(Map<String, AttributeValue> ddbItem);

    Map<String, AttributeValue> ddbItem();

    GetBranchKeyIdFromItemInput build();
  }

  static class BuilderImpl implements Builder {
    protected Map<String, AttributeValue> ddbItem;

    protected BuilderImpl() {
    }

    protected BuilderImpl(GetBranchKeyIdFromItemInput model) {
      this.ddbItem = model.ddbItem();
    }

    public Builder ddbItem(Map<String, AttributeValue> ddbItem) {
      this.ddbItem = ddbItem;
      return this;
    }

    public Map<String, AttributeValue> ddbItem() {
      return this.ddbItem;
    }

    public GetBranchKeyIdFromItemInput build() {
      if (Objects.isNull(this.ddbItem()))  {
        throw new IllegalArgumentException("Missing value for required field `ddbItem`");
      }
      return new GetBranchKeyIdFromItemInput(this);
    }
  }
}
