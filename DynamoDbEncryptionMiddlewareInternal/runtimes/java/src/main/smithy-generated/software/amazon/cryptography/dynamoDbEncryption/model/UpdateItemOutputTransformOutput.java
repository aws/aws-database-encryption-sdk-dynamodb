// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.UpdateItemOutput;
import java.util.Objects;

public class UpdateItemOutputTransformOutput {
  private final UpdateItemOutput transformedOutput;

  protected UpdateItemOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public UpdateItemOutput transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(UpdateItemOutput transformedOutput);

    UpdateItemOutput transformedOutput();

    UpdateItemOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected UpdateItemOutput transformedOutput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(UpdateItemOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(UpdateItemOutput transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public UpdateItemOutput transformedOutput() {
      return this.transformedOutput;
    }

    public UpdateItemOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedOutput`");
      }
      return new UpdateItemOutputTransformOutput(this);
    }
  }
}
