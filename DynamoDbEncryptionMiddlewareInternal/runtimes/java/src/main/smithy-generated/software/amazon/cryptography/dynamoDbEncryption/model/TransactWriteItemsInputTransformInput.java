// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.TransactWriteItemsInput;
import java.util.Objects;

public class TransactWriteItemsInputTransformInput {
  private final TransactWriteItemsInput sdkInput;

  protected TransactWriteItemsInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public TransactWriteItemsInput sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(TransactWriteItemsInput sdkInput);

    TransactWriteItemsInput sdkInput();

    TransactWriteItemsInputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected TransactWriteItemsInput sdkInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(TransactWriteItemsInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(TransactWriteItemsInput sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public TransactWriteItemsInput sdkInput() {
      return this.sdkInput;
    }

    public TransactWriteItemsInputTransformInput build() {
      if (Objects.isNull(this.sdkInput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkInput`");
      }
      return new TransactWriteItemsInputTransformInput(this);
    }
  }
}
