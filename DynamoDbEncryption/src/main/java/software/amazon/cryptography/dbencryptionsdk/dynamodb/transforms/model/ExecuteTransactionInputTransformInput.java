// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.ExecuteTransactionRequest;

public class ExecuteTransactionInputTransformInput {

  private final ExecuteTransactionRequest sdkInput;

  protected ExecuteTransactionInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public ExecuteTransactionRequest sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(ExecuteTransactionRequest sdkInput);

    ExecuteTransactionRequest sdkInput();

    ExecuteTransactionInputTransformInput build();
  }

  static class BuilderImpl implements Builder {

    protected ExecuteTransactionRequest sdkInput;

    protected BuilderImpl() {}

    protected BuilderImpl(ExecuteTransactionInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(ExecuteTransactionRequest sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public ExecuteTransactionRequest sdkInput() {
      return this.sdkInput;
    }

    public ExecuteTransactionInputTransformInput build() {
      if (Objects.isNull(this.sdkInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `sdkInput`"
        );
      }
      return new ExecuteTransactionInputTransformInput(this);
    }
  }
}
