// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.BatchWriteItemInput;
import java.util.Objects;

public class BatchWriteItemInputTransformInput {
  private final BatchWriteItemInput sdkInput;

  protected BatchWriteItemInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public BatchWriteItemInput sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(BatchWriteItemInput sdkInput);

    BatchWriteItemInput sdkInput();

    BatchWriteItemInputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected BatchWriteItemInput sdkInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(BatchWriteItemInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(BatchWriteItemInput sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public BatchWriteItemInput sdkInput() {
      return this.sdkInput;
    }

    public BatchWriteItemInputTransformInput build() {
      if (Objects.isNull(this.sdkInput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkInput`");
      }
      return new BatchWriteItemInputTransformInput(this);
    }
  }
}
