// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.UpdateItemInput;
import com.amazonaws.dynamodb.model.UpdateItemOutput;
import java.util.Objects;

public class UpdateItemOutputTransformInput {
  private final UpdateItemOutput sdkOutput;

  private final UpdateItemInput originalInput;

  protected UpdateItemOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public UpdateItemOutput sdkOutput() {
    return this.sdkOutput;
  }

  public UpdateItemInput originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(UpdateItemOutput sdkOutput);

    UpdateItemOutput sdkOutput();

    Builder originalInput(UpdateItemInput originalInput);

    UpdateItemInput originalInput();

    UpdateItemOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected UpdateItemOutput sdkOutput;

    protected UpdateItemInput originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(UpdateItemOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(UpdateItemOutput sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public UpdateItemOutput sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(UpdateItemInput originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public UpdateItemInput originalInput() {
      return this.originalInput;
    }

    public UpdateItemOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkOutput`");
      }
      if (Objects.isNull(this.originalInput()))  {
        throw new IllegalArgumentException("Missing value for required field `originalInput`");
      }
      return new UpdateItemOutputTransformInput(this);
    }
  }
}
