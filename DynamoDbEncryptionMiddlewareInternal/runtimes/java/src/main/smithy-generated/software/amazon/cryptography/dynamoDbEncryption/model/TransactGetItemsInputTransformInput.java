// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.TransactGetItemsInput;
import java.util.Objects;

public class TransactGetItemsInputTransformInput {
  private final TransactGetItemsInput sdkInput;

  protected TransactGetItemsInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public TransactGetItemsInput sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(TransactGetItemsInput sdkInput);

    TransactGetItemsInput sdkInput();

    TransactGetItemsInputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected TransactGetItemsInput sdkInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(TransactGetItemsInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(TransactGetItemsInput sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public TransactGetItemsInput sdkInput() {
      return this.sdkInput;
    }

    public TransactGetItemsInputTransformInput build() {
      if (Objects.isNull(this.sdkInput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkInput`");
      }
      return new TransactGetItemsInputTransformInput(this);
    }
  }
}
