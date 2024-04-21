// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.ExecuteTransactionRequest;

public class ExecuteTransactionInputTransformOutput {

  private final ExecuteTransactionRequest transformedInput;

  protected ExecuteTransactionInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  public ExecuteTransactionRequest transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedInput(ExecuteTransactionRequest transformedInput);

    ExecuteTransactionRequest transformedInput();

    ExecuteTransactionInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {

    protected ExecuteTransactionRequest transformedInput;

    protected BuilderImpl() {}

    protected BuilderImpl(ExecuteTransactionInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(
      ExecuteTransactionRequest transformedInput
    ) {
      this.transformedInput = transformedInput;
      return this;
    }

    public ExecuteTransactionRequest transformedInput() {
      return this.transformedInput;
    }

    public ExecuteTransactionInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedInput`"
        );
      }
      return new ExecuteTransactionInputTransformOutput(this);
    }
  }
}
