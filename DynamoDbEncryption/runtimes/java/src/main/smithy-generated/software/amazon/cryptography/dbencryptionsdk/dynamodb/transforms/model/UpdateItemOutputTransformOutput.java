// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemResponse;

public class UpdateItemOutputTransformOutput {

  private final UpdateItemResponse transformedOutput;

  protected UpdateItemOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public UpdateItemResponse transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(UpdateItemResponse transformedOutput);

    UpdateItemResponse transformedOutput();

    UpdateItemOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {

    protected UpdateItemResponse transformedOutput;

    protected BuilderImpl() {}

    protected BuilderImpl(UpdateItemOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(UpdateItemResponse transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public UpdateItemResponse transformedOutput() {
      return this.transformedOutput;
    }

    public UpdateItemOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedOutput`"
        );
      }
      return new UpdateItemOutputTransformOutput(this);
    }
  }
}
