// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.UpdateTableInput;
import java.util.Objects;

public class UpdateTableInputTransformInput {
  private final UpdateTableInput sdkInput;

  protected UpdateTableInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public UpdateTableInput sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(UpdateTableInput sdkInput);

    UpdateTableInput sdkInput();

    UpdateTableInputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected UpdateTableInput sdkInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(UpdateTableInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(UpdateTableInput sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public UpdateTableInput sdkInput() {
      return this.sdkInput;
    }

    public UpdateTableInputTransformInput build() {
      if (Objects.isNull(this.sdkInput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkInput`");
      }
      return new UpdateTableInputTransformInput(this);
    }
  }
}
