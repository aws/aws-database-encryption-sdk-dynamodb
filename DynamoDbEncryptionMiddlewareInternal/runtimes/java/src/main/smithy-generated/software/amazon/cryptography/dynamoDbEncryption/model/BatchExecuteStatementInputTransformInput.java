// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.BatchExecuteStatementInput;
import java.util.Objects;

public class BatchExecuteStatementInputTransformInput {
  private final BatchExecuteStatementInput sdkInput;

  protected BatchExecuteStatementInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public BatchExecuteStatementInput sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(BatchExecuteStatementInput sdkInput);

    BatchExecuteStatementInput sdkInput();

    BatchExecuteStatementInputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected BatchExecuteStatementInput sdkInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(BatchExecuteStatementInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(BatchExecuteStatementInput sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public BatchExecuteStatementInput sdkInput() {
      return this.sdkInput;
    }

    public BatchExecuteStatementInputTransformInput build() {
      if (Objects.isNull(this.sdkInput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkInput`");
      }
      return new BatchExecuteStatementInputTransformInput(this);
    }
  }
}
