// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.BatchWriteItemInput;
import com.amazonaws.dynamodb.model.BatchWriteItemOutput;
import java.util.Objects;

public class BatchWriteItemOutputTransformInput {
  private final BatchWriteItemOutput sdkOutput;

  private final BatchWriteItemInput originalInput;

  protected BatchWriteItemOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public BatchWriteItemOutput sdkOutput() {
    return this.sdkOutput;
  }

  public BatchWriteItemInput originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(BatchWriteItemOutput sdkOutput);

    BatchWriteItemOutput sdkOutput();

    Builder originalInput(BatchWriteItemInput originalInput);

    BatchWriteItemInput originalInput();

    BatchWriteItemOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected BatchWriteItemOutput sdkOutput;

    protected BatchWriteItemInput originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(BatchWriteItemOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(BatchWriteItemOutput sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public BatchWriteItemOutput sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(BatchWriteItemInput originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public BatchWriteItemInput originalInput() {
      return this.originalInput;
    }

    public BatchWriteItemOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkOutput`");
      }
      if (Objects.isNull(this.originalInput()))  {
        throw new IllegalArgumentException("Missing value for required field `originalInput`");
      }
      return new BatchWriteItemOutputTransformInput(this);
    }
  }
}
