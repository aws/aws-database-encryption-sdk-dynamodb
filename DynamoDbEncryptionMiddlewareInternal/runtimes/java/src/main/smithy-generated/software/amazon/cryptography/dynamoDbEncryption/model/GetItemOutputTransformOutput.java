// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.GetItemOutput;
import java.util.Objects;

public class GetItemOutputTransformOutput {
  private final GetItemOutput transformedOutput;

  protected GetItemOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public GetItemOutput transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(GetItemOutput transformedOutput);

    GetItemOutput transformedOutput();

    GetItemOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected GetItemOutput transformedOutput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(GetItemOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(GetItemOutput transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public GetItemOutput transformedOutput() {
      return this.transformedOutput;
    }

    public GetItemOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedOutput`");
      }
      return new GetItemOutputTransformOutput(this);
    }
  }
}
