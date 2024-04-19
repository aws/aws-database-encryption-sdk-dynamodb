// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemResponse;

public class DeleteItemOutputTransformInput {

  private final DeleteItemResponse sdkOutput;

  private final DeleteItemRequest originalInput;

  protected DeleteItemOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public DeleteItemResponse sdkOutput() {
    return this.sdkOutput;
  }

  public DeleteItemRequest originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(DeleteItemResponse sdkOutput);

    DeleteItemResponse sdkOutput();

    Builder originalInput(DeleteItemRequest originalInput);

    DeleteItemRequest originalInput();

    DeleteItemOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {

    protected DeleteItemResponse sdkOutput;

    protected DeleteItemRequest originalInput;

    protected BuilderImpl() {}

    protected BuilderImpl(DeleteItemOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(DeleteItemResponse sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public DeleteItemResponse sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(DeleteItemRequest originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public DeleteItemRequest originalInput() {
      return this.originalInput;
    }

    public DeleteItemOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `sdkOutput`"
        );
      }
      if (Objects.isNull(this.originalInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `originalInput`"
        );
      }
      return new DeleteItemOutputTransformInput(this);
    }
  }
}
