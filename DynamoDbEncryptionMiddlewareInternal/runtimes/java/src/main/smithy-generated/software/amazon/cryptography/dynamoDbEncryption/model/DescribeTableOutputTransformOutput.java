// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.DescribeTableOutput;
import java.util.Objects;

public class DescribeTableOutputTransformOutput {
  private final DescribeTableOutput transformedOutput;

  protected DescribeTableOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public DescribeTableOutput transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(DescribeTableOutput transformedOutput);

    DescribeTableOutput transformedOutput();

    DescribeTableOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected DescribeTableOutput transformedOutput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(DescribeTableOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(DescribeTableOutput transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public DescribeTableOutput transformedOutput() {
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
