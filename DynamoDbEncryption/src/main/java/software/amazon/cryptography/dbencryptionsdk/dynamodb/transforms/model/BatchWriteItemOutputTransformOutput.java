// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemResponse;

public class BatchWriteItemOutputTransformOutput {

  /**
   * <p>Represents the output of a <code>BatchWriteItem</code> operation.</p>
   */
  private final BatchWriteItemResponse transformedOutput;

  protected BatchWriteItemOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  /**
   * @return <p>Represents the output of a <code>BatchWriteItem</code> operation.</p>
   */
  public BatchWriteItemResponse transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param transformedOutput <p>Represents the output of a <code>BatchWriteItem</code> operation.</p>
     */
    Builder transformedOutput(BatchWriteItemResponse transformedOutput);

    /**
     * @return <p>Represents the output of a <code>BatchWriteItem</code> operation.</p>
     */
    BatchWriteItemResponse transformedOutput();

    BatchWriteItemOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {

    protected BatchWriteItemResponse transformedOutput;

    protected BuilderImpl() {}

    protected BuilderImpl(BatchWriteItemOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(BatchWriteItemResponse transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public BatchWriteItemResponse transformedOutput() {
      return this.transformedOutput;
    }

    public BatchWriteItemOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedOutput`"
        );
      }
      return new BatchWriteItemOutputTransformOutput(this);
    }
  }
}
