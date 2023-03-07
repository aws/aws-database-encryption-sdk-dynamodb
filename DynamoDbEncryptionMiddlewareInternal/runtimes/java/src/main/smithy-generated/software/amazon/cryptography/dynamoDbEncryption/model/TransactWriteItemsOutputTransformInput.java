// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.TransactWriteItemsInput;
import com.amazonaws.dynamodb.model.TransactWriteItemsOutput;
import java.util.Objects;

public class TransactWriteItemsOutputTransformInput {
  private final TransactWriteItemsOutput sdkOutput;

  private final TransactWriteItemsInput originalInput;

  protected TransactWriteItemsOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public TransactWriteItemsOutput sdkOutput() {
    return this.sdkOutput;
  }

  public TransactWriteItemsInput originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(TransactWriteItemsOutput sdkOutput);

    TransactWriteItemsOutput sdkOutput();

    Builder originalInput(TransactWriteItemsInput originalInput);

    TransactWriteItemsInput originalInput();

    TransactWriteItemsOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected TransactWriteItemsOutput sdkOutput;

    protected TransactWriteItemsInput originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(TransactWriteItemsOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(TransactWriteItemsOutput sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public TransactWriteItemsOutput sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(TransactWriteItemsInput originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public TransactWriteItemsInput originalInput() {
      return this.originalInput;
    }

    public TransactWriteItemsOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkOutput`");
      }
      if (Objects.isNull(this.originalInput()))  {
        throw new IllegalArgumentException("Missing value for required field `originalInput`");
      }
      return new TransactWriteItemsOutputTransformInput(this);
    }
  }
}
