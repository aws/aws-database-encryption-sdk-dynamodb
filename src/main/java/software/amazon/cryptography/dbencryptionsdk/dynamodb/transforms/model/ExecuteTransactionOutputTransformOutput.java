// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.ExecuteTransactionResponse;

public class ExecuteTransactionOutputTransformOutput {

  private final ExecuteTransactionResponse transformedOutput;

  protected ExecuteTransactionOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public ExecuteTransactionResponse transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(ExecuteTransactionResponse transformedOutput);

    ExecuteTransactionResponse transformedOutput();

    ExecuteTransactionOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {

    protected ExecuteTransactionResponse transformedOutput;

    protected BuilderImpl() {}

    protected BuilderImpl(ExecuteTransactionOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(
      ExecuteTransactionResponse transformedOutput
    ) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public ExecuteTransactionResponse transformedOutput() {
      return this.transformedOutput;
    }

    public ExecuteTransactionOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedOutput`"
        );
      }
      return new ExecuteTransactionOutputTransformOutput(this);
    }
  }
}
