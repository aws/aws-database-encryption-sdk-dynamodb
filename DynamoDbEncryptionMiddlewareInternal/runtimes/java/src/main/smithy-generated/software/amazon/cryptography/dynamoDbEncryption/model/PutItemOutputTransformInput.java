// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.PutItemInput;
import com.amazonaws.dynamodb.model.PutItemOutput;
import java.util.Objects;

public class PutItemOutputTransformInput {
  private final PutItemOutput sdkOutput;

  private final PutItemInput originalInput;

  protected PutItemOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public PutItemOutput sdkOutput() {
    return this.sdkOutput;
  }

  public PutItemInput originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(PutItemOutput sdkOutput);

    PutItemOutput sdkOutput();

    Builder originalInput(PutItemInput originalInput);

    PutItemInput originalInput();

    PutItemOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected PutItemOutput sdkOutput;

    protected PutItemInput originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(PutItemOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(PutItemOutput sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public PutItemOutput sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(PutItemInput originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public PutItemInput originalInput() {
      return this.originalInput;
    }

    public PutItemOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkOutput`");
      }
      if (Objects.isNull(this.originalInput()))  {
        throw new IllegalArgumentException("Missing value for required field `originalInput`");
      }
      return new PutItemOutputTransformInput(this);
    }
  }
}
