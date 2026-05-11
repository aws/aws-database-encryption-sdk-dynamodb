// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.TransactGetItemsRequest;

public class TransactGetItemsInputTransformOutput {

  private final TransactGetItemsRequest transformedInput;

  protected TransactGetItemsInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  public TransactGetItemsRequest transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedInput(TransactGetItemsRequest transformedInput);

    TransactGetItemsRequest transformedInput();

    TransactGetItemsInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {

    protected TransactGetItemsRequest transformedInput;

    protected BuilderImpl() {}

    protected BuilderImpl(TransactGetItemsInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(TransactGetItemsRequest transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public TransactGetItemsRequest transformedInput() {
      return this.transformedInput;
    }

    public TransactGetItemsInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedInput`"
        );
      }
      return new TransactGetItemsInputTransformOutput(this);
    }
  }
}
