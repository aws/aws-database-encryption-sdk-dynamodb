// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.GetItemInput;
import java.util.Objects;

public class GetItemInputTransformOutput {
  private final GetItemInput transformedInput;

  protected GetItemInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  public GetItemInput transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedInput(GetItemInput transformedInput);

    GetItemInput transformedInput();

    GetItemInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected GetItemInput transformedInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(GetItemInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(GetItemInput transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public GetItemInput transformedInput() {
      return this.transformedInput;
    }

    public GetItemInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedInput`");
      }
      return new GetItemInputTransformOutput(this);
    }
  }
}
