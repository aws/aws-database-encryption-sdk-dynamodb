// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model;

// TODO manually updated the below DDB import to point to the right place
// TODO manually updated native type name, i.e. Input->Request Output->Response
import software.amazon.awssdk.services.dynamodb.model.TransactWriteItemsResponse;
import java.util.Objects;

public class TransactWriteItemsOutputTransformOutput {
  private final TransactWriteItemsResponse transformedOutput;

  protected TransactWriteItemsOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public TransactWriteItemsResponse transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(TransactWriteItemsResponse transformedOutput);

    TransactWriteItemsResponse transformedOutput();

    TransactWriteItemsOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected TransactWriteItemsResponse transformedOutput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(TransactWriteItemsOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(TransactWriteItemsResponse transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public TransactWriteItemsResponse transformedOutput() {
      return this.transformedOutput;
    }

    public TransactWriteItemsOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedOutput`");
      }
      return new TransactWriteItemsOutputTransformOutput(this);
    }
  }
}
