// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model;

// TODO manually updated the below DDB import to point to the right place
// TODO manually updated native type name, i.e. Input->Request Output->Result
import com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest;
import com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult;
import java.util.Objects;

public class BatchWriteItemOutputTransformInput {
  private final BatchWriteItemResult sdkOutput;

  private final BatchWriteItemRequest originalInput;

  protected BatchWriteItemOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public BatchWriteItemResult sdkOutput() {
    return this.sdkOutput;
  }

  public BatchWriteItemRequest originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(BatchWriteItemResult sdkOutput);

    BatchWriteItemResult sdkOutput();

    Builder originalInput(BatchWriteItemRequest originalInput);

    BatchWriteItemRequest originalInput();

    BatchWriteItemOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected BatchWriteItemResult sdkOutput;

    protected BatchWriteItemRequest originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(BatchWriteItemOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(BatchWriteItemResult sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public BatchWriteItemResult sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(BatchWriteItemRequest originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public BatchWriteItemRequest originalInput() {
      return this.originalInput;
    }

    public BatchWriteItemOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkOutput`");
      }
      if (Objects.isNull(this.originalInput()))  {
        throw new IllegalArgumentException("Missing value for required field `originalInput`");
      }
      return new BatchWriteItemOutputTransformInput(this);
    }
  }
}
