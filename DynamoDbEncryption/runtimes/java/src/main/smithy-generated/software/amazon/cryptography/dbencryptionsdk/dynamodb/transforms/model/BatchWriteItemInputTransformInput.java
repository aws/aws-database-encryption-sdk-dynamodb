// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemRequest;

public class BatchWriteItemInputTransformInput {

  private final BatchWriteItemRequest sdkInput;

  protected BatchWriteItemInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public BatchWriteItemRequest sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(BatchWriteItemRequest sdkInput);

    BatchWriteItemRequest sdkInput();

    BatchWriteItemInputTransformInput build();
  }

  static class BuilderImpl implements Builder {

    protected BatchWriteItemRequest sdkInput;

    protected BuilderImpl() {}

    protected BuilderImpl(BatchWriteItemInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(BatchWriteItemRequest sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public BatchWriteItemRequest sdkInput() {
      return this.sdkInput;
    }

    public BatchWriteItemInputTransformInput build() {
      if (Objects.isNull(this.sdkInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `sdkInput`"
        );
      }
      return new BatchWriteItemInputTransformInput(this);
    }
  }
}
