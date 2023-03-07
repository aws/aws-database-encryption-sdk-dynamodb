// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.BatchExecuteStatementOutput;
import java.util.Objects;

public class BatchExecuteStatementOutputTransformOutput {
  private final BatchExecuteStatementOutput transformedOutput;

  protected BatchExecuteStatementOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public BatchExecuteStatementOutput transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(BatchExecuteStatementOutput transformedOutput);

    BatchExecuteStatementOutput transformedOutput();

    BatchExecuteStatementOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected BatchExecuteStatementOutput transformedOutput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(BatchExecuteStatementOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(BatchExecuteStatementOutput transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public BatchExecuteStatementOutput transformedOutput() {
      return this.transformedOutput;
    }

    public BatchExecuteStatementOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedOutput`");
      }
      return new BatchExecuteStatementOutputTransformOutput(this);
    }
  }
}
