// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model;

// TODO manually updated the below DDB import to point to the right place
// TODO manually updated native type name, i.e. Input->Request Output->Result
import com.amazonaws.services.dynamodbv2.model.ExecuteStatementResult;
import java.util.Objects;

public class ExecuteStatementOutputTransformOutput {
  private final ExecuteStatementResult transformedOutput;

  protected ExecuteStatementOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public ExecuteStatementResult transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(ExecuteStatementResult transformedOutput);

    ExecuteStatementResult transformedOutput();

    ExecuteStatementOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected ExecuteStatementResult transformedOutput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(ExecuteStatementOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(ExecuteStatementResult transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public ExecuteStatementResult transformedOutput() {
      return this.transformedOutput;
    }

    public ExecuteStatementOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedOutput`");
      }
      return new ExecuteStatementOutputTransformOutput(this);
    }
  }
}
