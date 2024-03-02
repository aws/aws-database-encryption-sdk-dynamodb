// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.ExecuteStatementRequest;

public class ExecuteStatementInputTransformInput {

  private final ExecuteStatementRequest sdkInput;

  protected ExecuteStatementInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public ExecuteStatementRequest sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(ExecuteStatementRequest sdkInput);

    ExecuteStatementRequest sdkInput();

    ExecuteStatementInputTransformInput build();
  }

  static class BuilderImpl implements Builder {

    protected ExecuteStatementRequest sdkInput;

    protected BuilderImpl() {}

    protected BuilderImpl(ExecuteStatementInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(ExecuteStatementRequest sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public ExecuteStatementRequest sdkInput() {
      return this.sdkInput;
    }

    public ExecuteStatementInputTransformInput build() {
      if (Objects.isNull(this.sdkInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `sdkInput`"
        );
      }
      return new ExecuteStatementInputTransformInput(this);
    }
  }
}
