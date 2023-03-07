// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.DescribeTableInput;
import com.amazonaws.dynamodb.model.DescribeTableOutput;
import java.util.Objects;

public class DescribeTableOutputTransformInput {
  private final DescribeTableOutput sdkOutput;

  private final DescribeTableInput originalInput;

  protected DescribeTableOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public DescribeTableOutput sdkOutput() {
    return this.sdkOutput;
  }

  public DescribeTableInput originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(DescribeTableOutput sdkOutput);

    DescribeTableOutput sdkOutput();

    Builder originalInput(DescribeTableInput originalInput);

    DescribeTableInput originalInput();

    DescribeTableOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected DescribeTableOutput sdkOutput;

    protected DescribeTableInput originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(DescribeTableOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(DescribeTableOutput sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public DescribeTableOutput sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(DescribeTableInput originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public DescribeTableInput originalInput() {
      return this.originalInput;
    }

    public DescribeTableOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkOutput`");
      }
      if (Objects.isNull(this.originalInput()))  {
        throw new IllegalArgumentException("Missing value for required field `originalInput`");
      }
      return new DescribeTableOutputTransformInput(this);
    }
  }
}
