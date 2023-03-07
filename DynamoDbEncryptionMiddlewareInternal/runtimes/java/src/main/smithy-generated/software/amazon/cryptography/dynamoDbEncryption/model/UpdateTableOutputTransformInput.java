// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.UpdateTableInput;
import com.amazonaws.dynamodb.model.UpdateTableOutput;
import java.util.Objects;

public class UpdateTableOutputTransformInput {
  private final UpdateTableOutput sdkOutput;

  private final UpdateTableInput originalInput;

  protected UpdateTableOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public UpdateTableOutput sdkOutput() {
    return this.sdkOutput;
  }

  public UpdateTableInput originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(UpdateTableOutput sdkOutput);

    UpdateTableOutput sdkOutput();

    Builder originalInput(UpdateTableInput originalInput);

    UpdateTableInput originalInput();

    UpdateTableOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected UpdateTableOutput sdkOutput;

    protected UpdateTableInput originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(UpdateTableOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(UpdateTableOutput sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public UpdateTableOutput sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(UpdateTableInput originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public UpdateTableInput originalInput() {
      return this.originalInput;
    }

    public UpdateTableOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkOutput`");
      }
      if (Objects.isNull(this.originalInput()))  {
        throw new IllegalArgumentException("Missing value for required field `originalInput`");
      }
      return new UpdateTableOutputTransformInput(this);
    }
  }
}
