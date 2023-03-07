// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.BatchWriteItemInput;
import java.util.Objects;

public class BatchWriteItemInputTransformOutput {
  private final BatchWriteItemInput transformedInput;

  protected BatchWriteItemInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  public BatchWriteItemInput transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedInput(BatchWriteItemInput transformedInput);

    BatchWriteItemInput transformedInput();

    BatchWriteItemInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected BatchWriteItemInput transformedInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(BatchWriteItemInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(BatchWriteItemInput transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public BatchWriteItemInput transformedInput() {
      return this.transformedInput;
    }

    public BatchWriteItemInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedInput`");
      }
      return new BatchWriteItemInputTransformOutput(this);
    }
  }
}
