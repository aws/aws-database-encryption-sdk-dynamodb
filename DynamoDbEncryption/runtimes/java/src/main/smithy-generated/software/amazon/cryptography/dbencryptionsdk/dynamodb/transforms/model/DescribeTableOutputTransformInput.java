// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.DescribeTableRequest;
import software.amazon.awssdk.services.dynamodb.model.DescribeTableResponse;

public class DescribeTableOutputTransformInput {
  private final DescribeTableResponse sdkOutput;

  private final DescribeTableRequest originalInput;

  protected DescribeTableOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public DescribeTableResponse sdkOutput() {
    return this.sdkOutput;
  }

  public DescribeTableRequest originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(DescribeTableResponse sdkOutput);

    DescribeTableResponse sdkOutput();

    Builder originalInput(DescribeTableRequest originalInput);

    DescribeTableRequest originalInput();

    DescribeTableOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected DescribeTableResponse sdkOutput;

    protected DescribeTableRequest originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(DescribeTableOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(DescribeTableResponse sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public DescribeTableResponse sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(DescribeTableRequest originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public DescribeTableRequest originalInput() {
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
