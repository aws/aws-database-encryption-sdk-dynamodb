// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model;

// TODO manually updated the below DDB import to point to the right place
// TODO manually updated native type name, i.e. Input->Request Output->Result
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import java.util.Objects;

public class PutItemOutputTransformOutput {
  private final PutItemResult transformedOutput;

  protected PutItemOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public PutItemResult transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(PutItemResult transformedOutput);

    PutItemResult transformedOutput();

    PutItemOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected PutItemResult transformedOutput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(PutItemOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(PutItemResult transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public PutItemResult transformedOutput() {
      return this.transformedOutput;
    }

    public PutItemOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedOutput`");
      }
      return new PutItemOutputTransformOutput(this);
    }
  }
}
