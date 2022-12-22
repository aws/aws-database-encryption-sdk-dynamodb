// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model;

// TODO manually updated the below DDB import to point to the right place
// TODO manually updated native type name, i.e. Input->Request Output->Result
import com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult;
import java.util.Objects;

public class BatchWriteItemOutputTransformOutput {
  private final BatchWriteItemResult transformedOutput;

  protected BatchWriteItemOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public BatchWriteItemResult transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(BatchWriteItemResult transformedOutput);

    BatchWriteItemResult transformedOutput();

    BatchWriteItemOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected BatchWriteItemResult transformedOutput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(BatchWriteItemOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(BatchWriteItemResult transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public BatchWriteItemResult transformedOutput() {
      return this.transformedOutput;
    }

    public BatchWriteItemOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedOutput`");
      }
      return new BatchWriteItemOutputTransformOutput(this);
    }
  }
}
