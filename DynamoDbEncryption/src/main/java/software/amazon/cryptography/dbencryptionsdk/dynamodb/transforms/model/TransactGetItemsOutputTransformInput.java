// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.TransactGetItemsRequest;
import software.amazon.awssdk.services.dynamodb.model.TransactGetItemsResponse;

public class TransactGetItemsOutputTransformInput {

  private final TransactGetItemsResponse sdkOutput;

  private final TransactGetItemsRequest originalInput;

  protected TransactGetItemsOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public TransactGetItemsResponse sdkOutput() {
    return this.sdkOutput;
  }

  public TransactGetItemsRequest originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(TransactGetItemsResponse sdkOutput);

    TransactGetItemsResponse sdkOutput();

    Builder originalInput(TransactGetItemsRequest originalInput);

    TransactGetItemsRequest originalInput();

    TransactGetItemsOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {

    protected TransactGetItemsResponse sdkOutput;

    protected TransactGetItemsRequest originalInput;

    protected BuilderImpl() {}

    protected BuilderImpl(TransactGetItemsOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(TransactGetItemsResponse sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public TransactGetItemsResponse sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(TransactGetItemsRequest originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public TransactGetItemsRequest originalInput() {
      return this.originalInput;
    }

    public TransactGetItemsOutputTransformInput build() {
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
      return new TransactGetItemsOutputTransformInput(this);
    }
  }
}
