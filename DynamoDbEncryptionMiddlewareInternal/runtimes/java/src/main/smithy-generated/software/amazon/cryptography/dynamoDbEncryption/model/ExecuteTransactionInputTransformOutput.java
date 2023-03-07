// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.ExecuteTransactionInput;
import java.util.Objects;

public class ExecuteTransactionInputTransformOutput {
  private final ExecuteTransactionInput transformedInput;

  protected ExecuteTransactionInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  public ExecuteTransactionInput transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedInput(ExecuteTransactionInput transformedInput);

    ExecuteTransactionInput transformedInput();

    ExecuteTransactionInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected ExecuteTransactionInput transformedInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(ExecuteTransactionInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(ExecuteTransactionInput transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public ExecuteTransactionInput transformedInput() {
      return this.transformedInput;
    }

    public ExecuteTransactionInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedInput`");
      }
      return new ExecuteTransactionInputTransformOutput(this);
    }
  }
}
