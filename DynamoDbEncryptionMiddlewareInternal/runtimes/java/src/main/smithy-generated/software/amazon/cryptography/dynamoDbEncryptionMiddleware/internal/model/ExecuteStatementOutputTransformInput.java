// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model;

// TODO manually updated the below DDB import to point to the right place
// TODO manually updated native type name, i.e. Input->Request Output->Result
import com.amazonaws.services.dynamodbv2.model.ExecuteStatementRequest;
import com.amazonaws.services.dynamodbv2.model.ExecuteStatementResult;
import java.util.Objects;

public class ExecuteStatementOutputTransformInput {
  private final ExecuteStatementResult sdkOutput;

  private final ExecuteStatementRequest originalInput;

  protected ExecuteStatementOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public ExecuteStatementResult sdkOutput() {
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
    Builder sdkOutput(ExecuteStatementResult sdkOutput);

    ExecuteStatementResult sdkOutput();

    Builder originalInput(ExecuteStatementRequest originalInput);

    ExecuteStatementRequest originalInput();

    ExecuteStatementOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected ExecuteStatementResult sdkOutput;

    protected ExecuteStatementRequest originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(ExecuteStatementOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(ExecuteStatementResult sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public ExecuteStatementResult sdkOutput() {
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
      if (Objects.isNull(this.sdkOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkOutput`");
      }
      if (Objects.isNull(this.originalInput()))  {
        throw new IllegalArgumentException("Missing value for required field `originalInput`");
      }
      return new ExecuteStatementOutputTransformInput(this);
    }
  }
}
