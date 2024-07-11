// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemRequest;

public class BatchWriteItemInputTransformOutput {

  /**
   * <p>Represents the input of a <code>BatchWriteItem</code> operation.</p>
   */
  private final BatchWriteItemRequest transformedInput;

  protected BatchWriteItemInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  /**
   * @return <p>Represents the input of a <code>BatchWriteItem</code> operation.</p>
   */
  public BatchWriteItemRequest transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param transformedInput <p>Represents the input of a <code>BatchWriteItem</code> operation.</p>
     */
    Builder transformedInput(BatchWriteItemRequest transformedInput);

    /**
     * @return <p>Represents the input of a <code>BatchWriteItem</code> operation.</p>
     */
    BatchWriteItemRequest transformedInput();

    BatchWriteItemInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {

    protected BatchWriteItemRequest transformedInput;

    protected BuilderImpl() {}

    protected BuilderImpl(BatchWriteItemInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(BatchWriteItemRequest transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public BatchWriteItemRequest transformedInput() {
      return this.transformedInput;
    }

    public BatchWriteItemInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedInput`"
        );
      }
      return new BatchWriteItemInputTransformOutput(this);
    }
  }
}
