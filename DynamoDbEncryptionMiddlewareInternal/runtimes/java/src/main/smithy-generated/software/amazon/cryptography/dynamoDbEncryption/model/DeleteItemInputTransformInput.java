// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.DeleteItemInput;
import java.util.Objects;

public class DeleteItemInputTransformInput {
  private final DeleteItemInput sdkInput;

  protected DeleteItemInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public DeleteItemInput sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(DeleteItemInput sdkInput);

    DeleteItemInput sdkInput();

    DeleteItemInputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected DeleteItemInput sdkInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(DeleteItemInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(DeleteItemInput sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public DeleteItemInput sdkInput() {
      return this.sdkInput;
    }

    public DeleteItemInputTransformInput build() {
      if (Objects.isNull(this.sdkInput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkInput`");
      }
      return new DeleteItemInputTransformInput(this);
    }
  }
}
