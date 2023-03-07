// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.DeleteItemInput;
import com.amazonaws.dynamodb.model.DeleteItemOutput;
import java.util.Objects;

public class DeleteItemOutputTransformInput {
  private final DeleteItemOutput sdkOutput;

  private final DeleteItemInput originalInput;

  protected DeleteItemOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public DeleteItemOutput sdkOutput() {
    return this.sdkOutput;
  }

  public DeleteItemInput originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(DeleteItemOutput sdkOutput);

    DeleteItemOutput sdkOutput();

    Builder originalInput(DeleteItemInput originalInput);

    DeleteItemInput originalInput();

    DeleteItemOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected DeleteItemOutput sdkOutput;

    protected DeleteItemInput originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(DeleteItemOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(DeleteItemOutput sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public DeleteItemOutput sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(DeleteItemInput originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public DeleteItemInput originalInput() {
      return this.originalInput;
    }

    public DeleteItemOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkOutput`");
      }
      if (Objects.isNull(this.originalInput()))  {
        throw new IllegalArgumentException("Missing value for required field `originalInput`");
      }
      return new DeleteItemOutputTransformInput(this);
    }
  }
}
