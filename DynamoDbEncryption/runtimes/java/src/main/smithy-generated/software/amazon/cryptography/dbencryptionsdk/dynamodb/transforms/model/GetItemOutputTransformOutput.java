// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;

public class GetItemOutputTransformOutput {

  private final GetItemResponse transformedOutput;

  protected GetItemOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public GetItemResponse transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(GetItemResponse transformedOutput);

    GetItemResponse transformedOutput();

    GetItemOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {

    protected GetItemResponse transformedOutput;

    protected BuilderImpl() {}

    protected BuilderImpl(GetItemOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(GetItemResponse transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public GetItemResponse transformedOutput() {
      return this.transformedOutput;
    }

    public GetItemOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedOutput`"
        );
      }
      return new GetItemOutputTransformOutput(this);
    }
  }
}
