// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.GetItemInput;
import java.util.Objects;

public class GetItemInputTransformInput {
  private final GetItemInput sdkInput;

  protected GetItemInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public GetItemInput sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(GetItemInput sdkInput);

    GetItemInput sdkInput();

    GetItemInputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected GetItemInput sdkInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(GetItemInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(GetItemInput sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public GetItemInput sdkInput() {
      return this.sdkInput;
    }

    public GetItemInputTransformInput build() {
      if (Objects.isNull(this.sdkInput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkInput`");
      }
      return new GetItemInputTransformInput(this);
    }
  }
}
