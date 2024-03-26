// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemResponse;

public class DeleteItemOutputTransformOutput {

  private final DeleteItemResponse transformedOutput;

  protected DeleteItemOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public DeleteItemResponse transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(DeleteItemResponse transformedOutput);

    DeleteItemResponse transformedOutput();

    DeleteItemOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {

    protected DeleteItemResponse transformedOutput;

    protected BuilderImpl() {}

    protected BuilderImpl(DeleteItemOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(DeleteItemResponse transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public DeleteItemResponse transformedOutput() {
      return this.transformedOutput;
    }

    public DeleteItemOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedOutput`"
        );
      }
      return new DeleteItemOutputTransformOutput(this);
    }
  }
}
