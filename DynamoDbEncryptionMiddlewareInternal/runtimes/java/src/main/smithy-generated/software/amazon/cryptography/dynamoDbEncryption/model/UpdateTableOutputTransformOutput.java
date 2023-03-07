// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.UpdateTableOutput;
import java.util.Objects;

public class UpdateTableOutputTransformOutput {
  private final UpdateTableOutput transformedOutput;

  protected UpdateTableOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public UpdateTableOutput transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(UpdateTableOutput transformedOutput);

    UpdateTableOutput transformedOutput();

    UpdateTableOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected UpdateTableOutput transformedOutput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(UpdateTableOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(UpdateTableOutput transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public UpdateTableOutput transformedOutput() {
      return this.transformedOutput;
    }

    public UpdateTableOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedOutput`");
      }
      return new UpdateTableOutputTransformOutput(this);
    }
  }
}
