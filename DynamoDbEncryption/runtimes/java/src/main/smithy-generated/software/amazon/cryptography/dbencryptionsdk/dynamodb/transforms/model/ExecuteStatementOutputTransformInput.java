// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.ExecuteStatementRequest;
import software.amazon.awssdk.services.dynamodb.model.ExecuteStatementResponse;

public class ExecuteStatementOutputTransformInput {

  private final ExecuteStatementResponse sdkOutput;

  private final ExecuteStatementRequest originalInput;

  protected ExecuteStatementOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public ExecuteStatementResponse sdkOutput() {
    return this.sdkOutput;
  }

  public ExecuteStatementRequest originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(ExecuteStatementResponse sdkOutput);

    ExecuteStatementResponse sdkOutput();

    Builder originalInput(ExecuteStatementRequest originalInput);

    ExecuteStatementRequest originalInput();

    ExecuteStatementOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {

    protected ExecuteStatementResponse sdkOutput;

    protected ExecuteStatementRequest originalInput;

    protected BuilderImpl() {}

    protected BuilderImpl(ExecuteStatementOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(ExecuteStatementResponse sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public ExecuteStatementResponse sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(ExecuteStatementRequest originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public ExecuteStatementRequest originalInput() {
      return this.originalInput;
    }

    public ExecuteStatementOutputTransformInput build() {
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
      return new ExecuteStatementOutputTransformInput(this);
    }
  }
}
