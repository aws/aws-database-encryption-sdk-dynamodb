// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.DescribeTableResponse;

public class DescribeTableOutputTransformOutput {
  private final DescribeTableResponse transformedOutput;

  protected DescribeTableOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public DescribeTableResponse transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(DescribeTableResponse transformedOutput);

    DescribeTableResponse transformedOutput();

    DescribeTableOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected DescribeTableResponse transformedOutput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(DescribeTableOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(DescribeTableResponse transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public DescribeTableResponse transformedOutput() {
      return this.transformedOutput;
    }

    public DescribeTableOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedOutput`");
      }
      return new DescribeTableOutputTransformOutput(this);
    }
  }
}
