// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.BatchExecuteStatementRequest;

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

    protected BuilderImpl() {}

    protected BuilderImpl(BatchExecuteStatementInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(
      BatchExecuteStatementRequest transformedInput
    ) {
      this.transformedInput = transformedInput;
      return this;
    }

    public BatchExecuteStatementRequest transformedInput() {
      return this.transformedInput;
    }

    public BatchExecuteStatementInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedInput`"
        );
      }
      return new BatchExecuteStatementInputTransformOutput(this);
    }
  }
}
