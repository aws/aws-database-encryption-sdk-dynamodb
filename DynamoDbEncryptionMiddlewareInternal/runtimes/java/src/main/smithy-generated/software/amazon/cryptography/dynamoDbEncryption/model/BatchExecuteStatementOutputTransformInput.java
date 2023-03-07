// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.BatchExecuteStatementInput;
import com.amazonaws.dynamodb.model.BatchExecuteStatementOutput;
import java.util.Objects;

public class BatchExecuteStatementOutputTransformInput {
  private final BatchExecuteStatementOutput sdkOutput;

  private final BatchExecuteStatementInput originalInput;

  protected BatchExecuteStatementOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public BatchExecuteStatementOutput sdkOutput() {
    return this.sdkOutput;
  }

  public BatchExecuteStatementInput originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(BatchExecuteStatementOutput sdkOutput);

    BatchExecuteStatementOutput sdkOutput();

    Builder originalInput(BatchExecuteStatementInput originalInput);

    BatchExecuteStatementInput originalInput();

    BatchExecuteStatementOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected BatchExecuteStatementOutput sdkOutput;

    protected BatchExecuteStatementInput originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(BatchExecuteStatementOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(BatchExecuteStatementOutput sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public BatchExecuteStatementOutput sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(BatchExecuteStatementInput originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public BatchExecuteStatementInput originalInput() {
      return this.originalInput;
    }

    public BatchExecuteStatementOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkOutput`");
      }
      if (Objects.isNull(this.originalInput()))  {
        throw new IllegalArgumentException("Missing value for required field `originalInput`");
      }
      return new BatchExecuteStatementOutputTransformInput(this);
    }
  }
}
