// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;

public class GetItemInputTransformOutput {

  private final GetItemRequest transformedInput;

  protected GetItemInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  public GetItemRequest transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedInput(GetItemRequest transformedInput);

    GetItemRequest transformedInput();

    GetItemInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {

    protected GetItemRequest transformedInput;

    protected BuilderImpl() {}

    protected BuilderImpl(GetItemInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(GetItemRequest transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public GetItemRequest transformedInput() {
      return this.transformedInput;
    }

    public GetItemInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedInput`"
        );
      }
      return new GetItemInputTransformOutput(this);
    }
  }
}
