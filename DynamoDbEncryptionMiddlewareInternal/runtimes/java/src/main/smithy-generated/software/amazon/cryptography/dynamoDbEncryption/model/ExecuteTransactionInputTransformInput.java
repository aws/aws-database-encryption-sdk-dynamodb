// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.ExecuteTransactionInput;
import java.util.Objects;

public class ExecuteTransactionInputTransformInput {
  private final ExecuteTransactionInput sdkInput;

  protected ExecuteTransactionInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public ExecuteTransactionInput sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(ExecuteTransactionInput sdkInput);

    ExecuteTransactionInput sdkInput();

    ExecuteTransactionInputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected ExecuteTransactionInput sdkInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(ExecuteTransactionInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(ExecuteTransactionInput sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public ExecuteTransactionInput sdkInput() {
      return this.sdkInput;
    }

    public ExecuteTransactionInputTransformInput build() {
      if (Objects.isNull(this.sdkInput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkInput`");
      }
      return new ExecuteTransactionInputTransformInput(this);
    }
  }
}
