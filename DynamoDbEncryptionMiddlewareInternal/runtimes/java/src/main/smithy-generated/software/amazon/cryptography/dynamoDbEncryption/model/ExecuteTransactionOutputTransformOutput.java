// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.ExecuteTransactionOutput;
import java.util.Objects;

public class ExecuteTransactionOutputTransformOutput {
  private final ExecuteTransactionOutput transformedOutput;

  protected ExecuteTransactionOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public ExecuteTransactionOutput transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(ExecuteTransactionOutput transformedOutput);

    ExecuteTransactionOutput transformedOutput();

    ExecuteTransactionOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected ExecuteTransactionOutput transformedOutput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(ExecuteTransactionOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(ExecuteTransactionOutput transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public ExecuteTransactionOutput transformedOutput() {
      return this.transformedOutput;
    }

    public ExecuteTransactionOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedOutput`");
      }
      return new ExecuteTransactionOutputTransformOutput(this);
    }
  }
}
