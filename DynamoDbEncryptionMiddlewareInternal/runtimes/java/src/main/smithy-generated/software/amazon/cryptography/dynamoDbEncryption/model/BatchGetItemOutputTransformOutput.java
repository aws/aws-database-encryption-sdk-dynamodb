// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.BatchGetItemOutput;
import java.util.Objects;

public class BatchGetItemOutputTransformOutput {
  private final BatchGetItemOutput transformedOutput;

  protected BatchGetItemOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public BatchGetItemOutput transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(BatchGetItemOutput transformedOutput);

    BatchGetItemOutput transformedOutput();

    BatchGetItemOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected BatchGetItemOutput transformedOutput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(BatchGetItemOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(BatchGetItemOutput transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public BatchGetItemOutput transformedOutput() {
      return this.transformedOutput;
    }

    public BatchGetItemOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedOutput`");
      }
      return new BatchGetItemOutputTransformOutput(this);
    }
  }
}
