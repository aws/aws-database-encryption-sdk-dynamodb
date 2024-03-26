// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.TransactGetItemsRequest;

public class TransactGetItemsInputTransformInput {

  private final TransactGetItemsRequest sdkInput;

  protected TransactGetItemsInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public TransactGetItemsRequest sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(TransactGetItemsRequest sdkInput);

    TransactGetItemsRequest sdkInput();

    TransactGetItemsInputTransformInput build();
  }

  static class BuilderImpl implements Builder {

    protected TransactGetItemsRequest sdkInput;

    protected BuilderImpl() {}

    protected BuilderImpl(TransactGetItemsInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(TransactGetItemsRequest sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public TransactGetItemsRequest sdkInput() {
      return this.sdkInput;
    }

    public TransactGetItemsInputTransformInput build() {
      if (Objects.isNull(this.sdkInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `sdkInput`"
        );
      }
      return new TransactGetItemsInputTransformInput(this);
    }
  }
}
