// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.BatchGetItemInput;
import java.util.Objects;

public class BatchGetItemInputTransformOutput {
  private final BatchGetItemInput transformedInput;

  protected BatchGetItemInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  public BatchGetItemInput transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedInput(BatchGetItemInput transformedInput);

    BatchGetItemInput transformedInput();

    BatchGetItemInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected BatchGetItemInput transformedInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(BatchGetItemInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(BatchGetItemInput transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public BatchGetItemInput transformedInput() {
      return this.transformedInput;
    }

    public BatchGetItemInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedInput`");
      }
      return new BatchGetItemInputTransformOutput(this);
    }
  }
}
