// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.BatchExecuteStatementResponse;

public class BatchExecuteStatementOutputTransformOutput {

  private final BatchExecuteStatementResponse transformedOutput;

  protected BatchExecuteStatementOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public BatchExecuteStatementResponse transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(BatchExecuteStatementResponse transformedOutput);

    BatchExecuteStatementResponse transformedOutput();

    BatchExecuteStatementOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {

    protected BatchExecuteStatementResponse transformedOutput;

    protected BuilderImpl() {}

    protected BuilderImpl(BatchExecuteStatementOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(
      BatchExecuteStatementResponse transformedOutput
    ) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public BatchExecuteStatementResponse transformedOutput() {
      return this.transformedOutput;
    }

    public BatchExecuteStatementOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedOutput`"
        );
      }
      return new BatchExecuteStatementOutputTransformOutput(this);
    }
  }
}
