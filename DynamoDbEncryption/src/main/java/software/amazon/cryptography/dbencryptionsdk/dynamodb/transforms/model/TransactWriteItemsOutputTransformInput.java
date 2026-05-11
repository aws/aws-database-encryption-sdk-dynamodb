// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.TransactWriteItemsRequest;
import software.amazon.awssdk.services.dynamodb.model.TransactWriteItemsResponse;

public class TransactWriteItemsOutputTransformInput {

  private final TransactWriteItemsResponse sdkOutput;

  private final TransactWriteItemsRequest originalInput;

  protected TransactWriteItemsOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public TransactWriteItemsResponse sdkOutput() {
    return this.sdkOutput;
  }

  public TransactWriteItemsRequest originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(TransactWriteItemsResponse sdkOutput);

    TransactWriteItemsResponse sdkOutput();

    Builder originalInput(TransactWriteItemsRequest originalInput);

    TransactWriteItemsRequest originalInput();

    TransactWriteItemsOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {

    protected TransactWriteItemsResponse sdkOutput;

    protected TransactWriteItemsRequest originalInput;

    protected BuilderImpl() {}

    protected BuilderImpl(TransactWriteItemsOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(TransactWriteItemsResponse sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public TransactWriteItemsResponse sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(TransactWriteItemsRequest originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public TransactWriteItemsRequest originalInput() {
      return this.originalInput;
    }

    public TransactWriteItemsOutputTransformInput build() {
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
      return new TransactWriteItemsOutputTransformInput(this);
    }
  }
}
