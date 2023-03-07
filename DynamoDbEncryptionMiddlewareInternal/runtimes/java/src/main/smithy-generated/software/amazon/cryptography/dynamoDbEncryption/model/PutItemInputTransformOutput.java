// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.PutItemInput;
import java.util.Objects;

public class PutItemInputTransformOutput {
  private final PutItemInput transformedInput;

  protected PutItemInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  public PutItemInput transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedInput(PutItemInput transformedInput);

    PutItemInput transformedInput();

    PutItemInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected PutItemInput transformedInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(PutItemInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(PutItemInput transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public PutItemInput transformedInput() {
      return this.transformedInput;
    }

    public PutItemInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedInput`");
      }
      return new PutItemInputTransformOutput(this);
    }
  }
}
