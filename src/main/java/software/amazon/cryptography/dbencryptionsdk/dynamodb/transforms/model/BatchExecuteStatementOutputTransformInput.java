// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.BatchExecuteStatementRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchExecuteStatementResponse;

public class BatchExecuteStatementOutputTransformInput {

  private final BatchExecuteStatementResponse sdkOutput;

  private final BatchExecuteStatementRequest originalInput;

  protected BatchExecuteStatementOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public BatchExecuteStatementResponse sdkOutput() {
    return this.sdkOutput;
  }

  public BatchExecuteStatementRequest originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(BatchExecuteStatementResponse sdkOutput);

    BatchExecuteStatementResponse sdkOutput();

    Builder originalInput(BatchExecuteStatementRequest originalInput);

    BatchExecuteStatementRequest originalInput();

    BatchExecuteStatementOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {

    protected BatchExecuteStatementResponse sdkOutput;

    protected BatchExecuteStatementRequest originalInput;

    protected BuilderImpl() {}

    protected BuilderImpl(BatchExecuteStatementOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(BatchExecuteStatementResponse sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public BatchExecuteStatementResponse sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(BatchExecuteStatementRequest originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public BatchExecuteStatementRequest originalInput() {
      return this.originalInput;
    }

    public BatchExecuteStatementOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `sdkOutput`"
        );
      }
      if (Objects.isNull(this.originalInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `originalInput`"
        );
      }
      return new BatchExecuteStatementOutputTransformInput(this);
    }
  }
}
