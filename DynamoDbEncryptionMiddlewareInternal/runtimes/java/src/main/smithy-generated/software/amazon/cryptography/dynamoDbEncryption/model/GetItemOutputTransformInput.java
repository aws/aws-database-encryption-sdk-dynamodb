// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.GetItemInput;
import com.amazonaws.dynamodb.model.GetItemOutput;
import java.util.Objects;

public class GetItemOutputTransformInput {
  private final GetItemOutput sdkOutput;

  private final GetItemInput originalInput;

  protected GetItemOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public GetItemOutput sdkOutput() {
    return this.sdkOutput;
  }

  public GetItemInput originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(GetItemOutput sdkOutput);

    GetItemOutput sdkOutput();

    Builder originalInput(GetItemInput originalInput);

    GetItemInput originalInput();

    GetItemOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected GetItemOutput sdkOutput;

    protected GetItemInput originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(GetItemOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(GetItemOutput sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public GetItemOutput sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(GetItemInput originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public GetItemInput originalInput() {
      return this.originalInput;
    }

    public GetItemOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkOutput`");
      }
      if (Objects.isNull(this.originalInput()))  {
        throw new IllegalArgumentException("Missing value for required field `originalInput`");
      }
      return new GetItemOutputTransformInput(this);
    }
  }
}
