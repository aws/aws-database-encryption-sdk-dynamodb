// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.DeleteItemInput;
import java.util.Objects;

public class DeleteItemInputTransformOutput {
  private final DeleteItemInput transformedInput;

  protected DeleteItemInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  public DeleteItemInput transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedInput(DeleteItemInput transformedInput);

    DeleteItemInput transformedInput();

    DeleteItemInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected DeleteItemInput transformedInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(DeleteItemInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(DeleteItemInput transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public DeleteItemInput transformedInput() {
      return this.transformedInput;
    }

    public DeleteItemInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedInput`");
      }
      return new DeleteItemInputTransformOutput(this);
    }
  }
}
