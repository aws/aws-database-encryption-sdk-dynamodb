// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.UpdateItemInput;
import java.util.Objects;

public class UpdateItemInputTransformInput {
  private final UpdateItemInput sdkInput;

  protected UpdateItemInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public UpdateItemInput sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(UpdateItemInput sdkInput);

    UpdateItemInput sdkInput();

    UpdateItemInputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected UpdateItemInput sdkInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(UpdateItemInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(UpdateItemInput sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public UpdateItemInput sdkInput() {
      return this.sdkInput;
    }

    public UpdateItemInputTransformInput build() {
      if (Objects.isNull(this.sdkInput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkInput`");
      }
      return new UpdateItemInputTransformInput(this);
    }
  }
}
