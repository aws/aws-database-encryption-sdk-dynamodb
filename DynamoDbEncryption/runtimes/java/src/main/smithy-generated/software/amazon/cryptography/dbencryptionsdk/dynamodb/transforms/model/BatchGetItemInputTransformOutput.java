// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemRequest;

public class BatchGetItemInputTransformOutput {

  private final BatchGetItemRequest transformedInput;

  protected BatchGetItemInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  public BatchGetItemRequest transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedInput(BatchGetItemRequest transformedInput);

    BatchGetItemRequest transformedInput();

    BatchGetItemInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {

    protected BatchGetItemRequest transformedInput;

    protected BuilderImpl() {}

    protected BuilderImpl(BatchGetItemInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(BatchGetItemRequest transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public BatchGetItemRequest transformedInput() {
      return this.transformedInput;
    }

    public BatchGetItemInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedInput`"
        );
      }
      return new BatchGetItemInputTransformOutput(this);
    }
  }
}
