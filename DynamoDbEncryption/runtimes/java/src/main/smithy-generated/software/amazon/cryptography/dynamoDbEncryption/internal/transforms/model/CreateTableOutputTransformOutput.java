// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.CreateTableResponse;

public class CreateTableOutputTransformOutput {
  private final CreateTableResponse transformedOutput;

  protected CreateTableOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public CreateTableResponse transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(CreateTableResponse transformedOutput);

    CreateTableResponse transformedOutput();

    CreateTableOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected CreateTableResponse transformedOutput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(CreateTableOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(CreateTableResponse transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public CreateTableResponse transformedOutput() {
      return this.transformedOutput;
    }

    public CreateTableOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedOutput`");
      }
      return new CreateTableOutputTransformOutput(this);
    }
  }
}
