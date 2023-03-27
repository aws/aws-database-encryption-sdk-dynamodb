// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;

public class CreateTableInputTransformOutput {
  private final CreateTableRequest transformedInput;

  protected CreateTableInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  public CreateTableRequest transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedInput(CreateTableRequest transformedInput);

    CreateTableRequest transformedInput();

    CreateTableInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected CreateTableRequest transformedInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(CreateTableInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(CreateTableRequest transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public CreateTableRequest transformedInput() {
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
