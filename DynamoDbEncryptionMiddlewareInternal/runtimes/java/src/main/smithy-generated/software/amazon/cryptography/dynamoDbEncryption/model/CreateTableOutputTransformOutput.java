// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.CreateTableOutput;
import java.util.Objects;

public class CreateTableOutputTransformOutput {
  private final CreateTableOutput transformedOutput;

  protected CreateTableOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public CreateTableOutput transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(CreateTableOutput transformedOutput);

    CreateTableOutput transformedOutput();

    CreateTableOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected CreateTableOutput transformedOutput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(CreateTableOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(CreateTableOutput transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public CreateTableOutput transformedOutput() {
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
