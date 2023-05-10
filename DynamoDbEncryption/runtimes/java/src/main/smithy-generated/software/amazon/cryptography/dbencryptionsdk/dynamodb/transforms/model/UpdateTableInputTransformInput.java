// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.UpdateTableRequest;

public class UpdateTableInputTransformInput {
  private final UpdateTableRequest sdkInput;

  protected UpdateTableInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public UpdateTableRequest sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(UpdateTableRequest sdkInput);

    UpdateTableRequest sdkInput();

    UpdateTableInputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected UpdateTableRequest sdkInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(UpdateTableInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(UpdateTableRequest sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public UpdateTableRequest sdkInput() {
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
