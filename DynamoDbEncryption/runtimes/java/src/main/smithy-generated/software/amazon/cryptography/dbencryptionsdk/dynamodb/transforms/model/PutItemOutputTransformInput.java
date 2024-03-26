// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;

public class PutItemOutputTransformInput {

  private final PutItemResponse sdkOutput;

  private final PutItemRequest originalInput;

  protected PutItemOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public PutItemResponse sdkOutput() {
    return this.sdkOutput;
  }

  public PutItemRequest originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(PutItemResponse sdkOutput);

    PutItemResponse sdkOutput();

    Builder originalInput(PutItemRequest originalInput);

    PutItemRequest originalInput();

    PutItemOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {

    protected PutItemResponse sdkOutput;

    protected PutItemRequest originalInput;

    protected BuilderImpl() {}

    protected BuilderImpl(PutItemOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(PutItemResponse sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public PutItemResponse sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(PutItemRequest originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public PutItemRequest originalInput() {
      return this.originalInput;
    }

    public PutItemOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `sdkOutput`"
        );
      }
      if (Objects.isNull(this.originalInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `originalInput`"
        );
      }
      return new PutItemOutputTransformInput(this);
    }
  }
}
