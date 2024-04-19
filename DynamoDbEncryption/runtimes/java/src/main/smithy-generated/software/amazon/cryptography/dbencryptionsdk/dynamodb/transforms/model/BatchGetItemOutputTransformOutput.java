// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemResponse;

public class BatchGetItemOutputTransformOutput {

  private final BatchGetItemResponse transformedOutput;

  protected BatchGetItemOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public BatchGetItemResponse transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(BatchGetItemResponse transformedOutput);

    BatchGetItemResponse transformedOutput();

    BatchGetItemOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {

    protected BatchGetItemResponse transformedOutput;

    protected BuilderImpl() {}

    protected BuilderImpl(BatchGetItemOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(BatchGetItemResponse transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public BatchGetItemResponse transformedOutput() {
      return this.transformedOutput;
    }

    public BatchGetItemOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedOutput`"
        );
      }
      return new BatchGetItemOutputTransformOutput(this);
    }
  }
}
