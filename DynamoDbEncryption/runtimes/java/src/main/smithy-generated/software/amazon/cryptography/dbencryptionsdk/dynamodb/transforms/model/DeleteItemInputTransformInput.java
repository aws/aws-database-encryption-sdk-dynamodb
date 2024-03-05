// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;

public class DeleteItemInputTransformInput {

  private final DeleteItemRequest sdkInput;

  protected DeleteItemInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public DeleteItemRequest sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(DeleteItemRequest sdkInput);

    DeleteItemRequest sdkInput();

    DeleteItemInputTransformInput build();
  }

  static class BuilderImpl implements Builder {

    protected DeleteItemRequest sdkInput;

    protected BuilderImpl() {}

    protected BuilderImpl(DeleteItemInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(DeleteItemRequest sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public DeleteItemRequest sdkInput() {
      return this.sdkInput;
    }

    public DeleteItemInputTransformInput build() {
      if (Objects.isNull(this.sdkInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `sdkInput`"
        );
      }
      return new DeleteItemInputTransformInput(this);
    }
  }
}
