// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.ExecuteStatementRequest;

public class ExecuteStatementInputTransformOutput {

  private final ExecuteStatementRequest transformedInput;

  protected ExecuteStatementInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  public ExecuteStatementRequest transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedInput(ExecuteStatementRequest transformedInput);

    ExecuteStatementRequest transformedInput();

    ExecuteStatementInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {

    protected ExecuteStatementRequest transformedInput;

    protected BuilderImpl() {}

    protected BuilderImpl(ExecuteStatementInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(ExecuteStatementRequest transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public ExecuteStatementRequest transformedInput() {
      return this.transformedInput;
    }

    public ExecuteStatementInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedInput`"
        );
      }
      return new ExecuteStatementInputTransformOutput(this);
    }
  }
}
