// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Map;
import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class GetBranchKeyIdFromDdbKeyInput {
  private final Map<String, AttributeValue> ddbKey;

  protected GetBranchKeyIdFromDdbKeyInput(BuilderImpl builder) {
    this.ddbKey = builder.ddbKey();
  }

  public Map<String, AttributeValue> ddbKey() {
    return this.ddbKey;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder ddbKey(Map<String, AttributeValue> ddbKey);

    Map<String, AttributeValue> ddbKey();

    GetBranchKeyIdFromDdbKeyInput build();
  }

  static class BuilderImpl implements Builder {
    protected Map<String, AttributeValue> ddbKey;

    protected BuilderImpl() {
    }

    protected BuilderImpl(GetBranchKeyIdFromDdbKeyInput model) {
      this.ddbKey = model.ddbKey();
    }

    public Builder ddbKey(Map<String, AttributeValue> ddbKey) {
      this.ddbKey = ddbKey;
      return this;
    }

    public Map<String, AttributeValue> ddbKey() {
      return this.ddbKey;
    }

    public GetBranchKeyIdFromDdbKeyInput build() {
      if (Objects.isNull(this.ddbKey()))  {
        throw new IllegalArgumentException("Missing value for required field `ddbKey`");
      }
      return new GetBranchKeyIdFromDdbKeyInput(this);
    }
  }
}
