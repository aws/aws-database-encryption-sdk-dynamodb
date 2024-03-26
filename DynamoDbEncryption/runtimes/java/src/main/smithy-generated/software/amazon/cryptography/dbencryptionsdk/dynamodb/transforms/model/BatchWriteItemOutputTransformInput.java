// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemResponse;

public class BatchWriteItemOutputTransformInput {

  private final BatchWriteItemResponse sdkOutput;

  private final BatchWriteItemRequest originalInput;

  protected BatchWriteItemOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public BatchWriteItemResponse sdkOutput() {
    return this.sdkOutput;
  }

  public BatchWriteItemRequest originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(BatchWriteItemResponse sdkOutput);

    BatchWriteItemResponse sdkOutput();

    Builder originalInput(BatchWriteItemRequest originalInput);

    BatchWriteItemRequest originalInput();

    BatchWriteItemOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {

    protected BatchWriteItemResponse sdkOutput;

    protected BatchWriteItemRequest originalInput;

    protected BuilderImpl() {}

    protected BuilderImpl(BatchWriteItemOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(BatchWriteItemResponse sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public BatchWriteItemResponse sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(BatchWriteItemRequest originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public BatchWriteItemRequest originalInput() {
      return this.originalInput;
    }

    public BatchWriteItemOutputTransformInput build() {
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
      return new BatchWriteItemOutputTransformInput(this);
    }
  }
}
