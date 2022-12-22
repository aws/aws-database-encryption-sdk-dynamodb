// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model;

// TODO manually updated the below DDB import to point to the right place
// TODO manually updated native type name, i.e. Input->Request Output->Result
import com.amazonaws.services.dynamodbv2.model.TransactWriteItemsRequest;
import com.amazonaws.services.dynamodbv2.model.TransactWriteItemsResult;
import java.util.Objects;

public class TransactWriteItemsOutputTransformInput {
  private final TransactWriteItemsResult sdkOutput;

  private final TransactWriteItemsRequest originalInput;

  protected TransactWriteItemsOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public TransactWriteItemsResult sdkOutput() {
    return this.sdkOutput;
  }

  public TransactWriteItemsRequest originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(TransactWriteItemsResult sdkOutput);

    TransactWriteItemsResult sdkOutput();

    Builder originalInput(TransactWriteItemsRequest originalInput);

    TransactWriteItemsRequest originalInput();

    TransactWriteItemsOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected TransactWriteItemsResult sdkOutput;

    protected TransactWriteItemsRequest originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(TransactWriteItemsOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(TransactWriteItemsResult sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public TransactWriteItemsResult sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(TransactWriteItemsRequest originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public TransactWriteItemsRequest originalInput() {
      return this.originalInput;
    }

    public TransactWriteItemsOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkOutput`");
      }
      if (Objects.isNull(this.originalInput()))  {
        throw new IllegalArgumentException("Missing value for required field `originalInput`");
      }
      return new TransactWriteItemsOutputTransformInput(this);
    }
  }
}
