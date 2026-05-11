// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.ExecuteTransactionRequest;
import software.amazon.awssdk.services.dynamodb.model.ExecuteTransactionResponse;

public class ExecuteTransactionOutputTransformInput {

  private final ExecuteTransactionResponse sdkOutput;

  private final ExecuteTransactionRequest originalInput;

  protected ExecuteTransactionOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public ExecuteTransactionResponse sdkOutput() {
    return this.sdkOutput;
  }

  public ExecuteTransactionRequest originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(ExecuteTransactionResponse sdkOutput);

    ExecuteTransactionResponse sdkOutput();

    Builder originalInput(ExecuteTransactionRequest originalInput);

    ExecuteTransactionRequest originalInput();

    ExecuteTransactionOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {

    protected ExecuteTransactionResponse sdkOutput;

    protected ExecuteTransactionRequest originalInput;

    protected BuilderImpl() {}

    protected BuilderImpl(ExecuteTransactionOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(ExecuteTransactionResponse sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public ExecuteTransactionResponse sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(ExecuteTransactionRequest originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public ExecuteTransactionRequest originalInput() {
      return this.originalInput;
    }

    public ExecuteTransactionOutputTransformInput build() {
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
      return new ExecuteTransactionOutputTransformInput(this);
    }
  }
}
