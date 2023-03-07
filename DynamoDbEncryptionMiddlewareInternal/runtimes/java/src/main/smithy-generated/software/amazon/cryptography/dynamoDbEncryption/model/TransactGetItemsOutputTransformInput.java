// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.TransactGetItemsInput;
import com.amazonaws.dynamodb.model.TransactGetItemsOutput;
import java.util.Objects;

public class TransactGetItemsOutputTransformInput {
  private final TransactGetItemsOutput sdkOutput;

  private final TransactGetItemsInput originalInput;

  protected TransactGetItemsOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public TransactGetItemsOutput sdkOutput() {
    return this.sdkOutput;
  }

  public TransactGetItemsInput originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(TransactGetItemsOutput sdkOutput);

    TransactGetItemsOutput sdkOutput();

    Builder originalInput(TransactGetItemsInput originalInput);

    TransactGetItemsInput originalInput();

    TransactGetItemsOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected TransactGetItemsOutput sdkOutput;

    protected TransactGetItemsInput originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(TransactGetItemsOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(TransactGetItemsOutput sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public TransactGetItemsOutput sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(TransactGetItemsInput originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public TransactGetItemsInput originalInput() {
      return this.originalInput;
    }

    public TransactGetItemsOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkOutput`");
      }
      if (Objects.isNull(this.originalInput()))  {
        throw new IllegalArgumentException("Missing value for required field `originalInput`");
      }
      return new TransactGetItemsOutputTransformInput(this);
    }
  }
}
