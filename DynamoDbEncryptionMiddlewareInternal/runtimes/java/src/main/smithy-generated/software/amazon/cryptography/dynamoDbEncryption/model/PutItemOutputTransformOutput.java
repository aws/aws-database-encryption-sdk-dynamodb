// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.PutItemOutput;
import java.util.Objects;

public class PutItemOutputTransformOutput {
  private final PutItemOutput transformedOutput;

  protected PutItemOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public PutItemOutput transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(PutItemOutput transformedOutput);

    PutItemOutput transformedOutput();

    PutItemOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected PutItemOutput transformedOutput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(PutItemOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(PutItemOutput transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public PutItemOutput transformedOutput() {
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
