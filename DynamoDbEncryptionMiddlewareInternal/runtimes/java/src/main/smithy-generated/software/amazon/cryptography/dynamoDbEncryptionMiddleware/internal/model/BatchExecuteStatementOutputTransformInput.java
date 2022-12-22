// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model;

// TODO manually updated the below DDB import to point to the right place
// TODO manually updated native type name, i.e. Input->Request Output->Result
import com.amazonaws.services.dynamodbv2.model.BatchExecuteStatementRequest;
import com.amazonaws.services.dynamodbv2.model.BatchExecuteStatementResult;
import java.util.Objects;

public class BatchExecuteStatementOutputTransformInput {
  private final BatchExecuteStatementResult sdkOutput;

  private final BatchExecuteStatementRequest originalInput;

  protected BatchExecuteStatementOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public BatchExecuteStatementResult sdkOutput() {
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
    Builder sdkOutput(BatchExecuteStatementResult sdkOutput);

    BatchExecuteStatementResult sdkOutput();

    Builder originalInput(BatchExecuteStatementRequest originalInput);

    BatchExecuteStatementRequest originalInput();

    BatchExecuteStatementOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected BatchExecuteStatementResult sdkOutput;

    protected BatchExecuteStatementRequest originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(BatchExecuteStatementOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(BatchExecuteStatementResult sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public BatchExecuteStatementResult sdkOutput() {
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
