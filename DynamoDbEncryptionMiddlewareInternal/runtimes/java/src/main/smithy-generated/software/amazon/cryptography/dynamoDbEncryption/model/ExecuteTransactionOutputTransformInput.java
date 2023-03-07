// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.ExecuteTransactionInput;
import com.amazonaws.dynamodb.model.ExecuteTransactionOutput;
import java.util.Objects;

public class ExecuteTransactionOutputTransformInput {
  private final ExecuteTransactionOutput sdkOutput;

  private final ExecuteTransactionInput originalInput;

  protected ExecuteTransactionOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public ExecuteTransactionOutput sdkOutput() {
    return this.sdkOutput;
  }

  public ExecuteTransactionInput originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(ExecuteTransactionOutput sdkOutput);

    ExecuteTransactionOutput sdkOutput();

    Builder originalInput(ExecuteTransactionInput originalInput);

    ExecuteTransactionInput originalInput();

    ExecuteTransactionOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected ExecuteTransactionOutput sdkOutput;

    protected ExecuteTransactionInput originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(ExecuteTransactionOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(ExecuteTransactionOutput sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public ExecuteTransactionOutput sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(ExecuteTransactionInput originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public ExecuteTransactionInput originalInput() {
      return this.originalInput;
    }

    public ExecuteTransactionOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkOutput`");
      }
      if (Objects.isNull(this.originalInput()))  {
        throw new IllegalArgumentException("Missing value for required field `originalInput`");
      }
      return new ExecuteTransactionOutputTransformInput(this);
    }
  }
}
