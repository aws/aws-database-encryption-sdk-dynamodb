// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model;

// TODO manually updated the below DDB import to point to the right place
// TODO manually updated native type name, i.e. Input->Request Output->Result
import com.amazonaws.services.dynamodbv2.model.BatchExecuteStatementRequest;
import java.util.Objects;

public class BatchExecuteStatementInputTransformOutput {
  private final BatchExecuteStatementRequest transformedInput;

  protected BatchExecuteStatementInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  public BatchExecuteStatementRequest transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedInput(BatchExecuteStatementRequest transformedInput);

    BatchExecuteStatementRequest transformedInput();

    BatchExecuteStatementInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected BatchExecuteStatementRequest transformedInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(BatchExecuteStatementInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(BatchExecuteStatementRequest transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public BatchExecuteStatementRequest transformedInput() {
      return this.transformedInput;
    }

    public BatchExecuteStatementInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedInput`");
      }
      return new BatchExecuteStatementInputTransformOutput(this);
    }
  }
}
