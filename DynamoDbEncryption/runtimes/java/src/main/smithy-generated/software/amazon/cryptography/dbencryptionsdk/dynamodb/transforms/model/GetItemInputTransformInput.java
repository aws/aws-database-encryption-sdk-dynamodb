// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;

public class GetItemInputTransformInput {

  private final GetItemRequest sdkInput;

  protected GetItemInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public GetItemRequest sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(GetItemRequest sdkInput);

    GetItemRequest sdkInput();

    GetItemInputTransformInput build();
  }

  static class BuilderImpl implements Builder {

    protected GetItemRequest sdkInput;

    protected BuilderImpl() {}

    protected BuilderImpl(GetItemInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(GetItemRequest sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public GetItemRequest sdkInput() {
      return this.sdkInput;
    }

    public GetItemInputTransformInput build() {
      if (Objects.isNull(this.sdkInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `sdkInput`"
        );
      }
      return new GetItemInputTransformInput(this);
    }
  }
}
