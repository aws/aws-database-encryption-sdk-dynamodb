// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model;

// TODO manually updated the below DDB import to point to the right place
// TODO manually updated native type name, i.e. Input->Request Output->Result
import com.amazonaws.services.dynamodbv2.model.BatchExecuteStatementRequest;
import java.util.Objects;

public class BatchExecuteStatementInputTransformInput {
  private final BatchExecuteStatementRequest sdkInput;

  protected BatchExecuteStatementInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public BatchExecuteStatementRequest sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(BatchExecuteStatementRequest sdkInput);

    BatchExecuteStatementRequest sdkInput();

    BatchExecuteStatementInputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected BatchExecuteStatementRequest sdkInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(BatchExecuteStatementInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(BatchExecuteStatementRequest sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public BatchExecuteStatementRequest sdkInput() {
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
