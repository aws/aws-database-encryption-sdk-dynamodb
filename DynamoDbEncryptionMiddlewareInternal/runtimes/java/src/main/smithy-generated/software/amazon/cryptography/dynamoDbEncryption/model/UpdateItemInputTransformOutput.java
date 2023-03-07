// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.UpdateItemInput;
import java.util.Objects;

public class UpdateItemInputTransformOutput {
  private final UpdateItemInput transformedInput;

  protected UpdateItemInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  public UpdateItemInput transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedInput(UpdateItemInput transformedInput);

    UpdateItemInput transformedInput();

    UpdateItemInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected UpdateItemInput transformedInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(UpdateItemInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(UpdateItemInput transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public UpdateItemInput transformedInput() {
      return this.transformedInput;
    }

    public UpdateItemInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedInput`");
      }
      return new UpdateItemInputTransformOutput(this);
    }
  }
}
