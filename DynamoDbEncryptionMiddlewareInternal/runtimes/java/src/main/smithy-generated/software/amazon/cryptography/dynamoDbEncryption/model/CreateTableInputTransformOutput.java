// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.CreateTableInput;
import java.util.Objects;

public class CreateTableInputTransformOutput {
  private final CreateTableInput transformedInput;

  protected CreateTableInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  public CreateTableInput transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedInput(CreateTableInput transformedInput);

    CreateTableInput transformedInput();

    CreateTableInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected CreateTableInput transformedInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(CreateTableInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(CreateTableInput transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public CreateTableInput transformedInput() {
      return this.transformedInput;
    }

    public CreateTableInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedInput`");
      }
      return new CreateTableInputTransformOutput(this);
    }
  }
}
