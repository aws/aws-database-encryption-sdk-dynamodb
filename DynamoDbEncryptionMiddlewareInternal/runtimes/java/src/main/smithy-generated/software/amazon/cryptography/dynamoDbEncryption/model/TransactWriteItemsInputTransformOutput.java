// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.TransactWriteItemsInput;
import java.util.Objects;

public class TransactWriteItemsInputTransformOutput {
  private final TransactWriteItemsInput transformedInput;

  protected TransactWriteItemsInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  public TransactWriteItemsInput transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedInput(TransactWriteItemsInput transformedInput);

    TransactWriteItemsInput transformedInput();

    TransactWriteItemsInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected TransactWriteItemsInput transformedInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(TransactWriteItemsInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(TransactWriteItemsInput transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public TransactWriteItemsInput transformedInput() {
      return this.transformedInput;
    }

    public TransactWriteItemsInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedInput`");
      }
      return new TransactWriteItemsInputTransformOutput(this);
    }
  }
}
