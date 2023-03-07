// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.BatchExecuteStatementInput;
import java.util.Objects;

public class BatchExecuteStatementInputTransformOutput {
  private final BatchExecuteStatementInput transformedInput;

  protected BatchExecuteStatementInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  public BatchExecuteStatementInput transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedInput(BatchExecuteStatementInput transformedInput);

    BatchExecuteStatementInput transformedInput();

    BatchExecuteStatementInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected BatchExecuteStatementInput transformedInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(BatchExecuteStatementInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(BatchExecuteStatementInput transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public BatchExecuteStatementInput transformedInput() {
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
