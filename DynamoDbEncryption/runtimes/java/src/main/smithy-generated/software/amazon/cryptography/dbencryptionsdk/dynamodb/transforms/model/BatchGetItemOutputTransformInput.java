// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemResponse;

public class BatchGetItemOutputTransformInput {

  /**
   * <p>Represents the output of a <code>BatchGetItem</code> operation.</p>
   */
  private final BatchGetItemResponse sdkOutput;

  /**
   * <p>Represents the input of a <code>BatchGetItem</code> operation.</p>
   */
  private final BatchGetItemRequest originalInput;

  protected BatchGetItemOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  /**
   * @return <p>Represents the output of a <code>BatchGetItem</code> operation.</p>
   */
  public BatchGetItemResponse sdkOutput() {
    return this.sdkOutput;
  }

  /**
   * @return <p>Represents the input of a <code>BatchGetItem</code> operation.</p>
   */
  public BatchGetItemRequest originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param sdkOutput <p>Represents the output of a <code>BatchGetItem</code> operation.</p>
     */
    Builder sdkOutput(BatchGetItemResponse sdkOutput);

    /**
     * @return <p>Represents the output of a <code>BatchGetItem</code> operation.</p>
     */
    BatchGetItemResponse sdkOutput();

    /**
     * @param originalInput <p>Represents the input of a <code>BatchGetItem</code> operation.</p>
     */
    Builder originalInput(BatchGetItemRequest originalInput);

    /**
     * @return <p>Represents the input of a <code>BatchGetItem</code> operation.</p>
     */
    BatchGetItemRequest originalInput();

    BatchGetItemOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {

    protected BatchGetItemResponse sdkOutput;

    protected BatchGetItemRequest originalInput;

    protected BuilderImpl() {}

    protected BuilderImpl(BatchGetItemOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(BatchGetItemResponse sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public BatchGetItemResponse sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(BatchGetItemRequest originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public BatchGetItemRequest originalInput() {
      return this.originalInput;
    }

    public BatchGetItemOutputTransformInput build() {
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
      return new BatchGetItemOutputTransformInput(this);
    }
  }
}
