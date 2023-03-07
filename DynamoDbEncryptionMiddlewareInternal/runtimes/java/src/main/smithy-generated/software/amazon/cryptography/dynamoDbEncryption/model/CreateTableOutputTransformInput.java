// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.CreateTableInput;
import com.amazonaws.dynamodb.model.CreateTableOutput;
import java.util.Objects;

public class CreateTableOutputTransformInput {
  private final CreateTableOutput sdkOutput;

  private final CreateTableInput originalInput;

  protected CreateTableOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public CreateTableOutput sdkOutput() {
    return this.sdkOutput;
  }

  public CreateTableInput originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(CreateTableOutput sdkOutput);

    CreateTableOutput sdkOutput();

    Builder originalInput(CreateTableInput originalInput);

    CreateTableInput originalInput();

    CreateTableOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected CreateTableOutput sdkOutput;

    protected CreateTableInput originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(CreateTableOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(CreateTableOutput sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public CreateTableOutput sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(CreateTableInput originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public CreateTableInput originalInput() {
      return this.originalInput;
    }

    public CreateTableOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkOutput`");
      }
      if (Objects.isNull(this.originalInput()))  {
        throw new IllegalArgumentException("Missing value for required field `originalInput`");
      }
      return new CreateTableOutputTransformInput(this);
    }
  }
}
