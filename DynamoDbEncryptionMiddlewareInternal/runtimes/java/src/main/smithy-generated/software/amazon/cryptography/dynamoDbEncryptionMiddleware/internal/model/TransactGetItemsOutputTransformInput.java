// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model;

// TODO manually updated the below DDB import to point to the right place
// TODO manually updated native type name, i.e. Input->Request Output->Result
import com.amazonaws.services.dynamodbv2.model.TransactGetItemsRequest;
import com.amazonaws.services.dynamodbv2.model.TransactGetItemsResult;
import java.util.Objects;

public class TransactGetItemsOutputTransformInput {
  private final TransactGetItemsResult sdkOutput;

  private final TransactGetItemsRequest originalInput;

  protected TransactGetItemsOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public TransactGetItemsResult sdkOutput() {
    return this.sdkOutput;
  }

  public TransactGetItemsRequest originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(TransactGetItemsResult sdkOutput);

    TransactGetItemsResult sdkOutput();

    Builder originalInput(TransactGetItemsRequest originalInput);

    TransactGetItemsRequest originalInput();

    TransactGetItemsOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected TransactGetItemsResult sdkOutput;

    protected TransactGetItemsRequest originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(TransactGetItemsOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(TransactGetItemsResult sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public TransactGetItemsResult sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(TransactGetItemsRequest originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public TransactGetItemsRequest originalInput() {
      return this.originalInput;
    }

    public TransactGetItemsOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkOutput`");
      }
      if (Objects.isNull(this.originalInput()))  {
        throw new IllegalArgumentException("Missing value for required field `originalInput`");
      }
      return new TransactGetItemsOutputTransformInput(this);
    }
  }
}
