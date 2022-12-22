// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model;

// TODO manually updated the below DDB import to point to the right place
// TODO manually updated native type name, i.e. Input->Request Output->Result
import com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest;
import com.amazonaws.services.dynamodbv2.model.BatchGetItemResult;
import java.util.Objects;

public class BatchGetItemOutputTransformInput {
  private final BatchGetItemResult sdkOutput;

  private final BatchGetItemRequest originalInput;

  protected BatchGetItemOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public BatchGetItemResult sdkOutput() {
    return this.sdkOutput;
  }

  public BatchGetItemRequest originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(BatchGetItemResult sdkOutput);

    BatchGetItemResult sdkOutput();

    Builder originalInput(BatchGetItemRequest originalInput);

    BatchGetItemRequest originalInput();

    BatchGetItemOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected BatchGetItemResult sdkOutput;

    protected BatchGetItemRequest originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(BatchGetItemOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(BatchGetItemResult sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public BatchGetItemResult sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(BatchGetItemRequest originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public BatchGetItemRequest originalInput() {
      return this.originalInput;
    }

    public BatchGetItemOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkOutput`");
      }
      if (Objects.isNull(this.originalInput()))  {
        throw new IllegalArgumentException("Missing value for required field `originalInput`");
      }
      return new BatchGetItemOutputTransformInput(this);
    }
  }
}
