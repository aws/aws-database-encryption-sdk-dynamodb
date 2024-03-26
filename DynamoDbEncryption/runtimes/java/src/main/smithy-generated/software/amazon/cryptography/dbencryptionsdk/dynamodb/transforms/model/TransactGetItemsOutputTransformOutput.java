// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.TransactGetItemsResponse;

public class TransactGetItemsOutputTransformOutput {

  private final TransactGetItemsResponse transformedOutput;

  protected TransactGetItemsOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public TransactGetItemsResponse transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(TransactGetItemsResponse transformedOutput);

    TransactGetItemsResponse transformedOutput();

    TransactGetItemsOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {

    protected TransactGetItemsResponse transformedOutput;

    protected BuilderImpl() {}

    protected BuilderImpl(TransactGetItemsOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(
      TransactGetItemsResponse transformedOutput
    ) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public TransactGetItemsResponse transformedOutput() {
      return this.transformedOutput;
    }

    public TransactGetItemsOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedOutput`"
        );
      }
      return new TransactGetItemsOutputTransformOutput(this);
    }
  }
}
