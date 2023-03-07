// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.BatchGetItemInput;
import com.amazonaws.dynamodb.model.BatchGetItemOutput;
import java.util.Objects;

public class BatchGetItemOutputTransformInput {
  private final BatchGetItemOutput sdkOutput;

  private final BatchGetItemInput originalInput;

  protected BatchGetItemOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public BatchGetItemOutput sdkOutput() {
    return this.sdkOutput;
  }

  public BatchGetItemInput originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(BatchGetItemOutput sdkOutput);

    BatchGetItemOutput sdkOutput();

    Builder originalInput(BatchGetItemInput originalInput);

    BatchGetItemInput originalInput();

    BatchGetItemOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected BatchGetItemOutput sdkOutput;

    protected BatchGetItemInput originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(BatchGetItemOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(BatchGetItemOutput sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public BatchGetItemOutput sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(BatchGetItemInput originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public BatchGetItemInput originalInput() {
      return this.originalInput;
    }

    public BatchGetItemOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkOutput`");
      }
      if (Objects.isNull(this.originalInput()))  {
        throw new IllegalArgumentException("Missing value for required field `originalInput`");
      }
      return new BatchGetItemOutputTransformInput(this);
    }
  }
}
